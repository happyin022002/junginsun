/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0743_01.js
*@FileTitle  :  B/L Print Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/

	var sheetObjects=new Array();
	var sheetCnt=0;
	var rdObjects=new Array();
	var rdCnt=0;
	var queryStr="";
	var prefix="sheet1_";
	var firstYn=false;
	var obl_iss_knt=1;
	var bl_tp_cd=""; // B/L type
	var obl_iss_flg=""; // issued B/L
	var obl_prn_flg="";
	var bb_cgo_flg="";
	var bl_cpy_knt="";
	var pre_form_type="";
	var pre_container_type="";
	var success_cnt=0;
	var error_cnt=0;
	var save_face_print_cnt="";
	var save_rider_print_cnt="";
	/*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	//registering the created IBCombo Object at page as comboObjects list
	//ComComboObject is called from Constructor method
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initCombo event handling<br>
	 * @param
	 * @exception EventException
	 */
	function initCombo(comboObj, comboId) {
		var formObject=document.form
		initComboEditable(comboObj)
	}
	function initComboEditable(combo){
		with (combo) {
			SetMultiSelect(0);
			SetUseEdit(0);
			SetDropHeight(200);
		}
	}
 /*********************** EDTITABLE MULIT COMBO END********************/
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		if (window.dialogArguments) {
			document.form.p_bkg_no.value=window.dialogArguments.bkg_no;
			document.form.form_manifest.value=window.dialogArguments.form_manifest;
		}
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		 //MultiComboinitializing
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for(i=0;i<rdObjects.length;i++){
			initRdConfig(rdObjects[i],i+1);
		}
		initControl();
		firstYn=false;
		initPrintList();
		doActionIBSheet(sheetObjects[0],form,SEARCH02);
//		  var bkgXML= "<SHEET>"
//								+ " <DATA COLORDER='bkg_no|print_result|remarks|obl_issued_flg|obl_printed_flg|obl_released_flg|obl_wbl_flg|rider_yn|hbl_yn' COLSEPARATOR='☜☞' TOTAL='1'>"
//								+ "	 <TR><![CDATA[bkg_no☜☞print_result☜☞remarks☜☞obl_issued_flg☜☞obl_printed_flg☜☞obl_released_flg☜☞obl_wbl_flg☜☞rider_yn☜☞hbl_yn]]></TR>"
//								+ " </DATA>"
//								+ "</SHEET>";
//
//			sheetObjects[0].LoadSearchXml(bkgXML);
	}
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- in case of typing keyboard
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- focus out
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- focus in
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm('click',         'obj_click', 	form);
		axon_event.addListenerForm('change',         'obj_change', 	form);
	}

	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	var strPrintList="";
	var defaultPrint="";

	function initPrintList() {
		var Rdviewer_Face = document.form.report1;    // for IE11
		if (Rdviewer_Face == undefined) Rdviewer_Face = report1;    // for Chrome
		strPrintList=Rdviewer_Face.GetLocalInfo("PrnNames", "");
		defaultPrint=Rdviewer_Face.GetLocalInfo("DefaultPrnName", "");
		//alert(defaultPrint);
		if(strPrintList == undefined || strPrintList == null || strPrintList == "") return;
		var arrPrintList=strPrintList.split("|");
		printListXml=" <SHEET> \n";
		printListXml += " <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='"+(arrPrintList.length-1)+"'> \n";
		for(var i=0; i < arrPrintList.length-1; i++) {
			printListXml += " 	<TR><![CDATA["+arrPrintList[i]+"]]></TR> \n";
		}
		printListXml += " </DATA> \n";
		printListXml += " </SHEET> ";
		ComXml2ComboItem(printListXml, bl_face_prn_dvc_nm, "val", "val");
		ComXml2ComboItem(printListXml, bl_ridr_prn_dvc_nm, "val", "val");
	}
	/**
	* confirm print and saved print list
	* */
	function checkPrintList(val){
		var arrPrintList=strPrintList.split("|");
		for(var i=0; i < arrPrintList.length-1; i++) {
			if(val == arrPrintList[i]) return true;
		}
		return false;
	}
	function initRdConfig(rdObject){
		rdObject.AutoAdjust = true;
		rdObject.ViewShowMode(0);
		rdObject.SetBackgroundColor(128,128,128);
		rdObject.SetPageLineColor(128,128,128);
		rdObject.style.height = 0;
		rdObject.ApplyLicense("0.0.0.0");
	}
	function obj_click() {
		var formObject=document.form;
		var obj=event.srcElement;
		switch(ComGetEvent("name")){
			case "hiddenData": // hiddenData
				//alert(obj.name + "\n\n" + obj.value);
				Retrive(sheetObjects[0]);
				break;
			case "bl_ca_yn": // bl_ca_yn
				//alert(obj.name + "\n\n" + obj.value);
				if ( obj.checked == false ) {
					formObject.corr_no.value="";
					formObject.ca_no.SetSelectCode("");
				}
				Retrive(sheetObjects[0]);
				break;
		}
	}
	function Retrive(sheetObject) {
//		//
//		var formObject = document.form;
//
//		ComOpenWait(true);
//		doActionIBSheet(sheetObjects[0],form,SEARCH01);
//		sheetObjects[0].RemoveAll()
//		ComOpenWait(false);
	}
	function rdStart(p_bkg_no,bl_cpy_knt,obl_rider_flg) {
		//
		var formObject=document.form;
		var strBkgNo=p_bkg_no;
		var FaceYn="Y";
		var RiderYn="Y";
		var HBYn="Y";
		if (strBkgNo.length == 0) {
			ComShowCodeMessage('BKG00626','BKG No.');
			return;
		}
		rdOpen(formObject, RiderYn, HBYn,strBkgNo,bl_cpy_knt,obl_rider_flg);
	}
	function rdOpen(formObject, RiderYn, HBYn,p_bkg_no,bl_cpy_knt,obl_rider_flg){
		var totalPage = rdOpenStart(formObject, RiderYn, HBYn,p_bkg_no,bl_cpy_knt,obl_rider_flg);
		var Rdviewer_Face = document.form.report1;    // for IE11
		if (Rdviewer_Face == undefined) Rdviewer_Face = report1;    // for Chrome
		var Rdviewer_Rider = document.form.report2;    // for IE11
		if (Rdviewer_Rider == undefined) Rdviewer_Rider = report2;    // for Chrome
		var Rdviewer_Hb = document.form.report3;    // for IE11
		if (Rdviewer_Hb == undefined) Rdviewer_Hb = report3;    // for Chrome
		//ComOpenWait(true);
		var RiderPrintYn=false;
		var rdParam_Face="";
		var rdParam_Rider="";
		var rdParam_Hb="";
		var strFacePath="";
		var strRiderPath="";
		var strHbPath="";
		var bkgNo=p_bkg_no; // bkg_no
		var formType=form_type.GetSelectCode(); // form_type
		var formDataOnly=formObject.preview_yn.checked == true ? "N" : "Y"; // Preview
		var formManifest=formObject.form_manifest.value; // form_manifest
		var formUserId=formObject.usr_id.value; // form_usrId
		var formHiddenData=formObject.hiddenData.checked == true ? "Y" : "N"; // form_hiddeData
		var formOfcCd=formObject.ofc_cd.value; // ofc_cd
		// ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)")
		var formRemark=ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)"); // form_remark
		formRemark=ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(formRemark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
		var formRate=form_Rate.GetSelectCode(); // form_Rate
		var formCntr=form_Cntr.GetSelectCode(); // form_Cntr
		//var formMainOnly = (formObject.rider_only_yn.disabled == false|| formObject.rider_nvocc_yn.disabled == false) ? "N" : "Y"; // form_mainOnly
		var formMainOnly="Y"; // form_mainOnly
		var formCorrNo=formObject.bl_ca_yn.checked == true ? formObject.ca_no.GetSelectCode(): ""; // form_CorrNo
		var formHisCntr=formObject.bl_ca_yn.checked == true ? "BKG_CNTR_HIS" : "BKG_CONTAINER"; // form_his_cntr
		var formHisBkg=formObject.bl_ca_yn.checked == true ? "BKG_BKG_HIS" : "BKG_BOOKING"; // form_his_bkg
		var formHisMkd=formObject.bl_ca_yn.checked == true ? "BKG_BL_MK_DESC_HIS" : "BKG_BL_MK_DESC"; // form_his_mkd
		var formHisXpt=formObject.bl_ca_yn.checked == true ? "BKG_XPT_IMP_LIC_HIS" : "BKG_XPT_IMP_LIC"; // form_his_xpt
		var formHisBl=formObject.bl_ca_yn.checked == true ? "BKG_BL_DOC_HIS" : "BKG_BL_DOC"; // form_his_bl
		var formHisBlMkd=formObject.bl_ca_yn.checked == true ? "BKG_BL_ISS_HIS" : "BKG_BL_ISS"; // form_his_bl
		var formCaYn=formObject.bl_ca_yn.checked == true ? "Y" : ""; // form_caYn
		var Face_PrnDrv=bl_face_prn_dvc_nm.GetSelectCode(); // Print Setup (Face)
		var Face_PrnCnt=formObject.face_print_cnt.value; // Print Count (Face)
		var Rider_PrnDrv=bl_ridr_prn_dvc_nm.GetSelectCode(); // Print Setup (Rider)
		var Rider_PrnCnt=formObject.rider_print_cnt.value; // Print Count (Rider)
		// Face
		if(getRadioValue2(form.paper_type) == '1'){
			strFacePath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
		}else if(getRadioValue2(form.paper_type) == '4'){
			strFacePath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
		}else if(getRadioValue2(form.paper_type) == '10'){
			strFacePath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_DOT.mrd";
		}
		/*
		/rv form_bkgNo[(  'ATLZ4030031', 'TPEZ1295047', 'MUCZ3270004', 'HAMY5080012', 'SZPZ1145010', 'BKK6C135013' )]
			 form_type[2] ---> Default
			 form_dataOnly[N] ---> Default
			 form_manifest[N] ---> Default
			 form_usrId[TES_AARBA] ---> Session
			 form_hiddeData[N] ---> Default
			 form_level[(1)] ---> Default (ex - (1,2,3,4,5))
			 form_remark[] ---> Default
			 form_Cntr[1] ---> Default
			 form_mainOnly[N] ---> Default
			 form_CorrNo[] ---> Default
			 form_his_cntr[BKG_CONTAINER] ---> Default
			 form_his_bkg[BKG_BOOKING] ---> Default
			 form_his_mkd[BKG_BL_MK_DESC] ---> Default
			 form_his_xpt[BKG_XPT_IMP_LIC] ---> Default
			 form_his_bl[BKG_BL_DOC] ---> Default
		/rp [] ---> Default
		/riprnmargin
		*/
		rdParam_Face="/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
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
		rdParam_Face += "form_end_no[" + totalPage +"] "; // form_end_no
		rdParam_Face += "form_rqst_via_cd[] "; // form_rqst_via_cd
		rdParam_Face += "form_his_bl_mkd[" + formHisBlMkd +"] "; // form_his_bl_mkd
		rdParam_Face += "form_path[" + getFileDownPath() + "] "; // form_path
		rdParam_Face += "form_esig[] "; // form_esig
		rdParam_Face += "form_cpy_esig[] "; // form_cpy_esig
		rdParam_Face += "form_knt_flg[] "; // form_knt_flg
		rdParam_Face += "form_count[] "; // form_count
		rdParam_Face += "/rp [" + formCaYn + "] "; // form_caYn
		rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
		if(formOfcCd == "BOMBB" || formOfcCd == "DELBS" || formOfcCd == "MAABS") {
			rdParam_Face += " /rpypos [25]";
		}
		if ( obl_rider_flg =="Y") {
			// Rider print
			RiderPrintYn=true;
			if(getRadioValue2(form.paper_type) == '1'){
				strRiderPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_A4_Rider.mrd";
			}else if(getRadioValue2(form.paper_type) == '4'){
				strRiderPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_LETTER_Rider.mrd";
			}else if(getRadioValue2(form.paper_type) == '10'){
				strRiderPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DOT_Rider.mrd";
			}
			/*
			/rv form_bkgNo[(  'ATLZ4030031', 'TPEZ1295047', 'MUCZ3270004', 'HAMY5080012', 'SZPZ1145010', 'BKK6C135013' )]
				 form_hiddeData[N] ---> Default
				 form_level[(1)] ---> Default
				 form_Rate[] ---> Default
				 form_Cntr[1] ---> Default
				 form_gubun[M] ---> Default
				 form_CorrNo[] ---> Default
				 form_his_cntr[BKG_CONTAINER] ---> Default
				 form_his_bkg[BKG_BOOKING] ---> Default
				 form_his_mkd[BKG_BL_MK_DESC] ---> Default
				 form_his_xpt[BKG_XPT_IMP_LIC] ---> Default
				 form_his_bl[BKG_BL_DOC] ---> Default
			/rp [] ---> Default
			/riprnmargin
			*/
			rdParam_Rider="/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
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
			rdParam_Rider += "form_type[" + formType + "] "; // form_type
			rdParam_Rider += "form_rqst_via_cd[] "; // form_rqst_via_cd
			rdParam_Rider += "form_his_bl_mkd[" + formHisBlMkd + "] "; // form_his_bl_mkd
			rdParam_Rider += "form_end_no[" + totalPage +"] "; // form_end_no
			rdParam_Rider += "form_path[" + getFileDownPath() + "] "; // form_path
			rdParam_Rider += "form_esig[] "; // form_esig
			rdParam_Rider += "form_cpy_esig[] "; // form_cpy_esig
			rdParam_Rider += "form_knt_flg[] "; // form_knt_flg
			rdParam_Rider += "form_count[] "; // form_count
			rdParam_Rider += "/rp [" + formCaYn + "] "; // form_caYn
			rdParam_Rider += "/riprnmargin /rmatchprndrv [3]";
		}
		Rdviewer_Face.SetMessageboxShow(1); //print only error message
		Rdviewer_Face.FileOpen(strFacePath, RDServer + rdParam_Face);
		if (RiderPrintYn) {
			Rdviewer_Rider.SetMessageboxShow(1); //print only error message
			Rdviewer_Rider.FileOpen(strRiderPath, RDServer + rdParam_Rider);
		}
		//alert("Face_PrnCnt : [" + Face_PrnCnt + "]\n\n" + "RiderPrintYn : [" + RiderPrintYn + "]\n" + "Rider_PrnCnt : [" + Rider_PrnCnt + "]");
		//return;
		if(	form_type.GetSelectCode()== "4" && bl_cpy_knt > 0){//################# Original B/L
			Face_PrnCnt=bl_cpy_knt;
//			Rider_PrnCnt = bl_cpy_knt;
		}
		if ( Face_PrnCnt > 0 ) {
			// Face
			Rdviewer_Face.SetPrintInfo (Face_PrnDrv, parseInt(Face_PrnCnt), 1, 4);
			//alert("Face_PrnDrv : [" + Face_PrnDrv + "]\n\n" + "Face_PrnCnt : [" + Face_PrnCnt + "]");
			Rdviewer_Face.SetPrint2(parseInt(getRadioValue2(form.paper_type)),1,0,100);
			Rdviewer_Face.CMPrint();
		}
		if (RiderPrintYn == true && Rider_PrnCnt > 0) {
			//alert("RiderPrintYn : [" + RiderPrintYn + "]");
			Rdviewer_Rider.SetPrintInfo (Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
			//alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt : [" + Rider_PrnCnt + "]");
			Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)),1,0,100);
			Rdviewer_Rider.CMPrint();
		}
		if ( (formObject.nvocc_only_yn.disabled == false && formObject.nvocc_only_yn.checked == true) ||
			 (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true) ) {
			rdParam_Hb="/rv form_bkgNo[( '" + bkgNo + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";
			strHbPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D.mrd";
			Rdviewer_Hb.SetMessageboxShow(1); //print only error message
			Rdviewer_Hb.FileOpen(strHbPath, RDServer + rdParam_Hb);
			Rdviewer_Hb.SetPrintInfo (Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
			Rdviewer_Hb.SetPrint2(parseInt(getRadioValue2(form.paper_type)),1,0,100);
			Rdviewer_Hb.CMPrint();
		}
	}

	//전체 페이지 숫자를 알기위해 formMainOnly='N'로 하여 Face를 실행 한다.
	function rdOpenStart(formObject, RiderYn, HBYn,p_bkg_no,bl_cpy_knt,obl_rider_flg){
		var Rdviewer_Total = document.form.report4;    // for IE11
		if (Rdviewer_Total == undefined) Rdviewer_Total = report4;    // for Chrome
		//ComOpenWait(true);
		var RiderPrintYn=false;
		var rdParam_Face="";
		var strFacePath="";
		var bkgNo=p_bkg_no; // bkg_no
		var formType=form_type.GetSelectCode(); // form_type
		var formDataOnly=formObject.preview_yn.checked == true ? "N" : "Y"; // Preview
		var formManifest=formObject.form_manifest.value; // form_manifest
		var formUserId=formObject.usr_id.value; // form_usrId
		var formHiddenData=formObject.hiddenData.checked == true ? "Y" : "N"; // form_hiddeData
		var formOfcCd=formObject.ofc_cd.value; // ofc_cd
		// ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)")
		var formRemark=ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)"); // form_remark
		formRemark=ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(formRemark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
		var formRate=form_Rate.GetSelectCode(); // form_Rate
		var formCntr=form_Cntr.GetSelectCode(); // form_Cntr
		//var formMainOnly = (formObject.rider_only_yn.disabled == false|| formObject.rider_nvocc_yn.disabled == false) ? "N" : "Y"; // form_mainOnly
		var formMainOnly="N"; // form_mainOnly
		var formCorrNo=formObject.bl_ca_yn.checked == true ? formObject.ca_no.GetSelectCode(): ""; // form_CorrNo
		var formHisCntr=formObject.bl_ca_yn.checked == true ? "BKG_CNTR_HIS" : "BKG_CONTAINER"; // form_his_cntr
		var formHisBkg=formObject.bl_ca_yn.checked == true ? "BKG_BKG_HIS" : "BKG_BOOKING"; // form_his_bkg
		var formHisMkd=formObject.bl_ca_yn.checked == true ? "BKG_BL_MK_DESC_HIS" : "BKG_BL_MK_DESC"; // form_his_mkd
		var formHisXpt=formObject.bl_ca_yn.checked == true ? "BKG_XPT_IMP_LIC_HIS" : "BKG_XPT_IMP_LIC"; // form_his_xpt
		var formHisBl=formObject.bl_ca_yn.checked == true ? "BKG_BL_DOC_HIS" : "BKG_BL_DOC"; // form_his_bl
		var formHisBlMkd=formObject.bl_ca_yn.checked == true ? "BKG_BL_ISS_HIS" : "BKG_BL_ISS"; // form_his_bl_mkd
		var formCaYn=formObject.bl_ca_yn.checked == true ? "Y" : ""; // form_caYn
		var Face_PrnDrv=bl_face_prn_dvc_nm.GetSelectCode(); // Print Setup (Face)
		var Face_PrnCnt=formObject.face_print_cnt.value; // Print Count (Face)
		// Face
		if(getRadioValue2(form.paper_type) == '1'){
			strFacePath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
		}else if(getRadioValue2(form.paper_type) == '4'){
			strFacePath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
		}else if(getRadioValue2(form.paper_type) == '10'){
			strFacePath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_DOT.mrd";
		}
		/*
		/rv form_bkgNo[(  'ATLZ4030031', 'TPEZ1295047', 'MUCZ3270004', 'HAMY5080012', 'SZPZ1145010', 'BKK6C135013' )]
			 form_type[2] ---> Default
			 form_dataOnly[N] ---> Default
			 form_manifest[N] ---> Default
			 form_usrId[TES_AARBA] ---> Session
			 form_hiddeData[N] ---> Default
			 form_level[(1)] ---> Default (ex - (1,2,3,4,5))
			 form_remark[] ---> Default
			 form_Cntr[1] ---> Default
			 form_mainOnly[N] ---> Default
			 form_CorrNo[] ---> Default
			 form_his_cntr[BKG_CONTAINER] ---> Default
			 form_his_bkg[BKG_BOOKING] ---> Default
			 form_his_mkd[BKG_BL_MK_DESC] ---> Default
			 form_his_xpt[BKG_XPT_IMP_LIC] ---> Default
			 form_his_bl[BKG_BL_DOC] ---> Default
		/rp [] ---> Default
		/riprnmargin
		*/
		rdParam_Face="/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
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
		rdParam_Face += "form_rqst_via_cd[] "; //
		rdParam_Face += "form_his_bl_mkd[" + formHisBlMkd + "] "; // form_his_bl_mkd
		rdParam_Face += "form_path[" + getFileDownPath() + "] "; // form_path
		rdParam_Face += "form_esig[] "; // form_esig
		rdParam_Face += "form_cpy_esig[] "; // form_cpy_esig
		rdParam_Face += "form_knt_flg[] "; // form_knt_flg
		rdParam_Face += "form_count[] "; // form_count

		rdParam_Face += "/rp [" + formCaYn + "] "; // form_caYn
		rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
		if(formOfcCd == "BOMBB" || formOfcCd == "DELBS" || formOfcCd == "MAABS") {
			rdParam_Face += " /rpypos [25]";
		}
		Rdviewer_Total.FileOpen(strFacePath, RDServer + rdParam_Face);
		return Rdviewer_Total.GetTotalPageNo();
	}
	  /**
	 * control onBlur of HTML Control
	 **/
	function bkg_deactivate() {
		var formObj=document.form;
		switch (ComGetEvent("name")) {
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
	 * checking onFocus event of HTML Control Validation <br>
	 **/
	function bkg_activate(){
		//checking Validation
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
	 * change print sheet number option to 3<br>
	 **/
	function setPrintcnt(){
		if(form_type.GetSelectCode()== "0"){
			form.face_print_cnt.options[1].selected=true;
			form.rider_print_cnt.options[1].selected=true;
		} else if(form_type.GetSelectCode()== "1"){
			form.face_print_cnt.options[5].selected=true;
			form.rider_print_cnt.options[5].selected=true;
		} else if(form_type.GetSelectCode()== "2"){
			form.face_print_cnt.options[1].selected=true;
			form.rider_print_cnt.options[1].selected=true;
		} else if(form_type.GetSelectCode()== "3"){
			form.face_print_cnt.options[3].selected=true;
			form.rider_print_cnt.options[3].selected=true;
		} else if(form_type.GetSelectCode()== "4"){
			//if(save_face_print_cnt ==""){
//   			if(bl_cpy_knt == "0")
//   				form.face_print_cnt.options[3].selected = true;
//   			else
//   				form.face_print_cnt.options[eval(bl_cpy_knt)].selected = true;
		//}else{
		//	form.face_print_cnt.options[eval(save_face_print_cnt)].selected = true;
		//}
			form.face_print_cnt.options[3].selected=true; // FACE fixed
			if(save_rider_print_cnt ==""){
				form.rider_print_cnt.options[3].selected=true;
			}else{
				form.rider_print_cnt.options[eval(save_rider_print_cnt)].selected=true;
			}
			form.face_print_cnt.disabled=true;
			//form.rider_print_cnt.disabled = true;
			return;
		} else if(form_type.GetSelectCode()== "5"){
			form.face_print_cnt.options[1].selected=true;
			form.rider_print_cnt.options[1].selected=true;
		}
		form.face_print_cnt.disabled=false;
		form.rider_print_cnt.disabled=false;
	}
// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;

			switch(srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,MODIFY01);
					break;
				case "btn_Print":
					doPrint(sheetObject1, formObject);
					break;
				case "btn_Print_Release":
					doPrint(sheetObject1, formObject,true);
					break;
				case "btn_Print_Setup":
					print();
					break;
				case "btn_close":
					ComClosePopup();
					break;
				case "rider_only_yn":
					if(form.rider_only_yn.checked){
						form.nvocc_only_yn.checked=false;
						form.rider_nvocc_yn.checked=false;
					}
					break;
				case "nvocc_only_yn":
					if(form.nvocc_only_yn.checked){
						form.rider_only_yn.checked=false;
						form.rider_nvocc_yn.checked=false;
					}
					break;
				case "rider_nvocc_yn":
					if(form.rider_nvocc_yn.checked){
						form.nvocc_only_yn.checked=false;
						form.rider_only_yn.checked=false;
					}
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
	 * Different thing at condition is error in case of print
	 **/
	function doPrint(sheetObject1, formObject,releaseYn){
		if(formObject.face_print_cnt.value == '0' && formObject.rider_print_cnt.value == '0' ){
			formObject.face_print_cnt.focus();
			ComShowCodeMessage('BKG00394');
			return;
		}
		success_cnt=0;
		error_cnt=0;
		if(form_type.GetSelectCode()== "4"){//Original B/L
			if(obl_prn_flg == "Y"){
				ComShowCodeMessage('BKG08091');
				return;
			}
		}
		with (sheetObject1) {
			for (var i=HeaderRows(); i < HeaderRows()+ RowCount(); i++) {
				if(	form_type.GetSelectCode()== "4"){//################# Original B/L
					if(GetCellValue(i, "bl_tp_cd") == "W"){
						setError(i, msgs['BKG08089']);
						error_cnt++;
						continue;
					}else if( GetCellValue(i, "obl_prn_flg") == 'Y'){
						setError(i, msgs['BKG08091']);
						error_cnt++;
						continue;
					}else if(GetCellValue(i,"obl_iss_flg") == 'N'){
						setError(i, msgs['BKG08090']);
						error_cnt++;
						continue;
					}else if(GetCellValue(i,"obl_rlse_flg") == 'Y'){
						setError(i, msgs['BKG08098']);
						error_cnt++;
						continue;
					}else if( form_Cntr.GetSelectCode()== "4"  && GetCellValue(i,"bb_cgo_flg") == 'N'){
						setError(i, msgs['BKG08093']);
						error_cnt++;
						continue;
					}
					formObject.bkg_no.value=GetCellValue(i,"bkg_no");
					if(releaseYn){ // Print & Release
						if(GetCellValue(i,"org_ppd_rcv_cd") != "Y" || GetCellValue(i,"org_n3pty_ppd_cd") !="Y"){
								setError(i, msgs['BKG08079']);
								error_cnt++;
									continue;
							}
						if(!doActionIBSheet(sheetObject1,formObject,MODIFY02)){
								setError(i, "DB Error");
								error_cnt++;
								continue;
						}
						SetCellValue(i,"obl_rlse_flg",'Y');
					}else{// Print
						if(!doActionIBSheet(sheetObject1,formObject,MODIFY03)){
							setError(i, "DB Error");
							error_cnt++;
							continue;
						}
					}
					SetCellValue(i, "obl_prn_flg",'Y');
				//############### Original B/L End
				}else if( form_type.GetSelectCode()== '5' || form_type.GetSelectCode()== '6' ){
				//#################### Way B/L
					if(GetCellValue(i,"bl_tp_cd") != 'W'){
						setError(i, msgs['BKG08092']);
						error_cnt++;
						continue;
					}else{
						formObject.bkg_no.value=GetCellValue(i,"bkg_no");
						if(!doActionIBSheet(sheetObject1,formObject,MODIFY04)){
							setError(i, "DB Error");
							error_cnt++;
							continue;
						}
					}
				}
				ComOpenWait(true);
				rdStart(GetCellValue(i,"bkg_no"),GetCellValue(i,"bl_cpy_knt"),GetCellValue(i,"obl_rider_flg"));
				ComOpenWait(false);
				setSuccess(i);
				success_cnt++;
			}
		}
		if(	form_type.GetSelectCode()== "4"){//Original B/L
			obl_prn_flg="Y";
		}
		div_success.innerHTML=success_cnt;
		div_failure.innerHTML=error_cnt;
	}
	/**
	 * Different thing at condition is error in case of print
	 * */
	function setError(idx, msg){
		sheetObjects[0].SetCellValue(idx, "print_result",'ERR');
		sheetObjects[0].SetCellValue(idx, "remarks",msg);
		sheetObjects[0].SetCellFontColor(idx, "print_result","#FF0000");
		sheetObjects[0].SetCellFontColor(idx, "remarks","#FF0000");
	}
	/**
	 * handling success in case of print
	 * */
	function setSuccess(idx){
		sheetObjects[0].SetCellValue(idx, "print_result",'OK');
		sheetObjects[0].SetCellValue(idx, "remarks","");
		sheetObjects[0].SetCellFontColor(idx, "print_result","#000000");
		sheetObjects[0].SetCellFontColor(idx, "remarks","#000000");
	}
	/**
	 * BL_PRN_TP_CD||'>'||BL_PRN_CHG_TP_CD||'>'|| BL_PRN_CNTR_TP_CD||'>'||BL_FACE_PRN_KNT||'>'||BL_RIDR_PRN_KNT
	 */
	var bl_prn_setup="";
	/**
	 * variable for setting condition value according to B/L TYPE
	 * */
	var bl_prn_setup_Map=new Array();
	function setInitPrintSetup(val){
		if(val == ""){
			form_type.SetSelectCode('2');
			form_Rate.SetSelectCode('1');
			form_Cntr.SetSelectCode('1');
			pre_form_type=form_type.GetSelectCode();
			pre_container_type=form_Cntr.GetSelectCode();
			bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
			bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
			setPrintcnt();
			initYn=false;
			return;
		}
		bl_prn_setup=val;
		var arr_bl_prn_setup=bl_prn_setup.split("@");
		var arr_combo_setup=null;
		for(var i=0; i < arr_bl_prn_setup.length; i++){
			arr_combo_setup=arr_bl_prn_setup[i].split(">");
			
			bl_prn_setup_Map[arr_combo_setup[0]]=arr_bl_prn_setup[i];
			if(arr_combo_setup[0] == '2' ){
				form_type.SetSelectCode(arr_combo_setup[0]);
				pre_form_type=form_type.GetSelectCode();
				form_Rate.SetSelectCode(arr_combo_setup[1]);
				form_Cntr.SetSelectCode(arr_combo_setup[2]);
				face_print_cnt.options[arr_combo_setup[3]-1].selected=true;
				rider_print_cnt.options[arr_combo_setup[4]-1].selected=true;
				/************ print driver setting **********************/
				if(!checkPrintList(arr_combo_setup[5])){ //FACE_PRINT
					bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
				}else{
					bl_face_prn_dvc_nm.SetSelectCode(arr_combo_setup[5]);
				}
				if(!checkPrintList(arr_combo_setup[6])){//RIDER_PRINT
					bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
				}else{
					bl_ridr_prn_dvc_nm.SetSelectCode(arr_combo_setup[6]);
				}
				/************ print driver setting end **********************/
			}
		}
		if(form_type.GetSelectCode()!= '2'){
			form_type.SetSelectCode('2');
			form_Rate.SetSelectCode('1');
			form_Cntr.SetSelectCode('1');
			pre_form_type=form_type.GetSelectCode();
			pre_container_type=form_Cntr.GetSelectCode();
			bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
			bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
			setPrintcnt();
		}
		pre_container_type=form_Cntr.GetSelectCode();
		initYn=false;
	}
	/**
	 * The saved value in the DB is saved in a variable when option saves
	 * */
	function savePrintSetup(){
		bl_prn_setup_Map[form_type.GetSelectCode()]= form_type.GetSelectCode()+">"+form_Rate.GetSelectCode()+">"+form_Cntr.GetSelectCode()+">"+ComGetObjValue(form.face_print_cnt)+">"+ComGetObjValue(form.rider_print_cnt)+">"+bl_face_prn_dvc_nm.GetSelectCode()+">"+bl_ridr_prn_dvc_nm.GetSelectCode();
		}
	function setBtn_Print_Release(){
		if(form_type.GetSelectCode()== '4' && form.obl_rlse_flg.value != "Y"){
			ComBtnEnable("btn_Print_Release");
		}else{
			ComBtnDisable("btn_Print_Release");
		}
	}
/**
	 * Previously set value is set in case of changing form_type value
	 * @param comboObj
	 * @return
	 */
	var initYn=true;
	function form_type_OnChange(comboObj) {
		setBtn_Print_Release();
		if(initYn)		return;
		var formObject=document.form;
		if(comboObj.GetSelectCode()== '4' && obl_prn_flg == 'Y'){
			ComShowCodeMessage('BKG08091');
			form_type.SetSelectCode(pre_form_type);
			return;
		}
		pre_form_type=comboObj.GetSelectCode();
		if(bl_prn_setup_Map[comboObj.GetSelectCode()] == undefined){
			form_Rate.SetSelectCode('1');
			form_Cntr.SetSelectCode('1');
			pre_container_type=form_Cntr.GetSelectCode();
			bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
			bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
			setPrintcnt();
			return;
		}
		var arr_combo_setup=bl_prn_setup_Map[comboObj.GetSelectCode()].split(">");
		form_Rate.SetSelectCode(arr_combo_setup[1]);
		form_Cntr.SetSelectCode(arr_combo_setup[2]);
		pre_container_type=form_Cntr.GetSelectCode();
		if(comboObj.GetSelectCode()== '4'){
			if(arr_combo_setup[3]!= "")
				save_face_print_cnt=arr_combo_setup[3];
			if(arr_combo_setup[4]!= "")
				save_rider_print_cnt=arr_combo_setup[4];
			setPrintcnt();
		}else{
			form.face_print_cnt.options[arr_combo_setup[3]].selected=true;
			form.rider_print_cnt.options[arr_combo_setup[4]].selected=true;
			form.face_print_cnt.disabled=false;
			form.rider_print_cnt.disabled=false;
		}
		/************ print driver setting **********************/
		if(!checkPrintList(arr_combo_setup[5])){ //FACE_PRINT
			bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
		}else{
			bl_face_prn_dvc_nm.SetSelectCode(arr_combo_setup[5]);
		}
		if(!checkPrintList(arr_combo_setup[6])){//RIDER_PRINT
			bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
		}else{
			bl_ridr_prn_dvc_nm.SetSelectCode(arr_combo_setup[6]);
		}
		/************ print driver setting end **********************/
//		if(	comboObj.Code == "4"  && formObject.obl_rlse_flg.value == "Y"){
//			ComShowCodeMessage("BKG02019");
//		}
	}
	/**
	 * Previously set value is set in case of changing form_Rate value
	 * @param comboObj
	 * @return
	 */
	function form_Rate_OnChange(comboObj) {
	}

	/**
	 * Previously set value is set in case of changing form_Cntr value
	 * @param comboObj
	 * @return
	 */
	function form_Cntr_OnChange(comboObj) {
	}
	//handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case SEARCH02:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH02;
				formObj.f_cmd.value=SEARCH02;
				if(ComGetLenByByte(formObj.p_bkg_no.value) > 4000){
					formObj.bkg_no.value=getStringToClobString(formObj.p_bkg_no.value, 200)
				}else{
					formObj.bkg_no.value="'"+formObj.p_bkg_no.value+"'";
				}
				sheetObj.RemoveAll();
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				var sXmls=sheetObj.GetSearchData("ESM_BKG_0743GS.do", FormQueryString(formObj));
				var arrSXml=sXmls.split("|$$|");
				var sXml=arrSXml[0];
				conti_cd=ComGetEtcData(sXml, "conti_cd");
				if(conti_cd == 'M'){
					formObj.paper_type[1].checked=true;
				}
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.SetWaitImageVisible(0);
				sheetObj.RenderSheet(1);
				div_total.innerHTML=sheetObj.RowCount();
				ComXml2ComboItem(arrSXml[1], form_type, "val", "name");
				ComXml2ComboItem(arrSXml[2], form_Rate, "val", "name");
				ComXml2ComboItem(arrSXml[3], form_Cntr, "val", "name");
				setInitPrintSetup(ComGetEtcData(sXml, "bl_prn_setup"));
				break;
			case MODIFY01:        //save
				formObj.f_cmd.value=MODIFY01;
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var sParam="&"+ FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0743GS.do" , sParam);
				if (ComGetEtcData(sXml, "success_yn") =="Y"){
					savePrintSetup();
					ComShowCodeMessage('COM130102','Data');
				}else{
					ComShowCodeMessage('COM130103','Data');
				}
				break;
			case MODIFY02:        // OBL_PRN_FLG, OBL_RLSE_FLG update
				formObj.f_cmd.value=MODIFY02;
				var sParam="&obl_prn_flg=Y&released=Y&"+ FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0743GS.do" , sParam);
				if (ComGetEtcData(sXml, "success_yn") =="Y"){
					return true;
				}else{
					//ComShowCodeMessage('COM130103','Data');
					return false;
				}
				break;
			case MODIFY03:        // OBL_PRN_FLG update
				formObj.f_cmd.value=MODIFY02;
				var sParam="&obl_prn_flg=Y&"+ FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0743GS.do" , sParam);
				if (ComGetEtcData(sXml, "success_yn") =="Y"){
					return true;
				}else{
					//ComShowCodeMessage('COM130103','Data');
					return false;
				}
				break;
			case MODIFY04:        // OBL_PRN_FLG update
				formObj.f_cmd.value=MODIFY03;
				var sParam="&wbl_prn_flg=Y&"+ FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0743GS.do" , sParam);
				if (ComGetEtcData(sXml, "success_yn") =="Y"){
					return true;
				}else{
					//ComShowCodeMessage('COM130103','Data');
					return false;
				}
				break;
		}
	}
	/**
	 * handling process for input validation <br>
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return boolean
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
				if(bl_face_prn_dvc_nm.value == "" ){
					ComShowCodeMessage('BKG00626','Print Setup(Face)');
					return false;
				}
				break;
			}
			return true;
	}
	function isNullEtcData(xmlStr){
		var rtn=false;
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
		xmlDoc.loadXML(xmlStr);
		var xmlRoot=xmlDoc.documentElement;
		if(xmlRoot == null) return true;
		var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if(etcDataNode == null) return true;
		var etcNodes=etcDataNode.childNodes;
		if(etcNodes == null) return true;
		if(etcNodes.length == 0) rtn=true;
		return rtn;
	}
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":
				with (sheetObj) {
					var HeadTitle1=" |BKG No.|B/L No.|Result|Remarks|B/L Type|Special CGO|Issued|OB/L Print|Released|No. of OB/L|Rider YN|ORG PPD RCV CD | ORG N3PTY PPD CD|Sea Waybill Print";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							   {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no" },
							   {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_no" },
							   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"print_result" },
							   {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"remarks" },
							   {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_tp_cd" },
							   {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg" },
							   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"obl_iss_flg" },
							   {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"obl_prn_flg" },
							   {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"obl_rlse_flg" },
							   {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_cpy_knt" },
							   {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"obl_rider_flg" },
							   {Type:"Text",     Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"org_ppd_rcv_cd" },
							   {Type:"Text",     Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"org_n3pty_ppd_cd" },
							   {Type:"Text",     Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"wbl_prn_flg" }
							   ];
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(205);
				}
			break;
		}
	}

	function ca_no_OnChange(ComboObj, Index_Code, Text) {
		var formObject=document.form;
		if ( formObject.bl_ca_yn.checked ) {
//no support[check again]CLT 			var bComboUC=ComboObj.UseCode;
			//ComboObj.UseCode == true ? false : true;
			//alert("Index_Code : [" + Index_Code + "]\n\n" + "Text : [" + ComboObj.Text + "]");
			formObject.corr_no.value=Index_Code;
			Retrive(sheetObjects[0]);
			//ComboObj.UseCode = bComboUC;
		}
	}
