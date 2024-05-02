/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0016.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.29 장창수
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
     * @class fns_tot_016 : fns_tot_016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0016() {
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
                 case "btn_retrieve":
                	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                     break;
                 
                 case "btn_new":
				 		setDate();
				 		setCloseYn();
				 		formObject.tong_calc_dat_tp_cd.CODE = "1";
				 		formObject.vsl_cd.value = "";
   				 		sheetObject1.RemoveAll();
                 break;
                      
                 case "btn_downexcel":
                	 sheetObject1.SpeedDown2Excel(-1);
                     break;   
                     
                 case "btn_save":
                	 doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;                                      
 				 case "btns_back":

	                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
	                	 ComShowCodeMessage('TOT00003');
	                	 return;
	                 }
	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M",-1).substring(0,7);
	                 setCloseYn();

					break;

				 case "btns_next":
					
	                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
	                	 ComShowCodeMessage('TOT00003');
	                	 return;
	                 }
	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M", 1).substring(0,7);
	                 setCloseYn();

				 break;     
				case "btn1_pop_vsl":

                     ComOpenPopup("/hanjin/COM_ENS_0A1.do", 618, 480, "getCOM_ENS_0A1_1", "1,0,1,1,1");
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
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
	}
    
	 /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage(codeinfoValue,codeinfoText,stlClzFlg) {

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(var k=0;k<comboObjects.length;k++){

             initCombo(comboObjects[k],k+1,codeinfoValue,codeinfoText);
	 
         }

         initControl();

         closing_yn = stlClzFlg;
         
     	 if(closing_yn == "Y"){
     		ComBtnDisable("btn_save");
     	 }else{
     		ComBtnEnable("btn_save");
     	 }

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
    	axon_event.addListener  ('blur'  , 'stl_yrmon_onblur', 'stl_yrmon');//- customer code 입력 후 name 가져오기
        axon_event.addListener  ('keyup', 'vsl_cd_keyup', 'vsl_cd');	
        axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    
        
    }
      
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
          ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
          ComClearSeparator(event.srcElement);
    }

    function obj_keypress(){
		switch(event.srcElement.dataformat){
		    case "ym":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		    case "engup":
		        
		         ComKeyOnlyAlphabet('upper');
		    break;			    
           
		}
	}        
	  
	function form_keyup(){
		ComKeyEnter('lengthnextfocus');
	} 		  
	 
    function getCOM_ENS_0A1_1(rowArray) {
      
         var colArray = rowArray[0];
         document.all.vsl_cd.value = colArray[3];
    }
    
    //stl_yr 변경시 조회 
    function stl_yrmon_onblur(){
      	
      	var formObject = document.form;

 		if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
 			
 			ComShowCodeMessage('TOT00003');
 			ComSetFocus(formObject.stl_yrmon);
 			
 			return false;
 		}

          setCloseYn();
    }

	//tong_calc_dat_tp_cd 변경시 조회 
	function tong_calc_dat_tp_cd_OnChange(idx_cd, text){
		 
		   var formObj = document.form;
	       formObj.vsl_cd.value = "";
    }
	 
    function setDate(){
    		var today=new Date();
    		var y = today.getFullYear().toString();
    		var m = today.getMonth();
    			
    		if(m<10){
    			m = "0"+m;
    		}
    		
    		document.form.stl_yrmon.value = y+"-"+m;    	
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
      		ComBtnDisable("btn_save");
      	 }else{
      		ComBtnEnable("btn_save");
      	 }
 		 sheetObjects[0].RemoveAll(); 
 		
    }   
 
		  
    function vsl_cd_keyup(){
  	    var formObject = document.form;

  	    if (formObject.vsl_cd.value.length == 4){
  	    	setVslYn();
  		}
  	}
    
    /*
     * 팝업으로 선박코드 입력시 해당 선박코드의 유무조회한다.  <br>
     */
       
    function setVslYn(){
      	 
      	 var formObj = document.form;
      	 var prefix = "sheet1_";
      	 formObj.f_cmd.value = SEARCHLIST01;
      	 
      	 //alert(formObj.vsl_cd.value);
      	 var sXml = sheetObjects[1].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

      	 
      	 if(ComGetEtcData(sXml,"vslEngNm") == ""){
  				 ComShowCodeMessage('TOT00012');
  				 //formObject.vsl_cd.value = "";
  				 ComSetFocus(formObj.vsl_cd);
  				 return;
      	 }
    
    }   

	function obj_keypress(){
			switch(event.srcElement.dataformat){
			    case "ym":
			        //숫자+"."입력하기
			        ComKeyOnlyNumber(event.srcElement, "-"); 
			    break;
		    
			}
	}
       
    /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
    function initCombo(comboObj, comboNo, codeinfoValue,codeinfoText) {
         var formObject = document.form
         
         switch(comboNo) {  
         	case 1: 
                with (comboObj) { 
     				MultiSelect = false; 
     				UseAutoComplete = true;	
     				SetColAlign("left|left");        
     				SetColWidth("0|115");
			
      				DropHeight = 160;
      		    }
          
                  var comboItemsValue = codeinfoValue.split("|");
                 var comboItemsText = codeinfoText.split("|");
                 
                 for (var i = 0; i<comboItemsValue.length; i++){
	                 // addComboItem(comboObj, i, comboItemsValue[i], comboItemsText[i]);    
	                  comboObj.InsertItem(i, comboItemsText[i] + "|" + comboItemsText[i], comboItemsValue[i]);
                 }
                 
                 comboObj.index = -1;
                 
                 var prefix = "sheet1_";

                 sheetObjects[0].InitDataCombo(0, prefix+"tong_calc_dat_tp_cd"     , codeinfoText, codeinfoValue);	

      			break; 

      	} 
    }

    /**
      * 콤보필드에 데이터를 추가해준다.
      */	
    function addComboItem(comboObj, i, comboItemsValue, comboItemsText) {
     
     		//alert("addComboItem ::::: "+i+"번째  "+comboItemsValue+"        "+comboItemsText);

     		comboObj.InsertItem(i, comboItemsText + "|" + comboItemsText, comboItemsValue);
     		
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
                     style.height = 380;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 10, 100);

                     var HeadTitle1 = "|Seq.|Data Type|BKG No|Lane|VVD|Loadable TEU|Actual TEU|BKG POL|BKG POD|DURATION|DURATION|DURATION|NRT|USE(%)|Taxable Amount|||||";
 		             var HeadTitle2 = "|Seq.|Data Type|BKG No|Lane|VVD|Loadable TEU|Actual TEU|BKG POL|BKG POD|VVD POL DATE|VVD POD DATE|Days|NRT|USE(%)|Taxable Amount|||||";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					 InitHeadRow(1, HeadTitle2, true);
                     
 					 var prefix = "sheet1_";
 					 
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			 InitDataProperty(0, cnt++, dtHiddenStatus,  0, daCenter, true, prefix+"ibflag"   );
                     InitDataProperty(0, cnt++, dtSeq,				35,			daCenter,		true,		"Seq");
                     InitDataProperty(0, cnt++, dtCombo,			80,			daCenter,		true,		prefix+"tong_calc_dat_tp_cd",			false,		"",       dfNone,			0,		false,		false,		3);
					 InitDataProperty(0, cnt++, dtData,			90,			daCenter,		true,		prefix+"bkg_no",				false,		"",       dfNone,			0,		false,		false,		13);
					 InitDataProperty(0, cnt++, dtData,			45,			daCenter,		true,		prefix+"slan_cd",					false,		"",       dfNone,			0,		false,		false,		3);
					 InitDataProperty(0, cnt++, dtData,			80,		daCenter,			true,		prefix+"vvd",					false,		"",       dfNone,			0,		false,		false,		9);
					 InitDataProperty(0, cnt++, dtData,			90,			daRight,		true,		prefix+"ldb_capa_qty",			false,		"",       dfInteger,	0,		false,		false,		5);
					 InitDataProperty(0, cnt++, dtData,			80,			daRight,		true,		prefix+"act_bsa_capa",				false,		"",       dfInteger,	0,		false,		false,		5);
					 InitDataProperty(0, cnt++, dtData,			65,			daCenter,		true,		prefix+"bkg_pol_cd",				false,		"",       dfNone,			0,		false,		false,		5);
					 InitDataProperty(0, cnt++, dtData,			65,			daCenter,		true,		prefix+"bkg_pod_cd",				false,		"",       dfNone,			2,		false,		false,		5);
					 InitDataProperty(0, cnt++, dtData,			90,			daCenter,		true,		prefix+"pol_dep_dt",				false,		"",       dfDateYmd,	0,		true,		true);
					 InitDataProperty(0, cnt++, dtData,			90,			daCenter,		true,		prefix+"pod_dep_dt",				false,		"",       dfDateYmd,	0,		true,		true);
					 InitDataProperty(0, cnt++, dtData,			40,			daRight,		true,		prefix+"voy_dys",					false,		"",       dfNone,			0,		false,		false);
					 InitDataProperty(0, cnt++, dtData,			55,			daRight,		true,		prefix+"nrt_wgt",					false,		"",       dfInteger,	0,		false,		false,		5);
					 InitDataProperty(0, cnt++, dtData,			60,			daRight,		true,		prefix+"usg_rt",					false,		"",       dfNullFloat,2,		false,		false,		2);
					 InitDataProperty(0, cnt++, dtData,			100,			daRight,		true,		prefix+"tong_tax_amt",		false,		"",       	dfInteger,	0,		false,		false,		7);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"stl_yrmon",		false,		"",       dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"vsl_cd",		false,		"",       dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"vvd_seq",		false,		"",       dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"tong_stl_bat_jb_seq",		false,		"",       dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"per_ton_rev",		false,		"",       dfNone,	0,	false,	false);
                
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

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 10, 100);

                 var HeadTitle1 = "|Seq.|Data Type|BKG No|Lane|VVD|Loadable TEU|Actual TEU|BKG POL|BKG POD|DURATION|DURATION|DURATION|NRT|USE(%)|Taxable Amount|||||";
		             var HeadTitle2 = "|Seq.|Data Type|BKG No|Lane|VVD|Loadable TEU|Actual TEU|BKG POL|BKG POD|VVD POL DATE|VVD POD DATE|Days|NRT|USE(%)|Taxable Amount|||||";

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
					 InitHeadRow(1, HeadTitle2, true);
                 
					 var prefix = "sheet2_";
					 
                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     			 InitDataProperty(0, cnt++, dtStatus,  0, daCenter, true, prefix+"ibflag"   );
                 InitDataProperty(0, cnt++, dtSeq,				35,			daCenter,		true,		"Seq");
                 InitDataProperty(0, cnt++, dtCombo,			65,			daCenter,		true,		prefix+"tong_calc_dat_tp_cd",			false,		"",       dfNone,			0,		false,		false,		3);
				 InitDataProperty(0, cnt++, dtData,			95,			daCenter,		true,		prefix+"bkg_no",				false,		"",       dfNone,			0,		false,		false,		13);
				 InitDataProperty(0, cnt++, dtData,			45,			daCenter,		true,		prefix+"slan_cd",					false,		"",       dfNone,			0,		false,		false,		3);
				 InitDataProperty(0, cnt++, dtData,			85,		daCenter,			true,		prefix+"vvd",					false,		"",       dfNone,			0,		false,		false,		9);
				 InitDataProperty(0, cnt++, dtData,			95,			daCenter,		true,		prefix+"ldb_capa_qty",			false,		"",       dfInteger,	0,		false,		false,		5);
				 InitDataProperty(0, cnt++, dtData,			80,			daCenter,		true,		prefix+"act_bsa_capa",				false,		"",       dfInteger,	0,		false,		false,		5);
				 InitDataProperty(0, cnt++, dtData,			65,			daCenter,		true,		prefix+"bkg_pol_cd",				false,		"",       dfNone,			0,		false,		false,		5);
				 InitDataProperty(0, cnt++, dtData,			65,			daRight,		true,		prefix+"bkg_pod_cd",				false,		"",       dfNone,			2,		false,		false,		5);
				 InitDataProperty(0, cnt++, dtData,			90,			daRight,		true,		prefix+"pol_dep_dt",				false,		"",       dfDateYmd,	0,		true,		true);
				 InitDataProperty(0, cnt++, dtData,			90,			daRight,		true,		prefix+"pod_dep_dt",				false,		"",       dfDateYmd,	0,		true,		true);
				 InitDataProperty(0, cnt++, dtData,			40,			daRight,		true,		prefix+"voy_dys",					false,		"",       dfNone,			0,		false,		false);
				 InitDataProperty(0, cnt++, dtData,			55,			daRight,		true,		prefix+"nrt_wgt",					false,		"",       dfInteger,	0,		false,		false,		5);
				 InitDataProperty(0, cnt++, dtData,			60,			daRight,		true,		prefix+"usg_rt",					false,		"",       dfNullFloat,2,		false,		false,		2);
				 InitDataProperty(0, cnt++, dtData,			100,			daRight,		true,		prefix+"tong_tax_amt",		false,		"",       	dfInteger,	0,		false,		false,		7);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"stl_yrmon",		false,		"",       dfNone,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"vsl_cd",		false,		"",       dfNone,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"vvd_seq",		false,		"",       dfNone,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"tong_stl_bat_jb_seq",		false,		"",       dfNone,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"per_ton_rev",		false,		"",       dfNone,	0,	false,	false);
            
           }
             break;
                 
         }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
             case IBSEARCH:      //조회
	             if (validateForm(sheetObj, formObj, sAction)){
		            	
	                 if ( sheetObj.id == "sheet1"){
	     				formObj.f_cmd.value = SEARCH;
	     				 	//prefix 문자열 배열
	     				var prefix = "sheet1_";
		    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0016GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
	
		    			sheetObjects[0].LoadSearchXml(sXml);
		    			var dsum= sheetObjects[0].SumValue(5,"voy_dys");
		    			
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
				    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0016GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				    			sheetObj.LoadSaveXml(sXml);
	
				    			ComOpenWait(false);
				    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
				    		}
		              }              
                 break;
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
					if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
  						ComShowCodeMessage('TOT00003');
  						ComSetFocus(formObject.stl_yrmon);
  						return false;
  					}
				    if (formObject.tong_calc_dat_tp_cd.CODE ==null || formObject.tong_calc_dat_tp_cd.CODE ==""){
				    	ComShowCodeMessage('TOT00055');
					    ComSetFocus(formObject.tong_calc_dat_tp_cd);
					    return false;
				    }
				    if (formObject.vsl_cd.value ==null || formObject.vsl_cd.value ==""){
				    	ComShowCodeMessage('TOT00054');
					    ComSetFocus(formObject.vsl_cd);
					    return false;
				    }				    
				break;
			    case IBSAVE:   //저장
					for(var inx=1; inx<=sheetObj.LastRow; inx++){
						//수정되지 않은 값은 skip
						if (sheetObj.CellValue(inx,prefix+"ibflag")=="R"){
							continue;
						}
	
						if (sheetObj.CellValue(inx,prefix+"pol_dep_dt").length < 8){
							ComShowCodeMessage('TOT00056');
							sheetObj.SelectCell(inx,prefix+"pol_dep_dt",true);
							return false;
						}
						
						if (sheetObj.CellValue(inx,prefix+"pod_dep_dt").length < 8){
							ComShowCodeMessage('TOT00057');
							sheetObj.SelectCell(inx,prefix+"pod_dep_dt",true);
							return false;
						}
						
					}			   
			    break;
 			    default:
 				break;
 		 }
 		 return true;

    }
     
   
    function sheet1_OnChange(sheetObj,Row, Col, Value){     

  	   	 var prefix = "sheet1_";
  		 var sName = sheetObj.ColSaveName(Col);
  		 
  		 if(sName == (prefix+"pol_dep_dt")){
  			
  			//alert("Col : "+Col+"  Row : "+Row+"  Value : "+Value);
		    if (sheetObj.CellValue(Row,prefix+"pol_dep_dt").length < 8){
		    	ComShowCodeMessage('TOT00056');
				sheetObj.SelectCell(Row,prefix+"pol_dep_dt",true);
				return false;
			} 
		    
  	       	if (sheetObj.CellValue(Row,prefix+"pod_dep_dt") != "" && (sheetObj.CellValue(Row,prefix+"pol_dep_dt")> sheetObj.CellValue(Row,prefix+"pod_dep_dt"))){
  	       	ComShowCodeMessage('TOT00058');
  				sheetObj.CellValue2(Row,Col) = "";
  				sheetObj.SelectCell(Row,prefix+"pol_dep_dt",true);
  				return false;
  			}
  		 }else if(sName ==  (prefix+"pod_dep_dt")){
  			    if (sheetObj.CellValue(Row,prefix+"pod_dep_dt").length < 8){
  			    	ComShowCodeMessage('TOT00057');
  					sheetObj.SelectCell(Row,prefix+"pod_dep_dt",true);
  					return false;
  				} 
  	        	if (sheetObj.CellValue(Row,prefix+"pod_dep_dt") != "" && (sheetObj.CellValue(Row,prefix+"pol_dep_dt")> sheetObj.CellValue(Row,prefix+"pod_dep_dt"))){
  	        		ComShowCodeMessage('TOT00059');
  					sheetObj.CellValue2(Row,Col) = "";
  					sheetObj.SelectCell(Row,prefix+"pod_dep_dt",true);
  					return false;
  				}    		 
  		 }
  		 

        if(sName == (prefix+"pol_dep_dt") || sName == (prefix+"pod_dep_dt")){
        	
            // 변경된 날짜로 일수계산
      		//Days = DURATION VVD POD DATE - DURATION VVD POL DATE 
	        var pol_dep_dt = sheetObj.CellValue(Row,prefix+"pol_dep_dt")
	        var pod_dep_dt = sheetObj.CellValue(Row,prefix+"pod_dep_dt")
	        pol_dep_dt = pol_dep_dt.substring(0,4)+"-"+pol_dep_dt.substring(4,6)+"-"+pol_dep_dt.substring(6,8);
	        pod_dep_dt = pod_dep_dt.substring(0,4)+"-"+pod_dep_dt.substring(4,6)+"-"+pod_dep_dt.substring(6,8);
	
	  		sheetObj.CellValue2(Row,prefix+"voy_dys") = ComGetDaysBetween(pol_dep_dt,pod_dep_dt);

  	        //Taxable Amount 계산 : 1. 사용율을 구한다. USE(%) = Actual TEU / Loadable TEU
            //2. Taxable Amount = Round( (NRT / 1276) * 톤수 표준이익 * Days * USE(%), 0 )
            var load_teu = sheetObj.CellValue(Row,prefix+"ldb_capa_qty");
            var act_teu = sheetObj.CellValue(Row,prefix+"act_bsa_capa");
            var use = ComRound(load_teu/act_teu,0);
            var nrt = sheetObj.CellValue(Row,prefix+"nrt_wgt"); 
            
            var per_ton_rev = sheetObj.CellValue(Row,prefix+"per_ton_rev");
            var days = sheetObj.CellValue(Row,prefix+"voy_dys");
            //alert("use : "+use+"  per_ton_rev : "+per_ton_rev+" nrt : "+nrt);
	  		var tax_amt = ComRound((nrt/1276)*per_ton_rev*days*ComRound((act_teu/load_teu),6),0);
	  		 //alert("tax_amt : "+tax_amt);
	  		sheetObj.CellValue2(Row,prefix+"tong_tax_amt") = tax_amt;
        }
    }    
