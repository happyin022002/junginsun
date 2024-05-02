/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0745.js
*@FileTitle : ESM_BKG_0745
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.04.30 경종윤
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
     * @class esm_bkg_0745 : esm_bkg_0745 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0745() {
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
			
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
	
                case "btn_DownExcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                	break;
					
				case "btn2_RowAdd":
					sheetObject1.DataInsert(-1);
					break;
					
				case "btn2_Delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;
					
				case "btn_Save":
                	doActionIBSheet(sheetObject1,formObject,IBSAVE);
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

	        ComConfigSheet (sheetObjects[i] );

	        initSheet(sheetObjects[i],i+1);

	        ComEndConfigSheet(sheetObjects[i]);
	         
	    }
	    
	    
	}
	
	/**
	 * 화면 로딩 완료 후 이벤트
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
    	
		initFocus();
	    
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		
	 }   

	
	/**
	 * page Loading시 포커스 설정
	 * @return
	 */
	function initFocus() {
	    var formObj = document.form;
	    ComSetFocus(formObj.cmdt_cd);
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
							style.height = 302;
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
							
							var HeadTitle1 = "|Sel.|Del|Seq|Harmonized Tariff Code|Description|Category|User ID|Office|Update Date";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);
							
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, true, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							
	                        //var prefix = "sheet1_";
							
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"ibflag");
							InitDataProperty(0,		cnt++ , dtCheckBox,				40,		daCenter,		true,		"del_check");
							InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"act_flg",			false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtSeq,					50,		daCenter,		true,		"Seq");
							InitDataProperty(0,		cnt++ , dtData,					170,	daLeft,			true,		"brz_cmdt_cd",		true,		"",		dfNone,					0,		false,	true, 8);
							InitDataProperty(0,		cnt++ , dtData,					500,	daLeft,			true,		"cmdt_desc",		false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtData,					220,	daLeft,			true,		"cmdt_cate_ctnt",	false,		"",		dfNone,					0,		false,	false);

							InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"upd_usr_id",		false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		"office",			false,		"",		dfNone,					0,		false,	false);
							InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"upd_dt",			false,		"",		dfDateYmd,				0,		false,	false);
							
							
							//MassOfSearch=1
							
							//카운트를 표시할 포지션 /0의 경우 비표시 
							CountPosition = 2; 
							//토탈카운트표시 
							CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
							
							InitViewFormat(0, "upd_dt", "yyyy-mm-dd")
							
							WaitImageVisible=false;
							
							// 문장이 길경우 ...으로 표시함
							Ellipsis = true;
							
					}
					break;


		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
			  
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_0745GS.do",sParam);
				ComOpenWait(false);
				break;
			        
			case IBDOWNEXCEL:   // 엑셀
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				sheetObj.SpeedDown2Excel(1);
				ComOpenWait(false);
				break;
			        
			case IBDELETE:	// Row Delete
				if (!validateForm(sheetObj, formObj, sAction))	return;
				
				if(ComShowCodeConfirm('BKG03037')){
					ComRowHideDelete(sheetObj, "del_check");
                	sheetObj.CheckAll2("del_check") = 0;
				}
				
				break;
				
			case IBSAVE :
 				if(!validateForm(sheetObj,formObj,sAction)) return false;

 				formObj.f_cmd.value = MULTI;
 				var sParam = sheetObj.GetSaveString();
 				
 				if (sheetObj.IsDataModified == false || sParam == "") {
 					ComShowCodeMessage('BKG00260');
 					return;
 				}
 				
 				sParam = sParam + "&f_cmd="+MULTI;
 				
 				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0745GS.do", sParam);
				ComOpenWait(false);
				
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSearchXml(sXml);
					doActionIBSheet(sheetObj, formObj, IBSEARCH);//재조회
				}

				break;
				
				
	    }
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj,formObj,sAction){
		
	    switch(sAction) {
			case IBSEARCH: { // 조회
			    
				var brzCmdtCd = formObj.brz_cmdt_cd.value;
				var cmdtDesc  = formObj.cmdt_desc.value;
				
				
				if(brzCmdtCd.trim() == "" && cmdtDesc.trim() == "") {
					ComShowCodeMessage("BKG06045" );
					ComSetFocus(formObj.brz_cmdt_cd);
					return false;
				}

				break;
			}
			
			case IBDOWNEXCEL : { // 엑셀
				
				if(sheetObj.RowCount == 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}
				
				break;
			}
			
			case IBDELETE : // Row Delete
				var sheet1RowCnt = sheetObj.RowCount;
			    var selCnt = 0;
			
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}

				for(var i=1; i<=sheet1RowCnt; i++) {
					
					if(sheetObj.CellValue(i, "del_check") == 1) {
						selCnt++;
					}
					
					if(selCnt > 0) break;
				}
				
				if(selCnt == 0) {
					ComShowCodeMessage('BKG00442');
					return false;
				}
				
				break;
			
	    }
	    
	    return true;
	}
    
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (srcName == "brz_cmdt_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	
    }
    
     /**
      * 조회 처리 후 이벤트
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	
 		sheetObj.checkAll2("del_check") = 0;
     	
     }
     
    
      /**
       * 시트를 클릭했을 때 처리
       */
      function sheet1_OnClick(sheetObj, row, col) {

      	var rowCnt = sheetObj.RowCount;
      	var check = sheetObj.CellValue(row, "del_check");
      	var actFlg = sheetObj.CellValue(row, "act_flg");
      	var colSaveName = sheetObj.ColSaveName(col);

      	switch(colSaveName) {
      		/* 긴 문자열 MemoPad 처리*/
      		case "cmdt_desc" :
      		case "cmdt_cate_ctnt" :
      			ComShowMemoPad(sheetObj, null, null, false, 300, 100);
      			break;
      			
      		/* Check Box 클릭시 머리클릭 처리*/
      		case "del_check" :
      			
      			if(actFlg == "Y") {
      				sheetObj.CellValue2(row, "del_check") = 1;
      			}
      			
      			break;
      			
      		
      	} // end switch

      }
      

      

	/* 개발자 작업  끝 */