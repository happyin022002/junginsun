/**
  @fileoverview Off-Dock CY Container List 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_0018 : Off-Dock CY Container List 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * 2011.08.17 박정일 [E-mail요청] [TES] special character, characterSet problem
 * 2012.02.27 박성호 [CHM-201216241]미국 서부지역 조직 변경 관련 PHXSCG의 조회권한 확대 보완사항 테스트
 * 2015-03-05 김영신 [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
 */
function ESD_TES_0018() {
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
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * @return
	 */
	function processButtonClick(){
    	
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];
         var sheetObject4 = sheetObjects[4];
		 var sheetObject5 = sheetObjects[5];

         /** **************************************************** */
         var formObject = document.form;


    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
        	    case "btn_retrieve":
       	     		retrieve('Y');
        	        break;

        	    case "btn_new":
    	            formObject.reset();
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            sheetObject2.RemoveAll();
    	            sheetObject3.RemoveAll();
    	            sheetObject4.RemoveAll();
        	        break;

        	    case "btn_vndr":
                  var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
        	       	var classId = "COM_ENS_0C1";

        		   		var param = '?classId='+classId;

        		   		var chkStr = dispaly.substring(0,3)

                       // radio PopUp
                       if(chkStr == "1,0") {
                    	   ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVender', dispaly);
                      } else {
                           ComShowMessage(ComGetMsg('TES21906')); // ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                           return;
                      }
        	        break;

              case "btns_remarks":
            	  var display = "1,0,1,1,1,1,1,1,1,1,1,1";
            	  ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 300, 150, '', display, true);
                  break;

              case "btng_totalamount":
									var url_str = 'ESD_TES_9050Popup.screen?tml_so_ofc_cty_cd='+formObject.tml_so_ofc_cty_cd.value+'&tml_so_seq='+formObject.tml_so_seq.value;
									// window.open(url_str,
									// 'popup_rev_calc_vol', 'width=600px,
									// height=400px, location=0, status=0,
									// resizable=1');
									window.showModalDialog(url_str, window, "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;");
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
					document.all.CostCodeDescShow01.style.display = "none";
					document.all.CostCodeDescHide01.style.display = "inline";
					document.all.CostCodeDescShow02.style.display = "none";
					document.all.CostCodeDescHide02.style.display = "inline";
					document.all.CostCodeDescShow03.style.display = "none";
					document.all.CostCodeDescHide03.style.display = "inline";
					
			        sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = false;	//show
			        sheetObjects[3].ColHidden("lgs_cost_abbr_nm") = false;	//show
			        sheetObjects[4].ColHidden("lgs_cost_abbr_nm") = false;	//show
					break;
				
				case "btng_costcodedeschide":
					document.all.CostCodeDescShow01.style.display = "inline";
					document.all.CostCodeDescHide01.style.display = "none";
					document.all.CostCodeDescShow02.style.display = "inline";
					document.all.CostCodeDescHide02.style.display = "none";
					document.all.CostCodeDescShow03.style.display = "inline";
					document.all.CostCodeDescHide03.style.display = "none";
					
					sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = true;	//hide
		        	sheetObjects[3].ColHidden("lgs_cost_abbr_nm") = true;	//hide
		        	sheetObjects[4].ColHidden("lgs_cost_abbr_nm") = true;	//hide
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); // ComShowMessage("지금은
														// 사용하실 수가 없습니다 ");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param {ibsheet} sheet_obj 	IBSheet Object
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

        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        var formObj = document.form;
        
        if(!ComIsNull(formObj.inv_no_tmp.value)){
            formObj.inv_no.value = formObj.inv_no_tmp.value;
            formObj.vndr_seq.value = vndr_seq;
            validateVndrSeq();
            retrieve('Y');
        }
		
		document.form.inv_no.focus();	

		for (var i=1; i<sheetObjects[2].Rows; i++){
			sheetObjects[2].CellEditable(i,'n3pty_flg') = true;
		}
		
        document.all.CostCodeDescHide01.style.display = "inline";
        document.all.CostCodeDescHide02.style.display = "inline";
        document.all.CostCodeDescHide03.style.display = "inline";

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
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {int} sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @return
	 */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:   //t1sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(15);
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, true, true, false,false)

					var HeadTitle = "Seq.|CNTR No.|Type/Size|Gate In|Gate Out|F/M|I/O|DG|B/B|Mode|Verify\nResult|Remarks|";

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,         30,    daCenter,  false,    "",     false,          "",       dfNone,        0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtData,        90,    daCenter,  false,    "cntr_no",     false,          "",       dfNone,        0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false,    "cntr_tpsz_cd",     false,          "",       dfNone,        0,     false,      false, 1);
					InitDataProperty(0, cnt++ , dtData,        110,    daCenter , false,    "inv_gate_in_dt",     false,          "",       dfUserFormat2,     0,     false,      false, 9);
                    InitDataProperty(0, cnt++ , dtData,        110,    daCenter,  false,   "inv_gate_out_dt",     false,          "",       dfUserFormat2,      0,     false,      false, 6);

					InitDataProperty(0, cnt++ , dtData,        50,    daCenter , false,   "cntr_sty_cd",     false,          "",       dfNone,         0,     true,      true, 9);
					InitDataProperty(0, cnt++ , dtData,        50,    daCenter , false,   "io_bnd_cd",     false,          "",       dfNone,         0,     true,      true, 9);
					InitDataProperty(0, cnt++ , dtData,        50,    daCenter,  false,   "dcgo_clss_cd",     false,          "",       dfNone,         0,     true,      true, 1);
					InitDataProperty(0, cnt++ , dtData,        50,    daCenter , false,   "bb_cgo_flg",     false,          "",       dfNone,         0,     true,      true, 9);
					InitDataProperty(0, cnt++ , dtData,        50,    daCenter,  false,   "tml_trns_mod_cd",   false,          "",       dfNone,         0,     true,      true, 1);
					InitDataProperty(0, cnt++ , dtData,        50,    daCenter , false,   "dscr_ind_cd",     false,          "",       dfNone,         0,     false,      false, 9);

					InitDataProperty(0, cnt++ , dtData,        100,    daLeft , false,   "cntr_rmk",     false,          "",       dfNone,         0,     true,      true, 500);


                    InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:" ); 
                    InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:" );
                }
                break;
             case 2:   //t2sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(15);
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1 , 5, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 2, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle0 = "Discrepancy Type|Seq.|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O\|Remarks";
                    var HeadTitle1 = "Discrepancy Type|Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";


				   	// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCombo,      150,    daLeft,    true,     "dscr_ind_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtDataSeq,    30,    daCenter,  true,     "",     false,          "",       dfNone,          0,    false,      false);
                    InitDataProperty(0, cnt++ , dtData,       130,   daCenter,    false,     "cntr_no",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "cntr_tpsz_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter , false,    "cntr_sty_cd",     false,          "",       dfNone,         0,     true,      true, 9);

					InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "mvmt_gate_in_dt",    false,          "",       dfUserFormat2,       0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "inv_gate_in_dt",    false,          "",       dfUserFormat2,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,     "gate_in_td_dys",    false,          "",       dfInteger,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "mvmt_gate_out_dt",    false,          "",       dfUserFormat2,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "inv_gate_out_dt",    false,          "",       dfUserFormat2,       0,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,     "gate_out_td_dys",    false,          "",       dfInteger,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,    daLeft  ,  false,     "cntr_rmk",    false,          "",       dfNone,          0,     true,      true);


					InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "mvmt_gate_in_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "mvmt_gate_out_dt", "####-##-## ##:##", "-|:");

					InitDataCombo(0 , "dscr_ind_cd", "Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date|Another Movement", "DD|DP|HO|PD|NH|DB|DF|AM");

                    HeadRowHeight = 10;
                    RangeBackColor(1,5,1,6) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1,8,1,9) = RgbColor(222, 251, 248);   // ENIS

                }
                break;

             case 3:   //t3sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(15);
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        			if(ida_ofc_cd == 'Y'){
        				InitRowInfo(2, 1, 5, 100);
        			} else {
        				InitRowInfo(1, 1, 5, 100);
        			}

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(30, 0, 0, true);

                		// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Type/Size|Mode|Calculated\nVol.|Year\nMonth|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party";
                	if(ida_ofc_cd == 'Y'){
                		var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Type/Size|Mode|Calculated\nVol.|Year\nMonth|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party";
                	}
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        			InitHeadRow(0, HeadTitle, true);
        			if(ida_ofc_cd == 'Y'){
        				InitHeadRow(1, HeadTitle1, true);
        			}

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCombo,      150,    daLeft,    true,     "calc_tp_cd",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,    true,     "lgs_cost_cd",     false,          "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      200,   daLeft,    true,     "lgs_cost_abbr_nm",     false,          "",       dfNone,          0,     false,      false);
					if(ida_ofc_cd == 'Y'){
		            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
		            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
		            } else {
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
		            }
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "cntr_tpsz_cd",     false,          "",       dfNone,           0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "tml_trns_mod_cd",     false,          "",       dfNone,           0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "calc_vol_qty",     false,          "",       dfInteger,         0,     false,      false);
                    // manual input 비용 계산 적용 년월 칼럼 추가 ( 4342. 01. 19 - 이경한 과장 요청
					// CSR TMNL 추가 )
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter ,  true,    "rev_yrmon",     false,          "",       dfDateYm,   		0,     false,      false);

					InitDataProperty(0, cnt++ , dtPopup,      80,    daCenter,  true,    "rvis_vol_qty",     false,          "",       dfInteger,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,    "vol_tr_ut_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "ctrt_rt",     false,          "",       dfFloat,         2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_xch_rt",     false,          "",       dfFloat,         5,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       60,    daRight ,  true,    "inv_amt",     false,          "",       dfFloat,      2,     false,      false);
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
					InitDataProperty(0, cnt++ , dtData,       300,    daLeft  ,  true,    "calc_rmk",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,      10,    daLeft  ,  true,    "n3pty_flg",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     20,    daLeft,    true,     "tml_so_dtl_seq",     false,          "",       dfInteger,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true,    "dcgo_ind_cd",     false,          "",       dfNone,         0,     false,      false);

					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true,    "rc_flg",     false,          "",       dfNone,         0,     false,      false);

					InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
					
					
					if(ida_ofc_cd == 'Y'){
		            	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
		            }
                }
                break;

             case 4:   //t4sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(15);
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        			if(ida_ofc_cd == 'Y'){
        				InitRowInfo(2, 1, 5, 100);
        			} else {
        				InitRowInfo(1, 1, 5, 100);
        			}

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(33, 0, 0, true);

               		// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party";
                	
        			if(ida_ofc_cd == 'Y'){
    					var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party";

        			}
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        			InitHeadRow(0, HeadTitle, true);
        			if(ida_ofc_cd == 'Y'){
        				InitHeadRow(1, HeadTitle1, true);
        			}

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCombo,      150,    daLeft,    true,     "calc_tp_cd",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,    true,     "lgs_cost_cd",     false,          "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      200,    daLeft,    true,     "lgs_cost_abbr_nm",     false,          "",       dfNone,          0,     false,      false);
					if(ida_ofc_cd == 'Y'){
		            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
		            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
		            } else {
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
		            }
					InitDataProperty(0, cnt++ , dtData,       80,    daLeft  ,  true,     "cntr_no",     false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,    "cntr_tpsz_cd",     false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,    "io_bnd_cd",     false,          "",       dfNone,         0,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_ind_cd",     false,          "",       dfNone,         0,     false,      false);
                    // manual input 비용 계산시 적용 년월 칼럼 추가 ( 4342. 01. 13 - 이경한 과장
					// 요청 CSR )
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter ,  true,    "rev_yrmon",     false,          "",       dfDateYm,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       45,    daCenter,  true,    "stay_dys",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       45,    daCenter,  true,    "free_dys",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  true,    "paid_day",     false,          "",       dfInteger,         0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       35,    daCenter ,  true,    "free_dy_xcld_dys",     false,          "",       dfInteger,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  true,    "ovr_dys",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  true,    "vol_tr_ut_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "ctrt_rt",     false,          "",       dfFloat,        2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_xch_rt",     false,          "",       dfFloat,         5,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight ,  true,    "inv_amt",     false,          "",       dfFloat,        2,     false,      false);
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
					InitDataProperty(0, cnt++ , dtData,       200,    daLeft  ,  true,    "calc_rmk",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtPopup,      10,    daLeft  ,  true,    "n3pty_flg",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     20,    daLeft,    true,     "tml_so_dtl_seq",     false,          "",       dfInteger,         0,     false,      false);

					InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
					if(ida_ofc_cd == 'Y'){
		            	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
		            }
                }
                break;

             case 5:   //t5sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(10);
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        			if(ida_ofc_cd == 'Y'){
        				InitRowInfo(2, 1, 5, 100);
        			} else {
        				InitRowInfo(1, 1, 5, 100);
        			}
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(29, 0, 0, true);

               		// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party";
        			if(ida_ofc_cd == 'Y'){
        				var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party";
             			
        			}
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
        			if(ida_ofc_cd == 'Y'){
        				InitHeadRow(1, HeadTitle1, true);
        			}

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCombo,      150,    daLeft,    true,     "calc_tp_cd",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,    true,   "lgs_cost_cd",     false,          "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      200,    daLeft,    true,   "lgs_cost_abbr_nm",     false,          "",       dfNone,          0,     false,      false);
					if(ida_ofc_cd == 'Y'){
		            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
		            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
		            } else {
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
		            }
					
					InitDataProperty(0, cnt++ , dtData,       65,    daCenter,  true,    "wrk_dt",     false,          "",       dfDateYmd,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daRight ,  true,    "stk_vol_qty",     false,          "",       dfInteger,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_vol_qty",     false,          "",       dfInteger,      0,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       37,    daRight,  true,    "diff_vol_qty",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "fp_teu_qty",     false,          "",       dfInteger,      0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       45,    daRight,  true,    "ovr_vol_qty",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      35,    daRight,  true,    "vol_tr_ut_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "ctrt_rt",     false,          "",       dfFloat,        2,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_xch_rt",     false,          "",       dfFloat,         5,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight ,  true,    "inv_amt",     false,          "",       dfFloat,        2,     false,      false);
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
					
					InitDataProperty(0, cnt++ , dtData,       200,    daLeft  ,  true,    "calc_rmk",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,      10,    daCenter,  true,    "n3pty_flg",     false,          "",       dfNone,         0,     true,      true);
                
					InitDataProperty(0, cnt++ , dtHidden,     20,    daLeft,    true,     "tml_so_dtl_seq",     false,          "",       dfInteger,         0,     false,      false);

					InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
					if(ida_ofc_cd == 'Y'){
		            	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
		            }
				}
                break;

             case 6:   //main_hidden
            	 with (sheetObj) {
     			style.height = GetSheetHeight(5);
     			// 전체 너비 설정
     			SheetWidth = mainTable.clientWidth;

     			// Host정보 설정[필수][HostIp, Port, PagePath]
     			if (location.hostname != "")
     				InitHostInfo(location.hostname, location.port, page_path);

     			// 전체Merge 종류 [선택, Default msNone]
     			MergeSheet = msAll;

     			// 전체Edit 허용 여부 [선택, Default false]
     			Editable = false;

     			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     			InitRowInfo(1, 1, 5, 100);

     			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     			InitColumnInfo(45, 1, 0, true);

     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
     			InitHeadMode(true, true, false, true, false, false);

     			var HeadTitle = "tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|"
     						  + "fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|"
     						  + "pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|"
     						  +"inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt|mvmt_gate_in_dt|mvmt_gate_out_dt"
     						  + "dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";
     			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     			InitHeadRow(0, HeadTitle, true);

     			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
     			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
     			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
     			// SAVESTATUS, FORMATFIX]
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_seq", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_ofc_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cost_ofc_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_no", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vndr_seq", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "yd_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "yd_nm", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "curr_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ttl_inv_amt", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vat_amt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ttl_calc_amt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "fm_prd_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "hld_flg", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "hld_rmk", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "to_prd_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_inv_tp_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_cost_grp_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_calc_ind_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "sto_dys_ind_cd", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "iss_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "rcv_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "eff_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "pay_due_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "pay_flg", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_inv_sts_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_inv_rjct_sts_cd", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_cfm_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_rjct_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_rjct_rmk", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cre_usr_id", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cre_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "upd_usr_id", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "upd_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dup_tp_cd", false, "", dfNone, 0, true, true);

     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "err_inv_no", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "whld_tax_amt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ap_rvs_cng_flg", false, "", dfNone, 0, true, true);
     			
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "mvmt_gate_in_dt", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "mvmt_gate_out_dt", false, "", dfNone, 0, true, true);
     			
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dbt_note_no", false, "", dfNone, 0, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
     			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
     		}
     		break;

        }
    }

    /**
     * Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}	sAction		실행할 액션 구분 값
     * @return
     */
    function doActionIBSheetAllSheets(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				var arr_sht = getCostCalcShtToSaveArr('N'); // Cost Group에서 선택된 조건에 따라 저장할 sheet의 idx 배열을 return
				formObj.f_cmd.value = SEARCHLIST03;
				var sXml = sheetObj.GetSearchXml("ESD_TES_0018GS.do", tesFrmQryStr(formObj));
				
				var arrXml = sXml.split("|$$|"); 
				
				for (var i=0; arrXml!=null && i<arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
								
				// sheetObj.LoadSearchXml(sXml);
				// var idx = 0;
				// var sxml0;
				// var sxml1;
				// var sxml2;
				// var sxml3;
				// var sxml4;
				// sxml0 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
				// sxml1 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
				// for (var i=0; arr_sht!=null && i<arr_sht.length; i++) {
				// if (arr_sht[i]==2) { //TMNL
				// sxml2 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
				// } else if (arr_sht[i]==3) { //FD
				// sxml3 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
				// }
				// }
				// sxml4 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
				//				
				// sheetObj.RemoveEtcData();
				//				
				// sheetObjects[0].LoadSearchXml(sxml0);
				// sheetObjects[1].LoadSearchXml(sxml1);
				// for (var i=0; arr_sht!=null && i<arr_sht.length; i++){
				// sheetObjects[arr_sht[i]].LoadSearchXml(eval('sxml'+new String(arr_sht[i])));
				// }
				// sheetObjects[4].LoadSearchXml(sxml4);
				// sXml=null; sxml0=null; sxml1=null; sxml2=null; sxml3=null; sxml4=null;
								
			    break;

           case IBSAVE:        //저장
				break;

        }
    }
	
	/**
	 * main hidden Sheet관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}	sAction		실행할 액션 구분 값
	 * @return
	 */
    function doActionMainHiddenSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
           	if (!validateForm(sheetObj,formObj,sAction)){
           		return false;
           	}
		    formObj.f_cmd.value = SEARCH;
		    sheetObj.DoSearch4Post("ESD_TES_0018GS.do", tesFrmQryStr(formObj));
		    break;
       }
    }

	 /**
	  * 세번째( Cost Calc.(TMNL) ) 탭에 있는 Sheet OnPopupClick 이벤트
	  * n3pty_flg : 3rd Party,  rvis_vol_qty : Revised Volume
	  * @param {ibsheet}	sheetObj 	IBSheet Object
	  * @param {int}	row 		IBSheet Object Row Index
	  * @param {int}	col 		IBSheet Object Column Index
	  * @return
	  */
    function t3sheet1_OnPopupClick(sheetObj,row,col){
        var formObj = document.form;
        
        if (sheetObj.ColSaveName(col) == "n3pty_flg"){
			if (sheetObj.CellValue(row,'n3pty_flg')=='Y'){
				var url_str = 'ESD_TES_9253Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='+sheetObj.CellValue(row,'tml_so_dtl_seq');
				url_str = url_str + '&inv_no='+formObj.inv_no.value;
				window.showModalDialog(url_str, window, "dialogWidth:710px; dialogHeight:420px; help:no; status:no; resizable:yes;");
			}
		} else if (sheetObj.ColSaveName(col) == "rvis_vol_qty"){
			if (sheetObjects[5].CellValue(1,'sto_dys_ind_cd')!=null && sheetObjects[5].CellValue(1,'sto_dys_ind_cd')=='IO'){
				var url_str = 'ESD_TES_9074Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='+sheetObj.CellValue(row,'tml_so_dtl_seq');
				url_str = url_str + '&calc_tp_cd='+sheetObj.CellValue(row,'calc_tp_cd');
				url_str = url_str + '&param_lgs_cost_cd='+sheetObj.CellValue(row,'lgs_cost_cd');
				url_str = url_str + '&param_cntr_tpsz_cd='+sheetObj.CellValue(row,'cntr_tpsz_cd');
				url_str = url_str + '&param_dcgo_clss_cd='+sheetObj.CellValue(row,'dcgo_ind_cd');
				url_str = url_str + '&param_rc_flg='+sheetObj.CellValue(row,'rc_flg');
				window.showModalDialog(url_str, window, "dialogWidth:610px; dialogHeight:430px; help:no; status:no; resizable:yes;");
			} else if (sheetObjects[5].CellValue(1,'sto_dys_ind_cd')!=null && sheetObjects[5].CellValue(1,'sto_dys_ind_cd')=='DT'){
				var url_str = 'ESD_TES_9075Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='+sheetObj.CellValue(row,'tml_so_dtl_seq');
				url_str = url_str + '&calc_tp_cd='+sheetObj.CellValue(row,'calc_tp_cd');
				url_str = url_str + '&param_lgs_cost_cd='+sheetObj.CellValue(row,'lgs_cost_cd');
				url_str = url_str + '&param_cntr_tpsz_cd='+sheetObj.CellValue(row,'cntr_tpsz_cd');
				url_str = url_str + '&param_dcgo_clss_cd='+sheetObj.CellValue(row,'dcgo_ind_cd');
				url_str = url_str + '&param_rc_flg='+sheetObj.CellValue(row,'rc_flg');
				url_str = url_str + '&fm_prd_dt='+formObj.fm_prd_dt.value;
				window.showModalDialog(url_str, window, "dialogWidth:610px; dialogHeight:430px; help:no; status:no; resizable:yes;");
			}
		}
    }

	 /**
	  * 네번째( Cost Calc.(SR by Day) ) 탭에 있는 IBSheet OnPopupClick 이벤트
	  * @param {ibsheet}	sheetObj 	IBSheet Object
	  * @param {int}	row 		IBSheet Object Row Index
	  * @param {int}	col 		IBSheet Object Column Index
	  * @return
	  */    
    function t4sheet1_OnPopupClick(sheetObj,row,col){
        var formObj = document.form;
        if (sheetObj.ColSaveName(col) == "n3pty_flg"){
			if (sheetObj.CellValue(row,'n3pty_flg')=='Y'){
				var url_str = 'ESD_TES_9253Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='+sheetObj.CellValue(row,'tml_so_dtl_seq');
				url_str = url_str + '&inv_no='+formObj.inv_no.value;
				window.showModalDialog(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;");
			}
        }
	}

	 /**
	  * 다섯번째( Cost Calc.(SR by Pool) ) 탭에 있는 IBSheet OnPopupClick 이벤트
	  * @param {ibsheet}	sheetObj 	IBSheet Object
	  * @param {int}	row 		IBSheet Object Row Index
	  * @param {int}	col 		IBSheet Object Column Index
	  * @return
	  */       
    function t5sheet1_OnPopupClick(sheetObj,row,col){
        var formObj = document.form;
        if (sheetObj.ColSaveName(col) == "n3pty_flg"){
			if (sheetObj.CellValue(row,'n3pty_flg')=='Y'){
				var url_str = 'ESD_TES_9253Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='+sheetObj.CellValue(row,'tml_so_dtl_seq');
				url_str = url_str + '&inv_no='+formObj.inv_no.value;
				window.showModalDialog(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;");
			}
		}
	}

    
 	/**
 	 * IBTab Object를 배열로 등록
 	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 	 * 배열은 소스 상단에 정의
 	 * @param {int} tab_obj			Tab Object
 	 * @return
    */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

     /**
 	    * Tab 기본 항목 설정
 	    * @param {tab}		tabObj		tab
 	    * @param {int}	tabNo		tab index
 	    * @return
 	    */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "  Coincidence  " , -1 );
                    InsertTab( cnt++ , "  Discrepancy  " , -1 );
                    InsertTab( cnt++ , "Cost Calc.(TMNL)" , -1 );
                    InsertTab( cnt++ , "Cost Calc.(SR by Day)" , -1 );
                    InsertTab( cnt++ , "Cost Calc.(SR by Pool)" , -1 );

                }
             break;

         }
    }

 	/**
 	 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 	 * @param {tab}			tabObj	선택된 탭
 	 * @param {int}		nItem	선택된 탭 index
 	 * @return
 	 */
    function tab1_OnChange(tabObj , nItem)
    {
    	var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	// --------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	// ------------------------------------------------------//
    	beforetab= nItem;

    }
    
    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} formObj		Form Object
	 * @param {int} sAction			실행할 액션 구분 값
	 * @return
	 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(formObj.iPage)) {
//                return false;
// 				}
        }

        return true;
    }

	/**
	 * vander code 값에 따라 vndr_seq_hidden 와 is_valid_vndr_seq 값 설정하고 유효성 체크함수 호출한다.
	 * @return
	 */
	function validateVndrSeq() {

		var formObj = document.form;
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}

	/**
	 * Vender Code 유효성 체크
	 * @return
	 */
	function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					formObj.ida_gst_rgst_ste.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.ida_gst_rgst_no.value = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
					formObj.ida_ste_cd.value = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
					formObj.ida_ste_nm.value = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';

					// formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					ComShowMessage(ComGetMsg('TES24006','VNDR Code')); // ComShowMessage('유효하지
																		// 않은
																		// VendorCode입니다.');
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				// formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				ComShowMessage(ComGetMsg('TES24006','VNDR Code')); // ComShowMessage('유효하지
																	// 않은
																	// VendorCode입니다.');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			// formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			ComShowMessage(ComGetMsg('TES24006','VNDR Code')); // ComShowMessage('유효하지
																// 않은
																// VendorCode입니다.');
		}
	}

	/**
	 * 조회 후 첫번째(Coincidence) 탭의 Sheet 에 데이터가 채워지면 Sheet 하단에 통계항목을 계산하여 설정한ㄴ다.
	 * @return
	 */
	function setCoinShtStat(){

		var formObj = document.form;

		// 초기화
		formObj.sht_01_ttl_box.value	= 0;
		formObj.sht_01_full.value		= 0;
		formObj.sht_01_mt.value			= 0;
		// formObj.sht_01_ts_bkg.value = 0;
		formObj.sht_01_ts_same_yard.value = 0;
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

		// 계산하여 설정-----------------------------------------------------------
		formObj.sht_01_ttl_box.value = sheetObjects[0].RowCount; // 총수


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
					//ComShowMessage(e); // 여길 그냥 통과해야 한다..
				}
			}
			if (sheetObjects[0].CellValue(i,"locl_ts_ind_cd")!=undefined && sheetObjects[0].CellValue(i,"locl_ts_ind_cd")!=null && sheetObjects[0].CellValue(i,"locl_ts_ind_cd").trim()!='')
			{
				try {
					with (formObj) {
						if (sheetObjects[0].CellValue(i,"locl_ts_ind_cd")=='T'){
							sht_01_ts_bkg.value++;
						}
					}
				} catch(e){
					//ComShowMessage(e); // 여길 그냥 통과해야 한다..
				}
			}
			if (sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd")!=undefined && sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd")!=null && sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd").trim()!='')
			{
				try {
					with (formObj) {
						if (sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd")=='T'){
							sht_01_ts_same_yard.value++;
						}
					}
				} catch(e){
					//ComShowMessage(e); // 여길 그냥 통과해야 한다..
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
					//ComShowMessage(e); // 오류시에도 여길 그냥 통과해야 한다..
				}
			}
		}

	}
	
	/**
	 * Retrieve 버튼을 클릭 시 처리되는 업무
	 * @param REMOVE_YN
	 * @return
	 */
	function retrieve(REMOVE_YN){
		try {
			if (fnChkSearchForm()) {
				
				var formObj = document.form;
				
				if (REMOVE_YN!=undefined && REMOVE_YN.trim()=='Y'){
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					sheetObjects[4].RemoveAll();
					sheetObjects[5].RemoveAll();
				}

				//main hidden sheet - 기본정보조회
				doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH);
				
			}
		} catch(e){
		}
	}

	/**
	 * (Retrieve button) 조회 시 필수 입력항목 체크 
	 * @return
	 */
	function fnChkSearchForm(){

		var formObj = document.form;

		if (formObj.inv_no.value==null || formObj.inv_no.value=='') {
			ComShowMessage(ComGetMsg('TES21026','Inv No'));
			formObj.inv_no.focus();
			return false;
		} else if (formObj.vndr_seq.value==null || formObj.vndr_seq.value=='') {
			ComShowMessage(ComGetMsg('TES23007','VNDR Code'));
			formObj.vndr_seq.focus();
			return false;
		}

		return true;
	}

	 /**
	  * 조회가 완료되고 발생하는 이벤트
	  * @param {sheet}	main_hidden		ibsheet
	  * @param {string}	ErrMsg			error message
	  * @return
	  */
	function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {

		var formObj = document.form;

		if (main_hidden.RowCount == 1) {

			if (main_hidden.CellValue(1,'tml_inv_tp_cd')!='OF') {
				formObj.reset();

				if (main_hidden.CellValue(1,'tml_inv_tp_cd')=='TM'){
					ComShowMessage(ComGetMsg('TES40050','Terminal invoice')); // ComShowMessage('Terminal
																				// invoice에
																				// 등록된
																				// data
																				// 입니다.');
				} else if (main_hidden.CellValue(1,'tml_inv_tp_cd')=='ST'){
					ComShowMessage(ComGetMsg('TES40050','Storage invoice')); // ComShowMessage('Storage
																				// invoice에
																				// 등록된
																				// data
																				// 입니다');
				} else if (main_hidden.CellValue(1,'tml_inv_tp_cd')=='ON'){
					ComShowMessage(ComGetMsg('TES40050','On-dock invoice')); // ComShowMessage('On-dock
																				// invoice에
																				// 등록된
																				// data
																				// 입니다');
				// } else if (main_hidden.CellValue(1,'tml_inv_tp_cd')=='OF'){
				} else {
					ComShowMessage(ComGetMsg('TES21034')); // ComShowMessage('[1]저장된
															// data가 없습니다.');
				}
				return;
			}
			
			
			formObj.no_ofc_cd.value = sheetObjects[5].CellValue(1,'inv_ofc_cd');
			formObj.no_yd_cd.value  = sheetObjects[5].CellValue(1,'yd_cd');
        	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
			
			confirm_done = false;
			save_conf_01 = true; // 상위 기본 정보 저장이 확인된 경우만 활성화
//			setHdSheet2Form(); // 검색된 sheet의 data로 form을 채운다.
			
	        if (main_hidden.CellValue(1, 'ap_rvs_cng_flg')=='Y'){
	        	formObj.ap_rvs_cng_flg.checked = true;
	        } else {
	        	formObj.ap_rvs_cng_flg.checked = false;
	        }

		} else if (main_hidden.RowCount > 1) {
			ComShowMessage(ComGetMsg('TES24043')); // ComShowMessage('[ERR]
													// 복수개의 header data가
													// 조회되었습니다. 관리자에게 문의하십시오.');
			// disablePage();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();


			return false;
		} else {

			formObj.reset();
			ComShowMessage(ComGetMsg('TES21034')); // ComShowMessage('[2] 저장된
													// data가 없습니다.');
			return false;
		}
	}

	/**
	 * 검색된 main hidden sheet의 data로 form을 채운다.
	 * @param MODE
	 * @return
	 */
	function setHdSheet2Form(MODE){
		var formObj = document.form;
		if (sheetObjects[5].RowCount == 1){
			formObj.tml_so_ofc_cty_cd.value	= sheetObjects[5].CellValue(1, 'tml_so_ofc_cty_cd');
			formObj.tml_so_seq.value		= sheetObjects[5].CellValue(1, 'tml_so_seq');

			formObj.tml_cost_grp_cd.value	= sheetObjects[5].CellValue(1, 'tml_cost_grp_cd');
			formObj.inv_ofc_cd.value 		= sheetObjects[5].CellValue(1, 'inv_ofc_cd');
			formObj.cost_ofc_cd.value  	= sheetObjects[5].CellValue(1, 'cost_ofc_cd');
			formObj.vndr_seq.value			= tes_lpad(sheetObjects[5].CellValue(1, 'vndr_seq'),6,'0'); // 2008-01
																										// lpad추가;
			formObj.yd_cd.value					= sheetObjects[5].CellValue(1, 'yd_cd');
			formObj.yd_nm.value					= sheetObjects[5].CellValue(1, 'yd_nm');
			formObj.fm_prd_dt.value 		= sheetObjects[5].CellValue(1, 'fm_prd_dt');
			formObj.to_prd_dt.value			= sheetObjects[5].CellValue(1, 'to_prd_dt');
			formObj.inv_no.value				= sheetObjects[5].CellValue(1, 'inv_no');
			formObj.iss_dt.value				= sheetObjects[5].CellValue(1, 'iss_dt');

			formObj.ttl_inv_amt.value		= tes_chkAmtFmt(sheetObjects[5].CellValue(1,'ttl_inv_amt'),sheetObjects[5].CellValue(1,'curr_cd'));
			formObj.whld_tax_amt.value		= tes_chkAmtFmt(sheetObjects[5].CellValue(1,'whld_tax_amt'),sheetObjects[5].CellValue(1,'curr_cd'));
			

			// formObj.hld_rmk.value = sheetObjects[5].CellValue(1, 'hld_rmk');
			
			formObj.hld_flg.value	= sheetObjects[5].CellValue(1, 'hld_flg');
			formObj.hld_rmk.value	= sheetObjects[5].CellValue(1, 'hld_rmk');
			
			if (sheetObjects[5].CellValue(1, 'hld_flg')!=undefined && sheetObjects[5].CellValue(1, 'hld_flg')=='Y') {
				formObj.hld_flg.checked = true;
			} else {
				formObj.hld_flg.checked = false;
			}

			
			formObj.pay_due_dt.value		= sheetObjects[5].CellValue(1, 'pay_due_dt');
			formObj.pay_flg.value				= sheetObjects[5].CellValue(1, 'pay_flg');
			
			formObj.rcv_dt.value				= sheetObjects[5].CellValue(1, 'rcv_dt');
			
			formObj.curr_cd.value				= sheetObjects[5].CellValue(1, 'curr_cd');
			// formObj.tml_inv_tp_cd.value = sheetObjects[5].CellValue(1,
			// 'tml_inv_tp_cd');
			var inv_sts_cd = sheetObjects[5].CellValue(1, 'tml_inv_sts_cd');
			if (inv_sts_cd!=undefined && inv_sts_cd=='R'){inv_sts_cd = 'Received'
			} else if (inv_sts_cd!=undefined && inv_sts_cd=='C'){inv_sts_cd = 'Confirmed'
			} else if (inv_sts_cd!=undefined && inv_sts_cd=='P'){inv_sts_cd = 'AP Interfaced'
			} else if (inv_sts_cd!=undefined && inv_sts_cd=='A'){inv_sts_cd = 'Approval Request'
			} else if (inv_sts_cd!=undefined && inv_sts_cd=='D'){inv_sts_cd = 'Paid'
			}
			formObj.tml_inv_sts_cd.value 		= inv_sts_cd;
			formObj.tml_inv_sts_cd.title 		= tes_getInvStsFullNm(inv_sts_cd);

			var rjct_sts_cd = sheetObjects[5].CellValue(1, 'tml_inv_rjct_sts_cd');
			formObj.tml_inv_rjct_sts_cd.value	= (rjct_sts_cd!=null&&rjct_sts_cd.trim()!=''?rjct_sts_cd:'NL'); // 기본으로
																												// NL(정상)으로
																												// 설정
			formObj.tml_inv_rjct_sts_cd.title	= tes_getInvRejectStsFullNm(rjct_sts_cd!=null&&rjct_sts_cd.trim()!=''?rjct_sts_cd:'NL');
			// formObj.inv_rjct_rmk.value = sheetObjects[5].CellValue(1,
			// 'inv_rjct_rmk');

			// radio button 설정 관련....
			// var tml_calc_ind_cd = sheetObjects[5].CellValue(1,
			// 'tml_calc_ind_cd');
			// var sto_dys_ind_cd = sheetObjects[5].CellValue(1,
			// 'sto_dys_ind_cd');
			// ComShowMessage('tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' +
			// 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');

			// formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
			// formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;

			//India GST Amount
			formObj.dbt_note_no.value			= sheetObjects[5].CellValue(1, 'dbt_note_no' );
	        formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_cgst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));
	        formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_sgst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));
	        formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_igst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));
	        formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_ugst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));

		} else if (sheetObjects[5].RowCount > 0) {
			ComShowMessage(ComGetMsg('TES21035')); // ComShowMessage('ERR');
			return false;
		} else {
			ComShowMessage(ComGetMsg('TES21035')); // ComShowMessage('ERR2');
			return false;
		}
	}

	 /**
	  * 
	  * @return
	  */
//	function setCalcCostCond() {
//
////		ComShowMessage('setCalcCostCond!');
//
//		var formObj = document.form;
//
//		var tml_cost_grp_cd	= '';
//		var tml_calc_ind_cd	= '';
//		var sto_dys_ind_cd	= '';
//
//		if (formObj.TMNL.checked == true) {
//			tml_cost_grp_cd = 'TM';
//			if (formObj.Storage[0].checked == true) {
//				tml_cost_grp_cd = 'TD';
//			} else if (formObj.Storage[1].checked == true) {
//				tml_cost_grp_cd = 'TP';
//			}
//		} else {
//			tml_cost_grp_cd = '';
//			if (formObj.Storage[0].checked == true) {
//				tml_cost_grp_cd = 'SD';
//			} else if (formObj.Storage[1].checked == true) {
//				tml_cost_grp_cd = 'SP';
//			} else {
//				tml_cost_grp_cd = '';
//			}
//		}
////		if (formObj.CostCalcMethod[0].disabled == true && formObj.CostCalcMethod[1].disabled == true) {
////			tml_calc_ind_cd = '';
//// } else {
//			if (formObj.CostCalcMethod[0].checked == true) {
//				tml_calc_ind_cd = 'TP';
//			} else if (formObj.CostCalcMethod[1].checked == true) {
//				tml_calc_ind_cd = 'SP';
//			} else {
//				tml_calc_ind_cd = '';
//			}
////		}
////		if (formObj.StorageFD[0].disabled == true && formObj.StorageFD[1].disabled == true) {
////			sto_dys_ind_cd = '';
//// } else {
//			if (formObj.StorageFD[0].checked == true) {
//				sto_dys_ind_cd = 'IO';
//			} else if (formObj.StorageFD[1].checked == true) {
//				sto_dys_ind_cd = 'DT';
//			} else {
//				sto_dys_ind_cd = '';
//			}
////		}
//
//		formObj.tml_inv_tp_cd.value		= 'OF';
//		// ComShowMessage('[function setCalcCostCond]\n\n
//		// tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' +
//		// 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');
//		formObj.tml_cost_grp_cd.value	= tml_cost_grp_cd;
//		formObj.tml_calc_ind_cd.value	= tml_calc_ind_cd;
//		formObj.sto_dys_ind_cd.value	= sto_dys_ind_cd;
//	}

	/**
	 * Cost Group에서 선택된 조건에 따라 저장할 sheet의 idx 배열을 반환
	 * @param ROWCOUNT_CHK_YN
	 * @return
	 */
	function getCostCalcShtToSaveArr(ROWCOUNT_CHK_YN) {

		if (sheetObjects[5].RowCount == 0){
			return false;
		}

		var arr_sht_to_go = new Array();
		var tml_cost_grp_cd	= sheetObjects[5].CellValue(1, 'tml_cost_grp_cd');
		var tml_calc_ind_cd	= sheetObjects[5].CellValue(1, 'tml_calc_ind_cd');
		var sto_dys_ind_cd	= sheetObjects[5].CellValue(1, 'sto_dys_ind_cd');

		if (tml_cost_grp_cd!=undefined && tml_cost_grp_cd.trim().length == 2) {
			if (tml_cost_grp_cd.trim().substring(0,1) == 'T') { //TMNL
				if (ROWCOUNT_CHK_YN!=undefined && ROWCOUNT_CHK_YN.trim()=='Y'){
					if (sheetObjects[2].RowCount > 0 && sheetObjects[2].IsDataModified){
						arr_sht_to_go[arr_sht_to_go.length] = 2;
					}
				} else {
					arr_sht_to_go[arr_sht_to_go.length] = 2;
				}
			}
			if (tml_cost_grp_cd.trim().substring(1,2) == 'D') { //By Day
				if (ROWCOUNT_CHK_YN!=undefined && ROWCOUNT_CHK_YN.trim()=='Y'){
					if (sheetObjects[3].RowCount > 0 && sheetObjects[3].IsDataModified){
						arr_sht_to_go[arr_sht_to_go.length] = 3;
					}
				} else {
					arr_sht_to_go[arr_sht_to_go.length] = 3;
				}
			} else if (tml_cost_grp_cd.trim().substring(1,2) == 'P') { //By Pool
				if (ROWCOUNT_CHK_YN!=undefined && ROWCOUNT_CHK_YN.trim()=='Y'){
					if (sheetObjects[4].RowCount > 0 && sheetObjects[4].IsDataModified){
						arr_sht_to_go[arr_sht_to_go.length] = 4;
					}
				} else {
					arr_sht_to_go[arr_sht_to_go.length] = 4;
				}
			}
		} else {
			return false;
		}

		return arr_sht_to_go;
	}

	 /**
	  * Cost Group 에 따른 Calculated AMT 계산
	  * @param sheetObj
	  * @param colnm
	  * @return
	  */
	function getShtTotCalcAmt(sheetObj, colnm) {

		var tot_inv_amt_val = 0;

		for (var i=1; i<sheetObj.Rows; i++) // 제목은 제외
		{
			if (sheetObj.RowSumable(i) && sheetObj.CellValue(i,colnm)!=null && sheetObj.CellValue(i,colnm).trim()!='' &&
				sheetObj.CellValue(i,colnm)!=undefined && !isNaN(parseFloat(sheetObj.CellValue(i,colnm))) && sheetObj.RowStatus(i)!='D')
			{
				tot_inv_amt_val = tot_inv_amt_val + parseFloat(sheetObj.CellValue(i,colnm));
			}
		}

		tot_inv_amt_val *= 100;
		tot_inv_amt_val = new String(tot_inv_amt_val);
		var tmp = tot_inv_amt_val.split('.');
		if (tmp.length > 2){return '';}
		tmp[0] /= 100;
		var tmp2 = new String(tmp[0]).split('.');
		if (tmp2.length > 2){return '';}
		tot_inv_amt_val = tes_addComma(tmp2[0]) + (tmp2[1]!=undefined&&tmp2[1]!=null&&tmp2[1]!=''?'.'+tmp2[1]:'');

		return tot_inv_amt_val;
	}

	/**
	 * 첫번째(Coincidence) 탭의 sheet OnMouseMove Event
	 * @param {ibsheet}	t1sheet1	Coincidence) 탭의 sheet
	 * @param {int}	Button	마우스버튼 방향, 1:왼쪽, 2:오른쪽
	 * @param {int}	Shift	해당 셀의 Column Index
	 * @param {Long}	X	X좌표
	 * @param {Long}	Y	Y좌표
	 * @return
	 */
	function t1sheet1_OnMouseMove(t1sheet1, Button, Shift, X, Y){
		var row = t1sheet1.MouseRow;
		var col = t1sheet1.MouseCol;
		if (t1sheet1.ColSaveName(col) == "dscr_ind_cd" && row >= 1 && t1sheet1.CellValue(row,"dscr_ind_cd")!=null && t1sheet1.CellValue(row,"dscr_ind_cd")!=''){
			//t1sheet1.MouseToolTipText = tes_getInvVerifyResultFullNm(t1sheet1.CellValue(row,"dscr_ind_cd")); 
			t1sheet1.ToolTipText(row,col) = tes_getInvVerifyResultFullNm(t1sheet1.CellValue(row,"dscr_ind_cd")); 
		}
	}

	/**
	 * btn_retrieve 이벤트 실행시 t1sheet1 sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t1sheet1	Coincidence sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg){
		// 변환문자를 특수 문자로 치환. (2010-04-28)
        for (var i = 1; i <= t1sheet1.RowCount; i++)
		{
            t1sheet1.CellValue2(i, "cntr_rmk") = ComToString( t1sheet1.CellValue(i, "cntr_rmk") );
		}

		setCoinShtStat();
		setTooltip(t1sheet1,'cntr_rmk');
	}

	/**
	 * btn_retrieve 이벤트 실행시 t2sheet1 sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t2sheet1	Discrepancy sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg){
		// 변환문자를 특수 문자로 치환. (2010-04-28)
        for (var i = 1; i <= t2sheet1.RowCount; i++)
		{
        	t2sheet1.CellValue2(i, "cntr_rmk") = ComToString( t2sheet1.CellValue(i, "cntr_rmk") );
		}
		setTooltip(t2sheet1,'cntr_rmk');
	}

	/**
	 * btn_retrieve 이벤트 실행시 t3sheet1 sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t4sheet1	Cost Calc.(TMNL) sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */
	function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg){
		
		// 변환문자를 특수 문자로 치환. (2010-04-23)
        for (var i = 1; i <= t3sheet1.RowCount; i++)
		{
        	t3sheet1.CellValue2(i, "calc_rmk") = ComToString( t3sheet1.CellValue(i, "calc_rmk") );
		}
        
		if (t3sheet1.RowCount > 0){
			document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1,'inv_amt');
		}
		setTooltip(t3sheet1,'calc_rmk');
	}

	/**
	 * btn_retrieve 이벤트 실행시 t4sheet1 sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by Day) sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg){
		// 변환문자를 특수 문자로 치환. (2010-04-23)
        for (var i = 1; i <= t4sheet1.RowCount; i++)
		{
        	t4sheet1.CellValue2(i, "calc_rmk") = ComToString( t4sheet1.CellValue(i, "calc_rmk") );
		}

        if (t4sheet1.RowCount > 0){
			document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(t4sheet1,'inv_amt');
		}
		setTooltip(t4sheet1,'calc_rmk');
	}

	/**
	 * 조회가 완료되고 발생하는 이벤트
	 * @param t5sheet1
	 * @param ErrMsg
	 * @return
	 */
	function t5sheet1_OnSearchEnd(t5sheet1, ErrMsg){
		// 변환문자를 특수 문자로 치환. (2010-04-23)
        for (var i = 1; i <= t5sheet1.RowCount; i++)
		{
        	t5sheet1.CellValue2(i, "calc_rmk") = ComToString( t5sheet1.CellValue(i, "calc_rmk") );
		}

        if (t5sheet1.RowCount > 0){
			document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(t5sheet1,'inv_amt');
		}
		setTooltip(t5sheet1,'calc_rmk');
	}

	 /**
	  * vender name 세팅
	  * @param {Array}	rowArray	vender 정보가 담긴 array	
	  * @return
	  */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		document.all.vndr_seq.value = colArray[2];
		document.all.vndr_seq_name.value = colArray[4];
	}

    function setFormValue(){
    	var checkInv = "N";
    	var checkVndr = "N";
    	var formObj = document.form;
    	  
    	if(formObj.inv_no_tmp.value == sheetObjects[5].CellValue(1, 'inv_no'))checkInv = "Y";
    	if(vndr_seq == tes_lpad(sheetObjects[5].CellValue(1, 'vndr_seq'),6,'0'))checkVndr = "Y";
    	
    	if(formObj.auth_ofc_cd.value.trim()=="Y"){
			setHdSheet2Form(); // 검색된 sheet의 data로 form을 채운다.
         	
			if (sheetObjects[5].RowCount == 1 && sheetObjects[5].CellValue(1,'tml_inv_tp_cd')=='OF') {
				doActionIBSheetAllSheets(sheetObjects[0],formObj,IBSEARCH);
			}
			
     	}else if(document.form.flag.value == "Y" && checkInv == 'Y' && checkVndr == 'Y'){

			setHdSheet2Form(); // 검색된 sheet의 data로 form을 채운다.
         	
			if (sheetObjects[5].RowCount == 1 && sheetObjects[5].CellValue(1,'tml_inv_tp_cd')=='OF') {
				doActionIBSheetAllSheets(sheetObjects[0],formObj,IBSEARCH);
			}
     	
     	}else{
     		ComShowMessage(ComGetMsg('TES21051'));
     		formObj.auth_ofc_cd.value = "";
            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
            sheetObjects[3].RemoveAll();
            sheetObjects[4].RemoveAll();
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
     * [Error Inv. No.]유효성 체크
     * @return
     */
   function validateErrInvNo() {
   	var formObj = document.form;
   	formObj.err_inv_no.value = formObj.err_inv_no.value.trim();
   	if (formObj.err_inv_no.value != null
   			&& formObj.err_inv_no.value.trim() != '') {
   		tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
   	}
   }
    
    /**
     * [Error Inv. No.] 유효성 여부에 따른 처리.
     * @return
     */
   function checkValidErrInvNo() {
   	var formObj = document.form;
   	// ComShowMessage('checkValidErrInvNo -
   	// is_valid_err_inv_no:'+formObj.is_valid_err_inv_no.value);
   	if (formObj.is_valid_err_inv_no.value != undefined
   			&& formObj.is_valid_err_inv_no.value != null
   			&& formObj.is_valid_err_inv_no.value.trim() == 'Y') {
   		// ComShowMessage('ERR_INV_NO 오케바리');
   	} else {
   		formObj.is_valid_err_inv_no.value = '';
   		ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO')); // ComShowMessage('존재하지 않는 ERR INV.NO입니다.');
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