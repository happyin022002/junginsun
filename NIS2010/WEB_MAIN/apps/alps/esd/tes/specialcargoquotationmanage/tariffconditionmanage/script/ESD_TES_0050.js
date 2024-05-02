/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0050.js
*@FileTitle : Tariff Condition Registry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
* 1.0 Creation
* 2013.04.04 yoo 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview awkward cargo tariff 업무에서 condition을 관리 
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_TES_0050 : ESD_TES_0050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_0050(){
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    }
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var condDtlHeadCount = 0;
	var cond_dp_curr_sel_row = 1;
	var cond_dp_curr_sel_col = 2;
     

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

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
        doActionIBSheetObjectList(sheetObjects[1],document.form,IBSEARCH);
        ComSetFocus(document.form.cond_no);
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo){
        var cnt = 0;
        switch(sheetObj.id) {
            
			case "sheet1":      //condition display
                with (sheetObj) {

                    // 높이 설정
                    style.height = 162;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "||A|B|C|D|E|F|G|H|I|J|K|L|M";
					var headCount = ComCountHeadTitle(HeadTitle1);
					condDtlHeadCount = headCount;
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, false);
                    var prefix = "sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col1",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col2",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col3",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col4",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col5",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col6",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col7",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col8",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col9",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col10",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col11",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col12",			false,      "",				dfEngKey,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		prefix+"col13",			false,      "",				dfEngKey,		0,			false,		false);
					
					InitDataValid(0, prefix+"col1", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col2", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col3", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col4", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col5", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col6", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col7", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col8", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col9", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col10", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col11", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col12", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					InitDataValid(0, prefix+"col13", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					
					CountPosition = 0;
					
					SelectionMode = smSelectionFree; //추가
				}
                break;
                
			case "sheet2":   //object list
				with (sheetObj) {
					
					// 높이 설정
					style.height = 180;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					var HeadTitle1 = "||obj_list_no|obj_list_nm|obj_list_abbr_nm|tml_obj_list_tp_cd|tml_meas_ut_cd|tml_val_tp_cd|dflt_ctnt|dflt_val|max_val|min_val|obj_rmk|inter_use_flg|delt_flg";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					var prefix = "";
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_list_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_list_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_list_abbr_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_obj_list_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_meas_ut_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_val_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"dflt_ctnt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"dflt_val",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"max_val",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"min_val",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_rmk",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"inter_use_flg",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		prefix+"delt_flg",			false,      "",				dfNone,		0,			false,		false);
					
					CountPosition = 0;
				}
				break;
                
			case "sheet3":	//condition hdr
				with (sheetObj) {
					
					// 높이 설정
					style.height = 180;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					var HeadTitle1 = "||cond_no|cond_nm|cond_desc|cond_sys_desc|tml_awk_cgo_cond_tp_cd|cond_cre_tp_cd|cond_cre_sts_cd|cond_fx_flg|row_no|delt_flg|delt_dt|chk_cond_no_ref";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					var prefix = "";
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_desc",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_sys_desc",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_awk_cgo_cond_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_cre_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_cre_sts_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_fx_flg",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"row_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"delt_flg",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"delt_dt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"chk_cond_no_ref",			false,      "",				dfNone,		0,			false,		false);
					
					CountPosition = 0;
				}			
				break;
			
			case "sheet4":	//condition dtl data (DISPLAY DESC)
				with (sheetObj) {
					
					// 높이 설정
					style.height = 180;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					var HeadTitle1 = "||cond_dtl_use_tp_cd|cond_seq|obj_dp_nm|tml_cond_dtl_tp_cd|tml_cond_opr_cd|obj_list_no|cond_opr_val_ctnt|tml_obj_list_tp_cd|obj_delt_flg";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					var prefix = "";
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_dtl_use_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_seq",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_dp_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_cond_dtl_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_cond_opr_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_list_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_opr_val_ctnt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_obj_list_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_delt_flg",			false,      "",				dfNone,		0,			false,		false);
					
					CountPosition = 0;
				}
				break;
				
			case "sheet5":	//condition dtl data (SYSTEM DESC)
				with (sheetObj) {
					
					// 높이 설정
					style.height = 180;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					var HeadTitle1 = "||cond_dtl_use_tp_cd|cond_seq|obj_dp_nm|tml_cond_dtl_tp_cd|tml_cond_opr_cd|obj_list_no|cond_opr_val_ctnt|tml_obj_list_tp_cd|obj_delt_flg";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					var prefix = "";
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,	0,		daCenter,	true,		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_dtl_use_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_seq",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_dp_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_cond_dtl_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_cond_opr_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_list_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cond_opr_val_ctnt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"tml_obj_list_tp_cd",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"obj_delt_flg",			false,      "",				dfNone,		0,			false,		false);
					
					CountPosition = 0;
				}			
				break;			
        }
     }
     
     function isAble2UpdateFunc(){
		 /**
   		  * TODO: SELCGS/SELCCB 만 삭제 가능케하기
   		  * 		+ TARIFF에서 참조시 삭제 및 수정 제한하기 추가
   		  */
   		 if (tes_isAwkSpclAuthOfc(document.form.login_ofc_cd.value)){   		  
        	 if (sheetObjects[2].RowCount==1){
        		 if (sheetObjects[2].CellValue(1,'chk_cond_no_ref')=='Y'){
//        			 alert('Not allowed to modify');
//        			 return false;  /** SELCGS/SELCCB 만 허용함에 일단 풀어놓기로 함 **/
        		 }
        		 if (sheetObjects[2].CellValue(1,'cond_fx_flg')=='N'){
        			 return true;
        		 }        			 
        	 } else if (sheetObjects[2].RowCount==0){
        		 return true;
        	 } else {
        		 return false;
        	 }
    	 }
    	 return false;
     }
     
     function resetForm(){
    	 var formObject = document.form;
    	 sheetObjects[0].RemoveAll();
    	 sheetObjects[1].RemoveAll();
    	 sheetObjects[2].RemoveAll();
    	 sheetObjects[3].RemoveAll();
    	 sheetObjects[4].RemoveAll();
    	 doActionIBSheetObjectList(sheetObjects[1],document.form,IBSEARCH);
    	 formObject.tml_awk_cgo_cond_tp_cd.value = "";
    	 document.getElementById("tml_awk_cgo_cond_tp_cd").readOnly = false;
    	 formObject.cond_no.value = "";
    	 var dspXpr = document.getElementById("dspXpr");
    	 dspXpr.innerHTML = "";    	 
     }
     
     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
    	 
  		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		var sheetObject1 = sheetObjects[0]; //condition display
  		var sheetObject2 = sheetObjects[1]; //object list
  		var sheetObject3 = sheetObjects[2]; //condition hdr
  		var sheetObject4 = sheetObjects[3]; //condition dtl data (DISPLAY DESC)
  		var sheetObject5 = sheetObjects[4]; //condition dtl data (SYSTEM DESC)
  		
 		var formObject = document.form;
 		
     	try {
     		var srcName  = window.event.srcElement.getAttribute("name");
     		var altValue = window.event.srcElement.getAttribute("alt");
     		
     		switch(srcName) {
     		case "btn_New":
				resetForm();
				ComSetFocus(formObject.cond_no);
				break;

     		case "btn_New2":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			formObject.tml_awk_cgo_cond_tp_cd.value = "";
				formObject.cond_no.value = "";
				if (sheetObjects[2].RowCount==1){
					sheetObjects[2].CellValue(1,"cond_no") = '';
					sheetObjects[2].CellValue(1,"tml_awk_cgo_cond_tp_cd") = '';
				}
				ComSetFocus(formObject.cond_no);
				break;
				
     		case "btn_Retrieve":
     			doActionIBSheetConditionInfo(sheetObject4,document.form,IBSEARCH);
     			break;

     		case "btn_Delete":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			/**
     			 * TODO: 대상 CONDITION이 각각의 TARIFF에 사용하는게 확인되면 삭제를 막는다.
     			 * -> 화면단 + 서버단 둘다
     			 */
     			if(ComShowConfirm(ComGetMsg('TES21055'))){
     				doActionIBSheetConditionInfo(sheetObject4,document.form,IBDELETE);
     			}
     			break;

     		case "btn_Save":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			/**
     			 * TODO: 대상 CONDITION이 각각의 TARIFF에 사용하는게 확인되면 수정을 막는다.
     			 * -> 화면단 + 서버단 둘다
     			 */
     			doActionIBSheetConditionInfo(sheetObject4,document.form,IBSAVE);
     			break;

     		case "btn_Condition_Search":
		    	var sUrl = "/hanjin/ESD_TES_0057.do?ui_id=ESD_TES_0050&tml_awk_cgo_trf_tp_cd="+formObject.tml_awk_cgo_cond_tp_cd.value;
				var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
				if (rVal){
					resetForm();
					formObject.cond_no.value = rVal.cond_no;
//					formObject.tml_awk_cgo_cond_tp_cd.value = '';
					doActionIBSheetConditionInfo(sheetObjects[3],document.form,IBSEARCH);
				}
				ComSetFocus(document.form.cond_no);
     			break;

     		case "btng_Row_Add":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			if (sheetObject1.RowCount<=6){
     				sheetObject1.DataInsert(-1);
     				sheetObject1.SelectCell(sheetObject1.SelectRow,2);
     			}
     			break;
     			
     		case "btng_Row_Delete":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			if (sheetObject4.RowCount > 0){
     				for (var x=condDtlHeadCount-1; x>=2; x--){
     					if (getCondDpCellPosition2RowIdx2(sheetObject1.SelectRow,x)>0){
     						sheetObject4.RowDelete(getCondDpCellPosition2RowIdx2(sheetObject1.SelectRow,x),false);
     					}
     				}
         			sheetObject1.RowDelete(sheetObject1.SelectRow, false);
    				if (sheetObject1.RowCount > 0){
    					sheetObject1.SelectCell(1, 2); 
    				}
    				displayCondition(sheetObject4);
     			}
     			break;

     		case "btng_Cell_Add":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			cond_dp_curr_sel_row = sheetObjects[0].SelectRow;
     			cond_dp_curr_sel_col = sheetObjects[0].SelectCol;
     			var cond_dtl_row;
     			if (sheetObject1.RowCount > 0){
					if (sheetObject4.RowCount>0){
 						if ((getCondDpCellPosition2RowIdx()>0) && sheetObject4.RowCount>=getCondDpCellPosition2RowIdx()){
 							sheetObject4.SelectRow = getCondDpCellPosition2RowIdx()-1; //>1?(getCondDpCellPosition2RowIdx()-1):1;
 							cond_dtl_row = sheetObject4.DataInsert();
 						} else {
 							if (sheetObjects[0].SelectCol>0 && sheetObjects[0].SelectCol<condDtlHeadCount){
 								cond_dtl_row = sheetObject4.DataInsert(-1);
 							}
 						}
					} else {
						cond_dtl_row = sheetObject4.DataInsert(-1);
					}
					if (cond_dtl_row > 0){
						isRowAdded = true;	
						sheetObject4.CellValue2(cond_dtl_row,"cond_dtl_use_tp_cd") 		= "D";
 						sheetObject4.CellValue2(cond_dtl_row,"tml_awk_cgo_cond_tp_cd") 	= formObject.tml_awk_cgo_cond_tp_cd.value;
 						sheetObject4.CellValue2(cond_dtl_row,"obj_dp_nm") 				= "";
						sheetObject4.CellValue2(cond_dtl_row,"tml_cond_dtl_tp_cd")		= "C";
 						sheetObject4.CellValue2(cond_dtl_row,"tml_cond_opr_cd")			= "";
 						sheetObject4.CellValue2(cond_dtl_row,"obj_list_no")				= "-1";
//    					sheetObject4.CellValue2(cond_dtl_row,"tml_obj_list_tp_cd")		= "";
					}			
					displayCondition(sheetObject4);
     			}
     			break;
     			
     		case "btng_Cell_Delete":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			cond_dp_curr_sel_row = sheetObjects[0].SelectRow;
     			cond_dp_curr_sel_col = sheetObjects[0].SelectCol;
     			if (sheetObject1.RowCount > 0){
     				if ((getCondDpCellPosition2RowIdx()>0) && sheetObject4.RowCount>=getCondDpCellPosition2RowIdx()){
     					sheetObject4.RowDelete(getCondDpCellPosition2RowIdx(),false);
     					displayCondition(sheetObject4);
     				}
     			}
     			break;

     		case "btn1_OBJ":
     			if (!isAble2UpdateFunc()){
     				return;
     			}
     			cond_dp_curr_sel_row = sheetObjects[0].SelectRow;
     			cond_dp_curr_sel_col = sheetObjects[0].SelectCol;
				var cond_dtl_row = 0;
				var isRowAdded = false;
     			if (sheetObject1.RowCount > 0){
     				for (var i=1; i<=sheetObject2.RowCount; i++){
     					if (sheetObject2.CellValue(i,"obj_list_no") == altValue){
     						if (sheetObject2.CellValue(i,"delt_flg")=='Y'){
     							alert('Deleted object!');
     							return;
     						} else {
         						if (sheetObject4.RowCount>0){
             						if ((getCondDpCellPosition2RowIdx()>0) && sheetObject4.RowCount>=getCondDpCellPosition2RowIdx()){
             							sheetObject4.SelectRow = getCondDpCellPosition2RowIdx()-1;
             							cond_dtl_row = sheetObject4.DataInsert();
             						} else {
             							if (sheetObjects[0].SelectCol>0 && sheetObjects[0].SelectCol<condDtlHeadCount){
             								cond_dtl_row = sheetObject4.DataInsert(-1);
             							}
             						}
         						} else {
         							cond_dtl_row = sheetObject4.DataInsert(-1);
         						}
     							if (cond_dtl_row > 0){
     								isRowAdded = true;
     								sheetObject4.CellValue2(cond_dtl_row,"cond_dtl_use_tp_cd") 		= "D";
     	     						sheetObject4.CellValue2(cond_dtl_row,"tml_awk_cgo_cond_tp_cd") 	= formObject.tml_awk_cgo_cond_tp_cd.value;
     	     						sheetObject4.CellValue2(cond_dtl_row,"obj_dp_nm") 				= sheetObject2.CellValue(i,"obj_list_abbr_nm");
     	     						if (sheetObject2.CellValue(i,"tml_obj_list_tp_cd")=='P'){
     	     							sheetObject4.CellValue2(cond_dtl_row,"tml_cond_dtl_tp_cd")	= "P";
     	     						} else {
     	     							sheetObject4.CellValue2(cond_dtl_row,"tml_cond_dtl_tp_cd")	= "O";	
     	     						}
     	     						sheetObject4.CellValue2(cond_dtl_row,"tml_cond_opr_cd")			= "";
     	     						sheetObject4.CellValue2(cond_dtl_row,"obj_list_no")				= sheetObject2.CellValue(i,"obj_list_no");
     	     						sheetObject4.CellValue2(cond_dtl_row,"tml_obj_list_tp_cd")		= sheetObject2.CellValue(i,"tml_obj_list_tp_cd");
     							}     							
     						}
     					}
     				}
     				if (isRowAdded){
     					displayCondition(sheetObject4);	
     				}
     			}
     			break;
     		} // end switch
     	} catch(e){
     		if (e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }

     function getCondDpCellPosition2RowIdx(){
    	 var tmp_cond_dp_curr_sel_row = sheetObjects[0].SelectRow;
    	 var tmp_cond_dp_curr_sel_col = sheetObjects[0].SelectCol;
    	 return getCondDpCellPosition2RowIdx2(tmp_cond_dp_curr_sel_row, tmp_cond_dp_curr_sel_col);
     }

     function getCondDpCellPosition2RowIdx2(tmp_cond_dp_curr_sel_row, tmp_cond_dp_curr_sel_col){
    	 var rowIdx = -1;
    	 if (tmp_cond_dp_curr_sel_row>0 && tmp_cond_dp_curr_sel_col-1>0){
    		 if ((tmp_cond_dp_curr_sel_col-1) < condDtlHeadCount){
				 if (tmp_cond_dp_curr_sel_col%(condDtlHeadCount-1) == 0){
					 rowIdx = tmp_cond_dp_curr_sel_row * (condDtlHeadCount-2);
				 } else {
					 rowIdx = tmp_cond_dp_curr_sel_col%(condDtlHeadCount-1) - tmp_cond_dp_curr_sel_row + ((tmp_cond_dp_curr_sel_row-1)*(condDtlHeadCount-1));
				 }
        		 if (rowIdx > sheetObjects[3].RowCount){
        			 rowIdx = -2;
        		 }
        	 }
    	 }
    	 return rowIdx;
     }

     function getRowIdx2CondDpCellPosition(rowIdx){
    	 var cell_row_idx = '';
    	 var cell_col_idx = '';
    	 if (rowIdx>0 && rowIdx<=sheetObjects[3].RowCount){
    		 cell_row_idx = Math.ceil(rowIdx/(condDtlHeadCount-2));
    		 cell_col_idx = rowIdx%(condDtlHeadCount-2)==0?condDtlHeadCount-1:rowIdx%(condDtlHeadCount-2)+1;
    	 }
    	 return cell_row_idx+'|'+cell_col_idx;
     }
     
     function displayCondition(sheetObj){
    	 var curr_row_idx = 0;
    	 var cell_row_idx = '';
    	 var cell_col_idx = '';
		 var tmp = null;
		 var desc = '';
		 
    	 try {
			 if (sheetObj.RowCount > 0){
    			 sheetObjects[0].RemoveAll();
    		     for (var i=1; i<=sheetObj.RowCount; i++){
    		    	 rowIdx = getRowIdx2CondDpCellPosition(i);
    		    	 if (rowIdx!=null && rowIdx!=''){
    		    		 tmp = rowIdx.split('|');
    		    		 cell_row_idx = tmp[0];
    		    		 cell_col_idx = tmp[1];
    		    		 if (cell_row_idx!='' && cell_col_idx!=''){
        		    		 if (cell_row_idx!='' && curr_row_idx!=cell_row_idx){
        		    			 curr_row_idx = cell_row_idx;
        		    			 sheetObjects[0].DataInsert(-1);
        		    		 }
        		    		 sheetObjects[0].CellValue2(cell_row_idx,cell_col_idx) = sheetObj.CellValue(i,"obj_dp_nm");
    		    		 }
//    		    		 alert('displayCondition : ['+i+'] ' 
//	    				 + "\n  rowIdx: " + cell_row_idx
//	    				 + "\n  colIdx: " + cell_col_idx
//	    				 + "\n  obj_dp_nm: " + sheetObj.CellValue(i,"obj_dp_nm")
//	    				 );    		    		 
        				 if (sheetObj.CellValue(i,"tml_cond_dtl_tp_cd")=='C'){
        		    		 if (isAble2UpdateFunc()){
        		    			 sheetObjects[0].CellEditable(cell_row_idx,cell_col_idx) = true;
        		    		 }
        		    	 }
    		    	 }
    		    	 desc = desc + sheetObj.CellValue(i,"obj_dp_nm") + ' ';
    		     }
    		     sheetObjects[2].CellValue2(1,"cond_desc") = desc.trim();
    		     sheetObjects[0].SelectCell(cond_dp_curr_sel_row, cond_dp_curr_sel_col);
    		     dspXpr.innerHTML = desc.trim();
			 }
		 } catch(e){
		 }
     }
     
     function setObjBtn(){
    	 var formObj = document.form;
    	 var objBtnList = document.getElementById("objBtnList");
    	 var objColCount = 7;
    	 var strInnerHMTL = '';
    	 var cnt = 1;
    	 var arr_obj_tp = [['C','black'],['M','blue'],['Y','purple']];
    	 strInnerHMTL += "<table class=\"search_sm2\" border=\"0\" width=\"979\" >";
    	 for (var i=0; arr_obj_tp!=null && i<arr_obj_tp.length; i++){
    		 cnt = 1;
    		 for (var j=1; j<=sheetObjects[1].RowCount; j++){
    			 if (sheetObjects[1].CellValue(j,"tml_obj_list_tp_cd")==arr_obj_tp[i][0]){
    				 if (cnt%objColCount==1 && j<sheetObjects[1].RowCount){
    					 strInnerHMTL += " <tr class=\"h23\">";
    				 }
    				 if (sheetObjects[1].CellValue(j,"obj_list_no")!=''){
    					 strInnerHMTL +=  " <td width=\"100\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">"
    						 			+ " <tr><td class=\"btn2_left\"></td>"
    						 			+ " <td style=\"color:"+arr_obj_tp[i][1]+";\" class=\"btn2\" name=\"btn1_OBJ\" alt=\""+sheetObjects[1].CellValue(j,"obj_list_no")+"\">"+sheetObjects[1].CellValue(j,"obj_list_abbr_nm")+"</td>"
    						 			+ " <td class=\"btn2_right\"></td>"
    						 			+ " </tr></table></td>"
    						 			;
    				 }
    				 if (cnt%objColCount==0 || (cnt%objColCount<objColCount && j==sheetObjects[1].RowCount)){
    					 strInnerHMTL += " <td colspan = \""+(11-(cnt%objColCount))+"\"></td>";
    					 strInnerHMTL += " </tr>";
    				 }
    				 cnt++;
    			 }
    		 }
    	 }
         strInnerHMTL += "</table>";    		 
    	 objBtnList.innerHTML = strInnerHMTL;
     }

     function setOprBtn(){
    	 var formObj = document.form;
    	 var oprBtnList = document.getElementById("oprBtnList");
    	 var oprColCount = 8;
    	 var strInnerHMTL = '';
    	 var cnt = 1;
    	 var showHdr = false;
    	 var arr_obj_tp = [['P','black']];
    	 strInnerHMTL += "<table class=\"search_sm2\" border=\"0\" width=\"979\" >";
    	 for (var i=0; arr_obj_tp!=null && i<arr_obj_tp.length; i++){
    		 cnt = 1;
    		 for (var j=1; j<=sheetObjects[1].RowCount; j++){
    			 if (sheetObjects[1].CellValue(j,"tml_obj_list_tp_cd")==arr_obj_tp[i][0]){
    				 if (cnt%oprColCount==1 && j<sheetObjects[1].RowCount){
    					 strInnerHMTL += " <tr class=\"h23\">";
    				 }
    				 if (!showHdr){
    					 strInnerHMTL += "<td width=\"60\" valign=\"top\" rowspan=\"2\">Operator</td>";
    					 showHdr = true;
    				 }
    				 if (sheetObjects[1].CellValue(j,"obj_list_no")!=''){
    					 strInnerHMTL +=  " <td width=\"60\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">"
    						 			+ " <tr><td class=\"btn2_left\"></td>"
    						 			+ " <td style=\"color:gray;\" class=\"btn2\" name=\"btn1_OBJ\" alt=\""+sheetObjects[1].CellValue(j,"obj_list_no")+"\">"+sheetObjects[1].CellValue(j,"obj_list_abbr_nm")+"</td>"
    						 			+ " <td class=\"btn2_right\"></td>"
    						 			+ " </tr></table></td>"
    						 			;
    				 }
    				 if (cnt%oprColCount==0 || (cnt%oprColCount<oprColCount && j==sheetObjects[1].RowCount)){
    					 strInnerHMTL += " <td colspan = \""+(17-(cnt%oprColCount))+"\"></td>";
    					 strInnerHMTL += " </tr>";
    				 }
    				 cnt++;
    			 }
    		 }
    	 }
         strInnerHMTL += "</table>";    		 
    	 oprBtnList.innerHTML = strInnerHMTL;
     }

     function getSaveString(params){
    	 var saveString = null;
    	 if (params == null) {
    		 saveString = "";
    	 } else {
    		 saveString = params.join("&");
    	 }
    	 return saveString;
     }
     
     function ComTesSetPrefix(sStr, sPrefix){
    	 if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
    		 return sStr;
    	 }
    	 var regexp = RegExp(/&/g);
    	 sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
    	 return sStr;
     }

     function doActionIBSheetConditionInfo(sheetObj,formObj,sAction){
    	 sheetObj.ShowDebugMsg = false;
    	 switch(sAction) {
    	 case IBSEARCH:
    		 if (formObj.cond_no.value==''){
    			 alert('Condition No. should be entered');
    			 return;
    		 }
    		 ComOpenWait(true);
    		 formObj.f_cmd.value = SEARCH;
    		 var sXml = sheetObj.GetSearchXml("ESD_TES_0050GS.do", FormQueryString(formObj));
    		 var arrXml = sXml.split("|$$|");
    		 sheetObjects[2].LoadSearchXml(arrXml[0]);
    		 sheetObjects[3].LoadSearchXml(arrXml[1]);
    		 sheetObjects[4].LoadSearchXml(arrXml[2]);
    		 ComOpenWait(false);
    		 break;
    		 
    	 case IBDELETE:
    		 if (sheetObjects[2].RowCount<=0){
    			 return;
    		 }
    		 var params = new Array();
    		 params[0] = ComTesSetPrefix(sheetObjects[2].GetSaveString(true,false),"sheet3_");
    		 var sParam = getSaveString(params);
    		 if (sParam == ""){
    			 return;
    		 } else {
    			 try {
        			 formObj.f_cmd.value = REMOVE;
        			 sParam = sParam + "&" + FormQueryString(formObj);
            		 ComOpenWait(true);
            		 var sXml = sheetObj.GetSaveXml("ESD_TES_0050GS.do", sParam);
            		 var arrXml = sXml.split("|$$|");
            		 sheetObjects[2].LoadSaveXml(arrXml[0]);
            		 sheetObjects[3].LoadSaveXml(arrXml[1]);
            		 sheetObjects[4].LoadSaveXml(arrXml[2]);
            		 ComOpenWait(false);    		 
    			 } catch(e){
    				 ComOpenWait(false);
    			 }
    		 }	 
    		 break;
    		 
    	 case IBSAVE:
     		 if (formObj.tml_awk_cgo_cond_tp_cd.value==''){
     			 alert('Condition Type should be selected');
     			 return;
     		 } else {
     			 
     			 /**
     			  * TODO: 상수란이 비어있으면 채우라고 팅기기  + 상수란 숫자인지 확인할것
     			  */
        		 if (sheetObjects[2].RowCount <= 0){ // 첨부터 condition 조회 된게 없다는 의미
        			 sheetObjects[2].SelectRow = sheetObjects[2].DataInsert();
        			 sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"tml_awk_cgo_cond_tp_cd") = formObj.tml_awk_cgo_cond_tp_cd.value;
        		 } else if (sheetObjects[2].RowCount == 1){ 
        			 if (sheetObjects[2].CellValue(1,"cond_no")==''){ // NEW2로 처리되는 경우 - ROW는 존재하나 COND_NO만 없다 새로 받는다.
        				 sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"tml_awk_cgo_cond_tp_cd") = formObj.tml_awk_cgo_cond_tp_cd.value;	 
        			 }
        		 }
     		 }
    	 		
    		 processSystemDescription();
//    		 if (!confirm('validateSystemDescription - go?')){
//    			 return;
//    		 }
    		 
    		 /**
    		  * 저장 처리
    		  */
    		 var params = new Array();
    		 params[0] = ComTesSetPrefix(sheetObjects[2].GetSaveString(true,true),"sheet3_");
    		 params[1] = ComTesSetPrefix(sheetObjects[3].GetSaveString(true,true),"sheet4_");
    		 params[2] = ComTesSetPrefix(sheetObjects[4].GetSaveString(true,true),"sheet4_");
    		 var sParam = getSaveString(params);
    		 if (sParam == ""){
    			 return;
    		 } else {
    			 try {
        			 formObj.f_cmd.value = MULTI;
        			 sParam = sParam + "&" + FormQueryString(formObj);
            		 ComOpenWait(true);
            		 var sXml = sheetObj.GetSaveXml("ESD_TES_0050GS.do", sParam);
            		 var arrXml = sXml.split("|$$|");
            		 sheetObjects[2].LoadSaveXml(arrXml[0]);
            		 sheetObjects[3].LoadSaveXml(arrXml[1]);
            		 sheetObjects[4].LoadSaveXml(arrXml[2]);
            		 ComOpenWait(false);    		 
    			 } catch(e){
    				 ComOpenWait(false);
    			 }
    		 }
    		 break;
    	 }
     }

     function processSystemDescription(){
 		 var tmp_calc_ratio = 1;
   		 var desc = ''; 
 		 var sys_desc = '';
 		 var arr_uom_pair = [['ft','inch'],['m','cm'],['mt','kg']];

		 if (sheetObjects[3].RowCount > 0){
			 for (var i=1; i<=sheetObjects[3].RowCount; i++){
				 desc = desc + sheetObjects[3].CellValue(i,"obj_dp_nm") + ' ';
//				 if (sheetObjects[3].CellValue(i,"tml_cond_dtl_tp_cd")=='C'){
//					 if (isNaN(sheetObjects[3].CellValue(i,"obj_dp_nm"))){
//						 alert('Number should be entered');
//					 }
//				 }
			 }
			 sheetObjects[2].CellValue2(1,"cond_desc") = desc.trim();
			 sheetObjects[4].RemoveAll();
    		 tes_copy_rows_to2(sheetObjects[4],sheetObjects[3].GetSaveString(true),true);
    		 if (sheetObjects[4].RowCount > 0){
    			 for (var i=1; i<=sheetObjects[4].RowCount; i++){
    				 if (sheetObjects[4].CellValue(i,"tml_obj_list_tp_cd")=='M'){
    					 if (i>1){
        					 if (sheetObjects[4].CellValue(i-1,"tml_cond_dtl_tp_cd")=='C' && 
        					     sheetObjects[4].CellValue(i-1,"obj_dp_nm")!='' 
        					 ){
        						 if (!isNaN(sheetObjects[4].CellValue(i-1,"obj_dp_nm"))){
            						 tmp_calc_ratio = getMeasureUnitRatio(sheetObjects[4].CellValue(i,"obj_dp_nm"));
            						 sheetObjects[4].CellValue2(i-1,"obj_dp_nm") 			= Math.round((sheetObjects[4].CellValue(i-1,"obj_dp_nm")*tmp_calc_ratio)*100)/100;
            						 sheetObjects[4].CellValue2(i-1,"cond_opr_val_ctnt") 	= Math.round((sheetObjects[4].CellValue(i-1,"cond_opr_val_ctnt")*tmp_calc_ratio)*100)/100;
            						 sheetObjects[4].RowDelete(i,false);
            						 tmp_calc_ratio = 1;
        						 }
        					 }
    					 }
    				 }
    			 }
    			 for (var i=1; i<=sheetObjects[4].RowCount; i++){
    				 if (sheetObjects[4].CellValue(i,"tml_cond_dtl_tp_cd")=='C' 
    					 && i>1 && sheetObjects[4].CellValue(i-1,"tml_cond_dtl_tp_cd")=='C'
    					 && !isNaN(sheetObjects[4].CellValue(i,"obj_dp_nm")) && !isNaN(sheetObjects[4].CellValue(i-1,"obj_dp_nm"))
    					 && !isNaN(sheetObjects[4].CellValue(i,"cond_opr_val_ctnt")) && !isNaN(sheetObjects[4].CellValue(i-1,"cond_opr_val_ctnt"))	)
    				 {
						 sheetObjects[4].CellValue2(i-1,"obj_dp_nm") 			= Number(sheetObjects[4].CellValue(i-1,"obj_dp_nm")) + Number(sheetObjects[4].CellValue(i,"obj_dp_nm")); 
						 sheetObjects[4].CellValue2(i-1,"cond_opr_val_ctnt") 	= Number(sheetObjects[4].CellValue(i-1,"cond_opr_val_ctnt")) + Number(sheetObjects[4].CellValue(i,"cond_opr_val_ctnt"));
						 sheetObjects[4].RowDelete(i,false);
    				 }
    				 sheetObjects[4].CellValue2(i,"cond_dtl_use_tp_cd") = 'S';
    			 }
    			 for (var i=1; i<=sheetObjects[4].RowCount; i++){
    				 sys_desc = sys_desc + sheetObjects[4].CellValue(i,"obj_dp_nm") + ' ';
    			 }
    			 sheetObjects[2].CellValue2(1,"cond_sys_desc") = sys_desc.trim();
    		 } else {
//    			 alert('No condition System Detail Description found Exception!');
    			 return;
    		 }
		 } else {
//			 alert('No condition Detail Description found Exception!');
			 return;
		 }
     }

     function getMeasureUnitRatio(meas_ut){
    	 var ratio = 1;
    	 try {
    		 if (meas_ut!=null && meas_ut!=''){
    			 switch(meas_ut){
    			 	case 'm':
    			 		ratio = 100;
    			 		break;
    			 	case 'cm':
    			 		ratio = 1;
    			 		break;
    			 	case 'ft':
    			 		ratio = 30.48;
    			 		break;
    			 	case 'inch':
    			 		ratio = 2.54;
    			 		break;
    			 	case 'mt':
    			 		ratio = 1000;
    			 		break;
    			 	case 'lbs':
    			 		ratio = 0.453592;
    			 		break;
    			 	case 'kg':
    			 		ratio = 1;
    			 		break;
    			 	default:    
    			 		ratio = 1;
    			 		break;
    			 }
    		 }
    	 } catch(e){
    		 ratio = 1;
    	 }
    	 return ratio;
     }
     
     function doActionIBSheetObjectList(sheetObj,formObj,sAction){
    	 sheetObj.ShowDebugMsg = false;
    	 switch(sAction) {
    	 case IBSEARCH:
    		 ComOpenWait(true);
    		 formObj.f_cmd.value = SEARCH01;
    		 var sXml = sheetObj.GetSearchXml("ESD_TES_0050GS.do", FormQueryString(formObj));
    		 sheetObj.LoadSearchXml(sXml);
    		 ComOpenWait(false);
    		 break;
    	 }
     }

     function setFormValue(sheetObj){
    	 var formObject = document.form;
    	 document.getElementById("tml_awk_cgo_cond_tp_cd").value = sheetObj.CellValue(1,'tml_awk_cgo_cond_tp_cd');
    	 document.getElementById("cond_no").value = sheetObj.CellValue(1,'cond_no');
//    	 document.getElementById("cond_sts").value = sheetObj.CellValue(1,'cond_cre_sts_cd');
//    	 var cond_sts = document.getElementById("cond_sts");
//    	 cond_sts.innerHTML = sheetObj.CellValue(1,'cond_cre_sts_cd');

    	 /** todo: cond_no가 있으면 tml_awk_cgo_cond_tp_cd의 선택불가로 변경  **/
    	 if (sheetObjects[2].RowCount==1){
    		 if (sheetObjects[2].CellValue(1,'cond_no')!=''){
//    			 setElementDiabled('select-one','tml_awk_cgo_cond_tp_cd','Y');
//    			 document.form.tml_awk_cgo_cond_tp_cd.disabled = true;
    			 document.getElementById("tml_awk_cgo_cond_tp_cd").disabled = true;
    		 }
    	 }
     }

     function sheet1_OnClick(sheetObj, row, col){
    	 cond_dp_curr_sel_row = row;
    	 cond_dp_curr_sel_col = col;
     }
     
     function sheet1_OnDblClick(sheetObj, row, col){
    	 cond_dp_curr_sel_row = row;
    	 cond_dp_curr_sel_col = col;
//    	 alert("OnDblClick   - row:"+row + " -- col:"+col + "  -- postion:" + getCondDpCellPosition2RowIdx2(row, col) + "  - condDtlHeadCount:" + condDtlHeadCount);
     }

     function sheet1_OnChange(sheetObj, Row, Col, Value){
//    	 var tmp_val = '';
//    	 if (sheetObjects[0].CellEditable(Row,Col) == true){
//    		 tmp_val = tes_deleteComma(Value);
//    		 alert(tmp_val);
//    		 if (isNaN(tmp_val)){
//    			 sheetObjects[0].CellValue2(Row,Col) = '';
//    			 alert('Number can be entered');
//    		 }
//    	 }
		 
    	 sheetObjects[0].SelectRow = Row;
    	 sheetObjects[0].SelectCol = Col;
    	 cond_dp_curr_sel_row = Row;
    	 cond_dp_curr_sel_col = Col;
    	 var rowIdx = getCondDpCellPosition2RowIdx2(Row, Col);
    	 if (sheetObjects[3].RowCount > 0 && rowIdx > 0){
    		 if (sheetObjects[3].CellValue(rowIdx,"tml_cond_dtl_tp_cd")=='C'){
//    			 alert('input value: ' +  sheetObj.CellValue(Row,Col) + '\n rowIdx:' + rowIdx);
    			 if (sheetObj.CellValue(Row,Col)!=''){
    				 sheetObj.CellValue2(Row,Col) = tes_deleteComma(sheetObj.CellValue(Row,Col));
        			 if (!isNaN(sheetObj.CellValue(Row,Col))){
            			 sheetObjects[3].CellValue2(rowIdx,"obj_dp_nm") 			= tes_deleteComma(Value);
            			 sheetObjects[3].CellValue2(rowIdx,"cond_opr_val_ctnt") 	= tes_deleteComma(Value);
        			 } else {
        				 sheetObj.CellValue2(Row,Col) = '';
        			 }
        			 displayCondition(sheetObjects[3]);    			 
    			 }
    		 }
    	 }
     }

     function sheet1_OnSearchEnd(sheetObj){
    	 ComSetFocus(document.form.cond_no);
     }

     function sheet2_OnSearchEnd(sheetObj){
    	 setObjBtn();
    	 setOprBtn();
     }
     
     function sheet3_OnSearchEnd(sheetObj){
    	 if (sheetObj.RowCount == 1){
    		 setFormValue(sheetObj);
    		 sheetObjects[0].SelectRow = 1;
    		 sheetObjects[0].SelectCol = 2;
    	 } else {
    		 resetForm();
    	 }
     }

     function sheet3_OnSaveEnd(sheetObj){
    	 if (sheetObj.RowCount == 1){
    		 setFormValue(sheetObj);
    		 sheetObjects[0].SelectRow = 1;
    		 sheetObjects[0].SelectCol = 2;
    	 } else {
    		 resetForm();
    	 }
     }
     
     function sheet4_OnSearchEnd(sheetObj){
    	 displayCondition(sheetObj);
     }

     function sheet4_OnSaveEnd(sheetObj){
    	 displayCondition(sheetObj);
    	 if (sheetObjects[2].RowCount > 0){
    		 if (sheetObjects[2].CellValue(1,"cond_cre_sts_cd")=="X"){
    			 alert("Invalid Condition");
    		 } else if (sheetObjects[2].CellValue(1,"cond_cre_sts_cd")=="E"){
    			 alert("Error occurred");
    		 }
    	 }
     }
     