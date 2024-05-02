/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6042.js
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class ESM_PRI_6042 : ESM_PRI_6042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6042() {
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
 
 //현재 이벤트를 저장                                                                                                                                                                                                       
 var eventStatus = "";  
 
 //현재 선택한  sheet1의 bse_seq                                                                                                                                                                                            
 var selectedGrpLocSeq = -1;                                                                                                                                                                                              
                                                                                                                                                                                                                           
 //현재 선택한  sheet2의 cmpb_seq                                                                                                                                                                                         
 var selectedGrpLocDtlSeq = -1; 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	 /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
 		var sheetObject1 = sheetObjects[0];	
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

	            case "btn1_Row_Add":
	          		doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
					break;
	
				case "btn1_Row_Delete":
					if(doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC02)){
						doActionIBSheet(sheetObjects[1], formObject, IBDELETE);		
					}
					break;
          
				case "btn2_Row_Add":
					doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
					break;
	
				case "btn2_Row_Delete":
					doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;
	
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;

				case "btn_Close":
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
      * IBSheet Object를 배열로 등록 <br>
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
      * 배열은 소스 상단에 정의 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj 필수 IBSheet Object
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */   
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }
 	
     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
 	 function loadPage() {
 		for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 		}
 		
// 		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 		
     }
 	 
 	 
 	/**
      * LoadFinish 이벤트 시 발생한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.WaitImageVisible = false; 
    	 doActionIBSheet(sheetObj,document.form,IBSEARCH);
     }
 	 
     /** 
      * sheet1 search end 시 호출되는 이벤트핸들러 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {String} ErrMsg 
      * @see #
      * @author 이승준
      * @version 2009.10.16
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var formObj = document.form;
 		//prc_grp_loc_cd 수정시 원본 확인 위해 prc_grp_loc_cd를 조회시 복사한다. 
 		sheetObj.Copy2SheetCol(sheetObj,"prc_grp_loc_cd","prc_grp_loc_cd_bk");
 		
 	}
 	
 	
 	/**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj,1);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {
         
	        case "sheet0":      //hidden 
	             with (sheetObj) {
	            	// Host정보 설정[필수][HostIp, Port, PagePath]
	 				if (location.hostname != "")
	 					InitHostInfo(location.hostname, location.port, page_path);
											
	             }
	             break;
	             
 			case "sheet1":      // sheet1 init
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

                     var HeadTitle1  = "|Sel.|Seq.|Group Code|Description|svc_scp_cd|cre_ofc_cd|gline_seq|grp_loc_seq|Group Code Backup";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,30,  daCenter, false,  "ibflag");
  					InitDataProperty(0, cnt++, dtDummyCheck,   40,  daCenter, false,  "chk");
  					InitDataProperty(0, cnt++, dtDataSeq, 	   50,  daCenter, false,  "seq");
  					InitDataProperty(0, cnt++, dtData,		   100, daCenter, true,	  "prc_grp_loc_cd",		true,   "",	dfNone,	0, true,  true, 4);
  					InitDataProperty(0, cnt++, dtData,		   60,	daLeft,	  true,	  "prc_grp_loc_desc",	true,	"",	dfNone,	0, true,  true);	
  					InitDataProperty(0, cnt++, dtHidden,	   90,  daLeft,   false,  "svc_scp_cd", 		true, 	"", dfNone, 0, false, false);
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "cre_ofc_cd", 		true, 	"", dfNone, 0, false, false);
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "gline_seq", 			true, 	"", dfNone, 0, false, false);	
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "grp_loc_seq", 		true, 	"", dfNone, 0, false, false);
 					
 					InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, false, "prc_grp_loc_cd_bk", false, "", dfNone, 0, false, false);
 										
 					InitDataValid(0, "prc_grp_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					//InitDataValid(0,  "prc_grp_loc_desc",	vtEngUpOnly);		// 영문대문자만 입력
 					CountPosition = 0;
 					WaitImageVisible = false;

 			   }
 			break;

 			case "sheet2":
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

                     var HeadTitle1  = "|Sel.|Seq.|Code|Description|svc_scp_cd|cre_ofc_cd|gline_seq|grp_loc_seq|grp_loc_dtl_seq";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,  daCenter, false, "ibflag");
   					InitDataProperty(0, cnt++, dtDummyCheck,   40,  daCenter, false,  "chk");
   					InitDataProperty(0, cnt++, dtDataSeq, 	   50,  daCenter, false,  "seq");
  					InitDataProperty(0, cnt++, dtPopupEdit,	   100,	daCenter, true,	  "loc_cd",				true,   "", dfNone, 0, true,  true ,5);
  					InitDataProperty(0, cnt++, dtData,		   0,	daLeft,	  true,	  "loc_nm",				false,	"",	dfNone,	0, false, false);	
  					InitDataProperty(0, cnt++, dtHidden,	   90,  daLeft,   false,  "svc_scp_cd", 		true, 	"", dfNone, 0, false, false);
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "cre_ofc_cd", 		true, 	"", dfNone, 0, false, false);
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "gline_seq", 			true, 	"", dfNone, 0, false, false);	
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "grp_loc_seq", 		true, 	"", dfNone, 0, false, false);
 					InitDataProperty(0, cnt++, dtHidden, 	   90,  daLeft,   false,  "grp_loc_dtl_seq", 	true, 	"", dfNone, 0, false, false);	
 										
 					
 					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0,  "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					CountPosition = 0;
 					PopupImage  =  "img/btns_search.gif";
 					ShowButtonImage = 1;
 					WaitImageVisible = false;
 			   }
 			break;
         }
     }

     /**
      * Sheet관련 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch (sAction) {
  			case IBSEARCH: // 조회
  				if (validateForm(sheetObj,document.form,sAction)) {
  					try {
  						sheetObjects[1].WaitImageVisible = false;
  						ComOpenWait(true);
  					
	  					for (var i = 0; i < sheetObjects.length; i++) {
	  						sheetObjects[i].RemoveAll();
	  					}
	  					
	  					formObj.f_cmd.value = SEARCH01;
	  					sheetObj.DoSearch("ESM_PRI_6042GS.do" , FormQueryString(formObj));
	  					
	  					ComOpenWait(false);

  					} catch (e) {
  					    if (e == "[object Error]") {
  					        ComShowMessage(OBJECT_ERROR);
  					    } else {
  					        ComShowMessage(e);
  					    }
  					} finally {
  					   ComOpenWait(false);
  					}
  					
  					toggleButtons();
  				} 
  				break;
  				
  			case IBSEARCHAPPEND: // Detail 조회
 				if (validateForm(sheetObj,document.form,sAction)) {
 					try {
 						sheetObjects[2].WaitImageVisible = false;
 						ComOpenWait(true);
	 					formObj.f_cmd.value = SEARCH02;
	 					sheetObj.DoSearch("ESM_PRI_6042GS.do" , FormQueryString(formObj));
	 					
	 					ComOpenWait(false);

	 				} catch (e) {
	 				    if (e == "[object Error]") {
	 				        ComShowMessage(OBJECT_ERROR);
	 				    } else {
	 				        ComShowMessage(e);
	 				    }
	 				} finally {
	 				   ComOpenWait(false);
	 				}
 					
 					toggleButtons();
 				}
 				break;	
  			 		
  			case IBSAVE: // 저장
  				if (!validateForm(sheetObj,document.form,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = MULTI01;
  				var sParam = FormQueryString(formObj);
  				var sParamSheet1 = sheetObjects[1].GetSaveString();
  				if (sParamSheet1 != "") {
  					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
  				}
  				var sParamSheet2 = sheetObjects[2].GetSaveString();
  				if (sParamSheet2 != "") {
  					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
  				}

  				if (!supressConfirm && !ComPriConfirmSave()) {
  					return false;
  				}
  				
  				try {
  					ComOpenWait(true);

	  				eventStatus = "IBSAVE";
	
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_6042GS.do", sParam);
	  				sheetObjects[2].LoadSaveXml(sXml);
	  				sheetObjects[1].LoadSaveXml(sXml);
	  				
	  				ComOpenWait(false);

  				} catch (e) {
  				    if (e == "[object Error]") {
  				        ComShowMessage(OBJECT_ERROR);
  				    } else {
  				        ComShowMessage(e);
  				    }
  				} finally {
  				   ComOpenWait(false);
  				}	
  				
  				if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
  					return false;
  				} else {
  					ComPriSaveCompleted();
//  					if (getValidRowCount(sheetObjects[2]) <= 0) {
//  						doRowChange(sheetObjects[1], sheetObjects[2], -1, sheetObjects[1].SelectRow, sheetObjects[2].SelectCol, sheetObjects[1].SelectCol, false);
  					
//  					}
  					
  					
  					isFiredNested = true;
  					doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
					isFiredNested = false;	
					
					var validRow = ComGetValidRow(sheetObjects[1],"grp_loc_seq",selectedGrpLocSeq);

			 		if(validRow != -1 && validRow != 1) {
			 			sheetObjects[1].SelectCell(validRow,0,false);
			 		} else {
			 			formObj.grp_loc_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"grp_loc_seq");
		 				doActionIBSheet(sheetObjects[2],document.form,IBSEARCHAPPEND);
		 				validRow = ComGetValidRow(sheetObjects[2],"grp_loc_dtl_seq",selectedGrpLocDtlSeq);
		 				sheetObjects[2].SelectCell(validRow,0,false);
			 		}
 					
			 		eventStatus = "";
  					
  					
  					return true;
  				}
  				break;
  			
  			case IBINSERT: // Row Add
  				if (!validateForm(sheetObj,document.form,sAction)) {
  					return false;
  				}
  				
  				if (sheetObj.id == "sheet1") {
  					var idx = doRowChange(sheetObj, sheetObjects[2], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
  					if (idx < 0) {
  						return false;
  					}
  					sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
  					sheetObj.CellValue(idx, "cre_ofc_cd") = formObj.cre_ofc_cd.value;
  					sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
  					sheetObjects[2].RemoveAll();
  					sheetObj.CellValue(idx, "grp_loc_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_seq"),10) + 1;
  					
  					sheetObj.SelectCell(idx, "prc_grp_loc_cd", false);
  				}
  				if (sheetObj.id == "sheet2") {
  					var idx = sheetObj.DataInsert();
  					sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
  					sheetObj.CellValue(idx, "cre_ofc_cd") = formObj.cre_ofc_cd.value;
  					sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
  					var grp_loc_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "grp_loc_seq");
  					sheetObj.CellValue(idx, "grp_loc_seq") = grp_loc_seq;
  					sheetObj.CellValue(idx, "grp_loc_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq"),10) + 1;
  					
  					sheetObj.SelectCell(idx, "loc_cd", false);
  				}
  				break;
  				
  			case IBDELETE: // Delete
  				if (!validateForm(sheetObj,document.form,sAction)) {
  					return false;
  				}
  				
  	        	if (sheetObj.CheckedRows("chk") <= 0) {
  	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
  	        	}
  	        	
  	        	
//  	        	var delCnt = deleteRowCheck(sheetObj, "chk");
//  				if (delCnt > 0 && sheetObj.id == "sheet1") {
//  					for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
//  						sheetObjects[2].CellValue(i, "chk") = "1";
//  					}
//  					deleteRowCheck(sheetObjects[2], "chk");
//  				}
	        	
	        	if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
					sheetObjects[2].RemoveAll();
				}
				
	        	var delCnt = deleteRowCheck(sheetObj, "chk");
				if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
					sheetObjects[2].RemoveAll();
				}
				
				
  				break;
  				
  				
  			case IBSEARCH_ASYNC02: // 조회 - Group 삭제시 rate 사용여부 확인
//				if (validateForm(sheetObj,document.form,sAction)) {
					//rate 사용여부 체크 start
		        	if (sheetObj.id == "sheet1") {
		        		
		        		//공통 Source
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				    	
						if(chkArr.length == 0){
							sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
						}	
						chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
						
						//ROW ADD후 저장하지 않고 DELETE처리시 적용
						for(var i=0; i < chkArr.length; i++){
							if(sheetObj.CellValue(chkArr[i], "ibflag") == "I") {
								sheetObj.CellValue2(chkArr[i], "chk")= "0";
								
							}	
						}
						
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
						
						if(chkArr == "" || chkArr == null){
							return true;
						}

						
						var sParam = "f_cmd="+SEARCH03+"&"+"cre_usr_id="+formObj.prs_cust_tp_cd.value+"&"+sheetObj.GetSaveString(false, false, "chk");

			             var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_6042GS.do", sParam);
			             var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
			            
			             if (arrErr != null && arrErr.length > 0) {
			            	 
			            	 var txt = "";
			            	 for (var i = 0; i < arrErr.length; i++) {
			            		 	if(i==0) txt += "\n[RATE]\n";
									txt += arrErr[i][2];
									if(i < arrErr.length-1) txt += ", ";
									if(i%5 == 0 && i > 0) txt += "\n";
					    	 }
			            	 
			            	 ComShowCodeMessage("PRI08019", txt);
			            	 
			            	 return false;
			             }
					}
		        	//rate 사용여부 체크 end	
//				}	
				return true;
				break;	
  				
  		  }
  	 }
  	
  
  	 /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *         로직처리;
      *     }
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @returns bool <br>
      *          true  : 폼입력값이 유효할 경우<br>
      *          false : 폼입력값이 유효하지 않을 경우
      * @author 공백진
      * @version 2009.04.17
      */
       function validateForm(sheetObj,formObj,sAction){
    		switch (sAction) {
  			case IBSEARCH: // 조회
  				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
  					return false;
  				} else {
  					return true;
  				}
  				break;
  			case IBSEARCHAPPEND: // 조회
  				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
  					return false;
  				} else {
  					return true;
  				}
  				break;				
  			case IBSAVE: // 저장

  				if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
  					
  					if (sheetObjects[1].IsDataModified
	                        && sheetObjects[1].GetSaveString() == "") {
	                    return false;
	                }
 					
 					if (sheetObjects[2].IsDataModified
	                        && sheetObjects[2].GetSaveString() == "") {
	                    return false;
	                }
  					
//  			        if (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "ibflag") !="D" && getValidRowCount(sheetObjects[2]) <= 0) {
//  			              ComShowCodeMessage("PRI00007");
//  			              return false;
//  			        }
 					
 					if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
 						ComShowCodeMessage("PRI00319", "Location Group");
 						return false;
 					}
  					
  					var rowM = sheetObjects[1].ColValueDup("prc_grp_loc_cd");
  					if (rowM >= 0) {
  						ComShowCodeMessage("PRI00303", "Sheet1", rowM);
  						return false;
  					}					
  					var rowD = sheetObjects[2].ColValueDup("prc_grp_loc_cd|loc_cd");
  					if (rowD >= 0) {
  						ComShowCodeMessage("PRI00303", "Sheet2", rowD);
  						return false;
  					}
  					//code 길이가 4인지 체크
  					if(!checkLength(sheetObjects[1])) return false;
  					
  				} else {
  					ComShowCodeMessage("PRI00301");
  					return false;
  				}				
  				return true;
  				break;
  				
  			case IBINSERT: // Row Add
  				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
  					return false;
  				} else {
  					return true;
  				}
  				break;
  				
  			case IBDELETE: // Delete
  				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
  					return false;
  				} else {
  					return true;
  				}
  				break;
    		}
       }
       
       /**
        * Location code 자리수를 체크한다. <br>
        * <br><b>Example :</b>
        * <pre>
        *     checkLength(sheetObj)
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @return boolean 맞으면 true;
        * @author 이승준
        * @version 2009.04.17
        */
       function checkLength(sheetObj)  {
	        var isOk = true;
	       
			for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
				
				if(ComChkLen(sheetObj.CellValue(i, "prc_grp_loc_cd"),4) != 2) {
					ComShowCodeMessage("PRI03005");
					sheetObj.SelectCell(i, "prc_grp_loc_cd",false);
					isOk = false;
					break;
				}
			}
		
			return isOk; 
       }
      
       /**
        * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
        * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
        * <br><b>Example :</b>
        * <pre>
        *     sheet1_OnBeforeCheck(sheetObj, Row, Col);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {String} Row 
        * @param {String} Col 
        * @return 없음
        * @author 이승준
        * @version 2009.04.17
        */   
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);

  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
  		}
  	}
  	
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnBeforeCheck(sheetObj, Row, Col);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
  	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);

  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
  		}
  	} 
  	
  	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
  		if(!isFiredNested) {
   		    selectedGrpLocSeq = sheetObj.CellValue(NewRow,"grp_loc_seq");
   		    doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
 		}	
 	}
  	
  	
  	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
   	      if(eventStatus != "IBSAVE")
   		      selectedGrpLocDtlSeq = sheetObj.CellValue(NewRow,"grp_loc_dtl_seq");   	  
     }
  	
  	
  	var isFiredNested = false;
 	var supressConfirm = false;
 	/**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
 	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
 		var formObj = document.form;
 		var adjNewRow = ComGetValidRow(sheetM,"grp_loc_seq",selectedGrpLocSeq);
 
 		if (!isFiredNested && (OldRow != NewRow)) {
 			if (sheetM.IsDataModified) {
 				isFiredNested = true;
 				sheetM.SelectCell(OldRow, OldCol, false);
 				isFiredNested = false;
 				
 				if (validateForm(sheetM,document.form,IBSAVE)) {
 					isFiredNested = true;
 					sheetM.SelectCell(NewRow, NewCol, false);
 					isFiredNested = false;
 				} else {
 					isFiredNested = true;
 					sheetM.SelectCell(OldRow, OldCol, false);
 					isFiredNested = false;
 					return -1;
 				}
 			}
 			
 			if (sheetD.IsDataModified) {
 				isFiredNested = true;
 				sheetM.SelectCell(OldRow, OldCol, false);
 				isFiredNested = false;
 				
 				var rslt = false;
 				if (ComShowCodeConfirm("PRI00006")) {
 					supressConfirm = true;
 					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
 					supressConfirm = false;
 				}
 				if (rslt) {
 					isFiredNested = true;
 					sheetM.SelectCell(adjNewRow, NewCol, false);
 					isFiredNested = false;
 				} else {
 					isFiredNested = true;
 					sheetM.SelectCell(OldRow, OldCol, false);
 					isFiredNested = false;
 					return -1;
 				}
 			}
 			
 			if (appendRow) {
 				isFiredNested = true;
 				var idx = sheetM.DataInsert();
 				selectedGrpLocSeq = parseInt(ComPriGetMax(sheetM, "grp_loc_seq"),10) + 1;
 				isFiredNested = false;
 				return idx;
 			} else {
 				formObj.grp_loc_seq.value = sheetM.CellValue(adjNewRow, "grp_loc_seq");
 				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
 				adjNewRow = ComGetValidRow(sheetD,"grp_loc_dtl_seq",selectedGrpLocDtlSeq);
 				sheetD.SelectCell(adjNewRow,0,false);
 			}
 		}
 	}
 	
 	
   /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 이승준
    * @version 2009.04.17
    */  	
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	switch(colname)
    	{
	    	case "loc_cd":	    		
	    		if (Value.length==5){
	    			formObj.f_cmd.value = SEARCH05;
	    			formObj.cd.value = Value;

	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0) {
  						sheetObj.CellValue2(Row,"loc_nm") = arrData[1];
  					}else{
  						sheetObj.CellValue2(Row,"loc_cd") = "";
	  					sheetObj.CellValue2(Row,"loc_nm") = "";
	  					//ComShowCodeMessage("PRI00315");
	  					sheetObj.SelectCell(Row,"loc_cd")
  					}	  				
	    		}else{	  
	    			sheetObj.CellValue2(Row,"loc_cd") = "";
  					sheetObj.CellValue2(Row,"loc_nm") = "";
  					//ComShowCodeMessage("PRI00315");
  					sheetObj.SelectCell(Row,"loc_cd")			
	    		}
	    		break;
    	}
    }    		
   	
    
    /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Location PopUp을 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */  	      	 
	function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "loc_cd"){
			var sUrl = "/hanjin/ESM_PRI_4026.do?grp_cd="+ PRI_SG+"&location_cmd=L";
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			

			}
		}
	}
 	
	
	/**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function toggleButtons() {
 		
 		var formObj = document.form;
 		
 		var cfm_flg = formObj.cfm_flg.value;
 		var isSameOfc = formObj.isSameOfc.value;
 		
 		switch (cfm_flg) {
 		
			case "":		//신규
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn1_Row_Delete");
				ComBtnDisable("btn1_Row_Add");
				ComBtnDisable("btn2_Row_Delete");
				ComBtnDisable("btn2_Row_Add");
				
				break;	
			case "No":		//
				if(isSameOfc == 'true') {
					ComBtnEnable("btn_Save");
					ComBtnEnable("btn1_Row_Delete");
					ComBtnEnable("btn1_Row_Add");
					ComBtnEnable("btn2_Row_Delete");
					ComBtnEnable("btn2_Row_Add");
					sheetControl(true);
				} else {
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn1_Row_Delete");
					ComBtnDisable("btn1_Row_Add");
					ComBtnDisable("btn2_Row_Delete");
					ComBtnDisable("btn2_Row_Add");
					sheetControl(false);
				}
				
				break;
			case "Yes":		//
				if(isSameOfc) {
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn1_Row_Delete");
					ComBtnDisable("btn1_Row_Add");
					ComBtnDisable("btn2_Row_Delete");
					ComBtnDisable("btn2_Row_Add");
					sheetControl(false);
				} else {
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn1_Row_Delete");
					ComBtnDisable("btn1_Row_Add");
					ComBtnDisable("btn2_Row_Delete");
					ComBtnDisable("btn2_Row_Add");
					sheetControl(false);
				}
				break;
		
		}	
	}
 	
 	
 	/**
     * sheet에서 값이 바뀐 경우 발생한다. <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * src_info_cd 값을 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 
     * @param {int} Col 
     * @param {String} Value 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		var formObj = document.form;
		
		var colname = sheetObj.ColSaveName(Col);  
		
		if (colname == "prc_grp_loc_cd") {
			if (Value.length != 4) {
				sheetObj.CellValue2(Row, "prc_grp_loc_cd") = "";
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				
				//ComShowCodeMessage("PRI00317");
				return false;
			} else {
				var sParam = "f_cmd="+SEARCH03+"&svc_scp_cd="+formObj.svc_scp_cd.value+"&cre_ofc_cd="+formObj.cre_ofc_cd.value;
				sParam += "&gline_seq="+formObj.gline_seq.value;
				sParam += "&cre_usr_id="+formObj.prs_cust_tp_cd.value;
				sParam += "&prc_grp_loc_cd="+sheetObj.CellValue(Row, "prc_grp_loc_cd_bk");

				var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_6042GS.do", sParam);
			    var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
			    
			    if (arrErr != null && arrErr.length > 0) {
			    	 
			         var txt = "";
			    	 for (var i = 0; i < arrErr.length; i++) {
		    		 		if(i==0) txt += "\n[RATE] - ";
							txt += arrErr[i][2];
							if(i < arrErr.length-1) txt += ", ";
							if(i%5 == 0 && i > 0) txt += "\n";
			    	 }
			    	 
			    	 ComShowCodeMessage("PRI08019", txt);
			    	 
			    	 sheetObj.CellValue2(Row, "prc_grp_loc_cd") = sheetObj.CellValue(Row, "prc_grp_loc_cd_bk");
			    	 
			    	 sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
			    	 
			    	 sheetObj.RowStatus(Row) = "R";
			    	 
			    	 return false;
			    }
				
			}
		}
	  
	}
 	
 	
 	/**
     * IBSheet의 Cell을  컨폼 여부에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sheetControl(mode);
     * </pre>
     * @param   {boolean} flag 필수          
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */   
     function sheetControl(flag) {
	     	var sheetObj1 = sheetObjects[1];
	     	var sheetObj2 = sheetObjects[2];
	     	
			for (var i = 1; i <= sheetObj1.RowCount;i++) {
				sheetObj1.CellEditable(i, "chk") = flag;
				sheetObj1.CellEditable(i, "prc_grp_loc_cd") = flag;
				sheetObj1.CellEditable(i, "prc_grp_loc_desc") = flag;
			}
			
			for (var i = 1; i <= sheetObj2.RowCount;i++) {
				sheetObj2.CellEditable(i, "chk") = flag;
				sheetObj2.CellEditable(i, "loc_cd") = flag;
				sheetObj2.CellEditable(i, "loc_nm") = flag;
			}

     }  
	
	/* 개발자 작업  끝 */