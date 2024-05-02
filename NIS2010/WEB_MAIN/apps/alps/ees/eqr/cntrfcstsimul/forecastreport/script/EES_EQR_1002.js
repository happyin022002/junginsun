/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1002.js
*@FileTitle : History Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1002 : EES_EQR_1002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1002() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var HeadTitleCnt = 0;
    var yyyyMm = "";
	
	var comboObjects = new Array();
    var comboCnt = 0 ;
    
    var rptTtl = "";
    var rptTtlArr = new Array();
    
	// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //     
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|S2|O4|S4|O5"; // OT  TYPE SIZE 
    var tpszotCode  = "O2|S2|O4|S4|O5";
    var tpszfrText  = "F2|A2|F4|A4|F5|A5"; // FR  TYPE SIZE 
    var tpszfrCode  = "F2|A2|F4|A4|F5|A5"; 
    
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,O5,F2,A2,F4,A4,F5,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,S2,O4,S4,O5";
    var consTpszFr    = "F2,A2,F4,A4,F5,A5";
	// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
    	var sheet1 = sheetObjects[shtCnt];
    	var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
    		case "btn_Retrieve":
    			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    			break;
    		case "btn_downExcel":
    			sheetObjects[0].Redraw = false;
    			sheetObjects[0].WaitImageVisible = true;
//    			sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"tree");
    			
    			// excel 에서 감출 column 조립
    			var hidden_col = "tree";
    			for(i = 0; i < rptTtlArr.length; i++){
    				hidden_col += "|img_"+rptTtlArr[i]; 
    			}
    			
                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false, hidden_col);
    			
    			
    			sheetObjects[0].Redraw = true;
    			break;
    			
    		case "btn_loc_cd":	//Location By 조회 팝업
    			
    			if(document.form.loc_cd.value != "" && document.form.div_flag[0].checked == true) {
					var code_type = formObject.loc_type_code.value;
		
					if(code_type.substr(0,1) == "E") {
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
					}else if(code_type.substr(0,1) == "R") {	
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "rcc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
				    }else if(code_type.substr(0,1) == "L"){
				    	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:sub_loc_cd", "0,1,1,1,1,1", true);
				    }
					//obj_blur();
    			}
			    
				break;  
				
    		case "btn_loc_cd_second":	//Location 조회 팝업

    			if(document.form.loc_cd.value != "" && document.form.div_flag[1].checked == true) {	
					var code_type = formObject.loc_tp_cd_second.value;
		
					if(code_type.substr(0,1) == "E") {
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd_second", "0,1,1,1,1,1", true);
					}else if(code_type.substr(0,1) == "L") {	
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd_second", "0,1,1,1,1,1", true);
				    }else if(code_type.substr(0,1) == "S"){
				    	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd_second", "0,1,1,1,1,1", true);
				    }
					//obj_blur();
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
     * 초기 이벤트 등록 
     */
    function initControl() {
     	axon_event.addListener('keyup', 'sub_loc_cd_onkeyUp', 'sub_loc_cd');					//LOC_CD keyup 이벤트 처리
     	axon_event.addListener('keyup', 'loc_cd_second_onkeyUp', 'loc_cd_second');				//LOC_CD keyup 이벤트 처리

     	axon_event.addListener('keyup', 'from_bse_dt_onkeyUp', 'from_bse_dt');					//from_bse_dt keyup 이벤트 처리
     	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
     	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');								//엔터키 조회 이벤트처리
     	axon_event.addListener('blur', 'obj_blur', 'sub_loc_cd');								//Location  blur 이벤트 처리
     	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
     	
     	axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd');						//RCC 변경시 이벤트 처리
     	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');		//Location by 변경시 이벤트 처리
     	axon_event.addListener('change', 'loc_tp_cd_second_onchange', 'loc_tp_cd_second');	//Location 변경시 이벤트 처리
     	
		axon_event.addListenerForm('change','form_change',form);
		
     	loc_cd_onchange();  // RCC 이벤트 호출하여 라디오버튼을 통제(비활성화)        	
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
     * 설  명 : IBCombo Object를 배열로 등록 <br>
     *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *          배열은 소스 상단에 정의<br>
     * <br><b>Example : </b>
     * <pre>
     *     setComboObject(combo_obj)
     * </pre>
     * @param {object}  combo_obj - Combo Object
     * @see #링크연결
     * @author 작성자
     * @version 
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
//            sheetObjects[i].Visible = true;
        }
        initControl();
		
		for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
        tpszChange('D'); // Dry 선택
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
	    var shtID = sheetObj.id;
		
	    if(rptTtl != ""){
	    	rptTtlArr = rptTtl.split(",");
	    }
	    switch(shtID) {
	    	case "sheet1":      //sheet1 init
	    		with (sheetObj) {
	    			   // 높이 설정
	    			   style.height = 600;
	                   //전체 너비 설정
	                   SheetWidth = 800;
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msPrevColumnMerge;

	                   //전체Edit 허용 여부 [선택, Default false]
	                   Editable = false;

	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo(2, 1, 10, 100);
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(false, false, false, false, false,false)

	                   var HeadTitle1 = "GRP|LOC|T|Section/type||||";
	                   var HeadTitle2 = "GRP|LOC|T|Section/type||||";
	                   for(var i = 0; i < rptTtlArr.length; i++){
//	                	   for(var j = 0; j < 18; j++){
	                	   //for(var j = 0; j < 19; j++){
	                	   for(var j = 0; j < 20; j++){	   
	                		   HeadTitle1 += "|" + rptTtlArr[i];
	                	   }
//	                	   HeadTitle2 += "|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5|TTL";
	                	   HeadTitle2 += "||D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|TTL";
	                   }
	                   HeadTitleCnt = ComCountHeadTitle(HeadTitle1);
	                   InitColumnInfo(HeadTitleCnt, 0, 0, true);
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   //Rows = 36;
	                   InitHeadRow(0, HeadTitle1, true);
	                   InitHeadRow(1, HeadTitle2, true);
	                   sheetObj.FrozenCols = 7;
	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                   InitDataProperty(0, cnt++ , dtHidden, 	30,	  daCenter,		true,		"loc_grp_cd", 		  false,  "", 	   dfNone,		    0,	   true,	  true);
	                   InitDataProperty(0, cnt++ , dtData,     	80,   daCenter,		true,		"loc_cd",			  false,  "",      dfNone,		    0,     true,      true);
	                   
	                   InitDataProperty(0, cnt++ , dtData,   	15,   daCenter,		true,		"tree",				  false,  "",      dfNone,		    0,     true,      true);
	                   InitDataProperty(0, cnt++ , dtData,    	130,   daLeft,		true,		"name",				  false,  "",      dfNone,		    0,     true,      true);
	                   
	                   InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,	    false,		"ori_loc_cd",		  false,  "",      dfNone,		    0,     true,      true);
	                   InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,	    false,		"ori_ori_loc_cd",	  false,  "",      dfNone,		    0,     true,      true);
	                   InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,	    false,		"ori_ori_ori_loc_cd", false,  "",      dfNone,		    0,     true,      true);
					   InitDataProperty(0, cnt++ , dtHidden,     0,   daRight,      false,      "code",               false,  "",      dfNone,          0,     true,      true);
	                   for(i = 0; i < rptTtlArr.length; i++){
	                       InitDataProperty(0, cnt++,  dtImageText, 20,   daCenter,     true,       "img_"+rptTtlArr[i],            false,  "", dfNone, 0, false, false);
	                	   
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"d2"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"d4"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"d5"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"d7"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"r2"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"r5"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"r9"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"o2"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"s2"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"o4"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"s4"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"o5"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"f2"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"a2"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"f4"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"a4"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"f5"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
		                   InitDataProperty(0, cnt++ , dtData,      40,   daRight,	    false,		"a5"+rptTtlArr[i],				false,  "",      dfNumber,			0,     true,       true);
						   
						   InitDataProperty(0, cnt++ , dtData,      60,   daRight,      false,      "ttl_"+rptTtlArr[i],            false,  "",      dfNumber,     0,     true,       true);
	                   }
	                   CountPosition = 0;
					   
					   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
	                   SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
	                   SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
	                   
	                   ImageList(0) = "img/btns_search_off.gif";
	                   ImageList(1) = "img/btns_search.gif";     // popup icon 이미지
	                   ImageList(2) = "img/btns_note.gif";  	                   
	    		}
	    		break;
	    }
	}
	
	  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
		sheetObj.ShowDebugMsg = false;  
	    switch(sAction) {
	       case IBSEARCH:      //조회
	    	   if(document.form.div_flag[0].checked == true) {
	    		   if(formObj.sub_loc_cd.value != "" && !doActionIBSheet(sheetObjects[0], document.form, SEARCH02)){
	    			   return false;
	    		   }
	    	   }else {
	    		   if(formObj.loc_cd_second.value != "" && !doActionIBSheet(sheetObjects[0], document.form, SEARCH03)){
	    			   return false;
	    		   }	    		   
	    	   }	
	    	   
	    	   if(!validateForm(sheetObj,formObj,sAction)){
	       			return false;
	       	   }
	    	   
	    	   sheetObjects[0].RemoveAll();
	           
	    	   formObj.f_cmd.value = SEARCH;
	    	   
	    	   sheetObj.WaitImageVisible=false;
	    	   ComOpenWait(true); 
	    	   var mainXml = sheetObj.GetSearchXml("EES_EQR_1002GS.do" , FormQueryString(formObj));
	    	   rptTtl = ComGetEtcData(mainXml, "rpt_ttl");
	    	   initSheet(sheetObj,1);
	    	   sheetObj.LoadSearchXml(mainXml);
	    	   search_end(sheetObj);
			   
			   setGridHidden(formObj.tpsztype.Text);
			   calcBalance2(sheetObj.HeaderRows, sheetObj.HeaderRows+sheetObj.RowCount("R"), false); // Balance 및 EQ Supply Ratio (PFMC) 계산
			   calcTotal(sheetObj.HeaderRows, sheetObj.HeaderRows+sheetObj.RowCount("R")); // TTL 계산
			   
        	   ComOpenWait(false);
	    	   break;
	    	   
	       case SEARCH02:      //조회
           
	    	   formObj.f_cmd.value = SEARCH02;
	    	   
	    	   sheetObj.WaitImageVisible=false;
    		   var sXml = sheetObj.GetSearchXml("EES_EQR_1003GS.do" , FormQueryString(formObj)+"&head_week="+(i+1));
    		   var sCheck = ComGetEtcData(sXml, "check");
					
				if (sCheck != "T") {
					if (document.form.sub_loc_cd.value != "") {
						if (document.form.loc_type_code.value == "ES") {
							ComShowCodeMessage("EQR01006");
						}else if (document.form.loc_type_code.value == "LE" || document.form.loc_type_code.value == "LS") {
							ComShowCodeMessage("EQR01005");
						}else if (document.form.loc_type_code.value == "RE" || document.form.loc_type_code.value == "RS") {
							ComShowCodeMessage("EQR01004");
						}
						
						document.form.sub_loc_cd.value = "";
						ComSetFocus(document.form.sub_loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.sub_loc_cd);
						return true;
					}
	    	   }
				return true;
	    	   break;
	    	   
	       case SEARCH03:      // Location 조회
	           
	    	   formObj.f_cmd.value = SEARCH02; // 위와 동일함(주의)
	    	   
	    	   sheetObj.WaitImageVisible=false;
    		   var sXml = sheetObj.GetSearchXml("EES_EQR_1003GS.do" , FormQueryString(formObj)+"&head_week="+(i+1));
    		   var sCheck = ComGetEtcData(sXml, "check");
				
				if (sCheck != "T") {
					if (document.form.loc_cd_second.value != "") {
						if ( formObj.loc_tp_cd_second.value == 'E' ) {
							ComShowCodeMessage("EQR01006");
						} else if ( formObj.loc_tp_cd_second.value == 'L' ) {
							ComShowCodeMessage("EQR01005");
						} else if  ( formObj.loc_tp_cd_second.value == 'S' ) { // LCC 단위검색
							ComShowCodeMessage("EQR01007");
						}
						
						document.form.loc_cd_second.value = "";
						ComSetFocus(document.form.loc_cd_second);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd_second);
					}
				}
				return true;
	    	   break;	    	   		    	   	    	   
	    }
	}
    
    /**
    * 모든 시트 조회 후
    */    
   function search_end(sheetObj) {
	   with (sheetObj) {
		  sheetObj.CellFont("FontBold", 1, "tree", sheetObj.LastRow, "tree") = true;
		  sheetObj.CellFont("FontSize", 1, "tree", sheetObj.LastRow, "tree") = 10;
		  
		  // total 색상변경
          for(var k=0; k<rptTtlArr.length; k++){
              sheetObj.ColBackColor("ttl_"+rptTtlArr[k]) = sheetObj.RgbColor(193,196,232);
          }          
		  
		  for(var i=HeaderRows; i<=HeaderRows+RowCount; i++){
		  	  if(CellValue(i, "code") == "SP" || CellValue(i, "code") == "ST"){
                  RowBackColor(i) = sheetObj.WebColor2SysColor("#D0EC7F"); // 연두색 
              }else if(CellValue(i, "code") == "BA"){
                  RowBackColor(i) = sheetObj.WebColor2SysColor("#FFFFA0"); // 노란색 
                                
			  }else if(CellValue(i, "code") == "RI" || CellValue(i, "code") == "OT" || CellValue(i, "code") == "RO") { // Reposition In, Other, Reposition Out
				  if(CellValue(i, "loc_cd") != "TOTAL" && CellValue(i, "loc_grp_cd") != "R") {  // LOC : TOTAL, RCC 는 제외
					  
						  for(var k=0; k<rptTtlArr.length; k++){  // 선택된 WEEK, MONTH 만큼
							  sheetObj.CellImage(i, "img_"+rptTtlArr[k]) = 1; // 조회 팝업 이미지
						  }	  
					 
				  }
			  }

		  }		  
	   }
   }
    
  /**
   * shee1 클릭시 이벤트 발생
   */
  function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
	  with (sheetObj) {
		  if(ColSaveName(Col) == "tree"){
			  var addRow = (parseInt(((Row-2)/10))+1)*10+2;     //선택한 세트 아래에 삽입하기 위한 row 계산
			  var locGrpCd = "";
			  if (CellValue(Row, "loc_grp_cd") == "R"){
				  locGrpCd = "L";
			  }else if (CellValue(Row, "loc_grp_cd") == "L"){
				  locGrpCd = "E";
			  }else if (CellValue(Row, "loc_grp_cd") == "E"){
				  locGrpCd = "S";
			  }
			  
			  if(locGrpCd == "") return;  // SCC 는 +- 작동하지 않음(중요).
			  
			  var locCd = CellValue(Row, "loc_cd").substr(0,5);
			  if(CellValue(Row, Col) == "+"){
				  if(CellValue(Row, "loc_cd").substr(0,5) != CellValue(addRow, "ori_loc_cd") || CellValue(addRow, "loc_grp_cd") != locGrpCd){	//최초 클릭시만 조회
					  var formObj = document.form;
				  	  formObj.f_cmd.value = SEARCH;
				  	  var endRow = 0;
					  if(locGrpCd == "L" || locGrpCd == "E" || locGrpCd == "S"){	//loc_grp_cd가 L이거나 E이거나 S일 때만 조회(R일 때는 최초 조회함)
					  	  ComOpenWait(true); 
					  	  var param = "f_cmd=" 			+ formObj.f_cmd.value
						  			+ "&pagerows=" 		+ formObj.pagerows.value
						  			+ "&level_cd=" 		+ formObj.level_cd.value
						  			+ "&ofc_cd=" 		+ formObj.ofc_cd.value
						  			+ "&period=" 		+ formObj.period.value
						  			+ "&fmdate=" 		+ formObj.fmdate.value
						  			+ "&todate=" 		+ formObj.todate.value
						  			+ "&loc_grp_cd=" 	+ locGrpCd
						  			+ "&loc_cd=" 		+ locCd
						  			+ "&ori_loc_cd=" 	+ CellValue(Row, "ori_loc_cd")
						  			+ "&ori_ori_loc_cd=" 	+ CellValue(Row, "ori_ori_loc_cd")
						  			+ "&div_flag=0"  // 왼쪽 +클릭을 의미함 (중요)
						  			;
				    		   var sXml = sheetObj.GetSearchXml("EES_EQR_1002GS.do", param );
				    		   sheetObj.LoadSearchXml(sXml, true, addRow);
				    		   endRow = parseInt(ComGetTotalRows(sXml));
				    		   search_end(sheetObj);
				    	  }
						  
						  //추가되는 영역만 계산
						  calcBalance2(addRow, addRow + endRow, false);
						  calcTotal(addRow, addRow + endRow);
						  ComOpenWait(false); 
					  }
				  for(var i = addRow-10; i < addRow; i++){	
					  CellValue2(i, Col) = "-";
					  CellFont("FontBold", i, "tree", i, "tree") = true;
					  CellFont("FontSize", i, "tree", i, "tree") = 13;
				  }
			  }else if(CellValue(Row, Col) == "-"){	//실제로 펼쳐진 경우에만 감춤
				  for(var i = Row; i <= LastRow; i++){
					  if((CellValue(i, "loc_grp_cd") == locGrpCd && CellValue(i, "ori_loc_cd") == locCd) || 
							  ((locGrpCd == "E") && (CellValue(i, "loc_grp_cd") == "S" && CellValue(i, "ori_ori_loc_cd") == locCd)) || 
							  ((locGrpCd == "L") && (CellValue(i, "loc_grp_cd") == "E" && CellValue(i, "ori_ori_loc_cd") == locCd) || (CellValue(i, "loc_grp_cd") == "S" && CellValue(i, "ori_ori_ori_loc_cd") == locCd))){
							sheetObj.RowDelete(i, false);	
							i--;
					  }
				  }
				  for(var i = addRow-10; i < addRow; i++){	
					  CellValue2(i, Col) = "+";
					  CellFont("FontBold", i, "tree", i, "tree") = true;
					  CellFont("FontSize", i, "tree", i, "tree") = 10;
				  }
			  }
		  }
		  
		  // 돋보기 IMAGE 클릭
          if (ColSaveName(Col).substr(0,3) == "img") {
          	
              if(CellImage(Row,Col)=="-1" || CellImage(Row,Col)=="0"){ // popup 이미지 없거나, off 이면
                return false;
              }
              
    	 	  if(CellValue(Row,"code")=="RI"){
    	 		      	 		  
		          var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
//		                     +"&fcast_yrwk=" + sheetObj.CellValue(Row, sheetObj.ColSaveName(Col).substr(0,2)) 
		                     +"&fcast_yrwk=" + ColSaveName(Col).substr(4,6)
		                     +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
		                     +"&tp_cd="	+ document.form.period.value	                     
                             +"&f_cmd=" + SEARCH
		               ;

		          // popup page separator
		          var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
		            
		          ComOpenWindowCenter("/hanjin/EES_EQR_1081.do?"+ param, "EES_EQR_1081"+page_sep, 1015, 735); 
		            
  	 		  }else if(CellValue(Row,"code")=="OT"){ 
		          var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
                             +"&fcast_yrwk=" + ColSaveName(Col).substr(4,6)                     
                             +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
                             +"&tp_cd="	+ document.form.period.value
                             +"&f_cmd=" + SEARCH
                  	      ;
		          // popup page separator
		          var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
           
		          ComOpenWindowCenter("/hanjin/EES_EQR_1083.do?"+ param, "EES_EQR_1083"+page_sep, 1015, 735); 
  	 			
  	 		  }else if(CellValue(Row,"code")=="RO"){ // Reposition Out 팝업
		          var param = "loc_cd=" + sheetObj.CellValue(Row,"loc_cd").substr(0,5)
                             +"&fcast_yrwk=" + ColSaveName(Col).substr(4,6)                    
                             +"&loc_grp_cd=" + sheetObj.CellValue(Row,"loc_grp_cd")
                             +"&tp_cd="	+ document.form.period.value
                             +"&f_cmd=" + SEARCH
                  	;
		          // popup page separator 
		          var page_sep = sheetObj.CellValue(Row,sheetObj.ColSaveName(Col).substr(0,2)) + sheetObj.CellValue(Row,"loc_cd").substr(0,5);
           
		          ComOpenWindowCenter("/hanjin/EES_EQR_1082.do?"+ param, "EES_EQR_1082"+page_sep, 1015, 735); 

  	 		  }		  
          }
          
	  }
  }
   
   	/**
    * 모든 sheet 클릭시 이벤트 발생
   	*/
  	function inv_popUp(sheetObj, Row, Col){
	   with (sheetObj) {
		   var locTypeCode = "";
		   var inquiryLevel = "";
		   if(CellValue(Row, "loc_grp_cd") == "R"){
			   locTypeCode = "3";
			   inquiryLevel = "R";
		   }else if(CellValue(Row, "loc_grp_cd") == "L"){
			   locTypeCode = "4";
			   inquiryLevel = "L";
		   }else if(CellValue(Row, "loc_grp_cd") == "L"){
			   locTypeCode = "6";
			   inquiryLevel = "E";
		   }else{
			   locTypeCode = "7";
			   inquiryLevel = "S";
		   }
		   var param = "eqr_loc_type_code=" + locTypeCode
			   +"&eqr_loc_cd=" + CellValue(Row, "loc_cd").substr(0,5);
		   	   +"&location=" + CellValue(Row, "loc_cd").substr(0,5);
		   	   +"&inquiryLevel=" + inquiryLevel;
		   ComOpenPopup("/hanjin/EES_CIM_0008.do?"+ param,1000, 700, "", "1,0,1,1,1,1,1,1", true);
	   }
   }

    // 유효 입력 date 조건
    function isValidDate(date, period){
    	if(period == "M"){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidMonth(date)){
    			return true;
    		} else {
    			return false;
    		}
    	} else if(period == "W"){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidWeek(date)){
    			return true;
    		} else {
    			return false;
    		}
    	}
    }

    // 유효 연차 체크
    function isValidYear(yyyyww) {
    	var year = yyyyww.substring(0,4);
    	if (parseInt( year ) >= 1900) {
    		return true;
    	} else {
    		return false;
    	}
    }    
    
    // 유효 월차 체크
    function isValidMonth(yyyymm) {
    	var month = yyyymm.substring(4,6);
       	var intmonth = parseInt( month , 10 );
       	if( intmonth >= 1  && intmonth <= 12 ) {
       		return true;
       	} else {
       		return false;
       	}
    }
    
    // 유효 주차 체크
    function isValidWeek(yyyyww) {
    	
    	var week = yyyyww.substring(4,6);
    	if (parseInt( week , 10) >= 1 &&  parseInt(week , 10) <= 53) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	var pd = formObj.period.value;
        	var fm = formObj.fmdate.value;
        	var to = formObj.todate.value;
        	
        	if(pd == "W"){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR01012", "From Week");//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR01012", "To Week");//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		
        		var fromTo = 52;  // 52주간격을 의미함(01-53)
        		var fmyyyy = fm.substr(0,4);
        		var fmWeek = fm.substr(4,2);
        		var toyyyy = to.substr(0,4);
        		var toWeek = to.substr(4,2);
        		var yyyyDiff = fromTo * (parseInt(toyyyy)-parseInt(fmyyyy));
        		var fmToDiff = yyyyDiff + toWeek*1 - fmWeek*1; 

        		if(fmToDiff > 19){ // 20 주차 이상이면
        			ComShowCodeMessage("EQR01010");//
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}else if(pd == "M"){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR01012", "From Month");//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR01012", "To Month");
        			eval("formObj.todate").focus();
        			return false;
        		}
        		
				var fromTo = 12;  // 12달을 의미함(01-53)
        		var fmyyyy = fm.substr(0,4);
                var fmMonth = fm.substr(4,2);
                var toyyyy = to.substr(0,4);
                var toMonth = to.substr(4,2);
                var yyyyDiff = fromTo * (parseInt(toyyyy)-parseInt(fmyyyy));
                var fmToDiff = yyyyDiff + toMonth*1 - fmMonth*1; 
				
        		if(fmToDiff > 19){ // 20 달 이상이면
                    ComShowCodeMessage("EQR01011");
                    eval("formObj.fmdate").focus();
                    return false;
                }
        	}
        	
        	if(fm > to){
        		ComShowCodeMessage("EQR01013") // End date must be greater than start date.
        		eval("formObj.todate").focus();
        		return false;
        	}
        }
        return true;
    }

	
	function calcBalance2(startRow, endRow, ttlFlg){ // 속도를 개선 
        // ttlFlg = true 인 경우는 TTL_ column 만 계산, false 인 경우 TTL_ column 제외 하고 계산 
        // TTL_column 만 계산 하는 건 calcTotal() 에서 호출 함
		
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");
		
        var sheetObj = sheetObjects[0];
        if(rptTtl != ""){
            rptTtlArr = rptTtl.split(",");
        }
        
        // Balance 계산로직 
        // Inventory + Reposition In + Other(LT/ST/OW) + MG Performance - OP Performance - Reposition Out
        
        // EQ Supply Ratio (PFMC) 계산로직
        // [Inventory + Reposition In + Others(LT/ST/OW) + MG Performance] / OP Performance 
        
        var tmpIn = 0;
        var tmpRi = 0;
        var tmpOt = 0; 
        var tmpIf = 0;
        var tmpOf = 0;
        var tmpRo = 0;
        var tmpBa = 0;
        var tmpSrp = 0; // EQ Supply Ratio PFMC
        var tmpSrt = 0; // EQ Supply Ratio Target
        
        var tmpBalance = 0; // Balance 계산
        var tmpEsrPfmc = 0; // EQ Supply Ratio (PFMC) 계산
        
        with (sheetObj) {
			for (var i = startRow; i <= endRow; i++) {
				if(CellValue(i,"name") == "Balance"){// Balance
				    if(!ttlFlg){ // 선택된 tpsz 만 계산
				        for (var j = 0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
						    if(CellValue(i,arr_tpsz[j].toLowerCase()+rptTtlArr[0]) == ''){//계산된적 없을 때만,
							    for (var k = 0; k < rptTtlArr.length; k++) {//주차별
									tmpIn = parseInt(CellValue(i-7,arr_tpsz[j].toLowerCase()+rptTtlArr[k]));
									tmpRi = parseInt(CellValue(i-6,arr_tpsz[j].toLowerCase()+rptTtlArr[k]));
									tmpOt = parseInt(CellValue(i-5,arr_tpsz[j].toLowerCase()+rptTtlArr[k])); 
									tmpIf = parseInt(CellValue(i-4,arr_tpsz[j].toLowerCase()+rptTtlArr[k]));
									tmpOf = parseInt(CellValue(i-3,arr_tpsz[j].toLowerCase()+rptTtlArr[k]));
									tmpRo = parseInt(CellValue(i-2,arr_tpsz[j].toLowerCase()+rptTtlArr[k]));
									tmpBa = tmpIn + tmpRi + tmpOt + tmpIf - tmpOf - tmpRo;
									CellValue2(i,arr_tpsz[j].toLowerCase()+rptTtlArr[k]) = tmpBa;
									if(tmpBa < 0){
                                        CellFontColor(i, arr_tpsz[j].toLowerCase()+rptTtlArr[k]) = RgbColor(255,0,0);
                                    }
									
									if(tmpOf==0){
									  CellValue2(i+1,arr_tpsz[j].toLowerCase()+rptTtlArr[k]) = "";
									}else{
									  tmpSrp = (tmpIn + tmpRi + tmpOt + tmpIf)/tmpOf;
									  CellValue2(i+1,arr_tpsz[j].toLowerCase()+rptTtlArr[k]) = tmpSrp.toFixed(1); // 소수점 1째 자리로 반올림
									}
									
//									if(CellValue(i,"loc_cd")=="TOTAL"||CellValue(i,"loc_grp_cd")=="R")
//    									CellValue2(i+2,arr_tpsz[j].toLowerCase()+rptTtlArr[k]) = ""; // Target 은 계산 안함
									
									// 변수 초기화
									tmpIn = 0;
									tmpRi = 0;
									tmpOt = 0; 
									tmpIf = 0;
									tmpOf = 0;
									tmpRo = 0;
									tmpBa = 0;
									tmpSrp = 0;
									tmpSrt = 0;
								}
							}
						}
		            }else{ // TTL 만 계산
						for (var k = 0; k < rptTtlArr.length; k++) {
                            tmpIn = parseInt(CellValue(i-7,"ttl_"+rptTtlArr[k]));
                            tmpRi = parseInt(CellValue(i-6,"ttl_"+rptTtlArr[k]));
                            tmpOt = parseInt(CellValue(i-5,"ttl_"+rptTtlArr[k])); 
                            tmpIf = parseInt(CellValue(i-4,"ttl_"+rptTtlArr[k]));
                            tmpOf = parseInt(CellValue(i-3,"ttl_"+rptTtlArr[k]));
                            tmpRo = parseInt(CellValue(i-2,"ttl_"+rptTtlArr[k]));
                            tmpBa = tmpIn + tmpRi + tmpOt + tmpIf - tmpOf - tmpRo;
                            CellValue2(i,"ttl_"+rptTtlArr[k]) = tmpBa;
							if(tmpBa < 0){
                                CellFontColor(i, "ttl_"+rptTtlArr[k]) = RgbColor(255,0,0);
						    }else{
                                CellFontColor(i, "ttl_"+rptTtlArr[k]) = RgbColor(0,0,0);
                            }
							
							
                            if (tmpOf == 0) {
								CellValue2(i+1,"ttl_"+rptTtlArr[k]) = "";
//								CellValue2(i+2,"ttl_"+rptTtlArr[k]) = "";
							}else{ 
								tmpSrp = (tmpIn + tmpRi + tmpOt + tmpIf) / tmpOf;
                                CellValue2(i+1,"ttl_"+rptTtlArr[k]) = tmpSrp.toFixed(1); // 소수점 1째 자리로 반올림
//                                tmpSrt = tmpBa/tmpOf;
//                                CellValue2(i+2,"ttl_"+rptTtlArr[k]) = tmpSrt.toFixed(1); // 소수점 1째 자리로 반올림
                            }
							
                            // 변수 초기화
                            tmpIn = 0;
                            tmpRi = 0;
                            tmpOt = 0; 
                            tmpIf = 0;
                            tmpOf = 0;
                            tmpRo = 0;
                            tmpBa = 0;
                            tmpSrp = 0;
                            tmpSrt = 0;
                        }
					}
				}	
            }
        }
    }
	
	
    function calcTotal(startRow, endRow){
		
        var sheetObj = sheetObjects[0];
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");
		
		if(rptTtl != ""){
            rptTtlArr = rptTtl.split(",");
        }
		
		var tmpSum = 0;
        
		for (var row = startRow; row <= endRow; row++) {
			if(sheetObj.CellValue(row,"code")!="SP" && sheetObj.CellValue(row,"code")!="ST"){ // EQ Supply Ratio 2개는 계산 안 함
				for (var i = 0; i < rptTtlArr.length; i++) {
					for (var j = 0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
			            tmpSum = tmpSum + parseInt(sheetObj.CellValue(row,arr_tpsz[j].toLowerCase()+rptTtlArr[i]));
			        }
			        sheetObj.CellValue2(row,"ttl_"+rptTtlArr[i]) = tmpSum;
					tmpSum = 0;
	            }
			}
        }
		
		// TTL 의 Balance, EQ Supply Ratio 계산 함
		calcBalance2(startRow, endRow, true);
    }

	 /**
	  * Location 변경시 이벤트 처리
	  * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
	  * 나머지 활성화
	  */
	 function loc_cd_onchange() {
		if(document.form.loc_cd.value == ""){ // ALL 선택			
		   	document.form.div_flag[0].disabled = true;
		   	document.form.div_flag[1].disabled = true; 
		     	
	  		ComEnableObject(document.form.sub_loc_cd,  false);  // Location by 입력창 비활성화
	  		ComEnableObject(document.form.btn_loc_cd,  false);  // Location by 돋보기창 비활성화
	  		
	  		ComEnableObject(document.form.loc_cd_second,      false); // Location 입력창 비활성화
	  		ComEnableObject(document.form.btn_loc_cd_second,  false); // Location 돋보기창 비활성화   	
	  		    		
	  	}else{ // ALL 이 아닌 경우
		    document.form.div_flag[0].disabled = false;
		    document.form.div_flag[1].disabled = false; 	 	     	
	  		
	  		changeInputStatus(); // radio 클릭 상태에 따른 상태변경
	  	}
			
		// location 선택창 비우기 혹은 RCC 복사
		loc_type_code_onchange();
		loc_tp_cd_second_onchange();
	 }
   
	 /**
	  * Location by 변경시 이벤트 처리
	  * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
	  * 나머지 활성화
	  */
	 function loc_type_code_onchange() {
	 	
	 	// LOCATION BY 입력값 초기화 혹은 RCC 값 입력
		if(document.form.loc_type_code.value != "RE" && document.form.loc_type_code.value != "RS"){ // RCC(by ECC) 혹은 RCC(by SCC)
			document.form.sub_loc_cd.value = "";
			if(document.form.loc_cd.value != "" && document.form.div_flag[0].checked == true) {
				document.getElementById("sub_loc_cd").focus();
			}
		}else{ 
			document.form.sub_loc_cd.value = document.form.loc_cd.value;		
		}
	 }
	 
	 /**
	  * Location 변경시 이벤트 처리
	  */
	 function loc_tp_cd_second_onchange() {
			document.form.loc_cd_second.value = "";
			if(document.form.loc_cd.value != "" && document.form.div_flag[1].checked == true) {
				document.getElementById("loc_cd_second").focus();
			}	
	 }    
  
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "sub_loc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;
				
			case "loc_cd_second":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;				
		}
	}
    
 	/**
 	 * Location  blur 이벤트 처리
 	 * Location  blur 코드 적합성 체크
 	 */	
 	function sub_loc_cd_onkeyUp() {
 		var formObject = document.form;
		if ( formObject.sub_loc_cd.value.length == 5 ) { 
			if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && document.form.sub_loc_cd.value != "") {
		 		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
			}
		}
 	}
 	
 	/**
 	 * Location  blur 이벤트 처리
 	 * Location  blur 코드 적합성 체크
 	 */	
 	function loc_cd_second_onkeyUp() {
 		var formObject = document.form;
		if ( formObject.loc_cd_second.value.length == 5 ) { 
			if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && document.form.loc_cd_second.value != "") {
		 		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
			}
		}
 	} 	
	
	/**
	 * Radio Button 클릭시 이벤트 발생
	 */
	function changeInputStatus() {
		if(document.form.div_flag[0].checked == true) {
			ComEnableObject(document.form.sub_loc_cd,         true);			
			ComEnableObject(document.form.loc_cd_second,  	  false);
    		ComEnableObject(document.form.btn_loc_cd,  		  true);         // Location by 돋보기창 활성화
    		ComEnableObject(document.form.btn_loc_cd_second,  false);  // Location 돋보기창 비활성화
    		
			document.form.loc_cd_second.value="";
			document.getElementById("sub_loc_cd").className = "input";
			document.getElementById("sub_loc_cd").focus();
			
			loc_type_code_onchange(); //Location by 변경시 이벤트 처리
			
		}else {  // 두번째 라디오 선택(Location)
			ComEnableObject(document.form.sub_loc_cd,         false);
			ComEnableObject(document.form.loc_cd_second,  	  true);
    		ComEnableObject(document.form.btn_loc_cd,  		  false);         // Location by 돋보기창 활성화
    		ComEnableObject(document.form.btn_loc_cd_second,  true);  // Location 돋보기창 활성화
			
			document.form.sub_loc_cd.value="";
			document.getElementById("loc_cd_second").className = "input";
			document.getElementById("loc_cd_second").focus();
		}
		
		
	} 		
	
	/**
     * 설  명 :  Combo 기본 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     initCombo(comboObj,comboNo)
     * </pre>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt  = 0 ;
        
        switch(comboNo) {       
            // Type Size
            case 1:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    
                    var menuname = tpszallText.split('|'); 
                    var menucode = tpszallCode.split('|'); 
                    
                    MultiSelect = true;
                    MaxSelect = menuname.length;
                    MultiSeparator = ",";
                    
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }
	
	/**
     * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     tpszChange('')
     * </pre>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function tpszChange(key){
        switch (key) {
        case "":
            comboObjects[0].Code = consTpsz;                            
            break;
        case "D":
            comboObjects[0].Code = consTpszDry;                
            break;
        case "R":
            comboObjects[0].Code = consTpszRfr;
            break;
        case "O":
            comboObjects[0].Code = consTpszOt;
            break;
        case "F":
            comboObjects[0].Code = consTpszFr;
            break;
        }
    }
	
	/**
     * 설  명 : Form Object의 Change Event <br>
     * <br><b>Example : </b>
     * <pre>
     *     form_change()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function form_change(){
        var srcName = window.event.srcElement.getAttribute("name");

        if ( srcName == "cntrTpsz"){
            var index = document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
        }
    }
    
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
		var sheetObj = sheetObjects[0]; 
		calcBalance2(sheetObj.HeaderRows, sheetObj.HeaderRows+sheetObj.RowCount("R"), false);
        calcTotal(sheetObj.HeaderRows, sheetObj.HeaderRows+sheetObj.RowCount("R")); // TTL 계산
    }
    
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj = sheetObjects[0];
        var arr_tpsz = tpsz_cd.split(",");
		
		if(rptTtl != ""){
            rptTtlArr = rptTtl.split(",");
        }
		
		for (var k = 0; k < rptTtlArr.length; k++) { // 주차만큼반복
			for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
			    for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
			        if(consTpszArr[i] == arr_tpsz[j]){
			            sheetObj.ColHidden(consTpszArr[i].toLowerCase()+rptTtlArr[k])= false;
			            break;
			        }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
			            sheetObj.ColHidden(consTpszArr[i].toLowerCase()+rptTtlArr[k])= true;
			        }
			    }       
			}  
		}
    }
	/* 개발자 작업  끝 */  