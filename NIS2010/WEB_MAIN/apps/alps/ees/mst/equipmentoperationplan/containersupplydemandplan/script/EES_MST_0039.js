/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0039.js
*@FileTitle : Container Check Digit and Container Checking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
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
     * @class ees_mst_0039 : ees_mst_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0039() {
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
 var head_cntr_tpsz_cd ="";
 var head_pur_list = "";
 var tot_cntr_tpsz_cd ="";
 var comboObjects = new Array();
 var comboCnt = 0 ; 
 
 var IBSEARCH01  = 29;

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
				    if (formObject.bse_yrmon0.value.length < 7 || formObject.bse_yrmon1.value.length < 7) {
				        ComShowCodeMessage("MST00001", "Year/Month");
				        if (formObject.bse_yrmon0.value.length < 7)
				        	formObject.bse_yrmon0.focus()
				        else
				        	formObject.bse_yrmon1.focus(); 
				        return;
				    } 					
 					if (document.form.bse_yrmon0.value > document.form.bse_yrmon1.value){
	            		ComShowCodeMessage("MST00009");
	            		document.form.bse_yrmon0.focus();
	            		return; 						
 					}
 					sheetObject1.RemoveAll();
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 				break;
 				
 				case "btn_new":
 					sheetObject1.RemoveAll();
 					comboObjects[0].Code = "";
 					formObject.mloc_cd.value = "A";
 					formObject.loc_cd.value = "";
 				    formObject.bse_yrmon0.value = "";
 				    formObject.bse_yrmon1.value = "";
 				    formObject.eq_knd_cd[0].checked = true;
 				    formObject.loc_cd.disabled = true;
 			   	    document.getElementById("loc_cd").className = "input2"; 				   
 				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
 				    ComSetFocus(formObject.bse_yrmon0);
 				break;

 				case "btn_downexcel":
 					sheetObject1.Down2Excel();
 				break;
 				
 				// LOCATION 팝업(단건 선택일 경우 띠우는 방법)
 				case "ComOpenPopupWithTarget2":
 					
 		        	var tmp = formObject.mloc_cd.value;
 		        	if(tmp == "R"){
 		        		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
 		        	}else if(tmp == "L"){
 		        		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
 		        	}else if(tmp == "S"){
 		        		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:loc_cd", "0,0,1,1,1,1,1", true);
 		        	}else if(tmp == "E"){
 		        		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"ecc_cd:loc_cd", "0,0,1,1,1,1,1", true);
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

         axon_event.addListenerFormat('blur', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	     axon_event.addListenerFormat('focus','obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 	     axon_event.addListener('click', 'eq_knd_cd_click', 'eq_knd_cd');
 		 axon_event.addListener('change','mloc_cd_change',	'mloc_cd'); //- 키 눌렸을때
 		 axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때 		 
     	 axon_event.addListener('click',  'check_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', '');	//TP/SZ 체크박스 체크 이벤트 처리
     	 axon_event.addListener('change', 'cntr_tpsz_cd_change', 'cntr_tpsz_cd', '');			//TP/SZ 변경시 이벤트 처리
     }
      
      function sheet1_OnLoadFinish(sheetObj) {
   	      for(var p=0;p< comboObjects.length;p++){
     	      initCombo (comboObjects[p],p+1);
     	  }     	 
    	  document.form.bse_yrmon0.value = "";
    	  document.form.bse_yrmon1.value = "";  	     
     	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
     	  document.form.loc_cd.disabled = true;
     	  document.getElementById("loc_cd").className = "input2";
     	  document.form.bse_yrmon0.focus();    	  
      }
      
     /**
      * IBCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }
     
     function initCombo (comboObj, comboNo) {
    	 switch(comboObj.id) {
    		case "cntr_tpsz_cd":
    			with(comboObj) {
    				//BackColor = "cyan";
    				DropHeight = 150;
    				MultiSelect = true;
    				UseAutoComplete = true;
    				MultiSeparator = ",";
    				Style = 0;
    				ValidChar(2,3);    				
    			}
    		break;
    	 }      	
     }

	 //Axon 이벤트 처리2. 이벤트처리함수
	 function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	 }
	
	 function obj_activate(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "bse_yrmon0"){		
	    	ComClearSeparator(formObj.bse_yrmon0, "ym");
	    	ComSetFocus(formObj.bse_yrmon0);
	    } else if (event.srcElement.name == "bse_yrmon1"){
	    	ComClearSeparator(formObj.bse_yrmon1, "ym");
	    	ComSetFocus(formObj.bse_yrmon1);
	    } else {
	    	ComClearSeparator(event.srcElement);
	    }
	 }	 
	 
     function eq_knd_cd_click(){
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
     }
     
     function mloc_cd_change(){
    	 if(document.form.mloc_cd.value == "A"){
    		 document.form.loc_cd.disabled = true;
     		 document.getElementById("loc_cd").className = "input2";
     		document.form.loc_cd.value = "";
    	 } else {
    		 document.form.loc_cd.disabled = false;
     		 document.getElementById("loc_cd").className = "input";
    	 }
     }
     
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "engup":
	        	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
	        break;
	        case "ym":
	            if(obj.name=="bse_yrmon0") ComKeyOnlyNumber(this, "-");
	            if(obj.name=="bse_yrmon1") ComKeyOnlyNumber(this, "-");
	        break;
	    }
	}
 	
    /**
    * TP/SZ 체크박스 체크 이벤트 처리
    * TP/SZ 체크박스 체크시 전체체크,전체해재 기능
    */
    function check_cntr_tpsz_cd_check() {
       var formObject = document.form;
       if ( formObject.chk_cntr_tpsz_cd.checked ) {
    	   comboObjects[0].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
       } else {
    	   comboObjects[0].Code = "";
       }
    }
    
    /**
    * TP/SZ 변경시 이벤트 처리
    * 전체리스트에서 하나라도 체크 해제 되어 있으면 전체체크박스 해제, 전체가 체크되어 있어야 전체체크박스선택
    */   
    function cntr_tpsz_cd_change(comboObj,value,text) {
       var real_cntr_tpsz_cd = tot_cntr_tpsz_cd.replaceStr("|", ",").split(",")
       var cntr_tpsz_cd  = comboObjects[0].Code.split(",");
       if ( real_cntr_tpsz_cd.length !=cntr_tpsz_cd.length) {
    	   document.form.chk_cntr_tpsz_cd.checked = false;
       } else {
    	   document.form.chk_cntr_tpsz_cd.checked = true;
       }
       
	   if(  0 <= value.indexOf("ALL") ){
	       var strLstmCd =  value.split(",");        	
		   document.form.chk_cntr_tpsz_cd.value = ""; 		    
	   }else{
		   var strTpszCd =  value.replaceStr("|", ",").split(",");
		   document.form.chk_cntr_tpsz_cd.value = strTpszCd;
		   var sTpSz = document.form.chk_cntr_tpsz_cd.value;                         
	   } 	       
    }
    
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }
    
    /**
	 * cntr_tpsz_cd_OnBlur
	 */
	function cntr_tpsz_cd_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cntr_tpsz_cd_h.value = ComGetObjValue(comboObj);
	}
	
	/**
	 * combo1_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function cntr_tpsz_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd_h.value = ComGetObjValue(comboObj);
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
                     style.height = 400;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;
                     //MergeSheet = msAll;
 					//전체Edit 허용 여부 [선택, Default false]
                     Editable = false;
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 3, 1, 3, 100);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     //InitColumnInfo(18, 3, 0, true);
                     InitColumnInfo(15, 3, 0, true);
                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, false, false, true, false,false);

                     //var HeadTitle1 = "Item|Item|Item|CNSHA|CNSHA|CNSHA|CNSHA|CNSHA|CNDLC|CNDLC|CNDLC|CNDLC|CNDLC|Average|Average|Average|Average|Average";
                     var HeadTitle1 = "Item|Item|Item| | | | | | |Average|Average|Average|Average|Average|Average";                     
                     //var HeadTitle2 = "Year/Month|Manufacturer|TP/SZ|Price|Price|Price|Price|Price| Price| Price| Price| Price| Price|Price|Price|Price|Price|Price";
                     var HeadTitle2 = "Year/Month|Manufacturer|TP/SZ| Price| Price| Price| Price| Price| Price|Price|Price|Price|Price|Price|Price";                     
                     //var HeadTitle3 = "Year/Month|Manufacturer|TP/SZ|Q'ty|Box|Unit|Drayage|TTL|Q'ty|Box|Unit|Drayage|TTL|Q'ty|Box|Unit|Drayage|G.TTL";
                     var HeadTitle3 = "Year/Month|Manufacturer|TP/SZ|Q'ty|Box|Unit|Drayage|TTL|Remark|Q'ty|Box|Unit|Drayage|G.TTL|Remark";                     
                
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                     InitHeadRow(2, HeadTitle3, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,   80,daCenter,	    true,	"year",  		        false,      "",      dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   85,daCenter,	    true,	"vndr_abbr_nm",         false,      "",      dfNone,			0,     true,       true);										
                     InitDataProperty(0, cnt++ , dtData,   40,daCenter,	    true,	"eq_tpsz_cd",	        false,      "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   75,daRight,   	true,	"cnsha_eq_qty",	        false,      "",      dfNullInteger, 	0,     true,       true);                                       
                     InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_pur_prc",    	false,      "",      dfNullInteger, 	0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_pur_ut_prc",    	false,      "",      dfNullInteger, 	0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_dryg_amt",    	false,      "",      dfNullInteger, 	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_ttl",    	    false,      "",      dfNullInteger, 	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_remark",    	    false,      "",      dfNullInteger, 	0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	true,	"ttl_eq_qty", 		    false,      "",      dfNullInteger, 	0,     true,       true);                                         
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_pur_prc",    	    false,      "",      dfNullInteger, 	0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_pur_ut_prc",    	false,      "",      dfNullInteger, 	0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_dryg_amt",    	    false,      "",      dfNullInteger, 	0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_ttl", 		        false,      "",      dfNullInteger,		0,     true,       true);
 		             InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_remark", 		    false,      "",      dfNone,		0,     true,       true);
                }
             break;
         }
     }
      
     /**
     * 재설정 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function reinitsheet(sheetObj, strpur_listCd) {
          var cnt = 0;
          with (sheetObj) {
              // 높이 설정
              style.height = 400;
              //전체 너비 설정
              SheetWidth = mainTable.clientWidth;
              //Host정보 설정[필수][HostIp, Port, PagePath]
              if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
              //전체Merge 종류 [선택, Default msNone]
              MergeSheet = msPrevColumnMerge;
              //MergeSheet = msAll;
			  //전체Edit 허용 여부 [선택, Default false]
              Editable = false;
              //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
              InitRowInfo( 3, 1, 3, 100);
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
              var pur_listCnt = strpur_listCd.length;
              InitColumnInfo((pur_listCnt+1)*6+3, 3, 0, true);
              // 해더에서 처리할 수 있는 각종 기능을 설정한다
              InitHeadMode(false, false, false, true, false,false);

              var HeadTitle1 = "Item|Item|Item|";
              var HeadTitle2 = "Year/Month|Manufacturer|TP/SZ|";
              var HeadTitle3 = "Year/Month|Manufacturer|TP/SZ|";
              
              var pur_listCnt = strpur_listCd.length;
              for (var i = 0; i < pur_listCnt; i++){

            	  for (var j = 0; j < 6; j++){
            		  if (strpur_listCd[i].trim() != ""){
            		     HeadTitle1 = HeadTitle1 + strpur_listCd[i] + "|";
            		  } else {
            			  HeadTitle1 = HeadTitle1 + " |"; 
            		  }   
            		  if (i % 2 == 1){
            		      HeadTitle2 = HeadTitle2 + " Price|";
            		  } else {
            			  HeadTitle2 = HeadTitle2 + "Price|"; 
            		  }
            	  }
            	  HeadTitle3 = HeadTitle3 + "Q'ty|Box|Unit|Drayage|TTL|Remark|";
              }
              HeadTitle1 = HeadTitle1 + "Average|Average|Average|Average|Average|Average";
              if (pur_listCnt % 2 == 0){ 
                 HeadTitle2 = HeadTitle2 + "Price|Price|Price|Price|Price|Price";
              } else {
            	 HeadTitle2 = HeadTitle2 + " Price| Price| Price| Price| Price| Price"; 
              }
              HeadTitle3 = HeadTitle3 + "Q'ty|Box|Unit|Drayage|TTL|Remark";
              
              //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              InitHeadRow(0, HeadTitle1, true);
              InitHeadRow(1, HeadTitle2, true);
              InitHeadRow(2, HeadTitle3, true);

              //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              InitDataProperty(0, cnt++ , dtData,   80,daCenterTop,	true,	"year",  		        false,      "",      dfNone, 			0,     true,       true);
              InitDataProperty(0, cnt++ , dtData,   150,daLeft,	true,	"vndr_abbr_nm",         false,      "",      dfNone,			0,     true,       true);              
              InitDataProperty(0, cnt++ , dtData,   40,daCenter,	true,	"eq_tpsz_cd",	        false,      "",      dfNone,			0,     true,       true);
              
              for (var i = 0; i < pur_listCnt; i++){
	              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	true,	"cnsha_eq_qty",	        false,      "",      dfNullInteger, 	0,     true,       true);                                       
	              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_pur_prc",    	false,      "",      dfNullInteger, 	0,     true,       true);
	              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_pur_ut_prc",    	false,      "",      dfNullInteger, 	0,     true,       true);
	              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_dryg_amt",    	false,      "",      dfNullInteger, 	0,     true,       true);
	              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_ttl",    	    false,      "",      dfNullInteger, 	0,     true,       true);
	              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"cnsha_remark",    	    false,      "",      dfNone, 	0,     true,       true);
              }
              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	true,	"ttl_eq_qty", 		    false,      "",      dfNullInteger, 	    0,     true,       true);                                         
              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_pur_prc",    	    false,      "",      dfNullInteger, 	    0,     true,       true);
              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_pur_ut_prc",    	false,      "",      dfNullInteger, 	    0,     true,       true);
              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_dryg_amt",    	    false,      "",      dfNullInteger, 	    0,     true,       true);
              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_ttl", 		        false,      "",      dfNullInteger,		    0,     true,       true);
              InitDataProperty(0, cnt++ , dtData,   75,daRight,   	false,	"ttl_remark", 	        false,      "",      dfNullInteger,		    0,     true,       true);
         }
     }      
      
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction))
					if(sheetObj.id == "sheet1") {
						
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);						
						form.f_cmd.value = SEARCH;
						var sXml = sheetObj.GetSearchXml("EES_MST_0039GS.do" , FormQueryString(formObj));
						
						var pur_list = ComGetEtcData(sXml,"pur_list");
						head_pur_list = pur_list;
 			            formObj.head_pur_list.value = head_pur_list; 
 			            var strpur_listCd  = pur_list.split("|");
 			            
 			            ComConfigSheet (sheetObj );
 			            reinitsheet(sheetObj, strpur_listCd);
 			            ComEndConfigSheet(sheetObj);
 			            
 			            sheetObj.LoadSearchXml(sXml);
 			            ComOpenWait(false);
 			            
 			            for (var i = 0; i <= sheetObj.RowCount+2; i++)
 			                 sheetObj.RowHeight(i) = 0;
 			            
 			            //AVERAGE를 구한다.
 			            var lstcol = sheetObj.LastCol;
 			            
 			            for (var i = 3; i <= sheetObj.RowCount+2; i++){
 	 			            var divBoxcnt = 0;
 	 			            var divUnitcnt = 0;
 	 			            var divDragagecnt = 0;
 			            	
 			            	//BOX
 			            	for(var j = 4; j <= lstcol - 6;){
 			            	   var lbox = sheetObj.CellValue(i, j);
 			            	   if (lbox != "0" && lbox != "") divBoxcnt = divBoxcnt + 1;
 			            	   j = j + 6;
 			            	}
 			            	//UNIT
 			            	for(var j = 5; j <= lstcol - 6;){
  			            	   var lunit = sheetObj.CellValue(i, j);
  			            	   if (lunit != "0" && lunit != "" ) divUnitcnt = divUnitcnt + 1;
  			            	   j = j + 6;
  			            	}
 			            	//Dragage
 			            	for(var j = 6; j <= lstcol - 6;){
  			            	   var ldrg = sheetObj.CellValue(i, j);
  			            	   if (ldrg != "0" && ldrg != "" ) divDragagecnt = divDragagecnt + 1;
  			            	   j = j + 6;
  			            	}
 			            	
 			            	var avgBox = 0;
 			            	var avgUnit = 0;
 			            	var avgDragage = 0;
 			            	if (divBoxcnt != 0){
 			            		avgBox = parseInt(sheetObj.CellValue(i, lstcol-3)) / divBoxcnt;
 			            		sheetObj.CellValue(i, lstcol-3) = avgBox;
 			            	}
 			            	if (divUnitcnt != 0){
 			            		avgUnit = parseInt(sheetObj.CellValue(i, lstcol-2)) / divUnitcnt;
 			            		sheetObj.CellValue(i, lstcol-2) = avgUnit;
 			            	}
 			            	if (divDragagecnt != 0){
 			            		avgDragage = parseInt(sheetObj.CellValue(i, lstcol-1)) / divDragagecnt;
 			            		sheetObj.CellValue(i, lstcol-1) = avgDragage;
 			            	}
 			            	sheetObj.CellValue(i, lstcol) = avgBox + avgUnit + avgDragage;
 			            }
 			            sheetObj.ColHidden(lstcol) = true;
					}
			break;
			
			case IBSEARCH01:
				 form.cntr_tpsz_cd.RemoveAll();
	             form.f_cmd.value = SEARCH02;
	             var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do" , FormQueryString(formObj));
	 		     var chk = sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				    sheetObj.LoadSearchXml(sXml);
				    return;
			     }	             
	             
	             //TP/SZ 조회
	             var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");
	             head_cntr_tpsz_cd = cntr_tpsz_cd;
	             tot_cntr_tpsz_cd = cntr_tpsz_cd;
	             formObj.head_cntr_tpsz_cd.value = head_cntr_tpsz_cd; 
	             var strCntrTpszCd  = cntr_tpsz_cd.split("|");
	             
		         with (form.cntr_tpsz_cd) {
		        	 MultiSelect = true;
		             MultiSeparator = ",";
		        	 DropHeight = 270;
		        	 InsertItem(0 , 'ALL','ALL'); 
		        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
	  		        	 InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
		        	 }
		         }
			break;	
         }
     }
   
     /**
     * Calendar Display
     */
     function popCalendar(type,gubun){
    	 var formObj = document.form;    	 
         var cal = new ComCalendar();
         cal.setDisplayType('month');
         if (gubun == '0'){
            cal.select(formObj.bse_yrmon0, "yyyy-MM");
         } else if (gubun == '1'){
        	 cal.select(formObj.bse_yrmon1, "yyyy-MM"); 
         }
     }
   
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
	/* 개발자 작업  끝 */