/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0176.js
*@FileTitle  : Excel Upload 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends 
     * @class ESM_SAQ_0176 : business script for ESM_SAQ_0176
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isParentRefresh=false;
    var pWindow="";
    var lod_col=19;
    var grs_rpb_col=20;
    var rpb_col=21;
    var rmrk_col=26;
    var pol_col=13;
    var pod_col=14;
    var cmpb_col=21;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var formObj=document.form;
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
//    	var srcObj=window.event.srcElement;    
//        if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
        switch(srcName) {
        	case "btn_retrieve": // retrieve
        		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        		break;   
    		case "btn_DownExcel":
    			doActionIBSheet(sheetObjects[0],formObj,IBDOWNEXCEL);
    			break;       
    		case "btn_excelupload":
    			doActionIBSheet(sheetObjects[0],formObj,IBLOADEXCEL);			
    			break;					 		
    		case "btn_save":
    			doActionIBSheet(sheetObjects[0],formObj,IBSAVE);		
    			break;						
        	case "btn_close":
        	    ComClosePopup();
        	    break;        
        } // end switch
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
//    	pWindow=window.dialogArguments;
//    	pWindow.isParentRefresh=false;   	
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);        	
            ComEndConfigSheet(sheetObjects[i]);
        }
            ComBtnDisable("btn_save");
        if (isDevMode) {
            //hiddenLayer2.style.display = "Inline";
        }
        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);     
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
    		case 1: 
    		case 2:		     
    			with (sheetObj) {
	    		    var formObj=document.form;
	    		    var inclPortFlag=formObj.inclPortFlag.value;
	    		    var step_cd=formObj.mqta_step_cd.value;
	    	    	var HeadTitle="|Seq|Editable|Step|Year|Quarter|Trade|Sub\nTrade|Lane|Bound|Version|VVD\nGroup|Month|POL|POD|Voyage|Supply|Regional\nGroup|Unit|Volume|G.Rev|GRPB||CMPB|||Remark";
	    		    
	    		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	    		    var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    		    var headers =  [{ Text:HeadTitle, Align:"Center"}]; 
	    		    InitHeaders(headers, info);
	    		    
	    		    var cols = [ {Type:"Text",   Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"editable",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mqta_step_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"mqta_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lane_grp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:(inclPortFlag=="N")?1:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:(inclPortFlag=="N")?1:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"voyage",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"unit",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_rev",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_rpb_rev",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:1,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"ra_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cmpb",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:1,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"ra_opfit_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"opb",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	    		              {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"remark",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    		     
	    		    InitColumns(cols);

    		    	SetEditable(1);
    		        setRowColor(sheetObj, lod_col, rpb_col);
    		        SetSheetHeight(ComGetSheetHeight(sheetObj,18));
    	        }
    			break;		
        }
    }

    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        // disabled save button 
       	ComBtnDisable("btn_save");						    
    	switch(sAction) {
    		case IBSEARCH:     
    			ComOpenWait(true);
    		    formObj.f_cmd.value=SEARCHLIST;	
//    		    sheetObj.DoSearch("ESM_SAQ_0176GS.do", saqFormString(formObj) );
   			    var sXml = sheetObj.GetSearchData("ESM_SAQ_0176GS.do", saqFormString(formObj));
                if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );
                if (sXml != "") rhqAdjSheet_campare.LoadSearchData(sXml,{Sync:1} );
                
    		    // setting row color[editor:yellow] 
    		    setRowColor(sheetObj, lod_col, rpb_col);
    			break;
    			
    	    case IBDOWNEXCEL:  //excel download
				if(sheetObj.RowCount() < 1){//no data
	                ComShowCodeMessage("COM132501");
	            }else{
	            	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	            }
				break;
				
    		case IBLOADEXCEL:                  // upload excel
        		// Message Reset    	    
                document.form.msg.value="";
        		// Sheet Reset				
                rhqAdjSheet.RemoveAll();
    		    // Init Sheet
    		    initSheet(rhqAdjSheet,1);
    		    rhqAdjSheet.LoadExcel({ Mode:"HeaderMatch"});
    			break;
    			
    		case IBSAVE:                      // SAVE
    		    formObj.f_cmd.value=MODIFY01;
    		    sheetObj.DoSave("ESM_SAQ_0176GS.do", saqFormString(formObj), "ibflag", false);
                ComBtnDisable("btn_save");
                document.form.msg.value="Save successfully.\n"+
                                        "====================================================================================\n" ;            
    		    break;
    	}
    }
    /**
     * rhqAdjSheet_OnLoadExcel Event
     */	
    function rhqAdjSheet_OnLoadExcel(sheetObj, result, code, msg) {
    	if(isExceedMaxRow(msg))return; //2014-04-22 공통 요청사항(10,000 Row 제어)
    	var formObj      = document.form;
        var inclPortFlag = formObj.inclPortFlag.value; 
        
        rhqAdjSheet.ColumnSort("rn", "ASC");
        rhqAdjSheet_campare.ColumnSort("rn", "ASC");

        chkValidation(rhqAdjSheet, rhqAdjSheet_campare, formObj, lod_col, grs_rpb_col, rpb_col, rmrk_col, pol_col, pod_col, inclPortFlag , "N", cmpb_col);
    }	
    /**
     * OnSaveEnd Event
     */	
    function rhqAdjSheet_OnSaveEnd(sheetObj, errMsg) {
        if(sheetObj.GetEtcData("status") == "OK"){
            //isParentRefresh = true;
            pWindow.isParentRefresh=true;
        }
        var formObj=document.form;
        doActionIBSheet(sheetObj,formObj,IBSEARCH);	
    }
    /**
     * Sheet OnSearchEnd Event
     */	
    function rhqAdjSheet_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
