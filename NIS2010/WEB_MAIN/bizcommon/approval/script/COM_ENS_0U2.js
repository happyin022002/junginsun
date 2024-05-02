/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : COM_ENS_0U2.jsp
*@FileTitle : Approval Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-02
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2014-01-02 CHM-201328230 Approval Inquiry 화면 추가 외 조회권한 부여
* 2015.05.13 심성윤 [CHM-201535807] Agmt File 버튼 클릭시 get 주소에 sub_sys_cd 추가
* 2015.07.13 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가
=========================================================*/ 

var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects = new Array();
var comboObjects = new Array();
var comboCnt = 0;
var tabCnt = 0 ;
var beforetab = 1;
var authAproTpCd = "";
var sheetFlg = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1]; //Basic Data default
         var sheetObject3 = sheetObjects[2]; //Basic Data TRS W/O
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) { 

        	    case "btn_Retrieve":
        	    	if(beforetab == 0){
        	    		retrieve();
        	    	}else if(beforetab ==1){
        	    		setAuthSheets();        	    		
        	    	}
        	    
        	    break;
        	    
        	    case "btng_downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	    break;

        	    case "btn_New":
        	    	if(beforetab == 0){
        	    		sheetObject.RemoveAll();
        	    	}else if(beforetab ==1){
        	    		document.all.defaultAuth.style.display = 'inline';
        	    		document.all.trsAfWo.style.display = 'none';
        	    		sheetObject2.RemoveAll();
        	    		sheetObject3.RemoveAll();
        	    		formObject.pgm_no.value = "ALL";
        	            for(var k = 0; k < comboObjects.length; k++){
        	    			comboObjects[k].RemoveAll();
        	    			initCombo(comboObjects[k]);
        	    		}
        	    	}
    	                	            
    	            formObject.reset();
    	            
    	            setInit(formObject.usr_ofc_cd.value);
        	     break;

        	    //달력    
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
	 				var cal = new ComCalendarFromTo();
	 				
	 				if(beforetab == 0){
	 					cal.select(formObject.sdate,  formObject.edate,  'yyyy-MM-dd');
        	    	}else if(beforetab ==1){
        	    		cal.select(formObject.sdate_auth,  formObject.edate_auth,  'yyyy-MM-dd');
        	    	}
 	    		break;   
        	        
        	    case "btn_Detail":
        	        var selRow = sheetObject.SelectRow;
        	        if(selRow <= 0) {
        	            ComShowMessage(ComGetMsg("COM12176"));
        	            return false;
        	        }
        	        
        	        var v_csr_no = sheetObject.CellValue(selRow, "csr_no");
        	        
        	        var height = screen.height; 
                	var width = screen.width;
                	
                	var url = "";
                	var subSysCd = sheetObject.CellValue(selRow, "sub_sys_cd");
                	
	                if(subSysCd == "AGT") {
	                    var param = "?csr_no=" + v_csr_no;
	                    ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "570", false);
	                // else if(sheetObject.CellValue(selRow, "sub_sys_cd") == "TRS") {
	                }else if(subSysCd == "LSE" || subSysCd == "CHS" || subSysCd == "MGS" || subSysCd == "MNR" || subSysCd == "PSO" || subSysCd == "TLL" || subSysCd == "CNI" ) {
	                    var w = 760;
	                    var h = 510;
	                    var leftpos = width/2 - w/2; 
                    	var toppos = height/2 - h/2; 
                    	if(leftpos<0) leftpos=0;
                    	if(toppos<0) toppos=0;
                    	
    					var csrNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
    					var costOfcCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'cost_ofc_cd');
    					var currCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'curr_cd');
    					var invSubSysCd = sheetObject.CellValue(selRow, "sub_sys_cd");
						window.showModalDialog("/hanjin/COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd, window, "dialogWidth:820px; dialogHeight:510px; help:no; status:no; scroll:no; resizable:no;");
                    	
	                    //var url = "/hanjin/ESD_TRS_960.do?csr_no="+v_csr_no;
	                    //window.open(url, "detailPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
	                } else if(subSysCd == "TES") {
	                    var w = 800;
	                    var h = 560;
	                    var leftpos = width/2 - w/2; 
                    	var toppos = height/2 - h/2; 
                    	if(leftpos<0) leftpos=0;
                    	if(toppos<0) toppos=0;
                    	
	                    var url = "/hanjin/ESD_TES_0026.do?csr_no="+v_csr_no;
	                    window.open(url, "detailPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
	                 } else if(subSysCd == "TRS") {
	                     var url = "/hanjin/ESD_TRS_0960.do?mode=trs&csr_no="+v_csr_no;
	                     ComOpenPopup(url, 800, 495, '','1,0,1,1,1,1,1,1', false);
	                 } else if(subSysCd == "ACM") { 
	 	                 var param = "?csr_no=" +v_csr_no;
	 	                 ComOpenWindowCenter("ESM_ACM_0119.do" + param, "compop3", "700", "570", false);
	                 } else if(subSysCd == "FMS") {
	                	 var param = "s_csr_no=" + v_csr_no + "&s_flg=R";
		     				ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "", "0,0,1,1,1,1");
		             }
        	        
        	    break;
        	    
        	    case "btn_comments":
        	    	var selRow = sheetObject.SelectRow;
        	    	if(selRow <= 0) {
        	            ComShowMessage(ComGetMsg("COM12176"));
        	            return false;
        	        }
                    var v_apro_rqst_no = sheetObject.CellValue(selRow, "apro_rqst_no");
                    var url = "";
        	    	if (v_apro_rqst_no != "") {
        	    		url = "COM_CSR_0020.do?apro_rqst_no="+v_apro_rqst_no+"&btn_flag=N";
                    	ComOpenPopup(url, 615, 280, "", "1,0,1,1,1", true);
					}
        	    break;
        	    
        	    case "btn_files":
        	    	var selRow = sheetObject.SelectRow;
        	    	
        	    	if(selRow <= 0) {
        	            ComShowMessage(ComGetMsg("COM12176"));
        	            return false;
        	        }
        	        
        	        var v_csr_no = sheetObject.CellValue(selRow, "csr_no");
        	        var v_sub_sys_cd = sheetObject.CellValue(selRow, "sub_sys_cd");
        	     	//alert(v_sub_sys_cd);
        	        //url에서 sub_sys_cd를 분기처리 안하는 이유는 수정이 불가능한 readOnly =Y 이기 때문에 그냥 모든 탭을 열어도 상관없다.
        	     	var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus=1|1|1&readOnly=Y&invSubSysCd="+v_sub_sys_cd;
        	     	ComOpenPopup(url, 1020, 580, '', 'none', true); 
        	    
        	    break;
        	    
        	    case "btn_Detail_Auth":
        	    	if(sheetFlg == 0){
        	    		setAuthDetailBtn(sheetObject2);
        	    	}else if(sheetFlg == 1){
        	    		setAuthDetailBtn(sheetObject3);
        	    	}
        	    break;
        	    	

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg("COM12111"));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
   /**
    * IBSheet Object를 배열로 등록
    * comSheetObject(id)에서 호출한다
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBTab 초기화
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		//IBMultiCombo 초기화
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
        var formObj = document.form;
        var rhqOfcCd = "";
        
        axon_event.addListenerFormat('keypress', 			'obj_keypress', 	formObj);
        axon_event.addListenerForm  ('beforedeactivate', 	'obj_deactivate', 	formObj);
        axon_event.addListenerFormat('beforeactivate',	  	'obj_activate',		formObj);
        axon_event.addListenerForm  ('click'	   , 'obj_onclick'   , 	document.form); //라디오 버튼
        
        
        setInit(formObj.usr_ofc_cd.value);
 
    }

    /**
     * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
     * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
            	    // 높이 설정
                    style.height = 405;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
    				MergeSheet =  msHeaderOnly;
    				
    				MultiSelection = false;
    				
    				// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(23, 0, 0, true);
                    //InitColumnInfo(11, 0, 0, true);

                    //Row Height Fix
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|NO||ALPS Status|I/F Status|Module|Date|Cost Office|CSR No.|No. Of INV|Payment S/P|Payment S/P|Payment Due Date|Paid Date|Currency|Total Amount|ASA Amount|GW Contract|Contract|Files|Remark||ASA No." ;
                    //var HeadTitle = "NO|STS||Date|Cost Office|CSR No.|No of INV.|Payment S/P|payment Due Date|Currency|Total Amount|Remark|" ;

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,      DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true,     "ibflag",           false,        	"",       dfNone,   	0,     false,      	false);
                    InitDataProperty(0, cnt++ , dtData,      	90,    daCenter,  false,    "apro_rqst_no",     false,          "",       dfNone,	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     	 0,    daCenter,  false,    "apro_rqst_seq",    false,          "",       dfNone,	    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  false,    "alps_status",     	false,          "",       dfNone,   	0,     false,      	false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  false,    "if_status",     	false,          "",       dfNone,   	0,     false,      	false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  false,    "sub_sys_cd",       false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  false,    "rqst_st_dt",       false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  false,    "cost_ofc_cd",      false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        130,    daCenter,  false,    "csr_no",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  false,    "inv_knt",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  false,    "vndr_seq",         false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        100,    daLeft,    false,    "vndr_nm",          false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        120,    daCenter,  false,    "pay_due_dt",       false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  false,    "pay_dt",        	false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "curr_cd",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	90,    daRight,   false,    "apro_ttl_amt",     false,          "",       dfFloat,   	2,     false,       false, 2);
            		InitDataProperty(0, cnt++ , dtData,      	90,    daRight,   false,    "asa_amt",     		false,          "",       dfFloat,   	2,     false,       false, 2);
                    InitDataProperty(0, cnt++ , dtPopup,		80,    daCenter,  false,    "agmt_doc_cfm_cd",	false,			"",		  dfNone,		0,		true,		true);	//추가
					InitDataProperty(0, cnt++ , dtPopup,		70,    daCenter,  false,    "agmt_file_cfm_cd",false,			"",		  dfNone,		0,		true,		true);	//추가
					InitDataProperty(0, cnt++ , dtPopup,		50,	   daCenter,  false,    "file_upld_flg",	false,			"",		  dfNone,		0,		true,		true);	//추가
                    InitDataProperty(0, cnt++ , dtData,        100,    daCenter,  false,    "apro_rmk",         false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     	 0,    daCenter,  false,    "appyn",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     	80,    daCenter,  false,    "asa_no",        	false,          "",       dfNone,   	0,     false,       false);
                    
                    ColHidden(1) = true;
                    PopupImage  =  "/hanjin/img/btns_search.gif";  
                    ShowButtonImage = 2; 
             }
             break;
             
            case 2:      //IBSheet1 init
                with (sheetObj) {
            	    // 높이 설정
                    style.height = 382;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
    				MergeSheet =  msHeaderOnly;
    				
    				// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    MultiSelection = false;
                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);
                    //InitColumnInfo(11, 0, 0, true);

                    //Row Height Fix
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Seq||App Type||Office|Module|Menu||Excel|RQST Date|RQST ID|RQST Name|Result|Request\nCancel|Approval Date|Approval ID|Approval Name||Remark" ;
                    //var HeadTitle = "NO|STS||Date|Cost Office|CSR No.|No of INV.|Payment S/P|payment Due Date|Currency|Total Amount|Remark|" ;

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,      DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true,     "ibflag",           false,        	"",       dfNone,   	0,     false,      	false);
                    InitDataProperty(0, cnt++ , dtSeq,      	30,    daCenter,  false,    "seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	100,    daCenter,  false,    "auth_apro_rqst_no",    false,          "",       dfNone,	    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  false,    "auth_apro_tp_nm",     	false,          "",       dfNone,   	0,     false,      	false);
					InitDataProperty(0, cnt++ , dtHidden,      	50,    daCenter,  false,    "auth_apro_tp_cd",       false,          "",       dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "rqst_ofc_cd",       false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "sub_sys_cd",       false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	120,    daLeft,  false,    "pgm_nm",      false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,         0,    daCenter,  false,    "pgm_no",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  false,    "xls_flg",      false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "rqst_st_dt",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "rqst_usr_id",         false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "rqst_usr_nm",         false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,  false,    "apro_rslt",       false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  false,    "cxl_flg",       false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "auth_apro_dt",        	false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "auth_apro_usr_id",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "auth_apro_usr_nm",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,   false,    "dtl_pgm_url_ctnt",     false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        200,    daLeft,    false,    "auth_apro_rmk",          false,          "",       dfNone,   	0,     false,       false);
                    
//                    ColHidden(1) = true;
//                    PopupImage  =  "/hanjin/img/btns_search.gif";  
//                    ShowButtonImage = 2; 
             }
             break;
             
            case 3:      //TRS W/O용
                with (sheetObj) {
            	    // 높이 설정
                    style.height = 382;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
    				MergeSheet =  msPrevColumnMerge + msHeaderOnly;
    				
    				// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    MultiSelection = false;
                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(32, 0, 0, true);
                    //InitColumnInfo(11, 0, 0, true);

                    //Row Height Fix
                    InitHeadMode(true, true, true, true, false,false)

                   var HeadTitle = "|Seq||Module|App\nType||Menu||||W/O No.|S/P\nCode|S/P\nName|From Node|Via Node|To Node|Door\nLocation|Request Type|Approval\nAMT|RQST Date|RQST ID|RQST Name|Result|Request\nCancel|Approval Date|Approval ID|Approval Name|RQST Office||Approval Remark||" ;

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,      DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,     	100,    daCenter,  true,    "auth_apro_rqst_no",    false,          "",       dfNone,	    0,     false,       false );
                    InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,    "seq",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true,     "ibflag",           false,        	"",       dfNone,   	0,     false,      	false);
                    
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "sub_sys_cd",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
					InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "auth_apro_tp_nm",     	false,          "",       dfNone,   	0,     false,      	false, 		-1,		false,		true );
					InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,  false,    "auth_apro_tp_cd",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
					InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "pgm_nm",      false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  false,    "pgm_no",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );

                    /* TRS START */
                    InitDataProperty(0, cnt++ , dtHidden,      	100,    daCenter,  false,    "trsp_so_tp_nm",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtHidden,      	120,    daCenter,  false,    "trsp_cost_dtl_mod_nm",false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "trsp_wo_no",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 50,    daCenter,  false,    "vndr_seq",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	140,    daLeft,    false,    "vndr_nm",        	    false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "fm_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "via_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "to_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "dor_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	100,    daLeft,    false,    "request_type",        false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtHidden,      	 80,    daRight,   false,    "approval_amt",        false,          "",       dfFloat,   	2,     false,       false, 		-1,		false,		true );
                    /* TRS END */

                    InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "rqst_st_dt",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "rqst_usr_id",         false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "rqst_usr_nm",         false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,  false,    "apro_rslt",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  false,    "cxl_flg",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "auth_apro_dt",        	false,          "",       dfDateYmd,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "auth_apro_usr_id",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "auth_apro_usr_nm",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtData,      	 80,    daCenter,  false,    "rqst_ofc_cd",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtHidden,      	200,    daCenter,  false,    "rqst_rsn_rmk",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );//임시 savename
                    InitDataProperty(0, cnt++ , dtData,      	450,    daLeft,  false,    "auth_apro_rmk",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );//임시 savename
                    InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,   false,    "dtl_pgm_url_ctnt",     false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    InitDataProperty(0, cnt++ , dtHidden,     	  0,    daCenter,  false,    "auth_apro_rqst_no_seq",      		false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		true );
                    
//                    ColHidden(1) = true;
//                    PopupImage  =  "/hanjin/img/btns_search.gif";  
//                    ShowButtonImage = 2; 
                    HeadRowHeight = 50;
                    ScrollBar = 3;
             }
             break;

        }
    }
    
  	/** 
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      */ 
     function obj_keypress(){
    	 obj = event.srcElement;
    	 if(obj.dataformat == null) return;
    	 	
    	 window.defaultStatus = obj.dataformat;
    	 switch(obj.dataformat) {
    	 	case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	        break;
    	    case "eng":
    	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    case "engup":
    	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    
    	 }
     } 
     
     /** 
      * Object 의 deactivate 이벤트에 대한 처리  <br>
      */
     function obj_deactivate(){
    	 var formObj = document.form;
    	 obj = event.srcElement;
      
    	 if(obj.name=="sdate"  ){
        			
    		 with(formObj){
 	        			
    			 var creDtFr = ComReplaceStr(sdate.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
        }
      	if(obj.name=="edate"  ){
   		 with(formObj){
   			 var creDtFr = ComReplaceStr(edate.value,"-","");
 	        }
 	        ComChkObjValid(event.srcElement);
       }
      	
      	 if(obj.name=="sdate_auth"  ){
 			
    		 with(formObj){
 	        			
    			 var creDtFr = ComReplaceStr(sdate_auth.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
        }
      	if(obj.name=="edate_auth"  ){
   		 with(formObj){
   			 var creDtFr = ComReplaceStr(edate_auth.value,"-","");
 	        }
 	        ComChkObjValid(event.srcElement);
       }
   }
      
      /**
       * AXON 이벤트 처리
       */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
     
    function sheet1_OnSearchEnd() {
    	var sheetObj = sheetObjects[0];
    }
    
    function sheet1_OnSaveEnd() {
    }
    
    function sheet1_OnChange(sheetObj , row , col, value)
    {
    	var formObj = document.form;
		var sName = sheetObj.ColSaveName(col);
		var rows = sheetObj.Rows;
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,vAllYN) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

          case IBSEARCH:
        	    //RETRIEVE BUTTON CLICK EVENT
               if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value = SEARCHLIST;                
                sheetObj.DoSearch4Post("COM_ENS_0U2GS.do", FormQueryString(formObj));
          break;
          
          case SEARCH:
        	  //RHQ OFFICE COMBO LIST SEARCH
              formObj.f_cmd.value = SEARCH;                
              var searchXml =  sheetObj.GetSearchXml("COM_ENS_0U2GS.do", FormQueryString(formObj));
              var rhqOfcCdList = ComGetEtcData(searchXml, "rhq_ofc_cd_list");
              var arrRhqOfcCd = "";
              if (rhqOfcCdList != "") {
            	  arrRhqOfcCd = rhqOfcCdList.split("|");
            		if(vAllYN){
            			ComClearCombo(formObj.rhq_ofc_cd_csr); //RHQ OFFICE CD COMBO초기화
          	    		ComClearCombo(formObj.rhq_ofc_cd_auth); //RHQ OFFICE CD COMBO초기화
            		}else{
            			if(beforetab==0){
            				ComClearCombo(formObj.rhq_ofc_cd_csr); //RHQ OFFICE CD COMBO초기화
            			}else if(beforetab==1){
            				ComClearCombo(formObj.rhq_ofc_cd_auth); //RHQ OFFICE CD COMBO초기화
            			}
            		}
      	    	
            	ComAddComboItem(formObj.rhq_ofc_cd_csr, 'ALL', 'ALL');
  	 			for (var i = 0; i < arrRhqOfcCd.length; i++) {
  	 				if(vAllYN){
  	 					ComAddComboItem(formObj.rhq_ofc_cd_csr, arrRhqOfcCd[i], arrRhqOfcCd[i]);
        	    		ComAddComboItem(formObj.rhq_ofc_cd_auth, arrRhqOfcCd[i], arrRhqOfcCd[i]);
            		}else{
            			if(beforetab==0){
            				ComAddComboItem(formObj.rhq_ofc_cd_csr, arrRhqOfcCd[i], arrRhqOfcCd[i]);
            			}else if(beforetab==1){
            				ComAddComboItem(formObj.rhq_ofc_cd_auth, arrRhqOfcCd[i], arrRhqOfcCd[i]);
            			}
            		}        	    		
  	 			}
              }
              
              ComAddComboItem(formObj.ofc_cd, 'ALL', 'ALL');
			  sheetObj.RemoveEtcData();
         break;
           
          case SEARCH01:
        	  //SEARCH CODE : RHQ OFFICE CODE, OFFICE TYPE CODE
              formObj.f_cmd.value = SEARCH01;                
              var searchXml =  sheetObj.GetSearchXml("COM_ENS_0U2GS.do", FormQueryString(formObj));
              var accRhqOfcCd = ComGetEtcData(searchXml, "rhq_ofc_cd");
              var ofcTpCd = ComGetEtcData(searchXml, "ofc_tp_cd");
			  formObj.acct_rhq_ofc_cd.value = accRhqOfcCd;
			  formObj.ofc_tp_cd.value = ofcTpCd;
			  sheetObj.RemoveEtcData();
         break;
         
         case SEARCH02:
        	  //OFFICE COMBO LIST SEARCH
              formObj.f_cmd.value = SEARCH02;                
              var searchXml =  sheetObj.GetSearchXml("COM_ENS_0U2GS.do", FormQueryString(formObj));
              var ofcCdList = ComGetEtcData(searchXml, "ofc_cd_list");
              var arrOfcCd = "";
              
              if (ofcCdList != "" && ofcCdList != "null") {
            	arrOfcCd = ofcCdList.split("|");
            	if(vAllYN){
            		ComClearCombo(formObj.ofc_cd); //OFFICE CD COMBO초기화
      	    		ComClearCombo(formObj.ofc_cd_auth); //OFFICE CD COMBO초기화
        		}else{
        			if(beforetab==0){
        				ComClearCombo(formObj.ofc_cd); //OFFICE CD COMBO초기화
        			}else if(beforetab==1){
        				ComClearCombo(formObj.ofc_cd_auth); //OFFICE CD COMBO초기화
        			}
        		}
            		
            	ComAddComboItem(formObj.ofc_cd, 'ALL', 'ALL');
      	 		for (var i = 0; i < arrOfcCd.length; i++) {
      	 			if(vAllYN){
      	 				ComAddComboItem(formObj.ofc_cd, arrOfcCd[i], arrOfcCd[i]);
          	    		ComAddComboItem(formObj.ofc_cd_auth, arrOfcCd[i], arrOfcCd[i]);
            		}else{
            			if(beforetab==0){
            				ComAddComboItem(formObj.ofc_cd, arrOfcCd[i], arrOfcCd[i]);
            			}else if(beforetab==1){
            				ComAddComboItem(formObj.ofc_cd_auth, arrOfcCd[i], arrOfcCd[i]);
            			}
            		}
      	 		}
              } 
              
			  sheetObj.RemoveEtcData();
         break;
         
         case SEARCH03:
       	  	//OFFICE COMBO LIST SEARCH
             formObj.f_cmd.value = SEARCH03;
             var searchXml =  sheetObj.GetSearchXml("COM_ENS_0U2GS.do", FormQueryString(formObj));
             var ofcCdList = ComGetEtcData(searchXml, "ofc_cd_list");
             var arrOfcCd = "";
             
             if (ofcCdList != "" && ofcCdList != "null") {
            	 arrOfcCd = ofcCdList.split("|");
            	 if(vAllYN){
             		ComClearCombo(formObj.ofc_cd); //OFFICE CD COMBO초기화
       	    		ComClearCombo(formObj.ofc_cd_auth); //OFFICE CD COMBO초기화
         		}else{
         			if(beforetab==0){
         				ComClearCombo(formObj.ofc_cd); //OFFICE CD COMBO초기화
         			}else if(beforetab==1){
         				ComClearCombo(formObj.ofc_cd_auth); //OFFICE CD COMBO초기화
         			}
         		}
            	 
            	 ComAddComboItem(formObj.ofc_cd, 'ALL', 'ALL');
     	 		 for (var i = 0; i < arrOfcCd.length; i++) {
     	 			if(vAllYN){
      	 				ComAddComboItem(formObj.ofc_cd, arrOfcCd[i], arrOfcCd[i]);
          	    		ComAddComboItem(formObj.ofc_cd_auth, arrOfcCd[i], arrOfcCd[i]);
            		}else{
            			if(beforetab==0){
            				ComAddComboItem(formObj.ofc_cd, arrOfcCd[i], arrOfcCd[i]);
            			}else if(beforetab==1){
            				ComAddComboItem(formObj.ofc_cd_auth, arrOfcCd[i], arrOfcCd[i]);
            			}
            		}
     	 		}
     	 		
             }
             
			  sheetObj.RemoveEtcData();
        break;
        
         case SEARCH04:
        	  	//OFFICE COMBO LIST SEARCH
              formObj.f_cmd.value = SEARCH03;                
              var searchXml =  sheetObj.GetSearchXml("COM_ENS_0U2GS.do", FormQueryString(formObj));
              var ofcCdList = ComGetEtcData(searchXml, "ofc_cd_list");
              var arrOfcCd = "";
              
              if (ofcCdList != "" && ofcCdList != "null") {
             	 arrOfcCd = ofcCdList.split("|");
             	if(vAllYN){
             		ComClearCombo(formObj.ofc_cd); //OFFICE CD COMBO초기화
       	    		ComClearCombo(formObj.ofc_cd_auth); //OFFICE CD COMBO초기화
         		}else{
         			if(beforetab==0){
         				ComClearCombo(formObj.ofc_cd); //OFFICE CD COMBO초기화
         			}else if(beforetab==1){
         				ComClearCombo(formObj.ofc_cd_auth); //OFFICE CD COMBO초기화
         			}
         		}
             	
             	ComAddComboItem(formObj.ofc_cd, 'ALL', 'ALL');
      	 		 for (var i = 0; i < arrOfcCd.length; i++) {
      	 			if(vAllYN){
      	 				ComAddComboItem(formObj.ofc_cd, arrOfcCd[i], arrOfcCd[i]);
          	    		ComAddComboItem(formObj.ofc_cd_auth, arrOfcCd[i], arrOfcCd[i]);
            		}else{
            			if(beforetab==0){
            				ComAddComboItem(formObj.ofc_cd, arrOfcCd[i], arrOfcCd[i]);
            			}else if(beforetab==1){
            				ComAddComboItem(formObj.ofc_cd_auth, arrOfcCd[i], arrOfcCd[i]);
            			}
            		}
      	 		}
              }
              
 			  sheetObj.RemoveEtcData();
         break;
         
         

           
         case IBDOWNEXCEL:        
        	 //EXCEL DOWNLOAD
        	 sheetObj.SpeedDown2Excel("0", false, false, "","",false,false, "",false,"","",false, "",true) ;
         break;
         
         case IBSEARCH_ASYNC01:	//권한 로케이션 날짜 조회
       	  
   			var sXml = getInputValue(sheetObj,formObj.usr_ofc_cd.value);
   			//alert(sXml);
   			//if(ComGetEtcData(sXml, "ofc_cd") != 'null'){
   				ComSetObjValue(formObj.DB_DATE, ComGetEtcData(sXml, "curr_date"));
   			//}
   			break;
           
        }
    }
    
 // Sheet관련 프로세스 처리
    // Authorization
       function doActionIBSheet2(sheetObj,formObj,sAction) {
           sheetObj.ShowDebugMsg = false;

           switch(sAction) {
           case SEARCH01:
        	  	//Authorization Inquiry SEARCH
           	 if(!validateForm_auth(sheetObj,formObj,sAction)) {
                    return false;
                }
              formObj.f_cmd.value = COMMAND03;  
              sheetObj.DoSearch("COM_ENS_0U2GS_AUTH.do", FormQueryString(formObj));
              
         break;
             case IBSEARCH_ASYNC01:	//TRS용
            	 if(!validateForm_auth(sheetObj,formObj,sAction)) {
                     return false;
                 }
            	 formObj.f_cmd.value = COMMAND50;                
   	            selectVal = FormQueryString(formObj);
   	            sheetObj.DoSearch("COM_ENS_0U2GS_AUTH.do", FormQueryString(formObj));
       			break;
             
           }
       }
     
    
    /**
     * Form Object Event - onBlur <br>
     */
    function obj_blur(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var diffDay = "";
    	
    	srcName = window.event.srcElement.getAttribute("name");
    	switch (srcName) {
			case "sdate":
				formObj.sdate.value = ComGetMaskedValue(formObj.sdate.value, "ymd");
				if(ComTrimAll(formObj.edate) != ""){
			    	diffDay = ComGetDaysBetween(formObj.sdate, formObj.edate);
			    	
					if(diffDay < 0){
						ComShowCodeMessage('COM12133',"To date","from date","greater") ;
						formObj.sdate.value = "";
						formObj.sdate.focus() ;
						rtnVal = false;
					}
				}
				
			break;
			
			case "edate":
				formObj.edate.value = ComGetMaskedValue(formObj.edate.value, "ymd");
				
				if(ComTrimAll(formObj.sdate) != ""){
			    	diffDay = ComGetDaysBetween(formObj.sdate, formObj.edate);
			    	
					if(diffDay < 0){
						ComShowCodeMessage('COM12133',"To date","from date","greater") ;
						formObj.edate.value = "";
						formObj.edate.focus() ;
						rtnVal = false;
					}
				}
			break;
			case "sdate_auth":
				formObj.sdate_auth.value = ComGetMaskedValue(formObj.sdate_auth.value, "ymd");
				if(ComTrimAll(formObj.edate_auth) != ""){
			    	diffDay = ComGetDaysBetween(formObj.sdate_auth, formObj.edate_auth);
			    	
					if(diffDay < 0){
						ComShowCodeMessage('COM12133',"To date","from date","greater") ;
						formObj.sdate_auth.value = "";
						formObj.sdate_auth.focus() ;
						rtnVal = false;
					}
				}
				
			break;
			
			case "edate_auth":
				formObj.edate_auth.value = ComGetMaskedValue(formObj.edate_auth.value, "ymd");
				
				if(ComTrimAll(formObj.sdate_auth) != ""){
			    	diffDay = ComGetDaysBetween(formObj.sdate_auth, formObj.edate_auth);
			    	
					if(diffDay < 0){
						ComShowCodeMessage('COM12133',"To date","from date","greater") ;
						formObj.edate_auth.value = "";
						formObj.edate_auth.focus() ;
						rtnVal = false;
					}
				}
			break;
    	}
			
    }
    
  
   /**
     * Search Validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var rtnVal = true;
    	
    	if(ComTrimAll(formObj.sdate) == ""){
    		ComShowCodeMessage('COM12132') ;
    		formObj.sdate.focus() ;
    		rtnVal = false;
    	}else if(ComTrimAll(formObj.edate) == ""){
    		ComShowCodeMessage('COM12132') ;
    		formObj.edate.focus() ;
    		rtnVal = false;
    	}else if(formObj.rhq_ofc_cd_csr.value == ""){
			ComShowCodeMessage('COM12113',"RHQ") ;
			formObj.rhq_ofc_cd_csr.focus() ;
			rtnVal = false;
		}else if(formObj.ofc_cd.value == ""){
			ComShowCodeMessage('COM12113',"Office") ;
			formObj.ofc_cd.focus() ;
			rtnVal = false;
		}
			
        return rtnVal;
    }
    
    /**
     * Search Validation_auth
     */
    function validateForm_auth(sheetObj,formObj,sAction){
    	var rtnVal = true;
    	if(ComTrimAll(formObj.sdate_auth) == ""){
    		ComShowCodeMessage('COM12132') ;
    		formObj.sdate_auth.focus() ;
    		rtnVal = false;
    	}else if(ComTrimAll(formObj.edate_auth) == ""){
    		ComShowCodeMessage('COM12132') ;
    		formObj.edate_auth.focus() ;
    		rtnVal = false;
    	}else if(formObj.ofc_cd_auth.value == ""){
			ComShowCodeMessage('COM12113',"Office") ;
			formObj.ofc_cd_auth.focus() ;
			rtnVal = false;
		}
//    	else if(formObj.auth_apsts_cd.value == null){
//			ComShowCodeMessage('COM12113',"App Type") ;
//			formObj.auth_apro_tp_cd.focus() ;
//			rtnVal = false;
//		}
			
        return rtnVal;
    }
    
    /**
     * FORM CHANGE EVENT : RHQ OFFICE COMBOBOX
     * 2018-05-15 OFC CODE change SELOPA,SELOPB->SELCON
     */
    function changeRhqOfcCd_csr(objVal){
    	var formObj = document.form;
    	var usrOfcCd = form.usr_ofc_cd.value ;
    	formObj.rhq_ofc_cd.value = formObj.rhq_ofc_cd_csr.value;
    	if((formObj.ofc_tp_cd.value == "HT" || formObj.ofc_tp_cd.value == "HG") && ((usrOfcCd =="SELCON" || usrOfcCd =="SELOP" ))){
         	doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
    	}
    	
    	if(formObj.rhq_ofc_cd.value == "ALL"){
    		ComClearCombo(formObj.ofc_cd);
    		ComAddComboItem(formObj.ofc_cd, 'ALL', 'ALL');
    	}

    }
    
    /**
     * FORM CHANGE EVENT : RHQ OFFICE COMBOBOX
     * 2018-05-15 OFC CODE change SELOPA,SELOPB->SELCON
     */
    function changeRhqOfcCd_auth(objVal){
    	var formObj = document.form;
    	var usrOfcCdAuth = form.usr_ofc_cd_auth.value ;
    	formObj.rhq_ofc_cd.value = formObj.rhq_ofc_cd_auth.value;
    	if((formObj.ofc_tp_cd.value == "HT" || formObj.ofc_tp_cd.value == "HG") && (usrOfcCdAuth =="SELCON" || usrOfcCdAuth =="SELOP")){
    		
    		doActionIBSheet(sheetObjects[1],formObj,SEARCH03);
    	}

    }
    
    /*
     * Office type code가 HT일 경우만 RHQ 콤보박스 활성화 한다.
     */
    function controlRhqCombo() {
    	var formObj = document.form;
	    var ofcTpCd = formObj.ofc_tp_cd.value;
    	if(ofcTpCd == 'HT'|| ofcTpCd == 'HG') { // 본사 OFC
    		formObj.rhq_ofc_cd_csr.disabled = false;
    		formObj.rhq_ofc_cd_auth.disabled = false;
    	} else {
    		formObj.rhq_ofc_cd_csr.disabled = true;
    		formObj.rhq_ofc_cd_auth.disabled = true;
    	}
    }
    		
    
    /**
	  * OnPopupClick 이벤트 발생시 호출되는 function <br>
	  * Sheet1 Popup버튼 클릭시 팝업화면 호출. 팝업화면에서 수정된 결과는 해당 sheet의 내용을 조합하여 Sheet1에 다시 Update해준다.
	  * 
	  * @param {ibsheet} sheetObj 필수 IBSheet Object
	  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	  * @return 없음
	  * @author 
	  * @version 2015.01.02
	  */
	 function sheet1_OnPopupClick(sheetObj, Row, Col) {
	 	var colName = sheetObj.ColSaveName(Col);

	   	if (colName == "agmt_doc_cfm_cd" || colName == "agmt_file_cfm_cd" || colName == "file_upld_flg") {
	   		if(sheetObj.RowCount > 0){
	   			var v_csr_no = sheetObj.CellValue(Row, "csr_no");
	 			
	         	if(v_csr_no != "") {
	             	var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus=1|1|1&readOnly=Y";
	             	ComOpenPopup(url, 1020, 580, '', 'none', true); 
	         	}
	   		}
	   	}	 	
	 }
	 

		 
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt = 0;
				InsertTab(cnt++, "Expense", -1);
				InsertTab(cnt++, "Basic Data", -1);
			}
			break;
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		//------------------------------------------------------//
		beforetab = nItem;
		if(beforetab == 1){
			document.form.auth_apro_tp_cd.value = "ALL";
			comboObjects[2].RemoveAll();
			setComboData(comboObjects[2]);
		}
	}
	
	/**
	 * Radio 클릭시 이벤트 관련
	 * 
	 */
	function obj_onclick(){
		var formObj = document.form;
		var obj	 = event.srcElement;
		if ( obj.name == "auth_apro_tp_cd" ) {
			authAproTpCd = ComGetObjValue(obj);
			formObj.auth_apro_tp_cd.value = authAproTpCd;
			comboObjects[2].RemoveAll();
			setComboData(comboObjects[2]); //Status
			
			comboObjects[1].RemoveAll();
			setComboData(comboObjects[1]);
			document.form.pgm_no.value = "";//Menu 초기화
			setComboData(comboObjects[0], authAproTpCd); 
		}
	}
	

	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){     
    	comboObjects[comboCnt++] = combo_obj;  
	}	
	
	/**
	 * IBCombo 기본 설정
	 * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "pgm_no": 	//Year
				with (comboObj) { 
				
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					
					setComboData(comboObj);
				}
			break;
			
			case "auth_apsts_cd": 	//Year
				with (comboObj) { 
				
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					
					setComboData(comboObj);
				}
			break;
			
			case "sub_sys_cd_auth": 	//Year
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					
					setComboData(comboObj, "ALL");
				}
			break;
		
		}
	}
	
	function setComboData(comboObj, param){ 
		var comboID = comboObj.id;
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
		switch(comboID){
			case "pgm_no":	
				if(param == "ALL"){
					comboObj.InsertItem(0, "--ALL--", "ALL");
					comboObj.Code2 = "ALL";
				}else{
					var sParam = "f_cmd=" + COMMAND02 + "&sub_sys_cd_auth="+param;
					var xml = sheetObj.GetSearchXml("COM_ENS_0U2GS_AUTH.do", sParam );
					ComXml2ComboItem(xml,formObj.pgm_no,"pgm_no","pgm_nm");	
					comboObj.InsertItem(0, "--ALL--", "ALL");
					comboObj.Code2 = "ALL";
				}
				
				
				break;
				
			case "auth_apsts_cd":	
				if(formObj.auth_apro_tp_cd.value=="AF"){
					comboObj.InsertItem(0, "--ALL--", "ALL");
					comboObj.InsertItem(1, "Requested", "P");
					comboObj.InsertItem(2, "Confirmed", "C");
					comboObj.Code2 = "ALL";
				}else if(formObj.auth_apro_tp_cd.value=="BF"){
					comboObj.InsertItem(0, "--ALL--", "ALL");
					comboObj.InsertItem(1, "Requested", "P");
					comboObj.InsertItem(2, "Approved", "C");
					comboObj.InsertItem(3, "Disapproved", "R");
					comboObj.Code2 = "ALL";
				}else if(formObj.auth_apro_tp_cd.value=="ALL"){
					comboObj.InsertItem(0, "--ALL--", "ALL");
					comboObj.InsertItem(1, "Requested", "P");
					comboObj.InsertItem(2, "Confirmed", "C");
					comboObj.InsertItem(3, "Approved", "C");
					comboObj.InsertItem(4, "Disapproved", "R");
					comboObj.Code2 = "ALL";
				}
				break;
			case "sub_sys_cd_auth":		
				var sParam = "f_cmd=" + COMMAND01+"&auth_apro_tp_cd="+param;
		
				var xml = sheetObj.GetSearchXml("COM_ENS_0U2GS_AUTH.do", sParam );
				ComXml2ComboItem(xml,formObj.sub_sys_cd_auth,"sub_sys_cd_auth","sub_sys_cd");
				comboObj.InsertItem(0, "--ALL--", "ALL");
				comboObj.Code2 = "ALL";
				document.form.sub_sys_cd_auth.value="ALL";
				break;
			
		}
		
		
	}
	
	
/**
 * 모듈 변경시
 * @param comboObj
 * @param Index_Code
 * @param Text
 */
function sub_sys_cd_auth_OnChange(comboObj, Index_Code, Text){
	comboObjects[1].RemoveAll();
	setComboData(comboObjects[1], Index_Code);
	document.form.sub_sys_cd_auth.value = Index_Code;
	document.form.pgm_no.value = "";//Menu 초기화
}
	
/**
 * Menu 변경시
 * @param comboObj
 * @param Index_Code
 * @param Text
 */
function pgm_no_OnChange(comboObj, Index_Code, Text){
	document.form.pgm_no.value = Index_Code;
}
	
/**
 * Status 변경시
 * @param comboObj
 * @param Index_Code
 * @param Text
 */
function auth_apsts_cd_OnChange(comboObj, Index_Code, Text){
	document.form.auth_apsts_cd.value = Index_Code;
}
	
 function sheet2_OnChange(sheetObj , row , col, value)
{
 	
	
}
	 
	 function sheet2_OnSearchEnd(){
		 //ComBtnDisable("btn_Detail_Auth");
		 
	 }
	 
	 function sheet3_OnSearchEnd(){
		var sheetObj = sheetObjects[2];
		var rows = sheetObj.Rows;
		for(var i=1; i<rows; i++){
			if(sheetObj.cellValue(i, "auth_apro_rqst_no_seq")!=1){
				sheetObj.CellEditable(i,"auth_apro_rmk") = false;
				sheetObj.CellValue(i,"auth_apro_rmk") = "";
				
				//개발중
			}else if(sheetObj.cellValue(i, "auth_apro_rqst_no_seq")==1){
				sheetObj.CellEditable(i,"auth_apro_rmk") = false;
			}
//				sheetObj.CellEditable(i,"auth_apro_rmk") = true;
		}
	 }
	 
	 
	 
	
	 function setPeriod(){
			var formObj = document.form;
			var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
			var fr_dt;
			if (to_dt!=undefined && to_dt!=null && to_dt.trim()!='' && to_dt.length==8 && !isNaN(to_dt)){
				//fr_dt = csr_getDiffDate(to_dt, -30, 'D');
				fr_dt = getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
				if (fr_dt!=undefined && fr_dt!=null && fr_dt.trim()!='' && fr_dt.length==8){
					if (fr_dt.substring(6,8) > getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6))){
						
						fr_dt = fr_dt.substring(0,6) + getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6));
					}
					
					formObj.sdate.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
					formObj.edate.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
					formObj.sdate_auth.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
					formObj.edate_auth.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
				}
			}	
		}

		function getDiffDate(sdate, sdiff, stype) {
			/***********************************************************
				sdate:  YYYYMMDD 형식의 문자열
				sdiff:  차이값
				stype:	'Y' - 년
						'M' - 월
						'D'/NULL/''/이외  - 일
			***********************************************************/
			
			var tyy = sdate.substring(0,4);
			var tmm = sdate.substring(4,6) - 1;
			var tdd = sdate.substring(6,8);

			if (stype == "M") tdd = "01";

			var currdate = new Date(tyy,tmm,tdd);

			switch (stype) {
				case "Y" :
					diffdate = new Date(currdate.getYear() + sdiff,currdate.getMonth(),currdate.getDate());
					break;
				case "M" :
					diffdate = new Date(currdate.getYear(),currdate.getMonth() + sdiff,currdate.getDate());
					break;
				default  :
					diffdate = new Date(currdate.getYear(),currdate.getMonth(),currdate.getDate() + sdiff);
					break;
			}

			var tmpyy = diffdate.getYear();
			var ls_yy = (tmpyy > 99) ? tmpyy : 1900 + tmpyy;

			var tmpmm = diffdate.getMonth();
			var ls_mm = (tmpmm < 9)  ? "0" + (tmpmm + 1) : tmpmm + 1;

			var tmpdd = diffdate.getDate();
			var ls_dd = (tmpdd < 10) ? "0" + tmpdd : tmpdd;
			
			switch (stype) {
				case "M" :
					return ls_yy.toString() + ls_mm.toString();
				default  :
					return ls_yy.toString() + ls_mm.toString() + ls_dd.toString() ;
			}
			
		}

		function getInputValue(sheetObj,ofc_cd){
			var f_query = '';
			//쿼리 스트링 조합시작
			f_query += 'f_cmd' + '=' + COMMAND05 + '&';
			f_query += 'ofc_cd=' + ofc_cd + '&';
			var sXml = sheetObj.GetSearchXml("CSR_COM01.do","" ,f_query,true);
			return  sXml;
		}

		/**
		 * 해당 년, 월의 마지막 일자를 가져온다
		 * @param year   년
		 * @param month  월
		 * @return 마지막 일자
		*/
		function getEndDay(year,month) {
		   //if (!isMonth(month)) return 0;
		   if ((month==01)||(month==03)||(month==05)||(month==07)||(month==08)||(month==10)||(month==12)) {
		       return 31;
		   } else {
		       if(month==02) {
		           if ((year%4==0) && ((year/4)%200!=0))   return 29;
		           else    return 28;
		       } else {
		           return 30;
		       } // end if
		   } // end if
		}
		
function setInit(usrOfcCd){
	var formObj = document.form;
	
	  //SEARCH COMBO CODE : RHQ OFFICE CODE LIST
    doActionIBSheet(sheetObjects[0],formObj,SEARCH,true);
    doActionIBSheet(sheetObjects[1],formObj,SEARCH,true);
    //SEARCH CODE : RHQ OFFICE CODE, OFFICE TYPE CODE
    doActionIBSheet(sheetObjects[0],formObj,SEARCH01,true);
    doActionIBSheet(sheetObjects[1],formObj,SEARCH01,true);
    rhqOfcCd = formObj.acct_rhq_ofc_cd.value;
    formObj.rhq_ofc_cd.value = formObj.rhq_ofc_cd_csr.value;
    if((formObj.ofc_tp_cd.value == "HT" ||formObj.ofc_tp_cd.value == "HG") && (usrOfcCd =="SELOPA" || usrOfcCd =="SELOPB" || usrOfcCd =="SELOP" )){
    	doActionIBSheet(sheetObjects[0],formObj,SEARCH03,true);
//	        	doActionIBSheet(sheetObjects[1],formObj,SEARCH03,'ALL');
    }else{
    	formObj.rhq_ofc_cd_csr.value = formObj.acct_rhq_ofc_cd.value;
    	formObj.rhq_ofc_cd_auth.value = formObj.acct_rhq_ofc_cd.value;
        //SEARCH COMBO CODE : OFFICE CODE 
        doActionIBSheet(sheetObjects[0],formObj,SEARCH02,true);
//		        doActionIBSheet(sheetObjects[1],formObj,SEARCH02);
        form.ofc_cd.value = form.usr_ofc_cd.value;
        form.ofc_cd_auth.value = form.usr_ofc_cd_auth.value;
    }
    
    //ALL이 기본적으로 선택되도록 함
	var selRhq = document.getElementById("rhq_ofc_cd_csr");
    for(var i=0;i<selRhq.length; i++){
  	  if(selRhq[i].value=='ALL'){
  		selRhq[i].selected=true;
  	  }
    }
    
    var selOfc = document.getElementById("ofc_cd");
    for(var i=0;i<selOfc.length; i++){
  	  if(selOfc[i].value=='ALL'){
  		selOfc[i].selected=true;
  	  }
    }
    
    //RHQ Combo Office Type Code가 "HT"일 경우 활성화, 이외 비활성화
    controlRhqCombo();
    
    doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);		
	setPeriod();
	//라디오 버튼 초기화
	document.form.auth_apro_tp_cd.value = "ALL";
	comboObjects[2].RemoveAll();
	setComboData(comboObjects[2]);
}

/**
 * Auth 모듈별 Sheet 전환
*/
function setAuthSheets(){
	var formObj = document.form;
	 var sheetObject2 = sheetObjects[1]; //Basic Data default
     var sheetObject3 = sheetObjects[2]; //Basic Data TRS W/O
     
	if(formObj.pgm_no.value == 'ESD_TRS_0024'){
		sheetFlg = 1;
		document.all.defaultAuth.style.display = 'none';
		document.all.trsAfWo.style.display = 'inline';
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		doActionIBSheet2(sheetObject3,formObj,IBSEARCH_ASYNC01);
	}else{//default
		sheetFlg = 0;
		document.all.defaultAuth.style.display = 'inline';
		document.all.trsAfWo.style.display = 'none';
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		doActionIBSheet2(sheetObject2,formObj,SEARCH01);
	}
	

}

function setAuthDetailBtn(sheetObject){
	var selRow = sheetObject.SelectRow;
	var param = sheetObject.CellValue(selRow, "dtl_pgm_url_ctnt");
	var authAproRqstNo = sheetObject.CellValue(selRow, "auth_apro_rqst_no");
	if(authAproRqstNo != null && authAproRqstNo != "" && authAproRqstNo != "undefined"){
		var url = "/hanjin/"+param+authAproRqstNo;
		ComOpenPopup(url, 1020, 380, '', 'none', true); 
	}
}

/**
 * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {long}	X			X 좌표
 * @param {long}	Y			Y 좌표
 * @return
 */	 

function sheet3_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
	var row = t1sheet1.MouseRow;
	var col = t1sheet1.MouseCol;
	if (t1sheet1.ColSaveName(col) == "vndr_nm" && row >= 1
			&& t1sheet1.CellValue(row, "vndr_nm") != null
			&& t1sheet1.CellValue(row, "vndr_nm") != '') {
		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "vndr_nm");
	}else if (t1sheet1.ColSaveName(col) == "auth_apro_rmk" && row >= 1
			&& t1sheet1.CellValue(row, "auth_apro_rmk") != null
			&& t1sheet1.CellValue(row, "auth_apro_rmk") != ''){
		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "auth_apro_rmk");
	}
		
} 

/**
 * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {long}	X			X 좌표
 * @param {long}	Y			Y 좌표
 * @return
 */	 

function sheet2_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
	var row = t1sheet1.MouseRow;
	var col = t1sheet1.MouseCol;
	if (t1sheet1.ColSaveName(col) == "auth_apro_rmk" && row >= 1
			&& t1sheet1.CellValue(row, "auth_apro_rmk") != null
			&& t1sheet1.CellValue(row, "auth_apro_rmk") != '') {
		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "auth_apro_rmk");
	}
		
} 

/**
 * Authorization OnClick (MEMO)
 */
function sheet2_OnClick(sheetObj, Row, Col, Value) {
	//Basic Data Common
	var url = sheetObj.CellValue(Row, "dtl_pgm_url_ctnt");
	if(url == "" || url == null){
		ComBtnDisable("btn_Detail_Auth");
	}else{
		ComBtnEnable("btn_Detail_Auth");
	}
}

function changeIfStatus(objVal){
	var formObj = document.form;
	if(objVal == 'P' || objVal == 'R'){
		formObj.if_status.value = '';
		formObj.if_status.disabled = true;
	} else {
		formObj.if_status.disabled = false;
	}
}

function enterCheck(funcNm){
	if (event.keyCode == 13){
		retrieve();
	}        
}

function retrieve(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
}


