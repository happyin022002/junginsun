/**
 * @extends Tes
 * @class ESD_TES_9075 : business script for Off-Dock CY Container List - Tab Cost Calc.(TMNL) - Revised Volume Separate Input
 */
function ESD_TES_9075() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}
	// global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	/**
	 * Event handler processing by button name
	 * @return
	 */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
        var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
        var formObj = document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btn_close":
         	    	ComClosePopup();
        	        break;
            }
    	} catch(e) {
    		if ( e == "[object Error]") {
    			ComShowMessage(getMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @return     
     */
    function setSheetObject(sheet_obj){
    	 sheetObjects[sheetCnt++] = sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     * @return
     */
    function loadPage(){
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		var formObj = document.form;
		if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='A'){
			//Manual MODE
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} else if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='M'){
			//Auto MODE
			doActionIBSheetManual(sheetObjects[0],document.form,IBSEARCH);
		}
	}
    /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj IBSheet Object
     * @param {int} sheetNo 	 
     * 						adding case as numbers of counting sheets
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	            	var HeadTitle = "|Cost Code|CNTR No.|Type/\nSize|F/M||Gate In||Gate Out|Remark";
	        	    SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
                    
					var cols = [ {Type:"Seq",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"",						KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:80,		Align:"Center",		ColMerge:0,   SaveName:"lgs_cost_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:90,		Align:"Center",		ColMerge:0,   SaveName:"cntr_no",						KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:50,		Align:"Center",		ColMerge:0,   SaveName:"cntr_tpsz_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:40,		Align:"Center",		ColMerge:0,   SaveName:"cntr_sty_cd",					KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"rvis_gate_in_flg",			KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:110,	Align:"Center",		ColMerge:0,   SaveName:"inv_gate_in_dt",			KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"rvis_gate_out_flg",		KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:110,	Align:"Center",		ColMerge:0,   SaveName:"inv_gate_out_dt",			KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:0,	Width:60,		Align:"Center",		ColMerge:0,   SaveName:"cntr_rmk",					KeyField:0,   CalcLogic:"",   Format:"" },
					        {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",		KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_so_seq",					KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_so_cntr_list_seq",	KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_so_dtl_seq",			KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_so_rvis_list_seq",	KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_inv_tp_cd",				KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"calc_cost_grp_cd",		KeyField:0,   CalcLogic:"",   Format:"" },
		                    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_rvis_tp_cd",			KeyField:0,   CalcLogic:"",   Format:"" },
						    {Type:"Text",		Hidden:1,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"tml_so_dtl_seq2",			KeyField:0,   CalcLogic:"",   Format:"" } ];
					
		            InitColumns(cols);
		            SetEditable(0);
		            resizeSheet();
		            SetColProperty("inv_gate_in_dt", {Format:"####-##-####:##"} );
		            SetColProperty("inv_gate_out_dt", {Format:"####-##-####:##"} );
			    }
                break;
        }
    }
    /**
     * handling sheet process - Auto MODE
     * @param {ibsheet} sheetObj 	IBSheet Object
     * @param {form} formObj		Form Object
     * @param {int} sAction			
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:      //Retrieve
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch("ESD_TES_9075Popup.do", tesFrmQryStr(formObj));
			    break;
        }
    }
    /**
    * handling sheet process - Manual MODE
    * @param {ibsheet} sheetObj 	IBSheet Object
    * @param {form} formObj		Form Object
    * @param {int} sAction			
    * @return
    */    
    function doActionIBSheetManual(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:      //Retrieve
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch("ESD_TES_9075Popup.do", tesFrmQryStr(formObj));
				break;
        }
    }
    /**
     * UI 표준화관련 하단 여백 설정
     */
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
    }