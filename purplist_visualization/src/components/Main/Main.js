import React,{useState} from "react"
import './Main.css'


export const Main = ()=>{
    return(
        // <div style="height: 300px; width: 300px; background-color: red;">
        //     asd
        // </div>
        <div style={{width: 100+'vw', height: 100 + 'vh', backgroundColor: "#fafafa"}}>
            <div className="top-bar">
                {/*<button icon="fa-solid fa-sidebar">*/}
                {/*</button>*/}
                <span className="top-bar-text">Purplist</span>
                <div className="top-bar-user-icon">
                </div>
            </div>
        </div>
    )
}