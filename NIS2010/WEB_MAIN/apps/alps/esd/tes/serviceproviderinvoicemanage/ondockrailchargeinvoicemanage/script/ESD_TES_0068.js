﻿/*********************************************************************
 * Copyright(c) 2006 CyberLogitec
 * @FileName    : ESD_TES_0068.js
 * @FileTitle   : Marine Terminal Invoice
 * Open Issues      :
 * Change history   :
 * 2011.08.17 박정일 [E-mail요청] [TES] special character, characterSet problem
 * 2012.02.27 박성호 [CHM-201216241]미국 서부지역 조직 변경 관련 PHXSCG의 조회권한 확대 보완사항 테스트
 * 2012.04.05 오요한 [CHM-201217076] [TES]On-Dock Rail Charge 관련 BND별 rate 적용 및 Agrement의 Mode 선택 제한
 * 2015-03-05 김영신 [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
 *********************************************************************/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];

         /***** 폼 오프젝트 변수 *****/
         /*******************************************************/

         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":
                    var tmp_inv_no = formObject.inv_no.value;
        	        var tmp_vndr_seq = formObject.vndr_seq.value;
        	        var tmp_vndr_nm = formObject.vndr_seq_name.value;
        	        
        	        if(tmp_inv_no == null || tmp_inv_no == ''){
        	            if(tmp_vndr_seq == null || tmp_vndr_seq == ''){
        	                ComShowCodeMessage('TES21501'); //ComShowMessage('Pleas Input Invoice No & Vendor Code!');
        	                return;
        	            }else{
        	                ComShowCodeMessage('TES21502'); //ComShowMessage('Please Input Invoice No!');
        	                return;
        	            }
        	        }else{
        	            if(tmp_vndr_seq == null || tmp_vndr_seq == ''){
        	                ComShowCodeMessage('TES21503'); //ComShowMessage('Please Input Vendor Code!');
        	                return;
        	            }
        	        }
        	        
        	        if(tmp_vndr_seq.length < 6){
        	            ComShowCodeMessage('TES21504'); //ComShowMessage('Invaid Vendor Code!');
        	            formObject.vndr_seq.value ='';
        	            formObject.vndr_seq_name.value = '';
        	            //init();
        	            formObject.vndr_seq.focus();
        	            return;
        	        }


/*        	        formObject.reset();
        	        sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            sheetObject2.RemoveAll();
    	            sheetObject3.RemoveAll();*/

    	            formObject.inv_no.value = tmp_inv_no;
        	        formObject.vndr_seq.value = tmp_vndr_seq;
        	        formObject.vndr_seq_name.value = tmp_vndr_nm;
                    doActionIBSheet_main_hidden(sheetObject3,formObject,IBSEARCH);
                    
    	            //doActionIBSheet1(sheetObject,formObject,IBSEARCH);
    	            //doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    	            //doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
                    break;

                case "btn_new":
                    formObject.reset();
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            sheetObject2.RemoveAll();
    	            sheetObject3.RemoveAll();
                    break;

                case "btns_remarks":

                    if(formObject.tml_so_seq.value==null ||formObject.tml_so_seq.value==''){
                        return false;
                    }
                    ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 'popup_remarks', 300,150, true);
                    break;

                case "btn_vndr":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_0C1";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3)

                         // radio PopUp
                         if(chkStr == "1,0") {
                        	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
                        } else {
                             ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                             return;
                        }
          	         break;

                case "btng_totalamount":
                    if(formObject.tml_so_seq.value==null ||formObject.tml_so_seq.value==''){
                        return false;
                    }
//                    ComShowMessage('btng_totalamt');
//                    ComShowMessage('inv_tp:' + formObject.tml_inv_tp_cd.value);
                    var url_str = "ESD_TES_9061.screen?tml_inv_tp_cd="+formObject.tml_inv_tp_cd.value+"&tml_so_ofc_cty_cd="+formObject.tml_so_ofc_cty_cd.value+"&tml_so_seq="+formObject.tml_so_seq.value;;
//				    ComShowMessage(url_str);
				    window.showModalDialog(url_str, window, "dialogWidth:510px; dialogHeight:410px; help:no; status:no; resizable:yes;");
                    break;
                    
                case "btn_pre_inquiry_cond":
					var url_str = 'ESD_TES_0013.do';
					url_str += '?pgmNo=ESD_TES_0013';
					url_str += '&pre_cond_inv_no='+document.form.pre_cond_inv_no.value;
					url_str += '&pre_cond_inv_date_type='+document.form.pre_cond_inv_date_type.value;
					url_str += '&pre_cond_fm_prd_dt='+document.form.pre_cond_fm_prd_dt.value;
					url_str += '&pre_cond_to_prd_dt='+document.form.pre_cond_to_prd_dt.value;
					url_str += '&pre_cond_yd_cd='+document.form.pre_cond_yd_cd.value;
					url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
					url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
					url_str += '&pre_cond_inv_ofc_cd='+document.form.pre_cond_inv_ofc_cd.value;
					url_str += '&pre_cond_tml_inv_sts_cd='+document.form.pre_cond_tml_inv_sts_cd.value;
					url_str += '&pre_cond_csr_no='+document.form.pre_cond_csr_no.value;
					url_str += '&pre_cond_csr_status='+document.form.pre_cond_csr_status.value;
					url_str += '&pre_cond_tml_inv_rjct_sts_cd='+document.form.pre_cond_tml_inv_rjct_sts_cd.value;
					location.href = url_str;
					break;
				
				case "btng_costcodedescshow":
					document.all.CostCodeDescShow.style.display = "none";
					document.all.CostCodeDescHide.style.display = "inline";	
			        sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = false;	//show
					break;
				
				case "btng_costcodedeschide":
					document.all.CostCodeDescShow.style.display = "inline";
					document.all.CostCodeDescHide.style.display = "none";
					sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = true;	//hide
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object 
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
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        var sheetObject = sheetObjects[0];
        var sheetObject3 = sheetObjects[3];
        var formObject = document.form;
        if(!ComIsNull(formObject.inv_no_tmp.value)){
            formObject.inv_no.value = formObject.inv_no_tmp.value;
            formObject.vndr_seq.value = vndr_seq;
            chkInput(formObject.vndr_seq);

            doActionIBSheet_main_hidden(sheetObject3,formObject,IBSEARCH);
        }
        
        document.all.CostCodeDescHide.style.display = "inline";
        
        //India Info Display
    	if(ida_ofc_cd == 'Y'){
    		document.all.IndiaLayer01.style.display = "inline";
    		document.all.IndiaLayer02.style.display = "inline";
    		
    	} else {
    		document.all.IndiaLayer01.style.display = "none";
    		document.all.IndiaLayer02.style.display = "none";
    		
    	}
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheetObj) ==> 시트오브젝트
     * @param(sheetNo)  ==> 시트오브젝트 태그의 아이디에 붙인 일련번호     
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(5) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|VVD|CNTR No.|Type/Size|F/M|DG|Working Date|CLM Date|Rail Billing Date|Verify Result|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,     "",                  false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "vvd",               false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "cntr_no",           false,          "",      dfNone,      0,     true,       true,          30);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "cntr_tpsz_cd",      false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,     "cntr_sty_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,     "dcgo_clss_cd",      false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "wrk_dt",            false,          "",   dfDateYmd,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "clm_dt",            false,          "",   dfDateYmd,      0,     true,       true,          30);

                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "rail_bil_dt",       false,          "",   dfDateYmd,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "dscr_ind_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "cntr_rmk",          false,          "",      dfNone,      0,     true,       true,          30);

                    style.height = GetSheetHeight(16) ;


               }
                break;
            case 2:     //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|Discrepancy Type|CNTR No.|Type/Size|F/M|DG|Working\nDate|CLM Date|Rail Billing\nDate|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,    30,    daCenter,  true,      "");
                    InitDataProperty(0, cnt++ , dtCombo,     150,    daCenter,  true,      "dscr_ind_cd",      false,          "",       dfNone,     0,    false,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,     "cntr_no",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,     "cntr_tpsz_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,     "cntr_sty_cd",      false,          "",      dfNone,      0,     true,       true,          30);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,     "dcgo_clss_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,     "wrk_dt",           false,          "",   dfDateYmd,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,     "clm_dt",           false,          "",   dfDateYmd,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,     "rail_bil_dt",      false,          "",   dfDateYmd,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,     "cntr_rmk",         false,          "",      dfNone,      0,     true,       true,          30);

                    InitDataCombo(0 , "dscr_ind_cd", "Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date", "DD|DP|HO|PD|NH|DB|DF");

                    style.height = GetSheetHeight(17) ;

              }
                break;

            case 3:     //sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(ida_ofc_cd == 'Y'){
        				InitRowInfo(2, 1, 5, 100);
        			} else {
        				InitRowInfo(1, 1, 5, 100);
        			}

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(28, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Type/Size|Applied\nDate|DG|Calculated Vol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remark|3rd Party|dtl_seq";
                    
                    if(ida_ofc_cd == 'Y'){
                        var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Type/Size|Applied\nDate|DG|Calculated Vol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remark|3rd Party|dtl_seq";
                        
                    }
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    if(ida_ofc_cd == 'Y'){
        				InitHeadRow(1, HeadTitle1, true);
        			}

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCombo,     150,    daCenter,  true,     "calc_tp_cd",   false,          "",      dfNone,      0,     true,       true,          30);
                    
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,     "lgs_cost_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,      200,   daLeft,    true,     "lgs_cost_abbr_nm",  false,          "",      dfNone,      0,     true,       true,          30);
					
                    if(ida_ofc_cd == 'Y'){
		            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
		            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
		            } else {
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
		            }
					                   
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "cntr_tpsz_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "tml_wrk_dy_cd",    false,          "",   dfDateYmd,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,     "dcgo_ind_cd",      false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  true,     "calc_vol_qty",     false,          "",      dfNone,      0,     true,       true,          30);

                    InitDataProperty(0, cnt++ , dtPopup,     100,    daCenter,  true,     "rvis_vol_qty",     false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "vol_tr_ut_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "ctrt_rt",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "curr_cd",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "inv_xch_rt",       false,          "",  dfNullFloat,     5,     true,       true,          30);

                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "inv_amt",          false,          "",  dfNullFloat,     2,     true,       true,          30);
                    
                    if(ida_ofc_cd == 'Y'){
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_cgst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_sgst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_igst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_ugst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_gst_rto" , false, "", dfFloat, 2, false, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_gst_amt" , false, "", dfFloat, 2, false, true);
		            } else {
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_amt", false, "", dfFloat, 2, false, false);  
		            }	
                    
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "calc_rmk",         false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtPopup,      70,    daCenter,  true,     "n3pty_flg",        false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,     "tml_so_dtl_seq",   false,          "",      dfNone,      0,     true,       true,          30);
                    
                    if(ida_ofc_cd == 'Y'){
                    	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
                    }
                    style.height = GetSheetHeight(17) ;
                    InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
                    //initDataCombo(0,"a","Auto Calculated Cost|Manual Input Cost","a|b");

              }
                break;
             case 4:      //main_hidden init
                with (sheetObj) {
            	   //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 100, 2);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(43, 4, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
                 								+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
                 								+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|whld_inv_amt|inv_rjct_rmk|rtro_tml_inv_flg|ap_rvs_cng_flg|"
                 								+"dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCdtHiddenStatusDATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtStatus  ,   30  ,    daCenter, false,    "ibflag"			     ,		 false,          "",      dfNone,      0,     false ,       true );
				 InitDataProperty(0, cnt++ , dtData    ,      30,   daCenter,  false,    "sts"			     		   ,		 false,        "",      dfNone,      0,     false ,       true );
                 InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "tml_so_ofc_cty_cd"  ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "tml_so_seq"         ,     false,          "",       dfNone,         0,     true,      true);
			     InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "inv_ofc_cd"         ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "cost_ofc_cd"        ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       300  ,    daLeft,  false,    "inv_no"             ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "vndr_seq"           ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "yd_cd"              ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "yd_nm"              ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "curr_cd"            ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "ttl_inv_amt"        ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "vat_amt"            ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "ttl_calc_amt"       ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "fm_prd_dt"  	       ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "hld_flg"            ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "hld_rmk"            ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "to_prd_dt"          ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_tp_cd"      ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_cost_grp_cd"    ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_calc_ind_cd"    ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "sto_dys_ind_cd"     ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "iss_dt"             ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "rcv_dt"             ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "eff_dt"             ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "pay_due_dt"         ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "pay_flg"            ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_sts_cd"     ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_sts_nm"     ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_rjct_sts_cd",     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "inv_cfm_dt"         ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_agmt_ofc_cty_cd",     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_agmt_seq"       ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_agmt_ver_no"    ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "whld_tax_amt"       ,     false,          "",       dfNone,         0,     true,      true);
				 InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "inv_rjct_rmk"       ,     false,          "",       dfNone,         0,     true,      true);
					//2010.10.15 rtro_tml_inv_flg 추가
				 InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "rtro_tml_inv_flg"   ,     false,          "",       dfNone,         0,     true,      true);
                 InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ap_rvs_cng_flg"     ,     false,          "",       dfNone,         0,     true,      true);

                 InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dbt_note_no", false, "", dfNone, 0, true, true);
     			 InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
     			 InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
     			 InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
     			 InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
     			
                 style.Height = GetSheetHeight(1) ;
					}
                break;
        }
    }

  /**
   * Sheet관련 프로세스 처리
   * @param(sheetobj) sheet object
   * @param(formobj) form object
   * @param(sAction) Action value
   */
     function doActionIBSheet_main_hidden(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:
               formObj.f_cmd.value = SEARCH;
			   var searchXml = sheetObj.GetSearchXml("ESD_TES_0068GS.do", tesFrmQryStr(formObj));
			   if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
			   break;
            case IBSAVE:        //저장
               break;
		    case IBSEARCH_ASYNC01:      //조회
   		       break;
        }
    }
     
     
    /**
     * 폼에 메인시트에 있는 값들을 넣어줌
     * @param main_hidden
     * @param ErrMsg
     * @return
     */ 
    function main_hidden_OnSearchEnd(main_hidden, ErrMsg){
        var formObj = document.form;
        
        if(main_hidden.RowCount==1){
			formObj.no_ofc_cd.value = sheetObjects[3].CellValue(1,'inv_ofc_cd');
			formObj.no_yd_cd.value  = sheetObjects[3].CellValue(1,'yd_cd');
        	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
        	
        }
        
    }

    /**
     * sheet 객체에 값을 넣어줌
     * @param sheetObj   sheet object
     * @param formObj    form  object
     * @param sAction    Action value
     * @return
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
 
           case IBSEARCH:      //조회
              formObj.f_cmd.value = SEARCH01;
              var searchXml = sheetObj.GetSearchXml("ESD_TES_0068GS.do", tesFrmQryStr(formObj));

				var arrXml = searchXml.split("|$$|"); 
	            sheetObjects[0].LoadSearchXml(arrXml[0]);
	            sheetObjects[1].LoadSearchXml(arrXml[1]);
	            sheetObjects[2].LoadSearchXml(arrXml[2]);
	            
	            searchXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null; 
                break;
                
                
/*              
			 // if(searchXml != "")
			  sheetObj.LoadSearchXml(searchXml,true);

			  var sxml0 = sheetObj.EtcData("sxml0");
              var sxml1 = sheetObj.EtcData("sxml1");
              var sxml2 = sheetObj.EtcData("sxml2");
              sheetObj.RemoveEtcData();

              sheetObjects[0].LoadSearchXml(sxml0);
              sheetObjects[1].LoadSearchXml(sxml1);
              sheetObjects[2].LoadSearchXml(sxml2);

              searchXml=null; sxml0=null; sxml1=null; sxml2=null;
               break;
*/
        }
    }

    /**
     * Sheet관련 프로세스 처리
     * @param sheetObj   sheet object
     * @param formObj    form object
     * @param sAction    Action value
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

               sheetObj.DoSearch("UI_ESD_TES_0068_2DATA.html");
               break;

        }
    }

    /**
     * Sheet관련 프로세스 처리
     * @param sheetObj   sheet object
     * @param formObj    form object
     * @param sAction    Action value
     */
    function doActionIBSheet3(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                 if(validateForm(sheetObj,formObj,sAction))
                    sheetObj.DoSearch("UI_ESD_TES_0068_3DATA.html");

                break;
            case IBSAVE:        //저장

                if(validateForm(sheetObj,formObj,sAction))

//                formObj.f_cmd.value = MULTI;

                //sheetObj.DoAllSave("com.hanjin.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001Action.do", FormQueryString(formObj));
                break;

           case IBINSERT:
                var Row = sheetObj.DataInsert();
                break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.SpeedDown2Excel(-1 , true);
             break;
        }
    }



    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(tab_obj)
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     * @param tabObj  tab object
     * @param tabNo   tab number  
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Coincidence" , -1 );
                    InsertTab( cnt++ , "Discrepancy" , -1 );
                    InsertTab( cnt++ , "Cost Calculation" , -1 );
                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * @param(tabObj)
     * @param(nItem)
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;

    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param sheetObj   sheet object
     * @param formObj    form object 
     * @param sAction    Action value 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }


	/**
	 * 입력값의 길이를 확인하고, 입력받은 VNDR Seq가 6자리가되면
	 * 해당 VNDR Seq의 존재여부를 확인하고 VNDR Name을 화면에 보여주는 함수를 호출한다.
	 * @param(obj) object
	 */
	function chkInput(obj) {
	//	ComShowMessage(obj.maxLength + ' / ' + obj.value.length);
	//	ComShowMessage('strleng: '+getStrLen(obj.value));
		if (obj.maxLength < tes_getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
		validateVndrSeq();
	}


	/**
	 *  VndrSeq 유효성 체크
	 */
	function validateVndrSeq() {
		var formObj = document.form;
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}

		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}

		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}
	
	 /**
	  * vndrcode 유효셩 검사
	  * @return
	  */
	function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
//		ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.ida_gst_rgst_ste.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.ida_gst_rgst_no.value = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
					formObj.ida_ste_cd.value = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
					formObj.ida_ste_nm.value = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
				formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
			formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

		}
	}

	/**
	 * 첫번째 sheet object 값 설정
	 * @param t1sheet1    sheet 1 object
	 * @param ErrMsg      에러 메시지
	 * @return
	 */
	function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg){
		var formObj = document.form;

		//초기화
		formObj.sht_01_ttl_box.value	= 0;
		formObj.sht_01_full.value		= 0;
		formObj.sht_01_mt.value			= 0;
		formObj.sht_01_D2.value = 0;
		formObj.sht_01_D2.value = 0;
		formObj.sht_01_D4.value = 0;
		formObj.sht_01_D5.value = 0;
		formObj.sht_01_D7.value = 0;
		formObj.sht_01_D8.value = 0;
		formObj.sht_01_D9.value = 0;
		formObj.sht_01_DW.value = 0;
		formObj.sht_01_DX.value = 0;
		formObj.sht_01_R2.value = 0;
		formObj.sht_01_R4.value = 0;
		formObj.sht_01_R5.value = 0;
		formObj.sht_01_R7.value = 0;
		formObj.sht_01_R8.value = 0;
		formObj.sht_01_R9.value = 0;		
		formObj.sht_01_F2.value = 0;
		formObj.sht_01_F4.value = 0;
		formObj.sht_01_F5.value = 0;
		formObj.sht_01_O2.value = 0;
		formObj.sht_01_O4.value = 0;
		formObj.sht_01_O5.value = 0;
		formObj.sht_01_O7.value = 0;
		formObj.sht_01_S2.value = 0;
		formObj.sht_01_S4.value = 0;
		formObj.sht_01_T2.value = 0;
		formObj.sht_01_T4.value = 0;
		formObj.sht_01_A2.value = 0;
		formObj.sht_01_A4.value = 0;
		formObj.sht_01_A5.value = 0;
		formObj.sht_01_P2.value = 0;
		formObj.sht_01_P4.value = 0;
		//formObj.sht_01_Z2.value = 0;
		//formObj.sht_01_Z4.value = 0;
		formObj.sht_01_C2.value = 0;
		formObj.sht_01_C4.value = 0;


		//계산하여 설정-----------------------------------------------------------
		formObj.sht_01_ttl_box.value = sheetObjects[0].RowCount; //총수


		for (var i=1; i<=sheetObjects[0].RowCount; i++)
		{
			if (sheetObjects[0].CellValue(i,"cntr_sty_cd")!=undefined && sheetObjects[0].CellValue(i,"cntr_sty_cd")!=null && sheetObjects[0].CellValue(i,"cntr_sty_cd").trim()!='')
			{
				try {
					with (formObj) {
						if (sheetObjects[0].CellValue(i,"cntr_sty_cd")=='F'){
							sht_01_full.value++;
						} else if (sheetObjects[0].CellValue(i,"cntr_sty_cd")=='M'){
							sht_01_mt.value++;
						}
					}
				} catch(e){
					//ComShowMessage(e); //여길 그냥 통과해야 한다..
				}
			}

		}

		// Type/Size code별 갯수 구하기
		for (var i=1; i<=sheetObjects[0].RowCount; i++)
		{
			if (sheetObjects[0].CellValue(i,"cntr_tpsz_cd")!=undefined && sheetObjects[0].CellValue(i,"cntr_tpsz_cd")!=null && sheetObjects[0].CellValue(i,"cntr_tpsz_cd").trim()!='')
			{
				try {
					with (formObj) {
						eval('sht_01_'+sheetObjects[0].CellValue(i,"cntr_tpsz_cd")).value++;
					}
				} catch(e){
					//ComShowMessage(e); //여길 그냥 통과해야 한다..
				}
			}
		}

		setTooltip(t1sheet1,'cntr_rmk');
		for(i = i=t1sheet1.HeaderRows ; i<t1sheet1.HeaderRows + t1sheet1.RowCount; i++){
    		if(t1sheet1.CellValue(i,'dscr_ind_cd')=='CO'){
			    t1sheet1.ToolTipText(i,'dscr_ind_cd') = 'Coincidence';
			}else if(t1sheet1.CellValue(i,'dscr_ind_cd')=='HO'){
			    t1sheet1.ToolTipText(i,'dscr_ind_cd') = 'SML List only';
			}else if(t1sheet1.CellValue(i,'dscr_ind_cd')=='HD'){
			    t1sheet1.ToolTipText(i,'dscr_ind_cd') = 'SML List double';
			}else if(t1sheet1.CellValue(i,'dscr_ind_cd')=='NH'){
			    t1sheet1.ToolTipText(i,'dscr_ind_cd') = 'Not in SML source';
			}else if(t1sheet1.CellValue(i,'dscr_ind_cd')=='DB'){
			    t1sheet1.ToolTipText(i,'dscr_ind_cd') = 'Double billing';
			}else if(t1sheet1.CellValue(i,'dscr_ind_cd')=='DD'){
			    t1sheet1.ToolTipText(i,'dscr_ind_cd') = 'Discrepancy by detail data';
			}
		}

	}

	/**
	 * t2sheet1 객체에 값을 넣어줌
	 * @param t2sheet1
	 * @param ErrMsg
	 * @return
	 */
	function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg){
		setTooltip(t2sheet1,'cntr_rmk');
	}


	/***
	 * Cost Calculation탭의 inv_amt컬럽 값을 합친 Calculated AMT  값을 보여준다.
	 * @param t3sheet1    세번째 sheet 객체
	 * @param ErrMsg	  에러메시지 
	 */
	function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg){
	    var formObj = document.form;
	    formObj.ttl_calc_amt1.value=0;
	    formObj.ttl_calc_amt2.value=0;
	    formObj.ttl_calc_amt3.value=0;
	    var ttl_calc_amt=0;

	    for(var i=1;i<=t3sheet1.RowCount;i++){
	        if(t3sheet1.CellValue(i,"inv_amt")!=undefined && t3sheet1.CellValue(i,"inv_amt")!=null && t3sheet1.CellValue(i,"inv_amt").trim()!=''){
	            ttl_calc_amt += eval(t3sheet1.CellValue(i,"inv_amt"));
	        }

	        if(t3sheet1.CellValue(i,'tml_wrk_dy_cd')=='WD'){
			    t3sheet1.ToolTipText(i,'tml_wrk_dy_cd') = 'Week day';
			}else if(t3sheet1.CellValue(i,'tml_wrk_dy_cd')=='SA'){
			    t3sheet1.ToolTipText(i,'tml_wrk_dy_cd') = 'Saturday';
			}else if(t3sheet1.CellValue(i,'tml_wrk_dy_cd')=='SU'){
			    t3sheet1.ToolTipText(i,'tml_wrk_dy_cd') = 'Sunday';
			}else if(t3sheet1.CellValue(i,'tml_wrk_dy_cd')=='HO'){
			    t3sheet1.ToolTipText(i,'tml_wrk_dy_cd') = 'Holiday';
			}

			if(t3sheet1.CellValue(i,'vol_tr_ut_cd')=='C'){
    		    t3sheet1.ToolTipText(i,'vol_tr_ut_cd') = 'Container';
    		}else if(t3sheet1.CellValue(i,'vol_tr_ut_cd')=='T'){
    		    t3sheet1.ToolTipText(i,'vol_tr_ut_cd') = 'TEU';
    		// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
    		}else if(t3sheet1.CellValue(i,'vol_tr_ut_cd')=='B'){
    		    t3sheet1.ToolTipText(i,'vol_tr_ut_cd') = 'BOX';
    		}else if(t3sheet1.CellValue(i,'vol_tr_ut_cd')=='M'){
    		    t3sheet1.ToolTipText(i,'vol_tr_ut_cd') = 'Move';
    		}else if(t3sheet1.CellValue(i,'vol_tr_ut_cd')=='G'){
    		    t3sheet1.ToolTipText(i,'vol_tr_ut_cd') = 'Gang/Hour';
    		} else if (t3sheet1.CellValue(i, 'vol_tr_ut_cd') == 'W' ) {
    			t3sheet1.ToolTipText(i, 'vol_tr_ut_cd') = 'Metric Ton';
    		}
	    }

	    formObj.ttl_calc_amt1.value=ttl_calc_amt;
	    formObj.ttl_calc_amt2.value=ttl_calc_amt;
	    formObj.ttl_calc_amt3.value=ttl_calc_amt;

	    tes_chkAmtFmtObj(formObj.ttl_calc_amt1);
        tes_chkAmtFmtObj(formObj.ttl_calc_amt2);
        tes_chkAmtFmtObj(formObj.ttl_calc_amt3);

        setTooltip(t3sheet1,'calc_rmk');

	}



	/**
     * Vendor Help 화면에서 선택한 벤더를 작업화면으로 보내준다.
     * @param(rowArray) rowArray
     */
    function getVender(rowArray) {
    	var colArray = rowArray[0];
    	//document.all.vndr_seq.value = colArray[2].substr(2,6);
    	document.all.vndr_seq.value = colArray[6];
    	document.all.vndr_seq_name.value = colArray[4];
    }

    /**
     * sheet object tpb 팝업창 띄우는 화면
     * @param sheetObj  sheet object
     * @param row       row
     * @param col       col
     * @return
     */ 
    function t3sheet1_OnPopupClick (sheetObj, row, col)    {
        var formObj = document.form;
        if (sheetObj.ColSaveName(col) == "n3pty_flg"){
            var url_str = "ESD_TES_9251Pop.screen";
            url_str = url_str + "?tml_so_ofc_cty_cd="+formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + "&tml_so_seq="+formObj.tml_so_seq.value;
            url_str = url_str + "&tml_so_dtl_seq="+sheetObj.CellValue(row,"tml_so_dtl_seq");
            url_str = url_str + "&inv_no="+formObj.inv_no.value;
            url_str = url_str + "&curr_cd="+formObj.curr_cd.value;

            window.showModalDialog(url_str, window, "dialogWidth:820px; dialogHeight:470px; help:no; status:no; resizable:yes;");
        }
       /*else if (sheetObj.ColSaveName(col) == "rvis_vol_qty")
		{
			if (sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="A")
			{
				var url_str = "ESD_TES_907_1Pop.screen";
						url_str += "?tml_inv_tp_cd="			+formObj.tml_inv_tp_cd		.value;
						url_str += "&tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
						url_str += "&tml_so_seq="					+formObj.tml_so_seq				.value;
						url_str += "&vndr_seq="						+formObj.vndr_seq					.value;
						url_str += "&yd_cd="							+formObj.yd_cd						.value;
						url_str += "&lgs_cost_cd="				+sheetObj.CellValue(row,"lgs_cost_cd"	);
						url_str += "&cntr_tpsz_cd="				+sheetObj.CellValue(row,"cntr_tpsz_cd");
						url_str += "&dcgo_clss_cd="				+sheetObj.CellValue(row,"dcgo_ind_cd");
						url_str += "&cal_vol="						+sheetObj.CellValue(row,"calc_vol_qty");
						url_str += "&tml_wrk_dy_cd="									+sheetObj.CellValue(row,"tml_wrk_dy_cd"		);
						url_str += "&rvis_vol_qty="				+sheetObj.CellValue(row,"rvis_vol_qty");
					    url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
					    url_str += "&tml_so_dtl_seq="         +sheetObj.CellValue(row,"tml_so_dtl_seq");
					    url_str += "&ctrt_rt="         +sheetObj.CellValue(row,"ctrt_rt");
						url_str += "&opener_row="					+row;
						
				window.showModalDialog(url_str, window, "dialogWidth:430px; dialogHeight:405px; help:no; status:no; resizable:yes;");
			}
		}*/
    }
     
     /** 
      * sheet에 있는 값을 form에 넣어준다.
      * 
      * @return
      */
     function setFormValue(){
    	  var formObj = document.form;
    	  
      	  var checkInv = "N";
      	  var checkVndr = "N";
      	  
      	  if(formObj.inv_no_tmp.value == sheetObjects[3].CellValue(1, 'inv_no'))checkInv = "Y";
      	  if(vndr_seq == tes_lpad(sheetObjects[3].CellValue(1, 'vndr_seq'),6,'0'))checkVndr = "Y";
      	  
    	  if(document.form.auth_ofc_cd.value.trim()=="Y"){
         	
            formObj.tml_so_ofc_cty_cd.value	= sheetObjects[3].CellValue(1, 'tml_so_ofc_cty_cd');
			formObj.tml_so_seq.value		= sheetObjects[3].CellValue(1, 'tml_so_seq');
            formObj.cost_ofc_cd.value       = sheetObjects[3].CellValue(1,'cost_ofc_cd');
            formObj.inv_ofc_cd.value        = sheetObjects[3].CellValue(1,'inv_ofc_cd');
            formObj.yd_cd.value             = sheetObjects[3].CellValue(1,'yd_cd');
            formObj.yd_nm.value             = sheetObjects[3].CellValue(1,'yd_nm');
            formObj.pay_flg.value           = sheetObjects[3].CellValue(1,'pay_flg');
            formObj.curr_cd.value           = sheetObjects[3].CellValue(1,'curr_cd');
            formObj.hld_flg.value           = sheetObjects[3].CellValue(1,'hld_flg');
            formObj.hld_rmk.value           = sheetObjects[3].CellValue(1,'hld_rmk');
            formObj.iss_dt.value            = sheetObjects[3].CellValue(1,'iss_dt');
            formObj.rcv_dt.value            = sheetObjects[3].CellValue(1,'rcv_dt');
            formObj.ttl_inv_amt.value       = sheetObjects[3].CellValue(1,'ttl_inv_amt');
            formObj.vat_amt.value           = sheetObjects[3].CellValue(1,'vat_amt');
            formObj.pay_due_dt.value        = sheetObjects[3].CellValue(1,'pay_due_dt');
            formObj.whld_tax_amt.value      = sheetObjects[3].CellValue(1,'whld_tax_amt');
            formObj.tml_inv_tp_cd.value     = sheetObjects[3].CellValue(1,'tml_inv_tp_cd');

            checkYdCd(formObj.yd_cd.value);
            
            if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'R'){
                formObj.tml_inv_sts_cd.value = 'Received';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'C'){
                formObj.tml_inv_sts_cd.value = 'Confirmed';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'P'){
                formObj.tml_inv_sts_cd.value = 'AP Interfaced';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'A'){
                formObj.tml_inv_sts_cd.value = 'Approval Request';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'D'){
                formObj.tml_inv_sts_cd.value = 'Paid';
            }

            if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'NL'){
                formObj.tml_inv_rjct_sts_cd.value = 'Normal';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RJ'){
                formObj.tml_inv_rjct_sts_cd.value = 'Rejected';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RL'){
                formObj.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
            }

            //Amount 에 관련된 값은 ####.## 형식으로 값을 보여주기위해 tesCommon의 tes_chkAmtFmtObj를 이용한다.
            tes_chkAmtFmtObj(formObj.ttl_inv_amt);
            tes_chkAmtFmtObj(formObj.vat_amt);
            tes_chkAmtFmtObj(formObj.whld_tax_amt);
            
		    if(sheetObjects[3].RowCount>0){
		        doActionIBSheet1(sheetObjects[1], formObj, IBSEARCH);
		    }else{
		        ComShowMessage('No Data for\n\nInv No:'+inv_no+'  &  VNDR Code:'+vndr_seq);
		    }            
 			
      	}else if(formObj.flag.value == "Y" && checkInv == 'Y' && checkVndr == 'Y'){
      		formObj.tml_so_ofc_cty_cd.value	= sheetObjects[3].CellValue(1, 'tml_so_ofc_cty_cd');
			formObj.tml_so_seq.value		= sheetObjects[3].CellValue(1, 'tml_so_seq');
            formObj.cost_ofc_cd.value       = sheetObjects[3].CellValue(1,'cost_ofc_cd');
            formObj.inv_ofc_cd.value        = sheetObjects[3].CellValue(1,'inv_ofc_cd');
            formObj.yd_cd.value             = sheetObjects[3].CellValue(1,'yd_cd');
            formObj.yd_nm.value             = sheetObjects[3].CellValue(1,'yd_nm');
            formObj.pay_flg.value           = sheetObjects[3].CellValue(1,'pay_flg');
            formObj.curr_cd.value           = sheetObjects[3].CellValue(1,'curr_cd');
            formObj.hld_flg.value           = sheetObjects[3].CellValue(1,'hld_flg');
            formObj.hld_rmk.value           = sheetObjects[3].CellValue(1,'hld_rmk');
            formObj.iss_dt.value            = sheetObjects[3].CellValue(1,'iss_dt');
            formObj.rcv_dt.value            = sheetObjects[3].CellValue(1,'rcv_dt');
            formObj.ttl_inv_amt.value       = sheetObjects[3].CellValue(1,'ttl_inv_amt');
            formObj.vat_amt.value           = sheetObjects[3].CellValue(1,'vat_amt');
            formObj.pay_due_dt.value        = sheetObjects[3].CellValue(1,'pay_due_dt');
            formObj.whld_tax_amt.value      = sheetObjects[3].CellValue(1,'whld_tax_amt');
            formObj.tml_inv_tp_cd.value     = sheetObjects[3].CellValue(1,'tml_inv_tp_cd');

            checkYdCd(formObj.yd_cd.value);
            
            if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'R'){
                formObj.tml_inv_sts_cd.value = 'Received';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'C'){
                formObj.tml_inv_sts_cd.value = 'Confirmed';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'P'){
                formObj.tml_inv_sts_cd.value = 'AP Interfaced';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'A'){
                formObj.tml_inv_sts_cd.value = 'Approval Request';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'D'){
                formObj.tml_inv_sts_cd.value = 'Paid';
            }

            if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'NL'){
                formObj.tml_inv_rjct_sts_cd.value = 'Normal';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RJ'){
                formObj.tml_inv_rjct_sts_cd.value = 'Rejected';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RL'){
                formObj.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
            }

            //Amount 에 관련된 값은 ####.## 형식으로 값을 보여주기위해 tesCommon의 tes_chkAmtFmtObj를 이용한다.
            tes_chkAmtFmtObj(formObj.ttl_inv_amt);
            tes_chkAmtFmtObj(formObj.vat_amt);
            tes_chkAmtFmtObj(formObj.whld_tax_amt);
            
		    if(sheetObjects[3].RowCount>0){
		        doActionIBSheet1(sheetObjects[1], formObj, IBSEARCH);
		    }else{
		        ComShowMessage('No Data for\n\nInv No:'+inv_no+'  &  VNDR Code:'+vndr_seq);
		    }   
      	}else{
      		ComShowMessage(ComGetMsg('TES21051'));
      		 document.form.auth_ofc_cd.value = "";
      		 
             sheetObjects[0].RemoveAll();
             sheetObjects[1].RemoveAll();
             sheetObjects[2].RemoveAll();
             sheetObjects[3].RemoveAll();
      	}
          formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObjects[3].CellValue(1, 'ida_cgst_amt' ),sheetObjects[3].CellValue(1,'curr_cd'));
          formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObjects[3].CellValue(1, 'ida_sgst_amt' ),sheetObjects[3].CellValue(1,'curr_cd'));
          formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObjects[3].CellValue(1, 'ida_igst_amt' ),sheetObjects[3].CellValue(1,'curr_cd'));
          formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObjects[3].CellValue(1, 'ida_ugst_amt' ),sheetObjects[3].CellValue(1,'curr_cd'));
    	  
          if (sheetObjects[3].CellValue(1, 'ap_rvs_cng_flg')=='Y') {
            	formObj.ap_rvs_cng_flg.checked = true;
            } else {
            	formObj.ap_rvs_cng_flg.checked = false;
         }
          
          if (sheetObjects[3].CellValue(1, 'rtro_tml_inv_flg')=='Y') {
          	formObj.rtro_tml_inv_flg.checked = true;
          } else {
          	formObj.rtro_tml_inv_flg.checked = false;
          }
          
          
    	//[CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
      	try {
  			 for (var i = 0; i < formObj.elements.length; i++){
  				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
  						formObj.elements[i].name.substring(0,9) == 'pre_cond_')
  				 {
  					 with (formObj) {
  						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
  							 document.all.PreInquiryCondLayer01.style.display = "inline";
  							 break;
  						 }
  					 }
  				 }
  			 }
  		 } catch(e){}
      }         

      
  	/** 
  	 * 입력받은 yard Code가 US 또는 CA가 아닐경우(Code의 앞 2글자) 탭1시트와 탭2시트의 CLM Date칼럼을 Hidden 처리한다
  	 * @return
  	 */
  	function checkYdCd(ydCd) {
  		var sheetObject 	 = sheetObjects[0];
  		var sheetObject1 = sheetObjects[1];
  		
  		if (ydCd.length < 2) return;
  		
  		var ydCdPrefix = ydCd.substring(0,2); 		
  		
  		if ( ydCdPrefix =='US' || ydCdPrefix =='CA') {
  			sheetObject.ColHidden('clm_dt') = false; 
  			sheetObject1.ColHidden('clm_dt') = false; 
  		} else {
  			sheetObject.ColHidden('clm_dt') = true; 
  			sheetObject1.ColHidden('clm_dt') = true; 
  		}
  	}

  	
    /**
	 * 입력된 Invoice No가 기 존재하는 중복된 것이 아닌지 확인하는 함수
	 */
	function validateInvDupChk() {
		var formObj = document.form;
		if (formObj.inv_no.value==null || formObj.inv_no.value.trim()==''){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			return false;
		}
		
		if ((formObj.inv_no_hidden.value==null || formObj.inv_no_hidden.value.trim()=='') || formObj.inv_no.value.trim()!=formObj.inv_no_hidden.value.trim()){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
		}
	}	
	
	/**
	 *  Inv_no Dup Validation 함수
	 */
	function checkInvDup(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_dup_inv_no.value!=undefined && formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value.trim()!=''){
			tmp = formObj.is_dup_inv_no.value;
			if (tmp.length > 0){
				formObj.is_dup_inv_no.value = (tmp!=undefined&&tmp!=null?tmp:'');
				if (formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value == 'Y'){
					//formObj.is_dup_inv_no.value = '';
					//formObj.inv_no_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No. is duplicated. Plz, change to another Invoice No.');
				}
			}
		}
	}	 
	
	/** 엔터 체크 
	 * 
	 * @param funcNm
	 * @return
	 */
	function enterCheck(funcNm){
	    var formObj = document.form;
		if (funcNm==undefined || funcNm==null || funcNm.trim()==''){return false;}
		if (event.keyCode == 13){retrieveEvent(sheetObjects[3], formObj);}
	}

