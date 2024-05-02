/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0223.js
*@FileTitle  : FQA Result Detail Pop Up 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

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
//handliing S/Provider,Yard,audit Date does not change after retrieving  audit Result History combo
var noClick="";
// saving status in case of clicking retrieve button
var retrieveClick=0;
// Event handler processing by button click event
document.onclick=processButtonClick;

	// Event handler processing by button name
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
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
								break;
						case "btn_Close":
							ComClosePopup(); 
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
		vndr_seq_confirm();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//initUpload();
    }
    
    /* var pSheetObj, pRow, pCol ;
   function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do',
 			Files:[
 				
 			],
 			LimitFileCount:1,
 			AfterSaveStatus : function(event) {  
 				sheetObj.CellValue2(Row, "file_seq")= ComGetEtcData(sXml,"seqValue");
 			}
	 		,AfterAddFile:function(){
 				var fileName="TESTFILE";  // (이벤트 가이드 예정); 추후 함수 제공
 				pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
 				pSheetObj.SetCellValue(pRow, pCol,fileName,0);
 				pSheetObj.SetCellValue(pRow, 'file_dw','0',0);
 				var file_seq=pSheetObj.GetCellValue(pRow, 'file_seq');
 				var file_dtl_seq=pSheetObj.GetCellValue(pRow, 'file_dtl_seq');
 				if(file_dtl_seq=="") file_dtl_seq="1";
 				var ibflag='U';
 				if(file_seq=="") ibflag='I';
 	 			var sParam="f_cmd="+COMMAND01;
 	 			sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
 	 			sParam+= "&file_seq=" + file_seq;    // Existed file sequence
 	 			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // Existed file sequence
 	 			sParam+= "&org_file_nm=" + fileName; // Fileupload file name
 	 			sParam+= "&ibflag=" + ibflag;        // I : First time file upload, U : modify file
 				upload1.SaveStatus();
			}
 		});
 	}
    function sheet1_OnMouseMove(sheetObj, e) {
	  	  var row     = sheet1.MouseRow(),
	        col     = sheet1.MouseCol(),
	        info    = null;
	        if (row > 0 &&col == 5) {
	           
	            info = sheet1.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	            
	        } 
	  }*/
	
    /**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
		var formObject=document.form
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
                	var HeadTitle1="|Seq.|Evaluation Summary|Max Point|Point|Remark(s)";
                	var headCount=ComCountHeadTitle(HeadTitle1);

                	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"S",               KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ev_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Integer",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"max_pnt_no",      KeyField:0,   CalcLogic:"",   Format:"Integer",      PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pnt_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fld_aud_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fld_aud_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fld_aud_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pnt_calc_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
                	InitColumns(cols);

                	SetEditable(1);
                	SetCountPosition(0);
                	SetColProperty(0, prefix + "max_pnt_no", {AcceptKeys:"N|[-]"});
                	SetColProperty(0, prefix + "pnt_no", {AcceptKeys:"N|[-]"});
                	SetSelectionMode(smSelectionRow);

                	SetSheetHeight(382);
            	}
                break;
            case "sheet2":
            	with(sheetObj){
            		var prefix="sheet2_";
            		var HeadTitle1="|Seq.|Attach FQA Detail|Download Attachment";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
            	             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
            	             {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
            	             {Type:"Image",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	 
            		InitColumns(cols);

            		SetEditable(1);
            		SetCountPosition(0);
            		SetImageList(0,"img/ico_attach.gif");
            		SetShowButtonImage(1);
            		SetSheetHeight(82);
            	}
            	break;
        }
    }
    
	function initControl() {
	    //Axon handling event1. event catch
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
	//    axon_event.addListenerFormat('focus',   'obj_activate',    form);            
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
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
		obj=event.srcElement;
		if(obj.name == "fld_aud_dt"){
		    var formObject=document.form;
			formObject.combo1.SetSelectCode(document.form.fld_aud_dt.value);
		}
	    ComChkObjValid(event.srcElement);
	}
	
	/**
	 * HTML Control activate event <br>
	 **/
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
	
	function obj_change(){
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		vndr_seq_confirm();
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;
	    		case "yd_cd":
					yd_cd_confirm();
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;
			}
	    }
	}
	
	/**
	 * HTML Control keypress event <br>
	 **/
	function obj_keypress(){
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
	            if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				}else{
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}
	
	/**
	 * COMBO changing event
	 * @param	{IBMultiCombo}	comboObj	changed comboObject
	 * @param	{Number}		Index_Code	changed combo code
	 * @param	{String}		Text		changed combo name
	 */
	function combo1_OnChange(comboObj, oldindex , ooldtext , oldcode, newindex , Text , Index_Code){
		var sheetObject1=sheetObjects[0];
		var comboValue=Index_Code.split('|');
		var formObj=document.form;
		if(typeof comboValue != "undefined" && comboValue != "") {
      	   formObj.yd_cd.value=comboValue[0];
      	   formObj.fld_aud_dt.value=comboValue[1];
        }
		noClick="Y";
		fieldEnableYN();
		//Retrive
		doActionIBSheet(sheetObject1,formObj,IBSEARCH);
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
			//parameter changed[check again]CLT
			SetSumText(0, prefix+ "max_pnt_no",sheet1_ChangeMax(sheetObj));
			SetSumText(0, prefix+ "S", "TOTAL");
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
            if(sheetObj.GetCellValue(row, prefix+ "pnt_calc_flg")!=""){
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
		var prefix="sheet1_";
		var arrRow=sheetObj.RowCount();
        var max=0;
        var pnt=0;
        for (idx=1; idx<(arrRow + 1); idx++){
            var row=idx;
            if(sheetObj.GetCellValue(row, prefix+ "pnt_calc_flg")!=""){
            	max +=  eval(sheetObj.GetCellValue(row, prefix+ "max_pnt_no"));
            	pnt +=  eval(sheetObj.GetCellValue(row, prefix+ "pnt_no"));
            }
        }
        var total=MnrMakeRound(eval(pnt*(100/max)),2);
        var formObj=document.form;
        if(Number(total) != 'NaN')  formObj.total.value=total;
        if(formObj.total.value=='NaN') formObj.total.value='0';
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
		var prefix="sheet2_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	
	// handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
          case IBSEARCH:      //retrieving
        	  if(validateForm(sheetObj,formObj,sAction)){
	               formObj.f_cmd.value=SEARCH;
				    retrieveClick=1;
	    		    var aryPrefix=new Array("sheet1_", "sheet2_");
//parameter changed[check again]CLT
	    		    var sXml=sheetObj.GetSearchData("EES_MNR_0223GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
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
					//checking whether saving after retrieving
					formObj.key_value.value=ComGetNowInfo();
        	  }
              break;
          case IBCLEAR:      // new
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
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
				 uploadFileSeq="";
				 fieldEnableYN();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
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
   	    }
   	    return true;
    }
    
 	//handling S/Provider,Yard,audit Date does not change only audit Result History combo  
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
			var sCondition=new Array (
			 	new Array("MdmVendor",formObj.vndr_seq.value,"COMMON"), //retrieving service provider
				new Array("MnrFldQltyAudRslt",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.ofc_cd.value,"COMMON") //retrieving audit_result_history
			)
			//setting in case of existing retrieving result
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			//setting combo
			for(var i=0; i < comboList.length;i++){
				if(comboList[i] != null){
					//initializing sheetCombo
					sheetComboText="";
					sheetComboCode="";
					for(var j=0; j < comboList[i].length;j++){
						var tempText=comboList[i][j].split("|");
						//retrieving service provider
						if(i==0) {
							formObj.vndr_lgl_eng_nm.value=tempText[1];
						//retrieving audit_result_history
						}else if(i==1){
							comboObjects[0].InsertItem(j, comboList[i][j] ,comboList[i][j] );
						}
					}
					comboObjects[0].SetSelectCode("",false);
				}else{
					if(i==0) {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
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
	
	/**
	 * retrieving audit_result_history <br>
	 **/
	function audit_result_history_search() {
		var formObj=document.form;
	   	// retrieving combo
		var sCondition=new Array (
			new Array("MnrFldQltyAudRslt",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.ofc_cd.value,"COMMON")
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
      	//initializing Combo Data
	    for(var i=0; i < comboObjects.length;i++){
	 		 comboObjects[i].RemoveAll();
	   	}
		for(var i=0; i < comboList.length;i++){
	 		if(comboList[i] != null){
	 			for(var j=0; j < comboList[i].length;j++){
	 				comboObjects[i].InsertItem(j, comboList[i][j] ,comboList[i][j] );
	 			}
	 		}
	 		comboObjects[i].SetSelectCode("",false);
	 	}
	}
