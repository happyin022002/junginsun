/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_TOT_0024.js
*@FileTitle : Basic BSA Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.11.25 이병훈
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
     * @class FNS_TOT_0024 : FNS_TOT_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_TOT_0024() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
 
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject  = sheetObjects[0];
        var formObject = document.form;

    	try {
    		 var srcName = window.event.srcElement.getAttribute("name");
             
            switch(srcName) {
            
            	case "btns_back":
  	                 if(formObject.year.value == null || formObject.year.value == ""){
   	                	 ComShowCodeMessage('TOT00001');
   	                	 ComSetFocus(formObject.year);
   	                	 return;
   	                 }
   	                 formObject.year.value = ComGetDateAdd(formObject.year.value+"-01-01","Y",-1).substring(0,4);
            	break;
            		
            	case "btns_next":
  	                 if(formObject.year.value == null || formObject.year.value == ""){
   	                	 ComShowCodeMessage('TOT00001');
   	                	 ComSetFocus(formObject.year);
   	                	 return;
   	                 }
   	                 formObject.year.value = ComGetDateAdd(formObject.year.value+"-01-01","Y", 1).substring(0,4);
            	break;
                
                case "btn_retrieve":
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
                    
                case "btn_new":
                	sheetObject.RemoveAll();
    	            formObject.reset();
                break;
                    
                case "btn_downexcel":
                	sheetObject.Down2Excel(-1, false, false, true);
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

    /*
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
        for(i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
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
            case 1:      //t1sheet1 init
              with (sheetObj) {
                 //세로높이설정
            	  style.height = 400;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 10, 100);
                
                var HeadTitle = "Seq.|Trade|Lane|VSL\nCode|VSL\nName|NRT|NRT\nAMT|Declared\nCAPA|BSA|USE(%)|ETD\nSTART|ETD\nEND|DAY|REV per\nTON|Taxable\nAMT";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

              	// 해더에서 처리할 수 있는 각종 기능을 설정한다
              	InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtSeq,     30,    daCenter,  true,    "seq",  false,        "",       dfNone,     0,     		false,      false);
                InitDataProperty(0, cnt++ , dtData,     50,  daCenter,  false,   "trd_cd",     false,       "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,     50,  daCenter,  false,   "slan_cd",     false,       "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,     50,  daCenter,  false,   "vsl_cd",     false,       "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   100,  daCenter,  false,   "vsl_eng_nm",   false,       "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  false,   "nrt_wgt",   false,       "",       dfInteger,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   80,  daCenter,  false,   "nrt_tong_tax_amt",   false,       "",       dfInteger,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  false,   "ldb_capa_qty",   false,       "",       dfInteger,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  false,   "bsa_capa",   false,       "",       dfInteger,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  false,   "usg_rt",   false,       "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   80,  daCenter,  false,   "fm_vvd_stl_dt",   false,       "",       dfUserFormat,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   80,  daCenter,  false,   "to_vvd_stl_dt",   false,       "",       dfUserFormat,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  false,   "voy_dys",   false,       "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   80,  daCenter,  false,   "per_ton_rev",   false,       "",       dfInteger,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtAutoSum,   80,  daCenter,  false,   "tong_tax_amt",   false,       "",       dfInteger,    0,     false,       false);
                
                // 화면표시 형식 설정
                sheetObj.InitUserFormat(0, "fm_vvd_stl_dt", "####-##-##", "-" ); // ETD START
                sheetObj.InitUserFormat(0, "to_vvd_stl_dt", "####-##-##", "-" ); // ETD END
            }

            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
            case IBSEARCH:      //조회
            	
				if (formObj.year.value ==null || formObj.year.value ==""){
					ComShowCodeMessage('TOT00001');
					ComSetFocus(formObj.year);
					return false;
				}
				
            	formObj.f_cmd.value = SEARCH;
            	sheetObj.DoSearch("FNS_TOT_0024GS.do", FormQueryString(formObj));
            	
            	formObj.upd_dt.value = sheetObj.EtcData("upd_dt");
            break;
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)	{
    	var max_row = sheetObj.RowCount('');
    	var total_amount = sheetObj.SumText( 0,"tong_tax_amt");
    	
    	// Total Amount 셋팅
    	document.form.total_amount.value = total_amount;
    	// 제일 아래 생성되는 TOTAL Row hidden 처리
    	sheetObj.RowHidden(max_row+1) = true;
    }
