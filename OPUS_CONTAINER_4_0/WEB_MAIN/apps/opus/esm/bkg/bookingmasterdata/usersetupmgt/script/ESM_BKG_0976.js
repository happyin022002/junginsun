/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_0976.js
*@FileTitle : RemarkTemplate
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /* */
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_RowAdd":
    						doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
					case "btn_Delete":
						if(!validateForm(sheetObject,formObject,"btn_Delete")) {
							return false;
						}
    						ComRowHideDelete(sheetObject,"checkbox");
					break;
					case "btn_Save":
    						doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
					case "btn_Select":
						if(!validateForm(sheetObject,formObject,"btn_Select")) {
							return false;
						}
    						comPopupOK();
					break;
					case "btn_Close":
						ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
            	            	
                var HeadTitle1="|Sel.|Type|Title|Contents|Seq";
                var headCount=ComCountHeadTitle(HeadTitle1);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			   {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tmplt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	   {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"tmplt_hdr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 	   {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:"tmplt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tmplt_seq" } ];
               
               InitColumns(cols);

               SetEditable(1);
               SetCountPosition(0);
               
               SetColProperty(0,"tmplt_tp_cd", {ComboText:"Internal|Customer|Vendor", ComboCode:"I|X|E"} );
               SetSheetHeight(170);
               
               }

			break;
        }
    }
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:      //retrieve
            	if(!validateForm(sheetObj,formObj,sAction)) return;
		if (sheetObj.id == "sheet1") {
	            	formObj.f_cmd.value=SEARCH;
	                // (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])                	
 	            	sheetObj.DoSearch("ESM_BKG_0976GS.do", FormQueryString(formObj) );
        	}
                break;
          case IBSAVE:        //
		if(!validateForm(sheetObj,formObj,sAction)) {
		    return false;
		}//end if
		if (sheetObj.id == "sheet1") {
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_0976GS.do", FormQueryString(formObj));
        	}
		break;
	case IBDELETE:      // 
		for(i=0;i<sheetObj.RowCount()+1;i++){
			if(sheetObj.GetRowStatus(i) == 'U'){
				sheetObj.SetRowStatus(i,"D");
				sheetObj.SetRowHidden(i,1);
			}
		}
            break;
          case IBINSERT:      // 
       	         sheetObj.DataInsert(-1);
       	         break;
        }
    }
    function doSelectSheet(sheetObject, col) {
    	var sRow=sheetObject.FindCheckedRow(col);
    	var checkRow=sRow.split("|");
    	if (checkRow.length-1 == 1) {
//    		alert(checkRow[0]);
//    		window.close();
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		switch(sAction) {
		case "btn_Delete":
			if (sheetObj.CheckedRows("checkbox") == 0) {
				ComShowMessage(msgs['COM12189']);
				return false;
			} else if (sheetObj.CheckedRows("checkbox") > 0) {
				ComShowMessage(msgs['COM12188']);
				return true;
			}
			break;
/*
		case "btn_Select":
			if (sheetObj.CheckedRows("checkbox") > 1) {
				ComShowMessage(msgs['BKG00362']);
				return false;
			}
			break;
*/
		}
        }
        return true;
    }
