import "./App.css"
import {useState} from "react";
import {dictionary} from "./dictionary.ts";

export default function App() {

    const [outputText, setOutputText] = useState("")

    function convertText(inputText: string) {
        dictionary.forEach((value, key) => {
            inputText = inputText.replaceAll(key, value)
        })
        setOutputText(inputText)
    }

    return (
        <div className="container">
            <textarea className="inputField" onChange={(event) => convertText(event.target.value)}/>
            <div className="spacer"/>
            <textarea className="inputField" value={outputText}/>
        </div>
    )
}