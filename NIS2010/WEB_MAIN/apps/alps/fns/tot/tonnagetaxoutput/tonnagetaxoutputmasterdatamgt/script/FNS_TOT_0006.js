/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_006.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.04 장창수
* 1.0 Creation
* ======================================================== 
* History
* 2012.01.27 [CHM-201113807-01] 이준범
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
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
     * @class fns_tot_006 : fns_tot_006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0006() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var closing_yn = "N";
    var comboObjects = new Array();
    var comboCnt = 0;

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
              	
 							case "btn1_If":
 								doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
 							break;
 							
 							case "btn2_Recalculated":
 					   			var stlYrmon = formObject.stl_yrmon.value;
 								var param    = "stl_yrmon="+stlYrmon+"&f_cmd=" + SEARCH;
 					   			var url      = "FNS_TOT_0028.do?"+param;
 					   		    var winName  = "FNS_TOT_0028";
 					   		
 					   			ComOpenWindowCenter(url, winName, 600, 370, false);
 							break;
 					   		
 							case "btn2_LaneCheck":
 					   			var stlYrmon = formObject.stl_yrmon.value;
 								var param    = "stl_yrmon="+stlYrmon+"&f_cmd=" + SEARCH;
 					   			var url      = "FNS_TOT_0029.do?"+param;
 					   		    var winName  = "FNS_TOT_0029";
 					   		
 					   			ComOpenWindowCenter(url, winName, 400, 370, false);
 							break;
 							
 							case "btn1_Delete":
 								doActionIBSheet(sheetObject1,formObject,IBDELETE);
 							break;
 							
 							case "btn1_Save":
 								doActionIBSheet(sheetObject1,formObject,IBSAVE);
 							break;
 							
 			 				case "btns_back":
 			 				    
 				                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
 				                	ComShowCodeMessage('TOT00003');
 				                	 return;
 				                 }
 				                 
 				                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M",-1).substring(0,7);
 				                 document.form.rc_dt.value = "";
 				                  setCloseYn();
 				                break;

 							case "btns_next":
 								
 				                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
 				                	ComShowCodeMessage('TOT00003');
 				                	 return;
 				                 }
 				                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M", 1).substring(0,7);
 				                 document.form.rc_dt.value = "";
 				                 setCloseYn();
			                 
 							break;
 							case "btn1_Down_Excel":
 				                 
 								sheetObject1.SpeedDown2Excel(-1);
			                break;
						
 							case "btn1_Retrieve":
 								doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 							break;
       
             } 
         }catch(e) {
             if( e == "[object Error]") {
            	 ComShowMessage(OBJECT_ERROR);
             } else {
            	 ComShowMessage(e);
             }
         }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	*/
    function loadPage(bsaTrdList,stlClzFlg) {
        //alert("load...");
         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1,bsaTrdList);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         initCombo(comboObjects[0],1,bsaTrdList);

         
         initControl();
        
         closing_yn = stlClzFlg;
         var formObj = document.form
         
  		if(closing_yn == "Y"){
// 			ComBtnDisable("btn2_Recalculated");
 			ComBtnDisable("btn1_If");
 			ComBtnDisable("btn1_Save");
 			ComBtnDisable("btn1_Delete");
 		}else{
 		    if(formObj.strUsr_id.value == "0510142" || formObj.strUsr_id.value == "2007803"){
// 		    	ComBtnEnable("btn2_Recalculated");
 		    }else{
// 		    	ComBtnDisable("btn2_Recalculated");
 		    }
 			
 			ComBtnEnable("btn1_If");
 			ComBtnEnable("btn1_Save");
 			ComBtnEnable("btn1_Delete");
 		}

    }
  	/** 
  	 * IBCombo Object를 배열로 등록
  	 * param : combo_obj ==> 콤보오브젝트
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */ 
  	function setComboObject(combo_obj) {  
  	    comboObjects[comboCnt++] = combo_obj;  
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
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
 	  
	   	//** Date 구분자 **/
	   	DATE_SEPARATOR = "-";
	   	var formObject = document.form;
	   	
	      //Axon 이벤트 처리1. 이벤트catch
	  	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	  	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress','obj_keypress', formObject); 
        axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    

		axon_event.addListener  ('blur'  , 'stl_yrmon_onblur', 'stl_yrmon');//- customer code 입력 후 name 가져오기

    }
     
     //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
       ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
           ComClearSeparator(event.srcElement);
    }

	 function form_keyup(){
  		ComKeyEnter('lengthnextfocus');
    } 
	  
    function obj_keypress(){
		switch(event.srcElement.dataformat){
		    case "ym":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		}
	} 
    
    //trd_cd 변경시 조회 
    function trd_cd_OnChange(idx_cd, text){
    	//alert("trd_cd_OnChange");
    	 var formObject = document.form;
   	    document.form.rc_dt.value = "";
    	sheetObjects[0].RemoveAll(); 
	
    }
    
    //stl_yr 변경시 조회 
    function stl_yrmon_onblur(){
   	//alert("stl_yrmon_onblur");
   	    var formObject = document.form;

  		if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
  			
  			ComShowCodeMessage('TOT00003');
  			ComSetFocus(formObject.stl_yrmon);
  			
  			return false;
  		}

       setCloseYn();
  
    }
   
    function sheet1_OnChange(sheetObj,Row, Col, Value){  

	   	 var prefix = "sheet1_";
	   	 var sName = sheetObj.ColSaveName(Col);
	   	 
	   	 if(sName ==  (prefix+"modi_flg")){
	   		 
	   		 if(sheetObj.CellValue(Row, prefix+"modi_flg")== "1" ){
	   			sheetObj.CellEditable(Row,prefix+"ldb_capa_qty") = true;
	   			// 2010.06.01 권상준 수정(fnl_hjs_bsa_capa 금액은 무조건 수정가능하도록 수정)
	   			sheetObj.CellEditable(Row,prefix+"fnl_hjs_bsa_capa") = true;
//	   			if(sheetObj.CellValue(Row,prefix+"fnl_hjs_bsa_capa") == 0){
//	   				sheetObj.CellEditable(Row,prefix+"fnl_hjs_bsa_capa") = true;
//	   			}else{
//	   				sheetObj.CellEditable(Row,prefix+"fnl_hjs_bsa_capa") = false;
//	   			}
	   		 }else{
	   			sheetObj.CellEditable(Row,prefix+"ldb_capa_qty") = false;
	   			sheetObj.CellEditable(Row,prefix+"fnl_hjs_bsa_capa") = false;
	   		 }
	   	 }	
    }           
   /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
    */ 
    function initCombo(comboObj, comboNo, bsaList) {
          var formObject = document.form
 
          switch(comboNo) {  
          	case 1: 
                 with (comboObj) { 
      				MultiSelect = false; 
      				UseAutoComplete = true;	
      				SetColAlign("left|left");        
      				SetColWidth("0|30");
					
       				DropHeight = 160;
       		      }
                   //alert(comboItemsValue);
                   var comboItemsValue = bsaList.split("|");
                   var comboItemsText = bsaList.split("|");
                   
                   //alert("길이 : "+comboItemsValue.length);
                   for (var i = 0; i<=comboItemsValue.length; i++){
                	   
                	   
                	   if(i==0){
                		  // addComboItem(comboObj, 0, "ALL", " "); 
                		   comboObj.InsertItem(i, "" + "|" + "", "ALL");
                	   }else{
                		  // alert("가기전 : "+comboItemsValue[i-1]);
                		   comboObj.InsertItem(i, comboItemsText[i-1] + "|" + comboItemsText[i-1], comboItemsValue[i-1]);
	                      //addComboItem(comboObj, i, comboItemsValue[i-1], comboItemsText[i-1]); 
                	   }
                   }
                  
                   comboObj.index = 0;
       	      break; 
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
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 400;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     
                     var prefix = "sheet1_";
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 10, 100);

                     var HeadTitle1 = "|Seq.|Trade|Lane|Vessel|Voyage\nNumber|Direction\nCode|NRT|ITC|Declared\nCAPA|Previous Month\nCAPA|BSA|BSA|BSA|Modify\nFlag||";
                 	 var HeadTitle2 = "|Seq.|Trade|Lane|Vessel|Voyage\nNumber|Direction\nCode|NRT|ITC|Declared\nCAPA|Previous Month\nCAPA|TOT|BSA SYS|DIFF|Modify\nFlag||";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 										InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				 InitDataProperty(0, cnt++, dtHiddenStatus,  0,     daCenter, true, prefix+"ibflag"   );
                 InitDataProperty(0, cnt++, dtSeq,		30,			daCenter,	true,	prefix+"seq",		false,		"",       dfNone,	0,	false,	false);
                 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"trd_cd",	false,		"",       dfNone,	0,	false,	false);
		 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"slan_cd",		false,		"",       dfNone,	0,	false,	false);
		 										
		 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"vsl_cd",	false,		"",       dfNone,	0,	false,	false); 
		 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"skd_voy_no",	false,		"",       dfNone,	0,	false,	false); 
		 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"skd_dir_cd",	false,		"",       dfNone,	0,	false,	false);
		 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"nrt_wgt",		false,		"",       dfInteger,	2,	false,	false);
		 		 InitDataProperty(0, cnt++, dtCombo,	40,			daCenter,	true,	prefix+"intl_tong_certi_flg",		false,		"",       dfNone,	0,	false,	false);
		
		 		 InitDataProperty(0, cnt++, dtData,		100,		daRight,	true,	prefix+"ldb_capa_qty",	false,		"",       dfInteger,	0,	false,	false);
		 		 InitDataProperty(0, cnt++, dtData,		100,		daRight,	true,	prefix+"prev_ldb_capa_qty",	false,		"",       dfInteger,	0,	false,	false);
		 		 InitDataProperty(0, cnt++, dtData,		90,			daRight,	true,	prefix+"fnl_hjs_bsa_capa",	false,		"",       dfInteger,	0,	false,	false);
		 		 InitDataProperty(0, cnt++, dtData,		90,			daRight,	true,	prefix+"fnl_hjs_coa_capa",	false,		"",       dfInteger,	0,	false,	false);
		 		 InitDataProperty(0, cnt++, dtData,		90,			daRight,	true,	prefix+"diff",	false,		"",       dfInteger,	0,	false,	false);
                 InitDataProperty(0, cnt++, dtCheckBox,	40,			daCenter,	true,	prefix+"modi_flg");
				 InitDataProperty(0, cnt++, dtHidden,	 0,		    daCenter,	true,	prefix+"stl_yrmon",		false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,  	 0,		    daCenter,	true,	prefix+"tong_stl_bat_jb_seq",		false,		"",       dfNone);

				 InitDataCombo(0, prefix+"intl_tong_certi_flg"     , "Y|N", "Y|N");	

                 }
                 break;
             case 2:      // t1sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 0;
                 
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;
                 
                 var prefix = "sheet2_";
                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 10, 100);

                 var HeadTitle1 = "|Seq.|Trade|Lane|Vessel|Voyage\nNumber|Direction\nCode|NRT|ITC|Declared\nCAPA|BSA|BSA|BSA|COA BSA Information|COA BSA Information|COA BSA Information|Modify\nFlag||";
             	 var HeadTitle2 = "|Seq.|Trade|Lane|Vessel|Voyage\nNumber|Direction\nCode|NRT|ITC|Declared\nCAPA|HJS OWN|Space\nCharter|HJS Total|HJS OWN|Space\nCharter|HJS Total|Modify\nFlag||";

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
										InitHeadRow(1, HeadTitle2, true);

                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				 InitDataProperty(0, cnt++, dtStatus,  0, daCenter, true, prefix+"ibflag"   );
             InitDataProperty(0, cnt++, dtSeq,		40,			daCenter,	true,	prefix+"seq",		false,		"",       dfNone,	0,	false,	false);
             InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"trd_cd",	false,		"",       dfNone,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"slan_cd",		false,		"",       dfNone,	0,	false,	false);
	 										
	 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"vsl_cd",	false,		"",       dfNone,	0,	false,	false); 
	 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"skd_voy_no",	false,		"",       dfNone,	0,	false,	false); 
	 		 InitDataProperty(0, cnt++, dtData,		60,			daCenter,	true,	prefix+"skd_dir_cd",	false,		"",       dfNone,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		50,			daRight,	true,	prefix+"nrt_wgt",		false,		"",       dfInteger,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtCombo,		60,			daCenter,	true,	prefix+"intl_tong_certi_flg",		false,		"",       dfNone,	0,	false,	false);
	
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"ldb_capa_qty",	false,		"",       dfInteger,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"fnl_hjs_bsa_capa",	false,		"",       dfInteger,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"crr_bsa_capa",	false,		"",       dfInteger,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"tong_bsa_capa",	false,		"",       dfInteger,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"fnl_hjs_coa_capa",	false,		"",       dfInteger,	0,	false,	false);
	
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"crr_coa_capa",	false,		"",       dfInteger,	0,	false,	false);
	 		 InitDataProperty(0, cnt++, dtData,		70,			daRight,	true,	prefix+"tong_coa_capa",	false,		"",       dfInteger,	0,	false,	false);
             InitDataProperty(0, cnt++, dtCheckBox,  	40,			daCenter,	true,	prefix+"modi_flg");
			 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"stl_yrmon",		false,		"",       dfNone);
			 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"tong_stl_bat_jb_seq",		false,		"",       dfNone);

			 InitDataCombo(0, prefix+"intl_tong_certi_flg"     , "Y|N", "Y|N");	

             }
             break;
                 
         }
    }
      
    /*
     * 조건 년도가 마감 되었는지 여부를  조회하여 저장버튼을 활성또는 비활성 한다.
     */

    function setCloseYn(){
     	
     	var formObj = document.form;
     	var stlYr = formObj.stl_yrmon.value;

     	formObj.f_cmd.value = SEARCHLIST02;
     	formObj.stl_yr.value = stlYr.substr(0,4);

 		var sXml = sheetObjects[1].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj));

 		closing_yn = ComGetEtcData(sXml,"stlClzFlg");
 		
 		if(closing_yn == "Y"){
// 			ComBtnDisable("btn2_Recalculated");
 			ComBtnDisable("btn1_If");
 			ComBtnDisable("btn1_Save");
 			ComBtnDisable("btn1_Delete");
 		}else{
 			if(formObj.strUsr_id.value == "0510142" || formObj.strUsr_id.value == "2007803"){
// 				ComBtnEnable("btn2_Recalculated");
 			}else{
// 				ComBtnDisable("btn2_Recalculated");
 			}
 			ComBtnEnable("btn1_If");
 			ComBtnEnable("btn1_Save");
 			ComBtnEnable("btn1_Delete");
 		}
 		
 		sheetObjects[0].RemoveAll(); 
    }   

     // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         var prefix = "sheet1_";
         switch(sAction) {
             case IBSEARCH:      //조회
	             if (validateForm(sheetObj, formObj, sAction)){
		             	
	                 if ( sheetObj.id == "sheet1"){
	     				formObj.f_cmd.value = SEARCH;
	     				 	//prefix 문자열 배열
	
		    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0006GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
	
		    			sheetObjects[0].LoadSearchXml(sXml);
		    			
 			    	   for(var i=1; i<=sheetObjects[0].RowCount; i++){
 			    		   if(sheetObjects[0].CellValue(i, prefix+"modi_flg") ){
 			    			  sheetObjects[0].CellEditable(i,prefix+"ldb_capa_qty") = true;
 			    			  // 2010.06.01 권상준 수정(fnl_hjs_bsa_capa 금액은 무조건 수정가능하도록 수정)
 			    			 sheetObjects[0].CellEditable(i,prefix+"fnl_hjs_bsa_capa") = true;
// 			    			  if(sheetObjects[0].CellValue(i,prefix+"fnl_hjs_bsa_capa") == 0){
// 			    				 sheetObjects[0].CellEditable(i,prefix+"fnl_hjs_bsa_capa") = true;
// 				   			  }
 			    		   }
                       }
 			    	    
		    			formObj.rc_dt.value = ComGetEtcData(sXml,"recentDt");
		    			
		    			
	                 }
	                 
	             }
                 break;

              case IBSAVE:        //저장
	              if(closing_yn == "N"){
			     		if (validateForm(sheetObj, formObj, sAction)){
			     			
			     					
			     			var SaveStr = ComGetSaveString(sheetObjects);
			    			if (SaveStr == ""){
			    				ComShowCodeMessage('TOT00011');
			    				return;
			    			}

		 			    	   
			    			if (!ComShowCodeConfirm('TOT00004')){
			    				return;
			    			}

		                	sheetObj.WaitImageVisible=false;
		                	ComOpenWait(true);
		                	
			    			formObj.f_cmd.value = MULTI;
			    			
	
			    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
			    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0006GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			    			sheetObj.LoadSaveXml(sXml);
			    			ComOpenWait(false);
			    			
			    		}
	            }
              
                 break;

             case IBDELETE:      // 삭제
                 if(closing_yn == "N"){
		             if (validateForm(sheetObj, formObj, sAction)){
			             
		    			if (!ComShowCodeConfirm('TOT00025')){
		    				return;
		    			}
		                 if ( sheetObj.id == "sheet1"){

		                	sheetObj.WaitImageVisible=false;
		                	ComOpenWait(true);
		     				formObj.f_cmd.value = REMOVE01;
		     				 	//prefix 문자열 배열
		
			    			var sXml = sheetObjects[0].GetSaveXml("FNS_TOT_0006GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
			    			sheetObjects[0].LoadSaveXml(sXml);
			    			ComOpenWait(false);
			    			
		                 }
		                 
		             }
                 }

                 break;
	             case IBSEARCH_ASYNC01:      // I/F
	                 if(closing_yn == "N"){
			             if (validateForm(sheetObj, formObj, sAction)){
	
			     			formObj.f_cmd.value = SEARCH01;
		     				 	//prefix 문자열 배열
		
			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0006GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
			    			var delCnt = ComGetEtcData(sXml,"delCnt");
	                        //alert("delCnt ::: "+delCnt);
	                        
	                        if(ComParseInt(delCnt)>0){
	                        	ComShowCodeMessage('TOT00026');
	                        	return;
	                        }
			    			 if (!ComShowCodeConfirm('TOT00027')){
			    				 return;
			    			 }
			    			
			                 if ( sheetObj.id == "sheet1"){
			     				formObj.f_cmd.value = MULTI01;
			     				 	//prefix 문자열 배열
			     				
				    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0006GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
				    			sheetObj.LoadSaveXml(sXml);

				    			var backendJobKey = ComGetEtcData(sXml,"KEY"); 
				    			//var cdata = ComGetEtcData(sXml,"CDATA"); 
				    			//alert("backendJobKey :: "+backendJobKey);
				    			//alert("cdata :: "+cdata);
								if (backendJobKey.length > 0) {
									formObj.back_end_job_key.value = backendJobKey;
									sheetObj.WaitImageVisible = false;
									
									ComOpenWait(true);			
									getBackEndJobStatus();
									sheetObj.RequestTimeOut = 10000;
									timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
								

								}
								 
			                 }
			                
			             }
	                 }
	             break;
	             case IBSEARCH_ASYNC02:        //tax recalculated
	              if(closing_yn == "N"){
			     		if (validateForm(sheetObj, formObj, sAction)){
			    			
		                	sheetObj.WaitImageVisible=false;
		                	ComOpenWait(true);
		                	
			    			formObj.f_cmd.value = MULTI02;
	
			    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
			    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0006GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			    			ComOpenWait(false);
			    			
			    			formObj.f_cmd.value = SEARCH;

		     				var fXml = sheetObj.GetSearchXml("FNS_TOT_0006GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		     				sheetObjects[0].LoadSearchXml(fXml);
		     				formObj.rc_dt.value = ComGetEtcData(fXml,"recentDt");
			    		}
	            }
              
                 break;        
              
                 
         }
    }

    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
    */
    function getBackEndJobStatus() {
    	// sheet1
    	var formObj = document.form;
    	 var sheetObject1 = sheetObjects[0];
    	formObj.f_cmd.value = SEARCH03;
    	var sXml = sheetObject1.GetSearchXml("TOTCommonGS.do", FormQueryString(formObj),-1,false);
    	sheetObject1.LoadSearchXml(sXml);
    	var arrXml = sXml.split("|$$|");
    	var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
    	var jobCdata = ComGetEtcData(arrXml[0], "jb_cdata");
     
    	if(jobState == "3") {
        	//alert("jobState 3인 경우: "+jobState);
    		if(jobCdata =="nodata"){
    			ComShowCodeMessage('TOT00080');
    		}
    		ComOpenWait(false);
			clearInterval(timer);

         	doActionIBSheet(sheetObject1, formObj, IBSEARCH);     	
        } else if(jobState == "0") {
        	//ComShowCodeMessage('GEM00001',"BackEndJob관련");
        	//alert("jobState 0인 경우: "+jobState);
        	clearInterval(timer);
        	ComOpenWait(false);
        }
    	
    }
    
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
     		sheetObj.ShowDebugMsg = false;
     		var formObject = document.form;
     		var prefix="sheet1_";
     		switch (sAction) {

  			
  			    case IBSEARCH: //조회
				    if (formObject.trd_cd.Code ==null || formObject.trd_cd.Code ==""){
					    ComShowCodeMessage('TOT00006');
					    ComSetFocus(formObject.trd_cd);
					    return false;
				    }		
  				break;
  			    case IBSAVE: //저장


		    	   for(var i=1; i<=sheetObj.RowCount; i++){
		    		   if(sheetObj.CellValue(i, prefix+"modi_flg") ){
		    			   
		    			  if(sheetObj.CellValue(i,prefix+"ldb_capa_qty") == 0){
		    				  ComShowCodeMessage('TOT00083');
		    				  sheetObj.SelectCell(i,prefix+"ldb_capa_qty",true);
		    				  return false;
			   			  }
		    			  // 2010.06.04 권상준 수정 (TOT BSA의 값을 0으로 하여 저장할 수 있게끔 변경)
		    			  //if(sheetObj.CellValue(i,prefix+"fnl_hjs_bsa_capa") == 0){
		    			  //	  ComShowCodeMessage('TOT00083');
		    			  //	  sheetObj.SelectCell(i,prefix+"fnl_hjs_bsa_capa",true);
		    			  //	  return false;
			   			  //}
		    		   }
                   }
  			    
 				break;

  			    case IBSEARCH_ASYNC01: //  I/F
  		 		
 				break;

     			case IBDELETE:   //삭제
     			    var lstRow = sheetObjects[0].LastRow;
     		
     			    if(lstRow == 1 || (lstRow==2 && sheetObjects[0].CellValue(lstRow,prefix+"trd_cd").length == 0)){
     			    	ComShowCodeMessage('TOT00028');
     			    	return false;
     			    }
     				break;
     				
     			default:
     				break;
     		}
     		return true;

    }
      
    function tax_recalculated() {

    	var sheetObject1 = sheetObjects[0];        
        var formObject   = document.form;
        
    	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
	}
