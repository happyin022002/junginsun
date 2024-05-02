/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1028.jsp
*@FileTitle  : Agreement Matching
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* developer job	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 
     */ 
	function processButtonClick(){
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
		var sheetObject1=sheetObjects[0];
	    /*******************************************************/
	    var formObject=document.form;
	    try {
	    	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
	 			case "btn_Add":
	 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
	 					break;
	 			case "btn_Delete":
	 					ComRowHideDelete(sheetObject1,"del_chk");
	 					break;
	 			case "btn_Retrieve":
	 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	 					break;
	 			case "btn_Save":
	 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
	 * @param  {object} sheet_obj	
     * @return 
     * @author 
     * @version 
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 * @param  
     * @return 
     * @author 
     * @version 
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        //
	        ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	function resizeSheet(){
		ComResizeSheet( sheetObjects[0] );
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {int} sheetNo		
	 * @return 
	 * @author 
	 * @version 
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
	    switch(sheetNo) {
	    	case 1: // sheet1 init
	    	    with(sheetObj){
	          var HeadTitle="||||Reference No.|Agreement No.|Lessor Code|Lessor Name";

	          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);

	          var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq" },
	                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, DefaultValue:1},
	                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"inv_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	                 {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	           
	          	InitColumns(cols);

	          	SetEditable(1);
                SetShowButtonImage(2);
//                SetSheetHeight(480);
                
                SetColProperty(0, "agmt_no", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                resizeSheet( );
	          //conversion of function[check again]CLT 	 				InitDataValid(0, "inv_ref_no", vtEngUpOther, "1234567890-;:.,~!@#$%^&*()_+{}|[]");
	          //conversion of function[check again]CLT 	 				InitDataValid(0, "agmt_no", vtEngUpOther, "1234567890");
	          }


	            break;
	    }
	}
	/**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return 
     * @author 
     * @version 
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	    	case IBSEARCH:      //retrieve
	    		formObj.f_cmd.value=SEARCH;
	    	    formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
	    	    sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);	
 	            sheetObj.DoSearch("EES_CGM_1028GS.do",FormQueryString(formObj) );
				ComOpenWait(false);	
	            break;
	    	case IBSAVE:        //saving
	    		var actionFlag=true; 
	    		var stsRows=sheetObj.FindStatusRow("I|U");
	    		var arrStsRows=stsRows.split(";");
	    		for (i=0; i < arrStsRows.length; i++) {
	    			var row=arrStsRows[i];
	 				var invRefNo=sheetObj.GetCellValue(row, "inv_ref_no");
	 				var agmtCode=sheetObj.GetCellValue(row, "agmt_no"); 
	 				if (invRefNo == '' || agmtCode == ''){
	 					actionFlag=false;
	 					if (invRefNo == '') {
	 						ComShowCodeMessage('CGM10004','Refernce No.');
//	 						sheetObj.focus();
	 						sheetObj.SelectCell(row, "inv_ref_no", true);
	 					} else if (agmtCode == '') {
	 						ComShowCodeMessage('CGM20007', agmtCode);
//	 						sheetObj.focus();
	 						sheetObj.SelectCell(row, "agmt_no", true);
	 					}
	 					break;
	 				}
	 			}
	 			if (actionFlag){	
	 				var delRows=sheetObj.FindStatusRow("D");
		    		var arrDelRows=delRows.split(";");
	 				var chkRows=sheetObj.FindCheckedRow("del_chk");
	 				var arrChkRows=chkRows.split("|");
	 				if( (arrChkRows.length >= 1 && ComIsEmpty(arrChkRows[0])) 
	 						&& (arrDelRows.length >= 1 && ComIsEmpty(arrDelRows[0]))){
	 					ComShowCodeMessage('CGM10008');	 					
	 					return false;
	 				} else {
	 					//sheetObj.SetWaitImageVisible(0);
	 					ComOpenWait(true);	
			 			formObj.f_cmd.value=MULTI;
			 			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
			 			//var sParam=sheetObjects[0].GetSaveString();
			 			
		 				//sParam=sParam + "&" + FormQueryString(formObj);
		 				sheetObjects[0].DoSave("EES_CGM_1028GS.do", FormQueryString(formObj));
						
		 				return true;
		 				//ComOpenWait(false);	
	 				}
	 			}
	            break;
	    	case IBINSERT:      // inserting
	    		sheetObj.DataInsert(-1);
	            break;
	    }
	}
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	    
	}
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		switch(sheetObj.ColSaveName(Col)){
			case "agmt_no":
				ComOpenPopup('/opuscntr/EES_CGM_1117.do' , 820, 420, 'setPopupAgreementNo','1,0,1,1,1,1,1,1,1', true, false, Row, Col, 0);
				break;
	 	}
	}
	function setPopupAgreementNo(aryPopupData, row, col, sheetIdx){
		var sheetObject=sheetObjects[0];
		sheetObject.SetCellValue(row, "agmt_no",aryPopupData[0][2], 1);
		sheetObject.SetCellValue(row, "vndr_seq",aryPopupData[0][5], 0);
		sheetObject.SetCellValue(row, "vndr_lgl_eng_nm",aryPopupData[0][6], 0);
	}
	function sheet1_OnChange(sheetObj, Row, Col){
		var sheetObj=sheetObjects[0];
	 	var formObj=document.form;
	 	var agmtNoCol=sheetObj.SaveNameCol("agmt_no");
	 	var invRefNoCol=sheetObj.SaveNameCol("inv_ref_no");
	 	// Column == NIS Agreement No 
	 	if (Col == agmtNoCol && Row !=0) {
	 		var cellValue=sheetObj.GetCellValue(Row, Col); 
	 		if (cellValue != ''){
	 			var agmtSeq="000000" + cellValue.substring(3);
	 			cellValue=cellValue.substring(0, 3) + agmtSeq.substring(agmtSeq.length - 6);
	 			if(cellValue.length != 9 || !ComIsNumber(cellValue.substring(3))){
		 			// check message out
	 				ComShowCodeMessage('CGM10004','Agreement No.');
	 				// Setting Cell value to Null
		 			sheetObj.SetCellValue(Row, "agmt_no","");
		 			sheetObj.SetCellValue(Row, "vndr_seq","");
		 			sheetObj.SetCellValue(Row, "vndr_lgl_eng_nm","");
		 			// focus to grid
//		 			sheetObj.focus();
	 				sheetObj.SelectCell(Row, "agmt_no", true);
	 			} else {
	 				// Form parameter setting
	 				formObj.agmt_ofc_cty_cd.value=cellValue.substring(0,3);
	 				formObj.agmt_seq.value=cellValue.substring(3);
	 				// Agreement No  retrieve
	 				formObj.f_cmd.value=SEARCH01;
	 				formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
 			        var sXml=sheetObj.GetSearchData("EES_CGM_1028GS.do", FormQueryString(formObj), '', true);
			        var amgtCnt=ComGetEtcData(sXml,"AgmtCnt");
			        var vndrSeq=ComGetEtcData(sXml,"vndrSeq");
			        var vndrLglEngNm=ComGetEtcData(sXml,"vndrLglEngNm");
	 				//  Agreement No not existing
			        if (amgtCnt == 0){
			        	// check message out
			        	ComShowCodeMessage('CGM10004','Agreement No.');
			        	// Setting Cell value to Null
			 			sheetObj.SetCellValue(Row, "agmt_no","");
			 			sheetObj.SetCellValue(Row, "vndr_seq","");
			 			sheetObj.SetCellValue(Row, "vndr_lgl_eng_nm","");
			 			// focus to grid
//			 			sheetObj.focus();
			 			sheetObj.SelectCell(Row, "agmt_no", true);
	 				} else {
	 					sheetObj.SetCellValue(Row, "agmt_no",cellValue, 0);
	 					sheetObj.SetCellValue(Row, "vndr_seq",vndrSeq, 0);
	 					sheetObj.SetCellValue(Row, "vndr_lgl_eng_nm",vndrLglEngNm, 0);
	 					sheetObj.SetCellValue(Row, "del_chk", 1, 0);
	 				}
	 			}
	 		} else {
	 			sheetObj.SetCellValue(Row, "agmt_no", '');
	 			sheetObj.SetCellValue(Row, "vndr_seq",'');
	 			sheetObj.SetCellValue(Row, "vndr_lgl_eng_nm",'');
	 		}
	 	}
	 	// Column == Reference  No 
	 	if (Col == invRefNoCol && Row !=0) {
	 		var nCellValue=sheetObj.GetCellValue(Row, Col);
	 		// ObjId.FindText(Col,SearchText,[StartRow],[FullMatch], [CaseSensitive])
	 		var Row2=sheetObj.FindText(Col, nCellValue);
	 		
	 		if(Row2 != Row && Row2 > 0){
//	 			Row2=sheetObj.FindText(Col, nCellValue, 0, Row2+1); // Row2+1 의미를 알 수 없음
//	 	        if (Row2 > 0) {
 	        	ComShowCodeMessage('CGM10017','Reference No.');
 				// Setting Cell value to Null
 				sheetObj.SetCellValue(Row, Col, "", 0);
 				
 				// focus to grid
// 				sheetObj.focus();
 				sheetObj.SelectCell(Row, Col, true);
//	 			}
	 		}
	 	}
	}
	
	function sheet1_OnSaveEnd(Code, Msg, StCode, StMsg) {
//		alert("Code : " + Codes + 
//				"\nMsg : " + Msg + 
//				"\nStCode : " + StCode + 
//				"\nStMsg : " + StMsg);
		
		if(Msg == 0) {
			ComShowCodeMessage("CGM00003"); 
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		
		ComOpenWait(false);
	}
	/* developer job end */

