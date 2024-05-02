/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2003.js
*@FileTitle  : DEM/DET Adjustment Request - Before Booking Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
     * @class Dual Type Exception Creation : Dual Type Exception Creation for generating business from the screen using a script is defined.
     */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;	
	var plusComboCnt = 1;
	var IBSEARCH_INIT=100;
	var IBSEARCH_DAR=101;
	var IBSEARCH_VER=102;
	var IBSEARCH_ACTCUST=103;
	var IBSEARCH_CALC=104;
	var IBSEARCH_DUAL=105;
	var IBSEARCH_CHKCONTI=106;
	var IBSEARCH_AFFL=107;
	var IBSEARCH_COMM=108;
	var IBSEARCH_APRO=109;
	var IBSEARCH_RFANO_CUST=110;
	var IBSEARCH_CHECK_DUP=111;
	var IBSEARCH_RFATARIFF=113;
	var IBSEARCH_SUB=114;
	var IBSEARCH_RFATARIFF_APVLNO=115;
	var IBSEARCH_VER_CHECK=116;
	var IBSEARCH_DAR_CHECK=117;
	var IBSAVE_DAR=201;
	var IBSAVE_VERSTS=202;
	var IBSAVE_REQUEST=203
	var IBSAVE_CANCEL=204;
	var IBSAVE_APPROVAL=205;
	var IBSAVE_COUNTER=206;
	var IBSAVE_REJECT=207;
	var IBSAVE_RFATARIFF=208;
	var IBSAVE_RFATARIFF_UPDATE=209;
	var	IBSAVE_RFATARIFF_HISTORY=210;
	var	IBDELETE_RFATARIFF=301;
	var ROWMARK="|";
	var FIELDMARK="=";
	var TARIFF="dmdt_trf_cd";
	var EFF_DT="eff_dt";
	var EXP_DT="exp_dt";
	var CNTRCGO="dmdt_cntr_cgo_tp_cd";
	var CVRG_CTI="cvrg_conti_cd";
	var CVRG_CNT="cvrg_cnt_cd";
	var CVRG_RGN="cvrg_rgn_cd";
	var CVRG_STE="cvrg_ste_cd";
	var CVRG_LOC="cvrg_loc_cd";
	var CVRG_POP="cvrg_pop";
	var FT_FLG="ft_use_flg";
	var ADD_DYS="add_dys";
	var TOT_DYS="ttl_dys";
	var RT_FROM="ft_ovr_dys";
	var RT_UPTO="ft_und_dys";
	var RT_20FT="cntr_20ft_rt_amt";
	var RT_40FT="cntr_40ft_rt_amt";
	var RT_HC="cntr_hc_rt_amt";
	var RT_45FT="cntr_45ft_rt_amt";
	var RT_SEQ="rfa_expt_rt_seq";	
	var RT_MANDATORY="rt_chk_flg";		
	var RT_CHECK="rt_chk";		
	var SAT_FLG="xcld_sat_flg";
	var SUN_FLG="xcld_sun_flg";
	var HOL_FLG="xcld_hol_flg";
	var ORGDST_MULTI="org_dest_multi";
	var CURR_ORGDST_MULTI="curr_org_dest_multi";
	var ORGDST_CTI="org_dest_conti_cd";
	var ORGDST_CNT="org_dest_cnt_cd";
	var ORGDST_RGN="org_dest_rgn_cd";
	var ORGDST_STE="org_dest_ste_cd";
	var ORGDST_LOC="org_dest_loc_cd";
	var ORGDST_POP="org_dest_pop";
	var BKGDEL_CTI="fnl_dest_conti_cd";	
	var BKGDEL_CNT="fnl_dest_cnt_cd";
	var BKGDEL_RGN="fnl_dest_rgn_cd";
	var BKGDEL_STE="fnl_dest_ste_cd";
	var BKGDEL_LOC="fnl_dest_loc_cd";
	var BKGDEL_POP="fnl_dest_pop";
	var REMARK="expt_trf_rmk";
	var FULL_REMARK="full_expt_trf_rmk";
	var DAR_NO="rfa_expt_dar_no";
	var MAPG_SEQ="rfa_expt_mapg_seq";
	var VER_SEQ="rfa_expt_ver_seq";
	var DTL_SEQ="rfa_rqst_dtl_seq";
	var CVRG_SEQ="cvrg_cmb_seq";
	var VIEW_CVRG_SEQ="view_cvrg_cmb_seq";
	var CURR_CD="curr_cd";
	var RQST_STS_CD="dmdt_expt_rqst_sts_cd";
	var RQST_STS_DESC="dmdt_expt_rqst_sts_desc";
	var RQST_OFC_CD="rqst_ofc_cd";
	var PROG_DT="prog_dt";
	var PROG_OFC_CD="prog_ofc_cd";
	var PROG_USR_NM="prog_usr_nm";
	var PROG_RMK="prog_rmk";
	var RT_USE_FLG="rt_use_flg";
	var FNL_DEST_FLG="fnl_dest_flg";
	var HID_STATUS="hidden_status";
	//Actual Customer
	var CUST_CD="cust_cd";
	var CUST_NM="cust_nm";
	var ROW_EDIT_STS="row_edit_status";
	var isClearLocation=true;
	var isValueSettingEvent=false;
	var isRateCheckingCVRG="";
	var prevPropNo="";
	var prevDarNo="";
    var isDAREmpty=false;
    var isSettingValue=false;
	var isCopyRFAExceptionTariff=false;
	var currDtlSeq="";
	
	//[2016.01.05] NYK Add
	var	FT_TIR="ft_tir";
	var FT_FROM="cntr_fm_qty";
	var FT_UPTO="cntr_to_qty";
	var FT_DAYS="ft_dys";
	//var PROP_NO="prop_no";
	var FT_SEQ="ft_seq";
	var CMDT_CD="cmdt_cd";
	var CMDT_NM="cmdt_nm";
	var CMDT_FLG="cmdt_flg";
	
	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name  */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetRFAObj=sheetObjects[0];
         var sheetCVRGObj=sheetObjects[1];
         var sheetRTObj=sheetObjects[2];
         var sheetHSTObj=sheetObjects[5];
         
         var sheetFTObj=sheetObjects[3]; 	//[2016.01.05] NYK Add
         var sheetCMDTObj=sheetObjects[4]; 	//[2016.01.05] NYK Add
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName = ComGetEvent("name");

    		if (!ComIsBtnEnable(srcName)) return;    		
    		
            switch(srcName) {
            	case "btn_Affiliate":
					doProcessPopup("Affiliate");
				break;
				
				case "btn_AddBKGReqDetail":
					addBKGReqDetail();
				break;
				
				case "btn_CopyBKGReqDetail":
					copyBKGReqDetail();
				break;
				
				case "btn_SaveBKGReqDetail":
					saveBKGReqDetail();
				break;
				
				case "btn_DelBKGReqDetail":
					delBKGReqDetail();
				break;
				
				case "btn_AddMultiOrgDest":
					addMultiOrgDest();
				break;
				
				case "btn_DelMultiOrgDest":
					delSubBeforeException(sheetCVRGObj);
				break;
				
				case "btn_AddRateAdjustment":
					addRateAdjustment();
				break;
				
				case "btn_DelRateAdjustment":
					delSubBeforeException(sheetRTObj);
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
				

				//[2016.01.05] NYK Add start.
				case "btn_AddFreeTime":
					addFreeTime();
				break;
				case "btn_DelFreeTime":
					delSubBeforeException(sheetFTObj);
				break;
				
				case "btn_AddCommodity":
					addCommodity();
				break;
				case "btn_DelCommodity":
					delSubBeforeException(sheetCMDTObj);
				break;
				//[2016.01.05] NYK Add e n d.				
            }
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
  		var sheetRFAObj=sheetObjects[0];
        for (i=0 ; i < sheetObjects.length ; i++) {
        	ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    for (var k=0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
	    axon_event.addListener('blur', 'comment_Change', 'comment');
		initControl();
		initDisableObjects();
		displayBtnByCaller();		
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND06);
		
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_INIT);
		if (ComTrim(ComGetObjValue(formObj.proposalNo)) != "") {
			doActionRetrieve(IBSEARCH);
		}
		else {
			addComboItem(formObj.version, "001=", true);
			initBtnControl();
			var usrRhqOfcCd=ComGetObjValue(formObj.rhq_ofc_cd);
	   		ComSetObjValue(comboObjects[0], usrRhqOfcCd);
		}   		
    }
    
	function initControl() {
		axon_event.addListenerFormat('keypress',	'obj_keypress', 	document.form); 		
  		axon_event.addListener('keydown', 			'ComKeyEnter', 		'form');
	}
	function initDisableObjects() {
		var formObj=document.form;
		with(formObj) {
			ComEnableManyObjects(false, rFANo, proposalNo, custCd, custNm, status);
			rFANo.className="input2";
			proposalNo.className="input2";
			custCd.className="input2";
			custNm.className="input2";
			status.className="input2";
			chkComment.checked=false;
			comment.readOnly=true;
			comment.className="textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++
		}		
	}
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
          		DmtComKeyOnlyAlphabet('uppernum', ',. ');
 		        break;
          	case "engup3":
          		DmtComKeyOnlyAlphabet('upperall')
          		break;
          	case "int":
          		ComKeyOnlyNumber(event.srcElement);
     	        break;
          	default:
          		ComKeyOnlyNumber(event.srcElement);
		}
	}     
    /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
 //no support[check again]CLT 		sheetObj.ToolTipOption="balloon:true;width:50;";
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		              var HeadTitle1="|Seq.|Tariff|EFF DT|EXP DT|CNTR/Cargo Type|Coverage|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|Actual Customer|Actual Customer|Remark";
		              var HeadTitle2="|Seq.|Tariff|EFF DT|EXP DT|CNTR/Cargo Type|CN|RGN|LOC|LOC|Y|Tier|Add|Total|SAT|SUN|H/day|Multi|CT|CN|RGN|LOC|LOC|CN|RGN|LOC|LOC|Code|Name|Remark";
		              var headCount=ComCountHeadTitle(HeadTitle1) + 20;
		              //(headCount, 0, 0, true);
		              SetSelectionMode(smSelectionRow);
		
		              SetConfig( { SearchMode:2, FrozenCol:10, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:CNTRCGO,              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:CVRG_POP,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:FT_FLG,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:FT_TIR,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ADD_DYS,              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, MinimumValue:0 },
		                     {Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TOT_DYS,              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, MinimumValue:0 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_MULTI,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CTI,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CNT,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_RGN,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_LOC,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_POP,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CNT,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_RGN,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_LOC,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_POP,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:REMARK,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DAR_NO,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DTL_SEQ,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VIEW_CVRG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_ORGDST_MULTI,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_CD,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FULL_REMARK,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_CTI,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CTI,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RQST_STS_CD,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RQST_OFC_CD,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_MANDATORY,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_CHECK,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_USE_FLG,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FNL_DEST_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:ROW_EDIT_STS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CMDT_FLG,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetColProperty(TARIFF, {ComboText:"", ComboCode:""} );
		              SetColProperty(CNTRCGO, {ComboText:"", ComboCode:""} );
		              SetColProperty(CVRG_CNT, {ComboText:"", ComboCode:""} );
		              SetColProperty(CVRG_RGN, {ComboText:"", ComboCode:""} );
		              SetColProperty(ORGDST_MULTI, {ComboText:"Single|Multi", ComboCode:"S|M"} );
		              SetColProperty(ORGDST_CTI, {ComboText:"", ComboCode:""} );
		              SetColProperty(ORGDST_CNT, {ComboText:"", ComboCode:""} );
		              SetColProperty(ORGDST_RGN, {ComboText:"", ComboCode:""} );
		              SetColProperty(BKGDEL_CNT, {ComboText:"", ComboCode:""} );
		              SetColProperty(BKGDEL_RGN, {ComboText:"", ComboCode:""} );
		              SetColProperty(CUST_CD, {ComboText:"", ComboCode:""} );
		              SetColProperty(FT_TIR, {ComboText:"Single|Multi", ComboCode:"S|M"} );//[2016.01.04] NYK Add
		              FrozenCols=SaveNameCol(FT_FLG);
		              SetShowButtonImage(2);
		              SetSheetHeight(182,1);
		              SetRangeBackColor(1,5,1,27,"#555555");
              }
                break;
            case "sheet2":
                with(sheetObj){
		              var HeadTitle1="|Seq.|BKG POR|BKG POR|BKG POR|BKG POR|BKG POR";
		              var HeadTitle2="|Seq.|Continent|Country|Region|Location|Location";
		              var headCount=ComCountHeadTitle(HeadTitle1) + 10;
		              //(headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:ORGDST_CTI,    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"ComboEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:ORGDST_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_POP,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:CVRG_CTI,      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:CVRG_CNT,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:CVRG_RGN,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:CVRG_LOC,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DAR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DTL_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetColProperty(ORGDST_CTI, {ComboText:"", ComboCode:""} );
		              SetColProperty(ORGDST_CNT, {ComboText:"", ComboCode:""} );
		              SetColProperty(ORGDST_RGN, {ComboText:"", ComboCode:""} );
		              SetShowButtonImage(2);
		              SetSheetHeight(122,1);
		              SetRangeBackColor(1,1,1,5,"#555555");
              }


                break;
            case "sheet3":
                with(sheetObj){
		              var HeadTitle1="|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
		              var HeadTitle2="|From|Up To|20 FT|40 FT|H/C|45 FT";
		              var headCount=ComCountHeadTitle(HeadTitle1) + 7;
		              //(headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:RT_FROM,       KeyField:1,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:RT_UPTO,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:RT_20FT,       KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:RT_40FT,       KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:RT_HC,         KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:RT_45FT,       KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:DAR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:DTL_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetSheetHeight(122,1);
		              SetRangeBackColor(1,0,1,6,"#555555");
                    }
                break;
            case "sheet4":
                with(sheetObj){
		              var HeadTitle1="|Seq.|Status|Date|Office|Name";
		              var headCount=ComCountHeadTitle(HeadTitle1) + 1;
		              //(headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:RQST_STS_DESC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:PROG_DT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:PROG_OFC_CD,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:PROG_USR_NM,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:PROG_RMK,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetSheetHeight(100,1);
                    }
                break;

                
            case "sheet5"://[2016.01.04] NYK Add Tiered Free Time
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
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DAR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DTL_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetSheetWidth(mainTable.clientWidth);
	                SetSheetHeight(122,1);
	                SetCountPosition(0);
            	}
            break; 
            
            case "sheet6": //[2016.01.04] NYK Add Commodity
                with(sheetObj){
					var HeadTitle1="|Code|Name";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								 {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:CMDT_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:CMDT_NM,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DAR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DTL_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetSheetWidth(mainTable.clientWidth);
	                SetSheetHeight(122,1);
	                SetCountPosition(0);
            	}
            break;              
        }
    }
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form
   	    switch(comboNo) {
	    	//APVL Combo
	    	case 1:
	    		with(comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "140");
					SetDropHeight(160);
	    		}
		break;   	    
   	    	//DAR Combo
   	    	case 2:
   	    		with(comboObj) {
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColWidth(0, "140");
   					SetDropHeight(160);
   	    		}
    		break;
    		
   	   	   	//APVL NO Combo
   	    	case 3:
   	    		with(comboObj) {
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColWidth(0, "135");
   					SetDropHeight(160);
   	    		}
    		break;   	    		
   	     } 
   	}      
	//Sheet processing-related processes
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var cboAPVLObj=comboObjects[1 + plusComboCnt];
		var sheetRTObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetCMDTObj=sheetObjects[4];
		switch(sAction) {
	        case IBSEARCH_INIT:
	        	ComSetObjValue(formObj.prop_no,			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.apro_ofc_cd, 	"init");
				ComSetObjValue(formObj.f_cmd, 			COMMAND01);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));				
				//3-2.Tariff Type
				tariffList=handleNullString(ComGetEtcData(sXml, "TARIFF"));
				addCellComboItem(sheetObj, tariffList, "dmdt_trf_cd", false);
				//3-3.CNTR/CGO Type
				cntrCgoList=handleNullString(ComGetEtcData(sXml, "CNTRCGO"));
				addCellComboItem(sheetObj, cntrCgoList, "dmdt_cntr_cgo_tp_cd", false, false);
				//3-4.Origin or Dest. Continent
				continentList=handleNullString(ComGetEtcData(sXml, "CONTINENT"));
				addCellComboItem(sheetObj, 		continentList, "org_dest_conti_cd", false);
				addCellComboItem(sheetCVRGObj, 	continentList, "org_dest_conti_cd", false);
				//3-5.Country
				countryList=handleNullString(ComGetEtcData(sXml, "COUNTRY"));
				addCellComboItem(sheetObj, 		countryList, 	"cvrg_cnt_cd", 			false);
				addCellComboItem(sheetObj, 		countryList, 	"org_dest_cnt_cd",		false);
				addCellComboItem(sheetObj, 		countryList, 	"fnl_dest_cnt_cd", 		false);
				addCellComboItem(sheetCVRGObj, 	countryList, 	"org_dest_cnt_cd", 		false);
				//3-6.Region
				regionList=handleNullString(ComGetEtcData(sXml, "REGION"));
				addCellComboItem(sheetObj, 		regionList, 	"cvrg_rgn_cd", 			false);
				addCellComboItem(sheetObj, 		regionList, 	"org_dest_rgn_cd", 		false);
				addCellComboItem(sheetObj, 		regionList, 	"fnl_dest_rgn_cd", 		false);
				addCellComboItem(sheetCVRGObj, 	regionList, 	"org_dest_rgn_cd", 		false);
	            ComSetObjValue(formObj.custCd, 			handleNullString(ComGetEtcData(sXml, "CUST_CD"))); //CUST_CNT_CD + CUST_SEQ(6자리)
	            ComSetObjValue(formObj.custNm, 			handleNullString(ComGetEtcData(sXml, "CUST_NM")));
	            ComSetObjValue(formObj.custSeq, 		handleNullString(ComGetEtcData(sXml, "CUST_SEQ"))); //CUST_SEQ
	            ComSetObjValue(formObj.rFANo, 			handleNullString(ComGetEtcData(sXml, "RFA_NO")));
	            actCustList=handleNullString(ComGetEtcData(sXml, "CUST"));
	            addCellComboItem(sheetObj, 		actCustList, 	CUST_CD, 				false);
	            darList=handleNullString(ComGetEtcData(sXml, "DAR"));
	            cboDARObj.RemoveAll();
	            if (darList != "")
	            	addMultiComboItem(cboDARObj, darList.split(ROWMARK));
            	if (cboDARObj.GetItemCount() > 0) {
	            	isSettingValue=true;
	            	cboDARObj.SetSelectIndex(0);
	            	isSettingValue=false;
	            	ComSetObjValue(comboObjects[0],  cboDARObj.GetSelectCode());
            	}
            	
            	//[2016.01.04] NYK Add Commodity
	            cmdtList=handleNullString(ComGetEtcData(sXml, "CMDT"));
	            addCellComboItem(sheetCMDTObj,cmdtList, CMDT_CD, false);
				//==========================================================================================================================
	        break;
	        
			case IBSEARCH:      
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.GetSelectText()));
					ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
					ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	"");
					ComSetObjValue(formObj.f_cmd, 				SEARCH);
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					sheetObjects[0].SetWaitImageVisible(0);
					sheetObjects[5].SetWaitImageVisible(0);
					//*********************************************************************************
 					var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
		            var arrXml=sXml.split("|$$|");
		            sheetObjects[0].RemoveAll();	//Before Booking Request Detail
					sheetObjects[5].RemoveAll();	//Comment History
	            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[5].LoadSearchData(arrXml[1],{Sync:1} );
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					formObj.chkComment.checked=false;
					with(sheetObjects[5]) {
						if (RowCount()> 0) {
							ComSetObjValue(formObj.comment, GetCellValue(HeaderRows(), PROG_RMK));
						}
						else {
							ComSetObjValue(formObj.comment, "");
						}
						//ComEnableObject(formObj.comment, false);
						formObj.comment.readOnly=true;
						formObj.comment.style.backgroundColor="#E8E7EC";	//textarea2
						//++++++++++++++++++++++++++++++++++++++++++++++++
					}
				}
				else if (sheetObj.id == "sheet3") {
					var sheetObj1=sheetObjects[0];
					var custCd=ComTrim(formObj.custCd.value);
					ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0,2));
					ComSetObjValue(formObj.cust_seq, ComTrim(ComGetObjValue(formObj.custSeq)));
					with(sheetObj1) {
						ComSetObjValue(formObj.dmdt_trf_cd, 		GetCellValue(GetSelectRow(), TARIFF));
						ComSetObjValue(formObj.eff_dt, 				GetCellValue(GetSelectRow(), EFF_DT));
						ComSetObjValue(formObj.exp_dt, 				GetCellValue(GetSelectRow(), EXP_DT));
						ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, GetCellValue(GetSelectRow(), CNTRCGO));
						ComSetObjValue(formObj.cnt_cd, 				GetCellValue(GetSelectRow(), CVRG_CNT));
						if (GetCellValue(GetSelectRow(), CVRG_CNT) == "CA" || GetCellValue(GetSelectRow(), CVRG_CNT) == "US") {
							ComSetObjValue(formObj.rgn_cd, 			"");
							ComSetObjValue(formObj.ste_cd, 			GetCellValue(GetSelectRow(), CVRG_RGN));
						}
						else {
							ComSetObjValue(formObj.rgn_cd, 			GetCellValue(GetSelectRow(), CVRG_RGN));
							ComSetObjValue(formObj.ste_cd, 			"");							
						}
						ComSetObjValue(formObj.loc_cd, 				GetCellValue(GetSelectRow(), CVRG_LOC));
					}
					ComSetObjValue(formObj.f_cmd, SEARCH01);
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
 					var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					var result=ComGetEtcData(sXml, "RT_MANDATORY");
					ComSetObjValue(formObj.result, result);					
				}
			break;
			
	        case IBSEARCH_RFATARIFF:
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), DTL_SEQ));
				ComSetObjValue(formObj.f_cmd, 				SEARCH16);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				with(sheetObj) {
					SetCellValue(GetSelectRow(), TARIFF,handleNullString(ComGetEtcData(sXml, "TARIFF")),0);
					SetCellValue(GetSelectRow(), EFF_DT,handleNullString(ComGetEtcData(sXml, "EFF_DT")),0);
					SetCellValue(GetSelectRow(), EXP_DT,handleNullString(ComGetEtcData(sXml, "EXP_DT")),0);
					SetCellValue(GetSelectRow(), CNTRCGO,handleNullString(ComGetEtcData(sXml, "CNTRCGO")),0);
					SetCellValue(GetSelectRow(), CVRG_CNT,handleNullString(ComGetEtcData(sXml, "CVRG_CNT")),0);
					SetCellValue(GetSelectRow(), CVRG_RGN,handleNullString(ComGetEtcData(sXml, "CVRG_RGN")),0);
					SetCellValue(GetSelectRow(), CVRG_LOC,handleNullString(ComGetEtcData(sXml, "CVRG_LOC")),0);
					SetCellValue(GetSelectRow(), FT_FLG,handleNullString(ComGetEtcData(sXml, "FT_FLG")),0);
					SetCellValue(GetSelectRow(), FT_TIR,handleNullString(ComGetEtcData(sXml, "FT_TIR")),0);//[2016.01.04] NYK Add.
					SetCellValue(GetSelectRow(), ADD_DYS,handleNullString(ComGetEtcData(sXml, "ADD_DYS")),0);
					SetCellValue(GetSelectRow(), TOT_DYS,handleNullString(ComGetEtcData(sXml, "TOT_DYS")),0);
					SetCellValue(GetSelectRow(), SAT_FLG,handleNullString(ComGetEtcData(sXml, "SAT_FLG")),0);
					SetCellValue(GetSelectRow(), SUN_FLG,handleNullString(ComGetEtcData(sXml, "SUN_FLG")),0);
					SetCellValue(GetSelectRow(), HOL_FLG,handleNullString(ComGetEtcData(sXml, "HOL_FLG")),0);
					SetCellValue(GetSelectRow(), ORGDST_MULTI,handleNullString(ComGetEtcData(sXml, "ORGDST_MULTI")),0);
					SetCellValue(GetSelectRow(), ORGDST_CTI,handleNullString(ComGetEtcData(sXml, "ORGDST_CTI")),0);
					SetCellValue(GetSelectRow(), ORGDST_CNT,handleNullString(ComGetEtcData(sXml, "ORGDST_CNT")),0);
					SetCellValue(GetSelectRow(), ORGDST_RGN,handleNullString(ComGetEtcData(sXml, "ORGDST_RGN")),0);
					SetCellValue(GetSelectRow(), ORGDST_LOC,handleNullString(ComGetEtcData(sXml, "ORGDST_LOC")),0);
					SetCellValue(GetSelectRow(), BKGDEL_CNT,handleNullString(ComGetEtcData(sXml, "BKGDEL_CNT")),0);
					SetCellValue(GetSelectRow(), BKGDEL_RGN,handleNullString(ComGetEtcData(sXml, "BKGDEL_RGN")),0);
					SetCellValue(GetSelectRow(), BKGDEL_LOC,handleNullString(ComGetEtcData(sXml, "BKGDEL_LOC")),0);
					SetCellValue(GetSelectRow(), CUST_CD,handleNullString(ComGetEtcData(sXml, "CUST_CD")),0);
					SetCellValue(GetSelectRow(), CUST_NM,handleNullString(ComGetEtcData(sXml, "CUST_NM")),0);
					SetCellValue(GetSelectRow(), REMARK,handleNullString(ComGetEtcData(sXml, "REMARK")),0);
					SetCellValue(GetSelectRow(), DAR_NO,handleNullString(ComGetEtcData(sXml, "DAR_NO")),0);
					SetCellValue(GetSelectRow(), MAPG_SEQ,handleNullString(ComGetEtcData(sXml, "MAPG_SEQ")),0);
					SetCellValue(GetSelectRow(), VER_SEQ,handleNullString(ComGetEtcData(sXml, "VER_SEQ")),0);
					SetCellValue(GetSelectRow(), DTL_SEQ,handleNullString(ComGetEtcData(sXml, "DTL_SEQ")),0);
					SetCellValue(GetSelectRow(), CVRG_SEQ,handleNullString(ComGetEtcData(sXml, "CVRG_SEQ")),0);
					SetCellValue(GetSelectRow(), VIEW_CVRG_SEQ,handleNullString(ComGetEtcData(sXml, "VIEW_CVRG_SEQ")),0);
					SetCellValue(GetSelectRow(), CURR_ORGDST_MULTI,handleNullString(ComGetEtcData(sXml, "CURR_ORGDST_MULTI")),0);
					SetCellValue(GetSelectRow(), CURR_CD,handleNullString(ComGetEtcData(sXml, "CURR_CD")),0);
					SetCellValue(GetSelectRow(), FULL_REMARK,handleNullString(ComGetEtcData(sXml, "FULL_REMARK")),0);
					SetCellValue(GetSelectRow(), CVRG_CTI,handleNullString(ComGetEtcData(sXml, "CVRG_CTI")),0);
					SetCellValue(GetSelectRow(), BKGDEL_CTI,handleNullString(ComGetEtcData(sXml, "BKGDEL_CTI")),0);
					SetCellValue(GetSelectRow(), RQST_STS_CD,handleNullString(ComGetEtcData(sXml, "RQST_STS_CD")),0);
					SetCellValue(GetSelectRow(), RQST_OFC_CD,handleNullString(ComGetEtcData(sXml, "RQST_OFC_CD")),0);
					SetRowStatus(GetSelectRow(),"R");
				}
        	break;
        	
	        case IBSEARCH_SUB:			
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), DTL_SEQ));
				ComSetObjValue(formObj.cvrg_cmb_seq, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_SEQ));
				ComSetObjValue(formObj.f_cmd, 				SEARCH15);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObjects[1].SetWaitImageVisible(0);
				sheetObjects[2].SetWaitImageVisible(0);
				
				//[2016.01.04] NYK Add
				sheetObjects[3].SetWaitImageVisible(0);
				sheetObjects[4].SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				
				//[2016.01.04] NYK Add
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				/*				
            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[2]) > 0) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );

				if (arrXml.length > 2 && ComGetTotalRows(arrXml[3]) > 0) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
				if (arrXml.length > 3 && ComGetTotalRows(arrXml[4]) > 0) sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
				*/				

				//[2016.01.04] NYK Add Commodity
	            var cmdtList=handleNullString(ComGetEtcData(arrXml[0], "CMDT"));
	            addCellComboItem(sheetCMDTObj,cmdtList, CMDT_CD, false);
				
				if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
				
				if (arrXml.length > 2 && ComGetTotalRows(arrXml[2]) > 0) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
				if (arrXml.length > 3 && ComGetTotalRows(arrXml[3]) > 0) sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************

			break;
			
			case IBSEARCH_DAR:
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		SEARCH01);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
	            darList=handleNullString(ComGetEtcData(sXml, "DAR"));
	            cboDARObj.RemoveAll();
	            if (darList != "")
	            	addMultiComboItem(cboDARObj, darList.split(ROWMARK));
            	if (cboDARObj.GetItemCount() > 0) {
	            	isSettingValue=true;
	            	if (ComGetObjValue(formObj.apvlno_dar) != "") {
	            		matchIndex=-1;
	            		for (var i=0 ; i < cboDARObj.GetItemCount() ; i++) {
	            			cboDARObj.SetSelectIndex(i);
	            			if (cboDARObj.GetSelectText()== ComGetObjValue(formObj.apvlno_dar)) {
	            				matchIndex=i;
	            				break;
	            			}
	            		}
	            		cboDARObj.SetSelectIndex(matchIndex);
	            	}
	            	else {
	            		cboDARObj.SetSelectIndex(0);
	            	}
	            	isSettingValue=false;
            	}
			break;
			
			case IBSEARCH_DAR_CHECK:
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		SEARCH01);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
	            darList=handleNullString(ComGetEtcData(sXml, "DAR"));
	            if (darList != ""){
	            	ComSetObjValue(formObj.dar_no_check, "Y");
	            }else{
	            	ComSetObjValue(formObj.dar_no_check, "N");
	            }
			break;
			
			case IBSEARCH_VER:
				ComSetObjValue(formObj.rfa_expt_dar_no, ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComClearCombo(formObj.version);
	            verList=handleNullString(ComGetEtcData(sXml, "VER"));
				if (verList != "") {
					addComboItem(formObj.version, 	verList, 	false);
					if (ComGetObjValue(formObj.apvlno_ver) != "") {
						matchIndex=-1;
						for (var i=0 ; i < formObj.version.length ; i++) {
							if (formObj.version.options[i].text == ComGetObjValue(formObj.apvlno_ver)) { 
								matchIndex=i;
								break;
							}
						}
						formObj.version.selectedIndex=matchIndex;
					}
				}
				else {
					addComboItem(formObj.version, 	"001=", 	true);
				}
			break;
			
			case IBSEARCH_VER_CHECK:	
				ComSetObjValue(formObj.rfa_expt_dar_no, ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
				//*********************************************************************************
				//ComOpenWait(true);
				//sheetObj.WaitImageVisible = false;
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
	            verList=handleNullString(ComGetEtcData(sXml, "VER"));
				var val=getMaxVersion(verList);
				if(val == undefined) {
					ComSetObjValue(formObj.max_ver, "001"); 
				}else{
					ComSetObjValue(formObj.max_ver, val);
				}
				var val2=getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
			break;
			
			case IBSEARCH_ACTCUST:	
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		SEARCH03);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
	            var comboDatas=ComGetEtcData(sXml, "CUST");
				if (ComTrim(comboDatas).length > 0)  {
					isActualCustomer=true;
				} else {
					isActualCustomer=false;
				}
				addCellComboItem(sheetObj,comboDatas,CUST_CD,false);
			break;
			
			case IBSEARCH_COMM:
				ComSetObjValue(formObj.f_cmd, 				SEARCH06);
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				sheetObj.RemoveAll();
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml,{Sync:1} );
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.comment, sheetObj.GetCellValue(sheetObj.HeaderRows(), PROG_RMK));
			break;
			
			case IBSEARCH_APRO:
				ComSetObjValue(formObj.f_cmd, 				SEARCH11);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				apvlList=handleNullString(ComGetEtcData(sXml, "APRO"));
				cboAPVLObj.RemoveAll();
				if (apvlList != "") {
					addMultiComboItem(cboAPVLObj, apvlList.split(ROWMARK));
					if (cboAPVLObj.GetItemCount() > 0) {
						isSettingValue=true;
						cboAPVLObj.SetSelectIndex(0);
						isSettingValue=false;
					}
				}				
			break;							
			
			case IBSEARCH_RFANO_CUST:
				ComSetObjValue(formObj.f_cmd, 	SEARCH14);
				ComSetObjValue(formObj.prop_no, ComGetObjValue(formObj.proposalNo));
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.custCd,		ComGetEtcData(sXml, "CUST_CD")); 	//CUST_CNT_CD + CUST_SEQ(6자리)
	            ComSetObjValue(formObj.custNm, 		ComGetEtcData(sXml, "CUST_NM"));
	            ComSetObjValue(formObj.custSeq, 	ComGetEtcData(sXml, "CUST_SEQ")); 	//CUST_SEQ
	            ComSetObjValue(formObj.rFANo, 		ComGetEtcData(sXml, "RFA_NO"));
			break;
			
	        case IBSEARCH_CHECK_DUP:
	        	with(sheetObj) {
					ComSetObjValue(formObj.rfa_expt_dar_no, 	GetCellValue(GetSelectRow(), DAR_NO));
					ComSetObjValue(formObj.rfa_expt_mapg_seq, 	GetCellValue(GetSelectRow(), MAPG_SEQ));
					ComSetObjValue(formObj.rfa_expt_ver_seq, 	GetCellValue(GetSelectRow(), VER_SEQ));
					ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	GetCellValue(GetSelectRow(), DTL_SEQ));
					ComSetObjValue(formObj.dmdt_trf_cd,			GetCellValue(GetSelectRow(), TARIFF));
					ComSetObjValue(formObj.eff_dt,				GetCellValue(GetSelectRow(), EFF_DT));
					ComSetObjValue(formObj.exp_dt,				GetCellValue(GetSelectRow(), EXP_DT));
					var cntrCgoArr=GetCellValue(GetSelectRow(), CNTRCGO).split(":");
					ComSetObjValue(formObj.dmdt_cntr_tp_cd,		cntrCgoArr[0]);
					ComSetObjValue(formObj.dmdt_cgo_tp_cd,		cntrCgoArr[1]);
					ComSetObjValue(formObj.cvrg_cnt_cd,			GetCellValue(GetSelectRow(), CVRG_CNT));
					if (GetCellValue(GetSelectRow(), CVRG_CNT) == "CA" || GetCellValue(GetSelectRow(), CVRG_CNT) == "US") {
						ComSetObjValue(formObj.cvrg_rgn_cd,		"");
						ComSetObjValue(formObj.cvrg_ste_cd,		GetCellValue(GetSelectRow(), CVRG_RGN));
					}
					else {
						ComSetObjValue(formObj.cvrg_rgn_cd,		GetCellValue(GetSelectRow(), CVRG_RGN));
						ComSetObjValue(formObj.cvrg_ste_cd,		"");
					}
					ComSetObjValue(formObj.cvrg_loc_cd,			GetCellValue(GetSelectRow(), CVRG_LOC));
					ComSetObjValue(formObj.fnl_dest_cnt_cd,		GetCellValue(GetSelectRow(), BKGDEL_CNT));
					if (GetCellValue(GetSelectRow(), BKGDEL_CNT) == "CA" || GetCellValue(GetSelectRow(), BKGDEL_CNT) == "US") {
						ComSetObjValue(formObj.fnl_dest_rgn_cd,	"");
						ComSetObjValue(formObj.fnl_dest_ste_cd,	GetCellValue(GetSelectRow(), BKGDEL_RGN));
					}
					else {
						ComSetObjValue(formObj.fnl_dest_rgn_cd,	GetCellValue(GetSelectRow(), BKGDEL_RGN));
						ComSetObjValue(formObj.fnl_dest_ste_cd,	"");
					}
					ComSetObjValue(formObj.fnl_dest_loc_cd,		GetCellValue(GetSelectRow(), BKGDEL_LOC));
					ComSetObjValue(formObj.act_cust_cnt_cd,		GetCellValue(GetSelectRow(), CUST_CD).substring(0, 2));
					ComSetObjValue(formObj.act_cust_seq,		GetCellValue(GetSelectRow(), CUST_CD).substring(2));
				}

	      		var cmdtList="";
	      		with(sheetCMDTObj) {
	      			for (var row=HeaderRows(); row <= LastRow(); row++) {
	      				if (GetRowStatus(row) == "D") continue;
	      				cmdtList		+= GetCellValue(row, CMDT_CD);
	      				if (row < LastRow()) cmdtList	+= "|";
	      			}
	      		}
	      		ComSetObjValue(formObj.cmdt_list, 		cmdtList);
	      		
				ComSetObjValue(formObj.f_cmd, 			SEARCH17);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.result, handleNullString(ComGetEtcData(sXml, "RESULT")));
	        break;
	        
			case IBSEARCH_CALC:
				ComSetObjValue(formObj.f_cmd, SEARCH06);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
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
			
			case IBSEARCH_DUAL:
				ComSetObjValue(formObj.f_cmd, SEARCH07);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
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
			
			case IBSEARCH_CHKCONTI:
				ComSetObjValue(formObj.f_cmd, SEARCH08);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
	            var comboDatas=ComGetEtcData(sXml, "EQUAL");
				ComSetObjValue(formObj.result, comboDatas);					
			break;
			
			case IBSEARCH_RFATARIFF_APVLNO:
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.rfa_expt_apro_no, 	ComTrim(cboAPVLObj.GetSelectText()));
				ComSetObjValue(formObj.f_cmd, 				SEARCH18);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
	            ComSetObjValue(formObj.apvlno_ofc, handleNullString(ComGetEtcData(sXml, "APVL_OFC")));
	            ComSetObjValue(formObj.apvlno_dar, handleNullString(ComGetEtcData(sXml, "DAR")));
	            ComSetObjValue(formObj.apvlno_ver, handleNullString(ComGetEtcData(sXml, "VER")));
			break;
			
			case IBSAVE_RFATARIFF:        
				ComSetObjValue(formObj.f_cmd, 				MULTI);
				ComSetObjValue(formObj.cust_cnt_cd,			ComGetObjValue(formObj.custCd).substring(0, 2));
				ComSetObjValue(formObj.cust_seq,			ComGetObjValue(formObj.custCd).substring(2));
				ComSetObjValue(formObj.prog_rmk,			ComGetObjValue(formObj.comment));
				
				//[2016.01.04] NYK Add. Detail 변동없이 하위만 변경되었을시 Key 값을 넘겨야 한다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.GetCellValue(sheetObj.GetSelectRow(), DTL_SEQ));
				ComSetObjValue(formObj.cvrg_cmb_seq, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_SEQ));
				
				
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString();
				var sParam2=sheetObjects[1].GetSaveString();
				var sParam3=sheetObjects[2].GetSaveString();
				
				//[2016.01.04] NYK Add.
				var sParam4=sheetObjects[3].GetSaveString(); //Tiered Free Time
				var sParam5=sheetObjects[4].GetSaveString(true);//Commodity : all delete -> all insert.
				
				if (sheetObjects[0].IsDataModified()== true) {
					sParam1=ComSetPrifix(sParam1, "subBKGREQDTL");
					sParam=sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified()== true) {
					sParam2=ComSetPrifix(sParam2, "subORGDEST");
					sParam=sParam + sParam2 + "&";
				}
				if (sheetObjects[2].IsDataModified()== true) {
					sParam3=ComSetPrifix(sParam3, "subRT");
					sParam=sParam + sParam3 + "&";
				}
				
				//[2016.01.04] NYK Add.
				if (sheetObjects[3].IsDataModified()== true) {
					sParam4=ComSetPrifix(sParam4, "subFT");
					sParam=sParam + sParam4 + "&";
				}
				//[2016.01.04] NYK Add.
				if (sheetObjects[4].IsDataModified()== true) {
					sParam5=ComSetPrifix(sParam5, "subCM");
					sParam=sParam + sParam5 + "&";
				}
				
				sParam += "&" + FormQueryString(formObj);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSaveData("EES_DMT_2003GS.do", sParam);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
					var darList=handleNullString(ComGetEtcData(sXml, "DAR"));
		            if (darList != "") {
		            	addMultiComboItem(cboDARObj, darList.split(ROWMARK));
		            	if (cboDARObj.GetItemCount() > 0) {
			            	isSettingValue=true;
			            	cboDARObj.SetSelectIndex(0);
			            	isSettingValue=false;
			            	sheetObj.SetCellValue(sheetObj.GetSelectRow(), DAR_NO,cboDARObj.GetSelectText(),0);
		            	}
		            }
					var dtlSeq=handleNullString(ComGetEtcData(sXml, "DTL_SEQ"));
					if (sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "I") {
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), DTL_SEQ,dtlSeq,0);
					}
					//======================================================================================					
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
            break;
            
			case IBSAVE_RFATARIFF_UPDATE:
				ComSetObjValue(formObj.f_cmd, 					MULTI02);
				ComSetObjValue(formObj.rfa_expt_dar_no,			sheetObj.GetCellValue(sheetObj.HeaderRows(), DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq,		sheetObj.GetCellValue(sheetObj.HeaderRows(), MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_prev_ver_seq, 	sheetObj.GetCellValue(sheetObj.HeaderRows(), VER_SEQ));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"T");
				ComSetObjValue(formObj.prop_no,					ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.apro_ofc_cd, 			ComGetObjValue(formObj.approvalOfcCd));
				ComSetObjValue(formObj.cust_cnt_cd,				ComGetObjValue(formObj.custCd).substring(0, 2));
				ComSetObjValue(formObj.cust_seq,				ComGetObjValue(formObj.custCd).substring(2));
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
            break;
            
			case IBSAVE_RFATARIFF_HISTORY:
				ComSetObjValue(formObj.f_cmd, 					MULTI03);
				ComSetObjValue(formObj.rfa_expt_dar_no, 		cboDARObj.GetSelectText());
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"T");
				ComSetObjValue(formObj.prop_no,					ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.apro_ofc_cd, 			ComGetObjValue(formObj.approvalOfcCd));				
				ComSetObjValue(formObj.cust_cnt_cd,				ComGetObjValue(formObj.custCd).substring(0, 2));
				ComSetObjValue(formObj.cust_seq,				ComGetObjValue(formObj.custCd).substring(2));				
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
			break;
			
			case IBSAVE_VERSTS:
				ComSetObjValue(formObj.f_cmd, SEARCH10);
				ComSetObjValue(formObj.prop_no, ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
			break;
			
			case IBSAVE_DAR:
				ComSetObjValue(formObj.f_cmd, SEARCH05);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
	            var result=ComGetEtcData(sXml, "DAR");
				ComSetObjValue(formObj.result, result);
			break;
			
			case IBSAVE_REQUEST:
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"R");				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 				
				ComSetObjValue(formObj.f_cmd, 					SEARCH06);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
			
			case IBSAVE_CANCEL:
				ComSetObjValue(formObj.rfa_expt_dar_no, 		cboDARObj.GetSelectText());
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"C");				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 				
				ComSetObjValue(formObj.f_cmd, 					SEARCH07);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
			
			case IBSAVE_APPROVAL:
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"A");
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Approved");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		ComTrim(cboAPVLObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.f_cmd, 					SEARCH08);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}							
			break;
			
			case IBSAVE_COUNTER:
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"O");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Counter Offered");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.f_cmd, 					SEARCH09);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
			
			case IBSAVE_REJECT:
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"J");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Rejected");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.f_cmd, 					SEARCH10);
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}							
			break;
			
			case IBDELETE_RFATARIFF:
				ComSetObjValue(formObj.rfa_expt_dar_no, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 		sheetObj.GetCellValue(sheetObj.GetSelectRow(), DTL_SEQ));
				//ComSetObjValue(formObj.cvrg_cmb_seq, 			sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_SEQ));
				ComSetObjValue(formObj.f_cmd, 					MULTI01);	
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
			break;	
			
	   		case IBSEARCH_ASYNC01:         // [2016.01.04] NYK Add Search
	   			formObj.f_cmd.value=COMMAND15;
	   			var selRow=sheetObj.GetSelectRow();
	   			var param="f_cmd=" + COMMAND15 + "&cmdt_cd=" + sheetObj.GetCellText(sheetObj.GetSelectRow(), "cmdt_cd");
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
    
	function doActionIBCommon(sheetObj, formObj, sAction, sComboAction, sComboKey, sSetParameter) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		selectedRow=sheetObj.GetSelectRow();
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			selectedRow=ComGetObjValue(formObj.select_row);
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        switch(sAction) {
        	case IBSEARCH:
				if (sSetParameter == undefined) sSetParameter=true;
				if (sSetParameter) {
					setComboParameters(sheetObj, sComboAction, sComboKey);
				}
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
 				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var comboDatas;
				switch(sComboAction) {
					case SEARCHLIST:
						comboDatas=handleNullString(ComGetEtcData(sXml, "common_tariff_cd"));
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;
					case SEARCH11:											
						comboDatas=handleNullString(ComGetEtcData(sXml, "CONTR_CGO"));
						comboDatas=comboDatas.replace("All=All^All|", "");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false,false);
						break;
					case SEARCH08:
						comboDatas=handleNullString(ComGetEtcData(sXml, "CONTI"));
						addCellComboItem(sheetObjects[0],comboDatas,sComboKey,false);
						addCellComboItem(sheetObjects[1],comboDatas,sComboKey,false);
						break;
					case SEARCH02:
						comboDatas=handleNullString(ComGetEtcData(sXml, "CNT"));
						if (sComboKey == "ALL") {
							addCellComboItem(sheetObjects[0],comboDatas,"cvrg_cnt_cd",false);
							addCellComboItem(sheetObjects[0],comboDatas,"org_dest_cnt_cd",false);
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_cnt_cd",false);
							addCellComboItem(sheetObjects[1],comboDatas,"org_dest_cnt_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
					case SEARCH01:
						comboDatas=handleNullString(ComGetEtcData(sXml, "RGN"));
						if (sComboKey == "ALL") {
							addCellComboItem(sheetObjects[0],comboDatas,"cvrg_rgn_cd",false);
							addCellComboItem(sheetObjects[0],comboDatas,"org_dest_rgn_cd",false);
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_rgn_cd",false);
							addCellComboItem(sheetObjects[1],comboDatas,"org_dest_rgn_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
					case SEARCH03:
						sComboKey=sComboKey.split(ROWMARK);
						var cntCd=sheetObj.GetCellValue(selectedRow, sComboKey[0]);
						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
							comboDatas=handleNullString(ComGetEtcData(sXml, "STE"));
						} 
						else {
							comboDatas=handleNullString(ComGetEtcData(sXml, "RGN"));
						}
						if (comboDatas == "") {
							ComShowCodeMessage("DMT00110", "Country");
							sheetObj.SetCellValue(selectedRow, sComboKey[0],"");
							return;
						} 
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey[1],true);
						}	
						break;
					case SEARCH04:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=handleNullString(ComGetEtcData(sXml, "CNT"));
						if (comboDatas != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							if (sheetObj.id == "sheet1") selectedRow=sheetObj.GetSelectRow();
							var cntCd=ComTrim(sheetObj.GetCellValue(selectedRow, sComboKey[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=handleNullString(ComGetEtcData(sXml, "STE"));
								} else {
									comboDatas=handleNullString(ComGetEtcData(sXml, "RGN"));
								}
								setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.SetCellValue(selectedRow, sComboKey[2],"",0);
						}
						break;
					case SEARCH06:
						comboDatas=handleNullString(ComGetEtcData(sXml, "CNT"));
						if (comboDatas != "") {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						} 
						else {
							ComShowCodeMessage("DMT00110", "Continent");
							sheetObj.SetCellValue(selectedRow, ORGDST_CTI,"");
							isValueSettingEvent=true;
							sheetObj.SetCellValue(selectedRow, ORGDST_CNT,"");
							isValueSettingEvent=false;
						}
						break;
					case SEARCH10:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=handleNullString(ComGetEtcData(sXml, "CONTI"));
						if (comboDatas != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							comboDatas=handleNullString(ComGetEtcData(sXml, "CNT"));
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							var cntCd=sheetObj.GetCellValue(selectedRow, sComboKey[1]);
							if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
								comboDatas=ComGetEtcData(sXml, "STE");
							} 
							else {
								comboDatas=ComGetEtcData(sXml, "RGN");
							}
							setCellComboItem(sheetObj, comboDatas, sComboKey[2], selectedRow);
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.SetCellValue(selectedRow, sComboKey[3],"",0);
						}
						break;
					case SEARCH12:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=handleNullString(ComGetEtcData(sXml, "CONTI"));
						if (comboDatas != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							if (sComboKey[0] == "org_dest_conti_cd") {
								comboDatas=ComGetEtcData(sXml, "CNT");
								setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							}
						}
						break;
					case SEARCH13:
					case SEARCH17:
						sComboKey=sComboKey.split(ROWMARK);
						comboDatas=handleNullString(ComGetEtcData(sXml, "CONTI"));
						if (comboDatas != "") {						
							if (ComTrim(sComboKey[0]) != "") {
								setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							}
							comboDatas=handleNullString(ComGetEtcData(sXml, "CNT"));
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							var cntCd=ComTrim(sheetObj.GetCellValue(selectedRow, sComboKey[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=handleNullString(ComGetEtcData(sXml, "STE"));
								} 
								else {
									comboDatas=handleNullString(ComGetEtcData(sXml, "RGN"));
								}
								setCellComboItem(sheetObj, comboDatas, sComboKey[2], selectedRow);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							sheetObj.SetCellValue(selectedRow, sComboKey[2],"",0);
						}
						break;
					case COMMAND05:
						comboDatas=handleNullString(ComGetEtcData(sXml, sComboKey));
						comboDatas="=|" + comboDatas;
						addComboItem(formObj.currency,comboDatas,true);
						break;	
				};
				break;
        }
		sheetObj.SetWaitImageVisible(1);
    }	
    /**	
     * Select the combo in our grid allows data in the field.
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
     * Our grid data in the field adds a combo.
     */		
	function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
     	var formObj=document.form;
		var comboItems;
		var comboItem;
		var comboTxt="";
		var comboVal="";		
		var comboInitTxt="";
		var comboInitVal="";
		sRow=sheetObj.GetSelectRow();
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			sRow=ComGetObjValue(formObj.select_row);
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems=comboDatas.split(ROWMARK);
			for (var i=0 ; i < comboItems.length ; i++) {
				comboItem=comboItems[i].split(FIELDMARK);
				if (!isCellCombo && i == 0) {
					comboInitTxt=comboItem[0];
					comboInitVal=comboItem[0];
				}
				if (ComTrim(comboItem[0]) != "") {
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					}
					else if (comboItem[1].indexOf("\^") != -1) {
						comboTxt += comboItem[1].replace("^", " - ");
					}
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
      * Data in the field adds a multi-combo.
      */	
 	function addMultiComboItem(comboObj, comboItems) {
     	for (var i=0 ; i < comboItems.length ; i++) {
     		var comboItem=comboItems[i].split(FIELDMARK);
 			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
     	}
 	}     
	/**
 	 * Max Version 
 	 * The result is returned by query.
 	 */
	function getMaxVersion(versions) {
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
		return val; 
	}
	/**
 	 * Max Version Status 
 	 * The result is returned by query
 	 */
	function getMaxVersionStatus(versions) {
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
		if (val.indexOf(":") != -1) {
			var stsArr=val.split(":");
			val=stsArr[0]; 
		}
		return val;
	}
	function setMandatoryRTAdjust(selectedRow) {
    	var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[2];
		var tariff=sheetRFAObj.GetCellValue(selectedRow, TARIFF);
		if (tariff == "CTIC" || tariff == "CTOC") {
			var isMandatory="N";
			doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
			if (ComTrim(ComGetObjValue(formObj.result)) == "M") {
				isMandatory="Y";
			}
			sheetRFAObj.SetCellValue(selectedRow, RT_MANDATORY,isMandatory);
		} 
		else {
			sheetRFAObj.SetCellValue(selectedRow, RT_MANDATORY,"N");
		}
	}
	function searchCurrencyList(selectedRow) {
    	var formObj=document.form;
    	var sheetRFAObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[2];
		if (ComTrim(sheetRFAObj.GetCellValue(selectedRow, CVRG_CNT)) != "") {
			doActionIBCommon(sheetRTObj, formObj, IBSEARCH, COMMAND05, "CURRENCY");
		}
	}
	function getOriginOrDestinationCNT(selectRow) {
		var sheetObj=sheetObjects[0];
		var sheetObj1=sheetObjects[1];
		var cntCd="";
		if (sheetObj.GetCellValue(selectRow, ORGDST_MULTI) == "S") {
			cntCd=ComTrim(sheetObj.GetCellValue(selectRow, ORGDST_CNT));
		}
		else if (fetchRowCount(selectRow, sheetObj1) > 0) {
			cntCd=ComTrim(sheetObj1.GetCellValue(sheetObj1.HeaderRows(), ORGDST_CNT))
		}
		return cntCd;	
	}
	function setCurrencyVal() {
    	 var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
			SetCellValue(GetSelectRow(), CURR_CD, ComTrim(ComGetObjValue(formObj.currency)), 0);
		}
	}
	function setComboParameters(sheetObj, sAction, sComboKey) {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		ComSetObjValue(formObj.f_cmd, sAction);			//Command
		with(sheetObj) {
			if (sComboKey.indexOf("fnl") != -1 && GetSelectRow()>= HeaderRows()) {
				ComSetObjValue(formObj.conti_cd, 	"");
				ComSetObjValue(formObj.cnt_cd, 		GetCellValue(GetSelectRow(), BKGDEL_CNT));		//BKG DEL(I) or POR(O) CN
				rgnCd=ComTrim(GetCellValue(GetSelectRow(), BKGDEL_RGN));
				if (rgnCd.length == 2) 
					ComSetObjValue(formObj.ste_cd, rgnCd);		//BKG DEL(I) or POR(O) STE
				else 
					ComSetObjValue(formObj.rgn_cd, rgnCd);		//BKG DEL(I) or POR(O) RGN				
				ComSetObjValue(formObj.loc_cd, 		GetCellValue(GetSelectRow(), BKGDEL_LOC));		//BKG DEL(I) or POR(O) LOC
			}
			else if (sComboKey.indexOf("org") != -1 && GetSelectRow()>= HeaderRows()) {
				ComSetObjValue(formObj.conti_cd, 	GetCellValue(GetSelectRow(), ORGDST_CTI));		//Origin(I) or Dest.(O) CT
				ComSetObjValue(formObj.cnt_cd, 		GetCellValue(GetSelectRow(), ORGDST_CNT));		//Origin(I) or Dest.(O) CN
				rgnCd=ComTrim(GetCellValue(GetSelectRow(), ORGDST_RGN));
				if (rgnCd.length == 2) 
					ComSetObjValue(formObj.ste_cd, rgnCd);		//Origin(I) or Dest.(O) STE
				else 
					ComSetObjValue(formObj.rgn_cd, rgnCd);		//Origin(I) or Dest.(O) RGN				
				ComSetObjValue(formObj.loc_cd, 		GetCellValue(GetSelectRow(), ORGDST_LOC));		//Origin(I) or Dest.(O) LOC
			}
			else if (sComboKey == "CURRENCY" && sheetRFAObj.GetSelectRow()>= sheetRFAObj.HeaderRows()) {
				ComSetObjValue(formObj.cnt_cd, 		sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CNT));
			}
			else if (GetSelectRow()>= HeaderRows()) {
				ComSetObjValue(formObj.conti_cd, 	"");
				ComSetObjValue(formObj.cnt_cd, 		GetCellValue(GetSelectRow(), CVRG_CNT));		//Coverage CN
				rgnCd=ComTrim(GetCellValue(GetSelectRow(), CVRG_RGN));
				if (rgnCd.length == 2) 
					ComSetObjValue(formObj.ste_cd, rgnCd);		//Coverage STE
				else 
					ComSetObjValue(formObj.rgn_cd, rgnCd);		//Coverage RGN		
				ComSetObjValue(formObj.loc_cd, 		GetCellValue(GetSelectRow(), CVRG_LOC));		//Coverage LOC
			}
		}
	}
	
	function doActionRetrieve(sAction) {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var cboAPVLObj=comboObjects[1 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER);
		if (getVerStatus("Code") == "A") {
			ComSetObjValue(formObj.prop_no, 			"");
			ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.GetSelectText()));
			ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
			ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
		}
		else {
			cboAPVLObj.RemoveAll();
		}
		doActionRetrieveByVer(sAction);
	}
	
	function doActionRetrieveByVer(sAction) {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetRTObj=sheetObjects[2];
		var sheetHSTObj=sheetObjects[5];
		ComSetObjValue(formObj.status, getVerStatus("Text"));
		
		doActionIBSheet(sheetRFAObj, formObj, sAction);
		//--------------------------------------------------------------------
		currDtlSeq=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ);
		//--------------------------------------------------------------------
		if (sheetRFAObj.RowCount()> 0) {
			if ((getVerStatus("Code") == "T" || getVerStatus("Code") == "O") && ComGetObjValue(formObj.isEditable) == "Y")
				editableDetail(true);
			else
				editableDetail(false);
			setSubBeforeException(true);
		}
		else {
			if (ComGetObjValue(formObj.isEditable) == "Y")
				editableDetail(true);
			else
				editableDetail(false);
			
			sheetCVRGObj.RemoveAll();
			sheetRTObj.RemoveAll();
			sheetHSTObj.RemoveAll();
			setSubBeforeException(false);
		}
		initBtnControl();
		//동적으로 Sort 변경이 안되기 때문에, 기능패치가 이루어질때 까지는 임시적으로 Sheet 초기화시 Sort 기능을 차단함. 2014.08.26		
//		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
//			sheetRFAObj.InitHeadMode(false, false, false, false, false, false);
//		}
//		else {
//			sheetRFAObj.InitHeadMode(true, false, false, false, false, false);
//		}
	}
	
    function setSubBeforeException(isRetrieve) {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		if (isRetrieve) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_SUB);
		}
		setMultiOrgDestTitle();
		setMultiOrgDestGrid();
		setRateAdjustmentGrid();
		
		//[2016.01.04] NYK Add.
		setTieredFreeTimeGrid();
		setCommodityGrid();
	}
	function setMultiOrgDestGrid() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
			if (GetCellValue(GetSelectRow(), ORGDST_MULTI) == "M") {
				formObj.chkMultiOrgDest.checked=true;
				SetCellEditable(GetSelectRow(), ORGDST_CTI,0);
				SetCellEditable(GetSelectRow(), ORGDST_CNT,0);
				SetCellEditable(GetSelectRow(), ORGDST_RGN,0);
				SetCellEditable(GetSelectRow(), ORGDST_LOC,0);
				SetCellEditable(GetSelectRow(), ORGDST_POP,0);
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					editableMultiOrgDest(true);
				}
				else {
					editableMultiOrgDest(false);
				}
			}
			else {
				formObj.chkMultiOrgDest.checked=false;
				if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
					SetCellEditable(GetSelectRow(), ORGDST_CTI,1);
					SetCellEditable(GetSelectRow(), ORGDST_CNT,1);
					SetCellEditable(GetSelectRow(), ORGDST_RGN,1);
					SetCellEditable(GetSelectRow(), ORGDST_LOC,1);
					SetCellEditable(GetSelectRow(), ORGDST_POP,1);
				}
				else {
					SetCellEditable(GetSelectRow(), ORGDST_CTI,0);
					SetCellEditable(GetSelectRow(), ORGDST_CNT,0);
					SetCellEditable(GetSelectRow(), ORGDST_RGN,0);
					SetCellEditable(GetSelectRow(), ORGDST_LOC,0);
					SetCellEditable(GetSelectRow(), ORGDST_POP,0);
				}
				editableMultiOrgDest(false);	
			}
		}
	}
	function setRateAdjustmentGrid() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
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
	function setFreeTimeByMandatory(sheetObj, Row, Col) {
		with(sheetObj) {
			if (GetCellValue(Row, Col) == "1") {
				SetCellEditable(Row, ADD_DYS,1);
				SetCellEditable(Row, TOT_DYS,1);
				SetCellEditable(Row, SAT_FLG,1);
				SetCellEditable(Row, SUN_FLG,1);
				SetCellEditable(Row, HOL_FLG,1);
			}
			else {
				SetCellValue(Row, ADD_DYS,"");
				SetCellValue(Row, TOT_DYS,"");
				SetCellValue(Row, SAT_FLG,"");
				SetCellValue(Row, SUN_FLG,"");
				SetCellValue(Row, HOL_FLG,"");
				SetCellEditable(Row, ADD_DYS,0);
				SetCellEditable(Row, TOT_DYS,0);
				SetCellEditable(Row, SAT_FLG,0);
				SetCellEditable(Row, SUN_FLG,0);
				SetCellEditable(Row, HOL_FLG,0);
			}
		}
	}
	function doActionNew() {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var cboAPVLObj=comboObjects[1 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		enableSearchFields(true);
		initDisableObjects();
		ComSetObjValue(formObj.apro_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));		
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
		if (ComTrim(ComGetObjValue(formObj.proposalNo)) != "") {
			doActionRetrieve(IBSEARCH);
		}
		else {
			addComboItem(formObj.version, "001=", true);
			initBtnControl();
		}	
	}
	function doActionUpdate() {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var cboAPVLObj=comboObjects[1 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		var result=isApprovedInPrevVersion();
		if (result[0]) {
			if (!ComShowCodeConfirm("DMT01122", result[1])) { return; }	
		}
		else {
			if (!ComShowCodeConfirm("DMT00135", "update the version")) { return; }	
		}
		if (getVerStatus("Code") == "A" || getVerStatus("Code") == "J") {
			doActionIBSheet(sheetRFAObj, formObj, IBSAVE_RFATARIFF_UPDATE);
			if (ComGetObjValue(formObj.result) == "Y") {
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER);
				ComSetObjValue(formObj.status, getVerStatus("Text"));
				cboAPVLObj.RemoveAll();
				doActionRetrieve(IBSEARCH);
			}
			else {
				ComShowCodeMessage("DMT00008", "update");
				return;
			}
		}
		else {
			enableSearchFields(false);
			ComClearObject(formObj.status);	
			editableDetail(true);
			setSubBeforeException(false);
			ComBtnEnable(	"btn_New"			);
			ComBtnDisable(	"btn_Update"		);
			ComBtnEnable(	"btn_Request"		);
			ComBtnDisable(	"btn_Cancel"		);
			ComBtnDisable(	"btn_Approval"		);
			ComBtnDisable(	"btn_CounterOffer"	);
			ComBtnDisable(	"btn_Reject"		);
			ComBtnEnable(	"btn_Close"			);
		}
		
		//동적으로 Sort 변경이 안되기 때문에, 기능패치가 이루어질때 까지는 임시적으로 Sheet 초기화시 Sort 기능을 차단함. 2014.08.26	
//		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
//			sheetRFAObj.InitHeadMode(false, false, false, false, false, false);
//		}
//		else {
//			sheetRFAObj.InitHeadMode(true, false, false, false, false, false);
//		}
	}				
	function doActionRequest() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var cboDARObj=comboObjects[0 + plusComboCnt];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		if (ComTrim(cboDARObj.GetSelectText()) == "") {
			if(!doActionCheckByApprovalOfc()) {
				return;
			}
		}
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT01117", "request");
			return;
		}
		if (!validateComment()) return;
		var chkResult=isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				if (!saveBKGReqDetail(chkResult[0])) return;
			}
			else {
				return;
			}
		}
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_REQUEST);
		if (ComGetObjValue(formObj.result) == "Y") {
			enableSearchFields(true);
			doActionRetrieve(IBSEARCH);
		}	
	}
	function doActionCancel() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		if (!ComShowCodeConfirm("DMT00135", "cancel this version")) { return; }
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_CANCEL);
		if (ComGetObjValue(formObj.result) == "Y") {
			enableSearchFields(true);
			doActionRetrieve(IBSEARCH);
		}		
	}
	function doActionApproval() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		if (!ComShowCodeConfirm("DMT00135", "approve")) { return; }
		if (!validateComment()) return;
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_APPROVAL);
		if (ComGetObjValue(formObj.result) == "Y") {
			enableSearchFields(true);
			doActionRetrieve(IBSEARCH);		
		}		
	}
	function doActionCounterOffer() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		if (!ComShowCodeConfirm("DMT00135", "counter offer")) { return; }
		if (!validateComment()) return;
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_COUNTER);
		if (ComGetObjValue(formObj.result) == "Y") {
			enableSearchFields(true);
			doActionRetrieve(IBSEARCH);	
		}		
	}
	function doActionReject() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		if (!ComShowCodeConfirm("DMT00135", "reject")) { return; }
		if (!validateComment()) return;
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_REJECT);
		if (ComGetObjValue(formObj.result) == "Y") {
			enableSearchFields(true);
			doActionRetrieve(IBSEARCH);	
		}		
	}				
	function doActionClose() {
		var chkResult=isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT00147")) {
				ComClosePopup(); 
			}
			return;
		}
		ComClosePopup(); 
	}
	function setDarNoBKGReqDetail(darNo) {
		sheetObj=sheetObjects[0];
		setDarNoGridItem(darNo, sheetObj);
	}
	function setDarNoMultiOriginOrDestination(darNo) {
		sheetObj=sheetObjects[1];
		setDarNoGridItem(darNo, sheetObj);
	}
	function setDarNoRateAdjustment(darNo) {
		sheetObj=sheetObjects[2];
		setDarNoGridItem(darNo, sheetObj);
	}
	function setDarNoGridItem(darNo, sheetObj) {
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellValue(row, DAR_NO,darNo);
			}
		}
	}
	function copyBKGDetailReqCoverageforSave() {
		var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		with(sheetRFAObj) {
			var prevOrgDestMulti=ComTrim(GetCellValue(GetSelectRow(), CURR_ORGDST_MULTI));
			var currOrgDestMulti=ComTrim(GetCellValue(GetSelectRow(), ORGDST_MULTI));
		}		
		with(sheetCVRGObj) {
			if (prevOrgDestMulti == "S" && currOrgDestMulti == "S") {
				DataInsert(-1);
				SetRowHidden(LastRow(),1);
				SetCellValue(LastRow(), DAR_NO,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO),0);
				SetCellValue(LastRow(), MAPG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), MAPG_SEQ),0);
				SetCellValue(LastRow(), VER_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(LastRow(), DTL_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ),0);
				SetCellValue(LastRow(), CVRG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_SEQ),0);
				SetCellValue(LastRow(), CVRG_CTI,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CTI),0);
				SetCellValue(LastRow(), CVRG_CNT,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CNT),0);
				SetCellValue(LastRow(), CVRG_RGN,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_RGN),0);
				SetCellValue(LastRow(), CVRG_LOC,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_LOC),0);
				SetCellValue(LastRow(), ORGDST_CTI,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_CTI),0);
				SetCellValue(LastRow(), ORGDST_CNT,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_CNT),0);
				SetCellValue(LastRow(), ORGDST_RGN,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_RGN),0);
				SetCellValue(LastRow(), ORGDST_LOC,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_LOC),0);
				SetRowStatus(LastRow(),"U");
			}
			else if (prevOrgDestMulti == "S" && currOrgDestMulti == "M") {
				DataInsert(-1);
				SetRowStatus(LastRow(),"U");
				SetRowHidden(LastRow(),1);
				SetCellValue(LastRow(), DAR_NO,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO),0);
				SetCellValue(LastRow(), MAPG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), MAPG_SEQ),0);
				SetCellValue(LastRow(), VER_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(LastRow(), DTL_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ),0);
				SetCellValue(LastRow(), CVRG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_SEQ),0);
				SetRowStatus(LastRow(),"D");
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					SetCellValue(row, CVRG_CTI,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CTI),0);
					SetCellValue(row, CVRG_CNT,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CNT),0);
					SetCellValue(row, CVRG_RGN,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_RGN),0);
					SetCellValue(row, CVRG_LOC,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_LOC),0);
				}
			}
			else if ((prevOrgDestMulti == "M" || prevOrgDestMulti == "") && currOrgDestMulti == "S") {
				DataInsert(-1);
				SetRowHidden(LastRow(),1);
				SetCellValue(LastRow(), DAR_NO,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO),0);
				SetCellValue(LastRow(), MAPG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), MAPG_SEQ),0);
				SetCellValue(LastRow(), VER_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER_SEQ),0);
				SetCellValue(LastRow(), DTL_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ),0);
				SetCellValue(LastRow(), CVRG_SEQ,"1",0);
				SetCellValue(LastRow(), CVRG_CTI,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CTI),0);
				SetCellValue(LastRow(), CVRG_CNT,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CNT),0);
				SetCellValue(LastRow(), CVRG_RGN,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_RGN),0);
				SetCellValue(LastRow(), CVRG_LOC,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_LOC),0);
				SetCellValue(LastRow(), ORGDST_CTI,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_CTI),0);
				SetCellValue(LastRow(), ORGDST_CNT,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_CNT),0);
				SetCellValue(LastRow(), ORGDST_RGN,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_RGN),0);
				SetCellValue(LastRow(), ORGDST_LOC,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_LOC),0);
				SetRowStatus(LastRow(),"I");
			}
			else if ((prevOrgDestMulti == "M" || prevOrgDestMulti == "") && currOrgDestMulti == "M") {
				for (var subRow=HeaderRows(); subRow <= LastRow(); subRow++) {
					SetCellValue(subRow, CVRG_CTI,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CTI),0);
					SetCellValue(subRow, CVRG_CNT,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_CNT),0);
					SetCellValue(subRow, CVRG_RGN,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_RGN),0);
					SetCellValue(subRow, CVRG_LOC,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_LOC),0);
				}
			}			
		}
	}
	function releaseBKGDetailReqCoverageforSave() {
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
     * Screen input form validation process for handling
     */	 
	function validateForm(reqType) {
    	var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetRTObj=sheetObjects[2];

		var sheetFTObj=sheetObjects[3];
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT00128");
			return false;
		}		
		with(sheetRFAObj) {
			var chkResult=isChangedBeforeException(1); 
			if (GetRowStatus(GetSelectRow()) == "I" || GetRowStatus(GetSelectRow()) == "U" || chkResult[0]) {
				//==================================================================================================
				//1.APVL OFC Check
				//==================================================================================================
				if (ComTrim(ComGetObjValue(formObj.approvalOfcCd)) == "") {
					ComShowCodeMessage("DMT02002", "APVL OFC");
					ComSetFocus(comboObjects[0]);
					return false;			
				}
				//==================================================================================================
				//2-1.EFF DT Check
				//==================================================================================================		
				if (GetCellValue(GetSelectRow(), EFF_DT) == "") {
					ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "EFF DT");
					return false;
				}
				//==================================================================================================
				//2-2.EXP DT Check
				//==================================================================================================
				if (GetCellValue(GetSelectRow(), EXP_DT) == "") {
					ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "EXP DT");
					return false;
				}
				if (ComGetDaysBetween(GetCellValue(GetSelectRow(), EXP_DT), GetCellValue(GetSelectRow(), EFF_DT)) > 0) {
	    			ComShowCodeMessage("COM12133", "'EFF DT'", "'EXP DT'", "earlier");
	    			return false;	    			
	    		}				
				//==================================================================================================
				//3.CNTR/Cargo Type Check
				//==================================================================================================				
				if (GetCellValue(GetSelectRow(), CNTRCGO) == "") {
					ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "CNTR/Cargo Type");
					return false;
				}
				//==================================================================================================
				//4.Coverage Check
				//==================================================================================================
				if (GetCellValue(GetSelectRow(), CVRG_CNT) == "") {
					ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Coverage CN");
					return false;
				}

				//==================================================================================================
				//[2016.01.04] NYK Add
				//5.Free Time Validation Check
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
				//5.Free Time Check
				//==================================================================================================
				/*if (GetCellValue(GetSelectRow(), FT_FLG) == 1) {
					if (GetCellValue(GetSelectRow(), ADD_DYS) != "" && GetCellValue(GetSelectRow(), TOT_DYS) != "") {
						ComShowCodeMessage("DMT02004", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					} 
					else if (GetCellValue(GetSelectRow(), ADD_DYS) == "" && GetCellValue(GetSelectRow(), TOT_DYS) == "") {
						ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Free Time");
						return false;						
					}
				}
				else {
					if (GetCellValue(GetSelectRow(), RT_CHECK) == "N") {
						ComShowCodeMessage("DMT02028", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					}
				}*/
				//==================================================================================================
				//6.Origin(I) or Dest.(O) Validate Check
				//==================================================================================================				
				if (GetCellValue(GetSelectRow(), ORGDST_MULTI) == "S") {
					if (ComTrim(GetCellValue(GetSelectRow(), ORGDST_CTI)) == "") {
						ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Origin(I) or Dest.(O)");
						return false;						
					}
					if (GetCellValue(GetSelectRow(), CVRG_CNT) == GetCellValue(GetSelectRow(), ORGDST_CNT)) {
						ComShowCodeMessage("DMT01144", GetCellValue(GetSelectRow(), TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
						return false;
					}
				}
				else if (GetCellValue(GetSelectRow(), ORGDST_MULTI) == "M") {
					for (var row=sheetCVRGObj.HeaderRows(); row <= sheetCVRGObj.LastRow(); row++) {
						if (sheetCVRGObj.GetCellValue(row, ORGDST_CTI) == "") {
							ComShowCodeMessage("DMT00108", GetCellValue(GetSelectRow(), "Seq"), "Continent");
							return false;
						}
						if (GetCellValue(GetSelectRow(), CVRG_CNT) == sheetCVRGObj.GetCellValue(row, ORGDST_CNT)) {
							ComShowCodeMessage("DMT01144", GetCellValue(GetSelectRow(), TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
							return false;
						}							
					}
					if (fetchRowCount(sheetCVRGObj) < 2) {
						ComShowCodeMessage("DMT00115", GetCellValue(GetSelectRow(), "Seq"), "Multi Origin or Destination");
						return false;
					}
				}
				if (GetCellValue(GetSelectRow(), RT_MANDATORY) == "Y") {
					if (GetCellValue(GetSelectRow(), ADD_DYS) != "" && GetCellValue(GetSelectRow(), TOT_DYS) == "") {
						ComShowCodeMessage("DMT00113", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					}
					else if (GetCellValue(GetSelectRow(), TOT_DYS) == "") {
						ComShowCodeMessage("DMT00152", GetCellValue(GetSelectRow(), "Seq"));
						return false;
					}
				}
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
				//9.Calculation Type Check
				//==================================================================================================
				if (!validateCalculationType(GetSelectRow()))
					return false;
				if (!validateCalculationTypeInDM(GetSelectRow()))
					return false;
			}
		}
		if (dupValidate()) return false;	
		return true;
	}
    function dupValidate() {
   		var formObj=document.form;
   		var sheetRFAObj=sheetObjects[0];
   		var sheetCVRGObj=sheetObjects[1];
   		var coverageList="";
   		if (sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), ORGDST_MULTI) == "S") {
   			with(sheetRFAObj) {
   				coverageList 	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), ORGDST_CTI));
 	  			coverageList  	+= ", ";   				
 	  			coverageList 	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), ORGDST_CNT));
 	  			coverageList  	+= ", ";
 	  			if (GetCellValue(GetSelectRow(), ORGDST_CNT) == "CA" || GetCellValue(GetSelectRow(), ORGDST_CNT) == "US") {
 	  				coverageList  	+= "' '";
 		  			coverageList  	+= ", ";
 		  			coverageList  	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), ORGDST_RGN));
 	  			}
 	  			else {
 	  				coverageList  	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), ORGDST_RGN));
 		  			coverageList  	+= ", ";
 	  				coverageList  	+= "' '";
 	  			}
   		  		coverageList	+= ", ";	 			
   		  		coverageList  	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), ORGDST_LOC));
   			}
   		}
   		else {
   			with(sheetCVRGObj) {
   				for (var row=HeaderRows(); row <= LastRow(); row++) {
   					if (GetRowStatus(row) == "D") continue;
   					coverageList 	+= convertEmptyToSpace(GetCellValue(GetSelectRow(), ORGDST_CTI));
   	 	  			coverageList  	+= ", ";     					
   	 	  			coverageList 	+= convertEmptyToSpace(GetCellValue(row, ORGDST_CNT));
   		  			coverageList	+= ", ";
   		  			if (GetCellValue(row, ORGDST_CNT) == "CA" || GetCellValue(row, ORGDST_CNT) == "US") {
 		  				coverageList  	+= "' '";
 			  			coverageList  	+= ", ";
 			  			coverageList  	+= convertEmptyToSpace(GetCellValue(row, ORGDST_RGN));
 	  		  		}
 	  		  		else {
 	  		  			coverageList  	+= convertEmptyToSpace(GetCellValue(row, ORGDST_RGN));
 			  			coverageList  	+= ", ";
 		  				coverageList  	+= "' '";
 	  		  		}
   		  			coverageList	+= ", ";  		  			
   		  			coverageList	+= convertEmptyToSpace(GetCellValue(row, ORGDST_LOC));
   		  			if (row < LastRow()) coverageList	+= "|";
   				}
   			}
   		}
   		ComSetObjValue(formObj.coverage_list, 	coverageList);
     	doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_CHECK_DUP);
     	if (ComGetObjValue(formObj.result) == "Y") {
     		ComShowCodeMessage("DMT00138", sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), "Seq"));
     		return true;
     	}
       	return false;
 	}     
	function validateCalculationType(selectedRow) {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[2];
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		var tariff=sheetRFAObj.GetCellValue(selectedRow, TARIFF);
		var params="";
		params=changeNullToSpace(sheetRFAObj.GetCellValue(selectedRow, CVRG_CNT));
		params=params + "=" + changeNullToSpace(sheetRFAObj.GetCellValue(selectedRow, CVRG_RGN));
		params=params + "=" + changeNullToSpace(sheetRFAObj.GetCellValue(selectedRow, CVRG_LOC));
		params += "|";
		params += tariff;
		params += "|";
		params += sheetRFAObj.GetCellValue(selectedRow, EFF_DT);
		params += "|";
		params += sheetRFAObj.GetCellValue(selectedRow, EXP_DT);
		params += "|";
		params += sheetRFAObj.GetCellValue(selectedRow, CNTRCGO);
		params += "|";
		if (custCd.length > 2) {
			params += custCd.substring(0,2);
			params += ComTrim(ComGetObjValue(formObj.custSeq));
		}	
		ComSetObjValue(formObj.chk_calc_tp_in, params);
		if (tariff.indexOf("CT") != -1) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DUAL);	
		}
		else {
			ComSetObjValue(formObj.chk_calc_tp_combined, "N");
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_CALC);
		}
		var result=ComGetObjValue(formObj.result);
		//result(E: Error, M: Mandatory, O:Option)
		if (result == "M") {
			if (tariff.indexOf("CT") != -1) {
				if (ComTrim(sheetRFAObj.GetCellValue(selectedRow, ADD_DYS)).length > 0) {
					ComShowCodeMessage("DMT00113", sheetRFAObj.GetCellValue(selectedRow, "Seq"));
					return false; 					
				}
				if (fetchRowCount(sheetRTObj) < 1) {
					ComShowCodeMessage("DMT00114", sheetRFAObj.GetCellValue(selectedRow, "Seq"));
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
			ComShowCodeMessage(errMsgId, sheetRFAObj.GetCellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");
			return false;					
		}
		return true;
	}
	function validateCalculationTypeInDM(selectedRow) {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		var tariff=sheetRFAObj.GetCellValue(selectedRow, TARIFF);
		var params="";
		if (tariff.indexOf("DM") != -1) {
			if (ComTrim(sheetRFAObj.GetCellValue(selectedRow, BKGDEL_CNT)) != "") {
				params=changeNullToSpace(sheetRFAObj.GetCellValue(selectedRow, BKGDEL_CNT));
				params=params + "=" + changeNullToSpace(sheetRFAObj.GetCellValue(selectedRow, BKGDEL_RGN));
				params=params + "=" + changeNullToSpace(sheetRFAObj.GetCellValue(selectedRow, BKGDEL_LOC));
				params += "|";
				params += tariff;
				params += "|";
				params += sheetRFAObj.GetCellValue(selectedRow, EFF_DT);
				params += "|";
				params += sheetRFAObj.GetCellValue(selectedRow, EXP_DT);
				params += "|";
				params += sheetRFAObj.GetCellValue(selectedRow, CNTRCGO);
				params += "|";
				if (custCd.length > 2) {
					params += custCd.substring(0,2);
					params += ComTrim(ComGetObjValue(formObj.custSeq));
				}				
				ComSetObjValue(formObj.chk_calc_tp_in, params);
				ComSetObjValue(formObj.chk_calc_tp_combined, "Y");
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_CALC);
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
					ComShowCodeMessage("DMT00132", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + rgnCd + " ]");
					return false;				
				}			
			}
		}
		return true;		
	}
	
	function validateRateAdjustment(selectedRow) {
        var sheetRFAObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[2];
		if (isEmptyColumnOfLastRow(sheetRTObj, RT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetRTObj, RT_UPTO)) {
			ComShowCodeMessage("DMT02006", sheetRFAObj.GetCellValue(selectedRow, "Seq"));
			return false;
		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_20FT)) {
//			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "20FT");
//			return false;
//		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_40FT)) {
//			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "40FT");
//			return false;			
//		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_HC)) {
//			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "H/C");
//			return false;			
//		}
//		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_45FT)) {
//			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "45FT");
//			return false;			
//		}
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
	        case ORGDST_POP:
	            sUrl="/opuscntr/COM_ENS_051.do";
	            iWidth="1000";
	            iHeight="470";
	            ComOpenPopup(sUrl, iWidth, iHeight, "getMultiOrgDst", "0,0,1,1,1,1,1", true);
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
	function getMultiOrgDst(aryPopupData, row, col, sheetIdx) {
	    var formObj=document.form;
	    var location = "";
	    location = aryPopupData[0][3];
	    sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), ORGDST_LOC,location,1);
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
	
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj=document.form;
		var sheetCVRGObj=sheetObjects[1];
		var sheetFTObj=sheetObjects[3];
		var isCoverageError=false; 
		switch(sheetObj.ColSaveName(Col)) {
			case TARIFF:
				changeBKGDELorPOR(sheetObj, Row);
				setMultiOrgDestTitle();				
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
			case CVRG_CNT:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG=CVRG_CNT;
				var cntCd=ComTrim(sheetObj.GetCellValue(Row, Col));
				if (cntCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"cvrg_rgn_cd");
					sheetObj.SetCellValue(Row, "cvrg_rgn_cd","");
					ComClearCombo(formObj.currency);
				}
				else if (cntCd.length == 2) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH12,"cvrg_conti_cd");
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH03,"cvrg_cnt_cd|cvrg_rgn_cd");
					searchCurrencyList(Row);
					sheetObj.SetCellValue(Row, CURR_CD,ComTrim(ComGetObjValue(formObj.currency)));
				}
				if (isClearLocation) clearLocation(sheetObj,"cvrg_loc_cd");
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
				var rgnCd=ComTrim(sheetObj.GetCellValue(Row, Col));
				switch(rgnCd.length) {
					case 2:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH17,"|cvrg_cnt_cd|cvrg_rgn_cd");
						break;
					case 3:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH13,"|cvrg_cnt_cd|cvrg_rgn_cd");
						break;
				}
				if (isClearLocation) clearLocation(sheetObj,"cvrg_loc_cd");
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
	    			doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH04,"cvrg_cnt_cd|cvrg_rgn_cd|cvrg_loc_cd");
					isValueSettingEvent=false;
					isClearLocation=true;
				}
				else if (locCd.length > 0) {
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
					} else {
						SetCellValue(Row, 		FT_TIR,  "");
						SetCellValue(Row, 		ADD_DYS, "");
						SetCellValue(Row, 		TOT_DYS, "");
					}
				}
				//setFreeTimeByMandatory(sheetObj, sheetObj.GetSelectRow(), FT_FLG);
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
					delSubBeforeException(sheetFTObj, "All");
				}
			break;
			
			case ORGDST_MULTI:
				setMultiOrgDestGrid();
				if (Value == "M") {
					with(sheetObj) {
						SetCellValue(Row, 	ORGDST_CTI,"",0);
						SetCellValue(Row, 	ORGDST_CNT,"",0);
						SetCellValue(Row, 	ORGDST_RGN,"",0);
						SetCellValue(Row, 	ORGDST_LOC,"",0);
					}
					addMultiOrgDest();
				}
				else {
					delSubBeforeException(sheetCVRGObj, "All");
				}
				break;
			case ORGDST_CTI:
				var ctCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (ctCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH02,"org_dest_cnt_cd");
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"org_dest_rgn_cd");
				}
				else if (ctCd.length == 1) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH06,"org_dest_cnt_cd");
				}
				if (isClearLocation) clearLocation(sheetObj,"org_dest_loc_cd");				
				break;
			case ORGDST_CNT:
				var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (cntCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"org_dest_rgn_cd");
					sheetObj.SetCellValue(Row,"org_dest_rgn_cd","");
				}
				else if (cntCd.length == 2) {
					if (!isValueSettingEvent) {
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH12,"org_dest_conti_cd|org_dest_cnt_cd");
					}
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH03,"org_dest_cnt_cd|org_dest_rgn_cd");
				}
				if (isClearLocation) clearLocation(sheetObj,"org_dest_loc_cd");				
				break;
			case ORGDST_RGN:
				if (isValueSettingEvent) return;
				var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				switch(rgnCd.length) {
					case 2: 
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH17,"org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd");
						break;
					case 3:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH13,"org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd");
						break;
				}
				if (isClearLocation) clearLocation(sheetObj,"org_dest_loc_cd");
				break;
			case ORGDST_LOC:
				var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH10,"org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd|org_dest_loc_cd");
					isValueSettingEvent=false;
					isClearLocation=true;
				}
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}								
				break;				
			case BKGDEL_CNT:
				if (ComTrim(sheetObj.GetCellValue(Row, CVRG_CNT)) == "") {
					sheetObj.SetCellValue(Row, BKGDEL_CNT,"",0);
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (cntCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"fnl_dest_rgn_cd");
					sheetObj.SetCellValue(Row,"fnl_dest_rgn_cd","");
				}
				else if (cntCd.length == 2) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH12,"fnl_dest_conti_cd");
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH03,"fnl_dest_cnt_cd|fnl_dest_rgn_cd");
				}
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");
				if (!equalContinentByCN(Row)) {
					ComShowCodeMessage("DMT02008");
					sheetObj.SetCellValue(Row, BKGDEL_CNT,"");
					sheetObj.SetCellValue(Row, BKGDEL_RGN,"",0);
					sheetObj.SetCellValue(Row, BKGDEL_LOC,"",0);
					return;
				}				
				break;
			case BKGDEL_RGN:
				if (ComTrim(sheetObj.GetCellValue(Row, CVRG_CNT)) == "") {
					sheetObj.SetCellValue(Row, BKGDEL_RGN,"",0);
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				if (isValueSettingEvent) return;	
				var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				switch(rgnCd.length) {
					case 2: 
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH17,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
					case 3:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH13,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
				}
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");							
				break;
			case BKGDEL_LOC:
				if (ComTrim(sheetObj.GetCellValue(Row, CVRG_CNT)) == "") {
					sheetObj.SetCellValue(Row, BKGDEL_LOC,"",0);
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH04,"fnl_dest_cnt_cd|fnl_dest_rgn_cd|fnl_dest_loc_cd");
					isValueSettingEvent=false;
					isClearLocation=true;
				}	
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}								
				break;
			case CUST_CD:
				sheetObj.SetCellValue(Row, CUST_NM,ComGetComboText(sheetObj, Row, Col, 1),0);
				break;
			case REMARK:
				var remark = checkSpecialValue(sheetObj.GetCellValue(Row, REMARK));
				sheetObj.SetCellValue(Row, REMARK, remark);
				sheetObj.SetCellValue(Row, FULL_REMARK,sheetObj.GetCellValue(Row, REMARK));
				break;
		}
		if (isCoverageError) sheetObj.SetCellValue(Row, CVRG_CNT,"");
	}
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (currDtlSeq == GetCellValue(row, DTL_SEQ)) {
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
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var formObj=document.form;
		if (isDupEventFlag) 		  return;	// 중복이벤트 방지		
    	if (isCopyRFAExceptionTariff) return;
		with(sheetObj) {
			if (OldRow >= HeaderRows()&& OldRow != NewRow) {
				var chkResult=isChangedBeforeException();
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
						currDtlSeq=GetCellValue(GetSelectRow(), DTL_SEQ);
						//-------------------------------------------
						return;
					}
					isDupEventFlag = true;
					SetSelectRow(OldRow);
					isDupEventFlag = false;
					//-------------------------------------------
					currDtlSeq=GetCellValue(GetSelectRow(), DTL_SEQ);
					//-------------------------------------------
					if (!saveBKGReqDetail(chkResult[0])) return;	
					//##################################################################
				}
				else {
					//-------------------------------------------
					currDtlSeq=GetCellValue(GetSelectRow(), DTL_SEQ);
					//-------------------------------------------
					setSubBeforeException(true);
				}
			}
		}
	}
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		with(sheetObj) {
			var colName = ColSaveName(MouseCol());
			if (MouseRow() == (HeaderRows()- 1)) {
				switch(colName) {
					case ADD_DYS: 	SetToolTipText(MouseRow(), MouseCol(), "Additional Day"); break;
					case TOT_DYS: 	SetToolTipText(MouseRow(), MouseCol(), "Total Day"); 	  break;					
					default: 		SetToolTipText(MouseRow(), MouseCol(), "");
				}
			}
			else if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					switch(trfCd) {
						case "DMOF": 	SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": 	SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": 	SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); 	  break;
						case "DTIC":
						case "CTIC": 	SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); 	  break;
						default: 		SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}
				else if (colName == ADD_DYS) {
					SetToolTipText(MouseRow(), MouseCol(), "Additional Day");
				}
				else if (colName == TOT_DYS) {
					SetToolTipText(MouseRow(), MouseCol(), "Total Day");
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					switch(trfCd) {
						case "DMOF":
						case "DTOC":
						case "CTOC": 	SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": 	SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						default: 		SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					switch(trfCd) {
						case "DMIF": 	SetToolTipText(MouseRow(), MouseCol(), "BKG DEL for Demurrage Only"); break;
						case "DMOF": 	SetToolTipText(MouseRow(), MouseCol(), "BKG POR for Demurrage Only"); break;
						default: 		SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}				
				else if (colName == REMARK)	{
					SetToolTipText(MouseRow(), MouseCol(), GetCellValue(MouseRow(), FULL_REMARK));
				}		
				else {
					SetToolTipText(MouseRow(), MouseCol(), "");
				}
			}
			else {
				SetToolTipText(MouseRow(), MouseCol(), "");
			}			
		}		
	}
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		switch(sheetObj.ColSaveName(Col)) {
			case ORGDST_CTI:
				var isDeleteRowValue=false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue=true;
				}
				if (Value.length == 0) {
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH02, "org_dest_cnt_cd");
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH01, "org_dest_rgn_cd");
				}
				else if (Value.length == 1) {
					ComSetObjValue(formObj.conti_cd,	Value);	
					ComSetObjValue(formObj.f_cmd,		SEARCH06);
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH06, "org_dest_cnt_cd", false);
				}
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				if (isClearLocation) sheetObj.SetCellValue(Row, ORGDST_LOC,"",0);
				break;
			case ORGDST_CNT:
				var isDeleteRowValue=false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue=true;
				}
				if (Value.length == 0) {
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH01, "org_dest_rgn_cd");
					sheetObj.SetCellValue(Row, "org_dest_rgn_cd","");
				}
				else if (Value.length == 2) {
					if (!isValueSettingEvent) {
						ComSetObjValue(formObj.cnt_cd,		Value);	
						ComSetObjValue(formObj.f_cmd,		SEARCH12);
						doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH12, "org_dest_conti_cd|org_dest_cnt_cd", false);
					}
					ComSetObjValue(formObj.cnt_cd,		Value);	
					ComSetObjValue(formObj.f_cmd,		SEARCH03);
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH03, "org_dest_cnt_cd|org_dest_rgn_cd", false);
				}
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				if (isClearLocation) sheetObj.SetCellValue(Row, ORGDST_LOC,"",0);
				break;
			case ORGDST_RGN:
				if (isValueSettingEvent) return;	
				var isDeleteRowValue=false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue=true;
				}
				switch(Value.length) {
					case 2: 
						ComSetObjValue(formObj.f_cmd,		SEARCH17);
						ComSetObjValue(formObj.ste_cd,		Value);
						doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH17, "org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd", false);
						break;
					case 3:
						ComSetObjValue(formObj.f_cmd,		SEARCH13);
						ComSetObjValue(formObj.rgn_cd,		Value);
						doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH13, "org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd", false);
						break;
				}
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				if (isClearLocation) sheetObj.SetCellValue(Row, ORGDST_LOC,"",0);
				break;
			case ORGDST_LOC:
				if (Value.length == 5) {
					isClearLocation=false;
					isValueSettingEvent=true;
					ComSetObjValue(formObj.loc_cd,		Value);	
					ComSetObjValue(formObj.select_row, 	Row);
					ComSetObjValue(formObj.f_cmd,		SEARCH10);
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH10, "org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd|org_dest_loc_cd", false);
					ComSetObjValue(formObj.select_row, 	"");
					isValueSettingEvent=false;
					isClearLocation=true;
				}
				else if (Value.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.SetCellValue(Row, Col,"",0);
				}								
				break;	
		}
	}
	function sheet2_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		var sheetObj1 = sheetObjects[0];
		with(sheetObj) {
			var colName = ColSaveName(MouseCol());
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), TARIFF);
					switch(trfCd) {
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR");    break;
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL");    break;
						default:	 SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}			
				else {
					SetToolTipText(MouseRow(), MouseCol(), "");
				}
			}
			else {
				SetToolTipText(MouseRow(), MouseCol(), "");
			}			
		}		
	}
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetObj=sheetObjects[2];
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
				if (rtUpTo == "") { return; }
				if (!ComIsNumber(rtUpTo)) {
					ComShowCodeMessage("DMT00134");
					SetCellValue(Row, Col,"",0);
					SelectCell(Row, Col, false);
					return;					
				}               
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
	 * Sheet3(Tiered Free Time) change
	 * [2016.01.04] NYK Add.
	 */		 
	function sheet5_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetObj=sheetObjects[3];
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
	 * Sheet6(Commodity) change
	 * [2016.01.04] NYK Add.
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
	function sheet4_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj=document.form;
		if (OldRow >= sheetObj.HeaderRows()&& OldRow != NewRow) {
			if (!formObj.chkComment.checked) {
				ComSetObjValue(formObj.comment, sheetObj.GetCellValue(NewRow, PROG_RMK));
			}
		}		
	}
	function clearLocation(sheetObj,sComboKey) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sComboKey,"",0);
	}	
	function addBKGReqDetail() {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetRTObj=sheetObjects[2];
		
		var sheetFTObj=sheetObjects[3];
		var sheetCMDTObj=sheetObjects[4];
		
		if (ComTrim(ComGetObjValue(formObj.approvalOfcCd)) == "") {
			ComShowCodeMessage("DMT00140", "APVL OFC");
			ComSetFocus(comboObjects[0]);
			return;
		}
		var chkResult=isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				if (!saveBKGReqDetail(chkResult[0])) return;	
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		with(sheetRFAObj) {
			if (fetchRowCount(sheetRFAObj) > 0) {
				darNo=GetCellValue(LastRow(), 	DAR_NO);
				verSeq=GetCellValue(LastRow(), 	VER_SEQ);
			} else {
				darNo=ComTrim(cboDARObj.GetSelectText());
				verSeq=ComTrim(ComGetObjText(formObj.version));
			}
			isCopyRFAExceptionTariff=true;
			DataInsert(-1);
			isCopyRFAExceptionTariff=false;
			SetCellValue(LastRow(), DAR_NO,darNo);
			SetCellValue(LastRow(), MAPG_SEQ,"1");
			SetCellValue(LastRow(), VER_SEQ,verSeq);
			SetCellValue(LastRow(), DTL_SEQ,"");
			SetCellValue(LastRow(), FT_FLG,"1");
			SetCellValue(LastRow(), CVRG_SEQ,"1");
			SetCellValue(LastRow(), ROW_EDIT_STS,"Y");
			SetCellValue(LastRow(), CURR_CD,"");
			SetCellValue(LastRow(), RT_MANDATORY,"N");
		}
		setMultiOrgDestGrid();
		sheetCVRGObj.RemoveAll();
		setRateAdjustmentGrid();
		sheetRTObj.RemoveAll();
		
		//[2016.01.04] NYK Add.
		//Tiered Free Time  status change .(button )
		setTieredFreeTimeGrid();
		sheetFTObj.RemoveAll();
		
		//Commodity grid Clear 
		setCommodityGrid();
		sheetCMDTObj.RemoveAll();
	}
	function addMultiOrgDest() {
	    var formObj=document.form;
	    var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var cvrgSeq="";
		if (formObj.chkMultiOrgDest.checked) {
			cvrgSeq=fetchColumnValueOfLastRow(sheetCVRGObj, CVRG_SEQ);
			cvrgSeq=cvrgSeq  == "" ? 1 : ComParseInt(cvrgSeq)  + 1;
			with(sheetCVRGObj) {
				DataInsert(-1);
				SetCellValue(LastRow(), DAR_NO,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO));
				SetCellValue(LastRow(), MAPG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), MAPG_SEQ));
				SetCellValue(LastRow(), VER_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER_SEQ));
				SetCellValue(LastRow(), DTL_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ));
				SetCellValue(LastRow(), CVRG_SEQ,cvrgSeq);
			}
		}		
	}
	function addRateAdjustment() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[2];
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
			with(sheetRTObj) {
				DataInsert(-1);
				SetCellValue(LastRow(), 		DAR_NO,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO));
				SetCellValue(LastRow(), 		MAPG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), MAPG_SEQ));
				SetCellValue(LastRow(), 		VER_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER_SEQ));
				SetCellValue(LastRow(), 		DTL_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ));
				SetCellValue(LastRow(), 		CVRG_SEQ,sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_SEQ));
				SetCellValue(LastRow(), 		RT_SEQ,rtSeq);
				SetCellValue(LastRow(), 		RT_FROM,rtFrom);
				SetCellEditable(LastRow(), 	RT_FROM,0);
			}
		}
	}
	function copyBKGReqDetail() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT01117", "copy");
			return;
		}
		var chkResult=isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				if (!saveBKGReqDetail(chkResult[0])) return;
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		with(sheetRFAObj) {
			isCopyRFAExceptionTariff=true;
			var row=DataCopy();
			isCopyRFAExceptionTariff=false;
			SetRowStatus(row,"I");
			SetCellValue(row, CURR_ORGDST_MULTI,"");
			SetCellValue(row, DTL_SEQ,"");
		}
		for (var sheetNo=1 ; sheetNo < sheetObjects.length ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row=HeaderRows(); row <= LastRow(); row++) {
					SetRowStatus(row,"I");
					SetCellValue(row, DTL_SEQ,"");
				}
			}
		}		
	}
	function saveBKGReqDetail(isChangedRFATariff) {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}
		if (ComTrim(cboDARObj.GetSelectText()) == "") {
			if(!doActionCheckByApprovalOfc()) {
				return;
			}
		}
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT01117", "save");
			return;
		}
		if (!isChangedRFATariff) {
			var chkResult=isChangedBeforeException();
			if (!chkResult[0]) {
				ComShowCodeMessage("DMT01113");
				return false;
			}
		}
		if (validateForm()) {
			copyBKGDetailReqCoverageforSave();
			setFlagValues();
			ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, "T");
			doActionIBSheet(sheetRFAObj, formObj, IBSAVE_RFATARIFF);
			releaseBKGDetailReqCoverageforSave();
			if (ComGetObjValue(formObj.result) == "Y") {
				ComShowCodeMessage("DMT00001");
				doActionRetrieve(IBSEARCH_RFATARIFF);
			}
		}
		else {
			return false;
		}
		return true;
	}	 
	function delSubBeforeException(sheetObj, part) {
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
					SetRowStatus(GetSelectRow(),"D");
					SetRowHidden(GetSelectRow(), 1);
				}
			}
		}
	}
	function editableDetail(flag) { 
		var sheetRFAObj=sheetObjects[0];
		var tmpStatus="";
		with(sheetRFAObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				tmpStatus=GetRowStatus(row);
				SetCellEditable(row, TARIFF,flag);
				SetCellEditable(row, EFF_DT,flag);
				SetCellEditable(row, EXP_DT,flag);
				SetCellEditable(row, CNTRCGO,flag);
				SetCellEditable(row, CVRG_CNT,flag);
				SetCellEditable(row, CVRG_RGN,flag);
				SetCellEditable(row, CVRG_LOC,flag);
				SetCellEditable(row, CVRG_POP,flag);
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
				/*[2016.01.04] NYK Add
				if (flag && GetCellValue(row, FT_FLG) == 1) {
					SetCellEditable(row, ADD_DYS,1);
					SetCellEditable(row, TOT_DYS,1);
					SetCellEditable(row, SAT_FLG,1);
					SetCellEditable(row, SUN_FLG,1);
					SetCellEditable(row, HOL_FLG,1);
				}
				else {
					SetCellEditable(row, ADD_DYS,0);
					SetCellEditable(row, TOT_DYS,0);
					SetCellEditable(row, SAT_FLG,0);
					SetCellEditable(row, SUN_FLG,0);
					SetCellEditable(row, HOL_FLG,0);
				}*/				
				SetCellEditable(row, ORGDST_MULTI,flag);
				if (flag && GetCellValue(row, ORGDST_MULTI) == "M") {
					SetCellEditable(row, ORGDST_CTI,0);
					SetCellEditable(row, ORGDST_CNT,0);
					SetCellEditable(row, ORGDST_RGN,0);
					SetCellEditable(row, ORGDST_LOC,0);
					SetCellEditable(row, ORGDST_POP,0);
				} 
				else {
					SetCellEditable(row, ORGDST_CTI,flag);
					SetCellEditable(row, ORGDST_CNT,flag);
					SetCellEditable(row, ORGDST_RGN,flag);
					SetCellEditable(row, ORGDST_LOC,flag);
					SetCellEditable(row, ORGDST_POP,flag);
				}
				if (flag) { 
					changeBKGDELorPOR(sheetRFAObj, row); 
				}
				else { 
					SetCellEditable(row, BKGDEL_CNT,0);
					SetCellEditable(row, BKGDEL_RGN,0);
					SetCellEditable(row, BKGDEL_LOC,0);
					SetCellEditable(row, BKGDEL_POP,0);
				}
				SetCellEditable(row, CUST_CD,flag);
				SetCellEditable(row, REMARK,flag);
				SetCellValue(row, ROW_EDIT_STS,flag ? "Y" : "N");
				SetRowStatus(row,tmpStatus);
			}
		}
		if (flag) {
			ComBtnEnable("btn_AddBKGReqDetail");
			ComBtnEnable("btn_CopyBKGReqDetail");
			ComBtnEnable("btn_SaveBKGReqDetail");
			ComBtnEnable("btn_DelBKGReqDetail");
		}
		else {
			ComBtnDisable("btn_AddBKGReqDetail");
			ComBtnDisable("btn_CopyBKGReqDetail");
			ComBtnDisable("btn_SaveBKGReqDetail");
			ComBtnDisable("btn_DelBKGReqDetail");
		}
	}
	function editableMultiOrgDest(flag) {
		var sheetCVRGObj=sheetObjects[1];
		with(sheetCVRGObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				SetCellEditable(row, ORGDST_CTI,flag);
				SetCellEditable(row, ORGDST_CNT,flag);
				SetCellEditable(row, ORGDST_RGN,flag);
				SetCellEditable(row, ORGDST_LOC,flag);
				SetCellEditable(row, ORGDST_POP,flag);
			}
		}
		if (flag) {
			ComBtnEnable("btn_AddMultiOrgDest");
			ComBtnEnable("btn_DelMultiOrgDest");
		}
		else {
			ComBtnDisable("btn_AddMultiOrgDest");
			ComBtnDisable("btn_DelMultiOrgDest");
		}
	}
	function editableRateAdjustment(flag, isClicked) {
		var formObj=document.form;
		var sheetRTObj=sheetObjects[2];
		isClicked=(isClicked == undefined) ? false : isClicked;
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
		if (flag && formObj.chkRateAdjustment.checked) {
			ComBtnEnable("btn_AddRateAdjustment");
			ComBtnEnable("btn_DelRateAdjustment");
		}
		else {
			ComBtnDisable("btn_AddRateAdjustment");
			ComBtnDisable("btn_DelRateAdjustment");
		}
	}
	function delBKGReqDetail() {
		var formObj     = document.form;
		var sheetRFAObj = sheetObjects[0];

		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver     = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return;
		}

		with(sheetRFAObj) {
			if (fetchRowCount(sheetRFAObj) > 0) {
				if (GetRowStatus(GetSelectRow()) != 'I') {
					if (fetchRowCount(sheetRFAObj) == 1) {
						ComShowCodeMessage("DMT01123");
						return;
					}
					else if (fetchRowCount(sheetRFAObj) > 1) {
						if (!ComShowCodeConfirm("DMT00135", "delete")) return;
					}
					doActionIBSheet(sheetRFAObj, formObj, IBDELETE_RFATARIFF);
					if (ComGetObjValue(formObj.result) != "Y") {
						ComShowCodeMessage("DMT00008", "save");
						return;
					}
				}
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				
				//[2016.01.04] NYK Add				
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
								
				RowDelete(GetSelectRow(), false);
				
				if (fetchRowCount(sheetRFAObj) > 0) {
					setSubBeforeException(true);
				}
				else {
					//doActionRetrieveBBR(IBSEARCH);
				}
			}
		}
	}
	function changeBKGDELorPOR(sheetObj, selectedRow) {
		var trfCd=ComTrim(sheetObj.GetCellValue(selectedRow, TARIFF));
		if (trfCd == "DMIF" || trfCd == "DMOF") {
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_CNT,1);
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_RGN,1);
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_LOC,1);
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_POP,1);
		}
		else {
			sheetObj.SetCellValue(selectedRow,	BKGDEL_CNT,"");
			sheetObj.SetCellValue(selectedRow,	BKGDEL_RGN,"");
			sheetObj.SetCellValue(selectedRow,	BKGDEL_LOC,"");
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_CNT,0);
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_RGN,0);
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_LOC,0);
			sheetObj.SetCellEditable(selectedRow,	BKGDEL_POP,0);
		}		
	}
	function fetchColumnValueOfLastRow(sheetObj, COL) {
		var lastColumnValue="";
		with(sheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) != "D") {
					lastColumnValue=GetCellValue(row, COL);
					break;
				}
			}
		}
		return lastColumnValue;		
	}	
	function getVerStatus(type) {
		var formObj=document.form;
		var verInfo=ComTrim(ComGetObjValue(formObj.version));
		if (verInfo.indexOf(":") != -1) {
			var stsArr=verInfo.split(":");
			if (type == "Code") { 
				return stsArr[0]; 
			}
			else if (type == "Text") { 
				return stsArr[1]; 
			}
			else if (type == "ReqOfc") {
				return stsArr[2];
			}
		}
		return "";
	}
	function isProposalCreationScreen() {
		var formObj=document.form;
		if (ComTrim(ComGetObjValue(formObj.isEditable)) == "Y") {
			return true;	
		} else {
			return false;
		}		
	}
	function initBtnControl() {
		//New Button
		initBtnNew();	
		//Update Button
		initBtnUpdate();
		//Request Button
		initBtnRequest();
		//Cancel Button
		initBtnCancel();
		//Approval Button
		initBtnApproval();
		//Counter Offer Button
		initBtnCounterOffer();
		//Reject Button
		initBtnReject();
	}
	function initBtnNew() {
		if (isProposalCreationScreen()) {
			ComBtnEnable("btn_New");
		} else {
			ComBtnDisable("btn_New");
		}		
	}
	function initBtnUpdate() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
			var isPass1=ComGetObjValue(formObj.ofc_cd) == getVerStatus("ReqOfc");
	    	var isPass2=isMatchVersion();
	    	var isPass3=isPermitStatus("Update");
	    	if (isPass1 && isPass2 && isPass3)
	    		ComBtnEnable("btn_Update");
	    	else
	    		ComBtnDisable("btn_Update");
		} else {
			ComBtnDisable("btn_Update");
		}		
	}
	function initBtnRequest() {
		if (isProposalCreationScreen()) {
	    	var isPass1=isPermitStatus("Request");
	    	if (isPass1)
	    		ComBtnEnable("btn_Request");
	    	else
	    		ComBtnDisable("btn_Request");
		} else {
			ComBtnDisable("btn_Request");
		}
	}
	function initBtnCancel() {
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		if (isProposalCreationScreen()) {
			var statusCd=getVerStatus("Code");
			var rqstOfcCd="";
			if (sheetObj1.RowCount()> 0) rqstOfcCd=sheetObj1.GetCellValue(sheetObj1.HeaderRows(), RQST_OFC_CD);
			var logOfcCd=ComGetObjValue(formObj.ofc_cd);
			if (rqstOfcCd == logOfcCd && (statusCd == "R" || statusCd == "T" || statusCd == "O")) {
				ComBtnEnable("btn_Cancel");
			} else {
				ComBtnDisable("btn_Cancel");
			}
		} else {
			ComBtnDisable("btn_Cancel");
		}		
	}
	function initBtnApproval() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
	    	var isPass1=isPermitRole();
	    	var isPass2=isMatchOffice();
	    	var isPass3=isMatchVersion();
	    	var isPass4=isPermitStatus("Approval");
	    	if (isPass1 && isPass2 && isPass3 && isPass4)
	    		ComBtnEnable("btn_Approval");
	    	else
	    		ComBtnDisable("btn_Approval");			
		} else {
			ComBtnDisable("btn_Approval");
		}		
	}	
	function initBtnReject() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
	    	var isPass1=isPermitRole();
	    	var isPass2=isMatchOffice();
	    	var isPass3=isMatchVersion();
	    	var isPass4=isPermitStatus("Reject");
	    	if (isPass1 && isPass2 && isPass3 && isPass4)
	    		ComBtnEnable("btn_Reject");
	    	else
	    		ComBtnDisable("btn_Reject");				
		} else {
			ComBtnDisable("btn_Reject");
		}		
	}
	function initBtnCounterOffer() {
		var formObj=document.form;
		if (isProposalCreationScreen()) {
	    	var isPass1=isPermitRole();
	    	var isPass2=isMatchOffice();
	    	var isPass3=isMatchVersion();
	    	var isPass4=isPermitStatus("CounterOffer");
	    	if (isPass1 && isPass2 && isPass3 && isPass4)
	    		ComBtnEnable("btn_CounterOffer");
	    	else
	    		ComBtnDisable("btn_CounterOffer");
		} else {
			ComBtnDisable("btn_CounterOffer");
		}		
	}
	function isEmptyColumnOfLastRow(sheetObj, COL) {
		var isEmptyColumn=false;
		with(sheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (GetRowStatus(row) != "D") {
					var ColVal = GetCellValue(row, COL);
					if (ColVal == "") {
						isEmptyColumn=true;
					}					
					break;
				}
			}
		}
		return isEmptyColumn;		
	}
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
	function getNextRow(currRow, sheetObj) {
		var sheetObj1=sheetObjects[0];
		var darNo=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), DAR_NO);
		var mapgSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), MAPG_SEQ);
		var verSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), VER_SEQ);
		var dtlSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), DTL_SEQ);
		var nextRow=-1;
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (GetCellValue(row, HID_STATUS) != "Y") {
					if (darNo == GetCellValue(row, DAR_NO) &&
							mapgSeq == GetCellValue(row, MAPG_SEQ) &&
							verSeq == GetCellValue(row, VER_SEQ) &&
							dtlSeq == GetCellValue(row, DTL_SEQ)) {
						if (row > currRow) {
							nextRow=row;
							break;
						}
					}
				}
			}
		}				
		return nextRow;			
	}
	function equalContinentByCN(selectRow) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var orgCN=ComTrim(sheetObj.GetCellValue(selectRow, BKGDEL_CNT));
		if (orgCN.length == 0) return true;
		var trgCN=ComTrim(sheetObj.GetCellValue(selectRow, CVRG_CNT));
		ComSetObjValue(formObj.fnl_dest_cnt_cd, orgCN);
		ComSetObjValue(formObj.cnt_cd, trgCN);
		doActionIBSheet(sheetObj,formObj,IBSEARCH_CHKCONTI);
		chkOutData=ComGetObjValue(formObj.result);
		if (chkOutData == "Y") { return true; }
		else { return false; }
	}
	function changeNullToSpace(str) {
		return ComTrim(str).length == 0 ? " " : ComTrim(str);
	}	
	function checkRateAdjustment() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
			if (GetCellValue(GetSelectRow(), RT_MANDATORY) == "Y" && !formObj.chkRateAdjustment.checked) {
				ComShowCodeMessage("DMT00129", GetCellValue(GetSelectRow(), "Seq"));
				formObj.chkRateAdjustment.checked=true;
				return;
			}
			if (GetCellValue(GetSelectRow(), CVRG_CNT) == "" && formObj.chkRateAdjustment.checked) {
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
	function doActionCheckOnRateAdjustment() {
		var sheetRFAObj=sheetObjects[0];
		searchCurrencyList(sheetRFAObj.GetSelectRow());
		editableRateAdjustment(true);
		sheetRFAObj.SetCellValue(sheetRFAObj.GetSelectRow(), RT_CHECK,"Y");
		addRateAdjustment();
	}
	function doActionUnCheckOnRateAdjustment() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetRTObj=sheetObjects[2];
		delSubBeforeException(sheetRTObj, "All");
		ComClearCombo(formObj.currency);
		sheetRFAObj.SetCellValue(sheetRFAObj.GetSelectRow(), CURR_CD,"");
		editableRateAdjustment(false, true);
		sheetRFAObj.SetCellValue(sheetRFAObj.GetSelectRow(), RT_CHECK,"N");
	}
	function setFlagValues() {
		var sheetRFAObj		= sheetObjects[0];
		var sheetRTObj		= sheetObjects[2];
		var sheetCMDTObj	= sheetObjects[4];
		with(sheetRFAObj) {
			if (fetchRowCount(sheetRTObj) > 0) {
				SetCellValue(GetSelectRow(), RT_USE_FLG,"Y");
			} else {
				SetCellValue(GetSelectRow(), RT_USE_FLG,"N");
			}
			if (ComTrim(GetCellValue(GetSelectRow(), BKGDEL_CNT)) != "") {
				SetCellValue(GetSelectRow(), FNL_DEST_FLG,"Y");
			} else {
				SetCellValue(GetSelectRow(), FNL_DEST_FLG,"N");
			}
			
			if (fetchRowCount(sheetCMDTObj) > 0) {
				SetCellValue(GetSelectRow(), CMDT_FLG,"Y");
			} 
			else {
				SetCellValue(GetSelectRow(), CMDT_FLG,"N");
			}
		}
	}	
    function approvalOfcCd_OnChange() {
    	var formObj=document.form;
    	var cboDARObj=comboObjects[0 + plusComboCnt];
    	var cboAPVLObj=comboObjects[1 + plusComboCnt];
    	var sheetRFAObj=sheetObjects[0];
    	var sheetCVRGObj=sheetObjects[1];
    	var sheetRTObj=sheetObjects[2];
    	var sheetHSTObj=sheetObjects[5];
		ComSetObjValue(formObj.apro_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
		if (ComGetObjValue(formObj.approvalOfcCd) == "")
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
		if (cboDARObj.GetItemCount() > 0 && ComGetObjValue(formObj.approvalOfcCd) != "") {
			doActionRetrieve(IBSEARCH);
		}
		else {
			cboDARObj.SetSelectIndex(-1);
			addComboItem(formObj.version, "001=", true);
			ComClearObject(formObj.status);
			if (ComGetObjValue(formObj.approvalOfcCd) != "")
				cboAPVLObj.RemoveAll();
			else
				cboAPVLObj.SetSelectIndex(-1);
			sheetRFAObj.RemoveAll();
			sheetCVRGObj.RemoveAll();
			sheetRTObj.RemoveAll();
			sheetHSTObj.RemoveAll();
			ComSetObjValue(formObj.comment, "");
			if (ComGetObjValue(formObj.isEditable) == "Y")
				editableDetail(true);
			else
				editableDetail(false);
			setSubBeforeException(false);
			initBtnControl();  
		}
    }
    function doActionCheckByApprovalOfc() {
    	var formObj=document.form;
    	var cboDARObj=comboObjects[0 + plusComboCnt];
    	var sheetRFAObj=sheetObjects[0];
		ComSetObjValue(formObj.apro_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR_CHECK);
		if(formObj.dar_no_check.value == "Y"){
			ComShowCodeMessage("DMT01148","New");//Version()status has changed. Pls click New button
			return false;	
		}
		return true;
    }
 	function combo1_OnChange(comboObj, Index_Code, Text) {
    	if (!isSettingValue) 
    		doActionRetrieveByDARChange();
    }
  	function combo2_OnChange(comboObj, Index_Code, Text) {
  		if (!isSettingValue)
  			doActionRetrieveByAPVLNoChange();
     }     
    function doActionRetrieveByDARChange() {
    	var formObj=document.form;
    	var cboDARObj=comboObjects[0 + plusComboCnt];
    	var sheetRFAObj=sheetObjects[0];
    	if (ComTrim(cboDARObj.GetSelectCode()) != "") {
        	ComSetObjValue(comboObjects[0],  cboDARObj.GetSelectCode());
    		doActionRetrieve(IBSEARCH);
    	}
    }
    function doActionRetrieveByAPVLNoChange() {
    	var formObj=document.form;
    	var cboDARObj=comboObjects[0 + plusComboCnt];
    	var cboAPVLObj=comboObjects[1 + plusComboCnt];
    	var sheetRFAObj=sheetObjects[0];
    	if (ComTrim(cboAPVLObj.GetSelectCode()) != "") {
        	doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_RFATARIFF_APVLNO);
        	ComSetObjValue(comboObjects[0], ComGetObjValue(formObj.apvlno_ofc));
        	ComSetObjValue(formObj.apro_ofc_cd,	  ComGetObjValue(formObj.apvlno_ofc));
        	doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
        	doActionRetrieve(IBSEARCH);
        	ComSetObjValue(formObj.apvlno_ofc, "");
        	ComSetObjValue(formObj.apvlno_dar, "");
        	ComSetObjValue(formObj.apvlno_ver, "");
    	}
    }
     function doActionRetrieveByVerChange() {
    	var formObj=document.form;
    	var cboDARObj=comboObjects[0 + plusComboCnt];
    	var cboAPVLObj=comboObjects[1 + plusComboCnt];
     	var sheetRFAObj=sheetObjects[0];
     	if (ComGetObjText(formObj.version) != "") {
			if (getVerStatus("Code") == "A") {
				ComSetObjValue(formObj.prop_no, 			"");
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.GetSelectText()));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
			}
			else {
				cboAPVLObj.RemoveAll();
			}
			doActionRetrieveByVer(IBSEARCH);			
        }
    }
  	function doProcessPopup(srcName) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		with(sheetObj) {
  	  		switch(srcName) {
  	  			case "Affiliate":		// Affiliate Inquiry Popup
		  	  		var paramVal="?cond_prop_no=" + ComGetObjValue(formObj.proposalNo);
  	  				var rtnVal=ComOpenWindowCenter("ESM_PRI_2019_06.do" + paramVal, "", 1020, 335, true);
  					break;
  	  		} // switch-end
  		} // with-end
  	} 
  	function setMultiOrgDestTitle() {
		var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var trfCd=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), TARIFF);
		var HeadTitle1="";
		var HeadTitle2="|Seq.|Continent|Country|Region|Location";	
		switch(trfCd) {
			case "DMOF":
			case "DTOC":
			case "CTOC":
				HeadTitle1="|Seq.|BKG DEL|BKG DEL|BKG DEL|BKG DEL";
				break;
			case "DMIF":
			case "DTIC": 
			case "CTIC":				
				HeadTitle1="|Seq.|BKG POR|BKG POR|BKG POR|BKG POR";
				break;
		}
//no support[implemented common]CLT 		sheetCVRGObj.InitHeadRow(0, HeadTitle1, true);
//no support[implemented common]CLT 		sheetCVRGObj.InitHeadRow(1, HeadTitle2, true);  		
  	}
 	 function checkComment() {
  		var formObj=document.form;
 		var sheetHSTObj=sheetObjects[5];
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
			//ComEnableObject(formObj.comment, false);
			comment.readOnly=!chkComment.checked;
			if (chkComment.checked) {
				comment.style.backgroundColor="#CCFFFD";	//textarea1
			}
			else {
				comment.style.backgroundColor="#E8E7EC";	//textarea2
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++
 	 	}
 	}
  	function checkMandatoryRateAdjustment() {
  		var formObj=document.form;
  		var sheetRFAObj=sheetObjects[0];
  		var sheetRTObj=sheetObjects[2];
  		with(sheetRFAObj) {
  			var tariff=ComTrim(GetCellValue(GetSelectRow(), TARIFF));
  			var effDt=ComTrim(GetCellValue(GetSelectRow(), EFF_DT));
  			var expDt=ComTrim(GetCellValue(GetSelectRow(), EXP_DT));
  			var cntrCgo=ComTrim(GetCellValue(GetSelectRow(), CNTRCGO));
  			var cntCd=ComTrim(GetCellValue(GetSelectRow(), CVRG_CNT));
  			var rgnCd=ComTrim(GetCellValue(GetSelectRow(), CVRG_RGN));
  			var locCd=ComTrim(GetCellValue(GetSelectRow(), CVRG_LOC));
  		}
  		if (tariff != "" && effDt != "" && expDt != "" && cntrCgo != ""	&& cntCd != "") {
  			ComSetObjValue(formObj.result, 		"");
			setMandatoryRTAdjust(sheetRFAObj.GetSelectRow());
			var result=ComTrim(ComGetObjValue(formObj.result));
			if (result == "E") {
				var errMsgId="";
				if (tariff.indexOf("CT") != -1) {
					errMsgId="DMT02003";
				}
				else {
					errMsgId="DMT00132";
				}				
				ComShowCodeMessage(errMsgId, sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");
				return result;
			}
			else if (result == "M") {
				sheetRFAObj.SetCellValue(sheetRFAObj.GetSelectRow(), RT_CHECK,"Y");
				setRateAdjustmentGrid();
				if (fetchRowCount(sheetRTObj) == 0) 
					addRateAdjustment();				
			}
			else {
				if (fetchRowCount(sheetRTObj) > 0)
					sheetRFAObj.SetCellValue(sheetRFAObj.GetSelectRow(), RT_CHECK,"Y");
				else
					sheetRFAObj.SetCellValue(sheetRFAObj.GetSelectRow(), RT_CHECK,"N");
			}
			return result;
  		}
  		return "N";	
  	}
    function validateComment() {
    	var formObj=document.form;
		if (!formObj.chkComment.checked) {
			ComShowCodeMessage("DMT00151");
			ComSetFocus(formObj.chkComment);
			return false;				
		}
		else if (ComTrim(ComGetObjValue(formObj.comment)) == "") {
			ComShowCodeMessage("DMT02002", "Comment");
			ComSetFocus(formObj.comment);
			return false;				
		}
		else if (ComChkLenByByte(ComGetObjValue(formObj.comment), 500) == 0) {
			ComShowCodeMessage("DMT00104", "Comment", "500");
			ComSetFocus(formObj.comment);
			return false;				
		}
        return true;	
    }
	function openWinSearchRFA() {
		var formObj=document.form;
		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
	    var params="s_prop_no=" + propNo;
	    var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    ComOpenWindow("ESM_PRI_2019.do?"+ params, "", sFeatures);
//		var formObj 	= document.form;
//		
//		var propNo		= ComTrim(ComGetObjValue(formObj.proposalNo));
//		var pgmNo 		= "ESM_PRI_2019";
//		var pgmUrl 		= "/opuscntr/ESM_PRI_2019.do";
//		var params 		= "&s_prop_no=" + propNo;
//		var parentPgmNo = pgmNo.substring(0, 8) + 'M001';   
//		var src 		= "&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
//		var sFeatures 	= "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
//		  
//		var winObj 		= window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures); 
	}
	function openWinSearchDARHistory() {
		var formObj=document.form;
		var cboDARObj=comboObjects[0 + plusComboCnt];
		var sheetRFAObj=sheetObjects[0];
		var rFANo=ComTrim(ComGetObjValue(formObj.rFANo));
		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
		var darNo=cboDARObj.GetSelectText();
		var verSeq=ComTrim(ComGetObjText(formObj.version));
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		var custNm=ComTrim(ComGetObjValue(formObj.custNm));
		var status=ComTrim(ComGetObjValue(formObj.status));
		var count 		= fetchRowCount(sheetRFAObj);
		var caller=ComTrim(ComGetObjValue(formObj.caller));
		if (caller == "2007") {
			isActBtnCopy="N";
		}
		else if (status == "" || status == "Temp. Saved" || status == "Counter Offered") {
			isActBtnCopy="Y";
		}
		else {
			isActBtnCopy="N";
		}
		var params="rfa_no=" 	+ rFANo;
		params += "&prop_no=" 	+ propNo;
		params += "&dar_no=" 	+ darNo;
		params += "&ver_seq=" 	+ verSeq;	
		params += "&cust_cd=" 	+ custCd;
		params += "&cust_nm=" 	+ custNm;
		params += "&status=" 	+ status;
		params += "&rowcount=" 	+ count + ""
		params += "&is_copy=" + isActBtnCopy;
		ComOpenPopup("EES_DMT_2105.do?" + params, 920, 480, "copyDARHistory", "0,1", true);		
	}
	function copyDARHistory(aryPopupData) {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var cboDARObj=comboObjects[0 + plusComboCnt];
		ComSetObjValue(formObj.rfa_expt_hist_dar_no,	aryPopupData[0]);
		ComSetObjValue(formObj.rfa_expt_hist_mapg_seq,	aryPopupData[1]);
		ComSetObjValue(formObj.rfa_expt_hist_ver_seq,	Number(aryPopupData[2]));
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_RFATARIFF_HISTORY);
		if (ComGetObjValue(formObj.result) == "Y") {
			if (cboDARObj.GetSelectText()== "") {
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
			}
			doActionRetrieve(IBSEARCH);
		}
		else {
			ComShowCodeMessage("DMT00008", "copy");
			return;
		}
	}
    function displayBtnByCaller() {
    	var formObj=document.form;
    	if (ComGetObjValue(formObj.caller) == "2007") {
//    		//Group Buttons
//    		btnAddRFALayer.style.display='none';
//    		btnCopyRFALayer.style.display='none';
//    		btnSaveRFALayer.style.display='none';
//    		btnDelRFALayer.style.display='none';
//    		//Multi Origin or Dest. Buttons
//    		btnAddMultiOrgDestLayer.style.display='none';
//    		btnDelMultiOrgDestLayer.style.display='none';
//    		//RateAdjustment Buttons
//    		btnAddAdjustmentLayer.style.display='none';
//    		btnDelAdjustmentLayer.style.display='none';
//    		//Main Buttons
//        	btnNewLayer.style.display='none';
//        	btnUpdateLayer.style.display='none';
//        	btnRequestLayer.style.display='none';
//        	btnCancelLayer.style.display='none';
//        	btnApprovalLayer.style.display='none';
//        	btnCounterOfferLayer.style.display='none';
//        	btnRejectLayer.style.display='none';
//			btnLineLayer.style.display='none';
//        	btnCloseLayer.style.display='inline';
    	}
    	else {
//    		//Group Buttons
//    		btnAddRFALayer.style.display='inline';
//    		btnCopyRFALayer.style.display='inline';
//    		btnSaveRFALayer.style.display='inline';
//    		btnDelRFALayer.style.display='inline';
//    		//Multi Origin or Dest. Buttons
//    		btnAddMultiOrgDestLayer.style.display='inline';
//    		btnDelMultiOrgDestLayer.style.display='inline';
//    		//RateAdjustment Buttons
//    		btnAddAdjustmentLayer.style.display='inline';
//    		btnDelAdjustmentLayer.style.display='inline';
//    		//Main Buttons
//        	btnNewLayer.style.display='inline';
//        	btnUpdateLayer.style.display='inline';
//        	btnRequestLayer.style.display='inline';
//        	btnCancelLayer.style.display='inline';
//        	btnApprovalLayer.style.display='inline';
//        	btnCounterOfferLayer.style.display='inline';
//        	btnRejectLayer.style.display='inline';
//			btnLineLayer.style.display='inline';
//        	btnCloseLayer.style.display='inline';   		
    	}
    }
    function isPermitRole() {
        var formObj=document.form;
		if (ComGetObjValue(formObj.role_permit) == "Y") return true;
		return false;
	}
	function isMatchOffice() {
	    var formObj=document.form;
		with(formObj) {
		    if (ComGetObjValue(approvalOfcCd) == ComGetObjValue(rhq_ofc_cd))
			    return true;
		}
		return false;
	}
	function isMatchVersion() {
	    var formObj=document.form;
		with(formObj) {
		    if (ComTrim(ComGetObjText(formObj.version)) == ComTrim(formObj.version.options[0].text))
			    return true;
		}
		return false;
	}
	function isPermitStatus(caller) {
	    var formObj=document.form;
	    var stsCd=getVerStatus("Code");
		if (caller == "Approval") {
			if (stsCd == "R")
			    return true;
		}
	    else if (caller == "CounterOffer") {
			if (stsCd == "R")
			    return true;
	    }
	    else if (caller == "Reject") {
			if (stsCd == "R")
			    return true;
	    }
	    else if (caller == "Update") {
			if (stsCd == "R" || stsCd == "C" || stsCd == "A" || stsCd == "J")
			    return true;
	    }
	    else if (caller == "Request") {
			if (stsCd == "" || stsCd == "O" || stsCd == "T")
			    return true;
	    }
	    else if (caller == "TempSave") {
			if (stsCd == "" || stsCd == "O" || stsCd == "T")
			    return true;
	    }		
		return false;
	}
    function handleNullString(sVal) {
         if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
         return ComTrim(sVal);
    }
    function isChangedBeforeException(initSheetNo) {
    	var result=new Array(); 
    	result[0]=false;
	   	if (initSheetNo == undefined) initSheetNo=0;
	    for (var sheetNo=initSheetNo ; sheetNo < sheetObjects.length - 1 ; sheetNo++) {
	       	with(sheetObjects[sheetNo]) {
	            for (var row=HeaderRows(); row <= LastRow(); row++) {
	            	switch(GetRowStatus(row)) {
		            	case "I":
		            		result[0]=true;
		            		result[1]=row;
		            		result[2]="추가";
		            		result[3]="sheetObjects[" + sheetNo + "] 의 " + GetCellValue(row, "Seq") + " 가  추가 되었습니다. 확인하세요";
		            		return result;
		            		break;
		            	case "U":
		            		result[0]=true;
		            		result[1]=row;
		            		result[2]="수정";
		            		result[3]="sheetObjects[" + sheetNo + "] 의 " + GetCellValue(row, "Seq") + " 가  수정 되었습니다. 확인하세요";
		            		return result;
		            		break;
		            	case "D":
		            		result[0]=true;
		            		result[1]=row;
		            		result[2]="삭제";		            		
		            		result[3]="sheetObjects[" + sheetNo + "] 의 " + GetCellValue(row, "Seq") + " 가  삭제 되었습니다. 확인하세요";
		            		return result;
		            		break;
	            	}
	            }
	       	}
        }
     	return result;
   }
    function isApprovedInPrevVersion() {
        var formObj=document.form;
		var result=new Array();
		result[0]=false;
		for (var idx=0 ; idx < formObj.version.length ; idx++) {
			var arrVersion=ComGetObjValue(formObj.version[idx]).split(":");
			if (arrVersion[0] == "A") {
				result[0]=true;
				result[1]=formObj.version[idx].text;
				break;
			}
		}
		return result;
    }
    function enableSearchFields(flag) {
        var formObj=document.form;
        var cboDARObj=comboObjects[0 + plusComboCnt];
        var cboAPVLObj=comboObjects[1 + plusComboCnt];
		with(formObj) {
			ComEnableManyObjects(flag, approvalOfcCd, version);
			if (flag) {
				version.className="input";
				approvalOfcCd.className="input1";
			}
			else {
				version.className="input2";
				approvalOfcCd.className="input2";
			}
		}
		cboDARObj.SetEnable(flag);
		cboAPVLObj.SetEnable(flag);
    }
   function convertEmptyToSpace(sVal) {
   	if (sVal == "")
   		return "' '";
   	else
   		return "'" + sVal + "'";
   } 
   
	/*
	 * Tiered Free Time add.
	 */		
	function addFreeTime() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetFTObj=sheetObjects[3];
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
				SetCellValue(iRow, 	DAR_NO	, sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO)		, 0);
				SetCellValue(iRow, 	MAPG_SEQ, sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), MAPG_SEQ)	, 0);
				SetCellValue(iRow, 	VER_SEQ	, sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER_SEQ)		, 0);
				SetCellValue(iRow, 	DTL_SEQ	, sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ)		, 0);
				SetCellValue(iRow, 	CVRG_SEQ, sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_SEQ)	, 0);
				
				SetCellValue(iRow, 	FT_SEQ,ftSeq,0);
				SetCellValue(iRow, 	FT_FROM,ftFrom,0);
				SetCellEditable(iRow, 	FT_FROM,0);
			}
		}
	}  
   
	/*
	 * Commodity add.
	 */		
	function addCommodity() {
		var sheetRFAObj=sheetObjects[0];		 
		var sheetCMDTObj=sheetObjects[4];
		if (fetchRowCount(sheetCMDTObj) > 0 && fetchColumnValueOfLastRow(sheetCMDTObj, CMDT_CD) == "") {
			ComShowCodeMessage("DMT02002", "Code");
			return;					
		}
		var iRow = sheetCMDTObj.DataInsert(-1);
		var iRow2 = sheetRFAObj.GetSelectRow();
		
		sheetCMDTObj.SetCellValue(iRow, 	DAR_NO	, sheetRFAObj.GetCellValue(iRow2, DAR_NO)	, 0);
		sheetCMDTObj.SetCellValue(iRow, 	MAPG_SEQ, sheetRFAObj.GetCellValue(iRow2, MAPG_SEQ)	, 0);
		sheetCMDTObj.SetCellValue(iRow, 	VER_SEQ	, sheetRFAObj.GetCellValue(iRow2, VER_SEQ)	, 0);
		sheetCMDTObj.SetCellValue(iRow, 	DTL_SEQ	, sheetRFAObj.GetCellValue(iRow2, DTL_SEQ)	, 0);
		sheetCMDTObj.SetCellValue(iRow, 	CVRG_SEQ, sheetRFAObj.GetCellValue(iRow2, CVRG_SEQ)	, 0);
	}
	

   /**
	* RFA Exception Tariff 의 Free Time Change is the status of the function
	*/
	function setTieredFreeTimeGrid() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
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
	 * RFA Exception Tiered Free Time all of the information given is set to allow the flag state.
	 */		
	function editableTieredFreeTime(flag) {
		var sheetFTObj=sheetObjects[3];
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
	* RFA Exception Tariff  Commodity Change is the status of the function
	*/
	function setCommodityGrid() {
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
			if (GetCellValue(GetSelectRow(), ROW_EDIT_STS) == "Y") {
				editableCommodity(true);
			}
			else {
				editableCommodity(false);
			}
		}
	}
	/**
	 * RFA Exception Commodity all information given is set to allow the flag state.
	 */		
	function editableCommodity(flag) {
		var sheetCMDTObj=sheetObjects[4];
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
	 * Tiered Free Time Sheet for an item in the Validation checked.
	 */			
	function validateTieredFreeTime(selectedRow) {
		var sheetRFAObj=sheetObjects[0];
		var sheetFTObj=sheetObjects[3];
		//If the last Row, CNTR QTY of the From, Total required input, Up to the Empty should be.
		if (isEmptyColumnOfLastRow(sheetFTObj, FT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetFTObj, FT_UPTO)) {
			ComShowCodeMessage("DMT02005", sheetRFAObj.GetCellValue(selectedRow, "Seq"));
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetFTObj, FT_DAYS)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.GetCellValue(selectedRow, "Seq"), "Total");
			return false;
		}
		//From Up to and equal to or greater than the number known to enter
		with(sheetFTObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
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
     * comment onblur event
     */ 
    function comment_Change(){
        obj=document.form.comment;
    	var comment = checkSpecial(ComGetObjValue(obj));  //특수문자 제외 로직
    	ComSetObjValue(obj, comment);
    } 

