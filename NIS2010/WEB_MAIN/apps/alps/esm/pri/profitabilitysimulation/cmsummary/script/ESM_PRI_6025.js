/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6025.js
*@FileTitle : CM/OP Summary & Simulation - Contract Proposal Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
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
     * @class ESM_PRI_6025 : ESM_PRI_6025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6025() {
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

 var UNIT_TEXT = new Array();
 UNIT_TEXT["FEU"] = "[Unit: FEU/USD]";
 UNIT_TEXT["TEU"] = "[Unit: TEU/USD]";

 // 공통전역변수
 var rdObjects = new Array();
 var rdCnt = 0;
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var BACKEND_JOB_ID  = "";
 var TIMER_ID = "";
 var ARRAY_BACKENDJOB_TYPE = new Array();

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
         var Rdviewer = rdObjects[0];
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
 				case "btn1_Retrieve":
 					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                     break; 
 				case "btn1_Close":
 					self.close();
                     break; 
 
 				case "btn1_Down_Excel":
 					ComPriShowDialogExcel(sheetObject1,ComGetMsg("PRI03002"));
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
    	  var formObj = document.form;
          for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
              ComEndConfigSheet(sheetObjects[i]);
          }
          //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

          initControl();

          
          
           

         // Combo data 초기화
          initCombo();   
          //조회 조건의 초기화
          resetAllObjects();
          //PFMC unit code의 값에 따라 text변경
          changeUnitText(formObj.frm_pfmc_unit.value) ;
          //메인화면의 조회 조건을 현재 팝업에 저장
          initParams();
          //메인화면의 조회 조건을 화면에 표시
          initReadOnlyText(formObj);
          //조회 조건에 맞는 sheet column의 표시
          changeColHidden(opener.document.form.frm_summary_items,sheetObjects[0]);
          //RD 초기화
  		  initRdConfig(rdObjects[0]);
  		  //조회시작
  		  ComPriFireEvent("btn1_Retrieve", "onclick");  //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);과 동일한 수행
          
      }
       
       
       var summaryComboForCmValue = "";
       var summaryComboForOpValue = "";
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
    	   
		   summaryComboForCmValue = opener.summaryComboForCmValue;
		   summaryComboForOpValue = opener.summaryComboForOpValue;
		   document.form.frm_prop_no_list.value = opener.getPropNoList(opener.sheetObjects[0],"S")
		   document.form.frm_rfa_prop_no_list.value = opener.getPropNoList(opener.sheetObjects[0],"R")
       }
       

  	  /**  
  	   * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
  	   * 화면에 보여준다.
  	   *  
  	   * <br><b>Example :</b>
  	   * <pre>
  	   *   initReadOnlyText(formObj)
  	   * </pre>
  	   *
  	   * @param {object} formObj 필수, html form Object
  	   * @return 없음
  	   */  
       function initReadOnlyText(formObj){
    	   ComPriCheckRadioButton(formObj.readonly_contract_type,formObj.frm_contract_type.value);
    	   ComPriCheckRadioButton(formObj.readonly_pfmc_unit,formObj.frm_pfmc_unit.value);
    	   if( formObj.frm_profit_level.value == "C" ){
    		   formObj.readonly_profit_level.value = "CM"
    	   }else{
    		   formObj.readonly_profit_level.value = "OP"
    	   }
    	   if( formObj.frm_profit_view.value == "R" ){
    		   formObj.readonly_profit_view.value = "Office Profit"
    	   }else{
    		   formObj.readonly_profit_view.value = "Trade Profit"
    	   }
 
    	   
       }
       
   	  /**  
   	   * 팝업이 오픈될때  rd 파일의 초기 설정을 한다.<BR> 
   	   * 
   	   *  
   	   * <br><b>Example :</b>
   	   * <pre>
   	   *   initRdConfig(rdObjects[0]);
   	   * </pre>
   	   *
   	   * @param {object} rdObject 필수, RD Object
   	   * @return 없음
   	   */         
       function initRdConfig(rdObject){
   		var Rdviewer = rdObject;
   		//자동 배율 조정을 하지 않음
   		Rdviewer.AutoAdjust = false;
   		//배율을 100%
   		Rdviewer.ZoomRatio = 100;
   		//중앙정렬
   		Rdviewer.ViewShowMode(0);
   		//배경색지정
   		Rdviewer.setbackgroundcolor(128,128,128);
   		//테두리색 지정
   		Rdviewer.SetPageLineColor(128,128,128);
   		//조회된 정보가 없을때 경고창을 보여주지 않는다.
   		Rdviewer.SetNoDataDialogInfo(0, "", "");
   		//상태바 숨김
   		Rdviewer.hidestatusbar();
   		//tool bar 숨김
   		Rdviewer.hidetoolbar();
   		
       }
       
	  /**  
	   * rd 파일을 loading 한다.<BR> 
	   * 
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *   rdOpen(rdObjects[0],formObj);
	   * </pre>
	   *
	   * @param {object} rdObject 필수, RD Object
	   * @param {object} formObj 필수, HTML Form Object
	   * @return 없음
	   */   
       function rdOpen(rdObject,formObj){
 
	       	var Rdviewer = rdObject ;
	       	// 열고자 하는 RD 파일을 지정한다.
	       	path  = "apps/alps/esm/pri/profitabilitysimulation/cmsummary/report/ESM_PRI_6025.mrd";
	        // RD에 필요한 parameter의 조합을 return받는다.
	       	var param = getRDParams(formObj);
	       	// RD OPEN
	       	Rdviewer.FileOpen(RD_path + path, RDServer + param);
	        
       }
       
	  /**  
	   * RD와 sheet의 조회에 필요한 parameter를 array로 만든다.<BR> 
	   * 이 함수에서 생성하는 파라메터들은 RD안의 query에서 column명과<BR>  
	   * where 절을 구성하는데 쓰인다. <BR> 
	   * 왜냐하면 RD에서 chart에 표현되는 column을 동적으로 바꿀수 없기 때문임<BR> 
	   * 
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *   makeParams(formObj)
	   * </pre>
	   *
	   * @param {object} formObj 필수, HTML Form Object
	   * @return Array, Array형태의 parameter 목록 
	   */   	   
    function makeParams(formObj){
    	var arrParam = new Array();
    	
    	var profitView = formObj.frm_profit_view.value;
    	var vAxis = formObj.frm_v_axis.Code;
    	var hAxis = formObj.frm_h_axis.Code;
    	var minMax = ComPriGetCheckedRadioButtonValue(formObj.frm_min_max ); 
    	var dispRangeType =  formObj.frm_disp_range_tp.Code;
     	var dispRangeValue = formObj.frm_disp_range_vl.Code;
    	if( vAxis == "CM" ){ //CM
    		if( profitView == "R"){//"P	Trade Profit|R	Office Profit";
				arrParam["P4"] = "CM_NEW_OFFICE";
				arrParam["P5"] = "CM_PREVIOUS_OFFICE";   			
    		}else{
    			arrParam["P4"] = "CM_NEW_TRADE";
				arrParam["P5"] = "CM_PREVIOUS_TRADE";    			
    		}
    	}else if( vAxis == "OP" ){
			arrParam["P4"] = "OP_NEW";
			arrParam["P5"] = "OP_PREVIOUS";    		
    	}else if( vAxis == "CMPB" ){ //CMPB
    		if( profitView == "R"){//"P	Trade Profit|R	Office Profit";
				arrParam["P4"] = "CMPB_NEW_OFFICE";
				arrParam["P5"] = "CMPB_PREVIOUS_OFFICE";   			
			}else{
				arrParam["P4"] = "CMPB_NEW_TRADE";
				arrParam["P5"] = "CMPB_PREVIOUS_TRADE";    			
			}
    	}else if( vAxis == "OPB" ){ //OPB
			arrParam["P4"] = "OPB_NEW";
			arrParam["P5"] = "OPB_PREVIOUS";    	
    	}else if( vAxis == "LOAD" ){ //LOAD
			arrParam["P4"] = "LOAD_NEW";
			arrParam["P5"] = "LOAD_PREVIOUS";    	
    	}
    	
    	if( profitView == "R"){//"P	Trade Profit|R	Office Profit";
    		if( dispRangeType == "CMPB"){
    			arrParam["P6"] = "CMPB_NEW_OFFICE";
    		}else if( dispRangeType == "CM"){
    			arrParam["P6"] = "CM_NEW_OFFICE";
    		}else if( dispRangeType == "OPB"){
    			arrParam["P6"] = "OPB_NEW";
    		}else if( dispRangeType == "OP"){
    			arrParam["P6"] = "OP_NEW";
    		}else{
    			arrParam["P6"] = "LOAD_NEW";
    		}
    	}else{
    		if( dispRangeType == "CMPB"){
    			arrParam["P6"] = "CMPB_NEW_TRADE";
    		}else if( dispRangeType == "CM"){
    			arrParam["P6"] = "CM_NEW_TRADE";
    		}else if( dispRangeType == "OPB"){
    			arrParam["P6"] = "OPB_NEW";
    		}else if( dispRangeType == "OP"){
    			arrParam["P6"] = "OP_NEW";
    		}else{
    			arrParam["P6"] = "LOAD_NEW";
    		}    		
    	}
    	
    	
    	if( minMax == "MAX"){
    		arrParam["P6"] = "DECODE("+arrParam["P6"]+",NULL,-9999999999999999999999999999990,"+arrParam["P6"]+") DESC";
    	}else{
    		arrParam["P6"] = "DECODE("+arrParam["P6"]+",NULL,-9999999999999999999999999999990,"+arrParam["P6"]+") ASC";
    	}
    	
    	/*
    	var horizonalAxisValue = "AO|RO|PN|CT|CM|SR";
    	var horizonalAxisText = "Approval Office|Request Office|Proposal No.|Customer Type|Customer|Sales Rep.";
    	*/
    	if( hAxis == "RO"){
    		arrParam["P7"] = "PROP_OFC_CD" 
    	}else if( hAxis == "CM"){
    		arrParam["P7"] = "CUST_CD"
    	}else if( hAxis == "SR"){
    		arrParam["P7"] = "RESPB_SREP_CD"
    	}else if( hAxis == "PN"){
    		arrParam["P7"] = "PROP_NO"
    	}else if( hAxis == "CT"){
    		arrParam["P7"] = "PRC_CTRT_CUST_TP_NM"    	
    	}else if( hAxis == "AO"){
    		arrParam["P7"] = "PROP_APRO_OFC_CD"        			
    	}
    	if( ComIsNumber( dispRangeValue)) {
    		arrParam["P8"] = dispRangeValue;
    	}else{
    		arrParam["P8"] = "TOT_CNT * " + dispRangeValue.substring(0,dispRangeValue.length-1) +" /100 ";
    	}
    	if( formObj.frm_contract_type.value != 'B'){
    		arrParam["P9"] = " AND SR_MN.PRC_CTRT_TP_CD = '"+formObj.frm_contract_type.value+"'";
    	}else{
    		arrParam["P9"]  = "";
    	}    	
    	if( formObj.frm_contract_type.value == 'B'){
    		arrParam["P9"] = "1=1";//RFA데이터 조회 여부
    		arrParam["P10"] = "1=1";//SC데이터 조회 여부
    	}else if( formObj.frm_contract_type.value == 'R'){
    		arrParam["P9"] = "1=1";//RFA데이터 조회 여부
    		arrParam["P10"] = "1=0";//SC데이터 조회 여부
    	}else if( formObj.frm_contract_type.value == 'S'){
    		arrParam["P9"] = "1=0";//RFA데이터 조회 여부
    		arrParam["P10"] = "1=1";//SC데이터 조회 여부    		
    	}
    	
 
		
    	return arrParam;
    }
   
	  /**  
	   * RD에서 사용할 parameter를 String 형태로 만든다..<BR> 
	   * 
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *  param =  getRDParams(formObj);  //결과 : [] [][][CM_NEW_OFFICE][CMPB_PREVIOUS_OFFICE][CM_PREVIOUS_OFFICE ASC][PROP_OFC_CD][(TOT_CNT * 5 /100)]
	   * </pre>
	   *
	   * @param {object} formObj 필수, HTML Form Object
	   * @return string, rd에서 사용하는 parameter format string
	   */  	   
    function getRDParams(formObj){
    	var qry_prop_no_list = getQryPropNoList(formObj,"S");
    	var qry_rfa_prop_no_list = getQryPropNoList(formObj,"R");
     	var arrParam  = makeParams(formObj);
       	var param = " /rp [" + qry_prop_no_list + "]";
       	param += "["+formObj.frm_svc_scp_cd.value +"]";
       	param += "["+formObj.frm_pfmc_unit.value +"]";
       	param += "["+arrParam["P4"] +"]";
    	param += "["+arrParam["P5"] +"]";
    	param += "["+arrParam["P6"] +"]";
    	param += "["+arrParam["P7"] +"]";
    	param += "["+arrParam["P8"] +"]";
    	param += "["+arrParam["P9"] +"]";
    	param += "["+arrParam["P10"] +"]";
    	param += "["+qry_rfa_prop_no_list +"]";
    	
    	param += "["+formObj.frm_ori_rout_cd.value +"]";
    	param += "["+formObj.frm_ori_loc_tp.value +"]";
    	param += "["+formObj.frm_dest_rout_cd.value +"]";
    	param += "["+formObj.frm_dest_loc_tp.value +"]";
    	param += "["+getQrySLaneCdList(formObj) +"]";
    	
 
 
       	return param;
 
    }
       
	  /**  
	   * sheet에서 사용할 parameter를 String 형태로 만든다..<BR> 
	   * 
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *  param = getSearchParams(formObj); //결과 : "frm_prop_no_list=AFE0092092&frm_pfmc_unit=F"
	   * </pre>
	   *
	   * @param {object} formObj 필수, HTML Form Object
	   * @return string, http parameter format string
	   */  	  
    function getSearchParams(formObj){

     	var arrParam  = makeParams(formObj);
       	var param = FormQueryString(formObj);
       	param += "&new_data_col="+arrParam["P4"]; 
       	param += "&prev_data_col="+arrParam["P5"]; 
       	param += "&rank_order="+arrParam["P6"]; 
       	param += "&grp_code="+arrParam["P7"]; 
       	param += "&range_val="+arrParam["P8"]; 

 
       	return param;
    }    
   
	  /**  
	   * RD안의 query에서 사용할 쿼리중<BR>
	   * 일부를 동적 쿼리로 만들어 파라메터로 전달할수 있도록 쿼리를 구성한다. 
	   * 
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *   qry_prop_no_list = getQryPropNoList(formObj,"S");
	   * </pre>
	   *
	   * @param {object} formObj 필수, HTML Form Object
	   * @return string, rd에서 사용하는 query
	   */  	 	   
    function getQryPropNoList(formObj,dataTpCd){
    	var propNoArr = "";
    	if(dataTpCd == "S"){
    		propNoArr = formObj.frm_prop_no_list.value ;
    	}else{
    		propNoArr = formObj.frm_rfa_prop_no_list.value ;
    	}
    	
    	propNoArr = propNoArr.split("|")
    	var strList = "";
    	for(var i=0 ; i < propNoArr.length ; i++){
    		if( i != 0 ){
    			strList += "UNION ALL" 
    		}
    		strList += " SELECT '"+propNoArr[i]+"' FROM DUAL ";
    		
    	}
    	return strList;
    }
       
           
	  /**  
	   * RD안의 query에서 사용할 쿼리중<BR>
	   * 일부를 동적 쿼리로 만들어 파라메터로 전달할수 있도록 쿼리를 구성한다. 
	   * 
	   *  
	   * <br><b>Example :</b>
	   * <pre>
	   *   qry_prop_no_list = getQrySLaneCdList(formObj;
	   * </pre>
	   *
	   * @param {object} formObj 필수, HTML Form Object
	   * @return string, rd에서 사용하는 query
	   */  	 	   
    function getQrySLaneCdList(formObj){
    	var slaneCdArr = "";
    	slaneCdArr = formObj.frm_slane_cd.value ;
 
    	if( slaneCdArr == "" )
    		return "";
    	slaneCdArr = slaneCdArr.split(";")
    	var strList = "";
    	for(var i=0 ; i < slaneCdArr.length ; i++){
    		if( i != 0 ){
    			strList += "," 
    		}
    		strList += "'"+slaneCdArr[i]+"'";
    		
    	}
    	return strList;
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
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	    
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
		formObj.frm_disp_range_tp.Index = 2;
		formObj.frm_disp_range_vl.Index = 1;
		formObj.frm_h_axis.Index = 1;
		formObj.frm_v_axis.Index = 2;
    	
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
         sheetObj.WaitImageVisible = false;
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 200;
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

                     var HeadTitle1 = "|Seq.|Contract|Request\nOffice|Request\nOffice|Proposal No.|Customer Name|MQC\n(Target MVC)|Load (Performance)|Load (Performance)|Load (Performance)|Gross Revenue|Gross Revenue|Gross Revenue|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Week|Week|Week|CMPB|CMPB|CMPB|CMPB|CMPB|CMPB|CM|CM|CM|CM|CM|CM|OPB|OPB|OPB|OP|OP|OP|amdt_seq|ctrt_eff_dt|ctrt_exp_dt";
 					var HeadTitle2  = "|Seq.|Contract|Request\nOffice|Request\nOffice|Proposal No.|Customer Name|MQC\n(Target MVC)|Previous|New|Diff(%)|Previous|New|Diff(%)|Previous|Previous|Previous|New|New|New|Diff(%)|Diff(%)|Diff(%)|Previous|New|Diff(%)|Previous|Previous|New|New|Diff(%)|Diff(%)|Previous|Previous|New|New|Diff(%)|Diff(%)|Previous|New|Diff(%)|Previous|New|Diff(%)|amdt_seq|ctrt_eff_dt|ctrt_exp_dt";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 8, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"contract_nm",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"prop_ofc_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtHidden,    			60,   	daLeft,  	true,		"prop_ofc_nm",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"cust_nm",   	false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	true,		"prop_mqc_qty",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"load_previous",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"load_new",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"load_diff",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"g_rev_previous",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"g_rev",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"g_rev_diff",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cost_previous_cm_office",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cost_previous_cm_trade",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cost_previous_op_office",   			false,			"",      dfNullInteger,      	2,			true,       true);

 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"cost_new_cm_office",   			false,			"",		 dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"cost_new_cm_trade",   			false,			"",		 dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"cost_new_op_office",   			false,			"",		 dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cost_diff_cm_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cost_diff_cm_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cost_diff_op_office",   			false,			"",      dfNullFloat,      	2,			true,       true);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"week_previous",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"week_new",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"week_diff",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_previous_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_previous_trade",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_new_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_new_trade",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cmpb_diff_office",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cmpb_diff_trade",   			false,          "",      dfNullFloat,      	2,			true,       true);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cm_previous_office",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cm_previous_trade",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"cm_new_office",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"cm_new_trade",   			false,			"",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cm_diff_office",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cm_diff_trade",   			false,			"",      dfNullFloat,      	2,			true,       true);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"opb_previous",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"opb_new",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"opb_diff",   			false,			"",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"op_previous",   			false,          "",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"op_new",   			false,          "",      dfNullInteger,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"op_diff",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtHidden,    		80,   	daRight,  	false,		"amdt_seq",   			false,			"",      dfNone,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtHidden,    		80,   	daRight,  	false,		"ctrt_eff_dt",   			false,			"",      dfNone,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtHidden,    		80,   	daRight,  	false,		"ctrt_exp_dt",   			false,			"",      dfNone,      	2,			true,       true);
 					CountPosition = 0;
 					


 				 
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
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 		        
   		        
   		        formObj.f_cmd.value = SEARCH;
   		        var params = "";
   		        params = "&" +getSearchParams(formObj);

				ComOpenWait(true);
				sheetObj.RemoveAll();
				rdOpen(rdObjects[0],formObj);

				var sXml = sheetObj.GetSearchXml("ESM_PRI_6025GS.do", params );
				
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
 			
         }
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
	   for(var i = sheetObj.HeaderRows; i < sheetObj.LastRow ; i++){
		   currValue = sheetObj.CellValue(i,col);
		   if( i == sheetObj.HeaderRows ){
			   value = currValue;
		   }
		   
		   if( isMin == true ){
			   if(value > currValue){
				   value = currValue;
			   }
		   }else{
			   if(value < currValue){
				   value = currValue;
			   }
		   }
	   }
	   return value;
   }
   
   /**  
    * Combo에서 필요한 코드를 조회해서 Combo에 Assign한다.
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
      

       
       
       if( formObj.frm_profit_level.value == "C"){
    	   ComPriTextCode2ComboItem(ComReplaceStr(verticalAxisValue,"|OPB|OP",""),ComReplaceStr(verticalAxisText,"|OPB|OP",""), formObj.frm_v_axis ,"|","\t",1 );
    	   ComPriTextCode2ComboItem(ComReplaceStr(dispRangeTpValue,"|OPB|OP",""),ComReplaceStr(dispRangeTpText,"|OPB|OP",""), formObj.frm_disp_range_tp ,"|","\t",1 );

       }else{
    	   ComPriTextCode2ComboItem(verticalAxisValue,verticalAxisText, formObj.frm_v_axis ,"|","\t",1 ); 
    	   ComPriTextCode2ComboItem(dispRangeTpValue,dispRangeTpText, formObj.frm_disp_range_tp ,"|","\t" );
       }

	   ComPriTextCode2ComboItem(dispRangeVlValue,dispRangeVlText, formObj.frm_disp_range_vl ,"|","\t",0 );
	   ComPriTextCode2ComboItem( horizonalAxisValue, horizonalAxisText, formObj.frm_h_axis ,"|","\t" ,1);
	   

 
  
	   with(formObj.frm_disp_range_tp){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
	   }
	   with(formObj.frm_disp_range_vl){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = false;
	   }
	   with(formObj.frm_h_axis){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
	   }	
	 with(formObj.frm_v_axis){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
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
       var sheetObj = sheetObjects[0];
       formObj.f_cmd.value = SEARCH15;
       var sParam = FormQueryString(formObj)+"&etc1="+cd;
       sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
       ComPriXml2ComboItem(sXml, formObj.frm_prop_srep_cd, "cd", "cd|nm");
       formObj.frm_prop_srep_cd.InsertItem(0,"","")
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
	   var profit_view = formObj.frm_profit_view.value;
	   var profit_level = formObj.frm_profit_level.value;
	   
	   
	   hideColumnsRange(sheetObjects[0],"load_previous","op_diff");
	   
	   if( arrCodes.length == 0) return;
		var summaryComboForCmValue = "A|L|R|T|W|P|C|B|O";		
		var summaryComboForCmText = "A	All|L	Load|R	G.Revenue|T	Cost|W	Week|P	CMPB|C	CM|B	OPB|O	OP";
		
		

	   colList["L"] = "load_previous|load_new|load_diff"; //Load
	   colList["R"] = "g_rev_previous|g_rev|g_rev_diff"; //GREVENUE
	   colList["W"] = "week_previous|week_new|week_diff";//WEEK
 
	   if(profit_level== "C" ){ //CM
		   if( profit_view == "P"){ // Trade Profit
			   colList["T"] = "cost_previous_cm_trade|cost_new_cm_trade|cost_diff_cm_trade"; //COST
			   colList["P"] = "cmpb_previous_trade|cmpb_new_trade|cmpb_diff_trade";//CMPB
			   colList["C"] = "cm_previous_trade|cm_new_trade|cm_diff_trade"; //CM
			   colList["B"] = "";  //OPB
			   colList["O"] = ""; //OP
		   }else{ //"R" Office Profit
			   colList["T"] = "cost_previous_cm_office|cost_new_cm_office|cost_diff_cm_office"; //COST
			   colList["P"] = "cmpb_previous_office|cmpb_new_office|cmpb_diff_office"; //CMPB
			   colList["C"] = "cm_previous_office|cm_new_office|cm_diff_office";  //CM
			   colList["B"] = ""; //OPB
			   colList["O"] = ""; //OP
		   }
	   }else{//OP
		   if( profit_view == "P"){ // Trade Profit
			   colList["P"] = "cmpb_previous_trade|cmpb_new_trade|cmpb_diff_trade";//CMPB
		   	   colList["C"] = "cm_previous_trade|cm_new_trade|cm_diff_trade"; //CM
		   }else{ //"R" Office Profit
			   colList["P"] = "cmpb_previous_office|cmpb_new_office|cmpb_diff_office"; //CMPB
			   colList["C"] = "cm_previous_office|cm_new_office|cm_diff_office"; //CM
			   
		   }
		   colList["T"] = "cost_previous_op_office|cost_new_op_office|cost_diff_op_office"; //COST
		   colList["B"] = "opb_previous|opb_new|opb_diff"; //OPB
		   colList["O"] = "op_previous|op_new|op_diff"; //OP
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
			   showColumns(sheetObjects[0],colList[name]);
		   }		   
	   }else{
		   for(var i = 0 ; i < arrCodes.length ; i++){
			   code = arrCodes[i];
			   showColumns(sheetObjects[0],colList[code]);
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
   *   showColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 보여주고 싶은 column을 '|'로 연결한 string
   * @return 없음
   */     
   function showColumns(sheetObj, strColList ){
	   if( strColList == undefined) return;
	   if( strColList == "" ) return;
	   var arrColList = strColList.split("|");
	   for( var i = 0 ; i < arrColList.length ; i ++){
		   sheetObj.ColHidden(arrColList[i]) = false;
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
 		changeColHidden(document.form.frm_summary_items,sheetObjects[0]);
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
    * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} ErrMsg 필수, sheet의 결과 메시지
    * @return 없음
    */   
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		changeSheetSumValues(sheetObj);
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
 	
 		var COL_PREVIOUS_LOD = "load_previous";
 		var COL_PREVIOUS_CM_OFFICE = "cm_previous_office";
 		var COL_PREVIOUS_CMPB_OFFICE = "cmpb_previous_office";
 		var COL_PREVIOUS_CM_TRADE = "cm_previous_trade";
 		var COL_PREVIOUS_CMPB_TRADE = "cmpb_previous_trade"; 
 		var COL_PREVIOUS_G_REV = "g_rev_previous";
 		var COL_PREVIOUS_COST_CM_OFFICE = "cost_previous_cm_office"; 	 
 		var COL_PREVIOUS_COST_CM_TRADE = "cost_previous_cm_trade"; 	 
 		var COL_PREVIOUS_COST_OP_OFFICE = "cost_previous_op_office"; 	 
 		
 		var COL_NEW_LOD = "load_new";
 		var COL_NEW_CM_OFFICE = "cm_new_office";
 		var COL_NEW_CMPB_OFFICE = "cmpb_new_office";
 		var COL_NEW_CM_TRADE = "cm_new_trade";
 		var COL_NEW_CMPB_TRADE = "cmpb_new_trade"; 	 
 		var COL_NEW_G_REV = "g_rev";
 		var COL_NEW_COST_CM_OFFICE = "cost_new_cm_office"; 	 
 		var COL_NEW_COST_CM_TRADE = "cost_new_cm_trade"; 	 
 		var COL_NEW_COST_OP_OFFICE = "cost_new_op_office";  		
 		
 		var COL_DIFF_CMPB_OFFICE = "cmpb_diff_office"; 	 
 		var COL_DIFF_CMPB_TRADE = "cmpb_diff_trade"; 	 
 		var COL_PREVIOUS_WK = "week_previous"
 		var COL_NEW_WK = "week_new"
 		var COL_DIFF_WK = "week_diff"
 			
 	 	var COL_DIFF_CM_OFFICE = "cm_diff_office"; 	 
 		var COL_DIFF_CM_TRADE = "cm_diff_trade"; 	 
 		var COL_DIFF_LOAD = "load_diff"; 	 
 		
 		var COL_DIFF_REV = "g_rev_diff"; 	 
 		
 		var COL_DIFF_COST_CM_OFFICE = "cost_diff_cm_office"; 	 
 		var COL_DIFF_COST_CM_TRADE = "cost_diff_cm_trade"; 	 
 		var COL_DIFF_COST_OP_OFFICE = "cost_diff_op_office"; 	 
		
 		var COL_NEW_OP = "op_new";
 		var COL_NEW_OPB = "opb_new"; 	 
 		var COL_PREVIOUS_OP = "op_previous";
 		var COL_PREVIOUS_OPB = "opb_previous"; 
 		var COL_DIFF_OP = "op_diff"; 	
 		var COL_DIFF_OPB = "opb_diff"; 	
 		//OP
 		calcBottomCmpbOpb(sheetObj,COL_PREVIOUS_LOD,COL_PREVIOUS_OP,COL_PREVIOUS_OPB);
 		calcBottomCmpbOpb(sheetObj,COL_NEW_LOD,COL_NEW_OP,COL_NEW_OPB);
 		calcBottomDiff(sheetObj,COL_NEW_OP,COL_PREVIOUS_OP,COL_DIFF_OP)	;
 		calcBottomDiff(sheetObj,COL_NEW_OPB,COL_PREVIOUS_OPB,COL_DIFF_OPB);

 		//CM
 		calcBottomCmpbOpb(sheetObj,COL_PREVIOUS_LOD,COL_PREVIOUS_CM_OFFICE,COL_PREVIOUS_CMPB_OFFICE);
 		calcBottomCmpbOpb(sheetObj,COL_PREVIOUS_LOD,COL_PREVIOUS_CM_TRADE,COL_PREVIOUS_CMPB_TRADE);
 		calcBottomCmpbOpb(sheetObj,COL_NEW_LOD,COL_NEW_CM_OFFICE,COL_NEW_CMPB_OFFICE);
 		calcBottomCmpbOpb(sheetObj,COL_NEW_LOD,COL_NEW_CM_TRADE,COL_NEW_CMPB_TRADE);
 		calcBottomDiff(sheetObj,COL_NEW_CMPB_OFFICE,COL_PREVIOUS_CMPB_OFFICE,COL_DIFF_CMPB_OFFICE);
 		calcBottomDiff(sheetObj,COL_NEW_CMPB_TRADE,COL_PREVIOUS_CMPB_TRADE,COL_DIFF_CMPB_TRADE);
 		calcBottomWeek(sheetObj,COL_PREVIOUS_WK)	;
 		calcBottomWeek(sheetObj,COL_NEW_WK)	;
 		calcBottomDiff(sheetObj,COL_NEW_WK,COL_PREVIOUS_WK,COL_DIFF_WK)	;
 		
 		calcBottomDiff(sheetObj,COL_NEW_CM_OFFICE,COL_PREVIOUS_CM_OFFICE,COL_DIFF_CM_OFFICE)	;
 		calcBottomDiff(sheetObj,COL_NEW_CM_TRADE,COL_PREVIOUS_CM_TRADE,COL_DIFF_CM_TRADE)	;
 		
 		calcBottomDiff(sheetObj,COL_NEW_LOD,COL_PREVIOUS_LOD,COL_DIFF_LOAD)	;
 		calcBottomDiff(sheetObj,COL_NEW_G_REV,COL_PREVIOUS_G_REV,COL_DIFF_REV)	;
 		
 		calcBottomDiff(sheetObj,COL_NEW_COST_CM_OFFICE,COL_PREVIOUS_COST_CM_OFFICE,COL_DIFF_COST_CM_OFFICE)	;
 		calcBottomDiff(sheetObj,COL_NEW_COST_CM_TRADE,COL_PREVIOUS_COST_CM_TRADE,COL_DIFF_COST_CM_TRADE)	;
 		calcBottomDiff(sheetObj,COL_NEW_COST_OP_OFFICE,COL_PREVIOUS_COST_OP_OFFICE,COL_DIFF_COST_OP_OFFICE)	;
 		
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
   	   if( lod_qty == 0 ){
   		   rslt = 0
   	   }else{
   		   rslt = cm_amt / lod_qty;
   	   }
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
    function calcBottomDiff(sheetObj,COL_A_CMPB,COL_E_CMPB,COL_DIFF_CMPB){
    	   var a_cmpb =  eval(sheetObj.SumValue(0,COL_A_CMPB));
    	   var e_cmpb =  eval(sheetObj.SumValue(0,COL_E_CMPB));
    	   var rslt = "0";
    	   if( e_cmpb == 0 ){
    		   rslt = "0"
    	   }else{
    		   rslt = (a_cmpb-e_cmpb) / Math.abs(e_cmpb)*100;
    	   }
    	   sheetObj.SumValue(0,COL_DIFF_CMPB) = rslt;
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
		var sheetObj = sheetObjects[0];
    	form.f_cmd.value = SEARCH03;
    	var sXml = sheetObj.GetSearchXml("ESM_PRI_6025GS.do", "f_cmd="+SEARCH03+"&backendjob_key="+BACKEND_JOB_ID);
    	var jobStatus = ComGetEtcData(sXml, "jb_sts_flg");
    	if (jobStatus == "3") {
    		
    		getBackEndJobLoadFile(TIMER_ID);
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
    *      getBackEndJobLoadFile(id)
    * </pre>
    * 
    * @param {string} objId 필수, backend job이 여러 종류이기 때문에 이 id에 따라 load할 sheet를 다르게 한다. 
    * @return 없음
    */          
    function getBackEndJobLoadFile(objId) {
		var form = document.form;
		var sheetObj = sheetObjects[0];
		form.f_cmd.value = SEARCH04;
		var sXml = sheetObj.GetSearchXml("ESM_PRI_6025GS.do", "f_cmd="+SEARCH04+"&backendjob_key="+BACKEND_JOB_ID);		
		switch(ARRAY_BACKENDJOB_TYPE[objId]) {
		case IBSEARCH:      //조회
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);		
		 	
		 	break;
		}

    }	  	 
 
	/* 개발자 작업  끝 */