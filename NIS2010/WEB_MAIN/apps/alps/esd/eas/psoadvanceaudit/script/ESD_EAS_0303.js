/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : ESD_EAS_0303.js
*@FileTitle : Pre-Audit Criterion setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.24 백형인
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
     * @class ESD_EAS_0303 : ESD_EAS_0303 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0303() {
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

    
	//공통전역변수
    var frm = null;
    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	
	// offce_level 설정
	// 1 : 본부, 2:RQH, 3: 기타
	var ofcLevel="";
	
	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 	var change = 0;

	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	 				
	 				break;
	 			case "btn_save":
	 				doActionIBSheet(sheetObjects[0],document.form,MULTI01);
	 				break;
	 			case "btn_downexcel":
	 				doActionIBSheet(sheetObjects[0],document.form,"btn_downexcel","","");
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		var frm = document.form;
		var usrId = frm.usr_id.value;
//		비용심사 파트장 성범수 부장 :  사번 9100342
//  	비용심사 시스템 B/A 김대준 차장 : 사번  0010140
		if(usrId !="9100342" && usrId!="0010140"){
			ComBtnDisable("btn_save"); // Save 버튼 비활성화
		}
		
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		doActionIBSheet(sheetObjects[0], frm,"s_aud_ofc_cd");
		doActionIBSheet(sheetObjects[0], frm, "offce_level");
	    initControl();

	}
    
 	function initControl() {
//        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
//        axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
	}    
 	

 	
 	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {  
		case  "s_chg_tp_cd": 
			   comboObj.RemoveAll();
			   comboObj.InsertItem(0, "", "");
			   comboObj.InsertItem(1, "PORT CHARGE", "01");
			   comboObj.InsertItem(2, "PORT SERVICE CHARGE", "02");
			   comboObj.InsertItem(3, "CANAL TRANSIT FEE", "03");
			   comboObj.InsertItem(4, "OTHER", "04");
			   comboObj.Index=0;
	    break;
		case  "s_auto_acd": 
			   comboObj.RemoveAll();
			   comboObj.InsertItem(0, "", "");
			   comboObj.InsertItem(1, "YES", "Y");
			   comboObj.InsertItem(2, "NO", "N");
			   comboObj.Index=0;
		break;
		}
	}
	 
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {

	 	var cnt = 0;

	 	switch(sheetNo) {
	    	case 1:      //sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(22);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|Seq.|RHQ|Charge type|Account\ncode|Account name|Cost\ncode|Cost\nDescription|Objective\nof Auto Audit|Max.\nPermissible Ratio(%)|Update Date|Remark";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

//					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,		35,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "aud_ofc_cd",         false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "chg_tp_nm",          false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "acct_cd",            false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "acct_nm",            false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "cost_cd",            false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "cost_nm",            false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtCheckBox,     100,  	daCenter,   true,   "lgs_cost_aud_flg",	  false,    "",      dfNone,          0,          true,         true,    1);
					InitDataProperty(0, cnt++ , dtData,         150,  	daRight,    true,   "expn_max_prmt_rto",  false,    "",      dfNullFloat,     2,          true,         true,    5);
					InitDataProperty(0, cnt++ , dtData,          80,  	daCenter,   true,   "upt_dt",  			  false,    "",      dfNone,          0,          true,         true,    500);
					InitDataProperty(0, cnt++ , dtData,         170,  	daLeft,     true,   "expn_prmt_rto_rsn",  false,    "",      dfNone,          0,          true,         true,    500);
					
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
					
				}
				break;

			}
		}	
	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		var frm = document.form;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
//				if(validateForm(sheetObj,frm,sAction)){
					sheetObjects[0].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0303GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
//				}
				break;
			case MULTI01:
//				if(validateForm(sheetObj,frm,sAction)){
				
				ComOpenWait(true);
				
				frm.f_cmd.value = MULTI01;
	         	var params = sheetObjects[0].GetSaveString(false, true)  + "&" + FormQueryString(frm);
	         	var sXml = sheetObjects[0].GetSaveXml("ESD_EAS_0303GS.do", params);				
				
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('COM130102', 'Data');
				}
				break;


			case "btn_downexcel":	// EXCEL DOWNLOAD
//				sheetObj.SpeedDown2Excel(1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
				
	  		case "s_aud_ofc_cd":    
    			//RHQ 콤보 리스트 조회
    			frm.s_aud_ofc_cd.RemoveAll();
    			frm.f_cmd.value = COMMAND02;
    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
    			ComXml2ComboItem(sXml, frm.s_aud_ofc_cd, "ofc_cd", "ofc_cd");
    			loadFlag = 1;
    			frm.s_aud_ofc_cd.Index = 0;
	  		break;
	  		
			case "offce_level":    
				frm.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");

//        		if(ofcLevel=="O"){
//        			// 본사(심사팀) RHQ 소속이외
//        			document.all.btnSaveLayer.style.display = "none";                    
//        		}else if(ofcLevel=="R"){
//        			document.all.btnSaveLayer.style.display = "none";                    
//        		}else if(ofcLevel=="H"){
//        			document.all.btnSaveLayer.style.display = "";
//        		}
        		
	  		break; 	
	  		
		}
	}
	
	
	var loadFlag = 0;
	function s_aud_ofc_cd_OnChange(comboObj,Index_Code, Text){
		if(loadFlag==1){
			loadFlag = 0
			frm.s_aud_ofc_cd.InsertItem(0, "", "");
		}
		
	}
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case REMOVE01 :
	 		 if(sheetObj.RowCount == 0){
	 			 //alert("조회된 데이터가 없습니다.");
	 			ComShowCodeMessage('COM12189');
	 			return false;
	 		 }
	 		for(var i=1;i<=sheetObj.RowCount;i++){
	 			if(1==sheetObj.CellValue(i, 2)){
	 				return true;
	 			}
	 		}
	 		ComShowCodeMessage('COM12113', 'Data.');
 			return false;
	 		 break;
	 	 } // end switch()
	 	 return true;
	  }	 
	  
	  
	  
	// ===================================================================================
	// Sheet 이벤트 처리
	// ===================================================================================

	 
	/* 개발자 작업  끝 */