/*=========================================================
* 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2001_03.js
*@FileTitle  : Guideline Creation - Arbitrary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESM_PRI_2001_03 : Business Script for ESM_PRI_2001_03
     */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var enableFlag=true;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.07.14
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				case "btn_loadexcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break; 
				case "btn_rowadd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btn_rowcopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;
				case "btn_delete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.07.14
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.07.14
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        	//Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        pageOnLoadFinish();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.07.14
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                
		              var HeadTitle="|Sel.|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton <=)|Weight\n(<Ton )|Base Port|Per|Cargo Type|Cur.|Rate||||||";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",           KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"arb_seq" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
		              SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		              SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		              SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		              SetColProperty("rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		              SetColProperty("bse_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		              //SetAutoRowHeight(0);
		              resizeSheet(); //SetSheetHeight(360);
		              
		              
              }
				break;
	            case "sheet2":
//	                with(sheetObj){
////	                (1, 0, 0, true);	              
//
//		              SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
//	
//		              var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
//		              var headers = [ { Text:"", Align:"Center"} ];
//		              InitHeaders(headers, info);
//	
//		              var cols = [  ];
//		               
//		              InitColumns(cols);
//
//	            }

					break;
        }
    }
    
    function resizeSheet() {
   	   	ComResizeSheet(sheetObjects[0]);
   	}
    /**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     * @author 
     * @version 2009.07.14
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //Retrieving
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
              	}
	        	formObj.f_cmd.value=SEARCH;
	        	sheetObj.DoSearch("ESM_PRI_2001_03GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
           		break;
        	case IBSEARCH_ASYNC01: // radio button select
	 			//var firstCheck = false;
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2001_03GS.do" , FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "typecd|typecount");
				var obj=document.form;
				if (parseInt(arrData[0][1]) > 0) {
					formObj.org_dest_tp_cd[0].checked=true;
				} else if(parseInt(arrData[1][1]) > 0) {
					formObj.org_dest_tp_cd[1].checked=true;
				}
				break;
        	case IBSEARCH_ASYNC02: // Font Style
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2001_03GS.do" , FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "typecd|typecount");
				if (parseInt(arrData[0][1]) > 0) {
					document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
				} else {
					document.getElementById("org_dest_tp_cd1").style.fontWeight="";
				}
				if(parseInt(arrData[1][1]) > 0) {
					document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
				} else {
					document.getElementById("org_dest_tp_cd2").style.fontWeight="";
				}
				break;		
        	case IBSEARCH_ASYNC03:
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02070";
				} else {
					formObj.cd.value="CD02071";
				}
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
        	case IBSAVE:
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
            	}
           		formObj.f_cmd.value=MULTI;			
				var sParam=FormQueryString(formObj);
 				var sParamSheet=sheetObj.GetSaveString(false);
 				var sXml=sheetObj.GetSaveData("ESM_PRI_2001_03GS.do", sParam+"&"+sParamSheet);
 				sheetObj.LoadSaveData(sXml);
 				ComOpenWait(false);
                break;
        	case MODIFY01:
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
	        	}
	       		formObj.f_cmd.value=MULTI;
				var sParamSheet=sheetObj.GetSaveString()+"&f_cmd="+MULTI;
				var sXml=sheetObj.GetSaveData("ESM_PRI_2001_03GS.do", sParamSheet);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
	            break;
        	case IBDOWNEXCEL:
				//sheetObj.Down2Excel(-1);
        		if(sheetObj.RowCount() < 1){//no data	
        			ComShowCodeMessage("COM132501");
        		}else{	
//        			 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
        			 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        		}	
        		
				break;
        	case IBLOADEXCEL:
	        	if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var svcScpCd=formObj.svc_scp_cd.value;
				var glineSeq=formObj.gline_seq.value;
				var ordDestTpCd=ComGetObjValue(formObj.org_dest_tp_cd);
				var sParam="svc_scp_cd="+svcScpCd+"&gline_seq="+glineSeq+"&org_dest_tp_cd="+ordDestTpCd;		
				ComOpenPopup("ESM_PRI_2048.do?"+sParam, 1020, 425, "", "1,0", false);
				break;
			case IBINSERT:      // Insert
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var idx=sheetObj.DataInsert();
				sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
				sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd));
				sheetObj.SetCellValue(idx, "arb_seq",parseInt(ComPriGetMax(sheetObj, "arb_seq")) + 1);
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
				break;
			case IBCOPYROW:      // Row Copy
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				
				var checkedRows=sheetObj.FindCheckedRow( "chk" );
				var checkedRowArr=checkedRows.split("|");
				
				var endCnt = checkedRowArr.length;
				for(var i = endCnt; i >= 0; i--) {
					var chkIdx = checkedRowArr[i];
					sheetObj.SetSelectRow(chkIdx,0);
					var idx=sheetObj.DataCopy();
					sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
					sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
					sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd));
					sheetObj.SetCellValue(idx, "arb_seq",parseInt(ComPriGetMax(sheetObj, "arb_seq")) + 1);
					sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
				}

				break;
			case IBDELETE: // Delete
				if(enableFlag && !validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				deleteRowCheck(sheetObj, "chk" ,true);
				break;
        }
    }
    /**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.07.14
	 */
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="-";
 		// Process Axon Event No.1, Event Catch 
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.07.14
     */
	function obj_click(){
		var formObj=document.form;
		//if (event.srcElement.name == "org_dest_tp_cd") {
		if (ComGetEvent("name") == "org_dest_tp_cd") {
			if(sheetObjects[0].IsDataModified()) {
				if(ComShowCodeConfirm('PRI00006')) {
					if(!doActionIBSheet(sheetObjects[0], formObj, MODIFY01)) {
						returnRadioButton();
						return;
					}
				} else {
					returnRadioButton();
					return;
				}
			}
     		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
	}
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * calling popup window <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.07.14
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_RG + "&location_cmd=L&svc_scp_cd="+ formObj.svc_scp_cd.value +"&gline_seq="+ formObj.gline_seq.value;
 			ComOpenPopup(sUrl, 700, 310, "findRoutPntLocDefCd", "1,0,1,1,1,1,1", true);
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd="+ PRI_RG +"&location_cmd=LG&svc_scp_cd="+ formObj.svc_scp_cd.value +"&gline_seq="+ formObj.gline_seq.value;
			ComOpenPopup(sUrl, 700, 310, "findBsePortDefCd", "1,0,1,1,1,1,1", true);
 		}
    }
    
    function findRoutPntLocDefCd(rtnVal){
    	var formObj = document.form;
  		var sheetObj=sheetObjects[0];
    	var tpCd="G";
		if (rtnVal != null){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
			//Modifying location Type
			if (rtnVal.cd.length == 5){
				tpCd="L";
			}
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"rout_pnt_loc_tp_cd",tpCd ,0);
		}
    }
    
    function findBsePortDefCd(rtnVal){
    	var formObj = document.form;
  		var sheetObj=sheetObjects[0];
    	var tpCd="G";
		if (rtnVal != null && checkBasePort(sheetObj, sheetObj.GetSelectRow(), rtnVal.cd)) {
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
			//Modifying location Type
			if (rtnVal.cd.length == 5){
				tpCd="L";
			}
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"bse_port_tp_cd",tpCd ,0);
		}
    }
    /**
     * Calling Function in case of OnChange event <br>
	 * showing Description<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @param {string} Value Mandatory Value
	 * @return void
	 * @author 
	 * @version 2009.07.14
	 */  	    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		switch(sName) {
			case "rout_pnt_loc_def_cd": //point
				validCheckLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
				break;	
			case "bse_port_def_cd": //base port
				if(!checkBasePort(sheetObj, Row, Value)) { 
					 return;
				}
				validCheckLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
 	    		break;
			case "rcv_de_term_cd": //term
				if(Value != "D") {
					checkBasePort(sheetObj, Row, sheetObj.GetCellValue(Row, "bse_port_def_cd"));
				}
				break;
			case "rat_ut_cd":
				checkPerType(sheetObj, Row, Value);
				break;
			case "prc_cgo_tp_cd":
				checkCargoType(sheetObj, Row, Value);
				break;
			case "frt_rt_amt":
				break;
		}
    }
	/**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.07.14
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 		}
 	}   
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Showing saving confirmation message <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.07.14
     */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			parent.setTabStyle();
		}
  	}
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
      	toggleButtons("CLEAR");
      	parent.loadTabPage();
    }
    /**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.07.14
     */ 
	function validCheckLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=locCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.SetCellValue(Row,"loc_des",arrDesc[0][1],0);
				}
			} else {	
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.SetCellValue(Row,"loc_des","",0);
				}
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
			formObj.f_cmd.value=COMMAND24;
			formObj.cd.value=locCd;
			var sParam=FormQueryString(formObj);
			sParam += "&etc1="+PRI_RG;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","G",0);
			} else {
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	/**
     * Re-setting location code <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.07.14
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}
	/**
     * Function to check whether  rat_ut_cd is valid  <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.14
     */
     function checkPerType(sheetObj, Row, Value) {
 		var validPerClass="A,F,O,Q,S,P";
 		if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
         	ComShowCodeMessage("PRI08003");
     		sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
         }
 	}
	/**
     * Function to check whether prc_cgo_tp_cd is valid  <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.14
     */
     function checkCargoType(sheetObj, Row, Value) {
     	var validPerClass="A,F,O,Q,S,P";
     	var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
         if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
             ComShowCodeMessage("PRI08003");
             sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
         }
 	}
	/**
     * Function to check whether bse_port_def_cd is valid <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.14
     */
	function checkBasePort(sheetObj, Row, Value) {
		if (sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value && sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D") {
			ComShowCodeMessage('PRI01020');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","");
			sheetObj.SetCellValue(Row, "bse_port_tp_cd","");
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     * Getting org_dest_tp_cd's value<br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.07.14
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
    /**
     * Changking org_dest_tp_cd's checked status<br>
     * <br><b>Example :</b>
     * <pre>
     *    returnRadioButton()
     * </pre>
     * @return void
     * @author 
     * @version 2009.07.14
     */  
    function returnRadioButton() {
     	var formObj=document.form;
     	if(formObj.org_dest_tp_cd[0].checked) {
 			formObj.org_dest_tp_cd[1].checked=true;
 		} else if(formObj.org_dest_tp_cd[1].checked) {
 			formObj.org_dest_tp_cd[0].checked=true;
 		}
    }
	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.07.14
     */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}
	/**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.07.14
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}
	/**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     *		tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sGlineSeq Mandatory gline_seq
     * @return (String)
     * @author 
     * @version 2009.07.14
     */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if(formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag=true;
            } else {
            	enableFlag=false;
            }
			tabEnableSheet(enableFlag);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
    /**
     * Decide Editable option using the status of parent window. <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param  void
     * @return {Boolean} true(Editable, Status of Main is NO) false (Non-Editable, Status of Main is Yes)
     * @author 
     * @version 2009.07.14
     */    
    function getMainStatus(){
    	var mainStatus=parent.document.form.cfm_flg.value;
     	var editStatus=true;
     	if (mainStatus == "Yes"){
     		editStatus=false;
    	}
    	return editStatus;
    }
	/**
     * setting button's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    toggleButtons("INIT")
     * </pre>
     * @param (string) mandatory button setting mode
     * @return void
     * @author 
     * @version 2009.07.14
     */
    function toggleButtons(mode) {
    	switch (mode) {
	 		case "CLEAR":
	 			ComBtnDisable("btn_retrieve");
	 			ComBtnDisable("btn_save");
	 			ComBtnDisable("btn_downexcel");
	 			ComBtnDisable("btn_loadexcel");
	 			ComBtnDisable("btn_rowadd");
	 			ComBtnDisable("btn_rowcopy");
	 			ComBtnDisable("btn_delete");
	 			break;
	 		case "INIT":
	 			ComBtnEnable("btn_retrieve");
	 			if(getMainStatus()){
	 				ComBtnEnable("btn_save");
	 				ComBtnEnable("btn_loadexcel");
	 			} else {
	 				ComBtnDisable("btn_save");
	 				ComBtnDisable("btn_loadexcel");
	 			}
	 			ComBtnEnable("btn_downexcel");
	 			ComBtnEnable("btn_rowadd");
	 			ComBtnEnable("btn_rowcopy");
	 			ComBtnEnable("btn_delete");
	 			break;
	 		case "READONLY":
	 			ComBtnEnable("btn_retrieve");
	 			ComBtnDisable("btn_save");
	 			ComBtnEnable("btn_downexcel");
	 			ComBtnDisable("btn_loadexcel");
	 			ComBtnDisable("btn_rowadd");
	 			ComBtnDisable("btn_rowcopy");
	 			ComBtnDisable("btn_delete");
	 			break;
 		}
 	}
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory  
     * @return void
     * @author 
     * @version 2009.07.14
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	  		case IBSEARCH: // retrieving			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} 
            	if(sheetObj.IsDataModified()){
	            	if ( ComShowCodeConfirm("PRI00010") ) {
	            		return true;
	            	}else {
	            		return false;
	            	}
	            }	
	  			return true;
				break;
		  	case IBSAVE: // Saving
	            if(!ComPriConfirmSave()) {
	                return false;
	            }
			  	if(!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
			  	if(sheetObjects[0].GetSaveString() == "") {
					return false;
				}
				if(sheetObjects[0].IsDataModified()) {
					var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd");
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
					    return false;
				    }
				}
				return true;
				break;
		  	case MODIFY01: // Radio Button Click Save
			  	if(sheetObjects[0].GetSaveString() == "") {
					return false;
				}
				if(sheetObjects[0].IsDataModified()) {
					var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd");
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
					    return false;
				    }
				}
				return true;	
				break;
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				return true;
				break;
			case IBCOPYROW: // Row Copy
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				var checkedRows=sheetObj.FindCheckedRow( "chk" );
				var checkedRowArr=checkedRows.split("|"); 
				if ( checkedRows == "" || checkedRowArr.length == 0 ) {
					ComShowCodeMessage('COM12176');	
					return false;
				} else {
					sheetObj.selectRow=checkedRowArr[0];
				}
				return true;
				break;
			case IBDELETE: // Delete
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				} else {
					return true;
				}
				return true;
				break;
			case IBLOADEXCEL: // Excel Load
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            }
				if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
	        case IBDOWNEXCEL: // 
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            } else {
	                return true;
	            }
	        	return true;
	            break;				
    	}
    	return true;
    }