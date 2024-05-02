/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0151.js
*@FileTitle : Charge Filtering
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/

 function esm_bkg_0151() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	this.obj_keyup_loc           = obj_keyup_loc;
    	this.obj_click               = obj_click;
    	this.setChangeDisbled_rt_flg = setChangeDisbled_rt_flg; 
    	
    }

// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var sheet2;
var sheet3;
var comboObjects=new Array();
var comboCnt=0;
// biz global variables
var gCurrDate;
var gXml="";
var gLocationObj;
var gBkgRhqCd;
var gIsSearchDt=true;
var gIsSearchCharge=true;
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * register combo Object to comboObjects array
 * 
 * @param combo_obj
 * @return
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
	var form=document.form;	
    sheet1=sheetObjects[0];
    sheet2=sheetObjects[1];    
    sheet3=sheetObjects[2];        
    sheetCnt=sheetObjects.length ;    
    //IBMultiCombo init
    comboCnt=comboObjects.length;
    for(var k=0;k<comboCnt;k++){
        initCombo(comboObjects[k],k+1);
    }
    //IBSheet init
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    chg_cd1.SetSelectIndex("-1");
	chg_cd1.SetEnable(0);
	/*axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
    axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form'); */
	axon_event.addListenerForm('click', 'obj_click', form);
    gBkgRhqCd=form.strRhq_ofc_cd.value;
    gCurrDate=ComGetNowInfo('ymd', '-');
   // ComOpenWait(true);
	doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01);
	//ComOpenWait(false);
	
	
}
/**
 * setting Item to IBMultiCombo
 */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,        rhqComboValue,       getComboObject(comboObjects, 'bkg_rhq_cd'),  "|", "\t" );
	getComboObject(comboObjects, 'bkg_rhq_cd').SetSelectCode(gBkgRhqCd,false);// 초기화시에는 이벤트 발생 안시킴. 초기화시 office 자동 셋팅함.(java와 맞춰준다.)
	ComBkgTextCode2ComboItem(officeComboValue,     officeComboValue,    getComboObject(comboObjects, 'bkg_ofc_cd'),  "|", "\t" );	
	getComboObject(comboObjects, 'bkg_ofc_cd').SetSelectCode(form.strOfc_cd.value,false);
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'), "|", "\t" );
	//getComboObject(comboObjects, 'bkg_ctrt_tp_cd').Code2 = "S";
    ComBkgTextCode2ComboItem(cargoTypeComboValue,  cargoTypeComboText,  getComboObject(comboObjects, 'cargo_type'),  	"|", "\t" );
    //ComBkgTextCode2ComboItem(usaSvcModCdComboValue,usaSvcModCdComboText,getComboObject(comboObjects, 'usa_svc_mod_cd'), "|", "\t" );
    ComBkgTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'svc_scp_cd'),  	"|", "\t" );
    ComBkgTextCode2ComboItem(rTermComboValue,      rTermComboText,      getComboObject(comboObjects, 'rcv_term_cd'), 	"|", "\t" );
    ComBkgTextCode2ComboItem(dTermComboValue,      dTermComboText,      getComboObject(comboObjects, 'de_term_cd'),  	"|", "\t" );
    bkg_ctrt_tp_cd.InsertItem(0,'','');
	bdr_flg.InsertItem(0,'','');
	bdr_flg.InsertItem(1,'Yes','Y');
	bdr_flg.InsertItem(2,'No','N');
	ComBkgTextCode2ComboItem(bkgStatuCdComboValue, bkgStatuCdComboText, getComboObject(comboObjects, 'bkg_sts_cd'),  	"|", "\t" );
	getComboObject(comboObjects, 'bkg_sts_cd').SetSelectCode("F",false);
    ComBkgTextCode2ComboItem(splitFlgComboValue,   splitFlgComboText,   getComboObject(comboObjects, 'split_flg'),   	"|", "\t" );
	ComBkgTextCode2ComboItem(chargeFlgComboValue,  chargeFlgComboText,  getComboObject(comboObjects, 'charge_flg'),  	"|", "\t" );
	getComboObject(comboObjects, 'charge_flg').SetSelectCode("C",false);
	ComBkgTextCode2ComboItem(ratingTypeComboValue, ratingTypeComboText, getComboObject(comboObjects, 'auto_rat_flg'),	"|", "\t" );
    ComBkgTextCode2ComboItem(ratUtCdComboValue,   ratUtCdComboText,     getComboObject(comboObjects, 'rat_ut_cd'),  	"|", "\t" );
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
		    with(sheet1){
	        
	      var HeadTitle1="bkg_no|bkg_ctrt_tp_cd|Seq.|RHQ|Office|B/L No.|BKG Date|Appl.Date|POL ETD|T/VVD|Contract\nType|Contract No.|Rep.\nCMDT Code|CMDT Code|Commodity|Commodity (M&D)|Cargo Type|Cargo Type|Cargo Type|Cargo Type|Cargo Type|Cargo Type|EQ Sub|Scope|POR|POL|POD|DEL|R/D Term|R/D Term|USA\nSVC Mode|Shipper|Consignee|Notify|Contract|Contract|Contract|BDR\nStatus|BKG\nStatus|Split\nStatus|Charge\nStatus|Rating\nType|Bill\nType|INR Auth No.|Rater ID|RDN Issuance|RDN Status|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info";
	      var HeadTitle2="bkg_no|bkg_ctrt_tp_cd|Seq.|RHQ|Office|B/L No.|BKG Date|Appl.Date|POL ETD|T/VVD|Contract\nType|Contract No.|Rep.\nCMDT Code|CMDT Code|Commodity|Commodity (M&D)|DG|RF|AK|BB|RD|HG|EQ Sub|Scope|POR|POL|POD|DEL|R|D|USA\nSVC Mode|Shipper|Consignee|Notify|Customer|Type|Seg.|BDR\nStatus|BKG\nStatus|Split\nStatus|Charge\nStatus|Rating\nType|Bill\nType|INR Auth No.|Rater ID|RDN Issuance|RDN Status|Charge|Cur|Rate|Rated As|Per|Amount|M";
	      
	      SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:0 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ctrt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Popup",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_aply_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ctrt_tp_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cstms_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rd_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hngr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_subst_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"s_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"c_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"n_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"ctrt_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_val_sgm_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"split_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"charge_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"auto_rat_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_bl_tp_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"inr_auth_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rater_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rdn_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rdn_sts_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"chg_ut_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rat_as_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"chg_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"auto_rat_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);

	      SetEditable(1);
	      SetCountPosition(0);
	      //nosupport[checkagain]CLT UnEditableColor="#FFFFFF";
	      FrozenCols=4;
	      SetShowButtonImage(2);
	      SetSheetHeight(300);
	      
	      }


	      	break;
		case "sheet2": // combo
		    with(sheet2){
	        
	      var HeadTitle1="Seq.|chg_cd|chg_nm|rep_chg_cd"

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	       
	      InitColumns(cols);

	      SetEditable(1);
	      SetSheetHeight(100);
	            }


			break;
		case "sheet3": // backendjob
		    with(sheet3){
	        
	      var HeadTitle1="f_text1"

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	       
	      InitColumns(cols);

	      SetEditable(1);
	      SetVisible(0);
	      var idx=sheet3.DataInsert();
	      SetSheetHeight(65);
	      }


			break;
	}
}
/**
 * initializing ComboData <br>
 **/
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
		// RHQ
		case "bkg_rhq_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    // UpperCase Only
                SetMaxLength(5);
			}
			break;
		// office
		case "bkg_ofc_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    //  UpperCase Only		
			}
			break;
			// Contract type
        case "bkg_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
				SetUseAutoComplete(1);
            //no support[check again]CLT 	ValidChar(2, 2);    //  UpperCase Only + Special Characters
            }
            break;      
		// scope
		case "svc_scp_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    //  UpperCase Only
                SetMaxLength(3);
			}
			break;
		// charge
		case "chg_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    //  UpperCase Only
                SetMaxLength(3);// Input 3 digits
			}
			break;
		case "chg_cd1":
			var i=0;
			with (comboObj) {
				SetDropHeight(200);
				SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    // UpperCase Only
                SetMaxLength(3);// Input 3 digits
			}
			break;	
		// R/D Term
		case "rcv_term_cd":
            var i=0;
            with(comboObj) {
            	SetDropHeight(260);
            	SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(1, 0);    // English only
            }
            break;    
        // R/D Term    
		case "de_term_cd":
            var i=0;
            with(comboObj) {
            	SetDropHeight(260);
            	SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(1, 0);   // English only
            }
            break;  
        // cargo type
		case "cargo_type":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
            	SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    //  Upper case Only
                SetMaxLength(2);// Input 2 digits
            }
            break;
        // BKG Status
		case "bkg_sts_cd":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
            	SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);    //  Upper case Only
                SetMaxLength(1);// Input 1 digits
            }
            break;  
        // Charge Status
		case "charge_flg":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
            	SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);     //  Upper case Only
                SetMaxLength(1);// Input 1 digits
            }
            break;  
        // Split Status
		case "split_flg":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
            	SetUseAutoComplete(1);
//no support[check again]CLT 				ValidChar(2, 0);     //  Upper case Only
                SetMaxLength(1);// Input 1 digits
            }
            break;  
         // Rating Unit
		case "rat_ut_cd":
            var i=0;
            with(comboObj) {
            	SetMultiSelect(1);
            	Style=0;
            }
            break;  
	}
}      
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick(){
	var form=document.form;
	var rdoDateObj=form.rdoDate;
    try {
	    var srcName=ComGetEvent("name");
	    switch(srcName) {
	        case "btns_calendar1": 
	        	var cal=new ComCalendar();
	        	cal.select(form.from_dt, 'yyyy-MM-dd');
	        	break;
	        case "btns_calendar2":
		        var cal=new ComCalendar();
		        cal.select(form.to_dt, 'yyyy-MM-dd');
		        break;
	        case "ctrt_popup":
	        	var pgmNo="";
	        	var ctrtTpCd=getComboObject(comboObjects, 'bkg_ctrt_tp_cd').GetSelectCode();
	        	if(ctrtTpCd == "S") { // S/C
	 				pgmNo="ESM_PRI_0062";
	 				comRASCallPop(pgmNo, "ESM_BKG_0151", "", "");
	 			}
	 			else if(ctrtTpCd == "R") { // RFA
	 	    		pgmNo="ESM_PRI_2043";
	 	    		comRASCallPop(pgmNo, "ESM_BKG_0151", "", "");
	 	    	}
	 	    	else if(ctrtTpCd == "T") { // TAA
		    		pgmNo="ESM_PRI_3007";
		    		comRASCallPop(pgmNo, "ESM_BKG_0151", "", "");
		    	}
	        	else {
	        		ComShowCodeMessage("BKG00016");	        		
	        	}
	        	//comRASCallPop(pgmNo, "ESM_BKG_0151", "", "");
				break;
	        case "cmdt_popup":
				var param="";
	    		param=param + "&" + "cmdt_cd=" + form.cmdt_cd.value;
	    		ComOpenPopup('/opuscntr/COM_ENS_011.do?' + param, 800, 450, 'setCallBackCmdtPopup', '1,0,1,1,1,1,1,1', true);
				break;
	        case "vvd_popup":
				var param="";
	    		param=param + "&" + "vvd_cd=" + form.vvd.value;
	    		ComOpenPopup('/opuscntr/COM_ENS_0B2.do?' + param, 780, 500, 'setCallBackVVDPopup', '1,0,1,1,1,1,1,1', true);
				break;
			case "btn_por_cd":
			case "btn_pol_cd":
			case "btn_pod_cd":
			case "btn_del_cd":
				gLocationObj=eval("form."+(srcName.substr(4))); 
				ComOpenPopup("COM_ENS_051.do", 800, 460,"setLocationCd", "1,0,1,1,1", true);
				break;
	    	case "btn_retrieve":

	    		if (validateForm(sheet1, form, IBSEARCH)) {

	    			//doActionIBSheet(sheet1, form, IBSEARCH);
	    			doActionIBSheet(sheet2, form, IBBATCH);	    			
	    		}
	    		break;
	    	case "btn_new":
	    		//form.reset();
	    		ComResetAll();
	    		setNew();
	    		break;
	    	case "btn_downexcel":
	    		doActionIBSheet(sheet1, form, IBDOWNEXCEL);
	    		break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
	}
}
/**
* control onkeypress event
*/
function obj_keypress(){
	var obj=event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //date
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //number
 	case "number": //number
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}
/**
* control click event
*/
function obj_click(){
	var form=document.form;
	var obj=event.srcElement;
	switch(ComGetEvent("name")){
		case "r_date":
			form.search_date.value=obj.value;
			break;
		case "bill_type_all":
	 		var tf=false;
	 		if(obj.checked) {
	 			tf=true;
	 		}
	 		setBillTypeCheckBox(tf);
	 		break;
		case "chg_tp":
			form.charge_type.value=obj.value;
			break;
		case "chg_cond":
			form.charge_condition.value=obj.value;
			break;
	}
}
/**
* control OnBeforeActivate event
*/    
function obj_activate() {
    ComClearSeparator (event.srcElement);
}
/**
* control Onbeforedeactivate event
*/    
function obj_deactivate() {
	var form=document.form;
	var formObj=event.srcElement;
    var srcName=formObj.getAttribute("name");
    switch(srcName) {
		case "ctrt_no":
		case "cmdt_cd":
		case "cust_seq":
		case "cust_nm":
			break;
		case "vvd":
		case "bl_no":
			getSearchCondtion(formObj);
			break;
		default :
			ComChkObjValid(formObj);
	}
}
/**
* control UI Object(LCD) event
*/    
function setLocationCd(aryPopupData) {
	gLocationObj.value=aryPopupData[0][3];
} 
/**
* control UI Object(CMDT) event
*/ 
function setCallBackCmdtPopup(aryPopupData) {
	var form=document.form;
	form.cmdt_cd.value=aryPopupData[0][2];
} 
/**
* control UI Object(VVD) event
*/ 
function setCallBackVVDPopup(aryPopupData) {
	var form=document.form;
	form.vvd.value=aryPopupData[0][7];
} 
/**
* control popup click event
*/ 
function sheet1_OnPopupClick(sheetObj, Row, Col) {
 	var form=document.form;
 	var colName=sheetObj.ColSaveName(Col);
 	switch(colName){
		case "bl_no":
			var bkgNo=sheetObj.GetCellValue(Row, "bkg_no");
         	if(null == bkgNo || "" == bkgNo) { return; }
         	var popParams="bkg_no=" + bkgNo + "&openTab=B9";
        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0151", popParams, "");
 			break;
		case "ctrt_no":
			var ctrtNo=sheetObj.GetCellValue(Row, "ctrt_no");
         	if(null == ctrtNo || "" == ctrtNo) { return; }
         	var form=document.form;
         	var ctrtTpCd=sheetObj.GetCellValue(Row, "bkg_ctrt_tp_cd");
 			var pgmNo="";
 			var popParams="";
 			if(ctrtTpCd == "S") { // S/C
 				pgmNo="ESM_PRI_0004";
     			popParams="sc_no_p=" + ctrtNo.substr(0,3) + "&sc_no_s=" + ctrtNo.substr(3);
 			}
 			else if(ctrtTpCd == "R") { // RFA
 	    		pgmNo="ESM_PRI_2019";
 	    		popParams="s_rfa_no=" + ctrtNo;
 	    	}
 	    	else if(ctrtTpCd == "T") { // TAA
	    		pgmNo="ESM_PRI_3007";
	    		popParams="cond_taa_no=" + ctrtNo;  
	    	}
        	comRASCallPop(pgmNo, "ESM_BKG_0151", popParams, "");
 		    break;
		case "rdn_no":
			var rdnNo=sheetObj.GetCellValue(Row, "rdn_no");
			var blNo=sheetObj.GetCellValue(Row, "bl_no");
			var rhqCd=sheetObj.GetCellValue(Row, "bkg_rhq_cd");
			var ofcCd=sheetObj.GetCellValue(Row, "bkg_ofc_cd");
		    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
			var popParams="rdn_no=" + rdnNo + "&bl_no=" + blNo + "&rct_rhq_cd=" + rhqCd + "&rct_ofc_cd=" + ofcCd;
    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_0256", popParams, "");
			break;
 	}
 } 	      
/**
* control OnSearchEnd event
*/ 
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var form=document.form;
    initIBComboItem();
}   
/**
* control bkg_rhq_cd_OnChange event
*/ 
function bkg_rhq_cd_OnChange(rhqObj, oldindex, oldtext, oldcode, newindex , Text , Code) {
	var form=document.form;
	var officeObj=bkg_ofc_cd;
	officeObj.RemoveAll();
	if(null == Code || "" == Code) {
		officeObj.InsertItem(0, "", "");
	}else{
		var params="f_cmd=" + COMMAND02 + "&etc2=" + Code;
		var sXml=sheet1.GetSearchData("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, officeObj, "cd", "cd");
		officeObj.InsertItem(0, "", "");
		officeObj.SetSelectCode(form.strOfc_cd.value);
	}
}
/**
* control checkBox event
*/ 
function setBillTypeCheckBox(tf) {
	/*
	common code : B/L COVERED TYPE CODE ( CD01639 )
	B CO-BIZ B/L 
	C COVERED B/L
	M MASTER B/L
	N NORMAL B/L
	*/
	var form=document.form;
	form.bill_type_n.checked=tf;
	form.bill_type_m.checked=tf;
	form.bill_type_c.checked=tf;	
	form.bill_type_b.checked=tf;		
}
/**
* reset form data
*/ 
function setNew() {
	var form=document.form;
	var rhqObj=bkg_rhq_cd;
	var officeObj=bkg_ofc_cd;
	var bkgCtrtTpObj=bkg_ctrt_tp_cd;
	var bkgStatusObj=bkg_sts_cd;
	var chargeStatusObj=charge_flg;
	form.from_dt.className="input1";
	form.to_dt.className="input1";
	officeObj.RemoveAll();
    rhqObj.SetSelectIndex("-1");
   	rhqObj.SetSelectCode(gBkgRhqCd);
   	bkgStatusObj.SetSelectCode("F",false);
   	chargeStatusObj.SetSelectCode("C",false);
   	sheet1.RemoveAll();
}
//handling of Sheet process 
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheet1.ShowDebugMsg(false);
	switch(sAction) {
        case IBSEARCH: // retrieve
        	formObj.f_cmd.value=SEARCH;
  			sheet1.DoSearch("ESM_BKG_0151GS.do", FormQueryString(formObj) );
 			break;
        case IBBATCH: //backendjob
        	try {
        		formObj.f_cmd.value=COMMAND01;
    			ComOpenWait(true);
    			sheet1.SetWaitImageVisible(0);
    			sheet3.SetWaitImageVisible(0);
     			var sXml=sheet3.GetSearchData("ESM_BKG_0151GS.do", FormQueryString(formObj));
    			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
    			if (backendJobKey.length > 0) {
    				formObj.backendjob_key.value=backendJobKey;
    				sheet3.SetWaitTimeOut(10000);
    				timer=setInterval(getBackEndJobStatus, 3000); // backendjob time : 3 sec
    			}else{
        			ComOpenWait(false);
    			}
        	}catch(e){
        		ComShowMessage(e);
    			ComOpenWait(false);
	    	}
 			break;
		case IBDOWNEXCEL:      //download excel
			if(sheet1.RowCount() < 1){
				ComShowCodeMessage("COM132501");
			}else{
				sheet1.Down2Excel({ HiddenColumn:1});
			}
			//sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
			break;
	}
}
//handling of Sheet process 
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheet2.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH_ASYNC01:
         	gXml=sheet2.GetSearchData("RASCommonGS.do?", "f_cmd=" + SEARCHLIST09);
			ComXml2ComboItem(gXml, chg_cd, "chg_cd", "chg_cd|chg_nm");
			ComXml2ComboItem(gXml, chg_cd1, "chg_cd", "chg_cd|chg_nm");
			chg_cd.InsertItem(0, "", "");
			chg_cd1.InsertItem(0, "", "");
 			sheet2.LoadSearchData(gXml,{Sync:1} );
			break;
	}
}
/**
* check BackEndJob 
*/
function getBackEndJobStatus() {
	try {
		var form=document.form;
		form.f_cmd.value=SEARCH;
 		var sXml=sheet3.GetSearchData("ESM_BKG_0151GS.do", FormQueryString(form));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") { // Fail to BackEndJob
			ComShowCodeMessage("BKG95019"); //msgs['BKG95019']='Failed to download. Please try again.';
			clearInterval(timer);	
			ComOpenWait(false);	
		} else if (jobState == "5") {
			ComShowCodeMessage("BKG95020"); //msgs['BKG95020']='Data was downloaded successfully.'
			clearInterval(timer);
			ComOpenWait(false);	
		}
	}catch(e){
		ComShowMessage(e);
		ComOpenWait(false);
	}
}
/**
* Excel download(Request Expense Inital)
*/
function getBackEndJobLoadFile() {
	try {
		var form=document.form;
		form.f_cmd.value=SEARCHLIST;
		var formString="f_cmd=" + form.f_cmd.value + "&backendjob_key=" + form.backendjob_key.value;
 		var sXml=sheet1.GetSearchData("ESM_BKG_0151GS.do", formString);
		sheet1.LoadSearchData(sXml,{Sync:1} );
		if(sheet1.RowCount() > 0)
			form.bl_cnt.value=sheet1.GetCellValue(sheet1.RowCount()+ sheet1.HeaderRows()-1,2);
		else
			form.bl_cnt.value = 0;
	}catch(e){
		ComShowMessage(e);
	}finally{        	
		ComOpenWait(false);        		
	}
}
/**
 * handling process for input VVD validation
 */
function getSearchCondtion(formObj){
	var form=document.form;
	var srcName=formObj.getAttribute("name");
    switch(srcName) {
	case "vvd":
	case "bl_no":
		if(form.vvd.maxLength == form.vvd.value.length ||
		   form.bl_no.maxLength == form.bl_no.value.length ) {
			form.from_dt.className="input";
			form.to_dt.className="input";
			form.ctrt_no.className="input";
		}
		else {
			form.from_dt.className="input1";
			form.to_dt.className="input1";
			form.ctrt_no.className="input1";
		}
		if(srcName == "bl_no" && form.bl_no.maxLength == form.bl_no.value.length) {
			getComboObject(comboObjects, 'bkg_rhq_cd').SetSelectCode("");
		}
		break;
	default:
		break;
    }
    return true;
}
/**
 * handling process for input Date validation
 */
function chkDate(chkDays) {
	var form=document.form;
    var fmDtObj=form.from_dt;
    var toDtObj=form.to_dt;
	var fmDtValue=fmDtObj.value.replace(/-/g,'');
	var toDtValue=toDtObj.value.replace(/-/g,'');
	if(fmDtObj.className == "input1" && fmDtValue == ""){
		ComShowCodeMessage("BKG95025", fmDtObj.caption);
		event.returnValue=false;		
		ComSetFocus(fmDtObj);
		return false;
	}
	if(!ComChkObjValid(fmDtObj)) { return false; }
	if(toDtObj.className == "input1" && toDtValue == ""){
		ComShowCodeMessage("BKG95025", toDtObj.caption);
		event.returnValue=false;		
		ComSetFocus(toDtObj);
		return false;
	}
	if(!ComChkObjValid(toDtObj)) { return false; }
	if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
		ComShowCodeMessage("BKG95026", "From Date", "To Date");
		event.returnValue=false;
		ComSetFocus(fmDtObj);
		return false;
	}
	if(fmDtValue != "" && toDtValue != "") {
		var fromAddDays=ComGetDateAdd(fmDtValue, "D", parseInt(chkDays, 10) - 1, "", true);
		if( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) {
			ComShowCodeMessage("BKG95027", chkDays + " days"); // "The period of Date can't be over {?msg1}."
			event.returnValue=false;		
			ComSetFocus(fmDtObj);
			return false;
		}
	}
	return true;
}
/**
 * handling process for input validation
 */ 
function validateForm(sheetObj, formObj, sAction){

	var form=document.form;
	var rhqObj=form.bkg_rhq_cd;
	var rhq = bkg_rhq_cd;
	var fmDtObj=form.from_dt;	
	var toDtObj=form.to_dt;
	var vvdObj=form.vvd;
	var ctrtNoObj=form.ctrt_no;
	var blNoObj=form.bl_no;
	var fmDtValue=fmDtObj.value;	
	var toDtValue=toDtObj.value;

    switch (sAction) {
    	case IBSEARCH: // retrieve
			if((null == rhq.GetSelectCode()|| "" == rhq.GetSelectCode()) && blNoObj.maxLength != blNoObj.value.length) {
				ComShowCodeMessage("BKG95031", "RHQ");
				ComSetFocus(rhq);
				return false;
			}
			if(!ComChkObjValid(fmDtObj)) { return false; }
			if(!ComChkObjValid(toDtObj)) { return false; }
//			if("" == ctrtNoObj.value && "" == blNoObj.value && "" == vvdObj.value) {
//				 ComShowCodeMessage("BKG95025", "Contract No."); // "Please input {?msg2}."
//				 ComSetFocus(ctrtNoObj);
//				 return false;
//			}
			if("" == blNoObj.value && "" == vvdObj.value && ("" == fmDtValue || "" == toDtValue)) {
				 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
				 if("" == fmDtObj.value) {
					 ComSetFocus(fmDtObj);
				 }else{
					 ComSetFocus(toDtObj);
				 }
				 return false;
			}
			if(!chkDate(31)) { return false; }
			break;
    }
    return true;
}
/**
 * handling process chg_cd change
 */
function chg_cd_OnChange(comboObj, code, text) {
		if(chg_cd.GetItemCount() > 0 && chg_cd.GetSelectIndex()!= "-1") {
			if(code == "") {
				chg_cd1.SetSelectIndex("-1");
				chg_cd1.SetEnable(0);
			} else {
				chg_cd1.SetSelectIndex("-1");
				chg_cd1.SetEnable(1);
			}
		} 
	}
