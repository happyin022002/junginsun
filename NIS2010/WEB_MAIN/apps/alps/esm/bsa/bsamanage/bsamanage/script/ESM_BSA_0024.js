// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var aryNo1 = 0;      //동적해더의 갯수
var aryNo2 = 0;      //동적해더의 갯수

var sheet_height1 = 20; // sheet1의 height
var sheet_height2 = 20; // sheet2의 height
var first_load1 = true;
var first_load2 = true;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_new":
                    sheetObject.RemoveAll();
                    formObject.reset();
                    break;

                case "btn_retrieve":
                    if(formObject.rdoOp_cd[0].checked){
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    }else{
                        doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
                    }
                    break;

                case "btn_save":
                    if(formObject.rdoOp_cd[0].checked){
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                    }else{
                        doActionIBSheet2(sheetObject2,formObject,IBSAVE);
                    }
                    break;

//                case "btn_create":
//                    doActionIBSheet(sheetObject,formObject,IBCREATE);
//                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    //doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
                    break;

                case "btns_calendar1":
                     var cal = new ComCalendar();
                     cal.select(formObject.txtSDate, 'yyyy-MM-dd');
                    break;

                case "btns_calendar2":
                     var cal = new ComCalendar();
                     cal.select(formObject.txtEDate, 'yyyy-MM-dd');
                    break;

    			case "bu_zoom_in1": //next
    			case "bu_zoom_in2":
                    if (formObject.rdoOp_cd[0].checked) {
        				sheet_height1 = getSheetHeightCnt(sheetObject,"MAX",1);
        				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height1);
        				div_zoom_in1.style.display = "none";
        				div_zoom_out1.style.display = "inline";
        				parent.syncHeight();
                    } else {
        				sheet_height2 = getSheetHeightCnt(sheetObject2,"MAX",1);
        				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
        				div_zoom_in2.style.display = "none";
        				div_zoom_out2.style.display = "inline";
        				parent.syncHeight();
                    }
                    
    				break;
    
    			case "bu_zoom_out1": //next
    			case "bu_zoom_out2":
                    if (formObject.rdoOp_cd[0].checked) {
        				sheet_height1 = getSheetHeightCnt(sheetObject,"MIN",0);
        				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height1);
        				div_zoom_in1.style.display = "inline";
        				div_zoom_out1.style.display = "none";
        				parent.syncHeight();
                    } else {
        				sheet_height2 = getSheetHeightCnt(sheetObject2,"MIN",0);
        				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
        				div_zoom_in2.style.display = "inline";
        				div_zoom_out2.style.display = "none";
        				parent.syncHeight();
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }
     
    /**
 	 * IBCombo Object를 배열로 등록
 	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 	 * 배열은 소스 상단에 정의
 	*/
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(jHeader, sHeader) {
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1, jHeader, sHeader);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		// 멀티콤보 처리
		//---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
        
    }
 	
    /**
     * 
     * @return
     */
 	function loadCombo() {
     	var formObj = document.form;
  		var sXml = formObj.sXml.value;

  		var arrXml = sXml.split("|$$|");
 		
 		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
  		document.form.sXml.value="";
      }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, jHeader, sHeader) {
        var cnt = 0;
        var aryNM = "";
        var colNo = 0;
        var formObj = document.form;
        var selOp_jb_cd = "";
        for(k=0; k<formObj.rdoOp_jb_cd.length; k++){
            if(formObj.rdoOp_jb_cd[k].checked) selOp_jb_cd = formObj.rdoOp_jb_cd[k].value;
        }

        switch(sheetNo) {
            case 1:      //sheet1 init
                if(jHeader != ""){ 
                     aryNM = jHeader.split("|");
                } else {
                     aryNM = "crr|crr|crr|crr|crr".split("|");
                }
                aryNo1 = aryNM.length;
                colNo = aryNo1 + 17;

                with (sheetObj) {
                    if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
			        first_load1 = false;
                    
                    SheetWidth = mainTable1.clientWidth;         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;              //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 15 , 0, true);         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);    // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                    var txtTitle = "Other Carrier's Final BSA After Slot Swap For SPC Control"
                    var HeadTitle0 = "STS|SEL|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|OPR|VVD|VSL\nCapa.|vsl_capa|BSA\nCapa.|Own Vsl\nWeight|Final\nSML BSA";
                    for(j=0; j<aryNo1; j++){
                        HeadTitle0 = HeadTitle0 + "|" + txtTitle;
                    }
                    HeadTitle0 = HeadTitle0 + "|Others' Swap\nNotice|compare";
                    j=0;
                    var HeadTitle1 = "STS|SEL|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|OPR|VVD|VSL\nCapa.|vsl_capa|BSA\nCapa.|Own Vsl\nWeight|Final\nSML BSA"
                    for(j=0; j<aryNo1; j++){
                        HeadTitle1 = HeadTitle1 + "|" + aryNM[j];
                    }
                    HeadTitle1 = HeadTitle1 + "|Others' Swap\nNotice|compare";
                    InitHeadRow(0, HeadTitle0, true);           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++ ,     dtHiddenStatus, 30,    daCenter, true,    "ibflag");
                    InitDataProperty(0,     cnt++ ,     dtCheckBox,     30,    daCenter, true,    "chkBox");
                    InitDataProperty(0,     cnt++,      dtData,         30,     daCenter,       true,       "bsa_seq",          false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         70,     daCenter,       true,       "bsa_fm_dt",        false,      "",     dfDateYmd,      0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         70,     daCenter,       true,       "bsa_to_dt",        false,      "",     dfDateYmd,      0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         50,     daCenter,       true,       "trd_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         50,     daCenter,       true,       "rlane_cd",         false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         40,     daCenter,       true,       "dir_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         40,     daCenter,       true,       "vop_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtData,         80,     daCenter,       true,       "vvd_cd",           false,      "",     dfNone,         0,      false,      false);
                                                                        
                    InitDataProperty(0,     cnt++,      dtData,         60,     daRight,        true,       "",         false,      "",     dfInteger,      0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtHidden,       60,     daRight,        true,       "vsl_capa",         false,      "",     dfFloatOrg,      3,      false,      false);
                    InitDataProperty(0,     cnt++,      dtAutoSum,      60,     daRight,        true,       "bsa_capa",         false,      "",     dfInteger,      0,      false,      false);
//                  InitDataProperty(0,     cnt++,      dtAutoSum,      60,     daRight,        true,       "SML",              false,      "",     dfInteger,      0,      true,       true);
                    j=0;
                    if(selOp_jb_cd == "009"){
                        InitDataProperty(0,     cnt++,      dtAutoSum,  60,     daRight,        true,       "ownr_vsl_wgt",      false,      "",     dfFloatOrg,       2,      true,       true);
                    }else{
                        InitDataProperty(0,     cnt++,      dtAutoSum,  60,     daRight,        true,       "ownr_vsl_wgt",      false,      "",     dfFloatOrg,       2,      false,       false);
                    }
				    InitDataProperty(0,     cnt++,      dtAutoSum,  60,     daRight,        true,       "SML",              false,      "",     dfFloatOrg,       2,      true,       true);
                    for(j=0; j<aryNo1; j++)InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight ,  true,    aryNM[j],   false,      "",     dfFloatOrg,       2,      true,        true);
                    InitDataProperty(0,     cnt++,      dtData,     100,    daCenter,       true,       "swapYN",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++,      dtHidden,   300,    daCenter,       true,       "compare",          false,      "",     dfNone,         0,      false,      false);

                    RangeBackColor(1, 14, 1, 14+aryNo1) = RgbColor(211, 219, 255);
                    HeadRowHeight = 10;
                    CountPosition  = 0 ;
                }
                break;

            case 2:      //sheet1 init
                if(sHeader != ""){ 
                     aryNM = sHeader.split("|");
                } else {
                     aryNM = "crr|crr|crr|crr|crr".split("|");
                }
                aryNo2 = aryNM.length;
                colNo = aryNo2 + 11;
                with (sheetObj) {
                    if (first_load2 == true) { style.height = GetSheetHeight(sheet_height2); }
			        first_load2 = false;
			        
                    SheetWidth = mainTable2.clientWidth;                     //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                              //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                        //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 2, 1, 9, 100);                             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 11 , 0, true);                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false) ;    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    var txtTitle = "Other Carrier's Final BSA After Slot Swap For SPC Control"
                    var HeadTitle0 = "STS|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|VVD|Vessel|V.Seq|Final\nSML BSA";
                    for(j=0; j<aryNo2; j++){
                        HeadTitle0 = HeadTitle0 + "|" + txtTitle;
                    }
                    j=0;
                    var HeadTitle1 = "STS|BSA\nSEQ|From|To|Trade|R.Lane|Dir.|VVD|Vessel|V.Seq|Final\nSML BSA"
                    for(j=0; j<aryNo2; j++){
                        HeadTitle1 = HeadTitle1 + "|" + aryNM[j];
                    }

                    
                    InitHeadRow(0, HeadTitle0, true);           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);
                    
                    
//                    var HeadTitle = "STS|BSA SEQ|From|To|Trade|R.Lane|Dir.|VVD|Vessel|V.Seq|Final SML BSA";
//                    HeadTitle = HeadTitle + header;
//                    InitHeadRow(0, HeadTitle, false);                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성 [ROW,   COL,        DATATYPE,   WIDTH,      DATAALIGN,      COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++ ,     dtHiddenStatus,30,     daCenter,       true,      "ibflag");
                    InitDataProperty(0,     cnt++ ,     dtData,     30,        daCenter,       true,      "bsa_seq",          false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     70,        daCenter,       true,      "bsa_fm_dt",        false,      "",     dfDateYmd,      0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     70,        daCenter,       true,      "bsa_to_dt",        false,      "",     dfDateYmd,      0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     50,        daCenter,       true,      "trd_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     50,        daCenter,       true,      "rlane_cd",         false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     40,        daCenter,       true,      "dir_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     80,        daCenter,       true,      "vvd_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     80,        daCenter,       true,      "vsl_cd",           false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtData,     50,        daCenter,       true,      "vsl_seq",          false,      "",     dfNone,         0,      false,      false);
                    InitDataProperty(0,     cnt++ ,     dtAutoSum,  100,       daRight ,       true,      "SML",              false,      "",     dfFloatOrg,        2,      true,       true);
                    for(j=0; j<aryNo2; j++)InitDataProperty(0, cnt++ , dtAutoSum,    80,     daRight ,  true,    aryNM[j],    false,      "",     dfFloatOrg,       2,      true,        true);
  
                    HeadRowHeight = 10;
                    CountPosition = 0 ;
                    RangeBackColor(1, 10, 1, 10+aryNo2) = RgbColor(211, 219, 255);
                }
                break;
        }
    }

    /**
 	 * 콤보 항목을 설정한다. by.yjjeon
 	 */
    function initCombo (comboObj, comboNo) {
 		with (comboObj) {
 			DropHeight = 300;
 			comboObj.InsertItem(0, 'All' ,''); 
 			Index = 0;
 		}
 	}
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObject2 = sheetObjects[1];
        formObj.target = "";

        switch(sAction) {
			case IBCLEAR:          //조회
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = document.form.sXml.value;
		
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				//			alert(State)
				//			if(State == "S"){ 
				//				ComShowMessage(OBJECT_ERROR);
				//				ComOpenWait(false);
				//				return;
				//			}	
				var arrXml = sXml.split("|$$|");
		
		
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
				document.form.sXml.value="";
				ComOpenWait(false);
				break;
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch4Post("ESM_BSA_0024GS.do", bsaFormString(formObj,getParam(curPgmNo)));
                break;

            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction))return false;
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSave("ESM_BSA_0024GS.do",bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
                break;

            case IBCREATE:     // create
                if(!validateForm(sheetObj, formObj, sAction)) return false;
                formObj.f_cmd.value = COMMAND01;
                sheetObj.DoSearch4Post("ESM_BSA_0024GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')));
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                //alert(excelType):
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

        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:          //조회
           
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                formObj.f_cmd.value = SEARCHLIST03;
                sheetObj.DoSearch4Post("ESM_BSA_0024GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
                break;

            case IBSAVE:            //저장
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                formObj.f_cmd.value = MULTI03;
                sheetObj.DoSave("ESM_BSA_0024GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')));
                break;

//            case IBDOWNEXCEL:       //엑셀 다운로드
//                sheetObj.SpeedDown2Excel(-1);
//                break;

        }
    }

    /**
     * Other Carrier's Slot Swap PopUp 화면 Open
     */
    function sheet1_OnDblClick(sheetObj , row, col , value) {
        var formObj = document.form;
        var findRows = "";
        //var findStr = "";
        var pBsa_seq      = "";
        var pTrd_cd       = "";
        var pRlane_cd     = "";
        var pDir_cd       = "";
        var pVop_cd       = "";
        var pVsl_capa     = "";
        var pBsa_op_cd    = "";
        var pBsa_op_jb_cd = "";
        var pBsa_fm_dt    = "";
        var pBsa_to_dt    = "";
        var selRow        = "";
        var param         = "";
        
        
        // Joint Operating시에 BSA일경우 PopUp을 띄운다.
        //------------------------------------------------------------------------
        if(formObj.rdoOp_jb_cd[0].checked && sheetObj.colSaveName(col)== "swapYN"){
            // Double click한 행은 디폴트로 선택되어 지게 한다.
            //----------------------------------------------------
            sheetObj.CellValue(row, "chkBox") = 1;
        
            // 선택된 Row의 key정보를 String으로 만든다.
            //----------------------------------------------------------------
            pBsa_seq   = sheetObj.CellValue(row, "bsa_seq");
            pTrd_cd    = sheetObj.CellValue(row, "trd_cd");
            pRlane_cd  = sheetObj.CellValue(row, "rlane_cd");
            pDir_cd    = sheetObj.CellValue(row, "dir_cd");
            pVop_cd    = sheetObj.CellValue(row, "vop_cd");
            pVsl_capa  = sheetObj.CellValue(row, "vsl_capa");
            pBsa_fm_dt = sheetObj.CellValue(row, "bsa_fm_dt");
            pBsa_to_dt = sheetObj.CellValue(row, "bsa_to_dt");
            pBsa_op_cd = "J";
            pBsa_op_jb_cd = "";
            for(i=0; i<formObj.rdoOp_jb_cd.length; i++){
                if(formObj.rdoOp_jb_cd[i].checked){
                  pBsa_op_jb_cd = formObj.rdoOp_jb_cd[i].value;
                }
            }
            // 선택된 행의 특정 값들을 xml string으로 만든다.
            //-----------------------------------------------------------------
//            var sXml = ComMakeSearchXml(sheetObj, false, "chkBox","ibflag|bsa_seq|trd_cd|rlane_cd|dir_cd|vop_cd|vsl_capa|bsa_fm_dt|bsa_to_dt");
//            formObj.sXml.value= sXml;
            
            param     = "?pBsa_seq="+pBsa_seq
                       +"&pTrd_cd="+pTrd_cd
                       +"&pRlane_cd="+pRlane_cd
                       +"&pDir_cd="+pDir_cd
                       +"&pVop_cd="+pVop_cd
                       +"&pVsl_capa="+pVsl_capa
                       +"&pBsa_op_cd="+pBsa_op_cd
                       +"&pBsa_op_jb_cd="+pBsa_op_jb_cd
                       +"&pBsa_fm_dt="+pBsa_fm_dt
                       +"&pBsa_to_dt="+pBsa_to_dt
                       +"&f_cmd="+SEARCH
                       +"&sRow="+row;
//                       +"&sXml="+sXml;
            
            formObj.f_cmd.value = SEARCH;
//            ComOpenWindow('ESM_BSA_0122.do'+param, '', 'width=685,height=450,menubar=0,status=0,scrollbars=0,resizable=0',true);
            ComOpenWindowCenter('ESM_BSA_0122.do'+param, '', 605,450,true);
        }
     }

    /**
     * SLOT SWAP 후 재조회
     */
    function retrieve(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
        
    }
    
    function checkFalse(){
        var sheetObj = sheetObjects[0];
        
        sheetObj.CheckAll("chkBox") = 0;
    }
    
    /**
     * sheet의 데이터 변경시 
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        var selOp_jb_cd = "";
        for(k=0; k<formObj.rdoOp_jb_cd.length; k++){
            if(formObj.rdoOp_jb_cd[k].checked) selOp_jb_cd = formObj.rdoOp_jb_cd[k].value;
        }
        
        // 009
        //----------------------------------------------------
        if(selOp_jb_cd == "009") {
            // HJS 정보를 계산한다.
            // Own Vessel Weight - SUM(Carrier)
            //------------------------------------------------------------------------
            if( sheetObj.ColSaveName(col) != "SML"){
                var aryNM = formObj.jHeader.value.split("|");
                var aryNo = aryNM.length;
                var sumCrr = "0";
                
                if(sheetObj.CellValue(row, "ownr_vsl_wgt") == "0"){
                    //if(sheetObj.CellValue(row, "SML") == sheetObj.CellSearchValue(row, "SML")){
                    // own vessel weight가 0일경우 other carrier가 변경이 될때
                    // HJS가 변경되지 않토록하기 위해서 체크함
                    //----------------------------------------------------------------
                    if(sheetObj.ColSaveName(col) == "ownr_vsl_wgt"){
                        sheetObj.CellValue(row, "SML") = "0";
                    }
                    //----------------------------------------------------------------
                } else {
                    //
                    for(j=0; j<aryNo; j++){
                         sumCrr = parseFloat(sumCrr) + parseFloat(sheetObj.CellValue(row, aryNM[j])); 
                    }
                    sheetObj.CellValue(row, "SML") = parseFloat(sheetObj.CellValue(row, "ownr_vsl_wgt")) - parseFloat(sumCrr);
                }
            }
        }
        
    }

    /**
     *
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var rows = sheetObj.LastRow;
        for ( var i = 1 ; i < rows+1 ; i ++){
            sheetObj.CellFontUnderLine(i , "a") = true;
        }
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,1) = "";
        sheetObj.SumText(0,2) = "";
        sheetObj.SumText(0,"bsa_to_dt") = "TOTAL" ;
        
        //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
        if(document.form.isExcludZero.checked) {
            for(var k=0; k<=sheetObj.LastCol; k++) {

                //if(sheetObj.LastCol-3 <= k){
                //    alert(sheetObj.ColSaveName(k));
                //}
                
                //Title 필터링 -- 추가 2009.08.25 by kim ki dae
                if(k >= 12 && sheetObj.ColSaveName(k) != "swapYN" 
                           && sheetObj.ColSaveName(k) != "compare"){ 
                    if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                        sheetObj.ColHidden(k) = true;	 
                    }
                }
            }
        } else {
            for(var k=0; k<=sheetObj.LastCol; k++) {
                //if(sheetObj.LastCol-3 <= k){
                //    alert(sheetObj.ColSaveName(k));
                //}
                  
                //Title 필터링 -- 추가 2009.08.25 by kim ki dae
                if(k >= 12 && sheetObj.ColSaveName(k) != "swapYN" 
                           && sheetObj.ColSaveName(k) != "compare"){ 
                    if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                        sheetObj.ColHidden(k) = false;	            
                    }
                }
            }	      
        }    
    }
    
    /**
     *
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,1) = "";
        sheetObj.SumText(0, "bsa_to_dt") = "TOTAL";
        
        //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
        if(document.form.isExcludZero.checked) {
            for(var k=0; k<=sheetObj.LastCol; k++) {

                //Title 필터링 -- 추가 2009.08.25 by kim ki dae
                if(k >= 10){ 
                    if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                        sheetObj.ColHidden(k) = true;
                    }
                }

            }
        } else {
            for(var k=0; k<=sheetObj.LastCol; k++) {
                
                //Title 필터링 -- 추가 2009.08.25 by kim ki dae
                if(k >= 10){ 
                    sheetObj.ColHidden(k) = false;	
                }

            }	      
        }          
    }
    
    /**
     * trade코드 변경시 rlane리스트를 리플래쉬한다.
     */
    function cobTrade_OnChange(obj){
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
     * bsa_op_jb_cd가 변경되었을때 스크립트 처리
     *   BSA일때 others' swap 항목을 보여준다
     *   TTL Weight 일때 carrier capa 수정불가
     */
    function chgBsaOpJb(values, title){
        var formObj = document.form;
        var sheetObj;

        if(formObj.rdoOp_cd[0].checked){
            sheetObj = sheetObjects[0];
        }else{
            sheetObj = sheetObjects[1];
        }

        // BSA일때와 다른 op_jb_cd일때와 해더정보의 Final SML정보를 다르게 보여준다.
        // Joint Operation BSA일 경우만 otheros Swap을 할수 있도록한다
        //------------------------------------------------------------------------------
        if(formObj.rdoOp_cd[0].checked){
    		// sheet 초기화
    		//----------------------------------------------
    		sheetObj.Visible  = false;
    		sheetObj.Redraw = false;
    		sheetObj.RemoveAll();
    		sheetObj.Reset();
    		ComConfigSheet(sheetObj);
    		initSheet(sheetObj, 1, formObj.jHeader.value,"");
    	    //ComEndConfigSheet(sheetObj);
    		sheetObj.Redraw = true;
    		sheetObj.Visible  = true;
    		//----------------------------------------------
		   if(values == "007"){
                sheetObj.CellText(0,"SML") = "Final\nSML BSA";
                sheetObj.CellText(1,"SML") = "Final\nSML BSA";
                //for(j=0; j<aryNo; j++) sheetObj.CellText(0,12+j)=title;
                sheetObj.CellBackColor(1,"SML")=sheetObj.RgbColor(170,185,255);
                sheetObj.FrozenCols = 14;
                sheetObj.ColHidden("swapYN") = false;
            }else{
                for(j=0; j<aryNo1+1; j++) sheetObj.CellText(0,13+j)=title;
                sheetObj.CellText(1, "SML") = "SML";
                sheetObj.CellBackColor(1,"SML") = sheetObj.RgbColor(170,185,255);
                sheetObj.FrozenCols = 13;
                sheetObj.ColHidden("swapYN") = true;
            }
        } else {
    		// sheet 초기화
    		//----------------------------------------------
    		sheetObj.Visible  = false;
    		sheetObj.Redraw = false;
    		sheetObj.RemoveAll();
    		sheetObj.Reset();
    		ComConfigSheet(sheetObj);
    		initSheet(sheetObj, 2, "", formObj.sHeader.value);
    	    //ComEndConfigSheet(sheetObj);
    		sheetObj.Redraw = true;
    		sheetObj.Visible  = true;
    		//----------------------------------------------
		   if(values == "007"){
                sheetObj.CellText(0,"SML") = "Final\nSML BSA";
                sheetObj.CellText(1,"SML") = "Final\nSML BSA";
                //for(j=0; j<aryNo; j++) sheetObj.CellText(0,12+j)=title;
                sheetObj.CellBackColor(1,"SML")=sheetObj.RgbColor(170,185,255);
                sheetObj.FrozenCols = 11;
                sheetObj.ColHidden("swapYN") = false;
            }else{
                for(j=0; j<aryNo2+1; j++) sheetObj.CellText(0,10+j)=title;
                sheetObj.CellText(1, "SML") = "SML";
                sheetObj.CellBackColor(1,"SML") = sheetObj.RgbColor(170,185,255);
                sheetObj.FrozenCols = 10;
                sheetObj.ColHidden("swapYN") = true;
            }
            
        }

        // 자동조회한다.
        //------------------------------------------------------------------------------
        if(formObj.rdoOp_cd[0].checked){
            if(formObj.txtSDate.value != "") doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }else{
            if(formObj.txtSDate.value != "") doActionIBSheet2(sheetObj,formObj,IBSEARCH);
        }
        //------------------------------------------------------------------------------

    }

    /**
     * bsa_op_cd 체크박스 클릭시 화면 이동
     * gubun :1 >> Joint Operation
     *        2 >> Space Chartering
     */
    function changeView(gubun){
        var formObj = document.form;
        var sheetObj = sheetObjects[1];

        if(gubun == "1"){
            document.getElementById("rdoLayer1").style.display = "inline";
            document.getElementById("rdoLayer2").style.display = "none";
        } else if(gubun == "2") {
            document.getElementById("rdoLayer1").style.display = "none";
            document.getElementById("rdoLayer2").style.display = "inline";
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (formObj.txtSDate.value == "") {
                // [COM12114] : Period를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114","Period"));
                return false;
            }
            
            
            // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
            if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
                if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
                    //ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element')); 
                    //txtEDate.focus();
                    ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
                    return false;
                }
            }

//            if(formObj.cobTrade.value == ""){
//                ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//                return false;
//            }
//            
//            if(formObj.cobLane.value == ""){
//                ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//                return false;
//            }
/* 
            if(formObj.cobDir.value == ""){
                ComAlertFocus(cobDir, ComGetMsg('COM12113','Dir'));
                return false;
            }
*/ 
        }

        return true;
    }


    /**
     * Excel Dowload시 사용
     * 사용 : var rtn = selectDownExcelMethod(sheetObj);
     * (2007.4.13 - Kevin.KIM)
     *
     * @param sheetObj : sheet
     * @return String
     *         NODATA = Not Found Data
     *         AY = Down2Excel(0, false, false, true);
     *         DY = Down2Excel(-1, false, false, true);
     *         AN = SpeedDown2Excel(0, false, false);
     *         DN = SpeedDown2Excel(-1, false, false);
     *         CANCEL = Cancel + Window Close
     */
    function selectDownExcelMethod(sheetObj){
    	if(sheetObj.RowCount == 0){
    		sheetObj.Down2Excel(-1, false, false, true);
    		return "NODATA";
    	}
    	var sFeature = "";
    	sFeature = sFeature + "dialogHeight:200px;"
    	sFeature = sFeature + "dialogWidth:350px;"
    	sFeature = sFeature + "center:yes;"
    	sFeature = sFeature + "resizable:no;"
    	sFeature = sFeature + "scroll:no;"
    	sFeature = sFeature + "status:no;"
    	var rtn = window.showModalDialog("ESM_BSA_3002.do", "", sFeature);
    	return rtn;
    }