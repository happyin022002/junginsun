/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0010.js
*@FileTitle : Embargo Management
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
     * @class ESD_PRD_0010 : ESD_PRD_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0010() {
	this.processButtonClick		= tprocessButtonClick;
	this.selectCountry			= selectCountry;
	this.getCountry				= getCountry;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.validateCountry		= validateCountry;
	this.validateForm			= validateForm;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
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
                 // var btnDis  = eval("formObject."+srcName+".disabled");
            	  var btnDis = eval("document.getElementById('" + srcName + "').disabled");
                  if (btnDis) return;
              }
              
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
            //if(srcObj =='INPUT' && keyObj ==13) {
           //     srcName ='btn_retrieve';
            //}
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

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_rowcopy":
      	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;
        	        
       	        case "btn_fromCnt":
       	            selectCountry('From');

        	        break;
        	        
       	        case "btn_toCnt":
      	            selectCountry('To');
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
    
    var cntGb = '';
    function selectCountry(cnt){
        cntGb = cnt;
        var frm = document.form;
        var param = '?classId='+"COM_ENS_051"
        var sheetObj = sheetObjects[0];
        if(cntGb == 'From') {
            param = param+'&cnt_cd='+frm.i_from.value;
        } else if (cntGb == 'To'){
            param = param+'&cnt_cd='+frm.i_to.value;
        } else if (cntGb == 'gFrom'){
            param = param+'&cnt_cd='+sheetObj.CellValue(sheetObj.SelectRow,"fm_cnt_cd");
        } else if (cntGb == 'gTo'){
            param = param+'&cnt_cd='+sheetObj.CellValue(sheetObj.SelectRow,"to_cnt_cd");
        }
        
        ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);        
        
    }
    function getCountry(rowArray) {
    	
    	
    	var colArray = rowArray[0];	
        var sheetObj = sheetObjects[0];
        if(cntGb == 'From') {
            document.all.i_from.value = colArray[3];
        } else if (cntGb == 'To'){
            document.all.i_to.value   = colArray[3];
        } else if (cntGb == 'gFrom'){
            sheetObj.CellValue2(sheetObj.SelectRow,"fm_cnt_cd" )   = colArray[3];
        } else if (cntGb == 'gTo'){
            sheetObj.CellValue2(sheetObj.SelectRow,"to_cnt_cd" )   = colArray[3];
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

        if(CRUD == "R") {
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btng_rowadd");
        	ComBtnDisable("btng_rowcopy");
//			ComEnableObject(document.getElementById("btn_save"), false);
//			ComEnableObject(document.getElementById("btng_rowadd"), false);
//			ComEnableObject(document.getElementById("btng_rowcopy"), false);
		}

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_from', 'i_to');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'i_from', 'i_to');
    }
     
     /**
 	 * tab event처리
 	 * @return
 	 */
 	function prdComKeyDown(){
 		var keyObj=window.event.keyCode;
     	
      	if(keyObj == 9){
      
      		inputChkUpper(window.event.srcElement,keyObj , 'SEARCH06');
      		
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
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Del.|STS|No.|From|To|Creation DT|Update DT|User ID|Remark" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",           false, "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",     false, "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    "",           false, "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  120,   daCenter,  false,    "fm_cnt_cd",  true,  "",       dfNone,    0,     false,      true,2);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  120,   daCenter,  false,    "to_cnt_cd",  true,  "",       dfNone,    0,     false,      true,2);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "cre_dt",     false, "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "upd_dt",     false, "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "upd_usr_id", false, "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daLeft,    false,    "mbgo_rmk",   false, "",       dfNone,    0,     true,       true);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]

					InitDataValid(0, "fm_cnt_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, "to_cnt_cd", vtEngUpOther, "1234567890");
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
                formObj.f_cmd.value = SEARCHLIST;

                sheetObj.DoSearch4Post("ESD_PRD_0010GS.do", PrdFQString(formObj));
                break;
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                
                formObj.f_cmd.value = MULTI;
                sheetObj.DoAllSave("ESD_PRD_0010GS.do", PrdFQString(formObj));
                break;

           case IBINSERT:      // 입력

               if(validateForm(sheetObj,formObj,sAction))
                 sheetObj.DataInsert();
                break;

           case IBCOPYROW:        //행 복사

              sheetObj.DataCopy();
              break;

           case IBDOWNEXCEL:        //엑셀 다운로드

              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBLOADEXCEL:        //엑셀 업로드

              sheetObj.LoadExcel();
              break;
              
           case SEARCH06:
              formObj.f_cmd.value = SEARCH06;

              uid= "ESD_PRD_0010";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break; 

        }
    }

// dtPopupEdit 로 처리 할 경우 팝업오픈 처리

function sheet1_OnPopupClick(sheetObj, row, col)
{
    if ( sheetObj.ColSaveName(col) == "fm_cnt_cd" )
    {
       selectCountry('gFrom');
    }
    if ( sheetObj.ColSaveName(col) == "to_cnt_cd" )
    {
       selectCountry('gTo');
    }
}


    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        if(sheetObj.RowCount>0 && CRUD!="R") {
        	ComBtnEnable("btn_save");
        	ComBtnEnable("btn_new");
//        	ComEnableObject(document.getElementById("btn_save"), true);
//        	ComEnableObject(document.getElementById("btn_new"), true);      
        } 
    }  
    
    
    // Location code 에 대한 validation
    function validateCountry(loc, num) {
    	if (num ==1) {
        	document.form.i_from.value = loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.i_to.value = loc.toUpperCase();
    	}        
        validateData = loc.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
    	if(retValidate < 1) {
        	if (num ==1) {
            	document.form.i_from.focus();
        	}

    	}else {
        	if (num ==1) {
            	document.form.i_to.focus();
        	}
    	}
    	return false;

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