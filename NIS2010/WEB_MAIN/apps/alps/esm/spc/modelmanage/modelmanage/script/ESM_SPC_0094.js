/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0094.js
*@FileTitle : Yield Group Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.12.02 진마리아
* 1.0 Creation
*
* History
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
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
     * @class ESM_SPC_0094 : ESM_SPC_0094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0094() {
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
       				doActionIBSheet(sheetObjects[0], document.form, MULTI);
       				break;
       				
       			case "btn_ok":
       				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
       				break;
       				
       			case "btn_rowadd":
       				sheetObjects[0].DataInsert(sheetObjects[0].RowCount - 1); //Others 앞에 생성되도록
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
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        if ( document.form.inquiryPopup.value=="Y" || document.form.smpMainPopup.value == "Y" ){
        	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        } else {
        	otherGrpSetting();
        }
        
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    
                    style.height = 170;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    if(document.form.inquiryPopup.value=="Y"){
                        Editable = false;
                    }else{
                        Editable = true;                    	
                    }


                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false, false)
                  
                    var HeadTitle = "|Del|Main\nGroup|Sub\nGroup|Desc|season";

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	60,	daCenter,	false,		"ibflag");
                    if(document.form.inquiryPopup.value=="Y"){
                    	InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	false,		"del_chk",				false,	"",			dfNone,			0,		true,  true);
                    }else{
                    	InitDataProperty(0, cnt++ , dtDelCheck,	30,		daCenter,	false,		"del_chk",				false,	"",			dfNone,			0,		true,  true);
                    }
    				if(document.form.inquiryPopup.value=="Y"){
        				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"cust_ctrl_cd",		false,	"",			dfNone,			0,		true,  true);
    				}else{
        				InitDataProperty(0, cnt++ , dtCombo,	80,		daCenter,	false,		"cust_ctrl_cd",		true,	"",			dfNone,			0,		true,  true);
    				}
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"cust_ctrl_sub_cd",	false,	"",			dfNone,			0,		true,  true, 1);
    				InitDataProperty(0, cnt++ , dtData,		120,	daLeft,		false,		"cust_ctrl_desc",	false,	"",			dfNone,			0,		true,  true,50);
                    
    				InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	false,		"cost_yrwk",		true,	"",			dfNone,			0,		true,  true);
    				
    				InitDataCombo(0, "cust_ctrl_cd", "A|B", "A|B");
    				InitDataValid(0, "cust_ctrl_sub_cd", vtEngDnOther, "0123456789");
               }
            break;

        } 
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				
    				var param = SpcFormString(formObj,"ALL");
    				
    				var rtnXml = sheetObj.GetSearchXml("ESM_SPC_0094GS.do", param);
    				
    				sheetObj.LoadSearchXml(rtnXml);
    				
    				if ( document.form.smpMainPopup.value == "Y" ) {
    					
    				} else if ( sheetObj.RowCount > 0 ) {
    					formObj.cost_yrwk.value = sheetObj.CellValue(sheetObj.HeaderRows, "cost_yrwk");
    				}
    				sheetObj.ReDraw=true;
    			}
            break;
            
    		case MULTI:
    			if (!validateForm(sheetObj, formObj, sAction)) {
    				return false;
    			}
    			
    			formObj.f_cmd.value = MULTI;
    			var SaveStr = ComGetSaveString(sheetObj);
    			
    			if(SaveStr == undefined || SaveStr.length <= 0 ) return;
    			
    			ComOpenWait(true);
    			var sXml = sheetObj.GetSaveXml("ESM_SPC_0094GS.do", SaveStr + "&" + FormQueryString(formObj));
    			ComOpenWait(false);
    			
    			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
    				ComShowCodeMessage("COM130102", "Data");
    				doActionIBSheet(sheetObj, formObj, IBSEARCH);
    			}
    			sheetObj.LoadSaveXml(sXml);
    			break;
    			
    		case IBSAVE:
    			if (validateForm(sheetObj, formObj, sAction)) {
    				var saveStr = ComGetSaveString(sheetObj, true, true);
    				opener.document.form.ctrl_grp_xml.value = saveStr;
    				window.returnValue = "Y";
    				window.close();
    			}
    		break;

    	}
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
	 	case IBSEARCH:
	 		break;
	 		
	 	case MULTI:
	 	case IBSAVE:
	 		var rtn = sheetObj.ColValueDupRows("cust_ctrl_cd|cust_ctrl_sub_cd", false, true);
	 		if(rtn!=""){
 				ComShowMessage(getMsg("SPC90135"));
 				return false;
 			}
	 		break;
	 		
		}
    	return true;
    }
    
    function otherGrpSetting(){
    	var sheetObj = sheetObjects[0];

    	var row = sheetObj.DataInsert(-1);
    	sheetObj.CellValue(row, "cust_ctrl_cd") = "C";
    	sheetObj.CellValue(row, "cust_ctrl_desc") = "Others";
    	sheetObj.RowEditable(row) = false;
    }
     
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
    	
    	if ( document.form.smpMainPopup.value == "Y" ) {
    		for (var j=sheetObj.HeaderRows; j<sheetObj.HeaderRows+sheetObj.RowCount; j++){
    			sheetObj.CellEditable(j, "del_chk") = false;
    			sheetObj.CellEditable(j, "cust_ctrl_cd") = false;
    			sheetObj.CellEditable(j, "cust_ctrl_sub_cd") = false;
    		}
    	}
    }
	/* 개발자 작업  끝 */