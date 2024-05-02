/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0103.jsp
*@FileTitle : Packing Instruction & Special Packing Provision-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.01.27 나상보
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
     * @class VOP_SCG_0103 : VOP_SCG_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0103() {
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
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var prefix = "scgPckRef_";
    
    var tabIndex = 0;
    var tabLoad = new Array();
    tabLoad[0]= false;
    tabLoad[1]= false;
    tabLoad[2]= false;
    tabLoad[3]= false;
    tabLoad[4]= false;
    tabLoad[5]= false;
    tabLoad[6]= false;
    tabLoad[7]= false;
    
    var tabSave = new Array();
    tabSave[0]= true;
    tabSave[1]= true;
    tabSave[2]= true;
    tabSave[3]= true;
    tabSave[4]= true;
    tabSave[5]= true;
    tabSave[6]= true;
    tabSave[7]= true;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

     			case "btn1_Row_Add": case "btn1_Row_Delete":
     				processButtonClick1(srcName);		//VOP_SCG_0103_01.js
					break;
					
     			case "btn2_1_Row_Add": case "btn2_1_RowCopy": case "btn2_1_Row_Delete":
				case "btn2_2_Row_Add": case "btn2_2_RowCopy": case "btn2_2_Row_Delete":
				case "btn2_3_Row_Add": case "btn2_3_RowCopy": case "btn2_3_Row_Delete":
				case "btn2_4_Row_Add": case "btn2_4_RowCopy": case "btn2_4_Row_Delete":
					processButtonClick2(srcName);		//VOP_SCG_0103_02.js
					break;	
					
     			case "btn3_1_Row_Add": case "btn3_1_RowCopy": case "btn3_1_Row_Delete":
				case "btn3_2_Row_Add": case "btn3_2_RowCopy": case "btn3_2_Row_Delete":
					processButtonClick3(srcName);		//VOP_SCG_0103_03.js
					break;
					
     			case "btn5_1_Row_Add": case "btn5_1_RowCopy": case "btn5_1_Row_Delete":
     				processButtonClick5(srcName);		//VOP_SCG_0103_05.js
					break;
					
     			case "btn6_1_Row_Add": case "btn6_1_RowCopy": case "btn6_1_Row_Delete":
				case "btn6_2_Row_Add": case "btn6_2_RowCopy": case "btn6_2_Row_Delete":
				case "btn6_3_Row_Add": case "btn6_3_RowCopy": case "btn6_3_Row_Delete":
					processButtonClick6(srcName);		//VOP_SCG_0103_06.js
					break;
					
     			case "btn7_1_Row_Add": case "btn7_1_RowCopy": case "btn7_1_Row_Delete":
				case "btn7_2_Row_Add": case "btn7_2_RowCopy": case "btn7_2_Row_Delete":
				case "btn7_3_Row_Add": case "btn7_3_RowCopy": case "btn7_3_Row_Delete":
				case "btn7_4_Row_Add": case "btn7_4_RowCopy": case "btn7_4_Row_Delete":
					processButtonClick7(srcName);		//VOP_SCG_0103_07.js
					break;
					
				case "btn_New":
					clearAll();
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
					
				case "btn_SeqPrev":
 					pckCdSeqPrev();
 					break;

 				case "btn_SeqNext":
 					pckCdSeqNext();
 					break;
 					
 				case "pck_div_cd_radio":
 					if(document.form.pck_div_cd_radio[0].checked == true){
    					document.form.pck_div_cd.value = "P";
    				}else if(document.form.pck_div_cd_radio[1].checked == true){
    					document.form.pck_div_cd.value = "I";
    				}else if(document.form.pck_div_cd_radio[2].checked == true){
    					document.form.pck_div_cd.value = "L";
    				}else if(document.form.pck_div_cd_radio[3].checked == true){
    					tabObjects[0].TabEnable(0) = false;
    					tabObjects[0].TabEnable(1) = false;
    					tabObjects[0].TabEnable(2) = false;
    					tabObjects[0].TabEnable(3) = false;
    					tabObjects[0].TabEnable(4) = false;
    					tabObjects[0].TabEnable(5) = false;
    					tabObjects[0].TabEnable(6) = true;
//    					clearAll();
    					document.form.pck_div_cd.value = "T";
    					formEnable(false, true);
    				}
 					if(document.form.pck_div_cd_radio[3].checked == false && tabObjects[0].TabEnable(6) != false){
    					tabObjects[0].TabEnable(0) = true;
    					tabObjects[0].TabEnable(1) = true;
    					tabObjects[0].TabEnable(2) = true;
    					tabObjects[0].TabEnable(3) = true;
    					tabObjects[0].TabEnable(4) = true;
    					tabObjects[0].TabEnable(5) = true;
    					tabObjects[0].TabEnable(6) = false;
    					formEnable(true, true);
    				}
    			break; 
    			
 				case "pck_desc_use_box":
    				if(document.form.pck_desc_use_box.checked == true){
    					document.form.pck_desc_use_flg.value = "Y";
    				}else{
    					document.form.pck_desc_use_flg.value = "N";
    				}
    			break; 
    			
 				case "pck_regu_use_box":
    				if(document.form.pck_regu_use_box.checked == true){
    					document.form.pck_regu_use_flg.value = "Y";
    				}else{
    					document.form.pck_regu_use_flg.value = "N";
    				}
    			break; 
    			
 				case "in_pkg_use_box":
    				if(document.form.in_pkg_use_box.checked == true){
    					document.form.inr_pck_use_flg.value = "Y";
    				}else{
    					document.form.inr_pck_use_flg.value = "N";
    				}
    			break;
    			
 				case "intmd_pkg_use_box":
    				if(document.form.intmd_pkg_use_box.checked == true){
    					document.form.intmd_pck_use_flg.value = "Y";
    				}else{
    					document.form.intmd_pck_use_flg.value = "N";
    				}
    			break;
    			
 				case "out_pkg_use_box":
    				if(document.form.out_pkg_use_box.checked == true){
    					document.form.outr_pck_use_flg.value = "Y";
    				}else{
    					document.form.outr_pck_use_flg.value = "N";
    				}
    			break;
    			
 				case "out_pkg_max_capa_box":
    				if(document.form.out_pkg_max_capa_box.checked == true){
    					document.form.outr_pck_max_capa_flg.value = "Y";
    				}else{
    					document.form.outr_pck_max_capa_flg.value = "N";
    				}
    			break;
    			
 				case "sgl_pkg_use_box":
    				if(document.form.sgl_pkg_use_box.checked == true){
    					document.form.sgl_pck_use_flg.value = "Y";
    				}else{
    					document.form.sgl_pck_use_flg.value = "N";
    				}
    			break;
    			
 				case "sgl_pkg_max_capa_box":
    				if(document.form.sgl_pkg_max_capa_box.checked == true){
    					document.form.sgl_pck_max_capa_flg.value = "Y";
    				}else{
    					document.form.sgl_pck_max_capa_flg.value = "N";
    				}
    			break;
    			
 				case "prs_desc_use_box":
    				if(document.form.prs_desc_use_box.checked == true){
    					document.form.prss_desc_use_flg.value = "Y";
    				}else{
    					document.form.prss_desc_use_flg.value = "N";
    				}
    			break;
    			
 				case "add_regu_desc_use_box":
    				if(document.form.add_regu_desc_use_box.checked == true){
    					document.form.add_regu_desc_use_flg.value = "Y";
    				}else{
    					document.form.add_regu_desc_use_flg.value = "N";
    				}
    			break;
    			
 				case "spcl_pkg_regu_use_box":
    				if(document.form.spcl_pkg_regu_use_box.checked == true){
    					document.form.spcl_pck_regu_use_flg.value = "Y";
    				}else{
    					document.form.spcl_pck_regu_use_flg.value = "N";
    				}
    			break;
    			
 				case "gas_use_box":
    				if(document.form.gas_use_box.checked == true){
    					document.form.gas_use_flg.value = "Y";
    				}else{
    					document.form.gas_use_flg.value = "N";
    				}
    			break;
    			
 				case "pck_expt_box":
    				if(document.form.pck_expt_box.checked == true){
    					document.form.pck_expt_flg.value = "Y";
    				}else{
    					document.form.pck_expt_flg.value = "N";
    				}
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
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
    	 
    	 for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
    	 
    	 initControl();
    	 doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
     }

      /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 switch(sheetNo) {
    	 	case 1:      //t1sheet1 init
   	 			initSheet1(sheetObj,sheetNo);		//VOP_SCG_0103_01.js
    	 		break;
    	 		
    	 	case 2: case 3: case 4: case 5:    		
	    	 	initSheet2(sheetObj,sheetNo);		//VOP_SCG_0103_02.js
		 		break;
		 		
    	 	case 6: case 7:     		
	    	 	initSheet3(sheetObj,sheetNo);		//VOP_SCG_0103_03.js
		 		break;
		 		
    	 	case 8:    		
	    	 	initSheet5(sheetObj,sheetNo);		//VOP_SCG_0103_05.js
		 		break;
		 		
    	 	case 9: case 10: case 11:  		
	    	 	initSheet6(sheetObj,sheetNo);		//VOP_SCG_0103_06.js
		 		break;
		 		
    	 	case 12: case 13: case 14: case 15:  		
	    	 	initSheet7(sheetObj,sheetNo);		//VOP_SCG_0103_07.js
		 		break;

    	 }
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
	 	 			InsertTab( cnt++ , "Definition" , -1 );
	 	 			InsertTab( cnt++ , "Combine Packaging" , -1 );
	 	 			InsertTab( cnt++ , "Single Packaging" , -1 );
	 	 			InsertTab( cnt++ , "Pressure / Additional" , -1 );
	 	 			InsertTab( cnt++ , "Special Packing Provision" , -1 );
	 	 			InsertTab( cnt++ , "Gases and Others" , -1 );
	 	 			InsertTab( cnt++ , "Portable Tank" , -1 );
	 	 			TabEnable(6) = false;
	 	 		}
	 	 	break;
	 	 }
	  }
	   
	   /**
	    * Tab 클릭시 이벤트 관련
	    * 선택한 탭의 요소가 활성화 된다.
	    */
	   function tab1_OnChange(tabObj , nItem) {
    	 var objs = document.all.item("tabLayer");
    	 if(document.form.imdg_pck_instr_cd.value != "" && document.form.pck_div_cd_radio[3].checked == false && tabSave[beforetab+1] == false){
    		 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
    	 }
	  	 objs[nItem].style.display = "Inline";
	  	 objs[beforetab].style.display = "none";
	
	  	 //--------------- 요기가 중요 --------------------------//
	  	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	  	 //------------------------------------------------------//
	  	 beforetab= nItem;
	  	 tabIndex = nItem;
	  	 if(tabLoad[0] == true){
	  		if(beforetab == 0 && tabLoad[1] == false){
        		doActionIBSheet1(sheetObjects[0],document.form,IBSEARCH);
        		tabLoad[1] = true;
        	}else if(beforetab == 1 && tabLoad[2] == false){
        		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
        		tabLoad[2] = true;
        	}else if(beforetab == 2 && tabLoad[3] == false){
        		doActionIBSheet3(sheetObjects[5],document.form,IBSEARCH);
        		tabLoad[3] = true;
        	}else if(beforetab == 4 && tabLoad[5] == false){
        		doActionIBSheet5(sheetObjects[7],document.form,IBSEARCH);
        		tabLoad[5] = true;
        	}else if(beforetab == 5 && tabLoad[6] == false){
        		doActionIBSheet6(sheetObjects[8],document.form,IBSEARCH);
        		tabLoad[6] = true;
        	}
	  	 }else if(document.form.imdg_pck_instr_cd.value != ""){
	  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  	 }
	  	 if(beforetab == 6 && tabLoad[7] == false){
     		doActionIBSheet7(sheetObjects[11],document.form,IBSEARCH);
     		tabLoad[7] = true;
     	}
	   }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH:      //조회
         		if(formObj.imdg_pck_instr_cd.value != "" || document.form.pck_div_cd_radio[3].checked == true) {
         			if(document.form.pck_div_cd_radio[3].checked == false){
	         			formObj.f_cmd.value = SEARCH;
			        	var sXml = sheetObj.GetSearchXml("VOP_SCG_0103GS.do", FormQueryString(formObj));
			        	var arrData = ComScgXml2Array(sXml, "pck_instr_tp_ctnt|pck_div_cd|pck_desc|pck_desc_use_flg|pck_regu_use_flg|inr_pck_use_flg|intmd_pck_use_flg|" +
			        										"outr_pck_use_flg|outr_pck_max_capa_flg|sgl_pck_use_flg|sgl_pck_max_capa_flg|prss_desc|prss_desc_use_flg|add_regu_desc|" +
			        										"add_regu_desc_use_flg|spcl_pck_regu_use_flg|gas_use_flg|delt_flg|pck_expt_flg");
			        	formObj.ibflag.value = "U";
			        	formObj.pck_instr_tp_ctnt.value = arrData[0][0];
			        	formObj.pck_div_cd.value = arrData[0][1];
			        	if(formObj.pck_div_cd.value == "P"){
			        		formObj.pck_div_cd_radio[0].checked = true;
			        	}else if(formObj.pck_div_cd.value == "I"){
			        		formObj.pck_div_cd_radio[1].checked = true;
			        	}else if(formObj.pck_div_cd.value == "L"){
			        		formObj.pck_div_cd_radio[2].checked = true;
			        	}
			        	formObj.pck_desc.value = arrData[0][2];
			        	formObj.pck_desc_use_flg.value = arrData[0][3];
			        	if(formObj.pck_desc_use_flg.value == "Y"){
			        		formObj.pck_desc_use_box.checked = true;
			        	}else{
			        		formObj.pck_desc_use_box.checked = false;
			        	}
			        	formObj.pck_regu_use_flg.value = arrData[0][4];
			        	if(formObj.pck_regu_use_flg.value == "Y"){
			        		formObj.pck_regu_use_box.checked = true;
			        	}else{
			        		formObj.pck_regu_use_box.checked = false;
			        	}
			        	formObj.inr_pck_use_flg.value = arrData[0][5];
			        	if(formObj.inr_pck_use_flg.value == "Y"){
			        		formObj.in_pkg_use_box.checked = true;
			        	}else{
			        		formObj.in_pkg_use_box.checked = false;
			        	}

			        	formObj.intmd_pck_use_flg.value = arrData[0][6];
			        	if(formObj.intmd_pck_use_flg.value == "Y"){
			        		formObj.intmd_pkg_use_box.checked = true;
			        	}else{
			        		formObj.intmd_pkg_use_box.checked = false;
			        	}
			        	formObj.outr_pck_use_flg.value = arrData[0][7];
			        	if(formObj.outr_pck_use_flg.value == "Y"){
			        		formObj.out_pkg_use_box.checked = true;
			        	}else{
			        		formObj.out_pkg_use_box.checked = false;
			        	}
//		        	formObj.outr_pck_max_capa_flg.value = arrData[0][8];
			        	formObj.sgl_pck_use_flg.value = arrData[0][9];
			        	if(formObj.sgl_pck_use_flg.value == "Y"){
			        		formObj.sgl_pkg_use_box.checked = true;
			        	}else{
			        		formObj.sgl_pkg_use_box.checked = false;
			        	}
//			        	alert("11: "+arrData[0][11]+">12: "+arrData[0][12]+">13: "+arrData[0][13]+">14: "+arrData[0][14]);
//		        	    formObj.sgl_pck_max_capa_flg.value = arrData[0][10];
			        	formObj.prss_desc.value = arrData[0][11];

			        	formObj.prss_desc_use_flg.value = arrData[0][12];
			        	if(formObj.prss_desc_use_flg.value == "Y"){
			        		formObj.prs_desc_use_box.checked = true;
			        	}else{
			        		formObj.prs_desc_use_box.checked = false;
			        	}
			        	formObj.add_regu_desc.value = arrData[0][13];
			        	formObj.add_regu_desc_use_flg.value = arrData[0][14];
			        	if(formObj.add_regu_desc_use_flg.value == "Y"){
			        		formObj.add_regu_desc_use_box.checked = true;
			        	}else{
			        		formObj.add_regu_desc_use_box.checked = false;
			        	}
			        	formObj.spcl_pck_regu_use_flg.value = arrData[0][15];
			        	if(formObj.spcl_pck_regu_use_flg.value == "Y"){
			        		formObj.spcl_pkg_regu_use_box.checked = true;
			        	}else{
			        		formObj.spcl_pkg_regu_use_box.checked = false;
			        	}
//			        	alert("11: "+arrData[0][11]+">12: "+arrData[0][12]+">13: "+arrData[0][13]+">14: "+arrData[0][14]);

			        	formObj.gas_use_flg.value = arrData[0][16];
			        	if(formObj.gas_use_flg.value == "Y"){
			        		formObj.gas_use_box.checked = true;
			        	}else{
			        		formObj.gas_use_box.checked = false;
			        	}
			        	formObj.delt_flg.value = arrData[0][17];
			        	formObj.pck_expt_flg.value = arrData[0][18];
			        	if(formObj.pck_expt_flg.value == "Y"){
			        		formObj.pck_expt_box.checked = true;
			        	}else{
			        		formObj.pck_expt_box.checked = false;
			        	}
//			        	alert("100 beforetab:"+beforetab);
			        	tabLoad[0] = true;
			        	if(beforetab == 0){
			        		doActionIBSheet1(sheetObjects[0],document.form,IBSEARCH);
			        		tabLoad[1] = true;
			        	}else if(beforetab == 1){
			        		sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH02);
				   			ComSetIBCombo(sheetObjects[1], sXml, prefix1+"imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[2], sXml, prefix2+"imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[3], sXml, prefix3+"imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[5], sXml, "imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[7], sXml, "cond_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[7], sXml, "imdg_pck_cd", true );
			        		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
			        		tabLoad[2] = true;
			        	}else if(beforetab == 2){
			        		sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH02);
				   			ComSetIBCombo(sheetObjects[1], sXml, prefix1+"imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[2], sXml, prefix2+"imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[3], sXml, prefix3+"imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[5], sXml, "imdg_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[7], sXml, "cond_pck_cd", true );
				   			ComSetIBCombo(sheetObjects[7], sXml, "imdg_pck_cd", true );
			        		doActionIBSheet3(sheetObjects[5],document.form,IBSEARCH);
			        		tabLoad[3] = true;
			        	}else if(beforetab == 4){
			        		doActionIBSheet5(sheetObjects[7],document.form,IBSEARCH);
			        		tabLoad[5] = true;
			        	}else if(beforetab == 5){
			        		doActionIBSheet6(sheetObjects[8],document.form,IBSEARCH);
			        		tabLoad[6] = true;
			        	}
			        	formEnable(false, false);
         			}else{
		        		doActionIBSheet7(sheetObjects[11],document.form,IBSEARCH);
		        		tabLoad[7] = true;
		        	}
				}else{
					ComShowCodeMessage('SCG50007', 'Pack. Instruct. Code');
					formObj.imdg_pck_instr_cd.focus();
				}
	         	tabSave[0]= true;
	            tabSave[1]= true;
	            tabSave[2]= true;
	            tabSave[3]= true;
	            tabSave[4]= true;
	            tabSave[5]= true;
	            tabSave[6]= true;
	            tabSave[7]= true;
        	   	break;
			
			case IBSAVE:        //저장
				if(formObj.imdg_pck_instr_cd.value != "" || document.form.pck_div_cd_radio[3].checked == true) {
					if(!ComShowCodeConfirm('SCG50001', 'data')) return;
					if(document.form.pck_div_cd_radio[3].checked == false){
						var saveS = false;
						formObj.f_cmd.value = MULTI;
						sheetObj.GetSaveXml("VOP_SCG_0103GS.do", FormQueryString(formObj), false);
//						alert("beforetab:"+beforetab);
						if(beforetab == 0){
							saveS = doActionIBSheet1(sheetObjects[0],document.form,IBSAVE);
			        		tabSave[1]= true;
			        	}else if(beforetab == 1){
			        		saveS = doActionIBSheet2(sheetObjects[1],document.form,IBSAVE);
			        		tabSave[2]= true;
			        	}else if(beforetab == 2){
			        		saveS = doActionIBSheet3(sheetObjects[5],document.form,IBSAVE);			        		
			        		tabSave[3]= true;
			        	}else if(beforetab == 4){
			        		saveS = doActionIBSheet5(sheetObjects[7],document.form,IBSAVE);	
			        		tabSave[5]= true;
			        	}else if(beforetab == 5){
			        		saveS = doActionIBSheet6(sheetObjects[8],document.form,IBSAVE);
			        		tabSave[6]= true;
			        	} 
					}else{
						saveS = doActionIBSheet7(sheetObjects[11],document.form,IBSAVE);
		        		tabSave[7]= true;
		        	}
				}else{
					ComShowCodeMessage('SCG50007', 'Pack. Instruct. Code');
					formObj.imdg_pck_instr_cd.focus();
				}
				if(saveS){
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
				break;
				
			case IBSEARCH_ASYNC01:   //PCK INSTR CD 조회
                formObj.f_cmd.value = SEARCH09;

                var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
    		    var arrData = ComScgXml2Array(sXml, "imdg_pck_instr_seq|pck_cd_seq_max|pck_cd_seq_min|pck_cd_seq_cnt|upd_dt");

    		    if (arrData != null && arrData.length > 0) {	    		    
    		    	formObj.imdg_pck_instr_seq.value = parseInt(arrData[0][0]) - 1;	    		    		
   					formObj.pck_cd_seq_max.value = arrData[0][1];
   					formObj.pck_cd_seq_min.value = arrData[0][2];
   					formObj.pck_cd_seq_cnt.value = arrData[0][3];
   					formObj.upd_dt.value = arrData[0][4];
   					formObj.ibflag.value = "U";
   					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}else{
		 			if (ComShowCodeConfirm("SCG50036", formObj.imdg_pck_instr_cd.value)) {
	   					formObj.imdg_pck_instr_seq.value = "1";
	   					formObj.pck_cd_seq_max.value = "";
	   					formObj.pck_cd_seq_min.value = "";
	   					formObj.pck_cd_seq_cnt.value = "";
	   					formObj.upd_dt.value = "";
	   					formObj.ibflag.value = "I";
	   					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	   					formObj.ibflag.value = "U";
		 			}else{
	   					formObj.imdg_pck_instr_cd.value = "";
	   					formObj.imdg_pck_instr_seq.value = "";
	   					formObj.pck_cd_seq_max.value = "";
	   					formObj.pck_cd_seq_min.value = "";
	   					formObj.pck_cd_seq_cnt.value = "";
	   					formObj.upd_dt.value = "";
	   					formObj.imdg_pck_instr_cd.focus();
		 			}
				}
    		    tabSave[0]= true;
    		    tabSave[1]= true;
    		    tabSave[2]= true;
    		    tabSave[3]= true;
    		    tabSave[4]= true;
    		    tabSave[5]= true;
    		    tabSave[6]= true;
    		    tabSave[7]= true;
    		break;
			
			case SEARCH01:      // combo setting
	  	 		formObj.f_cmd.value = SEARCH01;
	   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103GS.do", FormQueryString(formObj));
	   			var arrxml = sXml.split("|$$|");
	   			ComSetIBCombo(sheetObjects[1], arrxml[0], prefix1+"grp_n1st_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[3], arrxml[0], prefix3+"grp_n1st_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[3], arrxml[0], prefix3+"grp_n2nd_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[3], arrxml[0], prefix3+"grp_n3rd_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[5], arrxml[0], "grp_n1st_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[5], arrxml[0], "grp_n2nd_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[5], arrxml[0], "grp_n3rd_meas_ut_cd", true );
//	   			ComSetIBCombo(sheetObjects[7], arrxml[0], "grp_n1st_meas_ut_cd", true );
//	   			ComSetIBCombo(sheetObjects[7], arrxml[0], "grp_n2nd_meas_ut_cd", true );
//	   			ComSetIBCombo(sheetObjects[7], arrxml[0], "grp_n3rd_meas_ut_cd", true );
	   			ComSetIBCombo(sheetObjects[7], arrxml[0], "capa_mass_meas_ut_cd", true );
	   			
	   			ComSetIBCombo(sheetObjects[1], arrxml[1], prefix1+"pck_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[2], arrxml[1], prefix2+"pck_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[3], arrxml[1], prefix3+"pck_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[5], arrxml[1], "pck_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[7], arrxml[1], "cond_pck_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[7], arrxml[1], "pck_tp_cd", true );
	   			
	   			ComSetIBCombo(sheetObjects[1], arrxml[2], prefix1+"pck_mtrl_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[2], arrxml[2], prefix2+"pck_mtrl_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[3], arrxml[2], prefix3+"pck_mtrl_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[5], arrxml[2], "pck_mtrl_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[7], arrxml[2], "cond_pck_mtrl_tp_cd", true );
	   			ComSetIBCombo(sheetObjects[7], arrxml[2], "pck_mtrl_tp_cd", true );
	   			
	   			sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH02);
//	   			alert("101:"+sXml);
	   			ComSetIBCombo(sheetObjects[1], sXml, prefix1+"imdg_pck_cd", true );
	   			ComSetIBCombo(sheetObjects[2], sXml, prefix2+"imdg_pck_cd", true );
	   			ComSetIBCombo(sheetObjects[3], sXml, prefix3+"imdg_pck_cd", true );
	   			ComSetIBCombo(sheetObjects[5], sXml, "imdg_pck_cd", true );
	   			ComSetIBCombo(sheetObjects[7], sXml, "cond_pck_cd", true );
	   			ComSetIBCombo(sheetObjects[7], sXml, "imdg_pck_cd", true );
	    		break;
	    		
//			case SEARCH02:      // combo
//	  	 		formObj.f_cmd.value = SEARCH02;
//	   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103GS.do", FormQueryString(formObj));
//	   			
//	   			ComSetIBCombo(sheetObjects[1], sXml, prefix1+"pck_mtrl_tp_cd", true );
//	   			ComSetIBCombo(sheetObjects[2], sXml, prefix2+"pck_mtrl_tp_cd", true );
//	   			ComSetIBCombo(sheetObjects[3], sXml, prefix3+"pck_mtrl_tp_cd", true );
//	   			ComSetIBCombo(sheetObjects[5], sXml, "pck_mtrl_tp_cd", true );
//	   			ComSetIBCombo(sheetObjects[7], sXml, "cond_pck_mtrl_tp_cd", true );
//	   			ComSetIBCombo(sheetObjects[7], sXml, "pck_mtrl_tp_cd", true );
//    		break;
         }
     }

 	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {    	
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerForm('change', 	'obj_change', 	document.form); 
         axon_event.addListenerForm('keypress', 'obj_keypress', document.form  );
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
//    	 if (sAction == IBSAVE) {
//  			var dupRow = sheetObj.ColValueDupRows("usr_id", false, true);
// 			if(dupRow != "") {
//				ComShowCodeMessage('SCG50005', 'Data');
//				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
//					sheetObj.SelectCell(dupRow.split("|")[1], 2);
//				}else{
//					sheetObj.SelectCell(dupRow.split("|")[0], 2);					
//				}
//				return;
// 			}    		 
//    	 }
         return true;
     }
      
      function clearAll(pckDivCd) {
   		var formObj = document.form;
   		formObj.reset();
   		if(pckDivCd != null && pckDivCd != ''){
   			if(pckDivCd == "P"){
				document.form.pck_div_cd_radio[0].checked = true;
				document.form.pck_div_cd.value = "P";
			}else if(pckDivCd == "I"){
				document.form.pck_div_cd_radio[1].checked = true;
				document.form.pck_div_cd.value = "I";
			}else if(pckDivCd == "L"){
				document.form.pck_div_cd_radio[2].checked = true;
				document.form.pck_div_cd.value = "L";
			}
   		}
  		sheetObjects[0].RemoveAll();
  		sheetObjects[1].RemoveAll();
  		sheetObjects[2].RemoveAll();
  		sheetObjects[3].RemoveAll();
  		sheetObjects[4].RemoveAll();
  		sheetObjects[5].RemoveAll();
  		sheetObjects[6].RemoveAll();
  		sheetObjects[7].RemoveAll();
  		sheetObjects[8].RemoveAll();
  		sheetObjects[9].RemoveAll();
  		sheetObjects[10].RemoveAll();
  		sheetObjects[11].RemoveAll();
  		sheetObjects[12].RemoveAll();
  		sheetObjects[13].RemoveAll();
  		sheetObjects[14].RemoveAll();
  		tabLoad[0] = false;
  		tabLoad[1] = false;
  		tabLoad[2] = false;
  		tabLoad[3] = false;
  		tabLoad[4] = false;
  		tabLoad[5] = false;
  		tabLoad[6] = false;
  		tabLoad[7] = false;
  		tabSave[0] = true;
  	    tabSave[1] = true;
  	    tabSave[2] = true;
  	    tabSave[3] = true;
  	    tabSave[4] = true;
  	    tabSave[5] = true;
  	    tabSave[6] = true;
  	    tabSave[7] = true;
  		formEnable(true, false);
      }
      
      function obj_change() {
     	 var formObj = document.form;
     	 switch(event.srcElement.name){
     	 	case "imdg_pck_instr_cd":
     	 		var pckCd = formObj.imdg_pck_instr_cd.value;
     	 		var length = formObj.imdg_pck_instr_cd.value.length;
 	 			if((document.form.pck_div_cd_radio[0].checked == true && pckCd.substr(0,1) == "P")
 	 			|| (document.form.pck_div_cd_radio[1].checked == true && pckCd.substr(0,3) == "IBC")
 	 			|| (document.form.pck_div_cd_radio[2].checked == true && pckCd.substr(0,2) == "LP")){
	 	 			clearAll(document.form.pck_div_cd.value);
	 	 			formObj.imdg_pck_instr_cd.value = pckCd;
	 	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	 	 		}else{
	 	 			ComShowCodeMessage('SCG50010',"Pack. Instruct. Code");
	 	 			formObj.imdg_pck_instr_cd.value = "";
	 	 			formObj.imdg_pck_instr_cd.focus();
	 	 		}
     	 		break;
     	 }
      }
      
      function pckCdSeqPrev() {
   		var formObj = document.form;
   		var pckCd 	= formObj.imdg_pck_instr_cd.value;
   		var pckCdSeq = parseInt(formObj.imdg_pck_instr_seq.value);
   		var maxSeq 	= parseInt(formObj.pck_cd_seq_max.value);
   		var minSeq 	= parseInt(formObj.pck_cd_seq_min.value);
   		var totCnt 	= formObj.pck_cd_seq_cnt.value;
   		var updDt 	= formObj.upd_dt.value;
   		if (formObj.imdg_pck_instr_seq.value == "" ) {
   			ComShowCodeMessage('SCG50007', 'Pack. Instruct. Code');
   			ComSetFocus(formObj.imdg_pck_instr_cd);
   			return;
   		}else if (pckCdSeq > 1){
			clearAll();
			formObj.imdg_pck_instr_cd.value = pckCd;
			formObj.pck_cd_seq_max.value = maxSeq;
			formObj.pck_cd_seq_min.value = minSeq;
			formObj.pck_cd_seq_cnt.value = totCnt;
			formObj.upd_dt.value = updDt;	 					
   	 		formObj.imdg_pck_instr_seq.value = pckCdSeq-1;
   	 		formObj.ibflag.value = "U";
   		}
   		if(tabLoad[0] == false && document.form.imdg_pck_instr_cd.value != ""){
	  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  	}
   	}

   	function pckCdSeqNext() {
   		var formObj = document.form;
   		var pckCd 	= formObj.imdg_pck_instr_cd.value;
   		var pckCdSeq = formObj.imdg_pck_instr_seq.value;
   		var maxSeq 	= parseInt(formObj.pck_cd_seq_max.value);
   		var minSeq 	= parseInt(formObj.pck_cd_seq_min.value);
   		var totCnt 	= formObj.pck_cd_seq_cnt.value;
   		var updDt 	= formObj.upd_dt.value;
   		
   		if (maxSeq > 0) {
  	 		if (formObj.imdg_pck_instr_seq.value == "" ) {
  	 			ComShowCodeMessage('SCG50007', 'substance details');
  	 			ComSetFocus(formObj.imdg_pck_instr_cd);
  	 			return;
  	 		}else if (parseInt(formObj.imdg_pck_instr_seq.value)+1 > maxSeq ){
  	 			if (ComShowCodeConfirm("SCG50025")) {
	 				clearAll();
	 				formObj.imdg_pck_instr_cd.value = pckCd;
	 				formObj.pck_cd_seq_max.value = maxSeq;
	 				formObj.pck_cd_seq_min.value = minSeq;
	 				formObj.pck_cd_seq_cnt.value = totCnt;
	 				formObj.upd_dt.value = updDt;	 					
  	 				formObj.imdg_pck_instr_seq.value = maxSeq+1;
  	 				formObj.ibflag.value = "I";
   				}
  	 		}else{
 				clearAll();
 				formObj.imdg_pck_instr_cd.value = pckCd;
 				formObj.pck_cd_seq_max.value = maxSeq;
 				formObj.pck_cd_seq_min.value = minSeq;
 				formObj.pck_cd_seq_cnt.value = totCnt;
 				formObj.upd_dt.value = updDt;	 					
  	 	 		formObj.imdg_pck_instr_seq.value = parseInt(pckCdSeq)+1;
  	 	 		formObj.ibflag.value = "U";
		 	 	if(tabLoad[0] == false && document.form.imdg_pck_instr_cd.value != ""){
			  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			  	}
  	 		}
   		}
   	}
   	
   	/**
     * Form Object obj_keypress 이벤트시 처리
     * @param  void
     * @return void
     */     
     function obj_keypress (){
         var obj = event.srcElement;

         switch (obj.name){
              case 'imdg_pck_instr_cd':
            	  //ComKeyOnlyAlphabet('uppernum');
                   break;
         }
         
         if(beforetab == 0){
     		tabSave[1]= false;
     	}else if(beforetab == 1){
     		tabSave[2]= false;
     	}else if(beforetab == 2){
     		tabSave[3]= false;
     	}else if(beforetab == 3){
     		tabSave[4]= false;
     	}else if(beforetab == 4){
     		tabSave[5]= false;
     	}else if(beforetab == 5){
     		tabSave[6]= false;
     	}else if(beforetab == 6){
	 		tabSave[7]= false;
     	}
         
     }
     
     function formEnable(bEnable, tnk){

         ComEnableObject(document.form.imdg_pck_instr_cd, bEnable);
         ComEnableObject(document.form.imdg_pck_instr_seq, bEnable);
         if(tnk){		//조회 후에는 타지 않도록 설정
        	 ComEnableObject(document.form.pck_instr_tp_ctnt, bEnable);
         }else{
        	 ComEnableObject(document.form.pck_div_cd_radio[0], bEnable);
        	 ComEnableObject(document.form.pck_div_cd_radio[1], bEnable);
        	 ComEnableObject(document.form.pck_div_cd_radio[2], bEnable);
        	 ComEnableObject(document.form.pck_div_cd_radio[3], bEnable);
         }
         if(bEnable){			//재활성화 할 때 imdg_pck_instr_cd, pck_cd_seq가 필수 입력 표시 되도록
        	 document.form.imdg_pck_instr_cd.className = "input1";
        	 document.form.imdg_pck_instr_seq.className = "input1";
         }

     } 

	/* 개발자 작업  끝 */