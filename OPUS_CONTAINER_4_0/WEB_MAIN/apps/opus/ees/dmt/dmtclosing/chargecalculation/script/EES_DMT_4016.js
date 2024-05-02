/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_4016.js
*@FileTitle  : SZPBB DEM Calculation &amp; Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_4016 :  business script for EES_DMT_4016.
     */
//    function EES_DMT_4016() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    // Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// RD
	var rdObjects=new Array();
	var rdCnt=0;
	var queryStr="";
	//Defining Action
	var IBSAVE_CORRRMK=89;
	var IBCHK_SHEETSET=90;
	var IBCHK_SHEETOPT=91;
	var IBFAXSEND=92;
	var IBEMAILSEND=93;
	var IBARIF=94;
	var IBCANCEL=95;
	var IBCALCULATE=96;
	var IBCONFIRM=97;
	var IBSEARCH_MBILL=98;
	var IBGETTOMVMT=99;
	//Business Global Variables
	var ROWMARK="|";
	var FIELDMARK="=";
	var PAYER_CD="act_payr_cust_cd";
	var PAYER_NM="act_payr_cust_nm";
	var TRUCKER_CD="vndr_seq";
	var TRUCKER_NM="vndr_nm";
	// The initial value of Tab2 IBSeet Height
	var TAB2_SHEET_HEIGHT=82;
	// ****************************************
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
     function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
    	 var sheetObj1=sheetObjects[0];
    	 var sheetObj2=sheetObjects[1];
    	 var sheetObj3=sheetObjects[2];
    	 var sheetObj4=sheetObjects[3];
    	 var sheetObj5=sheetObjects[4];
    	 var sheetObj6=sheetObjects[5];
         var formObj=document.form;
         var formObj2=document.form2;
         try {
        	 var srcObj=window.ComGetEvent();
        	 var srcName=srcObj.getAttribute("name");
        	 // Click the button at the bottom of the grid is disabled, return
        	 if(!ComIsBtnEnable(srcName)) return;
        	 switch(srcName) {
        	 	case "btns_calendar": //Calendar button
		      		//if(srcObj.style.cursor == "hand") {
	      			var cal=new ComCalendarFromTo();
	                cal.select(formObj.fm_mvmt_dt1, formObj.to_mvmt_dt1, 'yyyy-MM-dd');
		      		//}
					break;
        	 	case "btns_cust_cd":
 					doProcessPopup('cust_cd');
					break;
	            case "btns_svc_provdr":
	            	doProcessPopup('svc_provdr');
	            	break;
        	 	case "btn_Retrieve":
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;
				case "btn_New":
					doInit();
					break;
				case "btn_Minimize":
					var schCondDiv=document.getElementById("sch_cond_div");
					if(schCondDiv.style.display == 'inline') {
						schCondDiv.style.display='none';
						sheetObj1.SetSheetHeight(330+145);
					} else {
						schCondDiv.style.display='inline';
						sheetObj1.SetSheetHeight(330);
					}
					break;
 				case "btn_GetToMVMT":
 					doActionIBSheet(sheetObj1, formObj, IBGETTOMVMT);
                    break;
                case "btn_Calculate":
                	doActionIBSheet(sheetObj1, formObj, IBCALCULATE);
                    break;
                case "btn_DownExcel":
                	if(sheetObj1.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		sheetObj1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1 });
                	}
                    break; 
                case "btn_Confirm":    
                	doActionIBSheet(sheetObj1, formObj, IBCONFIRM);
                	break;
				case "btn_MBilling":
					doManualBilling();
					break;
				//case "btn_ROInfo":
				case "btn_MVMTInq":
				case "btn_ExptInq":
				case "m_bkg_no":
 				case "m_bl_no":
 				case "m_cntr_no":
                	 doProcessPopup(srcName);
                     break;
                // =================== Tab-2 ===================
 				case "btns_payer_cd":
 					doProcessPopup('payer_cd');
					break;
	            case "btns_trucker_cd":
	            	doProcessPopup('trucker_cd');
	            	break;
 				case "btn_New2":
 					doInit2();
					break;
 				case "btn_Minimize2":
 					doActionMinimize();
					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObj4, formObj2, IBSAVE);
					break;
 				case "btn_ARIF":
 					doActionIBSheet(sheetObj6, formObj2, IBARIF);
					break;	
 				case "btn_CRemark":
 					AlertCRemark();
					break;
 				case "btn_InvPrint":
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					//Preview, Print PayerCode If there is no alert message processing when
					if (ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT02002");
						return;
					}
					initRdConfig(rdObjects[0]);
					rdOpen(rdObjects[0], formObj2, sheetObj6);
					break;
 				case "btn_EmailSend":
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					doActionIBSheet(sheetObj6, formObj2, IBEMAILSEND);
 					doProcessPopup(srcName);
 					break;
 				case "btn_FaxSend":
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					doActionIBSheet(sheetObj6, formObj2, IBFAXSEND);
 					doProcessPopup(srcName);
 					break;
 				case "btn_Preview":
 					//If there is no alert message processing Sheet Set
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
					//Preview, Print PayerCode If there is no alert message processing when
					if (ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT02002");
						return;
					}
 				case "btn_SheetSet":
 				case "btn_SheetOpt":
 				case "btn_SendingHistory":
 				case "btn_Cancel":
 				case "btn_PayerInfo":
 					doProcessPopup(srcName);
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
    //comboObjects array generated in the registration page to IB Combo Object
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	} 
 	/**
      * IBTab Object is defined as an array.
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
	/**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
	function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
    	}
    	// IBMultiCombo initializing 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
    	for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
        }
 		//initializing html control event
		initControl();
		var formObj=document.form2;
  		var sheetObj=sheetObjects[0];
  		doInit();
	}
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
   //no support[check again]CLT 	function t1sheet1_OnLoadFinish() {
  		
  		//sheetObj.WaitImageVisible = false;
 		
  	    //sheetObj.WaitImageVisible = true; 
   	//}  
	// Tab-1 Screen initializing
  	function doInit() {
		var formObj=document.form;
		ComResetAll();
		sheetObjects[0].CheckAll("chk",0);
		//Period Date initializing
//		var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
//		var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -15);
//		var toMvmtDt = ofcCurrDate;
//		ComSetObjValue(formObj.fm_mvmt_dt1, fmMvmtDt);
//		ComSetObjValue(formObj.to_mvmt_dt1, toMvmtDt);
		//Searching conditions Partly to enable / disable processing
		doEnableCondObj("vvd_cd");
		initBtns();
		//tabObjects[0].TabEnable(1)=false;
		tabObjects[0].SetTabDisable(1, true);
	}
    	
  	
	// Tab-2 Screen initializing
  	function doInit2() {
		var formObj=document.form2;
		doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_MBILL);
  	}
  	/**
     * Minimize button click,  function that defines the behavior of running
     */	    
	function doActionMinimize() {
     	var chgSheetObj=sheetObjects[3];
     	var rtSheetObj=sheetObjects[4];
     	var addHeight=129;
 		if (conditionLayer.style.display == 'inline') {
 			conditionLayer.style.display='none';
 		}
 		else {
 			conditionLayer.style.display='inline';
 			addHeight=0;
 		}
 		chgSheetObj.SetSheetHeight(TAB2_SHEET_HEIGHT + addHeight);
 		rtSheetObj.SetSheetHeight(TAB2_SHEET_HEIGHT + addHeight);
	}
	// Tab-1 button status initializing
 	function initBtns() {
 		DmtComEnableManyBtns(false,	"btn_GetToMVMT", "btn_Calculate", "btn_Confirm", "btn_MVMTInq",
 									"btn_MBilling", "btn_ExptInq", "btn_DownExcel");
	  //	document.getElementById("btn_ROInfo").style.color = '';
 	}
	// Tab-2 button initializing
  	function initBtns2() {
		/*
  		DmtComEnableManyBtns(true, "btn_SheetSet", "btn_SheetOpt", "btn_Save");
		DmtComEnableManyBtns(false, "btn_SendingHistory", "btn_CRemark", "btn_Cancel", "btn_Preview", "btn_InvPrint"
									, "btn_FaxSend", "btn_EmailSend", "btn_PayerInfo", "btn_ARIF");
		*/
		var formObj=document.form2;
		var invStsCd=ComGetObjValue(formObj.dmdt_inv_sts_cd);
		//C. REMARK
		if(invStsCd == "X") {
			ComBtnEnable("btn_CRemark");
			document.getElementById("btn_CRemark").style.color="red";
		} else {
			ComBtnDisable("btn_CRemark");
			document.getElementById("btn_CRemark").style.color="";
		}
		//ARIF button Enable
		var arIfCd=ComGetObjValue(formObj.dmdt_ar_if_cd);
		if(invStsCd == "I" || invStsCd == "C") {
			if(arIfCd == "N" || arIfCd == "H")
				ComBtnEnable("btn_ARIF");
			else
				ComBtnDisable("btn_ARIF");
		} else {
			ComBtnDisable("btn_ARIF");
		}
		//SAVE button Enable
		if(invStsCd == "C" || invStsCd == "X") {
			ComBtnDisable("btn_Save");
		}else{
			ComBtnEnable("btn_Save");
		}
		//CANCEL 
		if(invStsCd == "I") {
			ComBtnEnable("btn_Cancel");
		}else{
			ComBtnDisable("btn_Cancel");
		}
		//Common button
		DmtComEnableManyBtns(true, "btn_SheetSet", "btn_SheetOpt", "btn_PayerInfo");
		if(ComGetObjValue(formObj.invoice_issue) == "1") {
			DmtComEnableManyBtns(false, "btn_SendingHistory", "btn_Preview", "btn_InvPrint", "btn_FaxSend"
										, "btn_EmailSend");
		} else { //if(ComGetObjValue(formObj.invoice_issue) == "2") {
			DmtComEnableManyBtns(true, "btn_SendingHistory", "btn_Preview", "btn_InvPrint", "btn_FaxSend"
										, "btn_EmailSend");
		}
  	}
  	/**
     *Attention Combo set up to look up information for the Payer Code
     */
    function setPayerCd() {
    	var formObj=document.form2;
    	var payer_cd=ComGetObjValue(formObj.payer_cd);
    	var cust_cnt_cd="";
    	var cust_seq="";
    	//Service Provider
    	if(payer_cd.length == 6) {
    		cust_cnt_cd="00";
    		cust_seq=payer_cd;
    	}else if(payer_cd.length == 8){
    		cust_cnt_cd=payer_cd.substring(0,2);
    		cust_seq=payer_cd.substring(2);
    	}else{
    		ComSetObjValue(formObj.payer_cd, "");
    		ComSetObjValue(formObj.cust_cnt_cd, "");
    		ComSetObjValue(formObj.cust_seq, "");
    		return;
    	}
    	ComSetObjValue(formObj.cust_cnt_cd, cust_cnt_cd);
    	ComSetObjValue(formObj.cust_seq, cust_seq);
    }
    /**
     * Attention data retrieval
     */	
	function searchAttentionList() {
    	setPayerCd();
    	var comboObj=comboObjects[2]; // Attention IBCombo
    	var formObj=document.form2;
 		if(ComGetObjValue(formObj.invoice_issue) == "1") {
 			//Before Invoice Issue
 			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
 		} else {
 			//After Invoice Issue
 			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
 		}
 		// Get data by asking
 		doActionIBCombo(sheetObjects[3], formObj, comboObj, SEARCHLIST03);
 		var comboObj=comboObjects[2];
 		var comboObjCd=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
		if(ComGetObjValue(formObj.payer_cd) == "") {
			comboObj.SetSelectCode("");
//			comboObj.Index = -1;
		} else {
			//Attention Setting
			comboObj.SetSelectCode(comboObjCd);
			if(comboObj.GetSelectCode()== ""){
				comboObj.SetSelectIndex(0);
			}
		}
 	}
  	function doManualBilling() {
  		var formObj=document.form2;
  		var sheetObj=sheetObjects[0];
  		var bkgNo;
  		var trfCd;
  		var chgStsCd;
  		var invIssue;
  		with(sheetObj) {
	  		var chkRow=GetSelectRow();
			/*if(CheckedRows("chk") > 0) {
				var chkRows=FindCheckedRow("chk").split("|");
				chkRow=chkRows[0];
			} else if(GetSelectRow()> 0) {
				chkRow=GetSelectRow();
			}*/
	  		if(GetCellValue(chkRow , "cal_flg") == '') {
				ComShowCodeMessage('DMT03054');
				SetSelectRow(chkRow);
				return;
			}
	  		var chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
			if(chgStsCd == 'U' || chgStsCd == 'L' || chgStsCd == 'N' || chgStsCd == 'E' || chgStsCd == 'F') {
				ComShowCodeMessage('DMT01076', 'billing');
				SetSelectRow(chkRow);
				return;
			}
			if(chgStsCd == 'C') {
				bkgNo=GetCellValue(chkRow , "bkg_no");
				trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
				chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
				invIssue="1";
		  		ComSetObjValue(formObj.dmdt_chg_sts_cds, chgStsCd);
			} else if(chgStsCd == 'I') {
				bkgNo=GetCellValue(chkRow , "bkg_no");
				trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
				invIssue="2";
				var invNo=GetCellValue(chkRow , "dmdt_inv_no");
		  		ComSetObjValue(formObj.s_invoice_no,	invNo);
		  		ComSetObjValue(formObj.cre_ofc_cd,		"SZPBB");
			}
			with(formObj) {
	  			ComSetObjValue(s_bkg_no, 		bkgNo);
	  			ComSetObjValue(s_dmdt_trf_cd,	trfCd);
	  			ComSetObjValue(invoice_issue,	invIssue);
	  			ComSetObjValue(dmdt_chg_sts_cds,chgStsCd);
	  		}
  		}
  		tabObjects[0].TabEnable(1)=true;
  		tabObjects[0].selectedIndex=1;
  		// Retrieve
  		doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_MBILL);
  		//Retrieves the current date by office
		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
		doActionIBCombo(sheetObjects[3], formObj, comboObjects[2], SEARCHLIST06);
  	}
	function initControl() {
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- out of focus
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form2);
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); // Get focus
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form2); // Get focus
  		//axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
  		//axon_event.addListenerFormat('keypress','obj_keypress', document.form2); //- on press keyboard
//  		axon_event.addListener('click', 'condType_click', 'cond_type');
  		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//  		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_remark','btn_CRemark');	// onMouseover event
//		axon_event.addListener('mouseout', 'obj_mouseout',	 'txt_remark','btn_CRemark');	// onMouseout event
		//axon_event.addListener('blur', 'sheetobj_blur', 't1sheet1');
  	}
	// Retrieving conditions(Date/VVD CD/CNTGR) Transfer function of the radio button click event
	function condType_click() {
		doEnableCondObj(ComGetEvent("value"));
	}
	// Retrieving conditions(Date/VVD CD/CNTGR) Handling function of the radio button click event
	function doEnableCondObj(condType) {
    	 var formObj=document.form;
    	 with (formObj) {
	    	 switch(condType){
	    	 	case "date":
	    	 		ComEnableManyObjects(true, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd);			//VVD CD: Disable
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);	//CNTR: Disable
	    	 		DmtComSetClassManyObjects('input2', vvd_cd, tmnl_cd, bkg_no, bl_no, cntr_no); //Disable class (input2)
	    	 		comboObjects[1].SetEnable(1);//Date YD
	    	 		//===> Search conditions(VVD CD, CNTR) Clear
	    	 		ComSetObjValue(yard_fmto, "yard_fm");
	    	 		ComClearManyObjects(vvd_cd, tmnl_cd);			//VVD CD
	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);	//CNTR
	    	 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
	    	 		break;
	    	 	case "vvd_cd":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(true, vvd_cd, tmnl_cd);
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', vvd_cd); 			//Display mandatory item
	    	 		DmtComSetClassManyObjects('input2', yd_cd, bkg_no, bl_no, cntr_no);
	    	 		comboObjects[1].SetEnable(0);//Date YD
	    	 		// Search conditions(Date, CNTR) Clear
	    	 		comboObjects[1].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, bkg_no, bl_no, cntr_no);	//CNTR
	    	 		break;
	    	 	case "cntr":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd);
	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no); //Display mandatory item
	    	 		DmtComSetClassManyObjects('input2', yd_cd, vvd_cd, tmnl_cd);
	    	 		comboObjects[1].SetEnable(0);//Date YD
	    	 		//===> Search conditions(Date, VVD CD) Clear
	    	 		comboObjects[1].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, vvd_cd, tmnl_cd);	//VVD CD
	    	 		break;
	    	 }
	    	 // activating Period
	    	 if(condType == 'date') {
	    		ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
	    		DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
	    		//Period Date initializing
	    		var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj);
				var fmMvmtDt=ComGetDateAdd(ofcCurrDate, "D", -15);
				var toMvmtDt=ofcCurrDate;
				ComSetObjValue(fm_mvmt_dt1, fmMvmtDt);
				ComSetObjValue(to_mvmt_dt1, toMvmtDt);
	    	 } else {
	    		 ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
	    		 DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
	    		 ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1);
	    	 }
	    	 // Multi-input pop open the icon to enable / disable the handling
	    	 if(condType == 'cntr') {
	    		 ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 } else {
	    		 ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 }
    	 }
     }
	// out of focus
    function obj_blur(){
        //check inputing Validation + Inserting separator 
        var obj=ComGetEvent();
        if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
        } else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
			 if(obj.value.length > 0 && obj.value.length < 5) {
				var cdDiv=(obj.name == 'yd_cd') ? 'Yard' : 'Location';
				ComShowCodeMessage('DMT00110', cdDiv);
				ComClearObject(obj);
			 }
        } else if(obj.name == 'payer_cd') {
			doActionText(sheetObjects[3], document.form2, obj, SEARCH20);
        } else if(obj.name == 'trucker_cd') {
			doActionText(sheetObjects[3], document.form2, obj, SEARCHLIST04);	 
        } else {
        	ComChkObjValid(obj);
        }
    }
	// Payer, Trucker
	function doActionText(sheetObj, formObj, object, formCmd) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		//Check Payer
		if(object.name == "payer_cd"){
			//cust_cd
			ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
			var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			if(cust_len == 0){
				clearPayerAttention();
				return;
			}
			var cre_cnt_cd="";
			//Before Invoice issue
			if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
				cre_cnt_cd=ComGetObjValue(formObj.session_cnt_cd);
			//After Invoice issue
			}else if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
				cre_cnt_cd=ComGetObjValue(formObj.cre_cnt_cd);
			}
			//USA : customer + vendor 
			if(cre_cnt_cd == "CA" || cre_cnt_cd == "US"){
				if(cust_len > 2) {
					var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					//If the two-digit alphanumeric code, then Retrieving CUSTOMER
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					// else Retrieving VENDOR
					}else{
						ComSetObjValue(formObj.s_cust_gubun, "1");
					}
				} else {
					ComSetObjValue(formObj.s_cust_gubun, "1");
				}
			} else {
				//US except: customer only apply (vendor except for error handling)
				if(cust_len > 2) {
					var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					//If the two-digit alphanumeric code, then Retrieving CUSTOMER
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					// else Retrieving VENDOR
					}else{
						ComShowCodeMessage("DMT00165", "Payer");
						clearPayerAttention();
						ComSetFocus(formObj.payer_cd);
						return;
					}
				} else {
					ComShowCodeMessage("DMT00165", "Payer");
					clearPayerAttention();
					ComSetFocus(formObj.payer_cd);
					return;
				}
			}
			ComSetObjValue(formObj.f_cmd, formCmd);
			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
			var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
			var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
			if(cust_nm == null || cust_nm == "") {
				ComShowCodeMessage("DMT00165", "Payer");
				clearPayerAttention();
				ComSetFocus(formObj.payer_cd);
			}else{
				ComSetObjValue(formObj.payer_cd, cust_cd);
				ComSetObjValue(formObj.payer_nm, cust_nm);
				searchAttentionList();
			}
		} else if(object.name == "trucker_cd") {
			// Trucker Code, Name(vndr_seq)  
			ComSetObjValue(formObj.vndr_cd, ComGetObjValue(formObj.trucker_cd));
			var vndr_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.vndr_cd)));
			//change
			if(vndr_len == 0) {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				return;
			}
			ComSetObjValue(formObj.f_cmd, formCmd);
			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var vndr_cd=ComGetEtcData(sXml, "VNDR_CD");	// add
			var vndr_nm=ComGetEtcData(sXml, "VNDR_NM");
			if(vndr_nm == null || vndr_nm == "") {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComShowCodeMessage("DMT00165", "Trucker");
				ComSetFocus(formObj.trucker_cd);
			}else{
				ComSetObjValue(formObj.trucker_cd, vndr_cd);	// Change
				ComSetObjValue(formObj.trucker_nm, vndr_nm);
				ComSetObjValue(formObj.vndr_seq, vndr_cd);
			}
		}
        sheetObj.SetWaitImageVisible(1);
    }
	function clearPayerAttention() {
		var formObj=document.form2;
		with(formObj) {
			ComSetObjValue(s_cust_gubun, "");
			ComSetObjValue(s_cust_cd, "");
			ComClearManyObjects(payer_cd, payer_nm, payr_cntc_pnt_phn_no, payr_cntc_pnt_fax_no, payr_cntc_pnt_eml);
		}
		// Attention IBCombo
		comboObjects[2].RemoveAll();
	}
	// Attention 정보  Clear
    function clearAttention() {
    	var formObj=document.form2;
    	comboObjects[2].RemoveAll();
    	ComClearManyObjects(formObj.payr_cntc_pnt_phn_no, formObj.payr_cntc_pnt_fax_no, formObj.payr_cntc_pnt_eml);
    }
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
   	 var obj=ComGetEvent();
        ComClearSeparator(obj);
        //If you have a block of text so as to choose.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
	//business javascript OnKeyPress event handling
	function obj_keypress() {
   	 switch(ComGetEvent("dataformat")){
        	case "engup":
		    	// upper case + numbers 
        		ComKeyOnlyAlphabet('uppernum');
		        break;
        	case "engup2":
		    	//  upper case + numbers + exceptional letters
        		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
        	case "int":
	   	        //only numbers
	   	        ComKeyOnlyNumber(ComGetEvent());
	   	        break;
        	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(ComGetEvent());
   	 }
    }
	/*
	 * Yard, Port (Location) field of the input code value for the KeyUp event handler function for Validation
	 */
	function obj_keyup() {
		var srcObj=ComGetEvent();
		checkLocYdCd(srcObj);
	}
	/*
	 * Yard, Port (Location) Validation of the handling function code value entered in the field
	 */
	function checkLocYdCd(srcObj) {
		var formObj=document.form;
		var cd=ComTrim(ComGetObjValue(srcObj));
		if (cd.length == 5) {
			//var comboObj = (srcObj.name == 'yd_cd') ? comboObjects[1]:comboObjects[4];
			var comboObj=comboObjects[1];
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				if(comboObj.GetItemCount() == 0) {
					formObj.loc_cd.value=cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.tmnl_cd);
				}
			} else {
				formObj.loc_cd.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
			}
		}
	}
	// (button Show balloon message)
 	function obj_mouseover() {
  		var msg='';
 		var x=event.x+document.body.scrollLeft;
 		var y=event.y+document.body.scrollTop;
//      	switch(event.srcElement.id){
 		switch(ComGetEvent("name")){
 	  		case 'txt_remark':
 	  			msg='Invoice Remark will be included in the Invoice Sheet';
 	  			x=x;
 	  			y=y-10;
 	  			break;
 	  		case 'btn_CRemark':
 	  			msg='Invoice Cancel Remark';
 	  			x=x-120;
 	  			y=y+20;
 	  			break;
 	  		case 'btn_HRemark':
 	  			msg='Invoice Hold Remark';
 	  			x=x-120;
 	  			y=y;
 	  			break;
      	}
      	var bak='lightyellow';
  		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
  						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
  		document.all("topdeck").innerHTML=content;
  		var skn=document.all("topdeck").style;
  		skn.left=x;
  		skn.top=y;
  		skn.visibility='visible';
     }
     // (button Hide balloon message)
 	function obj_mouseout() {
 		var skn=document.all("topdeck").style;
 		skn.visibility='hidden';
 	}
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
              case "t1sheet1":      //sheet1 init
				with(sheetObj){
            	  	SetSelectionMode(smSelectionList);
					var HeadTitle="||Seq.|Get|Cal.|STS|CNTR No.|T/S|From YD|To YD|Fm|To|Tariff|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Billable AMT|BKG No|B/L No"+"|VVD CD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|A/Cust|SOC|D/O|R/OFC|R/O|Invoice No.|ISS DT|INV Cur.|Billing AMT"+"|Payer|Payer|Shipper|Shipper|Cnsignee|Cnsignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer"+"|Service Provider|Service Provider|Commodity|Commodity|Remark(s)";
					SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("cntr_tpsz_cd"), MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					   {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					   {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"get_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Get To MVMT Processed"},
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cal_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"acust",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d_o",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Cargo Release"},
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Cargo Release Office"},
					   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"roll_ovr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Roll Over due to Carrier Schedule Change"},
					   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"payer_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"shipper_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ar_act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_provdr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"svc_provdr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					   {Type:"Popup",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"corr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,	ToolTip:1 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_split_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					   {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					 
					InitColumns(cols);
					SetSheetHeight(330);
					SetEditable(1);
					SetEllipsis(1);
//					FrozenCols=SaveNameCol("cntr_tpsz_cd");
					SetShowButtonImage(2);
				 }
                 break;
              case "t1sheet2":	// Data Communication Hidden sheet init (Get To MVMT)
					with(sheetObj){
						var HeadTitle="|Seq.|CNTR No.|BKG No.|To YD|To DT|To YR|To Seq|To SpNo";
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						   {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
						   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_split_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
						 
						InitColumns(cols);
						
						SetEditable(1);
					} // with - end
	         	 break;
              case "t1sheet3":	// Data Communication Hidden sheet init (Calculate)
					with(sheetObj){
						var HeadTitle="|Seq.|svr_id|cntr_no|cntr_cyc|trf_cd|loc_div|chg_seq|cntr_tpsz|bkg_no|vvd_cd|To DT|To|To YD|To YR|To Seq|To SpNo|F/T|Over|F/T CMNC|F/T End|Cur.|Billable AMT|STS|From DT";
						
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						   {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_split_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						 
						InitColumns(cols);
						SetSheetHeight(GetSheetHeight(5) + 100);
						SetEditable(1);
					} // with - end
            	break; 	 
 			case "t2sheet1":      // Tab2 - Charge
				with(sheetObj){
					var HeadTitle1="|Seq.|CNTR No.|T/S|From DT|To DT|F/T CMNC|F/T End|F/D";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_grp_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rt_dtl_grp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_aply_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(TAB2_SHEET_HEIGHT + 20);
					SetEditable(1);
					SetShowButtonImage(2);
				}
 				break;
 			case "t2sheet2":      // Tab2 - Rate Detail
				with(sheetObj){
					var HeadTitle1="|From|Up To|Rate|Over|Billable AMT";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_over",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_under",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"rt_rate",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_day",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rt_chrg",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rt_cur_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(TAB2_SHEET_HEIGHT + 20);
					SetEditable(1);
				}
 				break;
 			case "t2sheet3":      //sheet1 init
				with(sheetObj){
					var HeadTitle="";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"}];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
					   
					InitColumns(cols);
					SetSheetHeight(102);
					SetEditable(1);
				}
				break;
         }
     }
  	/**
     * IBSHeet mouse click in the data area that occurs when cells Event<br>
     */
    function t1sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk") {
                // Check Box Check that row when clicked
                //"/" Separator connected to get row number of the selected row, the result: "3/4/5"
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                	for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "chk")) {
                        	// Toggle
                        	SetCellValue(arr[i], "chk",(GetCellValue(arr[i], "chk") == '0') ? "1" : "0",0);
                        }
                    }
                    // AllCheck box Status synchronization
                    SetHeaderCheck(0, "chk",(CheckedRows("chk") == RowCount()));
                }
            } else {
            	// case in click Check box ,  All Check box Status synchronization
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
    /*
    function t1sheet1_OnPopupClick(sheetObj, row, col) {
  		if(sheetObj.ColSaveName(col) == 'corr_rmk')
  			ComShowMemoPad(sheetObj);
  	}
  	*/
    function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	var colSaveNm=sheetObj.ColSaveName(Col);
  		if(colSaveNm == "corr_rmk") {
  			if(sheetObj.GetCellValue(Row, "cal_flg") == '') {
				ComShowCodeMessage('DMT03054');
				return;
			}
  			//When corr_rmk double-click the cell to display the MemoPad. (MemoPad editable)
  		    ComShowMemoPad(sheetObj);
  			var _frameDoc=document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
  			var btnSaveObj=_frameDoc.getElementById("btn_apply");
  			btnSaveObj.innerHTML='Save';
  			btnSaveObj.detachEvent('onclick', eval('save_click'));
  			btnSaveObj.attachEvent("onclick", eval('save_click'));
  		}
    }
    function save_click() {
    	var _frameDoc=document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
		var btnSaveObj=_frameDoc.getElementById("btn_apply");
		btnSaveObj.detachEvent('onclick', eval('save_click'));
		doActionIBSheet(sheetObjects[0], document.form, IBSAVE_CORRRMK);
    }
	// sheetObjout of Focus
    function sheetobj_blur() {
   		var sheetObj=sheetObjects[0];
   		with(sheetObj) {
   			var col=GetSelectCol();
   			var row=GetSelectRow();
   			if(ColSaveName(col) != 'corr_rmk') return;
   			if(befCorrRmk != GetCellValue(row, col)) {
   				alert(befCorrRmk + ' --> ' + GetCellValue(row, col));
	  		}
   		}
    }
	/*
	 * Balloon handling in Grid
	 */
//	function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
//		with(sheetObj){
//			Row=MouseRow();
//			Col=MouseCol();
//			if (Row > 0) {
//				var ttText='';
//				var colSaveNm=ColSaveName(Col);
//				if (colSaveNm == 'corr_rmk') {	// Showing the entire contents of Remark
////					var corrRmk=GetCellValue(Row, "corr_rmk");
////					if(corrRmk == '') return;
////					ttText=corrRmk;
//					SetToolTipText(Row, Col, GetCellValue(Row, "corr_rmk"));
//				}
//			} else {
//
//			}
//		}
//	}
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:      // Search
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 			sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 				formObj.f_cmd.value=SEARCH01;
 				sheetObj.DoSearch("EES_DMT_4016GS.do", FormQueryString(formObj) );
 				ComOpenWait(false);
 				break;
 			case IBGETTOMVMT:	// Get To MVMT
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 			sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 				formObj.f_cmd.value=SEARCH02;
				var sheetObj2=sheetObjects[1];	// Hidden Sheet
				sheetObj2.DoAllSave("EES_DMT_4016GS.do", FormQueryString(formObj));
				ComOpenWait(false);
 				break;
 			case IBCALCULATE:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				//formObj.f_cmd.value = MULTI;
				//var sheetObj2 = sheetObjects[2];	// Hidden Sheet
				//sheetObj2.DoAllSave("EES_DMT_4016GS.do", FormQueryString(formObj));
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);
 				sheetObj=sheetObjects[2];	// Hidden Sheet
	         	formObj.f_cmd.value=COMMAND01;	
	         	ComSetObjValue(formObj.backendjob_id, "CALCULATE");
	         	var params=sheetObj.GetSaveString(true, true) + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_4016GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // After three seconds, running getBackEndJobStatus function - a recursive call
				}
                break;
 			case IBCONFIRM:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);
 				var chkRows=sheetObj.FindCheckedRow("chk").split("|");
         		for(var i=0; i < chkRows.length-1; i++) {
         			sheetObj.SetRowStatus(chkRows[i],"U");
         		}
 				formObj.f_cmd.value=MULTI01;
 				sheetObj.DoSave("EES_DMT_4016GS.do", FormQueryString(formObj), "chk");
 				ComOpenWait(false);
                break;
 			case IBSAVE_CORRRMK:
 				//if(!validateForm(sheetObj,formObj,sAction)) return;
 				var row=sheetObj.GetSelectRow();
				var sparam="f_cmd=" 	+ MODIFY
					+ "&svr_id="		+ sheetObj.GetCellValue(row, "svr_id")
					+ "&cntr_no="		+ sheetObj.GetCellValue(row, "cntr_no")
					+ "&cntr_cyc_no="	+ sheetObj.GetCellValue(row, "cntr_cyc_no")
					+ "&dmdt_trf_cd="	+ sheetObj.GetCellValue(row, "dmdt_trf_cd")
					+ "&dmdt_chg_loc_div_cd=" + sheetObj.GetCellValue(row, "dmdt_chg_loc_div_cd")
					+ "&chg_seq="		+ sheetObj.GetCellValue(row, "chg_seq")
					+ "&corr_rmk="		+ sheetObj.GetCellValue(row, "corr_rmk");
				var sheetObj2=sheetObjects[5];
				var sXml=sheetObj2.GetSaveData("EES_DMT_4016GS.do", sparam);
				//sheetObj.LoadSaveXml(sXml);
                break;
 			case IBSEARCH_MBILL:	// Manual Billing Retrieve
				if(sheetObj.id == 't2sheet1') {
					if(!validateForm(sheetObj,formObj,sAction)) return;
					ComSetObjValue(formObj.caller, "4016");
					if(ComGetObjValue(formObj.invoice_issue) == "1") {
						formObj.f_cmd.value=SEARCH;
						//ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
						ComSetObjValue(formObj.s_ofc_cd,	"SZPBB");
						ComSetObjValue(formObj.ofc_cd,		"SZPBB");
					} else {
						formObj.f_cmd.value=SEARCH01;
						//ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
						ComSetObjValue(formObj.ofc_cd, "SZPBB");
					}
					sheetObj.SetWaitImageVisible(0);
		        	ComOpenWait(true);
		        	var sXml=sheetObj.GetSearchData("EES_DMT_4016-2GS.do", FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	                sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
	                ComOpenWait(false);
	                calcBillableAmount();
				} else if(sheetObj.id == 't2sheet3') {
					formObj.f_cmd.value=SEARCH02;
					var sXml=sheetObj.GetSearchData("EES_DMT_4016-2GS.do", FormQueryString(formObj));
					var exRate=ComGetEtcData(sXml, "EX_RATE");
					ComSetObjValue(formObj.inv_xch_rt, exRate);
				}
 				break;    
 			case IBSAVE:
 				var sheetObj2=sheetObjects[3];
 				var sheetObj3=sheetObjects[4];
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 				ComSetObjValue(formObj.caller, "4016");
 				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.s_bkg_no));
 				//Remove the 3-digit comma
				unSetComma();
				var sparam='';
				//Before Invoice issue
 				if(ComGetObjValue(formObj.invoice_issue) == "1") {
 					if(!formObj.chk_tax.checked) {
 						ComSetObjValue(formObj.tax_rto, "0");
 					}
 					for(var i=sheetObj2.GetTopRow(); i <= sheetObj2.LastRow(); i++) {
 						sheetObj2.SetCellValue(i, "ibflag","U",0);
 					}
 					for(var i=sheetObj3.GetTopRow(); i <= sheetObj3.LastRow(); i++) {
 						sheetObj3.SetCellValue(i, "ibflag","U",0);
 					}
 					var sparam1=sheetObj2.GetSaveString();
 					var sparam2=sheetObj3.GetSaveString();
 					sparam1=ComSetPrifix(sparam1, "subCharge");
 					sparam=sparam1 + "&";
 					sparam2=ComSetPrifix(sparam2, "subRate");
 					sparam=sparam + sparam2;
 					formObj.f_cmd.value=MULTI;
 					sparam += "&" + FormQueryString(formObj);
 				} else {
 					//After Invoice issue
 					if(!formObj.chk_tax.checked) {
 						if(parseFloat(ComGetObjValue(formObj.tax_rto_dis)) == 0) {
 							ComSetObjValue(formObj.tax_rto, "0");
 						}else{
 							ComSetObjValue(formObj.tax_rto, ComGetObjValue(formObj.tax_rto_dis));
 						}
 					}
 					formObj.f_cmd.value=MULTI01; //After Invoice issue
 					sparam=FormQueryString(formObj);
 				}
 				var sXml=sheetObj.GetSaveData("EES_DMT_4016-2GS.do", sparam);
 				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				// ************* After saving handling **************
				var successYN=sheetObj.GetEtcData("SUCCESS_YN");
				if(successYN == 'Y') {
					var invIssue=ComGetObjValue(formObj.invoice_issue);
					var invNo;
					if(invIssue == '1') {
						invNo=sheetObj.GetEtcData("INVOICE_NO");
					} else { // '2'
						invNo=ComGetObjValue(formObj.dmdt_inv_no);
					}
					ComSetObjValue(formObj.invoice_issue, "2");
					ComSetObjValue(formObj.s_invoice_no, invNo);
					// Re-SEARCH
					doActionIBSheet(sheetObj, formObj, IBSEARCH_MBILL);
				} else
					initBtns2();
                break;
 			case IBARIF:
 				if(!validateForm(sheetObj,formObj,sAction)) return;   
 				sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 				formObj.f_cmd.value=COMMAND01;
 				//sheetObj.DoSave("EES_DMT_4002GS.do", FormQueryString(formObj), -1, false);
				//var sParam = sheetObj.GetSaveString(true) +"&" + FormQueryString(formObj);
				var sParam=FormQueryString(formObj);
				//Upon successful handling INVOICE Retrieving button
				var sXml=sheetObj.GetSaveData("EES_DMT_4016-2GS.do", sParam);
				//3.Save and processing results
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				// After the save button handling
				var successYN=ComGetEtcData(sXml, "SUCCESS_YN");
				ComSetObjValue(formObj.success_yn, successYN);
				//4.After the save button handling
				if(successYN == "Y") {
					// Retrieve
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_MBILL);
					var invStsCd=ComGetObjValue(formObj.dmdt_inv_sts_cd);
					var arIfCd=ComGetObjValue(formObj.dmdt_ar_if_cd);
					//ARIF button Enable
					if( (invStsCd == "I" || invStsCd == "C") && arIfCd == "N")
						ComBtnEnable("btn_ARIF");
					else
						ComBtnDisable("btn_ARIF");
				}
				break;
 			case IBFAXSEND:
        		var mrd_file="";
        		//MRD file
        		var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
        		if(temp_LR == "") {
        			mrd_file="EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "L") {
        			mrd_file="EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "R") {
        			mrd_file="EES_DMT_4902.mrd";		//R
        		}
        		var dmdtInvNo=ComGetObjValue(formObj.dmdt_inv_no);
        		var blNo=ComGetObjValue(formObj.bl_no);
	    		var ma_param="jspno=4016"
					 + "&invoice_no=" + dmdtInvNo
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 ;
	       		//Search MASTER DATA
	    		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
	       		sheetObj.LoadSearchData(sXml,{Sync:1} );
	       		ComEtcDataToForm(formObj, sheetObj);
	       		//rd_fxeml_rd_param
	       		var rdParm=" /ruseurlmoniker[0] /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
	   						+ " /rv " + rvParmByInvoice(formObj)
							+ " /rpost [jspno=4016&invoice_no=" + dmdtInvNo + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd) + "]";
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Number: " + dmdtInvNo + " (B/L No.: COM" + blNo + ")");
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");		//rcvr_email
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	"");
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo);	//"name;mjchang|message;" + mailCtnt);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");					//  I : Invoice D : Demend G : GroupDemand O : OTS
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    			ComSetObjValue(formObj.invno,					dmdtInvNo);
        		break;
        	case IBEMAILSEND:
        		var mrd_file="";
        		//MRD file
        		var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
        		if(temp_LR == "") {
        			mrd_file="EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "L") {
        			mrd_file="EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "R") {
        			mrd_file="EES_DMT_4902.mrd";		//R
        		}
        		var dmdtInvNo=ComGetObjValue(formObj.dmdt_inv_no);
        		var blNo=ComGetObjValue(formObj.bl_no);
	    		var ma_param="jspno=4016"
					 + "&invoice_no=" + dmdtInvNo
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd);
        		//Search MASTER DATA
	    		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
        		ComEtcDataToForm(formObj, sheetObj);
        		//rd_fxeml_rd_param
        		var rdParm=" /ruseurlmoniker[0] /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
    						+ " /rv " + rvParmByInvoice(formObj)
							+ " /rpost [jspno=4016&invoice_no=" + dmdtInvNo + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd) + "]"		//jspno, invoice_no
    						;
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Number: " + dmdtInvNo + " (B/L No.: COMC" + blNo + ")");
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	dmdtInvNo);
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo);	//"name;mjchang|message;" + mailCtnt);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");					//  I : Invoice D : Demend G : GroupDemand O : OTS
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    			ComSetObjValue(formObj.invno,					dmdtInvNo);
        		break;	
         }
	}
	/**
	* Status of BackEndJob a '3 'to make sure when.
	*/
	function getBackEndJobStatus() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[2];
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	 	var params="f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSearchData("EES_DMT_4016GS.do", params);
	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	 	// jobState == "2" BackEndJob Progress......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob success.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// Failure BackEndJob.
	 		var jbUsrErrMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// BackEndJob already have read the resulting file.
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	}
	//At the end of BackEndJob success is a reflection of the resulting data.
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[2];
	 	var fCmd=MULTI;
 	 	ComSetObjValue(formObj.f_cmd, fCmd);
	 	var params="f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSaveData("EES_DMT_4016GS.do", params);
	 	sheetObj.LoadSaveData(sXml);
	 	ComOpenWait(false);
	}
	/**
     * Processing after confirm
     */
  	function t1sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
  		if(ErrMsg != '') return;
		var formObj=document.form1;
		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
  		for(var i=0; i < chkRows.length-1; i++) {
  			sheetObj.SetCellValue(chkRows[i], "dmdt_chg_sts_cd",'C');
  		}
  		//All UnCheck -> sheetObj.RowStatus (i) all of the 'R' be changed to
		sheetObj.CheckAll("chk",0);
  	}
	/**
     * t1sheet2(Hidden Sheet - Get To MVMT)After the call handling
     */
  	function t1sheet2_OnSaveEnd(sheetObj,code,ErrMsg) {
  		if(ErrMsg != '') return;
		var formObj=document.form;
		var mainSheetObj=sheetObjects[0];	// The original list of Retrieving
		for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
			var seq=sheetObj.GetCellValue(i, "seq");
			var rowIdx=mainSheetObj.FindText("seq", seq);
			if(rowIdx != -1) {
				var toMvmtYdCd=sheetObj.GetCellValue(i, "to_mvmt_yd_cd");
				var toMvmtDt=sheetObj.GetCellValue(i, "to_mvmt_dt");
				var toMvmtYr=sheetObj.GetCellValue(i, "to_mvmt_yr");
				var toMvmtSeq=sheetObj.GetCellValue(i, "to_mvmt_seq");
				var toMvmtSplitNo=sheetObj.GetCellValue(i, "to_mvmt_split_no");
				with(mainSheetObj) {
					//CellValue(rowIdx, "get_flg")			= 'Y';
					SetCellValue(rowIdx, "to_mvmt_yd_cd",toMvmtYdCd,0);
					SetCellValue(rowIdx, "to_mvmt_sts_cd",'ID',0);
					SetCellValue(rowIdx, "dmdt_trf_cd",'DMIF',0);
					SetCellValue(rowIdx, "to_mvmt_dt",toMvmtDt,0);
					SetCellValue(rowIdx, "to_mvmt_yr",toMvmtYr,0);
					SetCellValue(rowIdx, "to_mvmt_seq",toMvmtSeq,0);
					SetCellValue(rowIdx, "to_mvmt_split_no",toMvmtSplitNo,0);
				}
			}
		}
		var chkRows=mainSheetObj.FindCheckedRow("chk").split("|");
 		for(var i=0; i < chkRows.length-1; i++) {
 			mainSheetObj.SetCellValue(chkRows[i], "get_flg",'Y',0);
 		}
  	}
     /**
      * t1sheet3(Hidden Sheet - Calculate)After the call handling
      */
   	function t1sheet3_OnSaveEnd(sheetObj,code,ErrMsg) {
   		if(ErrMsg != '') return;
 		var formObj=document.form;
 		var mainSheetObj=sheetObjects[0];	// The original list of Retrieving
 		for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
 			var seq=sheetObj.GetCellValue(i, "seq");
 			var rowIdx=mainSheetObj.FindText("seq", seq);
 			if(rowIdx != -1) {
				mainSheetObj.SetCellValue(rowIdx, "cal_flg",'Y');
				mainSheetObj.SetCellValue(rowIdx, "ft_dys",sheetObj.GetCellValue(i, "ft_dys"));
				mainSheetObj.SetCellValue(rowIdx, "fx_ft_ovr_dys",sheetObj.GetCellValue(i, "fx_ft_ovr_dys"));
				mainSheetObj.SetCellValue(rowIdx, "ft_cmnc_dt",sheetObj.GetCellValue(i, "ft_cmnc_dt"));
				mainSheetObj.SetCellValue(rowIdx, "ft_end_dt",sheetObj.GetCellValue(i, "ft_end_dt"));
				mainSheetObj.SetCellValue(rowIdx, "bzc_trf_curr_cd",sheetObj.GetCellValue(i, "bzc_trf_curr_cd"));
				mainSheetObj.SetCellValue(rowIdx, "bil_amt",sheetObj.GetCellValue(i, "bil_amt"));
				mainSheetObj.SetCellValue(rowIdx, "dmdt_chg_sts_cd",sheetObj.GetCellValue(i, "dmdt_chg_sts_cd"));
				mainSheetObj.SetCellValue(rowIdx, "dmdt_chg_loc_div_cd","SZP");
 			}
 		}
 		tabObjects[0].TabEnable(1)=false;
   	}
	// REMARK MESSAGE
	function AlertCRemark() {
		var formObj=document.form2;
		var cancel_rmk=ComGetObjValue(formObj.cxl_rmk);		//	cancel_remark
		var cancel_date=ComGetObjValue(formObj.upd_dt);		//	update_dt
		var ofc_cd=ComGetObjValue(formObj.upd_ofc_cd);	//	update_ofc_cd
		var usr_id=ComGetObjValue(formObj.upd_usr_id);	//update_usr_id
		var usr_name=ComGetObjValue(formObj.upd_usr_nm);	//update_usr_nm
		var msg=cancel_rmk
						+ "\n\nCancel Date: "+ cancel_date
						+ "\nOffice: "		+ ofc_cd
						+ "\nUser ID: "		+ usr_id
						+ "\nUser Name: "	+ usr_name;
		ComShowMessage(msg);
  	}
	/**
	 * Check Tax Rate
	 */
	 function setTax(){
		var formObj=document.form2;
		if(formObj.chk_tax.checked) {
			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
		}else{
			ComSetObjValue(formObj.tax_rto_dis, "0");
		}
		getExRate();
		setComma();
	}
	/**
	 * If you change the INV Currency, ExRate view and Invoice Amt is calculated.
	 */
	function getExRate() {
		var formObj=document.form2;
		var chg_curr_cd=ComGetObjValue(formObj.chg_curr_cd);
		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
		if(chg_curr_cd == "" || inv_curr_cd == "")	return;
		var chg_dc_amt;
		var inv_xch_rt;	
		var tot_amt;	
		var dc_amt;		
		var bil_amt;
		var inv_chg_amt;
		var tax_rto;
		var tax_amt;
		var inv_amt;
		bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),	"float"));	//Billable AMT
		tax_rto=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_rto_dis),	"float"));	//Tax Rate
		chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),	"float"));	//Discount AMT
		tot_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),		"float"));	//Total AMT
		inv_xch_rt=ComGetObjValue(formObj.inv_xch_rt);
		inv_xch_rt=ComRound(inv_xch_rt, 6);	//6-digit decimal rounding
		//tot_amt = tot_amt * inv_xch_rt;
		//tot_amt = DMTtrimCurrencyAmount(inv_curr_cd, tot_amt);
		//alert('tot_amt: ' + tot_amt);
		//calculation logic changes dc_amt
		//dc_amt	= inv_xch_rt * chg_dc_amt;
		//dc_amt	= DMTtrimCurrencyAmount(inv_curr_cd, dc_amt);
		dc_amt=chg_dc_amt;
		//calculation logic changes Billing AMT
		inv_chg_amt=tot_amt - dc_amt;
		inv_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_chg_amt);
		var cre_cnt_cd="";
		//Before Invoice issue
		if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
			cre_cnt_cd=ComGetObjValue(formObj.session_cnt_cd);
		//After Invoice issue
		} else { //if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
			cre_cnt_cd=ComGetObjValue(formObj.cre_cnt_cd);
		}
//		if(cre_cnt_cd == "VN") {	//If Vietnam
//			tax_amt=(inv_chg_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//		}else{
			tax_amt=(tax_rto * 0.01) * inv_chg_amt;
//		}
		tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tax_amt);
		inv_amt=inv_chg_amt + tax_amt;
		inv_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_amt);
		//Rounding, cut-off handling
		//ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
		//ComSetObjValue(formObj.tot_amt, tot_amt);
		//ComSetObjValue(formObj.dc_amt, dc_amt);
		//ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		setComma();
	}
	/**
	 * The a numeric string in numeric format is changed to suit.
	 */
	function setComma(){
    	var formObj=document.form2;
		//Charge 3-digit comma
//		var org_chg_amt		= ComAddComma2(ComGetObjValue(formObj.mn_org_chg_amt),"#,###.00");
//		var dmdt_expt_amt	= ComAddComma2(ComGetObjValue(formObj.dmdt_expt_amt),"#,###.00");
//		var chg_dc_amt		= ComAddComma2(ComGetObjValue(formObj.chg_dc_amt),"#,###.00");
		var bil_amt=ComAddComma2(ComGetObjValue(formObj.mn_bil_amt),"#,###.00");
//		var aft_inv_adj_amt	= ComAddComma2(ComGetObjValue(formObj.aft_inv_adj_amt),"#,###.00");
		//Invoice
		var tot_amt=ComAddComma2(ComGetObjValue(formObj.tot_amt),"#,###.00");
		var dc_amt=ComAddComma2(ComGetObjValue(formObj.dc_amt),"#,###.00");
		var inv_chg_amt=ComAddComma2(ComGetObjValue(formObj.inv_chg_amt),"#,###.00");
		var tax_amt=ComAddComma2(ComGetObjValue(formObj.tax_amt),"#,###.00");
		var inv_amt=ComAddComma2(ComGetObjValue(formObj.inv_amt),"#,###.00");
		var inv_xch_rt=parseFloat(ComGetObjValue(formObj.inv_xch_rt)).toFixed(6);
//		ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
//		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
//		ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
//		ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
		ComSetObjValue(formObj.tot_amt, tot_amt);
		ComSetObjValue(formObj.dc_amt, dc_amt);
		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
    }
	function unSetComma(){
        var formObj=document.form2;
  		//ChargeRemove the 3-digit comma
//  	var org_chg_amt		= ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float");
//  	var dmdt_expt_amt	= ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float");
//  	var chg_dc_amt		= ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float");
  		var bil_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float");
//  	var aft_inv_adj_amt	= ComGetUnMaskedValue(ComGetObjValue(formObj.aft_inv_adj_amt),"float");
  		//Invoice
  		var tot_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),"float");
  		var dc_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.dc_amt),"float");
  		var inv_chg_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float");
  		var tax_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tax_amt),"float");
  		var inv_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_amt),"float");
//  	ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
// 		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
//  	ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
  		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
//  	ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
  		ComSetObjValue(formObj.tot_amt, tot_amt);
  		ComSetObjValue(formObj.dc_amt, dc_amt);
  		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
  		ComSetObjValue(formObj.tax_amt, tax_amt);
  		ComSetObjValue(formObj.inv_amt, inv_amt);    	
	}
    /**
	 * Initializing Combo 
	 * param : comboObj , comboNo
	 *  adding case as numbers of counting Combos
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj=document.form;
	    switch(comboObj.options.id) {  
	    	case "tariff_type":
	    		with (comboObj) { 
					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "45");
					SetColWidth(1, "270");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
					SetColBackColor(1,"#CCFFFD");
					InsertItem(0, "DMIF|DEMURRAGE INBOUND LADEN CONTAINER", "DMIF");
	  				InsertItem(1, "DMOF|DEMURRAGE OUTBOUND LADEN CONTAINER", "DMOF");
			    }
	    		break;
	    	case "yd_cd2":
   	    		with (comboObj) { 
   	    			SetMultiSelect(0);
  					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
  					SetDropHeight(160);
  					ValidChar(2, 1);	// using the English uppercase letters, numbers
					SetMaxLength(2);
   		    	}
   	    		break;
	    	case "attention":
	    		with (comboObj) {
					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColAlign(2, "left");
					SetColAlign(3, "left");
					SetDropHeight(160);
			    }
	    		break;
	    }
	}
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=formCmd;
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 switch(comboObj.options.id) {
 	        case "yd_cd2":
 	        	var comboDatas;
 	        	var chkObj;
 	        	var condType=ComGetObjValue(formObj.cond_type);
 	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();
	 	        	chkObj=formObj.chk_yd_cd;
	 	        	comboDatas=ComGetEtcData(sXml, "YD");
 	        	} else {
 	        		if(condType == 'date')
 	        			chkObj=formObj.chk_yd_cd;
 	        		else
 	        			chkObj=formObj.chk_loc_cd;
 	        		comboDatas=ComGetEtcData(sXml, "LOC_CD");
 	        	}
				if (comboDatas != undefined && comboDatas != '') {
					ComSetObjValue(chkObj, "Y");
					if(srcObj.name == 'yd_cd') {
						comboItems=comboDatas.split(ROWMARK);
						addComboItem2(comboObj, comboItems);
					}
				} else {
					ComClearObject(srcObj);
					if(srcObj.name == 'yd_cd') {
						sheetObj.SetWaitImageVisible(1);
						return;
					}
					ComSetObjValue(chkObj, "N");
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
 	        	break;
 	        case "attention":
 	        	// ATTENTION LIST
 	        	if(formCmd == SEARCHLIST03) {
					var comboDatas;
					var comboItems;
					comboDatas=ComGetEtcData(sXml, "ATTENTION");
					comboObj.RemoveAll();
					if(comboDatas != undefined && comboDatas != '') {
						comboItems=comboDatas.split(ROWMARK);
						addComboItem2(comboObj, comboItems);
					}
 	        	} else if(formCmd == SEARCHLIST06) {
 	        		ComSetObjValue(formObj.ofc_curr_date, ComGetEtcData(sXml, "OFC_CURR_DAY"));
				}
 	        	break;
         }
         sheetObj.SetWaitImageVisible(1);
     }
    /**
     * Data in the field adds a combo.
     */	
 	function addComboItem(comboObj, comboDatas, isOnlyCode, isReverse) {
 		var comboItem;
 		var comboItems;
 		var val;
 		var txt;
 		if (comboDatas != undefined) {
 			comboItems=comboDatas.split(ROWMARK);	
 	    	for (var i=0 ; i < comboItems.length ; i++) {
 	    		comboItem=comboItems[i].split(FIELDMARK);
 	    		//ComboItem[0]: Code, [1]: Description
    			val=comboItem[0];
 				txt=isOnlyCode ? comboItem[0] : comboItem[1];
 				// Combo box to be displayed in the Description and to establishing a variable
 				if (isReverse) {
 					ComAddComboItem(comboObj,txt,val);
 				}
 				else {
 					ComAddComboItem(comboObj,val,txt);
 				}
 	    	}
 		}   		
 	}
 	/**
     * Data in the field adds a combo.
     */	
	function addComboItem2(comboObj, comboItems) {
 		switch(comboObj.id) {
 			case "yd_cd2":
 				for (var i=0 ; i < comboItems.length ; i++) {
 		    		var comboItem=comboItems[i].split(FIELDMARK);
 					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
 		    	}
 				break;
 			case "attention":
 				for (var i=0 ; i < comboItems.length ; i++) {
 		    		var comboItem=comboItems[i].split(FIELDMARK);
 					comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);		
 		    	}
 				break;
 		}
	}
	/**
	* Data in the field adds a combo. 
	*/	
   	function addMultiComboItem(comboObj, comboItems) {
       	for (var i=0 ; i < comboItems.length ; i++) {
       		var comboItem=comboItems[i].split(FIELDMARK);
   			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
       	}
   	}
 	//Attention IB combo selection event
	function attention_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		var formObj=document.form2;
		var code=comboObj.GetSelectCode();
		//alert('attention_OnChange --> ' + code);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm,	comboObj.GetText(NewCod,0));
		ComSetObjValue(formObj.payr_cntc_pnt_phn_no,	comboObj.GetText(NewCod,1));	//To show the text column
		ComSetObjValue(formObj.payr_cntc_pnt_fax_no,	comboObj.GetText(NewCod,2));	//To show the text column
		ComSetObjValue(formObj.payr_cntc_pnt_eml,		comboObj.GetText(NewCod,3));	//To show the text column
		var codes=NewCod.split("^");			//code
		if(codes != undefined || codes != "") {
			ComSetObjValue(formObj.cust_cntc_pnt_seq , codes[1]);
		}
	}
    //Combo-related functions to retrieve data
  	function doActionIBCommon(sheetObj, formObj, sAction, formCmd) {
  	    sheetObj.ShowDebugMsg(false);
  		sheetObj.SetWaitImageVisible(0);
  		//1.Setting parametor condition, before retrieving
  		ComSetObjValue(formObj.f_cmd, formCmd);
  		//ComSetObjValue(formObj.ofc_cd, "SZPBB");
  		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
  	    switch(formCmd) {
  	    	// Retrieving of SHEET SET exists
			case COMMAND13:
				ComSetObjValue(formObj.dmdt_sh_tp_cd, "I");
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//3.After handling Retrieving results
				ComSetObjValue(formObj.has_sheetset, ComGetEtcData(sXml, "RESULT"));
				break;
			// Search Sheet Option
			case COMMAND14:
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//3.After handling Retrieving results
				ComSetObjValue(formObj.bil_to_loc_div_cd, 	ComGetEtcData(sXml, "BIL_TO_LOC_DIV_CD"));
				break;
			//Payer's Email, FAX number is Retrieving.
			case COMMAND02:
				var sParam="f_cmd=" + COMMAND02
						  + "&payer_cd="	+ formObj.payer_cd.value
						  + "&dmdt_trf_cd=" + formObj.dmdt_trf_cd.value
						  + "&ofc_cd="		+ formObj.cre_ofc_cd.value;
				var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", sParam);
				//3.After handling Retrieving results
				ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
				ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
				break;
  	    }
  		sheetObj.SetWaitImageVisible(1);
  	}
	// IBMultiCombo Tariff Type initializing
   	function initComboValue_tariff_type() {
   		comboObjects[0].SetSelectCode("DMIF");
   	}
	// IBMultiCombo YardCode2 initializing
   	function initComboValue_yd_cd2() {
   		comboObjects[1].RemoveAll();
   	}
	/**
  	 * IBSheet lookup function Retrieving is complete, caused by an Event
  	 * (Tab-1 Retrieve After processing)
  	 */
  	function t1sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
  		if(ErrMsg != '') return;
		var formObj=document.form;
		sheetObj.CheckAll("chk",0);
		with(formObj) {
//			tabObjects[0].TabEnable(1)=false;
			tabObjects[0].SetTabDisable(true);
  			// Without a resulting data, Search conditions enter the data retention
        	if(sheetObj.SearchRows()== 0) {
        		initBtns();
        	} else {
        		var trfCd=comboObjects[0].GetSelectCode();
        		if(trfCd == 'DMIF') {
        			ComBtnEnable('btn_GetToMVMT');
        			for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
        				if(sheetObj.GetCellValue(i, "dmdt_chg_sts_cd") != '') {
	        				sheetObj.SetCellValue(i, "get_flg","Y",0);
	        				sheetObj.SetCellValue(i, "cal_flg","Y",0);
        				}
        			}
        		} else {	// 'DMOF'
        			ComBtnDisable('btn_GetToMVMT');
        			for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
        				if(sheetObj.GetCellValue(i, "dmdt_chg_sts_cd") != '')
        					sheetObj.SetCellValue(i, "cal_flg","Y",0);
        				sheetObj.SetCellValue(i, "get_flg","Y",0);
        				sheetObj.SetCellValue(i, "dmdt_trf_cd","DMOF",0);
        			}
        		}
    			// Activating of button
    			DmtComEnableManyBtns(true, "btn_Calculate", "btn_Confirm", "btn_MBilling", "btn_MVMTInq", "btn_ExptInq", "btn_DownExcel");
//        		if(sheetObj.CellValue(sheetObj.TopRow, "roll_ovr") == 'S')
//			  		document.getElementById("btn_ROInfo").style.color = "red";
//        		else
//        			document.getElementById("btn_ROInfo").style.color = "";
  			}
		} // with end
  	}
	// Tab-2 Retrieve After processing
  	function t2sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
  		var formObj=document.form2;
  		// Search for a Form object set in EtcData
  		ComEtcDataToForm(formObj, sheetObj);
  		// handling the output data format
  		setComma();
  		// Attention IBCombo initializing
  		//comboObjects[2].Code = "";
  		// Activating of button/deactivating 
  		initBtns2();
  		with(formObj) {
			//Date '-' handling
			if(ComGetObjValue(formObj.due_date) != "********") {
				ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
			}
			//ComSetObjValue(due_date, ComGetMaskedValue(due_date.value, "ymd"));
			//Create Note text, dynamic processing
			if(ComGetObjValue(dmdt_inv_sts_cd) == "C" && ComGetObjValue(cr_inv_no) != "") {
				document.getElementById('cr_nm').innerHTML="Reference No";
			}else{
				document.getElementById('cr_nm').innerHTML="Credit Note";
			}
			// 1. before the invoice issue always makes checkbox status..
		    // 2. After Invoice issue and the amount is zero, no check, 
		    //     (Invoice tax_rto, Office tax_rto)is different, do not select the check box, represents Invoice Tax_Rto viewed.
		    //     (Invoice tax_rto, Office tax_rto)is the same, select the check box..
		  	// Including TAX only if the amount you are checking the check box(After Invoice issue)
			if(ComGetObjValue(invoice_issue) == "2"){
				if(ComGetObjValue(tax_amt) == "0.00") {
					chk_tax.checked=false;
					ComSetObjValue(tax_rto_dis, "0");
				} else {
					//office's tax rto and the invoice is stored in the tax rto compare.
					if(ComGetObjValue(tax_rto) == ComGetObjValue(inv_tax_rto)) {
						chk_tax.checked=true;
						ComSetObjValue(tax_rto_dis, ComGetObjValue(tax_rto));
					}else{
						chk_tax.checked=false;
						ComSetObjValue(tax_rto_dis, ComGetObjValue(inv_tax_rto));
					}
				}
			} else {
				// Retrieving Before  Invoice Issue 
				chk_tax.checked=true;
				ComSetObjValue(tax_rto_dis, ComGetObjValue(tax_rto));
			}
			ComSetObjValue(vndr_seq, ComGetObjValue(trucker_cd));
			// The first item of the combo is the Default
		  	searchAttentionList();
		  	//Retrieving whether there should Sheet Set.
			//if there is no Sheet Set , when Preview / Print / Fax send / Email send button clicked,  on the Alert message show and blocking..
			doActionIBCommon(sheetObjects[5], formObj, IBSEARCH, COMMAND13);
			//search Payer's email and fax no
			//payer_cd, ofc_cd, dmdt_trf_cd
			if(ComGetObjValue(formObj.invoice_issue) == "2" && ComGetObjValue(formObj.payer_cd) != "") {
				doActionIBCommon(sheetObjects[5], formObj, IBCHK_SHEETSET, COMMAND02);
			}
			//Searching ATTENTION information
			ComSetObjValue(org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(dmdt_payr_cntc_pnt_nm));
			ComSetObjValue(org_payr_cntc_pnt_phn_no, 	ComGetObjValue(payr_cntc_pnt_phn_no));
			ComSetObjValue(org_payr_cntc_pnt_fax_no, 	ComGetObjValue(payr_cntc_pnt_fax_no));
			ComSetObjValue(org_payr_cntc_pnt_eml, 		ComGetObjValue(payr_cntc_pnt_eml));
  		} // with(formObj) - end
  	}
  	// Rate Detail Grid Processing after Retrieving
  	function t2sheet2_OnSearchEnd(sheetObj, code, ErrMsg) {
  		var formObj=document.form2;
  		var chgSheet=sheetObjects[3]; // Charge Grid
  		if(chgSheet.SearchRows()> 0) {
  			t2sheet1_OnSelectCell(chgSheet, 0, 0, 1, 0);
  		}
  		initBtns2();
  	}
  	/**
	 * Charge Sheet is changed when a called function
	 */		 
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		 if(OldRow != NewRow) {
			 var rtDtlGrp=sheetObj.GetCellValue(NewRow, "rt_dtl_grp");
	  		var rtDtlSheet=sheetObjects[4]; // Rate Detail Grid
	  		var selRow=0;
	  		with(rtDtlSheet) {
		  		for(var i=1; i <= LastRow(); i++) {
		  			if(GetCellValue(i, "rt_cur_cd") == rtDtlGrp) {
		  				SetRowHidden(i,0);
		  				if(selRow == 0) selRow=i;
		  			} else
		  				SetRowHidden(i,1);
		  		}
		  		SetSelectRow(selRow);
	  		}
		 }
	}
	 /**
     * init RD
     * index : Index of toolbar items to be disabled. 0-Save a  file, 1-Print, 2-Find, 3-Creating a table of contents, 
     * 4-Zoom-in the screen, 5-Zoom-out the screen, 12-Stop printing, 13-View in Microsoft Excel, 14-View in Hangul, 
     * 15-View in pdf, 16-View in Microsoft PowerPoint, 17-View in Microsoft Word.
     * @param rdObject
     * @return
     */
 	function initRdConfig(rdObject){
		var Rdviewer=rdObject ;
		Rdviewer.AutoAdjust=true;
		Rdviewer.HideStatusBar();
		Rdviewer.ViewShowMode(0);
		Rdviewer.SetPageLineColor(255,255,255);
		Rdviewer.DisableToolbar (0);
		Rdviewer.DisableToolbar (13);
		Rdviewer.DisableToolbar (14);
		Rdviewer.DisableToolbar (15);
		Rdviewer.DisableToolbar (16);
		Rdviewer.DisableToolbar (17);
 	}   
	//RD Open
    function rdOpen(rdObject,formObj, sheetObj){
    	var Rdviewer=rdObject ;
    	//var path = formObj.mrd.value;		//mrd_path
    	var path="";
    	var invoice_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
		if(invoice_LR == "") {
			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "L") {
			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "R") {
			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
		}
		var ma_param="jspno=4016"
			 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
			 ;
    	//Search MASTER DATA
		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		//RD calls 
		var rdParm=" /ruseurlmoniker[0] /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
					;
		Rdviewer.FileOpen(RD_path+path, rdParm);
		Rdviewer.PrintDialog();
    } 
	/**
     * rv By Invoice 
     */ 
    function rvParmByInvoice(formObj){
    	/////////////////////////////////////////////////////////////////////////////////////
		//separate Address1,Address2,Address3,Address4
		var payrAddrs=ComGetObjValue(formObj.rd_payr_addr);
		var rd_payr_addr01="";
		var rd_payr_addr02="";
		var rd_payr_addr03="";
		var rd_payr_addr04="";
        var paryInfoAddr=payrAddrs.split("\n");
        var paryInfoAddrCnt=paryInfoAddr.length;
        if ( paryInfoAddrCnt >= 1 ) {
        	rd_payr_addr01=paryInfoAddr[0];
        } else {
        	rd_payr_addr01="";
        }
        if ( paryInfoAddrCnt >= 2 ) {
        	rd_payr_addr02=paryInfoAddr[1];
        } else {
        	rd_payr_addr02="";
        }
        if ( paryInfoAddrCnt >= 3 ) {
        	rd_payr_addr03=paryInfoAddr[2];
        } else {
        	rd_payr_addr03="";
        }
        if ( paryInfoAddrCnt >= 4 ) {
        	rd_payr_addr04=paryInfoAddr[3];
        } else {
        	rd_payr_addr04="";
        }
        /////////////////////////////////////////////////////////////////////////////////////    	
    	var	rvRaram=" RD_SH_ADDR1[" + ComGetObjValue(formObj.rd_sh_addr1) +"]" +
					" RD_SH_ADDR2[" + ComGetObjValue(formObj.rd_sh_addr2) +"]" +
					" RD_SH_ADDR3[" + ComGetObjValue(formObj.rd_sh_addr3) +"]" +
					" RD_INVOICE_TITLE[" + ComGetObjValue(formObj.rd_invoice_title) +"]" +
					" RD_CANCEL_NOTE[" + ComGetObjValue(formObj.rd_cancel_note) +"]" +
					" RD_CUST_NM[" + ComGetObjValue(formObj.rd_cust_nm) +"]" +
					" RD_PAYR_ADDR01[" + rd_payr_addr01 +"]" +
					" RD_PAYR_ADDR02[" + rd_payr_addr02 +"]" +
					" RD_PAYR_ADDR03[" + rd_payr_addr03 +"]" +
					" RD_PAYR_ADDR04[" + rd_payr_addr04 +"]" +
					" RD_ATTN_NM[" + ComGetObjValue(formObj.rd_attn_nm) +"]" +
					" RD_PHN_NO[" + ComGetObjValue(formObj.rd_phn_no) +"]" +
					" RD_FAX_NO[" + ComGetObjValue(formObj.rd_fax_no) +"]" +
					" RD_DMDT_INV_NO[" + ComGetObjValue(formObj.rd_dmdt_inv_no) +"]" +
					" RD_ISSUE_DAY[" + ComGetObjValue(formObj.rd_issue_day) +"]" +
					" RD_DUE_DATE[" + ComGetObjValue(formObj.rd_due_date) +"]" +
					" RD_DUE_DAY[" + ComGetObjValue(formObj.rd_due_day) +"]" +
					" RD_NTC_KNT_CD[" + ComGetObjValue(formObj.rd_ntc_knt_cd) +"]" +
					" RD_CRE_USR_NM[" + ComGetObjValue(formObj.rd_cre_usr_nm) +"]" +
					" RD_CUST_CD[" + ComGetObjValue(formObj.rd_cust_cd) +"]" +
					" RD_INV_REF_NO[" + ComGetObjValue(formObj.rd_inv_ref_no) +"]" +
					" RD_CUST_VAT_NO[" + ComGetObjValue(formObj.rd_cust_vat_no) +"]" +
					" RD_SH_HD_N1ST_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n1st_msg) +"]" +
					" RD_SH_HD_N2ND_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n2nd_msg) +"]" +
					" RD_SH_HD_N3RD_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n3rd_msg) +"]" +
					" RD_SH_HD_N4TH_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n4th_msg) +"]" +
					" RD_SH_HD_N5TH_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n5th_msg) +"]" +
					" RD_VVD_CD[" + ComGetObjValue(formObj.rd_vvd_cd) +"]" +
					" RD_VSL_ENG_NM[" + ComGetObjValue(formObj.rd_vsl_eng_nm) +"]" +
					" RD_ARR[" + ComGetObjValue(formObj.rd_arr) +"]" +
					" RD_DEP[" + ComGetObjValue(formObj.rd_dep) +"]" +
					" RD_BL_NO[" + ComGetObjValue(formObj.rd_bl_no) +"]" +
					" RD_BKG_NO[" + ComGetObjValue(formObj.rd_bkg_no) +"]" +
					" RD_CMDT_NM[" + ComGetObjValue(formObj.rd_cmdt_nm) +"]" +
					" RD_DMDT_TRF_CD[" + ComGetObjValue(formObj.rd_dmdt_trf_cd) +"]" +
					" RD_DMDT_TRF_NM[" + ComGetObjValue(formObj.rd_dmdt_trf_nm) +"]" +
					" RD_BKG_RCV_TERM_NM[" + ComGetObjValue(formObj.rd_bkg_rcv_term_nm) +"]" +
					" RD_BKG_DEL_TERM_NM[" + ComGetObjValue(formObj.rd_bkg_del_term_nm) +"]" +
					" RD_POD[" + ComGetObjValue(formObj.rd_pod) +"]" +
					" RD_POD_NM[" + ComGetObjValue(formObj.rd_pod_nm) +"]" +
					" RD_DEL[" + ComGetObjValue(formObj.rd_del) +"]" +
					" RD_DEL_NM[" + ComGetObjValue(formObj.rd_del_nm) +"]" +
					" RD_TRUCKER_NM[" + ComGetObjValue(formObj.rd_trucker_nm) +"]" +
					" RD_ORG_CHG_AMT[" + ComGetObjValue(formObj.rd_org_chg_amt) +"]" +
					" RD_ORG_CURR_CD[" + ComGetObjValue(formObj.rd_org_curr_cd) +"]" +
					" RD_INV_XCH_RT[" + ComGetObjValue(formObj.rd_inv_xch_rt) +"]" +
					" RD_TOT_AMT[" + ComGetObjValue(formObj.rd_tot_amt) +"]" +
					" RD_INV_CURR_CD[" + ComGetObjValue(formObj.rd_inv_curr_cd) +"]" +
					" RD_DC_AMT[" + ComGetObjValue(formObj.rd_dc_amt) +"]" +
					" RD_INV_CHG_AMT[" + ComGetObjValue(formObj.rd_inv_chg_amt) +"]" +
					" RD_TAX_RTO[" + ComGetObjValue(formObj.rd_tax_rto) +"]" +
					" RD_TAX_AMT[" + ComGetObjValue(formObj.rd_tax_amt) +"]" +
					" RD_INV_AMT[" + ComGetObjValue(formObj.rd_inv_amt) +"]" +
					" RD_INV_RMK1[" + ComGetObjValue(formObj.rd_inv_rmk1) +"]" +
					" RD_INV_RMK2[" + ComGetObjValue(formObj.rd_inv_rmk2) +"]" +
					" RD_SH_RMK1[" + ComGetObjValue(formObj.rd_sh_rmk1) +"]" +
					" RD_SH_RMK2[" + ComGetObjValue(formObj.rd_sh_rmk2) +"]" +
					" RD_SH_RMK3[" + ComGetObjValue(formObj.rd_sh_rmk3) +"]" +
					" RD_SH_RMK4[" + ComGetObjValue(formObj.rd_sh_rmk4) +"]" +
					" RD_SH_RMK5[" + ComGetObjValue(formObj.rd_sh_rmk5) +"]" +
					" RD_SH_RMK6[" + ComGetObjValue(formObj.rd_sh_rmk6) +"]" +
					" RD_SH_RMK7[" + ComGetObjValue(formObj.rd_sh_rmk7) +"]" +
					" RD_SH_RMK8[" + ComGetObjValue(formObj.rd_sh_rmk8) +"]" +
					" RD_SH_RMK9[" + ComGetObjValue(formObj.rd_sh_rmk9) +"]" +
					" RD_SH_RMK10[" + ComGetObjValue(formObj.rd_sh_rmk10) +"]" +
					" RD_SH_RMK11[" + ComGetObjValue(formObj.rd_sh_rmk11) +"]" +
					" RD_SH_RMK12[" + ComGetObjValue(formObj.rd_sh_rmk12) +"]" +
					" RD_SH_RMK13[" + ComGetObjValue(formObj.rd_sh_rmk13) +"]" +
					" RD_SH_RMK14[" + ComGetObjValue(formObj.rd_sh_rmk14) +"]" +
					" RD_TAX_AMT_PRN_FLG[" + ComGetObjValue(formObj.rd_tax_amt_prn_flg) +"]" +
					" RD_PHN_FAX_PRN_FLG[" + ComGetObjValue(formObj.rd_phn_fax_prn_flg) +"]" +
					" RD_CUST_VAT_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_vat_prn_flg) +"]" +
					" RD_DC_AMT_FLG[" + ComGetObjValue(formObj.rd_dc_amt_flg) +"]" +
					" RD_CUST_REF_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_ref_prn_flg) +"]" +
					" RD_DAYS_DISP[" + ComGetObjValue(formObj.rd_days_disp) +"]" +
					" RD_DMDT_INV_STS_CD[" + ComGetObjValue(formObj.rd_dmdt_inv_sts_cd) +"]" +
					" RD_CRE_CNT_CD[" + ComGetObjValue(formObj.rd_cre_cnt_cd) +"]" 
					;
    	return rvRaram;
    }
  	/*
  	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
  	 */
    function getCustCd(aryPopupData) {
  		document.form.cust_cd.value=aryPopupData[0][3];
    }    
    /*
  	 * Service Provider Inquiry Common pop-up calls
  	 */
    function getSvcProvdr(aryPopupData) {
  		document.form.svc_provdr.value=aryPopupData[0][2];
    }
    /*
  	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
  	 */
    function getPayerCd(aryPopupData) {
    	document.form2.payer_cd.value=aryPopupData[0][3];
    	document.form2.payer_nm.value=aryPopupData[0][4];
    	searchAttentionList();
    }    
    /*
  	 * Trucker Cd Inquiry Common pop-up calls
  	 */
    function getTruckerCd(aryPopupData) {
  		var formObj=document.form2;
  		formObj.trucker_cd.value=aryPopupData[0][2];
  		formObj.trucker_nm.value=aryPopupData[0][4];
    	ComSetObjValue(formObj.vndr_seq, aryPopupData[0][2]);
    }
    /*
     * Multi-input pop-up page is closed, then the function is invoked Opener
     * - Set in a field allows multiple inputs.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj=eval("document.form." + return_val);
    	var retStr=rArray.toString().toUpperCase();
    	ComSetObjValue(targObj, retStr);
    }
   	/*
  	 * Each common pop-up function calls 
  	 */
  	function doProcessPopup(srcName, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var formObj2=document.form2;
  		var sUrl='';
  		var paramVal='';
  		var sWidth='';
  		var sHeight='';
  		var sScroll='no';
  		with(sheetObj) {
	  		switch(srcName) {
		        case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					return;
					break;
				case 'svc_provdr':		// Service Provider Popup
					ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);
					return;
					break;
	  			case 'payer_cd':		// Customer Inquiry Popup
//		  			if(ComGetObjValue(formObj2.payer_cd) == "") {
//		  			    ComShowCodeMessage("DMT00182");
//		  			    return;
//		  			}
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
					return;
	  				break;
	  			case 'trucker_cd':		// Service Provider Popup
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getTruckerCd", "1,0,1,1,1,1,0", true);
	  				return;
					break;
	  			case 'm_bkg_no':	// BKG No. Multi-Input pop-up calls
	  			case 'm_bl_no':		// B/L No. Multi-Input pop-up calls
	  			case 'm_cntr_no':	// CNTR No. Multi-Input pop-up calls
		  			var flag=ComReplaceStr(srcName,"m_","");
			  		// Specify the details of multi-input pop-up title
	  				var returntitle='';
	  				if(flag == 'bkg_no')
	  					returntitle='BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle='B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle='CNTR No.';
	  				var param="?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				return;
	  				break;
//	  			case 'btn_ROInfo':
//	  				var selRow	= SelectRow;
//		  			var bkgNo	= CellValue(selRow , "bkg_no");
//		  			paramVal	= "?bkg_no=" + bkgNo;
//		  			
//	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
//	  				sWidth	= '1000';
//              		sHeight	= '450';
//	  				break;
	  			case 'btn_MVMTInq':
	  				var selRow=GetSelectRow();
					var cntrNo=GetCellValue(selRow , "cntr_no");
					var cntrTpszCd=GetCellValue(selRow , "cntr_tpsz_cd");
	  				paramVal="?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10)
	  							+ "&check_digit=" + cntrNo.substring(10,11)
	  							+ "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl='EES_CTM_0408_POP.do' + paramVal;
					sWidth='1020';
					sHeight='690';
	  				break;
	  			case 'btn_ExptInq':
	  				var selRow=GetSelectRow();
					var scNo=GetCellValue(selRow , "sc_no");
					var rfaNo=GetCellValue(selRow , "rfa_no");
	  				if(scNo != '' && rfaNo != '') scNo='';
	  				paramVal="?caller=4016&sc_no=" + scNo
	  							+ "&rfa_no=" + rfaNo
	  							+ "&trf_cd=" + comboObjects[0].GetSelectCode()
	  							;
	  				sUrl='EES_DMT_2007_1.do' + paramVal;
	  				sWidth='1024';
              		sHeight='780';
              		sScroll='yes';
	  				break;
	  			case "btn_SheetSet":
	  				paramVal="?issoff=" + ComGetObjValue(formObj2.session_ofc_cd)
  								+ "&tftp2=" + ComGetObjValue(formObj2.dmdt_trf_cd)
  								+ "&sheetp=I"
  								+ "&invoice_issue=" + ComGetObjValue(formObj2.invoice_issue)
  								+ "&jspno=EES_DMT_4016-1";
	  				sUrl='EES_DMT_4101.do' + paramVal;
              		sWidth='725';
              		sHeight='780';
              		ComOpenWindowCenter(sUrl, 'EES_DMT_4101', sWidth, sHeight, true, 'yes');
              		//Sheet Set whether or not to re-Retrieving.
    				doActionIBCommon(sheetObjects[5], formObj2, IBSEARCH, COMMAND13);
    				return;
	  				break;
 				case "btn_SheetOpt":
 					paramVal="?issoff=" + ComGetObjValue(formObj2.session_ofc_cd)
								+ "&tftp=" + ComGetObjValue(formObj2.dmdt_trf_cd)
								+ "&invoice_issue=" + ComGetObjValue(formObj2.invoice_issue)
								+ "&jspno=EES_DMT_4016-1";
 					sUrl='EES_DMT_4103.do' + paramVal;
              		sWidth='625';
              		sHeight='650';
	  				break;
 				case "btn_SendingHistory":
 					paramVal="?jspno=EES_DMT_4016-1"
								+ "&invoice=" + ComGetObjValue(formObj2.dmdt_inv_no)
								+ "&selectOpt=1";
 					sUrl='EES_DMT_7006_P.do' + paramVal;
              		sWidth='1020';
              		sHeight='690';
              		break;
 				case "btn_Cancel":
 					var creOfcCd=ComGetObjValue(formObj2.cre_ofc_cd);
 					if(ComGetObjValue(formObj2.session_ofc_cd) == creOfcCd) {
 						if(ComShowCodeConfirm('DMT03025')) {
 							var sUrl="EES_DMT_4106.do"
	 								+ "?dmdt_inv_no=" + ComGetObjValue(formObj2.dmdt_inv_no)
	 								+ "&cre_ofc_cd=" + creOfcCd
	 								+ "&dmdt_trf_cd=" + ComGetObjValue(formObj2.dmdt_trf_cd);
 							var returnValue=ComOpenWindowCenter(sUrl, "EES_DMT_4106", "420", "450", true);
 							if(returnValue == "Y"){
 								doActionIBSheet(sheetObjects[3], formObj2, IBSEARCH_MBILL);
 							}
 						}
 					}else{
 						ComShowCodeMessage('DMT03024', creOfcCd, ComGetObjValue(formObj2.session_ofc_cd));
 					}
 					return;
 					break;
 				case "btn_Preview":
 					var temp_LR=ComGetObjValue(formObj2.bil_to_loc_div_cd);
 					var invoice_LR="";
 					if(temp_LR == "") {
 						invoice_LR="L";
 					}else if(temp_LR == "L") {
 						invoice_LR="L";
 					}else if(temp_LR == "R") {
 						invoice_LR="R";
 					}
					paramVal="?jspno=4016"
								+"&payr_cntc_pnt_phn_no="	+ ComGetObjValue(formObj2.org_payr_cntc_pnt_phn_no)
								+"&payr_cntc_pnt_fax_no="	+ ComGetObjValue(formObj2.org_payr_cntc_pnt_fax_no)
								+"&payr_cntc_pnt_eml="		+ ComGetObjValue(formObj2.org_payr_cntc_pnt_eml)
								//+"&dmdt_payr_cntc_pnt_nm="	+ ComGetObjValue(formObj2.org_dmdt_payr_cntc_pnt_nm)
								+"&invoice_no="	+ ComGetObjValue(formObj2.dmdt_inv_no)
								+"&invoice_LR="	+ invoice_LR
								+"&cre_ofc_cd="	+ ComGetObjValue(formObj2.cre_ofc_cd)
								+"&payer_cd="	+ ComGetObjValue(formObj2.payer_cd)
								+"&bkg_no="		+ ComGetObjValue(formObj2.s_bkg_no)
								+"&pod_cd="		+ ComGetObjValue(formObj2.pod_cd)
								+"&bl_no="		+ ComGetObjValue(formObj2.bl_no)
								+"&dmdt_trf_cd="+ ComGetObjValue(formObj2.dmdt_trf_cd)
								;
					sUrl='EES_DMT_4003.do' + paramVal;
              		sWidth='950';
              		sHeight='735';
              		break;
 				case "btn_PayerInfo":
 					if(ComGetObjValue(formObj2.payer_cd) == null || ComGetObjValue(formObj2.payer_cd) == "") {
 						ComShowCodeMessage("DMT00182");
 						return;
 					}
 					var ofcCd='';
 					if(ComGetObjValue(formObj2.invoice_issue) == "1")
 						ofcCd=ComGetObjValue(formObj2.session_ofc_cd);
 					else	//ComGetObjValue(formObj.invoice_issue) == "2"
 						ofcCd=ComGetObjValue(formObj2.cre_ofc_cd);
 					paramVal="?s_ofc_cd="	+ ofcCd
		 						+ "&s_cust_cd="	+ ComGetObjValue(formObj2.payer_cd)
		 						+ "&s_bkg_no="	+ ComGetObjValue(formObj2.s_bkg_no)
		 						+ "&s_pod_cd="	+ ComGetObjValue(formObj2.pod_cd)
		 						+ "&jspno=EES_DMT_4016-1"
		 						+ "&attn="		+ ComGetObjValue(formObj2.dmdt_payr_cntc_pnt_nm)
		 						+ "&telno="		+ ComGetObjValue(formObj2.payr_cntc_pnt_phn_no)
		 						+ "&faxno="		+ ComGetObjValue(formObj2.payr_cntc_pnt_fax_no)
		 						+ "&email="		+ ComGetObjValue(formObj2.payr_cntc_pnt_eml)
		 						;
 					sUrl='EES_DMT_4104.do' + paramVal;
              		sWidth='825';
              		sHeight='600';
 					break;
 				case "btn_FaxSend":
					if(ComGetObjValue(formObj2.payer_cd) == null || ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd="";
					if(ComGetObjValue(formObj2.invoice_issue) == "1") {
						return;
					}else{	//ComGetObjValue(formObj2.invoice_issue) == "2"
						ofc_cd=ComGetObjValue(formObj2.cre_ofc_cd);
					}
					sUrl="EES_DMT_4107.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj2.payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj2.s_bkg_no)
						+"&s_pod_cd="+ComGetObjValue(formObj2.pod_cd)
						+"&jspno=4016"
						+"&telno="+ComGetObjValue(formObj2.payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj2.payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj2.payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj2.cust_cntc_pnt_seq)
						;
					sWidth="500";
		  			sHeight="300";					
					break;
 				case "btn_EmailSend":
					if(ComGetObjValue(formObj2.payer_cd) == null || ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd="";
					if(ComGetObjValue(formObj2.invoice_issue) == "1") {
						return;
					}else{	//ComGetObjValue(formObj2.invoice_issue) == "2"
						ofc_cd=ComGetObjValue(formObj2.cre_ofc_cd);
					}
					sUrl="EES_DMT_4108.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj2.payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj2.s_bkg_no)
						+"&s_pod_cd="+ComGetObjValue(formObj2.pod_cd)
						+"&jspno=4016"
						+"&telno="+ComGetObjValue(formObj2.payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj2.payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj2.payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj2.cust_cntc_pnt_seq)
						;
					sWidth="500";
		  			sHeight="300";					
					break;					
	  		} // switch-end
  		} // with-end
  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
			var returnValue=ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, sScroll);
  		}
  	}
  	/**
 	 * SheetOption pop-up screen automatically changes the processing logic in the change(Due Date, Credit Term, Tax Rate)
 	 */
 	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
 		var formObj=document.form2;
 		var d_is_dt_prn_flg="";
		if(cr_term_dys == "0" && is_dt_prn_flg == "2") {
			d_is_dt_prn_flg="N";
		} else{
			d_is_dt_prn_flg="Y";
		}
 		if(cr_term_dys != null && cr_term_dys != ""){
 			//Before Invoice Issue
 			if(ComGetObjValue(formObj.invoice_issue) == "1") {
 				if(cr_term_dys == "0") {
 					if(is_dt_prn_flg == "Y"){
 						//Current date
 						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
 						//Date '-' handling
 						ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
 						//0
 						ComSetObjValue(formObj.cr_term_dys, "0");
 					}else if(is_dt_prn_flg == "N") {
 						ComSetObjValue(formObj.due_date, "********");
 						ComSetObjValue(formObj.cr_term_dys, "");
 					}
 				}else if(parseInt(cr_term_dys) > 0){
 					//Current date
 					ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
 					//Date '-' handling
 					ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
 					ComSetObjValue(formObj.cr_term_dys, cr_term_dys);
 				}
 			//After Invoice Issue
 			}else if(ComGetObjValue(formObj.invoice_issue) == "2") {
 				if(cr_term_dys == "0") {
 					if(is_dt_prn_flg == "Y"){
 						//Invoice issue date
 						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.cre_dt));
 						//0
 						ComSetObjValue(formObj.cr_term_dys, "0");
 					}else if(is_dt_prn_flg == "N") {
 						ComSetObjValue(formObj.due_date, "********");
 						ComSetObjValue(formObj.cr_term_dys, "");
 					}
 				}else{
 					//Invoice issue date + cr_term_dys
 					var cal_due_date=ComGetDateAdd(ComGetObjValue(formObj.cre_dt), "D", parseInt(cr_term_dys)); 
 					ComSetObjValue(formObj.due_date, cal_due_date);
 					ComSetObjValue(formObj.cr_term_dys, cr_term_dys);
 				}
 			}
 		}
 		if(tax_rto == null || tax_rto == "") {
 			tax_rto="0";
 		}
 		//tax_rto
 		ComSetObjValue(formObj.tax_rto, tax_rto);
 		if(formObj.chk_tax.checked) {
 			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
 			//tax calculate
 			getExRate();
 			setComma();
 		}
 		//searchSeetOption
 		doActionIBCommon(sheetObjects[5], formObj, IBSEARCH, COMMAND14);
 	}
	/**
 	 * PayerInfo pop-up screen, the changes are processed automatically change
 	 */
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
 		var formObj=document.form2;
 		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
 		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
 		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
 		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
 		//alert('getPayerInfoData');
 		searchAttentionList();
 		var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
 		//setting
 		if(ComGetObjValue(formObj.payer_cd) == "") {
 			comboObjects[2].SetSelectCode(-1);
 			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
 			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
 			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
 			ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
 		}else{
 			//Attention Setting
 			comboObjects[2].SetSelectCode(setCode);
 			if(comboObjects[2].GetSelectCode()== ""){
 				ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
 				ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
 				ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
 				ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
 			}
 		}
 	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
        	 switch(sAction) {
        	 	case IBSEARCH:     // Search
	        	 	ComSetObjValue(fm_mvmt_yd_cd, '');
	         		ComSetObjValue(to_mvmt_yd_cd, '');
	         		var condType=ComGetObjValue(cond_type);
	         		//******************** Date conditions  ************************
	         		if(condType == 'date') {
	         			if(!ComIsDate(fm_mvmt_dt1)) {
	         				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
	         				return false;
	         			}
	         			if(!ComIsDate(to_mvmt_dt1)) {
	         				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
	         				return false;
	         			}
	         			var startDt=ComGetUnMaskedValue(fm_mvmt_dt1, 'ymd');
	         			var endDt=ComGetUnMaskedValue(to_mvmt_dt1, 'ymd');
                        // Check period
                        if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        // Check within one month period is
                        var limitDt=ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
	                    ComSetObjValue(fm_mvmt_dt, startDt);
	                    ComSetObjValue(to_mvmt_dt, endDt);
	                    var yardCd=ComGetObjValue(yd_cd);
	                    // Check YardCode input
	                    if((yardCd != '' && yardCd.length < 5) || (yardCd.length == 5 && ComGetObjValue(chk_yd_cd) == "N")) {
	                    	ComShowCodeMessage('DMT00110', 'Yard');
	                    	ComClearObject(yd_cd);
	    					return false;
	    	       		} else if(yardCd.length == 5) {
	    	       			var yardFmto=ComGetObjValue(yard_fmto);
	         				if(yardFmto == 'yard_fm') {
	         					ComSetObjValue(fm_mvmt_yd_cd, yardCd);
	         					ComSetObjValue(to_mvmt_yd_cd, '');
	         				} else {
	         					ComSetObjValue(fm_mvmt_yd_cd, '');
	         					ComSetObjValue(to_mvmt_yd_cd, yardCd);
	         				}
	    	       		}
	         			var yardCd2=ComGetObjValue(comboObjects[1]);
	         			// Check YardCode selected
	         			if(yardCd2 != '') {
	         				var yardFmto=ComGetObjValue(yard_fmto);
	         				if(yardFmto == 'yard_fm') {
	         					ComSetObjValue(fm_mvmt_yd_cd, yardCd2);
	         					ComSetObjValue(to_mvmt_yd_cd, '');
	         				} else {
	         					ComSetObjValue(fm_mvmt_yd_cd, '');
	         					ComSetObjValue(to_mvmt_yd_cd, yardCd2);
	         				}
	         			}
	         		//******************** VVD CD conditions  ************************
	         		} else if(condType == 'vvd_cd') {
	         			if( ComChkLen('vvd_cd', 9) != 2) {	// Nine digits, or
	         				//ComShowCodeMessage('DMT00102', "VVD CD");
	         				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
	     					return false;
	         			}
	         			ComSetObjValue(pod_cd, "");
	         			ComSetObjValue(pol_cd, "");
	         			var tmnlCd=ComGetObjValue(tmnl_cd);
	         			if(tmnlCd != '') {
	         				if( tmnlCd.length < 5 || tmnlCd.length == 5 && ComGetObjValue(chk_loc_cd) == "N" ) {	
	         					//ComAlertFocus(tmnl_cd, ComGetMsg('DMT00110', 'Location'));
	         					ComShowCodeMessage('DMT00110', 'Location');
	         					ComClearObject(tmnl_cd);
	        	       			return false;
	         				}
	         				var trf_cd=comboObjects[1].GetSelectCode();
	         				if(trf_cd.indexOf('I') != -1)	// Inbound
	         					ComSetObjValue(pod_cd, tmnlCd);
	         				if(trf_cd.indexOf('O') != -1)	// Outbound
	         					ComSetObjValue(pol_cd, tmnlCd);
	         			}
	         		//******************** CNTR conditions  ************************	
	         		} else {
	     				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
	         				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
	             			return false;
	     				}
	         			var bkgNo=ComGetObjValue(bkg_no);
	         			if(bkgNo != '') {
	         				var arrBkgNo=bkgNo.split(',');
	         				for(var i=0; i<arrBkgNo.length; i++) {
	         					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
	         						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
		                 			return false;
	         					}
	         				}
	         			}
	         			var blNo=ComGetObjValue(bl_no);
	         			if(blNo != '') {
	         				var arrBlNo=blNo.split(',');
	         				for(var i=0; i<arrBlNo.length; i++) {
	         					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
	         						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
		                 			return false;
	         					}
	         				}
	         			}
	         			var cntrNo=ComGetObjValue(cntr_no);
	         			if(cntrNo != '') {
	         				var arrCntrNo=cntrNo.split(',');
	         				for(var i=0; i<arrCntrNo.length; i++) {
	         					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// Exceed the length
	         						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
		                 			return false;
	         					}
	         				}
	         			}
	         		}
	         		if(svc_provdr.value != '') {
	         			if(!ComIsNumber(svc_provdr)) {
	         				ComAlertFocus(svc_provdr, ComGetMsg('COM12122', 'Service Provider'));
	         				return false;
	         			}
	         			if(ComChkLen(svc_provdr, 6) != 2) {
	     					ComAlertFocus(svc_provdr, ComGetMsg('DMT00120', 'Service Provider', '6'));
	     					return false;
	     				}
	         		}
	         		// Selected value in Tariff Type IBMultiCombo, Hidden variables set to
	         		ComSetObjValue(dmdt_trf_cd, comboObjects[0].GetSelectCode());
	         		break;
        	 	case IBGETTOMVMT:
        	 		if(sheetObj.CheckedRows("chk") == 0) {
        	  			ComShowCodeMessage('COM12113', 'CNTR');
        	  			return false;
        			}
        	 		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow=chkRows[i];
             			if(sheetObj.GetCellValue(chkRow, "get_flg") == 'Y') {
             				if(ComShowCodeConfirm('DMT03051')) 
             					break;
             				else
             					return false;
             			}
             		}
        	 		// Hidden Sheet
        	 		var sheetObj2=sheetObjects[1];
        	 		//Sheet1 checked the "chk" Creating a retrieving data as XML
        	 		var sXml=ComMakeSearchXml(sheetObj, false, "chk", "seq|cntr_no|bkg_no");
        	 		sheetObj2.RemoveAll();
        	 		//Retrieving XML to load into sheet2
        	 		sheetObj2.LoadSearchData(sXml,{Append:1 , Sync:1} );
	    	 		break;
        	 	case IBCALCULATE:
        	 		if(sheetObj.CheckedRows("chk") == 0) {
        	  			ComShowCodeMessage('COM12113', 'CNTR');
        	  			return false;
        			}
        	 		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow=chkRows[i];
             			if(sheetObj.GetCellValue(chkRow, "get_flg") == '') {
             				ComShowCodeMessage('DMT03053');
         					sheetObj.SetSelectRow(chkRow);
         					return false;
             			}
             			if(sheetObj.GetCellValue(chkRow, "dmdt_trf_cd") == '') {
             				ComShowCodeMessage('DMT03028', 'To MVMT');
         					sheetObj.SetSelectRow(chkRow);
         					return false;
             			}
             			/*
						var toMvmtYdCd=sheetObj.GetCellValue(chkRow, "to_mvmt_yd_cd");
						var toMvmtStsCd=sheetObj.GetCellValue(chkRow, "to_mvmt_sts_cd");
						var toMvmtDt=sheetObj.GetCellValue(chkRow, "to_mvmt_dt");
             			*/
             			if(sheetObj.GetCellValue(chkRow, "dmdt_chg_sts_cd") == 'I') {
             				ComShowCodeMessage('DMT01068', 'calculate');
         					sheetObj.SetSelectRow(chkRow);
         					return false;
             			}
             		}
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow=chkRows[i];
             			if(sheetObj.GetCellValue(chkRow, "cal_flg") == 'Y') {
             				if(ComShowCodeConfirm('DMT03052')) 
             					break;
             				else
             					return false;
             			}
             		}
        	 		// Hidden Sheet
        	 		var sheetObj2=sheetObjects[2];
        	 		//Sheet1 checked the "chk" Creating a retrieving data as XML
        	 		var sXml=ComMakeSearchXml(sheetObj, false, "chk", "seq|svr_id|cntr_no|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|cntr_tpsz_cd|bkg_no|vvd_cd|to_mvmt_dt|to_mvmt_sts_cd|to_mvmt_yd_cd|to_mvmt_yr|to_mvmt_seq|to_mvmt_split_no|dmdt_chg_sts_cd|fm_mvmt_dt");
        	 		sheetObj2.RemoveAll();
        	 		//Retrieving XML to load into sheet2
        	 		sheetObj2.LoadSearchData(sXml,{Append:1 , Sync:1} );
        	 		break;
        	 	case IBCONFIRM:		// Confirm
	         		if(sheetObj.CheckedRows("chk") == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR for Confirm');
	         			return false;
	         		}
	         		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
	         		for(var i=0; i < chkRows.length-1; i++) {
	         			var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
	     				if(chgStsCd != 'F') {
	     					ComShowCodeMessage('DMT03018');
	     					sheetObj.SetSelectRow(chkRows[i]);
	     					return false;
	     				}
	         		}
	         		break;	
        	 	case IBSAVE:
        	 		if(ComGetObjValue(payer_cd) == "") {
    					ComAlertFocus(payer_cd, ComGetMsg("DMT01052"));
						return false;
    				}
    				//The INVOICE AR-interface has been completed, it can not be modified, and  the message should show.
    				if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "Y") {
    					ComShowCodeMessage("DMT03022");
    					return false;
    				}
        	 		break;
        	 	case IBARIF:
        	 		var sessionCntCd=ComGetObjValue(session_cnt_cd);
        	 		if( sessionCntCd != "US" && sessionCntCd != "CA" ) {
        	 			if(ComGetObjValue(payer_cd).length <= 6) {
        	 				ComShowCodeMessage("DMT00185");
        	 				return false;
        	 			}
	 		        }
        	 		if(!ComShowCodeConfirm('DMT03026'))
        	 			return false;
        	 		break;
        	 } // swith - end
    	  } // with - end
    	  return true;
     }
 	 /**
      * Initialization Tab
      * Setting Tab's entry.
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt=0 ;
					InsertItem( "DEM Cal." , "");
					InsertItem( "Manual Billing" , "");
                 }
                 break;
         }
     }
 	 /**
      * Click on Tab event-related
      * Elements selected tab is active.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
         objs[nItem].style.display="Inline";
         objs[beforetab].style.display="none";
         objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
         beforetab=nItem;
     }
   /**
  	* function to calculate the Billable AMT
  	*/	 
  	function calcBillableAmount() {
  		var formObj=document.form2;
  		var sheetCHGObj=sheetObjects[3];
  		var sheetRTObj=sheetObjects[4];
  		var billableAmt=0;
  		with(sheetCHGObj) {
  			for (var row=HeaderRows(); row <= LastRow(); row++) {
  				var dtlSeq=GetCellValue(row, "rt_dtl_grp");
  				for (var subRow=sheetRTObj.HeaderRows(); subRow <= sheetRTObj.LastRow(); subRow++) {
  					if (dtlSeq 	== sheetRTObj.GetCellValue(subRow, "rt_cur_cd")) {
  						billableAmt += parseFloat(sheetRTObj.GetCellValue(subRow, "rt_chrg"));
  					}
  				}
  			}
  		}
  		billableAmt=billableAmt + "";
  		ComSetObjValue(formObj.mn_bil_amt, setDataFormat(billableAmt, "AMT"));
  	}      
    /**
     * If a change occurs in Charge Currency, will perform the function that defines the behavior of 
     */
   function setDataFormat(sVal, sType) {
	   if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
	   if (sType != undefined) {
		   switch(sType) {
		   		case "AMT":
		   			sVal=ComAddComma2(sVal + "", "#,###.00");
		   			break;
		   		case "EX_RATE":
		   			sVal=parseFloat(sVal).toFixed(6);
		   			break;
   			}
   		}
	   	return sVal;
   }