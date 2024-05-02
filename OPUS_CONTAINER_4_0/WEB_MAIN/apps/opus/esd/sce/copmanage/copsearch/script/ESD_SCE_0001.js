﻿/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESD_SCE_0001.js
*@FileTitle  :  COP Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22

=========================================================*/
// Global variable
var selectVal="" ;
var sheetObjects=new Array();
var sheetCnt=0;   
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** Setting variable over two sheet at tab *****/
	var sheetObj=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btns_calendar1":
				var cal=new ComCalendarFromTo();
				cal.displayType="date";
				cal.select(formObj.bkg_cre_dt1, formObj.bkg_cre_dt2, 'yyyy-MM-dd');
			  break;
			case "btns_calendar2":
				var cal=new ComCalendarFromTo();
				cal.displayType="date";
				cal.select(formObj.bkg_de_due_dt1, formObj.bkg_de_due_dt2, 'yyyy-MM-dd');
			  break;
			case "btn_retrieve":
				if(validateForm(formObj)){
				    doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
			break;
			case "btn_Close":
            	ComClosePopup();
                break;
			case "btn_new":
				formObj.reset();
				formObj.cntr_no.value='';
				formObj.cntr_no_nonbit.value='';
				formObj.cntr_no_split.value='';
				sheetObj.RemoveAll();
			break;
			case "btn_copchange":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
//					if( sheetObj.CheckedRows("chk") > 1 ) {
//						ComShowMessage(ComGetMsg('COM12177'))
//						return false;
//					}

					if(sheetObj.CheckedRows("chk")>0) {
						var iCheckRow=sheetObj.FindCheckedRow("chk");

						var copNo="";
						var bkgNo="";
						var copStsCd="";
						var arrRow=iCheckRow.split("|");
						var nodeCd=sheetObj.GetCellValue(arrRow[0] , "nod_cd");
						
						// CHECK pctl no does match
						var pctl_no_ = "";
						for (var ir = 0; ir < arrRow.length; ir ++) {
							if (ir == 0) {
								pctl_no_ = sheetObj.GetCellValue(arrRow[ir], "pctl_no");
							} else {
								if (pctl_no_ != sheetObj.GetCellValue(arrRow[ir], "pctl_no")) {
									ComShowCodeMessage("SCE01223", "COPs which have the same route");
									return false;
								}
							}
						}
						
						for (idx=0; idx<arrRow.length; idx++) {
							if( sheetObj.GetCellValue(arrRow[idx], "r_cop_sub_sts_cd") == "R" && sheetObj.GetCellValue(arrRow[idx], "cop_sts_cd") == "F" ) {
								if(nodeCd!==sheetObj.GetCellValue(arrRow[idx],"nod_cd")){
									ComShowMessage(ComGetMsg('SCE90010', 'Current Location')) ;
									return ;
								} else {
									if(idx > 0){
										copNo += "<>" ;
										bkgNo +="<>";										
										copStsCd +="<>";
									}
									copNo += sheetObj.GetCellValue( arrRow[idx] , "r_cop_no");
									bkgNo += sheetObj.GetCellValue( arrRow[idx] , "r_bkg_no");
									copStsCd += sheetObj.GetCellValue( arrRow[idx] , "cop_sts_cd");
								}
							} else {
								if(sheetObj.GetCellValue(arrRow[idx], "cop_sts_cd") == "X"){
									ComShowMessage(ComGetMsg('SCE90047')) ;
									return ;									
								} else if(nodeCd!==sheetObj.GetCellValue(arrRow[idx],"nod_cd")){
									ComShowMessage(ComGetMsg('SCE90010', 'Current Location')) ;
									return ;
								} else if(ComIsEmpty(sheetObj.GetCellValue(arrRow[idx],"act_nm"))) {
									ComShowMessage(ComGetMsg('SCE90012')) ;
									return ;
								} else {
									if(idx > 0){
										copNo += "<>" ;
										bkgNo +="<>";										
										copStsCd +="<>";										
									}
									copNo += sheetObj.GetCellValue( arrRow[idx] , "r_cop_no");
									bkgNo += sheetObj.GetCellValue( arrRow[idx] , "r_bkg_no");
									copStsCd += sheetObj.GetCellValue( arrRow[idx] , "cop_sts_cd");
								}
							}
						}
						//formObj.cop_no.value=copNo;
						//window.open ("ESD_SCE_0053.do?cop_no=" + formObj.cop_no.value, "list", "scrollbars=no,fullscreen=no,width=400,height=195,location=no,menubar=no,toolbar=no");
						openESD_SCE_0053(copNo, bkgNo, copStsCd);						
					} else {
						ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
					}
				}
			break;
			case "btn_bkginfo":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					openESD_SCE_0915(sheetObj);
				}
			break;
//			case "btn_batchupdate":
//				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
//					openESD_SCE_0010(sheetObj);
//				}
//			break;
			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
			break;
			case "btn_statuschange":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			case "btn_history":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					var arrRow = sheetObj.FindCheckedRow("chk").split("|");
					formObj.cop_no.value=sheetObj.GetCellValue(arrRow[0], 'r_cop_no');
					openESD_SCE_0071(formObj);
				}
			break;
			case "btn_mastersave":
				openESD_SCE_0118();
			break;
			case "btn_test":
				openTest();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

function openESD009Screen(url, copNo, boundName, iscompled, isnodchg, nodcd, isfrmchg, frmcd, bkg_no, cop_sts_cd){
	var paramUrl = "pgmNo=ESD_SCE_0009&cop_no="+copNo+"&bound_name="+boundName+"&iscompled="+iscompled+"&isnodchg="+isnodchg+"&nodcd="+nodcd
	             + "&isfrmchg="+isfrmchg+"&frmcd="+frmcd+"&bkg_no="+bkg_no+"&cop_sts_cd="+cop_sts_cd;
	var newWin =  ComOpenWindow("ESD_SCE_0009.do?"+paramUrl,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1020px;dialogHeight:560px" , true);
	return false;
}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//changing initializing function name
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//adding last function name
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;
	if(formObj.cntr_no.value != ''){
		//CheckDigitSplit(formObj.cntr_no_nonbit, 'cntr_no_split', 'cntr_no');		
		validateForm(formObj);
	}
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    ComSetUIItem(sheetObjects[0], document.form, "SCE", "ESD_SCE_0001");
//    initControl();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetNo) {
		case 1:      //IBSheet1 init
		    with(sheetObj){
			      (29, 8, 0, true);
			      var HeadTitle0="|STS|Expt|COP No|COP DTL Seq|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Status\nChange|Manual\nChange|Activity Code|Current\nActivity|Current\nLocation"
			    	            +"|Planned D/T|Planned D/T|Estimated D/T|Estimated D/T|Delivery Planned D/T|Delivery Planned D/T|Delivery Estimated D/T|Delivery Estimated D/T|Delivery Appointment D/T|Delivery Appointment D/T||||PCTL";
			      var HeadTitle1="|STS|Expt|COP No|COP DTL Seq|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Status\nChange|Manual\nChange|Activity Code|Current\nActivity|Current\nLocation"
			    	            +"|Date|Time|Date|Time|Date|Time|Date|Time|Date|Time||||PCTL";
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"},
			                  { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",     Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cop_ext_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:106,  Align:"Center",  ColMerge:1,   SaveName:"r_cop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cop_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"r_bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no_v",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mst_lcl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cop_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cop_sts_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cop_sub_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"man_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pln_date",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pln_time",          KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"estm_date",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"estm_time",         KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"dlv_pln_date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"dlv_pln_time",      KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"dlv_estm_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"dlv_estm_time",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"due_date",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"due_time",          KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"r_cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"totcnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"r_cop_sub_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pctl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetImageList(0,"/opuscntr/img/opus/ico_b.gif");
			      SetImageList(1,"/opuscntr/img/opus/ico_g.gif");
			      SetImageList(2,"/opuscntr/img/opus/ico_r.gif");
			      SetColProperty('cop_sub_sts_cd', {ComboText:'YES|NO', ComboCode:'Y|N'} );
			      SetDataLinkMouse(true);
//			      SetSheetHeight(380 );
			      resizeSheet(); 

	      }
		break;
	}
} 

function sheet1_OnDblClick(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "cop_sub_sts_cd" ) {
	} else {
		var newForm="<form name='form2' method='post'>" ;
		newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.GetCellValue(row, "r_cop_no") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.GetCellValue(row, "r_bkg_no") + "'>" ;
		//newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(row, "r_bkg_no_split") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.GetCellValue(row, "r_cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='cop_mst_bkg'      value='" + sheetObj.GetCellValue(row, "mst_lcl_cd") + "'>" ;
		newForm += "  <input type='hidden' name='cop_sts'      value='" + sheetObj.GetCellValue(row, "cop_sts_nm") + "'>" ;
		newForm += "  <input type='hidden' name='pgmNo'      value='ESD_SCE_0006'>" ;		
		newForm += "</form>" ;
		document.body.innerHTML =newForm ;
		var formObj=document.form2 ;
		formObj.action="ESD_SCE_0006.do?parentPgmNo=ESD_SCE_M001";
		formObj.submit() ;
	}
}

// handling process of the sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //retrieving
       		if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.cntr_no) && ComIsEmpty(formObj.bkg_cre_dt1) && ComIsEmpty(formObj.bkg_cre_dt2) && ComIsEmpty(formObj.so_no) && ComIsEmpty(formObj.cop_no) && ComIsEmpty(formObj.ref_no)){
       			
	        }else if(formObj.bkg_cre_dt1.value > formObj.bkg_cre_dt2.value){
	        	ComShowMessage("To-date must be later than From-date");
	        	formObj.bkg_cre_dt2.value=""; 
	        	return false;
			}
       		else{
	        	formObj.page_no.value="1";
				formObj.f_cmd.value=SEARCHLIST;
				formObj.target="_self" ;
				sheetObj.DoSearch("ESD_SCE_0001GS.do", SceFrmQryString(formObj) );
         	}
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){//no data	
				ComShowCodeMessage("COM132501");
			}else{	
				 sheetObj.Down2Excel({ HiddenColumn:true,Merge:true,TreeLevel:false});
			}
			break;
		case IBSAVE:
			if( sheetObj.CheckedRows("chk") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			} else {
				if( confirm("Are you sure you want to proceed?") ) {
					formObj.f_cmd.value=MODIFY;
					sheetObj.DoSave("ESD_SCE_0001GS.do", SceFrmQryString(formObj), "chk", false, true);
					afterStatusChange(sheetObj, '');
				}
			}
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt=sheetObj.RowCount();
    var formObj=document.form;	
	var pageNo=formObj.page_no.value;
	var pageRows=formObj.pagerows.value;
	var startRow=(pageNo-1) * pageRows+2;
	if(sheetObj.GetTotalRows()> 0){
		for(var i=startRow; i<totalCnt+2; i++){
			if(sheetObj.GetCellValue(i, "cop_sts_cd") == 'F' || sheetObj.GetCellValue(i, "cop_sts_cd") == 'T'){
				sheetObj.SetCellEditable(i, "cop_sub_sts_cd",1);
			}else{
				sheetObj.SetCellEditable(i, "cop_sub_sts_cd",0);
			}
		}		
	}
}

function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) {
    	return;
    }
	var formObj = document.form;
	var currPageNo = Number(formObj.page_no.value);
	formObj.page_no.value = currPageNo + 1;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch("ESD_SCE_0001GS.do", selectVal+"&"+ "cur_page=" + currPageNo, {Append:true} );
}

/**
 * calling popup of booking info
 * @param sheetObj
 * @return
 */
function openESD_SCE_0915(sheetObj){
	var row=sheetObj.GetSelectRow();
	var bkgNo=sheetObj.GetCellValue(row, "r_bkg_no") ;
	//var bkgNoSplit = sheetObj.CellValue(row, "r_bkg_no_split") ;
	var copno=sheetObj.GetCellValue(row, "r_cop_no") ;
	newForm="<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='bkg_no'       value='" + bkgNo + "'>" ;
	//newForm += "  <input type='hidden' name='bkg_no_split' value='" + bkgNoSplit + "'>" ;
	newForm += "  <input type='hidden' name='cop_no' value='" + copno + "'>" ;
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0915'>" ;	
	newForm += "</form>"

	var formObj=document.form1 ;
	var paramUrl="pgmNo=ESD_SCE_0915&cop_no="+copno+"&bkg_no="+bkgNo;
	var newWin =  ComOpenWindow("ESD_SCE_0915.do?"+paramUrl,  "bkg_info_win",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:430px" , true);
}

/**
 * calling popup of master change
 * @return
 */
function openESD_SCE_0118(){
	var paramUrl="pgmNo=ESD_SCE_0118";
    var newWin =  ComOpenWindow("ESD_SCE_0118.do?"+paramUrl,  "Master",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:430px" , true);
    return;
}

/**
 * calling popup of cop change
 * @param formObj
 * @return
 */
function openESD_SCE_0053(cop_no, bkg_no, cop_sts_cd) {
	var newForm="<form name='form1' action='ESD_SCE_0053.do' method='post' target='COPchange' >" ;
	newForm += "  <input type='hidden' name='cop_no'       value='" + cop_no + "'>" ;
	newForm += "  <input type='hidden' name='bkg_no'       value='" + bkg_no + "'>" ;
	newForm += "  <input type='hidden' name='cop_sts_cd'       value='" + cop_sts_cd + "'>" ;	
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0053'>" ;
	newForm += "</form>";
//	document.all.innerHTML=newForm ;

//	var paramUrl="pgmNo=ESD_SCE_0053&cop_no="+cop_no+"&bkg_no="+bkg_no+"&cop_sts_cd="+cop_sts_cd;
//    var newWin =  ComOpenWindow("ESD_SCE_0053.do?"+paramUrl,  window,  "width=600,height=200,scroll:no;status:no;resizable:yes;help:no;" , false);
//    return false;
    
    // URL method : GET -> POST because URL length exceed
	document.getElementById("new_form_div").innerHTML = newForm ;
	var formObj = document.all.form1;
	var newWin = window.open("","COPchange", "width=600,height=200,scroll:no;status:no;resizable:yes;help:no," + getCenterXY(600, 200));
	formObj.submit() ;
    return false;
}

/**
 * calling popup of cop history
 * @param formObj
 * @return
 */
function openESD_SCE_0071(formObj){
	var cop_no=formObj.cop_no.value ;

	var paramUrl="pgmNo=ESD_SCE_0071&mainPage=false&cop_no="+cop_no;
    var newWin =  ComOpenWindow("ESD_SCE_0071_POP.do?"+paramUrl,  "cop_history",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:900px;dialogHeight:530px" , true);
}

function openTest(){
	var cntr_no="TRLU8979119" ;//TRLU8979119
	newForm="<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cntr_no'       value='" + cntr_no + "'>" ;
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0001'>" ;	
	newForm += "</form>"
//	document.all.new_form.innerHTML=newForm ;
	var formObj=document.form1 ;
	var newWin=window.open("","COPinquiry", "width=1000,height=580," + getCenterXY(1000, 580));
	formObj.action="ESD_SCE_0001.do" ;
	formObj.target="COPinquiry" ;
	formObj.submit() ;	
}

//
//function openESD_SCE_0010(sheetObj) {
//	var chkCnt = sheetObj.CheckedRows(0) ;
//
//	if( chkCnt==0 ) {
//		ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
//		return false ;
//	}
//
//	var chkRows = sheetObj.FindCheckedRow(0) ;
//	var arrChkRows = chkRows.split("|") ;
//	var newForm = "" ;
//
//	newForm += "<form name='form1' method='post'>" ;
//	for(i=0 ; i<arrChkRows.length-1; i++) {
//		if( sheetObj.CellValue(arrChkRows[i], "cop_sts_cd")!="T" && sheetObj.CellValue(arrChkRows[i],"cop_sts_cd")!="C" ) {
//			ComShowMessage(ComGetMsg('SCE90011')) ;
//			return false ;
//		}
//		newForm += "  <input type='hidden' name='cop_no'      value='" + sheetObj.CellValue(arrChkRows[i], "r_cop_no") + "'>" ;
//		//newForm += "  <input type='hidden' name='cop_grp_seq' value='" + sheetObj.CellValue(arrChkRows[i], "cop_grp_seq") + "'>" ;
//		newForm += "  <input type='hidden' name='cop_dtl_seq' value='" + sheetObj.CellValue(arrChkRows[i], "cop_dtl_seq") + "'>" ;
//		newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[i], "r_bkg_no") + "'>" ;
//		//newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[i], "bkg_no_split") + "'>" ;
//		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(arrChkRows[i], "r_cntr_no") + "'>" ;
//		newForm += "  <input type='hidden' name='act_cd'      value='" + sheetObj.CellValue(arrChkRows[i], "act_cd") + "'>" ;
//		newForm += "  <input type='hidden' name='act_nm'      value='" + sheetObj.CellValue(arrChkRows[i], "act_nm") + "'>" ;
//		newForm += "  <input type='hidden' name='nod_cd'      value='" + sheetObj.CellValue(arrChkRows[i], "nod_cd") + "'>" ;
//	}
//	newForm += "</form>" ;
//	document.all.new_form.innerHTML = newForm ;
//	var formObj = document.form1 ;
//	var newWin  = window.open("","cop_batch_update", "width=704,height=166," + getCenterXY(704, 166));
//	formObj.action = "ESD_SCE_0010.do" ;
//	formObj.target = "cop_batch_update" ;
//	formObj.submit() ;
//	newWin.focus() ;
//}

function getCenterXY(w, h){
	var height=screen.availHeight ;
	var width=screen.availWidth ;
	var leftpos=width/2 - w/2;
	var toppos=height/2 - h/2;
	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;
	return "left=" + leftpos + ", top=" + toppos ;
}

/*
 * checking bkg_no duplication
 */
function ibSheet_BKGCheck(sheetObj, sStatus) {
	if( sheetObj.CheckedRows("chk") < 1 ) {
		ComShowMessage("Please select at least one.");
		return false;
	}
	var fromRow=0;
	var docPrvBkgno="";
	var sRow=sheetObj.FindCheckedRow(sStatus);
	var arrRow=sRow.split("|");
	for( var ir=0; ir < arrRow.length-1; ir++ ) {
		fromRow=arrRow[ir];
		if( ir == 0 ) {
			docPrvBkgno=doSepRemove(sheetObj.GetCellValue(fromRow, "r_bkg_no"));//+sheetObj.GetCellValue(fromRow, "r_bkg_no_split"), " ");
		} else {
			if( docPrvBkgno != doSepRemove(sheetObj.GetCellValue(fromRow, "r_bkg_no"))){//+sheetObj.GetCellValue(fromRow, "r_bkg_no_split"), " ") ) {
				sheetObj.SetCellValue(fromRow,"chk","0",0);
				sheetObj.SetRowStatus(fromRow,"R");
			}
		}
	}
	return true;
}

function sheet1_OnChange(sheetObj,Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk" ) {
		if( Value == "1" ) {
			sheetObj.SetRowStatus(Row,"U");
		} else {
			sheetObj.SetRowStatus(Row,"R");
		}
	} else if( sheetObj.ColSaveName(Col) == "cop_sub_sts_cd" ) {
		if( sheetObj.GetCellValue(Row, "chk") == "1" ) {
			sheetObj.SetRowStatus(Row,"U");
		} else {
			sheetObj.SetRowStatus(Row,"R");
		}
	}
}

/**
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd
 */
//function sheet1_OnSaveEnd(sheetObj, errMsg) {
function afterStatusChange(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		var iCheckRow=sheetObj.FindCheckedRow("chk");
		var arrRow=iCheckRow.split("|");
		var fromRow=0;
		for( var ir=0; ir < arrRow.length-1; ir++ ) {
			fromRow=arrRow[ir];
			if( sheetObj.GetCellValue(fromRow, "cop_sub_sts_cd") == "Y" && sheetObj.GetCellValue(fromRow, "cop_sts_cd") == "F" ) {
				sheetObj.SetCellValue(fromRow, "r_cop_sub_sts_cd","R",0);
			} else {
				sheetObj.SetCellValue(fromRow, "r_cop_sub_sts_cd","",0);
			}
		}
	}
}

function sheet1_OnAfterColumnMove(sheetObj, col, newPos){
	var newColName=sheetObj.ColSaveName(newPos) ;
	switch (newColName) {
		case "bkg_no":
			if (col > newPos) {
				newPos=newPos+1;
			}
			//sheetObj.MoveColumnPos("r_bkg_no_split", newPos, false);
		break;
		default:
			break;
	}
}

/**
 * deleting char for sep
 */
function doSepRemove(obj, sep) {
	var ch="";
	var lvobj="";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch="";
		} else {
			ch=obj.charAt(i);
		}
		lvobj=lvobj + ch;
	}
	return lvobj;
}

 /**
  * handling process for input validation
  */
function validateForm(formObj){
	var result=true ;
	// checking option
	if( !isInputField(formObj) ) {
		result=false ;
	} else if( !ComIsEmpty(formObj.cntr_no) ) { // Container No
	    if( ComIsEmpty(formObj.bkg_cre_dt1) && ComIsEmpty(formObj.bkg_cre_dt2) ){
	        var now=new Date();  
	        var year=now.getFullYear();  
            var month=now.getMonth() + 1;  
	        //var day=now.getDay();  
	        var date=now.getDate();  
            //var firstDate = new Date(year, month-1, 1);  
            var fm_year=now.getFullYear()-2;
            var fm_date=now.getDate()+1; 
	        var fm_mon=month;
	        var to_last_date=new Date(year, month, 0).getDate();   
	        if (to_last_date==date){
              fm_date=new Date(fm_year, month+1, 1).getDate();     
              fm_mon=now.getMonth() + 1;
	        }
	        var fm_mon=fm_mon<10?"0"+fm_mon:fm_mon;
	        var to_mon=month<10?"0"+month:month;
	        var fm_edate=fm_date<10?"0"+fm_date:fm_date;
	        var to_edate=date<10?"0"+date:date;
			formObj.bkg_cre_dt1.value=fm_year+"-"+fm_mon+"-"+fm_edate;
			formObj.bkg_cre_dt2.value=year+"-"+to_mon+"-"+to_edate;
	    } else if( ComIsEmpty(formObj.bkg_cre_dt1) ){
	        ComShowMessage(ComGetMsg('SCE90014','BKG Date'));
//			formObj.bkg_cre_dt1.focus();
			result=false ;
	    } else if( ComIsEmpty(formObj.bkg_cre_dt2) ){
	        ComShowMessage(ComGetMsg('SCE90014','BKG Date'));
//			formObj.bkg_cre_dt2.focus();
			result=false ;
	    } else if( !ComIsDate(formObj.bkg_cre_dt1) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
//			formObj.bkg_cre_dt1.focus();
			result=false ;
		} else if( !ComIsDate(formObj.bkg_cre_dt2) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
//			formObj.bkg_cre_dt2.focus();
			result=false ;
		} else if ( dateCalcurationNew(formObj.bkg_cre_dt1.value , formObj.bkg_cre_dt2.value) > 1095) {
			ComShowMessage("Possible inquiry peroid is limited to 3 Years.");
//			formObj.bkg_cre_dt1.focus();
			result=false ;
		}
	} else if( !ComIsEmpty(formObj.cop_no) && !ChkObjValid(formObj.cop_no, 14, "COP No") ) { // Cop No
		if(formObj.cop_no.value.length > 14){
			formObj.cop_no.value=formObj.cop_no.value.substr(0,14);
		}
		result=false ;
	} else if ( dateCalcurationNew(formObj.bkg_cre_dt1.value , formObj.bkg_cre_dt2.value) > 1095) {
			ComShowMessage("Possible inquiry peroid is limited to 3 Years.");
			formObj.bkg_cre_dt1.focus();
			result=false ;
	} else if( result && (ComIsEmpty(formObj.cntr_no) || !ChkObjValid(formObj.cntr_no, 11, "Container No")) && !ComIsEmpty(formObj.bkg_cre_dt1) && !ComIsEmpty(formObj.bkg_cre_dt2) ) { // Container No
	  if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.cntr_no) && ComIsEmpty(formObj.cop_no) && ComIsEmpty(formObj.so_no) && ComIsEmpty(formObj.ref_no)){
			ComShowMessage("Container No. is mandatory item.");
			formObj.cntr_no.focus();
			result=false ;
	  }
	}
	return result ;
}

function dateCalcurationNew(objFrom, objTo) {
	var lvfrmDate=doSepRemove(doSepRemove(objFrom, " "), "-");
	var lvtoDate=doSepRemove(doSepRemove(objTo, " "), "-");
	var lvFrom=lvfrmDate.substring(4, 6)+"-"+lvfrmDate.substring(6)+"-"+lvfrmDate.substring(0, 4);
	var lvTo=lvtoDate.substring(4, 6)+"-"+lvtoDate.substring(6)+"-"+lvtoDate.substring(0, 4);
	var fromDay=new Date(lvFrom);
	var toDay=new Date(lvTo);
	var objFT=(toDay.getTime()-fromDay.getTime()) / (24*60*60*1000);
	return objFT;
}

function onEnterKey(textname) {
	if (event.keyCode == 13) {
      	var sheetObj=sheetObjects[0];
	    var formObj=document.form;
	    textname.value=textname.value.toUpperCase();
		if(validateForm(formObj)){
		    doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
}

function chkBKGDates(formObj, isEmptyBKGDates) {
	var result=true ;
	var emptyBKGDates=isEmptyBKGDates!=null ? isEmptyBKGDates : ComIsEmpty(formObj.bkg_cre_dt1)&&ComIsEmpty(formObj.bkg_cre_dt2);
	if( !emptyBKGDates ) {
		if( !ComIsDate(formObj.bkg_cre_dt1) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
			formObj.bkg_cre_dt1.focus();
			result=false ;
		} else if( !ComIsDate(formObj.bkg_cre_dt2) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
			formObj.bkg_cre_dt2.focus();
			result=false ;
		}
	}
	return result ;
}

function isInputField(formObj) {
	var result=false ;
	var fieldType=null ;
	for(i=0; i<formObj.length; i++) {
		fieldType=formObj[i].type;
		if( fieldType!="hidden" && !formObj[i].readOnly ) {
			if( !ComIsEmpty(formObj[i]) ) {
				result=true;
				break;
			}
		}
	}
	if( !result ) {
		ComShowMessage(ComGetMsg('SCE90016'));
		formObj.bkg_no.focus();
	} else {
		if( ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.cntr_no) && ComIsEmpty(formObj.so_no) && ComIsEmpty(formObj.cop_no) && ComIsEmpty(formObj.ref_no) && !ComIsEmpty(formObj.bkg_cre_dt1) && !ComIsEmpty(formObj.bkg_cre_dt2) ) { // COP 검색
			ComShowMessage("Container No. is mandatory item.");
			result=false;
		}
	}
	return result;
}

function ChkObjValid(obj, len, msg) {
	var result=true ;
	if( obj.value.length !=len ) {
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
		obj.focus();
		result=false;
	}
	return result ;
}

function CheckDigit(obj){
    var rtnval=cntrCheckDigit(obj);
    obj.value=rtnval;
}

// setting checkdigit of container no.
function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo=obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value='';
		document.getElementById(valueTarget).value=cntrNo;
		return;
	}
//	ComChkObjValid(obj, 'eng_num', true, 10);
	var sum=0;
 	cntrNo=cntrNo.toUpperCase();
	//for(var i=0;i<10;i++){
	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
	//}
	sum=ComGetCntrChkDgt( cntrNo.substr(0,10));
	var mod=sum % 11;
	if (mod == 10) mod=0;
	if( isNaN(mod)){
		document.getElementById(bitTarget).value='';
		document.getElementById(valueTarget).value=obj.value;
	}else{
		obj.value=cntrNo.substr(0,10);
		document.getElementById(bitTarget).value=mod;
		document.getElementById(valueTarget).value=obj.value + mod;
	}
}

function researchScreen(){
	//non-logic function
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if(validateForm(formObj)){
	    doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}	
}

function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 