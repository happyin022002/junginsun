/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9231.js
*@FileTitle : TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-23 parkyeonjin
* 1.0 최초 생성
* 2011.08.08 윤태승 [CHM-201111829-1] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var doneDefN3ptyBilCSCD = false;
var on_sheet_obj;
var opener_obj;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
                case "btng_interfaceto3rd":
         	        if(checkMandatory(sheetObject)==true){
         	            doActionIBSheet(sheetObject,formObject,IBSAVE);
         	            window.close();
         	        }
        	        break;

         	    case "btn_ok":
    	            window.close();
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
     * @param {ibsheet} sheet_obj 담을 ibsheet 
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
        //tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'lgs_cost_cd', 'setDefN3ptyBilCSCD');
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
//        for(i=0;i<sheetObjects.length;i++){
//            ComConfigSheet(sheetObjects[i]);
//            initSheet(sheetObjects[i],i+1);
//            ComEndConfigSheet(sheetObjects[i]);
//        }
        
        tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'lgs_cost_cd', 'setDefN3ptyBilCSCD');
        
        opener_obj = window.dialogArguments;
		on_sheet_obj = eval('opener_obj.document.t'+document.form.sheet_idx.value+'sheet1');

//        doActionIBSheet(sheetObject,formObject,IBSEARCH);
}
    /** 필수사항 체크
     * 
     * @param {ibsheet} sheetObject 	체크할 ibsheet
     * @return
     */ 
    function checkMandatory(sheetObject){
        var openerObj = window.dialogArguments.document;
        var formObj = document.form;
        var iCheckRow = '';
        var count = 0;           // 전체 체크수
        var chkCNTR = 0;         // CNTR 수
        var billCase = 0;        // Billing Case 수
        var result = false;

////        iCheckRow = sheetObject.FindCheckedRow('chk');
////        if(iCheckRow == null || iCheckRow ==''){
////            if(!confirm(ComGetMsg('TES40023'))){//'TPB 대상을 선택하시겠습니까?'
////                openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
////                result = true;
////            }
////        }else{
//            for(var i = sheetObject.HeaderRows; i< sheetObject.HeaderRows+sheetObject.RowCount; i++){
//                if(sheetObject.CellValue(i,'chk') == "1"){
//                    if(sheetObject.CellValue(i,'cntr_no') != null){
//                        chkCNTR = chkCNTR + 1;
//                    }
//                    if(sheetObject.CellValue(i,'n3pty_bil_tp_cd') != ''){
//                        billCase = billCase + 1;
//                    }
//                    count = count + 1;
//                }
//            }
//
//            if(count>chkCNTR || count>billCase){
//                ComShowMessage(ComGetMsg('TES21701')); //ComShowMessage("필수 입력항목을 입력하지 않았습니다. 확인해 주십시오.");
//            }else if(count == chkCNTR && count == billCase){
//                openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "Y";
//                result = true;
//            }
////        }
            
     // TPB I/F 저장 확인 - ( 2009-06-05 )
     var   changeCnt    = 0;
     var   delIfSeq     = "";

     for( var i = sheetObject.HeaderRows; i < sheetObject.HeaderRows + sheetObject.RowCount; i++ ) {
         if ( sheetObject.CellSearchValue(i, "chk") != sheetObject.CellValue( i , "chk" ) ) {
             if ( sheetObject.CellValue( i , "chk" ) == '0' ) {
                 delIfSeq    += sheetObject.CellValue(i, "tml_if_seq" ) + "|";
             }
             changeCnt++;         	                         	                
         }
     }

     document.getElementById("del_if_seq").value    = delIfSeq;

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
     		
     		result = true; 
     		
         } else {
             if (!confirm(ComGetMsg('TES40056'))){//저장할 data가 없습니다.
                 //openerObj.t3sheet1.CellValue(formObj.opener_row.value,"n3pty_flg") = "";
 				window.close();
                 return false;
             }
         }
         
     } else {
			for(var i = sheetObject.HeaderRows; i< sheetObject.HeaderRows+sheetObject.RowCount; i++){
             if(sheetObject.CellValue(i,'chk') == "1"){
                 if(sheetObject.CellValue(i,'cntr_no') != null){
                     chkCNTR = chkCNTR + 1;
                 }
                 if(sheetObject.CellValue(i,'n3pty_bil_tp_cd') != ''){
                     billCase = billCase + 1;
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
				//window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);
             result = true;
         }

			var arrRow = iCheckRow.split("|");
	
			for (var idx=0; arrRow!=null && idx<arrRow.length-1; idx++){ 
				if (sheetObject.CellValue(arrRow[idx],'cntr_no')==null || sheetObject.CellValue(arrRow[idx],'cntr_no')=='' ||
					sheetObject.CellValue(arrRow[idx],'n3pty_bil_tp_cd')==null || sheetObject.CellValue(arrRow[idx],'n3pty_bil_tp_cd')=='' ||
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

		//window.dialogArguments.checkTPBdataEditable(openerObj.t3sheet1);
        return result;
    }


	

   /**
     * 시트 초기설정값, 헤더 정의
     * @param {ibsheet} sheetObj ==> 시트오브젝트, 
     * @param {int}     sheetNo  ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
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
                    InitColumnInfo(34, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Seq|chk||lgs_cost_cd|Container No.|Billing Case|Curr.|Amount|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|3rd Party|Remarks|curr_cd|click_yn";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0, cnt++, dtSeq				 ,     30,    daCenter,  false,   ""   );
                    InitDataProperty(0, cnt++, dtCheckBox		 ,     30,    daCenter,  false,   "chk"   );
                    InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  false,   "ibflag");
                    InitDataProperty(0, cnt++, dtHidden  		 ,     90,    daCenter,  false,   "lgs_cost_cd"			 ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData		,    100,    daCenter,  false,   "cntr_no"					 ,       true,           "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtCombo		,    100,    daCenter,  false,   "n3pty_bil_tp_cd"	 ,       true,           "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);
                    if(tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)){
                        InitDataProperty(0, cnt++, dtData    ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfInteger,  0,     true ,       true);
                    }else{
                        InitDataProperty(0, cnt++, dtData	 ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfFloat,    2,     true ,       true);
                    }
                    InitDataProperty(0, cnt++, dtCombo			 ,     80,    daCenter,  false,   "vndr_cust_div_cd" ,       false,           "",       dfNone,    0,    true ,       true);
                    InitDataProperty(0, cnt++, dtPopup			 ,    100,    daCenter,  false,   "pop_value"				 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden		   ,     90,    daCenter,  true ,   "vndr_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtHidden		   ,     90,    daCenter,  true ,   "n3pty_vndr_seq"   ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		   ,     90,    daCenter,  true ,   "cust_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		   ,     90,    daCenter,  true ,   "cust_seq"      	 ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		   ,     90,    daCenter,  true ,   "n3pty_ofc_cd"     ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData				 ,    180,    daCenter,  false,   "if_rmk"					 ,       false,          "",       dfNone,    0,     true ,       true);

 					InitDataProperty(0, cnt++, dtHidden			 ,     90,    daCenter,  false,   "curr_cd"      		 ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden 		 ,     30,    daCenter,  false,   "click_yn"				 ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_inv_tp_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "bkg_no"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "bkg_no_split"					 ,       false,          "",       dfNone,    0,     true ,       true);

                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "bl_no"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "bl_no_tp"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "bl_no_chk"					 ,       false,          "",       dfNone,    0,     true ,       true);

                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_if_ofc_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_if_seq"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "calc_tp_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "calc_cost_grp_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_so_ofc_cty_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);

                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_so_seq"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_so_cntr_list_seq"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "cntr_tpsz_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "io_bnd_cd"					 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden				 ,    180,    daCenter,  false,   "tml_so_dtl_seq"					 ,       false,          "",       dfNone,    0,     true ,       true);

                    InitComboNoMatchText(true);

//                  getTPBGenCombo('n3pty_bil_tp_cd','searchBillingCaseCodeByTES','S','sheet','5');
//    				getThirdPartyBillingCaseHorizontally('|$|','Y','getTesBillingCase','n3pty_bil_tp_cd_tmp');
//    				setTimeout("tes_tpbBillcaseCode(docObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '' );", 1500);

//					getThirdPartyBillingCaseHorizontally('|$|','Y','getTesBillingCase','n3pty_bil_tp_cd_tmp', 'setTpbBillcaseCode');

					InitDataCombo( 0, "n3pty_bil_tp_cd", comboNm, comboVal );
					InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code,"Customer","C");
					

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
//      tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');

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
 *  @param {ibsheet} 	sheetObj		시트오브젝트
 *  @param {form} 		formObj			폼오브젝트
 *  @param {String}		sAction			액션값
 */     
function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:
             
                if(formObj.calc_tp_cd.value == "A"){ //Auto Calcurated Cost
                    formObj.f_cmd.value = SEARCH;
                    //ComShowMessage(FormQueryString(formObj));
                    var searchXml = sheetObj.GetSearchXml("ESD_TES_9231GS.do",  tesFrmQryStr(formObj));
                    sheetObj.RemoveAll();
                    //ComShowMessage(searchXml);
                    if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);

                }
                break;
                
           case IBSAVE: 
				var total_amt = 0;
				if (sheetObj.RowCount > 0 && sheetObj.IsDataModified){
				    for (var j=sheetObj.HeaderRows; j<(sheetObj.HeaderRows + sheetObj.RowCount); j++){
				        if (sheetObj.CellValue(j,'chk')=='1'){
				            total_amt = total_amt + Number(sheetObj.CellValue(j,'if_amt'));
				        } 
				    }
				    
					// CHM-201432779 [TES] TPB amount logic 수정 (2014-11-20)
				    /*if(Number(document.form.inv_amt.value) < total_amt){
				        ComShowMessage('Amount should be less than Total Amount.');
				        return false;
				    }*/
				    
					for (i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
						if (sheetObj.CellValue(i,'chk')=='1' && sheetObj.CellValue(i,'ibflag')!='R') {
							if (document.form.tml_so_ofc_cty_cd.value==undefined || document.form.tml_so_seq.value==undefined || document.form.tml_so_dtl_seq.value==undefined){
								ComShowMessage(ComGetMsg('TES23048')); //ComShowMessage('ERR - 중요DATA TYPE이 누락되었습니다. 관리자에게 문의하십시오.'); 
								return false;
							}
							
							if(sheetObj.CellValue(i,'tml_if_seq')==null || sheetObj.CellValue(i,'tml_if_seq')==""){
//						         sheetObj.CellValue(i,'ibflag')='I' ;
						         sheetObj.RowStatus(i) = "I";
						     }else{
//						         sheetObj.CellValue(i,'ibflag')='U' ;
						         sheetObj.RowStatus(i) = "U";
						     }
						     
						     if (isNaN(sheetObj.CellValue(i,'if_amt')) || sheetObj.CellValue(i,'if_amt')<=0) {
							    ComShowMessage('Amount should be greater than 0.'); 
							    return false;
						     }	
						     
						}else{
//						    sheetObj.CellValue(i,'ibflag')='R' ;
						    sheetObj.RowStatus(i) = "R";
						}
				            
					}

					formObj.f_cmd.value = MULTI;
					        var param = sheetObj.GetSaveString(false,false,'chk');  
//					        if(param == ""){
//					            return false;
//					        }
					        var savexml = sheetObj.GetSaveXml("ESD_TES_9231GS.do", param+'&'+tesFrmQryStr(formObj));
				            sheetObj.LoadSaveXml(savexml,true);
					
				} else {
					ComShowMessage(ComGetMsg('TES40056')); //ComShowMessage('저장할 data가 없습니다.'); 
					return false;
				}
                break;
          }
}


/** 팝업창 띠움
 * 
 * @param {ibsheet} sheetObj	팝업창에 넘길 시트
 * @param {String}	Row			row 값
 * @param {String}	Col			col 값
 * @return
 */
function sheet_OnPopupClick(sheetObj,Row,Col){
		tes_get3rdParty_sheet(sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row, Col );
}

   /** on change 가 발생했을때 값세팅
    * 
    * @param {ibsheet} 	sheetObj	넘길 시트
    * @param {String} 	Row			row 값
    * @param {String} 	Col			col 값
    * @return
    */
	function sheet_OnChange(sheetObj,Row,Col){

		if (sheetObj.ColSaveName(Col) == "pop_value"){
			if(sheetObj.CellValue(Row,"vndr_cust_div_cd")=='C'){
			  sheetObj.CellValue(Row,"cust_seq"				) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
				sheetObj.CellValue(Row,"cust_cnt_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(0,2);
			}else if(sheetObj.CellValue(Row,"vndr_cust_div_cd")=='S'){
			  sheetObj.CellValue(Row,"n3pty_ofc_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
			}else if(sheetObj.CellValue(Row,"vndr_cust_div_cd")=='V'){
				sheetObj.CellValue(Row,"n3pty_vndr_seq"	) = sheetObj.CellValue(Row,"pop_value").substring(2,8);
				sheetObj.CellValue(Row,"vndr_cnt_cd"		) = sheetObj.CellValue(Row,"pop_value").substring(0,2);
			}
		}else if(sheetObj.ColSaveName(Col) == "if_amt" && sheetObj.CellValue(Row,"if_amt")<0){
		    sheetObj.CellValue(Row,"if_amt") = "";
		    ComShowMessage("Minus amout is not allowed to 3rd Party.");
		}
	}
	
	/** sheet에 total 값 넣어주는 부분
	 * 
	 * @param {ibsheet}	sheetObj
	 * @return
	 */
	function sheet_OnSearchEnd(sheetObj){
	    var formObj = document.form;
		if (sheetObj.RowCount > 0){
			if (document.form.calc_tp_cd.value=='A' || document.form.calc_cost_grp_cd.value=='ON'){
				// for (var i=1; i<=sheetObj.RowCount; i++){
				for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
				    // 2008-07-03 3rd party interface 로직변경요청 CSR start
				    sheetObj.CellValue(i,'curr_cd')=document.form.curr_cd.value;
				    // 2008-07-03 3rd party interface 로직변경요청 CSR end
					if ((sheetObj.CellValue(i,'tml_if_ofc_cd')==null || sheetObj.CellValue(i,'tml_if_ofc_cd').trim()=='') || 
						(sheetObj.CellValue(i,'tml_if_seq')==null || sheetObj.CellValue(i,'tml_if_seq').trim()=='')) {
//						sheetObj.CellValue(i,'ibflag')='I';
						sheetObj.RowStatus(i) = "I";
						// 2008-07-07 3rd party interface 로직변경요청 CSR start
						if(document.form.ctrt_rt.value=="" || document.form.ctrt_rt.value==null || Number(document.form.ctrt_rt.value) == 0){
						    sheetObj.CellValue(i,'if_amt')=Number(document.form.inv_amt.value)/Number(document.form.rvis_vol_qty.value);
						}else{
						    
						    sheetObj.CellValue(i,'if_amt')=Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value);
						}
						    
						// 2008-07-07 3rd party interface 로직변경요청 CSR end
		            }
		            
					if (sheetObj.CellValue(i,"tml_so_dtl_seq")==null || sheetObj.CellValue(i,"tml_so_dtl_seq").trim()==''){
						sheetObj.CellValue2(i,"tml_so_dtl_seq") = formObj.tml_so_dtl_seq.value;
					}
					if (sheetObj.CellValue(i,"lgs_cost_cd")==null || sheetObj.CellValue(i,"lgs_cost_cd").trim()==''){
						sheetObj.CellValue2(i,"lgs_cost_cd") = formObj.param_lgs_cost_cd.value;
					}
				}
			}
		}
	}		

/**
 * 
 * @param {ibsheet}	sheet		sheet object
 * @param {String}	Row
 * @param {String}	Col
 * @param {String}	Value
 * @return
 */
function sheet_OnSaveEnd(sheet, Row, Col, Value) {
	if (sheet.RowCount > 0){
			on_sheet_obj.CellValue2(document.form.opener_row.value,'n3pty_flg') = 'Y';
			//opener_obj.disableTPBrow(document.form.sheet_idx.value, off_sheet_obj, sheet_curr_row); //본창의 row를 disable한다.
			
			for (var i=sheet.HeaderRows; i<(sheet.HeaderRows + sheet.RowCount); i++){
			    if(sheet.CellValue(i,'chk') == '0'){
			        if(document.form.ctrt_rt.value=="" || document.form.ctrt_rt.value==null || Number(document.form.ctrt_rt.value) == 0){
			        		sheet.CellValue(i,'if_amt')=Number(document.form.inv_amt.value)/Number(document.form.rvis_vol_qty.value);
						}else{
							sheet.CellValue(i,'if_amt')=Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value);
						}
			    }
			}
	}
}

/** 체크 클릭시 
 * 
 * @param {ibsheet}	sheet		sheet object
 * @param {String}  row			row 값
 * @param {String}	col			col 값
 * @return
 */
function sheet_OnClick(sheet, row, col){
	if (sheet.ColSaveName(col) == "chk"){
		if(sheet.CellValue(row,"click_yn") == "Y")  sheet.CellValue(row,"click_yn") = "N";
		else sheet.CellValue(row,"click_yn") = "Y";
	} 
}

/** 값세팅
 * 
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
