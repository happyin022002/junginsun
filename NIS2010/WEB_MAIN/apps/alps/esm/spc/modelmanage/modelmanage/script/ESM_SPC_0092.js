/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SPC_0092.js
*@FileTitle      : Amend
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.03.06
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
*
* History
* 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 기능 추가
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
* 2015.01.30 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (Amend 팝업 계약번호 중복체크)
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
     * @class ESM_SPC_0092 : ESM_SPC_0092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0092() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt     = 0;
    var opener       = window.dialogArguments;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick; 

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
        /*******************************************************/
    	var formObject = document.form;

       	try {
       		var srcName = window.event.srcElement.getAttribute("name");

       		switch(srcName) {
       			case "btn_retrieve":
       				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
       				break;
       				
       			case "btn_save":
       				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
       				break;
       				
       			case "btn_close":
       				self.close();
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
    	var formObj = document.form;
    	
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var formObj = document.form;
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false, false)
                    
                    var HeadTitle = "|Trade|Season|Version|Account\n(Group)|Account\n(Group)|CUST_CNT_CD|CUST_SEQ|Account\n(Individual)|Account\n(Individual)";
                    
                    if ( ComGetObjValue(formObj.trade) == "AES" || ComGetObjValue(formObj.trade) == "IAS" ) {
                    	HeadTitle = HeadTitle + "|Current RFA#|RFA#|SC_RFA_FLG";
                    } else {
                    	HeadTitle = HeadTitle + "|Current SC#|SC#|SC_RFA_FLG";
                    }
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);
                    
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);
                    
                    // 높이 설정
                    style.height = getSheetHeight(15);
                    
                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"trd_cd",			false,	"",			dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"cost_yrwk",		false,	"",			dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"ver_seq",			false,	"",			dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		"cust_grp_id",		false,	"",			dfNone,			0,		false,	false);
    				InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		false,		"cust_grp_nm",		false,	"",			dfNone,			0,		false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"cust_cnt_cd",		false,	"",			dfNone,			0,		false,	false);
    				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,		"cust_seq",			false,	"",			dfNone,			0,		false,	false);
    				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"cust_cd",			false,	"",			dfNone,			0,		false,	false);
    				InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		false,		"cust_lgl_eng_nm",	false,	"",			dfNone,			0,		false,	false);
    				
    				if ( ComGetObjValue(formObj.trade) == "AES" || ComGetObjValue(formObj.trade) == "IAS") {
    					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		"pre_rfa_no",		false,	"",			dfNone,			0,		false,	false);
    					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"rfa_no",			true,	"",			dfNone,			0,		true,	true,	11);
    					
    					InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789");
    				} else {
    					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		"pre_sc_no",		false,	"",			dfNone,			0,		false,	false);
    					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"sc_no",			true,	"",			dfNone,			0,		true,	true,	20);
    					
    					InitDataValid(0, "sc_no", vtEngUpOther, "0123456789");
    				}
    				
    				InitDataProperty(0, cnt++ , dtHidden,    	30,		daCenter,	true,		"sc_rfa_flg",    	false,	"",			dfNone,			0,		false,	false);
    				
               }
            break;

        } 
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value = SEARCHLIST01;
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				
    				var param = SpcFormString(formObj, "ALL");
    				
    				var rtnXml = sheetObj.GetSearchXml("ESM_SPC_0092GS.do", param);
    				
    				sheetObj.LoadSearchXml(rtnXml);
    				
    				sheetObj.ReDraw=true;
    			}
            break;
            
    		case IBSAVE:
    			var SaveStr = ComGetSaveString(sheetObj);
    			
    			if(SaveStr == undefined || SaveStr.length <= 0 ) {
    				if ( ComGetObjValue(formObj.trade) == "AES" || ComGetObjValue(formObj.trade) == "IAS") {
						ComShowMessage(getMsg("SPC90139", "RFA NO"));
					} else {
						ComShowMessage(getMsg("SPC90139", "S/C NO"));
					}
    				return;
    			}
    			
    			if (!validateForm(sheetObj, formObj, sAction)) {
    				return false;
    			}
    			
    			formObj.f_cmd.value = MULTI;
    			
    			ComOpenWait(true);
    			
    			var sXml = sheetObj.GetSaveXml("ESM_SPC_0092GS.do", SaveStr + "&" + FormQueryString(formObj));
    			ComOpenWait(false);
    			
    			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
    				ComShowCodeMessage("COM130102", "Data");
    				doActionIBSheet(sheetObj, formObj, IBSEARCH);
    			}
    			sheetObj.LoadSaveXml(sXml);
    			break;
    			
    	}
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:
				
				sheetObj.SpaceDupCheck = false;
				
				if ( ComGetObjValue(formObj.trade) == "AES" || ComGetObjValue(formObj.trade) == "IAS") {
					//var rtn = sheetObj.ColValueDupRows("cust_cd|rfa_no", false, true);
					var rtn = sheetObj.ColValueDupRows("rfa_no", false, true);
				} else {
					//var rtn = sheetObj.ColValueDupRows("cust_cd|sc_no", false, true);
					var rtn = sheetObj.ColValueDupRows("sc_no", false, true);
				}
				
				if(rtn!=""){
					if ( ComGetObjValue(formObj.trade) == "AES" || ComGetObjValue(formObj.trade) == "IAS" ) {
						ComShowMessage(getMsg("SPC90135", "RFA NO"));
					} else {
						ComShowMessage(getMsg("SPC90135", "S/C NO"));
					}
					return false;
				}
				break;
		}
    	return true;
    }
    
    function sheet1_OnChange(sheetObj,row,col, value){
    	var formObj = document.form;
    	
    	switch (sheetObj.ColSaveName(col)) {
    		
    		case "sc_no":
    			// 입력한 S/C, RFA 의 유효성 체크
    			if ( value != "" ) {
    				var param = "cost_yrwk="    + ComGetObjValue(formObj.cost_yrwk)
    				          + "&ver_seq="     + ComGetObjValue(formObj.ver_seq)
    				          + "&trade="       + ComGetObjValue(formObj.trade)
    				          + "&cust_grp_id=" + sheetObj.CellValue(row, "cust_grp_id")
    				          + "&cust_cd="     + sheetObj.CellValue(row, "cust_cd")
    				          + "&sc_no="       + sheetObj.CellValue(row, "sc_no");
    				
    				var sXml = sheetObj.GetSearchXml("ESM_SPC_0092GS.do", "f_cmd=" + (SEARCH01) + "&" + param);
    				var chk = ComGetEtcData(sXml, "chk");
    				
    				if ( chk == "N" ) {
    					ComShowMessage(getMsg("SPC90199", "S/C NO"));
    					sheetObj.CellValue2(row, col) = "";
    					sheetObj.SelectCell(row, col);
    					//유효한 계약일경우 해당 계약이 이미 화주 정보에 등록되어 있는지 중복 체크
    					//(Import로 계약을 추가한 후 동일 계약을 amend를 하여 중복된 경우가 있었음. 중복 계약 방지 목적)		
    				}else{
        				var sXml = sheetObj.GetSearchXml("ESM_SPC_0092GS.do", "f_cmd=" + (SEARCH02) + "&" + param);
        				
        				var chk1 = ComGetEtcData(sXml, "chk");
        				//중복이면 chk가 Y
        				if ( chk1 == "Y" ) {
        					ComShowMessage(getMsg("SPC90135"));  //'There is duplicated data.'
        					sheetObj.CellValue2(row, col) = "";
        					sheetObj.SelectCell(row, col);
        				}	
    				}
    			}
    			break;
    		
    		case "rfa_no":
    			// 입력한 S/C, RFA 의 유효성 체크
    			if ( value != "" ) {
    				var param = "cost_yrwk="    + ComGetObjValue(formObj.cost_yrwk)
    					      + "&ver_seq="     + ComGetObjValue(formObj.ver_seq)
    					      + "&trade="       + ComGetObjValue(formObj.trade)
    					      + "&cust_grp_id=" + sheetObj.CellValue(row, "cust_grp_id")
    					      + "&cust_cd="     + sheetObj.CellValue(row, "cust_cd");
    				
    				if ( sheetObj.CellValue(row, "sc_rfa_flg") == "SC" ) {
    					param = param + "&sc_no=" + sheetObj.CellValue(row, "rfa_no");
    				} else {
    					param = param + "&rfa_no=" + sheetObj.CellValue(row, "rfa_no"); 
    				}
    					      
    				
    				var sXml = sheetObj.GetSearchXml("ESM_SPC_0092GS.do", "f_cmd=" + (SEARCH01) + "&" + param);
    				var chk = ComGetEtcData(sXml, "chk");
    				
    				if ( chk == "N" ) {
    					if ( sheetObj.CellValue(row, "sc_rfa_flg") == "SC" ) {
    						ComShowMessage(getMsg("SPC90199", "S/C NO"));
    					} else {
    						ComShowMessage(getMsg("SPC90199", "RFA NO"));
    					}
    					sheetObj.CellValue2(row, col) = "";
    					sheetObj.SelectCell(row, col);
    				//유효한 계약일경우 해당 계약이 이미 화주 정보에 등록되어 있는지 중복 체크
    				//(Import로 계약을 추가한 후 동일 계약을 amend를 하여 중복된 경우가 있었음. 중복 계약 방지 목적)	
    				}else{
        				var sXml = sheetObj.GetSearchXml("ESM_SPC_0092GS.do", "f_cmd=" + (SEARCH02) + "&" + param);
        				
        				var chk1 = ComGetEtcData(sXml, "chk");
        				//중복이면 chk가 Y
        				if ( chk1 == "Y" ) {
        					ComShowMessage(getMsg("SPC90135"));  //'There is duplicated data.'
        					sheetObj.CellValue2(row, col) = "";
        					sheetObj.SelectCell(row, col);
        				}	
    				}
    			}
    			break;
    		
    	}
    }
	/* 개발자 작업  끝 */