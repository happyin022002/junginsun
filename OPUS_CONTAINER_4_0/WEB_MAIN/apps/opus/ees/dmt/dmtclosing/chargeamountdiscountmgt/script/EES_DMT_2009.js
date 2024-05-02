/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2009.js
*@FileTitle  : DEM/DET Adjustment Request - After Booking Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//Action definition
	var IBSEARCH_CHECK_CALC=101;
	var IBSEARCH_CHECK_DUP=102;
	var IBSEARCH_CHECK_BALCHG=103;
	var IBSEARCH_BKG=104;
	var IBSEARCH_CNTRCHG_BKG=105;
	var IBSEARCH_COMM=106;
	var IBSEARCH_DAR=107;
	var IBSEARCH_CURR=108;
	var IBSEARCH_CHECK_BKGNO=109;
	var IBSEARCH_CHECK_ROLE=110;
	var IBSAVE_CANCEL=201;
	var IBSAVE_APPROVAL=202;
	var IBSAVE_COUNTEROFFER=203;
	var IBSAVE_REJECT=204;
	//DATA delimiter definition
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
	var SRCH_FLG="child_search";	// Billable Amount per CNTR BKG look up information on the status of whether the column has a value
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
	var PRNT_OFC="prnt_ofc_cd"; // 2010-06-08 add
	//Container is viewed as a descendant of the hidden state and the actual deletion is used to distinguish
	var HIDDEN="hidden";
	//ROW COPY sheet1_OnSelect when the function is invoked through that logic does not perform variable for distinguish
	var isDataCopy=false;
	var timer;
    var prevActStatus="";
  	//Sort Row was chosen for the selection of state variables that are used in order to maintain
	var currAdjSeq="";    
	
	var DEF_SHEET_HEIGHT = 125;
	var CHG_SHEET_HEIGHT = 132;
	var CMT_SHEET_HEIGHT = 98;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName = ComGetEvent("name");
    		
    		if (!ComIsBtnEnable(srcName)) return; 
    		
			switch(srcName) {
				case "btn_AddBkgReq":
					doActionAddADJAfterBKG();
				break;

				case "btn_DelBkgReq":
					doActionDelADJAfterBKG();
				break;
				
				case "btn_PreCalc":
					doActionPreCalc();
				break;
				
				case "btn_Reset":
					doActionReset();
				break;
				
				case "btn_Retrieve":
					doActionRetrieve();
				break;
				
				case "btn_New":
					doActionNew();
				break;
				
				case "btn_Request":
					doActionRequest();
				break;
				
				case "btn_Cancel":
					doActionCancel();
				break;

				case "btn_Approval":
					doActionApproval();
				break;
				
				case "btn_CounterOffer":
					doActionCounterOffer();
				break;

				case "btn_Reject":
					doActionReject();
				break;	

				case "btn_Close":
					doActionClose();						
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
    	var sheetObj=sheetObjects[0];
	   	// Displays a pop-up title at the call handling
        if (isPopupWindow()) {
	        var spanObj=document.getElementById("title");
	       	spanObj.innerText=" DEM/DET Adjustment Request - After Booking Approval";
	       	//Pop-up call to the corresponding menu button in the pop-up shows.
	       	btnPopUpLayer.style.display="block";	       	
	   	}
        else {
        	//Calls to the main menu button in the pop-up shows the corresponding.
        	btnMainLayer.style.display="block";
        }        
        for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

	    axon_event.addListener('blur', 'comment_Change', 'comment');
		//html control event initializing
		initControl();        
		//deactivates certain fields when loading on the screen.
		initDisableControls();
		// Free Time of Billable Amount per CNTR, F/T Exclusion, Amount or Ratio column is hidden.
		hideContainerColumn(true);
  		//1.Make sure the permissions.
   		doActionIBCommon(sheetObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);
   		//2.Tariff Type query result set are retrieved in the combo
   		doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCHLIST,TARIFF);
   		
   		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND06);
   		
		//3. 2,006 times the screen by double-clicking on the queried results present a pop-up screen will pop up automatically if parameter is passed if the lookup is performed
		if (ComTrim(ComGetObjValue(formObj.darNo)) != "") {
			doActionRetrieve();
		}
		else {   		
			//2.resets the entire state of Button.
			initBtnControl();
		}
		
    }
    
  	function initControl() {
		axon_event.addListenerForm('beforedeactivate','obj_deactivate',  document.form, 'cond_type'); //- focus out
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- input with keyboard		
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListener('blur', 'obj_blur', 'custCd');
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
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
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
            	//SetConfig( { SearchMode:2,MergeSheet:5, DataRowMerge:0 } );
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
            	SetColProperty(CNTR_TP, {ComboText:"All|Different", ComboCode:"S|D"} );
            	//SetSheetWidth(mainTable.clientWidth);
            	SetSheetHeight(DEF_SHEET_HEIGHT,1);
            	SetEditable(1);
            	SetCountPosition(0);
            	}
			break;
			
            case "sheet2":
            	with(sheetObj){
            	var HeadTitle1="|Seq.|STS|A/R|CNTR No.|T/S|Office|From YD|F/T|Over|Cur.|Billable AMT|G/B|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio";
            	var HeadTitle2="|Seq.|STS|A/R|CNTR No.|T/S|Office|From YD|F/T|Over|Cur.|Billable AMT|G/B|Y|Add|Total|SAT|SUN|H/day|Y|CUR|AMT|Ratio|Ratio";
            	var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
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
            	{Type:"CheckBox",  Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:FT_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	{Type:"Int",       Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ADD_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, GetToolTipText:"Additional Day" },
            	{Type:"Int",       Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TTL_DYS,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, GetToolTipText:"Total Day"  },
            	{Type:"CheckBox",  Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"CheckBox",  Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"CheckBox",  Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"CheckBox",  Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:AR_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	{Type:"Combo",     Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:DCAR_CURR,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            	{Type:"Float",     Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:AR_AMT,         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
            	{Type:"Float",     Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:AR_RTO,         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:AR_RTO2,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            	{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:PRNT_OFC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HIDDEN,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
            	InitColumns(cols);
            	//SetSheetWidth(mainTable.clientWidth);
            	SetSheetHeight(CHG_SHEET_HEIGHT,1);
            	SetEditable(1);
            	SetCountPosition(0);
            	}
			break;
			
            case "sheet3":
            	with(sheetObj){
            	var HeadTitle1="|Seq.|Status|Date|Office|Name";
            	var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	SetConfig( { SearchMode:2,MergeSheet:5, DataRowMerge:0 } );
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
            	//SetSheetWidth(mainTable.clientWidth);
            	SetEditable(1);
            	SetCountPosition(0);
            	SetSheetHeight(CMT_SHEET_HEIGHT,1);
            	}
    		break;
        }
    }
    
    
    function doActionIBSheet(sheetObj,formObj,sAction){
    	sheetObj.ShowDebugMsg(false);
        var iRow=sheetObj.GetSelectRow();
        switch(sAction) {
        	case IBSEARCH:      //retrieving
        		var sheetBKGObj=sheetObjects[0];
        		var sheetCNTRObj=sheetObjects[1];
				//1.Enter all or selected query parameter set allows.
    			ComSetObjValue(formObj.f_cmd, 		SEARCH);
        		ComSetObjValue(formObj.apvl_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
        		ComSetObjValue(formObj.dar_no, 		ComGetObjValue(formObj.darNo));
        		ComSetObjValue(formObj.apvl_no, 	ComGetObjValue(formObj.apvlNo));
				//2.Viewed as a query is run conditions
        		//*********************************************************************************
        		ComOpenWait(true);
        		sheetObj.SetWaitImageVisible(0);
        		//*********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
                ComOpenWait(false);
				//3.Sheet before each mapping query results to the Clear Sheet to each.
        		sheetBKGObj.RemoveAll();
        		sheetCNTRObj.RemoveAll();
				//4.After processing query results(Retrieved results to the grid allows you to map each result.)
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
					//Makes referrals to a field set to the value of query conditions.
					
					ComSetObjValue(formObj.approvalOfcCd, 	ComGetEtcData(sXml, "APVL_OFC_CD"));
					
					if(ComGetEtcData(sXml, "APVL_OFC_CD")!=""){
				   		ComSetObjValue(comboObjects[0], ComGetEtcData(sXml, "APVL_OFC_CD"));		
				   		comboObjects[0].SetEnable(false);
					}

					ComSetObjValue(formObj.darNo, 			ComGetEtcData(sXml, "DAR_NO"));
					ComSetObjValue(formObj.apvlNo, 			ComGetEtcData(sXml, "APVL_NO"));
					ComSetObjValue(formObj.status, 			ComGetEtcData(sXml, "STS_DESC"));
					ComSetObjValue(formObj.scNo, 			ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.rfaNo, 			ComGetEtcData(sXml, "RFA_NO"));
					ComSetObjValue(formObj.custCd, 			ComGetEtcData(sXml, "CUST_CD"));
					ComSetObjValue(formObj.custNm, 			ComGetEtcData(sXml, "CUST_NM"));
					//Allows you to map the query results grid.
					sheetObj.LoadSearchData(sXml, {Sync:1});
					
					if (sheetObj.RowCount > 0) {
						//After Booking DAR queried the status of a Counter Offered disabled if the lookup field
						//2009-09-28(Mon) Changes : Counter Offered only if the current one, which disables lookups, when viewed as an unconditional change can be safely disabled
						 with(formObj) {
							 ComEnableManyObjects(false, darNo, apvlNo);
							 darNo.className 	= "input2";
							 apvlNo.className 	= "input2";
						 }						
					}
					
					//View-BKG No., B / LL No., Tariff Prevents users from modifying the change.
					with(sheetObj) {
						for (var row = HeaderRows ; row <= LastRow ; row++) {
							disableKeyColumn(row);
						}
					}					
				}
			break;
			
		    //Calculation Type Check
        	case IBSEARCH_CHECK_CALC:
				//1.Enter all or selected query parameter set allows.
    			ComSetObjValue(formObj.f_cmd, SEARCH04);
				//2.Lookup query execution condition
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.SetWaitImageVisible(0);
    			//*********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After processing query results(Viewed the results on the grid allows you to map each result.)
				ComSetObjValue(formObj.result, ComGetEtcData(sXml, "CHECK_CALC"));
				ComSetObjValue(formObj.result2, ComGetEtcData(sXml, "LOC"));
				ComSetObjValue(formObj.result3, ComGetEtcData(sXml, "CALC_TYPE"));
       		break;
       		
        	//Tariff Type and BKG. B/L NO. duplication Check	
        	case IBSEARCH_CHECK_DUP:
				//1.Enter all or selected query parameter set allows.
    			ComSetObjValue(formObj.f_cmd, SEARCH05);
				//2.Viewed as a query is run conditions
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.SetWaitImageVisible(0);
    			//*********************************************************************************
                var darNo=ComSearchEtcData(sheetObj, "EES_DMT_2009GS.do", FormQueryString(formObj), "DAR_NO");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After processing query results(Viewed the results on the grid allows you to map each result.)
				if (darNo != "")
					ComSetObjValue(formObj.result, "Y");	
				else
					ComSetObjValue(formObj.result, "N");
				ComSetObjValue(formObj.result2, darNo);
       		break;
       		
        	//Balance Charge Check
        	case IBSEARCH_CHECK_BALCHG:
				//1.Enter all or selected query parameter set allows.
    			ComSetObjValue(formObj.f_cmd, SEARCH06);
				//2.Viewed as a query is run conditions
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.SetWaitImageVisible(0);
    			//*********************************************************************************
                var result=ComSearchEtcData(sheetObj, "EES_DMT_2009GS.do", FormQueryString(formObj), "CHECK_BALCHG");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After processing query results(Viewed the results on the grid allows you to map each result.)
				ComSetObjValue(formObj.result, result);
       		break;
       		
        	//BKG No. Or B / L No. Charge before loading when entering sensitive information, BKG, B / L No. Make sure that(2009-09-30(Wed))
        	//2009-10-13(Tue) In the following module S / C No., RFA No. Compared with the value of a query to the top of the additional logic.
         	case IBSEARCH_CHECK_BKGNO:
         		//1.Enter all or selected query parameter set allows.
         		ComSetObjValue(formObj.f_cmd, COMMAND02);
         		with(sheetObj) {
					ComSetObjValue(formObj.bl_no, GetCellValue(iRow, BL_NO));
					ComSetObjValue(formObj.bkg_no, GetCellValue(iRow, BKG_NO));
         		}
         		//2.Viewed as a query is run conditions
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.SetWaitImageVisible(0);
    			//*********************************************************************************
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After processing query results(Viewed the results on the grid allows you to map each result.)
				var bkgNo=ComGetEtcData(sXml, "BKG_NO");
				var blNo=ComGetEtcData(sXml, "BL_NO");
				var scNo=ComGetEtcData(sXml, "SC_NO");
				var rfaNo=ComGetEtcData(sXml, "RFA_NO");				
				if (bkgNo != "") {
					//3-1.BKG No. or B / L No. Viewed as a S / C No. Or RFA No. Differ from the values ??in the lookup column is checked.============		
					if (ComGetObjValue(formObj.scNo) != "" && scNo != ComGetObjValue(formObj.scNo)) {
						ComSetObjValue(formObj.result, "N");
						//Check whether an error occurs in any condition known to give.(SC is set when the query does not match column with SC  No.)
						ComSetObjValue(formObj.result2, "SC");
						return;
					}
					else if (ComGetObjValue(formObj.rfaNo) != "" && rfaNo != ComGetObjValue(formObj.rfaNo)) {
						ComSetObjValue(formObj.result, "N");
						//Check whether an error occurs in any condition known to give.(RFA. is set when the query does not match column with RFA No.)
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
					//3-2.Views allow a reset to a value.
					with(sheetObj) {
						SetCellValue(iRow, BKG_NO, bkgNo, 0);
						SetCellValue(iRow, BL_NO,  blNo,  0);
					}
				}
				else {
					ComSetObjValue(formObj.result, "N");
					//Check whether an error occurs in any condition known to give.(space is set when BKG No., B/L No. does not match)
					ComSetObjValue(formObj.result2, "");	
				}
			break;
			
       		// Retrieving Booking Data of BKG No./ B/L No.
        	case IBSEARCH_BKG:
        		//1.Enter all or selected query parameter set allows.
    			ComSetObjValue(formObj.f_cmd, SEARCH02);
				//2.Viewed as a query is run conditions
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.SetWaitImageVisible(0);
    			//*********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After processing query results(Viewed the results on the grid allows you to map each result.)
				var frmSCNo=ComTrim(ComGetObjValue(formObj.scNo));
				var frmRFANo=ComTrim(ComGetObjValue(formObj.rfaNo));
				var srvSCNo=handleNullString(ComGetEtcData(sXml, "SC_NO"));
				var srvRFANo=handleNullString(ComGetEtcData(sXml, "RFA_NO"));		
				with(sheetObj) {
					if ((frmSCNo != "" && frmSCNo != srvSCNo) || (frmRFANo != "" && frmRFANo != srvRFANo)) {
						//3-1.Type BKG No. The S / C or RFA No. The top of the S / C or RFA No. Gives an error message pop up on inconsistencies and preventing.
						ComShowCodeMessage("DMT00159", GetCellValue(iRow, "Seq"));
						SetCellValue(iRow, BKG_NO, "", 0);
						SetCellValue(iRow, BL_NO,  "", 0);
						ComSetObjValue(formObj.result, 	"N");
						return;
					}
					else {
						//Viewed as the value of the result set Billable Amount per CNTR
						if (frmSCNo == "" && frmRFANo == "") {
							ComSetObjValue(formObj.scNo, 	svrSCNo);
							ComSetObjValue(formObj.rfaNo, 	srvRFANo);
							ComSetObjValue(formObj.custCd, 	handleNullString(ComGetEtcData(sXml, "CUST_CD")));
							ComSetObjValue(formObj.custNm, 	handleNullString(ComGetEtcData(sXml, "CUST_NM")));
						}
						SetCellValue(iRow, BKG_NO,  handleNullString(ComGetEtcData(sXml, "BKG_NO")),  0);
						SetCellValue(iRow, BL_NO,   handleNullString(ComGetEtcData(sXml, "BL_NO")),   0);
						SetCellValue(iRow, TVVD,    handleNullString(ComGetEtcData(sXml, "TVVD")),    0);
						SetCellValue(iRow, POR,     handleNullString(ComGetEtcData(sXml, "POR")),     0);
						SetCellValue(iRow, POL,     handleNullString(ComGetEtcData(sXml, "POL")),     0);
						SetCellValue(iRow, POD,     handleNullString(ComGetEtcData(sXml, "POD")),     0);
						SetCellValue(iRow, DEL,     handleNullString(ComGetEtcData(sXml, "DEL")),     0);
						SetCellValue(iRow, RD,      handleNullString(ComGetEtcData(sXml, "RD")),      0);
						SetCellValue(iRow, DG_FLG,  handleNullString(ComGetEtcData(sXml, "DG_FLG")),  0);
						SetCellValue(iRow, RF_FLG,  handleNullString(ComGetEtcData(sXml, "RF_FLG")),  0);
						SetCellValue(iRow, AK_FLG,  handleNullString(ComGetEtcData(sXml, "AK_FLG")),  0);
						SetCellValue(iRow, BB_FLG,  handleNullString(ComGetEtcData(sXml, "BB_FLG")),  0);
						SetCellValue(iRow, RD_FLG,  handleNullString(ComGetEtcData(sXml, "RD_FLG")),  0);
						SetCellValue(iRow, SOC_FLG, handleNullString(ComGetEtcData(sXml, "SOC_FLG")), 0);
						SetCellValue(iRow, CMDT_CD, handleNullString(ComGetEtcData(sXml, "CMDT_CD")), 0);
						SetCellValue(iRow, CMDT_NM, handleNullString(ComGetEtcData(sXml, "CMDT_NM")), 0);
						ComSetObjValue(formObj.result, "Y");
					}
				}
        	break;
        	
        	//Billable Amount per CNTR information is Viewed.
        	case IBSEARCH_CNTRCHG_BKG:
        		var sheetBKGObj=sheetObjects[0];
        		//1.Enter all or selected query parameter set allows.
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
					ComSetObjValue(formObj.aft_expt_dar_no,	 GetCellValue(iRow, DAR_NO));
					ComSetObjValue(formObj.aft_expt_adj_seq, GetCellValue(iRow, ADJ_SEQ));
        		}
				//2.Viewed as a query is run conditions
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.SetWaitImageVisible(0);
    			//*********************************************************************************
				var sXml = sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));

				//3.After processing query results(Viewed the results on the grid allows you to map each result.)
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1,Append:1});
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************    			
    			
				//3-1.After Booking information is viewed in the Container List information that is not registered, the default setting allows the value of KEY.(AS-IS If the data)
				setSequenceBKGContainer();
				
				//3-2.Check for the existence of Charge Container and allows them to set the flag value.
				if (fetchChargeRowCount() > 0) {
					//Seq No. Will be supplied sequentially.
					setCNTRSeq();  
					
					//After Exception Container Seq. Will be supplied sequentially.(because After Booking Charge after registration information to the query is generated  )
					setAfterBookingCNTRSeq();
					
					//If the entry does not exist, the Container EACH_CNTR_FLG 'N' is set to.
					sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), CNTR_FLG, "Y");
					
					//If an item does not exist Container CNTR will be activated.(2009-11-05(Thu))===============================
					sheetBKGObj.SetCellEditable(sheetBKGObj.SelectRow, CNTR_TP, isEnableGrid());
					//====================================================================================================
					
					//D/C AMT or Ratio Pre Cal., Reset Activate the button (2009-11-06(Fri)) ========================================
					ComBtnEnable("btn_PreCalc");
					ComBtnEnable("btn_Reset");
					//====================================================================================================					
				}
				else {
					//If the entry does not exist, the Container EACH_CNTR_FLG 'N' is set to.
					sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), CNTR_FLG, "N");
					
					//Container CNTR If an item does not exist, the 'All' is automatically set to be disabled.(2009-11-05(Thu))===========
					sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), 	CNTR_TP, "S", 0);
					sheetBKGObj.SetCellEditable(sheetBKGObj.GetSelectRow(), CNTR_TP, 0);
					//====================================================================================================
					
					//D/C AMT or Ratio Pre Cal., Reset Disable button (2009-11-06(Fri)) ======================================
					ComBtnDisable("btn_PreCalc");
					ComBtnDisable("btn_Reset");
					//====================================================================================================					
				}

				//3-3.Quantity Set
				ComSetObjValue(formObj.cntrQty, getChargeQuantity());
    			
				//3-4.Cur. setting(Currency of the retrieved Billable Amount per CNTR changes to show the first item)
				//         Booking for one even if there are multiple Container Currency is all the same.
				ComSetObjValue(formObj.curr, getCurrency());
				
				//3-5.Container Billable Amount is calculated on the Total Information.
				sumBillableAmount();
				
				//3-6.BKG Container list by checking the result of the Charge Detail per BKG GRID that has to be set.
				//	     So that duplicate data through re times can prevent the manifestation in the GRID.
				sheetBKGObj.SetCellValue(sheetBKGObj.GetSelectRow(), SRCH_FLG, "Y");	
       		break;
       		
        	//Comment History information is Viewed.
        	case IBSEARCH_COMM:
        		var sheetBKGObj=sheetObjects[0];
        		var sheetHSTObj=sheetObjects[2];
        		//1.Enter all or selected query parameter set allows.
        		//  BKG data lookup, because the parameters that were used to accept no further need to establish
        		ComSetObjValue(formObj.f_cmd, SEARCH03);
        		//2.Before mapping the query results makes relevant controls Clear.
        		sheetHSTObj.RemoveAll();
        		with(formObj) {
        			ComSetObjValue(formObj.comment, "");
        			chkComment.checked=false;
        		}
        		//3.Viewed as a query is run conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				//sheetObj.DoSearch("EES_DMT_2009GS.do", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));

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
			
			//DAR will generate new information.
        	case IBSEARCH_DAR:
				//1.DAR No. Request ago, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.f_cmd, SEARCH07);
				//2.Running modified input conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
                var result=ComSearchData(sheetObj, "EES_DMT_2009GS.do", FormQueryString(formObj), "DAR");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After processing query results(Retrieved results to the grid allows you to map each result.)
				ComSetObjValue(formObj.result, result);        		
       		break;
       		
        	case IBSAVE:        //saving
				//1.Enter all or selected query parameter set allows.
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
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd,	"R");
				ComSetObjValue(formObj.apro_ofc_cd, 			ComGetObjValue(formObj.approvalOfcCd));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment));				
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				sParam += "&" + FormQueryString(formObj);
				//2.Running store
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
                var sXml=sheetObj.GetSaveData("EES_DMT_2009GS.do", sParam);
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
				if (isPopupWindow()) {
					ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
				}
			break;
			
			case IBSAVE_CANCEL:
				//1.Delete all or selected set to the value of the input parameters allows.
				ComSetObjValue(formObj.f_cmd, 					SEARCH08);
				ComSetObjValue(formObj.aft_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"C");
				if (!formObj.chkComment.checked) {
					ComSetObjValue(formObj.prog_rmk, 			"");
				}
				else {
					ComSetObjValue(formObj.prog_rmk, 			ComGetObjText(formObj.comment));
				}
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				//2.Delete the selected running conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After deleting the result handle
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				if (isPopupWindow()) {
					ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
				}
			break;
			
			case IBSAVE_APPROVAL:
				//1.Approval to enter all the parameters, or set to allow selected.
				ComSetObjValue(formObj.f_cmd, 						COMMAND01);
				ComSetObjValue(formObj.aft_expt_dar_no, 			ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 		"A");
				ComSetObjValue(formObj.prog_rmk, 					ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 					isPopupWindow() ? "Y" : "N");
				//After the approval process required parameters in order to send mail
				ComSetObjValue(formObj.sc_no, 						ComGetObjValue(formObj.scNo));
				ComSetObjValue(formObj.rfa_no, 						ComGetObjValue(formObj.rfaNo));
				ComSetObjValue(formObj.bl_no, 						fetchAllBLNo());
				ComSetObjValue(formObj.cust_cd, 					ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 					ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, 	"Approved");
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
				sParam += "&" + FormQueryString(formObj);
				//2.Run to the approval process for selected conditions(handling by Back End Job)
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
                var sXml=sheetObj.GetSaveData("EES_DMT_2009GS.do", sParam);
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
				var jobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (jobKey.length > 0) {
					ComSetObjValue(formObj.job_key, jobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					//After three seconds, the execution of a function getBackEndJobStatus - Recursion
					timer=setInterval(getBackEndJobStatus, 3000);
				}
			break;
			
			case IBSAVE_COUNTEROFFER:
				//1.CounterOffer all parameters set to the value of the selected input or allow.
				//ComSetObjValue(formObj.f_cmd, 					COMMAND01); //SEARCH10
				ComSetObjValue(formObj.aft_expt_dar_no, 			ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 		"O");
				ComSetObjValue(formObj.prog_rmk, 					ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 					isPopupWindow() ? "Y" : "N");
				//Counter Offer after processing parameters required to send mail
				ComSetObjValue(formObj.sc_no, 						ComGetObjValue(formObj.scNo));
				ComSetObjValue(formObj.rfa_no, 						ComGetObjValue(formObj.rfaNo));
				ComSetObjValue(formObj.bl_no, 						fetchAllBLNo());
				ComSetObjValue(formObj.cust_cd, 					ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 					ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, 	"Counter Offered");
				if(ComGetObjValue(formObj.apvlNo) == '') {
					ComSetObjValue(formObj.f_cmd,	SEARCH10);
					//2.Run the selected conditions COUNTER OFFER
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
                    var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					//3.After processing the results COUNTER OFFER
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
						ComSetObjValue(formObj.result, "Y");
					}
					else {
						ComSetObjValue(formObj.result, "N");
					}
					if (isPopupWindow()) {
						ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
					}
				} else {
					ComSetObjValue(formObj.f_cmd,	COMMAND01);
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
					sParam += "&" + FormQueryString(formObj);
					//2.Run to the approval process for selected conditions(handling by Back End Job)
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
                    var sXml=sheetObj.GetSaveData("EES_DMT_2009GS.do", sParam);
					var jobKey=ComGetEtcData(sXml, "BackEndJobKey");
					if (jobKey.length > 0) {
						ComSetObjValue(formObj.job_key, jobKey);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.SetWaitTimeOut(10000);
						//After three seconds, the execution of a function getBackEndJobStatus - Recursive call
						timer=setInterval(getBackEndJobStatus, 3000); 
					}
				}
			break;
			
			case IBSAVE_REJECT:
				//1.Reject all parameters set to the value of the selected input or allow.
				//ComSetObjValue(formObj.f_cmd, 					COMMAND01); //SEARCH11
				ComSetObjValue(formObj.aft_expt_dar_no, 			ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 		"J");
				ComSetObjValue(formObj.prog_rmk, 					ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 					isPopupWindow() ? "Y" : "N");
				//Reject mail sent after processing parameters required to
				ComSetObjValue(formObj.sc_no, 						ComGetObjValue(formObj.scNo));
				ComSetObjValue(formObj.rfa_no, 						ComGetObjValue(formObj.rfaNo));
				ComSetObjValue(formObj.bl_no, 						fetchAllBLNo());
				ComSetObjValue(formObj.cust_cd, 					ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 					ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, 	"Rejected");
				if(ComGetObjValue(formObj.apvlNo) == '') {
					ComSetObjValue(formObj.f_cmd,	SEARCH11);
					//2.REJECT selected running conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
                    var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					//3.After processing the results REJECT
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
						ComSetObjValue(formObj.result, "Y");
					}
					else {
						ComSetObjValue(formObj.result, "N");
					}
					if (isPopupWindow()) {
						ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
					}
				} else {
					ComSetObjValue(formObj.f_cmd,	COMMAND01);
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
					sParam += "&" + FormQueryString(formObj);
					//2.Run to the approval process for selected conditions(handling by Back End Job)
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
                    var sXml=sheetObj.GetSaveData("EES_DMT_2009GS.do", sParam);
					var jobKey=ComGetEtcData(sXml, "BackEndJobKey");
					if (jobKey.length > 0) {
						ComSetObjValue(formObj.job_key, jobKey);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.SetWaitTimeOut(10000);
						//After three seconds, the execution of a function getBackEndJobStatus - Recursive call
						timer=setInterval(getBackEndJobStatus, 3000); 
					}
				}
			break;
        }
    }
    
    /**
     *  doActionIBCombo
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
			//Tariff Type call
			case IBSEARCH:
				//1.Enter all or selected query parameter set allows.
				setCommonParameters(sheetObj,sComboAction,sComboKey);
				//2.Viewed as a query is run conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				//3.After processing query results
				var comboDatas;
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
				ComOpenWait(false);
				//*********************************************************************************
				break;
				//3-3.User log in on the Security EES_DMT_2009 (DAR-After BKG Approval) of the Access permissions are views that.
			case IBSEARCH_CHECK_ROLE:
				//1.Enter all or selected query parameter set allows.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//2.Viewed as a query is run conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Processing the query results
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));
				break;					
        }
		sheetObj.SetWaitImageVisible(1);
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
     * grid data in the field adds a combo.
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
			sheetObj.CellComboItem(sRow,colName, {ComboText:comboTxt, ComboCode:comboVal});
		}
		else {
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
     * Screen form validation process for processing the input values
     */
    function validateForm(sheetObj, formObj, sAction) {
 		with (sheetObj) {
	 		for (var row=HeaderRows(); row <= LastRow(); row++) {
	 			//Enter or modify data is validated only for.
	 			if (GetRowStatus(row) == "I" || GetRowStatus(row) == "U") {
	 				//1. in case of that there is a required field.
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
			    	//BKG will check the validity of the data.
			    	if (GetCellValue(row, CNTR_TP) == "S") {
				    	//2.Free Time or D / C Amount, D / C Ratio input is not one of "Free Time or D / C Amount / Ratio is mandatory!" Alert blocking window showing
				    	//2-1.2009-10-07 change : Free Time column of the Y and D / C Amount / Ratio check both the Y column is not mandatory to show an error message 
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
			    		//2-2.D / C Amount or Ratio input Cur. Select the required(AMT input Cur. The input conditions required, Ratio in the Cur. Unnecessary)
			    		if (GetCellValue(row, DCAR_FLG) == 1 && GetCellValue(row, DCAR_CURR) == "" && GetCellValue(row, DCAR_AMT) != "") {
			    			ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "CUR");
			    			return false;			    			
			    		}
				    	//3.Add Day and Total in Free Time, if both "Only one of Add day or Total day can be input" Alert Window showing blocking
			    		if (GetCellValue(row, ADD_DYS) != "" && GetCellValue(row, TTL_DYS) != "") {
			    			ComShowCodeMessage("DMT02004", GetCellValue(row, "Seq"));
				    		return false;
				    	}
				    	//4.D / C Amount or Ratio is entered in the case both "Only one of D / C Amount or Ratio can be input" Alert Window showing blocking
			    		if (GetCellValue(row, DCAR_AMT) != "" && GetCellValue(row, DCAR_RTO) != "") {
			    			ComShowCodeMessage("DMT02012", GetCellValue(row, "Seq"));
				    		return false;
				    	}
			    	}
			    	//Billable Amount per CNTR all of the data to check the validity of.
			    	else {
			    		if (!validateChargeContainer(row, sAction)) {
			    			return false;
			    		}
			    	}
			    	//5.That BKG / B / L No. Tariff Type of the Calculation Type is not correct. "Calculation Type discrepancy! [Location Code] - [Dual]" Alert Window showing blocking
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
			    	//6.Tariff Type and BKG or B / L No. Preventing duplication Alert window showing the overlap
			    	//  Double check the lookup column DAR No. If you do not have (ie, if singyuipryeokil) only chekeuham.
			    	//  Redundancy check gives the parameters needed to set up.
			    	ComSetObjValue(formObj.bkg_no, GetCellValue(row, BKG_NO));
			    	ComSetObjValue(formObj.bl_no, GetCellValue(row, BL_NO));
			    	ComSetObjValue(formObj.tariff, GetCellValue(row, TARIFF));
			    	if (ComTrim(ComGetObjValue(formObj.darNo)) == "") {
				    	if (checkDupTariffBKGBLNo(sheetObj,formObj)) {
				    		ComShowCodeMessage("DMT00155", GetCellValue(row, "Seq"), ComGetObjValue(formObj.result2));
				    		return false;
				    	}
			    	}
	 			} else { // GetRowStatus(row) == "R"
	 				if (GetCellValue(row, CNTR_TP) != "S") {
		 				if (!validateChargeContainer(row, sAction)) {
				    		return false;
				    	}
	 				}
	 			}
	 		} // for - end
 		} // with - end
		//6.Check the logic adds redundant data(2009-07-28)
		if (!dupValidate(sheetObj)) return false;
		//8.Comment input letter length Check(2009-09-16)
		//  Comment is required in case of Request!!
		if (!validateComment()) return false;
 		return true;
    }
  	/**
  	 * That BKG / B / L No. Container of Free Time and clearly. D / C Amount or Ratio Check input to perform the essential functions
  	 */	    
    function validateChargeContainer(selectedRow, sAction) {
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1];
     	with(sheetBKGObj) {
var adjSeq=GetCellValue(selectedRow, ADJ_SEQ);
var seqNo=GetCellValue(selectedRow, "Seq");		// top BKG Grid Seq
     		//Charge information screen, if loaded, ie, Charge information does not provide Validation has not been changed.
if (GetCellValue(selectedRow, SRCH_FLG) != "Y") return true;
     	}
     	var formObj=document.form;
     	var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
    	var isCheckCnt=0;
    	//Charge a minimum of 1 or later is input validation pass
    	with(sheetCNTRObj) {
     		for (var row=HeaderRows(); row <= LastRow(); row++) {
if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
var bkgCntrSeqNo=seqNo + '-' + GetCellValue(row, "Seq");
     				// 2010-07-02 add
					var roleAuth=ComGetObjValue(formObj.role_auth);
if (GetCellValue(row, FT_FLG) == "1") {
     					// 2010-06-09 add
     					if(sAction == IBSAVE_APPROVAL) {
     						// 2010-07-02 edit
if(roleAuth == "DMT03" && (usrOfcCd == GetCellValue(row, OFC) || usrOfcCd == GetCellValue(row, PRNT_OFC)) ) {
    	     					// pass
    	     				} else if( roleAuth == "DMT01" || roleAuth == "DMT02" ) {
    	     					// pass
     						} else {
    	     					ComShowCodeMessage("DMT03071", bkgCntrSeqNo);
    					    	return false;
    	     				}
         				}
if (GetCellValue(row, ADD_DYS) == "" && GetCellValue(row, TTL_DYS) == "") {
     						ComShowCodeMessage("DMT00108", bkgCntrSeqNo, "Free Time");
     						return false;    
     					}
else if (GetCellValue(row, ADD_DYS) != "" && GetCellValue(row, TTL_DYS) != "") {
 				    		ComShowCodeMessage("DMT02004", bkgCntrSeqNo);
 				    		return false;    						
     					}
   						isCheckCnt++;
     				}
if (GetCellValue(row, AR_FLG) == "1") {
     					// 2010-06-09 add
     					if(sAction == IBSAVE_APPROVAL) {
     						// 2010-07-02 edit
if(roleAuth == "DMT03" && (usrOfcCd == GetCellValue(row, OFC) || usrOfcCd == GetCellValue(row, PRNT_OFC)) ) {
    	     					// pass
    	     				} else if( roleAuth == "DMT01" || roleAuth == "DMT02" ) {
    	     					// pass
     						} else {
    	     					ComShowCodeMessage("DMT03071", bkgCntrSeqNo);
    					    	return false;
    	     				}
         				}
if (GetCellValue(row, DCAR_CURR) == "" && GetCellValue(row, AR_AMT) != "") {
     						ComShowCodeMessage("DMT00108", bkgCntrSeqNo, "CUR");
     						return false;     						
     					}     					
else if (GetCellValue(row, AR_AMT) == "" && GetCellValue(row, AR_RTO) == "") {
     						ComShowCodeMessage("DMT00108", bkgCntrSeqNo, "D/C Amount or Ratio");
     						return false;
     					}
else if (GetCellValue(row, AR_AMT) != "" && GetCellValue(row, AR_RTO) != "") {
     			    		ComShowCodeMessage("DMT02012", bkgCntrSeqNo);
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
  	 * Duplicate Tariff, BKG No., B / L No. With a function that checks whether the data is
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
 	 * That BKG No. Or B / L No. Tariff Type of function to check the correct Calculation Type
 	 */	
    function checkCalcuationType(sheetObj, formObj) {
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_CALC);
    	return ComGetObjValue(formObj.result) == "Y" ? true : false; 
    }
   	/**
  	 * BKG No. Or B / L No. Charge before loading when entering sensitive information, BKG, B / L No. Check if the function
  	 */	
     function checkTariffBKGBLNo(sheetObj, formObj) {
      	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_BKGNO);
      	return ComGetObjValue(formObj.result) == "Y" ? true : false;
     }
 	/**
	 * Tariff Type and BKG or B / L No. Duplication of functions to check whether
	 */	
    function checkDupTariffBKGBLNo(sheetObj, formObj) {
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_DUP);
    	return ComGetObjValue(formObj.result) == "Y" ? true : false;
    }
 	/**
	 * Balance Charge function to check for the existence of the CNTR in
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
					//1-1.If the input BKG_NO B / L No. To query.
					if (ComTrim(GetCellValue(GetSelectRow(), BKG_NO)) == "") return;
					if (!checkBKGBLNo(BKG_NO)) return;
					//1-2.Tariff has not been entered, the query does not perform.
					if (ComTrim(GetCellValue(GetSelectRow(), TARIFF)) == "") return;
					//1-3.Tariff and BKG No. Charge Detail information corresponding to the query should be executed.
					searchContainerByTariffBKGNo();					
				break;
				
				//2.BKG No. If the BKG has been changed to look up information.
				case BL_NO:
					//2-1.B / L No. If the input BKG No. To query.
					if (ComTrim(GetCellValue(GetSelectRow(), BL_NO)) == "") return;
					if (!checkBKGBLNo(BL_NO)) return;
					//2-2.Tariff has not been entered, the query does not perform.
					if (ComTrim(GetCellValue(GetSelectRow(), TARIFF)) == "") return;
					//2-3.Tariff and BKG No. Charge Detail information corresponding to the lookup is performed.
					searchContainerByTariffBKGNo();
				break;
				
				//3.Tariff has been changed to look up information if the BKG.
				case TARIFF:
					//3-1.Blank if the selected Tariff does not perform a lookup.
					if (ComTrim(GetCellValue(GetSelectRow(), TARIFF)) == "") return;
					//3-2.BKG No, B / L No. If you have not entered the query does not perform.
					if (ComTrim(GetCellValue(GetSelectRow(), BKG_NO)) == "" && ComTrim(GetCellValue(GetSelectRow(), BL_NO)) == "") return;
					//3-3.Tariff and BKG No. Charge Detail information corresponding to the lookup is performed.
					searchContainerByTariffBKGNo();
				break;
				
				//Depending on CNTR Free Time, F / Time EXCL, D / C Amount or Ratio is activated or inactivated.
				//Argument indicates whether to delete the values ??that exist at disabled.
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
				
				//D / C Amount or Ratio Y if the check or disarmed
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
	 * When it is selected BKG Row Row Conditions will change the state.
	 */	
	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj=document.form;
		var sheetCNTRObj=sheetObjects[1];
		//This function is invoked through the ROW COPY If you do not perform the following logic.
		if (isDataCopy) return;
		//Row selected whenever there is a change in position to perform the following logic.
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
				//Free Time Y, if the check or unchecked
				case FT_FLG:
					if (Value == 1) {
						editableCNTRFreeTime(Row, true);
					}
					else {
						editableCNTRFreeTime(Row, false);
					}
				break;
				
				//D / C Amount or Ratio Y if the check or unchecked
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
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		if (OldRow >= sheetObj.HeaderRows() && OldRow != NewRow) {
			if (!formObj.chkComment.checked) {
				ComSetObjValue(formObj.comment, sheetObj.GetCellValue(NewRow, PROG_RMK));
			}
		}		
	}
   /**
	* Tariff or BKG No. After Booking DAR when a change in the applicable Charge Detail function to retrieve information
	*/	 	
	function searchContainerByTariffBKGNo() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		var tariff="";
		var cntCd="";
		var iRow=sheetBKGObj.GetSelectRow();
		with(sheetBKGObj) {
			tariff=GetCellValue(iRow, TARIFF);
			//1-1.Calculation Type Check to set the parameters for.
			ComSetObjValue(formObj.bkg_no, GetCellValue(iRow, BKG_NO));
			ComSetObjValue(formObj.bl_no, GetCellValue(iRow, BL_NO));
			ComSetObjValue(formObj.tariff, GetCellValue(iRow, TARIFF));
			//1-2.That BKG No. Tariff Type of the Calculation Type checking is performed correct.
	    	if (!checkCalcuationType(sheetBKGObj,formObj)) {
	    		if (ComGetObjValue(formObj.result3) == "C") {
	    			ComShowCodeMessage("DMT00132", GetCellValue(iRow, "Seq"), ComGetObjValue(formObj.result2));
	    		}
	    		else if (ComGetObjValue(formObj.result3) == "D") {
	    			ComShowCodeMessage("DMT02003", GetCellValue(iRow, "Seq"), ComGetObjValue(formObj.result2));
	    		}
	    		SetCellValue(iRow, TARIFF,"",0);
	    		return false;
	    	}
			//1-3.Tariff Type and BKG Check if a duplicate.
	    	if (checkDupTariffBKGBLNo(sheetBKGObj,formObj)) {
				ComShowCodeMessage("DMT00155", GetCellValue(iRow, "Seq"), ComGetObjValue(formObj.result2));
				SetCellValue(iRow, TARIFF,"",0);
	    		return false;
	    	}
		}
    	//1-4.Type BKG No. Booking Data to be viewed in.
		doActionIBSheet(sheetBKGObj,formObj,IBSEARCH_BKG);
    	//BKG No., B/L No. 에 해당되는 데이터가 없다면 종료
    	if (ComGetObjValue(formObj.result) == "N") return;
    	//1-5.Type BKG No. Charge Detail per BKG of information is Viewed.
    	//    Lookup a Charge Detail per BKG After Booking before reading from the set makes you want to read in Charge Calculation
    	//		(in this case reads in Charge Calculation. 2009-11-02)
    	ComSetObjValue(formObj.is_aft_bkg_cntr, "N");
		doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);
		//1-6.The entire CNTR A / RI / F looks Alert window check if it is requested.
		if (checkARIFAllContainer()) {
			if (!ComShowCodeConfirm("DMT00167")) {
				//Booking information and referrals to delete all information Charge.
				removeBookingChargeData();
				return;
			}
		}
    	//1-7.View-BKG No., B / LL No., Tariff Prevents users from modifying the change.
		disableKeyColumn(iRow);
    	//1-8.Currency to be viewed.
    	with(sheetBKGObj) {
			switch(tariff) {
				case "DMIF": 
					cntCd=GetCellValue(iRow, POD).substring(0, 2);
				break;
				
				case "DMOF": 
					cntCd=GetCellValue(iRow, POL).substring(0, 2);
				break;
				
				case "DTIC":
				case "CTIC":
					cntCd=GetCellValue(iRow, DEL).substring(0, 2);
				break;
				
				case "DTOC":
				case "CTOC":
					cntCd=GetCellValue(iRow, POR).substring(0, 2);
				break;
			}
    	}
    	ComSetObjValue(formObj.cnt_cd, cntCd);
   		doActionIBCommon(sheetBKGObj,formObj,IBSEARCH,COMMAND05,DCAR_CURR);
		//1-9.Depending on CNTR Free Time, F / Time EXCL, D / C Amount or Ratio is activated or inactivated.
   		//    (Argument indicates whether to delete the values ??that exist at disabled)
		modifyModeFreeTimeAmountorRatio(false);  		
	}
	/**
	 * Free Time Y column, check or provide all the relevant year is to set the activation function of the column
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
			//Grid is active only if you choose to be entered in each field can be.
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
	 * Billable Amount per CNTR Free Time Y columns of the check or provide all the relevant year is to set the activation function of the column
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
			//Grid is active only if you choose to be entered in each field can be.
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
	 * D / C Amount or Ratio Y column, check or provide all the relevant year is to set the activation function of the column
	 */
	function editableDCAmountRatio(row, flg) {
		var sheetBKGObj=sheetObjects[0];
		with(sheetBKGObj) {	
			if (!flg) {
				SetCellValue(row, DCAR_CURR,"",0);
				SetCellValue(row, DCAR_AMT,"",0);
				SetCellValue(row, DCAR_RTO,"",0);
			}
			//Grid is active only if you choose to be entered in each field can be.
			if (isEnableGrid()) {
				SetCellEditable(row, DCAR_CURR,flg);
				SetCellEditable(row, DCAR_AMT,flg);
				SetCellEditable(row, DCAR_RTO,flg);
			}
		}			
	}
	/**
	 * D / C Amount or Ratio Y column, check or provide all the relevant year is to set the activation function of the column
	 */
	function editableCNTRDCAmountRatio(row, flg) {
		var sheetCNTRObj=sheetObjects[1];
		with(sheetCNTRObj) {	
			if (!flg) {
				SetCellValue(row, DCAR_CURR,"",0);
				SetCellValue(row, AR_AMT,"",0);
				SetCellValue(row, AR_RTO,"",0);
			}
			//Grid is active only if you choose to be entered in each field can be.
			if (isEnableGrid()) {
				SetCellEditable(row, DCAR_CURR,flg);
				SetCellEditable(row, AR_AMT,flg);
				SetCellEditable(row, AR_RTO,flg);
			}
			//If Y, CUR checked if any of its value in the value of the items currently checked fills it with CUR.
			if (flg) {
			    var iRow=GetSelectRow();
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					if (row != iRow&& GetRowStatus(row) != "D" && GetCellValue(row, DCAR_CURR) != "") {
						SetCellValue(iRow, DCAR_CURR,GetCellValue(row, DCAR_CURR),0);
						break;
					}
				}
			}			
		}			
	}
	/**
	 * Select the value of the data according to BKG CNTR CNTR part of the data columns to show or hide much of the functions which operate
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
					SetCellValue(row, FT_FLG,  0);
					SetCellValue(row, ADD_DYS, "");
					SetCellValue(row, TTL_DYS, "");
					SetCellValue(row, SAT_FLG, 0);
					SetCellValue(row, SUN_FLG, 0);
					SetCellValue(row, HOL_FLG, 0);
					SetCellValue(row, AR_FLG,  0);
					SetCellValue(row, AR_AMT,  "");
					SetCellValue(row, AR_RTO,  "");
				}
			}
		}
	}
	/**
	 * Select the value of the data according to BKG CNTR CNTR Free Time for all of the data column and the Y Amount or Ratio column to check the behavior of the function Y
	 */		 
	function checkContainerColumn(selectRow) {
		var sheetBKGObj=sheetObjects[0];		
		var sheetCNTRObj=sheetObjects[1];
var adjSeq=sheetBKGObj.GetCellValue(selectRow, ADJ_SEQ);
		with(sheetCNTRObj) {		
			for (var row=LastRow(); row >= HeaderRows(); row--) {
if (adjSeq == GetCellValue(row, ADJ_SEQ)) {
					//G / B if you have a Balance Free Time, F / Time EXCL, D / C Amount or Ratio can not enter
if (GetCellValue(row, GB) == "B") {
						//Clears the value of the column with unchecked.						
SetCellValue(row, FT_FLG,0);
SetCellValue(row, AR_FLG,0);
						//Deactivate the status of the column.
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
    
    
    function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
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
    * Row Add button is clicked, if need to run a function that defines the behavior of
    */		
    function doActionAddADJAfterBKG() {
    	var formObj=document.form;
    	var sheetBKGObj=sheetObjects[0];
    	// When you add data, sheet1_OnSelect function is invoked automatically, 
    	// in this case, BKG DAR information for the CNTR CNTR GRID and adding it to re-query problem, 
    	// which to solve this problem, the following variables are set to TRUE.
    	isDataCopy=true;
    	with(sheetBKGObj) {
    		var iRow=DataInsert(-1);
    		//Queried if the state is to add in the ROW DAR No. And adds.
    		if (LastRow()> HeaderRows()&& GetCellValue(HeaderRows(), DAR_NO) != "") {
    			SetCellValue(iRow, DAR_NO,GetCellValue(HeaderRows(), DAR_NO));
    		}    		
    		//Empty by default columns sikyeojunda Tariff.
    		//Adds an empty space.(Default in the blank, User Selection) 2009-09-30(Wed) add.
    		SetCellValue(iRow, TARIFF,"");
    		//CUR is set to blank.
    		SetCellValue(iRow, DCAR_CURR,"");
    		//Ratio of the '%' symbol is added.
    		SetCellValue(iRow, DCAR_RTO2,"%");
    		//Billable Amount per CNTR lookup query to store the value that the state flag
    		SetCellValue(iRow, SRCH_FLG,"N");
    		//ADJ_SEQ adds value.
    		SetCellValue(iRow, ADJ_SEQ,fetchNextADJSeq());
    	}
    	isDataCopy=false;
    	//Charge Detail per BKG copied row of data processing, so no data is not to show.
    	showBillableAmountPerCNTR(); 
    	//BKG due to changes in the selected row of Charge Detail per BKG CNTR Q'ty, Cur., Total Billable AMT data gives clear.
    	clearChargeDetailTopInfo();
     	//Restoring color of calculated column.
     	changeCalcColumn(false);
     	//Additional Charge Detail per BKG at Row because no data is D / C AMT or Ratio Pre Cal., Reset button disabled
     	//D/C AMT or Ratio Pre Cal., Reset button disabled (2009-11-06(Fri)) ========================================
     	ComBtnDisable("btn_PreCalc");
     	ComBtnDisable("btn_Reset");
     	//====================================================================================================     	
    }
   /**
    * If you need to run the Delete button is clicked the function that defines the behavior of
    */		
    function doActionDelADJAfterBKG() {
    	var formObj=document.form;    	
    	var sheetBKGObj=sheetObjects[0];
    	with(sheetBKGObj) {
	    	if (GetSelectRow()>= HeaderRows()) {
				//Delete information allows Billable Amount per CNTR.
				doActionDelADJAfterBKGContainer(GetSelectRow());
				if (GetRowStatus(GetSelectRow()) == 'I') {
					RowDelete(GetSelectRow(), false);
				}
				else {
					SetRowStatus(GetSelectRow(),'D');
					GetRowHidden(SetSelectRow())(1);
				}
				//1.Be deleted and then automatically selects a row and then find the row.
				var row=fetchSelectedNextRow(GetSelectRow());
				//1-1.If the rows show
				if (row != -1) {
					SetSelectRow(row);
					displayChargeDetailperBKG(row);
				}				
		     	//Restoring color of calculated column.
		     	changeCalcColumn(false);
		 		//All information is deleted After Booking S / C No., RFA No., Customer Information Removes gives.
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
    * If data is deleted BKG also delete its sub-Container that handles the function information
    */	    
    function doActionDelADJAfterBKGContainer(selectRow) {
    	var formObj=document.form;
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1];
var adjSeq=sheetBKGObj.GetCellValue(selectRow, ADJ_SEQ);
var status=sheetBKGObj.GetRowStatus(selectRow);
 		//Charge Header information delete
 		ComClearObject(formObj.cntrQty);
 		ComClearObject(formObj.curr);
 		ComClearObject(formObj.totalBillAmt);
    	with(sheetCNTRObj) {
    		for (var row=LastRow(); row >= HeaderRows(); row--) {
if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
if (GetRowStatus(row) == "I" || status == "I") {
    					RowDelete(row, false);
    				}
    				else {
SetRowStatus(row,'D');
    					SetRowHidden(row,1);
    				}
    			}
    		}
    	}
    }
    /**
     * D / C AMT or Ratio Per Cal. Need to run when the button is clicked the function that defines the behavior of
     */	    
     function doActionPreCalc() {
     	var formObj=document.form;
     	var sheetBKGObj=sheetObjects[0];
     	var sheetCNTRObj=sheetObjects[1];
     	//If you have already clicked the state takes care not to click.
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
     	//CNTR two 'All' is selected as if, BKG entered in the D / C Amount or Ratio Ratio of the AMT, or copy it to the Charge Container.
     	if (cntrTp == "S") {
     		copyDCAmountOrRatioToChargeContainer();
     	}
     	with(sheetCNTRObj) {
     		for (var row=HeaderRows(); row <= LastRow(); row++) {
if (GetRowStatus(row) != "D" && GetRowHidden(row) == false && adjSeq == GetCellValue(row, ADJ_SEQ)) {
     				//D / C AMT or Ratio Pre Cal. Only for items checked below to perform logic.(2009-11-05 Thu)
if (dcArFlg == 1 || GetCellValue(row, AR_FLG) == 1) {
if (GetCellValue(row, GB) == "G") {
if (GetCellValue(row, AR_AMT) == "" && GetCellValue(row, AR_RTO) == "") {
 	    	     				//D / C AMT, Ratio If no value is entered in the "Pls input D / C Amount or Ratio" Alert Window showing blocking (2009-10-07(Wed))
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
 	    	     				//D / C AMT, Ratio Both are entered in the Alert window, showing if the blocking (2009-11-04(Wed))
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
 	    					// 2010-05-31 edit
bilAmt=GetCellValue(row, BIL_AMT) - GetCellValue(row, BIL_AMT) * disRto / 100;
	    					bilAmt=ComRound(bilAmt, 2);
 	    				}
 	    				else {
bilAmt=GetCellValue(row, BIL_AMT);
 	    				}
 	    				//Billable AMT always yisangyieoyaham 0.00. In other words, the amount must not be minus (2009-11-04(수))
 	    				bilAmt=bilAmt >= 0 ? bilAmt : 0;
SetCellValue(row, BIL_AMT,bilAmt);
     				}
     				// 2010-05-25 edit
total=total + parseFloat(GetCellValue(row, BIL_AMT));
     			}
     		} // for - end
     	} // with - end
     	// 2010-05-25 add
    	total=ComRound(total, 2);
     	ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
     	//Calculation of a button and complete the calculation of the column will change color to red.
     	changeCalcColumn(true);
     	//CNTR two 'All' is selected as if, BKG entered in the D / C Amount or Ratio Ratio of the AMT, or delete the information is copied to Charge Container.
     	if (cntrTp == "S") {
     		removeDCAmountOrRatioToChargeContainer();
     	}      	
     }
    /**
     * If you need to run the Reset button is clicked the function that defines the behavior of
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
     				//2010-05-25 edit
     				total=total + parseFloat(GetCellValue(row, BIL_AMT));
     			}
     		}
     	}
     	//Total Billable Amount setting allows to obtain the sum.
     	ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
     	//Restoring color of calculated column.
     	changeCalcColumn(false);     	
     }      
    /**
     * If you do run the Retrieve button is clicked the function that defines the behavior of
     */		
    function doActionRetrieve() {
     	var formObj=document.form;    	 
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1];
    	var sheetHSTObj=sheetObjects[2];
    	
     	//Restoring color of calculated column before retrieving.
     	changeCalcColumn(false);
    	//check the required input lookup.(DAR No. Or APVL No. If "Please enter DAR No. Or APVL No." Alert windows show)
    	with(formObj) {
    		if (ComTrim(ComGetObjValue(darNo)) == "" && ComTrim(ComGetObjValue(apvlNo)) == "") {
    			ComShowCodeMessage("DMT00166");
    			ComSetFocus(darNo);
    			return;
    		}
    	}
    	
    	//After Booking DAR registered information is viewed. 
    	doActionIBSheet(sheetBKGObj,formObj,IBSEARCH);
		//--------------------------------------------------------------------
    	currAdjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		//--------------------------------------------------------------------
    	with(sheetBKGObj) {
			//3.After Booking Adjustment Request queried if there is to look up a list of Container and Comment History.
			if (RowCount()> 0) {
				//3-1.This refers to the Container List.
		    	//    Lookup a Charge Detail per BKG Before After Booking you want to read on the set makes you want to read in Charge Calculation.
				//		(After Booking in this case reads. 2009-11-02)
				
		    	ComSetObjValue(formObj.is_aft_bkg_cntr, "Y");
				doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);
				//3-2.If you are a privileged DMT03 Approval, Counter Offer, Reject sure you have permission to query.
				if (ComGetObjValue(formObj.role_auth) == "DMT03")
					check03RoleAuth();
				//3-3.Status is blank or, Counter Offered Grid only activated state
				enableGrid(isEnableGrid());
				//3-4.Depending on CNTR Free Time, F / Time EXCL, D / C Amount or Ratio is activated or inactivated.
				//    (Argument indicates whether to delete the values ​​that exist at disabled)
				modifyModeFreeTimeAmountorRatio(false);
				
				//3-5.Comment History list is viewed.
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
    	//4.Row queried the status of all changes to a state allows read-.
    	for (var sheetNo=0 ; sheetNo < 2 ; sheetNo++) {
    		with(sheetObjects[sheetNo]) {
    			for (var row=HeaderRows(); row <= LastRow(); row++) {
    				SetRowStatus(row,"R");
    			}
    		}
    	}
    	//5.Button allows to change the state of.
    	initBtnControl();
    }
    /**
     * If you do run the Retrieve button is clicked the function that defines the behavior of
     */		
    function doActionNew() {
        var formObj=document.form;
        var sheetBKGObj=sheetObjects[0];
        var sheetCNTRObj=sheetObjects[1];
        var sheetHSTObj=sheetObjects[2];
        //deleting result grid.
        sheetBKGObj.RemoveAll();
        sheetCNTRObj.RemoveAll();
        sheetHSTObj.RemoveAll();
        //Delete a lookup field.
        with(formObj) {
	        ComSetObjValue(approvalOfcCd, "");
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
	        //Lookup fields to activate the inactive.
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
        //Restoring color of calculated column.
     	changeCalcColumn(false);
		//button initialization
		initBtnControl();
		// Free Time of Charge Detail for BKG, F/Time EXCL, D/C Amount or Ratio column is hidden.
		hideContainerColumn(true);
		//DAR No. is focus.
		ComSetFocus(formObj.darNo);		
    }
    /**
     * If you need to run Request button is clicked the function that defines the behavior of
     */		
    function doActionRequest() {
      	var formObj=document.form;
     	var sheetBKGObj=sheetObjects[0];
     	if (sheetBKGObj.RowCount()< 1) {
     		ComShowCodeMessage("DMT00128");
     		return;
     	}
     	//Request for Input Validation Check before you perform.
		if (validateForm(sheetBKGObj,formObj,IBSAVE)) {
			//DAR No. If you do not have DAR No. Automatically generate
if (sheetBKGObj.GetCellValue(sheetBKGObj.HeaderRows(), DAR_NO) == "") {
				//The new generated DAR No. To query.
				doActionIBSheet(sheetBKGObj,formObj,IBSEARCH_DAR);
				//Queried DAR No. Sets up a lookup column.
				ComSetObjValue(formObj.darNo, ComGetObjValue(formObj.result));
				//Queried DAR No. The BKG, CNTR allows all of the data set in.
				setNewDARNo(ComGetObjValue(formObj.darNo));
			}
			//Request before performing a CNTR TYPE Different if two of the Charge Detail per BKG Cur. BKG value set in the column of the Cur. Set to allow.
			setCurrencyBKGContainer();
			//Request Charge, if one exists, before you perform the Container Flag 'Y' is set to allow.
			setFlagBKGContainer();
			//Request to perform.
			doActionIBSheet(sheetBKGObj,formObj,IBSAVE);
			//Request Action should normally run a query execution.
			if (ComTrim(ComGetObjValue(formObj.result)) == "Y") {
				//The screen shot floated in 2006 as a pop-up if the Action is executed, depending on the current screen viewed 2,006 on the screen to reflect on the results Uses.
				prevActStatus=ComGetObjValue(formObj.status);
				doActionRetrieve();
			   	//in case of calling from No 2006 view (DEM/DET Adjustment Request & Approval Status)
				//Request history is reflected in the Main screen.
		        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
		        	commitMainScreen("Requested");
		        } 					
			}			
		}
    }
    /**
     * If you need to run the Cancel button is clicked the function that defines the behavior of
     */		
    function doActionCancel() {
    	var sheetBKGObj=sheetObjects[0];
    	var formObj=document.form;
		if (!ComShowCodeConfirm("DMT00135", "cancel this request")) { return; }
		//Cancel Action run.			
		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_CANCEL);
		//Action stores are running a normal query execution.
		if (ComGetObjValue(formObj.result) == "Y") {
			//2006 floated on the screen to pop up if executed in the current screen to the Action screen, viewed according to the 2006 results to reflect Enabled.
			prevActStatus=ComGetObjValue(formObj.status);
			doActionRetrieve();
		   	//in case of calling from No 2006 view (DEM/DET Adjustment Request & Approval Status)
			//Cancel the history is reflected in the Main screen.
	        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("Cancel");
	        } 			
		}   	
    }    
     /**
      * Approval need to run when the button is clicked the function that defines the behavior of
      */		
     function doActionApproval() {
    	var formObj=document.form;
     	var sheetBKGObj=sheetObjects[0];
     	//===================================================================================
		// Data Approval button is pressed after changing the typical "Do you want to approve?" 
     	// Instead of the phrase "Data was changed. Do you want to approve with changed data?" 
     	// Yes look for when selecting text data input validation and immediately apply the changes to the DAR please.
     	//===================================================================================
		isChangedData=false;
		for (var sheetNo=0 ; sheetNo < 2 ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					if (GetRowStatus(row) == "U") {
						isChangedData=true;
						break;
					}
				}
			}
			if (isChangedData) break;
		}
		if (isChangedData) {
			if (!ComShowCodeConfirm("DMT01136")) { return; }
		}
		else {
			if (!ComShowCodeConfirm("DMT00135", "approve")) { return; }
		}
		//Check the values ​​entered for the validity of.
		if (validateForm(sheetBKGObj, formObj, IBSAVE_APPROVAL)) {
			//Request before performing a CNTR TYPE Different if two of the Charge Detail per BKG Cur. BKG value set in the column of the Cur. Set to allow.
			setCurrencyBKGContainer();
			//Request Charge, if one exists, before you perform the Container Flag 'Y' is set to allow.
			setFlagBKGContainer();
			//Approval Action to perform.			
			doActionIBSheet(sheetBKGObj, formObj, IBSAVE_APPROVAL);
		}
     } 
     /**
      * If the button is clicked CounterOffer need to perform a function that defines the behavior of
      */		
     function doActionCounterOffer() {
     	var sheetBKGObj=sheetObjects[0];
     	var formObj=document.form;
 		if (!ComShowCodeConfirm("DMT00135", "counter offer")) { return; }
		//COUNTER OFFER Comment runtime is a required field.				
		if (!validateComment()) return;
 		//Cancel Action to perform.			
 		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_COUNTEROFFER);
 		if(ComGetObjValue(formObj.apvlNo) == '') {
	 		//CounterOffer Action should normally run a query execution.
	 		if (ComGetObjValue(formObj.result) == "Y") {
	 			ComShowCodeMessage("DMT00160", "counter offered");
				//The screen shot floated in 2006 as a pop-up if the Action is executed, depending on the current screen viewed 2,006 times on the screen to reflect on the results Uses.
				prevActStatus=ComGetObjValue(formObj.status);
	 			doActionRetrieve();
			   	//in case of calling form No 2006 view(DEM/DET Adjustment Request & Approval Status)
				//Main screen is reflected in the approved details.
		        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
		        	commitMainScreen("CounterOffer");
		        } 			
	 		}
 		}
     } 
    /**
     * Reject if button is clicked need to perform a function that defines the behavior of
     */		
    function doActionReject() {
     	var sheetBKGObj=sheetObjects[0];
     	var formObj=document.form;
 		if (!ComShowCodeConfirm("DMT00135", "reject")) { return; }
		//Comment REJECT runtime is a mandatory.				
		if (!validateComment()) return;
 		//Cancel Action run.			
 		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_REJECT);
 		if(ComGetObjValue(formObj.apvlNo) == '') {
	 		//Reject Action is running a normal query execution.
	 		if (ComGetObjValue(formObj.result) == "Y") {
	 			ComShowCodeMessage("DMT00160", "rejected");
				//The screen shot floated in 2006 as a pop-up if the Action is executed, depending on the current screen viewed 2,006 times on the screen to reflect on the results Uses.
				prevActStatus=ComGetObjValue(formObj.status);
	 			doActionRetrieve();
			   	//in case of calling from No 2006 view(DEM/DET Adjustment Request & Approval Status)
				//Main screen is reflected in the approved details.
		        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
		        	commitMainScreen("Reject");
		        }
	 		}    
 		}
    } 
   /**
    * If you need to run the Close button is clicked the function that defines the behavior of
    */
    function doActionClose() {
  ComClosePopup(); 
    }
    /**
	 * Queried based on the results of this change is the state of the button functions in a batch
	 */	    
    function initBtnControl() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
        //Once the screen pops up in 2006 as a pop-up screen After Booking Retrieve seems better to be disabled and the New(2009-11-12(Thu))
        if (ComGetObjValue(formObj.caller) == "2006") {
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_New");
        }
        else {
        	ComBtnEnable("btn_Retrieve");
        	ComBtnEnable("btn_New");
        }		
		//1.On-screen buttons to set the status of.######################
    	//resets the state of Request button.
    	initBtnRequest();
    	//resets the state of Cancel button.
    	initBtnCancel();
    	//resets the state of Approval button.
    	initBtnApproval();
    	//resets the state of Counter Offer button.
    	initBtnCounterOffer();
    	//resets the state of Reject button.
    	initBtnReject();
    	//2.D/C AMT or Ratio Pre Cal., Reset button setting.(2009-11-06(Fri)) ================================================
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
	 * Views on the results of the Request button functions change is the status of
	 */	     
    function initBtnRequest() {
    	var formObj=document.form;
    	var sheetBKGObj=sheetObjects[0];
    	var rqstOfcCd="";
    	with(sheetBKGObj) {
            if (RowCount()> 0) rqstOfcCd=GetCellValue(HeaderRows(), RQST_OFC_CD);
    	}
    	var status=ComTrim(ComGetObjValue(formObj.status));
    	//1.in case of that there is no Status vaue, it is activated
    	//[9/25] 2009 On the screen is viewed only for DAR Request (modified) only allowing, STS is blank if the Request button on a disabled(2009-11-02 edit)
    	if (status == "") {
    		ComBtnDisable("btn_AddBkgReq");
			ComBtnDisable("btn_DelBkgReq");
    		ComBtnDisable("btn_Request");
    	}
    	//2.Status is Request Counter Offered yimyeonseo Login mucin mucin is identical to the activation    	
    	else if (status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
    		ComBtnEnable("btn_AddBkgReq");
    		ComBtnEnable("btn_DelBkgReq");
    		ComBtnEnable("btn_Request");
    	}
    	//3.If the Request Status, Request office sign office is identical to the activation
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
    	//1.If the Request Status, Request office sign office is identical to the activation
    	var status=ComTrim(ComGetObjValue(formObj.status));
    	if ((status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd) ) || 
    			(status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) )
    		ComBtnEnable("btn_Cancel");
    	else
    		ComBtnDisable("btn_Cancel");
   }
    /**
	 * Approval retrieved based on the results of this change is the status of the button functions
	 */	     
    function initBtnApproval() {
    	//1.All conditions must be under the PASS is activated.
    	//1-1.User log in on the Security UI_DMT_2009 (DAR-After BKG Approval) if there is activation of Access Rights
    	var isPass1=isPermitRole();
    	//1-2.Approval Office and sign their local headquarters of office / Number of Lines (NYCNA, HAMUR, SHAAS, SINWA, SELHO) are the same, the only active when
    	var isPass2=isMatchOffice();
    	//1-3.Status is "Requested", "Counter Offered", "Rejected" state of activation and Status is blank, "Cancelled", "Approved" status of disabled in
    	var isPass3=isPermitStatus("Approval");
    	if (isPass1 && isPass2 && isPass3)
    		ComBtnEnable("btn_Approval");
    	else
    		ComBtnDisable("btn_Approval");
	 }
    /**
	 * Counter Offer buttons are retrieved based on the results of this change is a function of the state
	 */	     
    function initBtnCounterOffer() {
    	//1.All conditions must be under the PASS is activated.
    	//1-1.User log in on the Security UI_DMT_2009 (DAR-After BKG Approval) if there is activation of Access Rights
    	var isPass1=isPermitRole();
    	//1-2.Approval Office and sign their local headquarters of office / Number of Lines (NYCNA, HAMUR, SHAAS, SINWA, SELHO) are the same, the only active when
    	var isPass2=isMatchOffice();
    	//1-3.Status is "Requested", "Counter Offered", "Rejected" state of activation and Status is blank, "Cancelled", "Approved" status of disabled in
    	var isPass3=isPermitStatus("CounterOffer");
    	if (isPass1 && isPass2 && isPass3)
    		ComBtnEnable("btn_CounterOffer");
    	else
    		ComBtnDisable("btn_CounterOffer");
	}
    /**
	 * 조회된 결과에 따른 Counter Offer 버튼의 상태를 변경해주는 함수
	 */	     
    function initBtnReject() {
    	//1.All conditions must be under the PASS is activated.
    	//1-1.User log in on the Security UI_DMT_2009 (DAR-After BKG Approval) if there is activation of Access Rights
    	var isPass1=isPermitRole();
    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCNA, HAMUR, SHAAS, SINWA, SELHO) 가 동일할 경우에만 활성화
    	var isPass2=isMatchOffice();
    	//1-3.Approval Office and sign their local headquarters of office / Number of Lines (NYCNA, HAMUR, SHAAS, SINWA, SELHO) are the same, the only active when
    	var isPass3=isPermitStatus("Reject");
    	if (isPass1 && isPass2 && isPass3)
    		ComBtnEnable("btn_Reject");
    	else
    		ComBtnDisable("btn_Reject");
   }
    /**
	 * User log in on the Security EES_DMT_2009 (DAR-After BKG Approval) of the Access function that returns the results that you have permission
	 */	 
    function isPermitRole() {
        var formObj=document.form;
        var isPermit=false;
        var roleAuth=ComGetObjValue(formObj.role_auth);
        var rolePermit=ComGetObjValue(formObj.role_permit);
//     	if (roleAuth == "DMT01" || roleAuth == "DMT02" || roleAuth == "DMT03") {
        if (roleAuth == "DMT01" || roleAuth == "DMT02" || roleAuth == "DMT03"  || roleAuth == "DMT04") {
        	if (rolePermit == "Y")
        		isPermit=true;
        }
		return isPermit
	}
    /**
	 * Approval Office and sign their local headquarters of mucin / Number of Lines (NYCNA, HAMUR, SHAAS, SINWA, SELHO) is equal to a function that returns a result
	 */	 
	function isMatchOffice() {
	    var formObj=document.form;
		with(formObj) {
		    if (ComGetObjValue(approvalOfcCd) == ComGetObjValue(usr_rhq_cd))
			    return true;
		}
		return false;
	}
    /**
	 * Status button is enabled or disabled depending on the value of a function that returns
	 */	     
	function isPermitStatus(sts) {
	    var formObj=document.form;
	    var status=ComTrim(ComGetObjValue(formObj.status));
		if (sts == "Approval") {
			if (status == "Requested" || status == "Counter Offered" || status == "Rejected")
			    return true;
		}
	    else if (sts == "CounterOffer") {
			if (status == "Requested" || status == "Approved" || status == "Rejected")
			    return true;
	    }
	    else if (sts == "Reject") {
			if (status == "Requested" || status == "Counter Offered" || status == "Approved")
			    return true;
	    }
		return false;
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
					&& 	bkgNo  == GetCellValue(row, BKG_NO)
					&&	tariff == GetCellValue(row, TARIFF)
					&&	adjSeq == GetCellValue(row, ADJ_SEQ)	) {
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
		var total=0;
		with(sheetBKGObj) {
			var bkgNo=GetCellValue(GetSelectRow(), BKG_NO);
			var tariff=GetCellValue(GetSelectRow(), TARIFF);
			var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
		with(sheetCNTRObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (	GetRowStatus(row) != "D"
					&&	GetRowHidden(row) == false
					&& 	bkgNo == GetCellValue(row, BKG_NO)
					&&	tariff == GetCellValue(row, TARIFF)
					&&	adjSeq == GetCellValue(row, ADJ_SEQ)	) {
					if (!isSumed) isSumed=true;
					SetCellValue(row, BIL_AMT,GetCellValue(row, ORG_BIL_AMT),0);
					// 2010-05-25 edit
					total=total + parseFloat(GetCellValue(row, BIL_AMT));
				}
			}
		}
		if (!isSumed) total="";
		//Total Billable Amount setting allows to obtain the sum.
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
	 	      			if (sheetCNTRObj.GetRowStatus(subRow) != "D" && adjSeq == sheetCNTRObj.GetCellValue(subRow, ADJ_SEQ)) {
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
 	      		//Delete processing allows only for items that are not.
				if (GetRowStatus(row) != "D") {
 		      		//in case of checking 'All' on CNTR 
 		      		if (cntrTp == "S") {
 		      			SetCellValue(row, CNTR_FLG,"N",0);
 		      		}
 		      		//in case of checking 'Different' on CNTR
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
    * If the singyuil Booking Container Seqeunce to establishing the value of the function
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
				// Tariff or BKG No., B / L No. Has changed, if viewed Charge Detail per BKG After Booking DAR information is not registered with is data retrieved when the DAR No.,
				// Adjustment Seq., Container Seq. Does not exist, 
				// and in that case should be configured to obtain the value from the BKG data.
				if (	GetRowStatus(row) != "D"
									&& 	GetRowHidden(row) == false
				&& 	bkgNo == GetCellValue(row, BKG_NO)
				&&	tariff == GetCellValue(row, TARIFF)
				&&	GetCellValue(row, ADJ_SEQ) == ""	) {
					if (darNo != "") SetCellValue(row, DAR_NO,darNo,0);
					SetCellValue(row, ADJ_SEQ,  adjSeq,    0);
					SetCellValue(row, CNTR_SEQ, cntrSeq++, 0);
				}
			}
		}
    }
  	/**
	 * 2009 has been afloat in this pop-up screen that tells the function
	 */
	function isPopupWindow() {
	    var formObj=document.form;
		if (ComGetObjValue(formObj.caller) != "" && ComGetObjValue(formObj.darNo) != "") {
			return true;
		}
		return false;  		
    } 
  	/**
	 * No. 2006 on the main screen function of reflecting Approval, Counter Offer, Reject a result.
	 */
	function commitMainScreen(sAction) {
		var formObj=document.form;
        var receivedSheetObj=window.dialogArguments.sheetObjects[2];
        var sentSheetObj=window.dialogArguments.sheetObjects[5];
        //DATE viewed as a condition to only select to perform logic.(in case of approval process, deleting data in Received Tab and moving to Send Tab)
        if (!window.dialogArguments.document.form.cond_type[0].checked) return;
        //DAR No., Ver No. In the same Received Tab Send Tab add and delete data allows.
        var sheetId=ComGetObjValue(formObj.sheetId);
var reqOfc=(sheetId == "t1sheet3") 	? receivedSheetObj.GetCellValue(	receivedSheetObj.GetSelectRow(), "req_ofc_cd"	)
: sentSheetObj.GetCellValue(		sentSheetObj.GetSelectRow(), 	"req_ofc_cd"	);
        var apvlOfc=(sAction != "Requested")  ? ComGetObjValue(formObj.usr_ofc_cd) : "";
        var isSameOfc=window.dialogArguments.isSameOffice(reqOfc, apvlOfc);
        //1. Request and Approval Office are the same, if the lookup Received Tab and all appears to Sent Tab.
        //   Whether any Tab in these cases is called to modify the data if both places.
        if (isSameOfc) {
        	updateRow(receivedSheetObj, sAction);
			updateRow(sentSheetObj, 	sAction);			
        }
        //2. Request and Approval Office Received Tab if you call from a different case by moving the data to be Sent Tab
        else {
        	if (prevActStatus == "Requested") {
        		//Received Tab => Received Tab(update)
        		if (sAction == "Requested" || sAction == "Cancel") {
        			updateRow(receivedSheetObj, sAction);
        		}
        		//Received Tab => Sent Tab(delete data from received tab and insert data into sent tab)
        		else {
        			moveRowSheetToSheet(receivedSheetObj, sentSheetObj, sAction);	
        		}
        	}
        	else {
        		//Received Tab => Sent Tab(delete data from received tab and insert data into sent tab)
        		if (sAction == "Requested") {
        			moveRowSheetToSheet(receivedSheetObj, sentSheetObj, sAction);		
        		}
        		//Sent Tab => Sent Tab(update)
        		else {
        			updateRow(sentSheetObj, sAction);
        		}
        	}
        }
	}
 	/**
	 * Updating the status of the selected Row (with information that has changed), a function that
	 */		 
	function updateRow(sheetObj, sAction) {
		var formObj=document.form;
		var darNo=ComGetObjValue(formObj.darNo);
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
if (darNo == GetCellValue(row, "dar_no")) {
SetCellValue(row, "apvl_no",sAction == "Approval" ? ComGetObjValue(formObj.apvlNo) : "");
SetCellValue(row, "status",ComGetObjValue(formObj.status));
SetCellValue(row, "apro_ofc_cd",ComGetObjValue(formObj.usr_ofc_cd));
SetCellValue(row, "upd_dt",ComGetObjValue(formObj.popup_upd_dt));
				}
			}
		}		
	}
 	/**
	 * Row selected in the current Sheet Sheet, go to another function that
	 */		
    function moveRowSheetToSheet(fromSheetObj, toSheetObj, sAction) {
        var formObj=document.form;
		//Received Tab in the same DAR No. The 'TO', 'CC' in this case because it can appear as a deletion in the two cases, but one's there. 
        //Sent Tab has been added to display the distinguishing variables that are used to cycle
		var isAppliedRow=false;
		var darNo=ComGetObjValue(formObj.darNo);
		with(fromSheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
if (darNo == GetCellValue(row, "dar_no")) {
					if (!isAppliedRow) {
						//add data row
		                var addedRow=toSheetObj.DataInsert(-1);
		                //move data
		                var fieldValue="";
		                for (ic=0 ; ic <= LastCol(); ic++) {
		                	switch(ColSaveName(ic)) {
			                	case "apvl_no":
			                		fieldValue=sAction == "Approval" ? ComGetObjValue(formObj.apvlNo) : "";
			                		break;
			                	case "status":
			                		fieldValue=ComGetObjValue(formObj.status);
			                		break;
			                	case "apro_ofc_cd":
			                		fieldValue=sAction != "Requested" ? ComGetObjValue(formObj.usr_ofc_cd) : "";
			                		break;
			                	case "upd_dt":
			                		fieldValue=ComGetObjValue(formObj.popup_upd_dt);
			                		break;
			                	default:
fieldValue=GetCellValue(row, ic);
		                	}
toSheetObj.SetCellValue(addedRow, ic,fieldValue);
		                }
		                isAppliedRow=true;
					}
	                //Clear from the source
	                RowDelete(row, false);
				}
			}
		}    	
    }
 	/**
	 * D / C AMT or Ratio Pre Cal. Calculation of the column at the click of a button changes the status of the associated column or row, due to changes in the selected function to initialize
	 */	 
	function changeCalcColumn(flg) {
		if (flg) {
	     	//Changed to a red button to change the selected row and column calculations is due to the initialization.
	     	document.getElementById("btn_PreCalc").style.color="red";
	     	document.getElementById("totalBillAmt").style.color="red";				
		}
		else {
	     	//Changed to a red button to change the selected row and column calculations is due to the initialization.
	     	document.getElementById("btn_PreCalc").style.color="";
	     	document.getElementById("totalBillAmt").style.color="";				
		}
		changeCalcBillableAMT(flg);		
	}
 	/**
	 * D / C AMT or Ratio Pre Cal. Calculation of the column at the click of a button changes the status of the associated column or row, due to changes in the selected function to initialize
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
	 * D / C AMT or Ratio Pre Cal. Ensure that you have handled the calculation of the column the function
	 */	 
	function isCalculated() {
	    if (document.getElementById("btn_PreCalc").style.color == "red") {
	    	return true;
	    }
    	return false;
	}
    /**
 	 * Status Depending on the state of activate or deactivate the grid BKG.
 	 */
    function enableGrid(flg) {
    	var sheetBKGObj=sheetObjects[0];
    	with(sheetBKGObj) {
    		for (var row=HeaderRows(); row <= LastRow(); row++) {
if (GetRowStatus(row) != "D") {
    				//If you do not have information Charge inactive CNTR_TP movie ever.(2009-11-05(Thu))
if (GetCellValue(row, CNTR_FLG) != "N") {
    					SetCellEditable(row, CNTR_TP,flg);
    				}
    				else {
    					SetCellEditable(row, CNTR_TP,0);
    				}    				
	    			SetCellEditable(row, FT_FLG,flg);
	    			SetCellEditable(row, ADD_DYS,flg);
	    			SetCellEditable(row, TTL_DYS,flg);
	    			SetCellEditable(row, SAT_FLG,flg);
	    			SetCellEditable(row, SUN_FLG,flg);
	    			SetCellEditable(row, HOL_FLG,flg);
	    			SetCellEditable(row, DCAR_FLG,flg);
	    			SetCellEditable(row, DCAR_CURR,flg);
	    			SetCellEditable(row, DCAR_AMT,flg);
	    			SetCellEditable(row, DCAR_RTO,flg);
    			}
    		}
    	}
    	enableContainerGrid(flg);
    }
    /**
  	 * Status Container per BKG Depending on the state of activate or deactivate the grid.
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
if (	GetRowStatus(row) != "D"
&& bkgNo 	== GetCellValue(row, BKG_NO)
&& tariff 	== GetCellValue(row, TARIFF)	) {
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
	 * After Booking DAR values ​​are retrieved in the state of the state of the grid is enabled, disabled sikilgeot sikilgeot function to determine whether
	 */    
    function isEnableGrid() {
    	var formObj=document.form;
    	var sheetBKGObj=sheetObjects[0];
    	var rqstOfcCd="";
    	with(sheetBKGObj) {
            if (RowCount()> 0) rqstOfcCd=GetCellValue(HeaderRows(), RQST_OFC_CD);
    	}
    	//GRID activate 1)Status is blank, 2)If Counter Offered Login mucin mucin is identical to the Request
    	//             3)If Requested Login mucin mucin is identical to the Request is.
    	//			   4)If you are a privileged Approval
		var status=ComTrim(ComGetObjValue(formObj.status));
		if (status == "")
			return true;	
		else if (status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd))
			return true;
    	else if (status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd))
    		return true;
    	else if (isPermitRole() &&  isMatchOffice() && isPermitStatus("Approval"))
    		return true;
		return false;
    }
  	/**
  	 * DAR anti-stamp lookup field value is entered in a particular field makes other Clear all fields.
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
 	 * Of Change Detail per BKG D / C Amount or Ratio of the Currency, all data changes, the same shall also make the same changes.
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
    * Tariff and BKG No. The same Charge Detail per BKG obtain a function that returns the total number of
    */
    function getChargeQuantity() {
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
					quantity++;
				}
			}
		}    	
		quantity=quantity > 0 ? quantity : "";
    	return quantity
    }
   /**
    * Tariff and BKG No. The same Charge Detail per BKG find a function that returns the first Currency
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
   	 * Rate Adjustment or select an item of avoidance behavior that defines the function to perform
   	 */	
  	 function checkComment() {
   		var formObj=document.form;
 		var sheetHSTObj=sheetObjects[2];
 		with(formObj) {
 			if (chkComment.checked) {
 				ComSetObjValue(comment, "");
 			}
 			else {
 				if (sheetHSTObj.RowCount() > 0) {
 	 				ComSetObjValue(comment, sheetHSTObj.GetCellValue(sheetHSTObj.GetSelectRow(), PROG_RMK));
 				} 
 				else {
 					ComSetObjValue(comment, "");
 	 			} 				
 			}
			//Comment activate / deactivate+++++++++++++++++++++++++
			//ComEnableObject(formObj.comment, false);
			comment.readOnly = !chkComment.checked;
			if (chkComment.checked == true) {
				comment.style.backgroundColor="#CCFFFD";	//textarea1
				
			} 
			else {
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
  	 * BKG No. Or B / L No. Charge to modify the query after the key column is changed to prevent.
  	 */		
  	function disableKeyColumn(selectedRow) {
  		var sheetBKGObj=sheetObjects[0];
  		with(sheetBKGObj) {
  			SetCellEditable(selectedRow, BKG_NO,0);
  			SetCellEditable(selectedRow, BL_NO,0);
  			SetCellEditable(selectedRow, TARIFF,0);
  		}
  	}
   	/**
   	 * BKG No. Or B / L No. Input B / L No. Or BKG No., S / C No., RFA No. To look up the function
   	 */	 	
  	function checkBKGBLNo(COL) {
  		var formObj=document.form;
  		var sheetBKGObj=sheetObjects[0];
  		//1-1.BKG No. Or B / L No. Input B / L No. Or BKG No. If you do not like to look up and show an error message.
   		with(sheetBKGObj) {
  	 		if (!checkTariffBKGBLNo(sheetBKGObj,formObj)) {
				SetCellValue(GetSelectRow(), BKG_NO,"",0);
				SetCellValue(GetSelectRow(), BL_NO,"",0);
  	 			if (ComGetObjValue(formObj.result2) == "") {
 	 	 			ComShowCodeMessage("DMT00165", COL == BKG_NO ? "BKG No." : "B/L No.");
 	 	     		return false;
  	 			}
  	 			else {
 					//3-1.Type BKG No. The S / C or RFA No. The top of the S / C or RFA No. And shows an error message when a mismatch preventing.
  	 				ComShowCodeMessage("DMT00159", GetCellValue(GetSelectRow(), "Seq"));
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
	 * The entire CNTR A / RI / F when it is retrieved when the user clicks Cancel, the delete function that all the information.
	 */	 	
	function removeBookingChargeData() {
		var formObj=document.form;
		var sheetBKGObj=sheetObjects[0];
		var sheetCNTRObj=sheetObjects[1];
		with(sheetBKGObj) { 		
var adjSeq=GetCellValue(GetSelectRow(), ADJ_SEQ);
		}
 		//Charge Header infomation delete
 		ComClearObject(formObj.cntrQty);
 		ComClearObject(formObj.curr);
 		ComClearObject(formObj.totalBillAmt);
 		//Charge infomation delete
 		with(sheetCNTRObj) {
 			for (var row=LastRow(); row >= HeaderRows(); row--) {
if (GetRowStatus(row) != "D" && GetRowHidden(row) == false && adjSeq == GetCellValue(row, ADJ_SEQ)) {
if (GetRowStatus(row) == "I") {
 						RowDelete(row, false);
 					}
 					else {
SetRowStatus(row,"D");
 						SetRowHidden(row,1);
 					}
 				}
 			}
 		}
		//Booking infomation delete
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
 		//But if only one jeongboil Booking S / C No., RFA No., Customer Information Removes gives.
 		if (getAfterBKGCount() <= 1) {
 			ComClearObject(formObj.scNo);
 			ComClearObject(formObj.rfaNo);
 			ComClearObject(formObj.custCd);
 			ComClearObject(formObj.custNm);
 		}		
	}
 	/**
	 * Booking is present to obtain a function of the number of ROW
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
     * Pre Calc button at CNTR two 'All' as a jijeongdoeeotttae, BKG in order to calculate the D / C Amount or Ratio of the function will copy the data into Container Charge
     */	
    function copyDCAmountOrRatioToChargeContainer() {
    	var sheetBKGObj=sheetObjects[0];
    	var sheetCNTRObj=sheetObjects[1]
		var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
		var amt=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), DCAR_AMT);
		var ratio=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), DCAR_RTO);
		with(sheetCNTRObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D" && adjSeq == GetCellValue(row, ADJ_SEQ)) {
				if (GetCellValue(row, GB) == "G") {
					SetCellValue(row, AR_AMT,amt,0);
					SetCellValue(row, AR_RTO,ratio,0);
					}
				}
			}
		}
    }
  /**
    * Pre Calc button at CNTR two 'All' and the time specified in, 
    * for the calculation of BKG D / C Amount or Ratio of the data copied to the Container Charge to remove the information function
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
     * Depending on the value of CNTR selected BKG, CNTR's Free Time, Amount or Ratio can take care of whether to activate the function of the column
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
			SetCellEditable(row, ADD_DYS,isActive);
			SetCellEditable(row, TTL_DYS,isActive);
			SetCellEditable(row, SAT_FLG,isActive);
			SetCellEditable(row, SUN_FLG,isActive);
			SetCellEditable(row, HOL_FLG,isActive);
			SetCellEditable(row, DCAR_CURR,isActive);
			SetCellEditable(row, DCAR_AMT,isActive);
			SetCellEditable(row, DCAR_RTO,isActive);
    	}
    }
    /**
     * CNTR Grid's Free Time, Amount or Ratio can take care of whether to activate the function of the column
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
    	    var iRow=GetSelectRow();
			SetCellValue(iRow, FT_FLG,0,0);
			SetCellValue(iRow, ADD_DYS,"",0);
			SetCellValue(iRow, TTL_DYS,"",0);
			SetCellValue(iRow, SAT_FLG,0,0);
			SetCellValue(iRow, SUN_FLG,0,0);
			SetCellValue(iRow, HOL_FLG,0,0);
			SetCellValue(iRow, DCAR_FLG,0,0);
			SetCellValue(iRow, DCAR_CURR,"",0);
			SetCellValue(iRow, DCAR_AMT,"",0);
			SetCellValue(iRow, DCAR_RTO,"",0);
    	}
    }
    /**
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
    * Charge Detail per BKG Grid. The Seq. In order to reset the value of.
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
				&& 	bkgNo == GetCellValue(row, BKG_NO)
				&&	tariff == GetCellValue(row, TARIFF)
				&&	adjSeq == GetCellValue(row, ADJ_SEQ)	) {
				SetCellValue(row, "Seq", seq++, 0);
				}
			}
		}
   }
    /**
    * Automatically select the rows that were deleted after the function to find the rows be
    */
   function fetchSelectedNextRow(delRow) {
		var sheetBKGObj=sheetObjects[0];
		var nextRow=-1;
		with(sheetBKGObj) {
			for (var row=delRow ; row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					nextRow=row;
					break;
				}
			}
			if (nextRow == -1) {
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
	 * If another row is selected BKG Charge Detail per BKG also need to change your entry in the show is.
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
    * Tariff and BKG No. The same Charge Detail per BKG obtain a function that returns the total number of
    */
    function fetchChargeRowCount() {
     	var sheetBKGObj=sheetObjects[0];
     	var sheetCNTRObj=sheetObjects[1];
     	var adjSeq=sheetBKGObj.GetCellValue(sheetBKGObj.GetSelectRow(), ADJ_SEQ);
     	with(sheetCNTRObj) {
     		for (var row=HeaderRows(); row <= LastRow(); row++) {
     			if (GetRowStatus(row) != "D" && GetRowHidden(row) == false && adjSeq == GetCellValue(row, ADJ_SEQ)) {
     				return 1;
     			}
     		}
     	}
     	return 0;
    }
    /**
     * If you have permission to log on DMT03 about whether a valid privilege checkmark the function
     */
    function check03RoleAuth() {
    	var formObj=document.form;
    	var sheetBKGObj=sheetObjects[0];
    	var isPermit=false;
    	with(sheetBKGObj) {
    		ComSetObjValue(formObj.etc2, ComGetObjValue(formObj.approvalOfcCd));
    		ComSetObjValue(formObj.etc4, ComGetObjValue(formObj.darNo));
    		for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					ComSetObjValue(formObj.etc5, GetCellValue(row, BKG_NO));
					ComSetObjValue(formObj.etc6, GetCellValue(row, TARIFF));
		    		doActionIBCommon(sheetBKGObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);
		    		if (ComGetObjValue(formObj.role_permit) == "Y") {
		    			isPermit=true;
		    		}
		    		else {
		    			isPermit=false;
		    			break;
		    		}
    			}
    		}
    	}
    	ComSetObjValue(formObj.role_permit, isPermit ? "Y" : "N");
    }
    /**
     * All retrieved B / L No. A series of functions that return a string by converting
     */
    function fetchAllBLNo() {
    	var sheetBKGObj=sheetObjects[0];
    	var allBlNo="";
    	with(sheetBKGObj) {
	    	for (var row=HeaderRows(); row <= LastRow(); row++) {
	    		if (GetRowStatus(row) != "D") {
	    			allBlNo += GetCellValue(row, BL_NO);
	    			if (row < LastRow()) allBlNo += ",";
	    		}
	    	}
    	}
    	return allBlNo;
    }
     /// BACK END JOB Create Start ////////////////////////////////////////////
     /**
     * Related BackEndJob Status = '3 'until it is confirmed.
     */
    function getBackEndJobStatus() {
        var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	//It gets a status of backendjob. 2
       	ComSetObjValue(formObj.f_cmd, COMMAND02);
        var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
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
        ComSetObjValue(formObj.f_cmd, 			COMMAND03);
		ComSetObjValue(formObj.aft_expt_dar_no, ComGetObjValue(formObj.darNo));
		ComSetObjValue(formObj.popup_flag, 		isPopupWindow() ? "Y" : "N");
		sheetObj.ShowDebugMsg(false);
    	sheetObj.SetWaitImageVisible(0);
        var sXml=sheetObj.GetSearchData("EES_DMT_2009GS.do", FormQueryString(formObj));
    	ComOpenWait(false);
    	if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
    		var exptRqstStsCd=ComGetObjValue(formObj.dmdt_expt_rqst_sts_cd);
    		var msg;
    		var action;
    		if(exptRqstStsCd == 'A') {
    			msg='approved';
    			action='Approval';
    		} else if(exptRqstStsCd == 'O') {
    			msg='counter offered';
    			action='CounterOffer';
    		} else if(exptRqstStsCd == 'J') {
    			msg='rejected';
    			action='Reject';
    		}
    		
    		// Approval, Counter Offer, Reject 시 Comment 배경색을 비활성화 색상으로 변경한다.
    		formObj.comment.style.backgroundColor="#E8E7EC";	//textarea2
    		
    		ComShowCodeMessage("DMT00160", msg);
			if (isPopupWindow()) {
				ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
				prevActStatus=ComGetObjValue(formObj.status);
			}
 			doActionRetrieve();
	        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen(action);
	        }
 		}   
    } 
    /// BACK END JOB Create End ////////////////////////////////////////////
    /**
     * Delivered normally not received from the server being able to handle the data function 
     */
    function handleNullString(sVal) {
        if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
        return ComTrim(sVal);
    }
    /**
	 * After Exception Container Seq. In order to glue the function.
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
