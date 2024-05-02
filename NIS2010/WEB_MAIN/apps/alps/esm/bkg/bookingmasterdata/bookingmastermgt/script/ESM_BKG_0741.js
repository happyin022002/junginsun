/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0741.js
*@FileTitle : booking master data
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.16 강동윤
* 1.0 Creation
* 2012.10.29 윤태승 [CHM-201220903] [Office Setup] 추가시 로직보완
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
     * @class esm_bkg_0741 : esm_bkg_0741 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0741() {
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
 
 var maxCtrl = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

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
         
         changeOP('doc');

		 initControl();
     }

       /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');          
          axon_event.addListener('keypress', 'obj_keypress', 'ofc_cd_0');
          axon_event.addListener('keypress', 'obj_keypress', 'ofc_cd_1');
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
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

 					case "sheet1":
 							with (sheetObj) {
 								
 								// 높이 설정
 								style.height = 125;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;

 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msNone;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;

 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(1, 1, 3, 100);
 								
 								var HeadTitle1 = "|Sel.|Seq.|B.OFC|POR|GSO|SUB GRP|SUB GSO|Use_Flag|Region";

 								var headCount = ComCountHeadTitle(HeadTitle1);

 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(11, 0, 0, true);

 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);

 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtDelCheck,		40,		daCenter,		true,		"Del",				false,		"",		dfNone,					0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtSeq,			40,		daCenter,		true,		"Seq",				false,		"",		dfNone,					0,		true,	true); 								
 								InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"bkg_ofc_cd",		false,		"",		dfNone,					0,		false,	true);
 								InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"por_cd",		    false,		"",		dfNone,					0,		false,	true, 5);
 								InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"gso_ofc_cd",		false,		"",		dfNone,					0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"sub_grp_ctnt",		false,		"",		dfNone,					0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"sub_gso_ofc_cd",	false,		"",		dfNone,					0,		true,	true);	
 								InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"use_flg",		    false,		"",		dfNone,					0,		true,	true, 1);
 								InitDataProperty(0,		cnt++ , dtData,			90,		daCenter,		true,		"rgn_ofc_cd",		false,		"",		dfNone,					0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtHidden,		10,		daCenter,		true,		"chk_op");
 								
 								CountPosition = 0; 								
 								
 								InitDataValid(0, 	3, vtEngUpOther,"");
 								InitDataValid(0, 	4, vtEngUpOther,"*");
 								InitDataValid(0, 	5, vtEngUpOther,"");
 								InitDataValid(0, 	6, vtEngUpOther,"");
 								InitDataValid(0, 	7, vtEngUpOther,"");
 								InitDataValid(0, 	8, vtEngUpOther,"");
 								InitDataValid(0, 	9, vtEngUpOther,"");
 								
 						}
 						break;
 					case "sheet2":
							with (sheetObj) {
								
								// 높이 설정
								style.height = 125;
								//전체 너비 설정
								SheetWidth = mainTable.clientWidth;

								//Host정보 설정[필수][HostIp, Port, PagePath]
								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

								//전체Merge 종류 [선택, Default msNone]
								MergeSheet = msNone;
								
								//전체Edit 허용 여부 [선택, Default false]
								Editable = true;

								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 3, 100);

								var HeadTitle1 = "|Sel.|Seq.|H.OFC|GSO|Region|S/I Notification|BKG Notification|Controlled OFC";
								
								for (var i = 0 ; i < 30 ; i++){
									
									HeadTitle1 += "|Controlled OFC";
								}

								var headCount = ComCountHeadTitle(HeadTitle1);

								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
								InitColumnInfo(headCount+1, 0, 0, true);

								// 해더에서 처리할 수 있는 각종 기능을 설정한다
								InitHeadMode(true, true, false, true, false,false);

								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
								InitHeadRow(0, HeadTitle1, true);
								
								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtHiddenStatus,			10,		daCenter,		true,		"ibflag");
								InitDataProperty(0,		cnt++ , dtDelCheck,				40,		daCenter,		true,		"Del",				false,		"",		dfNone,					0,		true,	true);
								InitDataProperty(0,		cnt++ , dtSeq,					40,		daCenter,		true,		"Seq",				false,		"",		dfNone,					0,		true,	true);
								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"hndl_ofc_cd",		false,		"",		dfNone,					0,		false,	true);	
								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"gso_ofc_cd",		false,		"",		dfNone,					0,		true,	true);
								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"rgn_ofc_cd",		false,		"",		dfNone,					0,		true,	true);
								InitDataProperty(0,		cnt++ , dtData,					200,	daCenter,		true,		"si_ntfc_eml",		false,		"",		dfNone,					0,		true,	true);
								InitDataProperty(0,		cnt++ , dtData,					200,	daCenter,		true,		"bkg_ntfc_eml",		false,		"",		dfNone,					0,		true,	true);
								
								InitDataProperty(0,		cnt++ , dtHidden,				90,		daCenter,		true,		"ctrl_ofc_cd",		false,		"",		dfNone,					0,		true,	true);								
								
								for (var i = 0 ; i < 30 ; i++){
									
									InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"ctrl_ofc_cd_" + i,		false,		"",		dfNone,					0,		true,	true);
									
									InitDataValid(0, 	9+i, vtEngUpOther,"");
								}
								
								InitDataProperty(0,		cnt++ , dtHidden,				10,		daCenter,		true,		"chk_op");
								
								CountPosition = 0; 								
								
								InitDataValid(0, 	3, vtEngUpOther,"");
								InitDataValid(0, 	4, vtEngUpOther,"");
								InitDataValid(0, 	5, vtEngUpOther,"");
																
						}
						break;

 			}
 	}
      
      
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
  							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  						break;
  						
  						case "btn_save":
  							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
  						break;
  						
  						case "btn_close":
  							window.close();
  						break;
  						
  						case "btn_delete":
  							
  							if (document.form.cho_page[1].checked == true){ 
  							
  								doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
  							}else{
  								
  								doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
  							}
  						break;
  						
  						case "btn_add":
  							
  							 addRow();
  						break;
  						
  						case "btn_excel":
  							 if (document.form.cho_page[1].checked == true){ 
 					    		 
  								 sheetObjects[1].SpeedDown2Excel(-1);
 					    	 }else{
 					    		 
 					    		 sheetObjects[0].SpeedDown2Excel(-1);
 					    	 }
  							
  						break;
  						
  						case "btn_celladd":
  							addCell();
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
      
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
 						if(!validateForm(sheetObj,formObj,sAction)) return; 						 					
 					 	
 						formObj.f_cmd.value = SEARCH; 
 						
 						sheetObj.WaitImageVisible = false;
 						ComOpenWait(true);
 						
 						searchXml = sheetObj.GetSearchXml("ESM_BKG_0741GS.do" , FormQueryString(formObj)); 						 					
 						
 						if (formObj.cho_page[1].checked == true){ 

 							maxCtrl = ComGetEtcData(searchXml,"maxCtrl");
 							
 							sheetObjects[1].Redraw = false;
 							
 							for (var i = 0 ; i < maxCtrl ; i++){
 								
 								sheetObjects[1].ColHidden(9+i) 	= false;
 							} 							 						
 							
 							sheetObjects[1].Redraw = true;
 							
 							sheetObjects[1].LoadSaveXml(searchXml);
 							
 							for (var i = 1 ; i < sheetObjects[1].RowCount+1 ; i++){
 								
 								var tempCtrl = sheetObjects[1].CellValue(i,8).split(",");
 								
 								for (var j = 0 ; j < tempCtrl.length ; j++){
 									
 									sheetObjects[1].CellValue2(i,9+j) = tempCtrl[j]
 								}
 								
 								sheetObjects[1].CellValue2(i,8) = '';
 								sheetObjects[1].CellValue2(i,"chk_op") = 'B:0';
 								
 								sheetObjects[1].RowStatus(i) = "";
 								
 							}
 						}else{
 							
 							sheetObjects[0].LoadSaveXml(searchXml);
 						}
 						
 					break;
 					
 					case IBSAVE:        //저장				 						
 						if (formObj.cho_page[0].checked == true){ 
 							
// 							if(!chkDuplicate()){ 
// 								return;	 
// 							}
 							
 		 					  for(var i=1; i<=sheetObjects[0].RowCount; i++){
 		  						
 		 						if( sheetObj.CellValue(i,"bkg_ofc_cd")=="" ||sheetObj.CellValue(i,"bkg_ofc_cd")=="*"){
 		  							ComShowCodeMessage("BKG01101","B.OFC");
 		  						  return false;
 		  						}
 		 						  
 		 						  if( (sheetObj.CellValue(i,"bkg_ofc_cd")=="" && sheetObj.CellValue(i,"por_cd")=="" )||(sheetObj.CellValue(i,"bkg_ofc_cd")=="*" && sheetObj.CellValue(i,"por_cd")=="*" )){
 		  							ComShowCodeMessage("BKG06113","B.OFC","POR");
 		  							//ComShowCodeMessage('BKG03056',"B.OFC: " + bkg_ofc_cd + ", POR: " + por_cd);
 		  						  return false;
 		  						}
 		 						   		  					  
 		 				}
 		 					  
 		 					sheetObj.WaitImageVisible = false;
 	 						ComOpenWait(true);
 	 						
 							sheetObj = sheetObjects[0];
 							
 							for (var i = 1 ; i < sheetObj.RowCount+1 ; i++){
 								
 								sheetObj.CellValue2(i,"chk_op") = '';
 								
 								if (sheetObj.CellValue(i,0) == "I" || sheetObj.CellValue(i,0) == "U"){
 									
 									if (formObj.cho_ofc_1[0].checked == true){
 					 					
 										sheetObj.CellValue2(i,"chk_op") = 'A:0'; 
 						 			}else if (formObj.cho_ofc_1[1].checked == true){
 						 					
 						 				sheetObj.CellValue2(i,"chk_op") = 'A:1'; 
 						 			}else if (formObj.cho_ofc_1[2].checked == true){
 						 					
 						 				sheetObj.CellValue2(i,"chk_op") = 'A:2'; 
 						 			}else if (formObj.cho_ofc_1[3].checked == true){
 						 					
 						 				sheetObj.CellValue2(i,"chk_op") = 'A:3'; 
 						 			}
 								}else if (sheetObj.CellValue(i,0) == "D"){
 									
 									sheetObj.CellValue2(i,"chk_op") = 'A:0'; 
 								}
 							} 		
 						}else{
 							
 							sheetObj = sheetObjects[1];
 							
 							for (var i = 1 ; i < sheetObj.RowCount+1 ; i++){
 								
 								if (sheetObj.CellValue(i,0) == "I" || sheetObj.CellValue(i,0) == "U"){
 									
 									for (var j = 0 ; j < 30 ; j++){
 										
 										if (sheetObj.CellValue(i,9+j) != ''){
 											
 											sheetObj.CellValue2(i,8) = sheetObj.CellValue(i,8) + ":" + sheetObj.CellValue(i,9+j);
 											
 										}
 									}
 								}
 							} 							
 						}
 					
 						formObj.f_cmd.value = MULTI;   

 						var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("");
	                    
 		                sheetObj.DoSave("ESM_BKG_0741GS.do", sParam);
 		                
 		                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		                
 					break;
 					
 					case IBDELETE:      // 삭제
 						
 						ComRowHideDelete(sheetObj, "Del");
 					
 					break;
 					
         }
         
         ComOpenWait(false);
     }

     /**
      * option change
      */
   	 function changeOP(type){
    	  
   		 if (type == 'doc'){
   			
   			document.getElementById('office_0').style.display = 'none';
   			document.getElementById('office_1').style.display = 'block';
   			
   			document.form.cho_ofc_1[0].checked = true;   			
   			 
   			sheetObjects[1].removeAll();
   			
   			// 높이 설정
   			sheetObjects[0].style.height = 125;
   			sheetObjects[1].style.height = 0;
			//전체 너비 설정
			sheetObjects[0].SheetWidth = mainTable.clientWidth;
			sheetObjects[1].SheetWidth = 0;
		
			ComBtnDisable("btn_celladd");
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			
			document.form.ofc_cd_1.focus();
   		 }else{
   			 
   			document.getElementById('office_0').style.display = 'block';
   			document.getElementById('office_1').style.display = 'none';
   			
   			document.form.cho_ofc_0[0].checked = true;  	   			
   			
   			sheetObjects[1].Redraw = false;
   			
   			for (var i = 0 ; i < 31 ; i++){
   				
   				sheetObjects[1].ColHidden(8+i) 	= true;
   			}
   			
   			sheetObjects[1].Redraw = true;
   			
   			sheetObjects[0].removeAll();
   			
   			// 높이 설정
   			sheetObjects[0].style.height = 0;
   			sheetObjects[1].style.height = 125;
			//전체 너비 설정
			sheetObjects[0].SheetWidth = 0;
			sheetObjects[1].SheetWidth = mainTable.clientWidth;
			
			ComBtnEnable("btn_celladd");
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   		
	   		document.form.ofc_cd_0.focus();
	   		
   		 }   		    		
   	 }
      

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
        
    	 if (!ComChkValid(formObj)) return false;
    	 
    	 if (formObj.cho_page[1].checked == true){ 							 						
				
 			if (formObj.cho_ofc_0[0].checked == true){
 					
 				formObj.chk_op.value = 'B:0'; 
 			}else if (formObj.cho_ofc_0[1].checked == true){
 					
 				formObj.chk_op.value = 'B:1'; 
 			}else if (formObj.cho_ofc_0[2].checked == true){
 					
 				formObj.chk_op.value = 'B:2'; 
 			}else if (formObj.cho_ofc_0[3].checked == true){
 					
 				formObj.chk_op.value = 'B:3'; 
 			}
 				
 			formObj.ofc_cd.value = formObj.ofc_cd_0.value; 	
 				
 				
 		}else{
 				
 			if (formObj.cho_ofc_1[0].checked == true){
 					
 				formObj.chk_op.value = 'A:0'; 
 			}else if (formObj.cho_ofc_1[1].checked == true){
 					
 				formObj.chk_op.value = 'A:1'; 
 			}else if (formObj.cho_ofc_1[2].checked == true){
 					
 				formObj.chk_op.value = 'A:2'; 
 			}else if (formObj.cho_ofc_1[3].checked == true){
 					
 				formObj.chk_op.value = 'A:3'; 
 			}
 				
 			formObj.ofc_cd.value = formObj.ofc_cd_1.value; 							 						
 		}
    	 
         return true;
     }
     
      /**
       * 셀변경후  이벤트 처리 >>> ID체크
       */ 
     function sheet1_OnChange(sheetObj, Row, Col, Value) {
      	       	   
    	   with (sheetObj) {
    		   
    		 var formObj = document.form;
    		 
      		 if (Col == 3 ||Col == 5|| Col == 9){
      			 
      			 formObj.ofc_cd.value = CellValue(Row,Col);
      			 
      			 if (formObj.ofc_cd.value != ''){
      				 
      				 formObj.ofc_ty.value = Col;
	      			 formObj.f_cmd.value 	= SEARCH01; 
	      			
	      			 var sParam = FormQueryString(formObj);
	
	        	     var sXml = sheetObj.GetSaveXml("ESM_BKG_0741GS.do", sParam);
	        	     
	        	     if (ComGetEtcData(sXml,"check") == "N"){
	        	    	 
	        	    	 ComShowCodeMessage("BKG01107");//사용가능한 Office Code가 아닙니다.
	        	    	 
	        	    	 SelectCell(Row, Col, true, '');
	        	    	 
		        	 } 
	        	     
	        	     
      			 }
 
      		 }
      		 
      		if(Col == 4){
                formObj.por_cd.value = CellValue(Row,Col);
                
                if(sheetObj.CellValue(Row,"por_cd").substr(0,2) != "JP" && sheetObj.CellValue(Row,"por_cd")!= "" && sheetObj.CellValue(Row,"por_cd")!= "*" ){
                      ComShowCodeMessage("BKG04025");//You can only input the POR as Japan port
                      SelectCell(Row, Col, true, ''); 
                }
                 
           }
           
           
          /*
           * bkg_ofc_cd 가 null 아니고 그리고 por_cd 가  null 이 아닐 경우 validation 체크
           */
                  if( sheetObj.CellValue(Row,"bkg_ofc_cd") != "" && sheetObj.CellValue(Row,"por_cd") != "" ) {
                        checkDup(sheetObj, Row, Col, Value);
                  }


      	 }
     }  
     
     
     function checkDup(sheetObj, Row, Col, Value) {
         var formObj = document.form;
         formObj.f_cmd.value          = SEARCH02; 
         formObj.bkg_ofc_cd.value     = sheetObj.CellValue(Row,"bkg_ofc_cd"); 
         formObj.por_cd.value         = sheetObj.CellValue(Row,"por_cd"); 
                    
              var sParam = FormQueryString(formObj);

              /*
               * DB에 동일한 B.OFC + POR 이 있는지 쿼리 수행한 결과를 확인 한다.
               */
             var sXml = sheetObj.GetSaveXml("ESM_BKG_0741GS.do", sParam);
             if(ComGetEtcData(sXml,"checkBofcPOR") == "Y") {
                     //B.OFC + POR 존재하고 있는것
                    ComShowCodeMessage('BKG03056',"B.OFC: " + formObj.bkg_ofc_cd.value + ", POR: " + formObj.por_cd.value);//POR is duplicated
                    SelectCell(Row, Col, true, ''); 
               }
             
             /*
              * check sheet dup
              */
             var checkValue = formObj.bkg_ofc_cd.value + formObj.por_cd.value;
             var cnt = sheetObj.RowCount;
   
                     for( var j = 1; j <= cnt; j++){
                           
                           checkValueJ = sheetObj.CellValue(j,"bkg_ofc_cd") + sheetObj.CellValue(j,"por_cd");
                           
                          if(Row != j && checkValue == checkValueJ){
                               
                          ComShowCodeMessage('BKG03056',"B.OFC: " + formObj.bkg_ofc_cd.value + ", POR: " + formObj.por_cd.value);
                           sheetObj.SelectCell(Row, Col);  
                          sheetObj.CellValue2(Row,Col)="";
                           return false ;
                          }
                     }
              
       }

       
       /**
        * 셀변경후  이벤트 처리 >>> ID체크
        */ 
      function sheet2_OnChange(sheetObj, Row, Col, Value) {
       	      	   
     	   with (sheetObj) {
     		   
     		 var formObj = document.form;

       		 if (Col != 0 && Col != 1 && Col != 2 && Col != 6 && Col != 7){
       			 
       			 formObj.ofc_cd.value = CellValue(Row,Col);

       			 if (formObj.ofc_cd.value != ''){

	       			 formObj.ofc_ty.value = Col;
	       			       			
	       			 formObj.f_cmd.value 	= SEARCH01; 
	       			 
	       			 var sParam = FormQueryString(formObj);    
	       			 
	         	     var sXml = sheetObj.GetSaveXml("ESM_BKG_0741GS.do", sParam);
	         	     
	         	     if (ComGetEtcData(sXml,"check") == "N"){
	         	    	 
	         	    	ComShowCodeMessage("BKG01107");//사용가능한 Office Code가 아닙니다.
	         	    	 
	         	    	 SelectCell(Row, Col, true, ''); 
	  		         }else{
	  		        	 
	  		        	 if (Col != 3 && Col != 4 && Col != 5){
	  		        		 
	  		        		 for (var i = 0 ; i < 30 ; i++){
	  		        			 
	  		        			 if (Col != 9+i){
	  		        				 
		  		        			 if (CellValue(Row,Col) == CellValue(Row,9+i)){
		  		        				 
		  		        				 ComShowCodeMessage("BKG04024");
		  		        				 SelectCell(Row, Col, true, ''); 
		  		        				 
		  		        				 break;
		  		        			 }
	  		        			 }
	  		        		 }
	  		        	 }else if (Col == 3){
	  		        		 
	  		        		if (ComGetEtcData(sXml,"chkOFC") == "N"){
	  		        			
	  		        			ComShowCodeMessage("BKG04024");//Office already exist
 		        				SelectCell(Row, Col, true, ''); 
	  		        		}
	  		        	 }
	  		         }
       			 }
       		 }
       	 }
      }  
     
       /**
        * 로우추가이벤트 처리 
        */  
     function addRow(){
    	 
    	 if (document.form.cho_page[1].checked == true){ 
		     
    		 sheetObjects[1].DataInsert(-1);
    		 sheetObjects[1].SelectCell(sheetObjects[1].SelectRow, 3, true, ''); 
    	 }else{
    		 
    		 sheetObjects[0].DataInsert(-1);
    		 sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, 3, true, ''); 
    	 }
     }
       /**
        * 셀추가이벤트 처리 >>> Controlled OFC 추가
        */       
     function addCell(){    	     	
    	 
         maxCtrl++;	
        	
    	 sheetObjects[1].Redraw = false;			
			
		 sheetObjects[1].ColHidden(9+maxCtrl) = false;
			
		 sheetObjects[1].Redraw = true;		 
		 
		 sheetObjects[1].SelectCell(sheetObjects[1].SelectRow, 9+maxCtrl, true, ''); 
     }


        /**
         * 시트를 클릭했을 때 처리
         */
        function sheet2_OnClick(sheetObj, row, col) {
        	var rowCnt = sheetObj.RowCount;
        	var colSaveName = sheetObj.ColSaveName(col);

        	/* Row Focus 색상 및 글자  기본값으로 변경 */
        	sheetObj.SelectFontBold  = false;
        	sheetObj.SelectBackColor = "16186087";
        	
        	switch(colSaveName) {
        		/* 긴 문자열 MemoPad 처리*/
        		case "si_ntfc_eml" :
        			
        			sheetObj.CellEditable(row, col) = false;
        			ComShowMemoPad(sheetObj, sheetObjects[1].SelectRow, null, false, 400, 100);
        			sheetObj.CellEditable(row, col) = true;

        			break;
                case "bkg_ntfc_eml" :
        			
        			sheetObj.CellEditable(row, col) = false;
        			ComShowMemoPad(sheetObj, sheetObjects[1].SelectRow, null, false, 400, 100);
        			sheetObj.CellEditable(row, col) = true;
        			
        			break;
        			
        	} // end switch

        }
         
         function chkDuplicate(){
        	 var formObj = document.form;
        	 var cnt = sheetObjects[0].RowCount;
        	 var sheetObj = sheetObjects[0];
        	 for (var ix = 1; ix <= cnt; ix++ ){
        	 
        		 var bkg_ofc_cd = sheetObj.CellValue(ix,"bkg_ofc_cd");
        		 var por_cd = sheetObj.CellValue(ix,"por_cd");
        		 
        		 if(sheetObj.CellValue(ix,"bkg_ofc_cd")==""){
        			 sheetObj.CellValue2(ix,"bkg_ofc_cd") = "*"
        		 }
        		 if(sheetObj.CellValue(ix,"por_cd")==""){
        			 sheetObj.CellValue2(ix,"por_cd") = "*"
        		 }
        		         		 
        		
        		 var ofc_cd = bkg_ofc_cd + sheetObj.CellValue(ix,"por_cd");
        			
        			
        		  if (sheetObj.RowStatus(ix) == "I" || sheetObj.RowStatus(ix) == "U"){
    	    		 for( var j = 1; j <= cnt; j++){
    	    		 	var bkg_ofc_cd2 = sheetObj.CellValue(j,"bkg_ofc_cd");
        		 		var por_cd2 = sheetObj.CellValue(j,"por_cd");
        		 		var ofc_cd2 = bkg_ofc_cd2 + por_cd2;
    		 			
        		 		if(ix != j && ofc_cd == ofc_cd2){
        		 			ComShowCodeMessage('BKG03056',"B.OFC: " + bkg_ofc_cd + ", POR: " + por_cd);
    	    			 	 sheetObj.SelectCell(ix, "bkg_ofc_cd");  
    	    			 	sheetObj.CellValue2(ix,"bkg_ofc_cd")="";
    	    			 	sheetObj.CellValue2(ix,"por_cd")="";
    	    			 	 return false ;
        		 		}
    	    		 }
        		 }
        		 
        	 }
        	 return true;
         }

	/* 개발자 작업  끝 */