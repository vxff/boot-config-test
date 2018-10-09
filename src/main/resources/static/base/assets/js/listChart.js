 //环比数据
  var loopRatioDataChart = echarts.init(document.getElementById('loopRatioDataChart'));

        // 指定图表的配置项和数据
    var option = {
    tooltip : {
        trigger: 'axis'
    },
     toolbox: {
        show: true,
        right: '3%',
        orient: 'vertical',
        feature: {
        	restore: {title: '刷新'},
            saveAsImage: {title: '下载环比图片'},
             myTool1: {
                show: true,
                title: '下载环比源数据',
                icon: 'path://M0 512.7168c0 101.632 76.0832 185.9584 176.0256 202.24l35.2256 2.816 196.1984 0 0-50.8416L213.6576 666.9312 190.3104 665.088c-67.4816-10.752-142.0288-90.7776-142.0288-156.2112 0-51.0976 43.5712-133.0176 127.744-162.0992L159.0784 302.5408C155.136 294.0416 153.1392 284.9792 153.1392 275.5584c0-36.7616 37.1712-91.392 95.488-91.392 20.0192 0 43.4688 9.984 56.8832 24.1664l55.04 38.2464 46.7968-62.4128c52.992-79.0016 142.3872-133.3248 243.2-133.3248 142.1824 0 282.5216 135.5264 284.7744 271.0016l0 48.0256 49.5104 13.2608c55.808 18.7904 93.2352 69.3248 93.2352 125.7472 0 65.3824-66.9696 147.3024-134.4512 158.0544l-30.976 0-192.4096 0 0 50.8416 194.8672 0 35.2256-2.816C1050.3168 698.6752 1126.4 614.3488 1126.4 512.7168c0-89.2928-58.7776-165.3248-140.8512-193.4336C982.5792 142.4384 833.9968 0 651.2128 0c-131.84 0-245.8624 74.0864-300.3392 181.76C325.12 154.112 287.8464 136.704 246.3744 136.704c-77.7728 0-140.8 61.2352-140.8 136.704 0 19.712 4.3008 38.4512 11.9808 55.3472C47.9232 362.2912 0 432.0768 0 512.7168zM537.7024 307.2 537.7024 960 307.2 819.2 307.2 870.4 563.2 1024 819.2 870.4 819.2 819.2 588.8 960 588.8 307.2Z',
                onclick: function (){
                    alert('下载环比源数据')
                }
            }
        }
    },
    legend: {
    	left: 'center',
        top: '2%',
        itemGap: 20,
        itemWidth: 10,
        itemHeight: 10,
        data: [
        {name:'文章数',icon:'circle'},
        {name:'涉总',icon:'circle'},
        {name:'ALEXA值',icon:'circle'},
        {name:'涉时政',icon:'circle'},
        {name:'阅读数',icon:'circle'},
        {name:'涉娱乐',icon:'circle'},
        {name:'转发数',icon:'circle'},
        {name:'短视频',icon:'circle'},
        {name:'点赞数',icon:'circle'},
        {name:'政策解读',icon:'circle'}
        ]
    },
    grid: {
    	top: '15%',
        left: '7%',
        right: '7%',
        bottom: '6%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            axisLine:{//坐标轴轴线 默认 true,
            	show: true,
            	lineStyle:{
            		color: '#dcdcdc'
            	}
            },
            axisTick:{//坐标轴刻度
            	show: false
            },
            axisLabel:{//坐标轴刻度标签
            	show: true,
            	//rotate: 30,  //旋转角度
            	textStyle:{
            		color:'#888'
            	}
            },
            splitLine:{
            	show: false
            },
            boundaryGap : false,
             data: (function (){
                var now = new Date();
                var res = [];
                var len = 10;
                while (len--) {
                    res.unshift(now.toLocaleTimeString().replace(/^\D*/,''));
                    now = new Date(now - 2000);
                }
                return res;
            })()
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLine:{//坐标轴轴线 默认 true,
            	show: false
            },
            axisTick:{//坐标轴刻度
            	show: false
            },
            axisLabel:{//坐标轴刻度标签
            	show: true,
            	//rotate: 30,  //旋转角度
            	textStyle:{
            		color:'#888'
            	}
            },
            splitLine:{
            	show: true,
            	lineStyle:{
            		color: '#dcdcdc'
            	}
            }
            
        }
    ],
    
    series : [
        {
            name:'文章数',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#28c7a2'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#28c7a2',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[220, 332, 101, 134, 90, 230, 310,220, 332, 101]
        },
        {
            name:'涉总',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#b96bc9'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#b96bc9',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[160, 232, 161, 34, 120, 330, 110,320, 132, 41]
        },
        {
            name:'ALEXA值',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#02c3e0'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#02c3e0',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[180, 282, 191, 94, 160, 380, 160,380, 182, 91]
        },
        {
            name:'涉时政',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#ffb53e'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#ffb53e',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[80, 82, 91, 74, 60, 80, 60,80, 82, 71]
        },
        {
            name:'阅读数',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#97cc66'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#97cc66',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[60, 62, 71, 54, 40, 60, 40,60, 62, 51]
        },
        {
            name:'涉娱乐',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#fb8d3c'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#fb8d3c',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[50, 52, 61, 44, 30, 50, 30,50, 52, 41]
        },
        {
            name:'转发数',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#5c89e6'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#5c89e6',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[40, 42, 51, 34, 20, 40, 20,40, 42, 31]
        },
        {
            name:'短视频',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#946acc'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#946acc',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[30, 32, 41, 24, 10, 30, 10,30, 32, 21]
        },
        {
            name:'点赞数',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#4fe0e0'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#4fe0e0',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[140, 142, 151, 134, 120, 140, 120,140, 142, 131]
        },
        {
            name:'政策解读',
            type:'line',
            //symbol: 'circle',
            symbol: 'emptyCircle',//圆圈
            symbolSize: 10,
            itemStyle:{
            	normal:{
            		color: '#e55c5c'
            	}
            },
            lineStyle:{
            	normal:{
            		color: '#e55c5c',
            		width: 2,
            		type: 'solid'
            	}
            },            
            smooth: false,
            data:[240, 242, 251, 234, 220, 240, 220,240, 242, 231]
        }
         
        
    ]
};

        // 使用刚指定的配置项和数据显示图表。
  loopRatioDataChart.setOption(option);
        //重新定义所有图表自适应容器大小
        setTimeout(function() {
        	window.onresize = function() {
        		loopRatioDataChart.resize();
        	}

        });