/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0028.js
*@FileTitle : Owner’s Account - Window
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0028 : ESM_FMS_0028 definition of biz script for creation screen
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
	    	        		var ownersAccountData={
	    	        				acct_nm        			: "",
	    	        				acct_cd        			: "",
	    	        				vvd_bunker     			: "",
	    	        				curr_cd        			: "",
	    	        				n1st_amt       			: "",
	    	        				ap_desc        			: "",
	    	        				ctr_cd         			: "",
	    	        				slp_loc_cd     			: "",
	    	        				flet_olay_comm_rt_amt   : "",
	    	        				flet_src_tp_cd 			: "",
	    	        				slp_tp_cd      			: "",
	    	        				slp_func_cd    			: "",
	    	        				slp_ofc_cd     			: "",
	    	        				slp_iss_dt     			: "",
	    	        				slp_ser_no     			: "",
	    	        				slp_seq_no     			: "",
	    	        				manhour_ch				: ""
	    	        		};
							ownersAccountData.acct_nm=sheetObject.GetCellValue(row,"acct_nm");
							ownersAccountData.acct_cd=sheetObject.GetCellValue(row,"acct_cd");
							ownersAccountData.vvd_bunker=sheetObject.GetCellValue(row,"vvd_bunker");
							ownersAccountData.curr_cd=sheetObject.GetCellValue(row,"curr_cd");
							ownersAccountData.n1st_amt=sheetObject.GetCellValue(row,"n1st_amt");
							ownersAccountData.ap_desc=sheetObject.GetCellValue(row,"ap_desc");
							ownersAccountData.ctr_cd=sheetObject.GetCellValue(row,"ctr_cd");
							ownersAccountData.slp_loc_cd=sheetObject.GetCellValue(row,"slp_loc_cd");
							ownersAccountData.flet_olay_comm_rt_amt=sheetObject.GetCellValue(row,"flet_olay_comm_rt_amt");
							ownersAccountData.flet_src_tp_cd=sheetObject.GetCellValue(row,"flet_src_tp_cd");
							ownersAccountData.slp_tp_cd=sheetObject.GetCellValue(row,"slp_tp_cd");
							ownersAccountData.slp_func_cd=sheetObject.GetCellValue(row,"slp_func_cd");
							ownersAccountData.slp_ofc_cd=sheetObject.GetCellValue(row,"slp_ofc_cd");
							ownersAccountData.slp_iss_dt=sheetObject.GetCellValue(row,"slp_iss_dt");
							ownersAccountData.slp_ser_no=sheetObject.GetCellValue(row,"slp_ser_no");
							ownersAccountData.slp_seq_no=sheetObject.GetCellValue(row,"slp_seq_no");
							ownersAccountData.manhour_ch=sheetObject.GetCellValue(row,"manhour_ch");
	    	        		aryData[idx++]=ownersAccountData;
	    	        	}
	    	        	localopener.setOwnersAccount(aryData);
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
               
              var HeadTitle=" ||Apply|Item Name|Account Code|Original Slip No.|Vessel VVD|Cur|Amount|LCL|Amount|Manhour CH|Description|Center Code|City Code|FLET_OLAY_COMM_RT_AMT|Flet Src TpCd|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|SLP_SEQ_NO|Vvd Yn";
              var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"check",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"acct_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:175,  Align:"Center",  ColMerge:0,   SaveName:"org_slp_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_bunker",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:36,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"n1st_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:36,   Align:"Center",  ColMerge:0,   SaveName:"loc_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"loc_amt",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"manhour_ch",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"ap_desc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ctr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"flet_olay_comm_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_src_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_func_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"slp_iss_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_ser_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_seq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_yn",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
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
   				sheetObj.DoSearch("ESM_FMS_0028GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	Check Field Value
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
     * sheet_OnSearchEnd Event occur in Sheet
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
   	}
