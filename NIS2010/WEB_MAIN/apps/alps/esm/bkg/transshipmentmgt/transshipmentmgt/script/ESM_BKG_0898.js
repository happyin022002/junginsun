/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0898.js
*@FileTitle : Vessel/Port Group Assign by VVD, Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.22 최영희
* 1.0 Creation
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
     * @class ESM_BKG_0898 : ESM_BKG_0898 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0898() {
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
	var prefix1="sheet1_";
	var prefix2="sheet2_";
	var prefix3="sheet3_";
	var prefix4="sheet4_";

	var closedVvds= "";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
		 
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_retrieve":
				    if (ComChkLen(formObject.vvd,9)!=2){
						ComShowCodeMessage("BKG00549"); 
						return;
				    }
					if (ComChkLen(formObject.port,5)!=2){
						ComShowCodeMessage("BKG00424"); 
						return;
				    }
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					sheetObjects[4].RemoveAll();
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					ComSetDisplay("btn_UnCheckAll",false); 
					ComSetDisplay("btn_CheckAll",true);
				    break;
				
				case "btn_new":
					iniForm();
				    break;
				    
				case "btn_selectall":
					if (sheetObject2.Rows<2) return;
					ComSetDisplay("btn_CheckAll",false);
					ComSetDisplay("btn_UnCheckAll",true);
					sheetObject2.CheckAll2(prefix2+"chk") = "1";
					validateSheet(false);
				    break;
				    
				case "btn_deselectall":
					ComSetDisplay("btn_CheckAll",true);
					ComSetDisplay("btn_UnCheckAll",false);
					sheetObject2.CheckAll2(prefix2+"chk") = "0";
				    break;
				    
				case "btn_vvdportchange":
				    var sRow1=sheetObjects[0].FindCheckedRow(prefix1+"chk");
					var arrRow1 = sRow1.split("|"); 
					var sRow2=sheetObjects[1].FindCheckedRow(prefix2+"chk");
					var arrRow2 = sRow2.split("|"); 
					if (arrRow1.length==1 || arrRow2.length==1){
						ComShowCodeMessage("BKG00155"); 
						return;
					}						
                    doActionIBSheet(sheetObjects[2],formObject,COMMAND02); 						
				    break;				
            } // end switch
    	}catch(e) {
    		alert("error");
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		iniForm();
		ComSetDisplay("btn_UnCheckAll",false);
		axon_event.addListenerFormat('keypress','bkg0898_keypress',document.form); 
		ComSetFocus(document.form.vvd);
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 152;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle1 = "|SEQ|SEL.|POL|POL|POD|BKG Count|T.VVD|PRE VVD|PRE Relay|POST VVD|POST Relay|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			50, daCenter,	true,	prefix1+"seq");
					InitDataProperty(0, cnt++ , dtRadioCheck,	50,	daCenter,	true,	prefix1+"chk",		    false,		"",		dfNone,			0,			true,		true);				
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"pol_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			25, daCenter,	true,	prefix1+"pol_nod_cd",   false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"pod_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"bkg_count",    false,		"",		dfNullInteger,  0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"tvvd",         false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"pre_vvd",      false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"pre_relay",   false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"post_vvd",     false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"post_relay",  false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix1+"rmk",          false,		"",		dfNone,			0,			false,		false);					

					CountPosition = 0;
               	}
				break;

            case 2:      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 210;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|SEQ|SEL.|Booking No.|B/L No.|POL|TS1|TS2|TS3|POD|Result";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	prefix2+"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			50,	daCenter,	true,	prefix2+"seq");
					InitDataProperty(0, cnt++ , dtCheckBox,	    50,	daCenter,	true,	prefix2+"chk",		false,		"",	dfNone,		0,		true,		true); 
					InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	prefix2+"bkg_no",	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	prefix2+"bl_no",	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	prefix2+"pol",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix2+"ts1",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix2+"ts2",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	prefix2+"ts3",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	prefix2+"pod_cd",	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	prefix2+"result",	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"por_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"del_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"por_nod_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"pol_nod_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"pod_nod_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"del_nod_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"org_trns_mod_cd",       false,		"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix2+"dest_trns_mod_cd",       false,		"",		dfNone,			0,			false,		false);					
					 
					CountPosition = 0;
               	}
				break;

			case 3:      
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 350;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Cd|Seq|Pol1|Pol2|Pod1|Pod2|vslCd|skdVoyNo|skdDirCd|PolSeq|PodSeq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,		false,	prefix3+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,				55,		daCenter,		false,	prefix3+"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix3+"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix3+"pol_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	prefix3+"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix3+"pod_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	prefix3+"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix3+"vsl_cd",			    false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix3+"skd_voy_no",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix3+"skd_dir_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  prefix3+"pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  prefix3+"pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    CountPosition = 0;
               }
                break; 

			case 4:      
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 350;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|bkgNo|tvvd|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,		false,	prefix4+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			false,	prefix4+"bkg_no",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			false,	prefix4+"tvvd",					false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				55,		daCenter,		false,	prefix4+"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix4+"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix4+"pol_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	prefix4+"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix4+"pod_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	prefix4+"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			false,	prefix4+"bkg_vvd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  prefix4+"pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  prefix4+"pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    CountPosition = 0;
                }
                break; 

			case 5:      
                with (sheetObj) {
                    // 높이 설정
                    style.height = 1000;
                    //전체 너비 설정
                    SheetWidth = 350;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,		false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtData,				55,		daCenter,		false,	"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	"pol_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	"pod_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			false,	"bkg_vvd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  "pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  "pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    CountPosition = 0;
                }
                break; 
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix = sheetObj.id+"_"; 
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
			    formObj.f_cmd.value = SEARCH;
			    var sXml = sheetObj.GetSearchXml("ESM_BKG_0898GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			     
			    sheetObj.Redraw = false;
			    sheetObj.LoadSearchXml(sXml);  
			    sheetObj.Redraw = true; 
			    ComSetDisplay("btn_UnCheckAll",false);
				ComClearObject(formObj.totalBl);
				ComClearObject(formObj.success);
				ComClearObject(formObj.fail);
				break; 
				
			case COMMAND01:      //bkg_detail조회
			    formObj.f_cmd.value = COMMAND01;
				var params = FormQueryString(formObj);
            	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true)); 
            	params = params + "&" + ComGetPrefixParam("sheet2_");
				var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0898GS.do", params); 
			   
			    sheetObjects[1].Redraw = false;    
			    sheetObjects[1].LoadSearchXml(sXml);  
			    sheetObjects[1].Redraw = true; 
			    ComSetDisplay("btn_UnCheckAll",false); 
				ComSetObjValue(formObj.totalBl,sheetObjects[1].Rows-1);
				break; 
											
			case COMMAND02:      //VVD_Port Change조회 
			    formObj.f_cmd.value = COMMAND02;
			    var params = FormQueryString(formObj);
            	params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true)); 
				params = params + "&" + ComGetPrefixParam("sheet3_");
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0898GS.do", params); 
			   
			    sheetObj.Redraw = false;    
			    sheetObj.LoadSearchXml(sXml);  
			    sheetObj.Redraw = true;  
				RouteToSheet(sheetObjects[2],prefix3);
				 
				ComSetObjValue(formObj.bkg_pol_cd,sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix1+"pol_cd")); 
				ComSetObjValue(formObj.bkg_pod_cd,sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix1+"pod_cd"));
				
				ComSetObjValue(formObj.bkg_por_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"por_cd"));
				ComSetObjValue(formObj.bkg_del_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"del_cd"));
				
				ComSetObjValue(formObj.bkg_por_yd_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"por_nod_cd"));
				ComSetObjValue(formObj.bkg_pol_yd_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"pol_nod_cd"));
				ComSetObjValue(formObj.bkg_pod_yd_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"pod_nod_cd"));
				ComSetObjValue(formObj.bkg_del_yd_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"del_nod_cd"));
				ComSetObjValue(formObj.dest_trns_mod_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"dest_trns_mod_cd"));
				ComSetObjValue(formObj.org_trns_mod_cd,sheetObjects[1].CellValue(sheetObjects[1].SelectRow,prefix2+"org_trns_mod_cd"));
							
				var param="?bkg_no="+sheetObjects[1].CellValue(sheetObjects[1].SelectRow ,prefix2+"bkg_no");
							param+="&bkgTrunkVvd="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,prefix1+"tvvd");
							param+="&ca_flg=";
							param+="&callSheetIdx=4";
							param+="&pgmNo=ESM_BKG_0092";
				ComOpenPopup("/hanjin/ESM_BKG_0092.do"+param, 700, 490, 'callBack0092','1,0,1,1,1', true);
			break; 		   
        }
    }
    
    /**
     * 그리드에 대한 유효성검증 프로세스 처리
     */
    function validateSheet(flag){
        with(sheetObjects[1]){
			 var sRow =FindCheckedRow(prefix2+"chk"); 
			 var arrRow = sRow.split("|"); 
             var pol="";
             var ts2="";
             var ts3="";
             var pod="";

			 for(var i=0;i<arrRow.length-1;i++){
                pol=CellValue(arrRow[i],prefix2+"pol");
                ts1=CellValue(arrRow[i],prefix2+"ts1");
                ts2=CellValue(arrRow[i],prefix2+"ts2");
                ts3=CellValue(arrRow[i],prefix2+"ts3");
                pod=CellValue(arrRow[i],prefix2+"pod_cd");
				if (pol!=CellValue(arrRow[i],prefix2+"pol")
					|| ts1!=CellValue(arrRow[i],prefix2+"ts1")
					|| ts2!=CellValue(arrRow[i],prefix2+"ts2")
					|| ts3 !=CellValue(arrRow[i],prefix2+"ts3")
					|| pod !=CellValue(arrRow[i],prefix2+"pod_cd")){
					CellValue(arrRow[i],prefix2+"chk")=0;
					ComShowCodeMessage("BKG00721"); 
					if (flag){
						break;
					}else{
						ComSetDisplay("btn_CheckAll",true);
						ComSetDisplay("btn_UnCheckAll",false);
					}					
				}
			}
        } 
    }

	/*
	* 시트1 셀의 OnChange이벤트 처리
	*/
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		if (sName==prefix1+"chk" && Value=="1"){
			ComSetObjValue(formObj.success,"0");
			ComSetObjValue(formObj.fail,"0");
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			doActionIBSheet(sheetObj,formObj,COMMAND01);   
		}
		ComSetDisplay("btn_UnCheckAll",false); 
		ComSetDisplay("btn_CheckAll",true);
	}

	/*
	* 시트2 셀의 OnChange이벤트 처리
	*/
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName==prefix2+"chk" && Value=="1"){
			 validateSheet(true);
		}
	}

	/*
	 * KeyPress Event 처리
	 */
    function bkg0898_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
	}
	
	/**
     * Route Detail 처리 후 작업 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0092();
     * </pre>
     * @param Popup에서 전달받은 값
     */
    function callBack0092(){
    	//팝업에서 Clear 버튼을 누르면 return 시킨다
    	if(0 == sheetObjects[4].RowCount){
    		 return;
    	}
    	var formObj = document.form;
		var sheetObj = sheetObjects[4]; 
		var sRow1=sheetObjects[0].FindCheckedRow(prefix1+"chk");
		var arrRow1 = sRow1.split("|"); 
		var sRow2=sheetObjects[1].FindCheckedRow(prefix2+"chk");
		var arrRow2 = sRow2.split("|");
        	
		// T/S close by bayplan check
		if(!checkTsCloseByBayPlan()){
			return false;
		}
	
		ComSetObjValue(formObj.success,"0");
		ComSetObjValue(formObj.fail,"0");
		ComOpenWait(true); 
		for(var icnt=0;icnt<arrRow2.length-1;icnt++){
			sheetObjects[3].RemoveAll(); 
			for(var iRow=1;iRow<sheetObj.Rows;iRow++){
				sheetObjects[3].DataInsert(-1);
				sheetObjects[3].CellValue2(iRow,prefix4+"vsl_pre_pst_cd") =sheetObj.CellValue(iRow,"vsl_pre_pst_cd");
				sheetObjects[3].CellValue2(iRow,prefix4+"vsl_seq") =sheetObj.CellValue(iRow,"vsl_seq");
				sheetObjects[3].CellValue2(iRow,prefix4+"pol_cd") =sheetObj.CellValue(iRow,"pol_cd");
				sheetObjects[3].CellValue2(iRow,prefix4+"pod_cd") =sheetObj.CellValue(iRow,"pod_cd");
				if (!ComIsEmpty(sheetObj.CellValue(iRow,"pol_yd_cd"))){
					sheetObjects[3].CellValue2(iRow,prefix4+"pol_yd_cd") =sheetObj.CellValue(iRow,"pol_cd")+sheetObj.CellValue(iRow,"pol_yd_cd");
				}
				if (!ComIsEmpty(sheetObj.CellValue(iRow,"pod_yd_cd"))){
					sheetObjects[3].CellValue2(iRow,prefix4+"pod_yd_cd") =sheetObj.CellValue(iRow,"pod_cd")+sheetObj.CellValue(iRow,"pod_yd_cd");
				}
				sheetObjects[3].CellValue2(iRow,prefix4+"pol_clpt_ind_seq") =sheetObj.CellValue(iRow,"pol_clpt_ind_seq");
				sheetObjects[3].CellValue2(iRow,prefix4+"pod_clpt_ind_seq") =sheetObj.CellValue(iRow,"pod_clpt_ind_seq");
				sheetObjects[3].CellValue2(iRow,prefix4+"bkg_vvd_cd") =sheetObj.CellValue(iRow,"bkg_vvd_cd"); 
				sheetObjects[3].CellValue2(iRow,prefix4+"bkg_no") = sheetObjects[1].CellValue(arrRow2[icnt],prefix2+"bkg_no");
				sheetObjects[3].CellValue2(iRow,prefix4+"tvvd") = sheetObjects[0].CellValue(arrRow1[0],prefix1+"tvvd");
			}
			formObj.f_cmd.value = COMMAND03; 
			var params = FormQueryString(formObj)+"&closed_vvds="+closedVvds;  
			params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true)); 
			params = params + "&" + ComGetPrefixParam("sheet4_");
			
            sheetObjects[3].WaitImageVisible = false;
			var sXml = sheetObjects[3].GetSaveXml("ESM_BKG_0898GS.do", params);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
            
			if(State == "S"){
				sheetObjects[1].CellValue2(arrRow2[icnt],prefix2+"result")="Success"; 
				ComSetObjValue(formObj.success,ComParseInt(formObj.success)+1);  
			}else{
				ComOpenWait(false);
				sheetObjects[1].LoadSearchXml(sXml);  
				return false;
//				sheetObjects[1].CellValue2(arrRow2[icnt],prefix2+"result")="Fail";
//				ComSetObjValue(formObj.fail,ComParseInt(formObj.fail)+1); 
			}
			sheetObjects[1].CellValue2(arrRow2[icnt],prefix2+"chk")="0";
			if (icnt==0){
				ComSetDisplay("btn_UnCheckAll",false); 
				ComSetDisplay("btn_CheckAll",true);
			} 
		}
		if(formObj.cust_ntc_flg.value == "Y"){
			var paramBkgNos = "";
			formObj.f_cmd.value = COMMAND04;

			for(var i=0;i<arrRow2.length-1;i++){
				if(sheetObjects[1].CellValue(arrRow2[i],prefix2+"result")=="Success"){
					paramBkgNos = paramBkgNos + "&bkg_no="+sheetObjects[1].CellValue(arrRow2[i],prefix2+"bkg_no")+"&ibflag=R";
				}				
			}
			var params = FormQueryString(formObj)+paramBkgNos; 
//			alert(params);
			var sXml = sheetObjects[3].GetSaveXml("ESM_BKG_0898GS.do", params);
			sheetObjects[1].LoadSearchXml(sXml);  
		}
		ComOpenWait(false);
		if (arrRow2.length>1){
			ComShowCodeMessage("BKG06022");
		}		
    }  
	
	/*
	* Form 초기화
	*/
	function iniForm(){
		var formObject = document.form;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		
		ComClearObject(formObject.vvd);
		ComClearObject(formObject.port);
		ComClearObject(formObject.yard);
		ComClearObject(formObject.bkgOfcCd);
		ComClearObject(formObject.pol);
		ComClearObject(formObject.pod);
		ComClearObject(formObject.totalBl);
		ComClearObject(formObject.success);
		ComClearObject(formObject.fail);
	}

	/*
	* T/S Route 호출시 전달 Sheet에 값대입
	*/
	function RouteToSheet(sheetObj,prefix){
		if (ComIsEmpty(sheetObj.CellValue(1,prefix+"vsl_pre_pst_cd"))){
			return;
		}
		sheetObjects[4].RemoveAll(); 
		sheetObjects[4].Rows = 	sheetObj.Rows;
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			with(sheetObjects[4]){			
				CellValue2(iRow,"vsl_pre_pst_cd") =sheetObj.CellValue(iRow,prefix+"vsl_pre_pst_cd");
				CellValue2(iRow,"vsl_seq")=sheetObj.CellValue(iRow,prefix+"vsl_seq");
				CellValue2(iRow,"pol_cd")=sheetObj.CellValue(iRow,prefix+"pol_cd");
				if (!ComIsEmpty(sheetObj.CellValue(iRow,prefix+"pol_yd_cd"))){
					CellValue2(iRow,"pol_yd_cd")=sheetObj.CellValue(iRow,prefix+"pol_yd_cd").substring(5,8);
				}
				
				CellValue2(iRow,"pod_cd")=sheetObj.CellValue(iRow,prefix+"pod_cd");
				if (!ComIsEmpty(sheetObj.CellValue(iRow,prefix+"pod_yd_cd"))){
					CellValue2(iRow,"pod_yd_cd")=sheetObj.CellValue(iRow,prefix+"pod_yd_cd").substring(5,8);
				}
				 
				CellValue2(iRow,"bkg_vvd_cd")=sheetObj.CellValue(iRow,prefix+"vsl_cd")+sheetObj.CellValue(iRow,prefix+"skd_voy_no")+sheetObj.CellValue(iRow,prefix+"skd_dir_cd");
				CellValue2(iRow,"pol_clpt_ind_seq")=sheetObj.CellValue(iRow,prefix+"pol_clpt_ind_seq");
				CellValue2(iRow,"pod_clpt_ind_seq")=sheetObj.CellValue(iRow,prefix+"pod_clpt_ind_seq");
			}
		}
	} 

	function checkTsCloseByBayPlan(){		
		closedVvds = "";
		
		var param = "f_cmd="+SEARCH01;
		for(var iRow=1;iRow<sheetObjects[4].Rows;iRow++){
			param = param + "&ibflag=U"
						  + "&pol_cd=" + sheetObjects[4].CellValue(iRow,"pol_cd")
						  + "&pol_yd_cd=" + sheetObjects[4].CellValue(iRow,"pol_yd_cd")
						  + "&pol_clpt_ind_seq=" + sheetObjects[4].CellValue(iRow,"pol_clpt_ind_seq")
						  + "&vsl_cd=" + sheetObjects[4].CellValue(iRow,"bkg_vvd_cd").substring(0,4)
						  + "&skd_voy_no=" + sheetObjects[4].CellValue(iRow,"bkg_vvd_cd").substring(4,8)
						  + "&skd_dir_cd=" + sheetObjects[4].CellValue(iRow,"bkg_vvd_cd").substring(8,9)
		}
		
		var sRow2=sheetObjects[1].FindCheckedRow(prefix2+"chk");
		var arrRow2 = sRow2.split("|"); 
		for(var iRow=0;iRow<arrRow2.length-1;iRow++){
			param = param + "&"+prefix2+"ibflag=U&"+prefix2+"bkg_no=" + sheetObjects[1].CellValue(arrRow2[iRow],prefix2+"bkg_no")
		}
		
		ComOpenWait(true);
		var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_1157GS.do?"+param);
		ComOpenWait(false);		

		closedVvds = ComGetEtcData(sXml, "closedVvds");
		if(closedVvds != null && closedVvds.length > 0){
			ComShowCodeMessage("BKG08253",closedVvds);
		}
		return true;
	}

	/* 개발자 작업  끝 */