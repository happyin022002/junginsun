/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0493.js
*@FileTitle : ESM_BKG-0493
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0493() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	 
    }
    /* 개발자 작업 */
   
 // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

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
                			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                			break;
    						
    					case "btn_Save":
    						doActionIBSheet(sheetObject1, formObject, IBSAVE);
    						break;
    					 
    					case "btn_ViewResponse":
    						 
							var sUrl = "/hanjin/ESM_BKG_0492.do?pgmNo=ESM_BKG_0492&sr_sts_cd="+formObject.sr_sts_cd.value+"&rgst_dt="+formObject.rgst_dt.value
							+"&rjct_dt="+formObject.rjct_dt.value+"&vsl_auth_no="+formObject.vsl_auth_no.value+"&sr_sts_desc="+escape(formObject.sr_sts_desc.value)
							+"&sr_cmt_desc="+escape(formObject.sr_cmt_desc.value)+"&decl_bl_qty="+formObject.decl_bl_qty.value;
		 					ComOpenWindowCenter(sUrl, "ESM_BKG_0492", 400, 390, false);
    						break;
    					
    					case "btn_Transmit":
    						doActionIBSheet(sheetObject1,document.form,COMMAND01);
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
        	var formObj = document.form;
    		for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);                 
    		}
    		initSheetData(sheetObjects[0], formObj);
    		
    		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);  
    		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');     
        	axon_event.addListenerForm("click", "obj_Clicked", document.form);
        	formObj.frm_vvd_number.focus();
        	
        	// 라디오 버튼 조건 체크
    		for (var i = 0; i < document.form.port_flg.length; i++) {
    			if (document.form.port_flg[i].checked == true) {
    				document.form.port_flg[i].click();
    			}
    		}
    	}
         
         // 시트 데이터 초기화
     	function initSheetData(sheetObj, formObj) {
     		 
     		sheetObj.RemoveAll();
     		sheetObj.DataInsert(-1);	     		
     		IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");		
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
     			
     			case "sheet1":
     					with (sheetObj) {

     						// 높이 설정
     						style.height = 302;
     						//전체 너비 설정
     						SheetWidth = mainTable.clientWidth;
     						
     						//Host정보 설정[필수][HostIp, Port, PagePath]
     						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     						
     						//전체Merge 종류 [선택, Default msNone]
     						MergeSheet = msHeaderOnly;
     						
     						//전체Edit 허용 여부 [선택, Default false]
     						Editable = true;
     						
     						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     						InitRowInfo(1, 1, 3, 100);
     						
     						//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
     						var HeadTitle1 = "|| |vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|depature_port|arrival_port|aaa|cre_usr_id|cre_dt|vps_eta_dt|vvd_number|user_ofc_cd||cstms_vvd_cd|msg_ref_no";
     						var headCount = ComCountHeadTitle(HeadTitle1);

     						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     						InitColumnInfo(headCount, 0, 0, true);
     						
     						// 해더에서 처리할 수 있는 각종 기능을 설정한다
     						InitHeadMode(true, true, false, true, false,false);
     						
     						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     						InitHeadRow(0, HeadTitle1, true);
     						
     						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     						InitDataProperty(0,		cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
     						InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vsl_rgst_no", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vps_eta_dt", false, "", dfNone, 0, false, false);    						
     						InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vps_eta_dt_time", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vps_etd_dt", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vps_etd_dt_time", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_eng_nm", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_rgst_cnt_cd", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"cap_nm", false, "", dfNone, 0, false, false);     						
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"depature_port", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"arrival_port", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_nm", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_nm2", false, "", dfNone, 0, false, false);    						    					
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_auth_no", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vessel_reg_no", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_cd", false, "", dfNone, 0, false, false);    						    					
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"skd_voy_no", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"skd_dir_cd", false, "", dfNone, 0, false, false);   
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"cstms_vvd_cd", false, "", dfNone, 0, false, false);
     						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"msg_ref_no", false, "", dfNone, 0, false, false);
     						CountPosition = 0;
     				}
     				break;


     		}
     	}
     	
     	/**
     	 * 
     	 * @param sheetObj
     	 * @param formObj
     	 * @param sAction
     	 * @return
     	 */
     	 function doActionIBSheet(sheetObj,formObj,sAction) {     
     		sheetObj.ShowDebugMsg = false;
            
          	 switch(sAction) {
      			
          	 	case IBSEARCH:
          	 	    if(!validateForm(sheetObj,formObj,sAction)) {
          	 	    	return false;
          	 	    }   
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); 
          	 	    formObj.f_cmd.value = SEARCH;       	 	    	
          	 	    formObj.vsl_cd.value     = formObj.frm_vvd_number.value.substring(0,4);
          	 	    formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
          	 	    formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);         
          	 	    formObj.call_port.value = formObj.frm_call_port_cd.value;
          	 	    
          	 	    for(var i=1; i<=rowCnt; i++) {						
						sheetObj.CellValue2(i,"vsl_cd") = formObj.frm_vvd_number.value.substring(0,4);
						sheetObj.CellValue2(i,"skd_voy_no") = formObj.frm_vvd_number.value.substring(4,8);
						sheetObj.CellValue2(i,"skd_dir_cd") = formObj.frm_vvd_number.value.substring(8);    	
          	 	    } 
          	 	    
          	 	    if(formObj.pol_cd.value != ""){
          	 	    	formObj.port_cd.value = formObj.pol_cd.value;
          	 	    	formObj.io_bnd_cd.value = "O";
          	 	    }else{
          	 	    	formObj.port_cd.value = formObj.pod_cd.value; 	
          	 	    	formObj.io_bnd_cd.value = "I";
          	 	    }
          	 	 
          	 	    sheetObj.DoSearch("ESM_BKG_0493GS.do", FormQueryString(formObj) );
   					 
   					if(sheetObj.RowCount == 1){
   						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");	
   							if(formObj.io_bnd_cd.value == "I"){
   								formObj.frm_depature_port.value = formObj.frm_call_port_cd.value;
   							}
   						 
   						if(formObj.frm_vsl_nm.value.length == 0)
   							formObj.frm_vsl_nm.value = "SM LINE";
   						if(formObj.frm_vsl_nm2.value.length == 0)
   							formObj.frm_vsl_nm2.value = "SM LINE";
   					}  
   					ComEtcDataToForm(formObj, sheetObj);  
   					ComOpenWait(false); 
      			break;          	 	 
      			
          	 	case IBSAVE:
          	 		 
          	 		if(!validateForm(sheetObj,formObj,sAction)) {
          	 	    	return false;
          	 	    }
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); 
					
          	 		formObj.f_cmd.value = MULTI;
          	 		
          	 		var rowCnt = sheetObj.RowCount;
          	 		for(var i=1; i<=rowCnt; i++) {						
   						sheetObj.CellValue2(i,"vsl_cd") = formObj.frm_vvd_number.value.substring(0,4);
   						sheetObj.CellValue2(i,"skd_voy_no") = formObj.frm_vvd_number.value.substring(4,8);
   						sheetObj.CellValue2(i,"skd_dir_cd") = formObj.frm_vvd_number.value.substring(8);    	
   				    } 
          	 		if(formObj.frm_arrival_port.value.length < 5)
          	 			formObj.frm_arrival_port.value = formObj.pod_cd.value;
          	 		IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
          	 	  
          	 		if(formObj.pol_cd.value != ""){
        	 	    	formObj.port_cd.value = formObj.pol_cd.value;
        	 	    	formObj.io_bnd_cd.value = "O";
        	 	    }else{
        	 	    	formObj.port_cd.value = formObj.pod_cd.value; 	
        	 	    	formObj.io_bnd_cd.value = "I";
        	 	    }

	   			    sheetObj.DoSave("ESM_BKG_0493GS.do", FormQueryString(formObj));
	   			    
	   			    formObj.f_cmd.value = SEARCH;       	 	    	
	   			    formObj.vsl_cd.value     = formObj.frm_vvd_number.value.substring(0,4);
	   			    formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
	   			    formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);         
	   			    formObj.call_port.value = formObj.frm_call_port_cd.value;
       	 	    
	   			    for(var i=1; i<=rowCnt; i++) {						
						sheetObj.CellValue2(i,"vsl_cd") = formObj.frm_vvd_number.value.substring(0,4);
						sheetObj.CellValue2(i,"skd_voy_no") = formObj.frm_vvd_number.value.substring(4,8);
						sheetObj.CellValue2(i,"skd_dir_cd") = formObj.frm_vvd_number.value.substring(8);    	
	   			    } 
       	 	 
	   			    sheetObj.DoSearch("ESM_BKG_0493GS.do", FormQueryString(formObj) );
					 
					if(sheetObj.RowCount == 1){
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
						if(formObj.io_bnd_cd.value == "I"){
							formObj.frm_depature_port.value = formObj.frm_call_port_cd.value;
						}
						
						if(formObj.frm_vsl_nm.value.length == 0)
							formObj.frm_vsl_nm.value = "SM LINE";
						if(formObj.frm_vsl_nm2.value.length == 0)
							formObj.frm_vsl_nm2.value = "SM LINE";
					}  
				  
					ComEtcDataToForm(formObj, sheetObj);   		
					ComOpenWait(false); 	   			    
          	 		break;
        
          	 		//EDI 전송	
          	 	case COMMAND01:
          	 		if(!validateForm(sheetObj,formObj,sAction)) {
          	 	    	return false;
          	 	    }  
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); 
          	 		formObj.f_cmd.value = MULTI01;
          	 		var rowCnt = sheetObj.RowCount;
          	 		for(var i=1; i<=rowCnt; i++) {						
   						sheetObj.CellValue2(i,"vsl_cd") = formObj.frm_vvd_number.value.substring(0,4);
   						sheetObj.CellValue2(i,"skd_voy_no") = formObj.frm_vvd_number.value.substring(4,8);
   						sheetObj.CellValue2(i,"skd_dir_cd") = formObj.frm_vvd_number.value.substring(8);    	
   				    } 
          	 		sheetObj.CellValue2(1, "ibflag") = "I";			
          	 		formObj.vsl_cd.value     = formObj.frm_vvd_number.value.substring(0,4);
          	 	    formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
          	 	    formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);   
          	 	    
          	 	    if(formObj.pol_cd.value != ""){
          	 	    	formObj.port_cd.value = formObj.pol_cd.value;
          	 	    	formObj.io_bnd_cd.value = "O";
          	 	    }else{
          	 	    	formObj.port_cd.value = formObj.pod_cd.value; 	
          	 	    	formObj.io_bnd_cd.value = "I";
          	 	    }
          	 	    sheetObj.DoSave("ESM_BKG_0493GS.do", FormQueryString(formObj));
          	 	     ComEtcDataToForm(formObj, sheetObj);
          	 	  ComOpenWait(false); 
          	 	}
     	 }
     	 
     	/**
     	* HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
     	**/
     	function obj_KeyUp() {
     		     
     		    var formObject = document.form;        
     		    var srcName = window.event.srcElement.getAttribute("name");
     		    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     		    var srcValue = window.event.srcElement.getAttribute("value");
     		    if (ComChkLen(srcValue, srcMaxLength) == "2" && srcName != "frm_call_port_cd" && srcName != "pol_cd") {
     		    	ComSetNextFocus();        	    		
     		    }
     	}
     	/**
         * Enter 이벤트
         * @return
         */
        function obj_ComKeyEnter() {
        	
         	var formObject = document.form;
         	var srcName = window.event.srcElement.getAttribute("name");
            
         	if(srcName == "frm_vvd_number"|| srcName == "pol_cd" || srcName == "pod_cd" || srcName == "frm_call_port_cd") {         		 
         		ComKeyEnter();
         	}         	         
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch (sAction) {
      			case IBSEARCH: // 조회
      		     
      			if (formObj.frm_vvd_number.value.length == 0) {
      				ComShowCodeMessage('BKG00203');
      				formObj.frm_vvd_number.focus();
      				return false;
      			}
      			if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
      				ComShowCodeMessage('BKG00203');
      				formObj.frm_vvd_number.focus();
      				return false;
      			}
      			if (formObj.frm_call_port_cd.value.length == 0 && formObj.pod_cd.value.length > 0) {
      				ComShowCodeMessage('BKG00207');
      				formObj.frm_call_port_cd.focus();
      				return false;
      			}    
      			if (formObj.pod_cd.value.length > 0 && formObj.frm_call_port_cd.value.length != 5) {
      				ComShowCodeMessage('BKG00207');
      				formObj.frm_call_port_cd.focus();
      				return false;
      			}   
      			
      			
 			
      			return true;
      			break;
      			
      			case COMMAND01: // 
     		     
      			if (formObj.frm_vvd_number.value.length == 0) {
      				ComShowCodeMessage('BKG00203');
      				formObj.frm_vvd_number.focus();
      				return false;
      			}
      			if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
      				ComShowCodeMessage('BKG00203');
      				formObj.frm_vvd_number.focus();
      				return false;
      			}
      			if (formObj.frm_call_port_cd.value.length == 0 && formObj.pod_cd.value.length > 0) {
      				ComShowCodeMessage('BKG00207');
      				formObj.frm_call_port_cd.focus();
      				return false;
      			}    
      			if (formObj.pod_cd.value.length > 0 && formObj.frm_call_port_cd.value.length != 5) {
      				ComShowCodeMessage('BKG00207');
      				formObj.frm_call_port_cd.focus();
      				return false;
      			}     		     		
      			return true;
      			break;
      			case IBSAVE: // 저장
      			
      			if (formObj.frm_vvd_number.value.length == 0) {
      				ComShowCodeMessage('BKG00203');
      				formObj.frm_vvd_number.focus();
      				return false;
      			}
      			if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
      				ComShowCodeMessage('BKG00203');
      				formObj.frm_vvd_number.focus();
      				return false;
      			}
      			if(formObj.frm_vps_eta_dt.value.length > 0 && !ComIsDate(formObj.frm_vps_eta_dt.value, "ymd"))
      			{
      				ComShowCodeMessage('BKG00377');
      				formObj.frm_vps_eta_dt.focus();
      				return false;
      			}
      			if(formObj.frm_vps_etd_dt.value.length > 0 && !ComIsDate(formObj.frm_vps_etd_dt, "ymd"))
      			{
      				ComShowCodeMessage('BKG00377');
      				formObj.frm_vps_etd_dt.focus();
      				return false;
      			}
      			if(formObj.frm_vps_eta_dt_time.value.length > 0 &&!ComIsTime(formObj.frm_vps_eta_dt_time.value, "hms"))
      			{
      				ComShowMessage("올바른 시간형식이 아닙니다. (HH:MM:SS)");  
      				formObj.frm_vps_eta_dt_time.focus();
      				return false;
      			}
      			if(formObj.frm_vps_etd_dt_time.value.length > 0 &&!ComIsTime(formObj.frm_vps_etd_dt_time.value, "hms"))
      			{
      				ComShowMessage("올바른 시간형식이 아닙니다. (HH:MM:SS)");  
      				formObj.frm_vps_etd_dt_time.focus();
      				return false;
      			}
      			return true;
      			break;
      		 
      		}	
        }
    	/**
         * 조회조건 입력할 때 처리
         */
    	function obj_Clicked() {
        	var formObject = document.form;
        	var srcName = window.event.srcElement.getAttribute("name");
        	var srcValue = window.event.srcElement.getAttribute("value");
        	if(srcName == "port_flg"){
    			if (srcValue == "pol") {
    	
    				document.form.pod_cd.value = "";
    				document.form.frm_call_port_cd.value = "";
    				document.form.pod_cd.disabled = true;
    				document.form.pod_cd.readonly = true;
    				document.form.pol_cd.disabled = false;
    				document.form.pol_cd.readonly = false;
    				
    				document.form.frm_call_port_cd.disabled = true;
    				document.form.frm_call_port_cd.readonly = true;
    				
    				document.form.frm_call_port_cd.className = "input2";
    				document.form.pol_cd.className = "input1";
    				document.form.pod_cd.className = "input2";
    			} else {

    				document.form.pol_cd.disabled = true;
    				document.form.pol_cd.value = "";
    				document.form.pol_cd.readonly = true;
    				document.form.pod_cd.disabled = false;
    				document.form.pod_cd.readonly = false;
    				
    				document.form.frm_call_port_cd.disabled = false;
    				document.form.frm_call_port_cd.readonly = false;
    				
    				document.form.frm_call_port_cd.className = "input1";
    	    		document.form.pol_cd.className = "input2";
    	    		document.form.pod_cd.className = "input1";
    			}

        	}
        }
   
 