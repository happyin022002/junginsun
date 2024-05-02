/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1066.js
*@FileTitle : Pick up No Notice Manual Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.27 박미옥
* 1.0 Creation
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
     * @class esm_bkg_1066 : esm_bkg_1066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1066() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var receiverList = new Array();

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "img_dt":
    	        ComSetObjValue(formObject.sch_tp_cd, "ATA");
    	        setMandantorySearchType();
    	        var cal = new ComCalendarFromTo();
    		    cal.select(formObject.dt_s, formObject.dt_e, 'yyyy-MM-dd');
                break;
            
            case "img_mvmt_dt":
    	        ComSetObjValue(formObject.sch_tp_cd, "MVMT");
    	        setMandantorySearchType();
    	        var cal = new ComCalendarFromTo();
    		    cal.select(formObject.dt_mvmt_s, formObject.dt_mvmt_e, 'yyyy-MM-dd');
                break;
            	
            case "btn_Retrieve":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            
            case "btn_New":
            	doActionIBSheet(sheetObject1,formObject,IBRESET);
            	break;

            case "btn_PickUpNoUpload":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC13);
            	break;
            	
            	
            case "btn_Save":
            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;
             
            case "btn_StopSend":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC11);
            	break;
            	
            case "btn_ResumeSend":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC12);
            	break;
            	
            case "btn_Fax":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
                break;

            case "btn_Email":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
                break;
                
            case "btn_Preview":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC03);            	
                break;
             
            case "btn_ManualSetup":
            	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0993.do', 1006, 440, "", "none", true);
            	break;

            case "btn_DownExcel":
            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
            	break;
            	
            case "btn_SendHistory":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC04);
            	break;            	
            	
//            case "btn_DataSetup":
//            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC07);
//            	break;
            	
            case "btn_ReceiverSetup":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC05);
            	break;
            	
            case "btn_FormSetup":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC08);
            	break;            

            case "btn_CustomerInfo":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC09);
            	break;
            	
            case "btn_MasterData":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC10);
            	break;
            	
            case "btn_MultiContact":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC14);
            	break;
            	
            case "btn_RailAMSHistory":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC15);
            	break;
            	
            case "btn_UsIor":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC16);
            	break;
            	
             } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
   function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
   }


   /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
    * 
    * @return 없슴
    */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }       
         
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        // 2017.10.20 팩스 전송 안된게 처리
        tabObjects[0].TabEnable(1) = false;
        
        initControl();

        if (document.form.bl_no.value != "") {
            initForm("BL");
        } else {
            initForm();
        }
        
    	if (document.form.bl_no.value != "" && ComGetObjValue(document.form.sch_tp_cd) == "BL") {
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }

     
    /**
     * Form 데이터 초기화 작업. 화면 Open 초기값을 설정한다.
     *
     * @param {string} flag 필수. 구분자
     * @return 없슴
     */
    function initForm(flag) {
		with(document.form) {
	        var endDay = ComGetDateAdd(endDay, "D", 6, "-");
	        var startDay = ComGetNowInfo("ymd", "-");        
            dt_s.value = startDay;
            dt_e.value = endDay;
            dt_mvmt_s.value = startDay;
            dt_mvmt_e.value = endDay;
            tm_mvmt_s.value = "00:00";
            tm_mvmt_e.value = "23:59";
            mvmt_cd.value   = "";
		
            dt_tp_cd.value   = "SENT";
			eq_ofc_cd.value  = "";
			upd_usr_id.value = "";
		    snd_sts_cd.value = "";
		    ntc_tp_cd.value  = "";
		    foc_tp_cd.value  = "";
		    rail_co_cd.value = "";
		    ow_flag.checked   = false;
		    contact_flag.checked = false;
		    stop_flag.checked = false;
			
            if (flag != null && flag == "BL") {
    		    ComSetObjValue(sch_tp_cd, "BL");
            } else {
    		    bl_no.value      = "";		    
    		    ComSetObjValue(sch_tp_cd, "DATE");
            }
			
			setMandantorySearchType();
			fncEnableFocType(ntc_tp_cd.value);
		}
    }
     
    
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
      	axon_event.addListener("click","obj_click", "sch_tp_cd", "dt_s", "dt_e", "bl_no", "mvmt_cd", "dt_mvmt_s", "dt_mvmt_e", "tm_mvmt_s", "tm_mvmt_e");
      	axon_event.addListener("blur","obj_deactivate", "dt_s", "dt_e", "dt_mvmt_s", "dt_mvmt_e", "tm_mvmt_s", "tm_mvmt_e");
      	axon_event.addListener("keydown","ComKeyEnter", "dt_tp_cd", "dt_s", "dt_e",  
      			"mvmt_cd", "dt_mvmt_s", "dt_mvmt_e", "tm_mvmt_s", "tm_mvmt_e", "rail_co_cd",
      			"eq_ofc_cd", "upd_usr_id", "bl_no", "snd_sts_cd", "ntc_tp_cd", "foc_tp_cd");
      	axon_event.addListener("change","obj_change", "ntc_tp_cd");
    }


    /**
     * Click 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_click() {
    	var formObject = document.form;
    	 
    	switch(event.srcElement.name) {
    	case "sch_tp_cd":
    		setMandantorySearchType();
    		break;
     	case "dt_s":
     	case "dt_e":
     		ComSetObjValue(formObject.sch_tp_cd, "DATE");
     		setMandantorySearchType();
     		break;
     	case "mvmt_cd":
     	case "dt_mvmt_s":
     	case "dt_mvmt_e":
     	case "tm_mvmt_s":
     	case "tm_mvmt_e":
       		ComSetObjValue(formObject.sch_tp_cd, "MVMT");
      		setMandantorySearchType();
     		break;
     		
     	case "bl_no":
     		ComSetObjValue(formObject.sch_tp_cd, "BL");
     		setMandantorySearchType();
     		break;
    	}
    }
    
    
    
    /**
     * Blue 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_deactivate() {
        switch(event.srcElement.name) {
            case "dt_s":
            case "dt_e":
            case "dt_mvmt_s":
            case "dt_mvmt_e":
            case "tm_mvmt_s":
            case "tm_mvmt_e":
                ComChkObjValid(event.srcElement);
                break;
        }
    }

    
    /**
     * Change 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_change() {
   	    switch(event.srcElement.name) {
            case "ntc_tp_cd":
            	fncEnableFocType(event.srcElement.value);          
            	break;
   	    }
    }
    
    
    /**
    * FOC 검색조건을 Enable/Disable 처리한다.<br>
    * 
    * @param {string} val 필수. 구분자(Sent Type 값)
    * @return 없슴
    */
    function fncEnableFocType(val) {
    	with (document.form) {
            if (val == "FC" || val == "TO") {
            	foc_tp_cd.disabled = false;
            } else {
            	foc_tp_cd.disabled = true;
            	foc_tp_cd.value = "";
            }
    	}
    }
     
 
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

     
    /**
     * Tab 기본 설정 <br>
     * 탭의 항목을 설정한다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    tabNo  필수, Tab 오브젝트 일련번호
     * @return 없슴
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Pick up Data" , -1 );
                    InsertTab( cnt++ , "Fax" , -1 );
                    InsertTab( cnt++ , "E-Mail" , -1 );
                }
                 
                break;
        }
    }

     
    /**
     * Tab 클릭시 이벤트 관련 <br>
     * 선택한 탭의 요소가 활성화 된다.<br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    nItem  필수, Tab 오브젝트 일련번호
     * @return 없슴
     */
    function tab1_OnChange(tabObj , nItem)
    {
     	//var btnObj = document.getElementById("btn_Setup");
        with (sheetObjects[0]) {
 	        switch(nItem) {
 	            case 0:
 	            	 
 	            	ComBtnDisable("btn_ReceiverSetup");
 	            	ComBtnDisable("btn_Fax");
 	            	ComBtnDisable("btn_Email");
 	            	 
 	            	ColHidden("rail_lod_dt")          = false; 	            	
 	            	ColHidden("pkup_aval_dt")         = false;
 	            	ColHidden("lst_free_dt")          = false;
 	            	ColHidden("pkup_yd_cd")           = false; 
 	            	ColHidden("rtn_yd_cd")            = false; 
 	            	ColHidden("pkup_no_upld_dt")      = false;
 	            	ColHidden("pkup_no_upld_via")     = false;
 	            	ColHidden("pkup_no_upld_usr_id")  = false;
 	            	ColHidden("pod_cd")               = false;
 	            	ColHidden("ibd_trsp_hub_cd")      = false;
 	            	ColHidden("del_cd")               = false;
 	            	ColHidden("nvocc_file_no")        = false;
 	            	ColHidden("de_term_cd")           = false;
 	            	ColHidden("dor_trkr_wo_flg")      = false;
 	            	ColHidden("rout_gid_desc")        = false;
 	            	ColHidden("vvd_id")               = false;
           	
 	            	ColHidden("over_wgt_flg")         = true;
 	            	ColHidden("cntr_wgt")             = true;
 	            	ColHidden("sn")                   = true;
 	            	ColHidden("bkg_cust_tp_cd")       = true;
 	            	ColHidden("cust_cd")              = true;
 	            	ColHidden("cust_nm")              = true;
 	            	ColHidden("pkup_ntc_fom_cd_show") = true;
 	            	ColHidden("bl")                   = true;
 	            	 	            	
 	            	ColHidden("eclz_obl_cpy_flg")     = true; 	            	
 	            	ColHidden("mnl_flg_show")         = true;
 	            	ColHidden("c1_fax_no_chk")        = true;
 	            	ColHidden("c1_fax_no")            = true;
 	            	ColHidden("c2_fax_no_chk")        = true;
 	            	ColHidden("c2_fax_no")            = true;
 	            	ColHidden("b1_fax_no_chk")        = true;
 	            	ColHidden("b1_fax_no")            = true;
 	            	ColHidden("b2_fax_no_chk")        = true;
 	            	ColHidden("b2_fax_no")            = true;
 	            	ColHidden("an_fax_no_chk")        = true;
 	            	ColHidden("an_fax_no")            = true;
 	            	ColHidden("fax_snd_dt")           = true;
 	            	                                   
 	            	ColHidden("c1_ntc_eml_chk")       = true;
 	            	ColHidden("c1_ntc_eml")           = true;
 	            	ColHidden("c2_ntc_eml_chk")       = true;
 	            	ColHidden("c2_ntc_eml")           = true;
 	            	ColHidden("b1_ntc_eml_chk")       = true;
 	            	ColHidden("b1_ntc_eml")           = true;
 	            	ColHidden("b2_ntc_eml_chk")       = true;
 	            	ColHidden("b2_ntc_eml")           = true;
 	            	ColHidden("an_ntc_eml_chk")       = true;
 	            	ColHidden("an_ntc_eml")           = true;
 	            	ColHidden("eml_snd_dt")           = true;

 	            	ColHidden("diff_rmk")             = true;

 	            	break;
 	            	 
 	            	 
 	            	 
 	             case 1:

 	            	 ComBtnEnable("btn_ReceiverSetup");
 	            	// 2017.10.20 팩스 전송 안된게 처리
// 	            	 ComBtnEnable("btn_Fax");
 	            	 ComBtnDisable("btn_Email");

 	            	 ColHidden("rail_lod_dt")          = true; 	            	
 	            	 ColHidden("pkup_aval_dt")         = true;
 	            	 ColHidden("lst_free_dt")          = true;
 	            	 ColHidden("pkup_yd_cd")           = true; 
 	            	 ColHidden("rtn_yd_cd")            = true; 
 	            	 ColHidden("pkup_no_upld_dt")      = true;
 	            	 ColHidden("pkup_no_upld_via")     = true;
 	            	 ColHidden("pkup_no_upld_usr_id")  = true;
 	            	 ColHidden("pod_cd")               = true;
 	            	 ColHidden("ibd_trsp_hub_cd")      = true;
 	            	 ColHidden("del_cd")               = true;
 	            	 ColHidden("nvocc_file_no")        = true;
 	            	 ColHidden("de_term_cd")           = true;
 	            	 ColHidden("dor_trkr_wo_flg")      = true;
 	            	 ColHidden("rout_gid_desc")        = true;
 	            	 ColHidden("vvd_id")               = true;
           	
 	            	 ColHidden("over_wgt_flg")         = false;
 	            	 ColHidden("cntr_wgt")             = false;
 	            	 ColHidden("sn")                   = false;
 	            	 ColHidden("bkg_cust_tp_cd")       = false;
 	            	 ColHidden("cust_cd")              = false;
 	            	 ColHidden("cust_nm")              = false;
 	            	 ColHidden("pkup_ntc_fom_cd_show") = false;
 	            	 ColHidden("bl")                   = false;
 	            	 	            	
   	            	 ColHidden("eclz_obl_cpy_flg")     = false;
   	            	 ColHidden("mnl_flg_show")         = false;
 	            	 ColHidden("c1_fax_no_chk")        = false;
 	            	 ColHidden("c1_fax_no")            = false;
 	            	 ColHidden("c2_fax_no_chk")        = false;
 	            	 ColHidden("c2_fax_no")            = false;
 	            	 ColHidden("b1_fax_no_chk")        = false;
 	            	 ColHidden("b1_fax_no")            = false;
 	            	 ColHidden("b2_fax_no_chk")        = false;
 	            	 ColHidden("b2_fax_no")            = false;
 	            	 ColHidden("an_fax_no_chk")        = false;
 	            	 ColHidden("an_fax_no")            = false;
 	            	 ColHidden("fax_snd_dt")           = false;
 	            	                                   
 	            	 ColHidden("c1_ntc_eml_chk")       = true;
 	            	 ColHidden("c1_ntc_eml")           = true;
 	            	 ColHidden("c2_ntc_eml_chk")       = true;
 	            	 ColHidden("c2_ntc_eml")           = true;
 	            	 ColHidden("b1_ntc_eml_chk")       = true;
 	            	 ColHidden("b1_ntc_eml")           = true;
 	            	 ColHidden("b2_ntc_eml_chk")       = true;
 	            	 ColHidden("b2_ntc_eml")           = true;
 	            	 ColHidden("an_ntc_eml_chk")       = true;
 	            	 ColHidden("an_ntc_eml")           = true;
 	            	 ColHidden("eml_snd_dt")           = true;

 	            	 ColHidden("diff_rmk")             = false;

 	            	 break;

 	            	 
 	            	 
 	             case 2:
                     ComBtnEnable("btn_ReceiverSetup");
 	            	 ComBtnDisable("btn_Fax");
 	            	 ComBtnEnable("btn_Email");

 	            	 ColHidden("rail_lod_dt")          = true; 	            	
 	            	 ColHidden("pkup_aval_dt")         = true;
 	            	 ColHidden("lst_free_dt")          = true;
 	            	 ColHidden("pkup_yd_cd")           = true; 
 	            	 ColHidden("rtn_yd_cd")            = true; 
 	            	 ColHidden("pkup_no_upld_dt")      = true;
 	            	 ColHidden("pkup_no_upld_via")     = true;
 	            	 ColHidden("pkup_no_upld_usr_id")  = true;
 	            	 ColHidden("pod_cd")               = true;
 	            	 ColHidden("ibd_trsp_hub_cd")      = true;
 	            	 ColHidden("del_cd")               = true;
 	            	 ColHidden("nvocc_file_no")        = true;
 	            	 ColHidden("de_term_cd")           = true;
 	            	 ColHidden("dor_trkr_wo_flg")      = true;
 	            	 ColHidden("rout_gid_desc")        = true;
 	            	 ColHidden("vvd_id")               = true;
           	
 	            	 ColHidden("over_wgt_flg")         = false;
 	            	 ColHidden("cntr_wgt")             = false;
 	            	 ColHidden("sn")                   = false;
 	            	 ColHidden("bkg_cust_tp_cd")       = false;
 	            	 ColHidden("cust_cd")              = false;
 	            	 ColHidden("cust_nm")              = false;
 	            	 ColHidden("pkup_ntc_fom_cd_show") = false;
 	            	 ColHidden("bl")                   = false;
 	            	 	            	
   	            	 ColHidden("eclz_obl_cpy_flg")     = false;
   	            	 ColHidden("mnl_flg_show")         = false;
 	            	 ColHidden("c1_fax_no_chk")        = true;
 	            	 ColHidden("c1_fax_no")            = true;
 	            	 ColHidden("c2_fax_no_chk")        = true;
 	            	 ColHidden("c2_fax_no")            = true;
 	            	 ColHidden("b1_fax_no_chk")        = true;
 	            	 ColHidden("b1_fax_no")            = true;
 	            	 ColHidden("b2_fax_no_chk")        = true;
 	            	 ColHidden("b2_fax_no")            = true;
 	            	 ColHidden("an_fax_no_chk")        = true;
 	            	 ColHidden("an_fax_no")            = true;
 	            	 ColHidden("fax_snd_dt")           = true;
 	            	                                   
 	            	 ColHidden("c1_ntc_eml_chk")       = false;
 	            	 ColHidden("c1_ntc_eml")           = false;
 	            	 ColHidden("c2_ntc_eml_chk")       = false;
 	            	 ColHidden("c2_ntc_eml")           = false;
 	            	 ColHidden("b1_ntc_eml_chk")       = false;
 	            	 ColHidden("b1_ntc_eml")           = false;
 	            	 ColHidden("b2_ntc_eml_chk")       = false;
 	            	 ColHidden("b2_ntc_eml")           = false;
 	            	 ColHidden("an_ntc_eml_chk")       = false;
 	            	 ColHidden("an_ntc_eml")           = false;
 	            	 ColHidden("eml_snd_dt")           = false;

 	            	 ColHidden("diff_rmk")             = false;
 	
 	             break;
 	         }
 		
         }

     }

     
    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetObj.id) {

        case "sheet1":
            with (sheetObj) {
            	BasicImeMode = imeEng;
            	Ellipsis = true;
            	
	            // 높이 설정
	            style.height = 360;
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
	
	            var HeadTitle1 = 
		            "||Seq.|bkg No|ntcSeq|Type|MVMT|B/L No.|Cancel|Container|Over|Weight(LBS)|RL|" + 
		            "AVL DT|FRE DT|Pick-up No|Pick-up YD|Flag|Return YD|F|O|C|Customs|" + 
		            "Receive DT|Via|Sender|POD|CLOC|DEL|Filer|Term|Door W/O|Route Guide|VVD|" + 
		            "SN|TP|cntCd|custSeq|Code|Customer Name|formCd|Form|B/L|Verify||" + 	            
	                "CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|" +  
	                "Broker #1|Broker #1|Broker #1|Broker #1|Broker #2|Broker #2|Broker #2|Broker #2|" +  
	                "One Time Only|One Time Only|One Time Only|One Time Only|Sent Date|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|" +  
	                "CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|Broker #1|Broker #1|Broker #1|Broker #1|" +  
	                "Broker #2|Broker #2|Broker #2|Broker #2|One Time Only|One Time Only|One Time Only|One Time Only|Sent Date|Remark(s)|" + 
		            "Send Sts.|Sent DT|Sent ID|Stop Auto Send|Stop ID|Resume Auto Send|Resume ID|FTZ|Direct Delivery||"; 
	            	
	            var headCount = ComCountHeadTitle(HeadTitle1);
	            
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 9, 0, true);

	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
                // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
	            //InitHeadMode(true, false, false, true, false, false);
	            InitHeadMode(true, true, true, true, false,false)
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);

	            
	            //데이터속성            [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,               KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,   true, "ibflag");
                InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,   true, "chk",                   false,          "",     dfNone,         0,              true,            true, -1, false, true, "", true);
                InitDataProperty(0, cnt++ , dtSeq,           35,    daCenter,   true, "seq");                 
                InitDataProperty(0, cnt++ , dtHidden,        90,    daCenter,   true, "bkg_no",                false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        50,    daCenter,   true, "ntc_seq",               false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtCombo,         50,    daCenter,   true, "pkup_ntc_tp_cd",        false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "edi_322_mvmt_cd",       false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          90,    daCenter,   true, "bl_no",                 false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          50,    daCenter,   true, "pkup_ntc_snd_sts_cd",   false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          95,    daCenter,   true, "cntr_no",               false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          50,    daCenter,   true, "over_wgt_flg",          false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          90,     daRight,   true, "cntr_wgt",              false,          "",     dfInteger,      0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "rail_lod_dt",           false,          "",     dfUserFormat2,  0,              false,          false);
                
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "pkup_aval_dt",          false,          "",     dfUserFormat2,  0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "lst_free_dt",           false,          "",     dfUserFormat2,  0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          80,    daCenter,   true, "pkup_no",               false,          "",     dfEngUpKey,     0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          80,    daCenter,   true, "pkup_yd_cd",            false,          "",     dfEngUpKey,     0,              false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        40,    daCenter,   true, "pkup_yd_cd_flg",        false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          80,    daCenter,   true, "rtn_yd_cd",             false,          "",     dfEngUpKey,     0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          20,    daCenter,   true, "frt_clt_flg",           false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          20,    daCenter,   true, "obl_clt_flg",           false,          "",     dfNone,         0,              false,          false);                                                                  
                InitDataProperty(0, cnt++ , dtData,          20,    daCenter,   true, "cstms_clr_flg",         false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "cstms_clr_cd",          false,          "",     dfNone,         0,              false,          false);
                
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "pkup_no_upld_dt",       false,          "",     dfUserFormat2,  0,             false,          false);
                InitDataProperty(0, cnt++ , dtData,          80,    daCenter,   true, "pkup_no_upld_via",      false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          80,    daCenter,   true, "pkup_no_upld_usr_id",   false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "pod_cd",                false,          "",     dfNone,         0,              false,          false);                                                                  
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "ibd_trsp_hub_cd",       false,          "",     dfNone,         0,              false,          false);                                                                                  
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "del_cd",                false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "nvocc_file_no",         false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   true, "de_term_cd",            false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          65,    daCenter,   true, "dor_trkr_wo_flg",       false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          300,   daLeft,     true, "rout_gid_desc",         false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   true, "vvd_id",                false,          "",     dfNone,         0,              false,          false);

                InitDataProperty(0, cnt++ , dtData,          20,    daCenter,   true, "snd_yn",                false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "bkg_cust_tp_cd",        false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "cust_cnt_cd",           false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        50,    daCenter,   true, "cust_seq",              false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   true, "cust_cd",               false,          "",     dfEngUpKey,     0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,         215,      daLeft,   true, "cust_nm",               false,          "",     dfNone,         0,              false,         false);
                InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,   true, "pkup_ntc_fom_cd",       false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtCombo,         75,    daCenter,   true, "pkup_ntc_fom_cd_show",  false,          "",     dfNone,         0,               true,           true);
                InitDataProperty(0, cnt++ , dtCombo,         60,    daCenter,   true, "eclz_obl_cpy_flg",      false,          "",     dfNone,         0,               true,           true);
                                
                InitDataProperty(0, cnt++ , dtCheckBox,      50,    daCenter,   true, "mnl_flg_show",          false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,   true, "mnl_flg",               false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "c1_fax_no_chk",         false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         130,    daCenter,   true, "c1_fax_no",             false,          "",     dfNone,         0,              true,           true,     20);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c1_fax_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c1_fax_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "c2_fax_no_chk",         false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         130,    daCenter,   true, "c2_fax_no",             false,          "",     dfNone,         0,              true,           true,     20);                                                                      
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c2_fax_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c2_fax_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "b1_fax_no_chk",         false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         130,    daCenter,   true, "b1_fax_no",             false,          "",     dfNone,         0,              true,           true,     20);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b1_fax_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b1_fax_snd_flg",        false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "b2_fax_no_chk",         false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         130,    daCenter,   true, "b2_fax_no",             false,          "",     dfNone,         0,              true,           true,     20);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b2_fax_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b2_fax_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "an_fax_no_chk",         false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);                                                                  
                InitDataProperty(0, cnt++ , dtData,         130,    daCenter,   true, "an_fax_no",             false,          "",     dfNone,         0,              true,           true,     20);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "an_fax_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "an_fax_snd_flg",        false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "fax_snd_dt",            false,          "",     dfUserFormat2,  0,             false,          false);                                                                                
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "c1_ntc_eml_chk",        false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         170,      daLeft,   true, "c1_ntc_eml",            false,          "",     dfEngKey,       0,              true,           true,    200);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c1_eml_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c1_eml_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "c2_ntc_eml_chk",        false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         170,      daLeft,   true, "c2_ntc_eml",            false,          "",     dfEngKey,       0,              true,           true,    200);                                                                     
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c2_eml_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "c2_eml_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "b1_ntc_eml_chk",        false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         170,      daLeft,   true, "b1_ntc_eml",            false,          "",     dfEngKey,       0,              true,           true,    200);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b1_eml_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b1_eml_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "b2_ntc_eml_chk",        false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);
                InitDataProperty(0, cnt++ , dtData,         170,      daLeft,   true, "b2_ntc_eml",            false,          "",     dfEngKey,       0,              true,           true,    200);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b2_eml_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "b2_eml_snd_flg",        false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtCheckBox,      20,    daCenter,   true, "an_ntc_eml_chk",        false,          "",     dfNone,         0,              true,           true, -1, false, true, "", false);                                                                 
                InitDataProperty(0, cnt++ , dtData,         170,      daLeft,   true, "an_ntc_eml",            false,          "",     dfEngKey,       0,              true,           true,    200);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "an_eml_ntc_snd_rslt",   false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        20,    daCenter,   true, "an_eml_snd_flg"        ,false,          "",     dfNone,         0,             false,          false);
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "eml_snd_dt",            false,          "",     dfUserFormat2,  0,             false,          false);
                
                InitDataProperty(0, cnt++ , dtData,         150,      daLeft,   true, "diff_rmk",              false,          "",     dfEngKey,       0,             true,            true,    4000);
                InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   true, "snd_sts_desc",          false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true, "snd_dt",                false,          "",     dfUserFormat2,  0,              false,         false);
                InitDataProperty(0, cnt++ , dtData,          80,    daCenter,   true, "snd_usr_id",            false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,         110,    daCenter,   true, "auto_snd_stop_dt",      false,          "",     dfUserFormat2,  0,              false,         false);
                InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   true, "auto_snd_stop_usr_id",  false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,         120,    daCenter,   true, "auto_snd_resm_dt",      false,          "",     dfUserFormat2,  0,              false,         false);
                InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   true, "auto_snd_resm_usr_id",  false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtData,          30,    daCenter,   true, "free_trd_zn_flg",       false,          "",     dfNone,         0,              false,           false);
                InitDataProperty(0, cnt++ , dtData,          90,    daCenter,   true, "dir_de_flg",      	   false,          "",     dfNone,         0,              false,           false);
                InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,   true, "trsp_so_ofc_cty_cd",    false,          "",     dfNone,         0,              false,          false);
                InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,   true, "trsp_so_seq",           false,          "",     dfNone,         0,              false,          false);
                 
                InitDataValid(0, "pkup_yd_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "rtn_yd_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "pkup_no", vtEngUpOther, "0123456789/");
                InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
                
                InitDataValid(0, "c1_fax_no", vtNumericOther, "-");
                InitDataValid(0, "c2_fax_no", vtNumericOther, "-");
                InitDataValid(0, "b1_fax_no", vtNumericOther, "-");
                InitDataValid(0, "b2_fax_no", vtNumericOther, "-");
                InitDataValid(0, "an_fax_no", vtNumericOther, "-");
                
                InitUserFormat2(0, "rail_lod_dt", "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, "pkup_aval_dt", "####-##-##", "-|:" );
                InitUserFormat2(0, "lst_free_dt", "####-##-##", "-|:" );    
                InitUserFormat2(0, "pkup_no_upld_dt", "####-##-## ##:##", "-|:" );                
	            InitUserFormat2(0, "fax_snd_dt", "####-##-## ##:##", "-|:" );
	            InitUserFormat2(0, "eml_snd_dt", "####-##-## ##:##", "-|:" );
	            InitUserFormat2(0, "snd_dt", "####-##-## ##:##", "-|:" );
	            InitUserFormat2(0, "auto_snd_stop_dt", "####-##-## ##:##", "-|:" );
	            InitUserFormat2(0, "auto_snd_resm_dt", "####-##-## ##:##", "-|:" );
	            
	            initDataCombo(0, "pkup_ntc_fom_cd_show", "Event #1|Event #2|Event #3", "EV1|EV2|EV3");
	            initDataCombo(0, "pkup_ntc_tp_cd", "Time|F/O/C|Manual", "PP|FC|MA");
	            initDataCombo(0, "eclz_obl_cpy_flg", "Yes|No", "Y|N");
	            
	            AutoRowHeight = false;
            }
        
            break;
         
        }     
    }

    
    
    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.DataAutoTrim = false;
    	sheetObj.WaitImageVisible = false;

    	switch(sAction) {

    	// Reset
        case IBRESET:
        	sheetObj.RemoveAll();
        	initForm();

        	break;
        
        	
        	
        	// 검색
        case IBSEARCH:
        	if (validateForm(sheetObj,formObj,sAction) == false) break;

        	ComOpenWait(true);

            sheetObj.HeadCheck(0, "chk") = false;

            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_BKG_1066GS.do", FormQueryString(formObj));
            
            ComOpenWait(false);
            
            break;
         
            
            
            // 저장
        case IBSAVE:
            var sXml = "";

            if (validateForm(sheetObj,formObj,sAction) == false) break;
            

            var sParamSheet1 = sheetObj.GetSaveString(false, true, "chk");
            var sParamSheet2 = sheetObj.GetSaveString(false, true, "mnl_flg");

            if (sParamSheet1 == "" && sParamSheet2 == "") {
            	ComShowCodeMessage("BKG00743");
            	break;
            }

            
            ComOpenWait(true);


            // Save
            if (sParamSheet1 != "") {
                formObj.f_cmd.value = MULTI;
                var sParam = FormQueryString(formObj);
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
                
           	    sXml = sheetObj.GetSaveXml("ESM_BKG_1066GS.do", sParam);
           	    if (sParamSheet2 == "") sheetObj.LoadSaveXml(sXml);
           	    
                if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F") {
                    ComOpenWait(false);
                	break;
                }           	    
            }

            
            
       	    // Verify
            if (sParamSheet2 != "") {
                formObj.f_cmd.value = MULTI20;
                sParam = FormQueryString(formObj);

                sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
           	    sXml = sheetObj.GetSaveXml("ESM_BKG_1066GS.do", sParam);
           	    sheetObj.LoadSaveXml(sXml);
            }

            sheetObj.HeadCheck(0, "chk") = false;

            ComOpenWait(false);
	          

			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}

            break;
         

            
        case IBSEARCH_ASYNC01: // Fax 전송
        case IBSEARCH_ASYNC02: // Email 전송        
            if (validateForm(sheetObj,formObj,sAction) == false) break;
            
            ComOpenWait(true);
        
            for(var i=0; i < sheetObj.RowCount; i++) {
            	if(sheetObj.CellValue(i+1, "chk") == "1") {

            		if (sheetObj.CellValue(i+1, "pkup_ntc_fom_cd_show") != "" &&
                			sheetObj.CellValue(i+1, "pkup_ntc_fom_cd") != sheetObj.CellValue(i+1, "pkup_ntc_fom_cd_show")) {
            			sheetObj.CellValue2(i+1, "pkup_ntc_fom_cd") = sheetObj.CellValue(i+1, "pkup_ntc_fom_cd_show");
                	}
            		
            		sheetObj.CellValue2(i+1, "mnl_flg") = sheetObj.CellValue(i+1, "mnl_flg_show") == 1 ? "Y" : "N";
            	}
            }
            
            if (sAction == IBSEARCH_ASYNC01) formObj.f_cmd.value = MULTI01;
            else formObj.f_cmd.value = MULTI02;

            var sParam = FormQueryString(formObj);
            var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
            if (sParamSheet != "") {
                sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
            }

            sheetObj.HeadCheck(0, "chk") = false;

       	    var sXml = sheetObj.GetSaveXml("ESM_BKG_1066GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			
			ComOpenWait(false);

			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
			
            break;
            
        	
            
         // Stop Send
        case IBSEARCH_ASYNC11: 
        	// Resume Send
        case IBSEARCH_ASYNC12: 
            if (validateForm(sheetObj,formObj,sAction) == false) break;

            ComOpenWait(true);
            
            if (sAction == IBSEARCH_ASYNC11) formObj.f_cmd.value = MULTI11;
            else formObj.f_cmd.value = MULTI12;

            var sParam = FormQueryString(formObj);
            var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
            if (sParamSheet != "") {
                sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
            }

            sheetObj.HeadCheck(0, "chk") = false;

        	var sXml = sheetObj.GetSaveXml("ESM_BKG_1066GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			
			ComOpenWait(false);

			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}

            break;
        	
        	
            
        	// Preview
        case IBSEARCH_ASYNC03:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var sRowStr = sheetObj.GetSelectionRows("/");

        	//자바 스크립트 배열로 만들기
        	var arr = sRowStr.split("/");
           	if (arr.length < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	} else if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var vRow = arr[0];

           	if (sheetObj.CellValue(vRow,"ntc_seq") == "") {
           		ComShowCodeMessage("BKG00178");
           		break;
           	}

        	var usr_id          = formObj.usr_id.value;
        	var ofc_cd          = formObj.usr_ofc_cd.value;
        	var bkg_no          = sheetObj.CellValue(vRow, "bkg_no");
        	var ntc_seq         = sheetObj.CellValue(vRow, "ntc_seq");
        	var pkup_ntc_fom_cd = sheetObj.CellValue(vRow, "pkup_ntc_fom_cd_show");
        	var pkup_yd_cd      = sheetObj.CellValue(vRow, "pkup_yd_cd"); 
        	var rtn_yd_cd       = sheetObj.CellValue(vRow, "rtn_yd_cd");
        	var rmk             = sheetObj.CellValue(vRow, "diff_rmk").replace("'","''");;

        	formObj.com_mrdTitle.value = "PickUp Notice";
        	formObj.com_mrdBodyTitle.value = "PickUp Notice";
        	formObj.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_5018.mrd"; 
        	formObj.com_mrdArguments.value = "/rv bkg_no['" + bkg_no + "'] ntc_seq[''] usr_id['" + usr_id + "'] " + 
        	                                 "ofc_cd['" + ofc_cd + "'] p_pkup_ntc_fom_cd['" + pkup_ntc_fom_cd + "'] " + 
        	                                 "p_pkup_yd_cd['" + pkup_yd_cd + "'] p_rtn_yd_cd['" + rtn_yd_cd + "'] p_rmk['" + rmk + "'] form_revise_YN['']";

        	ComOpenRDPopup();

        	break;
        	
        	
        	
            // EXCEL DOWNLOAD
 		case IBDOWNEXCEL:	
     	    if (sheetObj.RowCount == 0) {
    		    ComShowCodeMessage("BKG00109"); 
    	        break;
    	    }

        	sheetObj.SpeedDown2Excel(-1);
        	
            break;

                    	
        	
        	// History
        case IBSEARCH_ASYNC04:
        	
        	var bl_no = "";
        	
     	    if (sheetObj.RowCount > 0) {
         	    var sRowStr = sheetObj.GetSelectionRows("/");

            	//자바 스크립트 배열로 만들기
            	var arr = sRowStr.split("/");
               	if (arr.length < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (arr.length > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}

               	bl_no = sheetObj.CellValue(arr[0], "bl_no");
    	    }

        	var param = "&autoSearchFlg=Y&sch_tp=B&bl_no=" + bl_no;
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0414.do?pgmNo=ESM_BKG_0414' + param, 1024, 680, "", "none", false);
        	            	
        	break;

        	
        	
        	// Data Setup
        case IBSEARCH_ASYNC07:
        	var iCheckRow = sheetObj.CheckedRows("chk");
        	if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	}
        	
        	var resultObj = ComOpenPopupWithTarget('/hanjin/ESM_BKG_1065.do', 450, 250, "", "none", true);
        	if (resultObj != null) {
        		ComOpenWait(true);
        		fncSetInfo(sheetObj, resultObj);
        		ComOpenWait(false);
        	}

        	break;
        	
        	
        	
        	// Receiver Setup
        case IBSEARCH_ASYNC05:
        	if (validateForm(sheetObj,formObj,sAction) == false) break;
        	
        	receiverList = fncGetReceiverInfo();
        	var resultList = ComOpenPopupWithTarget('/hanjin/ESM_BKG_0995.do', 906, 400, "", "none", true);
        	if (resultList != null) {
        		ComOpenWait(true);
            	fncSetReceiverInfo(resultList);
            	ComOpenWait(false);
        	}
        	
        	break;

        	

        	// Form Setup
        case IBSEARCH_ASYNC08:
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1034.do?pgmNo=ESM_BKG_1034', 1020, 650, "", "none", true);
        	break;
        	
        	
        	// Customer Info
        case IBSEARCH_ASYNC09:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var sRowStr = sheetObj.GetSelectionRows("/");

        	//자바 스크립트 배열로 만들기
        	var arr = sRowStr.split("/");
           	if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var param = "&bkg_no=" + sheetObj.CellValue(arr[0], "bkg_no");
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0242.do?pgmNo=ESM_BKG_0242' + param, 570, 380, "", "none", true);
        	break;

        	
        	// Master Data
        case IBSEARCH_ASYNC10:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var sRowStr = sheetObj.GetSelectionRows("/");

        	//자바 스크립트 배열로 만들기
        	var arr = sRowStr.split("/");
           	if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var param = "&autoSearchFlg=Y" +
        		        "&cust_cnt_cd=" + sheetObj.CellValue(arr[0], "cust_cnt_cd") +
        	            "&cust_seq=" + ComLpad(sheetObj.CellValue(arr[0], "cust_seq"),6,"0");
        	
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240' + param, 1024, 670, "", "none", true);
        	break;
        	
        	
        	// Multi-Contact
        case IBSEARCH_ASYNC14:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var sRowStr = sheetObj.GetSelectionRows("/");

        	//자바 스크립트 배열로 만들기
        	var arr = sRowStr.split("/");
           	if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var param = "&cust_cnt_cd=" + sheetObj.CellValue(arr[0], "cust_cnt_cd") +
        	            "&cust_seq=" + ComLpad(sheetObj.CellValue(arr[0], "cust_seq"),6,"0") +
        	            "&cust_nm=" + sheetObj.CellValue(arr[0], "cust_nm");
        	
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1044.do?pgmNo=ESM_BKG_1044' + param, 800, 380, "", "none", true);
        	break;
        	
        	
        	// Rail AMS History
        case IBSEARCH_ASYNC15:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var sRowStr = sheetObj.GetSelectionRows("/");

        	//자바 스크립트 배열로 만들기
        	var arr = sRowStr.split("/");
           	if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var param = "&cntr_no=" + sheetObj.CellValue(arr[0], "cntr_no") +
        	            "&vvd=" + sheetObj.CellValue(arr[0], "vvd_id");
        	
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1037.do?pgmNo=ESM_BKG_1037' + param, 1024, 610, "", "none", true);
        	break;
        	
        	
        case IBSEARCH_ASYNC16:
        	var param = "&eq_ofc_cd=" + formObj.usr_ofc_cd.value;
        	ComOpenPopupWithTarget('/hanjin/ESD_SCE_0056.do?pgmNo=ESD_SCE_0056' + param, 1024, 610, "", "none", true);
        	break;
        	
        	
        	
        	// PickUp No Upload
        case IBSEARCH_ASYNC13:
        	var bl_no = "";
        	
     	    if (sheetObj.RowCount > 0) {
         	    var sRowStr = sheetObj.GetSelectionRows("/");

            	//자바 스크립트 배열로 만들기
            	var arr = sRowStr.split("/");
            	if (arr.length >= 1) {
                   	bl_no = sheetObj.CellValue(arr[0], "bl_no");
            	}
    	    }

        	var param = "&popUp=Y&sch_tp_cd=BL&bl_no=" + bl_no;
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1063.do?pgmNo=ESM_BKG_1063' + param, 1020, 650, "", "none", true);
        	break;
        }
    }
    
	
    /**
     * Sheet1 더블클릭 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @return 없슴
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	with(sheetObj) {
    		// Pickup No 는 더블 클릭 시 보여줌
    		switch (ColSaveName(Col)) {
    		case "diff_rmk":
    			CellEditable(Row, Col) = false;
    			ComShowMemoPad(sheetObj, Row, Col, false, 450,60);
    			CellEditable(Row, Col) = true;
    			break;
    			
    		case "cust_nm":
    	        if(sheetObj.RowHeight(Row) == 20){
    	            sheetObj.RowHeight(Row) = 0;

    	        } else {
    	            sheetObj.RowHeight(Row) = 20;
    	        }
    			
    			break;
    		}
    	}    	
    }


    /**
     * Sheet1 Key Down 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     */
    function sheet1_OnKeyDown(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		switch(ColSaveName(Col)) {
    		case "c1_fax_no":
    		case "c2_fax_no":
    		case "b1_fax_no":
    		case "b2_fax_no":
    		case "an_fax_no":
    		case "c1_ntc_eml":
    		case "c2_ntc_eml":
    		case "b1_ntc_eml":
    		case "b2_ntc_eml":
    		case "an_ntc_eml":
    			CellValue2(Row, "chk")   = 1;
    			CellValue2(Row, (Col - 1)) = 1;
    			break;
    		}
    	}
    }
    

    /**
     * 해당 Row 체크박스 변경이 발생한 경우 해당 Row 의 모든 이메일/팩스 에 대한 체크박스를 체크/언체크 한다. 
     * 단, 체크 처리할 경우 이메일/팩스 정보가 있는 경우에 한한다. 
     * 
     * @param {ibsheet} sheetObj   필수. Sheet ID
     * @param {int}     Row        필수. Sheet Row
     * @param {int}     Col        필수. Sheet Col
     * @param {string}  checkValue 필수. Sheet 셀값
     * @return 없슴
     */
    function fncChangeSubCheckBox(sheetObj, Row, Col, checkValue) {
    	with(sheetObj) {
    		// Check 인 경우 Fax/Email 값이 있는 경우에 한하여 Check
    		if (checkValue == 1) 
    		{
    			//CellValue2(i+1, "mnl_flg_show") = checkValue;
    			
    			// Fax Notice 대상 여부
        		if (CellEditable(Row, "c1_fax_no_chk") && CellValue(Row, "c1_fax_no") != "") CellValue2(Row, "c1_fax_no_chk") = checkValue;
        		if (CellEditable(Row, "c2_fax_no_chk") && CellValue(Row, "c2_fax_no") != "") CellValue2(Row, "c2_fax_no_chk") = checkValue;
        		if (CellEditable(Row, "b1_fax_no_chk") && CellValue(Row, "b1_fax_no") != "") CellValue2(Row, "b1_fax_no_chk") = checkValue;
        		if (CellEditable(Row, "b2_fax_no_chk") && CellValue(Row, "b2_fax_no") != "") CellValue2(Row, "b2_fax_no_chk") = checkValue;
        		if (CellEditable(Row, "an_fax_no_chk") && CellValue(Row, "an_fax_no") != "") CellValue2(Row, "an_fax_no_chk") = checkValue;
        		// Email Notice 대상 여부
        		if (CellEditable(Row, "c1_ntc_eml_chk") && CellValue(Row, "c1_ntc_eml") != "") CellValue2(Row, "c1_ntc_eml_chk") = checkValue;
        		if (CellEditable(Row, "c2_ntc_eml_chk") && CellValue(Row, "c2_ntc_eml") != "") CellValue2(Row, "c2_ntc_eml_chk") = checkValue;
        		if (CellEditable(Row, "b1_ntc_eml_chk") && CellValue(Row, "b1_ntc_eml") != "") CellValue2(Row, "b1_ntc_eml_chk") = checkValue;
        		if (CellEditable(Row, "b2_ntc_eml_chk") && CellValue(Row, "b2_ntc_eml") != "") CellValue2(Row, "b2_ntc_eml_chk") = checkValue;
            	if (CellEditable(Row, "an_ntc_eml_chk") && CellValue(Row, "an_ntc_eml") != "") CellValue2(Row, "an_ntc_eml_chk") = checkValue;
    		} 
    		else 
    		{
        		// Fax Notice 대상 여부
        		CellValue2(Row, "c1_fax_no_chk") = checkValue;
        		CellValue2(Row, "c2_fax_no_chk") = checkValue;
        		CellValue2(Row, "b1_fax_no_chk") = checkValue;
        		CellValue2(Row, "b2_fax_no_chk") = checkValue;
        		CellValue2(Row, "an_fax_no_chk") = checkValue;
        		// Email Notice 대상 여부
        		CellValue2(Row, "c1_ntc_eml_chk") = checkValue;
        		CellValue2(Row, "c2_ntc_eml_chk") = checkValue;
        		CellValue2(Row, "b1_ntc_eml_chk") = checkValue;
        		CellValue2(Row, "b2_ntc_eml_chk") = checkValue;
            	CellValue2(Row, "an_ntc_eml_chk") = checkValue;
    		}
    	}
    }
    
     
     
    /**
    * 체크박스가 변경 된 경우 BL 별로 일괄적으로 체크/언체크 변경한다.
    * @param {ibsheet} sheetObj   필수. Sheet ID
    * @param {int}     Row        필수. Sheet Row
    * @param {int}     Col        필수. Sheet Col
    * @param {string}  checkValue 필수. Sheet 셀값
    * @return
    */
    function fncChangeCheckBoxByBL(sheetObj, Row, Col, checkValue) {

    	with(sheetObj) {
        	var bl_no          = CellValue(Row, "bl_no");
        	var bkg_cust_tp_cd = CellValue(Row, "bkg_cust_tp_cd");
        	
    		for (var i=0; i<RowCount; i++) {
    			// BL 단위별로 메일/팩스 Edit
    			if (CellValue(i+1, "bl_no") == bl_no && CellValue(i+1, "bkg_cust_tp_cd") == bkg_cust_tp_cd) {
    				CellValue2(i+1, "chk") = checkValue;
    				//if (checkValue == 1) CellValue2(i+1, "mnl_flg_show") = checkValue;
    				fncChangeSubCheckBox(sheetObj, i+1, Col, checkValue);
    			}
    		}
    	}
    }

    
    /**
     * Fax/Email 체크박스가 변경 된 경우 BL 별로 일괄적으로 체크/언체크 변경한다.
     * @param {ibsheet} sheetObj   필수. Sheet ID
     * @param {int}     Row        필수. Sheet Row
     * @param {int}     Col        필수. Sheet Col
     * @param {string}  checkValue 필수. Sheet 셀값
     * @return
     */
    function fncChangeSubCheckBoxByBL(sheetObj, Row, Col, checkValue) {

    	with(sheetObj) {
        	var bl_no          = CellValue(Row, "bl_no");
        	var bkg_cust_tp_cd = CellValue(Row, "bkg_cust_tp_cd");
        	
    		for (var i=0; i<RowCount; i++) {
    			// BL 단위별로 메일/팩스 Edit
    			if (CellValue(i+1, "bl_no") == bl_no && CellValue(i+1, "bkg_cust_tp_cd") == bkg_cust_tp_cd) {
    				if (checkValue == 1) CellValue2(i+1, "chk") = checkValue;
    				CellValue2(i+1, Col) = checkValue;
    			}
    		}
    	}
    }
    
    /**
     * 해당 Row 이메일/팩스 변경이 발생한 경우 동일 Customer 에 대하여 이메일/팩스 를 일괄 변경한다. 
     * 단, 체크 처리할 경우 이메일/팩스 정보가 있는 경우에 한한다.
     *  
     * @param {ibsheet} sheetObj   필수. Sheet ID
     * @param {int}     Row        필수. Sheet Row
     * @param {int}     Col        필수. Sheet Col
     * @param {string}  Value      필수. Sheet 셀값
     * @return
     */
    function fncChangeSendInfoByBL(sheetObj, Row, Col, Value) {
    	with(sheetObj) {

			var colName = ColSaveName(Col);
			var bl_no   = CellValue(Row, "bl_no");
        	var bkg_cust_tp_cd = CellValue(Row, "bkg_cust_tp_cd");
        	
			for (var i=0; i<RowCount; i++) {
				// BL 단위별로 메일/팩스 Edit
				if (CellValue(i+1, "bl_no") == bl_no && CellValue(i+1, "bkg_cust_tp_cd") == bkg_cust_tp_cd) {
	    			if (Value != "") CellValue2(i+1, "chk") = 1;
	    			if (Value == "") {
		    			CellValue2(i+1, colName+"_chk") = 0;
	    			} else {
	    				CellValue2(i+1, colName+"_chk") = 1;
	    			}
	    			CellValue2(i+1, colName)        = Value;    					
				}
			}
    	}
    }

     
    /**
     * Sheet1 변경 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	
    	with(sheetObj) {

			var colName = ColSaveName(Col);
			var bl_no   = CellValue(Row, "bl_no");

    		switch (ColSaveName(Col)) {
    		
    		case "chk":
    			fncChangeCheckBoxByBL(sheetObj, Row, Col, Value);
    			break;

            	
    		case "mnl_flg_show":
    			var mnl_flg = "";
    			
    			if (Value == CellSearchValue(Row, Col)) mnl_flg = "";
    			else mnl_flg = Value == 1 ? "Y" : "N";
    			
    			CellValue2(Row, "mnl_flg") = mnl_flg;
    			break;
    			
    			
    		case "c1_fax_no_chk":
    		case "c2_fax_no_chk":
    		case "b1_fax_no_chk":
    		case "b2_fax_no_chk":
    		case "an_fax_no_chk":
    		case "c1_ntc_eml_chk":
    		case "c2_ntc_eml_chk":
    		case "b1_ntc_eml_chk":
    		case "b2_ntc_eml_chk":
    		case "an_ntc_eml_chk":
    			fncChangeSubCheckBoxByBL(sheetObj, Row, Col, Value);
    			break;

    			
    		case "c1_fax_no":
    		case "c2_fax_no":
    		case "b1_fax_no":
    		case "b2_fax_no":
    		case "an_fax_no":
    		case "c1_ntc_eml":
    		case "c2_ntc_eml":
    		case "b1_ntc_eml":
    		case "b2_ntc_eml":
    		case "an_ntc_eml":
    		case "pkup_ntc_fom_cd_show":
    		case "eclz_obl_cpy_flg":
    		case "diff_rmk":
    			fncChangeSendInfoByBL(sheetObj, Row, Col, Value);    			
    			break;    			
    		}
    	}
    }

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(sheetObj) {
        	switch(sAction) {
        	case IBSEARCH:
     	    	if (!ComChkValid(formObj)) return false;
     	    	
            	if(ComGetObjValue(formObj.sch_tp_cd) == "DATE") {
                	if(ComGetDaysBetween(formObj.dt_s.value, formObj.dt_e.value) > 7) {
                		ComShowCodeMessage("BKG40008", "7");
                		ComSetFocus(formObj.dt_s);
                		return false;
                	}
            	}
            	else if(ComGetObjValue(formObj.sch_tp_cd) == "MVMT") {
                	if(ComGetDaysBetween(formObj.dt_mvmt_s.value, formObj.dt_mvmt_e.value) > 7) {
                		ComShowCodeMessage("BKG40008", "7");
                		ComSetFocus(formObj.dt_mvmt_s);
                		return false;
                	}
            	}

        		break;
        		
        		
        		
        	case IBSAVE:
    		    for(var i=0; i <RowCount; i++) {
    		    	if(RowStatus(i+1) == "U") {

    	                // E-mail 형식 체크
    		    		if (CellValue(i+1, "c1_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+1, "c1_ntc_eml")) == false) {
    		    			ComShowCodeMessage("BKG00366");
    		    			SelectCell(i+1, "c1_ntc_eml");
    		    			return false;
    		    		} 

    		    		if (CellValue(i+1, "c2_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+1, "c2_ntc_eml")) == false) {
    		    			ComShowCodeMessage("BKG00366");
    		    			SelectCell(i+1, "c2_ntc_eml");
    		    			return false;
    		    		} 

    		    		if (CellValue(i+1, "b1_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+1, "b1_ntc_eml")) == false) {
    		    			ComShowCodeMessage("BKG00366");
    		    			SelectCell(i+1, "b1_ntc_eml");
    		    			return false;
    		    		} 

    		    		if (CellValue(i+1, "b2_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+1, "b2_ntc_eml")) == false) {
    		    			ComShowCodeMessage("BKG00366");
    		    			SelectCell(i+1, "b2_ntc_eml");
    		    			return false;
    		    		} 

    		    		if (CellValue(i+1, "an_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+1, "an_ntc_eml")) == false) {
    		    			ComShowCodeMessage("BKG00366");
    		    			SelectCell(i+1, "an_ntc_eml");
    		    			return false;
    		    		}  
    		    	}
    		    }
                
        		break;
        		
        		
        		
            	// Fax Send
            case IBSEARCH_ASYNC01:
            	//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
            	var sCheckRow = FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");
            	if (arrRow.length <= 1) {
            		ComShowCodeMessage("BKG00249");
            		return false;
            	}

            	var checked = 0;
        		for (var i=0; i<RowCount; i++) {
        			checked = 0;
        			if (CellValue(i+1, "chk") == "1") {
        				if (CellValue(i+1, "c1_fax_no_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "c1_fax_no") == "") {
        						ComShowCodeMessage("BKG00577");
        						SelectCell(i+1, "c1_fax_no");
        						return false;
        					}
        				}

        				if (CellValue(i+1, "c2_fax_no_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "c2_fax_no") == "") {
        						ComShowCodeMessage("BKG00577");
        						SelectCell(i+1, "c2_fax_no");
        						return false;
        					}
        				}

        				if (CellValue(i+1, "b1_fax_no_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "b1_fax_no") == "") {
        						ComShowCodeMessage("BKG00577");
        						SelectCell(i+1, "b1_fax_no");
        						return false;
        					}
        				}

        				if (CellValue(i+1, "b2_fax_no_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "b2_fax_no") == "") {
        						ComShowCodeMessage("BKG00577");
        						SelectCell(i+1, "b2_fax_no");
        						return false;
        					}
        				}

        				if (CellValue(i+1, "an_fax_no_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "an_fax_no") == "") {
        						ComShowCodeMessage("BKG00577");
        						SelectCell(i+1, "an_fax_no");
        						return false;
        					}
        				}
        				
        				if (checked == 0) {
        					ComShowCodeMessage("BKG40018");
        					return false;
        				}

    	                // 날짜 형식 체크
    		    		if (CellValue(i+1, "pkup_aval_dt") != "" && ComIsDate(CellValue(i+1, "pkup_aval_dt")) == false) {
    		    			ComShowCodeMessage("BKG00921");
    	                	SelectCell(i+1, "pkup_aval_dt");
    	                	return false;
    	                }

    	                if (CellValue(i+1, "lst_free_dt") != "" && ComIsDate(CellValue(i+1, "lst_free_dt")) == false) {
    		    			ComShowCodeMessage("BKG00921");
    	                	SelectCell(i+1, "lst_free_dt");
    	                	return false;
    	                }

//    	                if (CellValue(i+1, "pkup_aval_dt") == "" && CellValue(i+1, "lst_free_dt") == "") {    		    			
//    	                	ComShowCodeMessage("COM12193", "AVL DT or FRE DT");    		    			
//    		    			SelectCell(i+1, "pkup_aval_dt");
//    	                	return false;
//    	                }
    	                
    		    		if (CellValue(i+1, "pkup_aval_dt") != "" && CellValue(i+1, "lst_free_dt") != "") {
    	    			    if (ComGetDaysBetween(CellValue(i+1, "pkup_aval_dt"), CellValue(i+1, "lst_free_dt")) <0) {
        		    			ComShowCodeMessage("BKG40016");
        	                	SelectCell(i+1, "lst_free_dt");
        	                	return false;
    	    			    }
    		    		}
        			}
        		}

        		break;
            	
        		
        		
            	// Email Send
            case IBSEARCH_ASYNC02:
            	//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
            	var sCheckRow = FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");
            	if (arrRow.length <= 1) {
            		ComShowCodeMessage("BKG00249");
            		return false;
            	}
            	
            	var checked = 0;
        		for (var i=0; i<RowCount; i++) {
        			checked = 0;
        			if (CellValue(i+1, "chk") == "1") {
        				if (CellValue(i+1, "c1_ntc_eml_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "c1_ntc_eml") == "" || ComIsEmailAddr(CellValue(i+1, "c1_ntc_eml")) == false) {
        						ComShowCodeMessage("BKG00366");
        						SelectCell(i+1, "c1_ntc_eml");
        						return false;
        		    		} 
        				}

        				if (CellValue(i+1, "c2_ntc_eml_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "c2_ntc_eml") == "" || ComIsEmailAddr(CellValue(i+1, "c2_ntc_eml")) == false) {
        		    			ComShowCodeMessage("BKG00366");
        		    			SelectCell(i+1, "c2_ntc_eml");
        						return false;
        		    		} 
        				}

        				if (CellValue(i+1, "b1_ntc_eml_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "b1_ntc_eml") == "" || ComIsEmailAddr(CellValue(i+1, "b1_ntc_eml")) == false) {
        		    			ComShowCodeMessage("BKG00366");
        		    			SelectCell(i+1, "b1_ntc_eml");
        						return false;
        		    		} 
        				}

        				if (CellValue(i+1, "b2_ntc_eml_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "b2_ntc_eml") == "" || ComIsEmailAddr(CellValue(i+1, "b2_ntc_eml")) == false) {
        		    			ComShowCodeMessage("BKG00366");
        		    			SelectCell(i+1, "b2_ntc_eml");
        						return false;
        		    		} 
        				}

        				if (CellValue(i+1, "an_ntc_eml_chk") == "1") {
        					checked++;
        					if (CellValue(i+1, "an_ntc_eml") == "" || ComIsEmailAddr(CellValue(i+1, "an_ntc_eml")) == false) {
        		    			ComShowCodeMessage("BKG00366");
        		    			SelectCell(i+1, "an_ntc_eml");
        						return false;
        		    		} 
        				}

        				if (checked == 0) {
        					ComShowCodeMessage("BKG40019");
        					return false;
        				}

    	                // 날짜 형식 체크
    		    		if (CellValue(i+1, "pkup_aval_dt") != "" && ComIsDate(CellValue(i+1, "pkup_aval_dt")) == false) {
    		    			ComShowCodeMessage("BKG00921");
    	                	SelectCell(i+1, "pkup_aval_dt");
    	                	return false;
    	                }

    	                if (CellValue(i+1, "lst_free_dt") != "" && ComIsDate(CellValue(i+1, "lst_free_dt")) == false) {
    		    			ComShowCodeMessage("BKG00921");
    	                	SelectCell(i+1, "lst_free_dt");
    	                	return false;
    	                }

//    	                if (CellValue(i+1, "pkup_aval_dt") == "" && CellValue(i+1, "lst_free_dt") == "") {    		    			
//    	                	ComShowCodeMessage("COM12193", "AVL DT or FRE DT");    		    			
//    		    			SelectCell(i+1, "pkup_aval_dt");
//    	                	return false;
//    	                }
    	                
    		    		if (CellValue(i+1, "pkup_aval_dt") != "" && CellValue(i+1, "lst_free_dt") != "") {
    	    			    if (ComGetDaysBetween(CellValue(i+1, "pkup_aval_dt"), CellValue(i+1, "lst_free_dt")) <0) {
        		    			ComShowCodeMessage("BKG40016");
        	                	SelectCell(i+1, "lst_free_dt");
        	                	return false;
    	    			    }
    		    		}
        			}
        		}

        		break;
        		
        		
        		
        		
        		// Stop Send
            case IBSEARCH_ASYNC11: 
            	// Resume Send
            case IBSEARCH_ASYNC12: 
            	//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
            	var sCheckRow = FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");
            	if (arrRow.length <= 1) {
            		ComShowCodeMessage("BKG00249");
            		return false;
            	}
        		
            	break;

            	
            	
        		// Receiver Setup
            case IBSEARCH_ASYNC05:
            	//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
            	var sCheckRow = FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");
            	if (arrRow.length <= 1) {
            		ComShowCodeMessage("BKG00249");
            		return false;
            	}
            	
            	break;
        		
        	}
        }

        return true;
    }
    
    
    /**
     * 수신자 정보 배열 생성한다.<br>
     * 
     * @return array. 수신자 정보 배열
     */
    function fncGetReceiverInfo() {
    	var arrInfo = new Array();
    	var info = null;
    	var idx = 0;

    	with (sheetObjects[0]) {
            for (var i=0; i<RowCount; i++) {
        	    if (CellValue(i+1, "chk") == "0") continue;
        	    
        	    info = new Object();
        	    
        	    info.seq            = CellValue(i+1, "seq");
        	    info.bl_no          = CellValue(i+1, "bl_no");
        	    info.cntr_no        = CellValue(i+1, "cntr_no");
        	    info.cust_nm        = CellValue(i+1, "cust_nm");
        	    info.c2_fax_no      = CellValue(i+1, "c2_fax_no");
        	    info.c2_fax_snd_flg = CellValue(i+1, "c2_fax_snd_flg");
        	    info.b1_fax_no      = CellValue(i+1, "b1_fax_no");
        	    info.b1_fax_snd_flg = CellValue(i+1, "b1_fax_snd_flg");
        	    info.b2_fax_no      = CellValue(i+1, "b2_fax_no");
        	    info.b2_fax_snd_flg = CellValue(i+1, "b2_fax_snd_flg");
        	    info.c2_ntc_eml     = CellValue(i+1, "c2_ntc_eml");
        	    info.c2_eml_snd_flg = CellValue(i+1, "c2_eml_snd_flg");
        	    info.b1_ntc_eml     = CellValue(i+1, "b1_ntc_eml");
        	    info.b1_eml_snd_flg = CellValue(i+1, "b1_eml_snd_flg");
        	    info.b2_ntc_eml     = CellValue(i+1, "b2_ntc_eml");
        	    info.b2_eml_snd_flg = CellValue(i+1, "b2_eml_snd_flg");
        	    
        	    arrInfo[idx++] = info;
            }    	
        }    	
    	
    	return arrInfo;
    }
    
    
    /**
     * 수신자 정보를 변경한다. <br>
     *
     * @param {array} arrInfo 필수 수신자 정보 배열
     */
    function fncSetReceiverInfo(arrInfo) {
    	with (sheetObjects[0]) {
    		
    		var info = null;
    		var vRow = -1;    		
    		for (var i=0; i<arrInfo.length; i++) {
    			info = arrInfo[i];
    			
        		vRow = FindText("seq", info.seq);
        		
        		if (CellValue(vRow, "chk") == "0") {
        			alert("Error!!");
        			return;
        		}

    			// Manual 또는 Sent 상태인 경우 신규 Data 생성이므로 수정 가능
    			if (CellValue(vRow, "pkup_ntc_tp_cd") == "MA" || 
    					CellValue(vRow, "pkup_ntc_snd_sts_cd") == "Y") {
    				CellValue2(vRow, "pkup_ntc_fom_cd_show") = info.fom_cd;
    			}
    			
    			if (CellValue(vRow, "c2_fax_snd_flg") != "N") {
    				CellValue2(vRow, "c2_fax_no")  = info.c2_fax_no;
    				if (CellValue(vRow, "c2_fax_no") == "") CellValue2(vRow, "c2_fax_no_chk") = 0;
    				else CellValue2(vRow, "c2_fax_no_chk") = 1; 
    			}
    			if (CellValue(vRow, "b1_fax_snd_flg") != "N") {
    				CellValue2(vRow, "b1_fax_no")  = info.b1_fax_no;
    				if (CellValue(vRow, "b1_fax_no") == "") CellValue2(vRow, "b1_fax_no_chk") = 0;
    				else CellValue2(vRow, "b1_fax_no_chk") = 1; 
    			}
    			if (CellValue(vRow, "b2_fax_snd_flg") != "N") {
    				CellValue2(vRow, "b2_fax_no")  = info.b2_fax_no;
    				if (CellValue(vRow, "b2_fax_no") == "") CellValue2(vRow, "b2_fax_no_chk") = 0;
    				else CellValue2(vRow, "b2_fax_no_chk") = 1; 
    			}
    			if (CellValue(vRow, "c2_eml_snd_flg") != "N") {
    				CellValue2(vRow, "c2_ntc_eml") = info.c2_ntc_eml;
    				if (CellValue(vRow, "c2_ntc_eml") == "") CellValue2(vRow, "c2_ntc_eml_chk") = 0;
    				else CellValue2(vRow, "c2_ntc_eml_chk") = 1; 
    			}
    			if (CellValue(vRow, "b1_eml_snd_flg") != "N") {
    				CellValue2(vRow, "b1_ntc_eml") = info.b1_ntc_eml;
    				if (CellValue(vRow, "b1_ntc_eml") == "") CellValue2(vRow, "b1_ntc_eml_chk") = 0;
    				else CellValue2(vRow, "b1_ntc_eml_chk") = 1; 
    			}
    			if (CellValue(vRow, "b2_eml_snd_flg") != "N") {
    				CellValue2(vRow, "b2_ntc_eml") = info.b2_ntc_eml;
    				if (CellValue(vRow, "b2_ntc_eml") == "") CellValue2(vRow, "b2_ntc_eml_chk") = 0;
    				else CellValue2(vRow, "b2_ntc_eml_chk") = 1; 
    			}
    		}
    	}
    }

    
    /**
     * 클릭된 로우의 AVL DT, FRE DT, Pick-up YD, Return YD 셋팅 정보를
     * 오브젝트(infoObj) 정보로 일괄 변경한다. 
     * 
     * @param sheetObj
     * @param infoObj
     * @return
     */
    function fncSetInfo(sheetObj, infoObj) {
    	with(sheetObj) {
    		var idx=0;
    		
    		var sRow = FindCheckedRow("chk");
        	var arrRow = sRow.split("|");
       	    for (i=0; i<arrRow.length-1; i++) { 
       	    	
       	    	idx = arrRow[i];
       	    	
    			if (CellValue(idx, "chk") != "1") continue;
    			
    			if (infoObj.avl_dt != "") {
    				CellValue2(idx, "pkup_aval_dt") = infoObj.avl_dt;
    			}
    			
    			if (infoObj.fre_dt != "") {
    				CellValue2(idx, "lst_free_dt") = infoObj.fre_dt;
    			}
    			
    			if (infoObj.pkup_yd_cd != "") {
    				CellValue2(idx, "pkup_yd_cd") = infoObj.pkup_yd_cd;
    			}
    			
    			if (infoObj.rtn_yd_cd != "") {
    				CellValue2(idx, "rtn_yd_cd") = infoObj.rtn_yd_cd;
    			}
       	    }
    	}
    }
    
     
     /**
      * 선택된 필수 조건을 셋팅한다.
      */
     function setMandantorySearchType() {
     	with(document.form) {
     		setNotRequiredObject(dt_s, dt_e, bl_no, dt_mvmt_s, dt_mvmt_e, tm_mvmt_s, tm_mvmt_e);
     		
     		var schVal = ComGetObjValue(sch_tp_cd);    		
    		if (schVal == "DATE") {
     			setRequiredObject(dt_s, dt_e);
         	} else if (schVal == "BL") {
     			setRequiredObject(bl_no);
         	} else if (schVal == "MVMT") {
     			setRequiredObject(dt_mvmt_s, dt_mvmt_e, tm_mvmt_s, tm_mvmt_e);
     		} else {    			
     		}
     	}
     }
     
     /**
      * 필수 검색 조건을 설정한다.
      * 
      * @param [...] 가변 인자
      */
     function setRequiredObject() {
     	for(var i=0; i<arguments.length; i++) {
     		setRequiredMode(arguments[i], true);
     	}
     	
     	if (arguments.length == 1) 
     		arguments[0].focus();
     }

     /**
      * 필수 검색 조건이 아님으로 설정한다.
      * 
      * @param [...] 가변 인자
      * @return
      */
     function setNotRequiredObject() {
     	for(var i=0; i<arguments.length; i++) {
     		setRequiredMode(arguments[i], false);
     	}
     }
     
     /**
      * Object 의 Required 속성을 셋팅한다.
      * 
      * @param obj
      * @param requireMode
      * @return
      */
     function setRequiredMode(obj, requireMode) {    	
     	if (requireMode == true) {
     		obj.setAttribute("required", true);
     	} else {
     		obj.removeAttribute("required");
     	}
     }
     
	/* 개발자 작업  끝 */