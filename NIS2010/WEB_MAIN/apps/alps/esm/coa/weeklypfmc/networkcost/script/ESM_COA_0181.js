/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0181.js
*@FileTitle : Port Tariff Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.01
*@LastModifier : 이석준
*@LastVersion : 1.0
=========================================================
* History
* 2013.05.07 최성민 [CHM-201324181] [COA] Port tariff 로직 수정
* =========================================================
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0181 : ESM_COA_0181 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0181() {
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

var save_flag = false; // popup에서 Save를 했는지,Save를 했다면 화면 close시에 Opener UI(0040)에서 자동 조회가 되어야 한다.

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

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    
                    break;
                    
				case "btn_Close":	
					window.close();
					break;
					
                case "btn_downExcel":
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
       
        doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
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
                    Editable = true;
                    InitRowInfo(2 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(13, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false, false, true, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle   = "STS|||||Port|CY|Currency|Port Exp.|Port Exp.|Canal Exp|Canal Exp|";
                    var HeadTitle1  = "STS|||||Port|CY|Currency|COA|PSO|COA|PSO|";
                    
                    InitHeadRow(0, HeadTitle, true);                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    
                  //데이터속성                [ROW,   COL,    DATATYPE,           WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC,     DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,  SORTENABLE, TOOLTIP,    ALLCHECK,   SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtStatus,           50,     daCenter,    true,      "ibflag");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "slan_cd");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "vsl_cd");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "skd_voy_no");
                    InitDataProperty(0,     cnt++,  dtHidden      ,     50,     daCenter,    false,     "skd_dir_cd");
                    
                    InitDataProperty(0,     cnt++,  dtData,   		    70,     daCenter,    true,      "port_cd",      false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,    		    70,     daCenter,    true,      "cy_cd",        false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,   		    100,    daCenter,    true,      "curr_cd",      false,      "",             dfEngUpKey,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    100,    daRight,     true,      "port_usd_amt", false,      "",             dfFloatOrg,     3,          true,       true);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    100,    daRight,     true,      "port_pso_amt", false,      "",             dfFloatOrg,     3,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    100,    daRight,     true,      "cnl_usd_amt",  false,      "",             dfFloatOrg,     3,          true,       true);
                    InitDataProperty(0,     cnt++,  dtAutoSum, 		    100,    daRight,     true,      "cnl_pso_amt",  false,      "",             dfFloatOrg,     3,          false,      false);                    
                    InitDataProperty(0,     cnt++,  dtHidden, 		    100,    daRight,     true,      "cre_usr_id");

                    CountPosition  = 2 ;
                    style.height = GetSheetHeight(16) ;
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
        sheetObj.SumText(0,"port_cd") = "  TOTAL";
       
        //EGSUZ,PAPAC 즉 커널일때는 Port쪽 Editable 막는다.
        for(var i=sheetObj.HeaderRows;i<=(sheetObj.RowCount + sheetObj.HeaderRows -1);i++) {
        	if (sheetObj.CellValue(i,"port_cd") == "EGSUZ" || sheetObj.CellValue(i,"port_cd") == "PAPAC") {
        		sheetObj.CellEditable(i, "port_usd_amt") = false;
        		sheetObj.CellEditable(i, "cnl_usd_amt")   = true;
        	} else {
        		sheetObj.CellEditable(i, "port_usd_amt") = true;
        		sheetObj.CellEditable(i, "cnl_usd_amt")   = false;        		
        	}
        }
        
       

    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	save_flag = true;
    	
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
//         alert(save_flag+"|"+(sheetObj.SumValue(0,"port_usd_amt") + sheetObj.SumValue(0,"cnl_usd_amt")));
         window.returnValue = save_flag+"|"+(sheetObj.SumValue(0,"port_usd_amt") + sheetObj.SumValue(0,"cnl_usd_amt")) ;
        
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	// 업무처리중 버튼사용 금지 처리

        switch(sAction) {

			case IBCLEAR:          //조회		        			
				break;	

            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0181GS.do", coaFormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				var pso_cre_dt = ComGetEtcData(sXml, "pso_cre_dt");
				
				formObj.f_rqst_dt.value = ComGetMaskedValue(pso_cre_dt,"ymd");
//                sheetObj.DoSearch4Post("ESM_COA_0181GS.do", coaFormQueryString(formObj));
//                
                
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장

//                if(!validateForm(sheetObj,formObj,sAction)) return false;
    				ComOpenWait(true);
    				sheetObj.Redraw = false;
    				var popup_save_flag = true;
    				//cre_usr_id가 Null인것은 IB Flag를 'I'로 강제 setting
    				for(var i=sheetObj.HeaderRows;i<=(sheetObj.RowCount + sheetObj.HeaderRows -1);i++) {
    					if (sheetObj.CellValue(i,"port_usd_amt") + sheetObj.CellValue(i,"cnl_usd_amt") == 0) { // 0값이 존재하는 Port가 있으면 message를 뿌려준다.
    						popup_save_flag = false;
    						break;
    					}
    				}
    				
    				if (popup_save_flag){
    					/* MERGE 문으로 대체
	    				for(var i=sheetObj.HeaderRows;i<=(sheetObj.RowCount + sheetObj.HeaderRows -1);i++) {
	    					if(sheetObj.CellValue(i,"cre_usr_id")=="" || sheetObj.CellValue(i,"cre_usr_id")==""){
	    						sheetObj.RowStatus(i) = "I";
	    					}
	    				}
	    				*/
	                    formObj.f_cmd.value = MULTI01;
	                    sheetObj.DoSave("ESM_COA_0181GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, true);     
    				} else {
    					ComShowMessage(ComGetMsg("COA10060"));
    				}
                    
                    sheetObj.Redraw = true;
                    ComOpenWait(false);
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
        }

        return true;
    }

//    /**
//    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//    */
//    function Dup_CheckForm(sheetObj,formObj,sAction){
//        var rtn = true;
//        with(formObj){
//            var dr = sheetObj.ColValueDup("cost_yrmon|slan_cd|skd_dir_cd|clss_capa|port|cy|locl_curr_cd");
//            if(dr>0){//중복된 값이 있는경우
//                ComShowMessage(ComGetMsg('COM12115', 'DATA'));
//                sheetObj.SelectCell(dr,"cost_yrmon|slan_cd|skd_dir_cd|clss_capa|port|cy|locl_curr_cd");
//                rtn = false;
//            }
//        }
//        return rtn;
//    }

//    function ComAddSeparator_Local(obj, sFormat) {
//        try {
//            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
//        } catch(err) { ComFuncErrMsg(err.message); }
//    }