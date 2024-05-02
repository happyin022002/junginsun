/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CMS_0311.jsp
*@FileTitle  : Credit customer
*@author     : jklim
*@version    : 1.0
*@since      : 2017/12/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
			   OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class BCM_CMS_0311 : BCM_CMS_0311 on the screen for creating the script defines the task using.
     */
    /** Common global variable */

    function BCM_CMS_0311() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl; 
    	this.doActionIBSheet 		= doActionIBSheet;
		this.obj_keypress_loc       = obj_keypress_loc;
		this.obj_keyup              = obj_keyup;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setTabObject 			= setTabObject;
    	this.initTab                = initTab;
    	this.tab3_OnChange          = tab3_OnChange;
    }

    var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
    var isdoActionIBSheetBeingProcessed=false;
    
    var tabObjects = new Array(); 
    var tabCnt = 0 ; 
    
    var x_sheetObject1 = null;
    var x_sheetObject2 = null; //Auto Invoice
    var x_sheetObject3 = null; //History
    
    /** Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** Event handler processing by button name */
	function processButtonClick() {
/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
		
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		
        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {
	            case "btn_Retrieve":
	            	doActionIBSheet(sheetObject,formObj,SEARCH);
	//				formObj.srep_cd.focus();
					break;
	            case "btn_New":
	            	doActionIBSheet(sheetObject,formObj,IBCLEAR);
	            	formObj.cust_cd.style.backgroundColor="#d4f6ff";
	            	formObj.cust_cd.readOnly=false;
	            	formObj.rfnd_psdo_vndr_flg.disabled = false;
	            	formObj.cust_cd.focus();
	            	break;
	            case "btn_Save":
	            	doActionIBSheet(sheetObject,formObj,MULTI01);
	            	break;
				case "btn_Close":
					self.close();
					break;
				case "t2_btn_t1bAdd":
					x_sheetObject2.DataInsert(-1);   
					break;
	            /*case "btn_Create":
	 				doActionIBSheet(sheetObject,formObj,IBCLEAR);
	 				formObj.creflag.value="Y";
	 				formObj.srep_cd.readOnly=true;
	 				formObj.srep_cd.style.backgroundColor="#bebebe";
	 				formObj.btn_com_ens_043.disabled = true;
	 				formObj.cnt_cd.focus();
	 				break;*/
				case "btn_com_ens_041":
					//if(formObj.creflag.value != "Y"){
					   var param="";
	   	    	  	   //param=param + "&" + "cust_seq=" + form.cust_seq.value+"&mdm_yn="+ formObj.mdm_yn.value;
		    		   ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
					//}
					break;
				case "btn_com_ens_071": // office pop-up
	 				var param="";
	 	    		param=param + "&" + "ofc_cd=" + form.cr_clt_ofc_cd.value;
	 	    		ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
	 				break;
				case "btn_com_ens_072": // office pop-up
	 				var param="";
	 	    		param=param + "&" + "ofc_cd=" + form.kr_ib_ofc_cd.value;
	 	    		ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B6', '1,0,1,1,1,1,1,1', true);
	 				break;
				case "btn_com_ens_n13":
	 				var param="";
	 	    		param=param + "&" + "cr_curr_cd=" + form.cr_curr_cd.value;
	 	    		ComOpenPopup('/hanjin/COM_ENS_N13.do?' + param, 700, 490, 'setCallBack0B4', '1,0,1,1,1,1,1,1', true);
	 	    		break;
				case "btn_com_ens_042":
	  				var param="";
	  	    		param=param + "&" + "act_cust_cd=" + form.act_cust_cd.value;
	  	    		ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 480, 'setCallBack0B5', '1,0,1,1,1,1,1,1', true);
	  	    		break;
	        	case "btn_opn_dt_cal":
	        		var cal = new ComCalendar();
			        cal.select(formObj.cr_st_dt, 'yyyy-MM-dd');         
					break;
	        	case "btn_clz_dt_cal":
	        		var cal = new ComCalendar();
			        cal.select(formObj.cr_end_dt, 'yyyy-MM-dd');         
					break;
	        	case "btn_dy_xch_aply_st_dt":
	        		if(comboObjects[2].Code!="NN"){
		        		var cal = new ComCalendar();
				        cal.select(formObj.dy_xch_aply_st_dt, 'yyyy-MM-dd');   
	        		}
					break;
				
            }
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
   	function setComboObject(combo_obj){	     
       	comboObjects[comboCnt++]=combo_obj;  
   	} 
   	/**
   	 * initializing sheet
   	 * implementing onLoad event handler in body tag
   	 * adding first-served functions after loading screen.
   	 */
    function loadPage() {
    	var formObj=document.form;
    	for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        
        //---------------
        //tab 초기화 
	    for(var k=0; k<tabObjects.length; k++){
	    	initTab(tabObjects[k],k+1);
	    }
	    
	    initControl();
        initComboSetVal(sheetObjects[0],document.form);
	    
 	    for(var k=0;k<comboObjects.length;k++){
 	 		initCombo(comboObjects[k],comboObjects[k].id);
 	 	}
    	x_sheetObject1 = sheetObjects[0];  //Credit customer
    	x_sheetObject2 = sheetObjects[1];  //Auto Invoice
    	x_sheetObject3 = sheetObjects[2];  //History
    }
    
    /**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		 switch(tabNo) {
	         case 1:
	            with (tabObj) {
	                var cnt  = 0 ;
	                InsertTab( cnt++ , "Invoice Payment" , -1 );
	                InsertTab( cnt++ , "Auto Invoice" , -1 );
	                InsertTab( cnt++ , "Local Information & TAX" , -1 );
	                InsertTab( cnt++ , "History" , -1 );
	                BaseColor = "243,242,248"; 
	            }
	         break;
	     }
	}
	
	function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    } 
	
	/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab3_OnChange(tabObj , nItem)
    {
        //var objs = document.all.item("tabLayer_moreinfo");
        var formObj = document.form;
        
        switch(nItem) {
         	case 0:
         		tabLayer_invoicepayment.style.display = "Inline";
         		tabLayer_autoinvoice.style.display = "none";
         		tabLayer_localinformation.style.display = "none";
         		tabLayer_history.style.display = "none";
			    break;
         	case 1:
         		tabLayer_invoicepayment.style.display = "none";
         		tabLayer_autoinvoice.style.display = "Inline";
         		tabLayer_localinformation.style.display = "none";
         		tabLayer_history.style.display = "none";
			    break;
         	case 2:
         		tabLayer_invoicepayment.style.display = "none";
         		tabLayer_autoinvoice.style.display = "none";
         		tabLayer_localinformation.style.display = "Inline";
         		tabLayer_history.style.display = "none";
			    break;
         	case 3:
         		tabLayer_invoicepayment.style.display = "none";
         		tabLayer_autoinvoice.style.display = "none";
         		tabLayer_localinformation.style.display = "none";
         		tabLayer_history.style.display = "Inline";
			    break;
        }

    	/*objs[beforetab_trob].style.zIndex = objs[nItem].style.zIndex -1 ;
    	beforetab_trob = nItem;*/
    	
    }
    
    
	 /**
	 * BCM_CMS_0311 콤보 데이타를 가져온다.
	 **/
	 function initComboSetVal(sheetObj,formObj){
	 	formObj.f_cmd.value = SEARCH01;
	 	
	 	var sXml = sheetObj.GetSearchXml("BCM_CMS_0311GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.xch_rt_div_cd, "cd", "cd_desc");
		if (arrXml.length > 1) 
			ComXml2ComboItem(arrXml[1], formObj.cng_indiv_cd, "cd", "cd_desc");
		if (arrXml.length > 2) 
			ComXml2ComboItem(arrXml[2], formObj.inv_iss_curr_tp_cd, "cd", "cd_desc");
		if (arrXml.length > 3) 
			ComXml2ComboItem(arrXml[3], formObj.pay_div_cd, "cd", "cd_desc");
		if (arrXml.length > 4) 
			ComXml2ComboItem(arrXml[4], formObj.cust_cr_due_dt_div_cd, "cd", "cd_desc");
		if (arrXml.length > 5) 
			ComXml2ComboItem(arrXml[5], formObj.cr_cust_tp_cd, "cd", "cd_desc");
		if (arrXml.length > 6) 
			ComXml2ComboItem(arrXml[6], formObj.iss_div_cd, "cd", "cd_desc");
	 }
	 
	 /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj, comboId) {
    	  UseAutoComplete = true; // 편집시 자동 코드 검색
      } 
    

 	/**
 	  * setting sheet initial values and header
 	  * param : sheetObj, sheetNo
 	  * adding case as numbers of counting sheets
 	  */
	 function initSheet(sheetObj,sheetNo) {
			var cnt = 0;
		    switch(sheetObj.id) {
		        case "sheet1":   //sheet1 init
		            with (sheetObj) {
		                //Host정보 설정[필수][HostIp, Port, PagePath]
		                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
		                
		              //전체Merge 종류 [선택, Default msNone]
		    			MergeSheet = msNone;
		
		    			//전체Edit 허용 여부 [선택, Default false]
		    			Editable = true;
		    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		    			InitRowInfo(1, 1, 15, 100);
		    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		    			InitColumnInfo(65, 0, 0, true);
		
		    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
		    			InitHeadMode(true, true, false, true, false, false)
		    			var HeadTitle1 = " |";
		
		    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		    			InitHeadRow(0, HeadTitle1, true);
		
		    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		    			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
						InitDataProperty(0, cnt++ , dtSeq,          40,    daCenter,  false,   "Seq");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_cnt_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_seq");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_clt_ofc_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_curr_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ob_cr_term_dys");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ib_cr_term_dys");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_amt");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "riss_inv_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_st_dt");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_end_dt");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_rlse_ctrl_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "xch_rt_div_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cng_indiv_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "dy_xch_aply_st_dt");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "iss_div_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "act_cust_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "act_cust_cnt_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "act_cust_seq");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cntc_pson_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "inv_iss_curr_tp_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "pay_dt_dy1");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "pay_dt_dy2");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "pay_dt_dy3");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "pay_dt_dy4");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "pay_div_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bank_acct_no");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_cust_rmk");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "locl_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "locl_zip_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "locl_addr1");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "locl_addr2");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "locl_addr3");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "locl_addr4");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ownr_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bzct_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bztp_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ob_eml");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ib_eml");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ob_fax_no");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ib_fax_no");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ob_phn_no");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ib_phn_no");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_cr_due_dt_div_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_lgl_eng_nm");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cr_cust_tp_cd");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "kr_ib_ofc_cd");
						
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rfnd_psdo_vndr_seq");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rfnd_psdo_vndr_flg");
						
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "delt_flg");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cre_usr_id");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cre_dt");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "upd_usr_id");
						InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "upd_dt");
		            }
		            break;
		            
		        case "t2bsheet1_autoinvoice":      //t1sheet1 init
		        	with (sheetObj) {
			            // 높이 설정
			        	style.height = 220;
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
						
						var HeadTitle = "|In/Out Bound|AR OFC|Auto Send|Invoice Sender|SML Ref|Cust Ref No Check|LocalCharge(MRI) Check|Email Address|CNT||||";
						var headCount = ComCountHeadTitle(HeadTitle);
				
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);	
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false, false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
				
			            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag"); 
						
						InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	false,		"io_bnd_cd",      	true,      "", dfNone,  	0,      true,      	true,1);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"ofc_cd",      		true,      "", dfEngUpKey,   	0,      true,      	true,6);
						InitDataProperty(0, cnt++ , dtCombo,		90,  	daCenter,  	false,		"auto_inv_flg",		false,	    "",	dfNone,	    0,		true,       true, 1);  
						InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	false,		"hjs_cust_svc_pic_tp_cd",	   	false,		"",	dfEngUpKey,	0,		true,		true, 1);
						
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"hjs_ref_no",	    false,		"",	dfEngUpKey,	0,		true,      	true, 50);
						InitDataProperty(0, cnt++ , dtCombo,		120,	daCenter,	false,		"cust_ref_no_flg", 	false,		"",	dfNone,		0,		true,		true, 1);
						InitDataProperty(0, cnt++ , dtCombo,	    160,    daCenter,	false,		"locl_chg_flg",		false,		"",	dfNone,		0,		true,		true, 1);
						InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	false,		"auto_inv_eml",	    false,		"",	dfEngUpKey,	0,		true,      	true, 200);
						
						InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_cnt_cd",		false,		"",	dfEngUpKey,	0,		true,		true, 2);
						InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_seq",			false,		"",	dfNumber,	0,		true,		true, 6);
						InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cre_usr_id",		false,		"",	dfNone,		0,		true,		true, 20);
						InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cre_dt",			false,		"",	dfNone,		0,		true,		true, 20);
						
						InitDataCombo(0, "io_bnd_cd", "Outbound|Inbound", "O|I");
						//InitDataCombo(0, "delt_flg", "Active|Inactive", "N|Y");
						InitDataCombo(0, "auto_inv_flg", "N|Y", "N|Y");
						InitDataCombo(0, "cust_ref_no_flg", "N|Y", "N|Y");
						InitDataCombo(0, "locl_chg_flg", "N|Y", "N|Y");
						InitDataCombo(0, "hjs_cust_svc_pic_tp_cd", " |Group|Indi. Ref", " |G|I");
		
						ShowButtonImage = 2;	
						WaitImageVisible = false; 
			        }
			        break;
		            
		        case "t2bsheet1_history":      //t1sheet1 init
		        	with (sheetObj) {
			            // 높이 설정
			        	style.height = 220;
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
						
						var HeadTitle = "|Item|Item|Now Read|Previous|User Name|Office|Date(Local)|Date(GMT)";
						var headCount = ComCountHeadTitle(HeadTitle);
				
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);	
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false, false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
				
			            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			            InitDataProperty(0, cnt++ , dtHidden,    110,   daLeft,  	 true,    "his_seq",      false,   "",      dfNone,         0,     false,      false);
			            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,  	 true,    "item_hdr",     false,   "",      dfNone,         0,     false,      false);
			            InitDataProperty(0, cnt++ , dtData,   	 130,   daLeft,  	 true,    "his_cate_nm",  false,   "",      dfNone, 		0,     false,      false);
			            InitDataProperty(0, cnt++ , dtData,   	 210,   daLeft,  	 false,   "crnt_ctnt",    false,   "",      dfNone,         0,     false,       false);
			            InitDataProperty(0, cnt++ , dtData,   	 180,   daLeft,      false,   "pre_ctnt",     false,   "",      dfNone, 		0,     false,       false);
			            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,    	 false,   "cre_usr_id",   false,   "",      dfNone,         0,     false,       false);
			            
			            InitDataProperty(0, cnt++ , dtData,   	 60,    daCenter,    false,   "office",       false,   "",      dfNone, 		0,     false,       false);
			            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,    false,   "cre_dt",       false,   "",      dfNone, 		0,     false,       false);
			            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,    false,   "gmt_dt",       false,   "",      dfNone, 		0,     false,       false);
			            
		
						//InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
						CountPosition = 0;
			        }
			        break;
		    }
		}
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	switch(sAction) {
    	case SEARCH:				//Retrieve
    		if (validateForm(sheetObj, formObj, sAction)) {
    			//isdoActionIBSheetBeingProcessed=true;
    			
    			var custCd = formObj.cust_cd.value
    			
    			if(formObj.cust_cd.value.length>2){	   
		  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
		  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
				}
    			
    			ComOpenWait(true);					
    			formObj.f_cmd.value = SEARCH;
				
    		    var sXml = sheetObj.GetSearchXml("BCM_CMS_0311GS.do", FormQueryString(formObj));				
				var arrXml = sXml.split("|$$|"); 
				
				formObj.reset();
	    		sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
	    		
	    		ComSetObjValue(formObj.riss_inv_flg,"N");
	    		ComSetObjValue(formObj.cust_rlse_ctrl_flg,"N");
	    		ComSetObjValue(formObj.cr_flg,"N");

	    		ComSetObjValue(formObj.xch_rt_div_cd,"");
	    		ComSetObjValue(formObj.cng_indiv_cd,"");
	    		ComSetObjValue(formObj.inv_iss_curr_tp_cd,"");
	    		ComSetObjValue(formObj.pay_div_cd,"");
	    		ComSetObjValue(formObj.cust_cr_due_dt_div_cd,"");
	    		ComSetObjValue(formObj.delt_flg,"N");
				
				if (arrXml.length > 0) {
					x_sheetObject1.LoadSearchXml(arrXml[0]);
				}
				if (arrXml.length > 1) {
					x_sheetObject2.LoadSearchXml(arrXml[1]); 
				}
				if (arrXml.length > 2) {
					x_sheetObject3.LoadSearchXml(arrXml[2]); 
				}
				
				ComOpenWait(false);
				
				formObj.cust_cd.value = custCd;
				
				if (sheetObj.CellValue(1, "cre_usr_id") != ""){
					formObj.creflag.value = "N";
	    			formObj.ibflag.value = "N";
	    			formObj.cust_cnt_cd.value=sheetObj.CellValue(1, "cust_cnt_cd");
	    			formObj.cust_seq.value=sheetObj.CellValue(1, "cust_seq");
	    			formObj.cr_clt_ofc_cd.value=sheetObj.CellValue(1, "cr_clt_ofc_cd");
	    			formObj.cr_curr_cd.value=sheetObj.CellValue(1, "cr_curr_cd");
	    			formObj.ob_cr_term_dys.value=sheetObj.CellValue(1, "ob_cr_term_dys");
	    			formObj.ib_cr_term_dys.value=sheetObj.CellValue(1, "ib_cr_term_dys");
	    			formObj.cr_amt.value=sheetObj.CellValue(1, "cr_amt");
	    			ComSetObjValue(formObj.riss_inv_flg,sheetObj.CellValue(1, "riss_inv_flg"));
	    			formObj.cr_st_dt.value=sheetObj.CellValue(1, "cr_st_dt");
	    			formObj.cr_end_dt.value=sheetObj.CellValue(1, "cr_end_dt");
	    			ComSetObjValue(formObj.cust_rlse_ctrl_flg,sheetObj.CellValue(1, "cust_rlse_ctrl_flg"));
	    			ComSetObjValue(formObj.cr_flg,sheetObj.CellValue(1, "cr_flg"));
	    			ComSetObjValue(formObj.xch_rt_div_cd,sheetObj.CellValue(1, "xch_rt_div_cd"));
	    			ComSetObjValue(formObj.cng_indiv_cd,sheetObj.CellValue(1, "cng_indiv_cd"));
	    			formObj.dy_xch_aply_st_dt.value=sheetObj.CellValue(1, "dy_xch_aply_st_dt");
	    			formObj.act_cust_cd.value=sheetObj.CellValue(1, "act_cust_cd");
	    			
	    			formObj.act_cust_cnt_cd.value=sheetObj.CellValue(1, "act_cust_cnt_cd");
	    			formObj.act_cust_seq.value=sheetObj.CellValue(1, "act_cust_seq");
	    			formObj.cntc_pson_nm.value=sheetObj.CellValue(1, "cntc_pson_nm");
	    			ComSetObjValue(formObj.inv_iss_curr_tp_cd,sheetObj.CellValue(1, "inv_iss_curr_tp_cd"));
	    			ComSetObjValue(formObj.iss_div_cd,sheetObj.CellValue(1, "iss_div_cd"));
	    			formObj.pay_dt_dy1.value=sheetObj.CellValue(1, "pay_dt_dy1");
	    			formObj.pay_dt_dy2.value=sheetObj.CellValue(1, "pay_dt_dy2");
	    			formObj.pay_dt_dy3.value=sheetObj.CellValue(1, "pay_dt_dy3");
	    			formObj.pay_dt_dy4.value=sheetObj.CellValue(1, "pay_dt_dy4");
	    			ComSetObjValue(formObj.pay_div_cd,sheetObj.CellValue(1, "pay_div_cd"));
	    			formObj.bank_acct_no.value=sheetObj.CellValue(1, "bank_acct_no");
	    			formObj.cr_cust_rmk.value=sheetObj.CellValue(1, "cr_cust_rmk");
	    			formObj.locl_nm.value=sheetObj.CellValue(1, "locl_nm");
	    			formObj.locl_zip_cd.value=sheetObj.CellValue(1, "locl_zip_cd");
	    			formObj.locl_addr1.value=sheetObj.CellValue(1, "locl_addr1");
	    			formObj.locl_addr2.value=sheetObj.CellValue(1, "locl_addr2");
	    			formObj.locl_addr3.value=sheetObj.CellValue(1, "locl_addr3");
	    			formObj.locl_addr4.value=sheetObj.CellValue(1, "locl_addr4");
	    			
	    			formObj.ownr_nm.value=sheetObj.CellValue(1, "ownr_nm");
	    			formObj.bzct_nm.value=sheetObj.CellValue(1, "bzct_nm");
	    			formObj.bztp_nm.value=sheetObj.CellValue(1, "bztp_nm");
	    			formObj.ob_eml.value=sheetObj.CellValue(1, "ob_eml");
	    			formObj.ib_eml.value=sheetObj.CellValue(1, "ib_eml");
	    			formObj.ob_fax_no.value=sheetObj.CellValue(1, "ob_fax_no");
	    			formObj.ib_fax_no.value=sheetObj.CellValue(1, "ib_fax_no");
	    			formObj.ob_phn_no.value=sheetObj.CellValue(1, "ob_phn_no");
	    			formObj.ib_phn_no.value=sheetObj.CellValue(1, "ib_phn_no");
	    			
	    			if (sheetObj.CellValue(1, "rfnd_psdo_vndr_flg") == "Y") {
	    				formObj.rfnd_psdo_vndr_flg.checked = true;
	    				formObj.rfnd_psdo_vndr_flg.disabled = true;
	    			} else {
	    				formObj.rfnd_psdo_vndr_flg.checked = false;
	    				formObj.rfnd_psdo_vndr_flg.disabled = false;
	    			}
	    			formObj.rfnd_psdo_vndr_seq.value=sheetObj.CellValue(1, "rfnd_psdo_vndr_seq");
	    			
	    			ComSetObjValue(formObj.cust_cr_due_dt_div_cd,sheetObj.CellValue(1, "cust_cr_due_dt_div_cd"));
	    			formObj.cust_lgl_eng_nm.value=sheetObj.CellValue(1, "cust_lgl_eng_nm");
	    			
	    			ComSetObjValue(formObj.cr_cust_tp_cd,sheetObj.CellValue(1, "cr_cust_tp_cd"));
	    			formObj.kr_ib_ofc_cd.value=sheetObj.CellValue(1, "kr_ib_ofc_cd");
	    				
		    		ComSetObjValue(formObj.delt_flg,sheetObj.CellValue(1, "delt_flg"));
		    		formObj.cre_usr_id.value=sheetObj.CellValue(1, "cre_usr_id");
		    		formObj.cre_dt.value=sheetObj.CellValue(1, "cre_dt");
		    		formObj.upd_usr_id.value=sheetObj.CellValue(1, "upd_usr_id");
		    		formObj.upd_dt.value=sheetObj.CellValue(1, "upd_dt");
		    		
		    		formObj.cust_cd.style.backgroundColor="#bebebe";
		    		formObj.cust_cd.readOnly=true;
		    		
				} else {
					formObj.creflag.value="I";
					formObj.ibflag.value = "I";
					formObj.cust_cnt_cd.value=sheetObj.CellValue(1, "cust_cnt_cd");
	    			formObj.cust_seq.value=sheetObj.CellValue(1, "cust_seq");
					formObj.cust_lgl_eng_nm.value=sheetObj.CellValue(1, "cust_lgl_eng_nm");
					formObj.rfnd_psdo_vndr_flg.disabled = false;
					ComSetObjValue(formObj.delt_flg,"N");
					ComShowCodeMessage("CCD00040");
				}
	    		
    		}
    		break;
    	case MULTI01:				//Save
    		if (validateForm(sheetObj, formObj, sAction)) {
    			formObj.f_cmd.value=MULTI;
          	    
          	    var sParam = FormQueryString(formObj);
          	    var sParam1 = ComSetPrifix(x_sheetObject2.GetSaveString(), "t2bsheet2_");

          	    sParam += "&" + sParam1;
          	    
          	    ComOpenWait(true); //대기이미지 표시

    			var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0311GS.do", sParam);
    			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
    			ComOpenWait(false); //대기이미지 숨김

    			if(sav == "S"  ){
    				ComShowCodeMessage("COM130102", "Data");
     				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
     			}else{
     				ComShowCodeMessage("COM130103", "Data");
     			}
    		}
    		break;
    	case IBCLEAR:
    		formObj.reset();
    		formObj.ibflag.value = "I";
    		formObj.creflag.value = "Y";
    		
    		sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
    		
    		ComSetObjValue(formObj.riss_inv_flg,"N");
    		ComSetObjValue(formObj.cust_rlse_ctrl_flg,"N");
    		ComSetObjValue(formObj.cr_flg,"N");
    		ComSetObjValue(formObj.iss_div_cd,"");

    		ComSetObjValue(formObj.xch_rt_div_cd,"");
    		ComSetObjValue(formObj.cng_indiv_cd,"");
    		ComSetObjValue(formObj.inv_iss_curr_tp_cd,"");
    		ComSetObjValue(formObj.pay_div_cd,"");
    		ComSetObjValue(formObj.cust_cr_due_dt_div_cd,"");
    		ComSetObjValue(formObj.cr_cust_tp_cd,"");
    		ComSetObjValue(formObj.delt_flg,"N");
    		ComBtnEnable("btn_save");

    		break;

		case SEARCH02:      //Control Office Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH02;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0311GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        if(result==""){
		        	ComShowCodeMessage("COM130402", "Credit Control Office Code");
		        	formObj.cr_clt_ofc_cd.value="";
		        }
				ComOpenWait(false);
			}
			break;
			
    	case SEARCH03:      //Credit Currency Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH03;
				
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0311GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        if(result==""){
		        	ComShowCodeMessage("COM130402", "Credit Currency Code");
		        	formObj.cr_curr_cd.value="";
		        }
				ComOpenWait(false);
			}
			break;
			
    	case SEARCH04:      //Actual Payer Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH04;
				
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0311GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        if(result==""){
		        	ComShowCodeMessage("COM130402", "Actual Payer Code");
		        	formObj.act_cust_cd.value="";
		        }
				ComOpenWait(false);
			}
			break;
			
    	case SEARCH05:      //Customer Code check
    		if(validateForm(sheetObj,formObj,sAction)){
    			ComOpenWait(true);
    			formObj.f_cmd.value=SEARCH05;
    			var sParam=FormQueryString(formObj);
    			var sXml=sheetObj.GetSearchXml("BCM_CMS_0311GS.do", sParam);
    	        var result=ComGetEtcData(sXml, "result");
    	        if(result==""){
    	        	ComShowCodeMessage("COM130402", "Customer Code");
    	        	formObj.cust_cd.value="";
		        	CustomerCodeChk="N"; // customer code check
    	        }
    			ComOpenWait(false);
    		}
    		break;
    		
    	case SEARCH09:      //Customer Code check
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH09;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        var result=ComGetEtcData(sXml, "result");
		        ;
		        if(result=="" ){
		        	ComShowCodeMessage("COM130402", "Customer Code");
		        	formObj.cust_cnt_cd.value="";
		        	formObj.cust_seq.value="";
		        	formObj.cust_cd.value="";
		        }
				ComOpenWait(false);
			}
			break;

		break;
    	}
    	return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction) {
    	switch (sAction) {
    	case SEARCH:
    		/*if( formObj.rqst_no.value == ''){
	    		if(formObj.srep_cd.value == "" || formObj.srep_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "Sales Rep.");
	    			formObj.srep_cd.focus();
	    			return false;
	    		}
    		}*/
    		break;
    	case MULTI01:
    		/*if(formObj.cr_clt_ofc_cd.value == "" || formObj.cr_clt_ofc_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Credit Control Office");
    			formObj.cr_clt_ofc_cd.focus();
    			return false;
    		}
    		if(formObj.cr_curr_cd.value == "" || formObj.cr_curr_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Credit Currency");
    			formObj.cr_curr_cd.focus();
    			return false;
    		}
    		if((formObj.ob_cr_term_dys.value == "" || formObj.ob_cr_term_dys.value == null) && (formObj.ib_cr_term_dys.value == "" || formObj.ib_cr_term_dys.value == null)){
    			ComShowCodeMessage("CCD00001", "O/B Credit Term/Day or I/B Credit Term/Day");
    			formObj.ob_cr_term_dys.focus();
    			return false;
    		}
    		if(formObj.cr_amt.value == "" || formObj.cr_amt.value == null){
    			ComShowCodeMessage("CCD00001", "Credit Amount Limit");
    			formObj.cr_amt.focus();
    			return false;
    		}*/
    		
    		var dupCustRep = x_sheetObject2.ColValueDupRows("io_bnd_cd|ofc_cd", false, true);
			if (dupCustRep != null && dupCustRep != "") {	//msgs['BKG00764']="{?msg1} is duplicated."
				ComShowCodeMessage("SAM00007","Auto Invoice");
				return false;
			}     
    	}
    	return true;
    }

    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm  ("change", 	 "form_onChange", 		formObj);
 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);  
 	   	axon_event.addListenerForm  ('click',    'obj_click',        document.form); 
 	    axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
 	    axon_event.addListenerForm  ('beforedeactivate'	, 'cms0311_deactivate'	, document.form); 
 	    axon_event.addListenerFormat('beforeactivate', 	'cms0311_activate',   formObj); //- 포커스 들어갈때
 	   
        //applyShortcut();
    }	

    
	// 업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress_loc() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
	       case "float":
	           //숫자+"."입력하기
	           ComKeyOnlyNumber(event.srcElement, ".");
	           break;
	       case "eng":
	           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	           ComKeyOnlyAlphabet();
	           break;
	       case "engdn":
	           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	           ComKeyOnlyAlphabet('lower');
	           break;
	       case "engup":
	           //영문 대문자만 입력하기
	           ComKeyOnlyAlphabet('upper');
	           break;
	       case "int":
	           //숫자만입력하기(정수,날짜,시간)
	           ComKeyOnlyNumber(event.srcElement);
	           break;
	       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
	       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
	     			event.keyCode = keyValue + 65 - 97;
	     		}
	           break;
	       case "tel":
		        // 숫자+"-"입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		        break;
           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
	    	   break;
	    }
	}
   /**
   * HTML Object OnKeyUp event handling
   */
   function obj_keypress(event) {
      var obj=event.srcElement;
      keyValidation(obj);
   }
   
   	 /**
	 * 마우스 IN일때 
	 */
	function cms0311_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "cr_st_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "cr_end_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "dy_xch_aply_st_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				event.srcElement.onfocus = new Function("this.select()");
				break;
		}
	}
	
	 /**
	 * 마우스 아웃일때 
	 */
    function cms0311_deactivate() {
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	
    	if(srcName == "cr_st_dt"){
	    	ComAddSeparator(event.srcElement);
    	}else if(srcName == "cr_end_dt"){
	    	ComAddSeparator(event.srcElement);
    	}else if(srcName == "dy_xch_aply_st_dt"){
	    	ComAddSeparator(event.srcElement)
    	}
    }
   
   
   function form_onChange(evt,el) {
	  	var formObj = document.form;
	  	var xml = "";
	  	var srcName;
	  	var srcValue;
		var srcObj;
		
	  	if (el) {
	  		srcObj = el;
	  		srcName = el.getAttribute("name");
	  		srcValue = el.getAttribute("value");
	  	} else {
	  		srcObj = window.event.srcElement;
	  		srcName = srcObj.getAttribute("name");
	  		srcValue = srcObj.getAttribute("value");
	  		if(formObj.ibflag.value != 'I'){
	  			formObj.ibflag.value = "U";
	  		}
	  	}

	  	switch(srcName) {
  			case "cust_cd":
		  		if(formObj.cust_cd.value.length>2){	   
		  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
		  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
	           		if(formObj.cust_seq.value.match(/[^0-9]{1}/)){
	           			  ComShowCodeMessage("CCD00039", "Customer Code");
	           			  formObj.cust_cd.value='';
	           			  return false;
	           		}  
	           		var custlpad="";
	           		if (formObj.cust_seq.value.length <6 ){
	           			for(i=1; i <= 6- formObj.cust_seq.value.length; i++){
	           				 custlpad=custlpad+"0" ;
	           			}
	           			formObj.cust_cd.value=formObj.cust_cnt_cd.value+custlpad+formObj.cust_seq.value ;
	           		}
	           		doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
	    			if(formObj.cust_cd.value.length==0){
	//            			document.form.cust_cd.focus();
	        		}else{
	    				formObj.ibflag.value="U";
	    				//formObj.cust_cd.readOnly=true;		
	//            				document.form.cust_lgl_eng_nm.focus();
	    				doActionIBSheet(sheetObjects[0], formObj, SEARCH);
	        		}
	    		}
		  		break;
		  		
	  		case "cr_clt_ofc_cd":
	  			if(formObj.cr_clt_ofc_cd.value.length>0){
	       			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	       			if(formObj.cr_clt_ofc_cd.value.length==0){
	   					document.form.cr_clt_ofc_cd.focus();
	       			}else{
	       				document.form.cr_curr_cd.focus();
	       			}
	       		}
	       		break;
	       	
	  		case "cr_curr_cd":
	       		if(formObj.cr_curr_cd.value.length>0){
	       			doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
	       			if(formObj.cr_clt_ofc_cd.value.length==0){
	   					document.form.cr_curr_cd.focus();
	       			}else{
	       				document.form.ob_cr_term_dys.focus();
	       			}
	       		}
	       		break;
	       		
            case "rfnd_psdo_vndr_flg":
            	if (formObj.rfnd_psdo_vndr_flg.checked) {
    				formObj.rfnd_psdo_vndr_flg.value = "Y";
    			} else {
    				formObj.rfnd_psdo_vndr_flg.value = "N";
    			}
            	break;
	  	}
	}
   
	/**
	 * Customer Code Pop up to read from. <br>
	 */
	function setCallBack0B2(aryPopupData) {
		var form=document.form;
		form.cust_seq.value=aryPopupData[0][3].substring(2,8);
		form.cust_cnt_cd.value=aryPopupData[0][3].substring(0,2);
		form.cust_cd.value=aryPopupData[0][3];
		doActionIBSheet(sheetObjects[0], form, SEARCH);
	}
	
	/**
	 * Office Code Pop up to read from. <br>
	 */
	function setCallBack0B3(aryPopupData) {
		var form=document.form;
		if (form.cr_clt_ofc_cd.value != aryPopupData[0][3]){
			form.cr_clt_ofc_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	
	/**
	 * Office Code Pop up to read from. <br>
	 */
	function setCallBack0B6(aryPopupData) {
		var form=document.form;
		if (form.kr_ib_ofc_cd.value != aryPopupData[0][3]){
			form.kr_ib_ofc_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	
	/**
	 * Currency Code Pop up to read from. <br>
	 */
	function setCallBack0B4(aryPopupData) {
		var form=document.form;
		if (form.cr_curr_cd.value != aryPopupData[0][3]){
			form.cr_curr_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	
	/**
	 * Actual Payer Code Pop up to read from. <br>
	 */
	function setCallBack0B5(aryPopupData) {
		var formObj=document.form;
		var actData = aryPopupData[0][3];
		if (form.act_cust_cd.value != aryPopupData[0][3]){
			formObj.act_cust_cd.value=actData;
			formObj.act_cust_cnt_cd.value=actData.substr(0,2);
			formObj.act_cust_seq.value=actData.substr(2,6);
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
			doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
		}
	}
		
    
	  function getValueForCombo(obj) {
		  if (Object.prototype.toString.call(obj) === '[object Array]') {
			  var str = obj[0];
			  if(str == undefined) return obj;
			  return str.split('|')[0];
		  }
		  return obj;
	  }
	    
	function isEmailAddr(event){
	    eventElement=ComGetEvent();
		if(eventElement.value.length > 0) {
			if(!ComIsEmailAddr(eventElement)) {
				ComShowCodeMessage("CCD00007");
				eventElement.focus();
			}
		}
	}
	
	//IB sheet의 값이 변경될경우.
	function t2bsheet1_autoinvoice_OnChange(sheetObj,row,col,value){
		var formObj = document.form;
		var val_type = "";
		var val_value = "";
		
		/* ColSaveName */
		var col_save_name = sheetObj.ColSaveName(col);
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		
		if (col_save_name == "ofc_cd") {
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "Office Code";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		if(!searchValidationData(sheetObj, val_type, val_value, row)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}
        }
	}
	
	// Invoicing Currency 변경시
	function inv_iss_curr_tp_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}
	// Due Date Criteria 변경시
	function cust_cr_due_dt_div_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}
	// Indi.Exch.Rate Apply Scope 변경시
	function xch_rt_div_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
		if(comboObjects[2].Code=="NN"){
			ComSetObjValue(formObj.cng_indiv_cd,"");
			formObj.dy_xch_aply_st_dt.value = "";
			formObj.cng_indiv_cd.Enable=false;
			formObj.dy_xch_aply_st_dt.disabled = true;
		} else {
			formObj.cng_indiv_cd.Enable=true;
			formObj.dy_xch_aply_st_dt.disabled = false;
		}
	}
	// Indi.Exch.Rate Apply Basis 변경시
	function cng_indiv_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}
	// Collection Method 변경시
	function pay_div_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}
	
	// Tax Invoice Issue Type 변경시
	function iss_div_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}
	
	// Korea Customer Type 변경시
	function cr_cust_tp_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
  			formObj.ibflag.value					="U";
  		}
	}
	
	/**
	 * 저장시 시트의 값에 따른 Validation을 실시한다.<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} lane_cd  
	 * @param {String} dir_cd  
	 * @param {String} cmdt_cd 
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 최문환
	 * @version 2014.01.07
	 */
	function searchValidationData(sheetObj, val_type, val_value, row) {
		var formObj = document.form;
		var sParam  = "";
		var result  = "";
		var sXml    = "";

    	ComOpenWait(true);
    	if (val_type == "Office Code") {
    		sParam = "f_cmd=104&" + "&val_type="+val_type+"&ofc_cd="+val_value;
	    	sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
	        result=ComGetEtcData(sXml, "result");
    	}

	    ComOpenWait(false);
        
        if(result==""){
        	ComShowCodeMessage("COM130402", val_type);
        	return false;
        }
		 
		return true;
	}