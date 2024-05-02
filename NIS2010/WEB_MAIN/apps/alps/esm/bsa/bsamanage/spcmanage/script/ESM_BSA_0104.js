/*=========================================================
* History
 * 2008.01.30 박은주 N200801230002 e-NIS/BSA 시스템 변경 요청
 *                  Type Size(Sub-allocation)별로 판매/구매 및 Free allocation 기능 추가[104]
 * 2008.02.27 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
 *                  Year, Month, Week관련 화면변경에 따른 Script변경
* 2009.10.06 남궁진호 ALPS 전환작업  1.0 Creation
* 2010.04.15 남궁진호 formQuiryString수정,popup 화면 modal 변경
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
     * @class ESM_BSA_0104 : ESM_BSA_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0104() {
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
    var vHeader = "";
    var clu2ndFinal="";    // 
    var subColNo = 0;      // 선사갯수
    var sheet_height = 20; // sheet의 height    

	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_downexcel":
				    //sheetObject.DataInsert();
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btn_skdinquiry":
                    var vsl_cd  = "";
                    var classId = "COM_ENS_0B1";
                    var param = "";

                    if(sheetObject.SelectRow > 1){
                        vsl_cd = ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "vsl_cd"))
                               + ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "skd_voy_no"))
                               + ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "skd_dir_cd"));
                    }else{
                        //[COM12113] : VVD 를(을) 선택하세요.
                        ComShowMessage(ComGetMsg("COM12113","VVD"));
                        return false;
                    }
                    param = '?vvd_cd='+vsl_cd+'&classId='+classId;
                    ComOpenPopup("/hanjin/COM_ENS_0B1.do"+param, 610, 430, "", "0,0,1,1,1,1,1,1,1,1", false);
					break;

                case "btng_reset":
                    doActionIBSheet(sheetObject,formObject,IBRESET);
                    break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;
    
    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
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
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage(header) {
		 
		for(i=0;i<sheetObjects.length;i++){
			sheetObjects[i].RemoveAll();
			sheetObjects[i].Reset();
			ComConfigSheet(sheetObjects[i]);    			
			initSheet(sheetObjects[i],i+1,header);
			ComEndConfigSheet(sheetObjects[i]);
			ComEndConfigSheet(sheetObjects[i]);
		}
		 var sheetObj = sheetObjects[0];
		sheetObj.Visible  = false;
		sheetObj.Redraw = false;
		sheetObj.RemoveAll();
		sheetObj.Reset();
		ComConfigSheet(sheetObj);
		initSheet(sheetObj, 1, header);
	    //ComEndConfigSheet(sheetObj);
		sheetObj.Redraw = true;
		sheetObj.Visible  = true;
		
		// SPC에서 콜할때 화면 로드시 자동조회하되록함.
		//-----------------------------------------------------
		if(document.form.hSearchYN.value == "Y") {
		    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		    document.form.hSearchYN.value = "";
		}
		//-----------------------------------------------------

		// 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
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
		document.form.sXml.value="";
	}

	/**
	 * 설  명 :  시트 초기설정값, 헤더 정의 <br>
	 *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj,sheetNo,header)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
	 * @param {String}	header   - header
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initSheet(sheetObj,sheetNo,header) {
		var cnt = 0;
		var aryCD = "";
		var colNo = 0;
		
		var formObj = document.form;
	    var sls = "";
	    var pur = "";
	    var slt = "";
        var chkValue = "";
        for(k=0; k<formObj.rdoOpJob.length; k++){
            if(formObj.rdoOpJob[k].checked) chkValue = formObj.rdoOpJob[k].value;
        }
		aryCD = header.split("|");
		if(header != "") subColNo = aryCD.length;
//		if(chkValue != "008" && chkValue != "009"){
//		    colNo = parseInt(subColNo*5) + 22;
//		}else{
//		    colNo = parseInt(subColNo) + 18;
//		}
		if(chkValue != "008" && chkValue != "009"){
		    colNo = parseInt(subColNo*5) + 23;
		}else{
		    colNo = parseInt(subColNo) + 19;
		}
		var arrCluLogic = new Array(subColNo) ;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(sheet_height) ;
					SheetWidth = mainTable.clientWidth;									//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;											//전체Merge 종류 [선택, Default msNone]
					Editable = true;													//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);											//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colNo, 15, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);					// 해더에서 처리할 수 있는 각종 기능을 설정한다
// 2016.01.29 김성욱
//                   var HeadTitle0 = "STS|BSA\nFlag|YYYY-WW|Trade|Sub-Trade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|Carrier|BSA CAPA." ;
//					var HeadTitle1 = "STS|BSA\nFlag|YYYY-WW|Trade|Sub-Trade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|Carrier|BSA CAPA." ;
					
					var HeadTitle0 = "STS|MNL\nFlag|BSA\nFlag|YYYY-WW|Trade|Sub-Trade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|Carrier|BSA CAPA." ;
					var HeadTitle1 = "STS|MNL\nFlag|BSA\nFlag|YYYY-WW|Trade|Sub-Trade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|Carrier|BSA CAPA." ;
					
            		if(chkValue == "007"){
            		    HeadTitle0 = HeadTitle0 +"|SML 1st BSA";
            		    HeadTitle1 = HeadTitle1 +"|SML 1st BSA";
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Other Carrier's 1st BSA" ;
            		    HeadTitle0 +="|Free Addition|Free Addition|SML 2nd BSA\n(SPC control)" ;
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Other Carrier's 2nd BSA Control (by VVD)" ;
//                		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Other Carrier's 2nd final BSA After Slot Swap For SPC Control(by VVD)" ;
            		    HeadTitle0 += "|Swap\nNotice";
//                		    HeadTitle1 += "|" + header + "|SPC(TEU)|WGT|SML 2nd BSA\n(SPC control)|" + header + "|Swap\nNotice|" + header + "|" + header + "|" + header;
            		    
            		    HeadTitle1 += "|" + header + "|SPC(TEU)|WGT|";
            		    HeadTitle1 += "SML 2nd BSA\n(SPC control)|";
            		    HeadTitle1 +=  header + "|Swap\nNotice|" + header + "|" + header + "|" + header;            		    
            		    // Hidden 값(PopUp 화면에서 변경된 값을 가지고 있기위해서...
            		    //------------------------------------------------------------------
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Sale to(by VVD)";
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Purchase from(by VVD)";
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Slot Swap(by VVD)";
            		    HeadTitle0 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
            		    HeadTitle1 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
                        // 수식
                	    // 2nd Final SML BSA = (1st Final SML BSA) - (Sal to(by VVD)) + (Purchase from(by VVD)) + (Slot Swap(by VVD)) + (Free Addition)
                	    // -- 이전꺼 >> Other Carrier's 2st final BSA = (Other Crraier's 1st final BSA) + (Sale to(by VVD)) - (Purchase from(by VVD)) + (Slot Swap(by VVD))
                	    // Other Carrier's 2st final BSA = (Other Crraier's 1st final BSA) + (Sale to(by VVD)) - (Purchase from(by VVD))
                	    //-------------------------------------------------------------------------------------------------------
            		    for(j=0; j<subColNo; j++){
            		        //arrCluLogic[j] = "|c"+aryCD[j]+"|+|sls"+aryCD[j]+"|-|pur"+aryCD[j]+"|+|slt"+aryCD[j]+"|";
            		        arrCluLogic[j] = "|c"+aryCD[j]+"|+|sls"+aryCD[j]+"|-|pur"+aryCD[j]+"|";
            		        sls += "|sls"+aryCD[j]+"|";
            		        pur += "|pur"+aryCD[j]+"|";
            		        slt += "|slt"+aryCD[j]+"|";
            		        if(j != subColNo-1){
            		            sls += "+";
            		            pur += "+";
            		            slt += "+";
            		        }
            		    }
            		    clu2ndFinal = "|fnl_hjs_bsa_capa|-("+sls+")+("+pur+")+("+slt+")+|free_add_teu_capa|";

            		}else if(chkValue == "008" && chkValue == "009"){
            		    HeadTitle0 = HeadTitle0 +"|"+vHeader;
            		    HeadTitle1 = HeadTitle1 +"|SML";
            		    for(j=0; j<subColNo; j++) HeadTitle0 = HeadTitle0 +  "|"+vHeader ;
            		    HeadTitle1 += "|" + header ;
            		    HeadTitle0 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
            		    HeadTitle1 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
            		} else {
            		    HeadTitle0 = HeadTitle0 +"|"+vHeader;
            		    HeadTitle1 = HeadTitle1 +"|SML";
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|"+vHeader ;
            		    HeadTitle0 +="|Free Addition|Free Addition|SML 2nd BSA\n(SPC control)" ;
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Other Carrier's 2nd BSA Control (by VVD)" ;
//                		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Other Carrier's 2nd final BSA After Slot Swap For SPC Control(by VVD)" ;
            		    HeadTitle0 += "|Swap\nNotice";
            		    HeadTitle1 += "|" + header + "|SPC(BOX)|WGT|SML 2nd BSA\n(SPC control)|" + header + "|Swap\nNotice|" + header + "|" + header + "|" + header;
            		    
            		    // Hidden 값(PopUp 화면에서 변경된 값을 가지고 있기위해서...
            		    //------------------------------------------------------------------
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Sale to(by VVD)";
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Purchase from(by VVD)";
            		    for(j=0; j<subColNo; j++) HeadTitle0 += "|Slot Swap(by VVD)";
            		    HeadTitle0 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
            		    HeadTitle1 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
                        // 수식
                	    // 2nd Final SML BSA = (1st Final SML BSA) - (Sal to(by VVD)) + (Purchase from(by VVD)) + (Slot Swap(by VVD)) + (Free Addition)
                	    // -- 이전꺼 >> Other Carrier's 2st final BSA = (Other Crraier's 1st final BSA) + (Sale to(by VVD)) - (Purchase from(by VVD)) + (Slot Swap(by VVD))
                	    // Other Carrier's 2st final BSA = (Other Crraier's 1st final BSA) + (Sale to(by VVD)) - (Purchase from(by VVD))
                	    //-------------------------------------------------------------------------------------------------------
            		    for(j=0; j<subColNo; j++){
            		        //arrCluLogic[j] = "|c"+aryCD[j]+"|+|sls"+aryCD[j]+"|-|pur"+aryCD[j]+"|+|slt"+aryCD[j]+"|";
            		        arrCluLogic[j] = "|c"+aryCD[j]+"|+|sls"+aryCD[j]+"|-|pur"+aryCD[j]+"|";
            		        sls += "|sls"+aryCD[j]+"|";
            		        pur += "|pur"+aryCD[j]+"|";
            		        slt += "|slt"+aryCD[j]+"|";
            		        if(j != subColNo-1){
            		            sls += "+";
            		            pur += "+";
            		            slt += "+";
            		        }
            		    }
            		    clu2ndFinal = "|fnl_hjs_bsa_capa|-("+sls+")+("+pur+")+("+slt+")+|free_add_teu_capa|";
            		    
            		}

					InitHeadRow(0, HeadTitle0, true);									//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,   "ibflag",            false);
					InitDataProperty(0, cnt++, dtData, 45, daCenter, true,	"mnl1_flg", false); //2015.12.22
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "bsa_zr_flg",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   "cost_yrwk",        false,          "",       dfDateYm,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "trd_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       65,    daCenter,  true,   "sub_trd_cd",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "slan_cd",           false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "rlane_cd",          false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "vsl_lane_tp_cd",    false,          "",       dfNone,    0,     false,       false);
//    					InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "type_flg",          false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "vsl_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "skd_voy_no",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "skd_dir_cd",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "vop_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "crr_cd",            false,          "",       dfNone,    0,     false,       false);
//    					InitDataProperty(0, cnt++ , dtHidden,     70,    daRight ,  true,   "vop_flg",           false,          "",       dfInteger, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    70,     daRight,  true,   "bsa_capa",          false,          "",       dfInteger,    0,     false,       false);

					//------------------------------------------------------------------------------------------------------------------------------------------------------
					// BSA일때 추가정보
					//------------------------------------------------------------------------------------------------------------------------------------------------------
					if(chkValue == "007"){
    					InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight,   true,    "fnl_hjs_bsa_capa", false,          "",       dfFloatOrg,       2,     false,        false);
					    for(j=0; j<subColNo; j++)InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight ,  true,    "c"+aryCD[j],       false,          "",       dfFloatOrg,       2,     false,        false);
					 
    					InitDataProperty(0, cnt++ , dtAutoSum,      80,    daRight ,  true,    "free_add_teu_capa",      false,      "",         dfInteger,       0,     true,       true);
    					InitDataProperty(0, cnt++ , dtAutoSum,      80,    daRight ,  true,    "free_add_wgt",           false,      "",         dfInteger,       0,     true,       true);
    					InitDataProperty(0, cnt++ , dtAutoSum,      100,   daRight ,  true,    "n2nd_fnl_hjs_bsa_capa",  false,      clu2ndFinal,dfInteger,       0,     false,      false);
                        for(j=0; j<subColNo; j++) InitDataProperty(0,cnt++,dtAutoSum,80,daRight,true,"s"+aryCD[j],       false,   arrCluLogic[j],dfInteger,       0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "spc_otr_swap_flg",        false,      "",         dfNone,          0,     false,      false);

                        for(j=0; j<subColNo; j++) InitDataProperty(0, cnt++ , dtHidden,      80,    daRight ,  true,    "sls"+aryCD[j],       false,   "",             dfInteger,       0,     false,       false);
                        for(j=0; j<subColNo; j++) InitDataProperty(0, cnt++ , dtHidden,      80,    daRight ,  true,    "pur"+aryCD[j],       false,   "",             dfInteger,       0,     false,       false);
                        for(j=0; j<subColNo; j++) InitDataProperty(0, cnt++ , dtHidden,      80,    daRight ,  true,    "slt"+aryCD[j],       false,   "",             dfInteger,       0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "ioc_cd",    false,          "",       dfNone,    0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "bsa_op_cd",    false,          "",       dfNone,    0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "n1st_port_etd_dt",    false,          "",       dfNone,    0,     false,       false);
    					
//    					RangeBackColor(0, 15, 0, 13+subColNo) = RgbColor(187,188,230);
    					RangeBackColor(0, 16, 0, 14+subColNo) = RgbColor(187,188,230);
//    					CellBackColor(0,17+subColNo) = RgbColor(187,188,230);
    					CellBackColor(0,18+subColNo) = RgbColor(187,188,230);
//    					RangeBackColor(1, 15, 1, 15+subColNo+2) = RgbColor(211, 219, 255);
    					RangeBackColor(1, 16, 1, 16+subColNo+2) = RgbColor(211, 219, 255);
//    					RangeBackColor(1, 16+subColNo, 1, 17+subColNo*2) = RgbColor(211, 219, 255);
    					RangeBackColor(1, 17+subColNo, 1, 18+subColNo*2) = RgbColor(211, 219, 255);
    					FrozenCols =16; //FrozenCols =15;

					//------------------------------------------------------------------------------------------------------------------------------------------------------
					// BSA일때 추가정보
					// 2008.01.15 Weight Per TEU(008),TTL Weight(009) 를 제외하고 다른 Type Size에서 Free Addtion을 할수 있도록 변경  
					//------------------------------------------------------------------------------------------------------------------------------------------------------
					} else if(chkValue != "008" && chkValue != "009"){
    					InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight,   true,    "fnl_hjs_bsa_capa", false,          "",       dfFloatOrg,       2,     true,        true);
					    for(j=0; j<subColNo; j++)InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight ,  true,    "c"+aryCD[j],       false,          "",       dfFloatOrg,       2,     true,        true);
    					InitDataProperty(0, cnt++ , dtAutoSum,      80,    daRight ,  true,    "free_add_teu_capa",      false,      "",         dfInteger,       0,     true,       true);
    					InitDataProperty(0, cnt++ , dtAutoSum,      80,    daRight ,  true,    "free_add_wgt",           false,      "",         dfInteger,       0,     true,       true);
    					InitDataProperty(0, cnt++ , dtAutoSum,      100,   daRight ,  true,    "n2nd_fnl_hjs_bsa_capa",  false,      clu2ndFinal,dfInteger,       0,     false,      false);
                        for(j=0; j<subColNo; j++) InitDataProperty(0,cnt++,dtAutoSum,80,daRight,true,"s"+aryCD[j],       false,   arrCluLogic[j],dfInteger,       0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "spc_otr_swap_flg",        false,      "",         dfNone,          0,     false,      false);

                        for(j=0; j<subColNo; j++) InitDataProperty(0, cnt++ , dtHidden,      80,    daRight ,  true,    "sls"+aryCD[j],       false,   "",             dfInteger,       0,     false,       false);
                        for(j=0; j<subColNo; j++) InitDataProperty(0, cnt++ , dtHidden,      80,    daRight ,  true,    "pur"+aryCD[j],       false,   "",             dfInteger,       0,     false,       false);
                        for(j=0; j<subColNo; j++) InitDataProperty(0, cnt++ , dtHidden,      80,    daRight ,  true,    "slt"+aryCD[j],       false,   "",             dfInteger,       0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "ioc_cd",    false,          "",       dfNone,    0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "bsa_op_cd",    false,          "",       dfNone,    0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "n1st_port_etd_dt",    false,          "",       dfNone,    0,     false,       false);

//    					RangeBackColor(0, 14, 0, 14+subColNo) = RgbColor(187,188,230);
    					RangeBackColor(0, 15, 0, 15+subColNo) = RgbColor(187,188,230);
//    					CellBackColor(0,17+subColNo) = RgbColor(187,188,230);
    					CellBackColor(0,18+subColNo) = RgbColor(187,188,230);    					
//    					RangeBackColor(1, 14, 1, 13+subColNo+2) = RgbColor(211, 219, 255);
    					RangeBackColor(1, 15, 1, 14+subColNo+2) = RgbColor(211, 219, 255);
//    					RangeBackColor(1, 16+subColNo, 1, 17+subColNo*2) = RgbColor(211, 219, 255);
    					RangeBackColor(1, 17+subColNo, 1, 18+subColNo*2) = RgbColor(211, 219, 255);
    					FrozenCols =15; //FrozenCols =14;
					//------------------------------------------------------------------------------------------------------------------------------------------------------
					}else{
    					InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight,   true,    "fnl_hjs_bsa_capa", false,          "",       dfFloatOrg,       2,     true,        true);
                        for(j=0; j<subColNo; j++)InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight ,  true,    "c"+aryCD[j],       false,          "",       dfFloatOrg,       2,     true,        true);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "ioc_cd",    false,          "",       dfNone,    0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "bsa_op_cd",    false,          "",       dfNone,    0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  true,   "n1st_port_etd_dt",    false,          "",       dfNone,    0,     false,       false);

//    					RangeBackColor(1, 14, 1, 14+subColNo) = RgbColor(211, 219, 255);
    					RangeBackColor(1, 15, 1, 15+subColNo) = RgbColor(211, 219, 255);
    					FrozenCols =15;  //FrozenCols =15; //14;
					}
						
					HeadRowHeight = 10;
					CountPosition  = 0 ;
					
					if(chkValue == "007"){
					    ColHidden("free_add_wgt")= false;
					} else if (chkValue != "008" && chkValue != "009"){
					    ColHidden("free_add_wgt")= true;
					}
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
 			comboObj.InsertItem(0, 'All' ,''); 
 			Index = 0;
 		}
 	}

	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
			    sheetObj.Editable = true;
				if(!validateForm(sheetObj,formObj,sAction))return false;
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value = fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value = fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value = fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value = fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("ESM_BSA_0104GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return false;
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_BSA_0104GS.do", bsaFormString(formObj,getParam2(curPgmNo,'S')), -1, false);
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.Down2Excel(-1, false, false, true);
				//sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;

			case IBRESET:      //생성데이터 초기화
			    if (validateForm(sheetObj,formObj,sAction)) {
			        if (ComShowConfirm(ComGetMsg('BSA10021')) == true) { //정보를 RESET 하시겠습니까?
			            formObj.f_cmd.value = COMMAND01;
			            sheetObj.DoSearch4Post("ESM_BSA_0104GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
			            var err_cd = sheetObj.EtcData("err_cd");
			            var err_msg = sheetObj.EtcData("err_msg");
			            sheetObj.RemoveEtcData();
			            
			            if (err_cd == "00000") {
			                ComShowMessage(ComGetMsg('BSA10018','RESET')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
			            }
			        }
			    }
			    break;
		}
	}

	/**
	 * rdoOpJob이 BSA(007)일경우 팝업이 열린다.
	 */
	function sheet1_OnDblClick(sheetObj, row, col){
	    var formObj     = document.form;
	    var selColName = sheetObj.ColSaveName(col);
	    
	    if(sheetObj.CellValue(row, "bsa_zr_flg")=="N"){
    	    if(selColName == 'spc_otr_swap_flg') {//swap popup open
    	        // 2008.01.15 Weight Per TEU(008),TTL Weight(009) 를 제외하고 다른 Type Size에서 Free Addtion을 할수 있도록 변경  
        	    if(!formObj.rdoOpJob[1].checked && !formObj.rdoOpJob[2].checked){
            	    var pPort_etd_dt   = sheetObj.CellValue(row, "n1st_port_etd_dt");
            	    var pTrd_cd     = sheetObj.CellValue(row, "trd_cd");
            	    var pRlane_cd   = sheetObj.CellValue(row, "rlane_cd");
            	    var pVsl_cd     = sheetObj.CellValue(row, "vsl_cd");
            	    var pSkd_voy_no = sheetObj.CellValue(row, "skd_voy_no");
            	    var pDir_cd     = sheetObj.CellValue(row, "skd_dir_cd");
            	    var pBsa_op_jb_cd = "";
            	    var selRow 		= row;
            	    
                    for(k=0; k<formObj.rdoOpJob.length; k++){
                        if(formObj.rdoOpJob[k].checked) pBsa_op_jb_cd = formObj.rdoOpJob[k].value;
                    }
            	    
            	    var param = "?pPort_etd_dt="+pPort_etd_dt+"&pTrd_cd="+pTrd_cd+"&pRlane_cd="+pRlane_cd+"&pVsl_cd="+pVsl_cd+"&pSkd_voy_no="+pSkd_voy_no+"&pDir_cd="+pDir_cd+"&f_cmd=&sRow="+selRow+"&pBsa_op_jb_cd="+pBsa_op_jb_cd;
            	    ComOpenWindow("ESM_BSA_0121.do"+param,'', 'width=800,height=430,menubar=0,status=0,scrollbars=0,resizable=0');
        	    }  
    	    } else if(selColName == 'vsl_cd' || selColName == 'skd_voy_no' || selColName == 'skd_dir_cd'){ // vessle별 BSA 팝업화면
    	        var param = "";
    	        //sheet선택내용
    	        param += "?s_cost_yrwk=" + sheetObj.CellValue(row, "cost_yrwk");
    	        param += "&s_trd_cd=" + sheetObj.CellValue(row, "trd_cd");
    	        param += "&s_rlane_cd=" + sheetObj.CellValue(row, "rlane_cd");
    	        param += "&s_ioc_cd=" + sheetObj.CellValue(row, "ioc_cd");
    	        param += "&s_vsl_cd=" + sheetObj.CellValue(row, "vsl_cd");
    	        param += "&s_skd_voy_no=" + sheetObj.CellValue(row, "skd_voy_no");
    	        param += "&s_skd_dir_cd=" + sheetObj.CellValue(row, "skd_dir_cd");
    	        
    	        //폼값
    	        param += "&" + bsaFormString(formObj,getParam2(curPgmNo));
//        	        ComOpenWindow("ESM_BSA_0143.do" + param,'', 'width=850, height=700, menubar=no, scrollbars=yes, resizable=yes');
    	        ComOpenWindowCenter("ESM_BSA_0143.do"+param,'', '850','700',true);
    	    }
    	    //더블클릭후 컬러 변화(다시 파랑으로 바꾼다.)
    	    makeLink(sheetObj);
	    } 
	   
	}

    /**
     * 마스터에만 있는 정보이면 입력 못하게한다.(상태가 Ins이면)
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
       var insStatus = sheetObj.FindStatusRow("I");
       var arrRows = insStatus.split(";"); 
       var formObj = document.form; 
       var chkValue ="";
       
        for(k=0; k<formObj.rdoOpJob.length; k++){
            if(formObj.rdoOpJob[k].checked) chkValue = formObj.rdoOpJob[k].value;
        }        

       if(formObj.rdoOpJob[1].checked){// 008 Weight Per TEU
           sheetObj.Editable = false;
       } else{
           sheetObj.Editable = true;
           // coa_bsa_vvd_otr_crr에 없는 정보일 경우 입력 불가능하게 함
           //--------------------------------------------
           for(k=0; k<arrRows.length-1; k++){
                   sheetObj.RowEditable(arrRows[k]) = false;
           }
       }
       
//           //---------------------------------------------------------------------------------------------------
//           // 2008.01.15 BSA가 아닌 다른 Type Size일 경우 Vessel의 선사의 계산수식을 "SML 2nd BSA"와 같이 변경한다.
//           //---------------------------------------------------------------------------------------------------
//           if(!formObj.rdoOpJob[0].checked && !formObj.rdoOpJob[1].checked && !formObj.rdoOpJob[2].checked) {
//               for(k=2; k<sheetObj.LastRow; k++){
//                   for(j=18+parseInt(subColNo); j<= 18+(parseInt(subColNo*2)); j++) {
//                       if("s" + sheetObj.CellValue(k,"crr_cd") == sheetObj.ColSaveName(j)) {
//                           sheetObj.InitCellProperty(k, j, dtAutoSum, daRight, sheetObj.ColSaveName(j), "|c"+sheetObj.CellValue(k,"crr_cd")+"|-" + clu2ndFinal);
//                           alert("[" + k + "," + j + "] : " + sheetObj.ColSaveName(j) + " : " + "|c" + sheetObj.CellValue(k,"crr_cd") + "|-" + clu2ndFinal);
//                       }
//                   }
//               }
//           }
       //---------------------------------------------------------------------------------------------------
      sheetObj.SumText(0,0) = "" ;
      sheetObj.SumText(0,2) = "TOTAL" ;

	  //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
	  if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol; k++) {
//    	    	  alert(k+":"+sheetObj.CellBackColor(0, k) +":"+sheetObj.CellBackColor(1, k)+":"+parseFloat(sheetObj.SumValue(0,k)))
	          if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
	             sheetObj.ColHidden(k) = true;	 
	          }else if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) != 0.00){
	        	  sheetObj.ColHidden(k) = false;	
	          }
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol; k++){
//    	    	  alert(k+":"+sheetObj.CellBackColor(0, k) +":"+sheetObj.CellBackColor(1, k)+":"+parseFloat(sheetObj.SumValue(0,k)))
	          if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){    	        	  
	              sheetObj.ColHidden(k) = false;	
				  if(chkValue == "007"){
				      sheetObj.ColHidden("free_add_wgt")= false;
				  } else if (chkValue != "008" && chkValue != "009"){
				      sheetObj.ColHidden("free_add_wgt")= true;
				  }
	          }	                         
	      }
	  }

	  //vvd칼럼, swap_notice 컬러 및 폰트 변경
	  makeLink(sheetObj);
  
    }
    
    /**
     * 커서 모양 바꾸
     */
   	function sheet1_OnMouseMove(sheetObj, button, shift, x, y){
		//var row   = sheetObj.MouseRow ;		
	    var mouseColName = sheetObj.ColSaveName(sheetObj.MouseCol);
	    
		if(mouseColName == 'vsl_cd' || mouseColName == 'skd_voy_no' || mouseColName == 'skd_dir_cd' || mouseColName == 'spc_otr_swap_flg'){
			sheetObj.MousePointer = "Hand" ;
		} 
		else{
			sheetObj.MousePointer = "Default" ;
		}

	}
    
    /**
     * vvd칼럼, swap_notice 컬러 및 폰트 변경
     */
    function makeLink(sheetObj){
	  
        sheetObj.ColFontColor("vsl_cd") = sheetObj.RgbColor(0,0,255);
        sheetObj.ColFontColor("skd_voy_no") = sheetObj.ColFontColor("vsl_cd");
        sheetObj.ColFontColor("skd_dir_cd") = sheetObj.ColFontColor("vsl_cd");
        
        sheetObj.ColFontUnderline("vsl_cd") = true;
        sheetObj.ColFontUnderline("skd_voy_no") = true;
        sheetObj.ColFontUnderline("skd_dir_cd") = true;
        
        if(!document.form.rdoOpJob[1].checked && !document.form.rdoOpJob[2].checked) {
            sheetObj.ColFontColor("spc_otr_swap_flg") = sheetObj.RgbColor(0,0,255); 
            sheetObj.ColFontUnderline("spc_otr_swap_flg") = true;
        }
    }

	/**
	 * 121화면에서 변경된 내역을 그리드에 반영한다.
	 */
	function changeRow(row, crr_cd, sls_teu, pur_teu, slt_swa_teu){
	    var sheetObj = sheetObjects[0];
	    var formObj = document.form;

	    sheetObj.CellValue(row, "sls"+crr_cd)= parseInt(sls_teu);
	    sheetObj.CellValue(row, "pur"+crr_cd)= parseInt(pur_teu);
	    sheetObj.CellValue(row, "slt"+crr_cd)= parseInt(slt_swa_teu);
//    	    sheetObj.CellValue(row, "sls"+crr_cd)= parseInt(sheetObj.CellValue(row, "sls"+crr_cd)) + parseInt(sls_teu);
//    	    sheetObj.CellValue(row, "pur"+crr_cd)= parseInt(sheetObj.CellValue(row, "pur"+crr_cd)) + parseInt(pur_teu);
//    	    sheetObj.CellValue(row, "slt"+crr_cd)= parseInt(sheetObj.CellValue(row, "slt"+crr_cd)) + parseInt(slt_swa_teu);
//    	    if(sls_teu+pur_teu+slt_swa_teu > 0){
//    	        sheetObj.CellValue(row, "spc_otr_swap_flg")="Yes";
//    	    }else{
//        	    sheetObj.CellValue(row, "spc_otr_swap_flg")="";
//    	    }
	}

	/**
	 * 121화면에서 변경된 내역을 저장 후 부모창의 내용도 동시에 저장한다.
	 */
	function parentExecute(){
	    var sheetObj = sheetObjects[0];
	    var formObj = document.form;

		if(!validateForm(sheetObj,formObj,IBSAVE))return false;
		formObj.f_cmd.value = MULTI01;
		sheetObj.DoSave("ESM_BSA_0104GS.do", bsaFormString(formObj,getParam2(curPgmNo,'S')), "", false);
	}

	/**
	 * Sheet를 초기화하고 Header를 변경한다.
	 */
	function chgOptionJob(value){
	    var sheetObj = sheetObjects[0];
	    var formObj = document.form;
//    		var sStatus = sheetObj.FindStatusRow("U");
//    		ComShowMessage(sStatus);
//    		return false;
//    	    if(sStatus != ""){
//    	        ComShowMessage(ComGetMsg());
//    	    }
		vHeader = value;
		// sheet 초기화
		//----------------------------------------------
		sheetObj.Visible  = false;
		sheetObj.Redraw = false;
		sheetObj.RemoveAll();
		sheetObj.Reset();
		ComConfigSheet(sheetObj);
		initSheet(sheetObj, 1, formObj.header.value);
	    //ComEndConfigSheet(sheetObj);
		sheetObj.Redraw = true;
		sheetObj.Visible  = true;

		// sheet 조회
		//----------------------------------------------
	    if(formObj.txtYear.value != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
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
                formObj.param5.value = "";
                formObj.param6.value = "";
                formObj.param7.value = formObj.txtFmWeek.value;
                formObj.param8.value = formObj.txtToWeek.value;
                fm_wk = formObj.txtFmWeek.value;
                to_wk = formObj.txtToWeek.value;
            } else {
                formObj.param5.value = formObj.txtFmMonth.value;
                formObj.param6.value = formObj.txtToMonth.value;
                formObj.param7.value = "";
                formObj.param8.value = "";
                fm_mon = formObj.txtFmMonth.value;
                to_mon = formObj.txtToMonth.value;
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
			    ComShowMessage(ComGetMsg("COM12114", "Year", ""));
			    txtYear.focus();
				return false;
			}
			if (txtFmMonth.value != "" && txtToMonth.value == "") {
			    ComShowMessage(ComGetMsg("COM12114", "month", ""))
			    txtToMonth.focus();
			    return false;
			}
			if (txtFmMonth.value == "" && txtToMonth.value != "") {
			    ComShowMessage(ComGetMsg("COM12114", "month", ""));
			    txtFmMonth.focus();
			    return false;
			}
//    			if (txtFmMonth.value != "" && txtToMonth.value != "") { 
//    			    if(txtFmMonth.value > txtToMonth.value){
//    			        ComShowMessage(ComGetMsg("COM12133","from Month"," to Month","작은값"));
//    			        txtFmMonth.value = "";
//    			        txtToMonth.value = "";
//    			        txtFmMonth.focus();
//    			        return false;
//    			    }
//    			}

			if (txtFmWeek.value != "" && txtToWeek.value == ""){
			    ComShowMessage(ComGetMsg("COM12114", "week", ""));
			    txtToWeek.focus();
			    return false;
			}
			if (txtFmWeek.value == "" && txtToWeek.value != ""){
			    ComShowMessage(ComGetMsg("COM12114", "week", ""));
			    txtFmWeek.focus();
			    return false;
			}
			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
//    			    ComShowMessage(ComGetMsg("COM12138", "month", "week"));
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

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//    		    if(!chkValidSearch()) return false;
			if (txtYear.value == "") {
			    ComShowMessage(ComGetMsg("COM12114", "Year", ""));
			    txtYear.focus();
				return false;
			}
			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
			    ComShowMessage(ComGetMsg("COM12138", "month", "week"));
			    return false;
			}
			if((chkPrd[1].checked && txtFmMonth.value == "" && txtToMonth.value == "") 
			   && txtVsl_cd.value == "" && txtSkd_voy_no.value == "" && txtDir_cd.value == ""){
			    ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
			    return false;
			}
			if((chkPrd[0].checked && txtFmWeek.value == ""  && txtToWeek.value == "") 
			   && txtVsl_cd.value == "" && txtSkd_voy_no.value == "" && txtDir_cd.value == ""){
			    ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
			    return false;
			}			
			
//    			if(formObj.cobTrade.value == "" && formObj.txtVsl_cd.value == ""){  
//    	            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//    	            return false;
//    	        }
//    	        
//	            if(formObj.cobLane.value == "" && formObj.txtVsl_cd.value == ""){
//	                ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//	                return false;
//	            }
			//msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
			if (chkPrd[1].checked && txtFmMonth.value != "" && txtToMonth.value != "") {
				if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
					ComAlertFocus(txtToMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
					return false;
				}
			}
			if (chkPrd[0].checked && txtFmWeek.value != "" && txtToWeek.value != "") {
				if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
					ComAlertFocus(txtToWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
					return false;
				}
			}
		}

		return true;
	}

	/* 개발자 작업  끝 */