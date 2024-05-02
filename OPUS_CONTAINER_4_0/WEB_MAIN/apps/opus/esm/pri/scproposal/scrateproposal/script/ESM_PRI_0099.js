/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0099.js
*@FileTitle  : S/C Proposal & Amendment Creation - Rate - Excel Upload(Horizontal)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/11
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for Commodity Group  
     */
    function ESM_PRI_0099() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;

    var isOViaMandatory=false;
    var isDViaMandatory=false;
    var isDirCallVisible = false;
    var isClear = true;
    
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
	function processButtonClick() {
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_template":
				downform.submit();
				break;
			case "btn_openfile":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
				break;
			case "btn_check":
				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC01);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Initializing and setting Sheet basics <br>
	 * Setting body tag's onLoad event handler <br>
	 * Adding pre-handling function after loading screen on the browser  <br>
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var gen_spcl_rt_tp_cd = document.form.gen_spcl_rt_tp_cd.value;
    	if(gen_spcl_rt_tp_cd == "G"){
    		sheetObjects[0].SetColEditable("cust_seq", 0);
    	} else {
    		sheetObjects[0].SetColEditable("cust_seq", 1);
    	}
    	
		bIsReqUsr=document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr=document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
		toggleButtons("INIT");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
		sheetObjects[0].GetEditableColorDiff(1);
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
        case 1: // sheet1 init	
        	with(sheetObj){
            
		        var HeadTitle1="|Type|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Commodity Note\nCopy|Route Note\nCopy";
		        var HeadTitle2="|Type|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code| Code|Code|Description|Term|Transmode|Y/N|Prefix|CGO TYPE|20|40|40HC|45|Commodity Note\nCopy|Route Note\nCopy";
		  
	            var headCount=ComCountHeadTitle(HeadTitle2);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0, ToolTip:1 } );
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"type",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"prefix_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1  },
		                     {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2  },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_20",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9  },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9  },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40hc",                  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9  },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_45",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9  },
		                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_copy",        	 KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6  },
		                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_note_copy",        	 KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6  },];
	            
	            InitColumns(cols);
	            SetColProperty("type", {AcceptKeys:"[CUD]" , InputCaseSensitive:1} );
	            SetColProperty(0 ,"cmdt_hdr_seq" , {AcceptKeys:"[0123456789]"});
	            SetColProperty(0 ,"prc_cmdt_def_cd" , {AcceptKeys:"E|[0123456789;]" , InputCaseSensitive:1});
	            SetColProperty(0 ,"cust_seq" , {AcceptKeys:"E|[0123456789;]" , InputCaseSensitive:1});
	            SetColProperty(0 ,"rout_seq" , {AcceptKeys:"[0123456789]" , InputCaseSensitive:1});
	            SetColProperty(0 ,"org_rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789;]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"org_rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789;]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"dest_rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789;]" , InputCaseSensitive:1});
	        	SetColProperty(0 ,"dest_rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789;]" , InputCaseSensitive:1});
	        	
	        	SetColProperty(0 ,"org_rcv_de_term_nm" , {AcceptKeys:"E|[0123456789; ]"});
	        	SetColProperty(0 ,"org_prc_trsp_mod_nm" , {AcceptKeys:"E|[0123456789/;]"});
	        	SetColProperty(0 ,"dest_rcv_de_term_nm" , {AcceptKeys:"E|[0123456789; ]"});
	        	SetColProperty(0 ,"dest_prc_trsp_mod_nm" , {AcceptKeys:"E|[0123456789/;]"});
	        	
	        	SetColProperty("dir_call_flg", {ComboText:"|Y|N", ComboCode:"|Y|N"} );
	        	SetColProperty("prefix_nm", {ComboText:"|D|R|F|O|T", ComboCode:"|D|R|F|O|T"} );
	        	SetColProperty("prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
	        	
	        	SetColProperty(0 ,"cmdt_note_copy" , {AcceptKeys:"[0123456789]"});
	        	SetColProperty(0 ,"rout_note_copy" , {AcceptKeys:"[0123456789]"});
	           
	            SetEditable(1);
	            SetShowButtonImage(2);
	            SetSelectionMode(0); //0:Cell, 1:Row
	            resizeSheet();
            
            }
            break;
	        
        case 2: // 
        	with(sheetObj){
            
		        var HeadTitle1="|Type|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)";
		        var HeadTitle2="|Type|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code| Code|Code|Description|Term|Transmode|Y/N|Prefix|CGO TYPE|20|40|40HC|45";
		  
	            var headCount=ComCountHeadTitle(HeadTitle2);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0, ToolTip:1 } );
	
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"type",                       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",               	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                   	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"prefix_nm",                  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_20",                    	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40",                    	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40hc",                  	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_45",                    	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_prc_cmdt_def_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_cust_seq",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_org_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_dest_rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_org_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_dest_rout_via_port_def_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_org_rcv_de_term_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_org_prc_trsp_mod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_dest_rcv_de_term_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_dest_prc_trsp_mod_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_prc_cmdt_def_dup",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_org_dest_dup",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_cmdt_hdr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_rout_seq",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_org_semi",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_dest_semi",              	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
				           
	            
	            InitColumns(cols);
	            SetEditable(1);
	            SetVisible(0);
            
            }
            break;

		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		if (!isClear) {
			if(KeyCode == 9) {
				while (true) {
		             if (Col > sheetObj.LastCol()) {
		                 Row++;
		                 Col=1;
		             }
		             if (Row > sheetObj.LastRow()) {
		                 Row=sheetObj.HeaderRows();
		             }
		             if (sheetObj.GetCellBackColor(Row, Col).toUpperCase() == "#FF0000") {
		                 sheetObj.SelectCell(Row, Col, false);
		                 break;
		             }
		             Col++;
		        }
			}
			
		}
	}
	
	function setCellEditable(sheetObj, rowIdx, ieditable){
		var formObj = document.form;
		for(var i = 0; i < sheetObj.LastCol(); i++){
			var saveNm = sheetObj.ColSaveName(0, i);
			
			if(saveNm == "ibflag" || saveNm == "type" || saveNm == "cmdt_hdr_seq" || saveNm == "rout_seq"){
				sheetObj.SetCellEditable(rowIdx, saveNm, 1);
		    } else if(saveNm == "prc_cmdt_def_nm"  || saveNm == "cust_lgl_eng_nm" || saveNm == "org_rout_pnt_loc_def_nm" || saveNm == "dest_rout_pnt_loc_def_nm"){
				sheetObj.SetCellEditable(rowIdx, saveNm, 0);
		    } else {
				sheetObj.SetCellEditable(rowIdx, saveNm, ieditable);
				if(saveNm == "cust_seq"){
					var gen_spcl_rt_tp_cd = formObj.gen_spcl_rt_tp_cd.value;
			    	if(gen_spcl_rt_tp_cd == "G"){
			    		sheetObj.SetCellEditable(rowIdx, saveNm, 0);
			    	} else {
			    		sheetObj.SetCellEditable(rowIdx, saveNm, ieditable);
			    	}
				}
			}
		}
	}
	
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		
		var typeVal = sheetObj.GetCellValue(Row, "type");
		if(typeVal == "D" || typeVal == ""){
			setCellEditable(sheetObj, Row, 0);

		} else {
			setCellEditable(sheetObj, Row, 1);
		}
		setRateAmountEnable(sheetObj, Row, Value);
	}
	
	function setRateAmountEnable(sheetObj, Row, Value){

		var typeVal = sheetObj.GetCellValue(Row, "type");
		if(typeVal=="C" || typeVal=="U"){
			if(Value == "F" || Value == "O"){
				sheetObj.SetCellEditable(Row, "rate_20"  , 1);
				sheetObj.SetCellEditable(Row, "rate_40"  , 1);
				sheetObj.SetCellEditable(Row, "rate_40hc", 1);
				sheetObj.SetCellEditable(Row, "rate_45"  , 0);
				
				sheetObj.SetCellValue(Row, "rate_45"  , "", 0);
			} else if(Value == "T"){
				sheetObj.SetCellEditable(Row, "rate_20"  , 1);
				sheetObj.SetCellEditable(Row, "rate_40"  , 1);
				sheetObj.SetCellEditable(Row, "rate_40hc", 0);
				sheetObj.SetCellEditable(Row, "rate_45"  , 0);
				
				sheetObj.SetCellValue(Row, "rate_40hc"  , "", 0);
				sheetObj.SetCellValue(Row, "rate_45"  , "", 0);
			} else {
				sheetObj.SetCellEditable(Row, "rate_20"  , 1);
				sheetObj.SetCellEditable(Row, "rate_40"  , 1);
				sheetObj.SetCellEditable(Row, "rate_40hc", 1);
				sheetObj.SetCellEditable(Row, "rate_45"  , 1);
			}
		} 
		
	}

	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {

			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
		        case IBSEARCH_ASYNC20: // retrieving PRI_SVC_SCP_PPT_MAPG  
		            var sXml="";  
		            isOViaMandatory=false;
		            isDViaMandatory=false;
		            isDirCallVisible = false;
					formObj.f_cmd.value=COMMAND17;
	 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
					var arrTemp=ComPriXml2Array(sXml, "cd|nm");
					if (arrTemp != null && arrTemp.length > 0) {
						for (var i=0; i < arrTemp.length; i++) {
							var pptCd=arrTemp[i][1];
							if (pptCd == "SOVA") {
								isOViaMandatory=true;
							} else if (pptCd == "SDVA") {
								isDViaMandatory=true;
							} else if (pptCd == "SDRC") {
								isDirCallVisible = true;
							}
						}
					}
		            break;
				case IBSEARCH_ASYNC02: // Open
	 				sheetObj.LoadExcel({ Mode:"HeaderMatch"}); //,WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:""});
		         	break;
		         	
				case IBSEARCH_ASYNC01: // Check
					
		        	ComOpenWait(true);
		        	
		        	if(!isSheetModifyForSave(sheetObjects[0])){
		        		ComOpenWait(false);
		        		ComShowCodeMessage("PRI01042","Type");
		                return false;
		        	}
		        	
		            if (!validateForm(sheetObjects[0], document.form, sAction)) {
		            	isClear = false;
		            	ComOpenWait(false);
		                return false;
		            }
		            
		            try {
		        		 if(sheetObjects[0].RowCount() <= 0) return;
	
		        		 sheetObjects[0].SetWaitImageVisible(1);

		                 ComOpenWait(true);
		                 formObj.f_cmd.value=COMMAND02;
		                 var sParam=FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString();
		                 var sXml=sheetObjects[1].GetSearchData("ESM_PRI_0099GS.do", sParam);
		                 var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
		                 if (backendJobKey.length > 0) {
		                     	
		                	 sheetObjects[1].RequestTimeOut = 3000;
		                	 sheetObjects[1].SetWaitTimeOut(3000);
		                     timer=setInterval("getBackEndJobStatusForCheck(sheetObjects[1], '" + backendJobKey + "');", 3000); 
		                 }else{
		                     ComOpenWait(false);
		                 }
		                 
		             }catch(e){
		                 ComShowMessage(e.message);
		                 ComOpenWait(false);
		             }
		         	break;
		         	
		        case IBSAVE: // Save
		        	ComOpenWait(true);
		        	
		        	if(!isSheetModifyForSave(sheetObj)){
		        		ComOpenWait(false);
		        		ComShowCodeMessage("PRI00301");
		                return false;
		        	}
		        	
		            if (!validateForm(sheetObj,document.form,sAction)) {
		            	isClear = false;
		            	ComOpenWait(false);
		                return false;
		            }
		            if (!ComPriConfirmSave()) {
		            	ComOpenWait(false);
		            	return false;
		            }
		            
		            
		            try {
		        		 if(sheet1.RowCount() <= 0) return;
	
		                 sheet1.SetWaitImageVisible(1);

		                 ComOpenWait(true);
		                 formObj.f_cmd.value=MODIFY02;
		                 var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
		                 var sXml=sheetObj.GetSearchData("ESM_PRI_0099GS.do", sParam);
		                 var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
		                 if (backendJobKey.length > 0) {
		                     formObj.backendjob_key.value=backendJobKey;
	
		                     sheet1.RequestTimeOut = 3000;
		                     sheet1.SetWaitTimeOut(3000);
		                     timer=setInterval(getBackEndJobStatus, 3000); 
		                 }else{
		                     ComOpenWait(false);
		                 }
		                 
		             }catch(e){
		                 ComShowMessage(e.message);
		                 ComOpenWait(false);
		             }
		             break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
            ComOpenWait(false);
        } finally {
        	if (sAction == IBSAVE) {
        		return;
        	}
        }
	}
	
	function isSheetModifyForSave(sheetObj){
		var result = false;
		var sIdx=sheetObj.HeaderRows();
		var eIdx=sheetObj.LastRow();
		var typeCnt = 0;
		
		for(var i = sIdx; i <= eIdx; i++){
			var originType = sheetObj.GetCellValue(i, "type");
			if(originType != undefined || originType != null || originType != ""){
				//lower case > upper case
				sheetObj.SetCellValue(i, "type", sheetObj.GetCellValue(i, "type").toUpperCase());
				var upperType = sheetObj.GetCellValue(i, "type");
				if(upperType == "C" || upperType == "U"  || upperType == "D"){
					typeCnt+=1;
				}else{
					sheetObj.SetCellValue(i, "type", "");
				}
			}
		}
		
		if(typeCnt > 0){
			result = true;
		}
		return result;
	}
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		ComOpenWait(false);
		if(isExceedMaxRow(msg))return;
		if (sheetObj.RowCount()> 0) {
			toggleButtons("LOAD");
		} else {
			toggleButtons("INIT");
		}
		
		var sIdx=sheetObj.HeaderRows();
		var eIdx=sheetObj.LastRow();
		var iErrCnt = 0;
		for(var i = sIdx; i <= eIdx; i++){
			var val = sheetObj.GetCellValue(i, "prefix_nm");
			setRateAmountEnable(sheetObj, i, val);
		}
		
		isClear = true;
		
	}
	
	function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		var iErrCnt = 0;
		var unValidRows = "";
		
		//success
		if(Code == 0) {
			var sIdx=sheetObj.HeaderRows();
			var eIdx=sheetObj.LastRow();
			for(var i = sIdx; i <= eIdx; i++){
				var type = sheetObj.GetCellValue(i, "type");
				if(type == "C" || type == "U"){
					
					var sCmdt 			= sheetObj.GetCellValue(i, "chk_prc_cmdt_def_cd");
					var sCust 			= sheetObj.GetCellValue(i, "chk_cust_seq");
					var sOrgCd 			= sheetObj.GetCellValue(i, "chk_org_rout_pnt_loc_def_cd");
					var sOrgTerm 		= sheetObj.GetCellValue(i, "chk_org_rcv_de_term_nm");
					var sOrgTrsp 		= sheetObj.GetCellValue(i, "chk_org_prc_trsp_mod_nm");
					var sDestCd 		= sheetObj.GetCellValue(i, "chk_dest_rout_pnt_loc_def_cd");
					var sDestTerm 		= sheetObj.GetCellValue(i, "chk_dest_rcv_de_term_nm");
					var sDestTrsp 		= sheetObj.GetCellValue(i, "chk_dest_prc_trsp_mod_nm");
					var sOrgVia 		= sheetObj.GetCellValue(i, "chk_org_rout_via_port_def_cd");
					var sDestVia 		= sheetObj.GetCellValue(i, "chk_dest_rout_via_port_def_cd");
					var sCmdtDupCnt		= sheetObj.GetCellValue(i, "chk_prc_cmdt_def_dup");
					var sLocDupCnt 		= sheetObj.GetCellValue(i, "chk_org_dest_dup");
					var sCmdtHdrSeqCnt 	= sheetObj.GetCellValue(i, "chk_cmdt_hdr_seq");
					var sRoutSeqCnt 	= sheetObj.GetCellValue(i, "chk_rout_seq");
					var sOrgSemi 	    = sheetObj.GetCellValue(i, "chk_org_semi");
					var sDestSemi 	    = sheetObj.GetCellValue(i, "chk_dest_semi");
					
					if(sCmdt == "F"){
						add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sCust == "F"){
						add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sOrgCd == "F"){
						add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sOrgTerm == "F"){
						add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sOrgTrsp == "F"){
						add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sDestCd == "F"){
						add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sDestTerm == "F"){
						add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sDestTrsp == "F"){
						add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sOrgVia == "F"){
						add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sDestVia == "F"){
						add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
						iErrCnt+=1;
					}
					if(sCmdtDupCnt != "0"){
						var headerNm = getHeaderName(sheetObj, "prc_cmdt_def_cd");
						add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00342", headerNm+" in pre-saved data"));
						iErrCnt+=1;
					}
					if(sLocDupCnt != "0"){
						add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00342", "Origin/Destination's Combination in pre-saved data"));
						iErrCnt+=1;
					}
					if(sCmdtHdrSeqCnt == "F"){
						add2Tooltip(i, "cmdt_hdr_seq", ComGetMsg("PRI03004", "CMDT Seq."));
						iErrCnt+=1;
					}
					if(sRoutSeqCnt == "F"){
						add2Tooltip(i, "rout_seq", ComGetMsg("PRI03004", "Rout Seq."));
						iErrCnt+=1;
					}
					if(sOrgSemi == "F"){
						add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI03037", "Origin"));
						iErrCnt+=1;
					}
					if(sDestSemi == "F"){
						add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI03037", "Destination"));
						iErrCnt+=1;
					}
					
					
					var realIdx = (i+1) - sheetObj.HeaderRows();
	        		if(unValidRows == ""){
	        			if(isErrRow(sheetObj, i)){
	        				unValidRows = String(realIdx);
	        			}
	        		} else {
	        			if(isErrRow(sheetObj, i)){
	        				unValidRows = unValidRows + ", " + String(realIdx);
	        			}
	        		}
					
				}
			}//end for
			
			if(iErrCnt > 0){
				isClear = false;
				toggleButtons("LOAD");
			} else {
				isClear = true;
				toggleButtons("CHECK");
			}
			
		}
		
		
		ComOpenWait(false);
		if(iErrCnt > 0){
			ComShowMessage(ComGetMsg("COM12114", unValidRows + " row."));
		}

	}
	
	/** 
	 * about BackEndJob : checking until Status='3'<br>
	 */ 
	function getBackEndJobStatus() {
		var form=document.form;	
	    form.f_cmd.value=COMMAND01;
	    var sXml=sheet1.GetSearchData("ESM_PRI_0099GS.do", FormQueryString(form));
	    var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	    if (jobState == "3") {
	    	clearInterval(timer);
	    	ComOpenWait(false);
	    	getWorkAfterBackEndJob();
	    } else if (jobState == "4") {  
	        ComShowCodeMessage("PRI03032"); 
	        clearInterval(timer);	
	        ComOpenWait(false);	
	    } else if (jobState == "5") {
	        ComShowCodeMessage("PRI03032"); 
	        clearInterval(timer);
	        ComOpenWait(false);	
	    }
	}
	
	/** 
	 * about BackEndJob : checking until Status='3'<br>
	 */ 
	function getBackEndJobStatusForCheck(sheetObj, sKey) {
		var form=document.form;	
	    var sXml=sheetObj.GetSearchData("ESM_PRI_0099GS.do?f_cmd=" + COMMAND03 + "&backendjob_key=" + sKey);
	    var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	    if (jobState == "3") {
	    	clearInterval(timer);
	    	getWorkAfterBackEndJobForCheck(sheetObj, sXml);
	    } else if (jobState == "4") {  
	        ComShowCodeMessage("PRI03033"); 
	        clearInterval(timer);	
	        ComOpenWait(false);	
	    } else if (jobState == "5") {
	        ComShowCodeMessage("PRI03033"); 
	        clearInterval(timer);
	        ComOpenWait(false);	
	    }
	}
	
	/*
	 * After BackEndJob is successed, Do work
	 */
	function getWorkAfterBackEndJob(){
		opener.saveCurRowPos();
        opener.reloadPagePostTr();
        opener.reloadAll();
        ComPriSaveCompleted();
        ComClosePopup();
	}
	
	/*
	 * After BackEndJob is successed, Do work
	 */
	function getWorkAfterBackEndJobForCheck(sheetObj, sXml){
		//sheet2
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		
		
	}
	
	
	function getHeaderName(sheetObj, ColNm){
		var result = "";
		var header1 = sheetObj.GetCellValue(0, ColNm);
		var header2 = sheetObj.GetCellValue(1, ColNm);
		if(header1 == header2){
			result = header1;
		} else {
			result = header1 +" "+ header2;
		}
		return result;
	}
	
	function isNullForRequiredField(sheetObj, Row, ColNm){
		var result = 0;
		var strVal = sheetObj.GetCellValue(Row, ColNm);
		if(strVal == undefined || strVal == null || strVal == ""){
			result = 1;
			
			var headerNm = getHeaderName(sheetObj, ColNm);
			add2Tooltip(Row, ColNm, ComGetMsg("PRI00316", headerNm));
		}
		return result;
	}
	
	function isNullInMultiField(sheetObj, Row, ColNm){
		var result = 0;
		var strVal = sheetObj.GetCellValue(Row, ColNm);
		if(strVal != undefined && strVal != null && strVal != ""){
			var arrTmp = strVal.split(";");
			if(arrTmp != undefined && arrTmp != null && arrTmp != null && arrTmp.length > 0){
				for(var i = 0; i < arrTmp.length; i++ ){
					if(arrTmp[i] == null || arrTmp[i] == ""){
						result = 1;
						break;
					}
				}
				
				if(result > 0){
					var headerNm = getHeaderName(sheetObj, ColNm);
					add2Tooltip(Row, ColNm, ComGetMsg("PRI03034", headerNm));
				}
			}
		} 
		return result;
	}
	
	function isNullForRequiredRateField(sheetObj, Row){
		var result = 0;
		
		var rate_20 = sheetObj.GetCellValue(Row, "rate_20");
		var rate_40 = sheetObj.GetCellValue(Row, "rate_40");
		var rate_40hc = sheetObj.GetCellValue(Row, "rate_40hc");
		var rate_45 = sheetObj.GetCellValue(Row, "rate_45");
		
		if(rate_20 == "" && rate_40 == "" && rate_40hc == "" && rate_45 == "" &&
				(rate_20 != "0" && rate_40 != "0" && rate_40hc != "0" && rate_45 != "0")){
			result = 1;
			
			var headerNm = sheetObj.GetCellValue(0, "rate_20");
			add2Tooltip(Row, "rate_20", ComGetMsg("PRI00316", headerNm));
		}
		return result;
	}
	
	function isCellDup(sheetObj, Row, ColNm){
		var result = 0;
		var strVal = sheetObj.GetCellValue(Row, ColNm);
		
		var arrVal1 = strVal.split(";");
		var arrVal2 = strVal.split(";");
		if(arrVal1.length > 0){
			for(var i = 0; i < arrVal1.length; i++){
				var strOrgVal = arrVal1[i];
				var tmpDupCnt = 0;
				for(var j = 0; j < arrVal2.length; j++){
					var strTarVal = arrVal2[j];
					if(strOrgVal == strTarVal){
						tmpDupCnt+=1;
					}
				}
				if(tmpDupCnt > 1){
					result = 1;
					break;
				}
			}
		}
		
		
		if(result == "1"){
			var headerNm = getHeaderName(sheetObj, ColNm);
			add2Tooltip(Row, ColNm, ComGetMsg("PRI00302", headerNm));
		}
		
		
		return result;
	}
	

    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj, formObj, sAction) {
    	var result = true;
        switch (sAction) {
        case IBSEARCH_ASYNC01: // Check
        	
        	toggleButtons("LOAD");
        	
        	var errCnt = 0;
        	var amdtSeq = formObj.amdt_seq.value;
        	
        	//Check Default Value
        	if (formObj.prop_no.value == "" || amdtSeq == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}

        	//Clean ToolTip
        	clearTooltip();
        	
        	//Check Validation
        	var fRowIdx = sheetObj.HeaderRows();
        	var lRowIdx = sheetObj.LastRow();
        	var unValidRows = "";
        	for(var i = fRowIdx; i <= lRowIdx; i++){
        		var sType = sheetObj.GetCellValue(i, "type");
        		if(sType == undefined || sType == null || sType == "") continue;
        		if(sType == "U" || sType == "C"){
        			var gen_spcl_rt_tp_cd = document.form.gen_spcl_rt_tp_cd.value;
        			
        			//(1) Mandatory
        			if(sType == "U"){
        				errCnt+=isNullForRequiredField(sheetObj, i, "cmdt_hdr_seq");
        				errCnt+=isNullForRequiredField(sheetObj, i, "rout_seq");
        				errCnt+=isNullForRequiredField(sheetObj, i, "dir_call_flg");
        				if(amdtSeq == "0" && !existsOpnerData(sheetObj, i)){
        					ComShowCodeMessage("PRI00351");
        					return false;
        				}
        			} else if(sType == "C"){
        				var strCmdt = sheetObj.GetCellValue(i, "cmdt_hdr_seq");
        				var strRout = sheetObj.GetCellValue(i, "rout_seq");
        				if( (strCmdt != undefined && strCmdt != "" && strRout != undefined && strRout != "") ||
        						( (strCmdt == undefined || strCmdt == "") && strRout != undefined && strRout != "") 	){
        					
        					var headerNm1 = getHeaderName(sheetObj, "cmdt_hdr_seq");
        					var headerNm2 = getHeaderName(sheetObj, "rout_seq");
        					var headerNm  = headerNm1+" and "+headerNm2;
        					errCnt++;
        					if((strCmdt == undefined || strCmdt == "") && strRout != undefined && strRout != "") {
        						add2Tooltip(i, "rout_seq", ComGetMsg("PRI03036", headerNm2));
        					} else {
        						add2Tooltip(i, "cmdt_hdr_seq", ComGetMsg("PRI03035", headerNm));
        					}
        					
        				}
        				
        				//(4)check note copy
        				var strCcopy = sheetObj.GetCellValue(i, "cmdt_note_copy");
        				var strRcopy = sheetObj.GetCellValue(i, "rout_note_copy");

        				if (strCcopy.length == 0 && strRcopy.length != 0){
        					var headerNm3 = getHeaderName(sheetObj, "cmdt_note_copy");
        					errCnt++;
        					add2Tooltip(i, "cmdt_note_copy", ComGetMsg("PRI00335", headerNm3));
        				}
        				
        			} 
        			errCnt+=isNullForRequiredField(sheetObj, i, "prc_cmdt_def_cd");
        			errCnt+=isNullForRequiredField(sheetObj, i, "org_rout_pnt_loc_def_cd");
        			errCnt+=isNullForRequiredField(sheetObj, i, "dest_rout_pnt_loc_def_cd");
        			errCnt+=isNullForRequiredField(sheetObj, i, "prefix_nm");
        			errCnt+=isNullForRequiredField(sheetObj, i, "prc_cgo_tp_cd");
        			errCnt+=isNullForRequiredField(sheetObj, i, "dir_call_flg");
        			errCnt+=isNullForRequiredRateField(sheetObj, i);
        			
        			//(2) Check blank in the Cell when there are ; in the Cell
        			errCnt+=isNullInMultiField(sheetObj, i, "prc_cmdt_def_cd");
        			errCnt+=isNullInMultiField(sheetObj, i, "org_rout_pnt_loc_def_cd");
        			errCnt+=isNullInMultiField(sheetObj, i, "org_rcv_de_term_nm");
        			errCnt+=isNullInMultiField(sheetObj, i, "org_prc_trsp_mod_nm");
        			errCnt+=isNullInMultiField(sheetObj, i, "dest_rout_pnt_loc_def_cd");
        			errCnt+=isNullInMultiField(sheetObj, i, "dest_rcv_de_term_nm");
        			errCnt+=isNullInMultiField(sheetObj, i, "dest_prc_trsp_mod_nm");
        			errCnt+=isNullInMultiField(sheetObj, i, "org_rout_via_port_def_cd");
        			errCnt+=isNullInMultiField(sheetObj, i, "dest_rout_via_port_def_cd");
        			if(gen_spcl_rt_tp_cd == "S"){
        				errCnt+=isNullInMultiField(sheetObj, i, "cust_seq");
        	    	} 
        			
        			//(3) Check the Dup in Cells
        			errCnt+=isCellDup(sheetObj, i, "prc_cmdt_def_cd");
        			errCnt+=isCellDup(sheetObj, i, "org_rout_pnt_loc_def_cd");
        			errCnt+=isCellDup(sheetObj, i, "org_rcv_de_term_nm");
        			errCnt+=isCellDup(sheetObj, i, "org_prc_trsp_mod_nm");
        			errCnt+=isCellDup(sheetObj, i, "dest_rout_pnt_loc_def_cd");
        			errCnt+=isCellDup(sheetObj, i, "dest_rcv_de_term_nm");
        			errCnt+=isCellDup(sheetObj, i, "dest_prc_trsp_mod_nm");
        			errCnt+=isCellDup(sheetObj, i, "org_rout_via_port_def_cd");
        			errCnt+=isCellDup(sheetObj, i, "dest_rout_via_port_def_cd");
        	    	if(gen_spcl_rt_tp_cd == "S"){
        	    		errCnt+=isCellDup(sheetObj, i, "cust_seq");
        	    	}
        	    	
// 2016.03.02 remove the check    	
//        	    	if(sType == "C"){
//        	    		//(5) Check the Dup of Ori/Dest in the all rows of sheet
//            	    	// when the all combinations of the org and dest is multiple
//        	    		// (STRUCTUR : RowIdx-ORG-DEST|RowIdx-ORG-DEST....
//        	    		//(ex) 5-SINBB-CHSHA|5-SINBB-USLAX..
//            	    	var dupCnt = chkLocDupInSheet(sheetObj, i);
//            	    	if(dupCnt > 0){
//            	    		add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00332", "the combination of Origin and Destination"));
//            	    		errCnt++;
//            	    	}
//        	    	}
        		} else if(sType == "D"){
        			errCnt+=isNullForRequiredField(sheetObj, i, "cmdt_hdr_seq");
    				errCnt+=isNullForRequiredField(sheetObj, i, "rout_seq");
    				if(amdtSeq == "0" && !existsOpnerData(sheetObj, i)){
    					ComShowCodeMessage("PRI00351");
    					return false;
    				}
        		}
        		
        		var realIdx = (i+1) - sheetObj.HeaderRows();
        		if(unValidRows == ""){
        			if(isErrRow(sheetObj, i)){
        				unValidRows = String(realIdx);
        			}
        		} else {
        			if(isErrRow(sheetObj, i)){
        				unValidRows = unValidRows + ", " + String(realIdx);
        			}
        		}
        	}
        	
        	if(errCnt > 0){
        		ComShowMessage(ComGetMsg("COM12114", unValidRows + " row."));
        		document.body.scroll="no";
        		return false;
        	}
            break;
        }
        
        
        return result;
    }
    
    function getOrgLocCombineCode(sheetObj, Row){
    	var sLoc = "";
    	var oloc = sheetObj.GetCellValue(Row, "org_rout_pnt_loc_def_cd");
    	var dloc = sheetObj.GetCellValue(Row, "dest_rout_pnt_loc_def_cd");
    	var arrOLoc = oloc.split(";");
    	var arrDLoc = dloc.split(";");
    	
    	if(arrOLoc != undefined && arrOLoc != null && arrOLoc.length > 0){
    		for(var i = 0; i < arrOLoc.length; i++){
	        	if(arrDLoc != undefined && arrDLoc != null && arrDLoc.length > 0){
	        		for(var j = 0; j < arrDLoc.length; j++){
	        			if( (i == (arrOLoc.length - 1)) && (j == (arrDLoc.length - 1)) ){
	        				sLoc += Row;
	        				sLoc += "-" + arrOLoc[i];
	        				sLoc += "-" + arrDLoc[j];
	        			} else {
	        				sLoc += Row;
	        				sLoc += "-" + arrOLoc[i];
	        				sLoc +=  "-" + arrDLoc[j] + "|";
	        			}
	        			
	    	    	}
	        	}
	    	}
    	}

    	return sLoc;
    }
    
    function getAllgetOrgLocCombineCode(sheetObj){
    	
    	var result = "";
    	var sidx = sheetObj.HeaderRows();
    	var eidx = sheetObj.LastRow();
		for(var i = sidx; i <= eidx; i++){
			var strOrgDests = getOrgLocCombineCode(sheetObj, i);
			if(i == sidx){
				result += strOrgDests;	
			} else {
				result += "|" + strOrgDests;	
			}
			
		}
		
		return result;

    }
    
    function chkCmdtDupInSheet(sheetObj, Row, errCnt){
    	var isAddErrMsg = false;
    	var strCmdt = sheetObj.GetCellValue(Row, "prc_cmdt_def_cd");
    	var dupCmdtRowIdxs = sheetObj.ColValueDupRows("prc_cmdt_def_cd",true,true);
    	if(dupCmdtRowIdxs != undefined && dupCmdtRowIdxs != ""){
    		var headerNm = getHeaderName(sheetObj, "prc_cmdt_def_cd");
    		
    		var arrCmdt = strCmdt.split(";");
    		if(arrCmdt != undefined && arrCmdt != null && arrCmdt.length > 0){
    			for(var x = 0; x < arrCmdt.length; x++){
    				var sCmdt = arrCmdt[x];
    				
    				//arrDups[0] : dup basic rows
    	    		//arrDups[1] : dup rows
    	    		var arrDups = dupCmdtRowIdxs.split("|");
    	    		var dupRows = arrDups[0]+","+arrDups[1];
    	    		var arrTmpDups = dupRows.split(",");
    	    		for(var y = 0; y < arrTmpDups.length; y++){
    	    			var dupRowIdx = arrTmpDups[y];
    	    			var tmpCmdt = sheetObj.GetCellValue(dupRowIdx, "prc_cmdt_def_cd");
    	    			var arrTmpCmdt = tmpCmdt.split(";");
    	    			if(arrTmpCmdt != undefined && arrTmpCmdt != null && arrTmpCmdt.length > 0){
    	    				for(var z = 0; z < arrTmpCmdt.length; z++){
    	    					var tCmdt = arrTmpCmdt[z];
    	    					if(Row != dupRowIdx && sCmdt == tCmdt){
    	    						
    	    						if(!isAddErrMsg){
	            	    				add2Tooltip(Row, "prc_cmdt_def_cd", ComGetMsg("PRI00332", headerNm));
	            	    				isAddErrMsg = true;
	            	    				errCnt++;
    	    						}
            	    			}
    	    				}
    	    			}
    	    			
    	    		}
    			}
    			
    			
    		}

    	}
    	
    	return errCnt;
    }
    

    function clearTooltip() {
    	var sheetObj=sheetObjects[0];
    	var sRIdx = sheetObj.HeaderRows();
        var n=sheetObj.LastRow();
        var m=sheetObj.LastCol();
        var i=sheetObj.HeaderRows();
        var j=0;
        for (i=sRIdx; i <= n; i++) {
            for (j=0 ; j <= m ; j++) {
                if (sheetObj.GetToolTipText(i, j) != "") {
                	if(sheetObj.GetCellEditable(i,j) == 1 || sheetObj.GetCellBackColor(i, j).toUpperCase() == "#FF0000"){
                		sheetObj.SetCellBackColor(i, j, "");
                	}
                    sheetObj.SetToolTipText(i, j,"");
                }
            }
        }
        
        isClear = true;
    }
    
    function add2Tooltip(row, col, msg) {
    	var sheetObj=sheetObjects[0];
    	//var toolTip = sheetObj.GetToolTipText(row, col) + "\n- " +  msg;
    	var toolTip = msg;
    	
    	sheetObj.SetCellBackColor(row, col, "#FF0000");
    	sheetObj.SetToolTipText(row, col, toolTip);
    }
	/**
	 * handling all buttons Enalbe/Disable <br> <br>
	 */
    function toggleButtons(step) {
        switch (step) {
        case "INIT":
        	ComBtnEnable("btn_openfile");
            ComBtnDisable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "LOAD":
        	ComBtnEnable("btn_openfile");
        	ComBtnEnable("btn_check");
            ComBtnDisable("btn_save");
            sheetObjects[0].SetEditable(1);
            break;
        case "CHECK":
        	ComBtnEnable("btn_openfile");
        	ComBtnDisable("btn_check");
        	ComBtnEnable("btn_save");
        	sheetObjects[0].SetEditable(0);
            break;
        }
    }
    
    
    /*
     * return true/false about the existence of saved Row
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @return boolean
     */
    function existsOpnerData(sheetObj, Row){
    	var result = false;
    	
    	if(opener.existsDataForUploadExcel()){
    		result = true;
    	} 
    	
    	return result;
    }
    
    /*
     * return the count of duplicated org-destination's combination row in the same commodity header seq
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @return int (dup count)
     */
    function chkLocDupInSheet(sheetObj, Row){
    	var dupCnt = 0;
    	
    	var strPrcCmdtDefCd = sheetObj.GetCellValue(Row, "prc_cmdt_def_cd");
    	if(strPrcCmdtDefCd == null || strPrcCmdtDefCd == "") return dupCnt;
    	
    	var strOrgDests = sheetObj.GetCellValue(Row, "org_rout_pnt_loc_def_cd") + sheetObj.GetCellValue(Row, "dest_rout_pnt_loc_def_cd");
    	
    	var sIdx=sheetObj.HeaderRows();
		var eIdx=sheetObj.LastRow();
		for(var i = sIdx; i <= eIdx; i++){
			if(i == Row) continue;
			var strCmpPrcCmdtDefCd = sheetObj.GetCellValue(i, "prc_cmdt_def_cd")
			var strCmpOrgDests = sheetObj.GetCellValue(i, "org_rout_pnt_loc_def_cd") + sheetObj.GetCellValue(i, "dest_rout_pnt_loc_def_cd");
			if(strPrcCmdtDefCd == strCmpPrcCmdtDefCd && strOrgDests == strCmpOrgDests){
				dupCnt++;
			}
		}
    	
    	return dupCnt;
    }
    
    /*
     * return true/false of the result that there are colored row with error
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @return boolean
     */
    function isErrRow(sheetObj, Row){
    	var result = false;
    	
    	var sColIdx = 0;
    	var eColIdx = sheetObj.LastCol();
    	
    	for(var i = sColIdx; i <= eColIdx; i++){
    		if (sheetObj.GetCellBackColor(Row, i).toUpperCase() == "#FF0000") {
    			result = true;
    			break;
        	}
    	}
    	
    	return result;
    }
