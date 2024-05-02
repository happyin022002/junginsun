/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_1098.js
*@FileTitle : Equalization Port 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/ 
	/* developer job	*/
	// common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
	// Event handler processing by button click event
    document.onclick=processButtonClick;
	// Event handler processing by button name
        function processButtonClick(){
    		         var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try{
        		var srcName=ComGetEvent("name");
                switch(srcName){
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					case "btn_downexcel":						
						if(sheetObject.RowCount() < 1){//no data
						  ComShowCodeMessage("COM132501");
						}else{
//							sheetObject.Down2Excel({ HiddenColumn:-1});
							sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
						}
					break;			
					case "btn_add":
						doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
					break;
					case "btn_del":
						doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
					break;
                }// end switch
        	}catch(e){
        		if(e == "[object Error]"){
        			ComShowMessage(OBJECT_ERROR);
        		}else{
        			ComShowMessage(e);
        		}
        	}
        }
    	/**
    	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
        function loadPage(){
			for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet(sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
	     	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	     	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
      	/**
         * Dynamically load HTML Control event in page. <br>
         * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
         **/
        function initControl(){
        	var formObject=document.form;
        	axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject);
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    	/**
    	 * setting sheet initial values and header
    	 * param : sheetObj, sheetNo
    	 * adding case as numbers of counting sheets
    	 */
        function initSheet(sheetObj,sheetNo){
            var cnt=0;
            switch(sheetNo){
                case 1:      //sheet1 init
                	  with(sheetObj){
                    
                   
                   var HeadTitle1="|Sel.|Seq|User ID|User Email|User Name|Office|LANE|Last F. Port|Notice will be sent at|Notice will be sent at|Hidden User Email|Hodden LANE|Hidden Last F. Port";
                   var headCount=ComCountHeadTitle(HeadTitle1);

                   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                   InitHeaders(headers, info);

                   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"rcvr_eml",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:100, UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E|N", InputCaseSensitive:1 },
                             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"lst_port_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"etd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                             {Type:"Int",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_hrs",         KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"hidden_rcvr_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hidden_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:100, UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hidden_lst_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 } ];
                    
                   InitColumns(cols);

                   SetEditable(1);
                      SetSelectionMode(smSelectionList);
                   //no support[implemented common] 						SelectHighLight=false;
                   //conversion of function[check again] 						InitDataValid(0, "slan_cd", vtEngUpOther ,"1234567890");
                   //conversion of function[check again] 						InitDataValid(0, "lst_port_cd", vtEngUpOnly);
//                      SetSheetHeight(400);
                      ComResizeSheet(sheetObj);
                   }


                    break;
            }
        }
        /**
		 * IBSheet setting data in the column of the combo
		 */
		function setIBMultiCombo(sheetObj, sXml, title){
			var arrData=ComBkgXml2SheetMultiComboString(sXml, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
			//sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
			sheetObj.SetColProperty("slan_cd_disp", {ComboText:arrData[1], ComboCode:arrData[0]} );
			sheetObj.InitComboNoMatchText(true, " ");
//conversion of function[check again] 			sheetObj.InitDataValid(0, "loc_cd", vtEngUpOnly);
//conversion of function[check again] 			sheetObj.InitDataValid(0, "eqlz_port_cd", vtEngUpOnly);
		}
        /**
		 * IBSheet setting data in the column of the combo
		 */
		function ComBkgXml2SheetMultiComboString(xmlStr, codeCol, textCol){
			var rtnArr=new Array();
			if(xmlStr == null || xmlStr == ""){
				return;
			}
			if(codeCol == null || codeCol == "" || textCol == null || textCol == ""){
				return;
			}
			try{
				var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
				xmlDoc.loadXML(xmlStr);
				var xmlRoot=xmlDoc.documentElement;
				if(xmlRoot == null){
					return;
				}
				var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
				if(dataNode == null || dataNode.attributes.length < 3){
					return;
				}
				var col=dataNode.getAttribute("COLORDER");
				var colArr=col.split("|");
				var sep=dataNode.getAttribute("COLSEPARATOR");
				var total=dataNode.getAttribute("TOTAL");
				var dataChildNodes=dataNode.childNodes;
				if(dataChildNodes == null){
					return;
				}
				var colListIdx=Array();
				var arrText=textCol.split("|");
				for(var i=0; i < colArr.length; i++){
					if(colArr[i] == codeCol){
						colListIdx[0]=i;
					}
					for(var j=0; j < arrText.length; j++){
						if(colArr[i] == arrText[j]){
							colListIdx[j+1]=i;
						}
					}
				}
				var sCode="";
				var sText="";
				for(var i=0; i < dataChildNodes.length; i++){
					if(dataChildNodes[i].nodeType != 1){
						continue;
					}
					var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
					sCode += arrData[colListIdx[0]];
					for(var j=1; j < colListIdx.length; j++){
						sText += arrData[colListIdx[j]];
						if(j < colListIdx.length - 1){
							sText += "\t";
						}
					}
					if(i != dataChildNodes.length - 1){
						sCode += "|";
						sText += "|";
					}
				}
				rtnArr.push(sCode);
				rtnArr.push(sText);
			}catch(err){
				ComFuncErrMsg(err.message);
			}
			return rtnArr;
		}
		// handling of Sheet process
        function doActionIBSheet(sheetObj,formObj,sAction, Row){
            sheetObj.ShowDebugMsg(false);
            switch(sAction){
	            case IBCLEAR: // on load
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
					if(arrXml.length > 0) 
						//setIBMultiCombo(sheetObj,  arrXml[0], "vsl_slan_cd" );
					break;	
	           case IBSEARCH:      // retrieve
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value=SEARCH;
		        	  sheetObj.SetWaitImageVisible(0);
		        	  ComOpenWait(true);
		        	  sheetObj.DoSearch("ESM_BKG_1098GS.do", FormQueryString(formObj )+ "&" + ComGetPrefixParam(""));
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case SEARCH01:      //retrieve
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value=SEARCH01;
		        	  sheetObj.SetWaitImageVisible(0);
		        	  ComOpenWait(true);
		        	  var sXml=sheetObj.GetSaveData("ESM_BKG_1098GS.do", FormQueryString(formObj));
		        	  var valResult=ComGetEtcData(sXml, "port_cd");
		        	  if(valResult == '' || valResult == 'INVALID'){
						  ComShowCodeMessage('BKG00068', 'Last F. Port');
						  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "lst_port_cd",'',0);
					  }
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case SEARCH02:      //retrieve
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value=SEARCH02;
		        	  sheetObj.SetWaitImageVisible(0);
		        	  ComOpenWait(true);
 		        	  var sXml=sheetObj.GetSaveData("ESM_BKG_1098GS.do", FormQueryString(formObj));
		        	  var valResult=ComGetEtcData(sXml, "slan_cd");
		        	  if(valResult == '' || valResult == 'INVALID'){
						  ComShowCodeMessage('BKG00068', 'LANE');
						  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "slan_cd",'',0);
					  }
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case SEARCH03:      //retrieve
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value=SEARCH03;
		        	  sheetObj.SetWaitImageVisible(0);
		        	  ComOpenWait(true);
 		        	  var sXml=sheetObj.GetSaveData("ESM_BKG_1098GS.do", FormQueryString(formObj));
		        	  var rcvr_eml=ComGetEtcData(sXml, "rcvr_eml");
		        	  var usr_nm=ComGetEtcData(sXml, "usr_nm");
		        	  var ofc_cd=ComGetEtcData(sXml, "ofc_cd");
		        	  //if(ofc_cd == '' || valResult == 'INVALID')  ComShowCodeMessage('BKG00068', 'User Info');
		        	  sheetObj.SetCellValue(Row, "rcvr_eml",rcvr_eml,0);
		        	  sheetObj.SetCellValue(Row, "usr_nm",usr_nm,0);
		        	  sheetObj.SetCellValue(Row, "ofc_cd",ofc_cd,0);
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case IBSAVE:        //save
					formObj.f_cmd.value=MULTI;
					var saveParam=ComGetSaveString(sheetObjects[0]);
					//alert(sheetObj.GetSaveString() + " : " + saveParam + " : " + sheetObjects[0].CellValue(2,3));
					if(sheetObj.IsDataModified()== false || saveParam == ""){
						ComShowCodeMessage('BKG00260');
						return;
					}
					//check : rcvr_eml, slan_cd, lst_port_cd
					var dup=new Array();
					for(var i=1; i <= sheetObjects[0].RowCount(); i++){
						dup[i]=sheetObjects[0].GetCellValue(i, "rcvr_eml")+sheetObjects[0].GetCellValue(i, "slan_cd")+sheetObjects[0].GetCellValue(i, "lst_port_cd");
					}
					for(var i=1; i<=dup.length; i++){
						for(var j=1; j<=dup.length; j++){
							if((i < j) &&(i != j) &&(dup[i] == dup[j])){
								ComShowCodeMessage("BKG01126");
								return;
							}
						}
					}
					saveParam += "&" + FormQueryString(formObj);
					var SaveXml=sheetObj.GetSaveData("ESM_BKG_1098GS.do", saveParam);
					sheetObjects[0].LoadSaveData(SaveXml);
					break;
				case IBINSERT:      // insert
	 				var row = sheetObj.DataInsert(-1);
	 				sheetObj.SetCellValue(row, "etd", "ETD +");
	 				//sheetObj.SetCellValue(sheetObj.RowCount(), "etd", "ETD +");
	 				//sheetObj.SetCellValue(sheetObj.RowCount(), "etd", 0);
					break;
				case IBDELETE:      // delete
					//sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";
					//ComRowHideDelete(sheetObj, "del_chk");
					if(!validateForm(sheetObj, formObj, sAction))	return;
					if(ComShowCodeConfirm('BKG03037')){
						ComRowHideDelete(sheetObj, "del_chk");
	                	sheetObj.CheckAll("del_chk",0,1);
					}
					break;	
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch(sAction){
	            case IBSEARCH: // retrieve
	         		if(!ComChkValid(formObj)) return false;
	         		break;
	            case IBSAVE: // save
         		//if(!ComChkValid(formObj)) return false;
         		break;
				case IBDELETE : // Row Delete
					var sheet1RowCnt=sheetObj.RowCount();
				    var selCnt=0;
					if(sheet1RowCnt == 0){
						ComShowCodeMessage('BKG00389');
						return false;
					}
					for(var i=1; i<=sheet1RowCnt; i++){
						if(sheetObj.GetCellValue(i, "del_chk") == 1){
							selCnt++;
						}
						if(selCnt > 0) break;
					}
					if(selCnt == 0){
						ComShowCodeMessage('BKG00442');
						return false;
					}
				break;
            }
            return true;
        }
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		with(sheetObj){
    			  for(i=1; i<= sheetObj.LastRow(); i++){
					  SetCellEditable(i,"loc_cd",0);
					  SetCellEditable(i,"eqlz_port_cd",0);
					  SetCellEditable(i,"slan_cd_disp",0);
    			  }
    		}
    	}
        /**
         * handling onchange event
         */
        function sheet1_OnChange(sheetObj, Row, Col, Value){
        	var formObj=document.form;
        	if(sheetObj.ColSaveName(Col) == "lst_port_cd"){
        		formObj.f_cmd.value=SEARCH01;
        		formObj.strLocCd.value=sheetObj.GetCellValue(Row, Col);
        		if(formObj.strLocCd.value != ""){
        			doActionIBSheet(sheetObj, formObj, SEARCH01);
        		}
        	}
        	if(sheetObj.ColSaveName(Col) == "slan_cd"){
        		formObj.f_cmd.value=SEARCH02;
        		formObj.strSlanCd.value=sheetObj.GetCellValue(Row, Col);
        		if(formObj.strSlanCd.value != ""){
        			doActionIBSheet(sheetObj, formObj, SEARCH02);
        		}
        	}
        	if(sheetObj.ColSaveName(Col) == "eml_snd_usr_id"){
        		formObj.f_cmd.value=SEARCH03;
        		formObj.strUsrId.value=sheetObj.GetCellValue(Row, Col);
        		if(formObj.strUsrId.value != ""){
        			//alert(formObj.strUsrId.value);
        			doActionIBSheet(sheetObj, formObj, SEARCH03, Row);
        		}
        	}    
        	if(sheetObj.ColSaveName(Col) == "rcvr_eml"){
        		sheetObj.SetCellValue(Row, 'eml_snd_usr_id','',0);
        		sheetObj.SetCellValue(Row, 'usr_nm','',0);
        		sheetObj.SetCellValue(Row, 'ofc_cd','',0);
        	}  
        	if(sheetObj.ColSaveName(Col) == "eml_snd_hrs"){
        		if(sheetObj.GetCellValue(Row, "eml_snd_hrs") > 48){
        			sheetObj.SetCellValue(Row, 'eml_snd_hrs','48',0);
        		}
        	}  
        }
