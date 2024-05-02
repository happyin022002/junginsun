/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0013.js
*@FileTitle :RHQ Ocean Link Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.24 김귀진
* 1.0 Creation
* history
* 2011.01.12 채창호 [CHM-201108287] [PRD] RHQ Ocean Link Management의 Lane Code 입력불가 요청.
* 2012.06.07 변종건 [CHM-201217633] TRS의 Cost Batch Error Inquiry 화면에서 PRD 화면 호출 기능 추가
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
     * @class ESD_PRD_0013 : ESD_PRD_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

function ESD_PRD_0013() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;			
	this.sheet1_OnChange		= sheet1_OnChange;
	this.lpad					= lpad;
	this.getFromYardGrid		= getFromYardGrid;
	this.getToYardGrid			= getToYardGrid;
	this.getSPBd				= getSPBd;
	this.selectPort				= selectPort;
	this.getCOM_ENS_051			= getCOM_ENS_051;
	
}

//공통 전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var validateLane="";
var retValidate = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
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

        	    case "btn_loadexcel":
    	            doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        	        break;

                    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_rowcopy":
    	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;

                case "btng_constraintLink":
                      document.location.href="ESD_PRD_0024.do?f_cmd="+SEARCH02+"&fromNd="+sheetObject.CellValue(sheetObject.selectRow, "s_from" ) +"&toNd="+sheetObject.CellValue(sheetObject.selectRow, "s_to" )+"&link_flg=Y&pgmNo=ESD_PRD_0024";
        	          break;

				case "btn_port_fm":
					selectPort('POL') ;
					break;

				case "btn_port_to":
					selectPort('POD') ;
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
			ComBtnDisable("btng_rowadd");
			ComBtnDisable("btng_rowcopy");
//			ComEnableObject(document.getElementById("btn_save"), false);
//			ComEnableObject(document.getElementById("btng_rowadd"), false);
//			ComEnableObject(document.getElementById("btng_rowcopy"), false);
		}
		
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'port_fm', 'port_to');
		
		
		//2012.06.07 변종건 [CHM-201217633] TRS의 Cost Batch Error Inquiry 화면에서 PRD 화면 호출 기능 추가
		if( document.form.port_fm.value != "" && document.form.port_to.value != "" ){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "SEQ|Del.|STS|Lane|From|To|T/Time|FQC|Pre/Post|Dir|Preferred S/P Name|Preferred S/P Name|SUN|MON|TUE|WED|THU|FRI|SAT" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,   "",              false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,   "s_del_check",   false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,   "ibflag",        false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "s_lane",        false,         "",       dfNone,     0,     false,      false,3);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "s_from",        true,          "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "s_to",          true,          "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,   "s_t_time",      true,          "",       dfNone,     0,     true,       true,4);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  false,   "s_fqc",         true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,  false,   "s_bd",          true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  false,   "s_dr",          true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  60,    daCenter,  false,   "s_sp_bd",       true,          "",       dfNone,     0,     true,       true,6);
                    InitDataProperty(0, cnt++ , dtData,       220,   daLeft,    false,   "s_sp_bd_name",  false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_sn",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_mn",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_te",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_wb",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_tu",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_fi",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "s_st",          false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  false,   "h_lane",        true,          "",       dfNone,     0,     true,       true,3);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  false,   "h_from",        true,          "",       dfNone,     0,     true,       true,5);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  false,   "h_to",          true,          "",       dfNone,     0,     true,       true,5);
                    InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  false,   "h_t_time",      true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  false,   "h_fqc",         true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,  false,   "h_bd",          true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  false,   "h_dir",         true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  false,   "h_sp_bd",       true,          "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     220,   daCenter,  false,   "h_sp_bd_name",  false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_sun",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_mon",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_tue",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_web",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_thu",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_fri",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_sat",         false,         "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  false,   "h_chk_lane_dir_tztm",  false,  "",       dfNone,     0,     true,       true);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
        		    InitDataCombo (0, "s_fqc", "1|2|3|4|5|6|7|8|9|10|11|12|13|14", "1|2|3|4|5|6|7|8|9|10|11|12|13|14","1");
        		    InitDataCombo (0, "s_bd", "Both|Post|Pre", "B|I|O","B");
        		    InitDataCombo (0, "s_dr", "E|W|N|S", "E|W|N|S","E");
        		    InitDataCombo (0, "h_fqc", "1|2|3|4|5|6|7|8|9|10|11|12|13|14", "1|2|3|4|5|6|7|8|9|10|11|12|13|14","1");
        		    InitDataCombo (0, "h_bd", "Both|Post|Pre", "B|I|O","B");
        		    InitDataCombo (0, "h_dir", "E|W|N|S", "E|W|N|S","E");

					InitDataValid(0, "s_lane", vtEngUpOther, "1234567890");
					InitDataValid(0, "s_from", vtEngUpOther, "1234567890");
					InitDataValid(0, "s_to",   vtEngUpOther, "1234567890");
					InitDataValid(0, "h_lane", vtEngUpOther, "1234567890");
					InitDataValid(0, "h_from", vtEngUpOther, "1234567890");
					InitDataValid(0, "h_to",   vtEngUpOther, "1234567890");
        		    
               }
                break;

        }
    }

	/**
	 * Sheet관련 프로세스 처리
	 * 
	 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
		sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESD_PRD_0013GS.do", PrdFQString(formObj));
                break;

           case IBSAVE:        //저장
               if(!validateForm(sheetObj,formObj,sAction)) {
            	   ComShowMessage('Please select day.');
            	   return false;
               }
 
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESD_PRD_0013GS.do", PrdFQString(formObj));
                break;

           case IBINSERT:      // 입력
               if(validateForm(sheetObj,formObj,sAction))
                var row = sheetObj.DataInsert();
                sheetObj.CellValue2(row, "s_lane") = "FDR";
                break;

           case IBCOPYROW:        //행 복사
                var row = sheetObj.DataCopy();
              	sheetObj.CellValue2(row, "s_lane") = "FDR";
              break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBLOADEXCEL:        //엑셀 업로드
              sheetObj.LoadExcel();
              var toalRow = sheetObj.RowCount("I")+1;
              setVslLane(sheetObj , toalRow);
              break;
              
           case SEARCH08:
              formObj.f_cmd.value = SEARCH08;
              uid  = "ESD_PRD_0013";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              if (retValidate != null) sheetObj.CellValue2(sheetObj.SelectRow, "s_sp_bd_name") = sheetObjects[0].EtcData("comData2");
              else sheetObj.CellValue2(sheetObj.SelectRow, "s_sp_bd_name") = "" ;              
              
              break;
           case SEARCH01:
              formObj.f_cmd.value = SEARCH01;
              uid= "ESD_PRD_0004";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
           case SEARCH09:
              formObj.f_cmd.value = SEARCH09;
              uid  = "ESD_PRD_0013";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);     
              retValidate = sheetObj.EtcData("rowCount");
              validateLane = ComGetEtcData(sXml,"comData1");
              break;           
           case SEARCH02:
              formObj.f_cmd.value = SEARCH02;

              uid= "ESD_PRD_0013";
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
    	 switch(sAction) {
	        case IBSAVE:
	        	var idx = 0;
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){

	        		if( sheetObj.CellValue(idx,"ibflag") == "I" || sheetObj.CellValue(idx,"ibflag") == "U"){
	        			if(sheetObj.CellValue(idx,"s_sn") == "0" && sheetObj.CellValue(idx,"s_mn") == "0" && sheetObj.CellValue(idx,"s_te") == "0" 
	        				&& sheetObj.CellValue(idx,"s_wb") == "0" && sheetObj.CellValue(idx,"s_tu") == "0" && sheetObj.CellValue(idx,"s_fi") == "0" 
	        					&& sheetObj.CellValue(idx,"s_st") == "0" ) {
	        				
	        				return false;
	        			}
	        			
	        		}
	        	}
	  			break;
         }

    	 return true;
    }


	/**
	 * dtPopupEdit 로 처리 할 경우 팝업오픈 처리
	 * 
	 */
	function sheet1_OnPopupClick(sheetObj, row, col){
		var param ;
	
	    if ( sheetObj.ColSaveName(col) == "sFryd" )
	    {
	           param = '?yd_cd='+sheetObj.CellValue(row, col-1)+sheetObj.CellValue(row, col); 
	           ComOpenPopup('/hanjin/COM_ENS_061.do' + param,  770, 470, 'getFromYardGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true,false,row,col);
	    }
	
	    if ( sheetObj.ColSaveName(col) == "sToyd" )
	    {
	           param = '?yd_cd='+sheetObj.CellValue(row, col-1)+sheetObj.CellValue(row, col);          
	           ComOpenPopup('/hanjin/COM_ENS_061.do' + param,  770, 470, 'getToYardGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true,false,row,col);
	    }
	    
	    if ( sheetObj.ColSaveName(col) == "s_sp_bd" )
	    {
	           param = '?vndr_seq='+sheetObj.CellValue(row, col);       
	       
	           ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param,  700, 450, 'getSPBd', '1,0,1,1,1,1,1,1,1,1,1,1', true,false,row,col);          
	    }
	}

	/**
	 * 시트 내의 셀 변경처리
	 * 
	 */
	function sheet1_OnChange(sheetObj, row, col, Value)
	{
	    var strNo = "";
	    // Get 방식으로 넘길 값 셋팅 
	    validateData = Value;
	   
	    // Fill in the Zero
	  
	    if((sheetObj.ColSaveName(col)=="s_sp_bd") && (sheetObj.ReadDataProperty(row, col, dpEditLen) > 0)) {
	        strNo = sheetObj.CellValue(row, "s_sp_bd");
	        sheetObj.CellValue2(row, "s_sp_bd") = ComLpad(strNo, 6, "0");
	    }
	    // Get Value Service Provider Name
	   
	    if ((sheetObj.ColSaveName(col)=="s_sp_bd") && (sheetObj.ReadDataProperty(row, col, dpEditLen) > 0)) {
	       
	    	doActionIBSheet(sheetObj,document.form,SEARCH08);
	        
	    }
	    
	    // lane, dir, tztm이 변경시 체크 셋팅
	    if ((sheetObj.ColSaveName(col)=="s_lane")||(sheetObj.ColSaveName(col)=="s_dr") || (sheetObj.ColSaveName(col)=="s_t_time") ) {
	        
	        if( sheetObj.CellValue(row, "s_lane") != sheetObj.CellValue(row, "h_lane") ||
	            sheetObj.CellValue(row, "s_dr") != sheetObj.CellValue(row, "h_dir")   || 
	            sheetObj.CellValue(row, "s_t_time") != sheetObj.CellValue(row, "h_t_time") ) {
	            
	            sheetObj.CellValue2(row, "h_chk_lane_dir_tztm") = "U";
	        } else {
	            sheetObj.CellValue2(row, "h_chk_lane_dir_tztm") = "";
	        }
	    }
	    
	    //LANE VALIDATION CHECK 
	    if ((sheetObj.ColSaveName(col)=="s_lane") && (sheetObj.ReadDataProperty(row, col, dpEditLen) == 3)) {
	       validateLane = "";
	       doActionIBSheet(sheetObj,document.form,SEARCH09);
	       if(validateLane != 'O' || retValidate ==0){
	           sheetObj.CellValue2(row, "s_lane") = "";
	           sheetObj.SelectCell(row, "s_lane");
	           
	       }
	    }
	    
	       if(sheetObj.ColSaveName(col) == "s_from" ||sheetObj.ColSaveName(col) == "s_to" ){
	            validateData = Value;
	            doActionIBSheet(sheetObj,document.form, SEARCH02);
	            if(retValidate < 1) { //rowcount 가 1보다 작으면 
	                if(sheetObj.ColSaveName(col) == "s_from") {
	                   sheetObj.CellValue2(row,"s_from")="";
	                   sheetObj.SelectCell(row,"s_from");
	                }else if(sheetObj.ColSaveName(col) == "s_to") {
	                   sheetObj.CellValue2(row,"s_to")="";
	                   sheetObj.SelectCell(row,"s_to");
	                }
	            }
	            
	        }
	}

	/**
	 * 왼쪽에 ch 문자 채우기; 부족한 숫자만큼  len 크기로 ch 문자로 채우기
	 * 
	 */
	function lpad(newValue, len, ch){
	
	 var strlen = trim(newValue).length;
	 var ret = "";
	 var alen = len - strlen;
	 var astr = ""; 
	 for (i=0; i<alen; ++i)
	 {
	  astr = astr + ch;
	 }
	 ret = astr + trim(newValue); 
	 
	 return ret;
	}

	/**
	 * Get Selected Data in 'FromYard' PopUp WINDOW    
	 * 
	 */
	function getFromYardGrid(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];
		var colArray = rowArray[0];
		var fromLoc = sheetObj.CellValue(row, "s_from");
		var popData = colArray[3].substring(0,colArray[3].length-2) ;
		if (sheetObj.ColSaveName(col) == "sFryd")
		{
		    if( fromLoc != popData  ) {
		        ComShowMessage(ComGetMsg('PRD90011'));
		        return;
		    }
	    	sheetObj.CellValue2(row, "s_from") = colArray[3].substring(0,colArray[3].length-2);
	    	sheetObj.CellValue2(row, "sFryd") = colArray[3].substring(colArray[3].length-2,colArray[3].length);
		}
		
	}
    
	/**
	 * Get Selected Data in 'ToYard' PopUp WINDOW    
	 * 
	 */
	function getToYardGrid(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];
		var colArray = rowArray[0];
	
		var toLoc = sheetObj.CellValue(row, "s_to");
		var popData = colArray[3].substring(0,colArray[3].length-2) ;
		
		if (sheetObj.ColSaveName(col) == "sToyd")
		{
		    if( toLoc != popData  ) {
		        ComShowMessage(ComGetMsg('PRD90011'));
		        return;
		    }
	    	sheetObj.CellValue2(row, "s_to")   = colArray[3].substring(0,colArray[3].length-2);
	    	sheetObj.CellValue2(row, "sToyd") = colArray[3].substring(colArray[3].length-2,colArray[3].length);
		}
		
	}

	/**
	 * Get Selected Data in 'Service Provider' PopUp WINDOW  
	 * 
	 */
	function getSPBd(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];
		var colArray = rowArray[0];
	
		if (sheetObj.ColSaveName(col) == "s_sp_bd")
		{
	    	sheetObj.CellValue2(row, "s_sp_bd") = colArray[2];
	    	sheetObj.CellValue2(row, "s_sp_bd_name") = colArray[4];
		}
		
	}
    
//////////////////////////////////////////////////////////////////////////////////////

	var portInd = '';
	
    /**
    * COM_ENS_051 팝업화면 호출
    * 
    */
	function selectPort(pt){
		var param = '?loc_port_ind=1';
		portInd = pt;
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}

    /**
    * COM_ENS_051 팝업 화면에서 받는 인자값 처리
    * 
    */
	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];

		var frm = document.form;
		if(portInd == 'POL'){
			 frm.port_fm.value = cArray[3];
		}
		if(portInd == 'POD'){
			 frm.port_to.value = cArray[3];
		}
	}

    /**
     * Excel Load 된 데이터의 vslLane을 강제적으로 FDR로 바꾼다
     * 
     */
 	function setVslLane(sheetObj ,total) {
    	 var count = 0;
 		  for(k=1 ; k <= total ; k++){
        	  if (sheetObj.RowStatus(k)== "I"){
        		  if (sheetObj.CellValue(k, "s_lane") != "FDR"){
        			  count++;
        		  }
        	    sheetObj.CellValue2(k, "s_lane") = "FDR";
        	  }
          }
 		  if (count >0){
 			 ComShowMessage(ComGetMsg('PRD90116')); 
 			 return;
 		  }
 	}