/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0976.js
*@FileTitle  : Invoice Authority
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================**/

	/** Common global variable */
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	/**Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	var	ofcSelected="";
	var	invOfcCdSelected="";
	
	/**Event handler processing by button name */
	function processButtonClick(){
		  /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
	     var sheetObject=sheetObjects[0];
	     var formObject=document.form;
		 try {
			var srcName=ComGetEvent("name");
			switch(srcName){
			 case "btng_save":
				 for(var k=sheetObject.HeaderRows(); k<sheetObject.RowCount()+sheetObject.HeaderRows(); k++)
				 {
					 if (sheetObject.GetCellValue(k, "inv_ofc_cd") == "" || sheetObject.GetCellValue(k, "ofc_cd")== "") {
						 var errMessage=ComGetMsg('COM130403'); 
						 ComShowMessage(errMessage);
						 return;
					 }
				 }
				 var saveRows=sheetObject.FindCheckedRow("sel");
				 var arrRow=saveRows.split("|");
				 if(arrRow.length == 0){
					 var errMessage=ComGetMsg('TRS90215'); 
					 ComShowMessage(errMessage);
					 break;
				 }else     	
					 doActionIBSheet(sheetObject,formObject,IBSAVE);
				 break;
			case "btn_retrieve":
		    	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
	             break;
	 	    case "btns_office": 
	 	    	invOfcCdSelected="Y";
	 	    	ofcSelected="N";
	 	    	if( validation_check()) {
					var inv_ofc_cd=formObject.inv_ofc_cd.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+inv_ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
				}	       
				break;
	 	    case "btng_office"	:
	 	    	ofcSelected="Y";
	 	    	invOfcCdSelected="N";
				if( validation_check1()) {
					var ofc_cd=formObject.ofc_cd.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
		    	}
		    	break;
				case 'btng_rowadd':
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case 'btng_del':
					var vMsg="";
					var saveRows=sheetObject.FindCheckedRow("sel");
		             var arrRow=saveRows.split("|");
						if(arrRow.length == 0){
							var errMessage=ComGetMsg('TRS90215'); 
							ComShowMessage(errMessage);
							break;
						}
						else if(confirm(ComGetMsg("COM12165", vMsg))){
							doActionIBSheet(sheetObject,formObject, IBDELETE);
	           	 }
				 break;	
				case "btn_close":
					ComClosePopup(); 
				break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
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
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//initControl();
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
				      //no support[check again]CLT 					style.height=GetSheetHeight(20) ;
				      //no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				      var HeadTitle1="|status|Invoice Office|Invoice Office|Office|Office|Creation User|Creation Date|Updated User|Updated Date";
				      HeadTitle2="|status|Code|Name|Code|Name|Creation User|Creation Date|Updated User|Updated Date";
				      SetHeaderRowHeight(12);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sel",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Status",    Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"inv_ofc_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"ofc_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				       
				      InitColumns(cols);		
				      SetEditable(1);
				      SetColHidden('ibflag',1);
//				      SetSheetHeight(320);
				      resizeSheet();
		      	}
				break;
		}
	}
	//UI 표준화관련 하단 여백 설정
	function resizeSheet(){
		    ComResizeSheet(sheetObjects[0]);
	}
	//handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
			switch(sAction) {
			        //Office Code retrieve 
			   case IBSEARCH:                      
					formObj.f_cmd.value=SEARCH20; 					
					sheetObj.DoSearch("ESD_TRS_0976GS.do", TrsFrmQryString(formObj) );
					break;
					//input
			   case IBINSERT:      
				   //The default setting after creation
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "cre_usr_id",document.form.hid_cre_usr_id.value.toUpperCase(),0);
					sheetObj.SetCellValue(Row, "cre_dt",document.form.hid_cre_date.value,0);
					sheetObj.SetCellValue(Row, "upd_dt",document.form.hid_cre_date.value,0);
					sheetObj.SetCellValue(Row, "upd_usr_id",document.form.hid_cre_usr_id.value.toUpperCase(),0);
					document.form.hid_cre_usr_id.value=document.form.hid_cre_usr_id.value.toUpperCase();
					sheetObj.SelectCell(Row, "inv_ofc_cd");
				    break;	
			        //save
			   case IBSAVE:        
				   	if(!validateForm(sheetObj, formObj, sAction)) return false;
	        		formObj.f_cmd.value=MULTI;
					var formObject=document.form;
					var sheet1_count=sheetObj.RowCount();
					var row_status="";     
					var k=sheet1_count+1;
					var duple1="";
					var duple2="";
					var save_val="Y";
					var row_val="";
					if(save_val =="Y"){
						formObj.f_cmd.value=MULTI;
						var savexml=sheetObjects[0].DoSave("ESD_TRS_0976GS.do", TrsFrmQryString(formObj),"sel","false","true");
				    }else{
						var errMessage=ComGetMsg('COM12115','Sheet data','','');  
						ComShowMessage(errMessage);
						formObject.sheet1.SelectCell(row_val, 'inv_ofc_cd');
					}
					break;
					//Delete row after selecting
			   case IBDELETE:
					var checkList=sheetObj.FindCheckedRow('sel');
					if(checkList == '') {
						ComShowCodeMessage('COM12176');
						return false;
					}
					var checkArray=checkList.split('|');
					var queryStr=sheetObj.GetSaveString(false, false, "sel");
					formObj.f_cmd.value=REMOVE;
	            	sheetObj.DoSave("ESD_TRS_0976GS.do",TrsFrmQryString(formObj),'sel',false);
					for(var k=checkArray.length-1; k>=0; k--)
					{
						sheetObj.RowDelete(checkArray[k], false);
					}
					break;
			  }	
	    }catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
	}
	/**
	 * Surcharge Input Inquiry popup
	 **/
	function popEdiInquiry(sheetObj,formObj){
		var sheetObj=sheetObjects[0];
		var arrRow='' ;
		var chkRows='' ;
		chkRows=sheetObj.FindCheckedRow("sel");
		arrRow=chkRows.split("|");
		if(arrRow == '' || arrRow.length-1 > 1){
			ComShowMessage("Please select one row");
	       	return;
		}
		var myOption="width=800,height=510,menubar=0,status=0,scrollbars=0,resizable=0";
		var url='ESD_TRS_0976.screen';
		url += '&inv_ofc_cd='+sheetObj.GetCellValue(arrRow, 'inv_ofc_cd');
		url += '&ofc_cd='+sheetObj.GetCellValue(arrRow, 'ofc_cd');
		url += '&cre_ofc_id='+sheetObj.GetCellValue(arrRow, 'cre_ofc_id');
		url += '&cre_usr_id='+sheetObj.GetCellValue(arrRow, 'cre_usr_id');
		url += '&inv_ofc_eng_nm='+sheetObj.GetCellValue(arrRow, 'inv_ofc_eng_nm');
		url += '&ofc_eng_nm='+sheetObj.GetCellValue(arrRow, 'ofc_eng_nm');
		myWin=window.open(url, "popEdiInquiry", myOption);
		myWin.focus();
	    ComOpenWindow(url, 'popEdiInquiry', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:400px', true);
	}
	/**
	 * On-screen input form validation process for the value of processing
	 */
	function validateForm(sheetObj,formObj,sAction){
		return true;
	}
	 function sheet1_OnChange(sheetObj, row, col, value) {
	 	var colName=sheetObj.ColSaveName(col);
	 	var formObj=document.form;
	 	var cmd=formObj.f_cmd.value=SEARCH19;
	 	switch(colName)
	 	{
	 		case ('ofc_cd'):
	 			formObj.ofc_cd.value=formObj.ofc_cd.value.toUpperCase();
	 		    var ofcCd=sheetObj.GetCellValue(row,'ofc_cd',ComTrim(value.toUpperCase()),0);
	 			value=cntrCheckDigit(value);
	        	if(ofcCd!=null)
				{
				value=cntrCheckDigit(value);
				sheetObj.SetCellValue(row, col,value.toUpperCase());
				formObj.f_cmd.value=SEARCH19;			
				}else {
					sheetObj.SetCellValue(row, 'ofc_cd',"",0);
					sheetObj.SetCellValue(row, 'ofc_eng_nm',"",0);
				}
	 			var urlStr='ibflag=R&inv_ofc_cd='+value+'&row='+row+'&col=ofc_eng_nm';
	 			//heetObj.DoRowSearch( ROW,urlStr&TrsFrmQryString(formObj) );
	 			sheetObj.SetCellValue(row, 'sel','1',0);
	 			//var ss=sheetObj.GetEtcData('ofcEngName');
	 			var sXml=sheetObj.GetSearchData('ESD_TRS_0976GS.do',urlStr+'&'+TrsFrmQryString(formObj));
	 		    var ss = ComGetEtcData(sXml,'ofcEngName');
	 			if(ss=="null"||ss==""){
	 		    	ComShowCodeMessage('COM12114', 'office code');
					sheetObj.SetCellValue(row, 'ofc_cd',"",0);
					sheetObj.SetCellValue(row, 'ofc_eng_nm',"",0);
		 		} else {
		 			sheetObj.SetCellValue(row,'ofc_eng_nm',ss,0);
		 		}
	 			break;
	 		case ('inv_ofc_cd'):
	 			formObj.inv_ofc_cd.value=formObj.inv_ofc_cd.value.toUpperCase();
	 		    var invOfcCd=sheetObj.GetCellValue(row,'inv_ofc_cd',ComTrim(value.toUpperCase()),0);
	 			value=cntrCheckDigit(value);
	 		    sheetObj.SetCellValue(row, col,ComTrim(value.toUpperCase()),0);
				if(invOfcCd!=null)
				{   				
					formObj.f_cmd.value=SEARCH19;		
				}else {
					sheetObj.SetCellValue(row, 'inv_ofc_cd',"",0);
					sheetObj.SetCellValue(row, 'inv_ofc_eng_nm',"",0);
				}
	 			var urlStr='ibflag=R&inv_ofc_cd='+value+'&row='+row+'&col=inv_ofc_eng_nm'; 	 			
	 			//sheetObj.DoRowSearch( ROW,urlStr&TrsFrmQryString(formObj) );
	 			//var ss=sheetObj.GetEtcData('ofcEngName');
	 			sheetObj.SetCellValue(row, 'sel','1',0);
	 		    var sXml=sheetObj.GetSearchData('ESD_TRS_0976GS.do',urlStr+'&'+TrsFrmQryString(formObj));
	 		    var ss = ComGetEtcData(sXml,'ofcEngName');
	 			if(ss=="null" || ss==""){
					ComShowCodeMessage('COM12114', 'invoice office code');
					sheetObj.SetCellValue(row, 'inv_ofc_cd',"",0);
					sheetObj.SetCellValue(row, 'inv_ofc_eng_nm',"",0);
	 			}else{
	 				sheetObj.SetCellValue(row, 'inv_ofc_eng_nm',ss,0);
	 			}
	 			break; 	 				
	      }
	 }
	function enterCheck(obj)
	{
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(event.keyCode == 13)
		{
			switch(ComGetEvent("name")) {
				case 'inv_ofc_cd':
					 sheetObj.RemoveEtcData();
					 getTextInvOfcCd(sheetObj, formObj, obj.value);				 
					 break;
				case 'ofc_cd':
					 sheetObj.RemoveEtcData();
					 getTextOfcCd(sheetObj, formObj, obj.value);
					 break;				 
				}		
		}
	}
	//ofc_cd entered into an empty row. DO NOT DELETE
	function importOfcCd(popSheetObj, obj)
	{
		var sheetObj=sheetObjects[0];
		var sheetObj2=sheetObjects[2];
		var checkList=popSheetObj.FindCheckedRow('ibflag');
		var checkArray=checkList.split('|');
		var row=0;
		var value='';
		document.form.f_cmd.value=SEARCH19;
		var queryStr=popSheetObj.GetSaveString(false, false, "ibflag");
		if(queryStr==''){
			return false;
		} 		
		sheetObj2.DoSearch("ESD_TRS_0976GS.do", queryStr+'&'+TrsFrmQryString(document.form),{Append:false} );
		for(var i=0; i<checkArray.length-1; i++){
			if(popSheetObj.GetCellValue(checkArray[i], 'verify_result') != 'OK'){
				var new_row=sheetObj2.DataInsert(-1);
				sheetObj2.SetCellValue(new_row, 'ofc_cd',popSheetObj.GetCellValue(checkArray[i], 'ofc_cd'),0);
			}
		}
		// eq_no to an empty row to enter into an array.
		var emptyEqArray=new Array();
		var cnt=0;
		for(var k=2; k<sheetObj.RowCount()+2; k++)
		{
			if(sheetObj.GetCellValue(k, 'ofc_cd')==''){ 
				emptyEqArray[cnt++]=k;
			}
		}
		cnt=0; //insert the number of data counts.
		var tempEqNo='';
		var loopLength=Math.min(sheetObj2.RowCount(),emptyEqArray.length);
		for(var k=0; k<loopLength;k++)
		{
			sheetObj.SetCellValue(emptyEqArray[k], 'ofc_cd',sheetObj2.GetCellValue(k+1, 'ofc_cd'),0);
			sheetObj.SetCellValue(emptyEqArray[k], 'ofc_eng_nm',sheetObj2.GetCellValue(k+1, 'ofc_eng_nm'),0);
		}
	//	obj.close();
	}
	//Beat the move..
	function value_move(row)
	{	 	
		 var sheet1_count=formObject.sheet1.RowCount();
		 //Inserting a partially colored (modifiable field).
		 for(var t=2; t < sheet1_count+1; t++) {
			check_val=formObject.sheet1.GetRowStatus(t);
			formObject.sheet1.SetCellEditable(t,'inv_ofc_cd',0);
			formObject.sheet1.SetCellEditable(t,'ofc_cd',0);
		 }
		 check_val=formObject.sheet1.GetRowStatus(row);
		    if(check_val=="I"){
		    	formObject.sheet1.SetRowBackColor(row,"#EEFFE2");
		    	formObject.sheet1.SetCellEditable(t,'inv_ofc_cd',1);
		    	formObject.sheet1.SetCellEditable(t,'ofc_cd',1);
		    }	
	    }
		//function to query the invoice office code
	    function getTextInvOfcCd(sheetObj, formObj, inv_ofc_cd) {  
			formObj.f_cmd.value=SEARCH20;
			formObj.inv_ofc_cd.value=lpad(ComTrim(inv_ofc_cd).toUpperCase()); 		    
			sheetObj.DoSearch("ESD_TRS_0976GS.do", TrsFrmQryString(formObj) );
	        return true;
		}
	   //function to query the office code
	    function getTextOfcCd(sheetObj, formObj, ofc_cd) { 
			formObj.f_cmd.value=SEARCH20;
			formObj.ofc_cd.value=lpad(ComTrim(ofc_cd).toUpperCase()); 			
			sheetObj.DoSearch("ESD_TRS_0976GS.do", TrsFrmQryString(formObj) );
		    return true;
		}
	    //office code return value. DO NOT DELETE
	    function rtn_office_code(obj){
		   	if(invOfcCdSelected=="Y") {
		   		document.form.inv_ofc_cd.value=obj;
		   	}else {
		   		document.form.ofc_cd.value=obj;	
		 }	  
	   }
	    //Invoice Office Code-PopUp Validation Checked- DO NOT DELETE
	    function validation_check() {	
	 	var prm_office=doSepRemove(document.form.inv_ofc_cd.value.toUpperCase(), " "); //input text
	 	var aoffice=prm_office.split(",");
	 	if( prm_office == ""){
	 		document.form.inv_ofc_cd.value="";
	 		ComShowMessage("Please input the 'S/O Office'!!");
	 		return false;
	 	}
	    else {
	        if( aoffice.length == 1 ) {
	    	return true;
	 	}
	    else {
	 		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
	 		return false;
		}
	}
	   }
	 //Office Code-PopUp Validation Checked- DO NOT DELETE
	 function validation_check1() {	
	 	var prm_office=doSepRemove(document.form.ofc_cd.value.toUpperCase(), " "); //input text
	 	var aoffice=prm_office.split(",");
	 	if( prm_office == "") {
	 		document.form.inv_ofc_cd.value="";
	 		ComShowMessage("Please input the 'Invoice Office'!!");
	 		return false;
	 	    }
	 	 else {
	 		if( aoffice.length == 1 ) {
	 		return true;
	 	    }
	     else {
	 		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
	 		return false;
	 		}
	 	} 
	 }
	 /**
	  * Handle events that occur after storage
	  */
	 function sheet1_OnSaveEnd(sheetObj, errMsg) {
		 var formObj=document.form;
		 if( errMsg != null && errMsg != '' ) {
			 //ComShowMessage(errMsg);
		 } else {
			 if(formObj.f_cmd.value == MULTI){
			     ComShowCodeMessage('COM130102', 'Invoice Authority');
			 }else if(formObj.f_cmd.value == REMOVE){
				 ComShowCodeMessage('COM12167', 'Invoice Authority');
			 }
		 }
	 }
