/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_5020.js
*@FileTitle : esm_bkg_5020
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.07 경종윤
* 1.0 Creation
=========================================================*/
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
 * @class esm_bkg_5020 : esm_bkg_5020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_print":
				rdPrint();
				break;
			case "btn_close":
				ComClosePopup();
				break;
			case "entry_type":
				loadPage();
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
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
function loadPage() {
	var formObject=document.form;
	var vvdCd=formObject.vvd_cd.value;
	var polCd=formObject.pol_cd.value;
	var podCd=formObject.pod_cd.value;
	var chk1=formObject.chk1.value;
	var chk2=formObject.chk2.value;
	var chk3=formObject.chk3.value;
	var vslNm=formObject.vsl_nm.value;
	var ofcCd=formObject.ofc_cd.value;
	var entryTp="";
	if(formObject.entry_type[0].checked) {
		entryTp="LC";
	} else if(formObject.entry_type[1].checked) {
		entryTp="TC";
	} else if(formObject.entry_type[2].checked) {
		entryTp="TI";
	}
	var param="/rp [" + vvdCd + "][" + polCd +"][" + podCd +"][" + entryTp + "][" + chk1 + "][" + chk2 + "][" + chk3 + "][" + vslNm + "][" + ofcCd + "]";
	//ComShowMessage(param);
	rdOpen(document.form, param);
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	return true;
}
/*
* RD 오픈  및 미리보기
*/
function rdOpen(formObject, param){
//	RD_path = "http://localhost:9001/opuscntr/"; // TEST용
	var rdParam=param +  " /riprnmargin /rwait";
	ComOpenWait(true);
	viewer.openFile(RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5020.mrd", RDServer+rdParam, {timeout:1800});
	ComOpenWait(false);
}
/**
 * RD 출력
 * @param viewer
 * @return
 */
function rdPrint() {
	viewer.print({isServerSide:true});
}
