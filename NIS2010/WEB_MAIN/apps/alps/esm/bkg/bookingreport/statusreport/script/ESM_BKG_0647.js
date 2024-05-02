/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0068.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.07.11 김보배 [CHM-201218861] [BKG] B/L Status Report 상 Web Original B/L 추가 요청
* 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
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
     * @extends 
     * @class esm_bkg_0647  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0647() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp; 
    	this.setComboObject 		= setComboObject;
    }
    
    
	/*
	 * 입력한 조건 값을 폼에 초기 값으로 처리하기 위한 변수
	 * */
    var arrFormElementMap = {dura_opt:'multi',      dura_from_dt:'input',dura_to_dt:'input', bl_sts_cd:'multi',  		vvd_cd:'input',	    pol_cd:'input', 
							 pod_cd:'input',		por_cd:'input',		 del_cd:'input',	 del_ofc_cd:'input',	 	obl_ofc_cd:'input',	
							 b_ofc_cd:'input', 		b_ofc_cd_1:'input',	 sal_ofc_cd:'input', bl_ofc_cd:'input',	 obl_rcv_ofc_cd:'input',	by_cd:'select',
							 staff_id:'input',	 	bkg_bl_cd:'radio',	 bkg_bl_no:'input',	 cust_tp_cd:'multi',		cust_cnt_cd:'input',
							 cust_seq:'input',		cust_nm:'input',	 sc_rfa_cd:'radio',	 sc_rfa_no:'input',	 		bl_type_ori:'check',	
							 bl_type_way:'check',	bl_type_web:'check'
							}
	    
	    
	    /*
	     * Grid 칼럼 별 속성 정의
	     * */                     
	    var arrGridColsProp= {
	    		bkg_no         	:"InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		prefix + 'bkg_no',        	false,		'',		dfNone,					0,		false,	true)",         
	    		bl_no          	:"InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		prefix + 'bl_no',         	false,		'',		dfNone,					0,		false,	true)",          
	    		por_cd          :"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'por_cd',        	false,		'',		dfNone,					0,		false,	true)",              
	    		pol_cd        	:"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'pol_cd',        	false,		'',		dfNone,					0,		false,	true)",              
	    		pod_cd         	:"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'pod_cd',        	false,		'',		dfNone,					0,		false,	true)",              
	    		del_cd         	:"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'del_cd',        	false,		'',		dfNone,					0,		false,	true)",              
	    		bkg_ofc        	:"InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + 'bkg_ofc',       	false,		'',		dfNone,					0,		false,	true)",              
	    		del_ofc      	:"InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + 'del_ofc',       	false,		'',		dfNone,					0,		false,	true)",     
	    		
	    		ob_type		 	:"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'ob_type',       	false,		'',		dfNone,					0,		false,	true)",     
	    		ob_date        	:"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'ob_date',       	false,		'',		dfDateYmd,				0,		false,	true)",            
	    		ir_bl_type    	:"InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + 'ir_bl_type',     	false,		'',		dfNone,					0,		false,	true)",             
	    		bl_issued     	:"InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + 'bl_issued',       false,		'',		dfNone,					0,		false,	true)",     
	    		bl_print    	:"InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + 'bl_print',        false,		'',		dfNone,					0,		false,	true)",
	    		
	    		bl_released   	:"InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + 'bl_released',     false,		'',		dfNone,					0,		false,	true)",       
	    		ir_office    	:"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'ir_office',     	false,		'',		dfNone,					0,		false,	true)",       
	    		ir_date        	:"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'ir_date',       	false,		'',		dfDateYmd,				0,		false,	true)",           
	    		
	    		ir_by         	:"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'ir_by',         	false,		'',		dfNone,					0,		false,	true)",       
	    		ors_office     	:"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'ors_office',    	false,		'',		dfNone,					0,		false,	true)",           
	    		ors_date  	 	:"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'ors_date',      	false,		'',		dfDateYmd,				0,		false,	true)",        
	    		ors_no         	:"InitDataProperty(0,		cnt++ , dtData,					30,		daCenter,		true,		prefix + 'ors_no',        	false,		'',		dfNone,					0,		false,	true)",        
	    		ors_surrender  	:"InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + 'ors_surrender', 	false,		'',		dfNone,					0,		false,	true)",         
	    		
	    		ors_do         	:"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'ors_do',        	false,		'',		dfNone,					0,		false,	true)",          
	    		bdi_sr          :"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'bdi_sr',        	false,		'',		dfNone,					0,		false,	true)",          
	    		bdi_complete  	:"InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + 'bdi_complete',  	false,		'',		dfNone,					0,		false,	true)",          
	    		bdi_type      	:"InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + 'bdi_type',  		false,		'',		dfNone,					0,		false,	true)",           
	    		bdi_confirm     :"InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + 'bdi_confirm',  	false,		'',		dfNone,					0,		false,	true)",       
	    		bdi_office      :"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'bdi_office',    	false,		'',		dfNone,					0,		false,	true)",            
	    		bdi_by          :"InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + 'bdi_by',        	false,		'',		dfNone,					0,		false,	true)",           
	    		
	    		pod_eta         :"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'pod_eta',       	false,		'',		dfDateYmd,              0,      false,  true)",
	    		vvd_cd          :"InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		prefix + 'vvd_cd',        	false,		'',		dfNone,					0,		false,	true)",           
	    		vvd_etd        	:"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'vvd_etd',       	false,		'',		dfDateYmd,              0,      false,  true)",
	    		cntr_confirm    :"InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		prefix + 'cntr_confirm',    false,		'',		dfNone,					0,		false,	true)",
	    		shipper       	:"InitDataProperty(0,		cnt++ , dtData,					70,		daLeft,			true,		prefix + 'shipper',       	false,		'',		dfNone,					0,		false,	true)",       
	    		fowarder        :"InitDataProperty(0,		cnt++ , dtData,					70,		daLeft,			true,		prefix + 'fowarder',     	false,		'',		dfNone,					0,		false,	true)",        
	    		consignee      	:"InitDataProperty(0,		cnt++ , dtData,					70,		daLeft,			true,		prefix + 'consignee',     	false,		'',		dfNone,					0,		false,	true)",          
	    		sales_office   	:"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'sales_office',   	false,		'',		dfNone,					0,		false,	true)",        
	    		sales_rep       :"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'sales_rep',      	false,		'',		dfNone,					0,		false,	true)",        
	    		
	    		sc_rfa_no      	:"InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + 'sc_rfa_no',       false,		'',		dfNone,					0,		false,	true)",        
	    		pay_term_cd    	:"InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		prefix + 'pay_term_cd',     false,		'',		dfNone,					0,		false,	true)",          
	    		ppd_org         :"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'ppd_org',         false,		'',		dfNone,					0,		false,	true)",          
	    		ppd_org2        :"InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + 'ppd_org2',        false,		'',		dfNone,					0,		false,	true)",         
	    		ppd_3rd   		:"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'ppd_3rd',         false,		'',		dfNone,		      		0,		false,	true)",   
	    		ppd_3rd2        :"InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + 'ppd_3rd2',        false,		'',		dfNone,		      		0,		false,	true)",            
	    		cct_dest      	:"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'cct_dest',        false,		'',		dfNone,					0,		false,	true)",      
	    		cct_dest2    	:"InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + 'cct_dest2',       false,		'',		dfNone,					0,		false,	true)",    
	    		cct_3rd       	:"InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + 'cct_3rd',         false,		'',		dfNone,		      		0,		false,	true)",          
	    		cct_3rd2        :"InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + 'cct_3rd2',        false,		'',		dfNone,		      		0,		false,	true)",          
	    		obl_iss_rmk     :"InitDataProperty(0,		cnt++ , dtData,					100,		daCenter,		true,		prefix + 'obl_iss_rmk',     false,		'',		dfNone,		      		0,		false,	true)"         
			}
	    
	    var arrGridColsTitle = {     
	    		bkg_no          :'Booking No.\n[BL Print]',                
	    		bl_no         	:'B/L No.\n[BL Issue]',           
	    		por_cd         	:'POR',            
	    		pol_cd         	:'POL',            
	    		pod_cd         	:'POD',         
	    		del_cd        	:'DEL',          
	    		bkg_ofc         :'BKG OFC',         
	    		del_ofc       	:'DEL OFC',  	    		
	    		ob_type        	:'Type',       
	    		ob_date        	:'Date',       
	    		ir_bl_type      :'B/L Type',              
	    		bl_issued     	:'Issue',       
	    		bl_print       	:'Print',   	    		
	    		bl_released    	:'Release',     
	    		ir_office       :'Office',         
	    		ir_date       	:'Date',         
	    		ir_by         	:'By',    
	    		ors_office     	:'Office',         
	    		ors_date     	:'Date',    
	    		ors_no          :'No',       
	    		ors_surrender  	:'Surrender',  	    		
	    		ors_do         	:'D/O',   
	    		bdi_sr          :'S/R',      
	    		bdi_complete   	:'Complete',            
	    		bdi_type        :'B/L Type',             
	    		bdi_confirm     :'Confirm',            
	    		bdi_office      :'Office',             
	    		bdi_by        	:'By',       	    		
	    		vvd_cd          :'VVD',  
	    		pod_eta         :'POD ETA',
	    		vvd_etd         :'VVD ETD', 
	    		cntr_confirm    :'CNTR CONFIRM',
	    		shipper         :'Shipper',        
	    		fowarder        :'Forwarder',          
	    		consignee       :'Consignee',           
	    		sales_office    :'Sales Office',          
	    		sales_rep       :'Sales Rep',           		
	    		sc_rfa_no       :'S/C or RFA',          
	    		pay_term_cd     :'Payment Term',           
	    		ppd_org       	:'PPD (Org)',            
	    		ppd_org2        :'PPD (Org)',          
	    		ppd_3rd     	:'PPD (3rd)',     
	    		ppd_3rd2      	:'PPD (3rd)',             
	    		cct_dest        :'CCT (Dest)',   
	    		cct_dest2      	:'CCT (Dest)',     
	    		cct_3rd         :'CCT (3rd)',            
	    		cct_3rd2        :'CCT (3rd)',            
	    		obl_iss_rmk   	:'B/L Remark(s)'
															   
			}
	    
	    
	    var arrGridColsTitle1 = {     
	    		bkg_no          :'Booking No.\n[BL Print]',                
	    		bl_no         	:'B/L No.\n[BL Issue]',           
	    		por_cd         	:'POR',            
	    		pol_cd         	:'POL',            
	    		pod_cd         	:'POD',         
	    		del_cd        	:'DEL',          
	    		bkg_ofc         :'BKG OFC',         
	    		del_ofc       	:'DEL OFC',  	    		
	    		ob_type        	:'On Board',       
	    		ob_date        	:'On Board',       
	    		ir_bl_type      :'Issue & Release',              
	    		bl_issued     	:'Issue & Release',       
	    		bl_print       	:'Issue & Release',   	    		
	    		bl_released    	:'Issue & Release',     
	    		ir_office       :'Issue & Release',         
	    		ir_date       	:'Issue & Release',         
	    		ir_by         	:'Issue & Release',    
	    		ors_office     	:'OBL Receive or Surrender',         
	    		ors_date     	:'OBL Receive or Surrender',    
	    		ors_no          :'OBL Receive or Surrender',       
	    		ors_surrender  	:'OBL Receive or Surrender',  	    		
	    		ors_do         	:'OBL Receive or Surrender',   
	    		bdi_sr          :'B/L Data Input',      
	    		bdi_complete   	:'B/L Data Input',            
	    		bdi_type        :'B/L Data Input',             
	    		bdi_confirm     :'B/L Data Input',            
	    		bdi_office      :'B/L Data Input',             
	    		bdi_by        	:'B/L Data Input',       	    		
	    		vvd_cd          :'VVD', 
	    		pod_eta         :'POD ETA',
	    		vvd_etd         :'VVD ETD',
	    		cntr_confirm    :'CNTR CONFIRM',
	    		shipper         :'Shipper',        
	    		fowarder        :'Forwarder',          
	    		consignee       :'Consignee',           
	    		sales_office    :'Sales Office',          
	    		sales_rep       :'Sales Rep',           		
	    		sc_rfa_no       :'S/C or RFA',          
	    		pay_term_cd     :'Payment Term',           
	    		ppd_org       	:'Payment Status',            
	    		ppd_org2        :'Payment Status',          
	    		ppd_3rd     	:'Payment Status',     
	    		ppd_3rd2      	:'Payment Status',             
	    		cct_dest        :'Payment Status',   
	    		cct_dest2      	:'Payment Status',     
	    		cct_3rd         :'Payment Status',            
	    		cct_3rd2        :'Payment Status',            
	    		obl_iss_rmk   	:'B/L Remark(s)'
															   
			}
	    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
var selectedGridCols;    
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
// var rowsPerPage = 50;
 var rowsPerPage = 99999;
 var ofc_flg = "N";
 var prefix = "sheet1_";//IBSheet 구분자
 var selectColList="";//Report 타입별 저장된 그리드 칼럼 목록
 var defaultSelectColList ="BL>BKG_NO|VIP>BL_NO";
 var arrMultiCombo;//멀티콤보 세팅할 변수
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	
	
/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
 			initComboEditable(comboObj, comboId)
 	}
 	 
 	  //콤보 멀티 셀렉트 및 수정 여부 초기 설정
 	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
		 	 		MultiSelect = false;
		 	 		UseAutoComplete = true; 
			 	  UseEdit = false;
			 	  if(comboId == "cust_tp_cd" ){
			 	  	DropHeight = 300; 
				 	  ColCnt =2;
				 	  ColBackColor(1) = "255,255,255";
			 	  }
	 	 	}
 	 } 	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }	
			  //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    
		    initControl();
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		    setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
//		    form.vvd_cd.focus();
		 		    
     }
	
	 	
	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm  ("change", "bkg_onChange",formObject);
    }        
    
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        //숫자 입력하기
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	          
	      default:
	    }
	}  
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
				break;
		}
	}  

	  /**
   * HTML Control의 change을 제어한다.
   **/
  function bkg_onChange() {
  	
  	var formObj = document.form;
	    switch (event.srcElement.getAttribute("name")) {
	    	case "b_ofc_cd_1":
	  			document.form.b_ofc_cd.value = document.form.b_ofc_cd_1.value;	 
	  			ofc_flg = "N";
	  			changeObjectColor("N", "Y", "btn_multi_ofc", "blue", "btn2");
				break;	    	   		
			default:
				break;
	    }
  }      
/*********************** KEY EVENT END ********************/
  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
					
					var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
						case "btn_dura_date":
		 					var cal = new ComCalendarFromTo();
							cal.select(formObject.dura_from_dt, formObject.dura_to_dt,'yyyy-MM-dd');
						 	break;		 				
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					ofc_flg = "N";
		 					break;
		 				case "btn_New":
		 					form.reset();
							form.cust_tp_cd.Text="";
							form.dura_opt.Code = "VE";
							changeObjectColor("N", "Y", "btn_multi_ofc", "blue", "btn2");
		 					break;
		 				case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				 case "bl_type_ori":
							if(form.bl_type_ori.checked){
								form.bl_type_way.checked = false;
								form.bl_type_web.checked = false;
							}
							break; 		
		 				 case "bl_type_way":
							if(form.bl_type_way.checked){
								form.bl_type_ori.checked = false;
								form.bl_type_web.checked = false;
							}
							break;
		 				case "bl_type_web":
							if(form.bl_type_web.checked){
								form.bl_type_way.checked = false;
								form.bl_type_ori.checked = false;
							}
							break;
		 				case "btn_multi_ofc":
//		 					bkgOfcListPopUp();
		 					comBkgCallPop1156('callBack1156', formObject.b_ofc_cd_1.value);
		 					break;
		 					
						case "btn_ReportTemplate": 		
	 						ComOpenPopup('/hanjin/ESM_BKG_0104.do?p_bkg_rpt_knd_cd=L', 820, 470, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
							break;	
//		 			    case "ofc_list_add":
//		 					sheetObjects[0].DataInsert(-1);
//		 					break;
//		 			    case "ofc_list_del":
//		 					if (sheetObjects[0].CheckedRows("slct_flg") != 0) {
//		 						var checkList = sheetObjects[0].FindCheckedRow("slct_flg");
//		 						var arrRow = checkList.split("|");
//		 						for (idx=arrRow.length-2; idx>=0; idx--){ 	
//		 							sheetObjects[0].RowDelete(arrRow[idx], false);
//		 						}
//		 					}
//		 					break;  
		        } // end switch
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e);
		    		}		     	
	     	}
	     	
	     	
    }
 
     
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 			case IBSEARCH:      //조회
 				if (ofc_flg == "N")
 					formObj.b_ofc_cd.value = formObj.b_ofc_cd_1.value;
 				if(!validateForm(sheetObj,formObj,sAction)) return;
//			 	debug.innerHTML=FormQueryString(formObj);
 				//alert(FormQueryString(formObj));
 				//break;
 				formObj.f_cmd.value = SEARCH;
 				formObj.rows_per_page.value = rowsPerPage;
 				formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
 				pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화

				sheetObj.RemoveAll();
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				var ColList = selectColList.substring(4);
				formObj.select_list.value = ColList.split("|BL>");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0647GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.WaitImageVisible = false;	
				sheetObj.Redraw = true;
				 
 				break;
 			case IBSEARCHAPPEND:  // 페이징 조회
				formObj.f_cmd.value = SEARCH;
                formObj.curr_page.value = PageNo;
                selectVal = FormQueryString(formObj);
                sheetObj.DoSearch4Post("ESM_BKG_0647GS.do", selectVal+ "&" + ComGetPrefixParam(prefix), "iPage=" + PageNo, true); 
           	break;  
           	
 			case SEARCH01:      //조회    			
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0647GS.do", FormQueryString(formObj));
				
				arrMultiCombo = sXml.split("|$$|");
				initAll(formObj);
				initReportType();
				setConditionAndInitSheet(tempform.report_type.Code);
				break;
				
			case IBDOWNEXCEL:   // 엑셀다운로드
//				sheetObj.Down2Excel();
				sheetObj.SpeedDown2Excel(-1);
				break;

 			case SEARCH02:      //Staff List 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH02;
				var p_ofc_cd ="";
				p_ofc_cd =formObj.b_ofc_cd.value;
				p_ofc_gubun ="BO";
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd+"&p_ofc_gubun="+p_ofc_gubun);
			
				 ComXml2ComboItem(sXml, formObj.b_staff_id, "usr_id", "usr_id");
				break;
		    }
     }
     
	 /**
      * 조회조건을 초기화<br>
      */      
 	function initAll(formObject){
 		var formObj = document.form;
		form.reset();
		/*CUSTOMER TYPE*/								
		ComXml2ComboItem(arrMultiCombo[0], formObj.cust_tp_cd, "val", "name");
		/*BL Status*/								
		ComXml2ComboItem(arrMultiCombo[1], formObj.bl_sts_cd, "val", "name");
		/*Duration*/								
		ComXml2ComboItem(arrMultiCombo[2], formObj.dura_opt, "val", "name");
		if(form.dura_opt.Code==""){
			form.dura_opt.Code = "VE";
		}
		changeObjectColor("N", "Y", "btn_multi_ofc", "blue", "btn2");
		ofc_flg = "N";
	} 
 	
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[3], tempform.report_type, "sql_ctnt_col_nm", "rpt_nm");
		var arr = ComBkgXml2Array(arrMultiCombo[3], "rpt_nm");
		tempform.report_type.Text2 = arr[0];
	}
	
	

	/** 
	 * condition setting and init Sheet
	 */ 
	function setConditionAndInitSheet(sqlCtnt){
	  	var arrSqlCtntColnm = sqlCtnt.URLDecode().split("@@");
	  	//alert(arrSqlCtntColnm.length);
	  	//return;
	  	var arrSqlCtnt = arrSqlCtntColnm[0].URLDecode().split("|");
	   	var formNameValue ; 
	  	var field;
	  	try{
		   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
	   			formNameValue = arrSqlCtnt[i].split("=");
	   			if(formNameValue[1] =="") continue;
	   			if(arrFormElementMap[formNameValue[0]] == "check"){
						eval("form."+formNameValue[0]).checked = true;
						
				}else if(arrFormElementMap[formNameValue[0]] == "radio"){
					field = eval("form."+formNameValue[0]);
						for(var j = 0; j < field.length; j++) {
							if(field[j].value == formNameValue[1]){
								field[j].checked = true;
								break;
							}
								
						}
						
				}else if(arrFormElementMap[formNameValue[0]] == "select"){
					field = eval("form."+formNameValue[0]);
						for(var j = 0; j < field.length; j++) {
							if(field[j].value == formNameValue[1]){
								field[j].selected = true;
								break;
							}
						}
						
				}else if(arrFormElementMap[formNameValue[0]] == "combo"){
					eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
				}else if(arrFormElementMap[formNameValue[0]] == "multi"){
					eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
				}
				else{
					field = eval("form."+formNameValue[0]);
					field.value=formNameValue[1];
//					if(field.name == "b_ofc_cd_1"){
//				  		doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','b_ofc_cd');
//					}else 
						
					if(field.name == "b_ofc_cd"){
						if(field.value!=null&&field.value!=""&&field.value.length>5){
							ofc_flg = "Y";
							changeObjectColor("Y", "Y", "btn_multi_ofc", "blue", "btn2");
						}
					}
//					else if(field.name == "l_ofc_cd"){
//						doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','l_ofc_cd');
//						doActionIBSheet(sheetObjects[1],document.form,SEARCH06);
//					}
	   			}
		   	}//end for
		   	
	  	}catch(e){}
	  	/*
	  	 * Report Type에 따라 Grid를 다시 그린다.
	  	 * */

	  	if(arrSqlCtntColnm.length > 1){
		  	selectColList = arrSqlCtntColnm[1];
		  	if(selectColList == "")
		  		selectColList = defaultSelectColList;
		  	initSheetDynamic(sheetObjects[0],selectColList);
	  	}else{
		  	selectColList = defaultSelectColList;
		  	initSheetDynamic(sheetObjects[0],selectColList); 
	  	}  	
	}
	
     
	 /**
     * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
     */ 
	  function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
	     //alert("PageNo:"+PageNo+"  "+OnePageRows);
	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
	  }        


     /*
      *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
      * 초기값은 쉬트 헤더 개수
      */ 
      var pagedMaxCnt=2; 
			/**
       * 조회후  이벤트 처리 >>> 폰트 칼라변경
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 with (sheetObj) {
    		 var blueColor = RgbColor(0,0,255);
    		 
    		 for (var i = pagedMaxCnt; i <= LastRow ; i++){
    			 sheetObj.CellFontColor(i,prefix+"bkg_no") = blueColor;
    		 	 sheetObj.CellFontUnderline(i,prefix+"bkg_no") = true;
    		 	 sheetObj.CellFontColor(i,prefix+"bl_no") = blueColor;
    		 	 sheetObj.CellFontUnderline(i,prefix+"bl_no") = true;
    		 }
    	 }
     }
     
     function setCelColor(flag, obj,idx,celName,color){
     	if(flag =="N")
     			obj.CellFontColor(idx,celName) = color;
     }
   
			/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
				if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
//					var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no");
//					ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
					//	모달로 변경 2010.04.10
//					comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, prefix+"bkg_no"));
					var param= "?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no") + "&bl_tp_cd=W";
					ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,true,"scrollbars=no,resizable=yes");

				}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
//					var param= "?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no") + "&bl_tp_cd=W";
//					ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,true,"scrollbars=no,resizable=yes");
//					comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, prefix+"bkg_no"));
//			    	var sUrl  = "ESM_BKG_0079_Q.do?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no")+"&ui_id="+"7";
//			    	ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, true, "yes");
		         	var popParams = "bkg_no=" + sheetObj.CellValue(rowIdx, prefix+"bkg_no") + "&openTab=B9";
    	        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0647", popParams, "");
				}
		 }
     
     
     /**
 	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
 	 * 입력값을 upper로 변경하여 재등록 한다.
 	 * @param comboObj
 	 * @return
 	 */
 	function report_type_OnChange(comboObj) {
// 		id_sheet1.style.display = "none";
 		initAll(document.form);
 		setConditionAndInitSheet(comboObj.Code);
 		//쉬트 헤드를 초기화 시 스크롤이 보였다 안보였다 하는데 이를 회피하기 위해 헤더 생성 후 쉬트를 전시한다. 
 		//setTimeout(function () { setConditionAndInitSheet(comboObj.Code);},100);
 		 
 	}
 	function dura_opt_OnChange(comboObj) {
 	 	if(comboObj.Code == "BP"){
 	 		document.getElementById("vvd_cd").className = "input";
 	 		document.getElementById("cust_cnt_cd").className = "input1";
 	 		document.getElementById("cust_seq").className = "input1";
 	 	}else{
 	 		document.getElementById("vvd_cd").className = "input1";
 	 		document.getElementById("cust_cnt_cd").className = "input";
 	 		document.getElementById("cust_seq").className = "input";
 	 	}

 	}
 	

     /**  
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */ 
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:

    			if(formObj.dura_opt.Code==''){
  					ComShowCodeMessage('BKG00445','Duration Type');
  					return false;
    			}
	    		if (ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.dura_from_dt) && ComIsNull(formObj.dura_to_dt))&& ComIsNull(formObj.bkg_bl_no)) {
     					ComShowCodeMessage('BKG00227');
     					formObj.vvd_cd.focus();
     					return false;
		  		}
	    		if (formObj.vvd_cd.value !='' && formObj.vvd_cd.value.length != 9) {
     					ComShowCodeMessage('BKG00538');
     					formObj.vvd_cd.focus();
     					return false;
		  		}
	  			if(form.dura_opt.Code == "BP"){
	  				if(ComIsNull(formObj.cust_seq)||ComIsNull(formObj.cust_cnt_cd)){
	  					ComShowCodeMessage('BKG00445','Customer Code');
	  					return false;
	  				}
	  			}else{
			  		if (ComIsNull(formObj.por_cd) && ComIsNull(formObj.pol_cd) 
							  && ComIsNull(formObj.pod_cd) 
							  && ComIsNull(formObj.del_cd) 
							  && ComIsNull(formObj.del_ofc_cd)
							  && ComIsNull(formObj.obl_ofc_cd)
							  && ComIsNull(formObj.sal_ofc_cd)
							  && ComIsNull(formObj.bl_ofc_cd)
							  && ComIsNull(formObj.obl_rcv_ofc_cd)
							  && ComIsNull(formObj.b_ofc_cd)
							  && ComIsNull(formObj.bkg_bl_no)
							  && ComIsNull(formObj.staff_id)) {

						if(formObj.n3pty_ofc_cd.value==""){
							ComShowCodeMessage('BKG00626','POR or POL or POD or DEL or Control Ofc or Booking Ofc or Sales Ofc or BL Issue Ofc or OBL Receive Ofc or User ID(By)');
							formObj.pol_cd.focus();
							return false;
						}
					
					
					}
	  			}

		  		
					
	  			break;
    	 }
         return true;
     }
     
    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,ColList) {
        var cnt = 0;
        id_sheet1.style.display = "none";
        switch(sheetObj.id) {
           case "sheet1":
           	//Report Type을 조회한 후 초기화 함.
						break;
        }
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheetDynamic(sheetObj,ColList) {
    	sheetObj.RemoveAll();
    	sheetObj.Reset();
        var cnt = 0;
       	selectedGridCols = new Array();//초기화
       	with (sheetObj) {
		           style.height = 335;
		           
		           //전체 너비 설정
		           SheetWidth = mainTable.clientWidth;
		
		           //Host정보 설정[필수][HostIp, Port, PagePath]
		           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		           //전체Merge 종류 [선택, Default msNone]
		           MergeSheet = msHeaderOnly;
		
		          //전체Edit 허용 여부 [선택, Default false]
		           Editable = false;
		           var HeadTitle = "no";
		           var HeadTitle1 = "no";
					var arrColList = ColList.split("|");
					var tempName="";
					var tempCnt=0;
					for(var index=0; index < arrColList.length; index++) {
						  if(arrColList[0] == ""){
						  	continue;
						  }
							tempName = arrColList[index].split(">")[1].toLowerCase();
							//alert(tempName);
							if(arrGridColsTitle[tempName] == undefined) {
								continue;
							}
								HeadTitle += "|"+ arrGridColsTitle1[tempName]; //선택된 컬럼 헤더생성
								HeadTitle1 += "|"+ arrGridColsTitle[tempName]; //선택된 컬럼 헤더생성
								
							selectedGridCols[tempName]= "Y";//선택된 그리드 칼럼-나머지 헤더 및 속성 정의시 제외
							//debug.innerHTML += "<br>"+tempName;
							tempCnt++;
					}
					
//									debug.innerHTML=selectedGridCols.join("|");
			//		debug.innerHTML=selectedGridCols.join("|");
					//alert(arrColList.join());
					for (var key in arrGridColsTitle){ //선택된헤더 컬럼 외 나머지 컬럼 헤더 생성
						if(selectedGridCols[key] != undefined) {
								continue;
						}
						HeadTitle += "|"+ arrGridColsTitle1[key];
						HeadTitle1 += "|"+ arrGridColsTitle[key];
					}
		
			          var headCount = ComCountHeadTitle(HeadTitle1);
			
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 1, rowsPerPage);
											
			          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			          InitColumnInfo(headCount, 0, 0, true);
			
			          // 해더에서 처리할 수 있는 각종 기능을 설정한다
			          //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			          InitHeadMode(true, true, true, true, false,false)
			
			          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			          InitHeadRow(0, HeadTitle, true);
			          InitHeadRow(1, HeadTitle1, true);

								
								InitDataProperty(0,		cnt++ , dtDataSeq,					30,		daCenter,		true,		prefix + "no" );								
								for (var key in selectedGridCols){ //선택된 헤더 컬럼  속성 세팅
									if(arrGridColsProp[key] == undefined) {
											continue;
									}
									eval(arrGridColsProp[key]);
									//debug.innerHTML += "<br>"+ arrGridColsProp[key];
								}
								for (var key in arrGridColsProp){ //선택된 헤더 컬럼 외 나머지 컬럼 헤더 속성 세팅
									if(selectedGridCols[key] != undefined) {
											continue;
									}
									
									eval(arrGridColsProp[key]);
									//debug.innerHTML += "<br>"+ arrGridColsProp[key];
									ColHidden(prefix + key) = true;
									//debug.innerHTML += "<br>"+cnt+ ColSaveName(cnt-1)+" - "+prefix + key;
								}
			
							CountPosition = 0;
						}//end width        	
       					id_sheet1.style.display = "";// 헤더 생성 후 쉬트 전시함 
       	
    }    
// /**
//      * 시트 초기설정값, 헤더 정의
//      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
//      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
//      */
//     function initSheet(sheetObj,sheetNo) {
//         var cnt = 0;
//         switch(sheetObj.id) {
//
//            case "sheet1":
//              with (sheetObj) {
//                 // 높이 설정
//                 style.height = 362;
//                 
//                 //전체 너비 설정
//                 SheetWidth = mainTable.clientWidth;
//
//                 //Host정보 설정[필수][HostIp, Port, PagePath]
//                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                 //전체Merge 종류 [선택, Default msNone]
//                 MergeSheet = msHeaderOnly;
//
//                //전체Edit 허용 여부 [선택, Default false]
//                 Editable = false;
//
//				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//				InitRowInfo(2, 1, 1, rowsPerPage);
//
//				var HeadTitle1 = "  |no|Booking No.\n[BL Print]|B/L No.\n[BL Issue]|POR|POL|POD|DEL|BKG OFC|DEL OFC|On Board|On Board|Issue & Release|Issue & Release|Issue & Release|Issue & Release|Issue & Release|Issue & Release|Issue & Release|OBL Receive or Surrender|OBL Receive or Surrender|OBL Receive or Surrender|OBL Receive or Surrender|OBL Receive or Surrender";
//						HeadTitle1 += "|B/L Data Input|B/L Data Input|B/L Data Input|B/L Data Input|B/L Data Input|B/L Data Input|VVD|Shipper|Forwarder|Consignee|Sales Office|Sales Rep|S/C or RFA|Payment Term|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|B/L Remark(s)";
//				var HeadTitle2 = "  |no|Booking No.\n[BL Print]|B/L No.\n[BL Issue]|POR|POL|POD|DEL|BKG OFC|DEL OFC|Type|Date|B/L Type|Issue|Print|Release|Office|Date|By|Office|Date|No|Surrender|D/O";
//						HeadTitle2 += "|S/R|Complete|B/L Type|Confirm|Office|By|VVD|Shipper|Forwarder|Consignee|Sales Office|Sales Rep|S/C or RFA|Payment Term|PPD (Org)|PPD (Org)|PPD (3rd)|PPD (3rd)|CCT (Dest)|CCT (Dest)|CCT (3rd)|CCT (3rd)|B/L Remark(s)";
//                 
//                var headCount = ComCountHeadTitle(HeadTitle1);
//
//                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                InitColumnInfo(headCount, 4, 0, true);
//
//                // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
//                InitHeadMode(true, true, true, true, false,false)
//
//                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                InitHeadRow(0, HeadTitle1, true);
//                InitHeadRow(1, HeadTitle2, true);
//                
//                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			 					
//				InitDataProperty(0,		cnt++ , dtHiddenStatus,			60,		daCenter,		true,		"hdnStatus");
//				//InitDataProperty(0,		cnt++ , dtCheckBox,		  		30,		daCenter,		true,		prefix + "Check",							false,		"",		dfNone,					0,		true,		true);
//				InitDataProperty(0,		cnt++ , dtDataSeq,				30,		daCenter,		true,		prefix + "Seq");
//				InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		prefix + "bkg_no",        	false,		"",		dfNone,					0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		prefix + "bl_no",         	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "por_cd",        	false,		"",		dfNone,					0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "pol_cd",        	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "pod_cd",        	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "del_cd",        	false,		"",		dfNone,					0,		false,	true);						
//				InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + "bkg_ofc",       	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + "del_ofc",       	false,		"",		dfNone,					0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "ob_type",       	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + "ob_date",       	false,		"",		dfDateYmd,				0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + "ir_bl_type",     	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + "bl_issued",       false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + "bl_print",        false,		"",		dfNone,					0,		false,	true);
//				
//				InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		prefix + "bl_released",     false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "ir_office",     	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + "ir_date",       	false,		"",		dfDateYmd,				0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "ir_by",         	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "ors_office",    	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + "ors_date",      	false,		"",		dfDateYmd,				0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					30,		daCenter,		true,		prefix + "ors_no",        	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + "ors_surrender", 	false,		"",		dfNone,					0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "ors_do",        	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "bdi_sr",        	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + "bdi_complete",  	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + "bdi_type",  		false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					65,		daCenter,		true,		prefix + "bdi_confirm",  	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "bdi_office",    	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		prefix + "bdi_by",        	false,		"",		dfNone,					0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		prefix + "vvd_cd",        	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daLeft,			true,		prefix + "shipper",       	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daLeft,			true,		prefix + "fowarder",     	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daLeft,			true,		prefix + "consignee",     	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + "sales_office",   	false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + "sales_rep",      	false,		"",		dfNone,					0,		false,	true);
//																																								                          
//				InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		true,		prefix + "sc_rfa_no",       false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		prefix + "pay_term_cd",     false,		"",		dfNone,					0,		false,	true);
//				
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "ppd_org",         false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + "ppd_org2",        false,		"",		dfNone,					0,		false,	true);
//				
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "ppd_3rd",         false,		"",		dfNone,		      		0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + "ppd_3rd2",        false,		"",		dfNone,		      		0,		false,	true);
//				
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "cct_dest",        false,		"",		dfNone,					0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + "cct_dest2",       false,		"",		dfNone,					0,		false,	true);
//				
//				InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,		prefix + "cct_3rd",         false,		"",		dfNone,		      		0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + "cct_3rd2",        false,		"",		dfNone,		      		0,		false,	true);
//				InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		prefix + "obl_iss_rmk",     false,		"",		dfNone,		      		0,		false,	true);
//				
//				CountPosition = 0;
// 				}
// 				
// 				break;
//
//         
//         }
//     }
     function setSchKey(val){ // Radio Click 시 data clear
    	 var formObj = document.form;
    	 
    	 if (val == "BKG"){
    		 
    		 formObj.vvd_cd.value ="";
    		 formObj.pol_cd.value ="";
    	 }
    	 if (val == "BL"){

    		 formObj.vvd_cd.value ="";
    		 formObj.pol_cd.value ="";
    	 }
    	 
     }


     function comBkgCallPop1156(callback_func, bkg_ofc) {
    		var param = "?bkg_ofc=" + bkg_ofc;
    		ComOpenPopup('ESM_BKG_1156.do' + param, 230, 345, callback_func, "0,1,1,1,1", true);
    	}
     
     function callBack1156(rArray) {
    		var formObj = document.form;
    		var bkgOfcList = "";
     		for(i = 0 ; i < rArray.length ; i++){
     			if(rArray[i][0] != "D"){
	     			bkgOfcList = bkgOfcList + ',' + rArray[i][2];    				
     			}
     		} 
     		
     		if(bkgOfcList.substring(0,1) == ",")
     			bkgOfcList = bkgOfcList.substring(1);
     		if(bkgOfcList != "")
     			changeObjectColor("Y", "Y", "btn_multi_ofc", "blue", "btn2");	 
     		
     		formObj.b_ofc_cd.value = bkgOfcList;
     		formObj.b_ofc_cd_1.value = rArray[0][2];
     		ofc_flg = "Y";
    	}

	/* 개발자 작업  끝 */    