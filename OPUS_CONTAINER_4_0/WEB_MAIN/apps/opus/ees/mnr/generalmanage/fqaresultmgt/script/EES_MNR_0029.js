/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0029.js
*@FileTitle  : FQA Result Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="";
	var uploadObjects=new Array();
	var uploadCnt=0;
	//file sequence variable
	var uploadFileSeq="";
	var noClick="";
	//saving status in case of clicking retrieve
	var retrieveClick=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
								break;
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
								break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
								break;
						case "btn_Delete":
							doActionIBSheet(sheetObject1,formObject,IBDELETE);
								break;
						case "btn_vndr":
						    if(noClick!="Y"){
								ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
							}
							break;
						case "btn_yd":
							if(noClick!="Y"){
								ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 540, 'getCOM_ENS_061', "1,0,1,1,1,1,1,1,1,1,1,1", true);
							}
							break;
						case "calendar":
							if(noClick!="Y"){
		                    	var cal=new ComCalendar();
		                    	cal.select(form.fld_aud_dt, 'yyyy-MM-dd');
							}
		                    break;
						case "btn_RowAdd":
							sheet_DataInsert(sheetObject2,'');
								break;
						case "btn_RowDel":
							rowRemove(sheetObject2, "");
								break;
                    } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		MnrWaitControl(true);
    	initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //initializing IBMultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		initUpload();
		
    }
    var pSheetObj, pRow, pCol ;
    
	function initUpload(uploadObj, uploadNo) {
		var prefix = "";
		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do'
 			,Files:[
 			]
 			,BeforeAddFile : function(result){ 

     			return true;
    		}
			,BeforeSaveStatus : function(result){ 
    			var files = result.files;
     			var fileName= files[files.length-1].GetFileName();
     			
    			pSheetObj.SetCellValue(pRow, pCol,fileName,0);
 				pSheetObj.SetCellValue(pRow,  "file_dw",'0',0);
 				var file_seq=pSheetObj.GetCellValue(pRow,  "file_seq");
 				var file_dtl_seq=pSheetObj.GetCellValue(pRow,  "file_dtl_seq");
 				if(file_dtl_seq=="") file_dtl_seq=pRow;
 				var ibflag='U';
 				if(file_seq=="" || uploadFileSeq!="") ibflag='I'; // saving initially, in case of not existing saved file
 				if(file_seq!="" && uploadFileSeq!="") ibflag='U';
 				if(uploadFileSeq != "") {
 					file_seq=uploadFileSeq;
 				}
 		 		var sParam="f_cmd="+COMMAND01;
 		 		sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
 		 		sParam+= "&file_seq=" + file_seq;    // existing File Sequence
 		 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // existing File Sequence
 		 		sParam+= "&org_file_nm=" + fileName; // Fileupload file name
 		 		sParam+= "&ibflag=" + ibflag;        // I : initial File Upload U : File change
 		 		
 		 		paramToForm(sParam);
 		 		
 		 		return true;
    		}
     		,AfterSaveStatus : function(result) {  
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
	 				if(uploadFileSeq != "" && uploadFileSeq != undefined){
	 					var fileXml=SearchFileUpload(sheetObjects[1],uploadFileSeq);
	 					sheetObjects[1].LoadSearchData(fileXml,{Sync:1} );
	 				}
	      		}else {
					ComShowMessage(result.msg);
				}
 			}
	 		,AfterAddFile:function(result){
    			var files = result.files;
     			
     			var fileName= files[files.length-1].GetFileName();
     			pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
 		 		upload1.SaveStatus();
			}
 		});
	}
	
    function sheet2_OnMouseMove(sheetObj, e) {		//sheet1 은 해당 시트  col은 파일 업로드할 컬럼
	  	  var row     = sheetObj.MouseRow(),
	        col     = sheetObj.MouseCol(),
	        info    = null;
	        if (row > 0 &&col == 2) {

	            info = sheetObj.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

				upload1.SetFileUploadElement(info);
	            
	        } 
	}
    
    /**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    switch(comboNo) {
	          case 1:
	           with (comboObj) {
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "80");
				SetColWidth(1, "100");
			   SetDropHeight(160);
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
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                var prefix="sheet1_";
              
	              var HeadTitle1="|Seq.|Sel|Evaluation Summary|Max Point|Point|Remark(s)";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"S",               KeyField:0,   CalcLogic:"",   Format:"" },
	                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ev_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"max_pnt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"N"},
	                     {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pnt_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N|[.]"},
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fld_aud_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fld_aud_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fld_aud_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pnt_calc_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(382);
	              SetEditable(1);
	              SetCountPosition(0);
	              SetSelectionMode(smSelectionRow);
              }
         		  break;
            case "sheet2":
                with(sheetObj){
                var prefix="";
             
	              var HeadTitle1="|Seq.|Attach FQA Detail|Download Attachment";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ 
	                     {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
	                     {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
	                     {Type:"Image",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(150);
	              SetCountPosition(0);
	              SetImageList(0,"img/ico_attach.gif");
	              SetShowButtonImage(1);
              }
             break;
         }
     }
	function initControl() {
	    //Axon handling event1. event catch
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
	    //axon_event.addListenerFormat('focus',   'obj_activate',    form);            
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
		axon_event.addListenerFormat('change',	 'obj_change',	form); 
	}
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	 //registering IBUpload Object as list of uploadObject
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++]=uploadObj;
	}
    /**
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * HTML Control deactivate event <br>
	 **/
	function obj_deactivate(){
	    var formObj=document.form;
		obj=ComGetEvent();
		if(obj.name == "fld_aud_dt"){
			aud_rslt_his.SetSelectCode(formObj.fld_aud_dt.value);
		}
	}
	/**
	 * HTML Control activate event <br>
	 **/
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){		
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(ComGetEvent("value")) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		vndr_seq_confirm();
				   	break;
	    		case "yd_cd":
					yd_cd_confirm();
				   	break;
			}
	    }
	}
 	/**
	 * sheet1 ChangeSum event
	 * @param {IBSheet}  sheetObj
	 * @param {String}  Row
	 */
	function sheet1_OnChangeSum(sheetObj, Row)
	{
		var prefix="sheet1_";
		with(sheetObj)
		{
			SetSumText(0, prefix+ "max_pnt_no",sheet1_ChangeMax(sheetObj));
			sheet1_ChangeSum2(sheetObj);
		}
	}
	/**
	 * sheet1 ChangeMax event
	 * @param {IBSheet}  sheetObj
	 */
	function sheet1_ChangeMax(sheetObj)
	{
		var prefix="sheet1_";
		var arrRow=sheetObj.RowCount();
        var max=0;
        for (idx=1; idx<(arrRow + 1); idx++){
            var row=idx;
            if(sheetObj.GetCellValue(row, prefix+ "del_chk")!="" || sheetObj.GetCellValue(row, prefix+ "del_chk") == null){
            	max +=  eval(sheetObj.GetCellValue(row, prefix+ "max_pnt_no"));
            }
        }
        return max;
	}
	/**
	 * sheet1 ChangeSum2 event
	 * @param {IBSheet}  sheetObj
	 */
	function sheet1_ChangeSum2(sheetObj)
	{
		var formObj=document.form;
		var prefix="sheet1_";
		var arrRow=sheetObj.RowCount();
        var max=0;
        var pnt=0;
        for (idx=1; idx<(arrRow + 1); idx++){
            var row=idx;
            if(sheetObj.GetCellValue(row, prefix+ "del_chk")!="" || sheetObj.GetCellValue(row, prefix+ "del_chk") == null){
            	max +=  eval(sheetObj.GetCellValue(row, prefix+ "max_pnt_no"));
            	pnt +=  eval(sheetObj.GetCellValue(row, prefix+ "pnt_no"));
            }
        }
        var total=MnrMakeRound(eval(pnt*(100/max)),2);
        if(Number(total) != 'NaN')  formObj.total.value=total;
        if(formObj.total.value=='NaN') formObj.total.value='0';
	}
	/* ********* Event Functions ************* */
	/**
	 * sheet1 SaveEnd event
	 * @param {IBSheet}  sheetObj comboObject
	 * @param  {String}    ErrMsg   errorMessage
	 */
	function sheet1_OnSaveEnd(sheetObj,Code, ErrMsg){
		if(retrieveClick=='2'){
			if (ErrMsg == "") {
				ComShowCodeMessage("MNR00020",'');
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}else{
			if (ErrMsg == "") {
				ComShowCodeMessage("MNR00023",'');
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			} else if(ErrMsg.indexOf("MNR00185")<=0){
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
	}
   /**
    * handling OnChange event
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.GetCellValue(Row,"sheet1_del_chk")=="1"){
			// editable
		   	sheetObj.SetCellEditable(Row, 5,1);
		   	sheetObj.SetCellEditable(Row, 6,1);
		}else{
			// not editable
		   	sheetObj.SetCellEditable(Row, 5,0);
		   	sheetObj.SetCellEditable(Row, 6,0);
		   	sheetObj.SetCellValue(Row, "sheet1_pnt_no","",0);
		   	sheetObj.SetCellValue(Row, "sheet1_fld_aud_rmk","",0);
		   	sheetObj.SetRowStatus(Row,"R");
		}
		if(Col == 2){
			sheet1_OnChangeSum(sheetObj, Row);
		}
		if(Col == 5){
			var max=sheetObj.GetCellValue(Row, "sheet1_max_pnt_no");
			var pnt=sheetObj.GetCellValue(Row, "sheet1_pnt_no");
			if(pnt == null || pnt == ""){
				ComShowMessage(ComGetMsg('MNR00167'));
				sheetObj.SelectCell(Row, "sheet1_pnt_no", true);
				return;
			} else if(eval(max) < eval(pnt)){
				ComShowCodeMessage("MNR00166");
				sheetObj.SetCellValue(Row,"sheet1_pnt_no","",0);
				sheetObj.SelectCell(Row, "sheet1_pnt_no", true);
				return;
			}
		}
	}

	/**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Col     	selected Row of sheetObj
     * @param {ibsheet} Col     	selected Col of sheetObj
     * @param {String} 	Value     	file name
     **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	/**
	 * COMBO changing event
	 * @param	{IBMultiCombo}	comboObj	changed comboObject
	 * @param	{Number}		Index_Code	changed combo code
	 * @param	{String}		Text		changed combo name
	 */
	function aud_rslt_his_OnChange(comboObj,oldIndex , oldtext , oldcode , newIndex , Text , Index_Code){
		var sheetObject1=sheetObjects[0];
		var comboValue=Index_Code.split('|');
		var formObj=document.form;
		if(typeof comboValue != "undefined" && comboValue != "") {
      	   formObj.yd_cd.value=comboValue[0];
      	   formObj.fld_aud_dt.value=comboValue[1];
        }
		noClick="Y";
		fieldEnableYN();
		//retrieving
		doActionIBSheet(sheetObject1,formObj,IBSEARCH);
	}
	// handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
          case IBSEARCH:      //retrieving
        	  if(validateForm(sheetObj,formObj,sAction)){
	               formObj.f_cmd.value=SEARCH;
				    retrieveClick=1;
	    		    var aryPrefix=new Array("sheet1_", "");
	    		    var sXml=sheetObj.GetSearchData("EES_MNR_0029GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
					sheetObjects[0].RenderSheet(0);
					if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					for(var i=1 ; i <= sheetObjects[0].RowCount(); i ++){
						 sheetObjects[0].SetCellEditable(i,1,0);
						 sheetObjects[0].SetCellEditable(i,3,0);
						 sheetObjects[0].SetCellEditable(i,4,0);
						 sheetObjects[0].SetCellEditable(i,5,0);
						 sheetObjects[0].SetCellEditable(i,6,0);
						 if(sheetObjects[0].GetCellValue(i, 5) != "" ){
							 sheetObjects[0].SetCellValue(i, 2,'1',0);
							 sheetObjects[0].SetCellEditable(i,5,1);
							 sheetObjects[0].SetCellEditable(i,6,1);
						 }
					 }
				    //sheet1_ChangeSum(sheetObj);
					sheet1_OnChangeSum(sheetObj, 0);
					sheetObjects[0].RenderSheet(1);
					//checking whether saving after retrieving
					formObj.key_value.value=ComGetNowInfo();
        	  }
              break;
          case IBSAVE:        //saving
        	  if(validateForm(sheetObj,formObj,sAction)){
		            formObj.f_cmd.value=MULTI;
	                //2.bind IBSheet data to QueryString
					var sParam=ComGetSaveString(sheetObjects);
					if (sParam == "") return;
	                //3.bind Form data to QueryString
					var aryPrefix=new Array("sheet1_", "");
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					//4. Request to the server to pass, response receiving
					var sXml=sheetObj.GetSaveData("EES_MNR_0029GS.do", sParam);
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[0].LoadSaveData(arrXml[0]);
	                if (arrXml.length > 1) sheetObjects[1].LoadSaveData(arrXml[1]);
 					audit_result_history_search();
					noClick="";
					fieldEnableYN();
        	    }
	            break;
          case IBCLEAR:      // new
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
        	    formObj.reset();
        	    form.fld_aud_dt.value=ComGetNowInfo();
        	    //initializing retrieve button
				retrieveClick=0;
				//initializing sheet
				 for(i=0;i<sheetObjects.length;i++){
			            sheetObjects[i].RemoveAll();
			     }
				 //initializing Combo Data
				 for(var i=0; i < comboObjects.length;i++){
			 		 comboObjects[i].RemoveAll();
			     }
				//====================================================================
				//calling common code
				//====================================================================
				 var arrXml=MnrComSearchGrid(sheetObjects[0],"com_code_search_ind");
				 sheetObjects[0].RenderSheet(0);
				 sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				 //end
				 for(var i=1 ; i <= sheetObjects[0].RowCount(); i ++){
					 sheetObjects[0].SetCellEditable(i,1,0);
					 sheetObjects[0].SetCellEditable(i,3,0);
					 sheetObjects[0].SetCellEditable(i,4,0);
					 sheetObjects[0].SetCellEditable(i,5,0);
					 sheetObjects[0].SetCellEditable(i,6,0);
				 }
				 form.fld_aud_dt.value=ComGetNowInfo();
				 sheetObjects[0].RenderSheet(1);
				 noClick="";
				 uploadFileSeq="";
				 formObj.key_value.value="";
				 fieldEnableYN();
				MnrWaitControl(false);
               break;
          case IBDELETE:      // deletion
        	  if(validateForm(sheetObj,formObj,sAction)){
	        	    formObj.f_cmd.value=REMOVE;
	        	    retrieveClick=2;
	        	    var sParam=ComGetSaveString(sheetObjects);
				    // if (sParam == "") return;
			    	var prefix='sheet1_';
			    	var aryPrefix=new Array("sheet1_", "");
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					//4. Request to the server to pass, response receiving
					var sXml=sheetObj.GetSaveData("EES_MNR_0029GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					sheetObjects[1].LoadSaveData(sXml);
        	   
		        	//clear
		        	formObj.reset();
		        	form.fld_aud_dt.value=ComGetNowInfo();
		        	//initialing retrieve buttion
					retrieveClick=0;
					//initializing sheet
					 for(i=0;i<sheetObjects.length;i++){
					        sheetObjects[i].RemoveAll();
					 }
					 //initializing Combo Data
					 for(var i=0; i < comboObjects.length;i++){
						 comboObjects[i].RemoveAll();
					 }
					 //====================================================================
					 //calling common code
					 //====================================================================
					 var arrXml=MnrComSearchGrid(sheetObjects[0],"com_code_search_ind");
					 sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					 //end
					 for(var i=1 ; i <= sheetObjects[0].RowCount(); i ++){
						 sheetObjects[0].SetCellEditable(i,1,0);
						 sheetObjects[0].SetCellEditable(i,3,0);
						 sheetObjects[0].SetCellEditable(i,4,0);
						 sheetObjects[0].SetCellEditable(i,5,0);
						 sheetObjects[0].SetCellEditable(i,6,0);
					 }
					 noClick="";
					 fieldEnableYN();
        	  }
        	 break;
         }
         sheetObj.ShowDebugMsg(false);
     }
    /**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants       */
    function validateForm(sheetObj,formObj,sAction){
    	var prefix="sheet1_";
    	switch (sAction) {
	 	    case IBSEARCH: // retrieving
				if(formObj.vndr_seq.value == "" || formObj.vndr_seq.value == null) {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00003'));
					return;
				} else if(formObj.fld_aud_dt.value == "") {
					ComAlertFocus(formObj.fld_aud_dt, ComGetMsg('MNR00003'));
					return;
    	        }
				break;
	 	    case IBSAVE: // saving
				if(retrieveClick=='0' && (formObj.vndr_seq.value == "" || formObj.vndr_seq.value == null)) {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00003'));
					return;
				} else if(retrieveClick=='0' && formObj.fld_aud_dt.value == "") {
					ComAlertFocus(formObj.fld_aud_dt, ComGetMsg('MNR00003'));
					return;
				}else if(formObj.yd_cd.value == "") {
					ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00003'));
					return;
				}else if(!sheetObjects[0].FindStatusRow("I|U") && sheetObjects[1].FindStatusRow("I|U")){
					ComShowMessage(ComGetMsg('MNR00167'));
					return;
				}else if(formObj.yd_cd.value != null || formObj.yd_cd.value != ""){
					 var aaa=formObj.yd_cd.value;
					 var bbb=formObj.vndr_seq.value;
				    for (var idx=1; idx <= sheetObj.RowCount(); idx++){
				    	if(sheetObj.GetCellValue(idx,"sheet1_del_chk") == '1'){
				        	sheetObj.SetCellValue(idx,"sheet1_yd_cd",aaa,0);
				        	sheetObj.SetCellValue(idx,"sheet1_vndr_seq",bbb,0);
							sheetObj.SetCellValue(idx,"sheet1_fld_aud_dt",form.fld_aud_dt.value,0);
							sheetObj.SetCellValue(idx,"sheet1_ofc_cd",formObj.ofc_cd.value,0);
							sheetObj.SetCellValue(idx,"sheet1_pnt_calc_flg",'Y',0);
				        }
				    }
				}
				for (idx=1; idx <= sheetObj.RowCount(); idx++){
					if(sheetObj.GetCellValue(idx,"sheet1_del_chk") == '1'){
						var max=sheetObj.GetCellValue(idx, "sheet1_max_pnt_no");
						var pnt=sheetObj.GetCellValue(idx, "sheet1_pnt_no");
						if(pnt == null || pnt == ""){
							ComShowMessage(ComGetMsg('MNR00167'));
							sheetObj.SelectCell(idx, "sheet1_pnt_no", true);
							return;
						} else if(eval(max) < eval(pnt)){
							ComShowCodeMessage("MNR00166");
							sheetObj.SetCellValue(idx,"sheet1_pnt_no","",0);
							sheetObj.SelectCell(idx, "sheet1_pnt_no", true);
							return;
						}
						if(uploadFileSeq!=""){
							sheetObj.SetCellValue(idx, "sheet1_file_seq",uploadFileSeq);
						}
					}
				}
			    break;
	 	    case IBDELETE: // deletion
	 	    	if(!ComShowCodeConfirm("MNR00026")){return false;} //checking whether saving or not saving
				if(retrieveClick=='0' && formObj.vndr_seq.value == "") {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00027'));
					return;
				}else if(retrieveClick=='0' && formObj.fld_aud_dt.value == "") {
					ComAlertFocus(formObj.fld_aud_dt, ComGetMsg('MNR00027'));
					return;
				}else if(retrieveClick=='0' && formObj.yd_cd.value == "") {
					ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00027'));
					return;
				}else if(sheetObj.GetCellValue(1,prefix + "cre_usr_id")!= formObj.usr.value){
					ComShowMessage(ComGetMsg('MNR00168'));
					return;
    	        }else{
					var sRow=sheetObj.FindStatusRow("R");
					var prefix="sheet1_";
			        var arrRow=sRow.split(";");
			        for (idx=0; idx<(arrRow.length - 1); idx++){
			            var row=arrRow[idx];
						sheetObj.SetRowStatus(row,"D");
			        }
				}
			    break;
   	    }
   	    return true;
    }
	function fieldEnableYN(){
		var formObj=document.form;
		if(noClick=="Y"){
			MnrFormSetReadOnly(formObj,true,"vndr_seq|fld_aud_dt|yd_cd");
		}else{
			MnrFormSetReadOnly(formObj,false,"vndr_seq|fld_aud_dt|yd_cd");
		}
	}
	/**
	 * checking whether vndr_seq exists or not
	 */
	function vndr_seq_confirm(){
		var formObj=document.form;
		if(formObj.vndr_seq.value != "" && noClick!="Y"){
			//retrieving service provider
			var sCondition=new Array (
				new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
			)
			//setting in case of existing retrieving result
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			if(comboList[0] != null){
				var tempText=comboList[0][0].split("|");
				formObj.vndr_lgl_eng_nm.value=tempText[1];
				audit_result_history_search();
			} else {
				ComShowCodeMessage("MNR00005", "Service Provider");
				ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}
		}
	}
	/**
	 * checking whether yd_cd exists or not
	 */
	function yd_cd_confirm(){
		var formObj=document.form;
		if(formObj.yd_cd.value != "" && noClick!="Y"){
			var retArray=MnrGeneralCodeCheck(sheetObjects[0],"YARD",formObj.yd_cd.value);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",formObj.yd_cd.value);
				formObj.yd_cd.value="";
				formObj.yd_cd.focus();
			}else{
				return;
			}
		}
	}
	function rowRemove(sheetObj, prefix) {
		if(sheetObj.FindCheckedRow(prefix + "del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	/**
	 * COM_ENS_061 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
   	 var formObj=document.form;
	   if(aryPopupData[0][3] != null && aryPopupData[0][3] != ""){
		   formObj.yd_cd.value=aryPopupData[0][3];
	   }
   }
    /**
     * getCOM_ENS_0C1 receiving function values ​​from Pop-up
	 * @param	{String[][]}	aryPopupData	return value from pupup
     */
    function getCOM_ENS_0C1(aryPopupData, row, col, sheetIdx){
	   		var formObj=document.form;
	   	var vndrSeq="";
	   	var vndrNm="";
	   	var i=0;
	   	for(i=0; i < aryPopupData.length; i++){
		   	vndrSeq=vndrSeq + aryPopupData[i][2];
		   	if(aryPopupData.length == 1){
		    	vndrNm=vndrNm + aryPopupData[i][4];
		   	}
		   	if(i < aryPopupData.length - 1){
		   		vndrSeq=vndrSeq + ",";
		   	}
	   	}
	   	formObj.vndr_seq.value=vndrSeq;
	   	formObj.vndr_lgl_eng_nm.value=vndrNm;
		audit_result_history_search();
    }
	/**
	 * retrieving audit_result_history <br>
	 **/
	function audit_result_history_search() {
		var formObj=document.form;
      	//initializing Combo Data
	    for(var i=0; i < comboObjects.length;i++){
	 		 comboObjects[i].RemoveAll();
	   	}
	   	// retrieving combo
		var sCondition=new Array (
			new Array("MnrFldQltyAudRslt",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.ofc_cd.value,"COMMON")
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
 		if(comboList[0] != null){
 			for(var j=0; j < comboList[0].length;j++){
 				aud_rslt_his.InsertItem(j, comboList[0][j] ,comboList[0][j] );
 			}
 		}
 		aud_rslt_his.SetSelectCode("",false);
	}
    /**
     * adding row to tab of IBSheet. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	variable prefix
     * @param {String} 	flag   		Row Add/Row Ins
     * @return {nothing}
     **/
	function sheet_DataInsert(sheetObj,prefix){
		var prefix="";
		uploadFileSeq=sheetObj.GetCellValue(1,prefix + "file_seq");
		if(uploadFileSeq==undefined || uploadFileSeq == -1){
			uploadFileSeq="";
		}
		var row=sheetObj.GetSelectRow();
		var col=sheetObj.GetSelectCol();
		for(i=1;i<=sheetObj.RowCount();i++){
			if (sheetObj.GetCellValue(i,prefix + "org_file_nm")==""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(i,prefix + "org_file_nm");
				return;
			}
		}
		var row=sheetObj.DataInsert(-1);
	}
	
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	sheetObj.SetSumText(1, "TOTAL");
    	sheet1_OnChangeSum(sheetObj, 0);
    	ComOpenWait(false);
    }
