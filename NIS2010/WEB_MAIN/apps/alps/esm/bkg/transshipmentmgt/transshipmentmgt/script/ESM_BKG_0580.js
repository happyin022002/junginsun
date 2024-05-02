/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0580.js
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
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
     * @class esm_bkg_0580 : esm_bkg_0580 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0580() {
    	
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
 
 var prefix1="sheet1_";
 var prefix2="sheet2_";

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];
          var sheetObject1 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name"); 
             switch(srcName) {

 					case "btn_retrieve":
						doActionIBSheet(sheetObject,document.form,IBSEARCH);
                     break;

 					case "btn_new":
 						doActionIBSheet(sheetObject,document.form,IBCLEAR);
                     break;

 					case "btn_save": 
						var iCheck=0;
						for(var i=0;i<sheetObject.RowCount;i++){ 
							
							if (sheetObject.RowStatus(i+1)=="I" || sheetObject.RowStatus(i+1)=="U"){ 
								sheetObject.CellValue(i+1,prefix1+"yd_cd") =formObject.vps_port_cd.value+sheetObject.CellValue(i+1,prefix1+"ydcd");
								iCheck++;
							}   
						}
						
						if (iCheck==0){
							ComShowCodeMessage("BKG00233");
						}else{ 
 							doActionIBSheet(sheetObject,document.form,IBSAVE);
						}
                     break;

 					case "btn_saveAs":
 						doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
                     break; 
 					case "btn_yardPaste":
						if(sheetObject.RowCount>0){
						    for(var i=0;i<sheetObject.RowCount;i++){
								if(sheetObject.CellValue(i+1,prefix1+"del_chk")==1&&sheetObject1.CheckedRows(prefix2+"del_chk")==1){ 
									sheetObject.CellValue(i+1,prefix1+"yd_cd")=sheetObject1.CellValue(sheetObject1.SelectRow,prefix2+"yd_cd");
									sheetObject.CellValue(i+1,prefix1+"ydcd")=sheetObject1.CellValue(sheetObject1.SelectRow,prefix2+"yd_cd").substring(5);
								}
							}
						}else{
							 ComShowCodeMessage("BKG00155");
						} 
                     break;  					     
 					case "btns_calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.vps_etb_dt, formObject.vps_etd_dt,'yyyy-MM-dd');
	 					
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

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
              
           //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
         }
          
         initDate(document.form);
         axon_event.addListenerFormat('keypress','bkg0580_keypress',document.form); 
		 axon_event.addListenerForm  ('beforedeactivate', 'bkg0580_obj_deactivate',  document.form); //- 포커스 나갈때
	     axon_event.addListenerFormat('beforeactivate',   'bkg0580_obj_activate',    document.form); //- 포커스 들어갈때
  
     }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

 		switch(sheetNo) {
 			case 1:      //sheet1 init
 				with (sheetObj) {

                     // 높이 설정
                     style.height = 360;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 14, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle1 = "|Sel.|VVD|Lane|ETB|Yard|CRN (Ship Call No.)|UVI No.";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix1+"ibflag");
						InitDataProperty(0, cnt++ , dtDummyCheck,					30,		daCenter,	false,		prefix1+"del_chk",				false,			"",      dfNone,			0,		true,		true);
 						
 						InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix1+"vvd",				false,			"",      dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"lane",				false,			"",      dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,					85,		daCenter,	false,		prefix1+"etb",				false,			"",      dfNone,			0,		false,		false);
 						InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"ydcd",				false,			"",      dfEngUpKey,			0,		true,		true, 7);
 						InitDataProperty(0, cnt++ , dtData,					140,		daCenter,	false,		prefix1+"cvy_ref_no",				false,			"",      dfEngUpKey,			0,		true,		true, 20);
 						InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		prefix1+"uq_vsl_id_no",				false,			"",      dfEngUpKey,			0,		true,		true, 20);
						
						InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,		false,		prefix1+"vsl_cd");
						InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,		false,		prefix1+"skd_voy_no");
						InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,		false,		prefix1+"skd_dir_cd");
						InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,		false,		prefix1+"skd_call_seq");
						InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,		false,		prefix1+"clpt_cd");
						InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,		false,		prefix1+"yd_cd");
					
					// Sheet1에 7행 숫자만 입력가능
					InitDataValid(0,prefix1+"uq_vsl_id_no",vtEngOther,"1234567890");
					EnterBehavior = "tab";
 				}
 				break;
 				
 			case 2:      //sheet1 init
 				with (sheetObj) {

                     // 높이 설정
                     style.height = 360;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 14, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(4, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle1 = "|Sel.|Yard CD|Full Name";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0, cnt++ , dtHiddenStatus,	10,		daCenter,		false,		prefix2+"ibflag");
						InitDataProperty(0, cnt++ , dtRadioCheck,					30,		daCenter,			false,		prefix2+"del_chk",				false,			"",      dfNone,			0,		true,		true);
 						
 						InitDataProperty(0, cnt++ , dtData,					130,		daCenter,			false,		prefix2+"yd_cd",				false,			"",      dfNone,			0,		false,		true);
 						InitDataProperty(0, cnt++ , dtData,					110,		daLeft,			false,		prefix2+"yd_nm",		false,			"",      dfNone,			0,		false,		true);


 				}
 				break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         var arrPreFix = new Array("sheet1_","sheet2_");
         switch(sAction) {

 			case IBSEARCH:      //조회 
 				if(validateForm(sheetObj,formObj,sAction)){ 
 					formObj.f_cmd.value = SEARCH;
 			        
 			        if (!ComIsEmpty(formObj.vps_oher_port_cd.value)){
 			        	formObj.vps_port_cds.value=formObj.vps_port_cd.value+"|"+formObj.vps_oher_port_cd.value;
 			        }else{
					}   formObj.vps_port_cds.value=formObj.vps_port_cd.value;
 			        
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0580GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
					var arrXml = sXml.split("|$$|");
					
					for(var i = 0; i < arrXml.length; i++){ 
						sheetObjects[i].Redraw = false;    
						if(i > 0) {
							sheetObjects[i].WaitImageVisible = false;	
						}  
						sheetObjects[i].LoadSearchXml(arrXml[i]); 
						sheetObjects[i].Redraw = true; 
					} 
				}
				break;
	 		case IBSAVE:        //저장 
		 		if(validateForm(sheetObj,formObj,sAction)) {
		 			formObj.f_cmd.value = MULTI; 
					var sParam = ComGetSaveString(sheetObjects);
				    if (sParam == "") return;  
				    sParam += "&" + FormQueryString(formObj);
				    var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0580GS.do", sParam);
				    sheetObjects[0].LoadSaveXml(sXml);     
		 		}
	 			break;

			case IBCLEAR:      // 초기화 
			    ComClearObject(formObj.vps_port_cd);
				ComClearObject(formObj.vps_oher_port_cd);
				ComClearObject(formObj.crr_cd);
				ComClearObject(formObj.vvd);
				ComClearObject(formObj.lane);
				formObj.vps_etb_dt.value=ComGetNowInfo();
				formObj.vps_etd_dt.value=ComGetNowInfo();

				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
            	break;
			
			case IBDOWNEXCEL:      // 엑셀다운
				sheetObjects[0].SpeedDown2Excel();
	        	break; 
         }
     }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
	       	if (ComChkLen(vps_port_cd,5)!=2){ 
	       		ComShowCodeMessage("BKG00655");
				return false;
	       	}
        	switch (sAction) {
        		case IBSEARCH: {
					if (ComGetDaysBetween(vps_etb_dt.value, vps_etd_dt.value) > 30) {
						ComShowCodeMessage("BKG00756", "Duration", "30Days");
						vps_etb_dt.focus();
						return false;
					}
        			break;
        		}
        	}
        }
        return true;
    }

     /**
      *  화면 날짜 입력폼 초기화 처리
      */
     function initDate(formObj){
    	 with(formObj){
    		 vps_etb_dt.value=ComGetNowInfo();
    		 vps_etd_dt.value=ComGetNowInfo();
    	 }
     }
     /**
	 * Sheet1에 대한 OnChange 이벤트 처리
	 */ 
	 function sheet1_OnChange(sheetObject,Row,Col,Value){ 
		 if (Col ==6 || Col ==7){
			 if (ComChkLen(sheetObject.CellValue(Row,prefix1+"cvy_ref_no"),20) !=2){
				sheetObject.SelectCell(Row,prefix1+"cvy_ref_no");
			}
			if (ComChkLen(sheetObject.CellValue(Row,prefix1+"uq_vsl_id_no"),20) !=2){
				sheetObject.SelectCell(Row,prefix1+"uq_vsl_id_no"); 
			}
		 } 
	 }  

	 /*
	 * KeyPress Event 처리
	 */
    function bkg0580_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum');
	            break; 
	    }
	}    

	/*
	 * Activate Event 처리
	 */
	function bkg0580_obj_activate(){
    	//입력Validation 확인하기
    	switch(event.srcElement.name){
    	
	    	case "vps_etb_dt":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "vps_etd_dt":
	    		ComClearSeparator(event.srcElement);
    			break; 
    		default:
    			break;
    			 
    	}
    }
	
	/*
	 * Deactivate Event 처리
	 */
    function bkg0580_obj_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "vps_etb_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "vps_etd_dt":
	    		ComAddSeparator(event.srcElement);
    			break;  
    		default:
    			break; 
    	}
    }

	 

	/* 개발자 작업  끝 */