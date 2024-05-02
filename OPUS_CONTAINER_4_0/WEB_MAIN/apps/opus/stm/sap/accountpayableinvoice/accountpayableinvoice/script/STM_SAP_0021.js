/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0021.js
*@FileTitle  : Account Information Popup  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @extends 
 * @class Evidence Popup : business script for STM_SAP_0021
 */
	var ipageNo=1 ;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var TAX_ACCOUNT = "";
	var OVERSAES_TAX_ACCOUNT = "";
	var WITHHOLDING_ACCOUNT = "";
	
	document.onclick=processButtonClick;
		/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
		function processButtonClick(){
			 var sheetObject=sheetObjects[0];
		     var form=document.form;
		    try {
		        var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
		        switch(srcName) {
		        	case "btn_new":
			            funcNew("FULL");
		    	        break;
		            case "btn_close":
		            	ComClosePopup(); 
		    	        break;
		    	    case "btn_ok":
		        		funcOK();
	            		break;
		    	    case "btns_co_srh":
		        		//Company
	            		var param="?lu_cd=" + form.liab_coa_co_cd.value;
	            		ComOpenPopup("STM_SAP_0420.do" + param, 400, 450, "setCompany", "0,0", false, false);
	            		break;	
		    	    case "btns_rgn_srh":
		        		//Region
		    	    	var param="?lu_cd=" + form.liab_coa_rgn_cd.value;
	            		ComOpenPopup("STM_SAP_0430.do" + param, 400, 400, "setRegion", "0,0", false, false);            		
	            		break;		
		    	    case "btns_ctr_srh":
		        		//Center
	            		var param="?f_center=" + form.liab_coa_ctr_cd.value;
	            		ComOpenPopup("STM_SAP_0440.do" + param, 500, 400, "setCenter", "0,0", false, false);
	            		break;	
		    	    case "btns_acct_srh":
		        		//Account
		    	    	var param="?acct_cd=" + form.liab_coa_acct_no.value+"&line_type="+form.reqLineType.value+"&acct_nm="+form.liab_coa_acct_nm.value;
	            		ComOpenPopup("STM_SAP_0450.do" + param, 500, 400, "setAccount", "0,0", false, false);
	            		break;	
		    	    case "btns_inter_co_srh":
		        		//Inter Company
	            		var param="?f_intercom=" + form.liab_coa_inter_co_cd.value;
	            		ComOpenPopup("STM_SAP_0460.do" + param, 500, 400, "setInterCompany", "0,0", false, false);
	            		break;	
		    	    case "btns_vvd_srh":
		        		//VVD
	            		var param="?vvd_cd=" + form.liab_coa_vvd_cd.value + "&vvd_type=" + form.reqvvdtype.value + "&acct_cd=" + form.liab_coa_acct_no.value;
	            		ComOpenPopup("STM_SAP_0470.do" + param, 500, 400, "setVVD", "0,0", false, false);
	            		break;	
		        } // end switch
		    }catch(e) {            
		        if( e == "[object Error]") {
		            ComShowMessage(OBJECT_ERROR);
		        } else {
		            ComShowMessage(e.message);
		        }
		    }
		}
	    /**
	     * IBSheet Object를 배열로 등록
	     * comSheetObject(id)에서 호출한다
	     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	     * 배열은 소스 상단에 정의
	     */
	    function setSheetObject(sheet_obj){
	        sheetObjects[sheetCnt++]=sheet_obj;
	    }
	    /**
	     * Sheet 기본 설정 및 초기화 
	     * body 태그의 onLoad 이벤트핸들러 구현
	     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	     */
	     function loadPage() {
	    	 var formObject=document.form;
	    	 for(i=0;i<sheetObjects.length;i++){
	 			ComConfigSheet (sheetObjects[i] );
	 			initSheet(sheetObjects[i],i+1);
	 			ComEndConfigSheet(sheetObjects[i]);
	 		}
	 		initControl();
	 		
	 		this.TAX_ACCOUNT = chkLookupOneData(sheetObjects[0], "&lu_tp_cd=AP TAX ACCOUNT&attr_ctnt1=INTERNAL");	
	 		this.OVERSAES_TAX_ACCOUNT = chkLookupOneData(sheetObjects[0], "&lu_tp_cd=AP TAX ACCOUNT&attr_ctnt1=EXTERNAL");
	 		this.WITHHOLDING_ACCOUNT = chkLookupOneData(sheetObjects[0], "&lu_tp_cd=AP TAX ACCOUNT&attr_ctnt1=WITHHOLDING");
	 		
	 		formObject.liab_coa_co_nm.value=getCompanyName(sheetObjects[0],formObject.liab_coa_co_cd.value );
	 		formObject.liab_coa_rgn_nm.value=getRegionName(sheetObjects[0],formObject.liab_coa_rgn_cd.value );
	 		formObject.liab_coa_ctr_nm.value=getCenterName(sheetObjects[0],formObject.liab_coa_ctr_cd.value );
	 		formObject.liab_coa_acct_nm.value=getAccountName(sheetObjects[0],formObject.liab_coa_acct_no.value );
	 		formObject.liab_coa_inter_co_nm.value=getInterCompanyName(sheetObjects[0],formObject.liab_coa_inter_co_cd.value );
	 		formObject.liab_coa_vvd_nm.value=getVVDName(sheetObjects[0],formObject.liab_coa_vvd_cd.value );
	 	}
	 	/**
	 	 * loading HTML Control event <br>
	 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 	 * @param {ibsheet} sheetObj    IBSheet Object
	 	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 	 **/
	 	function initControl() {
	 		var form=document.form;
	 		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);   //blur  beforedeactivate  
	 		axon_event.addListenerForm ('change', 'obj_onchange', form);
	 	}

	    /** 
	     * handling work javascript OnFocus event  <br>
	     */    
		function obj_activate() {
	       	//delete mask separator
	        ComClearSeparator(ComGetEvent());
	    }
	    /**
	     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	     **/
		function obj_deactivate(){
			ComChkObjValid(ComGetEvent());
		}
	    /**
	     * handling work javascript onchange event
	     **/	
		function obj_onchange(){
			var formObj=document.form;
			var sheetObj=sheetObjects[0];
			switch(ComGetEvent("name")){
				case "liab_coa_co_cd":
					if (formObj.liab_coa_co_cd.value != '' ) {
						formObj.liab_coa_co_nm.value=getCompanyName(sheetObj,ComGetEvent("value") );
					} else {
						formObj.liab_coa_co_nm.value="";
					}
					break;
				case "liab_coa_rgn_cd":
					if (formObj.liab_coa_rgn_cd.value != '' ) {
						formObj.liab_coa_rgn_nm.value=getRegionName(sheetObj,ComGetEvent("value") );
					} else {
						formObj.liab_coa_rgn_nm.value="";
					}
					break;
				case "liab_coa_ctr_cd":
					if (formObj.liab_coa_ctr_cd.value != '' ) {
						formObj.liab_coa_ctr_nm.value=getCenterName(sheetObj,ComGetEvent("value") );
					} else {
						formObj.liab_coa_ctr_nm.value="";
					}
					break;
				case "liab_coa_acct_no":
					if (formObj.liab_coa_acct_no.value != '' ) {
						formObj.liab_coa_acct_nm.value=getAccountName(sheetObj,ComGetEvent("value") );
					} else {
						formObj.liab_coa_acct_nm.value="";
					}
					break;
				case "liab_coa_inter_co_cd":
					if (formObj.liab_coa_inter_co_cd.value != '' ) {
						formObj.liab_coa_inter_co_nm.value=getInterCompanyName(sheetObj,ComGetEvent("value") );
					} else {
						formObj.liab_coa_inter_co_nm.value="";
					}
					break;
				case "liab_coa_vvd_cd":
					if (formObj.liab_coa_vvd_cd.value != '' ) {
						formObj.liab_coa_vvd_nm.value=getVVDName(sheetObj,ComGetEvent("value") );
					} else {
						formObj.liab_coa_vvd_nm.value="";
					}
					break;	
			}
		}		
	 	/**
	 	 * registering IBCombo Object as list
	 	 * @param combo_obj
	 	 * @return
	 	 */
	 	function setComboObject(combo_obj){
	 		comboObjects[comboCnt++]=combo_obj;
	 	} 
	    /**
	     * 시트 초기설정값, 헤더 정의
	     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	     */
	    function initSheet(sheetObj,sheetNo) {
	        var cnt=0;
	        switch(sheetNo) {
	            case 1:      //IBSheet1 init
	                with(sheetObj){
			              var HeadTitle="|liab_coa_co_cd|liab_coa_rgn_cd|liab_coa_ctr_cd|liab_coa_acct_no|liab_coa_inter_co_cd|liab_coa_vvd_cd";
			              var headCount=ComCountHeadTitle(HeadTitle);
			              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
			              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_coa_co_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_coa_rgn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_coa_ctr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_coa_acct_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_coa_inter_co_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_coa_vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			              InitColumns(cols);
			              SetEditable(0);
			              //SetSheetHeight(220);
			              resizeSheet();
	                    }
	                break;
	        }
	    }
	    /* Sheet관련 프로세스 처리 */
	    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
	        sheetObj.ShowDebugMsg(false);
	        switch(sAction) {
	           case COMMAND01:
	           break;
	        }
	    }
	   /**
	     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	     */
	    function validateForm(){
	    	var formObj=document.form;
	    	if (!ComChkValid(formObj, true, false, false)) return false;
			if ("NO_DATA" == formObj.liab_coa_co_nm.value ) {
				ComShowCodeMessage("COM132201", "Company" );  
				formObj.liab_coa_co_cd.value="";
	//			formObj.liab_coa_co_cd.focus();
				return false;
			} 
			if ("NO_DATA" == formObj.liab_coa_rgn_nm.value ) {
				ComShowCodeMessage("COM132201", "Region" );  
				formObj.liab_coa_rgn_cd.value="";
	//			formObj.liab_coa_rgn_cd.focus();
				return false;
			} 
			if ("NO_DATA" == formObj.liab_coa_ctr_nm.value ) {
				ComShowCodeMessage("COM132201", "Center" );  
				formObj.liab_coa_ctr_cd.value="";
	//			formObj.liab_coa_ctr_cd.focus();
				return false;
			} 
			if ("NO_DATA" == formObj.liab_coa_acct_nm.value ) {
				ComShowCodeMessage("COM132201", "Account" );  
				formObj.liab_coa_acct_no.value="";
	//			formObj.liab_coa_acct_no.focus();
				return false;
			} 
			if ("NO_DATA" == formObj.liab_coa_inter_co_nm.value ) {
				ComShowCodeMessage("COM132201", "Inter Company" );  
				formObj.liab_coa_inter_co_cd.value="";
	//			formObj.liab_coa_inter_co_cd.focus();
				return false;
			} 
			if ("NO_DATA" == formObj.liab_coa_vvd_nm.value ) {
				ComShowCodeMessage("COM132201", "VVD" );  
				formObj.liab_coa_vvd_cd.value="";
	//			formObj.liab_coa_vvd_cd.focus();
				return false;
			} 
	    	return true;
	    }	
	    function funcNew(flag) {
	    	var sheetObject=sheetObjects[0];
		    var formObj=document.form;
	    	if (flag == "FULL") {
	    		sheetObject.RemoveAll();
	    		formObj.reset();
	    		formObj.liab_coa_co_cd.value=""; 
	        	formObj.liab_coa_rgn_cd.value=""; 
	        	formObj.liab_coa_ctr_cd.value=""; 
	        	formObj.liab_coa_acct_no.value=""; 
	        	formObj.liab_coa_inter_co_cd.value=""; 
	        	formObj.liab_coa_vvd_cd.value=""; 
	    	} else if (flag == "OK") {
	    		sheetObject.RemoveAll();
	    		sheetObject.DataInsert(-1);
	    	}
	    }
	    function funcOK() {
	    	var sheetObj=sheetObjects[0];
		    var formObj=document.form;
	    	funcNew("OK");
	    	if ( !validateForm() ) {
	    		return false;
	    	}
	    	sheetObj.SetCellValue(1, "liab_coa_co_cd",ComTrim(formObj.liab_coa_co_cd.value),0);
	    	sheetObj.SetCellValue(1, "liab_coa_rgn_cd",ComTrim(formObj.liab_coa_rgn_cd.value),0);
	    	sheetObj.SetCellValue(1, "liab_coa_ctr_cd",ComTrim(formObj.liab_coa_ctr_cd.value),0);
	    	sheetObj.SetCellValue(1, "liab_coa_acct_no",ComTrim(formObj.liab_coa_acct_no.value),0);
	    	sheetObj.SetCellValue(1, "liab_coa_inter_co_cd",ComTrim(formObj.liab_coa_inter_co_cd.value),0);
	    	sheetObj.SetCellValue(1, "liab_coa_vvd_cd",ComTrim(formObj.liab_coa_vvd_cd.value),0);
	    	comPopupOK();
	    }
	    //Clear Name obj
	    function resetName(objName) {
	    	var obj=eval("document.form." + objName);
	    	obj.value="";
	    }    
	    //Company Popup
	    function setCompany(aryData) {
	    	var formObj=document.form;
	    	formObj.liab_coa_co_cd.value=aryData[0][1];
	    	formObj.liab_coa_co_nm.value=aryData[0][2];    	
	    }
	    //Region Popup
	    function setRegion(aryData) {
	    	var formObj=document.form;
	    	formObj.liab_coa_rgn_cd.value=aryData[0][1];
	    	formObj.liab_coa_rgn_nm.value=aryData[0][2];    	
	    }
	    //Center Popup
	    function setCenter(aryData) {
	    	var formObj=document.form;
	    	formObj.liab_coa_ctr_cd.value=aryData[0][1];
	    	formObj.liab_coa_ctr_nm.value=aryData[0][2];    	
	    }
	    //Account Popup
	    function setAccount(aryData) {
	    	var formObj=document.form;
	    	formObj.liab_coa_acct_no.value=aryData[0][1];
	    	formObj.liab_coa_acct_nm.value=aryData[0][2];  
	    	getAccountName(sheetObjects[0], formObj.liab_coa_acct_no.value);
	    }
	    //Inter Company Popup
	    function setInterCompany(aryData) {
	    	var formObj=document.form;
	    	formObj.liab_coa_inter_co_cd.value=aryData[0][1];
	    	formObj.liab_coa_inter_co_nm.value=aryData[0][2];    	
	    }
	    //VVD Popup
	    function setVVD(aryData) {
	    	var formObj=document.form;
	    	formObj.liab_coa_vvd_cd.value=aryData[0][1];
	    	formObj.liab_coa_vvd_nm.value=aryData[0][2];    	
	    } 
	    //Company Name
	    function getCompanyName(sheetObj, argVal) {
	    	if( ComTrim(argVal) == "") return "";
	    	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL COMPANY&lu_cd=" + argVal );
			if (SAPDecideErrXml(sheetObj, sXml)) {
				return "";
	        } else {
	       		return ComGetEtcData(sXml, "one_lu_desc");
	        }
	    }
	    //Region Name
	    function getRegionName(sheetObj, argVal) {
	    	if( ComTrim(argVal) == "") return "";
	    	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL REGION&lu_cd=" + argVal );
			if (SAPDecideErrXml(sheetObj, sXml)) {
				return "";
	        } else {
	        	if ( ComGetEtcData(sXml, "one_lu_desc") == "NO_DATA" ) {
	        		return "NO_DATA";
	        	} else {
	        		return ComGetEtcData(sXml, "one_lu_desc");
	        	}        	
	        } 	
	    }
	    //Center Name
	    function getCenterName(sheetObj, argVal) {
	    	if( ComTrim(argVal) == "") return "";
	    	var sXml=sheetObj.GetSearchData("STM_SAP_0440GS.do", "f_cmd=" + SEARCH + "&f_center=" + argVal);
			if (SAPDecideErrXml(sheetObj, sXml)) {
				return "";
	        } else {
	       		return ComGetEtcData(sXml, "ctr_desc");
	        }  	
	    }
	    //Account Name
	    function getAccountName(sheetObj, argVal) {
	    	if( ComTrim(argVal) == "") return "";
	    	return checkAccountAndGetName(sheetObj);
	    }
	    //Inter Company Name
	    function getInterCompanyName(sheetObj, argVal) {
	    	if( ComTrim(argVal) == "") return "";
	    	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL INTER COMPANY&lu_cd=" + argVal );
			if (SAPDecideErrXml(sheetObj, sXml)) {
				return "";
	        } else {
	       		return ComGetEtcData(sXml, "one_lu_desc");
	        } 
	    }
	    //VVD Name
	    function getVVDName(sheetObj, argVal) {
	    	if( ComTrim(argVal) == "") return "";
	    	if( ComTrim(argVal).length != 10 ) return "NO_DATA";
	    	var formObj=document.form;
	    	var coa_acct_cd=formObj.liab_coa_acct_no.value;
	    	var sXml=sheetObj.GetSearchData("STM_SAP_0470GS.do", "f_cmd=" + SEARCH + "&vvd_cd=" + argVal + "&vvd_type=" + formObj.reqvvdtype.value + "&acct_cd=" + coa_acct_cd);
			if (SAPDecideErrXml(sheetObj, sXml)) {
				return "";
	        } else {
	        	return ComGetEtcData(sXml, "vvd_desc");        	        	
	        }	
	    } 
	    function checkAccountAndGetName(sheetObj) {
	    	var formObj=document.form;
	    	var argVal=formObj.liab_coa_acct_no.value;
	    	var sXml=sheetObj.GetSearchData("STM_SAP_0010GS.do", "f_cmd=" + COMMAND05 + "&value0=" + argVal);
	    	if (SAPDecideErrXml(sheetObj, sXml)) {
				return "";
	        }  
	    	var lineType=formObj.reqLineType.value;
	    	if ("OTHER" == lineType) {
	    		return ComGetEtcData(sXml, "acct_eng_nm");
	    	}
	    	var pndTgtFlg=ComGetEtcData(sXml, "pnd_tgt_flg");
	    	var actType=(formObj.reqAccType.value).substring(0,1);
	    	var thisAcctNum=(formObj.liab_coa_acct_no.value).substring(0,1);
	    	var thisAcctNumFull = formObj.liab_coa_acct_no.value;
	    	
	    	//미결계정 Check
	    	if ( "MAIN" != lineType && "PREPAY_ITEM" != lineType ) {
	    		if (pndTgtFlg == "Y") {
	    			ComShowCodeMessage("SAP00022"); 
	    			formObj.liab_coa_acct_no.value="";
	    			formObj.liab_coa_acct_nm.value="";
	//    			formObj.liab_coa_acct_no.focus();
	    			return "";
	    		} 
	    	}
	    	//Account init Char Check
	    	if ( "MAIN" == lineType ) {
	    		if ( "2" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Liability Account", "2"); 
					formObj.liab_coa_acct_no.value="";
					formObj.liab_coa_acct_nm.value="";
	//				formObj.liab_coa_acct_no.focus();
					return "";
				}  
	    	/*} else if( "ITEM" == lineType ) {
	    		if ( "5" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Expense Account", "5");   
					formObj.liab_coa_acct_no.value="";
					formObj.liab_coa_acct_nm.value="";
	//				formObj.liab_coa_acct_no.focus();
					return "";
				}  
	    	*/} else if( "ITEM" == lineType  || "MISCELLANEOUS" == lineType ) {
	    		if ( "5" != thisAcctNum && "8" != thisAcctNum && "9" != thisAcctNum && (OVERSAES_TAX_ACCOUNT != thisAcctNumFull) && (WITHHOLDING_ACCOUNT != thisAcctNumFull) ) {
					ComShowCodeMessage("SAP00007", "Expense Account", "5 or 8 or 9");  
					formObj.liab_coa_acct_no.value="";
					formObj.liab_coa_acct_nm.value="";
	//				formObj.liab_coa_acct_no.focus();
					return "";
				}  
	    	} else if( "TAX" == lineType ) {
	    		if ( (TAX_ACCOUNT != thisAcctNumFull) && (OVERSAES_TAX_ACCOUNT != thisAcctNumFull) ) {
					ComShowCodeMessage("SAP00006", "Tax Expense Account", TAX_ACCOUNT + ' or ' + OVERSAES_TAX_ACCOUNT);   
					formObj.liab_coa_acct_no.value="";
					formObj.liab_coa_acct_nm.value="";
	//				formObj.liab_coa_acct_no.focus();
					return "";
				} 
	    	} else if( "PREPAY_ITEM" == lineType ) {
	    		if ( "1" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Prepayment Account", "1");   
					formObj.liab_coa_acct_no.value="";
					formObj.liab_coa_acct_nm.value="";
	//				formObj.liab_coa_acct_no.focus();
					return "";
				}  
	    	}  else if( "CASH" == lineType ) {
	    		if ( "1" != thisAcctNum && "9" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Cash Account", "1 or 9");   
					formObj.liab_coa_acct_no.value = "";
					formObj.liab_coa_acct_nm.value = "";
					return "";
				}  
	    	} else if( "CHARGE" == lineType ) {
	    		if ( "5" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Charge Account", "5");   
					formObj.liab_coa_acct_no.value = "";
					formObj.liab_coa_acct_nm.value = "";
					return "";
				}  
	    	} else if( "GAIN" == lineType ) {
	    		if ( "4" != thisAcctNum && "7" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Gain Account", "4 or 7");   
					formObj.liab_coa_acct_no.value = "";
					formObj.liab_coa_acct_nm.value = "";
					return "";
				}  
	    	} else if( "LOSS" == lineType ) {
	    		if ( "5" != thisAcctNum && "6" != thisAcctNum) {
					ComShowCodeMessage("SAP00007", "Loss Account", "5 or 6");   
					formObj.liab_coa_acct_no.value = "";
					formObj.liab_coa_acct_nm.value = "";
					return "";
				}  
	    	}  
	    	var vvd_cd=formObj.liab_coa_vvd_cd.value;
	    	if (vvd_cd != '') {
	    		var sXml2=sheetObj.GetSearchData("STM_SAP_0470GS.do", "f_cmd=" + SEARCH + "&vvd_cd=" + vvd_cd + "&vvd_type=" + formObj.reqvvdtype.value + "&acct_cd=" + argVal);
				if (SAPDecideErrXml(sheetObj, sXml2)) {
					ComShowCodeMessage("COM132201", "VVD" );
					formObj.liab_coa_vvd_cd.value="";
					formObj.liab_coa_vvd_nm.value="";
		        } else {
		        	if (ComGetEtcData(sXml2, "vvd_cd") == "NO_DATA") {
		        		ComShowCodeMessage("COM132201", "VVD" );
						formObj.liab_coa_vvd_cd.value="";
						formObj.liab_coa_vvd_nm.value="";
		        	} else {
		        		formObj.liab_coa_vvd_nm.value=ComGetEtcData(sXml2, "vvd_desc");
		        	}
		        } 	
	    	}
	    	return ComGetEtcData(sXml, "acct_eng_nm");
	    }
	    
	    function resizeSheet(){
	        ComResizeSheet(sheetObjects[0]);
	    }
