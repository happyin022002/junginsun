/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1109.js
*@FileTitle : Chassis Movement Update by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 김상수
*@LastVersion : 1.55
*
* 2009.07.22 최민회
*     1.0 Creation
*
* 2010.07.29 김상수
*     [CHM-201004960-01] Genset Ineventory Logic error 수정건
*         : 각 Row Data의 조건에 따라서 Edit가능/불가능으로 변경되는 컬럼들의 속성을 조건없이 모두 Edit가능하게 변경 by 김상수
*         : SAVE 버튼 클릭 시 ComOpenWait 호출하도록 수정 by 나상보
*
=========================================================*/

   /**
     * @fileoverview
     * @author
     */

    /**
     * @extends
     * @class EES_CGM_1109 : EES_CGM_1109
     */
    function EES_CGM_1109() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }



 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;


 var OrgValue = "";
 var maxIa = [['',''],['',''],['','']];


 document.onclick = processButtonClick;

     function processButtonClick(){
         var sheetObject1 = sheetObjects[0];
	     var sheetObject2 = sheetObjects[1];
        /*******************************************************/
	     var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

	     switch(srcName) {

			 case "btn_retrieve":
			 	 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			 break;

			 case "btn_new":
				 formObject.reset();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
			 break;

			 case "btn_save":
				 doActionIBSheet(sheetObject2,document.form,IBSAVE);
			 break;
	     } // end switch
	     tRoleApply();
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
     }

     /**
      * IBSheet Object
      *
      *
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /**
      * Sheet
      * body
      *
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){


             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);

             ComEndConfigSheet(sheetObjects[i]);
         }

     }

          /**
      *
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {

         var formObj = document.form;
//       axon_event.addListener('onkeypress', 'obj_keypress'  , 'p_cntrno'    );
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
         axon_event.addListener('focusout', 'obj_focusout', 'p_cntrno' );
         axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);

         // 초기화
         initControl(sheetObjects[0]);

         tRoleApply();
    }

      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  {object} sheetObj	필수
       * @return 없음
       * @author 최민회
       * @version 2009.05.20
       */
      function initControl(sheetObj){
      	// Form 객체 선언
      	  formObj = document.form;
          // axon event 등록


      	if(formObj.p_cntrno.value !=""){
        	//chungpa 20091006 popup으로 띄울때 default 날짜가 세팅이 안되고 전체 데이터가 조회되는 버그 fix.
 	     	    	//alert("sss");
     	    	cntrno = formObj.p_cntrno.value;
     	    	if (cntrno.length == 10) {
     	    		formObj.check_digit.value = "";

	     	    	var sheetObj = sheetObjects[0];
	     	    	formObj.f_cmd.value = SEARCH10;
	     	    	xml = sheetObj.GetSearchXml ("CTMCommonGS.do", FormQueryString(formObj));
	     	    	rtnValue = ComGetEtcData(xml, "rtnValue");
	     	    	if (rtnValue == null) sheetObj.LoadSearchXml(xml);
	     	    	parseCTNRNo(rtnValue, formObj);
     	    	}
        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
         } else {
        	 formObj.p_cntrno.focus();
         }

      }


      /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 80;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(12, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|Booking No.|Booking No.|B/L No.|Commodity";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]


                    InitDataProperty(0, cnt++ , dtData,      29,    daCenter,  false,     "cnmv_cyc_no",     false,          "",      dfNone  ,     0,     false,     false    );
                    InitDataProperty(0, cnt++ , dtData,      72,    daCenter,  false,     "vl",     false,          "",      dfNone ,     0,     false,     false     );
                    InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,     "por_cd",     false,          "",      dfNone  ,     0,     false,     false    );
                    InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,     "pol_cd",     false,          "",      dfNone   ,     0,     false,     false   );
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "Relay",     false,          "",      dfNone   ,     0,     false,     false   );

                    InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,     "pod_cd",     false,          "",      dfNone    ,     0,     false,     false  );
                    InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,     "del_cd",     false,          "",      dfNone    ,     0,     false,     false  );
                    InitDataProperty(0, cnt++ , dtData,      10,    daCenter,  false,     "",           false,          "",      dfNone    ,     0,     false,     false  );
                    InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "bkg_no",     false,          "",      dfNone    ,     0,     false,     false  );
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,     "bkg_no_split",     false,          "",      dfNone ,     0,     false,     false     );
                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,     "bl_no",     false,          "",      dfNone   ,     0,     false,     false   );

                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,     "rep_cmdt_nm",     false,          "",      dfNone ,     0,     false,     false,       13     );

                    ScrollBars = 1;

 					CountPosition =	0;
 					SelectHighLight = false;

                }
                 break;



                 case 2:      //t1sheet1 init
                 with (sheetObj) {
                	 sheetObj.SetAutoTrim = false;
                     // 높이 설정
                     style.height = 282;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(58, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|Sel.|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code";
                     HeadTitle      +=  "|F/M|I/O|MSG|TP|DM|D|E|R|SP";
                     HeadTitle      +=  "|Service Provider|Service Provider|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)";
                     HeadTitle      +=  "|Office|User Name|Remark(s)|ID|SEQ|NO|CNTR_NO|BKG_NO|BKG_SPLIT|BKG_KNT|BL_NO|BL_NO_TYPE|BL_NO_CHK|YEAR|FLG|TPSZ|MAX SEQ|CNTR_SVR ID|SVR_ID|EDI1|EDI2|EDI3|EDI4|VVD|";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                    var sTipAF = "[ Auto Flag ]"
                               + "\nA : Missing status automatically created by system"
                               + "\nC : (International) “TS, IC, MT” Status automatically created after \"VD\""
                               + "\n      (USA domestic) “CM” Status automatically created after \"CD\""
                               + "\nN : Once automatically created status (\"A\") modified by manual,"
                               + "\n      \"A\" changed to \"N\""
                               + "\nM : Added status."
                               + "\nU : Status updated due to next status."
                     var sTipTP = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
                     var sTipDM = "Damage, Y";
                     var sTipHG   = "Hanger rack, Y";
                     var sTipD   = " Disposal Candidate, Y";
                     var sTipE   = "Immediate Exit, Y";
                     var sTipR   = "Re-furbishing, Y";
                     var sTipSP   = "Special, Y";



                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                     InitDataProperty(0, cnt++ , dtHiddenStatus,      0,   daCenter,  false,     "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,      30,    daCenter,  false,     "del_chk",     false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "cnmv_cyc_no",     true,          "",      dfNone      ,    0,      false,      false);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "cnmv_co_cd",     true,          "",      dfNone       ,    0,      false,      false);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "mvmt_sts_cd",     true,          "",      dfNone      ,   0,      false,      false,      2,       false,      true);

                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,     "mvmt_cre_tp_cd",     false,          "",      dfNone ,   0,      false,      false,      1,       false,      true,       sTipAF   );
                     InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "org_yd_cd",     false,          "",      dfNone     ,   0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,     "dest_yd_cd",     false,          "",      dfNone     ,   0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "cnmv_evnt_dt",     false,          "",      dfUserFormat2   ,   0,      false,      false   );
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "cntr_id",     false,          "",      dfNone     ,   0,      false,      false );


                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "fcntr_flg",     false,          "",      dfNone       ,    0,      false,      true);
                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "ob_cntr_flg",     false,          "",      dfNone  ,    0,      false,      true);
                     InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,     "mvmt_edi_msg_tp_id",     false,          "",      dfNone       ,    0,      false,      true);
                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "bkg_cgo_tp_cd",     false,          "",      dfNone        ,    0,      false,      true,      10,       false,      true,       sTipTP );
                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "cntr_dmg_flg",     false,          "",      dfNone     ,    0,      false,      true,      10,       false,      true,       sTipDM  );

                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "cntr_disp_flg",     false,          "",      dfNone     ,    0,      false,      true,      10,       false,      true,       sTipD  );
                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "imdt_ext_flg",     false,          "",      dfNone       ,    0,      false,      true,      10,       false,      true,       sTipE );
                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "cntr_xch_cd",     false,          "",      dfNone     ,    0,      false,      true,      10,       false,      true,       sTipR  );
                     InitDataProperty(0, cnt++ , dtHidden,    25,    daCenter,  false,     "spcl_cgo_flg",     false,          "",      dfNone     ,    0,      false,      true,      10,       false,      true,       sTipSP  );

                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "vndr_seq",     false,          "",      dfNone     ,   0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "vndr_abbr_nm",     false,          "",      dfNone     ,    0,      false,      true,      10,       false,      true);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "mvmt_trsp_mod_cd",     false,          "",      dfNone     ,   0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "chss_no",     false,          "",      dfNone,      	0,     true,  true, 10      );
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "mgst_no",     false,          "",      dfNone,      	0,     true,  true, 10      );

                     InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  false,     "cntr_seal_no",     false,          "",      dfNone     ,   0,      false,      false );
                     InitDataProperty(0, cnt++ , dtHidden,    85,    daCenter,  false,     "wbl_no",     false,          "",      dfNone      ,   0,      false,      false);
                     InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  false,     "pkup_no",     false,          "",      dfNone     ,   0,      false,      false );

                     InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,     "upd_locl_dt",     false,          "",      dfUserFormat2      ,    0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,     "cre_locl_dt",     false,          "",      dfUserFormat2      ,    0,      false,      false );

                     InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,     "upd_dt",     false,          "",      dfUserFormat2      ,    0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,     "cre_dt",     false,          "",      dfUserFormat2      ,    0,      false,      false );


                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,     "ofc_cd",     false,          "",      dfNone      ,    0,      false,      false );
                     InitDataProperty(0, cnt++ , dtData,      130,    daLeft,  false,      "usr_nm",     false,          "",      dfNone,        0,      false,      false,     20,       false,      false  );
                     InitDataProperty(0, cnt++ , dtData,      160,    daLeft,  false,      "cnmv_rmk",     false,          "",      dfNone ,     0,     true,   true,     30     );

                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cnmv_id_no",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cnmv_seq",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cnmv_split_no",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cntr_no",     false,          "",      dfNone ,     0,     true,   true,     30     );

                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "bkg_no",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "bkg_no_split",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "bkg_knt",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "bl_no",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "bl_no_tp",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "bl_no_chk",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cnmv_yr",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "flg",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cntr_tpsz_cd",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "vr_seq",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "cntr_svr_id",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "svr_id",     false,          "",      dfNone ,     0,     true,   true,     30     );

                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "mvmt_edi_tp_cd",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "mvmt_edi_msg_area_cd",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "mvmt_edi_msg_yrmondy",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "mvmt_edi_msg_seq",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "vvd_cd",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "ctrt_seq",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "lst_flg",     false,          "",      dfNone ,     0,     true,   true,     30     );
                     InitDataProperty(0, cnt++ , dtHidden,      160,    daCenter,  false,     "crnt_skd_dir_cd",     false,          "",      dfNone ,     0,     true,   true,     30     );

                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "upd_locl_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
                     // 영문자만 입력하기
                     InitDataValid(0, "cnmv_co_cd"      , vtEngUpOnly);
                     InitDataValid(0, "mvmt_sts_cd"     , vtEngUpOnly);
                     InitDataValid(0, "mvmt_cre_tp_cd"  , vtEngUpOnly);
                     InitDataValid(0, "org_yd_cd"       , vtEngUpOther, "1234567890");
                     InitDataValid(0, "dest_yd_cd"      , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_id"         , vtEngUpOther, "1234567890");
                     InitDataValid(0, "vndr_seq"        , vtEngUpOther, "1234567890");
                     InitDataValid(0, "mvmt_trsp_mod_cd", vtEngUpOther, "1234567890");
                     InitDataValid(0, "chss_no"         , vtEngUpOther, "1234567890");
                     InitDataValid(0, "mgst_no"         , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_seal_no"    , vtEngUpOther, "1234567890");
                     InitDataValid(0, "wbl_no"          , vtEngUpOther, "1234567890");
                     InitDataValid(0, "pkup_no"         , vtEngUpOther, "1234567890");
                     InitDataValid(0, "ofc_cd"          , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cnmv_cyc_no"     , vtNumericOnly);

                     ToolTipOption="balloon:true;width:420;backcolor:#ffffff;forecolor:#14358B;icon:0;title:";

                     PlusChar2Encoding = true;
                     CountPosition =	0;
                     FrozenCols = 9;
                     SelectHighLight = false;

                }
                 break;



         }
     }

     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObjects[0].WaitImageVisible = false;
 				    sheetObjects[1].WaitImageVisible = false;
	 			 	ComOpenWait(true);
				    var sXml = sheetObj.GetSearchXml("EES_CGM_1109GS.do" , FormQueryString(formObj));
	        		var arrXml = sXml.split("|$$|");

		          	sheetObjects[0].LoadSearchXml(arrXml[0]);

		          	sheetObjects[1].LoadSearchXml(arrXml[1]);



		          	lastCnt = sheetObjects[1].LastRow;
                    //sheetObjects[0].SelectRow(lastCnt);
                    sheetObjects[1].SelectCell(lastCnt, 'del_chk', true);
                    sheetObjects[0].SelectCell(sheetObjects[0].LastRow, 1);
                   	if (sheetObjects[1].LastRow > 1) {
                    		sheetObjects[1].CellValue2(sheetObjects[1].LastRow, "lst_flg") = "1";
                    		sheetObjects[1].RowStatus(sheetObjects[1].LastRow) = "";
                    	}

                   	ComOpenWait(false);
                   	sheetObjects[0].WaitImageVisible = true;
 				    sheetObjects[1].WaitImageVisible = true;
				}
	          	break;

			case IBSAVE:
			   if(validateForm(sheetObj,formObj,sAction)){

				   formObj.f_cmd.value = MULTI;
				   queryString = "f_cmd=" + MULTI ;
				   var params = sheetObj.GetSaveString(true);
				   if(sheetObj.DoSave("EES_CGM_1109GS.do",queryString + "&" + ComGetPrefixParam(""))){

				   }
			   }
			   break;

         }
     }


/**
 * Object ��cntr_onkeypress
 * @param
 * @return �
 * @author
 * @version 2009.05.20
 */
 function obj_focusout() {
// 	frmObj = document.form;
// 	cntrno = frmObj.p_cntrno.value;
// 	if (cntrno.length < 10) return;
// 	frmObj.check_digit.value = "";
//
// 	var sheetObj = sheetObjects[0];
// 	frmObj.f_cmd.value = SEARCH10;
// 	xml = sheetObj.GetSearchXml ("CTMCommonGS.do", FormQueryString(frmObj));
// 	rtnValue = ComGetEtcData(xml, "rtnValue");
// 	if (rtnValue == null) sheetObj.LoadSearchXml(xml);
// 	parseCTNRNo(rtnValue, frmObj);
 }


     /**
      *
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             switch(sAction) {
             	case IBSEARCH:      //조회
             	     if(formObj.p_cntrno.value==""  ){
             	    	 ComShowCodeMessage('CGM10009','Container No');
             	    	 return false;
             	     }
	             	 if(formObj.check_digit.value==""  ){
	        	    	 ComShowCodeMessage('CGM10009','Container No');
	        	    	 return false;
	        	     }
             	     break;
             	case IBSAVE:       //저장
                    sheetObj.Redraw = false;
                    for (var i=1; i<=sheetObj.rowCount; i++) {
                        sheetObj.RowStatus(i) = "R";
                        if (sheetObj.CellValue(i, "del_chk") != "1") {
                            sheetObj.RowStatus(i) = "R";
                        } else {
                            if (sheetObj.CellValue(i, "del_chk") == "1" && (sheetObj.CellValue(i, "cnmv_rmk")=="" || sheetObj.CellValue(i, "cnmv_rmk") == sheetObj.CellValue(i, "crnt_skd_dir_cd"))) {
                                sheetObj.Redraw = true;
                                ComShowCodeMessage('CGM10080');
                                sheetObj.SelectCell(i, 33, true);
                                return false;
                            } else { 
                            	ComOpenWait(true);
                                sheetObj.RowStatus(i) = "U";
                            }
                        }
                    }
                    sheetObj.Redraw = true;
                    ComOpenWait(false);
                    break;
             }
         }

         return true;
     }




      /**
 	  * XML 파싱
 	  */
 	 function parseCTNRNo(CTNRNO, formObj) {
 		if (!CTNRNO) return;
 		var CtnrVal = CTNRNO.split("|");
 		if (CtnrVal.length >= 3) {
 			if (formObj.check_digit) {
 				formObj.check_digit.value = CtnrVal[0].substring(10,11);
 			}
 			if (formObj.ctnr_sts_cd) {
 				formObj.ctnr_sts_cd.value = CtnrVal[1];
 			}
 			if (formObj.ctnr_tpsz_cd) {
 				formObj.ctnr_tpsz_cd.value = CtnrVal[2];
 			}
 		} else {
 			if (formObj.check_digit) {
 				formObj.check_digit.value = "";
 			}
 			if (formObj.ctnr_sts_cd) {
 				formObj.ctnr_sts_cd.value = "";
 			}
 			if (formObj.ctnr_tpsz_cd) {
 				formObj.ctnr_tpsz_cd.value = "";
 			}
 		}
 	}

      /**
       * Object ��Keypress �  <br>
       *  ��dataformat  .  <br>
       * @param
       * @return
       * @author
       * @version 2009.05.20
       */
      function obj_keypress(){
     	 obj = event.srcElement;
     	 if(obj.dataformat == null) return;

     	 window.defaultStatus = obj.dataformat;
     	 switch(obj.dataformat) {

     	 case "eng":
     		if(event.keyCode == 13) {doActionIBSheet(IBSEARCH);}
   	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
   	        else ComKeyOnlyAlphabet('uppernum');
   	        break;
     	 }
      }

      /**
       *
       * @return
       */
      function obj_keyup(){
	    	 var formObj = document.form;
	    	 var sheetObj = sheetObjects[0];
	    	 obj = event.srcElement;
	    	 switch(obj.name){
	    	 	case "p_cntrno":

     	    	frmObj = document.form;
     	    	//alert("sss");
     	    	cntrno = frmObj.p_cntrno.value;
     	    	if (cntrno.length == 10) {
     	    	frmObj.check_digit.value = "";

     	    	var sheetObj = sheetObjects[0];
     	    	frmObj.f_cmd.value = SEARCH10;
     	    	xml = sheetObj.GetSearchXml ("CTMCommonGS.do", FormQueryString(frmObj));
     	    	rtnValue = ComGetEtcData(xml, "rtnValue");
     	    	if (rtnValue == null) sheetObj.LoadSearchXml(xml);
     	    	parseCTNRNo(rtnValue, frmObj);
     	    	}
     	    	break;
	    	 }
	    }

   /**
    *  체인지 전에 갑 저장
    * @param sheetObj
    * @param Row
    * @param Col
    * @return
    */
   function sheet2_OnBeforeEdit(sheetObj, Row, Col)
   {
  	 OrgValue = sheetObj.CellText(Row, Col);
   }

   	function sheet2_OnChange(sheetObj, Row, Col){
         var formObj = document.form;
         var chk      = true;
    	 switch (sheetObj.ColSaveName(Col)) {

      	 case "chss_no" :

			   	var cellValue = sheetObj.cellValue(Row, Col);

			   	if(sheetObj.CellValue(Row, "chss_no")!="")
			   	{

				   	formObj.eq_no.value = sheetObj.CellValue(Row, "chss_no");
				   	formObj.chss_no.value = sheetObj.CellValue(Row, "chss_no");
				   	formObj.eq_knd_cd.value = "Z";
				   	formObj.cntr_no.value = sheetObj.CellValue(Row, "cntr_no");
					formObj.from_dt.value = sheetObj.CellValue(Row, "cnmv_evnt_dt");
					formObj.eq_tpsz_cd.value = sheetObj.CellValue(Row, "cntr_tpsz_cd");
					formObj.cntr_tpsz.value = sheetObj.CellValue(Row, "cntr_tpsz_cd");

					sheetObj.CellValue(Row, "del_chk") = "1";
					if(Row == sheetObj.rowCount){
						formObj.to_dt.value = "";
					} else {
						formObj.to_dt.value = sheetObj.CellValue(Row+1, "cnmv_evnt_dt");
					}

					formObj.f_cmd.value = SEARCH02;
			    	var sXml2 = sheetObj.GetSearchXml("EES_CGM_1109GS.do" , FormQueryString(formObj));
				    var dataCount2 = ComGetTotalRows(sXml2);
				    if(dataCount2 > 0){
				    	if(DomXml2String(sXml2,"aciac_div_cd")=="I"){
				    		if(ComShowCodeConfirm("CGM10076"),sheetObj.CellValue(Row, "chss_no")){
				    			changeColor(sheetObj, i);

							} else {
								sheetObj.CellValue2(Row, "chss_no") = OrgValue;
								sheetObj.CellValue(Row, "del_chk") = "0";
								return;
							}
				    	}

				    	if(DomXml2String(sXml2,"tpsz_check")!="OK"){
				    		ComShowCodeMessage("CGM20030");
				    		sheetObj.CellValue(Row, "del_chk") = "0";
				    		sheetObj.CellValue2(Row, "chss_no") = OrgValue;
				    		return;
				    	}
				    } else {
				    	if(ComShowCodeConfirm("CGM10076")){
				    		changeColor(sheetObj, i);
						} else {
							sheetObj.CellValue(Row, "del_chk") = "0";
							sheetObj.CellValue2(Row, "chss_no") = OrgValue;
							return;
						}
				    }

				    formObj.f_cmd.value = SEARCH01;
			   		var sXml = sheetObj.GetSearchXml("EES_CGM_1109GS.do" , FormQueryString(formObj));
				    var dataCount = ComGetTotalRows(sXml);

				    if(dataCount > 0){

				    	if(DomXml2String(sXml,"chk")!="OK"){
				    		ComShowCodeMessage("CGM10078");
				    		sheetObj.CellValue(Row, "del_chk") = "0";
				    		sheetObj.CellValue2(Row, "chss_no") = OrgValue;
				    		return;
				    	}
				    	return;
				   	}



			   	} else {
			   		if(sheetObj.CellValue(Row, "chss_no") != sheetObj.CellValue(Row, "chss_no_2")){
			   			changeColor(sheetObj, i);
			   			sheetObj.CellValue(Row, "del_chk") = "1";
			   		}
			   	}

			   	break;
          case "mgst_no" :
        	    formObj.f_cmd.value = SEARCH;
	  		   	formObj.eq_no.value =sheetObj.CellValue(Row, "mgst_no");
	  			formObj.chss_no.value = sheetObj.CellValue(Row, "mgst_no");
	  		   	formObj.eq_knd_cd.value = "G";
	  			formObj.cntr_no.value = sheetObj.CellValue(Row, "cntr_no");
				formObj.from_dt.value = sheetObj.CellValue(Row, "cnmv_evnt_dt");
				formObj.eq_tpsz_cd.value = sheetObj.CellValue(Row, "cntr_tpsz_cd");
				if(Row == sheetObj.rowCount){
					formObj.to_dt.value = "";
				} else {
					formObj.to_dt.value = sheetObj.CellValue(Row+1, "cnmv_evnt_dt");
				}
	  		   	var cellValue = sheetObj.cellValue(Row, Col);
	  		    sheetObj.CellValue(Row, "del_chk") = "1";
	  		   	if(sheetObj.CellValue(Row, "mgst_no")!="")
	  		   	{

  			   		var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do", FormQueryString(formObj));
  				    var dataCount = ComGetTotalRows(sXml);
  				    //
  				    if(dataCount > 0){
  				    	if(DomXml2String(sXml,"aciac_div_cd")=="I"){
  				    		if(ComShowCodeConfirm("CGM10077")){

  				    			changeColor(sheetObj, i);

							} else {
								sheetObj.CellValue(Row, "del_chk") = "0";
								sheetObj.CellValue2(Row, "mgst_no") = OrgValue;
								return;
							}

  				    	} else {
  				    		sheetObj.CellValue(Row, "eq_tpsz_cd") = ComGetEtcData(sXml,"eq_tpsz_cd");
  				    	}

  				   	} else {
  				   		ComShowCodeMessage('CGM10077');
						sheetObj.CellValue(Row, "del_chk") = "0";
						sheetObj.CellValue2(Row, "mgst_no") = OrgValue;
						return;

  				   }

  				   formObj.f_cmd.value = SEARCH01;
			   		var sXml = sheetObj.GetSearchXml("EES_CGM_1109GS.do" , FormQueryString(formObj));
				    var dataCount = ComGetTotalRows(sXml);

				    if(dataCount > 0){
				    	ComShowCodeMessage('CGM10078');
				    	sheetObj.CellValue(Row, "del_chk") = "0";
				    	sheetObj.CellValue2(Row, "mgst_no") = OrgValue;
				    	return;
				   	}

	  		   	}
	  		   	break;
      	}
     }


   	 function sheet2_OnSaveEnd(sheetObj, errMsg) {
   		 if(errMsg =='') {
   			 ComShowCodeMessage('CGM00003');
   	    	 var sheetObject1 = sheetObjects[0];

   			 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
   		 }
   	 }


   	/**
   	 * 변경 추가된 라인의 배경 색 변경
   	 * param : sheetObj ==> 시트오브젝트, Row ==> Sheet Object의 라인 번호
   	 * 현재 선택된 라인의 색을 연두색으로 변경한다
   	 */
   	function changeColor(sheetObj, Row) {

//   		sheetObj.RowBackColor(Row) = sheetObj.RgbColor(124,252,0);
sheetObj.RowBackColor(Row) = sheetObj.RgbColor(0,0,0);
   	//alert (Row + "::::" + sheetObj.RowStatus(Row))
   		// A/F가 C가 아니면 N으로 변경한다.
   		Sts = sheetObj.CellValue(Row, 5);
//   		alert(Sts);
   		nowStatus = sheetObj.RowStatus(Row);
   		if (Sts != 'C' && Sts != '' && Sts != 'M') sheetObj.CellValue(Row, 5) = 'N';
   		if (nowStatus == 'I' || nowStatus == 'D') return;
   		else sheetObj.RowStatus(Row) = "U";

   	 }


    /**
     * 기능(ex:btn_save)에 권한(trole) 적용  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2010.03.05
     */
    function tRoleApply() {
        var formObj = document.form;
        if (formObj.trole.value == "Authenticated") {
        } else {
//            ComBtnDisable("btn_save");
        }
    }