/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0004.js
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
* 1.0 Creation
* 2011.02.14 정선용 [CHM-201108587-01] Inland Link Management 및 Hub Location Management
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
     * @class ESD_PRD_0004 : ESD_PRD_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ESD_PRD_0004() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.checkInput				= checkInput;
    	this.checkAdd				= checkAdd;
    	this.prdComKeyDown			= prdComKeyDown;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.getLocGrid				= getLocGrid;
    	this.getCOM_ENS_051_1		= getCOM_ENS_051_1;
    	this.getPort				= getPort;
    	this.getHub					= getHub;
    	this.getLoc					= getLoc;
    	this.validatePort			= validatePort;
    	this.validatePort2			= validatePort2;
    	this.validateLocation		= validateLocation;
    	this.sheet1_OnChange		= sheet1_OnChange;
    }

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;


var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
    	 var srcName = window.event.srcElement.getAttribute("name");
         
    	 var param ;
    	 var dispaly ;
    	 var classId ;
    	 var chkStr ;
    	 var loc_cd_val ;
    	try{
    		
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
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btn_loadexcel":
        	        doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        	        break;

          	    case "btng_rowcopy":
              	    //if(!checkAdd(sheetObject)) return;
        	       doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;

        	    case "btng_rowadd":
        	        //if(!checkAdd(sheetObject)) return;
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
              
                case "port_btn":
                   var loc_port_ind_val = "";
                   loc_cd_val = "" ;
                   
                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
        		 
        		   loc_port_ind_val = "1";
        		   loc_cd_val = formObject.in_port_cd.value;
        		   param = '?classId='+classId+'&loc_port_ind='+loc_port_ind_val+'&loc_cd='+loc_cd_val;
        			  
        		   chkStr = dispaly.substring(0,3)
                      
                   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getPort', dispaly, true);
                       
                       
                  break;
                case "hub_btn":

                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
                   loc_cd_val = formObject.in_hub_loc_cd.value;
        		   param = '?classId='+classId+'&loc_cd='+loc_cd_val;
        			  
        		   chkStr = dispaly.substring(0,3)
                   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getHub', dispaly, true);
                  break;
                case "loc_btn":

                   dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId = "COM_ENS_051";
                   loc_cd_val = formObject.in_loc_cd.value;
        		   param = '?classId='+classId+'&loc_cd='+loc_cd_val;
        			  
        		   chkStr = dispaly.substring(0,3)

                   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLoc', dispaly, true);
                     
                  break;
            } // end switch
          
    	}catch(e) {
    		
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('PRD90054'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    	
    }

    /*
     * retrieve 를 위한 입력조건 체크 
     */
     function checkInput() {
         var formObject = document.form;
         
         var portCd = formObject.in_port_cd.value;
         var hubCd = formObject.in_hub_loc_cd.value;
         var locCd = formObject.in_loc_cd.value;
//         if(portCd.length != 5){
//        
//             ComShowMessage(ComGetMsg('PRD90004'));
//             formObject.in_port_cd.focus();
//             return false;
//         }
//         if(hubCd.length != 5 && locCd.length != 5 ){
//      
//             ComShowMessage(ComGetMsg('PRD90004'));
//             formObject.in_hub_loc_cd.focus();;
//             return false;
//         }
         
         if(portCd.length == 0  && hubCd.length == 0  && locCd.length == 0 ){
        	 ComShowMessage(ComGetMsg('PRD90119','one','2'));
        	 formObject.in_port_cd.focus();
        	 return false;
         }
         if (portCd.length > 0){
        	// if(portCd.length != 5 ){ 
        	// 2자리 이상 입력시 조회되도록 변경 2012.01.10 Kim Hyun hwa
         	   if(portCd.length < 2 ){
             	 ComShowMessage(ComGetMsg('PRD90119','one','2'));
            	 formObject.in_port_cd.focus();
            	 return false;
        	 }
         }
         if (hubCd.length  > 0 ){
         	// if(hubCd.length != 5 ){ 
         	// 2자리 이상 입력시 조회되도록 변경 2012.01.10 Kim Hyun hwa
          	   if(hubCd.length < 2 ){
        	 		ComShowMessage(ComGetMsg('PRD90119','one','2'));
        	 		formObject.in_hub_loc_cd.focus();
        	 		return false;
        	 	}
         }
         if (locCd.length > 0 ){
         	// if(locCd.length != 5 ){ 
         	// 2자리 이상 입력시 조회되도록 변경 2012.01.10 Kim Hyun hwa
          	   if(locCd.length < 2 ){
        	 		ComShowMessage(ComGetMsg('PRD90119','one','2'));
        	 		formObject.in_loc_cd.focus();
        	 		return false;
        	 	}
         }
         
//         if(portCd.length != 5 && hubCd.length != 5 && locCd.length != 5 ){
//        	 ComShowMessage(ComGetMsg('PRD90117'));
//             formObject.in_port_cd.focus();
//             return false;
//         }
         
         return true;
     }

    /*
     * add button disable 여부 체크 
     */
     function checkAdd(sheetObject) {
         
         
         if(sheetObject.RowCount >0) {
             ComShowMessage(ComGetMsg('PRD90062'));
             return false;
           
         }
         return true;
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
			ComConfigSheet (sheetObjects[i] );
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
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'in_port_cd', 'in_hub_loc_cd', 'in_loc_cd');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'in_port_cd', 'in_hub_loc_cd', 'in_loc_cd');
    }
     
     
     /**
      * tab 이벤트 처리
      * @return
      */
     function prdComKeyDown(){
    	var keyObj=window.event.keyCode;
     	var formObj = document.form;
     	if(keyObj == 9){
         	var srcName = window.event.srcElement.getAttribute("name");
     		if(srcName == "in_port_cd" && formObj.in_port_cd.value.length == 5){
   	  			inputChkUpper(document.form.in_port_cd,keyObj , 'SEARCH01');
//   	  			formObj.in_hub_loc_cd.focus();
     		}else if(srcName == "in_hub_loc_cd" && formObj.in_port_cd.value.length == 5){
     			inputChkUpper(document.form.in_hub_loc_cd,keyObj , 'SEARCH02');
//     			formObj.in_loc_cd.focus();
     		}else if(srcName == "in_loc_cd" && formObj.in_loc_cd.value.length == 5){
     			inputChkUpper(document.form.in_loc_cd,keyObj , 'SEARCH02');
//     			formObj.in_port_cd.focus();
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
                    style.height = 400 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
                    
                    var HeadTitle1 = "Del.|STS|SEQ|Port|Hub Location|Location|Mode|Office|Creation DT|Update DT|User ID|Remarks" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    var prefix="sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",               false,  "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,   "ibflag",          false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,  false,    "",               false,  "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  60,    daCenter,  false,   "port_cd",         true,   "",       dfNone,     0,     false,       true ,5);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,  false,   "hub_loc_cd",      true,   "",       dfNone,     0,     true,        true,5);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,  false,   "loc_cd",          true,   "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  false,   "trsp_mod_cd",     true,   "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,   "cre_ofc_cd",      false,  "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,   "cre_dt",          false,  "",       dfDateYmd,  0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,   "upd_dt",          false,  "",       dfDateYmd,  0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,   "cre_usr_id",      false,  "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "hub_loc_mtch_rmk",false,  "",       dfNone,     0,     true,        true);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo(0,"trsp_mod_cd", trsp_mod_cdText, trsp_mod_cdCode);
        		    
					InitDataValid(0, "port_cd",     vtEngUpOther, "1234567890");
					InitDataValid(0, "hub_loc_cd",  vtEngUpOther, "1234567890");
					InitDataValid(0, "loc_cd",      vtEngUpOther, "1234567890");
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
                //       if(!comCheckRequiredField(formObj)) return;
                formObj.f_cmd.value = SEARCH;

                //sheetObj.DoSearch("data_004.htm");
                sheetObj.DoSearch4Post("ESD_PRD_0004GS.do", PrdFQString(formObj));
                break;
            case IBSAVE:        //저장

              if(validateForm(sheetObj,formObj,sAction))

                  formObj.f_cmd.value = MULTI;
                  sheetObj.DoSave("ESD_PRD_0004GS.do", PrdFQString(formObj));

                break;

           case IBINSERT:      // 입력
               if(validateForm(sheetObj,formObj,sAction))
                 var Row = sheetObj.DataInsert();
                 sheetObj.CellValue2(Row, "trsp_mod_cd" )= 'TD';
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
           case SEARCH01:
              formObj.f_cmd.value = SEARCH01;
              uid= "ESD_PRD_0004";
             
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
           case SEARCH02:
              formObj.f_cmd.value = SEARCH02;
              uid= "ESD_PRD_0004";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              break;
                    
        }
    }

// dtPopupEdit 로 처리 할 경우 팝업오픈 처리

    function sheet1_OnPopupClick(sheetObj, row, col)
    {
		
           var param = '?loc_cd='+sheetObj.CellValue(row, col);
        			  
           ComOpenPopup('/hanjin/COM_ENS_051.do'+param,  770, 470, 'getLocGrid', '1,0,1,1,1,1,1,1,1,1,1,1',true,false,row,col);

    }
    
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        if(sheetObj.RowCount>0 && CRUD != "R") {
//            bntImgEnable(document.form.btn_save, true);
//            bntImgEnable(document.form.btn_downexcel, true);
//            bntImgEnable(document.form.btng_rowcopy, true);
//            bntImgEnable(document.form.btng_rowadd, true);
        } else {
//             bntImgEnable(document.form.btn_save, false);
//            bntImgEnable(document.form.btn_downexcel, false);
//            bntImgEnable(document.form.btng_rowcopy, false);
//            bntImgEnable(document.form.btng_rowadd, false);           
        }
    }   
    
    function getLocGrid(rowArray, row, col) {

        var sheetObj = sheetObjects[0];
        
    	var colArray = rowArray[0];
    	if (sheetObj.ColSaveName(col) == "port_cd")
    	{
        	sheetObj.CellValue2(row, "port_cd") = colArray[3];
        	
    	} else if  (sheetObj.ColSaveName(col) == "hub_loc_cd")
    	{
        	sheetObj.CellValue2(row, "hub_loc_cd") = colArray[3];
        	
    	} else if  (sheetObj.ColSaveName(col) == "loc_cd")
    	{
        	sheetObj.CellValue2(row, "loc_cd") = colArray[3];
    	}
    }
    
    function getCOM_ENS_051_1(rowArray) {
    	//ComShowMessageComPopupData(rowArray);
    	
    	var colArray = rowArray[0];
    
    	document.all.in_port_cd.value = colArray[3];

    }
    
    function getPort (rowArray) {

    	//ComShowMessageComPopupData('1:'+rowArray);
    	
    	var colArray = rowArray[0];
    	
    	document.all.in_port_cd.value = colArray[3];
    	
    }
    
    function getHub(rowArray) {
    	//ComShowMessageComPopupData('2'+rowArray);
    	
    	var colArray = rowArray[0];
    	
    	document.all.in_hub_loc_cd.value = colArray[3];
    	
    }
            

    function getLoc(rowArray) {
    	//ComShowMessageComPopupData(rowArray);
    	
    	var colArray = rowArray[0];
    	
    	document.all.in_loc_cd.value = colArray[3];
    	
    }
       
  	// port code 에 대한 validation
    function validatePort(port) {
        if(port.length < 1) return false;
        validateData = port.toUpperCase();
        ComShowMessage("port:"+port+" up:"+validateData);
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	if(retValidate < 1) {
        	document.form.in_port_cd.focus();
    	} else {
    	    document.form.in_hub_loc_cd.focus();
    	}
        return false;

    }
    
    function validatePort2(port) {
        //this.value=this.value.toUpperCase();
        if(port.length < 1) return false;
        validateData = port.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	if(retValidate < 1) {
        	//document.form.in_port_cd.value = "";
        	document.form.in_port_cd.focus();
    	} else {
    	    document.form.in_hub_loc_cd.focus();
    	}
        return false;
    }
    
  	// port code 에 대한 validation
    function validateLocation(loc, num) {
        if(loc.length < 1 && num ==1) {
            document.form.in_loc_cd.focus();
            return;
        } else if(loc.length < 1 && num ==2) return;
        validateData = loc.toUpperCase();
    	if (num ==1) {
        	document.form.in_hub_loc_cd.value = loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.in_loc_cd.value = loc.toUpperCase();
    	}          
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
    	if(retValidate < 1) {
        	if (num ==1) {
            	//document.form.in_hub_loc_cd.value = "";
            	document.form.in_hub_loc_cd.focus();
        	} else if (num ==2) {
            	//document.form.in_loc_cd.value = "";
            	document.form.in_loc_cd.focus();
        	}
    	} else {
        	if (num ==1) {
            	//document.form.in_hub_loc_cd.value = "";
            	document.form.in_loc_cd.focus();
        	} 	    
    	}


    }
    
    
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
        // Get 방식으로 넘길 값 셋팅 
        
        validateData = Value;
      
        if(sheetObj.ColSaveName(Col)=="port_cd") {
          doActionIBSheet(sheetObj,document.form,SEARCH01); 
        } else if (sheetObj.ColSaveName(Col)=="hub_loc_cd" ) {
          doActionIBSheet(sheetObj,document.form,SEARCH02); 
        } else if (sheetObj.ColSaveName(Col)=="loc_cd") {
          doActionIBSheet(sheetObj,document.form,SEARCH02); 
        }
		
        
        
        if(retValidate < 1 && (sheetObj.ColSaveName(Col)=="port_cd" || sheetObj.ColSaveName(Col)=="hub_loc_cd" || sheetObj.ColSaveName(Col)=="loc_cd" )) {
        
           sheetObj.CellValue2(Row,sheetObj.ColSaveName(Col) )="";
           sheetObj.SelectCell(Row,Col );
            return false;
        }
        
    }
   
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        return true;
    }