/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_0121.js
*@FileTitle : MOT Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 강효진
*@LastVersion : 1.0
* 2010.04.21 강효진
* 1.0 Creation
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
 * @class ESM_PRI_0121 : ESM_PRI_0121 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_0121() {
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

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject1 = sheetObjects[0];
	 /*******************************************************/
	 var formObject = document.form;

	 try {
		 var srcName = window.event.srcElement.getAttribute("name");

		 switch(srcName) {

		 case "btns_calendar1": //From 달력버튼
			 var cal = new ComCalendar();
			 cal.select(form.from_file_dt, 'yyyy-MM-dd');
			 break;

		 case "btns_calendar2": //To 달력버튼
			 var cal = new ComCalendar();
			 cal.select(form.to_file_dt, 'yyyy-MM-dd');
			 break;

		 case "btn_Retrieve":
             doActionIBSheet(sheetObject1, form, IBSEARCH);
			 break;

		 case "btn_Downexcel":
			 doActionIBSheet(sheetObject1, form, IBDOWNEXCEL);
			 break;
		 } // end switch
	 }catch(e) {
 		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	 } finally {
 		ComOpenWait(false);
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
	 
	 axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	 axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
	 
	 // 하루 전 날짜로 default setting
	 gCurrDate = ComGetDateAdd(null, "D", -1)
	 
     form.from_file_dt.value = gCurrDate;
     form.to_file_dt.value = gCurrDate;

	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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
			 style.height = 450;
			 //전체 너비 설정
			 SheetWidth = mainTable.clientWidth;

			 //Host정보 설정[필수][HostIp, Port, PagePath]
			 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			 //전체Merge 종류 [선택, Default msNone]
			 //MergeSheet = msAll;

			 //전체Edit 허용 여부 [선택, Default false]
			 //Editable = true;
			 
			 //Row의 자동 줄바꿈 하지 않음
			 AutoRowHeight = false;

			 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			 InitRowInfo( 1, 1, 3, 100);

			 var HeadTitle = "|Seq.|Carrier|Contract\nNo.|Contract Holder|Lane|Origin\n(POL)|Dest\n(POD)| |CNTR\nType|CMDT\nType|Size|MQC1|MQC2|Rate|Commission|SUR|Effective\nDate|Expiry\nDate|Remark(s)";
			 var headCount = ComCountHeadTitle(HeadTitle);

			 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			 InitColumnInfo(headCount, 0, 0, true);

			 // 해더에서 처리할 수 있는 각종 기능을 설정한다
			 InitHeadMode(true, true, false, true, false, false)

			 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			 InitHeadRow(0, HeadTitle, true);

			 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			 InitDataProperty(0, cnt++ , dtHiddenStatus,	100,	daCenter,	false,	"Status");
			 InitDataProperty(0, cnt++ , dtSeq,   30,	daRight,	false,	"",				false,"",dfNone,	0,true,	true);
			 InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"carrier",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  70,	daLeft,		false,	"sc_no",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  110,	daLeft,		false,	"ctrt_pty_nm",	false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  40,	daRight,	false,	"lane",			false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"pol_cd",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  50,	daCenter,	false,	"pod_cd",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  20,	daCenter,	false,	"",				false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cntr_tp",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cmdt_tp",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  40,	daCenter,	false,	"cntr_sz",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"mqc_1",		false,"",dfInteger,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"mqc_2",		false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"oft_rt",		false,"",dfInteger,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  20,	daRight,	false,	"commission",	false,"",dfNone,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  50,	daRight,	false,	"sur_rt",		false,"",dfInteger,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"eff_dt",		false,"",dfDateYmd,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  70,	daCenter,	false,	"exp_dt",		false,"",dfDateYmd,	0,false,false);
			 InitDataProperty(0, cnt++ , dtData,  120,	daLeft,		false,	"remark",		false,"",dfNone,	0,false,false);

		 }
		 break;

	 }
 }

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSEARCH:      //조회
			if (!validateForm(sheetObj,formObj,sAction)) {
				return;
			}

			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				var queryStr = "f_cmd=" + formObj.f_cmd.value;
				queryStr += "&from_file_dt=" + formObj.from_file_dt.value;
				queryStr += "&to_file_dt=" + formObj.to_file_dt.value;
				sheetObj.DoSearch("ESM_PRI_0121GS.do", queryStr);
//				sheetObj.DoSearch4Fx("ESM_PRI_0121GS.do", queryStr);
//				sheetObj.ApplyFormat();
			}
		
			break;
	
		case IBDOWNEXCEL:      //download excel
//			sheetObjects[0].SpeedDown2Excel(-1); //, "chk|seq"
			sheetObj.SpeedDown2Excel(-1, false, false, "", "apps/alps/esm/pri/screport/screport/script/ESM_PRI_0121.xml");
	        break;
	        
	}
}

/**
 * OnKeyDown event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param 없음
 * @return 없음
 * @author 강효진
 * @version 2010.04.26
 */       
function obj_keydown(){
   //enter key조회
   var eleName = event.srcElement.name;
   if (eleName == "from_file_dt" || eleName == "to_file_dt"){
       var keyValue = null;
       if(event == undefined || event == null) {
    	   keyValue = 13;
       }else{
    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       }
       if (keyValue == 13){
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
       }
   }
}

/** 
 * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음  
 * @return 없음
 * @see #
 * @author 강효진
 * @version 2010.04.23
 */ 
function obj_deactivate() {
    var form = document.form;
    var formObj = event.srcElement;

    ComChkObjValid(formObj);
}
 
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkEffDate <br>
  * Period 날짜 Validation을 체크한다. <br>
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * @param  {object} formObj : 폼 오브젝트
  * @return {boolean}
  * @see #
  * @author 강효진
  * @version 2010.04.26
  */
 function chkEffDate(formObj) {
     var form = document.form;
     var fromDt = form.from_file_dt;
     var toDt = form.to_file_dt;
     var fromVal = fromDt.value.replace(/-/g,'');
     var toVal = toDt.value.replace(/-/g,'');

     var fromAddD = ComGetDateAdd(toVal, "D", -2, "", true);
     if( parseInt(fromVal,10) < parseInt(fromAddD,10) ) {
         ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 days");
         event.returnValue = false;
         ComSetFocus(formObj);
         return false;
     }
     return true;
 }

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	  var fromFileDt = form.from_file_dt;
	  var toFileDt = form.to_file_dt
	  
	  switch (sAction) {

	      case IBSEARCH: //조회

		      //Filing Date 입력했는지 mandatory validation
		      if(formObj.from_file_dt.value == "") {
		    	  ComShowCodeMessage("PRI00335", fromFileDt.caption);
		    	  ComSetFocus(fromFileDt);
		    	  return false;
		      }
		      if(formObj.to_file_dt.value == "") {
		    	  ComShowCodeMessage("PRI00335", toFileDt.caption);
		    	  ComSetFocus(toFileDt);
		    	  return false;
		      }
	
		      //from date가 to date보다 큰지 validation
		      if(!ComChkObjValid(fromFileDt)) { return false; }
		      if(!ComChkObjValid(toFileDt)) { return false; }
		      //from ~ to 의 날 수가 3일 이상 되지 않도록 validation
		      if(!chkEffDate(fromFileDt)) {return false;}
              if(!chkEffDate(toFileDt)) {return false;}
	
		      break;
	  }

	 return true;
 }
 

 /* 개발자 작업  끝 */