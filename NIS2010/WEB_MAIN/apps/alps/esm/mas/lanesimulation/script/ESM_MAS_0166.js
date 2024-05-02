/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_MAS_0166.js
*@FileTitle     : LaneSimulation >> Step1 >> VSL & BSA I/F(POPUP)
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.24
*@LastModifier  : 이연각
*@LastVersion   : 1.1
* 2006-08-28 eunju park
* 1.0 최초 생성
* =======================================================
* History
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.07.20 윤진영 Alps전환작업
* 2009.09.19 윤진영 [CHM-200901026] SC lane을 이용하여 simulation 진행할경우 vessel table에서 관리 되지 않는 vessel인
*            경우가 대부분(타사선이기 때문)  그로 인해 vessel 및 BSA정보를 I/F 받아오지 못함 처리
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.05.25 윤진영 CHM-200901719 UI개선
*            - open시 f_fm_wk 에 마우스 포커스
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
========================================================= */
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
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

                case "btn_close":
                    window.close();
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        document.form.f_fm_wk.focus();
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj) {
        var cnt = 0;

        with (sheetObj) {

            SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
            MergeSheet =  msHeaderOnly;                            //전체Merge 종류 [선택, Default msNone]
            Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
            InitRowInfo( 3, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitColumnInfo(42, 5 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다

            var HeadTitle0 = "SEL|Vessel|DIR|OPR|OPR2|VSL\nCapa|BSA\nCapa|vsl_clss_capa|port_clss_capa|Final\nSML BSA|"+
                             "Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|"+
                             "Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|Joint Operation Carrier's BSA(Cht-Out)|"+
                             "Lease|Lease|Lease|Lease|Lease|" +
                             "Lease|Lease|Lease|Lease|Lease|" +
                             "Charter in|Charter in|Charter in|Charter in|Charter in|" +
                             "Charter in|Charter in|Charter in|Charter in|Charter in|vsl_flg" ;

            var HeadTitle1 = "SEL|Vessel|DIR|OPR|OPR2|VSL\nCapa|BSA\nCapa|vsl_clss_capa|port_clss_capa|Final\nSML BSA|"+
                             "OTH1|OTH1|OTH2|OTH2|OTH3|OTH3|OTH4|OTH4|OTH5|OTH5|"+
                             "OTH1|OTH1|OTH2|OTH2|OTH3|OTH3|OTH4|OTH4|OTH5|OTH5|"+
                             "OTH1|OTH1|OTH2|OTH2|OTH3|OTH3|OTH4|OTH4|OTH5|OTH5|vsl_flg";

            var HeadTitle2 = "SEL|Vessel|DIR|OPR|OPR2|VSL\nCapa|BSA\nCapa|vsl_clss_capa|port_clss_capa|Final\nSML BSA|"+
                             "TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|"+
                             "TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|"+
                             "TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|TEU|Slot Price|vsl_flg";

            InitHeadRow(0, HeadTitle0, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(1, HeadTitle1, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(2, HeadTitle2, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

            //데이터속성[    ROW,    COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
            InitDataProperty(0,     cnt++,  dtCheckBox, 30,     daCenter,   true,     "chk_sel",          false,      "",        dfNone,    0,          true,      true);
//            InitDataProperty(0,     cnt++,  dtData,     60,     daCenter,   true,     "cost_yrwk",     false,      "",        dfNone,    0,          false,      false);
            InitDataProperty(0,     cnt++,  dtData,     50,     daCenter,   true,     "vsl_cd",            false,      "",        dfNone,    0,          false,      false);
//            InitDataProperty(0,     cnt++,  dtData,     50,     daCenter,   true,     "skd_voy_no",         false,      "",        dfNone,    0,          false,      false);
            InitDataProperty(0,     cnt++,  dtData,     40,     daCenter,   true,     "skd_dir_cd",         false,      "",        dfNone,    0,          false,      false);
            InitDataProperty(0,     cnt++,  dtData,     40,     daCenter,   true,     "vsl_oshp_cd",        false,      "",        dfNone,      0,           false,       false);
            InitDataProperty(0,     cnt++,  dtData,     40,     daCenter,   true,     "vop_cd",        false,       "",        dfNone,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,    true,     "vsl_clss_capa",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,    true,     "bsa_capa",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtHidden,   60,     daRight,    true,     "vsl_clss",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtHidden,   60,     daRight,    true,     "port_clss_capa",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,    true,     "fnl_hjs_bsa_capa",        false,       "",        dfNumber,      0,          false,       false);

            //joint
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00101",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00101",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00102",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00102",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00103",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00103",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00104",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00104",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00105",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00105",        false,       "",        dfNumber,      0,          false,       false);

            //lease
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00201",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00201",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00202",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00202",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00203",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00203",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00204",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00204",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00205",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00205",        false,       "",        dfNumber,      0,          false,       false);

            //chater in
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00301",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00301",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00302",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00302",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00303",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00303",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00304",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00304",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "bsa00305",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,     60,     daRight,   true,     "amt00305",        false,       "",        dfNumber,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtHidden,   60,     daRight,   true,     "vsl_flg",        false,       "",        dfNone,      0,          false,       false);
            InitDataProperty(0,     cnt++,  dtData,      5,     daRight,   false,     "",        false,       "",        dfNone,      0,          false,       false);
            HeadRowHeight =10;

            //FitSize(false, true);
            CountPosition  = 0 ;
            style.height = GetSheetHeight(18) ;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_MAS_0166GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                var sheetObj1 = opener.sheetObjects[0]; // 부모창의 Lane sheet
                var sheetObj2 = opener.sheetObjects[1]; // 부모창의 vessel sheet
                var findText = sheetObj.FindCheckedRow("chk_sel");
                var arrIndex = findText.split("|");
                var cnt = arrIndex.length-1;

                // 부모창의 정보들
                var freq_no = sheetObj1.CellValue(sheetObj1.SelectRow,"freq_no");   // 전체 선택할수 있는 Vessel의 개수
                var s_cnt   = parseInt(freq_no) - parseInt(sheetObj2.RowCount("R"));
                var v_rowcnt= sheetObj2.LastRow;        // Vessel sheet의 총 Row 수

                var l = 0;

                for(j=0; j<cnt; j++){
                    // frequence 만큼 Row가 생성되어 있지 않으면 체크하여 로를 생성한다.
//                    if(freq_no > (parseInt(sheetObj2.RowCount)-1)){
                    if(cnt > (parseInt(sheetObj2.RowCount("I")))){
                        sheetObj2.SelectRow=parseInt(sheetObj2.LastRow-1);
                        sheetObj2.DataInsert();
                    }

                    // Read,Delete 상태 다음행부터 데이터를 넣는다.
                    if(sheetObj2.RowCount("I")>0){
                        if((parseInt(sheetObj2.RowCount("R"))+parseInt(sheetObj2.RowCount("D")))>0){
                            l= j+1+parseInt(sheetObj2.RowCount("R"))+parseInt(sheetObj2.RowCount("D"));
                        } else {
                            l= j+2;
                        }
                    } else {
                        l = sheetObj2.LastRow-1;
                    }
                    sheetObj2.CellValue2(l, "sect_no")          = formObj.f_sect_no.value;
                    sheetObj2.CellValue2(l, "sim_div_cd")       = "1";
                    sheetObj2.CellValue2(l, "vsl_cd")           = sheetObj.CellValue(arrIndex[j],"vsl_cd");
                    sheetObj2.CellValue2(l, "vsl_flg")          = "N";
                    sheetObj2.CellValue2(l, "vsl_clss_capa")    = sheetObj.CellValue(arrIndex[j],"vsl_clss");
                    //sheetObj2.CellValue2(l, "port_clss_capa")   = sheetObj.CellValue(arrIndex[j],"port_clss_capa");
                    sheetObj2.CellValue2(l, "vsl_oshp_cd")      = sheetObj.CellValue(arrIndex[j],"vsl_oshp_cd");
                    sheetObj2.CellValue2(l, "vop_cd")           = sheetObj.CellValue(arrIndex[j],"vop_cd");
                    if(sheetObj.CellValue(arrIndex[j],"vop_cd") == "SML") sheetObj2.CellValue2(l, "vop_flg") = "1";
                    else sheetObj2.CellValue2(l, "vop_flg") = "0";
                    sheetObj2.CellValue2(l, "skd_dir_cd")       = sheetObj.CellValue(arrIndex[j],"skd_dir_cd");
                    sheetObj2.CellValue2(l, "vsl_capa")         = sheetObj.CellValue(arrIndex[j],"vsl_clss_capa");
                    sheetObj2.CellValue2(l, "bsa_capa")         = sheetObj.CellValue(arrIndex[j],"bsa_capa");
                    sheetObj2.CellValue2(l, "fnl_hjs_bsa_capa") = sheetObj.CellValue(arrIndex[j],"fnl_hjs_bsa_capa");

                    sheetObj2.CellValue2(l, "otr_crr_bsa_capa1") = sheetObj.CellValue(arrIndex[j],"bsa00101");
                    sheetObj2.CellValue2(l, "otr_crr_bsa_capa2") = sheetObj.CellValue(arrIndex[j],"bsa00102");
                    sheetObj2.CellValue2(l, "otr_crr_bsa_capa3") = sheetObj.CellValue(arrIndex[j],"bsa00103");
                    sheetObj2.CellValue2(l, "otr_crr_bsa_capa4") = sheetObj.CellValue(arrIndex[j],"bsa00104");
                    sheetObj2.CellValue2(l, "otr_crr_bsa_capa5") = sheetObj.CellValue(arrIndex[j],"bsa00105");

                    sheetObj2.CellValue2(l, "sub_lse_capa1") = sheetObj.CellValue(arrIndex[j],"bsa00201");
                    sheetObj2.CellValue2(l, "sub_lse_capa2") = sheetObj.CellValue(arrIndex[j],"bsa00202");
                    sheetObj2.CellValue2(l, "sub_lse_capa3") = sheetObj.CellValue(arrIndex[j],"bsa00203");
                    sheetObj2.CellValue2(l, "sub_lse_capa4") = sheetObj.CellValue(arrIndex[j],"bsa00204");
                    sheetObj2.CellValue2(l, "sub_lse_capa5") = sheetObj.CellValue(arrIndex[j],"bsa00205");

                    sheetObj2.CellValue2(l, "sub_chtr_capa1") = sheetObj.CellValue(arrIndex[j],"bsa00301");
                    sheetObj2.CellValue2(l, "sub_chtr_capa2") = sheetObj.CellValue(arrIndex[j],"bsa00302");
                    sheetObj2.CellValue2(l, "sub_chtr_capa3") = sheetObj.CellValue(arrIndex[j],"bsa00303");
                    sheetObj2.CellValue2(l, "sub_chtr_capa4") = sheetObj.CellValue(arrIndex[j],"bsa00304");
                    sheetObj2.CellValue2(l, "sub_chtr_capa5") = sheetObj.CellValue(arrIndex[j],"bsa00305");
                    sheetObj2.CellValue2(l, "vsl_flg") = sheetObj.CellValue(arrIndex[j],"vsl_flg");
                }
                sheetObj.SelectRow = 0;
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.Down2Excel(-1, false, false, true);
                break;
        }
        formObj.f_fm_wk.focus();
    }


    /**
     * 메인화면의 vessel 개수만큼만 선택할수 있도록 메시지 띄움
     */
    function sheet1_OnChange(sheetObj , row, col, value) {

        var formObj = document.form;
        var sheetObj1 = opener.sheetObjects[0];   // 부모창의 Lane sheet
        var sheetObj2 = opener.sheetObjects[1];   // 부모창의 Vessel sheet
        var freq_no = sheetObj1.CellValue(sheetObj1.SelectRow,"freq_no");
        var s_cnt = 0;
        if(sheetObj2.RowCount("R") > 0) {
          s_cnt = parseInt(freq_no) - parseInt(sheetObj2.RowCount("R")-1);
        } else {
	    		s_cnt = parseInt(freq_no);
				}


        if(sheetObj.ColSaveName(col) == "chk_sel"){
          var chkRow = sheetObj.CheckedRows ("chk_sel");
          if(s_cnt<chkRow){
            // [MAS10008] >> No of Vessels을(를)  초과할수 없습니다.
              ComShowMessage(ComGetMsg("MAS10008","No of Vessels"));
            //ComShowMessage(ComGetMsg("MAS10013", "Vessel"));
//            ComComShowMessage("Cannot choose more than the No of Vessels.");
              sheetObj.CellValue2(row,"chk_sel") = "N";
              return false;
          } else if(dup_check(sheetObj)) {
        		return;
        	}
        }
    }


    function dup_check(sheetObj) {
  		//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
  		var iCheckRow = sheetObj.FindCheckedRow("chk_sel");
  		//가져온 행을 배열로 반든다.
  		var arrRow = iCheckRow.split("|");
  		arrStr = new Array();
  		for (idx=0; idx<arrRow.length-1; idx++){
  			arrStr[idx] = sheetObj.CellValue(arrRow[idx],"vsl_cd");
  		}
			for(i=0;i<arrStr.length;i++)  {
			  for(j=i+1;j<arrStr.length;j++) {
			     if(arrStr[i].length > 0 && arrStr[j].length >0) {
			       if(arrStr[i] == arrStr[j]) {
						   ComShowMessage(ComGetMsg("MAS10008","same Vessels"));
						   sheetObj.CellValue2(sheetObj.SelectRow,"chk_sel") = "N";
						   return false;
						 } else {
						 	 return true;
						 }
			     }
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
     * Seq를 선택하면 Date Period를 clear한다.
     */
    function clearDatePeriod(){
        document.form.txtWeek.value = "";
        document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
    	 ComMasSetPeriod4(obj);
    }

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;
		with(formObj){
			if (f_year.value == "") {
			    // [COM12114] : Year 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Year"));
			    f_year.focus();
				return false;
			}
			if (f_fm_wk.value != "" && f_to_wk.value == ""){
			    // [COM12114] : Week 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Week"));
			    f_to_wk.focus();
			    return false;
			}
			if (f_fm_wk.value == "" && f_to_wk.value != ""){
			    // [COM12114] : Week 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Week"));
			    f_fm_wk.focus();
			    return false;
			}
			if (f_fm_wk.value > f_to_wk.value) {
			    // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
			    ComShowMessage(ComGetMsg("MAS10011","Week","From","To"));
			    f_to_wk.focus();
			    return false;
			}
		    if(!ComIsNumber("1234")) return false;
				if(!ComIsWeek(f_fm_wk,false,true)) return false;
				if(!ComIsWeek(f_to_wk,false,true)) return false;
		}
		return true;
    }


