/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0019.js
*@FileTitle : Requested Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.23 김진일
* 1.0 Creation
* 
* History
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가
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
     * @class vop_pso_0019 : vop_pso_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0019() {
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
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

	        switch(srcName) {
		        case "btn_sdr":
					var sUrl = "http://www.imf.org/external/np/fin/data/rms_five.aspx";
					var WIDTH_POPUP = 850;
					var HEIGHT_POPUP = 600;
					var sFeatures = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_POPUP + ",height=" + HEIGHT_POPUP;
					ComOpenWindow(sUrl, "EXCHANGE_RATE", sFeatures, false);		        	
		        	break;
	            case "btn_Close":
	            	self.close();
	            	break;
	            case "btn_DownExcel":
	            	sheetObject1.SpeedDown2Excel(-1);
	            	
	            	if(sheetObject3.RowCount > 0){
	            	   sheetObject3.SpeedDown2Excel(-1, true);
	            	} 
	            	break;
				case "btn_Reject":
					if(!ComShowCodeConfirm("PSO00041", "reject")){
						return;
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
					break;
					
				case "btn_ToCSR":
					ComShowMessage("Under Construction!!!");
					break;
				case "btn_Confirm":
					if(formObject.inv_no.value != ""&&formObject.inv_no.value != undefined){
						ComShowCodeMessage("PSO01001");
						break;
					}
					if(!ComShowCodeConfirm("PSO00041", "confirm")){
						return;
					}
					for(var j=sheetObject1.HeaderRows+1 ; j<=sheetObject1.RowCount;j++)//강제로 Insert로 만든다 // 1번째의 row는 Skip한다.
						sheetObject1.CellValue2(j,0) = "I";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
					break;
					
	    		case "btn_inv_list":
	    			if(formObject.inv_atch_file_no.value!='0'){
	    				popupAtchFile("");
	    			}
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		/*PopUp시 해당 데이터를 조회한다.*/
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

     /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

      var cnt = 0;
	  var sheetid = sheetObj.id;
      
	  switch(sheetid) {

				case "sheet1":
					with (sheetObj) {
							// 높이 설정
							style.height = 250;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);

							var HeadTitle1 = "|Seq.|Cost|Description|DEBITS|Last Invoice|Invoice|Tariff|Diff|BALANCE|Remark|Attach|Formula|Formula Value|InvNo.|ydCd|h1|h2|h3|h4|h5|cntr_pnm_capa|inv_atch_file_no|ydChgNo|ydChgVerSeq|vvd|callSeq";
						
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 5, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							var prefix = "sheet1_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtDataSeq,			50,		daCenter,	true,		"Seq");
							InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"lgs_cost_cd",						false,		"",	dfNone,				0,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		true,		prefix+"lgs_cost_full_nm",					false,		"",	dfNone,				0,		false,	false);
							InitDataProperty(0, cnt++ , dtHidden,			110,	daRight,	true,		prefix+"rqst_amt",					        false,		"",	dfNullFloat,	    2,		false,	false);
							InitDataProperty(0, cnt++ , dtAutoSum,			90,	    daRight,	true,		prefix+"last_inv",			                false,		"",	dfNullFloat,	    2,		false,	false);
							InitDataProperty(0, cnt++ , dtAutoSum,			90,	    daRight,	true,		prefix+"credits",				            false,		"",	dfNullFloat,	    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				90,	    daRight,	true,		prefix+"calc_amt",		                    false,		"",	dfNullFloat,	    2,		false,		false);
							InitDataProperty(0, cnt++ , dtData,				70,	    daRight,	true,		"Diff",						                false,		"|sheet1_last_inv| + |sheet1_credits|-|sheet1_calc_amt|",	dfNullFloat,	2,		false,		true);
							InitDataProperty(0, cnt++ , dtHidden,			110,	daRight,	true,		prefix+"balance",				            false,		"",	dfNullFloat,	    2,		false,	true);
							InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		true,		prefix+"diff_rmk" ,				        	false,		"",	dfNone,				0,		true,	true);
			    			InitDataProperty(0, cnt++ , dtPopup,			50,		daCenter,	true,		prefix+"atch_file_no" ,		                false,		"",	dfNone,	    		0,		true,	true);
							InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		prefix+"sys_xpr_desc",					    false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		prefix+"dflt_xpr_desc",					    false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"inv_no",					        false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"yd_cd",					            false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"suz_net_tong_wgt",					false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"locl_xch_rt",				     	false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"scg_rt_amt",					    false,		"",	dfNone,				0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"tr_vol_val",					    false,		"",	dfNone,				0,		true,		false);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"inv_rgst_no",					    false,		"",	dfNone,				0,		true,		false);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"cntr_pnm_capa",					    false,		"",	dfNone,				0,		true,		false);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"inv_atch_file_no",					false,		"",	dfNone,				0,		true,		false);
							
							//confirm 시 계산식의 정보를 update 하기 위해 필요 2009.11.18
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,			prefix+"yd_chg_no",					false,		"",	dfNone,				0,		false,		true);
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,			prefix+"yd_chg_ver_seq",			false,		"",	dfNone,				0,		false,		true);
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,			prefix+"vvd",					    false,		"",	dfNone,				0,		false,		true);
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,			prefix+"call_seq",					false,		"",	dfNone,				0,		false,		true);
					
							//InitDataValid(0, prefix+"diff_rmk", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
							ImageList(0) = "img/btng_detail.gif";		// Detail
							CountPosition = 0;

						}
						break;

				case "sheet2":
					with (sheetObj) {
						
							// 높이 설정
							style.height = 100;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 4, 100);

							var HeadTitle1 = "|Amount|CNAC|CNBK|CNHD|CNLD|CNLH|CNLR|CNOT|CNPT|CNQR|CNSS|CNTF|CNTW|CNTX";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							var prefix = "sheet2_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,		40,	daCenter,	        true,		prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtData,				110,daCenter,	        true,		prefix+"title",			        false,		"",	dfNone,			0,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd1",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd2",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd3",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd4",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd5",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd6",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd7",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd8",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd9",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd10",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd11",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd12",	        false,		"",	dfNullFloat,    2,		false,	false);
							InitDataProperty(0, cnt++ , dtData,				65,	daRight,		    true,		prefix+"lgs_cost_cd13",	        false,		"",	dfNullFloat,    2,		false,	false);
											
						}
						break;	
						
				case "sheet3":
					with (sheetObj) {
						
							// 높이 설정
							style.height = 85;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);

							var HeadTitle1 = "|Seq.|Cost|Description|Last Invoice|Invoice|Tariff|Diff|Remark|Attach|InvNo.|ydCd|h1|h2|h3|h4|h5|cntr_pnm_capa|inv_atch_file_no|ydChgNo|ydChgVerSeq|vvd|callSeq|INV_DESC";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							var prefix = "sheet3_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtDataSeq,			50,		daCenter,	true,		"Seq");
							InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"lgs_cost_cd",			false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		true,		prefix+"lgs_cost_full_nm",	    false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtData,			    110,	daRight,	true,		prefix+"last_inv",				false,		"",	dfNullFloat,	2,		false,	true);
							InitDataProperty(0, cnt++ , dtAutoSum,			110,	daRight,	true,		prefix+"credits",				false,		"",	dfNullFloat,	2,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			110,	daRight,	true,		prefix+"calc_amt",		        false,		"",	dfNullFloat,	2,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			110,	daRight,	true,		"Diff",						    false,		"",	dfNullFloat,	2,		false,	true);
							InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		true,		prefix+"diff_rmk" ,				false,		"",	dfEngKey,				0,		true,	true);
			    			InitDataProperty(0, cnt++ , dtPopup,			50,		daCenter,	true,		prefix+"atch_file_no" ,		    false,		"",	dfNone,			0,		true,	true);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"inv_no",				false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"yd_cd",					false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"suz_net_tong_wgt",		false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"locl_xch_rt",			false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix+"scg_rt_amt",			false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"tr_vol_val",			false,		"",	dfNone,			0,		true,	true);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"inv_rgst_no",			false,		"",	dfNone,			0,		true,	true);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"cntr_pnm_capa",			false,		"",	dfNone,			0,		true,	true);
							InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		prefix+"inv_atch_file_no",		false,		"",	dfNone,			0,		true,	true);
							//confirm 시 계산식의 정보를 update 하기 위해 필요 2009.11.18
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,		prefix+"yd_chg_no",				false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,		prefix+"yd_chg_ver_seq",		false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,		prefix+"vvd",					false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,		prefix+"call_seq",				false,		"",	dfNone,			0,		false,	true);
							InitDataProperty(0, cnt++ , dtHidden,			   110,	daRight,	true,		prefix+"inv_desc",				false,		"",	dfNone,	        0,		false,	true);
							
							//InitDataValid(0, prefix+"diff_rmk", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
							ImageList(0) = "img/btng_detail.gif";		// Detail
							CountPosition = 0;						
						}
						break;		
        }
    }

     // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        switch(sAction) {
        	case IBSEARCH:      //조회
        		formObj.f_cmd.value = SEARCH;
           		if(validateForm(sheetObj,formObj,sAction)){
           			var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_" );      
           			
					//if ( sheetObj.id == "sheet1"){
						
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_PSO_0019GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
						
						var arrXml = sXml.split("|$$|");
					
						sheetObjects[0].LoadSearchXml(arrXml[0]);
						sheetObjects[1].LoadSearchXml(arrXml[1]);
						sheetObjects[2].LoadSearchXml(arrXml[2]);

						var row = sheetObj.FindText("sheet1_inv_no", "-INV-", 0, 2); //INV_NO정보를 가진 넘을 찾는다. 
   							if(row > 0 )
   								formObj.inv_no.value =  sheetObj.CellValue(row, "sheet1_inv_no");
   						
   						var row = 0;
   						for(i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
   							if(sheetObj.CellValue(i, "sheet1_yd_cd") != ""){
   								row = i;
   								break;
   							}
   						}
   						
   						if(row>0){
   							formObj.scnt.value = sheetObj.CellValue(row, "sheet1_suz_net_tong_wgt");
   							formObj.sdr.value = sheetObj.CellValue(row, "sheet1_locl_xch_rt");
   							formObj.limit.value = sheetObj.CellValue(row, "sheet1_scg_rt_amt");
   							formObj.tier.value = sheetObj.CellValue(row, "sheet1_tr_vol_val"); // Tier 정보 설정 .. 추가 2009.12.14
   							formObj.inv_rgst_no.value = sheetObj.CellValue(row, "sheet1_inv_rgst_no"); // 2009.12.15. add
   							formObj.cntr_pnm_capa.value = sheetObj.CellValue(row, "sheet1_cntr_pnm_capa"); //2012.03.13 add
   							formObj.inv_atch_file_no.value = sheetObj.CellValue(row, "sheet1_inv_atch_file_no"); //2012.03.13 add
   						}else{
   							formObj.cntr_pnm_capa.value = sheetObj.CellValue(sheetObj.HeaderRows, "sheet1_cntr_pnm_capa"); //2012.03.13 add
   							formObj.inv_atch_file_no.value = sheetObj.CellValue(sheetObj.HeaderRows, "sheet1_inv_atch_file_no"); //2012.03.13 add
   						}
   						
   						
						ComOpenWait(false);
					//}
           		}
				break;
            case IBSEARCH_ASYNC01: //Save btn click
            	var aryPrefix = new Array( "sheet1_", "sheet3_"); 
            	formObj.f_cmd.value = MULTI01;		//[2010.05.11:jmh]
            	var sParam = ComGetSaveString(sheetObjects[0], true, true);	
                    sParam = sParam + "&" + ComGetSaveString(sheetObjects[2], true, true);	
			        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			
			        var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0019GS.do", sParam);
		
		         
		        	var etcVal =  ComGetEtcData(sXml, "invoiceNo");
					if(etcVal===undefined || etcVal===null || etcVal===""){
						//return;
						sheetObjects[0].LoadSaveXml(sXml);
					}
					else{
						formObj.inv_no.value = etcVal;//구해온 InvoiceNo셋팅
						ComShowCodeMessage("PSO01003");
						this.close();
						var opener = window.dialogArguments;
						opener.setInvStatus("A", formObj.row.value, formObj.col.value);
					}

              	break;
            case IBSEARCH_ASYNC03: //Reject btn click
            	var aryPrefix = new Array( "sheet1_", "sheet3_"); 
              //sheetObj.ShowDebugMsg = true;
              //formObj.f_cmd.value = COMMAND03;	//[2010.05.11:jmh]
              formObj.f_cmd.value = MODIFY;			//[2010.05.11:jmh]
              if(validateForm(sheetObj,formObj,sAction))
            	  if ( sheetObj.id == "sheet1"){
            		  var sParam = ComGetSaveString(sheetObjects[0], true, false);	
  			        sParam = sParam + "&" + ComGetSaveString(sheetObjects[1], true, true);	

  			        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
  			       var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0019GS.do", sParam);
            		  var etcVal =  ComGetEtcData(sXml, "calcelResult");
            		  if(etcVal==="OK"){
            			  ComShowCodeMessage("PSO01002");
            			  this.close();
            			  var opener = window.dialogArguments;
            			  opener.setInvStatus("R", formObj.row.value, formObj.col.value);
            		  }
            		  else
            			  ComShowMessage("The process failed");
            		  //formObj.inv_no.value = etcVal;//구해온 InvoiceNo셋팅
            	  }	
                break;
        }
    }
        

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if (CellValue(i, "Diff") > 0)
					CellFontColor(i, "Diff") = RgbColor(255, 0, 0);		// 빨강
				else if (CellValue(i, "Diff") < 0)
					CellFontColor(i, "Diff") = RgbColor(0, 0, 255);		// 파랑
				
				
				//--> 6자리 cost 코드는 색깔을 바꾼다. 
				if(CellValue(i, "sheet1_lgs_cost_cd").length < 6 ) {
					//행의 배경색을 회색으로 설정한다.
					if(CellValue(i, "sheet1_lgs_cost_full_nm") == "TTL Amount:")
						sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 200, 200);
					else
						sheetObj.RowBackColor(i) = sheetObj.RgbColor(200, 255, 200);
				}
				
				
				
				
	//			if(CellValue(i, "sheet1_atch_file_no")=="0"){
	//				 InitCellProperty(i, "sheet1_atch_file_no", dtData, daCenter, "sheet1_atch_file_no");
	//				 CellEditable(i, "sheet1_atch_file_no") = false;
	//			}
			}
		
			sheetObj.CellValue(sheetObj.LastRow-1,10) = "";	
			sheetObj.CellValue(sheetObj.LastRow-1,11) = "";	
			sheetObj.CellEditable(sheetObj.LastRow-1,10)  = false;
			sheetObj.CellEditable(sheetObj.LastRow-1,11)  = false;
			
			RowHidden(LastRow) = true;	//합계행 숨기기
		
		}
	}
    
    
    function sheet3_OnSearchEnd(sheetObj, ErrMsg)
    {
    	with(sheetObj)
		{
           RowHidden(LastRow) = true;	//합계행 숨기기
    	}
    
    }
    
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg)
    {
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if (CellText(i, 1) == "Diff" )
					for (var j = 1; j <= 14; j ++)
					  {
						//if(sheetObj.CellValue(i,j) == 0) sheetObj.CellValue(i,j) = "";
						CellFontColor(i,j ) = RgbColor(255, 0, 0); 
					  }		// 빨강
			}
		
		}
	}

    
	/**
	 * IBSheet Popup Event
	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col){
    	var prefix = "sheet1_";
    	switch (sheetObj.ColSaveName(Col)) {
			case prefix + "atch_file_no" :				//attach 팝업
//				if(Number(sheetObj.CellValue(Row, Col))>0){
					var lgsCostCd = sheetObj.CellValue(Row, prefix + "lgs_cost_cd");
				//	var callSeq = sheetObj.CellValue(Row, prefix + "call_seq")
					popupAtchFile(lgsCostCd);
//				}
			break;	 
		}
	}
    
	/**
	 * IBSheet Popup Event
	 */
    function sheet3_OnPopupClick(sheetObj,Row,Col){
    	var prefix = "sheet3_";
    	switch (sheetObj.ColSaveName(Col)) {
			case prefix + "atch_file_no" :	
		//		if(Number(sheetObj.CellValue(Row, Col))>0){
					var lgsCostCd = sheetObj.CellValue(Row, prefix + "lgs_cost_cd");
				//	var callSeq = sheetObj.CellValue(Row, prefix + "call_seq");
					popupAtchFile(lgsCostCd);
			//	}
			break;	 
		}
	}
	
    /* sheet의 attahced file 불러오기  */ 
	function popupAtchFile(lgsCostCd){
		var formObj = document.form;
		var url = "VOP_PSO_0215.do?lgsCostCd=" + lgsCostCd + "&vvd=" + formObj.vvd.value + "&ydCd=" + formObj.yd_cd.value + "&callSeq=" + formObj.call_seq.value;
		//ComOpenPopup(url, 640, 425, '', '0,0', true, true);
		var popup = window.showModalDialog(url, self, "dialogHeight:370px;dialogWidth:640px;center:yes;location:no;resizable:no;scroll:no;status:no;");
	}
	
	
	function setAtchFileNo(fileCnt){
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "sheet1_atch_file_no") = fileCnt;
	}
    		
	 /**
 	 * invoice description
     */
    function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y){
    
        with(sheetObj) {
        	sheetObj.ToolTipOption="balloon:false;width:410;backcolor:#ffffe0;forecolor:#ff0000;icon:0;title:INVOICE INFO";
        	var tip = "";
        	
    		if (MouseRow >= HeaderRows && MouseRow <= LastRow) {
    			
    			
    			
    			if (ColSaveName(MouseCol) == "sheet3_last_inv") {

    				tip += CellValue(MouseRow, "sheet3_inv_desc");	
    			}
    			else {
    				tip = CellText(MouseRow, MouseCol);
    			}				
    		}
    		MouseToolTipText = tip;
    	}
    }
	/* 개발자 작업  끝 */