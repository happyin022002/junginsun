/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_BKG_1058.js
*@FileTitle : MT Return Yard for Pickup Notice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_1058 : business script for ESM_BKG_1058. 
     */
    
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isRetrieve=false;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "img_dt":
    	        var cal=new ComCalendarFromTo();
    		    cal.select(formObject.rtn_yd_sav_dt_s, formObject.rtn_yd_sav_dt_e, 'yyyy-MM-dd');
                break;
            case "btn_Retrieve":
              	doActionIBSheet(sheetObjects[tabObjects[0].GetSelectedIndex()], formObject, IBSEARCH);
                break;
            case "btn_RowAdd":
                doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;
            case "btn_Delete":
            	doActionIBSheet(sheetObject1, formObject, IBDELETE);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
			case "btn_DownExcel":
				
				if(sheetObjects[tabObjects[0].GetSelectedIndex()].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[tabObjects[0].GetSelectedIndex()].Down2Excel({ HiddenColumn:1,SheetDesign:1, Merge:1,AutoSizeColumn:1});
				}				
				break;
			case "btn_Close":
     	    	ComClosePopup(); 
     	    	break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    /**
     * registering IBTab Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param {object} tab_obj
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     * 
     * @param {object} tabObj
     * @param {int}    tabNo 
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
            var cnt=0 ;
			InsertItem( "Live" , "");
			InsertItem( "Delete" , "");
        }
    }
    /**
     * Event when clicking Tab <br>
     * activating selected tab items <br>
     * 
     * @param {object} tabObj
     * @param {int}    nItem
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforetab].style.display="none";
        beforetab=nItem;
        if (isRetrieve == true) {
           	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);
        }
        if (nItem == 0) {
        	ComBtnEnable("btn_Save");
        } else {
        	ComBtnDisable("btn_Save");
        }
    }
    /**
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen <br>
     * 
     * @return 없슴
     */
    function loadPage() {
        //IBTab 초기화
        for (var k=0; k<tabObjects.length; k++) {
            initTab(tabObjects[k],k+1);
        }
        //IBSheet 초기화
        for(var i=0;i<sheetObjects.length;i++) {
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        tabObjects[0].SetSelectedIndex(0);
        initControl();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     }
    /**
    * registering initial event 
    * 
    */
    function initControl() {

    }
    /**
     * setting sheet initial values and header<br>
     * adding case as numbers of counting sheets <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {number}  sheetNo
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        // Live
        case "t1sheet1":
            with(sheetObj){
		          var HeadTitle=" |Check|Seq.|YD Seq.|POD|PICK YD|DEL|Type|Return YD|Office|Saved ID|Saved Date";
		          var headCount=ComCountHeadTitle(HeadTitle);
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_seq" },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_id",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"fnl_dest_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_cntr_tp_id",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"mcntr_rtn_yd_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_sav_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_sav_usr_id",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_sav_dt",      KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          //SetColProperty("rtn_yd_sav_dt", {Format:"####-##-####:##:##"} );
		          SetColProperty("pkup_cntr_tp_id", {ComboText:"*|RF", ComboCode:"ALL|RF"} );
		          SetColProperty("pod_cd", {InputCaseSensitive:1} );
		          SetColProperty("pkup_yd_id", {InputCaseSensitive:1} );
		          SetColProperty("fnl_dest_cd", {InputCaseSensitive:1} );
		          SetColProperty("mcntr_rtn_yd_cd", {InputCaseSensitive:1} );
		          SetColProperty("rtn_yd_sav_ofc_cd", {InputCaseSensitive:1} );
		          
		          SetSheetHeight(400);
		          //conversion of function[check again]CLT                 InitDataValid(0, "pod_cd", vtEngUpOther, "0123456789");
		          //conversion of function[check again]CLT                 InitDataValid(0, "pkup_yd_id", vtEngUpOther, "0123456789");
		          //conversion of function[check again]CLT                 InitDataValid(0, "fnl_dest_cd", vtEngUpOther, "0123456789");
		          //conversion of function[check again]CLT                 InitDataValid(0, "mcntr_rtn_yd_cd", vtEngUpOther, "0123456789");
          	}
            break;                  
            // Delete
        	case "t2sheet1":
            with(sheetObj){
        	      var HeadTitle="Seq.|POD|PICK YD|DEL|Type|Return YD|Office|Deleted ID|Deleted Date";
        	      var headCount=ComCountHeadTitle(HeadTitle);

        	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	      InitHeaders(headers, info);

        	      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"fnl_dest_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_cntr_tp_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mcntr_rtn_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_sav_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"delt_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"delt_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0 } ];
        	       
        	      InitColumns(cols);
        	      SetEditable(1);
        	      //SetColProperty("delt_dt", {Format:"####-##-####:##:##"} );
        	      SetColProperty("pkup_cntr_tp_id", {ComboText:"*|RF", ComboCode:"ALL|RF"} );
        	      SetSheetHeight(430);
        	}
            break;
        }
    }
    /**
     * handling sheet process <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {object}  formObj
     * @param {string}  sAction 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        // Search
        case IBSEARCH:  
            if(validateForm(sheetObj,formObj,sAction) == false) break;
            isRetrieve=true;
            if (sheetObj.id=="t1sheet1") {
            	formObj.delt_flg.value="N";
            } else if (sheetObj.id=="t2sheet1") {
            	formObj.delt_flg.value="Y";
            }
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_1058GS.do", FormQueryString(formObj) );
            ComOpenWait(false);
            break;
        case IBSAVE:        
        	if (sheetObj.id == "t2sheet1") break;
            if(!validateForm(sheetObj,formObj,sAction)) break;
    		if (ComShowCodeConfirm("BKG00824") == false) {
    			break;
    		}
            var sParamSheet=sheetObj.GetSaveString();
            if (sParamSheet == "") return;
            var sParam=ComSetPrifix(sParamSheet, "sheet1_");
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI;
			sParam += "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("ESM_BKG_1058GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
    		break;
        case IBINSERT:      
        	if (sheetObj.id == "t2sheet1") break;
            var vRow=sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(vRow, "rtn_yd_sav_usr_id",formObj.usr_id.value,0);
            sheetObj.SetCellValue(vRow, "rtn_yd_sav_ofc_cd",formObj.usr_ofc_cd.value,0);
            break;
        case IBDELETE:
        	if (sheetObj.id == "t2sheet1") break;
        	ComRowHideDelete(sheetObj, "del_chk");
        	break;
        }
    }
    /**
     * handling Tab1 Sheet1 change<br>
     * 
     * @param {ibsheet} sheetObj
     * @param {int}     Row 
     * @param {int}     Col  
     * @param {string}  Value
     */
    function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		if (ColSaveName(Col) == "pod_cd" ||
				ColSaveName(Col) == "pkup_yd_id" ||
				ColSaveName(Col) == "fnl_dest_cd" ||
				ColSaveName(Col) == "mcntr_rtn_yd_cd")
    		{
    			if (ColSaveName(Col) == "pod_cd" ||
					ColSaveName(Col) == "fnl_dest_cd")
    			{
    				if (Value.length < 5) return;
    			} else if (ColSaveName(Col) == "mcntr_rtn_yd_cd") {
    				if (Value.length < 7) return;
    			} else if (ColSaveName(Col) == "pkup_yd_id") {
    				if (Value.length < 5) {
    					ComShowCodeMessage("BKG40105", ColSaveName(Col));
    					return;
    				}
    			}
    			
    	    	
    			var formObj=document.form;    			
   		        sheetObj.SetCellValue(Row, Col,sheetObj.GetCellValue(Row, Col).toUpperCase());
    	    	
            	formObj.f_cmd.value=SEARCH01;
            	if (ColSaveName(Col) == "pod_cd") formObj.chk_tp.value="P";
            	else if (ColSaveName(Col) == "pkup_yd_id") formObj.chk_tp.value="YL";
            	else if (ColSaveName(Col) == "mcntr_rtn_yd_cd") formObj.chk_tp.value="Y";
            	else formObj.chk_tp.value="L";
            	formObj.loc_cd.value=Value.toUpperCase();
            	
            	var sXml=GetSearchData("ESM_BKG_1058GS.do", FormQueryString(formObj));
		        if(ComBkgErrMessage(sheetObj, sXml) == false) {
		        	SetCellValue(Row, Col,"",0);
		        	SelectCell(Row, Col);
		        }
    		}
    	}
    }
    
    /**
     * handling Tab1 Sheet1 save<br>
     * 
     * @param {ibsheet} sheetObj
     * @param {string}  ErrMsg
     */
    function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
      	}
    } 
    /**
     * handling Tab1 Sheet1 retrieve complete<br>
     * 
     * @param {ibsheet} sheetObj
     * @param {string}  ErrMsg 
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
            SetColFontColor("pod_cd","#FF0000");
            SetColFontColor("pkup_yd_id","#FF0000");
            SetColFontColor("fnl_dest_cd","#FF0000");
            SetColFontColor("rtn_yd_sav_ofc_cd","#FF0000");
    	}
    }
    /**
     * handling Tab2 Sheet1 retrieve complete <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {string}  ErrMsg
     */
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
            SetColFontColor("pod_cd","#FF0000");
            SetColFontColor("pkup_yd_id","#FF0000");
            SetColFontColor("fnl_dest_cd","#FF0000");
            SetColFontColor("rtn_yd_sav_ofc_cd","#FF0000");
    	}
    }
    /**
     *  handling Tab1 Sheet1 click<br>
     * 
     * @param {ibsheet} sheetObj
     * @param {int}     Row
     * @param {int}     Col
     * @param {string}  Value
     */
    function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		if(Col > 1){
	    		if (GetCellValue(Row, "del_chk") == 0) SetCellValue(Row, "del_chk",1,0);
	    		else SetCellValue(Row, "del_chk",0,0);
    		}
    	}
    }
    /**
     * handling process for input validation <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {object}  formObj
     * @param {string}  sAction 
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
         	switch(sAction) {
        	case IBSEARCH:
    	    	if (!ComChkValid(formObj)) return false;
    	    	break;
        	case IBSAVE:
                if (ComIsModifiedSheets(sheetObj) == false) {
                	ComShowCodeMessage("BKG00743");
                	return false;
            	}
        		var dupStr="pod_cd|pkup_yd_id|fnl_dest_cd|pkup_cntr_tp_id";
		        var dupRow=sheetObj.ColValueDup(dupStr, false);
		        if (dupRow > 0) {
		        	ComShowCodeMessage("BKG04008");
		        	return false;
		        }
		        for (var i=0; i<RowCount(); i++) {
		        	if (GetRowStatus(i+1) == "U" || GetRowStatus(i+1) == "I") {
		        		if (GetCellValue(i+1,"pkup_yd_id").length < 5) {
	    					ComShowCodeMessage("BKG40105", "pkup_yd_id");
	    					SelectCell(i+1,"pkup_yd_id");
	    					return false;
		        		}
		                SetCellValue(i+1, "rtn_yd_sav_usr_id",formObj.usr_id.value,0);
		                SetCellValue(i+1, "rtn_yd_sav_ofc_cd",formObj.usr_ofc_cd.value,0);
		        	}
		        }
        		break;
         	}
        }
        return true;
    }
