<template>
    <div>
        <div class="writeForm">
            <span>작성자</span><br>
            <input type="text" readonly :value="board.boardWriter">
            <span>제목</span><br>
            <input type="text" name="title" :value="board.boardTitle" 
                    @input="board.boardTitle=$event.target.value"
                    >
            <span>내용</span><br>
            <textarea name="content" :value="board.boardContent"
                        @input="board.boardContent=$event.target.value"
            >
                        <!-- @input="modBoardContent($event)" // 이렇게 쓰려면 밑에 function 필요 -->
            </textarea>
            <span>등록일</span><br>
            <input type="text" readonly :value="board.regDate">
            <span>수정일</span><br>
            <input type="text" readonly :value="board.modDate">
        </div>
        <div class="btn">
            <button class= "btn-1" @click="routeToMod">수정</button>
            <button class= "btn-1" @click="routeToDel">삭제</button>
        </div>
    </div> 
</template>
<script>
import axios from 'axios'
export default {
    data() {
        return {
            boardId: '',
            board: {},
            // boardWriter: '',
            title: '',
            content: '',
            // regDate:'',
            // modDate:'',
        }
    },
    mounted() {
        const boardId = this.$route.query.boardId
        this.boardId = boardId
        this.asyncData()
    }, methods: {
        
        async asyncData () {
            const response = await axios.get(`http://localhost:3000/board/detail?boardId=${this.boardId}`)
            this.board = response.data.data
        },

        async routeToDel() {
            console.log(this.boardId)
            await axios.delete('http://localhost:3000/board',{
                data: {boardId: this.boardId}
            })
            this.$router.push({path: '/'})
        },

        // modBoardTitle(event){
        //     this.board.boardTitle = event.target.value
        //     console.log(this.board.boardTitle)
        //     console.log(event.target.name)
        // },

        // modBoardContent(event){
        //     this.board.boardContent = event.target.value
        //     console.log(this.board.boardContent)
        // },

        async routeToMod(event){
            if(event.target.name === 'title') this.board.boardTitle = event.target.value
            if(event.target.name === 'content') this.board.boardContent = event.target.value

            const params = {
                boardId: this.boardId,
                boardTitle: this.board.boardTitle,
                boardContent: this.board.boardContent,
            }
            console.log(params)
            await axios.patch('http://localhost:3000/board',params
        ).then(res => {console.log(res)})
            this.$router.push({path: '/'})
        },
    },
}
</script>
<style scoped>
.writeForm {
    width:300px;
    height:300px;
    margin:0 auto;
}
/* button {
    font-size: 1rem;
    font-weight: 500;
    background-color: rgb(239, 236, 234);
    position: sticky;
} */
.btn{
	text-align: center;
}
.btn1{
	display :inline-block;
}
input {
    width: 300px
}
textarea {
    width: 300px
}
</style>