/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4013.js
*@FileTitle  : Invoice Creation - Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
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
     * @class EES_DMT_4013 : EES_DMT_4013 for generating business from the screen using a script is defined.
     */
//    function EES_DMT_4013() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBSEARCH02=51;
	var IBARIF=52;	
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
    	var sheetObject1=sheetObjects[0];
     	//var sheetObject2 = sheetObjects[1];
    	var srcObj=window.event.srcElement;
        /*******************************************************/
     	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
	            case "btn_payer_cd":
	         		openPopup('payer_cd');
					break;
				case "btn_update":
					setDataUpdate();
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_ar":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBARIF);
					}
					break;
				case "btn_excel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					break;
				case "btn_close":
					ComClosePopup(); 
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * Register as an array IBCombo Object
	 * param : combo_obj ==> combo object
	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
	 * Array defined at the top of the source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
  	/*
  	 * function calling common pop up 
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
					ComOpenPopup('COM_ENS_041.do', 770, 485, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  		} // switch-end
  		} // with-end
  	}
    /*
  	 * Customer Code Customer common values ​​selected in the pop-up settings in the appropriate fields
  	 */
    function getCustCd(aryPopupData) {
    	document.form.payer_cd.value=aryPopupData[0][3];
    	document.form.payer_nm.value=aryPopupData[0][4];
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
        initAxonControl();
        doActionIBCombo(sheetObjects[1], document.form, IBSEARCH, COMMAND17, "USR_CNT_CD");	//2010.04.04.
        doInit();
//		doActionIBCombo(sheetObjects[1], document.form, IBSEARCH, COMMAND17, "USR_CNT_CD");	//2010.04.04.
    }
    /*
     * calling pop up in EES_DMT_4001 
     */
	function doInit() {
 		var formObj=document.form;
 		var opener=window.dialogArguments;
 		if(!opener) opener=parent;
 		var opnSheetObj="";
 		var exchange_rate="";
 		if(ComGetObjValue(formObj.jspno) == "4001") {
 			opnSheetObj=opener.sheet1;
 		}else if(ComGetObjValue(formObj.jspno) == "3001") {
 			opnSheetObj=opener.sheet2;
 		}
 		var sheetObj=sheetObjects[0];
 		if(ComGetObjValue(formObj.s_group_by) == "1") {
 			sheetObj.SetColHidden("cntr_cnt", 0);
 			sheetObj.SetColHidden("cntr_no", 1);
 			sheetObj.SetColHidden("gb", 1);
		} else {
			sheetObj.SetColHidden("cntr_cnt", 1);
			sheetObj.SetColHidden("cntr_no", 0);
			sheetObj.SetColHidden("gb", 0);
		}
 		var sXml=ComMakeSearchXml(opnSheetObj, false, "CheckBox", "bkg_no|bl_no|cntr_cnt|cntr_no|gb|ofc_cd|dmdt_trf_cd|cust_cd|sc_no|rfa_no|ar_curr_cd|inv_amt|bzc_trf_curr_cd|org_chg_amt|sc_rfa_expt_amt|aft_expt_dc_amt|bil_amt|inv_xch_rt|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd");
 		//hidden sheet
 		sheetObjects[2].LoadSearchData(sXml,{Append:1 , Sync:1} );
 		var sXml2="";
 		var s_dmdt_trf_cd="";
 		var s_bkg_no="";
 		var s_ofc_cd="";
 		var s_chg_type="";
 		for(var i=2; i < sheetObjects[2].GetTotalRows()+ 2; i++) {
 			var temp=sheetObjects[2].GetCellValue(i, "dmdt_trf_cd");
 			var temp2=sheetObjects[2].GetCellValue(i, "bkg_no");
 			s_dmdt_trf_cd 	+= temp + ","; 
 			s_bkg_no 		+= temp2 + ",";
 			s_ofc_cd=sheetObjects[2].GetCellValue(i, "ofc_cd");
 		}
 		//search Bkg
 		ComSetObjValue(formObj.s_ofc_cd, 		s_ofc_cd);
 		ComSetObjValue(formObj.s_bkg_no, 		s_bkg_no);
 		ComSetObjValue(formObj.s_dmdt_trf_cd, 	s_dmdt_trf_cd);
 		doActionIBSheet(sheetObj, formObj, IBSEARCH);
 		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
 		var inv_tax_rto=0;
 		var inv_tax_amt=0;
 		var inv_payable_amt=0;
 		var inv_chg_amt=0;
 		var inv_curr_cd="";
 		for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
 			inv_curr_cd=sheetObj.GetCellValue(i, "ar_curr_cd");
 			if(ComGetObjValue(formObj.jspno) == "3001") {
 				inv_chg_amt=parseFloat(sheetObj.GetCellValue(i, "org_chg_amt")) * parseFloat(sheetObj.GetCellValue(i, "inv_xch_rt"));
 				inv_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_chg_amt);
 				sheetObj.SetCellValue(i, "inv_amt",inv_chg_amt, 0);
 			}else if(ComGetObjValue(formObj.jspno) == "4001") {
 				inv_chg_amt=parseFloat(sheetObj.GetCellValue(i, "inv_amt"));
 			}

 			inv_tax_rto=parseFloat(ComGetObjValue(formObj.tax_rto));

 			//if(ComGetObjValue(formObj.session_cnt_cd) == "VN") {	
// 			if(ComGetObjValue(formObj.usr_cnt_cd) == "VN") {	
//				inv_tax_amt=(inv_chg_amt / (1 - inv_tax_rto * 0.01)) * (inv_tax_rto * 0.01);
// 			}else{
// 				inv_tax_amt=(inv_tax_rto * 0.01) * inv_chg_amt;
// 			}

 			//=========================================
 			//2015.10.27 #7995 comment start
 			//2017.01.12 #23259 India Invoice
 			if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {
 				var ida_expn_tax_rt     = parseFloat(sheetObj.GetCellValue(i, "ida_expn_tax_rt"));
 				var ida_edu_tax_rt      = parseFloat(sheetObj.GetCellValue(i, "ida_edu_tax_rt"));
 				var ida_high_edu_tax_rt = parseFloat(sheetObj.GetCellValue(i, "ida_high_edu_tax_rt"));
 				var ida_expn_tax = 0;
 				var ida_edu_tax = 0;
 				var ida_high_edu_tax = 0;
  				// Service Tax
 				 ida_expn_tax = ComRound( (inv_chg_amt * ida_expn_tax_rt * 0.01), 2 );
  				 sheetObj.SetCellValue(i, "ida_expn_tax", ida_expn_tax, 0);
 				 
 				// Education Cess
  				 ida_edu_tax = ComRound( (ida_expn_tax * ida_edu_tax_rt * 0.01), 2 );
  				 sheetObj.SetCellValue(i, "ida_edu_tax", ida_edu_tax, 0);
 				
 				// Higher Edu Cess
 				 ida_high_edu_tax = ComRound( (ida_expn_tax * ida_high_edu_tax_rt * 0.01), 2 );
 				 sheetObj.SetCellValue(i, "ida_high_edu_tax", ida_high_edu_tax, 0);
 				
 				// Total Service Tax
 				inv_tax_amt = parseFloat(ida_expn_tax) + parseFloat(ida_edu_tax) + parseFloat(ida_high_edu_tax);
 				inv_tax_rto = "";
 				
 			}
 			//2015.10.27 #7995 comment e n d
 			//=========================================	
 			else{
 				inv_tax_amt=(inv_tax_rto * 0.01) * inv_chg_amt;
 			}
 			inv_tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_tax_amt);
 			//alert(inv_tax_amt);
 			inv_payable_amt=inv_chg_amt + inv_tax_amt;
 			inv_payable_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_payable_amt);
 			
 			sheetObj.SetCellValue(i, "inv_tax_rto", inv_tax_rto, 0);
 			sheetObj.SetCellValue(i, "inv_tax_amt", inv_tax_amt, 0);
 			sheetObj.SetCellValue(i, "inv_payable_amt", inv_payable_amt, 0);
 		}

 		//=========================================
 		//2015.10.27 #7995 comment start
 		//2017.01.12 #23259 India Invoice
 		//Tax Checked
		if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {
			formObj.chk_tax_rto.checked = true;
			ComEnableObject(formObj.chk_tax_rto, false);
			ComSetObjValue(formObj.tax_rto_dis, "");
		 }else{
		 	formObj.chk_tax_rto.checked = true;
		}
//		formObj.chk_tax_rto.checked = true;
		//2015.10.27 #7995 comment e n d
		//=========================================
// 		formObj.chk_tax_rto.checked=true;
 		sheetObj.CheckAll(1,1);
		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
		doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,SEARCHLIST06,"OFC_CURR_DAY");
 		ComSetObjValue(formObj.issue_date, 	ComGetObjValue(formObj.ofc_curr_date));
 		ComSetObjValue(formObj.usr_ofc, 	ComGetObjValue(formObj.session_ofc_cd));
 		ComSetObjValue(formObj.usr_name, 	ComGetObjValue(formObj.session_usr_nm));
 		ComSetObjValue(formObj.inv_qty, "0");
 		ComSetObjValue(formObj.inv_curr_cd, inv_curr_cd);
 		if(ComGetObjValue(formObj.s_group_by) == "1") {
 			for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
				ComSetObjValue(formObj.s_ofc_cd, sheetObj.GetCellValue(i, "ofc_cd"));
				ComSetObjValue(formObj.s_bkg_no, sheetObj.GetCellValue(i, "bkg_no"));
				ComSetObjValue(formObj.s_dmdt_trf_cd, sheetObj.GetCellValue(i, "dmdt_trf_cd"));
 				doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,SEARCH01,"CNTR_CNT");
 				sheetObj.SetCellValue(i, "cntr_cnt",ComGetObjValue(formObj.re_cntr_cnt),0);
 			}
		} 
 		for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
 			if(sheetObj.GetCellValue(i, "cust_cd") == ""){
 				continue;
 			}else{
 				ComSetObjValue(formObj.payer_cd, sheetObj.GetCellValue(i, "cust_cd"));
 				doActionText(sheetObjects[1], formObj, "", SEARCH20);
 				break;
 			}
 		}
		//REP CUST SEQ 코드 가져오기
		doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,COMMAND23,"REP_CUST_SEQ");
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
                with (sheetObj) {
	                
	                var HeadTitle="||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Invoice|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|dmdt_chg_loc_div_cd|ida_expn_tax_rt|ida_expn_tax|ida_edu_tax_rt|ida_edu_tax|ida_high_edu_tax_rt|ida_high_edu_tax";
	                var HeadTitle1="||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Cur.|Billing AMT|Tax(%)|Tax AMT|Payable AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|dmdt_chg_loc_div_cd|ida_expn_tax_rt|ida_expn_tax|ida_edu_tax_rt|ida_edu_tax|ida_high_edu_tax_rt|ida_high_edu_tax";
	                var headCount=ComCountHeadTitle(HeadTitle);
//	                (headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"check_box" },
	                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_ar_if_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"gb",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ar_curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_rto",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"inv_tax_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_payable_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vsl_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"skd_voy_no" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"skd_dir_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pol_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pod_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"por_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"del_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_expn_tax_rt" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_expn_tax" },
//	                       {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_expn_tax" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_edu_tax_rt" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_edu_tax" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_high_edu_tax_rt" },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_high_edu_tax" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(380);
                    FrozenCols=SaveNameCol("cntr_cnt");
                }
                break;
            case 2:
            	with (sheetObj) {
               
	                var HeadTitle="";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"}];
	                InitHeaders(headers, info);
	
	                var cols = [];
	                 
//	                InitColumns(cols);
	
	                SetEditable(1);
//	                SetSheetHeight(102);
//	                SetCountPosition(0);

                }
                break;
            case 3:      // sheet3 init
                with (sheetObj) {
	                
	                var HeadTitle="BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd";
	                var HeadTitle1="BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Cur.|Billing AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd";
	                var headCount=ComCountHeadTitle(HeadTitle);
//	                (headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2,  MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"gb",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ar_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vsl_cd" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"skd_voy_no" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"skd_dir_cd" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pol_cd" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pod_cd" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"por_cd" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"del_cd" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(380);
	                FrozenCols=SaveNameCol("cntr_cnt");
                }
                break;
        }
    }
    function initAxonControl() {
		axon_event.addListenerFormat('focus',	'obj_focus',	form); 
		axon_event.addListenerFormat('blur',	'obj_blur',		form);
    }
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
    	var obj=event.srcElement;
		ComClearSeparator(obj);
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }	
    function obj_blur(){
		var obj=event.srcElement;
		if(obj.name == 'payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else{
			ComChkObjValid(obj);
		}
    }       
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:     
        		if (sheetObj.id == "sheet1") {
        			ComSetObjValue(formObj.f_cmd, SEARCH02);
        			setParameters(SEARCH02);
//        			if(!validateForm(sheetObj,formObj,sAction)) return;
 					var sXml=sheetObj.GetSearchData("EES_DMT_4013GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
        		}else if (sheetObj.id == "sheet2") {	
        			ComSetObjValue(formObj.f_cmd, SEARCH);
					setParameters(SEARCH);
					if(!validateForm(sheetObj,formObj,sAction)) return;
 					var sXml=sheetObj.GetSearchData("EES_DMT_4013GS.do", FormQueryString(formObj));
					var tax_rto=ComGetEtcData(sXml, "TAX_RTO");
					ComSetObjValue(formObj.tax_rto, tax_rto);
					ComSetObjValue(formObj.tax_rto_dis, tax_rto);
				}
				break;     
        	case IBSAVE:
        		if (sheetObj.id == "sheet1") {	//Save
        			ComSetObjValue(formObj.f_cmd, COMMAND02);//MULTI
        			if(!validateForm(sheetObj,formObj,sAction)) return;
        			sheetObj.SetWaitImageVisible(0);
        			ComOpenWait(true);
        			unSetComma();
        			//sheetObj.DoSave("EES_DMT_4013GS.do", FormQueryString(formObj), -1, false);
           			var sParam=sheetObj.GetSaveString(true) +"&" + FormQueryString(formObj);
         			var sXml=sheetObj.GetSaveData("EES_DMT_4013GS.do", sParam);
        			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
    				if (backendJobKey != undefined && backendJobKey != '') {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.SetWaitTimeOut(10000);
						timer=setInterval(getBackEndJobStatus, 3000); 
					}
    				setComma();
        		}
	         	break;
//        		if (sheetObj.id == "sheet1") {	//Save
//        			ComSetObjValue(formObj.f_cmd, MULTI);
//					if(!validateForm(sheetObj,formObj,sAction)) return;
//					
//					unSetComma();
//					
//					sheetObj.DoSave("EES_DMT_4013GS.do", FormQueryString(formObj), -1, false);
//										
//					if(sheetObj.EtcData("inv_qty") == undefined) {
//						ComSetObjValue(formObj.inv_qty, "0");
//					}else{
//						ComSetObjValue(formObj.inv_qty, sheetObj.EtcData("inv_qty"));	
//					}
//					setComma();
//				}
//        		break;
        	case IBARIF:
        		ComSetObjValue(formObj.f_cmd, COMMAND01);
        		setParameters(COMMAND01);
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        		if (!ComShowCodeConfirm("DMT03026")) return;
				var sParam=sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("EES_DMT_4013GS.do", sParam);
 				sheetObj.LoadSaveData(sXml);
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
        		break;
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					if(sheetObj.RowCount() < 1){//no data
               		 	ComShowCodeMessage("COM132501");
	           		}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	           		}
				}; 
				break;        		
        }
    }
    function getBackEndJobStatus() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND03);
	 	var params="f_cmd=" + COMMAND03 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSearchData("EES_DMT_4013GS.do", params);
	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		var jbUsrErrMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	var backendjobId=ComGetObjValue(formObj.backendjob_id);
	 	ComSetObjValue(formObj.f_cmd, MULTI);	//SAVE
	 	var params="f_cmd=" + ComGetObjValue(formObj.f_cmd) + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
 	 	var sXml=sheetObj.GetSaveData("EES_DMT_4013GS.do", params);
 	 	sheetObj.LoadSaveData(sXml);
	 	if(sheetObj.GetEtcData("inv_qty") == undefined) {
			ComSetObjValue(formObj.inv_qty, "0");
		}else{
			ComSetObjValue(formObj.inv_qty, sheetObj.GetEtcData("inv_qty"));
		}	 	
	 	ComOpenWait(false);
	}    
  	/**
 	 * IBSheet lookup function lookup is complete, caused by an Event
 	 */
 	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
 		if(ErrMsg != '') return;
		var formObj=document.form;
		var fCmd=formObj.f_cmd.value;
		if(fCmd == COMMAND03){
			alert(ErrMsg);
		}
	}	
    /**
     *  Payer, CUR, Tax정보 Update
     */
    function setDataUpdate() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	//Payer
    	if(ComGetObjValue(formObj.payer_cd) == "") {
    		ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT02002","[Payer Code]"));
			return;
    	}
    	var chg_curr_cd="";
    	var inv_curr_cd="";
    	var chg_dc_amt;		//(Charge)D/C Amt
		var bil_amt;		//(Charge)Billable AMT
		var inv_xch_rt;		//Ex. Rate
		var inv_chg_amt;	//(Invoice) Billing Amt
		var tax_rto;		//(Invoice) Tax Rate
		var tax_amt;		//(Invoice) Tax Amt
		var inv_amt;		//(Invoice) Payable Amt
		var temp_tot_bil_amt=0;
		var temp_tot_tax_amt=0;
		var temp_tot_payable_amt=0;
    	//Payer Code Setting
    	var payer_cd=ComGetObjValue(formObj.payer_cd);
    	//Currency Setting
    	var currency=ComGetObjValue(formObj.inv_curr_cd);
    	//taxRto Setting
    	var tax_rto=ComGetObjValue(formObj.tax_rto_dis);
    	for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
    		//checBox
    		if(sheetObj.GetCellValue(i, "check_box") == 1) {
        		//cust_cd
    			sheetObj.SetCellValue(i, "cust_cd", payer_cd, 0);
    			//ar_curr_cd
    			sheetObj.SetCellValue(i, "ar_curr_cd", currency, 0);
    			// ex_rate calculation
				chg_curr_cd=sheetObj.GetCellValue(i, "bzc_trf_curr_cd");
				inv_curr_cd=sheetObj.GetCellValue(i, "ar_curr_cd");
				bil_amt=parseFloat(sheetObj.GetCellValue(i, "bil_amt"));				//(Charge)Billable AMT
				chg_dc_amt=parseFloat(sheetObj.GetCellValue(i, "aft_expt_dc_amt"));		//(Charge)D/C Amt
				inv_xch_rt=sheetObj.GetCellValue(i, "inv_xch_rt");
    			//Invoice Billing Amt
    			inv_chg_amt=bil_amt * inv_xch_rt;
    			inv_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_chg_amt);
    			sheetObj.SetCellValue(i, "inv_amt", inv_chg_amt, 0);
//alert("[INV_CHG_AMT=BIL_AMT*INV_XCH_RT]=["+inv_chg_amt+"]");
    			//Invoice Tax Rate
    			sheetObj.SetCellValue(i, "inv_tax_rto", tax_rto, 0);
    			//Invoice Tax Amt
    			//if(ComGetObjValue(formObj.session_cnt_cd) == "VN") {	
//    			if(ComGetObjValue(formObj.usr_cnt_cd) == "VN") {
//					tax_amt=(inv_chg_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//    			}
    			//=========================================
    			//2015.10.27 #7995 comment start
    			//2017.01.12 #23259 India Invoice
    			if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {
    				// 인도는 재계산 하지 않음. 2012.05.24
    				tax_amt = parseFloat(sheetObj.GetCellValue(i, "inv_tax_amt"));
   			    }
    			//2015.10.27 #7995 comment e n d
    			//=========================================
    			
    			else{
    				tax_amt=(tax_rto * 0.01) * inv_chg_amt;
    			}
    			tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tax_amt);
    			sheetObj.SetCellValue(i, "inv_tax_amt", tax_amt, 0);
//alert("[tax_amt=(tax_rto * 0.01) * inv_chg_amt]=["+tax_amt+"]");
    			inv_amt=inv_chg_amt + tax_amt;
    			inv_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_amt);
    			sheetObj.SetCellValue(i, "inv_payable_amt", inv_amt, 0);
//alert("[inv_amt=inv_chg_amt + tax_amt]=["+inv_amt+"]");
    			temp_tot_bil_amt += inv_chg_amt;
    			temp_tot_tax_amt += tax_amt;
    			temp_tot_payable_amt  += inv_amt;
    		}
    	}
    	ComSetObjValue(formObj.tot_bil_amt, temp_tot_bil_amt);
    	ComSetObjValue(formObj.tot_tax_amt, temp_tot_tax_amt);
    	ComSetObjValue(formObj.tot_payable_amt, temp_tot_payable_amt);
    	//setComma
    	setComma();
    	ComShowCodeMessage("DMT01109");
    }
    /**
     * calculating amount in case of clicking Detail Sheet
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
	function sheet1_OnChange (sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var inv_curr_cd="";
		var tot_bil_amt=0;
		var tot_tax_amt=0;
		var tot_payable_amt=0;
		if(sName == "check_box") {
			for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
				if(sheetObj.GetCellValue(i,"check_box") == 1) {
				tot_bil_amt=tot_bil_amt + parseFloat(sheetObj.GetCellValue(i,"inv_amt"));		//Billing Amt
				tot_tax_amt=tot_tax_amt + parseFloat(sheetObj.GetCellValue(i,"inv_tax_amt"));	//Tax Amt
					tot_payable_amt=tot_bil_amt + tot_tax_amt;
					inv_curr_cd=sheetObj.GetCellValue(i,"ar_curr_cd");
					tot_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_bil_amt);
					tot_tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_tax_amt);
					tot_payable_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_payable_amt);
				}
//				else if(Value == 0 ) {
//					tot_bil_amt = tot_bil_amt - parseFloat(sheetObj.CellValue(sheetObj.SelectRow,"inv_amt"));		//Billing Amt
//					tot_tax_amt = tot_tax_amt - parseFloat(sheetObj.CellValue(sheetObj.SelectRow,"inv_tax_amt"));	//Tax Amt
//					tot_payable_amt = tot_bil_amt + tot_tax_amt;
//					inv_curr_cd = sheetObj.CellValue(sheetObj.SelectRow ,"ar_curr_cd");
//				}
			}
	 		ComSetObjValue(formObj.tot_bil_amt, tot_bil_amt);
	 		ComSetObjValue(formObj.tot_tax_amt, tot_tax_amt);
	 		ComSetObjValue(formObj.tot_payable_amt, tot_payable_amt);
	 		setComma();
		}
	}    
    function sheet1_OnClick(sheetObj, row, col, Value){
        if(sheetObj.ColSaveName(col) == "check_box")
        	ComSyncAllCheck(sheetObj, col, Value);
    }	
	/*
	 * Lookup fields to enter information is stored as the value for a lookup field on the screen.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(sAction == SEARCH) {
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
		}else if(sAction == COMMAND01) {
			if(ComGetObjValue(formObj.s_group_by) == "2") {
				for(var i=2; i < sheetObj.GetTotalRows()+ 2 ; i++) {
					if(sheetObj.GetCellValue(i, "check_box") == "1") {
						var invoice_no=sheetObj.GetCellValue(i, "dmdt_inv_no");
						if(invoice_no == "") {
							continue;
						}
						for(var j=2; j < sheetObj.GetTotalRows()+ 2 ; j++) {
							if(i == j) {
								continue;
							}
							if(invoice_no == sheetObj.GetCellValue(j, "dmdt_inv_no")) {
								sheetObj.SetCellValue(j, "check_box","1");
							}
						}//end of for
					}
				}//end of for
			}
		}
	}
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){ 
    	with(sheetObj) {
    	      var Row = MouseRow();
    	      var Col = MouseCol();
    	      if (Row == 0 || Row == 1) {
    	    	  if (Col == 10){
    	    		  SetToolTipText(Row, Col, "General/Balance Charge Type");
    	    	  }
    	    	  else {
    	    		  SetToolTipText(Row, Col, "");
    	    	  }
    	      }
    	      else {
    	    	  if (Col == 4) {
    	    		  if (GetCellValue(Row, Col) == "I") {
    	    			  SetToolTipText(Row, Col, "Issued");
    	    		  }
    	    		  else {
    	    			  SetToolTipText(Row, Col, "");
    	    		  }
    	    	  }
    	    	  else {
    	    		  SetToolTipText(Row, Col, "");
    	    	  }
    	      }
    	}
    }
//	function searchARCurrencyList() {
//		var sheetObj = sheetObjects[1];
//		var formObj = document.form;
//	
//		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST05,"AR_CURRENCY");
//	}
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
        	case IBSEARCH:      
				if (sheetObj.id == "sheet2") {
					switch(sComboAction) {
						case SEARCHLIST06:
							ComSetObjValue(formObj.f_cmd, SEARCHLIST06);
							setComboParameters(sComboAction, sObj);
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.ofc_curr_date, ComGetEtcData(sXml, "OFC_CURR_DAY"));
							ComSetObjValue(formObj.ofc_curr_date, ComGetMaskedValue(formObj.ofc_curr_date.value, "ymd"));
							break;			
						case SEARCH01:
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							setComboParameters(sComboAction, sObj);
 							var sXml=sheetObj.GetSearchData("EES_DMT_4013GS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.re_cntr_cnt, ComGetEtcData(sXml, "CNTR_CNT"));
							break;			
						case COMMAND17:
							ComSetObjValue(formObj.f_cmd, COMMAND17);
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.usr_cnt_cd, 	ComGetEtcData(sXml, "USR_CNT_CD"));
							break;
//						case SEARCHLIST05:
//							ComClearCombo(formObj.inv_curr_cd);
//							comboDatas = ComGetEtcData(sXml, sComboKey);
//							if (comboDatas != undefined) {
//								addComboItem(formObj.inv_curr_cd,comboDatas,true);
//							}
//							break;		
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
    function setComboParameters(sComboAction, sObj) {
    	var formObj=document.form;
    	//ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));//inv_curr_cd
    }	
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
    function doActionText(sheetObj, formObj, object, formCmd) {
    	sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.payer_cd)));
		ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
		if(cust_len == 0){
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.payer_cd, "");
			ComSetObjValue(formObj.payer_nm, "");
			return;
		}
		//var cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
		var cre_cnt_cd=ComGetObjValue(formObj.usr_cnt_cd);
		var detention_check="";
		for(var i=2; i < sheetObj.GetTotalRows()+ 2; i++) {
			if(sheetObj.GetCellValue(i, "dmdt_trf_cd") == "DMIF" || sheetObj.GetCellValue(i, "dmdt_trf_cd") == "DMOF") {
				detention_check="Y";//Service Provider 입력 불가
				break;
			}
		}
		//미주 : customer + vendor 
		if(cre_cnt_cd == "CA" || cre_cnt_cd == "US"){
			if(cust_len > 2) {
				var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//2자리가 영문자이면 CUSTOMER 조회
				if(ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				//아니면 VENDOR 조회
				}else{
					//service provider는 Detention 만 가능하게 함
					if(detention_check == 'Y'){
						ComShowCodeMessage("DMT00165", "Payer");
						ComSetObjValue(formObj.s_cust_gubun, "");
						ComSetObjValue(formObj.s_cust_cd, "");
						ComSetObjValue(formObj.payer_cd, "");
						ComSetObjValue(formObj.payer_nm, "");
						return;
					} else {
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
							return;
						} else {
							ComSetObjValue(formObj.s_cust_gubun, "1");
						}
					}
				}
			} else {
				//service provider는 Detention 만 가능하게 함
				if(detention_check != 'Y'){
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
					return;
				}
			}
		} else {
			//미주 외 : customer만 적용 ( vendor 는 제외 에러 처리) 
			if(cust_len > 2) {
				var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//2자리가 영문자이면 CUSTOMER 조회
				if(ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				//아니면 VENDOR 조회
				}else{
					//ComSetObjValue(formObj.s_cust_gubun, "1");
					ComShowCodeMessage("DMT00165", "Payer");
					ComSetObjValue(formObj.s_cust_gubun, "");
					ComSetObjValue(formObj.s_cust_cd, "");
					ComSetObjValue(formObj.payer_cd, "");
					ComSetObjValue(formObj.payer_nm, "");
					return;
				}
			} else {
				//ComSetObjValue(formObj.s_cust_gubun, "1");
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.payer_cd, "");
				ComSetObjValue(formObj.payer_nm, "");
				return;
			}
		}
//		if(cust_len > 2) {
//			var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
//			if(ComIsAlphabet(char_chk)) {
//				ComSetObjValue(formObj.s_cust_gubun, "2");
//			}else{
//				//ComSetObjValue(formObj.s_cust_gubun, "1");
//				ComShowCodeMessage("DMT00165", "Payer");
//				ComSetObjValue(formObj.s_cust_gubun, "");
//				ComSetObjValue(formObj.s_cust_cd, "");
//				ComSetObjValue(formObj.payer_cd, "");
//				ComSetObjValue(formObj.payer_nm, "");
//				return;
//			}
//		} else {
//			//ComSetObjValue(formObj.s_cust_gubun, "1");
//			ComShowCodeMessage("DMT00165", "Payer");
//			ComSetObjValue(formObj.s_cust_gubun, "");
//			ComSetObjValue(formObj.s_cust_cd, "");
//			ComSetObjValue(formObj.payer_cd, "");
//			ComSetObjValue(formObj.payer_nm, "");
//			return;
//		}
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
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(formObj.payer_cd);
		}else{
			ComSetObjValue(formObj.payer_cd, cust_cd);
			ComSetObjValue(formObj.payer_nm, cust_nm);
		}
        sheetObj.SetWaitImageVisible(1);
    }
	/**
	 * Tax Rate check
	 */
	function setTax() {
		var formObj = document.form;
		
		if (formObj.chk_tax_rto.checked) {
			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
		}
		else {
			ComSetObjValue(formObj.tax_rto_dis, "0");
		}
		var inv_curr_cd = ComGetObjValue(formObj.inv_curr_cd);
		var inv_tax_rto = parseFloat(ComGetObjValue(formObj.tax_rto_dis));
		var inv_chg_amt = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_bil_amt),"float"));

 		var inv_tax_amt=0;
 		var inv_payable_amt=0;
 		
//		if (ComGetObjValue(formObj.usr_cnt_cd) == "VN") {	
//			inv_tax_amt=(inv_chg_amt / (1 - inv_tax_rto * 0.01)) * (inv_tax_rto * 0.01);
//		}
//		else {
			inv_tax_amt=(inv_tax_rto * 0.01) * inv_chg_amt;
//		}
		inv_tax_amt = DMTtrimCurrencyAmount(inv_curr_cd, inv_tax_amt);
		inv_payable_amt = inv_chg_amt + inv_tax_amt;
		inv_payable_amt = DMTtrimCurrencyAmount(inv_curr_cd, inv_payable_amt);
		//Tax Rate/AMT
		ComSetObjValue(formObj.tot_tax_amt, inv_tax_amt);
		//Billing AMT
		ComSetObjValue(formObj.tot_payable_amt, inv_payable_amt);
		//SETCOMMA
		setComma();		

 		var sheetObj=sheetObjects[0];
 		
 		for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
 			 			
			inv_tax_amt=(inv_tax_rto * 0.01) * parseFloat(sheetObj.GetCellValue(i, "inv_amt"));

 			inv_tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_tax_amt);
 			
 			inv_payable_amt = parseFloat(sheetObj.GetCellValue(i, "inv_amt")) + inv_tax_amt;
 			inv_payable_amt = DMTtrimCurrencyAmount(inv_curr_cd, inv_payable_amt);

 			sheetObj.SetCellValue(i, "inv_tax_rto", inv_tax_rto, 0);
 			sheetObj.SetCellValue(i, "inv_tax_amt", inv_tax_amt, 0);
 			sheetObj.SetCellValue(i, "inv_payable_amt", inv_payable_amt, 0);
 		}
	}
	
	/**
	 * If you change the INV Currency, ExRate view and Invoice Amt is calculated.
	 * @return
	 */
	function getExRate() {
		var formObj = document.form;
		var chg_curr_cd = ComGetObjValue(formObj.chg_curr_cd);
		var inv_curr_cd = ComGetObjValue(formObj.inv_curr_cd);
		
		if (chg_curr_cd == "" || inv_curr_cd == "")	return;
		
		var chg_dc_amt;
		var inv_xch_rt;	
		var tot_amt = 0;	
		var dc_amt;		
		var bil_amt;
		var inv_chg_amt;
		var tax_rto;
		var tax_amt;
		var inv_amt;
		
		var old_inv_xch_rt = ComGetObjValue(formObj.p_exchange_rt);
		var old_inv_chg_tot;
		var old_inv_bill_amt;
		
		var tot_bill_amt = 0;
		//Invoice before, total amount is to obtain the parts.
		if (ComGetObjValue(formObj.invoice_issue) == "1") {
		
			bil_amt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float"));	//Billable AMT
			chg_dc_amt	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float"));	//Discount AMT
			
			//
			if(chg_curr_cd == inv_curr_cd){
				ComSetObjValue(formObj.p_exchange_rt, 1);	//inv_xch_rt = 1 
			}else{
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
			}			
			
			inv_xch_rt 	= ComGetObjValue(formObj.p_exchange_rt);
			inv_xch_rt = ComRound(inv_xch_rt, 6);	//6-digit decimal rounding
			
		
			for(var i = 2 ; i < sheetObjects[0].TotalRows+2 ; i++) {
				old_inv_chg_tot = parseFloat(sheetObjects[0].cellValue(i, "inv_chg_tot")) / old_inv_xch_rt;
				old_inv_bill_amt = parseFloat(sheetObjects[0].cellValue(i, "inv_bill_amt")) / old_inv_xch_rt;
				sheetObjects[0].cellValue(i, "inv_chg_tot") = old_inv_chg_tot * inv_xch_rt;
				sheetObjects[0].cellValue(i, "inv_bill_amt") = old_inv_bill_amt * inv_xch_rt;
				
				if(sheetObjects[0].cellValue(i, "checkBox") == 1) {
					tot_amt += parseFloat(sheetObjects[0].cellValue(i, "inv_chg_tot"));
					tot_bill_amt += parseFloat(sheetObjects[0].cellValue(i, "inv_bill_amt"));
				}
			}
			
			//tot_amt 	= tot_amt * inv_xch_rt;
			tot_amt 	= DMTtrimCurrencyAmount(inv_curr_cd, tot_amt);
			
			//billing amt 
			inv_chg_amt = DMTtrimCurrencyAmount(inv_curr_cd, tot_bill_amt);
			
			//dc_amt
			dc_amt		= tot_amt - tot_bill_amt;
			dc_amt = DMTtrimCurrencyAmount(inv_curr_cd, dc_amt);
			
			ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
			ComSetObjValue(formObj.tot_amt, tot_amt);
			ComSetObjValue(formObj.dc_amt, dc_amt);
			ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);			
		}else{
			inv_chg_amt = ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float");
		}
			
		//tax 
		tax_rto		= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_rto_dis),"float")); //Tax Rate

		var cre_cnt_cd = "";
		//Before Invoice issue
		if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
			//cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
			cre_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);	//2010.04.04.
		//After Invoice issue
		}else if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
			cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
		}
		
		//If Vietnam
//		if(cre_cnt_cd == "VN"){
//			tax_amt = (inv_chg_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//		}else{
			tax_amt = (tax_rto * 0.01) * inv_chg_amt;
//		}
		tax_amt		= DMTtrimCurrencyAmount(inv_curr_cd, tax_amt);
		inv_amt		= parseFloat(inv_chg_amt) + parseFloat(tax_amt);
		inv_amt		= DMTtrimCurrencyAmount(inv_curr_cd, inv_amt);
		
		//Rounding, cut-off handling
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		
		//SETCOMMA
		setComma();
	}
	
    function setComma(){
    	var formObj=document.form;
		//Selected Total
		var tot_bil_amt=ComAddComma2(ComGetObjValue(formObj.tot_bil_amt),"#,###.00");
		var tot_tax_amt=ComAddComma2(ComGetObjValue(formObj.tot_tax_amt),"#,###.00");
		var tot_payable_amt=ComAddComma2(ComGetObjValue(formObj.tot_payable_amt),"#,###.00");
		ComSetObjValue(formObj.tot_bil_amt, tot_bil_amt);
		ComSetObjValue(formObj.tot_tax_amt, tot_tax_amt);
		ComSetObjValue(formObj.tot_payable_amt, tot_payable_amt);
    }
    
    function unSetComma(){
       	var formObj=document.form;
       	//Selected Total
		var tot_bil_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tot_bil_amt),"float");
		var tot_tax_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tot_tax_amt),"float");
		var tot_payable_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tot_payable_amt),"float");
		ComSetObjValue(formObj.tot_bil_amt, tot_bil_amt);
		ComSetObjValue(formObj.tot_tax_amt, tot_tax_amt);
		ComSetObjValue(formObj.tot_payable_amt, tot_payable_amt);
    }
    
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
				case IBSAVE:
    			//case COMMAND02://
					if(sheetObj.CheckedRows("check_box") == 0) {
		     			ComShowCodeMessage('COM12114', 'BKG No');
		     			return;
		     		}
					var seq=1;
					for (var i=2 ; i < sheetObj.GetTotalRows()+ 2; i++) {
						if(sheetObj.GetCellValue(i, "check_box") == 1) {
							if(sheetObj.GetCellValue(i, "dmdt_inv_sts_cd") == "I" ) {
								ComShowCodeMessage("DMT01094", seq);
								return false;
							}
						}
						seq++;
					}
					var s_payer_cd=ComGetObjValue(formObj.payer_cd);
					var s_tax_rto=ComGetObjValue(formObj.tax_rto_dis);
					var temp_payer_cd="";
					var temp_tax_rto="";
					//data dup check
					//1. payer code
					for(var i=2; i < sheetObj.GetTotalRows()+ 2; i++) {
						if(sheetObj.GetCellValue(i, "check_box") == "1") {
							temp_payer_cd=sheetObj.GetCellValue(i, "cust_cd");
							if(temp_payer_cd == "") {
								ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01052"));
								return false;
							}
							for( var j=i+1 ; j < sheetObj.GetTotalRows()+ 2; j++) {
								if(sheetObj.GetCellValue(j, "check_box") == "1") {
									if(temp_payer_cd != sheetObj.GetCellValue(j, "cust_cd")) {
										ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01051"));
										return false;
									}
								}
							}
						}
					}
    		        // Compare payer with rep cust seq
    		        if (ComTrim(ComGetObjValue(formObj.payer_cd)) == ComTrim(ComGetObjValue(formObj.rep_cust_seq))) {
    		        	ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01157"));
    		        	return false;
    		        }
					//2. tax rto
					for(var i=2; i < sheetObj.GetTotalRows()+ 2; i++) {
						if(sheetObj.GetCellValue(i, "check_box") == "1") {
							temp_tax_rto=sheetObj.GetCellValue(i, "inv_tax_rto");
							for( var j=i+1 ; j < sheetObj.GetTotalRows()+ 2; j++) {
								if(sheetObj.GetCellValue(j, "check_box") == "1") {
									if(temp_tax_rto != sheetObj.GetCellValue(j, "inv_tax_rto")) {
										ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01051"));
										return false;
									}
								}
							}
						}
					}
    				return true;
					break;
				case IBARIF:
					if(sheetObj.CheckedRows("check_box") == 0) {
		     			ComShowCodeMessage('COM12114', 'BKG No');
		     			return;
		     		}
					var seq=1;
					//Grid Check
					for (var i=2 ; i < sheetObj.GetTotalRows()+ 2; i++) {
						if(sheetObj.GetCellValue(i, "check_box") == 1) {
							if(sheetObj.GetCellValue(i, "dmdt_inv_sts_cd") == "I" || sheetObj.GetCellValue(i, "dmdt_inv_sts_cd") == "C") {
								if(sheetObj.GetCellValue(i, "dmdt_ar_if_cd") == "Y") {
									ComShowCodeMessage("DMT01098", seq);
									return false;
								}
							}else{
								ComShowCodeMessage("DMT01097", seq);
								return false;
							}
						}
						seq++;
					}
    				if((ComGetObjValue(formObj.usr_cnt_cd) != "US") && (ComGetObjValue(formObj.usr_cnt_cd) != "CA")) {
    					//payer code
    					for(var i = 2; i < sheetObj.TotalRows+2 ; i++) {
    						var cust_len = parseInt(ComGetLenByByte(sheetObj.GetCellValue(i, "cust_cd"))); 
    						if(cust_len <= 6) {
    							ComShowCodeMessage("DMT00185");
    							return false;
    						}
    					}
    				}
//					for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
//						var cust_len=parseInt(ComGetLenByByte(sheetObj.GetCellValue(i, "cust_cd")));
//    						if(cust_len <= 6) {
//    							ComShowCodeMessage("DMT00185");
//    							return false;
//    						}
//    					}
					break;
    		}
        }
        return true;
    }
	function unLoadPage() {
		window.returnValue="Y";
	}
