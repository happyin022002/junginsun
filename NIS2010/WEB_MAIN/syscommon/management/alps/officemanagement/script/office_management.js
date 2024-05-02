/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : office_management.js
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
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
     * @class office_management : office_management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function office_management() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    var sheetObjects = new Array();
    var sheetCnt = 0;

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
                switch(srcName) {
			    	case "btn_DownExcel":
			    		doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			    		break;
            	    case "btn_save":
        	    		doActionIBSheet(sheetObject,formObject,IBSAVE);
        	    		self.close();
            	        break;
            	    case "btn_close":
            	    	self.close();
            	    	break;
            		case "btn_ofc_cd":
            			ComOpenPopup('/hanjin/viewOrg.do?arOfcCd=Y', 700, 474, "getArOfcCd", "0,1,1,1,1,1", true);
            			break;
            		case "btn_cnt_cd":
            			ComOpenPopup('/hanjin/COM_ENS_0M1.do', 565, 450, "getCntCd", "0,1,1,1,1,1", true);
            			break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowMessage(OBJECT_ERROR);
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
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }

       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
            sheetObj.WaitImageVisible = false;

            switch(sheetNo) {
                 case 1:      //IBSheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 280 ;
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
                        InitColumnInfo(9, 0, 0, true);
                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, true, true, false,false) ;
                        var HeadTitle = "||Office|English Office Name|Korean Office Name|Level|County|AR OFC|";
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, false);
                        //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH,  DATAALIGN,  	COLMERGE,	SAVENAME,     	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        
                        InitDataProperty(0, cnt++ , dtCheckBox,   	20,  	daCenter,    	false,   	"check_val");
                        InitDataProperty(0, cnt++ , dtData,       	40,  	daCenter,    	false,   	"level",        false,        "",       dfNone,     0,       false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	70,  	daCenter,    	false,   	"ofc_cd",       false,        "",       dfNone,     0,       false,       false);
                        InitDataProperty(0, cnt++ , dtData,      	200,  	daLeft,      	false,   	"ofc_eng_nm",   false,        "",       dfNone,	   0,       false,       false);
                        InitDataProperty(0, cnt++ , dtData,      	130,   	daLeft,      	false,   	"ofc_krn_nm",   false,        "",       dfNone,	   0,       false,       false);
                        InitDataProperty(0, cnt++ , dtCombo,   		50,  	daCenter,      	false,   	"ofc_knd_cd",   false,        "",       dfNone,	   0,       false,       false);
                        InitDataProperty(0, cnt++ , dtData,    		50,  	daCenter,      	false,   	"rep_cust_cnt_cd",   false,        "",       dfNone,	   0,       false,       false);
                        InitDataProperty(0, cnt++ , dtData,    		70,  	daCenter,      	false,   	"ar_ofc_cd",   false,        "",       dfNone,	   0,       false,       false);
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");

                        InitDataCombo (0, "ofc_knd_cd", "SHO|RHQ|GOF|SOF|LOF|AGT|OTH", "1|2|3|4|5|6|9","9");

                        CountPosition = 0;
                        
                        InitTreeInfo(1, "level");
                   }
                 break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            ComOpenWait(true);
            switch(sAction) {
               case IBSEARCH:      //조회
                  	formObj.f_cmd.value = SEARCH;
                  	sheetObj.DoSearch4Post("Office_ManagementGS.do", FormQueryString(formObj));
                  	break;
                case IBSAVE:        //저장
                	formObj.f_cmd.value = MULTI;
                	sheetObj.DoSave("Office_ManagementGS.do", FormQueryString(formObj),"ibflag",false);
                	break;
                case IBDOWNEXCEL:	//엑셀다운로드
    				sheetObj.SpeedDown2Excel(1);
    				break;
            }
            ComOpenWait(false);
        }

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
    //
//                    return false;
//                }
            }
            return true;
        }
         
         /**
          * access level code auto check
          * @param code access level
          * @param checked boolean
          * @return
          */
         function chkBox(code, checked) {
        	var boxes = document.getElementsByTagName("input");
        	if ( code == 'A' ) {
     			for ( var i = 0 ; i < boxes.length-1 ; i++ ) {
     				if ( boxes[i].getAttribute("type") == "checkbox" ) boxes[i].checked = checked;
     			}
     			sheetObjects[0].CheckAll('check_val') = checked;
     		} else if ( code == 'Z' ) {
     			var strCountryCd = document.all.countryCd.value;
     			var strArOfcCd = document.all.arOfcCd.value;
     			for ( var idx = 1; idx <= sheetObjects[0].RowCount; idx++) {
     				if ( sheetObjects[0].CellValue(idx,'rep_cust_cnt_cd') != "" && strCountryCd.indexOf(sheetObjects[0].CellValue(idx,'rep_cust_cnt_cd')) > -1 )
     					sheetObjects[0].CellValue(idx,'check_val') = checked;
     				if ( sheetObjects[0].CellValue(idx,'ar_ofc_cd') != "" && strArOfcCd.indexOf(sheetObjects[0].CellValue(idx,'ar_ofc_cd')) > -1 )
     					sheetObjects[0].CellValue(idx,'check_val') = checked;
     			}
     		} else {
	        	for ( var idx = 1; idx <= sheetObjects[0].RowCount; idx++) {      
	        		//alert("["+sheetObjects[0].CellValue(idx,'ofc_knd_cd')+"] ["+code+"]");
					if(sheetObjects[0].CellValue(idx,'ofc_knd_cd') == code){
						sheetObjects[0].CellValue(idx,'check_val') = checked;
					}
				}
     		}
         }
         
         function getCntCd(rowArray) {
     		var gubun = ',';
     		var val = '';
     		
     		for(var i=0; i<rowArray.length; i++)
     		{
     			if(i == rowArray.length-1) gubun = '';
     			colArray = rowArray[i];
     			val += colArray[3] + gubun;
     		}
     		document.all.countryCd.value = val;
     	}

         function getArOfcCd(rowArray) {
     		var gubun = ',';
     		var val = '';
     		
     		for(var i=0; i<rowArray.length; i++)
     		{
     			if(i == rowArray.length-1) gubun = '';
     			colArray = rowArray[i];
     			val += colArray[3] + gubun;
     		}
     		document.all.arOfcCd.value = val;
     	}

	/* 개발자 작업  끝 */