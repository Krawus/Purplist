import React,{useState} from "react"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faBars} from '@fortawesome/free-solid-svg-icons'
import {faArrowRight,faArrowLeft} from "@fortawesome/free-solid-svg-icons";
import {faNoteSticky,faCalendar} from "@fortawesome/free-regular-svg-icons";
import Button from '../Common/Button/Button.js'
import Menu from "../Common/Menu/Menu";
import './Main.css'


export const Main = ()=>{

    const [isMainMenuOpen,setIsMainMenuOpen] = useState(false);
    const [userShortcut,setUserShortcut] = useState('JM');
    const [isUserModalOpen, setIsUserModalOpen] = useState(false);
    function openLeftMenu(){
        console.log('Sidebar clicked!')
        isMainMenuOpen === true ? setIsMainMenuOpen(false) : setIsMainMenuOpen(true)
    }
    function handlerUserClick(){
        console.log('User menu!')
        isUserModalOpen ? setIsUserModalOpen(true) : setIsUserModalOpen(false);
    }

    return(
        <div className={'main-container'}>
            <Menu show={isUserModalOpen}></Menu>
            <div className="top-bar">
                <div >
                    <Button className={`top-bar-sidebar-icon ${isMainMenuOpen ? 'active' : ''}`} onClick={openLeftMenu}>
                        {
                            isMainMenuOpen && <FontAwesomeIcon icon={faArrowLeft} size="xs" style={{color: '#ffffff', paddingRight: '2px'}}/>
                        }
                        <FontAwesomeIcon icon={faBars} size="xl" style={{color: '#ffffff'}}/>
                    {
                        !isMainMenuOpen && <FontAwesomeIcon icon={faArrowRight} size="xs" style={{color: '#ffffff', paddingLeft:'2px'}}/>
                    }
                    </Button>
                </div>
                <span className="top-bar-text">Purplist</span>
                <div className={'right-menu'}>
                    <div className="user-icon" onClick={handlerUserClick}>
                        {userShortcut}
                    </div>{
                }
                </div>

            </div>
            <div className={`main-sidebar ${isMainMenuOpen ? 'active': '' }`}>
                <ul style={{padding: 0, margin: 0}}>
                    <li className={'main-sidebar-list-item'}>
                        <FontAwesomeIcon icon={faNoteSticky} ></FontAwesomeIcon>
                        Notes
                    </li>
                    <li className={'main-sidebar-list-item'}>
                        <FontAwesomeIcon icon={faCalendar} ></FontAwesomeIcon>
                        Calendar
                    </li>
                </ul>
            </div>
        </div>
    )
}