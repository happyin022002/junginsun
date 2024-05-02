/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_5001.js
*@FileTitle  : Revenue Debit Note
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
//공통전역변수
//var rdObjects = new Array();
var rdCnt = 0;
var rd1;

/** 
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.12
*/ 
function loadPage() {
    var form = document.form;
    rd1 = viewer;	
    
//    initRdConfig(rd1);	

    //rdOpen(rd1, form);
    rdOpen();
}

/** 
* Rd 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* Rd가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {RD} rdObject : 시트오브젝트
* @return 없음
* @see #
* @author 김대호
. @version 2009.10,12
*/ 
//function initRdConfig(rdObject) {
//
//	rd1.AutoAdjust = true;
//	rd1.HideStatusBar();
//	rd1.ViewShowMode(0); 
////	rd1.ApplyLicense("0.0.0.0");
//	rd1.SetBackgroundColor(128,128,128);
//	rd1.SetPageLineColor(128,128,128);
//	
//}

//===================================================================================
//버튼 이벤트 처리
//===================================================================================
document.onclick = processButtonClick;

/** 
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.12
*/ 
function processButtonClick(){
	var form=document.form;
	try {
	    var srcName=ComGetEvent("name");
	    switch(srcName) {
			case "btn_Close":
				ComClosePopup(); 
				break;
			case "btn_Print":					
				rd1.print({isServerSide:true});
				break;
	    } //end switch
  }catch(e) {
  	if( e == "[object Error]") {
  		ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/** 
* rd 조회 기능을 호출하는 rdOpen <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.12
*/ 
function rdOpen() {
	
	// 로컬 폼
	var form = document.form;
	
	/* 기본 : ESM_BKG_0426 */
	var progId  = form.prog_id.value;

	// opener
	var opener_obj = opener;
	var opener_form;
	var opener_sheet_obj1;
	
	var rndNo        = "";
	var blNo         = "";
	var issOfcCd     = "";
	var rdnStsNm     = "";
	var rdnIssDt     = "";
	var stsUpdDt     = "";
	var rctRhqCd     = "";
	var rctOfcCd     = "";
	var respbRhqCd   = "";
	var respbOfcCd   = "";
	var umchTpCd     = "";
	var umchSubTpCd  = "";
	var rdnIssRsnCd  = "";
	var umchRmk      = "";
	var revAudToolCd = "";
	var scRfaNo      = "";
	var bkgCorrNo    = "";
	var rdnRmk       = "";
	var receiverRmk  = "";
	var usdAmdSum    = 0.00;
	
	if(progId == "ESM_BKG_0426") {
		
		opener_form = opener_obj.form;
		opener_sheet_obj1 = opener_obj.sheet1;
		
		rndNo        = opener_obj.rdn_no_cd.GetSelectText();
		blNo         = opener_form.bl_no.value;
		issOfcCd     = opener_form.iss_ofc_cd.value;
		rdnStsNm     = opener_form.rdn_sts_nm.value;
		rdnIssDt     = opener_form.rdn_iss_dt.value;
		stsUpdDt     = opener_form.sts_upd_dt.value;
		rctRhqCd     = opener_obj.rct_rhq_cd.GetSelectText();
		rctOfcCd     = opener_obj.rct_ofc_cd.GetSelectText();
		respbRhqCd   = opener_obj.respb_rhq_cd.GetSelectText();
		respbOfcCd   = opener_obj.respb_ofc_cd.GetSelectText();
		umchTpCd     = opener_obj.umch_tp_cd.GetSelectText();
		umchSubTpCd  = opener_obj.umch_sub_tp_cd.GetSelectText();
		rdnIssRsnCd  = opener_obj.rdn_iss_rsn_cd.GetSelectText();
		umchRmk      = opener_form.umch_rmk.value;
		revAudToolCd = opener_obj.rev_aud_tool_cd.GetSelectText();
		scRfaNo      = opener_form.sc_rfa_no.value;
		bkgCorrNo    = opener_form.bkg_corr_no.value;
		rdnRmk       = opener_form.rdn_rmk.value;      // textarea
		receiverRmk  = opener_form.receiver_rmk.value; // textarea
		
		usdAmdSum    = opener_sheet_obj1.GetSumValue(0, "usd_amount"); 
		
	} else if (progId == "ESM_BKG_0712") {
		
		opener_form = opener_obj.form;
		opener_sheet_obj1 = opener_obj.sheet1;
		
		rndNo        = opener_obj.rdn_no_cd.GetSelectText();
		blNo         = opener_form.bl_no.value;
		issOfcCd     = opener_form.iss_ofc_cd.value;
		rdnStsNm     = opener_form.rdn_sts_nm.value;
		rdnIssDt     = opener_form.rdn_iss_dt.value;
		stsUpdDt     = opener_form.sts_upd_dt.value;
		rctRhqCd     = opener_form.rct_rhq_cd.value;
		rctOfcCd     = opener_form.rct_ofc_cd.value;
		respbRhqCd   = opener_form.respb_rhq_cd.value;
		respbOfcCd   = opener_form.respb_ofc_cd.value;
		umchTpCd     = opener_form.umch_tp_cd.value;
		umchSubTpCd  = opener_form.umch_sub_tp_cd.value;
		rdnIssRsnCd  = opener_form.rdn_iss_rsn_cd.value;
		umchRmk      = opener_form.umch_rmk.value;
		revAudToolCd = opener_form.rev_aud_tool_cd.value;
		scRfaNo      = opener_form.sc_rfa_no.value;
		bkgCorrNo    = opener_form.bkg_corr_no.value;
		rdnRmk       = opener_form.rdn_rmk.value;      // textarea
		receiverRmk  = opener_form.receiver_rmk.value; // textarea
		
		usdAmdSum    = opener_sheet_obj1.GetSumValue(0, "usd_amount"); 

	} else {
		ComClosePopup();
	}
	
	//sXml +="<SHEET1>";
	//sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
	//sXml +="</SHEET1>";
	var tableXml = "";
	var startRow = opener_sheet_obj1.HeaderRows();
	//var endRow = opener_sheet_obj1.HeaderRows + opener_sheet_obj1.RowCount;
	var endRow = opener_sheet_obj1.HeaderRows() + opener_sheet_obj1.GetTotalRows();

	for(var i = startRow; i < endRow; i++ ) {
		tableXml += "<TR>";		
		
		tableXml += "    <curr_cd><![CDATA["    + opener_sheet_obj1.GetCellValue(i, "curr_cd")                              + "]]></curr_cd>";
		
		tableXml += "    <dr_amt><![CDATA["     + opener_sheet_obj1.GetCellValue(i, "dr_amt")     + "]]></dr_amt>";
		tableXml += "    <usd_amount><![CDATA[" + opener_sheet_obj1.GetCellValue(i, "usd_amount") + "]]></usd_amount>";

		tableXml += "</TR>";
	}
	/*
	for(var ii = 0; ii < 5; ii++ ) {
		tableXml += "<TR>";		
		tableXml += "<curr_cd><![CDATA["    + ii + "_curr_cd" + "]]></curr_cd>";
		var tmpDrAmt = ii;
		var tmpUsdAmt = ii + 10;
		//tableXml += "<dr_amt><![CDATA["     + ComAddComma2(""+tmpDrAmt, "#,###.00")     + "]]></dr_amt>";
		//tableXml += "<usd_amount><![CDATA[" + ComAddComma2(""+tmpUsdAmt, "#,###.00") + "]]></usd_amount>";
		tableXml += "<dr_amt><![CDATA["     + tmpDrAmt + "]]></dr_amt>";
		tableXml += "<usd_amount><![CDATA[" + tmpUsdAmt + "]]></usd_amount>";
		tableXml += "</TR>";
	}
	*/
	var sXml = "";
	var kindSpace = "    ";
	var descrepanceKind = umchTpCd + kindSpace + umchSubTpCd + kindSpace + rdnIssRsnCd;
	
	sXml = "<?xml version='1.0' encoding='UTF-8'?>";
	sXml += "<SHEET>";

	sXml += "<SHEET1>";
	sXml += "	<DATA TOTAL='" + opener_sheet_obj1.TotalRows + "'>";
	
	sXml += tableXml;
	
	sXml += "	</DATA>";
	//sXml += "   <usd_amt_sum>"       + usdAmdSum        + "</usd_amt_sum>";	
	sXml += "</SHEET1>";

	sXml += "<ETC>";
	sXml += "    <RNDNO>"            + rndNo            + "</RNDNO>";                
	sXml += "    <BLNO>"             + blNo             + "</BLNO>";                
	sXml += "    <ISSOFCCD>"         + issOfcCd         + "</ISSOFCCD>";                
	sXml += "    <RDNSTSNM>"         + rdnStsNm         + "</RDNSTSNM>";                
	sXml += "    <RDNISSDT>"         + rdnIssDt         + "</RDNISSDT>";                
	sXml += "    <STSUPDDT>"         + stsUpdDt         + "</STSUPDDT>";                
	sXml += "    <RCTRHQCD>"         + rctRhqCd         + "</RCTRHQCD>";                
	sXml += "    <RCTOFCCD>"         + rctOfcCd         + "</RCTOFCCD>";                
	sXml += "    <RESPBRHQCD>"       + respbRhqCd       + "</RESPBRHQCD>";                
	sXml += "    <RESPBOFCCD>"       + respbOfcCd       + "</RESPBOFCCD>";
	// ------------------------------------------------------------ //
	sXml += "    <UMCHTPCD>"         + umchTpCd         + "</UMCHTPCD>";                
	sXml += "    <UMCHSUBTPCD>"      + umchSubTpCd      + "</UMCHSUBTPCD>";                
	sXml += "    <RDNISSRSNCD>"      + rdnIssRsnCd      + "</RDNISSRSNCD>";
	sXml += "    <DESCREPANCE_KIND>" + descrepanceKind  + "</DESCREPANCE_KIND>";
	// ------------------------------------------------------------ //	
	sXml += "    <UMCHRMK>"          + umchRmk          + "</UMCHRMK>";                
	sXml += "    <REVAUDTOOLCD>"     + revAudToolCd     + "</REVAUDTOOLCD>";                
	sXml += "    <SCRFANO>"          + scRfaNo          + "</SCRFANO>";                
	sXml += "    <BKGCORRNO>"        + bkgCorrNo        + "</BKGCORRNO>";                
	sXml += "    <RDNRMK><![CDATA["  + rdnRmk           + "]]></RDNRMK>";                
	sXml += "    <RECEIVERMK>"       + receiverRmk      + "</RECEIVERMK>";
	sXml += "</ETC>";
	
	sXml += "</SHEET>";
	
//	rd1.ApplyLicense("0.0.0.0");
	rd1.setRData(sXml);
	var rv=" /rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";
	
	var urlPath = RD_path + 'apps/opus/esm/bkg/revenueaudit/revenuedebitnote/report/ESM_BKG_5001.mrd';
	
	rd1.openFile(urlPath ,RDServer+rv);
	
}