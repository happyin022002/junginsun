/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0220.js
*@FileTitle  : Pre-Dispatch Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var cnt=0;
	switch(sheetNo) {
	  	case 1: //sheet0 init ( Child S/P )
	  		with(sheetObj){
	  			var HeadTitle1="Del.|STS|SEQ|Child Service\nProvider|Child Service\nProvider" ;
	  			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	  			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	  			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	  			InitHeaders(headers, info);
	  			var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"check",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	  			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
	  			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	  			             {Type:"PopupEdit", Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	  			             {Type:"Text",     Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	  			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
	  			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trsp_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 } ];
	  			InitColumns(cols);
	  			SetEditable(1);
	            SetHeaderRowHeight(25);
	            SetSheetHeight(100, 1);
	            SetCountPosition(0);
	  		}
	  		break;
	  	case 2: //sheet2 init ( ATMT Header ) Hidden Sheet
	  	    with(sheetObj){
	  			var HeadTitle1="Ststus|AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK|OFC_CD|USR_ID" ;
	  			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	  			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	  			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	  			InitHeaders(headers, info);
	  			var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trsp_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_prmry_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_prmry_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:300 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ctrt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agmt_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agmt_pic_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cre_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 } ];
	  			InitColumns(cols);
	  			SetEditable(1);
	            SetHeaderRowHeight(25);
	            SetVisible(0);
	  		}
	  		break;
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); 
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); 
	}	
	if(document.form.fm_agmtno.value != ""){
		doSearch();
	}	
}
/*------------------From here the common JavaScript function is defined.     ------------------*/
/* Common global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/* At the bottom of the business by adding a global variable is used to declare. */
/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
    try {
    	var srcName=ComGetEvent("name");
    	if(ComGetBtnDisable(srcName)) return false;
    	switch(srcName) {
			/* [1.1.Add button at the top row] */
    		case "btn_rowadd":
    			var agmt_ofc_cty_cd=formObject.fm_trsp_agmt_ofc_cty_cd.value;
				if(agmt_ofc_cty_cd == "") return;
				doActionIBSheet(sheetObject,formObject,"INSERT");
			break;
			/* [1.2.Delete button at the top row] */
			case "btn_delete":
				doActionIBSheet(sheetObject,formObject,"DELETE");
			break;
			/* [1.3.Save button at the top of] */
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,"SAVE");
			break;
			/* [1.3.service provider's pop-up button] */
			case "btn_provider":
			    rep_OnPopupClick();
			break;
			/* [2.1.Lookup Logic] */
			case "btng_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			/* [2.2.Creation button at the bottom] */
			case "btng_create":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
			/* [2.3.Update button at the bottom] */
			case "btng_update":
				doActionIBSheet(sheetObject1,formObject,"IBUPDATE");
			break;
			/* [2.4.Ok button at the bottom] */
			case "btng_ok":
				var opener=window.dialogArguments;
				if (!opener) {
					opener=window.parent;
				}
				if (!opener) opener=window.opener;

				opener.form.fm_agmtno.value=form.fm_agmtno.value;
				opener.doActionIBSheet(opener.sheet1,formObject,IBSEARCH);

                // 2014.12.30    Hyungwook Choi
				opener.form.cur_page_cnt.value = 1;
				opener.reset_all1();
				opener.reset_all2();
				opener.reset_all3();

				ComClosePopup(); 
			break;
			/* [2.5.Close button at the bottom] */
			case "btng_close":
				ComClosePopup(); 
    	    break;
    	    /* [2.6.New button on the bottom] */
			case "btng_new":
				document.form.fm_vndr_prmry_seq.readOnly=false;
				document.form.fm_agmt_ref_no.readOnly=false;
				document.form.fm_ctrt_ofc_cd.readOnly=false;
				sheetObject.RemoveAll();
	            sheetObject1.RemoveAll();
	            formObject.reset();
	            formObject.fm_agmtno.value="";
			break;
       } // end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowCodeMessage('TRS90031');
    	} else {
    		ComShowMessage(e.message);
    	}
    }
}
/*
 * handling of Sheet 
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
	var x1="";
    switch(sAction) {
       case "INSERT":
   	    	var row=sheetObj.DataInsert();
   	    	sheetObj.SetCellValue(row, "trsp_agmt_ofc_cty_cd",formObject.fm_agmtno.value.substring(0,3));
   	    	sheetObj.SetCellValue(row, "trsp_agmt_seq",formObject.fm_agmtno.value.substring(3));
   	    	break;
       case "DELETE":
			var checkList=sheetObj.FindCheckedRow('check');
			var checkArray=checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
  	        break;
       case "SAVE":
	   	    formObj.f_cmd.value=MULTI;
	   	    sheetObjects[0].DoSave("ESD_TRS_0220GS.do", TrsFrmQryString(formObj),-1,false);
  	    	break;
       case IBSEARCH:
	   	    formObj.f_cmd.value=SEARCH01;
	   	    sheetObjects[1].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
		    formObj.f_cmd.value=SEARCH02;
		    sheetObjects[0].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
			break;
       case IBSAVE:
    	    if (!valcheck()) return;

    	    sheet1.RemoveEtcData();
    	    setAgreementInfo(); //Check for duplicates in the set IbSheet Agreement Header information
			formObj.f_cmd.value=SEARCH03;
			var queryStr=sheetObjects[1].GetSaveString(1);
			var sXml = sheetObj.GetSearchData("ESD_TRS_0220GS.do", queryStr+"&"+TrsFrmQryString(formObj));
			sheetObj.LoadSearchData(sXml, { Append : 1 });
			x1=ComSearchEtcData(sheetObj, "ESD_TRS_0220GS.do", queryStr+"&"+TrsFrmQryString(formObj), 'CNT_CD_AGREE');
			
			if(x1 =="" || x1 == undefined){ //If you do not have to exist AGMT generates Agreement no.
				setAgreementInfo(); //Check for duplicates in the set IbSheet Agreement Header information
			    sheet1.RemoveEtcData();
			    queryStr=sheetObjects[1].GetSaveString(1);
				formObj.f_cmd.value=SEARCH04;

                // 2015.01.06    Hyungwook Choi
				//var sXml = sheetObj.GetSearchData("ESD_TRS_0220GS.do", queryStr+"&"+TrsFrmQryString(formObj));
				//sheetObj.LoadSearchData(sXml, { Append : 1 });

				x1=ComSearchEtcData(sheetObj, "ESD_TRS_0220GS.do", queryStr+"&"+TrsFrmQryString(formObj), 'NEW_AGMT_NO');
				
				if(x1 !="" && x1 != undefined){ //
					formObj.fm_agmtno.value=x1;
				    formObj.f_cmd.value=SEARCH02;
				    
				    var sheetObject1=sheetObjects[1];
				    var formObject=document.form;
				    doActionIBSheet(sheetObject1,formObject,IBSEARCH);				    
				}else{
					formObj.fm_agmtno.value="";
				}
			}else{
				ComShowCodeMessage('TRS90032', '');
			}
    	    break;
       case "IBUPDATE":
	   	    if (!valcheck()) return;
    	    if (formObj.fm_agmtno.value == "") {
    	    	ComShowCodeMessage('TRS90386', 'Not exist save data.');
    	    	return;
    	    }
	   	    
	   	    sheetObj.RemoveEtcData();
//	   	    formObj.fm_ctrt_ofc_cd.value = sheetObj.CellValue(1, "ctrt_ofc_cd");
	   	    setAgreementInfo();
	   	    sheetObj.SetCellValue(1, "ibflag",'U');
	   	    sheetObj.SetCellValue(1, "trsp_agmt_ofc_cty_cd",formObject.fm_agmtno.value.substring(0,3));
	   	    sheetObj.SetCellValue(1, "trsp_agmt_seq",formObject.fm_agmtno.value.substring(3));
		    formObj.f_cmd.value=MODIFY;
    	    sheetObjects[1].DoSave("ESD_TRS_0220GS.do", TrsFrmQryString(formObj),-1,false);
    	    ComShowCodeMessage('TRS90405');
    	    break;
    }
}
function doSearch() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	
	doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
}
function doSearchEnter() {
	if(event.keyCode == 13 ) {
		doSearch();
	}
}
/**
 * Views that occur after the EVENT
 * By IBSheetConfig.js Defined by DataSheetObject.prototype.event_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj=document.form;
	var fCmd=formObj.f_cmd.value;
	if (fCmd == SEARCH02) { 
		if(sheetObj.RowCount()> 0) {
			formObj.fm_vndr_prmry_seq.value=sheetObj.GetCellValue(1, "vndr_prmry_seq");
			formObj.fm_vndr_prmry_nm.value=sheetObj.GetCellValue(1, "vndr_prmry_nm");
			formObj.fm_agmt_ref_no.value=sheetObj.GetCellValue(1, "agmt_ref_no");
			formObj.fm_ctrt_ofc_cd.value=sheetObj.GetCellValue(1, "ctrt_ofc_cd");
			formObj.fm_inter_rmk.value=sheetObj.GetCellValue(1, "inter_rmk");
			formObj.fm_trsp_agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1, "trsp_agmt_ofc_cty_cd");
		    formObj.fm_vndr_prmry_seq.readOnly=true;
		    formObj.fm_agmt_ref_no.readOnly=true;
		    formObj.fm_ctrt_ofc_cd.readOnly=true;
		}else{
		    formObj.fm_vndr_prmry_seq.value="";
		    formObj.fm_vndr_prmry_nm.value="";
		    formObj.fm_agmt_ref_no.value="";
		    formObj.fm_ctrt_ofc_cd.value="";
		    formObj.fm_inter_rmk.value="";
		    formObj.fm_trsp_agmt_ofc_cty_cd.value="";
		}
	}else if (fCmd == SEARCH03) { //Agreement NO Checking the existence
	}else if (fCmd == SEARCH04) { //Agreement NO Generation
	}else if (fCmd == SEARCH05) { //S/PName Lookup
	}
	sheetObj.RowDelete(1, false);
}
 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * OnChange event
 */
function sheet0_OnChange(sheetObj, row, col, value){
	 var formObject=document.form;
	 var colName=sheetObj.ColSaveName(col);
	 var loop_val="N";
	 var charval="Y";
	 var inputStr=value;
	 switch(colName){
	 case 'vndr_seq':
		 var sheet0_vndr_seq=sheetObj.GetCellValue(row, "vndr_seq");
		 var inputStr=sheet0_vndr_seq;
		 for (var i=0; i < inputStr.length; i++)
		 {
			 var oneChar=inputStr.charAt(i)
			 if (oneChar != "")
			 {
				 if ( (oneChar >= "0" && oneChar <= "9" )){
				 }else {
					 charval="N";
					 break;
				 }
			 }else{
				 charval="N";
				 break;
			 }
		 }
		 var b_vndr_seq=sheetObj.GetCellValue(row, "vndr_seq");
		 if(charval !="N"){
			 if(sheet0_vndr_seq!=""){
				 formObject.f_cmd.value=SEARCH04;
				 var queryString="vndr_cd="+value+"&"+TrsFrmQryString(formObject);
				 sheetObj.GetSearchData("ESD_TRS_0075GS.do", queryString);
				 var cnt_cd = ComSearchEtcData(sheetObj , "ESD_TRS_0075GS.do", queryString, 'CNT_CD' );
				 
				 if(!check_sheet_vndr(cnt_cd,row, col)){
					 sheetObj.SetCellValue(row, col,"",0);
					 sheetObj.SetCellValue(row, col+1,"",0);
					 sheetObj.SelectCell(row, col);
					 return false;
				 }
			 }
		 }
		 break;
	 }
}
/**
  * VNDR check
 */
function check_sheet_vndr(value, row, col)
{
	 var formObject=document.form;
	 if( value == 0)
	 {
		 ComShowCodeMessage('COM12114', 'VNDR');
		 return false;
	 }else{
		 sheet0.SetCellValue(row, col+1,value,0);
		 var xxx=sheetObj.ColValueDup("vndr_seq");
		 if(xxx>0){
			 ComShowCodeMessage('TRS90033');
			 sheet0.SetCellValue(row, col,"",0);
			 sheet0.SetCellValue(row, col+1,"",0);
			 sheet0.SetCellEditable(xxx,'vndr_seq',1);
			 sheet0.SelectCell(xxx, 'vndr_seq');
		 }
		 return true;
	 }
}
/**
  * Agreement Header Check the required values
  */
function valcheck(){
	var formObj=document.form;
    var prmry_seq=formObj.fm_vndr_prmry_seq.value;
    var ref_no=formObj.fm_agmt_ref_no.value;
    var ofc_cd=formObj.fm_ctrt_ofc_cd.value;
    if(prmry_seq == "" || ref_no == "" || ofc_cd == "" ) {
    	ComShowCodeMessage('TRS90075');
    	return false;
    }
    return true;
}
/**
  * Agreement Header information setting 
  */
function setAgreementInfo(){
	var formObj=document.form;
	sheet1.RemoveAll();
	sheetObjects[1].DataInsert();
	sheetObjects[1].SetCellValue(1, "vndr_prmry_seq",formObj.fm_vndr_prmry_seq.value);
	sheetObjects[1].SetCellValue(1, "vndr_prmry_nm",formObj.fm_vndr_prmry_nm.value);
	sheetObjects[1].SetCellValue(1, "agmt_ref_no",formObj.fm_agmt_ref_no.value);
	sheetObjects[1].SetCellValue(1, "ctrt_ofc_cd",formObj.fm_ctrt_ofc_cd.value);
	sheetObjects[1].SetCellValue(1, "inter_rmk",formObj.fm_inter_rmk.value);
	sheetObjects[1].SetCellValue(1, "trsp_agmt_ofc_cty_cd",(formObj.fm_ctrt_ofc_cd.value).substring(0,3));
	sheetObjects[1].SetCellValue(1, "cre_ofc_cd",formObj.fm_ctrt_ofc_cd.value);
	sheetObjects[1].SetCellValue(1, "cre_usr_id",formObj.fm_account_usr_id.value);
}
/**
 * S / P information, retrieving
 */
function  vender_blur(){
	var formObj=document.form;
	var error_val="";
	var lvobj=formObj.fm_vndr_prmry_seq.value;
	if(lvobj !=""){
		for (var i=0; i < lvobj.length; i++)
		{
			var oneChar=lvobj.charAt(i)
			if (oneChar != "")
			{
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val="Y";
					break;
				}
			}
		}
	}
	if(error_val =="Y" ){
		return;
	}
    sheet1.RemoveEtcData();
	formObj.f_cmd.value=SEARCH07;
	sheetObjects[1].GetSearchData("ESD_TRS_0220GS.do",TrsFrmQryString(formObj));
	x1=ComSearchEtcData(sheetObjects[1], "ESD_TRS_0220GS.do",TrsFrmQryString(formObj), 'VNDR_NM');
	
	if(x1 !="" && x1 != undefined){ //
		formObj.fm_vndr_prmry_nm.value=x1;
	}else{
		formObj.fm_vndr_prmry_nm.value="";
	}
}
 /**
  * The presence of Office Code Lookup
  */
 function  office_blur(){
	 var formObj=document.form;
	 setgetUpper(formObj.fm_ctrt_ofc_cd);
	 var error_val="";
	 var lvobj=formObj.fm_ctrt_ofc_cd.value;
	 if(lvobj !=""){
		 for (var i=0; i < lvobj.length; i++)
		 {
			 var oneChar=lvobj.charAt(i)
			 if (oneChar != "")
			 {
				 if (  (oneChar >= "0" && oneChar <= "9" )  ){
					 error_val="Y";
					 break;
				 }
			 }
		 }
	 }
//	 if(error_val =="Y" ){
//		 return;
//	 }
	 sheet1.RemoveEtcData();
	 formObj.f_cmd.value=SEARCH06;
	 sheetObjects[1].GetSearchData("ESD_TRS_0220GS.do",TrsFrmQryString(formObj));
	 x1=ComSearchEtcData(sheetObjects[1], "ESD_TRS_0220GS.do",TrsFrmQryString(formObj), 'CTRT_OFC_CD');
	 
	 if(x1 !="" && x1 != undefined){ //
		 formObj.fm_ctrt_ofc_cd.value=x1;
	 }else{
		 formObj.fm_ctrt_ofc_cd.value="";
	 }
 }

/**
  * rep_commodity Pop-up call
  */
function rep_OnPopupClick()
 {
	var formObject=document.form;
	var cmdt_cd_val="";   	
	var rep_cmdt_cd_val="";   	
	var cmdt_desc_val="";   	
	var classId="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&func_div=1";
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 699, 520, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity Pop-up call
 */
function getCOM_ENS_rep(rowArray) {
	
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];
		formObj.fm_vndr_prmry_seq.value=colArray2;
		formObj.fm_vndr_prmry_nm.value=colArray4;
	}
}
/**
 * sheet0 OnPopupClick event
 */
function sheet0_OnPopupClick(sheetObj, row, col)
{
		var formObject=document.form;
		var cmdt_cd_val="";   
		var rep_cmdt_cd_val=""; 
		var cmdt_desc_val=""; 
		var classId="getCOM_ENS_0C1";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		formObject.hid_row.value=row;   //row 
		formObject.hid_col.value=col;   //col
	if ( sheetObj.ColSaveName(col) == "vndr_seq" ) {
		var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&func_div=2";
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 699, 520, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
}
/**
 * getCOM_ENS_0C1
 */
function getCOM_ENS_0C1(rowArray) {
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var row_val=formObj.hid_row.value;   //row hidden
		var col_val=formObj.hid_col.value;   //col hidden
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];		
	
//		sheet0.SetCellValue(row_val, col_val-1, colArray2);
//		sheet0.SetCellValue(row_val, col_val, colArray4);
		sheet0.SetCellValue(row_val, "vndr_seq", colArray2);
		sheet0.SetCellValue(row_val, "vndr_nm", colArray4);
		
	}

	val_pop_check();
}
 /**
  * val_pop_check
  */ 
function val_pop_check(){
	var formObject=document.form;
	var xxx=sheet0.ColValueDup("vndr_seq");
	if(xxx>0){
		ComShowCodeMessage('TRS90033');
		sheet0.SetCellValue(xxx, 'vndr_seq',"",0);
		sheet0.SetCellValue(xxx, 'vndr_nm',"",0);
		sheet0.SetCellEditable(xxx,'vndr_seq',1);
		sheet0.SelectCell(xxx, 'vndr_seq');
	}
}
