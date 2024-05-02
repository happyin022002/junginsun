/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_2069.js
*@FileTitle : TDR Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.03 김종옥
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
     * @class VOP_OPF_2069 : VOP_OPF_2069 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_2069() {
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
    var sheet1Width = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1  = sheetObjects[0];   //t1sheet1
         
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
				case "btn_Excel":
					//sheetObject1.Down2Excel(-1);
					sheetObject1.SpeedDown2Excel(-1);
					break;
				
				case "btn_close":
					window.close();
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
    	var formObject = document.form;
        //Group By 따라 sheet컬럼 설정
        if(formObject.group_by.value == "L"){
        	sheet1Width = 67;
        }else{
        	sheet1Width = 79;
        }
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //Group By 따라 sheet컬럼 설정
        if(formObject.group_by.value == "L"){
        	sheetObjects[0].ColHidden("sheet1_month") = true;
        	sheetObjects[0].ColHidden("sheet1_tdr_qty") = true;
        }else{
        	sheetObjects[0].ColHidden("sheet1_lane") = true;
        	sheetObjects[0].ColHidden("sheet1_vvd") = true;
        	sheetObjects[0].ColHidden("sheet1_ata") = true;
        	sheetObjects[0].ColHidden("sheet1_atd") = true;
        	sheetObjects[0].ColHidden("sheet1_tml_prod_rpt_rsn_cd") = true;
        }
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}

	/**
     * Sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
	function sheet1_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
	
	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {

            case "sheet1":
				with (sheetObj) {
                    // 높이 설정
                    style.height = 282;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle1 = "|Port|Yard|Lane|VVD|ATA|ATD|Month|TTL TDR|TTL\nMoves|Gross\nWorking\nHRS|Gross\nGang\nHRS|Gross\nTMNL\nPROD|Gross\nGang\nPROD|Average\nNo. of\nCrane|Excluded\nReason";
                    var headCount = ComCountHeadTitle(HeadTitle1);
		
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

					var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"port",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	prefix+"yard",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	prefix+"lane",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefix+"vvd",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			72,		daCenter,	false,	prefix+"ata",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			72,		daCenter,	false,	prefix+"atd",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,	prefix+"month",			false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	false,	prefix+"tdr_qty",		false,		"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daRight,	false,	prefix+"tot_mvs",		false,		"",		dfNumber,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daRight,	false,	prefix+"work_gross",	false,		"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daRight,	false,	prefix+"gang_gross",	false,		"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daRight,	false,	prefix+"tmnl_prod",		false,		"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daRight,	false,	prefix+"gang_prod",		false,		"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daRight,	false,	prefix+"avg_clan",		false,		"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			sheet1Width,		daCenter,	false,	prefix+"tml_prod_rpt_rsn_cd",		false,		"",		dfNone,	0,	true,	true);	
				}
		}
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
 			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
	        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_OPF_2069GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchXml(sXml);
				}
 				break;				
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
	 			
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				if(sheetObj.CellValue(i, "sheet1_yard") == "S.Total"){
 	 					sheetObj.CellFont("FontBold", i,"sheet1_yard") = true;
 	 					sheetObj.CellAlign(i, "sheet1_yard") = daLeft;
 	 					for(var j=1 ; j<=15 ; j++){
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(232, 231, 236);
 	 					}
 	 				}
 	 			} 	 			
 	 			
 	 			if(sheetObj.RowCount > 2){
	 	 			//Grand Total RGB 설정
	 	 			var allRowCount = sheetObj.LastRow;
	 	 			for(var j=1 ; j<=15 ; j++){
	 	 				sheetObj.CellFont("FontBold", allRowCount-1, j) = true;
	 	 				sheetObj.CellFont("FontBold", allRowCount, j) = true;
	 	 				sheetObj.CellBackColor(allRowCount-1, j) = sheetObj.RgbColor(247, 225, 236);
	 	 				sheetObj.CellBackColor(allRowCount, j) = sheetObj.RgbColor(247, 225, 236);
	 	 			}
 	 			}
 	 			
 				//sheetObj.RowMerge(sheetObj.LastRow-1) = true;
 				//sheetObj.RowMerge(sheetObj.LastRow) = true;
 				sheetObj.CellAlign(sheetObj.LastRow-1, "sheet1_port") = daLeft;
 				sheetObj.CellAlign(sheetObj.LastRow, "sheet1_port") = daLeft;
 				
 				sheetObj.SetMergeCell(sheetObj.LastRow, 1, 1, 2);
 	 		} 			
		}
	}	

	/* 개발자 작업  끝 */