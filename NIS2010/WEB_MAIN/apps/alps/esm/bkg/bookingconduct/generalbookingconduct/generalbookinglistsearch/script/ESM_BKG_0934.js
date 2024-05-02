/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0934.js
*@FileTitle : bookringconduct
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2016.03.11 문동선 [CHM-201640257] booking receipt notice(fax/edi)에 Edit Rail Cut-off 기능 추가
* 2016.07.08 조창우 [CHM-201642288] booking receipt notice(fax/edi)에 VGM Cut-off 기능 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class esm_bkg_0934 : esm_bkg_0934 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0934() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
		initControl();
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
      	var formObject = document.form;
      	
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
        /*
          axon_event.addListener('keypress', 'eng_keypress', 'hamo_cd_desc');
          axon_event.addListener('keypress', 'obj_keypress', 'hamo_trf_cd');
      	*/
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
             switch(srcName) {

 							case "btn_ok":
 								transferValue(formObject);
 							break;
 							
 							case "btn_clear":
 								formObject.reset();
 							break;
 							
 							case "btn_close":
 								self.close();
 							break;				

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
     
    /**
     * 화면 폼입력값에 대한 전송
     */
    function transferValue(formObj) {
     	var cctValue = "";
    	var docCctValue = "";
    	var railFromCctValue = "";
    	var railToCctValue = "";
    	var vgmCctValue = "";
    	var row = formObj.row.value;
    	var col = formObj.col.value;
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
	     	cctValue = ComGetObjValue(formObj.year) + "-" + ComGetObjValue(formObj.month) + "-" + ComGetObjValue(formObj.day) + " " + ComGetObjValue(formObj.time) + ":" + ComGetObjValue(formObj.minute);
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
	    	docCctValue = ComGetObjValue(formObj.year2) + "-" + ComGetObjValue(formObj.month2) + "-" + ComGetObjValue(formObj.day2) + " " + ComGetObjValue(formObj.time2) + ":" + ComGetObjValue(formObj.minute2);
    	}
    	if (formObj.chk3.checked) {
	    	if (ComIsEmpty(formObj.year3)) {
	    		ComAlertFocus(formObj.year3, ComGetMsg("COM12130","Rail CCT (From)","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year3).length) {
	    		ComAlertFocus(formObj.year3, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month3)) {
	    		ComAlertFocus(formObj.month3, ComGetMsg("COM12130","Rail CCT (From)","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month3).length || !ComIsMonth(formObj.month3)) {
	    		ComAlertFocus(formObj.month3, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day3)) {
	    		ComAlertFocus(formObj.day3, ComGetMsg("COM12130","Rail CCT (From)","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day3).length || !ComIsDay2(formObj.day3)) {
	    		ComAlertFocus(formObj.day3, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time3)) {
	    		ComAlertFocus(formObj.time3, ComGetMsg("COM12130","Rail CCT (From)","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time3).length) {
	    		ComAlertFocus(formObj.time3, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute3)) {
	    		ComAlertFocus(formObj.minute3, ComGetMsg("COM12130","Rail CCT (From)","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute3).length) {
	    		ComAlertFocus(formObj.minute3, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time3)+ComGetObjValue(formObj.minute3),"hm")) {
	    		ComAlertFocus(formObj.time3,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	    	railFromCctValue = ComGetObjValue(formObj.year3) + "-" + ComGetObjValue(formObj.month3) + "-" + ComGetObjValue(formObj.day3) + " " + ComGetObjValue(formObj.time3) + ":" + ComGetObjValue(formObj.minute3);
    	}
    	if (formObj.chk4.checked) {
	    	if (ComIsEmpty(formObj.year4)) {
	    		ComAlertFocus(formObj.year4, ComGetMsg("COM12130","Rail CCT (To)","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year4).length) {
	    		ComAlertFocus(formObj.year4, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month4)) {
	    		ComAlertFocus(formObj.month4, ComGetMsg("COM12130","Rail CCT (To)","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month4).length || !ComIsMonth(formObj.month4)) {
	    		ComAlertFocus(formObj.month4, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day4)) {
	    		ComAlertFocus(formObj.day4, ComGetMsg("COM12130","Rail CCT (To)","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day4).length || !ComIsDay2(formObj.day4)) {
	    		ComAlertFocus(formObj.day4, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time4)) {
	    		ComAlertFocus(formObj.time4, ComGetMsg("COM12130","Rail CCT (To)","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time4).length) {
	    		ComAlertFocus(formObj.time4, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute4)) {
	    		ComAlertFocus(formObj.minute4, ComGetMsg("COM12130","Rail CCT (To)","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute4).length) {
	    		ComAlertFocus(formObj.minute4, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time4)+ComGetObjValue(formObj.minute4),"hm")) {
	    		ComAlertFocus(formObj.time4,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	    	railToCctValue = ComGetObjValue(formObj.year4) + "-" + ComGetObjValue(formObj.month4) + "-" + ComGetObjValue(formObj.day4) + " " + ComGetObjValue(formObj.time4) + ":" + ComGetObjValue(formObj.minute4);
    	}
    	if (formObj.chk5.checked) {
	    	if (ComIsEmpty(formObj.year5)) {
	    		ComAlertFocus(formObj.year5, ComGetMsg("COM12130","VGM CCT","Year"));  //Please enter {?msg2} of {?msg1}.
	    		return;
	    	} else if (4 > ComGetObjValue(formObj.year5).length) {
	    		ComAlertFocus(formObj.year5, ComGetMsg("COM12187","YYYY"));  //Please enter correct date.\n\n Format : {?msg1}
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.month5)) {
	    		ComAlertFocus(formObj.month5, ComGetMsg("COM12130","VGM CCT","Month"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.month5).length || !ComIsMonth(formObj.month5)) {
	    		ComAlertFocus(formObj.month5, ComGetMsg("COM12187","MM"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.day5)) {
	    		ComAlertFocus(formObj.day5, ComGetMsg("COM12130","VGM CCT","Day"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.day5).length || !ComIsDay2(formObj.day5)) {
	    		ComAlertFocus(formObj.day5, ComGetMsg("COM12187","DD"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.time5)) {
	    		ComAlertFocus(formObj.time5, ComGetMsg("COM12130","VGM CCT","Time"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.time5).length) {
	    		ComAlertFocus(formObj.time5, ComGetMsg("COM12187","HH"));
	    		return;
	    	}
	    	if (ComIsEmpty(formObj.minute5)) {
	    		ComAlertFocus(formObj.minute5, ComGetMsg("COM12130","VGM CCT","Minute"));
	    		return;
	    	} else if (2 > ComGetObjValue(formObj.minute5).length) {
	    		ComAlertFocus(formObj.minute5, ComGetMsg("COM12187","MI"));
	    		return;
	    	}
	    	if (!ComIsTime(ComGetObjValue(formObj.time5)+ComGetObjValue(formObj.minute5),"hm")) {
	    		ComAlertFocus(formObj.time5,ComGetMsg("COM132201","Time"));  //{?msg1} is invalid.
	    		return;
	    	}
	    	vgmCctValue = ComGetObjValue(formObj.year5) + "-" + ComGetObjValue(formObj.month5) + "-" + ComGetObjValue(formObj.day5) + " " + ComGetObjValue(formObj.time5) + ":" + ComGetObjValue(formObj.minute5);
    	}
    	opener.setCctValue(row,col,cctValue,docCctValue,railFromCctValue,railToCctValue,vgmCctValue);
    	self.close();
	}
      
    /**
     * 화면 폼입력값에 대한check
     */
    function formCheck(type){
	    var formObj = document.form;
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
		    
	    } else if ("year3"==type && 4==ComGetObjValue(formObj.year3).length) {
		    ComSetFocus(formObj.month3);
	    } else if ("month3"==type && 2==ComGetObjValue(formObj.month3).length) {
		    ComSetFocus(formObj.day3);
	    } else if ("day3"==type && 2==ComGetObjValue(formObj.day3).length) {
		    ComSetFocus(formObj.time3);
	    } else if ("time3"==type && 2==ComGetObjValue(formObj.time3).length) {
		    ComSetFocus(formObj.minute3);
		     
	    } else if ("year4"==type && 4==ComGetObjValue(formObj.year4).length) {
		    ComSetFocus(formObj.month4);
	    } else if ("month4"==type && 2==ComGetObjValue(formObj.month4).length) {
		    ComSetFocus(formObj.day4);
	    } else if ("day4"==type && 2==ComGetObjValue(formObj.day4).length) {
		    ComSetFocus(formObj.time4);
	    } else if ("time4"==type && 2==ComGetObjValue(formObj.time4).length) {
		    ComSetFocus(formObj.minute4);    

    	} else if ("year5"==type && 4==ComGetObjValue(formObj.year5).length) {
    		ComSetFocus(formObj.month5);
    	} else if ("month5"==type && 2==ComGetObjValue(formObj.month5).length) {
    		ComSetFocus(formObj.day5);
    	} else if ("day5"==type && 2==ComGetObjValue(formObj.day5).length) {
    		ComSetFocus(formObj.time5);
    	} else if ("time5"==type && 2==ComGetObjValue(formObj.time5).length) {
    		ComSetFocus(formObj.minute5);    
    	}
    }
	/* 개발자 작업  끝 */