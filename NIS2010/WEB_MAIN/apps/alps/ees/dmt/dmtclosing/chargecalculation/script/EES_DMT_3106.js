/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3106.js
*@FileTitle : Manual Batch by POD ETA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.03 황효근
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
     * @class EES_DMT_3106 : EES_DMT_3106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3106() {
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

var sheetObjects = new Array();
var sheetCnt = 0;

var IBGETPODETA	= 99;
var IBGETVDMVMT = 98;
 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj = sheetObjects[0];
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             	case "btn_GetVDMVMT":
             		doActionIBSheet(sheetObj,formObj,IBGETVDMVMT);
					break;
 			
 				case "btn_Save":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
 				
 				case "btn_Update":
 					processUpdate();
 					break;
 					
 				case "btn_Close":
 					window.close();
 					break;
	
 					
 				case "btns_calendar": //달력 버튼
					var cal = new ComCalendar();
					cal.select(formObj.upd_fm_dt, 'yyyy-MM-dd');
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
 		
         initControl();
         doInit();
     }
     
     
     function initControl() {
 		axon_event.addListener('blur',		'obj_blur',		'upd_fm_dt'); //- 포커스 나갈때
 		axon_event.addListener('focus',		'obj_focus',	'upd_fm_dt'); //- 포커스 들어갈때
 		axon_event.addListener('keypress',	'obj_keypress',	'upd_fm_dt'); //- 키보드 입력할때
     }

     
     //포커스가 나갈 때
     function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
    	ComChkObjValid(event.srcElement);
     }
     
     /**
      * HTML Control Foucs in
      */
	function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
         
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
     

	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
     
	
     /**
      * 초기화 처리
      */
     function doInit() {
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
 		
 		var opener = window.dialogArguments;
 		var opnSheetObj = opener.document.form.sheet1;
 		
 		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
 		var sXml = ComMakeSearchXml(opnSheetObj, false, "chk", "cntr_no|cntr_tpsz_cd|fm_mvmt_yd_cd|fm_mvmt_dt|bkg_no|bl_no|vvd_cd|svr_id|cntr_cyc_no|ar_act_cd|cnee_cd|ntfy_cd");
 		
 		
 		//sheet2로 조회XML 로드하기
 		sheetObj.LoadSearchXml(sXml, true);
 		
 		
 		var callFlag = ComGetObjValue(formObj.call_flag);
 		
 		// byBKG 화면에서 호출시 Grid 일부 데이터값 설정 처리
 		if(callFlag == 'bybkg') {
 			var opnFormObj = opener.document.form;
 			var bkgNo	= ComGetObjValue(opnFormObj.bkg_no);
 			var blNo	= ComGetObjValue(opnFormObj.bl_no);
 			var vvdCd	= ComGetObjValue(opnFormObj.vvd_cd);
 			var arActCd	= ComGetObjValue(opnFormObj.ar_act_cd);
 			var cneeCd	= ComGetObjValue(opnFormObj.cnee_cd);
 			var ntfyCd	= ComGetObjValue(opnFormObj.ntfy_cd);
 			
 			for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
     			sheetObj.CellValue2(i, "bkg_no")	= bkgNo;
     			sheetObj.CellValue2(i, "bl_no")		= blNo;
     			sheetObj.CellValue2(i, "vvd_cd")	= vvdCd;
     			sheetObj.CellValue2(i, "ar_act_cd") = arActCd;
     			sheetObj.CellValue2(i, "cnee_cd")	= cneeCd;
     			sheetObj.CellValue2(i, "ntfy_cd")	= ntfyCd;
     		}
 		}
  	}
      
      
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
  	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		var sheetObj = sheetObjects[0];
  		
  		sheetObj.WaitImageVisible = false;
  		
  		doActionIBSheet(sheetObj,formObj,IBGETPODETA);
   		
   		sheetObj.CheckAll("chk") = 1;
   		DmtComEnableManyBtns(false, "btn_Save", "btn_Update");
   		
   		sheetObj.WaitImageVisible = true;
	}  
     

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // sheet1 init
            	 with (sheetObj) {
                     // 높이 설정
                     style.height = GetSheetHeight(10);
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(16, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle  = "||Seq.|CNTR No.|T/S|From YD|From DT|BKG No.|B/L No.|VVD CD|ETA";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,   true,	"ibflag");
 					InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,	true,	"chk");
 					InitDataProperty(0, cnt++ , dtSeq,				40,		daCenter,	false,	"seq");
 					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	"cntr_no",		false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,	"cntr_tpsz_cd",	false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,	"fm_mvmt_yd_cd",false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtPopupEditFormat,	100,	daCenter,	false,	"fm_mvmt_dt",	false,	"",	dfDateYmd,	0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	"bkg_no",		false,	"",	dfNone,		0,	false,	true);	
 					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	"bl_no",		false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,	"vvd_cd",		false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,	"vps_eta_dt",	false,	"",	dfDateYmd,	0,	false,	true);
 					
 					InitDataProperty(0, cnt++ , dtHidden, 			0,		daCenter,	true,	"svr_id",		false,  "",	dfNone,		0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden, 			0,		daCenter,	true,	"cntr_cyc_no",	false,  "",	dfNone,		0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden, 			0,		daCenter,	true,	"ar_act_cd",	false,  "",	dfNone,		0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden, 			0,		daCenter,	true,	"cnee_cd",		false,  "",	dfNone,		0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden, 			0,		daCenter,	true,	"ntfy_cd",		false,  "",	dfNone,		0,	false,  false);
 					
 					
 					PopupImage  =  "img/btns_calendar.gif";
 					ShowButtonImage = 2;
            	 } // with - end
                 break;
                 
             case 2:      // sheet1 init
            	 with (sheetObj) {
                     // 높이 설정
                     style.height = GetSheetHeight(5);
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(6, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle  = "|Seq.|CNTR No.|From YD|From DT|BKG No.";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,	"ibflag");
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"seq");
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"cntr_no",		false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"fm_mvmt_yd_cd",false,	"",	dfNone,		0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"fm_mvmt_dt",	false,	"",	dfDateYmd,	0,	false,	true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"bkg_no",		false,	"",	dfNone,		0,	false,	true);	
            	 } // with - end
                 break;    
                 
         } // swith - end
     }
     

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
         	case IBGETPODETA:	//POD ETA 날짜 조회
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoAllSave("EES_DMT_3106GS.do", FormQueryString(formObj));
				break;

 			case IBGETVDMVMT:	// VD Movement Date 조회
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				formObj.f_cmd.value = MULTI02;
 				var sheetObj2 = sheetObjects[1];
 				sheetObj2.DoAllSave("EES_DMT_3106GS.do", FormQueryString(formObj));
 				break;
                 
 			case IBSAVE:		//저장
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				//formObj.f_cmd.value = MULTI;
 				//sheetObj.DoSave("EES_DMT_3106GS.do", FormQueryString(formObj),"chk");
 			
	 			ComOpenWait(true);
	         	sheetObj.WaitImageVisible = false;
	         	
	         	formObj.f_cmd.value = COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "MPODETA");
	         	var params = sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_3106GS.do", params);
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.WaitImageVisible = false;
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}
 				break;
         }
     }
   
   
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
   function getBackEndJobStatus() {
 	 	var formObj = document.form;
 	 	var sheetObj = sheetObjects[0];
 	
 	 	//It gets a status of backendjob. 2
 	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
 	
 	 	var params		= "f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
 	 	var sXml		= sheetObj.GetSearchXml("EES_DMT_3106GS.do", params);
 	 	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");
 	 	
 	 	// jobState == "2" BackEndJob 진행중......
 	 	if (jobState == "3") {
 	 		clearInterval(timer);
 	 		// BackEndJob이 성공 하였습니다.
 	 		getBackEndJobLoadFile();
 	 	}
 	 	else if (jobState == "4") {
 	 		clearInterval(timer);
 	 		// BackEndJob을 실패 하였습니다.
 	 		var jbUsrErrMsg	= ComGetEtcData(sXml, "jb_usr_err_msg");
 	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
 	 			ComShowMessage(jbUsrErrMsg);
 	 		else
 	 			ComShowCodeMessage("DMT01125");
 	 		
 	 		ComOpenWait(false);
 	 	}
 	 	else if (jobState == "5") {
 	 		clearInterval(timer);
 	 		// 이미 BackEndJob 결과 파일을 읽었습니다.
 	 		ComShowCodeMessage("DMT01125");
 	 		ComOpenWait(false);
 	 	}
	}

 	// BackEndJob 성공종료시 결과데이터를 반영한다. 
 	function getBackEndJobLoadFile() {
 	 	var formObj = document.form;
 	 	var sheetObj = sheetObjects[0];
 	
 	 	//It returns a result. 3
 	 	ComOpenWait(false);
 	 	
 	 	var fCmd = MULTI;
 	 	ComSetObjValue(formObj.f_cmd, fCmd);
 	 	
 	 	var params = "f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
 	 	var sXml = sheetObj.GetSaveXml("EES_DMT_3106GS.do", params);
 	 	sheetObj.LoadSaveXml(sXml);
 	}

   
	//Check box 클릭시  AllCheck box 상태 동기화 처리
	function sheet1_OnClick(sheetObj, row, col, Value){
 		if(sheetObj.ColSaveName(col) == "chk")
 			ComSyncAllCheck(sheetObj, col, Value);
 	}
   

	//팝업버튼 Click 이벤트 처리
	function sheet1_OnPopupClick(sheetObj, row,col){
		if (sheetObj.ColSaveName(col) == "fm_mvmt_dt") {
			var cal = new ComCalendarGrid("myCal");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		}
	}
	
	
	/**
  	 * sheet1 저장후 처리
  	 */
  	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
  		if(ErrMsg == '') {
  			if(document.form.f_cmd.value == MULTI) {
	  			var opener = window.dialogArguments;
				opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
				self.close();
  			}
  		}
  	}
  	
     
  	/**
     * sheet2 저장후 처리
     */
  	function sheet2_OnSaveEnd(sheetObj,ErrMsg) {
  		if(ErrMsg == '') {
  			var formObj = document.form;
  			var sheetObj1 = sheetObjects[0];
  			
  			for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
  				var fmMvmtDt = sheetObj.CellValue(i, "fm_mvmt_dt");
  				var seq = sheetObj.CellValue(i, "seq");
  				
  				var rowIdx = sheetObj1.FindText("seq", seq);
  				if(rowIdx != -1)
  					sheetObj1.CellValue(rowIdx, "fm_mvmt_dt") = fmMvmtDt;
  			}
  			
  			DmtComEnableManyBtns(true, "btn_Save", "btn_Update");
  		}
  	}
     
     
     /**
      * Update 버튼 기능을 처리한다.
      */
     function processUpdate() {
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 
    	 if(!ComIsDate(formObj.upd_fm_dt, "ymd")) {
    		 ComShowCodeMessage('DMT02002', 'Update From Date');
    		 ComSetFocus(formObj.upd_fm_dt);
    		 return;
    	 }
    	 
    	 /*
    	 ComChkPeriod(fromDate, toDate)
    	 0 : fromDate > toDate
    	 1 : fromDate < toDate
    	 2 : fromDate = toDate
    	 */
    	 var updFmDt = ComGetUnMaskedValue(formObj.upd_fm_dt, "ymd");
    	 var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
    	
		 if(ComChkPeriod(updFmDt, ofcCurrDate) == 1) {
  			ComShowCodeMessage('DMT01062');
  			ComSetFocus(formObj.upd_fm_dt);
  			return;
		 }
		 
		 if(sheetObj.CheckedRows("chk") == 0) {
  			ComShowCodeMessage('COM12113', 'CNTR');
  			return;
		 }
  		
		 var chkRows = sheetObj.FindCheckedRow("chk").split("|");
		 for(var i=0; i < chkRows.length-1; i++) {
			 sheetObj.CellValue(chkRows[i], "fm_mvmt_dt") = updFmDt;
		 }
     }     
     
     
  	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 
         with(formObj){
        	 
        	 switch(sAction) {
        	 	case IBGETVDMVMT:
        	 		if(sheetObj.CheckedRows("chk") == 0) {
        	  			ComShowCodeMessage('COM12113', 'CNTR');
        	  			return false;
        			 }
        	  		
        	 		var sheetObj2 = sheetObjects[1];
        	 		
        	 		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
        	 		var sXml = ComMakeSearchXml(sheetObj, false, "chk", "seq|cntr_no|fm_mvmt_yd_cd|bkg_no");
        	 		
        	 		sheetObj2.RemoveAll();
        	 		//sheet2로 조회XML 로드하기
        	 		sheetObj2.LoadSearchXml(sXml, true);
	    	 		break;
        	 
	    	 	case IBSAVE:
	    	 		var chkRows = sheetObj.CheckedRows("chk");
	    	 		if(chkRows == 0) {
             			ComShowCodeMessage('COM12113', 'CNTR');
             			return false;
             		} else if(chkRows > 100) {
             			ComShowCodeMessage('DMT01080', '100 cntrs');
             			return false;
             		}
             		
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow = chkRows[i];
             			var fmMvmtDt	= sheetObj.CellValue(chkRow, "fm_mvmt_dt");
             			var cntrNo		= sheetObj.CellValue(chkRow, "cntr_no");
             			
         				if(fmMvmtDt == '') {
         					ComShowCodeMessage('DMT01064', 'From Date', cntrNo);
         					sheetObj.SelectRow = chkRow;
         					return false;
         				}
         				
         		    	 /*
         		    	 ComChkPeriod(fromDate, toDate)
         		    	 0 : fromDate > toDate
         		    	 1 : fromDate < toDate
         		    	 2 : fromDate = toDate
         		    	 */
         		    	 var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
         		    	 
         				 if(ComChkPeriod(fmMvmtDt, ofcCurrDate) == 1) {
         		  			ComShowCodeMessage('DMT01062');
         		  			sheetObj.SelectRow = chkRow;
         		  			return false;
         				 }
         				
         				 var etaDt = sheetObj.CellValue(chkRow, "vps_eta_dt");
         				 var dtGap = ComGetDaysBetween(fmMvmtDt, etaDt);
         				 
         				 if(Math.abs(dtGap) > 10) {
         					ComShowCodeMessage('DMT01055', cntrNo);
         					sheetObj.SelectRow = chkRow;
         					return false;
         				 }
             		}
            		
            		// 중복된 BKG/CNTR 가 있을 경우 막는다.
            		var dupRows = sheetObj.ColValueDupRows("chk|cntr_no");
            		if(dupRows != '') {
    	        		var arrRow = dupRows.split(",");
    	        		
    	        		for(var i=0; i<arrRow.length; i++) {
    	        			var chk = sheetObj.CellValue(arrRow[i], "chk");
    	        			if(chk == '0')
    	        				continue;
    	        			else {
    	        				var dupCntrNo = sheetObj.CellValue(arrRow[i], "cntr_no");
    	        				
    	    		        	ComShowCodeMessage('DMT01065', dupCntrNo);
    	    		        	sheetObj.SelectRow = arrRow[i];
    	    		        	return false;
    	        			}
    	        		}
            		}
             		
             		if(!ComShowCodeConfirm('DMT01056'))
             			return false;
	    	 		
	    	 		break;
        	 }		
         }

         return true;
     }


	/* 개발자 작업  끝 */