/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0021.js
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_CIM_0021 : EES_CIM_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CIM_0021() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.openPopup				= openPopup;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
 
    var comboObjects = new Array();
    var comboCnt = 0 ;


 	var IBSEARCH01  = 29;
 	var IBSEARCH02  = 30;
 	var IBSEARCH03  = 31;
 	var IBSEARCH04  = 32;
 
 	var tot_cntr_tpsz_cd ="";
    var tot_cnmv_sts_cd ="";
    var tot_lstm_cd ="";
    var totHeadCount = 0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
        var sheetObject1 = sheetObjects[shtCnt++];
        var sheetObject2 = sheetObjects[shtCnt++];
        var sheetObject3 = sheetObjects[shtCnt++];

        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
        	var row;
        	var titleFlag = '';
        	var rsheetObjects;
        	if ( beforetab == 0 ) {	  //1번째 탭에서 조회
        		row = sheetObjects[0].RowCount;
        		rsheetObjects = sheetObjects[0];
        	} else if ( beforetab == 1 ) {	  //2번째 탭에서 조회
        		row = sheetObjects[1].RowCount;
        		rsheetObjects = sheetObjects[1];
        	} else if ( beforetab == 2 ) {	  //3번째 탭에서 조회
        		row = sheetObjects[2].RowCount;
        		rsheetObjects = sheetObjects[2];
        	}

			switch(srcName) {

				case "btn_Retrieve":
					if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
					} else if ( beforetab == 2 ) {	//두번째 탭에서 조회.
						doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
					}
					
					break;

				case "btn_new":
		        	formObject.reset();
					comboObjects[0].Code = '';
					comboObjects[1].Code = '';
					comboObjects[2].Code = '';
					loc_type_code_onchange();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					
					break;
					
				case "btns_search1":
					openPopup("1");
					break;	

				case "btn_downexcel":
					doActionIBSheet(rsheetObjects,formObject,IBDOWNEXCEL);
					break;
				case "btn_loc_cd":	//Location 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_type_code.value;
		            loc_cd = formObject.loc_cd.value;
		            if ( formObject.loc_type_code.value != '' ) {	
						if ( formObject.loc_type_code.value == '6' ) {	//yard
							var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopup("/hanjin/COM_ENS_061.do",1000, 477, "popupFinish", "1,0,1,1,1,1,1,1", true);
		           		} else {
		        			var loc_code = "";
		                    
		        			if ( form.loc_type_code.value == "1" ) {
		        				loc_code = "rcc_cd";
		        			} else if ( form.loc_type_code.value == "2" ) {
		        				loc_code = "lcc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code = "lcc_cd";
		        			} else if ( form.loc_type_code.value == "4" ) {
		        				loc_code = "ecc_cd";
		        			} else if ( form.loc_type_code.value == "5" ) {
		        				loc_code = "scc_cd";
		        			}
							var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		           		}
		            }
					break; 					
                case "btn_t1detail1":
                	titleFlag = 'Summary';	//detail 구분자:Symmary
					break; 					
                case "btn_t1detail3":
                	titleFlag = 'By Movement';	//detail 구분자:Movement
					break; 					
				case "btn_t1detail2":
                	if(row > 0){
	                	var loc_type_code = formObject.param_loc_type_code.value;
	                	if ( loc_type_code == '2' || loc_type_code == '3' ) {
	                		loc_type_code = '1'
	                	} else if ( loc_type_code == '4' ) {
	                		loc_type_code = '2'
	                	} else if ( loc_type_code == '5' ) {
	                		loc_type_code = '3'
	                	} else {
	                		loc_type_code = ''
	                	}
                		var loc_cd = formObject.param_loc_cd.value;
                		var over_stay_days = formObject.param_over_stay_days.value;
                		var cntr_tpsz_cd = formObject.param_cntr_tpsz_cd.value;
                		var cnmv_sts_cd = formObject.param_cnmv_sts_cd.value;
                		var full_flg = formObject.param_full_flg.value;
                		var lstmCd = formObject.param_lstm_cd.value;
                		var ofc_cd = formObject.ofc_cd.value;
                		var over_stay_days = formObject.over_stay_days.value;
						var param = "";
                		if ( loc_type_code == '' ) {
							param = "?popup_mode=Y";
                		} else {
							param = "?loc_type_code="+loc_type_code+"&loc_cd="+loc_cd+"&over_stay_days="+over_stay_days+"&cntr_tpsz_cd="+cntr_tpsz_cd+"&cnmv_sts_cd="+cnmv_sts_cd+"&full_flg="+full_flg+"&ofc_cd="+ofc_cd+"&over_stay_days="+over_stay_days+"&lstm_cd="+lstmCd+  "&popup_mode=Y";
                		}
						ComOpenPopup("/hanjin/EES_CIM_0022.do"+param,1150, 690, "", "1,0,1,1,1,1,1,1", true);
                	}
                    break;
                case "btn_t3ByMVMTStatus":
                	if(row > 0){
                    	var formObject = document.form;
                    	var sub_cntr_tpsz_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"cntr_tpsz_cd");
                    	var sub_loc_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"loc_cd");
                    	var sub_cnmv_sts_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"cnmv_sts_cd");

                    	if ( sub_loc_cd=='Total' ) {	// 전체 Detail 팝업은 성능 저하
                    		return;
                    	}
                    	
                    	if ( sub_loc_cd=='Total' ) {
                    		sub_loc_cd ='';
                    	}
                    	if ( sub_cntr_tpsz_cd=='Total' ) {
                    		sub_cntr_tpsz_cd = "";
                    	}
                    	if ( typeof(sub_cnmv_sts_cd)=='undefined' ) {
                    		sub_cnmv_sts_cd = formObject.param_cnmv_sts_cd.value
                    	}
                    	param = "?loc_type_code="+formObject.param_loc_type_code.value
                    		   +"&loc_cd="+formObject.param_loc_cd.value
                    		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
                    		   +"&dmg_flg="+formObject.param_dmg_flg.value
                    		   +"&cntr_use_co_cd="+formObject.param_cntr_use_co_cd.value
                    		   +"&over_stay_days="+formObject.param_over_stay_days.value
                    		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
                    		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
                    		   +"&full_flg="+formObject.param_full_flg.value
                    		   +"&lstm_cd="+formObject.param_lstm_cd.value
                    		   +"&soc_cd="+formObject.param_soc_cd.value
                    		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
                    		   +"&sub_loc_cd="+sub_loc_cd
                    		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd;
                		ComOpenPopup("/hanjin/EES_CIM_0041.do"+param,900, 445, "", "1,0,1,1,1,1,1,1", true);
                	}
                    break;   	                    
				case "btn_t3detail":
	               	if(row > 0){
                    	var formObject = document.form;
                    	var sub_cntr_tpsz_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"cntr_tpsz_cd");
                    	var sub_loc_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"loc_cd");
                    	var sub_cnmv_sts_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"cnmv_sts_cd");

                    	if ( sub_loc_cd=='Total' ) {	// 전체 Detail 팝업은 성능 저하
                    		return;
                    	}

                    	if ( sub_loc_cd=='Total' ) {
                    		sub_loc_cd ='';
                    	}
                    	if ( sub_cntr_tpsz_cd=='Total' ) {
                    		sub_cntr_tpsz_cd = "";
                    	}
                    	if ( typeof(sub_cnmv_sts_cd)=='undefined' ) {
                    		sub_cnmv_sts_cd = formObject.param_cnmv_sts_cd.value
                    	}
                    	param = "?loc_type_code="+formObject.param_loc_type_code.value
                    		   +"&loc_cd="+formObject.param_loc_cd.value
                    		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
                    		   +"&dmg_flg="+formObject.param_dmg_flg.value
                    		   +"&cntr_use_co_cd="+formObject.param_cntr_use_co_cd.value
                    		   +"&over_stay_days="+formObject.param_over_stay_days.value
                    		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
                    		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
                    		   +"&full_flg="+formObject.param_full_flg.value
                    		   +"&lstm_cd="+formObject.param_lstm_cd.value
                    		   +"&soc_cd="+formObject.param_soc_cd.value
                    		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
                    		   +"&sub_loc_cd="+sub_loc_cd
                    		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd;
                		ComOpenPopup("/hanjin/EES_CIM_0042.do"+param,900, 455, "", "1,0,1,1,1,1,1,1", true);
                	}
	               	break; 
			} // end switch
			
			if ( titleFlag == 'Summary' || titleFlag == 'By Movement' ) {	//Symmary,Movement detail 타이틀 구분
				var sub_over_qty = rsheetObjects.CellValue(rsheetObjects.SelectRow,"over_qty");
				if (sub_over_qty > 35000) {	// 데이터 건수가 3만5천 건 이상인 경우 Detail 버튼 선택시에 Warning Message 발생
					ComShowCodeMessage("CIM30024");
					return;
				}
				
				if(row > 0) {
	            	var formObject = document.form;
	            	var srcValue = window.event.srcElement.getAttribute("value");
	            	var sub_cntr_tpsz_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"cntr_tpsz_cd");
	            	var sub_loc_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"loc_cd");
	            	var sub_cnmv_sts_cd = rsheetObjects.CellValue(rsheetObjects.SelectRow,"cnmv_sts_cd");
	            	var ofc_cd = formObject.ofc_cd.value;
	
	            	if ( sub_loc_cd=='Total' ) {	// 전체 Detail 팝업은 성능 저하
	            		return;
	            	}
	
	            	if ( sub_loc_cd=='Total' ) {
	            		sub_loc_cd ='';
	            	}
	            	if ( sub_cntr_tpsz_cd=='Total' ) {
	            		sub_cntr_tpsz_cd = formObject.param_cntr_tpsz_cd.value
	            	}
	            	if ( typeof(sub_cnmv_sts_cd)=='undefined' ) {
	            		sub_cnmv_sts_cd = formObject.param_cnmv_sts_cd.value
	            	}
	            	if(formObject.ofc_cd.value !='' && formObject.loc_cd.value ==''){
		            	param = "?loc_type_code=1"
	            		   +"&loc_cd="+rsheetObjects.CellValue(rsheetObjects.SelectRow,"rcc_cd")
	            		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
	            		   +"&dmg_flg="+formObject.param_dmg_flg.value
	            		   +"&cntr_use_co_cd="+formObject.param_cntr_use_co_cd.value
	            		   +"&over_stay_days="+formObject.param_over_stay_days.value
	            		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
	            		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
	            		   +"&full_flg="+formObject.param_full_flg.value
	            		   +"&lstm_cd="+formObject.param_lstm_cd.value
	            		   +"&soc_cd="+formObject.param_soc_cd.value
	            		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
	            		   +"&sub_loc_cd="+sub_loc_cd
	            		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd
	            		   +"&ofc_cd="+ofc_cd
	            		   +"&titleFlag="+titleFlag
	            		   ;
	            	}else{
		            	param = "?loc_type_code="+formObject.param_loc_type_code.value
	            		   +"&loc_cd="+formObject.param_loc_cd.value
	            		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
	            		   +"&dmg_flg="+formObject.param_dmg_flg.value
	            		   +"&cntr_use_co_cd="+formObject.param_cntr_use_co_cd.value
	            		   +"&over_stay_days="+formObject.param_over_stay_days.value
	            		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
	            		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
	            		   +"&full_flg="+formObject.param_full_flg.value
	            		   +"&lstm_cd="+formObject.param_lstm_cd.value
	            		   +"&soc_cd="+formObject.param_soc_cd.value
	            		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
	            		   +"&sub_loc_cd="+sub_loc_cd
	            		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd
	            		   +"&ofc_cd="+ofc_cd
	            		   +"&titleFlag="+titleFlag
	            		   ;
	            	}

	        		ComOpenPopup("/hanjin/EES_CIM_0044.do"+param,900, 455, "", "1,0,1,1,1,1,1,1", true);
	        	}
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
     * 상세팝업  조회시 원조건 세팅
     */    
    function setParamValue() {
    	var formObject = document.form;
    	formObject.param_loc_type_code.value = formObject.loc_type_code.value; 
    	formObject.param_loc_cd.value = formObject.loc_cd.value; 
    	formObject.param_cntr_tpsz_cd.value = comboObjects[0].Code; 
    	formObject.param_dmg_flg.value = formObject.dmg_flg.value; 
    	formObject.param_cntr_use_co_cd.value = formObject.cntr_use_co_cd.value; 
    	formObject.param_over_stay_days.value = formObject.over_stay_days.value; 
    	formObject.param_cnmv_sts_cd.value = comboObjects[1].Code; 
    	formObject.param_uclm_ls_div_cd.value = formObject.uclm_ls_div_cd.value; 
    	formObject.param_full_flg.value = formObject.full_flg.value; 
    	formObject.param_lstm_cd.value = comboObjects[2].Code; 
    	formObject.param_soc_cd.value = formObject.soc_cd.value; 
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
    function loadPage( cnmv_sts_cd, cnmv_sts_nm ) {

    	for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
	    for(p=0;p< comboObjects.length;p++){
		       initCombo (comboObjects[p],p+1);
		}        

        initControl();
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
    }
    
    /**
     * Pop-up Open 부분<br>
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	 if ( type == "1" ) {
     		var formObj = document.form;
    		var sUrl    = '/hanjin/COM_ENS_071.do';
			var iWidth  = 855;
			var iHeight = 435;
			var sTargetObjList = "ofc_cd:ofc_cd";
			var sDisplay = "1,0,1,1,1,1,1,1";

			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
    	}
    }

    /**
     * MVMT Status 생성
     */
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        var arr_cnmv_sts_cd = cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm = cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd = arr_cnmv_sts_cd;
        with (form.cnmv_sts_cd) {
        	MultiSelect = true;
            MultiSeparator = ",";
        	DropHeight = 320;
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }    
    
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    	
    	viewUsData( true ) ;	 //Location by US이면 'CM','CP','CI','CO','CD','CT' 데이타 보이고 안보이기
    }        
    
    /**
     * Location by US이면 'CM','CP','CI','CO','CD','CT' 데이타 보이고 안보이기
     */
    function viewUsData( usFlag) {
    	for ( var i=9; i<=15; i++ ) {
    		sheetObjects[2].ColHidden("qty"+i) = usFlag;
    		sheetObjects[2].ColHidden("avg"+i) = usFlag;
    		sheetObjects[2].ColHidden("rate"+i) = usFlag;
    	}
    }
    
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
    }
      
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initCombo (comboObj, comboNo) {
     	
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
    * 초기 이벤트 등록 
    */
    function initControl() {
        axon_event.addListener('change', 'op_trnd_tp_cd_onchange', 'op_trnd_tp_cd');		//Period 변경시 이벤트 처리
        axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');		//Location by 변경시 이벤트 처리
        axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');						//LOC_CD keyup 이벤트 처리
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    }

    /**
     * beforeactivate 이벤트 처리
     * beforeactivate -없애기
     */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	/**
	 * beforedeactivate 이벤트 처리
	 * beforedeactivate YYYY-MM 포멧 처리
	 */	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
	}

	/**
     * TP/SZ 클릭 이벤트 처리
    */
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
     * MVMT Status  클릭 이벤트 등록
    */
    function cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
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
     * Lease Term  클릭 이벤트 등록
    */       
    function lstm_cd_OnCheckClick(comboObj, index, code) {
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
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH04);
				}
				break;
		}
	}

	/**
     * 키이벤트 등록
    */  
 	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "ofc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;	
			case "over_stay_days":
				ComKeyOnlyNumber(event.srcElement);// 알파벳 대문자,숫자만 입력허용
				break;
		}
	} 
    /**
	* LOC_CD keyup 이벤트 처리
	* LOC_CD keyup시 대분자로 처리
	*/
    function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	        if ( formObject.loc_type_code.value == '6' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",7);
	        	    formObject.loc_cd.value = formObject.loc_cd.value.substring(0,7).toUpperCase();
	        	    if ( formObject.loc_cd.value.length == 7 ) {
	        	    	ComSetFocus(document.form.cntr_tpsz_cd);
	        	    }
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
        	    if ( formObject.loc_cd.value.length == 5 ) {
        	    	ComSetFocus(document.form.cntr_tpsz_cd);
        	    }
	        }
	        formObject.loc_cd.value = formObject.loc_cd.value.toUpperCase();
        }
    }
      
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function loc_type_code_onchange() {
    	var formObject = document.form;
        if ( formObject.loc_type_code.value != '' ) {
     	   formObject.loc_cd.readOnly = false;
     	   formObject.loc_cd.className = "input";
        } else {
     	   formObject.loc_cd.readOnly = true;
     	   formObject.loc_cd.className = "input2";
     	   formObject.loc_cd.value = "";
        }
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	
    	var cnt = 0;
    	var shtID = sheetObj.id;

    	switch(shtID) {
    		case "sheet1":      //sheet1 init
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 345;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msPrevColumnMerge + msHeaderOnly;
    				
                    //전체Edit 허용 여부 [선택, Default false]
    				Editable = false;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(2, 1, 20, 100);
    				
    				var formObject = document.form;
    				
    				if(formObject.loc_type_code.value == '' && formObject.ofc_cd.value !=''){
        				var HeadTitle1 = "RCC|LCC|TP&SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
        				var HeadTitle2 = "RCC|LCC|TP&SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";
    				}else{
        				var HeadTitle1 = "SCC|TP&SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
        				var HeadTitle2 = "SCC|TP&SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";    					
    				} 
    				
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				totHeadCount = headCount;
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(false, false, false, true, false,false);
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);
    				
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				if(formObject.loc_type_code.value == '' && formObject.ofc_cd.value !=''){
    					InitDataProperty(0, cnt++ , dtAutoSum,	80,	  daCenterTop,	true,	"rcc_cd",			false,	"",	dfNone);
    					InitDataProperty(0, cnt++ , dtData,	80,	  daCenterTop,	true,	"loc_cd",			false,	"",	dfNone);
    				}else{
    					InitDataProperty(0, cnt++ , dtAutoSum,	80,	  daCenterTop,	true,	"loc_cd",			false,	"",	dfNone);	
    				}
    				
    				InitDataProperty(0, cnt++ , dtData,		60,   daCenter, 	true,	"cntr_tpsz_cd",   	false,	"",	dfNone);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"total_qty",    	false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"total_avg",     	false,	"",	dfNullInteger);
    				
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_qty",   		false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_avg",    		false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_rate",		false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty1",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg1",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate1",			false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty2",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg2",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate2",			false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty3",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg3",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate3",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty4",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg4",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate4",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty5",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg5",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate5",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty6",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg6",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate6",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty7",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg7",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate7",			false,	"",	dfNone,	1);
                    InitDataProperty(0, cnt++ , dtHidden,	60,   daRight,  	true,	"lvl",				false,	"",	dfNone,	1);
                     
                    SetSortDialog(false);
                    InitTreeInfo(0, "sLevel", RgbColor(0,0,255), false);
                    CountPosition = 0;
                    SelectHighLight = false;
                    FrozenCols = 7;
    			}
    	        break;

    		case "sheet2":      //sheet1 init
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 345;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msPrevColumnMerge + msHeaderOnly;
    				
                    //전체Edit 허용 여부 [선택, Default false]
    				Editable = false;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(2, 1, 10, 100);
    				
    				var formObject = document.form;
    				
    				if(formObject.loc_type_code.value == '' && formObject.ofc_cd.value !=''){
        				var HeadTitle1 = "RCC|LCC|MVMT|TP&SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
        				var HeadTitle2 = "RCC|LCC|MVMT|TP&SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";
    				}else{
        				var HeadTitle1 = "SCC|MVMT|TP&SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
        				var HeadTitle2 = "SCC|MVMT|TP&SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";   					
    				}    				
   				
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				totHeadCount = headCount;
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(false, false, false, true, false,false);
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);
    				    				
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				if(formObject.loc_type_code.value == '' && formObject.ofc_cd.value !=''){
    					InitDataProperty(0, cnt++ , dtAutoSum,	80,	  daCenterTop,	true,	"rcc_cd",			false,	"",	dfNone);
    					InitDataProperty(0, cnt++ , dtData,  80,	  daCenterTop,	true,	"loc_cd",			false,	"",	dfNone);
    				}else{
    					InitDataProperty(0, cnt++ , dtAutoSum,  80,	  daCenterTop,	true,	"loc_cd",			false,	"",	dfNone);	
    				}    				
    				
    				InitDataProperty(0, cnt++ , dtData,		60,   daCenterTop, 	true,	"cnmv_sts_cd",   	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		60,   daCenter, 	true,	"cntr_tpsz_cd",   	false,	"",	dfNone);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"total_qty",    	false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"total_avg",     	false,	"",	dfNullInteger);
    				
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_qty",   		false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_avg",    		false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_rate",		false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight, 	 	true,	"qty1",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg1",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate1",			false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty2",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg2",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate2",			false,	"",	dfNone,	1);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty3",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg3",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate3",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty4",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg4",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate4",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty5",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg5",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate5",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty6",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg6",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate6",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty7",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg7",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate7",			false,	"",	dfNone,	1);
                    InitDataProperty(0, cnt++ , dtHidden,	60,   daRight,  	true,	"lvl",				false,	"",	dfNone,	1);
                     
                    SetSortDialog(false);
                    CountPosition = 0;
                    SelectHighLight = false;
                    FrozenCols = 8;
    			}
    	        break;
             case "sheet3":      //sheet1 init
            	 with (sheetObj) {

                     // 높이 설정
                     style.height = 345;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 10, 100);
                     
                     var loc_cd = document.form.loc_cd.value.substr(0,2);
                     var HeadTitle1 = "SCC|TP&SZ|Total|Total|Total|IC|IC|IC|ID|ID|ID|MT|MT|MT|OP|OP|OP|OC|OC|OC|TN|TN|TN|EN|EN|EN|TS|TS|TS|CI|CI|CI|CD|CD|CD|CM|CM|CM|CP|CP|CP|CO|CO|CO|CT|CT|CT|CE|CE|CE|";
                     var HeadTitle2 = "SCC|TP&SZ|A/CNTR|Count|AVG|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|";
                     var headCount = ComCountHeadTitle(HeadTitle1);
                     totHeadCount = headCount;
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, false, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtAutoSum, 80,    daCenterTop,	true,	"loc_cd",			false,	"",	dfNone		 );
                     InitDataProperty(0, cnt++ , dtData,    50,    daCenterTop,	true,	"cntr_tpsz_cd",		false,	"",	dfNone		 );

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"act_qty",	        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"total_qty",	    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"total_avg",		false,	"",	dfNullInteger);
                                                                                
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty1",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg1",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate1",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty2",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg2",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate2",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty3",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg3",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate3",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty4",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg4",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate4",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty5",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg5",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate5",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty6",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg6",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate6",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty7",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg7",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate7",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty8",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg8",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate8",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty9",		        false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg9",			    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate9",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty10",		    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg10",			false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate10",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty11",		    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg11",			false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate11",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty12",		    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg12",			false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate12",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty13",		    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg13",			false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate13",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty14",		    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg14",			false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate14",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"qty15",		    false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"avg15",			false,	"",	dfNullInteger);
                     InitDataProperty(0, cnt++ , dtData,    50,    daRight,     true,	"rate15",	        false,	"",	dfNone,1);

                     InitDataProperty(0, cnt++ , dtHidden,	60,   	daRight,  	true,	"lvl",				false,	"",	dfNone,	1);
                                                                                
                     SetSortDialog(false);
                     CountPosition = 0;
                     SelectHighLight = false;
                     FrozenCols = 5;
            	 }
                 break;
                 
         	}
    }

	/**
     * Sheet관련 프로세스 처리
    */  
    function doActionIBSheet(sheetObj,formObj,sAction, cnmv_sts_cd , cnmv_sts_nm) {
//    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBSEARCH:      //조회

         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		sheetObj.RemoveAll();
				initSheet(sheetObjects[0],1);
	            sheetObj.Redraw = false;
    			setParamValue();	//상세팝업  조회시 원조건 세팅
         		setHeaderOver(form,sheetObj,4);

         		sheetObj.CellValue(0,4) = form.over_stay_days.value+" or Over";
         		sheetObj.CellValue(0,5) = form.over_stay_days.value+" or Over";
         		sheetObj.CellValue(0,6) = form.over_stay_days.value+" or Over";   
         		
	            formObj.f_cmd.value = SEARCH;
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 
		        sheetObj.DoSearch("EES_CIM_0021GS.do",FormQueryString(formObj));
	            ComOpenWait(false); 
         		break;

         	case IBSEARCH01:      //공통조회
         		sheetObj.WaitImageVisible = false;
    			form.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0021GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   //TP/SZ 조회
    			tot_cntr_tpsz_cd = cntr_tpsz_cd;
    			var strCntrTpszCd  = cntr_tpsz_cd.split("|");
    			
    			//멀티콤보초기화
    			with (form.cntr_tpsz_cd) {
    				MultiSelect = true;
    				MultiSeparator = ",";
    				DropHeight = 330;
    				InsertItem(0 , 'ALL','');
    				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    					InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
    				}
    			} 
 			
			 	//Lease Term
			 	var sLeaseTermNm = ComGetEtcData(sXml,"lease_term_nm");
			 	var sLeaseTermCd = ComGetEtcData(sXml,"lease_term_cd");
			 	
			 	var arrLeaseTermNm = sLeaseTermNm.split("|");
			 	var arrLeaseTermCd = sLeaseTermCd.split("|");
			 	tot_lstm_cd = arrLeaseTermCd;	 

			 	with (form.lstm_cd) {
			 		MultiSelect = true;
			 		MultiSeparator = ",";
			 		DropHeight = 320;
			 		InsertItem(0 , 'ALL','');
			 		for ( var i=1; i<=arrLeaseTermCd.length; i++) {
			 			InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
			 		}
			 	}
    			break; 
         	case IBSEARCH02:      //By Movement
         		if(!validateForm(sheetObj,formObj,sAction)) return;
				initSheet(sheetObjects[1],2);
         		sheetObj.Redraw = false;
    			setParamValue();	//상세팝업  조회시 원조건 세팅
         		setHeaderOver(formObj,sheetObj,5);
         		
         		sheetObj.CellValue(0,5) = formObj.over_stay_days.value+" or Over";
         		sheetObj.CellValue(0,6) = formObj.over_stay_days.value+" or Over";
         		sheetObj.CellValue(0,7) = formObj.over_stay_days.value+" or Over";
         		
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 

	            formObj.f_cmd.value = SEARCH02;
		        sheetObj.DoSearch("EES_CIM_0021GS.do",FormQueryString(formObj));
		        ComOpenWait(false); 
         		break;    			
         	case IBSEARCH03:      //Total/Days
        		if ( beforetab == 2 ) {	  //3번째 탭에서 조회
             		if ( formObj.loc_type_code.value == '' || formObj.loc_type_code.value == '1' || formObj.loc_type_code.value == '7') {
             			ComShowCodeMessage("CIM30009");	  //All (by RCC) and RCC (by LCC)는 조회할 수 없습니다.
             			return;
             		}
        		}
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		sheetObj.Redraw = false;
    			setParamValue();	//상세팝업  조회시 원조건 세팅
         		setHeaderOver(form,sheetObj,4);
         		
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 

	            formObj.f_cmd.value = SEARCH03;
		        sheetObj.DoSearch("EES_CIM_0021GS.do",FormQueryString(formObj));
	            ComOpenWait(false); 
         		break;    			
			case IBSEARCH04: //location focusOut
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == 1 ) {
					inquiryLevel = "R";
				} else if  ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel = "S";
				} else if  ( formObj.loc_type_code.value == 6 ) {
					inquiryLevel = "Y";
				}
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH04;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0021GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if ( document.form.loc_type_code.value == '1' ) {
							ComShowCodeMessage("CIM30021","RCC");
						} else if ( document.form.loc_type_code.value == '2' ) {
							ComShowCodeMessage("CIM30021","LCC");
						} else if ( document.form.loc_type_code.value == '3' ) {
							ComShowCodeMessage("CIM30021","LCC");
						} else if ( document.form.loc_type_code.value == '4' ) {
							ComShowCodeMessage("CIM30021","ECC");
						} else if ( document.form.loc_type_code.value == '5' ) {
							ComShowCodeMessage("CIM30021","SCC");
						} else if ( document.form.loc_type_code.value == '6' ) {
							ComShowCodeMessage("CIM30021","Yard");
						}
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
	
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.cntr_tpsz_cd);
					return false;
				}
				break;         		
            case IBDOWNEXCEL:      // 입력
            	if ( sheetObj.rowCount != 0 ) {
          	  		sheetObj.Down2Excel(-1, false, false, true);
            	} else {
            		ComShowMessage(msgs["CIM30008"]);	//No data found
            		return;
            	}
          	  	break;
         }
     }

    /**
     * 장기체화 기준일수에 따라, ?? Or Over Column명 바뀜  
     */
    function setHeaderOver(form,sheetObj,cnt){
    	var str_loc_nm = "";
        
 		if ( form.loc_type_code.value == "" ) {
 			str_loc_nm = "RCC";
 		} else if ( form.loc_type_code.value == "7" ) {
 			str_loc_nm = "ECC";
 		} else if ( form.loc_type_code.value == "1" ) {
 			str_loc_nm = "LCC";	
 		} else if ( form.loc_type_code.value == "2" ) {
 			str_loc_nm = "ECC";
 		} else if ( form.loc_type_code.value == "3" ) {
 			str_loc_nm = "SCC";
 		} else if ( form.loc_type_code.value == "4" ) {
 			str_loc_nm = "SCC";
 		} else if ( form.loc_type_code.value == "5" ) {
 			str_loc_nm = "Yard";
 		} else if ( form.loc_type_code.value == "6" ) {
 			str_loc_nm = "Yard";
 		}
 		sheetObj.CellValue(0,0) = str_loc_nm;
 		sheetObj.CellValue(1,0) = str_loc_nm;
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt  = 0 ;
    			InsertTab( cnt++ , "Summary" , -1 );
    			InsertTab( cnt++ , "By Movement" , -1 );
    			InsertTab( cnt++ , "Total S/Days" , -1 );
    		}
    		break;
    	 }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab= nItem;
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 data 조회한다.
     */
    function tab1_OnClick(tabObj , nItem)
    {
    	if ( nItem == 0 ) {
    		form.free_cd.value = "1";
    		form.free_cd.disabled = false;
    		form.ofc_cd.readOnly = false;
    		form.ofc_cd.className = "input";
 		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {
     		form.free_cd.value = "1";
     		form.free_cd.disabled = false;
    		form.ofc_cd.readOnly = false;
    		form.ofc_cd.className = "input";
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
     	} else if ( nItem == 2 ) {
     		form.free_cd.value = "";
     		form.free_cd.disabled = true;
     		form.ofc_cd.value = "";
    		form.ofc_cd.readOnly = true;
    		form.ofc_cd.className = "input2";
 			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
     	}
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	  	var formObject = document.form;

    	  	if ( doActionIBSheet(sheetObj, document.form, IBSEARCH04) ) {	//Location 유효성체크
     	        return false;
     	    } else {
	    	  	if(formObject.loc_type_code.value != "" && formObject.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	
	    	  	var ofcCd = formObject.ofc_cd.value;
	    	  	formObject.ofc_cd.value = '';
	    	  	
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	
	    	  	formObject.ofc_cd.value = ofcCd;
	    	  	
	    	  	return true;
     	    }
    	}
    	return true;
    }

    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	if ( sheetObj.rowCount != 0 ) {
    		with(sheetObj)
    		{
    			for(var i = 1; i <= LastRow; i ++)
    			{
    				var lvl = CellValue(i, "lvl");
    				if ( lvl == '01' ) {
    					sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    				}
    			}
    			for ( var j=0; j<totHeadCount; j++ ) {
    				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
    			}
    			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
    			sheetObj.RowDelete(sheetObj.LastRow-1 , false);
    			
    			sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
    			sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 2);
    		}
    		sheetObj.SelectHighLight = false;
    	}
    	sheetObj.Redraw = true;
    }

    /**
     * Tab2 조회종료
     * Tab2 조회종료후 이벤트 호출
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg)
    {
    	if ( sheetObj.rowCount != 0 ) {
    		with(sheetObj)
    		{
    			for(var i = 1; i <= LastRow; i ++)
    			{
    				var lvl = CellValue(i, "lvl");
    				if ( lvl == '001' || lvl=='101' ) {
    					sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    				}
    			}
    			for ( var j=0; j<totHeadCount; j++ ) {
    				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
    			}
    			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
    			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
    			sheetObj.RowDelete(sheetObj.LastRow-1 , false);
    			
    			sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
    			sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 3);
    		}
    		sheetObj.SelectHighLight = false;
    	}
    	sheetObj.Redraw = true;
    }

    /**
     * Tab3 조회종료
     * Tab3 조회종료후 이벤트 호출
     */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg)
    {
    	if ( sheetObj.rowCount != 0 ) {
    		with(sheetObj)
    		{
    			for(var i = 1; i <= LastRow; i ++)
    			{
    				var lvl = CellValue(i, "lvl");
    				if ( lvl == '01' ) {
    					sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    				}
    			}
    			for ( var j=0; j<totHeadCount; j++ ) {
    				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
    			}
    			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
    			sheetObj.RowDelete(sheetObj.LastRow-1 , false);
    			
    			sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
    			sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 2);
    		}
    		sheetObj.SelectHighLight = false;
    	}
    	
        var loc_cd = document.form.loc_cd.value.substr(0,2);
        var usViewFlag = true;
        if ( loc_cd == 'US' ) {
        	usViewFlag = false;
        }
		viewUsData( usViewFlag ) ; //Location by US이면 'CM','CP','CI','CO','CD','CT' 데이타 보이고 안보이기
    	
    	sheetObj.Redraw = true;
    }    
    
    /**
     * Location by loc_cd 팝업에서 선택한 값 Setting.
     */
    function popupFinish(aryPopupData, row, col, sheetIdx){
    	var sheetObject = sheetObjects[0];
        var formObject = document.form;
        formObject.loc_cd.value = aryPopupData[0][3] 
    }

    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet2_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet3_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }    
    