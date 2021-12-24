window.onload = function () {

    var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Orders Line Chart"
        },
        data: [{
            type: "line",
            indexLabelFontSize: 16,
            dataPoints: [
                {x: 0, y: 450},
                {x: 1, y: 414},
                {x: 2, y: 520, indexLabel: "\u2191 highest", markerColor: "red", markerType: "triangle"},
                {x: 3, y: 460},
                {x: 4, y: 450},
                {x: 5, y: 500},
                {x: 6, y: 480},
                {x: 7, y: 480},
                {x: 8, y: 410, indexLabel: "\u2193 lowest", markerColor: "DarkSlateGrey", markerType: "cross"},
                {x: 9, y: 500},
                {x: 10, y: 480},
                {x: 11, y: 510}
            ]
        }]
    });
    chart.render();

}