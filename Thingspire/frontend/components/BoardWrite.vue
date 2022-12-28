<template>
    <div>
        <div>
            <span>작성자</span>
            <input type="text" v-model="boardWriter" name=""/><br>
            <span>제목</span>
            <input type="text" v-model="boardTitle" name=""/><br>
            <span>내용</span>
            <textarea type="" name=""/><br>
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
        this.$router.push('/')
        }
    }
}
</script>