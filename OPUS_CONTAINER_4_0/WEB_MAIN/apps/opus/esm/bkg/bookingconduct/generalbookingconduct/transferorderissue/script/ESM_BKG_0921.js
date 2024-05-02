/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0921.js
*@FileTitle  : TRO-Multi
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0921 : esm_bkg_0921 business script for
     */

    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /* */
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Close":
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
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        initControl();
    }
    function initControl() {
    	var formObj=document.form;
    	formObj.cntr_no.focus(); 
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //hidden sheet1
	            with (sheetObj) {	
		       
			        var HeadTitle="Booking No.||TRO|MASTER";
			        var headCount=ComCountHeadTitle(HeadTitle);
//			        (headCount, 0, 0, true);
		
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
		
			        var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tro_i",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"master",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
		
			        SetEditable(1);
			        SetSheetHeight(120);

			    }
				break; 	
		}
	}
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {    	
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //retrieve	              		
	          	formObj.f_cmd.value=SEARCH;
           	    sheetObj.DoSearch("ESM_BKG_0921GS.do", FormQueryString(formObj) );
                break;
        }
    }
    //#################(Event)############################
    // Sheet searchEnd
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
   	    var formObj=document.form;
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{
  				SetCellFontUnderline(i, "bkg_no",1);
 			}
 		}
    }    
    // Sheet Click
    function sheet1_OnClick(sheetObj, Row, Col, Value)
    {   	
		with(sheetObj) {
			switch(ColSaveName(Col)){
	            case "bkg_no":
	            	var bkg_no=Value;
	            	var sUrl="/opuscntr/opusMain.screen";
	            	sUrl += "?parentPgmNo=ESM_BKG_M001";
	            	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079.do";
	            	sUrl += "&pgmNo=ESM_BKG_0079";
	            	sUrl += "&bkg_no="+bkg_no;
	            	//freezing 
//	            	ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 750, false);
	            	comBkgCallPopBkgDetail(bkg_no);   
	            	//var sOption = "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=1024,height=700,left=0,top=0";
	            	//ComOpenWindow2(sUrl, 'p', sOption); 
	            	break;
			}
		}
    }
    //#################(Etc/Logic)############################
