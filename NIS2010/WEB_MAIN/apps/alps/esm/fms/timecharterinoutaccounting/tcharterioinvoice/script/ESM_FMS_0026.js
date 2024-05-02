/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0026.js
*@FileTitle : Offhire Expenses - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.24 정윤태
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
     * @class ESM_FMS_0026 : ESM_FMS_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0026() {
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
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

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

	    	        		var offhireExpData = {
	    	        				acct_nm        : "",
	    	        				acct_cd        : "",
	    	        				vvd_bunker     : "",
	    	        				curr_cd        : "",
	    	        				inv_amt        : "",
	    	        				inv_desc       : "",
	    	        				ctr_cd         : "",
	    	        				slp_loc_cd     : "",
	    	        				flet_iss_tp_cd : "",
	    	        				inv_seq        : "",
	    	        				inv_dtl_seq    : "",
	    	        				flet_src_tp_cd : "",
	    	        				eff_dt 		   : "",
	    	        				exp_dt 		   : "",
	    	        				flet_ctrt_no   : ""
	    	        		};

	    	        		offhireExpData.acct_nm	= sheetObject.CellValue(row,"acct_nm");
	    	        		offhireExpData.acct_cd	= sheetObject.CellValue(row,"acct_cd");
	    	        		offhireExpData.vvd_bunker	= sheetObject.CellValue(row,"vvd_bunker");
	    	        		offhireExpData.curr_cd	= sheetObject.CellValue(row,"curr_cd");
	    	        		offhireExpData.inv_amt = sheetObject.CellValue(row,"inv_amt");
	    	        		offhireExpData.inv_desc	= sheetObject.CellValue(row,"inv_desc");
	    	        		offhireExpData.ctr_cd	= sheetObject.CellValue(row,"ctr_cd");
	    	        		offhireExpData.slp_loc_cd = sheetObject.CellValue(row,"slp_loc_cd");
	    	        		offhireExpData.flet_iss_tp_cd = sheetObject.CellValue(row,"flet_iss_tp_cd");
	    	        		offhireExpData.inv_seq	= sheetObject.CellValue(row,"inv_seq");
	    	        		offhireExpData.inv_dtl_seq = sheetObject.CellValue(row,"inv_dtl_seq");
	    	        		offhireExpData.flet_src_tp_cd = sheetObject.CellValue(row,"flet_src_tp_cd");
	    	        		offhireExpData.eff_dt = sheetObject.CellValue(row,"eff_dt");
	    	        		offhireExpData.exp_dt = sheetObject.CellValue(row,"exp_dt");
	    	        		offhireExpData.flet_ctrt_no = sheetObject.CellValue(row,"flet_ctrt_no");
	    	        		
	    	        		aryData[idx++] = offhireExpData;
	    	        	}
	    				opener.setOffhireExp(aryData);
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

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        sheetObjects[0].ExtendLastCol = false;
        
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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

 					//var HeadTitle1 = " |Apply|Hire No.|Item Name|Account Code|From|To|Cur.|Amount|Approval|Description";
 					//var HeadTitle = " ||Apply|Hire No|Item Name|Account Code|From|To|Cur|Amount|Description|Center Code|City Code";
					var HeadTitle = " ||Apply|Offhire Duration|Item Name|Account Code|Vessel VVD|Cur|Amount|Description|Center Code|City Code|FletIssTpCd|Inv Seq|Inv Dtl Seq|Flet Src TpCd|Eff Dt|Exp Dt|Vvd Yn|Flet Ctrt No";
 					var headCount = ComCountHeadTitle(HeadTitle);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //InitColumnInfo(headCount, 0, 0, true);
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, true, false, true, false, false)
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,  	40,		daCenter,	false,		"check",			false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	200,	daCenter,	false,		"duration",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	190,	daLeft,		false,		"acct_nm",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	90,		daCenter,	false,		"acct_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	false,		"vvd_bunker",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	40,		daCenter,	false,		"curr_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	80,		daRight,	false,		"inv_amt",			false,	"",		dfNullFloat,		2,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,		"Approval",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	300,	daLeft,		false,		"inv_desc",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"ctr_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"slp_loc_cd",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"flet_iss_tp_cd",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"inv_seq",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"inv_dtl_seq",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"flet_src_tp_cd",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	65,		daCenter,	true,		"eff_dt",			false,	"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	65,		daCenter,	true,		"exp_dt",			false,	"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	80,		daCenter,	false,		"vvd_yn",		    false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	80,		daCenter,	false,		"flet_ctrt_no",		false,	"",		dfNone,				0,	false,	false);
					
					//SetSortDialog(false);
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
  			
  				sheetObj.DoSearch("ESM_FMS_0026GS.do" , FormQueryString(formObj));
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
    	ComColFontName(sheetObj, "6");
   	}