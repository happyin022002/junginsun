/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0037.js
*@FileTitle : Revenue VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
//  common global variables 
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name  */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
   var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
      	switch(srcName) {
        	case "btn_retrieve":
             	//if(!CoFmsInitConfirm(sheetObject)) return;
             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
            break;
			case "btn_new":
             	//if(!CoFmsInitConfirm(sheetObject)) return;
				ComResetAll();
				inputReadOnly('New');
            break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
            break;
			case "btn_savetofile":
				if(sheetObject.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}	
            break;
			case "btn_vvdcreation":
				doActionIBSheet(sheetObject,formObject,IBSEARCH, "vvdcreation");
            break;
			case "btn_vvdfinalizing":
				doActionIBSheet(sheetObject,formObject,IBSEARCH, "vvdfinalizing");
            break;
			case "btn_add":
				if(!validateForm(sheetObject,formObject)) return;
				var row=sheetObject.DataInsert(-1);
				sheetObject.SetCellValue(row, "rev_yrmon",formObject.rev_yrmon.value);
            break;
			case "btn_ins":
				if(!validateForm(sheetObject,formObject)) return;
				var row=sheetObject.DataInsert();
				sheetObject.SetCellValue(row, "rev_yrmon",formObject.rev_yrmon.value);
				break;
			case "btn_del":
				if(checkBoxCheckYn(sheetObject, "DelChk")) { 
					ComRowHideDelete(sheetObject, "DelChk"); 
				}
            break;
 			case "btn_period":
 				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.rev_yrmon, 'yyyy-MM');
				break;					
			case "btn_lanepop":
				ComOpenPopup("ESM_FMS_0036.do", 620, 428,"setLaneCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0036");
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
    initControl();
}
/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
    //Axon Event Handling1. Event catch
	axon_event.addListenerForm  ('blur'				, 'obj_deactivate', form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
    axon_event.addListener  ('change'  , 'lane_cd_change', 'slan_cd');				//- Verifying Code after inputting Service Lane Code
    
    setToday(document.form.rev_yrmon,"ym");
    
}
/**
 * Checking Validation in onblur Event of HTML Control<br>
 **/
function obj_deactivate(){
    ComChkObjValid(ComGetEvent());
}
/**
 * Handling screen by Event <br>
 * @param {String} flag  
 **/
function inputReadOnly(flag) {
	var readOnly=true;
	var cursor="default";
	var img="no_";
	if(flag == "New") {
		readOnly=false;
		cursor="hand";
		img="";
		setToday(document.form.rev_yrmon,"ym");
	}
	form.rev_yrmon.readOnly=readOnly;
	document.all.name=img+"btn_period";
	form.btn_period.style.cursor=cursor;

}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
	              var HeadTitle="|Sel|Seq|Revenue Month|Service Lane|Revenue Lane|Service Lane Direction|VVD Code|Start Date(ETD/ATD)|End Date(ETD/ATD)|Com VVD Flag";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                     {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rev_yrmon",   KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,   EditLen:10 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vst_dt",      KeyField:1,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ved_dt",      KeyField:1,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rev_dir_cd" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"com_vvd_flg" }  ];
	               
	              InitColumns(cols);
	              SetEditable(1);
//		              SetSheetHeight(400);
	              resizeSheet();
	              
	              SetColProperty(0 ,"rev_yrmon" , {AcceptKeys:"N"});
	              SetColProperty(0 ,"slan_cd" , {AcceptKeys:"N|E", InputCaseSensitive:1});
	              SetColProperty(0 ,"rlane_cd" , {AcceptKeys:"N|E", InputCaseSensitive:1});
	              SetColProperty(0 ,"skd_dir_cd" , {AcceptKeys:"N|E", InputCaseSensitive:1});
	              SetColProperty(0 ,"vvd_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
	              SetColProperty(0 ,"vst_dt" , {AcceptKeys:"N|[-]", Format:"####-##-##"});
	              SetColProperty(0 ,"ved_dt" , {AcceptKeys:"N|[-]", Format:"####-##-##"});		              
                }
            break;
     }
 }
/**
 * Handling IBSheet's process(Retrieve, Save) <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form}    formObj Mandatory html form object
 * @param {int}     sAction mandatory,Constant Variable
 * @param {String}  gubun     	gubun value
 **/ 
function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
     	case IBSEARCH:      
 			if(!validateForm(sheetObj,formObj,sAction))return;
     		if (Col == "vvdcreation") {//VVD CD Creation In FMS
        		formObj.f_cmd.value=SEARCH01;
     		} else if (Col == "vvdfinalizing") {//VVD CD Finalizing From ERP 
        		formObj.f_cmd.value=SEARCH02;
     		} else {//Retrieve
        		formObj.f_cmd.value=SEARCH;
     		}
//         	   	sheetObj.DoSearch("ESM_FMS_0037GS.do", ComReplaceStr(FormQueryString(formObj)+"&"+"-",{Append:}));
     		sheetObj.DoSearch("ESM_FMS_0037GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
    	   	inputReadOnly('');
            break;
       	case IBSAVE:        
 			if(!validateForm(sheetObj,formObj,sAction))return;
 			//Start Date(ETD/ATD) or End Date(ETD/ATD) Duplicate Check.
 			if(!validateDupDate(sheetObj)) return;
 			formObj.f_cmd.value=MULTI;
 			sheetObj.DoSave("ESM_FMS_0037GS.do", FormQueryString(formObj));
            break;
		case IBROWSEARCH:   
    		if (Col == "slan_cd") {//Checking Service Lane Code
				var param='f_cmd='+SEARCH05;
				if(typeof Row == "undefined" || Row == "" ) {
					param += "&lane_cd="+formObj.slan_cd.value;		//Calling from form
				} else {
					param += "&lane_cd="+sheetObj.GetCellValue(Row, Col);//Calling from grid
				}
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName == "undefined" || cdName == "" ) {
					if(typeof Row == "undefined" || Row == "" ) {
						formObj.slan_cd.value="";
						ComAlertFocus(formObj.slan_cd, ComGetMsg("FMS01237"));
					} else {
						ComShowCodeMessage("FMS01237");
						sheetObj.SetCellValue(Row, Col,"",0);
						sheetObj.SelectCell(Row, Col);
					}
				}
    		} else if (Col == "rlane_cd") {//Checking Revenue Lane Code
				var param='f_cmd='+SEARCH07;
				//if(typeof Row == "undefined" || Row == "" ) {
				//	param += "&rlane_cd="+formObj.rlane_cd.value;		//Calling from form
				//} else {
					param += "&rlane_cd="+sheetObj.GetCellValue(Row, Col); //Calling from grid
				//}
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName == "undefined" || cdName == "" ) {
					if(typeof Row == "undefined" || Row == "" ) {
						//formObj.rlane_cd.value="";
						//ComAlertFocus(formObj.rlane_cd, ComGetMsg("FMS01237"));
						ComShowCodeMessage("FMS01237");
					} else {
						ComShowCodeMessage("FMS01237");
						sheetObj.SetCellValue(Row, Col,"",0);
						sheetObj.SelectCell(Row, Col);
					}
				}
    		} else if (Col == "vvd_cd") {
    			var param='f_cmd='+SEARCH06 + "&vvd_cd="+sheetObj.GetCellValue(Row, Col);//grid에서 호출하는 경우
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "chk_vvd");
	   			if(typeof cdName == "undefined" || cdName == "" ) {
					ComShowCodeMessage("FMS01144");
					sheetObj.SetCellValue(Row, Col,"",0);
					sheetObj.SelectCell(Row, Col);
				} else {
					var tmpComVvdFlg = cdName.substring(0,1);
					cdName=sheetObj.GetCellValue(Row, Col); // 입력된 VVD 를 재사용한다.

					var iDupVslCdCnt = 0;
					//대선 일때는 동일 VSL_CD 가 있으면 안됨.
					if(tmpComVvdFlg == "Y"){
						var inVslCd = cdName.substring(0,4);
						for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
							var chkVslCd = sheetObj.GetCellValue(i,"vsl_cd");
							var chkComVvdFlg = sheetObj.GetCellValue(i,"com_vvd_flg");
							if(chkComVvdFlg == "Y" && inVslCd == chkVslCd){
								iDupVslCdCnt++;
							}
						}
					}

					if(iDupVslCdCnt > 0){ // 입력시 아직 vsl_cd 를 넣지 않았기 때문에 0보다 크면 이미 존재한 VSL_CD 로 봄.
						ComShowCodeMessage("FMS20008","VVD Code");
						sheetObj.SetCellValue(Row, Col,"",0);
						sheetObj.SelectCell(Row, Col);
					}else{
		   				sheetObj.SetCellValue(Row, "com_vvd_flg", tmpComVvdFlg,0);
						cdName=sheetObj.GetCellValue(Row, Col); // 입력된 VVD 를 재사용한다.
		   				sheetObj.SetCellValue(Row, "vsl_cd",cdName.substring(0,4),0);
		   				sheetObj.SetCellValue(Row, "skd_voy_no",cdName.substring(4,8),0);
		   				sheetObj.SetCellValue(Row, "skd_dir_cd",cdName.substring(8,9),0);
		   				sheetObj.SetCellValue(Row, "rev_dir_cd",cdName.substring(9,10),0);
					}
				}
			}	
            break;
    }
}
/**
 * Inserting Lane Code<br>
 * @param {arry} aryPopupData
 */
function setLaneCd(aryPopupData){
	form.slan_cd.value=aryPopupData[0][3];
}
/**
 * Checking corresponding Lane Code when changing Service LaneCd <br>
 **/
function lane_cd_change() {
	if (form.slan_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'slan_cd');
	}
}

/**
  * Handling process for input validation
  */
function validateForm(sheetObj,formObj,sAction){
	if (!ComChkValid(formObj)) return false;
	
	return true;
}

function validateDupDate(sheetObj){
	 with(sheetObj){
		 
		 //COM_VVD_FLG : Y, N 구분.
		 for(var j=HeaderRows(); j<=LastRow(); j++) {
			 var varNowComVvdFlg = GetCellValue(j,"com_vvd_flg");
			 var varNowVslCd = GetCellValue(j,"vsl_cd");
			 
			 var varNowVstDt = GetCellValue(j,"vst_dt");
			 var varNowVedDt = GetCellValue(j,"ved_dt");
			 if("N" == varNowComVvdFlg){
				 //공동 선박이 아닌경우 > 동일 선박일때는 vst, ved 가 동일 할 수가 없다.
				 var iDupVstDtCnt = 0;
				 var iDupVedDtCnt = 0;
				 
				 for(var ii=HeaderRows(); ii<=LastRow(); ii++) {
					 var tmpVslCd = GetCellValue(ii,"vsl_cd");
					 var tmpVstDt = GetCellValue(ii,"vst_dt");
					 var tmpVedDt = GetCellValue(ii,"ved_dt");
					 var tmpSeq = GetCellValue(ii,"Seq");
					 var tmpComVvdFlg = GetCellValue(ii,"com_vvd_flg");
					 if(varNowVslCd == tmpVslCd && "N" == tmpComVvdFlg && (varNowVstDt == tmpVstDt || varNowVstDt == tmpVedDt)){
						 iDupVstDtCnt++;
					 }
					 
					 if(varNowVslCd == tmpVslCd && "N" == tmpComVvdFlg && (varNowVedDt == tmpVstDt || varNowVedDt == tmpVedDt)){
						 iDupVedDtCnt++;
					 }
					 
					 if(iDupVstDtCnt > 1 || iDupVedDtCnt > 1) {
						 ComShowCodeMessage("FMS20008","["+tmpSeq+"] Start Date(ETD/ATD) & End Date(ETD/ATD)");
						 return false;
					 }
				 }
			 }else{
				 //공동 선박일 경우 > 동일 선박이 존재 하는지만 체크하면 됨. 해당월 1 ~ 해당월 말일 로 날짜가 자동 셋팅됨.
				 var iDupVslCdCnt = 0;
				 for(var i=HeaderRows(); i<=LastRow(); i++) {
					 var tmpVslCd = GetCellValue(i,"vsl_cd");
					 var tmpSeq = GetCellValue(i,"Seq");
					 var tmpComVvdFlg = GetCellValue(i,"com_vvd_flg");
					 if(varNowVslCd == tmpVslCd && "Y" == tmpComVvdFlg){
						iDupVslCdCnt++;
					 }
					 
					 if(iDupVslCdCnt > 1){ // 선택된 데이타에 중복된 데이타가 있는지 체크 하기 때문에 1보다 크면 중복으로 봄.
						 ComShowCodeMessage("FMS20008","["+tmpSeq+"] Start Date(ETD/ATD) & End Date(ETD/ATD)");
						 return false;
					 }
				 }
				 
			 }
		 }
	 }
	 
	 return true;
}

 /**
  * In case of clicking Popup in IBSheet Object
  */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

}	
 /**
  * In case of changing Input value in IBSheet Object
  */
function sheet1_OnChange(sheetObj,Row, Col, Value)
{
	if (sheetObj.ColSaveName(Col) == "slan_cd") {
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", Row);
	} else if (sheetObj.ColSaveName(Col) == "rlane_cd") {
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "rlane_cd", Row);
	} else if (sheetObj.ColSaveName(Col) == "vvd_cd") {
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vvd_cd", Row);
	}
}

function sheet1_OnAfterEdit(sheetObj,row, col) {
	var value = sheetObj.GetCellValue(row, col);
	dateTimeOnChange(sheetObj,row,col,value,"");
}

function dateTimeOnChange(sheetObj,row,col,value,prefix) {
	if (sheetObj.GetCellProperty(row,col,"Format")!= "####-##-##") return;

	if (value=="") return;
	
	var sText=sheetObj.GetCellText(row,col);
	if (!ComIsDate(sText)) {
		ComShowMessage(ComGetMsg('FMS01065', sheetObj.GetCellText(0,col)));
		//ComShowMessage(sheetObj.CellText(0,col) + " is not valid date-time. Please enter a correct date-time. \n\n Format : YYYY-MM-DD");
		sheetObj.SelectCell(row,col,true);
		return;
	}
	
	// Period Check
	if (sheetObj.GetCellText(row,prefix + "vst_dt")!="" && sheetObj.GetCellText(row,prefix + "ved_dt")!=""){
		if(!sheet_chekPeriod(sheetObj,row,col,prefix)){		
			if(sheetObj.ColSaveName(col)==prefix + "vst_dt") {
				//sText=sheetObj.GetCellText(row,col+1);
				sheetObj.SelectCell(row,col+1,true);
			} else {
				//sheetObj.SelectCell(row,col,true,sText);
				//sheetObj.SetCellValue(row,col,"", 0);
				sheetObj.SelectCell(row,col,true);
			}
			return;
		}
	}else{
		return;
	}
	
}
function sheet_chekPeriod(sheetObj,row,col,prefix){
	//var prefix = "hir_";
	var fromDate=sheetObj.GetCellValue(row,prefix + "vst_dt");
	var toDate=sheetObj.GetCellValue(row,prefix + "ved_dt");
	if (fromDate=="" && toDate=="") return;
	if (fromDate > toDate){
		ComShowMessage(ComGetMsg('FMS01067'));
		//ComShowMessage("'To Date' must be greater than or equal to 'From Date'.");
		//sheetObj.SelectCell(row,col);
		return false;
	}
	return true;
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 	