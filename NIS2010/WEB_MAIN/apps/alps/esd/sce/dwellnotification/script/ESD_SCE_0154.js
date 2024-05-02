/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0154.js
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
* 1.0 Creation
===============================================================================================
* History
* 2011.12.28 전준영 [CHM-201115163] E-mailing Service List for Dwell/Delay Notification상에 조회 Column 추가요건반영
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0154 : ESD_SCE_0154 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SCE_0154() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject         = setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;
        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

        			case "btn_new":
        				sheetObject.RemoveAll();
        				formObject.reset();
        				//getScNoList();
        				loadPage();
         				break;

                    case "btn_ctrt_cust":
                    	openCustomerPop(false,'cust_cd');
                    	break;        			         				
         				
        			case "btn_retrieve":
        				doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;         				
         				
    				case "btn_save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break ;

    				case "btng_rowadd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break ;
    				
    				case "btng_rowdelete":
    					sheetObject.RowHidden(sheetObject.SelectRow)=true;
    					sheetObject.RowStatus(sheetObject.SelectRow) = "D"; 
//    				 	   sheetObject.RowDelete(sheetObject.SelectRow,false);
    				break ;

    				case "btn_rowcopy":
    					sheetObject.DataCopy(0);
    				break ;

                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
    				ComShowMessage(ComGetMsg('COM12111')) ;
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
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
             var cnt = 0; 
           	 switch(sheetNo) {
             case 1:      //IBSheet1 init
                	 with (sheetObj) {
     	                // 높이 설정
     	                style.height = 380;
     	                //전체 너비 설정
     	                SheetWidth = mainTable.clientWidth;
     	
     	                //Host정보 설정[필수][HostIp, Port, PagePath]
     	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     	
     	                //전체Merge 종류 [선택, Default msNone]
     	                MergeSheet = msHeaderOnly;
     	
     	               //전체Edit 허용 여부 [선택, Default false]
     	                Editable = true;
     	
     	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     	                InitRowInfo( 1, 1, 3, 100);
     	
     	                var HeadTitle = "|S/C No.|Customer Code|Name|MQC|UNIT|Request Office|EFF Date|EXP Date|E-mail List|exist flg";
     	                var headCount = ComCountHeadTitle(HeadTitle);
     	                
     	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     	                InitColumnInfo(headCount, 0, 0, true);
     	
     	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
     	                InitHeadMode(true, true, false, true, false,false);
     	
     	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     	                InitHeadRow(0, HeadTitle, true);
     	
     	                //데이터속성    [   ROW, COL,   DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     	               // InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter, false, "ibflag");
     	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter, false, "ibflag");
     	                InitDataProperty(0, cnt++ , dtData,     	77,   daCenter, false, "sc_no",          false, "", dfNone, 	  0, false, false ,12);
     	                InitDataProperty(0, cnt++ , dtData,      	100,  daCenter, false, "cust_cd",   true, "", dfNone, 	  0, false, false, 8);										
     				    InitDataProperty(0, cnt++ , dtData,     	350,  daLeft, false, "ctrt_pty_nm",     false, "", dfNone, 	  0, false, false);
     					InitDataProperty(0, cnt++ , dtData,      	80,   daRight, false, "prop_mqc_qty",   false, "", dfNone, 	  0, false, false);										
     				    InitDataProperty(0, cnt++ , dtData, 		80,   daCenter, false, "unit_nm", 		 false, "", dfNone,       0, false, false);
     					InitDataProperty(0, cnt++ , dtData,      	100,  daCenter, false, "prop_ofc_cd",   false, "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtData,     	72,   daCenter, false, "eff_dt",     	 false, "", dfDateYmd,    0, false, false);
     	                InitDataProperty(0, cnt++ , dtData,      	72,   daCenter, false, "exp_dt",         false, "", dfDateYmd,    0, false, false);
     	                InitDataProperty(0, cnt++ , dtData,      	72,   daCenter, false, "email_list_cnt", false, "", dfNone,    0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	72,   daCenter, false, "mst_exist_flg",  false, "", dfNone,    0, false, false);
     	                InitDataValid(0, "sc_no", vtEngUpOther, "0123456789");
     	               InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
     	                DataLinkMouse('email_list_cnt') = true;
     	                WaitImageVisible=false;
     	            }
     	            break;  
                
            }
        }

        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	var formObj = document.form;
    	    formObj.ctrt_exp_dt.value=ComGetNowInfo('ymd','-');
    	    formObj.ctrt_eff_dt.value='9999-12-31';
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            for(var k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
        	
            getScNoList();
            
            for(var k = 0; k < comboObjects[0].GetCount(); k++){
        		comboObjects[0].CheckIndex(k) = true; 
            }
            
            initControl();
     
        }

    	// Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
            	case IBSEARCH:      //조회
            		if(validateForm(sheetObj,formObj,sAction)){
            			formObj.f_cmd.value = SEARCH;
//            			alert(SceFrmQryString(formObj));
            			ComOpenWait(true);
            			sheetObj.DoSearch4Post("ESD_SCE_0154GS.do", SceFrmQryString(formObj));
            		 }
            	break;
            	case IBSAVE:
        		//if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value = MULTI;
            		ComOpenWait(true);
            		sheetObj.DoSave("ESD_SCE_0154GS.do", SceFrmQryString(formObj));
            		ComOpenWait(false);
        		// }
        		break;
            	case IBINSERT:
            		var Row = sheetObj.DataInsert();
            	    sheetObj.CellEditable(Row ,'cust_cd') = true;
            	break;
            	case DATACOPY:
           		 sheetObj.DataInsert();
                break;
            	case ROWDELETE:
            	   var Row = sheetObj.SelectRow(); 
            	   sheetObj.RowDelete(Row,false);
                break;
            }
        }
    	/**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
       		switch(sAction) {
    	  	case IBSEARCH:
  				 var eff_dt = formObj.ctrt_exp_dt.value.replace(/-/g,"");
  		  		 var exp_dt = formObj.ctrt_eff_dt.value.replace(/-/g,"");  
  		 			if(parseInt(eff_dt) > (parseInt(exp_dt))){
  	      	    	//	ComShowMessage("From 은  To 날짜보다 이후 일수는 없습니다.");
  	      	    	    ComShowCodeMessage("SCE90050","S/C EFF To Date","S/C EFF From Date");
  	      	    		formObj.ctrt_exp_dt.focus();
  	      	    		formObj.ctrt_eff_dt.value ="";
  	      	    		return false;
  	      	    	}
  		 			return true;
  		       break;
  		  	}
    	 }
 
    	// 코보 오브젝트 설정
         function setComboObject(combo_obj){
     		comboObjects[comboCnt++] = combo_obj;
     	}

         // 키 입력 이벤트 핸들러
       	 function initControl() {
    		 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
             axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
             axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
             axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
//             axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
             axon_event.addListenerForm	('focusin',			'form_focusin',			document.form); //- 클릭시
     	     axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
     	     axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	 }
 
       	 // SC Code 콤보 입력
      	  function initCombo(comboObj, comboNo) {
  		    switch(comboObj.id) {
  		        case "sc_pfx_cd":
  		            with(comboObj) {
  		            	DropHeight = 120;
  		            	SetColAlign("left|left");
  		            	SetColWidth("50|350");
  		            	MultiSelect = true;
  		            	//MaxSelect = 1;
  		            	UseAutoComplete = true;
  		            
  		            	IMEMode = 0;
  		            	ValidChar(2, 0);
  		            }
  		            break;
  		    }
  		}

      	  // SC No List Set
    	 function getScNoList() {
    		 
 		    var sheetObj = sheetObjects[0];
			var formObj = document.form;
			var query = SceFrmQryString(formObj);
			sheetObj.RemoveEtcData();
			sheetObj.DoSearch4Post("ESD_SCE_0140GS.do", query);
			eval(sheetObj.EtcData('sc_no'));

			var comboObj = document.sc_pfx_cd;
			comboObj.RemoveAll();
			var scCodeArray = scCode.split('|');
			var scTextArray = scText.split('|');
			for(k=0; k < scCodeArray.length; k++){
				comboObj.InsertItem(k, scCodeArray[k]+'|'+scTextArray[k], scCodeArray[k]);
			}
    	}

         /**
          * ETD,ETB 기간 선택 달력 띄우기
          */
       	function callDatePop(val){
       		var cal = new ComCalendarFromTo();
       		if (val == 'EFF Date'){
       			cal.select(form.ctrt_exp_dt,  form.ctrt_eff_dt,  'yyyy-MM-dd');
       		}
       		
       	}
          
          /**
           * 컬럼 입력된값을 확인하여 조회를 해온다.
           * 
           */  
       	function sheet1_OnChange(sheetObj,Row, Col, Value) {
       
      		 if(sheetObj.ColSaveName(Col) == "cust_cd"){
      			 var cust_cd = sheetObj.Cellvalue(Row,'cust_cd');
      			 if(cust_cd.length > 2){
      				 var f_cmd = COMMAND01;
      				 var sXml = sheetObj.GetSaveXml("ESD_SCE_0151GS.do", "row=" + Row +"&cust_cd=" + sheetObj.CellValue(Row,'cust_cd')+"&f_cmd=" + f_cmd);
      				 if( ComGetEtcData(sXml, "knt")!=1){
      					ComShowCodeMessage("COM130402","Customer Code");
      					sheetObj.CellValue2(Row,Col)= "";
      				 }else if(ComGetEtcData(sXml, "knt")==1){
      					 var f_cmd = SEARCH01;
      					 sheetObj.DoRowSearch("ESD_SCE_0154GS1.do" ,"row=" + Row +"&cust_cd=" + sheetObj.CellValue(Row,'cust_cd')+"&f_cmd=" + f_cmd ,false);
      					 sheetObj.CellValue2(Row,'cust_cd')=cust_cd.substring(0,2)+ComLpad(cust_cd.substring(2),6,0);
      				 }
      			 }
      			 
      		 }
      	 }
 
          
   /**
    * 컬럼 입력된값을 확인하여 조회를 해온다.
    * 
    */  
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
          var idx = coSceSaveNameCol(sheetObj, 'email_list_cnt');
          var rowcount = sheetObj.RowCount;
          sheetObj.ColFontUnderline('email_list_cnt') = true;
          sheetObj.ColFontColor('email_list_cnt')= sheetObj.RgbColor(0, 0, 255);
          sheetObj.RangeFontBold(1,idx,rowcount,idx)=true;
       //   sheetObj.CellFont("FontBold", 8, "email_list_cnt") = true;
          ComOpenWait(false);
          
  		 
   	 }
  
    // 신규프로젝트 No: S2Q-09P-004
    // VVD 더블클릭시 BayPlan POPUP 호출
    function sheet1_OnDblClick(sheetObj ,Row, Col){
   	    var formObject = document.form;
   	    var colName = sheetObj.ColSaveName(Col);
   	    var dtValue = sheetObj.CellValue(Row,Col);
   	    switch(colName) {
   	    case "email_list_cnt":
   	    	if (sheetObj.CellValue(Row, Col) != "" && sheetObj.CellValue(Row, 'ibflag')!= "I") {
	   	    	var paramUrl = "sc_no="+sheetObj.CellValue(Row,'sc_no')+"&row=" + Row+"&cust_cd="+sheetObj.CellValue(Row,'cust_cd');
	            window.showModalDialog("ESD_SCE_0163.do?"+paramUrl, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:950px;dialogHeight:500px");  
   	    	}
            break;
        }
    }
       	 
 //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /** 
     * Object 의 Keypress 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //숫자만 입력
            case "number": //숫자만 입력
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "uppernum":
                ComKeyOnlyAlphabet('uppernum');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }
 
    // SC Code 변경 이벤트 핸들
    function sc_pfx_cd_OnChange(value,text){
    	var formObj = document.form;
    	var textArray = text.split(',');
    	if( textArray.length >= 2){
    		formObj.sc_no.value="";
    		formObj.sc_no.disabled = true;
    		formObj.sc_no.className ="input2";
    	}else{
    		formObj.sc_no.disabled = false;
    		formObj.sc_no.className ="input";
    	}
    }
  
    // SC No Flag 변경 이벤트 핸들
    function changeSCNoFlg() {
        var formObject = document.form;
	    if(formObject.SCNoFlg.checked ){
        	 for(var k = 0; k < comboObjects[0].GetCount(); k++){
         		comboObjects[0].CheckIndex(k) = true; 
             }
                  
         } else {
        	 for(var k = 0; k < comboObjects[0].GetCount(); k++){
         		comboObjects[0].CheckIndex(k) = false; 
             }
         }
    }
    
    // 폼 값 변경 이벤트 핸들
    function obj_change() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    }
    
    // Cust_Code Setting
    function changeCustNoText(){
    	formObj = document.form;
    	formObj.cust_cd.value = formObj.cust_cnt_cd.value + formObj.cust_seq.value;
    }
    
    // Cust_Cnt_Cd 입력후 자동으로 Cust_Seq 로 Focus
    function focusCustSeq(){
    	formObj = document.form;
    	if(formObj.cust_cnt_cd.value.length == 2){
    	formObj.cust_seq.focus();
    	}
    }

    // Customer Code 조회 팝업 오픈 
	function openCustomerPop(multi, custCd, custNm, ofcCd, custSgmt){
		var formObj = document.form ;
		var param   = "" ;
		var display = getCommPopDisplay(multi) ;

		param  = "?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "cust_cd", custCd) ;
		param += getURLParam(multi, "cust_nm", custNm) ;
		param += getURLParam(multi, "ofc_cd",  ofcCd) ;

		custCdFld   = custCd ;
		custNmFld   = custNm ;
		ofcCdFld    = ofcCd ;
		custSgmtFld = custSgmt ;
		multiChkYN  = multi ;
		ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 450, 'setValFromCustomerPop', display, true) ;
	}
	
	// 팝업에서 조회된 Customer Code Set
	 function setValFromCustomerPop(rowArray){
		var colArray = null ;
		var formObj = document.form;
		
		colArray = rowArray[0] ;
		formObj.cust_cnt_cd.value = colArray[3].substring(0,2);
		formObj.cust_seq.value = colArray[3].substring(2);
	}
	 
	 // 저장 이벤트 처리 후 로직
	   function sheet1_OnSaveEnd(sheetObj, errMsg) {
		   if (errMsg == "") {
			   ComShowCodeMessage("COM130102", "E-mailing Service List for Dwell/Delay Notification");
			   doActionIBSheet(sheetObj,document.form,IBSEARCH);
		   }
	   }



	/* 개발자 작업  끝 */