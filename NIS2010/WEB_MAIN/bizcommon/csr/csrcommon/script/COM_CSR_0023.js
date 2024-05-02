/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : COM_CSR_0023.js
 *@FileTitle : Files Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.21
 *@LastModifier : 9014787
 *@LastVersion : 1.0
 * 2014.07.21 9014787
 * 1.0 Creation
 * 2015.05.13 심성윤 [CHM-201535807] PSO 별도 파일 추가 탭 기능 개발
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class COM_CSR_0023 : COM_CSR_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function COM_CSR_0023() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var uploadObjects = new Array();
var uploadCnt = 0;
var URL_COM_CSR = 'COM_CSR_0023GS.do';
var prefix = "sheet1_";
var prefix2 = "sheet2_";
var gvFileSize = 0; 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */


var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var invSubSysCd = ""; 
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	if (document.form.csr_no.value == '') {
		//ComShowCodeMessage("COM14001", "CSR No.");// 조회를 위한 CSR no가 없습니다.
		self.close();
	} else {
		try {
			for (i = 0; i < sheetObjects.length; i++) {

				//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet(sheetObjects[i]);

				initSheet(sheetObjects[i], i + 1);

				// khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			for(k=0;k<tabObjects.length;k++){
	            initTab(tabObjects[k],k+1);
	        }

			//UPLOAD 환경 설정
			for ( var i = 0; i < uploadObjects.length; i++) {
				//1. 기본 환경 설정
				ComConfigUpload(uploadObjects[i], "/hanjin/" + URL_COM_CSR);
				
				//uploadObjects[i].SetLimit(15, 5120);

				// 2. Upload 초기화
				// initUpload(uploadObjects[i],i+1);
			}
			uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
			ComEnableObject(document.form.csr_no, false);
			
			
			// 배열 처리를 통한 tabObjects[0].TabEnable(0) = false;
			var tab_enable = document.form.tab_enable.value;
			invSubSysCd = document.form.invSubSysCd.value;
			
			if(tab_enable != ""){
				var tab_enables = tab_enable.split('|');
				
				if(tab_enables.length != 3){
					// close
					self.close();
				}else{
					
					var tab_last = 0;
					for(var tab_i = tab_enables.length-1; tab_i >= 0; tab_i--){
						//alert("tab_i : " + tab_i + " : tab_enables[tab_i] : " +tab_enables[tab_i]);
						tabObjects[0].tabEnable(tab_i) = tab_enables[tab_i];
						
						//alert(tab_i+"     "+tab_enables[tab_i]);
						// GW Contract 가 false 일경우 조회하지 않음
						
						if(tab_i == 0 && tab_enables[tab_i] != 0){
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						}
						
						if(tab_enables[tab_i] != 0){
							if(invSubSysCd != "PSO"){
								tab_last = tab_i;
							}else{
								tab_last = 3; 
							}
						}
					}
					if(invSubSysCd != "PSO"){
						//[CHM-201535807]
						tabObjects[0].tabEnable(3) = 0;
					}
					tabObjects[0].SelectedIndex = tab_last;
				}
			}else{
				// close
			}
			
			
			
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
			/*csr_error_alert(ex);
			return false;*/
		}
	}
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 350;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "||S/P No.|Inv No.|Agreement Link|Name|OFC||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, prefix + "del_chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, prefix + "vndr_seq", false, "", dfNone, 0, false, true);
			//InitDataProperty(0, cnt++ , dtCombo,  150,    daLeft,    true,     "calc_tp_cd",       false,         "",        dfNone,   	0,     false,      true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, prefix + "inv_no", false, "", dfNone, 0, false, false, 200);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, prefix + "l_document_title", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 130, daCenter, false, prefix + "l_assetcd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix + "csr_file_upld_tp_cd");
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "atch_file_id");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "csr_no");

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "file_path");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ridr_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "file_sav_id");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "img_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "editable_yn");
			

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			//CountPosition = 0; 
		}
		break;
		
	case 2: //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 350;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(13, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Del|File Name|File Remark|Name|OFC|||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix2 + "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, prefix2 + "del_chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 275, daLeft, false, prefix2 + "file_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 400, daLeft, false, prefix2 + "file_rmk", false, "", dfNone, 0, false, false, 200);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, prefix2 + "usr_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, prefix2 + "ofc_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, prefix2 + "csr_file_upld_tp_cd");
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "atch_file_id");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "csr_no");

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "file_path");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "ridr_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "file_sav_id");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "editable_yn");

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			//CountPosition = 0; 
		}
		break;
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param tab_obj
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 * @param(tab_obj)
 */
function initTab(tabObj , tabNo) {

     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++ , "GW Contract" , -1 );
                InsertTab( cnt++ , "Contract" , -1 );
                InsertTab( cnt++ , "Files" , -1 );
                InsertTab( cnt++ , "PSO Tariff" , -1 ); //[CHM-201535807]
            }
         break;

     }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * @param(tabObj)
 * @param(nItem)
 */
function tab1_OnChange(tabObj , nItem)
{


    var objs = document.all.item("tabLayer");
    
    if(nItem == 0){
    	objs[0].style.display = "Inline";
		objs[1].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[1].style.zIndex = objs[0].style.zIndex -1 ;
		//------------------------------------------------------//
    }else{
    	objs[1].style.display = "Inline";
		objs[0].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[0].style.zIndex = objs[1].style.zIndex -1 ;
		//------------------------------------------------------//
    }
	
	
	// csr_file_upld_tp_cd
	var formObject = document.form;
	if(nItem == 0){
		formObject.csr_file_upld_tp_cd.value = "";
	}else if(nItem == 1){
		formObject.csr_file_upld_tp_cd.value = "FA";
	}else if(nItem == 2){
		formObject.csr_file_upld_tp_cd.value = "FU";
	}else if(nItem == 3){
		formObject.csr_file_upld_tp_cd.value = "PF"; //[CHM-201535807], PSO Tariff 용 추가
	}

	// GW Contract Only Close Btn, Contract All Btn, Files All Btn
	var btn_readOnly = document.form.btn_readOnly.value;
	if(btn_readOnly == "N" || btn_readOnly == ""){
		var target;
		if(beforetab == 0){
			target = document.getElementById('td_btn_upload');
			target.style.display = "block";
			target = document.getElementById('td_btn_delete');
			target.style.display = "block";
			target = document.getElementById('td_btn_save');
			target.style.display = "block";
		}else if(nItem == 0){
			target = document.getElementById('td_btn_upload');
			target.style.display = "none";
			target = document.getElementById('td_btn_delete');
			target.style.display = "none";
			target = document.getElementById('td_btn_save');
			target.style.display = "none";
		}
	}
	
	beforetab = nItem;
	
	// search
	
	if(nItem == 3){
		//[CHM-201535807] Tariff 용 탭
		//alert("Tariff 목록 출력");
		doActionIBSheet_sheet2(sheetObjects[1], formObject, IBSEARCH);
	}else if(nItem > 0){
		doActionIBSheet_sheet2(sheetObjects[1], formObject, IBSEARCH);
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
	
	//document.domain = "alpsdev.hanjin.com";
	//document.domain = '';

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_upload":

			// 15 file check
			if(sheetObject2.RowCount >= 15){
				ComShowMessage("Please attache less than 15 files");
				return false;
			} 
			
			// GW 아닐경우만
			var check_value = "XX";//fn_getRadioValue(document.getElementsByName('csr_file_upld_tp_cd'));
			if(check_value != "GW"){
				doActionIBSheet_sheet2(sheetObject2, formObject, IBINSERT);
			}
			break;
		case "btn_close":
			//window.close();
			self.close();
			break;
		case "btn_excel":
            //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
	        break;
		case "btn_delete":
			doActionIBSheet_sheet2(sheetObject2, formObject, IBDELETE);
	        break;
		case "btn_save":
			//2.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
			if (!ComShowConfirm("Data Changed. Do you want to save it ?")){
				return;
			}
			doActionIBSheet_sheet2(sheetObject2, formObject, MODIFY02);
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
var item_cnt = 0; // 현재 sheet에 보이는 item의 갯수
function fn_filteredData(sheetObj, tmp_name, tmp_value) {
	item_cnt = 0;
	var cnt = sheetObj.LastRow;
	if (cnt == 0)
		return;
	for (ix = 1; ix <= cnt; ix++) {
		if (sheetObj.RowStatus(ix) == 'D') {
		} else if (sheetObj.CellValue(ix, tmp_name) == tmp_value) {
			sheetObj.RowHidden(ix) = false;
			item_cnt++;
		} else {
			sheetObj.RowHidden(ix) = true;
		}
	}
	return true;
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColFontUnderline(prefix2 + "file_nm") = true;
		DataLinkMouse(prefix2 + "file_nm") = true;
	}
	
	if( sheetObj.RowCount > 0 ){
		setCellEditable(sheetObj);
	}
}

function setCellEditable(sheetObj) {
	for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
		if( sheetObj.CellValue(idx, prefix2 + "editable_yn") == "Y" ){
			sheetObj.CellEditable(idx, prefix2 + "file_rmk") = true;
		}
	}
}
/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet_sheet2(sheetObj, document.form, IBSEARCH); // 파일링크를 위해 재조회
}
/**
 * 파일 다운받기 GW<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function sheet1_OnClick(sheetObj, Row, Col, Value) {

	if (Col == '4') {
		
		var ifrm = document.createElement("IFRAME");
		ifrm.setAttribute("id", "gwrequest");
		ifrm.style.width = 0+"px";
		ifrm.style.height = 0+"px"
		
		var csrGwUrl = document.form.csr_gw_url.value;
		var url = "";

		var assetcd = sheetObj.CellValue(Row, 5);
		if(assetcd != ''){
			url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+assetcd);
			ifrm.setAttribute("src", url);
			document.body.appendChild(ifrm);
		}
	}
	
	return;
}

/**
 * 파일 다운받기 ALPS<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function sheet2_OnClick(sheetObj, Row, Col, Value) {

	if (Col != 2) return;
	
	var key_id = sheetObj.CellValue(Row, prefix2 + "file_sav_id");
	hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	
	return;
}

/**
 * Sheet관련 프로세스 처리 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	formObj   
 * @param {String} 	sAction   
 * @return {없음}
 **/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet1_");
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCH);
		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_COM_CSR, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet1_'));
		// 3.조회후 결과처리
		//alert(sXml);
		sheetObj.LoadSearchXml(sXml);
		// 4.값 존재시 처리
		if (sheetObj.RowCount > 0) {
			//조건에 따른 데이터 필터링  
			/*var check_value = fn_getRadioValue(document.getElementsByName('csr_file_upld_tp_cd'));
			if (fn_filteredData(sheetObj, prefix + "csr_file_upld_tp_cd", check_value)) {
				//size 변경하기 
				for ( var row = 1; row <= sheetObj.LastRow; row++) {
					var size = getSize(sheetObj.CellValue(row, prefix + "file_size"));
					sheetObj.CellValue(row, prefix + "file_size") = size;
					sheetObj.RowStatus(row) = 'R';
				}
			}*/
		}
		break;
	case IBINSERT: // 입력
		//ComOpenWait(true, true);
		var rtn = selectFile(sheetObj, sheetObj.RowCount, '', true);
		if(rtn == true)
			doActionIBSheet(sheetObj, formObj, IBSAVE);
		break;
	case IBDOWNEXCEL:        //엑셀 다운로드
        //sheetObj.SpeedDown2Excel(-1);
		sheetObj.Down2Excel(-1, false, false, true); // merge 된 excel
        break;
	}
}


function doActionIBSheet_sheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet2_");
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCH02);
		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_COM_CSR, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet2_'));
		// 3.조회후 결과처리
		//alert(sXml);
		sheetObj.LoadSearchXml(sXml);
		// 4.값 존재시 처리
		if (sheetObj.RowCount > 0) {
			//조건에 따른 데이터 필터링  
			/*var check_value = fn_getRadioValue(document.getElementsByName('csr_file_upld_tp_cd'));
			if (fn_filteredData(sheetObj, prefix + "csr_file_upld_tp_cd", check_value)) {
				//size 변경하기 
				for ( var row = 1; row <= sheetObj.LastRow; row++) {
					var size = getSize(sheetObj.CellValue(row, prefix + "file_size"));
					sheetObj.CellValue(row, prefix + "file_size") = size;
					sheetObj.RowStatus(row) = 'R';
				}
			}*/
		}
		break;
	case IBSAVE: //저장
	case MODIFY02:
		//ComOpenWait(true, true);
		//if (!validateForm(sheetObj, formObj, sAction)) return;

		// 0.IBUpload에 파일 추가하기
		var upObj = uploadObjects[0];
		upObj.Files = ""; // -먼저기존파일을 모두 지운후 추가함
		var paramFile1 = setFileUpload(sheetObj, prefix2);
		ComSetObjValue(formObj.f_cmd, MULTI);

		// 2.IBSheet 데이터 QueryString으로 묶기
		var sParam = ComGetSaveString(sheetObj);

		if (sParam == ""){
			if(sAction == MODIFY02){
				self.close();
			}
			return;
		}
		
		
		var formObject = document.form;
		if( !(formObject.csr_file_upld_tp_cd.value == "FA" || formObject.csr_file_upld_tp_cd.value == "FU" || formObject.csr_file_upld_tp_cd.value == "PF") ){
			alert('NOT FA FU PF');
			return false;
		}
		
		//alert('sParam :' + sParam);
		//alert('FormQueryString(formObj) :' + FormQueryString(formObj));
		//alert('ComGetPrefixParam(prefix2) :' + ComGetPrefixParam(prefix2));

		// 1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		
		//ComOpenWait(true, false); // 키보드나 마우스를 대기상태 & 대기이미지
		//ComOpenWait(false, false); // 키보드나 마우스를 대기상태 & 대기이미지

		if (upObj.LocalFiles == "") {
			
			
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2);
			// 4. 서버에 request전달하고, reponse 받기
			
			var sXml = sheetObj.GetSaveXml(URL_COM_CSR, sParam);
			
			
			/*if (sXml.length > 0)
				sheetObj.LoadSaveXml(sXml);*/
			if (sXml.length > 0){
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {	
					//ComShowMessage(ComGetMsg("COM14007"));
					//ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}else{
					fnExceptionMessage(sXml);
				}
			}
		} else {
			//3.Form 데이터 QueryString으로 묶기
			
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2);
			// 3.저장조건으로 저장실행
			upObj.ExtendParam = sParam; // param값 추가
			upObj.ParamDecoding = true;
			var sXml = upObj.DoUpload(true);
			
			//ComOpenWait(true);
			// 4.저장후 결과처리
			if (sXml.length > 0){
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {	
					//ComShowMessage("Data has been saved sucessfully.");
					//ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}else{
					fnExceptionMessage(sXml);
				}
			}
		}
		
		
		// IBSAVE 인지 IBUPLOAD 인지 확인후 self.close 처리
		if(sAction == "btn_save"){
			self.close();
		}
		break;

	case IBINSERT: // 입력
		//ComOpenWait(true, true);
		var rtn = selectFile(sheetObj, sheetObj.RowCount, '', true);
		if(rtn == true)
			doActionIBSheet_sheet2(sheetObj, formObj, IBSAVE);
		break;

	case IBDOWNEXCEL:        //엑셀 다운로드
        //sheetObj.SpeedDown2Excel(-1);
		sheetObj.Down2Excel(-1, false, false, true); // merge 된 excel
        break;

	case IBDELETE: // 삭제
		//alert(sheetObj.FindCheckedRow(prefix2 + "del_chk"));
		if (sheetObj.FindCheckedRow(prefix2 + "del_chk") != "") {
			if (!ComShowConfirm("Are you sure to delete?")){ 
				return;
			}
			ComRowHideDelete(sheetObj, prefix2 + "del_chk");
			doActionIBSheet_sheet2(sheetObj, document.form, IBSAVE);
		} else {
			//ComShowCodeMessage("COM14004");// "No Selected Row";
			ComShowMessage('No Selected Row');
		}
		break;
	}
}

/**
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix    	변수 구분값
 **/
function setFileUpload(sheetObj, prefix) {
	var sRow = sheetObj.FindStatusRow("I");
	var upObj = uploadObjects[0];
	var arrRow = sRow.split(";");
	

	for (idx = 0; idx < arrRow.length - 1; idx++) {
		var row = arrRow[idx];

		// 파일 경로 가져오기
		var sFile = sheetObj.CellValue(row, prefix + "file_path");

		// IBUpload에 파일 추가하기
		var ret = upObj.AddFile(sFile);//var ret = upObj.AddFile(sFile);
		var fileSize = upObj.GetFileSize(sFile);
	}

	var param = prefix + "file_cnt=" + (arrRow.length - 1);
	//alert('param : '+param);

	return param;
}

/**
 * 용량계산하기  <br>
 * @param {String} 	_val 		파일용량
 * @param {String} 	r_value    	MB/KB계산 
 **/
function getSize(_val) {

	var r_value = _val;
	var _value = Math.round(_val / 1024);

	if (_value > 0) {
		r_value = _value;
		_value = Math.round(_value / 1024);
		if (_value > 0) {
			_value = _value + " MB"
		} else {
			_value = r_value + " KB"
		}
	} else {
		_value = r_value + " Bytes"
	}
	return _value;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}

/**
 * IBSheet의 대한 Row를 추가한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix   변수 구분값
 * @param {String} 	flag    Row Add/Row Ins의 구분값
 * @return {없음}
 **/
function sheet1_DataInsert(sheetObj, prefix, flag) {
	var row = sheetObj.SelectRow;
	var col = sheetObj.SelectCol;

	var file_nm = sheetObj.CellValue(row, prefix + "file_nm");
	// 1. upload 파일 존재유무
	if (sheetObj.RowCount == 0 || (typeof file_nm != "undefined" && file_nm != "")) {
		row = sheetObj.DataInsert(-1);
	}
	//2. 파일선택 팝업창
	sheetObj.SelectCell(row, prefix + "file_nm");
}

/**
 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
 * @param {ibupload} uploadObj    IBUpload Object
 **/
function setUploadObject(uploadObj) {
	uploadObjects[uploadCnt++] = uploadObj;
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
 * Debug alert 
 */
function csr_error_alert(ex) {
	alert('[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
 /**
 * fnExceptionMessage 
 */
 function fnExceptionMessage(rXml){
 	var rMsg = ComGetEtcData(rXml,"Exception")
 	var rmsg = rMsg.split("<||>");
 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
 		ComShowMessage(rmsg[3]);
 	}else{
 		sheetObjects[0].LoadSaveXml(rXml);
 	}
 }

 
 /**
  * 파일 선택하기 <br>
  * @param {ibsheet} sheetObj    IBSheet Object
  * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
  **/
function selectFile(sheetObj, Row, Col, _insert) {
 	if (Col == '' || Col == '2') {

 		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
 		var file_nm = sheetObj.CellValue(Row, prefix2 + "file_nm");

 		if (typeof file_nm == "undefined" || file_nm == "File Name" || (file_nm != "" && _insert)) {
 			Row = sheetObj.DataInsert(-1, 0);// File Add인 경우 New Row 생성
 		}

 		var fileName = sheetObj.OpenFileDialog('');
 		var upObj = uploadObjects[0];
 		var fileSize = upObj.GetFileSize(fileName);
 		//alert('fileName :'+fileName +': fileSize :'+ fileSize +': file_nm :'+ file_nm);
// 		ComOpenWait(true);
 		if(fileSize >= 5485760){		
 			sheetObj.RowDelete(sheetObj.RowCount, false);
 			alert("Each attached file size will not exceed 5MB ["+fileSize+"]");
  			return false;
  		}
 		
 		if (fileName.indexOf("\\") != -1) {
 			sheetObj.CellValue2(Row, prefix2 + "file_path") = fileName;
 			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
 			sheetObj.CellValue2(Row, prefix2 +"file_nm") = fileName;
 			//var check_value = fn_getRadioValue(document.getElementsByName('csr_file_upld_tp_cd'));
 			var check_value = document.form.csr_file_upld_tp_cd.value;
 			sheetObj.CellValue2(Row, prefix2+ "csr_file_upld_tp_cd") = check_value;
 			return true;
 		}else{
 			sheetObj.RowDelete(sheetObj.RowCount, false);
 			return false;
 		}
 	}
 }
 
/* 개발자 작업  끝 */