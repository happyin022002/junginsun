/*=========================================================
* **Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0726.js
*@FileTitle  : Group Update for B/L Issue And Onboard Date
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   	/* Developer Work	*/
	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
    var intervalId;
    var intervalTime = 2000;
    var processCnt = 0;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					case "btn_New":
						sheetObject1.RemoveAll();
						formObject.reset();
					break;
					case "btn_Save":
						formObject.chkd_iss.value='N';
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
//					case "btn_SaveIssue":
					case "btn_Issue":
						// Check Issue Date!!
						var arr=ComFindText(sheetObject1, "sel", 1);
						var issBkg = "";
						var msgIssBkg = "";
						
						for(i=0; i<arr.length; i++){
							if("Y"==sheetObject1.GetCellValue(arr[i], "obl_iss_flg")){
								sheetObject1.SetCellValue(arr[i], "sel", 0);
								issBkg += sheetObject1.GetCellValue(arr[i], "bkg_no")+",";
							}
						}
						msgIssBkg = issBkg.substr(0,issBkg.length-1);
						if("" != msgIssBkg){
							ComShowMessage(ComGetMsg('BKG02124',msgIssBkg));
						}
						
						arr=ComFindText(sheetObject1, "sel", 1);
						if(arr.length == 0){
							ComShowMessage(ComGetMsg('BKG00249'));
							return;
						}
						
						for (i=0; i<arr.length; i++) {
//							if(sheetObject1.GetCellValue(arr[i], "obl_iss_dt_sd") == '' || sheetObject1.GetCellValue(arr[i], "bl_obrd_dt_sd") == ''){
							if((sheetObject1.GetCellValue(arr[i], "obl_iss_dt") == '' && sheetObject1.GetCellValue(arr[i], "obl_iss_dt_sd") == '')
									|| (sheetObject1.GetCellValue(arr[i], "bl_obrd_dt") == '' && sheetObject1.GetCellValue(arr[i], "bl_obrd_dt_sd") == '')){
//								ComShowMessage(ComGetMsg("COM12193", "Issue Date (should) and Onboard Date (should)"));
								ComShowMessage(ComGetMsg("COM12193", "Issue Date and Onboard Date\n(Now or Should)"));
								return;
							}
						}		
						
						formObject.chkd_iss.value='Y';
//						var arr=ComFindText(sheetObject1, "sel", 1);
//						for (i=0; i<arr.length; i++) {
//							sheetObject1.SetCellValue(arr[i], "obl_iss_flg",'Y',0);
//						}
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					case "btn_DownExcel":
						sheetObject1.Down2Excel({ SheetDesign:1,HiddenColumn:-1 });
					break;
					case "btn_Print":
						var url="ESM_BKG_0889.do";
						ComOpenWindowCenter(url, "ESM_BKG_0889", 400, 300, false);
					break;
					case "btn_Select":
						var sRowStr=sheetObject1.GetSelectionRow("|");
						//alert("sRowStr : " + sRowStr);
						var arr=sRowStr.split("|");
						for (i=0; i<arr.length; i++) {
							//if(arr[i] == '') continue;
							var rlsFlg=sheetObject1.GetCellValue(arr[i], "obl_rlse_flg");
							if(rlsFlg == 'Y'){
								ComShowMessage(ComGetMsg('BKG00328'));
								continue;
							}else{
								sheetObject1.SetCellValue(arr[i], "sel",1,0);
							}
						}
					break;
					case "btn_Deselect":
						var sRowStr=sheetObject1.GetSelectionRow("|");
						var arr=sRowStr.split("|");
						for (i=0; i<arr.length; i++) {
							sheetObject1.SetCellValue(arr[i], "sel",0,0);
						}
					break;
					case "btn_AdjustDate":
						var selRows=sheetObject1.FindCheckedRow("sel");
						if(selRows == ""){
							ComShowMessage(ComGetMsg('BKG00323'));
						} else {
							var eta=formObject.act_arr_dt.value;
							var etd=formObject.act_dep_dt.value;
							if(eta == '' || etd == ''){
								alert("ETA/ETD 필요함!!");
								return;
							}
							var callbackFunc="callbackAdjustDate";
							var url="ESM_BKG_0740.do?func=" + callbackFunc + "&eta=" + eta + "&etd=" + etd;
							//alert(url);
							ComOpenWindowCenter(url, "ESM_BKG_0740", 500, 330, true);
						}
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		// set init data
		if(document.form.vvd.value != '' && document.form.pol_cd.value != '') {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		// add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
		axon_event.addListenerForm('blur', 'form1_blur', document.form);
		//axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
//	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
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
						var HeadTitle1="|Seq.||BKG No.|B/L No.|B/L TYPE|Issue|Release|SHIPPER CD|SHIPPER NAME|On Board Date|On Board Date|On Board Date|B/L Issue Date|B/L Issue Date|B/L Issue Date|B/L Issue Date|PPD";
						var HeadTitle2="|Seq.||BKG No.|B/L No.|B/L TYPE|Issue|Release|SHIPPER CD|SHIPPER NAME|Type|Now|Should|Now|Should|AT|BY|PPD";
						var headCount=ComCountHeadTitle(HeadTitle1);
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"CheckBox", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"sel",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:100,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:100,   Align:"Left",    ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bl_iss_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"obl_rlse_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_dt_sd",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_dt_sd",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"credit_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
						 ];
						   
						InitColumns(cols);
						SetSheetHeight(480);
						SetEditable(1);
//						SetCountPosition(2);
						SetEditableColorDiff(0);
						SetAutoRowHeight(0);
					}
				break;
			}
	}
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0726GS.do", FormQueryString(formObj) );

				}
			break;
			case IBSAVE:        //save
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					ComOpenWait(true);
					//sheetObj.DoSave("ESM_BKG_0726GS.do", FormQueryString(formObj), -1, false, true);
					var sParam=FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1=sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}					
					var rXml=sheetObj.GetSaveData("ESM_BKG_0726GS.do", sParam);
					var arrXml = rXml.split("|$$|");
					if (ComGetEtcData(arrXml[0], "jobID")) {
						ComSetObjValue(formObj.backendjob_key, ComGetEtcData(arrXml[0], "jobID"));
			            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
					} else {  //backendJob 호출 실패
						ComOpenWait(false);
					}
				}
			break;
			
			case SEARCH02:
		    	ComSetObjValue(formObj.f_cmd,SEARCH01);
		    	params = FormQueryString(formObj);
		    	var sXml = sheetObj.GetSearchData("ESM_BKG_0726GS.do", params);
		    	var arrXml = sXml.split("|$$|");
				var jobState = ComGetEtcData(arrXml[0], "JB_STS_FLG");
				if ("3"==jobState) {  // BackEndJob 성공
					clearInterval(intervalId);
		            doActionIBSheet(sheetObj, document.form, SEARCH03);  // BackEndJob 결과 조회
				} else if ("4"==jobState) {  // BackEndJob 실패
					clearInterval(intervalId);
					ComOpenWait(false);
					ComShowMessage(ComResultMessage(arrXml[0]));

					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				} else if ("5"==jobState) {  // 이미 BackEndJob 결과 파일을 읽었습니다.
					clearInterval(intervalId);
					ComOpenWait(false);
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}

   				break;
   				
   			case SEARCH03: // BackEndJob 결과 조회
		    	ComSetObjValue(formObj.f_cmd,SEARCH02);
		    	
		    	params = FormQueryString(formObj);
		    	var rXml = sheetObj.GetSearchData("ESM_BKG_0726GS.do", params);
		    	var arrXml = rXml.split("|$$|");
		    	if ("Y" == ComGetEtcData(arrXml[0], "result")) {
		    		clearInterval(intervalId);
					ComOpenWait(false);
					if(formObj.chkd_iss.value == 'Y'){
						ComShowMessage(ComGetMsg("BKG02123"));		//What you selected is issued successfully.
					}
					sheetObj.LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
					// show message
					ComShowMessage(ComGetMsg("BKG00166"));			//Data Saved Successfully!!
		    	} else {
		    		clearInterval(intervalId);
					ComOpenWait(false);
					var result = ComGetEtcData(arrXml[0], "result").split("<||>");
					ComShowMessage(result[3]);
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
		    	break;			
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSEARCH:      //retrieve
				with(formObj){
					if(vvd.value == '' || vvd.value.length != 9){
						ComShowMessage(ComGetMsg('BKG00320'));
						vvd.focus();
						return false;
					}
					if(pol_cd.value == '' || pol_cd.value.length != 5){
						ComShowMessage(ComGetMsg('BKG00321'));
						pol_cd.focus();
						return false;
					}
					if(!ComIsNull(formObj.shipper_cd)){
						if(!ComIsNumber(shipper_cd.value.substr(2,6))){
				 			ComShowCodeMessage("BKG00340");
							//formObj.shipper_cd.focus();
							return false;
						}
					}
				}
			break;
			case IBSAVE:        //save
				with(formObj){
					if(vvd.value == '' || vvd.value.length != 9){
						ComShowMessage(ComGetMsg('BKG00320'));
						vvd.focus();
						return false;
					}
					if(pol_cd.value == '' || pol_cd.value.length != 5){
						ComShowMessage(ComGetMsg('BKG00321'));
						pol_cd.focus();
						return false;
					}
				}
			break;
        }
        return true;
    }
	/* ----------------------------------------------------------------------------
	 * Event handling
	 -----------------------------------------------------------------------------*/
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
	function form1_blur(){
		//ComChkObjValid(event.srcElement);
	}
//	function form1_keypress(){
//		if (ComGetEvent("type") == "text" && event.keyCode == 13 ) {
//   			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			//ComKeyEnter("search");
//		}
//		switch(ComGetEvent("dataformat")){
//			case "ymd":
//				ComKeyOnlyNumber(ComGetEvent());
//				break;
//			case "ym":
//			case "yw":
//			case "jumin":
//			case "saupja":	//number + "-"
//				ComKeyOnlyNumber(ComGetEvent(), "-"); 
//			break;
//			case "hms":
//			case "hm":		//number + ":"
//				ComKeyOnlyNumber(ComGetEvent(), ":"); 
//			break;
//			case "int":		//number
//				ComKeyOnlyNumber(ComGetEvent()); 
//			break;
//			case "float":	//number+"."	            
//				ComKeyOnlyNumber(ComGetEvent(), "."); 
//			break;	    
//			case "engup":
//				ComKeyOnlyAlphabet("upper");
//			break;
//			case "engupnum":
//				ComKeyOnlyAlphabet("uppernum");
//			break;
//			case "engupnumspc":
//				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
//				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//				if(keyValue >= 97 && keyValue <= 122){                 
//                	event.keyCode=keyValue + 65 - 97;
//				}
//				//event.returnValue = true;
//			break;
//		}			
//	}
	function form1_change(){
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "ob_date":
			break;
		}
	}
	function callbackAdjustDate(ob_date, issue_date, ussue_at, ussue_by, credit_chk){
		//alert(ob_date+"\n"+issue_date+"\n"+ussue_at+"\n"+ussue_by+"\n"+credit_chk);
		var sheetObj=sheetObjects[0];
		var selRows=sheetObj.FindCheckedRow("sel");
		var idxArr=selRows.split("|");
		for(ix=0;ix<idxArr.length;ix++){
			if(idxArr[ix] == '') continue;
			//alert(idxArr[ix] + ". " + sheetObj.CellValue(idxArr[ix], "bl_obrd_dt_sd") + " " + sheetObj.CellValue(idxArr[ix], "obl_iss_dt_sd") + " " + sheetObj.CellValue(idxArr[ix], "obl_iss_ofc_cd") + " " + sheetObj.CellValue(idxArr[ix], "obl_iss_usr_id"));
			if(ob_date != '')    sheetObj.SetCellValue(idxArr[ix], "bl_obrd_dt_sd",ob_date,0);
			if(issue_date != '') sheetObj.SetCellValue(idxArr[ix], "obl_iss_dt_sd",issue_date,0);
			if(ussue_at != '')   sheetObj.SetCellValue(idxArr[ix], "obl_iss_ofc_cd",ussue_at,0);
			if(ussue_by != '')   sheetObj.SetCellValue(idxArr[ix], "obl_iss_usr_id",ussue_by,0);
			if(credit_chk != '') sheetObj.SetCellValue(idxArr[ix], "credit_chk",credit_chk,0);
		}
		//alert(idxArr.length + " lines OK ");
	}
	
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
	    var formObj=document.form;
		formObj.act_arr_dt.value=(sheetObj.GetEtcData("act_arr_dt")==undefined || sheetObj.GetEtcData("act_arr_dt")=="null") ? "" : sheetObj.GetEtcData("act_arr_dt").substring(0, 10);
		formObj.act_dep_dt.value=(sheetObj.GetEtcData("act_dep_dt")==undefined || sheetObj.GetEtcData("act_dep_dt")=="null") ? "" : sheetObj.GetEtcData("act_dep_dt").substring(0, 10);
		for(var ir=sheetObj.HeaderRows();ir<=sheetObj.LastRow();ir++){
//			if(sheetObj.GetCellValue(ir, "obl_rlse_flg") == 'Y'){
//				sheetObj.SetCellEditable(ir, "sel",0);
//			}
//			if(sheetObj.GetCellValue(ir, "obl_iss_flg") == 'Y' || sheetObj.GetCellValue(ir, "obl_rlse_flg") == 'Y'){
//				sheetObj.SetRowEditable(ir,0);
//				sheetObj.SetCellBackColor(ir, "sel","#EBEBEB");
//			}						
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		if('14'==Col){
			sheetObj.SetCellValue(Row, "obl_iss_ofc_cd", document.form.strOfc_id.value);
			sheetObj.SetCellValue(Row, "obl_iss_usr_id", document.form.strUsr_id.value);
		}
	}
	
    //BackEndJob 상태 조회용 루프 함수
    function callIntervalBackEndJob() {
    	if (300==processCnt++) {  //intervalTime(3초) * 600 = 30분
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
        doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    }	
	/* Developer Work End */
