/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0207.js
*@FileTitle  : B/L Rider
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */
/**
 * @extends 
 * @class esm_bkg_0207 : esm_bkg_0207 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var uploadObjects=new Array();
	var uploadCnt=0;
	var sheetCnt=0;
	var BKG_DIV_NAME="_Bkg_div1_";
	var BKG_FRAME_NAME="_Bkg_iframe1_";
	var checkBoxString='';
	var iframeW=190;
	var iframeH=100;
	var prefix="sheet1_";
	var _debug=false;
	var isInquiry = "N";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) 	{
		case 1: //sheet1 init
		    with(sheetObj){
			      var HeadTitle="|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0,  	Width:240,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Right",  ColMerge:0,   SaveName:prefix+"file_size",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  	Width:120, 	Align:"Center",  ColMerge:0,   SaveName:prefix+"cargo_contain", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",     Hidden:0, 	Width:5,    Align:"Center",  ColMerge:1,   SaveName:prefix+"multiPopup",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"file_path" },
			             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ridr_tp_cd" },
			             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"file_sav_id" },
			             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"img_seq" }, 
			             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cargo_cnt" },
			             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"dcgo_seq" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetImageList(0,"img/opus/button/btns_multisearch.gif");
			      SetImageList(1,"img/opus/button/btng_minus.gif");
			      SetShowButtonImage(2);
			      SetFocusEditMode(0);
//			      SetSheetHeight(302);
			      resizeSheet();
		      }
			break;
		}
	}
	
	function resizeSheet(){
   	         ComResizeSheet(sheetObjects[0],65);
   }
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
//			case "btn_upload":
//				doActionIBSheet(sheetObject1, formObject, IBINSERT);
//				break;
			case "btn_delete":
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
			case "btn_save":
				if (!ComShowConfirm(ComGetMsg("BKG00254"))){
					return;
				}
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			} // end switch
		} catch (ex) {
			if (ex == "[object Error]") {
				bkg_error_alert('processButtonClick', ex);
				ComShowMessage(OBJECT_ERROR);
			} else {
				alert(ex);
			}
		}
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj=document.form;
		try {
			if (formObj.open_tp_cd.value == "D") {
				ComSetDisplay("pop_title", false);
				ComSetDisplay("pop_search", false);
			}
			if (formObj.bkg_no.value == '') {
				ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
			} else {
				// 최초 type 값을 setting 
				document.getElementById('v_bkg_no').innerHTML=document.form.bkg_no.value;
				fn_setRadioValue(document.getElementsByName('r_ridr_tp_cd'), ComGetObjValue(document.form.ridr_tp_cd));
			}
			for (i=0; i < sheetObjects.length; i++) {
				//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet(sheetObjects[i]);
				initSheet(sheetObjects[i], i + 1);
				//khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			if (opener){ 
				isInquiry = opener.form.isInquiry.value;
			}
			else if (parent){ 
				isInquiry = parent.form.isInquiry.value;
			}
			initUpload();
			// DIV 초기화
			divLayer_Config();
			// 최초 조회시작 
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} 
		catch (ex) {
			bkg_error_alert('loadPage', ex);
			return false;
		}
	}
	
	function initUpload(){
    	upload1.Initialize({
			SaveUrl:"/opuscntr/ESM_BKG_0207GS.do",
			ShowButtonArea: true,
			ShowInfoArea: false,
			ExtraForm:'upLoadForm',
			AddSaveButton: function(ibup){
				
			},
			AfterSaveStatus : function(result) {
				var code = result.code;
				
				if(document.upLoadForm){
					document.body.removeChild(document.upLoadForm);
				}
				
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			sXml = convert2ibsheet7(sXml);
	      			if (sXml.length > 0){
	      				ComShowMessage(ComGetMsg("BKG06071"));
	      				sheet1.LoadSaveData(sXml);
	      			}
	 				var files = result.files;
	                for( var i = 0; i < files.length; i++) {
//	                    files[i].DeleteFromList();
	                	ComUploadRemoveFile(upload1, "", true);
	                }
	      		}else {
					ComShowMessage(result.msg);
				}
			},			
			BeforeSaveStatus : function(result) {
			   return true;
			},
			AfterAddFile : function(result) {
				//if (typeof file_nm == "undefined" || file_nm == "File Name" || (file_nm != "" && _insert)) {
				//	sheetObj.DataInsert(-1, 0);//File Add인 경우 New Row 생성
				//}
				doActionIBSheet(sheetObjects[0], document.form, IBINSERT);  
				
                var files = result.files;
                var fileName=files[files.length-1].GetFileName();
                var row = sheet1.GetSelectRow();
                var formObj = document.form;
				
                for( var i = 0; i < files.length; i++) {
                	if(sheet1.GetCellValue(sheet1.GetSelectRow(), prefix+"file_nm") == files[i].GetFileName()){
                		files[i].DeleteFromList();
                	}
                }
                var files = upload1.GetList();
                var fileName=files[files.length-1].GetFileName();
                var serialNo = files[files.length-1].GetSerialNo();
                var row = sheet1.GetSelectRow();
				
                for( var i = 0; i < files.length; i++) {
                	console.log(sheet1.GetCellValue(sheet1.GetSelectRow(), prefix+"file_sav_id") + ">>" + files[i].GetSerialNo());
                	if(sheet1.GetCellValue(sheet1.GetSelectRow(), prefix+"file_sav_id") == files[i].GetSerialNo()){
                		upload1.RemoveOneFile(files[i].GetSerialNo());
                	}
                }
                
                sheet1.SetCellValue(row, prefix + "file_path",fileName,0);
//                sheet1.SetCellValue(row, prefix+"file_sav_id",serialNo,0); //현재 full local url 은 지원되지않음. 스페셜 카고는 ibupload에서 제공 하는 serialNo를 사용하지 않음. bcimple에서 프레임웍에서 제공하는 file save id를 사용 
    			//fileName=fileName.substr(fileName.lastIndexOf("\\") + 1);
    			sheet1.SetCellValue(row, prefix + "file_nm",fileName,0);
    			sheet1.SetCellValue(row, prefix + "ridr_tp_cd",ComGetObjValue(formObj.ridr_tp_cd),0);
    			if ('B' != ComGetObjValue(formObj.ridr_tp_cd)) {
    				sheet1.SetCellImage(row, prefix + "multiPopup",1);
    			}
    			sheet1.SetCellFontUnderline(row, prefix+"file_nm",1);
    			
			},
			BeforeAddFile : function(result){
//				if(sheet1.GetSelectRow() == -1) return false;
				return true;
			},
			AfterOnload : function() {
		          upload1.SetCustomAddButtonAsID('btn_upload');
			}
		});
    }
	
	/**
	 * ridr_Tp_Change 따른 값얻기 
	 * Radio버튼에 따른 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function fn_ridr_Tp_Change() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		try {
			// 최초 type 값을 setting 
			ComSetObjValue(formObj.ridr_tp_cd, fn_getRadioValue(document.getElementsByName('r_ridr_tp_cd')));
			// select box  강제로 숨기기 
			hiddenSelectForm();
			// 조회시작 
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} catch (ex) {
			bkg_error_alert('fn_ridr_Tp_Change', ex);
			return false;
		}
	}
	/**
	 * Radio 이벤트핸들러 구현
	 * getRadioValue 기본 설정 값얻기
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function fn_getRadioValue(fRadio) {
		try {
			var cnt=fRadio.length;
			if (cnt == 0)
				return;
			for (i=0; i < cnt; i++) {
				if (fRadio[i].checked) {
					return fRadio[i].value;
				}
			}
		} catch (ex) {
			bkg_error_alert('fn_getRadioValue', ex);
			return false;
		}
	}
	/**
	 * Radio 이벤트핸들러 구현
	 * getRadioValue 기본 설정 값얻기
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function fn_setRadioValue(fRadio, _val) {
		try {
			var cnt=fRadio.length;
			if (cnt == 0)
				return;
			for (i=0; i < cnt; i++) {
				if (_val == fRadio[i].value) {
					return fRadio[i].checked=true;
				}
			}
		} catch (ex) {
			bkg_error_alert('fn_setRadioValue', ex);
			return false;
		}
	}
	
	function sheet1_OnMouseMove(){
	    	var row     = sheet1.MouseRow(),
	        col     = sheet1.MouseCol(),
	        info    = null;
	             
	        if (row > 0 &&col == 2) {
	        	prow = row;
	        	info = sheet1.GetCellElement(row, col, 1);
	        	upload1.SetFileUploadElement(info);
	        } 

	    }
	/**
	 * Sheet 조회완료 후 이벤트 발생
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			SetColFontUnderline(prefix + "file_nm",1);
			SetDataLinkMouse(prefix + "file_nm",1);
			SetDataLinkMouse(prefix + "multiPopup",1);
		}
		
		if ('Y' == ComGetObjValue(document.form.disableYn)) {
			ComBtnDisable("btn_upload");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_save");
		}else{
			ComBtnEnable("btn_upload");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_save");
		}
		if('Y' == isInquiry){
			ComBtnDisable("btn_upload");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_save");
		}
	}
	/**
	 * Sheet 저장완료 후 이벤트 발생
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH); //파일링크를 위해 재조회
	}
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		
		if (Col != 2) return;
		if (sheetObj.ColSaveName(Col) == prefix + "file_nm") {
			//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
			if (sheetObj.GetCellText(Row, prefix + "file_nm") == "" || sheetObj.GetRowStatus(Row) == "I") {
				selectFile(sheetObj, Row, Col, false);
				return;
			}
			// 파일이 존재시 다운로드 받는다.
			var key_id=sheetObj.GetCellValue(Row, prefix + "file_sav_id");
			var exist=fnSaveFileExist(key_id , sheetObj);
			// 서버에 파일존재유무확인 
			if(eval(exist)){
				hiddenFrame.location.href="/opuscntr/FileDownload?key=" + key_id;
			}else{
				ComShowMessage(ComGetMsg("BKG08127"));
			}
		}
	}
	 /**
	  * 파일존재유무판단  
	  * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	  * param :file_id
	  * return :boolean
	  */
	 function fnSaveFileExist(file_id,sheetObj) {
	 	var formObj=document.form;
	 	var param="&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	  	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	 	var output_text=ComGetEtcData(sXml, "output_text");
	 	return output_text;
	 }
	/**
	 * 멀티 SELECT 이벤트 DIV Layer창 생성 
	 * 
	 */
	function divLayer_Config() {
		var iframeHTML='apps/opus/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargorider/jsp/ESM_BKG_0207.HTML';
//		var _divWait=document.createElement("<div id='" + BKG_DIV_NAME + "'  name='div01'  style='position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;'/>");
		var _divWait=document.createElement("div");
		
		_divWait.id = BKG_DIV_NAME;
		_divWait.name = "div01";
		_divWait.style.position = "absolute";
		_divWait.style.cursor = "wait";
		_divWait.style.left = "0px";
		_divWait.style.top = "0px";
		_divWait.style.width =" 100px"; //100%였는데 100%로 하면 이상함
		_divWait.style.height = "100px";//100%였는데 100%로 하면 이상함 
		_divWait.style.zIndex = "999"; 
		_divWait.style.visibility = "hidden";
		
//		document.body.insertBefore(_divWait);
		$('body').prepend(_divWait);
		
		//var _frameWait=document.createElement("<IFRAME id='" + BKG_FRAME_NAME + "' name='iframe01' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
		var _frameWait=document.createElement("iframe");
		
		_frameWait.id = BKG_FRAME_NAME;
		_frameWait.name = "iframe01";
		_frameWait.src = iframeHTML;
		_frameWait.frameborder = "1px";
		_frameWait.marginHeight = "0px";
		_frameWait.marginWidth = "0px";
		_frameWait.width = iframeW+"px";
		_frameWait.height = iframeH+"px";
		_frameWait.style.position = "absolute";
		
			
		_divWait.appendChild(_frameWait);
	}
	/**
	 * getMultiSelectCheck  이벤트 발생
	 * 값에 따라서 value값을 체크한다. 
	 */
	function getMultiSelectCheck(_check) {
		try {
			var t_nm=iframe01.document.getElementsByName('t_check');
			var arrRow=_check.split(",");
			for (idx=0; idx < arrRow.length; idx++) {
				for (i=0; i < t_nm.length; i++) {
					if (arrRow[idx] == t_nm[i].value) {
						t_nm[i].checked=true;
					}
				}
			}
		} catch (ex) {
			bkg_error_alert('getMultiSelect(_Check)', ex);
			return false;
		}
	}
	/**
	 * 마우스 다운 이벤트
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	var current_Row=0;
	var current_Equal=false;
	function sheet1_OnMouseDown(Button, Shift, X, Y) {
		var sheetObj=sheetObjects[0];
		var Bkg_div=document.getElementById(BKG_DIV_NAME);
		var Bkg_iframe=document.getElementById(BKG_FRAME_NAME);
		var m_row=sheetObj.MouseRow();
		var m_col=sheetObj.MouseCol();
		try {
			//4번째 컬럼에서만 팝업창 열림 
			if (m_row > 0 && m_col == 5) {
				if (Bkg_div.style.visibility == "hidden") {
					//초기 마우스 클릭 ROW 위치 
					if (sheetObj.MouseRow()== current_Row) {
						current_Equal=true;
					} else {
						current_Row=sheetObj.MouseRow();
					}
					//layer 왼쪽 좌표 
					var gleft=sheetObj.ColLeft(m_col) - 170;
					//layer 위쪽 좌표 
					var gtop=133 + sheetObj.RowTop(m_row) + sheetObj.GetRowHeight(m_row);
					//select box 리스트 다시 렌더링 초기화 
					iframe01.document.getElementById('ContainerList').innerHTML=checkBoxString;
					//보여주기 
					showSelectForm(gtop, gleft);
				} else {
					//감추기 
					hiddenSelectForm();
				}
			} else if (m_row > 0 && m_col == 2) {
				// 파일 다운로드 처리 
			} else {
				//그 이외의 컬럼이 눌리면  팝업 닫기
				hiddenSelectForm();
			}
		} catch (ex) {
			bkg_error_alert('sheet1_OnMouseDown', ex);
			return false;
		}
	}
	/**
	 * 보이기 multiSelectFrame  이벤트 발생
	 * @param topPos    상단 좌표 
	 * @param leftPos    왼쪽 좌표 
	 */
	function showSelectForm(topPos, leftPos) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var Bkg_div=document.getElementById(BKG_DIV_NAME);
		var Bkg_iframe=document.getElementById(BKG_FRAME_NAME);
		if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
			return;
		try {
			if (current_Equal) {
				//포커스 강제설정 
				sheetObj.SelectCell(current_Row, prefix + "cargo_contain", false);
				current_Equal=false;
			}
			Bkg_iframe.style.left=leftPos+"px";
			Bkg_iframe.style.top=topPos+"px";
			if (current_Row < 0)
				current_Row=1;
			// 눌렀을 경우  check 여부 셋팅하기 
			var _check=sheetObj.GetCellText(current_Row, prefix + "dcgo_seq");
			if (typeof _check != null || typeof _check != "undefined" || _check != "") {
				getMultiSelectCheck(_check);
				
			}
			Bkg_div.style.visibility="visible";
			Bkg_iframe.style.visibility="visible";
		} catch (ex) {
			bkg_error_alert('showSelectForm', ex);
			return false;
		}
	}
	/**
	 * 숨기기 multiSelectFrame   이벤트 발생
	 * @param void
	 */
	function hiddenSelectForm() {
		var formObj=document.form;
		var Bkg_div=document.getElementById(BKG_DIV_NAME);
		var Bkg_iframe=document.getElementById(BKG_FRAME_NAME);
		if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
			return;
		try {
			if (Bkg_div.style.visibility == "visible") {
				Bkg_iframe.style.visibility="hidden";
				Bkg_div.style.visibility="hidden";
				// 값 셋팅하기 
				setMultiSelectCheck();
				if (count_checked > 1) {
					sheetObjects[0].SetCellImage(current_Row, prefix + "multiPopup",0);
				} else {
					sheetObjects[0].SetCellImage(current_Row, prefix + "multiPopup",1);
				}
			}
		} catch (ex) {
			bkg_error_alert('hiddenSelectForm', ex);
			return false;
		}
	}
	/**
	 * setMultiSelectCheck  이벤트 발생
	 * 값에 따라서 value값을 구한다. 
	 */
	var count_checked=0;
	function setMultiSelectCheck() {
		try {
			var t_ck=iframe01.document.getElementsByName('t_check');
			var t_nm=iframe01.document.getElementsByName('t_name');
			if (t_nm.length == 0)
				return;
			var r_value='';
			var r_text='';
			var _flag=false;
			count_checked=0;// initial 
			for (i=0; i < t_ck.length; i++) {
				if (t_ck[i].checked) {
					if (!_flag)
						r_text=t_nm[i].value;
					if (_flag)
						r_value += ',';
					r_value += t_ck[i].value;
					_flag=true;
					count_checked++;
				}
			}
			sheetObjects[0].SetCellValue(current_Row, prefix + "dcgo_seq",r_value,0);
			sheetObjects[0].SetCellValue(current_Row, prefix + "cargo_contain",r_text,0);
		} catch (ex) {
			bkg_error_alert('setGetMultiSelect()Check', ex);
			return false;
		}
	}
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {String} 	formObj   
	 * @param {String} 	sAction   
	 * @return {없음}
	 **/
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var aryPrefix=new Array("sheet1_");
		switch (sAction) {
		case IBSEARCH: //조회
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			checkBoxString=''; 
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
			ComSetObjValue(formObj.f_cmd, SEARCH);
			//2.조회조건으로 조회실행
			var sXml=sheetObj.GetSearchData("ESM_BKG_0207GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet1_'));
			//3.조회후 결과처리
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			var _val=ComGetObjValue(formObj.ridr_tp_cd);
			//4.값 존재시 처리 
			if (sheetObj.RowCount()> 0) {
				for ( var row=1; row <= sheetObj.LastRow(); row++) {
					if ('B' != _val) {
						// 이미지 변경하기
						if (sheetObj.GetCellValue(row, prefix + "cargo_cnt") > 1) {
							sheetObj.SetCellImage(row, prefix + "multiPopup",0);
						} else {
							sheetObj.SetCellImage(row, prefix + "multiPopup",1);
						}
					}
					//size 변경하기 
					var size=getSize(sheetObj.GetCellValue(row, prefix + "file_size"));
					sheetObj.SetCellValue(row, prefix + "file_size",size);
					sheetObj.SetRowStatus(row,'R');
				}
			}
			checkBoxString=ComGetEtcData(sXml, "checkBoxString");
			break;
		case IBSAVE: //저장
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			//1.IBSheet 데이터 QueryString으로 묶기
			var sParam=ComGetSaveString(sheetObj);
			if (sParam == "")
				return;
			//0.IBUpload에 파일 추가하기
//			var upObj=uploadObjects[0];
//			upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
//			var paramFile1=setFileUpload(sheetObj, prefix);
			ComSetObjValue(formObj.f_cmd, MULTI);
			if (upload1.GetList().length == 0) {
				/*******파일이 없는 경우 IBSheet 이용하기********/
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				//4. 서버에 request전달하고, reponse 받기
				var sXml=sheetObj.GetSaveData("ESM_BKG_0207GS.do", sParam);
				if (sXml.length > 0)
					sheetObj.LoadSaveData(sXml);
				
			} else {
				/*******파일이 있는 경우 IBUpload 이용하기********/
				//3.Form 데이터 QueryString으로 묶기
				//sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				//3.저장조건으로 저장실행
//				upObj.ExtendParam=sParam; //param값 추가
//				upObj.ParamDecoding=true;
//				var sXml=upObj.DoUpload(true);
				//4.저장후 결과처리
//				if (sXml.length > 0){
//					var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
//					if ( State == "S" ) {	
//						ComShowMessage(ComGetMsg("BKG06071"));
//						sheetObj.LoadSaveData(sXml);
//					} else{
//					}
//				}
//				var sParam=ComGetFileSaveString(sheetObj, upload1, prefix+"file_sav_id");
//		        if (sParam == "") return; //필수 입력 오류 발생시 또는 저장내역 없는 경우
		        sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
		        paramToForm(sParam);
		        upload1.SaveStatus();
//				upload1.RemoveFile();
		       

			}
			break;
		case COMMAND01: // 입력
			var sParam=ComGetSaveString(sheetObj);
			//0.IBUpload에 파일 추가하기
			var upObj=uploadObjects[0];
//			upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
//			var paramFile1=setFileUpload(sheetObj, prefix);
			ComSetObjValue(formObj.f_cmd, MULTI);
			if (upload1.GetList().length == 0) {
				/*******파일이 없는 경우 IBSheet 이용하기********/
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				//4. 서버에 request전달하고, reponse 받기
				var sXml=sheetObj.GetSaveData("ESM_BKG_0207GS.do", sParam);
				if (sXml.length > 0)
					sheetObj.LoadSaveData(sXml);
			} else {
				/*******파일이 있는 경우 IBUpload 이용하기********/
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
//				upObj.ExtendParam=sParam; //param값 추가 
//				upObj.ParamDecoding=true;
//				var sXml=upObj.DoUpload(true);
				//4.저장후 결과처리
//				if (sXml.length > 0){
//					var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
//					if ( State == "S" ) {	
//						ComShowMessage(ComGetMsg("BKG06071"));
//						sheetObj.LoadSaveData(sXml);
//					}else{
//						fnExceptionMessage(sXml);
//					}
//				}
				paramToForm(sParam);
 				upload1.SaveStatus();
			}
			break;
		case IBINSERT: // 입력
			hiddenSelectForm();
			selectFile(sheetObj, sheetObj.RowCount(), '', true);
			break;
		case IBDELETE: // 삭제
			if (sheetObj.FindCheckedRow(prefix + "del_chk") != "") {
				if (!ComShowConfirm(ComGetMsg("BKG00535"))){
					return;
				}
				ComRowHideDelete(sheetObj, prefix + "del_chk");
				doActionIBSheet(sheetObj, document.form, COMMAND01);
			} else {
				ComShowCodeMessage("BKG00249");//"No Selected Row";
			}
			break;
		}
	}
	/**
	 * 용량계산하기  <br>
	 * @param {String} 	_val 		파일용량
	 * @param {String} 	r_value    	MB/KB계산 
	 **/
	function getSize(_val) {
		var r_value=_val;
		var _value=Math.round(_val / 1024);
		if (_value > 0) {
			r_value=_value;
			_value=Math.round(_value / 1024);
			if (_value > 0) {
				_value=_value + " MB"
			} else {
				_value=r_value + " KB"
			}
		} else {
			_value=r_value + " Bytes"
		}
		return _value;
	}
	/**
	 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {String} 	prefix    	변수 구분값
	 **/
	function setFileUpload(sheetObj, prefix) {
		var sRow=sheetObj.FindStatusRow("I");
		var upObj=uploadObjects[0];
		var arrRow=sRow.split(";");
		for (idx=0; idx < arrRow.length - 1; idx++) {
			var row=arrRow[idx];
			//파일 경로 가져오기
			var sFile=sheetObj.GetCellValue(row, prefix + "file_path");
			if (sFile == "")ComShowCodeMessage("BKG00220");
			//IBUpload에 파일 추가하기
			var ret=upObj.AddFile(sFile);
		}
		var param=prefix + "file_cnt=" + (arrRow.length - 1);
		return param;
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * B인경우 검사하지 않는다. 
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			// 저장시 유효성검사 
			if (sAction == IBSAVE) {
				var c_row=sheetObj.LastRow();
				if (c_row == 0) {
					ComShowCodeMessage("BKG00358");//Please select data to save.
					return;
				}
				var _val=ComGetObjValue(formObj.ridr_tp_cd);
				for ( var row=1; row <= c_row; row++) {
					var v_file_nm=sheetObj.GetCellValue(row, prefix + "file_nm");
					if (v_file_nm == '') {
						ComShowMessage(row + "행의 [File Name]은 필수값입니다. ");
						selectFile(sheetObj, sheetObj.RowCount(), '', false);
						return false;
					}
				}
			} else if (sAction == IBSEARCH) {
			}
		}
		return true;
	}
	/**
	 * 파일 선택하기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
	 **/
	function selectFile(sheetObj, Row, Col, _insert) {
		var formObj=document.form;
		if (Col == '' || Col == '2') {
			//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
			var file_nm=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "file_nm");
			
			if(_insert){
				//if (typeof file_nm == "undefined" || file_nm == "File Name" || (file_nm != "" && _insert)) {
					Row=sheetObj.DataInsert(-1, 0);//File Add인 경우 New Row 생성
				//}
			}else{
				var filePath=sheetObj.OpenFileDialog('Please choose target file to upload.');
				if(filePath.indexOf("\\") !=-1) {
					with(sheetObj) {
						SetCellValue(GetSelectRow(), prefix + "file_path",fileName,0);
						fileName=fileName.substr(fileName.lastIndexOf("\\") + 1);
						SetCellValue(GetSelectRow(), prefix + "file_nm",fileName,0);
						SetCellValue(GetSelectRow(), prefix + "ridr_tp_cd",ComGetObjValue(formObj.ridr_tp_cd),0);
						if ('B' != ComGetObjValue(formObj.ridr_tp_cd)) {
							SetCellImage(GetSelectRow(), prefix + "multiPopup",1);
						}
					}
				}
			}
			
			/*if (fileName.indexOf("\\") != -1) {
				sheetObj.SetCellValue(Row, prefix + "file_path",fileName,0);
				fileName=fileName.substr(fileName.lastIndexOf("\\") + 1);
				sheetObj.SetCellValue(Row, prefix + "file_nm",fileName,0);
				sheetObj.SetCellValue(Row, prefix + "ridr_tp_cd",ComGetObjValue(formObj.ridr_tp_cd),0);
				if ('B' != ComGetObjValue(formObj.ridr_tp_cd)) {
					sheetObj.SetCellImage(Row, prefix + "multiPopup",1);
				}
			}*/
		}
	}
	/**
	 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
	 * @param {ibupload} uploadObj    IBUpload Object
	 **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++]=uploadObj;
	}
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Debug alert 
	 */
	function bkg_error_alert(msg, ex) {
		alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
	}
	 /**
	 * fnExceptionMessage 
	 */
	 function fnExceptionMessage(rXml){
		 var rMsg=ComGetEtcData(rXml,"Exception")
	 	var rmsg=rMsg.split("<||>");
	 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
	 		ComShowMessage(rmsg[3]);
	 	}else{
	 		sheetObjects[0].LoadSaveData(rXml);
	 	}
	 }
	/* 개발자 작업  끝 */