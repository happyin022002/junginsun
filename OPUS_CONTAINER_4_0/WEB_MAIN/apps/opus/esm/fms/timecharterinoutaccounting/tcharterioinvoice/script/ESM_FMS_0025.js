/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0025.js
*@FileTitle  : Charterer's Account - Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0025 : ESM_FMS_0025 definition of biz script for creation screen
     */
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var localopener=window.dialogArguments;
	if (!localopener) localopener=window.opener;  //이 코드 추가할것
	if (!localopener) localopener=parent; //이 코드 추가할것
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
			        case "btn_confirm":
			        	var sRow=sheetObj.FindCheckedRow("check");
			    		if (sRow == "") {
			    			ComShowCodeMessage('COM12189');
			    			return;
			    		}
			        	var aryData=new Array();
	    	        	var idx=0;
	    	        	for(var i=0; i<sheetObject.LastRow();i++) {
	    	        		var row=i+1;
	    	        		if(sheetObject.GetCellValue(row,"check") == 0) {
	    	        			continue;
	    	        		}
	    	        		var charterExpData={
	    	        				acct_nm : "",
	    	        				acct_cd : "",
	    	        				vvd_bunker : "",
	    	        				curr_cd : "",
	    	        				inv_amt : "",
	    	        				inv_desc : "",
	    	        				ctr_cd : "",
	    	        				slp_loc_cd : "",
	    	        				flet_iss_tp_cd : "",
	    	        				inv_seq : "",
	    	        				inv_dtl_seq : "",
	    	        				chtr_pay_rcv_cd : "",
	    	        				//loc_cd : "",
	    	        				flet_src_tp_cd : "",
	    	        				flet_ctrt_no : ""
	    	        		};
	    	        		charterExpData.acct_nm=sheetObject.GetCellValue(row,"acct_nm");
							charterExpData.acct_cd=sheetObject.GetCellValue(row,"acct_cd");
							charterExpData.vvd_bunker=sheetObject.GetCellValue(row,"vvd_bunker");
							charterExpData.curr_cd=sheetObject.GetCellValue(row,"curr_cd");
							charterExpData.inv_amt=sheetObject.GetCellValue(row,"inv_amt");
							charterExpData.inv_desc=sheetObject.GetCellValue(row,"inv_desc");
							charterExpData.ctr_cd=sheetObject.GetCellValue(row,"ctr_cd");
							charterExpData.slp_loc_cd=sheetObject.GetCellValue(row,"slp_loc_cd");
							charterExpData.flet_iss_tp_cd=sheetObject.GetCellValue(row,"flet_iss_tp_cd");
							charterExpData.inv_seq=sheetObject.GetCellValue(row,"inv_seq");
							charterExpData.inv_dtl_seq=sheetObject.GetCellValue(row,"inv_dtl_seq");
							charterExpData.chtr_pay_rcv_cd=sheetObject.GetCellValue(row,"chtr_pay_rcv_cd");
	    	        		//charterExpData.loc_cd	= sheetObject.CellValue(row,"loc_cd");
							charterExpData.flet_src_tp_cd=sheetObject.GetCellValue(row,"flet_src_tp_cd");
							charterExpData.flet_ctrt_no=sheetObject.GetCellValue(row,"flet_ctrt_no");
	    	        		aryData[idx++]=charterExpData;
	    	        	}
	    	        	localopener.setCharterersExp(aryData);
	    				ComClosePopup(); 
						break;
			        case "btn_close":
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
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
 function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:
                with(sheetObj){
                
              var HeadTitle=" ||Apply|Charterer/Owner|Item Name|Account Code|Vessel VVD|Cur|Amount|Description|Center Code|City Code|FletIssTpCd|Inv Seq|Inv Dtl Seq|Flet Src TpCd|Vvd Yn|Flet Ctrt No";
              var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"chtr_pay_rcv_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"acct_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_bunker",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:227,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ctr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_iss_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"inv_dtl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_src_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_yn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetSheetHeight(260);
                    }


                break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:    
				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESM_FMS_0025GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	Check field Value
     **/
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		if (sheetObj.ColSaveName(Col)==("check")) {
if(sheetObj.GetCellValue(Row,"check") == 0) {
if(sheetObj.GetCellValue(Row,"vvd_yn") != "Y") {
	  				ComShowCodeMessage('FMS01443');
	  				sheetObj.SetCellValue(Row,"check",1);
	  			}
	  		}
  		}
  	}
    /**
     * sheet_OnSearchEnd Event occur in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
   	}
