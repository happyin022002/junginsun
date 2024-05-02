/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0146.js
*@FileTitle  : Creation, Inquiry & Update Vessel for BSA
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================
*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0146 : ESM_COA_0146 Business script for the UI
 */
	// Grobla Variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet_height=20; // sheet height
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Contents : Event handler processing by button name <br>
	 * <b>Example : </b>
	 * <pre>
	 *    processButtonClick()
	 * </pre>
	 * @see #Link
	 */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		try {
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_Downexcel":
					if(sheetObject.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	        	    }
					break;
				case "btng_Rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_Close":
					//SJH.20150205.ADD
					if (!opener) opener=parent; //이 코드 추가할것
					opener.retrieve();
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
	 * Contents :  Sheet default setting and Initialize <br>
	 *          implementing onLoad event handler in body tag<br>
   * adding first-served functions after loading screen.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 
	 * @see #Link
	 */
	function loadPage(VslSubTrade) {
		//doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1,VslSubTrade);
			//Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
		}
	     
		initRetrieve();
	}
	/**
	 * Contents :  Initialize sheet and define header info <br>
	 *          adding case as numbers of counting sheets<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj,sheetNo,tpszValue)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (A sequence No that is assigned in the sheet object tag ID)
	 * @param {String}	VslSubTrade  - VslSubTrade
	 * @param {String}	ownerShip  - ownerShip
	 * @param {String}	vslOpr  - vslOpr
	 * @see #Link
	 */
	function initSheet(sheetObj, sheetNo, VslSubTrade) {
		var cnt=0;
		//var colNo=0;
		var subColNo=0;
		var vslText=VslSubTrade;
		var aryCD=vslText.split("|");
		if(vslText != "") subColNo=aryCD.length;
		switch(sheetNo) {
			case 1:      //sheet1 init
			    with(sheetObj){
			        //colNo=subColNo + 22;
			        var HeadTitle0="Del.|STS|SEQ|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|VVD|VSL Apply Period|VSL Apply Period|VSL\nClass|Designed\nCapa.|Standard \nLoadable Capa.|CRR\nCode|bsa_vsl_flg|vsl_rgst_cnt_cd";
			      	for(j=0; j<subColNo; j++)
			      		HeadTitle0=HeadTitle0 + "|Trade Loadable Capa. By Trade";
			      	var HeadTitle1="Del.|STS|SEQ|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|VVD|From|To|VSL\nClass|Designed\nCapa.|Standard \nLoadable Capa.|CRR\nCode|bsa_vsl_flg|vsl_rgst_cnt_cd|" + vslText;
	
			      	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
	
			      	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      	var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
			      	InitHeaders(headers, info);
	
			      	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_check" },
			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			             {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vsl_oshp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_aply_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_aply_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			          
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"vsl_clss_capa",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"vsl_dznd_capa",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stnd_ldb_capa",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"crr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bsa_vsl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vsl_rgst_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			            for(j=0; j<subColNo; j++){
		            		cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:aryCD[j],           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			            }
			            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"trd_chk_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vsl_prc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vsl_prc_rto",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vsl_retn_fm_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vsl_retn_to_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			 
			      InitColumns(cols);
			      SetColProperty(0 ,"vsl_cd"     , {AcceptKeys:"E" , InputCaseSensitive:1});
			      SetColProperty(0 ,"vsl_tp_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetColProperty(0 ,"vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetEditable(1);//Editkind[optional,Defaultfalse]
//			      SetSheetHeight(380);
				  resizeSheet();
		      }
		    break;
		}
	}
	function initRetrieve(){
		var formObject=document.form;      
		var sheetObject=sheetObjects[0];             
		doActionIBSheet(sheetObject,formObject,IBSEARCH);            
	} 
	/**
	 * Contents : Registering IBSheet Object as list <br>
	 *         adding process for list in case of needing batch processing with other items<br>
	 *         defining list on the top of source<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setSheetObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #Link
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Contents : It's displayed of the ETD_Date of the first loading port when the VVD is changed<br>
	 * 		(From ESM_COA_5141.jsp)<br>
	 *      Assign the returned FIRST LOADING PORT ETD DT or display the error message
	 *          
	 * <br><b>Example : </b>
	 * <pre>
	 *     parent.getEdtDate("<%=rtnValue%>");
	 * </pre>
	 * @param {String}	result
	 * @see #Link
	 */
	function getEdtDate(selRow,result) {
		var sheetObject1=sheetObjects[0];
		var tmpRow=0;
		if(result == null || result == "" || result == "null"){
			ComShowMessage(ComGetMsg('COA10027',sheetObject1.GetCellValue(selRow,"vvd_cd")));
			sheetObject1.SelectCell(selRow, "vvd_cd",true);
		} else {
			sheetObject1.SetCellValue(selRow,"vsl_aply_fm_dt",result,0);
		}
	}
	/**
	 * Contents : Event after inquiry <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObj, errMsg)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {String}	errMsg  - Message after inquiry
	 * @see #Link
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		//sheetObj.RowEditable(2) = false; // Not to be edited firstly
	}
	/**
	 * Contents : The event is called when the cell value is changed <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnChange(sheetObj, Row, Col, Val)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {Long}	Row  - Row Index
	 * @param {Long}	Col  - Column Index
	 * @param {String}	Val  - Changed value
	 * @see #Link
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj=document.form;
		with(sheetObj) {
			// If you change the from_date  it is changed as to_date of the previous data
			if (ColSaveName(Col) == "vsl_aply_fm_dt") {
				if (Row > 2) {
					SetCellValue(Row-1,"vsl_aply_to_dt",ComGetDateAdd(Value, "D", -1, ""),0);
				}
			}
			// It's displayed of the ETD_Date of the first loading port when the VVD is changed
			if (ColSaveName(Col) == "vvd_cd") {
				var param="f_cmd="+SEARCH01;
         		param=param + "&f_vsl_cd="+Value;

         		var sXml=sheetObj.GetSearchData("ESM_COA_0146GS.do", param);
				var arrXml=sXml.split("|$$|");
				getEdtDate(Row,ComCoaGetEtcData(arrXml[0], "rtnValue"));
			}
			if (sheetObj.ColSaveName(Col) == "stnd_ldb_capa") {
				// Initialize the trade value as the stnd_ldb_capa's value in case of changing the stnd_ldb_capa,  If the company is not the OPR2 only.
				if(sheetObj.GetCellValue(Row, "vop_cd") != ConstantMgr.getCompanyCode()){
					var num=0;
					var header=document.form.f_header.value;
					var subTrade=header.split("|");
					if(header != "") num=subTrade.length;
					for(j=0;j<num; j++){
						sheetObj.SetCellValue(Row, subTrade[j],sheetObj.GetCellValue(Row, "stnd_ldb_capa"));
					}
				}
			}
			if ( sheetObj.ColSaveName(Col) == "del_check"){
				if(Row == 2){
				}
			}
			//-----------------------------------------------
	        // Inquiry again the combolist in case of changing the OPR(Operation)
	        //-----------------------------------------------
	        if(sheetObj.ColSaveName(Col) == "vop_cd"){
	        	if(Value == "") {
	        		sheetObj.SetCellValue(Row, "vsl_oshp_cd","");
	        		sheetObj.CellComboItem(Row,"vsl_oshp_cd", {ComboText:"|", ComboCode:"|"} );
	        	} else {
	        		var param="";
	        		param=param+"&f_cmd="+SEARCH02;
	        		param=param+"&f_vop_cd="+sheetObj.GetCellValue(Row,Col);

	        		var sXml=sheetObj.GetSearchData("ESM_COA_0146GS.do", param);
	        		var arrXml=sXml.split("|$$|");
	        		if (arrXml.length > 0)
	        			ComCoaSetIBCombo(sheetObj, arrXml[0], "vsl_oshp_cd", true,0,Row);
	        	}
	        }
		}
	}
	/**
	 * Contents : Handling process about the sheet object <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - Kinds of processes 
	 * @see #Link
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);// Prohibit button click when a business transaction is processing
		switch(sAction) {
			case IBCLEAR:          //Inquiry
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;

				var sXml=sheetObj.GetSearchData("ESM_COA_0146GS2.do", coaFormQueryString(formObj))
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "vop_cd", true, 0);
				ComOpenWait(false);
				break;
			case IBSEARCH:      //Inquiry
				if(!validateForm(sheetObj,formObj,sAction)) return false;
	   			if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
	   				//validation check
	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
	   					return false;
	   				}
				}
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCHLIST01;

				var xml=sheetObj.GetSearchData("ESM_COA_0146GS.do", coaFormQueryString(formObj))
				//formObj.header.value   = searchEtcData("header", xml);
				//formObj.f_header.value=ComGetEtcData(xml, "header");
				// Initialize the sheet to change header information
				//--------------------------------------------------
				// Initializing and Setting the sheet due to change the header
//				sheetObj.RenderSheet(0);
//				sheetObj.SetVisible(0);
//				sheetObj.RemoveAll();

				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				//initSheet(sheetObjects[0], 1, formObj.f_header.value);
						
				//loadPage(formObj.f_header.value);
//				sheetObj.SetVisible(1);
//				sheetObj.RenderSheet(1);
				//--------------------------------------------------
				sheetObj.LoadSearchData(xml,{Sync:1} );
				sheetObj.RemoveEtcData();
				ComOpenWait(false);
				break;
			case IBSAVE:        //Save
				if(!chkValidCreate(sheetObj,formObj)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI01;
				sheetObj.DoSave("ESM_COA_0146GS.do", coaFormQueryString(formObj), -1, false);
				ComOpenWait(false);
				break;
			case IBINSERT:      // Insert
				sheetObj.DataCopy(); //copy row
				var num=0;
				for(i=1; i<=sheetObj.LastRow(); i++){
					if(ComParseInt(num)<ComParseInt(sheetObj.GetCellValue(i, "vsl_seq")))
						num=sheetObj.GetCellValue(i, "vsl_seq");
				}
				num=ComParseInt(num) + 1;
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vsl_seq",num,0);
				break;			
			case IBDOWNEXCEL:        // Excell download
				var excelType=selectDownExcelMethod(sheetObj,0);
				break;
		}
	}
	
    
    function callBackExcelMethod(excelType) {	
        var sheetObj = sheetObjects[excelType[1]];
        switch (excelType[0]) {
    		case "AY":						
    			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true, SheetDesign:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
    			break;
    		case "DY":					
    			sheetObj.Down2Excel( { HiddenColumn:1, SheetDesign:1,Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
    			break;
    		case "AN":					
    			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
    			break;
    		case "DN":						
    			sheetObj.Down2Excel( { HiddenColumn:1, SheetDesign:1,Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
    			break;
    	}            
    }

    
	/**
	 * Contents : Handling process for form object input validation <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     validateForm(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - Kinds of processes 
	 * @see #Link
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(formObj.f_vsl_cd.value != ""){
				if (!ComIsAlphabet(formObj.f_vsl_cd, "un")) {
					ComShowMessage(ComGetMsg("COM12114", "Vessel"));
					formObj.f_vsl_cd.select();
					return false;
				}// end if
			}// end if
		}
		return true;
	}
	/**
		* Handling the process of the window validation <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkValidCreate(sheetObj,formObj)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @see #Link
	 */
	function chkValidCreate(sheetObj,formObj){
		var cntTotal=sheetObj.RowCount();
		var cntDel	= sheetObj.RowCount("D");
		var strRowNum=sheetObj.FindStatusRow("I|U");
		var arrRow=strRowNum.split(";");
		var cnt=0;
		if(strRowNum != "") cnt=arrRow.length-1;
		if( cntTotal == cntDel) {
			ComShowCodeMessage("COM130302","all data");
			return false;
		}
		with(formObj){
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
				var vsl_aply_fm_dt=sheetObj.GetCellValue(i,"vsl_aply_fm_dt");
				var vsl_aply_to_dt=sheetObj.GetCellValue(i,"vsl_aply_to_dt");
				if(sheetObj.GetCellValue(i,"ibflag") != "R"){
					if(vsl_aply_fm_dt == "") {
						ComShowMessage(ComGetMsg("COM12114","vsl_aply_fm_dt",""));
						sheetObj.SelectCell(i, "vsl_aply_fm_dt");
						return false;
					}
					if(vsl_aply_to_dt == "") {
						ComShowMessage(ComGetMsg("COM12114","vsl_aply_to_dt",""));
						sheetObj.SelectCell(i, "vsl_aply_to_dt");
						return false;
					}
				}
			}
		}
		return true;
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }