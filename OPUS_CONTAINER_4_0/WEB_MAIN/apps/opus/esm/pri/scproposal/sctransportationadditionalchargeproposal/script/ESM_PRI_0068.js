/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0068.js
*@FileTitle  : S/C Proposal Origin/Destination IHC ? Excel import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
    // global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var errFlg=false;	
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    
//다음의 화면들에서 호출됨
//ESM_PRI_0003_05
    
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	    		case "btn_template":
					downform.submit();
					break;
	    		case "btn_openfile":
	    			sheetObject1.LoadExcel({ Mode:"HeaderMatch"});
					break;
	    		case "btn_check":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":
					 opener.reloadExcelCopy();
					ComClosePopup(); 
					break;
            }
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
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
   	 	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;
   	 
    	 for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
    	 }
    	 pageOnLoadFinish();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
     	var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //t1sheet1 init
                with(sheetObj){               
	             var HeadTitle="state|Seq.|Point|Zip Code|Zip Code|Trans Mode|Term|Base Port|Per|Cargo Type|Currency|Proposal|||||||||||";
	             var headCount=ComCountHeadTitle(HeadTitle);
	             (headCount, 0, 0, true);
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"loc_grd_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"loc_grd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
			                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
			                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	             SetEditable(1);
	             SetWaitImageVisible(0);
	             SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
	             SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
	             SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
	             SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
	             SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
	             SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
	             //SetAutoRowHeight(0);
//	             SetSheetHeight(260);
	             resizeSheet();

             }
                break;
            case "sheet2":
                with(sheetObj){
		              var HeadTitle="status";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];               
		              InitColumns(cols);
		              SetEditable(1);
		              SetVisible(0);
                    }break;
            case "sheet3":      
                with(sheetObj){
		                 var HeadTitle="state|Point|Trans Mode|Term|Base Port|Per|Cargo Type|Currency";
			             var headCount=ComCountHeadTitle(HeadTitle);
			             (headCount, 0, 0, true);
			             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle, Align:"Center"} ];
			             InitHeaders(headers, info);
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0 },
			                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0 },
			                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0 },
			                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0 },
			                 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0 },
			                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0 },
			                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0 } ];
			              
			             InitColumns(cols);
			             SetEditable(0);
			             SetWaitImageVisible(0);
			             SetVisible(0);
                      }
	        		break;         
            case "sheet4":      
                with(sheetObj){                
		             var HeadTitle="state|Point|Base Port";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             (headCount, 0, 0, true);
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd" },
		                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd" } ];
		              
		             InitColumns(cols);
		             SetEditable(0);
		             SetWaitImageVisible(0);
		             SetSheetHeight(200);
                      }
	        	break; 	        	
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH_ASYNC01: 
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
        		}
        		ComOpenWait(false);
                break;
        	case IBSEARCH_ASYNC03:
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02138";
				} else {
					formObj.cd.value="CD02139";
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
	        	formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0068GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString());
				var sFlag=ComGetEtcData(sXml, "FLAG");
				var sDupIdx=ComGetEtcData(sXml, "DUP_INDEX");
				if(sFlag == "N") {
					ComShowCodeMessage("PRI02017", sDupIdx);
					sheetObj.SetEditable(1);
				} else {
					formObj.f_cmd.value=MULTI01;
					sheetObj.DoSave("ESM_PRI_0068GS.do", FormQueryString(formObj), -1, false);
				}
				ComOpenWait(false);
                break;
        }
    }
    /**
	 * calling Event when keyboard press data cell  <br>
	 */ 
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	if (errFlg && KeyCode == 9) {
    		while (true) {
    			if (Col > sheetObj.LastCol()) {
    				Row++;
    				Col=1;
    			}
    			if (Row > sheetObj.LastRow()) {
    				Row=sheetObj.HeaderRows();
    			}
    			if (sheetObj.GetCellBackColor(Row, Col) == "#FF0000") {
    				sheetObj.SelectCell(Row, Col, false);
    				break;
    			}
    			Col++;
    		}
    	}
    }
    
    function SheetObject(sheet, row, col){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 	}
 	var _tmp_sheetObject;
    
	/**
     * calling function when occurring OnClick Event <br>
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	
    	_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=L&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			ComOpenPopup(sUrl, 700, 310, "rout_pnt_loc_def_cd_returnVal", "1,0", true);
 			
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			ComOpenPopup(sUrl, 700, 310, "bse_port_def_cd_returnVal", "1,0", true);
 			
 		}
	}
    
    function rout_pnt_loc_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	if (rtnVal != null){
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, 0);
				if (rtnVal.cd.length == 5){ 
					tpCd="L";
				}
				_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row,"rout_pnt_loc_tp_cd",tpCd ,0);
			}
    }
    
    function bse_port_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	if (rtnVal != null  && checkBasePort(_tmp_sheetObject.sheet, _tmp_sheetObject.row, rtnVal.cd)){
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd,0);
				if(rtnVal.cd.length == 5) {
					tpCd="L";
				} else if(rtnVal.cd.length == 4) { 
					tpCd="G";
				}
				_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "bse_port_tp_cd", tpCd, 0);
			}
    }
    /**
	 * calling function when occurring OnChange Event <br>
	 *  when selecting multi comboBox, showing description and retrieveing validation <br>
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
 		var sName=sheetObj.ColSaveName(Col);
 		var amdt_seq=formObj.amdt_seq.value;
 		//sheetObj.CellBackColor(Row, sName) = "#FFFFFF";
 		switch(sName) {
 			case "rout_pnt_loc_def_cd": //point
 				if(!checkRoutePointLocation(sheetObj, Row, Value)) {
 					return;
 				}
 				if(checkLocation(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false)) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 				}
 				break;	
 			case "prc_trsp_mod_cd":
 				if(checkCommonCode(sheetObj, Row, sheetObj.GetCellValue(Row, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 	     		}
 				break;
 			case "rcv_de_term_cd":
 				if(checkCommonCode(sheetObj, Row, sheetObj.GetCellValue(Row, "rcv_de_term_cd"), "rcv_de_term_cd")) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 	     		}
 				break;
 			case "loc_grd_cnt_cd":
 				break;
 			case "bse_port_def_cd": //base port
 				if(!checkBasePort(sheetObj, Row, Value)) { 
 					 return;
 				}
 				if(checkLocation(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true)) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 				}
  	    		break;
 			case "rat_ut_cd":
 				checkPerType(sheetObj, Row, Value);
 				break;
 			case "prc_cgo_tp_cd":
 				checkCargoType(sheetObj, Row, Value);
 				break;
 		}
    }
    /**
     * calling function when occuring LoadExcel event <br>
     * setting SHEET COLUMN in case of successful loading excel file <br>
     */
  	function sheet1_OnLoadExcel(sheetObj, result, code,msg){
  		if(isExceedMaxRow(msg))return;
  		toggleButtons("INIT");
  	}
  	/**
     * calling function when occurring OnSaveEnd event  <br>
     * showing the save completion message in case of successful saving <br>
     */
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	  if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			opener.reloadExcelCopy();
 			ComClosePopup(); 
 		}
	}
    /**
     * calling function when Page Loading <br>
     */ 
function pageOnLoadFinish() {
    	 toggleButtons("CLEAR");
    	 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
    	 toggleButtons("INIT");
    }
  	/**
     * checking location code <br>
     */
	function checkLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		if(ComIsNull(locCd)) {
			return true;
		}
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value=SEARCH05; 	    			
			formObj.cd.value=locCd;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				return true;
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				return false;
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
 			formObj.f_cmd.value=SEARCH17;
 			formObj.cd.value=locCd;
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm,"G", 0);
				return true;
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				return false;
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return false;
 		}
		return true;
	}
	/**
     * initializing location code <br>
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}
	/**
     * checking Zip code's validation <br>
     */
	function checkZipCode(sheetObj) {
		if(sheetObj.GetCellValue(i, "loc_grd_cnt_cd") == "" && sheetObj.GetCellValue(i, "loc_grd_cnt_cd") == "" && sheetObj.GetCellValue(i, "loc_grd_cd") == "") {
   			ComShowCodeMessage('PRI00325','[Point]','[Zip Code]');
   			return false;
   		}
    	return true;
	}
	/**
     * checking rout_pnt_loc_tp_cd's validation <br>
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if (sheetObj.GetCellValue(Row, "bse_port_def_cd") == Value) {
			ComShowCodeMessage('PRI01078');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     * checking bse_port_def_cd's validation <br>
     */
	function checkBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if (sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     * checking prc_cgo_tp_cd's validation <br>
     */
    function checkPerType(sheetObj, Row, Value) {
    	var validPerClass="A,F,O,Q,S,P";
    	if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
    		ComShowCodeMessage("PRI08003");
     		sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
    	}
    }
    /**
     * checking rat_ut_cd's validation <br>
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
     * checking validation function <br>
     * error return when mandatory item is null <br>
     */
	function checkCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.GetCellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
 	/**
      * checking validation process of sheet's column data<br>
      */
 	function validateSheetData(sheetObj, formObj) {
 		var validCnt=0;
 		var rCnt=sheetObj.RowCount();
 		var baseColor="#FFFFFF";
 		var validColor="#FF0000";
 		ComOpenWait(true);
 		for(var i=1; i<=rCnt; i++) {
      		sheetObj.SetCellValue(i, "prop_no",formObj.prop_no.value);
      		sheetObj.SetCellValue(i, "amdt_seq",formObj.amdt_seq.value);
      		sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value);
      		sheetObj.SetCellValue(i, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
      		sheetObj.SetCellValue(i, "add_chg_tp_cd",formObj.add_chg_tp_cd.value);
      		sheetObj.SetCellValue(i, "org_dest_tp_cd",formObj.org_dest_tp_cd.value);
      		sheetObj.SetCellValue(i, "src_info_cd","NW");
 			sheetObj.SetCellValue(i, "prc_prog_sts_cd","I");
//      		if(!validCheckLocation(sheetObj, i, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false)) {
//      			sheetObj.CellBackColor(i, 'rout_pnt_loc_def_cd') = validColor;
//      			validCnt++;
//      		}
 			if(!validCheckLocationGridCountry(sheetObj, i, sheetObj.GetCellValue(i, "loc_grd_cnt_cd"))) {
      			sheetObj.SetCellBackColor(i, 'loc_grd_cnt_cd',validColor);
      			validCnt++;
      		}
 			if(!validCheckLocationGrid(sheetObj, i, sheetObj.GetCellValue(i, "loc_grd_cd"))) {
      			sheetObj.SetCellBackColor(i, 'loc_grd_cd',validColor);
      			validCnt++;
      		}
      		// Trans Mode
 			if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
      			sheetObj.SetCellBackColor(i, 'prc_trsp_mod_cd',validColor);
      			validCnt++;
      		}
      		// Term
 			if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "rcv_de_term_cd"), "rcv_de_term_cd")) {
      			sheetObj.SetCellBackColor(i, 'rcv_de_term_cd',validColor);
      			validCnt++;
      		}
//      		if(!validCheckLocation(sheetObj, i, 'bse_port_tp_cd', 'bse_port_def_cd', true, true)) {
//      			sheetObj.CellBackColor(i, 'bse_port_def_cd') = validColor;
//      			validCnt++;
//      		}
      		//point base port
 			if(!validCheckBasePort(sheetObj, i, sheetObj.GetCellValue(i, "bse_port_def_cd"))) {
 				sheetObj.SetCellBackColor(i, 'bse_port_def_cd',validColor);
 	  			sheetObj.SetCellBackColor(i, 'rcv_de_term_cd',validColor);
 	  			sheetObj.SetCellBackColor(i, 'rout_pnt_loc_def_cd',validColor);
      			validCnt++;
      		}
      		// Per
 			if(!validCheckRatingUnit(sheetObj, i, sheetObj.GetCellValue(i, "rat_ut_cd"))) { //Per(Rating Unit) checking
      			sheetObj.SetCellBackColor(i, 'rat_ut_cd',validColor);
      			validCnt++;
      		}
      		// Cargo Type
 			if(!validCheckCargoType(sheetObj, i, sheetObj.GetCellValue(i, "prc_cgo_tp_cd"))) {
      			sheetObj.SetCellBackColor(i, 'prc_cgo_tp_cd',validColor);
      			validCnt++;
      		}
      		// Currency
 			if(!validCheckCurrency(sheetObj, i, sheetObj.GetCellValue(i, "curr_cd"))) {
      			sheetObj.SetCellBackColor(i, "curr_cd",validColor);
      			validCnt++;
      		}
      		// Proposal
		if(!validCheckProposalFreightRateAmount(sheetObj, i, sheetObj.GetCellValue(i, "prop_frt_rt_amt"))) {
      			sheetObj.SetCellBackColor(i, "prop_frt_rt_amt",validColor);
      			validCnt++;
      		}
 		}
 		ComOpenWait(false);
         document.body.scroll="no";
 		return validCnt;
 	}     
  /**
   * validation function of excel file loading  <br>
   * existing error data, change color <br>
   */
   function checkDBCodeExist(sheetObj, color) {
 	  	var check=0;
 	  	var arbSeq=0;
		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if(sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == "0"){
				sheetObjects[0].SetCellBackColor(i, "rout_pnt_loc_def_cd",color);
				check ++;
			} else {
				sheetObjects[0].SetCellValue(i, "rout_pnt_loc_tp_cd","L",0);
			}			
			if(sheetObj.GetCellValue(i, "bse_port_def_cd") == "0"){
				sheetObjects[0].SetCellBackColor(i, "bse_port_def_cd",color);
				check ++;
			} else {
				if(sheetObjects[0].GetCellValue(i, "bse_port_def_cd").length == 4) {
					sheetObjects[0].SetCellValue(i, "bse_port_tp_cd","G",0);
				} else if(sheetObjects[0].GetCellValue(i, "bse_port_def_cd").length == 5) {
					sheetObjects[0].SetCellValue(i, "bse_port_tp_cd","L",0);
				}
			}
		}		
		return check;
   } 		
//	/**
//     * checking validation process of sheet's column data<br>
//     */
//	function validateCheckSheet(sheetObj, formObj) {
//		var validCnt = 0;
//		var rCnt = sheetObj.RowCount;
//		var baseColor = "#FFFFFF";
//		var validColor = "#FF0000";
//		
//		ComOpenWait(true);
//		for(var i=1; i<=rCnt; i++) {
//     		sheetObj.CellValue(i, "prop_no") = formObj.prop_no.value;
//     		sheetObj.CellValue(i, "amdt_seq") = formObj.amdt_seq.value;
//     		sheetObj.CellValue(i, "svc_scp_cd") = formObj.svc_scp_cd.value;
//     		sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
//     		sheetObj.CellValue(i, "add_chg_tp_cd") = formObj.add_chg_tp_cd.value;
//     		sheetObj.CellValue(i, "org_dest_tp_cd") = formObj.org_dest_tp_cd.value;
//     		sheetObj.CellValue(i, "src_info_cd") = "NW";
//			sheetObj.CellValue(i, "prc_prog_sts_cd") = "I";
//			
//     		if(!validCheckLocation(sheetObj, i, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false)) {
//     			sheetObj.CellBackColor(i, 'rout_pnt_loc_def_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		if(!validCheckLocationGridCountry(sheetObj, i, sheetObj.CellValue(i, "loc_grd_cnt_cd"))) {
//     			sheetObj.CellBackColor(i, 'loc_grd_cnt_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		if(!validCheckLocationGrid(sheetObj, i, sheetObj.CellValue(i, "loc_grd_cd"))) {
//     			sheetObj.CellBackColor(i, 'loc_grd_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Trans Mode
//     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
//     			sheetObj.CellBackColor(i, 'prc_trsp_mod_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Term
//     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "rcv_de_term_cd"), "rcv_de_term_cd")) {
//     			sheetObj.CellBackColor(i, 'rcv_de_term_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		if(!validCheckLocation(sheetObj, i, 'bse_port_tp_cd', 'bse_port_def_cd', true, true)) {
//     			sheetObj.CellBackColor(i, 'bse_port_def_cd') = validColor;
//     			validCnt++;
//     		}
//     		//point base port
//     		if(!validCheckBasePort(sheetObj, i, sheetObj.CellValue(i, "bse_port_def_cd"))) {
//				sheetObj.CellBackColor(i, 'bse_port_def_cd') = validColor;
//	  			sheetObj.CellBackColor(i, 'rcv_de_term_cd') = validColor;
//	  			sheetObj.CellBackColor(i, 'rout_pnt_loc_def_cd') = validColor;
//     			validCnt++;
//     		}
//
//     		// Per
//     		if(!validCheckRatingUnit(sheetObj, i, sheetObj.CellValue(i, "rat_ut_cd"))) { //Per(Rating Unit) 확인
//     			sheetObj.CellBackColor(i, 'rat_ut_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Cargo Type
//     		if(!validCheckCargoType(sheetObj, i, sheetObj.CellValue(i, "prc_cgo_tp_cd"))) { 
//     			sheetObj.CellBackColor(i, 'prc_cgo_tp_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Currency
//     		if(!validCheckCurrency(sheetObj, i, sheetObj.CellValue(i, "curr_cd"))) {
//     			sheetObj.CellBackColor(i, "curr_cd") = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Proposal
//     		if(!validCheckProposalFreightRateAmount(sheetObj, i, sheetObj.CellValue(i, "prop_frt_rt_amt"))) {
//     			sheetObj.CellBackColor(i, "prop_frt_rt_amt") = validColor;
//     			validCnt++;
//     		}
//		}
//		ComOpenWait(false);
//        document.body.scroll = "no";
//		return validCnt;
//	}
	/**
     * checking location code validation function <br>
     */
	function validCheckLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		if(ComIsNull(locCd)) {
			return true;
		}
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value=SEARCH05; 	    			
			formObj.cd.value=locCd;
 			var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				return true;
			} else {
				sheetObj.SetCellValue(Row, cellTpCdNm,"" ,0);
				return false;
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
 			formObj.f_cmd.value=SEARCH17;
 			formObj.cd.value=locCd;
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
 			var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if(arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm, "G", 0);
				return true;
			} else {
				sheetObj.SetCellValue(Row, cellTpCdNm, "", 0);
				return false;
			}
 		} else {
			return false;
 		}
		return true;
	}
	/**
     * checking rout_pnt_loc_tp_cd's validation function <br>
     */
//	function validCheckRoutePointLocation(sheetObj, Row, Value) {
//		if(ComIsNull(Value)) {
//			if(ComIsNull(sheetObj.CellValue(Row, "loc_grd_cnt_cd")) && ComIsNull(sheetObj.CellValue(Row, "loc_grd_cd"))) {
//				return false;
//			} 
//			return true;
//		}
//		return true;
//	}
	/**
     * checking loc_grd_cnt_cd's validation function <br>
     */
	function validCheckLocationGridCountry(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			if(!ComIsNull(sheetObj.GetCellValue(Row, "loc_grd_cd"))) {
				return false;
			}
			return true;
		}
		if(!ComIsAlphabet(Value, "u") || ComGetLenByByte(Value) != 2) {
			return false;
		}
	    return true;
	}
	/**
     * checking loc_grd_cd's validation function <br>
     */
	function validCheckLocationGrid(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			if(!ComIsNull(sheetObj.GetCellValue(Row, "loc_grd_cnt_cd"))) {
				return false;
			}
			return true;
		}
		if(!ComIsNumber(Value, "") || ComGetLenByByte(Value) > 8) {
			return false;
		}
	    return true;
	}
	/**
     * checking bse_port_def_cd's validation function <br>
     */
	function validCheckBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			return false;
		}
		return true;
	}
	/**
     * checking rat_ut_cd's validation function <br>
     */
	function validCheckRatingUnit(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!validCheckCommonCode(sheetObj, Row, Value, "rat_ut_cd")) {
			return false;
		}
    	return true;
	}
	/**
     * checking prc_cgo_tp_cd's validation function <br>
     */
	function validCheckCargoType(sheetObj, Row, Value) {
//		if(ComIsNull(Value)) {
//			return false;
//		}
		if(!validCheckCommonCode(sheetObj, Row, Value, "prc_cgo_tp_cd")) {
			return false;
		}
		var validPerClass="A,F,O,Q,S,P";
		var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
        if(!ComIsNull(perClass) && validPerClass.indexOf(perClass) > -1 && Value != "AK") {
       		return false;
        } else if(!ComIsNull(perClass) && validPerClass.indexOf(perClass) < 0 && Value == "AK") {
       		return false;
        }
        return true;
	}
	/**
     * curr_cd's validation check function <br>
     */
	function validCheckCurrency(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!validCheckCommonCode(sheetObj, Row, Value, "curr_cd")) {
			return false;
		}
    	return true;
	}
	/**
     * checking validation function <br>
     * returning error when mandatory item is null <br>
     */
	function validCheckCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.GetCellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
	/**
     * prop_frt_rt_amt's validation check function <br>
     */
	function validCheckProposalFreightRateAmount(sheetObj, Row, Value) {
		if(ComIsNull(ComZeroToNull(Value))) {
			return false;
		}
		if(!ComIsMoneyNumber(Value.toString())) {
			return false;
		}
		if(Value >= 10000000) {
			return false;
		}
		return true;
	}
	/**
     * setting button's attribute function <br>
     */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_template");
			ComBtnDisable("btn_openfile");
			ComBtnDisable("btn_check");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_close");
			break;
		case "INIT":
			ComBtnEnable("btn_template");
			ComBtnEnable("btn_openfile");
			ComBtnEnable("btn_check");
			ComBtnDisable("btn_save");
			ComBtnEnable("btn_close");
			break;
		case "READONLY":
			ComBtnEnable("btn_template");
			ComBtnEnable("btn_openfile");
			ComBtnDisable("btn_check");
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_close");
			break;
		}
	}
	/**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
        	case IBSEARCH_ASYNC01: 
        		var orgDestTpCd=formObj.org_dest_tp_cd.value;
		  		if (!sheetObj.IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
		  		for(var i=1; i<=sheetObj.RowCount(); i++) {
		  			sheetObj.SetRowBackColor(i,"#FFFFFF");
		  		}
//	  			var validCnt = validateCheckSheet(sheetObj, formObj);
		  		var check=0;
		 		var color="#FF0000"; //red
	  	  		check += validateSheetData(sheetObjects[0], formObj);
		  		//code db check
//		  		searchCheckDBCodeExist();
	  			formObj.f_cmd.value=SEARCH03;
	  	 		var sParam=FormQueryString(formObj);
	  	 		var sParamSheet1=sheetObjects[0].GetSaveString();
	  			sParam += "&" + sParamSheet1; 
 	  			var sXml=sheetObjects[3].GetSearchData("ESM_PRI_0068GS.do", sParam);
	  	 		sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
	  	  		check += checkDBCodeExist(sheetObjects[3], color);
		  		if(check > 0) {
		  			errFlg=true;
		  			ComBtnDisable("btn_save");
		  			return false;
		  		} else {	
		  			errFlg=false;
		  			sheetObj.SetEditable(0);
		  			ComBtnEnable("btn_save");
		  		}
		  		return true;
		  		break;
	  		case IBSAVE:
	  			if(!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
	  			var rowDupCnt1=sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
	  			if (rowDupCnt1 >= 0) {
	  				ComShowCodeMessage("PRI00303", "Sheet", rowDupCnt1);
//	  				sheetObj.Editable = true;
				    return false;
	  			}
  				sheetObjects[2].RemoveAll();
  				var sXml=ComPriSheet2Xml(sheetObjects[0])
  				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
	        	formObj.f_cmd.value=SEARCH02;
 				var sXml=sheetObjects[2].GetSearchData("ESM_PRI_0068GS.do", FormQueryString(formObj));
				sheetObjects[2].LoadSearchData(sXml,{Append:1 , Sync:1} );
				var rowM = sheetObjects[2].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|"
						+"rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", false,true);
				if (rowM != "") {
					 var rowDup=rowM.split("|");
	  				ComShowCodeMessage("PRI02017", rowDup[0]);
	  				sheetObj.SetEditable(1);
	  				return false;
				}
	  			if(!checkZipCode(sheetObjects[0])) {
  					return false;
  				}
				return true;
	  			break;
    	  }
    	  return true;
    }
