/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6032.js
*@FileTitle : CM,OP Summary And Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.10 송민석
* 1.0 Creation
=========================================================
* History
* 2011.06.29 김민아 [CHM-201111837] Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : 파라미터 맵핑 에러로 인한 수정
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
     * @class ESM_PRI_6032 : ESM_PRI_6032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6032() {
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
    	  
         //event의 초기화
         initControl();
         // 메인화면에서 조회 조건에 route 커럼이 있다면 
         // simulation화면에서는 readonly로 입력 불가하게 만듦
         showColsOfSheet();
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
    		if( isEditableOriRoutCd == false ){
    			//Main화면에서 화면에서 origin 을 조회했다면 해당 화면을 
    			//수정 못하도록한다.
    			//dummy_ori_rout_cd를 이용해 read only로 바꾼이유는
    			// ori_rout_cd를 채울경우 score 값을 부여해 
    			// 해당 조건이 최우선 매칭 되기 때문에 이를 방지하고자 ori_rout_cd는 null로 비우고
    			// dummy 데이터를 보여준다.
    			sheetObjects[i].ColHidden("ori_rout_cd") = true;
    			sheetObjects[i].ColHidden("dummy_ori_rout_cd") = false;
    		}
    		if( isEditableDestRoutCd == false ){
    			// origin과 동일
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
    	 sheetObj.CellValue2(row,"dummy_ori_rout_cd") = formObj.frm_ori_rout_cd.value;
    	 sheetObj.CellValue2(row,"dummy_dest_rout_cd") = formObj.frm_dest_rout_cd.value;
    	 sheetObj.CellValue2(row,"score") = 1;
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
   	  
    	 var frm_prop_apro_ofc_cd = formObj.frm_prop_apro_ofc_cd.value;
    	 var frm_customer_type = formObj.frm_customer_type.value.trim();
 
    	 
    	 var isEditableAprOfcCd = true;
    	 var isEditableCustTpCd = true;
 
    	 //메인 화면에서 approval office 조회 조건을 넣었다면 
    	 //해당 컬럼 수정을 못하도록 한다.
    	 if(frm_prop_apro_ofc_cd != "" ){
    		 isEditableAprOfcCd = false;
    	 }
    	 //메인 화면에서 customer type 조회 조건을 넣었다면 
    	 //해당 컬럼 수정을 못하도록 한다.
    	 if(frm_customer_type != "M" ){
    		 isEditableCustTpCd = false;
    	 }
    	 

    	 
         sheetObj.WaitImageVisible = false;

         switch(sheetObj.id) {
 			case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 210;
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

                     var HeadTitle1 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     var HeadTitle2 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
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
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"application",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);

 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);

 					
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfNumber,			0,			true,		true);
 					
 					
 					InitDataCombo(0, "application", applicationText, applicationValue);
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcValue) , appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "X|+", "X|+");
 					
 					ColHidden("application") = true;
 					
 					
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_dt")=1
 					PopupButtonImage(0,"exp_dt")=1
 					
 					ShowButtonImage = 1;
 					
 					 
 					ShowButtonImage = 1;
 					CountPosition = 0;
                }
                break;

 			case "sheet2":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 210;
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

                     var HeadTitle1 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     var HeadTitle2 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     
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
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"application",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);
 					
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"amount",				true,			"",		dfNone,				0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_dt",				true,			"",		 dfDateYmd,			0,			true,		true);

 					
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfNumber,			0,			true,		true);
 			
 
 					InitDataCombo(0, "application", applicationText, applicationValue);
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcText), appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);

 					InitDataCombo(0, "calc_tp_cd", "X|+", "X|+");
 					
 					ColHidden("application") = true;
 					
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_dt")=1
 					PopupButtonImage(0,"exp_dt")=1
 					
 					
 					ShowButtonImage = 1;
 					CountPosition = 0;
                }
                break;

 			case "sheet3":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 210;
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

                     var HeadTitle1 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Surcharge\nCode|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     var HeadTitle2 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Surcharge\nCode|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     
                     
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
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"application",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);
 					
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					
 					InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,	true,		"chg_cd",				false,			"",		dfNone,				0,			true,		true);
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfNumber,			0,			true,		true);
 					
 					InitDataCombo(0, "application", applicationText, applicationValue);
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcText), appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "X|+", "X|+");
 					InitDataCombo(0, "chg_cd", " |"+chgCdValue, " |"+chgCdValue);
 					
 					ColHidden("application") = true;
 					
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_dt")=1
 					PopupButtonImage(0,"exp_dt")=1
 					
 					
 					ShowButtonImage = 1;
 					CountPosition = 0;
                }
                break;

 			case "sheet4":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 210;
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

                     var HeadTitle1 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     var HeadTitle2 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     
                     
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
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"application",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);
 					
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					
 					
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfNumber,			0,			true,		true);
 					
 					InitDataCombo(0, "application", applicationText, applicationValue);
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcText), appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "X|+", "X|+");
 					
 					ColHidden("application") = true;
 					
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_dt")=1
 					PopupButtonImage(0,"exp_dt")=1
 					ShowButtonImage = 1;
 					CountPosition = 0;
                }
                break;
                case "sheet5":      //sheet5 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 210;
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

                     var HeadTitle1 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Route|Route|Route|Route|Route|Route|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     var HeadTitle2 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|Origin|Origin|ori_tp|Dest.|Dest.|dest_tp|Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
                     
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
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"application",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       isEditableAprOfcCd);
 					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       isEditableCustTpCd);
 					
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_ori_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfEngUpKey,      		0,			true,       true,3);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dummy_dest_rout_cd",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
 					
 					
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfNumber,			0,			true,		true);
 					
 					InitDataCombo(0, "application", applicationText, applicationValue);
 					InitDataCombo(0, "apr_ofc_cd", appendDefaultData(appOfcText), appendDefaultData(appOfcValue) );
 					InitDataCombo(0, "cust_tp_cd", customerTypeText, customerTypeValue);
 					InitDataCombo(0, "calc_tp_cd", "X|+", "X|+");
 					
 					ColHidden("application") = true;
 					
 					
 					ImageList(0)  =  "img/btns_search.gif";
 					ImageList(1)  =  "img/btns_calendar.gif";
 					
 					PopupButtonImage(0,"eff_dt")=1
 					PopupButtonImage(0,"exp_dt")=1
 					
 					ShowButtonImage = 1;
 					CountPosition = 0;
                }
                break;
                case "sheet6":      //simulation 결과를 받을 sheet
                with (sheetObj) {
                	
                    // 높이 설정
                    style.height = 210;
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

                    var HeadTitle1 = "prop_no|load|g_rev|cost_trade|cost_office|cost_op_office|rate|surcharge|cm_office|cm_trade|op_office|cmpb_office|cmpb_trade|opb_office";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

       
                    
                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	               
                    
					InitDataProperty(0, cnt++ ,dtData,			100,   	daCenter,  	true,		"prop_no",   		false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"load",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"g_rev",   			false,			"",		 dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cost_trade",   			false,			"",		 dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cost_office",   			false,			"",		 dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,		"cost_op_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,		"rate",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,		"surcharge",   			false,          "",      dfNullFloat,      	2,			true,       true);
					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	false,		"op_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    		100,   	daRight,  	false,		"cmpb_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,   	"cmpb_trade");
 					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,   	"opb_office");
 					  
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
 			case IBSEARCH:      //Simulation 
 				if(!validateForm(sheetObj,formObj,sAction)){
 					return;
 				}
 				// 5개의 sheet에서 모든 sheet의 내용을 보아 파라메터로 만든다.
 				formObj.f_cmd.value = SEARCH;
	            var sParam = FormQueryString(formObj);
	            var sParamSheet1 = sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }else if ( sheetObjects[0].RowCount != 0 ){
	            	return false;
	            }
	            var sParamSheet2 = sheetObjects[1].GetSaveString();
	            if (sParamSheet2 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	            }else if ( sheetObjects[1].RowCount != 0 ){
	            	return false;
	            }
	            var sParamSheet3 = sheetObjects[2].GetSaveString();
	            if (sParamSheet3 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
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
	            
	            // backend job 형식으로 simulation 조회 실행
	            var sXml = sheetObj.GetSearchXml("ESM_PRI_6032GS.do",sParam)
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey.length > 0) {
					BACKEND_JOB_ID = backendJobKey;
					sheetObj.RequestTimeOut = 10000;
					TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 마다 getBackEndJobStatus함수
																	
				}	            
	            
	           

        
	            
                break;

  			case IBDELETE: //삭제
				deleteRowCheck(sheetObj, "sel_chk") ;
				break;
			case IBCOPYROW:      // 입력
				var idx = sheetObj.DataCopy();
				sheetObj.CellValue(idx,"sel_chk") = 0;
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
  		formObj.min_ctrt_eff_dt.value = arrParams["min_ctrt_eff_dt"];
  		formObj.max_ctrt_exp_dt.value = arrParams["max_ctrt_exp_dt"];
  		formObj.frm_customer_type.value = arrParams["frm_customer_type"];
  		formObj.frm_contract_type.value = arrParams["frm_contract_type"];
  		formObj.frm_pfmc_unit.value = arrParams["frm_pfmc_unit"];
  		formObj.frm_status.value = arrParams["frm_status"];
  		formObj.frm_ctrt_eff_dt.value = arrParams["frm_ctrt_eff_dt"];
  		formObj.frm_ctrt_exp_dt.value = arrParams["frm_ctrt_exp_dt"];
  		formObj.frm_prop_ofc_cd.value = arrParams["frm_prop_ofc_cd"];
  		formObj.frm_prop_srep_cd.value = arrParams["frm_prop_srep_cd"];
  		
  		formObj.frm_ori_rout_cd.value = arrParams["frm_ori_rout_cd"];
  		formObj.frm_ori_loc_tp.value = arrParams["frm_ori_loc_tp"];
  		formObj.frm_dest_rout_cd.value = arrParams["frm_dest_rout_cd"];
  		formObj.frm_dest_loc_tp.value = arrParams["frm_dest_loc_tp"];
  		formObj.frm_slane_cd.value = arrParams["frm_slane_cd"];
    	  	
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
							var eff_dt = sheetObj.CellValue(rowIdx,"eff_dt");
							var exp_dt = sheetObj.CellValue(rowIdx,"exp_dt");
							
				    		if( eff_dt == "" || exp_dt == ""){
								ComShowCodeMessage("PRI00316","Duration");
								return false;
				    		}
				    		eff_dt = eff_dt.replace(/\/|\-|\./g,"");
				    		exp_dt = exp_dt.replace(/\/|\-|\./g,"");
				    		
				    		if(exp_dt != "" && ComChkPeriod(eff_dt, exp_dt) < 1){
				    			ComShowCodeMessage("PRI00306");
				    			sheetObj.SelectRow = rowIdx;
								return false;
				    		}
							//날짜 기간이 Main화면에서 select된 eff_dt,exp_dt사이의 값이어야만 한다.
				 	     	//입력 duration이 main화면의 min , max를 넘지 않도록 한다.

				 	     	var ctrt_eff_dt = formObj.frm_ctrt_eff_dt.value;
				 	     	var ctrt_exp_dt = formObj.frm_ctrt_exp_dt.value;
				 	     	var unformatCtrt_eff_dt = ctrt_eff_dt.replace(/\/|\-|\./g,"");
				 	     	var unformatCtrt_exp_dt = ctrt_exp_dt.replace(/\/|\-|\./g,"");
				 	     	if(unformatCtrt_exp_dt == "" ){
				 	     		unformatCtrt_exp_dt = "99991230";
				 	     		ctrt_exp_dt = "99991230";
				 	     	}
				 	     	if( eff_dt < unformatCtrt_eff_dt || exp_dt > unformatCtrt_exp_dt ){
				 	     		ComShowCodeMessage("PRI03015",ctrt_eff_dt+"~"+ctrt_exp_dt);
				 	     		sheetObj.SelectRow = rowIdx;
				 	     		return false;
				 	     	}
						}

			 	     	
			    		//중복체크 컬럼들. 해당 컬럼들의 값이 모두 같아야 중복이다.
			          	var colNames = "apr_ofc_cd|cust_tp_cd|ori_rout_cd|ori_loc_tp|dest_rout_cd|dest_loc_tp";
			          	//중복체크
			 	        var dupRow = sheetObj.ColValueDup(colNames,false); 
			 	     	if (dupRow >= 0) {
			 	     		sheetObj.SelectRow = dupRow;
			 	     		ComShowCodeMessage("PRI03023","Approval Office, Customer Type, (Surcharge code)");
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
       * 우선 순위 : ( ori_rout_cd == dest_rout_cd) > chg_cd > cust_tp_cd > apr_ofc_cd 
       * 우선순위가 높은 것이 한개는 낮은 순위 여러개보다 그 점수가 높다.
       * 예를 들어 ori_rout_cd 한개만 매칭되는 경우가 chg_cd,cust_tp_cd,apr_ofc_cd 모두 매칭되는 경우보다 순위가 높다.
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
    	 var colName = sheetObj.ColSaveName(col);
    	 var iScore = 1;
    	 
    	 switch(colName){
	    	 case "apr_ofc_cd" :
	    	 case "cust_tp_cd" :
	    	 case "chg_cd" :
	    	 case "ori_rout_cd" :
	    	 case "dest_rout_cd" :    		 
	    		  if(sheetObj.CellValue(row,"apr_ofc_cd") != "" ){
	    			  iScore += 2;
	    		  }
	    		  if(sheetObj.CellValue(row,"cust_tp_cd") != "" && sheetObj.CellValue(row,"cust_tp_cd") != "M" ){
	    			  iScore += 4;
	    		  }
	    		  if( sheetObj.id == "sheet3" && ComTrim(sheetObj.CellValue(row,"chg_cd")) != ""  ){
	    			  iScore += 8;
	    		  }
	    		  if(  ComTrim(sheetObj.CellValue(row,"ori_rout_cd")) != ""  ){
	    			  iScore += 16;
	    		  }
	    		  if(  ComTrim(sheetObj.CellValue(row,"dest_rout_cd")) != ""  ){
	    			  iScore += 16;
	    		  }	    		  
	    		 sheetObj.CellValue2(row,"score") = iScore ;
	    		 break;
    	 }
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
           case "eff_dt" :
           case "exp_dt" :
          	 openCalendar(sheetObj, row , colName);
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
  				if( !validateRoute(sheetObj,sheetObj.SelectRow,col,rtnVal.cd,"POPUP" ,"O") ){
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
  				if( !validateRoute(sheetObj,sheetObj.SelectRow,col,rtnVal.cd,"POPUP","D" ) ){
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
     function sheet1_OnPopupClick(sheetObj, row, col) {
         comOpenPopup(sheetObj, row, col);
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
         var cal = new ComCalendarGrid();
         cal.select(sheetObj, row , colName, 'yyyy-MM-dd');
         
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
  		if( sheetObj.RowCount > 0 ){
	    	 for(var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow; i++){
	    		 var propNo = sheetObj.CellValue(i,"prop_no");
	    		 var load = sheetObj.CellValue(i,"load");
	    		 var g_rev = sheetObj.CellValue(i,"g_rev");
	    		 var cost_trade = sheetObj.CellValue(i,"cost_trade");
	    		 var cost_office = sheetObj.CellValue(i,"cost_office");
	    		 var cost_op_office = sheetObj.CellValue(i,"cost_op_office");
	    		 var rate = sheetObj.CellValue(i,"rate");
	    		 var surcharge = sheetObj.CellValue(i,"surcharge");
	    		 var cm_office = sheetObj.CellValue(i,"cm_office");
	    		 var cm_trade = sheetObj.CellValue(i,"cm_trade");
	    		 var op_office = sheetObj.CellValue(i,"op_office");
	    		 var cmpb_office = sheetObj.CellValue(i,"cmpb_office");
	    		 var cmpb_trade = sheetObj.CellValue(i,"cmpb_trade");
	    		 var opb_office = sheetObj.CellValue(i,"opb_office");
	    		 //proposal을 key로 이용해 값을 적용할 row을 찾아냄
	    		 var row = parentSheetObj.FindText("prop_no", propNo);
	    		 
	    		 //찾은 row에 simulation한 결과를 반영함
	    		 parentSheetObj.CellValue2(row,"load_new") = load;
	    		 parentSheetObj.CellValue2(row,"g_rev") = g_rev;
	    		 parentSheetObj.CellValue2(row,"cost_new_cm_office") = cost_office;
	    		 parentSheetObj.CellValue2(row,"cost_new_cm_trade") = cost_trade;
	    		 parentSheetObj.CellValue2(row,"cost_new_op_office") = cost_op_office;
	    		 parentSheetObj.CellValue2(row,"cmpb_new_office") = cmpb_office;
	    		 parentSheetObj.CellValue2(row,"cmpb_new_trade") = cmpb_trade;
	    		 parentSheetObj.CellValue2(row,"cm_new_office") = cm_office;
	    		 parentSheetObj.CellValue2(row,"cm_new_trade") = cm_trade;
	    		 parentSheetObj.CellValue2(row,"opb_new") = opb_office;
	    		 parentSheetObj.CellValue2(row,"op_new") = op_office;
	    		 
	    		 //값을 변경한 row의 cell들의 font color를 변경함.
	    		 parentSheetObj.CellFontColor(row,"cmpb_new_office") = parentSheetObj.RgbColor(255, 0, 0);
	    		 parentSheetObj.CellFontColor(row,"cmpb_new_trade") = parentSheetObj.RgbColor(255, 0, 0);
	    		 parentSheetObj.CellFontColor(row,"cm_new_office") = parentSheetObj.RgbColor(255, 0, 0);
	    		 parentSheetObj.CellFontColor(row,"cm_new_trade") = parentSheetObj.RgbColor(255, 0 ,0);
	    		 parentSheetObj.CellFontColor(row,"opb_new") = parentSheetObj.RgbColor(255, 0 ,0);
	    		 parentSheetObj.CellFontColor(row,"op_new") = parentSheetObj.RgbColor(255, 0 ,0);
	    		 
	    		 
	    		 
	    		 //G.Rev 값이 바뀌는 경우는 G.Rev, Rate, Surcharge, Load를 simulation 했을때이기 때문에
	    		 //그 값을 적용 했을때만 G.Rev cell의 font color를 변경한다.
	    		 if( sheetObjects[0].RowCount > 0  //G.Rev
	    				 || sheetObjects[1].RowCount > 0 //Rate
	    				 || sheetObjects[2].RowCount > 0  //Surcharge
	    				 || sheetObjects[4].RowCount > 0 ){ //Load
	    		 		
	    			 parentSheetObj.CellFontColor(row,"g_rev") = parentSheetObj.RgbColor(255, 0, 0);
	    			 
	    		 }
	    		 if( sheetObjects[3].RowCount > 0  //Cost
	    				 || sheetObjects[4].RowCount > 0 ){ //Load 
		    		 parentSheetObj.CellFontColor(row,"cost_new_cm_office") = parentSheetObj.RgbColor(255, 0, 0);
	    	    	 parentSheetObj.CellFontColor(row,"cost_new_cm_trade") = parentSheetObj.RgbColor(255, 0, 0);
	    	    	 parentSheetObj.CellFontColor(row,"cost_new_op_office") = parentSheetObj.RgbColor(255, 0, 0);

	    			 
	    		 }
	    		 if( sheetObjects[4].RowCount > 0 ){ //Load
		    		 parentSheetObj.CellFontColor(row,"load_new") = parentSheetObj.RgbColor(255, 0, 0);

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
          		 //Origin이 정상적인 값인지 검사한다.
   				if( !validateRoute(sheetObj,row,col,value,"","O" ) ){
   					//정상적인 값이 아니면 입력한 route를 삭제한다.
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
    				if( !validateRoute(sheetObj,row,col,value ,"","D") ){
  					sheetObj.CellValue2(row, "dest_rout_cd") = "";
  					sheetObj.CellValue2(row, "dest_loc_tp") = ""; 	  
  					sheetObj.SelectCell(row, col)
  				}
          	 }
          	 break;
           }
       }
       

       

       /**  
        * 사용자가 입력한 Svc Scope가 USA에 속하는지 검사한다.
        * 
        *  
        * <br><b>Example :</b>
        * <pre>
        * </pre>
        * 
        * @return boolean, true: US에 해당하는 SVC Scope임, false: 기타지역 SVC Scope임
        */   
       function isUSArea( ){
       	var svc_scp_cd = document.form.frm_svc_scp_cd.value;
       	 if( svc_scp_cd == "TPE" || svc_scp_cd == "TPW" || svc_scp_cd == "TAE"|| svc_scp_cd == "ASE"|| svc_scp_cd == "TAW"|| svc_scp_cd == "ASW"|| svc_scp_cd == "MME"|| svc_scp_cd == "SAS"|| svc_scp_cd == "SAN" ){
       		 return true;
       	 }else{
       		 return false;
       	 }
       }
       /**  
        * 사용자가 입력한 route 가 유효한지 검사한다.
        * 
        *  
        * <br><b>Example :</b>
        * <pre>
        * </pre>
        * 
        * @return boolean, true: 유효한 Route, false: 유효하지 않은 route
        */     
      function validateRoute(sheetObj,row,col,locCd,checkType,oriDestCd){
 		var formObj = document.form;
 		var svc_scp_cd = formObj.frm_svc_scp_cd.value;
 		var colName = sheetObj.ColSaveName(col);
 		if( locCd == "US" &&  isUSArea( ) ){
 			ComShowCodeMessage("PRI03014"); // Please input region code only for US
 			return false;
 		}else {
 			//region code는 US region만 넣을수 있다. US region인지 검사 한다.
 			if( locCd.length == 3 &&  isUSArea( ) ){
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
		//Service Scope에서 선택 가능한 origin dest인지 확인 한다.
		formObj.f_cmd.value = SEARCH02;
		var param = FormQueryString(formObj);
		if(  locCd.length == 3   ){
			param += "&loc_tp_cd=R";
			param += "&rgn_cd="+locCd;
		}else if( locCd.length == 2   ){
			param += "&loc_tp_cd=C";
			param += "&cnt_cd="+locCd;
		}
		param += "&ori_dest_cd="+oriDestCd;
		param += "&svc_scp_cd="+svc_scp_cd;
		
		var sXml = sheetObj.GetSearchXml("ESM_PRI_6032GS.do", param );
		var is_success = ComGetEtcData(sXml, "IS_SCOPE_SUCCESS");
		if (is_success.length <= 0 || is_success == "F") {
			ComShowCodeMessage("PRI03029"); // SVC Scope doesn’t cover  for origin or destination you inputted.
	         								// Please check input data.
			return false;
		}
		
		// 입력한 code가 2자리 이면 contry code, 3자리 이면 region이 된다.
		if( locCd.length == 2 ){
			if(colName == "ori_rout_cd"){
				sheetObj.CellValue(row, "ori_loc_tp") = "C";
			}else if(colName == "dest_rout_cd"){
				sheetObj.CellValue(row, "dest_loc_tp") = "C";
			}
		}else if( locCd.length == 3 ){
			if(colName == "ori_rout_cd"){
				sheetObj.CellValue(row, "ori_loc_tp") = "R";
			}else if(colName == "dest_rout_cd"){
				sheetObj.CellValue(row, "dest_loc_tp") = "R";
			}
		}
		
		
 		return true;
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
 		//sheetObj.LoadSearchXml(sXml);
 	   	  
 		 
         var arrXml = sXml.split("|$$|");	
 
         for(var i=0 ; i < arrXml.length ; i++){
         	if ( arrXml[i] != null)		sheetObj.LoadSearchXml(arrXml[i],true); 	
         }
         sheet6LoadEnd(sheetObj); 	   	 
 	   	 
 	   	 ComOpenWait(false);
 		 
 		 
 		 
 		 
 		 
      }
            
	/* 개발자 작업  끝 */