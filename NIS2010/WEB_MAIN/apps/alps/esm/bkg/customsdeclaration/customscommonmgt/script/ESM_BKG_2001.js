/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_2001.js
*@FileTitle : Customs Common Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESM_BKG_2001 : business script for ESM_BKG_2001
     */
    function ESM_BKG_2001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	

    

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var dblRow = 0;
    var dblClickStatus = 0;
    var dblCnt = 0;
    var chgEventCnt1 = 0;
    var chgEventCnt2 = 0;


    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         
         /*******************************************************/
         var formObject = document.form;
         var sheet1RowCnt = sheetObjects[0].RowCount;
         var sheet2RowCnt = sheetObjects[1].RowCount;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
   			
   			case "btn_retrieve":
   				dblClickStatus = 0;
   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   				break;
   				
   			case "btn_save":
   				for(var i=1; i <= sheet1RowCnt; i++){
   					if(sheetObjects[0].CellValue(i,"ibflag")=='I' || sheetObjects[0].CellValue(i,"ibflag")=='U'|| sheetObjects[0].CellValue(i,"ibflag")=='D'){
   						chgEventCnt1 = chgEventCnt1 +1;
   					}
   				}
   				for(var i=1; i <= sheet2RowCnt; i++){
   					if(sheetObjects[1].CellValue(i,"ibflag")=='I' || sheetObjects[1].CellValue(i,"ibflag")=='U'|| sheetObjects[1].CellValue(i,"ibflag")=='D'){
   						chgEventCnt2 = chgEventCnt2 +1;
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
				deleteRow(sheetObjects[1],2);
				break;
				

			case "btn_exceldown2":
				doActionIBSheet(sheetObjects[1],document.form,"btn_exceldown2","","");
				break;
				
			case "btn_excelup2":
				doActionIBSheet(sheetObjects[1],document.form,"btn_excelup2");
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
       sheetObjects[sheetCnt++] = sheet_obj;
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
    	 var formObj = document.form;
    	 
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
        var cnt = 0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // setting height
                    style.height = 240;
                    // setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Kind of Merge [Option, Default msNone]
//                    MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                   //Edit  [Option, Default false]
                    Editable = true;
                    
                    var HeadTitle = "|Sel.|Seq|Country|Division ID|Description|Attribute Name 1|Attribute Name 2|Attribute Name 3|Attribute Name 4|Attribute Name 5";
                    var headCount = ComCountHeadTitle(HeadTitle);
                  //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);
                  //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);
                 // setting Header Mode
                    InitHeadMode(true, true, false, true, false,false)
                    //Header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                  //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck, 		40, 	daCenterTop,	true, 	"check");
	                InitDataProperty(0, cnt++ , dtSeq,  30,     daCenterTop, 	 true,     "seq");
	                InitDataProperty(0, cnt++ , dtData, 70,    daCenterTop, 	 true,     "cnt_cd",	true,       "",      dfNone,      	0,     false,		true, 2);
	                InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "cstms_div_id", 	true,       "",      dfNone,      	0,     false,		true, 20);
	                InitDataProperty(0, cnt++ , dtData, 400,    daLeft, 	 true,     "cstms_cd_desc",	false,       "",      dfNone,      	0,     true,		true, 4000);
	                InitDataProperty(0, cnt++ , dtData, 190,    daCenterTop, 	 true,     "attr_nm1",    false,       "",      dfNone,   	0,     true,		true, 200);
	                InitDataProperty(0, cnt++ , dtData, 110,    daCenterTop, 	 true,     "attr_nm2",    false,       "",      dfNone,   	0,     true,		true, 200);
	                InitDataProperty(0, cnt++ , dtData, 110,    daCenterTop, 	 true,     "attr_nm3",    false,       "",      dfNone,   	0,     true,		true, 200);
	                InitDataProperty(0, cnt++ , dtData, 110,    daCenterTop, 	 true,     "attr_nm4",    false,       "",      dfNone,   	0,     true,		true, 200);
	                InitDataProperty(0, cnt++ , dtData, 110,    daCenterTop, 	 true,     "attr_nm5",    false,       "",      dfNone,   	0,     true,		true, 200);
	                
	                 WaitImageVisible=false;
	                 
	                 InitDataValid(0, "cnt_cd", vtEngUpOnly);
	                 InitDataValid(0, "cstms_div_id", vtEngUpOther, "0123456789-_");
	                 InitDataValid(0, "attr_nm1", vtEngUpOther, "0123456789-_");
	                 InitDataValid(0, "attr_nm2", vtEngUpOther, "0123456789-_");
	                 InitDataValid(0, "attr_nm3", vtEngUpOther, "0123456789-_");
	                 InitDataValid(0, "attr_nm4", vtEngUpOther, "0123456789-_");
	                 InitDataValid(0, "attr_nm5", vtEngUpOther, "0123456789-_");

	                 // setting auto row height
	                 AutoRowHeight = false;
	                 // setting row height
	                 DataRowHeight = 22;
            }
            
            break;
            
            case 2:      // sheet2 init
            	with (sheetObj) {
                	// setting height
                	style.height = 240;
                	// setting width
                	SheetWidth = mainTable.clientWidth;

                	//setting Host information[mandatory][HostIp, Port, PagePath]
                	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                	//Kind of Merge [Option, Default msNone]
//                	MergeSheet = msNone;
                	MergeSheet = msHeaderOnly;

                	//Edit  [Option, Default false]
                	Editable = true;
                
                	var HeadTitle = "|Sel.|Seq|Country|Division ID|Attribute Content 1|Attribute Content 2|Attribute Content 3|Attribute Content 4|Attribute Content 5|";
                	var headCount = ComCountHeadTitle(HeadTitle);
                	//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                	InitRowInfo(1, 1, 15, 100);
                	//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(headCount, 0, 0, false);
                	// setting Header Mode
                	InitHeadMode(true, true, false, true, false,false)
                	//Header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle, true);
                
                	//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	"ibflag");
                	InitDataProperty(0, cnt++ , dtDummyCheck, 		40, 	daCenterTop,	true, 	"check");
                	InitDataProperty(0, cnt++ , dtSeq,  30,     daCenterTop, 	 true,     "seq");
                	InitDataProperty(0, cnt++ , dtData, 70,    daCenterTop, 	 true,     "cnt_cd",	true,       "",      dfNone,      	0,     false,		false, 2);
                	InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "cstms_div_id", 	true,       "",      dfNone,      	0,     false,		false, 20);
                	InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "attr_ctnt1",    false,       "",      dfNone,   	0,     true,		true, 200);
                	InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "attr_ctnt2",    false,       "",      dfNone,   	0,     true,		true, 200);
                	InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "attr_ctnt3",    false,       "",      dfNone,   	0,     true,		true, 200);
                	InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "attr_ctnt4",    false,       "",      dfNone,   	0,     true,		true, 200);
                	InitDataProperty(0, cnt++ , dtData, 150,    daCenterTop, 	 true,     "attr_ctnt5",    false,       "",      dfNone,   	0,     true,		true, 200);
                	InitDataProperty(0, cnt++ , dtHidden, 150,    daCenterTop, 	 true,     "cstms_div_id_seq",    false,       "",      dfNone,   	0,     true,		true, 6);
                	
                	WaitImageVisible=false;
                 
                	InitDataValid(0, "cnt_cd", vtEngUpOnly);
                	InitDataValid(0, "cstms_div_id", vtEngUpOther, "0123456789-_");
                	InitDataValid(0, "attr_ctnt1", vtEngUpOther, "0123456789-_");
                	InitDataValid(0, "attr_ctnt2", vtEngUpOther, "0123456789-_");
                	InitDataValid(0, "attr_ctnt3", vtEngUpOther, "0123456789-_");
                	InitDataValid(0, "attr_ctnt4", vtEngUpOther, "0123456789-_");
                	InitDataValid(0, "attr_ctnt5", vtEngUpOther, "0123456789-_");

                	// setting auto row height
                	AutoRowHeight = false;
                	// setting row height
                	DataRowHeight = 22;
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
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:
				ComOpenWait(true);
				if(validateForm(sheetObj,formObj,sAction)!= true){
					ComOpenWait(false);
					break;
				}
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_2001GS.do",sParam);
				ComOpenWait(false);
				
				break;
				
			case SEARCH01:
				formObj.f_cmd.value = SEARCH01;
				ComOpenWait(true);
				var sParam = FormQueryString(formObj);
				sheetObjects[1].DoSearch("ESM_BKG_2001GS.do",sParam);
				ComOpenWait(false);
				dblClickStatus = 1;
	            break;
       	
			case SEARCH02:      //retrieve
						formObj.f_cmd.value = SEARCH02;
						sheetObj.WaitImageVisible = false;
      	  
						var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_2001GS.do", FormQueryString(formObj));
						var valResult = ComGetEtcData(sXml, "conv_cnt");
						document.form.chk_cnt.value = valResult;
						break;
						
			case MULTI01: // Save
           			if(validateForm(sheetObj,formObj,sAction) != true){
           				ComShowCodeMessage('BKG00167');
           				break;
           			}
           			formObj.f_cmd.value = MULTI01;
           			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
           			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_2001GS.do", "f_cmd=" + MULTI01 + "&" +sParam);
           			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
           			if(chgEventCnt2 == 0){
           				if(State != "S"){
            				ComShowMessage(ComResultMessage(sXml));
            				return false;
            			}else if(State == "S"){
            				ComShowCodeMessage('BKG00166');
            				chgEventCnt1 = 0;
            				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            			}
           			}
           			
           			break;
           			
			case MULTI02: // Save
					formObj.f_cmd.value = MULTI02;
					var sParam 	= sheetObjects[1].GetSaveString(false, true, "ibflag");
					var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_2001GS.do", "f_cmd=" + MULTI02 + "&" +sParam);
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
           			if(State != "S"){
        				ComShowMessage(ComResultMessage(sXml));
        				return false;
        			}else if(State == "S"){
        				ComShowCodeMessage('BKG00166');
        				chgEventCnt1 = 0;
        				chgEventCnt2 = 0;
        				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        			}
					break;
			
           case "btn_exceldown1":
				sheetObj.SpeedDown2Excel(1);
				break;
				
           case "btn_exceldown2":
				sheetObj.SpeedDown2Excel(1);
				break;
				
           case "btn_excelup1":
       	    	sheetObj.RemoveAll();
       	    	sheetObjects[1].RemoveAll();
				sheetObj.Redraw = false;
				sheetObj.LoadExcel(-1);
				sheetObj.Redraw = true;
				var formObj = document.form;
				checkCount(sheetObj,formObj);
				break;
				
           case "btn_excelup2":
        	   	sheetObj.RemoveAll();
				sheetObj.Redraw = false;
				sheetObj.LoadExcel(-1);
				sheetObj.Redraw = true;
				if(dblCnt == 0){
		    		   ComShowMessage("Please double click on 1 Row of the sheet1 !!");
		    		   sheetObjects[1].RemoveAll();
		    		   break;
		    	}
				var formObj = document.form;
				checkCount2(sheetObj,formObj);
				dblCnt=0;
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
    	 var sheet1RowCnt = sheetObj.RowCount;
	    switch(sAction) {
			case IBSEARCH: { // retrieve
			    
				if (!ComChkValid(formObj)) return false;
				
   			var frmCntCd = formObj.frm_cnt_cd.value;
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
					if(sheetObj.CellValue(i,"cnt_cd")=="" || sheetObj.CellValue(i,"cstms_div_id") == ""){
						var Msg = "Country Code or Customs Division ID";
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
    	 var sheet1RowCnt = sheetObj.RowCount;
			for(var i=1; i <= sheet1RowCnt; i++){
				if(sheetObj.CellValue(i, "ibflag")=='I'){
					formObj.f_cmd.value = SEARCH02;
			      	formObj.chk_cnt_cd.value = sheetObj.CellValue(i, "cnt_cd");
			      	formObj.chk_cstms_div_id.value = sheetObj.CellValue(i, "cstms_div_id");
			      	if(sheetObj.CellValue(i, "cnt_cd").length == ""){
			      		ComShowCodeMessage('COM12200', i + ' Row Country Code');
			      		sheetObj.CellValue2(i, "cnt_cd") = '';
			      	}else if(sheetObj.CellValue(i, "cnt_cd").length != 2){
			      		ComShowCodeMessage('BKG95018', i + ' Row Country Code', '2');
			      		sheetObj.CellValue2(i, "cnt_cd") = '';
			      	}
			      	if(sheetObj.CellValue(i, "cstms_div_id").length == ""){
			      		ComShowCodeMessage('COM12200', i + ' Row Customs Division ID');
						sheetObj.CellValue2(i, "cstms_div_id") = '';
			      	}
			      	if(sheetObj.CellValue(i,"cnt_cd") != "" && sheetObj.CellValue(i,"cstms_div_id") != ""){
			      		doActionIBSheet(sheetObj, formObj, SEARCH02);
			      		if(document.form.chk_cnt.value == '1'){
			        		  var Msg = formObj.chk_cnt_cd.value + " and " + formObj.chk_cstms_div_id.value;
							  ComShowCodeMessage('BKG03056', Msg);
							  sheetObj.CellValue2(i, "cnt_cd") = '';
							  sheetObj.CellValue2(i, "cstms_div_id") = '';
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
    	   var nowRow = sheetObjects[0].SelectRow;
    	   var sheet2RowCnt = sheetObj.RowCount;
    	   for(var i=1; i <= sheet2RowCnt; i++){
 				if(sheetObj.CellValue(i, "ibflag")=='I'){
 					formObj.f_cmd.value = SEARCH02;
 			      	formObj.chk_cnt_cd.value = sheetObj.CellValue(i, "cnt_cd");
 			      	formObj.chk_cstms_div_id.value = sheetObj.CellValue(i, "cstms_div_id");
 			      	if(sheetObjects[0].CellValue(nowRow,"cnt_cd") != formObj.chk_cnt_cd.value){
 						ComShowMessage("Sheet2's Country Code is Not same as Sheet1's Country Code.");
 			      		sheetObj.CellValue2(i, "cnt_cd") = '';
 					}
 					if(sheetObjects[0].CellValue(nowRow,"cstms_div_id") != formObj.chk_cstms_div_id.value){
 						ComShowMessage("Sheet2's Customs Division ID is Not same as Sheet1's Customs Division ID.");
 			      		sheetObj.CellValue2(i, "cstms_div_id") = '';
 					}
 				}
 			}
      }
    
    /**
     * process when input retrieve keyword
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    }
     
     /**
      * add Row of sheet1 and sheet2
      * @param SheetObj
      * @param sheetNo
      */ 
    function addRow(sheetObj,sheetNo) {
    	  var formObj = document.form;
    	  switch(sheetNo) {
    	  case 1 :
    	  		with (sheetObjects[0]) {
    	  			var nowRow = SelectRow;
    	  			nowRow = DataInsert(-1);
    	  			CellValue2(nowRow, "cnt_cd") = formObj.frm_cnt_cd.value;
    	  			return true;
    	  		}

    	  case 2 :
        	  	with (sheetObjects[1]) {
        	  		var nowRow = SelectRow;
        	  		nowRow = DataInsert(-1);
        	  		CellValue2(nowRow, "cnt_cd") = sheetObjects[0].CellValue(dblRow,"cnt_cd");
        	  		CellValue2(nowRow, "cstms_div_id") = sheetObjects[0].CellValue(dblRow,"cstms_div_id");
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
                 var sRowStr1 = FindCheckedRow("check");
                 var arr1 = sRowStr1.split("|");
                 
                 for (var i=0; i<arr1.length - 1; i++) {
                	  RowStatus(arr1[i]) = "D";
//                     CellValue(arr[i], "dept_cd") = "NONE";
                     RowHidden(arr1[i]) = "true";
                 }
                 return true;
    	 }
    	 case 2 : 
    		 with (sheetObj) {
                 var sRowStr2 = FindCheckedRow("check");
                 var arr2 = sRowStr2.split("|");
                 
                 for (var i=0; i<arr2.length - 1; i++) {
                	  RowStatus(arr2[i]) = "D";
//                     CellValue(arr[i], "dept_cd") = "NONE";
                     RowHidden(arr2[i]) = "true";
                 }
                 return true;
    		 }
    	 }
     }
     
     /*
      * setting key input on the sheet
      */
     function obj_KeyPress(){
         var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
         var srcName = event.srcElement.getAttribute("name");
         var srcValue = event.srcElement.getAttribute("value");
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
    		  if(SheetObj.CellValue(Row,"cnt_cd")!=""&&SheetObj.CellValue(Row,"cstms_div_id")!=""){ 
    			  var formObj = document.form;
    			  var nowRow = SheetObj.SelectRow;
    			  dblRow = nowRow;
    			  formObj.chk_cnt_cd.value = SheetObj.CellValue(nowRow, "cnt_cd");
    			  formObj.chk_cstms_div_id.value = SheetObj.CellValue(nowRow, "cstms_div_id");
    			  doActionIBSheet(SheetObj, formObj, SEARCH01);
    			  dblCnt = 1;
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
      	var formObj = document.form;
      	// checking Country Code validation
      	if(sheetObj.ColSaveName(Col) == "cnt_cd"){
      		formObj.f_cmd.value = SEARCH02;
      		formObj.chk_cnt_cd.value = sheetObj.CellValue(Row, Col);
      		formObj.chk_cstms_div_id.value = sheetObj.CellValue(Row, "cstms_div_id");
      		if(sheetObj.CellValue(Row,"cnt_cd") != "" && sheetObj.CellValue(Row,"cstms_div_id") != ""){
      			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
      			if(document.form.chk_cnt.value == '1'){
	        		  var Msg = formObj.chk_cnt_cd.value + " and " + formObj.chk_cstms_div_id.value;
					  ComShowCodeMessage('BKG03056', Msg);
					  sheetObj.CellValue2(Row, "cnt_cd") = '';
					  sheetObj.CellValue2(Row, "cstms_div_id") = '';
				  }
      		}
      	}
      	
      	// checking Customs Division ID validation
      	if(sheetObj.ColSaveName(Col) == "cstms_div_id"){
      		formObj.f_cmd.value = SEARCH02;
      		formObj.chk_cstms_div_id.value = sheetObj.CellValue(Row, Col);
      		formObj.chk_cnt_cd.value = sheetObj.CellValue(Row, "cnt_cd");
      		if(sheetObj.CellValue(Row,"cnt_cd") != "" && sheetObj.CellValue(Row,"cstms_div_id") != ""){
      			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
      			if(document.form.chk_cnt.value == '1'){
	        		  var Msg = formObj.chk_cnt_cd.value + " and " + formObj.chk_cstms_div_id.value;
					  ComShowCodeMessage('BKG03056', Msg);
					  sheetObj.CellValue2(Row, "cnt_cd") = '';
					  sheetObj.CellValue2(Row, "cstms_div_id") = '';
				  }
      		}
      	} 
      }
