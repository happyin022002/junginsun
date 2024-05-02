/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0185.js
*@FileTitle : Port Tariff Modification
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : SJ KIM
*@LastVersion : 1.0
=========================================================
* History
* =========================================================
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0185 : ESM_MAS_0185 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0185() {
    this.processButtonClick     = processButtonClick   ;  
    this.loadPage               = loadPage             ;
    this.initSheet              = initSheet            ;
    this.setSheetObject         = setSheetObject       ;
    this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd   ;
    this.sheet1_OnSaveEnd       = sheet1_OnSaveEnd     ;
    this.sheet1_OnChange        = sheet1_OnChange      ;
    this.doActionIBSheet        = doActionIBSheet      ;
    this.validateForm           = validateForm         ;
    this.ComAddSeparator_Local  = ComAddSeparator_Local;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet_height = 20; // sheet의 height

var comboCnt = 0;
var loadingMode = false;

var sRow = 0;

var cre_flg = false;
var save_flag = ""; // popup에서 Save를 했는지,Save를 했다면 화면 close시에 Opener UI(0040)에서 자동 조회가 되어야 한다.

var rtn_value = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                    
                case "btn_Create":
                	doActionIBSheet(sheetObject,formObject,IBCREATE);
                	break;

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    
                    break;
                    
				case "btn_Close":	
					window.close();
					break;
					
                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;                    

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111", "", ""));
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    
    	var formObject = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        setName(formObject.f_cust_cnt_cd.value);
        formObject.f_yearweek.value = formObject.cost_wk.value;
        formObject.f_yearweek.focus();
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                //전체Merge 종류 [선택, Default msNone]
                    Editable = false;
                    InitRowInfo(1 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(13, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, true, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle   = "STS|YYYY-WK|VVD||||||Original Cost|Ratio|Distributed Cost|TTL Cost|";
                    
                    InitHeadRow(0, HeadTitle, true);                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    
                    //데이터속성                [ROW,   COL,    DATATYPE,           WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC,     DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,  SORTENABLE, TOOLTIP,    ALLCHECK,   SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtStatus,           50,     daCenter,    true,      "ibflag");
                    InitDataProperty(0,     cnt++,  dtData        ,     80,     daCenter,    false,     "cost_wk");
                    InitDataProperty(0,     cnt++,  dtData        ,    100,     daCenter,    false,     "vvd");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "slan_cd");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "vsl_cd");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "skd_voy_no");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "skd_dir_cd");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "cnt_cd");
                    
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    120,    daRight,     true,      "port_org_amt",     false,      "",             dfFloatOrg,     2,          true,       true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,		    100,    daRight,     true,      "wk_vsl_rt",        false,      "",             dfUserFormat,   0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    120,    daRight,     true,      "wk_vsl_dtrb_amt",  false,      "",             dfFloatOrg,     2,          true,       true);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    120,    daRight,     true,      "vvd_ttl_amt",      false,      "|port_org_amt|+|wk_vsl_dtrb_amt|",         dfFloatOrg,     2,          false,      false);                    
                    InitDataProperty(0,     cnt++,  dtHidden, 		    60,     daRight,     true,      "wk_ttl_amt",       false,      "",             dfFloatOrg,     2,          false,      false);                    

                    CountPosition  = 2 ;
                    style.height = GetSheetHeight(16) ;
                    
                    InitUserFormat(0, "wk_vsl_rt", "###%", "%" );

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

    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"ibflag") = "  TOTAL";
        sheetObj.SumText(0,"wk_vsl_rt") = "100 %";
        
        // Retrieve Button
        if(!cre_flg){
        	document.form.wk_ttl_amt.value = sheetObj.CellValue(1, "wk_ttl_amt");
        	
        // Create Button
        }else{
        	for(var i=1; i <= sheetObj.SearchRows; i++ ){
        		sheetObj.CellValue2(i, "ibflag") = "U";
        	}
        }
    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	save_flag = "Y";
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
//         alert(save_flag+"|"+(sheetObj.SumValue(0,"port_usd_amt") + sheetObj.SumValue(0,"cnl_usd_amt")));
         window.returnValue = save_flag;
        
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	// 업무처리중 버튼사용 금지 처리

        switch(sAction) {

            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				cre_flg = false;
				formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0185GS.do", masFormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
                
                ComOpenWait(false);
                break;
                
            case IBCREATE:      //1차 배부정보 조회
            	if(!validateForm(sheetObj,formObj,sAction)) return false;
            	ComOpenWait(true);
            	cre_flg = true;
            	formObj.f_cmd.value = SEARCHLIST02;
            	formObj.cost_wk.value = formObj.f_yearweek.value;
            	var sXml = sheetObj.GetSearchXml("ESM_MAS_0185GS.do", masFormQueryString(formObj));
            	sheetObj.LoadSearchXml(sXml);
            	
            	ComOpenWait(false);
            	break;

            case IBSAVE:        //저장

                if (sheetObj.RowCount > 0) {
                	
					ComOpenWait(true);
					sheetObj.Redraw = false;
					
	                formObj.f_cmd.value = MULTI01;
	                
	                var saveStr = sheetObj.GetSaveString(true);
	                var sXml = sheetObj.GetSearchXml("ESM_MAS_0185GS.do", masFormQueryString(formObj)+"&"+saveStr);
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
					
					if (backendJobKey != null && backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 7200; //초 - 2시간
						backEndJobTimer = setInterval(getBackEndJobStatus, 1000);	//밀리초  - 10초
					}
	                
	                sheetObj.Redraw = true;
	                ComOpenWait(false);
                }else {
                	ComShowMessage(ComGetMsg('MAS10017'));
                }
                
                break;
                

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

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	
        	if(f_yearweek.value == "") {
               // [COM12114] : YYYY-WW 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                f_yearweek.focus();
                return false;
            }
            if(f_yearweek.value.replace("-","").length != 6) {
                // [COM12114] : YYYY-WW 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                f_yearweek.focus();
                return false;
            }
            
            if(f_cust_cnt_cd.value == ""){
            	ComShowMessage(ComGetMsg("COM12114","Country",""));
            	f_cust_cnt_cd.focus();
                return false;
            }
            
            if(sAction == IBCREATE && (wk_ttl_amt.value == "" || Number(wk_ttl_amt.value) == 0)){
            	ComShowMessage(ComGetMsg("COM12114","Amount",""));
            	wk_ttl_amt.focus();
                return false;
            }
        }

        return true;
    }
    
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 CATCH 한다. <br>
     */
    function initControl() {
        //Axon 이벤트 처리1. 이벤트 catch
        axon_event.addListenerForm('blur', 'obj_blur', form); 
        axon_event.addListenerForm('focus', 'obj_focus', form); 
    } 
    
    /**
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013','25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */
    function obj_blur() {
      	 switch(event.srcElement.name) { 
      	 	case "f_yearweek":
	   	   		if(!ComAddSeparator(event.srcElement)) return false;   		
	   	   		setPeriod(event.srcElement);	   		
   	   		break;	
      	 }
    }
    
    function obj_focus() {
		switch(event.srcElement.name) {
			case "f_yearweek":
		   		ComClearSeparator(event.srcElement,'','-');  
		   		event.srcElement.select();
		   		break;
		} 
 	} 
    
    function setPeriod(obj){
        var formObj = document.form;
        obj.value = ComGetMaskedValue(obj.value,"yw");
        ComMasSetPeriod2(obj);
    }
    
    function setName(value){
    	var formObj = document.form;
    	formObj.cnt_cd.value = value;
    	formObj.cnt_nm.value = value=="CN"?"China":"Italy";
    }
    
    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobStatus();
     * </pre>
     * @return 없음
     * @author 박찬민
     * @version 2013.06.25
     */     
    function getBackEndJobStatus() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	ComOpenWait(true);
    	formObj.f_cmd.value = SEARCH11;
    	var sXml = sheetObj.GetSearchXml("ESM_MAS_0185GS.do", masFormQueryString(formObj));
    	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
    	
    	if (jobState == "3") {
    		getBackEndJobSearch();
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "4") {
    		ComShowCodeMessage("MAS00001");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "5") {
    		ComShowCodeMessage("MAS00002");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	}
    }   
    
    /**
     * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobSearch();
     * </pre>
     * @return 없음
     * @author 박찬민
     * @version 2013.06.25
     */       
    function getBackEndJobSearch() {
    	
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	formObj.f_cmd.value = SEARCH12;    	
    	var sXml = sheetObj.GetSearchXml("ESM_MAS_0185GS.do", masFormQueryString(formObj));
    	var err_cd = ComGetEtcData(sXml, "err_cd");
    	var err_msg = ComGetEtcData(sXml, "err_msg");

    	ComOpenWait(false);
		
		if (err_cd == "null") {
          ComShowMessage(ComGetMsg('MAS10018','SAVE'));
          window.returnValue = "Y";
      } else {
          ComShowMessage("["+err_cd+"]:"+err_msg);
      }
    }
    