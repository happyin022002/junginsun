/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0115.js
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-09 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject2 = sheetObjects[0];
         var sheetObject = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

    			case "dbtn_new":
    				sheetObject2.RemoveAll();
    				sheetObject.RemoveAll();
    				formObject.reset();
    				formObject.bkg_no.disabled=false;
    				break;

                case "dbtn_retrieve":
                    doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
                    sheetObject.RemoveAll();
                    break;

        	    case "dbtn_save":
        	               //if(validationSAVE(sheetObject2){
    	                       doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC02);
        	               //}

        	        break;

				case "selection":
				
				// 조회조건중 BKG_NO를 선택할때
					if( formObject.selection[0].checked) {
						formObject.bkg_no.disabled=false;
						//formObject.bkg_no_split.disabled=false;
						
				        formObject.cntr_no_txt.disabled=true;
				        formObject.cntr_no_txt.value="";
				        formObject.bkgcrt_fm_dt.disabled=true;
				        formObject.bkgcrt_fm_dt.value="";
				        formObject.bkgcrt_to_dt.disabled=true;
				        formObject.bkgcrt_to_dt.value="";
 				        sheetObject2.RemoveAll();
				        sheetObject.RemoveAll();
				   	// 조회조건중 Container No.를 선택할때
					} else if( formObject.selection[1].checked) {
						formObject.cntr_no_txt.disabled=false;

						formObject.bkg_no.disabled=true;
						formObject.bkg_no.value="";
						//formObject.bkg_no_split.disabled=true;
						//formObject.bkg_no_split.value="";
					  	formObject.bkgcrt_fm_dt.disabled=true;
					  	formObject.bkgcrt_fm_dt.value="";
					  	formObject.bkgcrt_to_dt.disabled=true;
					  	formObject.bkgcrt_to_dt.value="";
					  	sheetObject2.RemoveAll();
					  	sheetObject.RemoveAll();
					// 조회조건중 Bkg Create Date를 선택할때
					}else{
					  	formObject.bkgcrt_fm_dt.disabled=false;
					  	formObject.bkgcrt_to_dt.disabled=false;

						formObject.bkg_no.disabled=true;
						formObject.bkg_no.value="";
						//formObject.bkg_no_split.disabled=true;
						//formObject.bkg_no_split.value="";
				        formObject.cntr_no_txt.disabled=true;
				        formObject.cntr_no_txt.value="";

				        sheetObject2.RemoveAll();
				        sheetObject.RemoveAll();
					}
					break;

				case "btn_bkg_calendar":
					if( formObject.selection[2].checked) {
					cal = new ComCalendarFromTo();
					cal.displayType = "date";
					cal.select(formObject.bkgcrt_fm_dt, formObject.bkgcrt_to_dt,  'yyyy-MM-dd');
							
					}else{
						alert ( "Please Check 'Bkg Create Date' Button");
						return;
					}
				break ;

				case "btn_close":
        	    	self.close();
        	    break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComShowMessage(ComGetMsg('COM12111')) ;
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 2:      //IBSheet1 init
                with (sheetObj) {
                	var prefix = 'sheet1_';
                    //전체 너비 설정
                    style.height = 250 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 16, 200);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                     InitHeadMode(true, true, true, true, false,false);

					//var HeadTitle1 = "Del.|SEQ|Office|Mapping Office|Mapping Office Name|Mapping Location|User ID|Created Date" ;
					var HeadTitle1 = "COP_NO|BKG_NO|CNTR_NO|CNTR TYPE SIZE|UPDATE DATE" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	    200,	daLeft,	true,	"cop_no",     false,          "",       dfNone,   	0,			false,       true);                    
					InitDataProperty(0, cnt++ , dtData,	    200,	daLeft,	true,	"bkg_no",     false,          "",       dfNone,   	0,			false,       true);
					//InitDataProperty(0, cnt++ , dtData,		100,	    daLeft,	false,	"f_bkg_no_split", false,          "",       dfNone,   	0,			false,       true,		300);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"cntr_no",		false,          "",       dfEngKey,   0,			false,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"cntr_tpsz_cd",	false,          "",       dfEngKey,	0,			false,       true,		500);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,	"upd_dt",	         	false,         "",       dfNone,   	0,			false,     false,		20);
					//InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,	"f_bkg_crt_dt",	         	false,         "",       dfNone,   	0,			false,     false,		20);
                    //InitDataProperty(0, cnt++ , dtHiddenStatus,        30,    daCenter,   true,   "f_ibflag",            false,         "",       dfNone,   	0,          true,       true);
					//InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"f_nis_evnt_dt",		        false,         "",       dfNone,   	0,			false,     false,		20);
					//InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"f_cntr_vol_qty",		        false,         "",       dfNone,   	0,			false,     false,		20);
					//InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"f_rcv_term_cd",		        false,         "",       dfNone,   	0,			false,     false,		20);
					//InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"f_de_term_cd",		        false,         "",       dfNone,   	0,			false,     false,		20);
                    //InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);
					//InitDataProperty(0, cnt++ , dtCheckBox,      40,    daCenter,   true,   "fDelCheck",           false,         "",       dfNone,   	0,          true,       true);
                    //InitDataProperty(0, cnt++ , dtSeq,           40,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);

                    
                    var nums    = "1234567890" ;
                    var spChars = "!@#$%^&*()_+<>?,./'\" " ;
               }
                break;
            case 1:      //IBSheet1 init
                with (sheetObj) {
                	var prefix = 'sheet2_';                	
                    //전체 너비 설정
                    style.height = 250 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 16, 200);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                     InitHeadMode(true, true, true, true, false,false);

					//var HeadTitle1 = "Del.|SEQ|Office|Mapping Office|Mapping Office Name|Mapping Location|User ID|Created Date" ;
					var HeadTitle1 = "|SEQ|BKG_NO|CNTR_NO|TPSZ_CD|BKG_CRE_DT|nis event dt" ;
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,      40,    daCenter,   true,   "delCheck",           false,         "",       dfNone,   	0,          true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,           40,    daCenter,   true,    "seq",               false,         "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtData,	    200,	daLeft,	true,	"bkg_no",     false,          "",       dfNone,   	0,			false,       true);
					//InitDataProperty(0, cnt++ , dtData,		100,	    daLeft,	false,	"f_bkg_no_split", false,          "",       dfNone,   	0,			false,       true,		300);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"cntr_no",		false,          "",       dfEngKey,   0,			false,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"cntr_tpsz_cd",	false,          "",       dfEngKey,	0,			false,       true,		500);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,	"bkg_cre_dt",	         	false,         "",       dfNone,   	0,			false,     false,		20);
					InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"nis_evnt_dt",		        false,         "",       dfNone,   	0,			false,     false,		20);
					InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"cntr_vol_qty",		        false,         "",       dfNone,   	0,			false,     false,		20);
					InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"cntr_rcv_term_cd",		        false,         "",       dfNone,   	0,			false,     false,		20);
					InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,	true,	"cntr_de_term_cd",		        false,         "",       dfNone,   	0,			false,     false,		20);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,        30,    daCenter,   true,   "ibflag",            false,         "",       dfNone,   	0,          true,       true);

                    var nums    = "1234567890" ;
                    var spChars = "!@#$%^&*()_+<>?,./'\" " ;
               }
                break;
        }
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
        var formObject = document.form;

        formObject.cntr_no_txt.disabled=true;
        formObject.bkgcrt_fm_dt.disabled=true;
        formObject.bkgcrt_to_dt.disabled=true;
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH_ASYNC01:		//Retrieve
			if(validateSearch(sheetObj,formObj,sAction)){
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch4Post("ESD_SCE_0115GS2.do", SceFrmQryString(formObj));

              }
              break;

           case IBSEARCH_ASYNC02:		//Save
	         	var sheetObject = sheetObjects[1];
				if(validateForm(sheetObj,formObj,sAction)){
	                formObj.f_cmd.value = MULTI01;

					// Mapping 완료 정보를 보여줄 데이터
					var resultParam = sheetObj.GetSaveString( false, false)+"&f_cmd="+SEARCHLIST;
					
					if( sheetObj.DoSave("ESD_SCE_0115GS2.do", SceFrmQryString(formObj), -1, false)) {
//		                formObj.f_cmd.value = SEARCH01;
//		                sheetObj.DoSearch4Post("ESD_SCE_0115GS2.do", SceFrmQryString(formObj));
						
		                formObj.f_cmd.value = SEARCH01;

		                sheetObj.DoSearch4Post("ESD_SCE_0115GS2.do", SceFrmQryString(formObj));
		                
		                formObj.f_cmd.value = SEARCHLIST;

		                sheetObject.DoSearch4Post("ESD_SCE_0115GS.do", resultParam );
					}
				}
			break;
        }
    }
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
				var row           = null ;

				//var chgRows2       = sheetObj.FindStatusRow("D").split(";") ;
				var chgRows2       = sheetObj.FindCheckedRow("delCheck");
				//alert("FindCheckedRow-->"+sheetObj.FindCheckedRow("fDelCheck"));

				var all_rowcnt = sheetObj.RowCount;

				if(all_rowcnt=="0"){
					return false;
				}

				if(chgRows2== ""){
					ComShowMessage('Please check the CheckBox!');
					return false;

				}


		return true;
	}


	/**
	 * 화면 조회조건입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateSearch(sheetObj,formObj,sAction){
		var result = true;

			if( formObj.selection[0].checked) {

				if(ComIsEmpty(formObj.bkg_no)){
					ComShowMessage('Please input To Bkg No') ;
	            	formObj.bkg_no.focus() ;
	        		result = false ;
				}
			} else if( formObj.selection[1].checked) {
				if(ComIsEmpty(formObj.cntr_no_txt)){
					ComShowMessage('Please input To Container No') ;
	            	formObj.cntr_no_txt.focus() ;
	        		result = false ;
				}
			}else{
				if(ComIsEmpty(formObj.bkgcrt_fm_dt) || ComIsEmpty(formObj.bkgcrt_to_dt)){
					ComShowMessage('Please input To Bkg Create Date') ;
	            	formObj.bkgcrt_fm_dt.focus() ;
	        		result = false ;
				}
			}
		return result;
	}