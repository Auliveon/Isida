fetch("/hello")
    .then(resp => resp.text())
    .then(resp => {
        let div = document.createElement('div');
        div.innerHTML = resp;
        let ans = div.querySelector('div');
        console.log(ans);
    });