/**=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0032.js
* @FileTitle : Inquire/Edit Supply & Slot-swap By VVD
* Open Issues :
* Change history :
* @LastModifyDate : 2006-09-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-09-18 Kim Jong Beom
*  1.0 최초 생성
' =========================================================
 * History
 * 2008.02.27 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
 *    변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
 * 2009.09.28 남궁진호 ALPS 전환작업  ESM_BSA_0032.js로 1.0 Creation   
 * 2010.04.15 남궁진호 formQueryString수정          
 * 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
 * 2012.05.24 이석준 [CHM-201218050] Port Step Up/Down 화면 Weight 입력 기능 변경 요청
2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
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
     * @class ESM_BSA_0032 : ESM_BSA_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0032() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	// 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var sheet_height = 20; // sheet의 height
    
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				sheetObject2.RemoveAll();
    				break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				//doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    				break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;

    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
    				break;

    			case "btng_reset":
    				doActionIBSheet(sheetObject,formObject,IBRESET);
    				sheetObject2.RemoveAll();
    				break;

    			case "btng_portadd":
    				if (sheetObject.SelectRow > 0 && sheetObject.RowCount > 0) {
    					doActionIBSheet2(sheetObject2,formObject,IBINSERT);
    				}
    				break;

    			case "btng_save":
    				doActionIBSheet2(sheetObject2,formObject,IBSAVE);
    				break;
    				
    			case "btng_save1":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;

    			case "btn_skdinquiry":
    				var classId = "COM_ENS_0B1";
    				var vvd_cd = "";  //sheet1의 선택된 값 ex)HABK0418E
    				if (sheetObject.SelectRow > 0 && sheetObject.RowCount > 0) {
    					var vsl_cd     = sheetObject.CellValue(sheetObject.SelectRow, 'vsl_cd');
    					var skd_voy_no = sheetObject.CellValue(sheetObject.SelectRow, 'skd_voy_no');
    					var skd_dir_cd = sheetObject.CellValue(sheetObject.SelectRow, 'skd_dir_cd');

    					vvd_cd = vsl_cd + skd_voy_no + skd_dir_cd;
    				}
       				if (vvd_cd == "") { vvd_cd = "ABCD1234E"; }
    				var param = "?vvd_cd=" + vvd_cd + "&classId=" + classId;
    				ComOpenPopup("/hanjin/"+classId+".do"+param, 608, 470, "", "0,0,1,1,1,1,1,1,1,1", false);
    				break;

    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	 
	/**
	 * 설  명 : IBCombo Object를 배열로 등록 <br>
	 *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *          배열은 소스 상단에 정의<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setComboObject(combo_obj)
	 * </pre>
	 * @param {object}	combo_obj - Combo Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
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
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	// 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}

	    // 초기 설정
	    comboObjects[4].Code = "SML";
		loadingMode = false;
    }
    
    /**
 	 * 설  명 :  Combo 기본 설정 및 초기화 <br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *     loadCombo()
 	 * </pre>
 	 * @see #링크연결
 	 * @author 작성자
 	 * @version 2009.01.01
 	 */
 	function loadCombo() {
 		var formObj = document.form;
 		var sXml = formObj.sXml.value;

 		var arrXml = sXml.split("|$$|");
 		comboXml = arrXml;

 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
 		if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
 		if (arrXml.length > 2)
 			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
 		if (arrXml.length > 3)
 			ComXml2ComboItem(arrXml[3], formObj.cobIOC, "code", "code");
		if (arrXml.length > 4){
			ComXml2ComboItem(arrXml[4], formObj.cobCarrier, "code", "code");
		}
 		document.form.sXml.value="";
 	}
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

    	var cnt = 0;
    	var formObj = document.form;

    	switch(sheetNo) {
    		case 1:      //sheet1 init
    			with (sheetObj) {
                    SheetWidth = mainTable1.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    MergeSheet = msNone;
                    Editable = true;
                    InitRowInfo(1, 1, 9, 100);
//                    InitColumnInfo(18, 1, 0, true);
                    InitColumnInfo(19, 1, 0, true);
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "STS|MNL\nFLG|YYYY\nWW|Trade|Sub\nTrade|S.Lane|Lane|☆|Type|Vessel|Voy.|BND|OPR|BSA\nCapa.|Flag|C.Flag|SML|Option|Crr";
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    DataRow, Col, [DataType], [Width], [DataAlign],
                    //            [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
                    //            [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
                    //            [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                    InitDataProperty(0, cnt++, dtStatus,   30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData,     35, daCenter, true, "mnl_flg",        false, "", dfDateYm,  0, false, false);
                    InitDataProperty(0, cnt++, dtData,     55, daCenter, true, "cost_yrwk",        false, "", dfDateYm,  0, false, false);
                    InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "trd_cd",           false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "sub_trd_cd",       false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "slan_cd",          false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "rlane_cd",         false, "", dfNone,    0, false, false);

                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "bsa_op_cd",        false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "bsa_op_nm",        false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     45, daCenter, true, "vsl_cd",           false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "skd_voy_no",       false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,     30, daCenter, true, "skd_dir_cd",       false, "", dfNone,    0, false, false);

                    InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "vop_cd",           false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtAutoSum,  55, daRight,  true, "bsa_capa",         false, "", dfInteger, 0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "stup_flg",         false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "port_bsa_cfm_flg",   false, "", dfNone,    0, true, true);
                    
                    if(formObj.rdoCode[2].checked){
                    	InitDataProperty(0, cnt++, dtAutoSum,  50, daRight,  true, "port_bsa_capa",    false, "", dfFloat, 1, false, false);
                    }else{
                    	InitDataProperty(0, cnt++, dtAutoSum,  50, daRight,  true, "port_bsa_capa",    false, "", dfInteger, 0, false, false);
                    }

                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "bsa_op_jb_cd",     false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "crr_cd",           false, "", dfNone,    0, false, false);

                    CountPosition  = 0 ;
                    style.height =  GetSheetHeight(sheet_height) ;
                }
                break;
    		case 2:      //sheet1 init
    			with (sheetObj) {
                    SheetWidth = mainTable2.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    MergeSheet = msHeaderOnly;
                    Editable = true;
                    InitRowInfo(1, 1, 9, 100);
                    InitColumnInfo(12, 0 , 0, true);
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "Del.|STS|Trade|Lane|Vessel|Voy.|BND|OP-JB|Crr|SEQ|Port|BSA";
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    DataRow, Col, [DataType], [Width], [DataAlign],
                    //            [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
                    //            [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
                    //            [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                    InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter, false, "");
                    InitDataProperty(0, cnt++, dtStatus,   30, daCenter, false, "ibflag");

                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "trd_cd",          true,  "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "rlane_cd",        true,  "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "vsl_cd",          true,  "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "skd_voy_no",      true,  "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "skd_dir_cd",      true,  "", dfNone,    0, false, false);

                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "bsa_op_jb_cd",    true,  "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    0, daCenter, false, "crr_cd",          true,  "", dfNone,    0, false, false);

                    InitDataProperty(0, cnt++, dtData,     50, daCenter, false, "port_seq",        true,  "", dfNone,    0, false, true, 3);
                    InitDataProperty(0, cnt++, dtData,     50, daCenter, false, "port_cd",         false, "", dfEngUpKey,    0, true,  true, 5);
                    
                    if(formObj.rdoCode[2].checked){
                    	InitDataProperty(0, cnt++, dtAutoSum,  50, daRight,  false, "port_bsa_capa",   false, "", dfFloat, 1, true,  true);
                    }else{
                    	InitDataProperty(0, cnt++, dtAutoSum,  50, daRight,  false, "port_bsa_capa",   false, "", dfInteger, 0, true,  true);
                    }

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(sheet_height) ;
    			}
        		break;
    	}
    }

 	/**
 	 * 설  명 :  Combo 기본 설정 <br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *     initCombo(comboObj,comboNo)
 	 * </pre>
 	 * @param {object}	comboObj - Combo Object
 	 * @param {Number}	comboNo  - Combo Number
 	 * @see #링크연결
 	 * @author 작성자
 	 * @version 2009.01.01
 	 */
  	function initCombo (comboObj, comboNo) {
 		with (comboObj) {
	  		DropHeight = 300;
		  	if( comboNo == "cobCarrier"){
		  		//comboObj.BackColor = "#CCFFFD";
		  	} else {
		  		comboObj.InsertItem(0, 'All' ,''); 
		  	}
		  	Index = 0; 
 		}
  	}
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	var sheetObject2 = sheetObjects[1];

    	switch(sAction) {

    		case IBSEARCH:      //조회
    			if (validateCond(formObj,sAction)) {
    				formObj.f_cmd.value = SEARCHLIST01;
    				sheetObj.DoSearch4Post("ESM_BSA_0032GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
    			}
    			break;

    		case IBSAVE:      //저장
    			if (validateCond(formObj,sAction)) {
    				formObj.f_cmd.value = MULTI01;
    				sheetObj.DoSave("ESM_BSA_0032GS.do", bsaFormString(formObj,getParam2(curPgmNo,'S')));
    			}
    			break;

    		case IBDOWNEXCEL:   //엑셀 다운로드
    			//sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        if (sheetObject2.RowCount > 0) {
                            sheetObject2.Down2Excel(0, false, false, true);
                        }
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        if (sheetObject2.RowCount > 0) {
                            sheetObject2.Down2Excel(-1, false, false, true);
                        }
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        if (sheetObject2.RowCount > 0) {
                            sheetObject2.SpeedDown2Excel(0, false, false);
                        }
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        if (sheetObject2.RowCount > 0) {
                            sheetObject2.SpeedDown2Excel(-1, false, false);
                        }
                        break;
                }               
    			break;

    		case IBRESET:      //생성데이터 초기화
    			if (validateCond(formObj,sAction)) {
    				if (ComShowConfirm(ComGetMsg('BSA10021')) == true) { //정보를 RESET 하시겠습니까?
    					formObj.f_cmd.value = INIT;
    					sheetObj.DoSearch4Post("ESM_BSA_0032GS.do", bsaFormString(formObj,getParam2(curPgmNo,'S')));
    					var err_cd = sheetObj.EtcData("err_cd");
    					var err_msg = sheetObj.EtcData("err_msg");

    					if (err_cd == "00000") {
    					  ComShowMessage(ComGetMsg('BSA10018','RESET')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
    					}
    				}
    			}
    			break;

    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {

    		case IBSEARCH:      //조회 (Detail)
    			if (sheetObj.SelectRow > 0) {
    				var trd_cd          = sheetObj.CellValue(sheetObj.SelectRow, 'trd_cd');
    				var rlane_cd        = sheetObj.CellValue(sheetObj.SelectRow, 'rlane_cd');
    				var vsl_cd          = sheetObj.CellValue(sheetObj.SelectRow, 'vsl_cd');
    				var skd_voy_no      = sheetObj.CellValue(sheetObj.SelectRow, 'skd_voy_no');
    				var skd_dir_cd      = sheetObj.CellValue(sheetObj.SelectRow, 'skd_dir_cd');
    				var bsa_op_jb_cd    = sheetObj.CellValue(sheetObj.SelectRow, 'bsa_op_jb_cd');
    				var crr_cd          = sheetObj.CellValue(sheetObj.SelectRow, 'crr_cd');

    				var param = "&trd_cd=" +trd_cd+ "&rlane_cd=" +rlane_cd+ "&vsl_cd=" +vsl_cd
    				          + "&skd_voy_no=" +skd_voy_no+ "&skd_dir_cd=" +skd_dir_cd
    				          + "&bsa_op_jb_cd=" +bsa_op_jb_cd+ "&crr_cd=" +crr_cd;

    				        var sheetObject2 = sheetObjects[1];
    				        formObj.f_cmd.value = SEARCHLIST02;
    				        //ComShowMessage(FormQueryString(formObj) + param);
    				        sheetObject2.DoSearch4Post("ESM_BSA_0032GS2.do", bsaFormString(formObj,getParam2(curPgmNo,'S')) + param);
    			}
    		    break;

    		case IBINSERT:      // 입력
    			var sheetObject = sheetObjects[0];

    		    var Row = sheetObj.DataInsert();

    		    sheetObj.CellValue2(Row, "trd_cd")          = sheetObject.CellValue(sheetObject.SelectRow, "trd_cd");
    		    sheetObj.CellValue2(Row, "rlane_cd")        = sheetObject.CellValue(sheetObject.SelectRow, "rlane_cd");
    		    sheetObj.CellValue2(Row, "vsl_cd")          = sheetObject.CellValue(sheetObject.SelectRow, "vsl_cd");
    		    sheetObj.CellValue2(Row, "skd_voy_no")      = sheetObject.CellValue(sheetObject.SelectRow, "skd_voy_no");
    		    sheetObj.CellValue2(Row, "skd_dir_cd")      = sheetObject.CellValue(sheetObject.SelectRow, "skd_dir_cd");
    		    sheetObj.CellValue2(Row, "bsa_op_jb_cd")    = sheetObject.CellValue(sheetObject.SelectRow, "bsa_op_jb_cd");
    		    sheetObj.CellValue2(Row, "crr_cd")          = sheetObject.CellValue(sheetObject.SelectRow, "crr_cd");

            	break;

    		case IBSAVE:        // 저장
    			if (validateSheet(sheetObj)) {
    				if (sheetObj.RowCount > 0) {
    				    formObj.f_cmd.value = MULTI02;
    					sheetObj.DoAllSave("ESM_BSA_0032GS2.do", bsaFormString(formObj,getParam2(curPgmNo,'S')));
    				}
    			}
    			break;

    	}
    }

    /**
     * sheet1을 더블클릭하여 sheet2를 상세조회한다.
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var formObject = document.form;
    	doActionIBSheet2(sheetObj,formObject,IBSEARCH);
    }

    var selRow = 0;
    var selValue = "";

    function isValidLocation(result) {
    	var sheetObject2 = sheetObjects[1];

    	if(!result){
    		ComShowMessage(ComGetMsg('BSA10004',selValue));  //msg1 + ' 는(은) 유효한 PORT가 아닙니다.'
    		sheetObject2.SelectCell(selRow,"port_cd",true);
    	}
    }

    function sheet2_OnChange(sheetObj,Row,Col,Value) {
    	var formObj = document.form;
    	var param;

    	if (sheetObj.ColSaveName(Col) == "port_cd") {
    		selRow = Row;
    		selValue = Value;
    		
    		param = "f_cmd="+SEARCHLIST02;
    		param = param+"&port_cd="+sheetObj.CellValue(Row,Col);
    		param = param+"&code=locCd";
    		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    		var locCd = GetEtcDataForExceptional(sXml, "locCd", "0");
    		isValidLocation(locCd);
    	}
    }


    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
      sheetObj.SumText(0,0) = "";
      sheetObj.SumText(0,"cost_yrwk") = "TOTAL";
    }

    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
    //  sheetObj.SumText(0,0) = "";
    //  sheetObj.SumText(0,1) = "";
    //  sheetObj.SumText(0,2) = "";
    //  sheetObj.SumText(0,"port_seq") = "TOTAL";
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateSheet(sheetObj) {
    	with(sheetObj){
    	}

    	return true;
    }

    /**
     * 화면 조회값에 대한 유효성검증 프로세스 처리
     */
    function validateCond(formObj,sAction) {
    	with(formObj) {
    		// msg1 + '  를(을) 확인하세요.';
    		if (ComTrim(txtYear.value) == "") {
        		//ComShowMessage(ComGetMsg('COM12114','Year'));
        		//txtYear.focus();
        		ComAlertFocus(txtYear, ComGetMsg('COM12114','Year'));
        		return false;
    		}
    		if (sAction == IBSEARCH) { //조회시에만 체크
        		// msg1 + '  과 ' + msg2 + '중 하나는 입력하세요.';
        		if (ComTrim(txtFmMonth.value) == "" && ComTrim(txtFmWeek.value) == "") {
        			//ComShowCodeMessage('COM12138','Month','Week');
        			//txtFmMonth.focus();
        			ComAlertFocus(txtFmMonth, ComGetMsg('COM12138','Month','Week'));
        			return false;
        		}
        		// msg1 + ' 의 ' + msg2 + ' 를(을) 입력하세요.';
        		if (ComTrim(txtFmMonth.value) != "" && ComTrim(txtToMonth.value) == "") {
        			//ComShowCodeMessage('COM12130','Month','Second Element');
        			//txtToMonth.focus();
        			ComAlertFocus(txtToMonth, ComGetMsg('COM12130','Month','Second Element'));
        			return false;
        		}
        		if (ComTrim(txtFmWeek.value) != "" && ComTrim(txtToWeek.value) == "") {
        			//ComShowCodeMessage('COM12130','Week','Second Element');
        			//txtToWeek.focus();
        			ComAlertFocus(txtToWeek, ComGetMsg('COM12130','Week','Second Element'));
        			return false;
        		}
        	}

            // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
    		if (ComTrim(txtFmMonth.value) != "" && ComTrim(txtToMonth.value) != "") {
        		if(parseInt(txtFmMonth.value) > parseInt(txtToMonth.value)){
            		//ComShowCodeMessage('BSA10011','Month','First Element','Second Element');
            		//txtFmMonth.focus();
            		ComAlertFocus(txtFmMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
            		return false;
        		}
    		}
    		if (ComTrim(txtFmWeek.value) != "" && ComTrim(txtToWeek.value) != "") {
        		if(parseInt(txtFmWeek.value) > parseInt(txtToWeek.value)){
            		//ComShowCodeMessage('BSA10011','Week','First Element','Second Element');
            		//txtFmWeek.focus();
            		ComAlertFocus(txtFmWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
            		return false;
        		}
    		}
//    		if(formObj.cobTrade.value == "" ){  
//	            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//	            return false;
//	        }
//	        
//            if(formObj.cobLane.value == "" ){
//                ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//                return false;
//            }
    	}

    	return true;
    }

    //Carrier Combo Change
    function cobCarrier_OnChange(obj) {
    	var sheetObject  = sheetObjects[0];
    	var formObject = document.form;
    	sheetObject.CellValue2(0,"port_bsa_capa") = obj.Code;
    }
    
    function rdoCode_onClick(param){
        var sheetObj = sheetObjects[1];
        
        sheetObjects[0].RemoveAll();
        sheetObj.RemoveAll();
        initSheet(sheetObjects[0], 1);
        initSheet(sheetObj, 2);
        sheetObj.Cellvalue2(0, "port_bsa_capa") = param;
    }
    /**
     * ifram을 이용하여 R.Lane 표시
     */
    function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
    }

        /**
         * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
         */
        function setPeriod(obj) {
             var formObj = document.form;
             var sheetObj = sheetObjects[0];
             var param = "";
             var gubun = "";
             var fm_mon ="";
             var to_mon ="";
             var fm_wk ="";
             var to_wk ="";
        
            if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
                if(obj.name == "txtToMonth" ){
                    formObj.txtFmMonth.value = "";
                } else if (obj.name == "txtToWeek"){
                    formObj.txtFmWeek.value = "";
                }
                return false;
            } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
                if(obj.name == "txtFmMonth") return false;
                if(obj.name == "txtFmWeek") return false;
            }
        
            if(chkValidSearch()){
                if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value != ""){
                	gubun = "5";
                } else if(formObj.txtFmMonth.value == "" && formObj.txtFmWeek.value != "") {
                	gubun = "4";
                } else if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value == "") {
                	gubun = "3";
                }
                formObj.param2.value = formObj.txtYear.value;
                if(formObj.chkPrd[0].checked){
                    fm_mon = "";
                    to_mon = "";
                    fm_wk = formObj.txtFmWeek.value;
                    to_wk = formObj.txtToWeek.value;
                } else {
                    fm_mon = formObj.txtFmMonth.value;
                    to_mon = formObj.txtToMonth.value;
                    fm_wk = "";
                    to_wk = "";
                }

                param = param+"f_cmd="+SEARCHLIST02;
    			param = param+"&gubun="+gubun;
    			param = param+"&fm_mon="+fm_mon;
    			param = param+"&to_mon="+to_mon;
    			param = param+"&fm_wk="+fm_wk;
    			param = param+"&to_wk="+to_wk;
    			param = param+"&year="+eval(formObj.txtYear.value);
    			param = param+"&code=period";
    			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    			var period = GetEtcDataForExceptional(sXml, "period", "0");
    			document.getElementById("div_period").innerHTML = "<div id=\"div_period\">("+ period +")</div>";
            }
        }
        /**
         * 검색시 필수입력사항 체크
         */
        function chkValidSearch(){
            var formObj = document.form;

    		with(formObj){
    			if (txtYear.value == "") {
    				ComShowCodeMessage("COM12114", "Year", "");
    			    txtYear.focus();
    				return false;
    			}
    			if (txtFmMonth.value != "" && txtToMonth.value == "") {
    				ComShowCodeMessage("COM12114", "month", "")
    			    txtToMonth.focus();
    			    return false;
    			}
    			if (txtFmMonth.value == "" && txtToMonth.value != "") {
    				ComShowCodeMessage("COM12114", "month", "");
    			    txtFmMonth.focus();
    			    return false;
    			}
//    			if (txtFmMonth.value != "" && txtToMonth.value != "") { 
//    			    if(ComParseInt (txtFmMonth.value) > ComParseInt (txtToMonth.value)){
//    			    	ComShowCodeMessage("COM12133","from Month"," to Month","작은값");
//    			        txtFmMonth.value = "";
//    			        txtToMonth.value = "";
//    			        txtFmMonth.focus();
//    			        return false;
//    			    }
//    			}

    			if (txtFmWeek.value != "" && txtToWeek.value == ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    txtToWeek.focus();
    			    return false;
    			}
    			if (txtFmWeek.value == "" && txtToWeek.value != ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    txtFmWeek.focus();
    			    return false;
    			}
    			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
//    			    ComShowCodeMessage("COM12138", "month", "week"); 
    			    return false;
    			}
    		    if(!isValidYear(txtYear,false,true)) return false;
    			if(!isValidMonth(txtFmMonth,false,true)) return false;
    			if(!isValidMonth(txtToMonth,false,true)) return false;
    			if(!isValidWeek(txtFmWeek,false,true)) return false;
    			if(!isValidWeek(txtToWeek,false,true)) return false;
    		}
    		return true;
        }

	/* 개발자 작업  끝 */