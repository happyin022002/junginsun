/**
 * 
 * @fileoverview MR Storage Container List 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_0019 : MR Storage Container List 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * 2011.08.17 박정일 [E-mail요청] [TES] special character, characterSet problem
 * 2012.02.27 박성호 [CHM-201216241]미국 서부지역 조직 변경 관련 PHXSCG의 조회권한 확대 보완사항 테스트
 * 2015-03-05 김영신 [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
 */
function ESD_TES_0019() {
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
         var sheetObject  = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];
         var sheetObject4 = sheetObjects[4];


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
        	                ComShowMessage(ComGetMsg('TES21501')); //ComShowMessage('Pleas Input Invoice No & Vendor Code!');
        	                return;
        	            }else{
        	                ComShowMessage(ComGetMsg('TES21502')); //ComShowMessage('Please Input Invoice No!');
        	                return;
        	            }
        	        }else{
        	            if(tmp_vndr_seq == null || tmp_vndr_seq == ''){
        	                ComShowMessage(ComGetMsg('TES21503')); //ComShowMessage('Please Input Vendor Code!');
        	                return;
        	            }
        	        }
        	        if(tmp_vndr_seq.length < 6){
        	            ComShowMessage(ComGetMsg('TES21504')); //ComShowMessage('Invaid Vendor Code!');
        	            formObject.vndr_seq.value ='';
        	            formObject.vndr_seq_name.value = '';
        	            init();
        	            formObject.vndr_seq.focus();
        	            return;
        	        }

/*        	        formObject.reset();
        	        sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            sheetObject2.RemoveAll();
    	            sheetObject3.RemoveAll();
    	            sheetObject4.RemoveAll();*/

    	            formObject.inv_no.value = tmp_inv_no;
        	        formObject.vndr_seq.value = tmp_vndr_seq;
        	        formObject.vndr_seq_name.value = tmp_vndr_nm;
        	        doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
        	        
//        	        if(sheetObject4.RowCount >0 && formObject.yd_cd.value !=''){
//        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
//        	        }
        	        
        	        break;

        	    case "btn_new":
    	            formObject.reset();
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            sheetObject2.RemoveAll();
    	            sheetObject3.RemoveAll();
    	            sheetObject4.RemoveAll();
        	        break;

                case "btns_remarks":

                   	ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 'popup_remarks', 300,150, true);
					break;

                case "btn_vndr":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_0C1";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3)

                         // radio PopUp
                         if(chkStr == "1,0") {
                             ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVender', dispaly);
                        } else {
                             ComShowMessage(ComGetMsg('TES21906')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                             return;
                        }
          	         break;
          	    case "btng_totalamount" :
          	        //var url_str = "ESD_TES_906Popup.screen?tml_inv_tp_cd="+formObject.tml_inv_tp_cd.value+"&tml_so_ofc_cty_cd="+formObject.tml_so_ofc_cty_cd.value+"&tml_so_seq="+formObject.tml_so_seq.value;
					var url_str = "ESD_TES_9050Popup.screen?tml_so_ofc_cty_cd="+formObject.tml_so_ofc_cty_cd.value+"&tml_so_seq="+formObject.tml_so_seq.value;
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
					
			        sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = false;	//show
			        sheetObjects[3].ColHidden("lgs_cost_abbr_nm") = false;	//show
					break;
				
				case "btng_costcodedeschide":
					document.all.CostCodeDescShow01.style.display = "inline";
					document.all.CostCodeDescHide01.style.display = "none";
					document.all.CostCodeDescShow02.style.display = "inline";
					document.all.CostCodeDescHide02.style.display = "none";
					
					sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = true;	//hide
		        	sheetObjects[3].ColHidden("lgs_cost_abbr_nm") = true;	//hide
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];
        var sheetObject4 = sheetObjects[4];
        var formObject = document.form;
        
        if(!ComIsNull(formObject.inv_no_tmp.value)){
            formObject.inv_no.value =  formObject.inv_no_tmp.value;
            formObject.vndr_seq.value = vndr_seq;
            chkInput(formObject.vndr_seq);

            doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
            
//            if(sheetObject4.RowCount >0 && formObject.yd_cd.value !=''){
//                doActionIBSheet(sheetObject,formObject,IBSEARCH);
//            }
        }

		document.form.inv_no.focus();
		
        document.all.CostCodeDescHide01.style.display = "inline";
        document.all.CostCodeDescHide02.style.display = "inline";
        
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
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "Seq.|CNTR No.|Type/Size|Gate In|Gate Out|Stay Days|I/O|F/M|T/S|DG|B/B|Verify\nResult|Remarks|STS";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                   //데이터속성      [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,         30,    daCenter,  false,    "",                 false,          "",       dfNone,   		0,     false,      false, 6);
                    InitDataProperty(0, cnt++ , dtData,        80,    daCenter,  false,    "cntr_no",          false,          "",       dfNone,   		0,     false,      false, 3);
                    InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false,    "cntr_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false, 1);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter , false,    "inv_gate_in_dt",   false,          "",       dfUserFormat2, 0,     false,      false, 9);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter , false,    "inv_gate_out_dt",  false,          "",       dfUserFormat2, 0,     false,      false, 9);
                    
                    //[CHM-201539024]Invoice Summary에서 "View"로 들어간 Storage Invoice 화면 Coincidence 에서 Stay Over Days 숨김 (조아영D 2015.11.20)
                    //InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "inv_stay_dys",     false,          "",       dfNone,   		0,     false,      false, 1);
                    InitDataProperty(0, cnt++ , dtHidden,      60,    daCenter,  false,    "inv_stay_dys",     false,          "",       dfNone,   		0,     false,      false, 1);
                    InitDataProperty(0, cnt++ , dtData,        30,    daCenter , false,    "io_bnd_cd",        false,          "",       dfNone,   	    0,     false,      false, 9);
                    InitDataProperty(0, cnt++ , dtData,        30,    daCenter , false,    "cntr_sty_cd",      false,          "",       dfNone, 		0,     false,      false, 9);
                    InitDataProperty(0, cnt++ , dtData,        30,    daCenter,  false,    "locl_ts_ind_cd",   false,          "",       dfNone,   		0,     false,      false, 6);
                    InitDataProperty(0, cnt++ , dtData,        30,    daCenter,  false,    "dcgo_clss_cd",     false,          "",       dfNone,   		0,     false,      false, 1);

                    InitDataProperty(0, cnt++ , dtData,        30,    daCenter , false,    "bb_cgo_flg",       false,          "",       dfNone,   	    0,     false,      false, 9);
                    InitDataProperty(0, cnt++ , dtData,        50,    daCenter , false,    "dscr_ind_cd", false,          "",       dfNone,   	    0,     false,      true, 9);
                    InitDataProperty(0, cnt++ , dtData,        50,    daLeft , false,    "cntr_rmk",         false,          "",       dfNone, 		0,     false,      false, 9);

                    InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:" );

                }
                break;
             case 2:   //t2sheet1 init
                with (sheetObj) {

                 style.height=GetSheetHeight(15);
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1 , 5, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(12, 1, 0, true);//13,3,0,true

             	// 해더에서 처리할 수 있는 각종 기능을 설정한다
             	InitHeadMode(true, true, false, true, false,false);

                 var HeadTitle0 = "Discrepancy Type|Seq.|CNTR No.|Type|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O|Stay Days|Stay Days|SD|Remarks";
                 var HeadTitle1 = "Discrepancy Type|Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle0, true);
                 InitHeadRow(1, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,   DATAALIGN, COLMERGE,      SAVENAME,       KEYFIELD, CALCULOGIC,     DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtCombo,     150,    daLeft,    true,     "dscr_ind_cd",       false,          "",       dfNone,   		  0,     false,      false);
                 InitDataProperty(0, cnt++ , dtDataSeq,    30,    daCenter,  false,     "",                  false,          "",       dfNone,          0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,      130,    daLeft,    false,    "cntr_no",           false,          "",       dfNone,   		  0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  false,    "cntr_tpsz_cd",      false,          "",       dfNone,   		  0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  false,    "cntr_sty_cd",      false,          "",       dfNone,   		  0,     false,      false);

                 InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "mvmt_gate_in_dt",   false,          "",       dfUserFormat2,   0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "inv_gate_in_dt",    false,          "",       dfUserFormat2,   0,     false,      false);

                 InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,    "gate_in_td_dys",    false,          "",       dfNone,   		  0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "mvmt_gate_out_dt",  false,          "",       dfUserFormat2,   0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       95,    daCenter,  false,    "inv_gate_out_dt",   false,          "",       dfUserFormat2,   0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,    "gate_out_td_dys",   false,          "",       dfNone, 		  0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,       50,    daLeft  ,  false,    "cntr_rmk",          false,          "",       dfNone, 	      0,     false,      false);

                 HeadRowHeight = 10;

                 InitDataCombo(0 , "dscr_ind_cd", "Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date|Another Movement", "DD|DP|HO|PD|NH|DB|DF|AM");
				InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:");
				InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:");
				InitUserFormat2(0, "mvmt_gate_in_dt", "####-##-## ##:##", "-|:");
				InitUserFormat2(0, "mvmt_gate_out_dt", "####-##-## ##:##", "-|:");

                }
                break;

             case 3:   //t3sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(15);
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
                    	InitRowInfo( 2, 1 , 5, 100);
                    } else {
                    	InitRowInfo( 1, 1 , 5, 100);
                    }

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(33, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods\nServices|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party";
              
                    if(ida_ofc_cd == 'Y'){
                        var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods\nServices|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party";

                    }
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    if(ida_ofc_cd == 'Y'){
                    	InitHeadRow(1, HeadTitle1, true);
                    }

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCombo,      150,    daLeft,    true,     "calc_tp_cd",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,    true,     "lgs_cost_cd",     false,          "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      200,   daLeft,    true,     "lgs_cost_abbr_nm",     false,          "",       dfNone,          0,     false,      false);
					if(ida_ofc_cd == 'Y'){
                    	InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,     "ida_sac_cd"           ,       false,          "",       dfNone,    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCombo,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     true,       true);
                    } else {
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_sac_cd"           ,       false,          "",       dfNone,    0,     false,       false);
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     false,       false);
                    }					
					InitDataProperty(0, cnt++ , dtData,       80,    daLeft  ,  true,     "cntr_no",     false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,    "cntr_tpsz_cd",     false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,    "io_bnd_cd",     false,          "",       dfNone,         0,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_ind_cd",     false,          "",       dfNone,         0,     false,      false);
                    // manual input 비용 계산시 적용 년월 칼럼 추가 ( 4342. 01. 13 - 이경한 과장 요청 CSR )
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter ,  true,    "rev_yrmon",     false,          "",       dfDateYm,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       45,    daCenter,  true,    "stay_dys",     false,          "",       dfInteger,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       45,    daCenter,  true,    "free_dys",     false,          "",       dfInteger,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  true,    "pay_dys",     false,          "",       dfInteger,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  true,    "free_dy_xcld_dys",     false,          "",       dfInteger,         0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       35,    daCenter,  true,    "ovr_dys",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  true,    "vol_tr_ut_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daRight,  true,    "ctrt_rt",     false,          "",       dfFloat,        2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_xch_rt",     false,          "",       dfFloat,         5,     false,      false);

					InitDataProperty(0, cnt++ , dtData,       60,    daRight ,  true,    "inv_amt",     false,          "",       dfFloat,        2,     false,      false);
					if(ida_ofc_cd == 'Y'){
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_gst_rto"          ,       false,          "",       dfFloat,   2,     false,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_gst_amt"          ,       false,          "",       dfFloat,   2,     false,       true);
	                } else {
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_gst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_gst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);  
                    }
					
					InitDataProperty(0, cnt++ , dtData,       150,    daLeft  ,  true,    "calc_rmk",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtPopup,       15,    daLeft  ,  true,    "n3pty_flg",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     20,    daLeft,    true,     "tml_so_dtl_seq",     false,          "",       dfInteger,         0,     false,      false);

                    InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
					if(ida_ofc_cd == 'Y'){
                    	InitDataCombo(0 , "ida_pay_tp_cd"	     , "Goods|Services", "G|S");
                    }
             	}
                break;

             case 4:   //t4sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(15);
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
                    	InitRowInfo( 2, 1 , 5, 100);
                    } else {
                    	InitRowInfo( 1, 1 , 5, 100);
                    }

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(29, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party ";
                    if(ida_ofc_cd == 'Y'){
                        var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party ";
                   }
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    if(ida_ofc_cd == 'Y'){
                    	InitHeadRow(1, HeadTitle1, true);
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE,     SAVENAME,      KEYFIELD, CALCULOGIC,     DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCombo,      150,    daLeft,    true,      "calc_tp_cd",     false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "lgs_cost_cd",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       200,   daLeft,  true,     "lgs_cost_abbr_nm",     false,          "",       dfNone,          0,     false,      false);
                    if(ida_ofc_cd == 'Y'){
                    	InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,     "ida_sac_cd"           ,       false,          "",       dfNone,    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCombo,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     true,       true);
                    } else {
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_sac_cd"           ,       false,          "",       dfNone,    0,     false,       false);
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     false,       false);
                    }
                    
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter ,  true,    "wrk_dt",     false,          "",       dfDateYmd,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "stk_vol_qty",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_vol_qty",     false,          "",       dfInteger,   		0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "diff_vol_qty",     false,          "",       dfInteger,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       45,    daRight,  true,    "fp_teu_qty",     false,          "",       dfInteger,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       35,    daRight,  true,    "ovr_vol_qty",     false,          "",       dfInteger,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "vol_tr_ut_cd",     false,          "",       dfNone,   		1,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight ,  true,    "ctrt_rt",     false,          "",       dfFloat,        2,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",     false,          "",       dfNone,         0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,    "inv_xch_rt",     false,          "",       dfFloat,         5,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,   true,    "inv_amt",     false,          "",       dfFloat,   		2,     false,      false);
                    
					if(ida_ofc_cd == 'Y'){
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_gst_rto"          ,       false,          "",       dfFloat,   2,     false,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_gst_amt"          ,       false,          "",       dfFloat,   2,     false,       true);
	                } else {
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_gst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_gst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);  
                    }			
					InitDataProperty(0, cnt++ , dtData,       200,    daLeft,   true,    "calc_rmk",     false,          "",       dfNone,   		0,     true,      true);
					InitDataProperty(0, cnt++ , dtPopup,       30,    daLeft,   true,    "n3pty_flg",     false,          "",       dfNone,   		0,     true,      true);

					InitDataProperty(0, cnt++ , dtHidden,     20,    daLeft,    true,     "tml_so_dtl_seq",     false,          "",       dfInteger,         0,     false,      false);

					InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
                
					if(ida_ofc_cd == 'Y'){
                    	InitDataCombo(0 , "ida_pay_tp_cd"	     , "Goods|Services", "G|S");
                    }
             	}
                break;

             case 5:   //main_hidden
                with (sheetObj) {
                    style.height=GetSheetHeight(5);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(30, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|whld_tax_amt"
						+ "|dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_so_ofc_cty_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_so_seq",     false,          "",       dfNone,         0,     true,      true);
				
                    
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "inv_ofc_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "cost_ofc_cd",     false,          "",       dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "inv_no",     false,          "",       dfNone,      0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "vndr_seq",     false,          "",       dfNone,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "yd_cd",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "yd_nm",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "curr_cd",     false,          "",       dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "ttl_inv_amt",     false,          "",       dfNone,         0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "vat_amt",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "ttl_calc_amt",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "fm_prd_dt",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "hld_flg",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "hld_rmk",     false,          "",       dfNone,      0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "to_prd_dt",     false,          "",       dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_inv_tp_cd",     false,          "",       dfNone,      0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_cost_grp_cd",     false,          "",       dfNone,         0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_calc_ind_cd",     false,          "",       dfNone,      0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "sto_dys_ind_cd",     false,          "",       dfNone,         0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "iss_dt",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "rcv_dt",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "eff_dt",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "pay_due_dt",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "pay_flg",     false,          "",       dfNone,      0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_inv_sts_cd",     false,          "",       dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "tml_inv_rjct_sts_cd",     false,          "",       dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       80,    daLeft , false,    "whld_tax_amt",     false,          "",       dfNone, 		0,     false,      false, 9);
					//InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "inv_cfm_dt",     false,          "",       dfNone,         0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "inv_rjct_rmk",     false,          "",       dfNone,      0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "cre_usr_id",     false,          "",       dfNone,         0,     true,      true);

					//InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "cre_dt",     false,          "",       dfNone,      0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "upd_usr_id",     false,          "",       dfNone,      0,     true,      true);
					//InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "upd_dt",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "dbt_note_no"         ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_cgst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_sgst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_igst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_ugst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);


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
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                 if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }

				 formObj.f_cmd.value = SEARCHLIST;
				 var sXml = sheetObj.GetSearchXml("ESD_TES_0019GS.do", tesFrmQryStr(formObj));
				 
				var arrXml = sXml.split("|$$|"); 
				
				for (var i=0; arrXml!=null && i<arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
					
//				 sheetObj.LoadSearchXml(sXml);
//				 var sxml0 = sheetObj.EtcData("sxml0");
//				 var sxml1 = sheetObj.EtcData("sxml1");
//                 var sxml2 = sheetObj.EtcData("sxml2");
//			     var sxml3 = sheetObj.EtcData("sxml3");
//			     sheetObj.RemoveEtcData();
//
//			     sheetObjects[0].LoadSearchXml(sxml0);   //위에서 온거
//				 sheetObjects[1].LoadSearchXml(sxml1); //위에서 온거
//			     sheetObjects[2].LoadSearchXml(sxml2);
//			     sheetObjects[3].LoadSearchXml(sxml3);
//
//			     sXml=null; sxml0=null; sxml1=null;  sxml2=null; sxml3=null;
			     
				 break;
        }
    }

	/**
	 * main hidden Sheet관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} formObj		Form Object
	 * @param {int} sAction			실행할 액션 구분 값
	 * @return
	 */    
    function doActionIBSheet5(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
                 if(validateForm(sheetObj,formObj,sAction))
                 formObj.f_cmd.value = SEARCH;
           		sheetObj.DoSearch4Post("ESD_TES_0019GS.do", tesFrmQryStr(formObj));
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
				var url_str = 'ESD_TES_9254Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='+sheetObj.CellValue(row,'tml_so_dtl_seq');
				url_str = url_str + '&inv_no='+formObj.inv_no.value;
				window.showModalDialog(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;");
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
				var url_str = 'ESD_TES_9254Popup.screen';
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
                    InsertTab( cnt++ , "Cost Calc.(SR by FD)" , -1 );
                    InsertTab( cnt++ , "Cost Calc.(SR by FP)" , -1 );

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

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab = nItem;
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
//            }
        }

        return true;
    }


    /**
     *	invoice type 이 Marine Storage 인지 여부를 리턴
     */
    function isMarineStorage(){
        var tml_inv_tp_cd = sheetObjects[4].CellValue(1,'tml_inv_tp_cd');
        var inv_no = document.form.inv_no.value;
        if(tml_inv_tp_cd == 'TM'){
            ComShowMessage(inv_no+' is Terminal Invoice.');
            return false;
        }else if(tml_inv_tp_cd == 'ON'){
            ComShowMessage(inv_no+' is On-dock Invoice.');
            return false;
        }else if(tml_inv_tp_cd == 'OF'){
            ComShowMessage(inv_no+' is Off-dock Invoice.');
            return false;
        }else if(tml_inv_tp_cd == 'ST'){
            return true;
        }
    }
   
	/**
	 * btn_retrieve 이벤트 실행시 main_hidden sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t4sheet1	main_hidden sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */		  
    function main_hidden_OnSearchEnd(main_hidden, ErrMsg){
		
        var formObj = document.form;

        if(main_hidden.RowCount==1){
            if(isMarineStorage() == true){
                
    			formObj.no_ofc_cd.value = sheetObjects[4].CellValue(1,'inv_ofc_cd');
    			formObj.no_yd_cd.value  = sheetObjects[4].CellValue(1,'yd_cd');
            	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
            	
    	        if (sheetObjects[4].CellValue(1, 'ap_rvs_cng_flg')=='Y'){
    	        	document.form.ap_rvs_cng_flg.checked = true;
    	        } else {
    	        	document.form.ap_rvs_cng_flg.checked = false;
    	        }
    	        
    	        //India GST Amount
    			formObj.dbt_note_no.value			= sheetObjects[4].CellValue(1, 'dbt_note_no' );
    	        formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObjects[4].CellValue(1, 'ida_cgst_amt' ),sheetObjects[4].CellValue(1,'curr_cd'));
    	        formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObjects[4].CellValue(1, 'ida_sgst_amt' ),sheetObjects[4].CellValue(1,'curr_cd'));
    	        formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObjects[4].CellValue(1, 'ida_igst_amt' ),sheetObjects[4].CellValue(1,'curr_cd'));
    	        formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObjects[4].CellValue(1, 'ida_ugst_amt' ),sheetObjects[4].CellValue(1,'curr_cd'));

            }
        }else{
            ComShowMessage(ComGetMsg('TES21505',formObj.inv_no.value,formObj.vndr_seq.value)); //ComShowMessage('No Data for \n\nInv No:'+formObj.inv_no.value+'  &  VNDR Code:'+formObj.vndr_seq.value);
        }
    }

	/**
	 * 조회 후 첫번째(Coincidence) 탭의 Sheet 에 데이터가 채워지면 Sheet 하단에 통계항목을 계산하여 설정한ㄴ다.
	 * @return
	 */   
	function setCoinShtStat(){

		var formObj = document.form;

		//초기화
		formObj.sht_01_ttl_box.value	= 0;
		formObj.sht_01_full.value		= 0;
		formObj.sht_01_mt.value			= 0;
		//formObj.sht_01_ts_bkg.value		= 0;
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
			if (sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd")!=undefined && sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd")!=null && sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd").trim()!='')
			{
				try {
					with (formObj) {
						if (sheetObjects[0].CellValue(i,"sam_locl_ts_ind_cd")=='T'){
							sht_01_ts_same_yard.value++;
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
					//ComShowMessage(e); //오류시에도 여길 그냥 통과해야 한다..
				}
			}
		}
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
		setTooltip(t2sheet1,'cntr_rmk');
	}

	/**
	 * btn_retrieve 이벤트 실행시 t3sheet1 sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t4sheet1	Cost Calc.(TMNL) sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */		 
    function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg){
        var formObj = document.form;
        var ttl_amt = 0;
        for (var i=1; i<=sheetObjects[2].RowCount; i++)
		{
			// 변환문자를 특수 문자로 치환. (2010-04-28)
			t3sheet1.CellValue2(i, "calc_rmk") = ComToString( t3sheet1.CellValue(i, "calc_rmk") );
			
			if (sheetObjects[2].CellValue(i,"inv_amt")!=undefined && sheetObjects[2].CellValue(i,"inv_amt")!=null && sheetObjects[2].CellValue(i,"inv_amt").trim()!='')
			{
				try {
				    ttl_amt = ttl_amt + eval(sheetObjects[2].CellValue(i,"inv_amt"));
				} catch(e){
					//ComShowMessage(e); //여길 그냥 통과해야 한다..
				}
			}
		}

		formObj.ttl_calc_amt1.value = ttl_amt;
		tes_chkAmtFmtObj(formObj.ttl_calc_amt1);
		setTooltip(t3sheet1,'calc_rmk');
    }

	/**
	 * btn_retrieve 이벤트 실행시 t4sheet1 sheet 조회가 완료되고 발생하는 이벤트
	 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by Day) sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
    function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg){
        var formObj = document.form;

        var ttl_amt = 0;

        for (var i=1; i<=sheetObjects[3].RowCount; i++)
		{
			// 변환문자를 특수 문자로 치환. (2010-04-28)
			t4sheet1.CellValue2(i, "calc_rmk") = ComToString( t4sheet1.CellValue(i, "calc_rmk") );
			
			if (sheetObjects[3].CellValue(i,"inv_amt")!=undefined && sheetObjects[3].CellValue(i,"inv_amt")!=null && sheetObjects[3].CellValue(i,"inv_amt").trim()!='')
			{
				try {
				    ttl_amt = ttl_amt + eval(sheetObjects[3].CellValue(i,"inv_amt"));
				} catch(e){
					//ComShowMessage(e); //여길 그냥 통과해야 한다..
				}
			}
		}

		formObj.ttl_calc_amt2.value = ttl_amt;
		tes_chkAmtFmtObj(formObj.ttl_calc_amt2);
		setTooltip(t4sheet1,'calc_rmk');
    }

	 /**
	  * vender name 세팅
	  * @param {Array}	rowArray	vender 정보가 담긴 array	
	  * @return
	  */
    function getVender(rowArray) {
    	var colArray = rowArray[0];
    	//document.all.vndr_seq.value = colArray[2].substr(2,6);
    	document.all.vndr_seq.value = colArray[6];
    	document.all.vndr_seq_name.value = colArray[4];
    }

	/**
	 * 입력값이 숫자인지 확인하고 숫자값이 아닌경우 폼을 리셋한다.
	 * @param {object}	obj		입력된 객체
	 * @return 
	 */	  
	function isNum(obj){
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
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
					//ComShowMessage('유효하지 않은 VNDR Code입니다.');
					ComShowMessage(ComGetMsg('TES21040'));
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				//ComShowMessage('유효하지 않은 VNDR Code입니다.');
				ComShowMessage(ComGetMsg('TES21040'));
				formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			//ComShowMessage('유효하지 않은 VNDR Code입니다.');
			ComShowMessage(ComGetMsg('TES21040'));
			formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

		}
	}

	/**
	 * vander code 길이 체크해서 유효하면 validateVndrSeq() 호출
	 * @param {object}	obj	: vander code 객체
	 * @return
	 */
	function chkInput(obj) {
		if (obj.maxLength < tes_getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
		if(tes_getStrLen(obj.value) == 6){
		    validateVndrSeq();
		}
	}

	/**
	 * Sheet 초기화
	 * @return
	 */
	function init(){
	    var formObject = document.form;
	    var tmp_inv_no = formObject.inv_no.value;
        var tmp_vndr_seq = formObject.vndr_seq.value;
        var tmp_vndr_nm = formObject.vndr_seq_name.value;

        formObject.reset();
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
        sheetObjects[4].RemoveAll();

        formObject.inv_no.value = tmp_inv_no;
        formObject.vndr_seq.value = tmp_vndr_seq;
        formObject.vndr_seq_name.value = tmp_vndr_nm;

	}
    
	 /**
	  * 
	  * @return
	  */
    function setFormValue(){
		  var formObj = document.form;
		  
      	  var checkInv = "N";
      	  var checkVndr = "N";
      	  
      	  if(formObj.inv_no_tmp.value == sheetObjects[4].CellValue(1, 'inv_no'))checkInv = "Y";
      	  if(vndr_seq == tes_lpad(sheetObjects[4].CellValue(1, 'vndr_seq'),6,'0'))checkVndr = "Y";
      	  
		  if(document.form.auth_ofc_cd.value.trim()=="Y"){
        	
     		formObj.tml_so_ofc_cty_cd.value	= sheetObjects[4].CellValue(1,'tml_so_ofc_cty_cd');
			formObj.tml_so_seq.value		= sheetObjects[4].CellValue(1,'tml_so_seq');
            formObj.cost_ofc_cd.value       = sheetObjects[4].CellValue(1,'cost_ofc_cd');
			formObj.vndr_seq.value			= tes_lpad(sheetObjects[4].CellValue(1, 'vndr_seq'),6,'0'); //2008-01 lpad추가;
			formObj.inv_no.value			= sheetObjects[4].CellValue(1, 'inv_no');
            formObj.inv_ofc_cd.value        = sheetObjects[4].CellValue(1,'inv_ofc_cd');
            formObj.yd_cd.value             = sheetObjects[4].CellValue(1,'yd_cd');
            formObj.yd_nm.value             = sheetObjects[4].CellValue(1,'yd_nm');
            formObj.hld_flg.value           = sheetObjects[4].CellValue(1,'hld_flg');
            formObj.hld_rmk.value           = sheetObjects[4].CellValue(1,'hld_rmk');
            formObj.iss_dt.value            = sheetObjects[4].CellValue(1,'iss_dt');
            formObj.rcv_dt.value            = sheetObjects[4].CellValue(1,'rcv_dt');
            formObj.eff_dt.value            = sheetObjects[4].CellValue(1,'eff_dt');
            formObj.ttl_inv_amt.value       = sheetObjects[4].CellValue(1,'ttl_inv_amt');
            formObj.tml_inv_tp_cd.value     = sheetObjects[4].CellValue(1,'tml_inv_tp_cd');
            tes_chkAmtFmtObj(formObj.ttl_inv_amt);
            formObj.vat_amt.value           = sheetObjects[4].CellValue(1,'vat_amt');
            tes_chkAmtFmtObj(formObj.vat_amt);
			formObj.whld_tax_amt.value		= tes_chkAmtFmt(sheetObjects[4].CellValue(1,'whld_tax_amt'),sheetObjects[4].CellValue(1,'curr_cd'));
            formObj.pay_due_dt.value        = sheetObjects[4].CellValue(1,'pay_due_dt');
            formObj.tml_inv_rjct_sts_cd.value = sheetObjects[4].CellValue(1,'tml_inv_rjct_sts_cd');
            formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(sheetObjects[4].CellValue(1,'tml_inv_rjct_sts_cd'));
            formObj.fm_prd_dt.value         = sheetObjects[4].CellValue(1,'fm_prd_dt')+' ~ '+sheetObjects[4].CellValue(1,'to_prd_dt');

           if(sheetObjects[4].RowCount >0 && formObj.yd_cd.value !=''){
        	  doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
           }
			
     	}else if(formObj.flag.value == "Y" && checkInv == 'Y' && checkVndr == 'Y'){
     		
     		formObj.tml_so_ofc_cty_cd.value	= sheetObjects[4].CellValue(1,'tml_so_ofc_cty_cd');
			formObj.tml_so_seq.value		= sheetObjects[4].CellValue(1,'tml_so_seq');
            formObj.cost_ofc_cd.value       = sheetObjects[4].CellValue(1,'cost_ofc_cd');
			formObj.vndr_seq.value			= tes_lpad(sheetObjects[4].CellValue(1, 'vndr_seq'),6,'0'); //2008-01 lpad추가;
			formObj.inv_no.value			= sheetObjects[4].CellValue(1, 'inv_no');
            formObj.inv_ofc_cd.value        = sheetObjects[4].CellValue(1,'inv_ofc_cd');
            formObj.yd_cd.value             = sheetObjects[4].CellValue(1,'yd_cd');
            formObj.yd_nm.value             = sheetObjects[4].CellValue(1,'yd_nm');
            formObj.hld_flg.value           = sheetObjects[4].CellValue(1,'hld_flg');
            formObj.hld_rmk.value           = sheetObjects[4].CellValue(1,'hld_rmk');
            formObj.iss_dt.value            = sheetObjects[4].CellValue(1,'iss_dt');
            formObj.rcv_dt.value            = sheetObjects[4].CellValue(1,'rcv_dt');
            formObj.eff_dt.value            = sheetObjects[4].CellValue(1,'eff_dt');
            formObj.ttl_inv_amt.value       = sheetObjects[4].CellValue(1,'ttl_inv_amt');
            formObj.tml_inv_tp_cd.value     = sheetObjects[4].CellValue(1,'tml_inv_tp_cd');
            tes_chkAmtFmtObj(formObj.ttl_inv_amt);
            formObj.vat_amt.value           = sheetObjects[4].CellValue(1,'vat_amt');
            tes_chkAmtFmtObj(formObj.vat_amt);
			formObj.whld_tax_amt.value		= tes_chkAmtFmt(sheetObjects[4].CellValue(1,'whld_tax_amt'),sheetObjects[4].CellValue(1,'curr_cd'));
            formObj.pay_due_dt.value        = sheetObjects[4].CellValue(1,'pay_due_dt');
            formObj.tml_inv_rjct_sts_cd.value = sheetObjects[4].CellValue(1,'tml_inv_rjct_sts_cd');
            formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(sheetObjects[4].CellValue(1,'tml_inv_rjct_sts_cd'));
            formObj.fm_prd_dt.value         = sheetObjects[4].CellValue(1,'fm_prd_dt')+' ~ '+sheetObjects[4].CellValue(1,'to_prd_dt');

           if(sheetObjects[4].RowCount >0 && formObj.yd_cd.value !=''){
        	  doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
           }
     		
     	}else{
     		
     		ComShowMessage(ComGetMsg('TES21051'));
     		document.form.auth_ofc_cd.value = "";
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
