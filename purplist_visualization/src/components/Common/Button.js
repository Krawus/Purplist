import React from "react";
import "./Button.css"

function Button({ styleClass, text }) {
    return <button className={styleClass}>
        <span class="button_text">{text}</span>
        </button>
}

export default Button