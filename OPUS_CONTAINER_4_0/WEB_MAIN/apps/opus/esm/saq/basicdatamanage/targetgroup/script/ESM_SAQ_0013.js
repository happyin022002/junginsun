/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0013.js
*@FileTitle  : Equipment Status Code Creation, Update & Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var ComObjects=new Array();
    var sheetCnt=0;
    var Mincount=0;
    var ComboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    	function processButtonClick(){
    		var sheetObject=sheetObjects[0];
    		var formObject=document.form;
    		try {
    			var srcName=ComGetEvent("name");
    			if(ComGetBtnDisable(srcName)) return false;
    			switch(srcName) {
    				case "btn_retrieve":
    					doActionIBSheet(sheetObject, formObject, IBSEARCH);
    					break;
    				case "btn_new":
               			if(ComIsModifiedSheets(sheetObject)) {
    					    if(ComShowConfirm (ComGetMsg("SAQ90001")) != 1) {
    					    	return;
    					    }
    					}
               			ComResetAll();
      	        		break;
    				case "btn_save":
    					doActionIBSheet(sheetObject, formObject, IBSAVE);
    					break;
    				case "btn_rowadd":
    					doActionIBSheet(sheetObject, formObject, IBINSERT);
    					break;
    				case "btn_downexcel":
    					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    					break;
    			} // end switch
    		}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
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
         * registering IBSheet Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setComboObject(Combo_obj){
    		ComObjects[ComboCnt++]=Combo_obj;
        }
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
    	function loadPage() {
    		optionSetting();
    		for(i=0; i < sheetObjects.length; i++){
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i], i+1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		var sheetResizeFull=true;
    		//ComObjects[0].focus();
    		initSheetCombo();
    		
    		//initializing the combobox
			for (var k = 0; k < ComObjects.length; k++) {			    
			    initCombo(ComObjects[k], k + 1);
			}
    	}
    	
    	/**
		 * setting Combo initial values and header
		 * param : sheetObj, sheetNo
		 * adding case as numbers of counting Combos
		 */
		function initCombo(comboObj, comboNo) {
		    var formObject = document.form;
		    switch (comboObj.options.id) {
		        case "trade":
		            with(comboObj) {
		                SetDropHeight(250);
		                SetMultiSelect(0);
		                SetMaxSelect(1);
		                SetUseAutoComplete(1);
		                ValidChar(2);
		                SetMaxLength(3);
		            }
		            break;
		            
		        case "sub_trd_cd":
		            with(comboObj) {
		                SetDropHeight(340);
		                SetMultiSelect(0);
		                SetMaxSelect(1);
		                SetUseAutoComplete(1);
		                ValidChar(2, 1);
		                SetMaxLength(2);
		            }
		            break;
		            
		        case "saq_tgt_grp_cd":
		            with(comboObj) {
		                SetDropHeight(340);
		                SetMultiSelect(0);
		                SetMaxSelect(1);
		                SetUseAutoComplete(1);
		                ValidChar(2, 1);
		                SetMaxLength(2);
		            }
		            break;
		    }
		}
		
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
    		switch(sheetNo) {
    			case 1:       //sheet1 init
    				with(sheetObj){
	    		      SetFocusEditMode(default_edit_mode);
	    		      var HeadTitle="Del.|STS|SEQ|Trade|Sub Trade|Bound|Target Group|Allocation Priority" ;
	    		      SetHeaderRowHeight(20);

	    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

	    		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		      InitHeaders(headers, info);

                      var cols = [ {Type:"DelCheck",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"" },
                                   {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                   {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                   {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trd_cd",          KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,AcceptKeys:"E" },
                                   {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",      KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,AcceptKeys:"E" },
                                   {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dir_cd",          KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,AcceptKeys:"E" },
                                   {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"saq_tgt_grp_cd",  KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,AcceptKeys:"E" } ];

	    		      InitColumns(cols);
	    		      SetEditable(1);
//	    		      SetSheetHeight(540);
	    		      resizeSheet();
	    		      
    		      }
    				break;
    		}
    	}

    	function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
    	}

    	/* Sheet Combo Setting Start */
    	function initSheetCombo() {
    		initSheetCombo_trade();
    		initSheetCombo_subtrade();
    		initSheetCombo_bound();
    		initSheetCombo_tgt_grp();
    	}
    	function initSheetCombo_trade() {
    		var sheetObject=sheetObjects[0];
            var rtn=getCodeXmlList("TradeCombo", "isRepTrade=false&del=");
            var arrData=ComXml2ComboString(rtn, "trd_cd", "trd_nm");
            if (arrData != null){
                var arrCode=arrData[0].split("|");
                var arrName=arrData[1].split("|");
                var conData="";
                for(i=0; i < arrName.length;i++){
                    if(i==0){
                        arrName[i]=arrCode[i]+"\t"+arrName[i];
                    }else{
                        arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
                    }
                    conData=conData.concat(arrName[i]);
                }
                arrData[1]=conData;
            }
            arrData[0]=" |" + arrData[0];
            arrData[1]=" |" + arrData[1];
            sheetObject.SetColProperty("trd_cd", {ComboText:arrData[1], ComboCode:arrData[0]} );
    	}
    	function initSheetCombo_subtrade() {
    		var sheetObject=sheetObjects[0];
            var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true");
            var arrData=SaqXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
            arrData[0]=" |" + arrData[0];
            arrData[1]="\t\t|" + arrData[1];
            sheetObject.SetColProperty("sub_trd_cd", {ComboText:arrData[1] ,ComboCode:arrData[0], ShowCol:1} );
    	}
    	function initSheetCombo_bound() {
    		var sheetObject=sheetObjects[0];
            var sheetObject1=sheetObjects[1];
            var bound=" |E|W|S|N";
            sheetObject.SetColProperty("dir_cd", {ComboText:bound, ComboCode:bound} );
    	}
    	function initSheetCombo_tgt_grp() {
    		var sheetObject=sheetObjects[0];
    		var rtn=getCodeXmlList("TargetGroupCombo", "ofc=&del=");
            var arrData=SaqXml2ComboItem(rtn, "grp_cd", "grp_cd|grp_desc");
            //arrData[0] = " |" + arrData[0];
            //arrData[1] = " \tALL|" + arrData[1];
            arrData[0]=" |" + arrData[0];
            arrData[1]=" |" + arrData[1];
            sheetObject.SetColProperty("saq_tgt_grp_cd", {ComboText:arrData[1], ComboCode:arrData[0]} );
    	}
    	/* Sheet Combo Setting End */
        // handling sheet1 process
    	function doActionIBSheet(sheetObj, formObj, sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
    			case IBSEARCH:      //search
    				if(ComIsModifiedSheets(sheetObj)){
    					//Used in case of checking from changing sheet
    			        if(ComShowConfirm (getMsg("SAQ90001")) != 1){
    			            return;
    			        }
    				}
    				formObj.f_cmd.value=SEARCHLIST;
     				sheetObj.DoSearch("ESM_SAQ_0013GS.do", "f_cmd=" + SEARCHLIST + "&" + saqFormString(formObj)+ "&" + ComGetPrefixParam("") );
    				break;
    			case IBSAVE:        //save
					// DoSave 함수 사용과 동일한 저장 String 가져오기 - 트랜잭션이 발생한 것만 저장할 경우
					var SaveStr = sheetObj.GetSaveString(false);
					if (SaveStr == "") return;
					// 2컬럼SaveName="chulpa", 3컬럼SaveName="enterDate", 7컬럼SaveName="stckCd" 인 경우
					var Row = sheetObj.ColValueDup("trd_cd|sub_trd_cd|dir_cd",false);
					if (Row != -1) {
						ComShowCodeMessage("COM131302", "Trade,Sub Trade,Bound");
						return;
					}

					var tran_rows = sheetObj.FindStatusRow("U|I");
					formObj.f_cmd.value = MULTI01;
					doSaveSheet(sheetObj, "ESM_SAQ_0013GS.do", "f_cmd=" + MULTI01 + "&" + saqFormString(formObj));
					break;
    			case IBINSERT:      // insert
    				var Row=sheetObj.DataInsert();
    		        sheetObj.SelectCell(Row, "trd_cd", true, "");
    	            sheetObj.SetCellValue(Row, "trd_cd","",0);
    	            sheetObj.SetCellValue(Row, "sub_trd_cd","",0);
    	            sheetObj.SetCellValue(Row, "dir_cd","",0);
    				break;
    			case IBDOWNEXCEL:        //excel upload
                    selectDownExcelMethod(sheetObj);
    				break;
    			}
    	}

    	 function callBackExcelMethod(excelType) {
    	    	var sheetObj = sheetObjects[0];
    			if(sheetObj.RowCount() < 1){//no data
    				ComShowCodeMessage("COM132501");
    				return;
    			}
    			DownExcel(sheetObj, excelType);
    	 }

    	/**
    	 * Changing lane in case of chaging saq_tgt_grp_cd.
    	 * Changing spc_aloc_prio_cd in case of chaging saq_tgt_grp_cd.
    	 */
    	function sheet1_OnChange(sheetObj, row, col, value){
    		with(sheetObj){
    			switch(ColSaveName(col)){
                	case "trd_cd":
                		if(value == "" && value == " "){
                       		SetCellText(row, "trd_cd" ,"");
                     	}
                		//Trade에 따른 Sub Trade 세팅
                        var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true&trdCd="+value);
                        var arrData=SaqXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
                        arrData[0]=" |" + arrData[0];
                        arrData[1]="\t\t|" + arrData[1];
                                               
                        sheetObj.InitCellProperty(row, "sub_trd_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:1} );                        
                		break;
                	case "sub_trd_cd":
                		if(value != "" && value != " "){
                        	var text1=getSheetComboText(sheetObj, row, col, 1, "sub_trade", value);
                         	SetCellText(row, "sub_trd_cd" ,text1);
    					} else {
    					 	SetCellText(row, "sub_trd_cd" ,"");
    					}
                		break;
                	case "dir_cd":
                		if(value == "" && value == " "){
                       		SetCellText(row, "dir_cd" ,"");
                     	}
                		break;
    				case "saq_tgt_grp_cd":
    					if(value != "" && value != " "){
    						var insert_trd=GetCellValue(row, "trd_cd");
    						var findedRow=1;
    						findedRow=FindText("trd_cd", insert_trd);
    						while(findedRow >= 0) {
    							SetCellValue(findedRow, "saq_tgt_grp_cd",value,0);
    							findedRow=FindText("trd_cd", insert_trd, findedRow+1);
    						}
    					} else {
    						SetCellText(row, "saq_tgt_grp_cd" ,"");
    					}
    					break;
    			}
    		}
    	}
    	function optionSetting() {
    		SaqSearchOptionTrade("trade");
    		SaqSearchOptionSubTrade("sub_trd_cd");
    		SaqSearchOptionTargetGroup("saq_tgt_grp_cd", "", true, true);
    	}
    	
    	function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode ){
    	
    		SaqSearchOptionSubTrade("sub_trd_cd",true, false, '',newText);
    	}
