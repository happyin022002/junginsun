/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0703.js
*@FileTitle  : TRO-Cancel/Frusrate popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_CancelAll":
					setCancelAll();
	                break; 
				case "btn_FrustrateAll":
					setFrustrateAll();
	                break; 			
            	case "btn_ok":
            		doActionIBSheet(sheetObject1, formObject, IBSAVE);
                	break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);                
            ComEndConfigSheet(sheetObjects[i]);
        }
        axon_event.addListenerFormat('keypress', 'obj_KeyPress',   form);
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        initControl();
    }
    function initControl() {
    	var formObj=document.form;
    	formObj.bkg_no.focus(); 
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //hidden sheet1
	            with (sheetObj) {	
			        var HeadTitle=" ||Seq.|Container No.|TP/SZ|S/O No.|S/O|W/O|Cancel|Cancel|Frustrate|Frustrate|Revenue|Revenue||||||";
			        var headCount=ComCountHeadTitle(HeadTitle);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trs_so_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"so_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cxl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"frustrate",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"frustrate_chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:48,   Align:"Right",   ColMerge:0,   SaveName:"non_trns_rev_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"io_bnd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"act_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"act_cust_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"cfm_upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"hlg_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
			        SetEditable(1);
			        SetSheetHeight(220);
			    }
				break;
		}
	}
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {    	
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //retrieve	              		
	          	//if(!validateForm(sheetObj,formObj,sAction)) return;
	          	formObj.f_cmd.value=SEARCH;
	          	sheetObj.DoSearch("ESM_BKG_0703GS.do", FormQueryString(formObj) );
                break;
          	case IBSAVE: 
 	          	if(!validateForm(sheetObj, formObj, sAction)){
 	          		return false;
 	          	}
 	          	formObj.f_cmd.value=MULTI; 
	            sheetObj.DoSave("ESM_BKG_0703GS.do", FormQueryString(formObj), -1, false);
          		break;
        }
    }
    /**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj)
        {
        	switch (sAction) {
         	    case IBSEARCH:
 					if (bkg_no.value == "" && bl_no.value == "") {
 					    ComShowCodeMessage("BKG00255");
 					    ComSetFocus(bkg_no);
 					    return false;
 					}
         	    	break;
         	    case IBSAVE:
 					if (sheetObj.IsDataModified()== false) {
 						ComShowCodeMessage("BKG00567");
 						return false;
 					}
         	    	if (!ComShowCodeConfirm("COM12147", "")) {
         	    		return false;
         	    	}  					
         	    	break; 
            }
        }
        return true;
    }
    //#################(Event)############################
    // Sheet saveEnd
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)
    {
    	var formObj=document.form;
		if (ErrMsg.trim() == msgs['BKG00166'].trim()) {			
			if (formObj.f_cmd.value == MULTI) {	
				pre_comPopupOK();
			} else {
				ComClosePopup(); 
			}
		}
    }
 	// Sheet SearchEnd
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{
 				if ("Yes" == GetCellValue(i, "so_flg")) {
 					SetCellEditable(i, "cxl_flg_chk",0);
 					SetCellFontColor(i, "so_flg","#FF0000");
 				} else { 					
 					if ("Yes" == GetCellValue(i, "cxl_flg")) {
 						SetCellEditable(i, "cxl_flg_chk",0);
 					} else {
 						SetCellEditable(i, "cxl_flg_chk",1);
 					}
 					SetCellFontColor(i, "so_flg","#000000");
 				}
 				if ("Yes" == GetCellValue(i, "wo_flg")) {
 					SetCellFontColor(i, "wo_flg","#FF0000");
					SetCellEditable(i, "frustrate_chk",0);
 				} else if ("Fr" == GetCellValue(i, "wo_flg")) {
 					SetCellFontColor(i, "wo_flg","#0000FF");
 					if("Yes" == GetCellValue(i, "frustrate")){
						SetCellEditable(i, "frustrate_chk",0);
					} else {
						SetCellEditable(i, "frustrate_chk",1);
					}
				} else {
					SetCellEditable(i, "frustrate_chk",0);
				}
 			}
 		}
 	}   
    // Sheet Click
    function sheet1_OnClick(sheetObj, Row, Col, Value)
    {
		with(sheetObj) {
			switch(ColSaveName(Col)){
	            case "cxl_flg_chk":
	            case "frustrate_chk":
	            	setCfmCheck(sheetObj, Row, ColSaveName(Col), Value);
	            	break;
			}
		}
    }
    //#################(Etc/Logic)############################
 	//setCancelAll
 	function setCancelAll() {
 		var sheetObj=sheetObjects[0]; 		
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{
 				if (GetCellEditable(i, "cxl_flg_chk")) {
 					setCfmCheck(sheetObj, i, "cxl_flg_chk", 0);
 					SetCellValue(i, "cxl_flg_chk",1,0);
 				}
 			}
 		}
 	}
 	//setFrustrateAll
 	function setFrustrateAll() {
 		var sheetObj=sheetObjects[0]; 		
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{
 				if (GetCellEditable(i, "frustrate_chk")) {
 					setCfmCheck(sheetObj, i, "frustrate_chk", 0);
 					SetCellValue(i, "frustrate_chk",1,0);
 				} 
 			}
 		}
 	} 	
	/**     
	  * setCfmCheck -> cfm_upd_dt set
	  */
	function setCfmCheck(sheetObj, nRow, colId, preVal) {
  	    var toDay=ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //checked -> Confirm Date setting		
		with(sheetObj) {
			if (GetCellEditable(nRow, colId)) {
		    	if (preVal == 1) {
		    		SetCellValue(nRow, "cfm_upd_dt","",0);
		    	} else {
		    		SetCellValue(nRow, "cfm_upd_dt",toDay,0);
		    	}
			}
		}
	} 	
	/**
	 * parent : default Recall 
	 */
    function pre_comPopupOK() {
	   	sheetObjects[0].SetCellValue(1, "radio","Y",0);
   	    comPopupOK();
    } 