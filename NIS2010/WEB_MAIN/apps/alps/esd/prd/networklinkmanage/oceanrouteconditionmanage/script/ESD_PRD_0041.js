
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0041.js
*@FileTitle : Carrier별 이용터미널 예외 정보관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009-02-23
*@LastModifier : jungsunyoung
*@LastVersion : 1.0 
* 2009-02-23 jungsunyoung
* 1.0 최초 생성
* 20090421 권한 설정 변경.
=========================================================*/
function ESD_PRD_0041() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.checkMandatory			= checkMandatory;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.getPop2Grid			= getPop2Grid;
	this.getPortLoc				= getPortLoc;
	this.getNode				= getNode;
	this.getLane				= getLane;
	this.getCarrierCd			= getCarrierCd;
	this.validatePort			= validatePort;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.validateTml			= validateTml;
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

        	    case "btng_rowcopy":
      	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;

        	    case "btn_port":
                    dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	        classId = "COM_ENS_051";

        		    param = '?classId='+classId+'&loc_cd='+formObject.i_port_cd.value;
        			  
        		    chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getPortLoc', dispaly, true);
                    } else {
                         ComShowMessage(ComGetMsg('PRD90063'));
                         return;
                    }
        	        break;
        	        
        	    case "btn_tml":
                    var loc_cd_val = formObject.i_tml_cd.value;
                   
                    dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    
                    classId = "COM_ENS_061";
            	    param = '?node_cd='+loc_cd_val+'&classId='+classId;
            		  
            	    chkStr = dispaly.substring(0,3)          
                    
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', dispaly, true);
                   
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
        	        break;       
        	    case "btn_slan":
                    var slan_cd_val = formObject.i_vsl_slan_cd.value;
                   
                    dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    
                    classId = "COM_ENS_081";
            	    param = '?&lane_cd='+slan_cd_val+'&classId='+classId;
            		  
            	    chkStr = dispaly.substring(0,3);         
                    
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', dispaly, true);
                   
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
        	        break;
        	                   	        
        	    case "btn_crr":

                    dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    
                    classId = "COM_ENS_0N1"; //ESD_PRD_0030

                    param = '?classId='+classId+'&func=getCarrierCd&display='+dispaly+'&crr_cd='+formObject.i_crr_cd.value;
            		  
            	    chkStr = dispaly.substring(0,3);          
                    // Radio PopUp  
                    if(chkStr == "1,0") {
        		
                          myWin = ComOpenWindowCenter('COM_ENS_0N1.do'+param, 'compop', 420,450, true);
        	              myWin.focus();
                   
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
                    

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
        
        //권한부여
    	if(CRUD != "S") {
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btng_rowadd");
    		ComBtnDisable("btng_rowcopy");
//    		ComEnableObject(document.getElementById("btn_save"), false);
//    		ComEnableObject(document.getElementById("btng_rowadd"), false);
//    		ComEnableObject(document.getElementById("btng_rowcopy"), false);
    	}        
        
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_port_cd', 'i_vsl_slan_cd');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'i_port_cd','i_vsl_slan_cd');

    }
     
    function prdComKeyDown(){
    	var keyObj=window.event.keyCode;
    	
     	if(keyObj == 9){
     		var srcName = window.event.srcElement.getAttribute("name");
     		
     		if(srcName == "i_port_cd"){
   	  			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
     		}else if(srcName == "i_vsl_slan_cd"){
     			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH10');
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
                    style.height = GetSheetHeight(12) ;
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
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Seq.|STS|Del.|Port|Lane Code|Bound|TMNL Code|Terminal Name|Creation DT|Update DT|User ID" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    "",            false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",      false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtDelCheck,   40,    daCenter,  false,    "",            false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       65,    daCenter,  false,    "port_cd",     false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  80,    daCenter,  false,    "vsl_slan_cd", false,  "",       dfNone,     0,     false,      false ,3 );
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  false,    "skd_dir_cd",  true,   "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,  false,    "tml_cd",      true,   "",       dfNone,     0,     true,       true, 7);
                    InitDataProperty(0, cnt++ , dtData,       230,   daLeft,    false,    "yd_nm",       false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       75,    daCenter,  false,    "cre_dt",      false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,    "upd_dt",      false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "upd_usr_id",  false,  "",       dfNone,     0,     false,      false);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    InitDataCombo (0, "skd_dir_cd", "E|W|N|S", "E|W|N|S");

					InitDataValid(0, "vsl_slan_cd", vtEngUpOther, "1234567890");
					InitDataValid(0, "tml_cd",      vtEngUpOther, "1234567890");
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
                
                if(!checkMandatory() ) return;
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_PRD_0041GS.do", PrdFQString(formObj));
                break;
            case IBSAVE:        //저장
     
              if(validateForm(sheetObj,formObj,sAction))

                formObj.f_cmd.value = MULTI;
                sheetObj.DataAutoTrim = true;
                sheetObj.DoSave("ESD_PRD_0041GS.do", PrdFQString(formObj));
                sheetObj.DataAutoTrim = false;
                break;

           case IBINSERT:      // 입력
         
                if(validateForm(sheetObj,formObj,sAction))
                var Row = sheetObj.DataInsert();
                sheetObj.CellValue2(Row, "port_cd") = formObj.i_port_cd.value;
                sheetObj.CellValue2(Row, "vsl_slan_cd") = "FDR";
                
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
        
              uid= "ESD_PRD_0041";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
           case SEARCH05:
              formObj.f_cmd.value = SEARCH05;
         
              uid= "ESD_PRD_0041";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;   
           case SEARCH10:
              formObj.f_cmd.value = SEARCH10;
          
              uid= "ESD_PRD_0041";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;  
           case SEARCH11:
              formObj.f_cmd.value = SEARCH11;
            
              uid= "ESD_PRD_0041";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
                //rowcount 가 1보다 작으면 
                if(retValidate < 1) {
                    sheetObj.CellValue2(sheetObj.selectRow,"tml_cd") = "";
                    sheetObj.SelectCell(sheetObj.selectRow,"tml_cd");
                }              
              break;      
           case SEARCH04:
              formObj.f_cmd.value = SEARCH04;
           
              uid= "ESD_PRD_0041";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              if (retValidate != null) {

                  sheetObj.CellValue2(sheetObj.SelectRow, "yd_nm") = sheetObjects[0].EtcData("comData1");
              }else{
                  sheetObj.CellValue2(sheetObj.SelectRow, "yd_nm") = "";
              }
              break;
                                                           
        }
    }

    /*
     * Mandatory 체크 
     */
    function checkMandatory() {
        var formObj = document.form;
        var retValue = true;
        var portCd = formObj.i_port_cd.value;

        if( portCd.length != 5 ) {
             ComShowMessage(ComGetMsg('PRD90007'));
             formObj.i_port_cd.focus();;
             retValue = false;
        } 
        return retValue;
    }
    
// dtPopupEdit 로 처리 할 경우 팝업오픈 처리

    function sheet1_OnPopupClick(sheetObj, row, col){
    	var lane_cd ;
    	var tml_cd ;
    	var param ;
    	
        if ( sheetObj.ColSaveName(col) == "vsl_slan_cd"   )
        {
            lane_cd = sheetObj.CellValue(row, col);
            param = '?&lane_cd='+lane_cd;
    		  
            ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,false, row, col);
        } else if ( sheetObj.ColSaveName(col) == "crr_cd" )
        {
            lane_cd = sheetObj.CellValue(row, col);
            param = '?&lane_cd='+lane_cd;
    		  
            ComOpenPopup('/hanjin/COM_ENS_0N1.do' + param, 420, 450, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,false, row, col);
        } else if ( sheetObj.ColSaveName(col) == "tml_cd" )
        {
            tml_cd = sheetObj.CellValue(row, col);
            param = '?&node_cd='+tml_cd;
    		  
            ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,false, row, col);
        } 
    }
    
    

    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        if(sheetObj.RowCount>0 && CRUD!="R") {
        	ComBtnEnable("btn_save");
//        	ComEnableObject(document.getElementById("btn_save"), true);                    
        } 
    }  
    

    function getPop2Grid(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
    	var colArray = rowArray[0];

        if (sheetObj.ColSaveName(col) == "vsl_slan_cd")
    	{
        	sheetObj.CellValue2(row, "vsl_slan_cd") = colArray[3];
    	} else if (sheetObj.ColSaveName(col) == "crr_cd")
    	{
        	sheetObj.CellValue2(row, "crr_cd") = colArray[3];
    	} else if (sheetObj.ColSaveName(col) == "tml_cd")
    	{
        	sheetObj.CellValue2(row, "tml_cd") = colArray[3];
        	sheetObj.CellValue2(row, "yd_nm") = colArray[4];
        	
    	}
    	// POP UP에서 가져왔을때도  port code 에 대한 validation
    	sheet1_OnChange(sheetObj,row,col,colArray[3])
    }
    
    function getPortLoc(rowArray) {
    
    	
    	var colArray = rowArray[0];
    	document.all.i_port_cd.value = colArray[3];
    }
/**
 * Location : 팝업에서 Radio로 단일 선택을 한경우..
 */
    function getNode(rowArray, row, col) {
        var sheetObj = sheetObjects[1];
        
    	var colArray = rowArray[0];
    
    	document.all.i_tml_cd.value = colArray[3];

    	
    }

    function getLane(rowArray) {

    	var colArray = rowArray[0];
    	
    	document.all.i_vsl_slan_cd.value = colArray[3];
    	validateData = document.all.i_vsl_slan_cd.value;
        doActionIBSheet(sheetObjects[0],document.form,SEARCH10);    
        if(retValidate < 1 ) {
            document.all.i_vsl_slan_cd.focus();
     
        }
    	
    }

    function getCarrierCd(rowArray) {
    	//alertComPopupData(rowArray);
    	
    	var colArray = rowArray[0];
    	document.all.i_crr_cd.value = colArray[3];
    }
        
  	// port code 에 대한 validation
    function validatePort(port) {
        validateData = port.toUpperCase();
        document.form.i_port_cd.value = port.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	if(retValidate < 1) {
        
            document.form.i_port_cd.focus();    	        

    	}else {
    	    document.form.i_vsl_slan_cd.focus();  
    	}
    	return false;
    }

    function sheet1_OnChange(sheetObj,Row,Col,Value) {

        
        // Get 방식으로 넘길 값 셋팅 
        validateData = Value;
        if((sheetObj.ColSaveName(Col)=="tml_cd") && (sheetObj.ReadDataProperty(Row, Col, dpEditLen) == 7)) {
          doActionIBSheet(sheetObj,document.form,SEARCH04);
        }  
                
    }

    
  	// tml code 에 대한 validation
    function validateTml(tml) {
        validateData = tml.toUpperCase();
        document.form.i_tml_cd.value = tml.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
    	if(retValidate < 1) {
        	document.form.i_tml_cd.value = "";
        	document.form.i_tml_cd.focus();
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