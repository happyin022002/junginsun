/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_DMT_2005.js
*@FileTitle  : DEM/DET Adjustment Request - Before Booking Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	// Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;	
	// Defining Action
	var IBSEARCH_VER=101;
	var IBSEARCH_PROPNO=102
	var IBSEARCH_RFANO_CUST=103;
	var IBSEARCH_APRO=106;
	var IBSEARCH_CUST=107;
	var IBSEARCH_VER_APVLNO=108;
	var IBSEARCH_APVLOFC=109;
	var IBSEARCH_CHECK_ROLE=110;
	var IBSEARCH_SUB=111;
	var IBSEARCH_APRO_NO=112;
	var IBSEARCH_VER_CHECK=113;
	var IBSAVE_DAR=201;
	var IBSAVE_VERSTS=202;
	var IBSAVE_CANCEL=203;
	var IBSAVE_APPROVAL=204;
	var IBSAVE_COUNTER=205;
	var IBSAVE_REJECT=206;
	// Defining data unit separator
	var ROWMARK="|";
	var FIELDMARK="=";
	var TARIFF="dmdt_trf_cd";
	var EFF_DT="eff_dt";
	var EXP_DT="exp_dt";
	var CNTRCGO="dmdt_cntr_cgo_tp_txt";
	var CVRG_CTI="cvrg_conti_cd";
	var CVRG_CNT="cvrg_cnt_cd";
	var CVRG_RGN="cvrg_rgn_cd";
	var CVRG_STE="cvrg_ste_cd";
	var CVRG_LOC="cvrg_loc_cd";
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
	var ORGDST_CTI="org_dest_conti_cd";
	var ORGDST_CNT="org_dest_cnt_cd";
	var ORGDST_RGN="org_dest_rgn_cd";
	var ORGDST_STE="org_dest_ste_cd";
	var ORGDST_LOC="org_dest_loc_cd";
	var BKGDEL_CTI="fnl_dest_conti_cd";	
	var BKGDEL_CNT="fnl_dest_cnt_cd";
	var BKGDEL_RGN="fnl_dest_rgn_cd";
	var BKGDEL_STE="fnl_dest_ste_cd";
	var BKGDEL_LOC="fnl_dest_loc_cd";
	var REMARK="expt_trf_rmk";
	var FULL_REMARK="full_expt_trf_rmk";
	var DAR_NO="rfa_expt_dar_no";
	var MAPG_SEQ="rfa_expt_mapg_seq";
	var VER_SEQ="rfa_expt_ver_seq";
	var DTL_SEQ="rfa_rqst_dtl_seq";
	var CVRG_SEQ="cvrg_cmb_seq";
	var CURR_CD="curr_cd";
	var RQST_STS_CD="dmdt_expt_rqst_sts_cd";
	var RQST_STS_DESC="dmdt_expt_rqst_sts_desc";
	var PROG_DT="prog_dt";
	var PROG_OFC_CD="prog_ofc_cd";
	var PROG_USR_NM="prog_usr_nm";
	var PROG_RMK="prog_rmk";
	// real hidden of Request Detail items
	var HID_STATUS="hidden_status";
	// Actual Customer
	var CUST_CD="cust_cd";
	var CUST_NM="cust_nm";
	// case in  Proposal No.is changed, then it need searching condition , for RFA No. Customer, Affiliate, Version 
	// 위해서 사용하는 변수
	var prevPropNo="";
	// case in DAR No.is changed,  then it need searching condition for Version
    var prevDarNo="";
	// case inApproval No. is changed,  then it need searching condition for Version
    var prevApvlNo="";
    var prevActStatus="";
  	// selected  Row status
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
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         var sheetObject5=sheetObjects[4];
         var sheetObject6=sheetObjects[5];
         /** **************************************************** */
         var formObject=document.form;
    	try {
    		var srcName = ComGetEvent("name");
    		
    		if (!ComIsBtnEnable(srcName)) return;
    		
            switch(srcName) {
	        	case "btn_Affiliate":
					doProcessPopup("Affiliate");
				break;
				
	        	case "btn_Retrieve":
					doActionRetrieve();
				break;
				
				case "btn_New":
					doActionNew();
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
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		
	   	//Displays a pop-up title at the call handling
        if (isPopupWindow()) {
	        var spanObj=document.getElementById("title");
	       	spanObj.innerText=" DEM/DET Adjustment Request - Before Booking Approval";
	       	if (ComGetObjValue(formObj.caller) == "3107") {
	       		btnCloseLayer.style.display="block";
	       	}
	       	else {
	       		//display popup menu button
	       		btnPopUpLayer.style.display="block";
	       	}
	   	}
        else {
        	//display popup menu button
        	btnMainLayer.style.display="block";
        }
        for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    axon_event.addListener('blur', 'comment_Change', 'comment'); 
		//1.initializing html control event
		initControl();
		// 2.Load on the screen, deactivating makes initializing The controls to be.
		initDisableObjects();
   		// 3.check Security of login User
   		doActionIBCommon(sheetObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);
   		// 4.check pup up or main
   		if (isPopupWindow()) {
			//4-1. called  2006 Screen by duble click event
			doActionRetrieve();
		}
		else {
			//4-2.in Loading Main Screen,  button initializing .
			ComBtnEnable(	"btn_Retrieve"		);
			ComBtnEnable(	"btn_New"			);
			ComBtnDisable(	"btn_Approval"		);
			ComBtnDisable(	"btn_CounterOffer"	);
			ComBtnDisable(	"btn_Reject"		);
		}
    }
 	function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); 
//  		axon_event.addListener('keydown', 'ComKeyEnter', 'darNo');
//  		axon_event.addListener('keydown', 'ComKeyEnter', 'approvalNo');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
 	function initDisableObjects() {
		var formObj=document.form;
		with(formObj) {
			//in Loading pop up,   DAR No., APVL No.are deactivating 
			// in Loading pop up, initializing deactivating 
			if (isPopupWindow()) {
				ComEnableManyObjects(false, darNo, approvalNo);
	        	darNo.className="input2";
	        	approvalNo.className="input2";
			}
			//in Loading main, DAR No., APVL No. is activating 
			else {
				ComEnableManyObjects(true, darNo, approvalNo);
	        	darNo.className="input";
	        	approvalNo.className="input";
			}
        	ComEnableManyObjects(false, rFANo, proposalNo, custCd, custNm, approvalOfcCd, status, currency, chkMultiOrgDest, chkRateAdjustment);
        	rFANo.className="input2";
        	proposalNo.className="input2";
        	custCd.className="input2";
        	custNm.className="input2";
        	approvalOfcCd.className="input2";
        	status.className="input2";
        	currency.className="input2";
        	chkMultiOrgDest.className="trans";
        	chkRateAdjustment.className="trans";
			comment.readOnly=true;
			comment.style.backgroundColor="#E8E7EC";
		}		
	}     
	//business javascript OnKeyPress event handling
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				// upper case + numbers 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
 		    	//  upper case + numbers + exceptional letters
          		DmtComKeyOnlyAlphabet('uppernum', ',. ');
 		        break;
          	case "engup3":
          		//change upper case
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
	}  
    /**    
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        sheetObj.ToolTipOption="balloon:true;width:50;";
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            	with(sheetObj){
                var HeadTitle1="|Seq.|Tariff|EFF DT|EXP DT|CNTR/Cargo Type|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|Actual Customer|Actual Customer|Remark";
                var HeadTitle2="|Seq.|Tariff|EFF DT|EXP DT|CNTR/Cargo Type|CN|RGN|LOC|Y|Tier|Add|Total|SAT|SUN|H/day|Multi|CT|CN|RGN|LOC|CN|RGN|LOC|Code|Name|Remark";
                
                SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:100, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                                { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:CNTRCGO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:FT_FLG,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Combo",  	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:FT_TIR,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ADD_DYS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTipText:"Additional Day" },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TOT_DYS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTipText:"Total Day" },
                             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_MULTI,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CTI,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CNT,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_RGN,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_LOC,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CNT,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_RGN,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_LOC,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:CUST_NM,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:REMARK,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DAR_NO,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DTL_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_CD,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:FULL_REMARK,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_CTI,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CTI,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RQST_STS_CD,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_MANDATORY,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RT_CHECK,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                
                SetColProperty(ORGDST_MULTI, {ComboText:"Single|Multi", ComboCode:"S|M"} );
	            SetColProperty(FT_TIR, {ComboText:"Single|Multi", ComboCode:"S|M"} );//[2016.01.04] NYK Add
                SetCountPosition(0);
                //SetSheetWidth(mainTable.clientWidth);
                SetSheetHeight(185);
                SetEditable(1);
                SetShowButtonImage(2);
            	}
            break;
            
            case "sheet2":
            	with(sheetObj){
            	var HeadTitle1="|Seq.|BKG POR|BKG POR|BKG POR|BKG POR";
            	var HeadTitle2="|Seq.|Continent|Country|Region|Location";
            	SetConfig( { SearchMode:2, MergeSheet:5, DataRowMerge:0 } );
            	var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
            	var headers=[ { Text:HeadTitle1, Align:"Center"},
            	{ Text:HeadTitle2, Align:"Center"} ];
            	InitHeaders(headers, info);
            	var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_CTI,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:CVRG_CTI,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            	//SetSheetWidth(mainTable.clientWidth);
            	SetSheetHeight(122);
            	SetCountPosition(0);
            	SetEditable(1);
            	}
            break;
            
            case "sheet3":
            	with(sheetObj){
            	var HeadTitle1="|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
            	var HeadTitle2="|From|Up To|20 FT|40 FT|H/C|45 FT";
            	SetConfig( { SearchMode:2, MergeSheet:5, DataRowMerge:0 } );
            	var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
            	
            	var headers=[ { Text:HeadTitle1, Align:"Center"},
            	{ Text:HeadTitle2, Align:"Center"} ];
            	InitHeaders(headers, info);
            	var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:RT_FROM,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:RT_UPTO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_20FT,       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_40FT,       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_HC,         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:RT_45FT,       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:undefined, ColMerge:1,   SaveName:DAR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:undefined, ColMerge:1,   SaveName:VER_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:undefined, ColMerge:1,   SaveName:DTL_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:undefined, ColMerge:1,   SaveName:RT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:HID_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	InitColumns(cols);
            	//SetSheetWidth(mainTable.clientWidth);
            	SetSheetHeight(122);
            	SetCountPosition(0);
            	SetEditable(1);
            	}
            break;
            
            case "sheet4":
            	with(sheetObj){
            	var HeadTitle1="|Seq.|Status|Date|Office|Name";
            	var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
            	var headers=[ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);
            	SetConfig( { SearchMode:2, DataRowMerge:0 } );
            	var cols=[ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
            	{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:RQST_STS_DESC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            	{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:PROG_DT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            	{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:PROG_OFC_CD,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            	{Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:PROG_USR_NM,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            	{Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:PROG_RMK,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
            	InitColumns(cols);
            	//SetSheetWidth(mainTable.clientWidth);
            	SetSheetHeight(122);
            	SetCountPosition(0);
            	SetEditable(1);
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
								{Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:FT_FROM,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:FT_UPTO,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:FT_DAYS,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
					
					var cols = [ {Type:"Status",   Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:CMDT_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
	// Process of Sheet
    function doActionIBSheet(sheetObj, formObj, sAction) {
    		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			// search
			case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					//1.Setting parametor condition, before retrieving
					ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
					ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
					ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	"");
					ComSetObjValue(formObj.f_cmd, 				SEARCH);
					// 2.retrievie according to conditions
					// *********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					sheetObjects[0].SetWaitImageVisible(0);
					sheetObjects[5].SetWaitImageVisible(0);
					// *********************************************************************************
                    var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
					// 3.Result mapping in each Grid, after retrieving 
		            var arrXml=sXml.split("|$$|");
					// 3-1.grid initializing 
		            sheetObjects[0].RemoveAll();	// Before Booking Request
					sheetObjects[5].RemoveAll();	// Comment History
					// 3-2.Load result.
	            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[0].LoadSearchData(arrXml[0], {Sync:1});
					if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[5].LoadSearchData(arrXml[1], {Sync:1});
					// *********************************************************************************
					// *********************************************************************************
					// 3-3.Comment History setting
					formObj.chkComment.checked=false;
					formObj.comment.style.backgroundColor="#E8E7EC";
				}
				else if (sheetObj.id == "sheet3") {
					var sheetObj1=sheetObjects[0];
					// 1.Setting parametor condition, before retrieving
					var customerCd=ComTrim(formObj.custCd.value);
					ComSetObjValue(formObj.cust_cnt_cd, customerCd.substring(0,2));
					ComSetObjValue(formObj.cust_seq, 	customerCd.substring(2));					
					ComSetObjValue(formObj.f_cmd, 		SEARCH01);
					// 2.retrievie according to conditions
					// *********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					// *********************************************************************************
                    var result=ComSearchEtcData(sheetObj, "EES_DMT_2001GS.do", FormQueryString(formObj),"RATE");
					// *********************************************************************************
					ComOpenWait(false);
					// *********************************************************************************
					// 3.After handling Retrieving results
					ComSetObjValue(formObj.result, result);					
				}
				break;
	        case IBSEARCH_SUB:			
				//1.Setting parametor condition, before retrieving
				var iRow=sheetObj.GetSelectRow();
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.GetCellValue(iRow, DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.GetCellValue(iRow, MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.GetCellValue(iRow, VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.GetCellValue(iRow, DTL_SEQ));
				ComSetObjValue(formObj.cvrg_cmb_seq, 		sheetObj.GetCellValue(iRow, CVRG_SEQ));
				ComSetObjValue(formObj.f_cmd, 				SEARCH17);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObjects[1].SetWaitImageVisible(0);
				sheetObjects[2].SetWaitImageVisible(0);
				
				//[2016.01.04] NYK Add
				sheetObjects[3].SetWaitImageVisible(0);
				sheetObjects[4].SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// 3.Result mapping in each Grid, after retrieving 
	            var arrXml=sXml.split("|$$|");
				// 3-1. initializing  grid 
	            sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				
				//[2016.01.04] NYK Add
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				// 3-2.Load  results
            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[1].LoadSearchData(arrXml[0], {Sync:1});
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[2].LoadSearchData(arrXml[1], {Sync:1});
				
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[2]) > 0) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[3]) > 0) sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				break;	 
			// 1.Search Proposal No. by DAR No. or APVL No.
			case IBSEARCH_PROPNO:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 				SEARCH05);
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.rfa_expt_apro_no, 	ComTrim(ComGetObjValue(formObj.approvalNo)));
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.After handling Retrieving results
	            var propNo=ComTrim(ComGetEtcData(sXml, "PROP_NO"));
	            if (propNo != "") {
	            	ComSetObjValue(formObj.result, 		"Y");
	            	ComSetObjValue(formObj.proposalNo, 	propNo);
	            }
	            else {
	            	ComSetObjValue(formObj.result, 		"N");
	            }
	            if (ComTrim(ComGetObjValue(formObj.darNo)) == "")
	            	ComSetObjValue(formObj.darNo, 		ComGetEtcData(sXml, "DAR_NO"));
				break;	
			// 2.Search Customer Name 
			case IBSEARCH_RFANO_CUST:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, 				SEARCH14);
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.After handling Retrieving results
	            ComSetObjValue(formObj.custCd, ComGetEtcData(sXml, "CUST_CD"));
	            ComSetObjValue(formObj.custNm, ComGetEtcData(sXml, "CUST_NM"));
	            ComSetObjValue(formObj.rFANo, ComGetEtcData(sXml, "RFA_NO"));
				break;	
			// 3.Search  VER No.
			case IBSEARCH_VER:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH02);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2005GS.do", FormQueryString(formObj), "VER");
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 4.setting selected verson info.
				var ver_value=ComGetObjValue(formObj.version);
				// 3.Result mapping in each Grid, after retrieving 
				if (comboDatas != undefined) {
					addComboItem(formObj.version,comboDatas,false);
				}
				if(ver_value != "") {
					ComSetObjValue(formObj.version, ver_value);
				}
				break;
			// 3.Search current VER No. 
			case IBSEARCH_VER_CHECK:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH02);
				// 2.retrievie according to conditions
				// *********************************************************************************
				// ComOpenWait(true);
				// sheetObj.WaitImageVisible = false;
				// *********************************************************************************
                var sVer=ComSearchEtcData(sheetObj, "EES_DMT_2005GS.do", FormQueryString(formObj), "VER");
				// *********************************************************************************
				// ComOpenWait(false);
				// *********************************************************************************
				// 3.Result mapping in each Grid, after retrieving 
				var verList=handleNullString(sVer);
				var val=getMaxVersion(verList);
				ComSetObjValue(formObj.max_ver, val);	//Search  max_version 
				var val2=getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
				break;
			// 4.Search  Approval Office Code.
			case IBSEARCH_APVLOFC:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH16);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2005GS.do", FormQueryString(formObj), "APVLOFC");
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.Result mapping in each Grid, after retrieving 
				ComSetObjValue(formObj.approvalOfcCd, comboDatas);
				break;
			// 5.Search  VER No. 
			case IBSEARCH_VER_APVLNO:
				//1.Setting parametor condition, before retrieving
				// ComSetObjValue(formObj.rfa_expt_apro_no,
				// ComGetObjText(formObj.rfa_expt_apro_no));
				ComSetObjValue(formObj.rfa_expt_apro_no, 	ComGetObjValue(formObj.approvalNo));
				ComSetObjValue(formObj.f_cmd, 				SEARCH15);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2005GS.do", FormQueryString(formObj), "VER");
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.Result mapping in each Grid, after retrieving 
	            setComboText(formObj.version,comboDatas);
				break;
			// Search  Approval No.info
			case IBSEARCH_APRO:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH11);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var comboDatas=ComSearchEtcData(sheetObj, "EES_DMT_2005GS.do", FormQueryString(formObj), "APRO");
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.Result mapping in each Grid, after retrieving 
				if (comboDatas != undefined) {
					var aproArr=comboDatas.split(FIELDMARK);
					ComSetObjValue(formObj.approvalNo, aproArr[0]);
				}
				else {
					ComSetObjValue(formObj.approvalNo, "");
				}
				break;							
			case IBSEARCH_APRO_NO:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.prop_no,				ComTrim(ComGetObjValue(formObj.proposalNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH18);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sApvlNo=ComSearchEtcData(sheetObj, "EES_DMT_2005GS.do", FormQueryString(formObj), "APVL_NO");
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.Result mapping in each Grid, after retrieving 
				ComSetObjValue(formObj.approvalNo, sApvlNo);
				break;					
			// Search  Customer info.
			case IBSEARCH_CUST:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 				SEARCH12);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.Result mapping in each Grid, after retrieving 
	            var comboDatas=ComGetEtcData(sXml, "CUST_CD");
				if (comboDatas != undefined) {
					ComSetObjValue(formObj.custCd, comboDatas);
					comboDatas=ComGetEtcData(sXml, "CUST_NM");
					ComSetObjValue(formObj.custNm, comboDatas);
				}	            
				else {
					ComClearObject(formObj.custCd);
					ComClearObject(formObj.custNm);
				}
				break;				
			case IBSAVE_VERSTS:
				//1.Version status information before the change request, the selected parameter set to enter or allow.
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH10);
				// 2.Running modified input conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2001GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				break;
			case IBSAVE_APPROVAL:
				//1.Before deleting, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"A");
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Approved");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		ComGetObjValue(formObj.approvalNo));
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				ComSetObjValue(formObj.f_cmd, 					SEARCH08);					
				// 2.Delete the selected running conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.After deleting the result handle
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
			case IBSAVE_COUNTER:
				//1.Before deleting, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"O");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Counter Offered");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				ComSetObjValue(formObj.f_cmd, 					SEARCH09);				
				// 2.Delete the selected running conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.After deleting the result handle
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
			case IBSAVE_REJECT:
				//1.Before deleting, the parameter is set to a value type or allows selected.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"J");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Rejected");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				ComSetObjValue(formObj.f_cmd, 					SEARCH10);
				// 2.REJECT with selected running conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("EES_DMT_2005GS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.After processing the results REJECT
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
		}
    }
	/**
	 * Common module functions to Inquiry
	 */	
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
    	sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	    	//2005 Screen on the ROLE that is Inquiry.
	    	case IBSEARCH_CHECK_ROLE:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				// 2.retrievie according to conditions
				// *********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// *********************************************************************************
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				// *********************************************************************************
				ComOpenWait(false);
				// *********************************************************************************
				// 3.After handling Retrieving results
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));
				break;
	    }
		sheetObj.SetWaitImageVisible(1);
	}
	function sheet4_OnSearchEnd(sheetObj,Code, Msg, StCode, StMsg){
	    var formObj=document.form;
		with(sheetObj) {
			if (RowCount()> 0) {
				ComSetObjValue(formObj.comment, GetCellValue(HeaderRows(), PROG_RMK));
			}
			else {
				ComSetObjValue(formObj.comment, "");
			}
			//Comment deactivating +++++++++++++++++++++++++++++++++
			// ComEnableObject(formObj.comment, false);
			formObj.comment.readOnly=true;
			formObj.comment.className="textarea2";
			// ++++++++++++++++++++++++++++++++++++++++++++++++
		}						    
		ComOpenWait(false);
	}
   /**
	* Align the current selection state of ROW has been chosen to handle it functions to maintain
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
	    var iRow=sheetObj.FindText(DTL_SEQ, currDtlSeq);
	    if (iRow>0) SetSelectRow(row);
	}
	/**
	 *Row when it is selected, conditions will change the status of the Row.
	 */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		//Row selected whenever there is a change in position to perform the following logic.
		if (OldRow >= sheetObj.HeaderRows()&& OldRow != NewRow) {
			//-------------------------------------------
			currDtlSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), DTL_SEQ);
			// -------------------------------------------
			// Detail Seq selected sub-information shall be updated to match. (Parameter indicates're going to look up the sub-items.)
			setSubBeforeException(true);
		}		
	}	 
	/**
	 * Mouse over to Sheet1 if the tooltip displays information according to each field
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		with(sheetObj) {
			var colName=ColSaveName(MouseCol());
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					// if Tariff = DMOF , balloon message "BKG POL/CY"
					// if Tariff = DMIF , balloon message "BKG POD/CY"
					// if Tariff = DTOC or  CTOC ,  balloon message "BKG POR"
					// if Tariff = DTIC or CTIC  ,  balloon message "BKG DEL"
					switch(trfCd) {
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					// if Tariff =  DMOF or DTOC or CTOC ,  balloon message "BKG DEL"
					// if Tariff =  DMIF or DTIC or CTIC ,  balloon message "BKG POR"
					switch(trfCd) {
						case "DMOF":
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					var trfCd=GetCellValue(MouseRow(), TARIFF);
					// if Tariff =  DMIF ,  balloon message "BKG DEL for Demurrage Only"
					// if Tariff =  DMOF ,  balloon message "BKG POR for Demurrage Only"
					switch(trfCd) {
					case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL for Demurrage Only"); break;
					case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POR for Demurrage Only"); break;
					default: SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}				
				else if (colName == REMARK)	{
					SetToolTipText(MouseRow(), MouseCol(), GetCellValue(MouseRow(), FULL_REMARK));
				}		
			}
		}		
	}
	/**
	 * Row when selected, shows the corresponding Comment.
	 */	
	function sheet4_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj=document.form;
		// Row selected whenever there is a change in position to perform the following logic.
		if (OldRow >= sheetObj.HeaderRows()&& OldRow != NewRow) {
			ComSetObjValue(formObj.comment, sheetObj.GetCellValue(NewRow, PROG_RMK));
		}		
	}
	/**
	 * Before Booking Request Detail registered in the data retrieval functions that define the behavior
	 */		
	function doActionRetrieve() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		var sheetCVRGObj=sheetObjects[1];
		var sheetRTObj=sheetObjects[2];
		var sheetHSTObj=sheetObjects[5];

		// 1.Inquiry before, DAR No or APVL No one necessarily must be entered.
		var currDarNo=ComTrim(ComGetObjValue(formObj.darNo));
		var currApvlNo=ComTrim(ComGetObjValue(formObj.approvalNo));
		if (currDarNo == "" && currApvlNo == "") {
			ComShowCodeMessage("DMT02002", "DAR No. or APVL No.");
			ComSetFocus(formObj.darNo);
			return;
		}
		
		//2.search Proposal No  information  by DAR No or APVL No
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_PROPNO);
		if (ComGetObjValue(formObj.result) == "N") {
			ComShowCodeMessage("DMT06001");
			ComSetFocus(formObj.darNo);
			return;
		}
		var currPropNo=ComTrim(ComGetObjValue(formObj.proposalNo));
		
		// 3.Proposal No referrals are different only if the information below is performed.
		if (prevPropNo != currPropNo) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_RFANO_CUST);
		}

		//4.Proposal No. Or DAR No. Or Approval No. More information about the changes, Version gives resetting.
		if (prevPropNo != currPropNo || prevDarNo != currDarNo || prevApvlNo != currApvlNo) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APVLOFC);
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER);
			if (ComTrim(ComGetObjValue(formObj.approvalNo)) != "") {
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_APVLNO);
			}
			ComSetObjValue(formObj.status, getVerStatus("Text"));
			if (getVerStatus("Code") == "A") {
				//doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO_NO);
			}
		}
		//arching conditions for the field information in order to re-Inquiry, or whether to set the variables below.
		prevPropNo=currPropNo;
		prevDarNo=currDarNo;
		prevApvlNo=currApvlNo;
		
		// 4.DEM/DET Adjustment Request - Before Booking Request information and Comment
		// Search History .
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH);
		// --------------------------------------------------------------------
		currDtlSeq=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DTL_SEQ);
		// --------------------------------------------------------------------

		// 5.If you have a query result
		if (sheetRFAObj.RowCount()> 0) {
			//5-1.DAR No. and APVL No. are deactivating  
			with(formObj) {
				ComEnableManyObjects(false, darNo, approvalNo);
				darNo.className="input2";
				approvalNo.className="input2";
			}
			//Detail Seq selected sub-information shall be updated to match. (Parameter indicates're going to look up the sub-items.) 
			setSubBeforeException(true);
		}
		else {
			//detail initializing  grid 
			sheetCVRGObj.RemoveAll();
			sheetRTObj.RemoveAll();
			sheetHSTObj.RemoveAll();
			// Initializing information makes a sub: (parameter indicates whether to retrieve the sub-item.)
			setSubBeforeException(false);			
		}
//		formObj.approvalNo.value = currApvlNo;
		// 6.the status of the main button, makes activating or deactivating depending on the given conditions.
		initBtnControl();
	}
   /**
	* Detail list of Before Exception Request, select the Detail Seq has changed to change the status of the sub-item.
	*/	
    function setSubBeforeException(isRetrieve) {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		//searching  sub-items of Detail Seq 
		if (isRetrieve) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_SUB);
		}
		//1.Tariff is selected depending on the type, Multi Coverage of the title is changed.
		setMultiOrgDestTitle();
		// 2.Multi Coverage check box and input status makes changes.
		setMultiOrgDestGrid();
		// 3. the check box and input status of Rate Adjustment  makes changes.
		setRateAdjustmentGrid();
		
		//[2016.01.04] NYK Add.
		setTieredFreeTimeGrid();
		//setCommodityGrid();
	}
   /**
	* Before Booking Request 의 Multi Origin or Dest. Change is the status of the function
	*/
	function setMultiOrgDestGrid() {
		var formObj=document.form;
		var sheetRFAObj=sheetObjects[0];
		with(sheetRFAObj) {
			//=================================================================================================================================
			// if type of Origin or Dest is  Multi type , then checked Multi  Checkbox of  Origin or Dest.
			// =================================================================================================================================
			if (GetCellValue(GetSelectRow(), ORGDST_MULTI) == "M") {
				formObj.chkMultiOrgDest.checked=true;
			}
			else {
				formObj.chkMultiOrgDest.checked=false;
			}
		}
	}
   /**
	* Before Booking Request 의 Rate Adjustment Change is the status of the function
	*/
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
			ComSetObjValue(formObj.currency, GetCellValue(GetSelectRow(), CURR_CD));
		}
	}
   /**
    * If Version is changed, the data is Inquiry.
    */		 
    function checkRFAByVersion() {
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	var version=ComTrim(ComGetObjValue(formObj.version));
    	if (version != "") {
			ComClearObject(formObj.approvalNo);	
			ComClearObject(formObj.status);		
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			formObj.comment.value="";		
			if (getVerStatus("Code") == "A") {
				//doActionIBSheet(sheetObj, formObj, IBSEARCH_APRO);
				doActionIBSheet(sheetObj, formObj, IBSEARCH_APRO_NO);
			} 			
			ComSetObjValue(formObj.status, getVerStatus("Text"));
			doActionRetrieve(); 			
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
     * multi Data in the field adds a combo.
     */	
	function addMultiComboItem(comboObj,comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
			if (ComTrim(comboItems[i]) != "") {
    			var comboItem=comboItems[i].split(FIELDMARK);
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			}
    	}
	}
    /**
     * Given value of the items in the same combo field, locate and select the Text allows.
     */	
 	function setComboText(comboObj,comboItem) {
     	for (var i=0 ; i < comboObj.length ; i++) {
     		if (comboObj[i].text == comboItem) {
     			comboObj[i].selected=true;
     			break;
     		}
     	}
 	}
	/**
	 * If you click NEW button executes the function that defines the behavior of
	 */		
	function doActionNew() {
		var formObj=document.form;
		// 1.Empty lookup field makes them.
		ComClearObject(formObj.rFANo);	
		ComClearObject(formObj.proposalNo);
		ComClearObject(formObj.custCd);
		ComClearObject(formObj.custNm);
		ComClearObject(formObj.approvalOfcCd);
		ComClearObject(formObj.darNo);
		ComClearCombo(formObj.version);
		ComClearObject(formObj.approvalNo);
		ComClearObject(formObj.status);
		// 1-1.activating searching fields
		enableConditionObjects(true);		
		// 2.Empty Grid makes all of the query results.
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[5].RemoveAll();
		// 3.Multi Origin or Dest. , Rate Adjustment and Comment control initializing the status makes to Disable.
		with(formObj) {
			chkMultiOrgDest.checked=false;
			chkRateAdjustment.checked=false;
			ComSetObjValue(currency, "");
			// Comment initializing +++++++++++++++++++++++++++++++++++
			chkComment.checked=false;
			comment.readOnly=true;
			comment.className="textarea2";
			ComSetObjValue(comment, "");
			// +++++++++++++++++++++++++++++++++++++++++++++++++
		}		
		//4.button makes initializing status.
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnDisable("btn_Approval");
		ComBtnDisable("btn_CounterOffer");
		ComBtnDisable("btn_Reject");
		// 5.Click the New button then, re-referral to Empty below for initializing variables should be.
		prevPropNo="";
		prevDarNo="";
		prevApvlNo="";
	}
	/**
	 * searching fields Change is the status of the function
	 */				
	function enableConditionObjects(flag) {
		var formObj=document.form;
		with(formObj) {
			ComEnableManyObjects(flag, darNo, version, approvalNo);
			darNo.className="input";
			version.className="input2";
			approvalNo.className="input";
		}		
	}
	/**
	 * APPROVAL button is clicked, the function is executed to define the behavior
	 */				
	function doActionApproval() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		// The VERSION look up information on the current DB, Screen and check on the VERSION information
		doActionIBSheet(sheetObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","Retrieve");// Version()status has
														// changed. Pls click
														// New button
			return;
		}
		//=====================================================================================================			
		if (!ComShowCodeConfirm("DMT00135", "approve")) { return; }
		//APPROVAL runtime, Comment are required fields.		
		if (!validateComment()) return;	
		// 2.Approval Action is performed.
		doActionIBSheet(sheetObj,formObj,IBSAVE_APPROVAL);
		// 3.Action Save the normal runtime, the searching is executed.
		if (ComGetObjValue(formObj.result) == "Y") {
			//In 2006 Screen pop-up window opened, the current Screen executed in accordance with Action for 2006 Screen Enabled to reflect on the results retrieved.
			prevActStatus=ComGetObjValue(formObj.status);
			prevPropNo="";
			prevDarNo="";
			prevApvlNo="";
			doActionRetrieve();
		   	// 2006 (DEM / DET Adjustment Request & Approval Status) Screen has been called on
			// approved  History  reflected in  Main Screen.
	        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("Approval");
	        }
		}
	}
	/**
	 * COUNTER OFFER button is clicked, the function is executed to define the behavior
	 */				
	function doActionCounterOffer() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		// The VERSION look up information on the current DB, Screen and check on the VERSION information
		doActionIBSheet(sheetObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","Retrieve");// Version()status has
														// changed. Pls click
														// New button
			return;
		}
		//=====================================================================================================	
		if (!ComShowCodeConfirm("DMT00135", "counter offer")) { return; }
		//COUNTER OFFER runtime, Comment are required fields.	
		if (!validateComment()) return;			
		// 2.Counter Offer Action to perform.
		doActionIBSheet(sheetObj,formObj,IBSAVE_COUNTER);
		// 3.Action Save the normal runtime, the searching is executed.
		if (ComGetObjValue(formObj.result) == "Y") {
			//In 2006 Screen pop-up window opened, the current Screen executed in accordance with Action for 2006 Screen Enabled to reflect on the results retrieved.
			prevActStatus=ComGetObjValue(formObj.status);
			prevPropNo="";
			prevDarNo="";
			prevApvlNo="";
			doActionRetrieve();
		   	// 2006 (DEM / DET Adjustment Request & Approval Status) Screen has been called on
			// On the Main Screen, Counter Offer reflects the history.
			if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("CounterOffer");
	        }			
		}		
	}
	/**
	 * REJECT button is clicked, the function is executed to define the behavior
	 */				
	function doActionReject() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		// The VERSION look up information on the current DB, Screen and check on the VERSION information
		doActionIBSheet(sheetObj, formObj, IBSEARCH_VER_CHECK);
		var dis_status=getVerStatus("Code");
		var max_status=ComGetObjValue(formObj.max_ver_status);
		var curver=ComTrim(ComGetObjText(formObj.version));
		var maxver=ComGetObjValue(formObj.max_ver);
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","Retrieve");// Version()status has
														// changed. Pls click
														// New button
			return;
		}
		//=====================================================================================================	
		if (!ComShowCodeConfirm("DMT00135", "reject")) { return; }
		//Comment is a required field REJECT runtime.				
		if (!validateComment()) return;		
		// 2Reject Action is performed.
		doActionIBSheet(sheetObj,formObj,IBSAVE_REJECT);
		// 3.Action Save the normal runtime, the searching is executed.
		if (ComGetObjValue(formObj.result) == "Y") {
			//In 2006 Screen pop-up window opened, the current Screen executed in accordance with Action for 2006 Screen Enabled to reflect on the results retrieved.
			prevActStatus=ComGetObjValue(formObj.status);
			prevPropNo="";
			prevDarNo="";
			prevApvlNo="";
			doActionRetrieve();
		   	// 2006 (DEM / DET Adjustment Request & Approval Status) Screen has been called on
			// Rejected  History  reflected in  Main Screen.
			if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("Reject");
	        }				
		}		
	}	
    /**
     * Close button click,  function that defines the behavior of running
     */
    function doActionClose() {
    	ComClosePopup();
    }
	/**
	 * The main button, depending on conditions that change the status of a given function
	 */					
	function initBtnControl() {
		//Retrieve Button
		initBtnRetrieve();
		// New Button
		initBtnNew();
		// Approval Button
		initBtnApproval();
		// Counter Offer Button
		initBtnCounterOffer();
		// Reject Button
		initBtnReject();
	}
	/**
	 *Depending on conditions, Retrieve button will change the status of.
	 */		
	function initBtnRetrieve() {
        var formObj=document.form;
        if (isPopupWindow()) {
        	ComBtnDisable("btn_Retrieve");
        }
        else {
        	ComBtnEnable("btn_Retrieve");
        }
	}
	/**
	 * Depending on conditions, new button's state is changed.
	 */		
	function initBtnNew() {
	    var formObj=document.form;
	    if (isPopupWindow()) {
        	ComBtnDisable("btn_New");
        }
        else {
        	ComBtnEnable("btn_New");
        }		
	}
	/**
	 * Depending on conditions,  Approval button's state is changed. 
	 */		
	function initBtnApproval() {
    	//1.All conditions must be passed, activating is.
    	// 1-1.case in Login User's Security has  permission for UI_DMT_2005 (DAR-Before BKG Approval) 
		// activating 
    	var isPass1=isPermitRole();
    	var isPass2=isMatchOffice();
    	// 1-3.case in last version,  activating 
    	var isPass3=isMatchVersion();
    	// 1-4.case in Requested status activating 
    	var isPass4=isPermitStatus("Approval");
    	if (isPass1 && isPass2 && isPass3 && isPass4)
    		ComBtnEnable("btn_Approval");
    	else
    		ComBtnDisable("btn_Approval");
	}	
	/**
	 * Depending on conditions, Reject button's state is changed.
	 */		
	function initBtnReject() {
		//1.All conditions must be passed, activating is.
		// 1-1.case in Login User's Security has  permission for UI_DMT_2005 (DAR-Before BKG Approval) 
		// activating 
		var isPass1=isPermitRole();
		var isPass2=isMatchOffice();
		// 1-3.case in last version,  activating 
		var isPass3=isMatchVersion();
		// 1-4.case in Requested status activating 
		var isPass4=isPermitStatus("Reject");
		if (isPass1 && isPass2 && isPass3 && isPass4)
			ComBtnEnable("btn_Reject");
		else
			ComBtnDisable("btn_Reject");
	}
	/**
	 * Depending on conditions, Counter Offer button's state is changed. 
	 */		
	function initBtnCounterOffer() {
		//1.All conditions must be passed, activating is.
		// 1-1.case in Login User's Security has  permission for UI_DMT_2005 (DAR-Before BKG Approval) 
		// activating 
		var isPass1=isPermitRole();
		var isPass2=isMatchOffice();
		// 1-3.case in last version,  activating 
		var isPass3=isMatchVersion();
		// 1-4.case in Requested status activating 
		var isPass4=isPermitStatus("CounterOffer");
		if (isPass1 && isPass2 && isPass3 && isPass4)
			ComBtnEnable("btn_CounterOffer");
		else
			ComBtnDisable("btn_CounterOffer");
	}
	/**
	 * Selected for Version Status Code, Text, Request Office Code a function that returns
	 */		
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
				val=ver_item[1];
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
  	/**
  	 * Each common pop-up function calls 
  	 */
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
  	/**
  	 * According to the Tariff of selected Before Booking Request data  , Multi Origin or Destination must change the title of.
  	 */	  	 
   	function setMultiOrgDestTitle() {
 		var sheetObj1=sheetObjects[0];
 		var sheetObj2=sheetObjects[1];
 		var trfCd=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), TARIFF);
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
 		var arrHead1=HeadTitle1.split("|");
 		var arrHead2=HeadTitle2.split("|");
 		for(var iCol=0; iCol<arrHead1.length; iCol++){
 		    sheetObj2.SetCellText(0,iCol,arrHead1[iCol]);
 		    sheetObj2.SetCellText(1,iCol,arrHead2[iCol]);
 		}
   	}
   	
   	
   	
   	/**
   	 * Select rate Adjustment  item, or  uncheck when you need to perform a function that defines the behavior of
   	 */	
  	 function checkComment() {
  		var formObj=document.form;
 		var sheetHSTObj=sheetObjects[5];
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
 			//ComEnableObject(formObj.comment, false);
 			comment.readOnly = !chkComment.checked;
			if (chkComment.checked == true) {
				comment.style.backgroundColor="#CCFFFD";	//textarea1
				
			}else {
				comment.style.backgroundColor="#E8E7EC";	//textarea2
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++
 	 	}  		
  	}
 	/**
 	 * Comment Check mandatory item on the function that performs
 	 */	   	 
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
   /**
 	*  
 	*/
 	function openWinSearchRFA() {
		var formObj=document.form;
		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
	    var params="s_prop_no=" + propNo;
	    var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    ComOpenWindow("ESM_PRI_2019.do?"+ params, "", sFeatures);
 	}
   /**
 	* DAR History query function to open a pop-up.
 	*/
 	function openWinSearchDARHistory() {
 		var formObj=document.form;
 		var rFANo=ComTrim(ComGetObjValue(formObj.rFANo));
 		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
 		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
 		var custNm=ComTrim(ComGetObjValue(formObj.custNm));
 		var status=ComTrim(ComGetObjValue(formObj.status));
 		var caller=ComTrim(ComGetObjValue(formObj.caller));
 		var approvalOfcCd=ComTrim(ComGetObjValue(formObj.approvalOfcCd));
		if (caller == "3107") {
			isActBtnCopy="N";
		}
		else if (status == "" || status == "Temp. Saved") {
			isActBtnCopy="Y";
		}
		else {
			isActBtnCopy="N";
		}
 		var params="rfa_no=" + rFANo;
 		params += "&prop_no=" + propNo;
 		params += "&cust_cd=" + custCd;
 		params += "&cust_nm=" + custNm;
 		params += "&status=" + status;
 		params += "&is_copy=" + isActBtnCopy;
     	
 		
 		ComOpenPopup("EES_DMT_2105.do?" + params, 920, 480, "copyDARHistory", "0,1", true);
 	}
  	/**
	 * 2005 Screen open as a pop-up will tell you the function
	 */
	function isPopupWindow() {
	    var formObj=document.form;
		if (ComGetObjValue(formObj.caller) != "" && ComGetObjValue(formObj.darNo) != "") {
			return true;
		}
		return false;
    }
  	/**
	 * To 2006 main screen Approval / Counter Offer / Reject 's  result of the function, reflecting a
	 */
	function commitMainScreen(sAction) {
		var formObj=document.form;
		if (!opener) opener = window.dialogArguments;
		if (!opener) opener = window.opener;
		if (!opener) opener = parent;
        var receivedSheetObj=opener.sheetObjects[1];
        var sentSheetObj=opener.sheetObjects[4];
        // Only when I choose to DATE Retrieving conditions, to perform logic. (Received Tab in the approval process when data is deleted and moved to Send Tab)
        if (!opener.document.form.cond_type[0].checked) return;
        // Datas of Same DAR No and Ver No,  delete  data of  the  ReceivedTab , and add to data  to SendTab.
        var sheetId=ComGetObjValue(formObj.sheetId);
        var reqOfc=(sheetId == "t1sheet2") 	? receivedSheetObj.GetCellValue(receivedSheetObj.GetSelectRow(), "req_ofc_cd") : sentSheetObj.GetCellValue(sentSheetObj.GetSelectRow(), "req_ofc_cd");
        var apvlOfc=(sAction != "Requested")  ? ComGetObjValue(formObj.ofc_cd) : "";
        var isSameOfc=opener.isSameOffice(reqOfc, apvlOfc);
        // 1. Case in  Request and  Approval Office is same,  display all to Received Tab and Sent Tab 
        // all table Update 
        if (isSameOfc) {
        	updateRow(receivedSheetObj, sAction);
			updateRow(sentSheetObj, 	sAction);
        }
        //2. Case in  Request and  Approval Office is differnet, it called in Received Tab, then move data to Sent Tab 
        else {
        	if (prevActStatus == "Requested") {
        		//Received Tab => Received Tab(update)
        		if (sAction == "Requested") {
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
	 * The status of the selected Row, updated (with information that has changed), a function that
	 */
	function updateRow(sheetObj, sAction) {
		var formObj=document.form;
		var darNo=ComGetObjValue(formObj.darNo);
		var verNo=ComGetObjText(formObj.version);
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				if (darNo == GetCellValue(row, "dar_no") && verNo == GetCellValue(row, "ver_no")) {
					SetCellValue(row, "apvl_no",sAction == "Approval" ? ComGetObjValue(formObj.approvalNo) : "");
					SetCellValue(row, "status",ComGetObjValue(formObj.status));
					SetCellValue(row, "apro_ofc_cd",ComGetObjValue(formObj.ofc_cd));
					SetCellValue(row, "upd_dt",ComGetObjValue(formObj.popup_upd_dt));
				}
			}
		}
	}
 	/**
	 * Sheeted Row,  from the current function to move to another Sheet
	 */
    function moveRowSheetToSheet(fromSheetObj, toSheetObj, sAction) {
        var formObj=document.form;
		var isAppliedRow=false;
		var darNo=ComGetObjValue(formObj.darNo);
		var verNo=ComGetObjText(formObj.version);
		with(fromSheetObj) {
			for (var row=LastRow(); row >= HeaderRows(); row--) {
				if (darNo == GetCellValue(row, "dar_no") && verNo == GetCellValue(row, "ver_no")) {
					if (!isAppliedRow) {
		                var addedRow=toSheetObj.DataInsert(-1);
		                var fieldValue="";
		                for (ic=0 ; ic <= LastCol(); ic++) {
		                	switch(ColSaveName(ic)) {
			                	case "apvl_no":
			                		fieldValue=sAction == "Approval" ? ComGetObjValue(formObj.approvalNo) : "";
			                		break;
			                	case "status":
			                		fieldValue=ComGetObjValue(formObj.status);
			                		break;
			                	case "apro_ofc_cd":
			                		fieldValue=sAction != "Requested" ? ComGetObjValue(formObj.ofc_cd) : "";
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
	                //delete from original
	                RowDelete(row, false);
				}
			}
		}
    }
    /**
	 * EES_DMT_2005 (DAR-Before BKG Approval) for a login User Security rights of a function that returns a result that
	 */
    function isPermitRole() {
        var formObj=document.form;
		if (ComGetObjValue(formObj.role_permit) == "Y") return true;
		return false;
	}
    /**
	 * result return Function : Checking  RHQ of the Approval Office and  RHQ of  the login office are  same
	 */
	function isMatchOffice() {
	    var formObj=document.form;
		with(formObj) {
		    if (ComGetObjValue(approvalOfcCd) == ComGetObjValue(rhq_ofc_cd))
			    return true;
		}
		return false;
	}
    /**
	 *  The current version is the same as the final version of a function that returns a result
	 */
	function isMatchVersion() {
	    var formObj=document.form;
		with(formObj) {
		    if (ComTrim(ComGetObjText(formObj.version)) == ComTrim(formObj.version.options[0].text))
			    return true;
		}
		return false;
	}
   /**
	 * Depending on the value of Status, button a function that returns whether the activating
	 */
	function isPermitStatus(sts) {
	    var formObj=document.form;
	    var status=ComTrim(ComGetObjValue(formObj.status));
		if (sts == "Approval") {
			if (status == "Requested")
			    return true;
		}
	    else if (sts == "CounterOffer") {
			if (status == "Requested")
			    return true;
	    }
	    else if (sts == "Reject") {
			if (status == "Requested")
			    return true;
	    }
		return false;
	}
    /**
     * Delivered normally not received from the server being able to handle the data function 
     */
    function handleNullString(sVal) {
         if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
         return ComTrim(sVal);
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
 			} else if (GetCellValue(GetSelectRow(), FT_TIR) == "S") {
 				formObj.chkFreeTime.checked=false;
 			} else if (GetCellValue(GetSelectRow(), FT_TIR) == "") {
 				formObj.chkFreeTime.checked=false;
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
