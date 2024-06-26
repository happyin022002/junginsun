﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1126.js
*@FileTitle : Europe Advanced Manifest - ENS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
* 2011.01.17 김경섭 [CHM-201005134-01] [ESM-BKG] ENS Report: POFE 입력 처리, Grid 에 항목별 Sort
* 2011.04.08 김경섭 [CHM-201005134-01] [ESM-BKG] ENS Report: POFE 체크로직 수정
* 2011.04.14 김경섭 [CHM-201109994-01] [ESM-BKG] ENS Report: 엑셀다운시 CNTR NO별 분리(Download용 sheet추가 및 복제),POFE 체크로직 수정
* 2012.09.04 김보배 [CHM-201220027] [BKG] [EXS 신고화면 및 레포트화면] Released 추가 (조회조건 Status/ Summary 합계)
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
     * @class ESM_BKG_1126 : ESM_BKG_1126 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1126() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    }
    
   	/* 개발자 작업	*/

    
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var comboObjects = new Array();
    var comboCnt = 0;
	
    //전역변수
    var intervalId = "";

    
    /**
     * 시트를 클릭했을 때 처리 0127참조
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	
        var colSaveName = sheetObj.ColSaveName(col);
        switch(colSaveName) {
	    	case "cntrs":
	    		 //ComShowMemoPad(sheetObj, row, "cntrs", true, 150, 100);	//편집불가능
			       break;
        } // end switch
        
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
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
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
    	var formObj = document.form;
    	
		for(i=0;i<sheetObjects.length;i++){
	        //시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
	        //마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		  //MultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    
	    
		ComBtnDisable("btn_BLAdd");
		ComBtnDisable("btn_BLDelete");
		//ComBtnDisable("btn_Transmit");
		
		//화면에서 필요한 이벤트
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,SEARCH05);

	}
    
     function initControl() {
     	var formObject = document.form;
     	
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
    
     }
     
  	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
  	* @param {String} comboId 필수,combo ID
  	* @return 없음. 
   	 */ 
   	function initCombo(comboObj, comboId) {
   	    var formObject = document.form
  			initComboEditable(comboObj, comboId)
   	}
   	
 	/** 
 	* 콤보 멀티 셀렉트 및 수정 여부 초기 설정 <br> 
 	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 	* @param {String} comboId 필수,combo ID
 	* @return 없음.
 	*/ 
  	
 	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "p_pol_cd_temp" ){
	 			MultiSelect = false;
	 			UseEdit = true;
	 			BackColor = "#CCFFFD";
	 			ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	 		}
 		}
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
	        //영문,숫자,공백,기타문자(.,등)
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
	      break;
	    }
	}  
	
	
	var preVvd;//이전에 조회했던 VVD에서 Focus Out 되면 재조회 하지 않는다.
	var prePodCd;
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_vvd_cd":
//	    		if(preVvd == formObj.p_vvd_cd.value) {
//	    			formObj.p_pod_cd.value = prePodCd;
//	    		}else{
//		    		preVvd = formObj.p_vvd_cd.value;
//		    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
//	    		}
//	    		formObj.p_pol_cd.focus();
				break;
				
	    	case "p_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }           

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "p_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}       
    
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function bkg_change(){
    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_vvd":
	    		sheetObjects[2].RemoveAll();
	    		

	    		form.p_pol_cd_temp.RemoveAll();
	    		form.p_pol_cd_temp.Text2 = "";
	    		form.p_pol_yd.value = "";
	   	 		//form.p_search_pofe_yard_cd.value = "";
	    		
	    		
//	    		form.p_pofe_yd_temp.RemoveAll();
//	    		form.p_pofe_yd_temp.Text2 = "";
//	    		form.p_pofe_yd.value = "";
//	   	 		form.p_search_pofe_yard_cd.value = "";
	   	 		
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	    		if(form.p_pol_cd_temp.GetCount() >= 1 ){
	    			form.p_pol_cd_temp.Index = 0;
	    		}
	    		if(form.p_pol_cd_temp.GetCount() >= 1 ){
	    			form.p_pol_cd_temp.Index = 0;
	    		}
	    		form.p_b_ofc_cd.focus();
				break;
			default:
				break;
	    }
    }

	/**
	 * Trans Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
//	function p_pofe_yd_temp_OnChange(comboObj, value, text){
//		
//		if(text.indexOf("(") < 0 && (text.length < 5 || text.length > 7)){
//			ComShowCodeMessage('BKG06065','POFE(5~7 Digits)');
//			//form.p_pofe_yd.value = "";
//			//form.p_search_pofe_yard_cd.value = ""; 
//			//form.p_pofe_yd_temp.focus();
//			return;
//		}
///*		// 사용자 입력값을 uppercase로 변경  
//   	 	var comboText =  text.toUpperCase();
//   	 	 
//   	 	// 선택 또는 입력한  값이 콤보에 있으면 
//   	 	if (sheetObjects[2].FindText('eu_1st_port_name',comboText) != -1) { 
//   	 		form.p_pofe_yd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port_name',comboText),"eu_1st_port_yd_cd");
//   	 		form.p_search_pofe_yard_cd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port_name',comboText),"search_eu_1st_port_yd_cd");
//   	 	}else{
//   	 	    form.p_pofe_yd.value = comboText;
//   	 	    form.p_search_pofe_yard_cd.value = comboText;
//   	 	}
//   	 	//alert(form.p_pofe_yd.value);
// */
//   	 	
//	}        
    

     
     /**
      * Booking Creation 화면 이동
      * @param sheetObj Sheet
      * @param Row Row Index
      * @param Col Col Index
      */
     function sheet1_OnDblClick(sheetObj, row, col) {
	        var colSaveName = sheetObj.ColSaveName(col);
	        switch(colSaveName) {
	        	case "bl_no" :
	        		ComBkgCall0079(sheetObj.CellValue(row, "bkg_no"));
		    	break;
	        } // end switch
     	
     }	    
     
     
     /**
      * 조회후  이벤트 처리 >>> 폰트 칼라변경
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {
       
             var redColor  = RgbColor(255, 0, 0);
             for(var i= HeaderRows; i<= LastRow; i++) {
	                if (CellValue(i,"result2") == "DNL" || CellValue(i,"result2") == "R" || CellValue(i,"result2") == "D" || CellValue(i,"result2") == "P" || CellValue(i,"result2") == "H") {
	                	CellFontColor(i,"result") = redColor;
	                }
	                
             }
         }//end width
     }	     
	    
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
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_New":
 					formObject.reset();
 					sheetObject1.RemoveAll();
 					formObject.p_pol_cd_temp.RemoveAll();
 					formObject.p_pol_cd_temp.Text    = "";
					form.div_total_bl_cnt.value      = "";
					form.div_sent_bl_cnt.value       = "";
					form.div_unsent_bl_cnt.value     = "";
					form.div_sent_bl_cnt2.value      = "";
					form.div_a_cnt.value             = "";
					form.div_r_cnt.value             = "";
					form.div_dnl_cnt.value           = "";
					form.div_h_cnt.value             = "";
					form.div_nr_cnt.value            = "";
					
 					break;
 				case "btn_DownExcel":
 					
 					ComOpenWait(true);
 					var sheetDownload = sheetObjects[3];
 			        setTimeout(function(){getDownload(sheetObject1,sheetDownload);},500);

 					break;
 				case "btn_Inquiry":
 	  	            
	 			      var row = sheetObject1.SelectRow;
	 			      var p_bl_no 		   = sheetObject1.CellValue(row, "bl_no");
		            
	 			      ComOpenWindowCenter("/hanjin/ESM_BKG_1124.do?pgmNo=ESM_BKG_1124&bl_no=" + p_bl_no, "1124", 1040, 700, false);
	 			      break; 
 				case "btn_History":
 	 			      var row = sheetObject1.SelectRow;
 	 			      var p_vvd = sheetObject1.CellValue(row, "vvd");
 	 			      var p_cstms_port_cd = sheetObject1.CellValue(row, "pol");
 	 			      var p_bl_no 		   = sheetObject1.CellValue(row, "bl_no");
 	 			       
 	 			      ComOpenWindowCenter("/hanjin/ESM_BKG_1127.do?pgmNo=ESM_BKG_1127&p_vvd=" + p_vvd + "&p_cstms_port_cd=" + p_cstms_port_cd+ "&p_bl_no=" + p_bl_no, "1113", 900, 500, false);
 	 			      break;     
 			    case "btn_viewMsg":
 			      var row = sheetObject1.SelectRow;
 			      if (ComIsNull(sheetObject1.CellValue(row,"ack"))) {
 	    				ComShowCodeMessage('BKG00442');
 	 					return;    
 			      }
 			      
 			       var edi_rcv_dt = sheetObject1.CellValue(row, "edi_rcv_dt");
 			       var edi_rcv_seq = sheetObject1.CellValue(row, "edi_rcv_seq");
 			       var cnt_cd = sheetObject1.CellValue(row, "pofe").substring(0,2);
 			       
 			       ComOpenWindowCenter("/hanjin/ESM_BKG_1128.do?pgmNo=ESM_BKG_1128&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1104", 540, 600, false);
 			       break;   
 				case "btn_date":	
 					var cal = new ComCalendarFromTo();
 					cal.setEndFunction("endDateSet");
					cal.select(formObject.p_from_dt, formObject.p_to_dt,'yyyy-MM-dd');
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
  * DownExcel시 wait 창이 바로 뜨질 않아 setTimeout함수를 호출해서 작업한다.
  * @param sheetObj sheetObject1
  * @param sheetObj sheetDownload
  */   
function getDownload(sheetObject1,sheetDownload){
	sheetDownload.RemoveAll();
	 with (sheetObject1) {
     	 var arrCntr;
     	 var Row ;
          for(var i= HeaderRows; i<= LastRow; i++) {
         	arrCntr = CellValue(i,"cntrs").split("\n");
         	for( var j = 0; j< arrCntr.length; j++){
         		Row = sheetDownload.DataInsert(-1);
         		sheetDownload.CellValue2(Row, "seq")              = getNull(CellValue(i, "seq")                ," ");
         		sheetDownload.CellValue2(Row, "vvd")              = getNull(CellValue(i, "vvd")                ," ");
         		sheetDownload.CellValue2(Row, "lane")             = getNull(CellValue(i, "lane")               ," ");
         		sheetDownload.CellValue2(Row, "bpol")             = getNull(CellValue(i, "bpol")               ," ");
         		sheetDownload.CellValue2(Row, "bpol_yd")          = getNull(CellValue(i, "bpol_yd")			   ," ");
         		sheetDownload.CellValue2(Row, "pol")              = getNull(CellValue(i, "pol")                ," ");
         		sheetDownload.CellValue2(Row, "pol_yd")           = getNull(CellValue(i, "pol_yd")             ," ");
         		sheetDownload.CellValue2(Row, "pofe")             = getNull(CellValue(i, "pofe")               ," ");
         		sheetDownload.CellValue2(Row, "pofe_yd")          = getNull(CellValue(i, "pofe_yd")            ," ");
         		sheetDownload.CellValue2(Row, "bl_no")            = getNull(CellValue(i, "bl_no")              ," ");
         		sheetDownload.CellValue2(Row, "bkg_sts_cd")       = getNull(CellValue(i, "bkg_sts_cd")         ," ");
         		sheetDownload.CellValue2(Row, "pod")              = getNull(CellValue(i, "pod")                ," ");
         		sheetDownload.CellValue2(Row, "pod_yd")           = getNull(CellValue(i, "pod_yd")             ," ");
         		sheetDownload.CellValue2(Row, "del")              = getNull(CellValue(i, "del")                ," ");
         		sheetDownload.CellValue2(Row, "cntrs")            = arrCntr[j];
         		sheetDownload.CellValue2(Row, "ct")               = getNull(CellValue(i, "ct")                 ," ");
         		sheetDownload.CellValue2(Row, "sent_type")        = getNull(CellValue(i, "sent_type")          ," ");
         		sheetDownload.CellValue2(Row, "ack")              = getNull(CellValue(i, "ack")                ," ");
         		sheetDownload.CellValue2(Row, "result")           = getNull(CellValue(i, "result")             ," ");
         		sheetDownload.CellValue2(Row, "mrn_no")           = getNull(CellValue(i, "mrn_no")             ," ");
         		sheetDownload.CellValue2(Row, "ens_send_gmt_dt")  = getNull(CellValue(i, "ens_send_gmt_dt")    ," ");
         		sheetDownload.CellValue2(Row, "ens_send_dt")      = getNull(CellValue(i, "ens_send_dt")        ," ");
         		sheetDownload.CellValue2(Row, "ack_rcv_gmt_dt")   = getNull(CellValue(i, "ack_rcv_gmt_dt")     ," ");
         		sheetDownload.CellValue2(Row, "ack_rcv_dt")       = getNull(CellValue(i, "ack_rcv_dt")         ," ");
         		sheetDownload.CellValue2(Row, "edi_rcv_dt")       = getNull(CellValue(i, "edi_rcv_dt")         ," ");
         		sheetDownload.CellValue2(Row, "edi_rcv_seq")      = getNull(CellValue(i, "edi_rcv_seq")        ," ");
         		sheetDownload.CellValue2(Row, "bkg_no")           = getNull(CellValue(i, "bkg_no")             ," ");
         		sheetDownload.CellValue2(Row, "result2")          = getNull(CellValue(i, "result2")            ," ");;	

         	}
            
          }
     
       }//end width
      
//		sheetDownload.SpeedDown2Excel(-1);
		sheetDownload.Down2Excel(-1);
		ComOpenWait(false);
	
}     
     function getNull(src,nullToStr){
    	 if(src == null || src == ""){
    		 return (nullToStr == null ? "":nullToStr)
    	 }
    	 
    	return src;
     }

	 function endDateSet(){
		 if (ComIsNull(form.p_from_mt)) {
			form.p_from_mt.value ="00:00";
		 }
		 if (ComIsNull(form.p_to_mt)) {
			 form.p_to_mt.value ="23:59";
		 }
	  }
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
			
				var bl_sc_no = 0;
				if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_vvd)) {
					sheetObj.Redraw = false;    
					sheetObj.WaitImageVisible = true;
					
					formObj.f_cmd.value = SEARCH04;
					var pofeXml =  sheetObj.GetSearchXml("ESM_BKG_1121GS.do", FormQueryString(formObj));
					
					var vvd_cnt = ComGetEtcData(pofeXml,"vvd_cnt");
					var pol_cnt = ComGetEtcData(pofeXml,"pol_cnt");
					var temp_pol = ComGetEtcData(pofeXml,"pol");//bl로 조회한 pol
					formObj.p_vvd.value      = ComGetEtcData(pofeXml,"vvd");
					formObj.p_pol.value      = ComGetEtcData(pofeXml,"pod");
					
					doActionIBSheet(sheetObj, formObj, SEARCH01);
					
					//EU POL list
					doActionIBSheet(sheetObj, formObj, SEARCH02);
					if(eval(vvd_cnt) > 1){
						ComShowCodeMessage('BKG95001','BL이 2개이상 VVD를 가지고 있습니다. 직접 입력해주세요.');
						sheetObj.Redraw = true;
						sheetObj.WaitImageVisible = false;
						return;
					}
					
					if(formObj.p_pol_cd_temp.GetCount() == 1){
						formObj.p_pol_cd_temp.Index = 0;
					}else if(formObj.p_pol_cd_temp.GetCount() > 1){
						//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
			    		formObj.p_pol_cd_temp.Index = 0;
			    		formObj.p_pol_cd_temp.Text = temp_pol;
			    		formObj.p_pol_cd_temp.focus();
			    		//ComShowCodeMessage('BKG95001','select a POL');
						sheetObj.Redraw = true;
						sheetObj.WaitImageVisible = false;
						bl_sc_no = 1;
			    		//return;
					}else{
						ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
						sheetObj.Redraw = true;
						sheetObj.WaitImageVisible = false;
						return;
		    		}
		    		
	    		}
				
				// 사용자 입력값을 uppercase로 변경  
				var comboText =  formObj.p_pol_cd_temp.Text.toUpperCase();
				
				// 선택 또는 입력한  값이 콤보에 있으면
				if (sheetObjects[2].FindText('eu_1st_port',comboText) != -1) { 
					form.p_pol_yd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port',comboText),"eu_1st_port_yd_cd").substring(5);

				}else{
					form.p_pol_yd.value = comboText;

				}
				
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				
				formObj.f_cmd.value = SEARCH;
//				formObj.p_pol.value = ComGetObjValue(formObj.p_pol_cd_temp);
				formObj.p_pol.value = formObj.p_pol_cd_temp.Text;
				sheetObj.RemoveAll();
				
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1126GS.do", FormQueryString(formObj));
					
				sheetObj.LoadSearchXml(sXml);
				
				if(ComGetEtcData(sXml,"total_bl_cnt") == undefined){
					formObj.div_total_bl_cnt.value      = "0";
					formObj.div_sent_bl_cnt.value       = "0";
					formObj.div_unsent_bl_cnt.value     = "0";
					formObj.div_sent_bl_cnt2.value      = "0";
					formObj.div_a_cnt.value             = "0";
					formObj.div_r_cnt.value             = "0";
					formObj.div_dnl_cnt.value           = "0";
					formObj.div_h_cnt.value 	        = "0";
					formObj.div_l_cnt.value				= "0";
					formObj.div_nr_cnt.value            = "0";
				}else{
					formObj.div_total_bl_cnt.value      = ComGetEtcData(sXml,"total_bl_cnt");
					formObj.div_sent_bl_cnt.value       = ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_unsent_bl_cnt.value     = ComGetEtcData(sXml,"unsent_bl_cnt");
					formObj.div_sent_bl_cnt2.value      = ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_a_cnt.value             = ComGetEtcData(sXml,"a_cnt");
					formObj.div_r_cnt.value             = ComGetEtcData(sXml,"r_cnt");
					formObj.div_dnl_cnt.value           = ComGetEtcData(sXml,"dnl_cnt");
					formObj.div_h_cnt.value           	= ComGetEtcData(sXml,"h_cnt");
					formObj.div_l_cnt.value           	= ComGetEtcData(sXml,"l_cnt");
					formObj.div_nr_cnt.value            = ComGetEtcData(sXml,"nr_cnt");
				}
				
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
				if(bl_sc_no == 1 && sheetObj.RowCount < 1){
					ComShowCodeMessage('BKG95001','select a POL');
				}
			
				break;
			case SEARCH01 : // lane 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1126GS.do", FormQueryString(formObj));
				formObj.p_lane.value = ComGetEtcData(sXml,"p_lane");
				break;
			case SEARCH02 : // eu pol port 조회
				
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				
				formObj.f_cmd.value = SEARCH01;
				
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1121GS.do", FormQueryString(formObj)+"&p_vvd_cd="+formObj.p_vvd.value);
				
				ComXml2ComboItem(sXml, formObj.p_pol_cd_temp, "eu_1st_port_yd_cd", "eu_1st_port_yd_cd");
				sheetObjects[2].LoadSearchXml(sXml);
				
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
					
				break;
			case SEARCH05 : // eu 국가 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				
				
				sheetObjects[1].Redraw = false;    
				sheetObjects[1].WaitImageVisible = true;
				
				formObj.f_cmd.value = SEARCH05;
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1106GS.do", FormQueryString(formObj));
				sheetObjects[1].LoadSearchXml(sXml);
				sheetObjects[1].Redraw = true;
				sheetObjects[1].WaitImageVisible = false;
				
				break;
				
        }//end switch
    }
    

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
	    switch(sAction) {
	    	case IBSEARCH:
	    		

	    		if (!ComIsNull(formObj.p_from_mt)) {
    				var from_mt_temp="";
    				var arr_mt = formObj.p_from_mt.value.split(":")
    				if(ComIsNull(arr_mt[0])){
    					from_mt_temp ="00:";
    				}else{
    					if(eval(arr_mt[0])> 23 ) from_mt_temp ="23:";
    					else from_mt_temp = eval(arr_mt[0])< 10 ? "0"+eval(arr_mt[0])+":":arr_mt[0]+":";
    				}
    				
    				if(ComIsNull(arr_mt[1])){
    					from_mt_temp +="00";
    				}else{
    					if(eval(arr_mt[1])> 59 ) from_mt_temp +="59";
    					else from_mt_temp += eval(arr_mt[1])< 10 ? "0"+eval(arr_mt[1]):arr_mt[1];
    				}
    				
    				formObj.p_from_mt.value = from_mt_temp;
    			}
    				
    			if (!ComIsNull(formObj.p_to_mt)) {
    				var to_mt_temp="";
    				var arr_mt2 = formObj.p_to_mt.value.split(":")
    				if(ComIsNull(arr_mt2[0])){
    					to_mt_temp ="00:";
    				}else{
    					if(eval(arr_mt2[0])> 23 ) to_mt_temp ="23:";
    					else to_mt_temp = eval(arr_mt2[0])< 10 ? "0"+eval(arr_mt2[0])+":":arr_mt2[0]+":";
    				}
    				
    				if(ComIsNull(arr_mt2[1])){
    					to_mt_temp +="00";
    				}else{
    					if(eval(arr_mt2[1])> 59 ) to_mt_temp +="59";
    					else to_mt_temp += eval(arr_mt2[1])< 10 ? "0"+eval(arr_mt2[1]):arr_mt2[1];
    				}
    				
    				formObj.p_to_mt.value = to_mt_temp;
    			}
	    		/*
    			if(form.p_pofe_yd_temp.Text != "" && 
    					(form.p_pofe_yd_temp.Text.length < 5 || form.p_pofe_yd_temp.Text.length > 7) ){
    				if(form.p_pofe_yd_temp.Text.indexOf("(") < 0){
	    				ComShowCodeMessage('BKG06065','POFE(5~7 Digits)');
	    				return false;
    				}
    			}
    			*/
    			
	    		if ( (!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt)) ) {
		    		
	    			if( ComGetDaysBetween(formObj.p_from_dt.value,formObj.p_to_dt.value) +1 > 7){
		    			ComShowCodeMessage('COM132001','Send/Received Date','7Days');
		    			formObj.p_from_dt.focus();
		    			return false;
		    		}
	    				    			
	    			return true;
	    		}
	    		
    			
	    		if (!ComIsNull(formObj.p_bl_no)) {
	    			return true;
	    		}
	    		
	    		//기본포멧체크
    			if (ComIsNull(formObj.p_vvd)) {
    				ComShowCodeMessage('BKG00104','VVD');
 					formObj.p_vvd_cd.focus();
 					return false;    
    			}
    			
//    			if (ComIsNull(formObj.p_pol)) {
//    				ComShowCodeMessage('BKG00104','POL');
//    				formObj.p_pol.focus();
//    				return false;    
//    			}
    			
//    			if(form.p_pofe_yd_temp.Text == "" ){
//    				ComShowCodeMessage('BKG00104','POFE');
//    				formObj.p_pofe_yd_temp.focus();
//    				return false;    
//    			}   
   
	     					
				break;
	    }
        return true;

    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "p_vvd" || srcName == "p_pol" || srcName == "p_pod") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	
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
						style.height = 390;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
						MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 3, 100);
						
						var HeadTitle1 = "|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CNTR|CT|Sent\nType|Status|Status|MRN\nNO|EXS Send Date|EXS Send Date|ACK Receive Date|ACK Receive Date|edi_rcv_dt|edi_rcv_seq|bkg_no|result2";
				        var HeadTitle2 = "|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CNTR|CT|Sent\nType|Ack|Result|MRN\nNO|GMT|Local Time|GMT|Local Time|edi_rcv_dt|edi_rcv_seq|bkg_no|result2";
				        var headCount = ComCountHeadTitle(HeadTitle1);
						
						
						headCount = ComCountHeadTitle(HeadTitle1);
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 9, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
						InitHeadMode(true, false, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						
				           //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
						InitDataProperty(0, cnt++ , dtSeq,   40,  daCenter,  true,  "seq",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  80,  daCenter,  true,  "vvd",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "lane",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpol",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpol_yd",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pol",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pol_yd",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,  60,  daCenter,  true,  "pofe",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,  60,  daCenter,  true,  "pofe_yd",      false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "bl_no",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  30,  daCenter,  true,  "bkg_sts_cd",   false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pod",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pod_yd",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "del",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtPopup,  80,  daCenter,  true,  "cntrs",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "ct",           false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "sent_type",    false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "ack",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "result",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "mrn_no",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ens_send_gmt_dt",  false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ens_send_dt",  false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ack_rcv_gmt_dt",   false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ack_rcv_dt",   false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden, 120,  daCenter,  true,  "edi_rcv_dt",   false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden, 120,  daCenter,  true,  "edi_rcv_seq",   false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden, 100,  daCenter,  true,  "bkg_no",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden, 100,  daCenter,  true,  "result2",         false,  "",  dfNone,  0,  false,  false);
						CountPosition = 0;
						
						SetMergeCell(0, 4, 2, 2); //bpol
						SetMergeCell(0, 6, 2, 2); //pol
						SetMergeCell(0, 8, 2, 2); //pofe
						SetMergeCell(0, 12, 2, 2); //pod
						
						 // 자동 행 높이 지정
						//AutoRowHeight = false;
						// 행 높이 설정
						//DataRowHeight = 22;

					}
				break;
			case "sheetDownload":
				with (sheetObj) {

					// 높이 설정
					style.height = 390;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CT|Sent\nType|Status|Status|MRN\nNO|ENS Send Date|EXS Send Date|ACK Receive Date|ACK Receive Date|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|CNTR";
			        var HeadTitle2 = "|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CT|Sent\nType|Ack|Result|MRN\nNO|GMT|Local Time|GMT|Local Time|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|CNTR";
			        var headCount = ComCountHeadTitle(HeadTitle1);
					
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 9, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(true, false, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
			           //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
					InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "seq",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  80,  daCenter,  true,  "vvd",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "lane",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpol",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pol",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pol_yd",       false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden,  60,  daCenter,  true,  "pofe",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden,  60,  daCenter,  true,  "pofe_yd",      false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "bl_no",        false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  30,  daCenter,  true,  "bkg_sts_cd",   false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pod",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pod_yd",       false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "del",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "ct",           false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "sent_type",    false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "ack",          false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "result",       false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "mrn_no",       false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ens_send_gmt_dt",  false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ens_send_dt",  false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ack_rcv_gmt_dt",   false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "ack_rcv_dt",   false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden, 120,  daCenter,  true,  "edi_rcv_dt",   false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden, 120,  daCenter,  true,  "edi_rcv_seq",   false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden, 100,  daCenter,  true,  "bkg_no",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden, 100,  daCenter,  true,  "result2",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtPopup,  80,  daCenter,  true,  "cntrs",          false,  "",  dfNone,  0,  false,  false);					
					CountPosition = 0;
					
					SetMergeCell(0, 4, 2, 2); //bpol
					SetMergeCell(0, 6, 2, 2); //pol
					SetMergeCell(0, 8, 2, 2); //pofe
					SetMergeCell(0, 12, 2, 2); //pod
					
					 // 자동 행 높이 지정
					//AutoRowHeight = false;
					// 행 높이 설정
					//DataRowHeight = 22;

				}
			break;				
			case "sheet2":
				with (sheetObj) {
					
					// 높이 설정
					style.height = 280;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "|cnt_cd";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(false, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "cnt_cd",          false,  "",  dfNone,  0,  false,  false);
					
					CountPosition = 0;
					SelectHighLight= false;
					
				}
				break;
			case "sheet3":
				with (sheetObj) {
					
					// 높이 설정
					style.height = 280;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "|eu_1st_port|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(false, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port", false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "search_eu_1st_port_yd_cd", false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port_yd_cd",        false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port_name",         false,  "",  dfNone,  0,  false,  false);
					
					CountPosition = 0;
					SelectHighLight= false;
					
				}
				break;
		}//end switch
 	}     
	
    /* 개발자 작업  끝 */
