import {ReactComponent as GithubIcon} from '../../assets/img/github.svg';
import './styles.css'

function Navbar(){
    return(
        <header>
    <nav className="container">
        <div className="dsmovie-nav-content">
            <a href='/'> <h1>   GomesMovie</h1> </a>
            <a href="https://github.com/gomesmauricio" target="_blank" rel="noreferrer">
                <div className="dsmovie-contact-container">
                    <GithubIcon />
                    <p className="dsmovie-contact-link">/gomesmauricio</p>
                </div>
            </a>
        </div>
    </nav>
</header>
    );
}

export default Navbar;