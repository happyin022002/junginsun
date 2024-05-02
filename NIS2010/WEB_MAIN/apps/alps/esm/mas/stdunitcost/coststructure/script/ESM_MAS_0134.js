/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0134.js
*@FileTitle : Revenue Exception Charge
*Open Issues :
*@LastModifyDate : 2015-02-04
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-02-04 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_MAS_0134 : ESM_MAS_0134 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0134() {
    this.processButtonClick = processButtonClick ;
    this.chgView            = chgView            ;
    this.Popup              = Popup              ;
    this.retrieve           = retrieve           ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnDblClick  = sheet1_OnDblClick  ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
    this.chkValidCreate     = chkValidCreate     ;
    this.chkValidCreate     = chkValidCreate     ;
    this.initCombo          = initCombo          ;          
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet_height = 20; // sheet의 height
var comboCnt = 0;
var comboObjects = new Array();
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
    /**
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
         var sheetObject = sheetObjects[0];
         var formObject = document.form;
         var srcName = window.event.srcElement.getAttribute("name");

        try {
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btn_New":
                    doActionIBSheet2(sheetObject,formObject,IBCLEAR);
                    break;
                    
                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

                case "btn_Delete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                    
                case "btn_Downexcel":                	
                    doActionIBSheet2(sheetObject,formObject,IBDOWNEXCEL);                	
                    break;

                /*case "btn_SubTrade":
                    var rtn = window.showModalDialog ("/hanjin/ESM_MAS_0038.do", window,"dialogWidth:400px;dialogHeight:320px;center:1; scroll:0; help:0; status:0;");
                    //doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    //noRtnPopup('/hanjin/ESM_MAS_038.do', 'width=300,height=300,menubar=0,status=0,scrollbars=0,resizable=0');
                    break;*/

                /*case "btn_Rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;*/

                /*case "btng_Crrinfo":
                   ComOpenWindow2('ESM_MAS_0123.do','', 'width=650,height=370,menubar=0,status=1,scrollbars=0,resizable=0');
                   break;*/

                case "bu_zoom_in":
                    sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
                    sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
                    div_zoom_in.style.display = "none";
                    div_zoom_out.style.display = "inline";
    				if (parent && parent.syncHeight) {
    					parent.syncHeight();
    				}
                    break;

                case "bu_zoom_out":
                    sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
                    sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
                    div_zoom_in.style.display = "inline";
                    div_zoom_out.style.display = "none";
    				if (parent && parent.syncHeight) {
    					parent.syncHeight();
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

    function chgView(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        if(formObj.f_chkdel.checked){
            sheetObj.ColHidden(0) = true;
            sheetObj.ColHidden(1) = false;
        }else{
            sheetObj.ColHidden(0) = false;
            sheetObj.ColHidden(1) = true;
        }// end if

    }
    
    /**
     * 팝업 함수
     */
    /*function Popup(str){
        ComOpenWindow2("ESM_MAS_0146.do?" + str,'','width=1100, height=550, menubar=no, status=no,scrollbars=no, resizable=yes');

    }*/

    function retrieve(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
//		loadingMode = true;
//        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);       
//        loadingMode = false;
//        btn_Retrieve.focus();
        
        loadingMode = true;      	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }        
        
        // IBMultiCombo초기화  
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		for ( var k = 0; k < comboObjects.length; k++) {                                                                                                                                                                                                                                                                                                                                                                                                                    
			initCombo(comboObjects[k], k + 1);                                                                                                                                                                                                                                                                                                                                                                                                                          
		}
        loadingMode = false;
    }
    
    /**                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
     * 콤보 초기설정값, 헤더 정의 <br>                                                                                                                                                                                                                                                                                                                                                                                                                                              
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>                                                                                                                                                                                                                                                                                                                                                                                               
     * <br><b>Example :</b>                                                                                                                                                                                                                                                                                                                                                                                                                                                         
     * <pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
     *     initCombo(comboObj,1);                                                                                                                                                                                                                                                                                                                                                                                                                                                   
     * </pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
     * @param {object} comboObj 필수 IBMultiCombo Object                                                                                                                                                                                                                                                                                                                                                                                                                            
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호                                                                                                                                                                                                                                                                                                                                                                                                  
     * @return 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
     * @author 유제량                                                                                                                                                                                                                                                                                                                                                                                                                                                            
     * @version 2015.02.04                                                                                                                                                                                                                                                                                                                                                                                                                                                          
     */                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
    function initCombo(comboObj, comboNo) {                                                                                                                                                                                                                                                                                                                                                                                                                                         
    	switch (comboObj.id) {
	    	case "chg_cd":                                                                                                                                                                                                                                                                                                                                                                                                                                              
	 			var i = 0;                                                                                                                                                                                                                                                                                                                                                                                                                                          
	 			with (comboObj) {                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 				//UseEdit = true;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				// BackColor = "cyan";                                                                                                                                                                                                                                                                                                                                                                                                                      
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;
	 				/*DropHeight = 300;
 	     			MultiSelect = false;
 	     			MaxSelect = 1;
 	     			MaxLength = 3;
 	     			UseAutoComplete = false;
 	     			ValidChar(2, 1);	//영문대문자+숫자
 	     			Index = 0;*/
	 			}                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 			break;
 			
	 		case "cnt_cd":                                                                                                                                                                                                                                                                                                                                                                                                                                          
	 			var i = 0;                                                                                                                                                                                                                                                                                                                                                                                                                                          
	 			with (comboObj) {                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 				//BackColor = "cyan";                                                                                                                                                                                                                                                                                                                                                                                                                       
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;                                                                                                                                                                                                                                                                                                                                                                                                                     
	 			}                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 			break;                                                                                                                                                                                                                                                                                                                                                                                                                            
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
        
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	            	//style.height = 202;
	                SheetWidth = sheetTable.clientWidth; //전체 너비 설정
	        		//SheetWidth = 400; //전체 너비 설정
	                
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	                MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
	                Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
	                InitRowInfo(1 , 1, 1, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                
	                var HeadTitle1  = "|STS|Sel.|Charge|Country|Creation Date|Update Date|Del.|||";	                
	                var headCount = ComCountHeadTitle(HeadTitle1);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, false);
	                
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false); 
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);					
	                
	                //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,     cnt++,  dtHidden,        30,     daCenter,   true,       "");
	                InitDataProperty(0,     cnt++,  dtHiddenStatus,  40,     daCenter,  false,       "ibflag");
	                InitDataProperty(0,     cnt++ , dtDelCheck,	     50,	 daCenter,	false,		 "");
	                InitDataProperty(0,     cnt++,  dtCombo,        100,     daCenter,   true,       "chg_cd",       false,   "",   dfNone,  0,  true,  true);
	                InitDataProperty(0,     cnt++,  dtCombo,        100,     daCenter,   true,       "cnt_cd",       false,   "",   dfNone,  0,  true,  true);
	                InitDataProperty(0,     cnt++,  dtData,         100,     daCenter,   true,       "cre_dt",       false,   "",   dfNone,  0,  true, false);
	                InitDataProperty(0,     cnt++,  dtData,         100,     daCenter,   true,       "upd_dt",       false,   "",   dfNone,  0,  true, false);                    
	                InitDataProperty(0,     cnt++,  dtData,         100,     daCenter,   true,       "delt_flg",     false,   "",   dfNone,  0,  false, false);
	                
	                InitDataProperty(0,     cnt++,  dtHidden,       100,     daCenter,   true,       "chg_cd_org",   false,   "",   dfNone,  0,  false, false);
	                InitDataProperty(0,     cnt++,  dtHidden,       100,     daCenter,   true,       "cnt_cd_org",   false,   "",   dfNone,  0,  false, false);
	                InitDataProperty(0,     cnt++,  dtHidden,       100,     daCenter,   true,       "delt_flg_org", false,   "",   dfNone,  0,  false, false);

	                CountPosition  = 0 ; // dtHidden , dtHiddenStatus
	
	                sheetObj.style.height = 420;                    
	                //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
	                EditableColorDiff = true;
	                WaitImageVisible = false;
                }
                break;

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

    // f_chkdel 체크유무에 때라 sheet의 del 컬럼을 숨기거나 보여준다.
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
/*        var formObj = document.form;
        if (0==ComGetObjValue(formObj.f_cmd)) {
//			ComOpenWait(true);
//			ComSetObjValue(formObj.f_cmd,SEARCHLIST02);
//			var sXml = sheetObj.GetSearchXml("ESM_MAS_0134GS2.do", masFormQueryString(formObj));
//			var arrXml = sXml.split("|$$|");
//			if (arrXml.length > 0)
//				ComMasSetIBCombo(sheetObj, arrXml[0], "vop_cd", true, 0);
//			if (arrXml.length > 1)
//				ComMasSetIBCombo(sheetObj, arrXml[1], "vsl_oshp_cd", true, 0);
//			ComOpenWait(false);

			chgView();
	        sheetObj.SumText(0,1) = "";
	        sheetObj.SumText(0,2) = "TOTAL";
        }*/
    }

    /*
     * 1. vsl_prc_rto 변경시 소숫점을 백분율로 보여줌
     * 2. trd_chk_flg를 선택시 Trade Loadable Capa, trade를 입력할수 있도록 활성화한다.
     *                  선택이 안되었을 경우는 비활성화한다.
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        /*if(sheetObj.ColSaveName(Col) == "vsl_prc_rto" ) {
            sheetObj.CellValue2(Row, Col) = Value * 100;
        } else if (sheetObj.ColSaveName(Col) == "trd_chk_flg") {
            for(i=12; i<22; i++){
                if(Value == 1){
                    sheetObj.CellEditable(Row, i) = true;
                }else{
                    sheetObj.CellEditable(Row, i) = false;
                } // end if
            }//end for
        } else if (sheetObj.ColSaveName(Col) == "stnd_ldb_capa") {
            // stnd_ldb_capa값이 변경되면 Trade에 값을
            // stnd_ldb_capa값으로 초기화시킨다.
            // 단, OPR2가 'SML'가 아닐 경우만.
            //-----------------------------------------------
            if(sheetObj.CellValue(Row, "vop_cd") != "SML"){
                var num = 0;
                var header = document.form.f_header.value;
                
                var subTrade = header.split("|");

                if(header != "") num = subTrade.length;
                for(j=0;j<num; j++){
                    sheetObj.CellValue(Row, subTrade[j]) = sheetObj.CellValue(Row, "stnd_ldb_capa");
                }
            }
            //-----------------------------------------------
        }

        //-----------------------------------------------
        // 2007.09.11
        // 삭제된 vessel을 다시 사용할수 있도록 delt_flg = 'N'
        //-----------------------------------------------
        if(sheetObj.ColSaveName(Col) == "chg_delt"){
            if (Value == "1") sheetObj.CellValue(Row, "delt_flg")="N";
            else sheetObj.CellValue(Row, "delt_flg")="Y";

        }

        //-----------------------------------------------
        // 2009.10.14
        // 삭제된 vessel 신규 생성시 해당 vessel이 기존에 존재한다면
        // 신규로 입력이 안되게 한다.
        //-----------------------------------------------
        if(sheetObj.ColSaveName(Col) == "vsl_cd"){
            var current_vsl_code = sheetObj.CellValue(Row, "vsl_cd");

            for(var i=1; i<sheetObj.LastRow; i++){
                if(i != Row){
                    if(current_vsl_code == sheetObj.CellValue(i, "vsl_cd")){
                        ComShowMessage(ComGetMsg("MAS10043", current_vsl_code));
                    }
                }
            }
        }
        
        //-----------------------------------------------
        // 2011.01.25
        // OPR(Operation) 변경시 OPR2(Owner) ComboList 재조회.
        //-----------------------------------------------
        if(sheetObj.ColSaveName(Col) == "vop_cd"){
        	if(Value == "") {
        		sheetObj.CellValue(Row, "vsl_oshp_cd") = "";
        		sheetObj.CellComboItem(Row, "vsl_oshp_cd", " |", " |");
        	} else {
        		var param = "";
        		param = param+"&f_cmd="+SEARCHLIST03;
        		param = param+"&f_vop_cd="+sheetObj.CellValue(Row,Col);
        		
        		var sXml = sheetObj.GetSearchXml("ESM_MAS_0134GS2.do", param);
        		
        		var arrXml = sXml.split("|$$|");
        		
        		if (arrXml.length > 0)
        			ComMasSetIBCombo(sheetObj, arrXml[0], "vsl_oshp_cd", true,0,Row);
        	}
        }*/
    }

    /**
    * sheet1을 더블클릭하여 팝업화면을 띄운다.
    */
    function sheet1_OnDblClick(sheetObj , row, col){
        /*var str = "f_vsl_cd=" + sheetObj.CellValue(row, "vsl_cd") + "&sysCommUiTitle=Vessel History";
        
        var existCapa = "";
        if ( sheetObj.CellValue(row, "ibflag") == "U" && sheetObj.CellValue(row, "bsa_vsl_flg") == "N"){
        	existCapa = "Y";
        	str = str + "&existCapa="+existCapa;
        }
        // 팝업창 팝업
        Popup(str);*/
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
	        case IBCLEAR:        //COMBO
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0134GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_chg_cd, "code", "name");
				if (arrXml.length > 0)
					ComMasSetIBCombo(sheetObj, arrXml[0], "chg_cd", true, 0);
				if (arrXml.length > 1)
					ComMasSetIBCombo(sheetObj, arrXml[1], "cnt_cd", true, 0);
				
				/*if (arrXml.length > 3) {
					// 2011.09.15 Lane T/P2 콤보코드 변경
					var arrData = ComXml2ComboString(arrXml[3], "code", "name");
					if (arrData != null && arrData.length > 0) {
						var sCode = "LA|OT|" + arrData[0];
						var sName = "Lane Avg U/C|Other(OP1)|" + arrData[1];						
						sheetObj.InitDataCombo(0,"op_lane_tp_cd", sName, sCode,"", "OT", 0, "", "");
					}
				}*/
				
				ComOpenWait(false);
				break;
        	
        	case IBSEARCH:      //조회
	        	// 업무처리중 버튼사용 금지 처리
				/*ComOpenWait(true);
	            //if(!validateForm(sheetObj,formObj,sAction)) return false;
	            formObj.f_cmd.value = SEARCHLIST01;
	            var xml = sheetObj.GetSearchXml("ESM_MAS_0134GS.do", masFormQueryString(formObj));
	            formObj.f_header.value = searchEtcData("header", xml);
	
	            // Header 정보를 변경하기 위해 sheet를 초기화 한다.
	            //--------------------------------------------------
	            // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
	            sheetObj.Redraw = false;
	            sheetObj.Visible = false;
	            sheetObj.RemoveAll();
	            //sheetObj.Reset();
	            loadPage();
	            sheetObj.Visible = true;
	            sheetObj.Redraw = true;
	            //--------------------------------------------------
	            sheetObj.LoadSearchXml(xml);
	            sheetObj.RemoveEtcData();
	            ComOpenWait(false);*/
	        		        	
	        	//if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                sheetObj.Redraw = false;
                
                formObj.f_cmd.value = SEARCH; 
                //alert(masFormQueryString(formObj));
                sheetObj.DoSearch("ESM_MAS_0134GS.do", masFormQueryString(formObj));                 
                ComOpenWait(false);
                sheetObj.Redraw = true;
	            break;
        	
        	/*case IBNEW:
        		//formObj.f_cntrno.value = "";
				//formObj.f_bkgno.value = "";
                sheetObj.RemoveAll();
                
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0134GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0) {
		            ComConfigSheet(sheetObj);
			        initSheet(sheetObj, 1, ComXml2ComboString(arrXml[0], "code", "name")[0]);
			        formObj.f_header.value = ComXml2ComboString(arrXml[0], "code", "name")[0];
		            ComEndConfigSheet(sheetObj);
				}
				if (arrXml.length > 1)ComMasSetIBCombo(sheetObj, arrXml[1], "vop_cd", true, 0);
				
				// 2011.01.25 동적메소드로 변경하여 세팅 불필요
				//if (arrXml.length > 2)ComMasSetIBCombo(sheetObj, arrXml[2], "vsl_oshp_cd", true, 0);;
				
				ComOpenWait(false);
				break;*/	
				
            case IBSAVE:        //저장
                //if(!chkValidCreate(sheetObj,formObj)) return false;
                // 업무처리중 버튼사용 금지 처리
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_MAS_0134GS.do", masFormQueryString(formObj), -1, true);
                ComOpenWait(false);                
                break;

            case IBDELETE:        //삭제
                //if(!chkValidCreate(sheetObj,formObj)) return false;
                // 업무처리중 버튼사용 금지 처리
				ComOpenWait(true);
                formObj.f_cmd.value = REMOVE;
                sheetObj.DoSave("ESM_MAS_0134GS.do", masFormQueryString(formObj), -1, false);
                ComOpenWait(false);
                break;
                
            /*case IBINSERT:      // 입력
                sheetObj.DataInsert(-1);
                sheetObj.CellValue2(sheetObj.LastRow-1, "delt_flg") = "N";
                sheetObj.CellValue2(sheetObj.LastRow-1, "bsa_vsl_flg") = "N";
                sheetObj.CellValue2(sheetObj.LastRow-1, "vsl_seq") = "1"; // 초기값을 1로 세팅
                
                break;*/
        }
    }
    
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	switch(sAction) {
	    	case IBDOWNEXCEL:        //엑셀 다운로드
	            //sheetObj.SpeedDown2Excel(-1);            	
	            var excelType = selectDownExcelMethod(sheetObj);
	            switch (excelType) {
	                case "AY":
	                    sheetObj.Down2Excel(0, false, false, true);
	                    break;
	                case "DY":
	                    sheetObj.Down2Excel(-1, false, false, true);
	                    break;
	                case "AN":
	                    sheetObj.SpeedDown2Excel(0, false, false);
	                    break;
	                case "DN":
	                    sheetObj.SpeedDown2Excel(-1, false, false);
	                    break;
	            }
	            break;
	    	case IBCLEAR:        //New 버튼	    		
	    		sheetObj.RemoveAll();
	    		ComSetObjValue(document.form.f_rdodelflg,"");	    		
	    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    		break;
    	}
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(formObj.f_vsl_cd.value != ""){
                if (!ComIsAlphabet(formObj.f_vsl_cd)) {
                    ComShowMessage(ComGetMsg("COM12114", "Vessel"));
                    formObj.f_vsl_cd.select();
                    return false;
                }// end if
            }// end if

        }

        return true;
    }

    /**
     *
     */
    /*function chkValidCreate(sheetObj,formObj){
        var strRowNum = sheetObj.FindStatusRow("I|U");
        var arrRow = strRowNum.split(";");
        var cnt = 0;
        if(strRowNum != "") cnt = arrRow.length-1;
        with(formObj){
            // VSL Retaining Period가 있는지 여부를 확인한다.
            //---------------------------------------------------------            
        	for(i=0; i<cnt; i++){
                if(sheetObj.CellValue(arrRow[i], "vsl_retn_fm_dt") == "" || sheetObj.CellValue(arrRow[i], "vsl_retn_to_dt") == ""){
                    // [COM12114] : VSL Retaining Period 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114", "VSL Retaining Period"));
                    if(sheetObj.CellValue(arrRow[i], "vsl_retn_fm_dt") == "")sheetObj.SelectCell(arrRow[i], "vsl_retn_fm_dt");
                    if(sheetObj.CellValue(arrRow[i], "vsl_retn_to_dt") == "")sheetObj.SelectCell(arrRow[i], "vsl_retn_to_dt");
                    return false;
                }
            }            
        }
        //-----------------------------------------------
        // 2009.10.14
        // 삭제된 vessel 신규 생성시 해당 vessel이 기존에 존재한다면
        // 신규로 입력이 안되게 한다.
        //-----------------------------------------------
        var dupYn = "N";
        var dupVesselCd = "";
        for(var i=1; i<sheetObj.LastRow; i++){
            var current_vsl_code = "";
            if(sheetObj.CellValue(i, "ibflag") == "I"){
                current_vsl_code = sheetObj.CellValue(i, "vsl_cd");
                for(var j=1; j<sheetObj.LastRow; j++){
                    if(j!=1 && sheetObj.CellValue(j, "ibflag") != "I" && current_vsl_code == sheetObj.CellValue(j, "vsl_cd")){
                        dupYn = "Y";
                        dupVesselCd = current_vsl_code;
                        break;
                    }
                }
            }
        }

        if(dupYn == "Y") {
            ComShowMessage(ComGetMsg("MAS10043", dupVesselCd));
            return false;
        }

        return true;
    }*/


    