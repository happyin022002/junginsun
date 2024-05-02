/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_4004.js
*@FileTitle  : Manual Invoice Creation & Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code added code to make a good  JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
     * @author Hanjin Shipping
     */
    /**
     * @extends 
     * @class DEM/DET Adjustment Request - After Booking Request for generating business from the screen using a script is defined.
     */
    
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;	
	// RD
//	var rdObjects=new Array();
//	var rdCnt=0;
	var queryStr="";
	//Action
	var IBSEARCH_INIT=100;
	var IBSEARCH_CHG_CURR=101;
	var IBSEARCH_CHECK_BKGNO=102;
	var IBSEARCH_BKG_CHG=103;
	var IBSEARCH_CHECK_CNTRNO=104;
	var IBSEARCH_CALLPORT=105;
	var IBSEARCH_EX_RATE=106;
	var IBSEARCH_ARIF=107;
	var IBSEARCH_ATTL=108;
	var IBSEARCH_LOC=119;
	var IBSEARCH_CHECK_VVD=110;
	var IBSEARCH_SEND_FAX=111;
	var IBSEARCH_SEND_EMAIL=112;
	var IBSEARCH_CHECK_SHEETSET=113;
	var IBSEARCH_PAYER_EMLFAX=114;
	var IBSEARCH_SHEET_OPT=115;
	var IBSEARCH_DYS_BETWEEN=116;
	//business global variables
	var ROWMARK="|";
	var FIELDMARK="=";
	var SYS_AREA_GRP_ID="sys_area_grp_id";
	var CNTR_NO="cntr_no";
	var CNTR_CYC_NO="cntr_cyc_no";
	var DMDT_TRF_CD="dmdt_trf_cd";
	var DMDT_CHG_LOC_DIV_CD="dmdt_chg_loc_div_cd";
	var CHG_SEQ="chg_seq";
	var CNTR_TPSZ_CD="cntr_tpsz_cd";
	var FM_MVMT_DT="fm_mvmt_dt";
	var TO_MVMT_DT="to_mvmt_dt";
	var FT_CMNC_DT="ft_cmnc_dt";
	var FT_END_DT="ft_end_dt";
	var FT_DYS="ft_dys";
	var PAYER_CD="act_payr_cust_cd";
	var PAYER_NM="act_payr_cust_nm";
	var TRUCKER_CD="vndr_seq";
	var TRUCKER_NM="vndr_nm";
	var FT_OVR_DYS="ft_ovr_dys";
	var FT_UND_DYS="ft_und_dys";
	var BZC_CURR_CD="bzc_curr_cd";
	var INV_RT_AMT="inv_rt_amt";
	var RT_OVR_DYS="rt_ovr_dys";
	var RT_OVR_CHG_AMT="rt_ovr_chg_amt";
	var INV_NO="dmdt_inv_no";
	var CRE_OFC_CD="cre_ofc_cd";
	var INV_DTL_SEQ="inv_dtl_seq";
	var INV_RT_SEQ="inv_rt_seq";
	var DEL_FLAG="del_flag";
	var IBSHEET_HEIGHT=82;
	var currDtlSeq="";
	// 취소버튼에서 이벤트를 발생시켰는지 구분하기 위한 전역변수
	var isCancelAction = false;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_AddCharge":
					if (ComIsBtnEnable(srcName)) 
						doActionAddCharge();
					break;
				case "btn_CopyCharge":
					if (ComIsBtnEnable(srcName)) 
						doActionCopyCharge();
					break;
				case "btn_DelCharge":
					if (ComIsBtnEnable(srcName)) 
						doActionDelCharge();
					break;
				case "btn_InqMVMT":
					if (ComIsBtnEnable(srcName)) 
						doProcessPopup(srcName);
					break;
	            case "btn_PayerCd":
	            	if (isCanOpenPopupWin(srcName))
	            		doProcessPopup(srcName);
					break;
	            case "btn_TruckerCd":
	            	if (isCanOpenPopupWin(srcName))
	            		doProcessPopup(srcName);
	            	break;
 				case "btn_SheetSet":
 					if (ComIsBtnEnable(srcName)) 
 						doProcessPopup(srcName);
 					break;
 				case "btn_SheetOption":
 					if (ComIsBtnEnable(srcName))
 						doProcessPopup(srcName);
 					break;
				case "btn_SendingHistory":
					if (ComIsBtnEnable(srcName))
						doProcessPopup(srcName);
					break;
				case "btn_CRemark":
					if (ComIsBtnEnable(srcName))
						showRemarkMessage(srcName);
					break;
				case "btn_HRemark":
					if (ComIsBtnEnable(srcName))
						showRemarkMessage(srcName);
					break;
				case "btn_DataDisplay":
					if (ComIsBtnEnable(srcName)) 
						doActionDisplayData();
					break;					
				case "btn_New":
					if (ComIsBtnEnable(srcName)) 
						doActionNew();
					break;
				case "btn_Minimize":
					if (ComIsBtnEnable(srcName)) 
						doActionMinimize();
					break;
				case "btn_Save":
					if (ComIsBtnEnable(srcName)) { 
		        		if(ComGetObjValue(formObj.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Save");
		        			return;
		        		}
						if (ComGetObjValue(formObj.suth_chn_iss_flg) == "Y") {
							ComShowCodeMessage("DMT01108", "save");
							return;
						}
						doActionSave();
					}
					break;
				case "btn_Cancel":
					if (ComIsBtnEnable(srcName)) { 
		        		if(ComGetObjValue(formObj.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Cancel");
		        			return;
		        		}
						if (ComGetObjValue(formObj.suth_chn_iss_flg) == "Y") {
							ComShowCodeMessage("DMT01108", "cancel");
							return;
						}
						doProcessPopup(srcName);
					}
					break;
				case "btn_Preview":
					if (ComIsBtnEnable(srcName)) {
						//Sheet Set 이 없으면 alert 메시지 처리
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						//Preview, Print 할때 PayerCode가 없으면 alert 메시지 처리
						if (ComGetObjValue(formObj.payerCd) == "") {
							ComShowCodeMessage("DMT02002");
							return;
						}
						doProcessPopup(srcName);
					}
					break;
				case "btn_InvPrint":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						if (ComGetObjValue(formObj.payerCd) == "") {
							ComShowCodeMessage("DMT02002");
							return;
						}		
						initRdConfig();
						rdOpen(formObj);
					}
					break;
				case "btn_Fax":
					if (ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}						
						doActionFax();
						doProcessPopup(srcName);
					}
					break;
				case "btn_Email":
					if (ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}						
						doActionEmail();
						doProcessPopup(srcName);
					}
					break;
				case "btn_Arif":
					if(ComIsBtnEnable(srcName)){
		        		if(ComGetObjValue(formObj.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "A/R I/F");
		        			return;
		        		}
						doActionARIF();
					}
					break;
				case "btn_PayerInfo":
					if(ComIsBtnEnable(srcName))
						doProcessPopup(srcName);
					break;
				case "btn_Close":
					doActionClose();
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
   	/** 
  	 *Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
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
    	var formObj=document.form;
       	var sheetObj=sheetObjects[0];
       /* if(isPopupWindow()) {
	        var spanObj=document.getElementById("title2");
	       	spanObj.innerText=" Manual Invoice Creation & Issue";
	       	btnCloseLayer.style.display="inline";	       	
	   	}*/
        for (i=0 ; i < sheetObjects.length ; i++) {
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initAxonControl();
	    for (var k=0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k], k+1);
	    }
		doActionIBSheet(sheetObj, formObj, IBSEARCH_INIT);
		initBtnMain();
        doActionNew();	    
    }
   /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
				with(sheetObj){
					var HeadTitle1="|Seq.|CNTR No.|T/S|From DT|To DT|F/T CMNC|F/T End|F/D";
					var headCount=ComCountHeadTitle(HeadTitle1) + 9;
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:CNTR_NO,                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
					  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:CNTR_TPSZ_CD,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:FM_MVMT_DT,             KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:TO_MVMT_DT,             KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:FT_CMNC_DT,             KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:FT_END_DT,              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:FT_DYS,                 KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:BZC_CURR_CD,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:INV_NO,                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:CRE_OFC_CD,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:INV_DTL_SEQ,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:SYS_AREA_GRP_ID,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:CNTR_CYC_NO,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:DMDT_TRF_CD,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:DMDT_CHG_LOC_DIV_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:CHG_SEQ,                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					    
					InitColumns(cols);
					SetSheetHeight(100);
					SetEditable(1);
					SetShowButtonImage(2);
					SetCountPosition(0);
				}
                 break;
             case 2:      // sheet2 init
				with (sheetObj) {
					var HeadTitle1="|From|Up To|Rate|Over|Billable AMT";
					var headCount=ComCountHeadTitle(HeadTitle1) + 6;
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:FT_OVR_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
					{Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:FT_UND_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					{Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:INV_RT_AMT,        KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:RT_OVR_DYS,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:RT_OVR_CHG_AMT,    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:BZC_CURR_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:INV_NO,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:CRE_OFC_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:INV_DTL_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:INV_RT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:DEL_FLAG,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					  
					InitColumns(cols);
					SetSheetHeight(100);
					SetEditable(1);
					SetCountPosition(0);
				}
                 break;
             case 3:
             	with (sheetObj) {
//                     // height setting
//                     SetSheetHeight(102);
//                     // entire width setting
//                     SheetWidth=mainTable.clientWidth;
//                     //Set Host Information [required][HostIp, Port, PagePath]
//                     //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//                     //Kind of full-Merge [option, Default msNone]
//                     MergeSheet=msHeaderOnly;
//                    //Whether to allow a full Edit [option, Default false]
//                     SetEditable(1);
//                     //Setting row information [required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                     InitRowInfo( 2, 1, 2, 100);
//                     var HeadTitle="";
// 					 var headCount=ComCountHeadTitle(HeadTitle);
//                     //Set column information [required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                     (headCount, 0, 0, true);
//                     // various functions that can be processed by the header is set
//                     InitHeadMode(true, true, true, true, false, false)
//                     //Header row information [required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                     InitHeadRow(0, HeadTitle, true);
// 					SetCountPosition(0);
                 }
                 break;                 
         }
    }
    function initAxonControl() {
   		//axon_event.addListenerFormat('keypress','obj_keypress', document.form);     	 
//  		axon_event.addListener('mouseover', 'obj_mouseover', 	'txt_Remark',	'btn_CRemark',	'btn_HRemark', 'tdInclCNTRDetail', 'btn_DataDisplay');	// onMouseover event
//  		axon_event.addListener('mouseout', 	'obj_mouseout', 	'txt_Remark',	'btn_CRemark',	'btn_HRemark', 'tdInclCNTRDetail', 'btn_DataDisplay');	// onMouseout event
		axon_event.addListener('mouseover', 'obj_mouseover', 	'txt_Remark',	'btn_CRemark',	'tdInclCNTRDetail', 'btn_DataDisplay');	// onMouseover event
		axon_event.addListener('mouseout', 	'obj_mouseout', 	'txt_Remark',	'btn_CRemark',	'tdInclCNTRDetail', 'btn_DataDisplay');	// onMouseout event
  		axon_event.addListener('keydown', 	'ComKeyEnter', 		'form');
//  		axon_event.addListener('change',	'obj_change', 'bkgNo', 'blNo', 'vvdCd', 'porCd', 'polCd', 'podCd', 'delCd');
//		axon_event.addListenerFormat('focus',	'obj_focus',	form);
		axon_event.addListenerFormat('blur',	'obj_blur',		form);
    }
    function obj_blur(){
    	var obj=ComGetEvent();
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var cboAttention=comboObjects[1];
    	switch(ComGetEvent("name")) {
	    	case "payerCd":
	    		doActionText(sheetObj, formObj, obj, SEARCH20);
	    		if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
		    		searchAttentionList();
		    		if (cboAttention.GetItemCount() > 0) {
		    			cboAttention.SetSelectIndex(0);
		    		}
	    		}
	    		break;
	    	case "truckerCd":
	    		doActionText(sheetObj, formObj, obj, SEARCHLIST04);
	    		break;
	    	case "totalAmt":
	    	case "dcAmtRate":
	    	case "billingAmt":	    		
	    			doCalculate();
	    			break;
	    	default:
	    		ComChkObjValid(obj);
    	}
    }      
	function obj_keypress() {
		var formObj=document.form;
		switch(ComGetEvent("dataformat")){
			case "engup":
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
          		DmtComKeyOnlyAlphabet('uppernum', ',');
 		        break;
          	case "int":
     	        ComKeyOnlyNumber(ComGetEvent());
     	        break;
        	case "float":
        		ComKeyOnlyNumber(ComGetEvent(), ".");
        		break;
        	case "float2":
        		ComKeyOnlyNumber(ComGetEvent(), ".-");        		
        		break;     	        
          	default:
 	            ComKeyOnlyNumber(ComGetEvent());
		}
	}
	function obj_change() {
 		var obj=ComGetEvent("name");
		var formObj=document.form;
		var sheetCHGObj=sheetObjects[0];
		with(formObj) {
			if (ComGetEvent("name")== "bkgNo") {
				if (ComTrim(ComGetObjValue(bkgNo)) == "") {
					ComSetObjValue(blNo, "");
				}
				else if (ComTrim(ComGetObjValue(bkgNo)).length < 5) {
					ComShowCodeMessage("DMT00171", "BKG No. length!");
					ComSetObjValue(bkgNo, "");
					ComSetObjValue(blNo, "");
					ComSetFocus(bkgNo);
				}
				else {
					ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.bkgNo));
					ComSetObjValue(formObj.bl_no, "");
					doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_CHECK_BKGNO);
				}
			}
			else if (obj.name == "blNo") {
				if (ComTrim(ComGetObjValue(blNo)) == "") {
					ComSetObjValue(bkgNo, "");
				}
				else if (ComTrim(ComGetObjValue(blNo)).length < 5) {
					ComShowCodeMessage("DMT00171", "B/L No. length");
					ComSetObjValue(bkgNo, "");
					ComSetObjValue(blNo, "");
					ComSetFocus(blNo);
				}				
				else {
					ComSetObjValue(formObj.bkg_no, "");
					ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.blNo));					
					doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_CHECK_BKGNO);
				}
			}
			else if (obj.name == "vvdCd") {
				if (ComGetObjValue(formObj.vvdCd) != "" && ComGetObjValue(formObj.vvdCd).length != 9) {
					ComShowCodeMessage("DMT00165", "VVD CD");
					ComClearObject(formObj.vvdCd);
					ComSetFocus(formObj.vvdCd);
				}
			}
			else if (obj.name == "porCd") {
				if (ComGetObjValue(formObj.porCd) != "" && ComGetObjValue(formObj.porCd).length != 5) {
					ComShowCodeMessage("DMT00165", "Location");
					ComClearObject(formObj.porCd);
					ComSetFocus(formObj.porCd);
				}
			}
			else if (obj.name == "polCd") {
				if (ComGetObjValue(formObj.polCd) != "" && ComGetObjValue(formObj.polCd).length != 5) {
					ComShowCodeMessage("DMT00165", "Location");
					ComClearObject(formObj.polCd);
					ComSetFocus(formObj.polCd);
				}
			}
			else if (obj.name == "podCd") {
				if (ComGetObjValue(formObj.podCd) != "" && ComGetObjValue(formObj.podCd).length != 5) {
					ComShowCodeMessage("DMT00165", "Location");
					ComClearObject(formObj.podCd);
					ComSetFocus(formObj.podCd);
				}
			}
			else if (obj.name == "delCd") {
				if (ComGetObjValue(formObj.delCd) != "" && ComGetObjValue(formObj.delCd).length != 5) {
					ComShowCodeMessage("DMT00165", "Location");
					ComClearObject(formObj.delCd);
					ComSetFocus(formObj.delCd);
				}
			}			
		}
	}
 	function obj_mouseover() {
  		var msg='';
 		var x=event.x+document.body.scrollLeft;
 		var y=event.y+document.body.scrollTop;
 		var skn=document.all("topdeck").style;
      	switch(ComGetEvent("id")){
 	  		case 'txt_Remark':
 	  			msg='Invoice Remark will be included in the Invoice Sheet';
 	  			x=x;
 	  			y=y-20;
 	  			skn.left=x;
 	  			skn.top=y+20;
 	  			break;
 	  		case 'btn_CRemark':
 	  			msg='Invoice Cancel Remark';
 	  			x=x-20;
 	  			y=y-20;
 	  			skn.left=x;
 	  			skn.top=y+20;
 	  			break;
 	  		case 'btn_HRemark':
 	  			msg='Invoice Hold Remark';
 	  			x=x-20;
 	  			y=y-20;
 	  			skn.left=x;
 	  			skn.top=y+20;
 	  			break;
 	  		case 'btn_DataDisplay':
	  			msg='BKG Data and Charge in Deleted or Error status will be displayed';
	  			x=x-20;
	  			y=y-20;
	  			skn.left=x;
	  			skn.top=y+20;
	  			break;
 	  		case 'tdInclCNTRDetail':
 	  			msg='If No, CNTR Detail cannot be input and print/fax/e-mail will be blocked';
 	  			x=x-20;
 	  			y=y-60;
 	  			skn.left=x;
 	  			skn.top=y+20;
 	  			break; 	  			
      	}
 		var bak='lightyellow';
 		var content="<TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
    	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE>"; 
 		document.all("topdeck").innerHTML=content;
 		skn.visibility='visible';
     }
 	function obj_mouseout() {
 		var skn=document.all("topdeck").style;
 		skn.visibility='hidden';
 	}
  	function initCombo(comboObj, comboNo) {
  	    var formObj=document.form
  	    comboObj.SetEnable(0);
  	    switch(comboNo) {
  	    	//Tariff Type
  	    	case 1:
  	    		with(comboObj) {
  					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
  					SetDropHeight(160);
  	    		}
  	    		break;
  		    //Attention
	    	case 2:
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
	// Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
//        var cboTariff=comboObjects[0];
//        var cboAttention=comboObjects[1];
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
        switch(sAction) {
	        case IBSEARCH_INIT:
				ComSetObjValue(formObj.f_cmd, 		COMMAND02);
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				tariffList=ComGetEtcData(sXml, "TARIFF").replace("All=All|", "");
				addMultiComboItem(cboTariff, tariffList.split(ROWMARK));
				//3-2.Manual Invoice Reason
				mnlInvRsnList=" " + FIELDMARK + " " + ROWMARK + ComGetEtcData(sXml, "INV_RSN");
				addComboItem(formObj.reason, mnlInvRsnList, false, true);
				//3-3.Current Date
				ComSetObjValue(formObj.ofc_curr_date, setDataFormat(ComGetEtcData(sXml, "OFC_CURR_DAY")));
				//3-4.Receive Term
				ComClearCombo(formObj.rcvTermCd);
				rcvTermList=" " + FIELDMARK + " " + ROWMARK + ComGetEtcData(sXml, "RCV_TERM");
				addComboItem(formObj.rcvTermCd, rcvTermList, false, true);
				//3-5.Delivery Term
				ComClearCombo(formObj.deTermCd);
				deTermList=" " + FIELDMARK + " " + ROWMARK + ComGetEtcData(sXml, "DE_TERM");
				addComboItem(formObj.deTermCd, deTermList, false, true);
				//3-6.User Country Code
				ComSetObjValue(formObj.usr_cnt_cd,  ComGetEtcData(sXml, "USR_CNT_CD"));
				//3-7.Invoice Currency
				ComClearCombo(formObj.invoiceCurrency);
				invCurrList=ComGetEtcData(sXml, "AR_CURRENCY");
				addComboItem(formObj.invoiceCurrency, invCurrList, true);
				//========================================================================================
				
				//=========================================
				//2015.10.27 #7995 comment start
				//2017.01.12 #23259 India Invocie
            	//India GST Tax
            	if(formObj.usr_cnt_cd.value =="IN"){
            	   ComSetObjValue(formObj.ida_expn_tax_rt,  ComGetEtcData(sXml, "IDA_EXPN_TAX_RT"));
            	   ComSetObjValue(formObj.ida_edu_tax_rt,  ComGetEtcData(sXml, "IDA_EDU_TAX_RT"));
            	   ComSetObjValue(formObj.ida_high_edu_tax_rt,  ComGetEtcData(sXml, "IDA_HIGH_EDU_TAX_RT"));
            	}
            	//2015.10.27 #7995 comment e n d
            	//=========================================	
				//3-6.User Country Code
				ComSetObjValue(formObj.rep_cust_seq,  ComGetEtcData(sXml, "REP_CUST_SEQ"));
            	
	        	break;
        	case IBSEARCH:     
        		with(formObj) {
					ComSetObjValue(f_cmd, 		SEARCH);
					ComSetObjValue(dmdt_inv_no, ComGetObjValue(invoiceNo));
        		}
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetCHGObj.SetWaitImageVisible(0);
				sheetRTObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            cboTariff.SetSelectText(setDataFormat(ComGetEtcData(arrXml[0], "DMDT_TRF_CD")));
	            with(formObj) {
	            	ComSetObjValue(issueDate, 		setDataFormat(ComGetEtcData(arrXml[0], "ISSUE_DT")));
	            	ComSetObjValue(issueOfcCd, 		setDataFormat(ComGetEtcData(arrXml[0], "ISSUE_OFC")));
	            	ComSetObjValue(issueName, 		setDataFormat(ComGetEtcData(arrXml[0], "ISSUE_NM")));
	            	ComSetObjValue(dmdt_inv_sts_cd, setDataFormat(ComGetEtcData(arrXml[0], "DMDT_INV_STS_CD")));
	            	ComSetObjValue(status, 			setDataFormat(ComGetEtcData(arrXml[0], "DMDT_INV_STS_DESC")));
	            	ComSetObjValue(arIf, 			setDataFormat(ComGetEtcData(arrXml[0], "ARIF")));
	            	ComSetObjValue(arIfDate, 		setDataFormat(ComGetEtcData(arrXml[0], "ARIF_DT")));
	            	ComSetObjValue(arIfOfc, 		setDataFormat(ComGetEtcData(arrXml[0], "ARIF_OFC")));
	            	ComSetObjValue(arIfName, 		setDataFormat(ComGetEtcData(arrXml[0], "ARIF_NM")));
	            	ComSetObjValue(arIfId,			setDataFormat(ComGetEtcData(arrXml[0], "ARIF_ID")));
	            	ComSetObjValue(rhq_ofc_cd,		setDataFormat(ComGetEtcData(arrXml[0], "RHQ_OFC_CD")));
	            	
	            	//Credit Note
	            	ComSetObjValue(creditNote, 		setDataFormat(ComGetEtcData(arrXml[0], "CR_INV_NO")));
	            	if (ComGetObjValue(dmdt_inv_sts_cd) == "C") {
	            		creditNoteCaption.innerHTML="Reference";
	            	}
	            	else {
	            		creditNoteCaption.innerHTML="Credit Note";
	            	}
	            	if (ComGetObjValue(dmdt_inv_sts_cd) == "C" || ComGetObjValue(dmdt_inv_sts_cd) == "X") {
	            		var crArIfCd=setDataFormat(ComGetEtcData(arrXml[0], "CR_AR_IF_CD"));
            			ComSetObjValue(creditNoteArIf, 	"(A/R:" + crArIfCd + ")");	  	            	
	            	}
	            	ComSetObjValue(bkgNo, 			setDataFormat(ComGetEtcData(arrXml[0], "BKG_NO")));
	            	ComSetObjValue(blNo, 			setDataFormat(ComGetEtcData(arrXml[0], "BL_NO")));
	            	ComSetObjValue(incCntrDtail, 	setDataFormat(ComGetEtcData(arrXml[0], "INC_CNTR_DTL")));
	            	ComSetObjValue(vvdCd, 			setDataFormat(ComGetEtcData(arrXml[0], "VVD_CD")));
	            	ComSetObjValue(porCd, 			setDataFormat(ComGetEtcData(arrXml[0], "POR_CD")));
	            	ComSetObjValue(polCd, 			setDataFormat(ComGetEtcData(arrXml[0], "POL_CD")));
	            	ComSetObjValue(podCd, 			setDataFormat(ComGetEtcData(arrXml[0], "POD_CD")));
	            	ComSetObjValue(delCd, 			setDataFormat(ComGetEtcData(arrXml[0], "DEL_CD")));
	            	//R/D
	            	ComSetObjValue(rcvTermCd, 		setDataFormat(ComGetEtcData(arrXml[0], "RCV_TERM_CD")));
	            	ComSetObjValue(deTermCd, 		setDataFormat(ComGetEtcData(arrXml[0], "DE_TERM_CD")));
	            	//BKG Cust.
	            	ComSetObjValue(bkgCustCd, 		setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_CD")));
	            	ComSetObjValue(bkgCustNm, 		setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_NM")));
	            	//A/R Cust.
	            	ComSetObjValue(arCustCd, 		setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_CD")));
	            	ComSetObjValue(arCustNm, 		setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_NM")));
	            	//Payer.
	            	ComSetObjValue(payerCd, 		setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_CD")));
	            	ComSetObjValue(payerNm, 		setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM")));
	            	//ComSetObjValue(act_payr_cust_nm2, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM2")));	// E-mail Send용 Customer Name
	            	//Attention
	            	ComSetObjValue(dmdt_payr_cntc_pnt_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "DMDT_PAYR_CNTC_PNT_NM")));
	            	ComSetObjValue(cust_cntc_pnt_seq, 		setDataFormat(ComGetEtcData(arrXml[0], "CUST_CNTC_PNT_SEQ")));
	            	//Trucker
	            	ComSetObjValue(truckerCd, 		setDataFormat(ComGetEtcData(arrXml[0], "VNDR_SEQ")));
	            	ComSetObjValue(truckerNm, 		setDataFormat(ComGetEtcData(arrXml[0], "VNDR_NM")));
	            	//Due Date, Credit Term
	            	if (ComGetObjValue(incCntrDtail) == "Y") {
	            		ComSetObjValue(dueDate, 	setDataFormat(ComGetEtcData(arrXml[0], "DUE_DATE")));
	            		ComSetObjValue(creditTerm, 	setDataFormat(ComGetEtcData(arrXml[0], "CR_TERM_DYS")));
	            	}
	            	else {
	            		ComSetObjValue(dueDate, 	"");
		            	ComSetObjValue(creditTerm, 	"");
	            	}
	            	//Notice
	            	ComSetObjValue(notice, 			setDataFormat(ComGetEtcData(arrXml[0], "NOTICE")));
	            	//Cust. Ref.
	            	ComSetObjValue(custRef, 		setDataFormat(ComGetEtcData(arrXml[0], "INV_REF_NO")));
	            	//Invoice Remark(s)
	            	ComSetObjValue(invoiceRemark1, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_RMK1")));
	            	ComSetObjValue(invoiceRemark2, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_RMK2")));
	            	//Charge Currency
	            	var chgCurrCd=setDataFormat(ComGetEtcData(arrXml[0], "CHG_CURR_CD"));
	            	if (chgCurrCd != "") {
	            		chgCurrCd += FIELDMARK + chgCurrCd;
	            		addComboItem(formObj.chargeCurrency,chgCurrCd,true);
	            	}
	            	//Invoice Currency
	            	var invCurrCd=setDataFormat(ComGetEtcData(arrXml[0], "INV_CURR_CD"));
	            	if (invCurrCd != "") {
	            		invCurrCd += FIELDMARK + invCurrCd;
	            		ComClearCombo(formObj.invoiceCurrency);
	            		addComboItem(formObj.invoiceCurrency,invCurrCd,true);
	            	}
	            	//CNTR Q’ty
					ComSetObjValue(cntrQty, 		setDataFormat(ComGetEtcData(arrXml[0], "BKG_CNTR_QTY"), "AMT"));        	
	            	//Ex. Rate
	            	ComSetObjValue(exRate, 			setDataFormat(ComGetEtcData(arrXml[0], "INV_XCH_RT"), "EX_RATE"));
	            	//Total AMT
	            	ComSetObjValue(totalAmt, 		setDataFormat(ComGetEtcData(arrXml[0], "BIL_AMT"), "AMT"));
	            	//Billing AMT
	            	ComSetObjValue(billingAmt, 		setDataFormat(ComGetEtcData(arrXml[0], "INV_CHG_AMT"), "AMT"));
	            	//Tax Rate
	            	ComSetObjValue(taxRate, 		setDataFormat(ComGetEtcData(arrXml[0], "TAX_RTO")));
	            	ComSetObjValue(tax_rto, 		setDataFormat(ComGetEtcData(arrXml[0], "TAX_RTO")));
	            	//Sheet Option Tax Rate
	            	ComSetObjValue(dflt_tax_rto, 	setDataFormat(ComGetEtcData(arrXml[0], "DFLT_TAX_RTO")));
	            	//Tax AMT
	            	ComSetObjValue(taxAmt, 			setDataFormat(ComGetEtcData(arrXml[0], "TAX_AMT"), "AMT"));     
	            	ComSetObjValue(tax_amt, 		setDataFormat(ComGetEtcData(arrXml[0], "TAX_AMT")));
	            	//Payable AMT
	            	ComSetObjValue(payableAmt, 		setDataFormat(ComGetEtcData(arrXml[0], "INV_AMT"), "AMT"));  
	            	//Manual Invoice Reason
	            	ComSetObjValue(reason, 			setDataFormat(ComGetEtcData(arrXml[0], "DMDT_MNL_INV_RSN_CD")));
	            	//Manual Invoice Remark(s)
	            	ComSetObjValue(remark, 			setDataFormat(ComGetEtcData(arrXml[0], "MNL_INV_RMK")));
	            	//C.REMARK, H.REMARK
	            	ComSetObjValue(dmdt_cxl_rsn_cd, setDataFormat(ComGetEtcData(arrXml[0], "DMDT_CXL_RSN_CD")));
	            	ComSetObjValue(dmdt_cxl_rsn_nm, setDataFormat(ComGetEtcData(arrXml[0], "DMDT_CXL_RSN_NM")));
	            	ComSetObjValue(cxl_rmk, 		setDataFormat(ComGetEtcData(arrXml[0], "CXL_RMK")));
	            	ComSetObjValue(inv_hld_rsn_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_HLD_RSN_CD")));
	            	ComSetObjValue(inv_hld_rsn_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_HLD_RSN_NM")));
	            	ComSetObjValue(inv_hld_rmk, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_HLD_RMK")));
	            	ComSetObjValue(upd_dt, 			setDataFormat(ComGetEtcData(arrXml[0], "UPD_DT")));
	            	ComSetObjValue(upd_ofc_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "UPD_OFC_CD")));
	            	ComSetObjValue(upd_usr_id, 		setDataFormat(ComGetEtcData(arrXml[0], "UPD_USR_ID")));
	            	ComSetObjValue(upd_usr_nm, 		setDataFormat(ComGetEtcData(arrXml[0], "UPD_USR_NM")));
	            	ComSetObjValue(suth_chn_iss_flg,setDataFormat(ComGetEtcData(arrXml[0], "SUTH_CHN_ISS_FLG")));
	            	ComSetObjValue(bil_to_loc_div_cd, setDataFormat(ComGetEtcData(arrXml[0], "BIL_TO_LOC_DIV_CD")));
	            	if (ComGetObjValue(formObj.tax_rto) != ComGetObjValue(formObj.dflt_tax_rto)) {
	            		formObj.chkTaxRateAmt.checked=false;
	            	}
	            	else {
	            		formObj.chkTaxRateAmt.checked=true;
	            	}
	            	ComClearCombo(chargeCurrency);
	            	addComboItem(chargeCurrency,setDataFormat(ComGetEtcData(arrXml[0], "CHG_CURR_CD")),true);
	            	ComSetObjValue(cre_cnt_cd, setDataFormat(ComGetEtcData(arrXml[0], "CRE_CNT_CD")));
	            }
	            
            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetCHGObj.LoadSearchData(arrXml[0], {Sync:1});
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) {
					sheetRTObj.LoadSearchData(arrXml[1], {Sync:1});
					var chgCurrCd=sheetCHGObj.GetCellValue(sheetCHGObj.HeaderRows(), BZC_CURR_CD);
            		ComSetObjValue(formObj.chargeCurrency, chgCurrCd);
				}
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (sheetCHGObj.RowCount()> 0) {
					if (fetchRateRowCountOfCharge() > 0) {
						displaySelectedRateDetail();
					}
					else {
						doActionAddRate();
					}
					calcBillableAmount(true, "Retrieve");
				}
				else if (ComGetObjValue(formObj.incCntrDtail) == "N") {
					doCalculate("Retrieve");
				}
				ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
				setSaveBtnEnable();
				setCancelBtnEnable();		
				setCRemarkBtnEnable();
				//setHRemarkBtnEnable();  //--14.08.11 버튼[BTN_HRemark] 비활성화에 따른 로직 처리
				setARIFBtnEnable();
				break;
         	case IBSEARCH_CHECK_BKGNO:
         		ComSetObjValue(formObj.f_cmd, COMMAND02);
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//********************************************************************************
         		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var bkgNo=setDataFormat(ComGetEtcData(sXml, "BKG_NO"));
				var blNo=setDataFormat(ComGetEtcData(sXml, "BL_NO"));
         		if (bkgNo != "") ComSetObjValue(formObj.bkgNo, bkgNo);
         		if (bkgNo != "") ComSetObjValue(formObj.blNo, blNo);
				break;
         	case IBSEARCH_CHECK_CNTRNO:
         		ComSetObjValue(formObj.f_cmd, SEARCH02);
         		with(sheetObj) {
         			ComSetObjValue(formObj.cntr_no, GetCellValue(GetSelectRow(), CNTR_NO));
         		}         		
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
         		ComSetObjValue(formObj.result, 	ComGetEtcData(sXml, "VALIDATE"));				
         		ComSetObjValue(formObj.result2, ComGetEtcData(sXml, "TPSZ_CD"));
         		break;
         	case IBSEARCH_BKG_CHG:
         		ComSetObjValue(formObj.f_cmd, 			SEARCH01);
       			ComSetObjValue(formObj.bkg_no, 			ComGetObjValue(formObj.bkgNo));
       			ComSetObjValue(formObj.bl_no, 			ComGetObjValue(formObj.blNo));
       			ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.GetSelectText());
       			ComSetObjValue(formObj.mnl_inv_snd_flg, ComGetObjValue(formObj.incCntrDtail));
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		sheetCHGObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            //3-1.Booking 정보를 추출한다.
	            with(formObj) {
	            	ComSetObjValue(vvdCd, 		setDataFormat(ComGetEtcData(arrXml[0], "VVD_CD")));
	            	ComSetObjValue(porCd, 		setDataFormat(ComGetEtcData(arrXml[0], "POR_CD")));
	            	ComSetObjValue(polCd, 		setDataFormat(ComGetEtcData(arrXml[0], "POL_CD")));
	            	ComSetObjValue(podCd, 		setDataFormat(ComGetEtcData(arrXml[0], "POD_CD")));
	            	ComSetObjValue(delCd, 		setDataFormat(ComGetEtcData(arrXml[0], "DEL_CD")));
	            	//R/D
	            	ComSetObjValue(rcvTermCd, 	setDataFormat(ComGetEtcData(arrXml[0], "RCV_TERM_CD")));
	            	ComSetObjValue(deTermCd, 	setDataFormat(ComGetEtcData(arrXml[0], "DE_TERM_CD")));
	            	//BKG Cust.
	            	ComSetObjValue(bkgCustCd, 	setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_CD")));
	            	ComSetObjValue(bkgCustNm, 	setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_NM")));
	            	//A/R Cust.
	            	ComSetObjValue(arCustCd, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_CD")));
	            	ComSetObjValue(arCustNm, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_NM")));
	            	//Payer.
	            	ComSetObjValue(payerCd, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_CD")));
	            	ComSetObjValue(payerNm, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM")));
	            	//ComSetObjValue(act_payr_cust_nm2, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM2")));
	            	//Trucker.
	            	ComSetObjValue(truckerCd, 	setDataFormat(ComGetEtcData(arrXml[0], "VNDR_SEQ")));
	            	ComSetObjValue(truckerNm, 	setDataFormat(ComGetEtcData(arrXml[0], "VNDR_NM")));
	            	//Due Date, Credit Term
	            	ComSetObjValue(dueDate, 	setDataFormat(ComGetEtcData(arrXml[0], "DUE_DATE")));
	            	ComSetObjValue(creditTerm,	setDataFormat(ComGetEtcData(arrXml[0], "CR_TERM_DYS")));
	            	//Tax Rate / AMT
	            	chkTaxRateAmt.checked=true;
	            	var taxRatio=setDataFormat(ComGetEtcData(arrXml[0], "TAX_RTO"));
	            	ComSetObjValue(tax_rto, 	taxRatio);
	            	if (taxRatio == "") 
	            		ComSetObjValue(taxRate,	"0");
	            	else
	            		ComSetObjValue(taxRate, 	taxRatio);
	            	//S/C No.
	            	ComSetObjValue(sc_no, 		setDataFormat(ComGetEtcData(arrXml[0], "SC_NO")));
	            	//RFA No.
	            	ComSetObjValue(rfa_no, 		setDataFormat(ComGetEtcData(arrXml[0], "RFA_NO")));
	            }
	            sheetCHGObj.RemoveAll();
	            sheetRTObj.RemoveAll();
	            if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) {
	            	sheetCHGObj.LoadSearchData(arrXml[0], {Sync:1});
	            	if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
		            	if (sheetCHGObj.RowCount()> 0) {
		            		changeChargeRowStatus("I");
							setInvoiceDetailSeq();
				    		doActionAddRate();
							ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
		            	}
	            	}
	            	//============================================================================================================================
	            }
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
            	if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
            		searchChargeCurrency();
            		if (ComGetObjValue(formObj.use_rt_curr) != "Y") {
            			var chgCurrCd=sheetCHGObj.GetCellValue(sheetCHGObj.HeaderRows(), BZC_CURR_CD);
	            		if (chgCurrCd != "") {
	            			ComSetObjValue(formObj.chargeCurrency, chgCurrCd);
	            		}
	            		else {
	            			formObj.chargeCurrency.selectedIndex=-1;
	            		}
            		}
            	}
	            if (ComGetObjValue(formObj.chargeCurrency) != "") {
	            	searchExRate();
	            }
	            break;
         	case IBSEARCH_CHECK_VVD:
         		ComSetObjValue(formObj.f_cmd, SEARCH05);
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
         		ComSetObjValue(formObj.result, 	ComGetEtcData(sXml, "IS_VVD"));				
         		break; 
	        //Calling Port Check
         	case IBSEARCH_CALLPORT:
         		ComSetObjValue(formObj.f_cmd, SEARCH03);
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
         		var result=ComGetEtcData(sXml, "IS_CALLPORT");
         		ComSetObjValue(formObj.result, result);
         		break;
	    	case IBSEARCH_CHG_CURR:
				ComSetObjValue(formObj.bkg_no, 			ComGetObjValue(formObj.bkgNo));
				ComSetObjValue(formObj.dmdt_trf_cd,		cboTariff.GetSelectText());
				ComSetObjValue(formObj.f_cmd, 			SEARCH07);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var cboItems=ComGetEtcData(sXml, "CHG_CURR_CD");
				ComClearCombo(formObj.chargeCurrency);
				addComboItem(formObj.chargeCurrency,cboItems,true);
				break;
         	case IBSEARCH_EX_RATE:      
         		ComSetObjValue(formObj.vvd_cd, 			ComGetObjValue(formObj.vvdCd));
         		ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.GetSelectText());
         		ComSetObjValue(formObj.chg_curr_cd, 	ComGetObjValue(formObj.chargeCurrency));
         		ComSetObjValue(formObj.inv_curr_cd, 	ComGetObjValue(formObj.invoiceCurrency));
         		ComSetObjValue(formObj.pod_cd, 			ComGetObjValue(formObj.podCd));
         		ComSetObjValue(formObj.pol_cd, 			ComGetObjValue(formObj.polCd));
	     		ComSetObjValue(formObj.f_cmd, 			SEARCH04);
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.exRate, setDataFormat(ComGetEtcData(sXml, "EX_RATE"), "EX_RATE"));
         		break;
//         	case IBSEARCH_SEND_FAX:
//         		ComSetObjValue(formObj.f_cmd, SEARCH05);
//         		
//         		//*********************************************************************************
//         		ComOpenWait(true);
//         		sheetObj.WaitImageVisible = false;
//         		//*********************************************************************************
//         		
//         		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//         		
//				//*********************************************************************************
//				ComOpenWait(false);
//				//*********************************************************************************
//				
//         		ComShowMessage(dmtGetMsgText(sXml));
//         		break;
         	case IBSEARCH_SEND_EMAIL:
         		ComSetObjValue(formObj.f_cmd, SEARCH06);
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
        		ComShowMessage(dmtGetMsgText(sXml));
         		break;
        	case IBSEARCH_ARIF:
	     		ComSetObjValue(formObj.f_cmd, COMMAND01);
         		ComSetObjValue(formObj.dmdt_inv_no, ComGetObjValue(formObj.invoiceNo));
         		ComSetObjValue(formObj.cre_ofc_cd, ComGetObjValue(formObj.issueOfcCd));
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.SetWaitImageVisible(0);
         		//*********************************************************************************
         		var sXml=sheetObj.GetSaveData("EES_DMT_4004GS.do", FormQueryString(formObj));
         		sheetObj.LoadSaveData(sXml);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.result, ComGetEtcData(sXml, "SUCCESS_YN"));//SUCCESS_YN
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        		break;         		
			case IBSAVE:
         		if (ComTrim(ComGetObjValue(formObj.invoiceNo)) == "") {
         			ComSetObjValue(formObj.f_cmd, MULTI);
         		}
         		else {
         			ComSetObjValue(formObj.f_cmd, MULTI01);
         		}
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString(1);
				var sParam2=sheetObjects[1].GetSaveString(1);
//				var cboTariff=comboObjects[0];
				with(formObj) {
					ComSetObjValue(bkg_no, 				ComGetObjValue(bkgNo));
					ComSetObjValue(bl_no, 				ComGetObjValue(blNo));
					ComSetObjValue(dmdt_trf_cd, 		comboObjects[0].GetSelectText());
					ComSetObjValue(mnl_inv_snd_flg, 	ComGetObjValue(incCntrDtail));
					ComSetObjValue(vvd_cd, 				ComGetObjValue(vvdCd));
					ComSetObjValue(por_cd, 				ComGetObjValue(porCd));
					ComSetObjValue(pol_cd, 				ComGetObjValue(polCd));
					ComSetObjValue(pod_cd, 				ComGetObjValue(podCd));
					ComSetObjValue(del_cd, 				ComGetObjValue(delCd));
					ComSetObjValue(rcv_term_cd, 		ComGetObjValue(rcvTermCd));
					ComSetObjValue(de_term_cd, 			ComGetObjValue(deTermCd));
					//Payer
					var payerCustCd=ComGetObjValue(payerCd);
					if (payerCustCd.length == 6) {
						ComSetObjValue(act_payr_cnt_cd, "00");
						ComSetObjValue(act_payr_seq, 	payerCustCd);
						ComSetObjValue(cust_cnt_cd, 	"00");
						ComSetObjValue(cust_seq, 		payerCustCd);						
					}
					else if (payerCustCd.length == 8) {
						ComSetObjValue(act_payr_cnt_cd, payerCustCd.substring(0, 2));
						ComSetObjValue(act_payr_seq, 	payerCustCd.substring(2));
						ComSetObjValue(cust_cnt_cd, 	payerCustCd.substring(0, 2));
						ComSetObjValue(cust_seq, 		payerCustCd.substring(2));		
					}
					//Invoice Remark(s)
					ComSetObjValue(inv_rmk1, 			ComGetObjValue(invoiceRemark1));
					ComSetObjValue(inv_rmk2, 			ComGetObjValue(invoiceRemark2));
					//Charge Currency
					ComSetObjValue(chg_curr_cd, 		ComGetObjValue(chargeCurrency));
					//Attention
					ComSetObjValue(dmdt_payr_cntc_pnt_nm, 	comboObjects[1].GetSelectText());
					//Trucker
					ComSetObjValue(vndr_seq, 			ComGetObjValue(truckerCd));
					//Notice
					ComSetObjValue(ntc_knt_cd, 			ComGetObjValue(notice));
					//Cust. Ref
					ComSetObjValue(inv_ref_no, 			ComGetObjValue(custRef));	
					//Invoice Currency
					ComSetObjValue(inv_curr_cd, 		ComGetObjValue(invoiceCurrency));
					//Total AMT
//					ComSetObjValue(bil_amt, 			ComGetUnMaskedValue(ComGetObjValue(totalAmt),		"float"));
				    ComSetObjValue(bil_amt,             getBillAmtByIncCntrDtail());
					//Ex. Rate
					ComSetObjValue(inv_xch_rt, 			ComGetUnMaskedValue(ComGetObjValue(exRate),			"float"));
					//CNTR Q’ty
					ComSetObjValue(bkg_cntr_qty, 		ComGetUnMaskedValue(ComGetObjValue(cntrQty),		"float"));					
					//Billing AMT
					ComSetObjValue(inv_chg_amt, 		ComGetUnMaskedValue(ComGetObjValue(billingAmt),		"float"));
					//Tax Ratio
					ComSetObjValue(tax_rto, 			ComGetUnMaskedValue(ComGetObjValue(taxRate),		"float"));
					//Tax AMT
					ComSetObjValue(tax_amt, 			ComGetUnMaskedValue(ComGetObjValue(taxAmt),			"float"));
					//Payable AMT
					ComSetObjValue(inv_amt, 			ComGetUnMaskedValue(ComGetObjValue(payableAmt),		"float"));
					//Manual Invoice Reason					
					ComSetObjValue(dmdt_mnl_inv_rsn_cd, ComGetObjValue(reason));
					//Manual Invoice Remark
					ComSetObjValue(mnl_inv_rmk, 		ComGetObjValue(remark));
				}
				if (sheetObjects[0].IsDataModified()== true) {
					sParam1=ComSetPrifix(sParam1, "subCharge");
					sParam=sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified()== true) {
					sParam2=ComSetPrifix(sParam2, "subRate");
					sParam=sParam + sParam2;
				}
				sParam += "&" + FormQueryString(formObj);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_4004GS.do", sParam);
				sheetObj.LoadSaveData(sXml, {Sync:1});
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
         		ComSetObjValue(formObj.result,  setDataFormat(ComGetEtcData(sXml, "INV_NO")));
         		ComSetObjValue(formObj.result2, setDataFormat(ComGetEtcData(sXml, "SUCCESS_YN")));
                break;
        }
    }
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
//		var cboTariff=comboObjects[0];
		var cboAttention=comboObjects[1];
	    sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	    	case IBSEARCH_ATTL:
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var cboItems=ComGetEtcData(sXml, "ATTENTION");
				cboAttention.RemoveAll();
				if (cboItems != undefined && cboItems.length > 0) {
					addComboItem3(cboAttention, cboItems.split(ROWMARK));
				}
				break;
	    	case IBSEARCH_LOC:
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var locCd=setDataFormat(ComGetEtcData(sXml, "LOC_CD"));
				ComSetObjValue(formObj.result, locCd != "" ? "Y" : "N");
				break;
			case IBSEARCH_CHECK_SHEETSET:
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				ComSetObjValue(formObj.dmdt_sh_tp_cd, 	"I");
				ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.GetSelectText());
				var tmpOfcCd=ComGetObjValue(formObj.ofc_cd);
				ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.issueOfcCd));
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.has_sheetset, 	ComGetEtcData(sXml, "RESULT"));
				ComSetObjValue(formObj.ofc_cd, 			tmpOfcCd);
				break;
			case IBSEARCH_PAYER_EMLFAX:
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.issueOfcCd));
				ComSetObjValue(formObj.payer_cd, 		ComGetObjValue(formObj.payerCd));
				ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.GetSelectText());
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.payr_faxnos, 	setDataFormat(ComGetEtcData(sXml, "FAX_NO")));
				ComSetObjValue(formObj.payr_emailnos, 	setDataFormat(ComGetEtcData(sXml, "EMAIL_NO")));
				break;
			case IBSEARCH_SHEET_OPT:
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.issueOfcCd));
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.bil_to_loc_div_cd, 	ComGetEtcData(sXml, "BIL_TO_LOC_DIV_CD"));
				break;					
	    	case IBSEARCH_DYS_BETWEEN:	
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.ovr_dys, 	ComGetEtcData(sXml, "OVR_DYS"));
				break;	    		
	    }
		sheetObj.SetWaitImageVisible(1);
	}
	function addMultiComboItem(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	function addComboItem(comboObj,comboDatas,isOnlyCode,isReverse) {
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
				if (isReverse) {
					ComAddComboItem(comboObj,txt,val);
				}
				else {
					ComAddComboItem(comboObj,val,txt);
				}
	    	}
		}   		
	}    
	function addComboItem2(comboObj,comboDatas) {
 		var comboColItems;
 		var comboRowItems;
 		var val="";
 		var txt="";
 		if (comboDatas != undefined) {
 			comboRowItems=comboDatas.split(ROWMARK);	
 	    	for (var i=0 ; i < comboRowItems.length ; i++) {
 	    		comboColItems=comboRowItems[i].split(FIELDMARK);
   				txt=comboColItems[0];
   				for (var j=1 ; j < comboColItems.length ; j++) {
   					if (val == "") {
   						val=comboColItems[j];
   					}
   					else {
   						val=val + "=" + comboColItems[j];
   					}
   				}
				ComAddComboItem(comboObj,txt,val);
 	    	}
 		}   		
 	}
    function addComboItem3(comboObj, comboItems) {
     	for (var i=0 ; i < comboItems.length ; i++) {
     		var comboItem=comboItems[i].split(FIELDMARK);
 			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3], comboItem[4]);		
        }   		
 	}
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//          if (!isNumber(formObj.iPage)) {
//              return false;
//          }
        }
        return true;
    }
    function initScreenControl(caller) {
    	var formObj=document.form;
//    	var cboTariff=comboObjects[0];
    	var cboAttention=comboObjects[1];
    	var sheetCHGObj=sheetObjects[0];
    	var sheetRTObj=sheetObjects[1];
		sheetCHGObj.RemoveAll();
		sheetRTObj.RemoveAll();
		if (caller != "Retrieve") {
			ComClearObject(formObj.invoiceNo);			
			ComSetObjValue(formObj.incCntrDtail, "Y");	
		}
    	with(formObj) {
    		//Invoice No.
    		ComEnableObject(invoiceNo, false);
    		invoiceNo.className="input2";
    		ComClearObject(issueDate);
    		ComClearObject(issueOfcCd);
    		ComClearObject(issueName);
    		ComClearObject(status);
    		ComClearObject(arIf);
    		ComClearObject(arIfDate);
    		ComClearObject(arIfOfc);
    		ComClearObject(arIfName);
    		ComClearObject(creditNote);
//	    	cboTariff.SetSelectText("");
    		document.form.cboTariff_text.value="";
//	    	cboTariff.SetEnable(1);
    		ComClearObject(bkgNo);
    		ComClearObject(blNo);
    		ComEnableManyObjects(true, bkgNo, blNo, incCntrDtail);
    		bkgNo.className="input1";
    		blNo.className="input1";
    		incCntrDtail.className="input1";    		
//    		cboAttention.RemoveAll();
//    		cboAttention.SetEnable(0);
    		ComClearObject(vvdCd);
    		ComClearObject(porCd);
    		ComClearObject(polCd);
    		ComClearObject(podCd);
    		ComClearObject(delCd);
    		ComClearObject(bkgCustCd);
    		ComClearObject(bkgCustNm);
    		ComClearObject(arCustCd);
    		ComClearObject(arCustNm);
    		ComClearObject(payerCd);
    		ComClearObject(payerNm);
    		//ComClearObject(act_payr_cust_nm2);
    		ComClearObject(tel);
    		ComClearObject(fax);
    		ComClearObject(email);
    		ComClearObject(truckerCd);
    		ComClearObject(truckerNm);
    		ComClearObject(dueDate);
    		ComClearObject(creditTerm);
    		rcvTermCd.selectedIndex=-1;
    		deTermCd.selectedIndex=-1;
    		ComEnableManyObjects(false, vvdCd, porCd, polCd, podCd, delCd, rcvTermCd, deTermCd, payerCd, truckerCd);
    		vvdCd.className="input2";
    		porCd.className="input2";
    		polCd.className="input2";    		
    		podCd.className="input2";
    		delCd.className="input2";
    		rcvTermCd.className="input2";
    		deTermCd.className="input2";
    		payerCd.className="input2";
    		truckerCd.className="input2";
    		ComEnableManyObjects(false, bkgCustNm, arCustNm, payerNm, tel, fax, email, dueDate, creditTerm);
    		bkgCustNm.className="input2";
    		arCustNm.className="input2";
    		payerNm.className="input2";    		
    		tel.className="input2";
    		fax.className="input2";
    		email.className="input2";
    		dueDate.className="input2";
    		creditTerm.className="input2";
    		ComClearObject(invoiceRemark1);
    		ComClearObject(invoiceRemark2);
    		ComSetObjValue(notice, "");
    		ComClearObject(invoiceOverDay);
    		ComClearObject(custRef);
    		ComEnableManyObjects(false, invoiceRemark1, invoiceRemark2, notice, invoiceOverDay, custRef);
    		invoiceRemark1.className="input2";
    		invoiceRemark2.className="input2";
    		notice.className="input2";
    		invoiceOverDay.className="input2";
    		custRef.className="input2";
    		chkTaxRateAmt.checked=false;
    		ComClearObject(billableAmt);
    		ComClearObject(exRate);
    		ComClearObject(cntrQty);
    		ComClearObject(totalAmt);
    		ComClearObject(dcAmtRate);
    		ComClearObject(billingAmt);
    		ComClearObject(taxRate);
    		ComClearObject(taxAmt);
    		ComClearObject(payableAmt);
    		ComEnableManyObjects(false, totalAmt, dcAmtRate, billingAmt, taxRate, taxAmt, payableAmt, chkTaxRateAmt);
    		totalAmt.className="input2";
    		dcAmtRate.className="input2";
    		billingAmt.className="input2";
    		taxRate.className="input2";
    		taxAmt.className="input2";
    		payableAmt.className="input2";
    		chkTaxRateAmt.className="input2";
    		//Charge  =====================================================================================
    		ComClearCombo(chargeCurrency);
    		ComEnableManyObjects(false, chargeCurrency, billableAmt);
    		chargeCurrency.className="input2";
    		billableAmt.className="input2";    		
    		//Invoice =====================================================================================
    		ComEnableManyObjects(false, invoiceCurrency, exRate, cntrQty);
    		invoiceCurrency.className="input2"
    		exRate.className="input2";
    		cntrQty.className="input2";
    		//Manual Invoice Reason =======================================================================
    		reason.selectedIndex=-1;
    		ComSetObjValue(remark, "");
    		ComEnableManyObjects(false, reason, remark);
    		reason.className="input2";
    		remark.className="input2";
    	}
    	sheetCHGObj.RemoveAll();
    	sheetRTObj.RemoveAll();
    	enableBtnCharge(true);
    	initBtnMain();
    	ComSetFocus(formObj.invoiceNo);
    	cboTariff.SetEnable(1);
		cboAttention.SetEnable(0);
    }
    
	function cboTariff_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		searchChargeCurrency();
	}
	
  	function cboAttention_OnSelect(comboObj, Index, Text, Code) {
  		setAttentionInform(comboObj, Index, Code);
  	}
  	
    function setAttentionInform(comboObj, Index, Code) {
		var formObj=document.form;
		var cboAttention=comboObjects[1];
		
		var pntNm = "";
		var phnNo = "";
		var faxNo = "";
		var eml   = "";
		
		if (Index != -1) {
			var pntNm = cboAttention.GetText(Index, 0);
			var phnNo = cboAttention.GetText(Index, 1);
			var faxNo = cboAttention.GetText(Index, 2);
			var eml   = cboAttention.GetText(Index, 3);
				
			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, pntNm);
			ComSetObjValue(formObj.tel,  				  phnNo);	//To show the text column
			ComSetObjValue(formObj.fax,  				  faxNo);	//To show the text column
			ComSetObjValue(formObj.email,     			  eml);		//To show the text column
			
			var arrCode = Code.split("^");		//code
			if (arrCode != undefined || arrCode != "") {
				ComSetObjValue(formObj.cust_cntc_pnt_seq, arrCode[1]);
			}
		}
    }
    
	function sheet1_OnPopupClick(sheetObj,Row,Col) {
		var cal=new ComCalendarGrid("myCal");
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case TO_MVMT_DT :
				case FT_END_DT  :
					cal.setEndFunction("resetOverDay");
					break;
			}
		}
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (currDtlSeq == GetCellValue(row, INV_DTL_SEQ)) {
					SetSelectRow(row);
					break;
				}
			}
		}
	}
	
	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj=document.form;
		var sheetRTObj=sheetObjects[1];
		
		with(sheetObj) {
			if (OldRow >= HeaderRows()&& OldRow != NewRow) {
				//----------------------------------------------
				currDtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
				//----------------------------------------------
				if (GetRowStatus(NewRow) != "D") {
					displaySelectedRateDetail();
					if (GetCellValue(NewRow, CNTR_NO) != "" && fetchRateRowCountOfCharge() == 0) {
						if (ComGetObjValue(formObj.dmdt_inv_sts_cd) != "X")
							doActionAddRate();
					}
				}
			}
		}
	}
	
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case CNTR_NO:
					if (ComTrim(GetCellValue(Row, Col)) != "")
						checkContainerNo();
					else
						SetCellValue(Row, CNTR_TPSZ_CD,"",0);
					break;
				case FM_MVMT_DT :
					if (Value != "") {
						if (GetRowStatus(Row) == "I") {
							SetCellValue(Row, FT_CMNC_DT,Value,0);
						}
					}
//					var ftCmncDT = CellValue(Row, FT_CMNC_DT);
//					if (ftCmncDT != "" && Value != "") {
//						var intervalDT = retrieveDaysBetween(Value, ftCmncDT);
//						if (intervalDT < 0 || intervalDT > 1) {
//							ComShowCodeMessage("DMT00172");
//							CellValue2(Row, Col) = "";
//						}
//					}
					checkFromDTBetweenToDT(FM_MVMT_DT);
					break
				case TO_MVMT_DT:
					resetOverDay();
					break;
				case FT_CMNC_DT:
//					var ftFmDT = CellValue(Row, FM_MVMT_DT);
//					if (ftFmDT != "" && Value != "") {
//						var intervalDT = retrieveDaysBetween(ftFmDT, Value);
//						if (intervalDT < 0 || intervalDT > 1) {
//							ComShowCodeMessage("DMT00172");
//							CellValue2(Row, Col) = "";
//						}
//					}
					checkFTEndDTBetweenFTCmncDT(FT_CMNC_DT);
					if (!compareFTDate()) {
						ComShowCodeMessage("DMT00171", "F/T End date.");
						SetCellValue(Row, Col,"",0);
					}
					break;
				case FT_END_DT:
					resetOverDay();
					break;
				case FT_DYS:
					if (!compareFTDate()) {
						ComShowCodeMessage("DMT00171", "F/D.");
						SetCellValue(Row, Col,"",0);
					}					
					break;
			}
		}
	}
	
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case FT_UND_DYS:
					resetOverDay();
					calcBillableAmount(false);
					break;
				case INV_RT_AMT:
					calcBillableAmount(false);
					break;
			}
		}
	}
	
    function doActionRetrieve() {
    	var formObj=document.form;
    	var cboAttention=comboObjects[1];
    	var sheetCHGObj=sheetObjects[0];
    	with(formObj) {
    		var invNo=ComTrim(ComGetObjValue(invoiceNo));
    		if (invNo == "") {
     			ComShowCodeMessage("DMT03028", "Invoice No.");
     			ComSetFocus(invoiceNo);
     			return;    			
    		}
    		//2.Invoice No 의 세번째 Alphabet 이 'R' 또는 'T' 일 경우 DMT03057 를 보여주고 오류처리한다.
    		else if (invNo.substring(2, 3) == "R" || invNo.substring(2, 3) == "T") {
     			ComShowCodeMessage("DMT03057", "Invoice No.");
     			ComSetFocus(invoiceNo);
     			return;      			
    		}
    	}
    	//Invoice No.정보를 조회한다.
    	doActionIBSheet(sheetCHGObj, formObj, IBSEARCH);
		//-------------------------------------------------------------------------
    	currDtlSeq=sheetCHGObj.GetCellValue(sheetCHGObj.GetSelectRow(), INV_DTL_SEQ);
		//-------------------------------------------------------------------------
    	ComSetObjValue(formObj.org_payer_cd, ComGetObjValue(formObj.payerCd));
    	//==========================================================================================================
     	if (ComTrim(ComGetObjValue(formObj.payerCd)) != "" && ComGetObjValue(formObj.incCntrDtail) == "Y") {
     		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.issueOfcCd));
     		searchAttentionList();
        	if (cboAttention.GetItemCount() > 0) {
        		var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
        		//Attention Setting
       			cboAttention.SetSelectCode(setCode);
       			if (cboAttention.GetSelectCode()== ""){
       				cboAttention.SetSelectIndex(0);
        		}
        	}
     		ComSetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm));
     		ComSetObjValue(formObj.org_payr_cntc_pnt_eml, 		ComGetObjValue(formObj.email));
     		ComSetObjValue(formObj.org_payr_cntc_pnt_phn_no, 	ComGetObjValue(formObj.tel));
     		ComSetObjValue(formObj.org_payr_cntc_pnt_fax_no, 	ComGetObjValue(formObj.fax));
     		//======================================================================================================
     	}
   		postProcess("Retrieve");
     	if (ComIsBtnEnable("btn_DataDisplay")) ComBtnDisable("btn_DataDisplay");
		ComBtnEnable("btn_SheetSet");
		ComBtnEnable("btn_SheetOption");
		//Sending History, Preview, INV Print, Fax Send, Email Send, Payer Info
     	if (ComGetObjValue(formObj.dmdt_inv_sts_cd) != "") {
			ComBtnEnable("btn_SendingHistory");
			if (ComGetObjValue(formObj.payerCd) != "") {
				doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_PAYER_EMLFAX, COMMAND02);
			}
			doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_CHECK_SHEETSET, COMMAND13);			
			if (ComGetObjValue(formObj.incCntrDtail) == "N") {
				ComBtnDisable("btn_Preview");
				ComBtnDisable("btn_InvPrint");
				ComBtnDisable("btn_Fax");
				ComBtnDisable("btn_Email");
				//ComBtnDisable("btn_PayerInfo");
			}
			else {
				ComBtnEnable("btn_Preview");
				ComBtnEnable("btn_InvPrint");
				ComBtnEnable("btn_Fax");
				ComBtnEnable("btn_Email");
				//ComBtnEnable("btn_PayerInfo");
			}
			ComBtnEnable("btn_PayerInfo");
     	}
     	
     	//=========================================
     	//2015.10.27 #7995 comment start
     	//2017.01.12 #23259 India Invocie
		if (ComGetObjValue(formObj.cre_cnt_cd) =="IN" ){
			formObj.chkTaxRateAmt.checked = true;
			ComEnableObject(formObj.chkTaxRateAmt, false);
			ComSetObjValue(formObj.taxRate, "");
		}
		//2015.10.27 #7995 comment e n d
		//=========================================	
    }
    
     function doActionDisplayData() {
     	var formObj=document.form;
//     	var cboTariff=comboObjects[0];
     	var cboAttention=comboObjects[1];
     	var sheetCHGObj=sheetObjects[0];
     	with(formObj) {
     		if (ComTrim(ComGetObjValue(bkgNo)) == "") {
     			ComShowCodeMessage("DMT03028", "BKG No");
     			ComSetFocus(bkgNo);
     			return;
     		}
     		else if (ComTrim(ComGetObjValue(blNo)) == "") {
     			ComShowCodeMessage("DMT03028", "B/L No");
     			ComSetFocus(blNo);
     			return;     			
     		} 
     		else if (ComTrim(formObj.cboTariff.value) == "") {
     			ComShowCodeMessage("DMT03028", "Tariff Type");
     			return;     			
     		} 
     		else if (ComTrim(ComGetObjValue(incCntrDtail)) == "") {
     			ComShowCodeMessage("DMT03028", "Incl. CNTR Detail");
     			ComSetFocus(incCntrDtail);
     			return;     			
     		}      		
     	}
     	with(formObj) {
     		ComClearObject(invoiceNo);
     		ComClearObject(issueDate);
     		ComClearObject(issueOfcCd);
     		ComClearObject(issueName);
     		ComClearObject(status);
     		ComClearObject(arIf);
     		ComClearObject(arIfDate);
     		ComClearObject(arIfOfc);
     		ComClearObject(arIfName);
     		ComClearObject(creditNote);
     		ComClearObject(creditNoteArIf);
     	}
     	ComSetObjValue(formObj.use_rt_curr, "Y");	
     	doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_BKG_CHG);
     	ComSetObjValue(formObj.use_rt_curr, "N");	
		//-------------------------------------------------------------------------
     	currDtlSeq=sheetCHGObj.GetCellValue(sheetCHGObj.GetSelectRow(), INV_DTL_SEQ);
		//-------------------------------------------------------------------------
     	if (ComTrim(ComGetObjValue(formObj.payerCd)) != "" && ComGetObjValue(formObj.incCntrDtail) == "Y") {
     		searchAttentionList();
     		if (cboAttention.GetItemCount() > 0) {
     			cboAttention.SetSelectIndex(0);
     		}
     	}
     	ComBtnEnable("btn_Save");
   		postProcess("DataDisplay");
   		
	   	//=========================================
	   	//2015.10.27 #7995 comment start
   		//2017.01.12 #23259 India Invocie
   		var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
   		if(usr_cnt_cd == "IN"){ 
   			formObj.chkTaxRateAmt.checked = true;
   			ComEnableObject(formObj.chkTaxRateAmt, false);
   			ComSetObjValue(formObj.taxRate, "");
   		}else{
			ComEnableObject(formObj.chkTaxRateAmt, true);
   		}
   		ComEnableObject(formObj.chkTaxRateAmt, true);
	   	//2015.10.27 #7995 comment e n d
	   	//=========================================	
     }
     
    function doActionNew() {
        var formObj=document.form;
        var sheetCHGObj=sheetObjects[0];
        if (isPopupWindow()) {
        	doActionRetrieve();
        	ComBtnDisable("btn_DataDisplay");
        }
        else {
    		initScreenControl();
    		enableBtnCharge(false);
    		ComBtnEnable("btn_DataDisplay");
    		ComSetFocus(formObj.bkgNo);
        }
    }
    
    function doActionMinimize() {
    	var sheetCHGObj=sheetObjects[0];
    	var sheetRTObj=sheetObjects[1];
    	var addHeight=20;
    	
		if (conditionLayer.style.display == 'block') {
			conditionLayer.style.display='none';
			addHeight=127;
		}
		else {
			conditionLayer.style.display='block';
		}
		sheetCHGObj.SetSheetHeight(IBSHEET_HEIGHT + addHeight);
		sheetRTObj.SetSheetHeight(IBSHEET_HEIGHT + addHeight);
    }
    
    function doActionSave() {
        var formObj=document.form;
//        var cboTariff=comboObjects[0];
        var cboAttention=comboObjects[1];
        var sheetCHGObj=sheetObjects[0];
        var sheetRTObj=sheetObjects[1];
        //BKG No.
        if (ComTrim(ComGetObjValue(formObj.bkgNo)) == "") {
        	ComShowCodeMessage("DMT03028", "BKG No");
        	ComSetFocus(formObj.bkgNo);
        	return;
        }
        //B/L No.
        else if (ComTrim(ComGetObjValue(formObj.blNo)) == "") {
        	ComShowCodeMessage("DMT03028", "B/L No");
        	ComSetFocus(formObj.bkgNo);
        	return;        	
        }
        //Tariff Type
        else if (ComTrim(cboTariff.GetSelectText()) == "") {
        	ComShowCodeMessage("DMT03028", "Tariff Type");
        	return;           	
        }
        //Incl. CNTR Detail
        else if (ComTrim(ComGetObjValue(formObj.incCntrDtail)) == "") {
        	ComShowCodeMessage("DMT03028", "Incl. CNTR Detail");
        	ComSetFocus(formObj.incCntrDtail);
        	return;          	
        }
        if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
        	if (cboTariff.GetSelectText().substring(2, 3) == "O") {
        		if (ComTrim(ComGetObjValue(formObj.porCd)) == "") {
        			ComShowCodeMessage("DMT03028", "POR");
        			ComSetFocus(formObj.porCd);
        			return;
        		}
        		else if (ComTrim(ComGetObjValue(formObj.polCd)) == "") {
        			ComShowCodeMessage("DMT03028", "POL");
        			ComSetFocus(formObj.polCd);
        			return;
        		}
        	}
        	else if (cboTariff.GetSelectText().substring(2, 3) == "I") {
        		if (ComTrim(ComGetObjValue(formObj.podCd)) == "") {
        			ComShowCodeMessage("DMT03028", "POD");
        			ComSetFocus(formObj.podCd);
        			return;
        		}
        		else if (ComTrim(ComGetObjValue(formObj.delCd)) == "") {
        			ComShowCodeMessage("DMT03028", "DEL");
        			ComSetFocus(formObj.delCd);
        			return;
        		}        		
        	}
        }
        else if (ComGetObjValue(formObj.incCntrDtail) == "N") {
        	if (cboTariff.GetSelectText().substring(2, 3) == "O") {
        		if (ComTrim(ComGetObjValue(formObj.polCd)) == "") {
        			ComShowCodeMessage("DMT03028", "POL");
        			ComSetFocus(formObj.polCd);
        			return;
        		}
        	}
        	else if (cboTariff.GetSelectText().substring(2, 3) == "I") {
        		if (ComTrim(ComGetObjValue(formObj.podCd)) == "") {
        			ComShowCodeMessage("DMT03028", "POD");
        			ComSetFocus(formObj.podCd);
        			return;
        		}
        	}
        }
    	var vvdCd=ComTrim(ComGetObjValue(formObj.vvdCd));
    	if (vvdCd.substring(0, 4) != "CFDR") {
    		if (	ComTrim(ComGetObjValue(formObj.porCd)) == "" 
    			|| 	ComTrim(ComGetObjValue(formObj.polCd)) == ""
    			|| 	ComTrim(ComGetObjValue(formObj.podCd)) == "" 
    			|| 	ComTrim(ComGetObjValue(formObj.delCd)) == "") {
    			ComShowCodeMessage("DMT01146", "POR/POL/POD/DEL");
    			return;
    		}
    	}
        //.VVD CD check
        if (!validateCallPort()) {
        	ComClearObject(formObj.vvdCd);
        	ComSetFocus(formObj.vvdCd);
        	return;
        }
        //.Payer Validate =============================================================================================
		if (ComTrim(ComGetObjValue(formObj.payerCd)) == "") {
			ComAlertFocus(formObj.payerCd, ComGetMsg("DMT01052"));
			return false;
		}
		//=============================================================================================================
   		with(sheetCHGObj) {
 	  		var dupRows = ColValueDupRows(CNTR_NO);
 	  		if (dupRows != "") {
 	  			if (!ComShowCodeConfirm("DMT01124", "CNTR No")) return;
 			}
   		}
        if (ComGetObjValue(formObj.arIf) == "Y") {
        	ComShowCodeMessage("DMT03022");
        	return;
        }
        if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
        	if (ComGetObjValue(formObj.chargeCurrency) == "") {
        		ComShowCodeMessage("DMT03028", "Charge Cur.");
        		ComSetFocus(formObj.chargeCurrency);
        		return;
        	}
        	else if (fetchRateRowCountOfCharge() == 0) {
        		ComShowCodeMessage("DMT03028", "Charge");
        		return;
        	}
        }
        
        with(sheetCHGObj) {
        	for (var row=HeaderRows(); row <= LastRow(); row++) {
        		if (GetRowStatus(row) != "D") {
        			var ftDys = GetCellValue(row, FT_DYS) + "";
        			if (ComTrim(GetCellValue(row, CNTR_NO)) == "") {
        				ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "CNTR No");
                		return;
        			}
        			else if (ComTrim(GetCellValue(row, FM_MVMT_DT)) == "") {
        				ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "From DT");
                		return;        				
        			}
        			else if (ComTrim(GetCellValue(row, TO_MVMT_DT)) == "") {
        				ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "To DT");
                		return;        				
        			}
        			else if (ComTrim(GetCellValue(row, FT_CMNC_DT)) == "") {
        				ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "F/T CMNC");
                		return;        				
        			}
        			else if (ComTrim(GetCellValue(row, FT_END_DT)) == "") {
        				ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "F/T End");
                		return;        				
        			}  
        			else if (ftDys.length == 0) {
        				ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "F/D");
                		return;        				
        			}
        			
        			var invNo=GetCellValue(row, INV_NO);
        			var ofcCd=GetCellValue(row, CRE_OFC_CD);
        			var dtlSeq=GetCellValue(row, INV_DTL_SEQ);
        			for (var subRow=sheetRTObj.HeaderRows(); subRow <= sheetRTObj.LastRow(); subRow++) {
        				if (	sheetRTObj.GetRowStatus(subRow) != "D"
        					&&	invNo 	== sheetRTObj.GetCellValue(subRow, INV_NO)
        					&&	ofcCd 	== sheetRTObj.GetCellValue(subRow, CRE_OFC_CD)
        					&&	dtlSeq 	== sheetRTObj.GetCellValue(subRow, INV_DTL_SEQ)	) {
        					if (sheetRTObj.GetCellValue(subRow, INV_RT_AMT) == "") {
        						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Rate");
                        		return;         						
        					}
        				}
        			}
        		}
        	}
        }
        //Attention
        ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, cboAttention.GetSelectText());
        if (ComGetObjValue(formObj.incCntrDtail) == "N") {
        	var tmpTotalAmt=ComTrim(ComGetObjValue(formObj.totalAmt));
        	if (tmpTotalAmt == "" || ComParseInt(tmpTotalAmt) == 0) {
        		ComShowCodeMessage("DMT03028", "Total AMT");
        		ComSetFocus(formObj.totalAmt);
        		return;
        	}
        }
        if (parseFloat(ComGetObjValue(formObj.billingAmt)) <= 0) {
        	ComShowCodeMessage("DMT01128", "Billing Amount", "0");
        	return;
        }
        if (ComTrim(ComGetObjValue(formObj.reason)) == "") {
        	ComAlertFocus(formObj.reason, ComGetMsg("DMT03028", "Reason"));
        	return;
        }
        if (ComGetObjValue(formObj.reason) == "OTH") {
        	if (ComTrim(ComGetObjValue(formObj.remark)) == "") {
        		ComAlertFocus(formObj.remark, ComGetMsg("DMT01038"));
        		return;
        	}
        	else if (ComTrim(ComGetObjValue(formObj.remark)).length < 10) {
        		ComAlertFocus(formObj.remark, ComGetMsg("DMT01038"));
        		return;        		
        	}
        }
        setChargeCurrencyInRT();
        //“Discrepancy found in Tax Rate between Invoice and Sheet Option. Are you sure to save?”
        if (ComTrim(ComGetObjValue(formObj.invoiceNo)) != "") {
			//INVOICE TAX_RTO와 OFFICE별 TAX_RTO가 다를 경우 메시지 처리함
			if (	parseInt(ComGetObjValue(formObj.taxRate)) > 0  
				&&	ComGetObjValue(formObj.taxRate) != ComGetObjValue(formObj.dflt_tax_rto)) {
				if (!ComShowCodeConfirm("DMT00184")) return;
			}
        }
        // Compare payer with rep cust seq
        if (ComTrim(ComGetObjValue(formObj.payerCd)) == ComTrim(ComGetObjValue(formObj.rep_cust_seq))) {
        	ComAlertFocus(formObj.payerCd, ComGetMsg("DMT01157"));
        	return;
        }
        
        doActionIBSheet(sheetCHGObj, formObj, IBSAVE);
        if (ComTrim(ComGetObjValue(formObj.result2)) == "Y") {
	        if (ComTrim(ComGetObjValue(formObj.invoiceNo)) == "") {
	        	ComSetObjValue(formObj.invoiceNo, ComGetObjValue(formObj.result));
	        }
	        doActionRetrieve();
        }
    }
    
   	function postProcess(caller) {
   		var formObj=document.form;
   		var cboTariff=comboObjects[0];
   		var cboAttention=comboObjects[1];
   		with(formObj) {
   			ComEnableManyObjects(false, bkgNo, blNo, incCntrDtail);
   			bkgNo.className="input2";
   			blNo.className="input2";
   			incCntrDtail.className="input2";
   		}
		cboTariff.SetEnable(0);
   		if (caller == "Retrieve") {
   			with(formObj) {
	    		ComEnableManyObjects(false, vvdCd, porCd, polCd, podCd, delCd, rcvTermCd, deTermCd, dcAmtRate, taxRate, taxAmt, chargeCurrency, invoiceCurrency, totalAmt);
	    		vvdCd.className="input2";
	    		porCd.className="input2";
	    		polCd.className="input2";
	    		podCd.className="input2";
	    		delCd.className="input2";
	    		rcvTermCd.className="input2";
	    		deTermCd.className="input2";
	    		dcAmtRate.className="input2";
	    		taxRate.className="input2";
	    		taxAmt.className="input2";
	    		chargeCurrency.className="input2";
	    		invoiceCurrency.className="input2";
	    		totalAmt.className="input2";
   			}
   			enableChargeGrid(false);
   			enableBtnCharge(false);
   			enableRateGrid(false);
   		}
   		else {
   			with(formObj) {
	    		ComEnableManyObjects(true, vvdCd, porCd, polCd, podCd, delCd, rcvTermCd, deTermCd, dcAmtRate, taxRate, taxAmt);
	    		vvdCd.className="input1";
	    		rcvTermCd.className="input";
	    		deTermCd.className="input";
	    		dcAmtRate.className="noinput";
	    		taxRate.className="noinput2";
	    		taxAmt.className="noinput2";
   			}
   	 		setFieldMandatoryColor();
   	 		if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
   	 			with(formObj) {
   	 				ComEnableManyObjects(true, chargeCurrency, invoiceCurrency);
   	 				ComEnableObject(totalAmt, false);
   	 				chargeCurrency.className="input1";
   	 				invoiceCurrency.className="input1";
   	 				totalAmt.className="input2";
   	 			}
	   			enableChargeGrid(true);
	   			enableBtnCharge(true);
	   			enableRateGrid(true);
   	 		}
   	 		else {
   	 			with(formObj) {
   	 				ComEnableObject(chargeCurrency, false);
   	 				ComEnableObject(totalAmt, 		true);
   	 				ComEnableObject(dcAmtRate, 		false);
   	 				ComEnableObject(billingAmt, 	false);
   	 				ComClearCombo(chargeCurrency);
   	 				ComClearObject(exRate);
   	 				ComClearObject(dcAmtRate);
   	 				chargeCurrency.className="input2";
   	 				totalAmt.className="noinput1";
   	 				dcAmtRate.className="noinput2";
   	 				billingAmt.className="noinput2";
   	 			}
   	 			ComSetObjValue(formObj.totalAmt, 	setDataFormat("0", "AMT"));
   	 			ComSetObjValue(formObj.billingAmt, 	setDataFormat("0", "AMT"));
   	   			enableChargeGrid(false);
   	   			enableBtnCharge(false);
   	   			enableRateGrid(false);  	 			
   	 		}
   		}
   		
   		if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X") {
	    	with(formObj) {
	    		ComEnableManyObjects(false, payerCd, chkTaxRateAmt, reason, remark);
	    		payerCd.className="input2";
	    		chkTaxRateAmt.className="input2";
	    		reason.className="input2";
	    		remark.className="input2";
	    	}   			
   		}
   		else {
	    	with(formObj) {
	    		ComEnableManyObjects(true, payerCd, chkTaxRateAmt, reason, remark);
	    		payerCd.className="input1";
	    		chkTaxRateAmt.className="trans";
	    		reason.className="input1";
	    		remark.className="input";
	    	}
   		}
   		
    	if (ComGetObjValue(formObj.incCntrDtail) == "Y" || caller == "Retrieve") {
    		if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X") {
    			cboAttention.SetEnable(0);
    			with(formObj) {
    				ComEnableManyObjects(false, truckerCd, notice, custRef, invoiceRemark1, invoiceRemark2);
    				truckerCd.className="input2";
    				notice.className="input2";
    				custRef.className="input2";
    				invoiceRemark1.className="input2";
    				invoiceRemark2.className="input2";    				
    			}
    		}
    		else {
    			if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
    				cboAttention.SetEnable(1);
        			with(formObj) {
        				ComEnableManyObjects(true, truckerCd, notice, custRef, invoiceRemark1, invoiceRemark2);
        				truckerCd.className="input";
        				notice.className="input";
        				custRef.className="input";
        				invoiceRemark1.className="input";
        				invoiceRemark2.className="input";
        			}     				
    			}
    			else {
    				cboAttention.SetEnable(0);
        			with(formObj) {
        				ComEnableManyObjects(false, truckerCd, notice, custRef, invoiceRemark1, invoiceRemark2);
        				truckerCd.className="input2";
        				notice.className="input2";
        				custRef.className="input2";
        				invoiceRemark1.className="input";
        				invoiceRemark2.className="input";
        			}    				
    			}
    		}
    	}
    	else if (ComGetObjValue(formObj.incCntrDtail) == "N") {
			cboAttention.SetEnable(0);
			with(formObj) {
				ComEnableManyObjects(false, truckerCd, notice, custRef, invoiceRemark1, invoiceRemark2)
    			truckerCd.className="input2";				
				notice.className="input2";
				custRef.className="input2";
				invoiceRemark1.className="input2";
				invoiceRemark2.className="input2";
				ComClearObject(truckerCd);
				ComClearObject(truckerNm);
				ComClearObject(invoiceRemark1);
				ComClearObject(invoiceRemark2);
				ComClearObject(notice);
				ComClearObject(custRef);
				ComClearObject(dueDate);
			} 
    	}
   		if (caller == 'DataDisplay') {
    		ComSetObjValue(formObj.dcAmtRate, setDataFormat("0", "AMT"));
		}
   	}
   	
    function doActionAddCharge() {
    	var formObj=document.form;
    	var sheetCHGObj=sheetObjects[0];
    	with(sheetCHGObj) {
    		if (RowCount()> 0) {
				var invNo=GetCellValue(HeaderRows(), INV_NO);
				var ofcCd=GetCellValue(HeaderRows(), CRE_OFC_CD);
    		}
    		DataInsert(-1);
    		if (invNo != "") SetCellValue(LastRow(), INV_NO,invNo,0);
   			if (ofcCd != "") SetCellValue(LastRow(), CRE_OFC_CD,ofcCd,0);
    		SetCellValue(LastRow(), INV_DTL_SEQ,fetchNextSeq(sheetCHGObj),0);
   			doActionAddRate();
    		displaySelectedRateDetail();
    	}
		ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
    }
    
    function doActionAddRate() {
    	var sheetCHGObj=sheetObjects[0];
     	var sheetRTObj=sheetObjects[1];
     	with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
     	}
     	var ftOvrDys=fetchRTFromVal();
     	with(sheetRTObj) {
     		DataInsert(-1);
     		SetCellValue(LastRow(), INV_NO,invNo,0);
    		SetCellValue(LastRow(), CRE_OFC_CD,ofcCd,0);
    		SetCellValue(LastRow(), INV_DTL_SEQ,dtlSeq,0);
     		SetCellValue(LastRow(), INV_RT_SEQ,fetchNextSeq(sheetRTObj),0);
     		SetCellValue(LastRow(), FT_OVR_DYS,ftOvrDys,0);
     	}
     	resetOverDay();
    }
    
    function doActionCopyCharge() {
    	var formObj=document.form;
    	var sheetCHGObj=sheetObjects[0];
    	var srcRow=sheetCHGObj.GetSelectRow()
		var newRow=sheetCHGObj.DataCopy();
		sheetCHGObj.SetRowStatus(newRow,"I");
		ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());	
		sheetCHGObj.SetCellValue(newRow, INV_DTL_SEQ, fetchNextSeq(sheetCHGObj), 0);
		doActionCopyRate(srcRow, newRow);
		displaySelectedRateDetail();
		calcBillableAmount(true);
    }
    
	function doActionCopyRate(srcRow, newRow) {
		var sheetCHGObj=sheetObjects[0];
    	var sheetRTObj=sheetObjects[1];
    	//원본 Charge 의 Rate Detail 을 찾아서 복사해준다.
     	with(sheetCHGObj) {
			var srcInvNo=GetCellValue(srcRow, INV_NO);
			var srcOfcCd=GetCellValue(srcRow, CRE_OFC_CD);
			var srcDtlSeq=GetCellValue(srcRow, INV_DTL_SEQ);
			var newInvNo=GetCellValue(newRow, INV_NO);
			var newOfcCd=GetCellValue(newRow, CRE_OFC_CD);
			var newDtlSeq=GetCellValue(newRow, INV_DTL_SEQ);
     	}
     	with(sheetRTObj) {
     		var endRow=LastRow();
     		for (var row=HeaderRows(); row <= endRow ; row++) {
     			if (	GetRowStatus(row) != "D"
     				&&	srcInvNo  == GetCellValue(row, INV_NO)
     				&&	srcOfcCd  == GetCellValue(row, CRE_OFC_CD)
     				&&	srcDtlSeq == GetCellValue(row, INV_DTL_SEQ)	) {
     	     		DataInsert(-1);
     	     		SetCellValue(LastRow(), INV_NO, newInvNo, 0);
     	    		SetCellValue(LastRow(), CRE_OFC_CD, newOfcCd, 0);
     	    		SetCellValue(LastRow(), INV_DTL_SEQ, newDtlSeq, 0);
     	     		SetCellValue(LastRow(), INV_RT_SEQ, fetchNextSeq(sheetRTObj), 0);
					SetCellValue(LastRow(), FT_OVR_DYS, GetCellValue(row, FT_OVR_DYS), 0);
					SetCellValue(LastRow(), FT_UND_DYS, GetCellValue(row, FT_UND_DYS), 0);
					SetCellValue(LastRow(), INV_RT_AMT, GetCellValue(row, INV_RT_AMT), 0);
					SetCellValue(LastRow(), RT_OVR_DYS, GetCellValue(row, RT_OVR_DYS), 0);
					SetCellValue(LastRow(), RT_OVR_CHG_AMT, GetCellValue(row, RT_OVR_CHG_AMT), 0);
					SetCellValue(LastRow(), BZC_CURR_CD, GetCellValue(row, BZC_CURR_CD), 0);
     			}
     		}
     	}
   }
   
    function doActionDelCharge() {
    	var formObj=document.form;
    	var sheetCHGObj=sheetObjects[0];
		with(sheetCHGObj) {
			if (GetSelectRow()>= HeaderRows()) {
				doActionDelRate();
				if (GetRowStatus(GetSelectRow()) == 'I') {
					RowDelete(GetSelectRow(), false);
				}
				else {
					SetRowStatus(GetSelectRow(),'D');
					GetRowHidden(SetSelectRow)(1);
				}
				displaySelectedRateDetail();
				if (RowCount() > 0 && fetchRateRowCountOfCharge() == 0) {
					doActionAddRate();
				}				
			}
		}
		ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
		calcBillableAmount(true);
    }
    
   function doActionDelRate() {
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
		with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
		}
		with(sheetRTObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (invNo == GetCellValue(row, INV_NO)
						&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
						&& 	ofcCd 	== GetCellValue(row, CRE_OFC_CD)) {
					if (GetRowStatus(row) == 'I') {
						RowDelete(row, false);
					}
					else {
						SetRowStatus(row, 'D');
						SetRowHidden(row, 1);
					}
				}
			}
		}
    }
    
    function doActionFax() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[2];
//		if(ComGetObjValue(formObj.payr_faxnos) == "") {
//			ComShowCodeMessage("DMT01090");
//			return;
//		}
		var mrd_file="";
//		var sndr_id		= "";	//id
//		var sndr_name	= "";	//
//		var sndr_email	= "";	//
//		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//		var rcvr_email	= "";	//
//		var msg1		= "";
		//MRD 파일
		var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
		var temp_incCntrDtail	= ComGetObjValue(formObj.incCntrDtail);
		var rhq	= ComGetObjValue(formObj.rhq_ofc_cd);
		var ofc_cd	= ComGetObjValue(formObj.issueOfcCd);
		/*
		if (temp_LR == "" || temp_LR == "L") {
			mrd_file="EES_DMT_4901.mrd";		//L
		}
		else if (temp_LR == "R") {
			mrd_file="EES_DMT_4902.mrd";		//R
		}
		*/
		
		if(temp_LR == "") {
			if(temp_incCntrDtail == "N"){
				mrd_file = "EES_DMT_4908.mrd";
			}else{
				  mrd_file = "EES_DMT_4901.mrd";		//L
			}
 		}else if(temp_LR == "L") {
 			if(temp_incCntrDtail == "N"){
				mrd_file = "EES_DMT_4908.mrd";
			}else{
			    mrd_file = "EES_DMT_4901.mrd";		//L
			}
 		}else if(temp_LR == "R") {
 			if(temp_incCntrDtail == "N"){
				mrd_file = "EES_DMT_4909.mrd";
			}else{
				 mrd_file = "EES_DMT_4902.mrd";		//R
			}
 		}
		
//		//SEND
//		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//		sndr_email	= ComGetObjValue(formObj.session_email);
//		
//		//RCV
//		var arr_faxnos 	= ComGetObjValue(formObj.payr_faxnos).split(";");
//		var re_faxnos	= "";
//		
//		for (var i = 0 ; i < arr_faxnos.length ; i++) {
//			re_faxnos	+= ComGetObjValue(formObj.payerCd) + ";" + arr_faxnos[i];
//			msg1		+= arr_faxnos[i] + "\n\t";
//		}
//		if (!ComShowCodeConfirm("DMT01092", msg1))	return;
		var dmdtInvNo=ComGetObjValue(formObj.invoiceNo);
		var blNo=ComGetObjValue(formObj.blNo); 
		var payerCd=ComGetObjValue(formObj.org_payer_cd);
		var ma_param="jspno=4004"
			 + "&invoice_no=" + dmdtInvNo
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
			 ;		
		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		//rd_fxeml_rd_param
		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "	
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4004&invoice_no="+dmdtInvNo+"&cre_ofc_cd="+ComGetObjValue(formObj.issueOfcCd)+"]"		//jspno, invoice_no
					;
		ComSetObjValue(formObj.invno,					dmdtInvNo);
		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
		ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
		ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
		ComSetObjValue(formObj.rd_fxeml_title,			"Invoice(INV#: " + dmdtInvNo + ")");
		ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
		ComSetObjValue(formObj.rd_fxeml_fax_no,			ComGetObjValue(formObj.payr_faxnos));			//rcvr_fax_no
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_add,	"");			//sndr_email
		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");	//rcvr_email	//mjchang@COMPANY.com
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	"");
		ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo);	//"name;mjchang|message;" + mailCtnt);
		ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
		ComSetObjValue(formObj.payc,					payerCd);
		ComSetObjValue(formObj.invno,					dmdtInvNo);
		//doActionIBSheet(sheetObj,formObj,IBSEARCH_SEND_FAX);
   }
   
     function doActionEmail() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[2];
// 		if(ComGetObjValue(formObj.payr_emailnos) == "") {
// 			ComShowCodeMessage("DMT01091");
// 			return;
// 		}
 		var mrd_file="";
// 		var sndr_id		= "";	//id
// 		var sndr_name	= "";	//
// 		var sndr_email	= "";	//
// 		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
// 		var rcvr_email	= "";	//
// 		var msg1		= "";
 		var temp_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
 		var temp_incCntrDtail	= ComGetObjValue(formObj.incCntrDtail);
 		var rhq	                = ComGetObjValue(formObj.rhq_ofc_cd); //2011.12.26 추가
 		var ofc_cd              = ComGetObjValue(formObj.issueOfcCd) //2012.01.11
 		/*
 		if (temp_LR == "" || temp_LR == "L") {
 			mrd_file="EES_DMT_4901.mrd";		//L
 		}
 		else if(temp_LR == "R") {
 			mrd_file="EES_DMT_4902.mrd";		//R
 		}
 		*/
 		
 		if(temp_LR == "") {
			if(temp_incCntrDtail == "N"){
				mrd_file = "EES_DMT_4908.mrd";
			}else{
				  mrd_file = "EES_DMT_4901.mrd";		//L
			}
 		}else if(temp_LR == "L") {
 			if(temp_incCntrDtail == "N"){
				mrd_file = "EES_DMT_4908.mrd";
			}else{
				 mrd_file = "EES_DMT_4901.mrd";		//L
			}
 		}else if(temp_LR == "R") {
 			if(temp_incCntrDtail == "N"){
				mrd_file = "EES_DMT_4909.mrd";
			}else{
				 mrd_file = "EES_DMT_4902.mrd";		//R
			}
 		}
 		
// 		//SEND
// 		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
// 		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
// 		sndr_email	= ComGetObjValue(formObj.session_email);
// 		
// 		//RCV
//		rcvr_email		= ComGetObjValue(formObj.payr_emailnos);
//		var arr_emails	= ComGetObjValue(formObj.payr_emailnos).split(";");
// 		
// 		for(var i=0 ; i < arr_emails.length; i++) {
// 			msg1		+= arr_emails[i] +"\n\t";
// 		}
// 		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
		var dmdtInvNo=ComGetObjValue(formObj.invoiceNo);
		var blNo=ComGetObjValue(formObj.blNo); 		
		var payerCd=ComGetObjValue(formObj.org_payer_cd);
		var ma_param="jspno=4004"
			 + "&invoice_no=" + dmdtInvNo
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
			 ;		
		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	ma_param);
		//var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	"jspno=4004&invoice_no="+dmdtInvNo+"&f_cmd="+SEARCH01);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		//rd_fxeml_rd_param
		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4004&invoice_no="+dmdtInvNo+"&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)+"]"		//jspno, invoice_no
					;

		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
		ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
		ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
		ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Ref # " + dmdtInvNo);
		ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
		ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_fixed,	"shipment.info@notifications.nykline.com");				// use when should fix sndr_email
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.invoiceNo));
		ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo);	//"name;mjchang|message;" + mailCtnt);
		ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
		ComSetObjValue(formObj.payc,					payerCd);
		ComSetObjValue(formObj.invno,					dmdtInvNo);
// 		doActionIBSheet(sheetObj,formObj,IBSEARCH_SEND_EMAIL);
    }
    
    function doActionARIF() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
		if((ComGetObjValue(formObj.usr_cnt_cd) != "US") && (ComGetObjValue(formObj.usr_cnt_cd) != "CA")) {
    		if (ComGetObjValue(formObj.payerCd).length <= 6) {
    			ComShowCodeMessage("DMT00185");
    			return;
    		}
    	}    	
//    		if (ComGetObjValue(formObj.payerCd).length <= 6) {
//    			ComShowCodeMessage("DMT00185");
//    			return;
//    		}
    	if (!ComShowCodeConfirm("DMT03026")) return; 
    	doActionIBSheet(sheetObj,formObj,IBSEARCH_ARIF);
    }
    
    function doActionClose() {
    	//ComClosePopup();
		//window.returnValue="Y";
    	ComPopUpReturnValue("Y");
    }
    
	function fetchNextSeq(sheetObj) {
		var currSeq=0;
		var nextSeq=0;
		with(sheetObj) {
			var col=(id == "sheet1") ? INV_DTL_SEQ : INV_RT_SEQ;
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				currSeq=ComParseInt(GetCellValue(row, col));
				nextSeq=currSeq > nextSeq ? currSeq : nextSeq;
			}
		}
		return nextSeq + 1;
	} 
	
    function fetchRTFromVal() {
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
		var fromVal=0;
		with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
		}
		with(sheetRTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&	invNo 	== GetCellValue(row, INV_NO)
					&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
					&& 	ofcCd 	== GetCellValue(row, CRE_OFC_CD)	) {
					fromVal=ComParseInt(GetCellValue(row, FT_UND_DYS));
				}
			}
		}
		return fromVal + 1;
    }
    
    function fetchRateRowCountOfCharge() {
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
		var totalCount=0;
		with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
		}
		with(sheetRTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&	invNo 	== GetCellValue(row, INV_NO)
					&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
					&& 	ofcCd	== GetCellValue(row, CRE_OFC_CD)	) {
					totalCount++;
				}
			}
		}
		return totalCount;
    }
    
    function fetchRateFirstRowOfCharge() {
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
		var firtRow=0;
		with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
		}
		with(sheetRTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&	invNo 	== GetCellValue(row, INV_NO)
					&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
					&& 	ofcCd	== GetCellValue(row, CRE_OFC_CD)	) {
					firstRow=row;
					break;
				}
			}
		}
		return firstRow;
    }
    
    function fetchChargeRowCount() {
		var sheetCHGObj=sheetObjects[0];
		var totalCount=0;
		with(sheetCHGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					totalCount++;
				}
			}
		}
		return totalCount;
    }
    
    function checkContainerNo() {
    	var formObj=document.form;
    	var sheetCHGObj=sheetObjects[0];
    	doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_CHECK_CNTRNO);
    	if (ComGetObjValue(formObj.result) == "Y") {
   			sheetCHGObj.SetCellValue(sheetCHGObj.GetSelectRow(), CNTR_TPSZ_CD, ComGetObjValue(formObj.result2), 0);
    	}
    	else {
    		ComShowCodeMessage("DMT00171", "CNTR No.!");
    		sheetCHGObj.SetCellValue(sheetCHGObj.GetSelectRow(), CNTR_NO, "", 0);
    	}
    }
    
    function resetOverDay() {
	    var sheetCHGObj=sheetObjects[0];
	    var sheetRTObj=sheetObjects[1];
	    var ftOverDays=0;
	    if (!checkFromDTBetweenToDT(TO_MVMT_DT)) return;
	    if (!checkFTEndDTBetweenFTCmncDT(FT_END_DT)) {
	    	initRateDetail();
			calcBillableAmount(false);
			return;
	    }
	    if (!checkFTEndDT()) return;
	    //====================================================================================================
	    with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
			var ftToDT=GetCellValue(GetSelectRow(), TO_MVMT_DT);
			var ftEndDT=GetCellValue(GetSelectRow(), FT_END_DT);
	    }
	    
	    if (ftToDT != "" && ftEndDT != "") {
	    	ftOverDays=retrieveDaysBetween(ftEndDT, ftToDT);
			if (ftOverDays < 0) {
				ComShowCodeMessage("DMT01089", "To Date", "F/T End Date");
				sheetCHGObj.SetCellValue(sheetCHGObj.GetSelectRow(), FT_END_DT, "", 0);
				ftOverDays=0;
			}
	    }
		else {
			ftOverDays=0;
		}
	    var isRowDelete=false;
	    var prevUpTo=0;
	    if (ftOverDays > 0) {
	    	with(sheetRTObj) {
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					if (	GetRowStatus(row) != "D"
						&&	invNo 	== GetCellValue(row, INV_NO)
						&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
						&& 	ofcCd 	== GetCellValue(row, CRE_OFC_CD)	) {
						if (!isRowDelete) {
							if (GetCellValue(row, FT_UND_DYS) == "") {
								SetCellValue(row, RT_OVR_DYS,ftOverDays,0);
								ftOverDays=0;
							}
							else if (ComParseInt(GetCellValue(row, FT_UND_DYS)) < ComParseInt(GetCellValue(row, FT_OVR_DYS))) {
								ComShowCodeMessage("COM12133", "'From'", "'Up To'", "earlier");
								SetCellValue(row, FT_UND_DYS, "", 0);
								SetCellValue(row, RT_OVR_DYS, ftOverDays, 0);
								ftOverDays=0;								
							}
							if (prevUpTo > 0) {
								SetCellValue(row, FT_OVR_DYS, prevUpTo + 1, 0);
							}
							var intervalDays=ComParseInt(GetCellValue(row, FT_UND_DYS)) - ComParseInt(GetCellValue(row, FT_OVR_DYS)) + 1;
							if (ftOverDays == 0) {
								isRowDelete=true;
							}
							else if (ftOverDays > intervalDays) {
								SetCellValue(row, RT_OVR_DYS, intervalDays, 0);
								ftOverDays -= intervalDays;
								prevUpTo=ComParseInt(GetCellValue(row, FT_UND_DYS));
							}
							else if (ftOverDays <= intervalDays) {
								SetCellValue(row, RT_OVR_DYS, ftOverDays, 0);
								ftOverDays=0;			
								isRowDelete=true;
							}
						}
						else {
							if (GetRowStatus(row) == 'I') {
								SetCellValue(row, DEL_FLAG, "Y", 0);
							}
							else {
								SetRowStatus(row, 'D');
								SetRowHidden(row, 1);
							}							
						}
					}
				}
				if (ftOverDays > 0) {
					doActionAddRate();
					SetCellValue(LastRow(), RT_OVR_DYS, ftOverDays, 0);
				}
				doActionDelRateByDelMark();
	    	}
	    }
	    else {
	    	initRateDetail();
	    }
		calcBillableAmount(false);
    }
 	function compareFTDate() {
 	    var sheetCHGObj=sheetObjects[0];
 	    with(sheetCHGObj) {
			var ftEndDT=GetCellValue(GetSelectRow(), FT_END_DT);
			var ftCmncDT=GetCellValue(GetSelectRow(), FT_CMNC_DT);
			var ftDT=GetCellValue(GetSelectRow(), FT_DYS);
 			if (ftEndDT != "" && ftCmncDT != "") {
 				var intervalDT=ComParseInt(retrieveDaysBetween(ftCmncDT, ftEndDT)) + 1;
 				if (ftDT != "") {
 					if (intervalDT < ftDT) {
 						return false;
 					}
 				}
 			}
 	    }
 	    return true;
 	}
 	
    function checkFTEndDT() {
     	var sheetCHGObj=sheetObjects[0];
 		if (!compareFTDate()) {
 			ComShowCodeMessage("DMT00171", "F/T End date.");
 			sheetCHGObj.SetCellValue(sheetCHGObj.GetSelectRow(), FT_END_DT, "", 0);
 			return false;
 		}
 		return true;
    }
    
	function checkFromDTBetweenToDT(COL) {
		var sheetCHGObj=sheetObjects[0];
		with(sheetCHGObj) {
			var fmMvmtDT=GetCellValue(GetSelectRow(), FM_MVMT_DT);
			var toMvmtDT=GetCellValue(GetSelectRow(), TO_MVMT_DT);
		}
		if (fmMvmtDT != "" && toMvmtDT != "") {
			var intervalDT=retrieveDaysBetween(fmMvmtDT, toMvmtDT);
			if (intervalDT < 0) {
				ComShowCodeMessage("DMT01020");
				sheetCHGObj.SetCellValue(sheetCHGObj.GetSelectRow(), COL, "", 0);
				return false;
			}
		}
		return true;
	}
	
    function checkFTEndDTBetweenFTCmncDT(COL) {
 		var sheetCHGObj=sheetObjects[0];
 		with(sheetCHGObj) {
			var ftCmncDT=GetCellValue(GetSelectRow(), FT_CMNC_DT);
			var ftEndDT=GetCellValue(GetSelectRow(), FT_END_DT);
 		}
 		if (ftCmncDT != "" && ftEndDT != "") {
 			var intervalDT=retrieveDaysBetween(ftCmncDT, ftEndDT);
 			if (intervalDT < 0) {
 				ComShowCodeMessage("DMT01031", "F/T End", "F/T CMNC");
 				sheetCHGObj.SetCellValue(sheetCHGObj.GetSelectRow(), COL, "", 0);
 				return false;
 			}
 		}
 		return true;
 	}
 	function doActionDelRateByDelMark() {
 		var sheetRTObj=sheetObjects[1];
 		with(sheetRTObj) {
 			for (var row=LastRow(); row >= HeaderRows(); row--) {
 				if (GetCellValue(row, DEL_FLAG) == "Y") {
 					RowDelete(row, false);
 				}
 			}
 		}
 	}
 	
    function changeChargeRate() {
    	var formObj=document.form;
    	var sheetCHGObj=sheetObjects[0];
    	var sheetRTObj=sheetObjects[1];
    	if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
    		with(formObj) {
    			chargeCurrency.selectedIndex=0;
    			ComEnableManyObjects(true, chargeCurrency);
    			chargeCurrency.className="input1";
    		}    		
    		enableBtnCharge(true);
    	}
    	else {
    		clearGrid(sheetCHGObj);
    		clearGrid(sheetRTObj);
    		ComSetObjValue(formObj.cntrQty, "");
    		with(formObj) {
    			chargeCurrency.selectedIndex=-1;
    			ComEnableManyObjects(false, chargeCurrency);
    			chargeCurrency.className="input2";
    		}
    		enableBtnCharge(false);
    	}
 	}
 	
	function clearGrid(sheetObj) {
		with(sheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) == 'I') {
					RowDelete(row, false);
				}			
				else {
					SetRowStatus(row, "D");
					SetRowHidden(row, 1);
				}
			}
		}
	}
	
	function enableBtnCharge(flg) {
		if (flg) {
			ComBtnEnable("btn_AddCharge");
			ComBtnEnable("btn_CopyCharge");
			ComBtnEnable("btn_DelCharge");
			ComBtnEnable("btn_InqMVMT");
		}
		else {
			ComBtnDisable("btn_AddCharge");
			ComBtnDisable("btn_CopyCharge");
			ComBtnDisable("btn_DelCharge");
			ComBtnDisable("btn_InqMVMT");			
		}
	}
	
	function displaySelectedRateDetail() {
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
		with(sheetCHGObj) {
			var invNo=GetCellValue(GetSelectRow(), INV_NO);
			var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
			var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
		}
		with(sheetRTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&	invNo 	== GetCellValue(row, INV_NO)
					&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
					&& 	ofcCd 	== GetCellValue(row, CRE_OFC_CD)	) {
					SetRowHidden(row, 0);
				}
				else {
					SetRowHidden(row, 1);
				}
			}
		}
	}
	
	function changeChargeRowStatus(sts) {
		var sheetCHGObj=sheetObjects[0];
		with(sheetCHGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetRowStatus(row, sts);
			}
		}		
	}
	
	function setInvoiceDetailSeq() {
		var sheetCHGObj=sheetObjects[0];
		var invDtlSeq=0;
		with(sheetCHGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellValue(row, INV_DTL_SEQ, ++invDtlSeq, 0);
			}
		}		
	}
	
	function calcBillableAmount(isCalculated, caller) {
		var formObj=document.form;
		var sheetCHGObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[1];
		var billableAmt=0;
		with(sheetCHGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					var invNo=GetCellValue(row, INV_NO);
					var dtlSeq=GetCellValue(row, INV_DTL_SEQ);
					var ofcCd=GetCellValue(row, CRE_OFC_CD);
					for (var subRow=sheetRTObj.HeaderRows(); subRow <= sheetRTObj.LastRow(); subRow++) {
						if (	sheetRTObj.GetRowStatus(subRow) != "D"
							&&	invNo 	== sheetRTObj.GetCellValue(subRow, INV_NO)
							&&	dtlSeq 	== sheetRTObj.GetCellValue(subRow, INV_DTL_SEQ)
							&& 	ofcCd 	== sheetRTObj.GetCellValue(subRow, CRE_OFC_CD)	) {
							
							if (	sheetRTObj.GetCellValue(subRow, INV_RT_AMT) != ""
								&& 	sheetRTObj.GetCellValue(subRow, RT_OVR_DYS) != ""	) {
								if (!isCalculated) {
									sheetRTObj.SetCellValue(subRow, RT_OVR_CHG_AMT, parseFloat(sheetRTObj.GetCellValue(subRow, INV_RT_AMT)) * parseFloat(sheetRTObj.GetCellValue(subRow, RT_OVR_DYS)));
								}
								billableAmt += parseFloat(sheetRTObj.GetCellValue(subRow, RT_OVR_CHG_AMT));
							}
						}
					}
				}
			}
		}
		billableAmt=billableAmt + "";
		ComSetObjValue(formObj.billableAmt, setDataFormat(billableAmt, "AMT"));
		doCalculate(caller);
	}
	
    function doCalculate(caller) {
    	var formObj=document.form;
    	var cboTariff=comboObjects[0];
    	var sheetCHGObj=sheetObjects[0];
    	var inclCNTRDetail=ComGetObjValue(formObj.incCntrDtail);
    	var invoiceCurrency=ComGetObjValue(formObj.invoiceCurrency);    
    	if (invoiceCurrency == "")	return;
    	//Billable AMT
    	var billableAmt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.billableAmt), "float"));
    	//Ex. Rate
		var exRate=ComRound(ComGetObjValue(formObj.exRate), 6);	
		//Total AMT
		var totAmt = 0;
		if (inclCNTRDetail == "Y")
			 totAmt=DMTtrimCurrencyAmount(invoiceCurrency, (exRate * parseFloat(billableAmt)));
		else {
			totAmt=DMTtrimCurrencyAmount(invoiceCurrency, parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.totalAmt), 		"float")));
		}
		//Billing AMT
		var billingAmt = 0;
		//D/C by AMT or %
		var dcAmt = 0;
		if (caller == "Retrieve") {
			billingAmt=DMTtrimCurrencyAmount(invoiceCurrency, parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.billingAmt), 	"float")));
			dcAmt=DMTtrimCurrencyAmount(invoiceCurrency, (totAmt - billingAmt));
		}
		else {
			if (inclCNTRDetail == "Y") {
				dcAmt=DMTtrimCurrencyAmount(invoiceCurrency, parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.dcAmtRate), 		"float")));
				billingAmt=DMTtrimCurrencyAmount(invoiceCurrency, (totAmt - dcAmt));
			}
			else {
				billingAmt=DMTtrimCurrencyAmount(invoiceCurrency, parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.billingAmt), 	"float")));
				dcAmt=DMTtrimCurrencyAmount(invoiceCurrency, 0);
				billingAmt=totAmt - dcAmt;
			}
		}
		if (totAmt > 0 && totAmt < dcAmt) {
			ComShowCodeMessage("DMT00183");
			ComClearObject(formObj.dcAmtRate);
			ComSetFocus(formObj.dcAmtRate);
			dcAmt=0;
		}
    	//Tax Rate
    	var taxRate = 0;
    	if (ComGetObjValue(formObj.taxRate) == "") {
    		taxRate=0;
    	}
    	else {
    		taxRate=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.taxRate),"float")); 	//Tax Rate
    	}
		//Tax AMT
		var taxAmt = 0;
		var cre_cnt_cd=ComTrim(ComGetObjValue(formObj.status)) != "" ? ComGetObjValue(formObj.cre_cnt_cd) : ComGetObjValue(formObj.usr_cnt_cd);
//		if (cre_cnt_cd == "VN") {
//			taxAmt=(billingAmt / (1 - taxRate * 0.01)) * (taxRate * 0.01);
//		}
		//=========================================
		//2015.10.27 #7995 comment start 
		//2017.01.12 #23259
		if(cre_cnt_cd == "IN" ){  
			//india 은  신규생성시만 재계산함. 
		     if ( !isPopupWindow() && ComGetObjValue(formObj.invoiceNo) == "" ){

				  var ida_expn_tax_rt     = parseFloat(ComGetObjValue(formObj.ida_expn_tax_rt));
				  var ida_edu_tax_rt      = parseFloat(ComGetObjValue(formObj.ida_edu_tax_rt));
				  var ida_high_edu_tax_rt = parseFloat(ComGetObjValue(formObj.ida_high_edu_tax_rt));
				  var ida_expn_tax = 0;
				  var ida_edu_tax = 0;
				  var ida_high_edu_tax = 0;
				 
				  // Service Tax
				 ida_expn_tax = ComRound( ( billingAmt * ida_expn_tax_rt * 0.01), 2 )
				 ComSetObjValue(formObj.ida_expn_tax, ida_expn_tax);
				
				// Education Cess
				 ida_edu_tax = ComRound( (ida_expn_tax * ida_edu_tax_rt * 0.01), 2 )
				 ComSetObjValue(formObj.ida_edu_tax, ida_edu_tax);
				
				// Higher Edu Cess
				 ida_high_edu_tax = ComRound( (ida_expn_tax * ida_high_edu_tax_rt * 0.01), 2 )
				 ComSetObjValue(formObj.ida_high_edu_tax, ida_high_edu_tax);
				
				// Total Service Tax
				 taxAmt = parseFloat(ida_expn_tax) + parseFloat(ida_edu_tax) + parseFloat(ida_high_edu_tax) ;
		     }else{
		    	 taxAmt = parseFloat(ComGetObjValue(formObj.taxAmt));
		     }
		}
		//2015.10.27 #7995 comment e n d
		//=========================================	
		else {
			taxAmt=(taxRate * 0.01) * billingAmt;
		}
		taxAmt=DMTtrimCurrencyAmount(invoiceCurrency, taxAmt);
		//Payable AMT 
		var payableAmt=DMTtrimCurrencyAmount(invoiceCurrency, billingAmt + taxAmt);
		if (inclCNTRDetail == "Y") {
			//Ex. Rate
			ComSetObjValue(formObj.exRate, setDataFormat(exRate, "EX_RATE"), "EX_RATE");
		}
		//Total AMT
		ComSetObjValue(formObj.totalAmt, 	setDataFormat(totAmt, "AMT"));
		//D/C by AMT or %
		ComSetObjValue(formObj.dcAmtRate, 	setDataFormat(dcAmt, "AMT"));
		//Billing AMT
		ComSetObjValue(formObj.billingAmt, 	setDataFormat(billingAmt, "AMT"));
		//Tax Rate/ AMT
		ComSetObjValue(formObj.taxAmt, 		setDataFormat(taxAmt, "AMT"));
		//Payable AMT
		ComSetObjValue(formObj.payableAmt, 	setDataFormat(payableAmt, "AMT"));
    }
    
 	function doProcessPopup(caller) {
 		var formObj=document.form;
 		var cboTariff=comboObjects[0];
 		var cboAttention=comboObjects[1];
 		var sheetCHGObj=sheetObjects[0];
 		var paramVal, sUrl, sWidth, sHeight;
 		var invIssue=ComGetObjValue(formObj.invoiceNo) != "" ? 2 : 1;
 		with(sheetCHGObj) {
	  		switch(caller) {
	  			case "btn_InqMVMT":
	  				if (fetchChargeRowCount() > 0) {
						var cntrNo=GetCellValue(GetSelectRow(), CNTR_NO);
						var cntrTpSzCd=GetCellValue(GetSelectRow(), CNTR_TPSZ_CD);
	  					if (cntrNo != "" && cntrTpSzCd != "") {
	  						paramVal="?pop_mode=Y&p_cntrno=" + cntrNo + "&ctnr_tpsz_cd=" + cntrTpSzCd;
	  						ComOpenPopup('EES_CTM_0408_POP.do' + paramVal, 1036, 610, "getInqMVMT", "1,0,1,1,1,1,1", true);
	  					}
	  				}
					return;
					break;
	  			case "btn_PayerCd":	
	  				ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true);
	  				return;
					break;
	  			case "btn_TruckerCd":
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 488, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				return;
	  				break;
  				case "btn_SheetSet":
  					paramVal="?issoff=" 		+ ComGetObjValue(formObj.issueOfcCd)
							+ "&tftp2=" 		+ cboTariff.GetSelectText()
							+ "&sheetp=I"
							+ "&invoice_issue=" + invIssue
							+ "&jspno=EES_DMT_4004";
					sUrl="EES_DMT_4101.do" + paramVal;
					sWidth  = "725";
          			sHeight = "550";
  					break;
				case "btn_SheetOption":
					paramVal="?issoff=" 		+ ComGetObjValue(formObj.issueOfcCd)
							+ "&jspno=EES_DMT_4004"
							+ "&invoice_issue=" + invIssue
							+ "&tftp=" 			+ cboTariff.GetSelectText();
					sUrl="EES_DMT_4103.do" + paramVal;
					sWidth  = "625";
          			sHeight = "680";
          			break;  				
				case "btn_Cancel":
          			if (ComGetObjValue(formObj.issueOfcCd) == ComGetObjValue(formObj.session_ofc_cd)) {
          				if (ComShowCodeConfirm('DMT03025')) {
          					paramVal="?dmdt_inv_no=" 	+ ComGetObjValue(formObj.invoiceNo)
          							+ "&cre_ofc_cd=" 	+ ComGetObjValue(formObj.issueOfcCd)
          							+ "&dmdt_trf_cd=" 	+ cboTariff.GetSelectText();
          						sUrl="EES_DMT_4106.do" + paramVal;
          						sWidth  = "500";
          	          			sHeight = "442";
          				}
          				else
          					return;
          			}
      				else {
      					ComShowCodeMessage('DMT03024', ComGetObjValue(formObj.issueOfcCd), ComGetObjValue(formObj.session_ofc_cd));
      					return;
      				}
          			break;
				case "btn_SendingHistory":
					paramVal="?jspno=EES_DMT_4004"
							+ "&invoice=" + ComGetObjValue(formObj.invoiceNo)
							+ "&selectOpt=1";
					sUrl="EES_DMT_7006_P.do" + paramVal;
					sWidth  = "1036";
		  			sHeight = "650";
					break;
				case "btn_Preview":
					paramVal="?payr_cntc_pnt_phn_no=" + ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
							+ "&payr_cntc_pnt_fax_no=" 	+ ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
							+ "&payr_cntc_pnt_eml=" 	+ ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
							+ "&dmdt_payr_cntc_pnt_nm=" + ComGetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm)
							+ "&invoice_no=" 			+ ComGetObjValue(formObj.invoiceNo)
							+ "&invoice_LR=" 			+ ComGetObjValue(formObj.bil_to_loc_div_cd)
							+ "&cre_ofc_cd=" 			+ ComGetObjValue(formObj.issueOfcCd)
							+ "&payer_cd=" 				+ ComGetObjValue(formObj.org_payer_cd)
							+ "&bkg_no=" 				+ ComGetObjValue(formObj.bkgNo)
							+ "&bl_no=" 				+ ComGetObjValue(formObj.blNo)
							+ "&pod_cd=" 				+ ComGetObjValue(formObj.podCd)
							+ "&dmdt_trf_cd="			+ cboTariff.GetSelectText()
							+ "&inc_cntr_dtail="		+ ComGetObjValue(formObj.incCntrDtail)
							+ "&rhq_ofc_cd="            + ComGetObjValue(formObj.rhq_ofc_cd)
							+ "&usr_cnt_cd="            + ComGetObjValue(formObj.usr_cnt_cd)
							+ "&cre_cnt_cd="            + ComGetObjValue(formObj.cre_cnt_cd)
							+ "&jspno=4004";
					sUrl="EES_DMT_4003.do" + paramVal;
					sWidth  = "950";
					sHeight = "680";
					break;
				case "btn_PayerInfo":
					if (ComGetObjValue(formObj.payerCd) == null || ComGetObjValue(formObj.payerCd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					if (ComGetObjValue(formObj.status) == "") {
						ofc_cd=ComGetObjValue(formObj.session_ofc_cd);
					}
					else {
						ofc_cd=ComGetObjValue(formObj.issueOfcCd);
					}
					paramVal="?s_ofc_cd=" + ofc_cd
							+ "&s_cust_cd=" + ComGetObjValue(formObj.payerCd)
							+ "&s_bkg_no=" 	+ ComGetObjValue(formObj.bkgNo)
							+ "&s_pod_cd=" 	+ ComGetObjValue(formObj.podCd)
							+ "&jspno=EES_DMT_4004"
							+ "&attn=" 		+ ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
							+ "&telno=" 	+ ComGetObjValue(formObj.tel)
							+ "&faxno=" 	+ ComGetObjValue(formObj.fax)
							+ "&email=" 	+ ComGetObjValue(formObj.email);	
					sUrl="EES_DMT_4104.do" + paramVal;
					sWidth  = "825";
		  			sHeight = "580";
					break;
				case "btn_Fax":
					if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd="";
					if(invIssue == "1") {
						return;
					}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
						ofc_cd=ComGetObjValue(formObj.issueOfcCd);
					}
					sUrl="EES_DMT_4107.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj.bkgNo)
						+"&s_pod_cd="+ComGetObjValue(formObj.podCd)
						+"&jspno=4004"
						+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
						;
					sWidth  = "520";
		  			sHeight = "250";
					break;
				case "btn_Email":
					if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd="";
					if(invIssue == "1") {
						return;
					}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
						ofc_cd=ComGetObjValue(formObj.issueOfcCd);
					}
					sUrl="EES_DMT_4108.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj.bkgNo)
						+"&s_pod_cd="+ComGetObjValue(formObj.podCd)
						+"&jspno=4004"
						+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
						;
					sWidth  = "520";
		  			sHeight = "250";
					break;
	  		} // switch-end
 		} // with-end
  		if (sUrl.indexOf(".do") != -1) {
  			
  			// 부모창으로부터 응답을 받은경우, 취소일 경우에만 조회를 실행하도록 구분해주기 위함.
  			isCancelAction = caller == "btn_Cancel";
  			
  			if (caller == "btn_SheetSet") {
  				ComOpenPopup(sUrl, sWidth, sHeight, "callbackProc1", "0,1", true);
  				
  			}
  			else {
  				ComOpenPopup(sUrl, sWidth, sHeight, "callbackProc2", "0,1", true);
  			}
  			//###########################################################################################################		
  		} 
  	}
 	
 	function callbackProc1(rtnVal) {
 		doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_CHECK_SHEETSET, COMMAND13);
  	} 	
 	function callbackProc2(rtnVal) {
 		if (isCancelAction && rtnVal == "Y") {
 			doActionRetrieve();
  		} 
 	}
 	
  	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
  		var formObj=document.form;
 		var sheetCHGObj=sheetObjects[0];
		if (cr_term_dys == "0" && is_dt_prn_flg == "2") {
			is_dt_prn_flg="N";
		} 
		else {
			is_dt_prn_flg="Y";
		}
  		if (cr_term_dys != null && cr_term_dys != "") {
  			if (ComGetObjValue(formObj.incCntrDtail) == "N") {
				ComClearObject(formObj.dueDate);
				ComClearObject(formObj.creditTerm);
  			}
  			else if (!isPopupWindow()) {
  				if (cr_term_dys == "0") {
  					if (is_dt_prn_flg == "Y") {
  						ComSetObjValue(formObj.dueDate, ComGetObjValue(formObj.ofc_curr_date));
  						ComSetObjValue(formObj.dueDate, ComGetMaskedValue(ComGetObjValue(formObj.dueDate), "ymd"));
  						//0
  						ComSetObjValue(formObj.creditTerm, "0");
  					} 
  					else if(is_dt_prn_flg == "N") {
  						ComSetObjValue(formObj.dueDate, "********");
  						ComClearObject(formObj.creditTerm);
  					}
  				} 
  				else if (parseInt(cr_term_dys) > 0) {
  					ComSetObjValue(formObj.dueDate, ComGetObjValue(formObj.ofc_curr_date));
  					ComSetObjValue(formObj.dueDate, ComGetMaskedValue(ComGetObjValue(formObj.dueDate), "ymd"));
  					ComSetObjValue(formObj.creditTerm, cr_term_dys);
  				}
  			}
  			else if (isPopupWindow()) {
  				if (cr_term_dys == "0") {
  					if (is_dt_prn_flg == "Y") {
  						ComSetObjValue(formObj.dueDate, ComGetObjValue(formObj.issueDate));
  						//0
  						ComSetObjValue(formObj.creditTerm, "0");
  					}
  					else if(is_dt_prn_flg == "N") {
  						ComSetObjValue(formObj.dueDate, "********");
  						ComSetObjValue(formObj.creditTerm, "");
  					}
  				}
  				else {
  					var cal_due_date=ComGetDateAdd(ComGetObjValue(formObj.issueDate), "D", parseInt(cr_term_dys)); 
  					ComSetObjValue(formObj.dueDate, cal_due_date);
  					ComSetObjValue(formObj.creditTerm, cr_term_dys);
  				}
  			}
  		}
  		if (tax_rto == null || tax_rto == "") {
  			tax_rto="0";
  		}
  		//tax_rto
  		ComSetObjValue(formObj.dflt_tax_rto, tax_rto);
  		if (formObj.chkTaxRateAmt.checked) {
  			
  			ComSetObjValue(formObj.taxRate, ComGetObjValue(formObj.dflt_tax_rto));
  			doCalculate();
  		}
		doActionIBCommon(sheetCHGObj,formObj,IBSEARCH_SHEET_OPT,COMMAND14);
  	}
  	
 	function getInqMVMT() {
    	var formObj=document.form;
 	}
 	
    function getCustCd(aryPopupData) {
    	var formObj=document.form;
    	var cboAttention=comboObjects[1];
    	formObj.payerCd.value=aryPopupData[0][3];
    	formObj.payerNm.value=aryPopupData[0][4];
    	if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
	    	searchAttentionList();
	    	if (cboAttention.GetItemCount() > 0) {
	    		cboAttention.SetSelectIndex(0);
	    	}
    	}
    }
    
	function getSvcProvdr(aryPopupData) {
		var formObj=document.form;
 	    ComSetObjValue(formObj.truckerCd, aryPopupData[0][2]);	
 	    ComSetObjValue(formObj.truckerNm, aryPopupData[0][4]);
	}
	
    // Payer, Trucker
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var formObj=document.form;
		var sheetCHGObj=sheetObjects[0];
		var cboTariff=comboObjects[0];
		ComSetObjValue(formObj.f_cmd, formCmd);
	    //Payer check
		if (object.name == "payerCd") {
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_gubun, "");
			var payerCd=ComTrim(ComGetObjValue(formObj.payerCd));
			if (payerCd == "") {
				ComClearObject(formObj.payerNm);
				clearAttention();
				return;
			}
			var cre_cnt_cd=ComTrim(ComGetObjValue(formObj.status)) != "" ? ComGetObjValue(formObj.cre_cnt_cd) : ComGetObjValue(formObj.usr_cnt_cd);
			if (ComIsNumber(payerCd)) {
				if ((cre_cnt_cd == "CA" || cre_cnt_cd == "US") && cboTariff.GetSelectText().substring(1, 2) == "T") {
					// check TPB Customer by Vendor Code
					ComSetObjValue(formObj.s_cust_cd, payerCd);
					ComSetObjValue(formObj.f_cmd, COMMAND22);
		 			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					var custSeq=ComGetEtcData(sXml, "CUST_SEQ");
					if (custSeq == "") {
						ComShowCodeMessage("DMT01156");
						ComSetObjValue(formObj.s_cust_gubun, "");
						ComSetObjValue(formObj.s_cust_cd, "");
						ComClearObject(formObj.payerCd);
						ComClearObject(formObj.payerNm);
						clearAttention();
						return;
					} else {
						ComSetObjValue(formObj.s_cust_gubun, "1");
					}
				}
				else {
					ComShowCodeMessage("DMT00165", "Payer");
					ComClearObject(formObj.payerCd);
					ComClearObject(formObj.payerNm);
					clearAttention();
					ComSetFocus(formObj.payerCd);
					return;
				}
//					ComShowCodeMessage("DMT00165", "Payer");
//					ComClearObject(formObj.payerCd);
//					ComClearObject(formObj.payerNm);
//					clearAttention();
//					ComSetFocus(formObj.payerCd);
//					return;
			}
			else if (payerCd.length > 2) {
				var cntCd=payerCd.substring(0, 2);
				if (ComIsAlphabet(cntCd)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				}
			}
			if (ComGetObjValue(formObj.s_cust_gubun) == "") {
				ComShowCodeMessage("DMT00165", "Payer");
				ComClearObject(formObj.payerCd);
				ComClearObject(formObj.payerNm);
				clearAttention();
				ComSetFocus(formObj.payerCd);
				return;
			}
			ComSetObjValue(formObj.s_cust_cd, payerCd);
			ComSetObjValue(formObj.f_cmd, formCmd);
			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var resPayerCd=setDataFormat(ComGetEtcData(sXml, "PAYER_CODE"));
			var resPayerNm=setDataFormat(ComGetEtcData(sXml, "PAYER_NM"));
			if (resPayerCd == "") {
				ComShowCodeMessage("DMT00165", "Payer");
				clearAttention();
			}
			ComSetObjValue(formObj.payerCd, resPayerCd);
			ComSetObjValue(formObj.payerNm, resPayerNm);
		}
		else if (object.name == "truckerCd") {
			var payerCd=ComGetObjValue(formObj.truckerCd);
			if (payerCd == "") return;
			if (ComIsNumber(payerCd)) {
				ComSetObjValue(formObj.vndr_cd, ComGetObjValue(formObj.truckerCd));
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				ComSetObjValue(formObj.truckerCd, setDataFormat(ComGetEtcData(sXml, "VNDR_CD")));
				ComSetObjValue(formObj.truckerNm, setDataFormat(ComGetEtcData(sXml, "VNDR_NM")));
			}	
			else {
				ComShowCodeMessage("DMT00165", "Payer");
				ComClearObject(formObj.truckerCd);
				ComClearObject(formObj.truckerNm);
				ComSetFocus(formObj.truckerCd);
			}
		}
        sheetObj.SetWaitImageVisible(1);
    }
    
	function searchAttentionList() {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		var sheetCHGObj=sheetObjects[0];
		setPayerCd();
		doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_ATTL, SEARCHLIST03);
	}
	
    function setPayerCd() {
    	var formObj=document.form;
    	var payerCd=ComTrim(ComGetObjValue(formObj.payerCd));
    	//Vendor
    	switch(payerCd.length) {
	    	case 6:
	    		ComSetObjValue(formObj.cust_cnt_cd, "00");
	    		ComSetObjValue(formObj.cust_seq, 	payerCd);
	    		break;
	    	case 8:
	    		ComSetObjValue(formObj.cust_cnt_cd, payerCd.substring(0, 2));
	    		ComSetObjValue(formObj.cust_seq, 	payerCd.substring(2));
	    		break;
	    	default:
	    		ComSetObjValue(formObj.cust_cnt_cd, "");
				ComSetObjValue(formObj.cust_seq, 	"");
    	}
    }
    
	function searchChargeCurrency() {
		var formObj=document.form;
		var sheetCHGObj=sheetObjects[0];
		if (ComGetObjValue(formObj.incCntrDtail) == "N") return;
		var cntCd=getCountryCodeByTariff();
		if (cntCd == "exit") return;
		ComSetObjValue(formObj.cnt_cd, cntCd);
		doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_CHG_CURR)
		if (ComGetObjValue(formObj.cnt_cd) != "") {
			searchExRate();
		}
		else {
			formObj.chargeCurrency.selectedIndex=-1;
			ComClearObject(formObj.exRate);
		}
		doCalculate();
	}
	
	function searchExRate() {
		var formObj=document.form;
		var sheetCHGObj=sheetObjects[0];
		if (ComGetObjValue(formObj.chargeCurrency) == ComGetObjValue(formObj.invoiceCurrency)) {
			ComSetObjValue(formObj.exRate, setDataFormat("1", "EX_RATE"));
		}
		else {
			doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_EX_RATE);	
		}
	}
	
 	function getCountryCodeByTariff() {
 		var formObj=document.form;
 		var cboTariff=comboObjects[0];
 		var obj=event.srcElement;
 		var podCd=ComTrim(ComGetObjValue(formObj.podCd));
 		var delCd=ComTrim(ComGetObjValue(formObj.delCd));
 		var polCd=ComTrim(ComGetObjValue(formObj.polCd));
 		var porCd=ComTrim(ComGetObjValue(formObj.porCd));
 		var eventSrcName=obj.name;
 		var cntCd="";
		switch(cboTariff.GetSelectText()) {
		case "DMIF":
				if (obj.name == "btn_DataDisplay") eventSrcName="podCd";
				if (eventSrcName == "podCd" && podCd.length == 5)
					cntCd=podCd.substring(0, 2);
				else
					cntCd="exit";
				break;
		case "DTIC":
		case "CTIC":
				if (obj.name == "btn_DataDisplay") eventSrcName="delCd";
				if (eventSrcName == "delCd" && delCd.length == 5)
					cntCd=delCd.substring(0, 2);
				else
					cntCd="exit";
				break;			            					
		case "DMOF":
				if (obj.name == "btn_DataDisplay") eventSrcName="polCd";
				if (eventSrcName == "polCd" && polCd.length == 5)
					cntCd=polCd.substring(0, 2);
				else
					cntCd="exit";
				break;
		case "DTOC":
		case "CTOC":
				if (obj.name == "btn_DataDisplay") eventSrcName="porCd";
				if (eventSrcName == "porCd" && porCd.length == 5)
					cntCd=porCd.substring(0, 2);
				else
					cntCd="exit";
				break;
		}
		return cntCd;
 	}
 	
    function setCancelBtnEnable() {
    	var formObj=document.form;
		if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I") {
			ComBtnEnable("btn_Cancel");
		}
		else {
			ComBtnDisable("btn_Cancel");
		}
    }
    
    function setSaveBtnEnable() {
     	var formObj=document.form;
		if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I") {
			ComBtnEnable("btn_Save");
		}
		else {
			ComBtnDisable("btn_Save");
		}
    }
    
    function setCRemarkBtnEnable() {
    	var formObj=document.form;
    	if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "X" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
			ComBtnEnable("btn_CRemark");
			document.getElementById("btn_CRemark").style.color="red";
		} 
		else {
			ComBtnDisable("btn_CRemark");
			document.getElementById("btn_CRemark").style.color="";
		} 
    }
    
    function setHRemarkBtnEnable() {
    	var formObj=document.form;
		if (ComGetObjValue(formObj.arIf) == "H") {
			ComBtnEnable("btn_HRemark");
			document.getElementById("btn_HRemark").style.color="red";
		}
		else {
			ComBtnDisable("btn_HRemark");
			document.getElementById("btn_HRemark").style.color="";
		}
    }
    
    function setARIFBtnEnable() {
        var formObj=document.form;
    	if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "I" || ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C") {
    		if (ComGetObjValue(formObj.arIf) == "N") {
    			ComBtnEnable("btn_Arif");
    		}
    		else {
    			ComBtnDisable("btn_Arif");
    		}
    	}
    	else {
    		ComBtnDisable("btn_Arif");
    	} 
    }
    
    function initBtnMain() {
    	ComBtnEnable("btn_SheetSet");
    	ComBtnEnable("btn_SheetOption");
    	ComBtnDisable("btn_SendingHistory");
    	ComBtnDisable("btn_CRemark");
    	ComBtnDisable("btn_HRemark");
    	ComBtnEnable("btn_New");
    	ComBtnDisable("btn_Save");
    	ComBtnDisable("btn_Cancel");
    	ComBtnDisable("btn_Preview");
    	ComBtnDisable("btn_InvPrint");
    	ComBtnDisable("btn_Fax");
    	ComBtnDisable("btn_Email");
    	ComBtnEnable("btn_PayerInfo");
    	ComBtnDisable("btn_Arif");
    }
    
    function changeTaxRate() {
        var formObj=document.form;
        if (formObj.chkTaxRateAmt.checked) {
        	if (ComGetObjValue(formObj.dflt_tax_rto) != "") {
        		ComSetObjValue(formObj.taxRate, ComGetObjValue(formObj.dflt_tax_rto));
        	}
        	else {
        		var taxRatio=ComGetObjValue(formObj.tax_rto);
        		if (taxRatio == "") {
        			ComSetObjValue(formObj.taxRate, "0");
        		}
        		else {
        			ComSetObjValue(formObj.taxRate, taxRatio);
        		}
        		ComSetObjValue(formObj.taxAmt, 	ComGetObjValue(formObj.tax_amt));
        	}
        }
        else {
        	ComSetObjValue(formObj.taxRate, "0");
        	ComSetObjValue(formObj.taxAmt, "0.00");
        }
        doCalculate();
    }
    
 	function isPopupWindow() {
 	    var formObj=document.form;
 		if (ComGetObjValue(formObj.caller) != "" && ComGetObjValue(formObj.invoiceNo) != "") {
 			return true;
 		}
 		return false;  		
    }
    
 	function isCanCheckCallingPort() {
 		var formObj=document.form;
// 		var cboTariff=comboObjects[0];
		 //CALLING PORT check
 		if (ComGetObjValue(formObj.vvdCd) != "") {
 			if (cboTariff.GetSelectText().substring(2, 3) == "O" && ComGetObjValue(formObj.polCd) != "")
 				return true;
 			else if (cboTariff.GetSelectText().substring(2, 3) == "I" && ComGetObjValue(formObj.podCd) != "")
 				return true;
    	}
 		return false;
 	}
 	
 	function isCanOpenPopupWin(srcName) {
   		var formObj=document.form;
   		var stsCd=ComGetObjValue(formObj.dmdt_inv_sts_cd);
   		var incCntrDtail=ComGetObjValue(formObj.incCntrDtail);
 		if (stsCd != "C" && stsCd != "X") {
 			if (srcName == "btn_PayerCd") {
 				return true;
 			}
 			else if (srcName == "btn_TruckerCd" && incCntrDtail == "Y") {
 				return true;
 			}
 		}
 		return false;
 	}
 	
 	function validateCallPort() {
 		var formObj=document.form;
// 		var cboTariff=comboObjects[0];
 		var sheetCHGObj=sheetObjects[0];
        var vvdCd=ComTrim(ComGetObjValue(formObj.vvdCd));
        var polCd=ComTrim(ComGetObjValue(formObj.polCd));
        var podCd=ComTrim(ComGetObjValue(formObj.podCd));
        var trfCd=ComTrim(cboTariff.GetSelectText());
        var vslCd=vvdCd.substring(0, 4);
        var skdVoyNo=vvdCd.substring(4, 8);
        var skdDirCd=vvdCd.substring(8);
        if (vslCd != "CFDR" || skdDirCd != "E") {
    		ComSetObjValue(formObj.vsl_cd, 		vslCd);
    		ComSetObjValue(formObj.skd_voy_no, 	skdVoyNo);
    		ComSetObjValue(formObj.skd_dir_cd, 	skdDirCd);
    		if (trfCd.substring(2, 3) == "O") {
        		ComSetObjValue(formObj.vps_port_cd, polCd);
        	}
        	else if (cboTariff.GetSelectText().substring(2, 3) == "I") {
        		ComSetObjValue(formObj.vps_port_cd, podCd);
        	}
        	doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_CALLPORT);
        	if (ComGetObjValue(formObj.result) == "N") {
        		ComShowCodeMessage("DMT00175");
        		return false;
        	}
        }
        return true;
 	}
 	
  	function validateVVD() {
  		var formObj=document.form;
  		var sheetCHGObj=sheetObjects[0];
  		var vvdCd=ComTrim(ComGetObjValue(formObj.vvdCd));
		ComSetObjValue(formObj.vsl_cd, 		vvdCd.substring(0, 4));
		ComSetObjValue(formObj.skd_voy_no, 	vvdCd.substring(4, 8));
		ComSetObjValue(formObj.skd_dir_cd, 	vvdCd.substring(8));
		if(ComGetObjValue(formObj.vsl_cd) != "CFDR") {
			doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_CHECK_VVD);
		}else{
			ComSetObjValue(formObj.result, "Y");
		}
  		if (ComGetObjValue(formObj.result) == "Y") return true;
  		return false;
  	}
  	
	function setFieldMandatoryColor() {
		var formObj=document.form;
//		var cboTariff=comboObjects[0];
		with(formObj) {
			if (ComGetObjValue(incCntrDtail) == "Y") {
				// if (cboTariff.GetSelectText().substring(2, 3) == "I") {
				if (cboTariff.value.substring(2, 3) == "I") {
					porCd.className="input";
					polCd.className="input";
					podCd.className="input1";
					delCd.className="input1";					
				}
				else {
					porCd.className="input1";
					polCd.className="input1";
					podCd.className="input";
					delCd.className="input";					
				}
			}
			else {
				// if (cboTariff.GetSelectText().substring(2, 3) == "I") {
				if (cboTariff.value.substring(2, 3) == "I") {
					porCd.className="input";
					polCd.className="input";
					podCd.className="input1";
					delCd.className="input";					
				}
				else {
					porCd.className="input";
					polCd.className="input1";
					podCd.className="input";
					delCd.className="input";					
				}
			}
		}
	}
	
    function enableChargeGrid(flg) {
        var sheetCHGObj=sheetObjects[0];
        sheetCHGObj.SetEditable(flg);
    }
    
   function enableRateGrid(flg) {
       var sheetRTObj=sheetObjects[1];
       sheetRTObj.SetEditable(flg);
   }
   
   function setChargeCurrencyInRT() {
	   var formObj=document.form;
       var sheetRTObj=sheetObjects[1];
       var chargeCur = ComGetObjValue(formObj.chargeCurrency);

       with(sheetRTObj) {
    	   for (var row=HeaderRows(); row <= LastRow(); row++) {
    		   SetCellValue(row, BZC_CURR_CD, chargeCur, 0);
    	   }
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
//        Rdviewer.ApplyLicense("0.0.0.0");
//		var hiddenParam = ["save"];
//        Rdviewer.hideToolbarItem(hiddenParam);
	}
	
	//RD open
    function rdOpen(formObj ){
    	var sheetObj=sheetObjects[2];
//    	var Rdviewer=rdObject ;
    	//var path = formObj.mrd.value;		//mrd_path
    	var path="";
    	var invoice_LR=ComGetObjValue(formObj.bil_to_loc_div_cd);
    	var temp_incCntrDtail	= ComGetObjValue(formObj.incCntrDtail);
    	var rhq             	= ComGetObjValue(formObj.rhq_ofc_cd); // 2011.12.16 추가
    	var ofc_cd              = ComGetObjValue(formObj.issueOfcCd) //2012.01.11
    	var cre_cnt_cd          = ComGetObjValue(formObj.cre_cnt_cd);
    	/*
		if(invoice_LR == "") {
			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "L") {
			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "R") {
			path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
		}
		*/
    	
		var appendReport = [];
    	//=========================================
    	//2015.10.27 #7995 comment start
    	//2017.01.12 #23259
    	if(invoice_LR == "") {
			if(temp_incCntrDtail == "N"){
				if(cre_cnt_cd == "IN"){
	        		// india office 전용 2012.05.18	
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
				}else{
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
				}
			}else{
				if(cre_cnt_cd == "IN"){
	        		// india office 전용 2012.05.18	
					var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
				}else{   
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
				}
			}
		}else if(invoice_LR == "L") {
			if(temp_incCntrDtail == "N"){
				if(cre_cnt_cd == "IN"){
	        		// india office 전용 2012.05.18	
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
				}else{
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
				}
			}else{
				if(cre_cnt_cd == "IN"){
	        		// india office 전용 2012.05.18	
					var mrdPath ="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
				}else{
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
				}
			}
		}else if(invoice_LR == "R") {
			if(temp_incCntrDtail == "N"){
				if(cre_cnt_cd == "IN"){
	        		// india office 전용 2012.05.18	
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4915.mrd";
				}else{
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
				}   
			}else{
				if(cre_cnt_cd == "IN"){
	        		// india office 전용 2012.05.18	
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4913.mrd";
				}else{
					var mrdPath  = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
				}
			}
		}
    	
		/* 2017.01.12 #23259
		if(invoice_LR == "") {
			if(temp_incCntrDtail == "N"){
				var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
			}else{
				var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
			}
		}else if(invoice_LR == "L") {
			if(temp_incCntrDtail == "N"){
				var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
			}else{
				var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
			}
		}else if(invoice_LR == "R") {
			if(temp_incCntrDtail == "N"){
				var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
			}else{
				var mrdPath = RD_path + "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
			}
		}
		*/
		var ma_param="jspno=4004"
			 + "&invoice_no=" + ComGetObjValue(formObj.invoiceNo)
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
			 ;		
		//MASTER DATA retrieving
		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do", ma_param);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		//RD call
		var mrdParam="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA retrieving
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4004&invoice_no=" + ComGetObjValue(formObj.invoiceNo) + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd) + "]"		//jspno, invoice_no
					;
		
		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
		directReportDownload(appendReport);
    	
//    	if(invoice_LR == "") {
//			if(temp_incCntrDtail == "N"){
//			   path = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
//			}else{
//			   path = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
//			}
//		}else if(invoice_LR == "L") {
//			if(temp_incCntrDtail == "N"){
//			   path = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
//			}else{
//			   path = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
//			}
//		}else if(invoice_LR == "R") {
//			if(temp_incCntrDtail == "N"){
//			   path = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
//			}else{
//			   path = "apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
//			}
//		}
//    	//2015.10.27 #7995 comment e n d
//    	//=========================================	
//		
//		var ma_param="jspno=4004"
//			 + "&invoice_no=" + ComGetObjValue(formObj.invoiceNo)
//			 + "&f_cmd=" + SEARCH01
//			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
//			 ;		
//    	//MASTER DATA retrieving
//		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do", ma_param);
//		sheetObj.LoadSearchData(sXml,{Sync:1} );
//		ComEtcDataToForm(formObj, sheetObj);
//		//RD call
//		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA retrieving
//					+ " /rv " + rvParmByInvoice(formObj)
//					+ " /rpost [jspno=4004&invoice_no=" + ComGetObjValue(formObj.invoiceNo) + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd) + "]"		//jspno, invoice_no
//					;
//		Rdviewer.openFile(RD_path+path, rdParm, {timeout:1800});
//		Rdviewer.print({isServerSide:true});
    }
    
    /**
     * rv By Invoice 
     */ 
    function rvParmByInvoice(formObj){
    	/////////////////////////////////////////////////////////////////////////////////////
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
    
    function showRemarkMessage(srcName) {
    	var formObj=document.form;
		if (srcName == "btn_CRemark") {
			var cancel_rmk=ComGetObjValue(formObj.cxl_rmk);		//cancel_remark
			var cancel_date=ComGetObjValue(formObj.upd_dt);		//update_dt
			var ofc_cd=ComGetObjValue(formObj.upd_ofc_cd);	//update_ofc_cd
			var usr_id=ComGetObjValue(formObj.upd_usr_id);	//update_usr_id
			var usr_name=ComGetObjValue(formObj.upd_usr_nm);	//update_usr_nm
			var msg=cancel_rmk
							+ "\n\nCancel Date: " + cancel_date
							+ "\nOffice: " + ofc_cd
							+ "\nUser ID: " + usr_id
							+ "\nUser Name: " + usr_name;
		}
		else if (srcName == "btn_HRemark") {
			var hold_rmk=ComGetObjValue(formObj.inv_hld_rmk);	//hold_remark
			var hold_date=ComGetObjValue(formObj.arIfDate);		//ar_if_dt
			var ofc_cd=ComGetObjValue(formObj.arIfOfc);		//ar_if_ofc_cd
			var usr_id=ComGetObjValue(formObj.arIfId);		//ar_if_usr_id
			var usr_name=ComGetObjValue(formObj.arIfName);		//ar_if_usr_nm
			var msg=hold_rmk
							+ "\n\nHold Date: " + hold_date
							+ "\nOffice: " + ofc_cd
							+ "\nUser ID: " + usr_id
							+ "\nUser Name: " + usr_name;
		}
		ComShowMessage(msg);
    }
    
    function changeChargeCurrency() {
    	var formObj=document.form;
    	if (ComGetObjValue(formObj.chargeCurrency) != "" && ComGetObjValue(formObj.invoiceCurrency) != "") {
    		searchExRate();
    		doCalculate();
    	}
    }
    
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
    
    function checkValidation() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var obj=event.srcElement;
    	if (obj.name == "porCd" || obj.name == "polCd" || obj.name == "podCd" || obj.name == "delCd") {
    		if (obj.value.length != 5) return;
        	ComSetObjValue(formObj.loc_cd, obj.value);
        	doActionIBCommon(sheetObj,formObj,IBSEARCH_LOC,COMMAND07);
    		if (ComGetObjValue(formObj.result) != "Y") {
    			ComShowCodeMessage("DMT00110", "Location");
    			ComClearObject(obj);
    			ComSetFocus(obj);
    			return;
    		}
    	}
    	if (obj.name == "vvdCd" || obj.name == "polCd" || obj.name == "podCd") {
    		if (obj.name == "vvdCd") {
    			if (obj.value.length != 9) return;
    			if (!validateVVD()) {
    				ComShowCodeMessage("DMT00165", "VVD CD");
    				ComClearObject(obj);
    				ComSetFocus(obj);
    				return;
    			}
    		}
    		//CALLING PORT check
			if (isCanCheckCallingPort() && !validateCallPort()) {
				ComClearObject(obj);
				ComSetFocus(obj);
				return;
			}    		
    	}
    	if (obj.name == "vvdCd") {
    		searchExRate();
    		doCalculate();
    	}
    	else {
    		searchChargeCurrency();
    	}
    }
    
	function clearAttention(){
		var formObj=document.form;
		var cboAttention=comboObjects[1];
		cboAttention.RemoveAll();
    	ComClearObject(formObj.tel);
    	ComClearObject(formObj.fax);
    	ComClearObject(formObj.email);
	}
	
    function initRateDetail() {
    	var sheetCHGObj=sheetObjects[0];
    	var sheetRTObj=sheetObjects[1];
    	var rateRowCount=fetchRateRowCountOfCharge();
    	if (rateRowCount> 1) {
	    	with(sheetCHGObj) {
				var invNo=GetCellValue(GetSelectRow(), INV_NO);
				var dtlSeq=GetCellValue(GetSelectRow(), INV_DTL_SEQ);
				var ofcCd=GetCellValue(GetSelectRow(), CRE_OFC_CD);
	    	}
			with(sheetRTObj) {
				for (var row=LastRow(); row >= HeaderRows(); row--) {
					if (	GetRowStatus(row) != "D"
						&&	invNo 	== GetCellValue(row, INV_NO)
						&&	dtlSeq 	== GetCellValue(row, INV_DTL_SEQ)
						&& 	ofcCd 	== GetCellValue(row, CRE_OFC_CD)	) {
						if (rateRowCount()> 1) {
							if (GetRowStatus(row) == "I") {
								RowDelete(row, false);
							}
							else {
								SetRowStatus(row, "D");
								SetRowHidden(row, 1);
							}
						}
						rateRowCount--;
					}
				}
			}
    	}
    	var rateFirstRow=fetchRateFirstRowOfCharge();
    	with(sheetRTObj) {
    		SetCellValue(rateFirstRow, FT_UND_DYS, "", 0);
    		SetCellValue(rateFirstRow, RT_OVR_DYS, "", 0);
    		SetCellValue(rateFirstRow, RT_OVR_CHG_AMT, "", 0);
    	}
 	 }
 	 
 	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
 		
 		var formObj=document.form;
 		var cboAttention=comboObjects[1];
 		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
 		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
 		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
 		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
 		searchAttentionList();
 		var custKeyCode=ComGetObjValue(formObj.cust_cnt_cd)
 						+ "^"
 						+ ComGetObjValue(formObj.cust_cntc_pnt_seq)
 						+ "^"
 						+ ComParseInt(ComGetObjValue(formObj.cust_seq));
 		//setting
 		if (ComGetObjValue(formObj.payerCd) == "") {
 			comboObjects[0].SetSelectCode(-1);
 			ComSetObjValue(formObj.tel, 				"");
 			ComSetObjValue(formObj.fax, 				"");
 			ComSetObjValue(formObj.email, 				"");
 			ComSetObjValue(formObj.cust_cntc_pnt_seq, 	"");
 		}
 		else {
 			//Attention Setting
 			cboAttention.SetSelectCode(custKeyCode);
 			if(cboAttention.GetSelectCode()== ""){
 	 			ComSetObjValue(formObj.tel, 				"");
 	 			ComSetObjValue(formObj.fax, 				"");
 	 			ComSetObjValue(formObj.email, 				"");
 	 			ComSetObjValue(formObj.cust_cntc_pnt_seq, 	"");
 			}
 		}
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
    
    function disableControls() {
    	var formObj=document.form;
	    with(formObj) {
	    	ComEnableManyObjects(false, invoiceNo, issueDate, issueOfcCd, issueName, status);
	    	invoiceNo.className="input2";
	    	issueDate.className="input2";
	    	issueOfcCd.className="input2";
	    	issueName.className="input2";
	    	status.className="input2";
	    	ComEnableManyObjects(false, vvdCd, porCd, polCd, podCd, delCd, rcvTermCd, deTermCd);
	    	vvdCd.className="input2";
	    	porCd.className="input2";
	    	polCd.className="input2";
	    	podCd.className="input2";
	    	delCd.className="input2";
			rcvTermCd.className="input2";
			deTermCd.className="input2";
			ComEnableManyObjects(false, bkgCustCd, bkgCustNm, arCustCd, arCustNm, payerCd, payerNm);
			bkgCustCd.className="input2";
			bkgCustNm.className="input2";
			arCustCd.className="input2";
			arCustNm.className="input2";
			payerCd.className="input2";
			payerNm.className="input2";
			ComEnableManyObjects(false, tel, fax, email, truckerCd, truckerNm, dueDate, creditTerm);
			tel.className="input2";
			fax.className="input2";
			email.className="input2";
			truckerCd.className="input2";
			truckerNm.className="input2";
			dueDate.className="input2";
			creditTerm.className="input2";
			ComEnableManyObjects(false, invoiceRemark1, invoiceRemark2);
			invoiceRemark1.className="input2";
			invoiceRemark2.className="input2";
	    }
    }
    
    function retrieveDaysBetween(fromDt, toDt) {
        var formObj=document.form;
    	var sheetObj=sheetObjects[2];
    	ComSetObjValue(formObj.from_dt, fromDt);
    	ComSetObjValue(formObj.to_dt,   toDt);
    	doActionIBCommon(sheetObj, formObj, IBSEARCH_DYS_BETWEEN, COMMAND18);
    	return ComGetObjValue(formObj.ovr_dys);
    }
    /**
     * Incl. Cntr Detail 선택여부에 따라서 Bil Amt 금액을 설정해준다.
     */       
    function getBillAmtByIncCntrDtail() {
     var formObj = document.form;
     var bilAmt  = 0;
     
     if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
      bilAmt = ComGetUnMaskedValue(ComGetObjValue(formObj.billableAmt), "float");
     }
     else {
      bilAmt = ComGetUnMaskedValue(ComGetObjValue(formObj.totalAmt),    "float");
     }
     return bilAmt;
    }
