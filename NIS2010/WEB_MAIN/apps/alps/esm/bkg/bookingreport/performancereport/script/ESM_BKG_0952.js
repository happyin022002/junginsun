/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0952.js
*@FileTitle : TRO Status List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.10.15 이남경
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
     * @class ESM_BKG_0952 : ESM_BKG_0952 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0952() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	//this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {               
                case "btn_SummaryDownExcel":
                	var sRow = "";
    				for (var i=2; i <= sheetObject.RowCount+1; i++) {
    					if (sheetObject.CellValue(i, "gubun") == "1") { 
    					    sRow += i+"|";
    					}
    				}
    				var skipCol = "gubun|bkg_ofc_cd|corr_ofc_cd|ctrt_ofc_cd|por_cd|pol_cd|pod_cd|del_cd|bl_no_cnt|corr_no_cnt";
                	sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, skipCol, sRow, false); 
					break;
					
                case "btn_SaveListDownExcel":
                	var sRow2 = "";
    				for (var i=2; i <= sheetObject.RowCount+1; i++) {
    					if (sheetObject.CellValue(i, "gubun") != "1") { 
    						sRow2 += i+"|";
    					}
    				}
    				var skipCol2 = "gubun"
                	sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, skipCol2, sRow2, false);    
					break; 
					
                case "btn_Close":
                	self.close();
 					break;
            } // end switch
    	} catch(e) {
    		ComShowMessage(e);
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
		for(i=0;i<sheetObjects.length;i++) 
		{
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//initControl();
		doActionIBSheet(sheetObjects[0],document.form, IBSEARCH); 
	}
    
    /**
     * 화면 로딩시, 초기화 
     */
/*      
    function initControl() {
    	var formObj = document.form;	    
    	//ComSetObjValue(formObj.bkg_dt_fr, ComGetNowInfo());
    	//ComSetObjValue(formObj.bkg_dt_to, ComGetNowInfo());
    }
*/     

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
 		var sheetId = sheetObj.id;

        switch(sheetId) {
            case "sheet1":            	
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll; 

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 32, 100);

					var HeadTitle1 = "|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|Route|Route|Route|Route|B/L Q'ty|C/A Q'ty|" + 
					                 "C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Exempt|Class|Class|Class|" + 
					                 "Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind";
					var HeadTitle2 = "|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|POR|POL|POD|DEL|B/L Q'ty|C/A Q'ty|" + 
					                 "M|C|G|A|R|C.Haul|M.Haul|Exempt|R|N|E|A|B|C|D|E|F|G|H|I|J|K";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,0,	daCenter,   false,	"gubun");
					InitDataProperty(0, cnt++ , dtData,92,	daCenter,   true,	"sls_rhq_cd",   false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,60,	daCenter,   true,	"bkg_ofc_cd",   false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,60,	daCenter,   true,	"corr_ofc_cd",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,80,	daCenter,   true,	"ctrt_ofc_cd",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,50,	daCenter,   false,	"por_cd",       false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,50,	daCenter,   false,	"pol_cd",       false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,50,	daCenter,   false,	"pod_cd",       false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,50,	daCenter,   false,	"del_cd",       false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,52,	daRight,    true,	"bl_no_cnt",    false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,54,	daRight,    true,	"corr_no_cnt",  false,	"",	dfNone,	0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_rsn_cd_m",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_rsn_cd_c",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_rsn_cd_g",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_rsn_cd_a",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_rsn_cd_r",  false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,50,	daRight,    false,	"haul_c",       false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,50,	daRight,    false,	"haul_m",       false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,60,	daRight,    true,	"exerrpt",      false,	"",	dfNone,	0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"rat_flg_y",    false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"rat_flg_n",    false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"expn_flg",	    false,	"",	dfNone,	0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_a",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_b",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_c",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_d",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_e",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_f",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_g",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_h",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_i",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_j",	false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,30,	daRight,    false,	"ca_kind_k",	false,	"",	dfNone,	0,	false,	true);
					
					CountPosition = 0;
					
					//MessageText("Sum") = "1st WEEK";
	                //SetSortDialog(false);
               }
                break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
	            //if(validateForm(sheetObj,formObj,sAction)){ 
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0952GS.do", FormQueryString(formObj));			
				var arrXml = sXml.split("|$$|");
				sheetObjects[0].LoadSearchXml(arrXml[0]);  			
				break;

	        case IBDOWNEXCEL:  
   				sheetObj.SpeedDown2Excel(-1); 
   				break; 

	        case IBDOWNEXCEL01:  
   				sheetObj.SpeedDown2Excel(-1); 
   				break; 
        }
    }
      
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
         	switch(sAction) {
				case IBSEARCH: // 조회시 확인
	         		if (!ComChkValid(formObj)) return false;
				
/* 				
	         		if (ComIsNull(formObj.bkg_no) && ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.bkg_dt_fr) || ComIsNull(formObj.bkg_dt_to))){
						ComShowCodeMessage('BKG00626', 'BKG Date or VVD or BKG No.');
						return false;
					}
*/ 					
	         		break;
         	}
         }
         return true;
    }

  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		//소계/총계 : 라인 색상변경 
	   	var formObj = document.form;
	   	
	   	if (sheetObj.SearchRows>0) {
	   		sheetObj.Redraw = false;
	   		
    		for (var i=2; i<=sheetObj.RowCount+1; i++) {
    			if (sheetObj.CellValue(i, "gubun") == "2") {
    				sheetObj.RangeBackColor(i, 0, i, sheetObj.LastCol) = sheetObj.RgbColor(254, 240, 251); 
    			} else if (sheetObj.CellValue(i, "gubun") == "3") {
    				sheetObj.RangeBackColor(i, 0, i, sheetObj.LastCol) = sheetObj.RgbColor(186, 235, 176); 
    			} 
    		}
	   		
	   		sheetObj.Redraw = true;
	   	}
  	}
		 
	/* 개발자 작업  끝 */