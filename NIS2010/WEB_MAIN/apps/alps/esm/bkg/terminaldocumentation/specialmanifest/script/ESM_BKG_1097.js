/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1097.js
*@FileTitle : ESM_BKG_1097
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2010.06.03 경종윤
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
     * @class ESM_BKG_1097 : ESM_BKG_1097 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1097() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 				switch(srcName) {
					case "btn_Retrieve":
	 					doActionIBSheet(sheetObject, formObject, IBSEARCH);
						break;

					case "btn_Save":
	                	doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;

 					case "btn2_Delete":
 						doActionIBSheet(sheetObject,formObject,IBDELETE);
						break;

 					case "btn2_RowAdd":
	                	doActionIBSheet(sheetObject,formObject,IBINSERT);
						break;

					case "btn_Select":
 						doActionIBSheet(sheetObject,formObject,COMMAND01);
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
     	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
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
 		var sheetId = sheetObj.id;

         switch(sheetId) {

             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 190;
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

 					var HeadTitle1 = "|Sel.|seq|Feeder Lloyd Code|Feeder Vessel Name|SEQ_KEY";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     //InitHeadMode(true, true, false, true, false,false)
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     var prefix = "sheet1_";
                     
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix + "ibflag");
 					
                    InitDataProperty(0, cnt++ , dtCheckBox,		40, 	daCenter,	true, 		prefix + "del_chk",			 false	,"",  dfNone,0,true,true);
        			InitDataProperty(0, cnt++ , dtDataSeq, 		30,     daCenterTop, true, 		"seq",				  		false, "", dfNone, 0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,		prefix + "fdr_vsl_lloyd_no" ,true	,"",		dfNone,		0,		true,		true, 7);
 					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		true,		prefix + "fdr_vsl_nm"		,true	,"",		dfEngUpKey,	0,		true,		true);

 					InitDataProperty(0, cnt++ , dtHidden,		150,	daCenter,	true,		prefix + "seq_key"  		,false	,"",		dfNone,		0,		true,		true);

 					//InitDataValid(0, prefix + "anr_fwrd_id", vtEngUpOther);
 					
 					CountPosition = 0;
 					
 					DataInsert(-1);
 					
 					WaitImageVisible=false;
 			}
 			break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {

 			case IBSEARCH:		//조회
 				//if(!validateForm(sheetObj,formObj,sAction)) return false;
 				
 				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("ESM_BKG_1097GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_")); 	
 				ComOpenWait(false);
 				break;
 				
 			case IBINSERT:      // 그리드행 추가(입력)
				sheetObj.DataInsert(-1);
				break;
				
    	    case IBSAVE:        //저장
    	    	 
    	    	if(!validateForm(sheetObj,formObj,sAction)) return false;

    	    	ComOpenWait(true);
    	    	formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_BKG_1097GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
				break;
				
 			case IBDELETE:		// row 삭제
 				
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				
 				if(ComShowCodeConfirm('BKG03037')){
                	ComRowHideDelete(sheetObj,"sheet1_del_chk");
                	sheetObj.CheckAll2("sheet1_del_chk") = 0;
				}
 				break;
				
				
    	    case COMMAND01 :
    	    	if(!validateForm(sheetObj,formObj,sAction)) return false;
    	    	
    	    	sheet1_OnDblClick(sheetObj, sheetObj.SelectRow);
    	    	break;
				
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 
    	var sheet1RowCnt = sheetObj.RowCount;
    	
  	    switch(sAction) {
			case IBSEARCH: { // 조회
			    
    			//기본포멧체크
    			//if (!ComChkValid(formObj)) return false;
    			
				break;
			}
			
			case IBSAVE: {
				
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				break;
			}
			
			case IBDELETE : {
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				
				var checkedCnt = 0;
				
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.CellValue(i,"sheet1_del_chk") == "1") {
						checkedCnt++;
					}
				}
				
				if(checkedCnt == 0) {
					ComShowCodeMessage("BKG00546");
					return false;
				}
				
				break;
			}

			
			case COMMAND01 :
				if(sheet1RowCnt == 0 || (sheet1RowCnt == 1 && (sheetObj.CellValue(sheetObj.SelectRow,"sheet1_fdr_vsl_lloyd_no") == "" || sheetObj.CellValue(sheetObj.SelectRow,"sheet1_fdr_vsl_nm") == ""))) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				
				break;
			
  	    }

	    return true;
     }
     
     /**
      * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnDblClick(sheetObj,Row,Col) {
     	//alert("데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event \n" + "Row : " + Row + "\n" + "Col : " + Col);
    	 
    	var pageType = document.form.pageType.value;
    	
    	if(pageType != "MAIN") {
			var obj = new Object(); 
			   
			obj.cd = sheetObj.CellValue(Row, "sheet1_fdr_vsl_lloyd_no");
			obj.nm = sheetObj.CellValue(Row, "sheet1_fdr_vsl_nm");
			
			if(obj.cd !="" && obj.nm != "") {
				window.returnValue = obj;
				self.close();
			}
    	}
     	
     }
     
    
	/**
	 * 저장 후 이벤트
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	
		sheetObj.checkAll2("sheet1_del_chk") = 0;

		if (ErrMsg == "") {
			
	    	if (document.form.f_cmd.value == MULTI) {
				ComShowCodeMessage('BKG00102');
				
				doActionIBSheet(sheetObj, document.form, IBSEARCH); // 재조회
			}

		} 
		
    }
  		
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (srcName == "fdr_vsl_lloyd_no" && ComChkLen(srcValue, srcMaxLength) == "2") {
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
    	
		sheetObj.checkAll2("sheet1_del_chk") = 0;
    	
    	if(sheetObj.RowCount == 0) {
    		ComShowCodeMessage('BKG00095');
    		sheetObj.DataInsert(-1);
    	}
    }
    

	/* 개발자 작업  끝 */