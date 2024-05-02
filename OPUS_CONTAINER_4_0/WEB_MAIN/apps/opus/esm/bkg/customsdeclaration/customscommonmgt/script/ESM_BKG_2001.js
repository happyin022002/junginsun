/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2001.js
*@FileTitle  : Customs Common Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    var sheetObjects=new Array();
    var sheetCnt=0;
    
    var dblRow=0;
    var dblClickStatus=0;
    var dblCnt=0;
    
    var chgEventCnt1=0;
    var chgEventCnt2=0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    // Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
         var sheet1RowCnt=sheetObjects[0].RowCount();
         var sheet2RowCnt=sheetObjects[1].RowCount();
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
   			case "btn_retrieve":
   				dblClickStatus=0;
   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   				break;
   			case "btn_save":
   				for(var i=1; i <= sheet1RowCnt; i++){
   					if(sheetObjects[0].GetCellValue(i,"ibflag")=='I' || sheetObjects[0].GetCellValue(i,"ibflag")=='U'|| sheetObjects[0].GetCellValue(i,"ibflag")=='D'){
   						chgEventCnt1=chgEventCnt1 +1;
   					}
   				}
   				for(var i=1; i <= sheet2RowCnt; i++){
   					if(sheetObjects[1].GetCellValue(i,"ibflag")=='I' || sheetObjects[1].GetCellValue(i,"ibflag")=='U'|| sheetObjects[1].GetCellValue(i,"ibflag")=='D'){
   						chgEventCnt2=chgEventCnt2 +1;
   					}
   				}
				if(chgEventCnt1 == 0 && chgEventCnt2 == 0){
					ComShowCodeMessage('BKG00260');
					break;
				}
   				if(chgEventCnt1 > 0){
   					doActionIBSheet(sheetObjects[0], document.form, MULTI01);
   				}
   				if(chgEventCnt2 > 0){
   					doActionIBSheet(sheetObjects[1], document.form, MULTI02);
   				}
				break;
   			case "btn_RowAdd1":
				addRow(sheetObjects[0],1);
				break;
			case "btn_RowDel1":
				//deleteRow();
				deleteRow(sheetObjects[0],1);
				break;
			case "btn_exceldown1":
				doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown1","","");
				break;
			case "btn_excelup1":
				doActionIBSheet(sheetObjects[0],document.form,"btn_excelup1");
				break;
			case "btn_RowAdd2":
				if(dblClickStatus == 1){
				addRow(sheetObjects[1],2);
				}else if (dblClickStatus != 1){
					ComShowMessage("This Row Add Button is available only when you did double click parents table's Row.");
				}
				break;
			case "btn_RowDel2":
				//deleteRow();
				deleteRow(sheetObjects[1],2);
				break;
			case "btn_exceldown2":
				doActionIBSheet(sheetObjects[1],document.form,"btn_exceldown2","","");
				break;
			case "btn_excelup2":	
				doActionIBSheet(sheetObjects[1], document.form, "btn_excelup2");
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         // necessary event on the screen
    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
     }
     function initControl() {
    	 var formObj=document.form;
    	 axon_event.addListenerForm		('focus'	, 'obj_focus'		, formObj);
    	 axon_event.addListenerFormat	('keypress'	, 'obj_keypress'	, form);
      	 axon_event.addListenerFormat	('keyup'	, 'obj_change' 		, form);
     }
     function obj_focus() {
    	if(event.srcElement.options){
    		event.srcElement.focus();
    	}else{
    		event.srcElement.select();
    	}
    }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
            	with(sheetObj){                
                
                var HeadTitle="|Sel.|Seq|Country|Division ID|Description|Attribute Name 1|Attribute Name 2|Attribute Name 3|Attribute Name 4|Attribute Name 5";
                var headCount=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 }, 
                       {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cstms_div_id",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
                       {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cstms_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
                       {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                       {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                       {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                       {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                       {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetWaitImageVisible(0);                
                SetAutoRowHeight(0);
                SetDataRowHeight(22);
                SetSheetHeight(240);
                
                SetColProperty("cstms_div_id", {InputCaseSensitive:1});
                }
            break;
            case 2:      // sheet2 init
                with(sheetObj){	                
	              //no support[check again]CLT 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	              var HeadTitle="|Sel.|Seq|Country|Division ID|Attribute Content 1|Attribute Content 2|Attribute Content 3|Attribute Content 4|Attribute Content 5|";
	              var headCount=ComCountHeadTitle(HeadTitle);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
	                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cstms_div_id",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt5",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cstms_div_id_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetWaitImageVisible(0);	              
	              SetAutoRowHeight(0);
	              SetDataRowHeight(22);
	              SetSheetHeight(240);
              	}


                break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:
				ComOpenWait(true);
				if(validateForm(sheetObj,formObj,sAction)!= true){
					ComOpenWait(false);
					break;
				}
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.f_cmd.value=SEARCH;
				var sParam=FormQueryString(formObj);
 				sheetObj.DoSearch("ESM_BKG_2001GS.do",sParam );
				ComOpenWait(false);
				break;
			case SEARCH01:
				formObj.f_cmd.value=SEARCH01;
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
 				sheetObjects[1].DoSearch("ESM_BKG_2001GS.do",sParam );
				ComOpenWait(false);
				dblClickStatus=1;
	            break;
			case SEARCH02:      //retrieve
						formObj.f_cmd.value=SEARCH02;
						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObjects[0].GetSaveData("ESM_BKG_2001GS.do", FormQueryString(formObj));
						var valResult=ComGetEtcData(sXml, "conv_cnt");
						document.form.chk_cnt.value=valResult;
						break;
			case MULTI01: // Save
           			if(validateForm(sheetObj,formObj,sAction) != true){
           				ComShowCodeMessage('BKG00167');
           				break;
           			}
           			formObj.f_cmd.value=MULTI01;
           			var sParam=sheetObj.GetSaveString(false, true, "ibflag");
            			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_2001GS.do", "f_cmd=" + MULTI01 + "&" +sParam);
           			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
           			if(chgEventCnt2 == 0){
           				if(State != "S"){
            				ComShowMessage(ComResultMessage(sXml));
            				return false;
            			}else if(State == "S"){
            				ComShowCodeMessage('BKG00166');
            				chgEventCnt1=0;
            				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            			}
           			}
           			break;
			case MULTI02: // Save
					formObj.f_cmd.value=MULTI02;
					var sParam=sheetObjects[1].GetSaveString(false, true, "ibflag");
 					var sXml=sheetObjects[1].GetSaveData("ESM_BKG_2001GS.do", "f_cmd=" + MULTI02 + "&" +sParam);
					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
           			if(State != "S"){
        				ComShowMessage(ComResultMessage(sXml));
        				return false;
        			}else if(State == "S"){
        				ComShowCodeMessage('BKG00166');
        				chgEventCnt1=0;
        				chgEventCnt2=0;
        				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        			}
					break;
           case "btn_exceldown1":
 				//sheetObj.Down2Excel({ HiddenColumn:1}); 수정함
        	   	if(sheetObj.RowCount() < 1){//no data
        		   ComShowCodeMessage("BKG00109");
        		 }else{
//	       			sheetObj.SetHeaderBackColor("#CCCCCC");
	    			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
//	    			sheetObj.SetHeaderBackColor("#333333");
        		 }
				break;
           case "btn_exceldown2":
 				//sheetObj.Down2Excel({ HiddenColumn:1}); 수정함
        	   	if(sheetObj.RowCount() < 1){//no data
        		   ComShowCodeMessage("BKG00109");
        		 }else{
        		   sheetObj.Down2Excel({ HiddenColumn:1 });
        		 }
				break;
           case "btn_excelup1":        	    
       	    	sheetObj.RemoveAll();       	    	
       	    	sheetObjects[1].RemoveAll();       	    	
				sheetObj.RenderSheet(0);				
 				sheetObj.LoadExcel({ Mode:"HeaderMatch"}); 		
 				sheetObj.RenderSheet(1);
				break;
           case "btn_excelup2":
        	   sheetObj.RemoveAll();       	   	
        	   sheetObj.RenderSheet(0);
        	   sheetObj.LoadExcel({ Mode:"HeaderMatch"});
        	   sheetObj.RenderSheet(1);
        	   break;
        }
    }
    /**
     * handling process for input validation
     * @param SheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function validateForm(sheetObj,formObj,sAction){
    	 var sheet1RowCnt=sheetObj.RowCount();
	    switch(sAction) {
			case IBSEARCH: { // retrieve
				if (!ComChkValid(formObj)) return false;
   			var frmCntCd=formObj.frm_cnt_cd.value;
				//ComShowMessage("[" + etaDt + "][" + blNo +"]["+ cntrNo + "]");
   			if(frmCntCd == "") {
					ComShowCodeMessage('BKG01101', 'Country Code');
					ComSetFocus(formObj.frm_cnt_cd);
					return false;
   			}
   			if(formObj.frm_cnt_cd.value.length != 2){
   				ComShowCodeMessage('BKG95018', 'Country Code', '2');
				ComSetFocus(formObj.frm_cnt_cd);
				return false;
   			}
				break;
			}
			case MULTI01 : {
				if (!ComChkValid(formObj)) return false;
//				checkCount(sheetObj,formObj);
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i,"cnt_cd")=="" || sheetObj.GetCellValue(i,"cstms_div_id") == ""){
						var Msg="Country Code or Customs Division ID";
						ComShowCodeMessage('BKG00626',  Msg);
						return false;
					}
				}
				break;
			}
	    } // end switch()
        return true;
    }
     /**
      * checking Load Excel Validation
      * @param SheetObj
      * @param formObj
      */ 
     function checkCount(sheetObj,formObj){
    	 var sheet1RowCnt=sheetObj.RowCount();
			for(var i=1; i <= sheet1RowCnt; i++){
				if(sheetObj.GetCellValue(i, "ibflag")=='I'){
					formObj.f_cmd.value=SEARCH02;
					formObj.chk_cnt_cd.value=sheetObj.GetCellValue(i, "cnt_cd");
					formObj.chk_cstms_div_id.value=sheetObj.GetCellValue(i, "cstms_div_id");
					if(sheetObj.GetCellValue(i, "cnt_cd").length == ""){
			      		ComShowCodeMessage('COM12200', i + ' Row Country Code');
			      		sheetObj.SetCellValue(i, "cnt_cd",'',0);
					}else if(sheetObj.GetCellValue(i, "cnt_cd").length != 2){
			      		ComShowCodeMessage('BKG95018', i + ' Row Country Code', '2');
			      		sheetObj.SetCellValue(i, "cnt_cd",'',0);
			      	}
					if(sheetObj.GetCellValue(i, "cstms_div_id").length == ""){
			      		ComShowCodeMessage('COM12200', i + ' Row Customs Division ID');
						sheetObj.SetCellValue(i, "cstms_div_id",'',0);
			      	}
					if(sheetObj.GetCellValue(i,"cnt_cd") != "" && sheetObj.GetCellValue(i,"cstms_div_id") != ""){
			      		doActionIBSheet(sheetObj, formObj, SEARCH02);
			      		if(document.form.chk_cnt.value == '1'){
			        		  var Msg=formObj.chk_cnt_cd.value + " and " + formObj.chk_cstms_div_id.value;
							  ComShowCodeMessage('BKG03056', Msg);
							  sheetObj.SetCellValue(i, "cnt_cd",'',0);
							  sheetObj.SetCellValue(i, "cstms_div_id",'',0);
						  }
			      	}
				}
			}
     }
      /**
       * checking Load Excel of sheet2 Validation
       * @param SheetObj
       * @param formObj
       */ 
      function checkCount2(sheetObj,formObj){
    	   var nowRow=sheetObjects[0].GetSelectRow();
    	   var sheet2RowCnt=sheetObj.RowCount();
    	   for(var i=1; i <= sheet2RowCnt; i++){
    		   if(sheetObj.GetCellValue(i, "ibflag")=='I'){
 					formObj.f_cmd.value=SEARCH02;
 					formObj.chk_cnt_cd.value=sheetObj.GetCellValue(i, "cnt_cd");
 					formObj.chk_cstms_div_id.value=sheetObj.GetCellValue(i, "cstms_div_id");
 					if(sheetObjects[0].GetCellValue(nowRow,"cnt_cd") != formObj.chk_cnt_cd.value){
 						ComShowMessage("Sheet2's Country Code is Not same as Sheet1's Country Code.");
 			      		sheetObj.SetCellValue(i, "cnt_cd",'',0);
 					}
 					if(sheetObjects[0].GetCellValue(nowRow,"cstms_div_id") != formObj.chk_cstms_div_id.value){
 						ComShowMessage("Sheet2's Customs Division ID is Not same as Sheet1's Customs Division ID.");
 			      		sheetObj.SetCellValue(i, "cstms_div_id",'',0);
 					}
 				}
 			}
      }
    /**
     * process when input retrieve keyword
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    }
     /**
      * add Row of sheet1 and sheet2
      * @param SheetObj
      * @param sheetNo
      */ 
    function addRow(sheetObj,sheetNo) {
    	  var formObj=document.form;
    	  switch(sheetNo) {
    	  case 1 :
    	  		with (sheetObjects[0]) {
    	  			var nowRow=GetSelectRow();
    	  			nowRow=DataInsert(-1);
    	  			SetCellValue(nowRow, "cnt_cd",formObj.frm_cnt_cd.value,0);
    	  			return true;
    	  		}
    	  case 2 :
        	  	with (sheetObjects[1]) {
        	  		var nowRow=GetSelectRow();
        	  		nowRow=DataInsert(-1);
        	  		SetCellValue(nowRow, "cnt_cd",sheetObjects[0].GetCellValue(dblRow,"cnt_cd"),0);
        	  		SetCellValue(nowRow, "cstms_div_id",sheetObjects[0].GetCellValue(dblRow,"cstms_div_id"),0);
        	  		return true;
        	  	}
       }
    }
    /**
     * delete Row of sheet1 and sheet2
     * @param SheetObj
     * @param sheetNo
     */  
     function deleteRow(sheetObj,sheetNo) {    	 
    	 switch(sheetNo){
    	 case 1 : 
    		 with (sheetObj) {
                 var sRowStr1=FindCheckedRow("check");
                 var arr1=sRowStr1.split("|");
                 for (var i=0; i<arr1.length; i++) { // for (var i=0; i<arr1.length - 1 ; i++) {
                	  SetRowStatus(arr1[i],"D");
//                     CellValue(arr[i], "dept_cd") = "NONE";
                     SetRowHidden(arr1[i],"1");
                 }
                 return true;
    	 }
    	 case 2 : 
    		 with (sheetObj) {
                 var sRowStr2=FindCheckedRow("check");
                 var arr2=sRowStr2.split("|");
                 for (var i=0; i<arr2.length; i++) { // for (var i=0; i<arr2.length - 1 ; i++) {
                	  SetRowStatus(arr2[i],"D");
//                     CellValue(arr[i], "dept_cd") = "NONE";
                     SetRowHidden(arr2[i],"1");
                 }
                 return true;
    		 }
    	 }         
     }
     /*
      * setting key input on the sheet
      */
     function obj_KeyPress(){
         var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
         var srcName=event.srcElement.getAttribute("name");
         var srcValue=event.srcElement.getAttribute("value");
         switch(event.srcElement.dataformat) {
         case "engup":  
         ComKeyOnlyAlphabet('upper'); break;
         }
     }
      /**
       * retrieve about Country Code, Customs Division ID of sheet1 in case of double click at row of sheet1
       * @param SheetObj
       * @param Row
       * @param Col
       * @return
       */
      function sheet1_OnDblClick(SheetObj, Row, Col) {
    	   if(SheetObj.ColSaveName(Col)=="cnt_cd"||SheetObj.ColSaveName(Col)=="cstms_div_id"||SheetObj.ColSaveName(Col)=="seq"){
    		   if(SheetObj.GetCellValue(Row,"cnt_cd")!=""&&SheetObj.GetCellValue(Row,"cstms_div_id")!=""){
    			  var formObj=document.form;
    			  var nowRow=SheetObj.GetSelectRow();
    			  dblRow=nowRow;
    			  formObj.chk_cnt_cd.value=SheetObj.GetCellValue(nowRow, "cnt_cd");
    			  formObj.chk_cstms_div_id.value=SheetObj.GetCellValue(nowRow, "cstms_div_id");
    			  doActionIBSheet(SheetObj, formObj, SEARCH01);
    			  dblCnt=1;
    		  }
    	   }
       }
      /**
       * checking key field of sheet1 input Validation
       * @param SheetObj
       * @param Row
       * @param Col
       * @param Value
       */
      function sheet1_OnChange(sheetObj, Row, Col, Value){
      	var formObj=document.form;
      	// checking Country Code validation
      	if(sheetObj.ColSaveName(Col) == "cnt_cd"){
      		formObj.f_cmd.value=SEARCH02;
      		formObj.chk_cnt_cd.value=sheetObj.GetCellValue(Row, Col);
      		formObj.chk_cstms_div_id.value=sheetObj.GetCellValue(Row, "cstms_div_id");
      		if(sheetObj.GetCellValue(Row,"cnt_cd") != "" && sheetObj.GetCellValue(Row,"cstms_div_id") != ""){
      			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
      			if(document.form.chk_cnt.value == '1'){
	        		  var Msg=formObj.chk_cnt_cd.value + " and " + formObj.chk_cstms_div_id.value;
					  ComShowCodeMessage('BKG03056', Msg);
					  sheetObj.SetCellValue(Row, "cnt_cd",'',0);
					  sheetObj.SetCellValue(Row, "cstms_div_id",'',0);
				  }
      		}
      	}
      	// checking Customs Division ID validation
      	if(sheetObj.ColSaveName(Col) == "cstms_div_id"){
      		formObj.f_cmd.value=SEARCH02;
      		formObj.chk_cstms_div_id.value=sheetObj.GetCellValue(Row, Col);
      		formObj.chk_cnt_cd.value=sheetObj.GetCellValue(Row, "cnt_cd");
      		if(sheetObj.GetCellValue(Row,"cnt_cd") != "" && sheetObj.GetCellValue(Row,"cstms_div_id") != ""){
      			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
      			if(document.form.chk_cnt.value == '1'){
	        		  var Msg=formObj.chk_cnt_cd.value + " and " + formObj.chk_cstms_div_id.value;
					  ComShowCodeMessage('BKG03056', Msg);
					  sheetObj.SetCellValue(Row, "cnt_cd",'',0);
					  sheetObj.SetCellValue(Row, "cstms_div_id",'',0);
				  }
      		}
      	} 
      }
      
      
      function sheet2_OnLoadExcel(SheetObj, result, code, msg) {
    	  if(isExceedMaxRow(msg))return;
    	  if(dblCnt == 0){					   
    		  ComShowMessage("Please double click on 1 Row of the sheet1 !!");
		   	  sheetObjects[1].RemoveAll();
		  }
    	  checkCount2(sheet2, document.form);
    	  dblCnt=0;
    	  sheet2.RenderSheet(1);
      }
      
      function sheet1_OnLoadExcel(result, msg) {
    	  if(isExceedMaxRow(msg))return;
    	  checkCount(sheet1, document.form);
    	  sheet1.RenderSheet(1);
      }