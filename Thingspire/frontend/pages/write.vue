<template>
    <div>
        <h2>글쓰기</h2>
        <div class="writeForm">
            <span>작성자</span><br>
            <input type="text" v-model="boardWriter" name=""/><br>
            <span>제목</span><br>
            <input type="text" v-model="boardTitle" name=""/><br>
            <span>내용</span><br>
            <textarea type="text" v-model="boardContent"/><br>
        </div>
        <div><button @click="created">등록</button></div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data() {
        return {
                boardWriter: '',
                boardTitle: '',
                boardContent: '',
        }
    },
    methods: {
        async created() {
            await axios.post('http://localhost:3000/board', {
                boardWriter: this.boardWriter,
                boardTitle: this.boardTitle,
                boardContent: this.boardContent
        })
        this.$router.push({path: '/'})
        }
    }
}
</script>
<style scoped>
.writeForm {
    width:300px;
    height:300px;
    margin:0 auto;
}
h2 {
    text-align: center;
}
button {
    float: right
}
input {
    width: 300px
}
textarea {
    width: 300px
}
</style>