/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_1021.js
 *@FileTitle : Own Container Booking Forecast Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.07.07 우지석
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
 */

	/**
	 * @extends
	 * @class VOP_OPF_0021 : VOP_OPF_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_OPF_0021() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage 			= loadPage;
		this.initSheet 			= initSheet;
		this.initControl 		= initControl;
		this.doActionIBSheet 	= doActionIBSheet;
		this.validateForm 		= validateForm;
	}

	/* 개발자 작업	*/
	
	// 공통전역변수	
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	var cgoOprList   = new Array();
	
	var comboObjects = new Array();
	var comboCnt     = 0;
	var tcnt         = 0;
	
	var rdObjects    = new Array();
	var rdCnt        = 0;
	var queryStr     = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {		
		var sheetObj = sheetObjects[0]; // sheet1		
		var formObj  = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_Print":
					doActionIBSheet(sheetObj, document.form, IBSEARCH);	
					break;
	
				case "btn_close":
					self.close();
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

	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {	
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				
				var podComboObj = comboObjects[0];
				var oprComboObj = comboObjects[1];
				var mlbComboObj = comboObjects[2];
				
				var selP = "";
				for (var i = 0; i < formObj.selPrint.length; i++) {
					if (formObj.selPrint[i].checked) {
						var selP = formObj.selPrint[i].value;
					}
				}
				
	            var rdParam = "/rp " +
				              "["    + ComTrim(podComboObj.Code) + "] [" + ComTrim(oprComboObj.Code) + "] [" + ComTrim(mlbComboObj.Code) + "] ";
				
	            rdParam = rdParam + "/rv " +
				                    "vsl_cd["      + ComGetObjValue(formObj.vsl_cd)      + "] skd_voy_no[" + ComGetObjValue(formObj.skd_voy_no) + "] skd_dir_cd[" + ComGetObjValue(formObj.skd_dir_cd) + "] " +
				                    "vsl_nm["      + ComGetObjValue(formObj.vsl_nm)      + "] yd_cd["      + ComGetObjValue(formObj.yd_cd)      + "] loc_nm["     + ComGetObjValue(formObj.loc_nm)     + "] " +
				                    "yd_nm["       + ComGetObjValue(formObj.yd_nm)       + "] slan_cd["    + ComGetObjValue(formObj.slan_cd)    + "] slan_nm["    + ComGetObjValue(formObj.slan_nm)    + "] " +
				                    "cbf_ind_flg[" + ComGetObjValue(formObj.cbf_ind_flg) + "] upd_dt["     + ComGetObjValue(formObj.upd_dt)     + "] crr_cd["     + ComGetObjValue(formObj.crr_cd)     + "] " +
				                    "pod_cd["      + ComGetObjValue(formObj.pod_cd)      + "] mlb_cd["     + ComGetObjValue(formObj.mlb_cd)     + "] rd_type["    + selP                               + "]";
				
				/************************************************************************************************************
				 * - 1. CBF Summary by Volume                          		: UI_OPF-1121 
				 * - 2. Special Cargo Summary by Volume                		: UI_OPF-1621
                 * - 3. CBF Summary by Volume (Mini Land Bridge)       		: UI_OPF-1221
                 * - 4. Special Cargo Summary by Volume  (Mini Land Bridge) : UI_OPF-1621
                 * 
                 * - 5. CBF Summary by Weight Group                    		: UI_OPF-1321
                 * - 6. CBF Summary by Weight Group (Mini Land Bridge) 		: UI_OPF-1421 
                 * 
                 * - 7. All Special Cargo                              		: UI_OPF-1521
                 * - 8. Dangerous Cargo                                		: UI_OPF-1521 
                 * - 9. Reefer Cargo                                   		: UI_OPF-1521 
                 * - 10.Awkward Cargo                                  		: UI_OPF-1521
                 * - 11.Break Bulk Cargo                               		: UI_OPF-1521
                 * - 12.Special Stowage                                		: UI_OPF-1521
                 * - 13.Empty Container                                		: UI_OPF-1521  POD에 MLB가 없는 경우 프린트 되는 포멧 + 있는 경우 모두 포함
				 *************************************************************************************************************/
				var strPath = "";
				
				//1. CBF Summary by Volume
				if (selP == "1") {
					strPath = "VOP_OPF_1121.mrd";
				}
				//2. Special Cargo Summary by Volume
				else if (selP == "2") {
					strPath = "VOP_OPF_1621.mrd";
				}
				//3. CBF Summary by Volume (Mini Land Bridge)
				else if (selP == "3") {
					strPath = "VOP_OPF_1221.mrd";
				}
				//4. Special Cargo Summary by Volume (Mini Land Bridge)
				else if (selP == "4") {
					strPath = "VOP_OPF_1621.mrd";
				}
				//5. CBF Summary by Weight Group
				else if (selP == "5") {
					strPath = "VOP_OPF_1321.mrd";
				}
				//6. CBF Summary by Weight Group (Mini Land Bridge)
				else if (selP == "6") {
					strPath = "VOP_OPF_1421.mrd";
				}
				//7. All Special Cargo
				else if (selP == "7") {
					strPath = "VOP_OPF_1521.mrd";
				}
				//8. Dangerous Cargo
				else if (selP == "8") {
					strPath = "VOP_OPF_1521.mrd";
				}
				//9. Reefer Cargo
				else if (selP == "9") {
					strPath = "VOP_OPF_1521.mrd";
				}
				//10. Awkward Cargo
				else if (selP == "10") {
					strPath = "VOP_OPF_1521.mrd";
				}
				//11. Break Bulk Cargo
				else if (selP == "11") {
					strPath = "VOP_OPF_1521.mrd";
				}
				//12. Special Stowage
				else if (selP == "12") {
					strPath = "VOP_OPF_1521.mrd";
				}
				//13. Empty Container
				else if (selP == "13") {
					strPath = "VOP_OPF_1521.mrd";
				}
				
				strPath = "apps/alps/vop/opf/cargoloadingplanmgt/owncontainerbookingforecastmgt/report/" + strPath;
				
				var cgoOpr = "";
				for ( var n = 0; n < 5; n++) {
					if(n < cgoOprList.length) cgoOpr = cgoOprList[n];
					else cgoOpr = "";
					
					//조회조건 적용
					if(ComTrim(oprComboObj.Text) != "ALL") {
						if(n == 0) cgoOpr = ComTrim(oprComboObj.Text);
						else cgoOpr = "";
					}
					
					rdParam = rdParam + " qty"+(n+1)+"[" + cgoOpr + "]";
				}				
				
				for(var i=1; i<=15; i++) {
					rdParam = rdParam + " st_"+i+"[" + ComGetObjValue(eval("formObj.st_"+i)) + "]";
				}
				rdParam = rdParam + " opr_st_ct[" + ComGetObjValue(formObj.opr_st_ct) + "]";
				for(var i=1; i<=5; i++) {
					for(var j=1; j<=15; j++) {
						rdParam = rdParam + " opr"+i+"_st"+j+"[" + ComGetObjValue(eval("formObj.opr"+i+"_st"+j)) + "]";
					}
				}
				for(var i=1; i<=75; i++) {
					rdParam = rdParam + " opr_stcd"+i+"[" + ComGetObjValue(eval("formObj.opr_stcd"+i)) + "]";
				}
				
				ComSetObjValue(formObj.com_mrdPath,                   strPath);
				ComSetObjValue(formObj.com_mrdArguments,              rdParam);
				ComSetObjValue(formObj.com_mrdSaveDialogDir,          "c:\\MyFolder\\");
				ComSetObjValue(formObj.com_mrdSaveDialogFileName,     "SaveFileName");
				ComSetObjValue(formObj.com_mrdSaveDialogFileExt,      "pdf");
				ComSetObjValue(formObj.com_mrdSaveDialogFileExtLimit, "xls@pdf@bmp@tif");
				ComSetObjValue(formObj.com_mrdTitle,                  "Report Designer Common Popup");
				ComSetObjValue(formObj.com_mrdBodyTitle,              "Print CBF Summary");
				ComSetObjValue(formObj.com_isBatch,                   "Y");
				
				var leftpos = (screen.width - 960) / 2;
				if (leftpos < 0) leftpos = 0;
				var toppos = (screen.height - 650) / 2;
				if (toppos < 0) toppos = 0;
				
				ComOpenRDPopupModal("dialogWidth:990px;dialogHeight:672px;status:No;dialogTop:"+toppos+"px;dialogLeft:"+leftpos+"px");
		  
				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {			
		return true;
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
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
	
	//RD 초기화
	function initRdConfig(rdObject) {
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.setbackgroundcolor(128, 128, 128);
		Rdviewer.SetPageLineColor(128, 128, 128);

		Rdviewer.style.height = 0;
	}
	
	/**
	 * IBCOMBO 초기화. <br>
	 **/
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "pod_cd2":			
				with (comboObj) {
					DropHeight  = 230;
					InsertItem(0, 'ALL', ' ');
					Text2 = "ALL";
				}
				break;	
			case "crr_cd2":
				with (comboObj) {
					DropHeight      = 230;										
					InsertItem(0, 'ALL', ' ');
					Text2 = "ALL";
				}
				break;
			case "mlb_cd2":
				with (comboObj) {
					DropHeight      = 230;										
					InsertItem(0, 'ALL', ' ');
					Text2 = "ALL";
				}
				break;
		}	
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		// IBMultiCombo초기화
		for (var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		//IBSheet 초기화
		for (var i = 0; i < sheetObjects.length; i++) {			
			ComConfigSheet(sheetObjects[i]);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// RD 초기화
		for (var i = 0; i < rdObjects.length; i++) {
			initRdConfig(rdObjects[i], i + 1);
		}
		
		searchOprPodMlbCombo(sheetObjects[0]);	//POD, OPR, MBL
	}
	 
	/**
     * Sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
	function sheet1_OnLoadFinish(sheetObj) {
    	 //searchOprPodMlbCombo(sheetObj);	//POD, OPR, MBL
	}
	
	// OPR OnChange 이벤트 처리
    function crr_cd2_OnChange(comboObj, Index_Code, Text) {
    	var formObj  = document.form;
    	var sParam = "";
    	sParam += "vsl_cd="      + ComGetObjValue(formObj.vsl_cd);
		sParam += "&skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
		sParam += "&skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
		sParam += "&yd_cd="      + ComGetObjValue(formObj.yd_cd);
		
    	if(Text == "ALL") {
    		var oprCt;
    		for(oprCt=0; oprCt<cgoOprList.length; oprCt++) {
    			sParam += "&qty"+(oprCt+1)+"=" + cgoOprList[oprCt];
    		}
    		for(var j=oprCt+1; j<=5; j++) {
				sParam += "&qty"+(j)+"=" + "";
			}
    	} else {
    		sParam += "&qty1=" + Text;
    		for(var j=2; j<=5; j++) {
				sParam += "&qty"+(j)+"=" + "";
			}
    	}
    	
    	//Stowage Code List 조회
    	searchStowageList(sheetObjects[0], formObj, sParam);
    }
	
	//POD, OPR, MLB Combo & Stowage Code List
	function searchOprPodMlbCombo(sheetObj) {
		var formObj  = document.form;
		
		var sParam = "";
		sParam += "vsl_cd="      + ComGetObjValue(formObj.vsl_cd);
		sParam += "&skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
		sParam += "&skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
		sParam += "&yd_cd="      + ComGetObjValue(formObj.yd_cd);
		
		var podComboObj = comboObjects[0];
		var oprComboObj = comboObjects[1];
		var mlbComboObj = comboObjects[2];
		
		sheetObj.WaitImageVisible = false;		
		formObj.f_cmd.value = SEARCH11;
		var sXml = sheetObj.GetSearchXml("VOP_OPF_0021GS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		
		//1. POD
		var sPod   = ComGetEtcData(sXml, "sPod");			
		if (sPod != undefined) {
			var arrPod = sPod.split("|");	
			var podCd = ""; //yd_code + clpt_ind_seq
			for (var i = 0; i < arrPod.length; i++) {
				podCd = arrPod[i];
				if(podCd != '') podCd = podCd.substring(0, podCd.length-1); 
				podComboObj.InsertItem(i+1, podCd, arrPod[i]);
			}
		}
		
		//2. OPR
		var sOpr   = ComGetEtcData(sXml, "sOpr");	
		var oprCt  = 0;
		var sPCt   = 1;
		if (sOpr != undefined) {
			var arrOpr = sOpr.split("|");					
			for (var i = 0; i < arrOpr.length; i++) {
				if(ComTrim(arrOpr[i]) != '') {
					oprComboObj.InsertItem(i+1, arrOpr[i], arrOpr[i]);
					
					cgoOprList[oprCt++] = arrOpr[i];
					
					sParam += "&qty"+(sPCt++)+"=" + arrOpr[i];
				}
			}
			for(var j=sPCt; j<=5; j++) {
				sParam += "&qty"+(j)+"=" + "";
			}
		}		
		
		//3. MLB
		var sMlb = ComGetEtcData(sXml, "sMlb");	
		if (sMlb != undefined) {
			var arrMlb = sMlb.split("|");					
			for (var i = 0; i < arrMlb.length; i++) {
				if(ComTrim(arrMlb[i]) != '') {
					mlbComboObj.InsertItem(i+1, arrMlb[i], arrMlb[i]);
				}
			}
		}
		
		//4. Stowage	
		searchStowageList(sheetObj, formObj, sParam);
	}
	
	//Stowage Code List
	function searchStowageList(sheetObj, formObj, sParam) {	
		sheetObj.WaitImageVisible = false;
		
		sParam += "&f_cmd=" + SEARCH16;
		var stwgXml  = sheetObj.GetSearchXml("VOP_OPF_2019GS.do", sParam);
		var stwgStr  = ComGetEtcData(stwgXml, "stwgCdList");
		var stwgList = stwgStr.split("|");		
		
		var stParams   = new Array();	//Stowage 파라미터 목록
		var stFields   = new Array();	//OPR별 Stowage 목록
		var stFiledCt  = 0;
		var stDup      = false;
		var stCt       = 0;
		var colCt      = 0;
		var stcdCt     = 0;
		
		//OPR조건에 따른 OPR구성
		var curCgoOprs = new Array();
		var curCgoOprTxt = comboObjects[1].Text;
		if(curCgoOprTxt == "ALL") {
			for(var oprCt=0; oprCt<cgoOprList.length; oprCt++) {
				curCgoOprs[oprCt] = cgoOprList[oprCt];
			}
		} else {
			curCgoOprs[0] = curCgoOprTxt;
		}
		
		if(ComTrim(stwgStr) != "") {			
			for (var cgoOprCt=0; cgoOprCt<curCgoOprs.length; cgoOprCt++) {
				cgoOprVal = curCgoOprs[cgoOprCt];
				
				stFields[cgoOprCt] = new Array();
				stFiledCt = 0;
				
				for (; colCt < stwgList.length;) {
					var stwgCd = stwgList[colCt].split("+")[1];
					
					if(cgoOprVal == stwgList[colCt].split("+")[0]) {						
						//파라미터 생성
						stDup = false;
						for(var stCts=0; stCts<stParams.length; stCts++) {
							if(stwgCd == stParams[stCts]) stDup = true;
						}
						if(!stDup) stParams[stCt++] = stwgCd;
						
						//#step1[Stowage 구성] - OPR별 ST 구성
						stFields[cgoOprCt][stFiledCt++] = stwgCd;
						ComSetObjValue(eval("formObj.opr_stcd"+(++stcdCt)), cgoOprVal+"_"+stwgCd);
					} else {
						break;
					}
					
					colCt++;
				}
				
				//나머지 파라미터 초기화
				for(var restCt=stcdCt+1; restCt<=75; restCt++) {
					ComSetObjValue(eval("formObj.opr_stcd"+(restCt)), "");
				}
			}
		}
		
		//파라미터 셋팅				
		cgoOprCt = 0;
		ComSetObjValue(formObj.opr_st_ct, stParams.length);
		for(stCt=0; stCt<15; stCt++) {
			if(stCt<stParams.length) {	
				ComSetObjValue(eval("formObj.st_"+(stCt+1)), stParams[stCt]);
				//#step2[Stowage 구성] - 파라미터에 따른 리턴 필더 구성
				for(var cgoOprCt2=0; cgoOprCt2<stFields.length; cgoOprCt2++) {
					for(stFiledCt=0; stFiledCt<stFields[cgoOprCt2].length; stFiledCt++) {
						if(stParams[stCt] == stFields[cgoOprCt2][stFiledCt]) stFields[cgoOprCt2][stFiledCt] = stCt+1;
					}
				}
			} else {
				ComSetObjValue(eval("formObj.st_"+(stCt+1)), "");
			}
		}
		var tCt = 1;
		if(ComTrim(stwgStr) != "") {
			//파라미터 초기화
			for (var cgoOprCt=1; cgoOprCt<=5; cgoOprCt++) {
				for ( colCt=1; colCt<=15; colCt++) {
					ComSetObjValue(eval("formObj.opr"+cgoOprCt+"_st"+colCt), "0");
				}
			}
			//#step2[Stowage 구성] - 파라미터에 따른 리턴 필더 셋팅
			for (var cgoOprCt=1; cgoOprCt<=curCgoOprs.length; cgoOprCt++) {
				for ( colCt=1; stFields[cgoOprCt-1] != null && colCt <= stFields[cgoOprCt-1].length; colCt++) {		
					var fieldIdx = stFields[cgoOprCt-1][colCt-1];
					ComSetObjValue(eval("formObj.opr"+cgoOprCt+"_st"+fieldIdx), tCt++);	
				}
			}
			
		}
		
		sheetObj.WaitImageVisible = true;
	}

/* 개발자 작업  끝 */