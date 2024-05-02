/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2001.js
*@FileTitle  : DEM/DET Exception - S/C Exception Terms Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
	// Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Defining Action
	var IBSEARCH_INIT=100;
	var IBSEARCH_VER=101;
	var IBSEARCH_CUST=102;
	var IBSEARCH_CALC=103;
	var IBSEARCH_DUAL=104;
	var IBSEARCH_CHKCONTI=105;
	var IBSEARCH_FILED=106;
	var IBSEARCH_SCNO_CUST=107;
	var IBSEARCH_SUB=108;
	var IBSEARCH_SCTARIFF=109;
	var IBSEARCH_CHECK_DUP=110;
	var IBSEARCH_VER_CHECK=111;
	var IBSAVE_VERSTS=201;
	var IBSAVE_SCTARIFF=202;
	var IBSAVE_SCTARIFF_UPDATE=203;
	var IBSAVE_SCTARIFF_HISTORY=204;
	var	IBDELETE_SCTARIFF=301;
	//Defining data unit separator
	var ROWMARK="|";
	var FIELDMARK="=";
	var TARIFF="dmdt_trf_cd";
	var EFF_DT="eff_dt";
	var EXP_DT="exp_dt";	
	var CNTRCGO="dmdt_cntr_cgo_tp_cd";
	var CVRG_SEQ="cvrg_seq";
	var CVRG_MULTI="cvrg_multi";
	var CURR_CVRG_MULTI="curr_cvrg_multi";
	var CVRG_CNT="cnt_cd";
	var CVRG_RGN="rgn_cd";
	var CVRG_STE="ste_cd";
	var CVRG_LOC="loc_cd";
	var CVRG_POP="cvrg_pop";
	var FT_SEQ="ft_seq";
	var FT_FLG="ft_flg";
	var PREV_FT_FLG="prev_ft_flg";
	var	FT_TIR="ft_tir";
	var ADD_DYS="ft_add_dys";
	var TOT_DYS="ft_tot_dys";
	var FT_FROM="cntr_fm_qty";
	var FT_UPTO="cntr_to_qty";
	var FT_DAYS="ft_dys";
	var RT_FROM="ft_fm_dys";
	var RT_UPTO="ft_to_dys";
	var RT_20FT="cntr_20ft_rt_amt";
	var RT_40FT="cntr_40ft_rt_amt";
	var RT_HC="cntr_hc_rt_amt";
	var RT_45FT="cntr_45ft_rt_amt";
	var RT_SEQ="rt_seq";
	var RT_MANDATORY="rt_chk_flg";	
	var RT_CHECK="rt_chk";		
	var SAT_FLG="xcld_sat_flg";
	var SUN_FLG="xcld_sun_flg";
	var HOL_FLG="xcld_hol_flg";
	var ORGDST_CTI="sc_expt_fm_conti_cd";
	var ORGDST_CNT="sc_expt_fm_cnt_cd";
	var ORGDST_RGN="sc_expt_fm_rgn_cd";
	var ORGDST_STE="sc_expt_fm_ste_cd";
	var ORGDST_LOC="sc_expt_fm_loc_cd";
	var ORGDST_POP="sc_expt_fm_pop";
	var BKGDEL_CNT="fnl_dest_cnt_cd";
	var BKGDEL_RGN="fnl_dest_rgn_cd";
	var BKGDEL_STE="fnl_dest_ste_cd";
	var BKGDEL_LOC="fnl_dest_loc_cd";
	var BKGDEL_POP="fnl_dest_pop";
	var CYDOOR="rcv_de_term_cd";
	var REMARK="expt_trf_rmk";
	var FULL_REMARK="full_expt_trf_rmk";
	var PROP_NO="prop_no";
	var VER_SEQ="sc_expt_ver_seq";
	var GRP_SEQ="sc_expt_grp_seq";
	var CURR_CD="curr_cd";
	var CMDT_FLG="cmdt_flg";
	var ACT_CUST_FLG="act_cust_flg";
	var FM_TO_PAIR_FLG="fm_to_pair_flg";
	var FT_ADD_FLG="ft_add_flg";
	var FT_ADJ_FLG="ft_adj_flg";
	var RT_ADJ_FLG="rt_adj_flg";
	var DMDT_FT_ADJ_TP_CD="dmdt_ft_adj_tp_cd";
	var HID_STATUS="hidden_status";
	var CUST_CD="cust_cd";
	var CUST_NM="cust_nm";
	var CMDT_CD="cmdt_cd";
	var CMDT_NM="cmdt_nm";
	var ROW_EDIT_STS="row_edit_status";
	//When Retrieving Location, Location intended to prevent information from being erased
	var isClearLocation=true;
	//OnChange event that occurred is not made ??on the Screen, 
	//In other words, Retrieving the data, each combo when setting the field, whether generated variables that distinguish.(Enabled in order to prevent unintended actions)
	//Variable settings are made in the Location field.
	var isValueSettingEvent=false;
	var isCopySCExceptionTariff=false;
	var isRateCheckingCVRG="";	
   	var dupAlertMsg="";	 
  	var dupAlertSubMsg="";
  	//Sort when the selected Row in order to maintain the selection state of the variables used
	var currGrpSeq="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetSCObj=sheetObjects[0];
         var sheetCVRGObj=sheetObjects[1];
         var sheetFTObj=sheetObjects[2];
         var sheetRTObj=sheetObjects[3];
         var sheetCUSTObj=sheetObjects[4];
         var sheetCMDTObj=sheetObjects[5];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName = ComGetEvent("name");

    		if (!ComIsBtnEnable(srcName)) return;
    		
            switch(srcName) {
				case "btn_AddGroup":
					addGroup();
				break;
				
				case "btn_CopyGroup":
					copyGroup();
				break;
				
				case "btn_DelGroup":
					delGroup();
				break;
				
				case "btn_SaveGroup":
					saveGroup(false, false);
				break;
				
				case "btn_AddMultiCoverage":
					addMultiCoverage();
				break;
				
				case "btn_DelMultiCoverage":
					delSubSCException(sheetCVRGObj);
				break;
				
				case "btn_AddFreeTime":
					addFreeTime();
				break;
				
				case "btn_DelFreeTime":
					delSubSCException(sheetFTObj);
				break;
				
				case "btn_AddRateAdjustment":
					addRateAdjustment();
				break;
				
				case "btn_DelRateAdjustment":
					delSubSCException(sheetRTObj);
				break;
				
				case "btn_AddCustomer":
					addCustomer();
				break;
				
				case "btn_DelCustomer":
					delSubSCException(sheetCUSTObj);
				break;

				case "btn_AddCommodity":
					addCommodity();
				break;

				case "btn_DelCommodity":
					delSubSCException(sheetCMDTObj);
				break;
				
				case "btn_New":
					doActionNew();
				break;
				
				case "btn_Update":
					doActionUpdate();
				break;

				case "btn_Request":
					doActionRequest();
				break;
				
				case "btn_Delete":
					doActionDelete();
				break;
				
				case "btn_Accept":
					doActionAccept();
				break;

				case "btn_AcceptCancel":
					doActionAcceptCancel();						
				break;
				
				case "btn_Close":
					doActionClose();
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
  		var sheetSCObj=sheetObjects[0];
  		var sheetCMDTObj=sheetObjects[5];
        for (i=0 ; i < sheetObjects.length ; i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//1.Load on the screen, deactivating makes initializing The controls to be.
		initDisableObjects();
		//2.Depending on who to call, shall be determined to show a button.
		displayBtnByCaller();
  		//3.Page load,  initializing 
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_INIT);
		//4.Only Proposal No input, and search
		if (ComTrim(ComGetObjValue(document.getElementById("proposalNo"))) != "") {
			//4-1.S/C Exception is registered in the Inquiry data.
			doActionRetrieve(IBSEARCH);
		}
		else {
			//4-2.Version initializing .
			addComboItem(formObj.version,"001=",true);
			//4-3.the status of the main button, makes activating or deactivating depending on the given conditions.
			initBtnControl();
		}
	}
 	function initDisableObjects() {
		var formObj=document.form;
		with(formObj) {
			ComEnableManyObjects(false, sCNo, proposalNo, status, custCd, custNm);
			sCNo.className="input2";
			proposalNo.className="input2";
			status.className="input2";
			custCd.className="input2";
			custNm.className="input2";
		}		
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetid=sheetObj.id;
        switch(sheetid) {
            case "sheet1":
            	with(sheetObj){
	            	var HeadTitle1="|Seq.|Tariff|EFF DT|EXP DT|CNTR/CGO|Coverage|Coverage|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|CY/Door|Remark";
	            	var HeadTitle2="|Seq.|Tariff|EFF DT|EXP DT|CNTR/CGO|Multi|CN|Region/State|LOC|LOC|Y|Tier|Add|Total|SAT|SUN|H/day|CT|CN|Region/State|LOC|LOC|CN|Region/State|LOC|LOC|CY/Door|Remark";
	            	SetSelectionMode(smSelectionRow);
	            	SetConfig( { SearchMode:2, FrozenCol:11, MergeSheet:5, Page:100, DataRowMerge:1 } );
	            	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"},
	            	                { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:CNTRCGO,              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_MULTI,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
	            	             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:CVRG_POP,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:FT_FLG,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:FT_TIR,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ADD_DYS,              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, ToolTipText:"Additional Day", MinimumValue:0 },
	            	             {Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TOT_DYS,              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, ToolTipText:"Total Day", MinimumValue:0 },
	            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CTI,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CNT,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_RGN,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_LOC,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1},
	            	             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_POP,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CNT,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_RGN,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_LOC,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
	            	             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_POP,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:CYDOOR,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:REMARK,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PROP_NO,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:GRP_SEQ,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_CVRG_MULTI,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_CD,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FULL_REMARK,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_MANDATORY,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_CHECK,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:ROW_EDIT_STS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CMDT_FLG,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:ACT_CUST_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FM_TO_PAIR_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FT_ADD_FLG,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FT_ADJ_FLG,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_ADJ_FLG,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DMDT_FT_ADJ_TP_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREV_FT_FLG,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
	            	 ];
	            	 
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetColProperty(CVRG_MULTI, {ComboText:"Single|Multi", ComboCode:"S|M"} );
	            	SetColProperty(FT_TIR, {ComboText:"Single|Multi", ComboCode:"S|M"} );
	            	SetColProperty(CYDOOR, {ComboText:"|CY|Door", ComboCode:"|Y|D"} );
	            	FrozenCols=SaveNameCol(FT_FLG);
	            	//지원안함[확인요망]HANJIN: 					PopupImage="img/btns_multisearch.gif"
	            	SetShowButtonImage(2);
	            	SetSheetHeight(182,1);
	            	SetSheetWidth(mainTable.clientWidth);
	            	SetCountPosition(0);
	            	//SetVisible(false);
            	}
            break;
            
            case "sheet2":
                with(sheetObj){
					var HeadTitle1="|Seq.|BKG POD / CY|BKG POD / CY|BKG POD / CY|BKG POD / CY";
					var HeadTitle2="|Seq.|Country|Region/State|Location|Location";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					//동적으로 Sort 변경이 안되기 때문에, 기능패치가 이루어질때 까지는 임시적으로 Sheet 초기화시 Sort 기능을 차단함. 2014.08.26
					//var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };	
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
					{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//								동적으로 타이틀 변경시 sheet 에 설정된 EditLen 에 의해서 오류가 발생됨.(임시적으로 EditLen 을 삭제하고 사용함) 2014.08.26
//								{Type:"ComboEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
//								{Type:"ComboEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:CVRG_RGN,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
//								{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:CVRG_LOC,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
								{Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1 },
								{Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:CVRG_RGN,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:CVRG_LOC,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1 },
								{Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:CVRG_POP,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PROP_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:GRP_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_MANDATORY,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
								];
					
					InitColumns(cols);
					
					SetEditable(1);
	            	SetShowButtonImage(2);
	                SetSheetHeight(150,1);
					SetSheetWidth(mainTable.clientWidth);
					//SetVisible(false)
					SetCountPosition(0);
				}
            break;
            
            case "sheet3":
                with(sheetObj){
					var HeadTitle1="|CNTR Q'ty|CNTR Q'ty|Total";
					var HeadTitle2="|From|Up to|Total";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
					                { Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",   Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:FT_FROM,       KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
								{Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:FT_UPTO,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, MinimumValue:0 },
								{Type:"Int",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:FT_DAYS,       KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, MinimumValue:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PROP_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:GRP_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
					];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetSheetWidth(mainTable.clientWidth);
	                SetSheetHeight(150,1);
	               // SetVisible(false);
	                SetCountPosition(0);
            	}
            break;
            
            case "sheet4":
                with(sheetObj){
					var HeadTitle1="|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
					var HeadTitle2="|From|Up To|20 FT|40 FT|H/C|45 FT";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
					{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",   Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"Int",       Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:RT_FROM,       KeyField:1,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
								{Type:"Int",       Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:RT_UPTO,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
								{Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_20FT,       KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_40FT,       KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_HC,         KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:RT_45FT,       KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PROP_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:GRP_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
								];
					
					InitColumns(cols);
					SetEditable(1);
					SetSheetWidth(mainTable.clientWidth);
	                SetSheetHeight(150,1);
	                //SetVisible(false);
	                SetCountPosition(0);
            	}
            break;
            
            case "sheet5":
                with(sheetObj){
					var HeadTitle1="|Code|Name"
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",   Hidden:1, Width:30,   Align:"Center", ColMerge:1,   SaveName:"ibflag" },
								{Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center", ColMerge:0,   SaveName:CUST_CD,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0, Width:100,  Align:"Left",   ColMerge:0,   SaveName:CUST_NM,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center", ColMerge:0,   SaveName:PROP_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center", ColMerge:0,   SaveName:VER_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center", ColMerge:0,   SaveName:GRP_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center", ColMerge:0,   SaveName:ACT_CUST_FLG,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center", ColMerge:0,   SaveName:HID_STATUS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
								];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetSheetWidth(mainTable.clientWidth);
	                SetSheetHeight(100,1);
	                //SetVisible(false);
	                SetCountPosition(0);
            	}
            break;
            
            case "sheet6":
                with(sheetObj){
					var HeadTitle1="|Code|Name";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",   Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:CMDT_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:CMDT_NM,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PROP_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:GRP_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
								];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetSheetWidth(mainTable.clientWidth);
	                SetSheetHeight(100,1);
	               // SetVisible(false);
	                SetCountPosition(0);
            	}
            break;
            
            case "sheet7": // pre-search Region & State Info.
                with(sheetObj){
					var HeadTitle1="|Country|Code|Name";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rgn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
								];
					
					InitColumns(cols);
					
					SetEditable(1);
					//SetSheetWidth(400);
	                //SetSheetHeight(100);
	                SetVisible(false);
	                SetCountPosition(0);
            	}
            break;
        }
    }
	// Process of Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetCUSTObj=sheetObjects[4];
		var sheetCMDTObj=sheetObjects[5];
		var sheetRGNObj=sheetObjects[6];
    	var iRow = sheetObj.GetSelectRow();
	
		switch(sAction) {
	        //Page load,  initializing 
	        //1.Tariff Type, 2.CNTR/CGO Type, 3.Continent, 4.Country, 5.Region
	        case IBSEARCH_INIT:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		COMMAND01);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results =========================================================================
				tariffList 		= ComGetEtcData(sXml, "TARIFF");
				addCellComboItem(sheetObj, tariffList, "dmdt_trf_cd", false);
				
				//3-2.CNTR/CGO Type
				cntrCgoList		= ComGetEtcData(sXml, "CNTRCGO");
				addCellComboItem(sheetObj, cntrCgoList, "dmdt_cntr_cgo_tp_cd", false, true);
				
				//3-3.Origin or Dest. Continent
				continentList 	= ComGetEtcData(sXml, "CONTINENT");
				addCellComboItem(sheetObj, continentList, "sc_expt_fm_conti_cd", false);
				
				//3-4.Country
				countryList 	= ComGetEtcData(sXml, "COUNTRY");
				//3-4-1.Coverage CN 					
				addCellComboItem(sheetObj, 		countryList, 	"cnt_cd", 				false);
				//3-4-2.Group Sheet  Origin(I) or Dest.(D)
				addCellComboItem(sheetObj, 		countryList, 	"sc_expt_fm_cnt_cd",	false);
				//3-4-3.Group Sheet  BKG DEL(I) or POR(O)
				addCellComboItem(sheetObj, 		countryList, 	"fnl_dest_cnt_cd", 		false);
				//3-4-4.Multi Coverage Sheet  Country
				addCellComboItem(sheetCVRGObj, 	countryList, 	"cnt_cd", 				false);
				
				//3-5.Region
				regionList 		= ComGetEtcData(sXml, "REGION");
				//3-5-1.Group Sheet  Coverage State					
				addCellComboItem(sheetObj, 		regionList, 	"rgn_cd", 				false);
				//3-5-2.Group Sheet  Origin(I) or Dest.(D) :set RGN 
				addCellComboItem(sheetObj, 		regionList, 	"sc_expt_fm_rgn_cd", 	false);
				//3-5-3.Group Sheet  BKG DEL(I) or POR(O):set  State
				addCellComboItem(sheetObj, 		regionList, 	"fnl_dest_rgn_cd", 		false);
				//3-5-4.Multi Coverage Sheet :set Region.
				addCellComboItem(sheetCVRGObj, 	regionList, 	"rgn_cd", 				false);
				
				//3-6.S/C Duration
				ComSetObjValue(formObj.sc_eff_dt, 		handleNullString(ComGetEtcData(sXml, "EFF_DT")));
				ComSetObjValue(formObj.sc_exp_dt, 		handleNullString(ComGetEtcData(sXml, "EXP_DT")));
				//3-7.Accept, Accept Cancel button authority
				ComSetObjValue(formObj.isAcceptAuth,	handleNullString(ComGetEtcData(sXml, "HAS_AUTH")));
				//3-8. Search SC No.and Customer Cd and Customer Name by Proposal No.
	            ComSetObjValue(formObj.custCd, 			handleNullString(ComGetEtcData(sXml, "CUST_CD"))); //CUST_CNT_CD + CUST_SEQ(6)
	            ComSetObjValue(formObj.custNm, 			handleNullString(ComGetEtcData(sXml, "CUST_NM")));
	            ComSetObjValue(formObj.custSeq, 		handleNullString(ComGetEtcData(sXml, "CUST_SEQ"))); 
	            ComSetObjValue(formObj.sCNo, 			handleNullString(ComGetEtcData(sXml, "SC_NO")));
	            //3-9.Acutual Customer 
	            actCustList=handleNullString(ComGetEtcData(sXml, "CUST"));
	            addCellComboItem(sheetCUSTObj,actCustList, CUST_CD, false);
	            //3-10.Commodity
	            cmdtList=handleNullString(ComGetEtcData(sXml, "CMDT"));
	            addCellComboItem(sheetCMDTObj,cmdtList, CMDT_CD, false);
	            
	            sheetRGNObj.LoadSearchData(sXml, {Sync:1});
				//========================================================================================
	        break;
	        
	        case IBSEARCH:
				//S/C Exception Tariff
				if (sheetObj.id == "sheet1") {
					//1.Setting parametor condition, before retrieving
					ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.sc_expt_grp_seq, "");
					ComSetObjValue(formObj.f_cmd, 			SEARCH);
					//2.retrievie according to conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
					//sheetObj.DoSearch("EES_DMT_2001GS.do", FormQueryString(formObj));
					var sXml = sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml, {Sync:1});
					//*********************************************************************************
					ComOpenWait(false);
				}
				else if (sheetObj.id == "sheet2") {
					//1.Setting parametor condition, before retrieving
					ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.f_cmd, 		SEARCH);
					//2.retrievie according to conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
					//sheetObj.DoSearch("EES_DMT_2001GS.do", FormQueryString(formObj));
					var sXml = sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml, {Sync:1});
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************					
				}
				else if (sheetObj.id == "sheet3") {
					//1.Setting parametor condition, before retrieving
					ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.f_cmd, 		SEARCH);
					//2.retrievie according to conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
					//sheetObj.DoSearch("EES_DMT_2001GS.do", FormQueryString(formObj));
					var sXml = sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml, {Sync:1});
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************						
				}
				else if (sheetObj.id == "sheet4") {
					//1.Setting parametor condition, before retrieving
					with(sheetSCObj) {
						iRow = GetSelectRow();
	  	  				ComSetObjValue(formObj.cust_cnt_cd, 		ComTrim(ComGetObjValue(formObj.custCd)).substring(0,2));
	  	  				ComSetObjValue(formObj.cust_seq, 			ComTrim(ComGetObjValue(formObj.custCd)).substring(2));
						ComSetObjValue(formObj.dmdt_trf_cd, 		ComTrim(GetCellValue(iRow, TARIFF)));
						ComSetObjValue(formObj.eff_dt, 				ComTrim(GetCellValue(iRow, EFF_DT)));
						ComSetObjValue(formObj.exp_dt, 				ComTrim(GetCellValue(iRow, EXP_DT)));
						ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, ComTrim(GetCellValue(iRow, CNTRCGO)));
	  					ComSetObjValue(formObj.f_cmd, 				SEARCH01);
  	  				}
					//2.retrievie according to conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
					var result=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "RT_MANDATORY");
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************	
					//3.After handling Retrieving results
					ComSetObjValue(formObj.result, result);	
				}
			break;
			
	        case IBSEARCH_SCTARIFF:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.prop_no, 		sheetObj.GetCellValue(iRow, PROP_NO));
				ComSetObjValue(formObj.sc_expt_ver_seq, sheetObj.GetCellValue(iRow, VER_SEQ));
				ComSetObjValue(formObj.sc_expt_grp_seq, sheetObj.GetCellValue(iRow, GRP_SEQ));
				ComSetObjValue(formObj.f_cmd, 			SEARCH17);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************	
				//3.After handling Retrieving results
				with(sheetObj) {
					SetCellValue(iRow, TARIFF,handleNullString(ComGetEtcData(sXml, "TARIFF")),0);
					SetCellValue(iRow, EFF_DT,handleNullString(ComGetEtcData(sXml, "EFF_DT")),0);
					SetCellValue(iRow, EXP_DT,handleNullString(ComGetEtcData(sXml, "EXP_DT")),0);
					SetCellValue(iRow, CNTRCGO,handleNullString(ComGetEtcData(sXml, "CNTRCGO")),0);
					SetCellValue(iRow, CVRG_MULTI,handleNullString(ComGetEtcData(sXml, "CVRG_MULTI")),0);
					SetCellValue(iRow, CVRG_CNT,handleNullString(ComGetEtcData(sXml, "CVRG_CNT")),0);
					SetCellValue(iRow, CVRG_RGN,handleNullString(ComGetEtcData(sXml, "CVRG_RGN")),0);
					SetCellValue(iRow, CVRG_LOC,handleNullString(ComGetEtcData(sXml, "CVRG_LOC")),0);
					SetCellValue(iRow, FT_FLG,handleNullString(ComGetEtcData(sXml, "FT_FLG")),0);
					SetCellValue(iRow, FT_TIR,handleNullString(ComGetEtcData(sXml, "FT_TIR")),0);
					SetCellValue(iRow, ADD_DYS,handleNullString(ComGetEtcData(sXml, "ADD_DYS")),0);
					SetCellValue(iRow, TOT_DYS,handleNullString(ComGetEtcData(sXml, "TOT_DYS")),0);
					SetCellValue(iRow, SAT_FLG,handleNullString(ComGetEtcData(sXml, "SAT_FLG")),0);
					SetCellValue(iRow, SUN_FLG,handleNullString(ComGetEtcData(sXml, "SUN_FLG")),0);
					SetCellValue(iRow, HOL_FLG,handleNullString(ComGetEtcData(sXml, "HOL_FLG")),0);
					SetCellValue(iRow, ORGDST_CTI,handleNullString(ComGetEtcData(sXml, "ORGDST_CTI")),0);
					SetCellValue(iRow, ORGDST_CNT,handleNullString(ComGetEtcData(sXml, "ORGDST_CNT")),0);
					SetCellValue(iRow, ORGDST_RGN,handleNullString(ComGetEtcData(sXml, "ORGDST_RGN")),0);
					SetCellValue(iRow, ORGDST_LOC,handleNullString(ComGetEtcData(sXml, "ORGDST_LOC")),0);
					SetCellValue(iRow, BKGDEL_CNT,handleNullString(ComGetEtcData(sXml, "BKGDEL_CNT")),0);
					SetCellValue(iRow, BKGDEL_RGN,handleNullString(ComGetEtcData(sXml, "BKGDEL_RGN")),0);
					SetCellValue(iRow, BKGDEL_LOC,handleNullString(ComGetEtcData(sXml, "BKGDEL_LOC")),0);
					SetCellValue(iRow, CYDOOR,handleNullString(ComGetEtcData(sXml, "CYDOOR")),0);
					SetCellValue(iRow, REMARK,handleNullString(ComGetEtcData(sXml, "REMARK")),0);
					SetCellValue(iRow, PROP_NO,handleNullString(ComGetEtcData(sXml, "PROP_NO")),0);
					SetCellValue(iRow, VER_SEQ,handleNullString(ComGetEtcData(sXml, "VER_SEQ")),0);
					SetCellValue(iRow, GRP_SEQ,handleNullString(ComGetEtcData(sXml, "GRP_SEQ")),0);
					SetCellValue(iRow, CURR_CVRG_MULTI,handleNullString(ComGetEtcData(sXml, "CURR_CVRG_MULTI")),0);
					SetCellValue(iRow, CURR_CD,handleNullString(ComGetEtcData(sXml, "CURR_CD")),0);
					SetCellValue(iRow, FULL_REMARK,handleNullString(ComGetEtcData(sXml, "FULL_REMARK")),0);
					SetCellValue(iRow, RT_MANDATORY,handleNullString(ComGetEtcData(sXml, "RT_MANDATORY")),0);
					SetCellValue(iRow, RT_CHECK,handleNullString(ComGetEtcData(sXml, "RT_CHECK")),0);
					SetRowStatus(iRow,"R");
				}
	        break;
	        
	        case IBSEARCH_CHECK_DUP:
				//1.Setting parametor condition, before retrieving
				with(sheetObj) {
					ComSetObjValue(formObj.prop_no, 			GetCellValue(iRow, PROP_NO));
					ComSetObjValue(formObj.sc_expt_ver_seq, 	GetCellValue(iRow, VER_SEQ));
					ComSetObjValue(formObj.sc_expt_grp_seq, 	GetCellValue(iRow, GRP_SEQ));
					ComSetObjValue(formObj.dmdt_trf_cd,			GetCellValue(iRow, TARIFF));
					ComSetObjValue(formObj.eff_dt,				GetCellValue(iRow, EFF_DT));
					ComSetObjValue(formObj.exp_dt,				GetCellValue(iRow, EXP_DT));
					ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd,	GetCellValue(iRow, CNTRCGO));
					ComSetObjValue(formObj.sc_expt_fm_conti_cd,	GetCellValue(iRow, ORGDST_CTI));
					ComSetObjValue(formObj.sc_expt_fm_cnt_cd,	GetCellValue(iRow, ORGDST_CNT));
					if (GetCellValue(iRow, ORGDST_CNT) == "CA" || GetCellValue(iRow, ORGDST_CNT) == "US") {
						ComSetObjValue(formObj.sc_expt_fm_rgn_cd,	"");
						ComSetObjValue(formObj.sc_expt_fm_ste_cd,	GetCellValue(iRow, ORGDST_RGN));
					}
					else {
						ComSetObjValue(formObj.sc_expt_fm_rgn_cd,	GetCellValue(iRow, ORGDST_RGN));
						ComSetObjValue(formObj.sc_expt_fm_ste_cd,	"");
					}
					ComSetObjValue(formObj.sc_expt_fm_loc_cd,	GetCellValue(iRow, ORGDST_LOC));
					ComSetObjValue(formObj.fnl_dest_cnt_cd,		GetCellValue(iRow, BKGDEL_CNT));
					if (GetCellValue(iRow, BKGDEL_CNT) == "CA" || GetCellValue(iRow, BKGDEL_CNT) == "US") {
						ComSetObjValue(formObj.fnl_dest_rgn_cd,	"");
						ComSetObjValue(formObj.fnl_dest_ste_cd,	GetCellValue(iRow, BKGDEL_RGN));
					}
					else {
						ComSetObjValue(formObj.fnl_dest_rgn_cd,	GetCellValue(iRow, BKGDEL_RGN));
						ComSetObjValue(formObj.fnl_dest_ste_cd,	"");
					}
					ComSetObjValue(formObj.fnl_dest_loc_cd,		GetCellValue(iRow, BKGDEL_LOC));
					ComSetObjValue(formObj.rcv_de_term_cd,		GetCellValue(iRow, CYDOOR));
				}
				ComSetObjValue(formObj.f_cmd, 			SEARCH18);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "RESULT");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				ComSetObjValue(formObj.result, handleNullString(sResult));
        	break;
        	
	        case IBSEARCH_SUB:			
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 			SEARCH16);
				ComSetObjValue(formObj.prop_no, 		sheetObj.GetCellValue(iRow, PROP_NO));
				ComSetObjValue(formObj.sc_expt_ver_seq, sheetObj.GetCellValue(iRow, VER_SEQ));
				ComSetObjValue(formObj.sc_expt_grp_seq, sheetObj.GetCellValue(iRow, GRP_SEQ));
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObjects[1].SetWaitImageVisible(0);
				sheetObjects[2].SetWaitImageVisible(0);
				sheetObjects[3].SetWaitImageVisible(0);
				sheetObjects[4].SetWaitImageVisible(0);
				sheetObjects[5].SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//3.Result mapping in each Grid, after retrieving 
	            var arrXml=sXml.split("|$$|");
	            //3-1.Commodity
	            cmdtList = handleNullString(ComGetEtcData(arrXml[0], "CMDT"));
	            addCellComboItem(sheetCMDTObj, cmdtList, CMDT_CD, false);
	            
	            var sheetCnt=sheetObjects.length-1; // last sheet(sheet7) is region & state info. for cell combobox 
	            for (idx = 0; idx < sheetCnt-1; idx++) {
					//3-1. initializing  grid 
	            	sheetObjects[idx+1].RemoveAll();
					//3-2.Load  results
	            	if (idx < arrXml.length && ComGetTotalRows(arrXml[idx]) > 0) sheetObjects[idx+1].LoadSearchData(arrXml[idx], {Sync:1});
	            }
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (sheetObjects[4].RowCount()> 0) {
					ComSetObjValue(formObj.customerType, sheetObjects[4].GetCellValue(sheetObjects[4].HeaderRows(), ACT_CUST_FLG));
				}
				else {
					//(Actual Customer)
					ComSetObjValue(formObj.customerType, "Y");
				}
        	break;
        	
			case IBSEARCH_VER:	
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//********************************************************************************
				var sVer=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "VER");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
	            var verList=handleNullString(sVer);
				ComClearCombo(formObj.version);
				if (verList != "")
					addComboItem(formObj.version, verList, 	false);
				else
					addComboItem(formObj.version, "001=",	true);
			break;
			
			case IBSEARCH_VER_CHECK:	
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
				//2.retrievie according to conditions
				//*********************************************************************************
				//ComOpenWait(true);
				//sheetObj.WaitImageVisible = false;
				//********************************************************************************
				var sVer=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "VER");
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results(MAX VERSION, MAX VERSION STATUS)
	            var verList=handleNullString(sVer);
				var val=getMaxVersion(verList);
				ComSetObjValue(formObj.max_ver, val);	//max_version 
				var val2=getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
			break;
			
			case IBSEARCH_CUST:	
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH03);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//********************************************************************************
				var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "CUST");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Result mapping in each Grid, after retrieving 
				addCellComboItem(sheetObj,comboDatas,CUST_CD,false);
			break;
			
			//Tariff Type = 'DMIF, DMOF' , check Calc Type.
			case IBSEARCH_CALC:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 			SEARCH06);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
	            var comboDatas=ComGetEtcData(sXml, "CALC");
				ComSetObjValue(formObj.result, comboDatas);
				if (comboDatas == "E") {
					var cntCd=ComGetEtcData(sXml, "CNT");
					ComSetObjValue(formObj.result_cnt, cntCd);
					var steCd=ComGetEtcData(sXml, "STE");
					ComSetObjValue(formObj.result_ste, steCd);
					var rgnCd=ComGetEtcData(sXml, "RGN");
					ComSetObjValue(formObj.result_rgn, rgnCd);
					var locCd=ComGetEtcData(sXml, "LOC");
					ComSetObjValue(formObj.result_loc, locCd);
				}				
			break;
			
			//if Tariff Type = 'CTIC, CTOC' , check  Calc Type and Dual Type.				
			case IBSEARCH_DUAL:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 			SEARCH07);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
	            var comboDatas=ComGetEtcData(sXml, "CALC");
				ComSetObjValue(formObj.result, comboDatas);
				if (comboDatas == "E") {
					var cntCd=ComGetEtcData(sXml, "CNT");
					ComSetObjValue(formObj.result_cnt, cntCd);
					var steCd=ComGetEtcData(sXml, "STE");
					ComSetObjValue(formObj.result_ste, steCd);
					var rgnCd=ComGetEtcData(sXml, "RGN");
					ComSetObjValue(formObj.result_rgn, rgnCd);
					var locCd=ComGetEtcData(sXml, "LOC");
					ComSetObjValue(formObj.result_loc, locCd);
				}
			break;
			
			// Comparing Continent:  BKG POR(O) or DEL(I) Cnt_Cd and  Coverage 
			case IBSEARCH_CHKCONTI:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 			SEARCH08);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "EQUAL");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				ComSetObjValue(formObj.result, comboDatas);					
			break;
			
			case IBSEARCH_FILED:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 			SEARCH09);
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "FILED");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				ComSetObjValue(formObj.result, comboDatas);					
			break;
			
			case IBSAVE_SCTARIFF:        
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 			MULTI);
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString();
				var sParam2=sheetObjects[1].GetSaveString();
				var sParam3=sheetObjects[2].GetSaveString();
				var sParam4=sheetObjects[3].GetSaveString();
				var sParam5=sheetObjects[4].GetSaveString(true);	//all delete -> insert
				var sParam6=sheetObjects[5].GetSaveString(true);	//all delete -> insert
				if (sheetObjects[0].IsDataModified()== true) {
					sParam1=ComSetPrifix(sParam1, "subGRP");
					sParam=sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified()== true) {
					sParam2=ComSetPrifix(sParam2, "subCVRG");
					sParam=sParam + sParam2 + "&";
				}
				if (sheetObjects[2].IsDataModified()== true) {
					sParam3=ComSetPrifix(sParam3, "subFT");
					sParam=sParam + sParam3 + "&";
				}
				if (sheetObjects[3].IsDataModified()== true) {
					sParam4=ComSetPrifix(sParam4, "subRT");
					sParam=sParam + sParam4 + "&";
				}
				if (sheetObjects[4].IsDataModified()== true) {
					sParam5=ComSetPrifix(sParam5, "subCT");
					sParam=sParam + sParam5 + "&";
				}
				if (sheetObjects[5].IsDataModified()== true) {
					sParam6=ComSetPrifix(sParam6, "subCM");
					sParam=sParam + sParam6 + "&";
				}					
				sParam += "&" + FormQueryString(formObj);
				//2.save
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSaveData("EES_DMT_2001GS.do", sParam);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				
				//3. result
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
					var grpSeq=handleNullString(ComGetEtcData(sXml, "GRP_SEQ"));
					if (sheetObj.GetRowStatus(iRow) == "I") {
						sheetObj.SetCellValue(iRow, GRP_SEQ,grpSeq,0);
					}
					//======================================================================================					
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
            break;
            
			case IBSAVE_SCTARIFF_UPDATE:
				ComSetObjValue(formObj.f_cmd, 					MULTI02);
				ComSetObjValue(formObj.prop_no, 				sheetObj.GetCellValue(sheetObj.HeaderRows(), PROP_NO));
				ComSetObjValue(formObj.sc_expt_prev_ver_seq, 	sheetObj.GetCellValue(sheetObj.HeaderRows(), VER_SEQ));
				ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"T");
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "TRANS_RESULT_KEY");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************	
				if (sResult == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
            break;
            
			case IBSAVE_SCTARIFF_HISTORY:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 					MULTI03);
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, 		ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"T");
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "TRANS_RESULT_KEY");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************	
				if (sResult == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
            break;
            
			case IBSAVE_VERSTS:
				//1.Version status information before the change request, the selected parameter set to enter or allow.
				ComSetObjValue(formObj.f_cmd, 			SEARCH10);
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
				//2.Running modified input conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "TRANS_RESULT_KEY");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (sResult == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
			
			case IBDELETE:
				//1.Before deleting, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.f_cmd, 			SEARCH05);	
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
				//2.Delete the selected running conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "TRANS_RESULT_KEY");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (sResult == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
			
			case IBDELETE_SCTARIFF:
				//1.Before deleting, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.f_cmd, 			MULTI01);	
				//2.Delete the selected running conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sResult=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj), "TRANS_RESULT_KEY");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (sResult == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
			break;
			
	   		case IBSEARCH_ASYNC01:         // Search
	   			formObj.f_cmd.value=COMMAND15;
	   			var selRow=iRow;
	   			var param="f_cmd=" + COMMAND15
	   					  + "&cmdt_cd=" + sheetObj.GetCellText(iRow, "cmdt_cd")
	   					  ;
	       		//ComOpenWait Start
	   			sheetObj.SetWaitImageVisible(0);
	   			ComOpenWait(true);
	   			var rtnName=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", param, "rtnName");
	            //ComOpenWait End
	            ComOpenWait(false);
	            if ( rtnName != undefined && rtnName != '') {
	                var rtnNameArr=rtnName.split("|");
	                sheetObj.SetCellValue( selRow , 2 ,rtnNameArr[1],0);
	            } else {
	                ComShowCodeMessage( "DMT00165" , "Commodity code" );
	                sheetObj.SetCellValue( selRow , 1 ,"",0);
	                sheetObj.SetCellValue( selRow , 2 ,"",0);
	            }
	        break;
	        
	   		case IBSEARCH_ASYNC02:         // Search
	   			formObj.f_cmd.value=SEARCH19;
	   			var selRow=iRow;
	   			var param="f_cmd=" + SEARCH19
	   			          + "&cust_cnt_cd=" + sheetObj.GetCellText(iRow, "cust_cd").substring(0,2)
	   			          + "&cust_seq=" + ComLpad((sheetObj.GetCellText(iRow, "cust_cd").substring(2)),6,"0");
	   			          ;
	   			var rtnName=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", param, "CUST_NM");
	   			if ( rtnName != undefined && rtnName != '') {
	   				param="f_cmd=" + SEARCH19
		          	  	  + "&prop_no=" + ComGetObjValue(formObj.prop_no)
 			          	  + "&cust_cnt_cd=" + sheetObj.GetCellText(iRow, "cust_cd").substring(0,2)
 			          	  + "&cust_seq=" + ComLpad((sheetObj.GetCellText(iRow, "cust_cd").substring(2)),6,"0")
 			          	  ;
		       		//ComOpenWait Start
		   			sheetObj.SetWaitImageVisible(0);
		   			ComOpenWait(true);
		   			var rtnFlag=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", param, "rtnValue");
		            //ComOpenWait End
		            ComOpenWait(false);
	   				if(rtnFlag == "Y"){
		   				ComShowCodeMessage( "DMT01151" );
		   				sheetObj.SetCellValue( selRow , 1 ,"",0);
		   				sheetObj.SetCellValue( selRow , 2 ,"",0);
	   				}else{
	   					
	   					var sValue= sheetObj.GetCellText(iRow, "cust_cd").substring(0,2)
								+ ComLpad((sheetObj.GetCellText(iRow, "cust_cd").substring(2)),6,"0");
	   					
	   					sheetObj.SetCellValue( selRow , 1 ,sValue, 0);
		                sheetObj.SetCellValue( selRow , 2 ,rtnName,0);
	   				}
	   			}else{
	   				ComShowCodeMessage( "DMT00165" , "Customer code" );
	   				sheetObj.SetCellValue( selRow , 1 ,"",0);
	   				sheetObj.SetCellValue( selRow , 2 ,"",0);
	   			}
            break;
        }
    }
	// Combo-related functions to retrieve data
	function doActionIBCombo(sheetObj, formObj, sAction, sComboAction, sComboKey, sSetParameter) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		selectedRow=sheetObj.GetSelectRow();
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			selectedRow=ComGetObjValue(formObj.select_row);
		}
        switch(sAction) {
			case IBSEARCH:
				if (sSetParameter == undefined) sSetParameter=true;
				//1.Setting parametor condition, before retrieving
				if (sSetParameter) {
					setComboParameters(sheetObj, sComboAction, sComboKey);
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
				//3.After handling Retrieving results
				var comboDatas;
				switch(sComboAction) {
					case SEARCHLIST:
						comboDatas=ComGetEtcData(sXml, "common_tariff_cd");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;
					case SEARCH15:											
						comboDatas=ComGetEtcData(sXml, "COMMON_CD");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false,true);
						break;
					case SEARCH08:
						comboDatas=ComGetEtcData(sXml, "CONTI");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;
					case SEARCH02:
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (sComboKey == "ALL") {
							addCellComboItem(sheetObjects[0],comboDatas,"cnt_cd",false);

							addCellComboItem(sheetObjects[0],comboDatas,"sc_expt_fm_cnt_cd",false);

							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_cnt_cd",false);

							addCellComboItem(sheetObjects[1],comboDatas,"cnt_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
					//3-5.Search Region (All Region List)					
					case SEARCH01:
						comboDatas=ComGetEtcData(sXml, "RGN");
						if (sComboKey == "ALL") {
							//1.Group Sheet :set Coverage State						
							addCellComboItem(sheetObjects[0],comboDatas,"rgn_cd",false);
							//2.Group Sheet  Origin(I) or Dest.(D) :set  RGN 
							addCellComboItem(sheetObjects[0],comboDatas,"sc_expt_fm_rgn_cd",false);
							//3.Group Sheet  BKG DEL(I) or POR(O)  :set State
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_rgn_cd",false);
							//4.Multi Coverage Sheet  :set  Region
							addCellComboItem(sheetObjects[1],comboDatas,"rgn_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
					//3-6. Search Coverage RGN
					case SEARCH03:
						sComboKey=sComboKey.split(ROWMARK);
						//In response XML, Region or State allows to extract information entered in the list.
						var cntCd=sheetObj.GetCellValue(selectedRow, sComboKey[0]);
						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
							comboDatas=ComGetEtcData(sXml, "STE");
						} else {
							comboDatas=ComGetEtcData(sXml, "RGN");
						}
						// If you do not have the search results, Error Message show makes initializing to Empty.
						if (comboDatas == undefined || ComTrim(comboDatas) == "") {
							ComShowCodeMessage("DMT00110", "Country");
							sheetObj.SetCellValue(selectedRow, sComboKey[0],"");
							return;
						} else {
							addCellComboItem(sheetObj,comboDatas,sComboKey[1],true);
						}					
						break;
					//3-7.Coverage location of the parent item lookup (which corresponds to the location entered higher CN, RGN to be Inquiry)
					case SEARCH04:
						sComboKey=sComboKey.split(ROWMARK);
						//In response XML, Country information, choose from the list allows querying.
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							if (sheetObj.id == "sheet1" || sheetObj.id == "sheet2") selectedRow=sheetObj.GetSelectRow();
							//In response XML,  Region or State information, choose from the list allows querying.다.
							var cntCd=ComTrim(sheetObj.GetCellValue(selectedRow, sComboKey[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.SetCellValue(selectedRow, sComboKey[2],"",0);
						}
						break;
					//3-8.Search  Origin or Dest. CN 
					case SEARCH06:
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined && ComTrim(comboDatas) != "") {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						} else {
							ComShowCodeMessage("DMT00110", "Continent");
							sheetObj.SetCellValue(selectedRow, ORGDST_CTI,"");
							isValueSettingEvent=true;
							sheetObj.SetCellValue(selectedRow, ORGDST_CNT,"");
							isValueSettingEvent=false;
						}
						break;
					//3-9.Search  Origin or Dest. LOC 
					case SEARCH10:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=ComGetEtcData(sXml, "CONTI");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							//In response XML, Country information, choose from the list allows querying.
							comboDatas=ComGetEtcData(sXml, "CNT");
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							//In response XML,  Region or State information, choose from the list allows querying.다.
							var cntCd=sheetObj.GetCellValue(selectedRow, sComboKey[1]);
							if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
								comboDatas=ComGetEtcData(sXml, "STE");
							} else {
								comboDatas=ComGetEtcData(sXml, "RGN");
							}
							setCellComboItem(sheetObj, comboDatas, sComboKey[2], selectedRow);
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.SetCellValue(selectedRow, sComboKey[3],"",0);
						}
						break;
					//3-10. Search Origin or Dest. Country higher items
					case SEARCH12:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=ComGetEtcData(sXml, "CONTI");
						if (comboDatas != undefined && ComTrim(comboDatas) != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							//In response XML, Country information, choose from the list allows querying.
							comboDatas=ComGetEtcData(sXml, "CNT");
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
						}
						break;
					//3-11. Search Origin or Dest. Region higher items 
					case SEARCH13:
					//3-12. Search Origin or Dest. Region higher items 
					case SEARCH17:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=ComGetEtcData(sXml, "CONTI");
						if (comboDatas != undefined) {						
							if (ComTrim(sComboKey[0]) != "") {
								setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							}
							//In response XML, Country information, choose from the list allows querying.
							comboDatas=ComGetEtcData(sXml, "CNT");
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							//In response XML,  Region or State information, choose from the list allows querying.다.
							var cntCd=ComTrim(sheetObj.GetCellValue(selectedRow, sComboKey[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj, comboDatas, sComboKey[2], selectedRow);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							sheetObj.SetCellValue(selectedRow, sComboKey[2],"",0);
						}
						break;
					//3-13.Rate Adjustment  Currency
					case COMMAND05:
						ComClearCombo(formObj.currency);
						comboDatas=ComGetEtcData(sXml, sComboKey);
						comboDatas="=|" + comboDatas;
						addComboItem(formObj.currency,comboDatas,true);
						break;		
				};
				break;
        }
		sheetObj.SetWaitImageVisible(1);
    }	
    /**
     * Choose from a grid of data in the field makes the combo.
     */		
	function setCellComboItem(sheetObj, comboDatas, sComboKey, sComboRow) {
    	var formObj=document.form;
		if (comboDatas != undefined) {
			comboItem=comboDatas.split(FIELDMARK);
			sVal=comboItem[0];
		}
		else {
			sVal="";
		}
		sheetObj.SetCellValue(sComboRow, sComboKey,sVal);
	}
    /**
     * Grid Data in the field adds a combo.
     */		
	function addCellComboItem(sheetObj, comboDatas, sComboKey, isCellCombo, isOnlyTextView) {
    	var formObj=document.form;
		var comboItem;
		var comboItems;
		var comboTxt="";
		var comboVal="";
		var comboInitTxt="";
		var comboInitVal="";
		sRow=sheetObj.GetSelectRow();
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			sRow=ComGetObjValue(formObj.select_row);
		}
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems=comboDatas.split(ROWMARK);
			for (var i=0 ; i < comboItems.length ; i++) {
				comboItem=comboItems[i].split(FIELDMARK);
				//When InitDataCombo method call, if you do not select a value
				//Code, Value appears in the combo letter seeks to avoid being pushed.
				if (!isCellCombo && i == 0) {
					comboInitTxt=comboItem[0];
					comboInitVal=comboItem[0];
				}
				if (ComTrim(comboItem[0]) != "") {
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					} else {
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
			sheetObj.SetCellValue(sRow,colName,"",0);
		}
		else {
			sheetObj.SetColProperty(colName, {ComboText:comboTxt, ComboCode:comboVal} );
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
 	 * Max Version 
 	 * After searching, the result is returned.
 	 */
	function getMaxVersion(versions) {
		var ver_item;
		var ver_items;
		var val;
		if (versions != undefined) {
			ver_items=versions.split(ROWMARK);	
	    	for (var i=0 ; i < ver_items.length ; i++) {
	    		ver_item=ver_items[i].split(FIELDMARK);
				val=ver_item[0];
				break;
    		}
		}
		return val; 
	}
	/**
 	 * Max Version Status 
 	 * After searching, the result is returned.
 	 */
	function getMaxVersionStatus(versions) {
		var ver_item;
		var ver_items;
		var val;
		if (versions != undefined) {
			ver_items=versions.split(ROWMARK);	
	    	for (var i=0 ; i < ver_items.length ; i++) {
	    		ver_item=ver_items[i].split(FIELDMARK);
				val=ver_item[1];
				break;
    		}
		}
		if (val.indexOf(":") != -1) {
			var stsArr=val.split(":");
			val=stsArr[0]; 
		}
		return val;
	}
 	/**
 	 * Multi Origin or Destination   Rate Adjustment  check mandetory
 	 * After searching, the result is returned.
 	 */
 	function getRTMandatory() {
 		var sheetObj1=sheetObjects[0];
 		var sheetObj2=sheetObjects[1];
 		with(sheetObj1) {
			var propNo=GetCellValue(GetSelectRow(), PROP_NO);
			var verSeq=GetCellValue(GetSelectRow(), VER_SEQ);
			var grpSeq=GetCellValue(GetSelectRow(), GRP_SEQ);
 		}
 		var mark="N";
 		with(sheetObj2) {
	 		for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetCellValue(row, HID_STATUS) != "Y") {
					if (	propNo == GetCellValue(row, PROP_NO)
					&& verSeq == GetCellValue(row, VER_SEQ)
					&& grpSeq == GetCellValue(row, GRP_SEQ)	) {
						if (GetCellValue(row, RT_MANDATORY) == "Y") {
	 						mark="Y";
	 					}
	 				}
	 			}
	 		}
 		}
 		return mark;
 	}     
    /**
     * check Rate Adjustment .
     */	
	function setCheckMarkRTAdjust(selectedRow) {
    	 var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[3];
		var rowCount 	= fetchRowCount(sheetRTObj);
		var currCd=sheetSCObj.GetCellValue(selectedRow, CURR_CD);
		var isMandatory=sheetSCObj.GetCellValue(selectedRow, RT_MANDATORY);
		if (rowCount > 0 || currCd != "" || isMandatory == "Y") {
			sheetSCObj.SetCellValue(selectedRow, RT_CHECK,"Y");
		} else {
			sheetSCObj.SetCellValue(selectedRow, RT_CHECK,"N");
		}
	}
    /**
     * Rate Adjustment Sheet Currency 
     */	
	function searchCurrencyList(selectedRow) {
    	var formObj=document.form;
		var sheetRTObj=sheetObjects[3];
		if (getSCExceptionCountry(selectedRow) != "") {
			doActionIBCombo(sheetRTObj, formObj, IBSEARCH, COMMAND05, "CURRENCY");
		}
	}
    /**
     * selected GROUP ROW 's Coverage Country 
     */	
	function getSCExceptionCountry(selectedRow) {
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var cntCd="";
		
		if (sheetSCObj.GetCellValue(selectedRow, CVRG_MULTI) == "S") {
			cntCd=ComTrim(sheetSCObj.GetCellValue(selectedRow, CVRG_CNT));
		}
		else if (fetchRowCount(sheetCVRGObj) > 0) {
			cntCd=fetchColumnValueOfLastRow(sheetCVRGObj, CVRG_CNT);
		}
		return cntCd;	
	}
    /**
     * Currency value is selected the selected Row Group Sheet allows setting of the Currency field.
     */
	function setCurrencyVal() {
    	var formObj=document.form;
		var sheetObj=sheetObjects[0];
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), CURR_CD,ComTrim(ComGetObjValue(formObj.currency)));
	}
	/**
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setComboParameters(sheetObj, sAction, sComboKey) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		ComSetObjValue(formObj.f_cmd, sAction);			//Command
		var rgnCd="";
		if (sComboKey.indexOf("fnl") != -1 && sheetObj.GetSelectRow()>= sheetObj.HeaderRows()) {
			ComSetObjValue(formObj.conti_cd, 	"");
			ComSetObjValue(formObj.cnt_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), BKGDEL_CNT));		//BKG DEL(I) or POR(O) CN
			rgnCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), BKGDEL_RGN));
			if (rgnCd.length == 2) 
				ComSetObjValue(formObj.ste_cd, rgnCd);	//Coverage STE
			else 
				ComSetObjValue(formObj.rgn_cd, rgnCd);						//Coverage RGN
				ComSetObjValue(formObj.rgn_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), BKGDEL_RGN));		//BKG DEL(I) or POR(O) State
				ComSetObjValue(formObj.loc_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), BKGDEL_LOC));		//BKG DEL(I) or POR(O) LOC
		}
		else if (sComboKey.indexOf("sc") != -1 && sheetObj.GetSelectRow()>= sheetObj.HeaderRows()) {
				ComSetObjValue(formObj.conti_cd, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), ORGDST_CTI));		//Origin(I) or Dest.(O) CT
				ComSetObjValue(formObj.cnt_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), ORGDST_CNT));		//Origin(I) or Dest.(O) CN
				rgnCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), ORGDST_RGN));
			if (rgnCd.length == 2) 
				ComSetObjValue(formObj.ste_cd, rgnCd);	//Origin(I) or Dest.(O) STE
			else 
				ComSetObjValue(formObj.rgn_cd, rgnCd);						//Origin(I) or Dest.(O) RGN
			ComSetObjValue(formObj.loc_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), ORGDST_LOC));		//Origin(I) or Dest.(O) LOC
		}
		//Currency Rate Adjustment of the combo fills the lookup condition.
		else if (sComboKey == "CURRENCY") {
			if (sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_MULTI) == "S") {
				ComSetObjValue(formObj.cnt_cd, 	sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_CNT));
			}
			else if (fetchRowCount(sheetCVRGObj) > 0) {
				ComSetObjValue(formObj.cnt_cd, 	sheetCVRGObj.GetCellValue(sheetCVRGObj.HeaderRows(), CVRG_CNT));
			}
		}
		else if (sheetObj.GetSelectRow()>= sheetObj.HeaderRows()) {
			ComSetObjValue(formObj.conti_cd, 	"");
			ComSetObjValue(formObj.cnt_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_CNT));			//Coverage CN
			rgnCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_RGN));
			if (rgnCd.length == 2) 
				ComSetObjValue(formObj.ste_cd, rgnCd);	//Coverage STE
			else 
				ComSetObjValue(formObj.rgn_cd, rgnCd);						//Coverage RGN				
			ComSetObjValue(formObj.loc_cd, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_LOC));			//Coverage LOC
		}
	}
	/**
	 * calling POPUP
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		//alert("event name : sheet1_OnPopupClick(" + row + "," + sheetObj.ColSaveName(Col) + ")");
	    switch (sheetObj.ColSaveName(Col)) {
	        case CVRG_POP:
	            sUrl="/opuscntr/COM_ENS_051.do";
	            iWidth="1000";
	            iHeight="470";
	            ComOpenPopup(sUrl, iWidth, iHeight, "getCvrg", "0,0,1,1,1,1,1", true);
	            break;
	        case ORGDST_POP:
	            sUrl="/opuscntr/COM_ENS_051.do";
	            iWidth="1000";
	            iHeight="470";
	            ComOpenPopup(sUrl, iWidth, iHeight, "getOrgDst", "0,0,1,1,1,1,1", true);
	            break;
	        case BKGDEL_POP:
	            sUrl="/opuscntr/COM_ENS_051.do";
	            iWidth="1000";
	            iHeight="470";
	            ComOpenPopup(sUrl, iWidth, iHeight, "getBkgDel", "0,0,1,1,1,1,1", true);
	            break;
	    }
	}
	/**
	 * calling POPUP
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		//alert("event name : sheet1_OnPopupClick(" + row + "," + sheetObj.ColSaveName(Col) + ")");
	    switch (sheetObj.ColSaveName(Col)) {
	        case CVRG_POP:
	            sUrl="/opuscntr/COM_ENS_051.do";
	            iWidth="1000";
	            iHeight="470";
	            ComOpenPopup(sUrl, iWidth, iHeight, "getMultiCvrg", "0,0,1,1,1,1,1", true);
	            break;
	    }
	}

	/**
	 * mapping result in grid after ending location pop up successfully
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param sheetIdx
	 * @return
	 */
	function getCvrg(aryPopupData, row, col, sheetIdx) {
	    var formObj=document.form;
	    var location = "";
	    location = aryPopupData[0][3];
	    sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), CVRG_LOC,location,1);
	}

	/**
	 * mapping result in grid after ending location pop up successfully
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param sheetIdx
	 * @return
	 */
	function getMultiCvrg(aryPopupData, row, col, sheetIdx) {
	    var formObj=document.form;
	    var location = "";
	    location = aryPopupData[0][3];
	    sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), CVRG_LOC,location,1);
	}

	/**
	 * mapping result in grid after ending location pop up successfully
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param sheetIdx
	 * @return
	 */
	function getOrgDst(aryPopupData, row, col, sheetIdx) {
	    var formObj=document.form;
	    var location = "";
	    location = aryPopupData[0][3];
	    sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), ORGDST_LOC,location,1);
	}

	/**
	 * mapping result in grid after ending location pop up successfully
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param sheetIdx
	 * @return
	 */
	function getBkgDel(aryPopupData, row, col, sheetIdx) {
	    var formObj=document.form;
	    var location = "";
	    location = aryPopupData[0][3];
	    sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), BKGDEL_LOC,location,1);
	}
	
	/**
	 * Sheet1 change
	 */		 
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
	    var formObj=document.form;
		var sheetCVRGObj=sheetObjects[1];
		var sheetFTObj=sheetObjects[2];
		var isCoverageError=false; 
		
		switch(sheetObj.ColSaveName(Col)) {
			case TARIFF:
				changeCYDoor(sheetObj, Row);
				changeBKGDELorPOR(sheetObj, Row);
				//Tariff is selected depending on the type, Multi Coverage of the title is changed.(2009-07-28)
				setMultiCoverageTitle();
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.SetCellValue(Row, TARIFF,"",0);
				}
			break;
			
			case EFF_DT:
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.SetCellValue(Row, EFF_DT,"",0);
				}
			break;
			
			case EXP_DT:
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.SetCellValue(Row, EXP_DT,"",0);
				}
			break;
			
			case CNTRCGO:
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.SetCellValue(Row, CNTRCGO,"",0);
				}
			break;
			
			case CVRG_MULTI:
				//1. initializing Currency 
				ComClearCombo(formObj.currency);
				//2.Coverage Type change:  Rate Adjustment initializing
				sheetObj.SetCellValue(Row, RT_MANDATORY,"N");
				//3.depend on selected Multi Type, change Coverage
				setMultiCoverageGrid();
				//4-1.Multi Coverage :  Row  add
				if (Value == "M") {
					with(sheetObj) {
						SetCellValue(Row, CVRG_CNT, "", 0);
						SetCellValue(Row, CVRG_RGN, "", 0);
						SetCellValue(Row, CVRG_LOC, "", 0);
					}
					addMultiCoverage();
				}
				//4-2.Single : delete all in Multi Coverage
				else {
					delSubSCException(sheetCVRGObj, "All");
				}
			break;
			
			//======================================================================================================================
			case CVRG_CNT:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_CNT;
				var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				//If Country is Empty, All Region information is Inquiry.
				if (cntCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"rgn_cd");
					sheetObj.SetCellValue(Row,"rgn_cd","");
					ComClearCombo(formObj.currency); 
				}
				//Search information of Country belonging to the sub-Regsion or State 	
				else if (cntCd.length == 2) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH03,"cnt_cd|rgn_cd");
					searchCurrencyList(Row);
					sheetObj.SetCellValue(Row, CURR_CD,ComTrim(ComGetObjValue(formObj.currency)));
				}
				//If Country is changed, Location information erase.
				if (isClearLocation) clearLocation(sheetObj,"loc_cd");
				if (isRateCheckingCVRG == CVRG_CNT) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError=true;
					}
				}
				if (isRateCheckingCVRG == CVRG_CNT) isRateCheckingCVRG="";
			break;
			
			case CVRG_RGN:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_RGN;				
				if (isValueSettingEvent) return;	
				var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				//Search higher Country of  includes Region that includes
				switch(rgnCd.length) {
					case 2: 
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17,"|cnt_cd|rgn_cd");
						break;
					case 3:
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13,"|cnt_cd|rgn_cd");
						break;
				}
				//If Region is changed, Location information erase.
				if (isClearLocation) clearLocation(sheetObj,"loc_cd");
				if (isRateCheckingCVRG == CVRG_RGN) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError=true;
					}
				}				
				if (isRateCheckingCVRG == CVRG_RGN) isRateCheckingCVRG="";				
			break;
			
			case CVRG_LOC:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_LOC;
				var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
	    		if (locCd.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					//Search higher Country, Region or State of  Location includes
	    			doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH04,"cnt_cd|rgn_cd|loc_cd");
					isValueSettingEvent=false;
					isClearLocation=true;
				}
				else if (locCd.length > 0){
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}
				if (isRateCheckingCVRG == CVRG_LOC) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError=true;
					}
				}				
				if (isRateCheckingCVRG == CVRG_LOC) isRateCheckingCVRG="";	    		
			break;
			
			case FT_FLG:
				with(sheetObj) {
					if (Value == "1") {
						SetCellValue(Row, 		FT_TIR,  "S");
					}
					else {
						SetCellValue(Row, 		FT_TIR,  "");
						SetCellValue(Row, 		ADD_DYS, "");
						SetCellValue(Row, 		TOT_DYS, "");
					}
				}
			break;
			
			case FT_TIR:
				//1. Depending on selected Free Time Tier , Coverage's status change
				setTieredFreeTimeGrid();
				//2-1.Tiered Free Time, Row add
				if (Value == "M") {
					with(sheetObj) {
						SetCellValue(Row, 		ADD_DYS, "");
						SetCellValue(Row, 		TOT_DYS, "");
					}
					addFreeTime();
				}
				//2-2.Single : delete all data in Multi Coverage
				else {
					delSubSCException(sheetFTObj, "All");
				}
			break;
			
			//======================================================================================================================
			case ORGDST_CTI:
				var ctCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				//Continent is  Empty, all Country and all Region
				if (ctCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH02,"sc_expt_fm_cnt_cd");
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"sc_expt_fm_rgn_cd");
				}
				else if (ctCd.length == 1) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH06,"sc_expt_fm_cnt_cd");
				}
				if (isClearLocation) clearLocation(sheetObj,"sc_expt_fm_loc_cd");				
			break;
			
			case ORGDST_CNT:
				var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				//If Country is Empty, All Region information is Inquiry.
				if (cntCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"sc_expt_fm_rgn_cd");
					sheetObj.SetCellValue(Row,"sc_expt_fm_rgn_cd","");
				}
				else if (cntCd.length == 2) {
					if (!isValueSettingEvent) {
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH12,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd");
					}
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH03,"sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd");
				}
				//If Country is changed, Location information erase.
				if (isClearLocation) clearLocation(sheetObj,"sc_expt_fm_loc_cd");				
			break;
			
			case ORGDST_RGN:
				if (isValueSettingEvent) return;	
				var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				switch(rgnCd.length) {
					case 2: 
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd");
						break;
					case 3:
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd");
						break;
				}
				//If Region is changed, Location information erase.
				if (isClearLocation) clearLocation(sheetObj,"sc_expt_fm_loc_cd");				
			break;
			
			case ORGDST_LOC:
				var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					//Location (Continent, Country, Region or State)
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH10,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd|sc_expt_fm_loc_cd");
					isValueSettingEvent=false;
					isClearLocation=true;
				}
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}							
			break;
			
			case BKGDEL_CNT:
				if (getCoverageCNData(Row) == "") {
					sheetObj.SetCellValue(Row, BKGDEL_CNT,"",0);
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				//If Country is Empty, All Region information is Inquiry.
				if (cntCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"fnl_dest_rgn_cd");
					sheetObj.SetCellValue(Row,"fnl_dest_rgn_cd","");
				}
				else if (cntCd.length == 2) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH03,"fnl_dest_cnt_cd|fnl_dest_rgn_cd");
				}
				//If Country is changed, Location information erase.
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");
				if (!equalContinentByCN(Row)) {
					ComShowCodeMessage("DMT02008");
					sheetObj.SetCellValue(Row, BKGDEL_CNT,"");
					sheetObj.SetCellValue(Row, BKGDEL_LOC,"",0);
					return;
				}
			break;
			
			case BKGDEL_RGN:
				if (getCoverageCNData(Row) == "") {
					sheetObj.SetCellValue(Row, BKGDEL_RGN,"",0);
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				if (isValueSettingEvent) return;	
				var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				//Search higher Country of  includes Region that includes
				switch(rgnCd.length) {
					case 2: 
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
					case 3:
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
				}
				//If Region is changed, Location information erase.
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");						
			break;
			
			case BKGDEL_LOC:
				if (getCoverageCNData(Row) == "") {
					sheetObj.SetCellValue(Row, BKGDEL_LOC,"",0);
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					//Search higher Country, Region or State of  Location includes
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH04,"fnl_dest_cnt_cd|fnl_dest_rgn_cd|fnl_dest_loc_cd");
					isValueSettingEvent=false;
					isClearLocation=true;
				}	
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}							
			break;

			case REMARK:
				var remark = checkSpecialValue(sheetObj.GetCellValue(Row, REMARK));
				sheetObj.SetCellValue(Row, REMARK, remark);
				sheetObj.SetCellValue(Row, FULL_REMARK,sheetObj.GetCellValue(Row, REMARK));
			break;
		}
		if (isCoverageError) sheetObj.SetCellValue(Row, CVRG_CNT,"");
	}
   /**
	* Align the current selection state of ROW has been chosen to handle it functions to maintain
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (currGrpSeq == GetCellValue(row, GRP_SEQ)) {
					SetSelectRow(row);
					break;
				}
			}
		}
	}
	
	//SetSelectRow() 메소드 사용시, 무조건 OnSelectCell 이벤트가 발생됨.
	//IBSheet 제품에서 옵션값으로 OnSelectCell 이벤트가 발생되지 않도록 기능추가될 때까지, 아래와 같이
	//중복이벤트를 막을 수 있도록 전역변수를 사용함. 2014. 09. 03
	var isDupEventFlag = false;
	/**
	 *S/C Exception Tariff of the Group Seq. If the selection is changed, its sub-items are Inquiry.
	 */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var formObj=document.form;
		
		if (isDupEventFlag) 		 return;	// 중복이벤트 방지
    	if (isCopySCExceptionTariff) return;
		//Row selected whenever there is a change in position to perform the following logic.
		with(sheetObj) {
			if (OldRow >= HeaderRows()&& OldRow != NewRow) {
				//chkResult => 0: result, 1: Row, 2:input,modify,delete, 3:error
				var chkResult=isChangedSCExceptionTariff();
				if (chkResult[0]) {
					if (!ComShowCodeConfirm("DMT01112", "save")) {
						isDupEventFlag = true;
						SetSelectRow(OldRow);
						if (ColSaveName(OldCol) == CVRG_POP || ColSaveName(OldCol) == ORGDST_POP || ColSaveName(OldCol) == BKGDEL_POP) {
							if (!ComShowCodeConfirm("DMT01112", "save")) {
								isDupEventFlag = false;
								return;
							}
						}
						isDupEventFlag = false;
						//-------------------------------------------
						currGrpSeq=GetCellValue(GetSelectRow(), GRP_SEQ);
						//-------------------------------------------
						return;
					}
					isDupEventFlag = true;
					SetSelectRow(OldRow);
					isDupEventFlag = false;
					//-------------------------------------------
					currGrpSeq=GetCellValue(GetSelectRow(), GRP_SEQ);
					//-------------------------------------------
					if (!saveGroup(chkResult[0], true)) return;	
					//##################################################################
				}
				else {
					//-------------------------------------------
					currGrpSeq=GetCellValue(GetSelectRow(), GRP_SEQ);
					//-------------------------------------------
					setSubSCException(true);
				}
			}
			
			if(sheetObj.ColSaveName(NewCol) == CVRG_RGN) {
				var rowCnt = sheetObjects[6].RowCount();
				var info = {"ComboCode":"","ComboText":""};
				var comboCode = "";
				var comboText = "";

				if(sheetObj.GetCellValue(NewRow, CVRG_CNT) == "") {
					var isFirst = true;
					for(var i = 0; i < rowCnt; i++) {
						if(sheetObjects[6].GetCellValue(i, "cnt_cd") != "US" && sheetObjects[6].GetCellValue(i, "cnt_cd") != "CA") {
							if(!isFirst) {
								comboCode += ROWMARK;
								comboText += ROWMARK;
							}
							comboCode += sheetObjects[6].GetCellValue(i, "rgn_cd");
							comboText += sheetObjects[6].GetCellValue(i, "rgn_cd") + "\t" + sheetObjects[6].GetCellValue(i, "rgn_nm");
							isFirst = false;
						}
					}
				}else{
					var cnt = sheetObj.GetCellValue(NewRow, CVRG_CNT);
					var isFirst = true;
					for(var i = 0; i < rowCnt; i++) {
						if(sheetObjects[6].GetCellValue(i, "cnt_cd") == cnt) {
							if(!isFirst) {
								comboCode += ROWMARK;
								comboText += ROWMARK;
							}
							comboCode += sheetObjects[6].GetCellValue(i, "rgn_cd");
							comboText += sheetObjects[6].GetCellValue(i, "rgn_cd") + "\t" + sheetObjects[6].GetCellValue(i, "rgn_nm");
							isFirst = false;
						}
					}
				}

				info = {ComboText:comboText, ComboCode:comboCode};
				sheetObj.CellComboItem(NewRow, NewCol, info);
			//ORGDST_CNT ORGDST_RGN BKGDEL_CNT BKGDEL_RGN
			} else if(sheetObj.ColSaveName(NewCol) == ORGDST_RGN) {
				var rowCnt = sheetObjects[6].RowCount();
				var info = {"ComboCode":"","ComboText":""};
				var comboCode = "";
				var comboText = "";

				if(sheetObj.GetCellValue(NewRow, ORGDST_CNT) == "") {
					var isFirst = true;
					for(var i = 0; i < rowCnt; i++) {
						if(sheetObjects[6].GetCellValue(i, "cnt_cd") != "US" && sheetObjects[6].GetCellValue(i, "cnt_cd") != "CA") {
							if(!isFirst) {
								comboCode += ROWMARK;
								comboText += ROWMARK;
							}
							comboCode += sheetObjects[6].GetCellValue(i, "rgn_cd");
							comboText += sheetObjects[6].GetCellValue(i, "rgn_cd") + "\t" + sheetObjects[6].GetCellValue(i, "rgn_nm");
							isFirst = false;
						}
					}
				}else{
					var cnt = sheetObj.GetCellValue(NewRow, ORGDST_CNT);
					var isFirst = true;
					for(var i = 0; i < rowCnt; i++) {
						if(sheetObjects[6].GetCellValue(i, "cnt_cd") == cnt) {
							if(!isFirst) {
								comboCode += ROWMARK;
								comboText += ROWMARK;
							}
							comboCode += sheetObjects[6].GetCellValue(i, "rgn_cd");
							comboText += sheetObjects[6].GetCellValue(i, "rgn_cd") + "\t" + sheetObjects[6].GetCellValue(i, "rgn_nm");
							isFirst = false;
						}
					}
				}

				info = {ComboText:comboText, ComboCode:comboCode};
				sheetObj.CellComboItem(NewRow, NewCol, info);
			} else if(sheetObj.ColSaveName(NewCol) == BKGDEL_RGN) {
				var rowCnt = sheetObjects[6].RowCount();
				var info = {"ComboCode":"","ComboText":""};
				var comboCode = "";
				var comboText = "";

				if(sheetObj.GetCellValue(NewRow, BKGDEL_CNT) == "") {
					var isFirst = true;
					for(var i = 0; i < rowCnt; i++) {
						if(sheetObjects[6].GetCellValue(i, "cnt_cd") != "US" && sheetObjects[6].GetCellValue(i, "cnt_cd") != "CA") {
							if(!isFirst) {
								comboCode += ROWMARK;
								comboText += ROWMARK;
							}
							comboCode += sheetObjects[6].GetCellValue(i, "rgn_cd");
							comboText += sheetObjects[6].GetCellValue(i, "rgn_cd") + "\t" + sheetObjects[6].GetCellValue(i, "rgn_nm");
							isFirst = false;
						}
					}
				}else{
					var cnt = sheetObj.GetCellValue(NewRow, BKGDEL_CNT);
					var isFirst = true;
					for(var i = 0; i < rowCnt; i++) {
						if(sheetObjects[6].GetCellValue(i, "cnt_cd") == cnt) {
							if(!isFirst) {
								comboCode += ROWMARK;
								comboText += ROWMARK;
							}
							comboCode += sheetObjects[6].GetCellValue(i, "rgn_cd");
							comboText += sheetObjects[6].GetCellValue(i, "rgn_cd") + "\t" + sheetObjects[6].GetCellValue(i, "rgn_nm");
							isFirst = false;
						}
					}
				}

				info = {ComboText:comboText, ComboCode:comboCode};
				sheetObj.CellComboItem(NewRow, NewCol, info);
			}
		}
	}
	/*
	 * 
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		with(sheetObj) {
			var colName = ColSaveName(MouseCol());
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					//if Tariff = DMOF , balloon message "BKG POL/CY"
					//         if Tariff = DMIF , balloon message "BKG POD/CY"
					//         if Tariff = DTOC or  CTOC ,  balloon message "BKG POR"
					//         if Tariff = DTIC or CTIC  ,  balloon message "BKG DEL"				
					switch(trfCd) {
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); 	 break;
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL");    break;
						default:     SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					//if Tariff =  DMOF or DTOC or CTOC ,  balloon message "BKG DEL"
					//         if Tariff =  DMIF or DTIC or CTIC ,  balloon message "BKG POR" 		
					switch(trfCd) {
						case "DMOF":
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					//if Tariff =  DMIF ,  balloon message "BKG DEL for Demurrage Only"
					//         if Tariff =  DMOF ,  balloon message "BKG POR for Demurrage Only" 		
					switch(trfCd) {
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL for Demurrage Only"); break;
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POR for Demurrage Only"); break;
						default:     SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}				
				else if (colName == CYDOOR) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					//Tariff = DTIC, CTIC: balloon message "BKG DEL Term for Detention Only"
					//         DTOC, CTOC : balloon message "BKG RCV Term for Detention Only" 		
					switch(trfCd) {
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL Term for Detention Only"); break;
						case "DTOC": 
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG RCV Term for Detention Only"); break;
						default:     SetToolTipText(MouseRow(), MouseCol(), "");
					}					
				}
				else if (colName == REMARK)	{
					SetToolTipText(MouseRow(), MouseCol(), GetCellValue(MouseRow(), FULL_REMARK));
				}		
			}
		}		
	}
	/*
	 * Sheet2(Multi Coverage) 
	 */		 
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var isCoverageError=false; 
		switch(sheetObj.ColSaveName(Col)) {
			case CVRG_CNT:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_CNT;
				var isDeleteRowValue=false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue=true;
				}
				//================================================================================================================================
				if (Value.length == 0) {
					doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01, "rgn_cd"); 
					if (isDeleteRowValue) {
						ComSetObjValue(formObj.select_row, 	"");
					}
					sheetObj.SetCellValue(Row, "rgn_cd","");
					ComClearCombo(formObj.currency); 	
				}
				else if (Value.length == 2) {
					ComSetObjValue(formObj.cnt_cd,		Value);	
					ComSetObjValue(formObj.f_cmd,		SEARCH03);
					doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03, "cnt_cd|rgn_cd", false);
					if (isDeleteRowValue) {
						ComSetObjValue(formObj.select_row, 	"");
					}
					var rowCount = fetchRowCount(sheetObj);
					if (rowCount < 2) {
						searchCurrencyList(sheetSCObj.GetSelectRow());
						sheetSCObj.SetCellValue(sheetSCObj.GetSelectRow(), CURR_CD,ComTrim(ComGetObjValue(formObj.currency)));
					}
				}
				//If Country is changed, Location information erase.
				if (isClearLocation) sheetObj.SetCellValue(Row, CVRG_LOC,"",0);
				if (isRateCheckingCVRG == CVRG_CNT) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError=true;
					}
				}
				if (isRateCheckingCVRG == CVRG_CNT) isRateCheckingCVRG="";
				break;
			case CVRG_RGN:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_RGN;
				if (isValueSettingEvent) return;	
				var isDeleteRowValue=false;
				//Region or State 의 Continent, Country, Region ===================================================================
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue=false;
				}
				if (Value.length == 2) {
					ComSetObjValue(formObj.rgn_cd,		"");	
					ComSetObjValue(formObj.ste_cd,		Value);
				}
				else {
					ComSetObjValue(formObj.rgn_cd,		Value);	
					ComSetObjValue(formObj.ste_cd,		"");
				}
				switch(Value.length) {
					case 2:
						ComSetObjValue(formObj.f_cmd,		SEARCH17);
						doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH17, "|cnt_cd|rgn_cd", false);
						break;
					case 3:
						ComSetObjValue(formObj.f_cmd,		SEARCH13);
						doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH13, "|cnt_cd|rgn_cd", false);
						break;
				}
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				//================================================================================================================================
				//If Region is changed, Location information erase.
				if (isClearLocation) sheetObj.SetCellValue(Row, CVRG_LOC,"",0);
				//Rate Adjustment check mandetory items
				if (isRateCheckingCVRG == CVRG_RGN) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError=true;
					}
				}
				if (isRateCheckingCVRG == CVRG_RGN) isRateCheckingCVRG="";					
				break;	
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//[Location] change++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case CVRG_LOC:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_LOC;
				if (Value.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					//Search higher Country, Region or State of  Location includes ===================================================================
					// should set the parameters for search. (loc_cd if only because this is seoljeonghaeju fields.)
					ComSetObjValue(formObj.loc_cd,		Value);	
					ComSetObjValue(formObj.select_row, 	Row);
					ComSetObjValue(formObj.f_cmd,		SEARCH04);
					//The last parameter in doActionIBCombo set the parameters for query tells you whether you want to.
					doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH04, "cnt_cd|rgn_cd|loc_cd", false); 
					// After completing the search, the following parameters are not removed.
					ComSetObjValue(formObj.select_row, 	"");
					//==========================================================================================================================
					isValueSettingEvent=false;
					isClearLocation=true;
				}		
				else if (Value.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}
				//Rate Adjustment check mandetory items
				if (isRateCheckingCVRG == CVRG_LOC) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError=true;
					}
				}
				if (isRateCheckingCVRG == CVRG_LOC) isRateCheckingCVRG="";
				break;
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		}
		//case in  Rate Adjustment Mandatory checked, if occuer error in Coverage, then Clear all.
		if (isCoverageError) sheetObj.SetCellValue(Row, CVRG_CNT,"");
	}
	/*
	 * Sheet2 mouse over.
	 */	
	function sheet2_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		var sheetSCObj=sheetObjects[0];
		with(sheetObj) {
			var colName = ColSaveName(MouseCol());
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					var trfCd=sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), TARIFF);
					//if Tariff = DMOF , balloon message "BKG POL/CY"
					//         if Tariff = DMIF , balloon message "BKG POD/CY"
					//         if Tariff = DTOC or  CTOC ,  balloon message "BKG POR"
					//         if Tariff = DTIC or CTIC  ,  balloon message "BKG DEL"				
					switch(trfCd) {
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
					}
				}			
			}
		}		
	}
	/*
	 * Sheet3(Tiered Free Time) change
	 */		 
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetObj=sheetObjects[2];
		with(sheetObj) {
			switch(ColSaveName(Col)) {
			case FT_UPTO:
				if (	ComTrim(GetCellValue(Row, FT_FROM)) != ""
					&& 	ComTrim(GetCellValue(Row, FT_UPTO)) != ""
					&& 	ComParseInt(GetCellValue(Row, FT_FROM)) > ComParseInt(GetCellValue(Row, FT_UPTO))) {
					ComShowCodeMessage("DMT01032", "[Tiered Free Time]");
					SetCellValue(Row, FT_UPTO,"",0);
					return;
				}
				var ftUpTo=ComTrim(GetCellValue(Row,Col));
				var ftFmTo=ComParseInt(ftUpTo) + 1;
				var nextRow=getNextRow(Row, sheetObj);
				if (nextRow > 0) {
					SetCellValue(nextRow, FT_FROM,ftFmTo,0);
				}
				break;
			}
		}
	 }
	/*
	 * Sheet4(Rate Adjustment) change
	 */		 
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetObj=sheetObjects[3];
		with(sheetObj) {
			switch(ColSaveName(Col)) {
			case RT_UPTO:
				if (	ComTrim(GetCellValue(Row, RT_FROM)) != ""
					&& 	ComTrim(GetCellValue(Row, RT_UPTO)) != ""
					&& 	ComParseInt(GetCellValue(Row, RT_FROM)) > ComParseInt(GetCellValue(Row, RT_UPTO))) {
					ComShowCodeMessage("DMT01032", "[Rate Adjustment]");
					SetCellValue(Row, RT_UPTO,"",0);
					return;
				}
				var rtUpTo=ComTrim(sheetObj.GetCellValue(Row,Col));
				var rtFmTo=ComParseInt(rtUpTo) + 1;
				var nextRow=getNextRow(Row, sheetObj);
				if (nextRow > 0) {
					SetCellValue(nextRow, RT_FROM,rtFmTo + "",0);
				}
				break;
			}
		}
	}
	/*
	 * Sheet5(Actual Customer) change
	 */		 
	function sheet5_OnChange(sheetObj,Row,Col,Value) {
		switch(sheetObj.ColSaveName(Col)) {
			case CUST_CD:
				var row_value=sheetObj.GetCellText(Row, Col);
				if(row_value.length < 3) {
					ComShowCodeMessage( "DMT00165" , "Customer code" );
					sheetObj.SetCellValue(Row, CUST_CD,"",0);
					sheetObj.SetCellValue(Row, CUST_NM,"",0);
				} else {
		    		var cust_cnt_cd=row_value.substring(0,2);
		    		var cust_seq=row_value.substring(2);
		    		if(isNaN(cust_seq)){
		    			ComShowCodeMessage( "DMT00165" , "Customer code" );
		    			sheetObj.SetCellValue(Row, CUST_CD,"",0);
						sheetObj.SetCellValue(Row, CUST_NM,"",0);
		    		}else{
		    			if (ComLpad(cust_seq,6,"0")!="000000"){
		    				sheetObj.SetCellValue(Row, CMDT_CD,cust_cnt_cd+ComLpad(cust_seq,6,"0"),0);
		    			}
		    			doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02); 
		    		}
				}
				break;
		}		
	}
	/*
	 * Sheet6(Commodity) change
	 */		 
	function sheet6_OnChange(sheetObj,Row,Col,Value) {
		switch(sheetObj.ColSaveName(Col)) {
			case CMDT_CD:
				var row_value=sheetObj.GetCellText(Row, Col);
				if (row_value == "") {
					sheetObj.SetCellValue(Row, CMDT_CD,"",0);
					sheetObj.SetCellValue(Row, CMDT_NM,"",0);
				} else {
					doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01); 	
				}
				break;
		}		
	}	
	/**
	 * Location  initializing
	 */		
	function clearLocation(sheetObj, sComboKey) {
		selectedRow=sheetObj.GetSelectRow();
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			selectedRow=ComGetObjValue(formObj.select_row);
		}
		sheetObj.SetCellValue(selectedRow, sComboKey,"",0);
	}
	/**
	 * Coverage initializing.
	 */	
	function clearCoverage() {
		var sheetObj=sheetObjects[0];
		sheetObj.SetCellText(sheetObj.GetSelectRow(),CVRG_CNT ,"");
		sheetObj.SetCellText(sheetObj.GetSelectRow(),CVRG_RGN ,"");
		isRateCheckingCVRG="No Checking";
		sheetObj.CellComboItem(sheetObj.SelectRow,CVRG_RGN, {ComboText:"", ComboCode:""} );
		isRateCheckingCVRG="";
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), CVRG_LOC,"",0);
	}
	/**
	 * CY/Door change status : case in Tariff = DTIC/DTOC/CTIC/CTOC, activating 
	 */		
	function changeCYDoor(sheetObj,Row) {
		var trfCd=ComTrim(sheetObj.GetCellValue(Row,TARIFF));
		if (trfCd == "DTIC" || trfCd == "DTOC" || trfCd == "CTIC" || trfCd == "CTOC") {
			sheetObj.SetCellEditable(Row,CYDOOR,1);
		}
		else {
			sheetObj.SetCellValue(Row,CYDOOR,"");
			sheetObj.SetCellEditable(Row,CYDOOR,0);
		}		
	}
	/**
	 * BKG DEL(I) or PRO(O) change status  : case in Tariff = DMIF/DMOF ,  activating 
	 */		
	function changeBKGDELorPOR(sheetObj,Row) {
		var trfCd=ComTrim(sheetObj.GetCellValue(Row,TARIFF));
		if (trfCd == "DMIF" || trfCd == "DMOF") {
			sheetObj.SetCellEditable(Row,BKGDEL_CNT,1);
			sheetObj.SetCellEditable(Row,BKGDEL_RGN,1);
			sheetObj.SetCellEditable(Row,BKGDEL_LOC,1);
			sheetObj.SetCellEditable(Row,BKGDEL_POP,1);
		}
		else {
			sheetObj.SetCellValue(Row,BKGDEL_CNT,"",0);
			sheetObj.SetCellValue(Row,BKGDEL_RGN,"",0);
			sheetObj.SetCellValue(Row,BKGDEL_LOC,"",0);
			sheetObj.SetCellEditable(Row,BKGDEL_CNT,0);
			sheetObj.SetCellEditable(Row,BKGDEL_RGN,0);
			sheetObj.SetCellEditable(Row,BKGDEL_LOC,0);
			sheetObj.SetCellEditable(Row,BKGDEL_POP,0);
		}
	}	
	/*
	 * Group add.
	 */		
	function addGroup() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetFTObj=sheetObjects[2];
		var sheetRTObj=sheetObjects[3];
		var sheetCUSTObj=sheetObjects[4];
		var sheetCMDTObj=sheetObjects[5];		
		//1.Row Add button click, no Saving row: “Data was changed. Do you want to save?” Alert  ==========================
		var chkResult=isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				if (!saveGroup(chkResult[0], true)) return;	
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		//==========================================================================================================================
		with(sheetSCObj) {
			if (fetchRowCount(sheetSCObj) > 0) {
				propNo=GetCellValue(LastRow(), PROP_NO);
				verSeq=GetCellValue(LastRow(), VER_SEQ);
			} else {
				propNo=ComGetObjValue(formObj.proposalNo);
				verSeq=ComParseInt(ComGetObjText(formObj.version));
			}
			isCopySCExceptionTariff=true;
			DataInsert(-1);
			isCopySCExceptionTariff=false;
			SetCellValue(LastRow(), PROP_NO,propNo,0);
			SetCellValue(LastRow(), VER_SEQ,verSeq,0);
			SetCellValue(LastRow(), GRP_SEQ,"",0);
			//EFF DT, EXP DT  S/C Duration  default setting
			SetCellValue(LastRow(), EFF_DT,ComGetObjValue(formObj.sc_eff_dt),0);
			SetCellValue(LastRow(), EXP_DT,ComGetObjValue(formObj.sc_exp_dt),0);
			//Default  Y check 
			SetCellValue(LastRow(), FT_FLG,"1",0);
			SetCellValue(LastRow(), PREV_FT_FLG,"1",0);
			SetCellValue(LastRow(), ROW_EDIT_STS,"Y",0);
			SetCellValue(LastRow(), CURR_CD,"",0);
			SetCellValue(LastRow(), RT_MANDATORY,"N",0);
		}
		//Multi Coverage check box and input status makes changes.(button )
		setMultiCoverageGrid();
		sheetCVRGObj.RemoveAll();
		//Tiered Free Time  status change .(button )
		setTieredFreeTimeGrid();
		sheetFTObj.RemoveAll();
		// the check box and input status of Rate Adjustment  makes changes.(button )
		setRateAdjustmentGrid();
		sheetRTObj.RemoveAll();
		//Custmoer grid Clear 
		setCustomerGrid();
		sheetCUSTObj.RemoveAll();
		//Commodity grid Clear 
		setCommodityGrid();
		sheetCMDTObj.RemoveAll();
	}
	/*
	 * Multi Coverage add.
	 */		
	function addMultiCoverage() {
	    var formObj=document.form;
	    var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var cvrgSeq="";
		if (formObj.chkMultiCoverage.checked) {
			cvrgSeq=fetchColumnValueOfLastRow(sheetCVRGObj, CVRG_SEQ);
			cvrgSeq=cvrgSeq  == "" ? 1 : ComParseInt(cvrgSeq)  + 1;
			//Multi Coverage add Row.
			with(sheetCVRGObj) {
				var iRow = DataInsert(-1);
				SetCellValue(iRow, PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
				SetCellValue(iRow, VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(iRow, GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
				SetCellValue(iRow, CVRG_SEQ,cvrgSeq,0);
			}
		}
	}
	/*
	 * Tiered Free Time add.
	 */		
	function addFreeTime() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetFTObj=sheetObjects[2];
		var ftSeq="";
		var ftUpTo="";
		var ftFrom="";
		if (fetchRowCount(sheetFTObj) > 0) {
			if (fetchColumnValueOfLastRow(sheetFTObj, FT_UPTO) == "") {
				ComShowCodeMessage("DMT02002", "Up to");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetFTObj, FT_DAYS) == "") {
				ComShowCodeMessage("DMT02002", "Total");
				return;					
			}
		}
		if (formObj.chkFreeTime.checked) {
			ftSeq=fetchColumnValueOfLastRow(sheetFTObj, FT_SEQ);
			ftUpTo=fetchColumnValueOfLastRow(sheetFTObj, FT_UPTO);
			ftSeq=ftSeq  == "" ? 1 : ComParseInt(ftSeq)  + 1;
			ftFrom=ftUpTo == "" ? 1 : ComParseInt(ftUpTo) + 1;
			//Tiered Free Time  add Row..
			with(sheetFTObj) {
				var iRow = DataInsert(-1);
				SetCellValue(iRow, 	PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
				SetCellValue(iRow, 	VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(iRow, 	GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
				SetCellValue(iRow, 	FT_SEQ,ftSeq,0);
				SetCellValue(iRow, 	FT_FROM,ftFrom,0);
				SetCellEditable(iRow, 	FT_FROM,0);
			}
		}
	}
	/*
	 * Rate Adjustment add.
	 */		
	function addRateAdjustment() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[3];
		var rtSeq="";
		var rtUpTo="";
		var rtFrom="";
		if (fetchRowCount(sheetRTObj) > 0) {
			if (fetchColumnValueOfLastRow(sheetRTObj, RT_UPTO) == "") {
				ComShowCodeMessage("DMT02002", "Up to");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_20FT) < 0) {
				ComShowCodeMessage("DMT01128", "20FT", "0");
				return;
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_40FT) < 0) {
				ComShowCodeMessage("DMT01128", "40FT", "0");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_HC) < 0) {
				ComShowCodeMessage("DMT01128", "H/C", "0");
				return;
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_45FT) < 0) {
				ComShowCodeMessage("DMT01128", "45FT", "0");
				return;
			}
		}
		if (formObj.chkRateAdjustment.checked) {
			rtSeq=fetchColumnValueOfLastRow(sheetRTObj, RT_SEQ);
			rtUpTo=fetchColumnValueOfLastRow(sheetRTObj, RT_UPTO);
			rtSeq=rtSeq  == "" ? 1 : ComParseInt(rtSeq)  + 1;
			rtFrom=rtUpTo == "" ? 1 : ComParseInt(rtUpTo) + 1;
			//Rate Adjustment  add Row.
			with(sheetRTObj) {
				var iRow = DataInsert(-1);
				SetCellValue(iRow, 	PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
				SetCellValue(iRow, 	VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(iRow, 	GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
				SetCellValue(iRow, 	RT_SEQ,rtSeq,0);
				SetCellValue(iRow, 	RT_FROM,rtFrom,0);
				SetCellEditable(iRow, 	RT_FROM,0);
			}
		}
	}
	/*
	 * Actual Customer add.
	 */		
	function addCustomer() {
		var sheetSCObj=sheetObjects[0];
		var sheetCUSTObj=sheetObjects[4];
		if (fetchRowCount(sheetCUSTObj) > 0 && fetchColumnValueOfLastRow(sheetCUSTObj, CUST_CD) == "") {
			ComShowCodeMessage("DMT02002", "Code");
			return;					
		}
		with(sheetCUSTObj) {
			var iRow = DataInsert(-1);
			SetCellValue(iRow, 	PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
			SetCellValue(iRow, 	VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
			SetCellValue(iRow, 	GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
		}
	}
	/*
	 * Commodity add.
	 */		
	function addCommodity() {
		var sheetSCObj=sheetObjects[0];		 
		var sheetCMDTObj=sheetObjects[5];
		if (fetchRowCount(sheetCMDTObj) > 0 && fetchColumnValueOfLastRow(sheetCMDTObj, CMDT_CD) == "") {
			ComShowCodeMessage("DMT02002", "Code");
			return;					
		}
		var iRow = sheetCMDTObj.DataInsert(-1);
		var iRow2 = sheetSCObj.GetSelectRow();
		
		sheetCMDTObj.SetCellValue(iRow, 	PROP_NO, sheetSCObj.GetCellValue(iRow2, PROP_NO), 0);
		sheetCMDTObj.SetCellValue(iRow, 	VER_SEQ, sheetSCObj.GetCellValue(iRow2, VER_SEQ), 0);
		sheetCMDTObj.SetCellValue(iRow, 	GRP_SEQ, sheetSCObj.GetCellValue(iRow2, GRP_SEQ), 0);
	}		
    /**
	 * S/C Exception Tariff sub-grid within the last Row of data is not deleted, a function that returns the value of the specified Column
	 */
	function fetchColumnValueOfLastRow(sheetObj, COL) {
		var lastColumnValue="";
		with(sheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) != "D") {
					lastColumnValue=sheetObj.GetCellValue(row, COL);
					//Multi Coverage Rate Adjustment in the case of essential items, Country values ??must be present. At this time, this function when reading from the Country value,
					//If the value of the last row, the higher row so that the processing load values??. (Multi Coverage Row Add a blank space for the state to continue to be added because it is implemented).
					if (COL != CVRG_CNT || lastColumnValue != "") break;
				}
			}
		}
		return lastColumnValue;
	}
	/**
	 * Group  Copy .
	 */		
	function copyGroup() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
 		//Copy button check ====================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT01117", "copy");
			return;
		}
		//==========================================================================================================================
		//1.Row Add button click, check save  “Data was changed. Do you want to save?” Alert ==========================
		var chkResult=isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				if (!saveGroup(chkResult[0], true)) return;
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		//==========================================================================================================================
		with(sheetSCObj) {
			isCopySCExceptionTariff=true;
			var row=DataCopy();
			isCopySCExceptionTariff=false;
			SetRowStatus(row,"I");
			SetCellValue(row, CURR_CVRG_MULTI,"");
			SetCellValue(row, GRP_SEQ,"");
		}
		for (var sheetNo=1 ; sheetNo < sheetObjects.length ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					SetRowStatus(row,"I");
					SetCellValue(row, GRP_SEQ,"");
				}
			}
		}
	}
	function delGroup() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		with(sheetSCObj) {
			if (fetchRowCount(sheetSCObj) > 0) {
				if (GetRowStatus(GetSelectRow()) != 'I') {
					if (fetchRowCount(sheetSCObj) == 1) {
						if (!ComShowCodeConfirm("DMT01119")) return;
					}
					else if (fetchRowCount(sheetSCObj) > 1) {
						if (!ComShowCodeConfirm("DMT00135", "delete")) return;
					}
					ComSetObjValue(formObj.prop_no, 		GetCellValue(GetSelectRow(), PROP_NO));
					ComSetObjValue(formObj.sc_expt_ver_seq, GetCellValue(GetSelectRow(), VER_SEQ));
					ComSetObjValue(formObj.sc_expt_grp_seq, GetCellValue(GetSelectRow(), GRP_SEQ));
					doActionIBSheet(sheetSCObj, formObj, IBDELETE_SCTARIFF);
					//=============================================================================================================
					if (ComGetObjValue(formObj.result) != "Y") {
						ComShowCodeMessage("DMT00008", "save");
						return;
					}
				}
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
				RowDelete(GetSelectRow(), false);
				//=================================================================================================================
				if (fetchRowCount(sheetSCObj) > 0) {
					setSubSCException(true);
				}
				else {
					doActionRetrieve(IBSEARCH);
				}
			}
		}
	}
	function saveGroup(isChangedSCTariff, isOnlyRetrieve) {
		var sheetSCObj=sheetObjects[0];
		var formObj=document.form;
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT01117", "save");
			return;
		}
		//==========================================================================================================================
		if (!isChangedSCTariff) {
			//chkResult => 0: As a result, 1: raised Row, 2: input, modify, and delete sensitive, 3: error message
			var chkResult=isChangedSCExceptionTariff();
			if (!chkResult[0]) {
				ComShowCodeMessage("DMT01113");
				return false;
			}
		}
		//===========================================================================================================================
		if (validateForm()) {
			copyGroupCoverageforSave();
			//======================================================================================================================
			setFlagValues();
			//======================================================================================================================
			// Customer Type mapping. ====================================================================
			setCustomerType();
			//======================================================================================================================
			//'Temp.Save' =====================================================================
			ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, "T");
			//======================================================================================================================
			//  S/C Exception Tariff =============================================================
			doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF);
			//======================================================================================================================
			//  Multi Coverage Grid delete============================================================
			releaseGroupCoverageforSave();
			//======================================================================================================================
			// save Action  ============================================================
			if (ComGetObjValue(formObj.result) == "Y") {
				ComShowCodeMessage("DMT00001");
				doActionRetrieve(IBSEARCH_SCTARIFF);
			}
			//======================================================================================================================
		}
		else {
			return false;
		}
		return true;
	}
    /**
     * S / C Exception Tariff sub-function that performs the deletion of items (full, delete the selected item)
     */	
	function delSubSCException(sheetObj, part) {
		with(sheetObj) {
			if (part == "All") {
				for (var row=LastRow(); row >= HeaderRows(); row--) {
					if (GetRowStatus(row) == "I") {
						RowDelete(row, 0);
					}
					else {
						SetRowStatus(row, "D");
						SetRowHidden(row, 1);
					}
				}
			}
			else {
				if (GetRowStatus(GetSelectRow()) == "I") {
					RowDelete(GetSelectRow(), 0);
				}
				else {
					SetRowStatus(GetSelectRow(), "D");
					SetRowHidden(GetSelectRow(), 1);
				}
			}
		}
	}
	/*
	 * S/C Exception Group for all of the information given is set to allow the flag state.
	 */		
	function editableGroup(flag) {
		var sheetSCObj=sheetObjects[0];
		var tmpStatus="";
		with(sheetSCObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				tmpStatus=GetRowStatus(row);
				SetCellEditable(row, TARIFF,flag);
				SetCellEditable(row, EFF_DT,flag);
				SetCellEditable(row, EXP_DT,flag);
				SetCellEditable(row, CNTRCGO,flag);
				SetCellEditable(row, CVRG_MULTI,flag);
				if (flag && GetCellValue(row, CVRG_MULTI) == "M") {
					SetCellEditable(row, CVRG_CNT,0);
					SetCellEditable(row, CVRG_RGN,0);
					SetCellEditable(row, CVRG_LOC,0);
					SetCellEditable(row, CVRG_POP,0);
				} 
				else {
					SetCellEditable(row, CVRG_CNT,flag);
					SetCellEditable(row, CVRG_RGN,flag);
					SetCellEditable(row, CVRG_LOC,flag);
					SetCellEditable(row, CVRG_POP,flag);
				}
				SetCellEditable(row, FT_FLG,flag);
				SetCellEditable(row, FT_TIR,flag);
				if (flag && "M" == GetCellValue(row, FT_TIR)) {
					SetCellEditable(row, ADD_DYS,0);
					SetCellEditable(row, TOT_DYS,0);
				}
				else {
					SetCellEditable(row, ADD_DYS,flag);
					SetCellEditable(row, TOT_DYS,flag);
				}			
				SetCellEditable(row, SAT_FLG,flag);
				SetCellEditable(row, SUN_FLG,flag);
				SetCellEditable(row, HOL_FLG,flag);
				SetCellEditable(row, ORGDST_CTI,flag);
				SetCellEditable(row, ORGDST_CNT,flag);
				SetCellEditable(row, ORGDST_RGN,flag);
				SetCellEditable(row, ORGDST_LOC,flag);
				SetCellEditable(row, ORGDST_POP,flag);
				//BKG DEL (I) or POR (O) or in the field activating inputs vary according to the Tariff of the field.
				if (flag) { 
					changeBKGDELorPOR(sheetSCObj, row); 
				}
				else { 
					SetCellEditable(row, BKGDEL_CNT,0);
					SetCellEditable(row, BKGDEL_RGN,0);
					SetCellEditable(row, BKGDEL_LOC,0);
					SetCellEditable(row, BKGDEL_POP,0);
				}
				//CY / Door field, whether the activating inputs vary according to the Tariff of the field.
				if (flag) { 
					changeCYDoor(sheetSCObj, row); 
				}
				else { 
					SetCellEditable(row, CYDOOR,0);
				}
				SetCellEditable(row, REMARK,flag);
				sheetSCObj.SetCellValue(row, ROW_EDIT_STS,flag ? "Y" : "N");
				sheetSCObj.SetRowStatus(row,tmpStatus);
				//================================================================
			}
		}
		//Group button to match the given flags activating / deactivating makes.
		if (flag) {
			ComBtnEnable("btn_AddGroup");
			ComBtnEnable("btn_CopyGroup");
			ComBtnEnable("btn_DelGroup");
			ComBtnEnable("btn_SaveGroup");
		}
		else {
			ComBtnDisable("btn_AddGroup");
			ComBtnDisable("btn_CopyGroup");
			ComBtnDisable("btn_DelGroup");
			ComBtnDisable("btn_SaveGroup");
		}
	}
	/**
	 * S/C Exception MultiCoverage given all the information on the status of the flag is set to allow.
	 */		
	function editableMultiCoverage(flag) {
		var sheetCVRGObj=sheetObjects[1];
		with(sheetCVRGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellEditable(row, CVRG_CNT,flag);
				SetCellEditable(row, CVRG_RGN,flag);
				SetCellEditable(row, CVRG_LOC,flag);
				SetCellEditable(row, CVRG_POP,flag);
			}
		}
		
		//Multi Coverage button to match the given flags activating / deactivating makes.
		if (flag) {
			ComBtnEnable("btn_AddMultiCoverage");
			ComBtnEnable("btn_DelMultiCoverage");
		}
		else {
			ComBtnDisable("btn_AddMultiCoverage");
			ComBtnDisable("btn_DelMultiCoverage");
		}
	}
	/**
	 * S/C Exception Tiered Free Time all of the information given is set to allow the flag state.
	 */		
	function editableTieredFreeTime(flag) {
		var sheetFTObj=sheetObjects[2];
		with(sheetFTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellEditable(row, FT_FROM,0);
				SetCellEditable(row, FT_UPTO,flag);
				SetCellEditable(row, FT_DAYS,flag);
			}
		}
		// activating  / deactivating  
		if (flag) {
			ComBtnEnable("btn_AddFreeTime");
			ComBtnEnable("btn_DelFreeTime");
		}
		else {
			ComBtnDisable("btn_AddFreeTime");
			ComBtnDisable("btn_DelFreeTime");
		}
	}
	/**
	 * S/C Exception Rate Adjustment all of the information on the status of the flag is set to allow a given.
	 */		
	function editableRateAdjustment(flag, isClicked) {
		var formObj=document.form;
		var sheetRTObj=sheetObjects[3];
		isClicked=(isClicked == undefined) ? false : isClicked;
		// activating  / deactivating 
		if (!isClicked) {
			with(formObj) {
				ComEnableManyObjects(flag, chkRateAdjustment, currency);
				if (flag)
					currency.className="input";
				else
					currency.className="input2";
			}
		}
		with(sheetRTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellEditable(row, RT_FROM,0);
				SetCellEditable(row, RT_UPTO,flag);
				SetCellEditable(row, RT_20FT,flag);
				SetCellEditable(row, RT_40FT,flag);
				SetCellEditable(row, RT_HC,flag);
				SetCellEditable(row, RT_45FT,flag);
			}			
		}
		//Rate Adjustment button: activating  / deactivating
		if (flag && formObj.chkRateAdjustment.checked) {
			ComBtnEnable("btn_AddRateAdjustment");
			ComBtnEnable("btn_DelRateAdjustment");
		}
		else {
			ComBtnDisable("btn_AddRateAdjustment");
			ComBtnDisable("btn_DelRateAdjustment");
		}
	}
	/**
	 * S/C Exception Actual Customer all information given is set to allow the flag state.
	 */		
	function editableActualCustomer(flag) {
		var formObj=document.form;
		var sheetCUSTObj=sheetObjects[4];
		//Customer Type  activating  / deactivating 
		with(formObj) {
			ComEnableManyObjects(flag, customerType);
			if (flag)
				customerType.className="input";
			else
				customerType.className="input2";
		}
		with(sheetCUSTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellEditable(row, CUST_CD,flag);
			}
		}
		//Customer button: activating  / deactivating 
		if (flag) {
			ComBtnEnable("btn_AddCustomer");
			ComBtnEnable("btn_DelCustomer");
		}
		else {
			ComBtnDisable("btn_AddCustomer");
			ComBtnDisable("btn_DelCustomer");
		}		
	}
	/**
	 * S/C Exception Commodity all information given is set to allow the flag state.
	 */		
	function editableCommodity(flag) {
		var sheetCMDTObj=sheetObjects[5];
		with(sheetCMDTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellEditable(row, CMDT_CD,flag);
			}
		}
		//Commodity button: activating  / deactivating  
		if (flag) {
			ComBtnEnable("btn_AddCommodity");
			ComBtnEnable("btn_DelCommodity");
		}
		else {
			ComBtnDisable("btn_AddCommodity");
			ComBtnDisable("btn_DelCommodity");
		}		
	}
	/**
	 * S / C Proposal Creation Screen separates the function has been called in
	 */		
	function isProposalCreationScreen() {
		var formObj=document.form;
		//S/C No., Proposal No, Contract Party is exist,  called from S/C Proposal Creation Screen,  according to conditions,  activating .
		if (ComTrim(ComGetObjValue(formObj.isEditable)) == "Y") {
			return true;	
		} else {
			return false;
		}		
	}
	/**
	 * The main button, depending on conditions that change the status of a given function
	 */					
	function initBtnControl() {
		//New Button
		initBtnNew();		
		//Update Button
		initBtnUpdate();
		//Request Button
		initBtnRequest();
		//Delete Button
		initBtnDelete();
		//Accept Button
		initBtnAccept();
		//Accept Cancel Button
		initBtnAcceptCancel();
	}
	/**
	 * change status  UPDATE button.
	 */		
	function initBtnNew() {
		if (isProposalCreationScreen()) {
			ComBtnEnable("btn_New");
		} else {
			ComBtnDisable("btn_New");
		}		
	}
	/**
	 * change status  UPDATE button. in conditions
	 */		
	function initBtnUpdate() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
			var curver=ComTrim(ComGetObjText(formObj.version));
			var maxver=ComTrim(formObj.version.options[0].text);
			var status=getVerStatus("Code");
			if (curver == maxver && (status == "R" || status == "L")) {
				ComBtnEnable("btn_Update");
			} else {
				ComBtnDisable("btn_Update");
			}
		} else {
			ComBtnDisable("btn_Update");
		}
	}
	/**
	 *  change status  REQUEST button. in conditions
	 */		
	function initBtnRequest() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
			var status=getVerStatus("Code");
			if (status == "" || status == "T")
				ComBtnEnable("btn_Request");
			else
				ComBtnDisable("btn_Request");
		} else {		
			ComBtnDisable("btn_Request");
		}
	}	
	/**
	 *  change status  DELETE button in conditions 
	 */		
	function initBtnDelete() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
			var status=getVerStatus("Code");
			if (status == "R" || status == "T")
				ComBtnEnable("btn_Delete");
			else
				ComBtnDisable("btn_Delete");
		} else {		
			ComBtnDisable("btn_Delete");
		}
	}
	/**
	 * change status  ACCEPT button in conditions 
	 * page Load and search .
	 */		
	function initBtnAccept() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
			var status=getVerStatus("Code");
			// Requested : activating 
			if (status == "R") {
				if (ComGetObjValue(formObj.isAcceptAuth) == "Y") {
					ComBtnEnable("btn_Accept");
				}
				else {
					ComBtnDisable("btn_Accept");
				}
			}
			else {
				ComBtnDisable("btn_Accept");
			}
		} else {		
			ComBtnDisable("btn_Accept");
		}
	}
	/**
	 * change status  ACCEPT button in conditions 
	 */		
	function initBtnAcceptCancel() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
			var status=getVerStatus("Code");
			//Accepted: activating 
			if (status == "A") {
				if (ComGetObjValue(formObj.isAcceptAuth) == "Y") {
					ComBtnEnable("btn_AcceptCancel");
				}
				else {
					ComBtnDisable("btn_AcceptCancel");
				}
			}
			else {
				ComBtnDisable("btn_AcceptCancel");
			}
		} else {		
			ComBtnDisable("btn_AcceptCancel");
		}
	}
	/**
	 * S / C EXCEPTION registered in the data query functions that define the behavior
	 */		
	function doActionRetrieve(sAction) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER);
		doActionRetrieveByVer(sAction);
	}
	/**
	 * Version information change function is executed to define the behavior
	 */		
	function doActionRetrieveByVer(sAction) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		
		//1.initializing
		ComSetObjValue(formObj.status, getVerStatus("Text"));
		doActionIBSheet(sheetSCObj, formObj, sAction);
		
		//--------------------------------------------------------------------
		currGrpSeq=sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ);
		//--------------------------------------------------------------------
		if (sheetSCObj.RowCount() > 0) {
			if (getVerStatus("Code") == "T" && ComGetObjValue(formObj.isEditable) == "Y")
				editableGroup(true);
			else
				editableGroup(false);

			setSubSCException(true);
		}
		else {
			if (ComGetObjValue(formObj.isEditable) == "Y")
				editableGroup(true);
			else
				editableGroup(false);
			//  initializing  grid 
            sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();

			//Initializing information makes a sub: (parameter indicates whether to retrieve the sub-item.) 
			setSubSCException(false);
		}
		
		//4.the status of the main button, makes activating or deactivating depending on the given conditions.
		initBtnControl();

		//5. activating /deactivating 
		//동적으로 Sort 변경이 안되기 때문에, 기능패치가 이루어질때 까지는 임시적으로 Sheet 초기화시 Sort 기능을 차단함. 2014.08.26		
//		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
//			sheetSCObj.InitHeadMode(false, false, false, false, false, false);
//		}
//		else {
//			sheetSCObj.InitHeadMode(true, false, false, false, false, false);	
//		}
	 }
   /**
	* S/C Exception Tariff mokrokjung selected Group Seq. Have been changed to change the status of sub-items.
	*/	
    function setSubSCException(isRetrieve) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];

		if (isRetrieve) {
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_SUB);
		}
		setMultiCoverageTitle();
		setMultiCoverageGrid();
		setTieredFreeTimeGrid();
		setRateAdjustmentGrid();
		setCustomerGrid();
		setCommodityGrid();
    }
   /**
	* S/C Exception Tariff 의 Coverage Change is the status of the function
	*/
	function setMultiCoverageGrid() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		with(sheetSCObj) {
			if (GetCellValue(GetSelectRow(), CVRG_MULTI) == "M") {
				formObj.chkMultiCoverage.checked=true;
				SetCellEditable(GetSelectRow(), CVRG_CNT,0);
				SetCellEditable(GetSelectRow(), CVRG_RGN,0);
				SetCellEditable(GetSelectRow(), CVRG_LOC,0);
				SetCellEditable(GetSelectRow(), CVRG_POP,0);
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					editableMultiCoverage(true);
				}
				else {
					editableMultiCoverage(false);
				}
			}
			else {
				formObj.chkMultiCoverage.checked=false;
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					SetCellEditable(GetSelectRow(), CVRG_CNT,1);
					SetCellEditable(GetSelectRow(), CVRG_RGN,1);
					SetCellEditable(GetSelectRow(), CVRG_LOC,1);
					SetCellEditable(GetSelectRow(), CVRG_POP,1);
				}
				else {
					SetCellEditable(GetSelectRow(), CVRG_CNT,0);
					SetCellEditable(GetSelectRow(), CVRG_RGN,0);
					SetCellEditable(GetSelectRow(), CVRG_LOC,0);
					SetCellEditable(GetSelectRow(), CVRG_POP,0);
				}
				editableMultiCoverage(false);	
			}
		}
	}
   /**
	* S/C Exception Tariff 의 Free Time Change is the status of the function
	*/
	function setTieredFreeTimeGrid() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		with(sheetSCObj) {
			if (GetCellValue(GetSelectRow(), FT_TIR) == "M") {
				formObj.chkFreeTime.checked=true;
				SetCellEditable(GetSelectRow(), ADD_DYS,0);
				SetCellEditable(GetSelectRow(), TOT_DYS,0);
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					SetCellEditable(GetSelectRow(), FT_FLG,1);
					SetCellEditable(GetSelectRow(), FT_TIR,1);
					editableTieredFreeTime(true);
				}
				else {
					SetCellEditable(GetSelectRow(), FT_FLG,0);
					SetCellEditable(GetSelectRow(), FT_TIR,0);
					editableTieredFreeTime(false);
				}				
			}
			else if (GetCellValue(GetSelectRow(), FT_TIR) == "S") {
				formObj.chkFreeTime.checked=false;
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					SetCellEditable(GetSelectRow(), FT_FLG,1);
					SetCellEditable(GetSelectRow(), FT_TIR,1);
					SetCellEditable(GetSelectRow(), ADD_DYS,1);
					SetCellEditable(GetSelectRow(), TOT_DYS,1);
				}
				else {
					SetCellEditable(GetSelectRow(), FT_FLG,0);
					SetCellEditable(GetSelectRow(), FT_TIR,0);
					SetCellEditable(GetSelectRow(), ADD_DYS,0);
					SetCellEditable(GetSelectRow(), TOT_DYS,0);
				}
				editableTieredFreeTime(false);				
			}
			else if (GetCellValue(GetSelectRow(), FT_TIR) == "") {
				formObj.chkFreeTime.checked=false;
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					SetCellEditable(GetSelectRow(), FT_FLG,1);
				}
				else {
					SetCellEditable(GetSelectRow(), FT_FLG,0);
				}
				SetCellEditable(GetSelectRow(), FT_TIR,0);
				SetCellEditable(GetSelectRow(), ADD_DYS,0);
				SetCellEditable(GetSelectRow(), TOT_DYS,0);
				editableTieredFreeTime(false);	
			}
		}
	}
   /**
	* S/C Exception Tariff 의 Rate Adjustment Change is the status of the function
	*/
	function setRateAdjustmentGrid() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		with(sheetSCObj) {		
			if (GetCellValue(GetSelectRow(), RT_CHECK) == "Y") {
				formObj.chkRateAdjustment.checked=true;
			}
			else {
				formObj.chkRateAdjustment.checked=false;
			}
			ComClearCombo(formObj.currency);
			searchCurrencyList(GetSelectRow());
			var currCd=GetCellValue(GetSelectRow(), CURR_CD);
			if (currCd != "" && formObj.currency.length > 0) {
				ComSetObjValue(formObj.currency, currCd);
			}
			if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
				editableRateAdjustment(true);
			}
			else {
				editableRateAdjustment(false);
			}
		}
	}
   /**
	* S/C Exception Tariff  Customer Change is the status of the function
	*/
	function setCustomerGrid() {
		var sheetSCObj=sheetObjects[0];
		with(sheetSCObj) {
			if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
				editableActualCustomer(true);
			}
			else {
				editableActualCustomer(false);
			}
		}
	}
   /**
	* S/C Exception Tariff  Commodity Change is the status of the function
	*/
	function setCommodityGrid() {
		var sheetSCObj=sheetObjects[0];
		with(sheetSCObj) {
			if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
				editableCommodity(true);
			}
			else {
				editableCommodity(false);
			}
		}
	}	
	/**
	 * If you click NEW button executes the function that defines the behavior of
	 */				
	function doActionNew() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		with(formObj) {
			ComEnableManyObjects(true, version);
			version.className="input";
		}
		doActionRetrieve(IBSEARCH);
	}
	/**
	 * If you need to click the UPDATE button, a function that defines the operation to be executed
	 */				
	function doActionUpdate() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================
		if (getVerStatus("Code") == "R") {
			if (!ComShowCodeConfirm("DMT00133")) { return; }
			ComClearObject(formObj.status);	
			ComBtnDisable(	"btn_Update"		);
			ComBtnEnable(	"btn_Request"		);
			ComBtnDisable(	"btn_Delete"		);
			ComBtnDisable(	"btn_Accept"		);
			ComBtnDisable(	"btn_AcceptCancel"	);				
		}
		else if (getVerStatus("Code") == "L") {
			if (!ComShowCodeConfirm("DMT01114", ComGetObjText(formObj.version))) { return; }
			doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF_UPDATE);
			if (ComGetObjValue(formObj.result) == "Y") {
				doActionRetrieve(IBSEARCH);
			}
			else {
				ComShowCodeMessage("DMT00008", "update");
				return;
			}
		}
		with(formObj) {
			ComEnableManyObjects(false, version);
			version.className="input2";
		}
		editableGroup(true);
		setSubSCException(false);
		
		//동적으로 Sort 변경이 안되기 때문에, 기능패치가 이루어질때 까지는 임시적으로 Sheet 초기화시 Sort 기능을 차단함. 2014.08.26				
//		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
//			sheetSCObj.InitHeadMode(false, false, false, false, false, false);
//		}
//		else {
//			sheetSCObj.InitHeadMode(true, false, false, false, false, false);	
//		}		
	}			
	/**
	 * If you need to click the REQUEST button, a function that defines the operation to be executed
	 */				
	function doActionRequest() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT01117", "request");
			return;
		}
		var chkResult=isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				if (!saveGroup(chkResult[0], true)) return;	
			}
		}
		ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"R");
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
			with(formObj) {
				ComEnableObject(version, true);
				version.className="input";
			}	
		}
	}
	/**
	 * If you need to click the DELETE button, a function that defines the operation to be executed
	 */				
	function doActionDelete() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}				
		if (ComShowCodeConfirm("DMT02007")) {
			doActionIBSheet(sheetSCObj, formObj, IBDELETE);
			if (ComGetObjValue(formObj.result) == "Y") {
				ComShowCodeMessage("DMT01116", "deleted");
				doActionRetrieve(IBSEARCH);
				with(formObj) {
					ComEnableObject(version, true);
					version.className="input";
				}				
			}
		}
	}	
	/**
	 * If you need to click the ACCEPT button, a function that defines the operation to be executed
	 */				
	function doActionAccept() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		if (!ComShowCodeConfirm("DMT00135", "Accept")) { return; }
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_FILED);
		var result=ComGetObjValue(formObj.result);
		if (result == "N") {
			ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"A");
		}
		else {
			ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"L");
		}
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
		}
	}
	/**
	 * If you need to click ACCEPT CANCEL button, a function that defines the operation to be executed
	 */				
	function doActionAcceptCancel() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148");//Version()status has changed. Pls click New button
			return;
		}				
		if (!ComShowCodeConfirm("DMT00135", "cancel acceptance")) { return; }
		ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"R");
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
		}
	}
	/**
	 * If you need to click the CLOSE button, a function that defines the operation to be executed
	 */				
	function doActionClose() {
		var formObj=document.form;
		var chkResult=isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT00147")) {
				self.close();
			}
			return;
		}
		self.close();
	}	
	 /**
     * handling process for input validation
     */	 
	function validateForm() {
    	var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetFTObj=sheetObjects[2];
		var sheetRTObj=sheetObjects[3];
		// save할 Data does not exist
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT00128");
			return false;
		}
		with(sheetSCObj) {
			var chkResult=isChangedSCExceptionTariff(1); 
			if (GetRowStatus(GetSelectRow()) == "I" || GetRowStatus(GetSelectRow()) == "U" || chkResult[0]) {
				//==================================================================================================
				//1-1.EFF DT Check
				//==================================================================================================
				if (GetCellValue(GetSelectRow(), EFF_DT) == "") {
					ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "EFF DT");
					return false;
				}
				//==================================================================================================
				//1-2.EXP DT Check
				//==================================================================================================
				if (GetCellValue(GetSelectRow(), EXP_DT) == "") {
					ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "EXP DT");
					return false;
				}
				//==================================================================================================
				//2.EXP DT >= EFF DT 
				//==================================================================================================
				if (ComGetDaysBetween(GetCellValue(GetSelectRow(), EXP_DT), GetCellValue(GetSelectRow(), EFF_DT)) > 0) {
	    			ComShowCodeMessage("COM12133", "'EFF DT'", "'EXP DT'", "earlier");
	    			return false;	    			
	    		}
				//==================================================================================================
				//3.Coverage Check
				//==================================================================================================
				//3-1.Single Coverage mandetory
				if (GetCellValue(GetSelectRow(), CVRG_MULTI) == "S") {
					if (ComTrim(GetCellValue(GetSelectRow(), CVRG_CNT)) == "") {
						ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Coverage CN");
						return false;						
					}
					//check cnt_cd :  Coverage , Origin(I) or Dest(O) 
					if (GetCellValue(GetSelectRow(), CVRG_CNT) == GetCellValue(GetSelectRow(), ORGDST_CNT)) {
						ComShowCodeMessage("DMT01144", GetCellValue(GetSelectRow(), TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
						return false;
					}
				}
				//3-2.Multi Coverage Data Count Check(more 2 )
				else if (GetCellValue(GetSelectRow(), CVRG_MULTI) == "M") {
					for (var row=sheetCVRGObj.HeaderRows(); row <= sheetCVRGObj.LastRow(); row++) {
						if (sheetCVRGObj.GetCellValue(row, CVRG_CNT) == "") {
							ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Country");
							return false;
						}
						//check cnt_cd :  Coverage, Origin(I) or Dest(O) 
						if (sheetCVRGObj.GetCellValue(row, CVRG_CNT) == GetCellValue(GetSelectRow(), ORGDST_CNT)) {
							ComShowCodeMessage("DMT01144", GetCellValue(GetSelectRow(), TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
							return false;
						}						
					}
					if (fetchRowCount(sheetCVRGObj) < 2) {
						ComShowCodeMessage("DMT00115", GetCellValue(GetSelectRow(), "Seq"), "Multi Coverage");
						return false;
					}
				}
				//==================================================================================================
				//4.Free Time Validation Check
				//  (Y : Tier, Add, Total, F/Time EXCL: activating )
				//==================================================================================================
				if (GetCellValue(GetSelectRow(), FT_FLG) == 1) {
					//4-1.Free Time  = 'Single' ,  Free Time -  if Add Day = Total , error
					if (GetCellValue(GetSelectRow(), FT_TIR) == "S") {
						if (GetCellValue(GetSelectRow(), ADD_DYS) != "" && GetCellValue(GetSelectRow(), TOT_DYS) != "") {
							ComShowCodeMessage("DMT02004", GetCellValue(GetSelectRow(), "Seq"));
							return false;
						} 
						else if (GetCellValue(GetSelectRow(), ADD_DYS) == "" && GetCellValue(GetSelectRow(), TOT_DYS) == "") {
							ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Free Time");
							return false;						
						}
					}
					//4-2.Free Time = 'Multi' ,  Tiered Free Time - last Row   Up to must be blank, else error
					else if (GetCellValue(GetSelectRow(), FT_TIR) == "M") {
						if (!validateTieredFreeTime(GetSelectRow())) {
							return false; 
						}
						else if (fetchRowCount(sheetFTObj) < 2) {
							ComShowCodeMessage("DMT00115", GetCellValue(GetSelectRow(), "Seq"), "Tiered Free Time");
							return false;
						} 
					}
				}
				else {
					// Change: F/Time or Rate mandetory
					if (GetCellValue(GetSelectRow(), RT_CHECK) == "N") {
						ComShowCodeMessage("DMT02028", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					}
				}
				//==================================================================================================
				//5.Dual Type : Free Time  Total is mandetory
				//==================================================================================================
				if (GetCellValue(GetSelectRow(), RT_MANDATORY) == "Y" && GetCellValue(GetSelectRow(), FT_TIR) != "M") {
					if (GetCellValue(GetSelectRow(), ADD_DYS) != "" && GetCellValue(GetSelectRow(), TOT_DYS) == "") {
						ComShowCodeMessage("DMT00113", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					}
					else if (GetCellValue(GetSelectRow(), TOT_DYS) == "") {
						ComShowCodeMessage("DMT00152", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					}
				}
				//==================================================================================================
				//6.Rate Adjustment Validation Check( last Row   Up to must be blank, else error)
				//==================================================================================================
				var rtRowCounts = fetchRowCount(sheetRTObj);
				if (GetCellValue(GetSelectRow(), RT_CHECK) == "Y") {
					if (rtRowCounts < 1) {
						ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Rate Adjustment");
						return false;
					} 
					if (GetCellValue(GetSelectRow(), CURR_CD) == "") {
						ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Currency");
						return false;
					}
				}
				if (rtRowCounts > 0 && !validateRateAdjustment(GetSelectRow()))
					return false;
				//==================================================================================================
				//7.Calculation Type Check
				//==================================================================================================
				if (!validateCalculationType(GetSelectRow()))
					return false;
				if (!validateCalculationTypeInDM(GetSelectRow()))
					return false;
				//==================================================================================================
				//8.Actual Customer check
				//==================================================================================================
				if (!validateActualCustomer(GetSelectRow()))
					return false;
				//==================================================================================================
				//9. Commodity check
				//==================================================================================================
				if (!validateCommodity(GetSelectRow()))
					return false;
			}
		}
		if (dupValidate()) return false;
		return true;
	}
  	/**
  	 * S/C Exception Tariff based on the input of the Screen registered a function to check for duplicates in the data
  	 */	     
     function dupValidate() {
  		var formObj=document.form;
  		var sheetSCObj=sheetObjects[0];
  		var sheetCVRGObj=sheetObjects[1];
  		var sheetCUSTObj=sheetObjects[4];
  		var sheetCMDTObj=sheetObjects[5];
  		var coverageList="";
  		if (sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_MULTI) == "S") {
  			with(sheetSCObj) {
  				coverageList	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), CVRG_CNT));
	  			coverageList  	+= ", ";
	  			if (GetCellValue(GetSelectRow(), CVRG_CNT) == "CA" || GetCellValue(GetSelectRow(), CVRG_CNT) == "US") {
	  				coverageList  	+= "' '";
		  			coverageList  	+= ", ";
		  			coverageList  	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), CVRG_RGN));
	  			}
	  			else {
	  				coverageList  	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), CVRG_RGN));
		  			coverageList  	+= ", ";
	  				coverageList  	+= "' '";
	  			}
  		  		coverageList	+= ", ";	  			
  		  		coverageList  	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), CVRG_LOC));
  			}
  		}
  		else {
  			with(sheetCVRGObj) {
  				for (var row=HeaderRows(); row <= LastRow(); row++) {
  					if (GetRowStatus(row) == "D") continue;
  					coverageList 	+= convertEmptyToSpace(GetCellValue(row, CVRG_CNT));
  		  			coverageList	+= ", ";
  		  			if (GetCellValue(row, CVRG_CNT) == "CA" || GetCellValue(row, CVRG_CNT) == "US") {
		  				coverageList  	+= "' '";
			  			coverageList  	+= ", ";
			  			coverageList  	+= convertEmptyToSpace(GetCellValue(row, CVRG_RGN));
	  		  		}
	  		  		else {
	  		  			coverageList  	+= convertEmptyToSpace(GetCellValue(row, CVRG_RGN));
			  			coverageList  	+= ", ";
		  				coverageList  	+= "' '";
	  		  		}
  		  			coverageList	+= ", ";  		  			
  		  			coverageList	+= convertEmptyToSpace(GetCellValue(row, CVRG_LOC));
  		  			if (row < LastRow()) coverageList	+= "|";
  				}
  			}
  		}
  		var actCustList="";
  		with(sheetCUSTObj) {
  			for (var row=HeaderRows(); row <= LastRow(); row++) {
  				if (GetRowStatus(row) == "D") continue;
  				actCustList		+= "'" + GetCellValue(row, CUST_CD).substring(0, 2) + "'";
  				actCustList		+= ", ";
  				actCustList		+= "'" + GetCellValue(row, CUST_CD).substring(2) + "'";
  				if (row < LastRow()) actCustList	+= "|";
  			}
  		}
  		var cmdtList="";
  		with(sheetCMDTObj) {
  			for (var row=HeaderRows(); row <= LastRow(); row++) {
  				if (GetRowStatus(row) == "D") continue;
  				cmdtList		+= GetCellValue(row, CMDT_CD);
  				if (row < LastRow()) cmdtList	+= "|";
  			}
  		}
  		ComSetObjValue(formObj.coverage_list, 	coverageList);
  		ComSetObjValue(formObj.act_cust_list, 	actCustList);
  		ComSetObjValue(formObj.cmdt_list, 		cmdtList);
    	doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CHECK_DUP);
    	if (ComGetObjValue(formObj.result) == "Y") {
    		ComShowCodeMessage("DMT00138", sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), "Seq"));
    		return true;
    	}
      	return false;
	}
 	/**
	 * Calculation Type check 
	 */		
	function validateCalculationType(selectedRow) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[3];
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		var tariff=sheetSCObj.GetCellValue(selectedRow, TARIFF);
		var params="";
		if (sheetSCObj.GetCellValue(selectedRow, CVRG_MULTI) == "S") {
			params=changeNullToSpace(sheetSCObj.GetCellValue(selectedRow, CVRG_CNT));
			params=params + "=" + changeNullToSpace(sheetSCObj.GetCellValue(selectedRow, CVRG_RGN));
			params=params + "=" + changeNullToSpace(sheetSCObj.GetCellValue(selectedRow, CVRG_LOC));
		}
		else {
			params=getMultiCoverageData();
		}
		params += "|";
		params += tariff;
		params += "|";
		params += sheetSCObj.GetCellValue(selectedRow, EFF_DT);
		params += "|";
		params += sheetSCObj.GetCellValue(selectedRow, EXP_DT);
		params += "|";
		params += sheetSCObj.GetCellValue(selectedRow, CNTRCGO);
		params += "|";
		if (custCd.length > 2) {
			params += custCd.substring(0,2);
			params += ComTrim(ComGetObjValue(formObj.custSeq));
		}
		//1.Calculation Type Check 
		ComSetObjValue(formObj.chk_calc_tp_in, params);
		//2.Calculation Type Check 
		if (tariff.indexOf("CT") != -1) {
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_DUAL);
		}
		else {
			ComSetObjValue(formObj.chk_calc_tp_combined, "N");
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CALC);
		}
		var result=ComGetObjValue(formObj.result);
		//result(E: Error, M: Mandatory, O:Option)
		if (result == "M") {
			if (tariff.indexOf("CT") != -1) {
				//Free Time : Total Day 
				if (ComTrim(sheetSCObj.GetCellValue(selectedRow, ADD_DYS)).length > 0) {
					ComShowCodeMessage("DMT00113", sheetSCObj.GetCellValue(selectedRow, "Seq"));
					return false; 					
				}
				//Rate Adjustment .
				if (fetchRowCount(sheetRTObj) < 1) {
					ComShowCodeMessage("DMT00114", sheetSCObj.GetCellValue(selectedRow, "Seq"));
					return false;
				}						
			}
		} 
		else if (result == "E") {
			var cntCd=ComGetObjValue(formObj.result_cnt);
			var steCd=ComGetObjValue(formObj.result_ste);
			var rgnCd=ComGetObjValue(formObj.result_rgn);
			var locCd=ComGetObjValue(formObj.result_loc);
			if (cntCd.indexOf("US") != -1 || cntCd.indexOf("CA") != -1) {
				rgnCd=steCd;
			}
			var errMsgId="";
			if (tariff.indexOf("CT") != -1) {
				errMsgId="DMT02003";
			}
			else {
				errMsgId="DMT00132";
			}			
			ComShowCodeMessage(errMsgId, sheetSCObj.GetCellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");
			return false;					
		}
		return true;
	}
	/*
	 * Calculation Type check 
	 */		
	function validateCalculationTypeInDM(selectedRow) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		var tariff=sheetSCObj.GetCellValue(selectedRow, TARIFF);
		var params="";
		if (tariff.indexOf("DM") != -1) {
			if (ComTrim(sheetSCObj.GetCellValue(selectedRow, BKGDEL_CNT)) != "") {
				params=changeNullToSpace(sheetSCObj.GetCellValue(selectedRow, BKGDEL_CNT));
				params=params + "=" + changeNullToSpace(sheetSCObj.GetCellValue(selectedRow, BKGDEL_RGN));
				params=params + "=" + changeNullToSpace(sheetSCObj.GetCellValue(selectedRow, BKGDEL_LOC));
				params += "|";
				params += tariff;
				params += "|";
				params += sheetSCObj.GetCellValue(selectedRow, EFF_DT);
				params += "|";
				params += sheetSCObj.GetCellValue(selectedRow, EXP_DT);
				params += "|";
				params += sheetSCObj.GetCellValue(selectedRow, CNTRCGO);
				params += "|";
				if (custCd.length > 2) {
					params += custCd.substring(0,2);
					params += ComTrim(ComGetObjValue(formObj.custSeq));
				}				
				ComSetObjValue(formObj.chk_calc_tp_in, params);
				ComSetObjValue(formObj.chk_calc_tp_combined, "Y");
				doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CALC);
				var result=ComGetObjValue(formObj.result);
				//result(E: Error, O:Option)
				if (result == "E") {
					var cntCd=ComGetObjValue(formObj.result_cnt);
					var steCd=ComGetObjValue(formObj.result_ste);
					var rgnCd=ComGetObjValue(formObj.result_rgn);
					var locCd=ComGetObjValue(formObj.result_loc);
					if (cntCd.indexOf("US") != -1 || cntCd.indexOf("CA") != -1) {
						rgnCd=steCd;
					}
					ComShowCodeMessage("DMT00132", sheetSCObj.GetCellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");
					return false;				
				}			
			}
		}
		return true;		
	}
	/**
	 * Tiered Free Time Sheet for an item in the Validation checked.
	 */			
	function validateTieredFreeTime(selectedRow) {
		var sheetSCObj=sheetObjects[0];
		var sheetFTObj=sheetObjects[2];
		//If the last Row, CNTR QTY of the From, Total required input, Up to the Empty should be.
		if (isEmptyColumnOfLastRow(sheetFTObj, FT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetFTObj, FT_UPTO)) {
			ComShowCodeMessage("DMT02005", sheetSCObj.GetCellValue(selectedRow, "Seq"));
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetFTObj, FT_DAYS)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "Total");
			return false;
		}
		//From Up to and equal to or greater than the number known to enter
		with(sheetFTObj) {
			for (var row=HeaderRows(); row < LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					if (ComParseInt(GetCellValue(row, FT_FROM)) > ComParseInt(GetCellValue(row, FT_UPTO))) {
						ComShowCodeMessage("DMT01032", "[Tiered Free Time]");
						SetCellValue(row, FT_UPTO,"",0);
						return false;
					}
				}
			}
		}
		return true;		
	}
	/**
	 * In Rate Adjustment Sheet Validation will check for items.
	 */			
	function validateRateAdjustment(selectedRow) {
		var sheetSCObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[3];
		
		//If the last Row, Over Day's From Up to the required input must be an Empty.
		// Pate per Day : 20FT, 40FT, H/C, 45FT mandetory
		if (isEmptyColumnOfLastRow(sheetRTObj, RT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetRTObj, RT_UPTO)) {
			ComShowCodeMessage("DMT02006", sheetSCObj.GetCellValue(selectedRow, "Seq"));
			return false;
		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_20FT)) {
//			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "20FT");
//			return false;
//		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_40FT)) {
//			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "40FT");
//			return false;			
//		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_HC)) {
//			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "H/C");
//			return false;			
//		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_45FT)) {
//			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "45FT");
//			return false;			
//		}
		//Up to >= From
		with(sheetRTObj) {
			for (var row=HeaderRows(); row < LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					if (ComParseInt(GetCellValue(row, RT_FROM)) > ComParseInt(GetCellValue(row, RT_UPTO))) {
						ComShowCodeMessage("DMT01032", "[Rate Adjustment]");
						SetCellValue(row, RT_UPTO,"",0);
						return false;
					}
				}
			}
		}

		//F/Time Commence check
		for(var i=sheetRTObj.HeaderRows(); i<= sheetRTObj.LastRow(1); i++) { // sheetRTObj.LastRow(1) Last Row of Visible Rows
			if(sheetRTObj.GetCellValue(i, RT_FROM) == "") {
				ComShowCodeMessage("DMT02002", "Over Day From");
				sheetRTObj.SelectCell(i, RT_FROM);
				return false;
			}
			if(i != parseInt(sheetRTObj.LastRow(1))) {
				if(sheetRTObj.GetCellValue(i, RT_UPTO) == "") {
					ComShowCodeMessage("DMT02002", "Over Day Up To");
					sheetRTObj.SelectCell(i, RT_UPTO);
					return false;
				}
			}
			if(sheetRTObj.GetCellValue(i, RT_20FT) < 0) {
				ComShowCodeMessage("DMT01128", "Rate Per Day 20FT", "0");
				sheetRTObj.SelectCell(i, RT_20FT);
				return false;
			}
			if(sheetRTObj.GetCellValue(i, RT_40FT) < 0) {
				ComShowCodeMessage("DMT01128", "Rate Per Day 40FT", "0");
				sheetRTObj.SelectCell(i, RT_40FT);
				return false;
			}
			if(sheetRTObj.GetCellValue(i, RT_HC) < 0) {
				ComShowCodeMessage("DMT01128", "Rate Per Day H/C", "0");
				sheetRTObj.SelectCell(i, RT_HC);
				return false;
			}
			if(sheetRTObj.GetCellValue(i, RT_40FT) < 0) {
				ComShowCodeMessage("DMT01128", "Rate Per Day 45FT", "0");
				sheetRTObj.SelectCell(i, RT_40FT);
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * There should be a redundant code of Actual Customer.
	 */			
	function validateActualCustomer(selectedRow) {
		var sheetSCObj=sheetObjects[0];
		var sheetCUSTObj=sheetObjects[4];
		//Check mandatory item
		if (isEmptyColumnOfLastRow(sheetCUSTObj, CUST_CD)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "Customer Code");
			return false;			
		}
		var dupRows = sheetCUSTObj.ColValueDupRows(GRP_SEQ + "|" + CUST_CD, false, true);
		if (dupRows != "") {
			ComShowCodeMessage("DMT00138", sheetSCObj.GetCellValue(selectedRow, "Seq"), "Actual Customer");
			return false;
		}
		return true;
	}	
	/**
	 * There should be a redundant code of Commodity
	 */
	function validateCommodity(selectedRow) {
        var sheetSCObj=sheetObjects[0];
		var sheetCMDTObj=sheetObjects[5];
		//Check mandatory item
		if (isEmptyColumnOfLastRow(sheetCMDTObj, CMDT_CD)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.GetCellValue(selectedRow, "Seq"), "Commodity Code");
			return false;			
		}	
		var dupRows = sheetCMDTObj.ColValueDupRows(GRP_SEQ + "|" + CMDT_CD, false, true);
		if (dupRows != "") {
			ComShowCodeMessage("DMT00138", sheetSCObj.GetCellValue(selectedRow, "Seq"), "Commodity");
			return false;
		}
		return true;
	}
	/**
	 * Row selected for Group Sheet Multi Coverage Code value corresponding to the string value is returned.
	 */
	function getMultiCoverageData() {
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var cvrgData="";
		with(sheetCVRGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					cvrgData=cvrgData 		+ changeNullToSpace(GetCellValue(row, CVRG_CNT));
					cvrgData=cvrgData + "=" 	+ changeNullToSpace(GetCellValue(row, CVRG_RGN));
					cvrgData=cvrgData + "=" 	+ changeNullToSpace(GetCellValue(row, CVRG_LOC));
					if (row < LastRow()) { cvrgData += "^"; }
				}
			}
		}
		return cvrgData;
	}
	/**
	 * cnd_cd of Coverage find information and returns.
	 */	 
	 function getCoverageCNData(selectRow) {
		var sheetObj=sheetObjects[0];
		if (ComTrim(sheetObj.GetCellValue(selectRow, CVRG_MULTI)) == "M") {
			return getMultiCoverageFirstCNData();
		}
		else {
			return ComTrim(sheetObj.GetCellValue(selectRow, CVRG_CNT));
		}		 
	 }
	/**
	 * Group Sheet Multi Coverage corresponding to the selected Row returns the value of the first Country.
	 */
	function getMultiCoverageFirstCNData() {
		var sheetCVRGObj=sheetObjects[1];
		with(sheetCVRGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					return GetCellValue(row, CVRG_CNT);
				}
			}
		}
		return "";
	}
	/**
	 * Row Data Sheet given in my last, a function that checks whether a given column is Empty
	 * Selection, and entered the Data does not exist, returns false.
	 */			
	function isEmptyColumnOfLastRow(sheetObj, COL) {
		var isEmptyColumn=false;
		with(sheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) != "D") {
					if (COL == CMDT_CD) { 
						if (GetCellText(row,  COL) == "") isEmptyColumn=true;
					}
					else {
						if (GetCellValue(row, COL) == "") isEmptyColumn=true;
					}
					break;					
				}
			}
		}
		return isEmptyColumn;
	}
	/**
	 * Selection, and entered the Data does not exist, returns false....
	 */
	function fetchRowCount(sheetObj) {
		var totCount=0;
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetRowStatus(row) != "D") {
					totCount++
				}
			}
		}
		return totCount;	
	}
	/**
	 * Sheet given in the given row and then, row function that returns the index of
	 */	
	function getNextRow(currRow, sheetObj) {
		var sheetObj1=sheetObjects[0];
		var propNo=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), PROP_NO);
		var verSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), VER_SEQ);
		var grpSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), GRP_SEQ);
		var nextRow=-1;
		for (var row=sheetObj.HeaderRows(); row <= sheetObj.LastRow(); row++) {
			if (sheetObj.GetCellValue(row, HID_STATUS) != "Y") {
				if (	propNo == sheetObj.GetCellValue(row, PROP_NO)
					&& verSeq == sheetObj.GetCellValue(row, VER_SEQ)
					&& grpSeq == sheetObj.GetCellValue(row, GRP_SEQ)	) {
					if (row > currRow) {
						nextRow=row;
						break;
					}
				}
			}
		}				
		return nextRow;			
	}
	function equalContinentByCN(selectedRow) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var orgCN=ComTrim(sheetSCObj.GetCellValue(selectedRow, BKGDEL_CNT));
		if (orgCN.length == 0) return true;
		if (ComTrim(sheetSCObj.GetCellValue(selectedRow, CVRG_MULTI)) == "M") {
			trgCN=getMultiCoverageFirstCNData();
		} else {
			trgCN=ComTrim(sheetSCObj.GetCellValue(selectedRow, CVRG_CNT));
		}
		ComSetObjValue(formObj.fnl_dest_cnt_cd, orgCN);
		ComSetObjValue(formObj.cnt_cd, 			trgCN);
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CHKCONTI);
		chkOutData=ComGetObjValue(formObj.result);
		if (chkOutData == "Y") { return true; }
		else { return false; }
	}
	function changeNullToSpace(str) {
		return ComTrim(str).length == 0 ? " " : ComTrim(str);
	}	
	function checkRateAdjustment() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		with(sheetSCObj) {
			if (GetCellValue(GetSelectRow(), RT_MANDATORY) == "Y" && !formObj.chkRateAdjustment.checked) {
				ComShowCodeMessage("DMT00129", GetCellValue(GetSelectRow(), "Seq"));
				formObj.chkRateAdjustment.checked=true;
				return;
			}
			if (getSCExceptionCountry(GetSelectRow()) == "" && formObj.chkRateAdjustment.checked) {
				ComShowCodeMessage("DMT00130");
				formObj.chkRateAdjustment.checked=false;
				return;
			}
		 }
		if (formObj.chkRateAdjustment.checked) {
			doActionCheckOnRateAdjustment();
		} 
		else {
			doActionUnCheckOnRateAdjustment();
		}
	}
	/**
	 * Rate Adjustment  Check
	 */		 
	function doActionCheckOnRateAdjustment() {
		 var sheetSCObj=sheetObjects[0];
		 var sheetRTObj=sheetObjects[3];
		searchCurrencyList(sheetSCObj.GetSelectRow());
		editableRateAdjustment(true);
		sheetSCObj.SetCellValue(sheetSCObj.GetSelectRow(), RT_CHECK,"Y");
		if (fetchRowCount(sheetRTObj) == 0) {
			addRateAdjustment();
		}
	}
	/**
	 * Rate Adjustment  unChecked
	 */		 
	function doActionUnCheckOnRateAdjustment() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[3];
		delSubSCException(sheetRTObj, "All");
		ComClearCombo(formObj.currency);
		sheetSCObj.SetCellValue(sheetSCObj.GetSelectRow(), CURR_CD,"");
		editableRateAdjustment(false, true);
		sheetSCObj.SetCellValue(sheetSCObj.GetSelectRow(), RT_CHECK,"N");
	}
	/**
	 * Depending on the field values ??entered in Screen, Flag sets up a field value.
	 */			
	function setFlagValues() {
		var sheetSCObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[3]
		var sheetCUSTObj=sheetObjects[4];
		var sheetCMDTObj=sheetObjects[5];
		with(sheetSCObj) {
			if (fetchRowCount(sheetCMDTObj) > 0) {
				SetCellValue(GetSelectRow(), CMDT_FLG,"Y");
			} 
			else {
				SetCellValue(GetSelectRow(), CMDT_FLG,"N");
			}
			if (fetchRowCount(sheetCUSTObj) > 0) {
				SetCellValue(GetSelectRow(), ACT_CUST_FLG,"Y");
			} 
			else {
				SetCellValue(GetSelectRow(), ACT_CUST_FLG,"N");
			}
			if (GetCellValue(GetSelectRow(), ORGDST_CTI) != "") {
				SetCellValue(GetSelectRow(), FM_TO_PAIR_FLG,"Y");
			} 
			else {
				SetCellValue(GetSelectRow(), FM_TO_PAIR_FLG,"N");
			}
			if (GetCellValue(GetSelectRow(), FT_TIR) == "S") {
				if (GetCellValue(GetSelectRow(), ADD_DYS) != "")
					SetCellValue(GetSelectRow(), FT_ADD_FLG,"Y");
				else if (GetCellValue(GetSelectRow(), TOT_DYS) != "")
					SetCellValue(GetSelectRow(), FT_ADD_FLG,"N");
			}
			else {
				SetCellValue(GetSelectRow(), FT_ADD_FLG,"N");
			}
			if (GetCellValue(GetSelectRow(), FT_TIR) == "M") {
				SetCellValue(GetSelectRow(), FT_ADJ_FLG,"Y");
			} 
			else {
				SetCellValue(GetSelectRow(), FT_ADJ_FLG,"N");
			}
			if (fetchRowCount(sheetRTObj) > 0) {
				SetCellValue(GetSelectRow(), RT_ADJ_FLG,"Y");
			} 
			else {
				SetCellValue(GetSelectRow(), RT_ADJ_FLG,"N");
			}
			if (GetCellValue(GetSelectRow(), ADD_DYS) != "") {
				SetCellValue(GetSelectRow(), DMDT_FT_ADJ_TP_CD,"A");
			} 
			else if (GetCellValue(GetSelectRow(), TOT_DYS) != "") {
				SetCellValue(GetSelectRow(), DMDT_FT_ADJ_TP_CD,"T");
			} 
			else {
				SetCellValue(GetSelectRow(), DMDT_FT_ADJ_TP_CD,"");
			}						
		}
	}		
	/**
	 * The current version of the Status Code is returned or Text.
	 */		
	function getVerStatus(type) {
		var formObj=document.form;
		var status=ComTrim(ComGetObjValue(formObj.version));		
		if (status.indexOf(":") != -1) {
			var stsArr=status.split(":");
			if (type == "Code") { 
				return stsArr[0]; 
			}
			else { 
				return stsArr[1]; 
			}
		}
		return "";
	}
	/**
	 * Tariff of data, depending on the selected Group, Multi Coverage should change the title.
	 */	 
	function setMultiCoverageTitle() {
		var sheetObj1=sheetObjects[0];
		var sheetObj=sheetObjects[1];
		var trfCd=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), TARIFF);
		var HeadTitle1="";
		var HeadTitle2="|Seq.|Country|Region/State|Location";
		switch(trfCd) {
			case "DMOF": 
				HeadTitle1="|Seq.|BKG POL / CY|BKG POL / CY|BKG POL / CY";
			break;
			
			case "DMIF": 
				HeadTitle1="|Seq.|BKG POD / CY|BKG POD / CY|BKG POD / CY";
			break;
			
			case "DTOC":
			case "CTOC":
				HeadTitle1="|Seq.|BKG POR|BKG POR|BKG POR";
			break;
			
			case "DTIC": 
			case "CTIC":
				HeadTitle1="|Seq.|BKG DEL|BKG DEL|BKG DEL";
			break;
		}

		changeHeaderRow(sheetObj, 0, HeadTitle1);
        changeHeaderRow(sheetObj, 1, HeadTitle2);
	}
   	/**
   	 * Rate Adjustment of the items required, select a function to check whether
   	 */	  	 
  	function checkMandatoryRateAdjustment() {
  		var formObj=document.form;
  		var sheetSCObj=sheetObjects[0];
  		var sheetCVRGObj=sheetObjects[1];
  		var sheetRTObj=sheetObjects[3];
  		with(sheetSCObj) {
  		    var iRow = GetSelectRow();
			if (	ComTrim(GetCellValue(iRow, TARIFF)) 	!= ""
			 && 	ComTrim(GetCellValue(iRow, EFF_DT)) 	!= ""
			 &&	    ComTrim(GetCellValue(iRow, EXP_DT)) 	!= ""
			 && 	ComTrim(GetCellValue(iRow, CNTRCGO)) 	!= ""	) {
  				//< Coverage : Single  >+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (GetCellValue(iRow, CVRG_MULTI) == "S") {
					if (GetCellValue(iRow, CVRG_CNT) == "") return;
					ComSetObjValue(formObj.cnt_cd,	GetCellValue(iRow, CVRG_CNT));
					ComSetObjValue(formObj.loc_cd,	GetCellValue(iRow, CVRG_LOC));
					if (GetCellValue(iRow, CVRG_CNT) == "CA" || GetCellValue(iRow, CVRG_CNT) == "US") {
	  					ComSetObjValue(formObj.rgn_cd, "");
	  					ComSetObjValue(formObj.ste_cd, GetCellValue(iRow, CVRG_RGN));
	  				}
	  				else {
	  					ComSetObjValue(formObj.rgn_cd, GetCellValue(iRow, CVRG_RGN));
	  					ComSetObjValue(formObj.ste_cd, "");
	  				}
				
					doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
					var result=ComTrim(ComGetObjValue(formObj.result));
					if (result == "E") {
						SetCellValue(iRow, RT_MANDATORY,"N");
						SetCellValue(iRow, RT_CHECK,"N");
						if (GetCellValue(iRow, TARIFF).indexOf("CT") != -1)
							errMsgId="DMT02003";
						else
							errMsgId="DMT00132";
						errMsg="[ " + GetCellValue(iRow, CVRG_CNT) + " ][ " + GetCellValue(iRow, CVRG_RGN) + " ][ " + GetCellValue(iRow, CVRG_LOC) + " ]";
						ComShowCodeMessage(errMsgId, GetCellValue(iRow, "Seq"), errMsg);
						return "E";
					}
					//2-2.Mandatory
					else if (result == "M") {
						SetCellValue(iRow, RT_MANDATORY,"Y");
						SetCellValue(iRow, RT_CHECK,"Y");
						formObj.chkRateAdjustment.checked=true;
						checkRateAdjustment();
					}
					//2-3.optional
					else {
						SetCellValue(iRow, RT_MANDATORY,"N");
						if (fetchRowCount(sheetRTObj) > 0)
							SetCellValue(iRow, RT_CHECK,"Y");
						else
							SetCellValue(iRow, RT_CHECK,"N");
					}
	  			}
	  			//< Coverage : Multi   >+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  			else {
	  				for (var row=sheetCVRGObj.HeaderRows(); row <= sheetCVRGObj.LastRow(); row++) {
	  					if (sheetCVRGObj.GetRowStatus(row) != "D") {
	  						if (sheetCVRGObj.GetCellValue(row, CVRG_CNT) == "") continue;
	  						ComSetObjValue(formObj.cnt_cd,	sheetCVRGObj.GetCellValue(row, CVRG_CNT));
	  						ComSetObjValue(formObj.loc_cd,	sheetCVRGObj.GetCellValue(row, CVRG_LOC));
	  						if (sheetCVRGObj.GetCellValue(row, CVRG_CNT) == "CA" || sheetCVRGObj.GetCellValue(row, CVRG_CNT) == "US") {
  			  					ComSetObjValue(formObj.rgn_cd, "");
  			  					ComSetObjValue(formObj.ste_cd, sheetCVRGObj.GetCellValue(row, CVRG_RGN));
  			  				}
  			  				else {
  			  					ComSetObjValue(formObj.rgn_cd, sheetCVRGObj.GetCellValue(row, CVRG_RGN));
  			  					ComSetObjValue(formObj.ste_cd, "");
  			  				}  							
  							doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
  							var result=ComTrim(ComGetObjValue(formObj.result));
  							if (result == "E") {
  								SetCellValue(iRow, RT_MANDATORY,"N");
  								SetCellValue(iRow, RT_CHECK,"N");
  								if (GetCellValue(iRow, TARIFF).indexOf("CT") != -1)
  									errMsgId="DMT02003";
  								else
  									errMsgId="DMT00132";
  								errMsg="[ " + sheetCVRGObj.GetCellValue(row, CVRG_CNT) + " ][ " + sheetCVRGObj.GetCellValue(row, CVRG_RGN) + " ][ " + sheetCVRGObj.GetCellValue(row, CVRG_LOC) + " ]";
  								ComShowCodeMessage(errMsgId, GetCellValue(iRow, "Seq"), errMsg);
  								return "E";
  							}
  							//2-2.Mandatory
  							else if (result == "M") {
  								SetCellValue(iRow, RT_MANDATORY,"Y");
  								SetCellValue(iRow, RT_CHECK,"Y");
  								formObj.chkRateAdjustment.checked=true;
  								checkRateAdjustment();
  							}
  							//2-3.option
  							else {
  								SetCellValue(iRow, RT_MANDATORY,"N");
  								if (fetchRowCount(sheetRTObj) > 0)
  									SetCellValue(iRow, RT_CHECK,"Y");
  								else
  									SetCellValue(iRow, RT_CHECK,"N");
  							}
	  					}
	  				}	
	  			} //Coverage Multi  end if
  			} //Rate Adjustment check end if
  		}
  		return result;
  	}
	/**
	 * Free Time at the Y column, select the Automatically Tier 'Single' to change the logic to be selected due to
	 * Tier unconditional ROW have a different selection 'Multi' even if the 'Single' to solve the problem of changing
	 * Y for the previous state of the field to create a column, a function that initializing the state field.
	 */	    	 
   	function setPreviousFTFlag(sheetObj) {
   		with(sheetObj) {
	   		for (var row=HeaderRows(); row < LastRow(); row++) {
	   			SetCellValue(row, PREV_FT_FLG,GetCellValue(row, FT_FLG));
	   		}
   		}
   	}
	/**
	 *  S/C Group Grid Coverage information 
	 *  in the move to put the data in the Multi Coverage Grid. 
	 */		
	function copyGroupCoverageforSave() {
		var sheetSCObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		with(sheetSCObj) {
			var prevCVRGMulti=ComTrim(GetCellValue(GetSelectRow(), CURR_CVRG_MULTI));
			var currCVRGMulti=ComTrim(GetCellValue(GetSelectRow(), CVRG_MULTI));
		}
		/**
		 * Multi 구분이 
		 * 1. Single : 	'U' 
		 * 2. Single -->  Multi 		'D'  and delete
		 * 3. Multi  -->  Single 	 	'I'  and insert
		 * 4. Multi  -->  Multi  	 	'U'  and update
		 */
		with(sheetCVRGObj) {
			//1. Single: 'U'									
			if (prevCVRGMulti == "S" && currCVRGMulti == "S") {
				var iRow = DataInsert(-1);
				SetRowHidden(iRow,1);
				SetCellValue(iRow, PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
				SetCellValue(iRow, VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(iRow, GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
				SetCellValue(iRow, CVRG_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_SEQ),0);
				SetCellValue(iRow, CVRG_CNT,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_CNT),0);
				SetCellValue(iRow, CVRG_RGN,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_RGN),0);
				SetCellValue(iRow, CVRG_LOC,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_LOC),0);
				SetRowStatus(iRow,"U");
			}
			//2. Single -->  Multi 		'D'  and delete
			else if (prevCVRGMulti == "S" && currCVRGMulti == "M") {
				var iRow = DataInsert(-1);
				SetRowStatus(iRow,"U");
				SetRowHidden(iRow,1);
				SetCellValue(iRow, PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
				SetCellValue(iRow, VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(iRow, GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
				SetCellValue(iRow, CVRG_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_SEQ),0);
				SetRowStatus(iRow,"D");
			}
			//3. Multi  -->  Single 	 	'I'  and insert
			else if ((prevCVRGMulti == "M" || prevCVRGMulti == "") && currCVRGMulti == "S") {
				var iRow = DataInsert(-1);
				SetRowHidden(iRow,1);
				SetCellValue(iRow, PROP_NO,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO),0);
				SetCellValue(iRow, VER_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(iRow, GRP_SEQ,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ),0);
				SetCellValue(iRow, CVRG_SEQ,"1",0);
				SetCellValue(iRow, CVRG_CNT,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_CNT),0);
				SetCellValue(iRow, CVRG_RGN,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_RGN),0);
				SetCellValue(iRow, CVRG_LOC,sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_LOC),0);
				SetRowStatus(iRow,"I");
			}
		}			
	}
	/**
	 * S/C Group Grid Coverage in Multi Coverage Grid for storing information in the data is moved into place, delete the data.
	 */		
	function releaseGroupCoverageforSave() {
		var sheetCVRGObj=sheetObjects[1];
		with(sheetCVRGObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowHidden(row)) {
					RowDelete(row, false);
				}
			}
		}
	}
	/**
	 * S/C Exception Tariff History query that brings up a pop-up function.
	 */
	function openWinSearchTariffHistory() {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sCNo=ComTrim(ComGetObjValue(formObj.sCNo));
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		var custNm=ComTrim(ComGetObjValue(formObj.custNm));
		var status=ComTrim(ComGetObjValue(formObj.status));
		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
		var verSeq=ComTrim(ComGetObjText(formObj.version));
		var count 		= fetchRowCount(sheetSCObj);
		var caller=ComTrim(ComGetObjValue(formObj.caller));
		if (caller == "2006" || caller == "2007" || caller == "3107") {
			isActBtnCopy="N";
		}
		else if (status == "" || status == "Temp. Saved") {
			isActBtnCopy="Y";
		}
		else {
			isActBtnCopy="N";
		}
		var params="sc_no=" + sCNo;
		params += "&prop_no=" + propNo;
		params += "&ver_seq=" + verSeq;
		params += "&cust_cd=" + custCd;
		params += "&cust_nm=" + custNm;
		params += "&status=" + status;
		params += "&rowcount=" + count + "";
		params += "&is_copy=" + isActBtnCopy;
		ComOpenPopup("EES_DMT_2103.do?" + params, 920, 455, "copyTariffHistory", "0,1", true);
	}
	/**
	 * S/C Exception Tariff History from the selected version of the S / C Exception Tariff for the current version of the function to create
	 */	
	function copyTariffHistory(aryPopupData) {
		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		ComSetObjValue(formObj.hist_prop_no, 			aryPopupData[0]);
		ComSetObjValue(formObj.sc_expt_hist_ver_seq,	aryPopupData[1]);
		//The current version of the S/C Exception Tariff information, if any, delete,
		//In the current version of S/C Exception Tariff History from the pop-up screen, select the version of the S/C Exception Tariff information is generated.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF_HISTORY);
		if (ComGetObjValue(formObj.result) == "Y") {
			//S/C Exception Tariff 
			doActionRetrieve(IBSEARCH);
		}
		else {
			ComShowCodeMessage("DMT00008", "copy");
			return;
		}
	}
	/**
	 * Screen pop up shows up, the caller so that vary depending on the button to display a function that handles
	 */	
    function displayBtnByCaller() {
    	var formObj=document.form;
    	switch(ComGetObjValue(document.getElementById("caller"))) {
	    	case "2006":
	    	case "2007":
	    	case "3107":
				btnNewLayer.style.display='none';
				btnUpdateLayer.style.display='none';
				btnSaveLayer.style.display='none';
				btnDeleteLayer.style.display='none';
				btnAcceptLayer.style.display='none';
				btnAcceptCancelLayer.style.display='none';
				//S/C Group
				btnAddSCLayer.style.display='none';
				btnCopySCLayer.style.display='none';
				btnSaveSCLayer.style.display='none';
				btnDelSCLayer.style.display='none';
				//Multi Coverage
				btnAddMultiCoverageLayer.style.display='none';
				btnDelMultiCoverageLayer.style.display='none';
				//Tiered Free Time
				btnAddFreeTimeLayer.style.display='none';
				btnDelFreeTimeLayer.style.display='none';
				//Rate Adjustment
				btnAddRateAdjustmentLayer.style.display='none';
				btnDelRateAdjustmentLayer.style.display='none';
				//Customer
				btnAddCustomerLayer.style.display='none';
				btnDelCustomerLayer.style.display='none';
				//Commodity
				btnAddCommodityLayer.style.display='none';
				btnDelCommodityLayer.style.display='none';
//				btnLineLayer.style.display='none';
				btnCloseLayer.style.display='inline';
			break;
			
			default:
				btnNewLayer.style.display='inline';
				btnUpdateLayer.style.display='inline';
				btnSaveLayer.style.display='inline';
				btnDeleteLayer.style.display='inline';
				btnAcceptLayer.style.display='inline';
				btnAcceptCancelLayer.style.display='inline';
				//S/C Group
				btnAddSCLayer.style.display='inline';
				btnCopySCLayer.style.display='inline';
				btnSaveSCLayer.style.display='inline';
				btnDelSCLayer.style.display='inline';
				//Multi Coverage
				btnAddMultiCoverageLayer.style.display='inline';
				btnDelMultiCoverageLayer.style.display='inline';
				//Tiered Free Time
				btnAddFreeTimeLayer.style.display='inline';
				btnDelFreeTimeLayer.style.display='inline';
				//Rate Adjustment
				btnAddRateAdjustmentLayer.style.display='inline';
				btnDelRateAdjustmentLayer.style.display='inline';
				//Customer
				btnAddCustomerLayer.style.display='inline';
				btnDelCustomerLayer.style.display='inline';
				//Commodity
				btnAddCommodityLayer.style.display='inline';
				btnDelCommodityLayer.style.display='inline';
//				btnLineLayer.style.display='inline';
				btnCloseLayer.style.display='inline';   
    	}
    }
    /**
     * Customer Type Customer information is changed by checking if the function fills in the combo
     */
    function searchCustomerByTypeChange() {
        var formObj=document.form;
        var sheetCUSTObj=sheetObjects[4];
        delSubSCException(sheetCUSTObj, "All");
        ComSetObjValue(formObj.cust_type, ComGetObjValue(formObj.customerType));
       	doActionIBSheet(sheetCUSTObj, formObj, IBSEARCH_CUST);
    }
    /**
     * Save time, save selected Actual Customer Type of functions that map to the grid in order to
     */
    function setCustomerType() {
    	var formObj=document.form;
    	var sheetCustObj=sheetObjects[4];
    	var custType=ComGetObjValue(formObj.customerType);
    	with(sheetCustObj) {
    		for (var row=HeaderRows(); row <= LastRow(); row++) {
    			SetCellValue(row, ACT_CUST_FLG,custType,0);
    		}
    	}
    }
     /**
      * Delivered normally not received from the server being able to handle the data function 
      */
     function handleNullString(sVal) {
         if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
         return ComTrim(sVal);
     }
    function isChangedSCExceptionTariff(initSheetNo) {
    	var result=new Array(); 
    	result[0]=false;
    	if (initSheetNo == undefined) initSheetNo=0;
        for (var sheetNo=initSheetNo ; sheetNo < sheetObjects.length ; sheetNo++) {
        	with(sheetObjects[sheetNo]) {
	            for (var row=HeaderRows(); row <= LastRow(); row++) {
	            	switch(GetRowStatus(row)) {
		            	case "I":
		            		result[0]=true;
		            		result[1]=row;
		            		result[2]="add";
		            		result[3]="sheetObjects[" + sheetNo + "] : " + GetCellValue(row, "Seq") + " add. Checking";
		            		return result;
		            		break;
		            	case "U":
		            		result[0]=true;
		            		result[1]=row;
		            		result[2]="modify";
		            		result[3]="sheetObjects[" + sheetNo + "] : " + GetCellValue(row, "Seq") + " modify. Checking";
		            		return result;
		            		break;
		            	case "D":
		            		result[0]=true;
		            		result[1]=row;
		            		result[2]="delete";		            		
		            		result[3]="sheetObjects[" + sheetNo + "] : " + GetCellValue(row, "Seq") + " delete. Checking";
		            		return result;
		            		break;
	            	}
	            }
        	}
        }
      	return result;
    }
     /*
      * Coverage, if the value of Empty Space 1 leave it to convert a function that returns
      */
    function convertEmptyToSpace(sVal) {
    	if (sVal == "")
    		return "' '";
    	else
    		return "'" + sVal + "'";
    }
