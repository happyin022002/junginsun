/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0055.js
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
* 1.0 Creation
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
     * @class ESD_PRD_0055 : ESD_PRD_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ESD_PRD_0059() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheetMinimize			= sheetMinimize;
    	this.prdComKeyDown			= prdComKeyDown;
    	this.sheet1_OnDblClick		= sheet1_OnDblClick;
    	this.chkCombindMode			= chkCombindMode;
    	this.setCombindMode			= setCombindMode;
    	this.doActionIBSheet2		= doActionIBSheet2;
    	this.validateLocation		= validateLocation;
    	this.getCOM_ENS_051_1		= getCOM_ENS_051_1;
    	this.getOrgLoc				= getOrgLoc;
    	this.getDestLoc				= getDestLoc;
    	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
    	this.sheet2_OnPopupClick	= sheet2_OnPopupClick;
    	this.getVendor				= getVendor;
    	this.getNode				= getNode;
    	this.validateForm			= validateForm;
    	this.bottomFrmDisable		= bottomFrmDisable;
    	this.disableObjectR			= disableObjectR;
    	this.enableObjectR			= enableObjectR;
    	this.chkAmericanContinent	= chkAmericanContinent;
    	this.clearObjectN			= clearObjectN;
    	this.bottomFrmClear			= bottomFrmClear;
    	this.inputChkFromTo			= inputChkFromTo;
    	this.selectTml				= selectTml;
    	this.getCOM_ENS_061			= getCOM_ENS_061;
    	this.selectLoc				= selectLoc;
    	this.getCOM_ENS_051			= getCOM_ENS_051;
    	this.changeSelection		= changeSelection;
    	
}

// 공통전역변수

var tabObjects = new Array();
var sheetObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var sheetCnt = 0;
var maxPrioSeq = 0;
var i_origin = "";
var i_destination ="";
var validateData ="";
var retValidate = 0;
var priority_seq ="";
var min_state ='MIN';

var nodeCd = "";

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
    		
           //srcName= onEnterKey(srcName);
    		var keyObj=window.event.keyCode;
    		var srcObj=window.event.srcElement.nodeName;
           
           
            /****************************/
            
            switch(srcName) {

        	    case "btn_retrieve":
        	        
        	    	sheetObject1.RemoveAll();
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            
    	          
    	            if( !chkAmericanContinent(formObject)){
    	                //미주면 bottom form enable
        	            bottomFrmDisable(true);
    	            }else {
    	                bottomFrmDisable(false);
    	            }
                    bottomFrmClear(formObject);
    	            
    	            enableObjectR(formObject.i_bkg_flg);
    	            
    	           
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            formObject.reset();
        	        break;

                // 05. Location (COM_ENS_051)
                case "btn_org_loc":
 
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
 
        		   param = '?classId='+classId;
        			  
        		   chkStr = dispaly.substring(0,3);
                      
                       // radio PopUp  
                       if(chkStr == "1,0") {
                        
                           ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getOrgLoc', dispaly, true);
                       } else {
                           ComShowMessage(ComGetMsg('PRD90063'));
                           return;
                      }
                  break;
               case "btn_dest_loc":
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_0051";
        		   param = '?classId='+classId;
        			  
        		   chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
                       if(chkStr == "1,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getDestLoc', dispaly, true);
                       } else {
                           ComShowMessage(ComGetMsg('PRD90063'));
                           return;
                      }
                  break;
    	        
 			   case "ib_dest_loc_btn":
 			   		selectLoc(formObject,'IB_DEST_LOC');
 			   		break;        	                 
 			   case "ib_org_loc_btn":
 			   		selectLoc(formObject,'IB_ORG_LOC');
 			   		break;   
 			  case "btn_close":
	              window.close();
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
    
    
    function sheetMinimize(sheetObj){
    	var objs = document.all.item("minimize");
    	if( min_state == "MIN" ) {
    	    min_state = "MAX"
    		objs.style.display = "none";
    		sheetObj.style.height = sheetObj.GetSheetHeight(25);
    	} else {
    	    min_state = "MIN"
    		objs.style.display = "inline";
    		sheetObj.style.height = sheetObj.GetSheetHeight(6);
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        bottomFrmDisable(true);
		
		if(CRUD == "R") {
		}
		
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd', 'i_dest_cd');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'i_org_cd', 'i_dest_cd');
		axon_event.addListener('onblur', 'prdComOnBlur' , 'i_org_cd', 'i_dest_cd');
     }
     
     
   function prdComKeyDown(){
	   var keyObj=window.event.keyCode;
	   if(keyObj == 9){
    		var srcName = window.event.srcElement.getAttribute("name");
    		var thisObj = window.event.srcElement;
    		if(srcName == "i_org_cd"){
    			inputChkFromTo(thisObj, keyObj );
    		}else if(srcName == "i_dest_cd"){
    			inputChkUpper(thisObj,keyObj , 'SEARCH02');
    		}
    	}
	   
   }
   
   function prdComOnBlur(){
	  
	   return false;
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
                    style.height = GetSheetHeight(6) ;
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
                    InitColumnInfo(69, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Del.|BKG|STS|Constraint|Priority|ORG.LOC|Node|DEST.LOC|Node|Route|Tmp Flg|FreeInc|Total T/T|IO_BND_CD|N1ST_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N2ND_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N3RD_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N4TH_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N5TH_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N6TH_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N7TH_NODE|Creation office|Creation Date(YYYY-MM-DD)|Remarks|Rout Org Nod Cd|Rout Dest Nod Cd|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    var prefix = "";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   "delChk",                           false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox, 30,    daCenter,  false,   prefix + "inlnd_rout_bkg_flg",      false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtStatus,   30,    daCenter,  false,   "ibflag",                           false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtImage,    70,    daCenter,  false,   prefix + "cnst_flg",                false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,    70,    daCenter,  false,   prefix + "prio_seq",                true,           "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,   prefix + "org_loc",                 false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     30,    daCenter,  false,   prefix + "org_loc_type",            false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,   prefix + "dest_loc",                false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     30,    daCenter,  false,   prefix + "dest_loc_type",           false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     470,   daLeft,    false,   prefix + "route",                   false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     50,    daCenter,  false,   prefix +  "inlnd_rout_tmp_flg",     false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     50,    daCenter,  false,   prefix + "inlnd_rout_incl_sttl_flg",false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     70,    daCenter,  false,   prefix + "tot_tt",                  false,          "",       dfUserFormat2,  0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "io_bnd_cd",               false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_trsp_mod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_vndr_seq",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_vndr_nm",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_agmt_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_agmt_cre_ofc_cd",    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n1st_agmt_ref_no",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_trsp_mod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_vndr_seq",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_vndr_nm",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_agmt_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_agmt_cre_ofc_cd",    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n2nd_agmt_ref_no",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_trsp_mod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_vndr_seq",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_vndr_nm",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_agmt_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_agmt_cre_ofc_cd",    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n3rd_agmt_ref_no",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_trsp_mod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_vndr_seq",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_vndr_nm",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_agmt_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_agmt_cre_ofc_cd",    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n4th_agmt_ref_no",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_trsp_mod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_vndr_seq",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_vndr_nm",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_agmt_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_agmt_cre_ofc_cd",    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n5th_agmt_ref_no",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_trsp_mod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_vndr_seq",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_vndr_nm",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_agmt_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_agmt_cre_ofc_cd",    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n6th_agmt_ref_no",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "n7th_nod_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "cre_ofc_cd",              false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "cre_dt",                  false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "inlnd_rout_rmk",          false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "rout_org_nod_cd",         false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "rout_dest_nod_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "rout_seq",                false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "hub_search_gb",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "front_gb",                false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "undefine_nod",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "group_gubun",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,   prefix + "ori_prio_seq",            true,           "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   80,    daCenter,  false,   prefix + "cnst_rmk",                true,           "",       dfNone,    0,     true,       true);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo (0, prefix + "prio_seq", " |", " |");

                    InitUserFormat2(0, prefix + "tot_tt", "##D##H" , "D|H" );
                    ImageList(0) = "/hanjin/img/alps/ico_r.gif" ;
		            
					InitDataValid(0, "org_loc",       vtEngUpOther, "1234567890");
					InitDataValid(0, "org_loc_type",  vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc",      vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc_type", vtEngUpOther, "1234567890");
		            
					WaitImageVisible=false;
                }
                break;
            case 2:      //IBSheet2 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = GetSheetHeight(6) ;
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
                    InitColumnInfo(26, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //var HeadTitle = "Del.|STS|Seq.|      From Node|From Node|To Node|To Node|Mode|S/P Name|         T/T(D.H)  |Distanse|UOM|C/TOFC|                       Remark" ;
                    var HeadTitle = "Del.|STS|SEQ|Clear|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T(DD.HH)|AGMT No|Reference No|CombinedMode|C/TOFC|Junction|a|b|c|d|e|f|G|F|fc" ;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    var prefix = "";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  false,  "rnllws",                        false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtStatus,   30,    daCenter,  false,  "ibflag",                        false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,  false,  "ibseq",                         false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   40,    daCenter,  false,  prefix + "clear_chk",            false,          "",       dfNone,    0,     false,       true); //Clear
                    InitDataProperty(0, cnt++ , dtPopupEdit,60,    daCenter,  false,  prefix + "lnk_org_loc",          false,          "",       dfNone,    0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,     20,    daCenter,  false,  prefix + "lnk_org_type",         false,          "",       dfNone,    0,     false,       true,2);
                    InitDataProperty(0, cnt++ , dtPopupEdit,60,    daCenter,  false,  prefix + "lnk_dest_loc",         false,          "",       dfNone,    0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,     20,    daCenter,  false,  prefix + "lnk_dest_type",        false,          "",       dfNone,    0,     false,       true,2);
                    InitDataProperty(0, cnt++ , dtCombo,    60,    daCenter,  false,  prefix + "trsp_mod_cd",          false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,70,    daCenter,  false,  prefix + "vndr_seq",             true,           "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     150,   daLeft,    false,  prefix + "vndr_abbr_nm",         false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     70,    daCenter,  false,  prefix + "fmt_tztm_hrs",         false,          "",       dfUserFormat, 2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     70,    daCenter,  false,  prefix + "agmt_no",              false,          "",       dfNone,    0,     false,       false,9);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  false,  prefix + "refe_no",              false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox, 100,   daCenter,  false,  prefix + "combined_md",          false,          "",       dfNone,    0,     false,        true);
                    InitDataProperty(0, cnt++ , dtCombo,    85,    daLeft,    false,  prefix + "rail_crr_tp_cd",       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     50,    daCenter,  false,  prefix + "inlnd_rout_junc_nm",   false,          "",       dfNone,    0,     false,       true); //Junction
                    //-----hidden ---------------------
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "lnk_org_nod_cd",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "lnk_dest_nod_cd",      false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "clon_trsp_mod_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "rout_org_nod_cd",      false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "rout_dest_nod_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "rout_seq",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "rout_dtl_seq",         false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "selRow",               false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,  false,  prefix + "fc",                   false,          "",       dfNone,    0,     true,       true);

                    InitDataCombo(0,prefix + "trsp_mod_cd", trsp_mod_cdText, trsp_mod_cdCode);
                    InitDataCombo(0,prefix + "rail_crr_tp_cd", rail_crr_tp_cdText, rail_crr_tp_cdCode);
                    
                    InitUserFormat(0, prefix + "fmt_tztm_hrs", "##.##", "." );

					InitDataValid(0, "lnk_org_loc",   vtEngUpOther, "1234567890");
					InitDataValid(0, "lnk_org_type",  vtEngUpOther, "1234567890");
					InitDataValid(0, "lnk_dest_loc",  vtEngUpOther, "1234567890");
					InitDataValid(0, "lnk_dest_type", vtEngUpOther, "1234567890");
					InitDataValid(0, "vndr_seq",      vtEngUpOther, "1234567890");
                    
					WaitImageVisible=false;
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
           
               if(validateForm(sheetObj,formObj,sAction)); 
               if(!ComChkRequired(formObj))return;

               ComOpenWait(true);
               formObj.f_cmd.value = SEARCHLIST01;
               i_origin = formObj.i_org_cd.value;
               i_destination = formObj.i_dest_cd.value;
               var prefix = "";
               sheetObj.DoSearch4Post("ESD_PRD_0055GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam(""));
               priority_seq = sheetObjects[0].EtcData("prio_seq_combo");
               sheetObjects[0].InitDataCombo (0, prefix + "prio_seq", sheetObjects[0].EtcData("prio_seq_combo"),sheetObjects[0].EtcData("prio_seq_combo"));
               maxPrioSeq = sheetObjects[0].EtcData("maxPrioSeq");

               sheetObj.DoSearch4Post("ESD_PRD_0055GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam(""));
               ComOpenWait(false);
               
                break;
 
              
           case SEARCH02:
        	   ComOpenWait(true);
        	   formObj.f_cmd.value = SEARCH02;

              uid= "ESD_PRD_0055";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              ComOpenWait(false);
              break;              
           case SEARCH05:
        	   ComOpenWait(true);
        	   formObj.f_cmd.value = SEARCH05;
     
              uid= "ESD_PRD_0055";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              ComOpenWait(false);
              break; 
              
           case IBDOWNEXCEL:        //엑셀 다운로드

              sheetObj.Down2Excel(0, false, false, true);
              break;
        }
    }

 
    // sheet1 에서 클릭 이벤트 발생시 
    function sheet1_OnDblClick(sheetObj, row, col, value) {
        var formObj = document.form;
        formObj.i_selRow.value = row;
       
        // Alert - Constraint Remark
     
        ComShowMessage(sheetObj.CellValue(row, "cnst_rmk"));
        
        doActionIBSheet2(sheetObjects[1],formObj, IBSEARCH);  //sheetObjects[1]->sheet2
        
    }
 
 
 
    
    // SHEET1에서 더블클릭시 , SHEET2에서 저장시 CHECK


    function chkCombindMode(sheetObj){
            // inv billing,pattern 이 'C','S'로 시작하면 처음 rd 부터 끝rd 까지 combindmode를 체크 
            var formObj = document.form;
            var inv = formObj.i_inv.value;
            
            var firstRD = false;
            var lastRD  = false;
            var firstRow = 0;
            var lastRow = 0;
            var combindChk = true;

			var rdLink1 = false;
			var rdLink2 = false;
			var rdLink3 = false;
			
			var chkCnt = 0;
			var rdCnt = 0;
		
            //RD 인 첫번째(firstRow)와 마지막(lastRow) 로우를 찾는다 , rd의 카운트를 한다 
            if(inv.substring(0,1) == 'C' || inv.substring(0,1) == 'S') {
               
                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                    if( firstRD == false && sheetObj.CellValue(i, "trsp_mod_cd") == "RD" ) {
                        firstRD = true;
                        firstRow = i;
                        lastRow  = firstRow;
                        rdCnt++;
                    } else if(firstRD == true && sheetObj.CellValue(i, "trsp_mod_cd") == "RD")  {
                        lastRow = i ;
                        rdCnt++;
                    }
                    if(  sheetObj.CellValue(i,"combined_md")==1) chkCnt++;
                    
                    
                }      
                          
            
				//rd와 rd의 사이가 max 2,  RD링크의 max갯수는 3
				if( eval(lastRow-firstRow) > 2 || rdCnt > 3 ) {
	                combindChk = false;
	                ComShowCodeMessage('PRD90021');
	                return combindChk; 
				}
				
				// 이하는 rd와 rd사이의 max가 2이고, rd 갯수가 max 3 이하인 경우에만 적용하는 로직 
				
				// RD-RD-RD를 포함 할때 
				if( rdCnt == 3 && eval(lastRow-firstRow) == 2) {
					if(ComIsContainsChars(formObj.i_inv,"3")!=true) {
	                    ComShowCodeMessage('PRD90034');
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"combined_md")==1) {
	                		//rd 범위
	                		if( i < firstRow || i > lastRow) {
				                combindChk = false;
				                ComShowCodeMessage('PRD90021');
				                return combindChk;
	                		}
	                	} else {
	                		if( i >= firstRow && i <= lastRow) {
				                combindChk = false;
				                ComShowCodeMessage('PRD90021');
				                return combindChk;
	                		}
	                	}
	                	
	                }
	            // RD-RD를 포함 할때 
				} else if( rdCnt == 2 && eval(lastRow-firstRow)== 1){ // rd가 2개이고 연속된 rd 일때 
					if(ComIsContainsChars(formObj.i_inv,"2")!=true) {

	                    ComShowCodeMessage('PRD90034');
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"combined_md")==1) {
	                		//rd 범위밖 
	                		if( i < firstRow || i > lastRow) {
				                combindChk = false;
				                ComShowCodeMessage('PRD90021');
				                return combindChk;
	                		}
	                	} else {
	                		if( i >= firstRow && i <= lastRow) {
				                combindChk = false;
				                ComShowCodeMessage('PRD90021');
				                return combindChk;
	                		}
	                	}
	                }
	            // rd가 2개이고 RD-TD-RD 일때 
				} else if( rdCnt == 2 && eval(lastRow-firstRow)== 2){ 
					if(ComIsContainsChars(formObj.i_inv,"1")!=true) {
	                    ComShowCodeMessage('PRD90034');
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"combined_md")==1) {
			                combindChk = false;
			                ComShowCodeMessage('PRD90021');
			                return combindChk;
	                	}
	                }
				} else if( rdCnt == 1 ){ 
					if(ComIsContainsChars(formObj.i_inv,"1")!=true) {
	                    ComShowCodeMessage('PRD90034');
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"combined_md")==1) {
			                combindChk = false;
			                ComShowCodeMessage('PRD90021');
			                return combindChk;
	                	}
	                }
				} else if( rdCnt == 0 ){ 
	                var invIdx = formObj.i_inv.selectedIndex;
					if(invIdx >0) {
	                    ComShowCodeMessage('PRD90034');
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"combined_md")==1) {
			                combindChk = false;
			                ComShowCodeMessage('PRD90021');
			                return combindChk;
	                	}
	                }
				}

                              
            } else { // inv billing,pattern 이 'C','S'가 아닐때 combind mode 가 셋팅 되있으면 sp가 같은지 확인 
                var sp = '';
                var firstCombindMode = false;
                var firstCombindCnt = 0;
                for(var j = sheetObj.HeaderRows ; j < sheetObj.Rows ; j++) {
                    if( sheetObj.CellValue(j,"combined_md")==1 && firstCombindMode == false && sheetObj.RowCount > 1){ //첫번쨰 combind면 
                        sp = sheetObj.CellValue(j, "vndr_seq");
                        firstCombindMode = true;
                        firstCombindCnt ++;
                    } else if(sheetObj.CellValue(j,"combined_md")==1 && firstCombindMode == true && sheetObj.RowCount > 1 ) {   //두번째 이후 combind면                         
                        if( sp != sheetObj.CellValue(j, "vndr_seq") ) {

                            ComShowCodeMessage('PRD90022');
                            combindChk = false;
                            return combindChk;   
                        }
                    } else if(sheetObj.CellValue(j,"combined_md")==1 && sheetObj.RowCount ==1 ) {  // 데이터가 1건만 있는데 체크할때 

                            ComShowCodeMessage('PRD90023');
                            combindChk = false;
                            return combindChk;   
                    } else if( firstCombindMode == true && firstCombindCnt <2 ){ // 체크된게 1건일때 

                            ComShowCodeMessage('PRD90024');
                            combindChk = false;
                            return combindChk;  
                    }
                }//for 
            }
            
            return combindChk;  
            
    }    
    
    // INV Billing 을 선택했을때 .
    function setCombindMode() {
        var sheetObj = sheetObjects[1];
        var formObj = document.form;
            var inv = formObj.i_inv.value;
            
            var firstRD = false;
            var lastRD  = false;
            var firstRow = 0;
            var lastRow = 0;

            sheetObj.CheckAll("combined_md") = 0;
            //RD 인 첫번째와 마지막 로우를 찾는다 
            if(inv.substring(0,1) == 'C' || inv.substring(0,1) == 'S') {

                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                    if( firstRD == false && sheetObj.CellValue(i, "trsp_mod_cd") == "RD" ) {
                        firstRD = true;
                        firstRow = i;
                        lastRow  = firstRow;
                    } else if(firstRD == true && sheetObj.CellValue(i, "trsp_mod_cd") == "RD")  {
                        lastRow = i ;
                    }
                    
                }                  
                
                //ComShowMessage("lastRow:["+lastRow+"] -firstRD:["+firstRow + "] ="+ eval(lastRow-firstRow) +" inv:"+inv);
            
                //RD 처음 과 끝 사이를  체크 (RTR일때는 체크하지 않는다, RD가 하나일떄도 체크하지 않는다.)
                if( firstRow > 0){
                     for(j=firstRow ; j<= lastRow ; j++) {
                        //RD가 2개 또는 세개일때만 체크  
                        if(eval(lastRow-firstRow)==1 || eval(lastRow-firstRow)==2  ) {
                            sheetObj.CellValue2(j,"combined_md")=1;
                        }
                    }                   
                }

                
                              
            }
            
    }
    
    // Sheet2 관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        
        // 상세 조회시 hub를 통한 링크를 event에 담아 두었다가 디테일에 표시 하기 위해 
        var rout_org_nod_cd  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_org_nod_cd") ;
        var rout_dest_nod_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_dest_nod_cd") ;
        
        var rout_seq      = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_seq") ;
        var hub_search_gb = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"hub_search_gb") ;
        var front_gb      = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"front_gb") ;
        var undefine_nod  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"undefine_nod") ;

        switch(sAction) {

           case IBSEARCH:      //Sheet1에서 클릭시 상세 조회 ->Sheet2에 표시 
                if(validateForm(sheetObj,formObj,sAction));
           		ComOpenWait(true);

               formObj.f_cmd.value = SEARCH;
               
               // 상세 조회시 hub를 통한 링크를 event에 담아 두었다가 디테일에 표시 하기 위해 --------------------
               formObj.i_rout_org_nod_cd.value = rout_org_nod_cd;
               formObj.i_rout_dest_nod_cd.value = rout_dest_nod_cd;
               formObj.i_rout_seq.value = rout_seq;
               formObj.i_hub_search_gb.value = hub_search_gb;
               formObj.i_front_gb.value = front_gb;
               formObj.i_undefine_nod.value = undefine_nod;
               //------------------------------------------------------------------------------------------
               
               sheetObj.DoSearch4Post("ESD_PRD_0055GS.do", PrdFQString(formObj));

               ComEtcDataToForm(formObj,sheetObj);
               chkCombindMode(sheetObj);
               
               if (formObj.disable_bkg_flg.value == 'F')
            	   ComEnableObject(formObj.i_bkg_flg,false);
               else 
            	   ComEnableObject(formObj.i_bkg_flg,true);
                  
               ComOpenWait(false);
               break;
               
        }
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
            	document.form.i_route_rmk.focus();
        	}else if (num ==2) {
            	//document.form.i_dest_cd.value = "";
            	document.form.i_dest_cd.focus();
        	}
    	}else {
        	if (num ==1) {
            	//document.form.i_org_cd.value = "";
            	document.form.i_dest_cd.focus();
        	}
    	}
    	return false;

    }  
    


        
    function getCOM_ENS_051_1(rowArray) {	
    	var colArray = rowArray[0];
    
    	document.all.i_org_cd.value = colArray[3];
    
    }
    
    function getOrgLoc(rowArray) {
    	
    	var colArray = rowArray[0];
    	document.all.i_org_cd.value = colArray[3];
    }

    function getDestLoc(rowArray) {
    	
    	var colArray = rowArray[0];
    	document.all.i_dest_cd.value = colArray[3];
    }
        

    
	
	
	/**
	 * 2009.07.31
	 * kim kwi-jin 추가
	 * 
	 */
	function sheet2_OnSearchEnd(sheetObj){
		//alert(sheet2.TotalRows );
		
		var formObj = document.form;
		
		for(var i=1;i<=sheetObj.TotalRows;i++){
			if(formObj.i_hub_search_gb.value == "Y"){
				sheetObj.CellValue2(i, "rnllws" )= 'R';
				sheetObj.RowStatus(i)= 'I';
			}
			
			if(sheetObj.CellValue(i,"fc") == "T"){
				sheetObj.CellEditable(i, "rail_crr_tp_cd") = true;
			}else{
				sheetObj.CellEditable(i, "rail_crr_tp_cd") = false;
			}	
			
		}
		
		
		if(formObj.i_hub_search_gb.value == "Y"){
		
			if(formObj.i_front_gb.value == "F"){
				var Row = sheetObj.DataInsert(0);
				sheetObj.CellValue2(Row, "rnllws" )= 'R';
				sheetObj.RowStatus(Row)= 'I';
				
				sheetObj.CellValue2(Row, "lnk_org_loc" )= formObj.i_rout_dest_nod_cd.value.substr(0,5);
				sheetObj.CellValue2(Row, "lnk_org_type" )= formObj.i_rout_dest_nod_cd.value.substr(5);
				sheetObj.CellValue2(Row, "lnk_dest_loc" )= formObj.i_undefine_nod.value.substr(0,5);
				sheetObj.CellValue2(Row, "lnk_dest_type" )= formObj.i_undefine_nod.value.substr(5);
				sheetObj.CellValue2(Row, "i_selRow" )= formObj.i_selRow.value;
				
				
			}
			
			
			
			
			
			if(formObj.i_front_gb.value == "B"){
				var Row = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(Row, "rnllws" )= 'R';
				sheetObj.RowStatus(Row)= 'I';
				
				sheetObj.CellValue2(Row, "lnk_org_loc" )= formObj.i_rout_dest_nod_cd.value.substr(0,5);
				sheetObj.CellValue2(Row, "lnk_org_type" )= formObj.i_rout_dest_nod_cd.value.substr(5);
				sheetObj.CellValue2(Row, "lnk_dest_loc" )= formObj.i_undefine_nod.value.substr(0,5);
				sheetObj.CellValue2(Row, "lnk_dest_type" )= formObj.i_undefine_nod.value.substr(5);
				sheetObj.CellValue2(Row, "i_selRow" )= formObj.i_selRow.value;
				
			}
		}
	
		
	}
 

/**
 * 시트에서 Biz 공통 팝업 호출
 * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달  
 */
    function sheet2_OnPopupClick(sheetObj, row, col){
	    var loc_cd_val ;
	    var dispaly ;
	    var classId ;
	    var param ;
	    var chkStr ;
        if ( sheetObj.ColSaveName(col) == "lnk_org_loc" || sheetObj.ColSaveName(col) == "lnk_dest_loc" )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
           
            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_0061";
    	    param = '?loc_cd='+loc_cd_val+'&classId='+classId;
    		  
    	    chkStr = dispaly.substring(0,3)          
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col);
        }
        
        if ( sheetObj.ColSaveName(col) == "vndr_seq"  )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
           
            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_00C1";
    	    param = '?pts_vndr_cd='+loc_cd_val+'&classId='+classId;
    		  
    	    chkStr = dispaly.substring(0,3)          
            
            // Radio PopUp  
            if(chkStr == "1,0") {
            	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVendor', dispaly, true, false, row, col);
           
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }    
     }    
     
     function getVendor(rowArray, row, col) {
        var sheetObj = sheetObjects[1];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(row, "vndr_seq") = colArray[6];
    	sheetObj.CellValue2(row, "vndr_abbr_nm") = colArray[7];
    	
    }
     
/**
 * Location : 팝업에서 Radio로 단일 선택을 한경우..
 */
    function getNode(rowArray, row, col) {
        var sheetObj = sheetObjects[1];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(row, col+1) = colArray[3].substring(5);
    	sheetObj.CellValue2(row, col) = colArray[3].substring(0,5);
    	
    }

    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){


        return true;
    }
     
     /**
     * 화면 하단 폼입력값 disable처리
     */
    function bottomFrmDisable(gb) {
        var formObj = document.form;
        if(gb){
            disableObjectR(formObj.i_inv);
            disableObjectR(formObj.i_rout_pln_cd);
            disableObjectR(formObj.i_wrs_fl_cd);
            disableObjectR(formObj.i_wrs_mt_cd);
            
        } else{
            enableObjectR(formObj.i_inv);
            enableObjectR(formObj.i_rout_pln_cd);
            enableObjectR(formObj.i_wrs_fl_cd);
            enableObjectR(formObj.i_wrs_mt_cd);
        }
    }
     
     function disableObjectR(obj){
    	 obj.disabled = true;

     }
     
     function enableObjectR(obj){
    	 obj.disabled = false;
     }
    
    function chkAmericanContinent(formObj) {
        var org  = formObj.i_org_cd.value.substring(0,2);
        var des  = formObj.i_dest_cd.value.substring(0,2);
        
        if( (org == "US" || org == "CA"  ) && (des == "US" || des == "CA"  )) {
            return true;
        }
        
        return false;
        
        
    }
    
    /**
     * 대상 Object의 value값을 초기화 시킨다.
     * @param obj   대상 폼태그(Object)
     * @return
    */
   function clearObjectN(obj)
   {
       switch( obj.type ) {
           case "select-one" :
                obj.selectedIndex='0';
           case "radio" :
		    case "checkbox" :
                obj.checked=false;
                break;
           case "text" :
           case "password" :
                obj.readOnly=false;
                obj.value="";
                break;
           default:
       } // end switch
   }
    
    function bottomFrmClear(formObj) {
        clearObjectN(formObj.i_inv);
        clearObjectN(formObj.i_rout_pln_cd);
        clearObjectN(formObj.i_wrs_fl_cd);
        clearObjectN(formObj.i_wrs_mt_cd);
        clearObjectN(formObj.i_route_rmk);
       
    }
    
    function inputChkFromTo(obj, e){
    	var objNm = obj.name;
        var objVal = eval('document.form.'+objNm+'.value');
        var objEle = eval('document.form.'+objNm);
        var cmd='';
    	re = /^[a-zA-Z0-9]+$/; 
    	te = /\t/;
        validateData = objVal.toUpperCase();   
    	if(e==9) {
    	    if(objVal.length>0) {
    	        if(objVal.length==5 ) { 
    	            cmd = 'SEARCH02';
        		    doActionIBSheet(sheetObjects[0],document.form,SEARCH02);  
    	        }else if(objVal.length==7 ) {
    	            cmd = 'SEARCH05';
        		    doActionIBSheet(sheetObjects[0],document.form,SEARCH05);  
    	        }
    	        
    	        if(retValidate < 1 && cmd !="") {
                    objEle.focus();
                    return false;
            	} else {
            	    // 다음 포커스로 이동 
                    tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
                    if (tmp == null) tmp = GetObjectByTabIndex(document.form,1);
                    if (tmp != null) {
                        if(tmp.type =='select-one') {
                            tmp.selectedIndex ;
                        }else {
                            
                            tmp.select();
                        }                     
                        tmp.focus();
                    }
                    //objEle.focus();    
                    return false;
            	}    	        
    	        
    	    }
            else {
                    	    // 다음 포커스로 이동 
                            tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
                            if (tmp == null) tmp = GetObjectByTabIndex(document.form,1); 
                            
                            if (tmp != null) {
                                tmp.select(); 		        
                                tmp.focus(); 		        
                            }
                            return false;
            	    }    	      
    	} 
        else 
        	if (e==8 || e==46 || (e>=37 && e<=40)){
        	} else {
        	    if(objVal.length>0) {
        		    //대문자로 변경, 알파벳,숫자인지 체크 
        			if(re.test(objVal)) {
        			    objEle.value  = objVal.toUpperCase();
                        return false;
        			} else {
        			    ComShowMessage(ComGetMsg('PRD90016'));
        			}		        
        	    }
        
        	}    	          
    }  
	
	var portInd = '';
	function selectTml(frm, pt) {
		portInd = pt;
		if(pt == 'IB_ORG_TML')  param = "?node_cd="+frm.i_org_cd_ib.value;
		if(pt == 'OB_DEST_TML') param = "?node_cd="+frm.i_dest_cd_ob.value;
		if(pt == 'TS_ORG_YD')   param = "?node_cd="+frm.i_org_cd_ts.value;
		if(pt == 'TS_DEST_YD')  param = "?node_cd="+frm.i_dest_cd_ts.value;
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	
	function getCOM_ENS_061(rArray) {
		var cArray  =  rArray [0];	
		var frm = document.form;
		if(portInd == 'IB_ORG_TML'){
			 frm.i_org_cd_ib.value = cArray[3];
		}
		if(portInd == 'OB_DEST_TML'){
			 frm.i_dest_cd_ob.value = cArray[3];
		}
		if(portInd == 'TS_ORG_YD'){
			 frm.i_org_cd_ts.value = cArray[3];
		}
		if(portInd == 'TS_DEST_YD'){
			 frm.i_dest_cd_ts.value = cArray[3];
		}							
	}
	function selectLoc(frm, pt) {
		portInd = pt;
		if(pt == 'IB_DEST_LOC') param = "?loc_cd="+frm.i_dest_cd.value;
		if(pt == 'IB_ORG_LOC') param = "?loc_cd="+frm.i_org_cd.value;
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	
	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];	
		var frm = document.form;
		if(portInd == 'IB_DEST_LOC'){
			 frm.i_dest_cd.value = cArray[3];
		}	
		if(portInd == 'IB_ORG_LOC'){
			 frm.i_org_cd.value = cArray[3];
		}			
	}	

    
	function changeSelection(gubun){
	    document.form.rBtnIrgCd.value = gubun;
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
	}   