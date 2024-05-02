/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0002.js
*@FileTitle : Total Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.14 김종준
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cim_0002 : ees_cim_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cim_0073() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
   
    var head_cntr_tpsz_cd ="";
    var tot_cnmv_sts_cd ="";
    var tot_lstm_cd ="";
    var comboObjects = new Array();
    var comboCnt = 0 ;
    var period ='';
   
    var IBSEARCH01  = 29;
    var IBSEARCH02  = 30;
    var IBSEARCH04  = 32;
    
   	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
   	document.onclick = processButtonClick;

   	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
   	function processButtonClick(){
	    var formObject = document.form;
		try {
	   		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
			case "btn_New":		//조회조건 초기화
/*				comboObjects[0].Code = "";
				comboObjects[1].Code = "";
				comboObjects[2].Code = "";*/
				formObject.reset();
				sheetObjects[0].Redraw = false;
				sheetObjects[0].RemoveAll();
				sheetObjects[0].Redraw = true;
				document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd;
				document.form.period.value = period;
	            formObject.loc_cd.readOnly = true;
	            formObject.loc_cd.className = "input2";
	            formObject.loc_cd.value = "";
				break;
			case "btn_loc_cd":	//Location 조회 팝업
    	        var cnt_cd = "";
    	        var loc_cd = "";
	            cnt_cd = formObject.loc_type_code.value;
	            loc_cd = formObject.loc_cd.value;
	            if ( formObject.loc_type_code.value != '1' && formObject.loc_type_code.value != '2') {	
        			var loc_code = "";
                    // 2011.03.30 신자영 [CHM-201109821-01] [CIM] Inventory Stataus>Land Inventory의 Location 조회조건 추가
        			// case추가 - RCC (by ECC)
        			if ( form.loc_type_code.value == "3" ) {
        				loc_code = "rcc_cd";
        			} else if ( form.loc_type_code.value == "4" ) {
        				loc_code = "lcc_cd";
        			} else if ( form.loc_type_code.value == "5" ) {
        				loc_code = "lcc_cd";
        			} else if ( form.loc_type_code.value == "6" ) {
        				loc_code = "ecc_cd";
        			} else if ( form.loc_type_code.value == "7" ) {
        				loc_code = "scc_cd";
        			} else if ( form.loc_type_code.value == "8" ) { 
        				loc_code = "rcc_cd";
        			}
					var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);
	            }
				break;				
			case "btn_DownExcel":	//DOWN EXCEL
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
			case "btn_Retrieve":	//조회
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_Signal":		//Print
				ComOpenPopup('/hanjin/EES_CIM_0073_01.do', 320, 260, 'Signal', '1,0,1,1,1,1,1,1', true);
				break;
           } // end switch
   		} catch(e) {
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
     * 초기 이벤트 등록
     */
    function initControl() {
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');		//Location by 변경시 이벤트 처리
    	axon_event.addListener('change', 'tp_cd_onchange', 'tp_cd', '');		//TP/SZ 변경시 이벤트 처리
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd', '');
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
   		//axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', '');						//cntr_no keyup 이벤트 처리
   	//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
     function loc_type_code_onchange() {
         var formObject = document.form;
         if ( formObject.loc_type_code.value == '1' || formObject.loc_type_code.value == '2') {
             formObject.loc_cd.readOnly = true;
             formObject.loc_cd.className = "input2";
             formObject.loc_cd.value = "";
         } else {
             formObject.loc_cd.readOnly = false;
             formObject.loc_cd.className = "input";
         }
//         formObject.loc_cd.value = "";
         ComSetFocus(document.form.loc_cd);
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
     * 키이벤트 목록
     */
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
		}
	}
    
    /**
    * LOC_CD keyup 이벤트 처리
    * LOC_CD keyup시 대분자로 처리
    */
    function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        if ( formObject.loc_type_code.value == '2' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",2);
	        	    formObject.loc_cd.value = formObject.loc_cd.value.substring(0,2).toUpperCase();
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
	     	   if ( formObject.loc_cd.value.length == 5 ) {
	    		   ComSetFocus(document.form.focus_loc_cd);
	    	   }
	        }
        }
    }    
   
  
    /**
     * TP/SZ  클릭 이벤트 등록
     */
    function tp_cd_onchange() {
    	 var formObject = document.form;
    	 
    	 if(formObject.tp_cd.value == 2){
    		 formObject.tpList.value = 'D2,D4,D5,D7'
    	 }else if(formObject.tp_cd.value == 3){
    		 formObject.tpList.value = 'R2,R5,R9'
    	 }else if(formObject.tp_cd.value == 4){
    		 formObject.tpList.value = 'O2,O4,F2,F4'
    	 }else{
    		 formObject.tpList.value = 'D2,D4,D5,D7,R2,R5,R9,O2,O4,F2,F4';
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
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
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
       //makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
       var date =  new Date();
       var year = date.getFullYear();
       var month = new String(date.getMonth()+1);
       if(month.length == 1){
    	   period = year+"-0"+month;
       }else{
    	   period = year+"-"+month;
       }
       
       document.form.period.value = period;

	   initControl();

	   
    }
    
    /**
     * Lease Term  콤보코드 가져오기
     */
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
	    //MVMT Status
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
    
    /**
     * sheet1 로딩 완료시 이벤트 후출
     * TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
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
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle,tpSz) {

       var cnt = 0;

       switch(sheetNo) {
           case 1:      //t1sheet1 init
               with (sheetObj) {
                   // 높이 설정
                   style.height = 410;
                   //전체 너비 설정
                   //SheetWidth = mainTable.clientWidth;

                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                   Editable = false;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo(1, 1, 20, 100);
                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(false, true, true, true, false,false)

                   SheetWidth = 955;
                   style.width = 975;

                   if (headTitle==null || headTitle == 1) {
                	   headTitle = "RCC|Section/type|Total|";
                   }else if(headTitle == 3 ){
                	   headTitle = "LCC|Section/type|Total|";
                       SheetWidth = 535;
                       style.width = 555;
                   }else if(headTitle == 8 || headTitle == 4){
                	   headTitle = "ECC|Section/type|Total|";
                       SheetWidth = 475;
                       style.width = 495;
                   }
                   
                   if (tpSz==null || tpSz ==1) {
                	   headTitle = headTitle+"D2|D4|D5|D7|R2|R5|R9|O2|O4|F2|F4";
                       SheetWidth = 955;
                       style.width = 975;
                   }else if(tpSz == 2 ){
                	   headTitle = headTitle+"D2|D4|D5|D7";
                       SheetWidth = 535;
                       style.width = 555;
                   }else if(tpSz == 3 ){
                	   headTitle = headTitle+"R2|R5|R9";
                       SheetWidth = 475;
                       style.width = 495;
                   }else if(tpSz == 4 ){
                	   headTitle = headTitle+"O2|O4|F2|F4";
                       SheetWidth = 535;
                       style.width = 555;
                   }                   
                   
                   var headCnt  = headTitle.split("|").length;

                   InitColumnInfo(headCnt, 0, 0, true);
                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, headTitle, true);
                   sheetObj.FrozenCols = 3;
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtData,    50,    daCenterTop,	true,		"loc_cd",		false,  "",      dfNone,			0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,      165,    daLeft,	true,		"division",	false,  "",      dfNone,			0,     true,       true);
                   InitDataProperty(0, cnt++ , dtData,    	 70,    daRight,		true,		"total_cnt",	false,  "",      dfNone,		0,     true,       true);
                   for(var i=1 ; i <= headCnt - 3 ; i++){
                	   InitDataProperty(0, cnt++ , dtData,   60,    daRight,		true,		"qty"+i,		false,  "",      dfNone,		0,     true,       true);
                   }
                   CountPosition = 0;	//페이지카운트 없애기
                   
              }
              break;

       }
    }
   
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg = false;
       switch(sAction) {
         case IBSEARCH:      //조회
        	if(!validateForm(sheetObj,formObj,sAction)) return;
        	sheetObj.WaitImageVisible=false;
        	ComOpenWait(true);         	
  	        sheetObj.Redraw = false;
  	        formObj.f_cmd.value = SEARCH;
  	        initSheet(sheetObj,1,formObj.loc_type_code.value,formObj.tp_cd.value);
	        sheetObj.DoSearch("EES_CIM_0073GS.do",FormQueryString(formObj));
	        ComOpenWait(false); 
            break;
         case IBSEARCH01:      //공통조회
        	 sheetObjects[0].WaitImageVisible = false;
             form.f_cmd.value = SEARCH01;
             var sXml = sheetObj.GetSearchXml("EES_CIM_0073GS.do" , FormQueryString(form));

             //TP/SZ 조회
             var cntr_tpsz_cd = "D2|D4|D5|D7|R2|R5|R9|O2|O4|F2|F4";	   
             head_cntr_tpsz_cd = cntr_tpsz_cd;
             document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd; 
             var strCntrTpszCd  = cntr_tpsz_cd.split("|");
             var HeadTitle = "RCC|Section/type|Total|"+head_cntr_tpsz_cd;
             
             sheetObj.Redraw = false;
             sheetObj.RemoveAll();
             sheetObj.Reset();
             initSheet(sheetObj,1,HeadTitle);
             sheetObj.Redraw = true;   
                               
        	 break;
         case IBSEARCH02:      //YYYYWW 조회 및 batch주 여부 조회
             sheetObj.WaitImageVisible = false;
             form.f_cmd.value = SEARCH02;
             var sXml = sheetObj.GetSearchXml("EES_CIM_0073GS.do" , FormQueryString(form));
             var batFlg = ComGetEtcData(sXml,"bat_flg");	     //batch주 여부
             var preBatWk = ComGetEtcData(sXml,"pre_bat_wk"); //이전 batch주
         	 var thsWk = ComGetEtcData(sXml,"ths_wk");	     //이번주
         	
         	 document.form.bat_flg.value = batFlg;
         	 document.form.pre_bat_wk.value = preBatWk;
         	 document.form.ths_wk.value = thsWk;

         	 var yyyy = thsWk.substring(0,4);
         	 var ww = thsWk.substring(4,7);
         	 document.form.period.value = yyyy+"-"+ww;
    	     break;        	 
	      case IBDOWNEXCEL:      // 입력
	    	  sheetObj.Down2Excel(-1, false, false, true);
 	         break;
	      case IBSEARCH04: //location focusOut
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == 1 ) {
					inquiryLevel = "R";
				} else if ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel = "C";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel = "R";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 6 ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_type_code.value == 7 ) {
					inquiryLevel = "S";
				}
				
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				formObj.f_cmd.value = SEARCH04;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM29013");
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.lstm_cd);
				}
		
				break;     
       }
    }

   	/**
    * sheet1 조회종료
    * sheet1 조회종료후 이벤트 호출
    */
   	function sheet1_OnSearchEnd(sheetObj, msg){
   		var tpCd = document.form.tp_cd.value;
	    var y = 13;
   			
			if(tpCd == 2 || tpCd == 4){
   				y = 6;
   			}else if(tpCd ==3){
   				y = 5;
   			}  
   			
	   	for(var i=1; i<=sheetObj.LastRow; i++){
	   		if(sheetObj.CellValue(i,1) == 'Signal'){	   			

   				for(var x=2; x<=y; x++){
   					var ratio = sheetObj.CellValue(i,x);
   					sheetObj.CellValue(i,x) = '●';
   					sheetObj.CellFont("FontSize", i,x) = 15;
   					sheetObj.CellAlign(i,x) = daCenterTop;
   					if(ratio > 1.4){
   						sheetObj.CellFontColor(i, x) =  sheetObj.RgbColor(255, 0, 0);
   					}else if((ratio >= 1) && (ratio < 1.5)){
   						sheetObj.CellFontColor(i, x) =  sheetObj.RgbColor(53, 182, 44);
   					}
 	
   				}
	   			sheetObj.RowHeight(i) = 30;	   			
	   		}
	   		
	   		if(sheetObj.CellValue(i,0) != 'TOTAL'){
	   			if(sheetObj.CellValue(i,1) == 'Inventory (MT)'){
	   				for(var x=2; x<=y; x++){
	   					if(sheetObj.CellValue(i,x) != '0'){
	   						var locCd = sheetObj.CellValue(i,0);
	   						if(sheetObj.CellValue(i+1,0) == locCd){
	   							if(sheetObj.CellValue(i+1,x) == '0'){
	   								sheetObj.CellFontColor(i+5, x) =  sheetObj.RgbColor(255, 0, 0);
	   							}
	   						}
	   					}  					
	   				}
	   			}
	   		}	   		
	   		
	   		if(sheetObj.CellValue(i,0) == 'TOTAL'){
	   			sheetObj.RowBackColor(i) = sheetObj.RgbColor(247,225,236);
	   			for(var x=0; x<=y; x++){
	   				sheetObj.CellFont("FontBold", i, x) = true;	
	   			}  
	   		}
	   		if(sheetObj.CellValue(i,1) != 'Signal'){
	   			for(var x=2; x<=y; x++){
	   				sheetObj.CellValue(i,x) = numComma(sheetObj.CellValue(i,x))
	   			}  
	   		}
	   	}  

	   	sheetObj.SelectHighLight = false;
	   	sheetObj.Redraw = true;
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
                   InsertTab( cnt++ , "Inventory" , -1 );
                   InsertTab( cnt++ , "Long Staying" , -1 );
                   InsertTab( cnt++ , "Match Back" , -1 );
                   InsertTab( cnt++ , "Turn Time" , -1 );
               }
            break;
        }
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
	   	with(formObj){
		  	var formObject = document.form;
	
		  	if ( doActionIBSheet(sheetObj, document.form, IBSEARCH04) ) {	//Location 유효성체크
		  		ComSetFocus(formObject.loc_cd);
	 	        return false;
	 	    } else {
	 	    	if(formObj.loc_type_code.value != "1" && formObj.loc_type_code.value != "2" && formObj.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	
	    	  	return true;
	 	    }
		}
		return true; 
    }
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	
    
    function numComma(num){
 	   num = String(num);
	   return num.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,"$1,"); 	
    }
    