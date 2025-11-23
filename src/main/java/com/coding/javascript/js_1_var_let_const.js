/*

----Js is single threaded -> One task at a time
Interpreted -> Code execution line by line
Dynamically typed language -> data type variable decided at the runtime
Event driven -> keystrokes, clicks
used in client side + server side
Objected oriented, platform independent, modify dom, exception handling, async

----Can add JS in 3 ways
JavaScript Code Inside <head> Tag
Internal body JavaScript (Within <script> Tag)
External JavaScript (Using External File)

----Data Types in JavaScript
│
├── Primitive Data Types
│   │
│   ├── Numeric Type
│   │   ├── Number
│   │   └── BigInt
│   │
│   └── Non-Numeric Type
│       ├── String
│       ├── Boolean
│       ├── Null
│       ├── Undefined
│       └── Symbol
│
└── Non-Primitive Data Types
    ├── Object
    ├── Array
    ├── Function
    ├── Date Object
    └── Regular Expression


---Comparison
JavaScript evaluates it left-to-right due to its operator precedence.
console.log(5 > 3 > 2) -> false , first check 5> 3 => true then true > 2 -> false

Compares their Unicode values lexicographically (character by character).
console.log("10" < "9") false => check 1 < 9 -> true


console.log(null === undefined) -> false


console.log([1, 2] == [1, 2]) -> false => check ref not values
console.log("5" === 5) -> false => strict check ref and value
console.log([] === []) -> false => arrays are obj so diff ref



---Type Conversion and Type Coercion
Number("42.9")   // → 42.9
parseInt("42.9") // → 42

parseInt("101", 2)  // → 5  (binary)
parseInt("A", 16)   // → 10 (hex)
Number("101", 2)    // ❌ invalid (Number doesn’t take radix)


*/
//Callback Hell (Nested Callbacks)

function step1(callback) {
    setTimeout(() => {
        console.log("Step 1 completed");
        callback();
    }, 1000);
}

function step2(callback) {
    setTimeout(() => {
        console.log("Step 2 completed");
        callback();
    }, 1000);
}

function step3(callback) {
    setTimeout(() => {
        console.log("Step 3 completed");
        callback();
    }, 1000);
}

step1(() => {
    step2(() => {
        step3(() => {
            console.log("All steps completed");
        });
    });
});

function divide(a, b, callback) {
    if (b === 0) {
        callback(new Error("Cannot divide by zero"), null);
    } else {
        callback(null, a / b);
    }
}

function result(error, result) {
    if (error) {
        console.log("Error:", error.message);
    } else {
        console.log("Result:", result);
    }
}

divide(10, 2, result);
divide(10, 0, result);



function step1() {
    return new Promise(resolve => {
        setTimeout(() => {
            console.log("Step 1 completed");
            resolve();
        }, 1000);
    });
}


function callFun(){
    return new Promise((res,rej)=>{
        res("Resolve")
    })
}



function step2() {
    return new Promise(resolve => {
        setTimeout(() => {
            console.log("Step 2 completed");
            resolve();
        }, 1000);
    });
}

function step3() {
    return new Promise(resolve => {
        setTimeout(() => {
            console.log("Step 3 completed");
            resolve();
        }, 1000);
    });
}

step1()
    .then(step2)
    .then(step3)
    .then(() => console.log("All steps completed"));



async function processSteps() {
    await step1();
    await step2();
    await step3();
    console.log("All steps completed");
}

processSteps();

const getData = async () => {
    let y = await "Hello World";
    console.log(y);
}

console.log(1);
getData();
consoleog(2);