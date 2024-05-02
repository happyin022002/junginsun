/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0418.js
*@FileTitle : MVMT Timely Update Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.27 우경민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.08.18 나상보 [CHM-201005413-01] MVNT timely update ratio 기능보완
*                   : [EES_CTM_0418] 1. LCC 선택시 Yard 단위로 Download 가능 하도록 처리
*						             2. 검색 조건 추가 (mvmt status 멀티 선택 가능)
* 2010.09.09 김상수 [CHM-201006478-01] Full/Mty Option기능 추가 (Movement 적시 update 비율 및 row data를 조회하는 화면)
*                   1.Movement 적시 update 비율 및 row data를 조회하는 화면에 Full/Mty Option기능 추가
*                     ->Service Management > CNTR Movement > Monitoring > MVMT Timely Update Ratio
*                   2. Default 값은 All 로 하고, 필요시 Full 혹은 Mty별 조회 기능 추가
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
     * @class EES_CTM_0418 : EES_CTM_0418 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0418() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
        this.initCombo 				= initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/


 // 공통전역변수
 var comboObjects = new Array();
 var comboCnt = 0;
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var sRows = -1;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var frmObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 					switch(srcName) {

 						case "btn_Retrieve":
 							if (checkFormField())
 								doActionIBSheet(sheetObject, frmObj, IBSEARCH);
 								break;

 						case "btn_New":
                            DomSetFormObjDisable(frmObj, false);
                            frmObj.rcc_cd.Enable = true;
                            frmObj.lcc_cd.Enable = true;
                            frmObj.p_yard2.Enable = true;
                            ComResetAll();
                            frmObj.p_yard2.RemoveAll();
                            // RCC_CD 기본셋팅
                            doActionIBSheet(sheetObject, frmObj, SEARCH01);
 								break;

                         case "btn_Calendar":
                            if (!window.event.srcElement.disabled) {
                                var cal = new ComCalendarFromTo();
                                cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                            }
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
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);

         }
         // IBMultiCombo초기화
         for(var k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k], comboObjects[k].id);
         }

     	 document.form.dom_flg[0].disabled = true;
		 document.form.dom_flg[1].disabled = true;
		 document.form.dom_flg[2].disabled = true;

         setEventProcess("rcc_cd", "lcc_cd", "gap", "p_yard1");
         axon_event.addListener('click', 'gap_Change', 'gap');
         axon_event.addListener('keyup', 'yard_Change', 'p_yard1');
         axon_event.addListener('keypress', 'obj_keypress', 'p_yard1');

         doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
     }


      function yard_Change (event) {
    	  eventElement = event.srcElement;
    	  //alert (obj_keyup(event))
    	  ctl_radio();
    	  document.form.p_yard2.RemoveAll();
    	  if (eventElement.value.length < 5) return;
    	  if (srcValue == eventElement.value) return;
    	  document.form.p_yard2.RemoveAll();
    	  onShowErrMsg = false;
    	  rtn = yard_search()
/*
    	  if (rtn == true && svrChk != 'S') {
    		  ComShowCodeMessage("CTM20072");
    		  //alert ("사용자와 야드의 Server 정보 불 일치");
    		  eventElement.value = '';
    		  eventElement.select();
    		  return;
    	  }
*/
    	  //alert (srcValue + ":" +  eventElement.value + "::::" + rtn)
   		  document.form.data_by[3].checked = true;
    	  if (rtn == true) {
    		  // 커서 이동

    		  if (curKeyCode == '9') {
	   				// 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
	   				curKeyCode = "";
	   				srcValue = event.srcElement.value;
	   			} else {
	   				objTmp = setFocusIndex (eventElement, 1)
	   				try {
	   					objTmp.focus();
	   				} catch (e) {}
		   			curKeyCode = "";
		   			srcValue = event.srcElement.value;
		   			return;

	   			}
    	  } else if (rtn == false){
    		  eventElement.focus();
    		  eventElement.select();
    	  }
      }
      /**
       * GAP 변경에따른 화면 정리
       * param : combo_obj ==> 콤보오브젝트
       */
       function gap_Change() {
     	  gap = document.form.gap;
     	  obj = sheetObjects[0];
     	  if (gap[1].checked == true) {
        	 obj.ColHidden("off_12") = false;
        	 obj.ColHidden("per_12") = false;
        	 obj.ColHidden("moff_12") = false;
        	 obj.ColHidden("mper_12") = false;
        	 obj.ColHidden("soff_12") = false;
        	 obj.ColHidden("sper_12") = false;
        	 obj.ColHidden("eoff_12") = false;
        	 obj.ColHidden("eper_12") = false;
      		 obj.ColHidden("off_24") = true;
     		 obj.ColHidden("per_24") = true;
      		 obj.ColHidden("moff_24") = true;
     		 obj.ColHidden("mper_24") = true;
      		 obj.ColHidden("soff_24") = true;
     		 obj.ColHidden("sper_24") = true;
      		 obj.ColHidden("eoff_24") = true;
     		 obj.ColHidden("eper_24") = true;
     		 obj.ColHidden("off_48") = true;
     		 obj.ColHidden("per_48") = true;
     		 obj.ColHidden("moff_48") = true;
     		 obj.ColHidden("mper_48") = true;
     		 obj.ColHidden("soff_48") = true;
     		 obj.ColHidden("sper_48") = true;
     		 obj.ColHidden("eoff_48") = true;
     		 obj.ColHidden("eper_48") = true;
     	  } else if (gap[2].checked == true) {
       		 obj.ColHidden("off_12") = true;
     		 obj.ColHidden("per_12") = true;
      		 obj.ColHidden("moff_12") = true;
     		 obj.ColHidden("mper_12") = true;
      		 obj.ColHidden("soff_12") = true;
     		 obj.ColHidden("sper_12") = true;
      		 obj.ColHidden("eoff_12") = true;
     		 obj.ColHidden("eper_12") = true;
       		 obj.ColHidden("off_24") = false;
       		 obj.ColHidden("per_24") = false;
       		 obj.ColHidden("moff_24") = false;
       		 obj.ColHidden("mper_24") = false;
       		 obj.ColHidden("soff_24") = false;
       		 obj.ColHidden("sper_24") = false;
       		 obj.ColHidden("eoff_24") = false;
       		 obj.ColHidden("eper_24") = false;
     		 obj.ColHidden("off_48") = true;
     		 obj.ColHidden("per_48") = true;
     		 obj.ColHidden("moff_48") = true;
     		 obj.ColHidden("mper_48") = true;
     		 obj.ColHidden("soff_48") = true;
     		 obj.ColHidden("sper_48") = true;
     		 obj.ColHidden("eoff_48") = true;
     		 obj.ColHidden("eper_48") = true;
     	  } else if (gap[3].checked == true) {
       		 obj.ColHidden("off_12") = true;
       		 obj.ColHidden("per_12") = true;
       		 obj.ColHidden("moff_12") = true;
       		 obj.ColHidden("mper_12") = true;
       		 obj.ColHidden("soff_12") = true;
       		 obj.ColHidden("sper_12") = true;
       		 obj.ColHidden("eoff_12") = true;
       		 obj.ColHidden("eper_12") = true;
       		 obj.ColHidden("off_24") = true;
     		 obj.ColHidden("per_24") = true;
      		 obj.ColHidden("moff_24") = true;
     		 obj.ColHidden("mper_24") = true;
      		 obj.ColHidden("soff_24") = true;
     		 obj.ColHidden("sper_24") = true;
      		 obj.ColHidden("eoff_24") = true;
     		 obj.ColHidden("eper_24") = true;
     		 obj.ColHidden("off_48") = false;
     		 obj.ColHidden("per_48") = false;
     		 obj.ColHidden("moff_48") = false;
     		 obj.ColHidden("mper_48") = false;
     		 obj.ColHidden("soff_48") = false;
     		 obj.ColHidden("sper_48") = false;
     		 obj.ColHidden("eoff_48") = false;
     		 obj.ColHidden("eper_48") = false;

     	  } else {
       		 obj.ColHidden("off_12") = false;
       		 obj.ColHidden("per_12") = false;
       		 obj.ColHidden("moff_12") = false;
       		 obj.ColHidden("mper_12") = false;
       		 obj.ColHidden("soff_12") = false;
       		 obj.ColHidden("sper_12") = false;
       		 obj.ColHidden("eoff_12") = false;
       		 obj.ColHidden("eper_12") = false;
      		 obj.ColHidden("off_24") = false;
      		 obj.ColHidden("per_24") = false;
       		 obj.ColHidden("moff_24") = false;
      		 obj.ColHidden("mper_24") = false;
       		 obj.ColHidden("soff_24") = false;
      		 obj.ColHidden("sper_24") = false;
       		 obj.ColHidden("eoff_24") = false;
       		 obj.ColHidden("eper_24") = false;
       		 obj.ColHidden("off_48") = false;
       		 obj.ColHidden("per_48") = false;
       		 obj.ColHidden("moff_48") = false;
       		 obj.ColHidden("mper_48") = false;
       		 obj.ColHidden("soff_48") = false;
       		 obj.ColHidden("sper_48") = false;
       		 obj.ColHidden("eoff_48") = false;
       		 obj.ColHidden("eper_48") = false;

     	  }
     	  formObj = document.form;
			formObj.c12.value = '';
			formObj.c24.value = '';
			formObj.c48.value = '';
			formObj.c72.value = '';
			formObj.c_a.value = '';
			formObj.p12.value = '';
			formObj.p24.value = '';
			formObj.p48.value = '';
			formObj.p72.value = '';
     	  obj.RemoveAll();
       }


    /**
     * rcc_cd[combo0] Object의 OnKeyDown이벤트 처리
     */
    function rcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


     /**
      * Container No Object의 값 변경 처리
      * param : Row
      * param : Col
      * param : Value
      */
      function rcc_cd_OnChange(Row, Col, Value) {
    	  var rcc = document.form.rcc_cd.Text;
    	  if (rcc.substring(0,2) == 'US' || rcc.substring(0,2) == 'AL') {
    		  document.form.dom_flg[0].disabled = false;
    		  document.form.dom_flg[1].disabled = false;
    		  document.form.dom_flg[2].disabled = false;
    	  } else {
    		  document.form.dom_flg[0].disabled = true;
    		  document.form.dom_flg[1].disabled = true;
    		  document.form.dom_flg[2].disabled = true;
    		  document.form.dom_flg[0].checked = true;
    	  }
    	  doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
      }


      /**
       * Container No Object의 값 변경 처리
       * param : Row
       * param : Col
       * param : Value
       */
       function lcc_cd_OnChange(Row, Col, Value) {
     	  obj = document.form.data_by;
//     	  obj[3].checked = true;
     	  ctl_radio();
       }


    /**
     * lcc_cd[combo1] Object의 OnKeyDown이벤트 처리
     */
    function lcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


       /**
        * Container No Object의 값 변경 처리
        * param : Row
        * param : Col
        * param : Value
        */
        function p_yard2_OnChange(Row, Col, Value) {
        	ctl_radio();
        }


    /**
     * p_yard2[combo2] Object의 OnKeyDown이벤트 처리
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


     /**
      * 라디오 버튼제어
      */
     function ctl_radio() {
     	var obj = document.form;
     	var pobj = document.form.data_by;
     	var yd1 = obj.p_yard1.value;
     	var yd2 = obj.p_yard2.Text;
     	var lcc = obj.lcc_cd.Text;

     	if (yd2 != '') {
     		if (pobj[3].checked != true) {
         		pobj[4].checked = true;
     		}
     		pobj[0].disabled = true;
     		pobj[1].disabled = true;
     		pobj[2].disabled = true;
     		pobj[3].disabled = true;
     	} else if (yd1 != '') {
     		if (yd1.length == 5) {
     			if (pobj[4].checked != true) {
     				pobj[3].checked = true;
     			}
     			pobj[2].disabled = true;
     			pobj[3].disabled = false;
     		} else {
     			if (pobj[4].checked != true) {
         			pobj[3].checked = false;
     			}
     			pobj[2].disabled = false;
     			pobj[3].disabled = false;
     		}
     		pobj[0].disabled = true;
     		pobj[1].disabled = true;

     	} else if (lcc != '') {
     		pobj[0].disabled = true;
     		pobj[1].disabled = true;
     	} else if (lcc == '') {
     		pobj[0].disabled = false;
     		pobj[1].disabled = false;
     	}
     }


     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 382;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

 										var HeadTitle1 = "|Seq.|RCC|CN|LCC|LOC|Yard|ALL|ALL|ALL|ALL|ALL|ALL|ALL|ALL|ALL|";
 												HeadTitle1 += "EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|";
 												HeadTitle1 += "SPP|SPP|SPP|SPP|SPP|SPP|SPP|SPP|SPP|";
 												HeadTitle1 += "Manual|Manual|Manual|Manual|Manual|Manual|Manual|Manual|Manual|Cond|Cond|Cond|Cond|Cond|";

 										var HeadTitle2 = "|Seq.|RCC|CN|LCC|LOC|Yard|12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|";
 												HeadTitle2 += "12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|";
 												HeadTitle2 += "12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|";
 												HeadTitle2 += "12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|gap|p_date1|p_date2|dom_flg|data_by|";

                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 										InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                     InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,				30, 	daCenter,	true,	"SEQ");
                     InitDataProperty(0, cnt++ , dtData,			50, 	daCenter,	true,	"rcc_cd");
                     InitDataProperty(0, cnt++ , dtData,			30, 	daCenter,	true,	"cnt_cd");
                     InitDataProperty(0, cnt++ , dtData,			50, 	daCenter,	true,	"lcc_cd");
                     InitDataProperty(0, cnt++ , dtData,			40, 	daCenter,	true,	"loc_cd");
                     InitDataProperty(0, cnt++ , dtData,			60, 	daCenter,	true,	"org_yd_cd");

                     InitDataProperty(0, cnt++ , dtAutoSum,			70, 	daRight,	false,	"off_12",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"per_12",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtAutoSum,			70, 	daRight,	false,	"off_24",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"per_24",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtAutoSum,			70, 	daRight,	false,	"off_48",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"per_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtAutoSum,			70, 	daRight,	false,	"ovr_48",			false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"oper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtAutoSum,			70, 	daRight,	false,	"tot",		false,	"",		dfNullInteger);

                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"eoff_12",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"eper_12",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"eoff_24",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"eper_24",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"eoff_48",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"eper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"eovr_48",			false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"eoper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"etot",		false,	"",		dfNullInteger);

                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"soff_12",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"sper_12",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"soff_24",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"sper_24",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"soff_48",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"sper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"sovr_48",			false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"soper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"stot",		false,	"",		dfNullInteger);

                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"moff_12",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"mper_12",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"moff_24",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"mper_24",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"moff_48",		false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"mper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"movr_48",			false,	"",		dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,			35, 	daRight,	false,	"moper_48",	false,	"",		dfNullFloat,		1);
                     InitDataProperty(0, cnt++ , dtData,			70, 	daRight,	false,	"mtot",		false,	"",		dfNullInteger);

                     InitDataProperty(0, cnt++ , dtHidden,			70, 	daRight,	false,	"gap");
                     InitDataProperty(0, cnt++ , dtHidden,			70, 	daRight,	false,	"p_date1");
                     InitDataProperty(0, cnt++ , dtHidden,			70, 	daRight,	false,	"p_date2");
                     InitDataProperty(0, cnt++ , dtHidden,			70, 	daRight,	false,	"dom_flg");
                     InitDataProperty(0, cnt++ , dtHidden,			70, 	daRight,	false,	"data_by");

                     RequestTimeOut = 6000;
                     FrozenCols = 7;
                     CountPosition = 0;
                     WaitImageVisible = false;

 					}
                 break;
             case "sheet2":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 80;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);
                     var HeadTitle1 = "|Seq.|Container No.| Type/size| Status| I/O status| Method| Event Yard| Event date| receiving/creation date| GAP| User name";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(12, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,    true,     "HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,          30,     daCenter,    true,     "SEQ");
                     InitDataProperty(0, cnt++ , dtData,         120,    daCenter,    true,     "cntr_no");
                     InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    true,     "cntr_tpsz_cd");
                     InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    true,     "mvmt_sts_cd");
                     InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    true,     "ob_cntr_flg");
                     InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    true,     "mvmt_inp_tp_cd");

                     InitDataProperty(0, cnt++ , dtData,         70,     daRight,     false,    "org_yd_cd");
                     InitDataProperty(0, cnt++ , dtData,         120,    daRight,     false,    "cnmv_evnt_dt");
                     InitDataProperty(0, cnt++ , dtData,         120,    daRight,     false,    "cre_locl_dt");
                     InitDataProperty(0, cnt++ , dtData,         100,    daRight,     false,    "offset_dt");
                     InitDataProperty(0, cnt++ , dtData,         100,    daRight,     false,    "usr_nm");

                     RequestTimeOut = 6000;
                     CountPosition = 0;
                     WaitImageVisible = false;

                 }
                     break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;


          switch(sAction)
         {

            case IBSEARCH:      //조회
            		if(validateForm(sheetObj,formObj,sAction)) {

						// p_date1과 p_date2가 3개월이 넘으면 return
						var rcc = document.form.rcc_cd.Text;
						if (rcc != 'ALL' && ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "M", 3),'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
							ComShowCodeMessage("CTM30012", "3 months");
							return;
						} else if (rcc == 'ALL' && ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "M", 1),'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
							ComShowCodeMessage("CTM30012", "1 month");
							return;
						}

            			sheetObj.RemoveAll();
            			ComBtnDisable("btn_Retrieve");
            			ComBtnDisable("btn_New");
            			DomSetFormObjDisable(form, true);
        				ComOpenWait(true);
        				sheetObj.WaitImageVisible = false;
            			formObj.f_cmd.value = COMMAND01;
            			var sXml = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(formObj));
            			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")
						// BackEnd Job호출하고 key를 리턴 받는다. 리턴 받은 키를 3초에 한번씩 서버로 보내
						// 작업이 완료 되었는지 확인 후 완료되면 결과를 받아온다
            			if (backendJobKey.length > 0) {
            				formObj.backendjob_key.value = backendJobKey;
            				sheetObj.WaitImageVisible = false;
            				sheetObj.RequestTimeOut = 10000;
            				timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
            			}
            		}
                 break;

            case SEARCH01:        //
            	formObj.f_cmd.value = SEARCH01;
            	comboObj = document.form.rcc_cd;
            	rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(formObj));
	           	if (rtn == '') return;
	           	rtn = ComGetEtcData(rtn, "rtn");
	           	rtn = rtn + "ALL|0";
	        	var rtnList = rtn.split("^");
	        	comboObj.RemoveAll();
	        	idxSelect = "";


	        	for (i = 0; i <= rtnList.length; i++) {
	        		if (rtnList[i]) {
	        			rtnValue = rtnList[i].split("|");
	        			comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);
	        			if (rtnValue[1] == '1') idxSelect = rtnValue[0];
	        		}
	        	}
	        	comboObj.Text (idxSelect);
	        	doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
                break;

            case SEARCH02:        //
	        	formObj.f_cmd.value = SEARCH02;
	        	comboObj = document.form.lcc_cd;
	        	rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(formObj));
	           	if (rtn == '') return;
	           	rtn = ComGetEtcData(rtn, "rtn");
	        	var rtnList = rtn.split("^");
	        	comboObj.RemoveAll();
	        	idxSelect = "";

	        	for (i = 0; i <= rtnList.length; i++) {
	        		if (rtnList[i]) {
	        			rtnValue = rtnList[i].split("|");
	        			comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);
	        		}
	        	}
	            break;

            case COMMAND01:
	            var SaveFileName = sheetObj.SaveFileDialog("ExcelDown", "book1", "C:\\","엑셀파일(*.xls)|*.xls" );
	            if (SaveFileName == '' || SaveFileName == "<USER_CANCEL>") {
	            	return;
	            } else {
	            	ComOpenWait(true);
        			var queryStr = "f_cmd=" + SEARCH03;
        			queryStr += "&p_yard=" + sheetObjects[0].CellValue(sRows, "org_yd_cd");
        			queryStr += "&time_off=" + formObj.time_off.value;
        			queryStr += "&edi_type=" + formObj.edi_type.value;
        			queryStr += "&sts_cd=" + formObj.sts_cd.value;
        			queryStr += "&fcntr_flg=" + formObj.fcntr_flg.value;
        			queryStr += "&" + sheetObjects[0].RowSaveStr(sRows);
                    sheetObj.DoSearch4Fx("EES_CTM_0418GS.do", queryStr);
		            sheetObj.SpeedDown2Excel(-1, false, false, SaveFileName);
		            ComOpenWait(false);
	            }
	            break;
         }

     }


    /**
     * sheet1 Object의 OnSearchEnd이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        DomSetFormObjDisable(form, false);
        ctl_radio();

        var frmObj = document.form;
        if (frmObj.rcc_cd.Text.substring(0,2) == 'US') {
            frmObj.dom_flg[0].disabled = false;
            frmObj.dom_flg[1].disabled = false;
            frmObj.dom_flg[2].disabled = false;
        } else {
            frmObj.dom_flg[0].disabled = true;
            frmObj.dom_flg[1].disabled = true;
            frmObj.dom_flg[2].disabled = true;
        }

        if (ErrMsg == "" && sheetObj.RowCount > 0) {
            lstRow = sheetObj.LastRow;
            sheetObj.RowHidden(lstRow) = true;
            total = sheetObj.CellValue(lstRow, "tot");
            if (total == '0') total = 1;
            else total = total.replace(",","")
            if (sheetObj.CellValue(lstRow, "tot") == '') {
                formObj.c12.value = '';
                formObj.c24.value = '';
                formObj.c48.value = '';
                formObj.c72.value = '';
                formObj.c_a.value = '';
                formObj.p12.value = '';
                formObj.p24.value = '';
                formObj.p48.value = '';
                formObj.p72.value = '';
            } else {
                formObj.c12.value = sheetObj.CellText(lstRow, "off_12");
                formObj.c24.value = sheetObj.CellText(lstRow, "off_24");
                formObj.c48.value = sheetObj.CellText(lstRow, "off_48");
                formObj.c72.value = sheetObj.CellText(lstRow, "ovr_48");
                formObj.c_a.value = sheetObj.CellText(lstRow, "tot");
                formObj.p12.value = Math.round(sheetObj.CellValue(lstRow, "off_12").replace(",","") / total * 1000)/10 + " %";
                formObj.p24.value = Math.round(sheetObj.CellValue(lstRow, "off_24").replace(",","") / total * 1000)/10 + " %";
                formObj.p48.value = Math.round(sheetObj.CellValue(lstRow, "off_48").replace(",","") / total * 1000)/10 + " %";
                formObj.p72.value = Math.round(sheetObj.CellValue(lstRow, "ovr_48").replace(",","") / total * 1000)/10 + " %";
            }

            with(sheetObj) {
                if (frmObj.data_by[4].checked) {
                    CellFont("FontBold", 2, "tot", LastRow, "tot") = true;
                    ColFontColor("tot") = RgbColor(0, 0, 255);
                    DataLinkMouse("tot") = true;
                    CellFont("FontBold", 2, "mtot", LastRow, "mtot") = true;
                    ColFontColor("mtot") = RgbColor(0, 0, 255);
                    DataLinkMouse("mtot") = true;
                    CellFont("FontBold", 2, "stot", LastRow, "stot") = true;
                    ColFontColor("stot") = RgbColor(0, 0, 255);
                    DataLinkMouse("stot") = true;
                    CellFont("FontBold", 2, "etot", LastRow, "etot") = true;
                    ColFontColor("etot") = RgbColor(0, 0, 255);
                    DataLinkMouse("etot") = true;

                    CellFont("FontBold", 2, "off_12", LastRow, "off_12") = true;
                    ColFontColor("off_12") = RgbColor(0, 0, 255);
                    DataLinkMouse("off_12") = true;
                    CellFont("FontBold", 2, "moff_12", LastRow, "moff_12") = true;
                    ColFontColor("moff_12") = RgbColor(0, 0, 255);
                    DataLinkMouse("moff_12") = true;
                    CellFont("FontBold", 2, "soff_12", LastRow, "soff_12") = true;
                    ColFontColor("soff_12") = RgbColor(0, 0, 255);
                    DataLinkMouse("soff_12") = true;
                    CellFont("FontBold", 2, "eoff_12", LastRow, "eoff_12") = true;
                    ColFontColor("eoff_12") = RgbColor(0, 0, 255);
                    DataLinkMouse("eoff_12") = true;

                    CellFont("FontBold", 2, "off_24", LastRow, "off_24") = true;
                    ColFontColor("off_24") = RgbColor(0, 0, 255);
                    DataLinkMouse("off_24") = true;
                    CellFont("FontBold", 2, "moff_24", LastRow, "moff_24") = true;
                    ColFontColor("moff_24") = RgbColor(0, 0, 255);
                    DataLinkMouse("moff_24") = true;
                    CellFont("FontBold", 2, "soff_24", LastRow, "soff_24") = true;
                    ColFontColor("soff_24") = RgbColor(0, 0, 255);
                    DataLinkMouse("soff_24") = true;
                    CellFont("FontBold", 2, "eoff_24", LastRow, "eoff_24") = true;
                    ColFontColor("eoff_24") = RgbColor(0, 0, 255);
                    DataLinkMouse("eoff_24") = true;

                    CellFont("FontBold", 2, "off_48", LastRow, "off_48") = true;
                    ColFontColor("off_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("off_48") = true;
                    CellFont("FontBold", 2, "moff_48", LastRow, "moff_48") = true;
                    ColFontColor("moff_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("moff_48") = true;
                    CellFont("FontBold", 2, "soff_48", LastRow, "soff_48") = true;
                    ColFontColor("soff_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("soff_48") = true;
                    CellFont("FontBold", 2, "eoff_48", LastRow, "eoff_48") = true;
                    ColFontColor("eoff_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("eoff_48") = true;

                    CellFont("FontBold", 2, "ovr_48", LastRow, "ovr_48") = true;
                    ColFontColor("ovr_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("ovr_48") = true;
                    CellFont("FontBold", 2, "movr_48", LastRow, "movr_48") = true;
                    ColFontColor("movr_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("movr_48") = true;
                    CellFont("FontBold", 2, "sovr_48", LastRow, "sovr_48") = true;
                    ColFontColor("sovr_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("sovr_48") = true;
                    CellFont("FontBold", 2, "eovr_48", LastRow, "eovr_48") = true;
                    ColFontColor("eovr_48") = RgbColor(0, 0, 255);
                    DataLinkMouse("eovr_48") = true;
                } else {
                    DataLinkMouse("tot") = false;
                    DataLinkMouse("mtot") = false;
                    DataLinkMouse("stot") = false;
                    DataLinkMouse("etot") = false;

                    DataLinkMouse("off_12") = false;
                    DataLinkMouse("moff_12") = false;
                    DataLinkMouse("soff_12") = false;
                    DataLinkMouse("eoff_12") = false;

                    DataLinkMouse("off_24") = false;
                    DataLinkMouse("moff_24") = false;
                    DataLinkMouse("soff_24") = false;
                    DataLinkMouse("eoff_24") = false;

                    DataLinkMouse("off_48") = false;
                    DataLinkMouse("moff_48") = false;
                    DataLinkMouse("soff_48") = false;
                    DataLinkMouse("eoff_48") = false;

                    DataLinkMouse("ovr_48") = false;
                    DataLinkMouse("movr_48") = false;
                    DataLinkMouse("sovr_48") = false;
                    DataLinkMouse("eovr_48") = false;
                }
            }
        }
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
//     		if (sAction == IBSEARCH) {
//    	          if (cancelDate == false){
//    	        	  return false;
//    	          }
//    	         }
        	var tmpobjValue = formObj.p_date1.value;
        	var tmpobjValue2 = formObj.p_date2.value;
            // 전체 내용중 -를 삭제.
        	
        	tmpobjValue = ComGetUnMaskedValue(tmpobjValue, "ymd");
            tmpobjValue2 = ComGetUnMaskedValue(tmpobjValue2, "ymd");
            if (!ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue2) || !ComIsDate(tmpobjValue2)) {
				return false;
            } else {
                    date1 = document.getElementById("p_date1").value;
                    date2 = document.getElementById("p_date2").value;
                    date1 = ComGetUnMaskedValue(date1, "ymd");
                    date2 = ComGetUnMaskedValue(date2, "ymd");
                    if (date1 == '' || date2 == '') return;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	formObj.p_date1.focus();
                        return false;
                    }

            }

         }
         return true;
     }


    /**
     * 더블 클릭시 Excel로 자료를 내려받도록 한다.
     * 10000라인을 넘어가는 경우 경고 메시지 출력 후 종료한다
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        if (sheetObj.DataLinkMouse(Col) && sheetObj.CellValue(Row, "org_yd_cd") != "") {
        	var frmObj = document.form;
            var val = sheetObj.ColSaveName(Col);
            cellVal = sheetObj.CellValue(Row, Col);

            if (cellVal > 10000) {
                ComShowCodeMessage("CTM20112");
                return;
            } else if (cellVal < 1) {
            	return;
            } else if (ComShowCodeConfirm("CTM30006")) {

                sRows = Row;
                if (Col >= 7 && Col <= 15) {
                    val = val.substring (0, val.length);
                    frmObj.edi_type.value = 'A';
                } else if (Col >= 16 && Col <= 24) {
                    val = val.substring (1, val.length);
                    frmObj.edi_type.value = 'E';
                } else if (Col >= 25 && Col <= 33) {
                    val = val.substring (1, val.length);
                    frmObj.edi_type.value = 'S';
                } else if (Col >= 34 && Col <= 42) {
                    val = val.substring (1, val.length);
                    frmObj.edi_type.value = 'M';
                } else return;

                if (val == 'off_12') frmObj.time_off.value = '1';
                else if (val == 'off_24') frmObj.time_off.value = '2';
                else if (val == 'off_48') frmObj.time_off.value = '3';
                else if (val == 'ovr_48') frmObj.time_off.value = '4';
                else if (val == 'tot') frmObj.time_off.value = '5';

                doActionIBSheet(sheetObjects[1], frmObj, COMMAND01);
            }
        }
    }


     /**
      * statusCombo의 MultiSelection OnCheckClick 이벤트 처리
      */
     function statusCombo_OnCheckClick(comboObj, index, code) {
         // coCtm의 multiComboOnCheckClick 호출
         multiComboOnCheckClick(comboObj, index, document.form.sts_cd);
     }


    /**
	 * Combo 기본 설정
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 */
    function initCombo(comboObj, comboId) {

        with (comboObj) {
        	switch (comboId) {

        	case "statusCombo":
        		MultiSelect = true;
                DropHeight = 160;
                InsertItem(0, "ALL", "");
                InsertItem(1, "OP", "OP");
                InsertItem(2, "EN", "EN");
                InsertItem(3, "TN", "TN");
                InsertItem(4, "OC", "OC");
                InsertItem(5, "VL", "VL");
                InsertItem(6, "VD", "VD");
                InsertItem(7, "IC", "IC");
                InsertItem(8, "ID", "ID");
                InsertItem(9, "TS", "TS");
                InsertItem(10, "MT", "MT");
                InsertItem(11, "ER", "ER");
                InsertItem(12, "CP", "CP");
                InsertItem(13, "CT", "CT");
                InsertItem(14, "CE", "CE");
                InsertItem(15, "CO", "CO");
                InsertItem(16, "CI", "CI");
                InsertItem(17, "CD", "CD");
                InsertItem(18, "CM", "CM");
                InsertItem(19, "ZZ", "ZZ");
                Text = "ALL";
                break;
            }
            UseAutoComplete = true;
            ValidChar(2, 1);
        }
    }


      /**
       * IBCombo Object를 배열로 등록
       * param : combo_obj ==> 콤보오브젝트
       * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
       * 배열은 소스 상단에 정의
       */
      function setComboObject(combo_obj) {
          comboObjects[comboCnt++] = combo_obj;
     }

      /**
       * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
       */
      function getBackEndJobStatus() {

	    	formObj = document.form;
	       	var sheetObject1 = sheetObjects[0];
	       	formObj.f_cmd.value = SEARCH;
	       	sheetObject1.WaitImageVisible = false;
	      	var sXml = sheetObject1.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(formObj));
	       	var jobState = ComGetEtcData(sXml, "jb_sts_flg")
	       	// alert("sheet1 :::>> jobState : "+jobState);

	       	if (jobState == "3") {
	       		getBackEndJobLoadFile();
	       		clearInterval(timer);
	    		ComBtnEnable("btn_Retrieve");
	    		ComBtnEnable("btn_New");
	       	} else if (jobState == "4") {
	       		// BackEndJob을 실패 하였습니다.
	       		ComShowCodeMessage('CTM10024');
				ComOpenWait(false);
	    		ComBtnEnable("btn_Retrieve");
	    		ComBtnEnable("btn_New");
	       	} else if (jobState == "5") {
	       		// 이미 BackEndJob 결과 파일을 읽었습니다.
	       		ComShowCodeMessage('CTM10024');
				ComOpenWait(false);
	    		ComBtnEnable("btn_Retrieve");
	    		ComBtnEnable("btn_New");
	       	}

       }


    /**
     * sheet2 Object의 OnDownFinish이벤트 처리
     */
    function sheet2_OnDownFinish(DownloadType, SaveAsName) {
        ComShowCodeMessage("CTM10115", "Data");
    }


       /**
        * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)
        */
    function getBackEndJobLoadFile() {
       	formObj = document.form;
       	formObj.f_cmd.value = SEARCHLIST;
       	ComOpenWait(false);
       	sheetObjects[0].DoSearch4Sax("EES_CTM_0418GS.do", FormQueryString(formObj));
    }
	/* 개발자 작업  끝 */