import React from "react";
import "./Button.css"

export default function Button({ children,disabled,icon,...props }) {
    return <button {...props } disabled={disabled}>
        {children}
        </button>
}