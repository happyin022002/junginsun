/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0024.js
*@FileTitle : Prepayments - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.12 정윤태
* 1.0 Creation
* History
* 2013.06.10 이영두 [CHM-201325097] Prepayment가 기간용선료 (510911) 이외의 계정을 사용하더라도 선급계정(111431)으로  묶일 수 있도 록 지정
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
     * @class ESM_FMS_0024 : ESM_FMS_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0024() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
        this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
        this.sheet1_OnChange		= sheet1_OnChange;
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
			        	var sRow = sheetObj.FindCheckedRow("apply");

			    		if (sRow == "") {
			    			ComShowCodeMessage('COM12189');
			    			return;
			    		}
			    		
			        	var aryData = new Array();
	    	        	var idx = 0;
	    	        	var row = formObject.chk_row.value;

	    	        	var prePaymentData = {ppay_hir_no:"", ctr_cd:"", slp_loc_cd:"", inv_amt_sum:"", acct_desc:"", flet_iss_tp_cd:"", inv_seq:"", inv_dtl_seq:"", flet_src_tp_cd:"", eff_dt:"", exp_dt:"", flet_ctrt_no:""};

	    	        	prePaymentData.ppay_hir_no = sheetObject.CellValue(row,"ppay_hir_no");
	    	        	prePaymentData.ctr_cd = sheetObject.CellValue(row,"ctr_cd");
	    	        	prePaymentData.slp_loc_cd = sheetObject.CellValue(row,"slp_loc_cd");
	    	        	prePaymentData.inv_amt_sum = sheetObject.CellValue(row,"inv_amt_sum");
	    	        	
	    	        	for (var ir=1; ir<=sheetObject.LastRow; ir++){
	    		     		if(sheetObject.CellValue(ir, "ppay_hir_no") == sheetObject.CellValue(row,"ppay_hir_no")) {
	    		     			//if(sheetObject.CellValue(ir,"acct_cd") == "510911") {
	    		     				prePaymentData.acct_desc = sheetObject.CellValue(row,"inv_desc");
	    		     				break;
	    		     			//}
	    		     		}
	    	        	}
	    	        	//prePaymentData.acct_desc = sheetObject.CellValue(row,"acct_desc");
	    	        	prePaymentData.flet_iss_tp_cd = sheetObject.CellValue(row,"flet_iss_tp_cd");
	    	        	prePaymentData.inv_seq = sheetObject.CellValue(row,"inv_seq");
	    	        	prePaymentData.inv_dtl_seq = sheetObject.CellValue(row,"inv_dtl_seq");
	    	        	prePaymentData.flet_src_tp_cd = sheetObject.CellValue(row,"flet_src_tp_cd");
	    	        	prePaymentData.eff_dt = sheetObject.CellValue(row,"eff_dt");
	    	        	prePaymentData.exp_dt = sheetObject.CellValue(row,"exp_dt");
	    	        	prePaymentData.flet_ctrt_no = sheetObject.CellValue(row,"flet_ctrt_no");
	    	        	
	    	        	aryData[idx++] = prePaymentData;
	    	        	opener.setPrepayments(aryData);
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
					var HeadTitle = " |Apply|Apply|Hire No|Item Name|Account Code|From|To|Cur|Amount|Description|Center Code|City Code|Amount Sum|Acct Desc|FletIssTpCd|Inv Seq|Inv Dtl Seq|Flet Src TpCd|Flet Ctrt No";
 					var headCount = ComCountHeadTitle(HeadTitle);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //InitColumnInfo(headCount, 0, 0, true);
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, true, false, true, false, false)
                    InitHeadMode(false, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,		"ims_ppay_hir_no",  false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++, 	dtRadioCheck,	0,    	daCenter,  	true,		"radio",   			false,  "", 	dfNone,   			0,  true,   true);
					InitDataProperty(0, cnt++ , dtCheckBox,  	40,		daCenter,	true,		"apply",			false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,	false,		"ppay_hir_no",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	165,	daLeft,		false,		"acct_nm",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	false,		"acct_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	65,		daCenter,	false,		"eff_dt",			false,	"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	65,		daCenter,	false,		"exp_dt",			false,	"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	35,		daCenter,	false,		"curr_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	75,		daRight,	false,		"inv_amt",			false,	"",		dfNullFloat,		2,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,		"Approval",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	140,	daLeft,		false,		"inv_desc",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"ctr_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"slp_loc_cd",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	80,		daRight,	false,		"inv_amt_sum",		false,	"",		dfNullFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	130,	daLeft,		false,		"acct_desc",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"flet_iss_tp_cd",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"inv_seq",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"inv_dtl_seq",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"flet_src_tp_cd",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		"flet_ctrt_no",	    false,	"",		dfNone,				0,	false,	false);
					
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
  			
  				sheetObj.DoSearch("ESM_FMS_0024GS.do" , FormQueryString(formObj));
                break;
        }
    }
     
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
 	function sheet1_OnChange(sheetObj,Row,Col,Value){
 		//ComDebug("Row=>"+Row+"Col=>"+Col+"Value=>"+Value);
    	if (sheetObj.ColSaveName(Col)==("apply")) {
    		
    		var allchk = ComFindAll(sheetObj, "ppay_hir_no", sheetObj.CellValue(Row,"ppay_hir_no"));
 			//ComDebug("allchk"+allchk);

    		var arrchk = 0;
    		
    		//if(allchk != 1) {
    		if(typeof(allchk.length) != "undefined") {
    			arrchk = allchk.split("|");
    			
    			sheetObj.CheckAll(Col) = 0;
        		
        		for(var i = 0 in arrchk){
        			//ComDebug("i"+i);
        			sheetObj.CellValue2(arrchk[i],"apply") = Value;
        		}
    		} else {
    			sheetObj.CheckAll(Col) = 0;
    			sheetObj.CellValue2(Row,"apply") = Value;
    		}

    		//var arrchk = allchk.split("|");
    		
    		/*
    		sheetObj.CheckAll(Col) = 0;
    		
    		for(var i = 0 in arrchk){
    			//ComDebug("i"+i);
    			sheetObj.CellValue2(arrchk[i],"apply") = Value;
    		}
    		*/
    		
	 		var invAmtSum = parseFloat(sheetObj.CellValue(Row,"inv_amt"));
	
	 		var chkVal = sheetObj.CellValue(Row,"ppay_hir_no");
	 		// 체크이면
	 		if(Value == 1) {
	 			
		 		for (var ir=1; ir<=sheetObj.LastRow; ir++){
		     		if(sheetObj.CellValue(ir, "ppay_hir_no")== chkVal && Row != ir) {
		     			//sheetObj.CellValue2(ir,"apply") = 1;
		     			//sheetObj.CellValue2(ir,"apply") = 0;
		     			invAmtSum = invAmtSum + parseFloat(sheetObj.CellValue(ir,"inv_amt"));
		     			
		     			if(sheetObj.CellValue(ir,"acct_cd") == "510911") {
		     				sheetObj.CellValue2(Row,"acct_desc") = sheetObj.CellValue(ir,"inv_desc");
		     			}

		     		} else {
		     			if(sheetObj.CellValue(ir,"acct_cd") == "510911") {
		     				sheetObj.CellValue2(Row,"acct_desc") = sheetObj.CellValue(ir,"inv_desc");
		     			}

		     			//sheetObj.CellValue2(Row,"acct_desc") = sheetObj.CellValue(Row,"inv_desc");
		     			
		     			//ComDebug("Row=2>");
		     			//sheetObj.CellValue2(ir,"apply") = 0;
		     			//sheetObj.CellValue2(ir,"apply") = 1;
		     		}
		     		
		     		if(ir == sheetObj.LastRow) {
	     				sheetObj.CellValue2(Row, "inv_amt_sum") = invAmtSum;
	     			}
		     	}
	 		} else {
	 			//ComDebug("Row=3>");
	 			//sheetObj.CellValue2(Row,"apply") = 0;
	 			//sheetObj.CellValue2(Row,"apply") = 1;
	 		}
	     	
	 		form.chk_row.value = Row;
    	}
 	}