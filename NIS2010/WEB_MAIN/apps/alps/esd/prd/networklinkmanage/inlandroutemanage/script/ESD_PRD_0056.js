/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0056.js
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
* 1.0 Creation
* 1. 2011.01.18 이수진  [CHM-201108245-01] PRD내 Service Provide Inquiry 화면 변경 요청 
*    =>  List Link 버튼 클릭 시 및 하단 Grid의 S/P값 변경
*        (기존에는 Vendor Seq.를 선택하면 Parent Vendor Seq.를 보여줬었는데 자기 자신의 Vendor Seq.가 보이도록 수정)
* 2011.02.14 정선용 [CHM-201108587-01] Inland Link Management 및 Hub Location Management
* 2011.03.10 채창호 [CHM-201109187-01] Network Link 산하 기능의 입력/조회에 대한 Alert Message 변경 요청. 
* 2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
* 2012.10.17 김진승 [CHM-201220713][PRD] O5 CNTR 추가로 인한 PRD 상 변경사항
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
     * @class ESD_PRD_0056 : ESD_PRD_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0056() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
	this.sheetMinimize			= sheetMinimize;
	this.doIBSheetClear			= doIBSheetClear;
	this.sheet1_OnDblClick		= sheet1_OnDblClick;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
	this.chkMandatoryForAmerican	= chkMandatoryForAmerican;
	this.chkCombindMode			= chkMandatoryForAmerican;
	this.setCombindMode			= setCombindMode;
	this.doActionIBSheet2		= doActionIBSheet2;
	this.checkFromTo4US			= checkFromTo4US;
	this.chkRailLinkForMt		= chkRailLinkForMt;
	this.checkWRS				= checkWRS;
	this.checkMandatory			= checkMandatory;
	this.checkRouteList			= checkRouteList;
	this.validateLocation		= validateLocation;
	this.checkSpChange			= checkSpChange;
	this.checkJunk				= checkJunk;
	this.checkRoute2			= checkRoute2;
	this.checkRoute4Mt			= checkRoute4Mt;
	this.checkRoute3			= checkRoute3;
	this.checkLocCondition		= checkLocCondition;
	this.checkDtlLocCondition	= checkDtlLocCondition;
	this.getCOM_ENS_051_1		= getCOM_ENS_051_1;
	this.getOrgLoc				= getOrgLoc;
	this.getDestLoc				= getDestLoc;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.sheet2_OnChange		= sheet2_OnChange;
	this.sheet2_OnPopupClick	= sheet2_OnPopupClick;
	this.getVendor				= getVendor;
	this.getNode				= getNode;
	this.bottomFrmDisable		= bottomFrmDisable;
	this.chkAmericanContinent	= chkAmericanContinent;
	this.bottomFrmClear			= bottomFrmClear;
	this.changeNodTy1			= changeNodTy1;
	this.changeNodTy2			= changeNodTy2;
	this.changeSelection		= changeSelection;
	this.setWRS					= setWRS;;
	this.selectTml				= selectTml;
	this.getCOM_ENS_061			= getCOM_ENS_061;
	this.selectLoc				= selectLoc;
	this.getCOM_ENS_051			= getCOM_ENS_051;
	this.sheet1_OnSelectMenu	= sheet1_OnSelectMenu;
	this.changeDeltFlg			= changeDeltFlg;
	
}


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var maxPrioSeq = 0;
var i_origin = "";
var i_destination ="";
var validateData ="";
var retValidate = 0;
var priority_seq ="";

var comData1 ="";
var comData2 ="";

var min_state ='MIN';
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
    function setUpperCase(formObject) {
        formObject.from_cd.value=formObject.from_cd.value.toUpperCase();
        formObject.to_cd.value=formObject.to_cd.value.toUpperCase();
    }
    
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
        	        setUpperCase(formObject);
        	        if(!checkInput()) return false;
        	        
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);

    	            sheetObject1.RemoveAll();

        	        break;

        	    case "btn_new":
        	        
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            
    	            var cntCd = formObject.cnt_cd.value;
    	            formObject.reset();
    	            formObject.cnt_cd.value = cntCd;
    	            
        	        break;

        	    case "btn_routelist":
//    	            param = '?i_org_cd='+formObject.i_org_cd.value +'&i_dest_cd='+formObject.i_dest_cd.value+'&r_inbound='+formObject.rBtnIrgCd.value+'&nod_tp1='+formObject.rBtnNodTyCd1.value+'&nod_tp2='+formObject.rBtnNodTyCd2.value;
//    	            myWin = ComOpenWindowCenter('ESD_PRD_0006.do'+param , 'compop', 760, 480, true);
//		            myWin.focus();
//        	        break;

        	    case "btn_save":
                
    	             doActionIBSheet(sheetObject,formObject,IBSAVE);
    	             sheetObject1.RemoveAll();
    	            
    	             bottomFrmClear(formObject);
  
        	         break;
        	         
    			case "btn_minimize":
    				sheetMinimize(sheetObject);
    			break;
    			
        	    case "btng_listlink":
        	        var oriLoc =  "";
                    var destLoc =  "";


        	        if(sheetObject1.LastRow != 0 ) {

                        oriLoc =  sheetObject1.CellValue(sheetObject1.SelectRow ,"lnk_org_loc");
                        destLoc =  sheetObject1.CellValue(sheetObject1.SelectRow ,"lnk_dest_loc");
        	        } else {
        	            sheetObject1.DataInsert(-1); 
        	        }

    	          
    	            param = '?i_org_cd='+ oriLoc +'&i_dest_cd='+destLoc+"&row=" + sheetObject1.SelectRow + "&col=" + sheetObject1.SelectCol;
        	        myWin = ComOpenWindowCenter('ESD_PRD_0007.do'+param, 'compop', 750, 480, false,true);
		            myWin.focus();
        	        break;

          	    case "btng_save":
          	        if(chkCombindMode(sheetObject1)) {
            	        doActionIBSheet2(sheetObject1,formObject,IBSAVE);          	            
          	        }
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet2(sheetObject1,formObject,IBINSERT);
        	        break;

          	    case "btng_rowcopy":
              	    //if(!checkAdd(sheetObject)) return;
        	       doActionIBSheet2(sheetObject1,formObject,IBCOPYROW);
        	        break;
        	        
                // 05. Location (COM_ENS_051)
                case "btn_org_loc":
                	
                    /*
                   var conti_cd_val = com_ens_051_conti_cd.value;
                   var sconti_cd_val = com_ens_051_sconti_cd.value;
                   var cnt_cd_val = com_ens_051_cnt_cd.value;
                   var loc_state_val = com_ens_051_loc_state.value;
                   var loc_eq_ofc_val = com_ens_051_loc_eq_ofc.value;
                   var loc_cd_val = com_ens_051_loc_cd.value;
                   var loc_desc_val = com_ens_051_loc_desc.value;
                   
                   var loc_port_ind_val = "";
                   if(com_ens_051_loc_port_ind.checked) {
                       loc_port_ind_val = "1";
                   } else {
                       loc_port_ind_val = "0";
                   }
                   */
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
        		 
        		   param = '?classId='+classId;
        			  
        		   chkStr = dispaly.substring(0,3);
                      
                       // radio PopUp  
                       if(chkStr == "1,0") {
                    	 
                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getOrgLoc', dispaly, true);
                       } else {
                           ComShowMessage(ComGetMst('PRD90063'));
                           return;
                      }
                  break;
               case "btn_dest_loc":
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
        		   param = '?classId='+classId;
        			  
        		   chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
                       if(chkStr == "1,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getDestLoc', dispaly, true);
                       } else {
                           ComShowMessage(ComGetMst('PRD90063'));
                           return;
                      }
                  break;
        	   case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;                  
                  
               case "btng_clear":
                 
                  sheetObject1.RowDelete(sheetObject1.LastRow) 
                  break;
                  
        	   case "btng_new":
                    
    	            sheetObject1.RemoveAll();

    	            bottomFrmClear(formObject);

        	        break;         
        	        
        	        
               case "btng_saveas" :
                    if(!confirm(ComGetMsg('PRD90043'))) {
                        break;
                    };
                    if(!chkCombindMode(sheetObject1)) {
                        break;
          	        }
          	        // 미주시 체크 
                    var invIdx = formObject.i_inv.selectedIndex;
                    if(chkAmericanContinent(formObject) && !chkMandatoryForAmerican(formObject, sheetObject1) ) {
                        break;
                    }
                    
                    // 연결이 맞는지 확인 
                    if(!checkRoute3(sheetObject1,formObject)) {
                        break;
                    }


           	        doActionIBSheet2(sheetObject1,formObject, MULTI02);  
           	                	            
                    break;
 			   case "ib_org_tml_btn":
 			   		selectTml(formObject,'IB_ORG_TML');
 			   		break;    
 			   case "ob_dest_tml_btn":
 			   		selectTml(formObject,'OB_DEST_TML');
 			   		break; 	
 			   		 			   		 	        
 			   case "ib_dest_loc_btn":
 			   		selectLoc(formObject,'IB_DEST_LOC');
 			   		break;        	                 
 			   case "ob_org_loc_btn":
 			   		selectLoc(formObject,'OB_ORG_LOC');
 			   		break;     	        

 			   case "ts_org_yd_btn":
 			   		selectTml(formObject,'TS_ORG_YD');
 			   		break;     	        
 			   case "ts_dest_yd_btn":
 			   		selectTml(formObject,'TS_DEST_YD');
 			   		break; 
 			   case "mt_org_yd_btn":
 			   		selectTml(formObject,'MT_ORG_YD');
 			   		break;     	        
 			   case "mt_dest_yd_btn":
 			   		selectTml(formObject,'MT_DEST_YD');
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
    		sheetObj.style.height = sheetObj.GetSheetHeight(22);
    	} else {
    	    min_state = "MIN"
    		objs.style.display = "inline";
    		sheetObj.style.height = sheetObj.GetSheetHeight(10);
    	}        
    }
    
    function doIBSheetClear(sheetObj) {
        var firstChk = false;
        var firstChkRow = 0;

        for( i=1; i<=+sheetObj.RowCount; i++) {
            //ComShowMessage("row i:"+i+', check value:'+ sheetObj.CellValue(i,"clear_chk"));

            if(firstChk ==true && i> firstChkRow && sheetObj.CellValue(i,"clear_chk")!=1 ){
                 sheetObj.CellValue2(i,"clear_chk")=1;
                 
            }

            if(sheetObj.CellValue(i,"clear_chk")==1){
                if(firstChk ==false){
                    firstChk = true;
                    firstChkRow = i;

                }

                sheetObj.CellValue2(i,"lnk_org_loc")="";
                sheetObj.CellValue2(i,"lnk_org_type")="";
                sheetObj.CellValue2(i,"lnk_dest_loc")="";
                sheetObj.CellValue2(i,"lnk_dest_type")="";
                sheetObj.CellValue2(i,"trsp_mod_cd")="";
                sheetObj.CellValue2(i,"spname")="";
                sheetObj.CellValue2(i,"vndr_seq")="";
                sheetObj.CellValue2(i,"vndr_name")="";
                sheetObj.CellValue2(i,"tztm_hrs")="";

                sheetObj.CellValue2(i,"rail_crr_tp_cd")="";
   
                sheetObj.CellValue2(i,"inlnd_rout_junc_nm")="";
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

        //ComEnableObject(document.getElementById("btng_clear"), false);
       // ComEnableObject(document.getElementById("btng_new"), false);
		
		if(CRUD == "R") {
			ComBtnDisable("btn_save");
			ComBtnDisable("btng_save");
			ComBtnDisable("btng_listlink");
			ComBtnDisable("btng_rowadd");
			ComBtnDisable("btng_clear");
//			ComEnableObject(document.getElementById("btn_save"), false);
//			ComEnableObject(document.getElementById("btng_save"), false);
//			ComEnableObject(document.getElementById("btng_listlink"), false);
//			ComEnableObject(document.getElementById("btng_rowadd"), false);
//			ComEnableObject(document.getElementById("btng_clear"), false);
		}

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'from_cd', 'to_cd');
		
		//2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
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
                    style.height = GetSheetHeight(11) ;
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
                    InitColumnInfo(36, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Del.|WRS|CHK|STS|ORG.LOC|Node|DEST.LOC|Node|INV Billing Patten|Route Plan|C/TOFC|Junction|C.User|C.Date|U.User|U.Date|D.User|D.Date|Constaint Y/N|Remarks" ;
                    HeadTitle += "|D2|D4|D5|D7|O2|O4|O5|A2|A4|A5|R2|R5|R8";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, >>EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "delChk",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,  false,    "wrs_chk",       false,  "",       dfNone,     0,     true,       true, -1,false,true,"",true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,    "un_del",        false,  "",       dfNone,     0,     true,       true, -1, false, true, "undelete", false);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",        false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "ori_loc",       false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  false,    "ori_loc_type",  false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "dest_loc",      false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  false,    "dest_loc_type", false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      100,   daCenter,  false,    "inv_bl_pt",     false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  false,    "rout_pl",       false,  "",       dfNone,     0,     false,       true,1);
                    InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,  false,    "c_tofc",        false,  "",       dfNone,     0,     false,       true,1 ,false,true,"Free shuttle move include");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    "junc",          false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    "cre_id",        false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  false,    "cre_date",      false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    "upd_id",        false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  false,    "upd_date",      false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  false,    "del_id",        false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     100,   daCenter,  false,    "del_date",      false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  false,    "constraint",    false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       200,   daLeft,    false,    "remark",        false,  "",       dfNone,     0,     false,       true);
                    // CNTR TYPE/SIZE CAPACITY FLAG - ADD BY SJ
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "d2_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "d4_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "d5_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "d7_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "o2_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "o4_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "o5_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "a2_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "a4_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "a5_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    //090106 add by jsy
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "r2_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "r5_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "r8_flg",        false,  "",       dfNone,     0,     true,       true, -1,false,true,"",false);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "rout_org_nod_cd", false,  "",     dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "rout_dest_nod_cd",false,  "",     dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,    "rout_seq",      false,  "",       dfNone,     0,     false,       true);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo(0, "inv_bl_pt", inv_bill_ptnCode, inv_bill_ptnCode);
                    InitDataCombo(0, "rout_pl", rout_planCode, rout_planCode);
                    InitDataCombo(0, "c_tofc", rail_crr_tp_cdCode, rail_crr_tp_cdCode);

                    HeadRowHeight = 25;

                    ActionMenu ="Check|Uncheck";   // Action Menu - OnSelectMenu Event 발생.
       
                    MultiSelection = true;         // Multi-Selection
                    SelectionMode = smSelectionFree;   // Cel 단위 선택

					InitDataValid(0, "ori_loc",       vtEngUpOther, "1234567890");
					InitDataValid(0, "ori_loc_type",  vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc",      vtEngUpOther, "1234567890");
					InitDataValid(0, "dest_loc_type", vtEngUpOther, "1234567890");
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
                    InitColumnInfo(29, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //var HeadTitle = "Del.|STS|Seq.|      From Node|From Node|To Node|To Node|Mode|S/P Name|         T/T(D.H)  |Distanse|UOM|C/TOFC|                       Remark" ;
                    var HeadTitle = "Del.|STS|SEQ|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T(DD.HH)|AGMT No|Reference No|CombinedMode|C/TOFC|Junction|lnk_org_nod_cd|lnk_dest_nod_cd|clon_trsp_mod_cd|rout_org_nod_cd|rout_dest_nod_cd|rout_seq|rout_dtl_seq|selRow|clon_vndr_seq|clon_agmt_no|clon_combined_md|clon_rail_crr_tp_cd|clon_inlnd_rout_junc_nm" ;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  false,    "",                   false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,       30,    daCenter,  false,    "ibflag",             false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,  false,    "ibseq",              false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,    60,    daCenter,  false,    "lnk_org_loc",        false,  "",       dfNone,    0,     true,       true,5);
                    InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  false,    "lnk_org_type",       false,  "",       dfNone,    0,     true,       true,2);
                    InitDataProperty(0, cnt++ , dtPopupEdit,    60,    daCenter,  false,    "lnk_dest_loc",       false,  "",       dfNone,    0,     true,       true,5);
                    InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  false,    "lnk_dest_type",      false,  "",       dfNone,    0,     true,       true,2);
                    InitDataProperty(0, cnt++ , dtCombo,        60,    daCenter,  false,    "trsp_mod_cd",        false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,    70,    daCenter,  false,    "vndr_seq",           true,   "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         150,   daLeft,    false,    "vndr_name",          true,   "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  false,    "tztm_hrs",           false,  "",       dfUserFormat, 2,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  false,    "agmt_no",            false,  "",       dfNone,    0,     true,       true,9);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  false,    "refe_no",            false,  "",       dfNone,    0,     false,      false);
                    //----Add column[20061202] : CombinedMode
                    InitDataProperty(0, cnt++ , dtCheckBox,     100,   daCenter,  false,    "inlnd_rout_cmb_flg", false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,        85,    daLeft,    false,    "rail_crr_tp_cd",     false,  "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  false,    "inlnd_rout_junc_nm", false,  "",       dfNone,    0,     true,       true); //Junction
                    //-----hidden ---------------------
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "lnk_org_nod_cd",     false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "lnk_dest_nod_cd",    false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "clon_trsp_mod_cd",   false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "rout_org_nod_cd",    false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "rout_dest_nod_cd",   false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "rout_seq",           false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "rout_dtl_seq",       false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,  false,    "selRow",             false,  "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,  false,    "clon_vndr_seq",      false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,  false,    "clon_agmt_no",       false,  "",       dfNone,    0,     true,       true,9);
                    InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,  false,    "clon_combined_md",   false,  "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       85,    daLeft,    false,    "clon_rail_crr_tp_cd",false,  "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  false,    "clon_inlnd_rout_junc_nm", false,  "",  dfNone,    0,     true,       true); //Junction

                    InitDataCombo(0, "trsp_mod_cd", trsp_mod_cdText, trsp_mod_cdCode);
                    InitDataCombo(0, "rail_crr_tp_cd", rail_crr_tp_cdText, rail_crr_tp_cdCode);
                    InitUserFormat(0, "tztm_hrs", "##.##", "." );

					InitDataValid(0, "lnk_org_loc",   vtEngUpOther, "1234567890");
					InitDataValid(0, "lnk_org_type",  vtEngUpOther, "1234567890");
					InitDataValid(0, "lnk_dest_loc",  vtEngUpOther, "1234567890");
					InitDataValid(0, "lnk_dest_type", vtEngUpOther, "1234567890");
					InitDataValid(0, "vndr_seq",      vtEngUpOther, "1234567890");
					InitDataValid(0, "clon_vndr_seq", vtEngUpOther, "1234567890");
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
               
               sheetObj.DoSearch4Post("ESD_PRD_0056GS.do", PrdFQString(formObj));

                break;
            case IBSAVE:        //마스트 저장
                    
                 formObj.f_cmd.value = MULTI;
                 var iCheckRow = sheetObj.FindCheckedRow("delChk");
                
                 if( iCheckRow!="" ) {
                     if(!confirm(ComGetMsg('PRD90078'))){
                       break;
                     }
                 };
                 
                 sheetObj.DoSave("ESD_PRD_0056GS.do", PrdFQString(formObj),-1,false);

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
              
           case SEARCH02:
              formObj.f_cmd.value = SEARCH02;

              uid= "ESD_PRD_0005";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;              
           case SEARCH05:
              formObj.f_cmd.value = SEARCH05;
              uid= "ESD_PRD_0005";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
              
           case SEARCH01:
              formObj.f_cmd.value = SEARCH01;
 	          sParam = PrdFQString(formObj);
 	          var sXml = sheetObj.GetSearchXml("ESD_PRD_0056GS.do", sParam);
 	          formObj.cnt_cd.value = ComGetEtcData(sXml,"cnt_cd");
 	      	 
 	      	  break;
        }
    }


    // sheet1 에서 클릭 이벤트 발생시 
    function sheet1_OnDblClick(sheetObj, row, col, value) {
        var formObj = document.form;
        formObj.i_selrow.value = row;
        formObj.i_rout_seq.value = sheetObj.CellValue(row,"rout_seq");
        
        doActionIBSheet2(sheetObjects[1],formObj, IBSEARCH);  //sheetObjects[1]->sheet2
        
        
    }
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        if(sheetObj.RowCount>0 && (CRUD != "R")) {
            ComBtnEnable("btn_save");
        } 
    }  
    
    // DoSearch Method 나 DoRowSearch Method, LoadSearchXml Method를 사용하여 조회처리를 완료한 후 
    //성공,실패 여부에 관계 없이 이벤트가 발생한다.
    // 신규 등 수정중에는 SHEEET OBJECT를 EDIT하게 둔다 .
    // 미주, RAIL 은  수정해서 저장할수 없다 .
    // ->미주, RAIL 은  수정해서 저장할수 없다 . SAVEAS 만 사용가능 하게 
    // 처음과 끝이 다르면 SHEEET OBJECT를 EDIT하게 둔다 .
    
    function sheet2_OnSearchEnd(sheetObj,ErrMsg)
    {
    	
        var formObj = document.form;
        if(CRUD != "R") {
        	ComBtnEnable("btng_clear");
        	ComBtnEnable("btng_new");
//        	ComEnableObject(document.getElementById("btng_clear"), true);
//        	ComEnableObject(document.getElementById("btng_new"), true);
        }

    }  
    
    //미주시 레일을 포함하는지 체크해서 rail 을 포함한 row이면 "미주,rail일떄의 필수 요소 체크" 
    function chkMandatoryForAmerican(formObj, sheetObj) {
            // 미주이고 링크에 RD가 포함 되면  inv billing, Route Plan, WRS(F), WRS(M) 이 필수 입력 
            var invIdx = formObj.i_inv.selectedIndex;
            var routPlnIdx = formObj.i_rout_pln_cd.selectedIndex;
            var findRd = false;
            
            for( var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                sheetObj.FindText("trsp_mod_cd" , "RAIL" , i , -1 )!= -1? findRd = true: "" ;
            }
            if(findRd){
                if(invIdx ==0) {

                    ComShowMessage(ComGetMsg('PRD90017'));
                    formObj.i_inv.focus();
                    return false;
                } 
                if(routPlnIdx ==0) {

                    ComShowMessage(ComGetMsg('PRD90018'));
                    formObj.i_rout_pln_cd.focus();
                    return false;
                } 

                
                // 미주 레일 일떄 , agmt no 입력 필수 
                // 미주 레일 일떄 , rail_crr_tp_cd 입력 필수 (c/tofc)  
                for( i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                    //찾지 못하는 경우 -1 반환 ,찾을경우 첫번쨰 row를 반환 
                    if( sheetObj.CellValue(i, "trsp_mod_cd") == "RD" ) {
                        if( sheetObj.CellValue(i,"agmt_no")=="" || sheetObj.CellValue(i,"refe_no")=="" ) {
                            //미주 Rail 일경우 AGMT NO(Reference No) 는 필수 입니다.
                            ComShowMessage(ComGetMsg('PRD90037'));
                            sheetObj.SelectCell(i,"agmt_no");
                            return false;
                        }
                        if( sheetObj.CellValue(i,"rail_crr_tp_cd")==""  ) {
                            //미주 Rail 일경우 C/TOFC  는 필수 입니다.
                            ComShowMessage(ComGetMsg('PRD90038'));
                            sheetObj.SelectCell(i,"rail_crr_tp_cd");
                            return false;
                        }
                    } else {
                        if( sheetObj.CellValue(i,"agmt_no")!="" || sheetObj.CellValue(i,"refe_no")!="" ) {
                            //미주 Rail 일경우만  AGMT NO(Reference No) 입력 가능 합니다.
                            ComShowMessage(ComGetMsg('PRD90039'));
                            sheetObj.SelectCell(i,"agmt_no");
                            return false;
                        }
                        if( sheetObj.CellValue(i,"rail_crr_tp_cd")!=""  ) {
                            //미주 Rail 일경우만 C/TOFC  입력 가능 합니다.
                            ComShowMessage(ComGetMsg('PRD90040'));
                            sheetObj.SelectCell(i,"rail_crr_tp_cd");
                            return false;
                        }                        
                    }
                    
                }  //FOR 
                                           
            }

            return true;        
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
                    if(  sheetObj.CellValue(i,"inlnd_rout_cmb_flg")==1) chkCnt++;
                    
                    
                }      
                          
              
				//rd와 rd의 사이가 max 2,  RD링크의 max갯수는 3
				if( eval(lastRow-firstRow) > 2 || rdCnt > 3 ) {
	                combindChk = false;
	                ComShowMessage(ComGetMsg('PRD90021'));
	                return combindChk; 
				}
				
				// 이하는 rd와 rd사이의 max가 2이고, rd 갯수가 max 3 이하인 경우에만 적용하는 로직 
				
				// RD-RD-RD를 포함 할때 
				if( rdCnt == 3 && eval(lastRow-firstRow) == 2) {
					if(ComIsContainsChars(formObj.i_inv,"3")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"inlnd_rout_cmb_flg")==1) {
	                		//rd 범위
	                		if( i < firstRow || i > lastRow) {
				                combindChk = false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	} else {
	                		if( i >= firstRow && i <= lastRow) {
				                combindChk = false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	}
	                	
	                }
	            // RD-RD를 포함 할때 
				} else if( rdCnt == 2 && eval(lastRow-firstRow)== 1){ // rd가 2개이고 연속된 rd 일때 
					if(ComIsContainsChars(formObj.i_inv,"2")!=true) {

	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"inlnd_rout_cmb_flg")==1) {
	                		//rd 범위밖 
	                		if( i < firstRow || i > lastRow) {
				                combindChk = false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	} else {
	                		if( i >= firstRow && i <= lastRow) {
				                combindChk = false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	}
	                }
	            // rd가 2개이고 RD-TD-RD 일때 
				} else if( rdCnt == 2 && eval(lastRow-firstRow)== 2){ 
					if(ComIsContainsChars(formObj.i_inv,"1")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"inlnd_rout_cmb_flg")==1) {
			                combindChk = false;
			                ComShowMessage(ComGetMsg('PRD90021'));
			                return combindChk;
	                	}
	                }
				} else if( rdCnt == 1 ){ 
					if(ComIsContainsChars(formObj.i_inv,"1")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"inlnd_rout_cmb_flg")==1) {
			                combindChk = false;
			                ComShowMessage(ComGetMsg('PRD90021'));
			                return combindChk;
	                	}
	                }
				} else if( rdCnt == 0 ){ 
	                var invIdx = formObj.i_inv.selectedIndex;
					if(invIdx >0) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk = false;
	                    return combindChk; 
					}
	                for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
	                	if( sheetObj.CellValue(i,"inlnd_rout_cmb_flg")==1) {
			                combindChk = false;
			                
			                ComShowMessage(ComGetMsg('PRD90021'));
			                return combindChk;
	                	}
	                }
				}

                              
            } else {  
                var sp = '';
                var firstCombindMode = false;
                var firstCombindCnt = 0;
                for(var j = sheetObj.HeaderRows ; j < sheetObj.Rows ; j++) {
                    if( sheetObj.CellValue(j,"inlnd_rout_cmb_flg")==1 && firstCombindMode == false && sheetObj.RowCount > 1){ //첫번쨰 combind면 
                        sp = sheetObj.CellValue(j, "vndr_seq");
                        firstCombindMode = true;
                        firstCombindCnt ++;
                    } else if(sheetObj.CellValue(j,"inlnd_rout_cmb_flg")==1 && firstCombindMode == true && sheetObj.RowCount > 1 ) {   //두번째 이후 combind면                         
                        if( sp != sheetObj.CellValue(j, "vndr_seq") ) {

                            ComShowMessage(ComGetMsg('PRD90022'));
                            combindChk = false;
                            return combindChk;   
                        }
                    } else if(sheetObj.CellValue(j,"inlnd_rout_cmb_flg")==1 && sheetObj.RowCount ==1 ) {  // 데이터가 1건만 있는데 체크할때 
                            ComShowMessage(ComGetMsg('PRD90021'));
                            combindChk = false;
                            return combindChk;   
                    } else if( firstCombindMode == true && firstCombindCnt <2 ){ // 체크된게 1건일때 

                            ComShowMessage(ComGetMsg('PRD90024'));
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

            sheetObj.CheckAll("inlnd_rout_cmb_flg") = 0;
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
                
            
            
                //RD 처음 과 끝 사이를  체크 (RTR일때는 체크하지 않는다, RD가 하나일떄도 체크하지 않는다.)
                if( firstRow > 0){
                     for(j=firstRow ; j<= lastRow ; j++) {
                        //RD가 2개 또는 세개일때만 체크  
                        if(eval(lastRow-firstRow)==1 || eval(lastRow-firstRow)==2  ) {
                            sheetObj.CellValue2(j,"inlnd_rout_cmb_flg")=1;
                        }
                    }                   
                }

                
                              
            }
            
    }
    
    // Sheet2 관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
    	sheetObj.ShowDebugMsg = false;
        
        // 상세 조회시 hub를 통한 링크를 event에 담아 두었다가 디테일에 표시 하기 위해 
        var rout_org_nod_cd  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_org_nod_cd") ;
        var rout_dest_nod_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_dest_nod_cd") ;
        
        var rout_seq      = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_seq") ;


        switch(sAction) {

           case IBSEARCH:      //Sheet1에서 클릭시 상세 조회 ->Sheet2에 표시 
                if(validateForm(sheetObj,formObj,sAction))

                

               formObj.f_cmd.value = SEARCH;
               
            
               formObj.i_rout_org_nod_cd.value = rout_org_nod_cd;
               formObj.i_rout_dest_nod_cd.value = rout_dest_nod_cd;
               formObj.i_rout_seq.value = rout_seq;

               //------------------------------------------------------------------------------------------
               sheetObj.DoSearch4Post("ESD_PRD_0056DETAIL_GS.do", PrdFQString(formObj));
               
               ComEtcDataToForm(formObj,sheetObj);
              
               formObj.detail_org_i_inv.value = sheetObj.EtcData("i_inv");
               formObj.detail_org_i_rout_pln_cd.value = sheetObj.EtcData("i_rout_pln_cd");

               break;

            case IBSAVE:        //detail 저장( combind 체크는 하고 온 상태)
            
                if(validateForm(sheetObj,formObj,sAction))  
                // ROW ADD 가 있는것-> 신규라는 것 (SAVE)
                var isNew = true;
                // 미주 레일이던 아니던 상태가 전부 'I'일때  new route 
                for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                   //NEW 로 만든거면  save 가능 ,중복체크는 서버에서 
                   
                   if(isNew && sheetObj.RowStatus(i) =='I') {
                       isNew= true;
                   } else {
                       isNew= false;
                   }
                }//for1                
                // 연결이 맞는지 확인 (신규인지도 체크됨[i_newRouteCd])
                if(!checkRoute4Mt(sheetObj,formObj)) return;
                
                
                // MT용- IRG의 FROM-TO 가 미주인지 확인 
                if( !checkFromTo4US(sheetObj)){
                    ComShowMessage(ComGetMsg('PRD90111'));
                    return false;
                } else { //미주일때 처리 로직 
                     //미주시 필수 요소 체크 (레일 포함시 필수 체크) 
                     if(!chkMandatoryForAmerican(formObj, sheetObj)) return;
                     // MT 일때 처음과 끝 링크가 레일이다. 
                     if(!chkRailLinkForMt(sheetObj)) return false;
                     //(add) 2007 05 17 clon_trsp_mod_cd로 rd 체크 , rd 외에는 sp 를 변경할수 있다 .
                     //  미주 레일이 아닌 ROW의 SP만 변경 되었는지 확인 하는 로직 추가 .                     
                     if(!checkSpChange(sheetObj)){

                     	    ComShowMessage(ComGetMsg('PRD90080'));
                     	    return false;                     
                     }   
                     if(!checkJunk(sheetObj)) {
                         ComShowMessage(ComGetMsg('PRD90081'));
                 	     return false; 
                     }  


                     // 20070801 추가 
                     if( !checkWRS(sheetObj , 'M')) {
                             ComShowMessage(ComGetMsg('PRD90079'));

                     	 return false;
                     }                    
                                                          
                }
                
                


               
                // detail 에서 신규로 만들때 마스터 자리에 새로운 행을 삽입해 둔다                 
                if(isNew){
                    sheetObjects[0].DataInsert(-1);
                    formObj.i_selrow.value=sheetObjects[0].LastRow; //detail 저장후 들어갈 master의 row num

                }
                formObj.f_cmd.value = MULTI01;
                var SaveStr = sheetObj.GetSaveString(true);  
                if (sheetObj.IsDataModified && SaveStr == "") return;
                
                sXml = sheetObj.GetSaveXml("ESD_PRD_0056MST_ROWSEARCH.do",SaveStr+"&"+PrdFQString(formObj)+"&isNew="+isNew);        
                sheetObjects[0].LoadSearchXml(sXml,true, -1, true);


                if(sheetObjects[0].EtcData("strErrMsg")!=''){

                    //이미 같은 라우터가 있으면 에러
                    ComShowMessage(sheetObjects[0].EtcData("strErrMsg"));
                    if(sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)=='I'){
                         sheetObjects[0].RowDelete(sheetObjects[0].SelectRow ,false); 
                    }
                }

                break;
                
           case MULTI02: //SAVEAS 
                formObj.f_cmd.value = MULTI02;
                
                //변경사항 유무 체크 
                // 변경된 내용이없으면 중복된 irg를 생성할수 없습니다. 
                var updateRow = false;
                //그리드 내용 체크 
                for( var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                 	if(sheetObj.RowStatus(i) !='R') {
                 	    //변경되면 OK 
                 	    updateRow = true;
                 	} 
                }    
                //그리드외 내용 체크 
               var detail_org_i_inv = formObj.detail_org_i_inv.value ;
               var detail_org_i_rout_pln_cd = formObj.detail_org_i_rout_pln_cd.value ;
               var detail_org_i_bkg_flg = formObj.detail_org_i_bkg_flg.value ;

               var detail_org_i_wrs_fl_cd = formObj.detail_org_i_wrs_fl_cd.value ;
               var detail_org_i_wrs_mt_cd = formObj.detail_org_i_wrs_mt_cd.value ;

               var i_inv =            formObj.i_inv.value ;
               var i_rout_pln_cd =    formObj.i_rout_pln_cd.value ;
               var i_bkg_flg =        formObj.i_bkg_flg.value ;

               
               var i_wrs_fl_cd =      formObj.i_wrs_fl_cd.value ;
               var i_wrs_mt_cd =      formObj.i_wrs_mt_cd.value ;   
               

               var etcInDataUpdate = true;

                if( detail_org_i_inv ==i_inv && detail_org_i_rout_pln_cd == i_rout_pln_cd && detail_org_i_bkg_flg==detail_org_i_bkg_flg && 
                      detail_org_i_wrs_fl_cd == i_wrs_fl_cd && detail_org_i_wrs_mt_cd ==i_wrs_mt_cd) {
                    
                    etcInDataUpdate = false;
                }

                // 업데이트가 된게 있으면 저장 수행    
                if( updateRow || etcInDataUpdate ){
                    
                    // 미주시 체크 
                    if(chkAmericanContinent(formObj)) {
                         //미주시 레일을 포함할때  필수 요소 체크 
                         if(!chkMandatoryForAmerican(formObj, sheetObj)) return;
     
                         if(!checkJunk(sheetObj)) {
                             ComShowMessage(ComGetMsg('PRD90081'));

                     	     return false; 
                         }
                         
                         // 20070801 추가 
                         if( !checkWRS(sheetObj , 'M')) {
                                 ComShowMessage(ComGetMsg('PRD90079'));
                         	 return false;
                         } 
                    }                    
                    
                    
                    
                    // detail 에서 신규로 만들때 마스터 자리에 새로운 행을 삽입해 둔다                 
                    sheetObjects[0].DataInsert(-1);
                    formObj.i_selrow.value=sheetObjects[0].LastRow; //detail 저장후 들어갈 master의 row num
                    
                    var SaveStr = sheetObj.GetSaveString(true);  
                    sXml = sheetObj.GetSaveXml("ESD_PRD_0005MST_ROWSEARCH.do",SaveStr+"&"+PrdFQString(formObj));  
                    sheetObjects[0].LoadSearchXml(sXml,true, -1, true);
    
                    if(sheetObjects[0].EtcData("strErrMsg")==''){
                        maxPrioSeq = sheetObjects[0].EtcData("maxPrioSeq");
                      	//콤보 데이터 셋팅 
                      	sheetObjects[0].InitDataCombo (0, "prio_seq", sheetObjects[0].EtcData("prio_seq_combo"),sheetObjects[0].EtcData("prio_seq_combo"));
                      	sheetObjects[0].LoadSearchXml(sXml,true, -1, true);
        
                        sheetObj.RemoveAll();

                        bottomFrmClear(formObj);
                        formObj.i_org_cd.value = i_origin;
                        formObj.i_dest_cd.value = i_destination;
                    } else {
                        //에러면 
                        ComShowMessage(sheetObjects[0].EtcData("strErrMsg"));
                        sheetObjects[0].RowDelete(sheetObjects[0].LastRow,false); 
                        
                    }
                    

                }else {

                    ComShowMessage(ComGetMsg('PRD90042'));
                }

                break;     
                
           case IBINSERT:      // 입력

               if(validateForm(sheetObj,formObj,sAction))
               
               var modRoutOrgLoc = sheetObj.CellValue(sheetObj.LastRow,"lnk_org_loc");
               var modRoutOrgType = sheetObj.CellValue(sheetObj.LastRow,"lnk_org_type");
               var modRoutDestLoc = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc");
               var modRoutDestType = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
               if(sheetObj.RowCount>0) {
                   if(modRoutOrgLoc.length >0 && modRoutDestLoc.length>0) {
                       var row = sheetObj.DataInsert(-1);
                       
                       sheetObj.RowEditable(row) = true;
                       
                       sheetObj.CellValue2(sheetObj.LastRow,"lnk_org_loc") = modRoutDestLoc;
                       sheetObj.CellValue2(sheetObj.LastRow,"lnk_org_type") = modRoutDestType;
                   } else {
                       ComShowMessage(ComGetMsg('PRD90025'));
                       return;
                   }
                   
               } else {
                   // 신규로 라우터를 만들때 
                   var row = sheetObj.DataInsert(-1);  
                   sheetObj.RowEditable(row) = true;                  
               }
                 
                break;       
           case SEARCH08:
              formObj.f_cmd.value = SEARCH08;
              uid= "ESD_PRD_0005";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObj.EtcData("rowCount");
              comData1 = sheetObj.EtcData("comData1");
              comData2 = sheetObj.EtcData("comData2");
                //rowcount 가 1보다 작으면 
                if(retValidate < 1) {
                    sheetObj.CellValue2(sheetObj.selectRow,"vndr_name") = comData2;
                    sheetObj.CellValue2(sheetObj.selectRow,"vndr_seq") = "";
                    sheetObj.SelectCell(sheetObj.selectRow,"vndr_seq");
                }else {
                    sheetObj.CellValue2(sheetObj.selectRow,"vndr_name") = comData2;
                }
              break;                 
           case IBCOPYROW:        //행 복사

              sheetObj.DataCopy();
              break;                         
        }
    }
    
    
    // empty 용 
    function checkFromTo4US(sheetObj) {
        var fromNod = sheetObj.CellValue(parseInt(sheetObj.HeaderRows), "lnk_org_loc");
        var toNod   = sheetObj.CellValue(parseInt(sheetObj.LastRow), "lnk_dest_loc");
        
        var org  = fromNod.substring(0,2);
        var des  = toNod.substring(0,2);
        
        if( chkAmericaCntCd(org) && chkAmericaCntCd(des)) {
            return true;
        }
        
        return false;        
    }
    
    function chkRailLinkForMt(sheetObj){
        if( sheetObj.CellValue(parseInt(sheetObj.HeaderRows), "trsp_mod_cd")!="RD" || sheetObj.CellValue(sheetObj.LastRow, "trsp_mod_cd")!="RD") {
            ComShowMessage(ComGetMsg('PRD90082'));
            return false;
        }
        return true;
    }
    
    function checkWRS(sheetObj,irgGb) {
        var formObj = document.form;
        var inv = formObj.i_inv.value;
        for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
            var cTofc = sheetObj.CellValue(i, "rail_crr_tp_cd");
            var sp = sheetObj.CellValue(i, "vndr_seq");
            
            if(inv =='S2R' ) {
                if(formObj.wrs_chk.checked){
                  formObj.i_inv.focus();
                  return false;
                }
            }
            
            if( cTofc.substring(0,1) == 'T'  ) {
                if(formObj.wrs_chk.checked){
                  sheetObj.SelectCell(i,"rail_crr_tp_cd");
                  return false;
                }
            }
// 20101005 진석호 대리 요청               
//            if( sp=='105475'  ) {
//                if(formObj.wrs_chk.checked > 0){
//                  sheetObj.SelectCell(i,"vndr_seq");
//                  return false;
//                }
//            }
//            
//            if(sp=='105484'||sp=='108386' ) {
//                if(formObj.wrs_chk.checked > 0){
//                  sheetObj.SelectCell(i,"vndr_seq");
//                  return false;
//                }
//            }
            
            if(sp=='108386' ) {
                if( formObj.wrs_chk.checked > 0){
                  sheetObj.SelectCell(i,"vndr_seq");
                  return false;
                }
            }
            
        }
        
        return true;
    }


       
    /*
     * Mandatory 체크 
     */
    function checkMandatory() {
        var formObj = document.form;
        var retValue = true;

        var gubun = '';
        for(i=0; i < formObj.r_inbound.length ; i++) {
        	if(formObj.r_inbound[i].checked) {
        		gubun = formObj.r_inbound[i].value;
        	}
        }
        // 조회할때 from, to 인 i_org_cd,i_dest_cd  를 셋팅한다. 
        if(gubun=='I'){
        	orgCd = formObj.i_org_cd_ib.value;
        	destCd = formObj.i_dest_cd_ib.value;
         	formObj.i_org_cd.value = formObj.i_org_cd_ib.value;
        	formObj.i_dest_cd.value = formObj.i_dest_cd_ib.value;	
            if(( orgCd.length != 7 ) || ( destCd.length != 5 )) retValue = false;
        				
		}
		if(gubun=='O'){
        	orgCd = formObj.i_org_cd_ob.value;
        	destCd = formObj.i_dest_cd_ob.value;
         	formObj.i_org_cd.value = formObj.i_org_cd_ob.value;
        	formObj.i_dest_cd.value = formObj.i_dest_cd_ob.value;
            if(( orgCd.length != 5 ) || ( destCd.length != 7 )) retValue = false;
		}
		if(gubun=='T'){
        	orgCd = formObj.i_org_cd_ts.value;
        	destCd = formObj.i_dest_cd_ts.value;
         	formObj.i_org_cd.value = formObj.i_org_cd_ts.value;
        	formObj.i_dest_cd.value = formObj.i_dest_cd_ts.value;
            if(( orgCd.length != 5 ) || ( destCd.length != 5 )) retValue = false;
		}	
		if(gubun=='M'){
        	orgCd = formObj.i_org_cd_mt.value;
        	destCd = formObj.i_dest_cd_mt.value;
         	formObj.i_org_cd.value = formObj.i_org_cd_mt.value;
        	formObj.i_dest_cd.value = formObj.i_dest_cd_mt.value;
            if(( orgCd.length != 7 ) || ( destCd.length != 7 )) retValue = false;
		}	        
        

		if (!retValue){
			ComShowMessage(ComGetMsg('PRD90007'));
		}
        return retValue;
    }
    
    function checkRouteList(sheetObject) {
        var retValue = true;
    	var sIRow = sheetObject.FindStatusRow("I");
         //받은 결과를 배열로 생성한다.
        var arIRow = sIRow.split(";");
        if(arIRow.length > 1 ) { //  갯수가 1개라도 있으면 
             ComShowMessage(ComGetMsg('PRD90026'));
             retValue = false;
        }
        return retValue;
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
    
    // 미주 , 레일이 아닌 ROW의 SP만 변경 되었는지 , false이면 save as 를 사용하라고 표시 
    function checkSpChange(sheetObj) {
       for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
           //NEW 로 만든거면  save 가능 ,중복체크는 서버에서 
           if(sheetObj.RowStatus(i) =='I') return true;
       }//for1
       
       for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
         	if(sheetObj.RowStatus(i) !='R'  ) { // update or new 이면 

         	    
         	    // status가 new가 없고 ,update만 된거면, clon from,to,mode 는 같으면 , mode가 td면 sp만, mode가 rd면 junk만 변경가능. 
         	    if(sheetObj.CellValue(i,"lnk_org_nod_cd") == sheetObj.CellValue(i,"lnk_org_loc") + sheetObj.CellValue(i,"lnk_org_type") ||
         	       sheetObj.CellValue(i,"lnk_dest_nod_cd") == sheetObj.CellValue(i,"lnk_dest_loc") + sheetObj.CellValue(i,"lnk_dest_type") ||
         	       sheetObj.CellValue(i,"clon_trsp_mod_cd") == sheetObj.CellValue(i,"trsp_mod_cd"))
         	    {
         	        //from,to,mode는 변경이 없었으면 
         	        // RD가 아니면 sp만 변경 가능 
         	        if(sheetObj.CellValue(i, "trsp_mod_cd") != "RD"){
         	            if( sheetObj.CellValue(i,"clon_agmt_no")!=sheetObj.CellValue(i,"agmt_no") ||
         	                sheetObj.CellValue(i,"clon_combined_md")!=sheetObj.CellValue(i,"inlnd_rout_cmb_flg") ||
         	                sheetObj.CellValue(i,"clon_inlnd_rout_junc_nm")!=sheetObj.CellValue(i,"inlnd_rout_junc_nm")    ){

         	                return false;
         	            }
      	            //RD 면 junk만 변경 가능 
         	        } else if( sheetObj.CellValue(i,"clon_agmt_no")!=sheetObj.CellValue(i,"agmt_no") ||
         	                sheetObj.CellValue(i,"clon_rail_crr_tp_cd")!=sheetObj.CellValue(i,"rail_crr_tp_cd") ||
         	                sheetObj.CellValue(i,"clon_vndr_seq")!=sheetObj.CellValue(i,"vndr_seq") ) { 
                            return false;        	            
         	        }
         	    }else {
         	        // save as 사용 
         	        return false;
         	    }
         	} // update or new 이면 End 
        }//for2        
        return true;
    }
    
    //미주,레일을 포함할때 JUNK validation 
    function checkJunk(sheetObj) {
       var nextIdx=0;
       var totRowCnt = sheetObj.HeaderRows + sheetObj.RowCount;
       for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
            nextIdx= i+1;
 	        if(nextIdx < totRowCnt && sheetObj.CellValue(i, "trsp_mod_cd") == "RD" && sheetObj.CellValue(nextIdx, "trsp_mod_cd") == "RD" ){
 	            if( ComIsEmpty(sheetObj.CellValue(i,"inlnd_rout_junc_nm"))  ){
  	                return false;
 	            }
 	        } else if(i == sheetObj.RowCount && !ComIsEmpty(sheetObj.CellValue(i,"inlnd_rout_junc_nm"))  ) {
 	            return false;
 	        }

        }//for       
        return true;
    }
    
     
    /*
     * 연결고리 확인 
     */
    function checkRoute2(sheetObj,formObj) {
        var k = 0;
        var modRoutOrgLoc ="";
        var modRoutDestLoc = "";
        var routOrgNod  = new Array();
        var routDestNod = new Array();
        routOrgNod[k]  = "";
        routDestNod[k] = "";
        
        

         var sURow = sheetObj.FindStatusRow("U");
         //받은 결과를 배열로 생성한다.
         var arURow = sURow.split(";");
         
         var sIRow = sheetObj.FindStatusRow("I");
         //받은 결과를 배열로 생성한다.
         var arIRow = sIRow.split(";");                 
     
         //ComShowMessage("더블클릭시 히든값 :"+formObj.i_rout_org_nod_cd.value+","+formObj.i_rout_dest_nod_cd.value);
         formObj.i_new_route_cd.value = "";  
         //update Route 일때 마스터의 키값과 같은지 확인한다.
         //신규로 만들수도 있으므로 업데이트 여부를 체크한다 (arURow.length > 1)

         var gubun = '';
         for(i=0; i < formObj.r_inbound.length ; i++) {
        	if(formObj.r_inbound[i].checked) {
        		gubun = formObj.r_inbound[i].value;
        	}
         }
         //new Route 일때 ------------------------------------
         if(arIRow.length >= 2 && arURow.length==1  ) {
             formObj.i_new_route_cd.value = "Y";   
             formObj.i_rout_seq.value = 0;   
             formObj.i_rout_org_nod_cd.value = sheetObj.CellValue(1,"lnk_org_loc")  + sheetObj.CellValue(1,"lnk_org_type");
             formObj.i_rout_dest_nod_cd.value = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")  + sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
             //ComShowMessage("new rout::"+formObj.i_rout_org_nod_cd.value+", "+formObj.i_rout_dest_nod_cd.value);  
             // 조회 조건과  ori,dest 의 loc가 같은지 확인 
                
                
             var org_loc = formObj.i_org_cd.value;
        	 var dest_loc = formObj.i_dest_cd.value;


             // 07.05.03 추가 
             // IN/OUT/BOTH 구분에 따라 처리 
             // 'I' 7자리 , 5자리 
             //20070607 추가 mt 
             if(gubun == 'I'){
        	     if( org_loc != sheetObj.CellValue(1,"lnk_org_loc")+sheetObj.CellValue(1,"lnk_org_type") || dest_loc != sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")){
        	         ComShowMessage(ComGetMsg('PRD90028'));
        	         return false;
        	     }
             } else if (gubun == 'O') {
                 // 'O' 5자리 , 7자리 
        	     if( org_loc != sheetObj.CellValue(1,"lnk_org_loc")  || dest_loc != sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")+sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type") ){

        	         ComShowMessage(ComGetMsg('PRD90028'));
        	         return false;
        	     }
             } else if (gubun == 'B') {
                 // 'B' 5자리 , 5자리 
                 
        	     if( org_loc != sheetObj.CellValue(1,"lnk_org_loc")  || dest_loc != sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc") ){

                     
        	         ComShowMessage(ComGetMsg('PRD90028'));
        	         return false;
        	     }
             }else if (gubun == 'M') {
                 // 'M' 7자리 , 7자리 
                 
        	     if( org_loc != sheetObj.CellValue(1,"lnk_org_loc")+sheetObj.CellValue(1,"lnk_org_type")  || dest_loc != sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")+sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type") ){

                     
        	         ComShowMessage(ComGetMsg('PRD90028'));
        	         return false;
        	     }
             }
    	    
                    
         } else {
             if(arURow.length > 1 ) {
                 formObj.i_new_route_cd.value = "N";
             }
             var hRoutOrgNodCd = formObj.i_rout_org_nod_cd.value;     //수정될 라우터의 마스터 org
             var hRoutDestNodCd = formObj.i_rout_dest_nod_cd.value;   //수정될 라우터의 마스터 dest
             var firstRoutOrgNodCd = sheetObj.CellValue(1,"lnk_org_loc")  + sheetObj.CellValue(1,"lnk_org_type");  //수정된 라우터의 시작org 
             var lastRoutDestNodCd = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")  + sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type"); //수정된 라우터의 끝dest 
             //수정이면 수정된 라우터의 처음과 끝이  수정되기 전의 처음과 끝은 일치 해야 함 (마스터 테이블이 키이므로)
             if( hRoutOrgNodCd != firstRoutOrgNodCd || hRoutDestNodCd != lastRoutDestNodCd ) {

                 ComShowMessage(ComGetMsg('PRD90029'));
                 return false;
             }         
         }
         
         // 각링크를 수정하거나 신규로 안만들더라도 마스터 정보만 수정할수도 있다 (Y: 신규, N:수정, M:마스터 수정) 
         if(formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N")  
         {
             formObj.i_new_route_cd.value = "M";   
         }

        
        //뒤에서 연결고리를 확인하기 위해 배열로 담아 둔다 . 로우가 클리어된상태로 있으면 Delete로 보고 상태를 Delete로 바꾼다 
        for( i=1; i<= sheetObj.RowCount; i++) {
            routOrgNod[k]  = sheetObj.CellValue(i,"lnk_org_loc")  + sheetObj.CellValue(i,"lnk_org_type");
            routDestNod[k] = sheetObj.CellValue(i,"lnk_dest_loc") + sheetObj.CellValue(i,"lnk_dest_type");
            k++;
        }
          
         var j = 0;

         //연결고리가 맞는지 확인 
         for( i=0; i< routOrgNod.length; i++ ) {
            if(sheetObj.RowCount==1) {  //row가 하나일때 
                return true;
            } else {
                j=i+1;
            }
            if(routDestNod[i]==routOrgNod[j]) { //row가 2개 이상일때 
                if (j == (routOrgNod.length-1)) return true;
            } else {

                ComShowMessage(ComGetMsg('PRD90030'));
                return false;
            }
         }      
    }
    
    
    //Empty 연결고리 확인 
    function checkRoute4Mt(sheetObj,formObj) {
        var k = 0;
        var modRoutOrgLoc ="";
        var modRoutDestLoc = "";
        var routOrgNod  = new Array();
        var routDestNod = new Array();
        routOrgNod[k]  = "";
        routDestNod[k] = "";
        
        

         var sURow = sheetObj.FindStatusRow("U");
         //받은 결과를 배열로 생성한다.
         var arURow = sURow.split(";");
         
         var sIRow = sheetObj.FindStatusRow("I");
         //받은 결과를 배열로 생성한다.
         var arIRow = sIRow.split(";");                 
     
         //ComShowMessage("더블클릭시 히든값 :"+formObj.i_rout_org_nod_cd.value+","+formObj.i_rout_dest_nod_cd.value);
         formObj.i_new_route_cd.value = "";  


         //new Route 일때 ------------------------------------
         if(arIRow.length >= 2 && arURow.length==1  ) {
             formObj.i_new_route_cd.value = "Y";   
             formObj.i_rout_seq.value = 0;   
             formObj.i_rout_org_nod_cd.value = sheetObj.CellValue(1,"lnk_org_loc")  + sheetObj.CellValue(1,"lnk_org_type");
             formObj.i_rout_dest_nod_cd.value = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")  + sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
    	    
                    
         } else {
             if(arURow.length > 1 ) {
                 formObj.i_new_route_cd.value = "N";
             }
             var hRoutOrgNodCd = formObj.i_rout_org_nod_cd.value;     //수정될 라우터의 마스터 org
             var hRoutDestNodCd = formObj.i_rout_dest_nod_cd.value;   //수정될 라우터의 마스터 dest
             var firstRoutOrgNodCd = sheetObj.CellValue(1,"lnk_org_loc")  + sheetObj.CellValue(1,"lnk_org_type");  //수정된 라우터의 시작org 
             var lastRoutDestNodCd = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")  + sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type"); //수정된 라우터의 끝dest 
             //수정이면 수정된 라우터의 처음과 끝이  수정되기 전의 처음과 끝은 일치 해야 함 (마스터 테이블이 키이므로)
             if( hRoutOrgNodCd != firstRoutOrgNodCd || hRoutDestNodCd != lastRoutDestNodCd ) {
                 ComShowMessage(ComGetMsg('PRD90083'));

                 return false;
             }         
         }
         
         // 각링크를 수정하거나 신규로 안만들더라도 마스터 정보만 수정할수도 있다 (Y: 그리드신규, N:그리드수정, M:마스터수정(html 부분) ) 
         if(formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N")  
         {
             formObj.i_new_route_cd.value = "M";   
         }

        
        //뒤에서 연결고리를 확인하기 위해 배열로 담아 둔다 . 로우가 클리어된상태로 있으면 Delete로 보고 상태를 Delete로 바꾼다 
        for( i=1; i<= sheetObj.RowCount; i++) {
            routOrgNod[k]  = sheetObj.CellValue(i,"lnk_org_loc")  + sheetObj.CellValue(i,"lnk_org_type");
            routDestNod[k] = sheetObj.CellValue(i,"lnk_dest_loc") + sheetObj.CellValue(i,"lnk_dest_type");
            k++;
        }
          
         var j = 0;

         //연결고리가 맞는지 확인 
         for( i=0; i< routOrgNod.length; i++ ) {
            if(sheetObj.RowCount==1) {  //row가 하나일때 
                return true;
            } else {
                j=i+1;
            }
            if(routDestNod[i]==routOrgNod[j]) { //row가 2개 이상일때 
                if (j == (routOrgNod.length-1)) return true;
            } else {

                ComShowMessage(ComGetMsg('PRD90030'));
                return false;
            }
         }      
    }    
    //saveas 에서 연결 고리 확인 
    function checkRoute3(sheetObj,formObj) {
        var k = 0;
        var modRoutOrgLoc ="";
        var modRoutDestLoc = "";
        var routOrgNod  = new Array();
        var routDestNod = new Array();
        routOrgNod[k]  = "";
        routDestNod[k] = "";
        
        

         var sURow = sheetObj.FindStatusRow("U");
         //받은 결과를 배열로 생성한다.
         var arURow = sURow.split(";");
         
         var sIRow = sheetObj.FindStatusRow("I");
         //받은 결과를 배열로 생성한다.
         var arIRow = sIRow.split(";");                 
     
       
         formObj.i_new_route_cd.value = "";  
         //update Route 일때 마스터의 키값과 같은지 확인한다.
         //신규로 만들수도 있으므로 업데이트 여부를 체크한다 (arURow.length > 1)

         var gubun = '';
         for(i=0; i < formObj.r_inbound.length ; i++) {
        	if(formObj.r_inbound[i].checked) {
        		gubun = formObj.r_inbound[i].value;
        	}
         }
         //new Route 일때 ------------------------------------
         if(arIRow.length >= 2 && arURow.length==1  ) {
             formObj.i_new_route_cd.value = "Y";   
             formObj.i_rout_seq.value = 0;   
                 
             formObj.i_rout_org_nod_cd.value = sheetObj.CellValue(1,"lnk_org_loc")  + sheetObj.CellValue(1,"lnk_org_type");
             formObj.i_rout_dest_nod_cd.value = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")  + sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
  

             var org_loc = formObj.i_org_cd.value;
        	 var dest_loc = formObj.i_dest_cd.value;



         } else {
             if(arURow.length > 1 ) {
                 formObj.i_new_route_cd.value = "N";
             }

             var hRoutOrgNodCd = formObj.i_rout_org_nod_cd.value;     //수정될 라우터의 마스터 org
             var hRoutDestNodCd = formObj.i_rout_dest_nod_cd.value;   //수정될 라우터의 마스터 dest
             var firstRoutOrgNodCd = sheetObj.CellValue(1,"lnk_org_loc")  + sheetObj.CellValue(1,"lnk_org_type");  //수정된 라우터의 시작org 
             var lastRoutDestNodCd = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")  + sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type"); //수정된 라우터의 끝dest 
             //SAVE AS시 기본 정보를 바꾼다 .
             if(hRoutOrgNodCd != firstRoutOrgNodCd) {
                 formObj.i_rout_org_nod_cd.value =  firstRoutOrgNodCd;
              }
             if(hRoutDestNodCd != lastRoutDestNodCd) {
                 formObj.i_rout_dest_nod_cd.value = lastRoutDestNodCd;
             }
         }
         
         // 각링크를 수정하거나 신규로 안만들더라도 마스터 정보만 수정할수도 있다 (Y: 신규, N:수정, M:마스터 수정) 
         if(formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N")  
         {
             formObj.i_new_route_cd.value = "M";   
         }

        
        //뒤에서 연결고리를 확인하기 위해 배열로 담아 둔다 . 로우가 클리어된상태로 있으면 Delete로 보고 상태를 Delete로 바꾼다 
        for( i=1; i<= sheetObj.RowCount; i++) {
            routOrgNod[k]  = sheetObj.CellValue(i,"lnk_org_loc")  + sheetObj.CellValue(i,"lnk_org_type");
            routDestNod[k] = sheetObj.CellValue(i,"lnk_dest_loc") + sheetObj.CellValue(i,"lnk_dest_type");

            k++;
        }
          
         var j = 0;

         //연결고리가 맞는지 확인 
         for( i=0; i< routOrgNod.length; i++ ) {
            if(sheetObj.RowCount==1) {  //row가 하나일때 
                return true;
            } else {
                j=i+1;
            }
            if(routDestNod[i]==routOrgNod[j]) { //row가 2개 이상일때 
                if (j == (routOrgNod.length-1)) return true;
            } else {
                ComShowMessage(ComGetMsg('PRD90030'));
                return false;
            }
         }      
    }
        
    /*
     * 마스터 저장시 조회조건에 맞는 라우터 인지 확인 
     */
    function checkLocCondition(sheetObj) {
        var formObject = document.form;
        //조회 조건 
        var org_loc = formObject.i_org_cd.value;
    	var dest_loc = formObject.i_dest_cd.value;
    	
		var gubun = '';
        for(i=0; i < formObject.r_inbound.length ; i++) {
        	if(formObject.r_inbound[i].checked) {
        		gubun = formObject.r_inbound[i].value;
        	}
        }
        
        var orgSheetVal  = '';
        var destSheetVal = '';
        


    	for(var i=1; i <= sheetObj.RowCount ;i++){
	        if(gubun=='I'){ //7,5
	        	orgSheetVal  = sheetObj.CellValue(i,"rout_org_nod_cd") ;
	        	destSheetVal = sheetObj.CellValue(i,"dest_loc");
			}
			if(gubun=='O'){ //5,7
	        	orgSheetVal  = sheetObj.CellValue(i,"ori_loc");
	        	destSheetVal = sheetObj.CellValue(i,"rout_dest_nod_cd");
			}
			if(gubun=='T'){ //5,5
	        	orgSheetVal  = sheetObj.CellValue(i,"ori_loc") ;
	        	destSheetVal = sheetObj.CellValue(i,"dest_loc");
			}    	
			if(gubun=='M'){ //7,7
	        	orgSheetVal  = sheetObj.CellValue(i,"rout_org_nod_cd") ;
	        	destSheetVal = sheetObj.CellValue(i,"rout_dest_nod_cd");
			}			
    	    if( org_loc != orgSheetVal || dest_loc != destSheetVal){
    	        ComShowMessage(ComGetMsg('PRD90031'));
    	        return false;
    	    }
    	    
    	}
    	return true;
    }

    /*
     * 디테일  저장시 조회조건에 맞는 라우터 인지 확인 
     */
    function checkDtlLocCondition(sheetObj) {
        var formObject = document.form;
        var org_loc = formObject.i_org_cd.value;
    	var dest_loc = formObject.i_dest_cd.value;
      	

		var gubun = '';
        for(i=0; i < formObject.r_inbound.length ; i++) {
        	if(formObject.r_inbound[i].checked) {
        		gubun = formObject.r_inbound[i].value;
        	}
        }
        
        var orgSheetVal  = '';
        var destSheetVal = '';
        
        if(gubun=='I'){
        	orgSheetVal  = sheetObj.CellValue(1,"lnk_org_loc")+sheetObj.CellValue(1,"lnk_org_type");
        	destSheetVal = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc");
		}
		if(gubun=='O'){
        	orgSheetVal  = sheetObj.CellValue(1,"lnk_org_loc");
        	destSheetVal = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")+sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
		}
		if(gubun=='T'){
        	orgSheetVal  = sheetObj.CellValue(1,"lnk_org_loc");//sheetObj.CellValue(1,"lnk_org_type");
        	destSheetVal = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc");//+sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
		}
		if(gubun=='M'){
        	orgSheetVal  = sheetObj.CellValue(1,"lnk_org_loc")+sheetObj.CellValue(1,"lnk_org_type");
        	destSheetVal = sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_loc")+sheetObj.CellValue(sheetObj.LastRow,"lnk_dest_type");
		}
      	//ComShowMessage(org_loc+","+dest_loc+"sheet org_loc,dest_loc==["+orgSheetVal+","+destSheetVal);
	    if( org_loc != orgSheetVal || dest_loc != destSheetVal ){
	        ComShowMessage(ComGetMsg('PRD90032'));
	        return false;
	    }

    	return true;
    }
        
    function getCOM_ENS_051_1(rowArray) {
    	//alertComPopupData(rowArray);
    	
    	var colArray = rowArray[0];
    	document.all.i_org_cd.value = colArray[3];
    
    }
    
    function getOrgLoc(rowArray) {
    	//alertComPopupData(rowArray);
    	
    	var colArray = rowArray[0];
    	document.all.i_org_cd.value = colArray[3];
    }

    function getDestLoc(rowArray) {
    	//alertComPopupData(rowArray);
    	
    	var colArray = rowArray[0];
    	document.all.i_dest_cd.value = colArray[3];
    }
        
    
    
    /*
     * 07.05.01
     * 그룹구분은 없어졌음(그래서 1로 하드코딩) .조회된 것을 가지고 priority가 생김 
     */

    	var delCnt =1;
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        
    	//priority 변경 로직 (S)------------------------------------------------------------------------------------      
    	var i,curGubun,oriData,curOri;
    	var change_seq = Value;
    	ori_seq =  sheetObj.CellValue(Row,"ori_prio_seq");  //바뀌는 순위의 원래순위 
        var priorityArray = priority_seq.split("|"); 
        var priorityArrayLength = priorityArray.length-1; // split 할때  뒤에 더미 |가 있어서 1을 뺴줌 

    	// 바꾼 값들을 등록 , 나중 비교해서 했던 거면 제외하기 위해 
        var changedArr = new Array(); 
        var changedIdx = 0;
        var curMax = maxPrioSeq;
        if(sheetObj.ColSaveName(Col)=="prio_seq" && Value ==0 ){
            sheetObj.CellValue2(Row,"prio_seq") = sheetObj.CellValue(Row,"ori_prio_seq");
            ComShowMessage("Not select Value 0."    );
            return false;
        }
 
    	if(sheetObj.ColSaveName(Col)=="prio_seq" || sheetObj.ColSaveName(Col)=="delChk") {
    	    
    	    // delChk 가 되면 가장끝 priority( 순위가 낮은 )를 선택한 것으로 처리한다. 
    	    // 만약 delChk가 0인걸 했으면 priorityArray의 마지막 전껄 가장끝 priority( 순위가 낮은 )로 바꾼거로 처리 
        	if(sheetObj.ColSaveName(Col)=="delChk"){

        	    change_seq = priorityArray[priorityArrayLength-delCnt];
        	    if(ori_seq == 0){
             	    ori_seq = priorityArray[priorityArrayLength-(delCnt+1)];
        	    }

        	    if(sheetObj.CellValue(Row, "delChk")== 1) {
        	        delCnt++;
        	    } else { //delChk를 해제 했을떄 
        	        delCnt--;
        	    }
        	        

        	    sheetObj.CellValue2(Row,"prio_seq" )=change_seq;
        	}
            var prePrioSeq ;
    		for(i=1; i<= sheetObj.rowcount;i++) {  //+1는 해더의 row 수 (rowcount 는 1부터 의 숫자이므로 해더의 row가 두개 일때  인덱스로 처리할때 0부터이므로 +1만 해준다.
 
   					curOri = sheetObj.CellValue(i,"ori_prio_seq");
                    
                    // 같은 값이거나 현재 값이 전에 바뀐값으로 등록되어있는지 체크 
                    if (prePrioSeq == curOri) {
                    	continue;
                    } 
                    
                    var continueChk = false;
                    for(var index=0; index<changedArr.length; index++) {
                        if (changedArr[index] == curOri) {
                            continueChk = true;
                        	continue;
                        }                     	
                    }
                    if (continueChk)  continue;
                    

    				if(eval(ori_seq)-eval(change_seq)>0 || eval(ori_seq)==0 ){ // 순위가 높아지면 ( ex: 4->1)
    	
    					
    					if( (eval(change_seq) <= eval(curOri) && eval(curOri) < eval(ori_seq) ) ||  (eval(change_seq) <= eval(curOri) && eval(ori_seq)==0)  ){
    					    var upArr=new Array(); 
    					    var upIdx = 0;
    					    for(var index=0; index<priorityArrayLength; index++) {
    					    	if (eval(curOri) < eval(priorityArray[index])) {
    					    		upArr[upIdx] = priorityArray[index];
    					    		upIdx++;
    					    	} 
    					    } //for     					    
    						sheetObj.CellValue2(i,"prio_seq" )= upArr[0];
    						
    					}
    				}else {  //순위가 낮아지면 (ex:1 -> 4)
                        
                        if(eval(ori_seq)==0 ) {
                            if(eval(change_seq)<= eval(curMax) ){
            					if( eval(ori_seq) < eval(curOri) && eval(curOri) <= eval(change_seq) ){
            					    var downArr=new Array(); 
            					    var downIdx = 0;
            					    for(var index=0; index<priorityArrayLength; index++) {
  
            					    	if (eval(curOri) > eval(priorityArray[index]) && eval(priorityArray[index])!=0 ) {
            					    		downArr[downIdx] = priorityArray[index];
            					    		downIdx++;
            					    	} 
            					    } //for 
                                    if(downArr.length>0){
                   						sheetObj.CellValue2(i,"prio_seq" )= downArr[downArr.length-1];
                                    }
        
            					}	
                            }
                            
                        } else {
        					if( eval(ori_seq) < eval(curOri) && eval(curOri) <= eval(change_seq) ){
        					    var downArr=new Array(); 
        					    var downIdx = 0;
        					    for(var index=0; index<priorityArrayLength; index++) {
        					    	if (eval(curOri) > eval(priorityArray[index]) && eval(priorityArray[index])!=0 ) {
        					    		downArr[downIdx] = priorityArray[index];
   
        					    		downIdx++;
        					    	} 
        					    } //for 
                                if(downArr.length>0){
               						sheetObj.CellValue2(i,"prio_seq" )= downArr[downArr.length-1];
                                }
    
        					}	                            
                        }
			
    				}
    				changedArr[changedIdx++] = curOri;
    				prePrioSeq = curOri; //전꺼랑 비교를 위한 변수 

    		} //for 
    		
    		//ori 쪽에 정렬된것으로 바꾸어준다.그래야 정렬을 다시 바꿀때 현재 바뀐 정렬을 기준으로 처리할수 있다.
    
    		for(j=1; j<= sheetObj.rowcount;j++) {
    			sheetObj.CellValue2(j,"ori_prio_seq" )= sheetObj.CellValue(j,"prio_seq" );
    		} //for 	
    	} 
    	
    	//priority 변경 로직 (E)------------------------------------------------------------------------------------
    	
    	
    	// wrs 가 Check 된 경우에만, CNTR TYPE/SIZE Check 가능(S) ----------------------------------------------------     	
    	if(sheetObj.ColSaveName(Col) == "wrs_chk")
    	{
    	    
    	    if(sheetObj.CellValue(Row, "wrs_chk") == "1")
    	    {
    	        // CNTR TYPE/SIZE 활성화
    	        sheetObj.CellEditable(Row,"d2_flg") = true;
    	        sheetObj.CellEditable(Row,"d4_flg") = true;
    	        sheetObj.CellEditable(Row,"d5_flg") = true;
    	        sheetObj.CellEditable(Row,"d7_flg") = true;
    	        sheetObj.CellEditable(Row,"o2_flg") = true;
    	        sheetObj.CellEditable(Row,"o4_flg") = true;
    	        sheetObj.CellEditable(Row,"o5_flg") = true;
    	        sheetObj.CellEditable(Row,"a2_flg") = true;
    	        sheetObj.CellEditable(Row,"a4_flg") = true;
    	        sheetObj.CellEditable(Row,"a5_flg") = true;
    	        sheetObj.CellEditable(Row,"r2_flg") = true;
    	        sheetObj.CellEditable(Row,"r5_flg") = true;
    	        sheetObj.CellEditable(Row,"r8_flg") = true;
    	    } else {
    	        var tpsz_chk = 0;
    	        var mssg = "";
    	        
    	        // Type/Size Check 가 되어있는 경우에는 WRS Marking uncheck 불가(S) ------------------------------ #2007.10.01 by sj
    	        if(sheetObj.CellValue(Row, "d2_flg") == "1") {
    	            tpsz_chk = 1;
    	            mssg = "D2";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "d4_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "D4";
    	            else          mssg += ", D4";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "d5_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "D5";
    	            else          mssg += ", D5";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "d7_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "D7";
    	            else          mssg += ", D7";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "o2_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "O2";
    	            else          mssg += ", O2";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "o4_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "O4";
    	            else          mssg += ", O4";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "o5_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "O5";
    	            else          mssg += ", O5";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "a2_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "A2";
    	            else          mssg += ", A2";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "a4_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "A4";
    	            else          mssg += ", A4";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "a5_flg") == "1") {
    	        	tpsz_chk = 1;
    	        	if(mssg == "") mssg = "A5";
    	        	else          mssg += ", A5";
    	        }    	        
    	        if(sheetObj.CellValue(Row, "r5_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "R5";
    	            else          mssg += ", R5";
    	        }
    	        if(sheetObj.CellValue(Row, "r2_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "R2";
    	            else          mssg += ", R2";
    	        }  	      
    	        if(sheetObj.CellValue(Row, "r8_flg") == "1") {
    	            tpsz_chk = 1;
    	            if(mssg == "") mssg = "R8";
    	            else          mssg += ", R8";
    	        }      	        
    	        if(tpsz_chk == 1) {
    	            ComShowMessage("Please move " + mssg + " to other WRS empty IRG");
    	            sheetObj.CellValue2(Row, "wrs_chk") = "1";
    	            return false;
    	        }
    	        // Type/Size Check 가 되어있는 경우에는 WRS Marking uncheck 불가(E) -------------------------------------
    	        
    	        // CNTR TYPE/SIZE 비활성화
    	        sheetObj.CellEditable(Row,"d2_flg") = false;
    	        sheetObj.CellEditable(Row,"d4_flg") = false;
    	        sheetObj.CellEditable(Row,"d5_flg") = false;
    	        sheetObj.CellEditable(Row,"d7_flg") = false;
    	        sheetObj.CellEditable(Row,"o2_flg") = false;
    	        sheetObj.CellEditable(Row,"o4_flg") = false;
    	        sheetObj.CellEditable(Row,"o5_flg") = false;
    	        sheetObj.CellEditable(Row,"a2_flg") = false;
    	        sheetObj.CellEditable(Row,"a4_flg") = false;
    	        sheetObj.CellEditable(Row,"a5_flg") = false;
    	        sheetObj.CellEditable(Row,"r2_flg") = false;
    	        sheetObj.CellEditable(Row,"r5_flg") = false;
    	        sheetObj.CellEditable(Row,"r8_flg") = false;
    	    }
    	}
    	// wrs 가 Check 된 경우에만, CNTR TYPE/SIZE Check 가능(E) ----------------------------------------------------
    	
    	// From Location 에 연결된 Empty IRG 에 대해서 동일한 Type/Size 는 중복 check 되지 않도록.
    	// Check 하면, 같은 From Location 에 대해서 이전 Check 된 동일한 type/size는 uncheck(S) ------------------------------------
    	var ori_loc = sheetObj.CellValue(Row, "ori_loc");    // From Location
    	var col_nm = sheetObj.ColSaveName(Col);
    	
    	if( col_nm == "d2_flg" ||
    	    col_nm == "d4_flg" ||
    	    col_nm == "d5_flg" ||
    	    col_nm == "d7_flg" ||
    	    col_nm == "o2_flg" ||
    	    col_nm == "o4_flg" ||
    	    col_nm == "o5_flg" ||
    	    col_nm == "a2_flg" ||
    	    col_nm == "a4_flg" ||
    	    col_nm == "a5_flg" ||
    	    col_nm == "r2_flg" ||
    	    col_nm == "r5_flg" ||
    	    col_nm == "r8_flg"
    	) {
    	    if( sheetObj.CellValue(Row, col_nm) == "1"){
    	        
        	    for(i=1; i<= sheetObj.rowcount;i++) {
     
        	        if(i != Row && sheetObj.CellValue(i, "ori_loc") == ori_loc && sheetObj.CellValue(i, col_nm) == "1") {
        	            sheetObj.CellValue2(i, col_nm) = "0";      // OnChange Event 발생하지 않음.
        	        } else {
        	            continue;
        	        }
        	    }
    	    }
    	} 
    	// Check 하면, 같은 From Location 에 대해서 이전 Check 된 동일한 type/size는 uncheck(E) ---------------------------------------   	
 	
    }
 

    function sheet2_OnChange (sheetObj,Row,Col,Value) {
        var lnk_org_loc_cd = sheetObj.CellValue(Row,"lnk_org_loc")+sheetObj.CellValue(Row,"lnk_org_type");
        var lnk_dest_loc_cd = sheetObj.CellValue(Row,"lnk_dest_loc")+sheetObj.CellValue(Row,"lnk_dest_type");
        
 

        
        if((sheetObj.RowStatus(Row) =="I" || sheetObj.RowStatus(Row) =="U" ) && 
           ( sheetObj.ColSaveName(Col)=="lnk_org_loc" || sheetObj.ColSaveName(Col)=="lnk_dest_loc" || sheetObj.ColSaveName(Col)=="trsp_mod_cd" ||
             sheetObj.ColSaveName(Col)=="lnk_org_type" || sheetObj.ColSaveName(Col)=="lnk_dest_type" ) ) 
        {
           
            //링크 validation 검사
            if(sheetObj.CellValue(Row,"lnk_org_loc")!="" && sheetObj.CellValue(Row,"lnk_dest_loc")!="" && sheetObj.CellValue(Row,"trsp_mod_cd")!="" &&
               sheetObj.CellValue(Row,"lnk_org_type")!="" && sheetObj.CellValue(Row,"lnk_dest_type")!="" ) 
            {
      
                sheetObj.DoRowSearch("ESD_PRD_0005ROWSEARCH.do", "f_cmd="+SEARCH11+"&from_nod="+lnk_org_loc_cd +"&to_nod="+lnk_dest_loc_cd +"&trsp_mod="+sheetObj.CellValue(Row,"trsp_mod_cd")+"&row="+Row+"&col="+Col ) 
                if(sheetObj.EtcData("rowCount")==0) {
                    sheetObj.CellValue2(Row,"vndr_seq")="";
                    sheetObj.CellValue2(Row,"vndr_name")="";
                    sheetObj.CellValue2(Row,"tztm_hrs")="";
                    sheetObj.CellValue2(Row,"rail_crr_tp_cd")="";
                    sheetObj.CellValue2(Row,"inlnd_rout_cmb_flg")="";
                    sheetObj.CellValue2(Row,"inlnd_rout_junc_nm")="";
                    sheetObj.SelectCell(Row,"lnk_dest_loc");
                }
            }
        }
        
        //sp 코드 체크 
    	if (sheetObj.ColSaveName(Col) == "vndr_seq")
    	{
            if( sheetObj.CellValue(Row,"vndr_seq").length > 0) {
                //validateData 는 체크할 nod cd 
                
                validateData = sheetObj.CellValue(Row,"vndr_seq");
                doActionIBSheet2(sheetObj,document.form, SEARCH08);
            }   
    	} 
        // agree no validation 검사 ㅏ
        if ( sheetObj.ColSaveName(Col) == "agmt_no"  ){
            if(Value =="") {
                sheetObj.CellValue2(Row,"refe_no")="";
                return;
            }
            var cty_cd = Value.substring(0,3);
            var agmt_cd = Value.substring(3);
            var vndr_seq = sheetObj.CellValue(Row,"vndr_seq");
            sheetObj.DoRowSearch("ESD_PRD_0005_AGMT_NO_GS.do", "f_cmd="+SEARCH01+"&cty_cd="+cty_cd +"&agmt_seq="+agmt_cd +"&row="+Row+"&col="+Col+"&vndr_seq="+vndr_seq ) 
        	if(sheetObj.EtcData("rowCount")==0) {
        	    sheetObj.CellValue2(Row,"refe_no")="";
        	}else {
        	    if(sheetObj.EtcData("trs_vndr_seq") != vndr_seq ) {
                  ComShowMessage(ComGetMsg('PRD90070'));
                  sheetObj.CellBackColor(Row,"vndr_seq") =sheetObj.RgbColor(255,160,64);
                  sheetObj.CellBackColor(Row,"agmt_no") =sheetObj.RgbColor(255,160,64);
        	    }else {
        	      sheetObj.CellBackColor(Row,"vndr_seq") =sheetObj.RgbColor(255,255,255);
                  sheetObj.CellBackColor(Row,"agmt_no") =sheetObj.RgbColor(255,255,255);  
        	    }
        	}
        } 
    	// 미주이고 Rail 인지 확인하고 ,미주이고 Rail일때 입력가능하게 ENABLE,DISABLE  (S) -----------------------------------------------
    	if( checkFromTo4US(sheetObj) && sheetObj.CellValue(Row,"trsp_mod_cd")=="RD" ) {
    	    sheetObj.CellEditable(Row,"agmt_no") = true;
    	    sheetObj.CellEditable(Row,"rail_crr_tp_cd" ) = true;
    	    sheetObj.CellEditable(Row,"inlnd_rout_junc_nm" ) = true;
    	} else {
    		
    		
    	    sheetObj.CellValue2(Row,"agmt_no")="";
    	    sheetObj.CellValue2(Row,"refe_no")="";
    	    sheetObj.CellValue2(Row,"rail_crr_tp_cd")="";
    	    sheetObj.CellValue2(Row,"inlnd_rout_junc_nm")="";
    	    
    	    sheetObj.CellEditable(Row,"agmt_no") = false;
    	    sheetObj.CellEditable(Row,"rail_crr_tp_cd" ) = false;
    	    sheetObj.CellEditable(Row,"inlnd_rout_junc_nm" ) = false;
    	    
    	}
    	
    	// 미주이고 Rail 인지 확인하고 ,미주이고 Rail일때 입력가능하게 ENABLE,DISABLE (E) -----------------------------------------------           
        
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
            
            classId = "COM_ENS_061";
    	    param = '?loc_cd='+loc_cd_val+'&classId='+classId;
    		  
    	    chkStr = dispaly.substring(0,3)          
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true,true,row, col);
        }
        
        if ( sheetObj.ColSaveName(col) == "vndr_seq"  )
        {
            loc_cd_val = sheetObj.CellValue(row, col);
           
            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            
            classId = "COM_ENS_0C1";
    	    param = '?pts_vndr_cd='+loc_cd_val+'&classId='+classId;
    		  
    	    chkStr = dispaly.substring(0,3)          
            
            // Radio PopUp  
            if(chkStr == "1,0") {
            	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVendor', dispaly, true,false ,row, col);
           
            } else {
               ComShowMessage(ComGetMsg('PRD90063'));
               return;
            }
        }    
     }    
     
     function getVendor(rowArray, row, col) {
        var sheetObj = sheetObjects[1];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
    	sheetObj.CellValue2(row, "vndr_name") = colArray[4];
    	
    }
     
/**
 * Location : 팝업에서 Radio로 단일 선택을 한경우..
 */
    function getNode(rowArray, row, col) {
        var sheetObj = sheetObjects[1];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue2(parseInt(row), parseInt(col)+1) = colArray[3].substring(5);
    	sheetObj.CellValue2(parseInt(row), parseInt(col)) = colArray[3].substring(0,5);
    	
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
        	ComEnableObject(formObj.i_inv,false);
        	ComEnableObject(formObj.i_rout_pln_cd,false);
        	ComEnableObject(formObj.i_wrs_fl_cd,false);
        	ComEnableObject(formObj.i_wrs_mt_cd,false);
            
        } else{
        	ComEnableObject(formObj.i_inv,true);
        	ComEnableObject(formObj.i_rout_pln_cd,true);
        	ComEnableObject(formObj.i_wrs_fl_cd,true);
        	ComEnableObject(formObj.i_wrs_mt_cd,true);
        }
        var gubun = formObj.rBtnIrgCd.value ;
    }
    
    function chkAmericanContinent(formObj) {
        var org  = formObj.i_org_cd.value.substring(0,2);
        var des  = formObj.i_dest_cd.value.substring(0,2);
        
        if( (org == "US" || org == "CA"  ) && (des == "US" || des == "CA"  )) {
            return true;
        }
        
        return false;
        
        
    }
    
    function bottomFrmClear(formObj) {
    	ComClearObject(formObj.i_inv);
    	ComClearObject(formObj.i_rout_pln_cd);
    	ComClearObject(formObj.wrs_chk);
    	ComClearObject(formObj.i_route_rmk);

       
    }
    
    function changeNodTy1(nodTy)  {
        document.form.rBtnNodTyCd1.value = nodTy;
    }
    
    function changeNodTy2(nodTy)  {
        document.form.rBtnNodTyCd2.value = nodTy;
    }    
    
	function changeSelection(gubun){
	    document.form.wrs_flg.value = gubun;
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();

	}    
	
	function setWRS(gb) {
	    
	    var formObj = document.form;
	    if(gb=='M'){
	    	ComEnableObject(formObj.i_wrs_fl_cd,false);
	    	ComEnableObject(formObj.i_bkg_flg,false);
	    	ComEnableObject(formObj.i_wrs_mt_cd,true);
	    } else {
	    	ComEnableObject(formObj.i_wrs_mt_cd,false);
	    	ComEnableObject(formObj.i_bkg_flg,true);
	    	ComEnableObject(formObj.i_wrs_fl_cd,true);	        
	    }
	    
	    
	} 
	
	var portInd = '';
	function selectTml(frm, pt) {
		portInd = pt;
		if(pt == 'IB_ORG_TML')  param = "?node_cd="+frm.from_cd.value;
		if(pt == 'OB_DEST_TML') param = "?node_cd="+frm.to_cd.value;
		if(pt == 'TS_ORG_YD')   param = "?node_cd="+frm.i_org_cd_ts.value;
		if(pt == 'TS_DEST_YD')  param = "?node_cd="+frm.i_dest_cd_ts.value;
		if(pt == 'MT_ORG_YD')   param = "?node_cd="+frm.i_org_cd_ts.value;
		if(pt == 'MT_DEST_YD')  param = "?node_cd="+frm.i_dest_cd_ts.value;		
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	
	function getCOM_ENS_061(rArray) {
		var cArray  =  rArray [0];	
		var frm = document.form;
		if(portInd == 'IB_ORG_TML'){
			 frm.from_cd.value = cArray[3];
		}
		if(portInd == 'OB_DEST_TML'){
			 frm.to_cd.value = cArray[3];
		}
		if(portInd == 'TS_ORG_YD'){
			 frm.i_org_cd_ts.value = cArray[3];
		}
		if(portInd == 'TS_DEST_YD'){
			 frm.i_dest_cd_ts.value = cArray[3];
		}	
		if(portInd == 'MT_ORG_YD'){
			 frm.i_org_cd_mt.value = cArray[3];
		}
		if(portInd == 'MT_DEST_YD'){
			 frm.i_dest_cd_mt.value = cArray[3];
		}									
	}
	function selectLoc(frm, pt) {
		portInd = pt;
		if(pt == 'IB_DEST_LOC') param = "?loc_cd="+frm.i_dest_cd_ib.value;
		if(pt == 'OB_ORG_LOC') param = "?loc_cd="+frm.i_org_cd_ob.value;
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	
	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];	
		var frm = document.form;
		if(portInd == 'IB_ORG_TML'){
			 frm.i_dest_cd_ib.value = cArray[3];
		}	
		if(portInd == 'OB_ORG_LOC'){
			 frm.i_org_cd_ob.value = cArray[3];
		}			
	}	
	
	/* Action Menu 에 대한 Event */
	function sheet1_OnSelectMenu(sheetObj, sAction) {
	     
	   switch(sAction)  {
	       case "Check":    // 선택된 부분 Checked
	          var sColStr = sheetObj.GetSelectionCols("/");
	          var sRow = sheetObj.SelectRow;
	          
	          var arr = sColStr.split("/");
	          
              for (i=0; i<arr.length; i++) {
                  if(   (sheetObj.CellEditable(sRow, arr[i]) == true)
                     && ( (sheetObj.ColSaveName(arr[i]) == "d2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "d4_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "d5_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "d7_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "o2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "o4_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "o5_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "a2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "a4_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "a5_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "r2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "r8_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "r5_flg") )
                      ) {
              	      sheetObj.CellValue2(sRow, arr[i]) = "Y";
                  }
              }
              
              break;
           
           case "Uncheck":  // 선택된 부분 Unchecked
	          var sColStr = sheetObj.GetSelectionCols("/");
	          var sRow = sheetObj.SelectRow;
	          
	          var arr = sColStr.split("/");
              for (i=0; i<arr.length; i++) {
                  if(   (sheetObj.CellEditable(sRow, arr[i]) == true)
                     && ( (sheetObj.ColSaveName(arr[i]) == "d2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "d4_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "d5_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "d7_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "o2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "o4_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "o5_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "a2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "a4_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "a5_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "r2_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "r8_flg")
                     || (sheetObj.ColSaveName(arr[i]) == "r5_flg") )
                      ) {
              	     sheetObj.CellValue2(sRow, arr[i]) = "N";
                  }
              }
              
              break;
	   }
	    
	}
    function changeDeltFlg() {
        var frm = document.form;
        sheetObjects[0].RemoveAll();
        sheetObjects[0].Redraw = false;
        if(frm.i_del_flg.checked ){
           sheetObjects[0].ColHidden("upd_id")=true;
           sheetObjects[0].ColHidden("upd_date")=true;
           sheetObjects[0].ColHidden("del_id")=false;
           sheetObjects[0].ColHidden("del_date")=false;            
         } else {
           sheetObjects[0].ColHidden("upd_id")=false;
           sheetObjects[0].ColHidden("upd_date")=false;             
           sheetObjects[0].ColHidden("del_id")=true;
           sheetObjects[0].ColHidden("del_date")=true;           
        }
        sheetObjects[0].Redraw = true;
    }
    
	   /*
     * retrieve 를 위한 입력조건 체크 
     */
     function checkInput() {
         var formObject = document.form;
         
         var from_cd = formObject.from_cd.value;
         var to_cd = formObject.to_cd.value;
         
       	 if (from_cd.length > 0 ){
    		 if(!(from_cd.length < 2)){
    			 var org  = from_cd.substring(0,2);
    			 if( chkAmericaCnt("from_cd") == false ){
//    			 if(!(org == "US" || org == "CA" || org == "MX")  ) {
                  	 ComShowMessage(ComGetMsg('PRD90097'));
        			 formObject.from_cd.select();
        			 formObject.from_cd.focus();  
        			 return false;
        		 }
    		 }else{
    			 ComShowMessage(ComGetMsg('PRD90097'));
    			 formObject.from_cd.select();
    			 formObject.from_cd.focus();
    			 return false;
    		 }
    	 }
      	 if (to_cd.length > 0 ) {
    		 if(!(to_cd.length < 2)){
    			 var dest  = to_cd.substring(0,2);
    			 if( chkAmericaCnt("to_cd") == false ){
//               if(!(dest == "US" || dest == "CA" || dest == "MX")  ) {
               	    ComShowMessage(ComGetMsg('PRD90097'));
               	    formObject.to_cd.select();
               	    formObject.to_cd.focus(); 
               		return false;
               	 } 
    		 }else{
    			 ComShowMessage(ComGetMsg('PRD90097'));
    			 formObject.to_cd.select();
    			 formObject.to_cd.focus();
    			 return false;
    		 }
    	 }
         return true;
        
     }
     
     //2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
//     function getAmericaCntCd(){
//    	 document.form.f_cmd.value = SEARCH01;
//         sParam = PrdFQString(document.form);
//         var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0057GS.do", sParam);
//         document.form.cnt_cd.value = ComGetEtcData(sXml,"cnt_cd");
//     }
     
     //2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
     function chkAmericaCnt(objNm){
    	 var cnt_cd = document.form.cnt_cd.value;
    	 var obj = document.getElementsByName(objNm);
    	 var str = obj[0].value;
    	 var cnt = 0;
    	 
    	 if( cnt_cd != null && cnt_cd.length >= 3 ){
    		 for( var idx=0;idx<cnt_cd.length;idx=idx+3 ){
    			 if( cnt_cd.substr(idx,2) == str.substr(0,2) ){
    				 cnt++;
    			 }
    		 }
    	 }
    	 
    	 if( cnt <= 0 ){
    		 return false;
    	 }else{
    		 return true;
    	 }
     }

     function chkAmericaCntCd(vaCntCd){
    	 var cnt_cd = document.form.cnt_cd.value;
    	 var str = vaCntCd
    	 var cnt = 0;
    	 
    	 if( cnt_cd != null && cnt_cd.length >= 3 ){
    		 for( var idx=0;idx<cnt_cd.length;idx=idx+3 ){
    			 if( cnt_cd.substr(idx,2) == str.substr(0,2) ){
    				 cnt++;
    			 }
    		 }
    	 }
    	 
    	 if( cnt <= 0 ){
    		 return false;
    	 }else{
    		 return true;
    	 }
     }
     