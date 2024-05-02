/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_bkg_0793.js
*@FileTitle  : Advice notes _ List Print _ Printing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
// 공통전역변수
var docObjects=new Array();
var sheetCnt=0;
var rdObjects=new Array();
var rdCnt=0;
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
					rdObjects[0].PrintDialog();
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
	function loadPage(vvd, pod, pol, bkg_cust_tp_cd, bkg_sts_cd, rt_teu, rt_feu, rt_hcb, ttl_amt, bl_cnt, bkg_teu, bkg_feu, bkg_hcb, sub_title, sub_title2) {
		rdOpen(vvd, pod, pol, bkg_cust_tp_cd, bkg_sts_cd, rt_teu, rt_feu, rt_hcb, ttl_amt, bl_cnt, bkg_teu, bkg_feu, bkg_hcb, sub_title, sub_title2);
	}
	/**
	 * print화면 오픈
	 * print화면 오픈
	 * print할수 있는 화면 오픈
	 */
	function rdOpen(vvd, pod, pol, bkg_cust_tp_cd, bkg_sts_cd, rt_teu, rt_feu, rt_hcb, ttl_amt, bl_cnt, bkg_teu, bkg_feu, bkg_hcb, sub_title, sub_title2){
		var sXml="";
		if (!opener) opener=parent;
		var opener_obj=opener;
		//var form=opener_obj.document.from;
		var opener_sheet_obj1=opener_obj.sheet1;
		sXml="<?xml version='1.0' ?><SHEET>";
//		sXml +="<SHEET1>";
		sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
//		sXml +="</SHEET1>";
		sXml +="<ETC>" ;
		sXml +="<VVD>"+vvd+"</VVD>"
		sXml +="<POD>"+pod+"</POD>"
		sXml +="<POL>"+pol+"</POL>"
		sXml +="<BKG_CUST_TP_CD>"+bkg_cust_tp_cd+"</BKG_CUST_TP_CD>"
		sXml +="<BKG_STS_CD>"+bkg_sts_cd+"</BKG_STS_CD>"
		sXml +="<RT_TEU>"+rt_teu+"</RT_TEU>"
		sXml +="<RT_FEU>"+rt_feu+"</RT_FEU>"
		sXml +="<RT_HCB>"+rt_hcb+"</RT_HCB>"
		sXml +="<TTL_AMT>"+ttl_amt+"</TTL_AMT>"
		sXml +="<BL_CNT>"+bl_cnt+"</BL_CNT>"
		sXml +="<BKG_TEU>"+bkg_teu+"</BKG_TEU>"
		sXml +="<BKG_FEU>"+bkg_feu+"</BKG_FEU>"
		sXml +="<BKG_HCB>"+bkg_hcb+"</BKG_HCB>"
		sXml +="<SUB_TITLE>"+sub_title+"</SUB_TITLE>"
		sXml +="<SUB_TITLE2>"+sub_title2+"</SUB_TITLE2>"
		sXml +="</ETC>";
		sXml +="</SHEET>";
		rdObjects[0].AutoAdjust=true;
//		rdObjects[0].HideToolBar();
		rdObjects[0].HideStatusBar();
		rdObjects[0].ViewShowMode(0);
		rdObjects[0].SetBackgroundColor(128,128,128);
		rdObjects[0].SetPageLineColor(128,128,128);
		rdObjects[0].SetRData(sXml);
		rdObjects[0].ApplyLicense("0.0.0.0");
		rdObjects[0].FileOpen(RD_path+'apps/opus/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0793.mrd' ,RDServer);
	}