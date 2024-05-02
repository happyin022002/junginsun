/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0421.js
*@FileTitle : Queue List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
* 2011.11.07 정선용 [CHM-201114286-01] DPCS- Queue List 기능 보완
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
 * 2011.12.08 금병주 [CHM-201114555-01] DPCS Correction 기능 보완 -2
 * 2011.12.22 금병주 [CHM-201115195-01] SI Automation Receiving Lsit 기능 & DPCS 기능 보완 요청
 * 2012.01.07 조정민 [CHM-201221961] Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.03.11 김진주 [CHM-201323200] DPCS Queue List의 Pending 사유 기재 요청
 * 2013.04.18 김진주 [CHM-201324039] DPCS Queue List 상 L.OFC/Sales 추가 요청
 * 2013.04.24 김진주 [CHM-201324285] DPCS Queue List상 S/I 조회 기간 연장 요청 
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
     * @class esm_bkg_0421  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0421() {
        this.processButtonClick = processButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
        this.sheet1_OnClick     = sheet1_OnClick;
        this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
        this.setComboObject     = setComboObject;
    }

    /* 개발자 작업  */
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    	sheetObjectsMap[sheet_obj.id] = sheet_obj; 
    }

    var arrWindow = new Array(null,null); 
    
    var rdObjects = new Array();
    var rdCnt = 0;
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetObjectsMap = new Array();
    var sheetCnt = 0;
    var rowsPerPage = 9999999;

    var prefix = "sheet1_";//IBSheet 구분자
    var popWinObj;
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
        initComboEditable(comboObj, comboId)
    }

    function initComboEditable(combo, comboId) {
        with (combo) {
            MultiSelect = false;//comboId=="region";
            UseEdit = false;
            DropHeight = 200;
        }
    }

    /*############################# combo onchage start ########################*/
    /**
     * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
     * 입력값을 upper로 변경하여 재등록 한다.
     * @param comboObj
     * @return
     */
    function p_eq_type_OnChange(comboObj) {
        combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
    }

    function combo_Change(comboObj, multiComboDataAddedFlag) {
        var formObject = document.form;
        // 사용자 입력값을 uppercase로 변경
        var comboText =  comboObj.Text.toUpperCase();
        // 이전에 등록되었으면 삭제
        if (multiComboDataAddedFlag) {
            comboObj.DeleteItem(0);
            multiComboDataAddedFlag = false;
        }
        // 선택 또는 입력한  값이 콤보에 있으면 리턴
        if (comboObj.FindIndex(comboText, 0) != -1) {
            return;
        }
        comboObj.InsertItem(0, comboText, comboText);
        multiComboDataAddedFlag = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수)
        comboObj.Text2 = comboText;  // 입력값이 선택되게 한다.
     }

    /*############################# combo onchage end ########################*/

    /*********************** EDTITABLE MULIT COMBO END********************/

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //MultiCombo초기화
        for (var k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        initControl();
        
        //initRdConfig(rdObjects[0]);
    }

    function sheet1_OnLoadFinish(sheetObj) {
    	setTimeout(function () { doActionIBSheet(sheetObj,document.form,SEARCH01); },100);
    }

    function initControl() {
        var formObject = document.form;
        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        ComBtnDisable("btn_Split");
    }

    /*********************** KEY EVENT START ********************/
    function bkg_keypress() {
        switch (event.srcElement.dataformat) {
            case "ymd":
                //number
                ComKeyOnlyNumber(event.srcElement, "-");
            break;
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
            break;
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
        }
    }

    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        //입력Validation 확인하기
        switch (event.srcElement.name) {
            case "dura_from_dt":
                ComClearSeparator(event.srcElement);
            break;
            case "dura_to_dt":
                ComClearSeparator(event.srcElement);
            break;
        }
    }

    /*********************** KEY EVENT END ********************/


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick  = processButtonClick;

    /*
     * 모든 조건 값들을 초기화 한다.
     * */
    function initAll(formObject){    
	    
		formObject.reset();
		formObject.elements["input" ].Index = 0;  //All
		formObject.elements["rate"  ].Index = 0;  //All
		formObject.elements["qa"    ].Index = 0;  //All
		formObject.elements["fax"   ].Index = 0;  //All
		formObject.elements["region"].Index = 0;  //ALL
		formObject.elements["sts"   ].Index = 4;  //All
		initTotal();
    }
    /*
     * 모든 조건 값들을 초기화 한다.
     * */
    function initTotal(){    
    	total_bkg      .innerHTML = "";
    	total_sr       .innerHTML = "";
    	total_input    .innerHTML = "";
    	total_rate     .innerHTML = "";
    	total_qa       .innerHTML = "";
    	total_fax      .innerHTML = "";
    	total_pending  .innerHTML = "";
    	total_working  .innerHTML = "";
    	total_canceled .innerHTML = "";
    	total_completed.innerHTML = "";
    	total_na       .innerHTML = "";
    	total_bdr      .innerHTML = "";
    	total_pct      .innerHTML = "";
    	total_urgent   .innerHTML = "";
    	total_vip      .innerHTML = "";
    	total_normal   .innerHTML = "";
    	total_rtn_cust .innerHTML = "";
    	total_rtn_fo   .innerHTML = "";
    	total_rtn      .innerHTML = "";
    	total_cutoff   .innerHTML = "";
    }
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        
        /*******************************************************/
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
        try {
        switch (srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;
            case "btn_New":
            	sheetObject1.RemoveAll();
            	sheetObject2.RemoveAll();
            	initAll(formObject);
            break;
            case "btn_DownExcel":
				doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
            break;
            case "btn_detail":
                showDetail(sheetObject1);
            break;
            case "btn_pic":
                if (0 >= sheetObject1.CheckedRows(prefix+"sel")) {
                    ComShowCodeMessage("COM12189");
                    return;
                }
                var bkgNos = srNos = srcCds = picIds = "";
				var arrRow = ComFindText(sheetObject1, prefix+"sel", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						//if ("Y" != sheetObject1.CellValue(arrRow[i], prefix+"pnd_flg") && "RT" != sheetObject1.CellValue(arrRow[i], prefix+"return_src")) {
		                //    ComShowCodeMessage("BKG08035");
						//	return;
						//}
						bkgNos += sheetObject1.CellValue(arrRow[i], prefix+"bkg_no"           )+",";
						srNos  += sheetObject1.CellValue(arrRow[i], prefix+"max_sr_no"        )+",";
						srcCds += sheetObject1.CellValue(arrRow[i], prefix+"src_cd"           )+",";
						picIds += sheetObject1.CellValue(arrRow[i], prefix+"sr_wrk_sts_usr_id")+",";
					}
					bkgNos = bkgNos.substring(0,bkgNos.length-1);
					srNos  = srNos .substring(0,srNos.length-1);
					srcCds = srcCds.substring(0,srcCds.length-1);
					picIds = picIds.substring(0,picIds.length-1);
				}
                var param = "?bkg_no="+bkgNos
                          + "&sr_no=" +srNos
                          + "&src_cd="+srcCds
                          + "&pic_id="+picIds;
                ComOpenWindowCenter2("/hanjin/ESM_BKG_1004.do"+param, "QueueDetailReturn", 400,310,false,"scrollbars=no,resizable=yes");
            break;
			case "btn_stsc":
				doActionIBSheet(sheetObject1,formObject,MODIFY01);
				break;	
			case "btn_corr":
				var iCheckRow = sheetObject1.FindCheckedRow(prefix+"sel");
					iCheckRow = iCheckRow.substring(0,iCheckRow.length-1);
					
					if (0 >= sheetObject1.CheckedRows(prefix+"sel") || 2<= sheetObject1.CheckedRows(prefix+"sel")){
	                    ComShowCodeMessage("BKG08040");
	                    return;
	                }
	                if(sheetObject1.CellValue(iCheckRow,prefix+"sr_amd_tp_cd") != "R"){
	                	ComShowCodeMessage("BKG08206");
	                	return;
	                }
//	                if("" != sheetObject1.CellValue(iCheckRow,prefix+"pic_cng_id")){
//	                	return;
//	                }
	                var bkgNos = srNos = srcCds = picIds = srKnd = srAmdSeq ="";
					var arrRow = ComFindText(sheetObject1, prefix+"sel", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							bkgNos += sheetObject1.CellValue(arrRow[i], prefix+"bkg_no"           )+",";
							srNos  += sheetObject1.CellValue(arrRow[i], prefix+"max_sr_no"        )+",";
							srcCds += sheetObject1.CellValue(arrRow[i], prefix+"src_cd"           )+",";
							picIds += sheetObject1.CellValue(arrRow[i], prefix+"sr_wrk_sts_usr_id")+",";
						}
						bkgNos = bkgNos.substring(0,bkgNos.length-1);
						srNos  = srNos .substring(0,srNos.length-1);
						srcCds = srcCds.substring(0,srcCds.length-1);
						picIds = picIds.substring(0,picIds.length-1);
					}
					//2011.12.08 rgn_ofc_cd 추가 kbj
					var rgnOfcCd = sheetObject1.CellValue(iCheckRow,prefix+"rgn_ofc_cd");
	                var param = "?bkg_no="+bkgNos
	                          + "&sr_no=" +srNos
	                          + "&src_cd="+srcCds
	                          + "&pic_id="+picIds
	                          + "&rgn_ofc_cd="+rgnOfcCd;               
	                ComOpenWindowCenter2("/hanjin/ESM_BKG_1140.do"+param, "QueueDetailReturn", 600, 410, false, "scrollbars=no,resizable=yes");
	            break;				
			case "btn_Delete":	
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
				break;
			case "btn_FPending":
				doActionIBSheet(sheetObject1,formObject,MODIFY02);	
				break;
            case "btn_dura_date":
                (new ComCalendarFromTo()).select(formObject.dura_from_dt, formObject.dura_to_dt,'yyyy-MM-dd');
            break;
            case "chk_key":
            	if (ComGetObjValue(formObject.chk_key) == "DT") {
            		formObject.dura_from_dt.value = formObject.tmp_dura_from_dt.value;
            		formObject.dura_to_dt.value = formObject.tmp_dura_to_dt.value
            		formObject.tmp_dura_from_dt.value = "";
            		formObject.tmp_dura_to_dt.value = "";
            		formObject.dura_from_dt.className = "input1";
            		formObject.dura_to_dt.className = "input1";
            		formObject.btn_dura_date.style.display = "inline";
            	} else {
            		formObject.tmp_dura_from_dt.value = formObject.dura_from_dt.value;
            		formObject.tmp_dura_to_dt.value = formObject.dura_to_dt.value
            		formObject.dura_from_dt.value = "";
            		formObject.dura_to_dt.value = "";
            		formObject.dura_from_dt.className = "input2";
            		formObject.dura_to_dt.className = "input2";
            		formObject.btn_dura_date.style.display = "none";
            	}
            	if (ComGetObjValue(formObject.chk_key) == "VVD") {
            		formObject.vvd_cd.className = "input1";
//            		formObject.pol_cd.className = "input1";
            		formObject.vvd_cd.setAttribute("required","",true);
//            		formObject.pol_cd.setAttribute("required","",true);
            	} else {
            		formObject.vvd_cd.className = "input";
//            		formObject.pol_cd.className = "input";
            		formObject.vvd_cd.removeAttribute("required",true);
//            		formObject.pol_cd.removeAttribute("required",true);
            	}
            	if (ComGetObjValue(formObject.chk_key) == "BKG") {
            		formObject.bkg_no.className = "input1";
            		formObject.bkg_no.setAttribute("required","",true);
            	} else {
            		formObject.bkg_no.className = "input";
            		formObject.bkg_no.removeAttribute("required",true);
            	}
            	break;
            case "btn_SRCH_SET":
    			doActionIBSheet(sheetObjects[0],document.form,"btn_SRCH_SET","","");
    			break;
            case "btn_Split":
            	callSplitClick(sheetObjects[0]);
    			break;	
            case "split_only_flg":
            	/*sheetObjects[0].RemoveAll();
            	if (ComGetObjValue(formObject.split_only_flg) == "Y"){
            		ComBtnEnable("btn_Split");
            	}else{
            		ComBtnDisable("btn_Split");
            	}	
            	*/
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    			break;
    		case "btn_multi_rtn_ofc":
    			rtnOfcListPopUp();
    			break;
    		case "pRtnofc_list_add":
    			sheetObjectsMap["rtnOfcListSheet"].DataInsert(-1);
    			break;	

    		case "pRtnofc_list_del":
    			if (sheetObjectsMap["rtnOfcListSheet"].CheckedRows("slct_flg") != 0) {
    				var checkList = sheetObjectsMap["rtnOfcListSheet"].FindCheckedRow("slct_flg");
    				var arrRow = checkList.split("|");
    				for (idx=arrRow.length-2; idx>=0; idx--){ 	
    					sheetObjectsMap["rtnOfcListSheet"].RowDelete(arrRow[idx], false);
    				}
    			}
    			break;

    		case "pRtnofc_list_ok":
    			var pOfcList = "";
    			var sRow = sheetObjectsMap["rtnOfcListSheet"].FindCheckedRow("slct_flg");	
    			var arrRow = sRow.split("|");	
    			for( var i = 0; i < arrRow.length-1; i++ ) {	
    				pOfcList = pOfcList + ComReplaceStr(sheetObjectsMap["rtnOfcListSheet"].CellValue(arrRow[i], "m_p_ofc_cd"), " ","")+",";
    			}
    			pOfcList = pOfcList.substring(0, pOfcList.length-1);
    			formObject.return_to.value = pOfcList;
    			
    			document.all.divRtnOfcList.style.display = "none";
    			document.all.divRtnOfcList.style.visibility = 'hidden';
    			break;			
//            case "btn_bkg":
//                if (sheetObject1.RowCount < 1) {
//                    ComShowCodeMessage("BKG00495");
//                    return;
//                }
//                var idx = sheetObject1.GetSelectionRows();
//                var src_cd = sheetObject1.CellValue(idx, prefix+"src_cd") ;
//                var xter_sndr_id = sheetObject1.CellValue(idx, prefix+"xter_sndr_id") ;
//                var bkg_no = sheetObject1.CellValue(idx, prefix+"bkg_no") ;
//                var xter_rqst_no = sheetObject1.CellValue(idx, prefix+"xter_rqst_no") ;
//                var xter_rqst_seq = sheetObject1.CellValue(idx, prefix+"xter_rqst_seq") ;
//                var xter_sndr_id = sheetObject1.CellValue(idx, prefix+"xter_sndr_id") ;
//                var fax_log_ref_no = sheetObject1.CellValue(idx, prefix+"fax_log_ref_no") ;
//                var sr_knd_cd = sheetObject1.CellValue(idx, prefix+"sr_knd_cd") ;
//                var xter_sndr_id = sheetObject1.CellValue(idx, prefix+"xter_sndr_id") ;
//                
//				if (src_cd == "E" || src_cd  == "S" ||
//						(src_cd  == "M" &&  xter_sndr_id == "EML"   ) ||//2011.08.16 jsy||
//						(src_cd  == "U" &&  xter_sndr_id == "ULD"   )
//				   ) {
//						
//					var param = "?bkg_no=" + encodeURIComponent(bkg_no) + "&pgmNo=ESM_BKG_0229";
//					param += "&rqst_no=" + encodeURIComponent(xter_rqst_no);
//					param += "&rqst_seq=" + encodeURIComponent(xter_rqst_seq);
//					param += "&sender_id=" + encodeURIComponent(xter_sndr_id);
//					param += "&fax_log_ref_no=" + encodeURIComponent(fax_log_ref_no);
//					param += "&sr_knd_cd=" + encodeURIComponent(sr_knd_cd);
//					param += "&xter_rqst_via_cd="+ encodeURIComponent(xter_sndr_id);
//					
//					    var _text = "";
//					    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//					    for( var i=0; i < 5; i++ ) _text += possible.charAt(Math.floor(Math.random() * possible.length));
//							
//					    ComOpenWindowCenter("/hanjin/ESM_BKG_0229.do" + param, "PopupEsmBkgMain"+_text, 1025, 720, false, "yes");
////					}
//				} else {
//					
//					var param = "?bkg_no=" +  bkg_no + "&pgmNo=ESM_BKG_0079";
//					var _text = "";
//					var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//					for( var i=0; i < 5; i++ ) _text += possible.charAt(Math.floor(Math.random() * possible.length));
//					ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkgMain"+_text, 1025, 720, false, "yes");
//				}
//				
//				
//
//            break;    			
    			
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
	* RTN OFC Multi Popup
	*/	
	function rtnOfcListPopUp() {
		var formObj = document.form;
		
  	  	if (document.all.divRtnOfcList.style.display == "none") {
  			document.all.divRtnOfcList.style.display = "block";
  			document.all.divRtnOfcList.style.visibility = 'visible';
  			
  			if ( sheetObjectsMap["rtnOfcListSheet"].RowCount < 1 ) {
  				sheetObjectsMap["rtnOfcListSheet"].DataInsert(-1);
      			//sheetObjects[0].CellValue2(1, "p_rhq_bkg_ofc_cd") = formObj.p_rhq_bkg_ofc_cd.value;
  			}
  	  	} else {
  			document.all.divRtnOfcList.style.display = "none";
  			document.all.divRtnOfcList.style.visibility = 'hidden';
  	  	}
  	}	    
	
    function setSr_wrk_sts_usr_id(p_usr_id) {
		var arrRow = ComFindText(sheetObjects[0], prefix+"sel", 1);
		for (var i=0; i<arrRow.length; i++) {
			sheetObjects[0].CellValue(arrRow[i], prefix+"sr_wrk_sts_usr_id") = p_usr_id;
			sheetObjects[0].CellValue(arrRow[i], prefix+"pic_id") = p_usr_id;
		}
    }

    function setSr_wrk_sts_cd(rowIdx, sr_wrk_sts_cd) {
    	sheetObjects[0].CellValue(rowIdx, prefix+"sr_wrk_sts_cd") = sr_wrk_sts_cd;
    	setTotalStsCount();
    }

    function setTotalStsCount() {
    	var pCnt = wCnt = xCnt = yCnt = tCnt = fCnt = 0;
    	pCnt = ComFindText(sheetObjects[0], prefix+"sr_wrk_sts_cd", "P").length;
    	fCnt = ComFindText(sheetObjects[0], prefix+"sr_wrk_sts_cd", "F").length;
    	wCnt = ComFindText(sheetObjects[0], prefix+"sr_wrk_sts_cd", "W").length;
    	xCnt = ComFindText(sheetObjects[0], prefix+"sr_wrk_sts_cd", "X").length;
    	yCnt = ComFindText(sheetObjects[0], prefix+"sr_wrk_sts_cd", "Y").length;
    	total_pending  .innerHTML = ComAddComma(pCnt);
        total_working  .innerHTML = ComAddComma(wCnt);
        total_canceled .innerHTML = ComAddComma(xCnt);
        total_completed.innerHTML = ComAddComma(yCnt);
        total_na       .innerHTML = ComAddComma(sheetObjects[0].RowCount-(pCnt+wCnt+xCnt+yCnt+tCnt));
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH:      //조회
            
                if (!validateForm(sheetObj,formObj,sAction)) return;
                formObj.vvd_cd.focus();//duration date 의 포맷을 위함
                formObj.f_cmd.value = SEARCH;
                formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
                formObj.rows_per_page.value = rowsPerPage;
                sheetObj.RemoveAll();
                sheetObj.Redraw = false;
                sheetObj.WaitImageVisible = false;
                initTotal(); // Total 초기화
            	ComOpenWait(true);  //대기이미지 표시
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0421GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
                sheetObj.LoadSearchXml(sXml);
                sheetObjects[1].LoadSearchXml(sXml);
                
                if (ComGetObjValue(formObj.sts) == "X"){
                	ComBtnDisable("btn_pic");
                	ComBtnDisable("btn_stsc");
                	ComBtnDisable("btn_Delete");
                }
                
                //sheetObj.WaitImageVisible = false;
                sheetObj.Redraw = true;
                if (!ComGetEtcData(sXml, "total_bkg")) {
                	ComOpenWait(false); //대기이미지 숨김
                	break;
                }
                total_bkg      .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_bkg"      ));
                total_sr       .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_cnt"      ));
                total_input    .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_input"    ));
                total_rate     .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_rate"     ));
                total_qa       .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_qa"       ));
                total_fax      .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_fax"      ));
                total_pending  .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_pending"  ));
                total_working  .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_working"  ));
                total_canceled .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_canceled" ));
                total_completed.innerHTML = ComAddComma(ComGetEtcData(sXml, "total_completed"));
                total_na       .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_na"       ));
                total_bdr      .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_bdr"      ));
                total_pct      .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_pct"      ));
                total_urgent   .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_urgent"   ));
                total_vip      .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_vip"      ));
                total_normal   .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_normal"   ));
                total_rtn      .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_rtn"   ));
                total_cutoff   .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_cutoff"   ));
                total_rtn_cust .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_rtn_cust" ));
                total_rtn_fo   .innerHTML = ComAddComma(ComGetEtcData(sXml, "total_rtn_fo"   ));
                
                pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
                ComOpenWait(false); //대기이미지 숨김
                sheetObjects[0].SelectCell(0,0);
                
            break;
            case IBSEARCHAPPEND:  // 페이징 조회
                formObj.f_cmd.value = SEARCH;
                formObj.curr_page.value = PageNo;
                sheetObj.DoSearch4Post("ESM_BKG_0421GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), "iPage=" + PageNo, true);
            break;
            case SEARCH01:      //조회
                formObj.f_cmd.value = SEARCH01;
            	/*WaitImageVisible = false;
            	ComOpenWait(true);  //대기이미지 표시
            	 */     
            	sheetObj.Redraw = false;
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0421GS.do", FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                /*
                if ("F" !=ComGetEtcData(arrXml[0], "grp_cd")) {
                	ComSetDisplay("div_Fpending",false);
                }else{
                	ComSetDisplay("div_Fpending",true);
                }
                */
                ComXml2ComboItem(arrXml[0], formObj.elements["input"], "val", "name");
                formObj.elements["input"].Index = 0;  //All
                ComXml2ComboItem(arrXml[0], formObj.elements["rate"], "val", "name");
                formObj.elements["rate"].Index = 0;  //All
                ComXml2ComboItem(arrXml[0], formObj.elements["qa"], "val", "name");
                formObj.elements["qa"].Index = 0;  //All
                ComXml2ComboItem(arrXml[0], formObj.elements["fax"], "val", "name");
                formObj.elements["fax"].Index = 0;  //All
                if (arrXml.length > 1) 
                	ComXml2ComboItem(arrXml[1], formObj.elements["region"], "val", "val|name");
                formObj.elements["region"].Index = 0;  //ALL
                if (arrXml.length > 2) 
                	ComXml2ComboItem(arrXml[2], formObj.elements["sts"], "val", "val|name");
                ComSetObjValue(formObj.elements["sts"],"A");
                		
                if (arrXml.length > 3) 
                	ComXml2ComboItem(arrXml[3], formObj.elements["src_cd"], "val", "val|name");
                formObj.elements["src_cd"].Index = 0;  //All
                if (arrXml.length > 4) 
                	ComXml2ComboItem(arrXml[4], formObj.elements["sr_amd_tp_cd"], "val", "name");
                formObj.elements["sr_amd_tp_cd"].Index = 0; 
                if (arrXml.length > 5) 
                	ComXml2ComboItem(arrXml[5], formObj.elements["slan_cd"], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
                formObj.slan_cd.InsertItem(0,"All","All");
                formObj.slan_cd.Index =0 ;
                if (arrXml.length > 6) 
                	ComXml2ComboItem(arrXml[6], formObj.elements["bkg_cust_tp_cd"], "val", "name");
                formObj.elements["bkg_cust_tp_cd"].Index =0 ;
                
                if ("Y"!=ComGetEtcData(arrXml[0], "isPicBtn")) {
                	ComBtnDisable("btn_pic");
				}
                if ("U" ==ComGetEtcData(arrXml[0], "grp_cd") ) {
                	ComBtnEnable("btn_stsc");
                	ComBtnEnable("btn_Delete");
				}else{
					ComBtnDisable("btn_stsc");
					ComBtnDisable("btn_Delete");
				}
                ComSetObjValue(formObj.grp_cd,ComGetEtcData(arrXml[0], "grp_cd"));
                
                sheetObj.Redraw = true;
                //ComOpenWait(false); //대기이미지 숨김
                
            break;
            case MODIFY01:        //저장
	            if (0 >= sheetObj.CheckedRows(prefix+"sel")) {
	                ComShowCodeMessage("COM12189");
	                return;
	            }
	            if (ComShowCodeConfirm("BKG95006") == false) {
					return;
				}
            
            	formObj.f_cmd.value = MODIFY01;
	            var SaveStr = sheetObj.GetSaveString(false); 
	            WaitImageVisible = false;
	            ComOpenWait(true);  //대기이미지 표시
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0421GS.do?f_cmd="+MODIFY01, SaveStr);
				sheetObj.LoadSaveXml(sXml); 
				if (sheetObj.EtcData("TRANS_RESULT_KEY") =="S"){
			 		ComShowCodeMessage('COM130102','STS Change');
			 		
				}else{
					ComShowCodeMessage('COM130103','STS Change');
				}
				ComOpenWait(false); //대기이미지 숨김
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
            case IBDELETE: // 삭제
	            if (0 >= sheetObj.CheckedRows(prefix+"sel")) {
	                ComShowCodeMessage("COM12189");
	                return;
	            }
	            if (ComShowCodeConfirm("BKG00535") == false) {
					return;
				}
	           
	            formObj.f_cmd.value = REMOVELIST;
	            var SaveStr = sheetObj.GetSaveString(false); 
	            WaitImageVisible = false;
	            ComOpenWait(true);  //대기이미지 표시
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0421GS.do?f_cmd="+REMOVELIST, SaveStr);
				
				sheetObj.LoadSaveXml(sXml); 
				if (sheetObj.EtcData("TRANS_RESULT_KEY") =="S"){
			 		ComShowCodeMessage('BKG06010');
				}else{
					ComShowCodeMessage('COM130103','Delete');
					ComOpenWait(false); //대기이미지 숨김
					return;
				}
				ComOpenWait(false); //대기이미지 숨김
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
            case MODIFY02:        //FRONT PINDING
	            if (0 >= sheetObj.CheckedRows(prefix+"sel")) {
	                ComShowCodeMessage("COM12189");
	                return;
	            }
	            formObj.f_cmd.value = MODIFY02;
	            var SaveStr = sheetObj.GetSaveString(false); 
	            WaitImageVisible = false;
	            ComOpenWait(true);  //대기이미지 표시
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0421GS.do?f_cmd="+MODIFY02, SaveStr);
				sheetObj.LoadSaveXml(sXml); 
				if (sheetObj.EtcData("TRANS_RESULT_KEY") =="S"){
			 		ComShowCodeMessage('COM130102','Front Pending');
				}else{
					ComShowCodeMessage('COM130103','Front Pending');
				}
				ComOpenWait(false); //대기이미지 숨김
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				
            	break;
			break;
			case IBDOWNEXCEL:      // 엑셀다운
				sheetObj.SpeedDown2Excel(-1);
//				sheetObj.Down2Excel(-1);
				break;
			case "btn_SRCH_SET":      //조회조건 설정
				var param = "";
		 		ComOpenPopup("ESM_BKG_0446.do" + param, 800, 330, "PopupEsmBkg446", "1,0,1,1,1", true);
				break;	
			break;
        }
    }

    /**
     * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
     */
    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
    }

    /*
     *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
     * 초기값은 쉬트 헤더 개수
     */
    var pagedMaxCnt=1;
    /**
     * 조회후  이벤트 처리 >>> 폰트 칼라변경
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with (sheetObj) {
            var blueColor = RgbColor(0, 0, 255);
            var redColor  = RgbColor(255, 0, 0);
            var purpleColor  = RgbColor(200,0,200);
            sheetObj.SheetFontName = "Tahoma";
            for (var i = pagedMaxCnt; i <= LastRow; i++) {
            	CellImage(i,prefix+"message_yn") = ComIsEmpty(CellValue(i, prefix+"message"           )) ? 1 : 0;
                
                if (CellValue(i, prefix+"src") == "FAX"){
                	CellImage(i,prefix+"read"      ) = ComIsEmpty(CellValue(i, prefix+"img_file_real_path")) ? 1 : 0;
                }else 	if ( CellValue(i, prefix+"src") == "EML" || CellValue(i, prefix+"src") == "ULD" ){
                	//if 구문 추가 2011.12.22 kbj
                   	if(CellValue(i, prefix+"src_cd")  == 'M' && CellValue(i, prefix+"xter_sndr_id") == 'EML'  ){
                   		CellImage(i,prefix+"read"      ) = 3 ;
                   		//si receving list 에서 fax를 email로 보낼경우
                   		if(!ComIsEmpty(CellValue(i, prefix+"fax_log_ref_no")) ) {
                   			CellImage(i,prefix+"si_txt"      ) = 4 ;
                   		}
                	}else if(CellValue(i, prefix+"src_cd")  == 'U' && CellValue(i, prefix+"xter_sndr_id") == 'ULD'  ){
                   		CellImage(i,prefix+"read"      ) = 3 ; //note
                	}else{ //2 attach
                		CellImage(i,prefix+"read"      ) = 2 ;//ComIsEmpty(CellValue(i, prefix+"eml_subj_ctnt")) ? 1 : 2;
                    	DataLinkMouse(prefix + "atch_file_knt") = true;
                    	// sitxt 이미지용 email,homepage 에서 업로드 된 경우 
//                    	alert(CellValue(i, prefix+"xter_sndr_id")+':'+CellValue(i, prefix+"fax_log_ref_no"));
                    	if( (CellValue(i, prefix+"src_cd")  == 'M'||CellValue(i, prefix+"src_cd")  == 'U') 
                    			&& ComIsEmpty(CellValue(i, prefix+"xter_sndr_id")) 
                    			&& !ComIsEmpty(CellValue(i, prefix+"fax_log_ref_no")) ) {
                    		CellImage(i,prefix+"si_txt"      ) = 4 ;
                    	}
                	}
                }else 	if (CellValue(i, prefix+"src") == "EDI" || CellValue(i, prefix+"src") == "SEA"){
                	CellImage(i,prefix+"read"      ) = 3 ;
                }
                
                if ( CellValue(i, prefix+"src_cd")  == 'M'||CellValue(i, prefix+"src_cd")  == 'U') {
                	if(!ComIsEmpty(CellValue(i, prefix+"fax_log_ref_no")) ) {
               			CellImage(i,prefix+"si_txt"      ) = 4 ;
               		}
                }
                if (isBkgLink(i)) {
	                CellFontColor    (i,prefix+"bkg_no") = blueColor;
	                CellFontUnderline(i,prefix+"bkg_no") = true;
	                if (isTooltip(i)) {
	                	CellFontUnderline(i,prefix+"sr_wrk_sts_cd") = true;
	                }
                }
                if ("Y"==CellValue(i,prefix+ "rc_inp_flg")) {
                    RowFontColor(i) = redColor;
                }
                if ("D"==CellValue(i,prefix+ "sr_wrk_sts_cd")) {
                	CellFont("FontStrikethru",i,prefix+"bkg_no") = true;
                	CellFontColor    (i,prefix+"bkg_no") =  RgbColor(0, 0, 0);
                	CellEditable(i,prefix+"sel") = false;
                }
                CellFontColor    (i,prefix+"bkg_upld_sts_cd") = purpleColor;
                if("R"==CellValue(i,prefix+ "sr_amd_tp_cd") && "" == CellValue(i,prefix+"pic_cng_id")){
                	CellFont("FontItalic", i, 1, i, 50) = true;
            		CellFont("FontBold", i, 1, i, 50) = true;
        			CellFont("FontColor", i, 1, i, 50) = RgbColor(0, 0, 255);;
                }
            }
            comBkgIndicateLink(sheetObj,prefix+"eml_subj_ctnt");
        }//end width
        pagedMaxCnt = sheetObj.LastRow;
    }

	//STS 컬럼에 UserId 보여주기
    function sheet1_OnMouseMove(sheetObject, Button, Shift, X, Y) {
		var m_row = sheetObject.MouseRow;
		var m_colNm = sheetObject.ColSaveName(sheetObject.MouseCol);
		if (0<m_row) {
			with (sheetObject) {
				if (m_colNm==prefix+"sr_wrk_sts_cd") {
					if (isTooltip(m_row)) {
						MouseToolTipText = CellValue(m_row, prefix+"sr_wrk_sts_usr_id") + " " +CellValue(m_row, prefix+"sr_wrk_sts_usr_nm");					
					} else {
						
						if (CellValue(m_row, prefix+"sr_wrk_sts_cd") == "P" || CellValue(m_row, prefix+"sr_wrk_sts_cd") == "F"){
							
							MouseToolTipText = CellValue(m_row, prefix+"sr_wrk_sts_usr_id") + " " +CellValue(m_row, prefix+"sr_wrk_sts_usr_nm");
						}else{
							
							MouseToolTipText = "";
						}
					}
				}else if (m_colNm==prefix+"rtn_to_usr_eml") {
					MouseToolTipText = CellValue(m_row, prefix+"rtn_to_usr_remark");	
				}
			}
		}
	}

    /*
     * sheet1 OnChange 함수
     */
    function sheet1_OnChange(sheetObj,Row, Col, Value) {
        /*if (prefix+"split_sts_cd" == sheetObj.ColSaveName(Col)) {
            if (sheetObj.CellValue(rowIdx, prefix+"split_sts_cd") == "S"){
            	ComBtnEnable("btn_Split");
            }
        }*/
    }

    /*
     * 그리드 에서 여러 행에 대한 체크박스를 라디오버튼 처리
     */
    function SheetRowRadioCheck(sheetObj,Row,Col,Value) {
        sheetObj.CheckAll2(Col)=0;
        sheetObj.CellValue2(Row,Col)=Value;
    }

    /*
     *  Search Option or Item Option Modify
     */
    function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
        if (colIdx == sheetObj.SaveNameCol(prefix + "sel")) {
            //sheetObj.CellValue2(rowIdx, prefix+"sel") = sheetObj.CellValue(rowIdx, prefix+"sel") ? 0 : 1;
        } else if (colIdx == sheetObj.SaveNameCol(prefix + "read")
        			&& (sheetObj.CellValue(rowIdx, prefix+"src") == "FAX")) {
        	if (sheetObj.CellValue(rowIdx, prefix+"src") != "FAX") return;
        	if (!ComIsEmpty(sheetObj.CellValue(rowIdx, prefix+"img_file_real_path"))) {
	            var param = "?filepath="+sheetObj.CellValue(rowIdx, prefix+"img_file_path_ctnt");
	            var url = "/hanjin/FileDownload"
	                    + "?downloadLocation=" + sheetObj.CellValue(rowIdx, prefix+"img_file_real_path")
	                    + "&downloadFileName=" + sheetObj.CellValue(rowIdx, prefix+"img_file_nm");
				var host = "http://"+location.host+"/";
				if (0<host.indexOf("localhost") || 0<host.indexOf("127.0.0.1")) {
					url = "http://alpsdev.hanjin.com:9300/"+url;
				} else {
					url = host +url;
				}
	            location.href = url;
        	}
        } else if (colIdx == sheetObj.SaveNameCol(prefix + "message_yn")) {
            if (sheetObj.CellValue(rowIdx, prefix+"message") !="") {
                ComOpenWindowCenter2("", "AmendReason", 600,200,false,"scrollbars=no,resizable=yes");
                form2.message.value = sheetObj.CellValue(rowIdx, prefix+"message");
                form2.target = "AmendReason";
                form2.action = "/hanjin/ESM_BKG_0983.do";
                form2.submit();
            }
        }
        if ((sheetObj.ColSaveName(colIdx) == prefix+"eml_subj_ctnt" 
        		|| sheetObj.ColSaveName(colIdx) == prefix+"read" )
        			&& ((sheetObj.CellValue(rowIdx, prefix+"src") == "EML")||(sheetObj.CellValue(rowIdx, prefix+"src") == "ULD"))) {
        	
        	//if 구문 추가 2011.12.22 kbj
        	if(sheetObj.CellValue(rowIdx, prefix+"src_cd") == "M" && sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id") == 'EML' ){
        		rdOpen(sheetObj,rowIdx);
        	} else if(sheetObj.CellValue(rowIdx, prefix+"src_cd") == "U" && sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id") == 'ULD' ){
        		rdOpen(sheetObj,rowIdx);
        	} else{
        		goEmlCtntPop(sheetObj,rowIdx);
        	}
		}else if (sheetObj.ColSaveName(colIdx) == prefix+"read" && (sheetObj.CellValue(rowIdx, prefix+"src") == "EDI"  || sheetObj.CellValue(rowIdx, prefix+"src") == "SEA") && sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id") != ""){
			
			rdOpen(sheetObj,rowIdx);
		}else if(sheetObj.ColSaveName(colIdx) == prefix+"si_txt") {
			var formObject = document.form;
			var sParam = "";
			var sr_knd_cd = sheetObj.CellValue(rowIdx, prefix+"sr_knd_cd");
			var sr_no = "";
			if( !ComIsNull(sheetObj.CellValue(rowIdx, prefix+"xter_rqst_no"))) {
				
				sr_no = sheetObj.CellValue(rowIdx, prefix+"xter_rqst_no");
			} else if( !ComIsNull(sheetObj.CellValue(rowIdx, prefix+"sr_no"))) {
				sr_no = sheetObj.CellValue(rowIdx, prefix+"sr_no");
				
			}
			var fax_log_ref_no = sheetObj.CellValue(rowIdx, prefix+"fax_log_ref_no");
			var bkg_no = sheetObj.CellValue(rowIdx, prefix+"bkg_no");
			
			if( (sheetObj.CellValue(rowIdx, prefix+"src_cd")  == 'M'||sheetObj.CellValue(rowIdx, prefix+"src_cd")  == 'U') 
					//&& ComIsEmpty(sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id")) //fax를 mail 로 보낼떄 없음
					&& !ComIsEmpty(sheetObj.CellValue(rowIdx, prefix+"fax_log_ref_no")) ) {
            	
				if(ComIsNull(sr_knd_cd) || ComIsNull(sr_no) || ComIsNull(fax_log_ref_no) || ComIsNull(bkg_no) ) {
					return;
				}
			} else {
				return;
			}
			
			sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+sr_no +"&fax_log_ref_no="+fax_log_ref_no+"&bkg_no="+bkg_no+"&conv_pdf_flg=Y";
//			sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+'PHX103220002' +"&fax_log_ref_no="+'4d88199a3fcfbbaf45d58e28'+"&bkg_no="+'PHX113523201';

			var date = new Date();
			var toDay = date.getYear() + "" + (date.getMonth() + 1) + ""
					+ date.getDate() + "" + date.getHours() + "" + date.getMinutes()
					+ "" + date.getSeconds();
//			winIdx = openUploadWindowCheck();
			ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam, "ESM_BKG_0447"+toDay, 750, 480, false);

		}
    }

     function initRdConfig(rdObject){
     	var Rdviewer = rdObject ;
     	Rdviewer.style.height = 0;

     	Rdviewer.setbackgroundcolor(128,128,128);
     	Rdviewer.SetPageLineColor(128,128,128);
     	Rdviewer.AutoAdjust = true;
     	Rdviewer.ViewShowMode(0);
     }

     function rdOpen(sheetObj,Row){
		var Rdviewer = rdObjects[0];
		var formObj = document.form;
		
		var rdParam = "/rv " + "frm1_sender_id["+sheetObj.CellValue(Row, prefix+"xter_sndr_id")+"] frm1_rqst_no["+sheetObj.CellValue(Row, prefix+"xter_rqst_no")+"] frm1_rqst_seq["+sheetObj.CellValue(Row, prefix+"xter_rqst_seq")+"] frm1_bkg_no["+sheetObj.CellValue(Row, prefix+"bkg_no")+"]";
		var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
		var rdFile = null;
		if ( sheetObj.CellValue(Row, prefix+"doc_tp_cd") == "B" ) rdFile = "ESM_BKG_0230B.mrd";
		else rdFile = "ESM_BKG_0230S.mrd";
		
		formObj.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/"+rdFile;
		formObj.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
		
		var iWidth = 1000;
		var	iHeight= 600;
		var leftpos = (screen.width - iWidth) / 2;
		if (leftpos < 0)
			leftpos = 0;
		var toppos = (screen.height - iHeight) / 2;
		if (toppos < 0)
			toppos = 0;
		
		ComOpenRDPopup('resizable=yes,width='+iWidth+',height='+iHeight+',left='+ leftpos + ',top=' + toppos);
	}
    function goEmlCtntPop(sheetObj,Row){
 		if (sheetObj.CellValue(Row,prefix+"eml_subj_ctnt") == "") return;
 		var sParam = "";
 		var param   = new Array("sr_knd_cd","sr_no","fax_log_ref_no","bkg_no");
 		sParam = getGetSheetRowParam(sheetObj, Row ,prefix, param);
 		ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam, "ESM_BKG_0447", 750, 480, false);
 	}
    /*
     *  get Sheet row value
     */
 	function getGetSheetRowParam(sheetObj, Row, prefix, param){
 		var sParam = "?";
 		with (sheetObj) {
 			for(i=0;i<param.length;i++){
 				sParam += "&"+param[i]+"=" + encodeURIComponent(CellValue(Row,prefix+param[i]));  
 			}	
 		}
 		return sParam;
 	}
 	
    /*
     *  Search Option or Item Option Modify
     */
    function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
        if (colIdx == sheetObj.SaveNameCol(prefix + "bkg_no")) {
       		showQueueDetail(sheetObj,rowIdx);
        }
    }

    /*
     * Queue Detail 상세 화면
     */
    function showDetail(sheetObj) {
        if (sheetObj.RowCount < 1) {
            ComShowCodeMessage("BKG00495");
            return;
        }
        showQueueDetail(sheetObj,sheetObj.GetSelectionRows());
    }

    /*
     * Queue Detail 상세 화면
     */
    function showQueueDetail(sheetObj,rowIdx) {
    	var formObj = document.form;
    	var sts = sheetObj.CellValue(rowIdx, prefix+"sr_wrk_sts_cd");
        if (rowIdx == "0" ){
	        ComShowCodeMessage("COM12189");
	        return;
        }
        
        if (isBkgLink(rowIdx)) {
	        var param = "?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no")
		        + "&ui_id=ESM_BKG_0421"
		        + "&grp_cd="+formObj.grp_cd.value
		        + "&sr_kind="+sheetObj.CellValue(rowIdx, prefix+"sr_kind_cd")
		        + "&sr_no="+sheetObj.CellValue(rowIdx, prefix+"sr_no")
		        + "&pnd_flg="+sheetObj.CellValue(rowIdx, prefix+"pnd_flg")
		        + "&src_cd="+sheetObj.CellValue(rowIdx, prefix+"src_cd")
		        + "&sr_crnt_info_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_crnt_info_cd")
		        + "&sr_crnt_sts_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_crnt_sts_cd")
		        + "&bl_doc_inp_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_doc_inp_flg")
		        + "&bl_rt_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_rt_flg")
		        + "&bl_aud_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_aud_flg")
		        + "&bl_drft_fax_out_flg="+sheetObj.CellValue(rowIdx, prefix+"bl_drft_fax_out_flg")
	        	+ "&sr_wrk_sts_cd="+sheetObj.CellValue(rowIdx, prefix+"sr_wrk_sts_cd")
	        	+ "&xter_sndr_id="+sheetObj.CellValue(rowIdx, prefix+"xter_sndr_id") //2011.08.16 jsy
	        	+ "&row_idx="+rowIdx;
	            
	        /*
	        if (popWinObj != undefined ){
	        	if (popWinObj.isOpen){
		        	popWinObj.close();
	        	}
	        }
	        if (popWinObj.closed){
	        	popWinObj = ComOpenWindowCenter2("/hanjin/ESM_BKG_0422.do"+param, "Queue Detail", 1020,630,false,"scrollbars=no,resizable=yes");
	        }
	        */
	        //ComOpenPopup("/hanjin/ESM_BKG_0422.do" + param+ "&pgmNo=ESM_BKG_0422&popUpFlag=Y", 1020, 630, "", "0,1,1,1,1", true);
	        popWinObj = ComOpenWindowCenter2("/hanjin/ESM_BKG_0422.do"+param, "Queue Detail", 1020,630,false,"scrollbars=no,resizable=yes");
     	} else {
            ComShowCodeMessage("COM12114","STS");  //Please check {?msg1}
     	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:
    			if (!ComChkValid(formObj)) return false;
                if (ComIsNull(formObj.bkg_no) && ComGetObjValue(formObj.chk_key) == "DT") {
                    if (ComIsNull(formObj.dura_from_dt) ||  ComIsNull(formObj.dura_to_dt)) {
                        ComShowCodeMessage("BKG00626","Duration");
                        if(ComIsNull(formObj.dura_from_dt))formObj.dura_from_dt.focus();
                        else if(ComIsNull(formObj.dura_to_dt))formObj.dura_to_dt.focus();
                        return false;
                    } else {
                    	if(ComGetObjValue(formObj.sts) == 'P' || ComGetObjValue(formObj.sts) == 'F'){
                    		if(ComGetDaysBetween(formObj.dura_from_dt.value,formObj.dura_to_dt.value) > 31 ) {
		                        ComShowCodeMessage("COM132001","Duration","31Days")
		                        formObj.dura_to_dt.focus();
		                        pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
		                        return false;
                    		}
                    		
                    	}else{
                    		if(ComGetDaysBetween(formObj.dura_from_dt.value,formObj.dura_to_dt.value) > 14 ) {
		                        ComShowCodeMessage("COM132001","Duration","14Days")
		                        formObj.dura_to_dt.focus();
		                        pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
		                        return false;
                    		}
                    	}
                    }
                }
    			//최소입력길이확인(vvd) - engupnum 은 공통적용안됨
                if (ComGetObjValue(formObj.chk_key) == "VVD") {
    				var objs = formObj.elements;
    				for (var i=0; i<objs.length; i++) {
    					if (objs[i] && ""==objs[i].getAttribute("fullfill")) {
							var chkLen = objs[i].getAttribute("maxLength");
							var caption = objs[i].getAttribute("caption");
	    					if (2!=ComChkLenByByte(objs[i],objs[i].getAttribute("maxLength"))) {
	    						ComShowCodeMessage("COM12174",caption,chkLen);  //{?msg1} must be at least {?msg2} characters long.
	    						ComSetFocus(objs[i]);
	    						return false;
	    					}
	    				}
    				}
        		}
                if (ComIsNull(formObj.bkg_no) == false && ComGetLenByByte(ComGetObjValue(formObj.bkg_no)) < 11) {
                	ComShowCodeMessage("BKG95018","BKG NO.","11");
                	ComSetFocus(formObj.bkg_no);
                	return false;
                }
            break;
        }
        return true;
    }

    function isNullEtcData(xmlStr) {
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
        switch (sheetObj.id) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 250;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, rowsPerPage);
                    var HeadTitle = "|Sel|Seq.|Read|SiTxt|Ugt|SI Kind|Ver|Return|Freq.|R/F|To|SRC|SRC|Booking No.|Booking Staff|Split|Lane|VVD|I|R|Q|F|FO|STS|ESI|MF|POL|ETD Date|SI Transfer\nDate|DOC.Cut off|BKG OFC|S.OFC|S.Rep|Shipper|POD|PCT Date|Return Mail|PIC From|PIC|Est. BDR\nDate|Last Updated|Message|Email Subject|Vol 20|Vol 40|Vgm"
                                  + "|message_yn|sr_crnt_info_cd|sr_crnt_sts_cd|max_sr_no|crnt_usr_id|img_file_ip|img_file_path_ctnt|img_file_nm|img_file_real_path|bkg_sts_cd|pic_cng_id|rtn_fm_usr_id|rtn_to_usr_id|rtn_to_rtn_usr_id|sr_sts_cd|rtn_to_rtn_sts_cd|pnd_flg|sr_kind_cd|sr_knd_cd|src_cd|return_src|sr_wrk_sts_usr_id|sr_no|fax_log_ref_no|rtn_to_usr_remark|sr_wrk_sts_usr_nm|sr_amd_tp_cd|xter_sndr_id|xter_rqst_no|xter_rqst_seq|doc_tp_cd|rgn_ofc_cd";//hidden
                    var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 14, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, false, true, false,false)
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW,   COL,    DATATYPE,           WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true, 	prefix+"ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 25,  daCenter, true,  prefix+"sel",                 false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtDataSeq,  30,  daCenter, true,  prefix+"seq");
                    InitDataProperty(0, cnt++, dtImage,    35,  daCenter, false, prefix+"read",                false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtImage,    35,  daCenter, false, prefix+"si_txt",                false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"urgency",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     115,  daCenter, false, prefix+"sr_kind",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"sr_amd_seq",          false, "", dfNone,        0, false, false);

                    InitDataProperty(0, cnt++, dtData,     80,  daLeft, false, prefix+"return_cd",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     35,  daCenter, false, prefix+"rtn_freq",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"rc_inp_flg",         false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"return_to",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     40,  daCenter, false, prefix+"xter_si_cd",         false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   40,  daCenter, false, prefix+"src",               false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     90,  daLeft,   false, prefix+"bkg_no",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     90,  daLeft,   false, prefix+"bkg_staff",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"split_sts_cd",      false, "", dfEngUpKey,        0, true, true ,1); 
                    InitDataProperty(0, cnt++, dtData,     40,  daCenter, false, prefix+"slan_cd",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     70,  daCenter, false, prefix+"vvd_cd",              false, "", dfNone,        0, false, false);
                    
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_doc_inp_flg",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_rt_flg",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_aud_flg",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_drft_fax_out_flg", false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_fnt_ofc_flg"     , false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     26,  daCenter, false, prefix+"sr_wrk_sts_cd",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     26,  daCenter, false, prefix+"bkg_upld_sts_cd",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"cstms_mf_tp_cd",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     45,  daCenter, false, prefix+"pol_cd",              false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     80, daCenter, false, prefix+"vps_etd_dt",         false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"sr_date",             false, "", dfUserFormat2, 0, false, false);	
                    InitDataProperty(0, cnt++, dtData,     80, daCenter, false, prefix+"doc_cct",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"bkg_ofc_cd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"ob_sls_ofc_cd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"ob_srep_cd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     180, daLeft,   false, prefix+"shipper",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     45,  daCenter, false, prefix+"pod_cd",              false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"pct_date",            false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,     150, daLeft, false, prefix+"rtn_to_usr_eml",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100,  daLeft,   false, prefix+"rtn_fm_usr_id",              false, "", dfNone,        0, false, false);  //rtn_to_usr_id
                    InitDataProperty(0, cnt++, dtData,     100,  daLeft,   false, prefix+"pic_id",              false, "", dfNone,        0, false, false);  //rtn_to_usr_id
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"bdr_date",            false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"last_date",           false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtImage,    60,  daCenter, false, prefix+"message_yn",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     130, daLeft,   false, prefix+"eml_subj_ctnt",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter,   false, prefix+"vol20",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter,   false, prefix+"vol40",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     60,  daCenter,   false, prefix+"vgm_flg",       false, "", dfNone,        0, false, false);
                    
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"message",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_crnt_info_cd"     );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_crnt_sts_cd"      );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"max_sr_no"           );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"crnt_usr_id"         );

                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"img_file_ip"         );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"img_file_path_ctnt"  );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"img_file_nm"         );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"img_file_real_path"  );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"bkg_sts_cd"          );

                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"pic_id"              );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"pic_cng_id"          );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"rtn_fm_usr_id"       );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"rtn_to_rtn_usr_id"   );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_sts_cd"           );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"rtn_to_rtn_sts_cd"   );

                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"pnd_flg"             );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_kind_cd"          );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_knd_cd"           );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"src_cd"              );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"return_src"          );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_wrk_sts_usr_id"   );

                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_no"               );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"fax_log_ref_no"      );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"rtn_to_usr_remark"      );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_wrk_sts_usr_nm"   );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"sr_amd_tp_cd"   );
                    
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"xter_sndr_id"      );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"xter_rqst_no"   );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"xter_rqst_seq"   );
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"doc_tp_cd"   );
                    //2011.12.08 rgn_ofc_cd 추가 kbj
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix+"rgn_ofc_cd"   );
                   
                    
                    InitUserFormat2(0, prefix + "pct_date",  "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix + "bdr_date",  "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix + "sr_date",   "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix + "last_date", "####-##-## ##:##", "-|:" );

                    InitDataValid(0, prefix+"split_sts_cd", vtEngUpOnly);
                    
                    ShowButtonImage = 2;

                    ImageList(0) = "/hanjin/img/btns_search.gif";
                    ImageList(1) = "/hanjin/img/blank.gif";
                    ImageList(2) = "/hanjin/img/ico_attach.gif";
                    ImageList(3) = "/hanjin/img/btns_note.gif";
                    ImageList(4) = "/hanjin/img/btn_file.gif";
//                    FrozenCols = 15;
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
                    InitRowInfo(1, 1, 3, rowsPerPage);
                    var HeadTitle = "|Sel|Seq.|Read|Ugt|SI Kind|Ver|Return|Freq.|R/F|To|SRC|SRC|Booking No.|Booking Staff|Split|Lane|VVD|I|R|Q|F|FO|STS|Pending User|Pending User|ESI|MF|POL|ETD Date|SI Transfer\nDate|DOC.Cut off|BKG OFC|S.OFC|S.Rep|Shipper|POD|PCT Date|Return Mail|PIC From|PIC|Est. BDR\nDate|Last Updated|Message|Email Subject"
                                                     var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 11, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, false, true, false,false)
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW,   COL,    DATATYPE,           WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true, 	prefix+"ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 25,  daCenter, true,  prefix+"sel",				false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtDataSeq,  30,  daCenter, true,  prefix+"seq");
                    InitDataProperty(0, cnt++, dtImage,    35,  daCenter, false, prefix+"read",                false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"urgency",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     115,  daCenter, false, prefix+"sr_kind",            false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"sr_amd_seq",          false, "", dfNone,        0, false, false);

                    InitDataProperty(0, cnt++, dtData,     80,  daLeft, false, prefix+"return_cd",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     35,  daCenter, false, prefix+"rtn_freq",            false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"rc_inp_flg",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"return_to",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     40,  daCenter, false, prefix+"xter_si_cd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   40,  daCenter, false, prefix+"src",                 false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     90,  daLeft,   false, prefix+"bkg_no",              false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     90,  daLeft,   false, prefix+"bkg_staff",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"split_sts_cd",        false, "", dfEngUpKey,        0, true, true ,1); 
                    InitDataProperty(0, cnt++, dtData,     40,  daCenter, false, prefix+"slan_cd",			   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     70,  daCenter, false, prefix+"vvd_cd",              false, "", dfNone,        0, false, false);
                    
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_doc_inp_flg",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_rt_flg",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_aud_flg",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_drft_fax_out_flg", false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix+"bl_fnt_ofc_flg"     , false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     26,  daCenter, false, prefix+"sr_wrk_sts_cd",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     80,  daCenter, false, prefix+"pnd_usr_id",		   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"pnd_usr_nm",		   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     26,  daCenter, false, prefix+"bkg_upld_sts_cd",     false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix+"cstms_mf_tp_cd",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     45,  daCenter, false, prefix+"pol_cd",              false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     80, daCenter, false, prefix+"vps_etd_dt",           false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"sr_date",             false, "", dfUserFormat2, 0, false, false);	
                    InitDataProperty(0, cnt++, dtData,     80, daCenter, false, prefix+"doc_cct",              false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"bkg_ofc_cd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"ob_sls_ofc_cd",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix+"ob_srep_cd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     180, daLeft,   false, prefix+"shipper",             false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     45,  daCenter, false, prefix+"pod_cd",              false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"pct_date",            false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,     150, daLeft, false, prefix+"rtn_to_usr_eml",        false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100,  daLeft,   false, prefix+"rtn_fm_usr_id",      false, "", dfNone,        0, false, false);  //rtn_to_usr_id
                    InitDataProperty(0, cnt++, dtData,     100,  daLeft,   false, prefix+"pic_id",             false, "", dfNone,        0, false, false);  //rtn_to_usr_id
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"bdr_date",            false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix+"last_date",           false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,     100,  daCenter, false, prefix+"message",			   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,     130, daLeft,   false, prefix+"eml_subj_ctnt",       false, "", dfNone,        0, false, false);

                    InitUserFormat2(0, prefix + "pct_date",  "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix + "bdr_date",  "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix + "sr_date",   "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix + "last_date", "####-##-## ##:##", "-|:" );
                }
            break;
        	case "rtnOfcListSheet": //RTN Office 다중 선택
        		with (sheetObj) {
        		// 높이 설정
        		style.height = 94;
        		// 전체 너비 설정
        		SheetWidth = mainTable.clientWidth;

        		// Host정보 설정[필수][HostIp, Port, PagePath]
        		if (location.hostname != "")
        			InitHostInfo(location.hostname, location.port, page_path);

        		// 전체Merge 종류 [선택, Default msNone]
        		MergeSheet = msHeaderOnly;

        		// 전체Edit 허용 여부 [선택, Default false]
        		Editable = true;

        		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		InitRowInfo(1, 1, 2, 100);

        		var HeadTitle1 = " | |Office";
        		var headCount = ComCountHeadTitle(HeadTitle1);

        		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		InitColumnInfo(headCount, 0, 0, true);

        		// 해더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, true, true, false, false);

        		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        		InitHeadRow(0, HeadTitle1, true);

        		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
        		// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");

        		InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
        		InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
        		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "m_p_ofc_cd", false, "", dfEngUpKey, 0, true, true);
        		
        		CountPosition = 0;

        		}
        		break;	            
        }
    }

 	function isBkgLink(row) {
 		var formObj = document.form;
		var sts = sheetObjects[0].CellValue(row, prefix+"sr_wrk_sts_cd");
		var usr = sheetObjects[0].CellValue(row, prefix+"sr_wrk_sts_usr_id");
		return true;
		//return ""==sts || "Y"==sts || "T"==sts || "W"==sts || (("P"==sts || "F"==sts) && usr==document.form.usr_id.value) || ComGetObjValue(formObj.grp_cd)=="F" ;
	}

	function isTooltip(row) {
		return isBkgLink(row) && !ComIsNull(sheetObjects[0].CellValue(row,prefix+"sr_wrk_sts_usr_id"));
	}

	function openPopWindowCheck(){
		 for (var idx=0; idx< arrWindow.length ; idx++) {
			 if(arrWindow[idx] == null || arrWindow[idx].closed) 
				 return idx;
		 }
		 
		 return 99;
	}
	
	/*
     * Queue Detail 상세 화면
     */
    function callSplitClick(sheetObj) {
    	/* 
        if (sheetObj.RowCount < 1) {
            ComShowCodeMessage("BKG00495");
            return;
        }*/
        /*
        1. 선택된 항목이 없는 경우 [BKG00155] 표시 후 리턴
        2. 선택된 항목이 한개 이상인 경우 [BKG00362] 표시 후 리턴
        3. 선택된 항목이 삭제인 경우 [BKG00471] 표시후 리턴
         */
        if (ComFindText(sheetObj, prefix+"sel", 1).length < 1 ){
  	        ComShowCodeMessage("BKG00155");
  	        return;
        }
        
        if (ComFindText(sheetObj, prefix+"sel", 1).length > 1 ){
  	        ComShowCodeMessage("BKG00362");
  	        return;
        }
        callSplitPop(sheetObj,ComFindText(sheetObj, prefix+"sel", 1));
    }

    /*
     * Queue Detail 상세 화면
     */
    function callSplitPop(sheetObj,rowIdx) {
    	var formObj = document.form;
        if (rowIdx == "0" ){
	        ComShowCodeMessage("COM12189");
	        return;
        }
        var sts = sheetObjects[0].CellValue(rowIdx, prefix+"split_sts_cd");
        if (sts != "S" && sts != "F" && sts != "W"){
        	ComShowCodeMessage("BKG00063");
        	return;
        }
        var winIdx = openPopWindowCheck();
        var param   = new Array("xter_sndr_id","xter_rqst_no","xter_rqst_seq","sr_knd_cd","sr_no");
 		sParam = getGetSheetRowParam(sheetObj, rowIdx ,prefix,param);
 		sParam +="&openerPgmNo=ESM_BKG_0421"
		arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0445.do" + sParam+ "&pgmNo=ESM_BKG_0445", "SI_SPLIT_CANDIDATE", 1025, 650, true, "yes");
    }
    
    
    /* 개발자 작업  끝 */

    
    