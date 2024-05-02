/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0029.js
*@FileTitle : Send Mail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.06.03 김종준
* 1.0 Creation                        
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_SPC_0029 : ESM_SPC_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0029() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/** 개발자 작업	*/
 // 공통전역변수

    var sheetObjects = new Array();
    var comboObjects = new Array();
    
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //retrive check
    var check_retrive = false;
    var tab_retrives = new Array(3);
    //조회해온 결과의 week, 날짜
    var week;
    var fdtd;
    var rtn; 
    var portv;
    var week1;
    var fdtd1;
    var rtn1;  
    var portv1;

    var rlane_rtn_xml;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             /*******************************************************/
        	var sheetObj  = sheetObjects[0];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");
        		
        		
                switch(srcName) {
					case "btn_send":
						if (formObject.login_ofc_cd.value != "SELCDO" && formObject.login_ofc_cd.value != "SELCTY") return;
						doActionIBSheet(sheetObj, formObject, IBSAVE);					
						break;
					case "btn_close":
						window.close();
						break;	

                } // end switch
        	}catch(e) {
//        		alert(e);
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
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
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
    		comObjects[comboCnt++] = combo_obj;
        }
        
        
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	SpcSearchOptionYear("year1");
        	SpcSearchOptionWeek("week1");
        	
        	var formObj = document.form;
        	
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetResizeFull = true;
    		document_onresize();
    		

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            
            SpcSearchOptionRHQCombo("rhq",true,true);
            SpcSearchOptionTradeCombo("trade",true,true);
            SpcSearchOptionBound("bound",true,true);
            subtradeSetting();
            RevenueLaneSetting(); /* Multi Combo Data Setting */
            setContentMessage();
            formObj.duration.options.value="6";
            if (formObj.login_ofc_cd.value =="SELCDO" || formObj.login_ofc_cd.value =="SELCTY") {
            	document.getElementById("btn_send").disabled = false;
            } else {
            	document.getElementById("btn_send").disabled = true;
            }
        }
         
      //초기 contents 내용 세팅
      function setContentMessage() {
    	  var contents = document.getElementById("tcontents");
    	  var str = 
    		  ' <span style="font-size: 14px"><strong>TO&nbsp;:</strong></span><br> '
    		  +' <span style="font-size: 14px"><strong>FM : CDO-SP</strong></span> '
    		  +' <p>	Please refer the attached file listing the target VVDs for which your office has not input f&#39;cast yet.</p> '
    		  +' <p>	As soon as receiving this message, update f&#39;cast in the system.</p><BR> '
    		  +' <p>	Thanks &amp; Best Regards</p><BR> ';
    	  contents.value =str;
    	  
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
	    	  case "sheet1":      // sheet1 init
	    	  	with (sheetObj) {
	    	  }
	    	  break; 
    	  }
      }           
         
       // Sheet1관련 프로세스 처리
       function doActionIBSheet(sheetObj,formObj,sAction) {
    	   sheetObj.ShowDebugMsg = false;
    	   switch(sAction) {
    	   case IBSAVE:
    		   if(!validateForm(sheetObj,formObj,sAction)) {
    			   return false;
    		   }
									
    		   formObj.f_cmd.value = MULTI;
    		   
    		   var tcontents = CKEDITOR.instances.tcontents.getData();
    		   formObj.contents.value = tcontents;
    		   var sXml = sheetObj.GetSearchXml("ESM_SPC_0029GS.do", FormQueryString(formObj));
					
    		   var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    		   if (backendJobKey != null && backendJobKey.length > 0) {
    			   ComShowCodeMessage('COM12116', 'Email Send');
    			   self.close();
    		   }
    		   break;                
    	   }
       }	

       /**
        * 화면 폼입력값에 대한 유효성검증 프로세스 처리
        */
       function validateForm(sheetObj,formObj,sAction){
    	   var queryString = FormQueryString(formObj);
    	   var rhq = comObjects[0].Code;
    	   var trade = comObjects[1].Code;

    	   if(rhq==""){
    		   ComShowMessage(getMsg("SPC90114", "RHQ"));
    		   comObjects[0].focus();
    		   return false; 
    	   }
    	   if(trade==""){
    		   ComShowMessage(getMsg("SPC90114", "Trade"));
    		   comObjects[1].focus()
    		   return false; 
    	   }
    	   return true;
       }
    	
       /* Revenue Lane Setting */
       function RevenueLaneSetting(trdCd,subTrdCd) {
    	   if(trdCd == undefined || trdCd == null){
    		   trdCd = '';
    	   }     		
    	   if(subTrdCd == undefined || subTrdCd == null){
    		   subTrdCd = '';
    	   }     		
    	   rlane_rtn_xml = SpcSearchRevLane("rlane1",true,"N",true,trdCd,subTrdCd);    	
    	 	
    	   var rlane1_combo = document.getElementById("rlane1");
    	   ComXml2ComboItem(rlane_rtn_xml, rlane1_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
    	   rlane1_combo.InsertItem(0, "||ALL|ALL");
       }
    	
       /* subtrade Setting */
       function subtradeSetting(trdCd,subTrdCd) {
    	   if(trdCd == undefined || trdCd == null){
    		   trdCd = '';
    	   }     	
    	   if(subTrdCd == undefined || subTrdCd == null){
    		   subTrdCd = '';
    	   }         	 	
    	   subtrade_rtn_xml = SpcSearchOptionSubTradeCombo("subtrade1",true,"N",true,trdCd,subTrdCd);    	
    	   var subtrade1_combo = document.getElementById("subtrade1");
    	   ComXml2ComboItem(subtrade_rtn_xml, subtrade1_combo, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
    	   subtrade1_combo.InsertItem(0, "|ALL|ALL");
       }	    	

       /**
        * rhq 콤보를 클릭할 때 전체체크
        * @param comboObj
        * @param index
        * @param code
        * @return
        */
       function rhq_OnCheckClick(comboObj, index, code) {
    	   if (code == "" || code == "All") {
    		   var bChk = comboObj.CheckIndex(index);
    		   for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			   comboObj.CheckIndex(i) = bChk;
    		   }
    	   }else{
    		   comboObj.CheckIndex(0) = false;
    	   }
       } 
       /**
        * trade 콤보를 클릭할 때 전체체크
        * @param comboObj
        * @param index
        * @param code
        * @return
        */
       function trade_OnCheckClick(comboObj, index, code) {
    	   if (code == "" || code == "All") {
    		   var bChk = comboObj.CheckIndex(index);
    		   for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			   comboObj.CheckIndex(i) = bChk;
    		   }
        		
    	   }else{
    		   comboObj.CheckIndex(0) = false;
    	   }
    	   var formObj = document.form;
    	   
    	   var locCdT = subTraMutiCode(comboObj,'T');  // 0210 SHKIM 	   
    	   //RevenueLaneSetting(formObj.trade.Code);
    	   //subtradeSetting(formObj.trade.Code);
    	   RevenueLaneSetting(locCdT);	// 02.10 SHKIM    	   
    	   subtradeSetting(locCdT);		// 02.10 SHKIM
    	   
       }
        
       /**
       * subtrade 콤보를 클릭할 때 전체체크
       * @param comboObj
       * @param index
       * @param code
       * @return
       */
       function subtrade1_OnCheckClick(comboObj, index, code) {
    	   if (code == "" || code == "All") {
    		   var bChk = comboObj.CheckIndex(index);
    		   for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			   comboObj.CheckIndex(i) = bChk;
    		   }
    		   //0209 SHKIM SpcSearchOptionSubTrade
    		   /*
    		    * all 체크로직이므로 삭제함.
    		   SpcSearchOptionTrade("trade", true, true);
    		   SpcSearchOptionSubTrade("subtrade1",true,true,"","",code);			// 0207 SHKIM   			
    		   //SpcSearchOptionSubTrade("subtrade1",true,true);			// 0207 SHKIM
    		   SpcSearchOptionLane("rlane1",true,true,'',code,'',true);	// 0207 SHKIM
    		   */
    		   
    		   return;
    	   }else{
    		   comboObj.CheckIndex(0) = false;
    	   }
    	   var formObj = document.form;
    	   var locCdT = subTraMutiCode(comboObj,'T');  // 0210 SHKIM 
    	   var locCdS = subTraMutiCode(comboObj,'S');  // 0210 SHKIM 
    	   //RevenueLaneSetting(formObj.trade.Code,formObj.subtrade1.Code);	
    	   RevenueLaneSetting(locCdT,locCdS,true);	// 0210 SHKIM
 		   var totTrdCd = "";
		   for(var i = 0 ; i < comboObj.GetCount() ; i++) {
			   if ( comboObj.CheckIndex(i) == true ) {
				   totTrdCd = totTrdCd +comboObj.GetIndexText(i,0)+ ",";
			   }
		   }
		   comObjects[1].Code2 = totTrdCd;		//Trade 세팅
		   
		   
		   
       }
        
       /**
        * bound 콤보를 클릭할 때 전체체크
        * @param comboObj
        * @param index
        * @param code
        * @return
        */
       function bound_OnCheckClick(comboObj, index, code) {
    	   if (code == "" || code == "All") {
    		   var bChk = comboObj.CheckIndex(index);
    		   for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			   comboObj.CheckIndex(i) = bChk;
    		   }
    	   }else{
    		   comboObj.CheckIndex(0) = false;
    	   }
       }      

       /**
        * rlane1 콤보를 클릭할 때 전체체크
        * @param comboObj
        * @param index
        * @param code
        * @return
        */
       function rlane1_OnCheckClick(comboObj, index, code) {
    	   if (code == "" || code == "All") {
    		   var bChk = comboObj.CheckIndex(index);
    		   for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			   comboObj.CheckIndex(i) = bChk;
    		   }
    	   }else{
    		   comboObj.CheckIndex(0) = false;
     		   
    	   }
    	   
		   var totTrdCd = "";
		   var totSubTrdCd = "";
		   for(var i = 0 ; i < comboObj.GetCount() ; i++) {
			   if ( comboObj.CheckIndex(i) == true ) {
				   totTrdCd = totTrdCd +comObjects[4].GetIndexText(i,0)+ ",";
				   totSubTrdCd = totSubTrdCd +comObjects[4].GetIndexText(i,1)+ ",";
			   }
		   }

		   comObjects[1].Code2 = totTrdCd;		//Trade 세팅

		   var trdCdArr = totTrdCd.split(",");
		   var subTrdCdArr = totSubTrdCd.split(",");
		   for(var i = 0 ; i < comObjects[3].GetCount() ; i++) {
			   if ( trdCdArr != '' ) {
				   for(var j = 0 ; j < trdCdArr.length ; j++) {
					   if ( comObjects[3].GetIndexText(i,0) == trdCdArr[j] &&  comObjects[3].GetIndexText(i,1) == subTrdCdArr[j] ) {
						   comObjects[3].CheckIndex(i) = true;		//subTrade 세팅
					   } 
				   }
			   } else {
				   comObjects[3].CheckIndex(i) = false;		//subTrade 세팅
			   }
		   } 
       }
        /**
        * 조회 조건 [comboObj], [trdGubun] code value
        * 2012.02.07 SHKIM 
        * @param{elemName}	comboObj 필수
        * @param{isAll}		trdGubun필수	- trd_cd이면 T , sub_trd_cd이면 S
        */
        function subTraMutiCode(comboObj,trdGubun)
        {
        	var selCnt 		= 0;	// 선택된 건수 	
        	var sub_trd_cd_TR = "";  var sub_trd_cd_TR_tot = ""; var sub_trd_cd_STR = "";  var sub_trd_cd_STR_tot = "";
        		
        	for( ia=1 ; ia<comboObj.GetCount() ; ia++ ){
        	   if(comboObj.CheckIndex(ia)==true){
        		   selCnt++;
        				 if(trdGubun == 'T'){	   sub_trd_cd_TR = comboObj.GetIndexText(ia,0);
        		   }else if(trdGubun == 'S'){	   sub_trd_cd_STR = comboObj.GetIndexText(ia,1);
        		   }
        		   if(selCnt == 1){
        					  if(trdGubun == 'T'){	sub_trd_cd_TR_tot 	+= sub_trd_cd_TR;
        				}else if(trdGubun == 'S'){	sub_trd_cd_STR_tot 	+= sub_trd_cd_STR;
        				}
        		   }else{	
        				// 2개이상이면 중복제거를 위해 체크
        				if(trdGubun == 'T'){
        				   if(sub_trd_cd_TR != sub_trd_cd_TR_tot){	   sub_trd_cd_TR_tot 	+= ","+sub_trd_cd_TR;   }
        				}else if(trdGubun == 'S'){
        				   if(sub_trd_cd_STR != sub_trd_cd_STR_tot){   sub_trd_cd_STR_tot 	+= ","+sub_trd_cd_STR;   }
        				}
        		   }
        	   }
        	}
        		  if(trdGubun == 'T'){	return sub_trd_cd_TR_tot 	;
        	}else if(trdGubun == 'S'){	return sub_trd_cd_STR_tot ;
        	}
        }
/** 개발자 작업  끝 */