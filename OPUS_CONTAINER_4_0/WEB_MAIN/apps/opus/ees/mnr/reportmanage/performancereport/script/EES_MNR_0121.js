/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0121.js
*@FileTitle : PFMC by Estimate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable

 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var uTpSz=new Array();
 var gTpSz=new Array();
 var zTpSz=new Array();
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
function processButtonClick() {
	/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
 		var srcName=ComGetEvent("name");
 		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
			case "btn_New":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
	            break;
		    case "btn_DownExcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	            break;
			case "btn_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
				break;
			case "btn_loc_cd":
				var eq_knd_cd="";
				if(formObject.eq_type.GetSelectCode()!= 'A'){
					eq_knd_cd=formObject.eq_type.GetSelectCode();
				}
				break;
			case "btn_provider_popup":
			    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * Assigning array of IBSheet object
 * Array defined at the top of the source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
  * Assigning array of IBCombo object
  * @param	{IBMultiCombo}	combo_obj
  * Array defined at the top of the source
  */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Sheet default setting and initializing
 * To implement for onload event of body tag
 * After loading in your browser should display the ability to add pre-processing
 */
function loadPage() {
	initControl();
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    //Initializing IBMultiCombo
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k + 1);
    }
	setTpSzArray(sheetObjects[0]);
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
/**
 * Combo Setting default
 * @param	{IBMultiCombo}	combo_obj.
 * @param	{Number}	comboNo		Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
    var formObject=document.form
    switch(comboNo) {
        case 1:
           	with (comboObj) {
          	    SetMultiSeparator("|");
				SetTitle("Period|Amount");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "100");
				SetColWidth(1, "0");
				SetDropHeight(160);
				SetUseAutoComplete(1);
  		    }
        	break;
        case 2:
           	with (comboObj) {
				SetColAlign(0, "left");
				SetColWidth(0, "80");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
	    	}
        	break;
        case 3:
           	with (comboObj) {
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "230");
				SetDropHeight(200);
  		    }
        	break;
        case 4:
           	with (comboObj) {
				SetMultiSeparator("|");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
	            ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
	    	}
        	break;
        case 5:
           	with (comboObj) {
				SetMultiSeparator("|");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
	            ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
	    	}
        	break;
        case 6:
           	with (comboObj) {
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "50");
				SetColWidth(1, "150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
	    	}
        	break;
        case 7:
           	with (comboObj) {
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "50");
				SetColWidth(1, "150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
	    	}
        	break;
     }
}
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
 * Initializing variable for IBSheet and defining header
 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
 */
function initSheet(sheetObj, sheetNo) {
     var cnt=0;
	 var sheetID=sheetObj.id;
      switch(sheetID) {
          case "sheet1":
                  with(sheetObj){
					
				  var HeadTitle="|Seq.|RHQ|Item|Month|Account\nCode|Office|S/P Code|S/P Name|TP/SZ|Curr|Success|Success\nAMT|Success(L)|Success(L)\nAMT|Off-hire|Off-hire\nAMT|Standard Tariff\nNot Found|Standard Tariff\nNot Found AMT|Material Tariff\nNot Found|Material Tariff\nNot Found AMT|Man-Hour\nUnmatched|Man-Hour\nUnmatched AMT|Rate\nUnmatched|Rate\nUnmatched AMT|Material\nUnmatched|Material\nUnmatched AMT|Volume Type\nError|Volume Type\nError AMT|Location\nError|Location\nError AMT|Component\nError|Component\nError AMT|Repair\nError|Repair\nError AMT|Damage\nError|Damage\nError AMT|Agreement\nNot Found|Agreement\nNot Found AMT|Repair\nQTY|Estimate\nQTY|Reject\nQTY|Reject\nAMT|Counter\nOffer QTY|Counter\nOffer AMT|Total\nAMT|Average AMT\n(Total/Repair)";
				  var headCount=ComCountHeadTitle(HeadTitle);

				  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
						 {Type:"Seq",       Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rhq",               KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mnr_inp_tp_cd_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"month",             KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sp_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"sp_nm",             KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"tpsz",              KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr",              KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"ss_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"ss_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2 },
						 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"sl_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"sl_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"of_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"of_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:115,  Align:"Right",   ColMerge:0,   SaveName:"ns_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:115,  Align:"Right",   ColMerge:0,   SaveName:"ns_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:115,  Align:"Right",   ColMerge:0,   SaveName:"nt_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:115,  Align:"Right",   ColMerge:0,   SaveName:"nt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"uh_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"uh_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"ur_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"ur_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"um_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"um_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:110,   Align:"Right",   ColMerge:0,   SaveName:"vt_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"vt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"le_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"le_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ce_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"ce_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"re_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"re_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"de_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"de_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"na_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"na_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"dtl_cnt",           KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"est_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"hj_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"hj_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"ho_cnt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
						 {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"ho_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"t_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2},
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"t_avg",             KeyField:0,   CalcLogic:"",   Format:"NullFloat" , PointCount:2} ];
				   
							InitColumns(cols);

							SetEditable(0);
							SetCountPosition(0);
//							SetSheetHeight(382);
							resizeSheet( sheetObj );
							ShowSubSum([{StdCol:4, SumCols:"11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45", Sort:0, ShowCumulate:0, CaptionCol:3, CaptionText:" ", AvgCols:"46"}]);
						}


              break;
      }
}
//Sheet processing-related processes
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
		case IBSEARCH:      //Retrieving
			if(validateForm(sheetObj,formObj,sAction)){
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value=SEARCH;
					if(formObj.check_usd_only.checked){
						formObj.curr_cd.value="Y";
					} else {
						formObj.curr_cd.value="N";
					}
						sheetObj.DoSearch("EES_MNR_0121GS.do",FormQueryString(formObj) );
				}
			}
			break;
		case IBCLEAR:        //Initializing
			MnrWaitControl(true);
		    sheetObj.SetWaitImageVisible(0);
			//Initializing sheet
			for(i=0;i<sheetObjects.length;i++){
				sheetObjects[i].RemoveAll();
	        }
			//Initializing combo
			for(var i=0; i < comboObjects.length;i++){
				comboObjects[i].RemoveAll();
			}
			//Retrieving combo data
			var sCondition=new Array (
				new Array("MnrGenCd","CD00055", "COMMON"),
				new Array("MnrGenCd","","CUSTOM9"),
				new Array("MdmOrganization","RHQ","FALSE")
			)
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			//Period
			if(comboList[0] != null){
				for(var j=0; j < comboList[0].length;j++){
					var tempText=comboList[0][j].split("|");
					tempText[1]=tempText[1] + '|' + 'Estimate Amt';
					report_period_type.InsertItem(j,tempText[1] ,tempText[0]);
				}
			}
			//EQ Type
			eq_type.InsertItem(0,"ALL","A");
			if(comboList[1] != null){
				for(var j=0; j < comboList[1].length;j++){
					var tempText=comboList[1][j].split("|");
					eq_type.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}
			}
			//Regional HQ
			rhq.InsertItem(0,"ALL","A");
			if(comboList[2] != null){
				for(var j=0; j < comboList[2].length;j++){
					var tempText=comboList[2][j].split("|");
					rhq.InsertItem(j + 1, comboList[2][j] ,tempText[0]);
				}
			}
			//Setting init value
	 		report_period_type.SetSelectCode("WI");
	 		eq_type.SetSelectCode("A");
	 		rhq.SetSelectCode("A");
	 		tp_sz_cd.SetEnable(0);
			formObj.fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
			MnrSetFromDate(formObj.fm_dt);
			formObj.to_dt.value=ComGetNowInfo();
			formObj.vndr_seq.value="";
			formObj.vndr_lgl_eng_nm.value="";
			sheetObj.SetWaitImageVisible(1);
			MnrWaitControl(false);
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, AutoSizeColumn:1 });
				}
			
			break;
		case IBSEARCH_ASYNC01:	//Retrieving(sevice provider No. at inserting)
			if ( validateForm(sheetObj, formObj, sAction) ) {
				//Retrieving service provider
				var sCondition=new Array (
					new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
				)
				//Setting when returned data exist
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				if(comboList[0] != null){
					var tempText=comboList[0][0].split("|");
					formObj.vndr_lgl_eng_nm.value=tempText[1];
				} else {
					ComShowCodeMessage("MNR00005", "Service Provider");
					ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
					ComSetObjValue(formObj.vndr_seq, "");
					ComSetFocus(formObj.vndr_seq);
				}
			}
			break;
		case IBSEARCH_ASYNC02:	//Retrieving(Loc cd at inserting)
			if ( validateForm(sheetObj, formObj, sAction) ) {
				var checkLoc=ComGetObjValue(formObj.loc_cd);
			    retArray=MnrGeneralCodeCheck(sheetObj,"LOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"LOC");
					ComSetObjValue(formObj.loc_cd, "");
					ComSetFocus(formObj.loc_cd);
				}
			}
			break;
		case IBSEARCH_ASYNC03:	//Retrieving(RHQ When changing combo)
			sheetObj.SetWaitImageVisible(0);
			if ( validateForm(sheetObj, formObj, sAction) ) {
				ofc_cd.RemoveAll();
				var sCondition=new Array (
					new Array("MdmOrganization","SEARCH",rhq.GetSelectCode())
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				ofc_cd.InsertItem(0,"ALL","A");
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						ofc_cd.InsertItem(j + 1,comboList[0][j] ,tempText[0]);
					}
				}
			    ofc_cd.SetSelectCode("A");
			}
			sheetObj.SetWaitImageVisible(1);
			break;
    }
}
	/**
	* Event handling of OnSearchEnd of sheet1
	*/
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		if (ErrMsg != "") {
			ComShowCodeMessage("MNR00057","MNR PFMC by Estimate");
		}
		//Summing of sub
		
//		ShowSubSum([{StdCol:1, SumCols:"4|5|6|7|8|9|10|11|12|13|14", Sort:0, ShowCumulate:0, CaptionCol:3, CaptionText:"SubTotal"}]);
		var aFloat=parseFloat(sheetObj.GetSumValue(0,"t_amt") + "");
		var bFloat=parseFloat(sheetObj.GetSumValue(0,"dtl_cnt") + "");
		var avgFloat=0;
		if(bFloat != 0){
			avgFloat=MnrMakeRound((aFloat / bFloat),2);
		}
		sheetObj.SetSumValue(0,"t_avg",avgFloat);
		sheetObj.SetSumText(0, 1, "TOTAL");
	}
	/**
	 * rhq : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 *
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function rhq_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
	}
	/**
	 * combo_eq_type_cd : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function eq_type_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		var comboValue=comboObj.GetSelectCode();
		tp_sz_cd.RemoveAll();
		var selTpSz=new Array();
		if(comboValue == "U"){
			selTpSz=uTpSz;
		} else if(comboValue == "G"){
			selTpSz=gTpSz;
		} else if(comboValue == "Z"){
			selTpSz=zTpSz;
		}
		if(selTpSz.length == 0){
	 		tp_sz_cd.SetEnable(0);//tp_sz_cd
		}else{
	 		tp_sz_cd.SetEnable(1);//tp_sz_cd
			tp_sz_cd.InsertItem(0,"ALL","A");
			for(var i=1;i < (selTpSz.length + 1);i++){
				tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]);
			}
		}
	}
	//Multi combo click event
	function tp_sz_cd_OnCheckClick(comboObj, index, code) {
		MnrAllChkMultiCombo(comboObj,index);
	}
	/**
	 * Getting rep_Multiful_inquiry
	 */
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//Initializing
		formObj.eq_list.value='';
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//Removing last comma
		tempText=MnrDelLastDelim(tempText);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	function setTpSzArray(sheetObj){
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
		if(arrXml != null){
		    for(var i=0; i < arrXml.length; i++){
				if(i == 0){
					uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){
					zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){
					gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
		    }
		}
	}
	/**
	* Validating process for input form data
	*/
	function validateForm(sheetObj,formObj,sAction){
	  with(formObj){
		if(sAction==IBSEARCH) {
			if (!ComChkValid(formObj)) return false;
			if(!MnrChkFromDate(formObj.fm_dt)) return false;
		}
	  }
	  return true;
	}
	/**
	 * Processing of returned pop-up screen value (EES_MNR_0016)
	 */
	function setEES_MNR_0193(aryPopupData){
		var formObject=document.form;
		if(aryPopupData == null) return;
		formObject.loc_cd.value=aryPopupData;
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=aryPopupData[0][2];
			formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
		}
	}
	function initControl() {
	    //Axon event handling 1. Catching event
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
	//    axon_event.addListenerFormat('focus',   'obj_activate',    form);
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
		axon_event.addListenerFormat('change',	 'obj_change',		form);
	}
	/**
	 * Disable event handling <br>
	 **/
	function obj_deactivate(){
		obj=event.srcElement;
	    ComChkObjValid(event.srcElement);
	}
	/**
	 * Enable event handling <br>
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
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
	    		case "loc_cd":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
					ComSetObjValue(formObj.vndr_lgl_eng_nm,"")
				   	break;
			}
		}
	}
	/**
	 * Keypress event handling <br>
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
	            ComKeyOnlyNumber(obj, ".");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
	        	ComKeyOnlyAlphabet('uppernum');
	        break;
	    }
	}
	/* End of developer's task */
