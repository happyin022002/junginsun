/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0028.js
*@FileTitle : Owner’s Account - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.25 정윤태
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
     * @class ESM_FMS_0028 : ESM_FMS_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0099() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.sheet1_OnClick			= sheet1_OnClick;
        this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    }
    
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

			        case "btn_confirm":	    	        	
			        	var sRow = sheetObj.FindCheckedRow("check");

			    		if (sRow == "") {
			    			ComShowCodeMessage('COM12189');
			    			return;
			    		}
			    		
			        	var aryData = new Array();
	    	        	var idx = 0;
	    	        	for(var i=0; i<sheetObject.LastRow ;i++) {
	    	        		var row = i+1;
	    	        		
	    	        		if(sheetObject.CellValue(row,"check") == 0) {
	    	        			continue;
	    	        		}
	    	        	
	    	        		var ownersAccountDataStd = {
	    	        				acct_itm_nm:"",		
	    	        				ap_desc:"",			
	    	        				vvd_bunker: "",		
	    	        				oa_comm_flag:"",		
	    	        				oa_stl_sts_cd:"",	
	    	        				org_slp_no:"",
	    	        				n1st_amt:"",
	    	        				matching_slip_no:"",
	    	        				loc_curr_cd:"",		
	    	        				loc_amt	:"",			
	    	        				initial_amt_usd:"",	
	    	        				ex_diff_usd:"",ctr_cd:"",			
	    	        				slp_loc_cd: "",		
	    	        				flet_src_tp_cd: "",	
	    	        				flet_olay_comm_rt_amt: "",
	    	        				slp_tp_cd: "",		
	    	        				slp_func_cd: "",		
	    	        				slp_ofc_cd	: "",		
	    	        				slp_iss_dt: "",		
	    	        				slp_ser_no: "",		
	    	        				slp_seq_no: "",		
	    	        				vvd_yn: "",			
	    	        				initial_desc: "",		
	    	        				refund_add_comm: ""
	    	        		};	
	    	        			    	        		
	    	        		ownersAccountDataStd.acct_itm_nm= sheetObject.CellValue(row,"acct_itm_nm");				
	    	        		ownersAccountDataStd.ap_desc= sheetObject.CellValue(row,"ap_desc");				
	    	        		ownersAccountDataStd.vvd_bunker	= sheetObject.CellValue(row,"vvd_bunker");				
	    	        		ownersAccountDataStd.oa_comm_flag= sheetObject.CellValue(row,"oa_comm_flag");				
	    	        		ownersAccountDataStd.oa_stl_sts_cd= sheetObject.CellValue(row,"oa_stl_sts_cd");				
	    	        		ownersAccountDataStd.org_slp_no= sheetObject.CellValue(row,"org_slp_no");				
	    	        		ownersAccountDataStd.n1st_amt= sheetObject.CellValue(row,"n1st_amt");				
	    	        		ownersAccountDataStd.matching_slip_no = sheetObject.CellValue(row,"matching_slip_no");				
	    	        		ownersAccountDataStd.loc_curr_cd = "USD" //sheetObject.CellValue(row,"loc_curr_cd");				
	    	        		ownersAccountDataStd.loc_amt= sheetObject.CellValue(row,"loc_amt");				
	    	        		ownersAccountDataStd.initial_amt_usd = sheetObject.CellValue(row,"initial_amt_usd");				
	    	        		ownersAccountDataStd.ex_diff_usd	= sheetObject.CellValue(row,"ex_diff_usd");
	    	        		ownersAccountDataStd.ctr_cd = sheetObject.CellValue(row,"ctr_cd");	    	        			    	        			    	        			    	        		    	        		
	    	        		ownersAccountDataStd.slp_loc_cd= sheetObject.CellValue(row,"slp_loc_cd");				
	    	        		ownersAccountDataStd.flet_src_tp_cd= sheetObject.CellValue(row,"flet_src_tp_cd");				
	    	        		ownersAccountDataStd.flet_olay_comm_rt_amt= sheetObject.CellValue(row,"flet_olay_comm_rt_amt");		
	    	        		ownersAccountDataStd.slp_tp_cd= sheetObject.CellValue(row,"slp_tp_cd");					
	    	        		ownersAccountDataStd.slp_func_cd= sheetObject.CellValue(row,"slp_func_cd");     		
	    	        		ownersAccountDataStd.slp_ofc_cd= sheetObject.CellValue(row,"slp_ofc_cd");     		
	    	        		ownersAccountDataStd.slp_iss_dt= sheetObject.CellValue(row,"slp_iss_dt");     		
	    	        		ownersAccountDataStd.slp_ser_no= sheetObject.CellValue(row,"slp_ser_no");     		
	    	        		ownersAccountDataStd.slp_seq_no= sheetObject.CellValue(row,"slp_seq_no");     		
	    	        		ownersAccountDataStd.vvd_yn= sheetObject.CellValue(row,"vvd_yn");     		
	    	        		ownersAccountDataStd.initial_desc= sheetObject.CellValue(row,"initial_desc");         		
	    	        		ownersAccountDataStd.refund_add_comm= sheetObject.CellValue(row,"refund_add_comm");       			    	        		
	    	        		
	    	        		aryData[idx++] = ownersAccountDataStd;	    	        		
	    	        	}
	    				opener.setOwnersAccountStd(aryData);
	    				self.close();	  	
	    				
						break;
		
			        case "btn_close":
						window.close();
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
        	//khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheetObjects[0].ExtendLastCol = false;
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;    	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);		
		sheetObj.WaitImageVisible = true;   
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle = " ||Apply|O/A Item|Description|VVD|O/A\nComm.|Settlement|CSR No.|USD\nAmt|Matching\Slip No.|Cur|LCL\nAmt|Initial\nAmt(USD)" +
										  "|Ex.\Diff(USD)" +
										  "|CTR_CD|SLP_LOC_CD|FLET_SRC_TP_CD|FLET_OLAY_COMM_RT_AMT|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|SLP_SEQ_NO|VVD_YN|INITIAL_DESC|REFUND_ADD_COMM"
										  ;
 					var headCount = ComCountHeadTitle(HeadTitle);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");                    
					InitDataProperty(0, cnt++ , dtCheckBox,  	40,	daCenter,	false,		"check",						false,	"",		dfNone,				0,	true,		true);
					InitDataProperty(0, cnt++ , dtData,      	220,		daLeft,	false,		"acct_itm_nm",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	120,		daLeft,		false,		"ap_desc",					false,	"",		dfNone,				0,	false,	false);					
					InitDataProperty(0, cnt++ , dtData,      	90,		daCenter,	false,		"vvd_bunker",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,      	65,		daCenter,	false,		"oa_comm_flag",				false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	false,		"oa_stl_sts_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	160,		daCenter,	false,		"org_slp_no",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	false,		"n1st_amt",				false,	"",		dfFloat,				2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	180,		daCenter,	false,		"matching_slip_no",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	false,		"loc_curr_cd",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daRight,		false,		"loc_amt",					false,	"",		dfFloat,				2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daRight,		false,		"initial_amt_usd",		false,	"",		dfFloat,				2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daRight,		false,		"ex_diff_usd",				false,	"",		dfFloat,				2,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"ctr_cd",					false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_loc_cd",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"flet_src_tp_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"flet_olay_comm_rt_amt",	false,	"",		dfFloat,			2,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_tp_cd",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_func_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_ofc_cd",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_iss_dt",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_ser_no",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"slp_seq_no",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"vvd_yn",					false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"initial_desc",				false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	85,		daCenter,	false,		"refund_add_comm",	false,	"",		dfNone,				0,	false,	false);
					
					//FrozenCols = 9;
               }
                break;
        }
    }
    
    
    
    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;  			
  				sheetObj.DoSearch("ESM_FMS_0099GS.do" , FormQueryString(formObj));
                break;
        }
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	체크 필드값
     **/
  	function sheet1_OnClick(sheetObj,Row,Col,Value){

  		// 항차가 변경되었는지 체크한다
  		if (sheetObj.ColSaveName(Col)==("check")) {
	  		if(sheetObj.CellValue(Row,"check") == 0) {
	  			if(sheetObj.CellValue(Row,"vvd_yn") != "Y") {
	  				ComShowCodeMessage('FMS01443');
	  				sheetObj.CellValue(Row,"check") = 1;
	  			}
	  		}
  		}
  	}
     
    /**
     * Sheet에 sheet_OnSearchEnd 이벤트 발생
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
//    	ComColFontName(sheetObj, "5");
//    	ComColFontName(sheetObj, "6");
   	}