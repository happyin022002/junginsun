/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_MAS_0017.js
*@FileTitle : Container PDM by Inventory
*Open Issues :
*@LastModifyDate : 2016-03-18
*@LastModifier : Young-Heon Lee
*@LastVersion :
*  2016-03-18 Young-Heon Lee
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
 * @class ESM_MAS_0017 : ESM_MAS_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0017() {
    this.processButtonClick    = processButtonClick;  
    this.loadPage              = loadPage          ;
    this.initSheet             = initSheet         ;
    this.setSheetObject        = setSheetObject    ;
    this.doActionIBSheet       = doActionIBSheet   ;
    this.validateForm          = validateForm      ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var EXCEL_LOAD_FLG = false;	//엑셀 로드 실행체크

/** 
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  
 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
    	var sheetObject = sheetObjects[0];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":        
                	doActionIBSheet(sheetObject, formObject, IBSEARCH);
                    break;
                
                case "btn_Downexcel":
                	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                    
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                    
                case "btn_save":	
                	doActionIBSheet(sheetObject, formObject, IBSAVE);
                    break;
                
                case "btn_rowadd":
                	sheetObject.DataInsert(-1);
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
        
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // Save, Create 버튼 활성화, 비활성화 제어
    	if ( document.form.v_ofc_cd.value == 'SELAPM' || document.form.v_ofc_cd.value == 'CLTCO'
    		|| document.form.v_ofc_cd.value == 'SELOPE' || document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'SELOPB' 
    		|| document.form.v_ofc_cd.value == 'SELCON' ){
    		ComBtnEnable("btn_save");
    	} else {
    		ComBtnDisable("btn_save");
    	}
    	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        ComSetFocus(document.form.fr_year);
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
                    SheetWidth = mainTable.clientWidth;
                    //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(8, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    var HeadTitle0  = "Seq.|STS|DEL.|Period|TPSZ|Average Inventory|3 Months Cost|Per Diem";                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);

                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++,   dtDataSeq, 40,  daCenter,   false,      "dtDataSeq");
                    InitDataProperty(0,	cnt++,   dtStatus, 30,     daCenter,   false,      "ibflag");
                    InitDataProperty(0,	cnt++, 	 dtDelCheck,   50,     daCenter,   false,      "del_chk");
        			InitDataProperty(0,  cnt++,  dtData,         130,     daCenter,   true,       "cost_yr_qtr", 		true,  "",   dfUserFormat,     0,  false,  true);
        			InitDataProperty(0,  cnt++,  dtCombo,        80,     daCenter,    true,       "tpsz_cd",      	true,  "",   dfNone,     0,  false,  true);
                	InitDataProperty(0,  cnt++,  dtData,         210,     daRight,    true,       "invt_cntr_qty",     false,  "",  dfFloatOrg,  3,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         210,     daRight,    true,       "cost_amt",    		false,  "",  dfFloatOrg,  2,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         210,     daRight,    true,       "pd_cost_amt",     false,  "",  dfFloatOrg,  2,  true,  true);
                    
                    
                    InitUserFormat(0, "cost_yr_qtr", "####-#Q", "-" );
                    CountPosition  = 0 ;
                    //style.height = GetSheetHeight(13) ;
                    sheetObj.style.height = 370;    //sheetObj.GetSheetHeight(13);
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

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(false);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0017GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComMasSetIBCombo(sheetObjects[0], arrXml[0], "tpsz_cd", false, 0);
				ComOpenWait(false);
				break;
				
			case IBSEARCH: //sheet1 조회					
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                
                // 업무처리중 버튼사용 금지 처리  
                ComOpenWait(true);                
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch("ESM_MAS_0017GS.do", masFormQueryString(formObj));
                
  	            //initVariable(); //초기값 세팅
                ComOpenWait(false);
                break;
			
			case IBSAVE:                //저장
                if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }
                
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_MAS_0017GS.do", FormQueryString(formObj), -1, true);
				ComOpenWait(false);
                
                //Load Excel 사용시
                if(EXCEL_LOAD_FLG) {
                	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
  						initVariable(); //저장이 완료되면 전역변수 초기화
  					}
                }
                break;
                            	            
            case IBDOWNEXCEL:           //엑셀 다운로드
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
             	
        	case IBLOADEXCEL:
	        	ComOpenWait(true);
	        	sheetObj.RemoveAll();	        	
                sheetObj.LoadExcel(-1, 1, "", -1, -1, "");   
				break;	
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//공통 체크	       
    	with(formObj){    
    		if (fr_year.value > to_year.value) {
        		ComShowMessage(ComGetMsg("COM12114", "Year"));
        		fr_year.focus();
        		return;
    		}
    		
    		if (fr_qtr.value != "" && (fr_qtr.value < 1 || fr_qtr.value > 4)) {
        		ComShowMessage(ComGetMsg("COM12114", "QTR"));
        		fr_qtr.focus();
        		return;
    		}
    		
    		if (to_qtr.value != "" && (to_qtr.value < 1 || to_qtr.value > 4)) {
        		ComShowMessage(ComGetMsg("COM12114", "QTR"));
        		to_qtr.focus();
        		return;
    		}
        }
        
    	//버튼별 체크
        switch (sAction) {
        	case IBSEARCH: // 조회        		
        		if (formObj.fr_year.value == "" || formObj.fr_qtr.value == "" || formObj.to_year.value == "" || formObj.to_qtr.value == "") {
					ComShowMessage("Please enter correct date.\nFormat: From:YYYY-Qtr ~ To:YYYY-Qtr");
					//formObj.pod_cd.focus();
					return false;
				}
				break;
        	
        	case IBSAVE: // 저장
				break;
        }
        return true;
    }
	
	/**
	 * 전역변수를 초기화 하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		initVariable();
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2011.02.28
	 */
	function initVariable() {
		EXCEL_LOAD_FLG = false;
		ComShowObject(document.getElementById("btn_Rowdelete"),  false);
	}
	
