/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0067.js
*@FileTitle : TPR Target Lanes Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.19 김종옥
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
     * @class vop_opf_0067 : vop_opf_0067 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0067() {
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
          
         var sheetObject1  = sheetObjects[0];   //t1sheet1
         var sheetObject2  = sheetObjects[1];   //t1sheet1
         

         
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 				switch(srcName) {

 						case "btn_Save":
 							    doActionIBSheet(sheetObject2, formObject, IBSAVE);
 								break;
 		                case "btn_Close":
 		                		self.close();
 		                		break;
 								
						case "btn_Add":
								if(ComIsBtnEnable("btn_Save")){
									sheet1_OnDblClick(sheetObject1, sheetObject1.SelectRow, 2);
								}
								break;		

						case "btn_Del":
								if(ComIsBtnEnable("btn_Save")){
						        	sheet2_OnDblClick(sheetObject2, sheetObject2.SelectRow, 2);
								}
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
     function loadPage(strOfcCd) {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }

 		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 		 
 		var ofcCd = strOfcCd;
 		if(ofcCd == "SELOPA"){
 			ComEnableObject(document.all.btn_Del, true);
 			ComEnableObject(document.all.btn_Add, true);
 			ComBtnEnable("btn_Save");
 		}else{
 			ComEnableObject(document.all.btn_Del, false);
 			ComEnableObject(document.all.btn_Add, false); 			
 			ComBtnDisable("btn_Save");
 			
 			
 		}
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

             case "sheet1_":
 				with (sheetObj) {
                     // 높이 설정
                     style.height = 322;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

 					 var HeadTitle1 = "|All Lanes|All Lanes|";
 					 var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                    
                     var prefix="sheet1_";

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	prefix+"ibflag");
 					 InitDataProperty(0, cnt++ , dtDataSeq,			80,		daCenter,		true,	prefix+"Seq");
                     InitDataProperty(0, cnt++ , dtAutoSum,			150,	daCenter,		true,	prefix+"vsl_slan_cd",	    false,		"",				dfNone,				0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,			150,	daCenter,		true,	prefix+"tml_prod_rpt_flg",	false,		"",				dfNone,				0,		false,		false);
                     //InitDataProperty(0, cnt++ , dtData,			150,	daCenter,		true,	prefix+"tml_prod_rpt_flg",	false,		"",				dfNone,				0,		true,		true);
                     
 					 CountPosition = 0;
 										
 				}
 				break;
 							
             case "sheet2_":
 				with (sheetObj) {
 					
 					 WaitImageVisible = false;
 					
                     // 높이 설정
                     style.height = 322;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

 					 var HeadTitle1 = "|TPR Target Lanes|TPR Target Lanes|";
 					 var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     var prefix="sheet2_";

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	prefix+"ibflag");
 					 InitDataProperty(0, cnt++ , dtDataSeq,			80,		daCenter,		true,	prefix+"Seq");
                     InitDataProperty(0, cnt++ , dtAutoSum,			150,	daCenter,		true,	prefix+"vsl_slan_cd",	    false,		"",			dfNone,				0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,			150,	daCenter,		true,	prefix+"tml_prod_rpt_flg",	false,		"",				dfNone,				0,		false,		false);
                     //InitDataProperty(0, cnt++ , dtData,			150,	daCenter,		true,	prefix+"tml_prod_rpt_flg",	false,		"",				dfNone,				0,		true,		true);
                     
      
                   	 sheetObj.MessageText("Sum") = "Total";
                    // sheetObj.SumText();
                   	  
 					CountPosition = 0;
 										
 				}
 				break;
 							
 		}
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
 						if(sheetObj.id == "sheet1_")
 						{
 							formObj.tml_prod_rpt_flg.value = "N";
 							formObj.f_cmd.value = SEARCH;
 							sheetObj.DoSearch("VOP_OPF_0067GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
 						}else if(sheetObj.id == "sheet2_") {
 							formObj.tml_prod_rpt_flg.value = "Y";
 	 						formObj.f_cmd.value = SEARCH;
 	 						sheetObj.DoSearch("VOP_OPF_0067GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
 						}
 						break;
 					case IBSAVE:        //저장
 						/**
 					     if(validateForm(sheetObj,formObj,sAction)) {
 							formObj.f_cmd.value = MULTI;
 							var sParam = ComGetSaveString(sheetObjects);
 							alert(sParam);
 						    if (sParam == "") return;
 						   formObj.tml_prod_rpt_flg.value = "Y";
 						    sParam += "&" + FormQueryString(formObj);
 						    var sXml = sheetObjects[1].GetSaveXml("VOP_OPF_0067GS.do", sParam);   
 						    sheetObjects[1].LoadSaveXml(sXml);   
 						} 				
 					    **/
 			            if(validateForm(sheetObj,formObj,sAction)) {
 							formObj.f_cmd.value = MULTI;
 							var sParam = ComGetSaveString(sheetObjects);
 						    if (sParam == "") return;
 						    sParam += "&" + FormQueryString(formObj);
 						    var sXml = sheetObjects[0].GetSaveXml("VOP_OPF_0067GS.do", sParam);
 						    sheetObjects[0].LoadSaveXml(sXml);
 						    //sheetObjects[1].LoadSaveXml(sXml);   
 						}
 					     
 						break;
 					
         }
     }


     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	   /**
             if (!isNumber(formObj.iPage)) {
                 return false;
             }
               **/
         }

         return true;
     }
     
     function sheet1_OnDblClick(sheetObj, Row, Col){
    	 var vVslSlanCd = sheetObj.CellValue(Row, 2);

    	 sheetObj.RowDelete(Row, false);

    	 sheetObjects[1].DataInsert(-1); 
    	 //sheetObjects[1].CellValue(sheetObjects[1].LastRow-1, Col) = sheetObj.CellValue(Row, Col);
    	 sheetObjects[1].CellValue(sheetObjects[1].LastRow-1, 2) = vVslSlanCd;
    	 sheetObjects[1].CellValue(sheetObjects[1].LastRow-1, 3) = "Y";

    	 sheetObjects[0].SumText(0, 2)= sheetObjects[0].RowCount;
    	 sheetObjects[1].SumText(0, 2)= sheetObjects[1].RowCount;
     }
     
     function sheet2_OnDblClick(sheetObj, Row, Col){
    	 var vVslSlanCd = sheetObj.CellValue(Row, 2);
    	 
    	 sheetObj.RowDelete(Row, false);

    	 sheetObjects[0].DataInsert(-1); 
    	 //sheetObjects[1].CellValue(sheetObjects[1].LastRow-1, Col) = sheetObj.CellValue(Row, Col);
    	 sheetObjects[0].CellValue(sheetObjects[0].LastRow-1, 2) = vVslSlanCd;
    	 sheetObjects[0].CellValue(sheetObjects[0].LastRow-1, 3) = "N";
    	 
    	 sheetObjects[0].SumText(0, 2)= sheetObjects[0].RowCount;
    	 sheetObjects[1].SumText(0, 2)= sheetObjects[1].RowCount;
     }

     function sheet1__OnDblClick(sheetObj, Row, Col){    	 
    	 if(ComIsBtnEnable("btn_Save")){
    		 sheet1_OnDblClick(sheetObj, Row, Col);
    	 }
     }
     
     function sheet2__OnDblClick(sheetObj, Row, Col){
    	 if(ComIsBtnEnable("btn_Save")){
    		 sheet2_OnDblClick(sheetObj, Row, Col);
    	 }
     }
     
 	 function sheet1__OnSearchEnd(sheetObj, ErrMsg)
 	 {
 		with(sheetObj)
 		{
 	 		sheetObj.SumText(0, 2)= sheetObj.RowCount;
 			//CellAlign(LastRow, "Lanes") = daRight;
 		}
 	}
 		
 		
 	function sheet2__OnSearchEnd(sheetObj, ErrMsg)
 	{

 		with(sheetObj)
 		{
 	 		sheetObj.SumText(0, 2)= sheetObj.RowCount;
 		}
 	}

 		
	/* 개발자 작업  끝 */