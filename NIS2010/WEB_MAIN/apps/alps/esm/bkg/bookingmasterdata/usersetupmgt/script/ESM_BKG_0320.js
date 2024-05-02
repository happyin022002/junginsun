/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0320.js
*@FileTitle : Internet O/BL Release Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
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
     * @extends 
     * @class esm_bkg_0320  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0320() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	this.sheet1_OnKeyUp         = sheet1_OnKeyUp;
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
 				case "btn_RowAdd":
 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
 					break;
 				case "btn_RowDelete":
 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
 					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					break;
 				case "btn_DownExcel":
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 		initControl();
     }

    function initControl() {
    	var formObject = document.form;
        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper','44|95|32');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum','44|95|32');
	        break;
	      case "engdnnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('lowernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      default:
	    }
	}  
	
/*********************** KEY EVENT END ********************/
  

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 422;
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

										var HeadTitle1 = "|	|User ID|User Name|Office|Multi|Creation|Creation|Creation";
										var HeadTitle2 = "|	|User ID|User Name|Office|Multi|Date|Name|Office";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 					
					 					var prefix = "sheet1_";

										InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	  false,	prefix +"ibflag");
										InitDataProperty(0, cnt++ , dtDelCheck,			70,		daCenter,		true,		prefix +"del_chk");
										InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		true,		prefix +"usr_id",				true,	 	  "",		dfNone,					0,		false,	true);
										InitDataProperty(0, cnt++ , dtData,					200,	daCenter,		true,		prefix +"usr_nm",				false,		"",		dfNone,					0,		false,	false);
										InitDataProperty(0, cnt++ , dtData,					120,	daCenter,		true,		prefix +"ofc_cd",				false,		"",		dfNone,					0,		false,	false);
										InitDataProperty(0, cnt++,  dtCheckBox,              60, 	daCenter,		true, 		prefix + "inet_auth_lmt_flg", 	false, 		"",		dfNone, 				0, 		true, 	true);
										InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		true,			prefix +"upd_dt",		   false,		"",		dfUserFormat2,			0,		false,	false);
										InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		true,			prefix +"upd_nm",	 false,		"",		dfNone,					0,		false,	false);
										InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,			prefix +"upd_ofc_cd",	 false,		"",		dfNone,					0,		false,	false);
										
					 					InitUserFormat2(0, prefix +	"upd_dt", "####-##-##", "-|:" );
					 					
					 					CountPosition = 0;

 				}
 				
 				break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH;
			 				if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0320GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			 				break;
			 				
			 			case SEARCH01:      //조회
							if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							if ("sheet1" == sheetObj.id) {
								
								var sXml = sheetObj.GetSearchXml("ESM_BKG_0320GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
								sheetObj.CellValue(Row, Col+1) = ComGetEtcData(sXml, "search_usr_nm"); 
								sheetObj.CellValue(Row, Col+2) = ComGetEtcData(sXml, "search_ofc_cd");
								var check_usr_id = ComGetEtcData(sXml, "check_usr_id");
								if(check_usr_id =="N"){
									ComShowCodeMessage('BKG95075');
									sheetObj.CellValue2(Row, Col) = "";
									
								}
							
								if(isNullEtcData(sXml)) {
						    		ComShowCodeMessage('BKG00768');					    		
						    		sheetObj.CellValue2(Row, Col) = "";
								}
							}
							break;
			
			 			case IBSAVE:        //저장
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = MULTI;
							var sParam = sheetObj.GetSaveString();
							if (sheetObj.IsDataModified && sParam == "") return;
							sParam += "&" + FormQueryString(formObj);
							
							var sXml = sheetObj.GetSaveXml("ESM_BKG_0320GS.do" , sParam);
							sheetObj.LoadSaveXml(sXml);
						
			 				break;
			
						case IBINSERT:      // 입력
							sheetObj.DataInsert(-1);
							break;
							
						case IBDOWNEXCEL:   // 엑셀다운로드
							sheetObj.SpeedDown2Excel(1);
							break;
			
			    }
     }
     
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @version 2009.05.17
     */ 	
	 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	 		var formObject = document.form;
	 		if (ErrMsg == "") {
				ComBkgSaveCompleted();
				sheetObj.RemoveAll();
				doActionIBSheet(sheetObj,formObject,IBSEARCH);
			}
		}
		     

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSAVE:
    			var prefix = "sheet1_";
    			for(var i=sheetObj.HeaderRows; i <= sheetObj.RowCount+ sheetObj.HeaderRows -1; i++) {
	  				var vUsrId = sheetObj.CellValue(i, prefix+"usr_id");
	  				if (sheetObj.CellValue(i, prefix+"ibflag") != "R") {
	  					if (ComIsNull(vUsrId)) {
	      					ComShowCodeMessage('BKG00768','User ID');
	      					return false;
	  					}
	  				}
	  			}
	  			break;
    	 }
         return true;
     }
     

    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var prefix = "sheet1_";
    	var formObject = document.form;
    	if (sheetObj.ColSaveName(Col) == prefix+"usr_id"){
    		formObject.ch_usr_id.value = Value;
    		doActionIBSheet(sheetObj,formObject,SEARCH01,Row,Col);
    	}
    }
    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }

	/* 개발자 작업  끝 */    