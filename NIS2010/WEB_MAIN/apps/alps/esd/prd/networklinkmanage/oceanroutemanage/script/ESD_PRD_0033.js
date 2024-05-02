/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0033.js
*@FileTitle : Lane Connection by Terminal
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
     * @class ESD_PRD_0033 : ESD_PRD_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0033() {
	this.processButtonClick		= tprocessButtonClick;
	this.getLocation			= getLocation;
	this.checkInput				= checkInput;
	this.Space_All				= Space_All;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validatePort2			= validatePort2;
	this.validateLane			= validateLane;
	this.validateForm			= validateForm;
	
}

// 공통전역변수


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
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];

         /*******************************************************/
         var formObject = document.form;

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
	            if(!checkInput()) return;
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;

       	    case "btn_new":
	            formObject.reset();
	            sheetObject.removeall();
    	        break;

    	    case "btng_rowadd":
	            doActionIBSheet(sheetObject,formObject,IBINSERT);
     	        break;

    	    case "btng_rowcopy":
	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
     	        break;

    	    case "btn_downexcel":
	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	        break;

            case "port_btn":
                
               var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
    	       var classId = "COM_ENS_051";
               var loc_cd_val = formObject.i_port_cd.value;
    		   var param = '?classId='+classId+'&loc_cd='+loc_cd_val;
    		   var chkStr = dispaly.substring(0,3);
                 
                   if(chkStr == "1,0") {
                	   ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLocation', dispaly, true);
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

    function getLocation(rowArray) {
    	var colArray = rowArray[0];
    	document.all.i_port_cd.value = colArray[3];
    }

    function checkInput() {
        var formObject = document.form;
        
        var portCd = Space_All(formObject.i_port_cd.value);
        var ilane_from = Space_All(formObject.i_lane_from.value);
        var ilane_to = Space_All(formObject.i_lane_to.value);       
        
        formObject.i_port_cd.value = portCd;
        formObject.i_lane_from.value = ilane_from;
        formObject.i_lane_to.value = ilane_to;
        
        if(portCd.length != 5){
            ComShowMessage(ComGetMsg('PRD90007'));
            formObject.i_port_cd.focus();
            return false;
        }else{
            if(ilane_from.length > 0) {
                if(ilane_from.length != 3){
                    ComShowMessage(ComGetMsg('PRD90007'));
                    formObject.i_lane_from.focus();
                    return false;
                }else if(ilane_from.length == 3 && ilane_to.length == 0){
                    formObject.i_lane_to.value = formObject.i_lane_from.value;
                }else if(ilane_from.length == 3 && ilane_to.length != 3){
                    ComShowMessage(ComGetMsg('PRD90007'));
                    formObject.i_lane_to.focus();
                    return false;
                }               
            }else if(ilane_to.length > 0){
                ComShowMessage(ComGetMsg('PRD90007'));
                formObject.i_lane_from.focus();
                return false;
            }
        }        
                    
        return true;
    }   

    /**
     * 문자열 공백을 모두 제거.
     */
    function Space_All(str)
    {
      var index, len
               
      while(true)
      {
       index = str.indexOf(" ")
       // 공백이 없으면 종료합니다.
       if (index == -1) break
       // 문자열 길이를 구합니다.
       len = str.length
       // 공백을 잘라냅니다.
       str = str.substring(0, index) + str.substring((index+1),len)
      }
       
      return str;
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

        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_port_cd', 'i_lane_from', 'i_lane_to');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'i_port_cd', 'i_lane_from', 'i_lane_to');

    }
     
   /**
    * tab event처리
    * @return
    */
   function prdComKeyDown(){
	   var keyObj=window.event.keyCode;
   	
    	if(keyObj == 9){
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		if(srcName == "i_port_cd"){
  	  			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
    		}else if(srcName == "i_lane_from"){
    			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
    		}else if(srcName == "i_lane_to"){
    			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
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
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                                        
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
                    InitColumnInfo(18, 0, 0, true);
                    

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "Del.|STS|SEQ|Port|From|From|From|From|From|To|To|To|To|To|Staying Day|D2 (USD)|D4 (USD)|D5 (USD)";
                    var HeadTitle2 = "Del.|STS|SEQ|Port|Lane|Carrier|Dir.|Yard Code|Yard Name|Lane|Carrier|Dir.|Yard Code|Yard Name|Staying Day|Shuttle|Shuttle|Shuttle";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, false);
                    
                    
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,   daCenter,  true,    "");
                    InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++,  dtSeq,        60,    daCenter,  true,    "");
                    InitDataProperty(0, cnt++, dtData,       40,    daCenter,  true,    "std_port",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "fm_lane",        false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "fm_crr",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       30,    daCenter,  true,    "fm_dir",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "fm_tml",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,      100,    daLeft,  true,    "fm_tml_nm",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       40,    daCenter,  true,    "to_lane",        false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "to_crr",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       30,    daCenter,  true,    "to_dir",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "to_tml",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,      100,    daLeft,  true,    "to_tml_nm",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "st_time",        false,          "",       dfUserFormat2,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtData,       60,    daCenter,  false,    "stl_amt_d2",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       60,    daCenter,  false,    "stl_amt_d4",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,       60,    daCenter,  false,    "stl_amt_d5",        false,          "",       dfNone,    0,     false,       false);
                    InitUserFormat2(0, "st_time", "#D", "D" );

		            RangeBackColor(1, 4, 1, 13) = RgbColor(222, 251, 248);   // alps
		            RangeBackColor(1, 15, 1, 20) = RgbColor(222, 251, 248);   // alps

                    
               }
                break;
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,a, PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
                    if(validateForm(sheetObj,formObj,sAction))
                    formObj.f_cmd.value = SEARCHLIST;
                    if(PageNo != null){
                        formObj.iPage.value= PageNo;
                    }
                    sheetObj.DoSearch4Post("ESD_PRD_0033GS.do", PrdFQString(formObj));
                break;

            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))

                break;
          case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.SpeedDown2Excel(-1);
              break;

           case IBINSERT:      // 입력
                sheetObj.DataInsert();
                break;

           case IBCOPYROW:      // 입력
                sheetObj.DataCopy();
                break;
                
           
           case SEARCH01:
              formObj.f_cmd.value = SEARCH01;
    
              var uid= "ESD_PRD_0033";
              var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
           case SEARCH07:
              formObj.f_cmd.value = SEARCH07;
        
              var uid= "ESD_PRD_0033";
              var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;              
        }
    }
    
    
        
    function validatePort2(port) {
        //this.value=this.value.toUpperCase();
        if(port.length < 1) return false;
        validateData = port.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	if(retValidate < 1) {
        	document.form.i_port_cd.value = "";
        	document.form.i_port_cd.focus();
    	} else {
    	    document.form.i_lane_from.focus();
    	}
        return false;
    }

    function validateLane(lane, num) {
        //this.value=this.value.toUpperCase();
       	if (num ==1) {
        	document.form.i_lane_from.value = lane.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.i_lane_to.value = lane.toUpperCase();
    	}   
        if(lane.length < 1) return false;
        validateData = lane.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH07);
    	if(retValidate < 1) {
    	    if (num ==1) {
            	document.form.i_lane_from.value = "";
            	document.form.i_lane_from.focus();
        	} else if (num ==2) {
            	document.form.i_lane_to.value = "";
            	document.form.i_lane_to.focus();
        	}

    	} else {
    	    if (num ==1) {
                document.form.i_lane_to.focus();
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
