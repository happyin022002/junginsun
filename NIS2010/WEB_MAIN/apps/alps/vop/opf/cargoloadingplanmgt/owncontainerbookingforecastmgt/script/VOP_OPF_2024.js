/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_0021.js
 *@FileTitle : Own Container Booking Forecast Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.07.07 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 * 2011.11.29 [CHM-201114860-01] 김민아 [OPF] CBF Inquiry Excel Download 기능개선요청
 * 2011.12.12 [CHM-201114818-01] Split 03-특수화물(DG) 시스템 개선 요청(Segregation Group name 변경 외 3건)
 * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    function vop_opf_2024() {
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
				case "btn_Retrieve":
	
				   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
					
			 	   break;
			 	 
				case "btn_Close":
					self.close();
					break;   
					
				case "btn_crr_cd":
					    ComOpenPopup("/hanjin/COM_ENS_0N1.do", 450, 455, "popupcrrcd", "1,0,1,1,1", true, false, 0, 0, 0, "popcrr");		
		        		break;	
		        		
				case "btn_Save":
					
					   doActionIBSheet(sheetObjects[0],document.form,IBSAVE);	
						
				 	   break;
				 	   
			    case "btns_period": // From 달력버튼
		  	        	var cal = new ComCalendarFromTo();
		  	        	cal.endFunction = "cal_end_func";
		  	        	cal.select(formObject.fr_dt, formObject.to_dt, 'yyyy-MM-dd');
		  	            break;
		  	            
			    case "btn_Close":
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
         
     	var formObj = document.form;
        formObj.fr_dt.value = frDt;
        formObj.to_dt.value = toDt;
        initControl();
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }
    

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl(){
    	 axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리    	 
         axon_event.addListenerFormat('focus',     'obj_activate',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
         axon_event.addListenerFormat('keypress',  'obj_keypress',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
         axon_event.addListenerFormat('blur',	  'obj_blur',	    form); 
         axon_event.addListenerForm  ("keyup",    'obj_keyup',      form);
         
     	axon_event.addListener  ('keypress', 'eng_keypress', 'slan_cd'); //Code 입력 시 영문 대문자만 입력하기
     	axon_event.addListener  ('change', 'change_event', 'slan_cd');   //Input Box 이벤트
     	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
     }
          
      /**
       * OnBlur
       */
      function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
      }     

     /**
      * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
      **/
     function obj_activate(){
         ComClearSeparator(event.srcElement);
     }
 	
     function obj_blur() {
 		var formObj = document.form;
 		switch(event.srcElement.name){
 			case "fr_dt":	case "to_dt":
 			ComAddSeparator(event.srcElement);
 			break;    	 		
 		}
 	}
  	
     // 업무 자바스크립트 OnFocus 이벤트 처리
     function obj_focus() {
    	 
     	switch(event.srcElement.name){ 
 	    	case "fr_dt":	case "to_dt":
 	    		ComAddSeparator(event.srcElement);
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
         case 1:      //sheet1 init
             with (sheetObj) {
        	//높이 설정
				style.height = 400;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 2, 100);
                
				var HeadTitle  = "|SEQ|EDI|EDI|EDI|EDI|EDI|EDI|SML|SML|SML|SML|SML|QTY||||";
				var HeadTitle1 = "|SEQ|OPR|VVD|POL|POD|ETA|T/S|OPR|VVD|Yard|POD|T/S|QTY||||";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			 	InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);
				
				//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	 "ibflag");
				InitDataProperty(0, cnt++, dtDataSeq, 	    40, 	daCenter, 	true, 	 "seq"			     	,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++, dtData, 			70, 	daLeft, 	true, 	 "crr_nm"				,false	,""		,dfNone	     ,0	 ,false	  ,false	,3);
				InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	 "edi_vsl_nm"	  	    ,false	,""		,dfNone	     ,0	 ,false	  ,false	,5);
				InitDataProperty(0, cnt++ ,dtData,          50,     daCenter,   true,    "edi_pol_yd_cd"        ,false  ,""     ,dfNone      ,0  ,false   ,false    ,5);
				InitDataProperty(0, cnt++ ,dtData,          50,     daCenter,   true,    "edi_pod_cd"           ,false  ,""     ,dfEngUpKey  ,0  ,false   ,false    ,5);
				InitDataProperty(0, cnt++ ,dtData,          70,     daCenter,   true,    "eta_dt"               ,false  ,""     ,dfNone      ,0  ,false   ,false    ,5);
			 	InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	 "iso_cntr_tpsz_cd"	    ,false	,""		,dfNone	     ,0	 ,false	  ,false	,2);
				InitDataProperty(0, cnt++, dtPopupEdit, 	50, 	daCenter, 	true, 	 "crr_cd"				,true	,""		,dfEngUpKey	 ,0	 ,true	  ,false	,3);
				InitDataProperty(0, cnt++, dtData, 		    80, 	daCenter, 	true, 	 "vvd"	  	            ,true	,""		,dfNone	     ,0	 ,true    ,true	    ,9);
				InitDataProperty(0, cnt++, dtCombo, 	    80, 	daCenter, 	true, 	 "yd_cd"		        ,false	,""		,dfNone	     ,0	 ,true	  ,false	,2);
				InitDataProperty(0, cnt++ ,dtPopup,         70,     daCenter,   true,    "pod_cd"               ,true   ,""     ,dfEngUpKey  ,0  ,true    ,true     ,5);
                InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	 "cntr_tpsz_cd"		    ,true	,""		,dfNone	     ,0	 ,true	  ,false    ,2);
				InitDataProperty(0, cnt++, dtData, 			20, 	daCenter, 	true, 	 "cnt"		            ,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, 	true, 	 "pol_clpt_ind_seq"		,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, 	true, 	 "edi_rcv_dt"	    	,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, 	true, 	 "edi_snd_id"		   ,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++ ,dtHidden,        70,     daCenter,   true,    "etd_dt"               ,false  ,""     ,dfNone      ,0  ,false   ,false    ,5);
				
				InitDataValid(0,  "crr_cd",       vtEngUpOther);
				InitDataValid(0,  "cntr_tpsz_cd", vtEngUpOther, "1234567890");
				InitDataValid(0,  "vvd", vtEngUpOther, "1234567890");
				
         }
         break;
             
        
      }
   }

     /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "ymd":	
    			
    	        ComKeyOnlyNumber();
    			break;    			

    		default:    	    	
    			ComKeyOnlyAlphabet("num");					//공통기준:영문, 숫자만을 인식
	    		break;
    	}
    }
   
   function makeComma(srcValue){
		if(srcValue.length > 9){
	  		srcValue = srcValue.substring(0,9);
	  	}
			l=srcValue.length-3;
			while(l > 0) {
				srcValue=srcValue.substr(0,l)+","+srcValue.substr(l);
				l-=3;
			}    		
	  	return srcValue;
	  }
   
   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
	   sheetObj.ShowDebugMsg = false;
      // var sheetObject1 = sheetObjects[0];

		
     switch(sAction) {
       case IBSEARCH:        //조회
          if(validateForm(sheetObj,formObj,sAction)){
        	  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH01;

			  sheetObj.DoSearch("VOP_OPF_2024GS.do", FormQueryString(formObj));

			  ComOpenWait(false);
          }
       break;
       
       case  COMMAND03:  // VVD
    	   sheetObj.WaitImageVisible = false;
    	   formObj.f_cmd.value   =  SEARCH03;            
           var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
    	   var sXml = sheetObj.GetSearchXml("VOP_OPF_2024GS.do", sParam);
	       var vvdFlg = ComGetEtcData(sXml, "VALIDVVD");
           return vvdFlg;
	       break;
   
       
       case COMMAND02:
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = COMMAND02;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			var sXml = sheetObj.GetSearchXml("VOP_OPF_2024GS.do", sParam);
			var tyszvalid = ComGetEtcData(sXml, "VALIDTYPESIZE");
		    return tyszvalid;
			break;
       
      case IBSAVE:	
    	    sParam = ComGetSaveString(sheetObjects);
	 		sheetObj.Redraw = false;
			formObj.f_cmd.value = MULTI;	

			sParam += "&" + FormQueryString(formObj);	 			
			sheetObj.DoSave("VOP_OPF_2024GS.do", sParam, -1, false);
			
			doActionIBSheet(sheetObj, formObj, IBSEARCH); 
			sheetObj.Redraw = true;
			break;
     
      }
   }
   

	 function sheet1_OnClick(sheetObj, Row, Col) {
		 var colName = sheetObj.ColSaveName(Col);	
		
				switch (colName) {
					case "yd_cd": 
						
						 var val = sheetObj.CellValue(sheetObj.SelectRow, "edi_pol_yd_cd") ;
						 var vvd = sheetObj.CellValue(sheetObj.SelectRow, "vvd") ;
						  selectYard( Row,Col , val, vvd);
						  break;
						
				
			}
	 }
	 
	 function selectYard( Row,Col , yardVal, vvdVal) {
			var sheetObj = sheetObjects[0];
		  	var formObj = document.form;
		  	var prefix = "sheet1_";
            
		  	vslVal = vvdVal.substring(0,4);
		  	voyVal = vvdVal.substring(4,8);
		  	dirVal = vvdVal.substring(8,9);
		  		
		 
		  	formObj.f_cmd.value = SEARCH02;//2번으로 .. 
		  	var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		  	param = param + "&edi_pol_yd_cd=" + yardVal+ "&vsl_cd=" + vslVal + "&skd_voy_no=" + voyVal + "&skd_dir_cd=" + dirVal  ; 

		  	//2번으로 .. 
		  	var sXml = sheetObj.GetSearchXml("VOP_OPF_2024GS.do", param );

		  //	var comboItems = ComGetEtcData(sXml, "lane");
		  	var arrXml = sXml.split("|$$|");
		  	var arrCombo1 = ComXml2ComboString(arrXml[0], "sheet1_yd_cd", "sheet1_yd_cd");
			var selectYdcd;
			
			if (arrCombo1 != null) {			
				var arrVal  = arrCombo1[0].split("|");
				var arrName = arrCombo1[1].split("|");
				var itemNm  = "";
				for ( var j = 0; j < arrVal.length; j++) {
					if (j == 0){ 
						itemNm = itemNm + arrVal[j];
						selectYdcd = arrVal[j];
					}else{
						itemNm = itemNm + "|" + arrVal[j];
					}
				}
				
				sheetObj.InitDataCombo(0, "yd_cd", " |"	+ itemNm, " |" + arrCombo1[0]);
				// Fist Code Setting.
				//sheetObj.CellValue2(Row,'yd_cd') = selectYdcd;
			}
		 
	 }	
	
	
	
   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var rt = true;
		switch (sAction) {
			case IBSEARCH: //조회
		
				var fdt = formObj.fr_dt.value;
				var tdt = formObj.to_dt.value;	
	
				
				if(fdt =="" && !tdt =="") {//from이 없는 경우
					ComShowCodeMessage("OPF50009", "from date");
					formObj.fr_dt.focus();
					rt =  false;
				} else if (!fdt =="" && tdt =="") {
					ComShowCodeMessage("OPF50009", "to date");
					formObj.to_dt.focus();
					rt =  false;
				}
				

			break;
		}
		return rt;
	}
	
	/**
	  * Sheet1 OnPopupClick 이벤트 처리  
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnPopupClick(sheetObj, Row, Col)
     {   
         var prefix = sheetObj.id+"_";
         with(sheetObj)
         {
             if( sheetObj.ColSaveName(Col) == 'pod_cd' ){
                 var port_cd =  sheetObj.CellValue(Row, Col);
                 ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "setSheet1_PopupCallback_port", "0,0", true, false, Row, Col, 0);

             }
             
             else if(sheetObj.ColSaveName(Col) == 'crr_cd' ){
                 var crr_cd =  sheetObj.CellValue(Row, Col);
                 ComOpenPopup('/hanjin/COM_ENS_0N1.do',  770, 480, "PopupCallback_CrrCd", "1,0,0", true, false, Row, Col, 0);

             }
             
         }
     }
	
     function PopupCallback_CrrCd(aryPopupData,row, col, seetIdx){ 
 		var formObj = document.form;
 		sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][3];  
   }
     
 	
 	function apply_flg(){
   	   var sheetObject1 = sheetObjects[0];
       var formObject = document.form;
  
       if(formObject.apply_yn[0].checked) ComBtnDisable("btn_Save");
       else   ComBtnEnable("btn_Save");
       
 	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
 	   
 	  
 	}
     
     /**
      * Calendar From To 선택 후 호출하는 함수
      */
     function cal_end_func(){
     	sheetObjects[0].RemoveAll();
     }
     
     /**
      * Sheet1 OnPopupClick 이벤트 처리에 대한 CallBack 함수 
      * @param aryPopupData
      * @param row
      * @param col
      * @param seetIdx 
      * @return
      */
     function setSheet1_PopupCallback_port(aryPopupData,row, col, seetIdx){
         var formObj = document.form;
         sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][2];
     }
	 
	  function sheet1_OnChange(sheetObj, row, col, value){
			var formObj = document.form;
			var colName = sheetObj.ColSaveName(col);
		
		
		 	switch(colName) {
				case "cntr_tpsz_cd":
		 			formObj.cntr_tpsz_cd.value 		 = sheetObj.CellValue(row, "cntr_tpsz_cd");
		 			
		 				 var data = doActionIBSheet(sheetObj, formObj, COMMAND02);
						
		 				 if(data == 'N'){
								ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "cntr_tpsz_cd"));
								sheetObj.CellValue2(row, "cntr_tpsz_cd") = "";
						}
				break;
				
				
				case "vvd":
			     
				var vvd  = sheetObj.CellValue(row, "vvd");
					
				formObj.vsl_cd.value 		 = vvd.substring(0,4);
				formObj.skd_voy_no.value 		 = vvd.substring(4,8);
				formObj.skd_dir_cd.value 		 = vvd.substring(8,9);
				
 				 var data = doActionIBSheet(sheetObj, formObj, COMMAND03);
 		
 				 if(data == 'N'){
						ComShowCodeMessage("OPF50004", sheetObj.CellValue(row, "vvd"));
						sheetObj.CellValue2(row, "vvd") = "";
				}
 				 
		    break;

				
		 	}
		}

	  
		/**
	   * Carrier Code Pop-up 띄운 후 data 받는 function
	   * @param rowArray
	   * @return
	   */
	  function popupcrrcd(rowArray){
	  	var formObj = document.form;
	  	var fstArray = rowArray[0];
	  	var CrrCd  = fstArray[3];
 	
	   formObj.crr_cd.value = CrrCd;

	  }
  
	/* 개발자 작업  끝 */