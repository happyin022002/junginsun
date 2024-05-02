/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0009.js
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
* 1.0 Creation
* history
* 1. 2010.11.03 채창호  CHM-201006834-01: Inland Link Management와 Route Management의 연동 Logic 변경요청.(2010년 7월 29일 이전버젼으로 원복 조치)
* 2. 2011.01.18 이수진 [CHM-201108245-01] PRD내 Service Provide Inquiry 화면 변경 요청.
*    => 1)Inland Link Management 메뉴에서 사용하는 S/P Popup을 ESD_PRD_0026에서  COM_ENS_0C1로 변경
*       2)기존에는 Vendor Seq.를 선택하면 Parent Vendor Seq.를 보여줬었는데 자기 자신의 Vendor Seq.가 보이도록 수정
* 3. 2011.02.14 정선용 [CHM-201108587-01] Inland Link Management 및 Hub Location Management
* 4. 2011.03.10 채창호 [CHM-201109187-01] Network Link 산하 기능의 입력/조회에 대한 Alert Message 변경 요청. 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_PRD_0009 : ESD_PRD_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0009() {
	this.processButtonClick		= tprocessButtonClick;
	this.delFlagCheck			= delFlagCheck;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.setHiddenData			= setHiddenData;
	this.pseudoCdCheck			= pseudoCdCheck;
	this.errMsg					= errMsg;
	this.checkMandatory			= checkMandatory;
	this.calcuTztmHrs			= calcuTztmHrs;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.getNode				= getNode;
	this.getVendor				= getVendor;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.setNodCd				= setNodCd;
	this.getOrgLoc				= getOrgLoc;
	this.getDestLoc				= getDestLoc;
	this.validateLocation		= validateLocation;
	this.validateForm			= validateForm;
	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
	
	
}


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;
var comData1 ="";
var isDoor;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

         var dispaly ;
         var classId ;
         var param ;
         var chkStr ;
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            /****************************
             enterKey 처리
            *****************************/
            
    		var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;

            switch(srcName) {

        	    case "btn_retrieve":
        	    	if(!checkInput()) return false;
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();	            
        	        break;

        	    case "btn_save":
        	    	
        	        if(delFlagCheck(sheetObject)) {
                        if(!confirm(ComGetMsg('PRD90044'))) {
                            break;
                        }
        	        }
        	       if(!checkMandatory() ) return;
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_update":

    	            doActionIBSheet(sheetObject,formObject,MODIFY01);
        	        break;

        	    case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btn_loadexcel":
        	        doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_rowcopy":
      	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;
        	        
                // 05. Location (COM_ENS_051)
                case "btn_org_loc":
//                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
//        	       classId = "COM_ENS_051";
//        		   param = '?classId='+classId+'&loc_cd='+formObject.i_org_cd.value;
//        		   chkStr = dispaly.substring(0,3)
//                      
//                       // radio PopUp  
//                       if(chkStr == "1,0") {
//                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getOrgLoc', dispaly, true);
//                       } else {
//                           ComShowMessage(ComGetMsg('PRD90063'));
//                           return;
//                      }
        		   selectNode(formObject,'ORG');
                  break;
                  
               case "btn_dest_loc":
//                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
//        	       classId = "COM_ENS_051";
//        		   param = '?classId='+classId+'&loc_cd='+formObject.i_dest_cd.value;
//        		   chkStr = dispaly.substring(0,3)
//                   // radio PopUp  
//                   if(chkStr == "1,0") {
//                	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getDestLoc', dispaly, true);
//                   } else {
//                       ComShowMessage(ComGetMsg('PRD90063'));
//                       return;
//                   }
        		   selectNode(formObject,'DEST');
                  break;             } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('PRD90054'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    var portInd = '';
    function selectNode(frm, org_dest){
		var param = '?loc_port_ind=1';
		portInd = org_dest;
		if(portInd == 'ORG'){
          param = param+'&node_cd='+frm.i_org_cd.value;
		}
		if(portInd == 'DEST'){
		  param = param+'&node_cd='+frm.i_dest_cd.value;
		}		
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNodeCd', "1,0,1,1,1,1,1,1,1,1,1,1", true);    	
    }

	function getNodeCd(rowArray) {
//        alertComPopupData(rowArray);
		var colArray = rowArray[0];
	
		if(portInd == 'ORG'){
	    	document.all.i_org_cd.value =  colArray[3];    	
		}
		if(portInd == 'DEST'){
	    	document.all.i_dest_cd.value =  colArray[3]; 	
		}	    	  	
    }	
	
    function delFlagCheck(sheetObj) {
        var sRow =sheetObj.FindStatusRow("D");
        var arRow = sRow.split(";");
        if(arRow.length >1) {
           return true;
        } else {
           return false;
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
		}

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd', 'i_dest_cd', 'i_agmt_no');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'i_org_cd', 'i_dest_cd');
    }
     
    /**
     * tab event처리
     * @return
     */
    function prdComKeyDown(){
    	var keyObj=window.event.keyCode;
    	
     	if(keyObj == 9){
     		var srcName = window.event.srcElement.getAttribute("name");
     		if(eval('document.form.'+srcName+'.value').length ==5 ){
     			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH02');
     		} else if(eval('document.form.'+srcName+'.value').length ==7){
     			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH04');
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
                    //style.height = GetSheetHeight(11) ;
                    style.height = 400 ;
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
                    InitColumnInfo(27, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Del.|CHK|STS|SEQ|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|Agmt No|Reference No|T/T\n(DD.HH)|Distance|UOM||||||||||UPDATE RESULT|MSG" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,   50,    daCenter,  false,    "",               false, "",       dfNone,        0,     true,       true, -1, false, true, "", true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "agmt_chk",       false, "",       dfNone,        0,     true,       true, -1, false, true, "", true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",         false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    "",               false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  60,    daCenter,  false,    "org_loc",        false, "",       dfNone,        0,     false,      true, 5);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,    "org_type",       false, "",       dfNone,        0,     false,      true, 2 );
                    InitDataProperty(0, cnt++ , dtPopupEdit,  60,    daCenter,  false,    "dest_loc",       false, "",       dfNone,        0,     false,      true, 5);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,    "dest_type",      false, "",       dfNone,        0,     false,      true, 2);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  false,    "trsp_mod_cd",    false, "",       dfNone,        0,     false,      true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  60,    daCenter,  false,    "vndr_seq",       false, "",       dfNone,        0,     true,       true,6);
                    InitDataProperty(0, cnt++ , dtData,       170,   daLeft,    false,    "vndr_name",      false, "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    "agmt_no",        false, "",       dfNone,        0,     false,      false,9);
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  false,    "refe_no",        false, "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "fmt_tztm_hrs",   true,  "",       dfUserFormat2, 0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "lnk_dist",       false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      35,    daCenter,  false,    "dist_ut_cd",     false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,  false,    "rail_crr_tp_cd", false, "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "lnk_org_nod_cd", false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "lnk_dest_nod_cd",false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "tztm_hrs",       false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "us_rail",        false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "vndr_cnt_cd",    false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "org_is_door",    false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "dest_is_door",   false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "unmatch",        false, "",       dfNone,        0,     true,       true);
                    InitDataProperty(0, cnt++ , dtResult,     50,    daCenter,  false,    "result",         false, "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  false,    "sResult",        false, "",       dfNone,        0,     false,      false);

		            InitDataCombo(0, "trsp_mod_cd", trsp_mod_cdText, trsp_mod_cdCode);
		            InitDataCombo(0, "dist_ut_cd", " |M|K", " |M|K");
		            InitDataCombo(0, "rail_crr_tp_cd", rail_crr_tp_cdText, rail_crr_tp_cdCode);

		            InitUserFormat2(0, "fmt_tztm_hrs", "##.##", "." );

					InitDataValid(0, "org_loc",     vtEngUpOther, "1234567890");
					InitDataValid(0, "org_type",    vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc",    vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_type",   vtEngUpOther, "1234567890");
					InitDataValid(0, "vndr_seq",    vtEngUpOther, "1234567890");
					InitDataValid(0, "agmt_no",     vtEngUpOther, "1234567890");

                }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;	    
        sheetObj.ShowDebugMsg = false ;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction))
              
                if(!checkMandatory() ) return;
                formObj.f_cmd.value = SEARCHLIST;
                
                sheetObj.DoSearch4Post("ESD_PRD_0009GS.do", PrdFQString(formObj));
                
                break;
            case IBSAVE:        //저장
            
                if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value = MULTI;
                setNodCd(sheetObj);
                if(calcuTztmHrs(sheetObj) == false) {
                    return false;
                };
                sheetObj.DoSave("ESD_PRD_0009GS.do", PrdFQString(formObj));
                
                pseudoCdCheck(sheetObj);
                break;

            case MODIFY01:        //only agmt update
          
                if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value = MODIFY01;
                sheetObj.DoSave("ESD_PRD_0009UPGS.do", PrdFQString(formObj));
                
                errMsg(sheetObj);
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

              if(sheetObj.LoadExcel() == true) {
                  // hidden 값을 셋팅한다. 
                  setHiddenData(sheetObj);
              } 
              break;
           
           //location check
           case SEARCH02:
              formObj.f_cmd.value = SEARCH02;

              uid= "ESD_PRD_0009";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  

              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;  
           //node check
           case SEARCH04:
              formObj.f_cmd.value = SEARCH04;

              uid= "ESD_PRD_0009";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              isDoor = sheetObjects[0].EtcData("isDoor");
              break;   
           //vender check
           case SEARCH08:
              formObj.f_cmd.value = SEARCH08;

              uid= "ESD_PRD_0009";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              comData1 = sheetObjects[0].EtcData("comData1");
              comData2 = sheetObjects[0].EtcData("comData2");
                //rowcount 가 1보다 작으면 
                if(retValidate < 1) {
                    sheetObj.SelectCell(sheetObj.selectedRow,"vndr_seq");
                    sheetObj.CellValue2(sheetObj.selectedRow,"vndr_name") = comData2;
                }
              break;                             
        }
    }

    function setHiddenData(sheetObj) {
        setNodCd(sheetObj);
        if(calcuTztmHrs(sheetObj) == false) {
            return false;
        };
    }
    
    function  pseudoCdCheck(sheetObj){
        var pseudoCd = sheetObj.EtcData("pseudoCd");
        var blankCd = sheetObj.EtcData("blankCd");
        var invalidVendorCd = sheetObj.EtcData("invalidVendorCd");

        var msg = "";
        if(pseudoCd.length>0){

            msg = ComGetMsg('PRD90045',pseudoCd);
        }
        if(blankCd.length>0){

            msg = msg+ComGetMsg('PRD90046',blankCd);
        }
        if(invalidVendorCd.length>0){

            msg = msg+ComGetMsg('PRD90047',invalidVendorCd);
        }  
        
        if(pseudoCd.length>0 || blankCd.length>0|| invalidVendorCd.length>0){
            ComShowMessage(msg);
        }
    }
    
    function  errMsg(sheetObj){
        var validUpdateRoute = sheetObj.EtcData("validUpdateRoute");
        var validAgmtNoRoute = sheetObj.EtcData("validAgmtNoRoute");
        var msg = "";
        if(validUpdateRoute.length>0){
        	msg = ComGetMsg('PRD90068',validUpdateRoute); 
        }
        if(validAgmtNoRoute.length>0){
            msg = msg+ComGetMsg('PRD90068',validAgmtNoRoute);
        }
 
        
        if(validUpdateRoute.length>0 || validAgmtNoRoute.length>0 ){
            ComShowMessage(msg);
        }
    }
    /*
     * Mandatory 체크 
     */
    function checkMandatory() {
        var formObj = document.form;
        var retValue = true;
        var orgCd = formObj.i_org_cd.value;
        var destCd = formObj.i_dest_cd.value;
        var agmtNo = formObj.i_agmt_no.value;
         
        if(agmtNo.length > 0 ) {
            retValue = true;
        } 
//        else {
//            if( orgCd.length < 5 ) {
//                 ComShowMessage(ComGetMsg('PRD90007'));
//                 formObj.i_org_cd.focus();;
//                 retValue = false;
//            } else if (destCd.length < 5 ) {
//                 ComShowMessage(ComGetMsg('PRD90007'));
//                 formObj.i_dest_cd.focus();;
//                 retValue = false;
//            }            
//        }

         return retValue;
    }
    
/**
 * 시트에서 포맷으로 된 일수||시간을 시간으로 변경  
 * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달  
 */
    function calcuTztmHrs(sheetObj) {
        
        var fmtTime =0;
        for( i=1; i<= sheetObj.RowCount; i++) {
           if(sheetObj.RowStatus(i)=="I" || sheetObj.RowStatus(i)=="U"){
               fmtTime = sheetObj.CellValue(i,"fmt_tztm_hrs").replace(" ","");
               if(fmtTime.length != 4) {
                   
                   //4자리 모두 입력하십시요.(DD.HH)
                   ComShowMessage(ComGetMsg("PRD90014"));
                   sheetObj.SelectCell(i, "fmt_tztm_hrs", true); 
                   return false;
               }
               sheetObj.CellValue2(i,"tztm_hrs")=(eval(fmtTime.substring(0,2)*24)+eval(fmtTime.substring(2)));
           }
        }
        return true;
        
    }

/**
 * 시트에서 Biz 공통 팝업 호출
 * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달  
 */
    function sheet1_OnPopupClick(sheetObj, row, col){
	 	var loc_cd_val ;
	    var dispaly ;
	    var classId ;
	    var param ;
	    var chkStr ;
        if ( sheetObj.ColSaveName(col) == "org_loc" || sheetObj.ColSaveName(col) == "dest_loc" )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
           
            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_061";
    	    param = '?loc_cd='+loc_cd_val+'&classId='+classId;
    		  
    	    chkStr = dispaly.substring(0,3)          
            
            // Radio PopUp  
            if(chkStr == "1,0") {
            	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', dispaly, true,false, row, col);
           
            } else {
               ComShowMessage(ComGetMst('PRD90063'));
               return;
            }
        }
      
        
        if ( sheetObj.ColSaveName(col) == "vndr_seq"  )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
           
            display = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_0C1";
    	    param = '?pts_vndr_cd='+loc_cd_val+'&classId='+classId+'&func=getVendor&display='+display+'&row='+row+'&col='+col;
    		  
    	    chkStr = display.substring(0,3);
            
            // Radio PopUp  
            if(chkStr == "1,0") {
              myWin = ComOpenWindowCenter('/hanjin/COM_ENS_0C1.do'+param, 'pop', 700, 450, true);
    
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }
        
        
    }  



    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
    
        if(sheetObj.RowCount>0) {
//            bntImgEnable(document.form.btn_save, true);
//            bntImgEnable(document.form.btn_downexcel, true);
//            bntImgEnable(document.form.btn_loadexcel, true);
//            bntImgEnable(document.form.btng_rowadd, true);
//            bntImgEnable(document.form.btng_rowcopy, true);
        } else {
//            bntImgEnable(document.form.btn_save, false);
//            bntImgEnable(document.form.btn_downexcel, false);
//            bntImgEnable(document.form.btn_loadexcel, false);
//            bntImgEnable(document.form.btng_rowadd, false);
//            bntImgEnable(document.form.btng_rowcopy, false);         
        }
        
//        for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){	
//            
//            if(sheetObj.CellValue(i,"unmatch")=='OK'){
//                sheetObj.RowBackColor(i) =sheetObj.RgbColor(255,160,64);
//                
//            }
//        }
        
    } 
    


/**
 * Node : 팝업에서 Radio로 단일 선택을 한경우..
 */
    function getNode(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
        
    	var colArray = rowArray[0];
    	if (sheetObj.ColSaveName(col) == "org_loc")
    	{
        	sheetObj.CellValue2(row, "org_type") = colArray[3].substring(5);
        	sheetObj.CellValue2(row, "org_loc") = colArray[3].substring(0,5);
    	} else if  (sheetObj.ColSaveName(col) == "dest_loc")
    	{
        	sheetObj.CellValue2(row, "dest_type") = colArray[3].substring(5);
        	sheetObj.CellValue2(row, "dest_loc") = colArray[3].substring(0,5);
    	}
    }
    
    function getVendor(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
        
    	var colArray = rowArray[0];
        sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
        sheetObj.CellValue2(row, "vndr_name") = colArray[4];

    }
    
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        //시간 포맷 체크 
        if (sheetObj.ColSaveName(Col) == "fmt_tztm_hrs")
    	{
    	    var fmtTime = sheetObj.CellValue(Row,"fmt_tztm_hrs").replace(" ","");
    
           if(fmtTime.length != 4) {
               
               //4자리 모두 입력하십시요.(DD.HH)
               ComShowMessage(ComGetMsg("PRD90014"));
               sheetObj.SelectCell(Row, "fmt_tztm_hrs", true); 
               return false;
           }    	    
    	    if(fmtTime.substring(2)>24) {
    	        ComShowMessage(ComGetMsg("PRD90015")); // 시간은 24보다 작아야 합니다.
    	        sheetObj.SelectCell(Row,"fmt_tztm_hrs");
    	        return false;
    	    }

            sheetObj.CellValue2(i,"tztm_hrs")=(eval(fmtTime.substring(0,2)*24)+eval(fmtTime.substring(2)));
               
    	}   
    	//sp 코드 체크 
    	if (sheetObj.ColSaveName(Col) == "vndr_seq")
    	{
            if( sheetObj.CellValue(Row,"vndr_seq").length > 0) {
                //validateData 는 체크할 nod cd 
                
                validateData = sheetObj.CellValue(Row,"vndr_seq");
                doActionIBSheet(sheetObjects[0],document.form, SEARCH08);
                //rowcount 가 1보다 작으면 
                if(retValidate < 1) {
                    sheetObj.SelectCell(Row,"vndr_seq");
                    sheetObj.CellValue2(Row,"vndr_name") = comData2;
                } else {
                    sheetObj.CellValue2(Row,"vndr_name") = comData2;
                }
            }   
    	} 

        //RAIL 일때만 AGMT NO 입력 가능 
       if( sheetObj.ColSaveName(Col) == "trsp_mod_cd"  ){
               var trsp = sheetObj.CellValue(Row,"trsp_mod_cd"); 
               if(  trsp =="RD" ) {
                   sheetObj.CellEditable(Row,"agmt_no") = true;
               }else {
                   sheetObj.CellEditable(Row,"agmt_no") = false;                 
               }
       }        
        
            	
    	//AGMT NO 체크
        if ( sheetObj.ColSaveName(Col) == "agmt_no"  ){
            if(Value =="") {
                sheetObj.CellValue2(Row,"refe_no")="";
                return;
            }
            var cty_cd = Value.substring(0,3);
            var agmt_cd = Value.substring(3);
            var vndr_seq = sheetObj.CellValue(Row,"vndr_seq");
            sheetObj.DoRowSearch("ESD_PRD_0005_AGMT_NO_GS.do", "f_cmd="+SEARCH01+"&cty_cd="+cty_cd +"&agmt_seq="+agmt_cd +"&row="+Row+"&col="+Col ) 
        	if(sheetObj.EtcData("rowCount")==0) {
        	    sheetObj.CellValue2(Row,"refe_no")="";
        	}else {
        	    if(sheetObj.EtcData("trs_vndr_seq") != vndr_seq ) {
                 ComShowMessage(ComGetMsg('PRD90070'))
        	    	sheetObj.CellBackColor(Row,"vndr_seq") =sheetObj.RgbColor(255,160,64);
                  sheetObj.CellBackColor(Row,"agmt_no") =sheetObj.RgbColor(255,160,64);
        	    } else {
        	      sheetObj.CellBackColor(Row,"vndr_seq") =sheetObj.RgbColor(255,255,255);
                  sheetObj.CellBackColor(Row,"agmt_no") =sheetObj.RgbColor(255,255,255);  
        	    }
        	}
        	
        	
        }     	
       if( sheetObj.ColSaveName(Col) == "lnk_org_nod_cd" ||  sheetObj.ColSaveName(Col) == "lnk_dest_nod_cd" ){
           if(sheetObj.CellValue(Row,"lnk_org_nod_cd").length == 7 && sheetObj.CellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
               var org = sheetObj.CellValue(Row,"lnk_org_nod_cd").substring(0,2);
               var des = sheetObj.CellValue(Row,"lnk_dest_nod_cd").substring(0,2);
               var trsp = sheetObj.CellValue(Row,"trsp_mod_cd"); 
               if( (org == "US" || org == "CA"  ) && (des == "US" || des == "CA"  ) && trsp =="RD" ) {
                   sheetObj.CellEditable(Row,"rail_crr_tp_cd") = true;
                   
    
               }else {
                   //미주이고 RAIL일때만  AGMT NO 입력가능 
                     if(!ComIsEmpty(sheetObj.CellValue(Row,"agmt_no"))  ) {
                 	    sheetObj.CellValue2(Row,"agmt_no")="";
                 	    sheetObj.CellValue2(Row,"refe_no")="";
            	        ComShowMessage(ComGetMsg('PRD90049'));
            	     }                   
               }
           }else {
               //미주이고 RAIL일때만  AGMT NO 입력가능 
                 if(!ComIsEmpty(sheetObj.CellValue(Row,"agmt_no"))  ) {
             	    sheetObj.CellValue2(Row,"agmt_no")="";
             	    sheetObj.CellValue2(Row,"refe_no")="";
        	        ComShowMessage(ComGetMsg('PRD90049'));
        	     }                  
           }           
       }

        
        /*
         * ROW ADD 일때 FROM,TO,MODE체크 
         */
        if(sheetObj.RowStatus(Row)=="I") {
            if(sheetObj.ColSaveName(Col) != "org_loc" && sheetObj.ColSaveName(Col) != "org_type" 
               && sheetObj.ColSaveName(Col) != "dest_loc" && sheetObj.ColSaveName(Col) != "dest_type" 
               && sheetObj.ColSaveName(Col) != "trsp_mod_cd") return;
            sheetObj.CellValue2(Row,"lnk_org_nod_cd")=sheetObj.CellValue(Row,"org_loc")  + sheetObj.CellValue(Row,"org_type");
            sheetObj.CellValue2(Row,"lnk_dest_nod_cd")=sheetObj.CellValue(Row,"dest_loc")  + sheetObj.CellValue(Row,"dest_type");

            // 노드 코드 검사 
            if(sheetObj.ColSaveName(Col)=="org_loc" || sheetObj.ColSaveName(Col)=="org_type" ) {
                if( sheetObj.CellValue(Row,"lnk_org_nod_cd").length == 7 ) {
                    //validateData 는 체크할 nod cd 
                    validateData = sheetObj.CellValue(Row,"lnk_org_nod_cd");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH04);
                    //rowcount 가 1보다 작으면 
                    sheetObj.CellValue2(Row,"org_is_door")=isDoor;
                    if(retValidate < 1) { //data가 없으면 
                        
                        sheetObj.CellValue2(Row,"org_loc")="";
                        sheetObj.CellValue2(Row,"org_type")="";
                        sheetObj.SelectCell(Row,"org_loc");
                    } 
                }                
            }

           
           if(sheetObj.ColSaveName(Col)=="dest_loc" || sheetObj.ColSaveName(Col)=="dest_type" ) {
                if( sheetObj.CellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
                    //validateData 는 체크할 nod cd 
                    validateData = sheetObj.CellValue(Row,"lnk_dest_nod_cd");
                    doActionIBSheet(sheetObjects[0],document.form, SEARCH04);
                    sheetObj.CellValue2(Row,"dest_is_door")=isDoor;
                    //rowcount 가 1보다 작으면 
                    if(retValidate < 1) {
                        sheetObj.CellValue2(Row,"dest_loc")="";
                        sheetObj.CellValue2(Row,"dest_type")="";
                        sheetObj.SelectCell(Row,"dest_loc");
                    } 
                }                
           }
           if(sheetObj.CellValue(Row,"org_is_door")=='true' || sheetObj.CellValue(Row,"dest_is_door")=='true') {
               sheetObj.CellValue2(Row,"trsp_mod_cd")="TD";
               sheetObj.CellEditable(Row,"trsp_mod_cd") = false;
           } else {
               sheetObj.CellEditable(Row,"trsp_mod_cd") = true;
               
           }
           
            if(sheetObj.CellValue(Row,"lnk_org_nod_cd")==sheetObj.CellValue(Row,"lnk_dest_nod_cd") ){
               // FROM , TO NODE 가 같으면 안된다. Destination node must be different from orgin node.
                
	            ComShowMessage(ComGetMsg('PRD90067'));
                sheetObj.CellValue2(Row,"dest_loc")="";
                sheetObj.CellValue2(Row,"dest_type")="";
                sheetObj.SelectCell(Row,"dest_loc");      
                         
                return false;
           }          
           //미주 검사 
           if(sheetObj.CellValue(Row,"lnk_org_nod_cd").length == 7 && sheetObj.CellValue(Row,"lnk_dest_nod_cd").length == 7 ) {
               var org = sheetObj.CellValue(Row,"lnk_org_nod_cd").substring(0,2);
               var des = sheetObj.CellValue(Row,"lnk_dest_nod_cd").substring(0,2);
               var trsp = sheetObj.CellValue(Row,"trsp_mod_cd"); 
               if( (org == "US" || org == "CA"  ) && (des == "US" || des == "CA"  ) && trsp =="RD" ) {
                   sheetObj.CellEditable(Row,"rail_crr_tp_cd") = true;
                   

               } 
           } 
            
          
        } //STATUS 가 I일때  

    }

    function setNodCd(sheetObj) {
        for( i=1; i<= sheetObj.RowCount; i++) {
            if(sheetObj.RowStatus(i)=="I") {
                sheetObj.CellValue2(i,"lnk_org_nod_cd")=sheetObj.CellValue(i,"org_loc")  + sheetObj.CellValue(i,"org_type");
                sheetObj.CellValue2(i,"lnk_dest_nod_cd")=sheetObj.CellValue(i,"dest_loc")  + sheetObj.CellValue(i,"dest_type");
            }
        }
    }           
    
    function getOrgLoc(rowArray) {    	
    	var colArray = rowArray[0];
    	document.all.i_org_cd.value = colArray[3];
    }
    
    function getDestLoc(rowArray) {    	
    	var colArray = rowArray[0];
    	document.all.i_dest_cd.value = colArray[3];
    }         

    // Location code 에 대한 validation
    function validateLocation(loc, num) {
    	if (num ==1) {
        	document.form.i_org_cd.value = loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.i_dest_cd.value = loc.toUpperCase();
    	}        
        validateData = loc.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form, SEARCH02);
    	
    	if(retValidate < 1) { //rowcount 가 1보다 작으면 
        	if (num ==1) {
            	//document.form.i_org_cd.value = "";
            	document.form.i_org_cd.focus();
        	}else {
        	    document.form.i_dest_cd.focus();
        	}
        	if (num ==2) {
            
        	}
    	}else {
        	if (num ==1) {
            	document.form.i_dest_cd.focus();
        	}
    	}
    	return false;

    }    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        return true;
    }
    
    function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
    
        for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){	
            var result = sheetObj.CellValue(i,"result");
            
            regexp=/fail/ig
            //alert(result.search(regexp));
            if(result.search(regexp)!= -1){

                  sheetObj.CellBackColor(i,"vndr_seq") =sheetObj.RgbColor(255,160,64);
                  sheetObj.CellBackColor(i,"agmt_no") =sheetObj.RgbColor(255,160,64);
                  sheetObj.CellBackColor(i,"sResult") =sheetObj.RgbColor(255,160,64);
                
            } 

        }       
    }
    
	   /*
     * retrieve 를 위한 입력조건 체크 
     */
     function checkInput() {
         var formObject = document.form;
         
         var i_org_cd = formObject.i_org_cd.value;
         var i_dest_cd = formObject.i_dest_cd.value;
         
       	 if (i_org_cd.length > 0 ){
        	 // if(!( i_org_cd.length ==5 || i_org_cd.length ==7)){
        	 // ComShowMessage(ComGetMsg('PRD90120','Origin','5 or 7'));
           	 // 메세지 변경. 2자리 이상입력으로 수정함.  2012.01.10 Kim Hyun Hwa
        	 if( i_org_cd.length <2 ){
           	    ComShowMessage(ComGetMsg('PRD90120','2'));
        		formObject.i_org_cd.select();
        		formObject.i_org_cd.focus();  
        		return false;
        	 }
         }else {
        	//ComShowMessage(ComGetMsg('PRD90120','Origin','5 or 7'));
        	ComShowMessage(ComGetMsg('PRD90120','2'));
     		formObject.i_org_cd.select();
     		formObject.i_org_cd.focus();  
     		return false;
         }
       	if (i_dest_cd.length > 0 ){
       		//if(!( i_dest_cd.length ==5 || i_dest_cd.length ==7)){
       		//	ComShowMessage(ComGetMsg('PRD90120','Destination','5 or 7'));
       		if( i_dest_cd.length <2 ){
       		    ComShowMessage(ComGetMsg('PRD90120','2'));
       			formObject.i_dest_cd.select();
       			formObject.i_dest_cd.focus();  
       			return false;
       		}
       	}else {
       		//ComShowMessage(ComGetMsg('PRD90120','Destination','5 or 7'));
       		ComShowMessage(ComGetMsg('PRD90120','2'));
   			formObject.i_dest_cd.select();
   			formObject.i_dest_cd.focus();  
   			return false;
       	}
     return true;
        
     }