/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0022.js
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.13
 *@LastModifier : 김도현
 *@LastVersion : 1.0
 * 2015.10.13 김도현
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
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
 */

	/**
	 * @extends
	 * @class vop_opf_0022 : vop_opf_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_opf_0022() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

	/* 개발자 작업 */
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt     = 0;
	var beforetab  = 1;
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	
	var comboObjects = new Array();
	var comboCnt     = 0;
	  
	var prefix0 = "sheet0_";
	var prefix1 = "sheet1_";
	var prefix2 = "sheet2_";
	
	var IBSEARCH01  = 29;
	var IBSEARCH02  = 30;
	var IBSEARCH03  = 33;
	var IBSEARCH04  = 32;
	var IBSEARCH05  = 34;

	var strCarrNm = "";
	var curTabLoc = "0";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObj1 = sheetObjects[0]; // t1sheet1
		var sheetObj2 = sheetObjects[1]; // t1sheet2
		var sheetObj3 = sheetObjects[2]; // t1sheet3
		var sheetObj4 = sheetObjects[3]; // t1sheet4
		var sheetObj5 = sheetObjects[4]; // t1sheet5
		var sheetObj6 = sheetObjects[5]; // t1sheet6
		var sheetObj7 = sheetObjects[6]; // t1sheet7
		var sheetObj8 = sheetObjects[7]; // t1sheet8
		var sheetObj9 = sheetObjects[8]; // t1sheet9
		
		var tabObj    = tabObjects[0];
		var comboObj  = comboObjects[0];

		var formObj   = document.form;
		
		var selTabIdx = tabObj.SelectedIndex;
	
		/** **************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {	
				case "btn_Retrieve":
		        //  if(curTabLoc != "0"){ alert("Go to DG Tab and then retrieve."); }
		         // else {
		        	  if(sheetObjects[1].RowCount == 0)  formObj.re_seach_yn.value = "Y";  
		              doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
		         // }
					break;
				case "btn_Save":
					if(!ComShowCodeConfirm('OPF50001', '')) return;
					formObj.condition_gb.value = "manageSave";
					setSaveFlag(ComGetObjValue(formObj.tabSelectedIdx));
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
					break;
				case "btn_Del":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBDELETE);
					break;	
		
				case "btn_crr_cd_add":
					if(formObj.crrCd.value != 'SML'){
						alert('You should register SML CBF first.');
						return false;
					}else{
						formObj.condition_gb.value = "addCrrCd";
						if (!validateCheck()) return false;
		        		ComOpenPopup("/hanjin/COM_ENS_0N1.do", 528, 430, "setCrrCd", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0077");
					}
	        		break;
				case "btn_crr_cd_del":
					formObj.condition_gb.value = "delCrrCd";
					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
	        		break;

	        	// I/F BKG DT  	
				case "btn_IFBkgDt":
					if(!confirm('Do you want to import Booking data?')) return;
					formObj.condition_gb.value = "manageIfBkgDt";
					ComOpenWait(true);
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
					ComOpenWait(true);
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH04);
					break;

				case "btn_IFPrnrEdi":
					var yd_cd = formObj.pol_cd.value; //
				
					if(yd_cd == "") {
						ComShowCodeMessage("OPF50009", "Yard Code");	
					}
					else{
  			  		  var chk = doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH05);

                      if(chk == "Y") {
                     	if(!confirm('Already Data exists. Do you want to import after deleting ?')) return;
                      }
					
					  if(!confirm('Do you want to import Partner EDI?')) return;
					  formObj.condition_gb.value = "manageIfEDI";
					  ComOpenWait(true);
					  doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
					  doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
					  setCarrier_combo();
					}
					//  doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH04);
					break;
					
	        	// I/F D-CUDE  	
//				case "btn_IFDCUBE":
//					if(!ComShowCodeConfirm('OPF50001', 'I/F D-CUDE')) return;
//					formObj.condition_gb.value = "manageIfDcube";
//					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
//					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
//					break;
					
				// Carrier - pod
				case "btn_RowAdd_carr_pod":
					if (!validateCheck()) return false;
					var row = sheetObjects[1].DataInsert(-1);
					sheetObjects[1].SelectCell(row,prefix1 + "pod_stwg_cd",true);
					break;
				case "btn_RowDelete_carr_pod":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[1],prefix1+"del_chk");
					break;
					
				// DG	
				case "btn_RowAdd_dg":
					if (!validateCheck()) return false;
					var row = sheetObjects[2].DataInsert(-1);
					sheetObjects[2].SelectCell(row,prefix2 + "pod_nm2",true);
					sheetObjects[2].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					sheetObjects[2].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_dg":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[2],prefix2+"del_chk");
					break;
					
				// AWK
				case "btn_RowAdd_awk":
					if (!validateCheck()) return false;
					var row = sheetObjects[3].DataInsert(-1);
	 				sheetObjects[3].CellValue2(row,'sheet2_fwrd_ovr_dim_len') = 0;
	 				sheetObjects[3].CellValue2(row,'sheet2_bkwd_ovr_dim_len') = 0;
	 				sheetObjects[3].CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = 0;
	 				sheetObjects[3].CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = 0;
	 				sheetObjects[3].CellValue2(row,'sheet2_hgt_ovr_dim_len') = 0;
	 				sheetObjects[3].SelectCell(row,prefix2 + "pod_nm2",true);
	 				sheetObjects[3].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
	 				sheetObjects[3].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_awk":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[3],prefix2+"del_chk");
					break;
					
				// BB
				case "btn_RowAdd_bb":
					if (!validateCheck()) return false;
					var row = sheetObjects[4].DataInsert(-1);
					sheetObjects[4].SelectCell(row,prefix2 + "pod_nm2",true);
					sheetObjects[4].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					sheetObjects[4].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_bb":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[4],prefix2+"del_chk");
					break;
					
				// Reefer
				case "btn_RowAdd_rf":
					if (!validateCheck()) return false;
					var row = sheetObjects[5].DataInsert(-1);
					sheetObjects[5].SelectCell(row,prefix2 + "pod_nm2",true);
					sheetObjects[5].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					sheetObjects[5].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_rf":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[5],prefix2+"del_chk");
					break;
						
				// MTY
				case "btn_RowAdd_mty":
					if (!validateCheck()) return false;
					var row = sheetObjects[6].DataInsert(-1);
					sheetObjects[6].SelectCell(row,prefix2 + "pod_nm2",true);
					sheetObjects[6].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					sheetObjects[6].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_mty":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[6],prefix2+"del_chk");
					break;
							
				// Bundle
				case "btn_RowAdd_bn":
					if (!validateCheck()) return false;
					var row = sheetObjects[7].DataInsert(-1);
					sheetObjects[7].SelectCell(row,prefix2 + "pod_nm2",true);
					sheetObjects[7].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					sheetObjects[7].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_bn":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[7],prefix2+"del_chk");
					break;
								
				// Special STWG
				case "btn_RowAdd_stwg":
					if (!validateCheck()) return false;
					var row = sheetObjects[8].DataInsert(-1);
					sheetObjects[8].SelectCell(row,prefix2 + "pod_nm2",true);
					sheetObjects[8].CellValue2(row,'sheet2_pod_nm2') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					sheetObjects[8].CellValue2(row,'sheet2_pod_nm') = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,'sheet1_pod_stwg_cd');
					break;
				case "btn_RowDelete_stwg":
					if (!validateCheck()) return false;
					ComRowHideDelete(sheetObjects[8],prefix2+"del_chk");
					break;
	        		
				// VVD CD 팝업
				case "btn_vvd":
					var vslCd = ComGetObjValue(formObj.vsl_cd);
					var sUrl = "";
	
					if (vslCd == "") {
						sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 335, 430, "setCallBackVVD", "0,0", true);
					}
					break;
	
				case "btn_New":
					ComResetAll();
					comboObj.RemoveAll();
				
				// Preview Popup	
				case "btn_preview":	
					
					if(formObj.vsl_cd.value == '' || formObj.skd_voy_no.value == '' || formObj.skd_dir_cd.value == ''){
						ComShowCodeMessage("OPF50009", "VVD");
						ComSetFocus(formObj.vsl_cd);
				   		return false;
					}else if(formObj.yd_cd.Code == ''){
						ComShowCodeMessage("OPF50009", "POL");
						ComSetFocus(formObj.yd_cd);
				   		return false;
					}					
					preview_pop();
					break;
					
					//초기 포커스 위치
					ComSetFocus(formObj.vsl_cd);
					
					break;
					
				case "btn_DownExcel":
					sheetObjects[tabObj.SelectedIndex].SpeedDown2Excel(-1);					
					break;
					
					
				case "btn_EdiCheck":
					var yd_cd  = formObj.pol_cd.value.substring(0,5); //
					var vsl_cd = formObj.vsl_cd.value;
					var skd_voy_no = formObj.skd_voy_no.value;
					var skd_dir_cd = formObj.skd_dir_cd.value;
				    
					if(vsl_cd =="" || skd_voy_no =="" ||skd_dir_cd  == ""){
						ComShowCodeMessage("OPF50009", "VVD");	
						break;  }
					
					if(yd_cd == "") {
						ComShowCodeMessage("OPF50009", "Yard Code");
						break;  }
					
						
					else {
				   	var theURL = "VOP_OPF_2024.do?" +"&pol_cd="             +yd_cd
					                                +"&pol_clpt_ind_seq="  	+ComGetObjValue(formObj.pol_clpt_ind_seq)
					                                +"&vvd=" +vsl_cd+skd_voy_no+skd_dir_cd;
												
				   	var winName = "PreviewPopup";
				   	var features = "scroll:yes;status:no;resizable=no;help:no;dialogWidth:900px;dialogHeight:550px";
				   	ComOpenWindow(theURL,winName,features,true);   }
					break;
					
					//wgt group 팝업
				case "btn_Wgt":
					var vSlanCd   = ComGetObjValue(formObj.slan_cd);
					var vSkdDirCd = ComGetObjValue(formObj.skd_dir_cd);
					var vYdCd     = ComGetObjValue(formObj.yd_cd);
					var vPolCd    = vYdCd.substr(0, 5);
				
					sUrl = "/hanjin/VOP_OPF_3019.do?slan_cd=" + vSlanCd + "&skd_dir_cd=" + vSkdDirCd + "&pol_cd=" + vPolCd;
					ComOpenPopupWithTarget(sUrl, 700, 550, "yd_cd:yd_cd", "0,0", true);
			
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}

	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {	
		sheetObjects[sheetCnt++] = sheet_obj;	
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {	
		comboObjects[comboCnt++] = combo_obj;	
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	 
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
			case 1:
				with (tabObj) {
					var cnt = 0;
					InsertTab(cnt++, "DG", -1);
					InsertTab(cnt++, "AWK", -1);
					InsertTab(cnt++, "BB", -1);
					InsertTab(cnt++, "Reefer/Tank", -1);
					InsertTab(cnt++, "MTY", -1);
					InsertTab(cnt++, "BN", -1);
					InsertTab(cnt++, "Special STWG", -1);
				}
				break;
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
		 var formObj = document.form;
		 var objs = document.all.item("tabLayer");
		 var tabSelectedIdx = ComGetObjValue(formObj.tabSelectedIdx);
		
		 objs[nItem].style.display = "Inline";
		 objs[beforetab].style.display = "none";
		 
		 //--------------- 요기가 중요 --------------------------//
		 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		 //------------------------------------------------------//	

		 beforetab= nItem;
		 tabIndex = nItem;
	
		 if (sheetObjects[1].IsDataModified) {
			 	var msg1 = "";
				if(ComShowCodeConfirm('OPF50003', msg1)) {
		        	if(sheetObjects[1].RowCount>0){
		        		for(i=1; i< (sheetObjects[1].RowCount+1); i++){
		        			
		        			if(sheetObjects[1].CellValue(i,prefix1 + "pod_stwg_cd") == ""){
		                		ComShowCodeMessage("OPF50009", "POD");
		                		sheetObjects[1].SelectCell(i,prefix1 + "pod_stwg_cd",true);
		                		return false;
		                	}
		        		}
		        	}
					formObj.condition_gb.value = "manageSave";
					
					doActionIBSheet(sheetObjects[1],formObj,IBSAVE);
					return true;
				}else{
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
				}
		 }	

		 if (tabIndex == 1) {
			 curTabLoc = "1";
			 dataModCheck();
			 if (!validateCheck()) return false;
			 formObj.condition_gb.value = "searchAWK";
			 formObj.condition_gb2.value = "searchAWK";
			 formObj.re_seach_yn.value = "N";
			 sheetObjects[3].RemoveAll();	
			 if(sheetObjects[1].RowCount>0) {
			 doActionIBSheet(sheetObjects[3],formObj,IBSEARCH);
			 summary_qty(sheetObjects[1]);
			 }
			 
		 }else if (tabIndex == 2) {
			 curTabLoc = "2";
			 dataModCheck();
			 if (!validateCheck()) return false;
			 formObj.condition_gb.value = "searchBB";
			 formObj.condition_gb2.value = "searchBB";
			 formObj.re_seach_yn.value = "N";
			 sheetObjects[4].RemoveAll();
			 if(sheetObjects[1].RowCount>0) {
			 doActionIBSheet(sheetObjects[4],formObj,IBSEARCH);
			 summary_qty(sheetObjects[1]); 
			 }		 
		 }else if (tabIndex == 3) {
			 curTabLoc = "3";
			 dataModCheck();
			 if (!validateCheck()) return false;
			 formObj.condition_gb.value = "searchRF";
			 formObj.condition_gb2.value = "searchRF";
			 formObj.re_seach_yn.value = "N";
			 sheetObjects[5].RemoveAll();
			 if(sheetObjects[1].RowCount>0) {
			 doActionIBSheet(sheetObjects[5],formObj,IBSEARCH); 
			 summary_qty(sheetObjects[1]); }
		 }else if (tabIndex == 4) {
			 curTabLoc = "4";
			 dataModCheck();
			 if (!validateCheck()) return false;
			 formObj.condition_gb.value = "searchMTY";
			 formObj.condition_gb2.value = "searchMTY";
			 formObj.re_seach_yn.value = "N";
			 sheetObjects[6].RemoveAll();
			 if(sheetObjects[1].RowCount>0) {
			 doActionIBSheet(sheetObjects[6],formObj,IBSEARCH);
			 summary_qty(sheetObjects[1]); }
		 }else if (tabIndex == 5) {
			 curTabLoc = "5";
			 dataModCheck();
			 if (!validateCheck()) return false;
			 formObj.condition_gb.value = "searchBN";
			 formObj.condition_gb2.value = "searchBN";
			 formObj.re_seach_yn.value = "N";
			 sheetObjects[7].RemoveAll();
			 if(sheetObjects[1].RowCount>0) {
			 doActionIBSheet(sheetObjects[7],formObj,IBSEARCH); 
			 summary_qty(sheetObjects[1]); }
		 }else if (tabIndex == 6) {
		
			 curTabLoc = "6";
			 dataModCheck();
			 if (!validateCheck()) return false;
			 formObj.condition_gb.value = "searchSSTWG";	
			 formObj.condition_gb2.value = "searchSSTWG";
			 formObj.re_seach_yn.value = "N";
			 sheetObjects[8].RemoveAll();
			 if(sheetObjects[1].RowCount>0) {
			 doActionIBSheet(sheetObjects[8],formObj,IBSEARCH); 
			 summary_qty(sheetObjects[1]);
			 }
		 }else{
			 curTabLoc = "0";
			 if(formObj.vsl_cd.value != '' && formObj.skd_voy_no.value != '' && formObj.skd_dir_cd.value != ''){			 
				 dataModCheck();
	
				 formObj.condition_gb.value = "searchDG";
				 formObj.condition_gb2.value = "searchDG";
				 formObj.re_seach_yn.value = "N";
				 sheetObjects[2].RemoveAll();
				 if(sheetObjects[1].RowCount>0) {
				 doActionIBSheet(sheetObjects[2],formObj,IBSEARCH); 
				 summary_qty(sheetObjects[1]); }
			 }
		 }

		 ComSetObjValue(formObj.tabSelectedIdx, nItem);
	}

	/**
	 */
	function dataModCheck() {	
		var formObj = document.form;
		 var msg1 = "";

		 if (sheetObjects[2].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[2].RowCount>0){
	        		for(i=1; i< (sheetObjects[2].RowCount+1); i++){
	        			
	        			if(sheetObjects[2].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[2].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("0");
				doActionIBSheet(sheetObjects[2],formObj,IBSAVE);
				return true;
			}else{
				sheetObjects[2].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[2].Redraw = true;
			}
		 }else if (sheetObjects[3].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[3].RowCount>0){
	        		for(i=1; i< (sheetObjects[3].RowCount+1); i++){
	        			
	        			if(sheetObjects[3].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[3].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("1");
				doActionIBSheet(sheetObjects[3],formObj,IBSAVE);
				return true;
			}else{
				sheetObjects[3].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[3].Redraw = true;
			}
		 }else if (sheetObjects[4].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[4].RowCount>0){
	        		for(i=1; i< (sheetObjects[4].RowCount+1); i++){
	        			
	        			if(sheetObjects[4].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[4].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("2");
				doActionIBSheet(sheetObjects[4],formObj,IBSAVE);
				return true;
			}else{
				sheetObjects[4].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[4], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[4].Redraw = true;
			}
		 }else if (sheetObjects[5].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[5].RowCount>0){
	        		for(i=1; i< (sheetObjects[5].RowCount+1); i++){
	        			
	        			if(sheetObjects[5].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[5].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("3");
				doActionIBSheet(sheetObjects[5],formObj,IBSAVE);
				return true;
			}else{
				sheetObjects[5].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[5], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[5].Redraw = true;
			}
		 }else if (sheetObjects[6].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[6].RowCount>0){
	        		for(i=1; i< (sheetObjects[6].RowCount+1); i++){
	        			
	        			if(sheetObjects[6].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[6].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("4");
				doActionIBSheet(sheetObjects[6],formObj,IBSAVE);
				return true;
			}else{
				sheetObjects[6].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[6], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[6].Redraw = true;
			}
		 }else if (sheetObjects[7].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[7].RowCount>0){
	        		for(i=1; i< (sheetObjects[7].RowCount+1); i++){
	        			
	        			if(sheetObjects[7].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[7].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("5");
				doActionIBSheet(sheetObjects[7],formObj,IBSAVE);
				return true;
			}else{
				sheetObjects[7].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[7], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[7].Redraw = true;
			}
		 }else if (sheetObjects[8].IsDataModified) {
			if(ComShowCodeConfirm('OPF50003', msg1)) {
	        	if(sheetObjects[8].RowCount>0){
	        		for(i=1; i< (sheetObjects[8].RowCount+1); i++){
	        			
	        			if(sheetObjects[8].CellValue(i,prefix2 + "pod_nm") == ""){
	                		ComShowCodeMessage("OPF50009", "POD");
	                		sheetObjects[8].SelectCell(i,prefix2 + "pod_nm2",true);
	                		return false;
	                	}
	        		}
	        	}
				
				formObj.condition_gb.value = "manageSave";
				setSaveFlag("6");
				doActionIBSheet(sheetObjects[8],formObj,IBSAVE);
				tabIndex = 6;
				return true;
			}else{
				sheetObjects[8].Redraw = false;
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[8], formObj, IBSEARCH);
				alert('It was canceled.');
				ComOpenWait(false);
				sheetObjects[8].Redraw = true;
			}
		 }	
	}

	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {	
		//IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		//IBTab 초기화
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		//IBSheet 초기화
		for (i = 0; i < sheetObjects.length; i++) {	
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);	
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//Axon Event Listener 등록
		initControl();
	
		//초기 포커스 위치
		ComSetFocus(document.form.vsl_cd);
	}
	 
	/**
	 * IBCOMBO 초기화. <br>
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "yd_cd":
				with (comboObj) {
					BackColor       = "#CCFFFF";
					DropHeight      = 230;
					MultiSelect     = false;
					MaxSelect       = 1;
					UseAutoComplete = true;
				}
				break;
		}
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, 'spcode');
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
//		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}

	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}

    function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
	}
	
	//인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var formObj = document.form;
		
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue     = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else ComSetNextFocus(obj);
			
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
	}

	/**
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
	 **/
	function obj_blur() {
		var formObj  = document.form;
		
		with (event.srcElement) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//VVD Info 가져오기
						searchVVDInfo();
					}		
					
					break;
					
				default:
					break;
			}
		}
	}
	 
	/**
	 * 조회조건 입력시 Validation <br>
	 **/
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				switch (event.srcElement.name) {
					case "vsl_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
					case "skd_voy_no":
						//숫자입력하기
						ComKeyOnlyNumber(event.srcElement);
						break;
					case "skd_dir_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "crr_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "yd_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "cgo_grs_wgt":
						//영문대문자 입력하기
						ComKeyOnlyNumber(event.srcElement);
				}
				break;
				
			default:
				//공통기준:영문, 숫자만을 인식
				ComKeyOnlyAlphabet("num");
				break;
		}
	}
    
	/**
	 * VVD 정보 조회 <br>
	 **/
	function searchVVDInfo() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var comboObj = comboObjects[0];
		
		//관련항목 초기화
		resetForCondition(formObj, "vvd");
	
		formObj.f_cmd.value = SEARCH05;
		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));		
	
		var vvdData = ComOpfXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
		if (vvdData == null) {
			ComShowCodeMessage("OPF50004", 'Data');
			
			//관련항목 초기화
			resetForCondition(formObj, "vvd");
			ComSetObjValue(formObj.vsl_cd,     "");
			ComSetObjValue(formObj.skd_voy_no, "");
			ComSetObjValue(formObj.skd_dir_cd, "");
			
			//포커스 이동
			ComSetFocus(formObj.vsl_cd);
		} else {
			ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			ComSetObjValue(formObj.slan_cd,     vvdData[0][1]);
			ComSetObjValue(formObj.slan_nm,     vvdData[0][2]);

			//POL 가져오기
			formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
			var sPol = ComGetEtcData(sXml, "sPol");
			
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				var polCd = ""; //yd_code + clpt_ind_seq
				
				for (var cCt=0; cCt<arrPol.length; cCt++) {
					polCd = arrPol[cCt];
					if(polCd != '') polCd = polCd.substring(0, polCd.length-1); 
					comboObj.InsertItem(cCt, polCd, arrPol[cCt]);
				}
			}
			//포커스 이동
			ComSetFocus(formObj.yd_cd);
		}
		sheetObj.WaitImageVisible = true;
		
		setCarrier_combo();

		formObj.crrCd.value = '';
		formObj.tot_tot_qty.value = '';
		formObj.tot_20ft_qty.value = '';
		formObj.tot_40ft_qty.value = '';
		formObj.tot_40ft_hc_qty.value = '';
		formObj.tot_45ft_hc_qty.value = '';
		formObj.cgo_grs_wgt.value = '';		
	}
	 
    /**
	 * VVD/POL 변경시 관련항목 초기화 <br>
	 **/
	function resetForCondition(formObj, what) {	
		var comboObj = comboObjects[0];
		
		//VVD
		if(what.indexOf("vvd") != -1) {
			if(what.indexOf("pol") == -1) {
				ComSetObjValue(formObj.vsl_eng_nm, "");
				ComSetObjValue(formObj.slan_cd,    "");
				ComSetObjValue(formObj.slan_nm,    "");			
				
				comboObj.RemoveAll();
			}
			ComSetObjValue(formObj.loc_nm,     "");
			ComSetObjValue(formObj.yd_nm,      "");
			ComSetObjValue(formObj.eta,        "");
			
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");
		}
		
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();
		}
	}

	/**
	 * POL 콤보 데이터 선택시. <br>
	 **/
	function yd_cd_OnChange(comboObj, Code, Text) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
	
		//관련항목 초기화
		resetForCondition(formObj, "vvd-pol");
		
		if(Code != '') {		
			//POL Info 가져오기
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
	
			var sPol = ComGetEtcData(sXml, "sPol");
	
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				ComSetObjValue(formObj.loc_nm, arrPol[0]);
				ComSetObjValue(formObj.yd_nm,  arrPol[1]);
				ComSetObjValue(formObj.eta,    arrPol[2]);
				
				ComSetObjValue(formObj.pol_cd, comboObjects[0].Text);
				ComSetObjValue(formObj.pol_clpt_ind_seq, comboObjects[0].Code.substring(comboObjects[0].Text.length, comboObjects[0].Code.length));
			}
			
			// Last Created Info 가져오기
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
			//1. CBF, Booking Status 상태 조회
			var sCbf = ComGetEtcData(sXml, "sCbf");
			if (sCbf != undefined) {
				var arrCbf = sCbf.split("|");
				if ((arrCbf[1] != null) && (arrCbf[1] != '')) {
					ComSetObjValue(formObj.upd_dt, arrCbf[1]=='null'?"":arrCbf[1]);
				} else {
					ComSetObjValue(formObj.upd_dt, "");
				}
				if ((arrCbf[0] != null) && (arrCbf[0] != '')) {
					ComSetObjValue(formObj.cre_dt, arrCbf[0]=='null'?"":arrCbf[0]);
				} else {
					ComSetObjValue(formObj.cre_dt, "");
				}
				
				if ((arrCbf[2] != null) && (arrCbf[2] != '')) {
					ComSetObjValue(formObj.cbf_ind_flg, arrCbf[0]=='null'?"":arrCbf[2]);
				}
			}	
		}
		
		setCarrier_combo();
		setPod_combo();
			
		formObj.crrCd.value = '';
		formObj.tot_tot_qty.value = '';
		formObj.tot_20ft_qty.value = '';
		formObj.tot_40ft_qty.value = '';
		formObj.tot_40ft_hc_qty.value = '';
		formObj.tot_45ft_hc_qty.value = '';
		formObj.cgo_grs_wgt.value = '';
	}
	
	/**
	 * Carrier Combo 조회조건 셋팅. <br>
	 **/
    function setCarrier_combo() {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH05;
		formObj.condition_gb.value = "searchCrrCd"
		sheetObjects[0].WaitImageVisible = false;
		var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[2], "crr_cd", "crr_cd|crr_cd_flag"); 
		formObj.crr_cd.Code2 = 'SML';

    }

	function crr_cd_OnChange(comboObj, Code, Text) {
		var formObj = document.form;
		formObj.crr_cd.Code2 = comboObjects[1].Code;
		document.form.crr_cd_nm.value = comboObj.GetText(Code,1);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	
	 function setPod_combo() {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH04;
		sheetObjects[2].WaitImageVisible = false;
		var sRhqXml = sheetObjects[2].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[1], "vps_port_cd|vps_eta_dt", "vps_port_cd|vps_eta_dt");
		formObj.pod_cd.Index = 0;
    }
    
	/**
	 * POD Combo Sheet 셋팅. <br>
	 **/    
    function setSheet_Pod_combo(sheetObj) {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH09;
		sheetObjects[2].WaitImageVisible = false;
		var sRhqXml = sheetObjects[2].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		var arrXml = sRhqXml.split("|$$|");
		
		var arrCombo1 = ComXml2ComboString(arrXml[0], "pod_cd", "pod_cd");
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0) itemNm = itemNm + arrVal[j];
				else itemNm = itemNm + "|" + arrVal[j];
			}
			sheetObj.InitDataCombo(0, prefix2+"pod_nm2", " |"	+ itemNm, " |" + arrCombo1[0]);
		}
    }
    
	/**
	 * UnNo Class Combo Sheet 셋팅. <br>
	 **/    
    function setSheet_UnNo_Class_combo(sheetObj, row) {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH10;
		formObj.imdg_subs_rsk_lbl_cd.value = "";
		sheetObjects[2].WaitImageVisible = false;
		var sRhqXml = sheetObjects[2].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		var arrXml = sRhqXml.split("|$$|");
		var arrCombo1 = ComXml2ComboString(arrXml[0], "imdg_clss_cd", "imdg_clss_cd");
		var selectClassCd;
		
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0){ 
					itemNm = itemNm + arrVal[j];
					selectClassCd = arrVal[j];
				}else{
					itemNm = itemNm + "|" + arrVal[j];
				}
			}
			
			sheetObj.InitDataCombo(0, prefix2+"imdg_clss_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
			// Fist Code Setting.
			sheetObj.CellValue2(row,'sheet2_imdg_clss_cd') = selectClassCd;
		}
    }
    
	/**
	 * UnNo Class Combo Sheet 셋팅. <br>
	 **/    
    function setSheet_UnNo_Imdg_subs_rsk_lbl_cd_combo(sheetObj, row) {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH10;
		formObj.imdg_subs_rsk_lbl_cd.value = "Y";
		sheetObjects[2].WaitImageVisible = false;
		var sRhqXml = sheetObjects[2].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		var arrXml = sRhqXml.split("|$$|");
		var arrCombo1 = ComXml2ComboString(arrXml[0], "imdg_subs_rsk_lbl_cd", "imdg_subs_rsk_lbl_cd");
		var selectImdg_subs_rsk_lbl_cd;
		
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0){ 
					itemNm = itemNm + arrVal[j];
					selectImdg_subs_rsk_lbl_cd = arrVal[j];
				}else{
					itemNm = itemNm + "|" + arrVal[j];
				}
				
			}
			
			sheetObj.InitDataCombo(0, prefix2+"imdg_subs_rsk_lbl_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
			// Fist Code Setting.
			sheetObj.CellValue2(row,'sheet2_imdg_subs_rsk_lbl_cd') = selectImdg_subs_rsk_lbl_cd;
		}
    }
    
	/**
	 * Special STWG Combo Sheet 셋팅. <br>
	 **/    
    function setSheet_stwg_cd_combo(sheetObj) {
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH06;
		sheetObjects[2].WaitImageVisible = false;
		var sRhqXml = sheetObjects[2].GetSearchXml("VOP_OPF_0022GS.do", FormQueryString(formObj));
		var arrXml = sRhqXml.split("|$$|");

		var arrCombo1 = ComXml2ComboString(arrXml[0], "stwg_cd", "stwg_cd");
		if (arrCombo1 != null) {			
			var arrVal  = arrCombo1[0].split("|");
			var arrName = arrCombo1[1].split("|");
			var itemNm  = "";
			for ( var j = 0; j < arrVal.length; j++) {
				if (j == 0) itemNm = itemNm + arrVal[j];
				else itemNm = itemNm + "|" + arrVal[j];
			}
			sheetObj.InitDataCombo(0, prefix2+"stwg_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
		}
    }
        
	/**
	 * VVD  데이터 수정시. <br>
	 **/
	function obj_change() {
		var formObj  = document.form;		
		
		with (event.srcElement) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	
					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					
					//관련항목 초기화					
					resetForCondition(formObj, "vvd");
					
					break;
			}
		}
	}

	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj  = document.form;
		if (rtnObjs) {
			var rtnDatas = rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
	
					// 포커스 이동
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}

	/**
	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVVD(obj) {
		var formObj  = document.form;
		var comboObj = comboObjects[0];
		if (obj) {
			var rtnDatas = obj[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					
					//VVD Info 가져오기
					searchVVDInfo();
				}
			}
		}
	}
	
	/**
 	 * setCrrCd 입력부분(Carrier Code)<br>
 	 * @param {arry} aryPopupData
 	 */
    function setCrrCd(aryPopupData) {
    	var formObj  = document.form;
    	formObj.carrier_cd.value = aryPopupData[0][3];
    	if(!ComShowCodeConfirm('OPF50001', ' : ['+formObj.carrier_cd.value+ '] Carrier Code')) return false;
    	doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
		setCarrier_combo();
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	
    }
    
	/**
	 * 각 탭별로 저장 Flag 셋팅. <br>
	 **/
	function setSaveFlag(srcName) {
		var formObj   = document.form;

		try {
	
			switch (srcName) {	
				case "0":
					formObj.dcgo_flg.value = "Y"
					formObj.awk_cgo_flg.value = ""
					formObj.bb_cgo_flg.value = ""
					formObj.rc_flg.value = ""
					formObj.mty_bkg_flg.value = ""
					formObj.bdl_cgo_flg.value = ""
					formObj.stwg_cgo_flg.value = ""
					break;
				case "1":
					formObj.dcgo_flg.value = ""
					formObj.awk_cgo_flg.value = "Y"
					formObj.bb_cgo_flg.value = ""
					formObj.rc_flg.value = ""
					formObj.mty_bkg_flg.value = ""
					formObj.bdl_cgo_flg.value = ""
					formObj.stwg_cgo_flg.value = ""
					break;
				case "2":
					formObj.dcgo_flg.value = ""
					formObj.awk_cgo_flg.value = ""
					formObj.bb_cgo_flg.value = "Y"
					formObj.rc_flg.value = ""
					formObj.mty_bkg_flg.value = ""
					formObj.bdl_cgo_flg.value = ""
					formObj.stwg_cgo_flg.value = ""
					break;
				case "3":
					formObj.dcgo_flg.value = ""
					formObj.awk_cgo_flg.value = ""
					formObj.bb_cgo_flg.value = ""
					formObj.rc_flg.value = "Y"
					formObj.mty_bkg_flg.value = ""
					formObj.bdl_cgo_flg.value = ""
					formObj.stwg_cgo_flg.value = ""
					break;
				case "4":
					formObj.dcgo_flg.value = ""
					formObj.awk_cgo_flg.value = ""
					formObj.bb_cgo_flg.value = ""
					formObj.rc_flg.value = ""
					formObj.mty_bkg_flg.value = "Y"
					formObj.bdl_cgo_flg.value = ""
					formObj.stwg_cgo_flg.value = ""
					break;
				case "5":
					formObj.dcgo_flg.value = ""
					formObj.awk_cgo_flg.value = ""
					formObj.bb_cgo_flg.value = ""
					formObj.rc_flg.value = ""
					formObj.mty_bkg_flg.value = ""
					formObj.bdl_cgo_flg.value = "Y"
					formObj.stwg_cgo_flg.value = ""
					break;
				case "6":
					formObj.dcgo_flg.value = ""
					formObj.awk_cgo_flg.value = ""
					formObj.bb_cgo_flg.value = ""
					formObj.rc_flg.value = ""
					formObj.mty_bkg_flg.value = ""
					formObj.bdl_cgo_flg.value = ""
					formObj.stwg_cgo_flg.value = "Y"
					break;
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}	
	 
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: // t1sheet1 init - Carrier
			with (sheetObj) {
				//높이 설정
				style.height = 42;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	            // Row 선택 시 색상표시 안함
	            SelectHighLight = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 0, 100);

//				var HeadTitle1 = "|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
				var HeadTitle1 = "|1|2|3|4|5|6|7|8|9|10|11|12";
				var headCount = ComCountHeadTitle(HeadTitle1);
				sheet4HeadTitleCnt = headCount;

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false )

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, false, true);

				//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix0 + "ibflag");
				InitDataProperty(0, cnt++, dtData, 			62, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd1"			,false	,""		,dfNone	,0	,false	,true  	,5);	
				InitDataProperty(0, cnt++, dtData, 			62, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd2"			,false	,""		,dfNone	,0	,false	,true  	,5);	
				InitDataProperty(0, cnt++, dtData, 			62, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd3"			,false	,""		,dfNone	,0	,false	,true  	,5);	
				InitDataProperty(0, cnt++, dtData, 			62, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd4"			,false	,""		,dfNone	,0	,false	,true  	,5);	
				InitDataProperty(0, cnt++, dtData, 			62, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd5"			,false	,""		,dfNone	,0	,false	,true  	,5);	
				InitDataProperty(0, cnt++, dtData, 			62, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd6"			,false	,""		,dfNone	,0	,false	,true  	,5);	
//				InitDataProperty(0, cnt++, dtData, 			52, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd7"			,false	,""		,dfNone	,0	,false	,true  	,5);	
				
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg1"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg2"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg3"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg4"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg5"		,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg6"		,false	,""		,dfNone	,0	,false	,false);
//				InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix0 + "fcast_crr_cd_flg7"		,false	,""		,dfNone	,0	,false	,false);

				ColHidden(prefix0 + "fcast_crr_cd_flg1") = true;
				ColHidden(prefix0 + "fcast_crr_cd_flg2") = true;
				ColHidden(prefix0 + "fcast_crr_cd_flg3") = true;
				ColHidden(prefix0 + "fcast_crr_cd_flg4") = true;
				ColHidden(prefix0 + "fcast_crr_cd_flg5") = true;
				ColHidden(prefix0 + "fcast_crr_cd_flg6") = true;
//				ColHidden(prefix0 + "fcast_crr_cd_flg7") = true;
				
				CountPosition = 0;
			}
			break;
			
		case 2: // t1sheet1 init - Carrier
			with (sheetObj) {
				//높이 설정
				style.height = 295;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);

				var HeadTitle1 = "|Sel|POD|20'|40'|40H'|45'"+"|1|2|3|4|5|6|7|8";
				var headCount = ComCountHeadTitle(HeadTitle1);
				sheet2HeadTitleCnt = headCount;

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				//InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix1 + "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix1 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1	, false, false, false, false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	prefix1 + "pod_stwg_cd"			,true	,""		,dfNone	,0	,false	,true  	,5);	
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "bkg_20ft_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "bkg_40ft_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "bkg_40ft_hc_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "bkg_45ft_hc_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
				
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
				InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix1 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);

				HeadRowHeight = 20;
				
				// 대문자 처리
				InitDataValid(0, prefix1 + "pod_stwg_cd", vtEngUpOther, "1234567890-");	 
				InitDataValid(0, prefix1 + "bkg_20ft_qty", vtNumericOnly);	 
				InitDataValid(0, prefix1 + "bkg_40ft_qty", vtNumericOnly);
				InitDataValid(0, prefix1 + "bkg_40ft_hc_qty", vtNumericOnly);	 
				InitDataValid(0, prefix1 + "bkg_45ft_hc_qty", vtNumericOnly);
				
				sheetObj.SheetFontSize=9;
				sheetObj.CellFont("FontBold", 1,2) = true; 
				sheetObj.CellFont("FontBold", 2,1) = true; 
				sheetObj.CellFont("FontBold", 3,1) = true; 
				
				ColHidden(prefix1 + "vsl_cd") = true;
				ColHidden(prefix1 + "skd_voy_no") = true;
				ColHidden(prefix1 + "skd_dir_cd") = true;
				ColHidden(prefix1 + "yd_cd") = true;
				ColHidden(prefix1 + "pol_clpt_ind_seq") = true;
				ColHidden(prefix1 + "crr_cd") = true;
				ColHidden(prefix1 + "pod_cd") = true;
				ColHidden(prefix1 + "blck_stwg_cd") = true;

			}
			break;
			
			case 3: // sheet2 init - DG
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|Co-load|UN NO.|Class|SRL1|Q'Ty|MP|LQ|C/Type|S/STWG|PC|REV.MTY|Remark|Height|Left|Right|Front|Rear|1|2|3|4|5|6|7|8";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true); 
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		45, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					InitDataProperty(0, cnt++, dtPopup, 		50, 	daCenter, 	true, 	prefix2 + "co_load"				,false	,""		,dfNone	,0	,true	,true	);
//					InitDataProperty(0, cnt++, dtPopup, 	    60, 	daCenter, 	true, 	prefix2 + "imdg_un_no"			,false	,""		,dfNone	,0	,true	,true	,4);
					InitDataProperty(0, cnt++, dtData, 	    	60, 	daCenter, 	true, 	prefix2 + "imdg_un_no"			,false	,""		,dfNone	,0	,true	,true	,4);
					InitDataProperty(0, cnt++, dtCombo, 		35, 	daCenter, 	true, 	prefix2 + "imdg_clss_cd"		,false	,""		,dfNone	,0	,false	,false	,3);
					InitDataProperty(0, cnt++, dtCombo, 		35, 	daCenter, 	true, 	prefix2 + "imdg_subs_rsk_lbl_cd",false	,""		,dfNone	,0	,false	,false	,3);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		30, 	daCenter, 	true, 	prefix2 + "mrn_polut_flg"		,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		30, 	daCenter, 	false, 	prefix2 + "imdg_lmt_qty_flg"	,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "cargo_type"			,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "stwg_cd"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		30, 	daCenter, 	true, 	prefix2 + "prct_flg"			,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "bkg_rev_mcgo_flg"	,false	,""		,dfNone	,0	,true	,true	,1);
					InitDataProperty(0, cnt++, dtData, 			70, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "hgt_ovr_dim_len"		,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "lf_sd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "rt_sd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "fwrd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "bkwd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, prefix2 + "imdg_un_no", vtNumericOnly);
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					InitDataCombo(0, prefix2 + "mrn_polut_flg", "N|Y", "N|Y");
					InitDataCombo(0, prefix2 + "imdg_lmt_qty_flg", "N|Y", "N|Y");
					InitDataCombo(0, prefix2 + "cargo_type", "| |REEFER|AWK|MTY", "| |R|A|E");
					InitDataCombo(0, prefix2 + "prct_flg", "N|Y", "N|Y");
					InitDataCombo(0, prefix2 + "bkg_rev_mcgo_flg", " |N|Y", " |N|Y");
					
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					
				}
				break;
				
			case 4: // sheet3 init - AWK
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|Height|Left|Right|Front|Rear|Q'Ty|C/P Status|S/STWG|PC|Remark|1|2|3|4|5|6|7|8";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		45, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	false, 	prefix2 + "hgt_ovr_dim_len"		,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "lf_sd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "rt_sd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "fwrd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "bkwd_ovr_dim_len"	,false	,""		,dfNone	,0	,true	,true	,9);
					InitDataProperty(0, cnt++, dtData, 			50, 	daRight, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 	   110, 	daRight, 	true, 	prefix2 + "crn_pst_sts_cd"		,false	,""		,dfNone	,0	,true	,true	,5, false, false, "Coner Post Status");
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "stwg_cd"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "prct_flg"			,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			70, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataCombo(0, prefix2 + "crn_pst_sts_cd", "| |1 Feet Extension|2 Feet Extension|3 Feet Extension|4 Feet Extension|5 Feet Extension|Erect-No Extension|FOLDING", "| |1|2|3|4|5|E|F");
					InitDataCombo(0, prefix2 + "prct_flg", "N|Y", "N|Y");
					InitDataValid(0, prefix2 + "hgt_ovr_dim_len", vtNumericOnly);
					InitDataValid(0, prefix2 + "lf_sd_ovr_dim_len", vtNumericOnly);
					InitDataValid(0, prefix2 + "rt_sd_ovr_dim_len", vtNumericOnly);
					InitDataValid(0, prefix2 + "fwrd_ovr_dim_len", vtNumericOnly);
					InitDataValid(0, prefix2 + "bkwd_ovr_dim_len", vtNumericOnly);
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
//					ColHidden(prefix2 + "cbf_rmk") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					
				}
				
				break;
				
			case 5: // sheet4 init - BB
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|Used F/C Q'ty|Void Space|Q'ty|S/STWG|PC|Remark|1|2|3|4|5|6|7|8";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	prefix2 + "usd_bkg_ttl_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix2 + "void_20ft_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "stwg_cd"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "prct_flg"			,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, prefix2 + "usd_bkg_ttl_qty", vtNumericOnly);
					InitDataValid(0, prefix2 + "void_20ft_qty", vtNumericOnly);
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					InitDataCombo(0, prefix2 + "prct_flg", "N|Y", "N|Y");
					
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
//					ColHidden(prefix2 + "cbf_rmk") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					
				}
				break;

				
			case 6: // sheet5 init - RF
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|Q'ty|S/STWG|PC|Remark|1|2|3|4|5|6|7|8|9";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "stwg_cd"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "prct_flg"			,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "cargo_type"			,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					InitDataCombo(0, prefix2 + "prct_flg", "N|Y", "N|Y");
					
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
//					ColHidden(prefix2 + "cbf_rmk") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					ColHidden(prefix2 + "cargo_type") = true;
					
				}
				break;

				
			case 7: // sheet6 init - MTY
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|Q'ty|REV.MTY|Remark|1|2|3|4|5|6|7|8";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "bkg_rev_mcgo_flg"    ,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			10, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					InitDataCombo(0, prefix2 + "bkg_rev_mcgo_flg", " |N|Y", " |N|Y");
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
//					ColHidden(prefix2 + "cbf_rmk") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					
				}
				break;

				
			case 8: // sheet7 init - BN
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|Used F/C Q'ty|Q'ty|Remark|1|2|3|4|5|6|7|8";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	prefix2 + "usd_bkg_ttl_qty"		,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, prefix2 + "usd_bkg_ttl_qty", vtNumericOnly);
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
//					ColHidden(prefix2 + "cbf_rmk") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					
				}
				break;

				
			case 9: // sheet8 init - S/STWG
				with (sheetObj) {
					//높이 설정
					style.height = 385;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					var HeadTitle1 = "|Sel|Carrier|POD|POD|T/S|S/S CD|Q'ty|PC|Remark|1|2|3|4|5|6|7|8";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix2 + "del_chk"				,false	,""		,dfNone	,0	,true	,true	,1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daCenter, 	true, 	prefix2 + "crr_cd"				,false	,""		,dfNone	,0	,false	,false	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "pod_nm2"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "pod_nm"				,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd"		,true	,""		,dfNone	,0	,true	,true	,2);
					
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "stwg_cd"				,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix2 + "cntr_qty"			,true	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	prefix2 + "prct_flg"			,false	,""		,dfNone	,0	,true	,true	,5);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	prefix2 + "cbf_rmk"				,false	,""		,dfNone	,0	,true	,true	);
					
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "vsl_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_voy_no"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "skd_dir_cd"			,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "yd_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pol_clpt_ind_seq"	,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "pod_cd"				,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "blck_stwg_cd"		,false	,""		,dfNone	,0	,false	,false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daRight, 	true, 	prefix2 + "cbf_spcl_smry_seq"	,false	,""		,dfNone	,0	,false	,false);
					HeadRowHeight = 20;
					
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, prefix2 + "cntr_qty", vtNumericOnly);
					InitDataCombo(0, prefix2 + "prct_flg", "N|Y", "N|Y");
					
					ColHidden(prefix2 + "vsl_cd") = true;
					ColHidden(prefix2 + "skd_voy_no") = true;
					ColHidden(prefix2 + "skd_dir_cd") = true;
					ColHidden(prefix2 + "yd_cd") = true;
					ColHidden(prefix2 + "pol_clpt_ind_seq") = true;
					ColHidden(prefix2 + "pod_cd") = true;
					ColHidden(prefix2 + "blck_stwg_cd") = true;
					ColHidden(prefix2 + "cbf_spcl_smry_seq") = true;
//					ColHidden(prefix2 + "cbf_rmk") = true;
					ColHidden(prefix2 + "pod_nm") = true;
					
				}
				break;
				
		}
	}
	
	/**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var select_crr_cd = document.form.crr_cd.Code;
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				for ( var j=0; j<sheet4HeadTitleCnt; j++ ) {
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg1") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd1") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd1") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd1") = true;
 						}
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg2") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd2") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd2") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd2") = true;
 						}
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg3") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd3") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd3") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd3") = true;
 						}
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg4") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd4") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd4") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd4") = true;
 						}
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg5") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd5") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd5") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd5") = true;
 						}
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg6") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd6") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd6") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd6") = true;
 						}
 						if(sheetObj.CellValue(i,prefix0 + "fcast_crr_cd_flg7") == 'Y'){
 							CellFontColor(i, prefix0 + "fcast_crr_cd7") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellFont("FontBold", i, prefix0 + "fcast_crr_cd7") = true;
 							sheetObj.CellFont("FontItalic", i, prefix0 + "fcast_crr_cd7") = true;
 						}
 						
 						if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd1")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd1") = sheetObj.RgbColor(0, 0, 255);
 						}else if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd2")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd2") = sheetObj.RgbColor(0, 0, 255);
 						}else if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd3")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd3") = sheetObj.RgbColor(0, 0, 255);
 						}else if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd4")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd4") = sheetObj.RgbColor(0, 0, 255);
 						}else if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd5")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd5") = sheetObj.RgbColor(0, 0, 255);
 						}else if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd6")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd6") = sheetObj.RgbColor(0, 0, 255);
 						}else if(select_crr_cd == sheetObj.CellValue(i,prefix0 + "fcast_crr_cd7")){
 							CellFontColor(i, prefix0 + "fcast_crr_cd7") = sheetObj.RgbColor(0, 0, 255);
 						}
 						
 						sheetObj.ColFontUnderline(j) = true;
 	 				}
 	 			}
 	 		}
 	 		
 	 		if(ComGetObjValue(document.form.crr_cd) == 'SML'){
 	 			document.form.crr_cd_nm.value = "N";
 	 		}
		}
	}
	
	/**
     * Sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
  	function t1sheet1_OnClick(sheetObj,Row,Col,Value){
  	    var formObj = document.form;
		formObj.crr_cd.Code2 = Value;
		document.form.crr_cd_nm.value = comboObjects[1].GetText(comboObjects[1].Code,1);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 	}
	 
	/**
     * Sheet2 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		var bkg_20ft_qty = 0;
		var bkg_40ft_qty = 0;
		var bkg_40ft_hc_qty = 0;
		var bkg_45ft_hc_qty = 0;
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
					if(sheetObj.CellValue(i,prefix1 + "bkg_20ft_qty") != 0){
						bkg_20ft_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_20ft_qty"));
					}
					if(sheetObj.CellValue(i,prefix1 + "bkg_40ft_qty") != 0){
						bkg_40ft_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_40ft_qty"));
					}
					if(sheetObj.CellValue(i,prefix1 + "bkg_40ft_hc_qty") != 0){
						bkg_40ft_hc_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_40ft_hc_qty"));
					}
					if(sheetObj.CellValue(i,prefix1 + "bkg_45ft_hc_qty") != 0){
						bkg_45ft_hc_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_45ft_hc_qty"));
					}
 	 			}
 	 			formObj.tot_tot_qty.value = makeCommaRun(bkg_20ft_qty + bkg_40ft_qty + bkg_40ft_hc_qty + bkg_45ft_hc_qty);
 	 			formObj.tot_20ft_qty.value = makeCommaRun(bkg_20ft_qty);
 	 			formObj.tot_40ft_qty.value = makeCommaRun(bkg_40ft_qty);
 	 			formObj.tot_40ft_hc_qty.value = makeCommaRun(bkg_40ft_hc_qty);
 	 			formObj.tot_45ft_hc_qty.value = makeCommaRun(bkg_45ft_hc_qty);
 	 		}
		}
	}
	
	function summary_qty(sheetObj) {
		var formObj = document.form;
		var bkg_20ft_qty = 0;
		var bkg_40ft_qty = 0;
		var bkg_40ft_hc_qty = 0;
		var bkg_45ft_hc_qty = 0;
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
					if(sheetObj.CellValue(i,prefix1 + "bkg_20ft_qty") != 0){
						bkg_20ft_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_20ft_qty"));
					}
					if(sheetObj.CellValue(i,prefix1 + "bkg_40ft_qty") != 0){
						bkg_40ft_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_40ft_qty"));
					}
					if(sheetObj.CellValue(i,prefix1 + "bkg_40ft_hc_qty") != 0){
						bkg_40ft_hc_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_40ft_hc_qty"));
					}
					if(sheetObj.CellValue(i,prefix1 + "bkg_45ft_hc_qty") != 0){
						bkg_45ft_hc_qty += parseInt(sheetObj.CellValue(i,prefix1 + "bkg_45ft_hc_qty"));
					}
 	 			}
 	 			formObj.tot_tot_qty.value = makeCommaRun(bkg_20ft_qty + bkg_40ft_qty + bkg_40ft_hc_qty + bkg_45ft_hc_qty);
 	 			formObj.tot_20ft_qty.value = makeCommaRun(bkg_20ft_qty);
 	 			formObj.tot_40ft_qty.value = makeCommaRun(bkg_40ft_qty);
 	 			formObj.tot_40ft_hc_qty.value = makeCommaRun(bkg_40ft_hc_qty);
 	 			formObj.tot_45ft_hc_qty.value = makeCommaRun(bkg_45ft_hc_qty);
 	 		}
		}
	}
	/**
     * Sheet2 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
  	function t2sheet1_OnClick(sheetObj,Row,Col,Value){
  	    var formObj = document.form;
		
		var yd_cd      = ComGetObjValue(formObj.yd_cd);
		var vsl_cd     = formObj.vsl_cd.value;
		var skd_voy_no = formObj.skd_voy_no.value;
		var skd_dir_cd = formObj.skd_dir_cd.value;
	 
		var crr_cd = sheetObj.CellValue(Row, "sheet1_crr_cd");
		var blck_stwg_cd = sheetObj.CellValue(Row, "sheet1_blck_stwg_cd");
		var pod_cd = sheetObj.CellValue(Row, "sheet1_pod_cd");
		var bkg_20_qty  = sheetObj.CellValue(Row, "sheet1_bkg_20ft_qty");
		var bkg_40_qty  = sheetObj.CellValue(Row, "sheet1_bkg_40ft_qty");
		var bkg_40h_qty = sheetObj.CellValue(Row, "sheet1_bkg_40ft_hc_qty");
		var bkg_45_qty  = sheetObj.CellValue(Row, "sheet1_bkg_45ft_hc_qty");
		
		var colName = sheetObj.ColSaveName(Col);
	
		switch(colName) {
		  case "sheet1_pod_stwg_cd":
		  if(pod_cd !="") {
	   	     sUrl = "/hanjin/VOP_OPF_2025.do?vvd="  +vsl_cd+skd_voy_no+skd_dir_cd + "&yd_cd=" + yd_cd + "&crr_cd=" + crr_cd + "&blck_stwg_cd=" + blck_stwg_cd + "&pod_cd=" + pod_cd 
	   	            + "&bkg_20_qty=" + bkg_20_qty + "&bkg_40_qty=" + bkg_40_qty + "&bkg_40h_qty=" + bkg_40h_qty + "&bkg_45_qty=" + bkg_45_qty ;
	   	     var winName = "PreviewPopup";
	   	     var features = "scroll:yes;status:no;resizable=no;help:no;dialogWidth:700px;dialogHeight:380px";
	   	     ComOpenWindow(sUrl,winName,features,true);  
		     }
	   	  
		  break;
	   	
		}
		
 	}
  	
    /**
     * Sheet3 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 		setSheet_stwg_cd_combo(sheetObj);
 		var awkexists = 'N';
 		
 		
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				if(sheetObj.CellValue(i, "sheet2_cargo_type") == "A"){
 		 				sheetObj.CellEditable(i, "sheet2_fwrd_ovr_dim_len") = true; 
 		 				sheetObj.CellEditable(i, "sheet2_bkwd_ovr_dim_len") = true; 
 		 				sheetObj.CellEditable(i, "sheet2_lf_sd_ovr_dim_len") = true; 
 		 				sheetObj.CellEditable(i, "sheet2_rt_sd_ovr_dim_len") = true; 
 		 				sheetObj.CellEditable(i, "sheet2_hgt_ovr_dim_len") = true; 
 		 				awkexists = 'Y';
 		 			}else{
 		 				sheetObj.CellEditable(i, "sheet2_fwrd_ovr_dim_len") = false;
 		 				sheetObj.CellEditable(i, "sheet2_bkwd_ovr_dim_len") = false; 
 		 				sheetObj.CellEditable(i, "sheet2_lf_sd_ovr_dim_len") = false; 
 		 				sheetObj.CellEditable(i, "sheet2_rt_sd_ovr_dim_len") = false; 
 		 				sheetObj.CellEditable(i, "sheet2_hgt_ovr_dim_len") = false; 
 		 			}
 	 			}
 	 		}
 	 		
 	 		if(awkexists == "N"){
 	 			sheetObj.ColHidden("sheet2_fwrd_ovr_dim_len") = true;
 	 			sheetObj.ColHidden("sheet2_bkwd_ovr_dim_len") = true;
 	 			sheetObj.ColHidden("sheet2_lf_sd_ovr_dim_len") = true;
 	 			sheetObj.ColHidden("sheet2_rt_sd_ovr_dim_len") = true;
 	 			sheetObj.ColHidden("sheet2_hgt_ovr_dim_len") = true;
 	 		}
		}
 		
 		
 	}
	
    /**
     * Sheet4 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 		setSheet_stwg_cd_combo(sheetObj);
 	}
	
    /**
     * Sheet5 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 		setSheet_stwg_cd_combo(sheetObj);
 	}
 	
    /**
     * Sheet6 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 		setSheet_stwg_cd_combo(sheetObj);
 	}
 	
    /**
     * Sheet7 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 	}
 	
    /**
     * Sheet8 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t8sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 	}
 	
    /**
     * Sheet9 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t9sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		setSheet_Pod_combo(sheetObj);
 		setSheet_stwg_cd_combo(sheetObj);
 	}
 	
 	
	function t2sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	 	switch(colName) {
			case "sheet1_pod_stwg_cd":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet1_pod_stwg_cd");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet1_pod_stwg_cd"));
							sheetObj.CellValue2(row, "sheet1_pod_stwg_cd") = "";
					   		return false;
						}else{
				 	 		if(sheetObj.RowCount > 0){
				 	 			for(var i=sheetObj.HeaderRows ; i < sheetObj.LastRow ; i++){
				 	 				if(sheetObj.CellValue(i,"sheet1_vsl_cd") != '' && sheetObj.CellValue(i,"sheet1_skd_voy_no") != '' && sheetObj.CellValue(i,"sheet1_skd_dir_cd") != ''){
				 						if(formObj.pod_chk.value == sheetObj.CellValue(i,"sheet1_pod_stwg_cd")){
				 							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet1_pod_stwg_cd"));
											sheetObj.CellValue2(row, "sheet1_pod_stwg_cd") = "";
									   		return false;
				 						}
				 	 				}
				 	 			}
				 	 		}
						}
	             }
			case "sheet1_del_chk":
				
				formObj.f_cmd.value = SEARCH11;
				stwgcd   = sheetObj.CellValue(row, "sheet1_blck_stwg_cd");
				vslcd    = sheetObj.CellValue(row, "sheet1_vsl_cd");
				skdvoyno = sheetObj.CellValue(row, "sheet1_skd_voy_no");
				skddircd = sheetObj.CellValue(row, "sheet1_skd_dir_cd");
				ydcd     = sheetObj.CellValue(row, "sheet1_yd_cd");
				polseq   = sheetObj.CellValue(row, "sheet1_pol_clpt_ind_seq");
				crrcd    = sheetObj.CellValue(row, "sheet1_crr_cd");
				pod      = sheetObj.CellValue(row, "sheet1_pod_cd");
				
				if(sheetObj.CellValue(row, "sheet1_del_chk") == "1" && vslcd !="" &&skdvoyno !="" && skddircd != "" && pod != "" && crrcd != "" && polseq != "" )  {
					var param = "vsl_cd=" + vslcd + "&" + "skd_voy_no=" + skdvoyno + "&" + "skd_dir_cd=" + skddircd + "&" + "yd_cd=" + ydcd + 
					             "&" + "pol_clpt_ind_seq=" + polseq + "&" + "crr_cd=" + crrcd + "&" + "pod_cd=" + pod  + "&" + "blck_stwg_cd=" + stwgcd; 
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", param + "&" + FormQueryString(formObj));
					var delFlg = ComGetEtcData(sXml, "delFlg");

                    if(delFlg == "E") {
                    	alert("Delete special cargo data of " + pod.substring(0,2)+ stwgcd);
                    	sheetObj.CellValue2(row, "sheet1_del_chk") = 0;
                    }
				}
				
			  
	 		break;
	 	}
	}
 	
	function t3sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	
	 	switch(colName) {
			case "sheet2_cargo_type":
	 			if(sheetObj.cellValue(row, 'sheet2_cargo_type') == 'A'){
	 				sheetObj.CellEditable(row, "sheet2_fwrd_ovr_dim_len") = true; 
	 				sheetObj.CellEditable(row, "sheet2_bkwd_ovr_dim_len") = true; 
	 				sheetObj.CellEditable(row, "sheet2_lf_sd_ovr_dim_len") = true; 
	 				sheetObj.CellEditable(row, "sheet2_rt_sd_ovr_dim_len") = true; 
	 				sheetObj.CellEditable(row, "sheet2_hgt_ovr_dim_len") = true; 
	 				
	 				sheetObj.ColHidden("sheet2_fwrd_ovr_dim_len") = false;
	 	 			sheetObj.ColHidden("sheet2_bkwd_ovr_dim_len") = false;
	 	 			sheetObj.ColHidden("sheet2_lf_sd_ovr_dim_len") = false;
	 	 			sheetObj.ColHidden("sheet2_rt_sd_ovr_dim_len") = false;
	 	 			sheetObj.ColHidden("sheet2_hgt_ovr_dim_len") = false;
	 	 			
	 				sheetObj.CellValue2(row,'sheet2_fwrd_ovr_dim_len') = 0;
	 				sheetObj.CellValue2(row,'sheet2_bkwd_ovr_dim_len') = 0;
	 				sheetObj.CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = 0;
	 				sheetObj.CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = 0;
	 				sheetObj.CellValue2(row,'sheet2_hgt_ovr_dim_len') = 0;
	 				
	 			}else{
	 				sheetObj.CellEditable(row, "sheet2_fwrd_ovr_dim_len") = false;
	 				sheetObj.CellEditable(row, "sheet2_bkwd_ovr_dim_len") = false; 
	 				sheetObj.CellEditable(row, "sheet2_lf_sd_ovr_dim_len") = false; 
	 				sheetObj.CellEditable(row, "sheet2_rt_sd_ovr_dim_len") = false; 
	 				sheetObj.CellEditable(row, "sheet2_hgt_ovr_dim_len") = false;
	 				
	 				sheetObj.CellValue2(row,'sheet2_fwrd_ovr_dim_len') = "";
	 				sheetObj.CellValue2(row,'sheet2_bkwd_ovr_dim_len') = "";
	 				sheetObj.CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = "";
	 				sheetObj.CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = "";
	 				sheetObj.CellValue2(row,'sheet2_hgt_ovr_dim_len') = "";
	 				
	 			}
	 		
	 		break;
	 		
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;
	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
							sheetObj.CellValue2(row,'sheet2_cargo_type') = '';
							
			 				sheetObj.CellEditable(row, "sheet2_fwrd_ovr_dim_len") = false;
			 				sheetObj.CellEditable(row, "sheet2_bkwd_ovr_dim_len") = false; 
			 				sheetObj.CellEditable(row, "sheet2_lf_sd_ovr_dim_len") = false; 
			 				sheetObj.CellEditable(row, "sheet2_rt_sd_ovr_dim_len") = false; 
			 				sheetObj.CellEditable(row, "sheet2_hgt_ovr_dim_len") = false;
			 				
			 				sheetObj.ColHidden("sheet2_fwrd_ovr_dim_len") = true;
			 	 			sheetObj.ColHidden("sheet2_bkwd_ovr_dim_len") = true;
			 	 			sheetObj.ColHidden("sheet2_lf_sd_ovr_dim_len") = true;
			 	 			sheetObj.ColHidden("sheet2_rt_sd_ovr_dim_len") = true;
			 	 			sheetObj.ColHidden("sheet2_hgt_ovr_dim_len") = true;

			 	 			sheetObj.CellValue2(row,'sheet2_fwrd_ovr_dim_len') = "";
			 				sheetObj.CellValue2(row,'sheet2_bkwd_ovr_dim_len') = "";
			 				sheetObj.CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = "";
			 				sheetObj.CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = "";
			 				sheetObj.CellValue2(row,'sheet2_hgt_ovr_dim_len') = "";
							
					   		return false;
						}else{
							if(sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd").substring(0,1) == 'R'){
								sheetObj.CellValue2(row,'sheet2_cargo_type') = 'R';
								
				 				sheetObj.CellEditable(row, "sheet2_fwrd_ovr_dim_len") = false;
				 				sheetObj.CellEditable(row, "sheet2_bkwd_ovr_dim_len") = false; 
				 				sheetObj.CellEditable(row, "sheet2_lf_sd_ovr_dim_len") = false; 
				 				sheetObj.CellEditable(row, "sheet2_rt_sd_ovr_dim_len") = false; 
				 				sheetObj.CellEditable(row, "sheet2_hgt_ovr_dim_len") = false;
				 				
				 				sheetObj.ColHidden("sheet2_fwrd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_bkwd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_lf_sd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_rt_sd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_hgt_ovr_dim_len") = true;
				 				
				 				sheetObj.CellValue2(row,'sheet2_fwrd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_bkwd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_hgt_ovr_dim_len') = "";
								
							}else if(sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd").substring(0,1) == 'F' || sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd").substring(0,1) == 'O'){
								sheetObj.CellValue2(row,'sheet2_cargo_type') = 'A';
								
				 				sheetObj.CellEditable(row, "sheet2_fwrd_ovr_dim_len") = true; 
				 				sheetObj.CellEditable(row, "sheet2_bkwd_ovr_dim_len") = true; 
				 				sheetObj.CellEditable(row, "sheet2_lf_sd_ovr_dim_len") = true; 
				 				sheetObj.CellEditable(row, "sheet2_rt_sd_ovr_dim_len") = true; 
				 				sheetObj.CellEditable(row, "sheet2_hgt_ovr_dim_len") = true; 
				 				
				 				sheetObj.ColHidden("sheet2_fwrd_ovr_dim_len") = false;
				 	 			sheetObj.ColHidden("sheet2_bkwd_ovr_dim_len") = false;
				 	 			sheetObj.ColHidden("sheet2_lf_sd_ovr_dim_len") = false;
				 	 			sheetObj.ColHidden("sheet2_rt_sd_ovr_dim_len") = false;
				 	 			sheetObj.ColHidden("sheet2_hgt_ovr_dim_len") = false;
				 	 			
				 				sheetObj.CellValue2(row,'sheet2_fwrd_ovr_dim_len') = 0;
				 				sheetObj.CellValue2(row,'sheet2_bkwd_ovr_dim_len') = 0;
				 				sheetObj.CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = 0;
				 				sheetObj.CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = 0;
				 				sheetObj.CellValue2(row,'sheet2_hgt_ovr_dim_len') = 0;
								
							}else{
								sheetObj.CellValue2(row,'sheet2_cargo_type') = '';
								
				 				sheetObj.CellEditable(row, "sheet2_fwrd_ovr_dim_len") = false;
				 				sheetObj.CellEditable(row, "sheet2_bkwd_ovr_dim_len") = false; 
				 				sheetObj.CellEditable(row, "sheet2_lf_sd_ovr_dim_len") = false; 
				 				sheetObj.CellEditable(row, "sheet2_rt_sd_ovr_dim_len") = false; 
				 				sheetObj.CellEditable(row, "sheet2_hgt_ovr_dim_len") = false;
				 				
				 				sheetObj.ColHidden("sheet2_fwrd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_bkwd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_lf_sd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_rt_sd_ovr_dim_len") = true;
				 	 			sheetObj.ColHidden("sheet2_hgt_ovr_dim_len") = true;
				 				
				 				sheetObj.CellValue2(row,'sheet2_fwrd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_bkwd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_lf_sd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_rt_sd_ovr_dim_len') = "";
				 				sheetObj.CellValue2(row,'sheet2_hgt_ovr_dim_len') = "";
								
							}
						}
					}
	 		break;
	 		
			case "sheet2_imdg_un_no":
	 			formObj.imdg_un_no.value 		 = sheetObj.CellValue(row, "sheet2_imdg_un_no");
	             if (sheetObj.CellValue(row, col).length == "4") {
	            	 sheetObj.CellEditable(row, "sheet2_imdg_clss_cd") = true; 
	            	 sheetObj.CellEditable(row, "sheet2_imdg_subs_rsk_lbl_cd") = true; 
	            	 
	            	 setSheet_UnNo_Class_combo(sheetObj, row);
	            	 setSheet_UnNo_Imdg_subs_rsk_lbl_cd_combo(sheetObj, row);
	             }
	 		break;
	 		
	 	}
	}
 	
	function t4sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	 	switch(colName) {
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;
	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
						}
					}
	 		break;
	 	}
	}
 	
	function t5sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	
	 	switch(colName) {
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;
	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
						}
					}
	 		break;
	 	}
	}
 	
	function t6sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	
	 	switch(colName) {
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;

	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
						}else{
			            	 var cargo_type_gb = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd").substring(0,1);

			            	 if(cargo_type_gb == 'T'){
								sheetObj.CellValue2(row, "sheet2_cargo_type") = cargo_type_gb;
			            	 }else{
								sheetObj.CellValue2(row, "sheet2_cargo_type") = "Y";
			            	 }
						}
					}
	 		break;
	 	}
	}
 	
	function t7sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	
	 	switch(colName) {
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;
	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
						}
					}
	 		break;
	 	}
	}
 	
	function t8sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	
	 	switch(colName) {
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;
	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
						}
					}
	 		break;
	 	}
	}
 	
	function t9sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	
	
	 	switch(colName) {
			case "sheet2_pod_nm2":
	 			formObj.pod_chk.value 		 = sheetObj.CellValue(row, "sheet2_pod_nm2");
	             if (sheetObj.CellValue(row, col).length == "5") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH01);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_pod_nm2"));
							sheetObj.CellValue2(row, "sheet2_pod_nm") = "";
							sheetObj.CellValue2(row, "sheet2_pod_nm2") = "";
					   		return false;
						}else{
							sheetObj.CellValue2(row, "sheet2_pod_nm") = sheetObj.CellValue(row, "sheet2_pod_nm2");
						}
	             }else{
					if(sheetObj.CellValue(row, "sheet2_pod_nm2") == ''){
						sheetObj.CellValue2(row, "sheet2_pod_nm") = '';
					}
	             }
	 		break;
	 		
			case "sheet2_cntr_tpsz_cd":
	 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd");
	             if (sheetObj.CellValue(row, col).length == "2") {
					var data = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						if(data == 'N'){
							ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "sheet2_cntr_tpsz_cd"));
							sheetObj.CellValue2(row, "sheet2_cntr_tpsz_cd") = "";
						}
					}
	 		break;
	 	}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
 
		switch (sAction) {	
		  case IBSEARCH: // Retrieve
				if (validateForm(sheetObj, formObj, sAction)) {
		
					formObj.f_cmd.value = SEARCH;
					// 처음 조회시.
					if(formObj.condition_gb.value != 'searchAWK'
						&& formObj.condition_gb.value != 'searchBB'
						&& formObj.condition_gb.value != 'searchRF'
						&& formObj.condition_gb.value != 'searchMTY'
						&& formObj.condition_gb.value != 'searchBN'
						&& formObj.condition_gb.value != 'searchSSTWG'
						){
						formObj.condition_gb.value = "searchDG";
					}
					
					if(formObj.condition_gb2.value != "") 
					{ 
					   formObj.condition_gb.value = formObj.condition_gb2.value;
					}
					  
					//파라미터 명시적인 생성
					var formParams = "";
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					formParams += "&condition_gb="      +ComGetObjValue(formObj.condition_gb);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&yd_cd="             +comboObjects[0].Code;	
				    formParams += "&pod_cd="            +ComGetObjValue(formObj.pod_cd);
					formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					formParams += "&bkg_sts_cd="        +ComGetObjValue(formObj.bkg_sts_cd);
					
					sheetObj.WaitImageVisible = false;
					sheetObj.Redraw = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix1, prefix2)));
					var arrXml = sXml.split("|$$|");
					var arrCt = arrXml.length;
					if (arrXml != null && arrCt > 0) {
						
						formObj.cntr_tpsz_cd.value = '';
						formObj.tot_tot_qty.value = 0;
						formObj.tot_20ft_qty.value = 0;
						formObj.tot_40ft_qty.value = 0;
						formObj.tot_40ft_hc_qty.value = 0;
						formObj.tot_45ft_hc_qty.value = 0;
						
						if(formObj.re_seach_yn.value != "N"){
							formObj.cgo_grs_wgt.value = makeComma(ComGetEtcData(arrXml[0], "sWeight"));
							formObj.crrCd.value = makeCommaRun(ComGetEtcData(arrXml[0], "crrCd"));
							sheetObjects[1].LoadSearchXml(arrXml[0]);
						}
				    
					
						if(formObj.condition_gb.value == 'searchDG'){
							sheetObjects[2].LoadSearchXml(arrXml[1]);
						}else if(formObj.condition_gb.value == 'searchAWK'){
							sheetObjects[3].LoadSearchXml(arrXml[1]);
						}else if(formObj.condition_gb.value == 'searchBB'){
							sheetObjects[4].LoadSearchXml(arrXml[1]);
						}else if(formObj.condition_gb.value == 'searchRF'){
							sheetObjects[5].LoadSearchXml(arrXml[1]);
						}else if(formObj.condition_gb.value == 'searchMTY'){
							sheetObjects[6].LoadSearchXml(arrXml[1]);
						}else if(formObj.condition_gb.value == 'searchBN'){
							sheetObjects[7].LoadSearchXml(arrXml[1]);
						}else if(formObj.condition_gb.value == 'searchSSTWG'){
							sheetObjects[8].LoadSearchXml(arrXml[1]);
						}
					}
				
					if(formObj.re_seach_yn.value != "N"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH03);
					}
					formObj.re_seach_yn.value = "Y";
					
					ComOpenWait(false);
					sheetObj.Redraw = true;
				}
	
				break;
				
				
			case IBSEARCH01:
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = COMMAND03;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", sParam);
				var podvalid = ComGetEtcData(sXml, "VALIDPOD");
			    return podvalid;
				break;

			case IBSEARCH02:
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = COMMAND02;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", sParam);
				var tyszvalid = ComGetEtcData(sXml, "VALIDTYPESIZE");
			    return tyszvalid;
				break;
				
		  case IBSEARCH03:
			  	sheetObj.WaitImageVisible = false;
				if (validateForm(sheetObj, formObj, sAction)) {
					
					formObj.f_cmd.value = SEARCH07;
		
					//파라미터 명시적인 생성
					var formParams = "";
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					formParams += "&condition_gb="      +ComGetObjValue(formObj.condition_gb);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&yd_cd="             +comboObjects[0].Code;	
					formParams += "&pod_cd="            +ComGetObjValue(formObj.pod_cd);
					formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					formParams += "&bkg_sts_cd="        +ComGetObjValue(formObj.bkg_sts_cd);

					var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix0, prefix1)));
					var arrXml = sXml.split("|$$|");
	
					var arrCt = arrXml.length;
					if (arrXml != null && arrCt > 0) {
						sheetObjects[0].LoadSearchXml(arrXml[0]);
					}
					
				}
	
				break;
		
			case IBDELETE: //DEL
				var vsl_cd = ComGetObjValue(formObj.vsl_cd);
				var skd_voy_no = ComGetObjValue(formObj.skd_voy_no);
				var skd_dir_cd = ComGetObjValue(formObj.skd_dir_cd);
				var yd_cd      = comboObjects[0].Code;
				
			 if(vsl_cd !="" && skd_voy_no != "" && skd_dir_cd != ""  && yd_cd != "") {
				if(!ComShowCodeConfirm('OPF50002', 'data')) return false;	//'Do you want to delete {?msg1}?'
				
				formObj.f_cmd.value = COMMAND01;
				
				var formParams = "";
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&yd_cd="             +comboObjects[0].Code;	
		
				var sXml = sheetObj.GetSaveXml("VOP_OPF_0022GS.do", formParams);
				sheetObj.LoadSaveXml(sXml);

				doActionIBSheet(sheetObj, formObj, IBSEARCH); 
				
				}
			 else ComShowMessage("Please input VVD and POL.");
				break;
				
			case IBSEARCH04: // KOREA CLL과 BOOKING 데이터 비교
			   
				var nation = comboObjects[0].Code.substr(0, 2);
				
				if(nation == "KR"){
				
				formObj.f_cmd.value = COMMAND04;
				
				var formParams = "";
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&yd_cd="             +comboObjects[0].Code;	
		
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", formParams);
				
				ComOpenWait(false);
				var diffCntr = ComGetEtcData(sXml, "VALIDDIFF");

				if(diffCntr == "Y"){
				var formObj = document.form;		
				
			   	var theURL = "VOP_OPF_2023.do?vvd="					+ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd)
											+"&pol_cd="             +ComGetObjValue(formObj.pol_cd)
											+"&pol_clpt_ind_seq="  	+ComGetObjValue(formObj.pol_clpt_ind_seq);
			   	
			   	var winName = "PreviewPopup";
			   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:900px;dialogHeight:550px";
			   	ComOpenWindow(theURL,winName,features,true);
				}
				
			  }
				else  ComOpenWait(false); 
				
				break;
				
			case IBSEARCH05: // partner edi		
				formObj.f_cmd.value = COMMAND05;
				
				var formParams = "";
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&yd_cd="             +comboObjects[0].Code;	
				
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0022GS.do", formParams);
				var flag = ComGetEtcData(sXml, "VALIDCNT");
				
				return flag;
				
			case IBSAVE: // Save

				var save_gb = '';
				
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				
				if(formObj.condition_gb.value == "delCrrCd"){
					if(!ComShowCodeConfirm('OPF50002', ' : ['+formObj.crr_cd.Code+ '] Carrier Code')) return false;

					if(formObj.crr_cd_nm.value == "N"){
						alert("You can't delete Carrier Code : ["+formObj.crr_cd.Code+ "]"); return false;
					}
				}

				formObj.f_cmd.value = MULTI;
				
				//파라미터 명시적인 생성
				var formParams = "";
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				formParams += "&condition_gb="  			+ComGetObjValue(formObj.condition_gb);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&yd_cd="             +comboObjects[0].Code;	
				formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
				if(ComGetObjValue(formObj.condition_gb) == 'addCrrCd'){
					formParams += "&crr_cd="  		+ComGetObjValue(formObj.carrier_cd);
				}else{
					formParams += "&crr_cd="  		+ComGetObjValue(formObj.crr_cd);
				}
				formParams += "&pol_cd="             +ComGetObjValue(formObj.pol_cd);
				formParams += "&pol_clpt_ind_seq="  +ComGetObjValue(formObj.pol_clpt_ind_seq);

				formParams += "&dcgo_flg="  	+ComGetObjValue(formObj.dcgo_flg);
				formParams += "&rc_flg="  		+ComGetObjValue(formObj.rc_flg);
				formParams += "&awk_cgo_flg="  	+ComGetObjValue(formObj.awk_cgo_flg);
				formParams += "&bb_cgo_flg="  	+ComGetObjValue(formObj.bb_cgo_flg);
				formParams += "&bdl_cgo_flg="  	+ComGetObjValue(formObj.bdl_cgo_flg);
				formParams += "&stwg_cgo_flg="  +ComGetObjValue(formObj.stwg_cgo_flg);
				formParams += "&mty_bkg_flg="  	+ComGetObjValue(formObj.mty_bkg_flg);
				formParams += "&cgo_grs_wgt="  	+(ComGetObjValue(formObj.cgo_grs_wgt)).replace(/,/g, "");
				formParams += "&bkg_sts_cd="    +ComGetObjValue(formObj.bkg_sts_cd);
				if(ComGetObjValue(formObj.condition_gb) == 'addCrrCd' 
					|| ComGetObjValue(formObj.condition_gb) == 'delCrrCd'
					|| ComGetObjValue(formObj.condition_gb) == 'manageIfBkgDt'
				    || ComGetObjValue(formObj.condition_gb) == 'manageIfEDI' ){
		     	    var sXml = sheetObj.GetSaveXml("VOP_OPF_0022GS.do", formParams);
					sheetObj.LoadSaveXml(sXml);
				}else if(ComGetObjValue(formObj.condition_gb) == 'manageSave'){
					
         			var sParam = ComGetSaveString(sheetObjects[1]);
         			var sParamSpecial;

         			if(ComGetSaveString(sheetObjects[2]) != ''){
         				tabIndex = 0;
         				sParamSpecial = ComGetSaveString(sheetObjects[2]);
         			}else if(ComGetSaveString(sheetObjects[3]) != ''){
         				tabIndex = 1;
         				sParamSpecial = ComGetSaveString(sheetObjects[3]);
         			}else if(ComGetSaveString(sheetObjects[4]) != ''){
         				tabIndex = 2;
         				sParamSpecial = ComGetSaveString(sheetObjects[4]);
         			}else if(ComGetSaveString(sheetObjects[5]) != ''){
         				tabIndex = 3;
         				sParamSpecial = ComGetSaveString(sheetObjects[5]);
         			}else if(ComGetSaveString(sheetObjects[6]) != ''){
         				tabIndex = 4;
         				sParamSpecial = ComGetSaveString(sheetObjects[6]);
         			}else if(ComGetSaveString(sheetObjects[7]) != ''){
         				tabIndex = 5;
         				sParamSpecial = ComGetSaveString(sheetObjects[7]);
         			}else if(ComGetSaveString(sheetObjects[8]) != ''){
         				tabIndex = 6;
         				sParamSpecial = ComGetSaveString(sheetObjects[8]);
         			}
         			
         			//파라미터 명시적인 생성
         			
         			sParam += "&" + sParamSpecial+"&" + formParams;
         			var sXml = sheetObj.GetSaveXml("VOP_OPF_0022GS.do", sParam);
         			var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");        	
         			sheetObj.LoadSaveXml(sXml);
					
				}
									
				if(formObj.condition_gb.value != "addCrrCd"){
					if(formObj.condition_gb.value == "delCrrCd"){
						setCarrier_combo();
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}

					if(formObj.condition_gb.value == "manageIfBkgDt"){
						formObj.crr_cd.Code2 = 'SML';
					}				
				}
				
				if ( svcResult == "S" ) {
					// 저장 성공시에만 재조회 실행.
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					
					 if (tabIndex == 1) {
						 formObj.condition_gb.value = "searchAWK"
						 sheetObjects[3].RemoveAll();				 
						 doActionIBSheet(sheetObjects[3],formObj,IBSEARCH);
					 }else if (tabIndex == 2) {
						 formObj.condition_gb.value = "searchBB"
							 sheetObjects[4].RemoveAll();
						 doActionIBSheet(sheetObjects[4],formObj,IBSEARCH);
					 }else if (tabIndex == 3) {
						 formObj.condition_gb.value = "searchRF"
							 sheetObjects[5].RemoveAll();
						 doActionIBSheet(sheetObjects[5],formObj,IBSEARCH);
					 }else if (tabIndex == 4) {
						 formObj.condition_gb.value = "searchMTY"
							 sheetObjects[6].RemoveAll();
						 doActionIBSheet(sheetObjects[6],formObj,IBSEARCH);
					 }else if (tabIndex == 5) {
						 formObj.condition_gb.value = "searchBN"
							 sheetObjects[7].RemoveAll();
						 doActionIBSheet(sheetObjects[7],formObj,IBSEARCH);
					 }else if (tabIndex == 6) {
						 formObj.condition_gb.value = "searchSSTWG"
							 sheetObjects[8].RemoveAll();
						 doActionIBSheet(sheetObjects[8],formObj,IBSEARCH);
					 }else{
						 formObj.condition_gb.value = "searchDG"
							 sheetObjects[2].RemoveAll();
						 doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
					 }
					
				}				
				
				break;
		}
	}
	
	/*******************************************************************************
	 * Validation 시작 *
	 ******************************************************************************/
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
	
		case IBSEARCH:
			break;
		case IBSAVE:
			if(formObj.vsl_cd.value == '' || formObj.skd_voy_no.value == '' || formObj.skd_dir_cd.value == ''){
				ComShowCodeMessage("OPF50009", "VVD");
				ComSetFocus(formObj.vsl_cd);
		   		return false;
			}
			if(formObj.yd_cd.Code == ''){
				ComShowCodeMessage("OPF50009", "POL");
				ComSetFocus(formObj.yd_cd);
		   		return false;
			}
			if(formObj.pod_cd.Code == ''){
				ComShowCodeMessage("OPF50009", "POD");
				ComSetFocus(formObj.pod_cd);
		   		return false;
			}
			
			if(formObj.condition_gb.value != "addCrrCd"){
				if(formObj.crr_cd.Code == ''){
					ComShowCodeMessage("OPF50009", "Carrier");
					ComSetFocus(formObj.crr_cd);
					return false;
				}
			}
			
        	if(sheetObjects[1].RowCount>0){
        		for(i=1; i< (sheetObjects[1].RowCount+1); i++){
        			
        			if(sheetObjects[1].CellValue(i,prefix1 + "pod_stwg_cd") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[1].SelectCell(i,prefix1 + "pod_stwg_cd",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[2].RowCount>0){
        		for(i=1; i< (sheetObjects[2].RowCount+1); i++){
        			
        			if(sheetObjects[2].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[2].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[2].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[2].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[2].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[2].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[3].RowCount>0){
        		for(i=1; i< (sheetObjects[3].RowCount+1); i++){
        			
        			if(sheetObjects[3].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[3].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[3].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[3].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[3].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[3].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[4].RowCount>0){
        		for(i=1; i< (sheetObjects[4].RowCount+1); i++){
        			
        			if(sheetObjects[4].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[4].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[4].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[4].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[4].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[4].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[5].RowCount>0){
        		for(i=1; i< (sheetObjects[5].RowCount+1); i++){
        			
        			if(sheetObjects[5].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[5].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[5].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[5].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[5].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[5].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[6].RowCount>0){
        		for(i=1; i< (sheetObjects[6].RowCount+1); i++){
        			
        			if(sheetObjects[6].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[6].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[6].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[6].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[6].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[6].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[7].RowCount>0){
        		for(i=1; i< (sheetObjects[7].RowCount+1); i++){
        			
        			if(sheetObjects[7].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[7].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[7].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[7].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[7].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[7].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}
        	if(sheetObjects[8].RowCount>0){
        		for(i=1; i< (sheetObjects[8].RowCount+1); i++){
        			
        			if(sheetObjects[8].CellValue(i,prefix2 + "pod_nm") == ""){
                		ComShowCodeMessage("OPF50009", "POD");
                		sheetObjects[8].SelectCell(i,prefix2 + "pod_nm2",true);
                		return false;
                	}
        			if(sheetObjects[8].CellValue(i,prefix2 + "cntr_tpsz_cd") == ""){
                		ComShowCodeMessage("OPF50009", "T/S");
                		sheetObjects[8].SelectCell(i,prefix2 + "cntr_tpsz_cd",true);
                		return false;
                	}
        			if(sheetObjects[8].CellValue(i,prefix2 + "cntr_qty") == ""){
                		ComShowCodeMessage("OPF50009", "QTY");
                		sheetObjects[8].SelectCell(i,prefix2 + "cntr_qty",true);
                		return false;
                	}
        		}
        	}

			break;
		case IBCLEAR:
			if(sheetObj.IsDataModified) {
				var msg1 = "";
				if(ComShowCodeConfirm('OPF50003', msg1)) {
					doActionIBSheet(sheetObj,formObj,IBSAVE);
					return true;
				}
			}			
			break;
		}
	
		return true;
	}

	function validateCheck(){
		var formObj   = document.form;
		if(formObj.vsl_cd.value == '' || formObj.skd_voy_no.value == '' || formObj.skd_dir_cd.value == ''){
			ComShowCodeMessage("OPF50009", "VVD");
			ComSetFocus(formObj.vsl_cd);
	   		return false;
		}else if(formObj.yd_cd.Code == ''){
			ComShowCodeMessage("OPF50009", "POL");
			ComSetFocus(formObj.yd_cd);
	   		return false;
	   	}else if(formObj.pod_cd.Code == ''){
			ComShowCodeMessage("OPF50009", "POD");
			ComSetFocus(formObj.pod_cd);
	   		return false;
		}
		
		if(formObj.condition_gb.value != "addCrrCd"){
			if(formObj.crr_cd.Code == ''){
				ComShowCodeMessage("OPF50009", "Carrier");
				ComSetFocus(formObj.crr_cd);
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * // Preview Popup
	 */
	function preview_pop(){
		var formObj = document.form;		
		
	   	var theURL = "VOP_OPF_2022.do?vvd="					+ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd)
									+"&pol_cd="             +ComGetObjValue(formObj.pol_cd)
									+"&pol_clpt_ind_seq="  	+ComGetObjValue(formObj.pol_clpt_ind_seq);
	   	
	   	var winName = "PreviewPopup";
	   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1040px;dialogHeight:600px";
	   	ComOpenWindow(theURL,winName,features,true);
	}	

  /**
   * Sheet2에서 Popup 이벤트를 발생시킴.
   */
  function t3sheet1_OnPopupClick (sheetObj , row , col ){
	  var formObj = document.form;
	  var colName = sheetObjects[2].ColSaveName(col);
	  switch(colName){
	  	case('sheet2_imdg_un_no'):
//		   	ComOpenPopup("ESM_BKG_0204.do?imdg_un_no="+sheetObjects[2].CellValue(row, "sheet2_imdg_un_no")+"&bkg_no=", 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
	  		break;
	  	case('sheet2_co_load'):
	  		if(sheetObjects[2].CellValue(row, "sheet2_vsl_cd") != '' && sheetObjects[2].CellValue(row, "sheet2_skd_voy_no") != '' && sheetObjects[2].CellValue(row, "sheet2_skd_dir_cd") != ''){
				var pop_param = "";
				pop_param += "vsl_cd="	+sheetObjects[2].CellValue(row, "sheet2_vsl_cd");
				pop_param += "&skd_voy_no="	+sheetObjects[2].CellValue(row, "sheet2_skd_voy_no");
				pop_param += "&skd_dir_cd="	+sheetObjects[2].CellValue(row, "sheet2_skd_dir_cd");
				pop_param += "&yd_cd="	+sheetObjects[2].CellValue(row, "sheet2_yd_cd");
				pop_param += "&pol_clpt_ind_seq="	+sheetObjects[2].CellValue(row, "sheet2_pol_clpt_ind_seq");
				pop_param += "&crr_cd="	+sheetObjects[2].CellValue(row, "sheet2_crr_cd");
				pop_param += "&pod_cd="	+sheetObjects[2].CellValue(row, "sheet2_pod_cd");
				pop_param += "&blck_stwg_cd="	+sheetObjects[2].CellValue(row, "sheet2_blck_stwg_cd");
				pop_param += "&cbf_spcl_smry_seq="	+sheetObjects[2].CellValue(row, "sheet2_cbf_spcl_smry_seq");
				pop_param += "&imdg_un_no="	+sheetObjects[2].CellValue(row, "sheet2_imdg_un_no");
				pop_param += "&imdg_clss_cd="	+sheetObjects[2].CellText(row, "sheet2_imdg_clss_cd");
				pop_param += "&imdg_subs_rsk_lbl_cd="	+sheetObjects[2].CellText(row, "sheet2_imdg_subs_rsk_lbl_cd");
				pop_param += "&mrn_polut_flg="	+sheetObjects[2].CellValue(row, "sheet2_mrn_polut_flg");
				pop_param += "&imdg_lmt_qty_flg="	+sheetObjects[2].CellValue(row, "sheet2_imdg_lmt_qty_flg");
		  	
			   	ComOpenPopup("VOP_OPF_0023.do?"+pop_param, 360, 310, "CO_LOAD_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "VOP_OPF_0023");
	  		}
	  		break;
	  }
  }
  
	/**
	 * UN No. 리턴값 설정
	 */
  function getCOM_UNNO_POPUP(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var sRow = sheetObjects[2].SelectRow;
		sheetObjects[2].CellValue2(sRow,'sheet2_imdg_un_no') = colArray[2];
		sheetObjects[2].CellValue2(sRow,'sheet2_imdg_clss_cd') = colArray[4];
  }
		
  function makeComma(srcValue){
  	var arrVal = srcValue.split(".");
  	
  	if(arrVal.length > 1){
	    	if(arrVal[1].length > 3){
	    		arrVal[1] = arrVal[1].substring(0,3);
	    	}			
			srcValue = makeCommaRun(arrVal[0])+"."+ComRpad(arrVal[1], 3, "0");    		
  	}else{
//  		srcValue = makeCommaRun(arrVal[0]) + ".000";
  	}
		return  srcValue;
  }
  
  function makeCommaRun(srcValue){    	
//  	srcValue=srcValue.replace(/\D/g,"");
  	if(srcValue.length > 9){
  		srcValue = srcValue.substring(0,9);
  	}
		l=srcValue.length-3;
		while(l > 0) {
			srcValue=srcValue.substr(0,l)+","+srcValue.substr(l);
			l-=3;
		}    		
  	return srcValue;
  }
  
/* 개발자 작업 끝 */