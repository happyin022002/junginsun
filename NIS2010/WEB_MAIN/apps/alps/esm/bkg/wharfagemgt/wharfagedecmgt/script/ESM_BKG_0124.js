/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0124.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0124() {
    	this.processButtonClick		= processButtonClick;
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
    
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            				
                case "btn_retrieve":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				
                case "btn_new":
                	ComResetAll();
                	formObject.vvd.value = "";
                	formObject.bl_no.value = "";
                	formObject.vvd.focus();
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

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	formObject.vvd.focus();
    }

    

    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 462;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

										var HeadTitle1 = "|No.|B/L No.|Seq.|Weight|Measure|TEU Count|Per Type Code|Old Amount|New Amount|Different Amount|WHF Dec No.";
											HeadTitle1 += "|WHF Dec Date|WHF Type|WHF Dec IND|Arif IND|Arif Date|Remark|Create Date|Weight Type|Measure Type|VVD|VVD|VVD";
                    //var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(24, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,			"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,			"No");
                    InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,			"bl_no",              false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtAutoSum,		30,		daCenter,		true,			"chg_rt_seq",     		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtAutoSum,		50,		daRight,		true,			"cntr_wgt",       		false,		"",		dfNone,					0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		true,			"meas_qty",       		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		  	"teu_qty",        		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		  	"cntr_per_tp_cd", 		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,		true,		  	"old_chg_amt",    		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,		true,			"new_chg_amt",    		false,		"",		dfNone,					0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtAutoSum,		110,	daRight,		true,			"diff_amt",       		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			140,	daCenter,		true,			"whf_decl_no",    		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,			"whf_decl_dt",    		false,		"",		dfUserFormat2,		3,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			105,	daRight,		true,			"kr_whf_expt_cd", 		false,		"",		dfNone,		0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			140,	daCenter,		true,			"whf_decl_if_flg",		false,		"",		dfNone,					0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,			"ar_if_flg",      		false,		"",		dfNone,			0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,			"ar_if_dt",       		false,		"",		dfDateYmd,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,			"decl_rmk",       		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,			"cre_dt",         		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,			"wgt_ut_cd",      		false,		"",		dfNone,			0,		false,	true);
                    
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,			"meas_ut_cd",     		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,			"vsl_cd",         		false,		"",		dfNone,			0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,			"skd_voy_no",     		false,		"",		dfNone,					0,		false,	true);
                    InitDataProperty(0, cnt++ , dtData,			20,		daCenter,		true,			"skd_dir_cd",     		false,		"",		dfNone,					0,		false,	true);

					InitUserFormat2(0, "whf_decl_dt", "####-##-## ##:##", "-|:" );
					CountPosition = 0;
					//DataRowMerge(0) = true; // 홀수 행은 가로로 머지가 된다.
					//DataRowMerge(1) = true; // 짝수 행은 가로로 머지가 된다.

			}
			break;

        }
    }
   
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
        		if( validateForm(sheetObj,formObj,sAction) ){
					
					formObj.f_cmd.value = SEARCH;
					
					/*
					 * 팝업으로 호출되었을시에 호출한 화면에서 가져온값을 화면에 표기한후 호출하고 히든값을 초기화시킨다.
					 * 자체 조회시에 영향히든값에 의해 영향을 안받도록 하기위해서...
					 */
					var temp = formObj.whfBndCd.value;
					if( "II" == temp )
						formObj.whf_bnd_cd[1].selected = true;
					else if("IT" == temp)
						formObj.whf_bnd_cd[2].selected = true;
					else if("OO" == temp)
						formObj.whf_bnd_cd[3].selected = true;
					else if("OT" == temp)
						formObj.whf_bnd_cd[4].selected = true;
					formObj.whfBndCd.value = "";
					
					sheetObj.DoSearch("ESM_BKG_0124GS.do",FormQueryString(formObj));
					for(var i=1; i<sheetObj.RowCount+1; i ++){

						sheetObj.CellValue(i,4) = CommaInputWithPoint( sheetObj.CellValue(i,4) , 3);
						sheetObj.CellValue(i,5) = CommaInputWithPoint( sheetObj.CellValue(i,5) , 3);
						sheetObj.CellValue(i,6) = CommaInputWithPoint( sheetObj.CellValue(i,6) , 3);

						sheetObj.CellValue(i,7) = CommaInputWithPoint( sheetObj.CellValue(i,7) , 3);
						sheetObj.CellValue(i,8) = CommaInputWithPoint( sheetObj.CellValue(i,8) , 3);
						sheetObj.CellValue(i,9) = CommaInputWithPoint( sheetObj.CellValue(i,9) , 3);
						sheetObj.CellValue(i,10) = CommaInputWithPoint( sheetObj.CellValue(i,10) , 3);
						
					}
					sheetObj.SetMergeCell(sheetObj.RowCount+1,1,1,2);
					
        		}
        		
			break;
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if ( formObj.vvd.value == "" && formObj.bl_no.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				return false;
	 			}
	 			return true;
	 		break;
	 		
     	}
     }

     
	/* 개발자 작업  끝 */    