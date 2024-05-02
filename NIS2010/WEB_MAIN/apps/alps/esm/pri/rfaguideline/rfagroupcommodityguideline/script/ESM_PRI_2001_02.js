/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2001_02.js
*@FileTitle : RFA Guideline Creation - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.29 최성민
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2001_02() {
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
	
 	 var enableFlag = true;
 	
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.04.16
     */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          var sheetObject3 = sheetObjects[2];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		if (srcName != null && srcName !="" && srcName.indexOf("btn") == 0 
						&& getButtonDisableStatus(srcName)){
				return;
			}
            switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
							
				case "btn_Save":				
					if (validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;	
					
				case "btn_downexcel":
					if (validateForm(sheetObject3,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					}
					break;

				case "btn_Add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;					

				case "btn_Add2":
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
					break;					

				case "btn_Del":			
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;					

				case "btn_Del2":			
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
					break;	
				
            } // end switch
     	}catch(e) {
			if (e == "[object Error]") {
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
      * @author 최성민
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
      * @author 최성민
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
         
         toggleButtons("CLEAR");
         parent.loadTabPage();
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
      * @author 최성민
      * @version 2009.04.17
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id; 		 

         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 328;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     
                     var HeadTitle = "|Sel.|Seq.|svcscpcd|glineseq|grp_cmdtseq|Group\nCode|Description";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


     //             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
     //							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
     //				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
     //							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  	false, 	"ibflag");
 	                 InitDataProperty(0, cnt++,  dtDummyCheck,    	40,    	daCenter,  	false, 	"chk"); 	                
                     InitDataProperty(0, cnt++ , dtDataSeq,    		50,    	daCenter,  	false, 	"seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	  	40,    	daCenter,  	true,  	"svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	  	40,    	daCenter,  	true,  	"gline_seq"); 
	                 
	                 InitDataProperty(0, cnt++ , dtHidden,    	  	40,    	daCenter,  	true,  	"grp_cmdt_seq");
                     InitDataProperty(0, cnt++ , dtData,     	 	100,    daCenter,  	false, 	"prc_grp_cmdt_cd",   	true, 	"", dfNone, 0, false, false,5,5);
 					 InitDataProperty(0, cnt++ , dtData,     	 	180,    daLeft,		false, 	"prc_grp_cmdt_desc", 	true, 	"", dfNone, 0, true, true, 30);
 					 					
 					 ShowButtonImage = 2;
 					 InitDataValid(0, "prc_grp_cmdt_desc", vtEngOther,PRI_VALID_CHAR);	// 영대문자,숫자만 입력
	                 InitDataValid(0, "prc_grp_cmdt_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
	                 WaitImageVisible = false;
 					
                }
                 break;

             case "sheet2":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 328;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     
                     var HeadTitle = "|Sel.|Seq.|svcscpcd|glineseq|Commodity\nType|grpcmdtseq|grpcmdtdtlseq|Commodity\nCode" +
                     		"|Description|cre_dt";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


 //             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
 //							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
 //				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
 //							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  false,	"ibflag");
 	                 InitDataProperty(0, cnt++,  dtDummyCheck,   40,  daCenter,  false,	"chk");
// 	                 InitDataProperty(0, cnt++ , dtDelCheck,     40,  daCenter,  false,	"del_chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,  	 40,  daCenter,  true, 	"seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "gline_seq"); 
	                 InitDataProperty(0, cnt++ , dtCombo,      	 100,  daCenter,  true,	"prc_cmdt_tp_cd", 	true,	"",	dfNone,	0,	true,	true);
                     
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "grp_cmdt_seq");      
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "grp_cmdt_dtl_seq");
                     InitDataProperty(0, cnt++ , dtPopupEdit, 	 100, daCenter,  false, "prc_cmdt_def_cd",  true,  "",  dfNone, 0, true,  true ,6);
 					 InitDataProperty(0, cnt++ , dtData,     	 200, daLeft, 	 false, "loc_des",          false, "",  dfNone, 0, false,  false,100);
    				 
 					 InitDataProperty(0, cnt++ , dtHidden,    	  	40,    	daCenter,  	true,  	"cre_dt"); 
 					
 					 //공통 - type
 	 				 InitDataCombo(0,"prc_cmdt_tp_cd", COMODITY_TYPE2[1], COMODITY_TYPE2[0], " ", " ", 0);
 					 
 					 ShowButtonImage = 2;
	                 InitDataValid(0,  "prc_cmdt_def_cd",		vtNumericOnly);		// 숫자만 입력 

	                 WaitImageVisible = false;
                }
                 break;
             case "sheet3":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 260;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle = "|Seq.|Group Code|Group Description|Code|Description";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


 //             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
 //							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
 //				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
 //							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,  	 40,  daCenter,  true, 	"seq");
	                 InitDataProperty(0, cnt++ , dtData,     	 150, daCenter,  false, "prc_grp_cmdt_cd");
 					 InitDataProperty(0, cnt++ , dtData,     	 150, daLeft,	 false, "prc_grp_cmdt_desc");
                     InitDataProperty(0, cnt++ , dtPopupEdit, 	 110, daCenter,  false, "prc_cmdt_def_cd");
 					 InitDataProperty(0, cnt++ , dtData,     	 280, daLeft, 	 false, "cmdt_nm");  

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
      * @author 최성민
      * @version 2009.04.17
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          sheetObj.ShowDebugMsg = false;
	          switch(sAction) {		  		  		
	 				case IBSEARCH:      //조회
						if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
							sheetObjects[0].RemoveAll();
							sheetObjects[1].RemoveAll();
													
							formObj.f_cmd.value = SEARCH01;
							sheetObj.DoSearch("ESM_PRI_2001_02GS.do", FormQueryString(formObj));
						} else {
							ComShowCodeMessage('PRI08001');
						}	 
	 					break;
	                
	 				case IBSEARCHAPPEND: // 조회
	 				
						if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
							formObj.f_cmd.value = SEARCH02;
							sheetObj.DoSearch("ESM_PRI_2001_02GS.do" , FormQueryString(formObj));
						}
						break;
	 				case IBSAVE:        //저장
		 				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
							return false;
						}
		 				

						if (!supressConfirm && !ComPriConfirmSave()) {
							return false;
						}

		  				ComOpenWait(true);
						formObj.f_cmd.value = MULTI;
						var sParam = FormQueryString(formObj);
						var sParamSheet1 = sheetObjects[0].GetSaveString();	
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
						
						var sParamSheet2 = sheetObjects[1].GetSaveString();		
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
											
						var sXml = sheetObj.GetSaveXml("ESM_PRI_2001_02GS.do", sParam);
						sheetObjects[1].LoadSaveXml(sXml);
						sXml = ComDeleteMsg(sXml);
						sheetObjects[0].LoadSaveXml(sXml);
						
						if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
							return false;
						} else {
							if (getValidRowCount(sheetObjects[1]) <= 0) {
								doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, false);
							}
							
							parent.setTabStyle();
							return true;
						}
						break;
	
	 				case IBDOWNEXCEL:
	 					if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
	 						formObj.f_cmd.value = SEARCH03;
	 						sheetObj.DoSearch("ESM_PRI_2001_02GS.do" , FormQueryString(formObj));
							sheetObj.Down2Excel(-1);
	 					} else {
	 						ComShowCodeMessage('PRI08001');
	 					}
	 					break;
	 					
	 					
					case IBINSERT:      // 입력
						if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
							return false;
						}
						
						if (sheetObj.id == "sheet1") {
							var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);
							var maxCode = 0;
							if (idx < 0) {
								return false;
							}
							sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
							sheetObj.CellValue2(idx, "gline_seq") = formObj.gline_seq.value;
							sheetObjects[1].RemoveAll();
							sheetObj.CellValue2(idx, "grp_cmdt_seq") = parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq")) + 1;
									
							maxCode = parseInt(groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd")) + 1;
							sheetObj.CellValue2(idx,"prc_grp_cmdt_desc")= "Group "+ maxCode;
							
							maxCode = ComLpad(maxCode,   4, "0");
							sheetObj.CellValue2(idx,"prc_grp_cmdt_cd")= "G"+ maxCode;
							
							sheetObj.SelectCell(idx, "prc_grp_cmdt_desc", false);
						}
						if (sheetObj.id == "sheet2") {
							var idx = sheetObj.DataInsert();
							sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
							sheetObj.CellValue2(idx, "gline_seq") = formObj.gline_seq.value;
							var grp_cmdt_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_cmdt_seq");
							sheetObj.CellValue2(idx, "grp_cmdt_seq") = grp_cmdt_seq;
							sheetObj.CellValue2(idx, "grp_cmdt_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq")) + 1;
							
							sheetObj.SelectCell(idx, "prc_cmdt_def_cd", false);
						}
						break;	
					case IBDELETE: // Delete	
						if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
							return false;
						}				
					
			        	if (sheetObj.CheckedRows("chk") <= 0) {
			        		sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "1";
			        	}
			        	
						if (sheetObj.id == "sheet1") {
							if(!checkUseDataExist(sheetObj, formObj)) {
								return false;
							}
						}
							
						if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
							sheetObjects[1].RemoveAll();
						}
						
			        	var delCnt = deleteRowCheck(sheetObj, "chk");
						if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
							sheetObjects[1].RemoveAll();
						}
						

						//DETAIL의 모든 ROW를 삭제할경우 체크
						if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
							if(ComShowCodeConfirm('PRI00021')){
				  				ComOpenWait(true);
				  				//MASTER에 체크되어 있는 데이터를 언체크한다.
								sheetObjects[0].CheckAll2("chk") = 0;
								//RATE화면에서 사용중인지 체크한다. 사용중이면 재조회
								if(!checkUseDataExist(sheetObjects[0], formObj)) {
									formObj.grp_cmdt_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_cmdt_seq");
									doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									return false;
								} else {								
									if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "chk") == "1") {
										sheetObjects[1].RemoveAll();
									}
									
									var delCnt = deleteRowCheck(sheetObjects[0], "chk");

									if (delCnt > 0 && sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) == "D") {
										sheetObjects[1].RemoveAll();
									}
								}
							}
						}
								
						break;				
									
	          }
    	  }catch(e){
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e);
    			}
    		}finally {
    			 ComOpenWait(false);
    		}
      }
      

  /**
   * 삭제하려는 Group Code 가 Rate 에서 사용되고 있는경우 false 를 리턴한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *     checkUseDataExist(sheetObj, formObj);
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @return boolean
   * @author 최성민
   * @version 2010.02.16
   */
   	function checkUseDataExist(sheetObj, formObj) {

   		if (sheetObj.CheckedRows("chk") <= 0) {
   			sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "1";
       	}
   		
   		var arrChecked = sheetObj.FindCheckedRow("chk").split("|");
		for (var i = 0; arrChecked != null && i < arrChecked.length; i++) {
			if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
				continue;
			}
			
			formObj.f_cmd.value = SEARCH11;
			var sParam = FormQueryString(formObj) + "&prc_grp_cmdt_cd=" + sheetObj.CellValue(arrChecked[i], "prc_grp_cmdt_cd");
			
			var sXml = sheetObj.GetSearchXml("ESM_PRI_2001_02GS.do", sParam);
			var arrTemp = ComPriXml2Array(sXml, "etc1");
			
			if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
				var cntInUse = parseInt(arrTemp[0][0]);
				
				if (cntInUse > 0) {
					ComShowCodeMessage("PRI08017");
					return false;
				}
			} else {
				return false;
			}
		}
		
   		return true;
   	}
   	
  /**
   * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
   * sheet1의 전체체크를 컨트롤한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
   * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
   * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
   * @return 없음
   * @author 최성민
   * @version 2009.05.19
   */	
  	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
    /**
    * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
    * sheet2의 전체체크를 컨트롤한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}      
      

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * row 선택시 발생하는 로직을 처리하는 doRowChange function을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */  	
 	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
 		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
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
    * @author 최성민
    * @version 2009.04.17
    */  	
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	switch(colname)
    	{
	    	case "prc_cmdt_def_cd":	    		
	    		if (Value.length==6){
	    			formObj.f_cmd.value = SEARCH08;
	    			formObj.cd.value = Value;

	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
  					if (arrData[1] != ""){
  						sheetObj.CellValue2(Row,"loc_des") = arrData[1];
  						sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "C";
  					}else{
  						sheetObj.CellValue2(Row,"loc_des") = "";
	  					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") = "";
	  					sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		} else if (Value.length==4){
	    			formObj.f_cmd.value = COMMAND29;
	    			formObj.cd.value = Value;

	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
  					if (arrData[1] != ""){
  						sheetObj.CellValue2(Row,"loc_des") = arrData[1];
  						sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "R";
  					}else{
  						sheetObj.CellValue2(Row,"loc_des") = "";
	  					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") = "";
	  					sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		} else {	  
	    			sheetObj.CellValue2(Row,"loc_des") = "";	    		
  					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") = "";
  					sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "";
  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")  				
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
    * @author 최성민
    * @version 2009.05.07
    */  	      	 
	function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
    	var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var tpCd = "C";
		var prcCmdtTpCd = sheetObj.CellValue(Row,"prc_cmdt_tp_cd");
		
		if (colName == "prc_cmdt_def_cd"){
			var sUrl = "/hanjin/ESM_PRI_4027.do?prc_cmdt_tp_cd="+ prcCmdtTpCd + "&commodity_cmd=CR&grp_cd="+PRI_RG;
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;	
				sheetObj.CellValue2(Row, "prc_cmdt_tp_cd") = rtnVal.tp;
			}
		}
	}
    
    
	var isFiredNested = false;
	var supressConfirm = false;
   /**
    * SHEET의 ROW을 클릭할때 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 해당하는 자식SHEET를 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM 필수 HTML태그(Object) 오브젝트
    * @param {ibsheet} sheetD 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} appendRow 필수 SHEET Row 추가 유무
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
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
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
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
				isFiredNested = false;
				return idx;
			} else {
				formObj.grp_cmdt_seq.value = sheetM.CellValue(adjNewRow, "grp_cmdt_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
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
    * @author 최성민
    * @version 2009.04.17
    */
     function validateForm(sheetObj,formObj,sAction){
  		switch (sAction) {
			case IBSEARCH: // 조회
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;
			case IBSEARCHAPPEND: // 조회
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;				
			case IBDOWNEXCEL: // Excel Download
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;		
			case IBSAVE: // 저장

				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
					
					if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
						return false;
					}
					
					if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
						return false;
					}	
					
					if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
						&& getValidRowCount(sheetObjects[1]) <= 0) {
						ComShowCodeMessage("PRI00319", "Commodity Group");
						return false;
					}

					var rowM = sheetObjects[0].ColValueDup("prc_grp_cmdt_cd", false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet1", rowM);
						return false;
					}					
					var rowD = sheetObjects[1].ColValueDup("prc_cmdt_tp_cd|grp_cmdt_seq|prc_cmdt_def_cd", false);
					if (rowD >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet2", rowD);
						return false;
					}					
				} else {
					ComShowCodeMessage("PRI00301");
					return false;
				}	
				break;
				
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				
				if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
					ComShowCodeMessage("PRI01004");
					return false;					
				}
				break;
				
			case IBDELETE: // Delete
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				if (getValidRowCount(sheetObj) == 0) {
					return false;					
				}
				
				break;
		}
  		
  		return true;
     }
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;
		
		if( sheetObj.SearchRows > 0){
			document.form.yn_data.value = "Y"
		}else{
			document.form.yn_data.value = "N"
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
     * @author 최성민
     * @version 2009.06.22
     */ 
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)
	{
		//SORT 처리
		sheetObjects[1].ColumnSort("prc_cmdt_tp_cd|prc_cmdt_def_cd","DESC","DESC|ASC");
				
		if( sheetObj.RowCount > 0){
			document.form.yn_data.value = "Y"
		}else{
			document.form.yn_data.value = "N"
		}
		parent.setTabStyle();
	}    
	
    /**
    * 주어진 컬럼의 Max값 구하기 <br>
    *
    * @param {object} sheetObj 필수, IBSheet Object.
    * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
    * @return int Max값
     * @author 박성수
     * @version 2009.04.22
    */
	 function groupCodeGetMax(sheetObj, sCol) {

       var max = 0;

       for (var i = 0; i <= sheetObj.RowCount; i++) {
    	   if (parseInt(sheetObj.CellValue(i, sCol).substr(1,4),10) > max) {
        	   max = parseInt(sheetObj.CellValue(i, sCol).substr(1,4),10);
           }
       }
       return max;
    }	
    
    /**
     * 버튼 컨트롤하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {string} mode 세팅값
     * @return 없음
     * @author 최성민
     * @version 2009.05.22
     */	
 	function toggleButtons(mode) {
 		switch (mode) {
 		case "CLEAR":
 			ComBtnDisable("btn_Retrieve");
 			ComBtnDisable("btn_Save");
 			ComBtnDisable("btn_downexcel");
 			
 			ComBtnDisable("btn_Add");
 			ComBtnDisable("btn_Add2");
 			ComBtnDisable("btn_Del");
 			ComBtnDisable("btn_Del2");
 			break;
 		case "INIT":
 			ComBtnEnable("btn_Retrieve");
 			ComBtnEnable("btn_Save");
 			ComBtnEnable("btn_downexcel");
 			
 			ComBtnEnable("btn_Add");
 			ComBtnEnable("btn_Add2");
 			ComBtnEnable("btn_Del");
 			ComBtnEnable("btn_Del2");
 			break;
 		case "READONLY":
 			ComBtnEnable("btn_Retrieve");
 			ComBtnDisable("btn_Save");
 			ComBtnEnable("btn_downexcel");
 			
 			ComBtnDisable("btn_Add");
 			ComBtnDisable("btn_Add2");
 			ComBtnDisable("btn_Del");
 			ComBtnDisable("btn_Del2");
 			break;
 		}
 	}
	
 	
    /**
    * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
    * 화면이 보여지며 조회를 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sSvcScpCd 필수 svc_scp_cd 값
    * @param {string} sGlineSeq 필수 gline_seq 값
    * @return 없음
    * @author 최성민
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;

			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
						
			if(enableFlag && (isAproUsr == "true" || isAproUsr)) {
				toggleButtons("INIT");
			} else {
				enableFlag = false;
				tabEnableSheet(enableFlag);
				toggleButtons("READONLY");
			}	
			
		}
	}
    
	
    /**
    * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 최성민
    * @version 2009.04.17
    */ 	 	 
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
	 
   
    /**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */ 			
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		

	}   
   
	
	
	/* 개발자 작업  끝 */