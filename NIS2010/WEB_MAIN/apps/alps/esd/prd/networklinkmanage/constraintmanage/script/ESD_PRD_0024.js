/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0024.js
*@FileTitle :Constraint Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.24 김귀진
* 1.0 Creation
* histroy
* 2010.10.12  채창호 [CHM-201006247-01] Constraint Managment 보완.
* 2011.03.03  채창호 [CHM-201108996-01] Constraint Management 부분 기능 설정 제한 Program 개발 요청
* 2011.10.31  이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 
* 2012.06.07  이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_PRD_0024 : ESD_PRD_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0024() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.keyFieldCheck			= keyFieldCheck;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.sheet2_OnPopupClick	= sheet2_OnPopupClick;
	this.sheet3_OnPopupClick	= sheet3_OnPopupClick;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.sheet2_OnChange		= sheet2_OnChange;
	this.sheet3_OnChange		= sheet3_OnChange;
	this.validateForm			= validateForm;
	this.selectPort				= selectPort;
	this.selectLocation			= selectLocation;
	this.selectLane				= selectLane;
	this.getCOM_ENS_061			= getCOM_ENS_061;
	this.getLane				= getLane;
	this.changeSelection		= changeSelection;
	this.getNode				= getNode;
	this.getNode2				= getNode2;
	this.getLoc					= getLoc;
	this.getCommodity			= getCommodity;
	this.getCOM_ENS_051			= getCOM_ENS_051;
	this.changeDirection		= changeDirection;
	
}


//* csr: N200903120250 20090428 [PRD] Network Constraint 기능보완

// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;
var beforetab = 2;

var nodeCd = "";
var link_flag = "";

var mode = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[beforetab];


		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
//            // 버튼이 disable 인지 확인한다.
//            if(srcName != null && !ComIsEmpty(srcName)) {
//               // var btnDis  = eval("formObject."+srcName+".disabled");
//            	var btnDis = eval("document.getElementById('" + srcName + "').disabled"); 
//                if (btnDis) return;
//            }
              
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
            // if((srcObj =='INPUT'|| srcObj =='SELECT') && keyObj ==13) {
            //   srcName ='btn_retrieve';
            //}
            /****************************/       
                       
			switch(srcName) {
			case "btn_retrieve":
				var vvdValue = "";
				if (formObject.vsl_cd.value.length == 0 && formObject.skd_voy_no.value.length == 0 && formObject.skd_dir_cd.value.length == 0) {
					vvdValue = "";
				} else {
					vvdValue = ComRpad(formObject.vsl_cd.value.length==0?"_":formObject.vsl_cd.value, 4, "_");
					vvdValue = vvdValue + (ComLpad(formObject.skd_voy_no.value.length==0?"_":formObject.skd_voy_no.value, 4, "_"));
					vvdValue = vvdValue + (formObject.skd_dir_cd.value.length==0?"_":formObject.skd_dir_cd.value);
				}
				formObject.vvd.value =  vvdValue;
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
	            changeSelection(2);
    	        break;

			case "btn_save":
	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;
    	        
    	    case "btn_downexcel":
	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	        break;

    	    case "btn_loadexcel":
	            doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    	        break;

			case "btng_rowadd":
				var Row = sheetObject.DataInsert();
				sheetObject.CellValue2(Row, "s_cre_ofc_cd") = OFC_CD;
				sheetObject.CellValue2(Row, "s_upd_ofc_cd") = OFC_CD;

				break;

			case "btng_rowcopy":
				var Row = sheetObject.DataCopy();
				if (CRUD != 'S') {
                    if(sheetObject.CellValue(Row ,"s_nod_cd") =="ALL"){
                    	sheetObject.CellValue2(Row, "s_nod_cd") ="";
                    }
                    if(sheetObject.CellValue(Row ,"s_trnk_lane_cd") =="ALL"){
                    	sheetObject.CellValue2(Row, "s_trnk_lane_cd") ="";
                    }
				}
				break;


			/************* ********************** *****************/
			case "btn_node_cd":
				selectLocation('LOC');
				break;
				
			case "btn_from_cd":
				selectLocation('FROM');
				break;
			
			case "btn_to_cd":
				selectLocation('TO');
				break;
				
			case "btn_pol_port_cd":
	            selectPort(formObject, 'POL');
    	        break;

			case "btn_pod_port_cd":
	            selectPort(formObject, 'POD');
    	        break;
    	        
    	    case "btn_ts_port_cd":
	            selectPort(formObject, 'TS');
    	        break;
    	        
    	    case "btn_del_port_cd":
    	    	selectPort(formObject, 'DEL');
    	    	break;

    	    case "btn_tnk_lane_cd":
	            selectLane();
    	        break;
            case "btn_cmdt":
            	var param = '';
                param = param+'?cmdt_cd='+formObject.cmdt_cd.value+'&cmdt_nm='+formObject.cmdt_nm.value;
                ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 770, 470, 'getCmdtSch', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                break;  
            case "btn_slan_cd":
                param = '?&lane_cd='+formObject.vsl_slan_cd.value;
                ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLaneSch', "1,0,1,1,1,1,1,1,1,1,1,1",true);
				break;
			case "btn_vvd":
				var vvdParam = formObject.vsl_cd.value + formObject.skd_voy_no.value + formObject.skd_dir_cd.value;
				var param = '?lane_cd='+formObject.vsl_slan_cd.value + '&vvd_cd=' + vvdParam;
				ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVDSch', '1,0,1,1,1,1,1,1');
				
				break;

		   } // end switch
		} catch(e) {	 	
    		if( e == "[object Error]") {    			
				ComShowMessage(ComGetMsg('PRD90007'));
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetObject = sheetObjects[beforetab];
        var formObject = document.form;
       
        if(mode !='pop' && link_flag == 'Y') {            
            changeSelection(1);
            sheetObject = sheetObjects[beforetab];
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        }else if(mode =='pop' && link_flag !='Y'){
        	changeSelection(0);
        	sheetObject = sheetObjects[beforetab];
        	doActionIBSheet(sheetObject,formObject,IBSEARCH);
        } else {
        	changeSelection(2);
        }
        
//		  alert("crud=========>"+ CRUD);
//        alert("crud====?=====>"+ OFC_CD);
  	
		if(CRUD == "R") {
			ComBtnDisable("btn_save");
			ComBtnDisable("btng_rowadd");
			ComBtnDisable("btng_rowcopy");
			ComBtnDisable("btn_loadexcel");
		}     
		
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter');
//		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'loc', 'from_nd', 'to_nd','tlane','pol','tsport','pod','del');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'tlane', 'pol', 'tsport', 'pod','del', 'vsl_slan_cd', 'loc', 'from_nd', 'to_nd', 'cmdt_cd');
		axon_event.addListener('click', 'objClick' , 'general_opt_chk');
		
    }
     
    function prdComKeyDown(){
    	var keyObj=window.event.keyCode;
    	
     	if(keyObj == 9){
     		var srcName = window.event.srcElement.getAttribute("name");
     		if(srcName == "tlane" || srcName == "vsl_slan_cd"){
   	  			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
     		}else if(srcName == "pol" || srcName == "tsport" || srcName == "pod") {
     			if (window.event.srcElement.value.length == 5) {
     				inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
     			} else if (window.event.srcElement.value.length == 7) {
     				inputChkUpper(window.event.srcElement,keyObj , 'SEARCH05');
     			}
     		}else if(srcName == "del" || srcName == "loc" || srcName == "from_nd" || srcName == "to_nd"){
     			if (window.event.srcElement.value.length == 5) {
     				inputChkUpper(window.event.srcElement,keyObj , 'SEARCH02');
     			} else if (window.event.srcElement.value.length == 7) {
     				inputChkUpper(window.event.srcElement,keyObj , 'SEARCH04');
     			}
     		}else if(srcName == "cmdt_cd") {
     			if (window.event.srcElement.value.length > 0) {
     				var formObj = document.form;
     				formObj.cmdt_cd.value = ComLpad(formObj.cmdt_cd.value,6,"0");
     				var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0024GS.do", "f_cmd="+SEARCH11+"&cmdt_cd="+formObj.cmdt_cd.value ) ;
     			    var arrXml = sXml.split("|$$|");
     			    var cmdtCd = ComGetEtcData(arrXml[0], "cmdt_cd");
     			    if (cmdtCd == undefined || cmdtCd == "") {
     			    	ComShowMessage(ComGetMsg('PRD90055'));
     			    	formObj.cmdt_nm.value = "";
     			    } else {
     			    	formObj.cmdt_nm.value = ComGetEtcData(arrXml[0], "cmdt_nm");
     			    }
     			}
     		}
     	}
    	
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
        case 1:      //sheet1 init - Location Constraint
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(16) ;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(27, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle1 = "SEQ|Del.|STS|Location/\nNode|Point \nof Port|Item Name|Lane|VVD|CNTR TYPE|Commodity|Commodity|SVC|Exception\nCustomer|Remark|Effective Date|Effective Date|Creation\nDate|Creation\nOFC|Creation\nID|Update\nDate|Update\nOFC|Update\nID|ORG ITEM CD|ITEM NAME|a|b|c";
                var HeadTitle2 = "SEQ|Del.|STS|Location/\nNode|Point \nof Port|Item Name|Lane|VVD|CNTR TYPE|Code|Name|SVC|Exception\nCustomer|Remark|From|To|Creation\nDate|Creation\nOFC|Creation\nID|Update\nDate|Update\nOFC|Update\nID|ORG ITEM CD|ITEM NAME|a|b|c";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL, DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtSeq,        30,    daCenter,  true,    "Seq");
                InitDataProperty(0, cnt++, dtDelCheck ,  40,    daCenter,  true,    "s_delchk",          false,         "",       dfNone,    0,     true,       true,         -1,     false,      true,     "",       true);
                InitDataProperty(0, cnt++, dtStatus,     30,    daCenter,  true,    "s_ibflag");
                InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "s_nod_cd",          true,          "",       dfNone,    0,     false,      true,7);
                InitDataProperty(0, cnt++, dtCombo ,     50,    daCenter,  true,    "s_port_pnt_cd",     false,         "",       dfNone,    0,     false,      true);
                
                InitDataProperty(0, cnt++, dtCombo,      150,   daCenter,  true,    "s_nod_cnst_itm_cd", true,          "",       dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_vsl_slan_cd",     false,         "",       dfNone,    0,     true,       true,3);
                InitDataProperty(0, cnt++, dtPopupEdit,  85,    daCenter,  true,    "s_vvd",             false,         "",       dfNone,    0,     true,       true,9);
                InitDataProperty(0, cnt++, dtCombo,      80,    daCenter,  true,    "s_cntr_tp_cd",      false,         "",       dfNone,    0,     true,       true);
                //20090416 add
                InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "s_cmdt_cd",         false,         "",       dfNone,    0,     false,      true,6);
                
                InitDataProperty(0, cnt++, dtData ,      80,    daLeft,    true,    "s_cmdt_nm",         false,         "",       dfNone,    0,     false,      false );
                InitDataProperty(0, cnt++, dtCombo,      60,    daCenter,  true,    "s_svc_use_flg",     true,          "",       dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtPopup,      85,    daCenter,  true,    "s_cnst_cst_expt",   false,         "",       dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtData,      400,    daLeft,    true,    "s_nod_cnst_rmk",    true,          "",       dfNone,    0,     true,       true , 1000);
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_eff_fm_dt",       false,          "",      dfDateYmd, 0,     true,       true);
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_eff_to_dt",       false,          "",      dfDateYmd, 0,     true,       true);

                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_dt",          false,          "",      dfDateYmd, 0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_ofc_cd",      false,          "",      dfNone,    0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_usr_id",      false,          "",      dfNone,    0,     false,      false);                    
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_dt",          false,          "",      dfDateYmd, 0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_ofc_cd",      false,          "",      dfNone,    0,     false,      false);
                
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_usr_id",      false,          "",      dfNone,    0,     false,      false);                    
                InitDataProperty(0, cnt++, dtHidden,     10,    daCenter,  true,    "s_old_nod_cnst_itm_cd",false,       "",      dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtHidden,     10,    daCenter,  true,    "s_item_name",       false,          "",      dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtHidden,     10,    daCenter,  true,    "s_date_diff",       false,          "DateDiff(d, |s_eff_fm|, |s_eff_to|)",       dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtHidden,     10,    daCenter,  true,    "s_nod_cnst_seq",    false,          "",      dfNone,    0,     true,       true);

                InitDataProperty(0, cnt++, dtHidden,     10,    daCenter,  true,    "s_lane_vvd_chk",    false,          "",      dfNone,    0,     true,       true);

                InitDataCombo(0, "s_nod_cnst_itm_cd", ' |'+cnst_cdText, ' |'+cnst_cdCode);
                InitDataCombo(0, "s_port_pnt_cd", " |ALL|POR|POL|T/S|POD|DEL", " |ALL|POR|POL|TS|POD|DEL", "");
                InitDataCombo (0, "s_cntr_tp_cd", " |R2|R5|Tank|D2|D4|D5|D7|FR/OT", " |R2|R5|T|D2|D4|D5|D7|S");
                InitDataCombo (0, "s_svc_use_flg", " |Y|N", " |Y|N");
                
                ImageList(0) = "/hanjin/img/alps/button/btns_calendar.gif";
                PopupButtonImage(0, "s_eff_fm_dt") = 0;
                PopupButtonImage(0, "s_eff_to_dt") = 0;

                HeadRowHeight = 21 ;
                HeadRowHeight = 20 ;

				InitDataValid(0, "s_nod_cd",      vtEngUpOther, "1234567890");
				InitDataValid(0, "s_vsl_slan_cd", vtEngUpOther, "1234567890");
				InitDataValid(0, "s_vvd",         vtEngUpOther, "1234567890");
				InitDataValid(0, "s_cmdt_cd",     vtEngUpOther, "1234567890");
            }
            break;
            
        case 2:      //sheet2 init - Link Constraint
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(16) ;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(27, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle1 = "SEQ|Del.|STS|Link|Link|Mode|Item Name|Lane|VVD|CNTR TYPE|Commodity|Commodity|SVC|Remark|Effective Date|Effective Date|Creation\nDate|Creation\nOFC|Creation\nID|Update\nDate|Update\nOFC|Update\nID|a|b|c|d|e";
                var HeadTitle2 = "SEQ|Del.|STS|From|To|Mode|Item Name|Lane|VVD|CNTR TYPE|Code|Name|SVC|Remark|From|To|Creation\nDate|Creation\nOFC|Creation\nID|Update\nDate|Update\nOFC|Update\nID|a|b|c|d|e";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtSeq,        30,    daCenter,  true,    "Seq");
                InitDataProperty(0, cnt++, dtDelCheck,   40,    daCenter,  true,    "s_delchk",          false,  "",    dfNone,    0,     true,       true, -1, false, true, "", true);
                InitDataProperty(0, cnt++, dtStatus,     30,    daCenter,  true,    "s_ibflag");
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_lnk_org_nod_cd",  true,   "",    dfNone,    0,     false,      true, 7);
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_lnk_dest_nod_cd", true,   "",    dfNone,    0,     false,      true, 7);
                
                InitDataProperty(0, cnt++, dtCombo,      80,    daCenter,  true,    "s_trsp_mod_cd",     false,  "",    dfNone,    0,     false,      true);
                InitDataProperty(0, cnt++, dtCombo,      150,   daCenter,  true,    "s_lnk_cnst_itm_cd", true,   "",    dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_vsl_slan_cd",     false,  "",    dfNone,    0,     true,       true,3);
                InitDataProperty(0, cnt++, dtPopupEdit,  85,    daCenter,  true,    "s_vvd",             false,  "",    dfNone,    0,     true,       true,9);
                InitDataProperty(0, cnt++, dtCombo,      80,    daCenter,  true,    "s_cntr_tp_cd",      false,  "",    dfNone,    0,     true,       true);
                //20090416 add
                InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "s_cmdt_cd",         false,  "",    dfNone,    0,     false,      true,6);
                InitDataProperty(0, cnt++, dtData ,      80,    daLeft,    true,    "s_cmdt_nm",         false,  "",    dfNone,    0,     false,      false );
                InitDataProperty(0, cnt++, dtCombo,      60,    daCenter,  true,    "s_svc_use_flg",     true,   "",    dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtData,       400,   daLeft,    true,    "s_lnk_cnst_rmk",    true,   "",    dfNone,    0,     true,       true, 1000);
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_eff_fm_dt",       false,  "",    dfDateYmd, 0,     true,       true);
                
                InitDataProperty(0, cnt++, dtPopupEdit,  80,    daCenter,  true,    "s_eff_to_dt",       false,  "",    dfDateYmd, 0,     true,       true);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_dt",          false,  "",    dfDateYmd, 0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_ofc_cd",      false,  "",    dfNone,    0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_usr_id",      false,  "",    dfNone,    0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_dt",          false,  "",    dfDateYmd, 0,     false,      false);
                
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_ofc_cd",      false,  "",    dfNone,    0,     false,      false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_usr_id",      false,  "",    dfNone,    0,     false,      false);
                InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "s_old_lnk_cnst_itm_cd",false,"",   dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "s_item_name",       false,  "",    dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "s_date_diff",       false,  "DateDiff(d, |s_eff_fm|, |s_eff_to|)",       dfNone,    0,     true,       true);

                InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "s_lnk_cnst_seq",    false,  "",    dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtHidden,     10,    daCenter,  true,    "s_lane_vvd_chk",    false,          "",      dfNone,    0,     true,       true);
 
                InitDataCombo(0, "s_trsp_mod_cd", ' |'+trsp_mod_cdText, 'AL|'+trsp_mod_cdCode);
                InitDataCombo (0, "s_svc_use_flg", " |Y|N", " |Y|N");
                InitDataCombo (0, "s_cntr_tp_cd", " |R2|R5|Tank|D2|D4|D5|D7|FR/OT", " |R2|R5|T|D2|D4|D5|D7|S");
                InitDataCombo(0, "s_lnk_cnst_itm_cd", ' |'+cnst_cdText, ' |'+cnst_cdCode);
                
                ImageList(0) = "/hanjin/img/alps/button/btns_calendar.gif";
                PopupButtonImage(0, "s_eff_fm_dt") = 0;
                PopupButtonImage(0, "s_eff_to_dt") = 0;
                
                CellBackColor(1,3) = RgbColor(222, 251, 248);   // ENIS
                CellBackColor(1,4) = CellBackColor(1,3);
                CellBackColor(1,10) = CellBackColor(1,3);
                CellBackColor(1,11) = CellBackColor(1,3);

                HeadRowHeight = 21 ;
                HeadRowHeight = 20 ;

				InitDataValid(0, "s_lnk_org_nod_cd",  vtEngUpOther, "1234567890");
				InitDataValid(0, "s_lnk_dest_nod_cd", vtEngUpOther, "1234567890");
				InitDataValid(0, "s_vsl_slan_cd",     vtEngUpOther, "1234567890");
				InitDataValid(0, "s_vvd",             vtEngUpOther, "1234567890");
				InitDataValid(0, "s_cmdt_cd",         vtEngUpOther, "1234567890");
           }
           break;
            
        case 3:      //sheet3 init - Route Constraint(Default)
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(16) ;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(30, 0, 0, true); 

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle1 = "SEQ|ROW_NUM|Del.|STS|T.LANE|BD|POL/NODE|POL/NODE|LANE|1st T/S|1st T/S|2nd T/S|2nd T/S|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|VVD|CNTR TYPE|Commodity|Commodity|SVC|REMARKS|Creation\nDate|Creation\nOFC|Creation\nID|Update\nDate|Update\nOFC|Update\nID";
                var HeadTitle2 = "SEQ|ROW_NUM|Del.|STS|T.LANE|BD|LOC|NODE|LANE|Port|Lane|Port|Lane|Loc.|Node|Loc.|Node|VVD|CNTR TYPE|Code|Name|SVC|REMARKS|Creation\nDate|Creation\nOFC|Creation\nID|Update\nDate|Update\nOFC|Update\nID";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtSeq,        30,    daCenter,  true,    "Seq");
                InitDataProperty(0, cnt++, dtDataSeq,     0,    daCenter,  true,    "s_row_num",         false);
                InitDataProperty(0, cnt++, dtDelCheck,   40,    daCenter,  true,    "s_delchk",          false,  "",       dfNone,    0,     true,       true, -1, false, true, "", true);
                InitDataProperty(0, cnt++, dtStatus,     30,    daCenter,  true,    "s_ibflag");
                InitDataProperty(0, cnt++, dtPopupEdit , 60,    daCenter,  true,    "s_trnk_lane_cd",    true,   "",       dfNone,    0,     false,       true,3);
                InitDataProperty(0, cnt++, dtCombo ,     60,    daCenter,  true,    "s_dir_cd",          false,  "",       dfNone,    0,     false,       true,3);
                
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_pol_cd",          true,   "",       dfNone,    0,     false,       true,5);
                InitDataProperty(0, cnt++, dtData,       30,    daCenter,  true,    "s_pol_nod_cd",      false,  "",       dfNone,    0,     false,       true,5);
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_n1st_lane_cd",    false,  "",       dfNone,    0,     false,       true,3);
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_n1st_ts_port_cd", false,  "",       dfNone,    0,     false,       true,5);
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_n2nd_lane_cd",    false,  "",       dfNone,    0,     false,       true,3);
                
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_n2nd_ts_port_cd", false,  "",       dfNone,    0,     false,       true,5);
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_n3rd_lane_cd",    false,  "",       dfNone,    0,     false,       true,3);
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_pod_cd",          true,   "",       dfNone,    0,     false,       true,5);
                InitDataProperty(0, cnt++, dtData,       30,    daCenter,  true,    "s_pod_nod_cd",      false,  "",       dfNone,    0,     false,       true,2);
                InitDataProperty(0, cnt++, dtPopupEdit,  50,    daCenter,  true,    "s_del_cd",          false,  "",       dfNone,    0,     false,       true,5);
                
                InitDataProperty(0, cnt++, dtData,       30,    daCenter,  true,    "s_del_nod_cd",      false,  "",       dfNone,    0,     false,       true,2);
                InitDataProperty(0, cnt++, dtPopupEdit,  85,    daCenter,  true,    "s_vvd",             false,  "",       dfNone,    0,     true,        true,9);
                InitDataProperty(0, cnt++, dtCombo,      80,    daCenter,  true,    "s_cntr_tp_cd",      false,  "",       dfNone,    0,     true,        true);
                InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "s_cmdt_cd",         false,  "",       dfNone,    0,     false,       true,6);
                InitDataProperty(0, cnt++, dtData ,      80,    daLeft,    true,    "s_cmdt_nm",         false,  "",       dfNone,    0,     false,       false );
                
                InitDataProperty(0, cnt++, dtCombo,      45,    daCenter,  true,    "s_svc_use_flg",     true,   "",       dfNone,    0,     true,        true);
                InitDataProperty(0, cnt++, dtData,       400,   daLeft,    true,    "s_rout_cnst_rmk",   true,   "",       dfNone,    0,     true,        true, 1000);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_dt",          false,  "",       dfDateYmd, 0,     false,       false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_ofc_cd",      false,  "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_cre_usr_id",      false,  "",       dfNone,    0,     false,       false);
                
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_dt",          false,  "",       dfDateYmd, 0,     false,       false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_ofc_cd",      false,  "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "s_upd_usr_id",      false,  "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "s_rout_cnst_seq",   false,  "",       dfNone,    0,     false,       true);

                InitDataCombo (0, "s_svc_use_flg", " |Y|N", " |Y|N");
                InitDataCombo (0, "s_dir_cd", " |E|W|N|S", " |E|W|N|S");
                RangeBackColor(1, 8, 1, 11) = RgbColor(222, 251, 248);   // ENIS

                InitDataCombo (0, "s_cntr_tp_cd", " |R2|R5|Tank|D2|D4|D5|D7|FR/OT", " |R2|R5|T|D2|D4|D5|D7|S");
                
                HeadRowHeight = 21 ;
                HeadRowHeight = 20 ;
                

				InitDataValid(0, "s_trnk_lane_cd",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_pol_cd",         vtEngUpOther, "1234567890");
				InitDataValid(0, "s_pol_nod_cd",     vtEngUpOther, "1234567890");
				InitDataValid(0, "s_n1st_lane_cd",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_n1st_ts_port_cd",vtEngUpOther, "1234567890");
				InitDataValid(0, "s_n2nd_lane_cd",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_n2nd_ts_port_cd",vtEngUpOther, "1234567890");
				InitDataValid(0, "s_n3rd_lane_cd",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_pod_cd",         vtEngUpOther, "1234567890");
				InitDataValid(0, "s_pod_nod_cd",     vtEngUpOther, "1234567890");
				InitDataValid(0, "s_del_cd",         vtEngUpOther, "1234567890");
				InitDataValid(0, "s_del_nod_cd",     vtEngUpOther, "1234567890");
				InitDataValid(0, "s_vvd",            vtEngUpOther, "1234567890");
				InitDataValid(0, "s_cmdt_cd",        vtEngUpOther, "1234567890");
				
				sheetObj.ColHidden("s_row_num")=true;
            }
            break;
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
	    var uid ;
	    var sXml ;
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        case IBSEARCH:      //조회
          
            if(beforetab == 0){
		        formObj.f_cmd.value = SEARCH01;			     
            }else if(beforetab == 1){
		        formObj.f_cmd.value = SEARCH02;
    	    }else if(beforetab == 2){
	            formObj.f_cmd.value = SEARCH03;
    	    }
            var aryPrefix = new Array("s_");
			sheetObj.DoSearch4Post("ESD_PRD_0024GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
            break;
    	 

        case IBSAVE:        //저장
            if(!validateForm(sheetObj,formObj,sAction)) { return; }
            // 필수 항목 체크 
            if(!keyFieldCheck(sheetObj)) {return;}
            
            if(beforetab == 0)
		        formObj.f_cmd.value = MULTI01;
		    else if(beforetab == 1)
		        formObj.f_cmd.value = MULTI02;
	        else if(beforetab == 2) {
	        	if(!doActionIBSheet(sheetObj,formObj, COMMAND03))
	        		return;
	    		
	            sheetObj.ShowDebugMsg = false;
	            formObj.f_cmd.value = MULTI03;
	        }
			sheetObj.DoSave("ESD_PRD_0024GS.do", PrdFQString(formObj));
            break;
            
        case IBDOWNEXCEL:        //엑셀 다운로드
            sheetObj.Down2Excel(-1, false, false, true);
            break;

        case IBLOADEXCEL:        //엑셀 업로드
            sheetObj.LoadExcel();
            break;
       
        case SEARCH01:          // Port Check
            formObj.f_cmd.value = SEARCH01;
          
            uid= "ESD_PRD_024";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
          
            sheetObj.LoadSearchXml(sXml,true, -1, true);
            retValidate = sheetObj.EtcData("rowCount");
            break;
          
        case SEARCH02:         // Location Check
            formObj.f_cmd.value = SEARCH02;
     
            uid= "ESD_PRD_024";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
          
            sheetObj.LoadSearchXml(sXml,true, -1, true);     
            retValidate = sheetObj.EtcData("rowCount");
            break;
          
        case SEARCH07:         // Lane Check
            formObj.f_cmd.value = SEARCH07;
            uid= "ESD_PRD_024";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
          
            sheetObj.LoadSearchXml(sXml,true, -1, true);
            retValidate = sheetObj.EtcData("rowCount");
          
            break;
          
        case SEARCH04:        // Node Check
            formObj.f_cmd.value = SEARCH04;

            uid= "ESD_PRD_0024";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
          
            sheetObj.LoadSearchXml(sXml,true, -1, true);     
            retValidate = sheetObj.EtcData("rowCount");
            break;   

        case SEARCH05:        // Terminal Check
	        formObj.f_cmd.value = SEARCH05;
	
	        uid= "ESD_PRD_0024";
	        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
	      
	        sheetObj.LoadSearchXml(sXml,true, -1, true);     
	        retValidate = sheetObj.EtcData("rowCount");
	        break;   

        case SEARCH06:        // Country Check
            formObj.f_cmd.value = SEARCH06;

            uid= "ESD_PRD_0024";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
          
            sheetObj.LoadSearchXml(sXml,true, -1, true);     
            retValidate = sheetObj.EtcData("rowCount");
            break;

        case SEARCH09:        // Location Check
	        formObj.f_cmd.value = SEARCH02;
	
	        uid= "ESD_PRD_0024";
	        sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
	      
	        sheetObj.LoadSearchXml(sXml,true, -1, true);     
	        retValidate = sheetObj.EtcData("rowCount");
	        break;
	        
        case COMMAND03:
        	formObj.f_cmd.value = COMMAND03;
    		
        	var sParam = sheetObj.GetSaveString(false, true, "s_ibflag");
        	
        	if(sParam == null || sParam == "")
        		return false;
        	
        	sParam = "f_cmd=" + COMMAND03 + "&" + sParam;
        	var sXml = sheetObj.GetSaveXml("ESD_PRD_0024GS.do", sParam);
        	var row_num = ComGetEtcData(sXml, "rowNum");
        	row_num = parseInt(row_num, 10) + 1;
        	
    		var chk_field = ComGetEtcData(sXml, "checkField").split("|");
    		if(typeof chk_field != "undefined" && chk_field != "") {
				for(var i=0 ; i < chk_field.length ; i++ ) {
					if(chk_field[i] != "") {
			    		sheetObj.CellValue2(row_num, chk_field[i]) = "";
		    		}
				}
				ComShowMessage(ComGetMsg('PRD90139'));
				sheetObj.SelectCell(row_num, chk_field[0]);
				return false;
  			}
    		
    		return true;
        }
    }

    function keyFieldCheck(sheetObj) {
        
        var i = 1;
        var cnt = i+sheetObj.RowCount;
        var sheetID = sheetObj.id;
        var colNmCnstItmCd = "";
        if (sheetID = "sheet1") {
        	colNmCnstItmCd = "s_nod_cnst_itm_cd";
        } else if (sheetID = "sheet2") {
        	colNmCnstItmCd = "s_lnk_cnst_itm_cd";
        } else {
        	return true;
        }

        for( i=1; i<=cnt; i++) {
            
            // Constraint Item 이 R/F, D5, D7, F/T, O/T 인 경우, CNTR Type 은 필수항목.
            if(sheetObj.CellValue(i,colNmCnstItmCd)== "R" || sheetObj.CellValue(i,colNmCnstItmCd)== "F" ||
                sheetObj.CellValue(i,colNmCnstItmCd)== "S"  ){
                if( sheetObj.CellValue(i,"s_cntr_tp_cd").length != 1 ){
                    //ComShowMessage('Please select the \'CNTR TYPE\'!! - ROW[' + (i-1) + ']');
                	ComShowMessage(ComGetMsg('PRD90056',(i-1)));
                    sheetObj.SelectCell(i, "s_cntr_tp_cd");
                    return false;                    
                }

            } else if(sheetObj.CellValue(i,colNmCnstItmCd)== "5" || sheetObj.CellValue(i,colNmCnstItmCd)== "7" ) {
                if( sheetObj.CellValue(i,"s_cntr_tp_cd").length != 2 ){
                    ComShowMessage(ComGetMsg('PRD90056',(i-1)));
                    sheetObj.SelectCell(i, "s_cntr_tp_cd");
                    return false;                    
                }
            //} else if(sheetObj.CellValue(i, "s_date_diff") > 365) {
            //    ComShowMessage(ComGetMsg('PRD90057'));
            //    sheetObj.SelectCell(i, "s_eff_to_dt");
            //    return false;
            }
            
			var matchedFlag = false;
            if(sheetObj.CellValue(i, colNmCnstItmCd) == "R" && sheetObj.CellValue(i,"s_cntr_tp_cd") != "R"){
				matchedFlag = true;
    	    } else if(sheetObj.CellValue(i, colNmCnstItmCd) == "2" && sheetObj.CellValue(i,"s_cntr_tp_cd") != "D2") {
				matchedFlag = true;
    	    } else if(sheetObj.CellValue(i, colNmCnstItmCd) == "4" && sheetObj.CellValue(i,"s_cntr_tp_cd") != "D4") {
				matchedFlag = true;
    	    } else if(sheetObj.CellValue(i, colNmCnstItmCd) == "5" && sheetObj.CellValue(i,"s_cntr_tp_cd") != "D5") {
				matchedFlag = true;
    	    }  else if(sheetObj.CellValue(i, colNmCnstItmCd) == "7" && sheetObj.CellValue(i,"s_cntr_tp_cd") != "D7") {
				matchedFlag = true;
    	    }  else if(sheetObj.CellValue(i, colNmCnstItmCd) == "S" && sheetObj.CellValue(i,"s_cntr_tp_cd") != "S") {
				matchedFlag = true;
    	    }

			if(matchedFlag){
                ComShowMessage(ComGetMsg('PRD90058'));
                sheetObj.SelectCell(i, colNmCnstItmCd);
                return false;
			}
               
        }
        return true;
    }
    
    // 
    function sheet1_OnPopupClick(sheetObj, row, col){	
    	var colName = sheetObj.ColSaveName(col);
    	var cal ;
    	var param ;
    	    	
		if(!fnCreOfcCheck(sheetObj,row)) {
			return false;
		}
		if(colName == "s_eff_fm_dt"){
			cal = new ComCalendarGrid();
			cal.select( sheetObj,  row, col , "yyyyMMdd");
		}
		
		if (colName == "s_vsl_slan_cd") {
        	var slan_cd_val = sheetObj.CellValue(row, col);
            param = '?&lane_cd='+slan_cd_val;
            ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1",true,false ,row, col,0);

		}

		if(colName == "s_eff_to_dt"){
			cal = new ComCalendarGrid();
			cal.select( sheetObj,  row, col , "yyyyMMdd");
		}
		
		
		//Node popUp
		if ( colName == "s_nod_cd"  )
        {
			var loc_cd_val = sheetObj.CellValue(row, col);
    	     if (colName == "s_nod_cd" && sheetObj.RowStatus(row) == "I" && sheetObj.CellValue(row, "s_nod_cd") =='ALL') {
				 loc_cd_val  ="";
			 }
    	    param = '?node_cd='+loc_cd_val;
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true,false,row, col,0);

        }
		//Commodity popUp
		if ( colName == "s_cmdt_cd"  )
        {
            var cmdt_cd = sheetObj.CellValue(row, col);
    	    param = '?cmdt_cd='+cmdt_cd;
    	    ComOpenPopup('/hanjin/COM_ENS_011.do' + param , 770, 470, 'getCommodity', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);

        }
		if ( colName == "s_vvd" ) {
			var param = '?vvd_cd=' + sheetObj.CellValue(row, col) + "&lane_cd=" + sheetObj.CellValue(row, "s_vsl_slan_cd") ;
			ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1', true, false, row, col, 0);
		}
		if ( colName == "s_cnst_cst_expt" ) {
			if (sheetObj.CellValue(row, "s_ibflag") != 'I') {
				var param = '?p_nod_cd=' + sheetObj.CellValue(row, "s_nod_cd") + "&p_nod_cnst_itm_cd=" + sheetObj.CellValue(row, "s_nod_cnst_itm_cd") + "&p_nod_cnst_seq=" + sheetObj.CellValue(row, "s_nod_cnst_seq") + "&p_cnst_cst_expt=" + sheetObj.CellValue(row, "s_cnst_cst_expt") ;
				ComOpenPopup('/hanjin/ESD_PRD_0025.do'+ param, 770, 375, '', '1,0,1,1,1,1,1,1', true, false, row, col, 0);
			} else {
				ComShowMessage(ComGetMsg('PRD90149'));
				return false;
			}
		}

	}
	
	function sheet2_OnPopupClick(sheetObj, row, col){	
		var colName = sheetObj.ColSaveName(col);
		var cal ;
		var param ;
		
		if(!fnCreOfcCheck(sheetObj,row)) {
			return false;
		}
		
		if(colName == "s_eff_fm_dt"){
			cal = new ComCalendarGrid();
			cal.select( sheetObj,  row, col , "yyyyMMdd");
		}
		if(colName == "s_eff_to_dt"){
			cal = new ComCalendarGrid();
			cal.select( sheetObj,  row, col , "yyyyMMdd");
		}

//		if ( colName == "s_eff_fm_dt" ){
//			cal = new ComCalendarGrid();
//			cal.select( sheetObj, row, col , "yyyyMMdd");
//		}else if ( colName == "s_eff_to_dt" ){
//			cal = new ComCalendarGrid();
//			cal.select( sheetObj, row, col , "yyyyMMdd");
//		}
		
		//Node popUp
		if ( colName == "s_lnk_org_nod_cd" || colName == "s_lnk_dest_nod_cd" )
        {
            var loc_cd_val = sheetObj.CellValue(row, col);
    	    param = '?node_cd='+loc_cd_val;
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1",true,false ,row, col,0);

        }
		//Commodity popUp
		if ( colName == "s_cmdt_cd"  )
        {
            var cmdt_cd = sheetObj.CellValue(row, col);
    	    param = '?cmdt_cd='+cmdt_cd;
            ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 770, 470, 'getCommodity', "1,0,1,1,1,1,1,1,1,1,1,1",true,false, row, col,0);

        }
		if (colName == "s_vsl_slan_cd") {
        	var slan_cd_val = sheetObj.CellValue(row, col);
            param = '?&lane_cd='+slan_cd_val;
            ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1",true,false ,row, col,0);

		}
		if ( colName == "s_vvd" ) {
			var param = '?vvd_cd=' + sheetObj.CellValue(row, col) + "&lane_cd=" + sheetObj.CellValue(row, "s_vsl_slan_cd") ;
			ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1', true, false, row, col, 0);
		}
	}
	
	
    function sheet3_OnPopupClick(sheetObj, row, col)
    {
    	var colName = sheetObj.ColSaveName(col);
        var param = '';
        var slan_cd_val = '';
        var port_cd = '';
        
        if ( colName == "s_trnk_lane_cd" || colName == "s_n1st_lane_cd" ||
             colName == "s_n2nd_lane_cd" || colName == "s_n3rd_lane_cd" )
        {
        	
        	slan_cd_val = sheetObj.CellValue(row, col);
        	
            param = '?&lane_cd='+slan_cd_val;

            ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1",true,false ,row, col,0);
        } else if ( colName == "s_pol_cd"  || colName == "s_pod_cd" || colName == "s_del_cd" )
        {
            port_cd = sheetObj.CellValue(row, col);
            param = '?loc_cd='+port_cd;

            //node 정보 
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode2', "1,0,1,1,1,1,1,1,1,1,1,1",true,false ,row, col,0);
            
        } else if(colName == "s_n1st_ts_port_cd" ||  colName == "s_n2nd_ts_port_cd") {
            port_cd = sheetObj.CellValue(row, col);
            param = '?loc_cd='+port_cd;
            //loc 정보 
            ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLoc', '1,0,1,1,1,1,1,1,1,1,1,1',true,false,row, col,0);
        }
        
		//Commodity popUp
		if ( colName == "s_cmdt_cd"  )
        {
            var cmdt_cd = sheetObj.CellValue(row, col);
    	    param = '?cmdt_cd='+cmdt_cd;
    	    ComOpenPopup('/hanjin/COM_ENS_011.do' + param , 770, 470, 'getCommodity', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);

        }
		if ( colName == "s_vvd" ) {
			var param = '?vvd_cd=' + sheetObj.CellValue(row, col);;
			ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1', true, false, row, col, 0);
		}
    }

    function fnMgrOfcChk(sheetObj, Row, colName, chkValue, clsValue) {
    	if(sheetObj.CellValue(Row, colName) == chkValue){
			if(CRUD != 'S'){
			   ComShowMessage(ComGetMsg('PRD90118'));
    		   sheetObj.CellValue2(Row, colName) =clsValue;
    		   return false;
    		 }
		}
    	return true;
    }
    
//    function sheet1_OnClick(sheetObj,Row,Col,Value) {
//    	alert(Row + "***" + Col);
//    }
    // Node Constraint Item Name 가져오기.
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	var colName = sheetObj.ColSaveName(Col);
    	// delchk의 경우 예외 처리 (Insert Row의 경우 먼저 삭제되고 event생긴다.
    	if (colName == "s_delchk") {
    		if(sheetObj.CellValue(Row,colName) == undefined || sheetObj.CellValue(Row,colName) == 0) { return; }
    	}
        // Create Office가 아닐 경우 Old Data로 복구하고 종료한다.
    	if (!fnCreOfcCheck(sheetObj, Row)) {
    		ComShowMessage(ComGetMsg('PRD90130'));
    		sheetObj.CellValue2(Row, "s_delchk") = 0;
    		sheetObj.ReturnCellData(Row,"s_nod_cnst_itm_cd");
    		sheetObj.ReturnCellData(Row,"s_vsl_slan_cd");
    		sheetObj.ReturnCellData(Row,"s_vvd");
    		sheetObj.ReturnCellData(Row,"s_cntr_tp_cd");
    		sheetObj.ReturnCellData(Row,"s_svc_use_flg");
    		sheetObj.ReturnCellData(Row,"s_nod_cnst_rmk");
    		sheetObj.ReturnCellData(Row,"s_eff_fm_dt");
    		sheetObj.ReturnCellData(Row,"s_eff_to_dt");
    		return;
    	}
    	
    	validateData = sheetObj.CellValue(Row, colName);
    	
        //각각 배열로 구성한다.
        var arrText = cnst_cdText.split("|");
        var arrCode = cnst_cdCode.split("|");
  
        if(sheetObj.CellValue(Row, "s_item_name") == "") {
        	sheetObj.CellValue2(Row, "s_item_name") = arrText[0];
        }
        
    	if(colName=="s_nod_cnst_itm_cd" ) {
    		var idx   = sheetObj.GetComboInfo(Row,Col, "SelectedIndex");
            sheetObj.CellValue2(Row, "s_item_name") = arrText[idx];  
		            
     	    if(Value == "A"){ //R2 :A 선택  ( R5:B) 
    	        sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R2";
            } else if(Value == "B") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R5";
            } else if(Value == "2") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D2";
            } else if(Value == "4") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D4";
            } else if(Value == "5") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D5";
            } else if(Value == "7") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D7"; 
            } else if(Value == "S") { // F/R, O/T Constraint -> S 선택.
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "S";
    	    } else if(Value == "N") { // No Service -> Service Flag - Default : 'N'
    	        sheetObj.CellValue2(Row, "s_svc_use_flg") = "N";
    	    }
    	}else if(colName == "s_nod_cd") {
    	    validateData = Value.toUpperCase();
    	    
    	    if (!fnMgrOfcChk(sheetObj, Row,"s_nod_cd", "ALL", "")) {
    	    	return false;
    	    }
    	    
    	    if(Value.length != 2 &&  sheetObj.CellValue(Row, "s_nod_cd") != "ALL" && Value.length != 5 && Value.length != 7) {
               ComShowMessage(ComGetMsg('PRD90059'));
               sheetObj.SelectCell(Row, "s_nod_cd");
                return false;
            }
            else if(Value.length == 2)
               doActionIBSheet(sheetObj,document.form,SEARCH06);
            else if(Value.length == 5) 
               doActionIBSheet(sheetObj,document.form,SEARCH02);
            else if(Value.length == 7)
               doActionIBSheet(sheetObj,document.form,SEARCH04);
            if(retValidate == "" || retValidate < 1) {   
            	sheetObj.SelectCell(Row, "s_nod_cd");
                return false;
            }
            
           
    	} else if(colName == "s_cntr_tp_cd") {    		
			var matchedFlag = true;
			var cnstItmCd = sheetObj.CellValue(Row, "s_nod_cnst_itm_cd");
            if(cnstItmCd == "A" && Value != "R2"){
            	matchedFlag = false;
            	sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R2";
     	    } else if(cnstItmCd == "B" && Value != "R5") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R5";
    	    } else if(cnstItmCd == "2" && Value != "D2") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D2";
    	    } else if(cnstItmCd == "4" && Value != "D4") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D4";
    	    } else if(cnstItmCd == "5" && Value != "D5") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D5";
    	    } else if(cnstItmCd == "7" && Value != "D7") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D7";
    	    } else if(cnstItmCd == "S" && Value != "S") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "S";
    	    }
			if(!matchedFlag){
	            ComShowMessage(ComGetMsg('PRD90058'));
	            sheetObj.SelectCell(Row, "s_cntr_tp_cd");
                return false;  
			}
					
    	} else if(colName == "s_cmdt_cd") {
    		var cmdtVal = sheetObj.CellValue(Row,Col);
    		if (cmdtVal == "") {
    			sheetObj.CellValue2(Row, "s_cmdt_nm") = "";
    		} else {
	    		cmdtVal = ComLpad(cmdtVal,6,"0");
	    		sheetObj.CellValue2(Row,Col) = cmdtVal;
	    		fnObjCmdtCd(sheetObj, Row, Col, cmdtVal);
    		}
    	}
    	
    	if(colName == "s_vsl_slan_cd" && Value.length > 0) {
    		doActionIBSheet(sheetObj,document.form,SEARCH07);
    		if(retValidate == "" || retValidate < 1) {   
            	sheetObj.SelectCell(Row, "s_vsl_slan_cd");
                return false;
            }
    	}
    	
    	// lane / vvd가 모두 적합한지 검사 CHM-201216170 Network Constraint 기능보완
    	if(colName == "s_vsl_slan_cd" || colName == "s_vvd") {
    		var vslSlanCd = sheetObj.CellValue(Row,"s_vsl_slan_cd");
    		var vvd = sheetObj.CellValue(Row, "s_vvd");
    		if (vslSlanCd.length > 0 && vvd.length > 0) {
    			var formObj = document.form;
    			formObj.f_cmd.value = SEARCH12;
    			var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=ESD_PRD_0024&lane_code=" + vslSlanCd + "&vvd=" + vvd+ "&" +PrdFQString(formObj));
    			sheetObj.LoadSearchXml(sXml,true, -1, true); 
    		    if( sheetObj.EtcData("comData1") == "N") {
    		    	ComShowCodeMessage('PRD90133');
        			sheetObj.CellValue2(Row, "s_lane_vvd_chk") = "N";
    		    	sheetObj.SelectCell(Row, "s_vvd");
    		    	return;
    		    } else {
    		    	sheetObj.CellValue2(Row, "s_lane_vvd_chk") = "Y";
    		    }
    		}
    	} 

    	if(colName == "s_vvd") {
    		var pointOfPortCd = sheetObj.CellValue(Row,"s_port_pnt_cd");
    		if (Value.length > 0 && pointOfPortCd != "ALL" && pointOfPortCd != "POL" 
    			&& pointOfPortCd != "TS" && pointOfPortCd != "POD")
    		{
    			ComShowCodeMessage("PRD90134");
    			sheetObj.SelectCell(Row, "s_vvd");
    			return;
    		}
    	}
        
    	
    }
    	
    	
    	
    function sheet1_OnSaveEnd(sheetObj, errMsg){
    	if (errMsg != "Saved data successfully.") { return; }
    	var formObject = document.form;
    	doActionIBSheet(sheetObj,formObject,IBSEARCH);
    }

//     주석처리 요망 2011.11.15 박만건 수석님 요청
//    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
//    {
//        if(CRUD != "S") {
//        	for(i=0 ; i <sheetObj.RowCount+2 ; i++){
//        		if(sheetObj.CellValue(i, "s_nod_cd") == "ALL"){
//        		   sheetObj.RowEditable(i) ="false";
//        		}
//            }
//        	
//        }
//    }  
    
    function sheet1_OnLoadExcel(sheetObj,ErrMsg){
    	// Load 된 엑셀 파일 데이터 중 node 값이 ALL인 데이터를 삭제를 한다.
    	// S 권한을 가지지 않는 유저만 일때 가능
    	var totalRow = sheetObj.RowCount; 
    	var count = 0;
    	
    	// Excel에서 값이 없는 데이타를 제거한다.
    	for(i=totalRow+1 ; i > 1 ; i--){
			if(sheetObj.CellValue(i, "s_nod_cd") == ""){
				sheetObj.RowDelete(i ,false);
			}
		}
    	
    	totalRow = sheetObj.RowCount;
    	if(CRUD != "S") {
    		for(i=totalRow+1 ; i > 1 ; i--){
    			if(sheetObj.CellValue(i, "s_nod_cd") == "ALL"){
    				sheetObj.RowDelete(i ,false);
    				count = count + 1;
    			}
    		}
    		
    		if (count >0) {	
    			ComShowMessage(ComGetMsg('PRD90118'));
    		}
    	}
    }
    
    
    function sheet2_OnSaveEnd(sheetObj, errMsg){
    	if (errMsg != "Saved data successfully.") { return; }
    	var formObject = document.form;
    	doActionIBSheet(sheetObj,formObject,IBSEARCH);
    }
    
    function sheet3_OnSaveEnd(sheetObj, errMsg){
    	if (errMsg != "Saved data successfully.") { return; }
    	var formObject = document.form;
    	doActionIBSheet(sheetObj,formObject,IBSEARCH);
    	
    }
    
    function sheet3_OnSearchEnd(sheetObj,ErrMsg)
    {
    	if(document.form.f_cmd.value != SEARCH03) {
    		retValidate = sheetObj.EtcData("rowCount");
    	}

    	if(CRUD != "S") {
        	for(i=0 ; i <sheetObj.RowCount+2 ; i++){
        		if(sheetObj.CellValue(i, "s_trnk_lane_cd") == "ALL"){
        		   sheetObj.RowEditable(i) ="false";	
        		}
            }
        	
        }
    } 
    
    function sheet3_OnLoadExcel(sheetObj,ErrMsg){
    	var formObj = document.form;
    	var totalRow = sheetObj.RowCount; 
    	var count = 0;
    	
    	// Excel에서 값이 없는 데이타를 제거한다.
    	for(i=totalRow+1 ; i > 1 ; i--){
			if(sheetObj.CellValue(i, "s_trnk_lane_cd") == ""){
				sheetObj.RowDelete(i ,false);
			}
		}
    	
    	totalRow = sheetObj.RowCount;
    	if(CRUD != "S") {
    		for(i=totalRow+1 ; i > 1 ; i--){
    			if(sheetObj.CellValue(i, "s_trnk_lane_cd") == "ALL"){
    				sheetObj.RowDelete(i ,false);
    				count = count + 1;
    			}
    		}
    		
    		if (count >0) {
    			ComShowMessage(ComGetMsg('PRD90118'));
    		}
    	}
    }
    
    // Link Constraint Item Name 가져오기.
    function sheet2_OnChange(sheetObj,Row,Col,Value) {
    	var colName = sheetObj.ColSaveName(Col);
    	// delchk의 경우 예외 처리 (Insert Row의 경우 먼저 삭제되고 event생긴다.
    	if (colName == "s_delchk") {
    		if(sheetObj.CellValue(Row,colName) == undefined || sheetObj.CellValue(Row,colName) == 0) { return; }
    	}
        // Create Office가 아닐 경우 Old Data로 복구하고 종료한다.
    	if (!fnCreOfcCheck(sheetObj, Row)) {
    		ComShowMessage(ComGetMsg('PRD90130'));
    		sheetObj.CellValue2(Row, "s_delchk") = 0;
    		sheetObj.ReturnCellData(Row,"s_lnk_cnst_itm_cd");
    		sheetObj.ReturnCellData(Row,"s_vsl_slan_cd");
    		sheetObj.ReturnCellData(Row,"s_vvd");
    		sheetObj.ReturnCellData(Row,"s_cntr_tp_cd");
    		sheetObj.ReturnCellData(Row,"s_svc_use_flg");
    		sheetObj.ReturnCellData(Row,"s_nod_cnst_rmk");
    		sheetObj.ReturnCellData(Row,"s_eff_fm_dt");
    		sheetObj.ReturnCellData(Row,"s_eff_to_dt");
    		return;
    	}
    	
    	validateData = sheetObj.CellValue(Row, colName);
    	
    	//각각 배열로 구성한다.
        var arrText = cnst_cdText.split("|");
        var arrCode = cnst_cdCode.split("|");

        if(sheetObj.CellValue(Row, "s_item_name") == "")
         sheetObj.CellValue2(Row, "s_item_name") = arrText[0];
    
    	if(colName=="s_lnk_cnst_itm_cd" ) { 			
    		var idx   = sheetObj.GetComboInfo(Row,Col, "SelectedIndex");
            sheetObj.CellValue2(Row, "s_item_name") = arrText[idx];  
		            
     	    if(Value == "A"){ //R2 :A 선택  ( R5:B) 
    	        sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R2";
            } else if(Value == "B") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R5";
            } else if(Value == "2") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D2";
            } else if(Value == "4") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D4";
            } else if(Value == "5") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D5";
            } else if(Value == "7") {
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D7"; 
            } else if(Value == "S") { // F/R, O/T Constraint -> S 선택.
                sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "S";
    	    } else if(Value == "N") { // No Service -> Service Flag - Default : 'N'
    	        sheetObj.CellValue2(Row, "s_svc_use_flg") = "N";
    	    }
    	}  else if(colName == "s_lnk_org_nod_cd" || colName == "s_lnk_dest_nod_cd") {
    	    validateData = Value.toUpperCase();
    	}  else if(colName == "s_cntr_tp_cd") {  	
			var matchedFlag = true;
			var cnstItmCd = sheetObj.CellValue(Row, "s_lnk_cnst_itm_cd");
            if(cnstItmCd == "A" && Value != "R2"){
            	matchedFlag = false;
            	sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R2";
     	    } else if(cnstItmCd == "B" && Value != "R5") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "R5";
    	    } else if(cnstItmCd == "2" && Value != "D2") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D2";
    	    } else if(cnstItmCd == "4" && Value != "D4") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D4";
    	    } else if(cnstItmCd == "5" && Value != "D5") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D5";
    	    } else if(cnstItmCd == "7" && Value != "D7") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "D7";
    	    } else if(cnstItmCd == "S" && Value != "S") {
				matchedFlag = false;
				sheetObj.CellValue2(Row, "s_cntr_tp_cd") = "S";
    	    }
			if(!matchedFlag){
	            ComShowMessage(ComGetMsg('PRD90058'));
	            sheetObj.SelectCell(Row, "s_cntr_tp_cd");
                return false;  
			}
    	}else if(colName == "s_cmdt_cd") {
    		var cmdtVal = sheetObj.CellValue(Row,Col);
    		if (cmdtVal == "") {
    			sheetObj.CellValue2(Row, "s_cmdt_nm") = "";
    		} else {
	    		cmdtVal = ComLpad(cmdtVal,6,"0");
	    		sheetObj.CellValue2(Row,Col) = cmdtVal;
	    		fnObjCmdtCd(sheetObj, Row, Col, cmdtVal);
    		}
    	}
    	
    	if(colName == "s_vsl_slan_cd" && Value.length > 0) {
    		doActionIBSheet(sheetObj,document.form,SEARCH07);
    		if(retValidate == "" || retValidate < 1) {   
            	sheetObj.SelectCell(Row, "s_vsl_slan_cd");
                return false;
            }
    	}

    	// lane / vvd가 모두 적합한지 검사 CHM-201216170 Network Constraint 기능보완
    	if(colName == "s_vsl_slan_cd" || colName == "s_vvd") {
    		var vslSlanCd = sheetObj.CellValue(Row,"s_vsl_slan_cd");
    		var vvd = sheetObj.CellValue(Row, "s_vvd");
    		var trspModCd = sheetObj.CellValue(Row,"s_trsp_mod_cd");
    		if (Value.length > 0 && trspModCd != "AL" && trspModCd != "WD") {
    			ComShowCodeMessage("PRD90135");
		    	sheetObj.CellValue2(Row, "s_lane_vvd_chk") = "N";
    			sheetObj.SelectCell(Row, "s_vvd");
    			return;
    		}

    		if (vslSlanCd.length > 0 && vvd.length > 0) {
    			var formObj = document.form;
    			formObj.f_cmd.value = SEARCH12;
    			var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do", "uid=ESD_PRD_0024&lane_code=" + vslSlanCd + "&vvd=" + vvd+ "&" +PrdFQString(formObj));
    			sheetObj.LoadSearchXml(sXml,true, -1, true);     
    		    if( sheetObj.EtcData("comData1") == "N") {
    		    	ComShowCodeMessage('PRD90133');
    		    	sheetObj.CellValue2(Row, "s_lane_vvd_chk") = "N";
    		    	sheetObj.SelectCell(Row, "s_vvd");
    		    	return;
    		    } else {
    		    	sheetObj.CellValue2(Row, "s_lane_vvd_chk") = "Y";
    		    }
    		}
    	} 

    }
    
    /**
     * Sheet에서 Commodity Code값에 해당하는 Commodity Name을 가져와서 설정한다.
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function fnObjCmdtCd(sheetObj, Row, Col, Value) {
    	sheetObj.ShowDebugMsg = false;
    	var sXml = sheetObj.GetSearchXml("ESD_PRD_0024GS.do", "f_cmd="+SEARCH11+"&cmdt_cd="+Value+"&row="+Row+"&col="+Col ) ;
	    var arrXml = sXml.split("|$$|");
	    var cmdtCd = ComGetEtcData(arrXml[0], "cmdt_cd");
	    if (cmdtCd == undefined || cmdtCd == "") {
	    	ComShowMessage(ComGetMsg('PRD90055'));
	    	sheetObj.CellValue2(Row, "s_cmdt_cd") = "";
	    	sheetObj.CellValue2(Row, "s_cmdt_nm") = "";
	    	sheetObj.SelectCell(Row, "s_cmdt_cd");
	        return false;
	    } else {
	    	sheetObj.CellValue2(Row, "s_cmdt_cd") = cmdtCd;
	    	sheetObj.CellValue2(Row, "s_cmdt_nm") = ComGetEtcData(arrXml[0], "cmdt_nm");
	    	return true;
	    }
    }
    
     /**
     * Port (Location Code)를 검사한다.
     * @param sheetObj
     * @param Row
     * @param colName
     * @param Value
     * @return
     */
    function fnChkPortCode(sheetObj, Row, colName, Value) {
    	var sheetId = sheetObj.id;
    	validateData = Value.toUpperCase();
    	
    	if(sheetId == "sheet3") {
	    	if(Value.length == 0) {
	    		return true;
	    	} else if( Value.length == 5 ) {
	    		doActionIBSheet(sheetObj,document.form,SEARCH01);
	            if(retValidate == "" || retValidate < 1) { 
	            	sheetObj.CellValue2(Row, colName) = "";
	            	sheetObj.SelectCell(Row, colName);
	                return false;
	        	}
	    	} else if( Value.length == 3 && (colName == "s_pol_cd" || colName == "s_pod_cd")) {
	    		if(Value == "ALL") return true;
	    		else {
	    			sheetObj.CellValue2(Row, colName) = "";
	            	sheetObj.SelectCell(Row, colName);
	                return false;
	    		}
	    	} else if( Value.length == 2 && (colName == "s_pol_cd" || colName == "s_pod_cd")) {
	    		return true;
	    	} else {
	            doActionIBSheet(sheetObj,document.form,SEARCH01);
	            if(retValidate == "" || retValidate < 1) { 
	            	sheetObj.CellValue2(Row, colName) = "";
	            	sheetObj.SelectCell(Row, colName);
	                return false;
	        	}
	    	}
    	}
    	else {
    		if(Value.length == 0) {
	    		return true;
	    	} else if( Value.length != 5 ) {
	    		ComShowMessage(ComGetMsg('PRD90060'));
	    		sheetObj.CellValue2(Row, colName) = "";
	            sheetObj.SelectCell(Row, colName);
	            return false;
	    	} else {
	            doActionIBSheet(sheetObj,document.form,SEARCH01);
	            if(retValidate == "" || retValidate < 1) { 
	            	sheetObj.CellValue2(Row, colName) = "";
	            	sheetObj.SelectCell(Row, colName);
	                return false;
	        	}
	    	}
    	}
    	return true;
    }

    /**
     * Node code가 유효한지 검사한다.
     * @param sheetObj
     * @param Row
     * @param colName
     * @param locValue
     * @param Value
     * @return
     */
    function fnChkNodeCode(sheetObj, Row, colName, locValue, Value) {
    	if(Value.length == 0) {
    		return true;
    	}if(Value.length != 2 ) {
    		ComShowMessage(ComGetMsg('PRD90139'));
    		sheetObj.CellValue2(Row, colName) = "";
            sheetObj.SelectCell(Row, colName);
            return false;
    	} else {
    	    validateData = locValue.toUpperCase() + Value.toUpperCase() ;    		
            doActionIBSheet(sheetObj,document.form,SEARCH04); 
            if(retValidate < 1) { 
            	sheetObj.CellValue2(Row, colName) = "";
            	sheetObj.SelectCell(Row, colName);
                return false;
        	}
    	}
    	return true;
    }

    function sheet3_OnChange(sheetObj, Row, Col, Value){
    	if(Value == "") return;
    	
    	var colName = sheetObj.ColSaveName(Col);
    	    	
    	// delchk의 경우 예외 처리 (Insert Row의 경우 먼저 삭제되고 event생긴다.
    	if (colName == "s_delchk") {
    		if(sheetObj.CellValue(Row,colName) == undefined || sheetObj.CellValue(Row,colName) == 0) { return; }
    	}
    	
        // Create Office가 아닐 경우 Old Data로 복구하고 종료한다.
    	if (!fnCreOfcCheck(sheetObj, Row)) {
    		ComShowMessage(ComGetMsg('PRD90130'));
    		sheetObj.CellValue2(Row, "s_delchk") = 0;
    		sheetObj.ReturnCellData(Row,"s_vvd");
    		sheetObj.ReturnCellData(Row,"s_cntr_tp_cd");
    		sheetObj.ReturnCellData(Row,"s_svc_use_flg");
    		sheetObj.ReturnCellData(Row,"s_nod_cnst_rmk");
    		return ;
    	}
    	
    	validateData = sheetObj.CellValue(Row, colName);
    	
	    if(colName == "s_cmdt_cd") {
    		var cmdtVal = sheetObj.CellValue(Row,Col);
    		if (cmdtVal == "") {
    			sheetObj.CellValue2(Row, "s_cmdt_nm") = "";
    		} else {
	    		cmdtVal = ComLpad(cmdtVal,6,"0");
	    		sheetObj.CellValue2(Row,Col) = cmdtVal;
	    		fnObjCmdtCd(sheetObj, Row, Col, cmdtVal);
    		}
	    }
        
        if(colName == "s_pol_cd" || colName == "s_n1st_ts_port_cd" || colName == "s_n2nd_ts_port_cd" || colName == "s_pod_cd") {
            if (!fnChkPortCode(sheetObj, Row, colName, Value)) { return false; }
        } else if(colName == "s_del_cd") {
        	
        	if( Value.length == 2) {  
        		return ; 
        	} else if(Value.length == 5){
            	doActionIBSheet(sheetObj,document.form,SEARCH09);
            	if(retValidate < 1) { 
        	    	sheetObj.CellValue2(Row, Col) = "";
                	sheetObj.SelectCell(Row, colName);
                    return;
            	}        		
        	} else {
        		sheetObj.CellValue2(Row, Col) = "";
            	sheetObj.SelectCell(Row, colName);
        		ComShowMessage(ComGetMsg('PRD90139'));
        		return;
        	}
        	

        } else if(colName == "s_pol_nod_cd" || colName == "s_pod_nod_cd" || colName == "s_del_nod_cd") {
    		var locValue = "";
    		if (colName == "s_pol_nod_cd") { locValue = sheetObj.CellValue(Row, "s_pol_cd"); }
    		if (colName == "s_pod_nod_cd") { locValue = sheetObj.CellValue(Row, "s_pod_cd"); }
    		if (colName == "s_del_nod_cd") { locValue = sheetObj.CellValue(Row, "s_del_cd"); }
    		
    		if (!fnChkNodeCode(sheetObj, Row, colName, locValue, Value)) { return false; }
    	} else if(colName == "s_trnk_lane_cd" || colName == "s_n1st_lane_cd" || 
    	          colName == "s_n2nd_lane_cd" || colName == "s_n3rd_lane_cd") {
    		
    		if(colName == "s_trnk_lane_cd") {
	    		if(sheetObj.CellValue(Row, "s_trnk_lane_cd") != "ALL") {
	    	    	doActionIBSheet(sheetObj,document.form,SEARCH07);
	    	    }else {
	    	    	 if(CRUD != 'S'){
	    	    		 ComShowMessage(ComGetMsg('PRD90118'));
	    	    		 sheetObj.CellValue2(Row, "s_trnk_lane_cd") ="";
	     			 } else {
	     				retValidate = 1;
	     			 }
	    	    }
    		} else {
    			doActionIBSheet(sheetObj,document.form,SEARCH07);
    		}

    	    if(retValidate < 1) {
    	    	sheetObj.CellValue2(Row, Col) = "";
            	sheetObj.SelectCell(Row, colName);
                return;
        	}
    	}
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
         var sheetId = sheetObj.id;
         if (sAction == IBSAVE) {
        	 
	         switch (sheetId) {
	         case "sheet1":
	        	 var sRows = sheetObj.FindStatusRow("I|U");
	        	 if (sRows != undefined && sRows != '') {
	 	        	 var sRowArr = sRows.split(",");
		        	 for (var i = 0; i < sRowArr.length; i ++) {
		        		 var slanCd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_vsl_slan_cd");
		        		 var vvd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_vvd");
		        		 var chkVal = sheetObj.CellValue(parseInt(sRowArr[i]), "s_lane_vvd_chk");
		        		 var portPntCd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_port_pnt_cd");
		        		 if (slanCd.length > 0 && vvd.length > 0 && chkVal == "N" ) {
		        			 ComShowCodeMessage('PRD90133');
		     		    	 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_vvd");
		     		    	 return false;
		        		 }
		        		 if(portPntCd != 'ALL' && portPntCd != 'POL' && portPntCd != 'TS' && portPntCd != 'POD' && vvd.length > 0 ) {
		        			 ComShowCodeMessage('PRD90134');
		     		    	 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_vvd");
		     		    	 return false;
		        		 }
		        	 }
	        	 }
	        	 break;
	         case "sheet2":
	        	 var sRows = sheetObj.FindStatusRow("I|U");
	        	 if (sRows != undefined && sRows != '') {
	        		 var sRowArr = sRows.split(",");
		        	 for (var i = 0; i < sRowArr.length; i ++) {
		        		 var slanCd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_vsl_slan_cd");
		        		 var vvd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_vvd");
		        		 var chkVal = sheetObj.CellValue(parseInt(sRowArr[i]), "s_lane_vvd_chk");
		        		 var trspModCd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_trsp_mod_cd");
		        		 if (slanCd.length > 0 && vvd.length > 0 && chkVal == "N" ) {
		        			 ComShowCodeMessage('PRD90133');
		     		    	 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_vvd");
		     		    	 return false;
		        		 }
		        		 if(trspModCd != 'AL' && trspModCd != 'WD' && (vvd.length > 0 || slanCd.length > 0) ) {
		        			 ComShowCodeMessage('PRD90135');
		     		    	 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_vvd");
		     		    	 return false;
		        		 }
		        	 }
	        	 }
	        	 break;
	         case "sheet3":
	        	 var sRows = sheetObj.FindStatusRow("I|U");
	        	 if (sRows != undefined && sRows != '') {
	        		 var sRowArr = sRows.split(",");
		        	 for (var i = 0; i < sRowArr.length; i ++) {
		        		 var delCd    = sheetObj.CellValue(parseInt(sRowArr[i]), "s_del_cd");
		        		 var delNodCd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_del_nod_cd");
		        		 var trnkLaneCd = sheetObj.CellValue(parseInt(sRowArr[i]), "s_trnk_lane_cd");
		        		 
		        		 
		        		 // 아래 주석처리한 부분은 서버쪽에 위임한다.
		        		 /*if (delCd.length > 0 && delCd.length != 5) {
		        			 ComShowMessage(ComGetMsg('PRD90139'));
		    	    		 sheetObj.CellValue2(parseInt(sRowArr[i]), "s_del_cd") = "";
		    	    		 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_del_cd");
		    	    		 
		     		    	 return false;
		        		 }
		        		 
		        		 if (delNodCd.length > 0 && delNodCd.length != 2) {
		        			 ComShowMessage(ComGetMsg('PRD90139'));
		    	    		 sheetObj.CellValue2(parseInt(sRowArr[i]), "s_del_nod_cd") = "";
		    	    		 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_del_nod_cd");
		    	    		 
		     		    	 return false;
		        		 }*/
		        		 
		        		 if(trnkLaneCd == "ALL" && CRUD != "S") {
		        			 ComShowMessage(ComGetMsg('PRD90118'));
		        			 sheetObj.CellValue2(parseInt(sRowArr[i]), "s_trnk_lane_cd") = "";
		    	    		 sheetObj.SelectCell(parseInt(sRowArr[i]), "s_trnk_lane_cd");
		        			 return false;
		        		 }
		        	 }
	        	 }
	        	 break;
	         }
         }
    	 return true;
    }



    // Port 
	var portInd = '';
	
	function selectPort(frm, pt){
		portInd = pt;
		var param = '';
		if(pt == 'POL') param = '?loc_cd='+frm.pol.value;
		if(pt == 'POD') param = '?loc_cd='+frm.pod.value;
		if(pt == 'DEL') param = '?loc_cd='+frm.del.value;
		if(pt == 'TS') param = '?loc_cd='+frm.tsport.value;
		
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	
	// Node
	function selectLocation(pt){
	    portInd = pt;
		var param = '?loc_port_ind=1'+'&node_cd='+document.form.loc.value;;
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	
	// Trunk Lane
	function selectLane() {
	    var frm = document.form;
        var slan_cd_val = frm.tlane.value;
	    var param = '?&lane_cd='+slan_cd_val;

	    ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLaneFrm', "1,0,1,1,1,1,1,1,1,1,1,1", true);
       
	}
	
	function getCOM_ENS_061(rArray) {
		var cArray  =  rArray [0];
		
        if(portInd == 'LOC'){
            document.form.loc.value = cArray[3];
		}
		if(portInd == 'FROM'){
			 document.form.from_nd.value = cArray[3];
		}
		if(portInd == 'TO'){
			 document.form.to_nd.value = cArray[3];
		}
		

	}
	
	function getLaneFrm(rArray) {
    	var cArray  =  rArray [0];
    	document.form.tlane.value = cArray[3];
    }
	
	function getLane(rowArray,row,col) {
    	var colArray = rowArray[0];
    	var sheetObj = sheetObjects[beforetab];
    	sheetObj.CellValue2(row, col) = colArray[3];
    }

	function changeSelection(r_index) {

		var formObj = document.form; 
		var objs = document.all.item("tabLayer");
		
		objs[0].style.display = "none";
		objs[1].style.display = "none";
		objs[2].style.display = "none";
		objs[r_index].style.display = "inline";
		
		var area1 = false;
		var area2 = false;
		var area3 = false;
		if(r_index == 0){ // Location/Node
			area1 = true;
			area2 = false;
			area3 = false;
		} else if(r_index == 1){ // Link
			area1 = false;
			area2 = true;
			area3 = false;
		} else if(r_index == 2) { // Route
			area1 = false;
			area2 = false;
			area3 = true;
		}
		//초기화
		if(r_index != beforetab){
			formObj.loc.value = '';
			formObj.from_nd.value = '';
			formObj.to_nd.value = '';
			formObj.tlane.value = '';
			formObj.pol.value = '';
			formObj.tsport.value = '';
			formObj.pod.value = '';
			formObj.del.value = '';

			formObj.point_code[0].checked = true;
			formObj.s_dir_cd.value = '0';
			formObj.svc.value = 'A';
		}
		
		ComEnableObjectPrd(formObj.loc,				area1);
		ComEnableObjectPrd(formObj.btn_node_cd,		area1);
		ComEnableObjectPrd(formObj.point_code[0],	area1);
		ComEnableObjectPrd(formObj.point_code[1],	area1);
		ComEnableObjectPrd(formObj.point_code[2],	area1);
		ComEnableObjectPrd(formObj.point_code[3],	area1);
		ComEnableObjectPrd(formObj.point_code[4],	area1);
		ComEnableObjectPrd(formObj.point_code[5],	area1);

		ComEnableObjectPrd(formObj.from_nd,			area2);
		ComEnableObjectPrd(formObj.btn_from_cd,		area2);
		ComEnableObjectPrd(formObj.to_nd,			area2);
		ComEnableObjectPrd(formObj.btn_to_cd,		area2);

		ComEnableObjectPrd(formObj.tlane,			area3);
		ComEnableObjectPrd(formObj.btn_tnk_lane_cd,	area3);
		ComEnableObjectPrd(formObj.pol,				area3);
		ComEnableObjectPrd(formObj.btn_pol_port_cd,	area3);
		ComEnableObjectPrd(formObj.tsport,			area3);
		ComEnableObjectPrd(formObj.btn_ts_port_cd,	area3);
		ComEnableObjectPrd(formObj.pod,				area3);
		ComEnableObjectPrd(formObj.btn_pod_port_cd,	area3);
		ComEnableObjectPrd(formObj.del,				area3);
		ComEnableObjectPrd(formObj.btn_del_port_cd,	area3);
		ComEnableObjectPrd(formObj.svc,				area3);
		ComEnableObjectPrd(document.getElementById("s_dir_cd"),area3);

	    sheetObjects[0].RemoveAll();
	    sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
		beforetab = r_index;     // 현재 Grid Index 를 저장.

	}

	/**
	 * 공통에서 사용하는 ComEnableObject() 함수는 맞지 않아 이 메소드를 사용합니다
	 */
    function ComEnableObjectPrd(obj, flag){

		if (flag){
            switch( obj.type ) {
                case "select-one" :
                case "text" :
					obj.readOnly = !flag;
					obj.className = "input";
                    break;
                case "textarea":
					obj.readOnly = !flag;
					obj.className = "textarea";
                    break;
				default :
					obj.disabled = !flag;
                    if (obj.tagName=="IMG") {
						obj.style.cursor = "hand";
						obj.style.filter="";
                    }
			}
		}else {
			switch( obj.type ) {
                case "select-one" :
                case "text" :
					obj.readOnly = !flag;
					obj.className = "input2";   //회색바탕
                    break;
                case "textarea":
					obj.readOnly = !flag;
					obj.className = "textarea2";
                    break;

				default :
					obj.disabled = !flag;
                    if (obj.tagName == "IMG") {
						obj.style.cursor = "default";
						obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                    }
			}
		}

	}
	
	function getNode(rowArray, row, col) {
        var sheetObj = sheetObjects[beforetab];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(row, col) = colArray[3];
    }
    
	function getNode2(rowArray, row, col) {
        var sheetObj = sheetObjects[beforetab];
        var colName = sheetObj.ColSaveName(col);
    	var colArray = rowArray[0];
    	
    	if (colName == "s_pol_cd")	{
    	    sheetObj.CellValue2(row, 's_pol_cd') = colArray[3].substring(0,5);
    	    sheetObj.CellValue2(row, 's_pol_nod_cd') = colArray[3].substring(5);
    	}  
    	if (colName == "s_pod_cd")	{
    	    sheetObj.CellValue2(row, 's_pod_cd') = colArray[3].substring(0,5);
    	    sheetObj.CellValue2(row, 's_pod_nod_cd') = colArray[3].substring(5);
    	    
    	}    	  	
    }

    function getLoc(rArray, row, col) {
        var sheetObj = sheetObjects[beforetab];
		var cArray  =  rArray [0];
    	
    	if (colName == "s_n1st_ts_port_cd")	{
    	    sheetObj.CellValue2(row, 's_n1st_ts_port_cd') = cArray[3];
    	}
    	if (colName == "s_n2nd_ts_port_cd")	{
    	    sheetObj.CellValue2(row, 's_n2nd_ts_port_cd') = cArray[3];
    	}  		
    	if (colName == "s_del_cd")	{
    	    sheetObj.CellValue2(row, 's_del_cd') = cArray[3];
    	}  	    	
	}
	        
	function getCommodity(rowArray, row, col) {
        var sheetObj = sheetObjects[beforetab];
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(row, 's_cmdt_cd') = colArray[3];
    	sheetObj.CellValue2(row, 's_cmdt_nm') = colArray[4];
    }    

	/**
	 * Sheet의 VVD입력시 팝업 조회 결과를 입력한다.<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2012.02.22
	 */	
	function getVVD(rowArray, row, col) {
        var sheetObj = sheetObjects[beforetab];
    	var colArray = rowArray[0];
    	sheetObj.CellValue(row, 's_vvd') = colArray[7];
    }    

	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];

		var frm = document.form;
		if(portInd == 'POL'){
			 frm.pol.value = cArray[3];
		}
		if(portInd == 'POD'){
			 frm.pod.value = cArray[3];
		}
		if(portInd == 'DEL'){
			 frm.del.value = cArray[3];
		}
		if(portInd == 'TS'){
			 frm.tsport.value = cArray[3];
		}
		
		//SHEET3 의 POL 셋팅
	}
	
	function changeDirection() {
		var frm = document.form;
		var val = frm.s_dir_cd[frm.s_dir_cd.selectedIndex].value;
		frm.dir_cd.value = (val==0) ? "" : val;
	}
	
	function sheet3_OnClick(sheetObj ,Row, Col){
		var colName = sheetObj.ColSaveName(Col);
		 // s_trunk_lane 값을 초기화 한다.
		 if (colName == "s_trnk_lane_cd" && sheetObj.RowStatus(Row) == "I" && sheetObj.CellValue(Row, "s_nod_cd") =='ALL') {
			 sheetObj.CellValue2(Row, "s_trnk_lane_cd") ="";
			 if(CRUD != 'S'){
				 ComShowMessage(ComGetMsg('PRD90118'));
			 }
		 }
    }
	
	function sheet1_OnBeforeEdit(sheetObj, Row, Col, value){		
		if (sheetObj.CellValue(Row, "s_ibflag")=="I") { return; }
		if(!fnCreOfcCheck(sheetObj, Row)) { ComShowMessage(ComGetMsg('PRD90130')) };
	} // END sheet1_OnBeforeEdit
	
	function sheet2_OnBeforeEdit(sheetObj, Row, Col, value){		
		if (sheetObj.CellValue(Row, "s_ibflag")=="I") { return; }
		if(!fnCreOfcCheck(sheetObj, Row)) { ComShowMessage(ComGetMsg('PRD90130')) };
	} // END sheet2_OnBeforeEdit

	function sheet3_OnBeforeEdit(sheetObj, Row, Col, value){	
		if (sheetObj.CellValue(Row, "s_ibflag")=="I") { return; }
		if(!fnCreOfcCheck(sheetObj, Row)) { ComShowMessage(ComGetMsg('PRD90130')) };
	} // END sheet3_OnBeforeEdit
	
	
	/**
	 * 화면 데이터를 수정하기 전에 발생하는 이벤트를 처리<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param {object}
	 *            sheetObj 필수, IBSheet개체
	 * @param {int}
	 *            Row 필수, Row값
	 * @param {int}
	 *            Col 필수, Col값
	 * @param {String}
	 *            Val 필수, Sheet Row,Col의 값
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2009.10.01
	 */	
	function fnCreOfcCheck(sheetObj, row) {
		if (CRUD == "S") {
			return true;
		} else if (OFC_CD == sheetObj.CellValue(row, "s_cre_ofc_cd")) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Commodity Code를 가져와 화면에 출력한다.<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param {String[][]}
	 *            rowArray 필수, String배열
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2012.02.21
	 */	
    function getCmdtSch(rowArray) {
    	var colArray = rowArray[0];
    	document.form.cmdt_cd.value =  colArray[3];//.substring(0,5);
    	document.form.cmdt_nm.value =  colArray[4];//.substring(0,5);
   	  	
    }
	 
	/**
	 * 화면의 Click Event를 처리한다.<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2012.02.22
	 */	
	function objClick() {
	    var objName = event.srcElement.name;
	    var formObj = document.form;
	    switch(objName) {
        case "general_opt_chk":
        	formObj.general_opt_chk.checked = true; // 항상 TICK 상태
        	break;
	    }
		
	}
	 
	/**
	 * 화면의 Lane입력시 팝업 조회 결과를 입력한다.<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2012.02.22
	 */	
	 function getLaneSch(rowArray){
		  var colArray = rowArray[0];
	      document.form.vsl_slan_cd.value =  colArray[3];
	 } 

	/**
	 * 화면의 VVD입력시 팝업 조회 결과를 입력한다.<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @return {void}
	 * @author Park Mangeon
	 * @version 2012.02.22
	 */	
  	function getVVDSch(rowArray){
  		var colArray = rowArray[0];
  		var vvd = colArray[7];
  		document.form.vsl_cd.value = vvd.substring(0,4);
  		document.form.skd_voy_no.value = vvd.substring(4,8);
  		document.form.skd_dir_cd.value = vvd.substring(8,9);
  	}
	 