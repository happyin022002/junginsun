/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0030.js
*@FileTitle  : Stock Report (Due Data)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
         var shtCnt=0;
         var sheetObject=sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName){
            		case "btn_downexcel":
             			if(sheetObject.RowCount() < 1){//no data 
             				 ComShowCodeMessage("COM132501");
             				}else{ 
             					sheetObject.Down2Excel({ HiddenColumn:true});
             				}
            			break;
					case "btn_Close":
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
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    //setting height
            	
            	//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	var HeadTitle="Due\nI/O|Yard|C.Yard|MVMT|Date|TYPE|TP/\nSZ|CNTR No.|BKG No.|B/L No.|P/D Date|User ID|Office|Creation\nDate";
            	var headCount=ComCountHeadTitle(HeadTitle);
            	(headCount, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"stk_gate_io_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"stk_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd" },
            	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"stk_jb_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd" },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"stk_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"stk_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(275);
            	SetEditable(0);
                }
                break;
        }
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:    
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   sheetObj.SetWaitImageVisible(0);
	    	   ComOpenWait(true); 	    	   
	    	   formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT 	    	   sheetObj.DoSearch("EES_CIM_0030GS.do",FormQueryString(formObj) );
	    	   ComOpenWait(false); 
	    	   break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    /**
     * handling process after retrieving 
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
//no support[implemented common]CLT 		sheetObj.SelectHighLight=false;
		sheetObj.RenderSheet(1);
	}
     /**
      * event when clicking cell
      * setting background color for selected row
      */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	    
