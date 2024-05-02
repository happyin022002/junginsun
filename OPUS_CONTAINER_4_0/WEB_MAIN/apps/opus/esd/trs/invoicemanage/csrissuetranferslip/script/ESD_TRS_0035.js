/**
 * @class ESD_TRS_0035 : 
 */
function ESD_TRS_0035() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

    // 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];
		 //var sheetObject4 = sheetObjects[4];

         /*******************************************************/
         var formObj = document.form;

    	try {

			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

        	    case "btn_retrieve":
					retrieve();
        	        break;

				case "btn_new":
    	            sheetObject.RemoveAll();
				    sheetObject1.RemoveAll();
    	            formObj.reset();
        	        break;

				case "btng_preview":
            		if (sheetObjects[0].RowCount == 0){
                        errMsg = ComGetMsg("TRS90036" );
                        ComShowMessage(errMsg);
            			return false;
            		}
					doActionIBSheetPreview(sheetObject3,formObj,IBSEARCH);
					break;

				case "btng_print":
				
            		if (sheetObjects[0].RowCount == 0){
                        errMsg = ComGetMsg("TRS90036" );
                        ComShowMessage(errMsg);
            			return false;
            		}
            		
					var fromObj = new Array();
					var rdObj  	= new Array();
					var parmObj = new Array();
					fromObj[0] = formObj;                            // RD 로 보내기 위해 배열로담는다
					rdObj[0] = sheetObjects[0];     												// Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다
					RD_path  = "http://opusdev.clt.com:9300/clt/";
					// RD 로 보내기 위한 설정
					parmObj[0] = "1";
					parmObj[1] = "";
					parmObj[2] = "N";
					parmObj[3] = RD_path+"apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0024Print.mrd";     // RD 화면
					parmObj[4] = rdObj;
					parmObj[5] = fromObj;
					rdObjModaless(RdReport , parmObj , 1000 ,700);						
					break;

				case "btng_approvalrequest":
					approvalrequest();
					break;

            }
    	}catch(e) {
    		if( e == "[object Error]") {
                errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


	function retrieve(){
		var formObj = document.form;
		if(formObj.csr_no.value != "")
      		doActionIBSheetAPHDR(sheetObjects[1],formObj,IBSEARCH);
	}

	function approvalrequest(){
		if (sheetObjects[0].RowCount == 0){
            errMsg = ComGetMsg("TRS90036" );
            ComShowMessage(errMsg);
			return false;
		}

		var formObj = document.form;
		doActionIBSheetSOHDRlist(sheetObjects[0],formObj,IBSAVE);
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		document.form.csr_no.focus();
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
                    style.height = GetSheetHeight(13);
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
                    InitColumnInfo(9, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "|Seq.|Invoice No.|Net Amount|Tax Amount|Total Amount|Incorrect Invoice";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,    "ibflag",							false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtSeq,	 30,		daCenter,		false,    "",				false,			"",			dfNone,			0,			false,		false	);
					InitDataProperty(0, cnt++ , dtData,	 200,		daLeft,			false,    "inv_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 150,		daRight,		false,    "ttl_inv_amt",				false,			"",			dfNullFloat,			2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 150,		daRight,		false,    "vat_amt",				false,			"",			dfNullFloat,			2,			false,			false	);

					InitDataProperty(0, cnt++ , dtData,	 150,		daRight,		false,    "ttl_amt",				false,			"",			dfNullFloat,			2,			false,			false	);
					InitDataProperty(0, cnt++ , dtCheckBox, 100,		daCenter,		false,    "incor_inv",				false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daRight,		false,    "inv_vndr_seq",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 50,		daRight,		false,    "trsp_inv_aud_sts_cd",				false,			"",			dfNone,			0,			false,			false	);

               }
               break;

            case 2: //main_hidden
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(3);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(87, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					//var HeadTitle = 'csr_no|pay_amt|pay_dt|prnt_vndr_seq|prnt_vndr_lgl_eng_nm'
					var HeadTitle = 'csr_no|pay_amt|pay_dt|prnt_vndr_seq|prnt_vndr_lgl_eng_nm|csr_tp_cd|inv_dt|inv_term_dt|gl_dt|vndr_no|csr_amt|pay_amt|pay_dt|csr_curr_cd|vndr_term_nm|inv_desc|attr_cate_nm|attr_ctnt1|attr_ctnt2|attr_ctnt3|attr_ctnt4|attr_ctnt5|attr_ctnt6|attr_ctnt7|attr_ctnt8|attr_ctnt9|attr_ctnt10|attr_ctnt11|attr_ctnt12|attr_ctnt13|attr_ctnt14|attr_ctnt15|glo_attr_ctnt1|glo_attr_ctnt2|glo_attr_ctnt3|glo_attr_ctnt4|glo_attr_ctnt5|glo_attr_ctnt6|glo_attr_ctnt7|glo_attr_ctnt8|glo_attr_ctnt9|glo_attr_ctnt10|glo_attr_ctnt11|glo_attr_ctnt12|glo_attr_ctnt13|glo_attr_ctnt14|glo_attr_ctnt15|glo_attr_ctnt16|glo_attr_ctnt17|glo_attr_ctnt18|src_ctnt|pay_mzd_lu_cd|pay_grp_lu_cd|coa_co_cd|coa_rgn_cd|coa_ctr_cd|coa_acct_cd|coa_vvd_cd|coa_inter_co_cd|coa_ftu_n1st_cd|coa_ftu_n2nd_cd|ppd_no|ppd_dtrb_no|ppd_aply_amt|ppd_gl_dt|apro_flg|tax_decl_flg|err_csr_no|if_flg|if_dt|if_err_rsn|ppay_aply_flg|tj_ofc_cd|act_xch_rt|imp_err_flg|rcv_err_flg|tax_curr_xch_flg|usr_eml|imp_err_rsn|rcv_err_rsn|ftu_use_ctnt1|ftu_use_ctnt2|ftu_use_ctnt3|ftu_use_ctnt4|ftu_use_ctnt5|eai_evnt_dt';

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	 150,		daCenter,		false,    "csr_no",				false,			"",			dfNone,			0,			false,		false	);
					InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,		false,    "pay_amt",				false,			"",			dfNone,			0,			false,		false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "pay_dt",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "prnt_vndr_seq",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "prnt_vndr_lgl_eng_nm",				false,			"",			dfNone,			0,			false,			false	);

					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "csr_tp_cd"       ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "inv_dt"		    ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "inv_term_dt"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "gl_dt"           ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "vndr_no"         ,				false,			"",			dfNone,			0,			false,			false	);
					//10

					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "csr_amt"         ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "pay_amt"         ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "pay_dt"          ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "csr_curr_cd"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "vndr_term_nm"    ,				false,			"",			dfNone,			0,			false,			false	);
                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "inv_desc"        ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_cate_nm"    ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt1"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt2"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt3"      ,				false,			"",			dfNone,			0,			false,			false	);
					//20                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt4"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt5"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt6"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt7"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt8"      ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt9"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt10"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt11"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt12"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt13"     ,				false,			"",			dfNone,			0,			false,			false	);
					//30                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt14"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "attr_ctnt15"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt1"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt2"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt3"  ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt4"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt5"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt6"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt7"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt8"  ,				false,			"",			dfNone,			0,			false,			false	);
					//40                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt9"  ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt10" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt11" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt12" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt13" ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt14" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt15" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt16" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt17" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "glo_attr_ctnt18" ,				false,			"",			dfNone,			0,			false,			false	);
					//50                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "src_ctnt"        ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "pay_mzd_lu_cd"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "pay_grp_lu_cd"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_co_cd"       ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_rgn_cd"      ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_ctr_cd"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_acct_cd"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_vvd_cd"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_inter_co_cd" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_ftu_n1st_cd" ,				false,			"",			dfNone,			0,			false,			false	);
					//60                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "coa_ftu_n2nd_cd" ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ppd_no"          ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ppd_dtrb_no"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ppd_aply_amt"    ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ppd_gl_dt"       ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "apro_flg"        ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "tax_decl_flg"    ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "err_csr_no"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "if_flg"          ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "if_dt"           ,				false,			"",			dfNone,			0,			false,			false	);
					//70                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "if_err_rsn"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ppay_aply_flg"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "tj_ofc_cd"       ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "act_xch_rt"      ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "imp_err_flg"     ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "rcv_err_flg"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "tax_curr_xch_flg",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "usr_eml"         ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "imp_err_rsn"     ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "rcv_err_rsn"     ,				false,			"",			dfNone,			0,			false,			false	);
					//80                  
					
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ftu_use_ctnt1"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ftu_use_ctnt2"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ftu_use_ctnt3"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ftu_use_ctnt4"   ,				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "ftu_use_ctnt5"   ,				false,			"",			dfNone,			0,			false,			false	);
					                  
					InitDataProperty(0, cnt++ , dtData,  100,		daCenter,		false,    "eai_evnt_dt"     ,				false,			"",			dfNone,			0,			false,			false	);
                    InitDataProperty(0, cnt++,  dtStatus,    30,    daCenter,  false,    "ibflag");
			   }
               break;
        
            case 3:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(3);
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
                    InitColumnInfo(13, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtData,	 				70,	daLeft,			false,    "pre_csr_no",				false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_office",				false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_prpd_dy",			false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_to",				false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_csr_type",			false,			"",			dfNone,				0,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_desc",					false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_group",		false,			"",			dfNone,				0,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_evi_tp",				false,			"",			dfNone,				0,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_due_date",			false,			"",			dfNone,				0,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_asa_no",				false,			"",			dfNone,				0,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_inv_dt",				false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_curr_cd",			false,			"",			dfNone,				0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_amt",					false,			"",			dfNone,				0,			false,			false	);


               }
                break; 

            case 4:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(5);
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
                    InitColumnInfo(8, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "pre_chart_of_account",		false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData, 			80,			daCenter,		false,    "pre_account_name",				false,			"",			dfNone,					0,			true,			true	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daLeft,			false,    "pre_gl_date",						false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_city",								false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_inv_no",							false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_desc",								false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_debit",							false,			"",			dfNone,					2,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_credit",							false,			"",			dfNone,					2,			false,			false	);										


               }
                break;                                

		}
    }


  // Sheet관련 프로세스 처리
    function doActionIBSheetAPHDR(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
				if (!validateForm(sheetObj,formObj,sAction)){return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TRS_0035GS.do", TrsFrmQryString(formObj));
			    break;
        }
    }

    function doActionIBSheetSOHDRlist(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
				if (!validateForm(sheetObj,formObj,sAction)){return false;
				}
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch4Post("ESD_TRS_0035GS.do", TrsFrmQryString(formObj));
			    break;
            case IBSAVE:        //저장
				if (!validateForm(sheetObj,formObj,sAction)){return false;
				}
				formObj.f_cmd.value = MULTI;
				var param = sheetObj.GetSaveString(false,false);
				var savexml = sheetObj.GetSaveXml("ESD_TRS_0035GS.do", param+'&'+TrsFrmQryString(formObj));
				sheetObj.LoadSaveXml(savexml,true);
                break;
		}
    }

    function doActionIBSheetPreview(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
               	formObj.f_cmd.value = SEARCH01;
				var param = sheetObjects[0].GetSaveString(true);
				var sXml = sheetObjects[3].GetSearchXml("ESD_TRS_0035PreView.do", param+'&'+TrsFrmQryString(formObj),"",true);
				sheetObjects[3].LoadSearchXml(sXml); 	

                break; 
        }
    }     
 
/*
    function doActionIBSheet3rdIFlist(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
               	formObj.f_cmd.value = SEARCH02;                  
                var param = sheetObjects[0].GetSaveString(true);
				sheetObj.DoSearch4Post("ESD_TRS_0035GS.do", param+'&'+TrsFrmQryString(formObj));
                break; 
        }
    }
*/

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//                return false;
//            }
        }
        return true;
    }

	function setPVenderInfo(sheet, EXCEPTION_LIST){
		var formObj = document.form;
		formObj.prnt_vndr_seq.value = sheet.CellValue(1,"prnt_vndr_seq");
		formObj.prnt_vndr_lgl_eng_nm.value = sheet.CellValue(1,"prnt_vndr_lgl_eng_nm");
		for (var j=0; j<=sheet.LastCol; j++){
			if (sheet.ColSaveName(j) != ''){
				try {
					var tmp = EXCEPTION_LIST.split('|');
					with (formObj) {
						if (tmp.length > 0){
							for (var k=0; tmp!=null && k<tmp.length; k++){
								if (tmp[k]!=sheet.ColSaveName(j)){eval(sheet.ColSaveName(j)).value = sheet.CellValue(1,sheet.ColSaveName(j));
								}
							}
						} else {eval(sheet.ColSaveName(j)).value = sheet.CellValue(1,sheet.ColSaveName(j));
						}
					}
				} catch(e){ //COLNM과 일치하지 않은 INPUT이 있을 수 있기에... 오류시에도 여길 그냥 통과해야 한다..
				}
			}
		}
		// 이미 개발한 CSR에 맞춰 공통으로 사용하려면 다음과 같이 복사해서 사용해야 한당.
		formObj.iss_dt.value = formObj.inv_dt.value;
		formObj.payment_due_dt.value = formObj.inv_term_dt.value;
		formObj.vndr_seq.value = formObj.prnt_vndr_seq.value;
		formObj.vndr_seq_name.value = formObj.inv_desc.value;
		formObj.gen_pay_term_cd.value = formObj.vndr_term_nm.value;
		formObj.total_amt.value = formObj.csr_amt.value;
		formObj.curr_cd.value = formObj.csr_curr_cd.value;
		formObj.csr_tp_cd.value = 'C';
	}

	
	function main_hidden_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if (sheetObj.RowCount == 1){
			var pre_csr_no = sheetObj.EtcData("csrNo");	

			formObj.pre_csr_no.value = '';
			formObj.pre_csr_no.value = pre_csr_no;

			if (sheetObj.CellValue(1,"pay_amt").length >0 || sheetObj.CellValue(1,"pay_dt").length > 0)
			{
				return false;
			} else {
				//vendor정보 form 설정하기
				setPVenderInfo(sheetObj,'cost_ofc_cd|csr_tp_cd|vndr_seq|vndr_term_nm');
				//so hdr list조회하기
				doActionIBSheetSOHDRlist(sheetObjects[0],formObj,IBSEARCH);
			} 
			formObj.csr_no.focus();
		} else if (sheet.RowCount == 0){
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.prnt_vndr_seq.value = '';
			formObj.prnt_vndr_lgl_eng_nm.value = '';
			formObj.csr_no.focus();
		} else if (sheet.RowCount > 1){
			return false;			
		}
	}

	function sheet1_OnSearchEnd(sheetObj,errMsg){
		var formObj = document.form;
		//doActionIBSheet3rdIFlist(sheetObjects[4],formObj,IBSEARCH);

		for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
			sheetObj.CellValue2(i,"trsp_inv_aud_sts_cd") = 'C';
		}
	}

	function sheet1_OnChange(sheet, Row, Col, Value){
		if (sheet.ColSaveName(Col) == 'incor_inv'){ 
			if (sheet.CellValue(Row,"incor_inv") == 1){
				sheet.CellValue2(Row,"trsp_inv_aud_sts_cd") = 'R';
			} else if (sheet.CellValue(Row,"incor_inv") == 0){
				sheet.CellValue2(Row,"trsp_inv_aud_sts_cd") = 'C';
			}
		}
	}

    function sheet3_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        
		var pre_csr_no			= sheetObj.EtcData("pre_csr_no");			
		var pre_office			= sheetObj.EtcData("pre_office");				
		var pre_prpd_dy			= sheetObj.EtcData("pre_prpd_dy");			
		var pre_pay_to			= sheetObj.EtcData("pre_pay_to");				
		var pre_csr_type		= sheetObj.EtcData("pre_csr_type");		
		var pre_desc			= sheetObj.EtcData("pre_desc");					
		var pre_pay_group		= sheetObj.EtcData("pre_pay_group");		
		var pre_evi_tp			= sheetObj.EtcData("pre_evi_tp");				
		var pre_due_date		= sheetObj.EtcData("pre_due_date");			
		var pre_asa_no			= sheetObj.EtcData("pre_asa_no");				
		var pre_inv_dt			= sheetObj.EtcData("pre_inv_dt");				
		var pre_curr_cd			= sheetObj.EtcData("pre_curr_cd");			
		var pre_amt				= sheetObj.EtcData("pre_amt");	
		
		sheetObjects[2].RemoveAll();   

		sheetObjects[2].DataInsert(-1);     
         
        sheetObjects[2].CellValue(1,"pre_csr_no") 	= pre_csr_no;
        sheetObjects[2].CellValue(1,"pre_office") 	= document.form.cost_ofc_cd.value;
        sheetObjects[2].CellValue(1,"pre_prpd_dy") 	= pre_prpd_dy; 
        sheetObjects[2].CellValue(1,"pre_pay_to") 	= pre_pay_to;
        sheetObjects[2].CellValue(1,"pre_csr_type")	= pre_csr_type;
        sheetObjects[2].CellValue(1,"pre_desc") 		= pre_desc;
        sheetObjects[2].CellValue(1,"pre_pay_grou")	= pre_pay_group; 
        sheetObjects[2].CellValue(1,"pre_evi_tp") 	= pre_evi_tp;
        sheetObjects[2].CellValue(1,"pre_due_date")	= pre_due_date;
        sheetObjects[2].CellValue(1,"pre_asa_no") 	= document.form.asa_no.value; 
        sheetObjects[2].CellValue(1,"pre_inv_dt") 	= pre_inv_dt; 
        sheetObjects[2].CellValue(1,"pre_curr_cd") 	= pre_curr_cd; 
        sheetObjects[2].CellValue(1,"pre_amt") 		= pre_amt; 
        

        noRtnPopup('ESD_TRS_0036.do', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');            
    }	

	  /**
     * MInimize 클릭시 이벤트 관련
     */
    function Minimize(nItem)
    {
        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";


            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =20;

		}
    	else
    	{
    	    objs.style.display = "inline";

    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =10;

    	}
    }
	
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value)){
			obj.value = '';
			obj.focus();
			return false;
		}
	}
	
	function isApNum(obj){
		//영문과 숫자만
		if (!ComIsAlphabet(obj, 'n')){
			obj.value = '';
		}
	}
	
	function enterCheck(funcNm){
		if (event.keyCode == 13){retrieve();}
	}
	
	function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}