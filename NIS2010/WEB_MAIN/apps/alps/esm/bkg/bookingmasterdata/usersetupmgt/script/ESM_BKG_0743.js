/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0743.js
*@FileTitle : B/L Print Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
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
     * @author 한진해운
     * @extends 
     * @class esm_bkg_0743  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0743() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";
 
 var prefix = "sheet1_";//IBSheet 구분자

 var firstYn = false;
 
var obl_iss_knt = 1; //Original B/L  프린트 매수 조회 후 저장

var bl_tp_cd = ""; // B/L type
var hblTp = ""; // hB/L type
var obl_iss_flg = ""; // B/L의 issued
var obl_prn_flg = ""; // O.B/L Y여부
var bb_cgo_flg  = ""; // Break Bulk 정보
var bl_cpy_knt = ""; // Original B/L일 경우 저장된 인쇄 매수를 세팅하기 위함.

var pre_form_type  = ""; // 이전에 선택했던 B/L 타입 (선택 불가 B/L type일 경우 이전 B/L type으로 세팅한다.)
var pre_container_type  = ""; // 이전에 선택했던 Container 타입 (선택 불가 Container type일 경우 이전 Container type으로 세팅한다.)
 
var org_ppd_rcv_cd    = ""; //print and release 릴리스시 체크 
var org_n3pty_ppd_cd  = ""; //print and release 릴리스시 체크
var print_release_yn  = ""; //print and release 릴리스시 체크

var save_face_print_cnt =""; // obl을 위한 용도 : 저장된 프린트 face 매수 
var save_rider_print_cnt ="";// obl을 위한 용도 : 저장된 프린트 rider 매수
   /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	
	
/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
 	    initComboEditable(comboObj)
 	}
 	 
 	 function initComboEditable(combo){
	 	 	with (combo) {
	 	 		MultiSelect = false;
		 	  UseEdit = false;
		 	  DropHeight = 200;
		 	   
	 	 	}
 	 }
 	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }

		 //MultiCombo초기화 
 	    for(var k=0;k<comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
 	    
			for(i=0;i<rdObjects.length;i++){
				initRdConfig(rdObjects[i],i+1);
			}
	
		    initControl();
			firstYn = false;
			
			initPrintList();
			
		  doActionIBSheet(sheetObjects[0],form,IBSEARCH);
		  
		  Retrive(sheetObjects[0]);
     }

    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

		axon_event.addListenerForm('click',         'obj_click', 	form);
		axon_event.addListenerForm('change',         'obj_change', 	form);
    }
  var strPrintList ="";
  var defaultPrint ="";

  function initPrintList(){
	
  	strPrintList = Rdviewer.GetLocalInfo("PrnNames", "");
	  defaultPrint = Rdviewer.GetLocalInfo("DefaultPrnName", "");
  	//alert(defaultPrint);
  	if(strPrintList == undefined || strPrintList == null || strPrintList == "") return;
  	
		var arrPrintList = strPrintList.split("|");
		
  	printListXml  = " <SHEET> \n";
		printListXml += " <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='"+(arrPrintList.length-1)+"'> \n";
		
		for(var i = 0; i < arrPrintList.length-1; i++) {
			printListXml += " 	<TR><![CDATA["+arrPrintList[i]+"]]></TR> \n";
		}		
		printListXml += " </DATA> \n";
		printListXml += " </SHEET> ";
		ComXml2ComboItem(printListXml, form.bl_face_prn_dvc_nm, "val", "val");
		ComXml2ComboItem(printListXml, form.bl_ridr_prn_dvc_nm, "val", "val");
  }
  
  /**
   * 프린트 목록과 저장된 프린트 목록을 확인한다. (확인하여 없으면 기본프린터로 설정하기 위함) 
   * */
  function checkPrintList(val){
		var arrPrintList = strPrintList.split("|");

		for(var i = 0; i < arrPrintList.length-1; i++) {
			if(val == arrPrintList[i]) return true;
		}
		
		return false;
  }
    
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);

		Rdviewer.style.height = 0;
	}


	function obj_click() {
		var formObject = document.form;
		var obj = event.srcElement;

		switch(obj.name){

			case "hiddenData": // hiddenData
				//alert(obj.name + "\n\n" + obj.value);
				Retrive(sheetObjects[0]);
				break;

			case "bl_ca_yn": // bl_ca_yn
				//alert(obj.name + "\n\n" + obj.value);
				if ( obj.checked == false ) {
					formObject.corr_no.value = "";
					formObject.ca_no.Code = "";
				}
				Retrive(sheetObjects[0]);
				break;
		}
	}

	function Retrive(sheetObject) {
		//
		var formObject = document.form;

		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0],form,SEARCH01);
		sheetObjects[0].RemoveAll()
		ComOpenWait(false);
	}

	function rdStart() {
		//
		var formObject = document.form;

		var strBkgNo = formObject.bkg_no.value;

		var FaceYn = "Y";
		var RiderYn = "";
		var HBYn = "";

		if (strBkgNo.length == 0) {
			ComShowCodeMessage('BKG00626','BKG No.');
			return;
		}

		// Original B/L
		// B/L Release가 되어있으면 Error
		if ( formObject.form_type.value == 4 && formObject.obl_rlse_flg.value == "Y" ) {
			ComShowCodeMessage('BKG08098');
			return;
		}

		if ( formObject.rider_only_yn.checked ) {
			RiderYn = "Y";
		}

		if ( formObject.nvocc_only_yn.checked ) {
			HBYn = "Y";
		}

		if ( formObject.rider_nvocc_yn.checked ) {
			RiderYn = "";
			HBYn = "Y";
		}
		
		rdOpen(formObject, RiderYn, HBYn);
	}

	function rdOpen(formObject, RiderYn, HBYn){
		
		var Rdviewer_Face = rdObjects[0];
		var Rdviewer_Rider = rdObjects[1];
		var Rdviewer_Hb = rdObjects[2];

		//ComOpenWait(true);

		var RiderPrintYn = false;

		var rdParam_Face = "";
		var rdParam_Rider = "";
		var rdParam_Hb = "";

		var strFacePath = "";
		var strRiderPath = "";
		var strHbPath = "";

		var bkgNo = formObject.bkg_no.value; // bkg_no
		var formType = formObject.form_type.Code; // form_type
		var formDataOnly = formObject.preview_yn.checked == true ? "N" : "Y"; // Preview
		var formManifest = formObject.form_manifest.value; // form_manifest
		var formUserId = formObject.usr_id.value; // form_usrId
		var formHiddenData = formObject.hiddenData.checked == true ? "Y" : "N"; // form_hiddeData
		var formOfcCd = formObject.ofc_cd.value; // ofc_cd
//		var formMargin = formObject.bl_prn_mgn_val.value;//bl_prn_mgn_val
		var formMargin = formObject.bl_prn_mgn_val.options[formObject.bl_prn_mgn_val.selectedIndex].text;//bl_prn_mgn_val
		var formMarginB = (formMargin *10) + 25;

		// ComReplaceStr(formObject.form_remark.value, "\r\n", "[##]")
		var formRemark = ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)"); // form_remark
		formRemark = ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(formRemark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");

		var formRate = formObject.form_Rate.Code; // form_Rate
		var formCntr = formObject.form_Cntr.Code; // form_Cntr
		//var formMainOnly = (formObject.rider_only_yn.disabled == false|| formObject.rider_nvocc_yn.disabled == false) ? "N" : "Y"; // form_mainOnly
		var formMainOnly = "Y"; // form_mainOnly -- Face와 Rider가 다른 프린트에서 출력이 되야 하므로 각자 따로 구별하여 처리한다.
		var formCorrNo = formObject.bl_ca_yn.checked == true ? formObject.ca_no.Code : ""; // form_CorrNo

		var formHisCntr = formObject.bl_ca_yn.checked == true ? "BKG_CNTR_HIS" : "BKG_CONTAINER"; // form_his_cntr
		var formHisBkg = formObject.bl_ca_yn.checked == true ? "BKG_BKG_HIS" : "BKG_BOOKING"; // form_his_bkg
		var formHisMkd = formObject.bl_ca_yn.checked == true ? "BKG_BL_MK_DESC_HIS" : "BKG_BL_MK_DESC"; // form_his_mkd
		var formHisXpt = formObject.bl_ca_yn.checked == true ? "BKG_XPT_IMP_LIC_HIS" : "BKG_XPT_IMP_LIC"; // form_his_xpt
		var formHisBl = formObject.bl_ca_yn.checked == true ? "BKG_BL_DOC_HIS" : "BKG_BL_DOC"; // form_his_bl

		var formCaYn = formObject.bl_ca_yn.checked == true ? "Y" : ""; // form_caYn

		var Face_PrnDrv = formObject.bl_face_prn_dvc_nm.Code; // Print Setup (Face)
		var Face_PrnCnt = formObject.face_print_cnt.value; // Print Count (Face)
		var Rider_PrnDrv = formObject.bl_ridr_prn_dvc_nm.Code; // Print Setup (Rider)
		var Rider_PrnCnt = formObject.rider_print_cnt.value; // Print Count (Rider)

		// Face
		if(getRadioValue2(form.paper_type) == '1'){
			strFacePath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
		}else if(getRadioValue2(form.paper_type) == '4'){
			strFacePath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
		}else if(getRadioValue2(form.paper_type) == '10'){
			strFacePath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_DOT.mrd";
		}
		if(getRadioValue2(form.paper_type) == '1' && formType == '7'){
			strFacePath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_FBL_A4.mrd";
		}

		//BOMSC, DELSO, MAASO 의 경우 2.5mm 아래로 출력위치 조정
		if(formOfcCd == "BOMSC" || formOfcCd == "DELSO" || formOfcCd == "MAASO") {
			if(formMargin == "0"){
				rdParam_Face += " /rpypos [25]";
	    	 }else{ 
	    		 rdParam_Face += " /rpypos [" + formMarginB + "]"  ;
	    	 }
		} else{
	     if(formMargin == "0"){
	    	     rdParam_Face += " /rpypos [0]";	
	    	 }else{ 
	    		 rdParam_Face += " /rpypos [" + formMargin *10 + " ]"  ;
	    	 }
		}
		
		if((formType == '4' || formType == '1') && obl_prn_flg == 'Y'){
			ComShowCodeMessage('BKG95132');
			return;
		}
		
		var serNo = '';
		if(formType == '4' || formType == '1'){
			var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", 'f_cmd=' + SEARCH23 + '&bkg_no=' + bkgNo);
			serNo = ComGetEtcData(sXml, "serNo");
		}
		
		for (var i = 0; i < Face_PrnCnt; i++) {
			rdParam_Face = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
			rdParam_Face += "form_type[" + formType + "] "; // form_type
			rdParam_Face += "form_dataOnly[" + formDataOnly + "] "; // form_dataOnly
			rdParam_Face += "form_manifest[" + formManifest + "] "; // form_manifest
			rdParam_Face += "form_usrId[" + formUserId + "] "; // form_usrId
			rdParam_Face += "form_mainOnly[" + formMainOnly + "] "; // form_mainOnly
			rdParam_Face += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
			rdParam_Face += "form_level[(" + formRate + ")] "; // form_level
			rdParam_Face += "form_remark[" + formRemark + "] "; // form_remark
			rdParam_Face += "form_Cntr[" + formCntr + "] "; // form_Cntr
			rdParam_Face += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
			rdParam_Face += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
			rdParam_Face += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
			rdParam_Face += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
			rdParam_Face += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
			rdParam_Face += "form_his_bl[" + formHisBl + "] "; // form_his_bl
			if(serNo != '')
				rdParam_Face += "form_serial[" + serNo + (i+1) + "] "; // form_his_bl
			rdParam_Face += "/rp [" + formCaYn + "] "; // form_caYn
			rdParam_Face += "/riprnmargin /rmatchprndrv [3]";	
			
			Rdviewer_Face.SetMessageboxShow(1); //에러메시지만 출력함
			Rdviewer_Face.FileOpen(strFacePath, RDServer + rdParam_Face);
			// Face
			// 프린터 드라이버 이름 : Face_PrnDrv
			// 인쇄매수 : Face_PrnCnt
			// 한부씩인쇄 : 1
			// 인쇄시 뜨는 대화상자 모두 숨김 : 4
			// Rdviewer_main.SetPrintInfo (프린터 드라이버 이름, 인쇄매수, 1-한부씩 인쇄, 2-낱장인쇄, 1-DB접속다이얼로그만 숨김, 2-상태다이얼로그까지 숨김, 3-프린트 다이얼로그까지 숨김, 4-프린터 취소 다이얼로그까지 숨김)
			Rdviewer_Face.SetPrintInfo (Face_PrnDrv, 1, 1, 4);
			//alert("Face_PrnDrv : [" + Face_PrnDrv + "]\n\n" + "Face_PrnCnt : [" + Face_PrnCnt + "]");
			Rdviewer_Face.SetPrint2(getRadioValue2(form.paper_type),1,0,100);
			Rdviewer_Face.CMPrint();
			if(formType == '4' || formType == '1'){
				sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", 'f_cmd=' + COMMAND19 + '&bkg_no=' + bkgNo + '&ser_no=' + serNo + (i+1));
			}
			
		}

		// Rider
		if ( (formObject.rider_only_yn.disabled == false && formObject.rider_only_yn.checked == true) || (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true) ) {
			// Rider 출력
			RiderPrintYn = true;
			if(getRadioValue2(form.paper_type) == '1'){
				strRiderPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_A4_Rider.mrd";
			}else if(getRadioValue2(form.paper_type) == '4'){
				strRiderPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_LETTER_Rider.mrd";
			}else if(getRadioValue2(form.paper_type) == '10'){
				strRiderPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DOT_Rider.mrd";
			}
		}
		
		if (RiderPrintYn == true && Rider_PrnCnt > 0) {
			for (var i = 0; i < Rider_PrnCnt; i++) {
				rdParam_Rider = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
				rdParam_Rider += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
				rdParam_Rider += "form_level[(" + formRate + ")] "; // form_level
				rdParam_Rider += "form_Rate[] "; // form_Rate
				rdParam_Rider += "form_Cntr[" + formCntr + "] "; // form_Cntr
				//rdParam_Rider += "form_gubun[M] "; // form_gubun
				rdParam_Rider += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
				rdParam_Rider += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
				rdParam_Rider += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
				rdParam_Rider += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
				rdParam_Rider += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
				rdParam_Rider += "form_his_bl[" + formHisBl + "] "; // form_his_bl
				if(serNo != '')
					rdParam_Rider += "form_serial[" + serNo + (i+1) + "] "; // form_his_bl
				rdParam_Rider += "/rp [" + formCaYn + "] "; // form_caYn
				rdParam_Rider += "/riprnmargin /rmatchprndrv [3]";

				//alert("RiderPrintYn : [" + RiderPrintYn + "]");
				Rdviewer_Rider.SetMessageboxShow(1); //에러메시지만 출력함
				//alert("Rdviewer_Rider");
				Rdviewer_Rider.FileOpen(strRiderPath, RDServer + rdParam_Rider);
				
				//alert("RiderPrintYn : [" + RiderPrintYn + "]");
				// Rider
				// 프린터 드라이버 이름 : Rider_PrnDrv
				// 인쇄매수 : Rider_PrnCnt
				// 한부씩인쇄 : 1
				// 인쇄시 뜨는 대화상자 모두 숨김 : 4
				// Rdviewer_main.SetPrintInfo (프린터 드라이버 이름, 인쇄매수, 1-한부씩 인쇄, 2-낱장인쇄, 1-DB접속다이얼로그만 숨김, 2-상태다이얼로그까지 숨김, 3-프린트 다이얼로그까지 숨김, 4-프린터 취소 다이얼로그까지 숨김)
				Rdviewer_Rider.SetPrintInfo (Rider_PrnDrv, 1, 1, 4);
				Rdviewer_Rider.SetPrint2(getRadioValue2(form.paper_type),1,0,100);
				Rdviewer_Rider.CMPrint();
			}
		}
		
		if ( (formObject.nvocc_only_yn.disabled == false && formObject.nvocc_only_yn.checked == true) ||
			 (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true) ) {
			rdParam_Hb = "/rv form_bkgNo[( '" + bkgNo + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";
			if(hblTp == "A")
				strHbPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D.mrd";
			else
				strHbPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D2.mrd";
			Rdviewer_Hb.SetMessageboxShow(1); //에러메시지만 출력함
			Rdviewer_Hb.FileOpen(strHbPath, RDServer + rdParam_Hb);
			Rdviewer_Hb.SetPrintInfo (Rider_PrnDrv, Rider_PrnCnt, 1, 4);
			Rdviewer_Hb.SetPrint2(getRadioValue2(form.paper_type),1,0,100);
			Rdviewer_Hb.CMPrint();
		}
	}
	

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        //숫자 입력하기
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
    		
				default:
					break;
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}  

/*********************** KEY EVENT END ********************/

	/**
	 * 프린트 매수 옵션을 3으로 변경한다. <br>
	 **/
   function setPrintcnt(){
   	if(form.form_type.Code == "0"){
   		form.face_print_cnt.options[1].selected = true;
   		form.rider_print_cnt.options[1].selected = true;
   	} else if(form.form_type.Code == "1"){
   		form.face_print_cnt.options[5].selected = true;
   		form.rider_print_cnt.options[5].selected = true;
   	} else if(form.form_type.Code == "2"){
   		form.face_print_cnt.options[1].selected = true;
   		form.rider_print_cnt.options[1].selected = true;
   	} else if(form.form_type.Code == "3"){
   		form.face_print_cnt.options[obl_iss_knt].selected = true;
   		form.rider_print_cnt.options[obl_iss_knt].selected = true;
   	} else if(form.form_type.Code == "4"){
   		//if(save_face_print_cnt ==""){//저장된것이 없으면
   			if(bl_cpy_knt == "0")//bl당 인쇄 개수가 0이면 디폴트 인쇄
   				form.face_print_cnt.options[3].selected = true;
   			else
   				form.face_print_cnt.options[eval(bl_cpy_knt)].selected = true;
   		//}else{
   		//	form.face_print_cnt.options[eval(save_face_print_cnt)].selected = true;
   		//}
   		
   		
   		if(save_rider_print_cnt ==""){//저장된것이 없으면
   			if(bl_cpy_knt == "0")//bl당 인쇄 개수가 0이면 디폴트 인쇄
   				form.rider_print_cnt.options[3].selected = true;
   			else
   				form.rider_print_cnt.options[eval(bl_cpy_knt)].selected = true;
   		}else{
   			form.rider_print_cnt.options[eval(save_rider_print_cnt)].selected = true;
   		}
   			  		
   		form.face_print_cnt.disabled = true;
   		//form.rider_print_cnt.disabled = true;
   		return;
   		//form.face_print_cnt.options[3].selected = true;
   		//form.rider_print_cnt.options[3].selected = true;
   	} else if(form.form_type.Code == "5"){
   		form.face_print_cnt.options[1].selected = true;
   		form.rider_print_cnt.options[1].selected = true;
   	}
   	
   	form.face_print_cnt.disabled = false;
   	form.rider_print_cnt.disabled = false;
   	
   }
  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick  = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
				
        /*******************************************************/
        var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
					
		 				case "btn_save":
		 					doActionIBSheet(sheetObject1,formObject,MODIFY01);
		 					break;
		 				case "btn_Print":
					  	if(formObject.bkg_no.value == "" ){
								ComShowCodeMessage('BKG00626','BKG No.');
								return false;
							}

							ComOpenWait(true);
							rdStart();
							ComOpenWait(false);

							if(	formObject.form_type.Code == "4" ){
								doActionIBSheet(sheetObject1,formObject,MODIFY03);
								obl_prn_flg = "Y";
							}
							
		 					break;
		 				case "btn_Print_Release":
	 						
					  	if(formObject.bkg_no.value == "" ){
								ComShowCodeMessage('BKG00626','BKG No.');
								return false;
							}
							
							if(	formObject.form_type.Code == "4" ){
								if(org_ppd_rcv_cd != "Y" || org_n3pty_ppd_cd !="Y"){
									ComShowCodeMessage('BKG08079');
									return;	
								}
							}
							
							if(print_release_yn != "Y" ){
								ComShowCodeMessage('BKG00434');
								return;	
							}
								
							ComOpenWait(true);
							rdStart();
							
							if(	formObject.form_type.Code == "4" ){
								doActionIBSheet(sheetObject1,formObject,MODIFY02);
								formObject.obl_rlse_flg.value == "Y";
								obl_prn_flg = "Y";
							}
							
							ComOpenWait(false);

		 					break;
		 				case "btn_Print_Setup":
		 					print();
		 					break;	
		 				case "btn_close":
		 					self.close();
		 					break;	
		 				case "rider_only_yn":
							if(form.rider_only_yn.checked){
								form.nvocc_only_yn.checked = false;
								form.rider_nvocc_yn.checked = false;
							}
							break; 	
		 				case "nvocc_only_yn":
							if(form.nvocc_only_yn.checked){
								form.rider_only_yn.checked = false;
								form.rider_nvocc_yn.checked = false;
							}
							break; 	
		 				case "rider_nvocc_yn":
							if(form.rider_nvocc_yn.checked){
								form.nvocc_only_yn.checked = false;
								form.rider_only_yn.checked = false;
							}
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
  * //설정한 프린트 1>2>3>3>5,2>3>2>3>5 형식으로 조회함  
  * BL_PRN_TP_CD||'>'||BL_PRN_CHG_TP_CD||'>'|| BL_PRN_CNTR_TP_CD||'>'||BL_FACE_PRN_KNT||'>'||BL_RIDR_PRN_KNT
  */
   var bl_prn_setup = "";
	/**
	 * B/L TYPE에 따라 조건 값을 처리하기 위한 변수
	 * */
	var bl_prn_setup_Map = new Array();
	
	function setInitPrintSetup(val){
		if(val == ""){
  		form.form_type.Code = '2';
			form.form_Rate.Code = '1';
			form.form_Cntr.Code = '1';
			
			pre_form_type = form.form_type.Code;
			pre_container_type = form.form_Cntr.Code;
			
			form.bl_ridr_prn_dvc_nm.Code = defaultPrint;
			form.bl_face_prn_dvc_nm.Code = defaultPrint;
		
			setPrintcnt();
			initYn = false;
			return;
		}
		
		bl_prn_setup = val;
		var arr_bl_prn_setup = bl_prn_setup.split("@");
		var arr_combo_setup = null;							
		for(var i=0; i < arr_bl_prn_setup.length; i++){
				arr_combo_setup = arr_bl_prn_setup[i].split(">");
				bl_prn_setup_Map[arr_combo_setup[0]] = arr_bl_prn_setup[i];

				if(arr_combo_setup[0] == '2' ){ //기본프린트 Non-Negotiable B/L이 저장된 값이 있을 경우
					form.form_type.Code = arr_combo_setup[0];
					pre_form_type = form.form_type.Code;
					form.form_Rate.Code = arr_combo_setup[1];
					form.form_Cntr.Code = arr_combo_setup[2];
					form.face_print_cnt.options[arr_combo_setup[3]].selected = true;
					form.rider_print_cnt.options[arr_combo_setup[4]].selected = true;
					form.bl_prn_mgn_val.options[arr_combo_setup[7]].selected = true;
										
					/************ 프린트 드라이버 세팅 **********************/
					if(!checkPrintList(arr_combo_setup[5])){ //FACE_PRINT
						form.bl_face_prn_dvc_nm.Code = defaultPrint;
					}else{
						form.bl_face_prn_dvc_nm.Code	= arr_combo_setup[5];
					}
					
					if(!checkPrintList(arr_combo_setup[6])){//RIDER_PRINT
						form.bl_ridr_prn_dvc_nm.Code = defaultPrint;	
					}else{
						form.bl_ridr_prn_dvc_nm.Code	= arr_combo_setup[6];
					}
					/************ 프린트 드라이버 세팅 끝 **********************/					
				}
		}
		
		
		 if(form.form_type.Code != '2'){ //기본프린트 Non-Negotiable B/L이 저장된 값이 없을 경우
				 	form.form_type.Code = '2';
					form.form_Rate.Code = '1';
					form.form_Cntr.Code = '1';
					
					pre_form_type = form.form_type.Code;
					pre_container_type = form.form_Cntr.Code;
					
					form.bl_ridr_prn_dvc_nm.Code = defaultPrint;
					form.bl_face_prn_dvc_nm.Code = defaultPrint;
									
					setPrintcnt();
			}
		
		pre_container_type =form.form_Cntr.Code;
		 
		initYn = false;
	}
	
	/**
	 * 옵션 저장시 DB에 저장된 값을 변수에 저장한다. 추후 선택시 저장된 값을 선택되게 하기 위함. 
	 * */
	function savePrintSetup(){
		  bl_prn_setup_Map[form.form_type.Code] = form.form_type.Code+">"+form.form_Rate.Code+">"+form.form_Cntr.Code
		                                         +">"+ComGetObjValue(form.face_print_cnt)+">"+ComGetObjValue(form.rider_print_cnt)
		                                         +">"+form.bl_face_prn_dvc_nm.Code+">"+form.bl_ridr_prn_dvc_nm.Code+">"+ComGetObjValue(form.bl_prn_mgn_val);
		  
				
		}	
	
	
	function setBtn_Print_Release(){
		
		if(form.form_type.Code == '4' && form.obl_rlse_flg.value != "Y"){
			if(org_ppd_rcv_cd != "Y" || org_n3pty_ppd_cd !="Y" || print_release_yn != "Y" ){
				ComBtnDisable("btn_Print_Release");
				return;	
			}
			ComBtnEnable("btn_Print_Release");
		}else{
			ComBtnDisable("btn_Print_Release");
		}
	}
	
/**
	 * form_type 값이 변경 될때 기존에 설정된 값을 세팅한다.
	 * @param comboObj
	 * @return
	 */
	 
	var initYn = true;// 페이지 로딩시 값이 변경 되면 이벤트를 발생하지 않게 하기 위함.
	function form_type_OnChange(comboObj) {
		setBtn_Print_Release();
		if(initYn)		return;
	
		var formObject = document.form;
		if(comboObj.Code == '4' && bl_tp_cd == 'W'){
			 ComShowCodeMessage('BKG08089');
			form.form_type.Code = pre_form_type;
			return;
		}else if(comboObj.Code == '4' && obl_iss_flg == 'N'){
			 ComShowCodeMessage('BKG08090');
			form.form_type.Code = pre_form_type;
			return;
		}else if(comboObj.Code == '4' && obl_prn_flg == 'Y'){
			ComShowCodeMessage('BKG08091');
			form.form_type.Code = pre_form_type;
			return;
		}else if(comboObj.Code == '4' && form.obl_rlse_flg.value == 'Y'){
			ComShowCodeMessage('BKG08098');
			form.form_type.Code = pre_form_type;
			return;
		}else if(comboObj.Code == '4' && form.obl_block_flg.value == 'Y'){
			ComShowCodeMessage('BKG08318');
			form.form_type.Code = pre_form_type;
			return;
		}else if( (comboObj.Code == '5' || comboObj.Code == '6' ) && bl_tp_cd != 'W'){
			ComShowCodeMessage('BKG08092');
			form.form_type.Code = pre_form_type;
			return;
		}else if(form.form_type.Code == '7' && null != formObject.pod_cd.value && formObject.pod_cd.value.substring(0,2) != "RU" ){
			ComShowCodeMessage('BKG08261');
			form.form_type.Code = pre_form_type;
			return;
		}
	
		pre_form_type = comboObj.Code;
		
		if(bl_prn_setup_Map[comboObj.Code] == undefined){
			
			form.form_Rate.Code = '1';
			form.form_Cntr.Code = '1';
			
			pre_container_type =form.form_Cntr.Code;
			
			form.bl_face_prn_dvc_nm.Code = defaultPrint;
			form.bl_ridr_prn_dvc_nm.Code = defaultPrint;	
			
			setPrintcnt();
			
			return;
		}
		var arr_combo_setup = bl_prn_setup_Map[comboObj.Code].split(">");

		form.form_Rate.Code = arr_combo_setup[1];
		form.form_Cntr.Code = arr_combo_setup[2];
		
		pre_container_type  = form.form_Cntr.Code;
		
		if(comboObj.Code == '4'){
			
			if(arr_combo_setup[3]!= "")
				save_face_print_cnt = arr_combo_setup[3];
				
			if(arr_combo_setup[4]!= "")
				save_rider_print_cnt = arr_combo_setup[4];
			
			setPrintcnt();//Original B/L일경우 기본세팅
		}else{	
			form.face_print_cnt.options[arr_combo_setup[3]].selected = true;
			form.rider_print_cnt.options[arr_combo_setup[4]].selected = true;
			form.face_print_cnt.disabled = false;
   		form.rider_print_cnt.disabled = false;
		}
		 
		/************ 프린트 드라이버 세팅 **********************/
		if(!checkPrintList(arr_combo_setup[5])){ //FACE_PRINT
			form.bl_face_prn_dvc_nm.Code = defaultPrint;
		}else{
			form.bl_face_prn_dvc_nm.Code	= arr_combo_setup[5];
		}
		
		if(!checkPrintList(arr_combo_setup[6])){//RIDER_PRINT
			form.bl_ridr_prn_dvc_nm.Code = defaultPrint;	
		}else{
			form.bl_ridr_prn_dvc_nm.Code	= arr_combo_setup[6];
		}
		/************ 프린트 드라이버 세팅 끝 **********************/		
		
//		if(	comboObj.Code == "4"  && formObject.obl_rlse_flg.value == "Y"){
//			ComShowCodeMessage("BKG02019");
//		}
		
	}
		
/**
	 * form_Rate 값이 변경 될때 기존에 설정된 값을 세팅한다.
	 * @param comboObj
	 * @return
	 */
	 
	function form_Rate_OnChange(comboObj) {
		if(initYn) return;
		
		if(bl_prn_setup_Map[comboObj.Code] == undefined){	
			setPrintcnt();
		}
		
		Retrive(sheetObjects[0]);
	}
	
/**
	 * form_Cntr 값이 변경 될때 기존에 설정된 값을 세팅한다.
	 * @param comboObj
	 * @return
	 */
	 
	var pre_cntr_setup_flag = false; // 컨테이너 타입이 선택 불가 로직에 포함 될때 이전으로 되돌릴 시 Retrive 안되게 하기위함. 
	function form_Cntr_OnChange(comboObj) {
		if(initYn) return;
		
		var formObject = document.form;
		
		if(pre_cntr_setup_flag){
			pre_cntr_setup_flag = false;
			return;
		}
		
		if(comboObj.Code == "4" && bb_cgo_flg == "N" ){
			ComShowCodeMessage("BKG08093");
			pre_cntr_setup_flag = true; 
			comboObj.Code = pre_container_type;
			return;
		}
		
		if(bl_prn_setup_Map[comboObj.Code] == undefined){	
			setPrintcnt();
		}
		
		pre_container_type  = form.form_Cntr.Code;
		
		Retrive(sheetObjects[0]);
	}
		
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXmls = sheetObj.GetSearchXml("ESM_BKG_0743GS.do", FormQueryString(formObj));
							var arrSXml = sXmls.split("|$$|");
							var sXml = arrSXml[0];
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
							
							if (firstYn == false) {
								ComXml2ComboItem(sXml, formObj.ca_no, "corr_no", "corr_no");
								firstYn = true;
							}
							
							ComXml2ComboItem(arrSXml[1], formObj.form_type, "val", "name");
							ComXml2ComboItem(arrSXml[2], formObj.form_Rate, "val", "name");
							ComXml2ComboItem(arrSXml[3], formObj.form_Cntr, "val", "name");
							
							bl_tp_cd = ComGetEtcData(sXml, "bl_tp_cd");
							initPrintList();
							setInitPrintSetup(ComGetEtcData(sXml, "bl_prn_setup"));
//							if(ComGetEtcData(sXml, "bl_tp_cd") == "W"){
//								formObj.form_type.DeleteItem('4');
//							}else if(ComGetEtcData(sXml, "bl_tp_cd") == ""){
//								formObj.form_type.DeleteItem('5');
//								formObj.form_type.DeleteItem('6');
//							}
							
//							/************ 프린트 드라이버 세팅 **********************/
//							if(ComGetEtcData(sXml, "bl_face_prn_dvc_nm") == undefined){
//								form.bl_face_prn_dvc_nm.Code = defaultPrint;
//								form.bl_ridr_prn_dvc_nm.Code = defaultPrint;
//							}else{
//								if(!checkPrintList(ComGetEtcData(sXml, "bl_face_prn_dvc_nm"))){
//									form.bl_face_prn_dvc_nm.Code = defaultPrint;
//									
//								}else{
//									form.bl_face_prn_dvc_nm.Code	= ComGetEtcData(sXml, "bl_face_prn_dvc_nm");
//								}
//								
//								if(!checkPrintList(ComGetEtcData(sXml, "bl_ridr_prn_dvc_nm"))){
//									form.bl_ridr_prn_dvc_nm.Code = defaultPrint;	
//								}else{
//									form.bl_ridr_prn_dvc_nm.Code	= ComGetEtcData(sXml, "	");
//								}
//							}
//							/************ 프린트 드라이버 세팅 끝 **********************/

							var rider_only_yn = ComGetEtcData(sXml, "rider_only_yn");
							var nvocc_only_yn = ComGetEtcData(sXml, "nvocc_only_yn");
							hblTp = ComGetEtcData(sXml, "hbl_tp");
							
							org_ppd_rcv_cd = ComGetEtcData(sXml, "org_ppd_rcv_cd");
							org_n3pty_ppd_cd = ComGetEtcData(sXml, "org_n3pty_ppd_cd");
							
							obl_iss_knt	= ComGetEtcData(sXml, "obl_iss_knt");

							obl_iss_flg	= ComGetEtcData(sXml, "obl_iss_flg");
							obl_prn_flg	= ComGetEtcData(sXml, "obl_prn_flg");
							bb_cgo_flg	= ComGetEtcData(sXml, "bb_cgo_flg");
							bl_cpy_knt	= ComGetEtcData(sXml, "bl_cpy_knt");
							conti_cd	= ComGetEtcData(sXml, "conti_cd");
							print_release_yn	= ComGetEtcData(sXml, "print_release_yn");
							document.form.pod_cd.value = ComGetEtcData(sXml, "pod_cd");

							//5/31 이후 선적 진행된 OMMCT를 POD로 하는 BKG의 OBL 생성 Block
							if(ComGetEtcData(sXml, "pod_cd")=='OMMCT' && ComGetEtcData(sXml, "date_flg") == 'Y'){
								document.form.obl_block_flg.value = 'Y';
							}
							
							if(conti_cd == 'M'){
								formObj.paper_type[1].checked = true;
							}							
							formObj.obl_rlse_flg.value	= ComGetEtcData(sXml, "obl_rlse_flg");

							//alert("rider_only_yn : [" + rider_only_yn + "]\n\n" + "nvocc_only_yn : [" + nvocc_only_yn + "]");
							
							// checked
							/* 신은영 차장님 요청 Rider가 있고 H/BL 이 있을경우도  Rider Only 체크만 2010.1025 */
//							if(rider_only_yn == "Y" && nvocc_only_yn == "Y"){
								//formObj.rider_nvocc_yn.checked = true;
							if(rider_only_yn == "Y"){
								formObj.rider_only_yn.checked = true;
							}else	if(nvocc_only_yn == "Y"){
								//formObj.nvocc_only_yn.checked = true;
							}else if(rider_only_yn == "N"){
								formObj.rider_only_yn.checked = false;
							}else if(nvocc_only_yn == "N"){
								//formObj.nvocc_only_yn.checked = false;
							}
							else {
								//formObj.rider_nvocc_yn.checked = false;
							}

							// disable
							if ( rider_only_yn != "Y" || nvocc_only_yn != "Y") {

								//formObj.rider_nvocc_yn.disabled = true;

								if ( rider_only_yn != "Y" ) {
									formObj.rider_only_yn.disabled = true;
								}
								else {
									formObj.rider_only_yn.disabled = false;
								}

								if ( nvocc_only_yn != "Y" ) {
									//formObj.nvocc_only_yn.disabled = true;
								}
								else {
									//formObj.nvocc_only_yn.disabled = false;
								}

							}
							
							break;
			 			case SEARCH01:      //조회
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH01;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0743GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
							
							var rider_only_yn = ComGetEtcData(sXml, "rider_only_yn");
							var nvocc_only_yn = ComGetEtcData(sXml, "nvocc_only_yn");
							hblTp = ComGetEtcData(sXml, "hbl_flg");
							// checked
							/* 신은영 차장님 요청 Rider가 있고 H/BL 이 있을경우도  Rider Only 체크만 2010.1025 */
//							if(rider_only_yn == "Y" && nvocc_only_yn == "Y"){
								//formObj.rider_nvocc_yn.checked = true;
							if(rider_only_yn == "Y"){
								formObj.rider_only_yn.checked = true;
							}else	if(nvocc_only_yn == "Y"){
								//formObj.nvocc_only_yn.checked = true;
							}else if(rider_only_yn == "N"){
								formObj.rider_only_yn.checked = false;
							}else if(nvocc_only_yn == "N"){
								//formObj.nvocc_only_yn.checked = false;
							}
							else {
								//formObj.rider_nvocc_yn.checked = false;
							}

							// disable
							if ( rider_only_yn != "Y" || nvocc_only_yn != "Y") {

								//formObj.rider_nvocc_yn.disabled = true;

								if ( rider_only_yn != "Y" ) {
									formObj.rider_only_yn.disabled = true;
								}
								else {
									formObj.rider_only_yn.disabled = false;
								}

								if ( nvocc_only_yn != "Y" ) {
									//formObj.nvocc_only_yn.disabled = true;
								}
								else {
									//formObj.nvocc_only_yn.disabled = false;
								}

							}
							 
							break;
						case MODIFY01:        //저장
				 				formObj.f_cmd.value = MODIFY01;
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				var sParam = "&"+ FormQueryString(formObj);
								var sXml = sheetObj.GetSaveXml("ESM_BKG_0743GS.do" , sParam);
								 if (ComGetEtcData(sXml, "success_yn") =="Y"){
								 			savePrintSetup();
								 			ComShowCodeMessage('COM130102','Data');
								 }else{
								 	ComShowCodeMessage('COM130103','Data');
								 }
			 				break;									
						case MODIFY02:        // OBL_PRN_FLG, OBL_RLSE_FLG 업데이트
				 				formObj.f_cmd.value = MODIFY02;
				 				var sParam = "&obl_prn_flg=Y&released=Y&"+ FormQueryString(formObj);
								var sXml = sheetObj.GetSaveXml("ESM_BKG_0743GS.do" , sParam);
								 if (ComGetEtcData(sXml, "success_yn") !="Y"){
								 		ComShowCodeMessage('COM130103','Data');
								 }
			 				break;									
						case MODIFY03:        // OBL_PRN_FLG 업데이트
				 				formObj.f_cmd.value = MODIFY02;
				 				var sParam = "&obl_prn_flg=Y&"+ FormQueryString(formObj);
								var sXml = sheetObj.GetSaveXml("ESM_BKG_0743GS.do" , sParam);
								 if (ComGetEtcData(sXml, "success_yn") !="Y"){
								 		ComShowCodeMessage('COM130103','Data');
								 }
			 				break;									
			    }
     }
     
     
     
     


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
    		case IBSEARCH:
			  	if(formObj.bkg_no.value == "" ){
							ComShowCodeMessage('BKG00626','BKG No.');
							return false;
					}
	  			break;
    		case MODIFY01:
			  	if(formObj.bl_face_prn_dvc_nm.value == "" ){
							ComShowCodeMessage('BKG00626','Print Setup(Face)');
							return false;
					}
	  			break;
    	 	}
            return true;
     }
    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    

 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 // 높이 설정
                 style.height = 150;
                 
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 3, 10);

								var HeadTitle1 = "Sel|Group|User ID|User Name";

                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
								//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

								
						}
 				
 					break;
         
         }
     }

	function ca_no_OnChange(ComboObj, Index_Code, Text) {

		var formObject = document.form;

		if ( formObject.bl_ca_yn.checked ) {
			var bComboUC = ComboObj.UseCode;
			// UseCode=false인 경우 code를 의미한다.
			//ComboObj.UseCode == true ? false : true;

			//alert("Index_Code : [" + Index_Code + "]\n\n" + "Text : [" + ComboObj.Text + "]");
			formObject.corr_no.value = Index_Code;
			Retrive(sheetObjects[0]);

			// 초기값으로 변경
			//ComboObj.UseCode = bComboUC;
		}

	}
    

	/* 개발자 작업  끝 */    