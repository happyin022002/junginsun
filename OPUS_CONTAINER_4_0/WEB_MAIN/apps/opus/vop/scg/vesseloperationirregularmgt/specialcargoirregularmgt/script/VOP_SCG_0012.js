/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0012.jsp
*@FileTitle  : SPCL CGO Irregular List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0012 : business script for vop_scg_0012
     */
   
    // business javascript OnKeyPress event Catch
    function initControl() {
        // Axon event handling1. event catch
    	//axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
      //  axon_event.addListenerFormat ('focus',    'obj_activate',   form);
        axon_event.addListenerFormat ('blur', 	  'obj_deactivate', form);
        axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   form);
      //  axon_event.addListenerForm   ("keyup",    'obj_keyup',      form);
    } 
    // Handling business javascript OnKeyPress event
    function obj_keypress() {
    	switch(ComGetEvent().dataformat){
    	    case "engup":
    	    	switch(ComGetEvent("name")){
	    	    	case "":	
	    	        	//input english upper
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break; 
    	}
    }
    // Handling business javascript OnFocus event
    function obj_activate() {
    	// deleting mask separator
    	ComClearSeparator (ComGetEvent());
    }
    // Handling business javascript OnBlur event
    function obj_deactivate() {
    	with(ComGetEvent()) {
    		if(value != '' && (name == 'irr_occr_from_dt' || name == 'irr_occr_to_dt')) {
		    	// Checking Validation in one control + adding mask separator
		    	var rslt=ComChkObjValid(ComGetEvent(), false, true, true);
		    	if(!rslt) {
		    		ComShowMessage(ComGetMsg('COM12134', caption));
		    		value="";
		    		focus();
		    		select();
		    	}
    		}
    	}
    }
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	obj_nextfocus(ComGetEvent());
    }  
    // move focus - recieved parameter HTML tag(Object)'s next HTML tag(Object)
    function obj_nextfocus(obj) {
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		with(ComGetEvent()) {
        		if(name == 'irr_occr_from_dt') {
        			if(event.keyCode >= 48 && event.keyCode <=57 ) ComSetNextFocus(obj);
        		} else if(name == 'irr_occr_to_dt') {
        			obj.blur();
        		}
    		}
    	}
    }
    // Handling business javascript Lane OnKeyDown event
    function vsl_slan_cd_OnKeyDown(comboObj, KeyCode, Shift) {
    	//input english upper
    	//comboObj.SetSelectText(comboObj.GetSelectText().toUpperCase());
    }  
    // Handling business javascript Class OnChange event
    function imdg_clss_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	//Class Comp Combo retrieve
    	initCombo(comboObjects[6], 7, document.form);
    }  
    // common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefix="sheet1_";
    var comboObjects=new Array();
    var comboCnt=0;
    var loadCt=0;
    // Dangerous Goods / Awkward Cargo related items
    var dgStr="|imdg_un_no|imdg_un_no_seq|imdg_clss_cd";	//Dangerous Goods
    var acStr="|spcl_cgo_cate_cd|dim_len|dim_wdt|dim_hgt|por_cd|pol_cd|pod_cd|del_cd|s_cust_nm|c_cust_nm";	//Awkward Cargo
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified. *****/
         var sheetObj=sheetObjects[0];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObj,formObj,IBCLEAR);
					break;
				case "btn_DownExcel":
                    var paramObj=new Object();
                    paramObj.title="SPCL CGO Irregular List";
                    
					var sheetExcelObj = sheetObj;
                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
                    paramObj.datarowheight="0:25";
                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
                    
                    if(sheetExcelObj.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
	       	       		var str = sheetExcelObj.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}
//                    var url=ComScgGetPgmTitle(sheetObj, paramObj);
//                    if(sheetObj.RowCount() < 1){
//                		ComShowCodeMessage("COM132501");
//                	}else{
//                		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
//                	}
//					sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"SPCL CGO Irregular List",false);
					break;
				case "irr_spcl_cgo_cate_cd":
					setOptionInfo(sheetObj, formObj, false);	//by Option
					break;	
				case "btn_calendar":					
					var cal=new ComCalendarFromTo();
		            cal.select(formObj.irr_occr_from_dt, formObj.irr_occr_to_dt, "yyyy-MM-dd");	//open calendar for choosing date  	
   	                break;
				case "btn_Close": case "btn_Close2":
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
  	 * registering IBCombo Object as list
  	 * param : combo_obj ==> combo object
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
    function loadPage(comboItems) {
    	//Initializing Sheet
        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );	
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);	
        }
        //Initializing Combo
        var elseCt=0;
        for(var k=0;k<comboObjects.length;k++){
        	//Irregulars Type, AWK Type etc
            if(k != 4 && k != 8) { 
            	addComboItem(comboObjects[k], comboItems[elseCt], comboItems[elseCt]);
            	elseCt++;
            }
        }
        //register Listener
        initControl();
        // add mask separator
    	controlMask("irr_occr_from_dt|irr_occr_to_dt", true);
    	//Pre Condition & Pop
        if(preConds.pop_mode == 'Y' && imdg_un_no != '') {
       	 	//Set condition's values
	        imdg_un_no.SetSelectCode(preConds.imdg_un_no);
       	 	searchList(sheetObjects[0], document.form);
        }
        sheet1_OnLoadFinish(sheet1);
    }
     function sheet1_OnLoadFinish(sheetObj) {	
    	//Initializing Combo
    	var elseCt=0;
    	for(var k=0;k<comboObjects.length;k++){
    		//Irregulars Type, AWK Type
    		if(k==4 || k==8) initCombo(comboObjects[k],k+1,document.form);
    	}
    	searchUseVopScg0012ToPopup();
    	//Pre Condition & Pop
    	if(preConds.pop_mode == 'Y' && imdg_un_no != '') {   	 	
       	 	searchList(sheetObj, document.form);
        }
    }
    /**
     * SPCL CGO Irregular Inquery screen popup <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 selected Row
     * @param {ibsheet} Col     	sheetObj의 selected Col
     * @param {String} 	Value     	file name
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col,Value) {	
		var sParam=Array();
		sParam[0]="vsl_cd="+sheetObj.GetCellValue(Row, prefix+"vsl_cd");
		sParam[1]="skd_voy_no="+sheetObj.GetCellValue(Row, prefix+"skd_voy_no");
		sParam[2]="skd_dir_cd="+sheetObj.GetCellValue(Row, prefix+"skd_dir_cd");
		sParam[3]="spcl_cgo_irr_seq="+sheetObj.GetCellValue(Row, prefix+"spcl_cgo_irr_seq");
		sParam[4]="ofc_cd="+sheetObj.GetCellValue(Row, prefix+"ofc_cd");
		sParam[5]="pop_mode=Y";
		
//        ComOpenWindowCenter("VOP_SCG_0075.do?mainPage=false&"+sParam.join("&"), "winDtl", "1040", "700", true, "yes");
		ComOpenPopup("VOP_SCG_0075.do?mainPage=false&"+sParam.join("&"), 1200, 700, "VOP_SCG_0075", "0,0,1,1,1,1,1", false);
		return;
	}
    /**
     * controlling mask separator
     * param : objStr ==> object('cd1|cd2'), sFlg ==> true:Add, false:Remove
     */	
    function controlMask(objStr, sFlg) {
    	var objStr=objStr.split("|");
    	for (var i=0; i<objStr.length; i++){
    		if(sFlg) ComAddSeparator (eval("document.form."+objStr[i]));   
    		else ComClearSeparator (eval("document.form."+objStr[i]));   
        }	
    }
    /**
     * Initializing Combo 
     * param : comboObj ==> combo object, comboNo ==> combo
     * adding case as numbers of counting combo 
     */ 
    function initCombo(comboObj, comboNo, formObj) {
    	switch(comboObj.options.id) {
	        case "com_spcl_cgo_irr_tp_cd":
	            with(comboObj) {
	            	SetTitle("Name|Code|Description");
	            	SetColWidth(0, "100");
	            	SetColWidth(1, "50");
	            	SetColWidth(2, "200");
	            	SetDropHeight(200);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            }
	            break;	   
	    }
        switch(comboNo) {  
        	case 1: 
        		//Lane Combo retrieve
        		searchCombo(SEARCH01, "VOP_SCG_0012GS.do", "vsl_slan_cd", "vsl_slan_cd", "vsl_slan_cd");
     			break; 
        	case 2: 
        		//Vessel Combo retrieve
        		searchCombo(SEARCH02, "VOP_SCG_0012GS.do", "vsl_cd", "vsl_cd", "vsl_cd");
     			break;
        	case 3: 
        		//VSL OPR Combo retrieve
        		searchCombo(SEARCH03, "VOP_SCG_0012GS.do", "vsl_opr_tp_cd", "crr_cd", "crr_cd");
     			break;
        	case 4: 
        		//CGO OPR Combo retrieve
        		searchCombo(SEARCH04, "VOP_SCG_0012GS.do", "cgo_opr_cd", "crr_cd", "crr_cd");
     			break;
        	case 5: 
        		//Irregulars Type Combo retrieve
        		searchIrregularType();
     			break;
        	case 6: 
        		//Class Combo retrieve
        		searchCombo(SEARCH05, "VOP_SCG_0012GS.do", "imdg_clss_cd", "imdg_clss_cd", "imdg_clss_cd");
     			break;
        	case 7: 
        		//Class Comp Combo retrieve
        		var sOption=getObjValue("imdg_clss_cd");
         	    searchCombo(SEARCH06, "VOP_SCG_0012GS.do", "imdg_comp_grp_cd", "imdg_comp_grp_cd", "imdg_comp_grp_cd", "imdg_clss_cd="+sOption);
     			break;
        	case 8: 
        		//UN No. Combo retrieve
        		searchCombo(SEARCH07, "VOP_SCG_0012GS.do", "imdg_un_no", "imdg_un_no", "imdg_un_no");
     			break;
        	case 9: 
        		//fill AWK Type Combo
        		addComboItem(comboObj, "AK|RF|BB", "Awkward|Reefer|Break-Bulk");
     			break;
        	case 10: 
        		//POR Combo retrieve
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "por_cd", "loc_cd", "loc_cd","loc_tp_cd=POR");
     			break;
        	case 11: 
        		//POL Combo retrieve
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "pol_cd", "loc_cd", "loc_cd","loc_tp_cd=POL");
     			break;
        	case 12: 
        		//POD Combo retrieve
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "pod_cd", "loc_cd", "loc_cd","loc_tp_cd=POD");
     			break;
        	case 13: 
        		//DEL Combo retrieve
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "del_cd", "loc_cd", "loc_cd","loc_tp_cd=DEL");
     			break;
     	} 
    }
    /**
     * Add Combo
     */	
    function addComboItem(comboObj, itemValStr, itemTxtStr) {
    	var itemValArr=itemValStr.split("|");
        var itemTxtArr=itemTxtStr.split("|");
    	for (var i=0; i<itemValArr.length; i++){
    		comboObj.InsertItem(i, itemTxtArr[i], itemValArr[i]);    	
        }	
    }
     /**
      * 
      * <pre>
      *    Use VOP_SCG_0012 as main.
      * </pre>
      *
      * @param void   
      * @return void
      * @author 
      */
    function searchUseVopScg0012ToPopup(){
        var formObj=document.form;
        var docAll=document.all;
        var imdg_un_no=formObj.pImdg_un_no.value; 
        if( imdg_un_no != "" ){
                 imdg_un_no.SetSelectCode(imdg_un_no,false);
                 if(imdg_un_no.GetSelectIndex()> -1){
                     docAll.btn_Retrieve.fireEvent('onclick');
                 }
        }
    }
    /**
     * Combo retrieve
     */
    function searchCombo(searchType, url, combId, combCd, combNm, etcParam) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	//sheetObj.Redraw = false;
    	formObj.f_cmd.value=searchType;
  	   	var sXml=sheetObj.GetSearchData(url, FormQueryString(formObj)+"&"+etcParam);
 	   	//Add Combo
 	    ComXml2ComboItem(sXml, combId, combCd, combNm);
 	    //sheetObj.Redraw = true;
    }
    /**
     * Irregulars Type Combo retrieve
     */	
    function searchIrregularType() {
    	var sOption=getObjValue("irr_spcl_cgo_cate_cd");
    	var sParam;
		if(sOption == 'DG') sParam="dg_flg=Y";
		else if(sOption == 'AC') sParam="awk_flg=Y";
 	    searchCombo(SEARCH04, "SCG_COM_INTERNALGS.do", com_spcl_cgo_irr_tp_cd, "spcl_cgo_irr_tp_cd", "spcl_cgo_irr_tp_nm|spcl_cgo_irr_tp_cd|spcl_cgo_irr_tp_desc", sParam);
 	   return sOption;
    }
    /** 
  	 * change according to option change
  	 */ 
  	function setOptionInfo(sheetObj, formObj, forceYn) {  
  		var sOrslt=false;

  		var sOption=searchIrregularType();	//Irregulars Type Combo retrieve
  		
  		if(sOption == 'DG' || sOption == '') sOrslt=true;
  		for (var i=5; i<13; i++){  	
  			if(!forceYn) {
	  			if(i == 8 && sOption != '') comboObjects[i].SetEnable(!sOrslt);
	  			else comboObjects[i].SetEnable(sOrslt);
  			} else {
  				comboObjects[i].SetEnable(1);
  			}
  			comboObjects[i].SetSelectIndex("");
        }
  		sheetObj.RemoveAll();
  		var saveName;
  		sheetObj.RenderSheet(0);
  		for(var colIdx=1; colIdx<=sheetObj.LastCol()-5; colIdx++) {
  			if (sheetObj.SetColHidden(colIdx)) sheetObj.GetColHidden(colIdx,0);
  			saveName=sheetObj.ColSaveName(colIdx);
  			saveName=saveName.substring(7,saveName.length);
  			if(sOption == 'DG') {
  				if(acStr.indexOf(saveName) != -1) sheetObj.SetColHidden(colIdx,1);
  			} else if(sOption == 'AC') {
  				if(dgStr.indexOf(saveName) != -1) sheetObj.SetColHidden(colIdx,1);
  			}
  		}

  		sheetObj.RenderSheet(1);
  	}
    /**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
               
             var HeadTitle1="Date|VVD CD|Lane|VSL OPR|Type|BKG Ref. No.|Cgo OPR|CNTR No.|TP/SZ|CGO Type|CGO Seq.|UN No./Seq.|UN No./Seq.|Class|Weight(kg)|Weight(kg)|Dimension(cm)|Dimension(cm)|Dimension(cm)|POR|POL|POD|Delivery|Shipper|Consignee|||||";
             var HeadTitle2="Date|VVD CD|Lane|VSL OPR|Type|BKG Ref. No.|Cgo OPR|CNTR No.|TP/SZ|CGO Type|CGO Seq.|UN No./Seq.|UN No./Seq.|Class|Gross|Net|L|W|H|POR|POL|POD|Delivery|Shipper|Consignee|||||";
             var headCount=ComCountHeadTitle(HeadTitle1);
             //(headCount, 0, 0, true);

             SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
            
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"irr_occr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_opr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_irr_tp_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cgo_opr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_cate_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cgo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"imdg_un_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"imdg_un_no_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"awk_cgo_grs_wgt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"awk_cgo_net_wgt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dim_len",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dim_wdt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dim_hgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"s_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"c_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_voy_no" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"spcl_cgo_irr_seq" },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd" } ];
              
             	InitColumns(cols);
             	SetWaitImageVisible(0);
             	SetEditable(0);
             	SetDataLinkMouse(true);
             	//SetSheetHeight(370);
             	resizeSheet();
             }


               break;
        }
        return true;
    }
    function resizeSheet(){
   	 	ComResizeSheet(sheetObjects[0]);
    }
    /**
     * Search after loading all of objects
     */
    function searchList(sheetObj, formObj) {
    	loadCt++;
     	if(loadCt == 2) doActionIBSheet(sheetObj,formObj,IBSEARCH); 
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve
        		if(!validateForm(sheetObj,formObj,sAction)) return true;
        		ComOpenWait(true);
        		formObj.f_cmd.value=SEARCH;		
        		//remove mask separator
           	   	controlMask("irr_occr_from_dt|irr_occr_to_dt", false);
            	sheetObj.DoSearch("VOP_SCG_0012GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
           	   	//add mask separator
           	   	controlMask("irr_occr_from_dt|irr_occr_to_dt", true);
           	   	break;
        	case IBCLEAR:      
        		ComResetAll();
	        	//add mask separator
	           	controlMask("irr_occr_from_dt|irr_occr_to_dt", true);
	           	//Combo activate
	           	setOptionInfo(sheetObj, formObj, true);
	           	break;
        	case IBINSERT:      // insert
        		break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(!ComChkValid(formObj, true, false, false)) 
    		return false;
        return true;
    }

    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }