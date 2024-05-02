/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0305.js
*@FileTitle : ESM_BKG_0305
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.03 경종윤
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
     * @class ESM_BKG_0305 : ESM_BKG_0305 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0305() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }


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
         //var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);					
					break;

				case "btn_downexcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_Select":
                	doActionIBSheet(sheetObject1,formObject,COMMAND01);
					break;
					
				case "btn_Detail":
                	doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
					break;

				case "btn_Close":
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

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
             
        }

		//화면에서 필요한 이벤트
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
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
						InitRowInfo(1, 1, 3, 100);
						
						var HeadTitle = "|Abbr. Code|Customs Code|Bond Code|Warehouse Name|LOC|Phone|P.I.C|Fax|cnt_cd|loc_nm|wh_addr|diff_rmk";
						var headCount = ComCountHeadTitle(HeadTitle);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,		cnt++ , dtHiddenStatus,			60,		daCenter,		true,	"hdnStatus");
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		false,	"wh_cd",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtData,					100,	daLeft,			false,	"cstms_cd",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtData,					100,	daLeft,			false,	"bd_area_cd",	false,		"",		dfNone,					0,		false,		true);
						
						InitDataProperty(0,		cnt++ , dtData,					150,	daLeft,			false,	"wh_nm",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		false,	"loc_cd",		false,		"",		dfNone,					0,		false,		true);

						InitDataProperty(0,		cnt++ , dtData,					150,	daLeft,			false,	"phn_no",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtData,					150,	daLeft,			false,	"pson_nm",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtData,					100,	daLeft,			false,	"fax_no",		false,		"",		dfNone,					0,		false,		true);

						InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			false,	"cnt_cd",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			false,	"loc_nm",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			false,	"wh_addr",		false,		"",		dfNone,					0,		false,		true);
						InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			false,	"diff_rmk",		false,		"",		dfNone,					0,		false,		true);
						
						CountPosition = 2;
						
						WaitImageVisible=false;

					}
					
				break;


		}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

        	case IBSEARCH:      //조회
        		if(!validateForm(sheetObj,formObj,sAction)) return false;
        		ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_0305GS.do" , FormQueryString(formObj) );
        		sheetObj.LoadSearchXml(sXml);
        		ComOpenWait(false);
        		break;

			case IBDOWNEXCEL:      // 엑셀
						
        		if(!validateForm(sheetObj,formObj,sAction)) return false;
        		ComOpenWait(true);
				sheetObj.SpeedDown2Excel(-1);
				ComOpenWait(false);
				break;
        		
        	case COMMAND01:      //select 버튼
				if(!validateForm(sheetObj,formObj,sAction)) return false;
                select(sheetObj, sheetObj.selectRow, '');
                break;
        		
        	case IBROWSEARCH:	// detail 버튼
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheet1_OnDblClick(sheetObj,sheetObj.selectRow,'');
				break;

        } // end switch
    }


    /**
     * select 버튼 클릭시
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function select(sheetObj,Row,Col) {
    	
        try{    	
			var obj = new Object(); 
			   
			obj.cd = sheetObj.CellValue(Row, "cstms_cd");
			obj.nm = sheetObj.CellValue(Row, "bd_area_cd");
			
			window.returnValue = obj;
			self.close();

       }catch(e){}    
    	
    }

    /**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
		var cntCd = sheetObj.CellValue(Row, "cnt_cd");
		var whCd = sheetObj.CellValue(Row, "wh_cd");
		var cstmsCd = sheetObj.CellValue(Row, "cstms_cd");
		var whNm = sheetObj.CellValue(Row, "wh_nm");
		var whAddr = sheetObj.CellValue(Row, "wh_addr"); 
		var locCd = sheetObj.CellValue(Row, "loc_cd");
		var locNm = sheetObj.CellValue(Row, "loc_nm");
		var psonNm = sheetObj.CellValue(Row, "pson_nm");
		var phnNo = sheetObj.CellValue(Row, "phn_no");
		var faxNo = sheetObj.CellValue(Row, "fax_no");
		var diffRmk = sheetObj.CellValue(Row, "diff_rmk");
		
		var sUrl = "/hanjin/ESM_BKG_0982.do?";
		var sParam  = "&cntCd=" + cntCd
					+ "&whCd=" + whCd
					+ "&cstmsCd="+cstmsCd
					+ "&whNm=" + whNm
					+ "&whAddr=" + whAddr
					+ "&locCd=" + locCd
					+ "&locNm=" + locNm
					+ "&psonNm=" + psonNm
					+ "&phnNo=" + phnNo
					+ "&faxNo=" + faxNo
					+ "&diffRmk=" + diffRmk;
		
		ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0982", 560, 360, true);
			
    }
    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

     	switch(sAction) {
     	
	 		case IBSEARCH :
	 			
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
				
    			var cntCd = formObj.cnt_cd.value;
    			var locCd = formObj.loc_cd.value;
    			
    			if(cntCd == "" && locCd == "") {
					//ComShowMessage("Country Code또는Location 중 반드시 1개 이상 입력해야합니다.");
     				ComShowCodeMessage("BKG06094");
					ComSetFocus(formObj.cnt_cd);
					return false;
    			}
				
	 			break;
	 			
	 		case IBDOWNEXCEL:
     			if(sheetObj.RowCount == 0) {
     				//ComShowMessage("조회된 데이타가 없습니다.");
     				ComShowCodeMessage("BKG00889");
     				return false;
     			}
	 			break;
	 			
	 		case COMMAND01:
	 			
     			if(sheetObj.RowCount == 0) {
     				//ComShowMessage("조회된 데이타가 없습니다.");
     				ComShowCodeMessage("BKG00889");
     				return false;
     			}
	 			
	 			break;
	 			
	 		case IBROWSEARCH:
     			if(sheetObj.RowCount == 0) {
     				//ComShowMessage("조회된 데이타가 없습니다.");
     				ComShowCodeMessage("BKG00889");
     				return false;
     			}

     			break;
	 			
     	}
     	
     	return true;
    }


