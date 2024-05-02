/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0100.js
*@FileTitle : (KOR) DOD Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.09.12 
* 1.0 최초 생성 
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
     * @class ESD_EAS_0100 : ESD_EAS_0100 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0100() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    } 

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 
	//RD
    var rdObjects = new Array();
	var rdCnt = 0;
	
	//Action 정의
	var IBSEARCH_ATTL 			= 108;
	
	//업무전역변수
	var ROWMARK 				= "|";
	var FIELDMARK 				= "=";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0]; //sheet1
         var sheetObject2 = sheetObjects[1]; //sheet2
		 var rdObject = rdObjects[0];

         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_payer_cd":
						if(!formObject.payer_cd.readOnly) {
							ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
						}
						break;

					case "btn_retrieve":
						doActionIBSheet(sheetObject1, formObject, IBSEARCH, true);   //tab1
						break;

					case "btn_new":
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						//comboObjects[0].RemoveAll();
						formObject.cboEffdt.RemoveAll();
						formObject.cboAttention.RemoveAll();
						formObject.reset();
						object_disable();
						ComEnableObject(formObject.trf_ofc, true);
						
						ComBtnEnable("btn_retrieve");
						ComBtnDisable("btn_issue");
						ComBtnEnable("btn_payer_info");
						
						ComBtnDisable("btn_fax");
						ComBtnDisable("btn_email");
						ComBtnDisable("btn_preview");
						
						break;
						
					case "btn_issue":
						doActionIBSheet(sheetObject1, formObject, MULTI01, true);
						break;
						
					case "btn_payer_info":
						
						if (ComGetObjValue(formObject.payer_cd) == null || ComGetObjValue(formObject.payer_cd) == "") {
							ComShowCodeMessage("EAS80007");
							return;
						}
						
					
						 var ofc_cd = ComGetObjValue(formObject.session_ofc_cd);
						
						var paramVal = "?s_ofc_cd=" + ofc_cd
								+ "&s_cust_cd=" + ComGetObjValue(formObject.payer_cd)
								+ "&s_pod_cd=" 	+ ComGetObjValue(formObject.pod_cd)
								+ "&jspno=ESD_EAS_0100"
								+ "&attn=" 		+ ComGetObjValue(formObject.cntc_pnt_nm)
								+ "&telno=" 	+ ComGetObjValue(formObject.cntc_pnt_phn_no)
								+ "&faxno=" 	+ ComGetObjValue(formObject.cntc_pnt_fax_no)
								+ "&email=" 	+ ComGetObjValue(formObject.cntc_pnt_eml)
						        + "&cnt_cpnt_seq=" + ComGetObjValue(formObject.cust_cntc_pnt_seq);	

						var sUrl	= "ESD_EAS_0103.do" + paramVal;
						var sWidth	= "825";
						var sHeight	= "610";
			  			var sWinName = ComReplaceStr(sUrl, ".do", "");

			  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
						break;

					case "btn_print":
						//rdObject.PrintDialog();
						rdOpen(rdObject, formObject);
						break;								
						
					case "btn_fax":
						ComSetObjValue(formObject.send_flg, "F");
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
						break;
						
					case "btn_email":
						ComSetObjValue(formObject.send_flg, "E");
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
						break;
											
					case "btn_preview":
						var url = "ESD_EAS_0101.do";
						var returnValue = ComOpenWindowCenter(url, "ESD_EAS_0101", "950","735", true);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
	
    /**
     * Combo Object를 배열로 등록
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

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

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }
 	   
		initControl();
		//RD
		initRdConfig(rdObjects[0]);

		var formObj = document.form;
		ComAlertFocus(formObj.in_bl_no, "");
		ComBtnEnable("btn_retrieve");
		ComBtnDisable("btn_issue");
		ComBtnEnable("btn_payer_info");
		
		object_disable();
		
		//ComBtnDisable("btn_print");
		ComBtnDisable("btn_fax");
		ComBtnDisable("btn_email");
		ComBtnDisable("btn_preview");
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
	}

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
        	case "sheet1":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "Flag||CNTR No.|T/S|Lease Term|D.O.LOC|CURR|Billing AMT|Add AMT|Total AMT|Tax AMT|INV AMT|INV No";
					HeadTitle1 += "|pod_cd|del_cd|de_term_cd|cnee|nfty|bkg_no|bl_no|shpr|pol_cd|pol_conti_cd|pol_conti_nm|eff";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(false, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true,	"sel_chk",		false, "", dfNone, 0, true,	true);
					InitDataProperty(0, cnt++, dtData,	100, daCenter, true,"cntr_no",          false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,	40, daCenter, true,	"cntr_tpsz_cd",     false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,	75, daCenter, true,	"lstm_cd",          false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo,	75, daCenter, true,	"dod_loc_cd",       false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"bil_curr_cd",      false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	105, daRight, true,	"bil_amt",        	false, "", dfInteger, 3, false, true);
					InitDataProperty(0, cnt++, dtData,	105, daRight, true,	"add_amt",        	false, "", dfInteger, 3, true, true, 18);
					InitDataProperty(0, cnt++, dtData,	105, daRight, true,	"tot_bil_amt",     	false, "", dfInteger, 3, false, true);
					InitDataProperty(0, cnt++, dtData,	 95, daRight, true,	"tax_amt",        	false, "", dfInteger, 3, false, true);
					InitDataProperty(0, cnt++, dtData,	105, daRight, true,	"inv_amt",        	false, "", dfInteger, 3, false, true);
					InitDataProperty(0, cnt++, dtData,	 80, daCenter, true,"dod_inv_no",       false, "", dfNone, 0, false, true);

					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"pod_cd",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"del_cd",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"de_term_cd",		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cnee",				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"nfty",				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"bkg_no",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"bl_no",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"shpr",			    false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"pol_cd",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"pol_conti_nm",		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"pol_conti_cd",		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"drp_off_chg_trf_eff_dt", false, "", dfNone, 0, false, true);

					
					InitDataCombo(0, "dod_loc_cd", "KREIW|KRINC|KRPTK|KRKAN", "KREIW|KRINC|KRPTK|KRKAN");
					
					sheetObj.MinimumValue(0,"bil_amt") = "1";
					
				}
				break;
        	case "sheet2":
        		with (sheetObj) {
				// 높이 설정
                style.height = 0;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               	//전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

				var HeadTitle = "|T/S|CURR|POL|CNT|EFFDT|AMT";
								
				var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //InitHeadMode(true, true, false, true, false,false)
				InitHeadMode(false, true, true, true, false, false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
				InitDataProperty(0, cnt++, dtData,	40,  daCenter, true,	"cntr_tpsz_cd",        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,	60,  daCenter, true,	"curr_cd",             false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  75,  daCenter, true,	"pol_conti_cd",		   false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  75,  daCenter, true,	"pol_cnt_cd",		   false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,  75,  daCenter, true,	"eff_dt",		       false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData,	120, daRight,  true,	"drp_off_chg_trf_amt", false, "", dfInteger, 3, false, true);
		
				
			}
        		break;
        }
    }

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if( sheetObj.RowCount > 0 ){
			object_enable();
			setCellEditable(sheetObj);

			ComSetObjValue(formObj.bkg_no, sheetObj.CellValue(1, "bkg_no"));
			ComSetObjValue(formObj.bl_no, sheetObj.CellValue(1, "bl_no"));
			
			ComSetObjValue(formObj.pod_cd, sheetObj.CellValue(1, "pod_cd"));
			ComSetObjValue(formObj.del_cd, sheetObj.CellValue(1, "del_cd"));
			ComSetObjValue(formObj.bkg_de_term_cd, sheetObj.CellValue(1, "de_term_cd"));
			ComSetObjValue(formObj.cnee, sheetObj.CellValue(1, "cnee"));
			ComSetObjValue(formObj.nfty, sheetObj.CellValue(1, "nfty"));
			ComSetObjValue(formObj.shpr, sheetObj.CellValue(1, "shpr"));
			ComSetObjValue(formObj.pol_cd, sheetObj.CellValue(1, "pol_cd"));
			ComSetObjValue(formObj.pol_conti_cd, sheetObj.CellValue(1, "pol_conti_cd"));
			ComSetObjValue(formObj.pol_conti_nm, sheetObj.CellValue(1, "pol_conti_nm"));
			
			
			if(sheetObj.CellValue(1, "de_term_cd") == "D"){
				formObj.bkg_de_term_cd.style.color = "#ff0000";
				formObj.bkg_de_term_cd.style.fontWeight = "bold";
				ComShowCodeMessage("EAS80009");
				ComBtnDisable("btn_issue");
			}else{
				formObj.bkg_de_term_cd.style.color = "#606060";
				formObj.bkg_de_term_cd.style.fontWeight = "normal";
				ComBtnEnable("btn_issue");
			}
			ComEnableObject(formObj.trf_ofc, false);
			//ComBtnDisable("btn_retrieve");
			//ComBtnEnable("btn_issue");
		}else{
			object_disable();

			ComSetObjValue(formObj.bkg_no, "");
			ComSetObjValue(formObj.bl_no, "");
			
			ComSetObjValue(formObj.pod_cd, "");
			ComSetObjValue(formObj.del_cd, "");
			ComSetObjValue(formObj.bkg_de_term_cd, "");
			ComSetObjValue(formObj.cnee, "");
			ComSetObjValue(formObj.nfty, "");
			ComSetObjValue(formObj.shpr, "");
			
			//Payer 초기화
			setPayerInfoClear();
			ComShowCodeMessage("COM130402","Container Information");

		}
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		var vAmt = 0;
		if (sName == "sel_chk") {
			if(sheetObj.CellValue(Row, "sel_chk") == "1"){
//				if(sheetObj.CellValue(Row, "cntr_tpsz_cd").substring(1) == "2")
//					vAmt = 30000;
//				else
//					vAmt = 40000;
				setTariffAmt(Row);
					
				vAmt = parseFloat(sheetObj.CellValue(Row, "bil_amt"))+ parseFloat(sheetObj.CellValue(Row, "add_amt"));
				if(vAmt < 0) {
					vAmt = 0;
				}
				sheetObj.CellValue(Row, "tot_bil_amt") = vAmt
				sheetObj.CellValue(Row, "tax_amt") = vAmt*0.1;
				sheetObj.CellValue(Row, "inv_amt") = vAmt + (vAmt*0.1);						
			}else{
				sheetObj.CellValue(Row, "bil_amt") = 0;
				sheetObj.CellValue(Row, "add_amt") = 0;
				sheetObj.CellValue(Row, "tot_bil_amt") = 0;
				sheetObj.CellValue(Row, "tax_amt") = 0;
				sheetObj.CellValue(Row, "inv_amt") = 0;						
			}
			
			setTotalAmt(sheetObj, Col);
		} else if (sName == "add_amt") {
			vAmt = parseFloat(sheetObj.CellValue(Row, "bil_amt"))+ parseFloat(sheetObj.CellValue(Row, "add_amt"));
			if(vAmt < 0) {
				vAmt = 0;
				ComShowCodeMessage("COM12114","Invoice Amount");
			}
			sheetObj.CellValue(Row, "tot_bil_amt") = vAmt;
			sheetObj.CellValue(Row, "tax_amt") = vAmt*0.1;
			sheetObj.CellValue(Row, "inv_amt") = vAmt + (vAmt*0.1);
			
			setTotalAmt(sheetObj, 1);
		}
	}

	function setTotalAmt(sheetObj, Col){
		var formObj = document.form;
		var vTtlBilAmt = 0;
		var vTtlTaxAmt = 0;
		var vTtlInvAmt = 0;
		
		var sRow = sheetObj.FindCheckedRow(Col);
		var arrRow = sRow.split("|");
		for (idx=0; idx<arrRow.length-1; idx++)
		{
			vTtlBilAmt = vTtlBilAmt + parseFloat(sheetObj.CellValue(arrRow[idx], "tot_bil_amt"));
			vTtlTaxAmt = vTtlTaxAmt + parseFloat(sheetObj.CellValue(arrRow[idx], "tax_amt"));
			vTtlInvAmt = vTtlInvAmt + parseFloat(sheetObj.CellValue(arrRow[idx], "inv_amt"));
		}
		
		ComSetObjValue(formObj.ttl_bil_amt, ComAddCommaRun(vTtlBilAmt+""));
		ComSetObjValue(formObj.ttl_tax_amt, ComAddCommaRun(vTtlTaxAmt+""));
		ComSetObjValue(formObj.ttl_inv_amt, ComAddCommaRun(vTtlInvAmt+""));
	}

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, msgFlg) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					formObj.f_cmd.value = SEARCH;
		        	var sParam = FormQueryString(formObj);
		        	
		        	var ofc_cd = ComGetObjValue(formObj.session_ofc_cd);
		        	
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0100GS.do", sParam);
					var arrXml = sXml.split("|$$|");
					
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					sheetObjects[1].LoadSearchXml(arrXml[1]);
                     
					//3.조회후 결과처리
	 				var cboItems = ComGetEtcData(arrXml[0], "TRF_EFFDT");
	 				    comboObjects[0].RemoveAll();
	 		 	   
	 				if (cboItems != undefined && cboItems.length > 0) {
	 					addComboItemEff(comboObjects[0], cboItems.split(ROWMARK));
	 				}else{
	 					var conti = ComGetObjValue(formObj.pol_conti_nm);
	 					ComShowCodeMessage("EAS80011", conti ); // Tariff 없음. msgs['EAS80011'] = "Please check Tariff. There is no tariff information.({?msg1})";
	 					ComBtnDisable("btn_issue");
	 				}
	 	
				}	
				break;

			case MULTI01: //ISSUE
				if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					formObj.f_cmd.value = MULTI01;
					ComSetObjValue(formObj.inv_rmk, formObj.trf_ofc.value);
					var sParam =  ComGetSaveString(sheetObj, true, false);
					if( sParam == ""){ return;}
					var sXml = sheetObj.GetSaveXml("ESD_EAS_0100GS.do", FormQueryString(formObj) + "&" + sParam, true);
	    			
					var vDodInvNo = ComGetEtcData(sXml, "dodInvNo");
					ComSetObjValue(formObj.in_dod_inv_no, vDodInvNo);
					ComSetObjValue(formObj.dod_inv_no, vDodInvNo);
					setGridInvNo(sheetObj, vDodInvNo);
	
					
					ComBtnDisable("btn_retrieve");
					ComBtnDisable("btn_issue");
					ComBtnDisable("btn_payer_info");

					ComBtnEnable("btn_fax");
					ComBtnEnable("btn_email");
					ComBtnEnable("btn_preview");

					object_disable();
				}	
				break;
				
			case IBINSERT:        //저장
				//RD 호출
				var rdParm = "/rv dod_inv_no[" + ComGetObjValue(formObj.dod_inv_no) +"]";
				var path = "";
				var rd_nm = "";
				if (formObj.dod_inv_no.value.substr(0,2) == "KA" ) {
		    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1003.mrd";
		    		rd_nm = "ESD_EAS_1003.mrd";
		    	} else if (formObj.dod_inv_no.value.substr(0,2) == "IN" ){                                                                                  
		    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1001.mrd";  
		    		rd_nm = "ESD_EAS_1001.mrd";
		    	} else {
		    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1004.mrd";
		    		rd_nm = "ESD_EAS_1004.mrd";
		    	}
				
				ComSetObjValue(formObj.rd_parm, rdParm);
				ComSetObjValue(formObj.mrd, path);
				ComSetObjValue(formObj.rd_name, rd_nm);

				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("ESD_EAS_0101GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						ComShowCodeMessage("EAS90041");
					}
					else {
						ComShowCodeMessage("EAS90042");
					}
				}
			break;
				
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, msgFlg){
		var cboAttention = comboObjects[1];
		switch (sAction) {
			case IBSEARCH:
        		if( ComIsEmpty(formObj.in_bl_no) )
        		{
        			ComShowCodeMessage("COM130201", "B/L No");
        			ComAlertFocus(formObj.in_bl_no, "");
        			return false;
        		}
				break;

			case MULTI01:
				//TERM = "D" 이면 ISSUE 못함.
				if( ComGetObjValue(formObj.bkg_de_term_cd) == "D" ){
        			ComShowCodeMessage("EAS80009");
        			return false;
				}else{
	        		if(ComIsEmpty(formObj.payer_cd) )
	        		{
	        			ComShowCodeMessage("EAS80007");
	        			ComAlertFocus(formObj.payer_cd, "");
	        			return false;
					}else{
						
						//Attn, Tel, Fax, E-mail 이 없을 경우 Payer Info 처리 후.... 체크
						if(cboAttention.Text == "" ){
							ComShowCodeMessage("EAS80008");
							return false;
						}
						if(ComIsEmpty(formObj.cntc_pnt_phn_no)){

							ComShowCodeMessage("EAS80008");
							return false;
						}
						
						if(ComIsEmpty(formObj.cntc_pnt_fax_no) && ComIsEmpty(formObj.cntc_pnt_eml)){
							ComShowCodeMessage("EAS80008");
							return false;
						}
						
						
						if(cboAttention.GetIndexText(cboAttention.Index, 4) == "null"){
							ComShowCodeMessage("EAS80008");
							return false;
						}
						
						if( sheetObj.CheckedRows("sel_chk") < 1 ){
							ComShowCodeMessage("COM12189");
							return false;
						}
					}
				}
				
				if( ComGetObjValue(formObj.session_ofc_cd) == "INCKS" || ComGetObjValue(formObj.session_ofc_cd) == "KANKS" ){
        			ComShowCodeMessage("COM131602","Korea DOD Invoice");
        			return false;
				}
				break;
				
			case IBINSERT:
				with(formObj){
					//FAX 입력여부 확인
					if(formObj.send_flg.value == "F" && cntc_pnt_fax_no.value == "") {
						ComShowCodeMessage("EAS90043");
						cntc_pnt_fax_no.focus();
						return false;
					}
					//EMAIL 입력여부 확인
					if(formObj.send_flg.value =="E" && cntc_pnt_eml.value == "" ) {
						ComShowCodeMessage("EAS90043");
						cntc_pnt_eml.focus();
						return false;
					}
				}
				break;

		}
        return true;
    }
		
    /* initControl() */
    function initControl() {
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat("change", "frmObj_OnChange", form);
	    axon_event.addListener('keydown', 'frmObj_EnterKey', 'form');
    }

    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
     	}
    }    

    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
    	
		var formObj = document.form;
        var elementName = window.event.srcElement.getAttribute("name");
       // var sheetObj = sheetObjects[0];
        with (document.form) {
            switch (elementName) {
                case "payer_cd":
                	getPayerInfo();
                    break;
                case "cust_rgst_no":
					getPayerInfo();
                    break;                    
              
            }
        }
    }
	
    /**
     * Form Element의 EnterKey 이벤트
     */
    function frmObj_EnterKey() {
		if (13!=event.keyCode) return;
		var formObj = document.form;
        var elementName = window.event.srcElement.getAttribute("name");
        var sheetObj = sheetObjects[0];
		var sheetObj1 = sheetObjects[1];
        with (document.form) {
            switch (elementName) {
                case "in_bl_no":
					if(ComIsBtnEnable("btn_retrieve")){
						doActionIBSheet(sheetObj, formObj, IBSEARCH, true);	
					}
                    break;
                case "payer_cd":
					if(!formObj.payer_cd.readOnly){
						getPayerInfo();
					}				
                    break;
                case "cust_rgst_no":
					if(!formObj.cust_rgst_no.readOnly){
						getPayerInfo();
					}				
                    break;                    
            }
        }
    }
	
	function getPayerInfo(){
		var formObj = document.form;
		var sheetObj1 = sheetObjects[1];
		
		if(ComIsNull(formObj.payer_cd) && ComIsNull(formObj.cust_rgst_no)){
			setPayerInfoClear();	
		}else{
			if(!ComIsNull(formObj.payer_cd) && !ComIsNull(formObj.cust_rgst_no)) {
				if (formObj.cust_rgst_no.value != formObj.cust_rgst_no_old.value) { 
					ComSetObjValue(formObj.payer_cd, "");
				}
			}
 
			formObj.f_cmd.value = SEARCH02;
        	var sParam = FormQueryString(formObj);
			var sXml = sheetObj1.GetSearchXml("ESD_EAS_0100GS.do", sParam);
			var vCustCd = ComGetEtcData(sXml, "cust_cd");
			var vCustNM = ComGetEtcData(sXml, "cust_nm");
			var vCustRgstNo = ComGetEtcData(sXml, "cust_rgst_no");
			if(vCustCd == "null"){
				ComShowCodeMessage("COM12114", "Payer");
				setPayerInfoClear();
			}else{
				ComSetObjValue(formObj.payer_cd, vCustCd);
				ComSetObjValue(formObj.payer_nm, vCustNM);
				ComSetObjValue(formObj.cust_rgst_no, vCustRgstNo);
				
				ComSetObjValue(formObj.cust_rgst_no_old, vCustRgstNo);
				
				getAttn();
			}
		}
	}	
	
	function setPayerInfoClear(){
		var formObj = document.form;
	   	var cboAttention = comboObjects[1];
		
		ComSetObjValue(formObj.payer_cd, "");
		ComSetObjValue(formObj.payer_nm, "");
		ComSetObjValue(formObj.cust_rgst_no, "");
		ComSetObjValue(formObj.cust_rgst_no_old, "");
		cboAttention.RemoveAll();
		ComSetObjValue(formObj.cntc_pnt_phn_no, "");
		ComSetObjValue(formObj.cntc_pnt_fax_no, "");
		ComSetObjValue(formObj.cntc_pnt_eml, "");
	}

	function setGridInvNo(sheetObj, vDodInvNo) {
		for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
			if( sheetObj.CellValue(idx,"sel_chk") == "1" && sheetObj.CellValue(idx,"dod_inv_no") == ""){
				sheetObj.CellValue2(idx, "dod_inv_no") = vDodInvNo;
			}
			sheetObj.CellEditable(idx, "sel_chk") = false;
			sheetObj.CellEditable(idx, "dod_loc_cd") = false;
			sheetObj.CellEditable(idx, "bil_amt") = false;
			sheetObj.CellEditable(idx, "tax_amt") = false;
			sheetObj.CellEditable(idx, "inv_amt") = false;
		}
	}	
    
	function setCellEditable(sheetObj) {
		for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
			if( sheetObj.CellValue(idx,"dod_inv_no") != "" ){
				sheetObj.CellEditable(idx, "sel_chk") = false;
				sheetObj.CellEditable(idx, "dod_loc_cd") = false;
				sheetObj.CellEditable(idx, "bil_amt") = false;
				sheetObj.CellEditable(idx, "add_amt") = false;
				sheetObj.CellEditable(idx, "tax_amt") = false;
				sheetObj.CellEditable(idx, "inv_amt") = false;
			}
		}
	}	
	
	//입력 값 활성화 처리
	function object_enable(){
		var formObj = document.form;
		//payer
		ComEnableObject(formObj.payer_cd, true);
		ComEnableObject(formObj.btn_payer_cd, true);
		formObj.payer_cd.className	= "input1";
		
		//cust_rgst_no
		ComEnableObject(formObj.cust_rgst_no, true);
		formObj.cust_rgst_no.className	= "input1";
		
		formObj.cboAttention.Enable = true;	
		formObj.cboEffdt.Enable = true;	
	}
	//입력 값 비활성화 처리
	function object_disable(){
		var formObj = document.form;
		//payer
		ComEnableObject(formObj.payer_cd, false);
		ComEnableObject(formObj.btn_payer_cd, false);
		formObj.payer_cd.className 	= "input2";

		//cust_rgst_no
		ComEnableObject(formObj.cust_rgst_no, false);
		formObj.cust_rgst_no.className 	= "input2";
		
		formObj.cboAttention.Enable = false;
		formObj.cboEffdt.Enable = false;
	}

    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	var formObj = document.form;
    	var cboAttention = comboObjects[1];
       
		ComSetObjValue(formObj.payer_cd, aryPopupData[0][3]);
		ComSetObjValue(formObj.payer_nm, aryPopupData[0][4]);
		
		searchAttentionList();
		
		if (cboAttention.GetCount() > 0) {
    		//Payer 가 변경되면 자동으로 Attention 정보를 조회하며, 조회된 첫번째 항목을 자동으로 선택해 준다.
     		var inx = cboAttention.FindIndex('Y',4); 
    		
			if( inx == -1  ){
				cboAttention.Index = 0 ;
			}else{
				cboAttention.Code = inx ;
			}
    	}
		
		getPayerRgstNo();
    }
	function getPayerRgstNo(){
		var formObj = document.form;
		var sheetObj1 = sheetObjects[1];
		if(!ComIsNull(formObj.payer_cd) 
				&& ( ComIsNull(formObj.cust_rgst_no) || ( formObj.cust_rgst_no != formObj.cust_rgst_no_old ) )){
			formObj.f_cmd.value = SEARCH02;
        	var sParam = FormQueryString(formObj);
			var sXml = sheetObj1.GetSearchXml("ESD_EAS_0100GS.do", sParam);
			var vCustRgstNo = ComGetEtcData(sXml, "cust_rgst_no");
			ComSetObjValue(formObj.cust_rgst_no, vCustRgstNo);
			ComSetObjValue(formObj.cust_rgst_no_old, vCustRgstNo);
		}
	}
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getAttn() {
    	var formObj = document.form;
    	var cboAttention = comboObjects[1];
		
		searchAttentionList();
		
		if (cboAttention.GetCount() > 0) {
    		//Payer 가 변경되면 자동으로 Attention 정보를 조회하며, 조회된 첫번째 항목을 자동으로 선택해 준다.
     		var inx = cboAttention.FindIndex('Y',4); 
    		
			if( inx == -1  ){
				cboAttention.Index = 0 ;
			}else{
				cboAttention.Code = inx ;
			}
    	}
    }	
	
    /**
     * Attention 를 조회하는 함수
    */	
 	function searchAttentionList() {
 		var formObj 	= document.form;
 		var comboObj 	= comboObjects[1];
 		var sheetObj	= sheetObjects[0];
 		//Attention 정보를 조회하기 위한 필수 매개변수 설정
 		setPayerCd();

 		doActionIBCommon(sheetObj, formObj, IBSEARCH_ATTL, SEARCH01);
 	} 
	
    /**
     * Attention Combo를 조회하기 위한 Payer Code
     * @return
     */
    function setPayerCd() {
    	var formObj = document.form;
    	
    	var payer_cd	= ComGetObjValue(formObj.payer_cd);

    	var cust_cnt_cd	= "";
    	var cust_seq 	= "";
    	
    	//Service Provider
    	if(payer_cd.length == 6) {
    		cust_cnt_cd = "00";
    		cust_seq	= payer_cd;
    	}else if(payer_cd.length == 8){
    		cust_cnt_cd = payer_cd.substring(0,2);
    		cust_seq	= payer_cd.substring(2);
    	}else{
    		ComSetObjValue(formObj.payer_cd, "");
    		ComSetObjValue(formObj.cust_cnt_cd, "");
    		ComSetObjValue(formObj.cust_seq, "");
    		return;
    	}
    	
    	ComSetObjValue(formObj.cust_cnt_cd, cust_cnt_cd);
    	ComSetObjValue(formObj.cust_seq, cust_seq);
    }
     
 	//콤보관련 데이터를 조회하는 함수
 	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
 		var cboAttention 	= comboObjects[1];
 		
 	    sheetObj.ShowDebugMsg 		= false;
 		sheetObj.WaitImageVisible 	= false;
 		
 	    switch(sAction) {
 	    
 			//Attention List를 조회한다.
 	    	case IBSEARCH_ATTL:

 				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
 				ComSetObjValue(formObj.f_cmd, sComboAction);
 				

 				//2.조회조건으로 조회실행
 				//*********************************************************************************
 				ComOpenWait(true);
 				sheetObj.WaitImageVisible = false;
 				//*********************************************************************************
 				
 				var sXml = sheetObj.GetSearchXml("ESD_EAS_0100GS.do", FormQueryString(formObj));

 				//*********************************************************************************
 				ComOpenWait(false);
 				//*********************************************************************************

 				//3.조회후 결과처리
 				var cboItems = ComGetEtcData(sXml, "ATTENTION");

 				//3-1.Attention 에 기존 목록 삭제 후 조회된 데이터로 목록 재생성
 				cboAttention.RemoveAll();

 				if (cboItems != undefined && cboItems.length > 0) {
 					addComboItem(cboAttention, cboItems.split(ROWMARK));
 				}
 				break;
 	    }
 	    
 		sheetObj.WaitImageVisible = true;
 	} 
 	
	/**
	 * Attention Combo Change 이벤트 처리
	 * Attention 의 선택이 변경되면 변경되어진 Attention 의 Tel., Fax, E-mail 정보를 설정해준다. 
	 */
	function cboAttention_OnChange(cboObj, Index_Code, Text) {
		 setAttentionInform();
	}

	/**
	 * Attention 의 선택이 변경되면 변경되어진 Attention 의 Tel., Fax, E-mail 정보를 설정해준다. 
	 */	
   function setAttentionInform() {
		var formObj 		= document.form;
		var cboAttention 	= comboObjects[1];
		
		ComSetObjValue(formObj.cntc_pnt_nm, 	    cboAttention.GetText(cboAttention.Code,	0));
		ComSetObjValue(formObj.cntc_pnt_phn_no, 	cboAttention.GetText(cboAttention.Code, 1));
		ComSetObjValue(formObj.cntc_pnt_fax_no, 	cboAttention.GetText(cboAttention.Code, 2));
		ComSetObjValue(formObj.cntc_pnt_eml, 		cboAttention.GetText(cboAttention.Code, 3));
		
		//custKeys[0:CUST_CNT_CD, 1:CUST_CNTC_PNT_SEQ, 2:CUST_SEQ]
		var custKeys = cboAttention.Code.split("^");
		if (custKeys != undefined && custKeys.length > 1) {
			ComSetObjValue(formObj.cust_cntc_pnt_seq, custKeys[1]);
		}
		else {
			ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
		}
   }
	 
 /**
  * Attention 콤보필드에 데이터를 추가해준다.
  */	
    function addComboItem(comboObj, comboItems) {
	     	for (var i = 0 ; i < comboItems.length ; i++) {

	     		    var comboItem = comboItems[i].split(FIELDMARK);
	 			    comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3]+ "|" + comboItem[4], comboItem[5]);

	        }   		
	 	} 

    function addComboItemEff(comboObj, comboItems) {
    	var defaultCode = "";
     	for (var i = 0 ; i < comboItems.length ; i++) { 
     		  var to_day = ComGetNowInfo("ymd");      //결과 : 2008-11-10
     		  var eff_dt = comboItems[i].substring(0,4)+"-"+comboItems[i].substring(4,6)+"-"+comboItems[i].substring(6,8);
     		  
     		  var ins = parseFloat(ComGetDaysBetween(eff_dt, to_day));
     		  var j = 0 ; 
     		  if( ins >= 0 ){
        		    comboObj.InsertItem( j, eff_dt, comboItems[i]);
        		    if (j == 0){
        		    	defaultCode = comboItems[i] ;
        		     }
    		      j = j+1 ; 
     		  }
 	     }
     	comboObj.Code = defaultCode;
     }
	 
	/**
	 * PayerInfo 팝업화면에서 변경시 자동변경 처리됨
	 */
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
		var formObj 		= document.form;
		var cboAttention 	= comboObjects[1];
		
		ComSetObjValue(formObj.cntc_pnt_fax_no, fax_nos);
		ComSetObjValue(formObj.cntc_pnt_eml, 	email_nos);
		ComSetObjValue(formObj.cntc_pnt_nm, 	cntc_pnt_nm);
		ComSetObjValue(formObj.cust_cntc_pnt_seq, 	cntc_pnt_seq);
		
		searchAttentionList();

		var custKeyCode = ComGetObjValue(formObj.cust_cnt_cd)
						+ "^"
						+ ComGetObjValue(formObj.cust_cntc_pnt_seq)
						+ "^"
						+ ComParseInt(ComGetObjValue(formObj.cust_seq));

		//setting
		if (ComGetObjValue(formObj.payer_cd) == "") {
			comboObjects[1].Code = -1;
			ComSetObjValue(formObj.cntc_pnt_phn_no, 	"");
			ComSetObjValue(formObj.cntc_pnt_fax_no, 	"");
			ComSetObjValue(formObj.cntc_pnt_eml, 		"");
			ComSetObjValue(formObj.cust_cntc_pnt_seq, 	"");
		}
		else {
			//Attention Setting
			cboAttention.Code = custKeyCode;
			if(cboAttention.Code == ""){
	 			ComSetObjValue(formObj.cntc_pnt_phn_no, 	"");
	 			ComSetObjValue(formObj.faxcntc_pnt_fax_no, 	"");
	 			ComSetObjValue(formObj.cntc_pnt_eml, 		"");
	 			ComSetObjValue(formObj.cust_cntc_pnt_seq, 	"");
			}
		}
	}
 	
	/** 
	 * RD 초기설정값<br>
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
		
 	/** 
	 * Rd 오픈 <br>
	 */
	function rdOpen(rdObject, formObj){
		var Rdviewer = rdObject;	
		//review 창 오픈
		ComSetObjValue(formObj.com_mrdPath, ComGetObjValue(formObj.mrd));
		var rdParm = "/rv dod_inv_no[" + ComGetObjValue(formObj.in_dod_inv_no) +"]";
		ComSetObjValue(formObj.com_mrdArguments, rdParm);
		var feature = "resizable=yes,width=800,height=550";
		ComOpenRDPopup(feature);
	}
	
	/* Tarirr amount*/
	function setTariffAmt(Row){
		var formObj = document.form;
		var bil_ofc = ComGetObjValue(formObj.session_ofc_cd);
		//var bil_ofc = ComGetObjValue(formObj.trf_ofc);
		var trf_eff_dt = ComGetObjValue(formObj.cboEffdt);
		var trf_conti = ComGetObjValue(formObj.pol_conti_cd);
		var cntr_tpsz = sheetObjects[0].CellValue(Row,"cntr_tpsz_cd") ;
		var trf_amt =  0 ;

		var  sheetObj = sheetObjects[1];
		
		for( var idx = 1; idx <= sheetObj.LastRow; idx++ ){
			if( (sheetObj.CellValue(idx,"cntr_tpsz_cd") == cntr_tpsz) && (sheetObj.CellValue(idx,"eff_dt") == trf_eff_dt) ){
				trf_amt  =  sheetObj.CellValue(idx, "drp_off_chg_trf_amt");
			 }
		  }
		sheetObjects[0].CellValue2(Row,"bil_amt") = trf_amt ;   
		sheetObjects[0].CellValue2(Row,"drp_off_chg_trf_eff_dt")  = trf_eff_dt ;   
		
		if(trf_amt == 0 ){
			ComShowCodeMessage("EAS80011", cntr_tpsz );// tariff 등록 하라는 메세지처리
			sheetObjects[0].CellValue2(Row, "sel_chk") = 0;
			return false;
		}
	  }	
	
	/**
	 * efff Combo Change 이벤트 처리
	 */
	function cboEffdt_OnChange(cboObj, Index_Code, Text) {
	 	for (var idx= 1; idx< sheetObjects[0].RowCount + 1; idx++){
	 		if (sheetObjects[0].CellValue(idx,"sel_chk")  == 1){
	 		   sheet1_OnChange(sheetObjects[0], idx,  1, "");
	 		}

      	}
	}

	
	/* 개발자 작업  끝 */