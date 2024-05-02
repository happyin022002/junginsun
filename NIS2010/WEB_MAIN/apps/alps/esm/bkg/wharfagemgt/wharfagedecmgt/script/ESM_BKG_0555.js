/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0555.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0555() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
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

         var StringBuffer = function() {
        	 this.buffer = new Array();
         }
         StringBuffer.prototype.append = function(str) {
        	 this.buffer.push(str);
        	 return this;
         }
         StringBuffer.prototype.toString = function(){
        	 return this.buffer.join("");
         }
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,document.form,IBSEARCH);
								break;

						case "btn_DownExcel":
							doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
								break;

						case "btn_Print":
							if (sheetObject.RowCount == 0) {
								ComShowCodeMessage("BKG00095");
								return;
							}
							var subTitle = new StringBuffer();
							var subTitle2 = new StringBuffer();
							
							subTitle.append('WHF / ')
							        .append(formObject.vvd.value) 
							        .append(" / ")
							        .append( (formObject.bkg_cust_tp_cd[0].checked ? formObject.pol_cd.value
									: formObject.pod_cd.value) + "     ETA : " )
							        .append( sheetObjects[4].CellValue(1, 2) + "     ETD : " )
							        .append( sheetObjects[4].CellValue(1, 1));
							
							subTitle2.append("     Run Date : " )
							         .append( ComGetNowInfo("ymd") + " " + ComGetNowInfo("hms") );
							
							var temp  = subTitle.toString();
							var temp2 = subTitle2.toString();
							
							ComOpenWindowCenter("/hanjin/ESM_BKG_0793.do"
									+ "?rt_teu="     + formObject.rt_teu.value
									+ "&rt_feu="     + formObject.rt_feu.value
									+ "&rt_hcb="     + formObject.rt_hcb.value
									+ "&ttl_amt="    + formObject.ttl_amt.value
									+ "&bl_cnt="     + formObject.bl_cnt.value
									+ "&bkg_teu="    + formObject.bkg_teu.value
									+ "&bkg_feu="    + formObject.bkg_feu.value
									+ "&bkg_hcb="     + formObject.bkg_hcb.value
									+ "&sub_title="  + temp                     
									+ "&sub_title2=" + temp2,
									"0793", 1024, 720, false);
							break;
								
						case "btn_SumPrint":
							var s = new StringBuffer();	
							    s.append("/rdata [")
							     .append( sheetObjects[2].CellValue(2,2) )
							    .append("^").append( sheetObjects[2].CellValue(2,3) )
								.append("^").append( sheetObjects[2].CellValue(2,4) )
								.append("^").append( sheetObjects[2].CellValue(2,5) )
								.append("^").append( sheetObjects[2].CellValue(2,6) )
								.append("^").append( sheetObjects[2].CellValue(2,7) )
								.append("^").append( sheetObjects[2].CellValue(2,8) )
								.append("^").append( sheetObjects[2].CellValue(2,9) )
								.append("^").append( sheetObjects[2].CellValue(2,10))
								.append("^").append( sheetObjects[2].CellValue(2,11))
								.append("^").append( sheetObjects[2].CellValue(2,12))
								.append("^").append( sheetObjects[2].CellValue(2,13))
								.append("^").append( sheetObjects[2].CellValue(2,14))
								.append("^").append( sheetObjects[2].CellValue(2,15))
								.append("^").append( sheetObjects[2].CellValue(2,16))
								.append("^").append( sheetObjects[2].CellValue(2,17))
								.append("^").append( sheetObjects[2].CellValue(3,2) )
								.append("^").append( sheetObjects[2].CellValue(3,3) )
								.append("^").append( sheetObjects[2].CellValue(3,4) )
								.append("^").append( sheetObjects[2].CellValue(3,5) )
								.append("^").append( sheetObjects[2].CellValue(3,6) )
								.append("^").append( sheetObjects[2].CellValue(3,7) )
								.append("^").append( sheetObjects[2].CellValue(3,8) )
								.append("^").append( sheetObjects[2].CellValue(3,9) )
								.append("^").append( sheetObjects[2].CellValue(3,10))
								.append("^").append( sheetObjects[2].CellValue(3,11))
								.append("^").append( sheetObjects[2].CellValue(3,12))
								.append("^").append( sheetObjects[2].CellValue(3,13))
								.append("^").append( sheetObjects[2].CellValue(3,14))
								.append("^").append( sheetObjects[2].CellValue(3,15))
								.append("^").append( sheetObjects[2].CellValue(4,2) )
								.append("^").append( sheetObjects[2].CellValue(4,3) )
								.append("^").append( sheetObjects[2].CellValue(4,4) )
								.append("^").append( sheetObjects[2].CellValue(4,5) )
								.append("^").append( sheetObjects[2].CellValue(4,6) )
								.append("^").append( sheetObjects[2].CellValue(4,7) )
								.append("^").append( sheetObjects[2].CellValue(4,8) )
								.append("^").append( sheetObjects[2].CellValue(4,9) )
								.append("^").append( sheetObjects[2].CellValue(4,10))
								.append("^").append( sheetObjects[2].CellValue(4,11))
								.append("^").append( sheetObjects[2].CellValue(4,12))
								.append("^").append( sheetObjects[2].CellValue(4,13))
								.append("^").append( sheetObjects[2].CellValue(4,14))
								.append("^").append( sheetObjects[2].CellValue(4,15))
								.append("^").append( formObject.ofc_cd.value )
								.append("^").append( formObject.vvd.value           )
								.append("^").append( formObject.cfm_usr_id.value    )
								.append("^").append( sheetObjects[4].CellValue(1, 1))
								.append("^")
							    .append("] /rnl [~]");
							var temp = "/hanjin/ESM_BKG_0893.do" + "?rdData=" + s.toString();
							ComOpenWindowCenter(temp, "0893", 1024, 720, false );
							break;
								
						case "btn_Confirm":
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
     * 셀에 데이터를 메모패드에서 보여지게 하는 메서드.
     * 
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnClick(sheetObj, row, col){
    	 var sSaveName = sheetObj.ColSaveName(col);
    	 if (sSaveName == "sheet1_cust_nm" || sSaveName == "sheet1_xpt_ref_no") {
    		 if (ComTrim(sheetObj.CellValue(row, col)) != "")
    			 ComShowMemoPad(sheetObj, null, null, true, sheetObj.ColWidth(col) , 100);
    	 }
    }

     function sheet1_OnDblClick(sheetObj, row, col) {
    	 var sValue = "";
    	 sValue = ComTrim(sheetObj.CellValue(row, "sheet1_bkg_no"));
    	if (sValue != "") {
    		//ComOpenWindow("alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0079.do&pgmNo=ESM_BKG_0079&bkg_no=" + sValue, "", "width=1024,height=768, resizable=yes, scrollbars=yes, status=no");
    		comBkgCallPopBkgDetail(sValue);
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

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
    }
    
    
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	 var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
   
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
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    Ellipsis = true;
                    
                    AutoRowHeight = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "|Seq.|B/L No.|Shipper Name|Export Ref.|EQ|Qty|Amount|Container QTY|Container QTY|Container QTY|M/C|Exemption Reason|Exemption Reason";
					var HeadTitle2 = "|Seq.|B/L No.|Shipper Name|Export Ref.|EQ|Qty|Amount|20’|40’|45’|M/C|F|Free";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    var prefix = 'sheet1_';
                    //데이터속성             [ROW, COL,  DATATYPE,               WIDTH,  DATAALIGN,      COLMERGE,       SAVENAME,                    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		true,			prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,		true,			prefix + "Seq");
					InitDataProperty(0, cnt++ , dtData,					100,	daLeft,			true,			prefix + "bl_no",				false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					200,	daLeft,			true,			prefix + "cust_nm",		    	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					150,	daLeft,			true,			prefix + "xpt_ref_no",			false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		true,			prefix + "rat_ut_cd",			false,		"",		dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix + "rat_as_qty_sum",		false,		"",		dfNullFloat,	3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		true,			prefix + "amount",				false,		"",		dfNullInteger,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix + "teu_qty",				false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix + "feu_qty",				false,		"",		dfNullFloat,	2,		false,		false);

					InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix + "hcb_qty",				false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		true,			prefix + "bl_cvrd_tp_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,			prefix + "bkg_rt_whf_expt_cd",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,			prefix + "whf_shpr_rgst_no",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			    80,		daCenter,		true,			prefix + "f_teu_qty",			false,		"",		dfNone,			0,		false,		false);

					InitDataProperty(0, cnt++ , dtHidden,			    80,		daCenter,		true,			prefix + "f_feu_qty",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			    80,		daCenter,		true,			prefix + "f_hcb_qty",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		    	80,		daCenter,		true,			prefix + "bkg_no",				false,		"",		dfNone,			0,		false,		false);
									
					CountPosition = 0;
					
					WaitImageVisible = false;
			}
			break;
								
            case "sheet2":
            	with (sheetObj) {
            		
            		// 높이 설정
            		style.height = 0;
            		//전체 너비 설정
            		SheetWidth = mainTable.clientWidth;
            		
            		//Host정보 설정[필수][HostIp, Port, PagePath]
            		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            		
            		//전체Merge 종류 [선택, Default msNone]
            		MergeSheet = msAll;
            		
            		//전체Edit 허용 여부 [선택, Default false]
            		Editable = true;
            		
            		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            		InitRowInfo(1, 1, 15, 100);
            		
            		var HeadTitle1 = "|RT_TEU|RT_FEU|RT_HCB|BKG_TEU|BKG_FEU|BKG_HCB|TTL_AMT|BL_CNT";
            		var headCount = ComCountHeadTitle(HeadTitle1);
            		
            		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            		InitColumnInfo(headCount, 0, 0, true);
            		
            		// 해더에서 처리할 수 있는 각종 기능을 설정한다
            		InitHeadMode(true, true, false, true, false,false)
            		
            		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            		InitHeadRow(0, HeadTitle1, true);
            		//InitHeadRow(1, HeadTitle2, true);
            		var prefix2 = 'sheet2_';
            		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            		InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,			prefix2 + "ibflag");
            		InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,			prefix2 + "rt_teu",				false,		"",		dfNone,					0,		true,		true);
            		InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix2 + "rt_feu",						false,		"",		dfNullFloat,		2,		true,		true);
            		InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix2 + "rt_hcb",				false,		"",		dfNullFloat,		2,		true,		true);
            		InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix2 + "bkg_teu",					false,		"",		dfNullFloat,		2,		true,		true);
            		
            		InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix2 + "bkg_feu",					false,		"",		dfNullFloat,		2,		true,		true);
            		InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix2 + "bkg_hcb",				false,		"",		dfNullFloat,		2,		true,		true);
            		InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix2 + "ttl_amt",					false,		"",		dfNullFloat,		2,		true,		true);
            		InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix2 + "bl_cnt",							false,		"",		dfNullFloat,		2,		true,		true);
            		
            		CountPosition = 0;
            		
            		WaitImageVisible = false;
            	}
            	break;
            
            case "sheet3":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;
                    //MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    SelectHighLight = false;
                    
                    WaitImageVisible = false;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

					var HeadTitle1 = "|구분|부과대상|면제화주|면제화주|면제화주|면제화주|면제화주|T/S|IPO|Military|조달청|MTY|Bulk|Including\nOFT|Exempt\nTotal|Rating\nAmount|신고\n예정 금액";
					var HeadTitle2 = "|구분|부과대상|효성|대우|동부제강|현대|동국|T/S|IPO|Military|조달청|MTY|Bulk|Including\nOFT|Exempt\nTotal|Rating\nAmount|신고\n예정 금액";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    var prefix3 = 'sheet3_';
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,			prefix3 + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,			prefix3 + "gubun",				false,		"",		dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix3 + "buguadaesang",		false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "hyosung",			false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "daewoomot",			false,		"",		dfNullFloat,		2,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix3 + "dongbujekang",		false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "hyundaehi",			false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "donggukjekang",		false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "ts",					false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "ipi",				false,		"",		dfNullFloat,		2,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix3 + "military",			false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					55,		daRight,		false,			prefix3 + "jodalcheong",		false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					45,		daRight,		false,			prefix3 + "mty",				false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		false,			prefix3 + "bulk",				false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		false,			prefix3 + "incloft",		    false,		"",		dfNullFloat,		2,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		false,			prefix3 + "exempttotal",		false,		"",		dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		true,			prefix3 + "ratingamount",		false,		"",		dfNullInteger,	    0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		true,			prefix3 + "singoyejeonggumaek",	false,		"",		dfNullInteger,	    0,		false,		false);

//					RowHeight(0) = 20;
//					RowHeight(1) = 20;
					SetMergeCell(0, 1, 2, 1);
					SetMergeCell(0, 2, 2, 1);
					SetMergeCell(0, 8, 2, 1);
					SetMergeCell(0, 9, 2, 1);
					SetMergeCell(0, 10, 2, 1);
					SetMergeCell(0, 11, 2, 1);
					SetMergeCell(0, 12, 2, 1);
					SetMergeCell(0, 13, 2, 1);
					SetMergeCell(0, 14, 2, 1);
					SetMergeCell(0, 15, 2, 1);
					
					CountPosition = 0;
					
					WaitImageVisible = false;
			}
			break;
            case "sheet4":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|cfm_usr_id|upd_dt|ofc_cd|";
					 var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix4 = 'sheet4_';
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,			prefix4 + "ibflag");
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,			prefix4 + "cfm_usr_id",	false,		"",		dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix4 + "upd_dt",		false,		"",		dfNone,		3,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix4 + "ofc_cd",		false,		"",		dfNone,		3,		false,		false);
					
					CountPosition = 0;
					
					WaitImageVisible = false;
			}
			break;
            case "sheet5":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|vps_etd_dt|vps_eta_dt";
					 var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix5 = 'sheet5_';
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		false,			prefix5 + "ibflag");
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,			prefix5 + "vps_etd_dt",	false,		"",		dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,			prefix5 + "vps_eta_dt",		false,		"",		dfNone,		3,		false,		false);
					
					CountPosition = 0;
					
					WaitImageVisible = false;
			}
			break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_"); // prefix 문자열 배열
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0555GS.do", FormQueryString(formObj) + "&"
							+ ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0){
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[0].ColFontColor("sheet1_bl_no") = sheetObjects[0].RgbColor(0,0,255);
				sheetObjects[0].ColFontUnderline("sheet1_bl_no") = true;
			}
			if (arrXml.length > 1) {

				sheetObjects[1].LoadSearchXml(arrXml[1])
				formObj.rt_teu.value = ComAddComma(sheetObjects[1].CellValue(1, 1));
				formObj.rt_feu.value = ComAddComma(sheetObjects[1].CellValue(1, 2));
				formObj.rt_hcb.value = ComAddComma(sheetObjects[1].CellValue(1, 3));
				formObj.bkg_teu.value = ComAddComma(sheetObjects[1].CellValue(1, 4));
				formObj.bkg_feu.value = ComAddComma(sheetObjects[1].CellValue(1, 5));
				formObj.bkg_hcb.value = ComAddComma(sheetObjects[1].CellValue(1, 6));
				formObj.ttl_amt.value = ComAddComma(sheetObjects[1].CellValue(1, 7));
				formObj.bl_cnt.value = ComAddComma(sheetObjects[1].CellValue(1, 8));
			}
			if (arrXml.length > 2) {
				sheetObjects[2].LoadSearchXml(arrXml[2]);
			}
			if (arrXml.length > 3) {
				sheetObjects[3].LoadSearchXml(arrXml[3]);
				formObj.cfm_usr_id.value = sheetObjects[3].CellValue(1, 1);
				formObj.upd_dt.value = sheetObjects[3].CellValue(1, 2);
			}
			if (arrXml.length > 4) {
				sheetObjects[4].LoadSearchXml(arrXml[4]);
				formObj.retrieve_info.value = "WHF / "
						+ formObj.vvd.value
						+ " / "
						+ (formObj.bkg_cust_tp_cd[0].checked ? formObj.pol_cd.value
								: formObj.pod_cd.value) + "     ETA : "
						+ sheetObjects[4].CellValue(1, 2) + "     ETD : "
						+ sheetObjects[4].CellValue(1, 1) + "     Run Date : "
						+ ComGetNowInfo("ymd") + " " + ComGetNowInfo("hms");
			}
			ComOpenWait(false);
			
			if (formObj.cfm_usr_id.value != "") {
				ComBtnDisable("btn_Confirm");
			} else {
				ComBtnEnable("btn_Confirm");
			}
			
		}
		break;
	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			var aryPrefix = new Array("sheet4_"); // prefix 문자열 배열
			var sParam = FormQueryString(formObj);
			var saveXml = sheetObjects[3].GetSaveXml("ESM_BKG_0555GS.do", sParam + "&" + ComGetPrefixParam(aryPrefix));
			sheetObjects[3].RemoveAll(); 
			sheetObjects[3].LoadSearchXml(saveXml);
			if (sheetObjects[3].RowCount > 0) {
				formObj.cfm_usr_id.value = sheetObjects[3].CellValue(1, 1);
				formObj.upd_dt.value = sheetObjects[3].CellValue(1, 2);
				if (formObj.cfm_usr_id.value != "") {
					ComBtnDisable("btn_Confirm");
				} else {
					ComBtnEnable("btn_Confirm");
				}
			}
		}
		break;
	case IBDOWNEXCEL: // 엑셀 다운로드
		if (sheetObj.id == "sheet1") {
			sheetObjects[0].SpeedDown2Excel(-1, false, false);
		}
		else if (sheetObj.id == "sheet3") {
			sheetObjects[2].ExcelPrint = "PreView";
			sheetObjects[2].Down2Excel(-1, false, false, true, "", "apps/alps/esm/bkg/wharfagemgt/wharfagedecmgt/script/ESM_BKG_0555.xml", true);
		}
		break;
	}
}



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
 		case IBSEARCH: // 조회
 			if (formObj.vvd.value == "" ) 
 			{
 				ComShowCodeMessage('BKG00887', 'VVD');
 				formObj.vvd.focus();
 				return false;
 			}
 			if( formObj.bkg_cust_tp_cd[0].checked ){
 				if (formObj.pol_cd.value == "" ){ 
 					ComShowCodeMessage('BKG00887', 'POL');
 					return false;
 				}	
 			} else {
 				if (formObj.pod_cd.value == "" ){ 
 					ComShowCodeMessage('BKG00887', 'POD');
 					return false;
 				}
 			}
 					
 			return true;
 		break;
 		case IBSAVE: // 저장
 			
 			for(var i=2; i<=sheetObj.RowCount + 1 ; i++){
 				if( sheetObj.CellValue(i,0) == 'I' ){
 					if( formObj.port_cd.value == '' || sheetObj.CellValue(i,3) == '' ){
 						ComShowCodeMessage('BKG00104');
 		 				return false;
 					} 
 				}
 				
 			}
 			return true;
 		break;
 		case IBDELETE: // 저장
 			
 			if (formObj.port_cd.value == "" ) 
 			{
 				ComShowCodeMessage('BKG00266');
 				formObj.port_cd.focus();
 				return false;
 			}
 							
 			return true;
 		break;
    	}
    }
    
    /**
     * 소숫점이 포함된 수에 천단위의 콤마가 추가되는 메서드 <br>
     * <br><b>Example :</b>
     * <pre>
     *    CommaInputWithPoint( '23456.789', 3 );
     *    반환되는 값은 : 23,456.789
     * </pre>
     * @param String Type의 소숫점이 있거나 없는 수
     * @param Int Type의 소숫점 아래 자릿수의 갯수
     * @return 천단위의 콤마가 포함된 수
     * @author 정재엽
     * @version 2009.07.28
     */
	function CommaInputWithPoint2( num, pointCnt )
	{
		var pointNum = '';
		num=num.replace(",","");
		var pointLoc = num.indexOf(".")
		if( pointLoc != -1 ){
			pointNum = num.substring(pointLoc, pointLoc + ( pointCnt + 1));
			num = num.substring(0, pointLoc);
		}
		rl=num.length;
		l=num.length-3;
		while(l > 0) {
			if(num.substring(rl-1,1) == "."){
				return num;
			}else {
				num=num.substr(0,l)+","+num.substr(l);
				l-=3;
			}
	    }
	    return num + pointNum ;
	}

