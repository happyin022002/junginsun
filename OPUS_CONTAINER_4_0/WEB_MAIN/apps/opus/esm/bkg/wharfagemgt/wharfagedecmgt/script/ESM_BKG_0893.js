/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0893.js
*@FileTitle  : Wharfage 신고서
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Close":
					ComClosePopup();
					break;
				case "btn_Print":
					viewer.print({isServerSide:true});
					break;
			} // end switch
		}catch(e) {
		}
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(rdData) {
		rdOpen(rdData);
	}
	/**
	 * print화면 오픈
	 * print화면 오픈
	 * print할수 있는 화면 오픈
	 */
	function rdOpen(rdData){
		var xmldata = "<?xml version=\"1.0\" encoding=\"euc-kr\"?><root><startdate>20080101</startdate><enddate>20081231</enddate><today>20090113</today><table1>	<a>		<a1>100 </a1>		<a2> 200</a2>		<a3>300 </a3>		<a4>400 </a4>		<a5>500 </a5>	</a></table1></root>";
		var mrdpath = RD_path+"apps/opus/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0893.mrd" ;
		//viewer.openFile(mrdpath, "/rdata [14.000^0.000^0.000^0.000^0.000^0.000^4.000^0.000^0.000^0.000^0.000^0.000^0.000^4.000^161,280^161,280^17.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^2.222^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^0.000^3.333^ANRBS^AENA0052W^TES_ANRBS^2008-07-20^] /rnl[~]", {timeout:1800});
		viewer.openFile(mrdpath, rdData, {timeout:1800});
	}

