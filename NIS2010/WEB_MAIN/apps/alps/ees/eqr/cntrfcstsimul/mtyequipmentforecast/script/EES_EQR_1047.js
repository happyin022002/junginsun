/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1047.js
*@FileTitle : MTY Balance Repo Out
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.05.18 나상보
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var headCount = 0;
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1047 : EES_EQR_1047 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_EQR_1047() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheetObject = sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_downexcel":
                    if(sheetObjects[0].RowCount > 0){
                        doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    }
                    break;
                case "btn_Close":
                    window.close();
                    break;
                case "btn_RowAdd":
                	sheetObjects[0].DataInsert(-1);
                	for ( var j=0; j<headCount; j++ ) {
 	    			   if(sheetObjects[0].ColSaveName(j).substring(3) == "fcast_qty"){
 	    				   sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, j) = 0;
 	    			   }
 	    		    }
                	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "total") = 0;
                	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "inp_yrwk") = formObject.inp_yrwk.value;
                	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "fcast_yrwk") = formObject.fcast_yrwk.value;
                	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "loc_grp_cd") = formObject.loc_grp_cd.value;
                	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "loc_cd") = formObject.loc_cd.value;
                	setTotalForm();
                    break;
                case "btn_Delete":
                	if(sheetObjects[0].FindCheckedRow("Seq") != ""){
    					ComRowHideDelete(sheetObjects[0],"Seq"); 
    				}
                	setTotalForm();
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        if(document.form.save_option.value == "0"){
  		   ComBtnEnable("btn_save");
  		   ComBtnEnable("btn_RowAdd");
		   ComBtnEnable("btn_Delete");
		   sheetObjects[0].Editable = true;
  	   }else{
  		   ComBtnDisable("btn_save");
  		   ComBtnDisable("btn_RowAdd");
		   ComBtnDisable("btn_Delete");
		   sheetObjects[0].Editable = false;
  	   }
	   
	   setHiddenCol(sheetObjects[0], document.form.tpsz_flag.value); // column 히든
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 522;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);

                    var HeadTitle1 = "Seq.|Trans Mode|Lane|VVD|From|From|To|To|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|Remark||||||";
                    var HeadTitle2 = "Seq.|Trans Mode|Lane|VVD|LOC|ETD|LOC|ETB/ETA|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|Remark||||||";
                    headCount = ComCountHeadTitle(HeadTitle1);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    CountPosition = 0;  //페이지카운트 없애기

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    sheetObj.FrozenCols = 8; 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	true,  "Seq",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtCombo,        73,     daCenter,   true,  "trsp_mod_cd",       false,  "", dfNone, 		-1,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,         35,     daCenter,   true,  "vsl_lane_cd",  	    false,  "", dfNone, 		-1,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,         75,     daCenter,   true,  "vvd",               false,  "", dfNone, 		-1,		false,		true,	9);
                    InitDataProperty(0, cnt++ , dtCombo,        60,     daCenter,   true,  "fm_yd_cd",          true,  "", dfNone, 			-1,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   true,  "fm_etd_dt",         true,  "", dfDateYmd, 		-1,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,        60,     daCenter,   true,  "to_yd_cd",          true,  "", dfNone, 			-1,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,   true,  "to_etb_dt",         true,  "", dfDateYmd, 		-1,		false,		false);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    40,     daRight,    true,  "total",             false,  "", dfNullInteger, 	-1,		false,		false);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "d2_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "d4_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "d5_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "d7_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "r2_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "r5_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "r9_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "o2_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "s2_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "o4_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "s4_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "o5_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "f2_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "a2_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "f4_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "a4_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "f5_fcast_qty",      false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,    35,     daRight,    true,  "a5_fcast_qty",      false,  "", dfNullInteger);
					InitDataProperty(0, cnt++ , dtData,        150,     daCenter,   true,  "repo_out_rmk",      false,  "", dfNone, 0, true, true, 500);

					InitDataProperty(0, cnt++ , dtHidden,       0,    	daCenter,   true,  "inp_yrwk",          false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    	daCenter,   true,  "fcast_yrwk",        false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    	daCenter,   true,  "loc_grp_cd",        false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    	daCenter,   true,  "loc_cd",       		false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    	daCenter,   true,  "cre_seq",        	false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,  	daCenter, 	false, "ibflag");
                    
                    InitDataCombo(0, "fm_yd_cd", "", "",  "","");
                    InitDataCombo(0, "to_yd_cd", "", "",  "","");
                    
                    var trspModCdTextArr = trspModCdText.split("|");
                    var trspModCdCodeArr = trspModCdCode.split("|");
                    trspModCdText = trspModCdTextArr[1];
                    trspModCdCode = trspModCdCodeArr[1];
                    for(var i = 2; i < trspModCdCodeArr.length; i++){
                    	trspModCdText += "|"+trspModCdTextArr[i];
                    	trspModCdCode += "|"+trspModCdCodeArr[i];
                    }
                    InitDataCombo(0, "trsp_mod_cd", trspModCdText, trspModCdCode,  "","");
                    
                    InitDataValid(0, "vvd", vtEngUpOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
                    
					//KeyFieldImage = "/hanjin/img/blank.gif";
					KeyFieldImage = "/hanjin/img/ico_star.gif";
               }
               break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {

            case IBSEARCH:      //조회
            	sheetObj.WaitImageVisible=false;
            	ComOpenWait(true); 
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("EES_EQR_1047GS.do",FormQueryString(formObj));
                ComOpenWait(false); 
                break;
                
            case IBDOWNEXCEL:      // 엑셀 다운
            	sheetObj.Down2Excel(0,false,true,true,'','',false,false,'',false,'',sheetObj.LastRow-1);
             	break;
             	
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){
		        	sheetObj.WaitImageVisible=false;
		        	ComOpenWait(true); 
		            formObj.f_cmd.value = MULTI;
		            sheetObj.DoSave("EES_EQR_1047GS.do",FormQueryString(formObj),"ibflag");
		            ComOpenWait(false);
            	}
	            break;
        }
    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
    	 sheetObj.SelectHighLight = false;
//    	 sheetObj.Redraw = true;
    	 setTotalForm();
     }
     
     /**
      * 셀을 클릭했을때 발생하는 이벤트 <br>
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	if ( row == sheetObj.LastRow ) {
          	sheetObj.SelectHighLight = false;
      		sheetObj.RowBackColor(row) = -1;
      	} else {
          	sheetObj.SelectHighLight = true;
		    if (sheetObj.CellValue(row, "trsp_mod_cd") == "V") {
				sheetObj.InitDataProperty(0, 4, dtCombo, 60, daCenter, true, "fm_yd_cd", false, "", dfNone, -1, false, true);
				sheetObj.InitDataProperty(0, 5, dtData, 70, daCenter, true, "fm_etd_dt", false, "", dfDateYmd, -1, false, false);
				sheetObj.InitDataProperty(0, 6, dtCombo, 60, daCenter, true, "to_yd_cd", false, "", dfNone, -1, false, true);
		        sheetObj.InitDataProperty(0, 7, dtData, 70, daCenter, true, "to_etb_dt", false, "", dfDateYmd, -1, false, false);
		    }else{
               sheetObj.InitDataProperty(0, 4 , dtData,        60,     daCenter,   true,  "fm_yd_cd",          false,  "", dfNone,           -1,     false,      true,   7);
               sheetObj.InitDataProperty(0, 5 , dtData,        70,     daCenter,   true,  "fm_etd_dt",         false,  "", dfDateYmd,        -1,     false,      true);
               sheetObj.InitDataProperty(0, 6 , dtData,        60,     daCenter,   true,  "to_yd_cd",          false,  "", dfNone,           -1,     false,      true,   7);
               sheetObj.InitDataProperty(0, 7 , dtData,        70,     daCenter,   true,  "to_etb_dt",         false,  "", dfDateYmd,        -1,     false,      true);
               sheetObj.InitDataValid(0, "fm_yd_cd", vtEngUpOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
               sheetObj.InitDataValid(0, "to_yd_cd", vtEngUpOther, "0123456789-~[]{}_|*&^%$#@! "); //영문과 숫자
            }
		   
		   if(sheetObj.CellValue(row, "trsp_mod_cd") == "O"){ // other 선택한 경우 mandantory 이미지 해제
		      sheetObjects[0].KeyFieldImage = "/hanjin/img/blank.gif";
		   }else{
		      sheetObjects[0].KeyFieldImage = "/hanjin/img/ico_star.gif";
		   }
      	}
      	
     }
      /**
       * 셀에 키입력 했을때 발생하는 이벤트 <br>
       * @param {ibsheet} sheetObj    IBSheet Object
       * @param {ibsheet} row     	sheetObj의 선택된 Row
       * @param {ibsheet} col     	sheetObj의 선택된 Col
       **/
      function sheet1_OnChange(sheetObj, Row, Col, Value) {
	  	
    	   var formObj = document.form;
    	   with(sheetObj){
    		   if(ColSaveName(Col).substring(3) == "fcast_qty"){
	    		   var rowTotal = 0;
	    		   for ( var j=0; j<headCount; j++ ) {
	    			   if(ColSaveName(j).substring(3) == "fcast_qty"){
	    				   rowTotal += parseInt(CellValue(Row, j));
	    			   }
	    		   }
	    		   CellValue2(Row, "total") = rowTotal;
	    	   }
    		   switch (ColSaveName(Col)) {
    		   case "vvd":
    			   if(CellValue(Row, "trsp_mod_cd") == "V"){
    				   if(Value.length != 9){
	     					ComShowCodeMessage("EQR90078","9");
	     					SelectCell(Row, Col);
	     				}else{	//VVD로 lane 조회 및 from, to yard combo list 만들기
		      				WaitImageVisible=false;
		                	ComOpenWait(true); 
		                    formObj.f_cmd.value = SEARCH01;
		                    var sXml = GetSearchXml("EES_EQR_1047GS.do",FormQueryString(formObj)+"&vvd="+Value);
		                    
		                    var arrXml = sXml.split("|$$|");
		                    var slnaCd = ComGetEtcData(arrXml[0], "slan_cd");
		                    if(slnaCd != ""){
			                    CellValue2(Row, "vsl_lane_cd") = slnaCd;
			                    var frYdCdArr = ComXml2ComboString(arrXml[0], "fm_yd_cd", "fm_etd_dt");
			                    var toYdCdArr = ComXml2ComboString(arrXml[1], "to_yd_cd", "to_etb_dt");
								if(ComGetTotalRows(arrXml[0]) > 0){
									CellComboItem(Row, "fm_yd_cd", "|"+frYdCdArr[0], "|"+frYdCdArr[1]);
									CellValue2(Row, "fm_yd_cd") = "";
									CellValue2(Row, "fm_etd_dt") = "";
								}
			                    ComOpenWait(false);
		                    }else{
		                    	ComOpenWait(false);
		                    	ComShowCodeMessage("EQR90001","accurate vvd code");
		                    	SelectCell(Row, Col);
		                    }
	     				}
    			   }
    			   break;
    			   
    		   case "fm_yd_cd":
    			   if(CellValue(Row, "trsp_mod_cd") == "V"){
    				   if(Value.length > 7){
    					   WaitImageVisible=false;
		                   ComOpenWait(true); 
		                   
    					   var frYdDt = Value.split("%%");
	    				   CellValue2(Row, "fm_yd_cd") = frYdDt[1];
	    				   CellValue2(Row, "fm_etd_dt") = frYdDt[0];
	    				   
	    				   
		                   formObj.f_cmd.value = SEARCH01;
		                   var sXml = GetSearchXml("EES_EQR_1047GS.do",FormQueryString(formObj)+"&vvd="+CellValue(Row, "vvd")+"&fm_etd_dt="+CellValue(Row, "fm_etd_dt"));
		                    
		                   var arrXml = sXml.split("|$$|");
			               var toYdCdArr = ComXml2ComboString(arrXml[1], "to_yd_cd", "to_etb_dt");
			               if(ComGetTotalRows(arrXml[1]) > 0){
								CellComboItem(Row, "to_yd_cd", "|"+toYdCdArr[0], "|"+toYdCdArr[1]);
								CellValue2(Row, "to_yd_cd") = "";
								CellValue2(Row, "to_etb_dt") = "";
							}
			                ComOpenWait(false);
    				   }
    			   }else{
    				   if(Value.length == 7){
	    				   WaitImageVisible=false;
	    				   ComOpenWait(true); 
	    				   formObj.f_cmd.value = SEARCH02;
	    				   var sXml = GetSearchXml("EES_EQR_1047GS.do",FormQueryString(formObj)+"&fm_yd_cd="+Value);
	    				   
	    				   var ydCd = ComGetEtcData(sXml, "yd_cd");
	    				   if(ydCd == "" || ydCd == null){
	    					   ComOpenWait(false);
	    					   ComShowCodeMessage("EQR90206");
	    					   CellValue2(Row, "fm_yd_cd") = "";
	    					   SelectCell(Row, Col);
	    				   }
	    				   ComOpenWait(false); 
    				   }else if(Value.length > 4){
    					   var colName = ColSaveName(Col);
    					   formObj.f_cmd.value = SEARCH02;
	    				   var sXml = GetSearchXml("EES_EQR_1047GS.do",FormQueryString(formObj)+"&fm_yd_cd="+Value);
	    				   
	    				   var ydCd = ComGetEtcData(sXml, "yd_cd");
	    				   if(ydCd == "" || ydCd == null){
	    					   ComOpenWait(false);
	    					   ComShowCodeMessage("EQR90203");
	    					   CellValue2(Row, "fm_yd_cd") = "";
	    					   SelectCell(Row, Col);
	    				   }else{
	    					   if(sheetObj.CellValue(Row,"trsp_mod_cd")=="W") {  // ITEM -> WATER 은   SEARCHLIST20
	               	    		    
	    						   var f_cmd = SEARCHLIST20;
	               		    	    DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+Value+"&colname="+colName+"&f_cmd="+f_cmd);
	               		    	    //sheetObj.CellValue2(row, colName) = searchword;
	               			        CellValue2(Row, colName) = "";
	
	       			    	    }else { // ITEM -> TRUCK, RAIL 은   SEARCHLIST05
	               	     		    var f_cmd = SEARCHLIST05;
	              	    			DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+Value+"&colname="+colName+"&f_cmd="+f_cmd);
	                   			    //sheetObj.CellValue2(row, colName) = searchword;
	                   			    CellValue2(Row, colName) = "";
	       		    		    }
	    				   }
    				   }
    			   }
    			   break;
        			
     			case "to_yd_cd":
     				if(CellValue(Row, "trsp_mod_cd") == "V"){
     					if(Value.length > 7){
     						var toYdDt = Value.split("%%");
     						CellValue2(Row, "to_yd_cd") = toYdDt[1];
    	     				CellValue2(Row, "to_etb_dt") = toYdDt[0];
     					}
     				}else{
     					if(Value.length == 7){
     						WaitImageVisible=false;
	     					ComOpenWait(true); 
	     					formObj.f_cmd.value = SEARCH02;
	     					var sXml = GetSearchXml("EES_EQR_1047GS.do",FormQueryString(formObj)+"&to_yd_cd="+Value);
	     					
	     					var ydCd = ComGetEtcData(sXml, "yd_cd");
	     					if(ydCd == "" || ydCd == null){
	     						ComOpenWait(false);
	 	                    	ComShowCodeMessage("EQR90206");
	 	                    	CellValue2(Row, "to_yd_cd") = "";
	 	                    	SelectCell(Row, Col);
	     				    }
	     					ComOpenWait(false);
     					}else if(Value.length > 4){
    					   var colName = ColSaveName(Col);
    					   formObj.f_cmd.value = SEARCH02;
	    				   var sXml = GetSearchXml("EES_EQR_1047GS.do",FormQueryString(formObj)+"&to_yd_cd="+Value);
	    				   
	    				   var ydCd = ComGetEtcData(sXml, "yd_cd");
	    				   if(ydCd == "" || ydCd == null){
	    					   ComOpenWait(false);
	    					   ComShowCodeMessage("EQR90203");
	    					   CellValue2(Row, "fm_yd_cd") = "";
	    					   SelectCell(Row, Col);
	    				   }else{
	    					   if(sheetObj.CellValue(Row,"trsp_mod_cd")=="W") {  // ITEM -> WATER 은   SEARCHLIST20
	               	    		    var f_cmd = SEARCHLIST20;
	               		    	    DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+Value+"&colname="+colName+"&f_cmd="+f_cmd);
	               		    	    //sheetObj.CellValue2(row, colName) = searchword;
	               			        CellValue2(Row, colName) = "";
	
	       			    	    }else { // ITEM -> TRUCK, RAIL 은   SEARCHLIST05
	               	     		    var f_cmd = SEARCHLIST05;
	              	    			DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+Value+"&colname="+colName+"&f_cmd="+f_cmd);
	                   			    //sheetObj.CellValue2(row, colName) = searchword;
	                   			    CellValue2(Row, colName) = "";
	       		    		    }
	    				   }
    				   }
     				}
        			break;
        			
     			case "trsp_mod_cd" :
     				CellValue2(Row, "vvd") = "";
     				CellValue2(Row, "fm_yd_cd") = "";
     				CellValue2(Row, "to_yd_cd") = "";
     				CellValue2(Row, "fm_etd_dt") = "";
     				CellValue2(Row, "to_etb_dt") = "";
					
					if(sheetObj.CellValue(Row, "trsp_mod_cd") == "O"){ // other 선택한 경우 mandantory 이미지 해제
		               sheetObjects[0].KeyFieldImage = "/hanjin/img/blank.gif";
		            }else{
		               sheetObjects[0].KeyFieldImage = "/hanjin/img/ico_star.gif";
		            }
     				break;
    		   }
    	   }
    	   setTotalForm();
      }
    
    /**
    * Row add 시 
    */	
  	function setTotalForm() {
  		var sheetObj = sheetObjects[0];
		sheetObj.CellFont("FontBold", sheetObj.LastRow,"") = true;
		sheetObj.CellFont("FontBold", sheetObj.LastRow,"vsl_lane_cd") = true;
		sheetObj.CellFont("FontBold", sheetObj.LastRow,"vvd") = true;
		sheetObj.CellFont("FontBold", sheetObj.LastRow,"total") = true;
		//for ( var j=1; j<=15; j++ ) {
		for ( var j=1; j<=17; j++ ) {			
			sheetObj.CellFont("FontBold", sheetObj.LastRow,8+j) = true;
		}
		sheetObj.CellValue2(sheetObj.LastRow,"Seq") = 'MTY Repo. Out Total';
		sheetObj.CellAlign(sheetObj.LastRow,"Seq") = daCenter;
		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 8);
		sheetObj.SumBackColor  = sheetObj.WebColor2SysColor("#D3EBED");
		sheetObj.SumFontBold = true;
		if ( sheetObj.CellValue(i,"total") > 0 ) {
			sheetObj.CellFontColor(i,"total") = sheetObj.RgbColor(0,0,255);
		}
		if ( sheetObj.CellValue(i,"total") < 0 ) {
			sheetObj.CellFontColor(i,"total") = sheetObj.RgbColor(255,0,0);
		}
		
		if ( sheetObj.CellValue(sheetObj.LastRow,"total") > 0 ) {
			sheetObj.CellFontColor(sheetObj.LastRow,"total") = sheetObj.RgbColor(0,0,255);
		}
		if ( sheetObj.CellValue(sheetObj.LastRow,"total") < 0 ) {
			sheetObj.CellFontColor(sheetObj.LastRow,"total") = sheetObj.RgbColor(255,0,0);
		}
		//for ( var j=1; j<=15; j++ ) {
		for ( var j=1; j<=17; j++ ) {		
			if ( sheetObj.CellValue(sheetObj.LastRow,8+j) > 0 ) {
				sheetObj.CellFontColor(sheetObj.LastRow,8+j) = sheetObj.RgbColor(0,0,255);
			}
			if ( sheetObj.CellValue(sheetObj.LastRow,8+j) < 0 ) {
				sheetObj.CellFontColor(sheetObj.LastRow,8+j) = sheetObj.RgbColor(255,0,0);
			}
		} 
		sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.WebColor2SysColor("#D3EBED");
  	}
    
    /**
    * 저장 완료시 처리
    */
   function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		save_flag = true;
		if ( ErrMsg == "" ) {
			if ( save_flag ) { 
		    	var opener_obj = window.dialogArguments;
				//opener_obj.popupEditFlg = "Y";
				
		    	//for ( var j=9; j<=24; j++ ) {
		    	//for ( var j=9; j<=25; j++ ) {
		    	for ( var j=9; j<=26; j++ ) {		    		
	    			if ( sheetObjects[0].rowCount > 0 ) {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), sheetObjects[0].CellValue(sheetObjects[0].LastRow,sheetObjects[0].ColSaveName(j)));
	    			} else {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), 0);
	    			}
	            }
                opener_obj.calcBalance(); //EES_EQR_1001 재계산
                opener_obj.calcAllTotal();
			}
			ComShowCodeMessage("EQR01001");
		}
   }
    
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(sheetObj){
			switch (sAction) {
  			case IBSAVE:
  				for(var i = 0; i <= LastRow; i++){
  					if((RowStatus(i) == "I" || RowStatus(i) == "U") && CellValue(i, "trsp_mod_cd") == "V" && (CellValue(i, "vvd") == "" || CellValue(i, "vvd") == null)){
  						ComShowCodeMessage("COM130403", "VVD"); // 'Mandatory field is missing. Please enter {?msg1}.'
  						SelectCell(i, "vvd");
  						return false;
  					}
					if((RowStatus(i) == "I" || RowStatus(i) == "U") && CellValue(i, "trsp_mod_cd") != "O" 
					       && (CellValue(i, "fm_yd_cd") == "" || CellValue(i, "fm_yd_cd") == null)){
                        ComShowCodeMessage("COM130403", "From LOC"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "fm_yd_cd");
                        return false;
                    }  
					if((RowStatus(i) == "I" || RowStatus(i) == "U") && CellValue(i, "trsp_mod_cd") != "O" 
                           && (CellValue(i, "fm_etd_dt") == "" || CellValue(i, "fm_etd_dt") == null)){
                        ComShowCodeMessage("COM130403", "From ETD"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "fm_etd_dt");
                        return false;
                    }  
					if((RowStatus(i) == "I" || RowStatus(i) == "U") && CellValue(i, "trsp_mod_cd") != "O" 
                           && (CellValue(i, "to_yd_cd") == "" || CellValue(i, "to_yd_cd") == null)){
                        ComShowCodeMessage("COM130403", "To LOC"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "to_yd_cd");
                        return false;
                    }  
					if((RowStatus(i) == "I" || RowStatus(i) == "U") && CellValue(i, "trsp_mod_cd") != "O" 
                           && (CellValue(i, "fm_yd_cd") == "" || CellValue(i, "to_etb_dt") == null)){
                        ComShowCodeMessage("COM130403", "To ETB/ETA"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "to_etb_dt");
                        return false;
                    }   
  				}
  				break;
			}
	    }
	    return true;
	}
	
	function setHiddenCol(sheetObj, tpszStr){
		if(tpszStr != ""){
			var arr_tpsz = tpszStr.split(",");
			var consTpszArr = "D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,O5,F2,A2,F4,A4,F5,A5".split(",");//전체의 Container Type/Size

			for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size     
	            for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
	                if(consTpszArr[i] == arr_tpsz[j]){
	                    sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_fcast_qty")= false;
	                    break;
	                }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
	                    sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_fcast_qty")= true;
	                }
	            }
	        }
		}
	}
