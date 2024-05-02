/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0012.js
*@FileTitle : oceanroute management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 진마리아
*@LastVersion : 1.0 
* 2009.07.24 김귀진
* 1.0 Creation
=========================================================*/
/*
 * 2010.10.22 진마리아 CHM-201006410-01 HQ Link Management Logic 변경 요청
 */
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
     * @class ESD_PRD_0012 : ESD_PRD_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0012() {
    this.processButtonClick        = tprocessButtonClick;
    this.setSheetObject            = setSheetObject;
    this.loadPage                = loadPage;
    this.prdComKeyDown()        = prdComKeyDown();
    this.initSheet                = initSheet;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm            = validateForm;
    this.changeDirection()        = changeDirection();
    this.getLane                = getLane;
    this.validateLocation        = validateLocation;
    this.selectPort                = selectPort;
    this.getCOM_ENS_051            = getCOM_ENS_051;
    this.sheet1_OnChange        = sheet1_OnChange;
    this.sheet1_OnSearchEnd        = sheet1_OnSearchEnd;
    
}

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var validateLane ="";
var retValidate = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         var dispaly ;
         var classId ;
         var param ;
         var chkStr ;
         
        try {
            var srcName = window.event.srcElement.getAttribute("name");
              // 버튼이 disable 인지 확인한다.
              if(srcName != null && !ComIsEmpty(srcName)) {
                  //var btnDis  = eval("formObject."+srcName+".disabled");
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

                case "btng_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;

                case "btng_constraint":
                    document.location.href="ESD_PRD_0024.do?f_cmd="+SEARCH02+"&fromNd="+sheetObject.CellValue(sheetObject.selectRow, "polprot" ) +"&toNd="+sheetObject.CellValue(sheetObject.selectRow, "podprot" )+"&link_flg=Y&pgmNo=ESD_PRD_0024";
                    break;


                /************* ********************** *****************/
                case "btn_lane_cd":
                    var slan_cd_val = formObject.vsl_lane_cd.value;
                    dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    classId = "COM_ENS_081";
                    param = '?&lane_cd='+slan_cd_val+'&classId='+classId;
                    chkStr = dispaly.substring(0,3);         
                    
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                        ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', dispaly);
                   
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
                    break;                

                case "btn_pol_cd":
                    selectPort('POL');
                    break;

                case "btn_pod_cd":
                    selectPort('POD');
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

        if(CRUD == "R") {
            ComBtnDisable("btn_save");
//            ComEnableObject(document.getElementById("btn_save"),false);
        }
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress',     form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        axon_event.addListener('keypress', 'PrdComKeyEnter' , 'vsl_lane_cd', 'fm_port_cd', 'to_port_cd');
        axon_event.addListener('keydown', 'prdComKeyDown' , 'vsl_lane_cd', 'fm_port_cd', 'to_port_cd');        
        
    }

    /**
    * Tab 키 입력 이벤트 처리
    * 
    */
    function prdComKeyDown(){
        var keyObj=window.event.keyCode;
        
         if(keyObj == 9){
             var srcName = window.event.srcElement.getAttribute("name");
             
             if(srcName == "vsl_lane_cd"){
                     inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
             }else if(srcName == "fm_port_cd"){
                 inputChkUpper(window.event.srcElement,keyObj , 'SEARCH02');
             }else if(srcName == "to_port_cd"){
                 inputChkUpper(window.event.srcElement,keyObj , 'SEARCH02');
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
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    style.height = 390 ;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle  = "No.|STS|Del.|CHK|SEQ|Lane|Direction|POL|POL|POL|POD|POD|POD|T/Time\n(Day/Hour)|||Source|Remarks" ;
                    var HeadTitle1 = "No.|STS|Del.|CHK|SEQ|Lane|Direction|PORT|ETB|ETD|PORT|ETB|ETD|T/Time\n(Day/Hour)|||Source|Remarks" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,    "",                false,          "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",          false,          "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "del",                false,          "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  true,    "chk",             false,          "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     10,    daRight,   true,    "rseq",            false,          "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "lanecd",          true,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,    "dircd",           true,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "polprot",         true,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  false,   "poletb",          true,          "",       dfNone,        0,     false,       true); //add
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  false,   "poletd",          true,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "podprot",         true,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  false,   "podetb",          true,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  false,   "podetd",          true,          "",       dfNone,        0,     false,       true); //add
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,    "fmt_tztm_hrs",    true,          "",       dfUserFormat2, 0,     false,       true);
                    
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "tsIndCd",         false,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    "ocn_lnk_mnl_flg", false,          "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,    "source",          false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "lnk_rmk",          false,          "",       dfNone,        0,     false,       true);
                    
                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo (0, "poletb", day_cdText, day_cdCode);
                    InitDataCombo (0, "poletd", day_cdText, day_cdCode);
                    InitDataCombo (0, "podetb", day_cdText, day_cdCode);
                    InitDataCombo (0, "podetd", day_cdText, day_cdCode);
                    InitDataCombo (0, "dircd", "E|W|S|N", "E|W|S|N");
                    InitUserFormat2(0, "fmt_tztm_hrs", "##D ##H" , "D|H" );

                    HeadRowHeight = "10" ;
                    CellBackColor(1,"polprot") = RgbColor(231,250,249);
                    CellBackColor(1,"poletb") = CellBackColor(1,"polprot")
                    CellBackColor(1,"poletd") = CellBackColor(1,"polprot")
                    CellBackColor(1,"podprot") = CellBackColor(1,"polprot")
                    CellBackColor(1,"podetb") = CellBackColor(1,"polprot")
                    CellBackColor(1,"podetd") = CellBackColor(1,"polprot")

                    InitDataValid(0, "lanecd",  vtEngUpOther, "1234567890");
                    InitDataValid(0, "polprot", vtEngUpOther, "1234567890");
                    InitDataValid(0, "podprot", vtEngUpOther, "1234567890");
                    
                    WaitImageVisible=false;
                }
                break;

        }
    }

    /**
    * Sheet관련 프로세스 처리
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        var uid ;
        var sXml ;
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        //조회
        case IBSEARCH:
             if(!validateForm(sheetObj,formObj,sAction)) {return;}
             ComOpenWait(true);
             formObj.f_cmd.value = SEARCH;
             sheetObj.DoSearch4Post("ESD_PRD_0012GS.do", PrdFQString(formObj));
             ComOpenWait(false);
             break;
        //저장
        case IBSAVE:
        	ComOpenWait(true);
            if(!validateForm(sheetObj,formObj,sAction)) {
            	ComOpenWait(false);
                return;
            }
            formObj.f_cmd.value = MODIFY;//MULTI;
            var qryStr = PrdFQString(formObj);
            var saveString = sheetObj.getSaveString(false);
            if (saveString == null || saveString == '') { 
                ComShowCodeMessage("COM130503"); 
                ComOpenWait(false);
                return; 
            };
              
            // 메시지 출력 추가 (Delete가 있는 경우에만 메시지 출력)
            var re = new RegExp("ibflag=D", "g");
            var result = re.test(saveString);
            if(result && !ComShowCodeConfirm("PRD90128")){ 
            	ComOpenWait(false);
            	return; 
            }
              
            // Back End Job생성시 문제가 생기면 종료
            var sXml = sheetObj.GetSearchXml("ESD_PRD_0012GS.do" , qryStr + "&" + saveString  );
            if (sXml == "") {
                ComShowCodeMessage("PRD90127");
                ComOpenWait(false); 
                return;
            } else {
                var re2 = new RegExp("ERROR", "g");
                var result2 = re2.test(sXml);
                if (result2) {
                    sheetObj.LoadSaveXml(sXml);
                    ComOpenWait(false);
                    return;
                }
            }
            var sKey = ComGetEtcData(sXml, "back_end_job_key");
            var sQryStr = "f_cmd=" + SEARCH01 
                         + "&delt_flg=" + formObj.delt_flg[formObj.delt_flg.selectedIndex].value
                         + "&vsl_lane_cd=" + formObj.vsl_lane_cd.value 
                         + "&fm_port_cd=" + formObj.fm_port_cd.value 
                         + "&to_port_cd=" + formObj.to_port_cd.value
                         + "&skd_dir_cd=" + formObj.skd_dir_cd.value;
            intervalId = setInterval("doActionSaveResult (sheetObjects[0], '"
                         + sQryStr
                         + "&back_end_job_key=" + sKey
                         + "');"
                         , 5000);
            break;
        // 입력
        case IBINSERT:

            if(!validateForm(sheetObj,formObj,sAction)) {return;}
            ComOpenWait(true);
            sheetObj.DataInsert();
            ComOpenWait(false);
            break;

        case IBCOPYROW:        //행 복사

            sheetObj.DataCopy();
            break;

        case IBDOWNEXCEL:        //엑셀 다운로드
            ComOpenWait(true);
            sheetObj.Down2Excel(-1, false, false, true);
            ComOpenWait(false);
            break;

        case IBLOADEXCEL:        //엑셀 업로드
            ComOpenWait(true);
            sheetObj.LoadExcel();
            ComOpenWait(false);
            break;
        case SEARCH02:
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH02;

            uid= "ESD_PRD_0012";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
            sheetObj.LoadSearchXml(sXml,true, -1, true);     
            retValidate = sheetObjects[0].EtcData("rowCount");
            ComOpenWait(false);
            break; 
        case SEARCH07:
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH07;
       
            uid= "ESD_PRD_0012";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
            sheetObj.LoadSearchXml(sXml,true, -1, true);
            retValidate = sheetObjects[0].EtcData("rowCount");
            ComOpenWait(false);
            break;  
        case SEARCH09:
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH09;
        
            uid  = "ESD_PRD_0012";
            sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
            sheetObj.LoadSearchXml(sXml,true, -1, true);
            retValidate = sheetObj.EtcData("rowCount");
            validateLane = ComGetEtcData(sXml,"comData1");
            ComOpenWait(false);
            break;                             
        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
         switch(sAction) {
         case IBSAVE:
                 // duplication check
              var duprows = sheetObj.ColValueDupRows("lanecd|polprot|podprot");
              if (duprows != undefined && duprows != '') {
                  var dupArr = duprows.split(",");
                  ComShowCodeMessage("COM131302", ["HQ Link '" + sheetObj.CellValue(dupArr[0],"polprot") 
                                                        + "-(" + sheetObj.CellValue(dupArr[0],"lanecd")
                                                        + ")-" + sheetObj.CellValue(dupArr[0],"podprot") + "'"]);
                  return false;
              }
              // check한 데이터가 없는지 검사
              var chkRow = sheetObj.FindCheckedRow("chk");
              var delRow = sheetObj.FindCheckedRow("del");
              if ((chkRow == undefined || chkRow == "") && (delRow == undefined || delRow == "") ) {
                  ComShowCodeMessage("COM130503"); 
                  return false;
              }
              
              break;
         }
        return true;
    }


    /******************************************************************************/

     /**
      * 셀렉트박스 온체인지 이벤트
      * 
      */     
    function changeDirection() {
        var frm = document.form;
        var val = frm.select1[frm.select1.selectedIndex].value;
        frm.skd_dir_cd.value = (val==0) ? "" : val;
    }

    /**
    * COM_ENS_081 팝업화면에서 받는 인자값 처리
    * 
    */
    function getLane(rowArray) {

        var colArray = rowArray[0];
        //sheetObj.CellValue(row, col) = colArray[3];
        document.all.vsl_lane_cd.value = colArray[3];
        
    }

    /**
    * Location Validation 설정 
    * 
    */
    function validateLocation(loc, num) {
        if (num ==1) {
            document.form.fm_port_cd.value = loc.toUpperCase();
        }
        if (num ==2) {
            document.form.to_port_cd.value = loc.toUpperCase();
        }        
        validateData = loc.toUpperCase();
        doActionIBSheet(sheetObjects[0],document.form, SEARCH02);
        
        if(retValidate < 1) { //rowcount 가 1보다 작으면 
            if (num ==1) {
                //document.form.i_org_cd.value = "";
                document.form.fm_port_cd.focus();
            }else {
                document.form.to_port_cd.focus();
            }
            if (num ==2) {
                //document.form.i_dest_cd.value = "";
                //document.form.i_dest_cd.focus();
            }
        }else {
            if (num ==1) {
                //document.form.i_org_cd.value = "";
                document.form.to_port_cd.focus();
            }
        }
        return false;

    }  
    
    var portInd = '';
    /**
    * pol 과 pod 팝업화면 호출
    * 
    */
    function selectPort(pt){
        var frm = document.form;
        var param = '?loc_port_ind=1';
        
        portInd = pt;
        if(portInd == 'POL'){
             param = param+'&loc_cd='+frm.fm_port_cd.value ;
        }
        if(portInd == 'POD'){
             param = param+'&loc_cd='+frm.to_port_cd.value ;
             
        }        
        ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }

    /**
    * COM_ENS_051 팝업 화면에서 받는 인자값 처리
    */    
    function getCOM_ENS_051(rArray) {
        var cArray  =  rArray [0];

        var frm = document.form;
        if(portInd == 'POL'){
             frm.fm_port_cd.value = cArray[3];
        }
        if(portInd == 'POD'){
             frm.to_port_cd.value = cArray[3];
        }
    }
    
    /**
    * sheet1 조회후 처리
    */    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        if(sheetObj.RowCount>0 && CRUD!="R") {
            ComBtnEnable("btn_save");
//            ComEnableObject(document.getElementById("btn_save"), true);
        } 
    }       

    /**
    * sheet1 onChange 이벤트 처리
    */
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        var sName = sheetObj.ColSaveName(Col);
        if (sName == "dircd" || sName == "poletb" || sName == "poletd"|| sName == "podetb"|| sName == "podetd" || sName == "fmt_tztm_hrs"|| sName == "remark") {
              sheetObj.CellValue2(Row,"chk")=1;  
        }
        
        if(sName == "polprot" ||sName == "podprot" ){
            validateData = Value;
            doActionIBSheet(sheetObj,document.form, SEARCH02);
            if(retValidate < 1) { //rowcount 가 1보다 작으면 
                if(sName == "polprot") {
                   sheetObj.CellValue2(Row,"polprot")="";
                   sheetObj.SelectCell(Row,"polprot");
                }else if(sName == "podprot") {
                   sheetObj.CellValue2(Row,"podprot")="";
                   sheetObj.SelectCell(Row,"podprot");
                }
            }
            
        }
        
        // FDR 인지 체크
        if(sName=="lanecd") {
            validateData = Value;
            validateLane = "";
            doActionIBSheet(sheetObj,document.form, SEARCH09); 
            if(validateLane == 'O') { // 만약 fdr라면 
                   ComShowMessage(ComGetMsg('PRD90098'));
                   sheetObj.CellValue2(Row,"lanecd")="";
                   sheetObj.SelectCell(Row,"lanecd");
            } 
            if(retValidate < 1){
                sheetObj.CellValue2(Row,"lanecd")="";
                sheetObj.SelectCell(Row,"lanecd");
            }
        }
        
        if(sName == "fmt_tztm_hrs"){
        
            if(parseInt(Value) > 9923  ){
                ComShowMessage(ComGetMsg('PRD90099'));
                sheetObj.CellValue2(Row,Col) = "";
            }
        }
        
    }
    
    /**
     * POL, POD Click 여부
     * @return
     */
     function sheet1_OnClick(sheetObj ,Row, Col){
              
         if (sheetObj.ColSaveName(Col) == "del" && sheetObj.CellValue(Row, "del") =='0') {        
             if( sheetObj.CellValue(Row, "source") =="Auto Creation" ){
                 ComShowMessage(ComGetMsg('PRD90126'));
                 sheetObj.CellValue2(Row, "del") ='1';
             }
         }
         
         if (sheetObj.ColSaveName(Col) == "del" && sheetObj.CellValue(Row, "source") =='Manual Deletion') {
             sheetObj.CellValue2(Row, "del") ='1';
         }
    }
     
     /**
      * DoActionIBSheet의 Sub Function으로 동작한다.<br>
      * Backend job에 대한 모니터링 및 결과 처리를 수행한다.<br>
      * <br>
      * <b>Example : </b>
      *
      * <pre>
      * </pre>
      *
      * @param {Object}
      *            sheetObj 필수, sheet개체
      * @param {String}
      *            queryString 필수, HTML String
      * @return {void}
      * @author Park Mangeon
      * @version 2009.10.01
      */
     function doActionSaveResult(sheetObj, queryString) {
         var sXml = sheetObj.GetSearchXml("ESD_PRD_0012GS.do" , queryString);
         var sJbStsFlg = "";

         if (sXml == "") {
             // 서버가 내려간 경우 조회할 동안 해당과 같이 데이터가 들어온다.
             clearInterval(intervalId);
             ComShowCodeMessage("PRD90129", ["saving HQ Link"]);
              ComOpenWait(false);
             return;
         }

         // 에러가 발생했을 경우 대기상태를 종료한다.
         var txState = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
         if (txState == "F") {
             clearInterval(intervalId);
             ComShowCodeMessage("COM12151", ["HQ Link"]);
             ComOpenWait(false);
             return;
         }

         sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
         if (sJbStsFlg == "3" || sJbStsFlg == "4") {
             clearInterval(intervalId);
             ComOpenWait(false);
             if (sJbStsFlg == "3") {
                 sheetObj.RemoveAll();
                 sheetObj.LoadSearchXml(sXml);
                 ComShowCodeMessage("COM130102", ["HQ Link"]);
             } else if (sJbStsFlg == "4") {
                 // 오류가 났으므로 재조회 하도록 한다.
//                 alert(queryString);
                 ComShowCodeMessage("PRD90127");
                 return;
             }
         }

     }