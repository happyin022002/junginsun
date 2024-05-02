/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2007.js
*@FileTitle  : S/C & RFA Exception Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class   business script for S/C & RFA Exception Inquiry 
     */
	//Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var comboObjects=new Array();
	var comboCnt=0;	
	//Defining Action
	var IBSEARCH_TARIFF=100;
	var IBSEARCH_SC_STAT=101;
	var IBSEARCH_RFA_STAT=102;
	var IBSEARCH_REF_OFC=103;
	var IBSEARCH_CVRG=104;
	var IBSEARCH_CUST_NM=105;
	//Business Global Variables
	var CONTINENT="CONTI";
	var COUNTRY="CNT";
	var REGION="RGN";
	var STATE="STE";
	var LOCATION="LOC";
	var YARD="YD";
	var ROWMARK="|";
	var FIELDMARK="=";
    var SC_NO="sc_no";
    var RFA_NO="rfa_no";
    var STATUS="status";
    var TARIFF="tariff";
    var EFF_DT="eff_dt";
    var EXP_DT="exp_dt";
    var CNTRCGO="cntrcgo";
    var CNT_CD="cnt_cd";
    var RGN_CD="rgn_cd";
    var LOC_CD="loc_cd";
    var FT_TIR="ft_tir";
    var FT_ADD_DYS="ft_add_dys";
    var FT_TOT_DYS="ft_tot_dys";
    var SAT_FLG="xcld_sat_flg";
    var SUN_FLG="xcld_sun_flg";
    var HOL_FLG="xcld_hol_flg";
    var CURR_CD="curr_cd";
    var ORGDST_MULTI="org_dest_multi";
	var ORGDST_CTI="org_dest_conti_cd";
	var ORGDST_CNT="org_dest_cnt_cd";
	var ORGDST_RGN="org_dest_rgn_cd";
	var ORGDST_LOC="org_dest_loc_cd";;
    var BKGDEL_CNT="fnl_dest_cnt_cd";
    var BKGDEL_RGN="fnl_dest_rgn_cd";
    var BKGDEL_LOC="fnl_dest_loc_cd";
    var CYDOOR="rcv_de_term_cd";
    var RATE_FLG="rt_flg";
    var CMDT_FLG="rep_cmdt_flg";
    var ACUST_FLG="act_cust_flg";
    var AMDT_SEQ="amdt_seq";
    var PROP_NO="prop_no";
    var CUST_CD="cust_cd";
    var CUST_NM="cust_nm";
    var VER="ver_seq";
    var GRP_SEQ="grp_seq";
    var DAR_NO="dar_no";
    var APRO_NO="apvl_no";
    var RQST_SEQ="rqst_seq";
    var ACT_CUST_CD="act_cust_cd";
    var ACT_CUST_NM="act_cust_nm";
    var CVRG_SEQ="cvrg_seq";
    var CNTR_FM_QTY="cntr_fm_qty";
    var CNTR_TO_QTY="cntr_to_qty";
    var FT_DYS="ft_dys";
	var RT_FROM="ft_fm_dys";
	var RT_UPTO="ft_to_dys";
	var RT_OVER="ft_ovr_dys";
	var RT_UNDR="ft_und_dys";
	var RT_20FT="cntr_20ft_rt_amt";
	var RT_40FT="cntr_40ft_rt_amt";
	var RT_HC="cntr_hc_rt_amt";
	var RT_45FT="cntr_45ft_rt_amt";
	var CUST_CD="cust_cd";
	var CUST_NM="cust_nm";
	var CUST_TP="cust_tp";
	var CMDT_CD="cmdt_cd";
	var CMDT_NM="cmdt_nm";
	var MAPG_SEQ="mapg_seq";
	//When Retrieving Location, Location intended to prevent information from being erased
	var isClearLocation=true;
	var SC_TAB=0;
	var RFA_TAB=1;
  	//Sort when the selected Row in order to maintain the selection state of the variables used
	var currPropNo="";
	var currVerSeq="";
	var currGrpSeq="";
	var currCvrgSeq="";
	var currDarNo="";
	var currDarVerSeq="";
	var currRqstSeq="";
	var currCvrgCmbSeq="";
	var DEF_SHEET_HEIGHT = 162;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 181;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetSCObj=sheetObjects[0];
         var sheetRFAObj=sheetObjects[5]
         /*******************************************************/
         var formObj=document.form;
    	try {
     		var srcObj=ComGetEvent();
     		var srcName=srcObj.getAttribute("name");
            switch(srcName) {
	        	case "btn_Affiliate":
					if (ComIsBtnEnable("btn_Affiliate")) 
						doProcessPopup(sheetRFAObj, "Affiliate");
					break;
				case "btns_ofcCalendar": //Calendar button
	 				var cal=new ComCalendarFromTo();
	            	cal.select(formObj.ofcEffDtFm, formObj.ofcEffDtTo, 'yyyy-MM-dd');
					break;
				case "btns_cvrgCalendar": //Calendar button
 					var cal=new ComCalendarFromTo();
            		cal.select(formObj.cvrgEffDtFm, formObj.cvrgEffDtTo, 'yyyy-MM-dd');
            		break;
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve"))
						doActionRetrieve();
					break;
				case "btn_New":
					if (ComIsBtnEnable("btn_New"))
						doActionNew();
					break;
				case "btn_Minimize":
					if (ComIsBtnEnable("btn_Minimize"))
						doActionMinimize();
					break;
				case "btn_Detail":
					if (ComIsBtnEnable("btn_Detail"))
						doActionDetail();
					break;
				case "btn_DownExcel":
					if (ComIsBtnEnable("btn_DownExcel"))
						doActionDownExcel();
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
     * IBTab Object is defined as an array.
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
	 */
	function setTabObject(tab_obj){
    	 tabObjects[tabCnt++]=tab_obj;
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
 	   	//Displays a pop-up title at the call handling
        if(isPopupWindow()) {
	        //var spanObj=document.getElementById("title2");
 	       	//spanObj.innerText=" S/C & RFA Exception Inquiry";
	       	//called pop up  Close button.
        	ComSetDisplay('btn_Close', true);
// 	       btn_Close.style.display="inline"; 	       	
 	   	}
        for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);        	
        }
		for (var k=0 ; k < tabObjects.length ; k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
	 	//IBMultiCombo initializing 
	    for (var k=0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }

		//initializing html control event
		initControl();
		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		//S/C of the status information by checking the S / C combo initcall.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_SC_STAT,SEARCH15);
 		//Before the state of query information set in the combo gives RFA
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_RFA_STAT,SEARCH15);
 		//Tariff Inquiry by Tariff Type information to combo configuration.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_TARIFF,SEARCH09);
 		//Ref. Office query information and Ref. Office set up to give the combo.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_REF_OFC,SEARCHLIST01);
 		//Country Coverage of the grid to query information on CN initcall combo.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH02);
 		//Coverage of the Region information by checking the grid gives RGN combo set.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH01);
 		
		//in loading page, be deactivating specific fields.
		initDisableControls();
		initOfficeControls();
 		if (isPopupWindow()) {
 			doActionRetrieve();
 		}
    }
 	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
//    no support[check again]CLT 	function t1sheet1_OnLoadFinish() {
 		
// 	}
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetid=sheetObj.id;
        switch(sheetid) {
            case "t1sheet1":
				with(sheetObj){
					var HeadTitle1="|Seq.|S/C No.|Ver.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|F/T Exclusion|F/T Exclusion|F/T Exclusion|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|CY/Door|Rate|CMDT|Cust.|Proposal No.|Customer|Customer";
					var HeadTitle2="|Seq.|S/C No.|Ver.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|CN|RGN|LOC|Tier|Add|Total|SAT|SUN|H/day|CT|CN|RGN|LOC|CN|State|LOC|CY/Door|Rate|CMDT|Cust.|Proposal No.|Code|Name";
					var headCount=ComCountHeadTitle(HeadTitle1) + 4;
					//SetConfig( { SearchMode:2, FrozenCol:SaveNameCol(FT_TIR), MergeSheet:5, Page:20, DataRowMerge:1 } );
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:SC_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:VER,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:STATUS,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:CNTRCGO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:CNT_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:RGN_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:LOC_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:FT_TIR,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:FT_ADD_DYS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:FT_TOT_DYS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CTI,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:CYDOOR,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:RATE_FLG,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:CMDT_FLG,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:ACUST_FLG,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:PROP_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:GRP_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:AMDT_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(DEF_SHEET_HEIGHT);
					SetEditable(1);
				}
			break;
			
            case "t1sheet2":
				with(sheetObj){
					var HeadTitle1="|CNTR Q'TY|CNTR Q'TY|Total";
					var HeadTitle2="|From|Up to|Total";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CNTR_FM_QTY,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CNTR_TO_QTY,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:FT_DYS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(130);
					SetEditable(1);
				}
			break;
			
            case "t1sheet3":
				with(sheetObj){
					var HeadTitle1="|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
					var HeadTitle2="|From|Up to|20 FT|40 FT|H/C|45 FT";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:RT_FROM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:RT_UPTO,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:RT_20FT,    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:RT_40FT,    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:RT_HC,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:RT_45FT,    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 } ];
					    
					InitColumns(cols);
					SetSheetHeight(130);
					SetEditable(1);
				}
            break;
            
            case "t1sheet4":
				with(sheetObj){
					var HeadTitle1="|Code|Name";
					var headCount=ComCountHeadTitle(HeadTitle1) + 1;
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"}];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CUST_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CUST_TP,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(100);
					SetEditable(1);
				}
			break;
			
            case "t1sheet5":
				with(sheetObj){     
					var HeadTitle1="|Code|Name";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CMDT_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:CMDT_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					    
					InitColumns(cols);
					SetSheetHeight(100);
					SetEditable(1);
				}
			break;
			
            case "t2sheet1":
            	with(sheetObj){
					var HeadTitle1="|Seq.|RFA No.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|Actual Customer|Actual Customer|Rate|DAR No.|Ver.|Approval No.|Proposal No.|Customer|Customer";
					var HeadTitle2="|Seq.|RFA No.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|CN|RGN|LOC|Tier|Add|Total|SAT|SUN|H/day|Multi|CT|CN|RGN|LOC|CN|State|LOC|Code|Name|Rate|DAR No.|Ver.|Approval No.|Proposal No.|Code|Name";
					var headCount=ComCountHeadTitle(HeadTitle1) + 4;
					SetConfig( { SearchMode:2, FrozenCol:11, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:RFA_NO,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:STATUS,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:CNTRCGO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:CNT_CD,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:RGN_CD,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:LOC_CD,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:FT_TIR,      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:FT_ADD_DYS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:FT_TOT_DYS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:SAT_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:SUN_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:HOL_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_MULTI,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CTI,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_CNT,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_RGN,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:ORGDST_LOC,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_CNT,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_RGN,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:BKGDEL_LOC,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:ACT_CUST_CD,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:ACT_CUST_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:RATE_FLG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:DAR_NO,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:VER,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:APRO_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:PROP_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:RQST_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:AMDT_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CURR_CD,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CVRG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(DEF_SHEET_HEIGHT);
					SetEditable(1);
				}
			break;
			
            case "t2sheet2":
				with(sheetObj){
					var HeadTitle1="|Seq.|BKG POR|BKG POR|BKG POR|BKG POR";
					var HeadTitle2="|Seq.|Continent|Country|Region|Location";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
					 {Type:"Seq",       Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"Seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_CTI,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:ORGDST_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(122);
					SetEditable(1);
				}
			break;
			
            case "t2sheet3":
				with(sheetObj){
					var HeadTitle1="|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
					var HeadTitle2="|From|Up to|20 FT|40 FT|H/C|45 FT";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflg" },
					  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:RT_OVER,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:RT_UNDR,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_20FT,    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_40FT,    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:RT_HC,      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:RT_45FT,    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 } ];
					    
					InitColumns(cols);
					SetSheetHeight(122);
					SetEditable(1);
				}
			break;
			
            case "t2sheet4":
				with(sheetObj){
					var HeadTitle1="|CNTR Q'TY|CNTR Q'TY|Total";
					var HeadTitle2="|From|Up to|Total";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CNTR_FM_QTY,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CNTR_TO_QTY,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:FT_DYS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(122);
					SetEditable(1);
				}
			break;
			
            case "t2sheet5":
				with(sheetObj){     
					var HeadTitle1="|Code|Name";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:CMDT_CD,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:CMDT_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					    
					InitColumns(cols);
					SetSheetHeight(122);
					SetEditable(1);
				}
			break;
        }
    }
 	/**
  	 * Initializing Combo 
  	 * param : comboObj , comboNo
  	 *  adding case as numbers of counting Combos
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObj=document.form
  	    switch(comboNo) {
  	    	//S/C
  	    	case 1:
  	    		with(comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");
  					SetColWidth(0, "110");
  					SetDropHeight(160);
  	    		}
  	    		break;
  	    	//Before
  	    	case 2:
  	    		with(comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");  					
  					SetColWidth(0, "120");
  					SetDropHeight(160);
  	    		}
  	    		break;
  	    	//Tariff Type
  	    	case 3:
  	    		with(comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");  					
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
  					SetDropHeight(160);
  	    		}
  	    		break;
  		   	//Ref. Office
  	    	case 4:
  	        	with(comboObj) { 
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");
  					SetDropHeight(160);
  					SetBackColor("#CCFFFD");
  					SetFontColor("#606060");
  					ValidChar(2, 2);	// use upper case
  	    	    }
  	            break; 
  			//Country
  			case 5:
  				with(comboObj) { 
  					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "190");
  					SetDropHeight(160);
  					ValidChar(2);
					SetMaxLength(2);
  		    	}
  				break;
  			//Region
  			case 6: 
  				with(comboObj) { 		
  					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "190");
  					SetDropHeight(160);
  					ValidChar(2);
					SetMaxLength(3);
  				}
  				break;			
  	     } 
  	} 
 	function initControl() {
		axon_event.addListenerForm('blur',			'obj_deactivate', 		document.form, 'cond_type'); //- out of focus
		axon_event.addListenerFormat('keypress',	'obj_keypress', 		document.form); //- on press keyboard
		axon_event.addListenerFormat('focus',		'obj_focus',			document.form); // Get focus
		axon_event.addListener('click', 			'condType_click', 		'cond_type');
		axon_event.addListener('blur', 				'obj_blur', 			'custCd');
		axon_event.addListener('keydown', 			'ComKeyEnter', 			'form');
	}
    /**
    * HTML Control Foucs in
    */
	function obj_focus(){
		var obj=event.srcElement;
		ComClearSeparator(obj);
		//If you have a block of text so as to choose.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
   // out of focus
 	function obj_deactivate(){
 		//check inputing Validation + Inserting separator 
 		var obj=event.srcElement;
 		if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
 		} else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
 			if(obj.value.length > 0 && obj.value.length < 5) {
 	 			ComShowCodeMessage('DMT00110', 'Location');
 	 			ComClearObject(obj);
    		 	}
 		} else {
 			ComChkObjValid(obj);
 		}
	}
	//business javascript OnKeyPress event handling
	function obj_keypress() {
		var formObj=document.form;
		switch(ComGetEvent("dataformat")){
			case "engup":
				// upper case + numbers 
				ComKeyOnlyAlphabet('uppernum', ',');
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
		// search option, DAR item, then enter data in a particular field, the entered value of other fields makes Clear.
		clearNoSelectDARFields();
	} 
	function obj_blur() {
		switch(ComGetEvent("name")){
			case "custCd":
				searchCustomerName();
				break;
		}
	}
    // Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
        		//1.S/C 
        		if (sheetObj.id == "t1sheet1") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH);
    				ComSetObjValue(formObj.type, "SC");
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				//sheetObj.DoSearch("EES_DMT_2007GS.do", FormQueryString(formObj));
    				var sXml = sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
    				//3.S/C if items do a lookup, automatic S/C Tab allows changes to be selected.
    				if (formObj.chkSC.checked) {
    					tabObjects[0].SetSelectedIndex(0);
    				}    				
        		}
        		//2.S/C - Tiered Free Time 
        		else if (sheetObj.id == "t1sheet2") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH01);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//3.S/C - Rate Adjustment 
        		else if (sheetObj.id == "t1sheet3") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH02);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//4.S/C - Actual Customer 
        		else if (sheetObj.id == "t1sheet4") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH03);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
    					sheetObj.LoadSearchData(sXml, {Sync:1});
    					//Type of Customer allows the selected setting.
    					ComSetObjValue(formObj.scCustType, sheetObj.GetCellValue(sheetObj.GetSelectRow(), CUST_TP));
    				}
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//5.S/C - Commodity 
        		else if (sheetObj.id == "t1sheet5") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH04);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//6.RFA 
        		else if (sheetObj.id == "t2sheet1") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH);
    				ComSetObjValue(formObj.type, "BB");
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				//sheetObj.DoSearch("EES_DMT_2007GS.do", FormQueryString(formObj));
    				var sXml = sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				sheetObj.LoadSearchData(sXml, {Sync:1});    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
    				//3.If only the query to RFA, RFA Tab is selected automatically allows changes to be.
    				if (!formObj.chkSC.checked && formObj.chkRFA.checked) {
    					tabObjects[0].SetSelectedIndex(1);
    				}
    				//4.Before Booking the selected according to the Tariff, Multi Origin or Destination allows to change the subject line.
					setMultiOriginOrDestTitle();
        		}
        		//7.RFA - Multi Origin or Destination 
        		else if (sheetObj.id == "t2sheet2") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH05);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//8.RFA - Rate Adjustment 
        		else if (sheetObj.id == "t2sheet3") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH06);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}  
        		//9.RFA - Tiered Free Time 
        		else if (sheetObj.id == "t2sheet4") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH07);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}    
        		//10.RFA - Commodity
        		else if (sheetObj.id == "t2sheet5") {
    				//1.Setting parametor condition, before retrieving
    				ComSetObjValue(formObj.f_cmd, SEARCH08);
    				//2.retrievie according to conditions
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.SetWaitImageVisible(0);
    				//*********************************************************************************
    				var sXml=sheetObj.GetSearchData("EES_DMT_2007GS.do", FormQueryString(formObj));
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml, {Sync:1});
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}     		
			break;
        }
    }
	/**
	 * Initializing the combo field in order to Inquiry the data and then populate it with the queried data.
	 */	
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
	    sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	    	case IBSEARCH_SC_STAT:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01972");
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
				var comboObj=comboObjects[0];
				var comboDatas=ComGetEtcData(sXml, "COMMON_CD");
				var sCStatusArray=comboDatas.split(ROWMARK);
				var sCStatusSortArray=new Array();
				sCStatusSortArray[0]="R" + FIELDMARK;
				sCStatusSortArray[1]="A" + FIELDMARK;
				sCStatusSortArray[2]="L" + FIELDMARK;
				sCStatusSortArray[3]="D" + FIELDMARK;
				var sCStatusDatas="" + FIELDMARK + "All";
				for (var sortI=0 ; sortI < sCStatusSortArray.length ; sortI++) {
					for (var arrayI=0 ; arrayI < sCStatusArray.length ; arrayI++) {
						if (sCStatusArray[arrayI].indexOf(sCStatusSortArray[sortI]) != -1) {
							sCStatusDatas += ROWMARK + sCStatusArray[arrayI];
							break;
						}
					}
				}
				//######################################################################################################
				var comboItems=sCStatusDatas.split(ROWMARK);
				addComboItem(comboObj,comboItems,"ONE-SELECT");
				comboObj.SetSelectCode("L");
			break;
			
	    	case IBSEARCH_RFA_STAT:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD02069");
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
				var comboObj=comboObjects[1];
				var comboDatas=ComGetEtcData(sXml, "COMMON_CD");
				var rFAStatusArray=comboDatas.split(ROWMARK);
				var rFAStatusSortArray=new Array();
				rFAStatusSortArray[0]="R" + FIELDMARK;
				rFAStatusSortArray[1]="C" + FIELDMARK;
				rFAStatusSortArray[2]="A" + FIELDMARK;
				rFAStatusSortArray[3]="O" + FIELDMARK;
				rFAStatusSortArray[4]="J" + FIELDMARK;
				var rFAStatusDatas="" + FIELDMARK + "All";
				for (var sortI=0 ; sortI < rFAStatusSortArray.length ; sortI++) {
					for (var arrayI=0 ; arrayI < rFAStatusArray.length ; arrayI++) {
						if (rFAStatusArray[arrayI].indexOf(rFAStatusSortArray[sortI]) != -1) {
							rFAStatusDatas += ROWMARK + rFAStatusArray[arrayI];
							break;
						}
					}
				}				
				//##############################################################################################################################
				var comboItems=rFAStatusDatas.split(ROWMARK);
				addComboItem(comboObj,comboItems,"ONE-SELECT");
				comboObj.SetSelectCode("A");
			break;
			
	    	case IBSEARCH_TARIFF:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
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
				var comboObj=comboObjects[2];
				var comboItems=ComGetEtcData(sXml, "all_tariff_cd").split(ROWMARK);
				addComboItem(comboObj,comboItems);
				if (isPopupWindow()) {
					comboObj.SetSelectText(ComGetObjValue(formObj.opener_tariff));
				}
				else {
					for (var i=0 ; i < comboItems.length ; i++) {
						comboObj.SetItemCheck(i,1);
					}
				}
			break;
			
	    	case IBSEARCH_REF_OFC:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
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
	    	    var comboObj=comboObjects[3];
	    	    var ofc_cds=handleNullString(ComGetEtcData(sXml, "OFC_CD"));
	    	    var ofc_nms=handleNullString(ComGetEtcData(sXml, "OFC_NM"));
	    	    if (sComboAction == SEARCHLIST01) { // Search Office
	    	    	if (ofc_cds != "") {
						var usrOfcCd=ComGetObjValue(formObj.login_ofc_cd);
	 					var idx=0;
	 					if (ofc_cds.indexOf(usrOfcCd) == -1) {
	 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
	 						idx=1;
	 					}
			    	    var comboCodeArr=ofc_cds.split("|");
			    	    var comboTextArr=ofc_nms.split("|");
			    	    for (var i=0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(idx + i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i].toString());		
			         	}
			    	    //setDefaultRefOffice();
	    	    	}
	    	    } 
	    	    else { // incl. Sub Office
	    	    	if (ofc_cds != "")  {
	    	    		var usrOfcCd=ComGetObjValue(formObj.login_ofc_cd);
	    	    		if (comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && ofc_cds.indexOf(usrOfcCd) == -1)
	    	    			ofc_cds=usrOfcCd + "," + ofc_cds;
	    	    		comboObj.SetSelectCode(ofc_cds, false);
	    	    	}
	    	    }
    	    break;
    	    
        	case IBSEARCH_CUST_NM:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
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
				var custNm=ComTrim(ComGetEtcData(sXml, "CUST_NM"));
				if (custNm == "") {
					ComShowCodeMessage("DMT06001");
					ComClearObject(formObj.custCd);
					ComClearObject(formObj.custNm);
					ComSetFocus(formObj.custCd);
					return;
				} else {
					ComSetObjValue(formObj.custNm, custNm);
				}
        	break;
        	
	    	case IBSEARCH_CVRG:
	    		//1.Setting parametor condition, before retrieving
	    		ComSetObjValue(formObj.f_cmd, sComboAction);
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
				var comboItems;
				var comboItem;
				switch(sComboAction) {
					//3-1.Search Region (All Region List)
					case SEARCH01:
						comboItems=ComGetEtcData(sXml, REGION).split(ROWMARK);
						comboObjects[5].RemoveAll();
						addComboItem(comboObjects[5],comboItems);						
						break;
					//3-2.Search Country (All Country List)
					case SEARCH02:
						comboItems=ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
						comboObjects[4].RemoveAll();
						addComboItem(comboObjects[4],comboItems);						
						break;
					//3-3. Search  Region of Country
					case SEARCH03:
						//In response XML,  Region or State information, choose from the list allows querying
						if (comboObjects[4].GetSelectText()== "CA" || comboObjects[4].GetSelectText()== "US") {
							comboDatas=ComGetEtcData(sXml, STATE);
						} else {
							comboDatas=ComGetEtcData(sXml, REGION);
						}
						// If you do not have the search results, Error Message show makes initializing to Empty.
						if (comboDatas == undefined || ComTrim(comboDatas) == "") {
							ComShowCodeMessage("DMT00110", "Country");
							return;
						} else {
							//Region combo Empty  initializing
							comboObjects[5].RemoveAll();
							comboItems=comboDatas.split(ROWMARK);
							addComboItem(comboObjects[5],comboItems);
						}					
						break;						
					//3-4.Location according to an item, enter higher Country, Region Inquiry
					case SEARCH04:
						//In response XML, Country information, choose from the list allows querying.
						comboDatas=ComGetEtcData(sXml, COUNTRY);
						if (comboDatas != undefined) {
							comboItems=comboDatas.split(ROWMARK);
							setComboItem(comboObjects[4],comboItems);
						}
						//In response XML,  Region or State information, choose from the list allows querying
						var locCd=ComTrim(ComGetObjValue(formObj.location)).substring(0, 2);
						if (locCd == "CA" || locCd == "US") {
							comboDatas=ComGetEtcData(sXml, STATE);
						} else {
							comboDatas=ComGetEtcData(sXml, REGION);
						}
						if (comboDatas != undefined) {
							comboItems=comboDatas.split(ROWMARK);
							setComboItem(comboObjects[5],comboItems);
						} else {
							ComShowCodeMessage("DMT00110", "Location");
							ComClearObject(formObj.location);
							ComSetFocus(formObj.location);
						}
						break;
					//3-5.Region as a higher item code (Country) should query information.
					case SEARCH13:						
					//3-6.State as a higher item code (Country) should query information.
					case SEARCH17:
						//In response XML, Country information, choose from the list allows querying.
						comboDatas=ComGetEtcData(sXml, COUNTRY);
						if (comboDatas != undefined) {
							comboItems=comboDatas.split(ROWMARK);
							setComboItem(comboObjects[4],comboItems);
							//In response XML,  Region or State information, choose from the list allows querying
							if (comboObjects[4].GetSelectText()== "US" || comboObjects[4].GetSelectText()== "CA") {
								comboDatas=ComGetEtcData(sXml, STATE);
							}
							else {
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[5],comboItems);
							}							
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							comboObjects[5].SetSelectText("");
						}
						break;
				}	    	    
	    	break;
	    }
		sheetObj.SetWaitImageVisible(1);
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 var formObj=document.form;
    	 //1.Type the S / C or Before sure to select either
    	 if (!formObj.chkSC.checked && !formObj.chkRFA.checked) {
    		 ComShowCodeMessage("DMT00102", "S/C or Before");
    		 return false;
    	 }
    	 //2.Tariff Type Type is a required selection
   		 if (ComTrim(comboObjects[2].GetSelectText()) == "") {
    		 ComShowCodeMessage("DMT00102", "Tariff Type");
    		 return false;    			 
		 }    	 
    	 //3-1.Selection Office at (Ref.Office and Effective entry is required.)
    	 if (formObj.cond_type[0].checked) {
  			var startDt=ComTrim(ComGetObjValue(formObj.ofcEffDtFm));
 			var endDt=ComTrim(ComGetObjValue(formObj.ofcEffDtTo));
    		 if (ComTrim(comboObjects[3].GetSelectText()) == "") {
        		 ComShowCodeMessage("DMT00102", "Ref. Office");
        		 return false;    			 
    		 }
    		 else if (startDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.ofcEffDtFm);
        		 return false;    			 
    		 }
    		 else if (endDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.ofcEffDtTo);
        		 return false;    			 
    		 }
			startDt=ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt=ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt=ComGetDateAdd(startDt, "Y", 1);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "1 year");
            	return false;
            }
    	 }
    	//3-2.Coverage is selected (Country and Effective entry is required.)
    	 else if (formObj.cond_type[1].checked) {
   			var startDt=ComTrim(ComGetObjValue(formObj.cvrgEffDtFm));
 			var endDt=ComTrim(ComGetObjValue(formObj.cvrgEffDtTo));
    		 if (ComTrim(comboObjects[4].GetSelectText()) == "") {
        		 ComShowCodeMessage("DMT00102", "Country");
        		 return false;       			 
    		 }
    		 else if (startDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.cvrgEffDtFm);
        		 return false;    			 
    		 }
    		 else if (endDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.cvrgEffDtTo);
        		 return false;    			 
    		 }
 			startDt=ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt=ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt=ComGetDateAdd(startDt, "Y", 1);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "1 year");
            	return false;
            }
    	 }
    	 //3-3.DAR 
    	 else {
    		 var sCNo=ComTrim(ComGetObjValue(formObj.sCNo));
    		 var rFANo=ComTrim(ComGetObjValue(formObj.rFANo));
    		 var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
    		 var darNo=ComTrim(ComGetObjValue(formObj.darNo));
    		 var aprvNo=ComTrim(ComGetObjValue(formObj.approvalNo));
    		 var inputFieldCount=0;
    		 if (propNo != "") inputFieldCount++;
    		 if (sCNo != "") inputFieldCount++;
    		 if (rFANo != "") inputFieldCount++;
    		 if (darNo != "") inputFieldCount++;
    		 if (aprvNo != "") inputFieldCount++;
    		 if (inputFieldCount == 0 || inputFieldCount > 1) {
    			 ComShowCodeMessage("DMT00180");
    			 ComSetFocus(formObj.sCNo);
    			 return false;    			 
    		 }
    	 }
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
					InsertItem( "S/C" , "");
					InsertItem( "RFA" , "");
                }
                break;
        }
    }
	 /**
     * Click on Tab event-related
     * Elements selected tab is active.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");

        objs[nItem].style.display="inline";
        objs[beforetab].style.display="none";
        objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab=nItem;
    }
   /**
  	* Align the current selection state of ROW has been chosen to handle it functions to maintain
  	*/	
  	function t1sheet1_OnSort(sheetObj, Col, SortArrow) {
  		with(sheetObj) {
  			for (var row=HeaderRows(); row <= LastRow(); row++) {
  				if (	currPropNo 	== GetCellValue(row, PROP_NO)
  						&& 	currVerSeq 	== GetCellValue(row, VER)
  						&& 	currGrpSeq 	== GetCellValue(row, GRP_SEQ)
  						&& 	currCvrgSeq == GetCellValue(row, CVRG_SEQ)) {
  					SetSelectRow(row);
  					break;
  				}
  			}
  		}
  	} 
	function t1sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		if (OldRow >= sheetObj.HeaderRows()&& OldRow != NewRow) {
			//------------------------------------------------------------------
			currPropNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), PROP_NO);
			currVerSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), VER);
			currGrpSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), GRP_SEQ);
			currCvrgSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_SEQ);
			//------------------------------------------------------------------
			doActionSCChildRetrieve();
		}
	}
	function t1sheet1_OnDblClick(sheetObj,Row,Col) {
		 doActionDetail();
	}
	/**
	 * T1
	 */	
	function t1sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		with(sheetObj) {
			var colName = ColSaveName(MouseCol());
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == CNT_CD || colName == RGN_CD || colName == LOC_CD) {
					var trfCd = GetCellValue(MouseRow(), TARIFF);
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
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd = GetCellValue(MouseRow(), TARIFF);
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
					var trfCd = GetCellValue(MouseRow(), TARIFF);
					//if Tariff =  DMIF ,  balloon message "BKG DEL for Demurrage Only"
					//         if Tariff =  DMOF ,  balloon message "BKG POR for Demurrage Only" 
					switch(trfCd) {
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL for Demurrage Only"); break;
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POR for Demurrage Only"); break;
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}				
				else if (colName == CYDOOR) {
					var trfCd = GetCellValue(MouseRow(), TARIFF);
					//Tariff = DTIC, CTIC, balloon message "BKG DEL Term for Detention Only"
					//         DTOC, CTOC, balloon message "BKG RCV Term for Detention Only" 
					switch(trfCd) {
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL Term for Detention Only"); break;
						case "DTOC": 
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG RCV Term for Detention Only"); break;
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
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
   /**
  	* Align the current selection state of ROW has been chosen to handle it functions to maintain
  	*/	
  	function t2sheet1_OnSort(sheetObj, Col, SortArrow) {
  		with(sheetObj) {
  			for (var row=HeaderRows(); row <= LastRow(); row++) {
  				if (	currDarNo 		== GetCellValue(row, DAR_NO)
  						&& 	currDarVerSeq 	== GetCellValue(row, VER)
  						&& 	currRqstSeq 	== GetCellValue(row, RQST_SEQ)
  						&& 	currCvrgCmbSeq 	== GetCellValue(row, CVRG_SEQ)) {
  					SetSelectRow(row);
  					break;
  				}
  			}
  		}
  	}  
	/**
	 * 
	 */	
	function t2sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		if (OldRow >= sheetObj.HeaderRows()&& OldRow != NewRow) {
			//------------------------------------------------------------------
			currDarNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO);
			currDarVerSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), VER);
			currRqstSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), RQST_SEQ);
			currCvrgCmbSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_SEQ);
			//------------------------------------------------------------------
			setMultiOriginOrDestTitle();
			doActionRFAChildRetrieve();
		}
	}
	/**
	 * Double-click pop-up screen is opened in the relevant time.
	 */	
	function t2sheet1_OnDblClick(sheetObj,Row,Col) {
		 doActionDetail();
	}

	/**
	 * T2
	 */	
	function t2sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		with(sheetObj) {
			var colName = ColSaveName(MouseCol());
			var tariff = GetCellValue(MouseRow(), TARIFF);
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == CNT_CD || colName == RGN_CD || colName == LOC_CD) {
					//if Tariff = DMOF , balloon message "BKG POL/CY"
					//         if Tariff = DMIF , balloon message "BKG POD/CY"
					//         if Tariff = DTOC or  CTOC ,  balloon message "BKG POR"
					//         if Tariff = DTIC or CTIC  ,  balloon message "BKG DEL"				
					switch(tariff) {
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					//if Tariff =  DMOF or DTOC or CTOC ,  balloon message "BKG DEL"
					//         if Tariff =  DMIF or DTIC or CTIC ,  balloon message "BKG POR" 		
					switch(tariff) {
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
					//if Tariff =  DMIF ,  balloon message "BKG DEL for Demurrage Only"
					//         if Tariff =  DMOF ,  balloon message "BKG POR for Demurrage Only" 		
					switch(tariff) {
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL for Demurrage Only"); break;
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POR for Demurrage Only"); break;
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
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
	/**
	 *If your mouse over T2Sheet2 tooltip displays information according to each field.
	 */	
	function t2sheet2_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		var sheetRFAObj=sheetObjects[5];
		var tariff=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), TARIFF);
		with(sheetObj) {
			var colName=ColSaveName(MouseCol());
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					//if Tariff = DMOF , balloon message "BKG POL/CY"
					//         if Tariff = DMIF , balloon message "BKG POD/CY"
					//         if Tariff = DTOC or  CTOC ,  balloon message "BKG POR"
					//         if Tariff = DTIC or CTIC  ,  balloon message "BKG DEL"				
					switch(tariff) {
						case "DMOF": SetToolTipText(MouseRow(), MouseCol(), "BKG POL/CY"); break;
						case "DMIF": SetToolTipText(MouseRow(), MouseCol(), "BKG POD/CY"); break;
						case "DTOC":
						case "CTOC": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						case "DTIC":
						case "CTIC": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						default: 	 SetToolTipText(MouseRow(), MouseCol(), "");
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
 	/**
 	 * According to the Tariff of selected Before Booking Request data  , Multi Origin or Destination must change the title of.
 	 */	  	 
  	function setMultiOriginOrDestTitle() {
		var sheetRFAObj=sheetObjects[5];
		var sheetMultiOrgDestObj=sheetObjects[6];
		var tariff=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), TARIFF);
		var HeadTitle1="";
		var HeadTitle2="|Seq.|Continent|Country|Region|Location";	
		switch(tariff) {
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
  	}	 
  	/*
  	 * Each common pop-up function calls 
  	 */
  	function doProcessPopup(sheetObj, srcName) {
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var propNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), PROP_NO);
  		with(sheetObj) {
  	  		switch(srcName) {
 	  			case "Affiliate":	// Affiliate Inquiry Popup
  	  				var paramVal="?cond_prop_no=" + propNo;
	  				var rtnVal=ComOpenWindowCenter("ESM_PRI_2019_06.do" + paramVal, "", 1020, 335, true); 	  			
 					break;
  	  			case "cust_cd":		// Customer Inquiry Popup
  	  				ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true); 	  			
  					break;
  	  			case SC_TAB:
  	  				ComOpenPopup('EES_DMT_2001.do?prop_no=' + propNo + '&caller=2007', 1200, 700, 'findCustomer', '0,1', false);
  	  				break;
  	  			case RFA_TAB:
  	  				ComOpenPopup('EES_DMT_2003.do?prop_no=' + propNo + '&caller=2007', 1200, 690, 'findCustomer', '0,1', true);
  	  				break;
  	  		} // switch-end
  		} // with-end
  	}
 	function openWinSearchCustomer(srcName) {
		var sheetObj=sheetObjects[0];
		doProcessPopup(sheetObj, srcName);
	}
	/**
   	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
   	 */
     function getCustCd(aryPopupData) {
   		var formObj=document.form;
   		document.form.custCd.value=aryPopupData[0][3];
   		document.form.custNm.value=aryPopupData[0][4];
     }
 	/**
	 * Enter the Customer ID then, when focus out, Customer Name is looking up.
	 */
	function searchCustomerName() {
		var formObj=document.form;
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		if (custCd.length > 2) {
			ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
			ComSetObjValue(formObj.cust_seq, custCd.substring(2));		 
			doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_CUST_NM, SEARCH19);
		}
		else {
			ComClearObject(formObj.custCd);
			ComClearObject(formObj.custNm);
		}
	}
	/**
	 * Screen Load, deactivating and to establishing the definition of Control to function.
	 */	 
	function initDisableControls() {
		 var formObj=document.form;
		 with(formObj) {
			 ComEnableManyObjects(false, custNm);
			 custNm.className="input2";
		 }
	}
	/**
 	 * Date  initializing
 	 */
 	function initOfficeControls() {
 		var formObj=document.form;
 		//Searching conditions Partly to enable / disable processing
 		formObj.cond_type[0].checked=true;
 		//Incl.Sub Office initializing
 		formObj.chkSubOfc.checked=false;
 		if (isPopupWindow()) {
 			formObj.cond_type[2].checked=true;
 			doEnableCondObj("dar");
 		}
 		else {
 			formObj.cond_type[0].checked=true; 			
 			doEnableCondObj("office");
 		}
 	}
	/**
     * Data in the field adds a combo.
     */	
	function addComboItem(comboObj, comboItems, comboType) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
    		if (comboType == "ONE-SELECT") {
    			comboObj.InsertItem(i, comboItem[1], comboItem[0]);
    		}
    		else {
    			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1].toString());
    		}
    	}   		
	}
    /**
     * Select the first item
     */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem=comboItems[0].split(FIELDMARK);
 		comboObj.SetSelectText(checkedItem[0]);
 	}
 	
 	//====================================================================================================================
 	// 수정일시 : 2014.08.12
 	// comboObj_OnCheckClick 함수는 2개의 함수로 변환됨 : comboObj_OnSelect, comboObj_OnChang
 	//==================================================================================================================== 	
  	//S/C Multi Combo click event
//  function combo1_OnCheckClick(comboObj, index, code) {
//  	setMultiCombo(comboObj, index, code) ;
//  }
 	//RFA(Before BKG DAR) Multi Combo click event
// 	function combo2_OnCheckClick(comboObj, index, code) {
// 		setMultiCombo(comboObj, index, code) ;
// 	} 
 	//Tariff Type Multi Combo click event
// 	function combo3_OnCheckClick(comboObj, index, code) {
// 		setMultiCombo(comboObj, index, code) ;
// 	} 	
	 var selComboIndex, selComboCode;
	 function combo1_OnSelect(comboObj ,index, text , code) {
		 selComboIndex = index;
		 selComboCode = code;
	 }
	 function combo1_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }	 	
	 function combo2_OnSelect(comboObj ,index, text , code) {
		 selComboIndex = index;
		 selComboCode = code;
	 }
	 function combo2_OnChange(comboObj) {
		 ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }	 
	 function combo3_OnSelect(comboObj ,index, text , code) {
		 selComboIndex = index;
		 selComboCode = code;
	 }
	 function combo3_OnChange(comboObj) {
		 ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }	 
	//====================================================================================================================

	//multi combo Click Event Catch
 	function combo4_OnCheckClick(comboObj, index, code) {
 		var formObj=document.form;
 		if (formObj.chkSubOfc.checked) {
 			
 			// 체크 이전 상태로 원복 시킨다.
 			var blnCheck = !comboObj.GetItemCheck(index);
 			comboObj.SetItemCheck(index, blnCheck, 0)
 			
 			ComShowCodeMessage('DMT00107');
 		}
 	}
	//multi combo Click Event Catch
 	function combo4_OnKeyDown(comboObj, keycode, shift) { 
 		var formObj=document.form;
 		if (formObj.chkSubOfc.checked) {
 			
 			// 체크 이전 상태로 원복 시킨다.
 			var blnCheck = !comboObj.GetItemCheck(index);
 			comboObj.SetItemCheck(index, blnCheck, 0)
 			
 			ComShowCodeMessage('DMT00107');
 		}
 	}	
	//DEM / DET Office Login Office to the functions that initializing.
   	function setDefaultRefOffice() {
		var formObj=document.form;
		var cboRefOffice=comboObjects[3];
		var itemindex=cboRefOffice.FindItem(ComGetObjValue(formObj.login_ofc_cd), 0);
		if (itemindex == -1) {
			cboRefOffice.SetSelectCode(-1);
		}
		else {
			cboRefOffice.SetSelectCode(-1);
			cboRefOffice.SetSelectCode(ComGetObjValue(formObj.login_ofc_cd), false);
		}
   	}
    function condType_click() {
    	doEnableCondObj(ComGetEvent("value"));
    }
	function doEnableCondObj(condType) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if (condType == "office" || condType == "coverage") {
			ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
		}
		var cboOFCObj=comboObjects[3];
		var cboCNTObj=comboObjects[4];
		var cboRGNObj=comboObjects[5];
		with (formObj) {
			switch(condType){
				case "office":
					//Office Searching conditions of the fields activating
					cboOFCObj.SetSelectIndex(-1);
					cboOFCObj.SetEnable(1);
					cboOFCObj.SetSelectIndex(0);
					ComEnableManyObjects(true, ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					ofcEffDtFm.className="input1";
					ofcEffDtTo.className="input1";
					chkSubOfc.className="trans";
					ComSetObjValue(ofcEffDtFm, ComGetDateAdd(ofcCurrDate, "D", -30));
					ComSetObjValue(ofcEffDtTo, ofcCurrDate);
					setDefaultRefOffice();
					//Coverage Searching conditions of the fields deactivating 
					cboCNTObj.SetSelectText("");
					cboRGNObj.SetSelectText("");
					cboCNTObj.SetEnable(0);
					cboRGNObj.SetEnable(0);
					ComEnableManyObjects(false, location, cvrgEffDtFm, cvrgEffDtTo);
					ComClearManyObjects(location, cvrgEffDtFm, cvrgEffDtTo);
					//DAR Searching conditions 필드 deactivating 
					ComEnableManyObjects(false, sCNo, rFANo, proposalNo, darNo, approvalNo);
					ComClearManyObjects(sCNo, rFANo, proposalNo, darNo, approvalNo);
					ComSetFocus(formObj.sCNo);
				break;
				
				case "coverage":
					//Office Searching conditions of the fields deactivating 
					cboOFCObj.SetSelectText("");
					cboOFCObj.SetEnable(0);
					ComEnableManyObjects(false, ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					ComClearManyObjects(ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					//Coverage Searching conditions of the fields activating 
					cboCNTObj.SetEnable(1);
					cboRGNObj.SetEnable(1);
					ComEnableManyObjects(true, location, cvrgEffDtFm, cvrgEffDtTo);
					location.className="input";
					cvrgEffDtFm.className="input1";
					cvrgEffDtTo.className="input1";
					ComSetObjValue(cvrgEffDtFm, ComGetDateAdd(ofcCurrDate, "D", -30));
					ComSetObjValue(cvrgEffDtTo, ofcCurrDate);
					//DAR Searching conditions  deactivating 
					ComEnableManyObjects(false, sCNo, rFANo, proposalNo, darNo, approvalNo);
					ComClearManyObjects(sCNo, rFANo, proposalNo, darNo, approvalNo);
				break;
				
				case "dar":
					//Office Searching conditions of the fields deactivating 
					//cboOFCObj.Text = "";
					cboOFCObj.SetSelectCode(-1,false);
					cboOFCObj.SetEnable(0);
					ComEnableManyObjects(false, ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					ComClearManyObjects(ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					//Coverage Searching conditions of the fields deactivating 
					cboCNTObj.SetSelectText("");
					cboRGNObj.SetSelectText("");
					cboCNTObj.SetEnable(0);
					cboRGNObj.SetEnable(0);
					ComEnableManyObjects(false, location, cvrgEffDtFm, cvrgEffDtTo);
					ComClearManyObjects(location, cvrgEffDtFm, cvrgEffDtTo);
					//DAR Searching conditions of the fields activating 
					ComEnableManyObjects(true, sCNo, rFANo, proposalNo, darNo, approvalNo);
					sCNo.className="input";
					rFANo.className="input";
					proposalNo.className="input";
					darNo.className="input";
					approvalNo.className="input"
					ComSetFocus(sCNo);
				break;
			}
		}
	}
   /**
    * Multi-select the DEM / DET Office of the Sub-mucin (Sub Office) lookup
    */
	function doInclSubOfc() {
		var formObj=document.form;
		var cboOFCObj=comboObjects[3];
		if(formObj.chkSubOfc.checked) {	// Sub Office 
			if (ComIsEmpty(cboOFCObj.GetSelectCode())) {
				ComShowCodeMessage('COM12113', "DEM/DET Office");
				formObj.chkSubOfc.checked=false;
				return;
			}
			formObj.ofc_cd.value=ComGetObjValue(cboOFCObj);
			formObj.tmp_ofc_cd.value=ComGetObjValue(cboOFCObj);
			doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_REF_OFC,COMMAND01);
		} 
		else {
			cboOFCObj.SetSelectCode(-1, 0);
			cboOFCObj.SetSelectCode(ComGetObjValue(formObj.tmp_ofc_cd), 0);
		}
	}
	/**
	 * Country Search Field, if the Region or State change query information functions that
	 */		
	function cboCountry_OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		var cntCd=comboObj.GetSelectText();
		//If Country is changed, Location information erase
		if (isClearLocation) clearLocation();
		//Region Caption change depending on the Country Code gives.
		switch(cntCd) {
			case "CA":
			case "US":
				Region.innerHTML="State";
				break;
			default:
				Region.innerHTML="Region";
		}
		//If Country is Empty, All Region information is Inquiry.
		if (cntCd.length == 0) {
			doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CVRG,SEARCH01);
			return;	
		}
		//Country belonging to the sub-Region or State should query information.
	    ComSetObjValue(formObj.cnt_cd, cntCd);
		doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CVRG,SEARCH03);
	}
 	/**
 	 * If a change Region or State Search Field, Location Search Field and initializing functions that
 	 */	
	function cboRegion_OnChange(comboObj, Index_Code, Text) {
 		var sheetObj=sheetObjects[0];
 		var formObj=document.form;
 		var rgnCd=comboObj.GetSelectText();
		switch(rgnCd.length) {
			case 2: //State Code to find a parent code.
				ComSetObjValue(formObj.ste_cd, rgnCd);
				doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH17);
				break;
			case 3:	//Region Code to find a parent code.
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH13);
				break;
		}
		//If Region is changed, Location information erase.
		if (isClearLocation) clearLocation();
 	}
	/**
	 * Location Search Field, if entered in the Enter Key Location Country and Region or State that includes a function to query information
	 */		
	function checkLocation() {
		var formObj=document.form;
		var locCd=ComTrim(ComGetObjValue(formObj.location));
		if (locCd.length == 5) {
			isClearLocation=false;
			//Search higher Country, Region or State of  Location includes
			ComSetObjValue(formObj.loc_cd, locCd);
			doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CVRG,SEARCH04);
			isClearLocation=true;
		}
	}
	/**
	 * Location Search Field initializing
	 */		
	function clearLocation() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
 	/**
 	 * S / C & RFA Exception Inqury Inquiry to query data that meet the criteria that define the behavior of the function
 	 */ 	 
	function doActionRetrieve() {
 		var formObj=document.form;
		var sheetSCObj=sheetObjects[0];
		var sheetRFAObj=sheetObjects[5];
		var sCNo=ComTrim(ComGetObjValue(formObj.sCNo));
		var rFANo=ComTrim(ComGetObjValue(formObj.rFANo));
		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
		var darNo=ComTrim(ComGetObjValue(formObj.darNo));
		var apvlNo=ComTrim(ComGetObjValue(formObj.approvalNo));
		//1.Inquiry before, Validation Check performs.
		if (!validateForm(sheetSCObj,formObj,IBSEARCH)) return; 
		//2.Inquiry before deleting the existing query results gives.
		for (var sheetNo=0 ; sheetNo < sheetObjects.length ; sheetNo++) {
			sheetObjects[sheetNo].RemoveAll();
		}
		//3.Inquiry before, Screen to set the parameters from the input received. (Once call S / C, RFA of the Inquiry is set to satisfy all the conditions.)
		setCommonParameters();
		//4.Inquiry the TYPE S/C to check if query is run.
		if (formObj.chkSC.checked) {
			//4-1.Select items on DAR S C No. Or Proposal No. Is entered only if the query is performed.
		    if (	formObj.cond_type[0].checked 
		    	|| 	formObj.cond_type[1].checked 
		    	|| (formObj.cond_type[2].checked && (sCNo != '' || propNo != ''))	) {
				//4-2.S/C 
				doActionIBSheet(sheetSCObj,formObj,IBSEARCH);
				//------------------------------------------------------------------
				currPropNo=sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), PROP_NO);
				currVerSeq=sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), VER);
				currGrpSeq=sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), GRP_SEQ);
				currCvrgSeq=sheetSCObj.GetCellValue(sheetSCObj.GetSelectRow(), CVRG_SEQ);
				//------------------------------------------------------------------				
				if (sheetSCObj.RowCount()> 0) {
					doActionSCChildRetrieve();
				}
		    }
		}
		//5.TYPE is Inquiry RFA (Before Booking) to check if query is run.
		if (formObj.chkRFA.checked) {
			//5-1.Select items on DAR RFA No., Proposal No., DAR No., APVL No. When the input to the lookup is performed.
		    if (	formObj.cond_type[0].checked 
			    || 	formObj.cond_type[1].checked 
			    || (formObj.cond_type[2].checked && (rFANo != '' || propNo != '' || darNo != '' || apvlNo != ''))	) {			
			    //5-2.RFA 
				doActionIBSheet(sheetRFAObj,formObj,IBSEARCH);
				//-------------------------------------------------------------------------
				currDarNo=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), DAR_NO);
				currDarVerSeq=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), VER);
				currRqstSeq=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), RQST_SEQ);
				currCvrgCmbSeq=sheetRFAObj.GetCellValue(sheetRFAObj.GetSelectRow(), CVRG_SEQ);
				//-------------------------------------------------------------------------
				//5-3.If RFA is retrieved, the child will Inquiry information.
				if (sheetRFAObj.RowCount()> 0) {
					doActionRFAChildRetrieve();
				}
		    }
		}
	 }
  	/**
  	 *Click the New button, a function that defines the behavior of
  	 */ 	 
 	function doActionNew() {
 		var formObj=document.form;
 		// reset 
  		formObj.chkSC.checked=true
  		checkType(formObj.chkSC);
  		
  		formObj.chkRFA.checked=true;
  		checkType(formObj.chkRFA);
  		
  		var comboObj = comboObjects[2];	// Tariff Type
        var count = parseInt(comboObj.GetItemCount());
        for(var i=0 ; i < count ; i++) {    
            comboObj.SetItemCheck(i, 1);
        }
  		
  		initOfficeControls();

  		ComClearObject(formObj.custCd);
  		ComClearObject(formObj.custNm);
  		for (var sheetNo=0 ; sheetNo < sheetObjects.length ; sheetNo++) {
  			sheetObjects[sheetNo].RemoveAll();
  		}
  		
  		ComClearObject(formObj.scCurrency);
  		ComClearObject(formObj.rfaCurrency);
  		formObj.custTp.selectedIndex=0;
 	}
 	/**
	 * Click Minimize button, a function that defines the behavior of
	 */ 	 
	function doActionMinimize() {
		 var sheetSCObj=sheetObjects[0];
		 var sheetRFAObj=sheetObjects[5];
		if (conditionLayer.style.display == 'inline') {
			conditionLayer.style.display='none';
			sheetSCObj.SetSheetHeight(MAX_SHEET_HEIGHT);
			sheetRFAObj.SetSheetHeight(MAX_SHEET_HEIGHT);
		}
		else {
			conditionLayer.style.display='inline';
			sheetSCObj.SetSheetHeight(DEF_SHEET_HEIGHT);
			sheetRFAObj.SetSheetHeight(DEF_SHEET_HEIGHT);
		}
	}
 	/**
	 * Click Detail button, a function that defines the behavior of
	 */ 	 
	function doActionDetail() {
		var sheetObj;
		switch (beforetab) {
			case SC_TAB:
				 sheetObj=sheetObjects[0];
				 if (sheetObj.RowCount()< 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 else if (sheetObj.GetSelectRow()== -1) {
					 ComShowCodeMessage("DMT00140", "S/C");
					 return;
				 }
				 break;
			case RFA_TAB:
				 sheetObj=sheetObjects[5];
				 if (sheetObjects[5].RowCount()< 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 else if (sheetObjects[5].GetSelectRow()== -1) {
					 ComShowCodeMessage("DMT00140", "RFA");
					 return;
				 }
				 break;
		}
		doProcessPopup(sheetObj, beforetab);
	}
 	/**
	 * Click Down Excel button , a function that defines the behavior of
	 */ 	 
	function doActionDownExcel() {
		 switch (beforetab) {
			 case SC_TAB:
				 if (sheetObjects[0].RowCount()< 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(				 sheetObjects[0]), SheetDesign:1,Merge:1 });
				 break;
			 case RFA_TAB:
				 if (sheetObjects[5].RowCount()< 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 sheetObjects[5].Down2Excel( {DownCols: makeHiddenSkipCol(				 sheetObjects[5]), SheetDesign:1,Merge:1 });
				 break;
		 }
	}
    /**
     * Close button click,  function that defines the behavior of running
     */
    function doActionClose() {
    	//ComClosePopup();
    	window.close();
    }
  	/**
  	 * S / C & RFA Exception Inqury query results, select the S / C of the child data Inquiry function that defines the behavior
  	 */ 	 
 	function doActionSCChildRetrieve() {
 		var formObj=document.form;
 		var sheetSCObj=sheetObjects[0];
 		var sheetTFObj=sheetObjects[1];	//Tiered Free Time
 		var sheetRTObj=sheetObjects[2];	//Rate Adjustment
 		var sheetACUSTObj=sheetObjects[3];	//Actual Customer
 		var sheetCMDTObj=sheetObjects[4];	//Commodity
 		with(sheetSCObj) {
			ComSetObjValue(formObj.prop_no, 		GetCellValue(GetSelectRow(), PROP_NO));
			ComSetObjValue(formObj.sc_expt_ver_seq, GetCellValue(GetSelectRow(), VER));
			ComSetObjValue(formObj.sc_expt_grp_seq, GetCellValue(GetSelectRow(), GRP_SEQ));
			ComSetObjValue(formObj.scCurrency, 		GetCellValue(GetSelectRow(), CURR_CD));
 		}
 		sheetTFObj.RemoveAll();
 		sheetRTObj.RemoveAll();
 		sheetACUSTObj.RemoveAll();
 		sheetCMDTObj.RemoveAll();
 		
 		//Tiered Free Time
 		doActionIBSheet(sheetTFObj, formObj, IBSEARCH);
 		//Rate Adjustment
 		doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
 		//Actual Customer
 		doActionIBSheet(sheetACUSTObj, formObj, IBSEARCH);
 		//Commodity
 		doActionIBSheet(sheetCMDTObj, formObj, IBSEARCH);
 	}
   	/**
   	 * S/C & RFA Exception Inqury query results,
   	 * select the RFA (Before Adjustment Request) to define the behavior of the child data Inquiry functions that
   	 */ 	 
  	function doActionRFAChildRetrieve() {
  		var formObj=document.form;
 		var sheetORGDSTObj=sheetObjects[6];	//Multi Origin or Destination
 		var sheetRTObj=sheetObjects[7];	//Rate Adjustment
 		
 		var sheetFTObj=sheetObjects[8];	//Rate Adjustment
 		var sheetCMDTObj=sheetObjects[9];	//Rate Adjustment
  		with(sheetObjects[5]) {
			ComSetObjValue(formObj.rfa_expt_dar_no, 	GetCellValue(GetSelectRow(), DAR_NO));
			ComSetObjValue(formObj.rfa_expt_ver_seq, 	Number(GetCellValue(GetSelectRow(), VER)));
			ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	GetCellValue(GetSelectRow(), RQST_SEQ));
 	 		//Rate Adjustment Currency 
			ComSetObjValue(formObj.rfaCurrency, 		GetCellValue(GetSelectRow(), CURR_CD));
			
			ComSetObjValue(formObj.rfa_expt_mapg_seq, 	Number(GetCellValue(GetSelectRow(), MAPG_SEQ)));
			ComSetObjValue(formObj.cvrg_cmb_seq, 		Number(GetCellValue(GetSelectRow(), CVRG_SEQ)));
  		}
 		sheetORGDSTObj.RemoveAll();
 		sheetRTObj.RemoveAll();
 		
 		sheetFTObj.RemoveAll();
 		sheetCMDTObj.RemoveAll();
		//Multi Origin or Destination
		doActionIBSheet(sheetORGDSTObj, formObj, IBSEARCH);
		//Rate Adjustment
		doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
		
		doActionIBSheet(sheetFTObj, formObj, IBSEARCH);	
		doActionIBSheet(sheetCMDTObj, formObj, IBSEARCH);	
  	}
   	/**
  	 * Screen stage, the input Inquiry conditions in data lookup function to set the parameters
  	 */ 	    
     function setCommonParameters() {
  		var formObj=document.form;
  		var cboSCObj=comboObjects[0];
  		var cboRFAObj=comboObjects[1];
  		var cboTariffObj=comboObjects[2];
  		var cboOFCObj=comboObjects[3];
  		var cboCNTObj=comboObjects[4];
  		var cboRGNObj=comboObjects[5];
  		with(formObj) {
	  		//1.Set S/C Type
			ComSetObjValue(ver_sts_cd, cboSCObj.GetSelectCode());
	 		//2.Set RFA Type
			ComSetObjValue(rqst_sts_cd, cboRFAObj.GetSelectCode());
	 		//3.Set Tariff
	  		var trfCd=ComTrim(cboTariffObj.GetSelectText());
	  		if (trfCd.indexOf("All") != -1) {
	  			trfCd=trfCd.replace("All,", "");
	  		}
	  		ComSetObjValue(formObj.tariff, trfCd);
	  		//4-1.When selected distinctions Office Inquiry
	  		if (cond_type[0].checked) {
	  			ComSetObjValue(ofc_cd, 		ComTrim(cboOFCObj.GetSelectText()));
	  			ComSetObjValue(fm_dt, 		ComTrim(ComGetObjValue(ofcEffDtFm)));
	  			ComSetObjValue(to_dt, 		ComTrim(ComGetObjValue(ofcEffDtTo)));
	  			ComSetObjValue(cond_tp, 	"OFC");
	  		}
	  		//4-2.When selected distinctions Coverage Inquiry 
	  		else if (cond_type[1].checked) {
	  	  		var cntCd=ComTrim(cboCNTObj.GetSelectText());
	  	  		ComSetObjValue(cnt_cd, cntCd);
	  	  		if (cntCd == "US" || cntCd == "CA") {
	  	  			ComSetObjValue(ste_cd, 	ComTrim(cboRGNObj.GetSelectText()));
	  	  			ComSetObjValue(rgn_cd, 	"");
	  	  		}
	  	  		else {
	  	  			ComSetObjValue(rgn_cd, 	ComTrim(cboRGNObj.GetSelectText()));
	  	  			ComSetObjValue(ste_cd, 	"");
	  	  		}
	  	  		ComSetObjValue(loc_cd, 		ComTrim(ComGetObjValue(location)));
	  			ComSetObjValue(fm_dt, 		ComTrim(ComGetObjValue(cvrgEffDtFm)));
	  			ComSetObjValue(to_dt, 		ComTrim(ComGetObjValue(cvrgEffDtTo))); 
	  			ComSetObjValue(cond_tp, 	"CVRG");
	  		}
	  		//4-3.When selected distinctions DAR Inquiry 
	  		else if (cond_type[2].checked) {
	  			ComSetObjValue(sc_no, 		ComTrim(ComGetObjValue(sCNo)));
	  			ComSetObjValue(rfa_no, 		ComTrim(ComGetObjValue(rFANo)));
	  			ComSetObjValue(prop_no, 	ComTrim(ComGetObjValue(proposalNo)));
	  			ComSetObjValue(dar_no, 		ComTrim(ComGetObjValue(darNo)));
	  			ComSetObjValue(apvl_no, 	ComTrim(ComGetObjValue(approvalNo)));
	  			ComSetObjValue(cond_tp, 	"DAR");
	  		}
	  		//5.Set Customer
			var custCode=ComTrim(ComGetObjValue(custCd));
			var custType=ComTrim(ComGetObjValue(custTp));
			if (custCode != "") {
				switch (custType) {
					case "":
						ComSetObjValue(cust_cd, 	custCode);
						ComSetObjValue(act_cust_cd, custCode);
						break;
					case "CUST":
						ComSetObjValue(cust_cd, 	custCode);
						ComSetObjValue(act_cust_cd, "");
						break;
					case "A/CUST":
						ComSetObjValue(cust_cd, 	"");
						ComSetObjValue(act_cust_cd, custCode);	    						
						break;
				}
			}
			else {
				ComSetObjValue(cust_cd, 	"");
				ComSetObjValue(act_cust_cd, "");
			}
  		}
     }
 	/**
   	 * Type check box is selected, or choose a function that handles the revocation if
   	 */  	 
  	 function checkType(chkObj) {
  		 var cboTypeObj;
  		 var cboCode;
  		 switch(chkObj.name) {
	  		 case "chkSC":
	  			 cboTypeObj=comboObjects[0];
	  			 cboCode="L";
	  			 break;
	  		 case "chkRFA":
	  			 cboTypeObj=comboObjects[1];
	  			 cboCode="A";
	  			 break;
  		 }

      	if (!chkObj.checked) {
 	    	for (var i=0 ; i < cboTypeObj.GetCount ; i++) {
 	    		cboTypeObj.SetItemCheck(i,0);
 	    	}
 	    	cboTypeObj.SetEnable(0);
     	}
     	else {
     		cboTypeObj.SetEnable(1);
     		cboTypeObj.SetSelectIndex(-1);
     		cboTypeObj.SetSelectCode(cboCode);
     	}  		 
  	 }
  	/**
  	 * DAR search field, enter the value of the items in a particular field when the other fields Clear all makes.
  	 */
  	function clearNoSelectDARFields() {
  	    var formObj=document.form;
  		with(formObj) {
  			switch(ComGetEvent("name")) {
  				case "sCNo":
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  				case "rFANo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  				case "proposalNo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  				case "darNo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  				case "approvalNo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					break;
  			}
  		}		
  	}
   	/**
  	 * 2007 Screen pop up
  	 */
    function isPopupWindow() {
  	    var formObj=document.form;
  		if (ComGetObjValue(formObj.caller) != "" && (ComGetObjValue(formObj.sCNo) != "" || ComGetObjValue(formObj.rFANo) != "")) {
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