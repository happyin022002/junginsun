/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_VSK_0290.js
*@FileTitle : ETA sending[Auto FLX/TLX]
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 황태진 
*@LastVersion : 1.0
* 2012.12.06 황태진 
* 1.0 Creation
* History
* 2012.12.20 CHM-201221649-01 황태진  ETA sending[Auto-Fax] 정보 저장
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
 * @class VOP_VSK_0290 : VOP_VSK_0290 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0290() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initCombo 				= initCombo;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var comboObjects = new Array();
 var comboCnt = 0;

 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      
      var sheetObject = sheetObjects[0];
      
      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);   
				////window.close();
				break;
			case "btn_close":
				window.close();
				break;
			case "trsm_mzd_chk":
				loadPage();
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
}
 
  
 
 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     for(i=0;i<comboObjects.length;i++){
         initCombo(comboObjects[i],i+1);
     }
     initControl();
     setUnformData();   // 날짜 포맷 초기화 
     setFormData();     // 날짜 포맷  
     setTrsmEmlValue(); // Transmit Method(FAX/TLX)에 따른  메일 세팅 
 }
 
 
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "/";
	var formObj = document.form;
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('focus', 'obj_focus', formObj);
	axon_event.addListener('keypress', 'enter_keypress', 'form');		//- Enter 키 처리
	axon_event.addListenerForm('change', 'obj_change' , 	form);	
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "int":
	        //숫자 만입력하기
	        ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
	        //숫자+"."입력하기
	        ComKeyOnlyNumber(event.srcElement, ".");
			break;
		default:
	        //숫자만입력하기
	        ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	    var formObj = document.form;
	    switch(comboObj.id) {
    	case "imst_cd":
			with (comboObj) { 
         	    RemoveAll();
				MultiSelect = false;
				UseAutoComplete = true;
				DropHeight = 160;
				MaxSelect = 1;
				IMEMode = 0;
				ValidChar(2, 1);
				MaxLength = 1;
 				if (formObj.trsm_mzd_chk[0].checked) {

                	//TELEX Inmarset code
               	    InsertItem(i++, "0581", "0581");
    				InsertItem(i++, "0582", "0582");
    				InsertItem(i++, "0583", "0583");
    				InsertItem(i++, "0584", "0584");
    				Code = formObj.tlx_imst_cd.value; 
    				if (formObj.vsl_tlx_no.value == "") {
						ComBtnDisable("btn_save");
                    } else {
                    	ComBtnEnable("btn_save");
                    }
                    	
 				}
                else {

                	//FAX Inmarset code
 					InsertItem(i++, "870", "870");
    				InsertItem(i++, "871", "871");
    				InsertItem(i++, "872", "872");
    				InsertItem(i++, "873", "873");
    				InsertItem(i++, "874", "874");
    				Code = formObj.fax_imst_cd.value; 

    				if (formObj.vsl_fax_no.value == "") {
						ComBtnDisable("btn_save");
                    } else {
                    	ComBtnEnable("btn_save");
                    }
                }
			}
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
         case 1:      // sheet1 init
             with (sheetObj) {
            	 tabIndex = -1;
 		          // 높이 설정
		         style.height = 0;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;
                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;
                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(24, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 var HeadTitle = "vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq|yd_cd|trsm_mzd_cd|trsm_ownr_cd|slan_cd|act_crr_cd|vps_eta_dt|vps_etb_dt|ntc_eta_dt|ntc_etb_dt|ntc_etd_dt|trsm_rsn|vsl_fax_no|vsl_tlx_no|vsl_eml|imst_cd|vsl_fax_trsm_eml|intl_tlx_no|vsl_tlx_trsm_eml";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);
                 
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag",			false,	"",      	dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vsl_cd",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"skd_voy_no",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"skd_dir_cd",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vps_port_cd",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"clpt_ind_seq",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"yd_cd",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"trsm_mzd_cd",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"trsm_ownr_cd",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"slan_cd",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"act_crr_cd",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vps_eta_dt",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vps_etb_dt",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"ntc_eta_dt",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"ntc_etb_dt",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"ntc_etd_dt",		false,	"",			dfNone,			0,			false,		false);
				
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"trsm_rsn",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vsl_fax_no",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vsl_tlx_no",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vsl_eml",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"imst_cd",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vsl_fax_trsm_eml",	false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"intl_tlx_no",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"vsl_tlx_trsm_eml",	false,	"",			dfNone,			0,			false,		false);
 					//CountPosition = 0;
 			}
            break;
     }
 }

 /**
  * 시트 관련 프로세스 처리 
  * param : sheetObj ==> 시트오브젝트, formObj ==> 폼오브젝트 , sAction ==> 이벤트(save - insert)
  */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     sheetObj.WaitImageVisible = false;
     switch(sAction) {
         case IBSAVE:         //저장
         
    		if(validateForm(sheetObj,formObj,sAction)){
	            ComOpenWait(true);
	            formObj.f_cmd.value = ADD;
				formObj.ibflag.value = "I";
				setUnformData(); //날짜 언포맷 
				
				//if (formObj.trsm_mzd_cd.value == "FAX") {
				//	alert(formObj.vsl_fax_trsm_eml.value);
				//} else {
				//	alert(formObj.vsl_tlx_trsm_eml.value);
				//}
				
				var rXml = sheetObj.GetSaveXml("VOP_VSK_0290GS.do", FormQueryString(formObj));
				if (ComGetEtcData(rXml,"TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage('VSK02001');		//"Sked change notice has been sent successfully."
					window.dialogArguments.doActionIBSheet(window.dialogArguments.sheetObjects[0], window.dialogArguments.document.form, IBSEARCH);
					window.close();
				} else{
					ComShowCodeMessage('VSK02002');		//"Sked change notice has not been sent, Please Try Again !"
				}     			
	    		ComOpenWait(false);
    		}
	    	break;
	    	
     }
 }

/**
  * 저장시 필수 폼 입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
	    if (ComIsNull(formObj.vsl_cd.value)) {
		    ComShowCodeMessage('VSK00027', "Vessel Code");
			return false;
		}
	    if (ComIsNull(formObj.skd_voy_no.value)) {
			ComShowCodeMessage('VSK00027', "Vessel Voyage No");
			return false;
		}
	    if (ComIsNull(formObj.skd_dir_cd.value)) {
		    ComShowCodeMessage('VSK00027', "Direction Code");
			return false;
		}
	    if (ComIsNull(formObj.vps_port_cd.value)) {
		    ComShowCodeMessage('VSK00027', "Pord Code");
			return false;
		}
	    if (ComIsNull(formObj.clpt_ind_seq.value)) {
		    ComShowCodeMessage('VSK00027', "Calling Port Indicator Seq");
			return false;
		}
	    if (ComIsNull(formObj.ntc_eta_dt.value)) {
		    ComShowCodeMessage('VSK00027', "NOTICE ETA DATE");
			return false;
		}
	    if (ComIsNull(formObj.slan_cd.value)) {
		    ComShowCodeMessage('VSK00027', "Service Lane Code");
			return false;
		}
	    
	    if (ComIsNull(formObj.trsm_rsn.value)) {
		    ComShowCodeMessage('VSK00027', "Reason");
		    formObj.trsm_rsn.focus();
			return false;
		}	    
	    if (ComIsNull(formObj.sndr_nm.value)) {
		    ComShowCodeMessage('VSK00027', "PIC Name");
		    formObj.sndr_nm.focus();
			return false;
		}	    
	    if (ComIsNull(formObj.sndr_phn_no.value)) {
		    ComShowCodeMessage('VSK00027', "Phone No.");
		    formObj.sndr_phn_no.focus();
			return false;
		}	    
	    
     }
     return true;
 }
 
 
/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

/**
 * 조회 시 날짜 포맷 
 */
function setFormData(){
	var formObj = document.form;
	formObj.vps_eta_dt.value = VskReplaceUserDate(formObj.vps_eta_dt.value);
    formObj.vps_etb_dt.value = VskReplaceUserDate(formObj.vps_etb_dt.value);
    formObj.vps_etd_dt.value = VskReplaceUserDate(formObj.vps_etd_dt.value);
    formObj.ntc_eta_dt.value = VskReplaceUserDate(formObj.ntc_eta_dt.value);
    formObj.ntc_etb_dt.value = VskReplaceUserDate(formObj.ntc_etb_dt.value);
    formObj.ntc_etd_dt.value = VskReplaceUserDate(formObj.ntc_etd_dt.value);
 }

 /**
  * 저장 시 날짜 언포맷 
  */
 function setUnformData(){
 	var formObj = document.form;
    formObj.vps_eta_dt.value = ComGetUnMaskedValue(formObj.vps_eta_dt.value,"ymdhms");
    formObj.vps_etb_dt.value = ComGetUnMaskedValue(formObj.vps_etb_dt.value,"ymdhms");
    formObj.vps_etd_dt.value = ComGetUnMaskedValue(formObj.vps_etd_dt.value,"ymdhms");
    formObj.ntc_eta_dt.value = ComGetUnMaskedValue(formObj.ntc_eta_dt.value,"ymdhms");
    formObj.ntc_etb_dt.value = ComGetUnMaskedValue(formObj.ntc_etb_dt.value,"ymdhms");
    formObj.ntc_etd_dt.value = ComGetUnMaskedValue(formObj.ntc_etd_dt.value,"ymdhms");
 }

  /**
   * Inmarset Codmo 값에 따른  fax_imst_cd, tlx_imst_cd , vsl_fax_trsm_eml, vsl_tlx_trsm_eml 값 변경  
   */
  function imst_cd_OnChange(comboObj, comboText, comboValue){
	 setTrsmEmlValue();
 }
  
  /**
   * trsm_mzd_cd radio 값에 따른 trsm_mzd_cd , fax_imst_cd, tlx_imst_cd , vsl_fax_trsm_eml, vsl_tlx_trsm_eml 값 변경 
   */
  
 function setTrsmEmlValue(){
	var formObj = document.form;
	if (formObj.trsm_mzd_chk[0].checked) {

		formObj.trsm_mzd_cd.value 	   =   "TLX";
		formObj.tlx_imst_cd.value 	   =   formObj.imst_cd.Code;
		formObj.vsl_tlx_trsm_eml.value =   "TLX."+formObj.imst_cd.Code + formObj.vsl_tlx_no.value +"@ipmsg.com";
	} else {
		formObj.trsm_mzd_cd.value 	   =   "FAX";
		formObj.fax_imst_cd.value 	   =   formObj.imst_cd.Code;
		formObj.vsl_fax_trsm_eml.value =   "FAX."+formObj.imst_cd.Code + formObj.vsl_fax_no.value +"@ipmsg.com";
	}
}  

/* 개발자 작업  끝 */