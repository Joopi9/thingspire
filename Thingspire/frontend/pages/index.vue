<template>
    <div>
         <!-- <h2>목록 페이지</h2> -->
         <div>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>작성자</th>
                        <th>제목</th>
                        <th>등록일</th>
                    </tr>
                </thead>    
                <tbody>
                    <tr @click="routeToDetailPage(board.boardId)" 
                        v-for="board in boardList" 
                        :key="board.boardId"
                    >
                        <td>{{board.boardId}}</td>
                        <td>{{board.boardWriter}}</td>
                        <td>{{board.boardTitle}}</td>
                        <td>{{board.regDate}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div>
        <span :v-bind="paging" >총 {{paging.totalCount}}</span>
        </div>
        <ul v-if="paging.totalCount">
            <!-- <li v-for="page in paging.startPage" :key="page.idx">
                <span v-if="!page.prev">이전</span>
            </li>
            <li v-for="page in paging.endPage" :key="page.idx">
                <span v-if="!page.next" >다음</span>
            </li> -->
        </ul>
        <div class="write-wrapper"><button class="writeBtn" @click="routeToWritePage">글쓰기</button></div>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            boardId: this.boardId,
        }
    },
    async asyncData() {
        const response = await axios.get('http://localhost:3000/board/list')
        console.log(response)
        const boardList = response.data.data.boardList
        const paging = response.data.data.paging
        console.log(paging)
        return { boardList, paging }
    },
    methods:{
      routeToWritePage() {
        this.$router.push('/write')
      },
      routeToDetailPage(boardId) {
        this.$router.push({name: 'detail', query:{ boardId: boardId}})
      }
    }
}
</script>
<style scoped>
table {
    margin-left:auto; 
    margin-right:auto;
    width:1000px;
    height:100px;
}
table, td, th {
    border-collapse : collapse;
    border : 1px solid gray;
}
h2 {
    padding: 30px;
    text-align: center;
}
.write-wrapper {
  position: sticky;
  float: right;
  bottom:50px;
  right: 50px;
}
.write-wrapper .writeBtn{
    display: inline-block;
    height: 40px;
    font-size: 1rem;
    font-weight: 500;
    background-color: rgb(239, 236, 234);
}
</style>