/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_0253.js
*@FileTitle : Equalization Port 
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */

 // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
    		         var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					case "btn_downexcel":
						if(sheetObject.RowCount() < 1){
							ComShowCodeMessage("COM132501");
						}else{
							sheetObject.Down2Excel({ HiddenColumn:-1});
						}
					break;			
					case "btn_add":
						doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
					break;
					case "btn_del":
						doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
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
				ComConfigSheet(sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
    	}
        /**
         * HTML Control on the page  loaded dynamically  the event. <br>
         * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
         * 
         * @param {ibsheet}
         *            sheetObj IBSheet Object
         * @param {int}
         *            sheetNo sheetObjects array  sequence number
         */
        function initControl() {
        	var formObject=document.form;
        	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        }
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){                    
					
						var HeadTitle1="|Del|Port|Equalization Port|Lane|Dir|Lane|User ID|Office|Update Date";
						
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
						{Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"eqlz_port_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
						{Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd_disp",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_office_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						
						InitColumns(cols);
						
						SetEditable(1);
						SetSelectionMode(smSelectionList);
						InitComboNoMatchText(true,"");
						SetSheetHeight(400);
					}

                    break;
            }
        }
        /**
		 * IBSheet combo data  setting <br>
		 * <b>Example :</b>
		 * <pre>
		 * setIBMultiCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
		 * </pre>
		 * 
		 * @param {string} sheetObj mandatory
		 * @param {string} sXml mandatory, Combo data
		 * @param {string} title mandatory, Combo field name(IBSheet SaveName).
		 */
		function setIBMultiCombo(sheetObj, sXml, title){
			var arrData = ComBkgXml2SheetMultiComboString(sXml, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
			//sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
			sheetObj.SetColProperty("slan_cd_disp", {ComboText:arrData[1], ComboCode:arrData[0]} );
			sheetObj.InitComboNoMatchText(true, " ");
		}
		function ComBkgXml2SheetMultiComboString(xmlStr, codeCol, textCol) {
			var rtnArr=new Array();
			if (xmlStr == null || xmlStr == "") {
				return;
			}
			if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
				return;
			}
			try {
				var xmlDoc = ComGetXmlDoc(xmlStr);
		            if (xmlDoc == null) return;
		        var xmlRoot = xmlDoc.documentElement;
				var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
				if (dataNode == null || dataNode.attributes.length < 3) {
					return;
				}
				var col=dataNode.getAttribute("COLORDER");
				var colArr=col.split("|");
				var sep=dataNode.getAttribute("COLSEPARATOR");
				var total=dataNode.getAttribute("TOTAL");
				var dataChildNodes=dataNode.childNodes;
				if (dataChildNodes == null) {
					return;
				}
				var colListIdx=Array();
				var arrText=textCol.split("|");
				for (var i=0; i < colArr.length; i++) {
					if (colArr[i] == codeCol) {
						colListIdx[0]=i;
					}
					for (var j=0; j < arrText.length; j++) {
						if (colArr[i] == arrText[j]) {
							colListIdx[j+1]=i;
						}
					}
				}
				var sCode="";
				var sText="";
				for (var i=0; i < dataChildNodes.length; i++) {
					if (dataChildNodes[i].nodeType != 1) {
						continue;
					}
					var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
					sCode += arrData[colListIdx[0]];
					for (var j=1; j < colListIdx.length; j++) {
						sText += arrData[colListIdx[j]];
						if (j < colListIdx.length - 1) {
							sText += "\t";
						}
					}
					if (i != dataChildNodes.length - 1) {
						sCode += "|";
						sText += "|";
					}
				}
				rtnArr.push(sCode);
				rtnArr.push(sText);
			} catch (err) {
				ComFuncErrMsg(err.message);
			}
			return rtnArr;
		}
      // Sheet handling process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
	            case IBCLEAR: 
					formObj.f_cmd.value=SEARCHLIST10;
					var param=FormQueryString(formObj);
					param=param + "&comboCd=MDM0001";
 					var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
					var arrXml=sXml.split("|$$|");
					/*
					vsl_slan_cd 
					vsl_slan_nm
					skd_dir_cd
					*/
					if (arrXml.length > 0) 
						setIBMultiCombo(sheetObj,  arrXml[0], "vsl_slan_cd" );
					break;	
	           case IBSEARCH:      //Retrieve
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value=SEARCH;
		        	  sheetObj.SetWaitImageVisible(0);
		        	  ComOpenWait(true);
 		        	  sheetObj.DoSearch("ESM_BKG_0253GS.do", FormQueryString(formObj )+ "&" + ComGetPrefixParam(""));
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case IBSAVE:        //Save
					if(validateForm(sheetObj,formObj,sAction)){
						var rowM=sheetObjects[0].ColValueDup("loc_cd|eqlz_port_cd|skd_dir_cd|slan_cd");
						if (rowM >= 0) {
							 var msg=ComGetMsg("BKG06018");
							 msg += "\n----------------------------------";
							 msg += "\nPort : " + sheetObjects[0].GetCellValue(rowM, "loc_cd");
							 msg += "\nEqualization Port : " + sheetObjects[0].GetCellValue(rowM, "eqlz_port_cd");
							 msg += "\nLane : " + sheetObjects[0].GetCellValue(rowM, "skd_dir_cd");
							 msg += "\nDir : " + sheetObjects[0].GetCellValue(rowM, "slan_cd");
							 msg += "\n----------------------------------";
							 alert(msg);
							 return false;
					    }	 
						sheetObj.SetWaitImageVisible(0);
			        	ComOpenWait(true);
						formObj.f_cmd.value=MULTI;
						sheetObj.DoSave("ESM_BKG_0253GS.do", FormQueryString(formObj));
//						if (sheetObj.GetEtcData("TRANS_RESULT_KEY") != 'F') {
//				        	doActionIBSheet(sheetObj,formObj,IBSEARCH);
//			        	}
						ComOpenWait(false);
					}
					break;
				case IBINSERT:   
	 				sheetObj.DataInsert(-1);
	 				sheetObj.SetCellValue(sheetObj.RowCount(), "slan_cd_disp","*",0);
	 				sheetObj.SetCellValue(sheetObj.RowCount(), "skd_dir_cd","*",0);
	 				sheetObj.SetCellValue(sheetObj.RowCount(), "slan_cd","*",0);
	 				sheetObj.SelectCell(sheetObj.RowCount(), "loc_cd");
					break;
				case IBDELETE:      
					if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "del_chk")==""){
						ComShowCodeMessage("COM12189");
						return false;
					}
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ibflag","D",0);
					ComRowHideDelete(sheetObj, "del_chk");
					break;	
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch(sAction) {
	            case IBSAVE: 
	         		if (!ComChkValid(formObj)) return false;
	         		break;
            }
            return true;
        }
        
//        function sheet1_OnEditValidation(sheetObj, Row, Col, Value) {
//        	var locCol =  sheetObj.SaveNameCol("loc_cd");
//        	var eqlzPortCol =  sheetObj.SaveNameCol("eqlz_port_cd");
//        	if(Value == "") return;
//        	if(Col == locCol) {
//	        	if(Value ==  sheetObj.GetCellValue(Row, "eqlz_port_cd")){
//	        		ComShowCodeMessage("BKG43061");
//	        		sheetObj.SetCellValue(Row, "loc_cd", "");
//	        		sheetObj.SetSelectCell(Row, Col);
//	        	}
//        	}
//        	else if(Col == eqlzPortCol) {
//        		if(Value == sheetObj.GetCellValue(Row, "loc_cd")){
//        			ComShowCodeMessage("BKG43061");
//        			sheetObj.SetCellValue(Row, "eqlz_port_cd", "");
//        			sheetObj.SetSelectCell(Row, Col);
//        		}
//        	}
//        }

        
        function sheet1_OnChange(sheetObj, Row, Col, Value){
        	with (sheetObj) {
	            var iCol = SaveNameCol("slan_cd_disp");
	            var locCol = SaveNameCol("loc_cd");
	            var eqlzPortCol = SaveNameCol("eqlz_port_cd");
	            
	        	if (Col == iCol) {
	        		var sText=GetComboInfo(Row,Col, "Text");
	        		var idx=GetComboInfo(Row,Col, "SelectedIndex");
					var arrText=sText.split("|");
					var schText=arrText[idx];	
					if (schText == undefined) return;
					var skd_dir_cd=schText.split("\t");
					SetCellValue(Row,"skd_dir_cd",skd_dir_cd[1],0);
					SetCellValue(Row,"slan_cd",skd_dir_cd[0],0);
	        	}
	        	else if(Col == locCol) {
		        	if(Value ==  sheetObj.GetCellValue(Row, "eqlz_port_cd")){
		        		ComShowCodeMessage("BKG43061");
		        		sheetObj.SetCellValue(Row, "loc_cd", "");
		        		sheetObj.SetSelectCell(Row, Col);
		        	}
	        	}
	        	else if(Col == eqlzPortCol) {
	        		if(Value == sheetObj.GetCellValue(Row, "loc_cd")){
	        			ComShowCodeMessage("BKG43061");
	        			sheetObj.SetCellValue(Row, "eqlz_port_cd", "");
	        			sheetObj.SetSelectCell(Row, Col);
	        		}
	        	}
        	}
         }
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		with(sheetObj){
    			  for (i=1; i<= LastRow(); i++) {
					  SetCellEditable(i,"loc_cd",0);
					  SetCellEditable(i,"eqlz_port_cd",0);
					  SetCellEditable(i,"slan_cd_disp",0);
    			  }
    		}
    	}
        function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	 		var formObj=document.form;
	 		if (ErrMsg == "") {
	 			doActionIBSheet(sheetObj,formObj,IBSEARCH);
	 		}
		}