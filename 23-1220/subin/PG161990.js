function solution(wallpaper) {
    var answer = [];
    // 드래그 시작점은 제일 왼쪽에 있는 x값이랑 제일 위에 있는 y값
    // 끝점은 제일 오른쪽에 있는 x값이랑 제일 아래에 있는 y값

    const x = [];
    const y = [];

    for(let i=0;i<wallpaper.length;i++) {
        for(let j=0;j<wallpaper[i].length;j++) {
            if(wallpaper[i][j] === "#") {
                x.push(i);
                y.push(j);
            }
        }
    }

    x.sort((a, b) => a - b);
    y.sort((a, b) => a - b);

    var answer = [];

    answer.push(x[0], y[0], x[x.length-1] + 1, y[y.length-1] + 1);
    console.log(answer);

    // return answer;
}

const wallpaper = ["..........", ".....#....", "......##..", "...##.....", "....#....."]
solution(wallpaper);