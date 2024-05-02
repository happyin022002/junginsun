/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0997.js
*@FileTitle : COD Comfirm Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.06 최영희
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
     * @class ESM_BKG_0997 : ESM_BKG_0997 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0997() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var prefix4="sheet4_";
var prefix5="sheet5_";
var prefix6="sheet6_";
var sheetObjects = new Array();
var sheetCnt = 0;
var orgSplit = "";
var asCodeList = "";
var asTextList = "";
var strSheetTitle2=" |Move|Booking No.|B/L No.|T/VVD|Weight|Weight|Package|Package|Measure|Measure|AS||";
var strSheetTitle3="|TS|Q'ty ";
var strSheetTitle4="|CNTR|TS|ST|AS";
var strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObj = document.form;
		var param="";
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_ok":
					if (ComGetObjText(formObj.bdr_flag)=="Y"){
						comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "C");
						if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
							doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
            			}
					} else {
						doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
					}					     
				break; 
          
				case "btn_close":
					window.close();
				break;                                

            } // end switch
    	} catch(e) {
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
    function loadPage(asCode,asText) {
        asCodeList = " |"+asCode;
		asTextList = " |"+asText;
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true);
			ComEndConfigSheet(sheetObjects[i]);
        }
		
		 axon_event.addListenerForm('click', 'bkg0997_click', document.form); 
		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    }

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
//	function sheet1_OnLoadFinish(sheetObj) {   
//		sheetObj.WaitImageVisible = false;  
//		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
//		sheetObj.WaitImageVisible = true;   
//	} 


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,asCodeList,asTextList,flag) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init // org booking info
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|BKG|B/L No.|T/VVD|Weight|Weight|Package|Package|Measure|Measure|AS|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,	    	110,	daLeft,		false,		prefix1+"bkg_no",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		prefix1+"bl_no",			false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		prefix1+"tvvd",				false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,		prefix1+"act_wgt",			false,			"",      dfFloatOrg,		3,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix1+"wgt_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,		prefix1+"pck_qty",			false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix1+"pck_tp_cd",		false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,		prefix1+"meas_qty",			false,			"",      dfFloatOrg,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix1+"meas_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prefix1+"adv_shtg_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			 0,		daCenter,	true,		prefix1+"pc",				false,			"",		 dfNone,			0,		false,		true);
					ImageList(0) = "img/btng_pc.gif";	
					
					ColHidden(prefix1+"pc")=true;	
					InitDataCombo(0, prefix1+"adv_shtg_cd", asTextList,asCodeList);
					 
					//if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
					//	ColHidden(prefix1+"adv_shtg_cd")=true;	
					//}
					 
																				
               }
                break;

			  case 2:      //sheet2 init//split 정보
				with (sheetObj) {

						// 높이 설정
						style.height = 102;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 2, 100);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(false, true, false, true, false,false);

						var HeadTitle1 = strSheetTitle2;
						var headCount = ComCountHeadTitle(HeadTitle1);
						 
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					    InitDataProperty(0, cnt++ , dtHiddenStatus,			 30,		daCenter,		false,		prefix2+"ibflag");
						InitDataProperty(0, cnt++ , dtRadioCheck,			 50,		daCenter,		false,		prefix2+"move",				false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					 100,		daLeft,			false,		prefix2+"bkg_no",			false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				 110,		daCenter,		true,		prefix2+"bl_no",			false,			"",      dfEngUpKey,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				 110,		daCenter,		true,		prefix2+"tvvd",				false,			"",      dfEngUpKey,		0,		true,		true,  9);
                                                                                               	
						InitDataProperty(0, cnt++ , dtData,				 	 100,		daRight,		true,		prefix2+"act_wgt",			false,			"",      dfFloatOrg,		3,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				 	 40,		daCenter,		true,		prefix2+"wgt_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,				 	 80,		daRight,		true,		prefix2+"pck_qty",			false,			"",      dfFloatOrg,		2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				 	 40,		daCenter,		true,		prefix2+"pck_tp_cd",		false,			"",      dfEngUpKey,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,					 80,		daRight,		true,		prefix2+"meas_qty",			false,			"",      dfFloatOrg,		2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,				 	 40,		daCenter,		true,		prefix2+"meas_ut_cd",		false,			"",      dfEngUpKey,		0,		false,		false);						
						InitDataProperty(0, cnt++ , dtHidden,				 50,		daCenter,		true,		prefix2+"adv_shtg_cd",		false,			"",      dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtHidden,				 70,		daCenter,		true,		prefix2+"rtn_route",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtHidden,				 0,		    daCenter,	    true,		prefix2+"pc",				false,			"",		 dfNone,			0,		true,		true);
						//ImageList(0) = "img/btng_pc.gif";		 
						//ColHidden(prefix2+"pc")=true; 
						//InitDataCombo(0, prefix2+"adv_shtg_cd", asTextList,asCodeList);

						//if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
						//	ColHidden(prefix2+"adv_shtg_cd")=true;	
						//}
						
						CountPosition = 0;

					}
					break;

			case 3:      //sheet3 init// qty 배분
				with (sheetObj) {

						// 높이 설정
						style.height = 120;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 2, 100);

						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, false, false, false, false,false);
						 
						var HeadTitle1 = strSheetTitle3;
						var headCount = ComCountHeadTitle(HeadTitle1);
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 3, 0, true);


						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,			prefix3+"ibflag");
						InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,			prefix3+"cntr_tpsz_cd",			false,			"",      dfNone,		0,		false,		false); 
						InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,			prefix3+"op_cntr_qty",			false,			"",      dfNullFloat,	2,		false,		false);
						  
						if(orgSplit.length>1){
							InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,			prefix3+orgSplit,				false,			"",      dfFloat,		2,		true,		true); 
						}
						 					 
						CountPosition = 0; 
					}
					break;
					
			case 4:      //sheet4 init// cntr 배분
				with (sheetObj) {

						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 2, 100);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, false, false, false, false,false);

						var HeadTitle1 = strSheetTitle4; 
						var headCount = ComCountHeadTitle(HeadTitle1);
					    
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 5, 0, true);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		prefix4+"ibflag");
						InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix4+"cntr_no",			false,			"",      dfNone,			0,		false,		false); 
						InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix4+"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix4+"cnmv_sts_cd",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,	true,		prefix4+"adv_shtg_cd",		false,			"",      dfNone,			0,		false,		false); 
						if(flag &&  orgSplit.length>1){
							InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		prefix4+orgSplit,			false,			"",      dfNone,			0,		true,		true);
						}
						InitDataCombo(0, prefix4+"adv_shtg_cd", asTextList,asCodeList);
						if(ComGetObjValue(document.form.splitreason).toUpperCase()=="C"){
							ColHidden(prefix4+"adv_shtg_cd")=true;	
						}
						CountPosition = 0;
					}
					break;	
			case 5:      //sheet5 init// spcl 배분
				with (sheetObj) {

						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 2, 100);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, false, false, false, false,false);

						var HeadTitle1 = strSheetTitle5; 
						var headCount = ComCountHeadTitle(HeadTitle1);
					    
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 5, 0, true);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		prefix5+"ibflag");
						InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix5+"code",			false,			"",      dfNone,			0,		false,		false); 
						InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		prefix5+"cntr_no",		false,			"",      dfNone,			0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		prefix5+"dcgo_seq",		false,			"",      dfNone,			0,		false,		false);
						 
						CountPosition = 0;
					}
					break;	
				case 6:  //sheet6 init    
					with (sheetObj) {
						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = 150;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

					   //전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 1, 1, 3, 100);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(14, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false)

						var HeadTitle = "|Cd|Seq|Pol1|Pod1|PolSeq|PodSeq|VslCd|SkdVoyNo|SkdDirCd|SlanCd|||";

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,		false,	prefix6+"ibflag");
						InitDataProperty(0, cnt++ , dtData,			55,		daCenter,		false,	prefix6+"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			50,		daLeft,			false,	prefix6+"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,			90,		daLeft,			false,	prefix6+"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daLeft,			false,	prefix6+"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,   		90,    	daCenter,  		false,  prefix6+"pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,   		90,    	daCenter,  		false,  prefix6+"pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtData,			90,		daLeft,			false,	prefix6+"vsl_cd",				false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daLeft,			false,	prefix6+"skd_voy_no",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daLeft,			false,	prefix6+"skd_dir_cd",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			50,		daLeft,			false,	prefix6+"slan_cd",				false,		"",	dfNone,		0,		true,		true);
						
						InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  		false,  prefix6+"bkg_no");
						InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  		false,  prefix6+"cod_rqst_seq");
						InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  		false,  prefix6+"vvd_op_cd");

						CountPosition = 0;
				   }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_","sheet3_","sheet4_","sheet5_","sheet6_","sheet2_");
        switch(sAction) {
          
          case IBSEARCH:      //조회
	         formObj.f_cmd.value = SEARCH; 
			 var codParam = ComGetObjValue(formObj.paramVvd);
			 
			 sheetObj.WaitImageVisible = false;  
			 ComOpenWait(true);			   
			 var sXml = sheetObj.GetSearchXml("ESM_BKG_0997GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix)+ codParam); 
			 ComOpenWait(false);
			
			 var arrXml = sXml.split("|$$|");
			 if (ComGetTotalRows(arrXml[0]) == 0) ComShowCodeMessage("BKG00889");
			 iniFormSheet(); 
			 for(var i = 0; i < arrXml.length; i++){ 
				if(i==0){
					sheetObjects[i].Redraw = false;    
					if(i > 0) {
						sheetObjects[i].WaitImageVisible = false;	
					}  
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
					sheetObjects[i].Redraw = true;
				}else{
					sheetObjects[i+1].Redraw = false;    
					if(i > 0) {
						sheetObjects[i+1].WaitImageVisible = false;	
					}
					sheetObjects[i+1].LoadSearchXml(arrXml[i]); 
					sheetObjects[i+1].Redraw = true;					 
				}
			} 
			  
			
			if(ComGetObjValue(formObj.bkg_no).length==11 || ComGetObjValue(formObj.bkg_no).length==13){ //old bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit="91";
				}else{
					orgSplit="00";
				}
			}else if(ComGetObjValue(formObj.bkg_no).length==12){  //new bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit=sheetObj.EtcData("memoSplitNo");
				}else{
					orgSplit=sheetObj.EtcData("custSplitNo");
				}
			}
			ComSetObjValue(formObj.rtn_route, sheetObj.EtcData("rtn_route"));
			setFormData(formObj,sheetObj);
			 
			var splitCnt=0; 
			splitCnt=ComParseInt(formObj.splitcount)-1;
			sheet_splitSet(ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			autoVolume(ComParseInt(formObj.splitcount),ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			
			Check_Cntr(sheetObjects[3],prefix4+orgSplit,prefix4+sheetObjects[1].CellValue(2,prefix2+"bkg_no").substring(10)); 
			sheetObjects[1].CellValue2(2,prefix2+"move")=1;  
			 
			 break;
		 case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
		 	for(i = 1; i<sheetObjects[1].Rows;i++){
		 		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="C"){
		 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="90"){
		 				ComShowCodeMessage("BKG00884");
		 				return;
		 			}
		 		} else {
		 			if(sheetObjects[1].CellValue(i, prefix2+"bkg_no").substring(10)=="100"){
		 				ComShowCodeMessage("BKG00884");
		 				return;		 	
		 			}
		 		}
		 	}
			setQtyCntrCgoVar(formObj);
			var rtnRoute = ComGetObjValue(formObj.rtn_route);
			if (ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
				sheetObjects[1].CellValue2(2, prefix2+"rtn_route") = rtnRoute;
			}else{
				sheetObjects[1].CellValue2(2, prefix2+"rtn_route") = rtnRoute;
			}
			var params = FormQueryString(formObj);
            params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
			params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
			params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
			params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true)); 
			params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true)); 
			 
			sheetObj.WaitImageVisible = false;  
			ComOpenWait(true);
			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0997GS.do", params);  
			ComOpenWait(false);
			
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			sheetObjects[1].LoadSaveXml(sXml);     
			if(State == "S"){
				if(!opener) opener = window.dialogArguments; 
				 opener.callSearch();
				 window.close(); 
			}
		break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	/*
	* Form, Grid 초기화
	*/
	function iniFormSheet(){
		orgSplit="";
		strSheetTitle3="|TS|Q'ty";
		strSheetTitle4="|CNTR|TS|ST|AS";
		strSheetTitle5="|CODE|CNTR_NO|DCGO_SEQ";
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,asCodeList,asTextList,true);
            ComEndConfigSheet(sheetObjects[i]);
        }
		 
		sheetObjects[2].ExtendLastCol = false;
		sheetObjects[3].ExtendLastCol = false; 
	}

	/*
	* Click 이벤트 처리
	*/
	function bkg0997_click(){
		obj = event.srcElement;
		formObj= document.form;
	    if (obj.name="splitreason"){
			var splitCnt=0;
			if(ComGetObjValue(formObj.bkg_no).length==11 || ComGetObjValue(formObj.bkg_no).length==13){ //old bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit="91";
				}else{
					orgSplit="00";
				}
				 
			}else if(ComGetObjValue(formObj.bkg_no).length==12){  //new bkg_no
				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					orgSplit=ComGetObjValue(formObj.memoSplitNo); 
				}else{
					orgSplit=ComGetObjValue(formObj.custSplitNo); 
				}
				
			}
			ComSetObjValue(formObj.lastSplitNo,orgSplit); 
			splitCnt=ComParseInt(formObj.splitcount)-1;
			sheet_splitSet(ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			autoVolume(ComParseInt(formObj.splitcount),ComGetObjValue(formObj.splitreason),ComParseInt(formObj.lastSplitNo),splitCnt);
			
			if (ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
				Check_Cntr(sheetObjects[3],prefix4+orgSplit,prefix4+sheetObjects[1].CellValue(3,prefix2+"bkg_no").substring(10));
				sheetObjects[1].CellValue2(1, prefix2+"act_wgt") = sheetObjects[0].CellValue(1, prefix1+"act_wgt");
				sheetObjects[1].CellValue2(1, prefix2+"wgt_ut_cd") = sheetObjects[0].CellValue(1, prefix1+"wgt_ut_cd");
				sheetObjects[1].CellValue2(1, prefix2+"pck_qty") = sheetObjects[0].CellValue(1, prefix1+"pck_qty");
				sheetObjects[1].CellValue2(1, prefix2+"pck_tp_cd") = sheetObjects[0].CellValue(1, prefix1+"pck_tp_cd");
				sheetObjects[1].CellValue2(1, prefix2+"meas_qty") = sheetObjects[0].CellValue(1, prefix1+"meas_qty");
				sheetObjects[1].CellValue2(1, prefix2+"meas_ut_cd") = sheetObjects	[0].CellValue(1, prefix1+"meas_ut_cd");
				sheetObjects[1].RowEditable(1)=false;
			}else{
				Check_Cntr(sheetObjects[3],prefix4+orgSplit,prefix4+sheetObjects[1].CellValue(2,prefix2+"bkg_no").substring(10));
			}
			sheetObjects[1].CellValue2(2,prefix2+"move")=1; 
	    } 
	}
//	 function getSplitBkgNo1(splitreason,lastno,splitcount,orgBkgNo,bkgNo){
//		var imeno=0;
//		var newSplitBkgNo=new Array();
//		var idx=0;
//        
//		for (var i=lastno;i<=splitcount;i++ ){
//			 if(splitreason.toUpperCase() =="C"){
//				if(idx==0){
//					newSplitBkgNo[idx]=orgBkgNo;
//				}else{
//					newSplitBkgNo[idx]=bkgNo.substring(0,10)+ComLpad(i,2,"0");
//				}
//				if(i=="90"){
//					ComShowCodeMessage("BKG00884");
//					return null;
//				}
//			 }else{
//				newSplitBkgNo[idx]=bkgNo.substring(0,10)+ComLpad(i,2,"9");
//				if(i=="100"){
//					ComShowCodeMessage("BKG00884");
//					return null;
//				}
//			 }
//			 idx++;
//		}
//		return newSplitBkgNo;
//	}

	/*
	* 자동으로 Volume분할
	*/
	function autoVolume(splitNo,splitreason,lastno,splitcount){
		var colTile ="";
		var fWgt =ComTrunc(ComTrunc(sheetObjects[0].CellValue(1,prefix1+"act_wgt"),3)/splitNo,3);
		var fWgtLast=0;
		var fPkg =ComParseInt(sheetObjects[0].CellValue(1,prefix1+"pck_qty")/splitNo);
		var fPkgLast =0;
		var fMea =ComTrunc(ComTrunc(sheetObjects[0].CellValue(1,prefix1+"meas_qty"),2)/splitNo,2);
		var fMeaLast =0;
		var newBkgNo = ComGetObjValue(document.form.bkgsplitno);
		 
		if (newBkgNo.length<1){
			newBkgNo =sheetObjects[0].CellValue(1,prefix1+"bkg_no");
		}else{
			newBkgNo =ComGetObjValue(document.form.bkgsplitno);
		}
		 
		var newSplitBkgNo=getSplitBkgNo(splitreason,lastno,splitcount+lastno,sheetObjects[0].CellValue(1,prefix1+"bkg_no"),newBkgNo);

		with(sheetObjects[1]){
			for(var i=0;i<splitNo;i++){
				if (splitreason.toUpperCase()=="M"){
					if (i==0){
						DataInsert(-1);
						CellValue(i+1,prefix2+"bkg_no") = sheetObjects[0].CellValue(1,prefix1+"bkg_no");
						CellValue(i+1,prefix2+"bl_no") = sheetObjects[0].CellValue(1,prefix1+"bl_no");
					}
					
					DataInsert(-1);
					CellValue(i+2,prefix2+"bkg_no") = newSplitBkgNo[i];
					CellValue(i+2,prefix2+"bl_no") = newSplitBkgNo[i];
					CellValue(i+2,prefix2+"tvvd") = sheetObjects[0].CellValue(1,prefix1+"tvvd");
					 
					if ((splitNo-1)==i){
						CellValue2(i+2,prefix2+"act_wgt") =ComTrunc(sheetObjects[0].CellValue(1,prefix1+"act_wgt"),3)-ComTrunc(fWgtLast,3);
						CellValue2(i+2,prefix2+"pck_qty") =ComParseInt(sheetObjects[0].CellValue(1,prefix1+"pck_qty"))-fPkgLast;
						CellValue2(i+2,prefix2+"meas_qty") =ComTrunc(sheetObjects[0].CellValue(1,prefix1+"meas_qty"),2)-ComTrunc(fMeaLast,2);

					}else{
						CellValue2(i+2,prefix2+"act_wgt") =fWgt;
						CellValue2(i+2,prefix2+"pck_qty") =fPkg;
						CellValue2(i+2,prefix2+"meas_qty") =fMea;
						fWgtLast+=fWgt; 
						fPkgLast+=fPkg;
						fMeaLast+=fMea;
					}
					
					CellValue2(i+2,prefix2+"wgt_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"wgt_ut_cd");
					CellValue2(i+2,prefix2+"pck_tp_cd") = sheetObjects[0].CellValue(1,prefix1+"pck_tp_cd");
					CellValue2(i+2,prefix2+"meas_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"meas_ut_cd");
				}else{
					DataInsert(-1);
					CellValue(i+1,prefix2+"bkg_no") = newSplitBkgNo[i];
					//colTile=ComLpad(i,2,"0");
					//CellValue(i+1,prefix2+"bkg_no_split") = colTile;
					CellValue(i+1,prefix2+"bl_no") = newSplitBkgNo[i];
					CellValue(i+1,prefix2+"tvvd") = sheetObjects[0].CellValue(1,prefix1+"tvvd");
					 
					if ((splitNo-1)==i){
						CellValue2(i+1,prefix2+"act_wgt") =ComTrunc(sheetObjects[0].CellValue(1,prefix1+"act_wgt"),3)-ComTrunc(fWgtLast,3);
						CellValue2(i+1,prefix2+"pck_qty") =ComParseInt(sheetObjects[0].CellValue(1,prefix1+"pck_qty"))-fPkgLast;
						CellValue2(i+1,prefix2+"meas_qty") =ComTrunc(sheetObjects[0].CellValue(1,prefix1+"meas_qty"),2)-ComTrunc(fMeaLast,2);

					}else{
						CellValue2(i+1,prefix2+"act_wgt") =fWgt;
						CellValue2(i+1,prefix2+"pck_qty") =fPkg;
						CellValue2(i+1,prefix2+"meas_qty") =fMea;
						fWgtLast+=fWgt; 
						fPkgLast+=fPkg;
						fMeaLast+=fMea;
					}
					
					CellValue2(i+1,prefix2+"wgt_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"wgt_ut_cd");
					CellValue2(i+1,prefix2+"pck_tp_cd") = sheetObjects[0].CellValue(1,prefix1+"pck_tp_cd");
					CellValue2(i+1,prefix2+"meas_ut_cd") = sheetObjects[0].CellValue(1,prefix1+"meas_ut_cd");
				}
				
			}
		}
		sheetObjects[0].Copy2SheetCol(sheetObjects[1],prefix1+"adv_shtg_cd",prefix2+"adv_shtg_cd",-1,-1);

		//Qty split no
		for(var iRow=0;iRow<sheetObjects[2].Rows-1;iRow++){
			var fQty=ComTrunc(ComTrunc(sheetObjects[2].CellValue(iRow+1,prefix3+"op_cntr_qty"),2)/splitNo,2);
		    var fQtyLast=0;
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				if (iCol==ComCountHeadTitle(strSheetTitle3)-1){
					sheetObjects[2].CellValue2(iRow+1,iCol)=ComTrunc(sheetObjects[2].CellValue(iRow+1,prefix3+"op_cntr_qty"),2)-ComTrunc(fQtyLast,2);
				}else{
					sheetObjects[2].CellValue2(iRow+1,iCol)=fQty; 
					fQtyLast+=fQty;
				}
			}
		}
		 
	}
 

	/*
	* Qty,Cntr,Spc CGO SplitNo 변수 처리
	*/
	function setQtyCntrCgoVar(formObj){
		var arr="";
		var dgArr="";
		var rfArr="";
		var akArr="";
		var bbArr="";
		var strNo="";
		var ichk=0;
		var tmpbkgno="";
		var splitNo=ComParseInt(formObj.splitcount); 
		for(var iRow=1;iRow<sheetObjects[2].Rows;iRow++){
			for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3);iCol++){
				strNo = sheetObjects[2].ColSaveName(iCol).split("_");
				arr+=sheetObjects[2].CellValue(iRow,prefix3+"cntr_tpsz_cd")+":"+sheetObjects[2].CellValue(iRow,iCol)+":"+strNo[1]+"~";
			}
		}
		ComSetObjValue(formObj.qtySplitNo,arr);
		arr="";
        
		var dgArr="";
		var rfArr="";
		var akArr="";
		var ifindRow=-1;
		for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
			ichk=0;
			
			for(var iCol=ComCountHeadTitle(strSheetTitle4)-splitNo;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){
				if (ichk==0){
					var strTmp = strSheetTitle4.split("|");
					strNo=["",strTmp[iCol]];
				}else{
					strNo = sheetObjects[3].ColSaveName(iCol).split("_");
				}
//				strNo = sheetObjects[3].ColSaveName(iCol).split("_");
				ichk++;

				if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
					tmpbkgno=sheetObjects[1].CellValue(ichk+1,prefix2+"bkg_no");	
				} else {
					tmpbkgno=sheetObjects[1].CellValue(ichk,prefix2+"bkg_no");
				}
				 ifindRow=sheetObjects[4].FindText(prefix5+"cntr_no", sheetObjects[3].CellValue(iRow,prefix4+"cntr_no")); 
				 if(sheetObjects[3].CellValue(iRow,iCol)==1){
					arr+=sheetObjects[3].CellValue(iRow,prefix4+"cntr_no")+":"+strNo[1]+":"+tmpbkgno+":"+sheetObjects[3].CellValue(iRow,prefix4+"adv_shtg_cd")+"~";
					if (ifindRow>-1){
						if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="DG"){
							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="RF"){
							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="AK"){
							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+":"+strNo[1]+":"+tmpbkgno+"~";
						}
					}
				 }else{
					 arr+=sheetObjects[3].CellValue(iRow,prefix4+"cntr_no")+"::"+tmpbkgno+":"+sheetObjects[3].CellValue(iRow,prefix4+"adv_shtg_cd")+"~";
					 if (ifindRow>-1){
						if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="DG"){
							dgArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+"::"+ComGetObjValue(formObj.bkg_no)+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="RF"){
							rfArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+"::"+ComGetObjValue(formObj.bkg_no)+"~";
						}else if (sheetObjects[4].CellValue(ifindRow,prefix5+"code")=="AK"){
							akArr+=sheetObjects[4].CellValue(ifindRow,prefix5+"cntr_no")+":"+sheetObjects[4].CellValue(ifindRow,prefix5+"dcgo_seq")+"::"+ComGetObjValue(formObj.bkg_no)+"~";
						}
					}
				 }
			}
		} 
		 
		ComSetObjValue(formObj.cntrSplitNo,arr);
		ComSetObjValue(formObj.dgCntrSplitNo,dgArr);
		ComSetObjValue(formObj.rfCntrSplitNo,rfArr);
		ComSetObjValue(formObj.akCntrSplitNo,akArr);
		
	}
	
	 /*
	* sheet split 처리
	*/
	function sheet_splitSet(splitreason,lastno,splitcount){
		if (orgSplit.length>1 && splitreason.toUpperCase()=="C"){
			strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+orgSplit);
			if (!ComIsEmpty(sheetObjects[3].CellValue(1,prefix4+"cntr_no"))){
				strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
			}else{
				strSheetTitle4="|CNTR|TS|ST|AS";
			}
		}else{
			strSheetTitle3=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|TS|Q'ty|"+orgSplit);
			strSheetTitle4=SheetSetHeader(splitreason,lastno,splitcount+lastno,"|CNTR|TS|ST|AS|"+orgSplit);
		}
         
		var tmpSheet3= SheetToArrary(sheetObjects[2]);
		var tmpSheet4= SheetToArrary(sheetObjects[3]); 
		var tmpSheet5= SheetToArrary(sheetObjects[4]); 
		 
		if (!ComIsEmpty(sheetObjects[3].CellValue(1,prefix4+"cntr_no"))){
			loadInitSheet(orgSplit,true);
		}else{
			loadInitSheet(orgSplit,false);
		}
		 ArrayToSheet(sheetObjects[2],tmpSheet3);
         ArrayToSheet(sheetObjects[3],tmpSheet4);
		 ArrayToSheet(sheetObjects[4],tmpSheet5);
		 
		 
	}

	/*
	* Sheet 자료를 배열에 저장
	*/
	function SheetToArrary(sheetObj){
		var tmpSheet= new Array(sheetObj.Rows);
		for (var iRow=0;iRow<sheetObj.Rows;iRow++){
			tmpSheet[iRow] = new Array(sheetObj.LastCol+1);
		}
		 
		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
			 for(var iCol=0;iCol<sheetObj.LastCol+1;iCol++){ 
				tmpSheet[iRow][iCol]= sheetObj.CellValue(iRow+1,iCol); 
			 }
		 }
		 return tmpSheet;
	}
	/*
	* 배열 자료를 Sheet에 저장
	*/
	function ArrayToSheet(sheetObj,arr){
		for(var iRow=0;iRow<arr.length-1;iRow++){
			sheetObj.DataInsert(-1); 
		}
		for(var iRow=0;iRow<arr.length-1;iRow++){
			 for(var iCol=0;iCol<arr[iRow].length;iCol++){
				sheetObj.CellValue2(iRow+1,iCol) =arr[iRow][iCol]
			 }
		 }
	}
	/*
	*Booking split대한 그리드 Setting
	*/
	function loadInitSheet(orgSplit,flag){  
		for(var i=1;i<sheetObjects.length-1;i++){
			sheetObjects[i].Redraw = false;
			sheetObjects[i].RemoveAll();
			sheetObjects[i].Reset();
            
            ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1,asCodeList,asTextList,flag);
            
			if (i==2){ //sheet3 head Col setting
					SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|TS|Q'ty|"+orgSplit),prefix3);
			}
			
			if (flag){
				if (i==3){ //sheet4 head Col setting
						SheetSetInitCol(sheetObjects[i],ComGetObjValue(document.form.splitreason),ComParseInt(document.form.splitcount)-1+ComParseInt(document.form.lastSplitNo),ComParseInt(document.form.lastSplitNo),ComCountHeadTitle("|CNTR|TS|ST|AS|"+orgSplit),prefix4);
				}
			}
			 
			ComEndConfigSheet(sheetObjects[i]);
			sheetObjects[i].Redraw = true;
			
        }
		
		sheetObjects[2].ExtendLastCol = false;
		sheetObjects[3].ExtendLastCol = false;

	}
	

	/*
	* Cntr 초기화시 SplitNo 체크
	*/
	function Check_Cntr(sheetObj,prefix,splitNo){
		var formObj= document.form;
		var sCntr=ComGetObjValue(formObj.codCntrNo);
		sheetObj.CheckAll(splitNo)=0;
		sheetObj.CheckAll(prefix)=0;
 
		for(var i=1;i<sheetObj.Rows;i++){

            if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
				if (sCntr.indexOf(sheetObj.CellValue(i,prefix4+"cntr_no"))>-1){
					sheetObj.CellValue2(i,prefix)=1;
				}else{
					sheetObj.CellValue2(i,splitNo)=1;
				}
			}else{
				if (sCntr.indexOf(sheetObj.CellValue(i,prefix4+"cntr_no"))>-1){
					sheetObj.CellValue2(i,splitNo)=1;
				}else{
					sheetObj.CellValue2(i,prefix)=1;
				}
			}
		}
	}

	/*
	* Data를 Form에 대입
	*/
	function setFormData(formObj,sheetObj){
		
		ComSetObjValue(formObj.bl_no,sheetObj.EtcData("bl_no"));
		ComSetObjValue(formObj.tvvd,sheetObj.EtcData("tvvd"));
		ComSetObjValue(formObj.por_cd,sheetObj.EtcData("por_cd"));
		ComSetObjValue(formObj.pol_cd,sheetObj.EtcData("pol_cd"));
		ComSetObjValue(formObj.pod_cd,sheetObj.EtcData("pod_cd"));
		ComSetObjValue(formObj.del_cd,sheetObj.EtcData("del_cd"));
        
		ComSetObjValue(formObj.stwg_cd,sheetObj.EtcData("stwg_cd"));
		ComSetObjValue(formObj.rail_blk_cd,sheetObj.EtcData("rail_blk_cd"));
		ComSetObjValue(formObj.fd_grd_flg,sheetObj.EtcData("fd_grd_flg"));
		ComSetObjValue(formObj.hngr_flg,sheetObj.EtcData("hngr_flg"));
		ComSetObjValue(formObj.hot_de_flg,sheetObj.EtcData("hot_de_flg"));
		ComSetObjValue(formObj.prct_flg,sheetObj.EtcData("prct_flg"));
		ComSetObjValue(formObj.stop_off_loc_cd,sheetObj.EtcData("stop_off_loc_cd"));
		ComSetObjValue(formObj.spcl_hide_flg,sheetObj.EtcData("spcl_hide_flg"));
		ComSetObjValue(formObj.remark,sheetObj.EtcData("remark"));
         
		ComSetObjValue(formObj.dg,sheetObj.EtcData("dg"));
		ComSetObjValue(formObj.rf,sheetObj.EtcData("rf"));
		ComSetObjValue(formObj.ak,sheetObj.EtcData("ak"));
		ComSetObjValue(formObj.bb,sheetObj.EtcData("bb"));
		 
		if(ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){ 
			ComSetObjValue(formObj.lastSplitNo,sheetObj.EtcData("memoSplitNo")); 
		}else{
			ComSetObjValue(formObj.lastSplitNo,sheetObj.EtcData("custSplitNo"));
		}
		
		ComSetObjValue(formObj.custSplitNo,sheetObj.EtcData("custSplitNo"));
		ComSetObjValue(formObj.memoSplitNo,sheetObj.EtcData("memoSplitNo"));
		ComSetObjValue(formObj.bkgsplitno,sheetObj.EtcData("bkgsplitno"));
		ComSetObjValue(formObj.bdr_flag,sheetObj.EtcData("bdr_flag"));
		ComSetObjValue(formObj.pctl_no,sheetObj.EtcData("pctl_no"));
		ComSetObjValue(formObj.tro_flg,sheetObj.EtcData("tro_flg"));
		ComSetObjValue(formObj.bkgStsCd,sheetObj.EtcData("bkgStsCd"));
        
		 
	}
	


    /**
    * CA Reason 후속 처리 : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj = document.form;
          
    	//01. CA ReasonCd, Remark 입력정보 받아서,
    	var strRsnCd  = nullToBlank(arrPopupData[0][2]);
    	var strRemark = nullToBlank(arrPopupData[0][3]);
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value = strRsnCd;
        formObj.ca_remark.value = strRemark;
    }

	/*
	* Sheet2 onAfterEdit 이벤트 처리
	*/
	function sheet2_OnAfterEdit(sheetObj,Row,Col){
		var formObj = document.form;
		var fActSum =0;
		var fPckSum =0;
		var fMeasSum =0; 
		var startRow = 0;
		if (ComGetObjValue(formObj.splitreason).toUpperCase()=="M"){
			startRow = 2;			
		} else {
			startRow = 1;
		}
		 if (sheetObj.ColSaveName(Col)==prefix2+"act_wgt"
		    || sheetObj.ColSaveName(Col)==prefix2+"pck_qty"
			|| sheetObj.ColSaveName(Col)==prefix2+"meas_qty"){
			
			for(var idx=startRow;idx<sheetObj.Rows-1;idx++){
				fActSum+=ComTrunc(sheetObj.CellValue(idx,prefix2+"act_wgt"),3);
				fPckSum+=ComParseInt(sheetObj.CellValue(idx,prefix2+"pck_qty"));
				fMeasSum+=ComTrunc(sheetObj.CellValue(idx,prefix2+"meas_qty"),2);
			}
			
			if (ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"act_wgt"),3)-fActSum<0){
				ComShowCodeMessage("BKG00643");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
			}
			 
			if (ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"pck_qty"))-fPckSum<0){
				ComShowCodeMessage("BKG00644");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
			}

			if (ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"meas_qty"),2)-fMeasSum<0){
				ComShowCodeMessage("BKG00645");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
			}
			 
			sheetObj.CellValue2(sheetObj.Rows-1,prefix2+"act_wgt")=ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"act_wgt"),3)-fActSum;
			sheetObj.CellValue2(sheetObj.Rows-1,prefix2+"pck_qty")=ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"pck_qty"))-fPckSum;
			sheetObj.CellValue2(sheetObj.Rows-1,prefix2+"meas_qty")=ComTrunc(sheetObjects[0].CellValue(sheetObjects[0].Rows-1,prefix1+"meas_qty"),2)-fMeasSum;
		}
		
		SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix2);
		
		var arr="";
		if (sheetObj.CellValue(Row,prefix2+"bkg_no").length==12){
			arr=sheetObj.CellValue(Row,prefix2+"bkg_no").substring(10,12);
		}else{
			arr="00";
		}
		for(var iRow=1;iRow<sheetObjects[3].Rows;iRow++){
			for(var iCol=5;iCol<ComCountHeadTitle(strSheetTitle4);iCol++){ 
                var arrCol=sheetObjects[3].ColSaveName(iCol).split("_");
				if(arrCol[1]==arr && sheetObjects[3].CellValue(iRow,iCol)==1){
					sheetObjects[3].CellValue2(iRow,prefix4+"adv_shtg_cd") =  sheetObj.CellValue(Row,prefix2+"adv_shtg_cd");
				}
			 }
		 } 
	}
	
	/*
	* Sheet3 onAfterEdit 이벤트 처리
	*/
	function sheet3_OnAfterEdit(sheetObj,Row,Col){
		var formObj = document.form;
		if (ComIsNull(formObj.splitcount)) return;
		var splitNo=ComParseInt(formObj.splitcount);
		var fQtySum=0.00;
		var fQtySub=0; 
		var fQtyDiv=0.00;
		
		fQtyDiv=ComCountHeadTitle(strSheetTitle3)-Col-1;
		for (var iCol=Col+1;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
			sheetObj.CellValue2(Row,iCol)=(ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-ComTrunc(sheetObj.CellValue(Row,Col),2))/fQtyDiv;
		}
		
		for(var iCol=ComCountHeadTitle(strSheetTitle3)-splitNo;iCol<ComCountHeadTitle(strSheetTitle3)-1;iCol++){
			fQtySum +=ComTrunc(sheetObj.CellValue(Row,iCol),2);
			if (iCol<ComCountHeadTitle(strSheetTitle3)-1){
				fQtySub +=ComTrunc(sheetObj.CellValue(Row,iCol),2);
			}			
		} 

        if (Col != sheetObj.LastCol){ 
			sheetObj.CellValue2(Row,sheetObj.LastCol)=ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-fQtySum;			
		}

        if (ComTrunc(sheetObj.CellValue(Row,prefix3+"op_cntr_qty"),2)-(ComTrunc(fQtySum,2)+ComTrunc(sheetObj.CellValue(Row,sheetObj.LastCol),2))!=0){
				ComShowCodeMessage("BKG00642");
				sheetObj.CellValue2(Row,Col)=0;
				return false;
		}		
	}	
	
	/*
	* Sheet onAfterEdit이벤트 일때 split관련 처리
	*/
	function SheetOnAfterEditSet(sheetObj,formObj,Row,Col,prefix){
//		if (sheetObj.ColSaveName(Col)==prefix+"tvvd"){   //T.VVD 
//			if(sheetObj.CellValue(Row,prefix+"tvvd")==null){
//				sheetObj.ColHidden(prefix+"pc")=false;
//				sheetObj.CellValue2(Row,prefix+"pc")=0;
//			} else if (ComGetObjValue(formObj.tvvd).toUpperCase() != sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase()){ 
//				sheetObj.ColHidden(prefix+"pc")=false;	
//				sheetObj.CellValue2(Row,prefix+"pc")=0;
//			}else{
//				sheetObj.CellValue2(Row,prefix+"pc")=1;
//			}
//		}
//		 
//		if (ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJXX")
//			|| ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJYY")
//			|| ComIsContainsCharsOnly(sheetObj.CellValue(Row,prefix+"tvvd").toUpperCase(),"HJZZ")){
//			ComSetObjValue(formObj.pseudoVvdFlag,"Y");
//		}else{
//			ComSetObjValue(formObj.pseudoVvdFlag,"N");
//		}
	}
	/* 개발자 작업  끝 */