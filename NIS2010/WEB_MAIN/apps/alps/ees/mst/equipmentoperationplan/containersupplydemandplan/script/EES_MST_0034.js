/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0034.js
*@FileTitle : Own Container Purchasing Value Trend Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
* ========================================================
* 2010.08.19 : 남궁진호 : CHM-201005431-01
*              Year/Month 항목 비활성화 해제
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
     * @class ees_mst_0034 : ees_mst_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0034() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
		this.sheet1_OnChange        = sheet1_OnChange;    	
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
       	   var sheetObject1 = sheetObjects[0];
          /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
				case "btn_retrieve":
				    if (formObject.bse_yrmon.value.length < 7) {
			    	   ComShowCodeMessage("MST00001","Year/Month");
			    	   ComSetFocus(formObject.bse_yrmon);
			      	   return;
			    	}
				    sheetObjects[1].RemoveAll();
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);				    
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					if (sheetObjects[0].RowCount > 0){
//						formObject.bse_yrmon.disabled = true;   //CHM-201005431-01
						formObject.eq_knd_cd[0].disabled = true;
						formObject.eq_knd_cd[1].disabled = true;
						formObject.eq_knd_cd[2].disabled = true;
					}
					ComBtnEnable_u("btn_save");
			        ComBtnEnable_u("btn_add");
				    ComBtnEnable_u("btn_del");	
				    ComBtnEnable_u("btn_loadexcel");
				    ComBtnEnable_u("btn_downexcel");	
				break;
				
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObjects[1].RemoveAll();
//					formObject.bse_yrmon.disabled = false;         //CHM-201005431-01
					formObject.eq_knd_cd[0].disabled = false;
					formObject.eq_knd_cd[1].disabled = false;
					formObject.eq_knd_cd[2].disabled = false;
					formObject.eq_knd_cd[0].checked;
					formObject.bse_yrmon.value = "";
				    ComBtnDisable_u("btn_save");
					ComBtnDisable_u("btn_add");
					ComBtnDisable_u("btn_del");
					formObject.eq_knd_cd[0].checked = true;
					sheetObject1.HeadCheck(0,"del_chk") = false;
					sheetObject1.HeadCheck(1,"del_chk") = false;
					formObject.bse_yrmon.focus();
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break; 
				
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"1");
				break;
				
				case "btn_loadexcel":
					sheetObject1.RemoveAll();	
					sheetObject1.LoadExcel(true);
				    sheetObjects[1].RemoveAll();
				    
//					formObject.bse_yrmon.disabled = true;   //CHM-201005431-01
					formObject.eq_knd_cd[0].disabled = true;
					formObject.eq_knd_cd[1].disabled = true;
					formObject.eq_knd_cd[2].disabled = true;
					ComBtnEnable_u("btn_save");
			        ComBtnEnable_u("btn_add");
				    ComBtnEnable_u("btn_del");
				    ComBtnEnable_u("btn_downexcel");
				    
					for (var i = 1; i <= sheetObject1.RowCount+1; i++){
					   //sheetObject1.CellValue(i,"ibflag") = "I";
					   sheetObject1.RowStatus(i) = "I";
		               if (sheetObject1.CellValue(i,"eq_tpsz_cd").substring(0, 1) == "R") {
		            	   sheetObject1.CellEditable(i,"pur_ut_prc") = true;
		            	   sheetObject1.MinimumValue (i, "pur_ut_prc") = 1;
		               } else {
		            	   sheetObject1.CellEditable(i,"pur_ut_prc") = false;
		            	   sheetObject1.MinimumValue (i, "pur_ut_prc") = 0;
		               }
		               sheetObject1.CellValue(i,"bse_yrmon") = formObject.bse_yrmon.value;
		               sheetObject1.CellValue2(i,"curr_cd") = "USD";
		 		       for (var j = 0; j < 3; j++){
		 		          if (formObject.eq_knd_cd[j].checked == true)
		 		        	 sheetObject1.CellValue(i,"eq_knd_cd") = formObject.eq_knd_cd[j].value;
		 		       }
		               sheetObject1.MinimumValue (i, "eq_qty") = 1;
		               sheetObject1.MinimumValue (i, "pur_prc") = 1;
		               sheetObject1.MinimumValue (i, "dryg_amt") = 0;
					}
					
					/*for (var i = sheetObject1.LastRow; i > sheetObject1.HeaderRows; i--){
					   if (sheetObject1.CellValue(i,"vndr_abbr_nm") == "" &&
						   sheetObject1.CellValue(i,"vndr_seq") == ""	  &&
						   sheetObject1.CellValue(i,"loc_cd") == ""	      &&
						   sheetObject1.CellValue(i,"eq_tpsz_cd") == ""	  &&
						   sheetObject1.CellValue(i,"eq_qty") == "0"	  &&
						   sheetObject1.CellValue(i,"pur_prc") == "0"	  &&
						   sheetObject1.CellValue(i,"pur_ut_prc") == "0"  &&
						   sheetObject1.CellValue(i,"dryg_amt") == "0"	  &&
						   sheetObject1.CellValue(i,"ttl") == "0"){
						   sheetObject1.RowDelete(i,false);
					   } 
					} */
				break;	
				
				case "btn_add":
					sheetObject1.DataInsert();
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;

				case "btn_del":
   					if(sheetObject1.FindCheckedRow("del_chk")==""){
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")){ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
 	     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	     axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		 axon_event.addListenerFormat('keydown',	      'obj_keydown',	 form); //- 키 눌렸을때
		 axon_event.addListenerFormat('keypress',         'obj_keypress',	 form); //- 키 눌렸을때
		 axon_event.addListenerForm('keydown',	'ComKeyEnter',	    form); //- 키 눌렸을때	
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
	     document.form.bse_yrmon.value = "";
	     ComBtnDisable_u("btn_save");
	     ComBtnDisable_u("btn_add");
	     ComBtnDisable_u("btn_del");
	     // IBSheet내 Combo 초기화
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);	     
	     document.form.bse_yrmon.focus();    	
    }

  	//Axon 이벤트 처리2. 이벤트처리함수
  	function obj_deactivate(){
  	    ComChkObjValid(event.srcElement);
  	}
  	
  	function obj_activate(){
  	    ComClearSeparator(event.srcElement);
  	}
  	
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "ym":
	            if(obj.name=="bse_yrmon") ComKeyOnlyNumber(this, "-");
	            break;
	    }        
	}
 	
 	function obj_keydown() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		if (obj.name == "bse_yrmon") {
	  		if ( vKeyCode == 9 || vKeyCode == 13) {
			    if (formObj.bse_yrmon.value.length < 6) {
			    	   ComShowCodeMessage("MST00001","Year/Month");
			    	   ComSetFocus(formObj.bse_yrmon);
			      	   return;
			    }
			    sheetObjects[1].RemoveAll();
			    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);				    
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//				formObj.bse_yrmon.disabled = true; //CHM-201005431-01
				formObj.eq_knd_cd[0].disabled = true;
				formObj.eq_knd_cd[1].disabled = true;
				formObj.eq_knd_cd[2].disabled = true;
				ComBtnEnable_u("btn_save");
		        ComBtnEnable_u("btn_add");
			    ComBtnEnable_u("btn_del");
			    ComBtnEnable_u("btn_loadexcel");
			    ComBtnEnable_u("btn_downexcel");
	  		}
 		} 
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
                 style.height = 440;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(21, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, false, true, true, false,false);

                 var HeadTitle1 = "||Manufacturer  Name|Manufacturer|Delivery Location|TP/SZ|Q'ty|Price|Price|Price|Price|Price";
                 var HeadTitle2 = "||Manufacturer  Name|Manufacturer|Delivery Location|TP/SZ|Q'ty|Box|Unit|Drayage|G.TTL|Remark";

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);  //vndr_abbr_nm
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 		 30,  daCenter, false, 	  "ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck, 			 40,  daCenter, true,     "del_chk");
                 InitDataProperty(0, cnt++ , dtComboEdit,     		 135, daLeft,   true,     "vndr_abbr_nm",    true,     "",      dfNone, 	0,     false,       true, 6);//
                 InitDataProperty(0, cnt++ , dtData,	 			 115, daLeft,   true,     "vndr_seq",        true,      "",      dfEngUpKey, 	    0,     false,       true, 6);//
                 InitDataProperty(0, cnt++ , dtPopupEdit, 	 		 135, daLeft,   true,     "loc_cd",          true,      "",      dfEngUpKey, 		0,     false,       true, 5);//
                 InitDataProperty(0, cnt++ , dtCombo,    			 95, daCenter,  true,     "eq_tpsz_cd",      true,      "",      dfEngUpKey,		0,     false,       true);//
                 InitDataProperty(0, cnt++ , dtData, 	 			 98, daRight,   true,     "eq_qty",          true,      "",      dfInteger,	    0,     true,       true, 6);//
                 InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "pur_prc",         false,     "",      dfInteger,     0,     true,       true, 6);
                 InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "pur_ut_prc",      false,     "",      dfInteger,     0,     true,       true, 6);
                 InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "dryg_amt",        false,     "",      dfInteger,     0,     true,       true, 6);
                 InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "ttl",             false,     "|pur_prc|+|pur_ut_prc|+|dryg_amt|",      dfInteger,     0,     true,       true);
                 InitDataProperty(0, cnt++ , dtData,     	         100,daCenter,  true,     "diff_rmk",        false,     "",      dfNone,        0,     true,       true);
                 
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "bse_yrmon",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eq_knd_cd",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "curr_cd",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "stl1",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "stl2",       false,     "",      dfNone,        0,     true,       true);                     
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "stl3",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "insflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "updflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "delflg",       false,     "",      dfNone,        0,     true,       true);                     
                 
                 InitDataValid(0, "loc_cd", vtEngUpOther, "1234567890");
                 InitDataValid(0, "vndr_seq", vtNumericOnly); 
                 //InitDataValid(0, "vndr_abbr_nm", vtNumericOnly);
                 SelectFontBold = true;
                 SelectHighLight = false;
                 EditEnterBehavior = "tab";
                 PopupImage  =  "img/btns_search.gif";
         }
         break;
             
         case 2:      //sheet2 init
           with (sheetObj) {
             // 높이 설정
             style.height = 200;
             //전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = true;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 2, 1, 3, 100);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(21, 0, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(true, false, true, true, false,false);

             var HeadTitle1 = "|Sel.|Manufacturer|Manufacturer  Name|Delivery Location|TP/SZ|Qty|Price|Price|Price|Price|Price";
             var HeadTitle2 = "|Sel.|Manufacturer|Manufacturer  Name|Delivery Location|TP/SZ|Qty|Box|Unit|Drayage|G.TTL|Remark";

              //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle1, true);
             InitHeadRow(1, HeadTitle2, true);  //vndr_abbr_nm
             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++ , dtHiddenStatus, 		 30,  daCenter, false, 	  "ibflag");
             InitDataProperty(0, cnt++ , dtDummyCheck, 			 30,  daCenter, true,     "del_chk");
             InitDataProperty(0, cnt++ , dtComboEdit,     		 135, daLeft,   true,     "vndr_abbr_nm",    false,     "",      dfEngUpKey, 	   	0,     false,       true);//
             InitDataProperty(0, cnt++ , dtData,	 			 115, daLeft,   true,     "vndr_seq",        true,      "",      dfEngUpKey, 	    0,     false,       true, 6);//
             InitDataProperty(0, cnt++ , dtData, 	 			 135, daLeft,   true,     "loc_cd",          true,      "",      dfEngUpKey, 		0,     false,       true, 5);//
             InitDataProperty(0, cnt++ , dtData,    			 95, daCenter,  true,     "eq_tpsz_cd",      true,      "",      dfEngUpKey,		0,     false,       true);//
             InitDataProperty(0, cnt++ , dtData, 	 			 98, daRight,   true,     "eq_qty",          true,      "",      dfInteger,	    0,     true,       true, 6);//
             InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "pur_prc",         false,     "",      dfInteger,     0,     true,       true, 6);
             InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "pur_ut_prc",      false,     "",      dfInteger,     0,     true,       true, 6);
             InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "dryg_amt",        false,     "",      dfInteger,     0,     true,       true, 6);
             InitDataProperty(0, cnt++ , dtData,     			 85, daRight,   true,     "ttl",             false,     "|pur_prc|+|pur_ut_prc|+|dryg_amt|",      dfInteger,     0,     true,       true);
             InitDataProperty(0, cnt++ , dtData,     	         100,daCenter,  true,     "diff_rmk",        false,     "",      dfNone,        0,     true,       true);
             
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "bse_yrmon",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eq_knd_cd",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "curr_cd",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "stl1",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "stl2",       false,     "",      dfNone,        0,     true,       true);                     
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "stl3",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "insflg",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "updflg",       false,     "",      dfNone,        0,     true,       true);
             InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "delflg",       false,     "",      dfNone,        0,     true,       true);                     
             
             InitDataValid(0, "loc_cd",    vtEngUpOther, "1234567890");
             InitDataValid(0, "vndr_seq",  vtNumericOnly);

        }
        break;
      }
   }

   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
       case IBSEARCH:        //조회
          if(validateForm(sheetObj,formObj,sAction)){
			  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH;
			  sheetObj.DoSearch("EES_MST_0034GS.do", FormQueryString(formObj));
			  for (var i = 1; i <= sheetObj.RowCount+1; i++){
	             if (sheetObj.CellValue(i,"eq_tpsz_cd").substring(0, 1) == "R") {
	            	 sheetObj.CellEditable(i,"pur_ut_prc") = true;
	            	 sheetObj.MinimumValue (i, "pur_ut_prc") = 1;
	             } else {
	            	 sheetObj.CellEditable(i,"pur_ut_prc") = false;
	            	 sheetObj.MinimumValue (i, "pur_ut_prc") = 0;
	             }
	             sheetObj.MinimumValue (i, "eq_qty") = 1;
	             sheetObj.MinimumValue (i, "pur_prc") = 1;
	             sheetObj.MinimumValue (i, "dryg_amt") = 0;
			  }
			  ComOpenWait(false);
          }
       break;

       case IBSEARCH_ASYNC01://Sheet Combo 데이타 담아오기
	   	 	formObj.f_cmd.value = SEARCH01;
	   	  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&vndr_seq=");
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }	   	  	
	   	  	var cols = ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
	   	  	sheetObj.InitDataCombo(0, "vndr_abbr_nm", cols[1], cols[0],"","",1);    // IBSheet내 Combo 초기화
       break;
       
       case IBSEARCH_ASYNC02://Sheet Combo 데이타 담아오기
		 	formObj.f_cmd.value = SEARCH02;
		  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd="+formObj.eq_knd_cd.value);
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }		  	
		  	var cols = ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
		  	sheetObj.InitDataCombo(0, "eq_tpsz_cd", cols[0], cols[0]);    // IBSheet내 Combo 초기화
       break;
       
	   case IBSAVE:          //저장
		    if(validateForm(sheetObj,formObj,sAction)){
			   for (var i = 2; i <= sheetObj.RowCount+1; i++){
	                if (sheetObj.CellValue(i,"eq_tpsz_cd").substring(0, 1) == "R"){
	            	    if (eval(sheetObj.CellValue(i,"pur_ut_prc")) < 1){
		            		ComShowCodeMessage("MST01019", sheetObj.CellValue(i,"pur_ut_prc"));
		            		sheetObj.SelectCell(i,"pur_ut_prc");
		            		return;
	            	    }	 
	                }	 

		            if (parseInt(sheetObj.CellValue(i,"eq_qty")) < 1){
		            	 ComShowCodeMessage("MST01019", sheetObj.CellValue(i,"eq_qty"));
		            	 sheetObj.SelectCell(i,"eq_qty");
		            	 return;
		            }
		            if (parseInt(sheetObj.CellValue(i,"pur_prc")) < 1){
		            	 ComShowCodeMessage("MST01019", sheetObj.CellValue(i,"pur_prc"));
		            	 sheetObj.SelectCell(i,"pur_prc");
		            	 return;
		            }
		            if (parseInt(sheetObj.CellValue(i,"dryg_amt")) < 0){
		            	 ComShowCodeMessage("MST01019", sheetObj.CellValue(i,"dryg_amt"));
		            	 sheetObj.SelectCell(i,"dryg_amt");
		            	 return;
		            }		             
			   }
		    	
    		// 동일한  vndr_seq|loc_cd|eq_tpsz_cd 있으면  첫번째 중복행에 대해서  메세지 출력
    		var dupRows = sheetObj.ColValueDupRows("vndr_seq|loc_cd|eq_tpsz_cd",false);
    		var arrRow = dupRows.split(",");
	        if (dupRows != ""){
       			 //오류메시지 : 데이터가 중복됩니다.
       			 ComShowCodeMessage("MST00002", sheetObj.CellValue(arrRow[0],3)+","+sheetObj.CellValue(arrRow[0],4)+","+sheetObj.CellValue(arrRow[0],5));
	             for (var i = 1; i <= sheetObj.RowCount+1; i++){
	            	 if (sheetObj.CellValue(i,"vndr_seq")   == sheetObj.CellValue(arrRow[0],"vndr_seq") &&
	            		 sheetObj.CellValue(i,"loc_cd")     == sheetObj.CellValue(arrRow[0],"loc_cd") &&
	            		 sheetObj.CellValue(i,"eq_tpsz_cd") == sheetObj.CellValue(arrRow[0],"eq_tpsz_cd") &&
	            		 sheetObj.RowStatus(i) == "I"){
	       			     sheetObj.SelectCell(i, "vndr_seq", true);
	            	 }
	             }
       			 return;				        	
	        }
	        
	        sheetObj.WaitImageVisible=false;
	        			
			formObj.f_cmd.value = MULTI;
 	        var sParam = ComGetSaveString(sheetObjects[0]);
 	        if(sParam=="")break;
 	        if (sheetObj.IsDataModified){
 	           sParam += "&" + FormQueryString(formObj);
 	           ComOpenWait(true);
 	        }
			var sXml = sheetObj.GetSaveXml("EES_MST_0034GS.do", sParam);
			//ibflag가 D 이고 delflg 가 E가 아니면 삭제 Count를 1증가 하고  xml에서 삭제한다.
			
			//삭제성공
			var delsuc = 0;
			//삭제실패
			var delfal = 0;
			//등록성공
			var inssuc = 0;
			//등록실패
			var insfal = 0;
			//수정성공
			var updsuc = 0;
			//수정실패
			var updfal = 0;
			//failcnt
			var failcnt = 0;
			var failflg = false;
			
			var msg = ComXmlStringOfItmCnt(sXml, "vndr_seq", 0);
			if (msg == "") {ComOpenWait(false); return;}
			
			sheetObjects[1].LoadSaveXml(sXml);
			ComOpenWait(false);
			var sheetcnt = 2;
			
			//삭제 count를  구하기 위하여
			for (var i = 1; i <= sheetObjects[1].RowCount+1; i++){
				if (sheetObjects[1].RowStatus(i) == "D" && sheetObjects[1].CellValue(i,"delflg") == "") {
					var vndr_seql     = sheetObjects[1].CellValue(i,"vndr_seq");
					var loc_cdl       = sheetObjects[1].CellValue(i,"loc_cd");
					var eq_tpsz_cdl   = sheetObjects[1].CellValue(i,"eq_tpsz_cd");
					sheetObjects[1].RowDelete(i, false);
					
					for (var j = 1; j <= sheetObj.RowCount+1; j++){
						if (sheetObj.RowStatus(j) == "D" && 
							sheetObj.CellValue(j,"vndr_seq")   == vndr_seql &&
							sheetObj.CellValue(j,"loc_cd")     == loc_cdl &&
							sheetObj.CellValue(j,"eq_tpsz_cd") == eq_tpsz_cdl){
							sheetObj.RowDelete(j, false);
							delsuc = delsuc + 1;
						}	
					}	
				}
			}

			//color 원복
			for (var i = 1; i <= sheetObj.RowCount+1; i++){
				setsheetRowColorBlack(i);				
			}
			
			for (var i = 1; i <= sheetObj.RowCount+1; i++){
				if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U" || sheetObj.RowStatus(i) == "D") {
				    if (sheetObjects[1].CellValue(sheetcnt, "stl1") == "B"){
						sheetObj.CellEditable(i,"vndr_seq") = true;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = true;
						sheetObj.CellValue(i,"stl") = "";
						sheetObj.CellFontColor(i,3) = sheetObj.RgbColor(255, 0, 0);
						sheetObj.RowStatus(i) = "I";
						failflg = true;
				    }
				    if (sheetObjects[1].CellValue(sheetcnt, "stl2") == "B"){
						sheetObj.CellEditable(i,"vndr_seq") = true;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = true;
						sheetObj.CellValue(i,"stl") = "";
						sheetObj.CellFontColor(i,5) = sheetObj.RgbColor(255, 0, 0);
						sheetObj.RowStatus(i) = "I";
						failflg = true;
				    }
				    if (sheetObjects[1].CellValue(sheetcnt, "stl3") == "B"){
						sheetObj.CellEditable(i,"vndr_seq") = true;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = true;
						sheetObj.CellValue(i,"stl") = "";
						sheetObj.CellFontColor(i,4) = sheetObj.RgbColor(255, 0, 0);
						sheetObj.RowStatus(i) = "I";
						failflg = true;
				    }
				    
				    if (failflg == true) failcnt = failcnt + 1;
				    failflg = false;
				    
				    if (sheetObj.RowStatus(i) == "I" && sheetObjects[1].CellValue(sheetcnt, "insflg") == "E"){
						sheetObj.CellEditable(i,"vndr_seq") = true;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = true;
						sheetObj.CellValue(i,"stl1") = "";
						sheetObj.CellValue(i,"stl2") = "";
						sheetObj.CellValue(i,"stl3") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "I";
						insfal = insfal + 1;
				    } else if (sheetObj.RowStatus(i) == "I" && 
				    		   sheetObjects[1].CellValue(sheetcnt, "stl1") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "stl2") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "stl3") != "B" ){
						sheetObj.CellEditable(i,"vndr_seq") = false;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = false;
						sheetObj.CellEditable(i,"loc_cd") = false;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = false;
						sheetObj.CellValue(i,"stl") = "";
						sheetObj.RowStatus(i) = "R";
						inssuc = inssuc + 1;
				    }
				    
				    if (sheetObj.RowStatus(i) == "U" && sheetObjects[1].CellValue(sheetcnt, "updflg") == "E"){
						sheetObj.CellEditable(i,"vndr_seq") = true;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = true;
						sheetObj.CellValue(i,"stl1") = "";
						sheetObj.CellValue(i,"stl2") = "";
						sheetObj.CellValue(i,"stl3") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "U";
						updfal = updfal + 1;
				    } else if (sheetObj.RowStatus(i) == "U" && 
				    		   sheetObjects[1].CellValue(sheetcnt, "stl1") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "stl2") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "stl3") != "B" ){
						sheetObj.CellEditable(i,"vndr_seq") = false;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = false;
						sheetObj.CellEditable(i,"loc_cd") = false;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = false;
						sheetObj.CellValue(i,"stl1") = "";
						sheetObj.CellValue(i,"stl2") = "";
						sheetObj.CellValue(i,"stl3") = "";
						sheetObj.RowStatus(i) = "R";
						updsuc = updsuc + 1;
				    }
				    
				    if (sheetObjects[1].CellValue(sheetcnt, "delflg") == "E"){
						sheetObj.CellEditable(i,"vndr_seq") = true;
						sheetObj.CellEditable(i,"vndr_abbr_nm") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellEditable(i,"eq_tpsz_cd") = true;
						sheetObj.CellValue(i,"stl") = "";
						sheetObj.RowStatus(i) = "D";
				    }
				    sheetcnt = sheetcnt + 1; 
			   }
			}

			var insfalstr = "";
			if (insfal != 0){
				insfalstr = "Insert Fail : " + insfal.toString()+ "\n";
			} else {
				insfalstr = "";
			}
			
			var updfalstr = "";
			if (updfal != 0){
				updfalstr = "Update Fail : " + updfal.toString()+ "\n";
			} else {
				updfalstr = "";
			}
			
			var delfalstr = "";
			if (delfal != 0){
				delfalstr = "Delete Fail : " + delfal.toString()+ "\n";
			} else {
				delfalstr = "";
			}
			
			var failstr = "";
			if (failcnt != 0){
				failstr = "Data Fail   : " + failcnt.toString()+ "\n";
			} else {
				failstr = "";
			}
			
			var sMsg = "";
			if (inssuc > 0 || updsuc > 0 || delsuc > 0){
				sMsg = ComGetMsg("MST01025", "", "", "");
			}
			if (failcnt > 0){
				sMsg = sMsg + ComGetMsg("MST01026", "", "", "");
			}
			if (insfal > 0 || updfal > 0 || delfal > 0){
				sMsg = sMsg + ComGetMsg("MST01027", "", "", "");
			}
			
			ComShowMessage (sMsg);
		}
       break;
       
	   case IBINSERT:        // 입력
	        sheetObj.CellValue2(sheetObj.SelectRow,"bse_yrmon") = formObj.bse_yrmon.value.replace("-","");
        	sheetObj.CellValue2(sheetObj.SelectRow,"curr_cd") = "USD";
        	sheetObj.CellValue2(sheetObj.SelectRow,"vndr_abbr_nm") = "";
        	sheetObj.CellValue2(sheetObj.SelectRow,"eq_tpsz_cd") = "";
        	sheetObj.CellEditable(sheetObj.SelectRow,"pur_ut_prc") = false;
	        for (var i = 0; i < 3; i++){
	        	if (formObj.eq_knd_cd[i].checked == true)
	               sheetObj.CellValue2(sheetObj.SelectRow,"eq_knd_cd") = formObj.eq_knd_cd[i].value;
	        }
	        
            sheetObj.MinimumValue (sheetObj.SelectRow, "eq_qty") = 0;
            sheetObj.MinimumValue (sheetObj.SelectRow, "pur_prc") = 0;
            sheetObj.MinimumValue (sheetObj.SelectRow, "pur_ut_prc") = 0;
            sheetObj.MinimumValue (sheetObj.SelectRow, "dryg_amt") = 0; 		        
       break;
       
		case IBDELETE:      // 삭제
   		if (sheetObj.id == 'sheet1') {  
   		    sheetObj.SelectFontBold = false;
   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
				ComRowHideDelete(sheetObj,"del_chk"); 
				sheetObj.SelectFontBold = true;
			} 
		}    			
	    break;
     }
   }
   
   /**
    * 아이비시트 팝업 클릭시 이벤트
    */
   function sheet1_OnPopupClick(sheetObj, Row,Col,Value)
   {
   	 	if (sheetObj.ColSaveName(Col) == "loc_cd"){
   	 		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"scc_cd:loc_cd", "0,0,1,1,1,1,1", true);
   	 	    ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 470, 'setPopData_Loccd', '0,0,1', true, true, Row, "loc_cd", 1);   	 		
   	 	}
   }    
   
   function setPopData_Loccd(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			sheetObj.CellValue(Row,Col) = aryPopupData[0][3];
		}
   } 	
   
   function setsheetRowColorRed(cnt){
    	 sheetObjects[0].CellFontColor(cnt,1) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,2) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,3) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,4) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,5) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,6) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,7) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,8) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,9) = sheetObjects[0].RgbColor(255, 0, 0);
   }
     
   function setsheetRowColorBlack(cnt){
    	 sheetObjects[0].CellFontColor(cnt,1) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,2) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,3) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,4) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,5) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,6) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,7) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,8) = sheetObjects[0].RgbColor(0, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,9) = sheetObjects[0].RgbColor(0, 0, 0);
   }
   
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  if(ComIsEmpty(formObj.bse_yrmon)){
				 ComShowCodeMessage("MST00001", "Year/Month");
				 ComSetFocus(formObj.bse_yrmon);
				 return false;			
			  }        			  
         return true;
     }

     /**
     * Calendar Display
     */
     function popCalendar(type){
    	 var formObj = document.form;    	 
         var cal = new ComCalendar();
         cal.setDisplayType('month');
         cal.select(formObj.bse_yrmon, "yyyy-MM");
     }

     /**
     * Button style change (disable)
     */     
     function ComBtnDisable_u(name){ 
    	 var tds = document.getElementsByTagName("td"); 
	    	 for(var i = 0; i < tds.length; i++) { 
		    	 var td=tds[i]; 
		    	 if (td.className.length > 0 && td.name == name){ 
		    	 if(td.className.indexOf('_1') == -1) 
		    	 td.className += "_1"; 
		    	 td.name="no_"+name; 
	    	 } 
    	 } 
     }
     
     /**
     * Button style change (Enable)
     */      
     function ComBtnEnable_u(name) { 

    	 var tds = document.getElementsByTagName("td"); 
    	 for ( var i = 0; i < tds.length; i++) { 
	    	 var td = tds[i]; 
	    	 if (td.className.length > 0 && td.name == "no_"+name) { 
		    	 if (td.className.indexOf('_1') > 0) 
		    	 td.className = td.className.replace(/_1/i, ""); 
		    	 td.name=name; 
	    	 } 
    	 } 
     }
      
     function sheet1_OnChange(SheetObj, Row, Col, Value){
    	 var formObj = document.form; 
    	 var sName = SheetObj.ColSaveName(Col); 	
         if (sName == "eq_tpsz_cd"){
             if (Value.substring(0, 1) == "R") {
            	 SheetObj.CellEditable(Row,"pur_ut_prc") = true;
             } else {
            	 SheetObj.CellEditable(Row,"pur_ut_prc") = false;
            	 SheetObj.CellValue(Row,"pur_ut_prc") = 0;
             }
         } 
         else if (sName == "vndr_abbr_nm"){
             var sText = SheetObj.GetComboInfo(Row, Col, "Text");
             //각각 배열로 구성한다.
             var arrText = sText.split("|");
             var idx   = SheetObj.GetComboInfo(Row, Col, "SelectedIndex");	  
             if (idx >=0){
	             var tt = arrText[idx].substring(7,arrText[idx].length); 	 
	             SheetObj.CellValue(Row, "vndr_seq") = arrText[idx].substring(0,6);
             }
         }
     }
     
	/* 개발자 작업  끝 */