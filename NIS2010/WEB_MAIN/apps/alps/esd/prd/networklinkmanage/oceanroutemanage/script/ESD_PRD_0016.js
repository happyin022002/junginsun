/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0016.js
*@FileTitle :Lane Status Inquiry by P/F Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.24 김귀진
* 1.0 Creation
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
     * @class ESD_PRD_0016 : ESD_PRD_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0016() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.prdComChange			= prdComChange;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.validateForm			= validateForm;
	this.changeSelection		= changeSelection;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
             // 버튼이 disable 인지 확인한다.
              if(srcName != null && !ComIsEmpty(srcName)) {
            	  var btnDis = eval("document.getElementById('" + srcName + "').disabled");
                  if (btnDis) return;
              }
              
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
         
            /****************************/              
            switch(srcName) {

         	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
            
        	        break;

        	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;
        	        
                case "btn_batchupdate":
        	        doActionIBSheet(sheetObject,formObject,SEARCH01);
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
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

		if(CRUD != "S") {
			ComBtnDisable("btn_save");
//		    ComEnableObject(document.getElementById("btn_save"), false);
//		    ComEnableObject(document.getElementById("btn_batchupdate"), false);
		}

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'lane_cd');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'lane_cd');
		axon_event.addListener('change', 'prdComChange' , 'select2','select3','select4');

    }
     
     /**
      * tab evnet처리
      * @return
      */
     function prdComKeyDown(){
    	 var keyObj=window.event.keyCode;
      	if(keyObj == 9){
      		inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
      	}
    	 
     }

     /**
      * change event
      * @return
      */
     function prdComChange(){
    	 
  		var srcName = window.event.srcElement.getAttribute("name");
  		if(srcName == "select2"){
  			changeSelection(document.form.select2, document.form.ocn_ipc_flag, '');
  		}else if(srcName == "select3"){
  			changeSelection(document.form.select3, document.form.status, '');
  		}else if(srcName == "select4"){
  			changeSelection(document.form.select4, document.form.multi_ind, '');
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
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = GetSheetHeight(13) ;
                    //style.height = 270 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "SEQ|STS|Del.|Chk|Lane|P/F Type|Duration|Creation DT|Update DT|Standard|Multi IND|Leg|Status|Remarks";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,  "",             false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,  "ibflag",       false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtDelCheck,   40,    daCenter,  false,  "",             false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox ,  40,    daCenter,  false,  "chk",          false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,  "s_lane_cd",    false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,  "s_lane_tp",    false,          "",       dfNone, 	    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,  "",             false,          "",       dfNone, 	    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,  "",             false,          "",       dfDateYmd,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,  "",             false,          "",       dfDateYmd,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  false,  "s_standard",   false,          "",       dfNone, 	    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  false,  "s_multi",      false,          "",       dfNone, 	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  false,  "s_leg",        true,           "",       dfNone, 	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,  "g_status",     false,          "",       dfNone, 	    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daLeft,    false,  "",             false,          "",       dfNone, 	    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  false,  "s_upd_ind_cd", false,          "",       dfNone, 	    0,     false,       true);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0, "s_standard", "Y|N", "Y|N");
         		    InitDataCombo (0, "s_multi", "Y|N", "Y|N");
         		    InitDataCombo (0, "s_leg", " |OCN|IPC", " |OCN|IPC");

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
                if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_PRD_0016GS.do", PrdFQString(formObj));
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value = MODIFY;
                sheetObj.DoSave("ESD_PRD_0016GS.do", PrdFQString(formObj));
                sheet1_OnSearchEnd(sheetObj, 1);
                break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBLOADEXCEL:        //엑셀 업로드
              sheetObj.LoadExcel();
              break;

           case SEARCH01:        //배치 
              if(validateForm(sheetObj,formObj,sAction))
              formObj.f_cmd.value = SEARCH01;
              sheetObj.DoSearch4Post("ESD_PRD_0016GS.do", PrdFQString(formObj));
              break;
           case SEARCH07: //lane
              formObj.f_cmd.value = SEARCH07;
              uid= "ESD_PRD_0033";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;                
        }
    }

  
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


//////////////////////////////////////////////////////////////////////////////////////

	function changeSelection(list, tgtObj, defaultVal) {
		/*
		var list   = null;
		var setObj = null;
		if(gugun==''){
			return;

		}
		if(gugun==''){
			list   = document.form.select1;
			setObj = document.form.text2;
		}

		setObj.value = (val==0) ? "" : val;
		*/
		var val = list[list.selectedIndex].value;

		defaultVal   = (defaultVal!=null) ? defaultVal : list[0].value;
		tgtObj.value = (val==0) ? defaultVal : val;
	}

	function sheet1_OnSearchEnd(sheetObj, row){
		var rowCount  = sheetObj.RowCount;
		var colIndex  = 10;//
		var rowStatus = '';
		for(i=1;i<=rowCount;i++){
			rowStatus = sheetObj.CellValue(i, "g_status");
			if(rowStatus=='' || rowStatus=='Deleted'){
				sheetObj.CellEditable(i, "s_leg") = false;
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(235,235,235);
			}else{
				sheetObj.CellEditable(i, "s_leg") = true ;
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,192);
			}
		}

        if(sheetObj.RowCount>0 && CRUD!="R") {
        	ComBtnEnable("btn_save");
//        	ComEnableObject(document.getElementById("btn_save"), true);        
        }	
	}
	
	

    