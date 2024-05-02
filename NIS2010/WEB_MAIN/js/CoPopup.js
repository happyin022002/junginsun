/**
===============================================================================
프로그램  명  : 팝업 처리 관련 공통 함수 정의 Script
프로그램개요  : 공통 팝업 표시 관련 함수 정의
작   성   자  : 이경희
작   성   일  : 2008-11
===============================================================================
수정자/수정일 : 
수정사유/내역 : 
===============================================================================
 */

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 팝업 처리 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @class CoPopup : 팝업 처리 관련 함수가 정의한다.
 */
function CoPopup() {
	this.ComOpenWindow = ComOpenWindow;
	this.ComOpenWindowCenter = ComOpenWindowCenter;
	this.ComOpenPopup = ComOpenPopup;
	this.ComOpenPopupWithTarget = ComOpenPopupWithTarget;
	this.ComOpenWindow2 = ComOpenWindow2;
	this.ComPostOpenWindow = ComPostOpenWindow;
	this.ComOpenRDPopup = ComOpenRDPopup;
	this.ComOpenRDPopupModal = ComOpenRDPopupModal;
	this.ComUserPopup = ComUserPopup;
}

/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 리턴팝업에서 사용하는 전역변수
var rtnPopValue = new Array(20);

/**
 * 해당 url을 팝업으로 새창을 열어서 표시하고, 새창에 포커스 설정 후 팝업창 window object 또는
 * window.returnValue를 리턴한다. <br>
 * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택한다. <br>
 * bModal=true인 경우 window.showModalDialog 함수를 이용하고, bModal=false인 경우 window.open
 * 함수를 이용한다. <br>
 * sFeatures 인자의 자세한 설정은
 * {@link http://msdn.microsoft.com/ko-kr/library/ms536651(en-us,VS.85).aspx window.open 도움말}
 * 또는
 * {@link http://msdn.microsoft.com/ko-kr/library/ms536759(en-us,VS.85).aspx window.showModalDialog 도움말}
 * 을 참고한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * ComOpenWindow(
 * 		&quot;ESD_TPB_911.do&quot;,
 * 		&quot;ESD_TPB_911&quot;,
 * 		&quot;toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=755,height=460&quot;);
 * ComOpenWindow(&quot;ESD_TPB_911.do&quot;, null, &quot;width=755,height=460&quot;);
 * pWin = ComOpenWindow(&quot;ESD_TPB_911.do&quot;, null, &quot;width=755,height=460&quot;); //pWin은 팝업창 window object이다.
 * </pre>
 * 
 * @param {string}
 *            sUrl 선택,팝업창의 Url, default="about:blank"
 * @param {string}
 *            sWinName 선택,팝업창의 name 또는 dialogArguments, default=null
 * @param {string}
 *            sFeatures 선택,팝업창의 세부 설정, default=""
 * @param {bool}
 *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
 * @returns object<br>
 *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
 *          리턴값 : 팝업창의 window.returnValue값
 * @see #ComOpenWindow
 */
function ComOpenWindow(sUrl, sWinName, sFeatures, bModal) {
	try {
		if (bModal) {
			return window.showModalDialog(sUrl, window, sFeatures);
		} else {
			// window name에 공백이 들어가면 window.open 함수에 오류가 발생하여 trimAll()함
			var winObj = window.open(sUrl, sWinName.trimAll(), sFeatures);
			if (winObj == null)
				return ComShowMessage("Please confirm Pop-up Blocker Settings and Trusted sites at Internet Options. (Add to allow site: *.hanjin.com)");
			winObj.focus();
			return winObj;
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * {@link #ComOpenWindow} 함수와 동일한 처리와 함께 팝업화면을 화면의 중앙에 활성화 한다. <br>
 * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택한다. <br>
 * bModal=true인 경우 window.showModalDialog 함수를 이용하고, bModal=false인 경우 window.open
 * 함수를 이용한다. <br>
 * 팝업을 표시할 경우 가운데 표시하기위한 width, height, left, top 옵션은 자동으로 설정되고, 그외 다음과 같은 옵션이
 * 설정된다. <br>
 * window.showModalDialog 함수의 옵션 : "scroll:no; status:no; help:no;"<br>
 * window.open 함수의 옵션 : "status=no, resizable=no, scrollbars=no"<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * ComOpenWindowCenter(&quot;ESD_TPB_911.do&quot;, &quot;ESD_TPB_911&quot;, 755, 460);
 * ComOpenWindowCenter(&quot;ESD_TPB_911.do&quot;, null, 755, 460);
 * pWin = ComOpenWindowCenter(&quot;ESD_TPB_911.do&quot;, null, 755, 460); //pWin은 팝업창 window object이다.
 * </pre>
 * 
 * @param {string}
 *            sUrl 선택,팝업창의 Url, default="about:blank"
 * @param {string}
 *            sWinName 선택,팝업창의 name 또는 dialogArguments, default=null
 * @param {string}
 *            iWidth 선택,팝업창의 넓이로 픽셀단위이며 최소100이상 설정
 * @param {string}
 *            iHeight 선택,팝업창의 높이로 픽셀단위이며 최소100이상 설정
 * @param {bool}
 *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
 * @param {String}
 *            sScroll 선택, 스크롤바 생성 여부 (no | yes), default=no
 * @returns object<br>
 *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
 *          리턴값 : 팝업창의 window.returnValue값
 * @see #ComOpenWindow
 */
function ComOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, sScroll) {
	 if (sScroll == undefined || sScroll == null) sScroll = "no";
	 try {
		var leftpos = (screen.width - iWidth) / 2;
		if (leftpos < 0)
			leftpos = 0;
		var toppos = (screen.height - iHeight) / 2;
		if (toppos < 0)
			toppos = 0;

		if (bModal) {
			return ComOpenWindow(sUrl, sWinName,
					"scroll:"+sScroll+";status:no;help:no;dialogWidth:" + iWidth
							+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
							+ leftpos + ";dialogTop:" + toppos, true);
		} else {
			return ComOpenWindow(sUrl, sWinName,
					"status=no, resizable=no, scrollbars="+sScroll+", width=" + iWidth
							+ ", height=" + iHeight + ", left=" + leftpos
							+ ", top=" + toppos);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * 공통 팝업창 호출하고, 팝업창에서 마지막 처리는 부모페이지(opener)의 특정함수를 호출하도록 지정한다. <br>
 * 부모페이지(opener)의 특정함수는 첫번째 인자는 팝업창에서 선택된 데이터의 배열이다. <br>
 * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택하며
 * {@link #ComOpenWindowCenter} 함수를 이용한다. <br>
 * 부모창(opener)의 Sheet의 특정 Cell에서 공통 팝업을 호출하는 경우 iRow, iCol, iSheetIdx 인자를 설정하여
 * 호출한다. <br>
 * 1) iRow, iCol 인자 : 해당 Cell 정보(row, col)로 팝업URL에 "&row=iRow인자값&col=iCol인자값"으로
 * 전달된다. <br>
 * 2) iSheetIdx 인자 : Sheet의 sheetObjects 배열 Index로 팝업URL에
 * "&sheetIdx=iSheetIdx인자값"으로 전달된다. <br>
 * 인자를 설정하면 url에 다음 querystring이 추가되어 조회된다. <br>
 * url?pop_mode=1&display=sDisplay인자값&func=sFunc
 * 인자값&sheet=2&row=iRow인자값&col=iCol인자값&sheetIdx=iSheetIdx인자값 <br>
 * row와 col인자를 설정하여 호출하는 경우 부모페이지(opener)의 특정함수는 첫번째 인자는 팝업창에서 선택된 데이터의 배열이고,
 * 2번째인자는 row, 3번째 인자는 col, 4번째 인자는 sheetIdx이다. <br>
 * <b>Example :</b>
 * 
 * <pre>
 *     //Modaless(일반팝업)로 팝업이 표시되고, 팝업이 닫힐때 부모(opener)의 getVVD 함수를 호출한다.
 *     ComOpenPopup('/hanjin/COM_ENS_0B2.do?sdate=20080901&amp;edate=20081231', 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
 *     function getVVD(aryPopupData)
 *     //부모창(opener)의 sheetObjects[0] Sheet의 Cell(3,10)에서 팝업을 열었다. Modal로 팝업을 표시하고, 팝업이 닫힐때 부모(opener)의 setCntInfoInSheet함수를 호출한다.
 *     ComOpenPopup('/hanjin/COM_ENS_0M1.do?cnt_cd=123&amp;classId=cls', 565, 480, 'setCntInfoInSheet', &quot;1,0,1,1,1,1,1&quot;, true, false, 3, 10, 0);
 *     function setCntInfoInSheet(aryPopupData, row, col, sheetIdx)
 * </pre>
 * 
 * @param {string}
 *            sUrl 필수,호출될 팝업 주소
 * @param {int}
 *            iWidth 필수,팝업 창의 넓이
 * @param {int}
 *            iHeight 필수,팝업 창의 높이
 * @param {string}
 *            sFunc 필수,팝업에서 최종 확인을 했을때 데이터를 받을 부모창(opener)의 자바스크립트 함수명
 * @param {string}
 *            sDisplay 필수,팝업창에 있는 그리드의 컬럼 히든여부 설정(1:보임, 0:숨김)
 * @param {bool}
 *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
 * @param {bool}
 *            b2ndSheet 선택,Sheet 2개인 팝업 오픈시 true 1개인 팝업 오픈시 false, default=false
 * @param {int}
 *            iRow 선택,Sheet의 Cell의 Row Index
 * @param {int}
 *            iCol 선택,Sheet의 Cell의 Col Index
 * @param {int}
 *            iSheetIdx 선택,Sheet의 sheetObjects 배열 Index
 * @param {string}
 *            sWinName 선택,팝업창의 name 또는 dialogArguments, default=compopup
 * @param {String}
 *            sScroll 선택, 스크롤바 생성 여부 (no | yes), default=no
 * @returns object<br>
 *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
 *          리턴값 : 팝업창의 window.returnValue값
 * @see #ComOpenWindowCenter
 * @see #ComOpenPopupWithTarget
 */
function ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal,
		b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll) {
	try {
		// sDisplay인자값의 Validation을 체크한다.
		if (!chkDisplayStr(sDisplay, "ComOpenPopup"))
			return;

		if (bModal == undefined || bModal == null)
			bModal = false;
		if (b2ndSheet == undefined || b2ndSheet == null)
			b2ndSheet = false;
		if (sWinName == undefined || sWinName == null)
			sWinName = "compopup";
		if (sScroll == undefined || sScroll == null) 
			 sScroll = "no";

		var pop_mode = "1"; // 1은 function 호출형, 2는 target 세팅형
		sUrl += ((sUrl.indexOf("?") == -1) ? "?" : "&") + "pop_mode="
				+ pop_mode + "&display=" + sDisplay + "&func=" + sFunc;

		// Sheet 2개인 팝업 오픈시
		if (b2ndSheet)
			sUrl += "&sheet=2";

		// 부모창(opener)의 Sheet의 특정 Cell에서 공통 팝업을 호출하는 경우
		if (iRow != undefined && iRow != null && iRow != undefined
				&& iRow != null) {
			// 1) Sheet 의 셀 정보를 전달한다.
			sUrl += "&row=" + iRow + "&col=" + iCol;

			// 2) Sheet의 sheetObjects 배열 Index
			if (iSheetIdx != undefined && iSheetIdx != null)
				sUrl += "&sheetIdx=" + iSheetIdx;
		}

		return ComOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, sScroll);

	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * 공통 팝업창 호출하고, 팝업창에서 마지막 처리는 부모창(opener)의 Target Object를 지정해 줌으로서 팝업창에서 처리를 하도록
 * 한다. <br>
 * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택하며
 * {@link #ComOpenWindowCenter} 함수를 이용한다. <br>
 * sTargetObjList는 팝업창의 데이터를 받을 부모창의 Object명을 의미하며 다음과 같이 "|"구분과 ":"구분의 문자열로
 * 구성한다. <br>
 * 예) "popupval1:txtData1|popupval2:txtData2|popupval3:cboData1" <br>
 * 인자를 설정하면 url에 다음 querystring이 추가되어 조회된다. <br>
 * url?pop_mode=2&display=sDisplay인자값&targetObjList=sTargetObjList 인자값 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * //Modal로 팝업이 표시되고, 완료 시 팝업창은 부모(opener)의 opener.sltStatus=loc_dpth_cd를 설정하고, opener.txtLocation=loc_cd를 설정한다.
 * ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do?depth=3&amp;classId=COM_ENS_0O1',
 * 		400, 500, &quot;loc_dpth_cd:sltStatus|loc_cd:txtLocation&quot;, &quot;0,1&quot;, true);
 * </pre>
 * 
 * @param {string}
 *            sUrl 필수,호출될 팝업 주소
 * @param {int}
 *            iWidth 필수,팝업 창의 넓이
 * @param {int}
 *            iHeight 필수,팝업 창의 높이
 * @param {string}
 *            sTargetObjList 필수,팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 Object명(Input 또는
 *            Combo 등)
 * @param {string}
 *            sDisplay 필수,팝업창에 있는 그리드의 컬럼 히든여부 설정(1:보임, 0:숨김)
 * @param {bool}
 *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
 * @param {String}
 *            sScroll 선택, 스크롤바 생성 여부 (no | yes), default=no
 * @returns object<br>
 *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
 *          리턴값 : 팝업창의 window.returnValue값
 * @see #ComOpenWindowCenter
 * @see #ComOpenPopup
 */
function ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList,
		sDisplay, bModal, sScroll) {
	try {
		// sDisplay인자값의 Validation을 체크한다.
		if (!chkDisplayStr(sDisplay, "ComOpenPopupWithTarget"))
			return;

		if (bModal == undefined || bModal == null)
			bModal = false;
		if (sScroll == undefined || sScroll == null) 
			 sScroll = "no";

		var pop_mode = "2"; // 1은 function 호출형, 2는 target 세팅형
		sUrl += ((sUrl.indexOf("?") == -1) ? "?" : "&") + "pop_mode="
				+ pop_mode + "&display=" + sDisplay + "&targetObjList="
				+ sTargetObjList;

		return ComOpenWindowCenter(sUrl, 'compopup', iWidth, iHeight, bModal, sScroll);

	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * {@link #ComOpenPopup}함수와 {@link #ComOpenPopupWithTarget}함수의 Display인자값이
 * 정확한지 여부를 확인하여 반환한다. <br>
 * 이 함수는 이 파일(CoPopup.js)에서만 사용하기 위한 목적으로 만들졌다.
 */
function chkDisplayStr(sDisplay, sFucnName) {
	try {
		var sMsgTitle = "[" + sFucnName + " Error] ";

		if (sDisplay != "none") {
			if (sDisplay.length >= 3) {
				var chkStr = sDisplay.substring(0, 3);
				if (chkStr != "0,0" && chkStr != "0,1" && chkStr != "1,0") {
					alert(sMsgTitle
						       + "Information to open a Popup is wrong  \n\n"
						       + "Example) A front of three word of Parameter must be '0.0','0.1','1.0'."); 
					return false;
				}
			} else {
				alert(sMsgTitle + "Information of Display Parameter is insufficient to open Popup.");  
				return false;
			}
		}

		return true;
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * {@link #ComOpenWindow} 함수와 동일하지만 return으로 window Object를 반환하지 않는다.
 */
function ComOpenWindow2(sUrl, sWinName, sFeatures) {
	try {
		var winObj = ComOpenWindow(sUrl, sWinName, sFeatures);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * Post 방식으로 PopUp을 연다.
 * 
 * @param sUrl
 * @param sWinName
 * @param sHeight
 */
function ComPostOpenWindow(sUrl, sWinName, sFeatures) {
	window.open("", sWinName, sFeatures);
	document.form.action = sUrl;
	document.form.target = sWinName;
	document.form.method = "post";
	document.form.submit();
}

 /**
  * Post 방식으로 RD Popup을 띄운다. Popup창의 Size 조절 가능
  * @param sFeatures
  */
 function ComOpenRDPopup(sFeatures) {
	if(sFeatures == undefined){
	 	ComPostOpenWindow("/hanjin/COM_RD_COMMON_POPUP.do", "ReportDesignerCommonPopup", "width=1010, height=660, status=no");
	} else{
		ComPostOpenWindow("/hanjin/COM_RD_COMMON_POPUP.do", "ReportDesignerCommonPopup", sFeatures);
	}
 }
   
   /**
    * Post 방식으로 RD Modal Popup을 띄운다. Popup창의 Size 조절 가능
    * @param sFeatures
    */
   function ComOpenRDPopupModal(sFeatures) {
		if(sFeatures == undefined){
		  	window.showModalDialog("/hanjin/syscommon/common/reportdesigner/commonpopup/jsp/COM_RD_COMMON_POPUP_MODAL.jsp", window, "dialogWidth:750px;dialogHeight:690px;status:no");
		} else{
			window.showModalDialog("/hanjin/syscommon/common/reportdesigner/commonpopup/jsp/COM_RD_COMMON_POPUP_MODAL.jsp", window, sFeatures);
		}
   }

 /**
 * 
 * @param sUserId
 */
  
  	function ComUserPopup(sUserId) {
  		ComOpenWindowCenter("/hanjin/UserInfo.do?usr_id="+sUserId+"&f_cmd=104", "UserInfo", "500", "330", true);
	}
