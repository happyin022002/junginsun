/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BSA_0021.js
*@FileTitle : BSA Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.07
*@LastModifier : 이행지
*@LastVersion : 1.0
=========================================================
* History
* 2010.10.05 이행지 [CHM-201005758-01] BSA Architecture 위배사항 수정
* 2011.01.18 이행지 [CHM-201108496-01] BSA CREATION / UPDATE 화면 - 신규 VVD LOADABLE CAPACITY 입력 불가하도록 조치
* 2011.05.23 최윤성 [CHM-201110969-01] BSA Creation 화면 기능 보완 - Save Validation 추가
* 2011.08.19 최성민 [CHM-201112943-01] Add Carrier Time-Out 에러 수정
* 2014.05.14 신자영 [CHM-201429943] BSA System 기능 개선 관련 - BSA Creation VVD Inquiry popup 개발
* 2015.01.23 김용습 [CHM-201533808] 기간이 중복된 계약들의 From, To 셀의 배경색을 빨간색으로 변경해주는 로직 추가
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends 
	 * @class ESM_BSA_0021 : ESM_BSA_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BSA_0021() {
	    this.processButtonClick		= processButtonClick;
	    this.loadPage 				= loadPage;
	    this.initSheet 				= initSheet;
	    this.setSheetObject 		= setSheetObject;
	    this.sheet1_OnChange 		= sheet1_OnChange;
	    this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
	    this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
	    this.doActionIBSheet 		= doActionIBSheet;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var sheet_selno = ""; //현재선택된 SHEET
	
	var JOINT_OPERATING  = "";
	var SPACE_CHARTERING = "";
	
	var splitPos1 = new Array(0, 3, 6, 9, 12, 15);
	var splitPos2 = new Array(0, 3, 6, 9, 12, 15);
	
	var fixCnt1 = 20; //Sheet1 고정길이  (※주의: ESM_BSA_021GS.jsp에서도 수정할 것)
	var fixCnt2 = 17; //Sheet2 고정길이  (※주의: ESM_BSA_021GS2.jsp에서도 수정할 것)
	
	var LOGIC_fnl_capa = "";
	var LOGIC_sub_capa  = "";
	
	var selRow = 0;
	var selValue = "";
	
	var sheet_height1 = 20; // sheet1의 height
	var sheet_height2 = 20; // sheet2의 height
	var zoomFlag1 = "close"; // Zoom Flag #1
	var zoomFlag2 = "close"; // Zoom Flag #2
	
	var first_load1 = true;  //최초 Load시만 sheet1 height 조정
	var first_load2 = true;  //최초 Load시만 sheet2 height 조정
	
	
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage(headText1,headText2,headText3,headText4) {
		var head1 = "";
		var head2 = "";
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			if (i==0) {
				head1 = headText1;
				head2 = headText2;
			} else {
				head1 = headText3;
				head2 = headText4;
			}
			initSheet(sheetObjects[i],i+1,head1,head2);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		JOINT_OPERATING  = document.form.rdoOp_cd[0].value;
		SPACE_CHARTERING = document.form.rdoOp_cd[1].value;
		document.getElementById("tabLayer2").style.display = "none";
		//tabLayer2.style.display = "none";
		sheet_selno = JOINT_OPERATING; //현재선택된 SHEET (첫번째 쉬트)
		set_Zoom();
		
		// 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
	}
	
	function loadCombo() {
    	var formObj = document.form;
 		var sXml = formObj.sXml.value;

 		var arrXml = sXml.split("|$$|");
 		
 		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
 		document.form.sXml.value="";
     }
	
	/**
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	* IBCombo Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	
	/**
	* IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
	*/
	function setIBMultiCombo(sheetObj, sXml ,objName){
		if (sXml == undefined || sXml == ""){
			return;
		}
		var arrData = ComCoaXml2SheetMultiComboString(sXml, "code", "code");
		sheetObj.InitDataCombo(0,objName, arrData[1], arrData[0],"","");		
	}
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
			switch(srcName) {
				case "btn_retrieve":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
					}
					break;
		
				case "btn_save":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						checkDate(sheetObject1);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBSAVE);
						checkDate(sheetObject2);
					}
					break;
		
				case "btn_downexcel":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
					}
					break;
		
				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.select(formObject.txtSDate, 'yyyy-MM-dd');
					break;
		
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.txtEDate, 'yyyy-MM-dd');
					break;
		
				case "rdoOp_cd":
					if (formObject.rdoOp_cd[0].checked) { //JO 선택시
						document.getElementById("tabLayer1").style.display= "inline";
					document.getElementById("tabLayer2").style.display= "none";
					formObject.excludVslCapa.disabled = false;
					sheet_selno = formObject.rdoOp_cd[0].value; //'J'
					//doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else if (formObject.rdoOp_cd[1].checked) { //SC 선택시
						document.getElementById("tabLayer1").style.display= "none";
					document.getElementById("tabLayer2").style.display= "inline";
					formObject.excludVslCapa.disabled = true;
					sheet_selno = formObject.rdoOp_cd[1].value; //'S'
					//doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
					}
					set_Zoom();
					break;
		
				case "rdoType":
					var checkedIdx = -1;
					var obj = formObject.rdoType;
					for(var i=0; i<obj.length; i++) {
						if (obj[i].checked) {
							checkedIdx = i;
							break;
						}
					}
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						sheetObject1.LeftCol = (fixCnt1-1) + splitPos1[checkedIdx];
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						sheetObject2.LeftCol = (fixCnt2-1) + splitPos2[checkedIdx];
					}
					break;
		
				case "bu_zoom_in1": //next
				case "bu_zoom_in2":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",1);
					sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
					zoomFlag1 = "open";
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						sheet_height2 = ComGetSheetViewRows(sheetObject2,"MAX",1);
					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
					zoomFlag2 = "open";
					}
					set_Zoom();
					parent.syncHeight();
					break;
		
				case "bu_zoom_out1": //next
				case "bu_zoom_out2":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						sheet_height1 = getSheetHeightCnt(sheetObject1,"MIN",0);
					sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
					zoomFlag1 = "close";
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						sheet_height2 = ComGetSheetViewRows(sheetObject2,"MIN",0);
					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
					zoomFlag2 = "close";
					}
					set_Zoom();
					parent.syncHeight();
					break;
					
				case "btng_rowadd": 	
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBINSERT);
					}
					break;
		
				case "btng_rowdel":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBDELETE);
					}
					break;
		
				case "btng_creation":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBCREATE);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBCREATE);
					}
					break;
		
				case "btng_crrinfo":
					window.showModalDialog("ESM_BSA_0120.do", "Carrier's Register", "dialogWidth:406px;dialogHeight:425px");
					//ComOpenWindow("ESM_BSA_0120.do", "Carrier's Register", "width=426,height=375",true);
					break;
		
				case "btng_addcrrrgst":
					var param = "?bsa_op_cd=" + sheet_selno;
					var option	= "dialogWidth:600px;"
								+ "dialogHeight:380px;"
								+ "status:no;"
								+ "help:no;"
								+ "resizable:no;"
								+ "scroll:no;";
					ComOpenWindow("ESM_BSA_0023.do"+ param, "Add Carrier", "width=600,height=360",false);
					//window.showModalDialog("ESM_BSA_0023.do" + param, "win_addcrrrgst", option);
					break;
		
				case "btng_stepupdownbyport":
					formObject.f_cmd.value = "";
					formObject.method = "POST";
					formObject.action = "/hanjin/ESM_BSA_0026.do?flag=Y&pgmNo=ESM_BSA_0026";
					formObject.submit();
					break;
		
				case "btng_skdinquiry":
					var classId = "COM_ENS_0B1";
					var vvd_cd = "";  //sheet의 선택된 값 ex)HABK0418E
		
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						if (sheetObject1.SelectRow > 0 && sheetObject1.RowCount > 0) {
							var vvd_cd = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_vvd_cd');
						}
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						if (sheetObject2.SelectRow > 0 && sheetObject2.RowCount > 0) {
							var vvd_cd = sheetObject2.CellValue(sheetObject2.SelectRow, 'M_vvd_cd');
						}
					}
					//if (vvd_cd == "") { vvd_cd = "ABCD1234E"; }
					var param = "?vvd_cd=" + vvd_cd + "&classId=" + classId;
					ComOpenPopup("/hanjin/"+classId+".do"+param, 608, 470, "", "0,0,1,1,1,1,1,1,1,1", false);
		
					break;
					
				case "btng_vvdinquiry":
					
					var from_dt = "";
					var trd_cd = "";
					var rlane_cd = "";
					var dir_cd = "";
					var vsl_capa = "";
					
					var today = new	Date();
					var year  = today.getFullYear();
					var mon = (today.getMonth()+1).toString();
					mon = fillZero(mon, 2,'0','left');
					var day = (today.getDate()).toString();
					day = fillZero(day, 2,'0','left');
					var todaystr = year+mon+day;
					

					if (sheet_selno == "J") { //첫번째 SHEET 이면
						if (sheetObject1.SelectRow> 0 && sheetObject1.RowCount > 0) {
							var row = sheetObject1.SelectRow;
							var from_dt = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_bsa_fm_dt');
							var end_dt = getOffsetDate(todaystr, 92);
							from_dt = from_dt.substring(0,4)+"-"+from_dt.substring(4,6)+"-"+from_dt.substring(6,8);


							var trd_cd = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_trd_cd');
							var rlane_cd = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_rlane_cd');
							var dir_cd = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_dir_cd');
							var vsl_capa = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_vsl_capa');
							var opr = sheetObject1.CellValue(sheetObject1.SelectRow, 'M_vop_cd');
						}
					} else if (sheet_selno == "S") { //두번째 SHEET 이면
						if (sheetObject2.SelectRow > 0 && sheetObject2.RowCount > 0) {
							var row = sheetObject2.SelectRow;
							var from_dt = sheetObject2.CellValue(sheetObject2.SelectRow, 'M_bsa_fm_dt');
							var end_dt = getOffsetDate(todaystr, 92);
							from_dt = from_dt.substring(0,4)+"-"+from_dt.substring(4,6)+"-"+from_dt.substring(6,8);

						
							var trd_cd = sheetObject2.CellValue(sheetObject2.SelectRow, 'M_trd_cd');
							var rlane_cd = sheetObject2.CellValue(sheetObject2.SelectRow, 'M_rlane_cd');
							var dir_cd = sheetObject2.CellValue(sheetObject2.SelectRow, 'M_dir_cd');
							var vsl_capa = "" // Space charter 경우엔 capa 없음
							var opr = sheetObject2.CellValue(sheetObject2.SelectRow, 'M_vop_cd');
						}
					}
					
					var param = "?bsa_op_cd=" + sheet_selno +"&trd_cd=" + trd_cd + "&rlane_cd=" + rlane_cd+ "&from_dt=" + from_dt+ "&end_dt=" + end_dt+
								"&dir_cd=" + dir_cd + "&vsl_capa=" + vsl_capa + "&vop_cd=" + opr;

					var param = param + "&popup_row=" + row;
					var option	= "dialogWidth:900px;"
								+ "dialogHeight:620px;"
								+ "status:no;"
								+ "help:no;"
								+ "resizable:no;"
								+ "scroll:no;";	
					var retVal = ComOpenPopup('/hanjin/ESM_BSA_0123.do'+ param, 900, 350, 'BSA Creation VVD Inquiry', '0,1,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
					break;
					
				case "btng_checkdate":
					if (sheet_selno == JOINT_OPERATING) {  
						checkDate(sheetObject1);
					} else if (sheet_selno == SPACE_CHARTERING) {  
						checkDate(sheetObject2);
					}
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo,head1,head2) {
		var formObj = document.form;
		var head0    = "";
		var arrHead1 = "";
		var arrHead2 = "";
		var varCnt = 0;
		
		var cnt = 0;
		var HeadTitle0 = "";
		var HeadTitle1 = "";
		var HeadTitle2 = "";
		var n = 0;
		
		var bsaOpJbCd1 = formObj.bsa_op_jb_cd.value.replace(/(^\s*)/g, '').split("|");
		var bsaOpJbCd2 = formObj.bsa_op_jb_cd2.value.replace(/(^\s*)/g, '').split("|");
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				if (head1 == "" && head2 == "") {
					head1 = "|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA"
						+ "|Lease|Lease|Lease"
						+ "|Charter in|Charter in|Charter in"
						+ "|Additional Lease|Additional Lease|Additional Lease"
						+ "|Additional Chater in|Additional Chater in|Additional Chater in";
						head2 = "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3";
				}
		
				arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
				arrHead2 = head2.replace(/(^\s*)/g, '').split("|");
				
				varCnt = arrHead2.length - 1;
		
				with (sheetObj) {
					if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
					first_load1 = false;
		
					SheetWidth = mainTable1.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
		
					Editable = true;
					InitRowInfo(3, 1, 9, 100);
					InitColumnInfo(fixCnt1 + varCnt, 16, 0, true);
					InitHeadMode(true, true, false, true, false, false);
		
					for (j=1; j<=varCnt; j++) {
						if(bsaOpJbCd1[j]== "001"){
							head0 += "|Basic Slots";
							n++;
						}else{
							head0 += "|Chartered Slots";
						}
					}
		
					HeadTitle0 = "STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|SML\nFinal|SML\nInclude Sub|☆|ownr_vsl_wgt|★"
								+ head0 + "|DESC";
					HeadTitle1 = "STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|SML\nFinal|SML\nInclude Sub|☆|ownr_vsl_wgt|★"
								+ head1 + "|DESC";
					HeadTitle2 = "STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|SML\nFinal|SML\nInclude Sub|☆|ownr_vsl_wgt|★"
								+ head2 + "|DESC";
		
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, false);
					
					SetMergeCell(0, 19, 2, n); 
		
		
					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					cnt = 0;
					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
					
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_bsa_group",            false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "M_bsa_seq",              false, "", dfInteger, 0, false, true, 3);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "M_vvd_cd",               false, "", dfNone,    0, true,  true, 9);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "M_bsa_fm_dt",            false, "", dfDateYmd, 0, true,  true);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "M_bsa_to_dt",            false, "", dfDateYmd, 0, true,  true);
					
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_trd_cd",               false, "", dfNone,    0, false, false, 3);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_sub_trd_cd",           false, "", dfNone,    0, false, false, 2);
					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "M_rlane_cd",             false, "", dfNone,    0, false, false, 5);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_dir_cd",               false, "", dfNone,    0, false, false, 1);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_vop_cd",               false, "", dfNone,    0, false, false, 3);
					
					InitDataProperty(0, cnt++, dtHidden, 70, daRight,  true, "",                       false, "", dfInteger, 3, false, false);
					InitDataProperty(0, cnt++, dtHidden,  70, daRight,  true, "M_vsl_capa",             false, "", dfFloatOrg, 3, false, false);
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "M_bsa_capa",             false, "", dfInteger, 3, false,  false);
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "M_fnl_hjs_bsa_capa",     false, LOGIC_fnl_capa, dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "M_hjs_bsa_bfr_sub_capa", false, LOGIC_sub_capa, dfInteger, 0, false, false);
					
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_spc_otr_swap_flg",     false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_ownr_vsl_wgt",         false, "", dfInteger,   0, false, false);
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_upd_usr_id",           false, "", dfNone,    0, false, false);
		
					for (n=0; n<varCnt; n++) {
						InitDataProperty(0, cnt, dtAutoSum, 50, daRight, true, "D_crr_bsa_capa"+n, false, "", dfInteger, 0, true, true);
						if (arrHead1[n+1] == "Basic Leased" || arrHead1[n+1] == "Additional Leased") {
							CellBackColor(2, cnt) = RgbColor(196, 210, 255);
						} else {
							CellBackColor(2, cnt) =RgbColor(211, 219, 255);
						}
						cnt++;
					}
		
					InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "M_jo_desc", false, "", dfNone, 0, true, true, 1000);
					
					InitDataValid(0, "M_dir_cd",  1, "NEWS");       //vtCharOnly=1
					InitDataValid(0, "M_vvd_cd",  6, "1234567890"); //vtEngOther=6
					//InitDataValid(0, "M_jo_desc", 8, "&/<>");       //vtExceptChar=8
					
					HeadRowHeight = 10;
					CountPosition  = 0 ;
				}
				break;
		
			case 2:      //sheet2 init
				if (head1 == "" && head2 == "") {
					head1 = "|from which carrier|from which carrier|from which carrier"
						+ "|Sub Lease|Sub Lease|Sub Lease"
						+ "|Sub Chater in|Sub Chater in|Sub Chater in"
						+ "|Additional Lease|Additional Lease|Additional Lease"
						+ "|Additional Chater in|Additional Chater in|Additional Chater in";
					head2 = "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3"
						+ "|CRR1|CRR2|CRR3";
				}
		
				arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
				arrHead2 = head2.replace(/(^\s*)/g, '').split("|");
				
				varCnt = arrHead2.length - 1;
		
				with (sheetObj) {
					if (first_load2 == true) { style.height = GetSheetHeight(sheet_height2); }
					first_load2 = false;
		
					SheetWidth = mainTable2.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
					Editable = true;
					InitRowInfo(2, 1, 9, 100);
					InitColumnInfo(fixCnt2 + varCnt, 14, 0, true);
					InitHeadMode(true, true, false, true, false, false);
		
					HeadTitle0 = "STS|GRP|SEQ|VVD|From|To.|Trade|R.Lane|Dir.|VSL Chk|Seq|VSL\nCode|Final\nSML BSA|SML BSA\nBefore Sub|☆|★"
							+ head1 + "|DESC";
					HeadTitle1 = "STS|GRP|SEQ|VVD|From|To.|Trade|R.Lane|Dir.|VSL Chk|Seq|VSL\nCode|Final\nSML BSA|SML BSA\nBefore Sub|☆|★"
							+ head2 + "|DESC";
		
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, false);
		
					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					cnt = 0;
					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
		
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_bsa_group",            false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "M_bsa_seq",              false, "", dfInteger, 0, false, true, 3);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "M_vvd_cd",               false, "", dfNone,    0, true,  true, 11);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "M_bsa_fm_dt",            false, "", dfDateYmd, 0, true,  true);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "M_bsa_to_dt",            false, "", dfDateYmd, 0, true,  true);
					
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_trd_cd",               false, "", dfNone,    0, false, false, 3);
					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "M_rlane_cd",             false, "", dfNone,    0, false, false, 5);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_dir_cd",               false, "", dfNone,    0, false, false, 1);
					InitDataProperty(0, cnt++, dtCheckBox,55, daCenter, true, "M_vsl_bsa_chk_flg",      false, "", dfNone,    0, true,  true);
					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "M_vsl_seq",              false, "", dfInteger, 0, false, true, 3);
					
					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "M_vsl_cd",               false, "", dfNone,    0, false, false, 4);
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "M_hjs_fnl_bsa_capa",     false, LOGIC_fnl_capa, dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "M_hjs_bsa_bfr_sub_capa", false, LOGIC_sub_capa, dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_vsl_mlt_inp_flg",      false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "M_upd_usr_id",           false, "", dfNone,    0, false, false);
		
					for (n=0; n<varCnt; n++) {
						InitDataProperty(0, cnt, dtAutoSum, 50, daRight, true, "D_crr_bsa_capa"+n, false, "", dfInteger, 0, true, true);
						if (arrHead1[n+1] == "Sub Lease" || arrHead1[n+1] == "Additional Lease") {
							CellBackColor(1, cnt) = RgbColor(196, 210, 255);
						} else {
							CellBackColor(1, cnt) = RgbColor(211, 219, 255);
						}
						cnt++;
					}
		
					InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "M_scht_desc", false, "", dfNone, 0, true, true, 100);
					
					InitDataValid(0, "M_dir_cd",    1, "NEWS");       //vtCharOnly=1
					InitDataValid(0, "M_vvd_cd",    6, "1234567890"); //vtEngOther=6
					InitDataValid(0, "M_vsl_cd",    11, "1234567890");  //vtEngUpOther=11
					//InitDataValid(0, "M_scht_desc", 8, "&/<>");       //vtExceptChar=8
					
					
					HeadRowHeight = 10;
					CountPosition = 0;
				}
				break;
		}
	}
	
	
	
	/**
	* 콤보 항목을 설정한다. by.yjjeon
	*/
	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300;
			comboObj.InsertItem(0, 'All' ,''); 
			Index = 0;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {		
			case IBSEARCH:      //조회
				sheetObj.WaitImageVisible = true;
				
				if(formObj.excludVslCapa.checked) {
					formObj.excludVslCapa.value = "Y";
				} else {
					formObj.excludVslCapa.value = "N";
				}
				
				if (!validateCond(formObj, sAction)) {
					return false;
				}				
				
				formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObj.GetSearchXml("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo))+"&excludVslCapa=" + formObj.excludVslCapa.value);
				//var gXml = xml.split("|$$|");
				
				var head1 = GetEtcDataForExceptional(sXml, "head1");
				var head2 = GetEtcDataForExceptional(sXml, "head2");
				var head3 = GetEtcDataForExceptional(sXml, "head3");
				LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
				LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
				if (head1 != "" && head2 != "") {
					formObj.bsa_op_jb_nm1.value=head1;
					formObj.jHeader.value=head2;
					formObj.bsa_op_jb_cd.value=head3;
					sheetObj.Redraw = false;
					sheetObj.Visible = false;
					sheetObj.RemoveAll();
					sheetObj.Reset();
					ComConfigSheet(sheetObjects[0]);
					initSheet(sheetObj, 1, head1, head2);
					sheetObj.Visible = true;
					sheetObj.Redraw = true;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.RemoveEtcData(); // ETC 데이타 삭제
				}
				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
		
				setOffsetPos(head1);
				break;
		
			case IBSAVE:        //저장
				if (!validateForm(sheetObj)) {
					return false;
				}
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
				//sheetObj.EtcData("comment");
				break;
		
			case IBDOWNEXCEL:   //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
				case "AY":
				sheetObj.Down2Excel(0, false, false, true);
				break;
				case "DY":
				sheetObj.Down2Excel(-1, false, false, true);
				break;
				case "AN":
				sheetObj.SpeedDown2Excel(0, false, false);
				break;
				case "DN":
				sheetObj.SpeedDown2Excel(-1, false, false);
				break;
				}               
				break;
		
				//		case IBINSERT:      //행추가
				//			with(sheetObj) {
				//				if (RowCount > 0) {
				//					SelectRow = getMaxRow(sheetObj);
				//
				//					var Row = DataCopy(false); //행을 복사
				//					if (Row > HeaderRows) {
				//						InitHeadMode(false, true, false, true, false, false); //Sort불가능
				//
				//						//CellValue2(Row,"M_bsa_seq") = parseInt(CellValue(Row,"M_bsa_seq")) + 1;
				//                        //중요 Regacy 정보 채번 로직 변경.
				//                        //현재 화면에서 채번 하는 형식을 ALPS 변환 과정에서 BCImpl에서 변경하는 걸로 바꾸었음
				//                        // editedy by kim ki dae in 2009-09-28 
				//
				//						//이전Row가 있으면 이전Row의 bsa_to_dt를 수정 못하게 함
				//						var grpRow = getFindRow(sheetObj,Row,-1);
				//						if (grpRow != -1) {
				//							CellEditable(grpRow,"M_bsa_to_dt") = false;
				//						}
				//					}
				//				} //end of if
				//			}
				//			break;
			case IBINSERT:      //행추가
				with(sheetObj) {
					if (RowCount > 0) {
						SelectRow = getMaxRow(sheetObj);
					
						var Row = DataCopy(false); //행을 복사
						if (Row > HeaderRows) {
							InitHeadMode(false, true, false, true, false, false); //Sort불가능
							CellValue2(Row,"M_bsa_seq") = parseInt(CellValue(Row,"M_bsa_seq")) + 1;
					
							//이전Row가 있으면 이전Row의 bsa_to_dt를 수정 못하게 함
							var grpRow = getFindRow(sheetObj,Row,-1);
							if (grpRow != -1) {
								CellEditable(grpRow,"M_bsa_to_dt") = false;
							}
						}
					} //end of if
				}
				break;
			case IBDELETE:      //행삭제
				with(sheetObj) {
					if (SelectRow > 0 && RowCount > 0) {
						var currRow = SelectRow;
						var stat = RowStatus(currRow);
						
						if (getMaxRow(sheetObj) != currRow) { //지우려는 대상Row가 최대값인 경우에만 삭제가 가능
							ComShowMessage(ComGetMsg('BSA10029')); //같은 그룹내의 최대값만 삭제할 수 있습니다.
						} else {
							var grpRow = getFindRow(sheetObj,currRow,-1);
							RowStatus(currRow) = "D";
							if (stat != "I") { //추가 중인 ROW가 아닌 경우
								if (ComShowConfirm(ComGetMsg('BSA10028')) == true) { //정보를 삭제 하시겠습니까?
									if (grpRow != -1) {
										//이전Row의 bsa_to_dt를 수정가능하게 함
										CellEditable(grpRow,"M_bsa_to_dt") = true;
										//현Row의 bsa_to_dt를 이전Row의 bsa_to_dt로 복사함
										CellValue2(grpRow,"M_bsa_to_dt") = CellValue(currRow,"M_bsa_to_dt");
									} 
									formObj.f_cmd.value = REMOVE01;
									DoSave("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
									//RowDelete(currRow,false);
								} else {
									RowStatus(currRow) = stat; //원래값으로 복구
								}
							} else { //추가 중인 경우
								if (grpRow != -1) {
									//이전Row의 bsa_to_dt를 수정가능하게 함
									CellEditable(grpRow,"M_bsa_to_dt") = true;
								}
							}
						}
					}
				}
				break;
		
			case IBCREATE:      //생성
				if (!validateCond(formObj, sAction)) {
					return false;
				}
	
				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { //정보를 생성 하시겠습니까?
					formObj.f_cmd.value = MULTI03;
					sheetObj.DoSearch4Post("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo)));
					var err_cd = sheetObj.EtcData("err_cd");
					var err_msg = sheetObj.EtcData("err_msg");
				
					//재조회 ------------------------------------------------------- START
					formObj.f_cmd.value = SEARCHLIST01;
					var sXml = sheetObj.GetSearchXml("ESM_BSA_0021GS.do", bsaFormString(formObj,getParam(curPgmNo)));
					var head1 = GetEtcDataForExceptional(sXml, "head1");
					var head2 = GetEtcDataForExceptional(sXml, "head2");
					var head3 = GetEtcDataForExceptional(sXml, "head3");
					LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
					LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
					if (head1 != "" && head2 != "") {
						formObj.bsa_op_jb_nm1.value=head1;
						formObj.jHeader.value=head2;
						formObj.bsa_op_jb_cd.value=head3;
						sheetObj.Redraw = false;
						sheetObj.Visible = false;
						sheetObj.RemoveAll();
						sheetObj.Reset();
						ComConfigSheet(sheetObjects[0]);
						initSheet(sheetObj, 1, head1, head2);
						sheetObj.Visible = true;
						sheetObj.Redraw = true;
						sheetObj.LoadSearchXml(sXml);
						sheetObj.RemoveEtcData(); // ETC 데이타 삭제
					}
					sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
				
					setOffsetPos(head1);
					//재조회 ------------------------------------------------------- END
				
					if (err_cd == "00000") {
						ComShowMessage(ComGetMsg('BSA10018','CREATION')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
					}
				}
				break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var grpRow = 0;
	
		switch(sAction) {
			case IBSEARCH:      //조회
				if (!validateCond(formObj, sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCHLIST02;
				var sXml = sheetObj.GetSearchXml("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
				var head1 = GetEtcDataForExceptional(sXml, "head1");
				var head2 = GetEtcDataForExceptional(sXml, "head2");
				var head3 = GetEtcDataForExceptional(sXml, "head3");
				LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
				LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
				if (head1 != "" && head2 != "") {
					formObj.bsa_op_jb_nm2.value=head1;
					formObj.sHeader.value=head2;
					formObj.bsa_op_jb_cd2.value=head3;
					sheetObj.Redraw = false;
					sheetObj.Visible = false;
					sheetObj.RemoveAll();
					sheetObj.Reset();
					ComConfigSheet(sheetObjects[1]);
					initSheet(sheetObj, 2, head1, head2);
					sheetObj.Visible = true;
					sheetObj.Redraw = true;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.RemoveEtcData(); // ETC 데이타 삭제
				}
				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
				
				setOffsetPos(head1);
				
				// 2012.03.05 SHKIM 조회 후 바로 chk이면 true
				for(var i=2 ; i< (sheetObj.TotalRows+2) ; i++){
					if(sheetObj.CellValue(i,9) == 1){	sheetObj.CellEditable(i,11) = true;	}
				}
				break;
	
			case IBSAVE:        //저장
				if (!validateForm(sheetObj)) {
					return false;
				}
			
				formObj.f_cmd.value = MULTI02;        
				sheetObj.DoSave("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
				break;
	
			case IBDOWNEXCEL:   //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
						sheetObj.Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObj.Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObj.SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObj.SpeedDown2Excel(-1, false, false);
						break;
				}               
				break;
	
			case IBINSERT:      // 행추가
				with(sheetObj) {
					if (RowCount > 0) {
						SelectRow = getMaxRow(sheetObj);
						var Row = DataCopy(false); //행을 복사
						if (Row > HeaderRows) {
							InitHeadMode(false, true, false, true, false, false); //Sort불가능
							CellValue2(Row,"M_bsa_seq") = parseInt(CellValue(Row,"M_bsa_seq")) + 1;
							CellValue2(Row,"M_vsl_seq") = 1; //최초 시작이므로 항상 '1'로 샛팅
							//이전Row가 있으면 이전Row의 bsa_to_dt를 수정 못하게 함
							var grpRow = getFindRow(sheetObj,Row,-1);
							if (grpRow != -1) {
								CellEditable(grpRow,"M_bsa_to_dt") = CellValue(grpRow, "M_vsl_bsa_chk_flg") == "1"?true:false; // SHKIM 12.03.02 수정가능으로 변경(2) . CellEditable(grpRow,"M_bsa_to_dt") = false;
							}
							//체크박스별 vsl_cd의 CellEditable 셋팅
							if (CellValue(Row,"M_vsl_bsa_chk_flg") == "1") {
								CellEditable(Row,"M_vsl_cd") = true;
							} else if (CellValue(Row,"M_vsl_bsa_chk_flg") == "0") {
								CellEditable(Row,"M_vsl_cd") = false;
							}
						}
					} //end of if
				}
				break;
	
			case IBDELETE:      //행삭제
				with(sheetObj) {
					if (SelectRow > 0 && RowCount > 0) {
						var currRow = SelectRow;
						var stat = RowStatus(SelectRow);
						
						if (getMaxRow(sheetObj) != currRow) { //지우려는 대상Row가 최대값인 경우에만 삭제가 가능
							ComShowMessage(ComGetMsg('BSA10029')); //같은 그룹내의 최대값만 삭제할 수 있습니다.
						} else {
							var grpRow = getFindRow(sheetObj,currRow,-1);
							RowStatus(currRow) = "D";
							if (stat != "I") { //추가 중인 ROW가 아닌 경우
								if (ComShowConfirm(ComGetMsg('BSA10028')) == true) { //정보를 삭제 하시겠습니까?
									if (grpRow != -1) {
										//이전Row의 bsa_to_dt를 수정가능하게 함
										CellEditable(grpRow,"M_bsa_to_dt") = true;
										//현Row의 bsa_to_dt를 이전Row의 bsa_to_dt로 복사함
										CellValue2(grpRow,"M_bsa_to_dt") = CellValue(currRow,"M_bsa_to_dt");
									}
									
									formObj.f_cmd.value = REMOVE02;
									DoSave("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
									
									//RowDelete(currRow,false);
								} else {
									RowStatus(currRow) = stat; //원래값으로 복구
								}
							} else { //추가 중인 경우
								if (grpRow != -1) {
									//이전Row의 bsa_to_dt를 수정가능하게 함
									CellEditable(grpRow,"M_bsa_to_dt") = true;
								}
							}
						}
					}
				}
				break;
	
			case IBCREATE:      //생성
				if (!validateCond(formObj, sAction)) {
					return false;
				}
			
				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { //정보를 생성 하시겠습니까?
					formObj.f_cmd.value = MULTI04;
					sheetObj.DoSearch4Post("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
					var err_cd = sheetObj.EtcData("err_cd");
					var err_msg = sheetObj.EtcData("err_msg");
					
					//재조회 ------------------------------------------------------- START
					formObj.f_cmd.value = SEARCHLIST02;
					var sXml = sheetObj.GetSearchXml("ESM_BSA_0021GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
					var head1 = GetEtcDataForExceptional(sXml, "head1");
					var head2 = GetEtcDataForExceptional(sXml, "head2");
					var head3 = GetEtcDataForExceptional(sXml, "head3");
					LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
					LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
					if (head1 != "" && head2 != "") {
						formObj.bsa_op_jb_nm2.value=head1;
						formObj.sHeader.value=head2;
						formObj.bsa_op_jb_cd2.value=head3;
						sheetObj.Redraw = false;
						sheetObj.Visible = false;
						sheetObj.RemoveAll();
						sheetObj.Reset();
						ComConfigSheet(sheetObjects[1]);
						initSheet(sheetObj, 2, head1, head2);
						sheetObj.Visible = true;
						sheetObj.Redraw = true;
						sheetObj.LoadSearchXml(sXml);
						sheetObj.RemoveEtcData(); // ETC 데이타 삭제
					}
					sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
					
					setOffsetPos(head1);
					//재조회 ------------------------------------------------------- END
					
					if (err_cd == "00000") {
					ComShowMessage(ComGetMsg('BSA10018','CREATION')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
					}
				}
				break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			SumText(0,0) = "" ;
			SumText(0,"M_vvd_cd") = "TOTAL" ;
		}
			
		//isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
		if(document.form.isExcludZero.checked) {
			for(var k=0; k<=sheetObj.LastCol; k++) {
				if(sheetObj.CellBackColor(1, k) != sheetObj.CellBackColor(2, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
				sheetObj.ColHidden(k) = true;	 
			}
		} else {
			for(var k=0; k<=sheetObj.LastCol; k++){
				if(sheetObj.CellBackColor(1, k) != sheetObj.CellBackColor(2, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
				sheetObj.ColHidden(k) = false;
			}
		}		
		
		overlappedDateCheckForJointOperating(sheetObj);				
	}
	
	function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			SumText(0,0) = "" ;
			SumText(0,"M_vvd_cd") = "TOTAL" ;
		}
		
		//isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
		if(document.form.isExcludZero.checked) {
			for(var k=0; k<=sheetObj.LastCol; k++) {
				if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
				sheetObj.ColHidden(k) = true;	 
			}
		} else {
			for(var k=0; k<=sheetObj.LastCol; k++){
				if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
					sheetObj.ColHidden(k) = false;	            
				}	      
		}		
		
		overlappedDateCheckForSpaceChartering(sheetObj);
	}
	
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		var grpRow = -1;
		var param="";
		
		var current_row = Row;
		
		with(sheetObj) {
		
			if (ColSaveName(Col) == "M_bsa_fm_dt") {
				grpRow = getFindRow(sheetObj,Row,-1);
				if (grpRow != -1) {
					//Day-1 추출 로직 적용
					CellValue2(grpRow,"M_bsa_to_dt") = getOffsetDate(Value,-1);
				}
			}
			if (ColSaveName(Col) == "M_vvd_cd") {
				selRow = Row;
				selValue = Value;
				
				param = param+"f_cmd="+SEARCHLIST02;
				param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
				param = param+"&code=etdDt";
				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
				var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
				getEdtDate(etdDt);
			}
		}
	}
	
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		var grpRow = -1;
		var param="";
		
		with(sheetObj){
			if (ColSaveName(Col) == "M_bsa_fm_dt") {
				grpRow = getFindRow(sheetObj,Row,-1);
				if (grpRow != -1) {
				//Day-1 추출 로직 적용
				CellValue2(grpRow,"M_bsa_to_dt") = getOffsetDate(Value,-1);
				}
			}
			if (ColSaveName(Col) == "M_vsl_bsa_chk_flg") {
				if (CellValue(Row,"M_vsl_bsa_chk_flg") == "1") {
					CellEditable(Row,"M_vsl_cd") = true;
				} else if (CellValue(Row,"M_vsl_bsa_chk_flg") == "0") {
					CellEditable(Row,"M_vsl_cd") = false;
					CellValue2(grpRow,"M_vsl_cd") = '';// 12.03.02 SHKIM(1) - M_vsl_cd 체크를 뺄 경우 공란으로 되면서 비활성화 됩니다.
				}
			}
			if (ColSaveName(Col) == "M_vvd_cd") {
				selRow = Row;
				selValue = Value;
		
				param = param+"f_cmd="+SEARCHLIST02;
				param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
				param = param+"&code=etdDt";
				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
				var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
				getEdtDate(etdDt);
			}
			
			// [S] 2012.03.05 SHKIM - VSL Code 입력하면.. 존재하는 코드인지 체크되게 해주세요.BSACommonSC.searchCode() MDM_VSL_CNTR 테이블 참조
			if (ColSaveName(Col) == "M_vsl_cd" && (sheetObj.CellValue(Row,Col)==null || sheetObj.CellValue(Row,Col)!='')) {
				selRow = Row;
				selValue = Value;
				param = param+"f_cmd="+SEARCHLIST02;
				param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
				param = param+"&code=vslCd";
				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
				var vslCdCnt = GetEtcDataForExceptional(sXml, "vslCdCnt", "0");
				if(vslCdCnt < 1){
					ComShowMessage(ComGetMsg('BSA10047',sheetObj.CellValue(Row,Col)));
					sheetObj.CellValue2(Row,Col) = '';
					// focus
					sheetObj.SelectCell(Row, Col, true);
				}
			}
			// [E] 2012.03.05 SHKIM - VSL Code 입력하면.. 존재하는 코드인지 체크되게 해주세요.BSACommonSC.searchCode() MDM_VSL_CNTR 테이블 참조
			
		}
	}
	
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	* - 2012.03.02 SHKIM 
	*	VLS Chk 체크여부에 따라 From/To Date 를 체크.
	*
	*/
	function validateForm(sheetObj) {
		with(sheetObj){
			
			// From 날짜가 To 날짜보다 큰 경우
			var cnt = sheetObj.RowCount + 3;
			
			for(i = 3; i < cnt; i++){
				if(sheetObj.CellValue(i, "M_bsa_fm_dt") > sheetObj.CellValue(i, "M_bsa_to_dt")) {
					ComShowCodeMessage('BSA10045');
					return false;
				}	
			}
			
			// 동일한 Trade/Lane/Direction/Operator/Vessel Capa의 From/To 날짜가 중복되는 경우
			var dup = "";
			
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
				dup = sheetObj.ColValueDupRows("M_trd_cd|M_rlane_cd|M_dir_cd|M_vop_cd|M_vsl_capa", true, true);
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
				
				//[S] 2012.03.05 SHKIM 저장시 VSL Chk여부 VSL Code가 입력되지 않은 경우에는 메세지
				for(var i=2 ; i< (sheetObj.TotalRows+2) ; i++){
					if(CellValue(i,"M_vsl_bsa_chk_flg") == 1){	// 체크여부 
						if( (CellValue(i,"M_vsl_cd") == null)	|| (CellValue(i,"M_vsl_cd") == '') ){
							ComShowCodeMessage('BSA10002','VSL Code');
							// focus
							sheetObj.SelectCell(i,11,true);
							return false;
						}
					}
				}
				//[E] 2012.03.05 SHKIM 저장시 VSL Chk여부 VSL Code가 입력되지 않은 경우에는 메세지
				
				//dup = sheetObj.ColValueDupRows("M_trd_cd|M_rlane_cd|M_dir_cd|M_hjs_fnl_bsa_capa|M_vsl_bsa_chk_flg|M_vsl_cd", true, true); // 2012.03.05 SHKIM 3 M_vsl_bsa_chk_flg
				dup = sheetObj.ColValueDupRows("M_trd_cd|M_rlane_cd|M_dir_cd|M_vsl_bsa_chk_flg|M_vsl_cd", true, true); // 2012.03.05 SHKIM 3 M_vsl_bsa_chk_flg ADD , M_hjs_fnl_bsa_capa DEL
			}
			
			if(dup != "") {
				var arrRow1 = dup.split("|");
				var arrRow2 = arrRow1[0].split(",");	// 최초의 기준행 배열
				var arrRow3 = arrRow1[1].split(",");	// 중복행 배열
				
				// 기준행을 기준으로 중복행 에서 중복 체크
				for(i=0; i < arrRow2.length; i++) {
					for(j=0; j < arrRow3.length; j++) {
						
						// 기준 행보다 작은 중복행 제외
						if(arrRow2[i] < arrRow3[j]) {
							
							// 중복행 배열에서 기준행과 같은 행 찾기
							if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
								if(    sheetObj.CellValue(arrRow2[i], "M_trd_cd")   == sheetObj.CellValue(arrRow3[j], "M_trd_cd")
									&& sheetObj.CellValue(arrRow2[i], "M_rlane_cd") == sheetObj.CellValue(arrRow3[j], "M_rlane_cd")
									&& sheetObj.CellValue(arrRow2[i], "M_dir_cd")   == sheetObj.CellValue(arrRow3[j], "M_dir_cd")
									&& sheetObj.CellValue(arrRow2[i], "M_vop_cd")   == sheetObj.CellValue(arrRow3[j], "M_vop_cd")
									&& sheetObj.CellValue(arrRow2[i], "M_vsl_capa") == sheetObj.CellValue(arrRow3[j], "M_vsl_capa") ) {
									
									if(sheetObj.CellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.CellValue(arrRow2[i], "M_bsa_to_dt")) {
										ComShowCodeMessage('BSA10045');
										return false;
									}
								}	
							} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
								if(    sheetObj.CellValue(arrRow2[i], "M_trd_cd")           == sheetObj.CellValue(arrRow3[j], "M_trd_cd")
									&& sheetObj.CellValue(arrRow2[i], "M_rlane_cd")         == sheetObj.CellValue(arrRow3[j], "M_rlane_cd")
									&& sheetObj.CellValue(arrRow2[i], "M_dir_cd")           == sheetObj.CellValue(arrRow3[j], "M_dir_cd")
									//&& sheetObj.CellValue(arrRow2[i], "M_hjs_fnl_bsa_capa") == sheetObj.CellValue(arrRow3[j], "M_hjs_fnl_bsa_capa")
									&& sheetObj.CellValue(arrRow2[i], "M_vsl_bsa_chk_flg")  == sheetObj.CellValue(arrRow3[j], "M_vsl_bsa_chk_flg") 	// 2012.03.05 SHKIM 3  NOHN Vessel 에 대해서 둘다 VSL Chk 하고 기간을 넣는다고 하면 기간이 중복되면 안되죠
									&& sheetObj.CellValue(arrRow2[i], "M_vsl_cd")           == sheetObj.CellValue(arrRow3[j], "M_vsl_cd")			// 2012.03.05 SHKIM 3
								) {
									if(sheetObj.CellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.CellValue(arrRow2[i], "M_bsa_to_dt")) {
										ComShowCodeMessage('BSA10045');
										return false;
									}
								}
							}	
						}
					}
				}
				
				// 중복행 배열 내에서 중복 체크
				for(i=0; i < arrRow3.length; i++) {
					for(j=i+1; j < arrRow3.length; j++) {
						// 중복행 배열에서 기준행과 같은 행 찾기
						if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
							if(    sheetObj.CellValue(arrRow3[i], "M_trd_cd")   == sheetObj.CellValue(arrRow3[j], "M_trd_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_rlane_cd") == sheetObj.CellValue(arrRow3[j], "M_rlane_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_dir_cd")   == sheetObj.CellValue(arrRow3[j], "M_dir_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_vop_cd")   == sheetObj.CellValue(arrRow3[j], "M_vop_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_vsl_capa") == sheetObj.CellValue(arrRow3[j], "M_vsl_capa") ) {
								if(sheetObj.CellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.CellValue(arrRow3[i], "M_bsa_to_dt")) {
									ComShowCodeMessage('BSA10045');
									return false;
								}
							}
						} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
							if(    sheetObj.CellValue(arrRow3[i], "M_trd_cd")           == sheetObj.CellValue(arrRow3[j], "M_trd_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_rlane_cd")         == sheetObj.CellValue(arrRow3[j], "M_rlane_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_dir_cd")           == sheetObj.CellValue(arrRow3[j], "M_dir_cd")
								&& sheetObj.CellValue(arrRow3[i], "M_hjs_fnl_bsa_capa") == sheetObj.CellValue(arrRow3[j], "M_hjs_fnl_bsa_capa")
								&& sheetObj.CellValue(arrRow3[i], "M_vsl_bsa_chk_flg")  == sheetObj.CellValue(arrRow3[j], "M_vsl_bsa_chk_flg") 	// 2012.03.05 SHKIM 3  NOHN Vessel 에 대해서 둘다 VSL Chk 하고 기간을 넣는다고 하면 기간이 중복되면 안되죠
								&& sheetObj.CellValue(arrRow3[i], "M_vsl_cd")           == sheetObj.CellValue(arrRow3[j], "M_vsl_cd")			// 2012.03.05 SHKIM 3
								) {
								if(sheetObj.CellValue(arrRow3[j], "M_bsa_fm_dt") <= sheetObj.CellValue(arrRow3[i], "M_bsa_to_dt")) {
									ComShowCodeMessage('BSA10045');
									return false;
								}
							}
						}	
					}
				}
			}
		}
	
		return true;
	}
	
	/**
	* 화면 조회값에 대한 유효성검증 프로세스 처리
	*/
	function validateCond(formObj, sAction) {
		with(formObj){	
			if (ComTrim(txtSDate.value) == "") {
				//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
				//formObj.txtSDate.focus();
				ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
	
				return false;
			}
	
			if (sAction == IBCREATE) { } //생성시에만 체크	
			// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
			if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
				if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
					//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
					//txtEDate.focus();
					ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
					return false;
				}
			}
	
			//        if(formObj.cobTrade.value == ""){
			//            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
			//            return false;
			//        }
			//        
			//        if(formObj.cobLane.value == ""){
			//            ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
			//            return false;
			//        }
			/*
			if(formObj.cobDir.value == ""){
			ComAlertFocus(cobDir, ComGetMsg('COM12113','Dir'));
			return false;
			}*/
			}
	
		return true;
	}
	
	//화면의 Enter-Key 처리
	function keyEnter_loc(){
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
		if (event.keyCode == 13) {
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
				doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
			}
		}
	}
	
	//rdoType별 위치이동
	function setOffsetPos(head) {
		var shead = head.split("|");
		var idx = 0;
		var cnt = 0;
		var old = shead[0];
		for(var i=1; i<shead.length; i++) {
			if (old != shead[i]) {
				if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
					splitPos1[idx] = cnt;
				} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
					splitPos2[idx] = cnt;
				}
				idx = idx + 1;
			}
			cnt = cnt + 1;
			old = shead[i];
		}
		if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
			splitPos1[idx] = cnt;
		} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
			splitPos2[idx] = cnt;
		}
	}
	
	//sheet의 현재선택된 Row의 상/하위(offset 만큼) Row를 리턴
	function getFindRow(sheetObj, Row, offset) {
		var rtnRow = -1;
		var bsa_group = "";
		var bsa_seq   = -1;
		var col1 = 0;
		var col2 = 0;
		var tmp = 0;
		
		with(sheetObj) {
			bsa_group = CellValue(Row,"M_bsa_group");
			bsa_seq   = parseInt(CellValue(Row,"M_bsa_seq")) + offset;
			
			for (var i=HeaderRows; i<LastRow; i++) {
				col1 = FindText("M_bsa_group", bsa_group, tmp);
				if (col1 == -1) { break; } //Not Found
				
				col2 = FindText("M_bsa_seq", bsa_seq, col1);
				if (col1 == col2) { //Found
					rtnRow = col2;
					break;
				}
				tmp = col1 + 1;
			}
		}
	
		return rtnRow;
	}
	
	//VVD --> edt-date
	function getEdtDate(result) {
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var tmpRow = 0;
		
		if(result == null || result == "" || result == "null"){
			ComShowMessage(ComGetMsg('BSA10027',selValue));  //msg1 + '는(은) 유효한 VVD가 아니거나 EDT Date가 존재하지 않습니다.'
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
				sheetObject1.SelectCell(selRow,"M_vvd_cd",true);
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
				sheetObject2.SelectCell(selRow,"M_vvd_cd",true);
			}
		} else {
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
				sheetObject1.CellValue(selRow,"M_bsa_fm_dt") = result;
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
				sheetObject2.CellValue(selRow,"M_bsa_fm_dt") = result;
			}
		}
	}
	
	//Grouping별 Max값을 추출
	function getMaxRow(sheetObj) {
		var bsa_group = "";
		var bsa_seq = 0;
		var tmpSeq = 0;
		var tmpRow = 0;
		var maxRow = 0;
		var tmp = 0;
		
		with(sheetObj) {
			if (SelectRow > 0) {
				maxRow = SelectRow;
				bsa_group = CellValue(SelectRow,"M_bsa_group");
				for (var i=HeaderRows; i<LastRow; i++) {
					tmpRow = FindText("M_bsa_group", bsa_group, tmp);
					if (tmpRow == -1) {
						break;
					} else {
						tmpSeq = parseInt(CellValue(tmpRow,"M_bsa_seq"));
						if (bsa_seq <= tmpSeq) {
							bsa_seq = tmpSeq;  //최대값
							maxRow = tmpRow;  //최대값이 위치한 Row
						}
					}
					tmp = tmpRow + 1;
				} //end of for
			}
		} //end of with
		
		return maxRow;
	}
	
	//화면의 Zoom 처리
	function set_Zoom() {
		if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
			if (zoomFlag1 == "open") {
				div_zoom_in1.style.display  = "none";  
				div_zoom_out1.style.display = "inline";
			} else if (zoomFlag1 == "close") {
				div_zoom_in1.style.display  = "inline"; 
				div_zoom_out1.style.display = "none";
			}
			div_zoom_in2.style.display  = "none";
			div_zoom_out2.style.display = "none";
		
		} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
			div_zoom_in1.style.display  = "none";
			div_zoom_out1.style.display = "none";
			if (zoomFlag2 == "open") {
				div_zoom_in2.style.display  = "none";  
				div_zoom_out2.style.display = "inline";
			} else if (zoomFlag2 == "close") {
				div_zoom_in2.style.display  = "inline"; 
				div_zoom_out2.style.display = "none";
			}		
		}
	}
	
	
	//function sheet1_OnSelectMenu(sAction) {
	//    var sheetObject1 = sheetObjects[0];
	//    //ActionMenu = "All Check|-|Excel Download|Excel Upload";
	//    OnSelectMenu(sheetObject1, sAction);
	//}
	
	//추가------------------------------------------------------------------------------------------------------
	
	/**
	* IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 ETC-DATA로 넣은 KEY의 값을 리턴한다.
	* <br><b>Example :</b>
	* <pre>
	*     xmlStr = mySheet.GetSearchXml("list.jsp");
	*     sValue = ComGetEtcData(xmlStr, "UserId");
	*     예를 들어 xmlStr의 내용이 아래와 같다면 sValue의 값은 "ibs006"이 된다.
	*     xmlStr ======================================================
	*       &lt;?xml version='1.0' ?&gt;
	*       &lt;SHEET&gt;
	*         &lt;ETC-DATA&gt;
	*              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
	*              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
	*         &lt;/ETC-DATA&gt;
	*       &lt;/SHEET&gt;
	*     xmlStr ======================================================
	* </pre>
	* @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
	* @param   {string} etcName    필수,xml 문자열에서 추출하고자하는 ETC Key이름
	* @return  string, ETC-DATA로 넣은 KEY의 값
	* @version 3.4.0.50
	*/
	function GetEtcDataForExceptional0021(xmlStr,etcName){
		if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;
		
		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
			xmlDoc.loadXML(xmlStr);
			
			var xmlRoot = xmlDoc.documentElement;
			if(xmlRoot == null) return;
			
			var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
			if(etcDataNode == null) return;
			
			var etcNodes = etcDataNode.childNodes;
			if(etcDataNode == null) return;
			
			for(var i=0;i<etcNodes.length;i++){
				if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;
				
				if(etcNodes[i].attributes(0).text==etcName) {
					if (etcNodes[i].firstChild==null) {
						return "";
					} else {
						return etcNodes[i].firstChild.nodeValue;
					}
				}
			}
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComAddSeparator_Local(obj, sFormat) {
		try {
			//obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	/**
	* trade코드 변경시 rLane 리스트를 리플래쉬 한다.
	*/
	function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
	}

	/**
	 * ESM_BSA_0123 popup에서 VVD선택 시 setting하는 함수
	 */
	function getESM_BSA_0123(vvd, row, type)
	{
		if(type == "J"){
			var sheetObj = sheetObjects[0];
			sheetObj.CellValue(row,"M_vvd_cd") = vvd;
		}else if(type == "S"){
			var sheetObj = sheetObjects[1];
			sheetObj.CellValue(row,"M_vvd_cd") = vvd;
		}

	} 	
	
//	2015.01.09 YONGSEUP KIM - find joint operating contracts having overlapped dates and change the background color of the cells having overlapped date data into red
	function overlappedDateCheckForJointOperating(sheetObj)
	{		
		for(var k=3; k<=sheetObj.LastRow-1; k++){			
			if( (parseInt(sheetObj.CellValue(k,'M_bsa_seq')) + 1 == parseInt(sheetObj.CellValue(k+1,'M_bsa_seq')) ) && // if squences of two rows are continued 
				(sheetObj.CellValue(k,'M_trd_cd') == sheetObj.CellValue(k+1,'M_trd_cd')) && // if the two rows have the same trade code
				(sheetObj.CellValue(k,'M_sub_trd_cd') == sheetObj.CellValue(k+1,'M_sub_trd_cd')) && // if the two rows have the same subtrade code
				(sheetObj.CellValue(k,'M_rlane_cd') == sheetObj.CellValue(k+1,'M_rlane_cd')) && // if the two rows have the same revenue lane code
				(sheetObj.CellValue(k,'M_dir_cd') == sheetObj.CellValue(k+1,'M_dir_cd')) && // if the two rows have the same direction code
				(sheetObj.CellValue(k,'M_vop_cd') == sheetObj.CellValue(k+1,'M_vop_cd')) && // if the two rows have the same operator code
				(parseInt(sheetObj.CellValue(k,'M_bsa_capa')) == parseInt(sheetObj.CellValue(k+1,'M_bsa_capa'))) ){ // if the two rows have the same loadable capacity
				
					var from_value = sheetObj.CellValue(k,'M_bsa_fm_dt');				
					var year_of_from_value = from_value.substring(0,4);
					var month_of_from_value = from_value.substring(4,6);
					var day_of_from_value = from_value.substring(6,8);				
				
					var to_value = sheetObj.CellValue(k,'M_bsa_to_dt');				
					var year_of_to_value = to_value.substring(0,4);
					var month_of_to_value = to_value.substring(4,6);
					var day_of_to_value = to_value.substring(6,8);				
					
					var from_value_of_the_next_seq = sheetObj.CellValue(k+1,'M_bsa_fm_dt');
					var year_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(0,4);
					var month_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(4,6);
					var day_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(6,8);				
					
					var to_value_of_the_next_seq = sheetObj.CellValue(k+1,'M_bsa_to_dt');
					var year_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(0,4);
					var month_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(4,6);
					var day_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(6,8);	
					
					// activated when 'To' date is earlier than 'From' date (in the same sequence)
					if( year_of_from_value > year_of_to_value ){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if( year_of_from_value == year_of_to_value && month_of_from_value > month_of_to_value ){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if( year_of_from_value == year_of_to_value && month_of_from_value == month_of_to_value && day_of_from_value > day_of_to_value ){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}					
					
					// activated when 'To' date is later than(or the same with) 'From' date of the next sequence
					if(year_of_to_value > year_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_from_value_of_the_next_seq && month_of_to_value > month_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_from_value_of_the_next_seq && month_of_to_value == month_of_from_value_of_the_next_seq && day_of_to_value >= day_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}
					
					// activated when 'To' date is later than(or the same with) 'To' date of the next sequence
					if(year_of_to_value > year_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_to_value_of_the_next_seq && month_of_to_value > month_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_to_value_of_the_next_seq && month_of_to_value == month_of_to_value_of_the_next_seq && day_of_to_value >= day_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}
					
					// activated when 'From' date is later than(or the same with) 'From' date of the next sequence
					if(year_of_from_value > year_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_from_value == year_of_from_value_of_the_next_seq && month_of_from_value > month_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_from_value == year_of_from_value_of_the_next_seq && month_of_from_value == month_of_from_value_of_the_next_seq && day_of_from_value >= day_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}
			}	
		} // the end of the for loop 
	} // the end of the function
	
	
//	2015.01.09 YONGSEUP KIM - made to find space chartering contracts having overlapped dates and change the background color of the cells having overlapped date data into red
	function overlappedDateCheckForSpaceChartering(sheetObj)
	{
		for(var k=2; k<=sheetObj.LastRow-1; k++){
			if( (parseInt(sheetObj.CellValue(k,'M_bsa_seq')) + 1 == parseInt(sheetObj.CellValue(k+1,'M_bsa_seq')) ) && // if squences of two rows are continued 
				(sheetObj.CellValue(k,'M_trd_cd') == sheetObj.CellValue(k+1,'M_trd_cd')) && // if the two rows have the same trade code
				(sheetObj.CellValue(k,'M_rlane_cd') == sheetObj.CellValue(k+1,'M_rlane_cd')) && // if the two rows have the same revenue lane code
				(sheetObj.CellValue(k,'M_dir_cd') == sheetObj.CellValue(k+1,'M_dir_cd')) ){ // if the two rows have the same direction code

					var from_value = sheetObj.CellValue(k,'M_bsa_fm_dt');				
					var year_of_from_value = from_value.substring(0,4);
					var month_of_from_value = from_value.substring(4,6);
					var day_of_from_value = from_value.substring(6,8);				
				
					var to_value = sheetObj.CellValue(k,'M_bsa_to_dt');				
					var year_of_to_value = to_value.substring(0,4);
					var month_of_to_value = to_value.substring(4,6);
					var day_of_to_value = to_value.substring(6,8);				
					
					var from_value_of_the_next_seq = sheetObj.CellValue(k+1,'M_bsa_fm_dt');
					var year_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(0,4);
					var month_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(4,6);
					var day_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(6,8);				
					
					var to_value_of_the_next_seq = sheetObj.CellValue(k+1,'M_bsa_to_dt');
					var year_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(0,4);
					var month_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(4,6);
					var day_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(6,8);		
					
					// activated when 'To' date is earlier than 'From' date (in the same sequence)
					if( year_of_from_value > year_of_to_value ){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if( year_of_from_value == year_of_to_value && month_of_from_value > month_of_to_value ){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if( year_of_from_value == year_of_to_value && month_of_from_value == month_of_to_value && day_of_from_value > day_of_to_value ){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}					
					
					// activated when 'To' date is later than(or the same with) 'From' date of the next sequence
					if(year_of_to_value > year_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_from_value_of_the_next_seq && month_of_to_value > month_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_from_value_of_the_next_seq && month_of_to_value == month_of_from_value_of_the_next_seq && day_of_to_value >= day_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0); 
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}
					
					// activated when 'To' date is later than(or the same with) 'To' date of the next sequence
					if(year_of_to_value > year_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_to_value_of_the_next_seq && month_of_to_value > month_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_to_value_of_the_next_seq && month_of_to_value == month_of_to_value_of_the_next_seq && day_of_to_value >= day_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0); 
						sheetObj.CellBackColor(k+1,'M_bsa_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}
					
					// activated when 'From' date is later than(or the same with) 'From' date of the next sequence
					if(year_of_from_value > year_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_from_value == year_of_from_value_of_the_next_seq && month_of_from_value > month_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_from_value == year_of_from_value_of_the_next_seq && month_of_from_value == month_of_from_value_of_the_next_seq && day_of_from_value >= day_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'M_bsa_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}
			}	
		} // the end of the for loop 
	} // the end of the function
	
	
//	2015.01.09 YONGSEUP KIM - change red background color of cells into white before checking if date data is input without overlap(s) again
	function checkDate(sheetObj)
	{		
		for(var k=2; k<=sheetObj.LastRow-1; k++){			
			if(sheetObj.CellBackColor(k,'M_bsa_to_dt') == sheetObj.RgbColor(192, 0, 0)){
				sheetObj.CellBackColor(k,'M_bsa_to_dt') = sheetObj.CellBackColor(k,'M_vvd_cd');
			}
			
			if( sheetObj.CellBackColor(k,'M_bsa_fm_dt') == sheetObj.RgbColor(192, 0, 0) ){
				sheetObj.CellBackColor(k,'M_bsa_fm_dt') = sheetObj.CellBackColor(k,'M_vvd_cd'); 
			}	
		} // the end of the for loop 
		
		if(sheetObj==sheetObjects[0]){
			overlappedDateCheckForJointOperating(sheetObj);
		}else if(sheetObj==sheetObjects[1]){
			overlappedDateCheckForSpaceChartering(sheetObj);
		}
	} // the end of the function