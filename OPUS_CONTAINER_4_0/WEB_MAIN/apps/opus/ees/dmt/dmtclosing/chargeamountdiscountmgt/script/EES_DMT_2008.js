/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2008.js
*@FileTitle  : DEM/DET Adjustment Request - After Booking Request 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
	// Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//Defining Action
	var IBSEARCH_CHECK_CALC=101;
	var IBSEARCH_CHECK_DUP=102;
	var IBSEARCH_CHECK_BALCHG=103;
	var IBSEARCH_BKG=104;
	var IBSEARCH_CNTRCHG_BKG=105;
	var IBSEARCH_COMM=106;
	var IBSEARCH_DAR=107;
	var IBSEARCH_CURR=108;
	var IBSEARCH_CHECK_BKGNO=109;
	var IBSAVE_CANCEL=201;
	//Defining data unit separator
	var ROWMARK="|";
	var FIELDMARK="=";
	var TARIFF="dmdt_trf_cd";
	var BKG_NO="bkg_no";
	var BL_NO="bl_no";
	var FT_FLG="ft_adj_flg";
	var ADD_DYS="ft_add_dys";
	var TTL_DYS="ft_ttl_dys";
	var SAT_FLG="xcld_sat_flg";
	var SUN_FLG="xcld_sun_flg";
	var HOL_FLG="xcld_hol_flg";
	var DCAR_CURR="curr_cd";	
	var DCAR_FLG="dc_flg";
	var DCAR_AMT="dc_amt";
	var DCAR_RTO="dc_rto";
	var DCAR_RTO2="dc_rto2";
	var TVVD="tvvd";
	var POR="por_cd";
	var POL="pol_cd";
	var POD="pod_cd";
	var DEL="del_cd";
	var RD="rd";
	var DG_FLG="dcgo_flg";
	var RF_FLG="rc_flg";
	var AK_FLG="awk_cgo_flg";
	var BB_FLG="bb_cgo_flg";
	var RD_FLG="rd_cgo_flg";
	var SOC_FLG="soc_flg";
	var CMDT_CD="cmdt_cd";
	var CMDT_NM="cmdt_nm";
	var CNTR_FLG="each_cntr_flg";
	var STS="dmdt_chg_sts_cd";
	var CNTR_NO="cntr_no";
	var CNTR_TS="cntr_tpsz_cd";
	var OFC="ofc_cd";
	var FM_YD="fm_mvmt_yd_cd";
	var FT_DYS="ft_dys";
	var FT_OVR_DYS="fx_ft_ovr_dys";
	var CURR="bzc_trf_curr_cd";
	var DC_AMT="aft_expt_dc_amt";
	var BIL_AMT="bil_amt";
	var ORG_BIL_AMT="org_bil_amt";
	var AR="dmdt_ar_if_cd";
	var AR_FLG="cntr_chg_dc_flg";
	var AR_AMT="cntr_chg_dc_amt";
	var AR_RTO="cntr_chg_dc_rto";
	var AR_RTO2="cntr_chg_dc_rto2";
	var CNTR_TP="cntr_tp";
	var STS_DESC="sts_desc";
	var PROG_DT="prog_dt";
	var PROG_OFC_CD="prog_ofc_cd";
	var PROG_USR_NM="prog_usr_nm";
	var PROG_RMK="prog_rmk";
	var SRCH_FLG="child_search";	//status column of Searching Billable Amount per CNTR information of BKG or not  
	var DAR_NO="aft_expt_dar_no";
	var ADJ_SEQ="aft_expt_adj_seq";
	var CNTR_SEQ="aft_expt_cntr_seq";
	var CHG_SEQ="chg_seq";
	var GB="chg_seq_desc";
	var SYS_ID="sys_area_grp_id";
	var CNTR_NO="cntr_no";
	var CNTR_CYC_NO="cntr_cyc_no";
	var LOC_DIV_CD="dmdt_chg_loc_div_cd";
	var RQST_OFC_CD="rqst_ofc_cd";
	// Division of delte flag and hidden flag becaouse of Container belons is hidden
	var HIDDEN="hidden";
	//case in calling sheet1_OnSelect func. in ROW COPY , skip logic 
	var isDataCopy=false;
  	//  Row select Staus keep  go on  when it is Sorting
	var currAdjSeq="";

	var DEF_SHEET_HEIGHT = 125;
	var CHG_SHEET_HEIGHT = 132;
	var CMT_SHEET_HEIGHT = 98;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** case in Sheet count are more two by Tab, defining adding sheet *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
   	try {
   		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_AddBkgReq":
						if (ComIsBtnEnable("btn_AddBkgReq")) 
							doActionAddADJAfterBKG();
						break;
					case "btn_DelBkgReq":
						if (ComIsBtnEnable("btn_DelBkgReq")) 
							doActionDelADJAfterBKG();
						break;
					case "btn_PreCalc":
						if (ComIsBtnEnable("btn_PreCalc")) 
							doActionPreCalc();
						break;
					case "btn_Reset":
						if (ComIsBtnEnable("btn_Reset"))
							doActionReset();
						break;
					case "btn_Retrieve":
						if (ComIsBtnEnable("btn_Retrieve")) 
							doActionRetrieve();
						break;
					case "btn_New":
						if (ComIsBtnEnable("btn_New")) 
							doActionNew();
						break; 
					case "btn_Request":
						if (ComIsBtnEnable("btn_Request")) 
							doActionRequest();
						break;
					case "btn_Cancel":
						if (ComIsBtnEnable("btn_Cancel"))
							doActionCancel();
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
   
   /** setComboObject
    * 
    * @param combo_obj
    */
   function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}   
   /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen.
    */
   function loadPage() {
   	var formObj=document.form;
       for (i=0 ; i < sheetObjects.length ; i++) {
           ComConfigSheet (sheetObjects[i] );
           initSheet(sheetObjects[i],i+1);
           ComEndConfigSheet(sheetObjects[i]);
       }
       
       for(var k=0;k<comboObjects.length;k++){
      	 	initCombo(comboObjects[k],k+1);
       }

	    axon_event.addListener('blur', 'comment_Change', 'comment');
		//Clearalizing html control event
		initControl();
		
		//in loading page, be deactivating specific fields.
		initDisableControls();
		
		//Free Time of Billable Amount per CNTR, F/T Exclusion, Amount or Ratio :hidden
		hideContainerColumn(true);

		//1.initializing all buttons status
  		initBtnControl();
  		
		sheet1_OnLoadFinish();
		
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND06);
		
		var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
   		ComSetObjValue(comboObjects[0], usrRhqOfcCd);
		
   }
   
   
	// if it create IBSheet instance in page, using Object tag create IBSheet instance, then occur Event.
   function sheet1_OnLoadFinish() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		
  		//1.setting Combo, after search Tariff Type
  		doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCHLIST,TARIFF);	
	}
	
	
 	function initControl() {
		axon_event.addListenerForm('beforedeactivate','obj_deactivate',  document.form, 'cond_type'); //- out of focus
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard		
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//		axon_event.addListener('blur', 'obj_blur', 'custCd');
	}
 	
 	
 	function initDisableControls() {
		 var formObj=document.form;
		 with(formObj) {
			 ComEnableManyObjects(false, status, scNo, rfaNo, custCd, custNm, cntrQty, curr, totalBillAmt);
			 status.className="input2";
			 scNo.className="input2";
			 rfaNo.className="input2";
			 custCd.className="input2";
			 custNm.className="input2";
			 cntrQty.className="input2";
			 curr.className="input2";
			 totalBillAmt.className="input2";
			//Comment initializing +++++++++++++++++++++++++++++++++++
			chkComment.checked=false;
			comment.readOnly=true;
			comment.className="textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++
		 }
 	}
  /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
   function initSheet(sheetObj,sheetNo) {
       var cnt=0;
		var sheetID=sheetObj.id;
       switch(sheetID) {
           case "sheet1":
        	   with(sheetObj){
        	   var HeadTitle1="|Seq.|BKG No.|B/L No.|Tariff|by Cntr|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|T/VVD|POR|POL|POD|DEL|RCV/DEL|Special|Special|Special|Special|Special|Special|Commodity|Commodity";
        	   var HeadTitle2="|Seq.|BKG No.|B/L No.|Tariff|by Cntr|Y|Add|Total|SAT|SUN|H/day|Y|CUR|AMT|Ratio|Ratio|T/VVD|POR|POL|POD|DEL|RCV/DEL|DG|RF|AK|BB|RD|S.O.C|Code|Name";
        	   var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:17, DataRowMerge:0 } );
        	   var headers=[ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
        	   InitHeaders(headers, info);
        	   var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
        	   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
        	   {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:BKG_NO,         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
        	   {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:BL_NO,          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
        	   {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:CNTR_TP,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:FT_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	   {Type:"Int",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:ADD_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2, GetToolTipText:"Additional Day" },
        	   {Type:"Int",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:TTL_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2, GetToolTipText:"Total Day" },
        	   {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:DCAR_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	   {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:DCAR_CURR,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:DCAR_AMT,       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
        	   {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:DCAR_RTO,       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
        	   {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:DCAR_RTO2,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:TVVD,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:POR,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:POL,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:POD,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:DEL,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:RD,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:DG_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:RF_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:AK_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:BB_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:RD_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SOC_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CMDT_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:CMDT_NM,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:CNTR_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:DAR_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:ADJ_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:RQST_OFC_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:SRCH_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
        	   InitColumns(cols);
        	   //SetSheetWidth(mainTable.clientWidth);
        	   SetSheetHeight(DEF_SHEET_HEIGHT,1);
        	   SetColProperty(CNTR_TP, {ComboText:"All|Different", ComboCode:"S|D"} );
        	   SetCountPosition(0);
        	   }
       	   break;
       	   
           case "sheet2":
        	   with(sheetObj){
        	   var HeadTitle1="|Seq.|STS|A/R|CNTR No.|T/S|Office|From YD|F/T|Over|Cur.|Billable AMT|G/B|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio";
        	   var HeadTitle2="|Seq.|STS|A/R|CNTR No.|T/S|Office|From YD|F/T|Over|Cur.|Billable AMT|G/B|Y|Add|Total|SAT|SUN|H/day|Y|CUR|AMT|Ratio|Ratio";
        	   var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:0 } );
        	   var headers=[ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
        	   InitHeaders(headers, info);
        	   var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:STS,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:AR,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:CNTR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:CNTR_TS,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:OFC,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:FM_YD,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:FT_DYS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:FT_OVR_DYS,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:CURR,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:BIL_AMT,        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:GB,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:FT_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	   {Type:"Int",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ADD_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2, GetToolTipText:"Additional Day" },
        	   {Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TTL_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2, GetToolTipText:"Total Day" },
        	   {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:AR_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	   {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:DCAR_CURR,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:AR_AMT,         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
        	   {Type:"Float",     Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:AR_RTO,         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
        	   {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:AR_RTO2,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:BKG_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:BL_NO,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:DAR_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:ADJ_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:CNTR_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:SYS_ID,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CNTR_CYC_NO,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:TARIFF,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:LOC_DIV_CD,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CHG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:ORG_BIL_AMT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HIDDEN,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
        	   InitColumns(cols);
        	   SetSheetHeight(CHG_SHEET_HEIGHT,1);
        	   SetCountPosition(0);
        	   }
       	   break;
       	   
           case "sheet3":
        	   with(sheetObj){
        	   var HeadTitle1="|Seq.|Status|Date|Office|Name";
        	   var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	   // 그리드에 맨 마지막 컬럼을 FrozenCol 로 적용할 수 없다고 함.
        	   // 동적으로 FrozenCol 적용메소드 사용시 오류로 인해서 패치 전까지 FrozenCol 설정해제함.
        	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
        	   var headers=[ { Text:HeadTitle1, Align:"Center"} ];
        	   InitHeaders(headers, info);
        	   var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        	   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
        	   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:STS_DESC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:PROG_DT,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:PROG_OFC_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:PROG_USR_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:PROG_RMK,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
        	   InitColumns(cols);
        	   SetSheetHeight(CMT_SHEET_HEIGHT,1);
        	   SetCountPosition(0);
        	   }
       	   break;
       }
   }
   
 // Process of Sheet
   function doActionIBSheet(sheetObj,formObj,sAction) {
	   sheetObj.ShowDebugMsg(false);
       switch(sAction) {
       		case IBSEARCH:     // Search
	       		var sheetBKGObj=sheetObjects[0];
	       		var sheetCNTRObj=sheetObjects[1];
	       		var sheetHSTObj=sheetObjects[2];
					//1.Setting parametor condition, before retrieving
	   			ComSetObjValue(formObj.f_cmd, 		SEARCH);
	       		ComSetObjValue(formObj.apvl_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
	       		ComSetObjValue(formObj.dar_no, 		ComGetObjValue(formObj.darNo));
	       		ComSetObjValue(formObj.apvl_no, 	ComGetObjValue(formObj.apvlNo));
					//2.Clear previous retrieving results.
	       		sheetBKGObj.RemoveAll();
	       		sheetCNTRObj.RemoveAll();
	       		sheetHSTObj.RemoveAll();
	       		//initializing Comment Grid
	       		with(formObj) {
	           		ComClearObject(cntrQty);
	           		ComClearObject(curr);
	           		ComClearObject(totalBillAmt);
	       		}
				//3.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2008GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				//4.Result mapping in each Grid, after retrieving 
				
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
					//Setting results to condition fields
					approvalOfcCd.SetSelectCode(ComGetEtcData(sXml, "APVL_OFC_CD"));
					ComSetObjValue(formObj.darNo, 			ComGetEtcData(sXml, "DAR_NO"));
					ComSetObjValue(formObj.apvlNo, 			ComGetEtcData(sXml, "APVL_NO"));
					ComSetObjValue(formObj.status, 			ComGetEtcData(sXml, "STS_DESC"));
					ComSetObjValue(formObj.scNo, 			ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.rfaNo, 			ComGetEtcData(sXml, "RFA_NO"));
					ComSetObjValue(formObj.custCd, 			ComGetEtcData(sXml, "CUST_CD"));
					ComSetObjValue(formObj.custNm, 			ComGetEtcData(sXml, "CUST_NM"));
					//mapping results to Grid
					sheetObj.LoadSearchData(sXml, {Sync:1});
					
			        if (sheetObj.RowCount()> 0) {
						//after retrieving , retrieved fields are deactivating .
						 with(formObj) {
							 ComEnableManyObjects(false, darNo, apvlNo);
							 darNo.className="input2";
							 apvlNo.className="input2";
						 }						
					}
					//after retrieving , BKG No., B/LL No., Tariff are protected,
					with(sheetObj) {
						for (var row=HeaderRows(); row <= LastRow(); row++) {
							disableKeyColumn(row);
						}
					}
				}
			break;
			
			    //Calculation Type Check
	       	case IBSEARCH_CHECK_CALC:
	       		
					//1.Setting parametor condition, before retrieving
	   			ComSetObjValue(formObj.f_cmd, SEARCH04);
					//2.retrievie according to conditions
	   			//*********************************************************************************
	   			ComOpenWait(true);
	   			sheetObj.SetWaitImageVisible(0);
	   			//*********************************************************************************
	   			var sXml=sheetObj.GetSearchData("EES_DMT_2008GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				ComSetObjValue(formObj.result,  handleNullString(ComGetEtcData(sXml, "CHECK_CALC")));
				ComSetObjValue(formObj.result2, handleNullString(ComGetEtcData(sXml, "LOC")));
				ComSetObjValue(formObj.result3, handleNullString(ComGetEtcData(sXml, "CALC_TYPE")));
       		break;
       		
	       	// Check Duplication Tariff Type and BKG. B/L NO
	       	case IBSEARCH_CHECK_DUP:
					//1.Setting parametor condition, before retrieving
	   			ComSetObjValue(formObj.f_cmd, SEARCH05);
					//2.retrievie according to conditions
	   			//*********************************************************************************
	   			ComOpenWait(true);
	   			sheetObj.SetWaitImageVisible(0);
	   			//*********************************************************************************
	   			var darNo=ComSearchEtcData(sheetObj, "EES_DMT_2008GS.do", FormQueryString(formObj), "DAR_NO");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				if (darNo != "")
					ComSetObjValue(formObj.result, "Y");	
				else
					ComSetObjValue(formObj.result, "N");
				ComSetObjValue(formObj.result2, darNo);
			break;
			
	       	//Balance Charge Check
	       	case IBSEARCH_CHECK_BALCHG:
					//1.Setting parametor condition, before retrieving
	   			ComSetObjValue(formObj.f_cmd, SEARCH06);
					//2.retrievie according to conditions
	   			//*********************************************************************************
	   			ComOpenWait(true);
	   			sheetObj.SetWaitImageVisible(0);
	   			//*********************************************************************************
	   			var sValue=ComSearchEtcData(sheetObj, "EES_DMT_2008GS.do", FormQueryString(formObj), "CHECK_BALCHG");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				var result=handleNullString(sValue);
				ComSetObjValue(formObj.result, result);
       		break;
       		
	       	//Check validation of  BKG, B/L No. 
	       	//Check S/C No., RFA No. information
        	case IBSEARCH_CHECK_BKGNO:
        		//1.Setting parametor condition, before retrieving
        		ComSetObjValue(formObj.f_cmd, COMMAND02);
        		with(sheetObj) {
					ComSetObjValue(formObj.bl_no, 	GetCellValue(GetSelectRow(), BL_NO));
					ComSetObjValue(formObj.bkg_no, 	GetCellValue(GetSelectRow(), BKG_NO));
        		}
	        	//2.retrievie according to conditions
	   			//*********************************************************************************
	   			ComOpenWait(true);
	   			sheetObj.SetWaitImageVisible(0);
	   			//*********************************************************************************
	   			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				var bkgNo=handleNullString(ComGetEtcData(sXml, "BKG_NO"));
				var blNo=handleNullString(ComGetEtcData(sXml, "BL_NO"));
				var scNo=handleNullString(ComGetEtcData(sXml, "SC_NO"));
				var rfaNo=handleNullString(ComGetEtcData(sXml, "RFA_NO"));				
				if (bkgNo != "") {
					//3-1. check  S/C No. and  RFA No. about information of BKG No or B/L No ============		
					if (ComGetObjValue(formObj.scNo) != "" && scNo != ComGetObjValue(formObj.scNo)) {
						ComSetObjValue(formObj.result, "N");
						// inform error position ( check SC No.)
						ComSetObjValue(formObj.result2, "SC");
						return;
					}
					else if (ComGetObjValue(formObj.rfaNo) != "" && rfaNo != ComGetObjValue(formObj.rfaNo)) {
						ComSetObjValue(formObj.result, "N");
						//inform error position ( check RFA No.)
						ComSetObjValue(formObj.result2, "RFA");
						return;
					}
					else if (ComGetObjValue(formObj.scNo) != "" && ComGetObjValue(formObj.rfaNo) != "") {
						ComSetObjValue(formObj.scNo)=scNo;
						ComSetObjValue(formObj.rfaNo)=rfaNo;
					}
					//==================================================================================================
					ComSetObjValue(formObj.result, "Y");
					ComSetObjValue(formObj.result2, "");
					//3-2.Resetting by Retrieving results
					with(sheetObj) {
						SetCellValue(GetSelectRow(), BKG_NO,bkgNo,0);
						SetCellValue(GetSelectRow(), BL_NO,blNo,0);
					}
				}
				else {
					ComSetObjValue(formObj.result, "N");
					//inform error position( if there is no BKG No.or B/L No.,then setting blank)
					ComSetObjValue(formObj.result2, "");	
				}
			break;
			
      		// Search Booking Data by BKG No.or B/L No. 
	       	case IBSEARCH_BKG:
	       		//1.Setting parametor condition, before retrieving
	   			ComSetObjValue(formObj.f_cmd, SEARCH02);
					//2.retrievie according to conditions
	   			//*********************************************************************************
	   			ComOpenWait(true);
	   			sheetObj.SetWaitImageVisible(0);
	   			//*********************************************************************************
   				var sXml=sheetObj.GetSearchData("EES_DMT_2008GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				var frmSCNo=ComTrim(ComGetObjValue(formObj.scNo));
				var frmRFANo=ComTrim(ComGetObjValue(formObj.rfaNo));
				var svrSCNo=handleNullString(ComGetEtcData(sXml, "SC_NO"));
				var srvRFANo=handleNullString(ComGetEtcData(sXml, "RFA_NO"));	
				with(sheetObj) {
					var iRow=GetSelectRow();
					if ((frmSCNo != "" && frmSCNo != svrSCNo) || (frmRFANo != "" && frmRFANo != srvRFANo)) {
						//3-1.Showing alert message when unmatched inputed  S/C or RFA No. and  S/C or RFA No.of conditons.
						ComShowCodeMessage("DMT00159", GetCellValue(iRow, "Seq"));
						SetCellValue(iRow, BKG_NO,"",0);
						SetCellValue(iRow, BL_NO,"",0);
						ComSetObjValue(formObj.result, 	"N");
						return;						
					}
					else {
						// setting Billable Amount per CNTR by result
						if (frmSCNo == "" && frmRFANo == "") {
							ComSetObjValue(formObj.scNo, 	svrSCNo);
							ComSetObjValue(formObj.rfaNo, 	srvRFANo);
							ComSetObjValue(formObj.custCd, 	handleNullString(ComGetEtcData(sXml, "CUST_CD")));
							ComSetObjValue(formObj.custNm, 	handleNullString(ComGetEtcData(sXml, "CUST_NM")));
						}
						SetCellValue(iRow, BKG_NO,  handleNullString(ComGetEtcData(sXml, "BKG_NO")), 0);
						SetCellValue(iRow, BL_NO,   handleNullString(ComGetEtcData(sXml, "BL_NO")),  0);
						SetCellValue(iRow, TVVD,    handleNullString(ComGetEtcData(sXml, "TVVD")),   0);
						SetCellValue(iRow, POR,     handleNullString(ComGetEtcData(sXml, "POR")),    0);
						SetCellValue(iRow, POL,     handleNullString(ComGetEtcData(sXml, "POL")),    0);
						SetCellValue(iRow, POD,     handleNullString(ComGetEtcData(sXml, "POD")),    0);
						SetCellValue(iRow, DEL,     handleNullString(ComGetEtcData(sXml, "DEL")),    0);
						SetCellValue(iRow, RD,      handleNullString(ComGetEtcData(sXml, "RD")),     0);
						SetCellValue(iRow, DG_FLG,  handleNullString(ComGetEtcData(sXml, "DG_FLG")), 0);
						SetCellValue(iRow, RF_FLG,  handleNullString(ComGetEtcData(sXml, "RF_FLG")), 0);
						SetCellValue(iRow, AK_FLG,  handleNullString(ComGetEtcData(sXml, "AK_FLG")), 0);
						SetCellValue(iRow, BB_FLG,  handleNullString(ComGetEtcData(sXml, "BB_FLG")), 0);
						SetCellValue(iRow, RD_FLG,  handleNullString(ComGetEtcData(sXml, "RD_FLG")), 0);
						SetCellValue(iRow, SOC_FLG, handleNullString(ComGetEtcData(sXml, "SOC_FLG")),0);
						SetCellValue(iRow, CMDT_CD, handleNullString(ComGetEtcData(sXml, "CMDT_CD")),0);
						SetCellValue(iRow, CMDT_NM, handleNullString(ComGetEtcData(sXml, "CMDT_NM")),0);
						ComSetObjValue(formObj.result, "Y");
					}
				}
	       	break;
	       	
	       	//Rretrieving Billable Amount per CNTR 
	       	case IBSEARCH_CNTRCHG_BKG:
	       		var sheetBKGObj=sheetObjects[0];
	       		//1.Setting parametor condition, before retrieving
	       		with(sheetBKGObj) {
	       			var iRow=GetSelectRow();
	    			ComSetObjValue(formObj.f_cmd, 			 SEARCH01);
					ComSetObjValue(formObj.pod, 			 GetCellValue(iRow, POD));
					ComSetObjValue(formObj.pol, 			 GetCellValue(iRow, POL));
					ComSetObjValue(formObj.del, 			 GetCellValue(iRow, DEL));
					ComSetObjValue(formObj.por, 			 GetCellValue(iRow, POR));
					ComSetObjValue(formObj.tariff, 			 GetCellValue(iRow, TARIFF));
					ComSetObjValue(formObj.bkg_no, 			 GetCellValue(iRow, BKG_NO));
					ComSetObjValue(formObj.is_cntr, 		 GetCellValue(iRow, CNTR_FLG));
					ComSetObjValue(formObj.aft_expt_dar_no,  GetCellValue(iRow, DAR_NO));
					ComSetObjValue(formObj.aft_expt_adj_seq, GetCellValue(iRow, ADJ_SEQ));
	       		}
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml = sheetObj.GetSearchData("EES_DMT_2008GS.do ", FormQueryString(formObj));

				//3.Result mapping in each Grid, after retrieving 
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1,Append:1});
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3-1. if result of Container information doesn't register After Booking, Setting default KEY value.(case in AS-IS data)
				setSequenceBKGContainer();
				//3-2.Setting flag , check Charge Container existing .
				if (fetchChargeRowCount() > 0) {
					//Seq No. set serially.
					setCNTRSeq();
					//After Exception Container Seq. set serially.
					setAfterBookingCNTRSeq();
					//existing Container item :  EACH_CNTR_FLG = 'Y' 
					sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), CNTR_FLG, "Y");
					//existing Container item: CNTR is activating ===============================
					sheetBKGObj.SetCellEditable(sheetBKGObj.GetSelectRow(), CNTR_TP, isEnableGrid());
					//====================================================================================================
					//D/C AMT or Ratio Pre Cal., Reset button activating  ========================================
					ComBtnEnable("btn_PreCalc");
					ComBtnEnable("btn_Reset");
					//====================================================================================================
				}
				else {
					//not existing Container item: CEACH_CNTR_FLG = 'N'
					sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), CNTR_FLG, "N");
					
					//not existing Container item:  CNTR set 'All' auto, and deactivating===========
					sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(),   CNTR_TP, "S", 0);
					sheetBKGObj.SetCellEditable(sheetBKGObj.GetSelectRow(), CNTR_TP, 0);
					//====================================================================================================
					
					//D/C AMT or Ratio Pre Cal., Reset button deactivating======================================
					ComBtnDisable("btn_PreCalc");
					ComBtnDisable("btn_Reset");
					//====================================================================================================
				}
				//3-3.setting Quantity
				ComSetObjValue(formObj.cntrQty, getChargeQuantity());

				//3-4.setting  Cur. (first row information of Billable Amount per CNTR)
				ComSetObjValue(formObj.curr, getCurrency());
				
				//3-5.Serarch Container Billable Amount  Total
				sumBillableAmount();

				//3-6. Container list by bkg info.and setting in Charge Detail per BKG GRID .
				sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), SRCH_FLG, "Y");	
       		break
       		
	       	//Serarch Comment History.
	       	case IBSEARCH_COMM:
	       		var sheetBKGObj=sheetObjects[0];
	       		var sheetHSTObj=sheetObjects[2];
	       		//1.Setting parametor condition, before retrieving
	       		//  use conditon of searching BKG info.
	       		ComSetObjValue(formObj.f_cmd, SEARCH03);
	       		//2. Clear controls and retrieving results mapping.
	       		sheetHSTObj.RemoveAll();
				//3.retrievie according to conditions
	       		//*********************************************************************************
	       		ComOpenWait(true);
	       		sheetObj.SetWaitImageVisible(0);
	       		//*********************************************************************************
	       		//sheetObj.DoSearch("EES_DMT_2008GS.do", FormQueryString(formObj) );
				var sXml = sheetObj.GetSearchData("EES_DMT_2008GS.do", FormQueryString(formObj));
				
				//4.Queried in the grid allows you to map the results.
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1}); 		
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//5.Settings for Comment History
				formObj.chkComment.checked = false;
				
				with(sheetHSTObj) {
					if (RowCount() > 0) {
						ComSetObjValue(formObj.comment, GetCellValue(HeaderRows(), PROG_RMK));
					}
					else {
						ComSetObjValue(formObj.comment, "");
					}
					//Comment Disabled+++++++++++++++++++++++++++++++++
					//ComEnableObject(formObj.comment, false);
					formObj.comment.readOnly 	= true;
					formObj.comment.className 	= "textarea2";
					//++++++++++++++++++++++++++++++++++++++++++++++++
				}	       		
			break;
			
			// Create new DAR information.
	       	case IBSEARCH_DAR:
				//1.DAR No. Request ago, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.f_cmd, SEARCH07);
				//2.Running modified input conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var result=ComSearchEtcData(sheetObj, "EES_DMT_2008GS.do", FormQueryString(formObj), "DAR");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				ComSetObjValue(formObj.result, result);        		
       		break;
       		
	       	case IBSAVE:        
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, MULTI);
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString();
				var sParam2=sheetObjects[1].GetSaveString();
				if (sheetObjects[0].IsDataModified()== true) {
					sParam1=ComSetPrifix(sParam1, "subBKG");
					sParam=sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified()== true) {
					sParam2=ComSetPrifix(sParam2, "subBKGCNTR");
					sParam=sParam + sParam2 + "&";
				}
				ComSetObjValue(formObj.aft_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"R");
				ComSetObjValue(formObj.apro_ofc_cd, 			ComGetObjValue(formObj.approvalOfcCd));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjValue(formObj.comment));
				sParam += "&" + FormQueryString(formObj);
				//2.Running save
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSaveData("EES_DMT_2008GS.do", sParam);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Save and processing results
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
			
			case IBSAVE_CANCEL:
				//1.Delete all or selected set to the value of the input parameters allows.
				ComSetObjValue(formObj.f_cmd, SEARCH08);
				ComSetObjValue(formObj.aft_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"C");
				if (!formObj.chkComment.checked) {
					ComSetObjValue(formObj.prog_rmk, "");
				}
				else {
					ComSetObjValue(formObj.prog_rmk, ComGetObjText(formObj.comment));
				}
				//2.Delete the selected running conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2008GS.do", FormQueryString(formObj), "TRANS_RESULT_KEY");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After deleting the result handle
				if (sResult == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
       }
   }
   
   
	function initCombo(comboObj, comboNo) {
		var formObj=document.form;
	    switch(comboObj.options.id) {  
	    	case "approvalOfcCd": 
	    		with (comboObj) {
	    			//SetColWidth(0, "100");
					//MultiSelect = false;
	    			SetUseAutoComplete(0);
	    			SetColAlign(0, "left");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
					
					//MaxLength = 6;
			    }
		    break;

	    }
	}
	
	/** doActionIBCombo
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param comboObj
	 * @param formCmd
	 */
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
   	 sheetObj.ShowDebugMsg(false);
   	 sheetObj.SetWaitImageVisible(0);
   	 formObj.f_cmd.value=formCmd;
   	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
   	 switch(formCmd) {
   	 	case COMMAND06:	// RHQ
   	 		with (comboObj) { 
	    	 		RemoveAll();
					SetMultiSelect(0);
					SetColWidth(0, "80");
					ValidChar(2);	
					//MaxLength = 6;
   	 		}
   	 		var data=ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems=data.split("|");
					for (var i=0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
			break;
   	
   	 	}
	}	
   
	//Combo-related functions to retrieve data
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboKey) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
       switch(sAction) {
			//search Tariff Type
			case IBSEARCH:
				//1.Setting parametor condition, before retrieving
				setCommonParameters(sheetObj,sComboAction,sComboKey);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				//3.After processing query results
				switch(sComboAction) {
					//3-1.Tariff retrieving(all Tariff list)
					case SEARCHLIST:
						var comboDatas=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", FormQueryString(formObj), "common_tariff_cd");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false,"");
					break;
					
					//3-2.Tariff and selected BKG No. Or BL No. Local Currency in the corresponding information is Viewed.
					case COMMAND05:
						var comboDatas=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", FormQueryString(formObj), "CURRENCY");
						//After Booking DAR set of data allows for Currency.
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						//Charge Detail per BKG set of data allows for Currency.
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
					break;						
				};
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				break;
       }
		sheetObj.SetWaitImageVisible(1);
   }

	//business javascript OnKeyPress event handling
	function obj_keypress() {
		var formObj=document.form;
		switch(event.srcElement.dataformat){
			case "engup":
				// upper case + numbers 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
         	case "engup2":
		    	// upper case + numbers + exceptional letters
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup3":
         		// change upper case
         		DmtComKeyOnlyAlphabet('upperall')
         		break; 		        
         	case "int":
    	        //only numbers
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
		}
		//DAR viewed as an option to select an item and enter data in a particular field, the entered value of other fields makes Clear.
		clearNoSelectConditionFields();
	}
   /**
    * Select the combo in our grid allows data in the field.
    */		
	function setCellComboItem(sheetObj,comboDatas,sComboKey) {
		var sRow=sheetObj.GetSelectRow();
		var sVal="";
		if (comboDatas != undefined) {
			var comboItem=comboDatas.split(FIELDMARK);
			sVal=comboItem[0];
		}
		sheetObj.SetCellValue(sRow, sComboKey,sVal);
	}
   /**
    *  grid data in the field adds a combo.
    */		
	function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
		var comboTxt="";
		var comboVal="";
		var comboItems;
		var comboItem;
		var comboInitTxt="";
		var comboInitVal="";
		var sRow=sheetObj.GetSelectRow();
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems=comboDatas.split(ROWMARK);
			for (var i=0 ; i < comboItems.length ; i++) {
				comboItem=comboItems[i].split(FIELDMARK);
				//If you burn InitDataCombo method if you do not select a value
				//Code, Value appears in the combo letter seeks to avoid being pushed.
				if (!isCellCombo && i == 0) {
					comboInitTxt=comboItem[0];
					comboInitVal=comboItem[0];
				}
				if (ComTrim(comboItem[0]) != "") {
					//in case of showing only Text
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					}
					//in case of getting Text with '^' as delimiter
					else if (comboItem[1].indexOf("\^") != -1) {
						comboTxt += comboItem[1].replace("^", " - ");
					}
					//in case of showing both Text and Code
					else {
						comboTxt += comboItem[0] + "\t" + comboItem[1];
					}
					comboVal += comboItem[0];
				}
				else {
					comboTxt += " \t ";
					comboVal += " ";
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		else {
			comboTxt += " \t ";
			comboVal += " ";			
		}
		var colName=sComboKey;
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName, {ComboText:comboTxt, ComboCode:comboVal} );
		} else {
			sheetObj.SetColProperty(colName, {ComboText:comboTxt, ComboCode:comboVal, DefaultValue:''} );
		}
		
		
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
			ComClearCombo(comboObj);
			comboItems=comboDatas.split(ROWMARK);	
	    	for (var i=0 ; i < comboItems.length ; i++) {
   			comboItem=comboItems[i].split(FIELDMARK);
				val=comboItem[0];
				txt=isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,txt,val);
   		}
		}   		
	}
   /**
    * handling process for input validation
    */
   function validateForm(sheetObj,formObj,sAction) {
		with (sheetObj) {
	 		for (var row=HeaderRows(); row <= LastRow(); row++) {
	 			//Enter or modify data is validated only for.
	 			if (GetRowStatus(row) == "I" || GetRowStatus(row) == "U") {
	 				//1. in case of that there is a required field..
			    	if (ComTrim(form.approvalOfcCd) == "") {
			    	    ComShowCodeMessage("DMT03028", "APVL Office"); 
			    	    return false;
			    	}
			    	else if (GetCellValue(row, BKG_NO) == "") {
			    		ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "BKG No.");
			    		return false;
			    	}
			    	else if (GetCellValue(row, BL_NO) == "") {
			    		ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "B/L No.");
			    		return false;
			    	}
			    	else if (GetCellValue(row, TARIFF) == "") {
			    		ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Tariff");
			    		return false;
			    	}	 				
			    	//check the validity of the bkg data.
			    	if (GetCellValue(row, CNTR_TP) == "S") {
				    	//2.if Free Time or D/C Amount, D/C Ratio input is not one of them,  "Free Time or D/C Amount or  Ratio is mandatory!" Alert blocking window showing
				    	//2-1. change : Free Time checkbox and D/C Amount and Ratio checkbox  are not checked both,  show an error message 
			    		// 										if the value was not entered Changed to appear as if the missing
			    		if (GetCellValue(row, FT_FLG) == 0 && GetCellValue(row, DCAR_FLG) == 0) {
			    			ComShowCodeMessage("DMT02011", GetCellValue(row, "Seq"));
				    		return false;			    			
			    		}
			    		else if (GetCellValue(row, FT_FLG) == 1 && GetCellValue(row, ADD_DYS) == "" && GetCellValue(row, TTL_DYS) == "") {
			    			ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Free Time");
			    			return false;
			    		}
			    		else if (GetCellValue(row, DCAR_FLG) == 1 && GetCellValue(row, DCAR_AMT) == "" && GetCellValue(row, DCAR_RTO) == "") {
			    			ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "D/C Amount or Ratio");
			    			return false;
			    		}
			    		//2-2.D/C Amount or Ratio input Cur. Select the required(AMT input Cur. The input conditions required, Ratio in the Cur. Unnecessary)
			    		if (GetCellValue(row, DCAR_FLG) == 1 && GetCellValue(row, DCAR_CURR) == "" && GetCellValue(row, DCAR_AMT) != "") {
			    			ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "CUR");
			    			return false;			    			
			    		}
				    	//3.Add Day and Total in Free Time, if both "Only one of Add day or Total day can be input" Alert Window showing blocking
			    		if (GetCellValue(row, ADD_DYS) != "" && GetCellValue(row, TTL_DYS) != "") {
			    			ComShowCodeMessage("DMT02004", GetCellValue(row, "Seq"));
				    		return false;
				    	}
				    	//4.D/C Amount or Ratio is entered in the case both "Only one of D/C Amount or Ratio can be input" Alert Window showing blocking
			    		if (GetCellValue(row, DCAR_AMT) != "" && GetCellValue(row, DCAR_RTO) != "") {
			    			ComShowCodeMessage("DMT02012", GetCellValue(row, "Seq"));
				    		return false;
				    	}
			    	}
			    	// Check the validity of Billable Amount per CNTR all of the data.
			    	else {
			    		if (!validateChargeContainer(row)) {
			    			return false;
			    		}
			    	}
			    	//5.That BKG and B/L No. Tariff Type of the Calculation Type is not correct. "Calculation Type discrepancy! [Location Code] - [Dual]" Alert Window showing blocking
			    	//  ([Location Code], the DMIF, DMOF In the case of From yard, DTIC / CTIC in the case of BKG DEL, DTOC / CTOC, the Location of the bloodstream when the BKG POR.
			    	//  [Dual] or [Combined] is a notation)
			    	if (!checkCalcuationType(sheetObj,formObj)) {
			    		if (ComGetObjValue(formObj.result3) == "C") {
			    			ComShowCodeMessage("DMT00132", GetCellValue(row, "Seq"), ComGetObjValue(formObj.result2));
			    		}
			    		else if (ComGetObjValue(formObj.result3) == "D") {
			    			ComShowCodeMessage("DMT02003", GetCellValue(row, "Seq"), ComGetObjValue(formObj.result2));
			    		}
			    		return false;
			    	}
			    	//6.If Tariff Type and BKG or B/L No. are duplicated , Alert window showing and blocking
			    	//   checking duplication : there is not DAR No in the lookup column. (case in new inserting)
			    	//  set parameters for checking duplication
					ComSetObjValue(formObj.bkg_no, GetCellValue(row, BKG_NO));
					ComSetObjValue(formObj.bl_no, GetCellValue(row, BL_NO));
					ComSetObjValue(formObj.tariff, GetCellValue(row, TARIFF));
			    	if (ComTrim(ComGetObjValue(formObj.darNo)) == "") {
				    	if (checkDupTariffBKGBLNo(sheetObj,formObj)) {
				    		ComShowCodeMessage("DMT02013", GetCellValue(row, "Seq"), ComGetObjValue(formObj.result2));
				    		return false;
				    	}
			    	}
	 			}
	 		}
		}
		//7.Check the logic adds redundant data
		if (!dupValidate(sheetObj)) return false;
		//8.Comment input letter length Check
		// Comment is required in case of Request!
		if (!validateComment()) return false;
		return true;
   }
  	/**
  	 *  Check  Free Time and D/C Amount or Ratio of bkg Container information input to perform the essential functions
  	 */	    
    function validateChargeContainer(selectedRow) {
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1];
    	with(sheetBKGObj) {
			var adjSeq=GetCellValue(selectedRow, ADJ_SEQ);
			var seqNo=GetCellValue(selectedRow, "Seq");
    		//Charge information screen, if loaded, ie, Charge information does not provide Validation has not been changed.
			if (GetCellValue(selectedRow, SRCH_FLG) != "Y") return true;
    	}
    	var isCheckCnt=0;
    	//Charge a minimum of 1 or later is input validation skip
    	with(sheetCNTRObj) {
    		for (var row=HeaderRows(); row <= LastRow(); row++) {
    			if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
    				if (GetCellValue(row, FT_FLG) == "1") {
    					if (GetCellValue(row, ADD_DYS) == "" && GetCellValue(row, TTL_DYS) == "") {
    						ComShowCodeMessage("DMT00108", seqNo, "Free Time");
    						return false;    
    					}
    					else if (GetCellValue(row, ADD_DYS) != "" && GetCellValue(row, TTL_DYS) != "") {
				    		ComShowCodeMessage("DMT02004", seqNo);
				    		return false;    						
    					}
  						isCheckCnt++;
    				}
					if (GetCellValue(row, AR_FLG) == "1") {
    					// case in inputting D/C Amount or Ratio , Cur. is mandatory item(but case in Ratio,  Cur.is optional item)
						if (GetCellValue(row, DCAR_CURR) == "" && GetCellValue(row, AR_AMT) != "") {
    						ComShowCodeMessage("DMT00108", seqNo, "CUR");
    						return false;     						
    					}
						else if (GetCellValue(row, AR_AMT) == "" && GetCellValue(row, AR_RTO) == "") {
    						ComShowCodeMessage("DMT00108", seqNo, "D/C Amount or Ratio");
    						return false;
    					}
						else if (GetCellValue(row, AR_AMT) != "" && GetCellValue(row, AR_RTO) != "") {
    			    		ComShowCodeMessage("DMT02012", seqNo);
				    		return false;    						
    					}
  						isCheckCnt++;
    				}
    			}
    		}
    		if (isCheckCnt == 0) {
	    		ComShowCodeMessage("DMT02011", seqNo);
    			return false;
    		}
    	}
    	return true;
    }
 	/**
 	 *  Duplicate Tariff, BKG No., B/L No. With a function that checks whether the data is
 	 */	  	 
  	function dupValidate(sheetObj) {
  		with(sheetObj) {
	  		var dupRows = ColValueDupRows(TARIFF + "|" + BKG_NO + "|" + BL_NO);
	  		if (dupRows != "") {
	    		var dupArrRow=dupRows.split(",");
	    		ComShowCodeMessage('DMT00161', GetCellValue(dupArrRow[0], "Seq"));
				SetSelectRow(dupArrRow[0]);
	        	return false;
			}
  		}
  		return true;
  	}
	/**
	 * That BKG No. Or B/L No. Tariff Type of function to check the correct Calculation Type
	 */	
   function checkCalcuationType(sheetObj, formObj) {
   	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_CALC);
   	return ComGetObjValue(formObj.result) == "Y" ? true : false; 
   }
 	/**
	 *  BKG No. Or B/L No. Charge before loading when entering sensitive information, BKG, B/L No. Check if the function
	 */	
   function checkTariffBKGBLNo(sheetObj, formObj) {
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_BKGNO);
    	return ComGetObjValue(formObj.result) == "Y" ? true : false;
   }
	/**
	 *  Tariff Type and BKG or B/L No. Duplication of functions to check whether
	 */	
   function checkDupTariffBKGBLNo(sheetObj, formObj) {
   	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_DUP);
   	return ComGetObjValue(formObj.result) == "Y" ? true : false;
   }
	/**
	 *  Balance Charge function to check for the existence of the CNTR info.
	 */	
   function checkBalanceCharge(sheetObj, formObj) {
   	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_BALCHG);
   	return ComGetObjValue(formObj.result) == "Y" ? true : false;
   }
	/**
	 * When changes occur in Sheet1 function that is called
	 */	    
   function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj=document.form;
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				//1.BKG No. If the BKG has been changed to look up information.
				case BKG_NO:
					//1-1.If the input BKG_NO B/L No. To query.
					if (ComTrim(GetCellValue(GetSelectRow(), BKG_NO)) == "") return;
					if (!checkBKGBLNo(BKG_NO)) return;
					//1-2.Tariff has not been entered, the query does not perform.
					if (ComTrim(GetCellValue(GetSelectRow(), TARIFF)) == "") return;
					//1-3.Tariff and BKG No. Charge Detail information corresponding to the query should be executed.
					searchContainerByTariffBKGNo();
				break;
				
				//2.BKG No. If the BKG has been changed to look up information.
				case BL_NO:
					//2-1. If input B/L No, search BKG No.
					if (ComTrim(GetCellValue(GetSelectRow(), BL_NO)) == "") return;
					if (!checkBKGBLNo(BL_NO)) return;
					//2-2. if doesn't input Tariff, not search.
					if (ComTrim(GetCellValue(GetSelectRow(), TARIFF)) == "") return;
					//2-3.Search Charge Detail information of Tariff and  BKG No.
					searchContainerByTariffBKGNo();
				break;
				
				//3. case in changing Tariff , search BKG information.
				case TARIFF:
					//3-1. if selected Tariff is Blank , then do not search.
					if (ComTrim(GetCellValue(GetSelectRow(), TARIFF)) == "") return;
					//3-2.if  BKG No, B/L No does not input, then do not search.
					if (ComTrim(GetCellValue(GetSelectRow(), BKG_NO)) == "" && ComTrim(GetCellValue(GetSelectRow(), BL_NO)) == "") return;
					//3-3.Search Charge Detail information of Tariff and  BKG No.
					searchContainerByTariffBKGNo();
				break;
				
				//case in changing Diff of Free Time  to Different , Free Time of  Billable Amount per CNTR change activating.
				case CNTR_TP:
					modifyModeFreeTimeAmountorRatio(true);
				break;
				
				//Free Time Y, if the check or disarmed
				case FT_FLG:
					if (Value == 1) {
						editableFreeTime(Row, true);
					}
					else {
						editableFreeTime(Row, false);
					}
				break;
				
				//D/C Amount or Ratio Y  if the check or disarmed
				case DCAR_FLG:
					if (Value == 1) {
						editableDCAmountRatio(Row, true);
					}
					else {
						editableDCAmountRatio(Row, false);
					}
				break;
			}
		}
	}
  /**
	* Align the current selection state of ROW has been chosen to handle it functions to maintain
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (currAdjSeq == GetCellValue(row, ADJ_SEQ)) {
					SetSelectRow(row);
					break;
				}
			}
		}
	}
	/**
	 *  When BKG Row is selected , Row by Conditions change status.
	 */	
	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol,isDelete) {
		var formObj=document.form;
		var sheetCNTRObj=sheetObjects[1];
		//This function is invoked through the ROW COPY If you do not perform the following logic.
		if (isDataCopy) return;
		//whenever selected Row change in row position to perform the following logic.
		with(sheetObj) {
			
			if (OldRow >= HeaderRows() && OldRow != NewRow) {
				//-------------------------------------------
				
				currAdjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
				//-------------------------------------------

				if (GetRowStatus(NewRow) != "D") {
					displayChargeDetailperBKG(NewRow)
				}
			}
		}
	}
	/**
	 * In Sheet2 function that is invoked when a change occurs
	 */	    
   function sheet2_OnChange(sheetObj,Row,Col,Value) {
		var formObj=document.form;
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				//Free Time check box "Y",  if the check or unchecked
				case FT_FLG:
					if (Value == 1) {
						editableCNTRFreeTime(Row, true);
					}
					else {
						editableCNTRFreeTime(Row, false);
					}
				break;
				
				//D/C Amount or Ratio Y , if the check or unchecked
				case AR_FLG:
					if (Value == 1) {
						editableCNTRDCAmountRatio(Row, true);
					}
					else {
						editableCNTRDCAmountRatio(Row, false);
					}
				break;
				
				case DCAR_CURR:
					changeCurrencyAltogther(Row);					
				break;
			}
		}
	}	 
	/**
	 * Comment History of the Row that is selected shows a Comment.
	 */	
	function sheet3_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj=document.form;
		//whenever selected Row change in row position to perform the following logic.
		if (OldRow >= sheetObj.HeaderRows() && OldRow != NewRow) {
			if (!formObj.chkComment.checked) {
				ComSetObjValue(formObj.comment, sheetObj.GetCellValue(NewRow, PROG_RMK));
			}
		}		
	}
  /**
	*   Function that search Charge Detail of After Booking DAR wheen Tariff or BKG No. change in the applicable 
	*/	 	
	function searchContainerByTariffBKGNo() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		var tariff="";
		var cntCd="";
		with(sheetBKGObj) {
			tariff=GetCellValue(GetSelectRow(), TARIFF);
			//1-1. set the parameters for Calculation Type Checking.
			ComSetObjValue(formObj.bkg_no, 	GetCellValue(GetSelectRow(), BKG_NO));
			ComSetObjValue(formObj.bl_no, 	GetCellValue(GetSelectRow(), BL_NO));
			ComSetObjValue(formObj.tariff, 	GetCellValue(GetSelectRow(), TARIFF));
			//1-2.Check Calculation Type of Tariff Type by BKG No
	    	if (!checkCalcuationType(sheetBKGObj,formObj)) {
	    		if (ComGetObjValue(formObj.result3) == "C") {
	    			ComShowCodeMessage("DMT00132", GetCellValue(GetSelectRow(), "Seq"), ComGetObjValue(formObj.result2));
	    		}
	    		else if (ComGetObjValue(formObj.result3) == "D") {
	    			ComShowCodeMessage("DMT02003", GetCellValue(GetSelectRow(), "Seq"), ComGetObjValue(formObj.result2));
	    		}
	    		SetCellValue(GetSelectRow(), TARIFF, "", 0);
	    		return false;
	    	}
			//1-3. Check duplication Tariff Type and BKG 
	    	if (checkDupTariffBKGBLNo(sheetBKGObj,formObj)) {
	    		ComShowCodeMessage("DMT00155", GetCellValue(GetSelectRow(), "Seq"), ComGetObjValue(formObj.result2));
	    		SetCellValue(GetSelectRow(), TARIFF, "", 0);
	    		return false;
	    	}
		}
		//1-4. Search Booking Data by inputed BKG No.
		doActionIBSheet(sheetBKGObj,formObj,IBSEARCH_BKG);
		// not exist result (by BKG No., B/L No.)
		if (ComGetObjValue(formObj.result) == "N") return;
	   	//1-5. Search Charge Detail per BKG Data by inputed BKG No. 
	   	//    decide before Searching Charge Detail per BKG from  After Booking or Charge Calculation
	   	//   (in this case from  Charge Calculation)
   		ComSetObjValue(formObj.is_aft_bkg_cntr, "N");
		doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);
		//1-6. if all CNTR information A/R interface done , then  show Alert window and request confrim.
		if (checkARIFAllContainer()) {
			if (!ComShowCodeConfirm("DMT00167")) {
				//delete all Booking and Booking Charge information.
				removeBookingChargeData();
				return;
			}
		}
   	//1-7. after searching , BKG No., B/LL No., Tariff  change to deactivating(disabled) 
	disableKeyColumn(sheetBKGObj.GetSelectRow());
   	//1-8.search Currency.
   	with(sheetBKGObj) {
			switch(tariff) {
				case "DMIF": 
					cntCd=GetCellValue(GetSelectRow(), POD).substring(0, 2);	
				break;
				
				case "DMOF": 
					cntCd=GetCellValue(GetSelectRow(), POL).substring(0, 2);
				break;
				
				case "DTIC":
				case "CTIC":
					cntCd=GetCellValue(GetSelectRow(), DEL).substring(0, 2);
				break;
				
				case "DTOC":
				case "CTOC":
					cntCd=GetCellValue(GetSelectRow(), POR).substring(0, 2);
				break;
			}
   		}
   		ComSetObjValue(formObj.cnt_cd, cntCd);
  		doActionIBCommon(sheetBKGObj,formObj,IBSEARCH,COMMAND05,DCAR_CURR);
		//1-9. Depending on CNTR information,  Free Time, F/Time EXCL, D/C Amount or Ratio change to activating or deactivating 
  		//    (Argument indicates whether to delete the value)
		modifyModeFreeTimeAmountorRatio(false);     		
	}
	/**
	 * Depending on Free Time check box' value , every relatived items' status change to activating
	 */
	function editableFreeTime(row, flg) {
		var sheetBKGObj=sheetObjects[0];
		with(sheetBKGObj) {
			if (!flg) {
				SetCellValue(row, ADD_DYS,"");
				SetCellValue(row, TTL_DYS,"");
				SetCellValue(row, SAT_FLG,0);
				SetCellValue(row, SUN_FLG,0);
				SetCellValue(row, HOL_FLG,0);
			}
			// case in Grid's status is activating, field's edit property can use 
			if (isEnableGrid()) {
				SetCellEditable(row, ADD_DYS,flg);
				SetCellEditable(row, TTL_DYS,flg);
				SetCellEditable(row, SAT_FLG,flg);
				SetCellEditable(row, SUN_FLG,flg);
				SetCellEditable(row, HOL_FLG,flg);
			}
		}
	}
	/**
	 *  Depending on  Free Time  check box of Billable Amount per CNTR  is checked or not checked, every relatived items' status change to activating
	 */
	function editableCNTRFreeTime(row, flg) {
		var sheetCNTRObj=sheetObjects[1];
		with(sheetCNTRObj) {
			if (!flg) {
				SetCellValue(row, ADD_DYS,"");
				SetCellValue(row, TTL_DYS,"");
				SetCellValue(row, SAT_FLG,0);
				SetCellValue(row, SUN_FLG,0);
				SetCellValue(row, HOL_FLG,0);
			}
			//case in Grid's status is activating, field's edit property can use 
			if (isEnableGrid()) {
				SetCellEditable(row, ADD_DYS,flg);
				SetCellEditable(row, TTL_DYS,flg);
				SetCellEditable(row, SAT_FLG,flg);
				SetCellEditable(row, SUN_FLG,flg);
				SetCellEditable(row, HOL_FLG,flg);
			}
		}
	}
	/**
	 * Depending on  D/C Amount or Ratio  check box is checked or not checked, every relatived items' status change to activating
	 */
	function editableDCAmountRatio(row, flg) {
		var sheetBKGObj=sheetObjects[0];
		with(sheetBKGObj) {	
			if (!flg) {
				SetCellValue(row, DCAR_CURR,"",0);
				SetCellValue(row, DCAR_AMT,"",0);
				SetCellValue(row, DCAR_RTO,"",0);
			}
			//case in Grid's status is activating, field's edit property can use 
			if (isEnableGrid()) {
				SetCellEditable(row, DCAR_CURR,flg);
				SetCellEditable(row, DCAR_AMT,flg);
				SetCellEditable(row, DCAR_RTO,flg);
			}
		}			
	}
	/**
	 * Depending on  D/C Amount or Ratio  check box is checked or not checked, every relatived items' status change to activating
	 */
	function editableCNTRDCAmountRatio(row, flg) {
		var sheetCNTRObj=sheetObjects[1];
		with(sheetCNTRObj) {	
			if (!flg) {
				SetCellValue(row, DCAR_CURR,"",0);
				SetCellValue(row, AR_AMT,"",0);
				SetCellValue(row, AR_RTO,"",0);
			}
			//case in Grid's status is activating, field's edit property can use 
			if (isEnableGrid()) {
				SetCellEditable(row, DCAR_CURR,flg);
				SetCellEditable(row, AR_AMT,flg);
				SetCellEditable(row, AR_RTO,flg);
			}
			// if there is checked row's Currency value,  all checked rows filled same  Currency .
			if (flg) {
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					if (row != GetSelectRow()&& GetRowStatus(row) != "D" && GetCellValue(row, DCAR_CURR) != "") {
						SetCellValue(GetSelectRow(), DCAR_CURR,GetCellValue(row, DCAR_CURR),0);
						break;
					}
				}
			}
		}			
	}
	/**
	 *  Select the value of the data according to BKG CNTR CNTR part of the data columns to show or hide much of the functions which operate
	 */	
	function hideContainerColumn(flg) {
		var sheetCNTRObj=sheetObjects[1];
		with(sheetCNTRObj) {
			
			if(GetColHidden(FT_FLG) != flg) SetColHidden(FT_FLG,flg);
			if(GetColHidden(ADD_DYS) != flg) SetColHidden(ADD_DYS,flg);
			if(GetColHidden(TTL_DYS) != flg) SetColHidden(TTL_DYS,flg);
			if(GetColHidden(SAT_FLG) != flg) SetColHidden(SAT_FLG,flg);
			if(GetColHidden(SUN_FLG) != flg) SetColHidden(SUN_FLG,flg);
			if(GetColHidden(HOL_FLG) != flg) SetColHidden(HOL_FLG,flg);
			if(GetColHidden(AR_FLG) != flg) SetColHidden(AR_FLG,flg);
			if(GetColHidden(DCAR_CURR) != flg) SetColHidden(DCAR_CURR,flg);
			if(GetColHidden(AR_AMT) != flg) SetColHidden(AR_AMT,flg);
			if(GetColHidden(AR_RTO) != flg) SetColHidden(AR_RTO,flg);
			if(GetColHidden(AR_RTO2) != flg) SetColHidden(AR_RTO2,flg);
			
			// GB 컬럼의 위치를 재설정하는 코드는 위에 ColHidden 맨 마지막에 나타나야 함.
			if(!flg) SetColWidth(GB, 30);
		}
	}
	/**
	 * Select the value of the data according to BKG CNTR CNTR column's data is erased some of the data functions that operate
	 */		 
	function clearContainerColumn(row) {
		var sheetBKGObj=sheetObjects[0];		
		var sheetCNTRObj=sheetObjects[1];
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		with(sheetCNTRObj) {		
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (adjSeq == GetCellValue(row, ADJ_SEQ)) {
				SetCellValue(row, FT_FLG,0);
				SetCellValue(row, ADD_DYS,"");
				SetCellValue(row, TTL_DYS,"");
				SetCellValue(row, SAT_FLG,0);
				SetCellValue(row, SUN_FLG,0);
				SetCellValue(row, HOL_FLG,0);
				SetCellValue(row, AR_FLG,0);
				SetCellValue(row, AR_AMT,"");
				SetCellValue(row, AR_RTO,"");
				}
			}
		}
	}
	/**
	 *  Select the value of the data according to all BKG CNTR data , 
	 *  "Free Time"'s check box and "Amount or Ratio" 'check box  do checked
	 */		 
	function checkContainerColumn(selectRow) {
		var sheetBKGObj=sheetObjects[0];		
		var sheetCNTRObj=sheetObjects[1];
		var adjSeq=sheetBKGObj.GetCellValue(selectRow, ADJ_SEQ);
		with(sheetCNTRObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (adjSeq == GetCellValue(row, ADJ_SEQ)) {
					// if G/B = "Balance" , then Free Time, F/Time EXCL, D/C Amount or Ratio are can not input
					if (GetCellValue(row, GB) == "B") {
						// to be unchecked (initializing)					
						SetCellValue(row, FT_FLG,0);
						SetCellValue(row, AR_FLG,0);
						// colunm status is deactivating.
						SetCellEditable(row, FT_FLG,0);
						SetCellEditable(row, AR_FLG,0);
						editableCNTRFreeTime(row, false);
						editableCNTRDCAmountRatio(row, false);	
					}
				}
			}
		}
	}
	
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	var formObj=document.form;
        var iCol=sheetObj.SaveNameCol(DCAR_RTO2);
        sheetObj.SetRangeText("%", 2, iCol, sheetObj.LastRow(), iCol);
    }
    
	function sheet2_OnSearchEnd(sheetObj, code, ErrMsg) {
    	var formObj=document.form;
        var iCol=sheetObj.SaveNameCol(AR_RTO2);
        sheetObj.SetRangeText("%", 2, iCol, sheetObj.LastRow(), iCol);
	}
	
	/**
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setCommonParameters(sheetObj,sAction,sComboKey) {
		var formObj=document.form;
		ComSetObjValue(formObj.f_cmd, sAction);			//Command
	}
	
  /**
   *  if Row Add button is clicked,  function that defines the behavior of running
   */		
   function doActionAddADJAfterBKG() {
   	var formObj=document.form;
   	var sheetBKGObj=sheetObjects[0];
   	//When you add data, sheet1_OnSelect function is invoked automatically, , in this case, BKG DAR information for the CNTR CNTR GRID and adding it to re-query problem
   	// which to solve this problem, the following variables are set to TRUE.
   	isDataCopy=true;
   	with(sheetBKGObj) {
   		DataInsert(-1);
   		//Queried if the state is to add in the ROW DAR No. And adds.
if (LastRow()> HeaderRows()&& GetCellValue(HeaderRows(), DAR_NO) != "") {
SetCellValue(LastRow(), DAR_NO,GetCellValue(HeaderRows(), DAR_NO));
   		}
   		//set Tariff to default value(Empty).
   		//add blank (Default is blank, selected User).
SetCellValue(LastRow(), TARIFF,"");
   		//set CUR to blank.
SetCellValue(LastRow(), DCAR_CURR,"");
   		//Ratio item add '%' .
SetCellValue(LastRow(), DCAR_RTO2,"%");
   		//Billable Amount per CNTR lookup query to store the value that the state flag
SetCellValue(LastRow(), SRCH_FLG,"N");
   		//add ADJ_SEQ.
SetCellValue(LastRow(), ADJ_SEQ,fetchNextADJSeq());
   	}
   	isDataCopy=false;
   	//Charge Detail per BKG copied row of data processing, so no data is not to show.
   	showBillableAmountPerCNTR(); 
   	//BKG due to changes in the selected row of Charge Detail per BKG CNTR Q'ty, Cur., Total Billable AMT data gives clear.
   	clearChargeDetailTopInfo();
    	// calculated column' color Restore to origin color
    	changeCalcColumn(false);
    	//Additional Charge Detail per BKG at Row because no data is D/C AMT or Ratio Pre Cal., Reset button disabled
    	//D/C AMT or Ratio Pre Cal., Reset button disabled ========================================
    	ComBtnDisable("btn_PreCalc");
    	ComBtnDisable("btn_Reset");
    	//====================================================================================================
   }
   /**
    *  when Delete button click,  function that defines the behavior of running
    */		
   function doActionDelADJAfterBKG() {
    	var formObj=document.form;    	
    	var sheetBKGObj=sheetObjects[0];
    	with(sheetBKGObj) {
	    	if (GetSelectRow()>= HeaderRows()) {
				//delete Billable Amount per CNTR info.
				doActionDelADJAfterBKGContainer(GetSelectRow());
				if (GetRowStatus(GetSelectRow()) == 'I') {
					RowDelete(GetSelectRow(), false);
				}
				else {
					SetRowStatus(GetSelectRow(),'D');
					GetRowHidden(SetSelectRow(1));
				}
				//1.after delete row, focus move to next row automatically.
				var row=fetchSelectedNextRow(GetSelectRow());
				//1-1. no row
				if (row != -1) {
					SetSelectRow(row);
					displayChargeDetailperBKG(row);
				}				
		     	//calculated column' color Restore to origin color
		     	changeCalcColumn(false);
		 		// if After Booking infomation delete, then S/C No., RFA No., Customer 's information delete
		 		if (getAfterBKGCount() < 1) {
		 			ComClearObject(formObj.scNo);
		 			ComClearObject(formObj.rfaNo);
		 			ComClearObject(formObj.custCd);
		 			ComClearObject(formObj.custNm);
		 		}				
			}
    	}
   }
  /**
   * if Booking infomation delete, then belongs Container information delete
   */	    
   function doActionDelADJAfterBKGContainer(selectRow) {
	   	var formObj=document.form;
	   	var sheetBKGObj=sheetObjects[0];
	   	var sheetCNTRObj=sheetObjects[1];
	   	var adjSeq=sheetBKGObj.GetCellValue(selectRow, ADJ_SEQ);
	   	//var status=sheetBKGObj.FindStatusRow(selectRow);
		//delete Charge Header
		ComClearObject(formObj.cntrQty);
		ComClearObject(formObj.curr);
		ComClearObject(formObj.totalBillAmt);
		with(sheetCNTRObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
				if (GetRowStatus(row) == "I") {
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
   /**
   * D/C AMT or Ratio Per Cal. button click,  function that defines the behavior of running
   */	    
   function doActionPreCalc() {
   	var formObj=document.form;
   	var sheetBKGObj=sheetObjects[0];
   	var sheetCNTRObj=sheetObjects[1];
   	// if already  clicked, do protect .
   	if (isCalculated()) return;
   	with(sheetBKGObj) {
		var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		var cntrTp=GetCellValue(GetSelectRow(), CNTR_TP);
		var dcArFlg=GetCellValue(GetSelectRow(), DCAR_FLG);
   	}
   	var total=0;
   	var bilAmt="";
   	var disAmt="";
   	var disRto="";
   	// if CNTR is  'All', D/C Amount or Ratio AMT or  Ratio of BKG  copy to Charge Container.
   	if (cntrTp == "S") {
   		copyDCAmountOrRatioToChargeContainer();
   	}
   	with(sheetCNTRObj) {
   		for (var row=HeaderRows(); row <= LastRow(); row++) {
   			if (GetRowStatus(row) != "D" && GetRowHidden(row) == false && adjSeq == GetCellValue(row, ADJ_SEQ)) {
   				// D/C AMT or Ratio Pre Cal. Only for items checked below to perform logic.
   				if (dcArFlg == 1 || GetCellValue(row, AR_FLG) == 1) {
   					if (GetCellValue(row, GB) == "G") {
   						if (GetCellValue(row, AR_AMT) == "" && GetCellValue(row, AR_RTO) == "") {
	    	     				//no data in D/C AMT, Ratio , Alert  "Pls input D/C Amount or Ratio"
	    	     				if (cntrTp == "S") {
	    	     					ComShowCodeMessage("DMT00168", sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), "Seq"));
	    	     					removeDCAmountOrRatioToChargeContainer();
	    	     				}
	    	     				else {
	    	     					ComShowCodeMessage("DMT00168", GetCellValue(row, "Seq"));
	    	     				}
	  	     					return;     						
	    					}
   							else if (GetCellValue(row, AR_AMT) != "" && GetCellValue(row, AR_RTO) != "") {
	    	     				//both D/C AMT, Ratio input, not show Alert
	    	     				if (cntrTp == "S") {
	    	     					ComShowCodeMessage("DMT02012", sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), "Seq"));
	    	     					removeDCAmountOrRatioToChargeContainer();
	    	     				}
	    	     				else {
	    	     					ComShowCodeMessage("DMT02012", GetCellValue(row, "Seq"));
	    	     				}
	  	     					return;     						
	    					}
   							else if (GetCellValue(row, AR_AMT) != "") {
   								disAmt=GetCellValue(row, AR_AMT);
	    						disRto="";
	    					}
   							else if (GetCellValue(row, AR_RTO) != "") {
	    						disAmt="";
	    						disRto=GetCellValue(row, AR_RTO);
	    					}
	    				}
	    				if (disAmt != "") {
	    					bilAmt=GetCellValue(row, BIL_AMT) - disAmt;
	    				}
	    				else if (disRto != "") {
	    					bilAmt=GetCellValue(row, BIL_AMT) - GetCellValue(row, BIL_AMT) * disRto / 100;
	    					bilAmt=ComRound(bilAmt, 2);
	    				}
	    				else {
	    					bilAmt=GetCellValue(row, BIL_AMT);
	    				}
	    				//Billable AMT must be over 0.00. minus amount can not input
	    				bilAmt=bilAmt >= 0 ? bilAmt : 0;
	    				SetCellValue(row, BIL_AMT,bilAmt);
   				}
   				total=total + parseFloat(GetCellValue(row, BIL_AMT));
   			} // if - end
   		} // for - end
   	} // with - end
   	total=ComRound(total, 2);
   	ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
   	//complete Calculation, button and colunm's color "red".
   	changeCalcColumn(true);
   	// if CNTR is  'All', D/C Amount or Ratio AMT or  Ratio of BKG  copy to Charge Container.
   	if (cntrTp == "S") {
   		removeDCAmountOrRatioToChargeContainer();
   	}      	
   }
   /**
    * Reset button click,  function that defines the behavior of running
    */	    
    function doActionReset() {
    	var formObj=document.form;
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1]
		var bkgNo=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), BKG_NO);
		var tariff=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), TARIFF);
    	var total=0;
    	with(sheetCNTRObj) {
    		for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
				    &&	GetRowHidden(row) == false
					&& 	bkgNo == GetCellValue(row, BKG_NO)
					&& 	tariff == GetCellValue(row, TARIFF)	) {
					SetCellValue(row, BIL_AMT,GetCellValue(row, ORG_BIL_AMT));
					total=total + parseFloat(GetCellValue(row, BIL_AMT));
				}
    		}
    	}
    	//set  Total Billable Amount .
    	ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
    	//calculated column' color Restore to origin color
    	changeCalcColumn(false);
    }      
   /**
    * Retrieve button click,  function that defines the behavior of running
    */		
   function doActionRetrieve() {
    	var formObj=document.form;    	 
	   	var sheetBKGObj=sheetObjects[0];
	   	var sheetCNTRObj=sheetObjects[1];
	   	var sheetHSTObj=sheetObjects[2];
	    	//calculated column' color Restore to origin color
	    	changeCalcColumn(false);
	   	// check mandatory item (if there is no DAR No. or APVL No. , Alert "Please enter DAR No. or APVL No.")
	   	with(formObj) {
	   		if (ComTrim(ComGetObjValue(darNo)) == "" && ComTrim(ComGetObjValue(apvlNo)) == "") {
	   			ComShowCodeMessage("DMT00166");
	   			ComSetFocus(darNo);
	   			return;
	   		}
	   	}

	   	// search  After Booking DAR. 
	   	doActionIBSheet(sheetBKGObj, formObj, IBSEARCH);
		//--------------------------------------------------------------------
	   	currAdjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		//--------------------------------------------------------------------
	   	with(sheetBKGObj) {
			//3.if exist  After Booking Adjustment Request, search Container and Comment History.
			if (RowCount() > 0) {
				//3-1.search Container list.
		    	//    decide before Searching Charge Detail per BKG from  After Booking or Charge Calculation
		    	//   (in this case from  Charge Calculation) 
		    	ComSetObjValue(formObj.is_aft_bkg_cntr, "Y");
				doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);
				
				//3-2.if Status is blank or "Counter Offered" ,then Grid activating 
				enableGrid(isEnableGrid());
				//3-3.Depending on CNTR information,  Free Time, F/Time EXCL, D/C Amount or Ratio change to activating or deactivating
				//    (Argument indicates whether to delete the value)
				modifyModeFreeTimeAmountorRatio(false);
				//3-4.Search Comment History list.
				doActionIBSheet(sheetHSTObj,formObj,IBSEARCH_COMM);
			}
			else {
				ComShowCodeMessage("DMT06001");
				if (ComTrim(ComGetObjValue(formObj.darNo)) != "") {
					ComSetFocus(formObj.darNo);	
				}
				else {
					ComSetFocus(formObj.apvlNo);
				}
			}
	   	}
	   	
	   	// change cutton staus.
	   	initBtnControl();
   }
   /**
    * Retrieve button click,  function that defines the behavior of running
    */		
   function doActionNew() {
       var formObj=document.form;
       var sheetBKGObj=sheetObjects[0];
       var sheetCNTRObj=sheetObjects[1];
       var sheetHSTObj=sheetObjects[2];
      // delete searched grid data.
       sheetBKGObj.RemoveAll();
       sheetCNTRObj.RemoveAll();
       sheetHSTObj.RemoveAll();
      // delete searched field
       with(formObj) {        
//	        ComSetObjValue(approvalOfcCd, "");
	        ComClearObject(darNo);
	        ComClearObject(apvlNo);
	        ComClearObject(status);;
	        ComClearObject(scNo);
	        ComClearObject(rfaNo);
	        ComClearObject(custCd);
	        ComClearObject(custNm);
	        ComClearObject(cntrQty);
	        ComClearObject(curr);
	        ComClearObject(totalBillAmt);
	        // deactivated filed change to activate.
  	 		ComEnableManyObjects(true, darNo, apvlNo);
  	 		darNo.className="input";
  	 		apvlNo.className="input";
			//Comment initializing +++++++++++++++++++++++++++++++++++
			chkComment.checked=false;
			comment.readOnly=true;
			comment.className="textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++
		}
    	//calculated column' color Restore to origin color
    	changeCalcColumn(false);
		//Activating of button
		initBtnControl();
		// Hide Free Time, F/Time EXCL, D/C Amount or Ratio of Charge Detail for BKG.
		hideContainerColumn(true);
		//get focus to DAR No.
		ComSetFocus(formObj.darNo);
   }
   /**
    * Request button click,  function that defines the behavior of running
    */		
   function doActionRequest() {
    	var sheetBKGObj=sheetObjects[0];
    	var formObj=document.form;
    	if (sheetBKGObj.RowCount()< 1) {
    		ComShowCodeMessage("DMT00128");
    		return;
    	}
    	//Check Validation input data before Request.
		if (validateForm(sheetBKGObj,formObj,IBSAVE)) {
			//No DAR No. : create new DAR No. 
if (sheetBKGObj.GetCellValue(sheetBKGObj.HeaderRows(), DAR_NO) == "") {
				//search created new DAR No.
				doActionIBSheet(sheetBKGObj,formObj,IBSEARCH_DAR);
				// set condition colunm to searched DAR No.
				ComSetObjValue(formObj.darNo, ComGetObjValue(formObj.result));
				//set BKG and CNTR data to searched DAR No. 
				setNewDARNo(ComGetObjValue(formObj.darNo));
			}
			//Request before performing a CNTR TYPE Different if two of the Charge Detail per BKG Cur.
			// BKG value set in the column of the Cur. Set to allow.
			setCurrencyBKGContainer();
			//Request Charge, if one exists, before you perform the Container Flag 'Y' is set to allow.
			setFlagBKGContainer();
			//Approval Action to perform.		
			doActionIBSheet(sheetBKGObj,formObj,IBSAVE);
			//Searching data ,after Request Action sucess .
			if (ComTrim(ComGetObjValue(formObj.result)) == "Y") {
				doActionRetrieve();
			}			
		}
   }
   /**
    * Cancel button click,  function that defines the behavior of running
    */		
   function doActionCancel() {
   	var sheetBKGObj=sheetObjects[0];
   	var formObj=document.form;
		if (!ComShowCodeConfirm("DMT00135", "cancel this request")) { return; }
		// run Cancel Action	
		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_CANCEL);
		//if save Action sucess , then search date
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve();
		}    	
   }    
   /**
	 * Queried based on the results of this change is the state of the button functions in a batch
	 */	    
   function initBtnControl() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		//1. set button status.######################
	   	//Request button initializing
	   	initBtnRequest();
	   	//Cancel button initializing
	   	initBtnCancel();
	   	
	   	//2.D/C AMT or Ratio Pre Cal., Reset button initializing ================================================
	   	if (sheetBKGObj.RowCount() > 0 && fetchChargeRowCount() > 0) {
	   		ComBtnEnable("btn_PreCalc");
	   		ComBtnEnable("btn_Reset");
	   	}
	   	else {
	   		ComBtnDisable("btn_PreCalc");
	   		ComBtnDisable("btn_Reset");
	   	}
   	//========================================================================================================================
   }
   /**
	 *  Views on the results of the Request button functions that changes status
	 */	     
   function initBtnRequest() {
   		var formObj=document.form;
	   	var sheetBKGObj=sheetObjects[0];
	   	var rqstOfcCd="";
	   	with(sheetBKGObj) {
	   		if (RowCount()> 0) rqstOfcCd=GetCellValue(HeaderRows(), RQST_OFC_CD);
	   	}
	   	//1. No Status :activating 
	   	var status=ComTrim(ComGetObjValue(formObj.status));
	   	if (status == "") {
	   		ComBtnEnable("btn_AddBkgReq");
	   		ComBtnEnable("btn_DelBkgReq");
	   		ComBtnEnable("btn_Request");
	   	}
	   	//2.if Status = "Counter Offered"  and login office = Request office , then activating 	
	   	else if (status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
	   		ComBtnEnable("btn_AddBkgReq");
	   		ComBtnEnable("btn_DelBkgReq");
	   		ComBtnEnable("btn_Request");
	   	}
	   	//3. if Status = "Request"  and login office = Request office , then activating 
	   	else if (status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
	   		ComBtnEnable("btn_AddBkgReq");
	   		ComBtnEnable("btn_DelBkgReq");
	   		ComBtnEnable("btn_Request");
	   	}
	   	else {
	   		ComBtnDisable("btn_AddBkgReq");
	   		ComBtnDisable("btn_DelBkgReq");
	   		ComBtnDisable("btn_Request");
	   	}
   }
   /**
	 * Queried based on the results of this change is the status of Cancel button function
	 */	     
   function initBtnCancel() {
	   	var formObj=document.form;
	   	var sheetBKGObj=sheetObjects[0];
	   	var rqstOfcCd="";
	   	with(sheetBKGObj) {
	   		if (RowCount()> 0) rqstOfcCd=GetCellValue(HeaderRows(), RQST_OFC_CD);
	   	}
	   	//1.if Status = "Request"  and login office = Request office , then activating 
	   	//2.if Status = "Counter Offered"  and login office = Request office , then activating 	
	   	var status=ComTrim(ComGetObjValue(formObj.status));
	   	if ((status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd) ) || 
	   			(status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) )
	   		ComBtnEnable("btn_Cancel");
	   	else
	   		ComBtnDisable("btn_Cancel");
  }
	/**
	 * BKG Sequence ROW Add or Copy, and then obtain a function on
	 */		
	function fetchNextADJSeq() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var prevSeq=0;
		var currSeq=0;
		with(sheetBKGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				currSeq=ComParseInt(GetCellValue(row, ADJ_SEQ));
				prevSeq=currSeq > prevSeq ? currSeq : prevSeq;
			}
		}
		return prevSeq + 1;
	} 
	/**
	 * Corresponding to the selected BKG data gives you information about Billable Amount per CNTR.
	 */		
	function showBillableAmountPerCNTR() {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		with(sheetBKGObj) {
			var bkgNo  = GetCellValue(GetSelectRow(), BKG_NO);
			var tariff = GetCellValue(GetSelectRow(), TARIFF);
			var adjSeq = GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&& 	bkgNo 	== GetCellValue(row, BKG_NO)
					&&	tariff 	== GetCellValue(row, TARIFF)
					&&	adjSeq 	== GetCellValue(row, ADJ_SEQ)	) {
					//display ROW.
					SetRowHidden(row, 0);
				}
				else {
					//hide ROW .
					SetRowHidden(row, 1);
				}
			}
		}
	}
	/**
	 * Corresponding to the selected BKG Data's Total Billable Amount per CNTR seek information.
	 */	    
   function sumBillableAmount() {
   		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		var isSumed=false;
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		var total=0;
		with(sheetCNTRObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
					if (!isSumed) isSumed=true;
					SetCellValue(row, BIL_AMT, GetCellValue(row, ORG_BIL_AMT), 0);
					total=total + parseFloat(GetCellValue(row, BIL_AMT));
				}
			}
		}
		if (!isSumed) total="";
		//set gotten summary to Total Billable Amount.
		ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
   }	 
   /**
    * Booking Charge Container of the Currency to Currency to establishing the function
    * Currency in order to save the information you need to save on the grid because the BKG.
    */	 
    function setCurrencyBKGContainer() {
   	var sheetBKGObj=sheetObjects[0];
   	var sheetCNTRObj=sheetObjects[1];
   	with(sheetBKGObj) {
	      	for (var row=HeaderRows(); row <= LastRow(); row++) {
var cntrTp=GetCellValue(row, CNTR_TP);
var adjSeq=GetCellValue(row, ADJ_SEQ);
	      		if (cntrTp == "D") {
	 	      		for (var subRow=sheetCNTRObj.HeaderRows(); subRow <= sheetCNTRObj.LastRow(); subRow++) {
if (sheetCNTRObj.GetCellValue(subRow,"ibflag") != "D" && adjSeq == sheetCNTRObj.GetCellValue(subRow, ADJ_SEQ)) {
var currCd=ComTrim(sheetCNTRObj.GetCellValue(subRow, DCAR_CURR));
	 	      				if (currCd != "") {
SetCellValue(row, DCAR_CURR,currCd,0);
	 	      					break;
	 	      				}
	 	      			}
	 	      		}
	      		}
	        }
   	}
   }
  /**
	* BOOKING Container corresponding to the amount or to the Discount Ratio can be entered by each Container indication of whether the function
	*/	 
	function setFlagBKGContainer() {
	   	var sheetBKGObj=sheetObjects[0];
	   	with(sheetBKGObj) {
	      	for (var row=HeaderRows(); row <= LastRow(); row++) {
var cntrTp=GetCellValue(row, CNTR_TP);
var adjSeq=GetCellValue(row, ADJ_SEQ);
	      		// apply to only no deleted items.
if (GetRowStatus(row) != "D") {
		      		//if CNTR  is 'All' 
		      		if (cntrTp == "S") {
SetCellValue(row, CNTR_FLG,"N",0);
		      		}
		      		//if CNTR is 'Different' 
		      		else if (cntrTp == "D") {
SetCellValue(row, CNTR_FLG,"Y",0);
		      		}
	      		}
	      	}
	   	}
	}
  /**
   * Viewed as a new DAR No. The BKG, Container allows to set.
   */	     
	function setNewDARNo(darNo) {
     	var sheetBKGObj=sheetObjects[0];
     	var sheetCNTRObj=sheetObjects[1];
     	with(sheetBKGObj) {
     		for (var row=HeaderRows(); row <= LastRow(); row++) {
SetCellValue(row, DAR_NO,darNo);
     		}
     	}
     	with(sheetCNTRObj) {
 			for (var row=HeaderRows(); row <= LastRow(); row++) {
SetCellValue(row, DAR_NO,darNo);
     		}
     	}
	}
   /**
    *  Booking Container Seqeunce create new (new insert)
    */    
   function setSequenceBKGContainer() {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		with(sheetBKGObj) {
var darNo=GetCellValue(GetSelectRow(), DAR_NO);
var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
var tariff=GetCellValue(GetSelectRow(), TARIFF);
var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		var cntrSeq=1;
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				// Tariff or BKG No., B/L No. Has changed, if viewed Charge Detail per BKG After Booking DAR information is not registered with is data retrieved when the DAR No.,
				// Adjustment Seq., Container Seq. Does not exist, 
				// and in that case should be configured to obtain the value from the BKG data.
if (	bkgNo == GetCellValue(row, BKG_NO)
&&	tariff == GetCellValue(row, TARIFF)
&& 	GetCellValue(row, ADJ_SEQ) == ""	) {
if (darNo != "") SetCellValue(row, DAR_NO,darNo,0);
SetCellValue(row, ADJ_SEQ,adjSeq,0);
SetCellValue(row, CNTR_SEQ,cntrSeq++,0);
				}
			}
		}
   }
	/**
	 * When Calculate button of D/C AMT or Ratio Pre Cal click, reletive colunm's status changes or selected row changes: initializing function
	 */	 
	function changeCalcColumn(flg) {
		if (flg) {
	     	//when selected row changes , changed red button and colunms initializing.
	     	document.getElementById("btn_PreCalc").style.color="red";
	     	document.getElementById("totalBillAmt").style.color="red";		
		}
		else {
	     	//when selected row changes , changed red button and colunms initializing.
	     	document.getElementById("btn_PreCalc").style.color="";
	     	document.getElementById("totalBillAmt").style.color="";				
		}
		changeCalcBillableAMT(flg);
	}
	/**
	 * When Calculate button of D/C AMT or Ratio Pre Cal click, reletive colunm's status changes or selected row changes: initializing function
	 */		 
	function changeCalcBillableAMT(flg) {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
    	with(sheetCNTRObj) {
    		for (var row=HeaderRows(); row <= LastRow(); row++) {
    			if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
    				if (flg) {
    					SetCellFontColor(row,BIL_AMT,"#FF0000");
    				}
    				else {
    					SetCellFontColor(row,BIL_AMT,"#000000");
    				}
  				}
    		}
		}
	}
	/**
	 * check calculation D/C AMT or Ratio Pre Cal.
	 */	 
	function isCalculated() {
	    if (document.getElementById("btn_PreCalc").style.color == "red") {
	    	return true;
	    }
	    return false;
	}
   /**
	 * depend on Status,  BKG grid status change( activating  of deactivating ).
	 */
   function enableGrid(flg) {
	   	var sheetBKGObj=sheetObjects[0];
	   	
	   	with(sheetBKGObj) {
	   		for (var row=HeaderRows(); row <= LastRow(); row++) {
	   			if (GetRowStatus(row) != "D") {
	   				//no Charge :CNTR_TP is  deactivating
	   				if (GetCellValue(row, CNTR_FLG) != "N") {
	   					SetCellEditable(row, CNTR_TP, flg);
	   				}
	   				else {
	   					SetCellEditable(row, CNTR_TP, 0);
	   				}
	   				
	    			SetCellEditable(row, FT_FLG,    flg);
	    			SetCellEditable(row, ADD_DYS,   flg);
	    			SetCellEditable(row, TTL_DYS,   flg);
	    			SetCellEditable(row, SAT_FLG,   flg);
	    			SetCellEditable(row, SUN_FLG,   flg);
	    			SetCellEditable(row, HOL_FLG,   flg);
	    			SetCellEditable(row, DCAR_FLG,  flg);
	    			SetCellEditable(row, DCAR_CURR, flg);
	    			SetCellEditable(row, DCAR_AMT,  flg);
	    			SetCellEditable(row, DCAR_RTO,  flg);
   			}
   		}
   	}
	   	
   	enableContainerGrid(flg);
   }
   /**
 	 *  depend on Status,  Container per BKG grid status change( activating  of deactivating ).
 	 */
    function enableContainerGrid(flg) {
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1];
    	with(sheetBKGObj) {
    		var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
    		var tariff=GetCellValue(GetSelectRow(), TARIFF);
    	}
    	
    	with(sheetCNTRObj) {
    		for (var row=LastRow(); row >= HeaderRows(); row--) {
    			if (	GetRowStatus(row) != "D" && bkgNo 	== GetCellValue(row, BKG_NO) && tariff 	== GetCellValue(row, TARIFF)	) {
	     			SetCellEditable(row, FT_FLG,flg);
	     			SetCellEditable(row, ADD_DYS,flg);
	     			SetCellEditable(row, TTL_DYS,flg);
	     			SetCellEditable(row, SAT_FLG,flg);
	     			SetCellEditable(row, SUN_FLG,flg);
	     			SetCellEditable(row, HOL_FLG,flg);
	     			SetCellEditable(row, AR_FLG,flg);
	     			SetCellEditable(row, AR_AMT,flg);
	     			SetCellEditable(row, AR_RTO,flg);
    			}
    		}
    	}
    }
   /**
	 *  depend on After Booking DAR's Status,  grid status change( activating  of deactivating ). 
	 */    
   function isEnableGrid() {
	   	var formObj=document.form;
	   	var sheetBKGObj=sheetObjects[0];
	   	var rqstOfcCd="";
	   	with(sheetBKGObj) {
	   		if (RowCount()> 0) rqstOfcCd=GetCellValue(HeaderRows(), RQST_OFC_CD);
	   	}
	   	//GRID activating  1)Status is blank, 2)case in  Status is "Counter Offered" , login office =  Request office
	   	//                 3)case in  Status is "Requested",  login office =  Request office
		var status=ComTrim(ComGetObjValue(formObj.status));
		if (status == "") {
			return true;	
		} else if (status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
			return true;
		} else if (status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
			return true;
		}
		return false;
   }
 	/**
 	 * On DAR searching condition fields,  if value is entered in a particular field, then makes other Clear all fields.
 	 */
 	function clearNoSelectConditionFields() {	 
 	    var formObj=document.form;
 		with(formObj) {
 			switch(event.srcElement.name) {
 				case "darNo":
 					if (ComTrim(ComGetObjValue(apvlNo)) != "") ComClearObject(apvlNo);
 					break;
 				case "apvlNo":
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					break;  					
 			}
 		}
 	}
	/**
	 * if D/C Amount or Ratio' Currency of Change Detail per BKG  is changed, then all data changes, the same shall also make the same changes.
	 */		 
	function changeCurrencyAltogther(selectRow) {
		var sheetCNTRObj=sheetObjects[1];
		with(sheetCNTRObj) {
			var adjSeq=GetCellValue(selectRow, ADJ_SEQ);
			var currCd=GetCellValue(selectRow, DCAR_CURR);
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (adjSeq == GetCellValue(row, ADJ_SEQ) && row != selectRow) {
					if (GetCellValue(row, AR_FLG) == 1) {
						SetCellValue(row, DCAR_CURR,currCd,0);
					}
					else {
						SetCellValue(row, DCAR_CURR,"",0);
					}
				}
			}
		}
	}
  /**
   * Search count of Charge Detail per BKG  in same Tariff and  BKG No.
   */
   function getChargeQuantity() {
	   	var sheetBKGObj=sheetObjects[0];
	   	var sheetCNTRObj=sheetObjects[1];
		var bkgNo=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), BKG_NO);
		var tariff=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), TARIFF);
	   	var quantity=0;
	   	with(sheetCNTRObj) {
	   		for (var row=HeaderRows(); row <= LastRow(); row++) {
	   			if (bkgNo == GetCellValue(row, BKG_NO) && tariff == GetCellValue(row, TARIFF)) {
	   				quantity++;
	   			}
	   		}
	   	}
	   	if (quantity == 0) return ""
	   	return quantity
   }
  /**
   *  Returns the first Currency of Charge Detail per BKG of same Tariff and BKG No
   */
   function getCurrency() {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		var quantity=0;
		with(sheetBKGObj) {
		var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
		var tariff=GetCellValue(GetSelectRow(), TARIFF);
		var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		var seq=1;
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&  GetRowHidden(row) == false
					&& 	bkgNo == GetCellValue(row, BKG_NO)
					&&	tariff == GetCellValue(row, TARIFF)
					&&	adjSeq == GetCellValue(row, ADJ_SEQ)	) {
					return GetCellValue(row, CURR);
				}
			}
		} 
   	return "";
   }
   /**
   * Of Charge Detail per BKG CNTR Q'ty, Cur, Total Billable AMT functions that Clear information
   */    
	function clearChargeDetailTopInfo() {
		var formObj=document.form;
		with(formObj) {
			ComClearObject(cntrQty);
			ComClearObject(curr);
			ComClearObject(totalBillAmt);
		}
	}
  	/**
  	 *  Rate Adjustment or select an item of avoidance behavior that defines the function to perform
  	 */	
 	 function checkComment() {
 		var formObj=document.form;
		var sheetHSTObj=sheetObjects[2];
		with(formObj) {
			if (chkComment.checked) {
				ComSetObjValue(comment, "");
			}
			else {
				if(sheetHSTObj.RowCount()>0){
					ComSetObjValue(comment, sheetHSTObj.GetCellValue(sheetHSTObj.GetSelectRow(), PROG_RMK));
 				}else{
 					ComSetObjValue(comment, "");
 				}
			}
			comment.readOnly=!chkComment.checked;
			if (chkComment.checked) {
				comment.style.backgroundColor="#CCFFFD";	//textarea1
				
			}else {
				comment.style.backgroundColor="#E8E7EC";	//textarea2
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++
	 	}  		
 	}
	/**
	 * Comment on the required input function that performs the check
	 */	   	 
    function validateComment() {
    	var formObj=document.form;
    	with(formObj) {
	 		if (!chkComment.checked) {
	 			ComShowCodeMessage("DMT00151");
	 			ComSetFocus(chkComment);
	 			return false;				
	 		}
	 		else if (ComTrim(ComGetObjValue(comment)) == "") {
	 			ComShowCodeMessage("DMT02002", "Comment");
	 			ComSetFocus(comment);
	 			return false;				
	 		}
	 		else if (ComChkLenByByte(ComGetObjValue(comment), 500) == 0) {
	 			ComShowCodeMessage("DMT00104", "Comment", "500");
	 			ComSetFocus(comment);
	 			return false;				
	 		}
    	}
       return true;	
    }  
	/**
	 * BKG No. Or B/L No. Charge to modify the query after the key column is changed to prevent.
	 */		
  	function disableKeyColumn(selectedRow) {
  		var sheetBKGObj=sheetObjects[0];
  		with(sheetBKGObj) {
  			SetCellEditable(selectedRow, BKG_NO, 0);
  			SetCellEditable(selectedRow, BL_NO,  0);
  			SetCellEditable(selectedRow, TARIFF, 0);
  		}
  	}
 	/**
 	 * When BKG No Or B/L No Input,  B/L No Or BKG No S/C No, RFA No. To look up the function
 	 */	 	
	function checkBKGBLNo(COL) {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		//1-1.  When BKG No Or B/L No Input, if it is invalid  B/L No or BKG No,  then show error message.
 		with(sheetBKGObj) {
	 		if (!checkTariffBKGBLNo(sheetBKGObj,formObj)) {
	 			if (ComGetObjValue(formObj.result2) == "") {
	 	 			ComShowCodeMessage("DMT00165", COL == BKG_NO ? "BKG No." : "B/L No.");
					SetCellValue(GetSelectRow(), BKG_NO,"",0);
					SetCellValue(GetSelectRow(), BL_NO,"",0);
	 	     		return false;
	 			}
	 			else {
					//3-1. if S/C or RFA No of inputed BKG No  is mismatch The top of the S/C or RFA No. , then show error message.
					ComShowCodeMessage("DMT00159", GetCellValue(GetSelectRow(), "Seq"));
					SetCellValue(GetSelectRow(), BKG_NO,"",0);
					SetCellValue(GetSelectRow(), BL_NO,"",0);
					return false;
	 			}
	 		} 
 		}
 		return true;
	}
	/**
 	 * The entire CNTR A / RI / F is a function that the checkmark
 	 * (Least one A / RI / F when it is changed to checkmark)
	 */	
	function checkARIFAllContainer() {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
					if (GetCellValue(row, AR) == "Y") {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 *  if All CNTR done A/R interface, delete user cancel information
	 */	 	
	function removeBookingChargeData() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		with(sheetBKGObj) { 		
			var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		//delete Charge Header
		ComClearObject(formObj.cntrQty);
		ComClearObject(formObj.curr);
		ComClearObject(formObj.totalBillAmt);
		//delete Charge 
		with(sheetCNTRObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (sheetCNTRObj.GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
					if (GetRowStatus(row) == "I") {
						RowDelete(row, false);
					}
					else {
						SetRowStatus(row, "D");
						SetRowHidden(row, 1);
					}
				}
			}
		}
		//delete Booking
		with(sheetBKGObj) {
			var iRow=GetSelectRow();
			SetCellValue(iRow, BKG_NO,"",0);
			SetCellValue(iRow, BL_NO,"",0);
			SetCellValue(iRow, TVVD,"",0);
			SetCellValue(iRow, POR,"",0);
			SetCellValue(iRow, POL,"",0);
			SetCellValue(iRow, POD,"",0);
			SetCellValue(iRow, DEL,"",0);
			SetCellValue(iRow, RD,"",0);
			SetCellValue(iRow, DG_FLG,"",0);
			SetCellValue(iRow, RF_FLG,"",0);
			SetCellValue(iRow, AK_FLG,"",0);
			SetCellValue(iRow, BB_FLG,"",0);
			SetCellValue(iRow, RD_FLG,"",0);
			SetCellValue(iRow, SOC_FLG,"",0);
			SetCellValue(iRow, CMDT_CD,"",0);
			SetCellValue(iRow, CMDT_NM,"",0);
		}
		// if it is only one exist Booking infotmation, delete information of S/C No, RFA No and Customer.
		if (getAfterBKGCount() <= 1) {
			ComClearObject(formObj.scNo);
			ComClearObject(formObj.rfaNo);
			ComClearObject(formObj.custCd);
			ComClearObject(formObj.custNm);
		}		
	}
	/**
	 * existing  Booking' row count
	 */	 	 
	function getAfterBKGCount() {
		var sheetBKGObj=sheetObjects[0];
		with(sheetBKGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					return 1;
				}
			}
		}
		return 0;
	}
  /**
   * When Pre Calc button click, if  CNTR  is  'All' , 
   * BKG D/C Amount or Ratio 's data copy to Container Charge for charge calculation
   */	
   function copyDCAmountOrRatioToChargeContainer() {
	   	var sheetBKGObj=sheetObjects[0];
	   	var sheetCNTRObj=sheetObjects[1]
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		var amt=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), DCAR_AMT);
		var ratio=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), DCAR_RTO);
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D" && GetRowHidden(row) == false && adjSeq == GetCellValue(row, ADJ_SEQ)) {
					if (GetCellValue(row, GB) == "G") {
						SetCellValue(row, AR_AMT,amt,0);
						SetCellValue(row, AR_RTO,ratio,0);
					}
				}
			}
		}
   }
  /**
   * When Pre Calc button click, if  CNTR  is  'All' , 
   *  delete BKG D/C Amount or Ratio 's data that copied to Container Charge for charge calculation 
   */	
   function removeDCAmountOrRatioToChargeContainer() {
  	    var sheetBKGObj=sheetObjects[0];
  	    var sheetCNTRObj=sheetObjects[1]
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		var amt=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), DCAR_AMT);
		var ratio=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), DCAR_RTO);
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
					if (GetCellValue(row, GB) == "G") {
						SetCellValue(row, AR_AMT,"",0);
						SetCellValue(row, AR_RTO,"",0);
					}
				}
			}
		}
   }  	 
  /**
   *   Depending on CNTR information,  Free Time, F/Time EXCL, D/C Amount or Ratio change to activating or deactivating 
   */    
   function modifyModeFreeTimeAmountorRatio(isValueClear) {
	   	var sheetBKGObj=sheetObjects[0];
	    var sheetCNTRObj=sheetObjects[1]; 
	    var isActive=isEnableGrid();
	    
	    var selectedRow = sheetBKGObj.GetSelectRow();
	    with(sheetBKGObj) {
			var cntrType = GetCellValue(selectedRow, CNTR_TP);
			var bkgNo    = GetCellValue(selectedRow, BKG_NO);
			var tariff   = GetCellValue(selectedRow, TARIFF);
	    }
	    
	   	//all same 
	   	if (cntrType == "S") {
	   		with(sheetBKGObj) {
	   			//[ BKG ] Free Time check box, D/C Amount or Ratio check box change to  activating or deactivating 
	   			SetCellEditable(selectedRow, FT_FLG,   isActive);
	   			SetCellEditable(selectedRow, DCAR_FLG, isActive);
				//if Free Time check box is checked,  Free Time(Add, Total), F/Time EXCL(SAT, SUN, H/day) is deactivating .
   				if (GetCellValue(selectedRow, FT_FLG) == 1) {
					SetCellEditable(selectedRow, ADD_DYS, isActive);
					SetCellEditable(selectedRow, TTL_DYS, isActive);
					SetCellEditable(selectedRow, SAT_FLG, isActive);
					SetCellEditable(selectedRow, SUN_FLG, isActive);
					SetCellEditable(selectedRow, HOL_FLG, isActive);
				}
				else {
					SetCellEditable(selectedRow, ADD_DYS, 0);
					SetCellEditable(selectedRow, TTL_DYS, 0);
					SetCellEditable(selectedRow, SAT_FLG, 0);
					SetCellEditable(selectedRow, SUN_FLG, 0);
					SetCellEditable(selectedRow, HOL_FLG, 0);
				}
				//if  D/C Amount or Ratio  check box is checked,  D/C Amount or Ratio(CUR, AMT, Ratio) is activating .
   				if (GetCellValue(selectedRow, DCAR_FLG) == 1) {
					SetCellEditable(selectedRow, DCAR_CURR, isActive);
					SetCellEditable(selectedRow, DCAR_AMT,  isActive);
					SetCellEditable(selectedRow, DCAR_RTO,  isActive);
				}
				else {
					SetCellEditable(selectedRow, DCAR_CURR, 0);
					SetCellEditable(selectedRow, DCAR_AMT,  0);
					SetCellEditable(selectedRow, DCAR_RTO,  0);
				}
				// hide colunm in Charge Detail per BKG
				hideContainerColumn(true);
				//delete colunm in Charge Detail per BKG
				if (isValueClear) {
					clearCNTRFreeTimeAmountorRatio();
				}
				//deactivate colunm in Charge Detail per BKG .
				modifyCNTRModeFreeTimeAmountorRatio(selectedRow, false);
	   		}
	   	}
	   	//all different 
	   	else if (cntrType == "D") {
			//[ BKG ] Free Time check box, D/C Amount or Ratio check box change to  activating or deactivating 
	   		with(sheetBKGObj) {
	   			SetCellEditable(selectedRow, FT_FLG,   0);
	   			SetCellEditable(selectedRow, DCAR_FLG, 0);
	   		}
	   		with(sheetCNTRObj) {
	   			for (var row=HeaderRows(); row <= LastRow(); row++) {
	   				if (GetRowStatus(row) != "D" && bkgNo == GetCellValue(row, BKG_NO) && tariff == GetCellValue(row, TARIFF)) {
	        			isActive=isEnableGrid();
	         				//if G/B='B',  'Y' check box deactivating
	        			if (GetCellValue(row, GB) == "B") isActive=false;
	        			SetCellEditable(row, FT_FLG, isActive);
		    				//if Free Time  check box is checked,  Free Time(Add, Total), F/Time EXCL(SAT, SUN, H/day) activate
	        			if (GetCellValue(row, FT_FLG) == 1) {
	    					SetCellEditable(row, ADD_DYS, isActive);
	    					SetCellEditable(row, TTL_DYS, isActive);
	    					SetCellEditable(row, SAT_FLG, isActive);
	    					SetCellEditable(row, SUN_FLG, isActive);
	    					SetCellEditable(row, HOL_FLG, isActive);
	    				}
	    				else {
	    					SetCellEditable(row, ADD_DYS, 0);
	    					SetCellEditable(row, TTL_DYS, 0);
	    					SetCellEditable(row, SAT_FLG, 0);
	    					SetCellEditable(row, SUN_FLG, 0);
	    					SetCellEditable(row, HOL_FLG, 0);
	    				}
	    				SetCellEditable(row, AR_FLG, isActive);
		    			//if  D/C Amount or Ratio check box is checked,  D/C Amount or Ratio(CUR, AMT, Ratio) activate
	    				if (GetCellValue(row, AR_FLG) == 1) {
		    					SetCellEditable(row, DCAR_CURR, isActive);
								SetCellEditable(row, AR_AMT,    isActive);
								SetCellEditable(row, AR_RTO,    isActive);
		    				}
		    				else {
		    					SetCellEditable(row, DCAR_CURR, 0);
								SetCellEditable(row, AR_AMT,    0);
								SetCellEditable(row, AR_RTO,    0);
		    				}
	        			}
	   			}
				//dislpay colunm in Charge Detail per BKG.
				hideContainerColumn(false);
				//delete bkg data.
				if (isValueClear) {
					clearBKGFreeTimeAmountorRatio();
				}
				//activate  bkg data.
				modifyBKGModeFreeTimeAmountorRatio(selectedRow, false);
	   		}
       }
   }
  /**
   * BKG Grid's Free Time, Amount or Ratio can take care of whether to activate the function of the column
   */ 
   function modifyBKGModeFreeTimeAmountorRatio(row, isActive) {
	    var sheetBKGObj=sheetObjects[0];
	    if (!isEnableGrid()) isActive=false;
	    with(sheetBKGObj) {
			SetCellEditable(row, ADD_DYS,   isActive);
			SetCellEditable(row, TTL_DYS,   isActive);
			SetCellEditable(row, SAT_FLG,   isActive);
			SetCellEditable(row, SUN_FLG,   isActive);
			SetCellEditable(row, HOL_FLG,   isActive);
			SetCellEditable(row, DCAR_CURR, isActive);
			SetCellEditable(row, DCAR_AMT,  isActive);
			SetCellEditable(row, DCAR_RTO,  isActive);
	    }
   }
  /**
   *  CNTR Grid's Free Time, Amount or Ratio can take care of whether to activate the function of the column
   */ 
   function modifyCNTRModeFreeTimeAmountorRatio(bkgrow, isActive) {
   	var sheetBKGObj=sheetObjects[0];
   	var sheetCNTRObj=sheetObjects[1]; 
   	if (!isEnableGrid()) isActive=false;
		with(sheetBKGObj) {
			var bkgNo=GetCellValue(bkgrow, BKG_NO);
			var tariff=GetCellValue(bkgrow, TARIFF);
			var adjSeq=GetCellValue(bkgrow, ADJ_SEQ);
		}
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&	GetRowHidden(row) == false
					&& 	bkgNo == GetCellValue(row, BKG_NO)
					&&	tariff == GetCellValue(row, TARIFF)
					&&	adjSeq == GetCellValue(row, ADJ_SEQ)	) {
					SetCellEditable(row, ADD_DYS,isActive);
					SetCellEditable(row, TTL_DYS,isActive);
					SetCellEditable(row, SAT_FLG,isActive);
					SetCellEditable(row, SUN_FLG,isActive);
					SetCellEditable(row, HOL_FLG,isActive);
					SetCellEditable(row, DCAR_CURR,isActive);
					SetCellEditable(row, AR_AMT,isActive);
					SetCellEditable(row, AR_RTO,isActive);
				}
			}
		}
   }
 /**
  * BKG Grid's Free Time, Amount or Ratio a function that deletes the data in column
  */   
   function clearBKGFreeTimeAmountorRatio() {
  	    var sheetBKGObj=sheetObjects[0];
  	    with(sheetBKGObj) {
			SetCellValue(GetSelectRow(), FT_FLG,0,0);
			SetCellValue(GetSelectRow(), ADD_DYS,"",0);
			SetCellValue(GetSelectRow(), TTL_DYS,"",0);
			SetCellValue(GetSelectRow(), SAT_FLG,0,0);
			SetCellValue(GetSelectRow(), SUN_FLG,0,0);
			SetCellValue(GetSelectRow(), HOL_FLG,0,0);
			SetCellValue(GetSelectRow(), DCAR_FLG,0,0);
			SetCellValue(GetSelectRow(), DCAR_CURR,"",0);
			SetCellValue(GetSelectRow(), DCAR_AMT,"",0);
			SetCellValue(GetSelectRow(), DCAR_RTO,"",0);
       }
   }
  /*
   * Charge Detail per BKG Grid's Free Time, Amount or Ratio a function that deletes the data in column
   */ 
   function clearCNTRFreeTimeAmountorRatio() {
   	var sheetBKGObj=sheetObjects[0];
   	var sheetCNTRObj=sheetObjects[1]; 
   	with(sheetBKGObj) {
		var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
		var tariff=GetCellValue(GetSelectRow(), TARIFF);
   	}
	with(sheetCNTRObj) {
		for (var row=HeaderRows(); row <= LastRow(); row++) {
			if (GetRowStatus(row) != "D" && bkgNo == GetCellValue(row, BKG_NO) && tariff == GetCellValue(row, TARIFF)) {
				SetCellValue(row, FT_FLG,0,0);
				SetCellValue(row, ADD_DYS,"",0);
				SetCellValue(row, TTL_DYS,"",0);
				SetCellValue(row, SAT_FLG,0,0);
				SetCellValue(row, SUN_FLG,0,0);
				SetCellValue(row, HOL_FLG,0,0);
				SetCellValue(row, AR_FLG,0,0);
				SetCellValue(row, DCAR_CURR,"",0);
				SetCellValue(row, AR_AMT,"",0);
				SetCellValue(row, AR_RTO,"",0);
   			}
		}
	}
   }
   /**
    * In order to reset the value of Seq of Charge Detail per BKG Grid
    */
   function setCNTRSeq() {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		with(sheetBKGObj) {
			var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
			var tariff=GetCellValue(GetSelectRow(), TARIFF);
			var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		var seq=1;
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&  GetRowHidden(row) == false
					&& 	bkgNo 	== GetCellValue(row, BKG_NO)
					&&	tariff 	== GetCellValue(row, TARIFF)
					&&	adjSeq 	== GetCellValue(row, ADJ_SEQ)	) {
					SetCellValue(row, "Seq", seq++, 0);
				}
			}
		}
   }
    /**
    * after delete row, focus move to next row automatically
    */
   function fetchSelectedNextRow(delRow) {
		var sheetBKGObj=sheetObjects[0];
		var nextRow=-1;
		with(sheetBKGObj) {
			//fine next row of delete row 
			for (var row=delRow ; row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					nextRow=row;
					break;
				}
			}
			//can not find row
			if (nextRow == -1) {
				//fine previous row of delete row 
				for (var row=delRow ; row >= HeaderRows(); row--) {
					if (GetRowStatus(row) != "D") {
						nextRow=row;
						break;
					}
				}
			}
		}
		return nextRow;
   }
	/**
	 *  If another row is selected BKG's row,  showing Charge Detail per BKG also need to change.
	 */
   function displayChargeDetailperBKG(newRow) {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		//if change selected BKG row , delete  CNTR Q'ty, Cur., Total Billable AMT of Charge Detail per BKG 
		clearChargeDetailTopInfo();  
		//if change selected BKG row , changed red items  Restore to original color.
		changeCalcColumn(false);
		if (sheetBKGObj.GetCellValue(newRow, SRCH_FLG) != "Y") {
			with(sheetBKGObj) {
				// Tariff and ( BKG No. or  B/L No.) are madatory items
				if (GetCellValue(newRow, TARIFF) != "" && (GetCellValue(newRow, BKG_NO) != "" || GetCellValue(newRow, BL_NO) != "")) {
			    	//decide before Searching Charge Detail per BKG from  After Booking or Charge Calculation
			    	// (in this case from  Charge Calculation)
					// if it is not existing, get in Charge Calculation			
					if (GetCellValue(newRow, DAR_NO) != "") {
						ComSetObjValue(formObj.is_aft_bkg_cntr, "Y");
					}
					else {
						ComSetObjValue(formObj.is_aft_bkg_cntr, "N");
					}
					//search Billable Amount per CNTR info..
					doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);		
				}
			}
		}
		
		// Billable Amount per CNTR 
		showBillableAmountPerCNTR();
		//Depending on CNTR information,  Free Time, F/Time EXCL, D/C Amount or Ratio change to activating or deactivating
  		//(Argument indicates whether to delete the value)    	
		modifyModeFreeTimeAmountorRatio(true);
		
		if (sheetBKGObj.GetCellValue(newRow, SRCH_FLG) == "Y") {
			//summary Container Quantity in grid.
			ComSetObjValue(formObj.cntrQty, getChargeQuantity());
			// change Currency by bkg information 
			ComSetObjValue(formObj.curr, getCurrency());
			// Total amount of Container Billable Amount.
			sumBillableAmount();	
		}
		
		// if exist Charge Detail per BKG data, then D/C AMT or Ratio Pre Cal., Reset button activating else  deactivating)
		if (fetchChargeRowCount() > 0) {
			ComBtnEnable("btn_PreCalc");
			ComBtnEnable("btn_Reset");
		}
		else {
			ComBtnDisable("btn_PreCalc");
			ComBtnDisable("btn_Reset");
		}
   }
    /**
     *  return  total count of Charge Detail per BKG of same Tariff and BKG No.
     */
   function fetchChargeRowCount() {
     	var sheetBKGObj=sheetObjects[0];
     	var sheetCNTRObj=sheetObjects[1];
     	var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
     	var count=0;
     	with(sheetCNTRObj) {
     		for (var row=HeaderRows(); row <= LastRow(); row++) {
     			if (GetRowStatus(row) != "D" && GetRowHidden(row) == false && adjSeq == GetCellValue(row, ADJ_SEQ)) {
     				count++;
     			}
     		}
     	}
     	return count;
   }
   
  /**
   * Delivered normally not received from the server being able to handle the data function 
   */
   function handleNullString(sVal) {
      if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
      return ComTrim(sVal);
   }
   /**
	 * After Exception Container Seq. Function that generates sequentially.
	 * Charge information is also viewed. After Booking generated after registration
	 */
	function setAfterBookingCNTRSeq() {
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		with(sheetBKGObj) {
			var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
			var tariff=GetCellValue(GetSelectRow(), TARIFF);
			var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		var maxCNTRSeq=0;
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) != "D"
					&&	GetRowStatus(row) != "I"
					&&  GetRowHidden(row) == false
					&&	""		!= GetCellValue(row, CNTR_SEQ)
					&& 	bkgNo 	== GetCellValue(row, BKG_NO)
					&&	tariff 	== GetCellValue(row, TARIFF)
					&&	adjSeq 	== GetCellValue(row, ADJ_SEQ)	) {
					if (ComParseInt(GetCellValue(row, CNTR_SEQ)) > maxCNTRSeq) maxCNTRSeq=ComParseInt(GetCellValue(row, CNTR_SEQ));
				}
			}
			maxCNTRSeq++;
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (	GetRowStatus(row) == "I"
					&&  GetRowHidden(row) == false
					&&  ""		== GetCellValue(row, CNTR_SEQ)
					&& 	bkgNo 	== GetCellValue(row, BKG_NO)
					&&	tariff 	== GetCellValue(row, TARIFF)
					&&	adjSeq 	== GetCellValue(row, ADJ_SEQ)	) {
					SetCellValue(row, CNTR_SEQ, maxCNTRSeq++, 0);
				}
			} 			
		}
	}
	
    /** 
     * comment onblur event
     */ 
    function comment_Change(){
        obj=document.form.comment;
    	var comment = checkSpecial(ComGetObjValue(obj));  //특수문자 제외 로직
    	ComSetObjValue(obj, comment);
    }
