/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : ESM_BKG_1501_1.js
*@FileTitle : Advance Cargo Information Download & Transmit
*Open Issues :
*Change history :
*	2017.08.03 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.08.03
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.08.03 하대성
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**
	 * @extends
	 * @class ESM_BKG_1501_1 : ESM_BKG_1501_1 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1501_1() {
		this.processButtonClick = tprocessButtonClick;
		this.loadPage           = loadPage;
		this.frmObj_OnChange    = frmObj_OnChange;
		this.initControl 		= initControl;
	}

/* 개발자 작업 */

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
			var frmObj = document.form;

			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {

				case "btn_del_new_trans":
					if(frmObj.del_cd.value == "") {
						frmObj.del_cd.setAttribute("required", "");
						if(!ComChkValid(frmObj)) return;
					} else if(frmObj.del_cd.value == 5) {
						frmObj.del_reason.setAttribute("required", "");
						if(!ComChkValid(frmObj)) return;
					}
					var obj = new Object();
					obj.del_cd = frmObj.del_cd.value;
					obj.del_reason =  frmObj.del_reason.value; 
					window.returnValue = obj;
					self.close();
		
			        break;
			        
				case "btn1_Close":
					self.close();
					
					break;
			}
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		initControl();
	}

	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		// 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
		// OnChange 이벤트
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}

	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var frmObj = document.form;
	
		var elementName = window.event.srcElement.getAttribute("name");
		with (document.form) {
			switch (elementName) {
				case "del_cd":
					if(del_cd.value == 5) {
						document.getElementById("row1").style.display = "none";
						document.getElementById("row2").style.display = "block";
					} else {
						document.getElementById("row1").style.display = "block";
						document.getElementById("row2").style.display = "none";
					}
					
					break;
			}
		}
	}
	 
/* 개발자 작업 끝 */
