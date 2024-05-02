/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002_03.js
*@FileTitle : Commodity Group Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.01 최성민
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
    function ESM_PRI_0002_03() {
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
	var isFiredNested = false;
	var supressConfirm = false;	
	
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.04.16
     */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

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
						fontChange();
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				
				case "btn_DownExcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				
				case "prc_cust_cd":
			    	if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
			    		obj_click();
			    	}
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
      * @author 공백진
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
      * @author 공백진
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
      * @author 공백진
      * @version 2009.04.17
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id; 		 

         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 320;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     
                     var HeadTitle = "|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grp_cmdtseq|Group Code|Description";
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
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false, "ibflag");
 	                 InitDataProperty(0, cnt++,  dtHidden,    	40,    daCenter,  false, "chk"); 	                
                     InitDataProperty(0, cnt++ , dtDataSeq,    		  50,    daCenter,  false, "seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "gline_seq"); 
	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "prc_cust_tp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "grp_cmdt_seq");
                     InitDataProperty(0, cnt++ , dtData,     	 100,    daCenter,  false, "prc_grp_cmdt_cd",   false, "", dfNone, 0, false, false,5,5);
 					 InitDataProperty(0, cnt++ , dtData,     	 130,    daLeft,	false, "prc_grp_cmdt_desc", false, "", dfNone, 0, false, false);
 					
 					 ShowButtonImage = 2;
 					 InitDataValid(0, "prc_grp_cmdt_desc", vtEngOther,PRI_VALID_CHAR);	// 영대문자,숫자만 입력
	                 InitDataValid(0, "prc_grp_cmdt_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력

	                 WaitImageVisible = false;
                }
                 break;

             case "sheet2":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 320;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     
                     var HeadTitle = "|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grpcmdtseq|grpcmdtdtlseq|Code|Description";
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
 	                 InitDataProperty(0, cnt++,  dtHidden,   	40,  daCenter,  false,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,  	 40,  daCenter,  true, 	"seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "gline_seq"); 
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "prc_cust_tp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "grp_cmdt_seq");      
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "grp_cmdt_dtl_seq");
                     InitDataProperty(0, cnt++ , dtData, 	 	100, daCenter,  false, "prc_cmdt_def_cd",  false,  "",  dfNone, 0, false,  false ,6);
 					 InitDataProperty(0, cnt++ , dtData,     	 280, daLeft, 	 false, "loc_des",          false, "",  dfNone, 0, false,  false,100);
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
      * @author 공백진
      * @version 2009.04.17
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          sheetObj.ShowDebugMsg = false;
	          switch(sAction) {
		          case IBSEARCH_ASYNC01: // 화면조회시 Customer Type 재조회
		  			ComOpenWait(true);
			  		
					formObj.f_cmd.value = SEARCH10;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0002_03GS.do" , FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "cd|nm|rcnt");
					var eleName = "cust_tp";
					var j = 1;
					var optCheck = 0;
					for (var i = 0; i < arrData.length; i++) {
						switch (arrData[i][0]){
						case "A":
							j = "1";
							break;
						case "I":
							j = "2";
							break;
						case "N":
							j = "3";
							break;
						case "O":
							j = "4";
							break;								
						}
						
						if (parseInt(arrData[i][2]) > 0) {
							document.getElementById(eleName + j).style.fontWeight = "bold";
							if (optCheck == 0){
								optCheck = j;
							}
						} else {
							document.getElementById(eleName + j).style.fontWeight = "";
						}
					}
					if (optCheck <= 0){
						document.form.prc_cust_cd[0].checked = true;
					}else{
						document.form.prc_cust_cd[optCheck - 1].checked = true;	
					}
					
					
					var obj = document.form;
					if (obj.prc_cust_cd[0].checked == true){
						obj.prc_cust_tp_cd.value = "A";
					}else if (obj.prc_cust_cd[1].checked == true){
						obj.prc_cust_tp_cd.value = "I";
					}else if (obj.prc_cust_cd[2].checked == true){
						obj.prc_cust_tp_cd.value = "N";
					}else if (obj.prc_cust_cd[3].checked == true){
						obj.prc_cust_tp_cd.value = "O";
					}	
					ComOpenWait(false);
		
					break;
	 				case IBSEARCH:      //조회
						if (validateForm(sheetObj,document.form,sAction)) {
				  			ComOpenWait(true);
							for (var i = 0; i < sheetObjects.length; i++) {
								sheetObjects[i].RemoveAll();
							}
							
							formObj.f_cmd.value = SEARCH01;
							sheetObj.DoSearch("ESM_PRI_0002_03GS.do", FormQueryString(formObj));
							ComOpenWait(false);
						} else {
							ComShowCodeMessage('PRI08001');
						}	 
	 					break;
	                
	 				case IBSEARCHAPPEND: // 조회
	 				
						if (validateForm(sheetObj,document.form,sAction)) {
				  			ComOpenWait(true);
							formObj.f_cmd.value = SEARCH02;
							sheetObj.DoSearch("ESM_PRI_0002_03GS.do" , FormQueryString(formObj));
							ComOpenWait(false);
						}
						break;
	 			
					case IBDOWNEXCEL:      //excel		
			  			ComOpenWait(true);			
						formObj.f_cmd.value = SEARCH03;
						sheetObjects[2].DoSearch("ESM_PRI_0002_03GS.do", FormQueryString(formObj));
						ComOpenWait(false);                					
						sheetObjects[2].Down2Excel(-1);
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
     * @author 공백진
     * @version 2009.04.17
     */  	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	    doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}	
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
			formObj.grp_cmdt_seq.value = sheetM.CellValue(adjNewRow, "grp_cmdt_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
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
		}
  		return true;
     }

     /**
     * radio버튼 Axon 이벤트  처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	 
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListener('click', 'obj_click', 'prc_cust_cd');
	}
	
    /**
    * radio버튼 click 이벤트 발생시 호출되는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param 없음
    * @returns 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	
	function obj_click()
	{
		var obj = document.form;

		if (obj.prc_cust_cd[0].checked == true){
			obj.prc_cust_tp_cd.value = "A";
		}else if (obj.prc_cust_cd[1].checked == true){
			obj.prc_cust_tp_cd.value = "I";
		}else if (obj.prc_cust_cd[2].checked == true){
			obj.prc_cust_tp_cd.value = "N";
		}else if (obj.prc_cust_cd[3].checked == true){
			obj.prc_cust_tp_cd.value = "O";
		}		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}  
    
    
    /**
     * Radio 버튼의  font를 변경하는 function <br>
     * 데이터가 있다면 BOLD로 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj = document.form;
		var fontBold ="";
    	var eleName ="";
    	
    	for (var i = 0; i <4; i++){
    		if (formObj.prc_cust_cd[i].checked == true){
    			eleName = "cust_tp" + (i+1);
    		}
    	}
    	
 		if (row_count > 0) {
 			fontBold = "bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight = fontBold;
    }         
     /**
      * OnSearchEnd 이벤트 발생시 호출되는 function <br>
      *  <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
      * @param {string} errMsg 필수 메세지
      * @return 없음
      * @author 최성민
      * @version 2009.05.19
      */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;
		
		if( sheetObj.SearchRows > 0){
			document.form.yn_data.value = "Y"
		}else{
			document.form.yn_data.value = "N"
		}
		/*
		if (formObj.svc_scp_cd.value == "TPW" || formObj.svc_scp_cd.value == "ACE" || formObj.svc_scp_cd.value =="MXW"){
			if (sheetObj.RowCount <= 0){
				ComBtnEnable("btn_Copy");
			}else{
				ComBtnDisable("btn_Copy");
			}
			
		}else{
			ComBtnDisable("btn_Copy");
		}
		*/
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
			ComBtnDisable("btn_DownExcel");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_DownExcel");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_DownExcel");
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
    * @author 공백진
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
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
    * @author 공백진
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
     * @author 공백진
     * @version 2009.04.17
     */ 			
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;

		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		

	}   
   
	
	
	/* 개발자 작업  끝 */