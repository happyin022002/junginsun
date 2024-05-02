/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6031.js
*@FileTitle : CM,OP Summary And Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.10 송민석
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
     * @class ESM_PRI_6031 : ESM_PRI_6031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6031() {
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
 var BACKEND_JOB_ID  = "";
 var TIMER_ID = "";

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	 /** 
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  *
	  * @return 없음
	  */ 
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");    
 

            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }                       
            
     		var sheetIdx = 0;
 			switch(srcName) {
 				case "btn1_Row_Add":
 					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                    break; 
 				case "btn2_Row_Add":
 					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
                    break; 
 				case "btn3_Row_Add":
 					doActionIBSheet(sheetObjects[2],document.form,IBINSERT);
                    break; 
 				case "btn4_Row_Add":
 					doActionIBSheet(sheetObjects[3],document.form,IBINSERT);
                    break; 
 				case "btn5_Row_Add":
 					doActionIBSheet(sheetObjects[4],document.form,IBINSERT);
                    break; 
                     
 				case "btn1_Row_Copy":
 					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
                    break; 
 				case "btn2_Row_Copy":
 					doActionIBSheet(sheetObjects[1],document.form,IBCOPYROW);
                    break; 
 				case "btn3_Row_Copy":
 					doActionIBSheet(sheetObjects[2],document.form,IBCOPYROW);
                    break; 
 				case "btn4_Row_Copy":
 					doActionIBSheet(sheetObjects[3],document.form,IBCOPYROW);
                    break; 
 				case "btn5_Row_Copy":
 					doActionIBSheet(sheetObjects[4],document.form,IBCOPYROW);
                    break; 
 				case "btn1_Row_Delete":
 					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
                    break; 
 				case "btn2_Row_Delete":
 					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
                    break; 
 				case "btn3_Row_Delete":
 					doActionIBSheet(sheetObjects[2],document.form,IBDELETE);
                    break; 
 				case "btn4_Row_Delete":
 					doActionIBSheet(sheetObjects[3],document.form,IBDELETE);
                    break; 
 				case "btn5_Row_Delete":
 					doActionIBSheet(sheetObjects[4],document.form,IBDELETE);
                    break; 
                    
 				case "btn1_OK":
 					doActionIBSheet(sheetObjects[5],document.form,IBSEARCH);
                    break; 
 				case "btn1_Close":
 					self.close();
                    break;
 				
             } // end switch
     	}catch(e) {
    			ComShowMessage(e);
     	}
     }

     /** 
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      *
      * @param  {object}   sheet_obj 필수, sheet Object
      * @return 없음
      */ 
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     /** 
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * 
      * @return 없음
      */ 
     function loadPage() {
    	//jsp에 정의된 변수임.
    	  customerTypeValue = ComReplaceStr(customerTypeValue,"|M",""); 
    	  customerTypeText = ComReplaceStr(customerTypeText,"|ALL","");  
    	  customerTypeText = " |"+customerTypeText
    	  customerTypeValue = "M|"+customerTypeValue
    	  //파라메터의 초기화
     	 initParams();
 
         for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
 
             initSheet(sheetObjects[i],i+1);
 			//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 			
         }
 
         // 메인화면에서 조회 조건에 route 커럼이 있다면 
         // simulation화면에서는 readonly로 입력 불가하게 만듦
         showColsOfSheet();
         //event의 초기화
         initControl();
         //두번째 파라메터에 해당하는 sheet를 보이거나 숨김
         displaySheet(document.all.item("sheetLayer"), "0", true );
         //버튼의 상태를 변경함.
         changeButtonStatus()
 
         
     }
 
      
      
      /** 
       * 일부 컬럼을 숨기거나 보여준다. <BR>
       * 메인화면에서 조회 조건에 route 커럼이 있다면 <BR> 
       * simulation화면에서는 readonly로 입력 불가하게 만듦 <BR>
       *
       * <br><b>Example :</b>
       * <pre>
       * </pre>
       * 
       * @return 없음
       */     
	   function showColsOfSheet() {
	       	 var formObj = document.form;
	   	   	 var frm_ori_rout_cd = formObj.frm_ori_rout_cd.value;
	   		 var frm_dest_rout_cd = formObj.frm_dest_rout_cd.value;
	   	   	 var isEditableOriRoutCd = true;
	   		 var isEditableDestRoutCd = true;
	   		 
	   		 if(frm_ori_rout_cd != "" ){
	   			 isEditableOriRoutCd = false;
	   		 }
	   		 if(frm_dest_rout_cd != "" ){
	   			 isEditableDestRoutCd = false;
	   		 }
	   		 
	       	for(var i = 0 ; i < 5 ; i++ ){
    			//Main화면에서 화면에서 origin 을 조회했다면 해당 화면을 
    			//수정 못하도록한다.
    			//dummy_ori_rout_cd를 이용해 read only로 바꾼이유는
    			// ori_rout_cd를 채울경우 score 값을 부여해 
    			// 해당 조건이 최우선 매칭 되기 때문에 이를 방지하고자 ori_rout_cd는 null로 비우고
    			// dummy 데이터를 보여준다.	       		
	       		if( isEditableOriRoutCd == false ){
	       			sheetObjects[i].ColHidden("ori_rout_cd") = true;
	       			sheetObjects[i].ColHidden("dummy_ori_rout_cd") = false;
	       		}
	       		if( isEditableDestRoutCd == false ){
	       			sheetObjects[i].ColHidden("dest_rout_cd") = true;
	       			sheetObjects[i].ColHidden("dummy_dest_rout_cd") = false;
	       		}    		
	       	}
	  }
    
        
        
     /** 
      * document에서 일어나는 event들의 listener를 정의 한다.. <BR>
      * 
      *
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * 
      * @return 없음
      */    
     function initControl() {
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
	    axon_event.addListener('click', 'simulation_data_OnClick', 'simulation_data');
    }  

     /**  
      * simulation_data이 click 되었을 경우의 이벤트처리
      * 
      *  
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * 
      * @param {object} event 필수, Event Object
      * @return 없음
      */   
     function simulation_data_OnClick(event){
    	 var clickedValue = event.srcElement.getAttribute("value");
    	 var clickedName = event.srcElement.getAttribute("name");
         var objs = document.all.item("sheetLayer");
       //check box의 값에 따라  해당 sheet를 숨기거나 보여준다.
         displaySheet(objs,clickedValue,event.srcElement.checked);
       //버튼의 상태를 바꾼다.
         changeButtonStatus();
     }
     /**  
     * check box의 선택된 해당 sheet를 화면에 보여주거나 숨긴다.<BR>
     * 
     *  
     * <br><b>Example :</b>
     * <pre>
     *       displaySheet(objs,clickedValue,event.srcElement.checked);
     * </pre>
     * 
     * @param {Array} layerObjs 필수, sheet를 감싸고 있는 div object배열
     * @param {int} sheetIdx 필수, check된 check box의 index
     * @param {boolean} isCheck 필수, check, uncheck 여부 ( true : check , false, uncheck)
     * 
     * @return 없음
     */   
     function displaySheet(layerObjs, sheetIdx, isCheck ){
    	 var checkObj = document.form.simulation_data;
         if(isCheck){
        	 layerObjs[sheetIdx].style.display = "inline";
        	 //G.Revenue와 Rate,Surcharge는 동시에 check될수 없다.
        	 if( sheetIdx == "0" ){
	    		 checkObj[1].disabled = true;
	    		 checkObj[2].disabled = true;
	    	 }else if( sheetIdx == "1" || sheetIdx == "2" ){
	    		 checkObj[0].disabled = true;
	    	 }
         }else{
        	 layerObjs[sheetIdx].style.display = "none";
        	 //sheet의 모든데이터를 삭제한다.
        	 sheetObjects[sheetIdx].RemoveAll();
        	 if( sheetIdx == "0" ){
	    		 checkObj[1].disabled = false;
	    		 checkObj[2].disabled = false;
	    	 }else if( sheetIdx == "1" || sheetIdx == "2" ){
	    		 
	    		 if( checkObj[1].checked == false && checkObj[2].checked == false)
	    		 checkObj[0].disabled = false;
	    	 }
        	 
         }
         
     }
     
     /**  
     * sheet에 row 하나를  add하고 default값을 assign한다.<BR>
     * 
     *  
     * <br><b>Example :</b>
     * <pre>
     *       addRowSheet(sheetObj);
     * </pre>
     * 
     * @param {object} sheetObj 필수, sheet Object
     * 
     * @return 없음
     */   
     function addRowSheet(sheetObj){
    	 var formObj = document.form;
    	 var row = sheetObj.DataInsert();
    	 sheetObj.CellValue2(row,"apr_ofc_cd") = formObj.frm_prop_apro_ofc_cd.value;
    	 sheetObj.CellValue2(row,"cust_tp_cd") = formObj.frm_customer_type.value;
       	 sheetObj.CellValue2(row,"trd_cd") = formObj.frm_trd_cd.value;
       	 sheetObj.CellValue2(row,"dir_cd") = formObj.frm_dir_cd.value;
       	 sheetObj.CellValue2(row,"sub_trd_cd") = formObj.frm_sub_trd_cd.value;
       	 sheetObj.CellValue2(row,"rlane_cd") = formObj.frm_rlane_cd.value;
       	 
    	 sheetObj.CellValue2(row,"dummy_ori_rout_cd") = formObj.frm_ori_rout_cd.value;
    	 sheetObj.CellValue2(row,"dummy_dest_rout_cd") = formObj.frm_dest_rout_cd.value;
       	 
       	 
    	 calcScore(sheetObj, row, "apr_ofc_cd");
     }
     
     
     /** 
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {String} sheetNo 필수, sheet의 ID
      * @return 없음
      */ 
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
    	 var formObj = document.form;
         sheetObj.WaitImageVisible = false;  	

    	 var frm_prop_apro_ofc_cd = formObj.frm_prop_apro_ofc_cd.value;
    	 var frm_customer_type = formObj.frm_customer_type.value.trim();
    	 var frm_sub_trd_cd = formObj.frm_sub_trd_cd.value;
    	 var frm_rlane_cd = formObj.frm_rlane_cd.value.trim();
    	 var isEditableAprOfcCd = true;
    	 var isEditableCustTpCd = true;
    	 var isEditableSubTrdCd = true;
    	 var isEditableRlaneCd = true;
    	 //메인 화면에서 approval office,customer type, sub-trade, rlane 조회 조건을 넣었다면 
    	 //해당 컬럼 수정을 못하도록 한다.
    	 if(frm_prop_apro_ofc_cd != "" ){
    		 isEditableAprOfcCd = false;
    	 }
    	 if(frm_customer_type != "M" ){
    		 isEditableCustTpCd = false;
    	 }
    	 if(frm_sub_trd_cd != "" ){
    		 isEditableSubTrdCd = false;
    	 }
    	 if(frm_rlane_cd != "" ){
    		 isEditableRlaneCd = false;
    	 }

         switch(sheetObj.id) {
 			case "sheet1":      //sheet1 init
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
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
                     var HeadTitle2 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 5, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"trd_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"dir_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"sub_trd_cd",   	false,          "",      dfNone,      		0,			true,       isEditableSubTrdCd);
 					InitDataProperty(0, cnt++ , dtPopup,    		100,   	daCenter,  	true,		"rlane_cd",   	false,          "",      dfNone,      		0,			true,       isEditableRlaneCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);

 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"hidden_eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"hidden_exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfFloat,			5,			true,		true);
 					InitUserFormat(0, "eff_yrwk", "####-##", "-" );
 					InitUserFormat(0, "exp_yrwk", "####-##", "-" );
 					

 					 
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcValue) , appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "sub_trd_cd", appendDefaultData(subTrdCdValue) , appendDefaultData(subTrdCdValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "+|X", "+|X");
 					
 		 
 					
 					ColHidden("application") = true;
 					
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_yrwk")=1
 					PopupButtonImage(0,"exp_yrwk")=1
 					
 					ShowButtonImage = 1;
 					
 					CountPosition = 0;
                }
                break;

 			case "sheet2":      //sheet1 init
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
	                InitRowInfo(2, 1, 15, 100);
	
	                var HeadTitle1 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
	                var HeadTitle2 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
					var headCount = ComCountHeadTitle(HeadTitle1);
	                
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"trd_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"dir_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"sub_trd_cd",   	false,          "",      dfNone,      		0,			true,       isEditableSubTrdCd);
 					InitDataProperty(0, cnt++ , dtPopup,    		100,   	daCenter,  	true,		"rlane_cd",   	false,          "",      dfNone,      		0,			true,       isEditableRlaneCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);

 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"hidden_eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"hidden_exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfFloat,			5,			true,		true);
 			
 					InitUserFormat(0, "eff_yrwk", "####-##", "-" );
 					InitUserFormat(0, "exp_yrwk", "####-##", "-" );
 					
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcValue) , appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "sub_trd_cd", appendDefaultData(subTrdCdValue) , appendDefaultData(subTrdCdValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "+|X", "+|X");
 					
 
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_yrwk")=1
 					PopupButtonImage(0,"exp_yrwk")=1
 					
 					ShowButtonImage = 1;
 					
 					CountPosition = 0;
                }
                break;

 			case "sheet3":      //sheet1 init
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
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Surcharge\nCode|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
                     var HeadTitle2 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Surcharge\nCode|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
 	                
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"trd_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"dir_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"sub_trd_cd",   	false,          "",      dfNone,      		0,			true,       isEditableSubTrdCd);
 					InitDataProperty(0, cnt++ , dtPopup,    		100,   	daCenter,  	true,		"rlane_cd",   	false,          "",      dfNone,      		0,			true,       isEditableRlaneCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);

 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"chg_cd",   	true,          "",      dfNone,      		0,			true,       true);

 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"hidden_eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"hidden_exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfFloat,			5,			true,		true);
 			
 					InitUserFormat(0, "eff_yrwk", "####-##", "-" );
 					InitUserFormat(0, "exp_yrwk", "####-##", "-" );
 					
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcValue) , appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "sub_trd_cd", appendDefaultData(subTrdCdValue) , appendDefaultData(subTrdCdValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "+|X", "+|X");
 					InitDataCombo(0, "chg_cd", " |"+chgCdValue, " |"+chgCdValue);
 					
 					 
 					 
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_yrwk")=1
 					PopupButtonImage(0,"exp_yrwk")=1
 					
 					ShowButtonImage = 1;
 					
 					CountPosition = 0;
                }
                break;

 			case "sheet4":      //sheet1 init
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
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
                     var HeadTitle2 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"trd_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"dir_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"sub_trd_cd",   	false,          "",      dfNone,      		0,			true,       isEditableSubTrdCd);
 					InitDataProperty(0, cnt++ , dtPopup,    		100,   	daCenter,  	true,		"rlane_cd",   	false,          "",      dfNone,      		0,			true,       isEditableRlaneCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);

 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"hidden_eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"hidden_exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfFloat,			5,			true,		true);
 					InitUserFormat(0, "eff_yrwk", "####-##", "-" );
 					InitUserFormat(0, "exp_yrwk", "####-##", "-" );
 					
 
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcValue) , appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "sub_trd_cd", appendDefaultData(subTrdCdValue) , appendDefaultData(subTrdCdValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "+|X", "+|X");
 
 					
 					 
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_yrwk")=1
 					PopupButtonImage(0,"exp_yrwk")=1
 					
 					ShowButtonImage = 1;
 					
 					CountPosition = 0;
                }
                break;
                case "sheet5":      //sheet5 init
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
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
                     var HeadTitle2 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"trd_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"dir_cd",				false,			"",		dfNone,				2,			false,		false);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"sub_trd_cd",   	false,          "",      dfNone,      		0,			true,       isEditableSubTrdCd);
 					InitDataProperty(0, cnt++ , dtPopup,    		100,   	daCenter,  	true,		"rlane_cd",   	false,          "",      dfNone,      		0,			true,       isEditableRlaneCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);

 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    		75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"hidden_eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"hidden_exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfFloat,			5,			true,		true);
 			
 					InitUserFormat(0, "eff_yrwk", "####-##", "-" );
 					InitUserFormat(0, "exp_yrwk", "####-##", "-" );
 					
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcValue) , appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "sub_trd_cd", appendDefaultData(subTrdCdValue) , appendDefaultData(subTrdCdValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "+|X", "+|X");
 
 					
 					 
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_yrwk")=1
 					PopupButtonImage(0,"exp_yrwk")=1
 					
 					ShowButtonImage = 1;
 					
 					CountPosition = 0;
                }
                break;
                case "sheet6":      //simulation 결과를 위한 sheet
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
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "sc_no|load|g_rev|cost_trade|cost_office|cost_op_office|cm_office|cm_trade|op_office|cmpb_office|cmpb_trade|opb_office|upd_flg";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

       
                    
                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	               
                    
					InitDataProperty(0, cnt++ ,dtData,			100,   	daCenter,  	true,		"sc_no",   		false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"load",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"g_rev",   			false,			"",		 dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cost_trade",   			false,			"",		 dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cost_office",   			false,			"",		 dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,		"cost_op_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"op_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,		"cmpb_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,   	"cmpb_trade");
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,   	"opb_office");
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,   	"upd_flg");
 					  
					CountPosition = 0;
					 
               }
               break;
         }
     }
      

      /**  
       * 입력받은 값에 default string을 붙여서 return한다.
       *  
       * <br><b>Example :</b>
       * <pre>
       *     InitDataCombo(0, "currency", appendDefaultData(currencyText), appendDefaultData(currencyValue));
       * </pre>
       * 
       * @param {string} str 필수, Combo code에서 쓸 코드 string
       * @return string, default를 붙인 string
       */           
	 function appendDefaultData(str){
   		 return " |"+ str;
   	 }

   /** 
    * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {object} formObj 필수, html document form Object
    * @param {int} sAction 필수, action의 구분
    * @return 없음
    */   
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBINSERT:      //조회
         	
				addRowSheet(sheetObj);
        	break;
 			case IBSEARCH:      //조회
 				if(!validateForm(sheetObj,formObj,sAction)){
 					return;
 				}
 				formObj.f_cmd.value = SEARCH;
 				var simul_tp_cd = "A";
	            var sParam = FormQueryString(formObj);
	         // 5개의 sheet에서 모든 sheet의 내용을 보아 파라메터로 만든다.
	            var sParamSheet1 = sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }else if ( sheetObjects[0].RowCount != 0 ){
	            	return false;
	            }
	            var sParamSheet2 = sheetObjects[1].GetSaveString();
	            if (sParamSheet2 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	                simul_tp_cd = "B";
	            }else if ( sheetObjects[1].RowCount != 0 ){
	            	return false;
	            }
	            var sParamSheet3 = sheetObjects[2].GetSaveString();
	            if (sParamSheet3 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	                simul_tp_cd = "B";
	            }else if ( sheetObjects[2].RowCount != 0 ){
	            	return false;
	            }
	            var sParamSheet4 = sheetObjects[3].GetSaveString();
	            if (sParamSheet4 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
	            }else if ( sheetObjects[3].RowCount != 0 ){
	            	return false;
	            }
	            var sParamSheet5 = sheetObjects[4].GetSaveString();
	            if (sParamSheet5 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
	            }else if ( sheetObjects[4].RowCount != 0 ){
	            	return false;
	            }
	            
				ComOpenWait(true);		
				sheetObj.RemoveAll();
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", FormQueryString(formObj)+sParam+"&simul_tp_cd="+simul_tp_cd);
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey.length > 0) {
					BACKEND_JOB_ID = backendJobKey;
					sheetObj.RequestTimeOut = 10000;
					TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 후에
																	// getBackEndJobStatus함수
																	// 실행 - 재귀호출
				}
				
				
        
	            
                break;

  			case IBDELETE: //삭제
				deleteRowCheck(sheetObj, "sel_chk") ;
				break;
			case IBCOPYROW:      // 입력
				var idx = sheetObj.DataCopy();
				sheetObj.CellValue(idx,"sel_chk") = 0;
				break;		
			case IBSEARCH_ASYNC06:        //RLane
				var iWidth = 100;
				var iHeight = 760;
	        	var sUrl = "ESM_PRI_6055.do?";
				sUrl +="&trd_cd="     + sheetObj.CellValue(sheetObj.SelectRow,"trd_cd");     //formObj.frm_trd_cd.value;
				sUrl +="&sub_trd_cd=" + sheetObj.CellValue(sheetObj.SelectRow,"sub_trd_cd"); //formObj.frm_sub_trd_cd.value;
				sUrl +="&revCdList="  + sheetObj.CellValue(sheetObj.SelectRow,"rlane_cd");   //formObj.frm_rlane_cd.value;
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6055", 500, 350, true);
				if( rtnVal != undefined ){
					sheetObj.CellValue(sheetObj.SelectRow,"rlane_cd") = rtnVal.cd;
				}
				break;
			case IBSEARCH_ASYNC05:

			break;  
 			
         }
         changeButtonStatus();
     }
   
	  /**  
	   * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
	   * 저장해 놓는다.
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *   initParams()
	   * </pre>
	   *
	   * @return 없음
	   */         
     function initParams(){
    	 var formObj = document.form;
   		var args = window.dialogArguments
 		var arrParams = args.Params;
   		formObj.frm_prop_no_list.value =arrParams["prop_no_list"];
   		formObj.frm_rfa_prop_no_list.value =arrParams["rfa_prop_no_list"];
   		
  		formObj.frm_svc_scp_cd.value = arrParams["frm_svc_scp_cd"];
  		formObj.frm_prop_apro_ofc_cd.value = arrParams["frm_prop_apro_ofc_cd"];
  		formObj.min_smr_eff_yr.value = arrParams["min_smr_eff_yr"];
  		formObj.min_smr_eff_wk.value = arrParams["min_smr_eff_wk"];
  		formObj.max_smr_exp_yr.value = arrParams["max_smr_exp_yr"];
  		formObj.max_smr_exp_wk.value = arrParams["max_smr_exp_wk"];
  		formObj.frm_customer_type.value = arrParams["frm_customer_type"];
  		formObj.frm_contract_type.value = arrParams["frm_contract_type"];
  		formObj.frm_pfmc_unit.value = arrParams["frm_pfmc_unit"];
  		formObj.frm_status.value = arrParams["frm_status"];
  		formObj.frm_ctrt_eff_yr.value = arrParams["frm_ctrt_eff_yr"];
  		formObj.frm_ctrt_eff_wk.value = arrParams["frm_ctrt_eff_wk"];
  		formObj.frm_ctrt_exp_yr.value = arrParams["frm_ctrt_exp_yr"];
  		formObj.frm_ctrt_exp_wk.value = arrParams["frm_ctrt_exp_wk"];
  		formObj.frm_smr_eff_yr.value = arrParams["frm_smr_eff_yr"];
  		formObj.frm_smr_eff_wk.value = arrParams["frm_smr_eff_wk"];
  		formObj.frm_smr_exp_yr.value = arrParams["frm_smr_exp_yr"];
  		formObj.frm_smr_exp_wk.value = arrParams["frm_smr_exp_wk"];
  		formObj.frm_rfrc_eff_yr.value = arrParams["frm_rfrc_eff_yr"];
  		formObj.frm_rfrc_eff_wk.value = arrParams["frm_rfrc_eff_wk"];
  		formObj.frm_rfrc_exp_yr.value = arrParams["frm_rfrc_exp_yr"];
  		formObj.frm_rfrc_exp_wk.value = arrParams["frm_rfrc_exp_wk"];  		
  		formObj.frm_prop_ofc_cd.value = arrParams["frm_prop_ofc_cd"];
  		formObj.frm_prop_srep_cd.value = arrParams["frm_prop_srep_cd"];
  		
  		formObj.frm_ori_rout_cd.value = arrParams["frm_ori_rout_cd"];
  		formObj.frm_ori_loc_tp.value = arrParams["frm_ori_loc_tp"];
  		formObj.frm_dest_rout_cd.value = arrParams["frm_dest_rout_cd"];
  		formObj.frm_dest_loc_tp.value = arrParams["frm_dest_loc_tp"];
  		
  		formObj.frm_trd_cd.value = arrParams["frm_trd_cd"];
  		formObj.frm_dir_cd.value = arrParams["frm_dir_cd"];
  		formObj.frm_sub_trd_cd.value = arrParams["frm_sub_trd_cd"];
  		formObj.frm_rlane_cd.value = arrParams["frm_rlane_cd"];
  		formObj.min_yrwk.value = arrParams["min_yrwk"];
  		formObj.max_yrwk.value = arrParams["max_yrwk"];
  		
   }
   
     
  	/** 
      * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *      changeButtonStatus();
 	 * </pre>
 	 * 
 	 * @return 없음
 	 */  	
   	 function changeButtonStatus(){
   		 if( sheetObjects[0].RowCount == 0  
   				&& sheetObjects[1].RowCount == 0 
   				&& sheetObjects[2].RowCount == 0  
   				&& sheetObjects[3].RowCount == 0  
   				&& sheetObjects[4].RowCount == 0  ){
   			disableButton("btn1_OK");
   		 }else{
   			enableButton("btn1_OK");
   		 }
   	 }

     /** 
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      * <br><b>Example :</b>
      * <pre>
      *      if (!validateForm(sheetObj,document.form,sAction)) {
      *          return false;
      *       }
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {object} formObj 필수, html document form Object
      * @param {int} sAction 필수, action의 구분
      *
      * @return boolean, true: 유효, false: 비유효
      */      
     function validateForm(sheetObj,formObj,sAction){
    	  
    	  
		switch(sAction) {
			case IBSEARCH:      //조회
				var checkObj = formObj.simulation_data;
				for(var idx=0 ; idx < checkObj.length ; idx++){
					if( checkObj[idx].checked == true ){
						var sheetObj =  sheetObjects[idx];
						for(var rowIdx = sheetObj.HeaderRows ; rowIdx <= sheetObj.LastRow ; rowIdx++){
							var eff_yrwk = sheetObj.CellValue(rowIdx,"eff_yrwk");
							var exp_yrwk = sheetObj.CellValue(rowIdx,"exp_yrwk");
							
				    		if( eff_yrwk == "" || exp_yrwk == ""){
								ComShowCodeMessage("PRI00316","Duration");
								return false;
				    		}
				    		eff_yrwk = eff_yrwk.replace(/\/|\-|\./g,"");
				    		exp_yrwk = exp_yrwk.replace(/\/|\-|\./g,"");
				    		
				    		if(exp_yrwk != "" && ComChkPeriod(eff_yrwk, exp_yrwk) < 1){
				    			ComShowCodeMessage("PRI00306");
				    			sheetObj.SelectRow = rowIdx;
								return false;
				    		}
							//날짜 기간이 Main화면에서 select된 eff_yrwk,exp_yrwk사이의 값이어야만 한다.
				 	     	//입력 duration이 main화면의 min , max를 넘지 않도록 한다.
				 	     	var min_yrwk = formObj.min_yrwk.value;
				 	     	var max_yrwk = formObj.max_yrwk.value;
				 	     	min_yrwk = min_yrwk.replace(/\/|\-|\./g,"");
				 	     	max_yrwk = max_yrwk.replace(/\/|\-|\./g,"");
				 	     	if( eff_yrwk < min_yrwk || exp_yrwk > max_yrwk ){
				 	     		min_yrwk = min_yrwk.substring(0,4)+'-'+min_yrwk.substring(4,6);
				 	     		max_yrwk = max_yrwk.substring(0,4)+'-'+max_yrwk.substring(4,6);
				 	     		ComShowCodeMessage("PRI03013",min_yrwk,max_yrwk);
				 	     		sheetObj.SelectRow = rowIdx;
				 	     		return false;
				 	     	}
						}
 					
	 					
						
			    		//중복체크
			          	var colNames = "sub_trd_cd|rlane_cd|apr_ofc_cd|cust_tp_cd|ori_rout_cd|ori_loc_tp|dest_rout_cd|dest_loc_tp";
			          	//중복체크
			 	        var dupRow = sheetObj.ColValueDup(colNames,false); 
			 	     	if (dupRow >= 0) {
			 	     		sheetObj.SelectRow = dupRow;
			 				ComShowCodeMessage("PRI03023","Sub-Trade, Revenue Lane, Approval Office, Customer Type, Route, (Surcharge  code)");
			 				return false;
			 	     	}

					}
				}
			
			break;
		}
		return true;
     }	
      
      /** 
       * 입력된 값에 따라 matching point를 계산한다.
       * 우선 순위가 낮은 것이라도 매칭되는 갯수가 더 많다면 더 높은 매칭 순위를 갖을수 있다.    
       *
       * <br><b>Example :</b>
       * <pre>
       *       calcScore(sheetObj,row,col);
       * </pre>
       * 
       * @param {object} sheetObj 필수, sheet Object
       * @param {int} row 필수, row index
       * @param {string} col 필수, colnum name
       * 
       * @return 없음
       */         
     function calcScore(sheetObj, row, col){
    	 
     
    	 var colName = "";
    	 var iScore = 0.01  ;
    	 
    	 if( ComIsNumber(col) == true ){
    		 colName = sheetObj.ColSaveName(col);
    	 }else{
    		 colName = col;
    	 }
    	 switch(colName){
    	 case "apr_ofc_cd" :
    	 case "cust_tp_cd" :
    	 case "chg_cd" :
    	 case "sub_trd_cd" :
    	 case "rlane_cd" :
    	 case "apr_ofc_cd" :
    	 case "ori_rout_cd" :
    	 case "dest_rout_cd" :
    		  if(sheetObj.CellValue(row,"sub_trd_cd") != "" ){
    			  iScore += 7;
    		  }			
    		  if(sheetObj.CellValue(row,"rlane_cd") != "" ){
    			  iScore += 8.5;
    		  }				
    		  if(sheetObj.CellValue(row,"apr_ofc_cd") != "" ){
    			  iScore += 6.5;
    		  }				
    		  if(sheetObj.CellValue(row,"cust_tp_cd") != "" && sheetObj.CellValue(row,"cust_tp_cd") != "M" ){
    			  iScore += 9.5;
    		  }
    		  if(sheetObj.CellValue(row,"ori_rout_cd") != "" ){
    			  iScore += 10;
    		  }				
    		  if(sheetObj.CellValue(row,"dest_rout_cd") != "" ){
    			  iScore += 10;
    		  }				    		  
					

    		  if( sheetObj.id == "sheet3" && ComTrim(sheetObj.CellValue(row,"chg_cd")) != ""  ){
    			  iScore += 11;
    		  }
    		 sheetObj.CellValue2(row,"score") = iScore ;
    		 break;
    	 
    	 }
     }
         

     /** 
      * sheet의 DATA TYPE이 dtPopup, dtEditPopup의 column을 클릭했을 경우 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, click한 cell의 row index
      * @param {int} col 필수, click한 cell의 col index
      * @return 없음
      */        
     function sheet1_OnPopupClick(sheetObj, row, col) {
    	 comOpenPopup(sheetObj, row, col)
     }
     


      /** 
      * Date형태의 값을 이용해 Year, Week를 구한다.
      * 
      * <br><b>Example :</b>
      * <pre>
      *       sheetObj.CellValue2(row,ComReplaceStr(colName,"hidden_","") ) = changeDateToWeek(sheetObj, row , ComReplaceStr(colName,"hidden_",""));
      * </pre>
      * 
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, row index
      * @param {string} colName 필수, 컬럼명
  	  *
      * 
      * @return string, yearwk 형태의 string
      */        
     function changeDateToWeek(sheetObj, row , colName){
		   var args = window.dialogArguments
		   var weekSheetObj = args.WeekSheetObj;
		   var sls_fm_dt = "";
		   var sls_to_dt = "";
		   var rtnValue = "";
		   var selectedDate = sheetObj.CellValue(row,"hidden_"+colName);
			
		   for( var i = weekSheetObj.HeaderRows  ; i < weekSheetObj.LastRow; i++ ){
			    sls_fm_dt = weekSheetObj.CellValue(i,"sls_fm_dt");
			    sls_to_dt = weekSheetObj.CellValue(i,"sls_to_dt");
	 	     	sls_fm_dt = sls_fm_dt.replace(/\/|\-|\./g,"");
	 	     	sls_to_dt = sls_to_dt.replace(/\/|\-|\./g,"");
	 	     	if( selectedDate >= sls_fm_dt && selectedDate <= sls_to_dt ){
	 	     		rtnValue = weekSheetObj.CellValue(i,"cost_yr") + weekSheetObj.CellValue(i,"cost_wk");
	 	     		break;
	 	     	}
		   }
		   return rtnValue;
   		
     }
      
      
     function validateRoute(sheetObj,row,col,locCd,checkType){
		var trdCd= sheetObj.CellValue(row,"trd_cd");
		if( locCd == "US" && ( trdCd == "TPS" || trdCd == "TAS" )){
			ComShowCodeMessage("PRI03014"); // Please input region code only for US
			return false;
		}else {
			//region code는 US region만 넣을수 있다. US region인지 검사 한다.
			if( locCd.length == 3 && ( trdCd == "TPS" || trdCd == "TAS") ){
				var formObj = document.form;
 				formObj.f_cmd.value = SEARCH02;
 				var param = FormQueryString(formObj);
 				param += "&cnt_cd=US";
 				param += "&rgn_cd="+locCd;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", param );
				var is_success = ComGetEtcData(sXml, "IS_SUCCESS");
				if (is_success.length <= 0 || is_success == "F") {
					ComShowCodeMessage("PRI03014"); // Please input region code only for US
					return false;
				}
			}else if(checkType != "POPUP" && locCd.length == 2){//COUNTRY CODE
				var formObj = document.form;
 				formObj.f_cmd.value = SEARCH02;
 				var param = FormQueryString(formObj);
 				param += "&cnt_cd="+locCd;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", param );
				var is_success = ComGetEtcData(sXml, "IS_SUCCESS");
				if (is_success.length <= 0 || is_success == "F") {
					ComShowCodeMessage("PRI03024"); // This is an invalid code. Please input country code except US(United states, Region code only)
					return false;
				}
			}else if(checkType != "POPUP" && locCd.length == 3){//REGION CODE
				var formObj = document.form;
 				formObj.f_cmd.value = SEARCH02;
 				var param = FormQueryString(formObj);
 				param += "&rgn_cd="+locCd;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", param );
				var is_success = ComGetEtcData(sXml, "IS_SUCCESS");
				if (is_success.length <= 0 || is_success == "F") {
					ComShowCodeMessage("PRI03024"); // This is an invalid code. Please input country code except US(United states, Region code only)
					return false;
				}				
			}
		}
		return true;
     }
     
     /** 
      * sheet의 컬럼별로 그에 적당한 popup을 띄워준다.<BR> 
      * 
      * <br><b>Example :</b>
      * <pre>
      *       comOpenPopup(sheetObj, row, col)
      * </pre>
      * 
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, row index
      * @param {string} col 필수, 컬럼명
  	  *
      * 
      * @return 없음
      */    
     function comOpenPopup(sheetObj, row, col){
         var colName = sheetObj.ColSaveName(col);
         var formObj = document.form;
         switch(colName){
         case "eff_yrwk" :
         case "exp_yrwk" :
        	 openCalendar(sheetObj, row , "hidden_"+colName);
        	 break;
         case "rlane_cd":
        	 doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC06);
        	 break;
         case "ori_rout_cd":
    			/*
 	  	  		  "LGTCR"
 				 L:Location
 				 G:Group Location
 				 T:State
 				 C:Country
 				 R:Region
 	  	  		 */

 	  	  	var trdCd= sheetObj.CellValue(row,"trd_cd");
 	  	  	 var sUrl = "ESM_PRI_4026.do?"  
 	  	 	 sUrl += "&group_cmd=" + PRI_SP_SCP; 
 	  	  	 
 	  	  	 if( trdCd == "TPS" || trdCd == "TAS"){
 	  	  		sUrl += "&location_cmd=RC";
 	  	  		sUrl += "&loc_tp_cd=C"; 	  	  		 
 	  	  	 }else{
  	  	  		sUrl += "&location_cmd=C";
 	  	  		sUrl += "&loc_tp_cd=C";
 	  	  	 }
 	  	  	// Please input region code only for US.
 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 			if (rtnVal != null){
				sheetObj.CellValue2(sheetObj.SelectRow, "ori_rout_cd") = rtnVal.cd;
				sheetObj.CellValue2(sheetObj.SelectRow, "ori_loc_tp") = rtnVal.tp; 	  
				if( !validateRoute(sheetObj,sheetObj.SelectRow,"ori_rout_cd",rtnVal.cd,"POPUP" ) ){
					sheetObj.CellValue2(sheetObj.SelectRow, "ori_rout_cd") = "";
					sheetObj.CellValue2(sheetObj.SelectRow, "ori_loc_tp") = ""; 	 
					sheetObj.SelectCell(sheetObj.SelectRow, "ori_rout_cd");
				}
 			}
        	 break;
     	case "dest_rout_cd":
    			/*
 	  	  		 * "LGTCR"
 				 L:Location
 				 G:Group Location
 				 T:State
 				 C:Country
 				 R:Region
 	  	  		 */
 			 var trdCd= sheetObj.CellValue(sheetObj.SelectRow,"trd_cd");
 			 
 	  	  	 var sUrl = "ESM_PRI_4026.do?"  
 	  	 	 sUrl += "&group_cmd=" + PRI_SP_SCP; 
 	  	  	 
 	  	  	 if( trdCd == "TPS" || trdCd == "TAS"){
 	  	  		sUrl += "&location_cmd=RC";
 	  	  		sUrl += "&loc_tp_cd=C"; 	  	  		 
 	  	  	 }else{
  	  	  		sUrl += "&location_cmd=C";
 	  	  		sUrl += "&loc_tp_cd=C";
 	  	  	 }
 	  	  	// Please input region code only for US.
 		  		
 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 			if (rtnVal != null){
				sheetObj.CellValue2(sheetObj.SelectRow, "dest_rout_cd") = rtnVal.cd;
				sheetObj.CellValue2(sheetObj.SelectRow, "dest_loc_tp") = rtnVal.tp; 	  
				if( !validateRoute(sheetObj,sheetObj.SelectRow,"dest_rout_cd",rtnVal.cd,"POPUP" ) ){
					sheetObj.CellValue2(sheetObj.SelectRow, "dest_rout_cd") = "";
					sheetObj.CellValue2(sheetObj.SelectRow, "dest_loc_tp") = ""; 	  
					sheetObj.SelectCell(sheetObj.SelectRow, "dest_rout_cd");
				}
 			} 	  	  	
        	break;       	 	
       	 
         }
     }
     /** 
      * sheet의 DATA TYPE이 dtPopup, dtEditPopup의 column을 클릭했을 경우 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, click한 cell의 row index
      * @param {int} col 필수, click한 cell의 col index
      * @return 없음
      */        
     function sheet2_OnPopupClick(sheetObj, row, col) {
    	 comOpenPopup(sheetObj, row, col)
     }  
     /** 
      * sheet의 DATA TYPE이 dtPopup, dtEditPopup의 column을 클릭했을 경우 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, click한 cell의 row index
      * @param {int} col 필수, click한 cell의 col index
      * @return 없음
      */        
     function sheet3_OnPopupClick(sheetObj, row, col) {
    	 comOpenPopup(sheetObj, row, col)
     }  
     /** 
      * sheet의 DATA TYPE이 dtPopup, dtEditPopup의 column을 클릭했을 경우 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, click한 cell의 row index
      * @param {int} col 필수, click한 cell의 col index
      * @return 없음
      */        
     function sheet4_OnPopupClick(sheetObj, row, col) {
    	 comOpenPopup(sheetObj, row, col)
     }  
     /** 
      * sheet의 DATA TYPE이 dtPopup, dtEditPopup의 column을 클릭했을 경우 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, click한 cell의 row index
      * @param {int} col 필수, click한 cell의 col index
      * @return 없음
      */        
     function sheet5_OnPopupClick(sheetObj, row, col) {
    	 comOpenPopup(sheetObj, row, col)
     }  
     var cal = ""
    	 
     /** 
      * sheet에 calendar popup을 띄워준다.<BR> 
      * 
      * <br><b>Example :</b>
      * <pre>
      *       openCalendar(sheetObj, row , "hidden_"+colName);
      * </pre>
      * 
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, row index
      * @param {string} colName 필수, 컬럼명
  	  *
      * 
      * @return 없음
      */       	 
     function openCalendar(sheetObj, row , colName){
         cal = new ComCalendarGrid();
         cal.setEndFunction("endCalendar"); 
         cal.sheetObj = sheetObj;
         cal.row = row;
         cal.colName = colName;
         cal.select(sheetObj, row , colName, 'yyyyMMdd');
     }
     /** 
     * sheet에 calendar popup이 닫힌후 자동 호출 되는 함수로<BR> 
     * 입력된 년월일을 이용해 해당 년,주차를 구한다.
     * 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * 
     * @return 없음
     */      
     function endCalendar( ){
    	 var sheetObj = cal.sheetObj;
    	 var row = cal.row;
    	 var colName = cal.colName;
       	 sheetObj.CellValue2(row,ComReplaceStr(colName,"hidden_","") ) = changeDateToWeek(sheetObj, row , ComReplaceStr(colName,"hidden_","")); 	 
     }
     
     /** 
     * simulation 작업 완료후 opener에 simulation한<BR>
     * 내용을 적용시킨다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *      sheet6LoadEnd(sheetObj)
     * </pre>
     * 
     * 
     * @return 없음
     */         
     function sheet6LoadEnd(sheetObj){
  		var args = window.dialogArguments
 		var parentSheetObj = args.SheetObj;
  		//속도 향상을 위해 total sum 을 해제함
  		parentSheetObj.RedrawSum = false;

    	// var parentSheetObj = parent.sheetObjects[0];
  		if( sheetObj.RowCount > 0 ){
	    	 for(var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow; i++){
	    		 
	    		 var scNo = sheetObj.CellValue(i,"sc_no");
	    		 var load = sheetObj.CellValue(i,"load");
	    		 var g_rev = sheetObj.CellValue(i,"g_rev");
	    		 var cost_trade = sheetObj.CellValue(i,"cost_trade");
	    		 var cost_office = sheetObj.CellValue(i,"cost_office");
	    		 var cost_op_office = sheetObj.CellValue(i,"cost_op_office");
	    		 var cm_office = sheetObj.CellValue(i,"cm_office");
	    		 var cm_trade = sheetObj.CellValue(i,"cm_trade");
	    		 var op_office = sheetObj.CellValue(i,"op_office");
	    		 var cmpb_office = sheetObj.CellValue(i,"cmpb_office");
	    		 var cmpb_trade = sheetObj.CellValue(i,"cmpb_trade");
	    		 var opb_office = sheetObj.CellValue(i,"opb_office");
	    		 var upd_flg = sheetObj.CellValue(i,"upd_flg");
	    		//scno를 key로 이용해 값을 적용할 row을 찾아냄
	    		 var row = parentSheetObj.FindText("a_sc_no", scNo);
	    		 //찾은 row에 simulation한 결과를 반영함
	    		 parentSheetObj.CellValue2(row,"e1_load") = load;
	    		 parentSheetObj.CellValue2(row,"e1_g_rev") = g_rev;
	    		 parentSheetObj.CellValue2(row,"e1_cost_cm_office") = cost_office;
	    		 parentSheetObj.CellValue2(row,"e1_cost_cm_trade") = cost_trade;
	    		 parentSheetObj.CellValue2(row,"e1_cost_op_office") = cost_op_office;
	    		 parentSheetObj.CellValue2(row,"e1_cmpb_office") = cmpb_office;
	    		 parentSheetObj.CellValue2(row,"e1_cmpb_trade") = cmpb_trade;
	    		 parentSheetObj.CellValue2(row,"e1_cm_office") = cm_office;
	    		 parentSheetObj.CellValue2(row,"e1_cm_trade") = cm_trade;
	    		 parentSheetObj.CellValue2(row,"e1_opb") = opb_office;
	    		 parentSheetObj.CellValue2(row,"e1_op") = op_office;
	    		 
	    		//값을 변경한 row의 cell들의 font color를 변경함.
	    		 parentSheetObj.CellFontColor(row,"e1_cmpb_office") = parentSheetObj.RgbColor(255, 0, 0);
	    		 parentSheetObj.CellFontColor(row,"e1_cmpb_trade") = parentSheetObj.RgbColor(255, 0, 0);
	    		 parentSheetObj.CellFontColor(row,"e1_cm_trade") = parentSheetObj.RgbColor(255, 0, 0);
	    		 parentSheetObj.CellFontColor(row,"e1_opb") = parentSheetObj.RgbColor(255, 0 ,0);
	    		 parentSheetObj.CellFontColor(row,"e1_op") = parentSheetObj.RgbColor(255, 0 ,0);
	    		 //G.Rev 값이 바뀌는 경우는 G.Rev, Rate, Surcharge, Load를 simulation 했을때이기 때문에
	    		 //그 값을 적용 했을때만 G.Rev cell의 font color를 변경한다.
	    		 if( sheetObjects[0].RowCount > 0  //G.Rev
	    				 || sheetObjects[1].RowCount > 0 //Rate
	    				 || sheetObjects[2].RowCount > 0  //Surcharge
	    				 || sheetObjects[4].RowCount > 0 ){ //Load
	    		 		
	    			 parentSheetObj.CellFontColor(row,"e1_g_rev") = parentSheetObj.RgbColor(255, 0, 0);
	    			 
	    		 }
	    		 if( sheetObjects[3].RowCount > 0  //Cost
	    				 || sheetObjects[4].RowCount > 0 ){ //Load 
		    		 parentSheetObj.CellFontColor(row,"e1_cost_cm_office") = parentSheetObj.RgbColor(255, 0, 0);
		    		 parentSheetObj.CellFontColor(row,"e1_cost_cm_trade") = parentSheetObj.RgbColor(255, 0, 0);
		    		 parentSheetObj.CellFontColor(row,"e1_cost_op_office") = parentSheetObj.RgbColor(255, 0, 0);
	    			 
	    		 }
	    		 if( sheetObjects[4].RowCount > 0 ){ //Load
	    			 parentSheetObj.CellFontColor(row,"e1_load") = parentSheetObj.RgbColor(255, 0, 0);
	    		 }
	    		 


	 
	 	 
	    	 }
  		}
  		// total sum을 다시 enable함
    	 parentSheetObj.RedrawSum = true;
    	
    	 
	     var args = window.dialogArguments
	     var simulSheetObj = args.SimulSheetObj;
	     //메인 화면의 숨겨진 5개의 sheet에 simulation 조건들을 copy해 둔다.
	     //왜냐하면 excel download시 simulation 입력값도 같이 내려줘야 하기 때문이다.
	     for(var idx=0 ; idx < 5 ; idx++){
	    	 simulSheetObj[idx].RemoveAll();
	    	 if( sheetObjects[idx].RowCount != 0 ){
	    	 	sheetObjects[idx].Copy2SheetCol(simulSheetObj[idx],"","",-1,-1,-1,2);
	    	 }
	     }
    	 var obj = new Object();
    	 obj.code = "SIMULATION";
    	 window.returnValue = obj;
		   
    	 ComOpenWait(false);
    	 self.close();
     }
     
     

     /** 
      * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
      * 
      * <br><b>Example :</b>
      * <pre>
      *      sheet6LoadEnd(sheetObj)
      * </pre>
      * 
      * 
      * @return 없음
      */              
     function getBackEndJobStatus() {
     	var form = document.form;	
		var sheetObj = sheetObjects[5];
     	form.f_cmd.value = SEARCH01;
     	var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", "f_cmd="+SEARCH01+"&backendjob_key="+BACKEND_JOB_ID);
     	var jobStatus = ComGetEtcData(sXml, "jb_sts_flg");
     	if (jobStatus == "3") {
     		getBackEndJobLoadFile();
     		clearInterval(TIMER_ID);
     	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
     		ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
     		clearInterval(TIMER_ID);	
     		ComOpenWait(false);	
     	} else if (jobStatus == "5") {
     		ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
     		clearInterval(TIMER_ID);
     		ComOpenWait(false);	
     	}
     }
     /** 
     * BackEndJob이 완료 된후 그 결과를 sheet에 loading한다.<BR>
     * 
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobLoadFile()
     * </pre>
     * 
     * 
     * @return 없음
     */          
     function getBackEndJobLoadFile() {
		var form = document.form;
		var sheetObj = sheetObjects[5];
		form.f_cmd.value = SEARCHLIST;
		
		var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", "f_cmd="+SEARCHLIST+"&backendjob_key="+BACKEND_JOB_ID);
		sheetObj.LoadSearchXml(sXml);
	   	 sheet6LoadEnd(sheetObj);
		 ComOpenWait(false);
     }
     
 
     /** 
     * sheet의 내용이 변경 되었을때 해야하는 공통 작업 
     * <br><b>Example :</b>
     * <pre>
     *     comSheetOnChange(sheetObj, row, col, value)
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 변경된 row index
     * @param {int} col 필수, 변경된 col index
     * @param {string} value 필수, 변경된 cell의 값
     * @return 없음
     */   
     function comSheetOnChange(sheetObj, row, col, value){
    	 calcScore(sheetObj, row, col);
         var colName = sheetObj.ColSaveName(col);
         var formObj = document.form;
         switch(colName){
         case "ori_rout_cd" :
        	 if(value == ""){
        		 sheetObj.CellValue2(row,"ori_loc_tp") = ""
        	 }else{
 				if( !validateRoute(sheetObj,row,col,value,"" ) ){
					sheetObj.CellValue2(row, "ori_rout_cd") = "";
					sheetObj.CellValue2(row, "ori_loc_tp") = ""; 	
					sheetObj.SelectCell(row, col)
				}
        	 }
        	 break;
         case "dest_rout_cd" :
        	 if(value == ""){
        		 sheetObj.CellValue2(row,"dest_loc_tp") = ""
        	 }else{
  				if( !validateRoute(sheetObj,row,col,value ,"") ){
					sheetObj.CellValue2(row, "dest_rout_cd") = "";
					sheetObj.CellValue2(row, "dest_loc_tp") = ""; 	  
					sheetObj.SelectCell(row, col)
				}
        	 }
        	 break;
         }
     }
     
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */    
     function sheet1_OnChange(sheetObj, row, col, value) {
    	 comSheetOnChange(sheetObj, row, col, value)
     }
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */    
     function sheet2_OnChange(sheetObj, row, col, value) {
    	 comSheetOnChange(sheetObj, row, col, value)
     }
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */         
     function sheet3_OnChange(sheetObj, row, col, value) {
    	 comSheetOnChange(sheetObj, row, col, value)
     }
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */         
     function sheet4_OnChange(sheetObj, row, col, value) {
    	 comSheetOnChange(sheetObj, row, col, value)
     }
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */         
     function sheet5_OnChange(sheetObj, row, col, value) {
    	 comSheetOnChange(sheetObj, row, col, value)
     }
	/* 개발자 작업  끝 */