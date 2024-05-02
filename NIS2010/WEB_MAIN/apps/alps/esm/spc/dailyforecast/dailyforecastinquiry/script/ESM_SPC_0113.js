/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0113.js
*@FileTitle : dailyforecastinquiry
*Open Issues :
*Change history :
*2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
*2010-07-07 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171  53ft 추가
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.03 한상훈
* 1.0 Creation
* 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청 
			 -RHQ가 현재 필수항목으로 SHARC/SINRS/HAMRU/NYCRA로 되어있으나, ALL을 추가.
			 -RHQ : ALL 선택 시 T/S Conti는 필수항목. 
			 -T/S Lane과 T/S Port 사이에  T/S VVD 및  T/S ETB DATE(T/S VVD의 T/S Port의 ETB_DT) 추가
			 -Grid 상단의 Check Box에 T/S VVD 체크박스 추가 : 해당 체크박스 체크시 T/S VVD 및 ETB Date 보여줌
* 2011.05.06 최성민 [CHM-201110577-01] Pre/Post T/S ETB Date 항목 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 - 기존 105번 화면 copy하여 복원
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
* 2015.08.03 Arie T/S BKG 화면 조직없이 전지역 조회 가능하도록 수정 
* 2015.08.17 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(8.03내용 포함)
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
     * @class ESM_SPC_113 : ESM_SPC_113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0113() {
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
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';
    var init_duration = '';
    var init_ofcCd = '';
    
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

//        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
       	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	            break;
        	            
    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//공통함수사용: 화면을 초기화
    					resetAll();
    					changeSelectPort("U");
    		    		document.getElementsByName("chkDsTSPort")[0].checked = true;
    		    		document.getElementsByName("chkDsPost")[0].checked = true;
    		    		document.getElementsByName("chkDsOffice")[0].checked = true;
    		    		document.getElementsByName("chkDsLane")[0].checked = true;    					
    					document.getElementsByName("chkDsVvd")[0].checked = false; 					
    					document.getElementsByName("chkDsPVvd")[0].checked = false;
    					
    					sheetObject.ColHidden("ts_port") = false;
    					sheetObject.ColHidden("bkg_port") = false;
    					sheetObject.ColHidden("office") = false;
    					sheetObject.ColHidden("lane") = false;
    					sheetObject.ColHidden("vvd") = false;
    					
    					sheetObject.ColHidden("ts_vvd") = true;
    					sheetObject.ColHidden("ts2_vvd") = true;
    					sheetObject.ColHidden("ts_etb_dt") = true;
    					sheetObject.ColHidden("ts2_etb_dt") = true;

    					formObject.year.value = init_year;
    					formObject.week.value = init_week;
    					formObject.duration.value = init_duration;
    					formObject.rhq_cd.value = rhq_cd;
    					document.getElementById("ofc_cd").Code2 = init_ofcCd;
    					
    					SpcSearchOptionWeek("week",false,document.form.year.value);         
    					break;
    					
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            	        break;

    			} // end switch
//        	}catch(e) {
//        		if( e == "[object Error]") {
//        			ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//        	}
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
         * ts_conti 초기화
         */
        function initDataValue_ts_conti(){
            var sheetObj = document.getElementById("ts_conti");
            with(sheetObj){
                Index2 = 0;
            }        	
        }
        
        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
    		comObjects[comboCnt++] = combo_obj;
        }
        
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	//ie11  ibcombo 잔상 개선
        	document.getElementById("lane").Enable = false;
        	document.getElementById("ts_conti").Enable = false;

        	
        	SpcSearchOptionYear("year");
         	SpcSearchOptionWeek("week");
         	SpcSearchOptionDuration("duration", 5, 3);
         	SpcSearchOptionLane("lane");

            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
    			//initDataSelection(i);
            }
            
            var sheetResizeFull = true;
    		document_onresize();

    		var formObject = document.form;
    		formObject.rhq_cd.value = rhq_cd;
//    		formObject.rhq_cd.value = "SHARC";
    		rhq_cd_OnChange(formObject.rhq_cd.value);
    		SpcSearchOptionContiCd("ts_conti", true, true);	   //T/S Conti 코드 조회
    		comObjects[1].BackColor = "#CCFFFD"; 

//    		formObject.pol1.value = "KRPUS";
//    		formObject.pod1.value = "JPKIJ";
//    		formObject.week.value = "03";
//    		formObject.vvd.value = "GOTR0801E";
    	    var comObj = document.getElementById("ofc_cd");
//    	    comObj.Code = "BKKSC";
    		formObject.year.focus();

        	init_year = formObject.year.value; // 년 초기화용
        	init_week = formObject.week.value; // 주차 초기화용
        	init_duration = formObject.duration.value; // duration 초기화용
        	init_ofcCd = document.getElementById("ofc_cd").Code;
        	
        	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
        	document.getElementById("lane").Enable = true;
        	document.getElementById("ts_conti").Enable = true;
        }
        
        function showDataSelectionItem(id, show){
        	var objs = document.all[id];
        	for(var i = 0 ; i < objs.length ; i++){
        		objs[i].style.display = show?"":"none";
        	}
        }

       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

    		with (sheetObj) {
    			// 높이 설정
    			style.height = getSheetHeight(20) ;
    			//전체 너비 설정
    			SheetWidth = mainTable.clientWidth;
    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    			
    			//전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msPrevColumnMerge + msHeaderOnly;
    			
    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = false;
    			
    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo( 2, 1, 10, 100);
    			
    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(21, 11, 0, false);
    			
    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(false, true, true, true, false,false) ;
    			
    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			var HeadTitleC = "WEEK|T/S\nLANE|T/S\nVVD|T/S\nPORT|T/S\nETB Date|Prev.\nVVD|Prev.\nETB Date|POL/POD|OFFICE|T.LANE|T.VVD||";
    			var HeadTitle1 = "BKG(VOL/WT)|BKG(VOL/WT)|SZ(BOX)|SZ(BOX)|SZ(BOX)|SZ(BOX)|SZ(BOX)|RF(BOX)|RF(BOX)";
    			var HeadTitle2 = "Total Teu|M/T|20|40|HC|45|53'|20|40";
    			InitHeadRow(0, HeadTitleC+HeadTitle1, true);
    			InitHeadRow(1, HeadTitleC+HeadTitle2, true);
    			var cnt = 0;
    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "week",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "ts_lane",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "ts_vvd",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "ts_port",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "ts_etb_dt",     false,          "",       dfDateYmd,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "ts2_vvd",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "ts2_etb_dt",     false,          "",       dfDateYmd,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "bkg_port",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "office",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "lane",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "vvd",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtHidden ,    50,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   false,    "",     false,          "",       dfNullInteger,       0,     false,       false);
    			HeadRowHeight  = 10;
    			InitTreeInfo(11, "sLevel", RgbColor(0,0,255), false);
    			var backColor = RgbColor(222, 251, 248);
    			RangeBackColor(1, 10, 1, 17) = backColor;
    			ImageList(0) = "img/nolines_plus.gif";
    			ImageList(1) = "img/nolines_minus.gif";
    			sheetObj.ColHidden("ts_vvd") = true;
    			sheetObj.ColHidden("ts2_vvd") = true;
    			sheetObj.ColHidden("ts_etb_dt") = true;
    			sheetObj.ColHidden("ts2_etb_dt") = true;
    		}
        }
        function showDataCol() {
        	
        	if ( document.getElementsByName("chkDsVvd")[0].checked ) {
        		sheetObjects[0].ColHidden("ts_vvd") = false;
        		sheetObjects[0].ColHidden("ts_etb_dt") = false;
        	} else {
        		sheetObjects[0].ColHidden("ts_vvd") = true;
        		sheetObjects[0].ColHidden("ts_etb_dt") = true;
        	}
        }

        /**
         * Prev./Post VVD 클릭시 SHEET 항목 hidden 처리하는 function
         * <br><b>Example :</b>
         * <pre>
         *
         * </pre>
         * @return 없음
         * @author 최성민
         * @version 2011.05.16
         */
        function showPrePostDataCol() {        	
        	if ( document.getElementsByName("chkDsPVvd")[0].checked ) {
        		sheetObjects[0].ColHidden("ts2_etb_dt") = false;
        		sheetObjects[0].ColHidden("ts2_vvd") = false;
        	} else {
        		sheetObjects[0].ColHidden("ts2_etb_dt") = true;
        		sheetObjects[0].ColHidden("ts2_vvd") = true;
        	}
        }

        /**
         * TabSheet2에서 조회후 타이틀 변경
         */
    	function initSheet1(sheetObj){

    	}
        
        /**
         * OnClick 이벤트 발생시 호출되는 function <br>
         * 트리 펼침 닫힘 이미지 클릭시 toggleExpand()호출 <br>
         * - Pre/Post T/S ETB Date 항목 추가로 ts2_etb_dt 추가함.
         * <br><b>Example :</b>
         * <pre>
         *
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
         * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
         * @return 없음
         * @author 최성민
         * @version 2011.05.06
         */  
    	function sheet1_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "ts_vvd":
        	case "ts_port":
        	case "ts2_vvd":
        	case "bkg_port":
        	case "office":
        	case "lane":
    			var mark = sheetObj.CellValue(row, col);
    			if(mark == "0" || mark == "1"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
       	
       	function toggleExpand(sheetObj, row, col){
    		var mark = sheetObj.CellValue(row, col);
    		if(sheetObj.RowExpanded(row)){
    			sheetObj.RowExpanded(row) = false;
    			ChangeValue2(sheetObj, row, col, "0");
    		}
    		else{
    			sheetObj.RowExpanded(row) = true;
    			ChangeValue2(sheetObj, row, col, "1");
    		}
       	}

    	function ChangeValue2(sheetObj, row, col, val){
    		with(sheetObj){
    			CellValue2(row, col) = val;
    		}
    	}

     	/**
     	 * 체크박스 클릭시 SHEET 컬럼 HIDDEN 설정하는 Function <br>
     	 * - Pre/Post T/S ETB Date 항목 추가로 CHECKBOX value 값 수정함.
     	 * <br><b>Example :</b>
     	 * <pre>
     	 * changeDataSelection();
     	 * </pre>
     	 * @return 없음
     	 * @author 최성민
     	 * @version 2011.05.06
     	 */
    	function changeDataSelection(){
    		var sheetObj = sheetObjects[0];
    		var obj = null;
    		obj = event.srcElement;
    		var sts = obj.checked;
    		var lvl = obj.value * 1;
    		
    		if(lvl!=2)document.getElementsByName("chkDsTSPort")[0].checked = lvl>=2;
    		if(lvl!=4)document.getElementsByName("chkDsPost")[0].checked = lvl>=4;
    		if(lvl!=5)document.getElementsByName("chkDsOffice")[0].checked = lvl>=5;
    		if(lvl!=6)document.getElementsByName("chkDsLane")[0].checked = lvl>=6;
    		for(var l = 1 ; l < lvl ; l++){
    			var frow = 0;
    			while((frow = sheetObj.FindText("lvl", l, frow + 1)) > 0){
    				sheetObj.CellValue2(frow, l + 1) = 1;
    			}
    		}
    		lvl = lvl - (sts?0:1);
    		sheetObj.ColHidden("ts_port") = lvl<2;
    		sheetObj.ColHidden("bkg_port") = lvl<4;
    		sheetObj.ColHidden("office") = lvl<5;
    		sheetObj.ColHidden("lane") = lvl<6;
    		sheetObj.ColHidden("vvd") = lvl<6;    		
    		sheetObj.ShowTreeLevel(lvl+1, 0);
    		return true;
    	}
    	    	
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, quite) {
        	if(quite == undefined) quite = false;
            sheetObj.ShowDebugMsg = false;		
    		
            switch(sAction) {
    			
               case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }
    				
    				var param = "year=" + formObj.year.value;
    				param = param + "&week="        + formObj.week.value;
    				param = param + "&duration="    + formObj.duration.value;
    				param = param + "&rhq_cd="      + formObj.rhq_cd.value;
    				param = param + "&ofc_cd="      + comObjects[0].Code;
    				param = param + "&pre_pst_flg=" + (formObj.pre_pst_flg_U.checked?formObj.pre_pst_flg_U.value:formObj.pre_pst_flg_S.value);
    				param = param + "&ts_lane1="    + formObj.ts_lane1.value;
    				param = param + "&ts_lane2="    + formObj.ts_lane2.value;
    				param = param + "&ts_lane3="    + formObj.ts_lane3.value;
    				param = param + "&ts_conti="    + comObjects[1].Code;
    				param = param + "&pol1="        + formObj.pol1.value;
    				param = param + "&pod1="        + formObj.pod1.value;
    				param = param + "&lane="        + comObjects[2].Code;
    				param = param + "&vvd="         + formObj.vvd.value;
//    				var rtn = sheetObj.DoSearch("ESM_SPC_0105GS.do", "f_cmd="+(SEARCHLIST01)+"&"+FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
    				var rtn = sheetObj.DoSearch("ESM_SPC_0113GS.do", "f_cmd="+(SEARCHLIST01)+"&"+ param + "&" + ComGetPrefixParam(""));
    				
    				if(formObj.pre_pst_flg[0].checked){
    					document.getElementById("txtDsPort").innerText = "POD";
    					document.getElementById("divDsPVvd").innerText = "Prev. VVD";
    					sheetObj.CellText(0, "bkg_port") = "POD";
    					sheetObj.CellText(1, "bkg_port") = "POD";
    					sheetObj.CellText(0, "ts2_etb_dt") = "Prev.\nETB Date";
    					sheetObj.CellText(1, "ts2_etb_dt") = "Prev.\nETB Date";
    					sheetObj.CellText(0, "ts2_vvd") = "Prev.\nVVD";
    					sheetObj.CellText(1, "ts2_vvd") = "Prev.\nVVD";
    				}
    				else{
    					document.getElementById("txtDsPort").innerText = "POL";
    					document.getElementById("divDsPVvd").innerText = "Post VVD";
    					sheetObj.CellText(0, "bkg_port") = "POL";
    					sheetObj.CellText(1, "bkg_port") = "POL";	
    					sheetObj.CellText(0, "ts2_etb_dt") = "Post\nETB Date";
    					sheetObj.CellText(1, "ts2_etb_dt") = "Post\nETB Date";
    					sheetObj.CellText(0, "ts2_vvd") = "Post\nVVD";
    					sheetObj.CellText(1, "ts2_vvd") = "Post\nVVD";
    				}
    				break;

               case IBDOWNEXCEL:        //엑셀 다운로드              
                  //sheetObj.Down2Excel(-1, false, false, true);
                  sheetObj.Down2Excel(-1, true, true, false);
                  break;
            }
        }

    	function rhq_cd_OnChange(value){
    		if(value == undefined){
    			var obj = event.srcElement;
    			value = obj.value;
    		}
    		if(value == "") {
    			comObjects[1].BackColor = "#CCFFFD";
    			return;
    		} else {
    			comObjects[1].BackColor = "white";
    		}
    		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=4");
    		initData_ofc_cd(rtn[0].split("|"), rtn[1].split("|"));
    	} 
    	

    	
    	function initDataValue_ofc_cd(){
    	    var sheetObj = document.getElementById("ofc_cd");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}

    	function initData_ofc_cd(codes, names){
    	    var sheetObj = document.getElementById("ofc_cd");
    	    var cnt = 0;
    	    with(sheetObj){
    	        RemoveAll();
    	        SetTitle("Office|Name");
    	        SetColWidth("60|250");
    	        SetColAlign("left|left");
    	        ShowCol = 0;
    	        MultiSelect = false;
    	        MaxSelect = 1;
    	        DropHeight = 190;
    	        if(codes == undefined || codes == null){
    	        	return;
    	        }
    	        if(codes.length > 2){
    	    		InsertItem(-1, "|ALL", "");
    	        }
    	    	var selectCode = "";
    		    for(var i = 0 ; i < codes.length - 1 ; i++){
    		    	var txt = names[i].split("~");
    		    	if(txt[1] == "1"){
    		    		selectCode = codes[i];
    		    	}
    		    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		    }
//    		    if(selectCode != ""){
//    		    	Code = selectCode;
//    		    }
//    		    else{
    		    	Index = 0;
//    		    }
//    			Enable = (GetCount() > 1 && selectCode == "");
    		    Enable = GetCount() > 1;
    	    }
    	}
    	
    	/**
    	 * 검색조건의 By Post Lane / By Pre Lane 선택시 TS Port / BKG Port 타이틀 변경
    	 */
    	function changeSelectPort(value){
    		var obj = event.srcElement;
    		if(value == undefined){
    			value = obj.value;
    		}
    		switch(value){
    		case "S":
    			txtPol.innerHTML = "<img class='nostar'>B.POL";
    			txtPod.innerHTML = "<img class='nostar'>T/S Port";
    			break;
    		case "U":
    			txtPol.innerHTML = "<img class='nostar'>T/S Port";
    			txtPod.innerHTML = "<img class='nostar'>B.POD";   
    			break;
    		}
    	}
    	/**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){

            switch(sAction) {
    			
               case IBSEARCH:      //조회
               		var val = formObj.ts_lane1.value;
    				if(val != "" && val.length < 3){
    					ComShowCodeMessage("COM12174", "T/S SVC.Lane", "3");
    					formObj.ts_lane1.focus();
    					return false;
    				}
    				val = formObj.ts_lane2.value;
    				if(val != "" && val.length < 3){
    					ComShowCodeMessage("COM12174", "T/S SVC.Lane", "3");
    					formObj.ts_lane2.focus();
    					return false;
    				}
    				val = formObj.ts_lane3.value;
    				if(val != "" && val.length < 3){
    					ComShowCodeMessage("COM12174", "T/S SVC.Lane", "3");
    					formObj.ts_lane3.focus();
    					return false;
    				}
    				var sts = formObj.pre_pst_flg[0].checked;
    				val = formObj.pol1.value;
    				if(val != "" && val.length < 2){
    					ComShowCodeMessage("COM12174", sts?"T/S Port":"B.POL", "2");
    					formObj.pol1.focus();
    					return false;
    				}
    				val = formObj.pod1.value;
    				if(val != "" && val.length < 2){
    					ComShowCodeMessage("COM12174", sts?"B.POD":"T/S Port", "2");
    					formObj.pod1.focus();
    					return false;
    				}
    				var rhq_cd = formObj.rhq_cd.value;		//필수 입력 체크 삭제 by kjj
    				if(rhq_cd == "" && comObjects[1].Code =="" ){
    					ComShowMessage(getMsg("SPC90114", "T/S Conti"));
    					comObjects[1].focus();
    					return false;
    				}
    				var vvd = formObj.vvd.value;
    				if(vvd != "" && vvd.length < 9){
    					ComShowCodeMessage("COM12174", "VVD", "9");
    					formObj.vvd.focus();
    					return false;
    				}
    		        return true;
    		    break;
    		}
    		return true;
        }

        function initDataValue_lane(){
        	var sheetObj = document.getElementById("lane");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }

        /**
         * Start Week 의 year 변경시
         * Start Week 의 year 변경시 주차 변경
         */
        function checkWeek(){
        	SpcSearchOptionWeek("week",false,document.form.year.value);
        	
        }
        
        /**
         * ie11 관련 개선 lane 콤보 
         */
        function lane_OnFocus(combj, value, text){
        	document.getElementById("year").focus();
            document.getElementById("lane").focus(); 
        }
        /**
         * ie11 관련 개선 lane 콤보 
         */
        function ts_conti_OnFocus(combj, value, text){
        	document.getElementById("year").focus();
            document.getElementById("ts_conti").focus(); 
        }
        

        
	/* 개발자 작업  끝 */
