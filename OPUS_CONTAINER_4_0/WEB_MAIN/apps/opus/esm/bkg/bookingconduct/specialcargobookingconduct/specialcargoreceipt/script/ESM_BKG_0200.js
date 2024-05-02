/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0200.js
*@FileTitle  : Criteria for out guage calculation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_0200 : business script for esm_bkg_0200
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0; 
	var saveEnd="";
	var retFlag="";
	var rsltVal="";
	var saveFlg="";
	var requestFlg="";
	var cancelFlg="";
	var reqCancelFlg="";
	var messageFlg="";
	var chkFlg="";
//	var autoRequestCond="";  //"Y" means auto request is required. (Key Data is modified.)
//	var specialRequest="";  //"Y" means special request checked at server side. 
	//var saveEnd = "";
	//var rsltVal = "";
	var companyCode="";
	var unNoKeyEnter="";
	var imdgSegrGrpNone = 0;
	var provi_length=9;
	
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if (srcName != "btn_splitPop") {
				if (layList.style.display == "") {
					layList.style.display="none";
				}
			}
			if(ComGetBtnDisable(srcName)){
				return false;
			}
			switch (srcName) {
			case "btn_splitPop": 
				doActionIBSheet(sheetObject1, formObject, COMMAND04);
				break;
			case "btn_retrieve":
				if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
					doActionIBSheet(sheetObjects[0], document.form, SEARCH);
				}
				break;
			case "btn_attach":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
//					if(document.getElementById("bkg_no").value != document.getElementById("bl_no").value) {
//						ComShowMessage(ComGetMsg("BKG08356"));
//						return;
//					}
					var bkgNo=ComGetObjValue(formObject.bkg_no);
					if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
						ComShowMessage(ComGetMsg("BKG08356"));
						ComSetFocus(formObject.bkg_no);
	    				return;    				
	    			}					
					ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=D", 580, 520, "", "1,0", true);
				}
				break;
			case "btn_save":
//				autoRequestCond="N";
//				specialRequest="N";
				if(document.getElementById("bkg_no").value == "" || document.getElementById("bl_no").value == "") {
					return;
				}
				
//				if(document.getElementById("bkg_no").value != document.getElementById("bl_no").value) {
//					ComShowMessage(ComGetMsg("BKG08356"));
//					return;
//				}
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}				
				document.getElementById("button").value="N"; // N is for request. Not cancel request.
				document.getElementById("save_button").value="Y"; // Set Y to distinguish SAVE button process, not save process by REQUEST
				ComOpenWait(true); //add to show processing image
				setTimeout( function () {
//					if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					messageFlg="save";
					retFlag="N";
					saveChkFlg="Y"; // Y means validation is conducted before save logic
					set_imdg_un_no_spcl_provi_ctnt();	//2015.11.30 formdata -> sheet data 체크
					
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
					if (retFlag == "Y") { //retFlag Y is success.
						doActionIBSheet(sheetObjects[0], document.form, SEARCH);
					}
					//Auto request is conducted by server side
//					if ((retFlag == "Y") && (autoRequestCond == "Y") && (specialRequest == "Y") && ((document.getElementById("spcl_cgo_auth_cd").value=="R") || (document.getElementById("spcl_cgo_auth_cd").value=="Y"))) {
//						document.getElementById("button").value="N";
//						rsltVal="Y";
//						requestFlg="Y";
//						var layerUrl="VOP_SCG_0069.do?pop_type=B2";
//						var contents="<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
//
//						progressPop.innerHTML=contents;
//
//					}else{
						ComOpenWait(false);	//If it's auto request, keep waiting image.					
//					}
						
//					}
					

//					ComOpenWait(false);						
					
			    } , 100);
				break;
			case "btn_request":
				//add 2015/01/09
				document.getElementById("button").value="N";
				document.getElementById("save_button").value="N";
//				autoRequestCond="N";
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
//					if(document.getElementById("bkg_no").value != document.getElementById("bl_no").value) {
//						ComShowMessage(ComGetMsg("BKG08356"));
//						return;
//					}
					var bkgNo=ComGetObjValue(formObject.bkg_no);
					if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
						ComShowMessage(ComGetMsg("BKG08356"));
						ComSetFocus(formObject.bkg_no);
	    				return;    				
	    			}					
					var reqCnt=0;
					for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
							//get row count not cancel
							reqCnt++;
						}
					}
					// in case of row count not cancel is 0
					if (reqCnt < 1 && reqCancelFlg != "Y") {
						ComShowMessage(ComGetMsg("BKG08107"));
						return;
					}
					messageFlg="request";
					retFlag="N";
					var cntR=0;
					for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetCellValue(i, "ibflag") != "R") {
							cntR++;
						}
					}
					//  Blocking when saving after BDR 
					if (cntR > 0 && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y") {
						ComShowMessage(ComGetMsg("BKG00004"));
						chkFlg="Y";
						return;
					}
					// run request logic after saving in case of cntR > 0
					if (cntR > 0) {
						chkFlg="N";
						saveChkFlg="Y";
						requestFlg="Y";
						doActionIBSheet(sheetObjects[0], document.form, MULTI); //This process actually does not save. Only validation.
						if (chkFlg == "N") {
							rsltVal="Y";
							requestFlg="Y";
							var layerUrl="VOP_SCG_0069.do?pop_type=B2";
							var contents="<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
							
							progressPop.innerHTML=contents;
							
							
						}
						//run request logic without saving in case of cntR < 1	
					} else {
						rsltVal="Y";
						requestFlg="Y";
						var layerUrl="VOP_SCG_0069.do?pop_type=B2";
						var contents="<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
						
						progressPop.innerHTML=contents;
						

//						var url="VOP_SCG_0069.do?func=&pop_type=SR"+"&pop_mode=1";
//						ComOpenWindowCenter(url, "VOP_SCG_0069", 940, 682, true);
						
					}
				}
				break;
			//request cancel
			case "btn_cancel":
				document.getElementById("button").value="Y";
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
//					if(document.getElementById("bkg_no").value != document.getElementById("bl_no").value) {
//						ComShowMessage(ComGetMsg("BKG08356"));
//						return;
//					}
					var bkgNo=ComGetObjValue(formObject.bkg_no);
					if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
						ComShowMessage(ComGetMsg("BKG08356"));
						ComSetFocus(formObject.bkg_no);
	    				return;    				
	    			}					
					messageFlg="requestCancel";
					if (cancelFlg == "Y") {
						return;
					}
					retFlag="N";
					var cntR=0;
					for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetCellValue(i, "ibflag") != "R") {
							cntR++;
						}
					}
					if (cntR > 0) {
						// saveChkFlg = Y이면 저장 체크로직을 수행한다.
						ComShowMessage(ComGetMsg("BKG01129"));
						//saveChkFlg="Y";
						//doActionIBSheet(sheetObjects[0], document.form, MULTI);
						// run request cancel logic in case of saving data not exist	
					} else {
						rsltVal="Y";
						requestFlg="Y";
						reqCancelFlg="Y";
						var layerUrl="VOP_SCG_0069.do?pop_type=B2";
						var contents="<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
						progressPop.innerHTML=contents;
					}
				}
				break;
			//e-mail send
			case "btn_email":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
//					if(document.getElementById("bkg_no").value != document.getElementById("bl_no").value) {
//						ComShowMessage(ComGetMsg("BKG08356"));
//						return;
//					}
					var bkgNo=ComGetObjValue(formObject.bkg_no);
					if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
						ComShowMessage(ComGetMsg("BKG08356"));
						ComSetFocus(formObject.bkg_no);
	    				return;    				
	    			}
					sendMail();
				}
				break;
			//rd print
			case "btn_print":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
//					if(document.getElementById("bkg_no").value != document.getElementById("bl_no").value) {
//						ComShowMessage(ComGetMsg("BKG08356"));
//						return;
//					}
					var bkgNo=ComGetObjValue(formObject.bkg_no);
					if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
						ComShowMessage(ComGetMsg("BKG08356"));
						ComSetFocus(formObject.bkg_no);
	    				return;    				
	    			}
					goPrint();
				}
				break;
			//remark popup
			case "btn_Remark":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var url="ESM_BKG_0757.do";
					ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
				}
				break;
			//sheet row add
			case "row_add":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					rowAdd();
				}
				break;
			//add hidden sheet row and Html selectbox value
			case "btn_add":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					checkAdd();
				}
				break;
			// unNo popup
			case "imdg_class_button":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
//					ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + formObject.imdg_un_no.value + "&bkg_no=" + formObject.bkg_no.value, 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
					callPopup0204();
				}
				break;
			// sheet data copy popup(Container copy)
			case "btn_copy1":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var url="ESM_BKG_0735.do?copyFlg=Y";
					ComOpenWindowCenter(url, "ESM_BKG_0735", 415, 170, true);
				}
				break;
			//copy hidden sheet row and Html selectbox value (Detail Copy)
			case "btn_copy2":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					setSpclProviCtnt(getEditRowNo()); //Update value of imdg_un_no_spcl_provi_ctnt object
					var url="ESM_BKG_0735.do?copyFlg=N";
					ComOpenWindowCenter(url, "ESM_BKG_0735", 415, 450, true);
				}
				break;
			//package popup
			case "pkg_qty_type":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var in_imdg_pck_cd1=document.getElementById("in_imdg_pck_cd1").value;
					var in_imdg_pck_cd2=document.getElementById("in_imdg_pck_cd2").value;
					var intmd_imdg_pck_cd1=document.getElementById("intmd_imdg_pck_cd1").value;
					var intmd_imdg_pck_cd2=document.getElementById("intmd_imdg_pck_cd2").value;
					var out_imdg_pck_cd1=document.getElementById("out_imdg_pck_cd1").value;
					var out_imdg_pck_cd2=document.getElementById("out_imdg_pck_cd2").value;
					var in_imdg_pck_desc1=document.getElementById("in_imdg_pck_desc1").value;
					var in_imdg_pck_desc2=document.getElementById("in_imdg_pck_desc2").value;
					var intmd_imdg_pck_desc1=document.getElementById("intmd_imdg_pck_desc1").value;
					var intmd_imdg_pck_desc2=document.getElementById("intmd_imdg_pck_desc2").value;
					var out_imdg_pck_desc1=document.getElementById("out_imdg_pck_desc1").value;
					var out_imdg_pck_desc2=document.getElementById("out_imdg_pck_desc2").value;
					var in_imdg_pck_qty1=document.getElementById("in_imdg_pck_qty1").value;
					var in_imdg_pck_qty2=document.getElementById("in_imdg_pck_qty2").value;
					var intmd_imdg_pck_qty1=document.getElementById("intmd_imdg_pck_qty1").value;
					var intmd_imdg_pck_qty2=document.getElementById("intmd_imdg_pck_qty2").value;
					var out_imdg_pck_qty1=document.getElementById("out_imdg_pck_qty1").value;
					var out_imdg_pck_qty2=document.getElementById("out_imdg_pck_qty2").value;
					var hcdg_intmd_bc_rstr_desc=document.getElementById("hcdg_intmd_bc_rstr_desc").value;
					var hcdg_pck_rstr_desc=document.getElementById("hcdg_pck_rstr_desc").value;
					var hcdg_tnk_rstr_desc=document.getElementById("hcdg_tnk_rstr_desc").value;
					var ltd_qty=document.getElementById("ltd_qty").value;
					var imdg_lmt_qty_desc=document.getElementById("imdg_lmt_qty_desc").value;
					var imdg_expt_qty_cd=document.getElementById("imdg_expt_qty_cd").value;
					var imdg_expt_qty_desc=document.getElementById("imdg_expt_qty_desc").value;
					ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1=" + in_imdg_pck_cd1 + "&in_imdg_pck_cd2=" + in_imdg_pck_cd2 + "&intmd_imdg_pck_cd1=" + intmd_imdg_pck_cd1 + "&intmd_imdg_pck_cd2=" + intmd_imdg_pck_cd2 + "&out_imdg_pck_cd1=" + out_imdg_pck_cd1 + "&out_imdg_pck_cd2=" + out_imdg_pck_cd2 + "&in_imdg_pck_desc1=" + in_imdg_pck_desc1 + "&in_imdg_pck_desc2=" + in_imdg_pck_desc2
							+ "&intmd_imdg_pck_desc1=" + intmd_imdg_pck_desc1 + "&intmd_imdg_pck_desc2=" + intmd_imdg_pck_desc2 + "&out_imdg_pck_desc1=" + out_imdg_pck_desc1 + "&out_imdg_pck_desc2=" + out_imdg_pck_desc2 + "&in_imdg_pck_qty1=" + in_imdg_pck_qty1 + "&in_imdg_pck_qty2=" + in_imdg_pck_qty2 + "&intmd_imdg_pck_qty1=" + intmd_imdg_pck_qty1 + "&intmd_imdg_pck_qty2=" + intmd_imdg_pck_qty2
//							+ "&out_imdg_pck_qty1=" + out_imdg_pck_qty1 + "&out_imdg_pck_qty2=" + out_imdg_pck_qty2 + "&hcdg_intmd_bc_rstr_desc=" + hcdg_intmd_bc_rstr_desc + "&hcdg_pck_rstr_desc=" + hcdg_pck_rstr_desc + "&hcdg_tnk_rstr_desc=" + hcdg_tnk_rstr_desc + "&ltd_qty=" + ltd_qty + "&imdg_expt_qty_cd=" + imdg_expt_qty_cd, 710, 600, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
							+ "&out_imdg_pck_qty1=" + out_imdg_pck_qty1 + "&out_imdg_pck_qty2=" + out_imdg_pck_qty2 + "&hcdg_intmd_bc_rstr_desc=" + hcdg_intmd_bc_rstr_desc + "&hcdg_pck_rstr_desc=" + hcdg_pck_rstr_desc + "&hcdg_tnk_rstr_desc=" + hcdg_tnk_rstr_desc + "&ltd_qty=" + ltd_qty + "&imdg_lmt_qty_desc=" + imdg_lmt_qty_desc + "&imdg_expt_qty_cd=" + imdg_expt_qty_cd + "&imdg_expt_qty_desc=" + imdg_expt_qty_desc, 710, 610, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
							"ESM_BKG_0206");
				}
				break;
			//emer_no popup
			case "btn_emer_info":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var param = "?pop_type=OR&imdg_emer_no=" + formObject.ems_no.value + "&emer_rspn_gid_no=" + formObject.emer_rspn_gid_no.value + "&emer_rspn_gid_chr_no=" + formObject.emer_rspn_gid_chr_no.value + "&ctrl_temp_ctnt=" + formObject.ctrl_temp_ctnt.value + "&emer_temp_ctnt=" + formObject.emer_temp_ctnt.value
					          + "&erap_no=" + formObject.erap_no.value + "&erap_cntc_no=" + formObject.erap_cntc_no.value + "&erap_apro_ref_no=" + formObject.erap_apro_ref_no.value; 
//					ComOpenPopup("ESM_BKG_0770.do"+ param, 500, 220, "getCOM_EMER_NO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
					ComOpenPopup("ESM_BKG_0770.do"+ param, 500, 270, "getCOM_EMER_NO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
							"ESM_BKG_0770");
				}
				break;
			//sheet row delete
			case "row_delete":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					rowDelete();
				}
				break;
			//delete hidden sheet row and Html selectbox value
			case "btn_delete":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					deleteRows();
				}
				break;
			//Route Detail popup
			case "ts_route_vvd_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_1069.do?bkg_no=" + formObject.bkg_no.value, 800, 420, "", "1,0,1,1,1", true);
				}
				break;
			//
			case "btn_approval":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("VOP_SCG_1015.do?scg_flg=DG&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
				}
				break;
			//un information
			case "un_information_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var imdg_un_no=document.getElementById("imdg_un_no").value;//sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "imdg_un_no");
					var imdg_un_no_seq=document.getElementById("imdg_un_no_seq").value;//sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "imdg_un_no_seq");
					ComOpenWindowCenter("VOP_SCG_0001Pop.do?pop_mode=Y&imdg_un_no=" + imdg_un_no + "&imdg_un_no_seq=" + imdg_un_no_seq, "winUnInformation", "1230", "600", true);
				}
				break;
			//restrictions
			case "restrictions_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var bkg_no=document.getElementById("bkg_no").value;
					var imdg_un_no=document.getElementById("imdg_un_no").value;//sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "imdg_un_no");
					var imdg_un_no_seq=document.getElementById("imdg_un_no_seq").value;//sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "imdg_un_no_seq");
					var pol_cd=document.getElementById("pol_cd").value;
					var pod_cd=document.getElementById("pod_cd").value;
					var vsl_cd=document.getElementById("vsl_cd").value.substring(0, 4);
					var skd_voy_no=document.getElementById("vsl_cd").value.substring(4, 8);
					var skd_dir_cd=document.getElementById("vsl_cd").value.substring(8, 9);
					var slan_cd=document.getElementById("slan_cd").value;
					ComOpenWindowCenter("VOP_SCG_0021.do?bkg_no=" + bkg_no + "&imdg_un_no=" + imdg_un_no + "&imdg_un_no_seq=" + imdg_un_no_seq + "&pol_cd=" + pol_cd + "&pod_cd=" + pod_cd + "&vsl_cd=" + vsl_cd + "&skd_voy_no=" + skd_voy_no + "&skd_dir_cd=" + skd_dir_cd + "&slan_cd=" + slan_cd, "VOP_SCG_0021", 1200, 600, true);
				}
				break;
			//pre-checking reports
			case "pre_checking_reports_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					
					var url="VOP_SCG_0069.do?func=&pop_type=SR"+"&pop_mode=1";
					ComOpenWindowCenter(url, "VOP_SCG_0069", 940, 682, true);
					
//					ComOpenPopup("VOP_SCG_0069.do?pop_type=SR", 940, 980, "VOP_SCG_0069", "0,0,1,1,1,1,1", true, null, null, null, null, null, "yes");
				}
				break;
			
			case "btn_declarant":
				if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != ""){
					//check DG Cargo
//					doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
					
//					if(document.getElementById("dcgo_yn").value != "Y"){
//					var dg_cntr_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "dg_cntr_seq_original");
					var dg_cntr_seq=getCheckedDgCntrSeqRep();
					if(dg_cntr_seq==""||dg_cntr_seq=="-1"){
						ComShowMessage(ComGetMsg("BKG08331"));
						return;
					}
					
					var bkg_no=document.getElementById("bkg_no").value;
//					var dcgo_seq=document.getElementById("dcgo_seq").value;
//					var dg_cntr_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "dg_cntr_seq");
//					var param = "?pop_type=W&bkg_no="+bkg_no+"&dcgo_seq="+dcgo_seq+"&dg_cntr_seq="+dg_cntr_seq+"&dg_cntr_seq_upd="+getCheckedDgCntrSeq();
					var param = "?pop_type=W&bkg_no="+bkg_no+"&dg_cntr_seq="+dg_cntr_seq+"&dg_cntr_seq_upd="+getCheckedDgCntrSeq();
					ComOpenPopup("ESM_BKG_1300.do"+param,1200,580,"","0,0",true,false,0,0,0,"ESM_BKG_1300");
				}
				break;
			//dot references popup
			case "btn_dot_info":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var param = "?pop_type=W&dot_exp_no=" + formObject.dot_exp_no.value + "&dot_spcl_apro_no=" + formObject.dot_spcl_apro_no.value + "&dot_auth_no=" + formObject.dot_auth_no.value;
					ComOpenPopup("ESM_BKG_1301.do"+ param, 700, 280, "getCOM_DOT_INFO_POPUP", '0,0', true, false, 0, 0, 0,
							"ESM_BKG_1301");
				}
				break;
			//imdg_un_no_spcl_provi_ctnt
			case "btn_imdg_spcl_provi_no1": 
			case "btn_imdg_spcl_provi_no2": 
			case "btn_imdg_spcl_provi_no3": 
			case "btn_imdg_spcl_provi_no4": 
			case "btn_imdg_spcl_provi_no5": 
			case "btn_imdg_spcl_provi_no6": 
			case "btn_imdg_spcl_provi_no7": 
			case "btn_imdg_spcl_provi_no8":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					onPopupClick(srcName);
				}
				break;
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	// call at VOP_SCG_0069 ,need when pre-checking
	function getCgoSheet() {
		return sheetObjects[3];
	}
	// pre-checking...
	function setPreChkRslt(rslt) {
		if (requestFlg == "Y") {
			if (rslt == "P") {
				rsltVal="N";
				requestFlg="N";
				// pre-checking popup
//				ComOpenPopup("VOP_SCG_0069.do", 940, 950, "VOP_SCG_0069", "0,0,1,1,1,1,1", true);
				
				var url="VOP_SCG_0069.do?func="+"&pop_mode=1";
				ComOpenWindowCenter(url, "VOP_SCG_0069", 940, 682, true);
			} else {
				rsltVal="Y";
				saveChkFlg="N";
			}
		}
	}
	// request...
	function spRequest(pSheetObj) {
		for ( var k=1; k <= sheetObjects[3].RowCount(); k++) {
			if (sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
				sheetObjects[3].SetCellValue(i, "spcl_rqst_flg","N",0);
			}
		}
		for ( var i=2; i <= pSheetObj.RowCount()+ 1; i++) {
			var bkg_cntr_seq=pSheetObj.GetCellValue(i, "spcl_cntr_seq") + pSheetObj.GetCellValue(i, "spcl_cgo_seq");
			var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
			sheetObjects[3].SetCellValue(row, "spcl_rqst_desc",pSheetObj.GetCellValue(i, "reason"),0);
			sheetObjects[3].SetCellValue(row, "spcl_rqst_flg","Y",0);
			sheetObjects[3].SetCellValue(row, "apro_cd",sheetObjects[3].GetCellValue(row, "spcl_cgo_apro_cd"),0);
			if (pSheetObj.GetCellValue(i, "reason") != "") {
				rsltVal="Y";
				saveChkFlg="N";
			}
		}
		closeProgressPop();
	}
	function closeProgressPop() {
		ComOpenWait(true); //add to show processing image
		setTimeout( function () {
		if (rsltVal == "Y") {
			rsltVal="N";
			var iCnt=0;
			var uCnt=0;
			var dCnt=0;
			if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
				ComShowMessage(ComGetMsg("BKG08076"));
				ComOpenWait(false);
				return;
			}
			iCnt=sheetObjects[3].FindText("ibflag", "I", 0, 2);
			uCnt=sheetObjects[3].FindText("ibflag", "U", 0, 2);
			dCnt=sheetObjects[3].FindText("ibflag", "D", 0, 2);
			if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
				if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
					//if(ComShowConfirm(ComGetMsg("BKG00824"))){ 	
					requestFlg="N";
					saveChkFlg == "N";
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
					//}else{
					//	return;
					//} 					 				
				}
				if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") != "") {
					ComShowMessage(ComGetMsg("BKG08074"));
					ComOpenWait(false);
					return;
				}
				if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") == "") {
					ComShowMessage(ComGetMsg("BKG08075"));
					ComOpenWait(false);
					return;
				}
			} else {
				saveEnd="Y";
			}
			var ncCnt=0;
			var rCnt=0;
			var yCnt=0;
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
					ComShowMessage(ComGetMsg("BKG00500"));
					ComOpenWait(false);
					return;
				}
//				if ((document.getElementById("pol_cd").value).indexOf("CN") == "0") {
//					if (sheetObjects[3].GetCellValue(i, "imdg_clss_cd") == "5.1" || sheetObjects[3].GetCellValue(i, "imdg_clss_cd") == "5.2") {
//						ComShowMessage(ComGetMsg("BKG00963"));
//						ComOpenWait(false);
//						return;
//					}
//				}
				if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
					ncCnt++;
				}
				if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
					rCnt++;
				}
				if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
					yCnt++;
				}
			}
			if (saveEnd == "Y") {
//				if (autoRequestCond != "Y"){ //do not show confirmation message when auto request
					if(reqCancelFlg !="Y"){
//						if (ncCnt > 0) {
//							if (ComShowConfirm(ComGetMsg("BKG00521"))) {
//							} else {
//								ComOpenWait(false);
//								return;
//							}
//						}
//						if (rCnt > 0) {
//							if (confirm(ComGetMsg("BKG00522", document.getElementById("bkg_no").value))) {
//							} else {
//								ComOpenWait(false);
//								return;
//							}
//						}
//						if (yCnt > 0) {
//							if (ComShowConfirm(ComGetMsg("BKG00523", document.getElementById("bkg_no").value))) {
//							} else {
//								ComOpenWait(false);
//								return;
//							}
//						}
						//show confirmation message only one time
						if (yCnt > 0) {
							if (ComShowConfirm(ComGetMsg("BKG00523", document.getElementById("bkg_no").value))) {
							} else {
								ComOpenWait(false);
								return;
							}
						}else if (rCnt > 0) {
							if (confirm(ComGetMsg("BKG00522", document.getElementById("bkg_no").value))) {
							} else {
								ComOpenWait(false);
								return;
							}
						}else if (ncCnt > 0) {
							if (ComShowConfirm(ComGetMsg("BKG00521"))) {
							} else {
								ComOpenWait(false);
								return;
							}
						}
						
					}else{ //confirm request cancel 
						if (ComShowConfirm(ComGetMsg("BKG95003", "cancel request"))) {
						} else {
							ComOpenWait(false);
							return;
						}						
					}
//				}
				var reqCnt=0;
				if (reqCancelFlg != "Y") {
					for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
							sheetObjects[3].SetCellValue(i, "apro_cd","R",0);
							reqCnt++;
						}
					}
					if (reqCnt > 0) {
						doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
					} else {
						ComShowMessage(ComGetMsg("BKG08107"));
						ComOpenWait(false);
						return;
					}
				} else {
					reqCancelFlg="N";
					var Row=sheetObjects[3].FindText("DelChk", "1", 0, 2);
					sheetObjects[3].SetCellValue(Row, "apro_cd","C",0);
					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
				}
			}
			if (retFlag == "Y") {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			}
		}
		ComOpenWait(false);
	    } , 100);
	}
	/**
	 * Making parameter of Pre-Checking
	 */
	function makePreChkParam() {
		var sheetObj2=sheetObjects[3];
		var sParam="";
		for ( var i=sheetObj2.HeaderRows(); i <= sheetObj2.LastRow(); i++) {
//			if (sheetObj2.GetRowStatus(i) != 'D') {
			if ((sheetObj2.GetRowStatus(i) != 'D')&&(sheetObj2.GetCellValue(i,"spcl_cgo_apro_cd") != "C")) {
				for ( var j=0; j <= sheetObj2.LastCol(); j++) {
					if (sheetObj2.ColSaveName(j) != "") {
						sParam += sheetObj2.ColSaveName(j) + "=" + sheetObj2.GetCellValue(i, j) + "&";
					}
				}
			}
		}
		sParam += "rgn_shp_opr_cd=";
		sParam += "cgo_opr_cd="+companyCode;
		sParam += "&bkg_no=" + document.getElementById("bkg_no").value;
		sParam += "&vsl_cd=" + document.getElementById("vsl_cd").value.substring(0, 4);
		sParam += "&skd_voy_no=" + document.getElementById("vsl_cd").value.substring(4, 8);
		sParam += "&skd_dir_cd=" + document.getElementById("vsl_cd").value.substring(8, 9);
		sParam += "&crr_cd=" + document.getElementById("crr_cd").value;
		sParam += "&slan_cd=";
		sParam += "&pol_cd=" + document.getElementById("pol_cd").value;
		sParam += "&pod_cd=" + document.getElementById("pod_cd").value;
		return sParam;
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		for(var j=0; j<comboObjects.length; j++){
	        initCombo(comboObjects[j]);
	    }
		
		doActionIBSheet(sheetObjects[5],document.form,INIT);
		if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
		}
		//------------------------------------------------>
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}
		initControl();
	}
	 /**
	  * setting initial value of combo
	  * @param {IBMultiCombo} comboObj  comboObj
	  */
	  function initCombo(comboObj) {
	  	comboObj.SetMultiSelect(0);
	//  comboObj.UseCode = true;
	  	comboObj.SetColAlign(0, "left");
	  	comboObj.SetColAlign(1, "left");
	  	comboObj.SetColWidth(0, "60");
	  	comboObj.SetColWidth(1, "150");
	  	comboObj.SetMultiSeparator("|");
	  }
	  /**
	   * registering IBCombo Object as list
	   * adding process for list in case of needing batch processing with other items 
	   * defining list on the top of source
	   * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
	   **/
	   function setComboObject(combo_obj){
	     comboObjects[comboCnt++]=combo_obj;
	   }
	function sendMail() {
		var iCnt=sheetObjects[3].FindText("ibflag", "I", 0, 2);
		var uCnt=sheetObjects[3].FindText("ibflag", "U", 0, 2);
		var dCnt=sheetObjects[3].FindText("ibflag", "D", 0, 2);
		if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
			ComShowMessage(ComGetMsg("BKG00178"));
			return;
		}
		var date=new Date();
		var content="";
		content="SHIPPING<br><br>[ Dangerous Cargo ]<br>"
//				+ date.toString()
				+ date.toGMTString()
				+ "<br>Booking Number : " 
				+ document.getElementById("bkg_no").value 
				+ "<br>B/L Number : " 
				+ document.getElementById("bl_no").value 
				+ "<br>POL : " 
				+ document.getElementById("pol_cd").value 
				+ "<br>POD : " 
				+ document.getElementById("pod_cd").value 
				+ "<br>VVD/VESSEL NAME : " 
				+ document.getElementById("vsl_cd").value + " / "
				+ document.getElementById("vessel_nm").value 
				+ "<br>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (sheetObjects[3].GetCellValue(i, "spcl_apro_cd") != "C") {
				content += "1.  Container SEQ           : " + sheetObjects[3].GetCellValue(i, "spcl_cntr_seq") + "<br>";
				content += "2.  Container No.           : " + sheetObjects[3].GetCellValue(i, "cntr_no") + "<br>";
				content += "3.  EQ Type/Size            : " + sheetObjects[3].GetCellValue(i, "eq_tpsz") + "<br>";
				content += "4.  Cargo SEQ               : " + sheetObjects[3].GetCellValue(i, "spcl_cgo_seq") + "<br>";
				content += "5.  DG Ref No.              : " + sheetObjects[3].GetCellValue(i, "dcgo_ref_no") + "<br>";
				content += "6.  UN No.                  : " + sheetObjects[3].GetCellValue(i, "imdg_un_no") + "<br>";
				content += "7.  IMO Class               : " + sheetObjects[3].GetCellValue(i, "imdg_clss_cd") + "<br>";
				content += "8.  Net WGT/KG              : " + sheetObjects[3].GetCellText(i, "net_wgt") + "<br>";
				content += "9.  Grs WGT/KG              : " + sheetObjects[3].GetCellText(i, "grs_wgt") + "<br>";
				content += "10.  Proper Ship Name        : " + sheetObjects[3].GetCellValue(i, "prp_shp_nm") + "<br>";
				//content += "LTD QTY : " + sheetObjects[3].CellValue(i, "imdg_lmt_qty_flg") + "<br>";
				content += "11. HAZ. Contents           : " + sheetObjects[3].GetCellValue(i, "hzd_desc") + "<br>";
				content += "12. Flash Point/Cel         : " + sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") + "<br>";
				content += "13. Packing GRP             : " + sheetObjects[3].GetCellValue(i, "imdg_pck_grp_cd") + "<br>";
				if (sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd1") == "" && sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd2") == "" && sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd3") == "" && sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd4") == "") {
					content += "14. Sub Label                : <br>"
				} else {
					content += "14. Sub Label                : " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd1") + " / " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd2") + " / " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd3") + " / " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd4") + "<br>";
				}
				content += "15. Control Temp./Cel       : " + sheetObjects[3].GetCellValue(i, "ctrl_temp_ctnt") + "<br>";
				content += "16. Emergency Temp./Cel     : " + sheetObjects[3].GetCellValue(i, "emer_temp_ctnt") + "<br>";
				content += "17. PSA GRP                 : " + sheetObjects[3].GetCellValue(i, "psa_no") + "<br>";
				content += "18. Limited Quantity        : " + sheetObjects[3].GetCellValue(i, "imdg_lmt_qty_flg") + "<br>";
				content += "19. Excepted Quantity       : " + sheetObjects[3].GetCellValue(i, "imdg_expt_qty_flg") + "<br>";
				content += "20. Marine Pollutant        : " + sheetObjects[3].GetCellValue(i, "mrn_polut_flg") + "<br>";
				content += "21. Cargo Status            : " + sheetObjects[3].GetCellValue(i, "dcgo_sts_cd") + "<br>";
				content += "22. EMS No                  : " + sheetObjects[3].GetCellValue(i, "ems_no") + "<br>";
				content += "23. ERG                     : " + sheetObjects[3].GetCellValue(i, "emer_rspn_gid_no") + sheetObjects[3].GetCellValue(i, "emer_rspn_gid_chr_no") +  "<br>";
				content += "24. Emergency Contact       : " + sheetObjects[3].GetCellValue(i, "emer_cntc_phn_no_ctnt") + "<br>";
				content += "25. Outer Pack              : " ;
				if(sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty1") != 0){
					content += sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty1") + " X "+  sheetObjects[3].GetCellValue(i, "out_imdg_pck_desc1");
				}
				if(sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty2") != 0){
					content += "<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp;" + sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty2") + " X "+  sheetObjects[3].GetCellValue(i, "out_imdg_pck_desc2") ;
				}
				content += "<br>";
				//content += "Intermediate Pack 1 : " + sheetObjects[3].CellValue(i, "intmd_imdg_pck_qty1") + "<br>";
				//content += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + sheetObjects[3].CellValue(i, "intmd_imdg_pck_desc1") + "<br>";
				content += "26. Inner Pack              : ";
				if(sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty1") != 0){
					content += sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty1") + " X "+  sheetObjects[3].GetCellValue(i, "in_imdg_pck_desc1");
				}
				if (sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty2") != 0){
					content += "<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp;" + sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty2") + " X "+  sheetObjects[3].GetCellValue(i, "in_imdg_pck_desc2") ;
				}
				content += "<br>";
				content += "27. Net Explosive Weight/kg : " + sheetObjects[3].GetCellText(i, "net_explo_wgt") + "<br>";
				content += "28. Segregation Group       : " + sheetObjects[3].GetCellText(i, "imdg_segr_grp_no") + "<br>";
				content += "29. Residue Last Contained  : " + sheetObjects[3].GetCellText(i, "rsd_flg") + "<br>";
				content += "30. Remarks                 : " + sheetObjects[3].GetCellText(i, "diff_rmk") + "<br>";
				content += "<br>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
			}
		}
		document.form.com_content.value=content;
//		ComSendMailModal(false);
		ComSendMail();
	}
	function initControl() {
		axon_event.addListenerForm('click', 'obj_click', form);
		axon_event.addListenerForm('change', 'obj_change', form);
		axon_event.addListenerForm('keyup', 'obj_keyup', form);
		axon_event.addListenerForm('keypress', 'obj_keypress', form);
		axon_event.addListenerForm('blur', 'obj_blur', form);
		axon_event.addListenerForm('keydown', 'obj_keydown', form);
//		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		document.getElementById("pkg_qty_type").setAttribute("style", "font-weight: bold;color:red!important");
		applyShortcut();
	}
	function obj_click() {
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var find_row=getEditRowNo("");
		switch (event.srcElement.name) {
		case "grs_wgt":
			if (sheetObjects[3].GetCellValue(find_row, "grs_wgt") == "0") {
				document.getElementById("grs_wgt").value="";
			}
			break;
		case "net_wgt":
			if (sheetObjects[3].GetCellValue(find_row, "net_wgt") == "0") {
				document.getElementById("net_wgt").value="";
			}
			break;
//		case "cfr_flg":
//			if(document.form.cfr_flg.checked){
//    			sheetObjects[3].SetCellValue(find_row, "cfr_flg", "Y");
//    		}else{
//    			sheetObjects[3].SetCellValue(find_row, "cfr_flg", "N");
//    		}
		}
	}
	function getCOM_UNNO_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var opener_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var opener_row=getEditRowNo("");
		document.getElementById("imdg_un_no").value=colArray[2];
		document.getElementById("imdg_un_no_seq").value=colArray[3];
//		if(490<=Number(colArray[3])){
		if(colArray[37]=="Y"){
			document.getElementById("cfr_flg").checked = true;
			sheetObjects[3].SetCellValue(opener_row, "cfr_flg","Y",0);
		}else{
			document.getElementById("cfr_flg").checked = false;
			sheetObjects[3].SetCellValue(opener_row, "cfr_flg","N",0);
		}
		document.getElementById("imdg_clss_cd").value=colArray[4];
		document.getElementById("imdg_comp_grp_cd").value=colArray[5];
		document.getElementById("prp_shp_nm").value=colArray[7];
		document.getElementById("imdg_subs_rsk_lbl_cd1").value=colArray[10];
		document.getElementById("imdg_subs_rsk_lbl_cd2").value=colArray[11];
		document.getElementById("imdg_subs_rsk_lbl_cd3").value=colArray[12];
		document.getElementById("imdg_subs_rsk_lbl_cd4").value=colArray[13];
		document.getElementById("psa_no").value=colArray[15];
//		imdg_pck_grp_cd.SetSelectIndex(colArray[6]);	//packing group cd - idx로 저장
		setImdg_pck_grp_cdCombo(colArray[6]);
		document.getElementById("ems_no").value=colArray[17];
		document.getElementById("emer_rspn_gid_no").value=colArray[18];
		document.getElementById("emer_rspn_gid_chr_no").value=colArray[19];
		document.getElementById("crr_cd").value=colArray[28];
		document.getElementById("hzd_desc").value=colArray[9];
		document.getElementById("ltd_qty").value=colArray[20];
		document.getElementById("imdg_lmt_qty_desc").value=colArray[21];
		document.getElementById("hcdg_pck_rstr_desc").value=colArray[29];
		document.getElementById("hcdg_intmd_bc_rstr_desc").value=colArray[30];
		document.getElementById("hcdg_tnk_rstr_desc").value=colArray[31];
		document.getElementById("ctrl_temp_ctnt").value=colArray[32];
		document.getElementById("emer_temp_ctnt").value=colArray[33];
		document.getElementById("imdg_expt_qty_cd").value=colArray[22];
		document.getElementById("imdg_expt_qty_desc").value=colArray[23];
		document.getElementById("imdg_amdt_no").value=colArray[36];
		sheetObjects[3].SetCellValue(opener_row, "imdg_un_no",colArray[2],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_un_no_seq",colArray[3],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_clss_cd",colArray[4],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_comp_grp_cd",colArray[5],0);
		sheetObjects[3].SetCellValue(opener_row, "prp_shp_nm",colArray[7],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_subs_rsk_lbl_cd1",colArray[10],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_subs_rsk_lbl_cd2",colArray[11],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_subs_rsk_lbl_cd3",colArray[12],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_subs_rsk_lbl_cd4",colArray[13],0);
		sheetObjects[3].SetCellValue(opener_row, "psa_no",colArray[15],0);
		sheetObjects[3].SetCellValue(opener_row, "ltd_qty",colArray[20],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_lmt_qty_desc",colArray[21],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_expt_qty_cd",colArray[22],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_expt_qty_desc",colArray[23],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_pck_grp_cd",colArray[6],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_spcl_provi_no",colArray[26],0);
		//sheetObjects[3].CellValue2(opener_row, "imdg_crr_rstr_expt_cd") = colArray[24]; 
		sheetObjects[3].SetCellValue(opener_row, "imdg_mrn_polut_cd",colArray[16],0);
		sheetObjects[3].SetCellValue(opener_row, "ems_no",colArray[17],0);
		sheetObjects[3].SetCellValue(opener_row, "emer_rspn_gid_no",colArray[18],0);
		sheetObjects[3].SetCellValue(opener_row, "emer_rspn_gid_chr_no",colArray[19],0);
		sheetObjects[3].SetCellValue(opener_row, "crr_cd",colArray[28],0);
		sheetObjects[3].SetCellValue(opener_row, "hcdg_pck_rstr_desc",colArray[29],0);
		sheetObjects[3].SetCellValue(opener_row, "hcdg_intmd_bc_rstr_desc",colArray[30],0);
		sheetObjects[3].SetCellValue(opener_row, "hcdg_tnk_rstr_desc",colArray[31],0);
		sheetObjects[3].SetCellValue(opener_row, "ctrl_temp_ctnt",colArray[32],0);
		sheetObjects[3].SetCellValue(opener_row, "emer_temp_ctnt",colArray[33],0);
		sheetObjects[3].SetCellValue(opener_row, "hzd_desc",colArray[9],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_pck_grp_cd",colArray[6],0);
		sheetObjects[3].SetCellValue(opener_row, "imdg_amdt_no",colArray[36],0);
		if (colArray[24] == "Y") {
			document.getElementById("hcdg_flag").value="HCDG";
			sheetObjects[3].SetCellValue(opener_row, "hcdg_flg","Y",0);
		} else {
			document.getElementById("hcdg_flag").value="";
			sheetObjects[3].SetCellValue(opener_row, "hcdg_flg","N",0);
		}
		if (colArray[16] == "P") {
			document.form.mrn_polut_flg.value="Y";
			sheetObjects[3].SetCellValue(opener_row, "mrn_polut_flg","Y",0);
		} else {
			document.form.mrn_polut_flg.value="N";
			sheetObjects[3].SetCellValue(opener_row, "mrn_polut_flg","N",0);
		}
		if ((colArray[20] == "" || colArray[20] == "0") && colArray[21] == ""){
			document.form.imdg_lmt_qty_flg.value="N";
			sheetObjects[3].SetCellValue(opener_row, "imdg_lmt_qty_flg","N",0);
		}
		if ((colArray[22] == "" || colArray[22] == "E0") && colArray[23] == "") {
			document.form.imdg_expt_qty_flg.value="N";
			sheetObjects[3].SetCellValue(opener_row, "imdg_expt_qty_flg","N",0);
		}
		if (colArray[28] != "") {
			sheetObjects[3].SetCellValue(opener_row, "imdg_crr_rstr_expt_cd","R",0);
		}
		temp_imdg_un_no=document.getElementById("imdg_un_no").value;
		
		//set imdg_segr_grp_no1~4
		setImdg_segr_grp_nos(colArray[35]);
		sheetObjects[3].SetCellValue(opener_row, "imdg_segr_grp_nos",colArray[35],0);
		
		if(colArray[7].indexOf("N.O.S")>-1){
			if(imdgSegrGrpNone != 0){
				comboObjects[2].SetSelectIndex(imdgSegrGrpNone);
			}
		}else if(colArray[35]==""){
			comboObjects[2].SetSelectIndex(0);
		}
		// #CSR 14449
		chkForFlshPnt(opener_row, "Y");
		document.form.grs_wgt.focus();
		document.form.grs_wgt.select();
	}
	function bkgSplitNoList(split_list) {
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	function getCOM_EMER_NO_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var row=getEditRowNo("");
		if (document.getElementById("ems_no").value != colArray[5]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}
		document.getElementById("ems_no").value=colArray[5];
		document.getElementById("emer_rspn_gid_no").value=colArray[7];
		document.getElementById("emer_rspn_gid_chr_no").value=colArray[8];
		document.getElementById("ctrl_temp_ctnt").value=colArray[6];
		document.getElementById("emer_temp_ctnt").value=colArray[9];
		document.getElementById("erap_no").value=colArray[10];
		document.getElementById("erap_cntc_no").value=colArray[11];
		document.getElementById("erap_apro_ref_no").value=colArray[12];
		sheetObjects[3].SetCellValue(row, "ems_no",colArray[5]);
		sheetObjects[3].SetCellValue(row, "emer_rspn_gid_no",colArray[7]);
		sheetObjects[3].SetCellValue(row, "emer_rspn_gid_chr_no",colArray[8]);
		sheetObjects[3].SetCellValue(row, "ctrl_temp_ctnt",colArray[6]);
		sheetObjects[3].SetCellValue(row, "emer_temp_ctnt",colArray[9]);
		sheetObjects[3].SetCellValue(row, "erap_no",colArray[10]);
		sheetObjects[3].SetCellValue(row, "erap_cntc_no",colArray[11]);
		sheetObjects[3].SetCellValue(row, "erap_apro_ref_no",colArray[12]);
	}
	function getCOM_PKG_QTY_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var row=getEditRowNo("");
		if (document.getElementById("out_imdg_pck_cd1").value != colArray[8]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}
		if (document.getElementById("out_imdg_pck_qty1").value != colArray[7]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}
		document.getElementById("in_imdg_pck_cd1").value=colArray[20];
		document.getElementById("in_imdg_pck_cd2").value=colArray[23];
		document.getElementById("out_imdg_pck_cd1").value=colArray[8];
		document.getElementById("out_imdg_pck_cd2").value=colArray[11];
		document.getElementById("in_imdg_pck_desc1").value=colArray[21];
		document.getElementById("in_imdg_pck_desc2").value=colArray[24];
		document.getElementById("out_imdg_pck_desc1").value=colArray[9];
		document.getElementById("out_imdg_pck_desc2").value=colArray[12];
		document.getElementById("in_imdg_pck_qty1").value=colArray[19];
		document.getElementById("in_imdg_pck_qty2").value=colArray[22];
		document.getElementById("out_imdg_pck_qty1").value=colArray[7];
		document.getElementById("out_imdg_pck_qty2").value=colArray[10];
		document.getElementById("intmd_imdg_pck_cd1").value=colArray[14];
		document.getElementById("intmd_imdg_pck_cd2").value=colArray[17];
		document.getElementById("intmd_imdg_pck_qty1").value=colArray[13];
		document.getElementById("intmd_imdg_pck_qty2").value=colArray[16];
		document.getElementById("intmd_imdg_pck_desc1").value=colArray[15];
		document.getElementById("intmd_imdg_pck_desc2").value=colArray[18];
		document.getElementById("hcdg_intmd_bc_rstr_desc").value=colArray[26];
		document.getElementById("hcdg_pck_rstr_desc").value=colArray[25];
		document.getElementById("hcdg_tnk_rstr_desc").value=colArray[27];
		document.getElementById("ltd_qty").value=colArray[28];
		document.getElementById("imdg_expt_qty_cd").value=colArray[29];
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd1",colArray[20],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd2",colArray[23],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd1",colArray[8],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd2",colArray[11],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc1",colArray[21],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc2",colArray[24],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc1",colArray[9],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc2",colArray[12],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty1",colArray[19],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty2",colArray[22],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty1",colArray[7],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty2",colArray[10],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd1",colArray[14],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd2",colArray[17],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty1",colArray[13],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty2",colArray[16],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc1",colArray[15],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc2",colArray[18],0);
		sheetObjects[3].SetCellValue(row, "hcdg_intmd_bc_rstr_desc",colArray[26],0);
		sheetObjects[3].SetCellValue(row, "hcdg_pck_rstr_desc",colArray[25],0);
		sheetObjects[3].SetCellValue(row, "hcdg_tnk_rstr_desc",colArray[27],0);
		sheetObjects[3].SetCellValue(row, "ltd_qty",colArray[28],0);
		sheetObjects[3].SetCellValue(row, "imdg_expt_qty_cd",colArray[29],0);
	}
	function obj_keydown() {
		if (event.keyCode == 13) { // Enter Key  			
			switch (event.srcElement.name) {
			case "bkg_no":
				document.getElementById("bkg_no").value=(document.getElementById("bkg_no").value).toUpperCase();
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
				break;
			case "bl_no":
				document.getElementById("bl_no").value=(document.getElementById("bl_no").value).toUpperCase();
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
				break;
			case "imdg_un_no":
//				ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + document.getElementById("imdg_un_no").value + "&bkg_no=" + document.getElementById("bkg_no").value, 900, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
				callPopup0204();
				unNoKeyEnter="Y"; //enter key pressed when cursor is in UN No.
				break;
			}
		}
	}
	var temp_imdg_un_no='';
	function obj_blur() {
		var formObj=document.form;
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var find_row=getEditRowNo("");
		switch (event.srcElement.name) {
		case "rada_amt":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("rada_amt").value=sheetObjects[3].GetCellText(find_row, "rada_amt")
			}
			break;
		case "net_explo_wgt":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("net_explo_wgt").value=sheetObjects[3].GetCellText(find_row, "net_explo_wgt")
			}
			break;
		case "certi_no":
			if (document.getElementById("bkg_no").value != "") {
				var certi_no=document.getElementById("certi_no").value;
				if (certi_no.length == "15") {
					sheetObjects[3].SetCellValue(find_row, "certi_no",document.getElementById("certi_no").value,0);
				}
				if (certi_no.length == "13") {
					document.getElementById("certi_no").value=certi_no.substr(0, 4) + "-" + certi_no.substr(4, 4) + "-" + certi_no.substr(8, 5);
					sheetObjects[3].SetCellValue(find_row, "certi_no",document.getElementById("certi_no").value,0);
				}
			}
			break;
		case "net_wgt":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
				if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
					ComAlertFocus(document.getElementById("net_wgt"), ComGetMsg("BKG00491"));
					document.getElementById("net_wgt").value=document.getElementById("temp_net_wgt").value;
					sheetObjects[3].SetCellValue(find_row, "net_wgt",document.getElementById("temp_net_wgt").value);
					document.getElementById("net_wgt").select();
				} else {
					document.getElementById("temp_net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
				}
				sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			}
			break;
		case "grs_wgt":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt");
				if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
					ComAlertFocus(document.getElementById("grs_wgt"), ComGetMsg("BKG00491"));
					document.getElementById("grs_wgt").value=document.getElementById("temp_grs_wgt").value;
					sheetObjects[3].SetCellValue(find_row, "grs_wgt",document.getElementById("temp_grs_wgt").value);
					document.getElementById("grs_wgt").select();
				} else {
					document.getElementById("temp_grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt")
				}
				sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);9
			}
			break;
		case "imdg_un_no":
			// open popup in case of default value deffirent 
			if ( temp_imdg_un_no  != document.getElementById("imdg_un_no").value) {
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					if(unNoKeyEnter==""){
//						ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + document.getElementById("imdg_un_no").value + "&bkg_no=" + document.getElementById("bkg_no").value, 900, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
						callPopup0204();
					}
				}
			}
			unNoKeyEnter="";
			break;
		case "frm_imdg_spcl_provi_no1": case "frm_imdg_spcl_provi_no2": case "frm_imdg_spcl_provi_no3": case "frm_imdg_spcl_provi_no4": case "frm_imdg_spcl_provi_no5": case "frm_imdg_spcl_provi_no6": case "frm_imdg_spcl_provi_no7": case "frm_imdg_spcl_provi_no8":
			if (ComGetEvent("value") != "") {
				for(i=1; i<9; i++){
					if (ComGetEvent("name") != eval("formObj.frm_imdg_spcl_provi_no"+i+".name")){
						if (event.srcElement.value == eval("formObj.frm_imdg_spcl_provi_no"+i+".value")) {
				    		ComShowCodeMessage('BKG00764', 'Data');
//							event.srcElement.value="";
				    		//ComGetEvent("value")="";
				    		ComSetObjValue(this, "");
		    	 			ComSetFocus(ComGetEvent());
							return;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
				sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);

			}
			break;
		}
	}
	function obj_keypress() {
		switch (event.srcElement.name) {
		case "grs_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "net_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "rada_amt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "net_explo_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "flsh_pnt_cdo_temp":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "imdg_un_no":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		}
	}
	function obj_change() {
		var row=sheetObjects[1].GetSelectRow();
		var imdg_clss_cd=document.getElementById("imdg_clss_cd").value;
		var imdg_subs_rsk_lbl_cd1=document.getElementById("imdg_subs_rsk_lbl_cd1").value;
		var imdg_subs_rsk_lbl_cd2=document.getElementById("imdg_subs_rsk_lbl_cd2").value;
		var imdg_subs_rsk_lbl_cd3=document.getElementById("imdg_subs_rsk_lbl_cd3").value;
		var imdg_subs_rsk_lbl_cd4=document.getElementById("imdg_subs_rsk_lbl_cd4").value;
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=0;
//		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
//	if (bkg_cntr_seq == sheetObjects[3].GetCellValue(i, "bkg_cntr_seq")) {
//				find_row=i;
//			}
//		}
		var find_row=getEditRowNo("");
		switch (ComGetEvent("name")) {
		case "cntr_cgo_seq":
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				sheetObjects[3].SetCellValue(i, "DelChk","0",0);
			}
			sheetObjects[3].SetCellValue(find_row, "DelChk","1",0);
			document.form.cntr_cgo_seq.value=sheetObjects[3].GetCellValue(find_row, "cntr_cgo_seq");
			document.getElementById("imdg_clss_cd").value = sheetObjects[3].GetCellValue(find_row, "imdg_clss_cd");
			if("Y"==sheetObjects[3].GetCellValue(find_row, "cfr_flg")){
				document.getElementById("cfr_flg").checked = true;
			}else{
				document.getElementById("cfr_flg").checked = false;
			}
			document.getElementById("imdg_comp_grp_cd").value = sheetObjects[3].GetCellValue(find_row, "imdg_comp_grp_cd");
			document.getElementById("imdg_un_no").value=sheetObjects[3].GetCellValue(find_row, "imdg_un_no");
			document.getElementById("imdg_un_no_seq").value=sheetObjects[3].GetCellValue(find_row, "imdg_un_no_seq");
			document.getElementById("grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt");
			document.getElementById("net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
			document.getElementById("temp_grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt");
			document.getElementById("temp_net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
			document.getElementById("prp_shp_nm").value=sheetObjects[3].GetCellValue(find_row, "prp_shp_nm");
			document.getElementById("hzd_desc").value=sheetObjects[3].GetCellValue(find_row, "hzd_desc");
			document.getElementById("flsh_pnt_cdo_temp").value=sheetObjects[3].GetCellValue(find_row, "flsh_pnt_cdo_temp");
			document.getElementById("imdg_amdt_no").value=sheetObjects[3].GetCellValue(find_row, "imdg_amdt_no");
//			imdg_pck_grp_cd.SetSelectIndex(sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd"));		//packing group cd - idx로 저장
			setImdg_pck_grp_cdCombo(sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd"));
			document.getElementById("psa_no").value=sheetObjects[3].GetCellValue(find_row, "psa_no");
			document.form.imdg_lmt_qty_flg.value=sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_flg");
			document.form.imdg_expt_qty_flg.value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_flg");
			
			if (sheetObjects[3].GetCellValue(find_row, "hcdg_flg") == "Y") {
				document.getElementById("hcdg_flag").value="HCDG"
			} else {
				document.getElementById("hcdg_flag").value="";
			}
			if (sheetObjects[3].RowCount()> 0 && sheetObjects[3].GetCellValue(find_row, "diff_rmk").length > 1) {
				document.getElementById("btn_Remark").setAttribute("style", "font-weight: bold;color:blue!important");
			} else {
				document.getElementById("btn_Remark").setAttribute("style", "color:##A0BAED!important");
			}
			if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "Y") {
				document.getElementById("approved").setAttribute("style", "color:black!important");
				document.getElementById("approved").innerHTML="approved";
			} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "N") {
				document.getElementById("approved").setAttribute("style", "color:red!important");
				document.getElementById("approved").innerHTML="Rejected";
			} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "R") {
				document.getElementById("approved").setAttribute("style", "color:blue!important");
				document.getElementById("approved").innerHTML="Requested";
			} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "P") {
				document.getElementById("approved").setAttribute("style", "color:black!important");
				document.getElementById("approved").innerHTML="Pending";
			} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "C") {
				document.getElementById("approved").setAttribute("style", "color:black!important");
				document.getElementById("approved").innerHTML="Canceled";
			} else {
				document.getElementById("approved").innerHTML="";
			}
			document.getElementById("imdg_subs_rsk_lbl_cd1").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd1");
			document.getElementById("imdg_subs_rsk_lbl_cd2").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd2");
			document.getElementById("imdg_subs_rsk_lbl_cd3").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd3");
			document.getElementById("imdg_subs_rsk_lbl_cd4").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd4");
			dcgo_sts_cd.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "dcgo_sts_cd"));
			document.form.mrn_polut_flg.value=sheetObjects[3].GetCellValue(find_row, "mrn_polut_flg");
			document.getElementById("emer_cntc_phn_no_ctnt").value=sheetObjects[3].GetCellValue(find_row, "emer_cntc_phn_no_ctnt");
			document.getElementById("emer_cntc_pson_nm").value=sheetObjects[3].GetCellValue(find_row, "emer_cntc_pson_nm");
			document.getElementById("certi_no").value=sheetObjects[3].GetCellValue(find_row, "certi_no");
			document.getElementById("cnee_dtl_desc").value=sheetObjects[3].GetCellValue(find_row, "cnee_dtl_desc");
			document.getElementById("net_explo_wgt").value=sheetObjects[3].GetCellValue(find_row, "net_explo_wgt");
			document.getElementById("rada_skd_no").value=sheetObjects[3].GetCellValue(find_row, "rada_skd_no");
			document.getElementById("rada_amt").value=sheetObjects[3].GetCellValue(find_row, "rada_amt");
			rada_ut_cd.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "rada_ut_cd"));
			document.getElementById("rada_trsp_no").value=sheetObjects[3].GetCellValue(find_row, "rada_trsp_no");
			document.getElementById("crr_cd").value=sheetObjects[3].GetCellValue(find_row, "crr_cd");
			document.getElementById("in_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd1");
			document.getElementById("in_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd2");
			document.getElementById("intmd_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_cd1");
			document.getElementById("intmd_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_cd2");
			document.getElementById("out_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd1");
			document.getElementById("out_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd2");
			document.getElementById("in_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_desc1");
			document.getElementById("in_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_desc2");
			document.getElementById("intmd_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_desc1");
			document.getElementById("intmd_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_desc2");
			document.getElementById("out_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_desc1");
			document.getElementById("out_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_desc2");
			document.getElementById("in_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty1");
			document.getElementById("in_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty2");
			document.getElementById("intmd_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_qty1");
			document.getElementById("intmd_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_qty2");
			document.getElementById("imdg_expt_qty_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_cd");
			document.getElementById("imdg_expt_qty_desc").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_desc");
			document.getElementById("out_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty1");
			document.getElementById("out_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty2");
			document.getElementById("max_in_pck_qty").value=sheetObjects[3].GetCellValue(find_row, "max_in_pck_qty");
			document.getElementById("max_in_pck_tp_cd").value=sheetObjects[3].GetCellValue(find_row, "max_in_pck_tp_cd");
			document.getElementById("hcdg_intmd_bc_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_intmd_bc_rstr_desc");
			document.getElementById("hcdg_pck_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_pck_rstr_desc");
			document.getElementById("hcdg_tnk_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_tnk_rstr_desc");
			document.getElementById("ltd_qty").value=sheetObjects[3].GetCellValue(find_row, "ltd_qty");
			document.getElementById("imdg_lmt_qty_desc").value=sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_desc");
			document.getElementById("ems_no").value=sheetObjects[3].GetCellValue(find_row, "ems_no");
			document.getElementById("emer_rspn_gid_no").value=sheetObjects[3].GetCellValue(find_row, "emer_rspn_gid_no");
			document.getElementById("emer_rspn_gid_chr_no").value=sheetObjects[3].GetCellValue(find_row, "emer_rspn_gid_chr_no");
			document.getElementById("ctrl_temp_ctnt").value=sheetObjects[3].GetCellValue(find_row, "ctrl_temp_ctnt");
			document.getElementById("emer_temp_ctnt").value=sheetObjects[3].GetCellValue(find_row, "emer_temp_ctnt");
			document.getElementById("diff_rmk").value=sheetObjects[3].GetCellValue(find_row, "diff_rmk");
			document.getElementById("clod_flg").value=sheetObjects[3].GetCellValue(find_row, "clod_flg");
			document.getElementById("rc_flg").value=sheetObjects[3].GetCellValue(find_row, "rc_flg");
			document.getElementById("awk_cgo_flg").value=sheetObjects[3].GetCellValue(find_row, "awk_cgo_flg");
			document.getElementById("bb_cgo_flg").value=sheetObjects[3].GetCellValue(find_row, "bb_cgo_flg");
			document.getElementById("hcdg_flg").value=sheetObjects[3].GetCellValue(find_row, "hcdg_flg");
			document.getElementById("meas_qty").value=sheetObjects[3].GetCellValue(find_row, "meas_qty");
			document.getElementById("hcdg_dpnd_qty_flg").value=sheetObjects[3].GetCellValue(find_row, "hcdg_dpnd_qty_flg");
			document.getElementById("dcgo_seq").value=sheetObjects[3].GetCellValue(find_row, "dcgo_seq");
			document.getElementById("aply_no").value=sheetObjects[3].GetCellValue(find_row, "aply_no");
			if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "C" || sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "") {
				document.getElementById("btn_cancel").disabled=true;
				cancelFlg="Y";
			} else {
				document.getElementById("btn_cancel").disabled=false;
				cancelFlg="N";
			}
			temp_imdg_un_no=document.getElementById("imdg_un_no").value;
			imdg_segr_grp_no.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "imdg_segr_grp_no"));
			document.form.rsd_flg.value=sheetObjects[3].GetCellValue(find_row, "rsd_flg");
			document.form.dcgo_ref_no.value=sheetObjects[3].GetCellValue(find_row, "dcgo_ref_no");
			
			setImdg_segr_grp_nos(sheetObjects[3].GetCellValue(find_row, "imdg_segr_grp_nos"));
			
			//2015.11.24. erap
			document.getElementById("erap_no").value=sheetObjects[3].GetCellValue(find_row, "erap_no");
			document.getElementById("erap_cntc_no").value=sheetObjects[3].GetCellValue(find_row, "erap_cntc_no");
			document.getElementById("erap_apro_ref_no").value=sheetObjects[3].GetCellValue(find_row, "erap_apro_ref_no");
			//2015.11.25. dot references
			document.getElementById("dot_exp_no").value=sheetObjects[3].GetCellValue(find_row, "dot_exp_no");
			document.getElementById("dot_spcl_apro_no").value=sheetObjects[3].GetCellValue(find_row, "dot_spcl_apro_no");
			document.getElementById("dot_auth_no").value=sheetObjects[3].GetCellValue(find_row, "dot_auth_no");
			//2015.11.26. IMDG_UN_NO_SPCL_PROVI_CTNT(provi_no^dp_seq|)
			setProviNo(sheetObjects[3].GetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt"));
			chkForFlshPnt(find_row, "N");
			break;
			
		case "imdg_lmt_qty_flg":
			if ((sheetObjects[3].GetCellValue(find_row, "ltd_qty") == "" || sheetObjects[3].GetCellValue(find_row, "ltd_qty") == "0") && sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_desc") == "") {
				if (document.form.imdg_lmt_qty_flg.value == "Y") {
					ComShowMessage(ComGetMsg("BKG00543"));
					document.form.imdg_lmt_qty_flg.value="N";
					sheetObjects[3].SetCellValue(find_row, "imdg_lmt_qty_flg","N",0);
				} else {
					sheetObjects[3].SetCellValue(find_row, "imdg_lmt_qty_flg",document.form.imdg_lmt_qty_flg.value,0);
				}
			} else {
				sheetObjects[3].SetCellValue(find_row, "imdg_lmt_qty_flg",document.form.imdg_lmt_qty_flg.value,0);
			}
			break;
		case "imdg_expt_qty_flg":
			if ((sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_cd") == "" || sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_cd") == "E0") && sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_desc") == "" ) {
				if (document.form.imdg_expt_qty_flg.value == "Y") {
					ComShowMessage(ComGetMsg("BKG00544"));
					document.form.imdg_expt_qty_flg.value="N";
					sheetObjects[3].SetCellValue(find_row, "imdg_expt_qty_flg","N",0);
				} else {
					sheetObjects[3].SetCellValue(find_row, "imdg_expt_qty_flg",document.form.imdg_expt_qty_flg.value,0);
				}
			} else {
				sheetObjects[3].SetCellValue(find_row, "imdg_expt_qty_flg",document.form.imdg_expt_qty_flg.value,0);
			}
			break;
			
		case "imdg_clss_cd":
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			// #CSR 14449
			chkForFlshPnt(find_row, "Y");
			break;
		case "imdg_un_no":
			sheetObjects[3].SetCellValue(find_row, "imdg_un_no",document.getElementById("imdg_un_no").value,0);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			// #CSR 14449
			chkForFlshPnt(find_row, "Y");
			break;
//		case "imdg_subs_rsk_lbl_cd1":
//			break;
//		case "imdg_subs_rsk_lbl_cd2":
//			break;
//		case "imdg_subs_rsk_lbl_cd3":
//			break;
//		case "imdg_subs_rsk_lbl_cd4":
//			break;
		case "mrn_polut_flg":
			if (sheetObjects[3].GetCellValue(find_row, "mrn_polut_flg") == "Y" && sheetObjects[3].GetCellValue(find_row, "imdg_mrn_polut_cd") == "P") {
				var imdg_un_no=sheetObjects[3].GetCellValue(find_row, "imdg_un_no");
				ComShowCodeMessage("BKG08039", imdg_un_no);
				document.form.mrn_polut_flg.value="Y";
				sheetObjects[3].SetCellValue(find_row, "mrn_polut_flg","Y",0);
			} else {
				sheetObjects[3].SetCellValue(find_row, "mrn_polut_flg",document.form.mrn_polut_flg.value,0);
				sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			}
			break;
		case "bkg_no":
			document.getElementById("bkg_no").value=(document.getElementById("bkg_no").value).toUpperCase();
			break;
		case "bl_no":
			document.getElementById("bl_no").value=(document.getElementById("bl_no").value).toUpperCase();
			break;
		case "dcgo_sts_cd":
			sheetObjects[3].SetCellValue(find_row, "dcgo_sts_cd", dcgo_sts_cd.GetSelectCode(),0);
			break;
		case "hzd_desc":
			sheetObjects[3].SetCellValue(find_row, "hzd_desc",document.getElementById("hzd_desc").value);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
		case "cnee_dtl_desc":
			sheetObjects[3].SetCellValue(find_row, "cnee_dtl_desc",document.getElementById("cnee_dtl_desc").value);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
		case "prp_shp_nm":
			sheetObjects[3].SetCellValue(find_row, "prp_shp_nm",document.getElementById("prp_shp_nm").value);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
		case "net_explo_wgt":
			sheetObjects[3].SetCellValue(find_row, "net_explo_wgt",document.getElementById("net_explo_wgt").value,0);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
		case "rada_skd_no":
			sheetObjects[3].SetCellValue(find_row, "rada_skd_no",document.getElementById("rada_skd_no").value,0);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
		case "rada_amt":
			sheetObjects[3].SetCellValue(find_row, "rada_amt",document.getElementById("rada_amt").value,0);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
		case "rada_ut_cd":
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			sheetObjects[3].SetCellValue(find_row, "rada_ut_cd",rada_ut_cd.GetSelectCode(),0);
			break;
		case "rada_trsp_no":
			formObj=document.form;
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			sheetObjects[3].SetCellValue(find_row, "rada_trsp_no",document.getElementById("rada_trsp_no").value,0);
			if(isNaN(document.getElementById("rada_trsp_no").value)){
				ComShowMessage(ComGetMsg("BKG08176"));
				ComSetFocus(formObj.rada_trsp_no);
			}
			break;
//		case "imdg_pck_grp_cd":
//			sheetObjects[3].SetCellValue(find_row, "imdg_pck_grp_cd",imdg_pck_grp_cd.SetSelectIndex(),0);	//packing group cd - idx로 저장
//			break;
		case "imdg_segr_grp_no":
			sheetObjects[3].SetCellValue(find_row, "imdg_segr_grp_no", imdg_segr_grp_no.GetSelectCode(),0);
			break;
		case "rsd_flg":
			sheetObjects[3].SetCellValue(find_row, "rsd_flg",document.form.rsd_flg.value,0);
			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			break;
			//2015.03.06 Add for paste by mouse operation.
		case "grs_wgt":
			if (document.getElementById("grs_wgt").value.length > 7) {
				if (document.getElementById("grs_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("grs_wgt").value=document.getElementById("grs_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[3].SetCellValue(find_row, "grs_wgt",document.getElementById("grs_wgt").value,0);
			break;
		case "net_wgt":
			if (document.getElementById("net_wgt").value.length > 7) {
				if (document.getElementById("net_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("net_wgt").value=document.getElementById("net_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[3].SetCellValue(find_row, "net_wgt",document.getElementById("net_wgt").value,0);
			break;
		case "flsh_pnt_cdo_temp":
			sheetObjects[3].SetCellValue(find_row, "flsh_pnt_cdo_temp",document.getElementById("flsh_pnt_cdo_temp").value,0);
			break;
		case "psa_no":
			sheetObjects[3].SetCellValue(find_row, "psa_no",document.getElementById("psa_no").value,0);
			break;
		case "emer_cntc_phn_no_ctnt":
			sheetObjects[3].SetCellValue(find_row, "emer_cntc_phn_no_ctnt", document.getElementById("emer_cntc_phn_no_ctnt").value,0);
			break;
		case "emer_cntc_pson_nm":
			sheetObjects[3].SetCellValue(find_row, "emer_cntc_pson_nm", document.getElementById("emer_cntc_pson_nm").value,0);
			break;			
		case "imdg_subs_rsk_lbl_cd1":
			sheetObjects[3].SetCellValue(find_row, "imdg_subs_rsk_lbl_cd1",document.getElementById("imdg_subs_rsk_lbl_cd1").value,0);
			// #CSR 14449
			chkForFlshPnt(find_row, "Y");
			break;
		case "imdg_subs_rsk_lbl_cd2":
			sheetObjects[3].SetCellValue(find_row, "imdg_subs_rsk_lbl_cd2",document.getElementById("imdg_subs_rsk_lbl_cd2").value,0);
			// #CSR 14449
			chkForFlshPnt(find_row,"Y");
			break;
		case "imdg_subs_rsk_lbl_cd3":
			sheetObjects[3].SetCellValue(find_row, "imdg_subs_rsk_lbl_cd3",document.getElementById("imdg_subs_rsk_lbl_cd3").value,0);
			// #CSR 14449
			chkForFlshPnt(find_row,"Y");
			break;
		case "imdg_subs_rsk_lbl_cd4":
			sheetObjects[3].SetCellValue(find_row, "imdg_subs_rsk_lbl_cd4",document.getElementById("imdg_subs_rsk_lbl_cd4").value,0);
			// #CSR 14449
			chkForFlshPnt(find_row, "Y");
			break;
		case "certi_no":
			sheetObjects[3].SetCellValue(find_row, "certi_no",document.getElementById("certi_no").value,0);
			break;
		case "frm_imdg_spcl_provi_no1": case "frm_imdg_spcl_provi_no2": case "frm_imdg_spcl_provi_no3": case "frm_imdg_spcl_provi_no4": case "frm_imdg_spcl_provi_no5": case "frm_imdg_spcl_provi_no6": case "frm_imdg_spcl_provi_no7": case "frm_imdg_spcl_provi_no8":
			//2015.11.27. imdg_un_no_spcl_provi_ctnt setting
//			var formObj=document.form;
//			var imdg_un_no_spcl_provi_ctnt = "";
//			for(i=1; i<9; i++){
//				if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != ""){
//					imdg_un_no_spcl_provi_ctnt += eval("formObj.frm_imdg_spcl_provi_no"+i+".value")+"^"+i+"|";
//					sheetObjects[3].SetCellValue(find_row, "imdg_spcl_provi_no"+i,eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//				}
//			}
////				imdg_un_no_spcl_provi_ctnt = imdg_un_no_spcl_provi_ctnt.substring(0,imdg_un_no_spcl_provi_ctnt.length-1);
//			if(imdg_un_no_spcl_provi_ctnt.length>0){
//				var str_length= imdg_un_no_spcl_provi_ctnt.length - 1; 
//				imdg_un_no_spcl_provi_ctnt = imdg_un_no_spcl_provi_ctnt.substring(0,str_length); //Remove last "|"
//				sheetObjects[3].SetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt",imdg_un_no_spcl_provi_ctnt,0);
//			}else{
//				sheetObjects[3].SetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt","",0);
//			}
			
			//Set screen object value to ibsheet "imdg_un_no_spcl_provi_ctnt"
			setSpclProviCtnt(find_row);
			break;

		}
	}
	function obj_keyup() {
		//var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
		//var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var row=getEditRowNo("");
		
		switch (event.srcElement.name) {
		case "cntr_cgo_seq":
			sheetObjects[3].SetCellValue(row, "cntr_cgo_seq",document.form.cntr_cgo_seq.value);
			break;
		case "imdg_clss_cd":
			sheetObjects[3].SetCellValue(row, "imdg_clss_cd",document.getElementById("imdg_clss_cd").value);
			break;
		case "imdg_comp_grp_cd":
			sheetObjects[3].SetCellValue(row, "imdg_comp_grp_cd",document.getElementById("imdg_comp_grp_cd").value);
			break;
		case "imdg_un_no":
			sheetObjects[3].SetCellValue(row, "imdg_un_no",document.getElementById("imdg_un_no").value);
			break;
		case "grs_wgt":
			if (document.getElementById("grs_wgt").value.length > 7) {
				if (document.getElementById("grs_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("grs_wgt").value=document.getElementById("grs_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[3].SetCellValue(row, "grs_wgt",document.getElementById("grs_wgt").value,0);
			break;
		case "net_wgt":
			if (document.getElementById("net_wgt").value.length > 7) {
				if (document.getElementById("net_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("net_wgt").value=document.getElementById("net_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[3].SetCellValue(row, "net_wgt",document.getElementById("net_wgt").value,0);
			break;
		case "prp_shp_nm":
			sheetObjects[3].SetCellValue(row, "prp_shp_nm",document.getElementById("prp_shp_nm").value,0);
			break;
		case "hzd_desc":
			sheetObjects[3].SetCellValue(row, "hzd_desc",document.getElementById("hzd_desc").value,0);
			break;
		case "flsh_pnt_cdo_temp":
			sheetObjects[3].SetCellValue(row, "flsh_pnt_cdo_temp",document.getElementById("flsh_pnt_cdo_temp").value,0);
			break;
		case "psa_no":
			sheetObjects[3].SetCellValue(row, "psa_no",document.getElementById("psa_no").value,0);
			break;
		case "imdg_lmt_qty_flg":
			sheetObjects[3].SetCellValue(row, "imdg_lmt_qty_flg",document.form.imdg_lmt_qty_flg.value,0);
			break;
		case "imdg_expt_qty_flg":
			sheetObjects[3].SetCellValue(row, "imdg_expt_qty_flg",document.form.imdg_expt_qty_flg.value,0);
			break;
		case "hcdg_flag":
			sheetObjects[3].SetCellValue(row, "hcdg_flg",document.getElementById("hcdg_flag").value,0);
			break;
		case "imdg_subs_rsk_lbl_cd1":
			sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd1",document.getElementById("imdg_subs_rsk_lbl_cd1").value,0);
			break;
		case "imdg_subs_rsk_lbl_cd2":
			sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd2",document.getElementById("imdg_subs_rsk_lbl_cd2").value,0);
			break;
		case "imdg_subs_rsk_lbl_cd3":
			sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd3",document.getElementById("imdg_subs_rsk_lbl_cd3").value,0);
			break;
		case "imdg_subs_rsk_lbl_cd4":
			sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd4",document.getElementById("imdg_subs_rsk_lbl_cd4").value,0);
			break;
		case "dcgo_sts_cd":
			sheetObjects[3].SetCellValue(row, "dcgo_sts_cd",dcgo_sts_cd.GetSelectCode(),0);
			break;
		case "mrn_polut_flg":
			sheetObjects[3].SetCellValue(row, "mrn_polut_flg",document.form.mrn_polut_flg.value,0);
			break;
		case "emer_cntc_phn_no_ctnt":
			sheetObjects[3].SetCellValue(row, "emer_cntc_phn_no_ctnt",document.getElementById("emer_cntc_phn_no_ctnt").value,0);
			break;
		case "emer_cntc_pson_nm":
			sheetObjects[3].SetCellValue(row, "emer_cntc_pson_nm",document.getElementById("emer_cntc_pson_nm").value,0);
			break;
		case "certi_no":
			sheetObjects[3].SetCellValue(row, "certi_no",document.getElementById("certi_no").value,0);
			break;
		case "cnee_dtl_desc":
			sheetObjects[3].SetCellValue(row, "cnee_dtl_desc",document.getElementById("cnee_dtl_desc").value,0);
			break;
		case "net_explo_wgt":
			sheetObjects[3].SetCellValue(row, "net_explo_wgt",document.getElementById("net_explo_wgt").value,0);
			break;
		case "rada_skd_no":
			sheetObjects[3].SetCellValue(row, "rada_skd_no",document.getElementById("rada_skd_no").value,0);
			break;
		case "rada_amt":
			sheetObjects[3].SetCellValue(row, "rada_amt",document.getElementById("rada_amt").value,0);
			break;
		case "rada_ut_cd":
			sheetObjects[3].SetCellValue(row, "rada_ut_cd", rada_ut_cd.GetSelectCode(), 0);
			break;
		case "rada_trsp_no":
			 sheetObjects[3].SetCellValue(row, "rada_trsp_no",document.getElementById("rada_trsp_no").value,0);
			if (document.getElementById("rada_trsp_no").value != '' && !ComIsNumber(document.getElementById("rada_trsp_no").value,".")){
				 ComShowMessage(ComGetMsg("BKG08176"));
				 document.getElementById("rada_trsp_no").value='';
				return;
			 }else{
				 sheetObjects[3].SetCellValue(row, "rada_trsp_no",document.getElementById("rada_trsp_no").value,0);
			 }
			break;
		case "imdg_segr_grp_no":
			sheetObjects[3].SetCellValue(row, "imdg_segr_grp_no",imdg_segr_grp_no.GetSelectCode(),0);
			break;
		case "rsd_flg":
			sheetObjects[3].SetCellValue(row, "rsd_flg",document.form.rsd_flg.value,0);
			break;
		case "frm_imdg_spcl_provi_no1": case "frm_imdg_spcl_provi_no2": case "frm_imdg_spcl_provi_no3": case "frm_imdg_spcl_provi_no4": case "frm_imdg_spcl_provi_no5": case "frm_imdg_spcl_provi_no6": case "frm_imdg_spcl_provi_no7": case "frm_imdg_spcl_provi_no8":
			//object change......
			//2015.11.27. imdg_un_no_spcl_provi_ctnt setting
//			var formObj=document.form;
//			var imdg_un_no_spcl_provi_ctnt = "";
//			if (ComGetEvent("value") != "") {
//				for(i=1; i<9; i++){
//					if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != ""){
//						imdg_un_no_spcl_provi_ctnt += eval("formObj.frm_imdg_spcl_provi_no"+i+".value")+"^"+i+"|";
////						sheetObjects[3].SetCellValue(find_row, "imdg_spcl_provi_no"+i,eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//						sheetObjects[3].SetCellValue(row, "imdg_spcl_provi_no"+i,eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//					}
//				}
//				sheetObjects[3].SetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt",imdg_un_no_spcl_provi_ctnt,0);
//			}
			
			//Set screen object value to ibsheet "imdg_un_no_spcl_provi_ctnt"
			setSpclProviCtnt(row);
			break;
		}
	}
	function rowAdd() {
		if (document.getElementById("bkg_no").value != "") {
			var Row1=sheetObjects[1].DataInsert(-1);
			var Row2=sheetObjects[3].DataInsert(-1);
			sheetObjects[1].SetCellValue(Row1, "cntr_no","",0);
			sheetObjects[1].SetCellValue(Row1, "bkg_no",document.getElementById("bkg_no").value,0);
			sheetObjects[1].SetCellValue(Row1, "cntr_cgo_seq","1",0);
			sheetObjects[1].SetCellValue(Row1, "meas_qty","0",0);
			sheetObjects[1].SetCellValue(Row1, "clod_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "mrn_polut_flg","Y",0);
			sheetObjects[1].SetCellValue(Row1, "rc_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "awk_cgo_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "bb_cgo_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "hcdg_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "hcdg_dpnd_qty_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "imdg_expt_qty_flg","N",0);
			sheetObjects[1].SetCellValue(Row1, "cntr_vol_qty","1",0);
			var dg_cntr_seq=Number(sheetObjects[1].GetCellValue(1, "dg_cntr_seq"));
			var dcgo_seq=Number(sheetObjects[3].GetCellValue(1, "dcgo_seq"));
			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
				if (dg_cntr_seq < Number(sheetObjects[1].GetCellValue(i, "dg_cntr_seq"))) {
					dg_cntr_seq=Number(sheetObjects[1].GetCellValue(i, "dg_cntr_seq"));
				}
			}
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				if (dcgo_seq < Number(sheetObjects[3].GetCellValue(i, "dcgo_seq"))) {
					dcgo_seq=Number(sheetObjects[3].GetCellValue(i, "dcgo_seq"));
				}
			}
			sheetObjects[1].SetCellValue(Row1, "dg_cntr_seq",Number(dg_cntr_seq) + 1,0);
			sheetObjects[3].SetCellValue(Row2, "cntr_cgo_seq","1",0);
			sheetObjects[3].SetCellValue(Row2, "spcl_cgo_seq","1",0);
			sheetObjects[3].SetCellValue(Row2, "bkg_no",document.getElementById("bkg_no").value,0);
			sheetObjects[3].SetCellValue(Row2, "meas_qty","0",0);
			sheetObjects[3].SetCellValue(Row2, "clod_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "mrn_polut_flg","Y",0);
			sheetObjects[3].SetCellValue(Row2, "rc_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "awk_cgo_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "bb_cgo_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "hcdg_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "imdg_expt_qty_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "imdg_expt_qty_cd","",0);
			sheetObjects[3].SetCellValue(Row2, "hcdg_dpnd_qty_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "spcl_rqst_flg","N",0);
			sheetObjects[3].SetCellValue(Row2, "cntr_vol_qty","1",0);
			sheetObjects[3].SetCellValue(Row2, "dg_cntr_seq",Number(dg_cntr_seq) + 1,0);
			sheetObjects[3].SetCellValue(Row2, "spcl_cntr_seq",Number(dg_cntr_seq) + 1,0);
			sheetObjects[3].SetCellValue(Row2, "dcgo_seq",Number(dcgo_seq) + 1,0);
			sheetObjects[3].SetCellValue(Row2, "max_in_pck_qty","0",0);
			sheetObjects[3].SetCellValue(Row2, "aply_no","",0);
			sheetObjects[3].SetCellValue(Row2, "imdg_segr_grp_no","",0);
			sheetObjects[3].SetCellValue(Row2, "rsd_flg","N",0);
		}
		cntrChk();
		htmlSheetSync();
		document.getElementById("temp_grs_wgt").value="0";
		document.getElementById("temp_net_wgt").value="0";
		var cntr_name="";
		var cntr_val="";
		for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
			if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
			}
		}
		cntr_val=cntr_val.substr(0, cntr_val.length - 1);
		cntr_name=cntr_name.substr(0, cntr_name.length - 1);
		var checkCntr=sheetObjects[4].FindText("DelChk", "0", 0, 2);
		if (checkCntr > 0) {
			sheetObjects[1].CellComboItem(Row1,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
		} else {
//			sheetObjects[1].CellComboItem(Row1,"cntr_no", {ComboText:"", ComboCode:""} );
			sheetObjects[1].CellComboItem(Row1,"cntr_no", {ComboText:" |", ComboCode:" |"} );
		}
	}
	function checkAdd() {
		var row=sheetObjects[3].DataInsert(-1);
		sheetObjects[3].SetCellValue(row, "cntr_no",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cntr_no"),0);
		sheetObjects[3].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cntr_tpsz_cd"),0);
		sheetObjects[3].SetCellValue(row, "cntr_vol_qty",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cntr_vol_qty"),0);
		sheetObjects[3].SetCellValue(row, "meas_qty",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "meas_qty"),0);
		sheetObjects[3].SetCellValue(row, "clod_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "clod_flg"),0);
		sheetObjects[3].SetCellValue(row, "mrn_polut_flg","Y",0);
		sheetObjects[3].SetCellValue(row, "rc_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "rc_flg"),0);
		sheetObjects[3].SetCellValue(row, "awk_cgo_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "awk_cgo_flg"),0);
		sheetObjects[3].SetCellValue(row, "bb_cgo_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "bb_cgo_flg"),0);
		sheetObjects[3].SetCellValue(row, "hcdg_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "hcdg_flg"),0);
		sheetObjects[3].SetCellValue(row, "hcdg_dpnd_qty_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "hcdg_dpnd_qty_flg"),0);
		sheetObjects[3].SetCellValue(row, "spcl_rqst_flg","N",0);
		sheetObjects[3].SetCellValue(row, "dg_cntr_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "dg_cntr_seq"),0);
		sheetObjects[3].SetCellValue(row, "spcl_cntr_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "dg_cntr_seq"),0);
		sheetObjects[3].SetCellValue(row, "imdg_expt_qty_flg","N",0);
		sheetObjects[3].SetCellValue(row, "bkg_no",document.getElementById("bkg_no").value,0);
		sheetObjects[3].SetCellValue(row, "CntrChk","1",0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd","",0);
		sheetObjects[3].SetCellValue(row, "DelChk","1",0);
		sheetObjects[3].SetCellValue(row, "max_in_pck_qty","0",0);
		var cnt=0;
		var dcgo_seq=Number(sheetObjects[3].GetCellValue(1, "dcgo_seq"));
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (sheetObjects[3].GetCellValue(i, "CntrChk") == "1" && sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
				cnt++;
				sheetObjects[3].SetCellValue(i, "cntr_cgo_seq",cnt,0);
				sheetObjects[3].SetCellValue(i, "spcl_cgo_seq",cnt,0);
			}
			if (dcgo_seq < Number(sheetObjects[3].GetCellValue(i, "dcgo_seq"))) {
				dcgo_seq=Number(sheetObjects[3].GetCellValue(i, "dcgo_seq"));
			}
		}
		sheetObjects[3].SetCellValue(row, "dcgo_seq",Number(dcgo_seq) + 1,0);
		cntrChk();
		document.form.cntr_cgo_seq.value=cnt;
		document.getElementById("dg_cntr_seq").value="";
		document.getElementById("imdg_clss_cd").value="";
		document.getElementById("cfr_flg").checked=false;
		document.getElementById("imdg_comp_grp_cd").value="";
		document.getElementById("imdg_un_no").value="";
		document.getElementById("grs_wgt").value="";
		document.getElementById("net_wgt").value="";
		document.getElementById("prp_shp_nm").value="";
		document.getElementById("hzd_desc").value="";
		document.getElementById("flsh_pnt_cdo_temp").value="";
//		imdg_pck_grp_cd.SetSelectCode("");
//		document.getElementById("imdg_pck_grp_cd").value = "";
		document.getElementById("psa_no").value="";
		document.form.imdg_lmt_qty_flg.value="";
		document.form.imdg_expt_qty_flg.value="";
		document.getElementById("hcdg_flag").value="";
		document.getElementById("imdg_subs_rsk_lbl_cd1").value="";
		document.getElementById("imdg_subs_rsk_lbl_cd2").value="";
		document.getElementById("imdg_subs_rsk_lbl_cd3").value="";
		document.getElementById("imdg_subs_rsk_lbl_cd4").value="";
//		dcgo_sts_cd.SetSelectCode("");
//		document.getElementById("dcgo_sts_cd").value = "";
		document.form.mrn_polut_flg.value="";
		document.getElementById("emer_cntc_phn_no_ctnt").value="";
		document.getElementById("emer_cntc_pson_nm").value="";
		document.getElementById("certi_no").value="";
		document.getElementById("cnee_dtl_desc").value="";
		document.getElementById("net_explo_wgt").value="";
		document.getElementById("rada_skd_no").value="";
		document.getElementById("rada_amt").value="";
		rada_ut_cd.SetSelectCode("");
		document.getElementById("rada_trsp_no").value="";
		document.getElementById("temp_cntr_no").value="";
		document.getElementById("in_imdg_pck_cd1").value="";
		document.getElementById("in_imdg_pck_cd2").value="";
		document.getElementById("intmd_imdg_pck_cd1").value="";
		document.getElementById("intmd_imdg_pck_cd2").value="";
		document.getElementById("out_imdg_pck_cd1").value="";
		document.getElementById("out_imdg_pck_cd2").value="";
		document.getElementById("in_imdg_pck_desc1").value="";
		document.getElementById("in_imdg_pck_desc2").value="";
		document.getElementById("intmd_imdg_pck_desc1").value="";
		document.getElementById("intmd_imdg_pck_desc2").value="";
		document.getElementById("out_imdg_pck_desc1").value="";
		document.getElementById("out_imdg_pck_desc2").value="";
		document.getElementById("in_imdg_pck_qty1").value="";
		document.getElementById("in_imdg_pck_qty2").value="";
		document.getElementById("intmd_imdg_pck_qty1").value="";
		document.getElementById("intmd_imdg_pck_qty2").value="";
		document.getElementById("out_imdg_pck_qty1").value="";
		document.getElementById("out_imdg_pck_qty2").value="";
		document.getElementById("out_imdg_pck_qty2").value="";
		document.getElementById("imdg_expt_qty_cd").value="";
		document.getElementById("imdg_expt_qty_desc").value="";
		document.getElementById("max_in_pck_qty").value="";
		document.getElementById("max_in_pck_tp_cd").value="";
		document.getElementById("hcdg_intmd_bc_rstr_desc").value="";
		document.getElementById("hcdg_pck_rstr_desc").value="";
		document.getElementById("hcdg_tnk_rstr_desc").value="";
		document.getElementById("ltd_qty").value="";
		document.getElementById("imdg_lmt_qty_desc").value="";
		document.getElementById("ems_no").value="";
		document.getElementById("emer_rspn_gid_no").value="";
		document.getElementById("emer_rspn_gid_chr_no").value="";
		document.getElementById("ctrl_temp_ctnt").value="";
		document.getElementById("emer_temp_ctnt").value="";
		document.getElementById("aply_no").value="";
		document.getElementById("imdg_amdt_no").value="";
		document.getElementById("erap_no").value="";
		document.getElementById("erap_cntc_no").value="";
		document.getElementById("erap_apro_ref_no").value="";
		document.getElementById("dot_exp_no").value="";
		document.getElementById("dot_spcl_apro_no").value="";
		document.getElementById("dot_auth_no").value="";
		document.getElementById("frm_imdg_spcl_provi_no1").value="";
		document.getElementById("frm_imdg_spcl_provi_no2").value="";
		document.getElementById("frm_imdg_spcl_provi_no3").value="";
		document.getElementById("frm_imdg_spcl_provi_no4").value="";
		document.getElementById("frm_imdg_spcl_provi_no5").value="";
		document.getElementById("frm_imdg_spcl_provi_no6").value="";
		document.getElementById("frm_imdg_spcl_provi_no7").value="";
		document.getElementById("frm_imdg_spcl_provi_no8").value="";
		htmlSheetSync();
		document.getElementById("temp_grs_wgt").value="0";
		document.getElementById("temp_net_wgt").value="0";
		dcgo_seq=Number(sheetObjects[3].GetCellValue(1, "dcgo_seq"));
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (dcgo_seq < Number(sheetObjects[3].GetCellValue(i, "dcgo_seq"))) {
				dcgo_seq=Number(sheetObjects[3].GetCellValue(i, "dcgo_seq"));
			}
			if (sheetObjects[3].GetCellValue(i, "DelChk") == "1") {
				sheetObjects[3].SetCellValue(i, "DelChk","0",0);
			}
		}
		sheetObjects[3].SetCellValue(row, "DelChk","1",0);
//		imdg_segr_grp_no.SetSelectCode("");
		document.form.rsd_flg.value="N";
	}
	
	function rowDelete() {
//		for ( var k=1; k <= sheetObjects[3].RowCount(); k++) {
//			if (sheetObjects[1].GetCellValue(k, "DelChk") == "1") {
//				if (sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "N") {
//					ComShowMessage(ComGetMsg("BKG00525"));
//					return;
//				}
//			}
//		}

		//check approval status
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if((sheetObjects[1].GetCellValue(i,"ibflag") != "D") && (sheetObjects[1].GetCellValue(i, "DelChk") == "1") ){ // D is out of check target
				for ( var j=1; j <= sheetObjects[3].RowCount(); j++) {
					if(sheetObjects[3].GetCellValue(j,"ibflag") != "D"){
						if( (sheetObjects[1].GetCellValue(i, "cntr_no") == sheetObjects[3].GetCellValue(j, "cntr_no")) && (sheetObjects[1].GetCellValue(i, "dg_cntr_seq") == sheetObjects[3].GetCellValue(j, "dg_cntr_seq")) ){
							if (sheetObjects[3].GetCellValue(j, "spcl_cgo_apro_cd") == "P" || sheetObjects[3].GetCellValue(j, "spcl_cgo_apro_cd") == "R" || sheetObjects[3].GetCellValue(j, "spcl_cgo_apro_cd") == "Y" || sheetObjects[3].GetCellValue(j, "spcl_cgo_apro_cd") == "N") {
								ComShowMessage(ComGetMsg("BKG00525"));
								return;							
							}
						}	
					}
				}
			}
		}

		var sRow=sheetObjects[1].FindCheckedRow("DelChk");
		var arrRow=sRow.split("|");
//		for (idx=0; idx < arrRow.length - 1; idx++) {
		for (idx=0; idx <= arrRow.length - 1; idx++) {
			for ( var j=1; j <= sheetObjects[3].RowCount(); j++) {
				if (sheetObjects[1].GetCellValue(arrRow[idx], "cntr_no") == sheetObjects[3].GetCellValue(j, "cntr_no") && sheetObjects[1].GetCellValue(arrRow[idx], "dg_cntr_seq") == sheetObjects[3].GetCellValue(j, "dg_cntr_seq")) {
//					sheetObjects[3].SetCellValue(j, "CntrChk","1",0);
					sheetObjects[3].SetCellValue(j, "DelChk","1",0);
				}
			}
			for ( var k=1; k <= sheetObjects[4].RowCount(); k++) {
				if (sheetObjects[1].GetCellValue(arrRow[idx], "cntr_no") == sheetObjects[4].GetCellValue(k, "val")) {
					sheetObjects[4].SetCellValue(k, "DelChk","0",0);
				}
			}
		}
		var find_row=sheetObjects[1].FindText("DelChk", "1", 0, 2);
		
		if (find_row > 0) {
			ComRowHideDelete(sheetObjects[1], "DelChk");
			ComRowHideDelete(sheetObjects[3], "DelChk");	////////////////////////////////////////////////<<<<<<<<<<<<
		}
		var cntr_name="";
		var cntr_val="";
		for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
			if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
			}
		}
		cntr_val=cntr_val.substr(0, cntr_val.length - 1);
		cntr_name=cntr_name.substr(0, cntr_name.length - 1);
		var cntr_no="";
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			cntr_no=sheetObjects[1].GetCellValue(i, "cntr_no");
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_no+"|"+cntr_name, ComboCode:"|"+cntr_no+"|"+cntr_val} );
			sheetObjects[1].SetCellValue(i, "cntr_no",cntr_no,0);
		}
		var row_find=0;
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "ibflag") == "D") {
				row_find++;
			} else {
				sheetObjects[1].SelectCell(i, 0, false);
				cntrChk();
				htmlSheetSync();
				return;
			}
		}
		if (row_find == sheetObjects[1].RowCount()) {
			document.getElementById("dg_cntr_seq").value="";
			document.form.cntr_cgo_seq.value="";
			document.getElementById("imdg_clss_cd").value="";
			document.getElementById("cfr_flg").checked=false;
			document.getElementById("imdg_comp_grp_cd").value="";
			document.getElementById("imdg_un_no").value="";
			document.getElementById("grs_wgt").value="";
			document.getElementById("net_wgt").value="";
			document.getElementById("prp_shp_nm").value="";
			document.getElementById("hzd_desc").value="";
			document.getElementById("flsh_pnt_cdo_temp").value="";
			imdg_pck_grp_cd.SetSelectCode("");
			document.getElementById("psa_no").value="";
			document.form.imdg_lmt_qty_flg.value="";
			document.form.imdg_expt_qty_flg.value="";
			document.getElementById("hcdg_flag").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd1").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd2").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd3").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd4").value="";
			dcgo_sts_cd.SetSelectCode("");
			document.form.mrn_polut_flg.value="";
			document.getElementById("emer_cntc_phn_no_ctnt").value="";
			document.getElementById("emer_cntc_pson_nm").value="";
			document.getElementById("certi_no").value="";
			document.getElementById("cnee_dtl_desc").value="";
			document.getElementById("net_explo_wgt").value="";
			document.getElementById("rada_skd_no").value="";
			document.getElementById("rada_amt").value="";
			rada_ut_cd.SetSelectCode("");
			document.getElementById("rada_trsp_no").value="";
			document.getElementById("temp_cntr_no").value="";
			document.getElementById("in_imdg_pck_cd1").value="";
			document.getElementById("in_imdg_pck_cd2").value="";
			document.getElementById("intmd_imdg_pck_cd1").value="";
			document.getElementById("intmd_imdg_pck_cd2").value="";
			document.getElementById("out_imdg_pck_cd1").value="";
			document.getElementById("out_imdg_pck_cd2").value="";
			document.getElementById("in_imdg_pck_desc1").value="";
			document.getElementById("in_imdg_pck_desc2").value="";
			document.getElementById("intmd_imdg_pck_desc1").value="";
			document.getElementById("intmd_imdg_pck_desc2").value="";
			document.getElementById("out_imdg_pck_desc1").value="";
			document.getElementById("out_imdg_pck_desc2").value="";
			document.getElementById("in_imdg_pck_qty1").value="";
			document.getElementById("in_imdg_pck_qty2").value="";
			document.getElementById("intmd_imdg_pck_qty1").value="";
			document.getElementById("intmd_imdg_pck_qty2").value="";
			document.getElementById("out_imdg_pck_qty1").value="";
			document.getElementById("out_imdg_pck_qty2").value="";
			document.getElementById("imdg_expt_qty_cd").value="";
			document.getElementById("imdg_expt_qty_desc").value="";
			document.getElementById("max_in_pck_qty").value="";
			document.getElementById("max_in_pck_tp_cd").value="";
			document.getElementById("hcdg_intmd_bc_rstr_desc").value="";
			document.getElementById("hcdg_pck_rstr_desc").value="";
			document.getElementById("hcdg_tnk_rstr_desc").value="";
			document.getElementById("ltd_qty").value="";
			document.getElementById("imdg_lmt_qty_desc").value="";
			document.getElementById("ems_no").value="";
			document.getElementById("emer_rspn_gid_no").value="";
			document.getElementById("emer_rspn_gid_chr_no").value="";
			document.getElementById("ctrl_temp_ctnt").value="";
			document.getElementById("emer_temp_ctnt").value="";
			document.getElementById("temp_grs_wgt").value="";
			document.getElementById("temp_net_wgt").value="";
			document.getElementById("aply_no").value="";
			document.getElementById("imdg_amdt_no").value="";
			imdg_segr_grp_no.SetSelectCode("");
			document.form.rsd_flg.value="";
			document.getElementById("erap_no").value="";		//2015.11.24 erap
			document.getElementById("erap_cntc_no").value="";
			document.getElementById("erap_apro_ref_no").value="";
			document.getElementById("dot_exp_no").value="";		//2015.11.25 dot references
			document.getElementById("dot_spcl_apro_no").value="";
			document.getElementById("dot_auth_no").value="";
			document.getElementById("frm_imdg_spcl_provi_no1").value="";
			document.getElementById("frm_imdg_spcl_provi_no2").value="";
			document.getElementById("frm_imdg_spcl_provi_no3").value="";
			document.getElementById("frm_imdg_spcl_provi_no4").value="";
			document.getElementById("frm_imdg_spcl_provi_no5").value="";
			document.getElementById("frm_imdg_spcl_provi_no6").value="";
			document.getElementById("frm_imdg_spcl_provi_no7").value="";
			document.getElementById("frm_imdg_spcl_provi_no8").value="";
			
		}
	}
	function deleteRows() {
		for ( var k=1; k <= sheetObjects[3].RowCount(); k++) {
			if (sheetObjects[3].GetCellValue(k, "DelChk") == "1") {
				if (sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "N") {
					ComShowMessage(ComGetMsg("BKG00525"));
					return;
				}
			}
		}
		ComRowHideDelete(sheetObjects[3], "DelChk");
		var cnt=0;
		document.getElementById("cntr_cgo_seq").options.length=0;
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (sheetObjects[3].GetCellValue(i, "CntrChk") == "1" && sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
				cnt++;
				sheetObjects[3].SetCellValue(i, "cntr_cgo_seq",cnt,0);
				sheetObjects[3].SetCellValue(i, "spcl_cgo_seq",cnt,0);
				var cntr_cgo_seq=sheetObjects[3].GetCellValue(i, "cntr_cgo_seq");
				document.getElementById("cntr_cgo_seq").options[cnt - 1]=new Option(cntr_cgo_seq, cntr_cgo_seq);
			}
			sheetObjects[3].SetCellValue(i, "bkg_cntr_seq",sheetObjects[3].GetCellValue(i, "dg_cntr_seq") + sheetObjects[3].GetCellValue(i, "cntr_cgo_seq"),0);
		}
		document.getElementById("cntr_cgo_seq_sum").value=cnt;
		if (cnt > 0) {
			document.form.cntr_cgo_seq.value=cnt;
			cntrChk();
			htmlSheetSync();
		} else {
			var dg_cntr_seq=document.getElementById("dg_cntr_seq").value;
			var find_cntr_no=sheetObjects[1].FindText("dg_cntr_seq", dg_cntr_seq, 0, 2);
			sheetObjects[1].SetCellValue(find_cntr_no, "DelChk","1",0);
			//add process to show container list
			var del_cntr_no = sheetObjects[1].GetCellValue(find_cntr_no,"cntr_no");
			if(del_cntr_no != ""){
				for ( var k=1; k <= sheetObjects[4].RowCount(); k++) {
					if (del_cntr_no == sheetObjects[4].GetCellValue(k, "val")) {
						sheetObjects[4].SetCellValue(k, "DelChk","0",0);
					}
				}				
			}
			ComRowHideDelete(sheetObjects[1], "DelChk");
		}
		var row_find=0;
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
				sheetObjects[1].SelectCell(i, 0, true);
				cntrChk();
				htmlSheetSync();
				return;
			} else {
				row_find++;
			}
		}
		if (row_find == sheetObjects[1].RowCount()) {
//			document.getElementById("temp_seq").value="";
			document.form.cntr_cgo_seq.value="";
			document.getElementById("imdg_clss_cd").value="";
			document.getElementById("cfr_flg").checked=false;
			document.getElementById("imdg_comp_grp_cd").value="";
			document.getElementById("imdg_un_no").value="";
			document.getElementById("grs_wgt").value="";
			document.getElementById("net_wgt").value="";
			document.getElementById("prp_shp_nm").value="";
			document.getElementById("hzd_desc").value="";
			document.getElementById("flsh_pnt_cdo_temp").value="";
			imdg_pck_grp_cd.SetSelectCode("");
			document.getElementById("psa_no").value="";
			document.form.imdg_lmt_qty_flg.value="";
			document.form.imdg_expt_qty_flg.value="";
			document.getElementById("hcdg_flag").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd1").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd2").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd3").value="";
			document.getElementById("imdg_subs_rsk_lbl_cd4").value="";
			dcgo_sts_cd.SetSelectCode("");
			document.form.mrn_polut_flg.value="";
			document.getElementById("emer_cntc_phn_no_ctnt").value="";
			document.getElementById("emer_cntc_pson_nm").value="";
			document.getElementById("certi_no").value="";
			document.getElementById("cnee_dtl_desc").value="";
			document.getElementById("net_explo_wgt").value="";
			document.getElementById("rada_skd_no").value="";
			document.getElementById("rada_amt").value="";
			rada_ut_cd.SetSelectCode("");
			document.getElementById("rada_trsp_no").value="";
			document.getElementById("temp_cntr_no").value="";
			document.getElementById("in_imdg_pck_cd1").value="";
			document.getElementById("in_imdg_pck_cd2").value="";
			document.getElementById("intmd_imdg_pck_cd1").value="";
			document.getElementById("intmd_imdg_pck_cd2").value="";
			document.getElementById("out_imdg_pck_cd1").value="";
			document.getElementById("out_imdg_pck_cd2").value="";
			document.getElementById("in_imdg_pck_desc1").value="";
			document.getElementById("in_imdg_pck_desc2").value="";
			document.getElementById("intmd_imdg_pck_desc1").value="";
			document.getElementById("intmd_imdg_pck_desc2").value="";
			document.getElementById("out_imdg_pck_desc1").value="";
			document.getElementById("out_imdg_pck_desc2").value="";
			document.getElementById("in_imdg_pck_qty1").value="";
			document.getElementById("in_imdg_pck_qty2").value="";
			document.getElementById("intmd_imdg_pck_qty1").value="";
			document.getElementById("intmd_imdg_pck_qty2").value="";
			document.getElementById("out_imdg_pck_qty1").value="";
			document.getElementById("out_imdg_pck_qty2").value="";
			document.getElementById("imdg_expt_qty_cd").value="";
			document.getElementById("imdg_expt_qty_desc").value="";
			document.getElementById("max_in_pck_qty").value="";
			document.getElementById("max_in_pck_tp_cd").value="";
			document.getElementById("hcdg_intmd_bc_rstr_desc").value="";
			document.getElementById("hcdg_pck_rstr_desc").value="";
			document.getElementById("hcdg_tnk_rstr_desc").value="";
			document.getElementById("ltd_qty").value="";
			document.getElementById("imdg_lmt_qty_desc").value="";
			document.getElementById("ems_no").value="";
			document.getElementById("emer_rspn_gid_no").value="";
			document.getElementById("emer_rspn_gid_chr_no").value="";
			document.getElementById("ctrl_temp_ctnt").value="";
			document.getElementById("emer_temp_ctnt").value="";
			document.getElementById("temp_grs_wgt").value="";
			document.getElementById("temp_net_wgt").value="";
			document.getElementById("aply_no").value="";
			document.getElementById("dcgo_ref_no").value="";
			document.getElementById("imdg_amdt_no").value="";
			imdg_segr_grp_no.SetSelectCode("");
			document.form.rsd_flg.value="";
			document.getElementById("erap_no").value="";
			document.getElementById("erap_cntc_no").value="";
			document.getElementById("erap_apro_ref_no").value="";
			document.getElementById("dot_exp_no").value="";
			document.getElementById("dot_spcl_apro_no").value="";
			document.getElementById("dot_auth_no").value="";
			document.getElementById("frm_imdg_spcl_provi_no1").value="";
			document.getElementById("frm_imdg_spcl_provi_no2").value="";
			document.getElementById("frm_imdg_spcl_provi_no3").value="";
			document.getElementById("frm_imdg_spcl_provi_no4").value="";
			document.getElementById("frm_imdg_spcl_provi_no5").value="";
			document.getElementById("frm_imdg_spcl_provi_no6").value="";
			document.getElementById("frm_imdg_spcl_provi_no7").value="";
			document.getElementById("frm_imdg_spcl_provi_no8").value="";
			
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //sheet1 init : Visible sheet at upper left, To show total container quantity
		    with(sheetObj){
			      var HeadTitle1="TP/SZ|BKG Q'ty|DG Q'ty";
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"dcgo_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Float",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"eq_tpsz",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSheetHeight(180);
		          }
			break;
			
		case 2: //sheet2 init : Visible sheet at lower left, To show container information
		    with(sheetObj){
			      var HeadTitle1="|Seq||Container No.|TS|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no|dg_cgo_seq" + "|cntr_cgo_seq|imdg_clss_cd|cfr_flg|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm|hzd_desc"
			      + "|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|hcdg_flag|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4" + "|dcgo_sts_cd|mrn_polut_flg|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt|rada_ut_cd"
			      + "|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk||meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_dpnd_qty_flg|spcl_rqst_flg|spcl_rqst_desc|rc_seq|awk_cgo_seq|bb_cgo_seq|dg_cntr_seq";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"DummyCheck", Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"DelChk" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cargo_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cargo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_skd_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_amt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_trsp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clod_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_lcl_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"approved",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
				            ,{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq_original",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
				             ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(200);
		          }
			break;
		case 3: //sheet1 init : Not visible sheet, to store booking information to show it at top 
		    with(sheetObj){
			      var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg";
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bkg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_n1st_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bdr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_pre_pst_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"flex_hgt_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vessel_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"img_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      sheetObj.SetVisible(0);
		        }
			break;
		case 4: //sheet2 init : Not visible sheet, to store main DG information to update DB
		    with(sheetObj){
			      var HeadTitle1="|||Seq|Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no" + "|dg_cgo_seq|cntr_cgo_seq|imdg_clss_cd|cfr_flg|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm"
			      + "|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3" + "|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_mrn_polut_cd|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt"
			      + "|rada_ut_cd|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk|bkg_cntr_seq|in_imdg_pck_cd1|in_imdg_pck_cd2|out_imdg_pck_cd1" + "|out_imdg_pck_cd2|in_imdg_pck_desc1|in_imdg_pck_desc2|out_imdg_pck_desc1|out_imdg_pck_desc2|in_imdg_pck_qty1|in_imdg_pck_qty2|out_imdg_pck_qty1|out_imdg_pck_qty2|max_in_pck_qty"
			      + "|max_in_pck_tp_cd|hcdg_intmd_bc_rstr_desc|hcdg_pck_rstr_desc|hcdg_tnk_rstr_desc|ltd_qty|ems_no|emer_rspn_gid_no|emer_rspn_gid_chr_no|ctrl_temp_ctnt|emer_temp_ctnt"
			      + "|dcgo_seq|modifyaproflg|dg_cntr_seq|meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_flg|hcdg_qty|hcdg_dpnd_qty_flg|imdg_spcl_provi_no|imdg_crr_rstr_expt_cd|spcl_rqst_flg|spcl_rqst_desc|imdg_expt_qty_cd|crr_cd|por_cd|del_cd|rcv_term_cd|de_term_cd|spcl_cgo_seq|spcl_cntr_seq|apro_cd|imdg_segr_grp_no|rsd_flg|dcgo_ref_no|imdg_segr_grp_nos|dg_cntr_seq_original"
			      + "|imdg_lmt_qty_desc|imdg_expt_qty_desc";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"CntrChk" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
			             {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",             	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_mrn_polut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_skd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_ut_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_trsp_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clod_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_lcl_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_desc1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_desc2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_desc1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_desc2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_desc1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_desc2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_qty1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_qty2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_qty1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_qty2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_intmd_bc_rstr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_pck_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ltd_qty",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ems_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_temp_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_temp_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"modifyaproflg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_crr_rstr_expt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"apro_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"aply_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rsd_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }, 
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_ref_no",			  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_nos",		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq_original",	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",	  		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"erap_no",	  		  	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"erap_cntc_no",	  		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"erap_apro_ref_no",	  	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dot_exp_no",	  		  	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dot_spcl_apro_no",	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dot_auth_no",	  	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_spcl_provi_ctnt",	  	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_desc",	  	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_desc",	  	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no7",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no8",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
			             ,];
			      InitColumns(cols);
			      SetEditable(1);
			      sheetObj.SetVisible(1);
			      SetSheetHeight(200);
	            }
			break;
		case 5: //sheet1 init : Not visible sheet
		    with(sheetObj){
//		    	  var HeadTitle="|";
			      var HeadTitle="|value|name||";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1, Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"}];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      sheetObj.SetVisible(0);
	            }
		      break;
		      
	      case 6:
			break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case INIT:      //Default
			sheetObjects[0].SetWaitImageVisible(1);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0200GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (0 < arrXml.length) {
				ComBkgXml2ComboItem(arrXml[0], imdg_pck_grp_cd, "val", "name");
//				imdg_pck_grp_cd.SetSelectIndex(0);
				setImdg_pck_grp_cdCombo(0);
				companyCode=ComGetEtcData(arrXml[0],"companyCode");
			}
			if (1 < arrXml.length) {
				ComBkgXml2ComboItem(arrXml[1], dcgo_sts_cd, "val", "name");
				dcgo_sts_cd.SetSelectIndex(0);
			}
			if (2 < arrXml.length) {
				ComBkgXml2ComboItem(arrXml[2], imdg_segr_grp_no, "val", "name");
				imdg_segr_grp_no.SetSelectIndex(0);
				
				for(i=1;i < comboObjects[2].GetItemCount();i++){
					if(comboObjects[2].GetIndexText(i,2).toUpperCase() == "NONE"){
						imdgSegrGrpNone = i-1;
						break;
					}
				}
			}
			if (3 < arrXml.length) {
				ComBkgXml2ComboItem(arrXml[3], rada_ut_cd, "val", "name");
				rada_ut_cd.SetSelectIndex(0);
			}
			sheetObjects[0].SetWaitImageVisible(0);
			
			break;
		case SEARCH: 
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value=SEARCH;
			var resultXml=sheetObj.GetSearchData("ESM_BKG_0200GS.do", FormQueryString(formObj));
			var arrXml=resultXml.split("|$$|");
			if (arrXml.length == 6) {
				var etcXml=arrXml[0];
				if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {
					document.getElementById("rqst_dt").value="";
					document.getElementById("rqst_usr_id").value="";
				} else {
					document.getElementById("rqst_dt").value=ComGetEtcData(etcXml, "rqst_dt");
					document.getElementById("rqst_usr_id").value=ComGetEtcData(etcXml, "rqst_usr_id");
				}
				if (ComGetEtcData(etcXml, "rqst_gdt") == "null" || ComGetEtcData(etcXml, "rqst_gdt") == "") {
					document.getElementById("rqst_gdt").value="";
				} else {
					document.getElementById("rqst_gdt").value=ComGetEtcData(etcXml, "rqst_gdt");
				}
				if (arrXml[4].indexOf("TOTAL='0'") < 1) {
					var arrCombo=ComXml2ComboString(arrXml[4], "val", "name");
//					sheetObjects[1].SetColProperty("cntr_no", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
					sheetObjects[1].SetColProperty("cntr_no", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
				}
				sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1} );
				sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[2].LoadSearchData(arrXml[3],{Sync:1} );
				sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
				sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
//				if(sheetObjects[1].GetCellValue(1, "bkg_no") == -1 && sheetObjects[0].RowCount() == 0){
//				     ComShowCodeMessage("BKG00273");
//				     return false;
//				    }
				if(sheetObjects[0].RowCount() < 1){
					ComShowMessage(ComGetMsg("BKG00502"));
//					ComResetAll();
					return;
				}
				if(sheetObjects[2].RowCount() > 0){
					document.getElementById("bl_no").value = sheetObjects[2].GetCellValue(1, "bl_no");
					document.getElementById("old_bkg_no").value=sheetObjects[2].GetCellValue(1, "bkg_no");
				}else{
					document.getElementById("bl_no").value = "";					
					document.getElementById("old_bkg_no").value = "";					
				}
				
				
				if (document.getElementById("bkg_no").value == "") {
					document.getElementById("bkg_no").value=sheetObjects[2].GetCellValue(1, "bkg_no");
				}
				//Display booking information
				if(sheetObjects[2].RowCount() > 0){
					document.getElementById("bl_no").value=sheetObjects[2].GetCellValue(1, "bl_no");
					document.getElementById("vsl_cd").value=sheetObjects[2].GetCellValue(1, "vsl_cd");
					document.getElementById("pol_cd").value=sheetObjects[2].GetCellValue(1, "pol_cd");
					document.getElementById("pod_cd").value=sheetObjects[2].GetCellValue(1, "pod_cd");
					document.getElementById("pol_nod_cd").value=sheetObjects[2].GetCellValue(1, "pol_nod_cd");
					document.getElementById("pod_nod_cd").value=sheetObjects[2].GetCellValue(1, "pod_nod_cd");
					document.getElementById("slan_cd").value=sheetObjects[2].GetCellValue(1, "slan_cd");
					document.getElementById("vessel_nm").value=sheetObjects[2].GetCellValue(1, "vessel_nm");
				}else{
					ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
					ComResetAll();
					return;					
				}
				


//				for ( var i=1; i <= sheetObjects[0].RowCount(); i++) {
//					if (Number(sheetObjects[0].GetCellValue(i, "dcgo_qty")) < 1) {
//						for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
//							if (sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[1].GetCellValue(j, "cntr_tpsz_cd")) {
//								sheetObjects[1].SetCellValue(j, "cntr_vol_qty",Number(sheetObjects[0].GetCellValue(i, "dcgo_qty")),0);
//							}
//						}
//					}
//				}
				var cntSeq=0;
				for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
					sheetObjects[1].SetCellValue(i, "ibflag","I",0);
					if (sheetObjects[1].GetCellValue(i, "rc_seq") != "") {
						sheetObjects[1].SetCellValue(i, "cargo_nm","RF",0);
						sheetObjects[1].SetCellValue(i, "cargo_seq",sheetObjects[1].GetCellValue(i, "rc_seq"),0);
					} else if (sheetObjects[1].GetCellValue(i, "awk_cgo_seq") != "") {
						sheetObjects[1].SetCellValue(i, "cargo_nm","AWK",0);
						sheetObjects[1].SetCellValue(i, "cargo_seq",sheetObjects[1].GetCellValue(i, "awk_cgo_seq"),0);
					} else if (sheetObjects[1].GetCellValue(i, "bb_cgo_seq") != "") {
						sheetObjects[1].SetCellValue(i, "cargo_nm","BB",0);
						sheetObjects[1].SetCellValue(i, "cargo_seq",sheetObjects[1].GetCellValue(i, "bb_cgo_seq"),0);
					} else {
						cntSeq++;
					}
				}
				//If all container are DG specific, not show column for other special cargo 
				if (cntSeq == sheetObjects[1].RowCount()) {
					sheetObjects[1].SetColHidden("cargo_nm",1);
					sheetObjects[1].SetColHidden("cargo_seq",1);
				} else {
					sheetObjects[1].SetColHidden("cargo_nm",0);
					sheetObjects[1].SetColHidden("cargo_seq",0);
				}
				for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
					var cntr_no=sheetObjects[1].GetCellValue(j, "cntr_no");
					if (cntr_no != "") {
						var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
						sheetObjects[4].SetCellValue(find_row, "DelChk","1",0);
					}
				}
				cntrChk();
				
				//2015.12.15 search dcgo count check.
				if(sheetObjects[3].RowCount() < 1){
					document.getElementById("dcgo_yn").value="N";
				}else{
					document.getElementById("dcgo_yn").value="Y";
				}
				for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
					sheetObjects[3].SetCellValue(i, "spcl_cgo_seq",sheetObjects[3].GetCellValue(i, "cntr_cgo_seq"),0);
					sheetObjects[3].SetCellValue(i, "spcl_cntr_seq",sheetObjects[3].GetCellValue(i, "dg_cntr_seq"),0);
					if (sheetObjects[3].GetCellValue(i, "crr_cd") != "") {
						sheetObjects[3].SetCellValue(i, "imdg_crr_rstr_expt_cd","R",0);
					}
				}
				var cnt=0;
				var sum=0;
				//Display approval code per container 
				for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
						cnt++;
					}
					var tpszN2=0;
					var tpszP2=0;
					var tpszR2=0;
					var tpszY2=0;
					var tpszC2=0;
					for ( var k=1; k <= sheetObjects[3].RowCount(); k++) {
						if (sheetObjects[1].GetCellValue(i, "cntr_no") == sheetObjects[3].GetCellValue(k, "cntr_no") && sheetObjects[1].GetCellValue(i, "dg_cntr_seq") == sheetObjects[3].GetCellValue(k, "dg_cntr_seq")) {
							if (sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "Y") {
								tpszY2++;
							} else if (sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "N") {
								tpszN2++;
							} else if (sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "P") {
								tpszP2++;
							} else if (sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "R") {
								tpszR2++;
							} else if (sheetObjects[3].GetCellValue(k, "spcl_cgo_apro_cd") == "C") {
								tpszC2++;
							} else {
							}
						}
					}
					//priority Priority, High:N->P->R->Y->Other:Low
					if (tpszN2 > 0) {
						sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","N",0);
					}else if (tpszP2 > 0) {
						sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","P",0);
					}else if (tpszR2 > 0) {
						sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","R",0);
					}else if(tpszY2 > 0) {
						sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","Y",0);
					}else if(tpszC2 > 0){
						sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","C",0);
					}else{
						sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","",0);
					}
			
					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "N") {
						sheetObjects[1].SetCellFontColor(i, "spcl_cgo_apro_cd","#FF0000");
						sheetObjects[1].SetCellFont("FontBold", i, "spcl_cgo_apro_cd",1);
					}
				}
				for ( var j=1; j <= sheetObjects[0].RowCount(); j++) {
					if (sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd").indexOf("Q") == -1) {
						sum += Number(sheetObjects[0].GetCellValue(j, "dcgo_qty"));
					}
				}
				
				//Display booking representative approval code
				//priority Priority, High:N->P->R->Y->Other:Low
				var tpszN=sheetObjects[1].FindText("spcl_cgo_apro_cd", "N", 0, 2);
				var tpszP=sheetObjects[1].FindText("spcl_cgo_apro_cd", "P", 0, 2);
				var tpszR=sheetObjects[1].FindText("spcl_cgo_apro_cd", "R", 0, 2);
				var tpszY=sheetObjects[1].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
				if (tpszN > 0) {
					document.getElementById("spcl_cgo_auth_cd").value="N";
					document.getElementById("spcl_cgo_auth_cd").style.color="red";
				} else if (tpszP > 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color="black";
					document.getElementById("spcl_cgo_auth_cd").value="P";
				} else if (tpszR > 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color="black";
					document.getElementById("spcl_cgo_auth_cd").value="R";
				} else if (tpszY > 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color="black";
					document.getElementById("spcl_cgo_auth_cd").value="Y";
				} else {
					document.getElementById("spcl_cgo_auth_cd").style.color="black";
					document.getElementById("spcl_cgo_auth_cd").value="";
				} 
				
				for ( var a=1; a <= sheetObjects[3].RowCount(); a++) {
					sheetObjects[3].SetCellValue(a, "ibflag","R",0);
				}
				for ( var b=1; b <= sheetObjects[1].RowCount(); b++) {
					sheetObjects[1].SetCellValue(b, "ibflag","R",0);
				}
				
				if (sheetObjects[1].RowCount()< 1 && document.getElementById("bl_no").value != "") {
					rowAdd();
				} else if (sheetObjects[1].RowCount()< 1 && document.getElementById("bl_no").value == "") {
					ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
					ComResetAll();
					return;
				}

				htmlSheetSync();
			}
			//------------------------------------------------>
			if (ComGetObjValue(document.form.isInquiry) == "Y") {
				setInquiryDisableButton();
			}
			imdg_pck_grp_cd.SetEnable(false);
			// #CSR 14449
//			chkForFlshPnt(1, "N"); // Change only editable or not
			
			//search BCC email address for DG email
			var bccEmlAddr=ComGetEtcData(arrXml[0],"bcc_eml_addr");
			if(bccEmlAddr != ""){
				formObj.com_blindCarbonCopy.value = bccEmlAddr;
			}
			
			break;
			
		case COMMAND04: //retrieving booking split no 
			formObj.f_cmd.value=COMMAND03;
			var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
			var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
			bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 25);
			break;
			
		case MULTI: 
			var cntrNo="";
			var oldCntrNo="";
			var dgChkFlg="N";
			var flshPntCdoTemp="";
			if (validateForm(sheetObj, formObj, sAction)) {
				//set fixed value to WGT_UT_CD
				for (j=1;j<=sheetObjects[3].RowCount();j++){
					if((sheetObjects[3].GetCellValue(j, "ibflag") == "I") || (sheetObjects[3].GetCellValue(j, "ibflag") == "U")){
						if(sheetObjects[3].GetCellValue(j, "wgt_ut_cd") != "KGS"){
							sheetObjects[3].SetCellValue(j, "wgt_ut_cd", "KGS");
						}
					}
				}
				
				
				if (sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y") {
					ComShowMessage(ComGetMsg("BKG00004"));
					chkFlg="Y";
					return;
				}
				
				if (saveChkFlg == "Y") { //Come from SAVE button or save before REQUEST
					var cntR=0;
					var cntHCDG=0;
					//Check updated rows exist or not
					for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetCellValue(i, "ibflag") != "R") {
							cntR++;
						}
					}
					if (cntR < 1) {
						ComShowMessage(ComGetMsg("BKG00501"));
						saveEnd="Y";
						return;
					}
					//Value validation
					for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
						// Validate Skip in case of delete
						if( sheetObjects[3].GetRowHidden(i) || sheetObjects[3].GetCellValue(i, "ibflag") == "D"){
							
							continue;
						}
						if (sheetObjects[3].GetCellValue(i, "apro_cd") != "C" || sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") != "C" || sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
							if (sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
								ComShowMessage(ComGetMsg("BKG00500"));
								chkFlg="Y";
								return;
							}
							for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
								if (sheetObjects[3].GetCellValue(i, "cntr_no") == sheetObjects[1].GetCellValue(j, "cntr_no") && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == sheetObjects[1].GetCellValue(j, "dg_cntr_seq")) {
									var seq=sheetObjects[1].GetCellValue(j, "seq");
								}
							}
							var cntr_cgo_seq=sheetObjects[3].GetCellValue(i, "cntr_cgo_seq");
							if (document.getElementById("bkg_no").value != sheetObjects[3].GetCellValue(i, "bkg_no")) {
								ComShowCodeMessage("BKG00048", sheetObjects[3].GetCellValue(i, "bkg_no"), document.getElementById("bkg_no").value);
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "cntr_tpsz_cd") == "") {
								ComShowCodeMessage("BKG08126", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
									if (sheetObjects[1].GetCellValue(j, "cntr_tpsz_cd") == "") {
										sheetObjects[1].SelectCell(j, "cntr_tpsz_cd");
									}
								}
								return;
							}
							//IMDG Class Valid
							if (sheetObjects[3].GetCellValue(i, "imdg_clss_cd") == "") {
								ComShowCodeMessage("BKG00445", " IMDG Class [" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;							
							}
							var prp_shp_nm=(sheetObjects[3].GetCellValue(i, "prp_shp_nm")).toUpperCase();
							if (prp_shp_nm.indexOf(" OR ") > -1) {
								ComShowCodeMessage("BKG00539", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (prp_shp_nm.indexOf(" NOS") > -1 || prp_shp_nm.indexOf(" N.O.S") > -1) {
								if (sheetObjects[3].GetCellValue(i, "hzd_desc") == "") {
									ComShowCodeMessage("BKG00761", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg="Y";
									return;
								}
							}
							// #CSR 14349
							if(sheetObjects[3].GetCellValue(i, "mrn_polut_flg") == "Y" && sheetObjects[3].GetCellValue(i, "hzd_desc") == ""){
								ComShowCodeMessage("BKG08352", "[" + seq + "." + cntr_cgo_seq + "]");
								return;
							}
							//check number , decimal point, max value of flash point
							if(sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") != ""){
								flshPntCdoTemp = sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp");
								if(isNaN(flshPntCdoTemp)){ // Not A Number
									ComShowCodeMessage("BKG01177", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg="Y";
									return;
								}else{
									if((flshPntCdoTemp>=1000) || (flshPntCdoTemp<=-1000)){
										ComShowCodeMessage("BKG01177", "[" + seq + "." + cntr_cgo_seq + "]");
										chkFlg="Y";
										return;
									}else{
										if(flshPntCdoTemp.toString().indexOf('.') > -1){  // Check decimal point length
											if(flshPntCdoTemp.toString().split(".")[1].length > 1){
												ComShowCodeMessage("BKG01178", "1", "[" + seq + "." + cntr_cgo_seq + "]");
												chkFlg="Y";
												return;
											}
										}									
									}
								}
							}
							if (sheetObjects[3].GetCellValue(i, "imdg_clss_cd") == "3" || sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd1") == "3" || sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd2") == "3" || sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd3") == "3" || sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd4") == "3"
									// #CSR 14449
									|| sheetObjects[3].GetCellValue(i, "imdg_un_no") == "3255" || sheetObjects[3].GetCellValue(i, "imdg_un_no") == "3257" ) {
								if (sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") == "") {
									ComShowCodeMessage("BKG00540", "[" + seq + "." + cntr_cgo_seq + "]");  
									chkFlg="Y";
									return;
								}
								if (sheetObjects[3].GetCellValue(i, "imdg_pck_grp_cd") == "3") {
									if (sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") >= 23 && sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") <= 60) {
									} else {
										ComShowCodeMessage("BKG00541", "[" + seq + "." + cntr_cgo_seq + "]");
									}
								}
								if (sheetObjects[3].GetCellValue(i, "imdg_pck_grp_cd") == "1" || sheetObjects[3].GetCellValue(i, "imdg_pck_grp_cd") == "2") {
									if (sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") < 23) {
									} else {
										ComShowCodeMessage("BKG00542", "[" + seq + "." + cntr_cgo_seq + "]");
									}
								}
//							}else{
//								if (sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") != "") {
//									ComShowCodeMessage("BKG00601", "[" + seq + "." + cntr_cgo_seq + "]");
//									chkFlg="Y";
//									return;
//								}
							}
							if (sheetObjects[3].GetCellValue(i, "imdg_lmt_qty_flg") == "Y") {
								if ((sheetObjects[3].GetCellValue(i, "ltd_qty") == "0" || sheetObjects[3].GetCellValue(i, "ltd_qty") == "") && sheetObjects[3].GetCellValue(i, "imdg_lmt_qty_desc") == "") {
									ComShowCodeMessage("BKG00543", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg="Y";
									return;
								}
							}
							if (sheetObjects[3].GetCellValue(i, "imdg_expt_qty_flg") == "Y") {
								if ((sheetObjects[3].GetCellValue(i, "imdg_expt_qty_cd") == "E0" || sheetObjects[3].GetCellValue(i, "imdg_expt_qty_cd") == "") && sheetObjects[3].GetCellValue(i, "imdg_expt_qty_desc") == "") {
									ComShowCodeMessage("BKG00544", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg="Y";
									return;
								}
							}
							if (sheetObjects[3].GetCellValue(i, "cntr_cgo_seq") == "") {
								ComShowCodeMessage("BKG00578", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "imdg_un_no") == "") {
								ComShowCodeMessage("BKG00579", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							//IMDG UN No SEQ Valid
							if (sheetObjects[3].GetCellValue(i, "imdg_un_no_seq") == "" || sheetObjects[3].GetCellValue(i, "imdg_un_no_seq") == "0") {
								ComShowCodeMessage("BKG02122", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;							
							}
							if (sheetObjects[3].GetCellValue(i, "emer_cntc_phn_no_ctnt") == "") {
								ComShowCodeMessage("BKG00580", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "emer_cntc_pson_nm") == "") {
								ComShowCodeMessage("BKG00691", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty1") == "" || sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty1") == "0") {
								ComShowCodeMessage("BKG00581", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "out_imdg_pck_cd1") == "") {
								ComShowCodeMessage("BKG00582", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "grs_wgt") == "" || sheetObjects[3].GetCellValue(i, "grs_wgt") == "0") {
								ComShowCodeMessage("BKG00585", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "net_wgt") == "" || sheetObjects[3].GetCellValue(i, "net_wgt") == "0") {
								ComShowCodeMessage("BKG00586", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
//							if (sheetObjects[3].GetCellValue(i, "dcgo_sts_cd") == "") {
//								ComShowCodeMessage("BKG00587", "[" + seq + "." + cntr_cgo_seq + "]");
//								chkFlg="Y";
//								return;
//							}
							if ((sheetObjects[3].GetCellValue(i, "imdg_spcl_provi_no") == "274" || sheetObjects[3].GetCellValue(i, "imdg_spcl_provi_no") == "318" 
								|| sheetObjects[3].GetCellValue(i, "imdg_mrn_polut_cd") == "P") && sheetObjects[3].GetCellValue(i, "hzd_desc") == "") {
								ComShowCodeMessage("BKG00761", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if (sheetObjects[3].GetCellValue(i, "imdg_crr_rstr_expt_cd") == "R") {   
								var unNo=sheetObjects[3].GetCellValue(i, "imdg_un_no");
								var crrCd=sheetObjects[3].GetCellValue(i, "crr_cd");
								ComShowCodeMessage("BKG00762", crrCd, unNo);
							}
							if (sheetObjects[3].GetCellValue(i, "imdg_lmt_qty_flg") == "") {
								ComShowCodeMessage("BKG00589", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg="Y";
								return;
							}
							if ((sheetObjects[3].GetCellValue(i, "imdg_clss_cd")).indexOf("1") == "0") {
								if (sheetObjects[3].GetCellValue(i, "cnee_dtl_desc") == "" || sheetObjects[3].GetCellValue(i, "net_explo_wgt") == "0" || sheetObjects[3].GetCellValue(i, "net_explo_wgt") == "") {
									ComShowCodeMessage("BKG00559", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg="Y";
									return;
								}
							}
							if ((sheetObjects[3].GetCellValue(i, "imdg_clss_cd")).indexOf("7") == "0") {
								if (sheetObjects[3].GetCellValue(i, "rada_skd_no") == "" || sheetObjects[3].GetCellValue(i, "rada_trsp_no") == "" || sheetObjects[3].GetCellValue(i, "rada_amt") == "") {
									ComShowCodeMessage("BKG00560", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg="Y";
									return;
								}
							}
							if (sheetObjects[3].GetCellValue(i, "hcdg_flg") == "Y" && sheetObjects[3].GetCellValue(i, "hcdg_qty") == "1") {
								cntHCDG++;
							}
							if(isNaN(sheetObjects[3].GetCellValue(i, "rada_trsp_no"))){
								ComShowMessage(ComGetMsg("BKG08176"));
								return;
							}
							// make Flg for Vender 301 sending in case of Cntr No changed
							cntrNo=sheetObjects[3].GetCellValue(i, "cntr_no");
							oldCntrNo=sheetObjects[3].CellSearchValue(i, "cntr_no");
							if ( dgChkFlg == "N" && cntrNo != oldCntrNo ) {
								dgChkFlg="Y";
							}
						}
					}
					if (cntHCDG > 0) {
						if (ComShowConfirm(ComGetMsg("BKG00563"))) {
						} else {
							chkFlg="Y";
							return;
						}
					}
					var cntSum=0;
					var rcnt=0;
					var find_tpsz_cd="";
					var cnt_tpsz=0;
					var qtyCnt=0;
					var dcgo_qty=0;
					var fhFlg=sheetObjects[2].GetCellValue(1, "flex_hgt_flg");
					var d4d5CntBkg=0;
					var d4d5CntDg=0;
					var tpszBkg="";
					var tpszDg="";
					if (sheetObjects[0].RowCount()> 0) {
						for ( var j=1; j <= sheetObjects[0].RowCount(); j++) {
							cntSum=0; //Count of container type/size in sheetObjects[1] based on sheetObjects[0] type/size
							tpszBkg=sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd");
							if(fhFlg == "Y" && (tpszBkg == "D4" || tpszBkg == "D5")) {
								d4d5CntBkg += sheetObjects[0].GetCellValue(j, "dcgo_qty");
							}
							for ( var m=1; m <= sheetObjects[1].RowCount(); m++) {
								tpszDg=sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd");
								if (sheetObjects[1].GetCellValue(m, "ibflag") != "D" && sheetObjects[1].GetCellValue(m, "spcl_cgo_apro_cd") != "C") {
									if(tpszBkg == tpszDg) {
										cntSum += Number(sheetObjects[1].GetCellValue(m, "cntr_vol_qty"));
										if(fhFlg == "Y" && (tpszDg == "D4" || tpszDg == "D5")) {
											d4d5CntDg += Number(sheetObjects[1].GetCellValue(m, "cntr_vol_qty"));
										}
									}
									var find_tpsz_row=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd"), 0, 2);
									if (!(fhFlg == "Y" && (tpszDg == "D4" || tpszDg == "D5")) && find_tpsz_row < 0) {
										rcnt++;
										find_tpsz_cd += sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd") + ",";
									}
								}
							}
							if (rcnt > 0) {
								find_tpsz_cd=find_tpsz_cd.substr(0, find_tpsz_cd.length - 1);
								ComShowCodeMessage("BKG08023", find_tpsz_cd);
								chkFlg="Y";
								return;
							}
							var find_tpsz_cd=sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd"), 0, 2);
							if (!(fhFlg == "Y" && (tpszBkg == "D4" || tpszBkg == "D5")) && find_tpsz_cd > 0) {
								if (Number(sheetObjects[0].GetCellValue(j, "dcgo_qty")) > cntSum) {
									qtyCnt++;
									cntSum=0;
								}
								if (Number(sheetObjects[0].GetCellValue(j, "dcgo_qty")) == cntSum) {
									cntSum=0;
								}
								if (Number(sheetObjects[0].GetCellValue(j, "dcgo_qty")) < cntSum) {
									ComShowCodeMessage("BKG00679", "DG");
									chkFlg="Y";
									return;
								}
							}
						}
						if(fhFlg == "Y") {
							if (d4d5CntBkg > d4d5CntDg) {
								qtyCnt++;
							}
							if (d4d5CntBkg < d4d5CntDg) {
								ComShowCodeMessage("BKG00679", "DG");
								chkFlg="Y";
								return;
							}
						}						
						if (qtyCnt > 0) {
							if (confirm(ComGetMsg("BKG00678", "DG"))) {
							} else {
								chkFlg="Y";
								return;
							}
						}
					} else {
						ComShowMessage(ComGetMsg("BKG00502", "DG"));
						chkFlg="Y";
						return;
					}
					
					if (messageFlg == "save") { //Come from SAVE button
						formObj.f_cmd.value=MULTI;
						setDgCntrSeqVal();
						var sParam=FormQueryString(formObj);
						sParam=sParam + "&" + "dg_chk_flg=" + dgChkFlg;
						var sParamSheet3=sheetObjects[3].GetSaveString();
						sParam=sParam + "&sheet3_" + sParamSheet3.replace(/&/g, '&sheet3_');
						var rXml=sheetObj.GetSaveData("ESM_BKG_0200GS.do", sParam);
						var rMsg=ComResultMessage(rXml);
						var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
//						autoRequestCond=ComGetEtcData(rXml, "autoRequestCond");
						var autoRequestExe=ComGetEtcData(rXml, "autoRequestExe");
//						specialRequest=ComGetEtcData(rXml, "specialRequest");
						// PSA send when DG save
						if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
							var errMsg01=ComGetEtcData(rXml,"psaValCode");
							if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
						    	var rmsg=errMsg01.split("<||>");
						    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
						    		ComShowCodeMessage("BKG06125");
						    	}else if ( rmsg[1] != "BKG95025" ){
						    		ComShowMessage(rmsg[3]);
						    	}
							}
						}
						if (rMsg == '' && messageFlg == "save") { //Success
							ComShowMessage(ComGetMsg("BKG00166"));
							retFlag="Y";
							if(autoRequestExe=="Y"){
								ComShowMessage(ComGetMsg("BKG08102"));								
							}
						} else {
							sheetObj.LoadSearchData(rXml,{Sync:0} );
							chkFlg="Y";
							return;
						}		
					}
				}
				if (requestFlg == "N" && saveChkFlg == "N") { //Come from save before REQUEST via VOP_SCG_0069
					requestFlg="N";
					saveEnd="Y";
					formObj.f_cmd.value=MULTI;
					setDgCntrSeqVal();
					var sParam=FormQueryString(formObj);
					// make Flg for Vender 301 sending in case of Cntr No changed
					sParam=sParam + "&" + "dg_chk_flg=" + dgChkFlg;
					var sParamSheet3=sheetObjects[3].GetSaveString();
					sParam=sParam + "&sheet3_" + sParamSheet3.replace(/&/g, '&sheet3_');
					var rXml=sheetObj.GetSaveData("ESM_BKG_0200GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
					// PSA send when DG save
					if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
						var errMsg01=ComGetEtcData(rXml,"psaValCode");
				    	var rmsg=errMsg01.split("<||>");
				    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
				    		ComShowCodeMessage("BKG06125");
				    	}else if ( rmsg[1] != "BKG95025" ){
				    		ComShowMessage(rmsg[3]);
				    	}	
					}
					if (rMsg == '') {
					} else {
						sheetObj.LoadSearchData(rXml,{Sync:0} );
						return;
					}
				}
			}
			break;
		case COMMAND01:
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value=COMMAND01;
			var sParam=FormQueryString(formObj);
			var sParamSheet1=sheetObjects[3].GetSaveString();
			if (sParamSheet1 != "") {
				sParam=sParam + "&sheet3_" + sParamSheet1.replace(/&/g, '&sheet3_');
			}
			var rXml=sheetObj.GetSaveData("ESM_BKG_0200GS.do", sParam);
			var rMsg=ComResultMessage(rXml);
			var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
			// PSA send when DG save
			if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
				var errMsg01=ComGetEtcData(rXml,"psaValCode");
		    	var rmsg=errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}	
			}
//			if (rMsg == '' && messageFlg == "save") {
//			if (rMsg == '' && messageFlg == "save" && autoRequestCond != "Y") {
			if (rMsg == '' && messageFlg == "save") {
				retFlag="Y";
				//ComShowMessage(ComGetMsg("BKG00166"));
//			} else if (rMsg == '' && messageFlg == "request") {
			} else if (rMsg == '' && (messageFlg == "request" || messageFlg == "save")) {
				retFlag="Y";
				ComShowMessage(ComGetMsg("BKG08102"));
			} else if (rMsg == '' && messageFlg == "requestCancel") {
				retFlag="Y";
				ComShowMessage(ComGetMsg("BKG08103"));
			} else {
				sheetObj.LoadSearchData(rXml,{Sync:0} );
				return;
			}
			break;
		case COMMAND02:
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value=COMMAND01;
			var sParam=FormQueryString(formObj);
			var sParamSheet1=sheetObjects[3].GetSaveString();
			if (sParamSheet1 != "") {
				sParam=sParam + "&sheet3_" + sParamSheet1.replace(/&/g, '&sheet3_');
			}
			var rXml=sheetObj.GetSaveData("ESM_BKG_0200GS.do", sParam);
			var rMsg=ComResultMessage(rXml);
			var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
			if (rMsg == '' && messageFlg == "save") {
				retFlag="Y";
				//ComShowMessage(ComGetMsg("BKG00166"));
			} else if (rMsg == '' && messageFlg == "request") {
				retFlag="Y";
				ComShowMessage(ComGetMsg("BKG08102"));
			} else if (rMsg == '' && messageFlg == "requestCancel") {
				retFlag="Y";
				ComShowMessage(ComGetMsg("BKG08103"));
			} else {
				sheetObj.LoadSearchData(rXml,{Sync:0} );
				return false;
			}
			break;
		case IBSEARCH_ASYNC05:   //Special Provisions check
			formObj.f_cmd.value=SEARCH03;
 		    var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_spcl_provi_no="+event.srcElement.value);
 		   var arrData=ComBkgXml2Array(sXml, "imdg_spcl_provi_no");
		    if (arrData != null && arrData.length > 0) {
			}else{
				ComShowCodeMessage("BKG08330", 'Special Provisions Creation');
				event.srcElement.value="";
	 			ComSetFocus(ComGetEvent());
			}
			break;
		case SEARCH01: 
			formObj.f_cmd.value=SEARCH01;
			var resultXml=sheetObj.GetSearchData("ESM_BKG_0200GS.do", FormQueryString(formObj));
			document.getElementById("dcgo_yn").value = ComGetEtcData(resultXml, "DCGO_YN");
			break;
			
		}
	}
	function cntrChk() {
		var Row=sheetObjects[1].GetSelectRow();
		var cnt=0;
		document.getElementById("cntr_cgo_seq").options.length=0;
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(Row, "cntr_no") != "") {
				if (sheetObjects[1].GetCellValue(Row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no") && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == sheetObjects[1].GetCellValue(Row, "dg_cntr_seq") && sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
					sheetObjects[3].SetCellValue(i, "CntrChk","1",0);
				} else {
					sheetObjects[3].SetCellValue(i, "CntrChk","0",0);
				}
			} else {
				if (sheetObjects[1].GetCellValue(Row, "cntr_no") == "" && sheetObjects[1].GetCellValue(Row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no") && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == sheetObjects[1].GetCellValue(Row, "dg_cntr_seq") && sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
					sheetObjects[3].SetCellValue(i, "CntrChk","1",0);
				} else {
					sheetObjects[3].SetCellValue(i, "CntrChk","0",0);
				}
			}
			if (sheetObjects[3].GetCellValue(i, "CntrChk") == "1") {
				var cntr_cgo_seq=sheetObjects[3].GetCellValue(i, "cntr_cgo_seq");
				document.getElementById("cntr_cgo_seq").options[cnt]=new Option(cntr_cgo_seq, cntr_cgo_seq);
				cnt++;
			}
			sheetObjects[3].SetCellValue(i, "bkg_cntr_seq",sheetObjects[3].GetCellValue(i, "dg_cntr_seq") + sheetObjects[3].GetCellValue(i, "cntr_cgo_seq"),0);
		}
		document.getElementById("cntr_cgo_seq_sum").value=cnt;
	}
	function htmlSheetSync() {
		Row=sheetObjects[1].GetSelectRow();
		var cnt=0;
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(Row, "cntr_no") != "") {
				if (sheetObjects[1].GetCellValue(Row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no") && sheetObjects[1].GetCellValue(Row, "cntr_cgo_seq") == sheetObjects[3].GetCellValue(i, "cntr_cgo_seq")) {
					sheetObjects[3].SetCellValue(i, "DelChk","1",0);
				} else {
					sheetObjects[3].SetCellValue(i, "DelChk","0",0);
				}
			} else {
				if (sheetObjects[1].GetCellValue(Row, "dg_cntr_seq") == sheetObjects[3].GetCellValue(i, "dg_cntr_seq") && sheetObjects[1].GetCellValue(Row, "cntr_cgo_seq") == sheetObjects[3].GetCellValue(i, "cntr_cgo_seq")) {
					sheetObjects[3].SetCellValue(i, "DelChk","1",0);
				} else {
					sheetObjects[3].SetCellValue(i, "DelChk","0",0);
				}
			}
		}
		document.getElementById("dg_cntr_seq").value=sheetObjects[1].GetCellValue(Row, "dg_cntr_seq");
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
//		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
//			if (sheetObjects[3].GetCellValue(find_row, "ibflag") == "D") {
//				if (sheetObjects[3].GetCellValue(i, "ibflag") != "D") {
//					find_row=i;
//					break;
//				}
//			}
//		}
		var find_row=getEditRowNo("");
		document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd");
		
		document.getElementById("cntr_no").value=sheetObjects[3].GetCellValue(find_row, "cntr_no");
		document.form.cntr_cgo_seq.value=sheetObjects[3].GetCellValue(find_row, "cntr_cgo_seq");
		document.getElementById("imdg_clss_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_clss_cd");
		if("Y"==sheetObjects[3].GetCellValue(find_row, "cfr_flg")){
			document.form.cfr_flg.checked=true;
		} else {
			document.form.cfr_flg.checked=false;					
		}
		document.getElementById("imdg_comp_grp_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_comp_grp_cd");
		document.getElementById("imdg_un_no").value=sheetObjects[3].GetCellValue(find_row, "imdg_un_no");
		document.getElementById("grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt");
		document.getElementById("temp_grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt");
		document.getElementById("net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
		document.getElementById("temp_net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
		document.getElementById("prp_shp_nm").value=sheetObjects[3].GetCellValue(find_row, "prp_shp_nm");
		document.getElementById("hzd_desc").value=sheetObjects[3].GetCellValue(find_row, "hzd_desc");
		document.getElementById("flsh_pnt_cdo_temp").value=sheetObjects[3].GetCellValue(find_row, "flsh_pnt_cdo_temp");
		document.getElementById("psa_no").value=sheetObjects[3].GetCellValue(find_row, "psa_no");
		document.form.imdg_lmt_qty_flg.value=sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_flg");
		document.form.imdg_expt_qty_flg.value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_flg");
		document.getElementById("imdg_amdt_no").value=sheetObjects[3].GetCellValue(find_row, "imdg_amdt_no");
		if (sheetObjects[3].GetCellValue(find_row, "hcdg_flg") == "Y") {
			document.getElementById("hcdg_flag").value="HCDG";
		} else {
			document.getElementById("hcdg_flag").value="";
		}
		if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "Y") {
			document.getElementById("approved").setAttribute("style", "color:black!important"); 
			document.getElementById("approved").innerHTML="approved";
		} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "N") {
			document.getElementById("approved").setAttribute("style", "color:red!important"); 
			document.getElementById("approved").innerHTML="Rejected";
		} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "R") {
			document.getElementById("approved").setAttribute("style", "color:blue!important"); 
			document.getElementById("approved").innerHTML="Requested";
		} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "P") {
			document.getElementById("approved").setAttribute("style", "color:black!important"); 
			document.getElementById("approved").innerHTML="Pending";
		} else if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "C") {
			document.getElementById("approved").setAttribute("style", "color:black!important"); 
			document.getElementById("approved").innerHTML="Canceled";
		} else {
			document.getElementById("approved").innerHTML="";
		}
		if (sheetObjects[3].GetCellValue(find_row, "diff_rmk").length > 1) {
			document.getElementById("btn_Remark").setAttribute("style", "font-weight: bold;color:blue!important"); 
		} else {
			document.getElementById("btn_Remark").setAttribute("style", "color:##A0BAED!important"); 
		}
		document.getElementById("imdg_subs_rsk_lbl_cd1").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd1");
		document.getElementById("imdg_subs_rsk_lbl_cd2").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd2");
		document.getElementById("imdg_subs_rsk_lbl_cd3").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd3");
		document.getElementById("imdg_subs_rsk_lbl_cd4").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd4");
		dcgo_sts_cd.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "dcgo_sts_cd"));
		/* combo ojbect 로 변경 되어 combo 값 셋팅 */
//		imdg_pck_grp_cd.SetSelectIndex(sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd"));
		setImdg_pck_grp_cdCombo(sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd"));
		
		document.form.mrn_polut_flg.value=sheetObjects[3].GetCellValue(find_row, "mrn_polut_flg");
		document.getElementById("emer_cntc_phn_no_ctnt").value=sheetObjects[3].GetCellValue(find_row, "emer_cntc_phn_no_ctnt");
		document.getElementById("emer_cntc_pson_nm").value=sheetObjects[3].GetCellValue(find_row, "emer_cntc_pson_nm");
		document.getElementById("certi_no").value=sheetObjects[3].GetCellValue(find_row, "certi_no");
		document.getElementById("cnee_dtl_desc").value=sheetObjects[3].GetCellValue(find_row, "cnee_dtl_desc");
		document.getElementById("net_explo_wgt").value=sheetObjects[3].GetCellValue(find_row, "net_explo_wgt");
		document.getElementById("rada_skd_no").value=sheetObjects[3].GetCellValue(find_row, "rada_skd_no");
		document.getElementById("rada_amt").value=sheetObjects[3].GetCellValue(find_row, "rada_amt");
		rada_ut_cd.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "rada_ut_cd"));
		document.getElementById("rada_trsp_no").value=sheetObjects[3].GetCellValue(find_row, "rada_trsp_no");
		document.getElementById("temp_cntr_no").value=sheetObjects[3].GetCellValue(find_row, "cntr_no");
		document.getElementById("in_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd1");
		document.getElementById("in_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd2");
		document.getElementById("intmd_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_cd1");
		document.getElementById("intmd_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_cd2");
		document.getElementById("out_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd1");
		document.getElementById("out_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd2");
		document.getElementById("in_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_desc1");
		document.getElementById("in_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_desc2");
		document.getElementById("intmd_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_desc1");
		document.getElementById("intmd_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_desc2");
		document.getElementById("out_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_desc1");
		document.getElementById("out_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_desc2");
		document.getElementById("in_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty1");
		document.getElementById("in_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty2");
		document.getElementById("intmd_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_qty1");
		document.getElementById("intmd_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_qty2");
		document.getElementById("imdg_expt_qty_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_cd");
		document.getElementById("imdg_expt_qty_desc").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_desc");
		document.getElementById("out_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty1");
		document.getElementById("out_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty2");
		document.getElementById("max_in_pck_qty").value=sheetObjects[3].GetCellValue(find_row, "max_in_pck_qty");
		document.getElementById("max_in_pck_tp_cd").value=sheetObjects[3].GetCellValue(find_row, "max_in_pck_tp_cd");
		document.getElementById("hcdg_intmd_bc_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_intmd_bc_rstr_desc");
		document.getElementById("hcdg_pck_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_pck_rstr_desc");
		document.getElementById("hcdg_tnk_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_tnk_rstr_desc");
		document.getElementById("ltd_qty").value=sheetObjects[3].GetCellValue(find_row, "ltd_qty");
		document.getElementById("imdg_lmt_qty_desc").value=sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_desc");
		document.getElementById("hzd_desc").value=sheetObjects[3].GetCellValue(find_row, "hzd_desc");
		document.getElementById("ems_no").value=sheetObjects[3].GetCellValue(find_row, "ems_no");
		document.getElementById("emer_rspn_gid_no").value=sheetObjects[3].GetCellValue(find_row, "emer_rspn_gid_no");
		document.getElementById("emer_rspn_gid_chr_no").value=sheetObjects[3].GetCellValue(find_row, "emer_rspn_gid_chr_no");
		document.getElementById("ctrl_temp_ctnt").value=sheetObjects[3].GetCellValue(find_row, "ctrl_temp_ctnt");
		document.getElementById("emer_temp_ctnt").value=sheetObjects[3].GetCellValue(find_row, "emer_temp_ctnt");
		document.getElementById("diff_rmk").value=sheetObjects[3].GetCellValue(find_row, "diff_rmk");
		var imdg_clss_cd=document.getElementById("imdg_clss_cd").value;
		var imdg_subs_rsk_lbl_cd1=document.getElementById("imdg_subs_rsk_lbl_cd1").value;
		var imdg_subs_rsk_lbl_cd2=document.getElementById("imdg_subs_rsk_lbl_cd2").value;
		var imdg_subs_rsk_lbl_cd3=document.getElementById("imdg_subs_rsk_lbl_cd3").value;
		var imdg_subs_rsk_lbl_cd4=document.getElementById("imdg_subs_rsk_lbl_cd4").value;
		document.getElementById("clod_flg").value=sheetObjects[3].GetCellValue(find_row, "clod_flg");
		document.getElementById("rc_flg").value=sheetObjects[3].GetCellValue(find_row, "rc_flg");
		document.getElementById("awk_cgo_flg").value=sheetObjects[3].GetCellValue(find_row, "awk_cgo_flg");
		document.getElementById("bb_cgo_flg").value=sheetObjects[3].GetCellValue(find_row, "bb_cgo_flg");
		document.getElementById("hcdg_flg").value=sheetObjects[3].GetCellValue(find_row, "hcdg_flg");
		document.getElementById("meas_qty").value=sheetObjects[3].GetCellValue(find_row, "meas_qty");
		document.getElementById("hcdg_dpnd_qty_flg").value=sheetObjects[3].GetCellValue(find_row, "hcdg_dpnd_qty_flg");
		document.getElementById("spcl_rqst_flg").value=sheetObjects[3].GetCellValue(find_row, "spcl_rqst_flg");
		document.getElementById("imdg_un_no_seq").value=sheetObjects[3].GetCellValue(find_row, "imdg_un_no_seq");
		document.getElementById("crr_cd").value=sheetObjects[3].GetCellValue(find_row, "crr_cd");
		document.getElementById("dcgo_seq").value=sheetObjects[3].GetCellValue(find_row, "dcgo_seq");
		document.getElementById("aply_no").value=sheetObjects[3].GetCellValue(find_row, "aply_no");
		if (sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "C" || sheetObjects[3].GetCellValue(find_row, "spcl_cgo_apro_cd") == "") {
			document.getElementById("btn_cancel").disabled=true;
			cancelFlg="Y";
		} else {
			document.getElementById("btn_cancel").disabled=false;
			cancelFlg="N";
		}
		temp_imdg_un_no=document.getElementById("imdg_un_no").value;
		imdg_segr_grp_no.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "imdg_segr_grp_no"));
		document.form.rsd_flg.value=sheetObjects[3].GetCellValue(find_row, "rsd_flg");
		document.form.dcgo_ref_no.value=sheetObjects[3].GetCellValue(find_row, "dcgo_ref_no");
		
		//set imdg_segr_grp_no1~4
		setImdg_segr_grp_nos(sheetObjects[3].GetCellValue(find_row, "imdg_segr_grp_nos"));

		//2015.11.24. erap
		document.getElementById("erap_no").value=sheetObjects[3].GetCellValue(find_row, "erap_no");
		document.getElementById("erap_cntc_no").value=sheetObjects[3].GetCellValue(find_row, "erap_cntc_no");
		document.getElementById("erap_apro_ref_no").value=sheetObjects[3].GetCellValue(find_row, "erap_apro_ref_no");
		//2015.11.25. dot references
		document.getElementById("dot_exp_no").value=sheetObjects[3].GetCellValue(find_row, "dot_exp_no");
		document.getElementById("dot_spcl_apro_no").value=sheetObjects[3].GetCellValue(find_row, "dot_spcl_apro_no");
		document.getElementById("dot_auth_no").value=sheetObjects[3].GetCellValue(find_row, "dot_auth_no");
		//2015.11.26. IMDG_UN_NO_SPCL_PROVI_CTNT(provi_no^dp_seq|)
		setProviNo(sheetObjects[3].GetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt"));
		chkForFlshPnt(find_row, "N");
	}
	/**
	 * handler fnCntrComboItem event 
	 * @param sheetObj, Row, Col, Value
	 */
	function fnCntrComboItem(sheetObj, row, col, val) {
		var cntr_name="";
		var cntr_val="";
		for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
			if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
			}
		}
		cntr_val=cntr_val.substr(0, cntr_val.length - 1);
		cntr_name=cntr_name.substr(0, cntr_name.length - 1);
		var checkCntr=sheetObjects[4].FindText("DelChk", "0", 0, 2);
		var i=row;
		if (checkCntr > 0) {
			if (val != "") {
//				sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_name, " |" + sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_val);
				sheetObjects[1].CellComboItem(i, "cntr_no", {ComboText:" |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_name, ComboCode:" |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_val} );
				sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
				sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",0);
			} else {
				sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
				sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
				sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",1);
			}
		} else {
			if (val != "") {
//				sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no"), " |" + sheetObjects[1].CellValue(i, "cntr_no"));
				sheetObjects[1].CellComboItem(i, "cntr_no", {ComboText:" |" + sheetObjects[1].GetCellValue(i, "cntr_no"), ComboCode:" |" + sheetObjects[1].GetCellValue(i, "cntr_no")});
				sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
				sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",0);
			} else {
//				sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"", ComboCode:""} );
				sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:" |", ComboCode:" |"} );
				sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
				sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",1);
			}
		}
	}
	/**
	 * handler sheet2_OnClick event 
	 * @param sheetObj, Row, Col, Value
	 */
	function sheet2_OnClick(sheetObj, row, col, val) {
		var col_name=sheetObj.ColSaveName(col);
		cntrChk();
		htmlSheetSync();
		switch (col_name) {
		case "cntr_no":
			fnCntrComboItem(sheetObj, row, col, val);
			break;
		}
	}
	/**
	 * handler sheet2_OnChange event 
	 * @param sheetObj, Row, Col, Value
	 */
	function sheet2_OnChange(sheetObj, row, col, val) {
		var col_name=sheetObj.ColSaveName(col);
		switch (col_name) {
		case "cntr_no":
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				if (sheetObjects[1].GetCellValue(row, "dg_cntr_seq") == sheetObjects[3].GetCellValue(i, "dg_cntr_seq")) {
					sheetObjects[3].SetCellValue(i, "cntr_no",sheetObjects[1].GetCellValue(row, "cntr_no"),0);
				}
			}
			if (sheetObjects[1].GetCellValue(row, "cntr_no") != "") {
				var temp_cntr_no=document.getElementById("temp_cntr_no").value;
				var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
				if (temp_cntr_no != "") {
					sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
				}
				var cntr_no=sheetObjects[1].GetCellValue(row, "cntr_no");
				var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
				if (sheetObjects[1].GetCellValue(row, "cntr_no") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd")) {
					if (ComShowConfirm(ComGetMsg("BKG00570"))) {
						sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd"),0);
						document.getElementById("cntr_tpsz_cd").value=sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd");
					} else {
						sheetObjects[1].SetCellValue(row, "cntr_no","",0);
						cntr_no="";
					}
				} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "") {
					sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd"),0);
					document.getElementById("cntr_tpsz_cd").value=sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd");
				}
				sheetObjects[1].SetCellValue(row, "cntr_vol_qty",sheetObjects[4].GetCellValue(find_row, "cntr_vol_qty"),0);
				for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
					if (sheetObjects[1].GetCellValue(row, "dg_cntr_seq") == sheetObjects[3].GetCellValue(i, "dg_cntr_seq")) {
						sheetObjects[3].SetCellValue(i, "cntr_tpsz_cd",document.getElementById("cntr_tpsz_cd").value,0);
						sheetObjects[3].SetCellValue(i, "cntr_vol_qty",sheetObjects[4].GetCellValue(find_row, "cntr_vol_qty"),0);
					}
				}
				if (cntr_no != "") {
					sheetObjects[4].SetCellValue(find_row, "DelChk","1",0);
				}
				} else {
				var temp_cntr_no=document.getElementById("temp_cntr_no").value;
				if (temp_cntr_no != "") {
					var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
					sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
				}
			}
			break;
			
		case "cntr_vol_qty":
			if (Number(sheetObjects[1].GetCellValue(row, "cntr_vol_qty")) > 1) {
				ComShowMessage(ComGetMsg("BKG08013"));
				sheetObjects[1].SetCellValue(row, "cntr_vol_qty","",0);
			}
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				if (sheetObjects[1].GetCellValue(row, "dg_cntr_seq") == sheetObjects[3].GetCellValue(i, "dg_cntr_seq") && sheetObjects[1].GetCellValue(row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no")) {
					sheetObjects[3].SetCellValue(i, "cntr_vol_qty",sheetObjects[1].GetCellValue(row, "cntr_vol_qty"),0);
				}
			}
			break;
			
		case "cntr_tpsz_cd":
			sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",(sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).toUpperCase(),0);
			var tpsz_row1=sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"), 0, 2);
			var tpsz_row2=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"), 0, 2);
			var sum=0;
			if (sheetObjects[1].GetCellValue(row, "cntr_vol_qty") == "" || sheetObjects[1].GetCellValue(row, "cntr_vol_qty") == "0") {
				sheetObjects[1].SetCellValue(row, "cntr_vol_qty",sheetObjects[0].GetCellValue(tpsz_row2, "dcgo_qty"),0);
			}
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				if (sheetObjects[1].GetCellValue(row, "dg_cntr_seq") == sheetObjects[3].GetCellValue(i, "dg_cntr_seq") && sheetObjects[1].GetCellValue(row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no")) {
					sheetObjects[3].SetCellValue(i, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"),0);
				}
			}
			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
				if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")) {
					sum += Number(sheetObjects[1].GetCellValue(i, "cntr_vol_qty"))
				}
			}
			break;
		}
	}
	// handler retrieving complete by retrieve function
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			SetColBackColor("RFQTY","#CCFFFD");
		}
	}
	
	//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			
			/* Image Storage 에 AK 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
			if(sheetObjects[2].RowCount() > 0){
				if(sheetObjects[2].GetCellValue(1,"img_flg") =='Y'){
//					document.getElementById('btn_attach').style.color = 'blue';
					ComGetObject("btn_attach").style.setProperty("color", BTN_BLUE, "important");
				}else{
//					document.getElementById('btn_attach').style.color = '';
					ComGetObject("btn_attach").style.setProperty("color", "", "");
				}
			}
		}
	}	
	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * initializing Tab
	 * setting Tab items
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0;
				InsertItem( "Class 1 Only", "");
				InsertItem( "Class 7 Only", "");
			}
			break;
		}
		tabObj.SetSelectedIndex(0);
	}
	/**
	 * Event when clicking Tab
	 * activating selected tab items
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		beforetab=nItem;
	}
	 /**
	  * when dcgo_sts_cd chage
	  */
	function dcgo_sts_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var find_row=getEditRowNo("");
		sheetObjects[3].SetCellValue(find_row, "dcgo_sts_cd",text,0);
	}
	 /**
	  * when change imdg_pck_grp_cd
	  */
//	function imdg_pck_grp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){
//	 	var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//	 	var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
//		var find_row=getEditRowNo("");
//	 	if(newindex == -1)	comboObj.SetSelectIndex(0);
//	 	sheetObjects[3].SetCellValue(find_row, "imdg_pck_grp_cd",comboObj.GetSelectIndex(),0);
//	}
	/**
	 * when change imdg_pck_grp_cd
	 */
	function imdg_segr_grp_no_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var find_row=getEditRowNo("");
		sheetObjects[3].SetCellValue(find_row, "imdg_segr_grp_no",code,0);
	}
	/**
	 * when change rada_ut_cd
	 */
	function rada_ut_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){
//		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		var find_row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var find_row=getEditRowNo("");
		sheetObjects[3].SetCellValue(find_row, "rada_ut_cd",code,0);
	}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		}
		return true;
	}
	/*
	 * RD print
	 */
	function goPrint() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var rdPath="apps/opus/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargoreceipt/repoort/ESM_BKG_5004.mrd";
		var where="";
		var param=new Array("bkg_no");
		var strTitle="Dangerous Cargo Information";
		if (param == "") {
			ComShowCodeMessage("BKG00495");
		}
		where=getParam(param);
		formObj.com_mrdPath.value=rdPath;
		formObj.com_mrdArguments.value="/rv " + where;
		//formObj.com_mrdDisableToolbar.value = strToolbar;
		formObj.com_mrdTitle.value=strTitle;
		formObj.com_mrdBodyTitle.value="<span style='color:red'>" + strTitle + "</span>";
		ComOpenRDPopup();
	}
	/*
	 * get parameter for send RD printer
	 * @param string 
	 * @return string  
	 */
	function getParam(param) {
		var formObj=document.form;
		var rParam="";
		for (i=0; i < param.length; i++) {
			rParam += param[i] + "[" + ComGetObjValue(eval("document.form." + param[i])) + "] ";
		}
		return rParam;
	}
	/**
	 * disable in case of do ComBtnDisable
	 * @param 
	 */
	function setInquiryDisableButton() {
//		ComBtnDisable("btn_attach");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_request");
		ComBtnDisable("btn_email");
		ComBtnDisable("btn_print");
		ComBtnDisable("pre_checking_reports_btn");
	}
	/*
	 * get editing row of sheet3(in case delete button clicked some row has same bkg_cntr_seq value
	 * @param bkg_cntr_seq 
	 * @return string  
	 */
	function getEditRowNo(bkg_cntr_seq) {
		if (bkg_cntr_seq==""){
			bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
		}
		var row=0;
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if((sheetObjects[3].GetCellValue(i, "bkg_cntr_seq")==bkg_cntr_seq)&&(sheetObjects[3].GetCellValue(i, "ibflag")!="D")){
				row=i;
				break;
			}
		}		
		return row;
	}

	/*
	 * control the display of imdg_pck_grp_cd combo box
	 * @param grp_cd   
	 */
	function setImdg_pck_grp_cdCombo(grp_cd) {
		if(grp_cd==""){
			grp_cd = "0";
		}
		imdg_pck_grp_cd.SetSelectIndex(grp_cd);	
	}

	/*
	 * control the display of imdg_segr_grp_no1~4
	 * @param grp_cd   
	 */
	function setImdg_segr_grp_nos(imdgSegrGrpNos) {
		
		document.getElementById("imdg_segr_grp_no1").value = "";
		document.getElementById("imdg_segr_grp_no2").value = "";
		document.getElementById("imdg_segr_grp_no3").value = "";
		document.getElementById("imdg_segr_grp_no4").value = "";
		
		if (imdgSegrGrpNos != "") {
			var imdgSegrGrpNosArr=imdgSegrGrpNos.split(",");
			for(i=0;i < imdgSegrGrpNosArr.length; i++){
				document.getElementById("imdg_segr_grp_no" + (i + 1)).value = imdgSegrGrpNosArr[i];
			}
		}
	}

	/*
	 * set correct dg_cntr_seq because retrieved dg_cntr_seq and the one in database are different.
	 * @param    
	 */
	function setDgCntrSeqVal() {
		//if dg_cntr_seq is differnet from database value, that should be updated.
		for (i=1; i <= sheetObjects[3].RowCount(); i++) {
			if((sheetObjects[3].GetCellValue(i,"ibflag")=="R") && (sheetObjects[3].GetCellValue(i,"dg_cntr_seq") != (sheetObjects[3].GetCellValue(i,"dg_cntr_seq_original")))){
				sheetObjects[3].SetCellValue(i, "ibflag","U",0);
			}
		}
	}

	/*
	 * create string to call 0204 popup screen
	 * @param    
	 */
	function callPopup0204() {
		ComOpenPopup(	"ESM_BKG_0204.do?imdg_un_no=" + document.getElementById("imdg_un_no").value
				     + 	"&bkg_no=" + document.getElementById("bkg_no").value 
				     + 	"&imdg_amdt_no=" + document.getElementById("imdg_amdt_no").value
				     +    "&pol_cd=" + document.getElementById("pol_cd").value
				     +    "&pod_cd=" + document.getElementById("pod_cd").value
					, 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
	}

	function getCOM_DOT_INFO_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
		var row=getEditRowNo("");
		
		if (document.getElementById("dot_exp_no").value != colArray[0]
			|| document.getElementById("dot_spcl_apro_no").value != colArray[1]
			|| document.getElementById("dot_auth_no").value != colArray[2]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}

		document.getElementById("dot_exp_no").value = colArray[0];
		document.getElementById("dot_spcl_apro_no").value = colArray[1];
		document.getElementById("dot_auth_no").value = colArray[2];
		sheetObjects[3].SetCellValue(row, "dot_exp_no",colArray[0]);
		sheetObjects[3].SetCellValue(row, "dot_spcl_apro_no",colArray[1]);
		sheetObjects[3].SetCellValue(row, "dot_auth_no",colArray[2]);
		
	}
	
	//Setting Special Provisions
	//from ibsheet value to screen objects
	function setProviNo(value){
		for(var i=1 ; i < provi_length ; i++ ) {
//			sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(),"imdg_spcl_provi_no"+i,"");
			document.getElementById("frm_imdg_spcl_provi_no"+i).value="";
		}
		if(value=="")	return;

		var spclProviList=value.split("|"); // Data is like Val1^Seq1|Val2^Seq2|Val3^Seq3
		var spclProviDpSeq=null;
//		for(var i=1 ; i < provi_length ; i++ ) {
			for(var j=1 ; j < spclProviList.length+1 ; j++){
				spclProviDpSeq=spclProviList[j-1].split("^");
//				if (i==spclProviDpSeq[1]){
//					sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(),"imdg_spcl_provi_no"+i,spclProviDpSeq[0]);
//					document.getElementById("frm_imdg_spcl_provi_no"+i).value=spclProviDpSeq[0];
					document.getElementById("frm_imdg_spcl_provi_no"+spclProviDpSeq[1]).value=spclProviDpSeq[0];
//				}
			}
		}
//	}
	
	//Setting Special Provisions - form data -> cell data popup change
	function set_imdg_un_no_spcl_provi_ctnt(){
//		var formObj=document.form;
		var find_row=getEditRowNo("");
		
//		var imdg_un_no_spcl_provi_ctnt = "";
//		var val_chg_chk = false; 
//		for(i=1; i<9; i++){
//			if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != sheetObjects[3].GetCellValue(find_row, "imdg_spcl_provi_no"+i)){
//				val_chg_chk = true;
//				break;
//			}
//		}
//		if(val_chg_chk){
//			for(i=1; i<9; i++){
//				sheetObjects[3].SetCellValue(find_row, "imdg_spcl_provi_no"+i, eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//				
//				if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != ""){
//					imdg_un_no_spcl_provi_ctnt += eval("formObj.frm_imdg_spcl_provi_no"+i+".value")+"^"+i+"|";
//					sheetObjects[3].SetCellValue(find_row, "imdg_spcl_provi_no"+i,eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//				}
//			}
//			var str_length= imdg_un_no_spcl_provi_ctnt.length - 1;
//			
//			imdg_un_no_spcl_provi_ctnt = imdg_un_no_spcl_provi_ctnt.substring(0,str_length);
//			sheetObjects[3].SetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt",imdg_un_no_spcl_provi_ctnt,0);
//		}
		
		setSpclProviCtnt(find_row);
		
	}
	
	/**
	 * Clicking popup in IBSheet Object
	 */
	function onPopupClick(srcName){
		var formObj=document.form;
		var objName=ComGetEvent("name").replace('btn_','frm_');
		ComOpenPopupWithTarget('/opuscntr/VOP_SCG_0059Pop.do?imdg_spcl_provi_no='+eval("formObj."+objName+".value")+'&objName='+objName, 1025, 693, objName, "1,0", true);
	}	
	
	//Setting Special Provisions - form data to ibsheet "imdg_un_no_spcl_provi_ctnt"
	function setSpclProviCtnt(row){
		var formObj=document.form;
		var imdg_un_no_spcl_provi_ctnt = "";
		for(i=1; i<9; i++){
			if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != ""){
				imdg_un_no_spcl_provi_ctnt += eval("formObj.frm_imdg_spcl_provi_no"+i+".value")+"^"+i+"|";
			}
		}
//			imdg_un_no_spcl_provi_ctnt = imdg_un_no_spcl_provi_ctnt.substring(0,imdg_un_no_spcl_provi_ctnt.length-1);
		if(imdg_un_no_spcl_provi_ctnt.length>0){
			var str_length= imdg_un_no_spcl_provi_ctnt.length - 1; 
			imdg_un_no_spcl_provi_ctnt = imdg_un_no_spcl_provi_ctnt.substring(0,str_length); //Remove last "|"
			sheetObjects[3].SetCellValue(row, "imdg_un_no_spcl_provi_ctnt",imdg_un_no_spcl_provi_ctnt,0);
		}else{
			sheetObjects[3].SetCellValue(row, "imdg_un_no_spcl_provi_ctnt","",0);
		}
		document.getElementById("imdg_un_no_spcl_provi_ctnt").value=imdg_un_no_spcl_provi_ctnt;
	}
	// #CSR 14449
	function chkForFlshPnt(find_row, modifyData){
		if (document.getElementById("imdg_clss_cd").value == "3" || document.getElementById("imdg_subs_rsk_lbl_cd1").value == "3" || document.getElementById("imdg_subs_rsk_lbl_cd2").value == "3" || document.getElementById("imdg_subs_rsk_lbl_cd3").value == "3" ||document.getElementById("imdg_subs_rsk_lbl_cd4").value == "3"
			|| document.getElementById("imdg_un_no").value == "3255" || document.getElementById("imdg_un_no").value == "3257" ) {
			document.form.flsh_pnt_cdo_temp.disabled = false;
		}else{
			document.form.flsh_pnt_cdo_temp.disabled = true;
			if(modifyData=="Y"){ //Do not change past data.
				document.form.flsh_pnt_cdo_temp.value = "";
				sheetObjects[3].SetCellValue(find_row, "flsh_pnt_cdo_temp", "",0);
	//			sheetObjects[3].SetCellValue(find_row, "modifyaproflg","Y",0);
			}
		}
	}

	/*
	 * MOUSE PASTE 이벤트
	 */
	function mousePaste(obj){
		setTimeout(function(){
	    	var updateString = checkSpecial(obj);	//특수문자 제외 로직
	    	if(obj.value != updateString){
//	    		document.form.modify_flag.value="Y";	//변경사항 체크
	    	}
		}, 100)
	}
	
	/**
	 * Get dg_cntr_seq to show data at DG declarant screen
	 * If no row checked -> selected cursor
	 * If checked -> Top row of checked rows
	 */
	function getCheckedDgCntrSeqRep(){
		var dgCntrSeqRep = "";
		var rowSeq = "";
		var strRow = sheetObjects[1].FindCheckedRow("DelChk");		
		if(strRow!=""){
			rowSeq = strRow.split("|")[0];
		}else{
			rowSeq = sheetObjects[1].GetSelectRow();
		}
		
		dgCntrSeqRep = sheetObjects[1].GetCellValue(rowSeq, "dg_cntr_seq_original");
		return dgCntrSeqRep;
	}	

	/**
	 * Get the list of checked dg_cntr_seq
	 */
	function getCheckedDgCntrSeq(){
		var dgCntrSeqList = "";
		var strRow = sheetObjects[1].FindCheckedRow("DelChk");		
		if(strRow!=""){
			var arrRow = strRow.split("|");
			for(var n=0; n<arrRow.length; n++){
				dgCntrSeqList += sheetObjects[1].GetCellValue(arrRow[n], "dg_cntr_seq_original")+"|";
			}			
		}
		return dgCntrSeqList;
	}	
