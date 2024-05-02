/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0032.js
*@FileTitle : Analyze different Data in NIS & ERP-FA - Master/FA Only
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.31 이호선
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
     * @class ees_mst_0032 : ees_mst_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0032() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo 				= initCombo;
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
 
 var comboObjects = new Array();
 var comboCnt = 0 ; 
 var IBSEARCH01  = 29;
 var bKeyDown = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
          /*******************************************************/
         var formObject = document.form;

         try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
					case "btn_retrieve":
					    if (formObject.yr_mon.value.length < 7 || formObject.ver_no.Text.length == 0) {
					    	if (formObject.yr_mon.value.length < 7){
					    		ComShowCodeMessage("MST00001", "Month");
					    		return;
					    	}
					    	if (formObject.ver_no.Text.length == 0){
					    		ComShowCodeMessage("MST00001", "Version");
					    		return;
					    	}
					    }
				        if (tabObjects[0].selectedIndex == 0){
				        	//sheetObject2.RemoveAll();
				        	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				        }else if (tabObjects[0].selectedIndex == 1){
				        	//sheetObject1.RemoveAll();
				        	doActionIBSheet(sheetObject2,document.form,IBSEARCH);
				        }else{
				        	//sheetObject1.RemoveAll();
				        	doActionIBSheet(sheetObject3,document.form,IBSEARCH);
				        }
					break;
					
					case "btn_new":
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						sheetObject3.RemoveAll();
						ClearMasterData(1);
						formObject.yr_mon.disabled = false;
						formObject.eq_type[0].disabled = false;
						formObject.eq_type[1].disabled = false;
						formObject.eq_type[2].disabled = false;	
						formObject.ver_no.Enable = true;
						ComBtnEnable("btn_retrieve");
						ComBtnDisable("btn_save");
						
					     var today = new Date();
					     if (today.getMonth() < 9){
					    	 formObject.yr_mon.value = String(today.getYear())+ "-0" + String(today.getMonth()+1);
					     } else {
					    	 formObject.yr_mon.value = String(today.getYear())+ "-" + String(today.getMonth()+1); 
					     }						
						
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
						ComSetFocus(formObject.ver_no);
						
					break;

					case "btn_t1downexcel":
						sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"0");
					break;
					
					case "btn_t2downexcel":
						sheetObject2.Down2Excel(-1,false,false,true,"","",false,false,"",false,"0");
					break;	
					
					case "btn_t3downexcel":
						sheetObject3.Down2Excel(-1,false,false,true,"","",false,false,"",false,"0");
					break;
					
					case "btn_save":
				        doActionIBSheet(sheetObject1,document.form,IBSAVE);
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
          
   		 // IBMultiCombo초기화 
   	     for(var k=0;k<comboObjects.length;k++)  	    	
   	         initCombo(comboObjects[k],k+1);
         
 	     axon_event.addListenerFormat('blur', 	 'obj_blur',  		form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	     axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		 axon_event.addListenerFormat('keyup', 'obj_keyup',	 	form); //- 키 눌렸을때
		 axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때
		 axon_event.addListenerForm('keydown',	 'ComKeyEnter',	    form); //- 키 눌렸을때
		 axon_event.addListener('click', 		 'eq_type_click',	'eq_type');	
 
     }
      
     function sheet1_OnLoadFinish(sheetObj) {
         //첫번째 IBShseet의 데이터만 먼저 조회한다.
         var formObj = document.form;
         
         for(var k=0;k<tabObjects.length;k++)
             initTab(tabObjects[k],k+1);
         
	     var today = new Date();
	     if (today.getMonth() < 9){
	         document.form.yr_mon.value = String(today.getYear())+ "-0" + String(today.getMonth()+1);
	     } else {
	    	 document.form.yr_mon.value = String(today.getYear())+ "-" + String(today.getMonth()+1); 
	     }
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);		 
		 ComBtnDisable("btn_save");   
		 document.getElementById("ver_no").BackColor = "#CCFFFD"
		 ComSetFocus(formObj.ver_no);
     }
     
     /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
     }
     
	 //Axon 이벤트 처리2. 이벤트처리함수
	 function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
        if(event.srcElement.name == "yr_mon"){
	    	if (formObj.yr_mon.value.trim().length > 0){ 
	    	   ComChkObjValid(obj);
	    	   comboObjects[0].RemoveAll();
	    	   if (bKeyDown == false){
	    		   bKeyDown = true;
   		          doActionIBSheet(sheetObjects[0], formObj, IBSEARCH01);
	    	   } else {
	    		   bKeyDown = false;
	    	   }
	    	}
	    }
	    else {
            //Validation 전체 체크(길이,format,최대,최소 등등)
            ComChkObjValid(obj);
            bKeyDown = false;
	    }
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
	            if(obj.name=="yr_mon") ComKeyOnlyNumber(this, "-");
	            break;
	    }        
	}
 	
 	function obj_keyup() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		if (obj.name == "yr_mon") {
	  		if ( vKeyCode == 9 || vKeyCode == 13) {
			    if (formObj.yr_mon.value.length < 6) {
			    	ComShowCodeMessage("MST00001","Month");
			      	return;
			    }
			    bKeyDown = true;
			    ComSetFocus(formObj.ver_no);
	  		}
 		} 
 	}

 	function eq_type_click(){
 		var formObj  = document.form;
 		
	    sheetObjects[0].RemoveAll();
	    sheetObjects[1].RemoveAll();
	    ClearMasterData(2); 		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); 		
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
           case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 260;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;
                     //MergeSheet = msAll;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(11, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle1 = "|Seq.|EQ No.|TP/SZ|Term|Status|Movement|Yard|Movement date|Remark(s)|A";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  0,   daCenter,  true,   	 "ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq, 	  90,  daCenter,  false,     "Seq",  			false,      "",      dfNone, 			0,     false,       false);
 					 InitDataProperty(0, cnt++ , dtData,   	      145, daCenter,  false,     "eq_no", 			false,      "",      dfNone, 			0,     false,       false); 
 					 InitDataProperty(0, cnt++ , dtData, 		  90,  daCenter,  false,     "eq_tpsz_cd",  	false,      "",      dfNone,			0,     false,       false);
 					 InitDataProperty(0, cnt++ , dtData, 		  90,  daCenter,  false,     "lstm_cd",  	    false,      "",      dfNone,			0,     false,       false); 					 
 					 InitDataProperty(0, cnt++ , dtData, 		  90,  daCenter,  false,     "cntr_sts_cd",  	false,      "",      dfNone,			0,     false,       false); 					 
                     InitDataProperty(0, cnt++ , dtData, 	 	  110,  daCenter,  false,     "cnmv_sts_cd",	false,      "",      dfNone,			0,     false,       false);
 					 InitDataProperty(0, cnt++ , dtData,   	      85,  daCenter,  false,     "crnt_yd_cd", 		false,      "",      dfNone, 			0,     false,       false); 
 					 InitDataProperty(0, cnt++ , dtData, 		  115, daCenter,  false,     "cnmv_dt",  		false,      "",      dfDateYmd,		    0,     false,       false);										
                     InitDataProperty(0, cnt++ , dtData, 	 	  40,  daLeft,    false,     "diff_rmk",  		false,      "",      dfNone,			0,     true,        true, 200);
                     
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eq_fa_aud_rslt_cd",       false,     "",      dfNone,        0,     true,       true);                     
                     
                     InitDataValid(0, "diff_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ ");   //영문만                     
                }
             break;
                  
             case "sheet2":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 260;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;
                     //MergeSheet = msAll;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(11, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle1 = "|Seq.|EQ No.|TP/SZ|Term|Status|Movement|Yard|Movement date|Remark(s)|A";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  0,   daCenter,  true,   	 "ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq, 	  90,  daCenter,  false,     "Seq",  		false,      "",      dfNone, 			0,     false,       false);
 					 InitDataProperty(0, cnt++ , dtData,   	      145, daCenter,  false,     "eq_no", 		false,      "",      dfNone, 			0,     false,       false); 
 					 InitDataProperty(0, cnt++ , dtData, 		  90,  daCenter,  false,     "eq_tpsz_cd",  false,      "",      dfNone,			0,     false,       false);
 					 InitDataProperty(0, cnt++ , dtData, 		  90,  daCenter,  false,     "lstm_cd",  	    false,      "",      dfNone,			0,     false,       false); 					 
 					 InitDataProperty(0, cnt++ , dtData, 		  90,  daCenter,  false,     "cntr_sts_cd",  	false,      "",      dfNone,			0,     false,       false); 					 
                     InitDataProperty(0, cnt++ , dtData, 	 	  110, daCenter,  false,     "cnmv_sts_cd", false,      "",      dfNone,			0,     false,       false);
 					 InitDataProperty(0, cnt++ , dtData,   	      85,  daCenter,  false,     "crnt_yd_cd", 	false,      "",      dfNone, 			0,     false,       false); 
 					 InitDataProperty(0, cnt++ , dtData, 		  115, daCenter,  false,     "cnmv_dt",  	false,      "",      dfDateYmd,		    0,     false,       false);										
                     InitDataProperty(0, cnt++ , dtData, 	 	  40,  daLeft,    false,     "diff_rmk",  	false,      "",      dfNone,			0,     true,        true, 200);

                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eq_fa_aud_rslt_cd",       false,     "",      dfNone,        0,     true,       true);
                     
                     InitDataValid(0, "diff_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ ");   //영문만                     
                     //InitDataValid(0, "diff_rmk", vtEngOnly);   //영문만
             }
             break;
             
             case "sheet3":      //sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 260;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;
                 //MergeSheet = msAll;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(9, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false);

                 var HeadTitle1 = "||ALPS|ALPS|ALPS|ERP FA|ERP FA|ERP FA|";
                 var HeadTitle2 = "|TP/SZ|Qty|AMT|Average|Qty|AMT|Average|";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  	true,  	   "ibflag");
                 InitDataProperty(0, cnt++ , dtData, 		  60,  daCenter,  	false,     "eq_tpsz_cd",  	false,      "",      dfNone,			0,     false,       false);
				 InitDataProperty(0, cnt++ , dtData, 		  150,  daRight,  	false,     "alps_qty",    	false,      "",      dfInteger,			0,     false,       false); 					 
				 InitDataProperty(0, cnt++ , dtData, 		  150,  daRight,  	false,     "alps_amt",  	false,      "",      dfInteger,			0,     false,       false); 					 
                 InitDataProperty(0, cnt++ , dtData, 	 	  150,  daRight,  	false,     "alps_avg", 		false,      "",      dfFloat,			0,     false,       false);
				 InitDataProperty(0, cnt++ , dtData,   	      150,  daRight,  	false,     "fa_qty", 		false,      "",      dfInteger, 		0,     false,       false); 
				 InitDataProperty(0, cnt++ , dtData, 		  150,  daRight, 	false,     "fa_amt",  		false,      "",      dfInteger,		    0,     false,       false);										
                 InitDataProperty(0, cnt++ , dtData, 	 	  150,  daRight,    false,     "fa_avg",  		false,      "",      dfFloat,			0,     false,       false);
                 InitDataProperty(0, cnt++ , dtAutoSum, 	  150, 	daRight,	false,	   "auto_sum",		false,		"",		 dfFloat);
                 ColHidden("auto_sum") = true;
                 
                 //InitDataValid(0, "diff_rmk", vtEngOnly);   //영문만
                 EditableColorDiff = true;
         }
         break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
				case IBSEARCH:      //조회
					if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value = SEARCH;
				        var sXml = "";

			        	sheetObj.WaitImageVisible=false;
			        	ComOpenWait(true);
//				        if (formObj.cre_dt.value.length == 0 &&
//				        	formObj.mst_qty.value.length == 0  &&
//				        	formObj.fa_qty.value.length == 0){
							if (sheetObj.id == "sheet1"){
							    sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do", FormQueryString(formObj)+"&rslt_cd=M");
							}    
							else if (sheetObj.id == "sheet2"){
								sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do", FormQueryString(formObj)+"&rslt_cd=F");
							}
							else if (sheetObj.id == "sheet3"){
								sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do", FormQueryString(formObj)+"&rslt_cd=A");
							}
			            	var chk = sXml.indexOf("ERROR");
			            	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
			            		sheetObj.LoadSearchXml(sXml);
				            	ComOpenWait(false);
			            		return;
			            	}							
							var arrXml = sXml.split("|$$|");
							
			                // 입력 박스 데이타 채우기 	  
			            	formObj.mst_qty.value    = ComXmlString(arrXml[0], "mst_qty");
			            	formObj.fa_qty.value     = ComXmlString(arrXml[0], "fa_qty");
			            	formObj.cre_dt.value     = ComXmlString(arrXml[0], "cre_dt");
			            	formObj.diff_qty.value   = ComXmlString(arrXml[0], "diff_qty");
			            	formObj.mst_ony_qty.value= ComXmlString(arrXml[0], "mst_ony_qty");
			            	formObj.fa_ony_qty.value = ComXmlString(arrXml[0], "fa_ony_qty");
			            	formObj.diff_rmk_m.value = ComXmlString(arrXml[0], "diff_rmk_m");
			            	
			            	formObj.mst_qty.value    = ComAddComma(formObj.mst_qty.value);
			            	formObj.fa_qty.value	 = ComAddComma(formObj.fa_qty.value); 
			            	formObj.diff_qty.value	 = ComAddComma(formObj.diff_qty.value);
			            	formObj.mst_ony_qty.value= ComAddComma(formObj.mst_ony_qty.value);
			            	formObj.fa_ony_qty.value = ComAddComma(formObj.fa_ony_qty.value);
			            	
			            	//시트 데이타 채우기
			            	if (arrXml.length > 1) sheetObj.LoadSearchXml(arrXml[1]);
			            	
			            	formObj.yr_mon.disabled = true;
			            	formObj.eq_type[0].disabled = true;
			            	formObj.eq_type[1].disabled = true;
			            	formObj.eq_type[2].disabled = true;		
			            	formObj.ver_no.Enable = false;
			            	ComBtnDisable("btn_retrieve");
			            	ComBtnEnable("btn_save");
//				        } else {
//				        	
//				            //Master Only 인지 FA Only 인지에 따라서 count의 조회여부 확인 
//				            if (sheetObj.id == "sheet1"){
//			            		sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do", FormQueryString(formObj)+"&rslt_cd=M");
//			            		var arrXml = sXml.split("|$$|");
//			            		if (arrXml.length > 1) sheetObj.LoadSearchXml(arrXml[1]);
//				            } 
//				            else if (sheetObj.id == "sheet2"){
//			            		sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do", FormQueryString(formObj)+"&rslt_cd=F");
//			            		var arrXml = sXml.split("|$$|");
//			            		if (arrXml.length > 1) sheetObj.LoadSearchXml(arrXml[1]);
//				            }else if (sheetObj.id == "sheet3"){
//				            	sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do", FormQueryString(formObj)+"&rslt_cd=A");
//				            	var arrXml = sXml.split("|$$|");
//								if (arrXml.length > 1) sheetObj.LoadSearchXml(arrXml[1]);
//							}
//				        }
		            	ComOpenWait(false);
					}
				break;
				
				case IBSEARCH01:
					if(validateForm(sheetObj,formObj,sAction)){
						comboObjects[0].RemoveAll();
				  		// IBMultiCombo초기화 
						 formObj.f_cmd.value = SEARCH01;
			             var sXml = sheetObj.GetSearchXml("EES_MST_0032GS.do" , FormQueryString(formObj));	             
			             //TP/SZ 조회
		            	 var chk = sXml.indexOf("ERROR");
		            	 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
		            		sheetObj.LoadSearchXml(sXml);
		            		return;
		            	 }				             
			             var cntr_ver_no = ComGetEtcData(sXml,"version_cd");
			             var strCntrver_no  = cntr_ver_no.split("|");
			             
				         with (formObj.ver_no) {
				        	 var cnt = GetCount();
				        	 for (var i=0; i < cnt; i++) {
			  		        	 DeleteItem(i);
				        	 }
				        	 for (var i=0; i<cntr_ver_no.split("|").length; i++) {
			  		        	 InsertItem(i, strCntrver_no[i], strCntrver_no[i]);
				        	 }
				         }
					}	
				break;	
				
				case IBSAVE:        //저장
					if(validateForm(sheetObj,formObj,sAction)){
						
		     	        var uptflg = false;
		     	        for (var i = 1; i <= sheetObj.RowCount; i++){
		     	        	if(sheetObj.RowStatus(i) == 'U'){
		     	        		uptflg = true;
		     	        	}
		     	        }
	     	        
		     	        //Row가 한개도 없을때는 ?
		     	        if (uptflg == false){
		     	        	sheetObj.RowStatus(1) = 'U';
		     	        	//sheetObj.CellValue(1,"ibflag") = 'U';
		     	        }						
						
		     	        sheetObj.WaitImageVisible=false;
		     	        ComOpenWait(true);		     	        
						formObj.f_cmd.value = MULTI;
						
		     	        var sParam = ComGetSaveString(sheetObjects[0]);
		     	        sParam += "&" + ComGetSaveString(sheetObjects[1]);
	     	            sParam += "&" + FormQueryString(formObj);
	     	            
		     	        var sXml = "";
		     	        sXml = sheetObj.GetSaveXml("EES_MST_0032GS.do", sParam);
		     	        ComOpenWait(false);
		     	        
						var chk = sXml.indexOf("OK");
						if (chk == -1){
							sheetObj.LoadSearchXml(sXml);
						} else {
							ComShowCodeMessage("MST01025");
						}
				    }
				break;
        }
    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
      
    /**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
    function initCombo(comboObj, comboNo) {
        var formObject = document.form;
		switch(comboObj.id) {
		    case "ver_no":
			   with (comboObj) { 
				   DropHeight = 100;   
			       MultiSelect = false;
		   	       MaxSelect = 1;
		   	       BackColor = "#CCFFFD";
		    	   Style = 0;
	  			   ValidChar(2,1);
	   			   UseAutoComplete = true;
			   }				   
			break;	  
		 } 
	}        

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt  = 0 ;

                     InsertTab( cnt++ , "Master Only" , -1 );
                     InsertTab( cnt++ , "FA Only" , -1 );
                     InsertTab( cnt++ , "ALL DPC" , -1 );
                 }
             break;
        }
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , tabIndex){
        var formObj = document.form;
        var objs = document.all.item("tabLayer");
        objs[tabIndex].style.display = "Inline";
        objs[beforetab].style.display = "none";
        
        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[tabIndex].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= tabIndex;

      	if (tabIndex == "0" && formObj.ver_no.Text.length > 0) {
      		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
      	} else if (tabIndex == "1" && formObj.ver_no.Text.length > 0) {
      		doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
        } else if (tabIndex == "2" && formObj.ver_no.Text.length > 0) {
      		doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
        }		        
    } 
      
    /**
   	 * cntr_tpsz_cd_OnBlur
   	 */
    function ver_no_OnBlur(comboObj, Index_Code, Text) {
   		  var formObj = document.form;
   		  formObj.ver_no_h.value = ComGetObjValue(comboObj);
   	 }
       
  	 /**
  	  * combo1_OnKeyDown
  	  * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
  	  */
     function ver_no_OnKeyDown(comboObj, KeyCode, Shift) {
	     var formObj = document.form;

  		 with(comboObj) {
  			if(KeyCode == 13) {
  				formObj.ver_no_h.value = ComGetObjValue(comboObj);
  			}
  		 }
  	 }
   	  
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
         
	 /**
	  * 마스터부분 reset
	  */
     function ClearMasterData(gubun){
		 var formObj  = document.form;
	 	 if (gubun == 1)
		    formObj.eq_type[0].checked = true;
		 formObj.mst_qty.value		= "";
		 formObj.fa_qty.value		= "";		
		 formObj.cre_dt.value		= "";
		 formObj.diff_qty.value		= "";
		 formObj.mst_ony_qty.value	= "";
		 formObj.fa_ony_qty.value	= "";
		 formObj.diff_rmk_m.value	= "";		 
     }
	  
     /**
     * Calendar Display
     */
     function popCalendar(type){
    	 var formObj = document.form;
    	 if (formObj.yr_mon.disabled == false){
	         var cal = new ComCalendar();
	         cal.setDisplayType('month');
	         cal.select(formObj.yr_mon, "yyyy-MM");
    	 }
     }
     
     /**
      * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	 * @param sheetObj
 	 * @param ErrMsg
      */
     function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
     	var formObj = document.form;

 		with(sheetObj) {
 			CellValue2(LastRow, 1) = "G.TTL";
 			for(var j = 0; j < LastCol; j++) {
				CellText(LastRow, j) = CellText(LastRow -1, j);
			}
 			sheetObj.RowDelete(LastRow -1, false);
 		}
     }
	 
	/* 개발자 작업  끝 */