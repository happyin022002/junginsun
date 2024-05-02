/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0014.js
*@FileTitle : Leased Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.07 이호선
* 1.0 Creation
* 
* History
* 2010.12.23 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
* 2013.01.29 채창호 [CHM-201322752] ALPS -Master-Master-> Leased Container Creation 로직 변경 건 
*            (LT의 경우, 신조장비를 lease한다는 전제하에  M/Date를 입력하지 않아도 save되도록 조치)
* 2013.06.19 채창호 [CHM-201324954-01] Master에서 SOC creation시 CTM의 OC event date 확인기능 추가           
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
     * @class ees_mst_0014 : ees_mst_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0014() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;    
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet1_OnAfterEdit     = sheet1_OnAfterEdit;
		
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 // Combo Object Array
 var comboObjects = new Array();
 var comboCnt = 0;
 var IBSEARCH01  = 29;
 var IBSEARCH02  = 30;
 var tcnt = 0;
 var rcnt = 0;
 var tabkey = false;
 var tabkey_1 = false;
  var tmp_agmt_seq = "";
 var tmp_sts_evnt_yd_cd = "";

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
					case "btn_master":
						if (sheetObjects[0].rowCount != 0 ) {
							var cntr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no");
							if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"){
								var cntr_no_len =cntr_no.length;
								if ( cntr_no_len > 10 ) {
									cntr_no = cntr_no.substring(0,10);
								} 
								ComOpenPopup("/hanjin/EES_MST_0019.do?popup_mode=Y&cntr_no="+cntr_no,1100, 630, "", "1,0,1,1,1,1,1,1", true);
							}
						}
						break;             
             
					case "btn_new":
						sheetObject1.RemoveAll();
						sheetObjects[1].RemoveAll();
						initCntr();
						formObject.ctype.value = "";
						formObject.hire_date.value = "";
						setnotreadOnly();
						sheetObject1.HeadCheck(0,"del_chk") = false;
						formObject.ctype.focus();
					break;
					
					case "btn_save":
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
					case "btn_loadexcel":
						//lcb2000
						// SH Term 계약은 Approval No. 없기 때문에 Approval No 를 확인하지 않도록 한다.
			            if ( ( formObject.lstm_cd.value == "SH" || formObject.approval_no.text.length > 0 ) && 
			            	formObject.sts_evnt_yd_cd.value.length > 0 &&
			            	formObject.agmt_cty_cd.value.length > 0 &&
			            	formObject.agmt_seq.value.length > 0 &&
			            	formObject.ctype.value.length > 0 &&
			            	formObject.hire_date.value.length > 0){

				        } else {
				        	if (formObject.ctype.value.length == 0)
				        		ComShowCodeMessage("MST00001", "Creation Type")
				        	else if (formObject.hire_date.value.length == 0)
				        		ComShowCodeMessage("MST00001", "On-hire Date")
				            else if (formObject.approval_no.text.length == 0)
			            	    ComShowCodeMessage("MST00001", "Auth No.")
			            	else if (formObject.sts_evnt_yd_cd.value.length == 0)
			            	    ComShowCodeMessage("MST00001", "On Hire Yard")
			            	else if (formObject.agmt_cty_cd.value.length == 0)   
			            		ComShowCodeMessage("MST00001", "AGMT No.")
			            	else if (formObject.agmt_seq.value.length == 0)	
			            		ComShowCodeMessage("MST00001", "AGMT No.");
			            	return;
				        } 

						var ccheck = sheetObject1.LoadExcel(-1,1,"","-1","-1","",false);
						//if (ccheck == true && formObject.lstm_cd.value != "SH"){ //MDS
						if (ccheck == true){
						    for(var i = 1; i <= sheetObject1.RowCount; i++){
						    	setCntInsMode(i);
						    }
						} 
						
					break;
					
					case "btn_add":
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;							

					case "btn_delete":
	   					if(sheetObject1.FindCheckedRow("del_chk")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
	   					}
					break;
					
	                case "ComOpenPopupWithTargetYard":
	                	if (formObject.sts_evnt_yd_cd.readOnly == false){
	         		       ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 500, "3:sts_evnt_yd_cd", "0,0,1,1,1,1,1", true);
	         		       
		                	if (formObject.sts_evnt_yd_cd.value.length > 0 && formObject.sts_evnt_yd_cd.value.length != 7){
		                		ComShowCodeMessage("MST01019", formObject.sts_evnt_yd_cd.value);
		                		formObject.sts_evnt_yd_cd.value = "";
		                		ComSetFocus(formObject.sts_evnt_yd_cd);
		                		return;
		                	} else {
		                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
		                	} 	         		       
	                	}
	         		break;
	         		
	                case "ComOpenPopupWithTargetAgmtNo": //agmt no
	                    if (formObject.agmt_seq.readOnly == false)
	       			       ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '0,0,1', true); 	
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
  	 * Currency Pop-up Return Value 처리 부분<br>
  	 * @param {arry} returnedValues Pop-up 화면의 Return value array
  	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  	 * @param 대상IBSheet의 Sheet Array index
  	 */
 	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
 	    var formObj  = document.form;
 	    var sheetObj = sheetObjects[0];
 	    if ( aryPopupData.length > 0 ) {
 	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][3]);
 	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
 	        ComSetObjValue(formObj.ref_no,   aryPopupData[0][5]);
 	        ComSetObjValue(formObj.lstm_cd,  aryPopupData[0][6]);
 	        ComSetObjValue(formObj.vndr_seq, aryPopupData[0][7]);
 	        ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][8]);

 	        if (formObj.lstm_cd.value != "LT" &&
 	        	formObj.lstm_cd.value != "ST" &&	
 	        	formObj.lstm_cd.value != "OF" &&
 	        	formObj.lstm_cd.value != "SI" &&
 	        	formObj.lstm_cd.value != "MI" &&
 	        	formObj.lstm_cd.value != "SH") {
 	        	ComShowCodeMessage("MST01003");
 	        	formObj.agmt_cty_cd.value = "HHO";
 	        	formObj.agmt_seq.value = "";
 	        	formObj.ref_no.value = "";
 	        	formObj.vndr_seq.value = "";
 	        	formObj.vndr_nm.value = "";
 	        	formObj.lstm_cd.value = "";
 	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
 	        	ComSetFocus(formObj.agmt_seq);
 	        	return;
 	        }
 	        
        	if (formObj.lstm_cd.value.length == 2) {
        		if (formObj.ctype.value == "1"){  //W.O check digit 일때
		  			if (!(formObj.lstm_cd.value == "OF" || 
				  		  formObj.lstm_cd.value == "SH" ||
				  		  formObj.lstm_cd.value == "MI")){
					        ComShowCodeMessage("MST01003");
					        formObj.agmt_seq.value = "";
		                    formObj.ref_no.value = "";
	                    formObj.lstm_cd.value = "";
	            	    formObj.vndr_seq.value = "";
	            	    formObj.vndr_nm.value = "";		
	     	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);		            	    
					    ComSetFocus(formObj.agmt_seq);                                                		  				
			  			return;    		  				
		  			}
        		}
        	} 	        
 	        
        	//lcb2000
 	        if (formObj.lstm_cd.value == "LT" ||
 	        	formObj.lstm_cd.value == "ST" ||
 	        	formObj.lstm_cd.value == "OF" ||
 	        	formObj.lstm_cd.value == "SH" ) {
 	        	ComBtnEnable("btn_loadexcel");
 	        } else {
 	        	ComBtnDisable("btn_loadexcel");
 	        }
 	        
 	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	        
	  		if (formObj.lstm_cd.value.length == 2) {
	  			if (formObj.lstm_cd.value == "LT" || 
	  				formObj.lstm_cd.value == "ST" ||
	  				formObj.lstm_cd.value == "OF" ||
	  				formObj.lstm_cd.value == "SI"){
	  				document.getElementById("approval_no").BackColor = "#CCFFFD";
	  				comboObjects[0].DisabledBackColor = "#CCFFFD"; 
	  			} else {
	  				document.getElementById("approval_no").BackColor = "#FFFFFF";
	  				comboObjects[0].DisabledBackColor = "#FFFFFF";
	  			}
	  		} else {
	  			document.getElementById("approval_no").BackColor = "#FFFFFF";
	  			comboObjects[0].DisabledBackColor = "#FFFFFF";
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
   	 * IBMultiCombo Object를 배열로 등록
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   	 * 배열은 소스 상단에 정의
   	 */
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
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
         document.form.hidden_curdate.value = ComGetNowInfo("ymd"); //document.form.hire_date.value;
         document.form.agmt_cty_cd.value = "HHO";
         document.form.ctype.value = "";
         document.form.ctype.focus();         
  	     for ( k = 0 ; k < comboObjects.length ; k++ ){
  		   initCombo(comboObjects[k], k+1);
  	     }          
  		 initControl();
  		doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
     }
      
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);    	  
//          document.form.ctype.focus();          
      }
      
 	 // Axon 이벤트 처리
 	 // 1. 이벤트catch
	 function initControl() {
		var formObj = document.form;
		
		axon_event.addListenerFormat('blur',    'obj_blur',     form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- 키 눌렸을때
	    axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- 키 눌렸을때
	    axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
	    axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- 키 눌렸을때
		axon_event.addListener("change", "creat_type","ctype");
		
    	formObj.cntr_no0.disabled = true;
    	formObj.cntr_no1.disabled = true;
    	formObj.cntr_no2.disabled = true;		
	}

	function creat_type(){
		var formObj  = document.form;		

	    if (formObj.ctype.value == "0" || formObj.ctype.value == "1"){
	    	formObj.cntr_no0.value = "";
	    	formObj.cntr_no1.value = "";
	    	formObj.cntr_no2.value = "";
	    	formObj.cntr_no3.value = "";
	    	formObj.cntr_no0.disabled = true;
	    	formObj.cntr_no1.disabled = true;
	    	formObj.cntr_no2.disabled = true;
	 		document.getElementById("cntr_no0").className = "input2";
	 		document.getElementById("cntr_no1").className = "input2";
	 		document.getElementById("cntr_no2").className = "input2";
	 		formObj.cntr_no0.readOnly = true;
	 		formObj.cntr_no1.readOnly = true;
	 		formObj.cntr_no2.readOnly = true;	 		
	 		ComBtnEnable("btn_add");
	 		ComBtnEnable("btn_delete");
	 		
	 		//lcb2000
	 		if(formObj.lstm_cd.value == "LT" ||
	 		   formObj.lstm_cd.value == "ST" ||
	 		   formObj.lstm_cd.value == "OF" ||
	 		   formObj.lstm_cd.value == "SH" )
	 		   ComBtnEnable("btn_loadexcel")
	 		else
	 		   ComBtnDisable("btn_loadexcel");
	 		
	    	if (formObj.ctype.value == "1"){
	    		if (!(formObj.lstm_cd.value == "OF" || 
	    			  formObj.lstm_cd.value == "SH" ||
	    			  formObj.lstm_cd.value == "MI")){
	 	        	formObj.agmt_cty_cd.value = "HHO";
	 	        	formObj.agmt_seq.value = "";
	 	        	formObj.ref_no.value = "";
	 	        	formObj.vndr_seq.value = "";
	 	        	formObj.vndr_nm.value = "";
	 	        	formObj.lstm_cd.value = "";
	 	        	ComSetFocus(formObj.agmt_seq);
	 	        	return;
	    		}
	    	}	 		
	    } else {
	    	formObj.cntr_no0.value = "";
	    	formObj.cntr_no1.value = "";
	    	formObj.cntr_no2.value = "";
	    	formObj.cntr_no3.value = "";
	    	formObj.cntr_no0.disabled = false;
	    	formObj.cntr_no1.disabled = false;
	    	formObj.cntr_no2.disabled = false;
	 		document.getElementById("cntr_no0").className = "input1";
	 		document.getElementById("cntr_no1").className = "input1";
	 		document.getElementById("cntr_no2").className = "input1";
	 		formObj.cntr_no0.readOnly = false;
	 		formObj.cntr_no1.readOnly = false;
	 		formObj.cntr_no2.readOnly = false;
	 		ComBtnDisable("btn_add");
	 		ComBtnDisable("btn_loadexcel");
	 		ComBtnDisable("btn_delete");
	    }
	    tabkey = false;
	    
     	if (formObj.agmt_cty_cd.value != "" && formObj.agmt_seq.value != ""){
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);	    
     	}
     	
     	if (formObj.hire_date.value.trim() == ""){
     		formObj.hire_date.focus();
     	}	
     	else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
     		formObj.sts_evnt_yd_cd.focus();
     	}
	} 
	 
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){
	    	ComAddSeparator(formObj.hire_date);
	    	if (ComGetNowInfo("ymd") < formObj.hire_date.value){
	    		formObj.hire_date.value = ComGetNowInfo("ymd");
	    		ComAlertFocus(formObj.hire_date,ComGetMsg("MST01006", "", "", ""));
	    	} else {
	    		if (formObj.hire_date.value.length >= 8 &&
	    			replaceAll(formObj.hire_date.value,"-","") < getRelativeTime(0,0,-90,0).substring(0,8)){
	    			ComShowCodeMessage("MST01030");
	    		}
	    		ComAddSeparator(formObj.hire_date, "ymd");
	    	}
	    }
	    else if(event.srcElement.name == "agmt_cty_cd"){
	    	if (formObj.agmt_cty_cd.value.length == 3 && 
	    	    formObj.agmt_seq.value != "" &&
	    	    formObj.sts_evnt_yd_cd.value != "" &&
	    	    formObj.agmt_cty_cd.readOnly == false){
	    	} 
	    }
	    else if(event.srcElement.name == "agmt_seq"){
	    	if (formObj.agmt_cty_cd.value.length == 3 && 
	    	    formObj.agmt_seq.value != "" &&
	    	    formObj.sts_evnt_yd_cd.value != "" &&
	    	    formObj.agmt_cty_cd.readOnly == false){
 		
    			if (tmp_agmt_seq != formObj.agmt_seq.value){
		    		formObj.lstm_cd.value = "";
		    		formObj.vndr_seq.value = "";
		    		formObj.ref_no.value = "";
		    		formObj.vndr_nm.value = "";
		    		var chkdup = false;
		    		if (tcnt < 0) { tcnt = 0; chkdup = true} 
		    		tcnt = tcnt + 1;
		    		var toggle = tcnt%2;
		    		if (toggle == 1){	
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
    			    }
		    		if (!chkdup){
		    			tcnt = 0;
		    		}
	    		}	
		    } 	    	
	    }
	    else if(event.srcElement.name == "sts_evnt_yd_cd"){
        	if (formObj.sts_evnt_yd_cd.value.length > 0 && formObj.sts_evnt_yd_cd.value.length != 7){
        		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
        		formObj.sts_evnt_yd_cd.value = "";
        		formObj.yd_cd_nm.value = "";
            	comboObjects[0].Index = -1;
            	comboObjects[0].RemoveAll();        		
        		ComSetFocus(formObj.sts_evnt_yd_cd);
        		formObj.sts_evnt_yd_cd.focus();
        	} 		
	    }
	    else {
	    	//Validation 전체 체크(길이,format,최대,최소 등등)
            ComChkObjValid(obj);
	    }
	}
	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_focus(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    } else if (event.srcElement.name == "agmt_seq"){
	    	tmp_agmt_seq = formObj.agmt_seq.value;
	    	tmp_sts_evnt_yd_cd = formObj.sts_evnt_yd_cd.value;
	    } else if (event.srcElement.name == "sts_evnt_yd_cd"){
	    	tmp_agmt_seq = formObj.agmt_seq.value;
	    	tmp_sts_evnt_yd_cd = formObj.sts_evnt_yd_cd.value;
	    }
	}
	
  	function obj_keyup() {
 		
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		switch (obj.name) {
			case "cntr_no0":
				if (formObj.cntr_no0.value.length == 4) {
					ComSetFocus(formObj.cntr_no1);
				}
            break;
            
			case "cntr_no1":
				if (formObj.cntr_no1.value.length == 6) {
					ComSetFocus(formObj.cntr_no2);
				}
            break;
            
			case "cntr_no2":
				if (formObj.cntr_no2.value.length == 6) {
					getRangeCount();
				}
            break;
            
			case "agmt_cty_cd":
				if (formObj.agmt_cty_cd.value.length == 3) {
					ComSetFocus(formObj.agmt_seq);
				}
			break;
			
			case "agmt_seq":
				if (vKeyCode == 13 &&   //엔터 키 입력시 2번 검색하는것 임시로 막음.
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.sts_evnt_yd_cd.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// LSE 쪽에 검색 조건 호출
					tcnt = -1;
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
					ComSetFocus(formObj.approval_no);
				}
			break;
			
			case "sts_evnt_yd_cd":
				if (vKeyCode == 13 && 
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.sts_evnt_yd_cd.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// LSE 쪽에 검색 조건 호출
					ComSetFocus(formObj.agmt_cty_cd);
				} else if (vKeyCode == 13){
					ComSetFocus(formObj.agmt_cty_cd);
				}
				
				if (formObj.sts_evnt_yd_cd.value.length == 7) {
	        		if (tmp_sts_evnt_yd_cd != formObj.sts_evnt_yd_cd.value){
	        			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	    			
	        		}
			    	if (formObj.agmt_cty_cd.value.length == 3 && 
			    	    formObj.agmt_seq.value != "" &&
			    	    formObj.sts_evnt_yd_cd.value != "" &&
			    	    formObj.agmt_cty_cd.readOnly == false){
			    		
			    		if (tmp_sts_evnt_yd_cd != formObj.sts_evnt_yd_cd.value || 
			    			tmp_agmt_seq != formObj.agmt_seq.value){
				    		formObj.lstm_cd.value = "";
				    		formObj.vndr_seq.value = "";
				    		formObj.ref_no.value = "";
				    		formObj.vndr_nm.value = "";
						    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
						    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
						    ComSetFocus(formObj.agmt_cty_cd);
			    		}
				    }
			    	if (formObj.sts_evnt_yd_cd.value == ""){
			    		formObj.yd_cd_nm.value = "";
		            	comboObjects[0].Index = -1;
		            	comboObjects[0].RemoveAll();    	    		
			    	}				
				}
			break;
			
			case "cntr_no2":
				if (vKeyCode == 13){
					getRangeCount();
				}
			break;	
 		}
 	}  	 
  	 
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    var vKeyCode = event.keyCode;

	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="lstm_cd") ComKeyOnlyAlphabet('uppernum');
	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
	            if(obj.name=="vndr_seq") ComKeyOnlyNumber('int');
	            if(obj.name=="approval_no") ComKeyOnlyAlphabet('uppernum');
	            if(obj.name=="ref_no") ComKeyOnlyAlphabet('uppernum',"45"); //"-" 허용
	            if(obj.name=="cntr_no0") ComKeyOnlyAlphabet('upper');
	            if(obj.name=="cntr_no1") ComKeyOnlyNumber('int');
	            if(obj.name=="cntr_no2") ComKeyOnlyNumber('int');
	            break;
	        case "ymd":
	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
	        	break;
	    }
	}

    function approval_no_OnKeyDown(comboObj, KeyCode, Shift) {
    	var formObj = document.form;
		if ((KeyCode >= 48 && KeyCode <= 57) || 
			(KeyCode >= 96 && KeyCode <= 105) || 
			(KeyCode >= 65 && KeyCode <= 90) ||
			(KeyCode >= 37 && KeyCode <= 40) ||
			KeyCode == 189 || KeyCode == 8 ||
			KeyCode == 46) {
			comboObj.SetText(0, 0, comboObj.Text.toUpperCase());
		} else { 
			comboObj.Text = ""; 
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
             case 1:      // sheet1 init
                 with (sheetObj) {
            	      // 높이 설정
                     style.height = 320;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle1 = "||CNTR No.|TP/SZ|Material|Unit Type|PU-charge|PU-credit|Min O/H Days|Free Days|Old /New|M/Date|Manufacturer|Lift On Charge|Error Message|Spec No.";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     //InitColumnInfo(ComCountHeadTitle(HeadTitle1)+1, 0, 0, true);
                     InitColumnInfo(23, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck, 	 30,   daCenter, true,  "del_chk");
                     InitDataProperty(0, cnt++, dtData,          90,   daLeft,   false, "cntr_no",     		    true,  "",      dfNone, 			0, true,  true,	11);
                     InitDataProperty(0, cnt++, dtCombo,         90,   daCenter, false, "eq_tpsz_cd",     		true,  "",      dfNone);
                     InitDataProperty(0, cnt++, dtCombo,         120,  daCenter, false, "cntr_mtrl_cd",     	false, "",      dfNone);
                     InitDataProperty(0, cnt++, dtCombo,         60,   daLeft, 		false, "rf_tp_cd",     		false,  "",      dfNone);                     
                     InitDataProperty(0, cnt++, dtData,          65,   daRight,   false,"pkup_chg_amt",     	false, "",   	dfNullFloat,      2, true, true);
                     InitDataProperty(0, cnt++, dtData,          65,   daRight,   false,"pkup_chg_cr_amt",   	false, "",      dfNullFloat,      2, true, true);
                     InitDataProperty(0, cnt++, dtData,          85,   daRight,   false,"min_onh_dys", 			false, "",      dfNullInteger);
                     InitDataProperty(0, cnt++, dtData,          65,   daRight,   false,"free_dys",  			false, "",      dfNullInteger);
                     InitDataProperty(0, cnt++, dtCombo,         60,   daCenter, false, "cntr_old_van_flg",   	false, "",      dfNone);
                     InitDataProperty(0, cnt++, dtPopupEditFormat,105, daCenter, false, "mft_dt",    			false, "",      dfDateYmd);
                     InitDataProperty(0, cnt++, dtCombo,         90,   daLeft,   true,  "vndr_abbr_nm",         false, "",      dfNone, 	0,     false,       true);
                     InitDataProperty(0, cnt++, dtData,          100,  daRight,  false, "lift_on_chrg",         false, "",      dfNullFloat,2);
                     InitDataProperty(0, cnt++, dtData,          150,  daLeft,   false, "err_msg",     		    false,  "",      dfNone ,   0,     false,       false);
                     InitDataProperty(0, cnt++, dtHidden,        80,   daCenter, false, "cntr_spec_no",     	false, "",      dfNone);                     
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ieflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eeflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ceflg",       false,     "",      dfNone,        0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ueflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "heflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "teflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "cntrUpdflg",       false,     "",      dfNone,        0,     true,       true);
                     
                     InitDataCombo(0, "cntr_mtrl_cd", "Stainless Steel|Steel (Unspecified)|Aluminum", "SS|SU|AU");
//                     InitDataCombo(0, "rf_tp_cd", " |CA|HU|MG", " |C|H|M");
                     InitDataCombo(0, "cntr_old_van_flg", "Old|New", "O|N");
                     
                     InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); //대문자만          
                     
                     PopupImage  =  "img/btns_calendar.gif";
                     ShowButtonImage = 2;
                     SelectFontBold = true;
                     SelectHighLight = false;
                     EditEnterBehavior = "tab";
                 }
                 break;
                 
             case 2:      // sheet1 init
             with (sheetObj) {
            	 // 높이 설정
                 style.height = 160;
                 
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 10, 100);

                 var HeadTitle1 = "|Sel|CNTR No.|TP/SZ|Material|Unit Type|PU-Charge|PU-Credit|Min O/H Days|Free Days|Old /New|M/Date|Manufacturer|Lift On Charge|Error Message|Spec No.";

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 //InitColumnInfo(ComCountHeadTitle(HeadTitle1)+1, 0, 0, true);
                 InitColumnInfo(23, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter, false, "ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck, 	 40,   daCenter, true,  "del_chk");
                 InitDataProperty(0, cnt++, dtData,          90,   daLeft,   false, "cntr_no",     		    true,  "",      dfNone, 			0, true,  true,	11);
                 InitDataProperty(0, cnt++, dtCombo,         60,   daCenter, false, "eq_tpsz_cd",     		true, "",       dfNone);
                 InitDataProperty(0, cnt++, dtCombo,         130,  daCenter, false, "cntr_mtrl_cd",     	false, "",      dfNone);
                 InitDataProperty(0, cnt++, dtCombo,         40,   daCenter, false, "rf_tp_cd",     		false,  "",      dfNone);                 
                 InitDataProperty(0, cnt++, dtData,          70,   daLeft,   false, "pkup_chg_amt",     	false, "",   	dfNullFloat,      2, true, true);
                 InitDataProperty(0, cnt++, dtData,          70,   daLeft,   false, "pkup_chg_cr_amt",   	false, "",      dfNullFloat,      2, true, true);
                 InitDataProperty(0, cnt++, dtData,          90,   daLeft,   false, "min_onh_dys", 			false, "",      dfNullInteger);
                 InitDataProperty(0, cnt++, dtData,          70,   daLeft,   false, "free_dys",  			false, "",      dfNullInteger);
                 InitDataProperty(0, cnt++, dtCombo,         60,   daCenter, false, "cntr_old_van_flg",   	false, "",      dfNone);
                 InitDataProperty(0, cnt++, dtPopupEditFormat,         90,   daCenter, false, "mft_dt",     			false, "",      dfDateYmd);
                 InitDataProperty(0, cnt++, dtComboEdit,     100,  daLeft,   false, "vndr_abbr_nm",         false, "",      dfNone);
                 InitDataProperty(0, cnt++, dtData,          100,   daCenter, false, "lift_on_chrg",         false, "",      dfNullFloat, 2);
                 InitDataProperty(0, cnt++, dtData,          150,  daLeft,   false, "err_msg",     		    false,  "",      dfNone,    0,     false,       false);
                 InitDataProperty(0, cnt++, dtHidden,          80,   daCenter, false, "cntr_spec_no",     	false, "",      dfNone);                 
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ieflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eeflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ceflg",       false,     "",      dfNone,        0,     true,       true);                     
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ueflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "heflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "teflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "cntrUpdflg",       false,     "",      dfNone,        0,     true,       true); 
                 
                 InitDataCombo(0, "cntr_mtrl_cd", "Stainless Steel|Steel (Unspecified)|Aluminium", "SS|SU|AL");
//                 InitDataCombo(0, "rf_tp_cd", " |CA|HU|MG", " |C|H|M");
                 InitDataCombo(0, "cntr_old_van_flg", "Old|New", "O|N");
                 
                 InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); //대문자만          
                 
                 PopupImage  =  "img/btns_calendar.gif";
                 ShowButtonImage = 2;
             }
             break;                 
         }
     }

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
   	function initCombo(comboObj, comboNo) {
   		var formObj = document.form;
   	    switch(comboObj.id) {
   	        case "approval_no":
   	        	with(comboObj) {
 			   	    SetTitle("Auth No.|Old/New|TP/SZ|Auth Vol.|Pick-up Vol.|Balance|P/Up LOC|Off-Hire LOC|Pick-up Due Date|tpsz|pca|pcca|mod|locg|fdys|lonchg|spno|ppp|qqq");  
			        SetColAlign("left|center|center|right|right|right|center|center|center|center|center|center|center|center|center|center|center|center|center");        
			        SetColWidth("130|65|50|80|90|70|80|90|140|-1|-1|-1|-1|-1|-1|-1|-1|-1|-1"); 	        
				    DropHeight = 160;     	        		
   	        		
   	            	MultiSelect = false;
   	            	MaxSelect = 1;
	   	 	  		if (formObj.lstm_cd.value.length == 2) {
	   		  			if (formObj.lstm_cd.value == "LT" || 
	   		  				formObj.lstm_cd.value == "ST" ||
	   		  				formObj.lstm_cd.value == "OF" ||
	   		  				formObj.lstm_cd.value == "SI"){
	   		  				BackColor = "#CCFFFD";
	   		  			    DisabledBackColor = "#CCFFFD";
	   		  			} else {
	   		  				BackColor = "#FFFFFF";
	   		  			    DisabledBackColor = "#FFFFFF";
	   		  			}
	   		  		} else {
	   		  			BackColor = "#FFFFFF";
	   		  		    DisabledBackColor = "#FFFFFF";
	   		  		}    	            	
   	            }
   	        	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
   	        	break;
   	    }
   	}      
	 
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBCREATE:
            	comboObjects[0].Index = -1;
            	comboObjects[0].RemoveAll();
            	clearAGMTdata();
            break;	
  	
			case IBSEARCH:      //조회
				comboObjects[0].Index = -1;
				comboObjects[0].RemoveAll();
			    clearAGMTdata();
			    sheetObj.WaitImageVisible=false;
			    ComOpenWait(true);			    
				formObj.f_cmd.value = SEARCH;
				var xml = "";
				if (formObj.ctype.value == '2')
	    	  	   xml = sheetObj.GetSearchXml ("EES_MST_0014GS.do", FormQueryString(formObj)+"&gubun=1")
				else
				   xml = sheetObj.GetSearchXml ("EES_MST_0014GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var chk = xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") == -1 && xml.indexOf("Error") == -1){
					ComXml2ComboItem(xml, formObj.approval_no, "cntr_onh_auth_no", "cntr_onh_auth_no|new_van_tp_cd|cntr_tpsz_cd|onh_qty|pick_qty|balance|dol|ecc|pkup_due_dt|cntr_tpsz_cd|pkup_chg_amt|pkup_chg_cr_amt|min_onh_dys|lift_on_chg|free_dys|lon_chg|cntr_spec_no");
				} else {
					sheetObj.LoadSearchXml(xml);
				}
			break;

			case IBSEARCH01:
				formObj.f_cmd.value = SEARCH05;
            	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
				 var chk = sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchXml(sXml);
					 return;
				 }            	
            	formObj.ref_no.value = ComXmlString(sXml, "ref_no");
            	formObj.lstm_cd.value = ComXmlString(sXml, "lstm_cd");
            	formObj.vndr_seq.value = ComXmlString(sXml, "vndr_seq");
            	formObj.vndr_nm.value = ComXmlString(sXml, "vndr_lgl_eng_nm");
            	
            	if (formObj.lstm_cd.value.length == 2) {
            		if (formObj.ctype.value == "1"){  //W.O check digit 일때
    		  			if (!(formObj.lstm_cd.value == "OF" || 
    				  		  formObj.lstm_cd.value == "SH" ||
    				  		  formObj.lstm_cd.value == "MI")){
   					        ComShowCodeMessage("MST01003");
   					        formObj.agmt_seq.value = "";
  		                    formObj.ref_no.value = "";
		                    formObj.lstm_cd.value = "";
		            	    formObj.vndr_seq.value = "";
		            	    formObj.vndr_nm.value = "";		
		     	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);		            	    
   					        ComSetFocus(formObj.agmt_seq);                                                		  				
   			  			    return;    		  				
    		  			}
            		}
            	}
            	
            	if (formObj.lstm_cd.value.length == 2) {
		  			if (!(formObj.lstm_cd.value == "LT" || 
			  			formObj.lstm_cd.value == "ST" ||
			  			formObj.lstm_cd.value == "OF" ||
			  			formObj.lstm_cd.value == "SI" ||
			  			formObj.lstm_cd.value == "MI" ||
			  			formObj.lstm_cd.value == "SH")){  
				        ComShowCodeMessage("MST01003");
				        formObj.agmt_seq.value = "";
		                formObj.ref_no.value = "";
		                formObj.lstm_cd.value = "";
		            	formObj.vndr_seq.value = "";
		            	formObj.vndr_nm.value = "";		
		 	        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);		            	
				        ComSetFocus(formObj.agmt_seq);                                                		  				
		  			    return;	
		  			}
            	}
            	
		  		if (formObj.lstm_cd.value.length == 2) {
		  			if (formObj.lstm_cd.value == "LT" || 
		  				formObj.lstm_cd.value == "ST" ||
		  				formObj.lstm_cd.value == "OF" ||
		  				formObj.lstm_cd.value == "SI"){
		  				document.getElementById("approval_no").BackColor = "#CCFFFD";
		  				comboObjects[0].DisabledBackColor = "#CCFFFD";
		  			} else {
		  				document.getElementById("approval_no").BackColor = "#FFFFFF";
		  				comboObjects[0].DisabledBackColor = "#FFFFFF";
		  			}
		  		} else {
		  			document.getElementById("approval_no").BackColor = "#FFFFFF";
		  			comboObjects[0].DisabledBackColor = "#FFFFFF";
		  		}
		  		
		  		if (formObj.ref_no.value == ""){
		  			formObj.agmt_cty_cd.value = "HHO";
		  			formObj.agmt_seq.value = "";
		  			ComSetFocus(formObj.agmt_seq);
		  		}
		  		
		  		if (formObj.ctype.value == "0" || formObj.ctype.value == "1"){
		  			// lcb2000
		 	        if (formObj.lstm_cd.value == "LT" ||
		 	 	        formObj.lstm_cd.value == "ST" ||
		 	 	        formObj.lstm_cd.value == "OF" ||
		 	 	        formObj.lstm_cd.value == "SH") {
		 	 	        ComBtnEnable("btn_loadexcel");
		 	 	    } else {
		 	 	        ComBtnDisable("btn_loadexcel");
		 	 	    }
		  		}else {
		  			ComBtnDisable("btn_loadexcel");
		  		}
            break;
            
			case IBSEARCH02 :
				if (formObj.sts_evnt_yd_cd.value != ""){
					formObj.f_cmd.value = SEARCH06;
	            	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.sts_evnt_yd_cd.value+"&yd_chk_flg=N");
					var chk = sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchXml(sXml);
					   return;
					}
	            	var codestr = ComXmlString(sXml, "code_nm");
	            	if (codestr == ""){
	            		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
	            		formObj.sts_evnt_yd_cd.value = "";
	            		formObj.yd_cd_nm.value = "";
	                	comboObjects[0].Index = -1;
	                	comboObjects[0].RemoveAll();	            		
	            		ComSetFocus(formObj.sts_evnt_yd_cd);
	            	} else {
	            		formObj.yd_cd_nm.value = codestr;
	            		ComSetFocus(formObj.agmt_cty_cd);	            		
	            	}
				}
            break;
            
			case IBSAVE:        //저장
			    if (sheetObj.RowCount == 0){
			       ComShowCodeMessage("MST00001", "New Row");
			       return;
			    }   
			    for (var i = 1; i <= sheetObj.RowCount; i++){
			    	var lcntrno = sheetObj.CellValue(i, "cntr_no");
			    	if (formObj.ctype.value == "0" && lcntrno.trim().length != 11){
			    		sheetObj.SelectCell(i, "cntr_no");
			    		ComShowCodeMessage("MST02010");
			    		return;
			    	}
			    }
			    
		    	if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
				    if (Number(formObj.cntr_no3.value) > Number(formObj.approval_vol.value.replace(",","")) - Number(formObj.pick_up_vol.value.replace(",",""))){
					    ComShowCodeMessage("MST01012");
					    return;			    	
				    }
		    	}
			
			    sheetObjects[1].RemoveAll();
			    if ((formObj.lstm_cd.value.length == 2 && 
			    	   (formObj.lstm_cd.value == "LT" || 
		  				formObj.lstm_cd.value == "ST" ||
		  				formObj.lstm_cd.value == "OF" ||
		  				formObj.lstm_cd.value == "SI")) ||	
			    	    document.getElementById("approval_no").BackColor == "#CCFFFD"){
			    	if (formObj.approval_no.Text.trim().length == 0){
			    	   ComShowCodeMessage("MST00001", "Approval No");
			    	   ComSetFocus(formObj.approval_no);
			      	   return;
			    	}
			    }
			    

			    for(var i = 0; i <= sheetObj.RowCount; i++){
				    if (formObj.lstm_cd.value == "LT"){
//				    	if (sheetObj.CellValue(i, "mft_dt") == ""){
//					    	ComShowCodeMessage("MST01011");
//					    	sheetObj.SelectCell(i, "mft_dt");
//				    		return;
//				    	}
			        }
			    }
			    
			    if (formObj.ctype.value == 2){ //serial range
			    	if (formObj.cntr_no0.value == "" || 
			    		formObj.cntr_no1.value == "" || 
			    		formObj.cntr_no2.value == ""){
			    		ComShowCodeMessage("MST01009");
			    		if (formObj.cntr_no0.value == "")
			    			ComSetFocus(formObj.cntr_no0);
			    		else if (formObj.cntr_no1.value == "")
			    			ComSetFocus(formObj.cntr_no1);
			    		else if	(formObj.cntr_no2.value == "")
			    			ComSetFocus(formObj.cntr_no2);
			    		return;
			    	}
			    }

			    if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
				    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObj.RowCount ) {
				       ComShowCodeMessage("MST01012");
				       return;
				    }
			    }    
			    
			    // 동일한  cntr_no 있으면  첫번째 중복행에 대해서  메세지 출력
        		var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		var arrRow = dupRows.split(",");
		        if (dupRows != ""){
		        	 //오류메시지 : 데이터가 중복됩니다.
	       			 ComShowCodeMessage("MST00002", sheetObj.CellValue(arrRow[0],3)+","+sheetObj.CellValue(arrRow[0],4)+","+sheetObj.CellValue(arrRow[0],5));
		             for (var i = 1; i <= sheetObj.RowCount+1; i++){
		            	 if (sheetObj.CellValue(i,"cntr_no")   == sheetObj.CellValue(arrRow[0],"cntr_no")){
		       			     sheetObj.SelectCell(i, "cntr_no", true);
		       			     break;
		            	 }
		             }
	       			 return;				        	
		        }
		        sheetObj.WaitImageVisible=false;
		    	formObj.f_cmd.value = MULTI;
     	        var sParam = ComGetSaveString(sheetObjects[0]);
     	        if (sheetObj.IsDataModified){     	        
     	           sParam += "&" + FormQueryString(formObj);
     	           ComOpenWait(true);
     	        }
				var sXml = sheetObj.GetSaveXml("EES_MST_0014GS.do", sParam);
				ComOpenWait(false);
				var chk = sXml.indexOf("(null)");
				if (chk != -1) return;
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					sheetObj.LoadSearchXml(sXml);
					return;
				} 				
				
				//등록성공
				var iesuc = 0;
				//등록실패
				var iefal = 0;
				//수정성공
				var uesuc = 0;
				//수정실패
				var uefal = 0;
				//failcnt
				var failcnt = 0;
				var failflg = false;
				
				var cerr = 0;
				var cerr1 = 0;
				var derr = 0;
				var eerr = 0;
				var herr = 0;
				var edierr = 0;
				var upderr = 0;
				
				var msg = ComXmlStringOfItmCnt(sXml, "cntr_no", 0);
				if (msg == "") return;
				
				sheetObjects[1].LoadSaveXml(sXml);
				var sheetcnt = 1;
				
				//color 원복
				for (var i = 1; i <= sheetObj.RowCount+1; i++){
					setsheetRowColorBlack(i);				
				}				
				
				for (var i = 1; i <= sheetObj.RowCount; i++){
					sheetObj.CellValue(i,"err_msg") ="";
				    if (sheetObjects[1].CellValue(sheetcnt, "ceflg") == "E"){
						sheetObj.CellValue(i,"ceflg") = "";
						sheetObj.CellFontColor(i,"cntr_no") = sheetObj.RgbColor(255, 0, 0);
						sheetObj.RowStatus(i) = "I";
						cerr = cerr + 1;
						failflg = true;
				    }
				    if (sheetObjects[1].CellValue(sheetcnt, "ceflg") == "B"){
						sheetObj.CellValue(i,"ceflg") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "I";
						cerr1 = cerr1 + 1;
						failflg = true;
				    }					    
				    if (sheetObjects[1].CellValue(sheetcnt, "eeflg") == "E"){
						sheetObj.CellValue(i,"eeflg") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "I";
						eerr = eerr + 1;
						failflg = true;
				    }
				    if (sheetObjects[1].CellValue(sheetcnt, "cntrUpdflg") == "E"){
						sheetObj.CellValue(i,"cntrUpdflg") = "";
						sheetObj.CellFontColor(i,"cntr_no") = sheetObj.RgbColor(255, 0, 0);
						sheetObj.RowStatus(i) = "I";
						upderr = upderr + 1;
						failflg = true;
				    }
				    if (sheetObjects[1].CellValue(sheetcnt, "heflg") == "E"){
						sheetObj.CellValue(i,"heflg") = "";
						sheetObj.CellValue2(i,"err_msg") = sheetObjects[1].CellValue(sheetcnt, "err_msg");
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "I";
						herr = herr + 1;
						failflg = true;
				    }
				    
				    if (failflg == true) failcnt = failcnt + 1;
				    failflg = false;
				    
				    if ( 
				    	sheetObjects[1].CellValue(sheetcnt, "ieflg") == "E" ||
				    	sheetObjects[1].CellValue(sheetcnt, "ueflg") == "E" ){
						sheetObj.CellValue(i,"ceflg") = "";
						sheetObj.CellValue(i,"eeflg") = "";
						sheetObj.CellValue(i,"heflg") = "";
						sheetObj.CellValue(i,"ieflg") = "";
						sheetObj.CellValue(i,"ueflg") = "";
						sheetObj.CellValue(i,"cntrUpdflg") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "I";
						if (sheetObjects[1].CellValue(sheetcnt, "ieflg") == "E"){
						   iefal = iefal + 1;
						} else {
						   uefal = uefal + 1;
						}	
				    } else if ( 
				    		   sheetObjects[1].CellValue(sheetcnt, "ceflg") != "E" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "eeflg") != "E" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "heflg") != "E" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "ieflg") != "E" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "ueflg") != "E" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "cntrUpdflg") != "E" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "ceflg") != "B"){
						sheetObj.RowStatus(i) = "R";
						iesuc = iesuc + 1;
				    }
				    sheetcnt = sheetcnt + 1; 
				}
				
				var sMsg = "";
				if (iesuc > 0){
					sMsg = ComGetMsg("MST01025", "", "", "");
				}				
				if (iefal > 0 || uefal > 0){
					sMsg = sMsg + ComGetMsg("MST02008", "", "", "");
				}
				if (cerr > 0){
					sMsg = sMsg + ComGetMsg("MST02003", "", "", "");
				}
				if (cerr1 > 0){
					sMsg = sMsg + ComGetMsg("MST02009", "", "", "");
				}
				if (eerr > 0){
					sMsg = sMsg + ComGetMsg("MST02004", "", "", "");
				}
				if (herr > 0){
					sMsg = sMsg + ComGetMsg("MST02005", "", "", "");
				}				
				if (derr > 0){
					sMsg = sMsg + ComGetMsg("MST02006", "", "", "");
				}
				if (upderr > 0){
					sMsg = sMsg + ComGetMsg("MST02031", "", "", "");
				}
				
				var lcheckerr = 0;
				for (var i = 1; i <= sheetObj.RowCount; i++){
				   if (sheetObj.RowStatus(i) == "R"){
					   sheetObj.CellEditable(i,"cntr_no") = false;
			           sheetObj.CellEditable(i,"eq_tpsz_cd") = false;
			           sheetObj.CellEditable(i,"cntr_mtrl_cd") = false;
			           sheetObj.CellEditable(i,"pkup_chg_amt") = false;
			           sheetObj.CellEditable(i,"pkup_chg_cr_amt") = false;
			           sheetObj.CellEditable(i,"min_onh_dys") = false;
			           sheetObj.CellEditable(i,"free_dys") = false;
			           sheetObj.CellEditable(i,"cntr_old_van_flg") = false;
			           sheetObj.CellEditable(i,"mft_dt") = false;
			           sheetObj.CellEditable(i,"vndr_abbr_nm") = false;
			           sheetObj.CellEditable(i,"lift_on_chrg") = false;
			           sheetObj.CellEditable(i,"err_msg") = false;
				   } else {
					   lcheckerr = lcheckerr + 1;
				   }
				}
				sheetObj.ColumnSort("ibflag|cntr_no");
				
				if (lcheckerr != 0){
	 	        	ComBtnEnable("btn_save");
	 	        } else {
	 	        	ComBtnDisable("btn_save");
	 	        	
	 	        	//저장 완료시 ADD 버튼과 DELETE 버튼 비활성화
	 	        	ComBtnDisable("btn_add");    
	 	        	ComBtnDisable("btn_delete");
				}
				ComShowMessage (sMsg);
				
				//Serial Range에서 에러가 발생 안하였을때만 조건상태를 disable한다.
				if (formObj.ctype.value == "2" && (iefal > 0 || failcnt > 0 || cerr > 0 || eerr > 0 || herr > 0 || derr > 0 || cerr1 > 0)){
					formObj.cntr_no0.value = "";
					formObj.cntr_no1.value = "";
					formObj.cntr_no2.value = "";
					formObj.cntr_no3.value = "";
					
					formObj.cntr_no0.readOnly = false;
					formObj.cntr_no1.readOnly = false;
					formObj.cntr_no2.readOnly = false;
					
					ComSetFocus(formObj.cntr_no0);
					ComBtnEnable("btn_save");
				}				
			break;
			
			case IBINSERT:      // 입력
			    if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
				    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObj.RowCount ) {
				       ComShowCodeMessage("MST02002");
				       return;
				    }
			    } 
			
			    if ((formObj.lstm_cd.value == "LT" || formObj.lstm_cd.value == "ST" ||
					formObj.lstm_cd.value == "OF" || formObj.lstm_cd.value == "SI") && 
					formObj.approval_no.value == "") {
         		    ComShowCodeMessage("MST01007");
         		    ComSetFocus(formObj.approval_no);
					return;
				}
	            if ((document.getElementById("approval_no").BackColor == "#FFFFFF" ||
	            	(document.getElementById("approval_no").BackColor == "#CCFFFD" && formObj.approval_no.text.length > 0)) && 
	            	formObj.sts_evnt_yd_cd.value.length > 0 &&
	            	formObj.agmt_cty_cd.value.length > 0 &&
	            	formObj.agmt_seq.value.length > 0 &&
	            	formObj.ctype.value.length > 0 &&
	            	formObj.hire_date.value.length > 0){
					    if (formObj.ctype.value == "2"){
					    	if (formObj.cntr_no0.value.length == 4 && 
					    		formObj.cntr_no1.value.length == 6 &&
					    		formObj.cntr_no2.value.length == 6){
					    		
					    		//row add 하고 버튼 disable 한다.
							    sheetObj.DataInsert();
							    setInsMode();
							    ComBtnDisable("btn_add");
							    ComBtnDisable("btn_loadexcel");
							    ComBtnDisable("btn_delete");
							    rcnt = rcnt + 1;
					    	} else {
					    		ComShowCodeMessage("MST00001", "CNTR Serial Range");
					    		if (formObj.cntr_no0.value.length != 4)
							    	ComSetFocus(formObj.cntr_no0);
					    		else if (formObj.cntr_no1.value.length != 6)
					    			ComSetFocus(formObj.cntr_no1);
					    		else if (formObj.cntr_no2.value.length != 6)
					    			ComSetFocus(formObj.cntr_no2);
					    	} 
					    } else {
						   sheetObj.DataInsert();
						   setInsMode();
						   rcnt = rcnt + 1;
					    }	 								   
	            } else {
		        	if (formObj.ctype.value.length == 0)
		        		ComShowCodeMessage("MST00001", "Creation Type")
		        	else if (formObj.hire_date.value.length == 0)
		        		ComShowCodeMessage("MST00001", "On-hire Date")	            	
		        	else if (formObj.approval_no.text.length == 0)
		            	ComShowCodeMessage("MST00001", "Auth No.")
		            else if (formObj.sts_evnt_yd_cd.value.length == 0)
		            	ComShowCodeMessage("MST00001", "On Hire Yard")
		            else if (formObj.agmt_cty_cd.value.length == 0)   
		            	ComShowCodeMessage("MST00001", "AGMT No.")
		            else if (formObj.agmt_seq.value.length == 0)	
		            	ComShowCodeMessage("MST00001", "AGMT No.");
		            return;
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
    	  	   var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd=U");
			   var chk = xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(xml);
				   return;
			   }    	  	   
    	  	   var cols = ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
    	  	   sheetObj.InitDataCombo(0, "eq_tpsz_cd", cols[0], cols[0]);   // IBSheet내 Combo 초기화
            break;
            
			case IBDELETE:      // 삭제
   	   		if (sheetObj.id == 'sheet1') {  
   	   		    sheetObj.SelectFontBold = false;
	   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj,"del_chk"); 
					sheetObj.SelectFontBold = true;
					rcnt = sheetObj.RowCount;
				} else {     
				}
			}    			
		    break;
		    
			case SEARCH08:      //Unit Type 콤보 조회
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH08;
				var xml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
				var comboItems = ComGetEtcData(xml, "unit_type").split("|");//배열
				var name = " ";
				var code = " ";
				for ( var i = 0; i < comboItems.length; i++) {
			 		var comboItem = comboItems[i].split(",");
					name = name + "|" + comboItem[1];
					code = code + "|" + comboItem[0];
			 	}
				sheetObj.InitDataCombo(0,"rf_tp_cd", name, code);
			ComOpenWait(false);
		break;
         }
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
      
     function setsheetRowColorBlack(cnt){
    	 var formObj = document.form;    	 
     	 sheetObjects[0].CellFontColor(cnt,1)  = sheetObjects[0].RgbColor(0, 0, 0);
         if (formObj.ctype.value != "2"){     	 
     	    sheetObjects[0].CellFontColor(cnt,2)  = sheetObjects[0].RgbColor(0, 0, 0);
         }
     	 sheetObjects[0].CellFontColor(cnt,3)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,4)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,5)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,6)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,7)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,8)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,9)  = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,10) = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,11) = sheetObjects[0].RgbColor(0, 0, 0);
     	 sheetObjects[0].CellFontColor(cnt,12) = sheetObjects[0].RgbColor(0, 0, 0);
     }
     
     function setsheetRowColorRed(cnt){
    	 var formObj = document.form; 
    	 sheetObjects[0].CellFontColor(cnt,1) = sheetObjects[0].RgbColor(255, 0, 0);
    	 if (formObj.ctype.value != "2"){  
    	    sheetObjects[0].CellFontColor(cnt,2) = sheetObjects[0].RgbColor(255, 0, 0);
    	 }
    	 sheetObjects[0].CellFontColor(cnt,3) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,4) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,5) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,6) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,7) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,8) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,9) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,10) = sheetObjects[0].RgbColor(255, 0, 0);    	 
    	 sheetObjects[0].CellFontColor(cnt,11) = sheetObjects[0].RgbColor(255, 0, 0);
    	 sheetObjects[0].CellFontColor(cnt,12) = sheetObjects[0].RgbColor(255, 0, 0);
     }     
      
     /**
     * 아이비시트 팝업 클릭시 이벤트
     */
     function sheet1_OnPopupClick(sheetObj, Row,Col,Value)
     {
          if (sheetObj.ColSaveName(Col) != "mft_dt") return;
          var cal = new ComCalendarGrid("myCal");
          cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
     }
      
     function sheet1_OnChange(sheetObj, Row,Col, Value)
     {
    	 var savename = sheetObj.ColSaveName(Col);
    	 
    	 if(savename == "cntr_old_van_flg"){
    		 if (sheetObj.CellValue(Row,"cntr_old_van_flg") == "N"){
    			 sheetObj.CellEditable(Row,"lift_on_chrg") = false;
    			 sheetObj.CellValue(Row, "lift_on_chrg") = "";
    		 } else {
    			 sheetObj.CellEditable(Row,"lift_on_chrg") = true;
    		 }
    	 }
         else if (savename == "vndr_abbr_nm"){
             var sText = sheetObj.GetComboInfo(Row, Col, "Text");
             //각각 배열로 구성한다.
           	 var arrText = sText.split("|");
             var idx   = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
             if(idx != -1){
            	 var tmparrtxt = arrText[idx].substring(0, 6);
                 sheetObj.CellValue(Row, "vndr_abbr_nm") = tmparrtxt;	 
             }
         }    	 
     }     
     
     function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	 var savename = SheetObj.ColSaveName(Col);
         if (savename == "pkup_chg_amt"){
        	 if(SheetObj.CellEditable(Row,"pkup_chg_cr_amt") == true ||
        		SheetObj.CellEditable(Row,"pkup_chg_amt") == true){
         	    if (KeyCode != 9)
          	       SheetObj.CellValue(Row,"pkup_chg_cr_amt") = 0;
        	 }
         }
         else if (savename == "pkup_chg_cr_amt"){
        	 if(SheetObj.CellEditable(Row,"pkup_chg_cr_amt") == true ||
             	SheetObj.CellEditable(Row,"pkup_chg_amt") == true){
        		 
        		 if (KeyCode != 9)
        	    SheetObj.CellValue(Row,"pkup_chg_amt") = 0;
        	 }
         }
     }
     
     /**
     *  저장시 validation check
     */
     function sheet1_OnValidation(Row,Col,Value){
     }
      
     function func_calendar(){
        var formObj = document.form; 
        if (formObj.hire_date.readOnly == false){    	 
	       var cal = new ComCalendar();
	       cal.select(document.form.hire_date, "yyyy-MM-dd");
        } 
     }
     
     /**
 	 * Form Element Clear 처리부분.<br>
 	 * @param fieldName
 	 */
 	 function clearForm(fieldName){
 		 var formObj = document.form;
 		 switch(fieldName) {
 			case "vndr_seq":
 				ComSetObjValue(formObj.vndr_seq, "");
 				ComSetObjValue(formObj.vndr_nm,  "");
 				break;
 		 }
 	 }
 	 
  	 /**
	 * 필수항목 체크
	 */
	 function checkSerItem(formObj){
		if (formObj.ctype.value == "2"){
			if (formObj.cntr_no0.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no0);
				formObj.cntr_no3.value="";
				return false;
			}
			
			if (formObj.cntr_no1.value.trim().length == 0 ) {
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no1);
				formObj.cntr_no3.value="";				
				return false;
			} 
	
			if (formObj.cntr_no2.value.trim().length == 0 ) {
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no2);
				formObj.cntr_no3.value="";				
				return false;
			}
			
			if (formObj.cntr_no1.value.trim() > formObj.cntr_no2.value.trim()){
				ComShowCodeMessage("MST00001", "S/N Range");
				ComSetFocus(formObj.cntr_no1);				
				formObj.cntr_no3.value="";
				return false;
			}
			
			if(eval(formObj.cntr_no3.value) < 1){
				ComShowCodeMessage("MST01022");
				formObj.cntr_no3.value="";
				return false;
			}
		}
		return true;
	 }
	
    /**
    * range_change
    */  
	function range_change1(){
		var formObj = document.form;
		var fm_ser_no = formObj.cntr_no1.value.trim();

		formObj.cntr_no3.value = '';

		if(formObj.cntr_no1.value.trim().length > 0){
			if(formObj.cntr_no1.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.cntr_no1.value.trim());
				ComSetFocus(formObj.cntr_no1);
				return;
			}

			if(!ComIsNumber(formObj.cntr_no1)){
				ComShowCodeMessage("MST01019", formObj.cntr_no1.value.trim());
				ComSetFocus(formObj.cntr_no1);
				return;
			}
		}
		getRangeCount();
	}

	function range_change2(){
		var formObj = document.form;

		formObj.cntr_no3.value = '';

		if(formObj.cntr_no2.value.trim().length > 0){
			if(formObj.cntr_no2.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.cntr_no2.value.trim());
				ComSetFocus(formObj.cntr_no2);
				return;
			}
		}

		if(formObj.cntr_no2.value.trim().length > 0){
			if(!ComIsNumber(formObj.cntr_no2)){
				ComShowCodeMessage("MST01019", formObj.cntr_no2.value.trim());
				ComSetFocus(formObj.cntr_no2);
				return;
			}
		}
		getRangeCount();
	}	
	
	function getRangeCount(){

		var formObj = document.form;
		var fm_no = formObj.cntr_no1.value.trim();
		var to_no = formObj.cntr_no2.value.trim();

		if(formObj.cntr_no1.value.trim().length != 6) return;
		if(formObj.cntr_no2.value.trim().length != 6) return;

		var change_count = String(to_no - fm_no + 1);
		if(eval(change_count) < 1){		
			formObj.cntr_no3.value = "";
		} else {
			formObj.cntr_no3.value = change_count;
			var sheetObject1 = sheetObjects[0];
			if (sheetObject1.RowCount == 0)
			   doActionIBSheet(sheetObject1, formObj, IBINSERT);
			
		    if (formObj.approval_vol.value != "" && formObj.pick_up_vol.value != ""){
			    if (Number(formObj.approval_vol.value.replace(",","")) < Number(formObj.pick_up_vol.value.replace(",","")) + sheetObject1.RowCount ) {
			    } else {
			    	//Serial Range 일때는 New
					sheetObject1.CellValue2(sheetObject1.SelectRow,"cntr_old_van_flg") = "N";
					sheetObject1.CellValue2(sheetObject1.SelectRow,"cntr_no") = "0";
					sheetObject1.CellFontColor(sheetObject1.SelectRow,"cntr_no") = sheetObject1.RgbColor(255, 255, 255);
			    }
		    } else {
		    	//Serial Range 일때는 New
		    	if (sheetObject1.RowCount > 0){
					sheetObject1.CellValue2(sheetObject1.SelectRow,"cntr_old_van_flg") = "N";
					sheetObject1.CellValue2(sheetObject1.SelectRow,"cntr_no") = "0";
					sheetObject1.CellFontColor(sheetObject1.SelectRow,"cntr_no") = sheetObject1.RgbColor(255, 255, 255);
		    	}
		    }			
		}

		if(eval(change_count) < 1){
			ComShowCodeMessage("MST01022");
			ComSetFocus(formObj.cntr_no1);
			return;
		}
	}
	
	/*
	* approval_no OnChange 이벤트 처리 
	*/
	function approval_no_OnChange(comboObj,Index_Code, Text){
		var formObj = document.form;
		var arrXml = Text.split("|");
		
		formObj.approval_vol.value = arrXml[3];
		formObj.pick_up_vol.value = arrXml[4];
		formObj.pick_up_due_date.value = arrXml[8]; //6
		formObj.hid_min_onh_dys.value = arrXml[12];
		formObj.hid_pkup_chg_cr_amt.value = arrXml[11];
		formObj.hid_pkup_chg_amt.value = arrXml[10];
		formObj.hid_tp_sz.value = arrXml[9];
		formObj.hid_old_new.value = arrXml[1];
		
		//Short Term, OLD 일경우에 한하여 데이타를 보여 주고 아닌경우 "0" 설정
		if ((formObj.lstm_cd.value == "ST" ||
			 formObj.lstm_cd.value == "LT" ||
			 formObj.lstm_cd.value == "OF" ||
			 formObj.lstm_cd.value == "SI" )	&&
			 formObj.hid_old_new.value.substring(0,1) == "O"){
		   formObj.hid_lift_on_chrg.value = arrXml[13];
		}
		formObj.hid_free_dys.value = arrXml[14];
		if (arrXml[15] != ""){
			formObj.hid_lift_on_chrg.value = arrXml[15]; 
		}
		
		formObj.hid_cntr_spec_no.value = arrXml[16];
		formObj.cntr_no0.value = "";
		formObj.cntr_no1.value = "";
		formObj.cntr_no2.value = "";
		formObj.cntr_no3.value = "";
	}	
	 
	function clearAGMTdata(){
		var formObj = document.form;
		formObj.approval_vol.value = "";
		formObj.pick_up_vol.value = "";
		formObj.pick_up_due_date.value = "";
		formObj.hid_min_onh_dys.value = "";
		formObj.hid_pkup_chg_cr_amt.value = "";
		formObj.hid_pkup_chg_amt.value = "";
		formObj.hid_tp_sz.value = "";
		formObj.hid_lift_on_chrg.value = "";
		formObj.hid_cntr_spec_no.value = "";
		formObj.hid_free_dys.value = "";
	} 
	
	function toDateString() { //formatTime(date)
		var now = new Date();
	    var year  = now.getFullYear();
	    var month = now.getMonth() + 1; // 1월=0,12월=11이므로 1 더함
	    var day   = now.getDate();

	    if (("" + month).length == 1) { month = "0" + month; }
	    if (("" + day).length   == 1) { day   = "0" + day;   }
	    return ("" + year+ "-" + month + "-" + day);
	}
	
	function initCntr(){
		var formObj = document.form;
		formObj.ctype.value = "0";
		formObj.hire_date.value = ComGetNowInfo("ymd");
		formObj.sts_evnt_yd_cd.value = "";
		formObj.agmt_cty_cd.value = "HHO";
		formObj.agmt_seq.value = "";
		formObj.lstm_cd.value = "";
		formObj.vndr_seq.value = "";
		formObj.vndr_nm.value = "";
		formObj.ref_no.value = "";
		comboObjects[0].Index = -1;
		comboObjects[0].RemoveAll();
		formObj.approval_vol.value = "";
		formObj.pick_up_vol.value = "";
		formObj.pick_up_due_date.value = "";
		formObj.cntr_no0.value = "";
		formObj.cntr_no1.value = "";
		formObj.cntr_no2.value = "";
		formObj.cntr_no3.value = "";
		formObj.hid_old_new.value = "";
		formObj.hid_tp_sz.value = "";
		formObj.hid_app_vol.value = "";
		formObj.hid_pick_vol.value = "";
		formObj.hid_pick_date.value = "";
		formObj.hid_min_onh_dys.value = "";
		formObj.hid_pkup_chg_cr_amt.value = "";
		formObj.hid_pkup_chg_amt.value = "";
		formObj.hid_lift_on_chrg.value = "";
		formObj.hid_lift_on_chrg.value = "";
		formObj.hid_cntr_spec_no.value = "";
		formObj.hid_free_dys.value = "";
		formObj.yd_cd_nm.value = "";
		document.getElementById("approval_no").BackColor = "#FFFFFF";	
		ComBtnEnable("btn_add");
		ComBtnEnable("btn_loadexcel");
		ComBtnEnable("btn_delete");
		ComBtnEnable("btn_save");
		
		document.getElementById("cntr_no0").className = "input2";
		document.getElementById("cntr_no1").className = "input2";
		document.getElementById("cntr_no2").className = "input2";
		formObj.cntr_no0.readOnly = true;
		formObj.cntr_no1.readOnly = true;
		formObj.cntr_no2.readOnly = true;
		rcnt = 0;
	}
	
	function setreadOnly(){
		var formObj = document.form;		
        formObj.ctype.disabled = true;
        formObj.hire_date.readOnly = true;
        formObj.sts_evnt_yd_cd.readOnly = true;
        formObj.agmt_cty_cd.readOnly = true;
        formObj.agmt_seq.readOnly = true;
        comboObjects[0].Enable = false;
	}
	
	function setnotreadOnly(){
		var formObj = document.form;		
        formObj.ctype.disabled = false;
        formObj.hire_date.readOnly = false;
        formObj.sts_evnt_yd_cd.readOnly = false;
        formObj.agmt_cty_cd.readOnly = false;
        formObj.agmt_seq.readOnly = false;
        comboObjects[0].Enable  = true;
	}
	
	function setInsMode(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
    	sheetObj.CellValue2(sheetObj.SelectRow,"vndr_abbr_nm") = "";
	    if (formObj.approval_no.Text.length > 0){
        	 sheetObj.CellEditable(sheetObj.SelectRow,"pkup_chg_cr_amt") = false;
        	 sheetObj.CellEditable(sheetObj.SelectRow,"pkup_chg_amt") = false;
        	// Approval_no에 값이 있을때는 Approval_no 값을 가져와야 함.
	    }	
	
    	sheetObj.CellValue2(sheetObj.SelectRow,"eq_tpsz_cd") = "";
    	sheetObj.CellValue2(sheetObj.SelectRow,"cntr_mtrl_cd") = "";
    	sheetObj.CellValue2(sheetObj.SelectRow,"cntr_old_van_flg") = "";
        sheetObj.MinimumValue(sheetObj.SelectRow, "pkup_chg_cr_amt") = 0;
        sheetObj.MinimumValue(sheetObj.SelectRow, "pkup_chg_amt") = 0;
        
        sheetObj.MinimumValue(sheetObj.SelectRow, "min_onh_dys") = 0;
        sheetObj.MinimumValue(sheetObj.SelectRow, "free_dys") = 0;
        sheetObj.MinimumValue(sheetObj.SelectRow, "lift_on_chrg") = 0;
        
        sheetObj.MaximumValue(sheetObj.SelectRow, "pkup_chg_cr_amt") = 99999.99;
        sheetObj.MaximumValue(sheetObj.SelectRow, "pkup_chg_amt") = 99999.99;
        sheetObj.MaximumValue(sheetObj.SelectRow, "min_onh_dys") = 99999;
        sheetObj.MaximumValue(sheetObj.SelectRow, "free_dys") = 99999;
        sheetObj.MaximumValue(sheetObj.SelectRow, "lift_on_chrg") = 999999;
        
        // 기본 값 설정
        if (formObj.approval_no.text.length > 0){
           sheetObj.CellValue2(sheetObj.SelectRow,"eq_tpsz_cd") = formObj.hid_tp_sz.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"eq_tpsz_cd") = false;
           
           sheetObj.CellValue2(sheetObj.SelectRow,"pkup_chg_amt") =  formObj.hid_pkup_chg_amt.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"pkup_chg_amt") = false;
           
           sheetObj.CellValue2(sheetObj.SelectRow,"pkup_chg_cr_amt") =  formObj.hid_pkup_chg_cr_amt.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"pkup_chg_cr_amt") = false;
           
           sheetObj.CellValue2(sheetObj.SelectRow,"min_onh_dys") = formObj.hid_min_onh_dys.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"min_onh_dys") = false;
           
           sheetObj.CellValue2(sheetObj.SelectRow,"free_dys") = formObj.hid_free_dys.value; 
           sheetObj.CellEditable(sheetObj.SelectRow,"free_dys") = false;
           
           sheetObj.CellValue2(sheetObj.SelectRow,"cntr_old_van_flg") = formObj.hid_old_new.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"cntr_old_van_flg") = false;
           
           sheetObj.CellValue2(sheetObj.SelectRow,"lift_on_chrg") = formObj.hid_lift_on_chrg.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"lift_on_chrg") = false;
           
           if(formObj.ctype.value == "0" && formObj.hid_old_new.value.substring(0,1) == "O"){
        	   sheetObj.CellEditable(sheetObj.SelectRow,"lift_on_chrg") = true;
           }
           
           sheetObj.CellValue2(sheetObj.SelectRow,"cntr_spec_no") = formObj.hid_cntr_spec_no.value;
           sheetObj.CellEditable(sheetObj.SelectRow,"cntr_spec_no") = false;
           
        } else {
           sheetObj.CellEditable(sheetObj.SelectRow,"eq_tpsz_cd") = true;	
           sheetObj.CellEditable(sheetObj.SelectRow,"pkup_chg_amt") = true;
           sheetObj.CellEditable(sheetObj.SelectRow,"pkup_chg_cr_amt") = true;
           sheetObj.CellEditable(sheetObj.SelectRow,"min_onh_dys") = true;
           sheetObj.CellEditable(sheetObj.SelectRow,"free_dys") = true;
           sheetObj.CellEditable(sheetObj.SelectRow,"cntr_old_van_flg") = true;
           sheetObj.CellEditable(sheetObj.SelectRow,"lift_on_chrg") = false;
           sheetObj.CellValue2(sheetObj.SelectRow,"cntr_old_van_flg") = "N";
           sheetObj.CellEditable(sheetObj.SelectRow,"cntr_spec_no") = false;
        }
        sheetObj.CellEditable(sheetObj.SelectRow,"rf_tp_cd") = false;
        
        if (formObj.hid_tp_sz.value.substring(0, 1) == "R"){
        	sheetObj.CellValue2(sheetObj.SelectRow,"cntr_mtrl_cd") = "SS";
        	
        	if(formObj.lstm_cd.value == "LT") {
        		sheetObj.CellEditable(sheetObj.SelectRow,"rf_tp_cd") = true;
        	} else {
        		sheetObj.CellEditable(sheetObj.SelectRow,"rf_tp_cd") = false;
        	}
        } else {
        	sheetObj.CellValue2(sheetObj.SelectRow,"cntr_mtrl_cd") = "SU";
        }
        setreadOnly();
        if (formObj.ctype.value != "2"){ 
        	sheetObj.SelectCell(sheetObj.SelectRow, "cntr_no", true);
        }
	}
	
	function setCntInsMode(cnt){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
    	
	    if (formObj.approval_no.Text.length > 0){
        	 sheetObj.CellEditable(cnt,"pkup_chg_cr_amt") = false;
        	 sheetObj.CellEditable(cnt,"pkup_chg_amt") = false;
        	 // Approval_no에 값이 있을때는 Approval_no 값을 가져와야 함.
	    }	
		if(formObj.lstm_cd.value != "SH"){ //MDS
			sheetObj.CellValue2(cnt,"vndr_abbr_nm") = "";
    		sheetObj.CellValue2(cnt,"eq_tpsz_cd") = "";
    	}
    	sheetObj.CellValue2(cnt,"cntr_mtrl_cd") = "";
    	sheetObj.CellValue2(cnt,"cntr_old_van_flg") = "";
        sheetObj.MinimumValue(cnt, "pkup_chg_cr_amt") = 0;
        sheetObj.MinimumValue(cnt, "pkup_chg_amt") = 0;
        
        sheetObj.MinimumValue(cnt, "min_onh_dys") = 0;
        sheetObj.MinimumValue(cnt, "free_dys") = 0;
        sheetObj.MinimumValue(cnt, "lift_on_chrg") = 0;
        
        sheetObj.MaximumValue(cnt, "pkup_chg_cr_amt") = 99999.99;
        sheetObj.MaximumValue(cnt, "pkup_chg_amt") = 99999.99;
        sheetObj.MaximumValue(cnt, "min_onh_dys") = 99999;
        sheetObj.MaximumValue(cnt, "free_dys") = 99999;
        sheetObj.MaximumValue(cnt, "lift_on_chrg") = 999999;
        
        // 기본 값 설정
        if (formObj.approval_no.text.length > 0){
           sheetObj.CellValue2(cnt,"eq_tpsz_cd") = formObj.hid_tp_sz.value;
           sheetObj.CellEditable(cnt,"eq_tpsz_cd") = false;
           
           sheetObj.CellValue2(cnt,"pkup_chg_amt") =  formObj.hid_pkup_chg_amt.value;
           sheetObj.CellEditable(cnt,"pkup_chg_amt") = false;
           
           sheetObj.CellValue2(cnt,"pkup_chg_cr_amt") =  formObj.hid_pkup_chg_cr_amt.value;
           sheetObj.CellEditable(cnt,"pkup_chg_cr_amt") = false;
           
           sheetObj.CellValue2(cnt,"min_onh_dys") = formObj.hid_min_onh_dys.value;
           sheetObj.CellEditable(cnt,"min_onh_dys") = false;
           
           sheetObj.CellValue2(cnt,"free_dys") = formObj.hid_free_dys.value; 
           sheetObj.CellEditable(cnt,"free_dys") = false;
           
           sheetObj.CellValue2(cnt,"cntr_old_van_flg") = formObj.hid_old_new.value;
           sheetObj.CellEditable(cnt,"cntr_old_van_flg") = false;
           
           sheetObj.CellValue2(cnt,"lift_on_chrg") = formObj.hid_lift_on_chrg.value;
           sheetObj.CellEditable(cnt,"lift_on_chrg") = false;
           
           sheetObj.CellValue2(cnt,"cntr_spec_no") = formObj.hid_cntr_spec_no.value;
           sheetObj.CellEditable(cnt,"cntr_spec_no") = false;           
           
        } else {
           sheetObj.CellEditable(cnt,"eq_tpsz_cd") = true;	
           sheetObj.CellEditable(cnt,"pkup_chg_amt") = true;
           sheetObj.CellEditable(cnt,"pkup_chg_cr_amt") = true;
           sheetObj.CellEditable(cnt,"min_onh_dys") = true;
           sheetObj.CellEditable(cnt,"free_dys") = true;
           sheetObj.CellEditable(cnt,"cntr_old_van_flg") = true;
           sheetObj.CellEditable(cnt,"lift_on_chrg") = false;
           if(formObj.lstm_cd.value != "SH"){
	           sheetObj.CellValue2(cnt,"cntr_old_van_flg") = "N";
	       }    
	       else{ //MDS
	       	   sheetObj.CellValue2(cnt,"cntr_old_van_flg") = "O";
	       }
           sheetObj.CellEditable(cnt,"cntr_spec_no") = false;
        }
        sheetObj.CellEditable(cnt,"rf_tp_cd") = false;
        
        if (formObj.hid_tp_sz.value.substring(0, 1) == "R"){
        	sheetObj.CellValue2(cnt,"cntr_mtrl_cd") = "SS";
        	
        	if(formObj.lstm_cd.value == "LT") {
        		sheetObj.CellEditable(cnt,"rf_tp_cd") = true;
        	} else {
        		sheetObj.CellEditable(cnt,"rf_tp_cd") = false;
        	}
        } else {
        	sheetObj.CellValue2(cnt,"cntr_mtrl_cd") = "SU";
        }
        
        setreadOnly();
	}	
	
	/*
	 *  gubun1 = 구분자 
	 *  gubun2 = 바뀔문자 
	 */
	function replaceAll(Str ,gubun1 ,gubun2){
		var Strname  = Str.split(gubun1);
		var returnStr ="";
		
		for(i=0 ; i < Strname.length ; i++) {
			if ( i == Strname.length-1 ){
				returnStr = returnStr + Strname[i];  
			} else {
				returnStr = returnStr + Strname[i]+gubun2;
			}
		}
		return returnStr;
	}	
	
	/* 개발자 작업  끝 */