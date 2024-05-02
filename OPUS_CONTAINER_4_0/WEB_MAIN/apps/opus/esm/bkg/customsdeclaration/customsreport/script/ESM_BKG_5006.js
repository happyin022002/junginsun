/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_5006.jsp
*@FileTitle  : Container Loading List(KOREA)_Print Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
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
     * @class esm_bkg_0881 : esm_bkg_0881 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_5006() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    }
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject1=sheetObjects[0];
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
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage(vvd, pol, etd) {
        	rdOpen();
     }
	/*
	* RD 오픈  및 미리보기
	*/
	function rdOpen(){
		var sXml="";		
		var opener_obj=opener;
		var form1=opener_obj.document.form;
		var opener_sheet_obj1=opener_obj.sheet1;
		sXml="<?xml version='1.0' ?><SHEET>";
		sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
		sXml +="\n<ETC>" ;
		sXml +="<VVD>"+form1.vvd_cd_nm.value+"</VVD>";
		sXml +="<POL>"+form1.pol_cd_print.value+"</POL>";
		sXml +="<ETD>"+form1.vps_etd.value+"</ETD>";
		sXml +="</ETC>";
		sXml +="</SHEET>";
		viewer.setRData(sXml);
		var urlPath=RD_path+'apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5006.mrd';
		//urlPath = "http://localhost:9001/opuscntr/apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5006.mrd";
		viewer.openFile(urlPath ,RDServer, {timeout:1800});
	}
	/**
	 * RD 출력
	 * @param rdObject
	 * @return
	 */
	function rdPrint() {
		viewer.print({isServerSide:true});
	}
