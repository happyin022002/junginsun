/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4002.js
*@FileTitle  : Invoice Creation & Issue - Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_4002 :  business script for EES_DMT_4002
     */
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// RD
//	var rdObjects=new Array();
//	rdObjects[0] = document.getElementById("invPreview"); 
//	var rdCnt=0;
	var queryStr="";
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBARIF=52;	
	var IBFAXSEND=53;
	var IBEMAILSEND=54;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	/***** case in Sheet count are more two by Tab, defining adding sheet *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var srcObj=window.ComGetEvent();
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		
    		if (ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_payer_cd":
	            	openPopup('payer_cd');
 				break;
 				
	            case "btn_trucker_cd":
	            	openPopup('trucker_cd');
	            break;
	            
            	case "btn_set":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
				break;
				
            	case "btn_option":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
            	break;
            	
            	case "btn_sendinghistory":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
            	break;
				
            	case "btn_cremark":
					if(ComIsBtnEnable(srcName)) {
						remark_alert(srcName);
					}
				break;					
				
//				case "btn_hremark":
//					if(ComIsBtnEnable(srcName)) {
//						remark_alert(srcName);
//					}
//				break; 
				
				case "btn_save":
					if(ComIsBtnEnable(srcName)) {
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Save");
		        			return;
		        		}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
				break;
				
				case "btn_cancel":
					if(ComIsBtnEnable(srcName)) {
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Cancel");
		        			return;
		        		}
						openPopupWindow(sheetObject1, formObject, srcName);
					}
				break;
				
				case "btn_preview":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						openPopupWindow(sheetObject1, formObject, srcName);
					}
				break;
				
				case "btn_print":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						initRdConfig();
						rdOpen(formObject, sheetObject2);
					}
				break;
				
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
	                    doActionIBSheet(sheetObject2, formObject, IBFAXSEND);	
						openPopupWindow(sheetObject1, formObject, srcName);
					}
				break;
				
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						doActionIBSheet(sheetObject2,formObject,IBEMAILSEND);
						openPopupWindow(sheetObject1, formObject, srcName);
					}
				break;																														
				
				case "btn_payerfaxemail":
					//if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObject, srcName);
					//}
				break; 
				
				case "btn_arif":
					if(ComIsBtnEnable(srcName)) {
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "A/R I/F");
		        			return;
		        		}
						doActionIBSheet(sheetObject1,formObject,IBARIF);
					}
				break;
				
				case "btn_close":
					ComPopUpReturnValue("Y");
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
                ComOpenWait(false);
    		} else {
    			ComShowMessage(e.message);
                ComOpenWait(false);
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
	/** 
	 * IBCombo Object set to an array
	 * param : combo_obj 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for (i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	 	// IBMultiCombo initializing 
	    for (var k=0;k<comboObjects.length;k++) {
	        initCombo(comboObjects[k],k+1);
	    }
		initAxonControl();
		var formObj=document.form;
		//CNT 코드 가져오기
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND17,"USR_CNT_CD","");	//2010.04.04.
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		setTaxRto();
		searchAttentionList();
		
		var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
		if(ComGetObjValue(formObj.payer_cd) == "") {
			comboObjects[0].SetSelectIndex(-1);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
		}
		else {
			//Attention Setting
			comboObjects[0].SetSelectCode(setCode);
			if (comboObjects[0].GetSelectCode() == "") {
				comboObjects[0].SetSelectIndex(0);
			}
		}
		
	    if (ComGetObjValue(formObj.invoice_issue) == "1") {
	    	document.getElementById('inv_cur').innerHTML 
	    	="<select name='inv_curr_cd' style='width:80;' class='input1' onchange='getExRate()'>&nbsp;</select>";
	    	searchARCurrencyList();
	    }
		
    	//RD
    	//initRdConfig(rdObjects[0]);
		//Retrieves the current date by office
		ComSetObjValue(document.form.ofc_cd, ComGetObjValue(document.form.session_ofc_cd));
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,SEARCHLIST06,"OFC_CURR_DAY","");
		//Retrieving whether there should Sheet Set.
		//if there is no Sheet Set , when Preview / Print / Fax send / Email send button clicked,  on the Alert message show and blocking..
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND13,"RESULT","");		
		//search Payer's email and fax no
		//payer_cd, ofc_cd, dmdt_trf_cd
		if(ComGetObjValue(formObj.invoice_issue) == "2") {
			if(ComGetObjValue(formObj.payer_cd) != "") {
				doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
			}
		}
		//Searching ATTENTION information
		ComSetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm));
		ComSetObjValue(formObj.org_payr_cntc_pnt_phn_no, 	ComGetObjValue(formObj.payr_cntc_pnt_phn_no));
		ComSetObjValue(formObj.org_payr_cntc_pnt_fax_no, 	ComGetObjValue(formObj.payr_cntc_pnt_fax_no));
		ComSetObjValue(formObj.org_payr_cntc_pnt_eml, 		ComGetObjValue(formObj.payr_cntc_pnt_eml));

		//CNT cd
//		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND17,"USR_CNT_CD","");
		
		//=========================================
		//2015.10.27 #7995 comment start
		//2017.01.12 #23259 India Invocie
		if(ComGetObjValue(formObj.invoice_issue) == "1" && ComGetObjValue(formObj.usr_cnt_cd) != "IN"){
//		if(ComGetObjValue(formObj.invoice_issue) == "1"){
		//2015.10.27 #7995 comment e n d
		//=========================================
			ComSetObjValue(formObj.ida_expn_tax_rt, "");
			ComSetObjValue(formObj.ida_expn_tax, "");
			ComSetObjValue(formObj.ida_edu_tax_rt, "");
			ComSetObjValue(formObj.ida_edu_tax, "");
			ComSetObjValue(formObj.ida_high_edu_tax_rt, "");
			ComSetObjValue(formObj.ida_high_edu_tax, "");
		}
		//REP CUST SEQ 코드 가져오기
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND23,"REP_CUST_SEQ","");	//2010.04.04.
    }
    /**
     * Search Attention Combo by Payer Code
     * @return
     */
    function setPayerCd() {
    	var formObj=document.form;
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
  	 * attention list reset
      */	
	function attentionReset(){
		var formObj=document.form;
     	comboObjects[0].RemoveAll();
     	ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, "");
     	ComSetObjValue(formObj.payr_cntc_pnt_phn_no	, "");
     	ComSetObjValue(formObj.payr_cntc_pnt_fax_no , "");
     	ComSetObjValue(formObj.payr_cntc_pnt_eml	, "");
     	ComSetObjValue(formObj.cust_cntc_pnt_seq	, "");
	}    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
               
              var HeadTitle="||Seq.|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|F/D|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_trf_grp_seq|CMDT_EXPT_AMT|rfa_expt_dar_no|rfa_expt_mapg_seq|rfa_expt_ver_seq|rfa_rqst_dtl_seq|sc_no|sc_expt_ver_seq|sc_expt_grp_seq|dmdt_trp_aply_tp_cd|inv_bill_amt|inv_chg_tot|org_ft_ovr_dys";
              var HeadTitle1="||Seq.|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|F/D|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_trf_grp_seq|CMDT_EXPT_AMT|rfa_expt_dar_no|rfa_expt_mapg_seq|rfa_expt_ver_seq|rfa_rqst_dtl_seq|sc_no|sc_expt_ver_seq|sc_expt_grp_seq|dmdt_trp_aply_tp_cd|inv_bill_amt|inv_chg_tot|org_ft_ovr_dys";
              var headCount=ComCountHeadTitle(HeadTitle);
             // (headCount, 0, 0, true);
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"checkBox",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gb",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"svr_id" },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no" },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd" },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd" },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chg_seq" },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_seq" },
                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_grp_seq" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"cmdt_expt_amt" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rfa_expt_dar_no" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rfa_expt_mapg_seq" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rfa_expt_ver_seq" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rfa_rqst_dtl_seq" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"sc_no" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"sc_expt_ver_seq" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"sc_expt_grp_seq" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"dmdt_trf_aply_tp_cd" },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"inv_bill_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"inv_chg_tot",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"org_ft_ovr_dys",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
            //  SetGetCountPosition()(0);
              FrozenCols=SaveNameCol("cntr_tpsz_cd");
              SetToolTipText(0,"gb","General/Balance Charge Type");
              SetToolTipText(1,"gb","General/Balance Charge Type");
              SetSheetHeight(140,1);
              }


                break;
            case 2:
                with(sheetObj){
                
              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
              var HeadTitle="";
              var headCount=ComCountHeadTitle(HeadTitle);
              

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20,DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"}];
              InitHeaders(headers, info);

//              var cols = [  ];
              FrozenCol=0;
//              InitColumns(cols);

              SetEditable(1);
             // SetCountPosition(0);
          //    SetSheetHeight(130);
              
            }
                break;
        }
    }
    
    function resizeSheet(){
    	        ComResizeSheet(sheetObjects[0]);
    	     }

    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:     // Search
				//1.Setting parametor condition, before retrieving
				if (sheetObj.id == "sheet1") {
					var param="";
					if (ComGetObjValue(formObj.invoice_issue) == "1") {
						//ComSetObjValue(formObj.f_cmd, SEARCH);
						//setParameters(SEARCH);
						param="f_cmd=" + SEARCH
							  + "&s_dmdt_trf_cd=" + formObj.s_dmdt_trf_cd.value 
							  + "&s_bkg_no=" + formObj.s_bkg_no.value 
							  + "&ofc_cd=" + formObj.session_ofc_cd.value		//session office code
							  + "&s_ofc_cd=" + formObj.s_ofc_cd.value			//charge office code
							  + "&dmdt_chg_sts_cds=" + formObj.dmdt_chg_sts_cds.value
							  + "&s_chg_type=" + formObj.s_chg_type.value
							  + "&usr_cnt_cd=" + formObj.usr_cnt_cd.value
							  ;
					}
					else if (ComGetObjValue(formObj.invoice_issue) == "2") {
						//ComSetObjValue(formObj.f_cmd, SEARCH01);
						//setParameters(SEARCH01);
						param="f_cmd=" + SEARCH01
						  + "&s_bkg_no=" + formObj.s_bkg_no.value 
						  + "&s_dmdt_trf_cd=" + formObj.s_dmdt_trf_cd.value
						  + "&ofc_cd=" + formObj.s_ofc_cd.value			//credit office code
						  + "&s_ofc_cd=" + formObj.s_ofc_cd.value			//charge office code
						  //+ "&dmdt_chg_sts_cds=" + formObj.dmdt_chg_sts_cds.value
						  //+ "&s_chg_type=" + formObj.s_chg_type.value
						  + "&s_invoice_no=" + formObj.s_invoice_no.value
						  ;
					}
					if (validateForm(sheetObj,formObj,sAction)) {
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
//						sheetObj.DoSearch("EES_DMT_4002GS.do", FormQueryString(formObj));
 						var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", param);
						sheetObj.LoadSearchData(sXml,{Sync:1} );
	                    //ComOpenWait End
	                    ComOpenWait(false);
						ComEtcDataToForm(formObj, sheetObj);
						//org_payer_cd
						ComSetObjValue(formObj.org_payer_cd, ComGetObjValue(formObj.payer_cd));
						setComma();
					}
					//HREMARK
//					if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "H") {
//						ComBtnEnable("btn_hremark");
//						document.getElementById("btn_hremark").style.color="red";
//					}else{
//						ComBtnDisable("btn_hremark");
//						document.getElementById("btn_hremark").style.color="";
//					}
					if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
						ComBtnEnable("btn_cremark");
						document.getElementById("btn_cremark").style.color="red";
						//input value
						object_disable();
					}
					else {
						ComBtnDisable("btn_cremark");
						document.getElementById("btn_cremark").style.color="";
						//input value
						object_enable();
					}
					//ARIF button Enable
					if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
						if (ComGetObjValue(formObj.dmdt_ar_if_cd) == "N") {
							ComBtnEnable("btn_arif");
						}
						else {
							ComBtnDisable("btn_arif");
						}
					}
					else {
						ComBtnDisable("btn_arif");
					}
					//SAVE button Enable
					if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X") {
						ComBtnDisable("btn_save");
					}
					else {
						ComBtnEnable("btn_save");
					}
					//CANCEL 
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I") {
						ComBtnEnable("btn_cancel");
					}else{
						ComBtnDisable("btn_cancel");
					}
					//Common button
					//sheet Set, sheet Option
					ComBtnEnable("btn_set");
					ComBtnEnable("btn_option");
					//Sending History, Preview, INV Print, Fax Send, Email Send, Payer Info + Fax/Email
					if(ComGetObjValue(formObj.invoice_issue) == "1") {
						ComBtnDisable("btn_sendinghistory");
						ComBtnDisable("btn_preview");
						ComBtnDisable("btn_print");
						ComBtnDisable("btn_fax");
						ComBtnDisable("btn_email");
						//ComBtnDisable("btn_payerfaxemail");
					}
					else if (ComGetObjValue(formObj.invoice_issue) == "2") {
						ComBtnEnable("btn_sendinghistory");
						ComBtnEnable("btn_preview");
						ComBtnEnable("btn_print");
						ComBtnEnable("btn_fax");
						ComBtnEnable("btn_email");
						//ComBtnEnable("btn_payerfaxemail");
					}
					if (ComGetObjValue(formObj.invoice_issue) == "2") {
						sheetObj.CheckAll(1, 1, 0);
						sheetObj.SetEditable(0);
					}
					else {
						sheetObj.CheckAll(1, 1, 0);
					}
					//Date '-' handling
					if(ComGetObjValue(formObj.due_date) != "********") {
						ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
					}
					//Create Note text, dynamic processing
					if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C" && ComGetObjValue(formObj.cr_inv_no) != "") {
						document.getElementById('cr_nm').innerHTML="Reference";
					}
					else {
						document.getElementById('cr_nm').innerHTML="Credit Note";
					}
				}
				else if (sheetObj.id == "sheet2") {
					ComSetObjValue(formObj.f_cmd, SEARCH02);
					setParameters(SEARCH02);
					if (validateForm(sheetObj,formObj,sAction)) {
// 						sheetObj.DoSearch("EES_DMT_4002GS.do", FormQueryString(formObj) );
 						var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						ComSetObjValue(formObj.inv_xch_rt, sheetObj.GetEtcData("EX_RATE"));
					}
				}
			break;
			
        	case IBSAVE:
        		//Before Invoice issue
        		if (ComGetObjValue(formObj.invoice_issue) == "1") {
        			ComSetObjValue(formObj.f_cmd, MULTI);
					setParameters(MULTI);
				//After Invoice issue
				}
        		else if(ComGetObjValue(formObj.invoice_issue) == "2") {
					ComSetObjValue(formObj.f_cmd, MULTI01);
					setParameters(MULTI01);
					
					if (parseInt(ComGetObjValue(formObj.tax_rto_dis)) > 0  
						&& ComGetObjValue(formObj.tax_rto_dis) != ComGetObjValue(formObj.tax_rto)) {
						if (!ComShowCodeConfirm("DMT00184")) return;
					}
				}
				if(!validateForm(sheetObj,formObj,sAction)) return;
				unSetComma();	
				var sParam="";
				//Before Invoice issue
        		if (ComGetObjValue(formObj.invoice_issue) == "1") {
        			sParam=sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
        			document.getElementById('inv_cur').innerHTML ="<input type='text' name='inv_curr_cd' style='width:40px;text-align:center' class='input2' value='' readonly>";
				//After Invoice issue
				}
        		else if(ComGetObjValue(formObj.invoice_issue) == "2") {
					sParam=sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
					sheetObj.SetRowStatus(2, "U");
				}

                //ComOpenWait Start
//                sheetObj.SetWaitImageVisible(0);
//                ComOpenWait(true);
//         		var sXml=sheetObj.GetSaveData("EES_DMT_4002GS.do", sParam);
//				//3.Save and processing results
////                var sXml="<?xml version='1.0' ?> <SHEET> <RESULT> 		<TR-ALL>OK</TR-ALL> <ETC-DATA> <ETC KEY='SUCCESS_YN'><![CDATA[Y]]></ETC> <ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC> <ETC KEY='Exception'><![CDATA[]]></ETC> </ETC-DATA> </RESULT> </SHEET>";
// 				sheetObj.LoadSaveData(sXml,{Sync:1} );
//                //ComOpenWait End
//                ComOpenWait(false);

                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
 				var sXml = sheetObj.GetSaveData("EES_DMT_4002GS.do", sParam);
 				//=========================================================================================================================================
 				// GetSaveData 메소드 호출시, 아래 convert2ibsheet7 공통함수를 실행해야 되는데, 실행되지 않는 연유로 인해서, 강제적으로 실행하도록 수정함.
 				// 추후, 이와 같은 문제가 처리될 경우, 아래 로직은 삭제처리해야 함. 2014.08.22 이성훈
 				//=========================================================================================================================================
 				sXml = convert2ibsheet7(sXml);
 				//=========================================================================================================================================
 				sheetObj.LoadSaveData(sXml, {Sync:1});

                //ComOpenWait End
                ComOpenWait(false);
                
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				
				//4.After the save button handling
				if(ComGetObjValue(formObj.success_yn) == "Y"){
					if(ComGetObjValue(formObj.invoice_issue) == "1") {
						ComSetObjValue(formObj.s_invoice_no, sheetObj.GetEtcData("INVOICE_NO"));
						ComSetObjValue(formObj.s_ofc_cd, sheetObj.GetEtcData("CRE_OFC_CD"));
					}else{
						ComSetObjValue(formObj.s_invoice_no, ComGetObjValue(formObj.dmdt_inv_no));
						ComSetObjValue(formObj.s_ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
					}
					//SEARCH
					ComSetObjValue(formObj.invoice_issue, "2");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					ComBtnEnable("btn_set");
					ComBtnEnable("btn_option");
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_close");
					ComBtnEnable("btn_seninghistory");
					ComBtnEnable("btn_preview");
					ComBtnEnable("btn_print");
					ComBtnEnable("btn_fax");
					ComBtnEnable("btn_email");
					//ComBtnEnable("btn_payerfaxemail");
					//Cancel button Issued : Enable
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I" ) {
						ComBtnEnable("btn_cancel");
					}else{
						ComBtnDisable("btn_cancel");
					}
					//ARIF button Enable
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
						if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "N"){
							ComBtnEnable("btn_arif");
						}else{
							ComBtnDisable("btn_arif");
						}
					}else{
						ComBtnDisable("btn_arif");
					}		
					//HREMARK
//					if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "H") {
//						ComBtnEnable("btn_hremark");
//						document.getElementById("btn_hremark").style.color="red";
//					}else{
//						ComBtnDisable("btn_hremark");
//						document.getElementById("btn_hremark").style.color="";
//					}
					//CREMARK
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
						ComBtnEnable("btn_cremark");
						document.getElementById("btn_cremark").style.color="red";
						//input value
						object_disable();
					}else{
						ComBtnDisable("btn_cremark");
						document.getElementById("btn_cremark").style.color="";
						//input value
						object_enable();
					}
					sheetObj.SetEditable(1);
					sheetObj.CheckAll(1,1,1);
					sheetObj.SetEditable(0);
					//email, fax 
					doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
					//attention setting
					searchAttentionList();
					setPayerCd();
					var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
					comboObjects[0].SetSelectCode(setCode);
					if(comboObjects[0].GetSelectCode()== ""){
						comboObjects[0].SetSelectIndex(0);
					}
					//Searching ATTENTION information
					ComSetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm));
					ComSetObjValue(formObj.org_payr_cntc_pnt_phn_no, 	ComGetObjValue(formObj.payr_cntc_pnt_phn_no));
					ComSetObjValue(formObj.org_payr_cntc_pnt_fax_no, 	ComGetObjValue(formObj.payr_cntc_pnt_fax_no));
					ComSetObjValue(formObj.org_payr_cntc_pnt_eml, 		ComGetObjValue(formObj.payr_cntc_pnt_eml));
				}else{
					ComBtnEnable("btn_set");
					ComBtnEnable("btn_option");
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_close");
					if(ComGetObjValue(formObj.invoice_issue) == "1") {
						ComBtnDisable("btn_seninghistory");
						ComBtnDisable("btn_preview");
						ComBtnDisable("btn_print");
						ComBtnDisable("btn_fax");
						ComBtnDisable("btn_email");
						//ComBtnDisable("btn_payerfaxemail");
					}else if(ComGetObjValue(formObj.invoice_issue) == "2") {
						ComBtnEnable("btn_seninghistory");
						ComBtnEnable("btn_preview");
						ComBtnEnable("btn_print");
						ComBtnEnable("btn_fax");
						ComBtnEnable("btn_email");
						//ComBtnEnable("btn_payerfaxemail");
					}
					//Cancel button Issued : Enable
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I") {
						ComBtnEnable("btn_cancel");
					}else{
						ComBtnDisable("btn_cancel");
					}		
					//HREMARK
//					if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "H") {
//						ComBtnEnable("btn_hremark");
//						document.getElementById("btn_hremark").style.color="red";
//					}else{
//						ComBtnDisable("btn_hremark");
//						document.getElementById("btn_hremark").style.color="";
//					}
					//CREMARK
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
						ComBtnEnable("btn_cremark");
						document.getElementById("btn_cremark").style.color="red";
						//input value
						object_disable();
					}else{
						ComBtnDisable("btn_cremark");
						document.getElementById("btn_cremark").style.color="";
						//input value
						object_enable();
					}
					//ARIF button Enable
					if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
						if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "N"){
							ComBtnEnable("btn_arif");
						}else{
							ComBtnDisable("btn_arif");
						}
					}else{
						ComBtnDisable("btn_arif");
					}
				}
			break;
			
        	case IBARIF:
        		ComSetObjValue(formObj.f_cmd, COMMAND01);
        		setParameters(COMMAND01);
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        		if (!ComShowCodeConfirm("DMT03026")) return;
        		//sheetObj.DoSave("EES_DMT_4002GS.do", FormQueryString(formObj), -1, false);
				var sParam=sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
				//Upon successful handling INVOICE Retrieving button
 				var sXml=sheetObj.GetSaveData("EES_DMT_4002GS.do", sParam);
				//3.Save and processing results
 				sheetObj.LoadSaveData(sXml);
                //ComOpenWait End
                ComOpenWait(false);
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));//SUCCESS_YN
				//4.After storage and re-Inquiry
				//SEARCH
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				// After search, conditions are set according to the Tax Rto.
				setTaxRto();
				searchAttentionList();
				var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
				if(ComGetObjValue(formObj.payer_cd) == "") {
					comboObjects[0].SetSelectIndex(-1);
					ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
					ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
					ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
				}else{
					//Attention Setting
					comboObjects[0].SetSelectCode(setCode);
					if(comboObjects[0].GetSelectCode()== ""){
						comboObjects[0].SetSelectIndex(0);
					}
				}
				//////////////////////////////////////////////
				//ARIF button Enable
				if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
					if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "N"){
						ComBtnEnable("btn_arif");
					}else{
						ComBtnDisable("btn_arif");
					}
				}else{
					ComBtnDisable("btn_arif");
				}
				sheetObj.SetEditable(1);
				sheetObj.CheckAll(1,1,1);
				sheetObj.SetEditable(0);
				//CREMARK
				if(ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
					ComBtnEnable("btn_cremark");
					document.getElementById("btn_cremark").style.color="red";
					//input value
					object_disable();
				}else{
					ComBtnDisable("btn_cremark");
					document.getElementById("btn_cremark").style.color="";
					//input value
					object_enable();
				}
        	break;
        	
        	case IBFAXSEND:
        		//MRD file
        		var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
        		var ofc_cd   = ComGetObjValue(formObj.cre_ofc_cd);
        		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
        		if(temp_LR == "") {
        			//=========================================
        			//2015.10.27 #7995 comment start
        			//2017.01.12 #23259 India Invocie
   		 		    if(cre_cnt_cd == "IN"){
   		 		    	// india office 전용 2012.05.18	
   		 		    	mrd_file = "EES_DMT_4912.mrd";
   		 		    }else{
   		 		    	mrd_file = "EES_DMT_4901.mrd";  //L
   		 		    }
//        			mrd_file = "EES_DMT_4901.mrd";  //L
   		 		    //2015.10.27 #7995 comment e n d
   		 		    //=========================================
        		}else if(temp_LR == "L") {
        			//=========================================
        			//2015.10.27 #7995 comment start   		 		    
     		 		if(cre_cnt_cd == "IN"){
          	        // india office 전용 2012.05.18	
          	           mrd_file = "EES_DMT_4912.mrd";
         		 	 }else{	
                       mrd_file = "EES_DMT_4901.mrd";		//L
         		 	}
//     		 		mrd_file = "EES_DMT_4901.mrd";		//L
		 		    //2015.10.27 #7995 comment e n d
		 		    //=========================================
        		}else if(temp_LR == "R") {
        			//=========================================
        			//2015.10.27 #7995 comment start   		 	
       		 		if(cre_cnt_cd == "IN"){
               	        // india office 전용 2012.05.18	
               	          mrd_file = "EES_DMT_4913.mrd";
              		  }else{	
        				  mrd_file = "EES_DMT_4902.mrd";		//R
        			}
//    				mrd_file = "EES_DMT_4902.mrd";		//R
  		 		    //2015.10.27 #7995 comment e n d
  		 		    //=========================================
        		}
        		var ma_param="jspno=4002"
					 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 ;        		
            	//Search MASTER DATA
         		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
        		ComEtcDataToForm(formObj, sheetObj);
        		//rd_fxeml_rd_param
        		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
    						+ " /rv " + rvParmByInvoice(formObj)
    						+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
    						;
        		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice(INV#: "+ComGetObjValue(formObj.dmdt_inv_no)+")");
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
//    			ComSetObjValue(formObj.rd_fxeml_fax_no,			ComGetObjValue(formObj.payr_faxnos));			//rcvr_fax_no
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");	//rcvr_email	//mjchang@COMPANY.com
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.dmdt_inv_no));		//file_name
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");// Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.dmdt_inv_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no));	//"name;mjchang|message;" + mailCtnt);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
//    			ComSetObjValue(formObj.f_cmd, SEARCH05);
//        		setParameters(SEARCH05);
//        		
//                //ComOpenWait Start
//                sheetObj.WaitImageVisible=false;
//                ComOpenWait(true);
//
//        		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//        		ComShowMessage(dmtGetMsgText(sXml));
//        		
//                //ComOpenWait End
//                ComOpenWait(false);
        	break;
        	
        	case IBEMAILSEND:
        		var mrd_file="";
//        		var sndr_id		= "";	//id
//        		var sndr_name	= "";	//
//        		var sndr_email	= "";	//
//        		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//        		var rcvr_email	= "";	//
//        		var msg1		= "";
//        		
        		//MRD file
        		var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
        		var ofc_cd   = ComGetObjValue(formObj.cre_ofc_cd);
        		var cre_cnt_cd  = ComGetObjValue(formObj.cre_cnt_cd);
        		if(temp_LR == "") {
        			//=========================================
        			//2015.10.27 #7995 comment start
        			//2017.01.12 #23259 India Invocie
         		 	if(cre_cnt_cd == "IN"){
              	        //india office 전용 2012.05.18	
              	          mrd_file = "EES_DMT_4912.mrd";
             		   }else{
                          mrd_file = "EES_DMT_4901.mrd";		//L
             		}
//                       mrd_file = "EES_DMT_4901.mrd";		//L
         		 	//2015.10.27 #7995 comment e n d
         		 	//=========================================	
        		}else if(temp_LR == "L") {
        			//=========================================
        			//2015.10.27 #7995 comment start
          		 	if(cre_cnt_cd == "IN"){
                 	        //india office 전용 2012.05.18	
                 	          mrd_file = "EES_DMT_4912.mrd";
                	   }else{
        				      mrd_file = "EES_DMT_4901.mrd";		//L
                	}
// 				      mrd_file = "EES_DMT_4901.mrd";		//L
          		 	//2015.10.27 #7995 comment e n d
          		 	//=========================================	
        		}else if(temp_LR == "R") {
        			//=========================================
        			//2015.10.27 #7995 comment start
          		 	if(cre_cnt_cd == "IN"){
                 	      //india office 전용 2012.05.18	
                 	      mrd_file = "EES_DMT_4912.mrd";
                	   }else{
        				  mrd_file = "EES_DMT_4902.mrd";		//R
                	}
//     				  mrd_file = "EES_DMT_4902.mrd";		//R
          		 	//2015.10.27 #7995 comment e n d
          		 	//=========================================	
        		}
//        		//SEND
//        		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//        		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//        		sndr_email	= ComGetObjValue(formObj.session_email);
//        		
//        		rcvr_email		= ComGetObjValue(formObj.payr_emailnos);
//        		var arr_emails	= ComGetObjValue(formObj.payr_emailnos).split(";");
//        		
//        		for(var i=0 ; i < arr_emails.length; i++) {
//        			msg1		+= arr_emails[i] +"\n\t";
//        		}
//        		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
//        		
        		var ma_param="jspno=4002"
					 		+ "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
					 		+ "&f_cmd=" + SEARCH01
					 		+ "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 		;        		
            	//Search MASTER DATA
         		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
        		ComEtcDataToForm(formObj, sheetObj);
        		//rd_fxeml_rd_param
        		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
    						+ " /rv " + rvParmByInvoice(formObj)
    						+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
    						;
        		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Ref # "+ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_fixed,	"shipment.info@notifications.nykline.com");				// use when should fix sndr_email
    			
//    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	ComGetObjValue(formObj.payr_emailnos));	//rcvr_email	
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");// Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.dmdt_inv_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no));	//"name;mjchang|message;" + mailCtnt);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,	"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
//    			ComSetObjValue(formObj.f_cmd, SEARCH06);
//        		setParameters(SEARCH06);
//        		
//                //ComOpenWait Start
//                sheetObj.WaitImageVisible=false;
//                ComOpenWait(true);
//
//        		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//        		ComShowMessage(dmtGetMsgText(sXml));
//        		
//                //ComOpenWait End
//                ComOpenWait(false);
        	break;
        }
    }
    
    // 1. before the invoice issue always makes checkbox status..
    // 2. After Invoice issue and the amount is zero, no check, 
    //     (Invoice tax_rto, Office tax_rto)is different, do not select the check box, represents Invoice Tax_Rto viewed.
    //     (Invoice tax_rto, Office tax_rto)is the same, select the check box..
    function setTaxRto(){
    	var formObj=document.form;
    	//Including TAX only if the amount you are checking the check box(After Invoice issue)
		if(ComGetObjValue(formObj.invoice_issue) == "2"){
			if(ComGetObjValue(formObj.tax_amt) == "0.00") {
				formObj.chk_tax.checked=false;
				ComSetObjValue(formObj.tax_rto_dis, "0");
			}else{
				//office's tax rto and the invoice is stored in the tax rto compare.
				if(ComGetObjValue(formObj.tax_rto) == ComGetObjValue(formObj.inv_tax_rto)) {
					formObj.chk_tax.checked=true;
					ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
				}else{
					formObj.chk_tax.checked=false;
					ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.inv_tax_rto));
				}
			}
		}else{
			formObj.chk_tax.checked=true;
	     	// India GST Tax
			//=========================================
			//2015.10.27 #7995 comment start
			//2017.01.12 #23259 India Invocie
	        if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {
	        	ComEnableObject(formObj.chk_tax, false);
	        	ComSetObjValue(formObj.tax_rto_dis, "");
	        	getExRate();
	        	setComma();
	        }else{
		        ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
	        }
//			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
			//2015.10.27 #7995 comment e n d
			//=========================================	
		}
    }
    
	/**
	 * EES_DMT_4013, EES_DMT_4002 call
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		if(srcName == "btn_preview") {
			formObj.f_cmd.value = SEARCH01;
			//no PayerCode --> error 
			if(ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT02002", "Payer Code");
			}
			var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
			var invoice_LR="";
			if(temp_LR == "") {
				invoice_LR="L";
			}else if(temp_LR == "L") {
				invoice_LR="L";
			}else if(temp_LR == "R") {
				invoice_LR="R";
			}
			var url="EES_DMT_4003.do"
				+"?f_cmd="+ComGetObjValue(formObj.f_cmd)
				+"&payr_cntc_pnt_phn_no="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
				+"&payr_cntc_pnt_fax_no="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
				+"&payr_cntc_pnt_eml="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
				//+"&dmdt_payr_cntc_pnt_nm="+ComGetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm)
				+"&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)
				+"&invoice_LR="+invoice_LR
				+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&payer_cd="+ComGetObjValue(formObj.payer_cd)
				+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&bl_no="+ComGetObjValue(formObj.bl_no)
				+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&rhq_ofc_cd="+ComGetObjValue(formObj.rhq_ofc_cd)
				+"&cre_cnt_cd="+ComGetObjValue(formObj.cre_cnt_cd)
				+"&jspno=4002"
				;
			//var returnValue = ComOpenWindowCenter(url, "EES_DMT_4003", "1036","735", true);
			var returnValue=ComOpenWindowCenter(url, "EES_DMT_4003", "950","680", true, "yes");
		}
		else if (srcName == "btn_cancel") {
			var url="EES_DMT_4106.do"
				+"?dmdt_inv_no="+ComGetObjValue(formObj.dmdt_inv_no)
				+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				;
			if(ComGetObjValue(formObj.cre_ofc_cd) == ComGetObjValue(formObj.session_ofc_cd)) {
				if(ComShowCodeConfirm('DMT03025')){
					var url="EES_DMT_4106.do"
						+"?dmdt_inv_no="+ComGetObjValue(formObj.dmdt_inv_no)
						+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)
						+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
						;

//					var returnValue=ComOpenWindowCenter(url, "EES_DMT_4106", "500","450", true);
//					if(returnValue=="Y"){
//						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//					}
					ComOpenPopup(url, "500", "450", "callbackProc", "1,0,1,1,1,1,1", true);
				}
			}
			else {
				ComShowCodeMessage('DMT03024', ComGetObjValue(formObj.cre_ofc_cd), ComGetObjValue(formObj.session_ofc_cd));
			}
		}
		else if(srcName == "btn_set") {
			var url="EES_DMT_4101.do"
				+"?issoff="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&tftp2="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&sheetp=I"
				+"&invoice_issue="+ComGetObjValue(formObj.invoice_issue)
				+"&jspno=EES_DMT_4002";
			var sWidht  = "725";
			var sHeight = "550";
			ComOpenWindowCenter(url, "EES_DMT_4101", sWidht, sHeight, true, "yes");
			//var returnValue=ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true, "yes");
			//Retrieving whether there should Sheet Set.
			//if there is no Sheet Set , when Preview / Print / Fax send / Email send button clicked,  on the Alert message show and blocking..
			doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND13,"RESULT","");		
		}else if(srcName == "btn_option") {
			var url="EES_DMT_4103.do"
				+"?issoff="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&jspno=EES_DMT_4002"
				+"&invoice_issue="+ComGetObjValue(formObj.invoice_issue)
				+"&tftp="+ComGetObjValue(formObj.dmdt_trf_cd)
				;
			var sWidht  = "625";
			var sHeight = "680"; 			
			ComOpenWindowCenter(url, "EES_DMT_4103", sWidht, sHeight, true);
			//var returnValue=ComOpenWindowCenter(url, "EES_DMT_4103", "625","780", true);
		}else if(srcName == "btn_payerfaxemail") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd="";
			if(ComGetObjValue(formObj.invoice_issue) == "1") {
				ofc_cd=ComGetObjValue(formObj.session_ofc_cd);
			}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
				ofc_cd=ComGetObjValue(formObj.cre_ofc_cd);
			}
			var url="EES_DMT_4104.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=EES_DMT_4002"
				+"&attn="+ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				;
			var sWidht  = "825";
			var sHeight = "580"; 	
			ComOpenWindowCenter(url, "EES_DMT_4104", sWidht, sHeight, true);			
			//var returnValue=ComOpenWindowCenter(url, "EES_DMT_4104", "825","600", true);
		}else if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd="";
			if(ComGetObjValue(formObj.invoice_issue) == "1") {
				return;
			}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
				ofc_cd=ComGetObjValue(formObj.cre_ofc_cd);
			}
			var url="EES_DMT_4107.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=4002"
				+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
				+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
				;
			var sWidht  = "520";
			var sHeight = "250";
			ComOpenWindowCenter(url, "EES_DMT_4107", sWidht, sHeight, true);			
			//ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
		}else if(srcName == "btn_email") {
			if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd="";
			if(ComGetObjValue(formObj.invoice_issue) == "1") {
				return;
			}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
				ofc_cd=ComGetObjValue(formObj.cre_ofc_cd);
			}
			var url="EES_DMT_4108.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=4002"
				+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
				+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
				;
			var sWidht  = "520";
			var sHeight = "250";	
			ComOpenWindowCenter(url, "EES_DMT_4108", sWidht, sHeight, true);			
			//ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);		
		}else if(srcName == "btn_sendinghistory") {
			var url="EES_DMT_7006_P.do"
				+"?jspno=EES_DMT_4002"
				+"&invoice="+ComGetObjValue(formObj.dmdt_inv_no)
				+"&selectOpt=1"
				;
			var sWidht  = "1036";
			var sHeight = "650";
			ComOpenWindowCenter(url, "EES_DMT_7006_P", sWidht, sHeight, true);			
			//var returnValue=ComOpenWindowCenter(url, "EES_DMT_7006", "1036","690", true);
		}
	}   
    /**
     * init RD
     * index : Index of toolbar items to be disabled. 0-Save a  file, 1-Print, 2-Find, 3-Creating a table of contents, 
     * 4-Zoom-in the screen, 5-Zoom-out the screen, 12-Stop printing, 13-View in Microsoft Excel, 14-View in Hangul, 
     * 15-View in pdf, 16-View in Microsoft PowerPoint, 17-View in Microsoft Word.
     * @return
     */
 	function initRdConfig(){
//		var Rdviewer=rdObject ;
//		Rdviewer.AutoAdjust=true;
//		Rdviewer.HideStatusBar();
//		Rdviewer.ViewShowMode(0);
//		Rdviewer.SetPageLineColor(255,255,255);      
//		Rdviewer.ApplyLicense("0.0.0.0"); 
//		var hiddenParam = ["save"];
//        Rdviewer.hideToolbarItem(hiddenParam);
 	}  
    //RD Open
    function rdOpen(formObj, sheetObj){
//    	var Rdviewer=rdObject ;
    	//var path = formObj.mrd.value;		//mrd_path
    	var path="";
    	var invoice_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
    	var ofc_cd      = ComGetObjValue(formObj.cre_ofc_cd);
    	var cre_cnt_cd  = ComGetObjValue(formObj.cre_cnt_cd);
    	
		var appendReport = [];
		/*
		if(invoice_LR == "") {
			var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "L") {
			var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "R") {
			var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
		}
		*/
//		var ma_param="jspno=4002"
//			 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
//			 + "&f_cmd=" + SEARCH01
//			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
//			 ;
//		//Search MASTER DATA
//		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
//		sheetObj.LoadSearchData(sXml,{Sync:1} );
//		ComEtcDataToForm(formObj, sheetObj);
//		//RD calls 
//		var mrdParam="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
//					+ " /rv " + rvParmByInvoice(formObj)
//					+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
//					;
//		
//		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
//		directReportDownload(appendReport);
    	
		if(invoice_LR == "") {
			//=========================================
			//2015.10.27 #7995 comment start
			//2017.01.12 #23259 India Invocie
	 		if(cre_cnt_cd == "IN"){
        		//india office
	 			var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
        	}else{
        		var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
        	}
//			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
	 		//2015.10.27 #7995 comment e n d
	 		//=========================================	
		}else if(invoice_LR == "L") {
			//=========================================
			//2015.10.27 #7995 comment start
			//2017.01.12 #23259 India Invocie
	 		if(cre_cnt_cd == "IN"){
        		//india office
	 			var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
        	}else{
        		var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
        	}
//	 		path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
	 		//2015.10.27 #7995 comment e n d
	 		//=========================================	
		}else if(invoice_LR == "R") {
			//=========================================
			//2015.10.27 #7995 comment start
			//2017.01.12 #23259 India Invocie
	 		if(cre_cnt_cd == "IN"){
        		// india office
	 			var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4913.mrd";
        	}else{
        		var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
        	}
	 		path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
	 		//2015.10.27 #7995 comment e n d
	 		//=========================================	
		}
		var ma_param="jspno=4002"
			 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
			 ;
		//Search MASTER DATA
		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		//RD calls 
		var mrdParam="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
					;
		
		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
		directReportDownload(appendReport);

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
					" RD_CUST_REF_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_ref_prn_flg) +"]"+
					" RD_DAYS_DISP[" + ComGetObjValue(formObj.rd_days_disp) +"]" +
					" RD_DMDT_INV_STS_CD[" + ComGetObjValue(formObj.rd_dmdt_inv_sts_cd) +"]" +
					" RD_CRE_CNT_CD[" + ComGetObjValue(formObj.rd_cre_cnt_cd) +"]" +
					" RD_IDA_EXPN_TAX_RT[" + ComGetObjValue(formObj.rd_ida_expn_tax_rt) +"]" +
					" RD_IDA_EXPN_TAX[" + ComGetObjValue(formObj.rd_ida_expn_tax) +"]" +
					" RD_IDA_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_edu_tax_rt) +"]" +
					" RD_IDA_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_edu_tax) +"]" +
					" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt) +"]" +
					" RD_IDA_HIGH_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_high_edu_tax) +"]" +
					" RD_TAX_RGST_NO[" + ComGetObjValue(formObj.rd_tax_rgst_no) +"]" +
					" RD_SVC_CATE_RMK[" + ComGetObjValue(formObj.rd_svc_cate_rmk) +"]" +
					" RD_PMNT_ACCT_NO[" + ComGetObjValue(formObj.rd_pmnt_acct_no) +"]"
					;
    	return rvRaram;
    }        
	// REMARK MESSAGE
	function remark_alert(srcName) {
		if(srcName == "btn_cremark") {
			var formObj=document.form;
			var cancel_rmk=ComGetObjValue(formObj.cxl_rmk);		//	cancel_remark
			var cancel_date=ComGetObjValue(formObj.upd_dt);		//	update_dt
			var ofc_cd=ComGetObjValue(formObj.upd_ofc_cd);	//	update_ofc_cd
			var usr_id=ComGetObjValue(formObj.upd_usr_id);	//update_usr_id
			var usr_name=ComGetObjValue(formObj.upd_usr_nm);	//update_usr_nm
			var msg=cancel_rmk
							+ "\n\nCancel Date: "+cancel_date
							+ "\nOffice: "+ofc_cd
							+ "\nUser ID: "+usr_id
							+ "\nUser Name: "+usr_name;
			ComShowMessage(msg);
//		}else if(srcName == "btn_hremark") {
//			var formObj=document.form;
//			var hold_rmk=ComGetObjValue(formObj.inv_hld_rmk);			//hold_remark
//			var hold_date=ComGetObjValue(formObj.ar_if_dt);		//ar_if_dt
//			var ofc_cd=ComGetObjValue(formObj.ar_if_ofc_cd);	//ar_if_ofc_cd
//			var usr_id=ComGetObjValue(formObj.ar_if_usr_id);	//ar_if_usr_id
//			var usr_name=ComGetObjValue(formObj.ar_if_usr_nm);	//ar_if_usr_nm
//			var msg=hold_rmk
//							+ "\n\nHold Date: "+hold_date
//							+ "\nOffice: "+ofc_cd
//							+ "\nUser ID: "+usr_id
//							+ "\nUser Name: "+usr_name;
//			ComShowMessage(msg);
		}
	}
    function setComma(){
    	var formObj=document.form;
		//Charge 3-digit comma
		var org_chg_amt=ComAddComma2(ComGetObjValue(formObj.mn_org_chg_amt),"#,###.00");
		var dmdt_expt_amt=ComAddComma2(ComGetObjValue(formObj.dmdt_expt_amt),"#,###.00");
		var chg_dc_amt=ComAddComma2(ComGetObjValue(formObj.chg_dc_amt),"#,###.00");
		var bil_amt=ComAddComma2(ComGetObjValue(formObj.mn_bil_amt),"#,###.00");
		var aft_inv_adj_amt=ComAddComma2(ComGetObjValue(formObj.aft_inv_adj_amt),"#,###.00");
		//Invoice
		var tot_amt=ComAddComma2(ComGetObjValue(formObj.tot_amt),"#,###.00");
		var dc_amt=ComAddComma2(ComGetObjValue(formObj.dc_amt),"#,###.00");
		var inv_chg_amt=ComAddComma2(ComGetObjValue(formObj.inv_chg_amt),"#,###.00");
		var tax_amt=ComAddComma2(ComGetObjValue(formObj.tax_amt),"#,###.00");
		var inv_amt=ComAddComma2(ComGetObjValue(formObj.inv_amt),"#,###.00");
		var inv_xch_rt=parseFloat(ComGetObjValue(formObj.inv_xch_rt)).toFixed(6);
		ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
		ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
		ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
		ComSetObjValue(formObj.tot_amt, tot_amt);
		ComSetObjValue(formObj.dc_amt, dc_amt);
		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
    }
    function unSetComma(){
       	var formObj=document.form;
		//ChargeRemove the 3-digit comma
		var org_chg_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float");
		var dmdt_expt_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float");
		var chg_dc_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float");
		var bil_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float");
		var aft_inv_adj_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.aft_inv_adj_amt),"float");
		//Invoice
		var tot_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),"float");
		var dc_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.dc_amt),"float");
		var inv_chg_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float");
		var tax_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tax_amt),"float");
		var inv_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_amt),"float");
		ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
		ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
		ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
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
	    var formObj=document.form
	    switch(comboNo) { 
	    	//Attention
	    	case 1:
	    		with (comboObj) {
// 					MultiSelect = false; 
// 					UseAutoComplete = false;	
// 					SetColAlign("left");        
// 					SetColWidth("150");
// 					DropHeight = 250;
// 					ValidChar(2,2);		
 					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColAlign(2, "left");
					SetColAlign(3, "left");
					//SetColWidth("|1|1|1|");
					SetDropHeight(160);
	    		}
	    		break;
	     } 		
	} 	
	/*
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		if(sAction == SEARCH) {
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
		}else if(sAction == MULTI) {
			if(!formObj.chk_tax.checked) {
				ComSetObjValue(formObj.tax_rto, "0");
			}
			if(ComGetObjValue(formObj.s_chg_type) == "A" || ComGetObjValue(formObj.s_chg_type) == "G") {
				ComSetObjValue(formObj.chg_type, "G");
			}else if(ComGetObjValue(formObj.s_chg_type) == "B") {
				ComSetObjValue(formObj.chg_type, "B");
			}
		}else if(sAction == MULTI01) {
			if(!formObj.chk_tax.checked) {
				if(parseFloat(ComGetObjValue(formObj.tax_rto_dis)) == 0 ) {
					ComSetObjValue(formObj.tax_rto, "0");
				}else{
					ComSetObjValue(formObj.tax_rto, ComGetObjValue(formObj.tax_rto_dis));
				}
			}
		}
	}
    function initAxonControl() {
		//axon_event.addListener('mouseover', 'obj_mouseover', 'txt_remark','txt_aft_inv_adj_amt','btn_cremark','btn_hremark');	// onMouseover event
		//axon_event.addListener('mouseout', 'obj_mouseout', 'txt_remark','txt_aft_inv_adj_amt','btn_cremark','btn_hremark');	// onMouseout event
		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_remark','txt_aft_inv_adj_amt','btn_cremark');	// onMouseover event
		axon_event.addListener('mouseout', 'obj_mouseout', 'txt_remark','txt_aft_inv_adj_amt','btn_cremark');	// onMouseout event
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListenerFormat('focus',	'obj_focus',	form); // Get focus
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- out of focus
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
   // out of focus
    function obj_blur(){
    	//check inputing Validation + Inserting separator 
		var obj=ComGetEvent();
		if(obj.name == 'payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else if(obj.name == 'trucker_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCHLIST04);
		}else{
			ComChkObjValid(obj);
		}
    }   
    // (button Show balloon message)
	function obj_mouseover() {
 		var msg='';
		var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
     	switch(ComGetEvent().id){
	  		case 'txt_remark':
	  			msg='Invoice Remark will be included in the Invoice Sheet';
	  			x=x;
	  			y=y-20;
	  			skn.left=x;
	  			skn.top=y+20;
	  			break;
	  		case 'txt_aft_inv_adj_amt':
	  			msg='Adjusted Billable AMT after the Invoice was issued';
	  			x=x;
	  			y=y-20;
	  			skn.left=x;
	  			skn.top=y-20;
	  			break;
	  		case 'btn_cremark':
	  			msg='Invoice Cancel Remark';
	  			x=x-20;
	  			y=y-20;
	  			skn.left=x;
	  			skn.top=y+20;
	  			break;
//	  		case 'btn_hremark':
//	  			msg='Invoice Hold Remark';
//	  			x=x-20;
//	  			y=y-20;
//	  			skn.left=x;
//	  			skn.top=y+20;
//	  			break;
     	}
		var bak='lightyellow';
		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
    }
    // (button Hide balloon message)
	function obj_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
	}
    /**
     * Search AR Currency
     */	
	function searchARCurrencyList() {
		var sheetObj=sheetObjects[1];
		var formObj=document.form;
		//Before Invoice Issue
//		if(ComGetObjValue(formObj.invoice_issue) == "1") {
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
//		//After Invoice Issue
//		}else{
//			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
//		}
		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST05,"AR_CURRENCY");
	}
    /**
     * Search Attention
     */	
	function searchAttentionList() {
		//Attention Combo
		setPayerCd();

		var formObj=document.form;
		//payer code is not exist
		if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
			comboObjects[0].RemoveAll();
			return;
		}
		//Before Invoice Issue
		if(ComGetObjValue(formObj.invoice_issue) == "1") {
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
		//After Invoice Issue
		}else{
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
		}
		doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,SEARCHLIST03,"ATTENTION",comboObjects[0]);
		// Attention Combo Setting
		//comboObj.Text = ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
	}
	// Retrieving conditions fields Combo 
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
        	case IBSEARCH:      // Search
				if (sheetObj.id == "sheet2") {
					//3.After handling Retrieving results
					var comboDatas;
					var comboItems;
					switch(sComboAction) {
						//1. ATTENTION LIST
						case SEARCHLIST03:
							//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST03);
							setComboParameters(sComboAction, sObj);
							//2.retrievie according to conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							comboObjects[0].RemoveAll();
							addComboItem1(sObj,comboItems);						
							break;							
						//3-1.Currency
						case SEARCHLIST05:
							//1.Setting parametor condition, before retrieving
							//ComSetObjValue(formObj.f_cmd, SEARCHLIST05);
							//setComboParameters(sComboAction, sObj);
							var param="f_cmd=" + SEARCHLIST05
							  + "&jspno=4002" 
							  + "&ofc_cd=" + formObj.session_ofc_cd.value
							  ; 
							//2.retrievie according to conditions					
							//var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", param);
							ComClearCombo(formObj.inv_curr_cd);
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								addComboItem(formObj.inv_curr_cd,comboDatas,true);
							}
							break;		
						//Current date 
						case SEARCHLIST06:
							//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST06);
							setComboParameters(sComboAction, sObj);
							//2.retrievie according to conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.ofc_curr_date, ComGetEtcData(sXml, "OFC_CURR_DAY"));
							break;		
						//Retrieving of SHEET SET exists
						case COMMAND13:
							//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, COMMAND13);
							setComboParameters(sComboAction, sObj);
							//2.retrievie according to conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							//3.After handling Retrieving results
							ComSetObjValue(formObj.has_sheetset, 	ComGetEtcData(sXml, "RESULT"));
							break;
						//Payer's Email, FAX number is Retrieving.
						case COMMAND02:
							//1.Setting parametor condition, before retrieving
							//ComSetObjValue(formObj.f_cmd, COMMAND02);
							//setComboParameters(sComboAction, sObj);
							var param="f_cmd=" + COMMAND02
									  + "&payer_cd=" + formObj.payer_cd.value 
									  + "&dmdt_trf_cd=" + formObj.dmdt_trf_cd.value 
									  + "&ofc_cd=" + formObj.cre_ofc_cd.value
									  ;     
 							var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", param);
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							//2.retrievie according to conditions					
							//var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
							//3.After handling Retrieving results
							ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							break;
						//Search Sheet Option
						case COMMAND14:
							//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, COMMAND14);
							setComboParameters(sComboAction, sObj);
							//2.retrievie according to conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							//3.After handling Retrieving results
							ComSetObjValue(formObj.bil_to_loc_div_cd, 	ComGetEtcData(sXml, "BIL_TO_LOC_DIV_CD"));
							break;
						//CNT 
						case COMMAND17:
							ComSetObjValue(formObj.f_cmd, COMMAND17);
							//2.retrievie according to conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							//3.After handling Retrieving results
							ComSetObjValue(formObj.usr_cnt_cd, 	ComGetEtcData(sXml, "USR_CNT_CD"));
							break;
						// REP CUST SEQ
						case COMMAND23:
							ComSetObjValue(formObj.f_cmd, COMMAND23);				
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.rep_cust_seq, 	ComGetEtcData(sXml, "REP_CUST_SEQ"));
							break;
					}
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Data in the field adds a combo.
     */	
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems=comboDatas.split(ROWMARK);	
	    	for (var i=0 ; i < comboItems.length ; i++) {
    			comboItem=comboItems[i].split(FIELDMARK);
				val=comboItem[0];
				txt=isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,val,txt);
    		}
		}   		
	}
	/**
     * Data in the field adds a combo.
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, " "+comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3]+" ", comboItem[4]);	
			//comboObj.SetColWidth("150|1|1|1");
    	}   		
	}
	//Attention  event
  	function combo1_OnSelect(comboObj, Index, Text, Code) {
  		search_combo1(comboObj, Index, Code);
  	}
  	
  	function search_combo1(comboObj, Index, Code) {
		var formObj=document.form;
		var cboAttention=comboObjects[0];
		
		var pntNm = "";
		var phnNo = "";
		var faxNo = "";
		var eml   = "";
		
		if (Index != -1) {
			var pntNm = comboObj.GetText(Index, 0);
			var phnNo = comboObj.GetText(Index, 1);
			var faxNo = comboObj.GetText(Index, 2);
			var eml   = comboObj.GetText(Index, 3);
		
			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, pntNm);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no,  phnNo);	//To show the text column
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no,  faxNo);	//To show the text column
			ComSetObjValue(formObj.payr_cntc_pnt_eml,     eml);		//To show the text column
		
			var arrCode = Code.split("^");		//code
			if (arrCode != undefined || arrCode != "") {
				ComSetObjValue(formObj.cust_cntc_pnt_seq, arrCode[1]);
			}
		}
	}
  	/*
  	 * Each common pop-up function calls 
  	 */
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'payer_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  			case 'trucker_cd':
					//ComOpenPopupWithTarget('COM_ENS_0C1.do', 700, 480, "getSvcProvdr", "1,0,1,1,1,1", true);
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 488, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				break;
	  		} // switch-end
  		} // with-end
  	}
    /*
  	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
  	 */
    function getCustCd(aryPopupData) {
    	var formObj=document.form;
    	document.form.payer_cd.value=aryPopupData[0][3];
    	document.form.payer_nm.value=aryPopupData[0][4];
    	//Attention 
    	searchAttentionList();
    	
    	var sCode = "";
    	if(ComGetObjValue(formObj.cust_cntc_pnt_seq) == undefined 
    			|| ComGetObjValue(formObj.cust_cntc_pnt_seq) == null
    			|| ComGetObjValue(formObj.cust_cntc_pnt_seq) == "") {
    		sCode = ComGetObjValue(formObj.cust_cnt_cd)+"^1^"+ComGetObjValue(formObj.cust_seq);
    	}
    	else {
    		sCode = ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComGetObjValue(formObj.cust_seq);
    	}
		//setting
    	if(ComGetObjValue(formObj.payer_cd) == "") {
    		comboObjects[0].SetSelectIndex(-1);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
		}
    	else {
			//Attention Setting
			comboObjects[0].SetSelectCode(sCode);

			if(comboObjects[0].GetSelectCode()== ""){
	    		comboObjects[0].SetSelectIndex(0);
			}
		}
    }    
    /*
  	 * Service Provider Inquiry Common pop-up calls
  	 */
    function getSvcProvdr(aryPopupData) {
    	document.form.trucker_cd.value=aryPopupData[0][2];
    	document.form.trucker_nm.value=aryPopupData[0][4];
    }
    // Payer, Trucker
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    //Payer check
		if(object.name == "payer_cd"){
			//cust_cd
			ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
			var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			if(cust_len == 0){
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.payer_cd, "");
				ComSetObjValue(formObj.payer_nm, "");
				attentionReset();
				return;
			}
			var cre_cnt_cd="";
			//Before Invoice issue
			if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
				//cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
				cre_cnt_cd=ComGetObjValue(formObj.usr_cnt_cd);	//2010.04.04.
			//After Invoice issue
			}else if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
				cre_cnt_cd=ComGetObjValue(formObj.cre_cnt_cd);
			}
			//US : customer + vendor 
			if(cre_cnt_cd == "CA" || cre_cnt_cd == "US"){
				if(cust_len > 2) {
					var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					//If the two-digit alphanumeric code, then Retrieving CUSTOMER
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					// else Retrieving VENDOR
					}else{
						// service provider: only  Detention 
						if(ComGetObjValue(formObj.dmdt_trf_cd).substring(1,2) == 'T'){
							// check TPB Customer by Vendor Code
							ComSetObjValue(formObj.f_cmd, COMMAND22);
				 			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var custSeq=ComGetEtcData(sXml, "CUST_SEQ");
							if (custSeq == "") {
								ComShowCodeMessage("DMT01156");
								ComSetObjValue(formObj.s_cust_gubun, "");
								ComSetObjValue(formObj.s_cust_cd, "");
								ComSetObjValue(formObj.payer_cd, "");
								ComSetObjValue(formObj.payer_nm, "");
								attentionReset();
								return;
							} else {
							ComSetObjValue(formObj.s_cust_gubun, "1");
							}
						} else {
							ComShowCodeMessage("DMT00165", "Payer");
							ComSetObjValue(formObj.s_cust_gubun, "");
							ComSetObjValue(formObj.s_cust_cd, "");
							ComSetObjValue(formObj.payer_cd, "");
							ComSetObjValue(formObj.payer_nm, "");
							attentionReset();
							return;
						}
					}
				} else {
					//service provider: only  Detention 
					if(ComGetObjValue(formObj.dmdt_trf_cd).substring(1,2) == 'T'){
						// check TPB Customer by Vendor Code
						ComSetObjValue(formObj.f_cmd, COMMAND22);
			 			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
						var custSeq=ComGetEtcData(sXml, "CUST_SEQ");
						if (custSeq == "") {
							ComShowCodeMessage("DMT01156");
							ComSetObjValue(formObj.s_cust_gubun, "");
							ComSetObjValue(formObj.s_cust_cd, "");
							ComSetObjValue(formObj.payer_cd, "");
							ComSetObjValue(formObj.payer_nm, "");
							attentionReset();
							return;
						} else {
						ComSetObjValue(formObj.s_cust_gubun, "1");
						}
					} else {
						ComShowCodeMessage("DMT00165", "Payer");
						ComSetObjValue(formObj.s_cust_gubun, "");
						ComSetObjValue(formObj.s_cust_cd, "");
						ComSetObjValue(formObj.payer_cd, "");
						ComSetObjValue(formObj.payer_nm, "");
						attentionReset();
						return;
					}
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
						//ComSetObjValue(formObj.s_cust_gubun, "1");
						ComShowCodeMessage("DMT00165", "Payer");
						ComSetObjValue(formObj.s_cust_gubun, "");
						ComSetObjValue(formObj.s_cust_cd, "");
						ComSetObjValue(formObj.payer_cd, "");
						ComSetObjValue(formObj.payer_nm, "");
						attentionReset();
						return;
					}
				} else {
					//ComSetObjValue(formObj.s_cust_gubun, "1");
					ComShowCodeMessage("DMT00165", "Payer");
					ComSetObjValue(formObj.s_cust_gubun, "");
					ComSetObjValue(formObj.s_cust_cd, "");
					ComSetObjValue(formObj.payer_cd, "");
					ComSetObjValue(formObj.payer_nm, "");
					attentionReset();
					return;
				}
			}
			ComSetObjValue(formObj.f_cmd, formCmd);
 			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
			var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
			var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
			if(cust_nm == null || cust_nm == "") {
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.payer_cd, "");
				ComSetObjValue(formObj.payer_nm, "");
				attentionReset();
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetFocus(formObj.payer_cd);
			}else{
				ComSetObjValue(formObj.payer_cd, cust_cd);
				ComSetObjValue(formObj.payer_nm, cust_nm);
				searchAttentionList();
				var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
				//setting
				if(ComGetObjValue(formObj.payer_cd) == "") {
					comboObjects[0].SetSelectIndex(-1);
					ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
					ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
					ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
				}else{
					//Attention Setting
					comboObjects[0].SetSelectCode(setCode);
					if(comboObjects[0].GetSelectCode()== ""){
						comboObjects[0].SetSelectIndex(0);
//						ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
//						ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
//						ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
					}
				}
			}
		}else if(object.name == "trucker_cd"){
			//vndr_cd
			ComSetObjValue(formObj.vndr_cd, ComGetObjValue(formObj.trucker_cd));
			var vndr_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.vndr_cd)));
			// Change
			if(vndr_len == 0) {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
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
				ComSetFocus(formObj.trucker_cd);
			}else{
				ComSetObjValue(formObj.trucker_cd, vndr_cd);	// Change
				ComSetObjValue(formObj.trucker_nm, vndr_nm);
			}			
		}
        sheetObj.SetWaitImageVisible(1);
    }
    function setComboParameters(sComboAction, sObj) {
    	var formObj=document.form;
    	ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));
    	if(sComboAction == COMMAND13) {
    		ComSetObjValue(formObj.dmdt_sh_tp_cd, 	"I");
    		if(ComGetObjValue(formObj.invoice_issue) == "1") {
    			ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.session_ofc_cd));
    		}else{//ComGetObjValue(formObj.invoice_issue) == "2"
    			ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.cre_ofc_cd));
    		}
    	}else if(sComboAction == COMMAND02) {
    		ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.cre_ofc_cd));
    	}else if(sComboAction == COMMAND14) {
    		ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.cre_ofc_cd));
    	}
    	ComSetObjValue(formObj.f_cmd, sComboAction);
    }
    /**
     * Detail Sheet  amount calculation
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
	function sheet1_OnChange (sheetObj, Row, Col, Value) {
		var formObj=document.form;
		// After search, calculation should not occur.
		if(ComGetObjValue(formObj.invoice_issue) == 1) {
			var sName=sheetObj.ColSaveName(Col);
			var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
			if(sName == "checkBox") {	//checkbox
				if(Value == 1) {
					//Incurrend AMT
					var c_org_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "org_chg_amt"));
					c_org_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_org_chg_amt);
					ComSetObjValue(formObj.mn_org_chg_amt, c_org_chg_amt);
					//Exception AMT
					var c_expt_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "expt_amt"));
					c_expt_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_expt_amt);
					ComSetObjValue(formObj.dmdt_expt_amt, c_expt_amt);
					//Discount AMT
					var c_chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "aft_expt_dc_amt"));
					c_chg_dc_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_chg_dc_amt);
					ComSetObjValue(formObj.chg_dc_amt, c_chg_dc_amt);
					//Billable AMT
					var c_bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "bil_amt"));
					c_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_bil_amt);
					ComSetObjValue(formObj.mn_bil_amt, c_bil_amt);
				}else if(Value == 0) {
					//Incurrend AMT
					var c_org_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "org_chg_amt"));
					c_org_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_org_chg_amt);
					ComSetObjValue(formObj.mn_org_chg_amt, c_org_chg_amt);
					//Exception AMT
					var c_expt_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "expt_amt"));
					c_expt_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_expt_amt);
					ComSetObjValue(formObj.dmdt_expt_amt, c_expt_amt);
					//Discount AMT
					var c_chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "aft_expt_dc_amt"));
					c_chg_dc_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_chg_dc_amt);
					ComSetObjValue(formObj.chg_dc_amt, c_chg_dc_amt);
					//Billable AMT
					var c_bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "bil_amt"));
					c_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_bil_amt);
					ComSetObjValue(formObj.mn_bil_amt, c_bil_amt);
				}
				var iCnt=0;
				for(var i=2; i < sheetObj.GetTotalRows()+2; i++) {
					if(sheetObj.GetCellValue(i,"checkBox") == 1) {
						iCnt++;
					}
				}
				ComSetObjValue(formObj.cntr_cnt, iCnt);
				getExRate();
				setComma();
				if(iCnt == 0){
					ComShowCodeMessage("DMT00169");
					//save비activating 
					ComBtnDisable("btn_save");
				}else{
					//saveactivating 
					ComBtnEnable("btn_save");
				}
			}
		}
	}
	//all selected
    function sheet1_OnClick(sheetObj, row, col, Value){
    	var formObj=document.form;
    	if(ComGetObjValue(formObj.invoice_issue) == "1") {
            if(sheetObj.ColSaveName(col) == "checkBox")
                ComSyncAllCheck(sheetObj, col, Value);
    	}
    }	
	/*
	 * Tool Tip(Issued, Cancelled, Credit)
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y ) {
		//Get the value from the column and row position of the mouse
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		var sName = sheetObj.ColSaveName(sheetObj.MouseCol());
		if (sName == "gb") {
			var sText = sheetObj.GetCellText(Row, Col);
			//Help create a balloon message
			if (Row == 0 || Row == 1) {
				sheetObj.SetToolTipText(Row, Col, "General/Balance Charge Type");
				sheetObj.SetMousePointer("Hand");
			}
			else {
				sheetObj.SetToolTipText(Row, Col, "");
			}
		}
		else {
			sheetObj.SetToolTipText(Row, Col, "");
		}
	}
	/**
	 * If you change the INV Currency, ExRate view and Invoice Amt is calculated.
	 * @return
	 */
	function getExRate() {
		var formObj=document.form;
		var chg_curr_cd=ComGetObjValue(formObj.chg_curr_cd);
		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
		if(chg_curr_cd == "" || inv_curr_cd == "")	return;
		var chg_dc_amt;
		var inv_xch_rt;	
		var tot_amt=0;	
		var dc_amt;		
		var bil_amt;
		var inv_chg_amt;
		var tax_rto;
		var tax_amt;
		var inv_amt;
		
		//var old_inv_xch_rt = ComGetObjValue(formObj.inv_xch_rt);
		//var old_inv_chg_tot;
		//var old_inv_bill_amt;
		var org_bil_amt ;
		
		var tot_bill_amt=0;
		
		//Invoice before, total amount is to obtain the parts.
		if (ComGetObjValue(formObj.invoice_issue) == "1") {
			bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float"));	//Billable AMT
			chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float"));	//Discount AMT
			//
			if (chg_curr_cd == inv_curr_cd) {
				ComSetObjValue(formObj.inv_xch_rt, 1);	//inv_xch_rt=1 
			}
			else {
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
			}			
			inv_xch_rt=ComGetObjValue(formObj.inv_xch_rt);
			inv_xch_rt=ComRound(inv_xch_rt, 6);	//6-digit decimal rounding
			
			for(var i=2 ; i < sheetObjects[0].GetTotalRows()+2 ; i++) {
//				old_inv_chg_tot  = parseFloat(sheetObjects[0].GetCellValue(i, "inv_chg_tot")) / old_inv_xch_rt;
//				old_inv_bill_amt = parseFloat(sheetObjects[0].GetCellValue(i, "inv_bill_amt")) / old_inv_xch_rt;
				org_bil_amt = parseFloat(sheetObjects[0].GetCellValue(i, "bil_amt"));
				
				var invChgTot  = org_bil_amt  * inv_xch_rt;
				var invBillAmt = org_bil_amt * inv_xch_rt;
				
				sheetObjects[0].SetCellValue(i, "inv_chg_tot",  invChgTot);
				sheetObjects[0].SetCellValue(i, "inv_bill_amt", invBillAmt);
				
				if (sheetObjects[0].GetCellValue(i, "checkBox") == 1) {
					tot_amt += parseFloat(sheetObjects[0].GetCellValue(i, "inv_chg_tot"));
					tot_bill_amt += parseFloat(sheetObjects[0].GetCellValue(i, "inv_bill_amt"));
				}
			}
			//tot_amt 	= tot_amt * inv_xch_rt;
			tot_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_amt);
			//billing amt 
			inv_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_bill_amt);
			//dc_amt
			dc_amt=tot_amt - tot_bill_amt;
			dc_amt=DMTtrimCurrencyAmount(inv_curr_cd, dc_amt);
			ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
			ComSetObjValue(formObj.tot_amt, tot_amt);
			ComSetObjValue(formObj.dc_amt, dc_amt);
			ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);			
		}
		else {
			inv_chg_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float");
		}
		//tax 
		tax_rto=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_rto_dis),"float")); //Tax Rate
		var cre_cnt_cd="";
		//Before Invoice issue
		if (ComGetObjValue(formObj.invoice_issue) == "1") {
			//cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
			cre_cnt_cd=ComGetObjValue(formObj.usr_cnt_cd);	//2010.04.04.
			//After Invoice issue
		}
		else if (ComGetObjValue(formObj.invoice_issue) == "2") {
			cre_cnt_cd=ComGetObjValue(formObj.cre_cnt_cd);
		}
		//If Vietnam
//		if (cre_cnt_cd == "VN") {
//			tax_amt=(inv_chg_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//		}
		//=========================================
		//2015.10.27 #7995 comment start
		//2017.01.12 #23259 India Invocie
		if(cre_cnt_cd == "IN"){

			var ida_expn_tax_rt     = parseFloat(ComGetObjValue(formObj.ida_expn_tax_rt));
			var ida_edu_tax_rt      = parseFloat(ComGetObjValue(formObj.ida_edu_tax_rt));
			var ida_high_edu_tax_rt = parseFloat(ComGetObjValue(formObj.ida_high_edu_tax_rt));
			var ida_expn_tax = 0;
			var ida_edu_tax = 0;
			var ida_high_edu_tax = 0;
			 
			// Service Tax
			//ida_expn_tax = multiplyFloat( inv_chg_amt, ida_expn_tax_rt);
			 ida_expn_tax = ComRound( (inv_chg_amt * ida_expn_tax_rt * 0.01), 2 )
			 ComSetObjValue(formObj.ida_expn_tax, ida_expn_tax);
			
			// Education Cess
			//ida_edu_tax = multiplyFloat(ida_expn_tax, ida_edu_tax_rt);
			 ida_edu_tax = ComRound( (ida_expn_tax * ida_edu_tax_rt * 0.01), 2 )
			 ComSetObjValue(formObj.ida_edu_tax, ida_edu_tax);
			
			// Higher Edu Cess
			//ida_high_edu_tax = multiplyFloat(ida_edu_tax, ida_high_edu_tax_rt);
			 ida_high_edu_tax = ComRound( (ida_expn_tax * ida_high_edu_tax_rt * 0.01), 2 )
			 ComSetObjValue(formObj.ida_high_edu_tax, ida_high_edu_tax);
			
			// Total Service Tax
			tax_amt = parseFloat(ida_expn_tax) + parseFloat(ida_edu_tax) + parseFloat(ida_high_edu_tax) ;
		}
		//2015.10.27 #7995 comment e n d
		//=========================================	
		else {
			tax_amt=(tax_rto * 0.01) * inv_chg_amt;
		}
		
		tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tax_amt);
		inv_amt=parseFloat(inv_chg_amt) + parseFloat(tax_amt);
		inv_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_amt);
		
		//Rounding, cut-off handling
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		//SETCOMMA
		setComma();
	}
	/**
	 * Check Tax Rate
	 */
	function setTax(){
		var formObj=document.form;
		if (formObj.chk_tax.checked) {
			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
		}
		else {
			ComSetObjValue(formObj.tax_rto_dis, "0");
		}
		getExRate();
		setComma();
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * SheetOption pop-up screen automatically changes the processing logic in the change(Due Date, Credit Term, Tax Rate)
	 */
	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
		var formObj=document.form;
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
					if(d_is_dt_prn_flg == "Y"){
						//Current date
						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
						//Date '-' handling
						ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
						//0
						ComSetObjValue(formObj.cr_term_dys, "0");
					}else if(d_is_dt_prn_flg == "N") {
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
					if(d_is_dt_prn_flg == "Y"){
						//Invoice issue date
						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.cre_dt));
						//0
						ComSetObjValue(formObj.cr_term_dys, "0");
					}else if(d_is_dt_prn_flg == "N") {
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
		//
		if(formObj.chk_tax.checked) {
			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
			//tax calculate
			getExRate();
			setComma();
		}
		//searchSeetOption
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND14,"","");
	}
	////////////////////////////////////////////////////////////////////////
	/**
	 * PayerInfo pop-up screen, the changes are processed automatically change
	 */
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
		var formObj=document.form;
		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
		searchAttentionList();
		var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
		//setting
		if(ComGetObjValue(formObj.payer_cd) == "") {
			comboObjects[0].SetSelectCode(-1);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
			ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
		}else{
			//Attention Setting
			comboObjects[0].SetSelectCode(setCode);
			if(comboObjects[0].GetSelectCode()== ""){
				ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
				ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
				ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
				ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
			}
		}
	}
	//input value activating
	function object_enable(){
		var formObj=document.form;
		//payer
		ComEnableObject(formObj.payer_cd, true);
		ComEnableObject(formObj.btn_payer_cd, true);
		formObj.payer_cd.className="input1";
		//attention
		for(var i=0 ; i < comboObjects.length ; i++) {
			comboObjects[i].SetEnable(1);
		}
		//trucker
		ComEnableObject(formObj.trucker_cd, true);
		ComEnableObject(formObj.btn_trucker_cd, true);
		//invoie remark
		ComEnableObject(formObj.inv_rmk1, true);
		ComEnableObject(formObj.inv_rmk2, true);
//		formObj.inv_rmk1.className="noinput";
//		formObj.inv_rmk2.className="noinput";
		//notice
		ComEnableObject(formObj.ntc_knt_cd, true);
		//ref
		ComEnableObject(formObj.inv_ref_no, true);
		//tax_rate
		ComEnableObject(formObj.chk_tax, true);
	}
	//input value  deactivating
	function object_disable(){
		var formObj=document.form;
		//payer
		ComEnableObject(formObj.payer_cd, false);
		ComEnableObject(formObj.btn_payer_cd, false);
		formObj.payer_cd.className="input2";
		//attention
		for(var i=0 ; i < comboObjects.length ; i++) {
			comboObjects[i].SetEnable(0);
		}
		//trucker
		ComEnableObject(formObj.trucker_cd, false);
		ComEnableObject(formObj.btn_trucker_cd, false);
		//invoie remark
		ComEnableObject(formObj.inv_rmk1, false);
		ComEnableObject(formObj.inv_rmk2, false);
		formObj.inv_rmk1.className="noinput2";
		formObj.inv_rmk2.className="noinput2";
		//notice
		ComEnableObject(formObj.ntc_knt_cd, false);
		//ref
		ComEnableObject(formObj.inv_ref_no, false);
		//tax_rate
		ComEnableObject(formObj.chk_tax, false);
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSAVE:
    				if(ComGetObjValue(formObj.payer_cd) == "") {
    					ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01052"));
						return false;
    				}
    		        // Compare payer with rep cust seq
    		        if (ComTrim(ComGetObjValue(formObj.payer_cd)) == ComTrim(ComGetObjValue(formObj.rep_cust_seq))) {
    		        	ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01157"));
    		        	return false;
    		        }
    				//The INVOICE AR-interface has been completed, it can not be modified, and  the message should show.
    				if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "Y") {
    					ComShowCodeMessage("DMT03022");
    					return false;
    				}
    				//invoice cur is not exist --> error
    				if(ComGetObjValue(formObj.inv_curr_cd) == ""){
    					ComShowCodeMessage("DMT02002" , "INV Cur.");
    					return false;
    				}
    				break;
    			case IBARIF:
    				//if((ComGetObjValue(formObj.session_cnt_cd) != "US") && (ComGetObjValue(formObj.session_cnt_cd) != "CA")) {
    				if((ComGetObjValue(formObj.usr_cnt_cd) != "US") && (ComGetObjValue(formObj.usr_cnt_cd) != "CA")) {	//2010.04.04.
    					if(ComGetObjValue(formObj.payer_cd).length <= 6) {
    						ComShowCodeMessage("DMT00185");
        					return false;
    					}
    				}
    				break;
    		}
        }
        return true;
    }
    function dmtGetMsgText(xmlStr){
        try {
        	return ComGetSelectSingleNode(xmlStr, "MESSAGE");
        	/*
        	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(xmlStr);
            var xmlRoot=xmlDoc.documentElement;
            if(xmlRoot == null) return;
            var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
            if(msgNode == null) 
             return;
            else
             return msgNode.firstChild.nodeValue;*/
       } catch(err) { ComFuncErrMsg(err.message); }
    }    
    function unLoadPage() {
		window.returnValue="Y";
    }

    function callbackProc(rtnVal) {
    	if (rtnVal == "Y") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
    }
    