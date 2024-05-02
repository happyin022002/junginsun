/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0754.js
*@FileTitle : Special Cargo Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.19 이병규
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
     * @class esm_bkg_0754 : esm_bkg_0754 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0754() {
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
 var opener = window.dialogArguments; 

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
 							
 						case "btn_select":
 							
 							var chkRow = sheetObjects[0].FindText("Chk", "1", 0, 2); 	
 							
 							if(opener.document.getElementById("title_id").value =="awk"){
 								opener.document.getElementById("frm_cntr_cgo_seq").value = sheetObjects[0].CellValue(chkRow, "dg_cntr_seq");
 								opener.sheetObjects[1].CellValue2(opener.sheetObjects[1].SelectRow, "awk_dcgo_seq") = sheetObjects[0].CellValue(chkRow, "dg_cntr_seq");
 								opener.sheetObjects[1].CellValue2(opener.sheetObjects[1].SelectRow, "cntr_cgo_seq") = sheetObjects[0].CellValue(chkRow, "cntr_cgo_seq");
 							}
 							if(opener.document.getElementById("title_id").value =="rf"){
 								opener.document.getElementById("rf_dcgo_seq").value = sheetObjects[0].CellValue(chkRow, "dg_cntr_seq");
 								opener.sheetObjects[1].CellValue2(opener.sheetObjects[1].SelectRow, "rf_dcgo_seq") = sheetObjects[0].CellValue(chkRow, "dg_cntr_seq");
 								opener.sheetObjects[1].CellValue2(opener.sheetObjects[1].SelectRow, "cntr_cgo_seq") = sheetObjects[0].CellValue(chkRow, "cntr_cgo_seq");
 							}
 							if(opener.document.getElementById("title_id").value =="bb"){
 								opener.document.getElementById("bb_dcgo_seq").value = sheetObjects[0].CellValue(chkRow, "dg_cntr_seq");
 								opener.sheetObjects[2].CellValue2(opener.sheetObjects[2].SelectRow, "bb_dcgo_seq") = sheetObjects[0].CellValue(chkRow, "dg_cntr_seq");
 								opener.sheetObjects[2].CellValue2(opener.sheetObjects[2].SelectRow, "cntr_cgo_seq") = sheetObjects[0].CellValue(chkRow, "cntr_cgo_seq"); 								
 							}
 							
 							
 							window.close();
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
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        
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
 								style.height = 159;
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
 								
 								var HeadTitle1 = "|||Container|Container|Container|Cargo Seq|UN No|Class|DG Package Description|CGO Status|M Poll|Pack Grp||||";
 								
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtHidden,				20,		daCenter,		true,		"merge_dg_cntr_seq",	false,		"",		dfNone,			0,		true,	false);
 								InitDataProperty(0,		cnt++ , dtCheckBox,				35,		daCenterTop,	true,		"Chk");
 								InitDataProperty(0,		cnt++ , dtData,					20,		daCenterTop,	true,		"dg_cntr_seq",			false,		"",		dfNone,			0,		true,	false);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daCenterTop,	true,		"cntr_no",				false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					25,		daCenterTop,	true,		"cntr_tpsz_cd",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		false,		"cntr_cgo_seq",			false,		"",		dfNone,			0,		false,	false);

 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		false,		"imdg_un_no",			false,		"",		dfNone,			0,		false,	false); 								
 								InitDataProperty(0,		cnt++ , dtData,					55,		daCenter,		false,		"imdg_clss_cd",			false,		"",		dfNone,			0,		false,	false);

 								InitDataProperty(0,		cnt++ , dtData,					200,	daLeft,			false,		"prp_shp_nm",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					75,		daCenter,		false,		"dcgo_sts_cd",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		false,		"mrn_polut_flg",		false,		"",		dfNone,			0,		false,	false);
 								
 								InitDataProperty(0,		cnt++ , dtData,					75,		daCenter,		false,		"imdg_pck_grp_cd",		false,		"",		dfNone,			0,		false,	false);
 								
 								InitDataProperty(0,		cnt++ , dtHidden,				45,		daCenter,		false,		"imdg_un_no_seq",		false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtHidden,				45,		daCenter,		false,		"dcgo_seq",				false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtHidden,				45,		daCenter,		false,		"cntr_no_temp",			false,		"",		dfNone,			0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtHidden,				45,		daCenter,		false,		"cntr_tpsz_cd_temp",	false,		"",		dfNone,			0,		false,	false);
 								
 								
 						}
 						break;
 						
 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
 					if(validateForm(sheetObj,formObj,sAction)) {
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch("ESM_BKG_0754GS.do", FormQueryString(formObj));     					
    					
    					if(document.getElementById("modalFlg").value != "Y"){
    						
    						sheetObjects[0].ColHidden("Chk") = true;    						
    					}
    					for(var i=1; i <= sheetObj.RowCount; i++){
    						sheetObj.CellValue2(i,"cntr_no_temp") = sheetObj.CellValue(i,"cntr_no");
    						sheetObj.CellValue2(i,"cntr_tpsz_cd_temp") = sheetObj.CellValue(i,"cntr_tpsz_cd");
    						
    						if(sheetObj.CellValue(i,"cntr_cgo_seq") != "1"){
    							
    							sheetObj.CellValue2(i, "cntr_no") = "";
        						sheetObj.CellValue2(i, "cntr_tpsz_cd") = "";
    							
    						}
    						
    						if(opener.document.getElementById("title_id").value =="awk"){
    							if(sheetObj.CellValue(i,"dg_cntr_seq") == opener.document.getElementById("frm_cntr_cgo_seq").value){
        							sheetObj.CellValue2(i,"Chk") = "Y";
        						}
    						}    						
    						if(opener.document.getElementById("title_id").value =="rf"){
    							if(sheetObj.CellValue(i,"dg_cntr_seq") == opener.document.getElementById("rf_dcgo_seq").value){
        							sheetObj.CellValue2(i,"Chk") = "Y";
        						}
    						}
    						if(opener.document.getElementById("title_id").value =="bb"){
    							if(sheetObj.CellValue(i,"dg_cntr_seq") == opener.document.getElementById("bb_dcgo_seq").value){
        							sheetObj.CellValue2(i,"Chk") = "Y";
        						}
    						}
    						
    						
    					}
    				} 													
 					break;
 					
 					case IBSAVE:        //저장
 						if(validateForm(sheetObj,formObj,sAction))
 							
 					
 					break;
 					
 					case IBINSERT:      // 입력
 					break;
                 
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }
         
     /**
      * 시트를 클릭했을 때 처리
      */
     function sheet1_OnClick(sheetObj, row, col) {
     	
     	var rowCnt = sheetObj.RowCount;
         var ifFlag = sheetObj.CellValue(row,"if_flag");
         var Chk = sheetObj.CellValue(row,"Chk");
         var dgCntrSeq = sheetObj.CellValue(row,"dg_cntr_seq");
         var colSaveName = sheetObj.ColSaveName(col);
         switch(colSaveName) {
 	        
 	    	case "Chk" :
 	    		for(i=1; i<=rowCnt; i++) {
 		    		if(Chk == 1) {
 		    			if(i == row) continue;
 		    			if(dgCntrSeq == sheetObj.CellValue(i, "dg_cntr_seq")) {
 		    				sheetObj.CellValue2(i, "Chk") = 0;
 		    			}
 		    		} else if(Chk == 0) {
 		    			if(i == row) continue;
 		    			if(dgCntrSeq == sheetObj.CellValue(i, "dg_cntr_seq")) {
 		    				sheetObj.CellValue2(i, "Chk") = 1;
 		    			}
 		    			else{
 		    				sheetObj.CellValue2(i, "Chk") = 0;
 		    			}
 		    		}
 	    		}
 	    		break;
 	    		
         } // end switch
         
     }

            
/* 개발자 작업  끝 */