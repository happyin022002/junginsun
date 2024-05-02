/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0934.js
*@FileTitle  : Edit Date / Time
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/

   	/* 개발자 작업	*/
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    var opener;
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		initControl();
		opener = window.dialogArguments;
		if (!opener)
			opener = parent;
    }
    /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
		var formObject=document.form;
      	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
      	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
      	// axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
      }
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
//     function obj_keypress(){
//		switch(ComGetEvent("dataformat")){
//	    	case "int":
//		        //숫자만입력하기
//		        ComKeyOnlyNumber(ComGetEvent());
//		        break;
//	        case "float":
//	            //숫자+"."입력하기
//	            ComKeyOnlyNumber(ComGetEvent(), ".");
//	            break;
//	        case "eng":
//	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engdn":
//	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        default:
//	            //숫자만입력하기(정수,날짜,시간)
//	            ComKeyOnlyNumber(ComGetEvent());
//	    }
//	}
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
				case "btn_ok":
					callPopupOK();
				break;
				case "btn_clear":
					formObject.reset();
				break;
				case "btn_close":
					ComClosePopup(); 
				break;				
             }
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     
    function callPopupOK(){
    	var formObj=document.form;
//		var calllFunc;
		var cctValue="";
    	var docCctValue="";
    	var cargoCctValue="";
//		var rArray=new Array(); // list of row data
		
		// single selection (Radio) or multiple selection (CheckBox)
		if (formObj.chk0.checked) {
	    	if (ComIsEmpty(formObj.year0)) {
	    		ComAlertFocus(formObj.year0, ComGetMsg("COM12130","Full Cargo CCT","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year0).length) {
	    		ComAlertFocus(formObj.year0, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month0)) {
	    		ComAlertFocus(formObj.month0, ComGetMsg("COM12130","Full Cargo","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month0).length || !ComIsMonth(formObj.month0)) {
	    		ComAlertFocus(formObj.month0, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day0)) {
	    		ComAlertFocus(formObj.day0, ComGetMsg("COM12130","Full Cargo","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day0).length || !ComIsDay2(formObj.day0)) {
	    		ComAlertFocus(formObj.day0, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time0)) {
	    		ComAlertFocus(formObj.time0, ComGetMsg("COM12130","Full Cargo","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time0).length) {
	    		ComAlertFocus(formObj.time0, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute0)) {
	    		ComAlertFocus(formObj.minute0, ComGetMsg("COM12130","Full Cargo","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute0).length) {
	    		ComAlertFocus(formObj.minute0, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time0)+ComGetObjValue(formObj.minute0),"hm")) {
	    		ComAlertFocus(formObj.time0,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	    	cargoCctValue=ComGetObjValue(formObj.year0) + "-" + ComGetObjValue(formObj.month0) + "-" + ComGetObjValue(formObj.day0) + " " + ComGetObjValue(formObj.time0) + ":" + ComGetObjValue(formObj.minute0);
    	}
		if (formObj.chk1.checked) {
	    	if (ComIsEmpty(formObj.year)) {
	    		ComAlertFocus(formObj.year, ComGetMsg("COM12130","Port CCT","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year).length) {
	    		ComAlertFocus(formObj.year, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month)) {
	    		ComAlertFocus(formObj.month, ComGetMsg("COM12130","Port CCT","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month).length || !ComIsMonth(formObj.month)) {
	    		ComAlertFocus(formObj.month, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day)) {
	    		ComAlertFocus(formObj.day, ComGetMsg("COM12130","Port CCT","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day).length || !ComIsDay2(formObj.day)) {
	    		ComAlertFocus(formObj.day, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time)) {
	    		ComAlertFocus(formObj.time, ComGetMsg("COM12130","Port CCT","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time).length) {
	    		ComAlertFocus(formObj.time, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute)) {
	    		ComAlertFocus(formObj.minute, ComGetMsg("COM12130","Port CCT","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute).length) {
	    		ComAlertFocus(formObj.minute, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time)+ComGetObjValue(formObj.minute),"hm")) {
	    		ComAlertFocus(formObj.time,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	     	cctValue=ComGetObjValue(formObj.year) + "-" + ComGetObjValue(formObj.month) + "-" + ComGetObjValue(formObj.day) + " " + ComGetObjValue(formObj.time) + ":" + ComGetObjValue(formObj.minute);
    	}
    	if (formObj.chk2.checked) {
	    	if (ComIsEmpty(formObj.year2)) {
	    		ComAlertFocus(formObj.year2, ComGetMsg("COM12130","DOC CCT","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year2).length) {
	    		ComAlertFocus(formObj.year2, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month2)) {
	    		ComAlertFocus(formObj.month2, ComGetMsg("COM12130","DOC CCT","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month2).length || !ComIsMonth(formObj.month2)) {
	    		ComAlertFocus(formObj.month2, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day2)) {
	    		ComAlertFocus(formObj.day2, ComGetMsg("COM12130","DOC CCT","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day2).length || !ComIsDay2(formObj.day2)) {
	    		ComAlertFocus(formObj.day2, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time2)) {
	    		ComAlertFocus(formObj.time2, ComGetMsg("COM12130","DOC CCT","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time2).length) {
	    		ComAlertFocus(formObj.time2, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute2)) {
	    		ComAlertFocus(formObj.minute2, ComGetMsg("COM12130","DOC CCT","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute2).length) {
	    		ComAlertFocus(formObj.minute2, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time2)+ComGetObjValue(formObj.minute2),"hm")) {
	    		ComAlertFocus(formObj.time2,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	    	docCctValue=ComGetObjValue(formObj.year2) + "-" + ComGetObjValue(formObj.month2) + "-" + ComGetObjValue(formObj.day2) + " " + ComGetObjValue(formObj.time2) + ":" + ComGetObjValue(formObj.minute2);
    	}
    	
//		rArray.push(cctValue);
//		rArray.push(docCctValue);
//		rArray.push(cargoCctValue);
		
//		try {
//			calllFunc=formObj.calllFunc.value;
//		} catch(err){}
//		if (!calllFunc)
//			calllFunc = "callBack0934";
//		
//		var func = opener[calllFunc];
//		if (func) {
//			func.apply(this, [rArray]);
//		}
		

    	var opener = window.dialogArguments;
		if (!opener) opener = parent;
		opener.setCctValue(cctValue,docCctValue,cargoCctValue);
		
//		if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
//		else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
		ComClosePopup(); 
    }
    
    /**
     * 화면 폼입력값에 대한 전송
     */
    function transferValue(formObj) {
     	var cctValue="";
    	var docCctValue="";
    	var row=formObj.row.value;
    	var col=formObj.col.value;
     	if (formObj.chk1.checked) {
	    	if (ComIsEmpty(formObj.year)) {
	    		ComAlertFocus(formObj.year, ComGetMsg("COM12130","Port CCT","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year).length) {
	    		ComAlertFocus(formObj.year, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month)) {
	    		ComAlertFocus(formObj.month, ComGetMsg("COM12130","Port CCT","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month).length || !ComIsMonth(formObj.month)) {
	    		ComAlertFocus(formObj.month, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day)) {
	    		ComAlertFocus(formObj.day, ComGetMsg("COM12130","Port CCT","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day).length || !ComIsDay2(formObj.day)) {
	    		ComAlertFocus(formObj.day, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time)) {
	    		ComAlertFocus(formObj.time, ComGetMsg("COM12130","Port CCT","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time).length) {
	    		ComAlertFocus(formObj.time, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute)) {
	    		ComAlertFocus(formObj.minute, ComGetMsg("COM12130","Port CCT","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute).length) {
	    		ComAlertFocus(formObj.minute, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time)+ComGetObjValue(formObj.minute),"hm")) {
	    		ComAlertFocus(formObj.time,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	     	cctValue=ComGetObjValue(formObj.year) + "-" + ComGetObjValue(formObj.month) + "-" + ComGetObjValue(formObj.day) + " " + ComGetObjValue(formObj.time) + ":" + ComGetObjValue(formObj.minute);
    	}
    	if (formObj.chk2.checked) {
	    	if (ComIsEmpty(formObj.year2)) {
	    		ComAlertFocus(formObj.year2, ComGetMsg("COM12130","DOC CCT","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year2).length) {
	    		ComAlertFocus(formObj.year2, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month2)) {
	    		ComAlertFocus(formObj.month2, ComGetMsg("COM12130","DOC CCT","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month2).length || !ComIsMonth(formObj.month2)) {
	    		ComAlertFocus(formObj.month2, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day2)) {
	    		ComAlertFocus(formObj.day2, ComGetMsg("COM12130","DOC CCT","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day2).length || !ComIsDay2(formObj.day2)) {
	    		ComAlertFocus(formObj.day2, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time2)) {
	    		ComAlertFocus(formObj.time2, ComGetMsg("COM12130","DOC CCT","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time2).length) {
	    		ComAlertFocus(formObj.time2, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute2)) {
	    		ComAlertFocus(formObj.minute2, ComGetMsg("COM12130","DOC CCT","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute2).length) {
	    		ComAlertFocus(formObj.minute2, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time2)+ComGetObjValue(formObj.minute2),"hm")) {
	    		ComAlertFocus(formObj.time2,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	    	docCctValue=ComGetObjValue(formObj.year2) + "-" + ComGetObjValue(formObj.month2) + "-" + ComGetObjValue(formObj.day2) + " " + ComGetObjValue(formObj.time2) + ":" + ComGetObjValue(formObj.minute2);
    	}
    	opener.setCctValue(row,col,cctValue,docCctValue);
    	ComClosePopup(); 
	}
    /**
     * 화면 폼입력값에 대한check
     */
    function formCheck(type){
	    var formObj=document.form;
	    if ("year"==type && 4==ComGetObjValue(formObj.year).length) {
		    ComSetFocus(formObj.month);
	    } else if ("month"==type && 2==ComGetObjValue(formObj.month).length) {
		    ComSetFocus(formObj.day);
	    } else if ("day"==type && 2==ComGetObjValue(formObj.day).length) {
		    ComSetFocus(formObj.time);
	    } else if ("time"==type && 2==ComGetObjValue(formObj.time).length) {
		    ComSetFocus(formObj.minute);
	    } else if ("year2"==type && 4==ComGetObjValue(formObj.year2).length) {
		    ComSetFocus(formObj.month2);
	    } else if ("month2"==type && 2==ComGetObjValue(formObj.month2).length) {
		    ComSetFocus(formObj.day2);
	    } else if ("day2"==type && 2==ComGetObjValue(formObj.day2).length) {
		    ComSetFocus(formObj.time2);
	    } else if ("time2"==type && 2==ComGetObjValue(formObj.time2).length) {
		    ComSetFocus(formObj.minute2);
	    }
    }
	/* 개발자 작업  끝 */