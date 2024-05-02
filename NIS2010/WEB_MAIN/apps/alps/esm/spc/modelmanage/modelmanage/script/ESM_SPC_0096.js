/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0096.js
*@FileTitle : Average Performance per Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.24 진마리아
* 1.0 Creation
* 2013.01.24 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가 
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
     * @class ESM_SPC_0096 : ESM_SPC_0096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0096() {
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

       			case "btn_downexcel":
       				if(sheetObjects[0].RowCount > 0){
       					sheetObjects[0].Down2Excel(-1);
       				}
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

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
                    
                    style.height = 500;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false, false)
                  
                    var HeadTitle = "ACCOUNT\n(GROUP)|cust_cd|ACCOUNT\n(INDIVIDUAL)";
                    if(document.form.trd_cd.value=="TPS"){
                    	HeadTitle = HeadTitle + "|SC#|C.OFC|L.OFC|SUB\nTRADE|LANE|AVG\nPFMC(1)|AVG\nPFMC(2)";
                    } else if(document.form.trd_cd.value=="AES" || document.form.trd_cd.value=="IAS"){
                    	HeadTitle = HeadTitle + "|RFA#|C.OFC|L.OFC|SUB\nTRADE|LANE|AVG\nPFMC(1)|AVG\nPFMC(2)";
                    }else{
                    	HeadTitle = HeadTitle + "|C.OFC|L.OFC|SUB\nTRADE|LANE|AVG\nPFMC(1)|AVG\nPFMC(2)";
                    }
                    for(var i=1; i < Number(document.form.duration.value)+1; i++){
                    	HeadTitle = HeadTitle + "|W"+i;
                    }
                    HeadTitle = HeadTitle + "|cust_grp_id";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtHiddenStatus,	60,	daCenter,	false,		"ibflag");
    				InitDataProperty(0, cnt++ , dtData,		120,	daLeft,	true,		"cust_grp_nm",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"cust_cd",			false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		150,	daLeft,	true,		"cust_lgl_eng_nm",	false,	"",			dfNone,			0,		true,  true);
    				if(document.form.trd_cd.value=="TPS"){
    					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"sc_no",			false,	"",			dfNone,			0,		true,  true);
    				}
    				if(document.form.trd_cd.value=="AES" || document.form.trd_cd.value=="IAS"){
    					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"rfa_no",			false,	"",			dfNone,			0,		true,  true);
    				}
    				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"ctrt_ofc_cd",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"sls_rgn_ofc_cd",	false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"sub_trd_cd",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,		"rlane_cd",			false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"avg_pfmc",			false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"smpl_avg_pfmc",			false,	"",			dfNone,			0,		true,  true);
    				
    				for(var i=1; i < Number(document.form.duration.value)+1; i++){
    					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"avg_pfmc_"+i,		false,	"",			dfNone,			0,		true,  true);
    				}
    				InitDataProperty(0, cnt++ , dtHidden,	110,	daCenter,	true,		"cust_grp_id",		false,	"",			dfNone,			0,		true,  true);
                    
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
    				
    				var param = SpcFormString(formObj,"f_cmd,cost_yrwk,ver_seq,duration,unit,trd_cd,sc_no,rfa_no,sub_trd_cd,sls_rhq_cd,sls_rgn_ofc_cd,rlane_cd,cust_cnt_cd,cust_seq");
    				
    				var rtnXml = sheetObj.GetSearchXml("ESM_SPC_0096GS.do", param);
    				
    				sheetObj.LoadSearchXml(rtnXml);
    				sheetObj.ReDraw=true;
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
	 		
		}
    	return true;
    }
     
	/* 개발자 작업  끝 */