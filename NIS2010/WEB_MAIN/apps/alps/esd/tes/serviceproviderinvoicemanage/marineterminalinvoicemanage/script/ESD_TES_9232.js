 /*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9232.js
*@FileTitle : TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-15
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-11-23 kimjinjoo
* 1.0 최초 생성
=========================================================*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var doneDefN3ptyBilCSCD = false;

	var	comboNm;
	var	comboVal;
	
	var defaultNm;
	var defaultVal;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 *  탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한
	 */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
         	    case "btn_ok":
					//try {
						var temp_amt = 0;
						var iCheckRow = sheetObject.FindCheckedRow('chk');
						if (iCheckRow != null && iCheckRow != ''){
							var arrRow = iCheckRow.split("|");
							for (var idx=0; idx<arrRow.length-1; idx++){ 
								temp_amt += parseFloat(sheetObject.CellValue(arrRow[idx],'if_amt'));
							}

							//alert(temp_amt + '  /  ' + parseFloat(document.form.inv_amt.value));
							// CHM-201432779 [TES] TPB amount logic 수정 (2014-11-20)
							/*if (Math.floor(temp_amt * Math.pow(10, 2)) / Math.pow(10, 2) > parseFloat(document.form.inv_amt.value)) {
								ComShowMessage('Total amount to interface should be less than or equal to '+parseFloat(document.form.inv_amt.value));
								return false;
							}*/
						}
					//} catch (e){ // 아무것도 하지 않는다 현재는...
					//}
				
    	            if (checkMandatory(sheetObject)) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
         	            window.close();
         	        }
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet}	sheet_obj	sheet object
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
        if(document.form.lgs_cost_cd.value == '' || document.form.lgs_cost_cd.value == null){
            ComShowMessage('Select COST CODE first.\n\nThis window will be closed!');
            window.close();
            return false;
        }

        tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'lgs_cost_cd', 'setDefN3ptyBilCSCD');
        
//        var sheetObject = sheetObjects[0];
//        var formObj = document.form;
//        for(i=0;i<sheetObjects.length;i++){
//            ComConfigSheet(sheetObjects[i]);
//            initSheet(sheetObjects[i],i+1);
//            ComEndConfigSheet(sheetObjects[i]);
//        }

//        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//        setTimeout("doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);",500);
    }
    
    /** setDefN3ptyBilCSCD
     *  N3pty_Bil_CS_CD가 조회되면 전체를 돌면서 'n3pty_bil_tp_cd'의 default값으로 설정한다.
     * @return
     */ 
    function setDefN3ptyBilCSCD(){

		if (doneDefN3ptyBilCSCD){
			return;
		}

		var retval = false;
		var formObj = document.form;
		if (sheetObjects[0].RowCount > 0 && formObj.n3pty_bil_cs_cd!=undefined && formObj.n3pty_bil_cs_cd.value!=null && formObj.n3pty_bil_cs_cd.value.trim()!=''){
			for (var i=sheetObjects[0].HeaderRows; i<(sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++){
				if (sheetObjects[0].CellValue(i,'n3pty_bil_tp_cd')==null || sheetObjects[0].CellValue(i,'n3pty_bil_tp_cd').trim()==''){
					sheetObjects[0].CellValue2(i,'n3pty_bil_tp_cd') = formObj.n3pty_bil_cs_cd.value;
					retval = true;
				}
			}
		}
		
		// TPB BillingCase Code TES 사용하는것 전체 조회.
		tes_getInputValueInvoice('n3pty_bil_tp_cd_tmp', SEARCH07, '', 'setTpbBillcaseCode');
		
		return retval;
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {ibsheet}	sheet_obj	sheet object
     * @param {int}		sheetNo		sheet number
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

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
                    InitColumnInfo(30, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "H_SEQ|STS|Seq||lgs_cost_cd|Container No.|TP|Billing Case|Curr.|Amount|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|Remarks|tml_if_ofc_cd|tml_if_seq|" +
                            "io_bnd|inv_no|vndr_seq|yd_cd|curr_cd|bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++, dtHidden      ,     70,    daCenter,  false,   "page_rows"   ,       false,          "",       dfNone ,   0,     false,       false);
                    InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  false,   "ibflag");
                    InitDataProperty(0, cnt++, dtSeq		 ,     30,    daCenter,  false,   ""   );
                    InitDataProperty(0, cnt++, dtCheckBox	 ,     30,    daCenter,  false,   "chk"   );
                    InitDataProperty(0, cnt++, dtHidden  	 ,     90,    daCenter,  false,   "lgs_cost_cd"		 ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++, dtData		 ,    100,    daCenter,  false,   "cntr_no"			 ,       true,           "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cntr_tpsz_cd"     ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtCombo		 ,    150,    daCenter,  false,   "n3pty_bil_tp_cd"	 ,       true,           "",       dfNone,    0,     document.form.lgs_cost_cd.value=='SVXXJO'?false:true ,       document.form.lgs_cost_cd.value=='SVXXJO'?false:true);
                    InitDataProperty(0, cnt++, dtData		 ,    50,    daCenter,  false,   "curr_cd"			 ,       true,           "",       dfNone,    0,     false,       false);
                    //if(document.form.curr_cd.value == 'KRW' || document.form.curr_cd.value == 'JPY'){
					if (tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)) {
                        InitDataProperty(0, cnt++, dtData    ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfInteger,  0,     true ,       true);
                        //InitDataProperty(0, cnt++, dtData    ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfInteger,  0,     document.form.lgs_cost_cd.value=='SVXXJO'?false:true ,       document.form.lgs_cost_cd.value=='SVXXJO'?false:true);
                    }else{
                        InitDataProperty(0, cnt++, dtData	 ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfFloat,    2,     true ,       true);
                        //InitDataProperty(0, cnt++, dtData	 ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfFloat,    2,     document.form.lgs_cost_cd.value=='SVXXJO'?false:true ,       document.form.lgs_cost_cd.value=='SVXXJO'?false:true);
                    }

					InitDataProperty(0, cnt++, dtCombo		 ,     80,    daCenter,  false,   "vndr_cust_div_cd" ,       false,          "",       dfNone,    0,     true ,       true);
					InitDataProperty(0, cnt++, dtPopup		 ,    100,    daCenter,  false,   "pop_value"		 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "vndr_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "n3pty_vndr_seq"   ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cust_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cust_seq"      	 ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "n3pty_ofc_cd"     ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData		 ,    180,    daCenter,  false,   "if_rmk"			 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "tml_if_ofc_cd"    ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "tml_if_seq"       ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "io_bnd_cd"        ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "inv_no"           ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "vndr_seq"         ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "yd_cd"            ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "curr_cd"          ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++, dtHidden		 ,    180,    daCenter,  false,   "bkg_no"			 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden		 ,    180,    daCenter,  false,   "bkg_no_split"	 ,       false,          "",       dfNone,    0,     true ,       true);
					InitDataProperty(0, cnt++, dtHidden  	 ,    100,    daCenter,  false,    "bl_no"		 	 ,       false,          "",      dfNone,      0,    false,       false);
					InitDataProperty(0, cnt++, dtHidden  	 ,    100,    daCenter,  false,    "bl_no_tp"	 	 ,       false,          "",      dfNone,      0,    false,       false);
					InitDataProperty(0, cnt++, dtHidden  	 ,    100,    daCenter,  false,    "bl_no_chk"	 	 ,       false,          "",      dfNone,      0,    false,       false);

                    //InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "tml_so_dtl_seq"       ,       false,          "",       dfNone,    0,     false,       false);
					
					InitComboNoMatchText(true); //n3pty_bil_tp_cd combo생성시 JO는 SQL문에서 제외해 실제 콤보데이타가 생성되지 않지만
                                                //InitComboNoMatchText값을 True로 설정하면 콤보코드에 존재하지 않는 JO가 화면에 표시 및 DB저장및 조회 처리가 가능해짐


////				getTPBGenCombo('n3pty_bil_tp_cd','searchBillingCaseCode','S','sheet','2');
//					getTPBGenCombo('n3pty_bil_tp_cd','searchBillingCaseCodeByTES','S','sheet','2');
					
//					 TPB Billing case (AW)에 대한 IF 오류 수정 (from TES) ( 2009-09-18 )
//					getThirdPartyBillingCaseHorizontally('|$|','Y','getTesBillingCase','n3pty_bil_tp_cd_tmp');
					
//					setTimeout("tes_tpbBillcaseCode(docObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '');",1500);

//					getThirdPartyBillingCaseHorizontally('|$|','Y','getTesBillingCase','n3pty_bil_tp_cd_tmp', 'setTpbBillcaseCode');
	
					InitDataCombo( 0, "n3pty_bil_tp_cd", comboNm, comboVal);
					
					if(document.form.lgs_cost_cd.value != '' && document.form.lgs_cost_cd.value == 'SVXXJO'){
					    InitDataCombo (0, "vndr_cust_div_cd", 'S/P', 'V',"S/P","V");
					}else{
					    InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code,"Customer","C");
					}
					
               }
                break;
        }
    }

		

/**
* TPB 에서 가져온 Billing Case 문자열로 콤보를 만들 함수 호출
* getThirdPartyBillingCaseHorizontally 동작이 끝난 후 호출된다
* @return
*/
function setTpbBillcaseCode(){
//	 tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
	 
	comboNm		= tes_tpbBillcaseCodeNm(document.getElementById('n3pty_bil_tp_cd_tmp').value);
	comboVal	= tes_tpbBillcaseCodeVal(document.getElementById('n3pty_bil_tp_cd_tmp').value);
	
	for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
 		
	getList();
}

/**
* Billing Case 콤보가 생성된 후 목록을 조회한다.
* @return
*/
function getList(){
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

    /** Sheet관련 프로세스 처리
     *  @param {ibsheet}	sheet_obj	sheet object
     *  @param {form}		formObj		form object
     *  @param {int}		sAction		form Action value
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
        
		switch(sAction){
		
			case IBSEARCH:
                if(formObj.calc_tp_cd.value == 'A'){
                    formObj.f_cmd.value = SEARCH01;
                }else if(formObj.calc_tp_cd.value == 'M'){
                    formObj.f_cmd.value = SEARCH02;
                }
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9232GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSAVE:
                formObj.f_cmd.value = MODIFY;
                var param = sheetObj.GetSaveString(false, false, 'chk');
				//alert(param);return false;
                var saveXml = sheetObj.GetSaveXml("ESD_TES_9232GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
                break;

        }
    }
    
    /** tpb 호출 
     * 	TES아닌 TPB common Function임.
     * 
     * @param {ibsheet}	sheet_obj	sheet object     
     * @param {int}	Row	sheet 	셀의 row index  
     * @param {int}	Col	sheet 	셀의 col index 
     * @return
     */
    function sheet_OnPopupClick(sheetObj,Row,Col){
		//TES아닌 TPB common Function임.
		tes_get3rdParty_sheet( sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row, Col );
    }
    
    /** sheet object
     * 
     * @param {ibsheet}	sheet_obj	sheet object     
     * @param {int}	Row	sheet 	셀의 row index  
     * @param {int}	Col	sheet 	셀의 col index 
     * @return
     */
	function sheet_OnChange(sheetObj,Row,Col){
		if (sheetObj.RowCount > 0) {
			if (sheetObj.ColSaveName(Col) == "pop_value"){
				if(sheetObj.CellValue(Row,"vndr_cust_div_cd")=='C'){
					sheetObj.CellValue(Row,"cust_seq"			) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
					sheetObj.CellValue(Row,"cust_cnt_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(0,2);
				}else if(sheetObj.CellValue(Row,"vndr_cust_div_cd")=='S'){
				  sheetObj.CellValue(Row,"n3pty_ofc_cd"		) = sheetObj.CellValue(Row,"pop_value");
				  //sheetObj.CellValue(Row,"n3pty_ofc_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
				}else if(sheetObj.CellValue(Row,"vndr_cust_div_cd")=='V'){
					sheetObj.CellValue(Row,"n3pty_vndr_seq"	) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
					sheetObj.CellValue(Row,"vndr_cnt_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(0,2);
				}
			}else if(sheetObj.ColSaveName(Col) == "if_amt" && sheetObj.CellValue(Row,"if_amt")<=0){
				sheetObj.CellValue(Row,"if_amt") = document.form.ctrt_rt.value;
				ComShowMessage("Minus amount is not allowed to 3rd Party.\n(I/F Amount shoule be bigger than 0)");
			}
			if (sheetObj.ColSaveName(Col)=="chk" || sheetObj.ColSaveName(Col)=="n3pty_bil_tp_cd" || 
				sheetObj.ColSaveName(Col)=="if_amt" || sheetObj.ColSaveName(Col)=="pop_value" || sheetObj.ColSaveName(Col)=="if_rmk" ||
				sheetObj.ColSaveName(Col)=="cust_seq" || sheetObj.ColSaveName(Col)=="cust_cnt_cd" || sheetObj.ColSaveName(Col)=="n3pty_ofc_cd" ||
				sheetObj.ColSaveName(Col)=="n3pty_vndr_seq" || sheetObj.ColSaveName(Col)=="vndr_cnt_cd") {
				if (sheetObj.CellSearchValue(Row,'chk')!=sheetObj.CellValue(Row,'chk')) {
					if (sheetObj.CellValue(Row,'chk')=='1'){
						if (sheetObj.CellValue(Row,'tml_if_ofc_cd')==null || sheetObj.CellValue(Row,'tml_if_ofc_cd')=='') {
//							sheetObj.CellValue(Row,'ibflag') = "I";
							sheetObj.RowStatus(Row) = "I";
						} else {
//							sheetObj.CellValue(Row,'ibflag') = "U";
							sheetObj.RowStatus(Row) = "U";
						}
					}
				}
			}
		}
	}
	
	/** 
	 * sheet 값 설정
	 * @param {ibsheet} sheetObj    sheet object
	 * @return
	 */
    function sheet_OnSearchEnd(sheetObj){//alert("start sheet_OnSearchEnd");
        var openerObj = window.dialogArguments.document.n3rd_hidden;
        var rvis_hidden = window.dialogArguments.document.rvis_hidden;
        var dtl_hidden = window.dialogArguments.document.t3sheet1;
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        var lgs_cost_cd_row;
        var cntr_no_row;
        var cntr_tpsz_cd_row;
        var bil_tp_cd_row;

        //2007-07-06 SVXXJO 관련 수정 --시작
        if(formObj.lgs_cost_cd.value == 'SVXXJO' && (formObj.tml_crr_cd.value=='' || formObj.tml_crr_cd.value==null)){
            ComShowMessage('SVXXJO need Carrier Code. Select Carrier Code first.\n\nThis window will be closed!');
            window.close();
            return false;
        }
        //2007-07-06 SVXXJO 관련 수정 --끝

        if (formObj.calc_tp_cd.value == 'M' && formObj.lgs_cost_cd.value == "SVXXJO"){
			if (sheetObj.RowCount < 1){
				var Row = sheetObj.DataInsert(-1);
				sheetObj.CellValue(Row,"lgs_cost_cd"          ) = 'SVXXJO';
				sheetObj.CellValue(Row,"cntr_no"              ) = 'SVXXJO00000';
				sheetObj.CellValue(Row,"cntr_tpsz_cd"         ) = formObj.cntr_tpsz_cd.value;
				sheetObj.CellValue(Row,"curr_cd"              ) = formObj.curr_cd.value;
				sheetObj.CellValue(Row,"vndr_seq"      	      ) = formObj.vndr_seq.value;
				sheetObj.CellValue(Row,"yd_cd"	              ) = formObj.yd_cd.value;
				sheetObj.CellValue(Row,"err_inv_no"	          ) = formObj.err_inv_no.value;
				sheetObj.CellValue(Row,"if_amt"				  ) = formObj.inv_amt.value;
				sheetObj.CellValue(Row,"n3pty_bil_tp_cd"      ) = 'JO';
			}
        } else {
			/** 2008-08: 전나영 차장 요청 - 기본 금액  **/
			var org_sts = '';
			var ctrt_rt			= document.form.ctrt_rt.value!=null&&!isNaN(parseFloat(document.form.ctrt_rt.value))?parseFloat(document.form.ctrt_rt.value):0;
			var inv_xch_rt		= document.form.inv_xch_rt.value!=null&&!isNaN(parseFloat(document.form.inv_xch_rt.value))?parseFloat(document.form.inv_xch_rt.value):0;
			var inv_amt			= document.form.inv_amt.value!=null&&!isNaN(parseFloat(document.form.inv_amt.value))?parseFloat(document.form.inv_amt.value):0;
			var rvis_vol_qty	= document.form.rvis_vol_qty.value!=null&&!isNaN(parseInt(document.form.rvis_vol_qty.value))?parseInt(document.form.rvis_vol_qty.value):0;
			var tmp_amt			= (ctrt_rt*inv_xch_rt)!=0?(ctrt_rt*inv_xch_rt):(inv_amt/rvis_vol_qty);
			//alert(ctrt_rt + '\n' + inv_xch_rt+ '\n inv_amt:'+ inv_amt + '\n rvis_vol_qty : '+ rvis_vol_qty + '\n (ctrt_rt*inv_xch_rt): ' + (ctrt_rt*inv_xch_rt) + '\n (inv_amt/rvis_vol_qty):' + (inv_amt/rvis_vol_qty) + '\n temp_Amt:' + tmp_amt);
			for (var i= sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
				if (sheetObj.CellValue(i,'tml_if_ofc_cd')==null || sheetObj.CellValue(i,'tml_if_ofc_cd')==''){
					org_sts = sheetObj.RowStatus(i);
					sheetObj.CellValue(i,'if_amt') = tmp_amt;
					sheetObj.RowStatus(i) = org_sts;
				}
			}
		}
        
        //[CHM-201642800]VGM Cost Code 4개 관련 TPB Billing강제화 및 Billing Case Match강제화 
        tes_tpbBillcaseDefaultVal(formObj.lgs_cost_cd.value, sheetObj);       
    }
    
    /** checkMandatory
     *  유효성 체크
     * @param {ibsheet}	sheet_obj	sheet object     
     * @return
     */
     function checkMandatory(sheetObject){//alert("start checkMandatory");
         var openerObj = window.dialogArguments.document;
         var formObj = document.form;
         var iCheckRow = '';
         var count = 0;           // 전체 체크수
         var chkCNTR = 0;         // CNTR 수
         var billCase = 0;        // Billing Case 수
         var result = false;
         

         // TPB I/F 저장 확인 - ( 2009-06-05 )
         var   changeCnt    = 0;
         var   delIfSeq     = "";
         var   delCntrSeq   = "";
         for( var i = sheetObject.HeaderRows; i < sheetObject.HeaderRows + sheetObject.RowCount; i++ ) {
             if ( sheetObject.CellSearchValue(i, "chk") != sheetObject.CellValue( i , "chk" ) ) {
                 if ( sheetObject.CellValue( i , "chk" ) == '0' ) {
                     delIfSeq    += sheetObject.CellValue(i, "tml_if_seq" ) + "|";
                     //delCntrSeq  += sheetObject.CellValue(i, "tml_so_dtl_seq" ) + "|"; 
                 }
                 changeCnt++;         	                         	                
             }
         }

         document.getElementById("del_if_seq").value    = delIfSeq;
         //document.getElementById("del_cntr_seq").value  = delCntrSeq;

         iCheckRow = sheetObject.FindCheckedRow('chk');

 		if (iCheckRow == null || iCheckRow ==''){
 			// TPB IF FLG 방지 추가 ( 2009-06-05 )
             if ( changeCnt > 0 ) {
                 if ( !confirm('Do you want to delete 3rd party?')) {    // 삭제할거니..?
  					return false;
                 }
      			
                 for(var i = sheetObject.HeaderRows; i< sheetObject.HeaderRows+sheetObject.RowCount; i++){
                    if(sheetObject.CellValue(i,'chk') == "1"){
                    	count = count + 1;
                    }
                }   
                 
         		if(count<1){
        			openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
        		}  
                 
             } else {
                 if (!confirm(ComGetMsg('TES40056'))){//저장할 data가 없습니다.
                     //openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
     				window.close();
                     return false;
                 }
             }
         } else {
 			///* - JJ
 			for(var i = sheetObject.HeaderRows; i< sheetObject.HeaderRows+sheetObject.RowCount; i++){
                 if(sheetObject.CellValue(i,'chk') == "1"){
                     if(sheetObject.CellValue(i,'cntr_no') != null){
                         chkCNTR = chkCNTR + 1;
                     }
//alert("n3pty_bil_tp_cd==>"+sheetObject.CellValue(i,'n3pty_bil_tp_cd'));
                     if(sheetObject.CellValue(i,'n3pty_bil_tp_cd') != '' || document.form.lgs_cost_cd.value == 'SVXXJO'){
                         billCase = billCase + 1;
                         if(document.form.lgs_cost_cd.value == 'SVXXJO'){
                        	 sheetObject.CellValue2(i,'n3pty_bil_tp_cd')= "JO";
                         }
//alert("n3pty_bil_tp_cd==>"+sheetObject.CellValue(i,'n3pty_bil_tp_cd'));                         
                     }
                     count = count + 1;
                 }
             }
 			
 			if(count>0){
 				document.getElementById("flg_yn").value  = "Y";
 			}else{
 				document.getElementById("flg_yn").value  = "";
 			}
 	          			
             if (count>chkCNTR || count>billCase){
                 ComShowMessage(ComGetMsg('TES21701')); //ComShowMessage("필수 입력항목을 입력하지 않았습니다. 확인해 주십시오.");
             } else if(count == chkCNTR && count == billCase) {
                openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "Y";
 				window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);
                 result = true;
             }//*/
   
 			var arrRow = iCheckRow.split("|");
		
 			for (var idx=0; arrRow!=null && idx<arrRow.length-1; idx++){ 
 				if (sheetObject.CellValue(arrRow[idx],'cntr_no')==null || sheetObject.CellValue(arrRow[idx],'cntr_no')=='' ||
 					((sheetObject.CellValue(arrRow[idx],'n3pty_bil_tp_cd')==null || sheetObject.CellValue(arrRow[idx],'n3pty_bil_tp_cd')=='') && document.form.lgs_cost_cd.value != 'SVXXJO' ) ||
// 					sheetObject.CellValue(arrRow[idx],'vndr_cust_div_cd')==null || sheetObject.CellValue(arrRow[idx],'vndr_cust_div_cd')=='') 
 					sheetObject.CellValue(arrRow[idx],'curr_cd')==null || sheetObject.CellValue(arrRow[idx],'curr_cd')=='') 				{
 					ComShowMessage(ComGetMsg('TES21701')); //ComShowMessage("필수 입력항목을 입력하지 않았습니다. 확인해 주십시오.");
 					return false;
 				}
 			}
 			
 			// TPB IF FLG 방지 추가 ( 2009-06-05 )
             if ( delIfSeq != "" ) {
                 if ( !confirm('Do you want to delete 3rd party?')) {    // 삭제할거니..?
                     return false;
                 }
             }		
         }

// 		openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "Y";
 		window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);	
         return true;
     }
