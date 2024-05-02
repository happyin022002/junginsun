/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0921.js
*@FileTitle : TRO-Multi
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.02 이남경
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
     * @class esm_bkg_0921 : esm_bkg_0921 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0921() {
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
				case "btn_Close":
					self.close();
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
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

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        initControl();
    }
     
    function initControl() {
    	var formObj = document.form;
    	formObj.cntr_no.focus(); 
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //hidden sheet1
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
	                InitRowInfo(1, 1, 15, 100);
	
	                var HeadTitle = "Booking No.||TRO|MASTER";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false); 
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
	                InitDataProperty(0,	cnt++,	dtData,			120, 	daCenter,	false,	"bkg_no", false,	"",			dfNone,		0,			false,		false);
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag", false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"tro_i",  false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"master", false,	"",			dfNone,		0,			false,		false);
			    }
				break; 	
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {    	
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          	case IBSEARCH:      //조회	              		
	          	formObj.f_cmd.value = SEARCH;
          	    sheetObj.DoSearch("ESM_BKG_0921GS.do", FormQueryString(formObj));
                break;
        }
    }

     
     
    //#################(Event)############################
    // Sheet searchEnd
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
   	    var formObj = document.form;
   	 
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{
 				CellFontUnderline(i, "bkg_no") = true;
 			}
 		}
    }    
    
    // Sheet Click
    function sheet1_OnClick(sheetObj, Row, Col, Value)
    {   	
		with(sheetObj) {
			switch(ColSaveName(Col)){
	            case "bkg_no":
	            	var bkg_no = Value;
	            	
	            	/* : menu 없음
	            	var sUrl = "/hanjin/ESM_BKG_0079.do";
	            	var sUrl += "?bkg_no="+bkg_no;	
	            	*/            		            	
	            	var sUrl = "/hanjin/alpsMain.screen";
	            	sUrl += "?parentPgmNo=ESM_BKG_M001";
	            	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0079.do";
	            	sUrl += "&pgmNo=ESM_BKG_0079";
	            	sUrl += "&bkg_no="+bkg_no;
	            	
	            	//freezing 관련 작업
//	            	ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 750, false);
	            	comBkgCallPopBkgDetail(bkg_no);   
	            	//var sOption = "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=1024,height=700,left=0,top=0";
	            	//ComOpenWindow2(sUrl, 'p', sOption); 
	            	break;
			}
		}
    }
 
    
    //#################(Etc/Logic)############################


	/* 개발자 작업  끝 */