	/**
	 * @fileoverview Off-Dock CY Container - 3rd Party Billing Input 화면에서 사용하는 업무 스크립트를 정의한다.
	 * @author SM LINE
	 */
	
	/**
	 * @extends Tes
	 * @class ESD_TES_9233 : Off-Dock CY Container - 3rd Party Billing Input 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_9233() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.setComboObject = setComboObject;
		this.setTabObject = setTabObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.initTab = initTab;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var opener_obj;
	var off_sheet_obj;
	var sheet_curr_row;
	var doneDefN3ptyBilCSCD = false;
	var	comboNm;
	var	comboVal;

	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * @return
	 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObj = sheetObjects[0];

         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObj,formObject,IBINSERT);
        	        break;

                case "btng_rowdel":
    	            doActionIBSheet(sheetObj,formObject,IBDELETE);
                    break;

         	    case "btng_ok":
         	        // TPB I/F 저장 확인 - ( 2009-06-02 )
         	        var   changeCnt    = 0;
         	        var   del_if_seq     = "";
         	        var   del_cntr_seq   = "";
         	        for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++ ) {
         	            if ( sheetObj.CellSearchValue(i, "chk") != sheetObj.CellValue( i , "chk" ) ) {
         	                if ( sheetObj.CellValue( i , "chk" ) == '0' ) {
         	                    del_if_seq    += sheetObj.CellValue(i, "tml_if_seq" ) + "|";
         	                    del_cntr_seq  += sheetObj.CellValue(i, "tml_so_cntr_list_seq" ) + "|";
         	                }
         	                changeCnt++;         	                         	                
         	            }
         	        }
         	        document.getElementById("del_if_seq").value    = del_if_seq;
         	        document.getElementById("del_cntr_seq").value  = del_cntr_seq;
           	        iCheckRow = sheetObj.FindCheckedRow('chk');    // 2009-06-02
           	        
         	        if ( iCheckRow == null || iCheckRow =='' ) {
         	            if ( changeCnt > 0 ) {
         	                if ( confirm(ComGetMsg('TES60103'))) {    // 'Do you want to delete 3rd party?'
             					doActionIBSheet(sheetObj,formObject,IBSAVE);
                            }
         	            } else {
         	                if (!confirm(ComGetMsg('TES40056'))){    //  저장할 data가 없습니다.
                        		//window.close();
                                return false;
                            }
         	            }
                        return false;
         	        } else {
         	            if ( del_if_seq != "" ) {
         	                if ( confirm(ComGetMsg('TES60103'))) {    // 'Do you want to delete 3rd party?'
             					doActionIBSheet(sheetObj,formObject,IBSAVE);
                            }
         	            } else {
         	               doActionIBSheet(sheetObj,formObject,IBSAVE); // 저장, 수정
         	            }
         	        }
        	        //window.close();
        	        break;
                
                case "btn_close":
                    window.close();
                    break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  * @param {ibsheet} 	sheet_obj 	IBSheet Object
	  * @return     
	  */    
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * @return
	 */
    function loadPage() {
    	// TPB BillingCaseCode Default 조회.
        tes_getInputValueInvoice('n3pty_bil_cs_cd', SEARCH02, 'param_lgs_cost_cd', 'setDefN3ptyBilCSCD');
	}

     /**
      * N3pty_Bil_CS_CD가 조회되면 전체를 돌면서 'n3pty_bil_tp_cd'의 default값으로 설정
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
	 * @param sheetObj
	 * @param sheetNo
	 * @return
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
				InitColumnInfo(28, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				//var HeadTitle = "Del.|STS|3rd Party|3rd Party|Container No.|Billing Case|Amount|Remark";
				// 2008-07-03 3rd party interface 로직변경요청 CSR start
				var HeadTitle = "||*Container No.|*Billing Case|Curr.|Amount|3rd Party|3rd Party|Remark";
				//var HeadTitle = "|STS|Container No.|Billing Case|Amount|3rd Party|3rd Party|Remark";
				// 2008-07-03 3rd party interface 로직변경요청 CSR end

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,   30,    daCenter,  true,    "chk");
				InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++, dtData,      100,    daLeft,  false,    "cntr_no",       false,           "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtCombo,     150,    daLeft,  false,    "n3pty_bil_tp_cd",       false,           "",       dfNone,    0,     true,       true);
				// 2008-07-03 3rd party interface 로직변경요청 CSR start
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);
				// 2008-07-03 3rd party interface 로직변경요청 CSR end
				if(tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)){
				   InitDataProperty(0, cnt++, dtData    ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfInteger,  0,     true ,       true);
				}else{
				   InitDataProperty(0, cnt++, dtData,       60,    daRight ,  false,    "if_amt",       false,          "",      dfFloat,    2,     true,       true);
				}
				
				InitDataProperty(0, cnt++, dtCombo,     80,     daLeft,  true,    "vndr_cust_div_cd",        false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtPopup,     100,    daLeft,  true,    "trd_party_val",        false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,      100,    daLeft,  false,    "if_rmk",       false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "vndr_cnt_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "vndr_seq",        false,          "",    dfNone);

				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "n3pty_vndr_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "cust_cnt_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "cust_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "n3pty_ofc_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_if_ofc_cd",        false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_if_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_ofc_cty_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_cntr_list_seq",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_so_dtl_seq",        false,          "",    dfNone);

				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "lgs_cost_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "cntr_tpsz_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "io_bnd_cd",        false,          "",    dfNone);
				
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "calc_cost_grp_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "tml_inv_tp_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "curr_cd",        false,          "",    dfNone);
				InitDataProperty(0, cnt++, dtHidden,       65,  daRight,   true,    "calc_tp_cd",        false,          "",    dfNone);


				InitComboNoMatchText(true);

				InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code);
				InitDataCombo( 0, "n3pty_bil_tp_cd", comboNm, comboVal );
				
//				getTPBGenCombo('n3pty_bil_tp_cd','searchBillingCaseCodeByTES','S','sheet1','5');
//				setTimeout("tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '');", 1500);
				
//				2009-12-07 이정혜 Billing Case 콤보를 동적으로 만들기 위해서 
//				'getThirdPartyBillingCaseHorizontally' 함수에 마지막 인자로
//				모든 작용이 끝난후 호출할 함수명을 넘겨준다
//				getThirdPartyBillingCaseHorizontally('|$|','Y','getTesBillingCase','n3pty_bil_tp_cd_tmp', 'setTpbBillcaseCode');				
				
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
 		comboNm		= tes_tpbBillcaseCodeNm(document.getElementById('n3pty_bil_tp_cd_tmp').value);
		comboVal	= tes_tpbBillcaseCodeVal(document.getElementById('n3pty_bil_tp_cd_tmp').value);

 		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
 		
 		var formObj = document.form;
 		
 		if (formObj.calc_cost_grp_cd.value==null || formObj.calc_cost_grp_cd.value.trim()==''){
 			ComShowMessage(ComGetMsg('TES24046')); //ComShowMessage('Cost Group code가 누락되었습니다.');
 			return false;
 		}
 		if (formObj.calc_tp_cd.value==null || formObj.calc_tp_cd.value.trim()==''){
 			ComShowMessage(ComGetMsg('TES40055')); //ComShowMessage('자동/수동 code가 누락되었습니다.');
 			return false;
 		}

 		if (formObj.calc_cost_grp_cd.value==null || formObj.calc_cost_grp_cd.value.trim()==''){
 			ComShowMessage(ComGetMsg('TES24046')); //ComShowMessage('Cost Group code가 누락되었습니다.');
 		} else {
 			if (formObj.calc_cost_grp_cd.value.trim()=='SP'){
 				//trd_if_hidden_idx = '_2';
 			}
 		}

 		// sheet관련 전역 변수 초기화
 		opener_obj = window.dialogArguments;
 		off_sheet_obj = eval('opener_obj.document.t'+document.form.sheet_idx.value+'sheet1');
 		sheet_curr_row = document.form.sheet_curr_row.value;

  
 		if (formObj.sheet_idx.value!=undefined && formObj.sheet_idx.value=='3'){ 
 			//TMNL CALC.는 RVIS_VOL으로만 입력받는다. -> ROWADD 불가
 			document.all.item("enableRowButton").style.display = "none";
 			document.all.item("disableRowButton").style.display = "inline";
 		} else if (formObj.sheet_idx.value!=undefined && formObj.sheet_idx.value=='4'){ 
 			//FD CALC
 			if (formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='A'){
 				document.all.item("enableRowButton").style.display = "none";
 				document.all.item("disableRowButton").style.display = "inline";
 			} else if (formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='M'){
 				document.all.item("enableRowButton").style.display = "inline";
 				document.all.item("disableRowButton").style.display = "none";
 			}
 		} else if (formObj.sheet_idx.value!=undefined && formObj.sheet_idx.value=='5'){ 
 			//FP CALC
 			document.all.item("enableRowButton").style.display = "inline";
 			document.all.item("disableRowButton").style.display = "none";
 		}
 		
		getList();
//    	 tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
     }

     /**
      * Billing Case 콤보가 생성된 후 목록을 조회한다.
      * @return
      */
     function getList(){
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     
	/**
	 * Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		실행할 액션 구분 값
	 * @return
	 */	
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:

				if (formObj.calc_cost_grp_cd.value==undefined || formObj.calc_cost_grp_cd.value==null || formObj.calc_cost_grp_cd.value.trim()==''){
					ComShowMessage(ComGetMsg('TES21035')); //ComShowMessage('[ERR] calc_cost_grp_cd');
					return false;
				}
				
				if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SD'){
					formObj.f_cmd.value = SEARCHLIST02;
				// SP에서 3rd Party Billing은 더이상 제공하지 않는다.
				//} else if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SP'){
				//	formObj.f_cmd.value = SEARCHLIST01;
				} else {
					formObj.f_cmd.value = SEARCHLIST;
				}
				sheetObj.DoSearch4Post("ESD_TES_9233Popup.do", tesFrmQryStr(formObj));
			    break;

            case IBSAVE: 
            	
//                if (!validateForm(sheetObj,formObj,sAction)){
//			        return false;
//			    }
                
                var total_amt = 0;
				if (sheetObj.RowCount > 0 && sheetObj.IsDataModified){
				    for (var j=sheetObj.HeaderRows; j<(sheetObj.HeaderRows + sheetObj.RowCount); j++){
				        if (sheetObj.CellValue(j,'chk')=='1'){
				            total_amt = total_amt + Number(sheetObj.CellValue(j,'if_amt'));
				        } 
				    }
				    
					// CHM-201432779 [TES] TPB amount logic 수정 (2014-11-20)
				    /*if(Number(document.form.inv_amt.value) < total_amt){
				        ComShowMessage(ComGetMsg('TES60101'));	//Amount should be less than Total Amount.
				        return false;
				    }*/
				    
					for (i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
						if (sheetObj.CellValue(i,'chk')=='1'){
														
						     if (sheetObj.CellValue(i,'tml_so_ofc_cty_cd')==undefined || sheetObj.CellValue(i,'tml_so_seq')==undefined || sheetObj.CellValue(i,'tml_so_dtl_seq')==undefined){
								ComShowMessage(ComGetMsg('TES23048')); //ComShowMessage('ERR - 중요DATA TYPE이 누락되었습니다. 관리자에게 문의하십시오.'); 
								return false;
							 }
						    
						     if(sheetObj.CellValue(i,'tml_if_seq')==null || sheetObj.CellValue(i,'tml_if_seq')==""){
						         sheetObj.RowStatus(i)	= 'I' ;
						     }else{
						         sheetObj.RowStatus(i)	= 'U' ;
						     }
						    
				        	if(sheetObj.CellValue(i, "n3pty_bil_tp_cd")=="") {
				        		ComShowMessage( ComGetMsg('TES60107', i, 'Billing Case') ); //'{?msg1} Row [{?msg2}]is mandantory item.'
				        		return false;
				        	}					
				        	
						}else{
						    sheetObj.RowStatus(i)	= 'R' ;						    
						}
						
						if (isNaN(sheetObj.CellValue(i,'if_amt')) || sheetObj.CellValue(i,'if_amt')<=0) {
							ComShowMessage(ComGetMsg('TES60102')); 	//Amount should be greater than 0.
							return false;
						}
						
						sheetObj.CellValue(i,'vndr_seq') = formObj.vndr_seq.value ;

					}
										
					formObj.f_cmd.value = MULTI;
                    // TPB IF 삭제처리를 위해 주석처리 ( 2009-06-05 )
					var param = sheetObj.GetSaveString(true,false);
					
					if(param == ""){
					     return false;
					}

					var savexml = sheetObj.GetSaveXml("ESD_TES_9233Popup.do", param+'&'+tesFrmQryStr(formObj));
				    sheetObj.LoadSaveXml(savexml,true);
										
				} else {
					ComShowMessage(ComGetMsg('TES40056')); //ComShowMessage('저장할 data가 없습니다.'); 
					return false;
				}
                break;

            case IBINSERT:
				var Row = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(Row,"tml_so_ofc_cty_cd") = formObj.tml_so_ofc_cty_cd.value;
				sheetObj.CellValue2(Row,"tml_so_seq") = formObj.tml_so_seq.value;
				sheetObj.CellValue2(Row,"vndr_cust_div_cd") = "C";
				sheetObj.CellValue2(Row,"lgs_cost_cd") = formObj.param_lgs_cost_cd.value;
				sheetObj.CellValue2(Row,"calc_cost_grp_cd") = formObj.calc_cost_grp_cd.value;
				
				//[CHM-201642800]VGM Cost Code 4개 관련 TPB Billing강제화 및 Billing Case Match강제화
				if(formObj.param_lgs_cost_cd.value == "TMVGWC"){
					sheetObj.CellValue2(Row,"n3pty_bil_tp_cd") = "V2";
				} else if(formObj.param_lgs_cost_cd.value == "TMVGXX"){
					sheetObj.CellValue2(Row,"n3pty_bil_tp_cd") = "V4";
				} else {
					sheetObj.CellValue2(Row,"n3pty_bil_tp_cd") = '';
				}
				
				if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value=='SP'){
					sheetObj.CellEditable(Row,'cntr_no') = true;
				} else if (formObj.calc_cost_grp_cd.value!=null && formObj.calc_cost_grp_cd.value.trim()=='SD'){
					if (formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='M'){
						sheetObj.CellEditable(Row,'cntr_no') = true;
					}				
				}
				sheetObj.CellValue2(Row,"tml_so_dtl_seq") = formObj.tml_so_dtl_seq.value; 
				sheetObj.CellValue2(Row,"curr_cd") = formObj.curr_cd.value; 
				sheetObj.CellValue2(Row,"calc_tp_cd") = formObj.calc_tp_cd.value;
				
				break;

			case IBDELETE:
				if (sheetObj.RowCount > 0){
					var Row = sheetObj.SelectRow;
					sheetObj.RowDelete(Row, false);
				}
				break;

		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		실행할 액션 구분 값
     * @return
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	for( var i=1; i<sheetObj.RowCount; i++){
	        	if(sheetObj.CellValue(i, "chk")==1 && sheetObj.CellValue(i, "n3pty_bil_tp_cd")=="") {
	        		ComShowMessage( ComGetMsg('TES60107', i, 'Billing Case') ); //'{?msg1} Row [{?msg2}]is mandantory item.'
	        		return false;
	        	}
        	}
        }

        return true;
    }

   	 /**
   	  * 조회가 완료되고 발생하는 이벤트
   	  * @param {sheet}	sheetObj		ibsheet
   	  * @param {string}	ErrMsg			error message
   	  * @return
   	  */        
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if (sheetObj.RowCount > 0){
			if (document.form.calc_tp_cd.value=='A' || document.form.calc_cost_grp_cd.value=='TM'){
				//for (var i=1; i<=sheetObj.RowCount; i++){
				for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
				    // 2008-07-03 3rd party interface 로직변경요청 CSR start
				    sheetObj.CellValue(i,'curr_cd')=document.form.curr_cd.value;
				    // 2008-07-03 3rd party interface 로직변경요청 CSR end
					if ((sheetObj.CellValue(i,'tml_if_ofc_cd')==null || sheetObj.CellValue(i,'tml_if_ofc_cd').trim()=='') || 
						(sheetObj.CellValue(i,'tml_if_seq')==null || sheetObj.CellValue(i,'tml_if_seq').trim()=='')) {
						sheetObj.RowStatus(i)	= 'I';
						// 2008-07-07 3rd party interface 로직변경요청 CSR start
						
						if(document.form.calc_cost_grp_cd.value=='TM'){
						    if(document.form.ctrt_rt.value=="" || document.form.ctrt_rt.value==null || Number(document.form.ctrt_rt.value) == 0){
						        sheetObj.CellValue(i,'if_amt')=Number(document.form.inv_amt.value)/Number(document.form.rvis_vol_qty.value);
						    }else{
						        sheetObj.CellValue(i,'if_amt')=Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value);
						        
						    }
						    
						}else{
						    // 2008-07-03 3rd party interface 로직변경요청 CSR start
						    //sheetObj.CellValue(i,'if_amt')=document.form.inv_amt.value;
        					  // 4341.12.23 3rd Parth Interface Amount 산출 로직 변경(전나영 차장님 CSR) Over Days 추가
        					  sheetObj.CellValue(i,'if_amt')=Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value)*Number(document.form.ovr_dys.value);
						    // 2008-07-03 3rd party interface 로직변경요청 CSR end
						    
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
			
			//[CHM-201642800]VGM Cost Code 4개 관련 TPB Billing강제화 및 Billing Case Match강제화 
	        tes_tpbBillcaseDefaultVal(formObj.param_lgs_cost_cd.value, sheetObj);   
		}

	}
	
	/**
	 * 저장 완료되고 발생하는 이벤트
	 * @param {sheet}	sheet			ibsheet
	 * @param {int}		Row				sheet row index
	 * @param {int}		Col				sheet column index
	 * @param {int}		Value			
	 * @return
	 */	  		
	function sheet1_OnSaveEnd(sheet, Row, Col, Value) {
	    // TPB I/F N3PTY FLG 누락 방지 ( 2009-06-03 )
	    iCheckRow = sheet.FindCheckedRow('chk');
        // sheet에 Check(저장)된게 없을경우 Opener에 Flg null 값 설정
     	if ( iCheckRow == null || iCheckRow == '' ) {
          off_sheet_obj.CellValue2(sheet_curr_row,'n3pty_flg') = '';
     	} else {
     	    off_sheet_obj.CellValue2(sheet_curr_row,'n3pty_flg') = 'Y';
     	}

		if (sheet.RowCount > 0){
			opener_obj.disableTPBrow(document.form.sheet_idx.value, off_sheet_obj, sheet_curr_row); //본창의 row를 disable한다.
			
			for (var i=sheet.HeaderRows; i<(sheet.HeaderRows + sheet.RowCount); i++){
			    if(sheet.CellValue(i,'chk') == '0'){
			        if(document.form.calc_cost_grp_cd.value=='TM'){
						    if(document.form.ctrt_rt.value=="" || document.form.ctrt_rt.value==null || Number(document.form.ctrt_rt.value) == 0){
						        sheet.CellValue(i,'if_amt')=Number(document.form.inv_amt.value)/Number(document.form.rvis_vol_qty.value);
						    }else{
						        sheet.CellValue(i,'if_amt')=Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value);
						        
						    }
						    
						}else{
						    // 2008-07-03 3rd party interface 로직변경요청 CSR start
						    //sheetObj.CellValue(i,'if_amt')=document.form.inv_amt.value;
						      sheet.CellValue(i,'if_amt')=Number(document.form.ctrt_rt.value)*Number(document.form.inv_xch_rt.value);
						    // 2008-07-03 3rd party interface 로직변경요청 CSR end
						    
						}
			        
			    }
			    
			}
			
		}
		
		window.close();
				
	}

	/**
	 * sheet 에 클릭 시 발생하는 이벤트
	 * @param {sheet}	sheetObj		ibsheet
	 * @param {int}		Row				sheet row index
	 * @param {int}		Col				sheet column index
	 * @return
	 */		 
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		tes_get3rdParty_sheet(sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row, Col );
	}