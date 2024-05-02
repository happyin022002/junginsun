/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6026.js
*@FileTitle : CM/OP Summary & Simulation- Contract Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
* 1.0 Creation
=========================================================
* History 
* 2012.08.16 송호진 [CHM-201219512-01] Split 02-조직도 변경에 따른 S/C & RFA DATA 업데이트 요청 
*                  SELCGM -> SELCAM, HAMUKG, NYCNKG, SINWKG 권한 유지 적용 
* 2012.09.18 송호진 [CHM-201220261-01] S/C Approval office 목록 수정 요청
*                  HAMUKG, NYCNKG, SINWKG 권한 부여 제외
* 2013.06.14 송호진 [CHM-201325245] 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가. 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_PRI_6026 : ESM_PRI_6026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6026() {
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

// PFMC Unit 선택에 따라 사용할 Text
 var UNIT_TEXT = new Array();
 UNIT_TEXT["FEU"] = "[Unit: FEU/USD]";
 UNIT_TEXT["TEU"] = "[Unit: TEU/USD]";

// Profit Level 선택에 따라 sheet title 에 사용할 Text
 var SHEET_TITLE = new Array();
 SHEET_TITLE["C"] = "CM Summary";
 SHEET_TITLE["O"] = "OP Summary";
 // 공통전역변수
 var BACKEND_JOB_ID  = "";
 var TIMER_ID = "";
 var ARRAY_BACKENDJOB_TYPE = new Array();

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var EXCEL_TP = "";
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
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");      
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
                       
            
            
 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                     break; 
 				case "btn1_New":
 					 resetAllObjects();
 					changeButtonStatus();
 					enableReferenceDt()
                     break; 
 				case "btn1_Revenue_Detail":
 					 doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC03);
                     break; 
 				case "btn1_Simulation":
 					 doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC02);
                     break; 
 				case "btn1_Chart":
					 doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC04);
                     break; 
 				case "btn1_Down_Excel":
 					var msgStr = ComGetMsg("PRI03002");
 			    	if(sheetObject1.RowCount == 0 )
 			    		return;
 			    	//vb script를 이용해서 버튼이 3개인 excel download 창을 띄운다.
 			     	execScript("rtn = Msgbox(\"" + ComReplaceStr(msgStr,"\n","\" & Chr(13) & \"") + "\", 3, \"Download Excel\")", "vbscript");
 			     	// download excel에서 Quick Mode를 선택 했을때
 			    	if (rtn == 6) {
 			    		// simulation 후 download excel 이라면 sheet의 내용을 다르게 download한다.
 			    		if( formObject.is_simulation.value == "Y"){
 			    			// excel에서 추가로 보여줘야 할 컬럼들을 노출 시킨다.
 			    			showColumns(sheetObject1,"cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
 			    			// sheet가 2개가 되는데 1번 sheet는 Before로 simulation 전 sheet이다.
	 			    		sheetObjects[7].SpeedDown2Excel(-1, false, false,"","",false,false,getSheetNameOfExcel("BEFORE"));
	 			    		// sheet가 2개가 되는데 2번 sheet는 After로 simulation 후 sheet이다.
	 			    		sheetObject1.SpeedDown2Excel(-1, true, true,"","",false,false,getSheetNameOfExcel("AFTER"));
	 			    		var isNewSheet = true;
	 			    		for(var idx=0 ; idx < 5 ; idx++){
	 			    			if( sheetObjects[2+idx].RowCount != 0 ){
	 			    				//simulation한 내용들을 다른 sheet에 추가한다.
	 			    				sheetObjects[2+idx].SpeedDown2Excel(-1, true, isNewSheet,"","",false,false,"Simulation Data");
	 			    				isNewSheet = false;
	 			    			}
	 			    		}
	 			    		// excel에서 추가로 보여주었던 컬럼들을 다시 숨긴다.
	 			    		hideColumns(sheetObject1,"cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
 			    		}else{
 			    			// simulation 이 안 됐다면 세로운 쿼리를 던져 데이터를 읽어 와야 한다.
 			    			// 왜냐하면 화면에 조회된 데이터를 그대로 DOWNLOAD받는 것이 아니라
 			    			// SUB-TRADE LEVEL로 데이터를 DOWNLOAD 받아야 하기 때문이다.
 			    			doActionIBSheet(sheetObjects[8],document.form,IBSEARCH_ASYNC07);
 			    		}
 			    		
 			    	// download excel에서 Standard Mode를 선택 했을때
 			    	} else if (rtn == 7) {
 			    		// simulation 후 download excel 이라면 sheet의 내용을 다르게 download한다.
 			    		if( formObject.is_simulation.value == "Y"){
 			    			// excel에서 추가로 보여줘야 할 컬럼들을 노출 시킨다.
 			    			showColumns(sheetObject1, "cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
 			    			// sheet가 2개가 되는데 1번 sheet는 Before로 simulation 전 sheet이다.
	 			    		sheetObjects[7].Down2Excel(-1, false, false,true,"","",false,false,getSheetNameOfExcel("BEFORE"));
	 			    		// sheet가 2개가 되는데 2번 sheet는 After로 simulation 후 sheet이다.
	 			    		sheetObject1.Down2Excel(-1, true, true,true,"","",false,false,getSheetNameOfExcel("AFTER"));	 			    		
	 			    		var isNewSheet = true;
	 			    		for(var idx=0 ; idx < 5 ; idx++){
	 			    			if( sheetObjects[2+idx].RowCount != 0 ){
	 			    				//simulation한 내용들을 다른 sheet에 추가한다.
	 			    				sheetObjects[2+idx].Down2Excel(-1, true, isNewSheet,true,"","",false,false,"Simulation Data");
	 			    				isNewSheet = false;
	 			    			}
	 			    		}
	 			    		// excel에서 추가로 보여주었던 컬럼들을 다시 숨긴다.
	 			    		hideColumns(sheetObject1,"cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
 			    		}else{
 			    			// simulation 이 안 됐다면 세로운 쿼리를 던져 데이터를 읽어 와야 한다.
 			    			// 왜냐하면 화면에 조회된 데이터를 그대로 DOWNLOAD받는 것이 아니라
 			    			// SUB-TRADE LEVEL로 데이터를 DOWNLOAD 받아야 하기 때문이다. 			    			
 			    			doActionIBSheet(sheetObjects[8],document.form,IBSEARCH_ASYNC08);
 			    		}
 			    		
 			    		
 			    	} 	 					
                     break; 
				case "btns_calendar1": //달력버튼
	            	var cal = ComCalendar();
	            	cal.select(formObject.frm_ctrt_eff_dt, 'yyyy-MM-dd');
	            	break;
                case "btns_calendar2":
                	var cal = ComCalendar();
                	cal.select(formObject.frm_ctrt_exp_dt, 'yyyy-MM-dd');

                    break;      
                case "btn_customer":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01);
                	break;   
         		case "btn_rlane" :
         			doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC06);
         			break;
                case "btn_origin":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC10);
                	break;   
                case "btn_dest":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC11);
                	break;              			
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage("Exception 1-"+OBJECT_ERROR);
     		} else {
     			ComShowMessage("Exception 2-"+e);
     		}
     		ComOpenWait(false);
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
    	  var formObj = document.form;
          for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
              ComEndConfigSheet(sheetObjects[i]);
          }
          changeButtonStatus();
          hideColumns(sheetObjects[0],"cust_tp_cd|svc_scp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
          // event들의 등록
          initControl();
          // 초기 combo data를 세팅하고, properties 설정  
          initCombo();
          // 화면의 모든 값을 초기 default 값으로 바꾼다.
          resetAllObjects();
          // Profit View, Profit level의 값에 따라 sheet의 보여지는 column을 다르게 숨기거나 보여준다.
          changeColHidden(formObj.frm_summary_items,sheetObjects[0]);
          // Profit View, Profit level의 값에 따라 sheet의 보여지는 column을 다르게 숨기거나 보여준다.
          changeColHidden(formObj.frm_summary_items,sheetObjects[7]);
          // Profit View, Profit level의 값에 따라 sheet의 보여지는 column을 다르게 숨기거나 보여준다.
          changeColHidden(formObj.frm_summary_items,sheetObjects[8]);
          // sheet오른쪽위의 Unit 관련 Text를 PFMC Unit 선택에 따라 TEU/FEU로 변경한다. 
  		  changeUnitText(ComPriGetCheckedRadioButtonValue(formObj.frm_pfmc_unit)) ;
  		  // COA_WK_PRD에서 주차와 그 주차의 시작 종료일을 읽어서 SHEET에 저장해 둔다.
  		  doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC05);
  		  // 로긴 권한에 따라 버튼 제어와 request office code input box를 제어 한다.
  		  checkAuthRequestOffice();
  		  
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
	    axon_event.addListener('change', 'frm_prop_ofc_cd_OnChange', 'frm_prop_ofc_cd');
	    axon_event.addListener('click', 'frm_pfmc_unit_OnClick', 'frm_pfmc_unit');
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
  
	    axon_event.addListener('mouseover', 'frm_cust_nm_OnMouseOver', 'frm_cust_nm');  
        axon_event.addListener('mouseout', 'frm_cust_nm_OnMouseOut', 'frm_cust_nm');
        
        axon_event.addListener('change', 'frm_ctrt_eff_yr_OnChange', 'frm_ctrt_eff_yr');  
	    axon_event.addListener('change', 'frm_ctrt_eff_wk_OnChange', 'frm_ctrt_eff_wk');  
        axon_event.addListener('change', 'frm_ctrt_exp_yr_OnChange', 'frm_ctrt_exp_yr');  
	    axon_event.addListener('change', 'frm_ctrt_exp_wk_OnChange', 'frm_ctrt_exp_wk');  	 
	    
        axon_event.addListener('change', 'frm_smr_eff_yr_OnChange', 'frm_smr_eff_yr');  
	    axon_event.addListener('change', 'frm_smr_eff_wk_OnChange', 'frm_smr_eff_wk');  
        axon_event.addListener('change', 'frm_smr_exp_yr_OnChange', 'frm_smr_exp_yr');  
	    axon_event.addListener('change', 'frm_smr_exp_wk_OnChange', 'frm_smr_exp_wk');  	
	    
        axon_event.addListener('change', 'frm_rfrc_eff_yr_OnChange', 'frm_rfrc_eff_yr');  
	    axon_event.addListener('change', 'frm_rfrc_eff_wk_OnChange', 'frm_rfrc_eff_wk');  
        axon_event.addListener('change', 'frm_rfrc_exp_yr_OnChange', 'frm_rfrc_exp_yr');  
	    axon_event.addListener('change', 'frm_rfrc_exp_wk_OnChange', 'frm_rfrc_exp_wk');  		
	    axon_event.addListener('click', 'frm_contract_type_t_OnClick', 'frm_contract_type_t');  		
	    
	    axon_event.addListener('change', 'frm_ori_rout_cd_OnChange', 'frm_ori_rout_cd');
	    axon_event.addListener('change', 'frm_dest_rout_cd_OnChange', 'frm_dest_rout_cd');	    
	    
	    axon_event.addListener('focus', 'frm_rfrc_eff_yr_OnFocus', 'frm_rfrc_eff_yr');  
	    
        axon_event.addListener ('keyup', 'MyComKeyEnter', 'form');
        axon_event.addListener ('keydown', 'myKeyEnter', 'form');
	    
   }   

  /** 
   * document에서 Enter를 입력했을때 호출 된다.
   * 
   *
   * <br><b>Example :</b>
   * <pre>
   * </pre>
   * 
   * @return 없음
   */  
    function myKeyEnter(){
   	   
   	   var name = event.srcElement.getAttribute("name");
	   //Origin, Dest.에서 Enter를 눌렀을 경우 origin, dest.관련 조회를 해야 하기 때문에 
	   //메인 화면 조회를 못하도록 한다.
   	   if( name == "frm_ori_rout_cd" ||  name == "frm_dest_rout_cd"  ){
   		   return;
   	   }
   	   ComKeyEnter();
    }      
      
  /** 
  * ComKeyEnter의 기능중 object의 입력값이 Maxlength에 이르렀을때  <BR>
  * 다음 Object로 focust를 옮겨주는 기능을 이용하기 위한 함수
  *
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * 
  * @return 없음
  */        
   function MyComKeyEnter( ){
     ComKeyEnter("lengthnextfocus");
   }
    var oPopup = null;
    
    /** 
     * frm_cust_nm 의 Mouse Over Event 시 호출 <BR>
     * customer list를 Tool tip 형태로 보여준다.
     *
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @param {object} e, Evnet Object
     * @return 없음
     */          
    function frm_cust_nm_OnMouseOver(e){
    	var parentObj = document.getElementById("frm_cust_nm");
    	if( document.form.frm_cust_list.value != "" ){
    		openDynamicPopup(0,parentObj.clientHeight+3,parentObj);
    	}
    }
    
    /** 
    * frm_rfrc_eff_yr 의 Mouse Over Event 시 호출 <BR>
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e, Evnet Object
    * @return 없음
    */   
    function frm_rfrc_eff_yr_OnFocus(e){
    	var formObj = document.form;
    	if( formObj.frm_rfrc_eff_yr.readOnly == true ){
    		formObj.frm_trd_cd.focus();
    	}
    }
    
    /** 
    * frm_cust_nm 의 Mouse Out Event 시 호출 <BR>
    * Tool tip 형태의 customer list를 감춘다.
    *
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e, Evnet Object
    * @return 없음
    */            
    function frm_cust_nm_OnMouseOut(e){
    	if( oPopup != null){
    		oPopup.hide();
    	}
    }
    
    /** 
    * 사용자가 입력한 년,주차를 <BR>
    * 입력받아 해당 기간의 일자를 return한다.<br>
    * 만약 잘못된 주차를 입력하면 그에 맞는 에러메시지를 RETURN한다.<br>
    *
    * <br><b>Example :</b>
    * <pre>
    * 		value = valicateYearWeek(formObj.frm_ctrt_exp_yr); 
    *       // 결과 Array["CODE"]="-1" 일경우 Array["MSG"] 에 입력기간 메시지가 있고
    *       //  Array["CODE"]="1" 일경우 Array["MSG"] = "", Array["DATE_TEXT"] 에는 파라메터로 받은 년,주차에 해당하는 날짜
    * </pre>
    * 
    * @param {object} obj 필수, html input object
    * @return Array, Array["CODE"]  , Array["MSG"]  , Array["DATE_TEXT"]  3개의 값을 갖는 Array
    */     
    function valicateYearWeek(obj){
    	// 1. 년과 주차 모두가 NOT NULL일 경우 - 년,주차가 정상 범위에 있는지 확인한다.
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	var name = obj.getAttribute("name");
    	var yrValue = "";
    	var wkValue = "";
    	var returnValue = new Array();
    	returnValue["DATE_TEXT"] = "";
    	
    	switch(name){
    	case "frm_ctrt_eff_yr" :
    	case "frm_ctrt_eff_wk" :
    		yrValue = formObj.frm_ctrt_eff_yr.value
    		wkValue = formObj.frm_ctrt_eff_wk.value
    		break;
    	case "frm_ctrt_exp_yr" :
    	case "frm_ctrt_exp_wk" :
    		yrValue = formObj.frm_ctrt_exp_yr.value
    		wkValue = formObj.frm_ctrt_exp_wk.value
    		break;
    	case "frm_smr_eff_yr" :
    	case "frm_smr_eff_wk" :
    		yrValue = formObj.frm_smr_eff_yr.value
    		wkValue = formObj.frm_smr_eff_wk.value
    		break;
    	case "frm_smr_exp_yr" :
    	case "frm_smr_exp_wk" :
    		yrValue = formObj.frm_smr_exp_yr.value
    		wkValue = formObj.frm_smr_exp_wk.value
    		break;  
    	case "frm_rfrc_eff_yr" :
    	case "frm_rfrc_eff_wk" :
    		yrValue = formObj.frm_rfrc_eff_yr.value
    		wkValue = formObj.frm_rfrc_eff_wk.value
    		break;
    	case "frm_rfrc_exp_yr" :
    	case "frm_rfrc_exp_wk" :
    		yrValue = formObj.frm_rfrc_exp_yr.value
    		wkValue = formObj.frm_rfrc_exp_wk.value
    		break;    		
    	}
    	if( yrValue != "" && wkValue != "" ){
	    	var row = sheetObj.FindText("cost_yr", yrValue) ;
	    	if( row >= 0 ){
	    		row = sheetObj.FindText("cost_wk", wkValue, row) ;
	    		if(sheetObj.CellValue(row,"cost_yr") != yrValue ){
	    			row = -1;
	    		}
	    	}
	    	if( row < 0 ){
	    		returnValue["CODE"] = -1;
	    		returnValue["MSG"] = ComGetMsg("PRI03018",yrValue+"-"+wkValue);//getDateFormat(sheetObj.CellValue(1,"sls_fm_dt"))+"~"+getDateFormat(sheetObj.CellValue(sheetObj.LastRow,"sls_fm_dt"));
	    	}else{
	    		returnValue["CODE"] = 1;
	    		returnValue["MSG"] = "";
	    		if( name.indexOf("_eff_") >0 ){
	    			returnValue["DATE_TEXT"] = getDateFormat(sheetObj.CellValue(row,"sls_fm_dt"));
	    		}else{
	    			returnValue["DATE_TEXT"] = getDateFormat(sheetObj.CellValue(row,"sls_to_dt"));
	    		}
	    	}
    	}else if(yrValue != "" ){
	    	var row = sheetObj.FindText("cost_yr", yrValue) ;
	    	if( row < 0 ){
	    		returnValue["CODE"] = -1;
	    		returnValue["MSG"] = ComGetMsg("PRI03018",yrValue);  //getDateFormat(sheetObj.CellValue(1,"sls_fm_dt"))+"~"+getDateFormat(sheetObj.CellValue(sheetObj.LastRow,"sls_fm_dt"));
	    	}else{
	    		returnValue["CODE"] = 0;
	    		returnValue["MSG"] = "";
	    		
	    	}
    	}else if(wkValue != "" ){
	    	var row = sheetObj.FindText("cost_wk", wkValue) ;
	    	if( row < 0 ){
	    		returnValue["CODE"] = -1;
	    		returnValue["MSG"] = ComGetMsg("PRI03018",wkValue);//getDateFormat(sheetObj.CellValue(1,"sls_fm_dt"))+"~"+getDateFormat(sheetObj.CellValue(sheetObj.LastRow,"sls_fm_dt"));
	    	}else{
	    		returnValue["CODE"] = 0;
	    		returnValue["MSG"] = "";
	    	}	    	
    	}else{
    		returnValue["CODE"] = 0;
    		returnValue["MSG"] = "";
    	}
    	return returnValue;
    }
    

    /** 
    * yyyymmdd형태의 날짜를 입력받아 <BR>
    * yyyy-mm-dd형태로 변환시켜줌 <br>
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		returnValue["MSG"] = getDateFormat(sheetObj.CellValue(1,"sls_fm_dt"))+"~"+getDateFormat(sheetObj.CellValue(sheetObj.LastRow,"sls_fm_dt"));
    * </pre>
    * 
    * @param {string} data 필수, 8자리의 date
    * @return string, yyyy-mm-dd 형태의 date
    */   
    function getDateFormat(data){
    	var value = "";
    	if( data != "" && data != undefined && data.length == 8){
    		value = data.substring(0,4) + "-" + data.substring(4,6) + "-" + data.substring(6,8);
    	}
    	return value;
    }
    
    /** 
    * Contract의 시작 년,주차를 입력하고 Summary의 시작 년,주차를 <BR>
    * 입력해줌
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		setDefaultDataToSummaryDt();
    * </pre>
    * 
    * @return 없음
    */       
    function setDefaultDataToSummaryDt(){
    	var formObj = document.form;
    	// summary 주차의 시작년,주차가 입력 되지 않았다면 default value를 넣어준다.
    	if( formObj.frm_smr_eff_yr.value == ""
    		&& formObj.frm_smr_eff_wk.value == "" 
    		&& document.getElementById("ctrt_eff_date_name").innerHTML != "" ){
    		formObj.frm_smr_eff_yr.value = formObj.frm_ctrt_eff_yr.value ;
    		formObj.frm_smr_eff_wk.value = formObj.frm_ctrt_eff_wk.value ;
    		//By Duration의 Text로 된 주차에 해당하는 년월일 text를 변경해준다.
    		changeDateText("smr_eff_date_name",document.getElementById("ctrt_eff_date_name").innerHTML );
    	}
    }
    
    /** 
    * Summary의 시작과 종료 년,주차를 입력하고 Reference의 시작 년,주차를 <BR>
    * 입력해줌
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		setDefaultDataToReferenceDt();
    * </pre>
    * 
    * @return 없음
    */           
    function setDefaultDataToReferenceDt(){
    	var formObj = document.form;
    	// summary 주차의 시작년,주차, 종료년, 주차가 입력 되었다면 Actual PFMC에 default value를 넣어준다.
    	if( formObj.frm_smr_eff_yr.value != ""
    		&& formObj.frm_smr_eff_wk.value != "" 
    		&& formObj.frm_smr_exp_yr.value != ""
        	&& formObj.frm_smr_exp_wk.value != "" 
    		&& document.getElementById("rfrc_eff_date_name").innerHTML == "" ){
    		formObj.frm_rfrc_eff_yr.value = formObj.frm_smr_eff_yr.value ;
    		formObj.frm_rfrc_eff_wk.value = formObj.frm_smr_eff_wk.value ;
    		//By Duration의 Text로 된 주차에 해당하는 년월일 text를 변경해준다.
    		changeDateText("rfrc_eff_date_name",document.getElementById("smr_eff_date_name").innerHTML );
    	}
    }
    
    /** 
    * Reference의 시작과 종료 년,주차를 활성화 또는 비활성화 시킴
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		enableReferenceDt();
    * </pre>
    * 
    * @return 없음
    */    
    function enableReferenceDt(){
    	var formObj = document.form;
    	var currYrWk = getCurrentYrWk();
    	// summary 값이 시작과 끝이 입력 되었고, 그 종료 날짜가 현제 날짜보다 미래이면 reference를 enable한다. 
    	if(	formObj.frm_smr_eff_yr.value != ""
	    		&& formObj.frm_smr_eff_wk.value != "" 
	    		&& formObj.frm_smr_exp_yr.value != ""
	        	&& formObj.frm_smr_exp_wk.value != "" 
	    		&& document.getElementById("smr_eff_date_name").innerHTML != "" 
	    		&& document.getElementById("smr_exp_date_name").innerHTML != ""
	    		&& currYrWk < formObj.frm_smr_exp_yr.value + formObj.frm_smr_exp_wk.value ){
    		//formObj.frm_rfrc_eff_yr.setAttribute("readOnly","false")  ;
    		formObj.frm_rfrc_eff_yr.readOnly = false;
    		formObj.frm_rfrc_eff_wk.disabled = false;
    		formObj.frm_rfrc_exp_yr.disabled = false;
    		formObj.frm_rfrc_exp_wk.disabled = false;
    		formObj.frm_rfrc_eff_yr.setAttribute("className","input1");
    		formObj.frm_rfrc_eff_wk.setAttribute("className","input1");
    		formObj.frm_rfrc_exp_yr.setAttribute("className","input1");
    		formObj.frm_rfrc_exp_wk.setAttribute("className","input1");
    		setDefaultDataToReferenceDt();
    		
    	}else{
    		formObj.frm_rfrc_eff_yr.readOnly = true;
    		//formObj.frm_rfrc_eff_yr.setAttribute("readOnly","true")  ;
    		formObj.frm_rfrc_eff_wk.disabled = true;
    		formObj.frm_rfrc_exp_yr.disabled = true;
    		formObj.frm_rfrc_exp_wk.disabled = true;
    		formObj.frm_rfrc_eff_yr.value = "";
    		formObj.frm_rfrc_eff_wk.value = "";
    		formObj.frm_rfrc_exp_yr.value = "";
    		formObj.frm_rfrc_exp_wk.value = "";
    		formObj.frm_rfrc_eff_yr.setAttribute("className","input2");
    		formObj.frm_rfrc_eff_wk.setAttribute("className","input2");
    		formObj.frm_rfrc_exp_yr.setAttribute("className","input2");
    		formObj.frm_rfrc_exp_wk.setAttribute("className","input2");
    		changeDateText("rfrc_eff_date_name","" );
    		changeDateText("rfrc_exp_date_name","" );
    		
    	}
    }
    
    /** 
    * 현재 일자에 해당하는 주차를 찾아 return한다
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		getCurrentYrWk();
    * </pre>
    * 
    * @return string, yyyywk 형태의 현재 년,주차
    */     
    function getCurrentYrWk(){
    	var sheetObj = sheetObjects[1];
    	//wk_tp가 0은 현재 주차
    	//wk_tp가 -1은 과거 주차
    	//wk_tp가 1은 미래 주차 이다.
    	var row = sheetObj.FindText("wk_tp","0");
    	var cost_yr = sheetObj.CellValue(row,"cost_yr");
    	var cost_wk = sheetObj.CellValue(row,"cost_wk");
    	return cost_yr + cost_wk;
    }
    /** 
    * 현재 일자에 해당하는 주차의 전주차를 찾아 return한다
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		getCurrentYrWk();
    * </pre>
    * 
    * @return string, yyyywk 형태의 현재주차의 전주차 년,주차
    */         
    function getBeforeThisYrWk(){
    	var sheetObj = sheetObjects[1];
    	//주차 정보가 주차별로 sort되어 있기 때문에
    	//현재주차 -1 번째 row는 한주 전 주차 이다.
    	var row = sheetObj.FindText("wk_tp","0");
    	var cost_yr = sheetObj.CellValue(row-1,"cost_yr");
    	var cost_wk = sheetObj.CellValue(row-1,"cost_wk");
    	return cost_yr + cost_wk;
    }
    
    
    /** 
    * 현재 주차의 시작일자를 찾아 return한다
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * 		getCurrentEffDt();
    * </pre>
    * 
    * @return string, yyyymmdd 형태의 현재주차의 년월일
    */        
    function getCurrentEffDt(){
    	var sheetObj = sheetObjects[1];
    	//wk_tp가 0은 현재 주차
    	//wk_tp가 -1은 과거 주차
    	//wk_tp가 1은 미래 주차 이다.    	
    	var row = sheetObj.FindText("wk_tp","0");
    	var sls_fm_dt = sheetObj.CellValue(row,"sls_fm_dt");
    	return sls_fm_dt 
    }    
    
    /**  
    * frm_ctrt_eff_yr의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */        
    function frm_ctrt_eff_yr_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	//Contract를 입력했을때 
    	changeDateText("ctrt_eff_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	}
    	//summary의 default value를 set한다.
    	setDefaultDataToSummaryDt();
    }
    /**  
    * frm_ctrt_eff_wk의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */     
    function frm_ctrt_eff_wk_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	//Contract를 입력했을때 
    	changeDateText("ctrt_eff_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    	//summary의 default value를 set한다.
    	setDefaultDataToSummaryDt();
    }  
    
    /**  
    * frm_ctrt_exp_yr의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_ctrt_exp_yr_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("ctrt_exp_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    }
    /**  
    * frm_ctrt_exp_wk의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_ctrt_exp_wk_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("ctrt_exp_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    } 
    /**  
    * frm_smr_eff_yr의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */  
    function frm_smr_eff_yr_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("smr_eff_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	}
    	//summary 입력값에 따라 reference 입력 input box를 
    	//활성화 하거나 비활성화 한다.
    	enableReferenceDt();
    }
    /**  
    * frm_smr_eff_yr의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_smr_eff_wk_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("smr_eff_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    	//summary 입력값에 따라 reference 입력 input box를 
    	//활성화 하거나 비활성화 한다.
    	enableReferenceDt();
    }   
    /**  
    * frm_smr_exp의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_smr_exp_yr_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("smr_exp_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	}
    	//summary 입력값에 따라 reference 입력 input box를 
    	//활성화 하거나 비활성화 한다.
    	enableReferenceDt();
    }
    /**  
    * frm_smr_exp_wk의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_smr_exp_wk_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("smr_exp_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    	//summary 입력값에 따라 reference 입력 input box를 
    	//활성화 하거나 비활성화 한다.
    	enableReferenceDt();
    } 
    /**  
    * frm_rfrc_eff_yr의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */  
    function frm_rfrc_eff_yr_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("rfrc_eff_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    	} 
    }
    /**  
    * frm_rfrc_eff_wk의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_rfrc_eff_wk_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("rfrc_eff_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    }   
    /**  
    * frm_rfrc_exp_yr의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_rfrc_exp_yr_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("rfrc_exp_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    }
    /**  
    * frm_rfrc_exp_wk의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_rfrc_exp_wk_OnChange(e){
    	//화면에서 입력한 year,week를 이용해 날짜를 찾아준다.
    	var value = valicateYearWeek(e.srcElement);
    	changeDateText("rfrc_exp_date_name",value["DATE_TEXT"]);
    	//year week 입력에 error 가 있었다면 경고메시지를 표시한다. 
    	if( value["CODE"] == -1){
    		alert(value["MSG"]);
    		return;
    	} 
    } 
    
    /**  
    * frm_contract_type_t의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e 필수, Event Object
    * @return 없음
    */      
    function frm_contract_type_t_OnClick(e){
    	//changeButtonStatus();
 
    } 
    
    
    /**  
    * 파라메터로 받은 Object의 innerHTML에 value값을 넣어줌<BR>
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 	changeDateText("rfrc_exp_date_name",value["DATE_TEXT"]);
    * </pre>
    * 
    * @param {string} objName 필수, span Object의 이름
    * @param {string} value 필수, Text내용.
    * @return 없음
    */   
    function changeDateText(objName,value){
    	document.getElementById(objName).innerHTML = value;
    }
 

    /** 
    * form에 모든 내용을 초기화 하고 default 선택을 한다.
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    *         resetAllObjects();
    * </pre>
    *
    * @return 없음
    */  
    function resetAllObjects(){
    	var formObj = document.form;
    	formObj.reset();
		formObj.frm_profit_view.Index2=1;
		formObj.frm_profit_level.Index2="0";
		formObj.frm_summary_items.Index2="0";
		formObj.frm_prop_apro_ofc_cd.Index2="0";
		formObj.frm_prop_srep_cd.Index2="0";
		formObj.frm_customer_type.Index2="0";
		changeDateText("ctrt_eff_date_name","");
		changeDateText("ctrt_exp_date_name","");
		changeDateText("smr_eff_date_name","");
		changeDateText("smr_exp_date_name","");
		
		sheetObjects[0].RemoveAll();
    }
    
    /**  
    * 화면에 추가 정보를 보여주기 위해 DIV로 만들어진<BR>
    * popup을 화면에 띄워준다.
    *  
    * <br><b>Example :</b>
    * <pre>
    *      openDynamicPopup(0,parentObj.clientHeight+3,parentObj);
    * </pre>
    * 
    * @param {int} x 필수, parentObj로 부터 표시하고자 하는 x 좌표 offset
    * @param {int} y 필수, parentObj로 부터 표시하고자 하는 y 좌표 offset
    * @param {object} parentObj 필수, popup이 표시될 기준 위치가 되는 Object
    * @return 없음
    */       
     function openDynamicPopup(x,y,parentObj){
         if( oPopup == null){
             oPopup = window.createPopup(); 
             var oPopBody = oPopup.document.body;
             oPopBody.style.backgroundColor = "lightyellow";
             oPopBody.style.border = "solid black 1px";
             oPopBody.style.padding= "2px"
              oPopBody.style.fontFamily="Tahoma,verdana,arial,dotum,gulim";
             oPopBody.style.fontSize="12px"
             	 
         }
         var innerHTML = makeCustomerHTML();
         oPopup.document.body.innerHTML = innerHTML;
         oPopup.show(x,y,325,0,parentObj);
        
         oPopup.show(x,y,325,getHeightForCustomerHtml(),parentObj);
         return oPopup;

     } 
     
     /**  
     * customer list를 표현하고 있는 table의 height를 구한다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *      oPopup.show(x,y,325,getHeightForCustomerHtml(),parentObj);
     * </pre>
     * 
     * @return int, customer list를 보여줄 table의 height값
     */     
     function getHeightForCustomerHtml(){
    	 var tName = oPopup.document.getElementById("t_name");
    	 
    	 return tName.clientHeight+8;
     }
     
     /**  
     * div에서 사용할 customer list를 html로 만들어 return한다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *      var innerHTML = makeCustomerHTML(); 
     *      oPopup.document.body.innerHTML = innerHTML;
     * </pre>
     * 
     * @return string, div에서 이용할 customer list를 html로 만든 string 
     */     
     function makeCustomerHTML(){
    	 var html = "";
    	 var formObj = document.form;
    	 var cdList = formObj.frm_cust_list.value;
    	 var nmList = formObj.frm_cust_nm.value;
 
    	 if( cdList != "" ){
    		 var cdArr = cdList.split(";");
    		 var nmArr = nmList.split(";");
    		 for(var i=0 ; i < cdArr.length ; i++ ){
    			 html += "<tr><TD style='padding:1px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;border:solid black 1px'>" + cdArr[i] +"</TD><TD style='padding:1px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;border:solid black 1px'>" + nmArr[i]  +"</TD></tr>" ;
    		 }
    		 html = "<table style='padding:0px;border-collapse: collapse; width:100%;border:solid black 1px' id='t_name'>" + html +"</table>";
    		 
    	 }
    	 return html;
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
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
              case "sheet8":      //sheet8 init //simulation 후 excel download시 사용한다. before sheet에 보여줄 내용을 처음 조회 값을 저장해 둔다.
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 220;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "||Sel.|Seq.|Contract|Approval Office|Request\nOffice|Request\nOffice|Sales Rep.|Contract No.|Customer Type|Customer Name|Eff. Date|Exp. Date|MQC\n(Target MVC)|Load (Performance)|Load (Performance)|Load (Performance)|Gross Revenue|Gross Revenue|Gross Revenue|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Week|Week|Week|CMPB|CMPB|CMPB|CMPB|CMPB|CMPB|CM|CM|CM|CM|CM|CM|OPB|OPB|OPB|OP|OP|OP|prop_no";
 					var HeadTitle2  = "||Sel.|Seq.|Contract|Approval Office|Request\nOffice|Request\nOffice|Sales Rep.|Contract No.|Customer Type|Customer Name|Eff. Date|Exp. Date|MQC\n(Target MVC)|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Actual|Actual|Estimate|Estimate|Estimate|Sum|Sum|Sum|Actual|Estimate|Sum|Actual|Actual|Estimate|Estimate|Diff(%)|Diff(%)|Actual|Actual|Estimate|Estimate|Sum|Sum|Actual|Estimate|Diff(%)|Actual|Estimate|Sum|prop_no";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 13, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"dummy_seq",   		false,          "",      dfNone,      		0,			false,       false);
  	               
 	                InitDataProperty(0, cnt++ , dtCheckBox,				40,   	daCenter,  	true,		"sel_chk",   		false,          "",      dfNone,      		0,			true,       true );

 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			false,       true);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"contract_nm",   			false,          "",      dfNone,      	2,			false,       false); 					
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"prop_apro_ofc_cd",   			false,          "",      dfNone,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"prop_ofc_cd",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    			60,   	daLeft,  	true,		"prop_ofc_nm",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"respb_srep_cd",   			false,          "",      dfNone,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"a_sc_no",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"cust_tp_cd",   			false,          "",      dfNone,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"cust_nm",   	false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"ctrt_eff_dt",   			false,			"",      dfNone,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"ctrt_exp_dt",   			false,			"",      dfNone,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	true,		"mqc_qty",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"a1_load",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"e1_load",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"sum_load",   			false,			"|a1_load|+|e1_load|",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_g_rev",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"e1_g_rev",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"sum_grev",   			false,			"|a1_g_rev|+|e1_g_rev|",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_cost_cm_office",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_cost_cm_trade",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_cost_op_office",   			false,			"",      dfNullInteger,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"e1_cost_cm_office",   			false,			"",		 dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"e1_cost_cm_trade",   			false,			"",		 dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"e1_cost_op_office",   			false,			"",		 dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"sum_cost_cm_office",   			false,			"|a1_cost_cm_office|+|e1_cost_cm_office|",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"sum_cost_cm_trade",   			false,			"|a1_cost_cm_trade|+|e1_cost_cm_trade|",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"sum_cost_op_office",   			false,			"|a1_cost_op_office|+|e1_cost_op_office|",      dfNullInteger,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"a1_week_cnt",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"e1_tot_wk",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"sum_week",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"a1_cmpb_office",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"a1_cmpb_trade",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"e1_cmpb_office",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"e1_cmpb_trade",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"diff_cmpb_office",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"diff_cmpb_trade",   			false,          "",      dfNullFloat,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_cm_office",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_cm_trade",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"e1_cm_office",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"e1_cm_trade",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"sum_cm_office",   			false,			"|a1_cm_office|+|e1_cm_office|",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"sum_cm_trade",   			false,			"|a1_cm_trade|+|e1_cm_trade|",      dfNullInteger,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"a1_opb",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"e1_opb",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"diff_opb",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"a1_op",   			false,          "",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"e1_op",   			false,          "",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"sum_op",   			false,          "|a1_op|+|e1_op|",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    			80,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			false,       false);
 					CountPosition = 0;
 					ColHidden("dummy_seq") = true;
 					
 					WaitImageVisible = false;

 				 
                }
                break;
              case "sheet2":      // coa_wk_prd table의 내용을 조회해서 저장해 둔다.
              					  // cost_yr,cost_wk로 sort되어 있으며 화면에서 week를 입력하면 날짜로 변환된 text를 보여줄때나
              					  // 현재 주차, 이전주차, 다음주차의 조회시 사용한다.
              with (sheetObj) {
                  // 높이 설정
                  style.height = 220;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msPrevColumnMerge + msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = false;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 1, 15, 100);

                  var HeadTitle1 = "COST_YR|COST_WK|SLS_FM_DT|SLS_TO_DT|WK_TP";
                  var headCount = ComCountHeadTitle(HeadTitle1);
                  
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true);

                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true);
				 

                  //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"cost_yr",   			false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"cost_wk",   	false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"sls_fm_dt",   			false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"sls_to_dt",   	false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"wk_tp",   	false,          "",      dfNone,      		0,			true,       true);
					 
					CountPosition = 0;
					WaitImageVisible = false;


				 
             }
             break;   
             // Simulation을 할때 입력한 값들을 저장 해 두기 위한 sheet들로 화면에는 보이지 않는다.
             // Simulation 후 excel download시 사용한다.
   			case "sheet3":      //G.Revenue Simulation
   			case "sheet4":      //Rate Simulation
   			case "sheet5":      //Surcharge Simulation
   			case "sheet6":      //Cost Simulation
   			case "sheet7":      //Load Simulation
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
                InitRowInfo(3, 1, 15, 100);
                
                var HeadTitle1 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Route|Route|Route|Route|"+(sheetObj.id == "sheet5" ? "Surcharge\nCode|" : "")+"Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
                var HeadTitle2 = "|Sel.|Seq.|Trade|Bound|Sub-Trade|Revenue Lane|Approval\nOffice|Customer\nType|Origin|ori_tp|Dest.|dest_tp|"+(sheetObj.id == "sheet5" ? "Surcharge\nCode|" : "")+"Cal.\n[+ , x(%)]|Amount\n[+/-]|hidden_eff_yrwk|Eff.Date\n(Year-Week)|hidden_exp_yrwk|Exp.Date\n(Year-Week)|score";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				var HeadTitle0 = "";
				var headerTitle = new Array();
				headerTitle["sheet3"] = "G.Revenue Simulation";
				headerTitle["sheet4"] = "Rate Simulation";
				headerTitle["sheet5"] = "Surcharge Simulation";
				headerTitle["sheet6"] = "Cost Simulation";
				headerTitle["sheet7"] = "Load Simulation";
				
				for(var idx=1 ; idx < headCount ; idx++){
					HeadTitle0 += "|"+ headerTitle[sheetObj.id]
				}

				
                
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                
				InitDataProperty(0, cnt++ , dtHidden,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"trd_cd",				false,			"",		dfNone,				2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"dir_cd",				false,			"",		dfNone,				2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"sub_trd_cd",   	false,          "",      dfNone,      		0,			true,       false);
				InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"rlane_cd",   	false,          "",      dfNone,      		0,			true,       false);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		75,   	daCenter,  	true,		"ori_rout_cd",   	false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"ori_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtPopup,    		75,   	daCenter,  	true,		"dest_rout_cd",   	false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtHidden,    		75,   	daCenter,  	true,		"dest_loc_tp",   	false,          "",      dfNone,      		0,			true,       true);

				if( sheetObj.id == "sheet5" ){
 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"chg_cd",   	true,          "",      dfNone,      		0,			true,       true);
				}
				InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"hidden_eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtPopupEdit,			100,	daCenter,	true,		"eff_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"hidden_exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtPopupEdit,			0,		daCenter,	true,		"exp_yrwk",				true,			"",		 dfUserFormat,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfFloat,			5,			true,		true);
				//ibsheet에 YYYY-WK 형식으로 format을 준다.
				InitUserFormat(0, "eff_yrwk", "####-##", "-" );
				InitUserFormat(0, "exp_yrwk", "####-##", "-" );
				InitDataCombo(0, "cust_tp_cd",  ComReplaceStr(customerTypeComboText,"ALL"," "), customerTypeComboValue);
				
				WaitImageVisible = false;
			
				
	 
				
				ColHidden("application") = true;
				
				//PopupImage(0)  =  "img/btns_search.gif";
				ImageList(0)  =  "img/btns_search.gif";
				ImageList(1)  =  "img/btns_calendar.gif";
				
				PopupButtonImage(0,"eff_yrwk")=1
				PopupButtonImage(0,"exp_yrwk")=1
				
				ShowButtonImage = 1;
				
				CountPosition = 0;
           }
           break;             
           
            case "sheet9":      // simulation 없이 download excel을 할 경우 sub-trade level까지 데이터를 조회해서
            					// download 시키는데 이때 조회용 sheet이다.
            with (sheetObj) {
                // 높이 설정
                style.height = 220;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 15, 100);

                var HeadTitle1 = "|Seq.|Contract|Approval Office|Request\nOffice|Sales Rep.|Contract No.|Customer Type|Customer Name|Eff. Date|Exp. Date|MQC\n(Target MVC)|Sub-Trade|R.Lane|Load (Performance)|Load (Performance)|Load (Performance)|Gross Revenue|Gross Revenue|Gross Revenue|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Week|Week|Week|CMPB|CMPB|CMPB|CMPB|CMPB|CMPB|CM|CM|CM|CM|CM|CM|OPB|OPB|OPB|OP|OP|OP|prop_no|is_tot|is_sub_tot";
				var HeadTitle2  = "|Seq.|Contract|Approval Office|Request\nOffice|Sales Rep.|Contract No.|Customer Type|Customer Name|Eff. Date|Exp. Date|MQC\n(Target MVC)|Sub-Trade|R.Lane|Actual|Estimate|Sum|Actual|Estimate|Sum|Actual|Actual|Actual|Estimate|Estimate|Estimate|Sum|Sum|Sum|Actual|Estimate|Sum|Actual|Actual|Estimate|Estimate|Diff(%)|Diff(%)|Actual|Actual|Estimate|Estimate|Sum|Sum|Actual|Estimate|Diff(%)|Actual|Estimate|Sum|prop_no|is_tot|is_sub_tot";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 12, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                
				InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"contract_nm",   			false,          "",      dfNone,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"prop_apro_ofc_cd",   			false,          "",      dfNone,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"prop_ofc_cd",   			false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"respb_srep_cd",   			false,          "",      dfNone,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"a_sc_no",   			false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"cust_tp_cd",   			false,          "",      dfNone,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"cust_nm",   	false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"ctrt_eff_dt",   			false,			"",      dfNone,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"ctrt_exp_dt",   			false,			"",      dfNone,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	true,		"mqc_qty",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"sub_trd_cd",   			false,			"",      dfNone,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"rlane_cd",   			false,			"",      dfNone,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"a1_load",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"e1_load",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	false,		"sum_load",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_g_rev",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"e1_g_rev",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	false,		"sum_grev",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_cost_cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_cost_cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_cost_op_office",   			false,			"",      dfNullFloat,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,			105,   	daRight,  	false,		"e1_cost_cm_office",   			false,			"",		 dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,			105,   	daRight,  	false,		"e1_cost_cm_trade",   			false,			"",		 dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,			105,   	daRight,  	false,		"e1_cost_op_office",   			false,			"",		 dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"sum_cost_cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"sum_cost_cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"sum_cost_op_office",   			false,			"",      dfNullFloat,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"a1_week_cnt",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"e1_tot_wk",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	false,		"sum_week",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"a1_cmpb_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"a1_cmpb_trade",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"e1_cmpb_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"e1_cmpb_trade",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	false,		"diff_cmpb_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	false,		"diff_cmpb_trade",   			false,          "",      dfNullFloat,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,			105,   	daRight,  	false,		"e1_cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,			105,   	daRight,  	false,		"e1_cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"sum_cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"sum_cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);

				InitDataProperty(0, cnt++ , dtData,    		80,   	daRight,  	false,		"a1_opb",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,			80,   	daRight,  	false,		"e1_opb",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	false,		"diff_opb",   			false,			"",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"a1_op",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"e1_op",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtData,    		105,   	daRight,  	false,		"sum_op",   			false,          "",      dfNullFloat,      	2,			true,       true);
				InitDataProperty(0, cnt++ , dtHidden,    			80,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtHidden,    			80,   	daCenter,  	true,		"is_tot",   			false,          "",      dfNone,      		0,			true,       true);
				InitDataProperty(0, cnt++ , dtHidden,    			80,   	daCenter,  	true,		"is_sub_tot",   			false,          "",      dfNone,      		0,			true,       true);

				CountPosition = 0;
				
				WaitImageVisible = false;

			 
           }
           break;
           
         }
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

 			case IBSEARCH:      //조회
 				setDefaultYrWk(formObj);
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				setSearchedValues(true)
   		        formObj.f_cmd.value = SEARCH;

 				var params = FormQueryString(formObj);
 				if( formObj.frm_ctrt_exp_yr.value == "" ){
 					var costYr = sheetObjects[1].CellValue(sheetObjects[1].LastRow,"cost_yr");
 					var costWk = sheetObjects[1].CellValue(sheetObjects[1].LastRow,"cost_wk");
 				    var value = valicateYearWeek(formObj.frm_ctrt_exp_yr);
 					params = ComReplaceStr(params, "frm_ctrt_exp_yr=", "");
 					params = ComReplaceStr(params, "frm_ctrt_exp_wk=", "");
 					params += "&frm_ctrt_exp_yr="+costYr;
 					params += "&frm_ctrt_exp_wk="+costWk;
 				}
 
 		 		sheetObj.SumFontColor = sheetObj.RgbColor(0,0,0);
 		 		 
 		 		
  		 		
	            //sheetObj.WaitImageVisible = false;  	
	            //sheetObjects[7].WaitImageVisible = false;  
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObjects[7].RemoveAll();

				// Backend job 실행
				var sXml = sheetObjects[7].GetSearchXml("ESM_PRI_6026GS.do", params );
				// Backend job 실행 후 그 key를 return받는다.
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey.length > 0) {
					// backend job key를 전역 변수에 저장해 둔다.
					BACKEND_JOB_ID = backendJobKey;
					// sheet의 time out 시간을 10초로 설정한다.
					sheetObjects[7].RequestTimeOut = 10000;	
					//3초마다 getBackEndJobStatus를 호출해 backend job이 끝났는지 확인한다.
					TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 후에
					// 현재 backend job이 무었에서 호출 됐는지 저장해 둔다.(IBSEARCH)
					ARRAY_BACKENDJOB_TYPE[TIMER_ID] = sAction;
																	// getBackEndJobStatus함수
																	// 실행 - 재귀호출
				}else{
					ComOpenWait(false);
				}

                break;
 			case IBSEARCH_ASYNC07:      //Excel Down Load용 조회
 			case IBSEARCH_ASYNC08:      //Excel Down Load용 조회
		        formObj.f_cmd.value = SEARCH02;

				var params = FormQueryString(formObj);
				if( sAction == IBSEARCH_ASYNC07){
					EXCEL_TP = "S";
				}else{
					EXCEL_TP = "N";
				}
		 		sheetObj.SumFontColor = sheetObj.RgbColor(0,0,0);
		        
	            //sheetObj.WaitImageVisible = false;  	
	            ComOpenWait(true);	
				sheetObj.RemoveAll();
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6026GS.do", params );
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");			
				if (backendJobKey.length > 0) {
					BACKEND_JOB_ID = backendJobKey;
					sheetObj.RequestTimeOut = 10000;
					TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 후에
					ARRAY_BACKENDJOB_TYPE[TIMER_ID] = sAction;
																	// getBackEndJobStatus함수
																	// 실행 - 재귀호출
				}else{
					ComOpenWait(false);
				}
		        
		        
		        
            break;                
 			case IBSEARCH_ASYNC05:      //주차조회
		        formObj.f_cmd.value = SEARCH01;
		        sheetObj.DoSearch("ESM_PRI_6026GS.do", FormQueryString(formObj) );
             break;
 			case IBSEARCH_ASYNC01:        //Customer Search Popup
	        	var sUrl = "ESM_PRI_6029.do?";
 				var params = new Array();  	  		
	  	  		params["cust_list"] = formObj.frm_cust_list.value;
	  	  		window.Params = params;
	
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6029", 900, 470, true);
				if( rtnVal != undefined ){
					formObj.frm_cust_list.value = rtnVal.custList;
					formObj.frm_cust_nm.value = rtnVal.custNameList;
				}
	        	break;
 			case IBSEARCH_ASYNC02:        //Simulation Popup

 				var iWidth = 825;
 				var iHeight = 430;
	        	var sUrl = "ESM_PRI_6031.do?";
 				var params = new Array();  	  		
 				//sheet에 check된 SC의 SC_NO list를 읽어 온다
	  	  		params["prop_no_list"] = getScNoList(sheetObj,"S");
	  	  		//sheet에 check된 RFA의 SC_NO list를 읽어 온다
	  	  		params["rfa_prop_no_list"] = getScNoList(sheetObj,"R");
	  	  		//year의 최소값을 조회
		  	  	params["min_ctrt_eff_yr"] = getMinMaxData(sheetObj,"cost_yr",true);
		  	  	//week의 최소값을 조회
		  	  	params["min_ctrt_eff_wk"] = getMinMaxData(sheetObj,"cost_wk",true);
		  	  	//year의 최대값을 조회
		  	  	params["max_ctrt_exp_yr"] = getMinMaxData(sheetObj,"cost_yr",false);
		  	  	//week의 최대값을 조회
		  	  	params["max_ctrt_exp_wk"] = getMinMaxData(sheetObj,"cost_wk",false);
		  	  	//조회시 사용했던 parameter 들을 simulation popup에 넘겨준다.
		  	  	params["frm_customer_type"] =formObj.searched_customer_type.value;		
		  	  	params["frm_prop_apro_ofc_cd"] = formObj.searched_prop_apro_ofc_cd.value;		
		  	  	
		  	  	params["frm_contract_type"] = formObj.searched_contract_type.value;
		  	  	params["frm_pfmc_unit"] = formObj.searched_pfmc_unit.value;
		  	  	params["frm_ctrt_eff_yr"] = formObj.searched_ctrt_eff_yr.value;
		  	  	params["frm_ctrt_eff_wk"] = formObj.searched_ctrt_eff_wk.value;
		  	  	params["frm_ctrt_exp_yr"] = formObj.searched_ctrt_exp_yr.value;
		  	  	params["frm_ctrt_exp_wk"] = formObj.searched_ctrt_exp_wk.value;
		  	  	params["frm_smr_eff_yr"] = formObj.searched_smr_eff_yr.value;
		  	  	params["frm_smr_eff_wk"] = formObj.searched_smr_eff_wk.value;
		  	  	params["frm_smr_exp_yr"] = formObj.searched_smr_exp_yr.value;
		  	  	params["frm_smr_exp_wk"] = formObj.searched_smr_exp_wk.value;
		  	  	params["frm_rfrc_eff_yr"] = formObj.searched_rfrc_eff_yr.value;
		  	  	params["frm_rfrc_eff_wk"] = formObj.searched_rfrc_eff_wk.value;
		  	  	params["frm_rfrc_exp_yr"] = formObj.searched_rfrc_exp_yr.value;
		  	  	params["frm_rfrc_exp_wk"] = formObj.searched_rfrc_exp_wk.value;
		  	  	params["frm_prop_ofc_cd"] = formObj.searched_prop_ofc_cd.value;
		  	  	params["frm_prop_srep_cd"] = formObj.searched_prop_srep_cd.value;
		  	  	params["frm_prop_srep_nm"] = formObj.searched_prop_srep_nm.value;
		  	  	
		  	  	params["frm_trd_cd"] = formObj.searched_trd_cd.value;
			  	params["frm_dir_cd"] = formObj.searched_dir_cd.value;
			  	params["frm_sub_trd_cd"] = formObj.searched_sub_trd_cd.value;
			  	params["frm_rlane_cd"] = formObj.searched_rlane_cd.value;
			  	
			  	params["frm_ori_rout_cd"] = formObj.searched_ori_rout_cd.value;
			  	params["frm_ori_loc_tp"] = formObj.searched_ori_loc_tp.value;
			  	params["frm_dest_rout_cd"] = formObj.searched_dest_rout_cd.value;
			  	params["frm_dest_loc_tp"] = formObj.searched_dest_loc_tp.value;
			  	
			  	params["min_yrwk"] = getCurrentYrWk();
			  	params["max_yrwk"] = formObj.searched_smr_exp_yr.value + formObj.searched_smr_exp_wk.value;
	  	  		window.Params = params;
	        	

 
	 			var leftpos = (screen.width - iWidth) / 2;
	
				if (leftpos < 0)
					leftpos = 0;
				var toppos = (screen.height - iHeight) / 2;
				if (toppos < 0)
					toppos = 0;
				
				var simulSheet = new Array();
				simulSheet[0] = sheetObjects[2];
				simulSheet[1] = sheetObjects[3];
				simulSheet[2] = sheetObjects[4];
				simulSheet[3] = sheetObjects[5];
				simulSheet[4] = sheetObjects[6];
				window.SheetObj = sheetObjects[0];
				window.WeekSheetObj = sheetObjects[1];
				window.SimulSheetObj = simulSheet;
				
				
				
	 			var rtnVal = ComOpenWindow(sUrl, "ESM_PRI_6031",
						"scroll:auto;status:no;help:no;dialogWidth:" + iWidth
								+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
								+ leftpos + ";dialogTop:" + toppos, true);
	 			
	 			if ( rtnVal != undefined ){
	 				if( rtnVal.code == "SIMULATION"){
	 					formObj.is_simulation.value = "Y";
	 					
	 				}
	 			}
	 			// simulation popup에서 simulation된 cell의 color를 red로 변경하는데,
	 			// cell의 font color를 변경할 경우 total row의 color도 같이 바뀌는 버그 때문에
	 			// cell의 font color 변경 후 total row의 color를 검정색으로 다시 바꿔준다.
	 			changeSheetSumFontColor(sheetObj);
	 			
	        	break;
 			case IBSEARCH_ASYNC03:        //Revenue Detail Popup

	        	var sUrl = "ESM_PRI_6053.do?";
	        	 
				sUrl +="frm_pfmc_unit="       + formObj.searched_pfmc_unit.value;

 
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6053", 1000, 450, false);

        	break;
        	
        	
 			case IBSEARCH_ASYNC04:        //Chart

        	var sUrl = "ESM_PRI_6027.do?";
        	 
			sUrl +="&frm_pfmc_unit="       + formObj.searched_pfmc_unit.value;
			sUrl +="&frm_profit_view=" + formObj.frm_profit_view.Code;
			sUrl +="&frm_profit_level=" + formObj.frm_profit_level.Code;
			sUrl +="&frm_contract_type=" + formObj.searched_contract_type.value;
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6027", 1000, 748, false);
			break;
			
 			case IBSEARCH_ASYNC06:        //RLane

        	var sUrl = "ESM_PRI_6055.do?";
        	 
			sUrl +="&trd_cd="       + formObj.frm_trd_cd.Code;
			sUrl +="&sub_trd_cd=" + formObj.frm_sub_trd_cd.Code;
			sUrl +="&revCdList="+formObj.frm_rlane_cd.value;
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6055", 500, 365, true);
			if( rtnVal != undefined ){
				formObj.frm_rlane_cd.value = rtnVal.cd;
			}
			break;			
	
			
 			case IBSEARCH_ASYNC10:        //origin popup
 			/* location_cmd parameter 값에 따라 popup에서 선택할수 있는 radio button이 달라진다.
 	 		 * "LGTCR"
 			 L:Location
 			 G:Group Location
 			 T:State
 			 C:Country
 			 R:Region
 	 		 */
				if(!validateForm(sheetObj,formObj,sAction)) return;
 	 		 var formObj = document.form;
 	 		 var frm_trd_cd = formObj.frm_trd_cd.Code;
 		 
 		 	 var sUrl = "ESM_PRI_4026.do?"  
 			 sUrl += "&group_cmd=" + PRI_SP_SCP; 
 		 	 
 		 	 if( isUSArea( )){
 		 		sUrl += "&location_cmd=RC";
 		 		sUrl += "&loc_tp_cd=C"; 	  	  		 
 		 	 }else{
 		 		sUrl += "&location_cmd=C";
 		 		sUrl += "&loc_tp_cd=C";
 		 	 }
 		 	// Please input region code only for US.
 		 		
 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 			if (rtnVal != null){
 				formObj.frm_ori_rout_cd.value = rtnVal.cd;
 				formObj.frm_ori_loc_tp.value = rtnVal.tp;
 				if( !validateRoute(rtnVal.cd,"POPUP" ) ){
 					formObj.frm_ori_rout_cd.value = "";
 					formObj.frm_ori_loc_tp.value = "";
 				}
 			} 	  
			break;
			case IBSEARCH_ASYNC11:        //dest popup
 			/*
 	 		 * "LGTCR"
 			 L:Location
 			 G:Group Location
 			 T:State
 			 C:Country
 			 R:Region
 	 		 */
			 if(!validateForm(sheetObj,formObj,sAction)) return;
 	 		 var formObj = document.form;
 	 		 var frm_trd_cd = formObj.frm_trd_cd.Code;
 		 
 		 	 var sUrl = "ESM_PRI_4026.do?"  
 			 sUrl += "&group_cmd=" + PRI_SP_SCP; 
 		 	 
 		 	 if(isUSArea( )){
 		 		sUrl += "&location_cmd=RC";
 		 		sUrl += "&loc_tp_cd=C"; 	  	  		 
 		 	 }else{
 		 		sUrl += "&location_cmd=C";
 		 		sUrl += "&loc_tp_cd=C";
 		 	 }
 		 	// Please input region code only for US.
 		 		
 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 			if (rtnVal != null){
 				formObj.frm_dest_rout_cd.value = rtnVal.cd;
 				formObj.frm_dest_loc_tp.value = rtnVal.tp;
 				//선택한 route가 정상적인지 검사한다.
 				if( !validateRoute(rtnVal.cd,"POPUP"  ) ){
 					//비정상 route라면 선택한 값을 지운다.
 					formObj.frm_dest_rout_cd.value = "";
 					formObj.frm_dest_loc_tp.value = "";
 				}
 			} 	   			
			break;
			
			
 			
         }
     }
   
 
	 
	 
    /** 
     * sheet의 모든 SC number list를 '|'연결한 string을 만든다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      params["sc_no_list"] = getScNoList(sheetObj); //결과 "AWN25607|AEF25900|AEF25903|AEF25905"
	 * </pre>
	 * 
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string] Code Type 필수, S : SC, R : RFA
	 * @return string, sheet의 모든 SC number list를 '|'연결한 string
	 */    
   function getScNoList(sheetObj, dataTpCd ){
	   var list = "";	   
	   var checkRow = sheetObj.FindCheckedRow("sel_chk");
	   var arrRow = checkRow.split("|");
	   var cnt = 0;
	   var dataTpNm= "";
	   if( dataTpCd == "S"){
		   dataTpNm = "SC";
	   }else if(dataTpCd == "R"){
		   dataTpNm = "RFA";
	   }
	   for( var i = 0  ; i < arrRow.length - 1; i++ ){
		   if( dataTpNm ==  sheetObj.CellValue(arrRow[i] , "contract_nm")){
		   	   if( cnt != 0 ){
		   		   list += "|";
		   	   } 
		   	   cnt++;
		   	   list += sheetObj.CellValue(arrRow[i] , "a_sc_no");
		   }
	   }
	   return list;
   }
   
   
   
   
   /** 
     * sheet의 특정 컬럼의 최고 또는 최저값을 구한다.<BR>
	 * <br><b>Example :</b>
	 * <pre>
	 *      params["min_ctrt_eff_dt"] = getMinMaxData(sheetObj,"ctrt_eff_dt",true);  //결과 "200910"
	 * 	  	params["max_ctrt_exp_dt"] = getMinMaxData(sheetObj,"ctrt_exp_dt",false); //결과 "200953"
	 * </pre>
	 * 
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string} col 필수, 최고,최저값을 구하고자하는 column name
	 * @param {boolean} isMin 필수, true: 최저값, false 최고값
	 * 
	 * @return string, 최고값 또는 최저값
	 */     
   function getMinMaxData(sheetObj,col,isMin){
	   var value = "";
	   var currValue = "";
	   // 해당 sheet의 값은 year week로 sort 되어 있기 때문에 
	   // 첫 row, 마지막 row값이 min,max가 된다.
	   if( isMin == true){
		   value = sheetObj.CellValue(sheetObj.HeaderRows,col);
	   }else{
		   value = sheetObj.CellValue(sheetObj.LastRow,col);
	   }
	   
	   return value;
   }
   
   /**  
    * Combo에서 필요한 코드를 조회해서 Combo에 Assign한다.<BR>
    * 화면에 Setting 해 놓는다.
    *  
    * <br><b>Example :</b>
    * <pre>
    *   initCombo();
    * </pre>
    * 
    * @return 없음
    */        
   function initCombo(){
       var formObj = document.form;
       formObj.frm_summary_items.MultiSelect = true;

 
       summaryComboForCmText.replace("OP","");
        
       // Profit Level이 CM일때는 Summary Items에 OP,OPB를 표시 하지 않는다. 
       summaryComboForCmText= ComReplaceStr(summaryComboForCmText,"|B	OPB|O	OP","");  
       summaryComboForCmValue= ComReplaceStr(summaryComboForCmValue,"|B|O","");  
 
       // customer type에 BOTH를 white space로 표현 해달라는 요구 때문에 replace
       customerTypeComboValue = ComReplaceStr(customerTypeComboValue,"|M",""); 
       customerTypeComboText = ComReplaceStr(customerTypeComboText,"|M	BOTH","");  
       
	   ComPriTextCode2ComboItem("|"+appOfcCdComboValue,"	|"+appOfcCdComboText, formObj.frm_prop_apro_ofc_cd ,"|","\t",0 );
	   
	   ComPriTextCode2ComboItem(profitViewComboValue,profitViewComboText, formObj.frm_profit_view ,"|","\t",1 );
	   ComPriTextCode2ComboItem(cmOpComboValue,cmOpComboText, formObj.frm_profit_level ,"|","\t" ,1);
	   ComPriTextCode2ComboItem("M|"+customerTypeComboValue,"\t|"+customerTypeComboText, formObj.frm_customer_type ,"|","\t",0 );
	   ComPriTextCode2ComboItem(summaryComboForCmValue,summaryComboForCmText, formObj.frm_summary_items,"|","\t",1);
	   
	   ComPriTextCode2ComboItem("|"+tradeCodeComboValue ," |"+tradeCodeComboValue , formObj.frm_trd_cd,"|","\t",1);
	   ComPriTextCode2ComboItem("|"+ComReplaceStr(boundCodeComboValue,"|A","")  ," |"+ComReplaceStr(boundCodeComboValue,"|A","")   , formObj.frm_dir_cd,"|","\t",1);

	   
	   
	   formObj.frm_profit_view.Index = 1;
	   formObj.frm_profit_level.Index = 0;
	   formObj.frm_summary_items.Index = 0;

 
	   formObj.frm_summary_items.DropHeight = 200 

	   with(formObj.frm_sub_trd_cd){
		   SetColWidth("50|150");
	   }

	   with(formObj.frm_prop_apro_ofc_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
		   	SetColWidth("100");
	   }
	   with(formObj.frm_dir_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
		   	SetColWidth("40");
	   }
	   with(formObj.frm_trd_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
		   	SetColWidth("100");
	   }
	   with(formObj.frm_sub_trd_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
		   	SetColWidth("50|250");
	   }
	   
	   with(formObj.frm_prop_srep_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
            IMEMode = 0;
            ValidChar(2, 1);
            MaxLength = 5;
            
	   }
   }
   
   /**  
   * Request Office 값을 이용해 Sales Rep.을 조회함 
   *  
   * <br><b>Example :</b>
   * <pre>
   *   searchSalesRepOffice();
   * </pre>
   * 
   * @return 없음
   */   
   function searchSalesRepOffice(){
       var formObj = document.form;
       var cd = formObj.frm_prop_ofc_cd.value;
       var sheetObj = sheetObjects[1];
       formObj.f_cmd.value = SEARCH15;
       var sParam = FormQueryString(formObj)+"&etc1="+cd;
       sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
       ComPriXml2ComboItem(sXml, formObj.frm_prop_srep_cd, "cd", "cd|nm");
       formObj.frm_prop_srep_cd.InsertItem(0,"","")
       formObj.frm_prop_srep_cd.focus();
   }
   
   /**  
   * trade code에 따라 해당 code 속하는 sub trade를 조회한다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   searchSubTrade(obj.Code);
   * </pre>
   * @param {string} trdCd 필수, trade code 
   * @return 없음
   */     
   function searchSubTrade(trdCd){
       var formObj = document.form;
       var sheetObj = sheetObjects[1];
       if( trdCd != "" ){
	       formObj.f_cmd.value = SEARCH18;
	       var sParam = FormQueryString(formObj)+"&etc1="+trdCd;
	       sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
	       ComPriXml2ComboItem(sXml, formObj.frm_sub_trd_cd, "cd", "cd|nm");
	       formObj.frm_sub_trd_cd.InsertItem(0,"","");
       }else{
    	   formObj.frm_sub_trd_cd.RemoveAll();
    	   formObj.frm_rlane_cd.value = "";
       }
   }
   
   

   /**  
   *  Summary Item의 값에 따라 sheet의 특정필드들을 가변적으로 보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   changeColHidden(formObj.frm_summary_items,sheetObjects[0]);
   * </pre>
   * @param {object} comboObj 필수, Summary Item IBMultiCombo Object
   * @param {object} sheetObj 필수, sheet Object
   * @return 없음
   */    
   function changeColHidden(comboObj,sheetObj){
	   var formObj = document.form;
	   var codes = comboObj.Code;
	   var arrCodes = codes.split(",")
	   var code="";
	   var colList = new Array( );
	   var profit_view = formObj.frm_profit_view.Code;
	   var profit_level = formObj.frm_profit_level.Code;
	   
	   
	   hideColumnsRange(sheetObj,"a1_load","sum_op");
	   
	   if( arrCodes.length == 0) return;
		var summaryComboForCmValue = "A|L|R|T|W|P|C|B|O";		
		var summaryComboForCmText = "A	All|L	Load|R	G.Revenue|T	Cost|W	Week|P	CMPB|C	CM|B	OPB|O	OP";
		
		

	   colList["L"] = "a1_load|e1_load|sum_load"; //Load
	   colList["R"] = "a1_g_rev|e1_g_rev|sum_grev"; //GREVENUE
	   colList["W"] = "a1_week_cnt|e1_tot_wk|sum_week";//WEEK
	   if(profit_level== "C" ){ //CM
		   if( profit_view == "P"){ // Trade Profit
			   colList["T"] = "a1_cost_cm_trade|e1_cost_cm_trade|sum_cost_cm_trade"; //COST
			   colList["P"] = "a1_cmpb_trade|e1_cmpb_trade|diff_cmpb_trade";//CMPB
			   colList["C"] = "a1_cm_trade|e1_cm_trade|sum_cm_trade"; //CM
			   colList["B"] = "";  //OPB
			   colList["O"] = ""; //OP
		   }else{ //"R" Office Profit
			   colList["T"] = "a1_cost_cm_office|e1_cost_cm_office|sum_cost_cm_office"; //COST
			   colList["P"] = "a1_cmpb_office|e1_cmpb_office|diff_cmpb_office"; //CMPB
			   colList["C"] = "a1_cm_office|e1_cm_office|sum_cm_office";  //CM
			   colList["B"] = ""; //OPB
			   colList["O"] = ""; //OP
		   }
	   }else{//OP
		   if( profit_view == "P"){ // Trade Profit
			   	colList["P"] = "a1_cmpb_trade|e1_cmpb_trade|diff_cmpb_trade";//CMPB
		   		colList["C"] = "a1_cm_trade|e1_cm_trade|sum_cm_trade"; //CM
		   }else{ //"R" Office Profit
			   	colList["P"] = "a1_cmpb_office|e1_cmpb_office|diff_cmpb_office"; //CMPB
		   		colList["C"] = "a1_cm_office|e1_cm_office|sum_cm_office";  //CM
			   
		   }
		   colList["T"] = "a1_cost_op_office|e1_cost_op_office|sum_cost_op_office"; //COST
		   colList["B"] = "a1_opb|e1_opb|diff_opb"; //OPB
		   colList["O"] = "a1_op|e1_op|sum_op"; //OP
	   }
	   
	   if( arrCodes[0] == "A"){
		   //var cnt = comboObj.GetCount();
		   var colNameList;
		   if( profit_level == "C"){
			   colNameList = summaryComboForCmValue
		   }else{
			   colNameList = summaryComboForOpValue
		   }
		   colNameList = colNameList.split("|");
		   var cnt = colNameList.length

		   for(var i = 0 ; i < cnt ; i++){
			   var name = colNameList[i];
			   if( name == "ALL ") continue;
			   showColumns(sheetObj,colList[name]);
		   }		   
	   }else{
		   for(var i = 0 ; i < arrCodes.length ; i++){
			   code = arrCodes[i];
			   showColumns(sheetObj,colList[code]);
		   }
	   }
   }
   /**  
   *  Summary Item의 값에 따라 sheet의 특정필드들을 가변적으로 보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   hideColumnsRange(sheetObjects[0],"load_previous","op_diff");
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} col1 필수, 숨기고 싶은 column의 시작 culumn name
   * @param {string} col2 필수, 숨기고 싶은 column의 마지막 culumn name
   * @return 없음
   */  
   function hideColumnsRange(sheetObj,col1,col2){
	   var startCol ;
	   var endCol;
	   if( !col1.isNumber() ){
		   startCol = sheetObj.SaveNameCol(col1);
	   }else{
		   startCol = col1;
	   }
	   
	   if( !col2.isNumber() ){
		   endCol = sheetObj.SaveNameCol(col2);
	   }else{
		   endCol = col2;
	   }
	   for( var i = startCol ; i <= endCol ; i ++){
		   sheetObj.ColHidden(i) = true;
	   }	   
   }

   
   /**  
   *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
   *  보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   showColumns(sheetObject1, "cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 보여주고 싶은 column을 '|'로 연결한 string
   * @return 없음
   */         
   function showColumns(sheetObj, strColList ){
	   showHideColumns(sheetObj, strColList,false )
   }
   
   
   /**  
   *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
   *  숨긴다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   hideColumns(sheetObject1, "cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 숨기고 싶은 column을 '|'로 연결한 string
   * @return 없음
   */       
   function hideColumns(sheetObj, strColList ){
	   showHideColumns(sheetObj, strColList,true )
   }
   
   /**  
   *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
   *  flg값에 따라 보여주거나 숨긴다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   showHideColumns(sheetObject1, "cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt",false ); // 해당 컬럼들을 보여준다.
   *   showHideColumns(sheetObject1, "cust_tp_cd|contract_nm|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt",true ); // 해당 컬럼들을 숨긴다.
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 숨기고 싶은 column을 '|'로 연결한 string
   * @param {boolean} flg 필수, true: 숨김, false : 보여줌
   * @return 없음
   */     
   function showHideColumns(sheetObj, strColList,flg ){
	   if( strColList == undefined) return;
	   if( strColList == "" ) return;
	   var arrColList = strColList.split("|");
	   for( var i = 0 ; i < arrColList.length ; i ++){
		   sheetObj.ColHidden(arrColList[i]) = flg;
	   }
   }   
   
   
   /**  
   *  년,주차에 값이 입력되지 않았을 경우 default 값을 넣어준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   setDefaultYrWk(formObj);
   * </pre>
   * 
   * @param {object} formObj 필수, HTML Document Form Object
   * @return 없음
   */    
   function setDefaultYrWk(formObj){
 	  var currYrWk = getCurrentYrWk();
	  var currYr = currYrWk.substring(0,4);
	  var currWk = currYrWk.substring(4,6);
 	  var beforeYrWk = getBeforeThisYrWk();
	  var beforeYr = beforeYrWk.substring(0,4);
	  var beforeWk = beforeYrWk.substring(4,6);	  
	  
	  
	  var sheetObj = sheetObjects[1];

	  if( formObj.frm_smr_exp_yr.value == "" 
		  && formObj.frm_smr_exp_wk.value == "" ){
		  var ctrt_exp_dt = document.getElementById("ctrt_exp_date_name").innerHTML
		  if( ctrt_exp_dt != "" 
			  && currYr + currWk > formObj.frm_ctrt_exp_yr.value  + formObj.frm_ctrt_exp_wk.value
			    ){
			  formObj.frm_smr_exp_yr.value = formObj.frm_ctrt_exp_yr.value;
			  formObj.frm_smr_exp_wk.value = formObj.frm_ctrt_exp_wk.value;
		  }else{
			  formObj.frm_smr_exp_yr.value = currYr;
			  formObj.frm_smr_exp_wk.value = currWk;
		  }
	      var value = valicateYearWeek(formObj.frm_smr_exp_yr);
	      changeDateText("smr_exp_date_name",value["DATE_TEXT"]);  
	  }	  
	  if(formObj.frm_rfrc_exp_yr.getAttribute("className") == "input1"
		  && formObj.frm_rfrc_exp_yr.value == "" 
		  && formObj.frm_rfrc_exp_wk.value == "" ){
		  formObj.frm_rfrc_exp_yr.value = beforeYr;
		  formObj.frm_rfrc_exp_wk.value = beforeWk;
	      var value = valicateYearWeek(formObj.frm_rfrc_exp_yr);
	      changeDateText("rfrc_exp_date_name",value["DATE_TEXT"]);  
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
     	  switch(sAction){
    	  case IBSEARCH :
	    		//1. 필수 입력 체크
	    		//2. 날짜의 입력 범위체크 
	    		if( formObj.frm_ctrt_eff_yr.value == "" 
	    			|| formObj.frm_ctrt_eff_wk.value == "" ){
					ComShowCodeMessage("PRI00316","Contract");
					return false;
	    		}
	    		if( formObj.frm_smr_eff_yr.value == "" 
	    			|| formObj.frm_smr_eff_wk.value == "" ){
					ComShowCodeMessage("PRI00316","Summary");
					return false;
	    		}    
	    		if( formObj.frm_rfrc_eff_yr.getAttribute("className") == "input1"
	    			&& ( formObj.frm_rfrc_eff_yr.value == ""  || formObj.frm_rfrc_exp_yr.value == "" ) ){
					ComShowCodeMessage("PRI00316","Reference");
					return false;
	    		} 
	    		if( formObj.frm_trd_cd.Code == "" ) {
					ComShowCodeMessage("PRI00316","Trade");
					return false;
	    		}     
	    		if( formObj.frm_dir_cd.Code == ""  ){
					ComShowCodeMessage("PRI00316","Bound");
					return false;
	    		}        		
	    		
	    		//contract의 날짜 검사
	    		var ctrt_eff_dt = document.getElementById("ctrt_eff_date_name").innerHTML
	    		var ctrt_exp_dt = document.getElementById("ctrt_exp_date_name").innerHTML
	    		ctrt_eff_dt = ctrt_eff_dt.replace(/\/|\-|\./g,"");
	    		ctrt_exp_dt = ctrt_exp_dt.replace(/\/|\-|\./g,"");
	    		//contract의 expired date를 입력하지 않으면 전체 범위가 default임
	    		if(ctrt_exp_dt == "" ){
	    			ctrt_exp_dt = "29991231";
	    		}
	    		// effective date가 expired date보다 큰지 검사.
	    		if( ComChkPeriod(ctrt_eff_dt, ctrt_exp_dt) < 1){
	    			ComShowCodeMessage("PRI00306");
	    			formObj.frm_ctrt_eff_yr.focus();
					return false;
	    		}
 
	    		//summary
	    		var smr_eff_dt = document.getElementById("smr_eff_date_name").innerHTML
	    		var smr_exp_dt = document.getElementById("smr_exp_date_name").innerHTML
	    		smr_eff_dt = smr_eff_dt.replace(/\/|\-|\./g,"");
	    		smr_exp_dt = smr_exp_dt.replace(/\/|\-|\./g,"");
	    		// effective date가 expired date보다 큰지 검사.
	    		if( ComChkPeriod(smr_eff_dt, smr_exp_dt) < 1){
	    			ComShowCodeMessage("PRI00306");
	    			formObj.frm_smr_eff_yr.focus();
					return false;
	    		}
	    		
	    		//reference
	    		var rfrc_eff_dt = document.getElementById("rfrc_eff_date_name").innerHTML
	    		var rfrc_exp_dt = document.getElementById("rfrc_exp_date_name").innerHTML
	    		rfrc_eff_dt = rfrc_eff_dt.replace(/\/|\-|\./g,"");
	    		rfrc_exp_dt = rfrc_exp_dt.replace(/\/|\-|\./g,"");
	    		// effective date가 expired date보다 큰지 검사.
	    		if( ComChkPeriod(rfrc_eff_dt, rfrc_exp_dt) < 1){
	    			ComShowCodeMessage("PRI00306");
	    			formObj.frm_rfrc_eff_yr.focus();
					return false;
	    		}
	    		// contract의 입력범위에 summary date는 포함 되어야 한다.
	    		if(ctrt_eff_dt > smr_eff_dt || ctrt_exp_dt < smr_exp_dt){
	    			//[Summary] date should be included in [Contract] period.
	    			ComShowCodeMessage("PRI03011","Summary","Contract");  
	    			formObj.frm_smr_eff_yr.focus();
					return false;
	    		}
	    		var curr_dt = getCurrentEffDt();
	    		curr_dt = curr_dt.replace(/\/|\-|\./g,"");
	    		// reference effective date는 summary effective date보다커야 하고
	    		// reference expired date는 현재 날짜 보다 커야 한다.
	    		if(rfrc_eff_dt != "" && (smr_eff_dt > rfrc_eff_dt || curr_dt < rfrc_exp_dt)){
	    			ComShowCodeMessage("PRI03012");  
	    			formObj.frm_rfrc_eff_yr.focus();
					return false;
	    		}	    		
	    		
	    		
	    		break;
    	  case IBSEARCH_ASYNC10:
    	  case IBSEARCH_ASYNC11:
    	  case IBSEARCH_ASYNC03:
	      	  if( formObj.frm_trd_cd.Code == "" ){
					ComShowCodeMessage("PRI03028");
					return false;
	    	  }
    		  break;	    		
	    		
    	  }

         return true;
     }	


    /**  
     * 화면에서 Key가 눌렸을경우의 이벤트처리
     *  
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @return 없음
     */     
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            default:
        }
    }    

    
    /**  
    * frm_prop_ofc_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_prop_ofc_cd_OnChange(){
 		
 		clearPropSrepNm ();
 		searchSalesRepOffice();
 	}
    /**  
    * Sales Rep.의 값을 null로 만듦.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */    	
 	function clearPropSrepNm(){
 		document.form.frm_prop_srep_nm.value="";
 	}
    /**  
    * frm_prop_srep_cd에서 focus를 잃었을 경우의 이벤트처리
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @return 없음
    */  
    function frm_prop_srep_cd_OnBlur(comboObj) {
    	//changeSrepText(comboObj);
    }   

    /**  
    * frm_prop_srep_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @return 없음
    */   
    function frm_prop_srep_cd_OnChange(comboObj,code,text) {
        var formObj = document.form;
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.frm_prop_srep_nm.value = comboObj.GetText(code, 1);
    	}
    }   
    /**  
    * Combo에서 Sales Rep. 이름을 읽어 화면에 표시 해줌<BR>
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @return 없음
    */       
    function changeSrepText(comboObj){
 
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var text = comboObj.GetText(comboObj.Code,1);
        formObj.frm_prop_srep_nm.value = text;
        
        
    }

    /** 
    * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} row 필수, 수정된 row
    * @param {String} col 필수, 수정된 col
    * @param {String} value 필수, 수정된 value
    * @return 없음
    */   
    function sheet1_OnChange(sheetObj,row,col,value){
   	 
  		switch(sheetObj.ColSaveName(col)){
 		case "sel_chk" :
 			 var checkRow = sheetObj.FindCheckedRow(col);
 			 var arrRow = checkRow.split("|");
 			 var flg = ComIsBtnEnable("btn1_Simulation");
 			 if( arrRow.length == 1 ){
 				if( flg == true )
 					ComBtnDisable("btn1_Simulation");
 			 }else{
 				if( flg == false && document.form.searched_contract_type_t.value == "")
 					ComBtnEnable("btn1_Simulation");
 			 }
 			break;
 		}
 
     }
    
    /** 
    * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} ErrMsg 필수, sheet의 결과 메시지
    * @return 없음
    */     
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	// sheet의 모든 row을 check한다.
    	sheetObj.CheckAll2("sel_chk") = 1;
    	// total row의 'Total' Text를 변경한다.
    	mergeTotalLine(sheetObj);
    	// 조회시 사용한 조회 조건들을 저장해 둔다.
 		setSearchedValues(false);
 		// 버튼의 상태를 바꾼다.
		changeButtonStatus();
		// Contract No.의 색깔을 link에 맞게 파란색으로 바꾸고 밑줄을 긋는다.
 		sheetObj.ColFontColor("a_sc_no") = sheetObj.RgbColor(100,100,255);
 		sheetObj.ColFontUnderline("a_sc_no") = true;
 		// total의 내용중 diff, cmpb 값은 단순 sum이 아니기 때문에 
 		// 계산에 의해서 바꿔준다.
 		changeSheetSumValues(sheetObj);
     }
    
    /** 
    * IBSheet Bug로 인해 sum row의 font color를 변경시켜줘야 한다.
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @return 없음
    */        
    function changeSheetSumFontColor(sheetObj){
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_load") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_g_rev") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_cost_cm_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_cost_cm_trade") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_cost_op_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_cmpb_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_cmpb_trade") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_cm_trade") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_opb") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"e1_op") = sheetObj.RgbColor(37,35,65);//sum font color
    }
    
    /** 
    * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} ErrMsg 필수, sheet의 결과 메시지
    * @return 없음
    */     
 	function sheet8_OnSearchEnd(sheetObj, ErrMsg){
    	mergeTotalLine(sheetObj);
 		changeSheetSumValues(sheetObj);
     }    
 	
    /** 
    * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} ErrMsg 필수, sheet의 결과 메시지
    * @return 없음
    */     
 	function sheet9_OnSearchEnd(sheetObj, ErrMsg){
    	mergeTotalLine(sheetObj);
 		setSearchedValues(false);
 		sheetObj.ColFontColor("a_sc_no") = sheetObj.RgbColor(100,100,255);
 		sheetObj.ColFontUnderline("a_sc_no") = true;
 		//조회된 결과의 total row의 week값을 계산한다.
 		calcBottomWeekForDownExcel(sheetObj);
 		if(sheetObj.RowCount > 0){
 			// download excel도 backend job으로 되어 있는데 
 			// 사용자가 quick모드를 선택 했는지 standard를 선택했는지에 따라
 			// 조회된 결과를 다르게 엑셀로 내려준다.
  			if( EXCEL_TP == "S" ){
 				sheetObj.SpeedDown2Excel(-1, false, false,"","",false,false,getSheetNameOfExcel(""));
 			}else{
 				sheetObj.Down2Excel(-1, false, false,true,"","",false,false,getSheetNameOfExcel(""));
 			}
 		}
     }    	
 
    /** 
    * sheet의 total line의 total text 부분을 merge한다. 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @return 없음
    */   
    function mergeTotalLine(sheetObj){
		sheetObj.SumText(0, "seq") = "";
		sheetObj.SumText(0, "cust_nm") = "Total";
    }    
    /** 
    * CMPB,CM,REVEVNUE는 단순 SUM으로 계산하면 안되기 때문에<BR>
    * sheet의 내용이 변경된 후 Sum Row에 일부 컬럼의 Sum값을 재 계산한다<BR>
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		changeSheetSumValues(sheetObj);
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * 
    * @return 없음
    */       
 	function changeSheetSumValues(sheetObj){
 		//Week 평균값을 보여준다.
 	
 		var COL_A_LOD = "a1_load";
 		var COL_A_CM_OFFICE = "a1_cm_office";
 		var COL_A_CMPB_OFFICE = "a1_cmpb_office";
 		var COL_A_CM_TRADE = "a1_cm_trade";
 		var COL_A_CMPB_TRADE = "a1_cmpb_trade"; 
 		var COL_E_LOD = "e1_load";
 		var COL_E_CM_OFFICE = "e1_cm_office";
 		var COL_E_CMPB_OFFICE = "e1_cmpb_office";
 		var COL_E_CM_TRADE = "e1_cm_trade";
 		var COL_E_CMPB_TRADE = "e1_cmpb_trade"; 	 
 		
 		var COL_DIFF_CMPB_OFFICE = "diff_cmpb_office"; 	 
 		var COL_DIFF_CMPB_TRADE = "diff_cmpb_trade"; 	 
 		var COL_A_WK = "a1_week_cnt"
 		var COL_E_WK = "e1_tot_wk"
 		var COL_S_WK = "sum_week"
 			
 	 	var COL_A_OP = "a1_op";
 		var COL_A_OPB = "a1_opb"; 
 	 	var COL_E_OP = "e1_op";
 		var COL_E_OPB = "e1_opb"; 	
 		var COL_DIFF_OPB = "diff_opb"; 	
 		//OP ( total row의 cmpb/opb/diff는 단순 sum이 아니기 때문에  재 계산한다.)
 		calcBottomCmpbOpb(sheetObj,COL_A_LOD,COL_A_OP,COL_A_OPB);
 		calcBottomCmpbOpb(sheetObj,COL_E_LOD,COL_E_OP,COL_E_OPB);
 		calcBottomDiffCmpbOpb(sheetObj,COL_A_OPB,COL_E_OPB,COL_DIFF_OPB);
 		
 		//CM( total row의 cmpb/opb/diff는 단순 sum이 아니기 때문에  재 계산한다.)
 		calcBottomCmpbOpb(sheetObj,COL_A_LOD,COL_A_CM_OFFICE,COL_A_CMPB_OFFICE);
 		calcBottomCmpbOpb(sheetObj,COL_A_LOD,COL_A_CM_TRADE,COL_A_CMPB_TRADE);
 		calcBottomCmpbOpb(sheetObj,COL_E_LOD,COL_E_CM_OFFICE,COL_E_CMPB_OFFICE);
 		calcBottomCmpbOpb(sheetObj,COL_E_LOD,COL_E_CM_TRADE,COL_E_CMPB_TRADE);
		calcBottomDiffCmpbOpb(sheetObj,COL_A_CMPB_OFFICE,COL_E_CMPB_OFFICE,COL_DIFF_CMPB_OFFICE);
 		calcBottomDiffCmpbOpb(sheetObj,COL_A_CMPB_TRADE,COL_E_CMPB_TRADE,COL_DIFF_CMPB_TRADE);
 		calcBottomWeek(sheetObj,COL_A_WK)	;
 		calcBottomWeek(sheetObj,COL_E_WK)	;
 		calcBottomWeek(sheetObj,COL_S_WK)	;
 	}
   
 	
    /** 
    * Week는 단순 SUM으로 계산하면 안되기 때문에<BR>
    * sheet의 내용이 변경된 후 week를 재 계산한다<BR>
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		calcBottomWeek(sheetObj,COL_NEW_WK)	;
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {string} COL_WK 필수, week 컬럼명
    * 
    * @return 없음
    */   
    function calcBottomWeek(sheetObj,COL_WK){
	   var rowCnt =  getNotNullCellRowCount( sheetObj, COL_WK); 
   	   var wk =  eval(sheetObj.SumValue(0,COL_WK));
   	   var rslt = 0;
   	   if( rowCnt == 0 ){
   		   return;
   	   }else{
   		   rslt = wk / rowCnt;
   	   }
   	   sheetObj.SumValue(0,COL_WK) = rslt;
    }
    
    /** 
    * 특정 컬럼에 null이 아닌 데이터가 몇 row가 있는지 count한다.
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		rowCnt =  getNotNullCellRowCount( sheetObj, COL_WK); 
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {string} COL_NM 필수, count할 컬럼명
    * 
    * @return int, not null인 row의 count 수
    */   
    function getNotNullCellRowCount(sheetObj, COL_NM){
    	var iCnt = 0;
    	var headRow = sheetObj.HeaderRows;
    	for(var i = 0 ; i < sheetObj.RowCount ; i++){
    		if(sheetObj.CellValue(i+headRow,COL_NM) != "" ){
    			iCnt++;
    		}
    	}
    	return iCnt;
    }
        
    /** 
    * Download Excel용 Week는 단순 SUM으로 계산하면 안되기 때문에<BR>
    * sheet의 내용이 변경된 후 week를 재 계산한다<BR>
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		calcBottomWeekForDownExcel(sheetObj,COL_NEW_WK)	;
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * 
    * @return 없음
    */    	
    function calcBottomWeekForDownExcel(sheetObj){
	   var rowCntSum = 0;
	   var rowCntE1 = 0;
	   var rowCntA1 = 0;
	   var e1TotWk = 0;
	   var a1WeekCnt = 0;
	   var sumWeek = 0;
   	   var wk = "";
	   for( var i = sheetObj.HeaderRows  ; i <= sheetObj.LastRow; i++ ){
		   
	   	   if(sheetObj.CellValue(i,"is_sub_tot") == "1" && sheetObj.CellValue(i,"is_tot") == "0"){
	   		   wk = sheetObj.CellValue(i,"e1_tot_wk");
	   		   if( wk != "" && wk != "0"){
	   			   rowCntE1++;
	   			   e1TotWk += eval(wk)
	   		   }
	   		   wk = sheetObj.CellValue(i,"a1_week_cnt");
	   		   if( wk != "" && wk != "0"){
	   			   rowCntA1++;
	   			   a1WeekCnt += eval(wk)
	   		   }
	   		   wk = sheetObj.CellValue(i,"sum_week");
	   		   if( wk != "" && wk != "0"){
	   			   rowCntSum++;
	   			   sumWeek += eval(wk)
	   		   }	   		   
	   	   } 
	   }
 
 
   	   if( rowCntE1 != 0 ){
   		   sheetObj.CellValue2(sheetObj.HeaderRows,"e1_tot_wk") = e1TotWk / rowCntE1;
   	   } 
   	   if( rowCntA1 != 0 ){
   		   sheetObj.CellValue2(sheetObj.HeaderRows,"a1_week_cnt") = a1WeekCnt / rowCntA1;
   	   } 
   	   if( rowCntSum != 0 ){
   		   sheetObj.CellValue2(sheetObj.HeaderRows,"sum_week") = sumWeek / rowCntSum;
   	   }    	   
    }    
   	/** 
    * SUM ROW에 있는 CMPB, OPB 값을 계산해서 CELL에 넣어 준다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB)
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
	 * @param {string} COL_CM 필수, 변경시킬 CM,OP column name
	 * @param {string} COL_CMPB 필수, 계산에 사용할 CMPB,OPB column name
	 * @return 없음
	 */      
    function calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB){
   	   var lod_qty =  eval(sheetObj.SumValue(0,COL_LOD));
   	   var cm_amt =  eval(sheetObj.SumValue(0,COL_CM));
   	   var rslt = 0;
   	   if( lod_qty == 0 || lod_qty == ""){
   		   rslt = 0
   	   }else{
   		   rslt = cm_amt / lod_qty;
   	   }
   	   //alert("load="+lod_qty+",cm_amt="+cm_amt+",rslt="+rslt)
   	   sheetObj.SumValue(0,COL_CMPB) = rslt;
      }    
    
   	/** 
    * SUM ROW에 있는 Diff값을 계산해서 CELL에 넣어 준다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      calcBottomDiff(sheetObj,COL_NEW_COST_OP_OFFICE,COL_PREVIOUS_COST_OP_OFFICE,COL_DIFF_COST_OP_OFFICE)	;
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string} COL_A_CMPB 필수, 계산에 사용할 Actual column name
	 * @param {string} COL_E_CMPB 필수, 계산에 사용할 Estimate column name
	 * @param {string} COL_DIFF_CMPB 필수, 값을 바꿀 Diff. column name
	 * @return 없음
	 */      
    function calcBottomDiffCmpbOpb(sheetObj,COL_A_CMPB,COL_E_CMPB,COL_DIFF_CMPB){
    	   var a_cmpb =  eval(sheetObj.SumValue(0,COL_A_CMPB));
    	   var e_cmpb =  eval(sheetObj.SumValue(0,COL_E_CMPB));
    	   var rslt = 0;
    	   if( e_cmpb == 0 || e_cmpb == "" ){
    		   rslt = 0;
    	   }else{
    		   
    		   rslt = (a_cmpb-e_cmpb) / Math.abs(e_cmpb)*100;
    	   }
    	   sheetObj.SumValue(0,COL_DIFF_CMPB) = rslt;
       }   
    
    /** 
    * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {int} x 필수, X 좌표
    * @param {int} y 필수, Y 좌표
    * @return 없음
    */   
 	function sheet1_OnMouseMove(sheetObj,button,shift,x,y){
 		switch(sheetObj.ColSaveName(sheetObj.MouseCol)){
 		case "a_sc_no" :
 			sheetObj.MousePointer = "Hand";

 			break;
 		default :
 			sheetObj.MousePointer = "Default";
 			break;
 		}
 	}
 	
 	
    /** 
    * sheet를 마우스 더블클릭 했을경우 자동 호출됨 
    * SC No를 double click했을때 해당 Main 화면 Popup을 띄워줌.
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} row 필수, 클릭된 row index
    * @param {int} col 필수, 클릭된 col index
    * @return 없음
    */    
 	function sheet1_OnDblClick(sheetObj,row,col){
 		switch(sheetObj.ColSaveName(col)){
 		case "a_sc_no" :	
			
			
 			var pgmNo = "";
 			var pgmUrl = "";
			var parentPgmNo = "";   
 			var src = "";
 			if( sheetObj.CellValue(row,"contract_nm") == "RFA" ){
 				//RFA Proposal & Amendment Creation
	 			pgmNo = "ESM_PRI_2003";
	 			pgmUrl = "/hanjin/ESM_PRI_2003.do"
				parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&cond_prop_no="+sheetObj.CellValue(row,"prop_no"); 
 			}else if(sheetObj.CellValue(row,"contract_nm") == "TAA" ){
	 			//TAA Creation & Amendment
 				pgmNo = "ESM_PRI_3007";
	 			pgmUrl = "/hanjin/ESM_PRI_3007.do"
				parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&cond_taa_no="+sheetObj.CellValue(row,"a_sc_no"); 
 			}else{
	 			//S/C Proposal & Amendment Creation
 				pgmNo = "ESM_PRI_0003";
	 			pgmUrl = "/hanjin/ESM_PRI_0003.do"
				parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&prop_no="+sheetObj.CellValue(row,"prop_no"); 
 			}
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);   
			 
 			break;
 		}
 	}
 	
    /** 
    * 조회 완료후 조회 할 당시의 조회 조건들을 다른 변수에 저장한다.<BR>
    * 만약 flag값이 true 일경우 조회 완료후 조건값을 초기화 한다.<BR> 
	 * <br><b>Example :</b>
	 * <pre>
	 *      setSearchedValues(false);
	 * </pre>
	 * 
	 * @param {boolean} bClearValues 필수, true : 값을 초기화, false : 현재 화면의 값을 다른 변수에 저장해 놓는다.
	 * @return 없음
	 */
 	function setSearchedValues(bClearValues){
 	
 		var formObj = document.form;
 		if(bClearValues != true){
 			formObj.searched_prop_apro_ofc_cd.value = formObj.frm_prop_apro_ofc_cd.Code;
 			formObj.searched_customer_type.value = formObj.frm_customer_type.Code;
 			
 
 			if(formObj.frm_contract_type_s.checked == true){
 				formObj.searched_contract_type_s.value =   formObj.frm_contract_type_s.value;
 				formObj.searched_contract_type.value = formObj.frm_contract_type_s.value;
 			}else{
 				formObj.searched_contract_type_s.value = "";
 			}
 			if(formObj.frm_contract_type_r.checked == true){
 				formObj.searched_contract_type_r.value =   formObj.frm_contract_type_r.value;
 				if(formObj.frm_contract_type_s.checked == true){
 					formObj.searched_contract_type.value = "B";
 				}else{
 					formObj.searched_contract_type.value = formObj.frm_contract_type_r.value;
 				}
 			}else{
 				formObj.searched_contract_type_r.value = "";
 			}
 			if(formObj.frm_contract_type_t.checked == true){
 				formObj.searched_contract_type_t.value =   formObj.frm_contract_type_t.value;
 			}else{
 				formObj.searched_contract_type_t.value = "";
 			}
 			
 			
 			formObj.searched_pfmc_unit.value =       ComPriGetCheckedRadioButtonValue(formObj.frm_pfmc_unit);
 			formObj.searched_ctrt_eff_yr.value =     formObj.frm_ctrt_eff_yr.value;
 			formObj.searched_ctrt_eff_wk.value =     formObj.frm_ctrt_eff_wk.value;
 			
			if( formObj.frm_ctrt_exp_yr.value == "" ){
				var costYr = sheetObjects[1].CellValue(sheetObjects[1].LastRow,"cost_yr");
				var costWk = sheetObjects[1].CellValue(sheetObjects[1].LastRow,"cost_wk");
			    var value = valicateYearWeek(formObj.frm_ctrt_exp_yr);
	 			formObj.searched_ctrt_exp_yr.value =     costYr;
	 			formObj.searched_ctrt_exp_wk.value =     costWk;
			}else{
	 			formObj.searched_ctrt_exp_yr.value =     formObj.frm_ctrt_exp_yr.value;
	 			formObj.searched_ctrt_exp_wk.value =     formObj.frm_ctrt_exp_wk.value;
			}
				
				

 			
 			formObj.searched_smr_eff_yr.value =     formObj.frm_smr_eff_yr.value;
 			formObj.searched_smr_eff_wk.value =     formObj.frm_smr_eff_wk.value;
 			formObj.searched_smr_exp_yr.value =     formObj.frm_smr_exp_yr.value;
 			formObj.searched_smr_exp_wk.value =     formObj.frm_smr_exp_wk.value;
 			
 			formObj.searched_rfrc_eff_yr.value =     formObj.frm_rfrc_eff_yr.value;
 			formObj.searched_rfrc_eff_wk.value =     formObj.frm_rfrc_eff_wk.value;
 			formObj.searched_rfrc_exp_yr.value =     formObj.frm_rfrc_exp_yr.value;
 			formObj.searched_rfrc_exp_wk.value =     formObj.frm_rfrc_exp_wk.value;
 			
 			formObj.searched_prop_ofc_cd.value =     formObj.frm_prop_ofc_cd.value;
 			formObj.searched_prop_srep_cd.value =    formObj.frm_prop_srep_cd.Code;
 			formObj.searched_cust_list.value =     formObj.frm_cust_list.value;
 			
 			formObj.searched_trd_cd.value =     formObj.frm_trd_cd.Code;
 			formObj.searched_dir_cd.value =     formObj.frm_dir_cd.Code;
 			formObj.searched_sub_trd_cd.value =     formObj.frm_sub_trd_cd.Code;
 			formObj.searched_rlane_cd.value =     formObj.frm_rlane_cd.value;
 			
 			
 			formObj.searched_ori_rout_cd.value =     formObj.frm_ori_rout_cd.value;
 			formObj.searched_ori_loc_tp.value =     formObj.frm_ori_loc_tp.value;
 			formObj.searched_dest_rout_cd.value =     formObj.frm_dest_rout_cd.value;
 			formObj.searched_dest_loc_tp.value =     formObj.frm_dest_loc_tp.value;

 			
 			
 			formObj.searched_crg_tp_dry.value =      (formObj.frm_crg_tp_dry.checked == true ? formObj.frm_crg_tp_dry.value : "" ) ;
 			formObj.searched_crg_tp_dg.value =       (formObj.frm_crg_tp_dg.checked == true ? formObj.frm_crg_tp_dg.value : "" ) ; 
 			formObj.searched_crg_tp_rf.value =       (formObj.frm_crg_tp_rf.checked == true ? formObj.frm_crg_tp_rf.value : "" ) ; 
 			formObj.searched_crg_tp_ak.value =       (formObj.frm_crg_tp_ak.checked == true ? formObj.frm_crg_tp_ak.value : "" ) ; 
 			formObj.searched_crg_tp_bb.value =       (formObj.frm_crg_tp_bb.checked == true ? formObj.frm_crg_tp_bb.value : "" ) ; 
 			formObj.is_simulation.value = "";

 			
 			
 		}else{
 			formObj.searched_prop_apro_ofc_cd.value = "";
 			formObj.searched_customer_type.value = "";
 			
 			formObj.searched_contract_type.value = "";
 			formObj.searched_contract_type_s.value = "";
 			formObj.searched_contract_type_r.value = "";
 			formObj.searched_contract_type_t.value = "";
 			formObj.searched_pfmc_unit.value = "";
 			formObj.searched_ctrt_eff_yr.value =  "";  
 			formObj.searched_ctrt_eff_wk.value =  "";  
 			formObj.searched_ctrt_exp_yr.value =  "";  
 			formObj.searched_ctrt_exp_wk.value =  "";  
 			                                           
 			formObj.searched_smr_eff_yr.value =  "";   
 			formObj.searched_smr_eff_wk.value =  "";   
 			formObj.searched_smr_exp_yr.value =  "";   
 			formObj.searched_smr_exp_wk.value =  "";   
 			                                           
 			formObj.searched_rfrc_eff_yr.value =  "";  
 			formObj.searched_rfrc_eff_wk.value =  "";  
 			formObj.searched_rfrc_exp_yr.value =  "";  
 			formObj.searched_rfrc_exp_wk.value =  "";  

 			formObj.searched_prop_ofc_cd.value = "";
 			formObj.searched_prop_srep_cd.value = "";
 			formObj.searched_prop_srep_nm.value = "";
 			formObj.searched_cust_list.value = "";
 			
 			formObj.searched_trd_cd.value =     "";
 			formObj.searched_dir_cd.value =     "";
 			formObj.searched_sub_trd_cd.value = "";
 			formObj.searched_rlane_cd.value =   "";
 			
 			formObj.searched_ori_rout_cd.value =  "";
 			formObj.searched_ori_loc_tp.value =  "";
 			formObj.searched_dest_rout_cd.value =  "";
 			formObj.searched_dest_loc_tp.value =  "";
 			
 			
 			formObj.searched_crg_tp_dry.value = "";
 			formObj.searched_crg_tp_dg.value = "";
 			formObj.searched_crg_tp_rf.value = "";
 			formObj.searched_crg_tp_ak.value = "";
 			formObj.searched_crg_tp_bb.value =  "";
 			formObj.is_simulation.value = "";

 		}
 	}
 	
    /**  
    * frm_profit_level의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @param {string} code 필수, 선택된 Code값
    * @param {string} name 필수, 선택된 text값
    * @return 없음
    */   
 	function frm_profit_level_OnChange(comboObj,code,name){
 		// Profit Level combo값을 변경 하면 그에 맞게 Summary Items combo의 내용을 변경한다.
 		changeSummaryItems(code);
 		changeColHidden(document.form.frm_summary_items,sheetObjects[0]);
 		changeColHidden(document.form.frm_summary_items,sheetObjects[7]);
 		changeColHidden(document.form.frm_summary_items,sheetObjects[8]);
 		// Profit Level combo값을 변경 하면 그에 맞게 main title의 내용을 변경한다.
 		changeTitle(code);
 		// Profit Level combo값을 변경 하면 그에 맞게 sheet의 title의 내용을 변경한다.
 		changeSheetTitle(code)
 	}
    /**  
    * frm_pfmc_unit이 click 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */  
 	function frm_pfmc_unit_OnClick(){
 		var obj = window.event.srcElement;
 		var value = ComPriGetCheckedRadioButtonValue(obj);
 		//PFMC Unit의 선택 내용에 따라 Sheet의 Unit(TEU/FEU) 내용을 바꾼다.
  		changeUnitText(value) ;
 	}
    /**  
    *  Unit의 값(TEU,FEU)에 따라 화면의 title을 변경한다. 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 	changeUnitText(value);
    * </pre>
    * 
    * @param {string} value 필수, Unit Value 
    * @return 없음
    */   
 	function changeUnitText(value){
  		document.getElementById("unit_text").innerText = UNIT_TEXT[value];
 	}
 	
    /**  
    *  Unit의 값(TEU,FEU)에 따라 화면의 title을 변경한다. 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeSheetTitle(value);
    * </pre>
    * 
    * @param {string} value 필수, Unit Value 
    * @return 없음
    */     	
 	function changeSheetTitle(value){
  		document.getElementById("sheet_title").innerText = SHEET_TITLE[value];
 	}
 	
    /**  
    * frm_profit_view의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @param {string} code 필수, 선택된 Code값
    * @param {string} name 필수, 선택된 text값
    * @return 없음
    */   
 	function frm_profit_view_OnChange(comboObj,code,name){
 		
 		var formObj = document.form;
 		var oriCode = formObj.frm_profit_level.Code;
 		formObj.frm_profit_level.removeAll();
 		//Profit View가 Office Profit이면 
    	//Profit Level에 CM,OP가 보이고 Trade Profit이면 CM만 보이도록 한다.
 		if( code == "P"){//trade office
 			ComPriTextCode2ComboItem(ComReplaceStr(cmOpComboValue,"|O",""),ComReplaceStr(cmOpComboText,"|OP",""), formObj.frm_profit_level ,"|","\t" ,1);
 			formObj.frm_profit_level.Code = "C";
 		}else{
 			ComPriTextCode2ComboItem(cmOpComboValue,cmOpComboText, formObj.frm_profit_level ,"|","\t" ,1);
 			formObj.frm_profit_level.Code = oriCode;
 		}
 		//Profit View와 Profit Level의 값에 맞춰 sheet의 column 값을 다르게 보이도록 한다.
 		changeColHidden(document.form.frm_summary_items,sheetObjects[0]);
 		changeColHidden(document.form.frm_summary_items,sheetObjects[7]);
 		changeColHidden(document.form.frm_summary_items,sheetObjects[8]);
 	}
    /**  
    * Code 값에 따라 summary items 의 list 값을 바꾼다.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeSummaryItems(code)
    * </pre>
    * 
    * @param {string} code 필수, CM,OP 의 Code값
    * @return 없음
    */   	
 	function changeSummaryItems(code){
 		var formObj = document.form;
 		var itemCombo = formObj.frm_summary_items;
 		var codes = itemCombo.Code;
 		itemCombo.RemoveAll();

 		if( code == "C"){
 			ComPriTextCode2ComboItem(summaryComboForCmValue,summaryComboForCmText, itemCombo,"|","\t",1);
 		}else{
 			ComPriTextCode2ComboItem(summaryComboForOpValue,summaryComboForOpText, itemCombo,"|","\t",1);
 		}
 		itemCombo.Code = codes;
 	}
 	
    /**  
    *  CM/OP 구분 Code에 따라 화면의 title을 변경한다. 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeTitle(code);
    * </pre>
    * 
    * @param {string} code 필수, CM/OP 구분 Code 
    * @return 없음
    */   	
 	function changeTitle(code){
 		var titleText = document.getElementById("title").innerText;
 		
 		if(titleText.indexOf("CM/OP") >= 0){
 			titleText = titleText.substring(titleText.indexOf("CM/OP")+5 );
 		}else if(titleText.indexOf("CM") >= 0){
 			titleText = titleText.substring(titleText.indexOf("CM")+2 );
 		}else if(titleText.indexOf("OP") >= 0){
 			titleText = titleText.substring(titleText.indexOf("OP")+2 );
 		}
		if( code == "C"){
			titleText = "  CM" + titleText;
		}else{
			titleText = "  OP" + titleText;
		}
 		document.getElementById("title").innerText = titleText;
 	}
 	
 	
    /**  
     * frm_summary_items의 check를 선택했을 경우의 이벤트처리
     * 
     *  
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @param {string} index 필수, 클릭한 아이템의 인덱스 
     * @param {string} code 필수, 클릭한 아이템의 코드
     *
     * @return 없음
     */  
    function frm_summary_items_OnCheckClick(comboObj,index,code){
    	if( code == "A"){
    		comboObj.Code2 = -1;
    		comboObj.Code2 = "A";
    	}else{
    		comboObj.CheckCode("A") = false;
    	}
    	changeColHidden(comboObj,sheetObjects[0]);
    	changeColHidden(comboObj,sheetObjects[7]);
    	changeColHidden(comboObj,sheetObjects[8]);
    }
    
 	/** 
    * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      changeButtonStatus(sheetObjects[0]);
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @return 없음
	 */  	
    function changeButtonStatus(){
		 ComBtnDisable("btn1_Simulation");
		 ComBtnDisable("btn1_Revenue_Detail");
		 ComBtnDisable("btn1_Chart");
		 ComBtnDisable("btn1_Down_Excel");
    	
    	var cnt =  sheetObjects[0].RowCount;
    	if( cnt == 0 ){
    		return;
    	}
		var rfrc_eff_dt = document.getElementById("rfrc_eff_date_name").innerHTML
		var rfrc_exp_dt = document.getElementById("rfrc_exp_date_name").innerHTML
		if( rfrc_eff_dt != "" && rfrc_exp_dt != ""){
			ComBtnEnable("btn1_Simulation");
		}
		ComBtnEnable("btn1_Chart");
		ComBtnEnable("btn1_Down_Excel");
    	if( sheetObjects[0].SelectRow > 0 ){
    		ComBtnEnable("btn1_Revenue_Detail");
    	}
    	if(document.form.searched_contract_type_t.value == "T"){
    		ComBtnDisable("btn1_Simulation");
    		ComBtnDisable("btn1_Revenue_Detail");
    		ComBtnDisable("btn1_Chart");
    	}
    }
    
 	/** 
     *  로그인 사용자의 권한을 체크해 버튼의 비활성화 활성화를 변경
     *  
	 * <br><b>Example :</b>
	 * <pre>
	 *      checkAuthRequestOffice();
	 * </pre>
	 * @return 없음
	 */  
    function checkAuthRequestOffice(){
        var formObj = document.form;
        var code = authCode;
        var obj = document.getElementById("frm_prop_ofc_cd")
        var reqOfcCd = formObj.req_ofc_cd.value;
        
        // SELCAM, HAMUKG, NYCNKG, SINWKG 코드 추가 2012.08.09 송호진
        // HAMUKG, NYCNKG, SINWKG 코드 제외 2012.09.18 송호진
        // CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB 코드 병행 관련 수정  2013.06.14 송호진
        if( reqOfcCd == "SELCGM"
            || reqOfcCd == "NYCRAS"
            || reqOfcCd == "HAMRUS"
            || reqOfcCd == "SHARCS"
            || reqOfcCd == "SINRSS"
            || reqOfcCd == "SELCMS"
            || reqOfcCd == "SELCMA"
            || reqOfcCd == "SELCMU"
            ){ // 승인권자
        	obj.setAttribute("className","input")
        	obj.readOnly = false
        	obj.value = "";
        }else if(code == "S"  || code == "A" ){
        	obj.setAttribute("className","input2")
        	obj.readOnly = true;
        	// sales rep 같은 경우 MDM_SLS_REP table의 OFC_CD값을 request office값으로 이용한다.
        	if(authReqOfcCd == "" ){
        		obj.value = reqOfcCd;
        	}else{
        		obj.value = authReqOfcCd;
        	}
        	searchSalesRepOffice();
        }else{
        	//일반사용자는 아무것도 조회 할수 없다.
           	disableButton("btn1_Simulation");
        	disableButton("btn1_Revenue_Detail");
        	disableButton("btn1_Chart");
        	disableButton("btn1_Down_Excel");
        	disableButton("btn_Retrieve")
        	
        }
      
    }
    /**  
    * frm_trd_cd에서 focus를 잃었을 경우의 이벤트처리
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    *
    * @param (object) 필수, IBMultiCombo
    * @return 없음
    */     
    function frm_trd_cd_OnBlur(obj){
    	searchSubTrade(obj.Code);
    }
    
    /**  
    * frm_trd_cd에서 focus를 얻었을 경우의 이벤트처리
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param (object) 필수, IBMultiCombo
    * @return 없음
    */     
    function frm_trd_cd_OnFocus(obj){
    	obj.Index = obj.Index;
    }    
 	
    /**  
    * download excel에서 사용할 sheet의 이름을 구성한다.
    * 
    *  
    * <br><b>Example :</b>
    *  	sheetObject1.SpeedDown2Excel(-1, false, false,"","",false,false,getSheetNameOfExcel("BEFORE"));
 		sheetObject2.SpeedDown2Excel(-1, true, true,"","",false,false,getSheetNameOfExcel("AFTER"));
    * <pre>
    * </pre>
    * 
    * @param {string} type 필수, 필요한 이름이 simulation된것인지 아닌지 code값
    * @return string, 엑셀의 sheet의 이름
    */        
 	function getSheetNameOfExcel(type){
 		var sheetName = SHEET_TITLE[document.form.frm_profit_level.Code];
 		if( type == "BEFORE"){
 			sheetName += " (Before Simulation)";
 		}else if( type == "AFTER"){
 			sheetName += " (After Simulation)";
 		}
 		return sheetName;
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
		var sheetObj = sheetObjects[7];
    	form.f_cmd.value = SEARCH03;
    	var sXml = sheetObj.GetSearchXml("ESM_PRI_6026GS.do", "f_cmd="+SEARCH03+"&backendjob_key="+BACKEND_JOB_ID);
    	var jobStatus = ComGetEtcData(sXml, "jb_sts_flg");
    	if (jobStatus == "3") {	// BackEndJob의 조회 성공
    		// 조회된 내용을 서버로부터 download해서 sheet에 load 한다.
    		getBackEndJobLoadFile(TIMER_ID);
    		// Backend Job의 상태 조회 stop
    		clearInterval(TIMER_ID);
    		ComOpenWait(false);	
    	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
    		
    		ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
    		// Backend Job의 상태 조회 stop    	
    	    clearInterval(TIMER_ID);	
    		ComOpenWait(false);	
    	} else if (jobStatus == "5") { // download까지 끝난 성공.
    		
    		ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
    		// Backend Job의 상태 조회 stop
    		clearInterval(TIMER_ID);
    		ComOpenWait(false);	
    	}
    }
    /** 
    * BackEndJob이 완료 된후 그 결과를 sheet에 loading한다.<BR>
    * 
    * <br><b>Example :</b>
    * <pre>
    *      getBackEndJobLoadFile(id)
    * </pre>
    * 
    * @param {string} objId 필수, backend job이 여러 종류이기 때문에 이 id에 따라 load할 sheet를 다르게 한다. 
    * @return 없음
    */          
    function getBackEndJobLoadFile(objId) {
		var form = document.form;
		var sheetObj = sheetObjects[0];
		var sheetObj7 = sheetObjects[7];
		form.f_cmd.value = SEARCHLIST;
		var sXml = sheetObj7.GetSearchXml("ESM_PRI_6026GS.do", "f_cmd="+SEARCHLIST+"&backendjob_key="+BACKEND_JOB_ID);		
		// Backend job이 실행 되는 경우는 Retrieve를 click 했을때와 download excel을 click 했을때 두가지 경우이다.
		// 각 경우에 따라 조화 완료된 내용을 loading 하는 sheet가 달라진다.
		switch(ARRAY_BACKENDJOB_TYPE[objId]) {
		case IBSEARCH:      //조회
			//sheetObj.WaitImageVisible = true;  			
			//첫번째 sheet 화면에 보이는 sheet에 조회 내용을 loading한다.
			sheetObj.LoadSearchXml(sXml);
			//simulation후 download excel시 before sheet에 보여질 내용으로
			//조회 될때의 데이터를 그대로 한본 저장해 둔다.
		 	sheetObjects[7].LoadSearchXml(sXml);	
			ComOpenWait(false);		
		 	
		 	break;
		case IBSEARCH_ASYNC07: //EXCEL
		case IBSEARCH_ASYNC08: //EXCEL

			// simulation을 하지 않고 download excel을 할경우 
			// 화면의 sheet 내용과는 다르게 sub-trade level로 새로 조회해서 download하기 때문에
			// download 전용 sheet에 해당 내용을 loading
		 	sheetObjects[8].LoadSearchXml(sXml);		
			ComOpenWait(false);		
		 	break;		
		}

    }
    
    
    /** 
    * sheet를 sort했을때 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} col 필수, sort된 col
    * @param {String} sortArrow 필수, 소트 방향 문자열, "ASC","DESC"
    * @return 없음
    */        
   function sheet1_OnSort(sheetObj,col,sortArrow){
	   	var colName = sheetObj.ColSaveName(col);
	   	// simulation 후 download excel시 화면에 보이는 첫번째 sheet와
	   	// before에 해당하는 숨겨진 sheet간에 sort를 맞추기 위해서
	   	// 화면에 보이는 sheet를 sort할때마다 숨겨진 sheet도 같이 sort해 둔다.
	   	sheetObjects[7].ColumnSort(colName, sortArrow)
   }
    
    
    

    /**  
    * frm_ori_rout_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_ori_rout_cd_OnChange(){
 		
    	var formObj = document.form;
		if( !validateRoute( formObj.frm_ori_rout_cd.value,""  ) ){
			formObj.frm_ori_rout_cd.value = "";
			formObj.frm_ori_loc_tp.value = "";
		}else{
			if(formObj.frm_ori_rout_cd.value.length == 2 ){
				formObj.frm_ori_loc_tp.value = "C";
			}else{
				formObj.frm_ori_loc_tp.value = "R";
			}
		}
 		 
 	}
    
    /**  
    * frm_dest_rout_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_dest_rout_cd_OnChange(){
    	var formObj = document.form;
		if( !validateRoute( formObj.frm_dest_rout_cd.value,""  ) ){
			formObj.frm_dest_rout_cd.value = "";
			formObj.frm_dest_loc_tp.value = "";
		}else{
			if(formObj.frm_dest_rout_cd.value.length == 2 ){
				formObj.frm_dest_loc_tp.value = "C";
			}else{
				formObj.frm_dest_loc_tp.value = "R";
			}
		}
 	}
    
    
    /**  
    * 화면의 trade code가 미주 지역 입력 가능 한 곳인지 검사한다.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return boolean, true : 미주, false: 미주 이외
    */   
    function isUSArea( ){
    	var trdCd = document.form.frm_trd_cd.Code;
    	 if( trdCd == "TPS" || trdCd == "TAS" ){
    		 return true;
    	 }else{
    		 return false;
    	 }
    }
    
    /**  
    * 사용자가 입력한 Origin, Dest.가 Rule에 맞게 입력 했는지 검사한다.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return boolean, true : 정상, false: 비정상
    */       
    function validateRoute(locCd,checkType){
		var sheetObj = sheetObjects[0]
		
		if( locCd == "US" &&  isUSArea( ) ){
			ComShowCodeMessage("PRI03014"); // Please input region code only for US
			return false;
		}else {
			//region code는 US region만 넣을수 있다. US region인지 검사 한다.
			if( locCd.length == 3 && isUSArea( ) ){
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
	/* 개발자 작업  끝 */