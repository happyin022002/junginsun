/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_02a.js
*@FileTitle : TRO(Transportation Request Order) for General
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.05.19 이남경
* 1.0 Creation
===============================================================================
 History
* 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
* 2010.09.17 전성진 [CHM-201005982] [ESM-BKG] 미주지역 TRO 화면상에 W/O preview 버튼 추가 (TRS 정보 link)
* 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
* 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.12.13 금병주 [CHM-201114899-01] 미주 TRO 화면 Validation 추가 (Special cargo seq.)
* 
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
     * @class esm_bkg_0079_02a : esm_bkg_0079_02a 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0079_02a() {
    	this.processButtonClick		    = tprocessButtonClick;
    	this.setSheetObject 		    = setSheetObject;
    	this.setComboObject             = setComboObject; 
    	this.loadPage 				    = loadPage;
    	this.initSheet 				    = initSheet;
		this.initCombo                  = initCombo; 
    	this.initControl                = initControl;
    	this.doActionIBSheet 		    = doActionIBSheet;
    	this.setTabObject 			    = setTabObject;
    	this.validateForm 			    = validateForm;
    	this.obj_keypress_loc           = obj_keypress_loc;
    	this.obj_keyup                  = obj_keyup;
    	this.initSearchVal              = initSearchVal;
        this.tro_seq_OnChange           = tro_seq_OnChange;
        this.changeTroSeqProc           = changeTroSeqProc;
        this.t2asheet1_OnPopupClick     = t2asheet1_OnPopupClick;
		this.dcgo_seq_OnCheckClick      = dcgo_seq_OnCheckClick;
		this.rc_seq_OnCheckClick        = rc_seq_OnCheckClick;
		this.awk_cgo_seq_OnChange       = awk_cgo_seq_OnChange;		
		this.t2asheet2_OnSaveEnd        = t2asheet2_OnSaveEnd;
		this.t2asheet1_OnChange         = t2asheet1_OnChange;
		this.addRow                     = addRow;
		this.setDefaultInsertRow        = setDefaultInsertRow;
		this.setDefaultInsertRow_Dtl    = setDefaultInsertRow_Dtl;
		this.copyRow                    = copyRow;
		this.setDataCopy                = setDataCopy;
		this.setDataCopy_dtl            = setDataCopy_dtl;    
		this.copyTrodgseq               = copyTrodgseq;		
		this.confirmSave                = confirmSave;
		this.cancelAll                  = cancelAll;
		this.cancelSeq                  = cancelSeq;
		this.cancelDtl                  = cancelDtl;
		this.copyAllRow_dtl             = copyAllRow_dtl;		
		this.changeTroQtyColor          = changeTroQtyColor;
		this.changeSumTroQty            = changeSumTroQty;
		this.plusMinusSumTroQty         = plusMinusSumTroQty;
		this.checkCopySumTroqty         = checkCopySumTroqty;		
        this.setDataToForm_TroMst       = setDataToForm_TroMst; 
        this.setFormToData_TroMst       = setFormToData_TroMst;  
        this.setAllDataToData_TroDtl    = setAllDataToData_TroDtl;
        this.setDataToAllData_TroDtl    = setDataToAllData_TroDtl;
        this.deleteRowDtlAll            = deleteRowDtlAll;        
        this.setEtcDataToForm_bkg       = setEtcDataToForm_bkg;
        this.setDataToForm_Tro_dg_seq   = setDataToForm_Tro_dg_seq;
        this.setFormToData_Tro_dg_seq   = setFormToData_Tro_dg_seq;
        this.getPrevMaxTroSeq           = getPrevMaxTroSeq;
        this.comboCodeToSheet           = comboCodeToSheet;
        //this.setSheetAllRowHidden       = setSheetAllRowHidden;
        this.changeSumTroQty            = changeSumTroQty;
        this.plusMinusSumTroQty         = plusMinusSumTroQty;
        this.setAddRemarkText           = setAddRemarkText;        
        this.changeDisplayBtn           = changeDisplayBtn; 
        //this.setRowDelStatus            = setRowDelStatus; 
        //this.setRowDelStatus_chkall     = setRowDelStatus_chkall;
        this.changeMasterColor            = changeMasterColor;
        this.changeEnabled_master_control = changeEnabled_master_control;
        this.changeEnabled_master         = changeEnabled_master;
        this.changeEnabled_cfmFlg         = changeEnabled_cfmFlg;
        this.setRowDelColorChange         = setRowDelColorChange; 
        this.setChangeAllComboBackColor = setChangeAllComboBackColor;
        this.setComboBackColor          = setComboBackColor;        
        this.changeAllCellEditable      = changeAllCellEditable;
        this.checkTdDisabled            = checkTdDisabled;        
        this.checkDtl                   = checkDtl;
        this.checkMaster                = checkMaster;        
        this.setActCustCallBack         = setActCustCallBack;
		this.getCOM_ENS_061_1           = getCOM_ENS_061_1;
    }
    
   	/* 개발자 작업  */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    

	//---------------------------------
    //순서에 관계없이 명칭을 사용하기 위해, 전역변수화 
    var x_sheetObject1 = null;
    var x_sheetObject2 = null;
    var x_sheetObject3 = null;
    var x_sheetObject4 = null;
    var x_sheetObject5 = null;
    var x_sheetObjMsg  = null;
    
    var x_oldTroSeq    = "";   //이전에 선택된  tro_seq 값  
    var x_cancelAllFlg = "N";  //Y:cancelAll 처리됨  
    var xNessColor     = "#CCFFFD";
    var tab_alert_msg = false; // 메세지 표시유무 
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display == ""){
        			layList.style.display = "none";
        		}  
    		}
    		
    		switch(srcName) {
				case "btn_splitPop":
					doActionIBSheet(x_sheetObjMsg, formObject, COMMAND03);	
					break; 
			    case "btn_Danger":
			    	if(checkTdUnLink(srcName)) return false;    
			    	var bkgNo = formObject.bkg_no.value;
			    	var caFlg = formObject.ca_flg.value;
			    	comBkgCallPop0200(bkgNo, caFlg);
			    	break;
			    case "btn_Reefer":
			    	if(checkTdUnLink(srcName)) return false;    		
			    	var bkgNo = formObject.bkg_no.value;
			    	var caFlg = formObject.ca_flg.value;
			    	comBkgCallPop0498(bkgNo, caFlg);
			    	break;
			    case "btn_Awkward":
			    	if(checkTdUnLink(srcName)) return false;    	
			    	var bkgNo = formObject.bkg_no.value;
			    	var caFlg = formObject.ca_flg.value;
			    	comBkgCallPop0055(bkgNo, caFlg);
			    	break;
			    case "btn_Bulk":
			    	if(checkTdUnLink(srcName)) return false;  
			    	var bkgNo = formObject.bkg_no.value;
			    	var caFlg = formObject.ca_flg.value;
			    	comBkgCallPop0106(bkgNo, caFlg);
			    	break;
    		    	
				case "btn_t2aAdd":
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject2.RowCount <= 0) {
						callShowMessageAddSeq();
						return false;
					}
					addRow(x_sheetObject1);   
					break;
	
				case "btn_t2aDelete":
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount <= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var nRow = x_sheetObject1.CheckedRows("del_chk");
					if (nRow <= 0) {
						ComShowCodeMessage("BKG00567");
						return false;
					}					
					if (!ComShowCodeConfirm("COM12194", "")) {
        	    		return false;
        	    	} 
				    //setRowDelStatus(x_sheetObject1, "del_chk");
				    //setRowDelStatus_chkall(x_sheetObject1, "del_chk");
				    cancelDtl();
				    doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					break;
	
				case "btn_t2aCopy": 
					if(checkTdDisabled(srcName)) return false;	
					if (x_sheetObject2.RowCount <= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var bResult = checkCopySumTroqty(x_sheetObject1);
					if (!bResult) {						
						return false;
					}
					copyRow(x_sheetObject1);
					break;
	
				case "btn_t2aRetrieve":
					if(checkTdDisabled(srcName)) return false;						
					formObject.curr_tro_seq.value = "";  //default 순번 clear
					doActionIBSheet(x_sheetObject2, formObject, IBSEARCH);
					break;
	
				case "btn_t2aSave":	
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE);
					break;
					
				case "btn_t2aSaveSeq":  //단건 Seq만 저장
				    doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "C");
					break;
					
				case "btn_t2aSaveConfirm":
					if(checkTdDisabled(srcName)) return false;					
					//if (!ComBkgProcessYn("Confirm & Save")) {
					if (!ComBkgProcessYn("All Confirm & Save")) {
        	    		return false;
        	    	}
					confirmSave();
					break;
	
				case "btn_t2aCancelAll":
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount <= 0) {						
						callShowMessageAddSeq();
						return false;
					}						
					if (x_cancelAllFlg == "Y") {
						callShowMessageReProc("Cancel All");
						return false;
					}
					if (!ComBkgProcessYn("CANCEL All")) {
        	    		return false;
        	    	} 
					cancelAll();
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "YA");
					break;
					
				case "btn_t2aTROCopy":		
                    if(checkTdDisabled(srcName)) return false;
					var bkgNo    = nullToBlank(formObject.bkg_no.value);
					var bkgNoOld = nullToBlank(formObject.oldBkgNo.value); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkgNo != bkgNoOld) {
						ComShowCodeMessage("BKG00048", bkgNoOld, bkgNo);
						ComSetFocus(bkg_no);
						return false;
					}
					var boundCd = ""; 
					var troSeq  = nullToBlank(formObject.tro_seq.Text); 
					var uiId    = "ESM_BKG_0079_02A";
					comBkgCallPop0920('setTroCopy', bkgNo, boundCd, troSeq, uiId); 
					break;
					
				case "btn_t2aAddSeq":
					if(checkTdDisabled(srcName)) return false;
					addRow(x_sheetObject2);   
					break;
	
				case "btn_t2aCopySeq":
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount <= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var bResult = checkCopySumTroqty(x_sheetObject2);
					if (!bResult) {
						return false;  
					}
					copyRow(x_sheetObject2);
					break;
	
				case "btn_t2aCancelSeq":	
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount <= 0) {
						callShowMessageAddSeq();
						return false;
					}						
					if (formObject.cxl_flg.checked) {
						callShowMessageReProc("Cancel Seq");
						return false; 
					}
					if (!ComBkgProcessYn("CANCEL Seq")) {
        	    		return false;
        	    	} 
			        cancelSeq();
			        doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					break;
					
				case "btns_popActCust":
					if(checkInputDisabled("act_shpr_nm")) return false; 
					var conti_cd        = document.form.conti_cd.value;            //hidden : 대륙코드 
					var cnt_cd          = document.form.por_cd.value.substr(0,2);  //국가코드 -> 사용않함
					var dor_loc_cd      = document.form.dor_loc_cd.value; 
					var act_shpr_cnt_cd = document.form.act_shpr_cnt_cd.value; 
					var act_shpr_seq    = document.form.act_shpr_seq.value; 
					var act_shpr_nm     = document.form.act_shpr_nm.value; 
					var arrAct_shpr_nm  = act_shpr_nm.split(" ");
					act_shpr_nm = arrAct_shpr_nm[0];
					var bkg_no          = nullToBlank(formObject.bkg_no.value);
					var bkg_no_old      = nullToBlank(formObject.oldBkgNo.value); 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm);
					break;
	
				case "btns_popLocation":					
					if(checkInputDisabled("zn_cd")) return false;					
					var cnt_cd     = document.form.por_cd.value.substr(0,2);  //국가코드 -> 사용않함
					var node_cd    = "";
					var dor_loc_cd = formObject.dor_loc_cd.value;
					var zn_cd      = formObject.zn_cd.value;					
					if (dor_loc_cd.length == 5 && zn_cd.length == 2) { 
						node = dor_loc_cd+zn_cd; 
					}					
					var param = "";
					param += "?cnt_cd="    + cnt_cd;
					param += "&loc_cd="    + dor_loc_cd;
					param += "&ofc_cd="    + "N";
					param += "&node_cd="   + node_cd;
					param += "&mode="      + "zone";
					param += "&mode_only=" + "Y";
					ComOpenPopup("/hanjin/COM_ENS_061.do"+param, 780, 470, 'getCOM_ENS_061_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;	
            }
    	}catch(e) {
    		ComShowMessage(e);
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
     	var formObj = document.form;
 	
   	    //버튼링크/버튼 출력처리 ------------->
   	    changeDisplayBtn("btn_Danger",  "N");
   	    changeDisplayBtn("btn_Reefer",  "N");
   	    changeDisplayBtn("btn_Awkward", "N");
   	    changeDisplayBtn("btn_Bulk",    "N");
   	    //<----------------------------------

         for(var i=0; i<sheetObjects.length; i++){
             ComConfigSheet   (sheetObjects[i]);
             initSheet        (sheetObjects[i], i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         //---------------
         //IBMultiCombo 초기화
         for(var k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k],k+1);
         } 
         
        //---------------
 		//iframe 생성 
 		//CofigIframe();
         
        //***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****
 	   	x_sheetObject5 = sheetObjects[0];  //sum_qty 화면
 	   	x_sheetObject1 = sheetObjects[1];  //tro_dtl 화면 
 	   	x_sheetObject2 = sheetObjects[2];  //tro all hidden
 	   	x_sheetObject3 = sheetObjects[3];  //tro_dtl all hidden
 	   	x_sheetObject4 = sheetObjects[4];  //tro_dg_seq all hidden
 	    x_sheetObjMsg  = sheetObjects[5];  //msg hidden
        //**************************************************************
 	   	  
 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form); 
 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form); 
 	   	axon_event.addListenerForm  ('click',    'obj_click',        document.form); 
 	   	axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
 		axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
 	   	if (formObj.bkg_no.value != "" || formObj.bl_no.value != "") {
 	   		formObj.curr_tro_seq.value = "";  //Seq default clear
             doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);
 	   	} else {
 	   		//Search버튼만 enabled
 	   		ComEnableManyTd(true,  "btn_t2aRetrieve");
 	   		ComEnableManyTd(false, "btn_t2aSave", "btn_t2aSaveSeq", 
 	   				                "btn_t2aSaveConfirm", "btn_t2aCancelAll", "btn_t2aTROCopy", 
                                    "btn_t2aAddSeq", "btn_t2aCopySeq", "btn_t2aCancelSeq", 
                                    "btn_t2aAdd", "btn_t2aDelete", "btn_t2aCopy");
 	   	}
 	   	
     	//------------------------------------------------>
     	//setInquiryDisableButton 이벤트 호출
     	if(ComGetObjValue(document.form.isInquiry) == "Y"){
     		setInquiryDisableButton();
     	}
    	initControl();
    	
    	if(ComGetObjValue(document.form.rhq_ofc_cd) == "NYCRA" || ComGetObjValue(document.form.usr_ofc_cd) == "PKGSA" 
    		|| ComGetObjValue(document.form.usr_ofc_cd) == "SELCMQ" || ComGetObjValue(document.form.usr_ofc_cd) == "SELCTY"){
    		document.getElementById("aloc_sts_cd").style.visibility = "visible";
    		document.getElementById("aloc_sts_cd").className = "input2";
    	} else {
    		document.getElementById("aloc_sts_cd").style.visibility = "hidden";
    		document.getElementById("aloc_sts_cd").className = "input2";
    	}
    }
     
	function initControl() {	
		applyShortcut();
	}

	// 업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress_loc() {
		switch(event.srcElement.dataformat){
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
	           //영문 대문자만 입력하기
	           ComKeyOnlyAlphabet('upper');
	           break;
	       case "int":
	           //숫자만입력하기(정수,날짜,시간)
	           ComKeyOnlyNumber(event.srcElement);
	           break;
	       case "uppernum":
	           //영문 대문자+숫자
	           ComKeyOnlyAlphabet('uppernum'); 
	           break;
	       case "tel":
		        // 숫자+"-"입력하기
		        ComKeyOnlyNumber(event.srcElement, " -"); 
		        break;
           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
	    	   break;
		}
	}
	function obj_keyup() {
		var formObj = document.form;
		var diffRmk = document.form.diff_rmk.value.length;
		with (formObj) {
			if(diffRmk > 1000){
				ComShowCodeMessage("BKG01137","1000");
				document.form.diff_rmk.value = document.form.diff_rmk.value.substring(0, 1000); 
		        }
			//textarea : enter 제외
			if (event.srcElement.type == "textarea") {
				return;
			}
			if ( window.event.keyCode == 13 ) { 
				formObj.curr_tro_seq.value = "";  //Seq default clear
		    }
		}
	}   

	function obj_click() {
		var formObj = document.form;
		with(formObj) {
			switch(event.srcElement.name){
	            case "cfm_flg":
	            	//var strToDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //local PC date 를 사용할 때, -> 아래로 대체함 
	            	//------------------------------------------------>
	            	//system date 조회해 온 값을 사용할 때,  !!!!!!!!!
	            	var bReturn  = doActionIBSheet(x_sheetObjMsg, formObj, COMMAND09);	            	
	            	var strToDay = formObj.cfm_sys_date.value;                     //cfm 대상row(check event발생한 화면row만) : cfm_dt변경 
	            	//<------------------------------------------------	            	
	            	
	            	var bResult = setCfmCheck(strToDay); 
	            	break;
			}
		}
	}

    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		MultiSeparator = "|";
    		
	    	switch(comboObj.id) {
			    case "tro_seq" : 
			    	SetColWidth("46");
			        break;

	    	    case "dcgo_seq" : 
	                SetColWidth("40|280");
	                SetTitle("seq|Remark");
	                MultiSelect = true;
	    	        break;
	    	    	
	    	    case "rc_seq" : 
	    	    	SetColWidth("40|380");
	    	    	SetTitle("seq|Remark");
	    	    	MultiSelect = true;
	    	    	break;
	    	        
	    	    case "awk_cgo_seq" : 
	    	    	SetColWidth("70");
	    	    	MultiSelect = true;
	    	        break;
	    	}
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
    	switch(sheetObj.id) {
    		case "t2asheet1":      //t2asheet1 init  
    			with (sheetObj) {
					// 높이 설정
					style.height = 120;
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
										
					var HeadTitle = "|Sel.|||Seq.|Del|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|"+
					                "Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|CNTR No.|Moved by Split|"+
					                "S/O|S/O|S/O|S/O|W/O|W/O|W/O||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false); 
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");  					
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,		"del_chk",		    	false,		"",	dfNone,		0,		true,		true);					
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,		"chk",		        	false,		"",	dfNone,		0,		true,		true);  //저장용 all-grid 보관시 사용됨 
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"tro_seq",          	false,      "", dfNumber,   0,      false,      false);					
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"tro_sub_seq",      	false,      "", dfNumber,   0,      false,      false);
					//InitDataProperty(0, cnt++ , dtData,     	30,		daCenter,	false,		"del",		        	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    30,		daCenter,	false,		"cxl_flg",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"cntr_tpsz_cd",	    	true,		"",	dfEngUpKey,	0,		true,		true, 4);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		"tro_qty",		    	false,		"",	dfNullInteger,	0,	false,      false, 11);
					InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	false,		"dor_arr_dt",	    	true,		"",	dfUserFormat2,	0,	true,		true);
					InitDataProperty(0, cnt++ , dtData,	        40,	    daCenter,	false,		"dor_arr_dt_hhmi",		true,		"",	dfTimeHm,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		"pkup_loc_cd",			false,		"",	dfEngKey,	0,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"pkup_yd_cd",	    	false,		"",	dfEngUpKey,	0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		"rtn_loc_cd",			false,		"",	dfEngUpKey,	0,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"rtn_yd_cd",	    	false,		"",	dfEngUpKey,	0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,			65,  	daCenter,	false,		"cmdt_cd",				false,		"",	dfNone,		0,		true,		true, 8);
					InitDataProperty(0, cnt++ , dtData,			80, 	daCenter,	false,		"cntr_no",		    	false,	    "",	dfEngUpKey,	0,		true,       true, 14);  //, true -> fullinput 
					InitDataProperty(0, cnt++ , dtData,			90,  	daCenter,	false,		"split_rmk",			false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"trsp_so_no",			false,	    "",	dfEngUpKey,	0,		false,      false, 18);  
					InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,		"so_cre_dt",			false,	    "",	dfNone,		0,		false,      false, 16);
					InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,		"so_cre_usr_id",		false,	    "",	dfEngUpKey,	0,		false,      false, 20);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	false,		"so_usr_nm",			false,	    "",	dfEngUpKey,	0,		false,      false, 20);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,		"trsp_wo_no",			false,	    "",	dfEngUpKey,	0,		false,      false);
					InitDataProperty(0, cnt++ , dtHidden,		25,		daCenter,	false,		"trsp_wo_ofc_cty_cd",	false,	    "",	dfEngUpKey,	0,		false,      false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"trsp_wo_seq",			false,	    "",	dfEngUpKey,	0,		false,      false);			
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"fr_flg",				false,	    "",	dfEngUpKey,	0,		false,      false);
					//hidden 처리할 것!!!!!!!
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,		"cntr_tpsz_cd_old",		false,		"",	dfNone,		0,		true,		true, 4);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"tro_qty_old",			false,		"",	dfNullInteger,	0,	false,      false, 11);
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"cxl_flg_old",			false,		"",	dfNone,		0,		false,		false);

					InitUserFormat2(0, "dor_arr_dt", "####-##-##", "-|:" );
					sheetObj.ColHidden("chk")     = true;  //chk 칼럼 : 숨김
					sheetObj.ColHidden("tro_seq") = true;  //tro_seq 칼럼 : 숨김
					/* 
					sheetObj.ColBackColor("cntr_tpsz_cd")    = sheetObj.WebColor(xNessColor); 
					sheetObj.ColBackColor("dor_arr_dt")      = sheetObj.WebColor(xNessColor); 
					sheetObj.ColBackColor("dor_arr_dt_hhmi") = sheetObj.WebColor(xNessColor); 
					*/
					InitDataValid(0, "cntr_tpsz_cd", vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					InitDataValid(0, "pkup_loc_cd",  vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					InitDataValid(0, "pkup_yd_cd",   vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					InitDataValid(0, "rtn_loc_cd",   vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					InitDataValid(0, "rtn_yd_cd",    vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					InitDataValid(0, "cmdt_cd",      vtNumericOnly);
					InitDataValid(0, "cntr_no",      vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					PopupImage      = "img/btns_calendar.gif";
					ShowButtonImage = 2;
					
					WaitImageVisible = false;   
    			}
    		    break;

    		case "t2asheet2":      //t2asheet2 init : all-master <hidden>  
				with (sheetObj) {
					// 높이 설정
//					style.height = 150;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
		            //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;

	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = false;
	    			
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 3, 100);

	    			var HeadTitle = " |";
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 3, 100);

	    			var HeadTitle = " |tro_seq|rcv_term_cd|rqst_dt|so_flg|ownr_trk_flg|biz_rgst_no|cntc_mphn_no|"+
	    			                "act_shpr_cnt_cd|act_shpr_seq|act_shpr_nm|dor_loc_cd|zn_cd|dor_pst_no|"+
	    			                "cfm_flg|cfm_dt|act_shpr_addr|diff_rmk|cntc_pson_nm|cntc_phn_no|cntc_fax_no|"+
	    			                "cxl_flg|cfm_flg_old|cxl_flg_old|||non_rt_sts_cd";  
                    var headCount = ComCountHeadTitle(HeadTitle); 
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false)	//test grid용   

	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle, true);

	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtStatus,   30,       daCenter,     true,   "ibflag");
					InitDataProperty(0,	cnt++,	dtData,		30, 	    daLeft,		false,	"tro_seq",          false,	"",	dfNone,		0,		true);  //dtHidden
					InitDataProperty(0,	cnt++,	dtData,		30, 	    daLeft,		false,	"rcv_term_cd",      false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"rqst_dt",          false,	"",	dfNone,		0,		true);
					//(B)-->
					InitDataProperty(0,	cnt++,	dtData,		30, 	    daLeft,		false,	"so_flg",           false,	"",	dfNone,		0,		true);					
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"ownr_trk_flg",     false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"biz_rgst_no",      false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		70, 	    daLeft,		false,	"cntc_mphn_no",     false,	"",	dfNone,		0,		true);
					//InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"ack_sts_cd",       false,	"",	dfNone,		0,		true);
					//<--(B)
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"act_shpr_cnt_cd",  false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"act_shpr_seq",     false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"act_shpr_nm",      false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"dor_loc_cd",       false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"zn_cd",            false,	"",	dfNone,		0,		true);					
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"dor_pst_no",       false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"cfm_flg",          false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"cfm_dt",           false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"act_shpr_addr",    false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"diff_rmk",         false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"cntc_pson_nm",     false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"cntc_phn_no",      false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daLeft,		false,	"cntc_fax_no",      false,	"",	dfNone,		0,		true);
					//(hidden)KeyCode-->
					InitDataProperty(0,	cnt++,	dtData,		30, 	    daLeft,		false,	"cxl_flg",          false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		100, 	    daLeft,		false,	"cfm_flg_old",      false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		30, 	    daLeft,		false,	"cxl_flg_old",      false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtHidden,	0, 		    daLeft,		false,	"pickup_cy_no",     false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtHidden,	0, 	   	 	daLeft,		false,	"return_cy_no",     false,	"",	dfNone,		0,		true);
					InitDataProperty(0,	cnt++,	dtData,		30, 	    daLeft,		false,	"non_rt_sts_cd",      false,	"",	dfNone,		0,		true);
					
					
	                //hidden-Grid Speed Option 처리----------->
					sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
					CountPosition = 0;
					//<---------------------------------------
					
					WaitImageVisible = false;   
				}	
			    break;
			    
    		case "t2asheet3":      //t2asheet3 init : all-detail <hidden>   			
				with (sheetObj) {
					// 높이 설정
//					style.height = 120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
										
					var HeadTitle = "|Sel.||Seq.|SubSeq|Del|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|"+
					                "Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|CNTR No.|Moved by Split|"+
					                "S/O|S/O|S/O|S/O|W/O|W/O|W/O||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);					
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false)					
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,	    30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,		"del_chk",		    	false,		"",	dfNone,		0,		true,		true);					
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,		"chk",		        	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"tro_seq",          	false,      "", dfNumber,   0,      false,      false);					
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"tro_sub_seq",      	false,      "", dfNumber,   0,      false,      false);
					//InitDataProperty(0, cnt++ , dtData,     	30,		daCenter,	false,		"del",		        	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		     70,	daCenter,	false,		"cxl_flg",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"cntr_tpsz_cd",	    	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"tro_qty",		    	false,		"",	dfNumber,	0,		false,      false);
					InitDataProperty(0, cnt++ , dtData,      	80,	    daCenter,	false,		"dor_arr_dt",	    	false,		"",	dfUserFormat2,	0,	true,		true);
					InitDataProperty(0, cnt++ , dtData,	        40,	    daCenter,	false,		"dor_arr_dt_hhmi",		false,		"",	dfTimeHm,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	false,		"pkup_loc_cd",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"pkup_yd_cd",	    	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	false,		"rtn_loc_cd",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		"rtn_yd_cd",	    	false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,		"cmdt_cd",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"cntr_no",		    	false,		"",	dfNone,		0,		true,		true);					
					InitDataProperty(0, cnt++ , dtData,			90,  	daCenter,	false,		"split_rmk",			false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,		"trsp_so_no",			false,	    "",	dfEngUpKey,	0,		false,      false, 18);  
					InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,		"so_cre_dt",			false,	    "",	dfNone,		0,		false,      false);
					InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	false,		"so_cre_usr_id",		false,	    "",	dfEngUpKey,	0,		false,      false, 20);
					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	false,		"so_usr_nm",			false,	    "",	dfEngUpKey,	0,		false,      false, 20);
					InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	false,		"trsp_wo_no",			false,	    "",	dfEngUpKey,	0,		false,      false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"trsp_wo_ofc_cty_cd",	false,	    "",	dfEngUpKey,	0,		false,      false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"trsp_wo_seq",			false,	    "",	dfEngUpKey,	0,		false,      false);			
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"fr_flg",				false,	    "",	dfEngUpKey,	0,		false,      true);
					//hidden 처리할 것!!!!!!!
					InitDataProperty(0, cnt++ , dtData,		    60,		daCenter,	false,		"cntr_tpsz_cd_old",		false,		"",	dfNone,		0,		true,		true, 4);
					InitDataProperty(0, cnt++ , dtData,		    50,		daCenter,	false,		"tro_qty_old",			false,		"",	dfNumber,	0,		false,      false, 11);
					InitDataProperty(0, cnt++ , dtData,		    70,  	daCenter,	false,		"cxl_flg_old",			false,		"",	dfNone,		0,		false,		false);
					
					InitUserFormat2(0, "dor_arr_dt", "####-##-##", "-|:" );	
	                //hidden-Grid Speed Option 처리----------->
					sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
					CountPosition = 0;
					//<---------------------------------------
					
					WaitImageVisible = false;   
				}
		        break;	
		    		    
    		case "t2asheet4":      //t2asheet4 init : tro_dg_seq all <hidden>  
				with (sheetObj) {				
					// 높이 설정
//					style.height = 150;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
		            //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;
	
	    			//전체Edit 허용 여부 [선택, Default false]
	    			//Editable = true;
	    			Editable = false;

	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 3, 100);
	
	    			var HeadTitle = " ||tro_seq|spcl_cgo_cd|spcl_cgo_seq|";  //5 cols
	                var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false)	//test grid용   
	
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtStatus,       30,     daCenter,   true,   "ibflag");		
	    			InitDataProperty(0,	cnt++,	dtDummyCheck,	27, 	daCenter,	false,	"del_chk");
					InitDataProperty(0,	cnt++,	dtData,		    30, 	daLeft,		false,	"tro_seq",        false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtData,		    30, 	daLeft,		false,	"spcl_cgo_cd",    false,	"",	dfNone,		0,		false);
					InitDataProperty(0,	cnt++,	dtData,		    30, 	daLeft,		false,	"spcl_cgo_seq",   false,	"",	dfNone,		0,		false);
	                //hidden-Grid Speed Option 처리----------->
					sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
					CountPosition = 0;
					//<---------------------------------------
					 
					WaitImageVisible = false;   
				}	
			    break;
			    
    		case "t2asheet5":      //t2asheet5 init : sum_qty grid
				with (sheetObj) {				
					//높이 설정
					style.height = 102;
					//전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
		            //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;
	
	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	    			
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 3, 100);
	
	    			var HeadTitle = "TP/SZ|Total Qty|TRO Qty";  //3 cols
	                var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false)	//test grid용   
	
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			//InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,     true,   "ibflag");					
					InitDataProperty(0,	cnt++,	dtData,		40, 	    daCenter,		false,	"cntr_tpsz_cd",   false,	"",	dfNone,		        0,		false,      false);
					InitDataProperty(0,	cnt++,	dtData,		60, 	    daRight,		false,	"total_qty",      false,	"",	dfNullInteger,		0,		false,      false);
					InitDataProperty(0,	cnt++,	dtData,		50, 	    daRight,		false,	"tro_qty",        false,	"",	dfNullInteger,		0,		false,      false);
	
	                //hidden-Grid Speed Option 처리----------->
					sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
					CountPosition = 0;					
					//<---------------------------------------
					
					WaitImageVisible = false;   
				}	
			    break;
			    
     		case "t2amsgsheet1":      //t2amsgsheet1 init : msg 전용 grid
				with (sheetObj) {
					// 높이 설정
					//style.height = 50;					
					//전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,     true,   "ibflag");		
					
					WaitImageVisible = false; 
				}	
			    break;
    	}    	
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, delFlg) {
    	if (delFlg == null) {
    		delFlg = "N";
    	}
    	
        switch(sAction) {
			case COMMAND03:      //booking split no조회 
				formObj.f_cmd.value = COMMAND03;				
				var param = "f_cmd=" + COMMAND03 + "&bkg_no=" + formObj.bkg_no.value;  
			    var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_02AGS.do", param);	
			 	var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
			 	bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -23); 
			 	break;	
			 	
			case COMMAND09:      //system_date 조회(local) 
				formObj.f_cmd.value = COMMAND09;
			 	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_02AGS.do", FormQueryString(formObj));				 	
			 	formObj.cfm_sys_date.value = ComGetEtcData(sXml, "cfm_sys_date");
			 	break;	
        
          	case IBSEARCH: 
          	    if(!validateForm(sheetObj,formObj,sAction)) return;  	
          	   
          	    initSearchVal();  //전역변수등 clear[load상태로] 
          	
				formObj.f_cmd.value = SEARCH;    		
				ComOpenWait(true);
				var parm   = "f_cmd=" + SEARCH + "&bkg_no=" + formObj.bkg_no.value + "&io_bnd_cd=" + "O"  + "&rtn_tro_flg=" + "N" + "&curr_tro_seq" + formObj.curr_tro_seq.value ;	
				var sXml   = sheetObj.GetSearchXml("ESM_BKG_0079_02AGS.do", parm); 
				var arrXml = sXml.split("|$$|");  
				ComOpenWait(false); //대기창 사라짐 				
				
				if(ComGetEtcData(arrXml[0], "DataYn") == "N") {					
					x_sheetObjMsg.LoadSearchXml(arrXml[0]); 
					formObj.bkg_no.value = formObj.oldBkgNo.value;
					formObj.bl_no.value  = formObj.oldBlNo.value;
					return;
				} 
				
				//(정보 조회 all): Start------------------------------------------>
                if (arrXml.length > 0) { 
                    x_sheetObject4.LoadSearchXml(arrXml[2]);  
                    ComBkgXml2ComboItem(arrXml[3], formObj.dcgo_seq,    "display_nm", "dg_seq"); 
                    ComBkgXml2ComboItem(arrXml[4], formObj.rc_seq,      "display_nm", "rf_seq"); 
                    ComBkgXml2ComboItem(arrXml[5], formObj.awk_cgo_seq, "awk_seq",    "awk_seq"); 
                    ComBkgXml2ComboItem(arrXml[0], formObj.tro_seq,     "tro_seq",    "tro_seq");  
                	x_sheetObject2.LoadSearchXml(arrXml[0]);  
                    setEtcDataToForm_bkg(formObj, x_sheetObject2);

                    //max_tro_seq_old : setting
                    var max_tro_seq_old = x_sheetObject2.CellValue(x_sheetObject2.RowCount, "tro_seq");
                    formObj.max_tro_seq_old.value = (nullToBlank(max_tro_seq_old.trim())=="")? "0": max_tro_seq_old;
                    
                    setDataToForm_TroMst(x_sheetObject2.CellValue(1, "tro_seq"));
                	//changeMasterColor();  //cxl_flg checkbox : Master 수정 불가/가능 처리 -> 위치이동 
                }
                if (arrXml.length > 1) {
                	x_sheetObject3.LoadSearchXml(arrXml[1]); 
                	changeMasterColor();  //cxl_flg checkbox : Master 수정 불가/가능 처리 
                    setAllDataToData_TroDtl(formObj.tro_seq.text); 
                } 
                //<--------------------------------------------(정보 조회 all): End 

                x_sheetObject5.LoadSearchXml(arrXml[6]);
                changeTroQtyColor(x_sheetObject5);
                
                //1) tot tro_seq가  '0'이면, default seq Add                
                if (formObj.tro_seq_maxcnt.value == "0") {
                	addRow(x_sheetObject2); 
                } else {
                	if (formObj.curr_tro_seq.value != "") { 
                		formObj.tro_seq.Text = formObj.curr_tro_seq.value;  //default seq set : onchange!!!!!!!!
                	}
                }
                
                // 2010.2.18 by 신자영 
                if('X' == ComGetObjValue(formObj.bkg_sts_cd)){
                	ComEnableManyTd(false ,"btn_t2aRetrieve","btn_t2aSave","btn_t2aSaveSeq","btn_t2aSaveConfirm","btn_t2aCancelAll","btn_t2aTROCopy","btn_t2aAddSeq","btn_t2aCopySeq","btn_t2aCancelSeq");
                }else{
                	ComEnableManyTd(true ,"btn_t2aRetrieve","btn_t2aSave","btn_t2aSaveSeq","btn_t2aSaveConfirm","btn_t2aCancelAll","btn_t2aTROCopy","btn_t2aAddSeq","btn_t2aCopySeq","btn_t2aCancelSeq");
                	// cancel all버튼 기능 문제가 잠시 막음
                	//ComEnableManyTd(false,"btn_t2aCancelAll");  
                }
                ComSetObjValue(formObj.modify_flag, "N");
                fnOnSearchEnd();
             	//------------------------------------------------>
             	//setInquiryDisableButton 이벤트 호출
             	if(ComGetObjValue(document.form.isInquiry) == "Y"){
             		setInquiryDisableButton();
             	}
                //2) C/A 버튼 Control
				parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"), 
						             ComGetEtcData(arrXml[0], "ca_flg"), 
						             ComGetEtcData(arrXml[0], "bdr_flg"), 
						             ComGetEtcData(arrXml[0], "ca_exist_flg"), 
						             ComGetEtcData(arrXml[0], "bl_no"));
				// Allocation 관련하여 allocation status 가 S 인 경우는 Tro Confirm 항목을 비활성화						             
				if("S"== document.form.aloc_sts_cd.value){
					document.form.cfm_flg.disabled = true;
				}else{
					document.form.cfm_flg.disabled = false;
				}
				
				// NON_RT_STS_CD 가 "R" 일 때 Tro Confirm 항목을 비활성화
				if("R"== document.form.non_rt_sts_cd.value){
					document.form.cfm_flg.disabled = true;
				}else{
					document.form.cfm_flg.disabled = false;
				}
				
				// Location에 저장된 값이 없는 경우 POR의 Location + Yard 를 표기해줌
				if(ComGetObjValue(formObj.dor_loc_cd) =="") {
					ComSetObjValue(formObj.dor_loc_cd ,ComGetObjValue(formObj.por_cd) );
					ComSetObjValue(formObj.zn_cd ,ComGetObjValue(formObj.por_nod_cd) );
					
				}
				
                break;

     		case IBSAVE: 
	 		    //(저장전)---------------------------->
     			//2011.12.13 spcial cargo가 남아 있는지 체크 하는 함수 kbj				
				var currTroSeq = formObj.tro_seq.Text;

                setFormToData_Tro_dg_seq(currTroSeq); 
                x_sheetObject4.ColumnSort("tro_seq|spcl_cgo_cd|spcl_cgo_seq");
     		    
	        	setFormToData_TroMst(currTroSeq); 

     		    setDataToAllData_TroDtl(currTroSeq, false);        //copy(삭제않함 ) 

				x_sheetObject3.ColumnSort("tro_seq|tro_sub_seq");  //dtl-all grid(hidden) 저장전, Sorting  
				
				if( formObj.cfm_flg.checked && delFlg != "Y") {
					if(isRemainSpCgo()){
	          			ComShowMessage(ComGetMsg("BKG02104"));
          				formObj.cfm_flg.checked = false;
          				return false;
	          		}
				}
				
//				if (delFlg == "C") {
//					for (var i=1; i<=x_sheetObject2.RowCount; i++) {
//						if (x_sheetObject2.CellValue(i, "tro_seq") != currTroSeq) {
//							x_sheetObject2.RowStatus(i) = "R";
//						}
//	     		    }
//					for (var i=1; i<=x_sheetObject3.RowCount; i++) {
//						if (x_sheetObject3.CellValue(i, "tro_seq") != currTroSeq) {
//							x_sheetObject3.RowStatus(i) = "R";
//						}
//	     		    }
//					for (var i=1; i<=x_sheetObject4.RowCount; i++) {
//						if (x_sheetObject4.CellValue(i, "tro_seq") != currTroSeq) {
//							x_sheetObject4.RowStatus(i) = "R";
//						}
//	     		    }
//				} else {
//	     		    for (var i=1; i<=x_sheetObject4.RowCount; i++) {
//	     		    	x_sheetObject4.RowStatus(i) = "I";
//	     		    }
//				}
				if (delFlg != "C") {
	     		    for (var i=1; i<=x_sheetObject4.RowCount; i++) {
	     		    	x_sheetObject4.RowStatus(i) = "I";
	     		    }
				}
				
				//<-----------------------------(저장전)  

				if(!validateForm(sheetObj, formObj, sAction, delFlg)) return;
				
          		//(containerVO)----------------------------------------->           	  
          	    //formObj.f_del_flg.value    = delFlg;                //delete event 구분 -> check시에 적용 
          	    formObj.curr_tro_seq.value = formObj.tro_seq.Text;  //default 순번 setting
          	    
          	    var sheetSaveObjects = new Array();
          	    sheetSaveObjects[0] = x_sheetObject2;
          	    sheetSaveObjects[1] = x_sheetObject3;
          	    sheetSaveObjects[2] = x_sheetObject4;
          	    
          	    //by신자영 :  저장할때  현재 seq번호의 pickup, return no 를 master에 셋팅한다.
				fnSetPickupReturn_no();
				
//      	    var sParam1 = ComSetPrifix(x_sheetObject2.GetSaveString(true), "t2asheet2_");  //allSave
//				var sParam3 = ComSetPrifix(x_sheetObject4.GetSaveString(),     "t2asheet4_"); 
//      	    var sParam2 = ComSetPrifix(x_sheetObject3.GetSaveString(true), "t2asheet3_");  //allSave

				var sParam = "";
          	    var sParam0 = "f_cmd=" + MULTI 
	    			+ "&bkg_no=" + formObj.bkg_no.value
	    			+ "&oldBkgNo=" + formObj.oldBkgNo.value
	    			+ "&io_bnd_cd=" + formObj.io_bnd_cd.value
	    			+ "&rtn_tro_flg=" + "N" 
	    			+ "&f_del_flg=" + formObj.f_del_flg.value
	    			+ "&curr_tro_seq=" + formObj.curr_tro_seq.value
	    			;
          	    var sParam1 = "";
          	    var sXml = ""; 
				for (var i=1; i<=x_sheetObject2.RowCount; i++) {
					sParam1 = sParam0;
					if((delFlg == "C" && x_sheetObject2.CellValue(i, "tro_seq") == currTroSeq)
							|| (delFlg == "Y" && x_sheetObject2.CellValue(i, "tro_seq") == currTroSeq)	
							|| (delFlg != "C" && delFlg != "Y")){
						sParam1 = sParam1 + "&t2asheet2_ibflag="	+ x_sheetObject2.CellValue(i, "ibflag")
								+ "&t2asheet2_tro_seq=" 			+ x_sheetObject2.CellValue(i, "tro_seq")
								+ "&t2asheet2_rcv_term_cd=" 		+ x_sheetObject2.CellValue(i, "rcv_term_cd")
								+ "&t2asheet2_rqst_dt=" 			+ x_sheetObject2.CellValue(i, "rqst_dt")
								+ "&t2asheet2_so_flg=" 				+ x_sheetObject2.CellValue(i, "so_flg")
								+ "&t2asheet2_ownr_trk_flg=" 		+ x_sheetObject2.CellValue(i, "ownr_trk_flg")
								+ "&t2asheet2_biz_rgst_no=" 		+ x_sheetObject2.CellValue(i, "biz_rgst_no")
								+ "&t2asheet2_cntc_mphn_no=" 		+ x_sheetObject2.CellValue(i, "cntc_mphn_no")
								+ "&t2asheet2_ack_sts_cd=" 			+ x_sheetObject2.CellValue(i, "ack_sts_cd")
								+ "&t2asheet2_act_shpr_cnt_cd="		+ x_sheetObject2.CellValue(i, "act_shpr_cnt_cd")
								+ "&t2asheet2_act_shpr_seq=" 		+ x_sheetObject2.CellValue(i, "act_shpr_seq")
								+ "&t2asheet2_act_shpr_nm=" 		+ x_sheetObject2.UrlEncoding(x_sheetObject2.CellValue(i, "act_shpr_nm"))
								+ "&t2asheet2_dor_loc_cd=" 			+ x_sheetObject2.CellValue(i, "dor_loc_cd")
								+ "&t2asheet2_zn_cd=" 				+ x_sheetObject2.CellValue(i, "zn_cd")
								+ "&t2asheet2_dor_pst_no=" 			+ x_sheetObject2.CellValue(i, "dor_pst_no")
								+ "&t2asheet2_cfm_flg=" 			+ x_sheetObject2.CellValue(i, "cfm_flg")
								+ "&t2asheet2_cfm_dt=" 				+ x_sheetObject2.CellValue(i, "cfm_dt")
								+ "&t2asheet2_act_shpr_addr=" 		+ x_sheetObject2.UrlEncoding(x_sheetObject2.CellValue(i, "act_shpr_addr"))
								+ "&t2asheet2_diff_rmk=" 			+ x_sheetObject2.UrlEncoding(x_sheetObject2.CellValue(i, "diff_rmk"))
								+ "&t2asheet2_cntc_pson_nm=" 		+ x_sheetObject2.UrlEncoding(x_sheetObject2.CellValue(i, "cntc_pson_nm"))
								+ "&t2asheet2_cntc_phn_no=" 		+ x_sheetObject2.CellValue(i, "cntc_phn_no")
								+ "&t2asheet2_cntc_fax_no=" 		+ x_sheetObject2.CellValue(i, "cntc_fax_no")
								+ "&t2asheet2_cxl_flg=" 			+ x_sheetObject2.CellValue(i, "cxl_flg")
								+ "&t2asheet2_cfm_flg_old=" 		+ x_sheetObject2.CellValue(i, "cfm_flg_old")
								+ "&t2asheet2_cxl_flg_old=" 		+ x_sheetObject2.CellValue(i, "cxl_flg_old")
								+ "&t2asheet2_pickup_cy_no=" 		+ x_sheetObject2.CellValue(i, "pickup_cy_no")
								+ "&t2asheet2_return_cy_no=" 		+ x_sheetObject2.CellValue(i, "return_cy_no");
						for (var j=1; j<=x_sheetObject4.RowCount; j++) {
							if(x_sheetObject4.CellValue(j, "tro_seq") == x_sheetObject2.CellValue(i, "tro_seq")){
								sParam1 = sParam1 + "&t2asheet4_ibflag=" 	+ x_sheetObject4.CellValue(j, "ibflag")
										+ "&t2asheet4_del_chk=" 			+ x_sheetObject4.CellValue(j, "del_chk")
										+ "&t2asheet4_tro_seq=" 			+ x_sheetObject4.CellValue(j, "tro_seq")
										+ "&t2asheet4_spcl_cgo_cd=" 		+ x_sheetObject4.CellValue(j, "spcl_cgo_cd")
										+ "&t2asheet4_spcl_cgo_seq=" 		+ x_sheetObject4.CellValue(j, "spcl_cgo_seq");
							}
						}
						for (var j=1; j<=x_sheetObject3.RowCount; j++) {
							sParam = sParam1;
							if(x_sheetObject3.CellValue(j, "tro_seq") == x_sheetObject2.CellValue(i, "tro_seq")){
								sParam = sParam + "&t2asheet3_ibflag=" 		+ x_sheetObject3.CellValue(j, "ibflag")
										+ "&t2asheet3_del_chk=" 			+ x_sheetObject3.CellValue(j, "del_chk")
										+ "&t2asheet3_chk=" 				+ x_sheetObject3.CellValue(j, "chk")
										+ "&t2asheet3_tro_seq=" 			+ x_sheetObject3.CellValue(j, "tro_seq")
										+ "&t2asheet3_tro_sub_seq=" 		+ x_sheetObject3.CellValue(j, "tro_sub_seq")
										+ "&t2asheet3_cxl_flg=" 			+ x_sheetObject3.CellValue(j, "cxl_flg")
										+ "&t2asheet3_cntr_tpsz_cd=" 		+ x_sheetObject3.CellValue(j, "cntr_tpsz_cd")
										+ "&t2asheet3_tro_qty=" 			+ x_sheetObject3.CellValue(j, "tro_qty")
										+ "&t2asheet3_dor_arr_dt=" 			+ x_sheetObject3.CellValue(j, "dor_arr_dt")
										+ "&t2asheet3_dor_arr_dt_hhmi=" 	+ x_sheetObject3.CellValue(j, "dor_arr_dt_hhmi")
										+ "&t2asheet3_pkup_loc_cd=" 		+ x_sheetObject3.CellValue(j, "pkup_loc_cd")
										+ "&t2asheet3_pkup_yd_cd=" 			+ x_sheetObject3.CellValue(j, "pkup_yd_cd")
										+ "&t2asheet3_rtn_loc_cd=" 			+ x_sheetObject3.CellValue(j, "rtn_loc_cd")
										+ "&t2asheet3_rtn_yd_cd=" 			+ x_sheetObject3.CellValue(j, "rtn_yd_cd")
										+ "&t2asheet3_cmdt_cd=" 			+ x_sheetObject3.CellValue(j, "cmdt_cd")
										+ "&t2asheet3_cntr_no=" 			+ x_sheetObject3.CellValue(j, "cntr_no")
										+ "&t2asheet3_split_rmk=" 			+ x_sheetObject3.CellValue(j, "split_rmk")
										+ "&t2asheet3_trsp_so_no=" 			+ x_sheetObject3.CellValue(j, "trsp_so_no")
										+ "&t2asheet3_so_cre_dt=" 			+ x_sheetObject3.CellValue(j, "so_cre_dt")
										+ "&t2asheet3_so_cre_usr_id=" 		+ x_sheetObject3.CellValue(j, "so_cre_usr_id")
										+ "&t2asheet3_so_usr_nm=" 			+ x_sheetObject3.CellValue(j, "so_usr_nm")
										+ "&t2asheet3_trsp_wo_no=" 			+ x_sheetObject3.CellValue(j, "trsp_wo_no")
										+ "&t2asheet3_trsp_wo_ofc_cty_cd="	+ x_sheetObject3.CellValue(j, "trsp_wo_ofc_cty_cd")
										+ "&t2asheet3_trsp_wo_seq=" 		+ x_sheetObject3.CellValue(j, "trsp_wo_seq")
										+ "&t2asheet3_fr_flg=" 				+ x_sheetObject3.CellValue(j, "fr_flg")
										+ "&t2asheet3_cntr_tpsz_cd_old=" 	+ x_sheetObject3.CellValue(j, "cntr_tpsz_cd_old")
										+ "&t2asheet3_tro_qty_old=" 		+ x_sheetObject3.CellValue(j, "tro_qty_old")
										+ "&t2asheet3_cxl_flg_old=" 		+ x_sheetObject3.CellValue(j, "cxl_flg_old")
//								alert(sParam);
								ComOpenWait(true);
				          		sXml = sheetObj.GetSaveXml("ESM_BKG_0079_02AGS.do", sParam);
								ComOpenWait(false); 
				          		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") != "S"){
				              		sheetSaveObjects[0].LoadSaveXml(sXml);
				          			return false;
				          		} 
							}
						}
					}
				}

          		sheetSaveObjects[0].LoadSaveXml(sXml);
          		//<------------------------------------------(containerVO)
          		
          		doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
          		
          		break; 
        }
    }
    
    //재조회전, 초기화작업 
    function initSearchVal() {
    	var formObj = document.form;
    	
    	//page 전역변수  clear -> OnLoad상태로 
    	x_oldTroSeq    = ""; 
        x_cancelAllFlg = "N";  //Y:cancelAll 처리됨         
    }    


    //######################[1. Event]############################################################
    /**
    * Tro master : tro_seq 콤보 선택변경시, 이벤트처리
    */
    function tro_seq_OnChange(comboObj, idx_cd, text) {
    	changeTroSeqProc(); 
    	fnCheckTrsp_so_no();
        //by신자영 : 저장할때  현재 seq번호의 pickup, return no 를 master에 셋팅한다.
    	fnSetPickupReturn_no();    
    	if("R"== document.form.non_rt_sts_cd.value){
			document.form.cfm_flg.disabled = true;
		}else{
			document.form.cfm_flg.disabled = false;
		}
    }
 
    function changeTroSeqProc() {    	
    	var comboObj = document.tro_seq; 
    	
    	//----------------------
    	//1) 변경되어 선택된 tro_seq 조회
		var currTroSeq = comboObj.Text; 
		
    	//----------------------
    	//2) tro-master  
		if (x_oldTroSeq != "") {
    	    setFormToData_TroMst(x_oldTroSeq);
		}
    	setDataToForm_TroMst(currTroSeq);          //tro-master Form 출력 변경(선택된 tro_seq) 
    	
    	//----------------------
    	//3) cxl_flg checkbox : Master 수정 불가/가능 처리    	
    	changeMasterColor();
    	
    	//----------------------
    	//4) tro-detail
    	if (x_oldTroSeq != "") {
    	    setDataToAllData_TroDtl(x_oldTroSeq);  //dtl(store) : display->hidden all (처음 loading시는 제외) : move
    	}
    	setAllDataToData_TroDtl(currTroSeq);       //dtl(load)  : hidden all->display        	
    	
    	//----------------------
    	//5) tro/tro-detail 화면변경사항 저장시 사용을 위해, x_oldTroSeq 유지     	
    	x_oldTroSeq = comboObj.Text;  //currTroSeq     	
    }
    /**
     * fnSetPickupReturn_no :  이벤트처리
     * 저장할때  현재 seq번호의 pickup, return no 를 master에 셋팅한다.
     * by 신자영
     */
    function fnSetPickupReturn_no() {
    	var mstSheetObj = x_sheetObject2; 
    	var dtlsheetObj = x_sheetObject1; 
    	var comboObj = document.tro_seq; 
    	var formObj = document.form;
    	//----------------------
    	//1) 변경되어 선택된 tro_seq 조회
		var tro_seq = comboObj.Text; 
    	//-----------------------------------
    	//1) tro_seq Value에 해당하는 row로 초기화 
    	var nRow = mstSheetObj.FindText("tro_seq", tro_seq); 
    	if(nRow > 0){
    		//mstSheetObj.CellValue2(nRow, "pickup_cy_no") = dtlsheetObj.CellValue(nRow, "pkup_loc_cd") + dtlsheetObj.CellValue(nRow, "pkup_yd_cd");
    		//mstSheetObj.CellValue2(nRow, "return_cy_no") = dtlsheetObj.CellValue(nRow, "rtn_loc_cd") + dtlsheetObj.CellValue(nRow, "rtn_yd_cd");
    		mstSheetObj.CellValue2(nRow, "pickup_cy_no") = formObj.pickup_cy1.value + formObj.pickup_cy2.value ;
    		mstSheetObj.CellValue2(nRow, "return_cy_no") = formObj.return_cy1.value + formObj.return_cy2.value;
    		//alert("pickup_cy_no" + formObj.pickup_cy1.value + formObj.pickup_cy2.value);
    		//alert("return_cy_no" + formObj.return_cy1.value + formObj.return_cy2.value);
    		
    	}
    }
    /**
    ;
    /**
    * Tro master : dcgo_seq 멀티콤보 체크시, 이벤트처리
    */
    function dcgo_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj  = document.form;
    	setAddRemarkText(comboObj, idx_cd, text);     	
    	setComboBackColor(formObj.dcgo_seq);
    }

    /**
    * Tro master : rc_seq 멀티콤보 체크시, 이벤트처리
    */
    function rc_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj  = document.form; 
    	setAddRemarkText(comboObj, idx_cd, text); 
    	setComboBackColor(formObj.rc_seq);	
    }    
    
    /**
    * Tro master : awk_cgo_seq 멀티콤보 변경시, 이벤트처리
    */
    function awk_cgo_seq_OnChange(comboObj, idx_cd, text) {    	
    	var formObj  = document.form; 
    	setComboBackColor(formObj.awk_cgo_seq);	    
    } 

    /**
    * 저장완료시, 재조회
    */    
    function t2asheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg.length > 9 && ErrMsg.substr(0,9) == "[Success]") {
    		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH); 
    	}
    }
    /**
    * 조회완료시
    */  
    function fnOnSearchEnd(sheetObj, ErrMsg) {
		var objForm  = document.form;
		with(objForm) { 
		    if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
    			if (diff_rmk.value == "") {
    			    diff_rmk.value = "Food Grade, Hide ";
    			}
		    } 
		    else if (fd_grd_flg.value == "Y") {
    			if (diff_rmk.value == "") {
    			    diff_rmk.value = "Food Grade ";
    			}
		    }
		    else if (spcl_hide_flg.value == "Y") {
    			if (diff_rmk.value == "") {
    			    diff_rmk.value = "Hide ";
    			}
		    }
		}
		//BY 신자영 2010.3.30
		fnCheckTrsp_so_no();

    	sheetObjects[1].ColFontUnderline("trsp_wo_no") = true;
    	sheetObjects[1].ColFontUnderline("trsp_wo_ofc_cty_cd") = true;
    	sheetObjects[1].ColFontUnderline("trsp_wo_seq") = true;
    }
    
    /**
    * trsp_so_no 번호존재 유무체크 
    * by 신자영  
    */  
    function fnCheckTrsp_so_no() {
		var sheetObj    = x_sheetObject1; 
		var cnt			= sheetObj.RowCount;
		var flg 		= false;
		for (var i = 1; i <= cnt; i++){ 
			var _val = sheetObj.CellValue(i, "trsp_so_no");
			var fr_flg = sheetObj.CellValue(i, "fr_flg");
			if (_val.length > 0 && fr_flg == ''){
				flg = true;
				break;
			}
		}
		if(flg){
			ComBtnDisable("btn_t2aCancelAll");
			ComBtnDisable("btn_t2aCancelSeq");
		}else{
			ComBtnEnable("btn_t2aCancelSeq");
			ComBtnEnable("btn_t2aSaveSeq");
		}
    }
    /**
    * Tro dtl : 달력 및 W/O 팝업 이벤트처리
    */
    function t2asheet1_OnPopupClick(sheetObj, row,col){
    	var selColNm = sheetObj.ColSaveName(col);
    	if (selColNm == "dor_arr_dt") {
            var cal = new ComCalendarGrid("myCal");
            cal.select(sheetObj, row, col, 'yyyy-MM-dd');
        }
    }    
    
    function t2asheet1_OnDblClick(sheetObj, row, col) {
    	var selColNm = sheetObj.ColSaveName(col);
    	if(selColNm == "trsp_wo_no" && !sheetObjects[1].CellValue(row, "trsp_wo_no") == "") {
        	var trsp_wo_ofc_cty_cd = sheetObjects[1].CellValue(row, "trsp_wo_ofc_cty_cd");
        	var trsp_wo_seq = sheetObjects[1].CellValue(row, "trsp_wo_seq");
        	var wo_cancel_flag = '';
        	var detain = '';
        	var bno_issue = '';
        	var eq_mode = 'IS';
        	var issued = 'Y';
        	var param = "?trsp_wo_ofc_cty_cd="+trsp_wo_ofc_cty_cd+"&trsp_wo_seq="+trsp_wo_seq+"&wo_cancel_flag="+wo_cancel_flag+"&detain="+detain+"&eq_mode="+eq_mode+"&bno_issue="+bno_issue+"&isInquiry=Y"+"&pgmNo=ESD_TRS_0024&tro_prv_flg=Y";
        	window.open('ESD_TRS_0024.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=1000,Height=800");
        }
    }
    
    function t2asheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	var colId   = sheetObj.ColSaveName(Col);
        var formObj = document.form; 

        with(formObj) {
            switch(colId) {
				case "cntr_tpsz_cd":
					var valType = sheetObj.EditValue;  	
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "dor_arr_dt", false);
	            	}
					break;
					
				case "dor_arr_dt":
					var valType = ComReplaceStr(sheetObj.EditValue, "_", ""); 
	            	if (valType.length == 10) {
	            		sheetObj.SelectCell(Row, "dor_arr_dt_hhmi", false);
	            	}
					break;					
				case "dor_arr_dt_hhmi":
					var valType = ComReplaceStr(sheetObj.EditValue, "_", ""); 
	            	if (valType.length == 4) {
	            		sheetObj.SelectCell(Row, "pkup_loc_cd", false);
	            	}
					break;
					
				case "pkup_loc_cd":
					var valType = sheetObj.EditValue;  	  					
	            	if (valType.length == 5) {
	            		sheetObj.SelectCell(Row, "pkup_yd_cd", false);
	            	}
					break;					
				case "pkup_yd_cd":
					var valType = sheetObj.EditValue;
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "rtn_loc_cd", false);
	            	}
					break;
					
				case "rtn_loc_cd":
					var valType = sheetObj.EditValue;	
	            	if (valType.length == 5) {
	            		sheetObj.SelectCell(Row, "rtn_yd_cd", false);
	            	}
					break;
					
				case "rtn_yd_cd":
					var valType = sheetObj.EditValue;
	            	if (valType.length == 2) {
	            		sheetObj.SelectCell(Row, "cmdt_cd", false);
	            	}
					break;
				case "cmdt_cd":
					var valType = sheetObj.EditValue;
	            	if (valType.length == 8) {
	            		sheetObj.SelectCell(Row, "cntr_no", false);
	            	}
					break;
	         }
        }
	}     

    function t2asheet1_OnChange(sheetObj, Row, Col, Val) {
    	var colId   = sheetObj.ColSaveName(Col);
        var formObj = document.form; 
        
        with(formObj) {
            switch(colId) {
				case "cntr_tpsz_cd": 
					if ("Y" == sheetObj.CellValue(Row, "cxl_flg") || "D" == sheetObj.CellValue(Row, "ibflag")) {
						//Cancel/Delete 건은, troqty sum수량에 포함않됨
						return; 
					}
					
					var preVal_type = sheetObj.CellValue(Row, "cntr_tpsz_cd_old");
					var nxtVal_type = Val;  //"cntr_tpsz_cd"
					
	            	if (nxtVal_type != preVal_type) {
	            		var preTroQty = sheetObj.CellValue(Row, "tro_qty_old");
	            		var nxtTroQty = sheetObj.CellValue(Row, "tro_qty");
	            		changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, Row);
	            	}
					break;
					
				case "dor_arr_dt":
					if (Val != "") {
		    			var t_dor_arr_dt      = ComReplaceStr(nullToBlank(sheetObj.CellValue(Row, "dor_arr_dt")),      "-", ""); 
		    			var t_dor_arr_dt_hhmi = ComReplaceStr(nullToBlank(sheetObj.CellValue(Row, "dor_arr_dt_hhmi")), ":", "");  
		    			if (t_dor_arr_dt_hhmi == "") {
		    				t_dor_arr_dt_hhmi = "0000"; 
		    			}
		    			var t_arr_dt = t_dor_arr_dt + t_dor_arr_dt_hhmi;	
	    				var t_etb_dt = etb_dt.value;

						if (t_etb_dt != "" && t_arr_dt > t_etb_dt) {
							ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.CellValue(Row, "tro_seq")+", SubSeq:"+sheetObj.CellValue(Row, "tro_sub_seq")+"] Door Arrival Date", "ETB Date("+t_etb_dt+")", "lesser");
							return false;  
						}
						if (t_dor_arr_dt_hhmi == "") {
						    sheetObj.CellValue2(Row, "dor_arr_dt_hhmi") = "00:00";
						}
					}					
					break;
					
				/* : 수량변경 불가  
			    case "tro_qty": 
			    	break;
			    */ 
	         }
        }
	}
    
	function t2asheet1_OnMouseMove(sheetObj, Button, Shift, X, Y)
	{
		with(sheetObj)
		{
			var row = MouseRow;
			var col = MouseCol;			
			
			var colname = ColSaveName(col);			
			switch(colname)
			{
				case "so_cre_usr_id":
					if (row > 0 && row <= sheetObj.SearchRows && "" != CellValue(row, col))
						MouseToolTipText = CellValue(row, "so_usr_nm");
					else
						MouseToolTipText = "";
					break;
				default :
						MouseToolTipText = "";
			}
		}
	}
	
    /**
    * Tro-Master : Mater 수정불가 처리 
    */    
    function changeMasterColor() {
    	var formObj = document.form;
    	
    	//-------------------------------------------
    	//1) cxl_flg/cfm_flg checkbox : Master 수정 불가/가능 처리  
    	var cxl_flg      = (formObj.cxl_flg.checked)? "Y" : "N";
    	var cfm_flg      = (formObj.cfm_flg.checked)? "Y" : "N";        
    	var targetTroSeq = formObj.tro_seq.Text;
    	var so_no_flg    = getExistYnSoNo(targetTroSeq);
    	
    	formObj.so_no_flg.value = so_no_flg; 
    	
    	changeEnabled_master_control(cxl_flg, cfm_flg, so_no_flg);
    	
		
		//-------------------------------------------
    	//2) 콤보항목값 존재시, 배경색 변경 
		setChangeAllComboBackColor();  
		
    	//----------------------
    	//3) tro_seq별 SaveSeq 버튼 상태 제어 
        //copyCntr/addCntr 된 건중, max_seq+1 보다 큰 seq건은, saveSeq버튼 disabled -> SaveAll 해야함. 
	    var t_max_tro_seq_old = (nullToBlank(formObj.max_tro_seq_old.value)=="")? "0" : formObj.max_tro_seq_old.value; 
	    var t_currTroSeq      = formObj.tro_seq.Text;
	    if (parseInt(t_currTroSeq) > parseInt(t_max_tro_seq_old)+1) {
	    	ComEnableManyTd(false, "btn_t2aSaveSeq"); 
	    } else {
	    	ComEnableManyTd(true, "btn_t2aSaveSeq"); 
	    }
	    
	    //3) confirm인경우  버튼 상태 제어 
	    var cfm_flg      = (formObj.cfm_flg.checked)? "Y" : "N"; 
	    if ("Y" == cfm_flg) {
	    	ComEnableManyTd(false, "btn_t2aSaveSeq");
	    	ComEnableManyTd(true, "btn_t2aCopySeq");
	    }
    }    
    
    /**
     * Tro-Master : 수정불가 일괄제어 
     */  
    function changeEnabled_master_control(p_cxl_flg, p_cfm_flg, p_so_no_flg) {
 		var bFlag   = true;
 		
 		//master all : disabled case  
 		//if (p_cxl_flg=="Y" || p_cfm_flg=="Y") {
 		// cancel이거나 so이미 발생 하였거나 confirm이 이미 된 상태이면 기존의 tro변경 불가 조치
 		if (p_cxl_flg == "Y" || p_so_no_flg == "Y" || p_cfm_flg=="Y") {
 			bFlag = false;
 		}
 		
 		//master : all disabled
 		changeEnabled_master(bFlag);
    	
    	//cfm_flg : disabled 
    	changeEnabled_cfmFlg(p_cxl_flg, p_cfm_flg, p_so_no_flg);
    }
    
    /**
    * Tro-Master : all disabled 제어
    */ 
    function changeEnabled_master(bFlag) {
    	var formObj = document.form;
     	with(formObj) {
     		ComEnableManyObjects_loc(bFlag, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, 
     				                        dor_loc_cd, zn_cd, dor_pst_no, act_shpr_addr, 
     				                        cntc_pson_nm, diff_rmk, cntc_phn_no, cntc_fax_no, 
     				                        btns_popActCust, btns_popLocation);
 	    	ComEnableManyIBCombo(bFlag, dcgo_seq, rc_seq, awk_cgo_seq);
 	    	ComEnableManyTd(bFlag, "btn_t2aAdd", "btn_t2aDelete", "btn_t2aCopy", "btn_t2aCopySeq");
     	}
    }
    
    /**
    * Tro-Master : cfm_flg disabled 제어
    */ 
    function changeEnabled_cfmFlg(p_cxl_flg, p_cfm_flg, p_so_no_flg) {
    	var formObj = document.form;
    	
		if (p_cxl_flg == "Y" || p_so_no_flg == "Y" || p_cfm_flg == "Y") {
			ComEnableObject_loc(formObj.cfm_flg, false);	
		} else {
			ComEnableObject_loc(formObj.cfm_flg, true);
		}	    	
    }
    
    /* : DeleteRow할 행에, status값을 설정한다. [chk된 all-row 삭제]  
    function setRowDelStatus_chkall(sheetObj, colId) { 
        var sRow   = sheetObj.FindCheckedRow(colId);
        var arrRow = sRow.split("|");
        for (var idx=arrRow.length-2; idx>=0; idx--)
        { 
            //sum-qty 변경 
            var PM_gubun = "M";  //P:Plus, M:Minus 
            var p_Row = arrRow[idx];
            var p_currVal_type = sheetObj.CellValue(p_Row, "cntr_tpsz_cd");
            var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty");
            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);         	
        	
            if (sheetObj.CellValue(arrRow[idx], "ibflag") == "I") {	
     	         sheetObj.CellValue2    (arrRow[idx], "ibflag") = "D";
            } else {
           	     //sheetObj.CellValue2    (arrRow[idx], "ibflag") = "D";
         	     //sheetObj.CellValue2    (arrRow[idx], "del")    = "Y";
           	     sheetObj.CellValue2    (arrRow[idx], "cxl_flg") = "Y";
         	     sheetObj.RangeFontColor(arrRow[idx], 0, arrRow[idx], sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);    
         	     sheetObj.CellFont("FontStrikethru", arrRow[idx], 0, arrRow[idx], sheetObj.LastCol) = true; 
         	     changeAllCellEditable(sheetObj, arrRow[idx], 3, sheetObj.LastCol, false);
            }
        }
    }  
*/

	/**  
	 * 해당 Sheet의 ibflag('D')인 상태row : Delete Color 처리
	 * : -> dtl cxl/cfm 시, disabled 및 취소선 
	 */ 
    function setRowDelColorChange(sheetObj, colId) {
	    var formObj = document.form;
	
	    var cfm_flg_mst = getMstValue_currSeq(sheetObj, "cfm_flg");
	    var so_no_flg = formObj.so_no_flg.value;
	
	   	for (var i=1; i<=sheetObj.RowCount; i++) {
			if ("Y" == sheetObj.CellValue(i, "cxl_flg")) {
				sheetObj.CellValue2(i, "cxl_flg") = "Y";
				sheetObj.RangeFontColor(i, 0, i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
				sheetObj.CellFont("FontStrikethru", i, 0, i, sheetObj.LastCol) = true; 
				changeAllCellEditable(sheetObj, i, 3, sheetObj.LastCol, false);
			} else if ("Y" == cfm_flg_mst) {
				sheetObj.RangeFontColor(i, 0, i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
				changeAllCellEditable(sheetObj, i, 3, sheetObj.LastCol, false);
			} else if ("Y" == so_no_flg) {
				changeAllCellEditable(sheetObj, i, 3, sheetObj.LastCol, false);
			}
		}
    }
    

    //######################[2. Button Proc : Add/Copy/Cancel/Confirm/Sumqty]#####################
	/**     
	  * confirmSave  
	  */
    function confirmSave() {
	    var formObj = document.form; 
	    var sheetObj_all = x_sheetObject2; 
	    
	    //-----------------------
	    //01. confirm 적용할시간을 구해옴 
    	//var strToDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");       //1) local PC date 를 사용할 때, -> 아래로 대체함 
    	//------------------------------------------------>
    	var bReturn = doActionIBSheet(x_sheetObjMsg, formObj, COMMAND09);  //서버시간을 구해옴 
    	var strToDay = formObj.cfm_sys_date.value;                         //2) system date 조회해 온 값을 사용할 때,  !!!!!!!!!
    	//<------------------------------------------------
    	
    	//----------------------->
    	//02. all row : cfm_flg 변경 
	    for (var i=1; i<=sheetObj_all.RowCount; i++)
	    {
	    	var p_cxl_flg    = sheetObj_all.CellValue(i, "cxl_flg");
	    	var targetTroSeq = sheetObj_all.CellValue(i, "so_no_flg");
	    	var p_so_no_flg  = getExistYnSoNo(targetTroSeq);
	    	
	        if (p_cxl_flg != "Y" && p_so_no_flg != "Y")  //변경불가하지 않은 && 신규 cfm건 일때만   
	    	{
		    	//02-1) cfm_flg변경 
		        sheetObj_all.CellValue2(i, "cfm_flg") = "Y"; 
		    	
		        //02-2) cfm_dt변경  : cfm 대상 row(신규confirm되는 all row에 대해서)
		    	var str_cfm_flg     = sheetObj_all.CellValue(i, "cfm_flg");
		    	var str_cfm_flg_old = sheetObj_all.CellValue(i, "cfm_flg_old"); 
	        	if (str_cfm_flg == "Y" && str_cfm_flg_old == "N") 
	        	{
	        		sheetObj_all.CellValue2(i, "cfm_dt") = strToDay;
	        	}
	    	}
	    }
	    //<-----------------------

	    
	    //------------------------>
	    //화면에 출력된 건이, 변경불가하지 않은 && 신규 cfm건 일때만 
    	var p_cxl_flg       = (formObj.cxl_flg.checked)? "Y" : "N";
    	var str_cfm_flg     = (formObj.cfm_flg.checked)? "Y" : "N";
    	var str_cfm_flg_old = formObj.cfm_flg_old.value; 
    	var p_so_no_flg     = formObj.so_no_flg.value;  
        if (p_cxl_flg != "Y" && p_so_no_flg != "Y" && str_cfm_flg == "Y" && str_cfm_flg_old == "N")
	    {
		    //03-1. 화면 cfm_flg출력 변경 : 동기화 
		    formObj.cfm_flg.checked = true;	
		    
		    //03-2. cfm_dt변경 : cfm 대상 row(check event발생한 화면row만) 
	    	var bResult = setCfmCheck(strToDay); 
	    }
	    
	    //-----------------------
	    //save call 
	    //doActionIBSheet(sheetObj_all, formObj, IBSAVE, "C");  //delFlg -> C: Confirm 
	    doActionIBSheet(sheetObj_all, formObj, IBSAVE, "AC");  //delFlg -> C: Confirm, AC: All Confirm(->msg분기이외에 N:SaveAll 과 동일함) 
	}
 
	/**     
	  * setCfmCheck -> Tro-Master Form  : 화면만 
	  */
	function setCfmCheck(toDay) {
		var formObj = document.form;
		
		with(formObj) {        	
	    	//-------------------------------------------
			//1) cfm_flg : "Y" 일때, Confirm Date setting 
	    	if (cfm_flg.checked) {
	    		cfm_dt.value = toDay;
	    	} else {
	    		cfm_dt.value = "";
	    	}
			//-------------------------------------------
			//2) cfm_flg : "Y" 일때, disabled
	    	var p_cxl_flg   = (formObj.cxl_flg.checked)? "Y" : "N";
	    	var p_cfm_flg   = (formObj.cfm_flg.checked)? "Y" : "N";
	        var p_so_no_flg = formObj.so_no_flg.value; 
	        
	        /* by 신자영  비활성화 제거 요청 
			changeEnabled_cfmFlg(p_cxl_flg, p_cfm_flg, p_so_no_flg);
			*/
		}
	} 
	  
	  
	/**     
	  * cancelAll 
	  */
    function cancelAll() {
	    var formObj = document.form; 
	    var sheetObj_all     = x_sheetObject2; 
	    var sheetObj_all_dtl = x_sheetObject3; 
	
	    sheetObj_all_dtl.ReDraw = false;
	    for (var i=1; i<=sheetObj_all_dtl.RowCount; i++){
			if ("Y" != sheetObj_all_dtl.CellValue(i, "cxl_flg")){
			    sheetObj_all_dtl.CellValue2(i, "cxl_flg") = "Y"; 
			    
	            //sum-qty 변경  
	            var PM_gubun = "M";  //P:Plus, M:Minus 
	            var p_Row = i;
	            var p_currVal_type = sheetObj_all_dtl.CellValue(p_Row, "cntr_tpsz_cd"); 
	            var p_currTroQty   = sheetObj_all_dtl.CellValue(p_Row, "tro_qty"); 
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun); 
	            //cancel all 버튼 시에 SCE call하지 않는 문제 발생 추가 2010.04.27
	            //sheetObj_dtl.CellValue2(i, "cxl_flg") = "Y"; 
	            if (sheetObj_all_dtl.RowStatus(i) == "I") {	
	            	sheetObj_all_dtl.RowStatus(i) = "D";
	            } else {
	            	sheetObj_all_dtl.CellValue2(i, "cxl_flg") = "Y";
	            	sheetObj_all_dtl.RangeFontColor(i, 0, i, sheetObj_all_dtl.LastCol) = sheetObj_all_dtl.RgbColor(255,0,0);    
	            	sheetObj_all_dtl.CellFont("FontStrikethru", i, 0, i, sheetObj_all_dtl.LastCol) = true; 
	            	//changeAllCellEditable(sheetObj_all_dtl, i, 3, sheetObj_dtl.LastCol, false);
	            }
			}		    	
	    }	
	    sheetObj_all_dtl.ReDraw = true;
	    
	    sheetObj_all.ReDraw = false;
	    for (var i=1; i<=sheetObj_all.RowCount; i++){
	    	if ("Y" != sheetObj_all.CellValue(i, "cxl_flg")){
	            sheetObj_all.CellValue2(i, "cxl_flg") = "Y";
	    	}
	    }
	    sheetObj_all.ReDraw = true;
	      
	    //화면 출력 변경  : 동기화 
	    cancelSeq("Y");	 
	    
	    //전역변수 상태정보 변경
	    x_cancelAllFlg = "Y";
	}

	/**     
	  * cancelSeq
	  */
	function cancelSeq(all_gubun) {
  	    var formObj = document.form; 
		var sheetObj_dtl = x_sheetObject1; 
				
		if (all_gubun == null) {
			all_gubun = "N";
		}
		
		//-------------------------------------------
		//1) tro-master : cancel
		formObj.cxl_flg.checked = true;
		
		//-------------------------------------------
		//2) tro-detail : cancel
		for (var i=sheetObj_dtl.RowCount; i>=1; i--)
		{
			if ("Y" != sheetObj_dtl.CellValue(i, "cxl_flg")) 
			{
	            //sum-qty 변경  
	            var PM_gubun = "M";  //P:Plus, M:Minus 
	            var p_Row = i;
	            var p_currVal_type = sheetObj_dtl.CellValue(p_Row, "cntr_tpsz_cd"); 
	            var p_currTroQty   = sheetObj_dtl.CellValue(p_Row, "tro_qty"); 
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);
	            
	            //sheetObj_dtl.CellValue2(i, "cxl_flg") = "Y"; 
	            if (sheetObj_dtl.CellValue(i, "ibflag") == "I") {	
	            	//sheetObj_dtl.CellValue2(i, "ibflag") = "D";
	            	sheetObj_dtl.RowStatus(i) = "D";
	            } else {
	            	sheetObj_dtl.CellValue2(i, "cxl_flg") = "Y";
	            	sheetObj_dtl.RangeFontColor(i, 0, i, sheetObj_dtl.LastCol) = sheetObj_dtl.RgbColor(255,0,0);    
	            	sheetObj_dtl.CellFont("FontStrikethru", i, 0, i, sheetObj_dtl.LastCol) = true; 
	            	changeAllCellEditable(sheetObj_dtl, i, 3, sheetObj_dtl.LastCol, false);
	            }
			}
		}
		
		//cancelSeq시, Master 수정불가 처리 	
    	var cxl_flg   = (formObj.cxl_flg.checked)? "Y" : "N";
    	var cfm_flg   = (formObj.cfm_flg.checked)? "Y" : "N";
        var so_no_flg = formObj.so_no_flg.value;     	
    	changeEnabled_master_control(cxl_flg, cfm_flg, so_no_flg);
	}
	
	/**     
	  * cancel_dtl
	  */
	function cancelDtl() {
  	    var formObj  = document.form; 
		var sheetObj = x_sheetObject1; 
		var colId    = "del_chk";

		//1) tro-detail : cancel
        var sRow   = sheetObj.FindCheckedRow(colId);
        var arrRow = sRow.split("|");
        for (var idx=arrRow.length-2; idx>=0; idx--)
        { 
        	if ("Y" != sheetObj.CellValue(arrRow[idx], "cxl_flg")) 
        	{	
	            //sum-qty 변경 
	            var PM_gubun = "M";  //P:Plus, M:Minus 
	            var p_Row = arrRow[idx];
	            var p_currVal_type = sheetObj.CellValue(p_Row, "cntr_tpsz_cd");
	            var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty");
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);         	
	        	
	            if (sheetObj.CellValue(arrRow[idx], "ibflag") == "I") {	
	     	         //sheetObj.CellValue2    (arrRow[idx], "ibflag")  = "D";
	     	         sheetObj.RowStatus(arrRow[idx])  = "D";
	            } else {
	            	 sheetObj.CellValue2    (arrRow[idx], "cxl_flg") = "Y";
	         	     //sheetObj.CellValue2    (arrRow[idx], "del")     = "Y";
	         	     sheetObj.RangeFontColor(arrRow[idx], 0, arrRow[idx], sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); 
	         	     sheetObj.CellFont("FontStrikethru", arrRow[idx], 0, arrRow[idx], sheetObj.LastCol) = true; 
	         	     changeAllCellEditable(sheetObj, arrRow[idx], 3, sheetObj.LastCol, false);
	            }   
        	}
        }
	}
	  
	/**     
	 *  CopySeq 시, dtl AllCopy 처리로직 제어 
	 */
    function copyAllRow_dtl(sheetObj, newTroSeq, sheetObj_copy, copyTroSeq) {
    	for (var i=1; i<=sheetObj_copy.RowCount; i++) {
    		addRow(sheetObj, "C", i, newTroSeq, sheetObj_copy);  //i:copyRow, sheetObj:x_sheetObject3, sheetObj_copy:x_sheetObject1 
    	} 
    }
	
	/**     
	 *  Copy 시, 처리로직 제어 
	 */
	function copyRow(sheetObj) {
	  	var formObj = document.form;	  	

	    //CancelSeq 된 건, copy 사용불가 check
	  	//2010.03.10 cancel도 copy가능하도록 validatin release
	  	if (formObj.cxl_flg.checked) {
	  	//	callShowMessageReProc("CancelSeq", "Copy");
	  	//	return;
	  	}	
	  	
		sheetObj.ReDraw = false;
	    if (sheetObj.id == "t2asheet2")       //master
	    {
	    	var nCopyRow = sheetObj.FindText("tro_seq", formObj.tro_seq.Text); 
		    addRow(sheetObj, "C", nCopyRow);  
	    } 
	    else if (sheetObj.id == "t2asheet1")  //dtl
	    { 	
			var strCopyCnt = formObj.tro_copy_cnt.value;	
		    if (strCopyCnt == "") {
		    	strCopyCnt = "1";  //없으면, default : 1 
		    }
		    var nCopyCnt = parseInt(strCopyCnt);
		    
	    	var nCopyRow = sheetObj.SelectRow;
	    	if (nCopyRow < 0) {
	    		nCopyRow = 0; 
	    	}
	    	
			for (var i=0; i<nCopyCnt; i++) {
				addRow(sheetObj, "C", nCopyRow);  
			}
		}
	    sheetObj.ReDraw = true;
	}
	   
	function setDataCopy(sheetObj, nNewRow, nCopyRow) {
        var formObj  = document.form;
        var sheetObj = x_sheetObject2;

    	sheetObj.CellValue2(nNewRow, "rqst_dt")          = sheetObj.CellValue(nCopyRow, "rqst_dt");    	
    	sheetObj.CellValue2(nNewRow, "act_shpr_cnt_cd")  = sheetObj.CellValue(nCopyRow, "act_shpr_cnt_cd");
    	sheetObj.CellValue2(nNewRow, "act_shpr_seq")     = sheetObj.CellValue(nCopyRow, "act_shpr_seq");
    	sheetObj.CellValue2(nNewRow, "act_shpr_nm")      = sheetObj.CellValue(nCopyRow, "act_shpr_nm");
    	sheetObj.CellValue2(nNewRow, "dor_loc_cd")       = sheetObj.CellValue(nCopyRow, "dor_loc_cd");
    	sheetObj.CellValue2(nNewRow, "zn_cd")            = sheetObj.CellValue(nCopyRow, "zn_cd");
    	sheetObj.CellValue2(nNewRow, "dor_pst_no")       = sheetObj.CellValue(nCopyRow, "dor_pst_no");    	       	
    	sheetObj.CellValue2(nNewRow, "act_shpr_addr")    = sheetObj.CellValue(nCopyRow, "act_shpr_addr");
    	sheetObj.CellValue2(nNewRow, "cntc_pson_nm")     = sheetObj.CellValue(nCopyRow, "cntc_pson_nm");
    	sheetObj.CellValue2(nNewRow, "diff_rmk")         = sheetObj.CellValue(nCopyRow, "diff_rmk");
    	sheetObj.CellValue2(nNewRow, "cntc_phn_no")      = sheetObj.CellValue(nCopyRow, "cntc_phn_no");
    	sheetObj.CellValue2(nNewRow, "cntc_fax_no")      = sheetObj.CellValue(nCopyRow, "cntc_fax_no");    
    	//sheetObj.CellValue2(nNewRow, "rc_seq")           = sheetObj.CellValue(nCopyRow, "rc_seq");
    	//sheetObj.CellValue2(nNewRow, "awk_cgo_seq")      = sheetObj.CellValue(nCopyRow, "awk_cgo_seq");	   
    	//hidden  
        //sheetObj.CellValue2(nNewRow, "cxl_flg")          = sheetObj.CellValue(nCopyRow, "cxl_flg");
    	sheetObj.CellValue2(nNewRow, "cxl_flg")          = "N";
    	sheetObj.CellValue2(nNewRow, "cfm_flg")          = "N";
    	sheetObj.CellValue2(nNewRow, "cxl_flg_old")      = "N";
    	sheetObj.CellValue2(nNewRow, "cfm_flg_old")      = "N";    	
	}
	   
	function setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy) {
	    var formObj  = document.form;	    
	    if (sheetObj_copy == null) {
	    	sheetObj_copy = sheetObj;
	    }
	    
		sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd")     = sheetObj_copy.CellValue(nCopyRow, "cntr_tpsz_cd"); 
		sheetObj.CellValue2(nNewRow, "tro_qty")          = sheetObj_copy.CellValue(nCopyRow, "tro_qty");
		sheetObj.CellValue2(nNewRow, "dor_arr_dt")       = sheetObj_copy.CellValue(nCopyRow, "dor_arr_dt");
		sheetObj.CellValue2(nNewRow, "dor_arr_dt_hhmi")  = sheetObj_copy.CellValue(nCopyRow, "dor_arr_dt_hhmi");
		sheetObj.CellValue2(nNewRow, "pkup_loc_cd")      = sheetObj_copy.CellValue(nCopyRow, "pkup_loc_cd");
		sheetObj.CellValue2(nNewRow, "pkup_yd_cd")       = sheetObj_copy.CellValue(nCopyRow, "pkup_yd_cd");
		sheetObj.CellValue2(nNewRow, "rtn_loc_cd")       = sheetObj_copy.CellValue(nCopyRow, "rtn_loc_cd"); 
		sheetObj.CellValue2(nNewRow, "rtn_yd_cd")        = sheetObj_copy.CellValue(nCopyRow, "rtn_yd_cd");
		sheetObj.CellValue2(nNewRow, "cmdt_cd")          = sheetObj_copy.CellValue(nCopyRow, "cmdt_cd");     	
		sheetObj.CellValue2(nNewRow, "cntr_no")          = sheetObj_copy.CellValue(nCopyRow, "cntr_no");
		//s/o
		sheetObj.CellValue2(nNewRow, "trsp_so_no")       = "";
		sheetObj.CellValue2(nNewRow, "so_cre_dt")        = "";
		sheetObj.CellValue2(nNewRow, "so_cre_usr_id")    = "";
		sheetObj.CellValue2(nNewRow, "so_usr_nm")        = "";
		sheetObj.CellValue2(nNewRow, "fr_flg")        	 = "";
		//hidden
		//sheetObj.CellValue2(nNewRow, "cxl_flg")          = sheetObj_copy.CellValue(nCopyRow, "cxl_flg");
		sheetObj.CellValue2(nNewRow, "cxl_flg")          = "N";
		sheetObj.CellValue2(nNewRow, "cxl_flg_old")      = "N";	
		sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd_old") = sheetObj_copy.CellValue(nCopyRow, "cntr_tpsz_cd"); 
		sheetObj.CellValue2(nNewRow, "tro_qty_old")      = sheetObj_copy.CellValue(nCopyRow, "tro_qty"); 
	}
	   
    function copyTrodgseq(copy_tro_seq, new_tro_seq) {
	    var sheetObj = x_sheetObject4;  
	   
        //1) dtl check (tro_seq) 
	    sheetObj.CheckAll2("del_chk") = 0;  //hidden chk : check clear
	   
        //2) copy_tro_seq 항목을 checking
        var nRow      = 0;  //findRow 
        var nStartRow = 0;  //find Start Index 
        while (nRow > -1) {
    	    nRow = sheetObj.FindText("tro_seq", copy_tro_seq, nStartRow); 
    	    if (nRow > -1) { 
    		    sheetObj.CellValue2(nRow, "del_chk") = "Y";
    		    nStartRow = nRow+1;
    	    }
        } 

        //3) sheetObj.copy 
        var sRow = sheetObj.FindCheckedRow("del_chk");
        var arrRow = sRow.split("|");
        for (var idx=0; idx<=arrRow.length-2; idx++)
        { 
	        var nNewRow = sheetObj.DataInsert(-1);
	        sheetObj.CellValue2(nNewRow, "tro_seq")      = new_tro_seq;
	        sheetObj.CellValue2(nNewRow, "spcl_cgo_cd")  = sheetObj.CellValue(arrRow[idx], "spcl_cgo_cd");
	        sheetObj.CellValue2(nNewRow, "spcl_cgo_seq") = sheetObj.CellValue(arrRow[idx], "spcl_cgo_seq");
        }
    }  
	
    /**     
    * AddRow시, 처리로직 제어 
    */
    function addRow(sheetObj, NCflag, nCopyRow, newCopyTroSeq, sheetObj_copy) {  //newCopyTroSeq -> dtl-all-copy 에서만 사용됨 
    	var formObj = document.form;    	
    	if (NCflag == null) {
    		NCflag = "N";  //N:New, C:Copy  
    	}    	
    	
    	//---------------------------------------
    	//1) 신규행 추가
    	var nNewRow = sheetObj.DataInsert(-1);   
    	
	    if (sheetObj.id == "t2asheet2"){       //master
	    	if (NCflag == "C") {
				if (x_oldTroSeq != "") {
		    	    setFormToData_TroMst(x_oldTroSeq);  //2-1) tro-master : store 
				}
	    	}
	    	
	    	//---------------------------------------
	        //2-2) default 값  setting : master 
	    	setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow);
	    } 
		else if (sheetObj.id == "t2asheet1")  //dtl
	    { 
	    	//---------------------------------------
	        //2) default 값  setting : dtl  	
	    	var curr_tro_seq = formObj.tro_seq.Text;     	
	    	setDefaultInsertRow_Dtl(sheetObj, nNewRow, curr_tro_seq); 
	    	if (NCflag == "C") {
	    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow);
	    		
	            //sum-qty 변경  
	            var PM_gubun = "P";  //P:Plus, M:Minus 
	            var p_Row = nNewRow;
	            var p_currVal_type = sheetObj.CellValue(p_Row, "cntr_tpsz_cd");
	            var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty"); 
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);
	    	}
	    }
		else if (sheetObj.id == "t2asheet3")  //dtl all : copy 
		{ 
	    	if (NCflag == "C") {
	    		sheetObj.CellValue2(nNewRow, "tro_seq")     = newCopyTroSeq;  //신규Copy한, tro_seq 의 값
	    		sheetObj.CellValue2(nNewRow, "tro_sub_seq") = sheetObj_copy.CellValue(nCopyRow, "tro_sub_seq");  
	    		//sheetObj.CellValue2(nNewRow, "del")         = sheetObj_copy.CellValue(nCopyRow, "del");   //'N';
	    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy);

	            //sum-qty 변경  
	            var PM_gubun = "P";  //P:Plus, M:Minus 
	            var p_Row = nNewRow;
	            var p_currVal_type = sheetObj.CellValue(p_Row, "cntr_tpsz_cd");
	            var p_currTroQty   = sheetObj.CellValue(p_Row, "tro_qty"); 
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);   
	    	}
		}
    	sheetObj.RowStatus(nNewRow) = "I";
    	
    	// Allocation 관련하여 allocation status 가 S 인 경우는 Tro Confirm 항목을 비활성화	
    	if("S"== document.form.aloc_sts_cd.value){
			document.form.cfm_flg.disabled = true;
		}else{
			document.form.cfm_flg.disabled = false;
		}
    	
    	if("R"== document.form.non_rt_sts_cd.value){
			document.form.cfm_flg.disabled = true;
		}else{
			document.form.cfm_flg.disabled = false;
		}
    }
    
    /**     
     * [tro_master]AddRow한 행에, 특정항목의 default값을 설정한다.
     */
    function setDefaultInsertRow(sheetObj, nRow, NCflag, nCopyRow) {
    	var formObj = document.form; 
    	var prevMaxTroSeq = ""; 
    	var newTroSeq     = "";   	
   
		prevMaxTroSeq = getPrevMaxTroSeq(sheetObj, nRow, "tro_seq"); 
		
		//-------------------------------------------
		//2) tro-master : New 기준 grid 초기값 setting 
        sheetObj.CellValue2(nRow, "tro_seq")         = parseInt(prevMaxTroSeq) + 1;  //new tro_seq : max+1
        sheetObj.CellValue2(nRow, "rcv_term_cd")     = formObj.term.value;        
        sheetObj.CellValue2(nRow, "act_shpr_cnt_cd") = formObj.cust_cnt_cd.value;  
        sheetObj.CellValue2(nRow, "act_shpr_seq")    = formObj.cust_seq.value; 
        sheetObj.CellValue2(nRow, "act_shpr_nm")     = formObj.cust_nm.value;          
        sheetObj.CellValue2(nRow, "dor_loc_cd")      = formObj.por_cd.value; 
        if (formObj.por_nod_cd.value.trim() == "") {
        	sheetObj.CellValue2(nRow, "zn_cd")       = "01";  
        } else {
        	sheetObj.CellValue2(nRow, "zn_cd")       = formObj.por_nod_cd.value;  
        }        
        sheetObj.CellValue2(nRow, "cxl_flg")         = "N";  
        sheetObj.CellValue2(nRow, "cfm_flg")         = "N";
        sheetObj.CellValue2(nRow, "cxl_flg_old")     = "N";
        sheetObj.CellValue2(nRow, "cfm_flg_old")     = "N";
	            
	    //-------------------------------------------
    	//3) tro-master Form : tro_seq 콤보선택가능 목록에 추가 (신규추가된  tro_seq)
        newTroSeq = sheetObj.CellValue(nRow, "tro_seq"); 
	    formObj.tro_seq.InsertItem(-1, newTroSeq, newTroSeq);	
	    	    
    	if (NCflag == "C") {
    		//CopyRow  		
            ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount); 
    		setDataCopy(sheetObj, nRow, nCopyRow);  //nNewRow 

            var copyTroSeq = sheetObj.CellValue(nCopyRow, "tro_seq");

    		//dg_seq Copy 
    		copyTrodgseq(copyTroSeq, newTroSeq); 
    		
    		//Dtl All Copy : call
    		copyAllRow_dtl(x_sheetObject3, newTroSeq, x_sheetObject1, copyTroSeq);     		
    	} else {
    		//AddRow 
        	formObj.tro_seq.Text2  = newTroSeq;   
		    ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount); 
        	changeTroSeqProc(); 
        	addRow(x_sheetObject1);  //5) tro-dtl Form 출력 변경(신규추가된  tro_seq)
    	}
    }
    
     /**     
      * [tro_dtl]AddRow한 행에, 특정항목의 default값을 설정한다.
      */
    function  setDefaultInsertRow_Dtl(sheetObj, nRow, tro_seq) { 
      	var formObj = document.form; 
    	var prevMaxTroSubSeq = ""; 
    	
    	prevMaxTroSubSeq = getPrevMaxTroSeq(sheetObj, nRow, "tro_sub_seq");     	

    	sheetObj.CellValue2(nRow, "tro_seq")         = tro_seq;  //현재, tro_seq 콤보의 값
	    sheetObj.CellValue2(nRow, "tro_sub_seq")     = parseInt(prevMaxTroSubSeq) + 1;  //new tro_sub_seq : max+1
        sheetObj.CellValue2(nRow, "tro_qty")         = 1;        //A : tro_qty = 1 고정
        //sheetObj.CellValue2(nRow, "del")             = "N";
	    sheetObj.CellValue2(nRow, "cxl_flg")         = "N"; 
	    sheetObj.CellValue2(nRow, "cxl_flg_old")     = "N"; 
	    sheetObj.CellValue2(nRow, "dor_arr_dt")      = formObj.dor_arr_dt.value;
	    sheetObj.CellValue2(nRow, "dor_arr_dt_hhmi") = formObj.dor_arr_dt_hhmi.value;	    
	    sheetObj.CellValue2(nRow, "pkup_loc_cd")     = formObj.pickup_cy1.value;
	    sheetObj.CellValue2(nRow, "pkup_yd_cd")      = formObj.pickup_cy2.value;
	    sheetObj.CellValue2(nRow, "rtn_loc_cd")      = formObj.return_cy1.value;
	    sheetObj.CellValue2(nRow, "rtn_yd_cd")       = formObj.return_cy2.value;         
        sheetObj.CellValue2(nRow, "cmdt_cd")	     = formObj.cmdt_cd.value;
    }

    /** 
     * 조회시, qtysum color 초기화 
     */  
    function changeTroQtyColor(sheetObj_qty) {
       	var formObj = document.form;  	
       	
       	for(var i=1; i<=sheetObj_qty.RowCount; i++) {
   	    	var cntr_tpsz_cd = sheetObj_qty.CellValue(i, "cntr_tpsz_cd");
   	    	var n_totQty     = parseInt(sheetObj_qty.CellValue(i, "total_qty")); 
   			var n_currTroqty = parseInt(sheetObj_qty.CellValue(i, "tro_qty"));  
   			
   			if (n_totQty > n_currTroqty) {
   				sheetObj_qty.CellFontColor(i, "tro_qty") = sheetObj_qty.RgbColor(255,0,0); 
   			} else if (n_totQty == n_currTroqty) {
   				sheetObj_qty.CellFontColor(i, "tro_qty") = sheetObj_qty.RgbColor(0,0,0); 
   			} else if (nullToBlank(sheetObj_qty.CellValue(i, "tro_qty")) != "") {
   				sheetObj_qty.CellFontColor(i, "tro_qty") = sheetObj_qty.RgbColor(255,0,0); 
   				//callShowMessageBiggerQty(sheetObj_qty.CellValue(i, "cntr_tpsz_cd"));
   			}
       	}
    }  
      
    /**     
     * [tro_dtl]변경시, sumqty 출력변경 : All(P/M)
     */
	function changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, p_Row) {
	  	var formObj      = document.form;
	  	var sheetObj     = x_sheetObject1; 
	  	var sheetObj_qty = x_sheetObject5; 
	  	
	  	sheetObj_qty.ReDraw = false; 	  	
	    var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);     	
	    if (nSRow > -1) 
        {
	    	var n_totQty      = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty")); 
			var n_currTroqty  = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty")); 
			var n_t_chgTroqty = n_currTroqty + parseInt(nxtTroQty);   
			
			//*) 체크추가 -------->
			if (n_totQty > n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty") = sheetObj_qty.RgbColor(255,0,0); 
			} else if (n_totQty == n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty") = sheetObj_qty.RgbColor(0,0,0); 
			} else {
				callShowMessageBiggerQty(sheetObj_qty.CellValue(nSRow, "cntr_tpsz_cd"));
				
				sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preVal_type;  //변경전 값으로 재변경 
				//sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preTroQty;  //변경전 값으로 재변경    
				sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
				sheetObj_qty.ReDraw = true; 
				return;
			}
			//<-------------------
			
			//1) next qty (+)처리 
			sheetObj_qty.CellValue2(nSRow, "tro_qty") = n_t_chgTroqty; 
			
		  	//2) pre qty (-)처리 
		  	var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", preVal_type); 
		  	if (nSRow > -1) 
		  	{
		    	var n_totQty      = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty")); 
				var n_currTroqty  = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty")); 
				var n_t_chgTroqty = n_currTroqty - parseInt(preTroQty);
				
				sheetObj_qty.CellValue2(nSRow, "tro_qty") = n_t_chgTroqty;
		  		
		  		//색상변경
			  	if (n_totQty > n_t_chgTroqty) {
					sheetObj_qty.CellFontColor(nSRow, "tro_qty") = sheetObj_qty.RgbColor(255,0,0); 
				} else if (n_totQty == n_t_chgTroqty) {
					sheetObj_qty.CellFontColor(nSRow, "tro_qty") = sheetObj_qty.RgbColor(0,0,0); 
				}
		  	} 
		  	
		  	//3) currVal -> oldVal 
			sheetObj.CellValue2(p_Row, "cntr_tpsz_cd_old") = nxtVal_type;  
			sheetObj.CellValue2(p_Row, "tro_qty_old")      = nxtTroQty; 
        } else {
        	ComShowCodeMessage("BKG00297");  //등록할 수 없는 TP/SZ 
			
			sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preVal_type;  //변경전 값으로 재변경
			//sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preTroQty;  //변경전 값으로 재변경    
			sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
		}
		sheetObj_qty.ReDraw = true; 
	}
	
    /**     
    * [tro_dtl]변경시, sumqty 출력변경 : Option(P/M)
    */	
	function plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun) {
	  	var formObj      = document.form;
  	  	var sheetObj_qty = x_sheetObject5; 
  	    var sheetObj     = x_sheetObject1; 
  	  		  	
	  	sheetObj_qty.ReDraw = false; 
	  	if ("P" == PM_gubun) {
			var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", p_currVal_type);     	
		  	if (nSRow > -1) 
		  	{
		    	var n_totQty      = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty")); 
		    	var n_currTroqty  = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty")); 
				var n_t_chgTroqty = n_currTroqty + parseInt(p_currTroQty);  //Copy 
		  		
				//*) 체크추가 -------->
				if (n_totQty > n_t_chgTroqty) {
					sheetObj_qty.CellFontColor(nSRow, "tro_qty") = sheetObj_qty.RgbColor(255,0,0); 
				} else if (n_totQty == n_t_chgTroqty) {
					sheetObj_qty.CellFontColor(nSRow, "tro_qty") = sheetObj_qty.RgbColor(0,0,0); 
				} else {
					callShowMessageBiggerQty(sheetObj_qty.CellValue(nSRow, "cntr_tpsz_cd"));
					
					var preVal_type = sheetObj.CellValue2(p_Row, "cntr_tpsz_cd_old"); 
					//var preTroQty = sheetObj.CellValue2(p_Row, "tro_qty_old");
					
					sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preVal_type;  //변경전 값으로 재변경 
					//sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preTroQty;  //변경전 값으로 재변경  
					sheetObj.SelectCell(p_Row, "cntr_tpsz_cd"); 
					sheetObj_qty.ReDraw = true; 
					return; 
				}
				//<-------------------
		  		
		  		sheetObj_qty.CellValue2(nSRow, "tro_qty") = n_t_chgTroqty;
		  	}
	    } else if ("M" == PM_gubun) {
		  	var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", p_currVal_type); 
		  	if (nSRow > -1) 
		  	{
		  		var currTroqty = sheetObj_qty.CellValue(nSRow, "tro_qty");
		  		sheetObj_qty.CellValue2(nSRow, "tro_qty") = parseInt(currTroqty) - parseInt(p_currTroQty);  //Delete
	      	} 
	  	} 
	  	sheetObj_qty.ReDraw = true; 
	}    
	  
	/**
	 * Copy/CopySeq 전, troqty 수량초과 체크 
	 */  
	function checkCopySumTroqty(sheetObj) {
	    var formObj = document.form;
	    var sheetObj_qty = x_sheetObject5;
	    var sheetObj_dtl = x_sheetObject1;
	    
	    if (sheetObj.id == "t2asheet1") 
	    {
			var nCopyCnt = formObj.tro_copy_cnt.value;	
		    if (nCopyCnt == "") {
		    	nCopyCnt = 1;  //없으면, default : 1 
		    }
	    	var nCopyRow = sheetObj.SelectRow;
	    	if (nCopyRow < 0) {
	    		nCopyRow = 0; 
	    	}
			var n_t_troqty        = parseInt(sheetObj.CellValue(nCopyRow, "tro_qty"));  
			var n_t_sumqty        = n_t_troqty * nCopyCnt; 
			var cntr_tpsz_cd_copy = sheetObj.CellValue(nCopyRow, "cntr_tpsz_cd"); 
			
			var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", cntr_tpsz_cd_copy); 
 		  	if (nSRow > -1) {
 		  		var totqty       = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty"));
 		  	    var currTroqty   = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty"));
 		  	    var changeTroqty = currTroqty + n_t_sumqty;
 		  	    
 		  	    if (totqty < changeTroqty) {
 		  	        callShowMessageBiggerQty(sheetObj_qty.CellValue(nSRow, "cntr_tpsz_cd"));
 		  	        return false;
 		  	    }
 		  	}
	    } 
	    else if (sheetObj.id == "t2asheet2") 
	    {	    
	    	for (var i=1; i<=sheetObj_qty.RowCount; i++) {
	    		var i_cntr_tpsz_cd = sheetObj_qty.CellValue(i, "cntr_tpsz_cd"); 
	    		
	    		var n_t_sumqty = 0;
	    		for (var j=1; j<=sheetObj_dtl.RowCount; j++) {
	    			var j_cntr_tpsz_cd = sheetObj_dtl.CellValue(j, "cntr_tpsz_cd"); 
	    			if (j_cntr_tpsz_cd == i_cntr_tpsz_cd) {
	    	    		var n_t_troqty = parseInt(sheetObj_dtl.CellValue(j, "tro_qty"));
	    				n_t_sumqty += n_t_troqty;  
	    			}
	    		}

 		  		var totqty       = parseInt(sheetObj_qty.CellValue(i, "total_qty"));
 		  	    var currTroqty   = parseInt(sheetObj_qty.CellValue(i, "tro_qty"));
 		  	    var changeTroqty = currTroqty + n_t_sumqty; 
 		  	    if (totqty < changeTroqty) {
 		  	        callShowMessageBiggerQty(sheetObj_qty.CellValue(i, "cntr_tpsz_cd"));
 		  	        return false;
 		  	    }
	    	}
	    }
	    
	    return true;
	}  


	//######################[3. Data Display/Store (Master/Detail)]###############################
    /** 
     * Tro-Mastr 출력 (Sheet -> Form : Display)
     */
    function setDataToForm_TroMst(tro_seq) {
        var objForm  = document.form;
        var sheetObj = x_sheetObject2; 
       
        //-----------------------------------
        //1) tro_seq Value에 해당하는 row로 초기화 
        var nRow = sheetObj.FindText("tro_seq", tro_seq); 

       //-----------------------------------
       //2) 출력 
       //if(sheetObj.RowCount > 1){ IBS_CopyRowToForm(sheetObj, formObj, nRow, ""); }   //공통메소드 작동않함. 
       with(objForm) {
           tro_seq.Text2 = sheetObj.CellValue(nRow, "tro_seq");  
           if (x_oldTroSeq == "") { 
               x_oldTroSeq = tro_seq.Text; 
           } 
    	   
    	   ComSetObjValue(tro_seq_maxcnt,   sheetObj.RowCount); 
    	   ComSetObjValue(rcv_term_cd,      nullToBlank(sheetObj.CellValue(nRow, "rcv_term_cd")));
    	   ComSetObjValue(rqst_dt,          nullToBlank(sheetObj.CellValue(nRow, "rqst_dt")));
    	   ComSetObjValue(act_shpr_cnt_cd,  nullToBlank(sheetObj.CellValue(nRow, "act_shpr_cnt_cd")));
    	   ComSetObjValue(act_shpr_seq,     nullToBlank(sheetObj.CellValue(nRow, "act_shpr_seq")));
    	   ComSetObjValue(act_shpr_nm,      nullToBlank(sheetObj.CellValue(nRow, "act_shpr_nm")));
    	   ComSetObjValue(dor_loc_cd,       nullToBlank(sheetObj.CellValue(nRow, "dor_loc_cd")));
    	   ComSetObjValue(zn_cd,            nullToBlank(sheetObj.CellValue(nRow, "zn_cd")));
    	   ComSetObjValue(dor_pst_no,       nullToBlank(sheetObj.CellValue(nRow, "dor_pst_no")));    	   
    	   //ComSetObjValue(cfm_flg,          nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")));
    	   cfm_flg.checked = (nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")) == "Y") ? true : false;     	
    	   ComSetObjValue(cfm_flg_old,      nullToBlank(sheetObj.CellValue(nRow, "cfm_flg_old"))); 
    	   ComSetObjValue(cfm_dt,           nullToBlank(sheetObj.CellValue(nRow, "cfm_dt")));    	   
    	   ComSetObjValue(act_shpr_addr,    nullToBlank(sheetObj.CellValue(nRow, "act_shpr_addr")));
    	   ComSetObjValue(cntc_pson_nm,     nullToBlank(sheetObj.CellValue(nRow, "cntc_pson_nm")));
    	   ComSetObjValue(diff_rmk,         nullToBlank(sheetObj.CellValue(nRow, "diff_rmk")));
    	   ComSetObjValue(cntc_phn_no,      nullToBlank(sheetObj.CellValue(nRow, "cntc_phn_no")).replace(/[^0-9]/gi,"")); // tel 에 숫자만 입력가능
//    	   alert(nullToBlank(sheetObj.CellValue(nRow, "cntc_phn_no")))
    	   ComSetObjValue(cntc_fax_no,      nullToBlank(sheetObj.CellValue(nRow, "cntc_fax_no")));
    	   //rc_seq.Text2 = sheetObj.CellValue(nRow, "rc_seq"); 
    	   //ComSetObjValue(awk_cgo_seq,      nullToBlank(sheetObj.CellValue(nRow, "awk_cgo_seq")));
    	   //hidden  
    	   cxl_flg.checked = (nullToBlank(sheetObj.CellValue(nRow, "cxl_flg")) == "Y") ? true : false;     
    	   ComSetObjValue(cxl_flg_old,      nullToBlank(sheetObj.CellValue(nRow, "cxl_flg_old"))); 
    	   
    	   //<B>-->            
    	   ComSetObjValue(so_flg,       nullToBlank(sheetObj.CellValue(nRow, "so_flg")));    	    
    	   ownr_trk_flg.checked = (nullToBlank(sheetObj.CellValue(nRow, "ownr_trk_flg")) == "Y") ? true : false;  
    	   ComSetObjValue(biz_rgst_no,  nullToBlank(sheetObj.CellValue(nRow, "biz_rgst_no")));
    	   ComSetObjValue(cntc_mphn_no, nullToBlank(sheetObj.CellValue(nRow, "cntc_mphn_no")));
    	   //ComSetObjValue(ack_sts_cd, nullToBlank(sheetObj.CellValue(nRow, "ack_sts_cd")));    	   
    	   //<--<B>

           //-----------------------------------
           //2-1) spcl_cgo_seq 화면출력
    	   setDataToForm_Tro_dg_seq(sheetObj.CellValue(nRow, "tro_seq"));
       }
       
   }  

    /** 
     * Tro-Master Temp 저장 (Form ->Sheet  : Store)
     */
    function setFormToData_TroMst(prev_tro_seq) {
    	var objForm  = document.form; 
        var sheetObj = x_sheetObject2; 
     		
        sheetObj.Redraw = false;  //----------------->
        
        //-----------------------------------
        // 1) tro_seq Value에 해당하는 row : delete 처리
        var nRow = sheetObj.FindText("tro_seq", prev_tro_seq); 
   
        //-----------------------------------
        // 2) Store(Update) 
        with(objForm) {
        	sheetObj.CellValue2(nRow, "tro_seq")          = prev_tro_seq;  
        	sheetObj.CellValue2(nRow, "rcv_term_cd")      = ComGetObjValue(rcv_term_cd);
        	sheetObj.CellValue2(nRow, "rqst_dt")          = ComGetObjValue(rqst_dt);
        	sheetObj.CellValue2(nRow, "act_shpr_cnt_cd")  = ComGetObjValue(act_shpr_cnt_cd);
        	sheetObj.CellValue2(nRow, "act_shpr_seq")     = ComGetObjValue(act_shpr_seq);
        	sheetObj.CellValue2(nRow, "act_shpr_nm")      = ComGetObjValue(act_shpr_nm);
        	sheetObj.CellValue2(nRow, "dor_loc_cd")       = ComGetObjValue(dor_loc_cd);
        	sheetObj.CellValue2(nRow, "zn_cd")            = ComGetObjValue(zn_cd);
        	sheetObj.CellValue2(nRow, "dor_pst_no")       = ComGetObjValue(dor_pst_no);
        	sheetObj.CellValue2(nRow, "cfm_flg")          = (cfm_flg.checked==true) ? "Y" : "N"; 
        	sheetObj.CellValue2(nRow, "cfm_dt")           = ComGetObjValue(cfm_dt); 
        	sheetObj.CellValue2(nRow, "act_shpr_addr")    = ComGetObjValue(act_shpr_addr);
        	sheetObj.CellValue2(nRow, "cntc_pson_nm")     = ComGetObjValue(cntc_pson_nm);
        	sheetObj.CellValue2(nRow, "diff_rmk")         = ComGetObjValue(diff_rmk);
        	sheetObj.CellValue2(nRow, "cntc_phn_no")      = ComGetObjValue(cntc_phn_no);
        	sheetObj.CellValue2(nRow, "cntc_fax_no")      = ComGetObjValue(cntc_fax_no);
        	//sheetObj.CellValue2(nRow, "rc_seq")           = rc_seq.Text; 
        	//sheetObj.CellValue2(nRow, "awk_cgo_seq")      = ComGetObjValue(awk_cgo_seq);    
        	//hidden  
            sheetObj.CellValue2(nRow, "cxl_flg")          = (cxl_flg.checked==true) ? "Y" : "N";  
        	
            //<B>-->            
            sheetObj.CellValue2(nRow, "so_flg")           = ComGetObjValue(so_flg);
            sheetObj.CellValue2(nRow, "ownr_trk_flg")     = (ownr_trk_flg.checked==true) ? "Y" : "N";  
            sheetObj.CellValue2(nRow, "biz_rgst_no")      = ComGetObjValue(biz_rgst_no);
            sheetObj.CellValue2(nRow, "cntc_mphn_no")     = ComGetObjValue(cntc_mphn_no);
            //sheetObj.CellValue2(nRow, "ack_sts_cd")       = ComGetObjValue(ack_sts_cd);
            //<--<B>
            
            //-----------------------------------
            // 2-1) dg_seq Store
        	//sheetObj.CellValue2(nRow, "dcgo_seq")         = dcgo_seq.Text; 
            setFormToData_Tro_dg_seq(prev_tro_seq); 
        }  
        
        sheetObj.Redraw = true;  //<------------------       
    } 

    /** 
    * Tro-Detail 출력 ( HiddenSheet -> Sheet : Display ) 
    */
    function setAllDataToData_TroDtl(tro_seq) {
        var formObj         = document.form;
        var sheetObj        = x_sheetObject2;
        var sheetObjDtl     = x_sheetObject1; 
        var sheetObjDtl_All = x_sheetObject3; 
       
        sheetObjDtl.Redraw     = false;  //----------------->
        sheetObjDtl_All.Redraw = false;
       
        //--------------------------------
        //1) 초기화 
        sheetObjDtl_All.CheckAll2("chk") = 0;  //dtl_all check 초기화
        sheetObjDtl.RemoveAll();               //dtl grid 초기화 
       
        //--------------------------------
        //2) dtl check (tro_seq)       
        for (var i=1; i<=sheetObjDtl_All.RowCount; i++) {
    	    var tempTro_seq = sheetObjDtl_All.CellValue(i, "tro_seq");
    	    if (tro_seq == tempTro_seq) {
    		    sheetObjDtl_All.CellValue2(i, "chk") = "1";
    	    }
        }
       
        //-------------------------------- 
        //3) ComMakeSearchXml
        var strSaveNames = "ibflag|tro_seq|tro_sub_seq|cntr_tpsz_cd|tro_qty|dor_arr_dt|dor_arr_dt_hhmi|"+
                           "pkup_loc_cd|pkup_yd_cd|rtn_loc_cd|rtn_yd_cd|cmdt_cd|cntr_no|split_rmk|"+
                           "trsp_so_no|so_cre_dt|so_cre_usr_id|so_usr_nm|trsp_wo_no|trsp_wo_ofc_cty_cd|trsp_wo_seq|fr_flg|"+  //s/o
                           "cxl_flg|cxl_flg_old|cntr_tpsz_cd_old|tro_qty_old";  
        var sXml = ComMakeSearchXml(sheetObjDtl_All, false, "chk", strSaveNames, true);  //all column : move 
              
        //--------------------------------
        //4) LoadSearchXml (출력용  dtl grid) 
        sheetObjDtl.LoadSearchXml(sXml, true);
       
        //--------------------------------
        //5) ibflag('D')인 상태row->cxl_flg="Y"인 상태row : Hidden 처리 -> 색상만 변경함
        setRowDelColorChange(sheetObjDtl, "del_chk");
       
        sheetObjDtl_All.Redraw = true;
        sheetObjDtl.Redraw     = true;  //<------------------
    }       

    /** 
     * Tro-Detail Temp 저장   ( Sheet -> HidenSheet : Store )
     */
    function setDataToAllData_TroDtl(prev_tro_seq, del_flag) {    
        var sheetObjDtl     = x_sheetObject1; 
        var sheetObjDtl_All = x_sheetObject3; 
       
        if (del_flag == null) {
    	    del_flag = true; //default : true(삭제)
        }       
        sheetObjDtl.Redraw = false;  //----------------->
       
        //--------------------------------
        //1) dtl check (tro_seq) 
        sheetObjDtl.CheckAll2("chk") = 1;  //hidden chk : dtl_all check 초기화
       
        //--------------------------------
        //2) dtl-all delete (tro_seq)
        deleteRowDtlAll(prev_tro_seq);   
       
        //-------------------------------- 
        //3) ComMakeSearchXml / LoadSearchXml (출력용  dtl grid) 
        var strSaveNames = "ibflag|tro_seq|tro_sub_seq|cntr_tpsz_cd|tro_qty|dor_arr_dt|dor_arr_dt_hhmi|"+
                           "pkup_loc_cd|pkup_yd_cd|rtn_loc_cd|rtn_yd_cd|cmdt_cd|cntr_no|split_rmk|"+
                           "trsp_so_no|so_cre_dt|so_cre_usr_id|so_usr_nm|trsp_wo_no|trsp_wo_ofc_cty_cd|trsp_wo_seq|fr_flg|"+  //s/o
                           "cxl_flg|cxl_flg_old|cntr_tpsz_cd_old|tro_qty_old"; 
        var sXml = ComMakeSearchXml(sheetObjDtl, false, "chk", strSaveNames, del_flag);  //all column : move/copy (true:삭제함)
        sheetObjDtl_All.LoadSearchXml(sXml, true); 
       
        sheetObjDtl.Redraw = true;  //<------------------        
    }
   
    function deleteRowDtlAll(prev_tro_seq) {
	    var sheetObj = x_sheetObject3;
	   
        //--------------------------------
        //1) dtl check (tro_seq) 
	    sheetObj.CheckAll2("del_chk") = 0;  //hidden chk : check clear
	   
        //2) prev_tro_seq 항목을 삭제 flag setting  
        var nRow      = 0;  //findRow 
        var nStartRow = 0;  //find Start Index 
        while (nRow > -1) {
    	    nRow = sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow); 
    	    if (nRow > -1) {    		   
    		    sheetObj.CellValue2(nRow, "del_chk") = "Y";
    		    nStartRow = nRow+1;
    	    }
        } 
     
        //3) sheetObj.RowDelete(); 
        var sRow = sheetObj.FindCheckedRow("del_chk");
        var arrRow = sRow.split("|");
        for (var idx=arrRow.length-2; idx>=0; idx--)
        { 
    	    sheetObj.RowDelete(arrRow[idx], false);
        }
    }


    //######################[4. Data Display/Store (Etc : Header/Combo)]##########################
    /**
    * Header 출력(Booking 정보) 
    * : ComEtcDataToForm()함수대신, EtcData를 화면에 View 
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData --> Form 
        //IBS_EtcDataToForm(formObj, sheetObj);
        with (formObj) 
        {	
	        por_nod_cd.value      = nullToBlank(sheetObj.EtcData("por_nod_cd")); 	        
	        skd_dir_cd.value      = nullToBlank(sheetObj.EtcData("skd_dir_cd")); 
	        cust_seq.value        = nullToBlank(sheetObj.EtcData("cust_seq")); 
	        fd_grd_flg.value      = nullToBlank(sheetObj.EtcData("fd_grd_flg")); 
	        spcl_hide_flg.value   = nullToBlank(sheetObj.EtcData("spcl_hide_flg"));
	        pol_code.value        = nullToBlank(sheetObj.EtcData("pol_code")); 
	        bkg_sts_cd.value      = nullToBlank(sheetObj.EtcData("bkg_sts_cd")); 
	        cmdt_nm.value         = nullToBlank(sheetObj.EtcData("cmdt_nm")); 
	        //bl_tp_cd.value        = nullToBlank(sheetObj.EtcData("bl_tp_cd")); 
	        bkg_no.value          = nullToBlank(sheetObj.EtcData("bkg_no")); 
	        bl_no.value           = nullToBlank(sheetObj.EtcData("bl_no")); 	        
	        cust_cnt_cd.value     = nullToBlank(sheetObj.EtcData("cust_cnt_cd")); 
	        cust_nm.value         = nullToBlank(sheetObj.EtcData("cust_nm"));
	        cmdt_cd.value         = nullToBlank(sheetObj.EtcData("cmdt_cd")); 	        
	        conti_cd.value        = nullToBlank(sheetObj.EtcData("conti_cd")); 
	        del_cd.value          = nullToBlank(sheetObj.EtcData("del_cd")); 	        
	        term.value            = nullToBlank(sheetObj.EtcData("term")); 
	        por_cd.value          = nullToBlank(sheetObj.EtcData("por_cd")); //<------- sheet2 의 dor_loc_cd 가 된다.
	        pod_cd.value          = nullToBlank(sheetObj.EtcData("pod_cd")); 
	        skd_voy_no.value      = nullToBlank(sheetObj.EtcData("skd_voy_no")); 
	        etb_dt.value          = nullToBlank(sheetObj.EtcData("etb_dt"));
	        vsl_cd.value          = nullToBlank(sheetObj.EtcData("vsl_cd"));  	        
	        dor_arr_dt.value      = nullToBlank(sheetObj.EtcData("dor_arr_dt")); 
	        dor_arr_dt_hhmi.value = nullToBlank(sheetObj.EtcData("dor_arr_dt_hhmi"));
	        //bkg_rep_cmdt_cd.value = nullToBlank(sheetObj.EtcData("bkg_rep_cmdt_cd")); 	 
	        //bkg_rep_cmdt_nm.value = nullToBlank(sheetObj.EtcData("bkg_rep_cmdt_nm"));
	        //act_wgt.value         = nullToBlank(sheetObj.EtcData("act_wgt")); 
	        //wgt_ut_cd.value       = nullToBlank(sheetObj.EtcData("wgt_ut_cd"));
	        //bkg_cgo_tp_cd.value   = nullToBlank(sheetObj.EtcData("bkg_cgo_tp_cd")); 
	        aloc_sts_cd.value = nullToBlank(sheetObj.EtcData("aloc_sts_cd"));
	        non_rt_sts_cd.value = nullToBlank(sheetObj.EtcData("non_rt_sts_cd"));  //jsy 다음 반영시 주석 품
        }

        var t_returnCy = nullToBlank(sheetObj.EtcData("return_cy"));  
	    if (t_returnCy.length >= 7) {
	    	formObj.return_cy1.value  = t_returnCy.substr(0, 5);
	    	formObj.return_cy2.value  = t_returnCy.substr(5, 2);	    	
	    } else {
	    	formObj.return_cy1.value = t_returnCy;
	    	formObj.return_cy2.value = "";
	    }

	    var t_pickupCy = nullToBlank(sheetObj.EtcData("pickup_cy"));
	    if (t_pickupCy.length >= 7) {
	    	formObj.pickup_cy1.value  = t_pickupCy.substr(0, 5);
	    	formObj.pickup_cy2.value  = t_pickupCy.substr(5, 2);
	    } else {
	    	formObj.pickup_cy1.value = t_pickupCy;
	    	formObj.pickup_cy2.value = "";
	    }
	   
        //------------------------------
        //hidden에 조회된 booking코드 보관
        formObj.oldBkgNo.value    = nullToBlank(sheetObj.EtcData("bkg_no"));
        formObj.oldBlNo.value     = nullToBlank(sheetObj.EtcData("bl_no"));
        formObj.ca_flg.value      = nullToBlank(sheetObj.EtcData("ca_flg"));
       
        //------------------------------------------------
        // Receiving Term : 'D'이외의 경우, 경고메세지 출력
        if ("D" != formObj.term.value) {
    	    ComShowCodeMessage("BKG02021");  //"Receiving Term is not 'D' !"
        }
        //zip : 필수입력
        if ("US" == formObj.por_cd.value.substr(0,2)) {
    	    document.getElementById("dor_pst_no").className = "input1";
    	    document.getElementById("dor_pst_no").setAttribute('required','');
        } else {
    	    document.getElementById("dor_pst_no").className = "input";   
    	    document.getElementById("dor_pst_no").removeAttribute('required');
        }
	   
	    //checkbox 출력 재처리 --------------------------> 
	    var dcgo_flg    = nullToBlank(sheetObj.EtcData("dcgo_flg")); 
	    var rc_flg      = nullToBlank(sheetObj.EtcData("rc_flg"));  
	    var awk_cgo_flg = nullToBlank(sheetObj.EtcData("awk_cgo_flg")); 
	    var bb_cgo_flg  = nullToBlank(sheetObj.EtcData("bb_cgo_flg")); 
	    var rd_cgo_flg  = nullToBlank(sheetObj.EtcData("rd_cgo_flg")); 
	    formObj.dcgo_flg.checked    = (dcgo_flg    == "Y") ? true : false;
	    formObj.rc_flag.checked     = (rc_flg      == "Y") ? true : false;
	    formObj.awk_cgo_flg.checked = (awk_cgo_flg == "Y") ? true : false;
	    formObj.bb_cgo_flg.checked  = (bb_cgo_flg  == "Y") ? true : false;
	    formObj.rd_cgo_flg.checked  = (rd_cgo_flg  == "Y") ? true : false;
	    //<---------------------------checkbox 출력 재처리 
	   
	    //버튼링크/버튼 출력처리 -------------------------->
	    changeDisplayBtn("btn_Danger",  dcgo_flg);
	    changeDisplayBtn("btn_Reefer",  rc_flg);
	    changeDisplayBtn("btn_Awkward", awk_cgo_flg);
	    changeDisplayBtn("btn_Bulk",    bb_cgo_flg);
	    //<----------------------------------------------
	    
	    //Search 완료후, 버튼 enabled
 		if (formObj.oldBkgNo.value != "") {
 		    ComEnableManyTd(true, "btn_t2aSave", "btn_t2aSaveConfirm", "btn_t2aCancelAll", "btn_t2aTROCopy", 
		                          "btn_t2aAddSeq", "btn_t2aCopySeq", "btn_t2aCancelSeq", 
                                  "btn_t2aAdd", "btn_t2aDelete", "btn_t2aCopy");
 		    //ComEnableManyTd(false, "btn_t2aCancelAll");
 		}
    }
    

    /** 
    * Tro-Mastr spcl_cgo_seq 출력 : (multi콤보값) 
    */
    function setDataToForm_Tro_dg_seq(tro_seq) {
        var objForm    = document.form;
        var sheetObj   = x_sheetObject4; 
        var comboObj_1 = objForm.dcgo_seq; 
        var comboObj_2 = objForm.rc_seq; 
        var comboObj_3 = objForm.awk_cgo_seq; 
        var comboId    = "spcl_cgo_seq";
        
        var nRow      = 0;  //findRow 
        var nStartRow = 0;
        var strCode_1 = ""; //code 초기화
        var strCode_2 = ""; //code 초기화 
        var strCode_3 = ""; //code 초기화
        
        while (nRow > -1) {
    	    nRow = sheetObj.FindText("tro_seq", tro_seq, nStartRow); 
    	    if (nRow > -1) {
    	    	var spcl_cgo_cd = sheetObj.CellValue(nRow, "spcl_cgo_cd");
    	    	switch(spcl_cgo_cd) {
    	    	    case "DG":
    	    		    if (strCode_1 == "") {
    	    			    strCode_1 += sheetObj.CellValue(nRow, comboId);
    	    		    } else {
    	    			    strCode_1 += "|"+sheetObj.CellValue(nRow, comboId);
    	    		    }
    	    	    	break;
    	    	    	
    	    	    case "RF":
    	    		    if (strCode_2 == "") {
    	    			    strCode_2 += sheetObj.CellValue(nRow, comboId);
    	    		    } else {
    	    			    strCode_2 += "|"+sheetObj.CellValue(nRow, comboId);
    	    		    }
    	    	    	break;
    	    	    	
    	    	    case "AK":
    	    		    if (strCode_3 == "") {
    	    			    strCode_3 += sheetObj.CellValue(nRow, comboId);
    	    		    } else {
    	    			    strCode_3 += "|"+sheetObj.CellValue(nRow, comboId);
    	    		    }
    	    	    	break;
    	    	}
                nStartRow = nRow+1;
    	    }
        } 
       
        //해당 tro_seq의 spcl_cgo_seq 를 각각 화면에 체크 출력 
        comboObj_1.Text2 = strCode_1;
        comboObj_2.Text2 = strCode_2;
        comboObj_3.Text2 = strCode_3;
    }
    
    /** 
     * Tro-Mastr spcl_cgo_seq Store_pre : (multi콤보값) 
     */
    function setFormToData_Tro_dg_seq(prev_tro_seq) {
        var objForm    = document.form;
        var sheetObj   = x_sheetObject4; 
        var comboObj_1 = objForm.dcgo_seq; 
        var comboObj_2 = objForm.rc_seq; 
        var comboObj_3 = objForm.awk_cgo_seq; 

        //1) prev_tro_seq 항목을 삭제 flag setting  
        var nRow      = 0;  //findRow 
        var nStartRow = 0;  //find Start Index 
        while (nRow > -1) 
	    {
    	    nRow = sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow); 
    	    if (nRow > -1) 
		    {    		   
    		    sheetObj.CellValue2(nRow, "del_chk") = "Y";
    		    nStartRow = nRow+1;
    	    }
        } 

        //2) prev_tro_seq 항목을 삭제 : 체크선택된 행을 모두 화면에서 삭제(서버에도 않보냄)        
        var sRow   = sheetObj.FindCheckedRow("del_chk");
        var arrRow = sRow.split("|");
        for (var idx=arrRow.length-2; idx>=0; idx--)
        { 
    	    sheetObj.RowDelete(arrRow[idx], false);
        }
       
        //3) comboObj.Text를 parsing
        comboCodeToSheet(sheetObj, comboObj_1, "DG", prev_tro_seq);
        comboCodeToSheet(sheetObj, comboObj_2, "RF", prev_tro_seq);
        comboCodeToSheet(sheetObj, comboObj_3, "AK", prev_tro_seq);
    }
    
    /** 
    * Tro-Mastr spcl_cgo_seq Store : (multi콤보값) 
    */
    function comboCodeToSheet(sheetObj, comboObj, spcl_cgo_cd, prev_tro_seq) {
        var strText = comboObj.Text; 
        if (strText != "") {
	        var arrComboSeq = strText.split("|");   
	        for (var i=0; i<arrComboSeq.length; i++) {	
		        var nNewRow = sheetObj.DataInsert(-1);  //신규행 추가
		    	sheetObj.CellValue2(nNewRow, "tro_seq")      = prev_tro_seq;
		    	sheetObj.CellValue2(nNewRow, "spcl_cgo_cd")  = spcl_cgo_cd;
		    	sheetObj.CellValue2(nNewRow, "spcl_cgo_seq") = arrComboSeq[i]; 
	        }
        }
    }

    //######################[5. Etc]##############################################################
    // addRow prev MaxSeq get 
    function getPrevMaxTroSeq(sheetObj, nRow, colId)
	{
	    var prevMaxTroSeq = 0;
		if (nRow > 1) {
			prevMaxTroSeq = sheetObj.CellValue(nRow-1, colId); 
		}
		return prevMaxTroSeq;
	}

	/**  
	 * 현재 tro_seq에 해당하는 master-row의 특정 column Value return 
	 */ 
	function getMstValue_currSeq(sheetObj, colId) {    	
	   	var formObj = document.form;
	   	var strSheetId_gubun = sheetObj.id.substr(sheetObj.id.length-2, 2);    	
		var strCurrTroSeq    = "";
		var sheetObj_mst     = null; 

		if (strSheetId_gubun == "_b") {
			sheetObj_mst  = x_sheetObject7;
			strCurrTroSeq = formObj.t2_tro_seq.Text;	
		} else {
			sheetObj_mst  = x_sheetObject2;
			strCurrTroSeq = formObj.tro_seq.Text;
		} 
		var nSRow_mst        = sheetObj_mst.FindText("tro_seq", strCurrTroSeq);
		var strReturnVal_mst = sheetObj_mst.CellValue(nSRow_mst, colId);    	
		
		return strReturnVal_mst;
	}
    
    /**
    * Tro-Master : 지정된 tro_seq에 대하여, Dtl의 so_no가 한건이라도 존재하는지 여부체크 
    */ 
	//function getExistYnSoNo() {
    function getExistYnSoNo(targetTroSeq) {
		var formObj = document.form;		
		var sheetObjDtl_All = x_sheetObject3; 
		//var targetTroSeq    = formObj.tro_seq.Text;
		var strReturn       = "N";

		for (var i=1; i<=sheetObjDtl_All.RowCount; i++) {
			var strTroSeq = sheetObjDtl_All.CellValue(i, "tro_seq");				
			if (strTroSeq == targetTroSeq) {
				var strSoNo = sheetObjDtl_All.CellValue(i, "trsp_so_no");
				if (strSoNo != "") {
					strReturn = "Y";
					break;
				}
			}
		}
		
		return strReturn;
	}
	 
    /**
     * 멀티콤보의 Text에서, remark 내용분리하여 textarea에 add 
     */    
    function setAddRemarkText(comboObj, idx_cd, text) {
    	if (comboObj.CheckIndex(idx_cd)) {  //멀티콤보 : checkbox 체크여부
	    	if (comboObj) {
	        	var arrComboText = text.split("|"); //textarea에 remark추가
	        	var objRemark = document.form.diff_rmk;
	        	if(objRemark.value != "") {
	        		objRemark.value += " ";
	        	}
	        	objRemark.value += arrComboText[1];
	    	}
    	}
    }

    /**
     * 존재여부 flag에 따라, 버튼 change 출력처리 
     */
    function changeDisplayBtn(btnNm, link_flag) {
 	    if ("Y" == link_flag) {
 		    document.getElementById(btnNm).style.color = "#0000ff";
	    } else { 	    	
		    document.getElementById(btnNm).style.color = "";
	    }
    }
    /**
     * Td 버튼 Link가능상태 체크용 
     */
    function checkTdUnLink(btnNm) {
    	return !(document.getElementById(btnNm).style.color == "#0000ff");
    }     
     
    /** 
    * (All)콤보 배경색 변경 
    */
    function setChangeAllComboBackColor() {
    	var formObj  = document.form;    	
    	setComboBackColor(formObj.dcgo_seq);
    	setComboBackColor(formObj.rc_seq);
    	setComboBackColor(formObj.awk_cgo_seq);
    }
    
    /** 
    * (특정)콤보 배경색 변경 
    */
    function setComboBackColor(comboObj) {
    	if ("" != comboObj.Text) {
    		comboObj.BackColor = "#ff0000"; 
    		comboObj.fontcolor = "#ffffff";
    	} else {
    		comboObj.BackColor = "#ffffff";
    		comboObj.fontcolor = "#606060";
    	} 
    }

	/**     
	 *  지정한 cell의 구간만 editable속성을 일괄 변경 
	 */
    function changeAllCellEditable(sheetObj, nRow, nSCol, nECol, bFlag) {
        for (var i=nSCol; i<=nECol; i++) {
            sheetObj.CellEditable(nRow, i) = bFlag;
        }
    }
	 
    /**
     * Td 버튼 Disabled 상태 체크용 
     */
    function checkTdDisabled(srcName) {
    	return !(document.getElementById(srcName).className.indexOf('_1') == -1);
    }

    /**
     * img 버튼 Disabled 상태 체크용 : 이전 input tag check
     */
    function checkInputDisabled(srcName) {
     	return (document.getElementById(srcName).getAttribute("readOnly") || document.getElementById(srcName).getAttribute("isDisabled"));
    }

/*  : 해당 Sheet의 ibflag('D')인 상태row : Hidden 처리 -> 실제 사용안함  
    function setSheetAllRowHidden(sheetObj) {
    	for (var i=1; i<=sheetObj.RowCount; i++) {
    		if ("D" == sheetObj.RowStatus(i)) {
    			sheetObj.RowHidden(i) = true;
    		}
    	}
    }
*/


    //######################[6. Check/Link/Popup]#################################################
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 
     */
    function validateForm(sheetObj, formObj, sAction, delFlg) {
	    if (delFlg == null) {
	    	delFlg = "N";
	    }
    
        with(formObj)
        {
        	switch (sAction) {
        	    case IBSEARCH:
					if (bkg_no.value == "" && bl_no.value == "") {
						//ComShowCodeMessage("BKG00255");
						//ComSetFocus(bkg_no);
						return false;
					}
        	    	break;
        	    	
        	    case IBSAVE:
        	   	    //0) 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크 
        	   	    //if (!ComChkValid(formObj)) return false;
        	   	    if (!ComChkObjValid(bkg_no,          true, true, false)) return false;
        	   	    if (!ComChkObjValid(bl_no,           true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_cnt_cd, true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_seq,    true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_nm,     true, true, false)) return false;
        	   	    if (!ComChkObjValid(dor_loc_cd,      true, true, false)) return false;
        	   	    if (!ComChkObjValid(zn_cd,           true, true, false)) return false;
        	   	    if (!ComChkObjValid(dor_pst_no,      true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_addr,   true, true, false)) return false;
        	   	    if (!ComChkObjValid(cntc_pson_nm,    true, true, false)) return false;
        	   	    if (!ComChkObjValid(diff_rmk,        true, true, false)) return false;
        	        if (!ComChkObjValid(cntc_phn_no,     true, true, false)) return false;
        	     	if (!ComChkObjValid(cntc_fax_no,     true, true, false)) return false;

  					if (bkg_no.value != oldBkgNo.value) {
  					    ComShowCodeMessage("BKG00448");  //조회 버튼을 클릭해야함
  					    ComSetFocus(bkg_no);
  					    return false;
  					}
        	   	    
  					//formObj.f_del_flg.value = delFlg;  //event구분 (delete:Y, save:N, currSeqSave:C) -> R:Request 기능은  troA에 없음 
  					formObj.f_del_flg.value = delFlg;  //event구분 (delete:Y, save:N, currSeqSave:C, allConfirmSave:AC) -> R:Request 기능은  troA에 없음
  					
					//1) Dtl : check
					if (!checkDtl(x_sheetObject3)) {
						return false;
					}
					//2) Master : check
					if (!checkMaster(x_sheetObject2)) {
						return false;
					}

        	        if (delFlg == "N" && !ComShowCodeConfirm("COM12147", "")) {
        	    		return false;
        	        } else if (delFlg == "C" && !ComShowCodeConfirm("COM12147", "Current Troseq")) {
        	    		return false;
        	    	}

        	        var cntrTpSzs = "";
        	        var cntrTpSz = "";
        	        var cfmFlg = "N";
        	        
        	        for (var i=1; i<=x_sheetObject2.RowCount; i++) {
        	        	if(x_sheetObject2.CellValue(i,"cfm_flg")=="Y"
        	        		&&x_sheetObject2.CellValue(i,"cfm_flg_old")=="N"){
        	        		cfmFlg = "Y"
        	        	}
        	        }
        	        if(cfmFlg == "Y"){
	        			for(var i = 1; i <=x_sheetObject3.RowCount; i++){
	        				if(x_sheetObject3.CellValue(i,"cxl_flg")!="Y"){
	        					cntrTpSzs = cntrTpSzs + "," + x_sheetObject3.CellValue(i,"cntr_tpsz_cd");
	        				}
	        			}

	        			cntrTpSzs = cntrTpSzs.split(",");
	        			for(var i = 1; i < cntrTpSzs.length; i++){
	        				if(i == 1){
	        					cntrTpSz = cntrTpSzs[i];
	        				} else {
	        					if(cntrTpSz.indexOf(cntrTpSzs[i]) == -1){
	        						cntrTpSz = cntrTpSz + "," + cntrTpSzs[i];
	        					}
	        				}
	        			}
	        			sendCntrTpSz = cntrTpSz.split(",");
	        			
	        			for(var i = 0; i < sendCntrTpSz.length; i++){
	        				var cnt = 0;
	        				 for (var j=1; j<=x_sheetObject3.RowCount; j++) {
	        					 if(x_sheetObject3.CellValue(j,"cxl_flg")!="Y" && 
	        							 (x_sheetObject3.CellValue(j,"cntr_tpsz_cd") == sendCntrTpSz[i])){
	        						 cnt = cnt + parseInt(x_sheetObject3.CellValue(j,"tro_qty"));
	        					 } 
	        				 } 
	        				 if(cnt>0){
	    						var rXml = sheetObjects[4].GetSearchXml("ESM_BKG_0079_02AGS.do", "f_cmd="+SEARCH01+"&cntr_tpsz_cd="+sendCntrTpSz[i]+"&tro_qty="+cnt+"&bkg_no="+bkg_no.value);
	    						var flg = ComGetEtcData(rXml, "cfm_block_flg");
	    						if(flg == 'Y'){
	    	  					    ComShowCodeMessage("BKG95091");  //조회 버튼을 클릭해야함
	    	  					    return false;			
	    						} 
	        				 }
	        			}
        			}
					
        	    	break; 
        	}
        }

        return true;
    }

    /**
     * Dtl Grid : 저장전, 필수입력등 일괄 체크  
     */ 
    function checkDtl(sheetObj) {
    	var formObj = document.form;
    	var sheetObj_mst  = x_sheetObject2;
    	var strCurrTroSeq = formObj.tro_seq.Text;
    	var delFlg        = formObj.f_del_flg.value;
    	var strMsgExistYn = "N";
    	
    	for (var i=1; i<=sheetObj.RowCount; i++) {
    		var t_tro_seq = sheetObj.CellValue(i, "tro_seq");
    		var t_cxl_flg = sheetObj.CellValue(i, "cxl_flg");
    		
    		//01. Request Row Find : 현재 tro_seq 값 -> 즉, request요청시, request tro_seq -> troA 대상아님. 
	   	    //02. Confirm Row Find : 
	   		var nSRow_mst       = sheetObj_mst.FindText("tro_seq", t_tro_seq);
	   		var cfm_flg_mst     = sheetObj_mst.CellValue(nSRow_mst, "cfm_flg");
	   		var cfm_flg_old_mst = sheetObj_mst.CellValue(nSRow_mst, "cfm_flg_old");
    		
    		if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) ||     			 
       	   		 (t_cxl_flg == "Y") || 
       	   	     (cfm_flg_old_mst == "Y") )  //기 confirm된 건 skip 
       		{
       			continue; 
       		}

    		//--------------------->
	   	    //03. confirm 대상건만 check 로직 수행함  
			//2) Arrival dt
			var t_dor_arr_dt      = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "dor_arr_dt")), "-", ""); 
			var t_dor_arr_dt_hhmi = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "dor_arr_dt_hhmi")), ":", "");  
			var t_arr_dt          = t_dor_arr_dt + t_dor_arr_dt_hhmi;
   			
   	  	    //madatory check 
   			if (cfm_flg_mst != cfm_flg_old_mst)
   			{
    			//1) TP/SZ
    			var t_tpsz = nullToBlank(sheetObj.CellValue(i, "cntr_tpsz_cd"));
    			if (t_tpsz == "") {
    				ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+", TP/SZ");
    				return false;
    			}
    			
    			//2) Arrival dt
    			if (t_dor_arr_dt != "" && t_dor_arr_dt_hhmi == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false; 
    			}
    			if (t_dor_arr_dt_hhmi != "" && t_dor_arr_dt == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false;  
    			}			
    			if (t_arr_dt != "") {
    				var etb_dt = formObj.etb_dt.value;
    				var toDay  = ComGetNowInfo("ymd")+ComGetNowInfo("hm");
    				toDay = ComReplaceStr(toDay, "-", ""); 
    				toDay = ComReplaceStr(toDay, ":", "");  
    				if (t_arr_dt <= toDay) {
    					//ComShowCodeMessage("COM12131", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date");
    					//return false;  //경고메세지만 출력 후, 저장 ->과거날짜 소급적용 가능
    					strMsgExistYn = "Y";
    				}
    				if (etb_dt != "" && t_arr_dt > etb_dt) {
    					ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Dat", "ETB Date("+etb_dt+")", "lesser");
    					return false;  
    				}  
    			} else {
    				ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+", Door Arrival Date");
    				return false; 
    			}
   			} else {
    			//2) Arrival dt
    			if (t_dor_arr_dt != "" && t_dor_arr_dt_hhmi == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false; 
    			}
    			if (t_dor_arr_dt_hhmi != "" && t_dor_arr_dt == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false;  
    			}
    			if (t_arr_dt != "") {
    				var etb_dt = formObj.etb_dt.value;
    				var toDay  = ComGetNowInfo("ymd")+ComGetNowInfo("hm");
    				toDay = ComReplaceStr(toDay, "-", ""); 
    				toDay = ComReplaceStr(toDay, ":", "");  
    				if (t_arr_dt <= toDay) {
    					//ComShowCodeMessage("COM12131", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Date");
    					//return false;  //경고메세지만 출력 후, 저장  ->과거날짜 소급적용 가능 
    					strMsgExistYn = "Y";
    				}
    				if (etb_dt != "" && t_arr_dt > etb_dt) {
    					ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.CellValue(i, "tro_seq")+", SubSeq:"+sheetObj.CellValue(i, "tro_sub_seq")+"] Door Arrival Dat", "ETB Date("+etb_dt+")", "lesser");
    					return false;  
    				}  
}
    		}
	   		//<-------------------
    	}
	   	if (strMsgExistYn == "Y") {
	   		ComShowCodeMessage("COM12131", "Door Arrival Date");
	   	} 
    	
    	return true;
    }
    
    /**
    * Master Grid : 저장전, 필수입력등 일괄 체크  
    */    
    function checkMaster(sheetObj) {
   	    var formObj = document.form;
   	    var strCurrTroSeq = formObj.tro_seq.Text;
   	    var delFlg        = formObj.f_del_flg.value;
   	    
        var t_Por = formObj.por_cd.value.substr(0,2);
        for (var i=1; i<=sheetObj.RowCount; i++) {
        	var t_tro_seq     = sheetObj.CellValue(i, "tro_seq");
        	var t_cxl_flg     = sheetObj.CellValue(i, "cxl_flg");
            var strCfmFlg     = sheetObj.CellValue(i, "cfm_flg");
    		var strCfmFlg_old = sheetObj.CellValue(i, "cfm_flg_old");

    		//01. cancel이 아니면서, saveSeq/request/confirm 대상건만 check 로직 수행함  
 	   	    if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
 	   		     (t_cxl_flg == "Y") || 
 	   		     (strCfmFlg == strCfmFlg_old) ) 
 	   	    {
 		        continue; 
 		    }
    		
    		//------------------------->
    		//02. request/confirm 대상건만 check 로직 수행함  
        	//Actual Customer Nm : act_shpr_nm
        	var t_act_shpr_nm = nullToBlank(sheetObj.CellValue(i, "act_shpr_nm"));
        	if (t_act_shpr_nm == "") {
        		ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.CellValue(i, "tro_seq")+", Actual Customer Name");
                return false;
        	}
        	
        	//Location 
        	var t_dor_loc_cd = nullToBlank(sheetObj.CellValue(i, "dor_loc_cd"));
        	if (t_dor_loc_cd == "") {
        		ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.CellValue(i, "tro_seq")+", Location");
                return false;
        	}
        	var t_zn_cd = nullToBlank(sheetObj.CellValue(i, "zn_cd"));
        	if (t_zn_cd == "") {            	
        		ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.CellValue(i, "tro_seq")+", Location Zone Code");
                return false;
        	}
        	
        	//Zip
            var t_zip = nullToBlank(sheetObj.CellValue(i, "dor_pst_no"));
            if ("US" == t_Por && t_zip == "") {
                ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.CellValue(i, "tro_seq")+", Zip");
                return false;
            }
            //<------------------------
        }
   	
        return true;
    }
			 
    /**
     * Actual Customer 팝업창 선택값 setting 
     */     
    function setActCustCallBack(aryPopupData) {
        var formObj = document.form;        
    	//var p_loc_cd              = nullToBlank(aryPopupData[0][1]); 
    	//var p_zn_cd               = nullToBlank(aryPopupData[0][2]);  
    	var p_act_shpr_nm	      = nullToBlank(aryPopupData[0][3]); 
    	var p_cnt_cd              = nullToBlank(aryPopupData[0][4]); 
    	//var p_vndr_seq            = nullToBlank(aryPopupData[0][5]); 
    	//var p_vndr_lgl_eng_nm	    = nullToBlank(aryPopupData[0][6]); 
    	var p_cntc_pson_nm        = nullToBlank(aryPopupData[0][7]); 
    	var p_cntc_phn_no         = nullToBlank(aryPopupData[0][8]); 
    	var p_cntc_mphn_no        = nullToBlank(aryPopupData[0][9]); 
    	var p_act_shpr_addr       = nullToBlank(aryPopupData[0][10]); 
    	var p_dor_zip_id          = nullToBlank(aryPopupData[0][11]); 
    	var p_cntc_fax_no         = nullToBlank(aryPopupData[0][12]); 
    	var p_cntc_eml            = nullToBlank(aryPopupData[0][13]); 
    	var p_tro_act_cust_knd_cd = nullToBlank(aryPopupData[0][14]);   //E, C
    	//var tro_vndr_seq        = nullToBlank(aryPopupData[0][15]); 
    	//var cnt_cd              = nullToBlank(aryPopupData[0][16]); 
    	var p_cust_seq            = nullToBlank(aryPopupData[0][17]); 
    	//var ofc_cd              = nullToBlank(aryPopupData[0][18]); 
    	//var tro_act_rep_seq     = nullToBlank(aryPopupData[0][19]); 

    	
        with(formObj) {
/*         	
	        if (act_shpr_cnt_cd.value == "") { act_shpr_cnt_cd.value = p_cnt_cd; }
	        if (act_shpr_seq.value    == "") { act_shpr_seq.value    = p_cust_seq; }
	        if (act_shpr_nm.value     == "") { act_shpr_nm.value     = p_act_shpr_nm; }	        
	        //if (dor_loc_cd.value      == "") { dor_loc_cd.value      = p_loc_cd; }
	        //if (zn_cd.value           == "") { zn_cd.value           = p_zn_cd; }
	        if (dor_pst_no.value      == "") { dor_pst_no.value      = p_dor_zip_id; }
	        if (act_shpr_addr.value   == "") { act_shpr_addr.value   = p_act_shpr_addr; }
	        if (cntc_pson_nm.value    == "") { cntc_pson_nm.value    = p_cntc_pson_nm; }
	        if (cntc_phn_no.value     == "") { cntc_phn_no.value     = p_cntc_phn_no; }
	        if (cntc_mphn_no.value    == "") { cntc_mphn_no.value    = p_cntc_mphn_no; }
	        if (cntc_fax_no.value     == "") { cntc_fax_no.value     = p_cntc_fax_no; }
*/ 
			act_shpr_cnt_cd.value = p_cnt_cd;
			act_shpr_seq.value    = p_cust_seq;
			act_shpr_nm.value     = p_act_shpr_nm;
            //dor_loc_cd.value      = p_loc_cd; 
            //zn_cd.value           = p_zn_cd; 
			dor_pst_no.value      = p_dor_zip_id;
			act_shpr_addr.value   = p_act_shpr_addr;
			cntc_pson_nm.value    = p_cntc_pson_nm;
			cntc_phn_no.value     = p_cntc_phn_no;
			cntc_mphn_no.value    = p_cntc_mphn_no;
			cntc_fax_no.value     = p_cntc_fax_no;
        }
    }
     
    /**
    * Location 공통팝업창 선택값 setting 
    */
    function getCOM_ENS_061_1(aryPopupData, row, col, sheetIdx) { 
    	var nod_cd = aryPopupData[0][3];
    	if (nod_cd.length == 7) {
    	    document.form.dor_loc_cd.value = nod_cd.substr(0,5); 
    	    document.form.zn_cd.value      = nod_cd.substr(5,7);
    	}
    }
    
    
    //#############################(7. Util/Etc)##################################################    
    function ComEnableObject_loc(obj, bEnable)
    {
        try {
        	//disabled나 readOnly 설정하기
            switch( obj.type ) {
                case "password" :
                case "text" :
                	obj.readOnly = !bEnable;
                    break;
                case "textarea":
                	obj.readOnly = !bEnable;
                    break;
                default:
                    obj.disabled = !bEnable;
            }

			//설정에 따라 css 처리하기
            switch( obj.type ) {
                case "select-one" :
                case "text" :
                    if (bEnable){
                        if (obj.className=="input2_2"){	      //회색바탕 - 필수입력
                        	obj.className = "input1";	      //흰색바탕 - 필수입력 
                        } else if (obj.className=="input2"){  //흰색 입력바탕
                        	obj.className = "input";          //흰색바탕
                        }
                    } else {
                        if (obj.className=="input1"){         //필수 입력바탕
                        	obj.className = "input2_2";       //회색바탕
                        } else if (obj.className=="input"){   //흰색 입력바탕
                        	obj.className = "input2";         //회색바탕
                        }
                    }
                    break;

                case "textarea":
                    if (bEnable){
                    	obj.className = "textarea";
                    } else {
                    	obj.className = "textarea2";
                    }
                    break;

				default :
                    if (obj.tagName=="IMG" || obj.tagName=="img") {
                        if (bEnable){
                            obj.style.cursor = "hand";
                            obj.style.filter="";
                        } else {
                            obj.style.cursor = "default";
                            obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                        }
                    }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function ComEnableManyObjects_loc(bEnable, objs) {
        try {
            var args = arguments;

            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
	/**
	 * IBMultiCombo 일괄 Enable/Disable 처리  
	 */
    function ComEnableManyIBCombo(bEnable, objs) {
        try {
            var args = arguments;

            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) {
                	args[i].Enable = bEnable;
                }
            } 
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
	/**
	 * IBMultiCombo 일괄 Enable/Disable 처리  
	 */
    function ComEnableManyTd(bEnable, objs) {
	    try {
	        var args = arguments;
	
	        if (args.length < 2) return;
	        for(var i=1; i<args.length; i++) {
	 	    	if (bEnable == true) {
		    		ComBtnEnable(args[i]);
		    	} else {
		    		ComBtnDisable(args[i]);
		    	} 
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
    }	 
	 
    function callShowMessageAddSeq() {
    	ComShowCodeMessage("COM12130", "click event", "AddSeq button");
    }
    function callShowMessageReProc(strMsgTitle, strMsg2) {
    	if (strMsg2 == null) { strMsg2 = "rehandling"; }
    	ComShowCodeMessage("COM12242", "Already ["+strMsgTitle+"] process status. "+strMsg2);
    }    
    function callShowMessageBiggerQty(strMsgTitle) {
        ComShowCodeMessage("COM12133", "["+strMsgTitle+"] Total Qty", "or equal to the BKG Qty", "lesser"); 
    }     
	 /**
	 * check_Enter  
	 * 조회조건 에터키 이력시 조회
	 * @param 
	 * @return 
	 */
	function check_Enter() {
		var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
		if (event.keyCode == 13) {
			if(event.srcElement.name == "bkg_no" || event.srcElement.name == "bl_no"){
				formObj.elements[srcName].value = srcValue.toUpperCase();
				doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
			}
		}
	}
	 /**
	 * searchData : 탭이동시 검색수행
	 * bkgNo : 
	 * 0079에서 실행
	 */
	 function searchData(bkgNo){
	 	var formObj  = document.form;
	 	ComSetObjValue(formObj.bkg_no ,bkgNo);
	 	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
	 }
	 /**
	  * HTML Control의 onblur이벤트 <br>
	  **/
	 function obj_deactivate() {
		if(event.srcElement.name != "bkg_no" && event.srcElement.name != "bl_no"){
			 if(eval('document.form.'+event.srcElement.name).value.length > 0){
				 ComSetObjValue(document.form.modify_flag, "Y");	 
			 }
		} else {
	    	var formObj = document.form;
	    	var srcName = window.event.srcElement.getAttribute("name");
	    	var srcValue = window.event.srcElement.getAttribute("value");
			formObj.elements[srcName].value = srcValue.toUpperCase();
		}
	  }
	 /**
	 * checkModify: 탭이동시 저장여부
	 * param : 
	 * 0079에서 실행
	 */
	 function checkModify(){	
		var formObj  = document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			tab_alert_msg = false;
			if (!ComShowConfirm(ComGetMsg("BKG00350")))
				return false; // Are you sure to save the changes?
			doActionIBSheet(x_sheetObject2, formObj, IBSAVE);
		}
	 }
	/**
	* setInquiryDisableButton 이벤트 호출 .<br>
	* ComBtnDisable 을 했을경우 비활성화
	* @param 
	*/
	function setInquiryDisableButton(){
		ComBtnDisable("btn_t2aSave");
		ComBtnDisable("btn_t2aSaveSeq");
		ComBtnDisable("btn_t2aCancelAll");
		ComBtnDisable("btn_t2aTROCopy");
		ComBtnDisable("btn_t2aAddSeq");
		ComBtnDisable("btn_t2aCopySeq");
		ComBtnDisable("btn_t2aCancelSeq");
		
		ComBtnDisable("btn_t2aAdd");
		ComBtnDisable("btn_t2aDelete");
		ComBtnDisable("btn_t2aCopy");
	}
	
	
	 //2011.12.13 spcial cargo가 남아 있는지 체크 하는 함수 kbj
    function isRemainSpCgo(){
    	var flag = false;
    	var objForm = document.form; 

    	for(var i = 0; i < objForm.dcgo_seq.GetCount;i++){
			var chkRow = new Array();
			var chkTro = new Array();
			var isCancel = null;
			//dcgo_seq로 tro_seq 가져오기
			for(var j = 1; j <= x_sheetObject4.RowCount; j++){
				if(objForm.dcgo_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"spcl_cgo_seq") && x_sheetObject4.CellValue(j,"spcl_cgo_cd") == 'DG'){
					chkTro.push(x_sheetObject4.CellValue(j,"tro_seq"));
				}
			}
			//가져온 tro_seq를 가진 idx 가져오기
			for(var k=0; k < chkTro.length; k++){
				for(var j=1;j<=x_sheetObject2.RowCount;j++){
					if(chkTro[k]==x_sheetObject2.CellValue(j,"tro_seq")){
						chkRow.push(x_sheetObject2.FindText("tro_seq", chkTro[k], j ));
					}
				}
			}

			//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
			for(var j=0; j< chkRow.length ;j++){ 
				if(x_sheetObject2.CellValue(chkRow[j],"cxl_flg") == "Y"){
					isCancel = true; 
				}else{
					isCancel = false; 
					break;
				}
			}  
			for(var j = 1; j <= x_sheetObject4.RowCount; j++){
				if(objForm.dcgo_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"spcl_cgo_seq") && x_sheetObject4.CellValue(j,"spcl_cgo_cd") == 'DG'){
					if( x_sheetObject4.FindText("spcl_cgo_seq",objForm.dcgo_seq.GetIndexText(i,0),j) == -1 ){
						flag = true;
						break;
					}
				}
			}
			
			if( flag || isCancel ){
				flag = true;
				break;
			}else if(chkTro.length < 1 ){
				flag = true;
				break;
			}
    	}
    	
    	if(flag) return flag;
    	
    	for(var i = 0; i < objForm.rc_seq.GetCount;i++){
			var chkRow = new Array();
			var chkTro = new Array();
			var isCancel = null;
			//rc_seq로 tro_seq 가져오기
			for(var j = 1; j <= x_sheetObject4.RowCount; j++){
				if(objForm.rc_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"spcl_cgo_seq") && x_sheetObject4.CellValue(j,"spcl_cgo_cd") == 'RF'){
					chkTro.push(x_sheetObject4.CellValue(j,"tro_seq"));
				}
			}
			
			//가져온 tro_seq를 가진 idx 가져오기
			for(var k=0; k < chkTro.length; k++){
				for(var j=1;j<=x_sheetObject2.RowCount;j++){
					if(chkTro[k]==x_sheetObject2.CellValue(j,"tro_seq")){
						chkRow.push(x_sheetObject2.FindText("tro_seq", chkTro[k], j ));
					}
				}
			}

			//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
			for(var j=0; j< chkRow.length ;j++){ 
				if(x_sheetObject2.CellValue(chkRow[j],"cxl_flg") == "Y"){
					isCancel = true; 
				}else{
					isCancel = false; 
					break;
				}
			}   
			for(var j = 1; j <= x_sheetObject4.RowCount; j++){ 
				if(objForm.rc_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"spcl_cgo_seq") && x_sheetObject4.CellValue(j,"spcl_cgo_cd") == 'RF'){
					if( x_sheetObject4.FindText("spcl_cgo_seq",objForm.rc_seq.GetIndexText(i,0),j) == -1 ){
						flag = true;
						break;
					}
				}
			}
			
			if( flag || isCancel ){
				flag = true;
				break;
			}else if(chkTro.length < 1){
				flag = true;
				break;
			}
    	}
    	
    	if(flag) return flag;
    	
    	for(var i = 0; i < objForm.awk_cgo_seq.GetCount;i++){
			var chkRow = new Array();
			var chkTro = new Array();
			var isCancel = null;
			//rc_seq로 tro_seq 가져오기
			for(var j = 1; j <= x_sheetObject4.RowCount; j++){
				if(objForm.awk_cgo_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"spcl_cgo_seq") && x_sheetObject4.CellValue(j,"spcl_cgo_cd") == 'AK'){
					chkTro.push(x_sheetObject4.CellValue(j,"tro_seq"));
				}
			}
			//가져온 tro_seq를 가진 idx 가져오기
			for(var k=0; k < chkTro.length; k++){
				for(var j=1;j<=x_sheetObject2.RowCount;j++){
					if(chkTro[k]==x_sheetObject2.CellValue(j,"tro_seq")){
						chkRow.push(x_sheetObject2.FindText("tro_seq", chkTro[k], j ));
					}
				}
			}

			//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
			for(var j=0; j< chkRow.length ;j++){ 
				if(x_sheetObject2.CellValue(chkRow[j],"cxl_flg") == "Y"){
					isCancel = true; 
				}else{
					isCancel = false; 
					break;
				}
			}  
			for(var j = 1; j <= x_sheetObject4.RowCount; j++){
				if(objForm.awk_cgo_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"spcl_cgo_seq") && x_sheetObject4.CellValue(j,"spcl_cgo_cd") == 'AK'){
					if( x_sheetObject4.FindText("spcl_cgo_seq",objForm.awk_cgo_seq.GetIndexText(i,0),j) == -1 ){
						flag = true;
						break;
					}
				}
			}
			
			if( flag || isCancel ){
				flag = true;
				break;
			}
    	}
    	
    	return flag;
    	
    }

	/* 개발자 작업  끝 */