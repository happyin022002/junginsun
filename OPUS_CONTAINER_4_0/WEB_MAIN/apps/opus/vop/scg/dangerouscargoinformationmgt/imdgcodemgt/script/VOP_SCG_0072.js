/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0072.jsp
 *@FileTitle : Segregation Simulation in a CNTR
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class VOP_SCG_0072 : business script for VOP_SCG_0072
     */

    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
		/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1]; 
        /*******************************************************/
		var formObj=document.form;
    	try {	
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_Un_No":	
					var imdg_un_no=ComGetObjValue(formObj.imdg_un_no);
					var paramStr="";
					if(imdg_un_no.length <= 4 && !isNaN(imdg_un_no)) {
						paramStr="&imdg_un_no="+imdg_un_no;
					} else {
						if(imdg_un_no.length > 4) {
							if(imdg_un_no.indexOf(",") == -1) {
								paramStr="&imdg_tec_nm="+imdg_un_no;
							}
						}
					}
                	var sUrl="/opuscntr/VOP_SCG_0002Pop.do?pgmNo=VOP_SCG_0002&pop_yn=Y"+paramStr;
            		ComOpenPopup(sUrl, 1006, 700, "setCallBackUnNoList", "0,1,1,1,1,1,1,1,1", true);
					break;
				case "btn2_Segregation_Check":
					doActionIBSheet(sheetObj1, sheetObj2,formObj,IBSEARCH);
					break;
				case "btn2_Down_Excel":
                      var paramObj = new Object();
                      var sheetExcelObj = "";
                      
					  if(sheetObj2.RowCount() < 1){//no data
		                   ComShowCodeMessage("COM132501");
		              }else{
						if(sheetObj2.RowCount() > 0) {
		                    paramObj.title="Segregation Validation";
	//	                    paramObj.cols="7";
	//	                    paramObj.columnwidth="1:5|2:5|3:5|4:90|5:5|6:5|7:5";
	//	                    paramObj.datarowheight="0:25";
	//	                    var url=ComScgGetPgmTitle(sheetObj2, paramObj);
	// 	                    sheetObj2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj2), SheetDesign:1,Merge:1, SheetName:'Segregation Validation' });
							sheetExcelObj = sheetObj2;
		                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
		                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
		                    paramObj.datarowheight="0:25";
		                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
		                    
		                    if(sheetExcelObj.RowCount() < 1){//no data
		                		  ComShowCodeMessage("COM132501");
		        	       	}else{
			       	       		var str = sheetExcelObj.GetSearchData(url);
			       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
			       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
		        	       	}
						}
						
						//sheetObj2.Down2ExcelBuffer(false);
						return;
		              }
					  
					  if(sheetObj1.RowCount() < 1){//no data
		                   ComShowCodeMessage("COM132501");
		              }else{
	                    paramObj.title="DG Items in a Container";
	                    sheetExcelObj = sheetObj1;
//	                    paramObj.cols="10";
//	                    paramObj.columnwidth="1:5|2:5|3:5|4:5|5:5|6:5|7:5|8:10|9:60|10:10";
	                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
	                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	                    
	                    paramObj.datarowheight="0:25";
	                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj);
	                    
	                    sheetExcelObj.Down2ExcelBuffer(true);  
//	                    sheetObj1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1, SheetName:'DG Items in a Container' });
	                    if(sheetExcelObj.RowCount() < 1){//no data
	                		  ComShowCodeMessage("COM132501");
	        	       	}else{
	        	       		//var pathArr = url.split("?");
		       	       		var str = sheetExcelObj.GetSearchData(url);
		       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
		       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
	        	       	}
	                    
	                    //sheetObj1.Down2ExcelBuffer(false);
		              } 
					  
					break;	
				case "btn_New":
                	ComResetAll();
            		ComSetFocus(formObj.imdg_un_no);
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
     * Handling Sheet1 Combo Change Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 with(sheetObj) { 
    		switch(ColSaveName(Col)) {
    			case "sel_chk":
    				if(Value == 0) {
    					SetCellValue(Row, "lq_chk",0,0);
    					SetCellValue(Row, "eq_chk",0,0);
    					SetCellEditable(Row, "lq_chk",0);
    					SetCellEditable(Row, "eq_chk",0);
    					SetRowStatus(Row,"R");
    				} else {
    					SetCellEditable(Row, "lq_chk",1);
    					SetCellEditable(Row, "eq_chk",1);
    				}
    				//Control all-check box
    				var allChk=0, allCt=0;
    				for(var chkIdx=HeaderRows(); chkIdx<=LastRow(); chkIdx++) {
    					if(GetCellValue(chkIdx, "sel_chk") == 1) allChk++;
    					allCt++;
    				}
    				if(allChk == allCt) CheckAll("sel_chk",1);
    				else if(allChk == 0) {
    					CheckAll("sel_chk",0);
    					for(var chkIdx=HeaderRows(); chkIdx<=LastRow(); chkIdx++) {
    						SetRowStatus(chkIdx,"R");
        				}
    				}
    				break;
    			case "lq_chk":
    				if(Value == "1") {
    					SetCellValue(Row, "eq_chk",0,0);
    				}
    				break;
    			case "eq_chk":
    				if(Value == "1") {
    					SetCellValue(Row, "lq_chk",0,0);
    				} 
    				break;
    		}
    	 }
	}
    /**
	 * Downloading selected list from UN Number popup
	 */
	function setCallBackUnNoList(aryPopupData) {
		var sheetObj=sheetObjects[0];
		//sheetObj.removeAll();
		var imdg_un_nos="";
		var tecName="";
		var existenceYn=false;
		for (var rowIdx=0; rowIdx<aryPopupData.length; rowIdx++){ 
			existenceYn=false;
			for(var curIdx=sheetObj.HeaderRows(); curIdx<=sheetObj.LastRow(); curIdx++) {
				if(sheetObj.GetCellValue(curIdx, "imdg_un_no") == aryPopupData[rowIdx][2]
				&& sheetObj.GetCellValue(curIdx, "imdg_un_no_seq") == aryPopupData[rowIdx][3]) existenceYn=true;
			}
			if(!existenceYn) {				
				sheetObj.DataInsert(-1,0);	//create new row
				imdg_un_nos += aryPopupData[rowIdx][2]+",";
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_un_no",aryPopupData[rowIdx][2],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_un_no_seq",aryPopupData[rowIdx][3],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_clss_cd",aryPopupData[rowIdx][4],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_comp_grp_cd",aryPopupData[rowIdx][5],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prp_shp_nm",aryPopupData[rowIdx][6],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_tec_nm",aryPopupData[rowIdx][7],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_pck_grp_cd",aryPopupData[rowIdx][9],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_lmt_qty",aryPopupData[rowIdx][11],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_expt_qty_cd",aryPopupData[rowIdx][12],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "imdg_subs_rsk_lbl_rmk",aryPopupData[rowIdx][8],0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sel_chk",1);
			}
		}
		for(var tecIdx=sheetObj.HeaderRows(); tecIdx<=sheetObj.LastRow(); tecIdx++) {
			tecName += sheetObj.GetCellValue(tecIdx, "imdg_tec_nm");
		}
		if(tecName.length > 0) sheetObj.SetColHidden("imdg_tec_nm",0);
		else sheetObj.SetColHidden("imdg_tec_nm",1);
		if(imdg_un_nos.length > 0) imdg_un_nos=imdg_un_nos.substring(0,imdg_un_nos.length-1);
		//ComSetObjValue(document.form.imdg_un_no, imdg_un_nos);
	}
    // event Catch Listener
    function initControl() {
         // Axon event handling1. event catch
         axon_event.addListener('keydown',  'unNoKeyEnter',   'form');
    }
    // Enter Key of Un Number form
    function unNoKeyEnter() {
    	var keyValue=event.keyCode;
    	if(keyValue == 13) {
    		if(event.srcElement.name='imdg_un_no') 
    			document.getElementById("btn_Un_No").fireEvent("onclick");
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
			//
			ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//
            ComEndConfigSheet(sheetObjects[i]);			
        }	
        initControl();
        resizeSheet();
    }
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
			      with(sheetObj){
	           
	         //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	         var HeadTitle1="||LQ|EQ|UN No. Seq|UN No. Seq|Class|Class|Subsidiary risk(s)|Proper Shipping Name|Technical Name|Packing Group||";
	         var headCount=ComCountHeadTitle(HeadTitle1);

	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	         InitHeaders(headers, info);

	         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lq_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eq_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"prp_shp_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"imdg_tec_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,    Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_cd" } ];
	          
	         InitColumns(cols);
	         SetSheetHeight(192);
	         SetEditable(1);
	         SetEditableColorDiff(0);
	                  }
                break;
			case "sheet2":      //sheet2 init
                with (sheetObj) {
                    //setting height
				
				var HeadTitle1="|UN No. Seq|UN No. Seq|SG|Conflicts with|UN No. Seq|UN No. Seq|SG";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:650,  Align:"Left",    ColMerge:1,   SaveName:"conflict_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				 
				InitColumns(cols);
				SetSheetHeight(144);
				SetEditable(0);
				SetEditableColorDiff(0);
				}
                break;
        }
    }
    function resizeSheet(){
   	 	ComResizeSheet(sheetObjects[1]);
    }
    /**
     * Handling Sheet2 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) { 
    	with(sheetObj) {
    		var rsltStr="";
    		if(RowCount()== 0) {
    			rsltStr='Load complies with IMDG Code segregation requirements.';
    		} else {
    			rsltStr="<font color='#ff0000'>"+'Load does not comply. Segregation is required between pairs of substances listed below.'+"</font>";
    		}
    		document.getElementById("rsltStr").innerHTML=rsltStr;
    	}
    }
    /**
     * Handling Sheet1 OnMouseMove Event
     * param : sheetObj ==> sheet object
     * 
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	if (sheetObj.MouseCol()== 2) {
     //no support[check again]CLT 		sheetObj.MouseToolTipText="Limited Q'ty";
     	} else if (sheetObj.MouseCol()== 3) {
     //no support[check again]CLT 		sheetObj.MouseToolTipText="Excepted Q'ty";
     	} else {
     //no support[check again]CLT 		sheetObj.MouseToolTipText="";
     	}
    }
    /**
     * Handling Sheet2 OnMouseMove Event
     * param : sheetObj ==> sheet object
     * 
     */
    function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	if (sheetObj.MouseCol()== 3 || sheetObj.MouseCol()== 7) {
     //no support[check again]CLT 		sheetObj.MouseToolTipText="Segregation Group";
     	} else {
     //no support[check again]CLT 		sheetObj.MouseToolTipText="";
     	}
    }
	// Sheet related process handling
    function doActionIBSheet(sheetObj1, sheetObj2, formObj, sAction) {
        sheetObj2.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj1,formObj,sAction)){
					switch(sheetObj2.id) {
						case "sheet2":
							var sParam=ComGetSaveString(sheetObj1, false, false, -1);
							if(sParam == "") return;
							formObj.f_cmd.value=SEARCH;
 							sheetObj2.DoSearch("VOP_SCG_0072GS.do", "f_cmd="+SEARCH+"&"+sParam );
							break;
					}					
				}
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction) {
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
		return true;
	}
