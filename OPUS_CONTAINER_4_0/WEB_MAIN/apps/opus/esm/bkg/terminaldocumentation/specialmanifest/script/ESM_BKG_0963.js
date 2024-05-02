/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0963.jsp
*@FileTitle  : Bay plan Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/25 
=========================================================*/
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn1_Select": // Retrieve
						doActionIBSheet(sheetObjects[0],document.form,COMMAND01); 
						break;
					case "btn1_Detail": // Bay-Plan Detail popup open
						if(sheetObject.RowCount()== 0 || sheetObject.GetSelectRow()< 1) return false;
						var vayId=sheetObject.GetCellValue(sheetObject.GetSelectRow(), "bay_pln_id");
						var openType=formObject.openType.value;
						var currMainPageListCnt=formObject.currMainPageListCnt.value;
						sUrl="ESM_BKG_1091.do?"; // Bay plan Detail Setup Screen
						sParam="bayId="+vayId+"&openType="+openType+"&currMainPageListCnt="+currMainPageListCnt;

						ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_1091", 740, 450, false);
//						var rtnVal=ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0961", 740, 500, true);
//						
//						if(rtnVal != undefined && rtnVal.length > 0) {
//							//alert("rtnVal.length : " + rtnVal.length)
//							 var obj=new Object();
//							 obj=rtnVal ; 
//							 window.returnValue=obj;
//							 ComClosePopup(); 
//						}
						break;
					case "btn1_Close":
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
     * @param sheet_obj IBSheet Object
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
        sheet1_OnLoadFinish(sheet1);
    }
 	/**
 	 * Sheet1 on load event handling
 	 * @param sheetObj
 	 * @return
 	 */
 	function sheet1_OnLoadFinish(sheetObj) {
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
 	 }   
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
		                
		              var HeadTitle1="|Seq.|Bay ID|Date|Vessel|T/VVD|FROM|TO|Sender";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		             // (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bay_pln_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trnk_vvd_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetSheetHeight(260);
		              SetCountPosition(0);
                    }


			break;
        }
    }
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH: 
        	  ComOpenWait(true);
        	  formObj.f_cmd.value=SEARCH;
        	  sheetObj.DoSearch("ESM_BKG_0963GS.do", FormQueryString(formObj) );
        	  ComOpenWait(false);
        	  break;
          case COMMAND01:     //Select 
        	  if(!validateForm(sheetObj,formObj,sAction))return;
        	  sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow(), sheetObj.GetSelectCol())
        	  break;
        }
    }
    /**
     * handling process for input validation
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
			case COMMAND02 : // Select
				if(sheetObj.RowCount()== 0) {
		    		ComShowCodeMessage('BKG00095');
		    		return false;
				}
				break;
    	}
        return true;
    }
    /**
     * Sheet1 double click event handling
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	//ComShowMessage("Mouse Double Click Event \n" + "Row : " + Row + "\n" + "Col : " + Col);
    	if(document.form.openType.value == "2") return false;  // openType="2"=> skip Double Click Event 
    	var obj=new Object(); 
    	obj.cd=sheetObj.GetCellValue(Row, "bay_pln_id");
		window.returnValue=obj;
		
		if (document.form.openType.value == "10") {
		    parent.setBayplnId(sheetObj.GetCellValue(Row, "bay_pln_id"))
		}
		ComClosePopup(); 
    }
