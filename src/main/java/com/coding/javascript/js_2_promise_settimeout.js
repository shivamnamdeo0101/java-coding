function callFun(){
    return new Promise((res,rej)=>{
        let success = true;
        if(success){
            res("Resolve")
        }else{
            rej("Reject")
        }
    })
}

console.log("Start")

callFun()
.then((res)=>{
    console.log(res)
})
.catch((rej)=>{
    console.log(rej)
}).finally(()=>{
    console.log("Finally")
})  

console.log("End")

setTimeout((()=>{
    console.log("Timeout")
}),0)