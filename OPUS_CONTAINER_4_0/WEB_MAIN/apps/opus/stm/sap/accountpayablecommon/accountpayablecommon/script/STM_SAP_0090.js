/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0090.jsp
*@FileTitle  : Bank Account Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
	     var form=document.form;
	    try {
	        var srcName=ComGetEvent("name");
	        switch(srcName) {
	    	    case "btn_cal_st":  
	        		var cal=new ComCalendar();
					cal.select(form.bank_acct_st_dt, 'yyyy-MM-dd');
					break;
	    	    case "btn_cal_inact":  
	        		var cal=new ComCalendar();
					cal.select(form.inact_dt, 'yyyy-MM-dd');
					break;					
	    	    case "btn_retrieve":  
	    	    	doActionIBSheet(sheetObject, form, IBSEARCH);
					break;					
	    	    case "btn_save":  
	    	    	doActionIBSheet(sheetObject, form, IBSAVE);
					break;
	    	    case "btn_cnt":  				
            	    var v_cnt_cd=form.cntc_area_cd.value;
            	    var classId="COM_ENS_0M1";
        		    var param='?cnt_cd='+v_cnt_cd+'&classId='+classId;
        		    var v_display="1,0,1,1,1,0,0";
        		    var chkStr=v_display.substring(0,3)
        		    if(chkStr == "1,0") {
        		    	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 700, 500, 'getCOM_ENS_0M1', v_display, true);
        		    } else {
        			    return;
        		    }	
        		    break;
	    	    case "btn_bank_brnc_nm" :	    	    		    			
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0081.do?bank_brnc_nm='+encodeURIComponent(form.bank_brnc_nm.value), 950, 590,"getSTM_SAP_0081", "0,0", true);
	    	    	break;
	    	    case "btn_bank_acct_nm" :	  
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0063.do?bank_acct_nm='+encodeURIComponent(form.sch_bank_acct_nm.value) + '&bank_acct_tp_nm=INTERNAL&acct_tp_cd=ALL', 720, 420,"getSTM_SAP_0063", "0,0", true);
	    	    	break;
	    	    case "btn_open_ofc_nm" :	    	    		    			
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0001.do?ofc_cd='+form.opn_ofc_cd.value + '&security_flag=Y', 400, 430,"getSTM_SAP_0001_OPEN", "0,0", true);
	    	    	break;
	    	    case "btn_ctrl_ofc_nm" :	    	    		    			
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0001.do?ofc_cd='+form.ap_ctrl_ofc_cd.value + '&security_flag=Y', 400, 430,"getSTM_SAP_0001_CTRL", "0,0", true);
	    	    	break;	    	    	
	    	    case "btn_ar_ofc_nm" :	    	    		    			
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0360.do?ofc_cd='+form.ar_ofc_cd.value + '&security_flag=Y', 400, 430,"getSTM_SAP_0360", "0,0", true);    	    	    	
	    	    	break;		    	    	
	    	    case "btn_aset_cd_cmb_seq" :	
                	var company=form.aset_coa_co_cd.value; 	
            		var region=form.aset_coa_rgn_cd.value;
            		var center=form.aset_coa_ctr_cd.value;
            		var account=form.aset_coa_acct_no.value;
            		var intercom=form.aset_coa_inter_co_cd.value;
            		var vvd=form.aset_coa_vvd_cd.value;                 				
            		var param="?lineType=CASH&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;              		 	    	    	
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0021.do'+param, 450, 300,"getSTM_SAP_0021_aset", "0,0", true);
	    	    	break;		    	    	
	    	    case "btn_chg_cmb_seq" :	  
                	var company=form.chg_coa_co_cd.value; 	
            		var region=form.chg_coa_rgn_cd.value;
            		var center=form.chg_coa_ctr_cd.value;
            		var account=form.chg_coa_acct_no.value;
            		var intercom=form.chg_coa_inter_co_cd.value;
            		var vvd=form.chg_coa_vvd_cd.value;                 				
            		var param="?lineType=CHARGE&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;   	    	    	
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0021.do'+param, 450, 300,"getSTM_SAP_0021_chg", "0,0", true);
	    	    	break;			    	    	
	    	    case "btn_gain_cd_cmb_seq" :	
                	var company=form.gain_coa_co_cd.value; 	
            		var region=form.gain_coa_rgn_cd.value;
            		var center=form.gain_coa_ctr_cd.value;
            		var account=form.gain_coa_acct_no.value;
            		var intercom=form.gain_coa_inter_co_cd.value;
            		var vvd=form.gain_coa_vvd_cd.value;                 				
            		var param="?lineType=GAIN&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;   	    	    	
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0021.do'+param, 450, 300,"getSTM_SAP_0021_gain", "0,0", true);
	    	    	break;		    	    	
	    	    case "btn_lss_cd_cmb_seq" :	 
                	var company=form.lss_coa_co_cd.value; 	
            		var region=form.lss_coa_rgn_cd.value;
            		var center=form.lss_coa_ctr_cd.value;
            		var account=form.lss_coa_acct_no.value;
            		var intercom=form.lss_coa_inter_co_cd.value;
            		var vvd=form.lss_coa_vvd_cd.value;                 				
            		var param="?lineType=LOSS&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;   	    	    	
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0021.do'+param, 450, 300,"getSTM_SAP_0021_lss", "0,0", true);
	    	    	break;		    	    	
	    	    case "btn_new" :
	    	    	form.reset();
	    	    	form.f_cmd.value="";
	    	    	form.pagerows.value="";
	    	    	form.bank_acct_seq.value="";
	    	    	form.bank_brnc_seq.value="";
	    	    	form.aset_cd_cmb_seq.value="";
	    	    	form.chg_cd_cmb_seq.value="";
	    	    	form.gain_cd_cmb_seq.value="";
	    	    	form.lss_cd_cmb_seq.value="";
	    	    	form.acct_tp_cd.value="";
	    	    	
	    	    	ComSetObjValue(curr_cd, "");  	    
	    	    	ComSetObjValue(bank_acct_tp_mn_cd, ""); 
	    	    	ComSetObjValue(bank_acct_tp_sub_cd, ""); 	    	    		    	    	
	    	    	break;
	        } // end switch
	    }catch(e) {            
	        if( e == "[object Error]") {
	            ComShowMessage(OBJECT_ERROR);
	        } else {
	            ComShowMessage(e.message);
	        }
	    }
	}
    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage() {
    	var formObject=document.form;
    	for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
 		for(var k=0;k<comboObjects.length;k++){
 			initCombo(comboObjects[k],k+1);
 		}
 		initControl();
 		
 	    //office 코드 설정
 		var ofcCd=SapGetLoginAPOfc(sheetObjects[0]);
 		formObject.opn_ofc_cd.value=ofcCd;
 		formObject.ap_ctrl_ofc_cd.value=ofcCd;
 	    //office local date 설정
 		var localTime=SapGetLocDate(sheetObjects[0]); 		 					
 		formObject.bank_acct_st_dt.value=ComGetMaskedValue(localTime, "ymd");   
 		
 		SapAddComboItem(comboObjects[0], SapGetCurrComboItems(sheetObjects[0], ""), "1", " ", " "); //currency 	 		
 		SapAddComboItem(comboObjects[1], SapGetComboItems(sheetObjects[0], "BANK ACCOUNT TYPE(L)"), "2", " ", " "); //BANK ACCOUNT TYPE(L)		 		 	
 		SapAddComboItem(comboObjects[2], SapGetComboItems(sheetObjects[0], "BANK ACCOUNT TYPE(M)"), "2", " ", " "); //BANK ACCOUNT TYPE(M)		
    }
 	/**
 	 * loading HTML Control event <br>
 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence number in sheetObjects array
 	 **/
 	function initControl() {
 		var formObject=document.form;
 		//axon_event.addListenerForm('keyup',    'obj_keyup',   	 formObject);
 		axon_event.addListenerFormat('focus' , 'obj_activate',   formObject);	
 	    axon_event.addListenerFormat('blur'  , 'obj_deactivate', formObject);
 	}
 	
    /** 
     * handling keyup event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	/*function obj_keyup(){
		switch(event.srcElement.name){ 	    	
   		case "curr_cd_text":
			$("#curr_cd_text").val($("#curr_cd_text").val().toUpperCase());
   			break;
		}
	} */
	
	/** 
	 * handling work javascript OnFocus event  <br>
	 */    
	function obj_activate() {
	   	//delete mask separator
	    ComClearSeparator(event.srcElement);        
	} 
	
	/**
	 * HTML Control onfocus validate event <br>
	 **/
	function obj_deactivate(){
		switch(ComGetEvent("name")){ 	    	
			case "bank_acct_st_dt":
				ComAddSeparator(form.bank_acct_st_dt, "ymd");
				ComChkObjValid(ComGetEvent());	
				break;
			case "inact_dt":
				ComAddSeparator(form.inact_dt, "ymd");
				ComChkObjValid(ComGetEvent());	
				break;
		}
	}	
 	/**
 	 * registering IBCombo Object as list
 	 * @param combo_obj
 	 * @return
 	 */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	} 
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
		 var formObject=document.form
	    	switch (comboObj.options.id) {
	    	case "curr_cd":
		           with (comboObj) {
				   	ValidChar(2);
			       }
	           break;
			   default :
		           with (comboObj) {
				   //ValidChar(2,0);
			       }
	           break;
	     }
	}	 	
	/**
	 * initSheet.<br>
	 * @author sangyoung cha
	 * @param sheetObj
	 * @param sheetNo
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
                
            		var HeadTitle="type|attr_1|attr_2|attr_3|attr_4|attr_5|attr_6|attr_7|attr_8|attr_9|attr_10|attr_11|attr_12|attr_13|attr_14|attr_15|attr_16|attr_17|attr_18|attr_19|attr_20";
            		HeadTitle=HeadTitle + "|glo_1|glo_2|glo_3|glo_4|glo_5|glo_6|glo_7|glo_8|glo_9|glo_10|glo_11|glo_12|glo_13|glo_14|glo_15|glo_16|glo_17|glo_18|glo_19|glo_20";
            		var headCount=ComCountHeadTitle(HeadTitle);

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

		             var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_cate_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt7",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt8",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt9",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt10",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt11",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt12",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt13",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt14",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt15",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt16",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt17",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt18",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt19",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt10",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt12",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt13",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt14",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt15",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt17",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt18",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt19",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt20",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              
		             InitColumns(cols);
		             SetEditable(1);
		             //SetSheetHeight(220);
		             resizeSheet();
                  }
            break;
        }
    }
    /**
     * doActionIBSheet.<br>
     * @author sangyoung cha
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {        
 	   if (!validateForm(formObj, sAction)) return;
        switch(sAction) {
        	case IBSEARCH: //조회
        		//account no 수정할 경우 조회를 위해, bank_acct_seq 으로 만 조회함.
        		if(formObj.f_cmd.value == MULTI) {
        			formObj.sch_bank_acct_no.value=""; 
        		}
                formObj.f_cmd.value=SEARCH; 
                ComOpenWait(true);
     			var sXml=sheetObj.GetSearchData("STM_SAP_0090GS.do", FormQueryString(formObj));
     			ComOpenWait(false);
    			var arrXml=sXml.split("|$$|");
        		//폼 초기화	
        		formObj.reset();	
    	    	ComSetObjValue(curr_cd, "");  	    
    	    	ComSetObjValue(bank_acct_tp_mn_cd, ""); 
    	    	ComSetObjValue(bank_acct_tp_sub_cd, "");         			
    			if (sXml.length > 0) {	
    				var list=SapXmlToListMap(arrXml[0]);
    				if (list.length > 0) {        					
    					formObj.bank_acct_seq.value=list[0]["bank_acct_seq"];
    					formObj.bank_brnc_seq.value=list[0]["bank_brnc_seq"];
    					formObj.cntc_area_cd.value=list[0]["cntc_area_cd"];
    					formObj.cntc_area_nm.value=list[0]["cntc_area_nm"];
    					formObj.sch_bank_acct_nm.value=list[0]["bank_acct_nm"];
    					formObj.sch_bank_acct_no.value=list[0]["bank_acct_no"];
    					formObj.bank_nm.value=list[0]["bank_nm"];
    					formObj.bank_brnc_nm.value=list[0]["bank_brnc_nm"];
    					formObj.bank_acct_nm.value=list[0]["bank_acct_nm"];
    					formObj.bank_acct_no.value=list[0]["bank_acct_no"];
    					formObj.bank_acct_altn_nm.value=list[0]["bank_acct_altn_nm"];
    					formObj.bank_acct_desc.value=list[0]["bank_acct_desc"];
    					formObj.bank_acct_st_dt.value=list[0]["bank_acct_st_dt"];
    					formObj.inact_dt.value=list[0]["inact_dt"];
    					formObj.dps_div_cd.value=list[0]["dps_div_cd"];
    					formObj.opn_ofc_cd.value=list[0]["opn_ofc_cd"];
    					formObj.ap_ctrl_ofc_cd.value=list[0]["ap_ctrl_ofc_cd"];
    					formObj.ar_ofc_cd.value=list[0]["ar_ofc_cd"];
    					formObj.mlt_curr_flg.value=list[0]["mlt_curr_flg"];
    					formObj.aset_cd_cmb_seq.value=list[0]["aset_cd_cmb_seq"];
    					formObj.chg_cd_cmb_seq.value=list[0]["chg_cd_cmb_seq"];
    					formObj.gain_cd_cmb_seq.value=list[0]["gain_cd_cmb_seq"];
    					formObj.lss_cd_cmb_seq.value=list[0]["lss_cd_cmb_seq"];
    					formObj.cntc_nm.value=list[0]["cntc_nm"];
    					formObj.cntc_tit_nm.value=list[0]["cntc_tit_nm"];
    					formObj.cntc_phn_no.value=list[0]["cntc_phn_no"];
    					formObj.attr_ctnt2.value=list[0]["attr_ctnt2"];					
    					formObj.attr_ctnt1.value=list[0]["attr_ctnt1"];
    					if(list[0]["acct_tp_cd"] == "P") {
    						formObj.chk_acct_tp_cd[0].checked=true;
    					}
    					else if(list[0]["acct_tp_cd"] == "R") {
    						formObj.chk_acct_tp_cd[1].checked=true;
    					}
    					else {
    						formObj.chk_acct_tp_cd[0].checked=true;
    						formObj.chk_acct_tp_cd[1].checked=true;
    					}
    					ComSetObjValue(curr_cd, list[0]["curr_cd"]);  
    					ComSetObjValue(bank_acct_tp_mn_cd, list[0]["bank_acct_tp_mn_cd"]); 
    					ComSetObjValue(bank_acct_tp_sub_cd, list[0]["bank_acct_tp_sub_cd"]); 
    					ComAddSeparator(formObj.bank_acct_st_dt, "ymd");
    					ComAddSeparator(formObj.inact_dt, "ymd");
    					doActionIBSheet(sheetObj, formObj, COMMAND01); 
    				}
    				else {
    					ComShowCodeMessage("COM130401");
    				}
    			}
	            break;
           case COMMAND01:			//account leger 정보 조회
        	    formObj.f_cmd.value=COMMAND01;                    
 	   			var sXml=sheetObj.GetSearchData("STM_SAP_0090GS.do", FormQueryString(formObj));
	   			var arrXml=sXml.split("|$$|");
	   			if (sXml.length > 0) {	
	   				var list=SapXmlToListMap(arrXml[0]);
	   				if (list.length > 0) {        					
	   					formObj.aset_coa_co_cd.value=list[0]["aset_coa_co_cd"];
	   					formObj.aset_coa_rgn_cd.value=list[0]["aset_coa_rgn_cd"];
	   					formObj.aset_coa_ctr_cd.value=list[0]["aset_coa_ctr_cd"];
	   					formObj.aset_coa_acct_no.value=list[0]["aset_coa_acct_no"];
	   					formObj.aset_coa_inter_co_cd.value=list[0]["aset_coa_inter_co_cd"];
	   					formObj.aset_coa_vvd_cd.value=list[0]["aset_coa_vvd_cd"];
	   					formObj.chg_coa_co_cd.value=list[0]["chg_coa_co_cd"];
	   					formObj.chg_coa_rgn_cd.value=list[0]["chg_coa_rgn_cd"];
	   					formObj.chg_coa_ctr_cd.value=list[0]["chg_coa_ctr_cd"];
	   					formObj.chg_coa_acct_no.value=list[0]["chg_coa_acct_no"];
	   					formObj.chg_coa_inter_co_cd.value=list[0]["chg_coa_inter_co_cd"];
	   					formObj.chg_coa_vvd_cd.value=list[0]["chg_coa_vvd_cd"];
	   					formObj.gain_coa_co_cd.value=list[0]["gain_coa_co_cd"];
	   					formObj.gain_coa_rgn_cd.value=list[0]["gain_coa_rgn_cd"];
	   					formObj.gain_coa_ctr_cd.value=list[0]["gain_coa_ctr_cd"];
	   					formObj.gain_coa_acct_no.value=list[0]["gain_coa_acct_no"];
	   					formObj.gain_coa_inter_co_cd.value=list[0]["gain_coa_inter_co_cd"];
	   					formObj.gain_coa_vvd_cd.value=list[0]["gain_coa_vvd_cd"];
	   					formObj.lss_coa_co_cd.value=list[0]["lss_coa_co_cd"];
	   					formObj.lss_coa_rgn_cd.value=list[0]["lss_coa_rgn_cd"];
	   					formObj.lss_coa_ctr_cd.value=list[0]["lss_coa_ctr_cd"];
	   					formObj.lss_coa_acct_no.value=list[0]["lss_coa_acct_no"];
	   					formObj.lss_coa_inter_co_cd.value=list[0]["lss_coa_inter_co_cd"];
	   					formObj.lss_coa_vvd_cd.value=list[0]["lss_coa_vvd_cd"];
	   				}
	   				else {
	   					//ComShowCodeMessage("COM130401");
	   				}
	   			}   			        	   
        		break;
           case IBSAVE:        	   
               formObj.f_cmd.value=MULTI;    
               ComOpenWait(true);
               setTimeout( function () {            	   
            	   var sXml=sheetObj.GetSaveData("STM_SAP_0090GS.do", FormQueryString(formObj));
            	   SapOpenWait(false,true);
                   var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                   if(result != "F"){
         				ComShowCodeMessage("COM130102", "Data");    
         				var bankAcctSeq=ComGetEtcData(sXml, "BANK_ACCT_SEQ");	
         				//재조회
         				formObj.bank_acct_seq.value=bankAcctSeq;     		     				
         				doActionIBSheet(sheetObj, formObj, IBSEARCH);     
                   }else{
         				ComShowCodeMessage("COM130103", "data");
                   }
            	} , 100);
               break;
        }
    }
    /**
     * validateForm.<br>
     * @author sangyoung cha
     * @param type
     */
    function validateForm(formObj, sAction){    
		switch (sAction) {
			case IBSEARCH: //retrieve		
        		if(formObj.bank_acct_seq.value == "" && formObj.sch_bank_acct_no.value == "") {
        			ComShowCodeMessage("SAP00010", "Bank Account");
        			return false;
        		}				
				break;
			case IBSAVE:
//				if(formObj.bank_acct_seq.value == "" && formObj.sch_bank_acct_no.value == "") {
//					ComShowMessage("Bank Account is mandatory item");  			
//        			return false;
//        		}	
		        if (!ComChkValid(formObj)){
		            return false;        
		        }
		        //duration check
		        if(formObj.inact_dt.value != "") {
			        if(ComChkPeriod(ComReplaceStr(formObj.bank_acct_st_dt.value,"-",""), ComReplaceStr(formObj.inact_dt.value,"-","")) < 1)  {
			        	ComShowCodeMessage("COM132002"); // End date must be greater than start date
			        	return false;
			        }
		        }
		        if(ComTrimAll(ComGetObjValue(curr_cd)).length == 0) {
		        	ComShowCodeMessage("SAP00010", "Currency");
		        	return false;
		        }
		        //Account Use 설정
				if(formObj.chk_acct_tp_cd[0].checked==false && formObj.chk_acct_tp_cd[1].checked==false) {
					ComShowCodeMessage("SAP00010", "Account Use");
					return false;
				}
				else if(formObj.chk_acct_tp_cd[0].checked==true && formObj.chk_acct_tp_cd[1].checked==true) {
					formObj.acct_tp_cd.value="O";
				}
				else if(formObj.chk_acct_tp_cd[0].checked==true) {
					formObj.acct_tp_cd.value="P";
				}
				else {
					formObj.acct_tp_cd.value="R";
				}
				if(formObj.dps_div_cd.value == "") {
					ComShowCodeMessage("SAP00010", "Deposit Division");
					return false;
				}
		        if(ComTrimAll(ComGetObjValue(bank_acct_tp_mn_cd)).length == 0) {
		        	ComShowCodeMessage("SAP00010", "Bank Acct Type(L)");
		        	return false;
		        }
		        if(ComTrimAll(ComGetObjValue(bank_acct_tp_sub_cd)).length == 0) {
		        	ComShowCodeMessage("SAP00010", "Bank Acct Type(M)");
		        	return false;
		        }
				if(formObj.attr_ctnt1.value == "") {
					ComShowCodeMessage("SAP00010", "A/R Offset");
					return false;
				}
				if(formObj.mlt_curr_flg.value == "") {
					ComShowCodeMessage("SAP00010", "Multiple Currency Use");
					return false;
				}
				
				//Bank Account No 중복체크
				if(ComTrimAll(ComGetObjValue(formObj.bank_acct_seq)).length == 0) {
		            var param = "&bank_acct_no=" + formObj.bank_acct_no.value + "&bank_acct_tp_nm=" + formObj.bank_acct_tp_nm.value ;
					var sXml = sheetObjects[0].GetSearchData("STM_SAP_0090GS.do", "f_cmd=" + COMMAND02 + param);
					
					if (SAPDecideErrXml(sheetObjects[0], sXml)) {
						
			        } else {
			        	 if ( "DUP" == ComGetEtcData(sXml, "dup_chk") ) {
			        		 ComShowCodeMessage("SAP00014", "Number [" + formObj.bank_acct_no.value + "]");   //data is duplicated
							 return false;
			        	 }       	
			         }		
				}
				
				/** Account Info 유효성 검사 (Account Info 항목의 readonly 처리로 유효성 검사 필요없어져 주석 처리함) 					
				var cdCmbSeq="";
				// Account Info (Cash) 				
				if(formObj.aset_cd_cmb_seq.value == "") {
					alert("Please verify inputed Account Information for Cash with  Account Information Popup.");							
					return false;
				}
				cdCmbSeq=searchLeger(formObj.aset_coa_co_cd.value, formObj.aset_coa_rgn_cd.value, formObj.aset_coa_ctr_cd.value, formObj.aset_coa_acct_no.value, formObj.aset_coa_inter_co_cd.value, formObj.aset_coa_vvd_cd.value);		    	
				if(cdCmbSeq == "ERROR") {  
					alert("Unexpected system error took place during verifying inputed Account Information for Cash. Please try again later.");	    		
		    		return false;
		    	}
		    	else if(cdCmbSeq == "NO_DATA") {	
		    		alert("There is no valid Account Information for Cash. Please verify inputed Account Information for Cash with  Account Information Popup.");		    				    		
		    		return false;
		    	}		    			
		    	else if(formObj.aset_cd_cmb_seq.value != cdCmbSeq) {
		    		alert("There is no valid Account Information for Cash. Please verify inputed Account Information for Cash with  Account Information Popup.");		    				    	
		    		return false;
		    	}
		    	// Account Info (Bank Charge) 
				if(formObj.chg_cd_cmb_seq.value == "") {
					alert("Please verify inputed Account Information for Bank Charge with  Account Information Popup.");								
					return false;
				}
				cdCmbSeq=searchLeger(formObj.chg_coa_co_cd.value, formObj.chg_coa_rgn_cd.value, formObj.chg_coa_ctr_cd.value, formObj.chg_coa_acct_no.value, formObj.chg_coa_inter_co_cd.value, formObj.chg_coa_vvd_cd.value);				
				if(cdCmbSeq == "ERROR") {   
					alert("Unexpected system error took place during verifying inputed Account Information for Bank Charge. Please try again later.");							    		
		    		return false;
		    	}
		    	else if(cdCmbSeq == "NO_DATA") {	
		    		alert("There is no valid Account Information for Bank Charge. Please verify inputed Account Information for Bank Charge with  Account Information Popup.");		    				    		
		    		return false;
		    	}		    			
		    	else if(formObj.chg_cd_cmb_seq.value != cdCmbSeq) {
		    		alert("There is no valid Account Information for Bank Charge. Please verify inputed Account Information for Bank Charge with  Account Information Popup.");		    				    		
		    		return false;
		    	}				
		    	// Account Info (Ex.Gain) 
				if(formObj.gain_cd_cmb_seq.value == "") {
					alert("Please verify inputed Account Information for Ex.Gain with  Account Information Popup.");									
					return false;
				}
				cdCmbSeq=searchLeger(formObj.gain_coa_co_cd.value, formObj.gain_coa_rgn_cd.value, formObj.gain_coa_ctr_cd.value, formObj.gain_coa_acct_no.value, formObj.gain_coa_inter_co_cd.value, formObj.gain_coa_vvd_cd.value);				
				if(cdCmbSeq == "ERROR") {  
					alert("Unexpected system error took place during verifying inputed Account Information for Ex.Gain. Please try again later.");						    		
		    		return false;
		    	}
		    	else if(cdCmbSeq == "NO_DATA") {
		    		alert("There is no valid Account Information for Ex.Gain. Please verify inputed Account Information for Ex.Gain with  Account Information Popup.");		    				    		
		    		return false;
		    	}		    			
		    	else if(formObj.gain_cd_cmb_seq.value != cdCmbSeq) {
		    		alert("There is no valid Account Information for Ex.Gain. Please verify inputed Account Information for Ex.Gain with  Account Information Popup.");		    				    		
		    		return false;
		    	}					
		    	// Account Info (Ex.Loss) 
				if(formObj.lss_cd_cmb_seq.value == "") {
					alert("Please verify inputed Account Information for Ex.Loss with  Account Information Popup.");								
					return false;
				}
				cdCmbSeq=searchLeger(formObj.lss_coa_co_cd.value, formObj.lss_coa_rgn_cd.value, formObj.lss_coa_ctr_cd.value, formObj.lss_coa_acct_no.value, formObj.lss_coa_inter_co_cd.value, formObj.lss_coa_vvd_cd.value);				
				if(cdCmbSeq == "ERROR") {
					alert("Unexpected system error took place during verifying inputed Account Information for Ex.Loss. Please try again later.");						    		
		    		return false;
		    	}
		    	else if(cdCmbSeq == "NO_DATA") {
		    		alert("There is no valid Account Information for Ex.Loss. Please verify inputed Account Information for Ex.Loss with  Account Information Popup.");		    				    		
		    		return false;
		    	}		    			
		    	else if(formObj.lss_cd_cmb_seq.value != cdCmbSeq) {
		    		alert("There is no valid Account Information for Ex.Loss. Please verify inputed Account Information for Ex.Loss with  Account Information Popup.");		    				    	
		    		return false;
		    	}	
				**/
				break;
		}
    	return true;
    }	
    /**
     * obj_keypress.<br>
     * @author sangyoung cha
     */
    function obj_keypress(){
        obj=ComGetEvent();
        if(obj.dataformat == null) return;
        window.defaultStatus=obj.dataformat;
        var vKeyCode=event.keyCode;
        switch(obj.dataformat) {
            case "engup" :
                if(ComGetEvent("name")=="opn_ofc_cd") ComKeyOnlyAlphabet('upper');                
                if(ComGetEvent("name")=="ap_ctrl_ofc_cd") ComKeyOnlyAlphabet('upper');
                if(ComGetEvent("name")=="ar_ofc_cd") ComKeyOnlyAlphabet('upper');
                break;
            case "ymd" :  
    	    	if(ComGetEvent("name")=="bank_acct_st_dt") ComKeyOnlyNumber('int', "-");
    	    	if(ComGetEvent("name")=="inact_dt") ComKeyOnlyNumber('int', "-");
    	    	break;       	    		    	
        }
    }    
    /**
     * setting bank account data<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0063(rowArray) {
    	var colArray=rowArray[0];	
    	document.all.sch_bank_acct_nm.value=colArray[1];
    	document.all.sch_bank_acct_no.value=colArray[2];       	
    	document.all.bank_acct_seq.value=colArray[3];  
    }        
    /**
     * setting country data<br>
     * @author sangyoung cha
     * @param rowArray
     */
    function getCOM_ENS_0M1(rowArray) {    	
    	var colArray=rowArray[0];	
    	document.all.cntc_area_cd.value=colArray[3];
    	document.all.cntc_area_nm.value=colArray[4];    	
    }
    /**
     * setting bank branch data<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0081(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	formObj.bank_nm.value=colArray[2];
    	formObj.bank_brnc_nm.value=colArray[4];
    	formObj.bank_brnc_seq.value=colArray[1];      	
    }
    /**
     * setting Open Office data<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0001_OPEN(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	formObj.opn_ofc_cd.value=colArray[1];   			    	
    }
    /**
     * setting Control Office data<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0001_CTRL(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	formObj.ap_ctrl_ofc_cd.value=colArray[1];  			    	
    }
    /**
     * setting A/R Office data<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0360(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	formObj.ar_ofc_cd.value=colArray[1]; 	
    }    
    /**
     * setting Account Info(Cash)<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0021_aset(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	var cdCmbSeq=SapGetCOAInfo(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]); // COA 조합의 Code Combination 조회
    	if(cdCmbSeq == "ERROR") {     		
    		ComShowCodeMessage("COM132101"); // Unexpected system error took place during data processing. Please try again later.
    	}
    	else if(cdCmbSeq == "NO_DATA") {
    		//ComShowCodeMessage("COM130401"); // There is no data to search.
   		     var cmb_chk = SapAddCCID(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]);
	   		 var cmb_msg = cmb_chk[0];
	   		 var cmb_seq = cmb_chk[1];
	   		 
	   		 if (cmb_msg != "OK") {
	   			 ComShowMessage(cmb_msg);
	   			 return false;
	   		 } else {
	   			formObj.aset_coa_co_cd.value = colArray[1]; 	
	        	formObj.aset_coa_rgn_cd.value = colArray[2];
	        	formObj.aset_coa_ctr_cd.value = colArray[3];
	        	formObj.aset_coa_acct_no.value = colArray[4];
	        	formObj.aset_coa_inter_co_cd.value = colArray[5];
	        	formObj.aset_coa_vvd_cd.value = colArray[6];    		
	    		formObj.aset_cd_cmb_seq.value = cmb_seq;
	   		 }
    	}
    	else {
        	formObj.aset_coa_co_cd.value=colArray[1]; 	
        	formObj.aset_coa_rgn_cd.value=colArray[2];
        	formObj.aset_coa_ctr_cd.value=colArray[3];
        	formObj.aset_coa_acct_no.value=colArray[4];
        	formObj.aset_coa_inter_co_cd.value=colArray[5];
        	formObj.aset_coa_vvd_cd.value=colArray[6];    		
    		formObj.aset_cd_cmb_seq.value=cdCmbSeq;
    	}
    }      
    /**
     * setting Account Info(Bank Charge)<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0021_chg(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	var cdCmbSeq=SapGetCOAInfo(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]); // COA 조합의 Code Combination 조회
    	if(cdCmbSeq == "ERROR") {     		
    		ComShowCodeMessage("COM132101"); // Unexpected system error took place during data processing. Please try again later.
    	}
    	else if(cdCmbSeq == "NO_DATA") {
	   		 var cmb_chk = SapAddCCID(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]);
	   		 var cmb_msg = cmb_chk[0];
	   		 var cmb_seq = cmb_chk[1];
	   		 
	   		 if (cmb_msg != "OK") {
	   			 ComShowMessage(cmb_msg);
	   			 return false;
	   		 } else {
	   			formObj.chg_coa_co_cd.value = colArray[1]; 	
	        	formObj.chg_coa_rgn_cd.value = colArray[2];
	        	formObj.chg_coa_ctr_cd.value = colArray[3];
	        	formObj.chg_coa_acct_no.value = colArray[4];
	        	formObj.chg_coa_inter_co_cd.value = colArray[5];
	        	formObj.chg_coa_vvd_cd.value = colArray[6];    		
	    		formObj.chg_cd_cmb_seq.value = cmb_seq;
	   		 }
    	}
    	else {
        	formObj.chg_coa_co_cd.value=colArray[1]; 	
        	formObj.chg_coa_rgn_cd.value=colArray[2];
        	formObj.chg_coa_ctr_cd.value=colArray[3];
        	formObj.chg_coa_acct_no.value=colArray[4];
        	formObj.chg_coa_inter_co_cd.value=colArray[5];
        	formObj.chg_coa_vvd_cd.value=colArray[6];    		
    		formObj.chg_cd_cmb_seq.value=cdCmbSeq;
    	}
    }     
    /**
     * setting Account Info(Ex.Gain)<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0021_gain(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	var cdCmbSeq=SapGetCOAInfo(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]); // COA 조합의 Code Combination 조회
    	if(cdCmbSeq == "ERROR") {     		
    		ComShowCodeMessage("COM132101"); // Unexpected system error took place during data processing. Please try again later.
    	}
    	else if(cdCmbSeq == "NO_DATA") {
    		 var cmb_chk = SapAddCCID(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]);
	   		 var cmb_msg = cmb_chk[0];
	   		 var cmb_seq = cmb_chk[1];
	   		 
	   		 if (cmb_msg != "OK") {
	   			 ComShowMessage(cmb_msg);
	   			 return false;
	   		 } else {
	   			formObj.gain_coa_co_cd.value = colArray[1]; 	
	        	formObj.gain_coa_rgn_cd.value = colArray[2];
	        	formObj.gain_coa_ctr_cd.value = colArray[3];
	        	formObj.gain_coa_acct_no.value = colArray[4];
	        	formObj.gain_coa_inter_co_cd.value = colArray[5];
	        	formObj.gain_coa_vvd_cd.value = colArray[6];    		
	    		formObj.gain_cd_cmb_seq.value = cmb_seq;
	   		 }
    	}
    	else {
        	formObj.gain_coa_co_cd.value=colArray[1]; 	
        	formObj.gain_coa_rgn_cd.value=colArray[2];
        	formObj.gain_coa_ctr_cd.value=colArray[3];
        	formObj.gain_coa_acct_no.value=colArray[4];
        	formObj.gain_coa_inter_co_cd.value=colArray[5];
        	formObj.gain_coa_vvd_cd.value=colArray[6];    		
    		formObj.gain_cd_cmb_seq.value=cdCmbSeq;
    	}
    }     
    /**
     * setting Account Info(Ex.Loss)<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0021_lss(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	var cdCmbSeq=SapGetCOAInfo(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]); // COA 조합의 Code Combination 조회  
    	if(cdCmbSeq == "ERROR") {     		
    		ComShowCodeMessage("COM132101"); // Unexpected system error took place during data processing. Please try again later.
    	}
    	else if(cdCmbSeq == "NO_DATA") {
    		 var cmb_chk = SapAddCCID(sheetObjects[0], colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]);
	   		 var cmb_msg = cmb_chk[0];
	   		 var cmb_seq = cmb_chk[1];
	   		 
	   		 if (cmb_msg != "OK") {
	   			 ComShowMessage(cmb_msg);
	   			 return false;
	   		 } else {
	   			formObj.lss_coa_co_cd.value = colArray[1]; 	
	        	formObj.lss_coa_rgn_cd.value = colArray[2];
	        	formObj.lss_coa_ctr_cd.value = colArray[3];
	        	formObj.lss_coa_acct_no.value = colArray[4];
	        	formObj.lss_coa_inter_co_cd.value = colArray[5];
	        	formObj.lss_coa_vvd_cd.value = colArray[6];    		
	    		formObj.lss_cd_cmb_seq.value = cmb_seq;
	   		 }
    	}
    	else {
        	formObj.lss_coa_co_cd.value=colArray[1]; 	
        	formObj.lss_coa_rgn_cd.value=colArray[2];
        	formObj.lss_coa_ctr_cd.value=colArray[3];
        	formObj.lss_coa_acct_no.value=colArray[4];
        	formObj.lss_coa_inter_co_cd.value=colArray[5];
        	formObj.lss_coa_vvd_cd.value=colArray[6];    		
    		formObj.lss_cd_cmb_seq.value=cdCmbSeq;
    	}
    }         
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
