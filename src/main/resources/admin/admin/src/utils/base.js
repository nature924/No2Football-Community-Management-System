const base = {
    get() {
        return {
            url : "http://localhost:8080/zuqiushequguanlixitong/",
            name: "zuqiushequguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zuqiushequguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "足球社区管理系统"
        } 
    }
}
export default base
