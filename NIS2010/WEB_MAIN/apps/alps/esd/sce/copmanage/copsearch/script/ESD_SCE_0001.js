﻿/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0001.js
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 2009.02.26 - 안정선 - CSR NO. N200902030014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
* 2012-04-26 [CHM-201217462]
=========================================================*/

// 공통전역변수
var selectVal = "" ;
var sheetObjects = new Array();
var sheetCnt = 0;
var processFlag = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btns_calendar1":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.bkg_cre_dt1, formObj.bkg_cre_dt2, 'yyyy-MM-dd');						
			  break;
			case "btns_calendar2":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_de_due_dt1, 'bkg_de_due_dt1',formObj.bkg_de_due_dt2, 'bkg_de_due_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.bkg_de_due_dt1, formObj.bkg_de_due_dt2, 'yyyy-MM-dd');				
			  break;
			case "btn_retrieve":
				if(validateForm(formObj)){
				    doActionIBSheet(sheetObj,formObj,IBSEARCH);

				}
			break;
			case "btn_new":
				formObj.reset();
				formObj.cntr_no_nonbit.value = '';
				formObj.cntr_no_split.value = '';
				sheetObj.RemoveAll();
			break;
			case "btns_bkg_no":
				if(processFlag) return;
				rep_Multiful_inquiry(srcName);
				break;

			case "btn_copchange":

				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					if(sheetObj.CheckedRows("chk")>0) {
						var iCheckRow = sheetObj.FindCheckedRow("chk");
						var copNo = "";
						var bkgNo = "";
						var copStsCd = "";

						//가져온 행을 배열로 반든다.
						var arrRow = iCheckRow.split("|");
						var nodeCd = sheetObj.CellValue(arrRow[0] , "nod_cd") ;

						for (idx=0; idx<arrRow.length-1; idx++) {
					
							if( sheetObj.CellValue(arrRow[idx], "r_cop_sub_sts_cd") == "R" && sheetObj.CellValue(arrRow[idx], "cop_sts_cd") == "F" ) {
								if(nodeCd!==sheetObj.CellValue(arrRow[idx],"nod_cd")){
									ComShowMessage(ComGetMsg('SCE90010', 'Current Location')) ;
									return ;
								} else {
									if(idx > 0){
										copNo += "<>" ;
										bkgNo +="<>";										
										copStsCd +="<>";
									}
									copNo += sheetObj.CellValue( arrRow[idx] , "r_cop_no");
									bkgNo += sheetObj.CellValue( arrRow[idx] , "r_bkg_no");									
									copStsCd += sheetObj.CellValue( arrRow[idx] , "cop_sts_cd");
								}
							} else {
								if(sheetObj.CellValue(arrRow[idx], "cop_sts_cd") == "X"){
									ComShowMessage(ComGetMsg('SCE90047')) ;
									return ;									
								} else if(nodeCd!==sheetObj.CellValue(arrRow[idx],"nod_cd")){
									ComShowMessage(ComGetMsg('SCE90010', 'Current Location')) ;
									return ;
								} else if(ComIsEmpty(sheetObj.CellValue(arrRow[idx],"act_nm"))) {
									ComShowMessage(ComGetMsg('SCE90012')) ;
									return ;
								} else {
									if(idx > 0){
										copNo += "<>" ;
										bkgNo +="<>";										
										copStsCd +="<>";										
									}
									copNo += sheetObj.CellValue( arrRow[idx] , "r_cop_no");
									bkgNo += sheetObj.CellValue( arrRow[idx] , "r_bkg_no");									
									copStsCd += sheetObj.CellValue( arrRow[idx] , "cop_sts_cd");									
								}
							}
						}
						formObj.cop_no.value = copNo;
						//window.open ("ESD_SCE_0053.do?cop_no=" + formObj.cop_no.value, "list", "scrollbars=no,fullscreen=no,width=400,height=195,location=no,menubar=no,toolbar=no");
//						alert("bkgNo = " + bkgNo + " / copStsCd = " + copStsCd);
						openESD_SCE_0053(formObj, bkgNo, copStsCd);						
					} else {
						ComShowMessage(ComGetMsg('COM12119', 'COP')) ;
					}
				}
				
			break;

			case "btn_bkginfo":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					if(sheetObj.CheckedRows("chk") > 0) {
						var iCheckRow = sheetObj.FindCheckedRow("chk");
						var arrRow = iCheckRow.split("|");
						if(arrRow.length > 2){
									ComShowMessage(ComGetMsg('COM12113', 'only one row in a table.')) ;
						}
						else{
						openESD_SCE_0915(sheetObj);
						}
					}
				}
			break;

			case "btn_batchupdate":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					openESD_SCE_0010(sheetObj);
				}
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
			break;

			case "btn_statuschange":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			// minestar - COP-History 관련 시작
			case "btn_history":
				
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					
					formObj.cop_no.value =  sheetObj.CellValue(sheetObj.FindCheckedRow("chk").substring(0,1), 'r_cop_no');

					if(sheetObj.CheckedRows("chk") > 0) {
						var iCheckRow = sheetObj.FindCheckedRow("chk");
						var arrRow = iCheckRow.split("|");
						if(arrRow.length > 2){
									ComShowMessage(ComGetMsg('COM12113', 'only one row in a table.')) ;
						}
						else{
							openESD_SCE_0071(formObj);
						}
					}
				}
			
//				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
//					formObj.cop_no.value =  sheetObj.CellValue(sheetObj.FindCheckedRow("chk").substring(0,1), 'r_cop_no');
//					//window.open ("ESD_SCE_0071.do?pgmNo=ESD_SCE_0071&cop_no="+ formObj.cop_no.value	 , "list", "scrollbars=no,fullscreen=no,width=800,height=600,resizable,location=no,menubar=no,toolbar=no,titlebar=no");
//					openESD_SCE_0071(formObj);
//				}
				
			break;
			// minestar - COP-History 관련 끝

            // 20080731 - COP-Inquiry 신용호
			case "btn_mastersave":
			     //window.open("ESD_SCE_0118.do","Master","scrollbars=no,fullscreen=no,width=1300,height=680,resizable");
				openESD_SCE_0118();
			break;

			case "btn_test":
			     //window.open("ESD_SCE_0001.do?pgmNo=ESD_SCE_0001&cntr_no=TRLU8979119","COPinquiry","location=no,menubar=no,toolbar=no,titlebar=no,scrollbars=no,fullscreen=no,width=1000,height=580,resizable");
				openTest();
			break;
			
/* 20070927 삭제 요청
			case "btn_terminalchange":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					window.open ("ESD_SCE_0055.do?VVD_POP=Y", "list", "scrollbars=no,fullscreen=no,width=530,height=150");
				}
			break;
*/
		} // end switch
	} catch(e) {

		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function openESD009Screen(url, copNo, boundName, iscompled, isnodchg, nodcd, isfrmchg, frmcd, bkg_no, cop_sts_cd){
	//window.open(openStr, "list2", "scrollbars=no,fullscreen=no,width=1020,height=560");
	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0009'>" ;	
	newForm += "  <input type='hidden' name='cop_no' value='"+copNo+"'>" ;
	newForm += "  <input type='hidden' name='bound_name'  value='"+boundName+"'>" ;
	newForm += "  <input type='hidden' name='iscompled'  value='"+iscompled+"'>" ;
	newForm += "  <input type='hidden' name='isnodchg'  value='"+isnodchg+"'>" ;
	newForm += "  <input type='hidden' name='nodcd'  value='"+nodcd+"'>" ;
	newForm += "  <input type='hidden' name='isfrmchg'  value='"+isfrmchg+"'>" ;
	newForm += "  <input type='hidden' name='frmcd'  value='"+frmcd+"'>" ;
	newForm += "  <input type='hidden' name='bkg_no'  value='"+bkg_no+"'>" ;
	newForm += "  <input type='hidden' name='cop_sts_cd'  value='"+cop_sts_cd+"'>" ;
	newForm += "</form>"
	
	document.all.new_form.innerHTML = newForm ;
	//var formObj = document.form1 ;
	var formObj = document.all.new_form.document.form1 ;
	
	var paramUrl = "pgmNo=ESD_SCE_0009&cop_no="+copNo+"&bound_name="+boundName+"&iscompled="+iscompled+"&isnodchg="+isnodchg+"&nodcd="+nodcd+
	"&isfrmchg="+isfrmchg+"&frmcd="+frmcd+"&bkg_no="+bkg_no+"&cop_sts_cd="+cop_sts_cd;
//	var newWin  = window.open("","cop_manual_change", "width=1020,height=560," + getCenterXY(1020, 560));
//	var newWin = window.showModalDialog("", "cop_manual_change", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1020px;dialogHeight:560px");
	//var newWin = window.showModalDialog("ESD_SCE_0009.do?"+paramUrl, "cop_manual_change", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1020px;dialogHeight:560px");
	var newWin = window.showModalDialog("ESD_SCE_0009.do?"+paramUrl, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1020px;dialogHeight:560px");
//	formObj.action = openStr ;
//	formObj.method = "post";
//	formObj.action = url ;
//	formObj.target = "cop_manual_change" ;
//	formObj.submit() ;	


}



/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj = document.form;
	
	if(formObj.cntr_no.value != ''){
		CheckDigitSplit(formObj.cntr_no_nonbit, 'cntr_no_split', 'cntr_no');		
		validateForm(formObj);
	}


    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    
    

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
		
	switch(sheetNo) {
		case 1:      //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				style.height = 380 ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, document.form.row_size.value);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(28, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle0 = "|STS|COP No|COP DTL Seq|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Status\nChange|Activity Code|Current\nActivity|Current\nLocation|Planned D/T|Planned D/T|Estimated D/T|Estimated D/T|Delivery Planned D/T|Delivery Planned D/T|Delivery Estimated D/T|Delivery Estimated D/T|Delivery Appointment D/T|Delivery Appointment D/T" ;
				var HeadTitle1 = "|STS|COP No|COP DTL Seq|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Status\nChange|Activity Code|Current\nActivity|Current\nLocation|Date|Time|Date|Time|Date|Time|Date|Time|Date|Time" ;

				//var HeadTitle0 = "|STS|Expt|COP No|COP DTL Seq|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Activity Code|Current\nActivity|Current\nLocation|Planned D/T|Planned D/T|Estimated D/T|Estimated D/T|Delivery Planned D/T|Delivery Planned D/T|Delivery Estimated D/T|Delivery Estimated D/T|Delivery Appointment D/T|Delivery Appointment D/T" ;
				//var HeadTitle1 = "|STS|Expt|COP No|COP DTL Seq|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Activity Code|Current\nActivity|Current\nLocation|Date|Time|Date|Time|Date|Time|Date|Time|Date|Time" ;

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,    SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "chk", false, "", dfNone, 0, true, true);//check box
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
//				InitDataProperty(0, cnt++, dtImage, 40, daCenter, true, "cop_ext_sts_cd", false, "", dfNone, 0, false, true);//Exception
				InitDataProperty(0, cnt++, dtData, 106, daCenter, true, "r_cop_no", false, "", dfNone, 0, false, true);//COP No
				//InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cop_grp_seq", false, "", dfNone, 0, false, true);//COP BKG seq
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cop_dtl_seq", false, "", dfNone, 0, false, true);//COP DTL seq
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "r_bkg_no", false, "", dfNone, 0, false, true);//BKG No
				//InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "r_bkg_no_split", false, "", dfNone, 0, false, true);//BKG Split No
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no_v", false, "", dfNone, 0, false, true);//Container No
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);//Container Type Size

				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cntr_vol_qty", false, "", dfNone, 0, false, true);// Container Vol
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "mst_lcl_cd", false, "", dfNone, 0, false, true);// Partial Container ( Master)
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cop_sts_cd", false, "", dfNone, 0, false, true);//COP Status CD
				InitDataProperty(0, cnt++, dtData, 70, daLeft,   true, "cop_sts_nm", false, "", dfNone, 0, false, true);//COP Status
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "cop_sub_sts_cd", false, "", dfNone, 0, true, true);//COP Status
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft,  true, "act_cd", false, "", dfNone, 0, false, true);//Current Activities
				InitDataProperty(0, cnt++, dtData, 150, daLeft,  true, "act_nm", false, "", dfNone, 0, false, true);//Current Activities
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "nod_cd", false, "", dfNone, 0, false, true);//Current Location
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "pln_date", false, "", dfDateYmd, 0, false, true);//Planned Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "pln_time", false, "", dfTimeHm, 0, false, true);//Planned Time

				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "estm_date", false, "", dfDateYmd, 0, false, true);//Estimated Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "estm_time", false, "", dfTimeHm, 0, false, true);//Estimated Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "dlv_pln_date", false, "", dfDateYmd, 0, false, true);//Delivery Planned Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "dlv_pln_time", false, "", dfTimeHm, 0, false, true);//Delivery Planned Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "dlv_estm_date", false, "", dfDateYmd, 0, false, true);//Delivery Estimated Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "dlv_estm_time", false, "", dfTimeHm, 0, false, true);//Delivery Estimated Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "due_date", false, "", dfDateYmd, 0, false, true);//Delivery Apointment Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "due_time", false, "", dfTimeHm, 0, false, true);//Delivery Apointment Time
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "r_cntr_no", false, "", dfNone,   0,     false,  true);//Delivery Apointment Time
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "totcnt", false, "", dfNone,   0,     false,  true);//Delivery Apointment Time				
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "r_cop_sub_sts_cd", false, "", dfNone, 0, false, true);

				ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
				ImageList(1) = "/hanjin/img/alps/ico_g.gif" ;
				ImageList(2) = "/hanjin/img/alps/ico_r.gif" ;

				InitDataCombo(0, 'cop_sub_sts_cd', 'YES|NO', 'Y|N');

				DataLinkMouse = true;

			}
		break;
	}
}

function sheet1_OnDblClick(sheetObj, row, col, value) {

	if( sheetObj.ColSaveName(col) == "cop_sub_sts_cd" ) {

	} else {
		var newForm  = "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(row, "r_cop_no") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(row, "r_bkg_no") + "'>" ;
		//newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(row, "r_bkg_no_split") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(row, "r_cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='cop_mst_bkg'      value='" + sheetObj.CellValue(row, "mst_lcl_cd") + "'>" ;
		newForm += "  <input type='hidden' name='cop_sts'      value='" + sheetObj.CellValue(row, "cop_sts_nm") + "'>" ;		
		newForm += "  <input type='hidden' name='pgmNo'      value='ESD_SCE_0006'>" ;	
		newForm += "</form>" ;
		document.all.new_form.innerHTML = newForm ;
		var formObj = document.form1 ;
		if(document.form.adm_flg.value=='Y'){//2012-04-26 [CHM-201217462]
			formObj.action = "ESD_SCE_0159.do?adm_flg=Y";
		}else if(document.form.adm_flg.value !='Y'){
			formObj.action = "ESD_SCE_0006.do";
		}
//		formObj.action = "ESD_SCE_0006.do";
		formObj.submit() ;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
       		if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.cntr_no) && ComIsEmpty(formObj.bkg_cre_dt1) && ComIsEmpty(formObj.bkg_cre_dt2) && ComIsEmpty(formObj.so_no) && ComIsEmpty(formObj.cop_no) && ComIsEmpty(formObj.ref_no)){
       			
	        }else{
	        	formObj.page_no.value = "1";
				formObj.f_cmd.value = SEARCHLIST;
				formObj.target = "_self" ;
				sheetObj.DoSearch4Post("ESD_SCE_0001GS.do", SceFrmQryString(formObj));
         	}

			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel(-1, false, false, true);
			break;
		case IBSAVE:

			if( sheetObj.CheckedRows("chk") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			} else {
				if( confirm("Are you sure you want to proceed?") ) {
					formObj.f_cmd.value = MODIFY;
					//shonBlur='javascript:this.value=this.value.toUpperCase();'0eetObj.DoSave("ESD_SCE_0002GS.do", SceFrmQryString(formObj), "chk", false, true);
					sheetObj.DoSave("ESD_SCE_0001GS.do", SceFrmQryString(formObj), "chk", false, true);
					afterStatusChange(sheetObj, '');
				}
			}
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj) {

	//var totalCnt = parseInt(sheetObj.CellValue(3, "totcnt"),10);
	var totalCnt = sheetObj.RowCount;
    var formObj = document.form;	
	var pageNo = formObj.page_no.value;
	var pageRows = formObj.pagerows.value;
	var startRow = (pageNo-1) * pageRows+2;
	if(sheetObj.TotalRows > 0){
		//sheetObj.TotalRows = totalCnt;
		for(var i=startRow; i<totalCnt+2; i++){
	
			if(sheetObj.CellValue(i, "cop_sts_cd") == 'F' || sheetObj.CellValue(i, "cop_sts_cd") == 'T'){
				sheetObj.CellEditable(i, "cop_sub_sts_cd") = true;				
			}else{
				sheetObj.CellEditable(i, "cop_sub_sts_cd") = false;			
			}
		}		
	}
	
}

function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow) {
	var formObj = document.form ;
	formObj.page_no.value = PageNo;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch4Post("ESD_SCE_0001GS.do", selectVal, "cur_page=" + PageNo, true);
}

function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	var obj = eval('document.form.'+x1.substring(x1.indexOf('btns_')+5));
	obj.value = rowArray;
	if(obj.name == 'eq_no') {
		checkDigit(obj);
	}
}

/**
 * booking info 팝업 호출
 * @param sheetObj
 * @return
 */
function openESD_SCE_0915(sheetObj){
	var row = sheetObj.SelectRow  ;
	var bkgNo      = sheetObj.CellValue(row, "r_bkg_no") ;
	//var bkgNoSplit = sheetObj.CellValue(row, "r_bkg_no_split") ;
	var copno = sheetObj.CellValue(row, "r_cop_no") ;

	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='bkg_no'       value='" + bkgNo + "'>" ;
	//newForm += "  <input type='hidden' name='bkg_no_split' value='" + bkgNoSplit + "'>" ;
	newForm += "  <input type='hidden' name='cop_no' value='" + copno + "'>" ;
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0915'>" ;	
	newForm += "</form>"

	document.all.new_form.innerHTML = newForm ;

	var formObj = document.form1 ;
	var paramUrl = "pgmNo=ESD_SCE_0915&cop_no="+copno+"&bkg_no="+bkgNo;
//	var newWin  = window.open("","bkg_info_win", "width=810,height=415," + getCenterXY(810, 425));
	var newWin = window.showModalDialog("ESD_SCE_0915.do?"+paramUrl, "bkg_info_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:415px");
//	formObj.action = "ESD_SCE_0915.do" ;
//	formObj.target = "bkg_info_win" ;
//	formObj.submit() ;
}
/**
 * master change  팝업 호출
 * @return
 */
function openESD_SCE_0118(){

	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0118'>" ;	
	newForm += "</form>"
	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1 ;
	var paramUrl = "pgmNo=ESD_SCE_0118";
    var newWin = window.showModalDialog("ESD_SCE_0118.do?"+paramUrl, "Master", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1300px;dialogHeight:680px");
//	var newWin  = window.open("","Master", "width=1300,height=680," + getCenterXY(1300, 680));
//	formObj.action = "ESD_SCE_0118.do" ;
//	formObj.target = "Master" ;
//	formObj.submit() ;	
}
/**
 * cop change 팝업 호출
 * @param formObj
 * @return
 */
function openESD_SCE_0053(formObj, bkg_no, cop_sts_cd){
	var cop_no = formObj.cop_no.value ;
	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cop_no'       value='" + cop_no + "'>" ;	
	newForm += "  <input type='hidden' name='bkg_no'       value='" + bkg_no + "'>" ;
	newForm += "  <input type='hidden' name='cop_sts_cd'       value='" + cop_sts_cd + "'>" ;	
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0053'>" ;	
	newForm += "</form>"
	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1 ;
	var paramUrl = "pgmNo=ESD_SCE_0053&cop_no="+formObj.cop_no.value+"&bkg_no="+formObj.bkg_no.value+"&cop_sts_cd="+formObj.cop_sts_cd.value;
    var newWin = window.showModalDialog("ESD_SCE_0053.do?"+paramUrl, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:195px");
//	var newWin  = window.open("","cop_change", "width=400,height=195," + getCenterXY(400, 195));
//	formObj.action = "ESD_SCE_0053.do" ;
//	formObj.target = "cop_change" ;
//	formObj.submit() ;	
}

/**
 * cop history 팝업 호출
 * @param formObj
 * @return
 */
function openESD_SCE_0071(formObj){
	var cop_no = formObj.cop_no.value ;
	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cop_no'       value='" + cop_no + "'>" ;	
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0071'>" ;	
	newForm += "</form>"
	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1 ;
	var paramUrl = "pgmNo=ESD_SCE_0071&cop_no="+cop_no;
    var newWin = window.showModalDialog("ESD_SCE_0071.do?"+paramUrl, "cop_history", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:600px");
//	var newWin  = window.open("","cop_history", "resizable,width=800,height=600," + getCenterXY(800, 600));
//	formObj.action = "ESD_SCE_0071.do" ;
//	formObj.target = "cop_history" ;
//	formObj.submit() ;	
}
function openTest(){

	var cntr_no = "TRLU8979119" ;//TRLU8979119
	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cntr_no'       value='" + cntr_no + "'>" ;
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0001'>" ;	
	newForm += "</form>"

	document.all.new_form.innerHTML = newForm ;

	var formObj = document.form1 ;
	var newWin  = window.open("","COPinquiry", "width=1000,height=580," + getCenterXY(1000, 580));
	formObj.action = "ESD_SCE_0001.do" ;
	formObj.target = "COPinquiry" ;
	formObj.submit() ;	
}
/**
 * Batch Update 창 오픈
 */
function openESD_SCE_0010(sheetObj) {
	var chkCnt = sheetObj.CheckedRows(0) ;

	if( chkCnt==0 ) {
		ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
		return false ;
	}

	var chkRows = sheetObj.FindCheckedRow(0) ;
	var arrChkRows = chkRows.split("|") ;
	var newForm = "" ;

	newForm += "<form name='form1' method='post'>" ;
	for(i=0 ; i<arrChkRows.length-1; i++) {
		if( sheetObj.CellValue(arrChkRows[i], "cop_sts_cd")!="T" && sheetObj.CellValue(arrChkRows[i],"cop_sts_cd")!="C" ) {
			ComShowMessage(ComGetMsg('SCE90011')) ;
			return false ;
		}
		newForm += "  <input type='hidden' name='cop_no'      value='" + sheetObj.CellValue(arrChkRows[i], "r_cop_no") + "'>" ;
		//newForm += "  <input type='hidden' name='cop_grp_seq' value='" + sheetObj.CellValue(arrChkRows[i], "cop_grp_seq") + "'>" ;
		newForm += "  <input type='hidden' name='cop_dtl_seq' value='" + sheetObj.CellValue(arrChkRows[i], "cop_dtl_seq") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[i], "r_bkg_no") + "'>" ;
		//newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[i], "bkg_no_split") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(arrChkRows[i], "r_cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='act_cd'      value='" + sheetObj.CellValue(arrChkRows[i], "act_cd") + "'>" ;
		newForm += "  <input type='hidden' name='act_nm'      value='" + sheetObj.CellValue(arrChkRows[i], "act_nm") + "'>" ;
		newForm += "  <input type='hidden' name='nod_cd'      value='" + sheetObj.CellValue(arrChkRows[i], "nod_cd") + "'>" ;
	}
	newForm += "</form>" ;
	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1 ;
	var newWin  = window.open("","cop_batch_update", "width=704,height=166," + getCenterXY(704, 166));
	formObj.action = "ESD_SCE_0010.do" ;
	formObj.target = "cop_batch_update" ;
	formObj.submit() ;
	newWin.focus() ;
}

function getCenterXY(w, h){
	var height = screen.availHeight ;
	var width = screen.availWidth ;
	var leftpos = width/2 - w/2;
	var toppos = height/2 - h/2;

	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;

	return "left=" + leftpos + ", top=" + toppos ;
}

/*
 * 선택한 Row중 Bkg_No가 중복 된 건이 있는지 체크
 */
function ibSheet_BKGCheck(sheetObj, sStatus) {
	if( sheetObj.CheckedRows("chk") < 1 ) {
		ComShowMessage("Please select at least one.");
		return false;
	}
	var fromRow = 0;
	var docPrvBkgno = "";
	var sRow = sheetObj.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");

//	for( var ir = 0; ir < arrRow.length-1; ir++ ) {
//		fromRow = arrRow[ir];
//		if( ir == 0 ) {
//			docPrvBkgno = doSepRemove(sheetObj.CellValue(fromRow, "r_bkg_no"));//+sheetObj.CellValue(fromRow, "r_bkg_no_split"), " ");
//		} else {
//			if( docPrvBkgno != doSepRemove(sheetObj.CellValue(fromRow, "r_bkg_no"))){//+sheetObj.CellValue(fromRow, "r_bkg_no_split"), " ") ) {
//				sheetObj.CellValue2(fromRow,"chk") = "0";
//				sheetObj.RowStatus(fromRow) = "R";
//			}
//		}
//	}
	return true;
}

function sheet1_OnChange(sheetObj,Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk" ) {
		if( Value == "1" ) {
			sheetObj.RowStatus(Row) = "U";
		} else {
			sheetObj.RowStatus(Row) = "R";
		}
	} else if( sheetObj.ColSaveName(Col) == "cop_sub_sts_cd" ) {
		if( sheetObj.CellValue(Row, "chk") == "1" ) {
			sheetObj.RowStatus(Row) = "U";
		} else {
			sheetObj.RowStatus(Row) = "R";
		}
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */

//function sheet1_OnSaveEnd(sheetObj, errMsg) {
function afterStatusChange(sheetObj, errMsg) {
		if( errMsg.length > 0 ) {
			ComShowMessage(errMsg);
		} else {
			var iCheckRow = sheetObj.FindCheckedRow("chk");
			var arrRow = iCheckRow.split("|");
			var fromRow = 0;
			for( var ir = 0; ir < arrRow.length-1; ir++ ) {
				fromRow = arrRow[ir];
				if( sheetObj.CellValue(fromRow, "cop_sub_sts_cd") == "Y" && sheetObj.CellValue(fromRow, "cop_sts_cd") == "F" ) {
					sheetObj.CellValue2(fromRow, "r_cop_sub_sts_cd") = "R";
				} else {
					sheetObj.CellValue2(fromRow, "r_cop_sub_sts_cd") = "";
				}
			}
		}
	}

function sheet1_OnAfterColumnMove(sheetObj, col, newPos){
	var newColName = sheetObj.ColSaveName(newPos) ;
	switch (newColName) {
		case "bkg_no":
			if (col > newPos) {
				newPos = newPos+1;
			}
			//sheetObj.MoveColumnPos("r_bkg_no_split", newPos, false);
		break;
		default:
			break;
	}
}

/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){
	var result = true ;

	// 검색 조건 입력 여부
	if( !isInputField(formObj) ) {
		result = false ;
	} else if( !ComIsEmpty(formObj.bkg_no) && ! ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No
		result = false ;
	//} else if( !ComIsEmpty(formObj.bkg_no_split) && !ComChkObjValid(formObj.bkg_no_split, 2, "BKG No Split") ) { // BKG NO Split
		//result = false ;
	} else if( !ComIsEmpty(formObj.bl_no) && !ComChkObjValid(formObj.bl_no, 12, "BL No") ) { // BL No
		result = false ;
	} else if( !ComIsEmpty(formObj.cntr_no) && !ComChkObjValid(formObj.cntr_no, 11, "Container No") ) { // Container No
		result = false ;
	} else if( !ComIsEmpty(formObj.cntr_no) && ComChkObjValid(formObj.cntr_no, 11, "Container No") ) { // Container No

	    if( ComIsEmpty(formObj.bkg_cre_dt1) && ComIsEmpty(formObj.bkg_cre_dt2) ){
		    	
	        var now=new Date(); //새로운 date객체 생성해서 now에 할당
	        var year=now.getYear(); //년도는 현재의 년도를 지정
            var month=now.getMonth() + 1; //달은 현재의 달을 지정하되 달은 0부터 시작하므로 1을 더해줌
	        //var day=now.getDay(); //요일을 구해서 day에 지정
	        var date=now.getDate(); //일을 구해서 date에 지정
            //var firstDate = new Date(year, month-1, 1); //해당 년 월의 첫날을 구함
            var fm_year = now.getYear()-2;
            var fm_date=now.getDate()+1; //일을 구해서 day에 지정
	        var fm_mon=month;
	        var to_last_date = new Date(year, month, 0).getDate();  //현재 달의 마지막 날 구함
	        //alert("현재 달의 마지막 날:"+to_last_date);
	        if (to_last_date==date){
              fm_date = new Date(fm_year, month+1, 1).getDate();    //from에서 첫 날 구함
              fm_mon=now.getMonth() + 1;
	        }

	        var fm_mon = fm_mon<10?"0"+fm_mon:fm_mon;
	        var to_mon = month<10?"0"+month:month;
	        var fm_edate = fm_date<10?"0"+fm_date:fm_date;
	        var to_edate = date<10?"0"+date:date;


			formObj.bkg_cre_dt1.value = fm_year+"-"+fm_mon+"-"+fm_edate;
			formObj.bkg_cre_dt2.value = year+"-"+to_mon+"-"+to_edate;
            //alert(dateCalcurationNew(formObj.bkg_cre_dt1.value , formObj.bkg_cre_dt2.value));
			//ComShowMessage(fm_year+"-"+fm_mon+"-"+fm_edate+"##"+year+"-"+month+"-"+to_edate);
			//result = false ;
			
	    } else if( ComIsEmpty(formObj.bkg_cre_dt1) ){
	        ComShowMessage(ComGetMsg('SCE90014','BKG Date'));
			formObj.bkg_cre_dt1.focus();
			result = false ;
	    } else if( ComIsEmpty(formObj.bkg_cre_dt2) ){
	        ComShowMessage(ComGetMsg('SCE90014','BKG Date'));
			formObj.bkg_cre_dt2.focus();
			result = false ;
	    } else if( !ComIsDate(formObj.bkg_cre_dt1) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
			formObj.bkg_cre_dt1.focus();
			result = false ;
		} else if( !ComIsDate(formObj.bkg_cre_dt2) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
			formObj.bkg_cre_dt2.focus();
			result = false ;
		} else if ( dateCalcurationNew(formObj.bkg_cre_dt1.value , formObj.bkg_cre_dt2.value) > 1095) {
			ComShowMessage("Possible inquiry peroid is limited to 3 Years.");
			formObj.bkg_cre_dt1.focus();
			result = false ;
		}
	} else if( !ComIsEmpty(formObj.cop_no) && !ComChkObjValid(formObj.cop_no, 14, "COP No") ) { // Cop No
		if(formObj.cop_no.value.length > 14){
			formObj.cop_no.value = formObj.cop_no.value.substr(0,14);
		}
		result = false ;
	} else if ( dateCalcurationNew(formObj.bkg_cre_dt1.value , formObj.bkg_cre_dt2.value) > 1095) {
			ComShowMessage("Possible inquiry peroid is limited to 3 Years.");
			formObj.bkg_cre_dt1.focus();
			result = false ;
	} else if( result && (ComIsEmpty(formObj.cntr_no) || !ComChkObjValid(formObj.cntr_no, 11, "Container No")) && !ComIsEmpty(formObj.bkg_cre_dt1) && !ComIsEmpty(formObj.bkg_cre_dt2) ) { // Container No
	  if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.cntr_no) && ComIsEmpty(formObj.cop_no) && ComIsEmpty(formObj.so_no) && ComIsEmpty(formObj.ref_no)){
			ComShowMessage("Container No. is mandatory item.");
			formObj.cntr_no.focus();
			result = false ;
	  }

	}
	return result ;
}

function dateCalcurationNew(objFrom, objTo) {
	var lvfrmDate = doSepRemove(doSepRemove(objFrom, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(objTo, " "), "-");
	var lvFrom = lvfrmDate.substring(4, 6)+"-"+lvfrmDate.substring(6)+"-"+lvfrmDate.substring(0, 4);
	var lvTo = lvtoDate.substring(4, 6)+"-"+lvtoDate.substring(6)+"-"+lvtoDate.substring(0, 4);

	var fromDay = new Date(lvFrom);
	var toDay = new Date(lvTo);
	var objFT = (toDay.getTime()-fromDay.getTime()) / (24*60*60*1000);
	return objFT;
}

function onEnterKey(textname) {

	if (event.keyCode == 13) {
//	    alert("onEnterKey");
      	var sheetObj = sheetObjects[0];
	    var formObj = document.form;
	    textname.value = textname.value.toUpperCase();
		if(validateForm(formObj)){
//		    alert("validateForm");
		    doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}


}

function chkBKGDates(formObj, isEmptyBKGDates) {
    //alert(isEmptyBKGDates);
	var result        = true ;
	var emptyBKGDates = isEmptyBKGDates!=null ? isEmptyBKGDates : ComIsEmpty(formObj.bkg_cre_dt1)&&ComIsEmpty(formObj.bkg_cre_dt2);
    //alert(emptyBKGDates);
	if( !emptyBKGDates ) {
		if( !ComIsDate(formObj.bkg_cre_dt1) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
			formObj.bkg_cre_dt1.focus();
			result = false ;
		} else if( !ComIsDate(formObj.bkg_cre_dt2) ) {
			ComShowMessage(ComGetMsg('SCE90003','BKG Date'));
			formObj.bkg_cre_dt2.focus();
			result = false ;
		}
	}
	return result ;
}

function isInputField(formObj) {
	var result    = false ;
	var fieldType = null ;
	for(i=0; i<formObj.length; i++) {
		fieldType = formObj[i].type;
		if( fieldType!="hidden" && !formObj[i].readOnly ) {
		    //alert("formObj[i]:"+formObj[i].name);
			if( !ComIsEmpty(formObj[i]) ) {
				result = true;
				//alert("!ComIsEmpty(formObj[i])");
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
			result = false;
		}
	}

	return result;
}

function ComChkObjValid(obj, len, msg) {
	var result = true ;
	if( getLenByByte(obj.value)!==len ) {
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
		obj.focus();
		result = false;
	}
	return result ;
}

function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}

// Container No. 의 CheckDigit 을 설정.
function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo = obj.value;

	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = cntrNo;
		return;
	}
	ComChkObjValid(obj, 'eng_num', true, 10);
	var sum = 0;
 	cntrNo = cntrNo.toUpperCase();

	//for(var i=0;i<10;i++){
	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
	//}
	sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
//alert("  "+	cntrNo.substr(0,10));
//alert('sum:'+sum);		
	var mod = sum % 11;

	if (mod == 10) mod =0;

	if( isNaN(mod)){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = obj.value;
	}else{
		obj.value = 	cntrNo.substr(0,10);
		document.getElementById(bitTarget).value = mod;
		document.getElementById(valueTarget).value = obj.value + mod;
	}

}


function researchScreen(){
	//로직이 없는 function 생성
	//cop manual replan 후 화면 refresh시 cop inquiry 는 refresh 필요 없음.
}