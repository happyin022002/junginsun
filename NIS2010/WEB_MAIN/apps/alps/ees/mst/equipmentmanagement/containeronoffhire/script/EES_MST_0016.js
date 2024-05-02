/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0016.js
*@FileTitle : Own Container Creation (New Van)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.10 민정호
* 1.0 Creation
* 
* History
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
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
     * @class ees_mst_0016 : ees_mst_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0016() {
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
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     function processButtonClick(){
         //***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****
         
         var sheetObject1 = sheetObjects[0];    	 
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             	 case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.select(formObject.mft_dt, 'yyyy-MM-dd');  
             	 	break;
             	 	
             	 case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.de_yrmon, 'yyyy-MM');  
          	 	break;             	 	
             	 	
    			case "ComOpenPopupWithTarget1":
   					ComOpenPopupWithTarget('/hanjin/EES_MST_0038.do', 640, 370, "lot_no:lot_no", "0,0", true);
   					break;             	 

    			case "ComOpenPopupWithTarget2":
    				ComOpenPopupWithTarget('/hanjin/EES_LSE_0091.do', 800, 450, "agmt_no:agmt_no|eff_dt:eff_dt|exp_dt:exp_dt|vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm|lstm_cd:lstm_cd", "0,0,1", true);    				
   					break;   
   					
    			case "ComOpenPopupWithTarget3":
					if(!checkAgmtNo(formObject)) return;
					ComOpenPopupWithTarget('/hanjin/EES_MST_0022.do?active_flag=1&own_cntr_flg=Y&cntr_tpsz_cd='+formObject.cntr_tpsz_cd.value+'&agmt_no='+formObject.agmt_no.value+'&lot_no='+formObject.lot_no.value, 1020, 660, "cntr_spec_no:cntr_spec_no|cntr_tpsz_cd:cntr_tpsz_cd|cntr_mtrl_cd:cntr_mtrl_cd|vndr_seq:mft_vndr_seq|vndr_abbr_nm:vndr_abbr_nm", "0,0", true);
					unit_type_enableYn();
   					break;

    			case "btn_new":
				   enabledYn('I');
    			   objectClear();
				   ComResetAll();
				   sheetObjects[0].EtcData("lot_no") ="";
				   
				   comboObjects[2].Index2 = "-1";
				   comboObjects[2].Enable = false;
				   comboObjects[3].Index2 = "-1";
				   comboObjects[3].Enable = false;
				   formObject.rf_mdl_nm.value = "";
				   formObject.rf_rfr_no.value = "";
				   formObject.min_temp.value = "";
				   formObject.max_temp.value = "";
				   formObject.rf_mdl_nm.readOnly = true;
				   formObject.rf_rfr_no.readOnly = true;
				   formObject.min_temp.readOnly = true;
				   formObject.max_temp.readOnly = true;				
				   document.getElementById("rf_mdl_nm").className = "input2";
				   document.getElementById("rf_rfr_no").className = "input2";
				   document.getElementById("min_temp").className = "input2";
				   document.getElementById("max_temp").className = "input2";				   
                   break;
                 
                case "btn_save":         	
                 	// 필수항목 Check  
					if(!checkItem(formObject)) return;
					
               		doActionIBSheet(sheetObject1, formObject, IBSAVE);   
					lot_no_change();
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
	  * checkAgmtNo - 게약번호 선택후 입력 가능합니다.
	  */
	function checkAgmtNo(formObj){
		if (formObj.agmt_no.value.trim().length == 0) {
			ComShowCodeMessage("MST01018");
			return false;
		} 
		return true;
	}

 	/**
	  * 필수항목 체크
	  */
	function checkItem(formObj){		  
		var changeYn = 'N';

		if(ComGetObjValue(formObj.org_plst_flr_flg) == 'N' && formObj.plst_flr_flg.checked == false){
				changeYn = 'Y';
		}

		if(ComGetObjValue(formObj.org_plst_flr_flg) == 'Y' && ComGetObjValue(formObj.plst_flr_flg) == 'Y'){
			changeYn = 'Y';
		}
		if(ComGetObjValue(formObj.org_agmt_no)				==	ComGetObjValue(formObj.agmt_no)                 &&				
				ComGetObjValue(formObj.org_mft_dt)          	==	ComGetObjValue(formObj.mft_dt)				&&
				ComGetObjValue(formObj.org_cntr_hngr_rck_cd)	==	ComGetObjValue(formObj.cntr_hngr_rck_cd)	&&
				ComGetObjValue(formObj.org_fctry_spec_no)		==	ComGetObjValue(formObj.fctry_spec_no)		&&
				ComGetObjValue(formObj.org_de_yrmon)	  		==	ComGetObjValue(formObj.de_yrmon)			&&
				ComGetObjValue(formObj.org_certi_no)	       	==	ComGetObjValue(formObj.certi_no)	    	&&				    
				ComGetObjValue(formObj.org_diff_rmk)		    ==	ComGetObjValue(formObj.diff_rmk)			&&
				ComGetObjValue(formObj.org_mft_vndr_seq)		==	ComGetObjValue(formObj.mft_vndr_seq)		&&
				ComGetObjValue(formObj.org_apro_csc_no)			==	ComGetObjValue(formObj.apro_csc_no)		&&
				ComGetObjValue(formObj.org_apro_tir_no)			==	ComGetObjValue(formObj.apro_tir_no)		&&
				ComGetObjValue(formObj.org_apro_uic_no)			==	ComGetObjValue(formObj.apro_uic_no)		&&
				ComGetObjValue(formObj.org_apro_tct_no)			==	ComGetObjValue(formObj.apro_tct_no)     &&
				ComGetObjValue(formObj.org_unit_type)			==	ComGetObjValue(formObj.unit_type)  		&&	
				ComGetObjValue(formObj.org_rf_mkr_seq)			==	ComGetObjValue(formObj.rf_mkr_seq)      &&
				ComGetObjValue(formObj.org_rf_mdl_nm)			==	ComGetObjValue(formObj.rf_mdl_nm)       &&
				ComGetObjValue(formObj.org_rf_rfr_no)			==	ComGetObjValue(formObj.rf_rfr_no)       &&
				ComGetObjValue(formObj.org_min_temp)			==	ComGetObjValue(formObj.min_temp)        &&
				ComGetObjValue(formObj.org_max_temp)			==	ComGetObjValue(formObj.max_temp))
		{
			if(changeYn == 'Y'){
				ComShowCodeMessage("MST00012");		// 변경사항이 없습니다.
				return false;
			}
		}
		if (formObj.cntr_spec_no.value.trim().length == 0) {
			ComShowCodeMessage("MST00001", "Spec. No");
			formObj.cntr_spec_no.focus();
			return false;
		} 

		if(comboObjects[0].Text == ''){
			ComShowCodeMessage("MST00001", "M/facturer Place");
			return false;
		}

		if (formObj.mft_dt.value.trim().length == 0) {
			ComShowCodeMessage("MST00001", "M/Facture Date");
			formObj.mft_dt.focus();
			return false;
		} 
		if(ComGetDaysBetween(ComGetNowInfo(), formObj.mft_dt) > 0){			
			ComShowCodeMessage("MST01006", "M/Facture Date");			
			formObj.mft_dt.value = "";
			return false;
		}			

		if(comboObjects[1].Text == ''){
			ComShowCodeMessage("MST00001", "S/N Range");
			return false;
		}

		if (formObj.fm_ser_no.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "S/N Range");
			formObj.fm_ser_no.focus();
			return false;
		} 

		if (formObj.to_ser_no.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "S/N Range");
			formObj.to_ser_no.focus();
			return false;
		} 
		if (formObj.de_yrmon.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "Delivery Month");
			formObj.de_yrmon.focus();
			return false;
		} 

		if (formObj.agmt_no.value.trim().length == 0 ) {
			ComShowCodeMessage("MST00001", "AGMT No.");
			formObj.agmt_no.focus();
			return false;
		} 
		
		if (formObj.certi_no.value.trim().length == 0 ){
			ComShowCodeMessage("MST00001", "CERTI No.");
			formObj.certi_no.focus();
			return false;
		}
		
		if (formObj.apro_csc_no.value.trim().length == 0 ){
			ComShowCodeMessage("MST00001", "CSC No.");
			formObj.apro_csc_no.focus();
			return false;
		}	    
		if (formObj.apro_tir_no.value.trim().length == 0 ){
			ComShowCodeMessage("MST00001", "TIR No.");
			formObj.apro_tir_no.focus();
			return false;
		}
		
		if(eval(formObj.range_count.value) < 1){
			ComShowCodeMessage("MST01022");
			return false;
		}

		if (formObj.rf_mdl_nm.readOnly == false){
			var vstr = ComGetObjValue(formObj.rf_mkr_seq);
			if (vstr.length == 0 ){
				ComShowCodeMessage("MST00001", "Marker");
				formObj.rf_mkr_seq.focus();
				return false;
			}
			if (formObj.rf_mdl_nm.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Model No.");
				formObj.rf_mdl_nm.focus();
				return false;
			}
			if (formObj.rf_rfr_no.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Refrigerant");
				formObj.rf_rfr_no.focus();
				return false;
			}
			if (formObj.min_temp.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Max Setting Temp(Min)");
				formObj.min_temp.focus();
				return false;
			}
			if (formObj.max_temp.value.trim().length == 0 ){
				ComShowCodeMessage("MST00001", "Max Setting Temp(Max)");
				formObj.max_temp.focus();
				return false;
			}
		}
		return true;
	}

 	/**
	 * doActionIBSheet
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {  
         switch(sAction) {
			case IBSEARCH:      //조회
			    sheetObj.WaitImageVisible=false;
			    ComOpenWait(true);			
				formObj.f_cmd.value = SEARCH;			
 				var xml = "";
 				xml = sheetObj.GetSearchXml("EES_MST_0016GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
            	var chk = xml.indexOf("ERROR"); 				
            	if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
            		sheetObj.LoadSearchXml(xml);
            		return;
            	} else {
            		sheetObj.LoadSearchXml(xml);
            	}				
 				
				setSearchValue(sheetObj, formObj);
				unit_type_enableYn();
				enabledYn('U');		
				break;
				
 			case IBSAVE:        //저장
				if(ComGetObjValue(formObj.lot_no) == '' || ComGetObjValue(formObj.lot_no) == null){	
					formObj.f_cmd.value = MULTI01;		// 생성
				}else{
					formObj.f_cmd.value = MULTI02;		// 수정
				}
 			    sheetObj.WaitImageVisible=false; 			
 			    ComOpenWait(true);
				sheetObj.DoSearch("EES_MST_0016GS.do", FormQueryString(formObj));								
				var lot_no = sheetObj.EtcData("lot_no");

				if(typeof lot_no == "undefined" || lot_no == ""){					
				}else{
					formObj.lot_no.value = sheetObj.EtcData("lot_no");
					enabledYn('U');	
				}
				
				ComOpenWait(false);
				ComShowObject(formObj.ComOpenPopupWithTarget2, false);
			    ComShowObject(formObj.ComOpenPopupWithTarget3, false);
				break;
				
 			case SEARCH08:      //Unit Type 조회
 				sheetObj.WaitImageVisible=false;
 				ComOpenWait(true);			
 				formObj.f_cmd.value = SEARCH08;			
				var xml = "";
				xml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
				var comboItems = ComGetEtcData(xml, "unit_type").split("|");
				if(comboItems != ""){
					addComboItem(formObj.unit_type,comboItems);
				}
				ComOpenWait(false);
			break;
         }                
     }
          
	 function setSearchValue(sheetObj, formObj){
		ComSetObjValue(formObj.agmt_no, 	sheetObj.CellValue(1,'agmt_no'));                            
		ComSetObjValue(formObj.lstm_cd,		sheetObj.CellValue(1,'lstm_cd'));                
		ComSetObjValue(formObj.eff_dt, 		sheetObj.CellValue(1,'eff_dt'));                 
		ComSetObjValue(formObj.exp_dt, 		sheetObj.CellValue(1,'exp_dt'));                 		
		ComSetObjValue(formObj.vndr_seq, 	sheetObj.CellValue(1,'vndr_seq'));               		
		ComSetObjValue(formObj.vndr_lgl_eng_nm, 	sheetObj.CellValue(1,'vndr_lgl_eng_nm'));        
		ComSetObjValue(formObj.cntr_spec_no, 		sheetObj.CellValue(1,'cntr_spec_no'));           
		ComSetObjValue(formObj.cntr_tpsz_cd, 		sheetObj.CellValue(1,'cntr_tpsz_cd'));		 
		ComSetObjValue(formObj.fctry_spec_no,		sheetObj.CellValue(1,'fctry_spec_no'));		 
		ComSetObjValue(formObj.lot_loc_cd,			sheetObj.CellValue(1,'lot_loc_cd'));		 
		ComSetObjValue(formObj.mft_vndr_seq,		sheetObj.CellValue(1,'mft_vndr_seq'));           
		ComSetObjValue(formObj.org_mft_vndr_seq,	sheetObj.CellValue(1,'mft_vndr_seq'));  
		ComSetObjValue(formObj.vndr_abbr_nm,		sheetObj.CellValue(1,'vndr_abbr_nm'));			
		ComSetObjValue(formObj.mft_dt,				sheetObj.CellValue(1,'mft_dt'));
		
		if(sheetObj.CellValue(1,'lot_cntr_pfx_cd') == 'HJCU'){
			ComSetObjValue(formObj.lot_cntr_pfx_cd,	sheetObj.CellValue(1,'lot_cntr_pfx_cd'));       
		}else if(sheetObj.CellValue(1,'lot_cntr_pfx_cd') == 'SMCU'){
			ComSetObjValue(formObj.lot_cntr_pfx_cd,	sheetObj.CellValue(1,'lot_cntr_pfx_cd'));       
		}else{			
			if( sheetObj.CellValue(1,'lot_cntr_pfx_cd') != ""){
				formObj.lot_cntr_pfx_cd.InsertItem(3, sheetObj.CellValue(1,'lot_cntr_pfx_cd'), sheetObj.CellValue(1,'lot_cntr_pfx_cd'));
				ComSetObjValue(formObj.lot_cntr_pfx_cd,	sheetObj.CellValue(1,'lot_cntr_pfx_cd'));
			}else{
				ComSetObjValue(formObj.lot_cntr_pfx_cd,	"");
			}
		}       

		ComSetObjValue(formObj.fm_ser_no,	sheetObj.CellValue(1,'fm_ser_no'));              
		ComSetObjValue(formObj.to_ser_no,	sheetObj.CellValue(1,'to_ser_no'));              
		ComSetObjValue(formObj.de_yrmon,	sheetObj.CellValue(1,'de_yrmon'));               
		ComSetObjValue(formObj.plst_flr_flg,		sheetObj.CellValue(1,'plst_flr_flg'));   
		if(sheetObj.CellValue(1,'plst_flr_flg') == 'N'){
			formObj.plst_flr_flg.checked = false;
		}		
		ComSetObjValue(formObj.cntr_hngr_rck_cd,	sheetObj.CellValue(1,'cntr_hngr_rck_cd'));   	
		ComSetObjValue(formObj.fa_if_grp_sts_cd,	sheetObj.CellValue(1,'fa_if_grp_sts_cd')); 
		ComSetObjValue(formObj.certi_no,			sheetObj.CellValue(1,'certi_no'));               
		ComSetObjValue(formObj.apro_csc_no,			sheetObj.CellValue(1,'apro_csc_no'));            
		ComSetObjValue(formObj.apro_tir_no,			sheetObj.CellValue(1,'apro_tir_no'));            
		ComSetObjValue(formObj.apro_uic_no,			sheetObj.CellValue(1,'apro_uic_no'));            
		ComSetObjValue(formObj.apro_tct_no,			sheetObj.CellValue(1,'apro_tct_no'));        
		ComSetObjValue(formObj.org_apro_csc_no,	sheetObj.CellValue(1,'apro_csc_no'));            
		ComSetObjValue(formObj.org_apro_tir_no,	sheetObj.CellValue(1,'apro_tir_no'));            
		ComSetObjValue(formObj.org_apro_uic_no,	sheetObj.CellValue(1,'apro_uic_no'));            
		ComSetObjValue(formObj.org_apro_tct_no,	sheetObj.CellValue(1,'apro_tct_no'));        		
		ComSetObjValue(formObj.cntr_mtrl_cd,	sheetObj.CellValue(1,'cntr_mtrl_cd'));  
		ComSetObjValue(formObj.range_count,	sheetObj.CellValue(1,'range_count'));  		
		ComSetObjValue(formObj.org_agmt_no,	sheetObj.CellValue(1,'agmt_no')); 			 	
		ComSetObjValue(formObj.org_diff_rmk,sheetObj.CellValue(1,'diff_rmk'));  	
		ComSetObjValue(formObj.diff_rmk,	sheetObj.CellValue(1,'diff_rmk'));  		 	 
		ComSetObjValue(formObj.org_mft_dt,	sheetObj.CellValue(1,'org_mft_dt'));  	
		ComSetObjValue(formObj.org_cntr_hngr_rck_cd,	sheetObj.CellValue(1,'org_cntr_hngr_rck_cd'));  	
		ComSetObjValue(formObj.org_plst_flr_flg,	sheetObj.CellValue(1,'org_plst_flr_flg'));
		ComSetObjValue(formObj.org_fctry_spec_no,	sheetObj.CellValue(1,'org_fctry_spec_no'));
		ComSetObjValue(formObj.org_de_yrmon,	sheetObj.CellValue(1,'org_de_yrmon'));
		ComSetObjValue(formObj.org_certi_no,	sheetObj.CellValue(1,'org_certi_no'));
		ComSetObjValue(formObj.org_unit_type,	sheetObj.CellValue(1,'unit_type'));		
		ComSetObjValue(formObj.unit_type,	sheetObj.CellValue(1,'unit_type'));
		ComSetObjValue(formObj.rf_mkr_seq,			sheetObj.CellValue(1,'rf_mkr_seq'));       
		ComSetObjValue(formObj.rf_mdl_nm,			sheetObj.CellValue(1,'rf_mdl_nm'));       
		ComSetObjValue(formObj.rf_rfr_no,			sheetObj.CellValue(1,'rf_rfr_no'));       
		ComSetObjValue(formObj.min_temp,			sheetObj.CellValue(1,'min_temp'));       
		ComSetObjValue(formObj.max_temp,			sheetObj.CellValue(1,'max_temp'));	
		ComSetObjValue(formObj.org_rf_mkr_seq,			sheetObj.CellValue(1,'org_rf_mkr_seq'));       
		ComSetObjValue(formObj.org_rf_mdl_nm,			sheetObj.CellValue(1,'org_rf_mdl_nm'));       
		ComSetObjValue(formObj.org_rf_rfr_no,			sheetObj.CellValue(1,'org_rf_rfr_no'));       
		ComSetObjValue(formObj.org_min_temp,			sheetObj.CellValue(1,'org_min_temp'));       
		ComSetObjValue(formObj.org_max_temp,			sheetObj.CellValue(1,'org_max_temp'));			
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
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {     	
    	var sheetObj = sheetObjects[0];
    	
  		for(i=0;i<sheetObjects.length;i++){ 
  	         //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );  			
			initSheet(sheetObjects[i],i+1);
	         //khlee-마지막 환경 설정 함수 추가
//          ComEndConfigSheet(sheetObjects[i]);			
		}
  		
  		comboObjects[3].Enable = false;
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){  	    	
	        initCombo(comboObjects[k],k+1);
	    } 	
	    
	    comboObjects[0].UseAutoComplete = true;	    
	    comboObjects[2].Enable = false;
	    
		//html컨트롤 이벤트초기화
		initControl();
		
		doActionIBSheet(sheetObj, document.form, SEARCH08);
     }
      
  	 function initControl() {
	    axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);        	      	   
		axon_event.addListenerFormat('keypress','obj_keypress',	form);				//- 키 눌렸을때
		axon_event.addListener("change", "lot_no_change","lot_no");
		axon_event.addListener("change", "lstm_cd_change","lstm_cd");
		axon_event.addListener("change", "cntr_tpsz_cd_change","cntr_tpsz_cd");
		axon_event.addListener("change", "vndr_abbr_nm_change","vndr_abbr_nm");
		axon_event.addListener("change", "range_change1","fm_ser_no");
		axon_event.addListener("change", "range_change2","to_ser_no");
		axon_event.addListener("change", "agmt_no_change","agmt_no");				
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- 키 눌렸을때
	 }

     /**
     * obj_keyup
     */   
  	 function obj_keyup() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		switch (obj.name) {
 			case "fm_ser_no": 
		  		if (formObj.fm_ser_no.value.length == 6) {
		  			if (vKeyCode != 8 && vKeyCode != 46 && vKeyCode != 32 && 
		  				vKeyCode != 37 && vKeyCode != 38 && vKeyCode != 39 && vKeyCode != 40){
						ComSetFocus(formObj.to_ser_no);
		  			}
		  		}
		  		break;
 			case "to_ser_no": 
		  		if (formObj.to_ser_no.value.length == 6) {
		  			if (vKeyCode != 8 && vKeyCode != 46 && vKeyCode != 32 && 
		  				vKeyCode != 37 && vKeyCode != 38 && vKeyCode != 39 && vKeyCode != 40){
						ComSetFocus(formObj.range_count);
		  			}
		  		}
		  		break;
 		 }
 	 }  	 

     /**
      * obj_keypress
      */   
 	 function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    

	    switch(obj.dataformat) {
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
         	case "int":                  		
         		if(obj.name=="fm_ser_no") ComKeyOnlyNumber('int');
         		if(obj.name=="to_ser_no") ComKeyOnlyNumber('int');         		
    	        break;
            case "ymd":
                if(obj.name=="mft_dt") ComKeyOnlyNumber(this, "-");
                break;
        	case "float":
        		ComKeyOnlyNumber(obj, "-.");
        		break;                
	    }        
	 }

     /**
      * agmt_no_change
     */ 
	 function agmt_no_change(){
		var formObj = document.form;

		if(formObj.agmt_no.value.trim() != formObj.org_agmt_no.value.trim()){
			formObj.cntr_spec_no.value = '';
			formObj.apro_csc_no.value = '';
			formObj.apro_tir_no.value = '';
			formObj.apro_uic_no.value = '';
			formObj.apro_tct_no.value = '';

			// 입력시에는 TY/SZ를 초기화한다.
			// 수정시에는 TY/SZ를 초기화하지 않는다.
			if(formObj.lot_no.value.trim().length == 0){
				formObj.cntr_tpsz_cd.value = '';
			}
		}
	 }

     /**
      * lot_no_change
      */   	
	 function lot_no_change() {
		var sheetObject1 = sheetObjects[0];
		var formObj = document.form;
		
		if(formObj.lot_no.value.trim().length > 0){
			enabledYn('U');
			doActionIBSheet(sheetObject1,formObj,IBSEARCH)
		}
	 }  	

	 function enabledYn(sw){
		var formObj = document.form;

		if( sw == 'U'){  // 수정시
			
			ComShowObject(formObj.ComOpenPopupWithTarget2, false);
		    ComShowObject(formObj.ComOpenPopupWithTarget3, false);
		    
			if(formObj.fa_if_grp_sts_cd.value.trim().length > 0){
				// ERP I/F 전에만 가능
				// MFT_DT, DE_YRMON, AGMT_CTY_CD, AGMT_SEQ
				ComShowObject(formObj.btns_calendar1, false);
				ComShowObject(formObj.btns_calendar2, false);
			}else{
				ComShowObject(formObj.btns_calendar1, true);
				ComShowObject(formObj.btns_calendar2, true);
			}

			comboObjects[0].Enable = false;			
			comboObjects[1].Enable = false;
			formObj.fm_ser_no.readOnly = true;
			formObj.to_ser_no.readOnly = true;
		}else{		// 입력시
			ComShowObject(formObj.btns_calendar1, true);
			ComShowObject(formObj.btns_calendar2, true);
			ComShowObject(formObj.ComOpenPopupWithTarget2, true);
			ComShowObject(formObj.ComOpenPopupWithTarget3, true);

			comboObjects[0].Enable = true;		
			comboObjects[1].Enable = true;			
			formObj.fm_ser_no.readOnly = false;
			formObj.to_ser_no.readOnly = false;
		}
	 }

     /**
      * range_change
     */  
	 function range_change1(){
		var formObj = document.form;
		var fm_ser_no = formObj.fm_ser_no.value.trim();

		formObj.range_count.value = '';

		if(formObj.fm_ser_no.value.trim().length > 0){
			if(formObj.fm_ser_no.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.fm_ser_no.value.trim());
				ComSetFocus(formObj.fm_ser_no);
				return;
			}

			if(!ComIsNumber(fm_ser_no)){
				ComShowCodeMessage("MST01019", formObj.fm_ser_no.value.trim());
				ComSetFocus(formObj.fm_ser_no);
				return;
			}
		}
		getRangeCount();
	 }

	 function range_change2(){
		var formObj = document.form;

		formObj.range_count.value = '';

		if(formObj.to_ser_no.value.trim().length > 0){
			if(formObj.to_ser_no.value.trim().length != 6){
				ComShowCodeMessage("MST01021", formObj.to_ser_no.value.trim());
				ComSetFocus(formObj.to_ser_no);
				return;
			}
		}

		if(formObj.to_ser_no.value.trim().length > 0){
			if(!ComIsNumber(formObj.to_ser_no)){
				ComShowCodeMessage("MST01019", formObj.to_ser_no.value.trim());
				ComSetFocus(formObj.to_ser_no);
				return;
			}
		}
		getRangeCount();
	 }

	 function getRangeCount(){

		var formObj = document.form;
		var fm_no = formObj.fm_ser_no.value.trim();
		var to_no = formObj.to_ser_no.value.trim();

		if(formObj.fm_ser_no.value.trim().length != 6) return;
		if(formObj.to_ser_no.value.trim().length != 6) return;

		var change_count = String(to_no - fm_no + 1);
		formObj.range_count.value = change_count;

		if(eval(formObj.range_count.value) < 1 || eval(formObj.range_count.value) > 9999){
			ComShowCodeMessage("MST01022");
			formObj.to_ser_no.value = "";
			formObj.range_count.value = "";
			ComSetFocus(formObj.to_ser_no);
			return;
		}
	 }

     /**
      * lstm_cd_change
     */   	
	 function lstm_cd_change(){
		var formObj = document.form;
		var lstm_cd = ComGetObjValue(formObj.lstm_cd);

		if(  lstm_cd == 'OW' || lstm_cd == 'OL' || lstm_cd == 'LP' ){
		}else{
			ComClearObject(formObj.agmt_no);
			ComClearObject(formObj.lstm_cd);
			ComClearObject(formObj.eff_dt);
			ComClearObject(formObj.exp_dt);
			ComClearObject(formObj.vndr_seq);
			ComClearObject(formObj.vndr_lgl_eng_nm);			
			ComShowCodeMessage("MST01003");
		}
	 }

     function cntr_tpsz_cd_change(){
		var formObj = document.form;
		var cntr_tpsz_cd = ComGetObjValue(formObj.cntr_tpsz_cd);
		
		if (cntr_tpsz_cd == "TP/SZ"){
			ComClearObject(formObj.cntr_tpsz_cd);
			ComClearObject(formObj.cntr_spec_no);
			ComClearObject(formObj.vndr_abbr_nm);
		}
     }
    
     function vndr_abbr_nm_change(){
		var formObj = document.form;
		var Manfac = ComGetObjValue(formObj.vndr_abbr_nm);
		
		if (Manfac == "Manufacturer"){
			ComClearObject(formObj.vndr_abbr_nm);			
		}
     }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {  	   
      
    	var cnt = 0;
      	switch (sheetObj.id) {
	      	case 'sheet1': 
	      	  with(sheetObj){
		          // 높이 설정
		          style.height = 0;
		          
		          //전체 너비 설정
		          SheetWidth = mainTable.cleintWidth;
		
		          //Host정보 설정[필수][HostIp, Port, PagePath]
				  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		          //전체Merge 종류 [선택, Default msNone]
		          MergeSheet = msNone;
		
		         //전체Edit 허용 여부 [선택, Default false]
		          Editable = true;
		
		          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		          InitRowInfo( 1, 1, 3, 100);
		
		          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		          InitColumnInfo(49, 0, 0, true);          
		
		          // 해더에서 처리할 수 있는 각종 기능을 설정한다
		          InitHeadMode(true, true, true, true, false,false)
		
		          var HeadTitle = "|agmt_no|agmt_cty_cd|agmt_seq|lstm_cd|eff_dt|exp_dt|vndr_seq|vndr_lgl_eng_nm|cntr_spec_no|cntr_tpsz_cd|fctry_spec_no|lot_loc_cd|mft_dt|fm_ser_no|to_ser_no|de_yrmon|plst_flr_flg|cntr_hngr_rck_cd|fa_if_grp_sts_cd|certi_no|apro_csc_no|apro_tir_no|apro_uic_no|apro_tct_no|cntr_mtrl_cd|mft_vndr_seq|lot_cntr_pfx_cd|range_count|diff_rmk|org_agmt_no|org_mft_dt|org_cntr_hngr_rck_cd|org_plst_flr_flg|org_fctry_spec_no|org_de_yrmon|org_certi_no|vndr_abbr_nm|unit_type|rf_mkr_seq|rf_mdl_nm|rf_rfr_no|min_temp|max_temp|org_rf_mkr_seq|org_rf_mdl_nm|org_rf_rfr_no|org_min_temp|org_max_temp";
		      
		          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		          InitHeadRow(0, HeadTitle, true);
		
		          //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		          InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"agmt_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"agmt_cty_cd",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"agmt_seq",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"lstm_cd",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"eff_dt",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"exp_dt",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"vndr_seq",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"vndr_lgl_eng_nm",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cntr_spec_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"fctry_spec_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"lot_loc_cd",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"mft_dt",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"fm_ser_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"to_ser_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"de_yrmon",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"plst_flr_flg",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cntr_hngr_rck_cd",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"fa_if_grp_sts_cd",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"certi_no",			false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"apro_csc_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"apro_tir_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"apro_uic_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"apro_tct_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cntr_mtrl_cd",		false,	"",	dfNone,	0,	false,	false);    
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"mft_vndr_seq",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"lot_cntr_pfx_cd",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"range_count",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"diff_rmk",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_agmt_no",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_mft_dt",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_cntr_hngr_rck_cd",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_plst_flr_flg",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_fctry_spec_no",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_de_yrmon",		false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_certi_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"vndr_abbr_nm",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"unit_type",		false,	"",	dfNone,	0,	false,	false);
		          
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"rf_mkr_seq",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"rf_mdl_nm",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"rf_rfr_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"min_temp",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"max_temp",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_rf_mkr_seq",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_rf_mdl_nm",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_rf_rfr_no",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_min_temp",		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"org_max_temp",		false,	"",	dfNone,	0,	false,	false);
	      	  }
	          break;
         }
      }
      
      /**
       * Combo 기본 설정 
       * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
       * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
       */ 
      function initCombo(comboObj, comboNo) {
    	    var formObject = document.form;   

			switch(comboNo) {       
			  case 1: 
				   with (comboObj) { 
					   SetColAlign("center|left");        
					   SetColWidth("100|200");         
					   DropHeight = 160;                         
				   }   
				   break;   
			  case 2: 
				   with (comboObj) { 
					   SetColAlign("center");        
					   SetColWidth("80");         
					   DropHeight = 160; 
				   }   
				   break; 
			  case 3: 
				   with (comboObj) { 
					   SetColAlign("left");        
					   SetColWidth("170");         
					   DropHeight = 160;
				   }   
				   break; 
				   
	   	      case 4://"vndr_abbr_nm":
				   with (comboObj) { 
				      SetColAlign("left|left");        
				      SetColWidth("100|200");         
				      DropHeight = 160;                         
			      } 
	   	          break;				   
			 } 

    	    switch(comboNo) {  
    	          case 1:       	        	  
    				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObj);
    				break; 
				  case 2:  					  
		      		formObject.lot_cntr_pfx_cd.InsertItem(0, "", "");
	      			//formObject.lot_cntr_pfx_cd.InsertItem(1, 'SMSU', 'SMSU'); 
	      			formObject.lot_cntr_pfx_cd.InsertItem(1, 'SMCU', 'SMCU'); 
	      			formObject.lot_cntr_pfx_cd.InsertItem(2, 'HJCU', 'HJCU'); 
					break;
				  case 4:
					  doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
					  break;
    	     }     	    
      }     
 
      function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
         sheetObj.ShowDebugMsg = false;
		 sheetObj.WaitImageVisible = false;
         switch(sAction) {            					
	        case IBSEARCH_ASYNC02:    
				formObj.f_cmd.value = SEARCH03;
	    	    var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
				var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(sXml);
				   return;
				}		    	    
				var sStr = ComGetEtcData(sXml, "comboList");    					
				var arrStr = sStr.split("@");    					
				MakeComboObject(formObj.lot_loc_cd, arrStr, 1, 0); 		    	   
	    	    break;	    
	    	    
            case IBSEARCH_ASYNC01://Sheet Combo 데이타 담아오기
	   	 		formObj.f_cmd.value = SEARCH01;
	   			var xmlStr = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
	   		    var chk = xmlStr.indexOf("ERROR");
	   			if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
	   			   sheetObj.LoadSearchXml(xmlStr);
	   			   return;
	   		    }  		
	   			var sStr = ComGetEtcData(xmlStr, "comboList");
	   			var arrStr = sStr.split("@");
	   			MakeComboObject(formObj.rf_mkr_seq, arrStr, 1, 0);
	   			break;
         }
		 sheetObj.WaitImageVisible = true;
      }
    	
      /**
       * 콤보 오브젝트 생성(Spec No * Type/Size)
       */
      function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
  		 cmbObj.RemoveAll();
  		 cmbObj.InsertItem(0, "", "");
  		
  		 for (var i=0; i<arrStr.length; i++) {
  		    var arrCode = arrStr[i].split("|");
  			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
  		 }
  		 cmbObj.Index2 = "" ;
      }
      	 
	  /**
	  * 기본 오브젝트 초기화 
	  */
	  function objectClear(){
		var formObj = document.form;
		var sheetObj  = sheetObjects[0];

		// 데이타 초기화
		sheetObj.RemoveAll();

		// 화면 초기화
		formObj.reset();
	  }

	  function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	     var sheetObj  = sheetObjects[0];
         if (ErrMsg == "") {
             //alert("저장 성공하였습니다.");
         } else {
             sheetObj.EtcData("lot_no") = "";
         }
	  }
	
	  //Axon 이벤트 처리2. 이벤트처리함수	
	  function obj_activate() {
	     ComClearSeparator(event.srcElement);
	  }
	
	  //Axon 이벤트 처리2. 이벤트처리함수	
	  function obj_deactivate() {
		 var formObj = document.form;
		 var obj = event.srcElement;
			
	     if (event.srcElement.name == "mft_dt"){
	    	 ComAddSeparator(formObj.mft_dt);
	    	 if (ComGetNowInfo("ymd") < formObj.mft_dt.value){
	    		ComAlertFocus(formObj.mft_dt,ComGetMsg("MST01006", "", "", ""));	    		
	    		formObj.mft_dt.value = '';	    		
	    	 } else {
	    		ComAddSeparator(formObj.mft_dt, "ymd");
	    	 }
	     }  else if (event.srcElement.name == "max_temp" ||  event.srcElement.name == "min_temp"){
	    	 ComChkObjValid(event.srcElement);
	     }
	  }	
	
	 // TP/SZ가 R일 경우 Unit Type 비활성화	
	 function unit_type_enableYn(){
		var formObj = document.form;	
		
		if(formObj.cntr_tpsz_cd.value.trim().length > 0){
			if(formObj.cntr_tpsz_cd.value.substr(0,1) == 'R'){
				comboObjects[2].Enable = true;
				comboObjects[3].Enable = true;
				document.getElementById("rf_mdl_nm").className = "input1";
				document.getElementById("rf_rfr_no").className = "input1";
				document.getElementById("min_temp").className = "input1";
				document.getElementById("max_temp").className = "input1";
				formObj.rf_mdl_nm.readOnly = false;
				formObj.rf_rfr_no.readOnly = false;
				formObj.min_temp.readOnly = false;
				formObj.max_temp.readOnly = false;				
			}else{
				comboObjects[2].Index2 = "-1";
				comboObjects[2].Enable = false;
				comboObjects[3].Index2 = "-1";
				comboObjects[3].Enable = false;
				formObj.rf_mdl_nm.value = "";
				formObj.rf_rfr_no.value = "";
				formObj.min_temp.value = "";
				formObj.max_temp.value = "";
				formObj.rf_mdl_nm.readOnly = true;
				formObj.rf_rfr_no.readOnly = true;
				formObj.min_temp.readOnly = true;
				formObj.max_temp.readOnly = true;				
				document.getElementById("rf_mdl_nm").className = "input2";
				document.getElementById("rf_rfr_no").className = "input2";
				document.getElementById("min_temp").className = "input2";
				document.getElementById("max_temp").className = "input2";				
			}
		}
	 }
	 
	 /**
	  * 콤보필드에 데이터를 추가해준다.
	  */
	 function addComboItem(comboObj, comboItems) {
		  for ( var i = 0; i < comboItems.length; i++) {
	 		var comboItem = comboItems[i].split(",");
	 		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
	 	}
		  comboObj.InsertItem(0,"","");
	 }

	/* 개발자 작업  끝 */