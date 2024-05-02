/*========================================================= 
*Copyright(c) 2008 CyberLogitec
*@FileName : COM_ENS_0U1.jsp
*@FileTitle : Approval Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2011-09-05
*@LastModifier : 조인영
*@LastVersion : 1.0
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2013.09.05 조인영 [CHM-201326202] ETS연동에 따른 TRS CSR삭제로직 추가 요청
* 2014.07.10 김영신 [CHM-201430993] urgent payment 기능 추가, Approval Step & Comments, Files 버튼 추가 및 활성화 기능 
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가, urgent payment 기능 제거
* 2015.05.13 심성윤 [CHM-201535807] Agmt File 버튼 클릭시 get 주소에 sub_sys_cd 추가
* 2015.07.16 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가
* 2016.06.16 유병희 [CHM-201642161] Approval 로직 수정 
=========================================================*/ 

var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects = new Array();
var comboObjects = new Array();
var comboCnt = 0;
var tabCnt = 0 ;
var beforetab = 1;
var authAproTpCd = "";
var sheetFlg = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0]; //Expense
         var sheetObject2 = sheetObjects[1]; //Basic Data default
         var sheetObject3 = sheetObjects[2]; //Basic Data TRS W/O
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_Retrieve":
        	    	
        	    	if(beforetab == 0){
        	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	    	}else if(beforetab ==1){
        	    		setAuthSheets();
        	    	}
    	            
        	        break;

        	    case "btn_New":
        	    	
        	    	if(beforetab == 0){
        	    		sheetObject.RemoveAll();
        	    		ComBtnDisable("btn_comments");
        				ComBtnDisable("btn_files");
        				ComBtnDisable("btng_reject");
        	    	}else if(beforetab ==1){
        	    		document.all.defaultAuth.style.display = 'inline';
        	    		document.all.trsAfWo.style.display = 'none';
        	    		sheetObject2.RemoveAll();
        	    		sheetObject3.RemoveAll();
        	    		formObject.pgm_no.value = "ALL";
        	            for(var k = 0; k < comboObjects.length; k++){
        	    			comboObjects[k].RemoveAll();
        	    			initCombo(comboObjects[k]);
        	    		}
        	            ComBtnDisable("btn_approve_auth");
   						ComBtnDisable("btn_disapprove_auth");
   						ComBtnDisable("btn_confirm_auth");
   						ComBtnDisable("btn_detail_auth");
        	    	}
    	                	            
        	    	formObject.reset();
        	    	doActionIBSheet2(sheetObject, formObject , IBSEARCH_ASYNC01);		
        			setPeriod();
    				
        	        break;

        	    //달력    
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
// 				var cal = new ComCalendar();
// 	    		cal.select(formObject.edate, "yyyy-MM-dd");
 	    		var cal = new ComCalendarFromTo();
 	    		
 	    		if(beforetab == 0){
 					cal.select(formObject.sdate,  formObject.edate,  'yyyy-MM-dd');
    	    	}else if(beforetab ==1){
    	    		cal.select(formObject.sdate_auth,  formObject.edate_auth,  'yyyy-MM-dd');
    	    	}
 	    		break;   
        	        
        	    case "btn_Detail":
        	    	var sRow = sheetObject.FindCheckedRow("checkbox");
                    var arrRow = sRow.split("|");
        	    	var v_csr_no = sheetObject.CellValue(arrRow[0], "csr_no");
 
        	        var height = screen.height; 
                	var width = screen.width;
                	
                	var url = "";
                	var subSysCd = sheetObject.CellValue(arrRow[0], "sub_sys_cd");
                	
	                if(subSysCd == "AGT") {
	                    var param = "?csr_no=" + v_csr_no;
	                    ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "570", false);
	                // else if(sheetObject.CellValue(selRow, "sub_sys_cd") == "TRS") {
	                }else if(subSysCd == "LSE" || subSysCd == "CHS" || subSysCd == "MGS" || subSysCd == "MNR" || subSysCd == "PSO" || subSysCd == "TLL" || subSysCd == "CNI" ) {
	                    var w = 760;
	                    var h = 510;
	                    var leftpos = width/2 - w/2; 
                    	var toppos = height/2 - h/2; 
                    	if(leftpos<0) leftpos=0;
                    	if(toppos<0) toppos=0;
                    	
    					var csrNo = sheetObject.CellValue(arrRow[0],"csr_no");
    					var costOfcCd = sheetObject.CellValue(arrRow[0],"cost_ofc_cd");
    					var currCd = sheetObject.CellValue(arrRow[0],"curr_cd");
    					var invSubSysCd = sheetObject.CellValue(arrRow[0], "sub_sys_cd");
						window.showModalDialog("/hanjin/COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd, window, "dialogWidth:820px; dialogHeight:510px; help:no; status:no; scroll:no; resizable:no;");
                    	
	                    //var url = "/hanjin/ESD_TRS_960.do?csr_no="+v_csr_no;
	                    //window.open(url, "detailPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
	                } else if(subSysCd == "TES") {
	                    var w = 800;
	                    var h = 560;
	                    var leftpos = width/2 - w/2; 
                    	var toppos = height/2 - h/2; 
                    	if(leftpos<0) leftpos=0;
                    	if(toppos<0) toppos=0;
                    	
	                    var url = "/hanjin/ESD_TES_0026.do?csr_no="+v_csr_no;
	                    window.open(url, "detailPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
	                 } else if(subSysCd == "TRS") {
	                     var url = "/hanjin/ESD_TRS_0960.do?mode=trs&csr_no="+v_csr_no;
	                     ComOpenPopup(url, 800, 495, '','1,0,1,1,1,1,1,1', false);
	                 } else if(subSysCd == "ACM") { 
	 	                 var param = "?csr_no=" +v_csr_no;
	 	                 ComOpenWindowCenter("ESM_ACM_0119.do" + param, "compop3", "700", "570", false);
	                 } else if(subSysCd == "FMS") {
	                	 var param = "s_csr_no=" + v_csr_no + "&s_flg=R";
	     				ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "", "0,0,1,1,1,1");
	                 }
        	        
        	        break;

                case "btng_confirm":
                	//심성윤 -> 여기에 탭 분기처리 필요
                	//check된 건에 대해서만 승인 처리하도록 변경 2014.07.11
                    if (sheetObject.RowCount <= 0){
                		ComShowMessage(ComGetMsg("COM130401"));
            			return false;
            		}  
                    if(sheetObject.CheckedRows("checkbox") == 0) {
                    	ComShowMessage(ComGetMsg("COM12114"));
                    	return false;
                    }
                    //var selRow = sheetObject.SelectRow;
                	//if(selRow != 0) {
	                //	if(!ComShowCodeMessage("COM12183")) {
	                //		break;
	                //	}
                	//}
                    
                    //pop-up 창에서 호출해서 사용 가능하도록 함수로 변경
                	doActionApprove();
                	
                	//doActionBtnEnable('C');              	
                	//doActionIBSheet(sheetObject,formObject,SEARCH01);
	                //doActionIBSheet(sheetObject,formObject,MULTI01);
	                
        	        break;

        	    case "btng_reject":
        	    	
        	    	//check된 건에 대해서만 승인 처리하도록 변경 2014.07.11
        	    	//reject은 한건만 가능 2014.08.14
        	        if (sheetObject.RowCount <= 0){
        	    		ComShowMessage(ComGetMsg("COM130401"));
        				return false;
        			}  
        	        if(sheetObject.CheckedRows("checkbox") == 0) {
        	        	ComShowMessage(ComGetMsg("COM12114"));
        	        	return false;
        	        }
        	        
        	        //var selRow = sheetObject.SelectRow;
					
					//if(selRow != 0) {
	        	    //	if(!ComShowCodeMessage("COM12184")) {
	        	    //		alert('dfs');
	                //		break;
	                //	}
					//}
        	        
        	        // Disapprove를 click하면 Approval Step & Comments popup창이 뜨도록 변경  2014.08.11
        	        //doActionDisapprove();
        	    	//doActionBtnEnable('C'); 				
                    //doActionIBSheet(sheetObject,formObject,MULTI02);
        	    	
        	    	var sRow = sheetObject.FindCheckedRow("checkbox");
                    var arrRow = sRow.split("|");

                    var v_apro_rqst_no = sheetObject.CellValue(arrRow[0], "apro_rqst_no");
        	    	
        	    	if(v_apro_rqst_no != "") {
        	        	var param = "?apro_rqst_no="+v_apro_rqst_no+"&btn_flag=D";
        	        	ComOpenPopup("COM_CSR_0020.do" + param, 615, 280, "", "1,0,1,1,1", true);
        	    	}
                        
        	        break;
        	    
        	    case "btng_viewapprovalstep":  
        	    	
        	    	var sRow = sheetObject.FindCheckedRow("checkbox");
                    var arrRow = sRow.split("|");
        	        
        	        var height = screen.height; 
                	var width = screen.width;
        	                          
      	            var w = 615;
                    var h = 280;
                    var leftpos = width/2 - w/2; 
                	var toppos = height/2 - h/2; 
                	if(leftpos<0) leftpos=0;
                	if(toppos<0) toppos=0;
                	
                	var v_apro_rqst_no = sheetObject.CellValue(arrRow[0], "apro_rqst_no");       	                
                	if (v_apro_rqst_no != "") {              	
                		var url = "/hanjin/COM_ENS_0W1.do?apro_rqst_no="+v_apro_rqst_no;
                		window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
                	}
                	
        	        break;
        	    
        	    case "btn_comments":

        	    	var sRow = sheetObject.FindCheckedRow("checkbox");
                    var arrRow = sRow.split("|");
                    
                    var v_apro_rqst_no = sheetObject.CellValue(arrRow[0], "apro_rqst_no");
                    var v_apsts_cd = sheetObject.CellValue(arrRow[0], "apsts_cd");
                    var url = "";
                    
        	    	if (v_apro_rqst_no != "") {     	    		     	    	    
        	    		if(v_apsts_cd == "Processing") {
        	    			url = "COM_CSR_0020.do?apro_rqst_no="+v_apro_rqst_no;
        	    		} else {
        	    			url = "COM_CSR_0020.do?apro_rqst_no="+v_apro_rqst_no+"&btn_flag=N";
        	    		}
                    	ComOpenPopup(url, 615, 280, "", "1,0,1,1,1", true);
					}   
        	    	
        	        break;
        	    	
        	    case "btn_files":
        	    	
        	    	var sRow = sheetObject.FindCheckedRow("checkbox");        	    	
                    var arrRow = sRow.split("|");
                    
        	    	var v_csr_no = sheetObject.CellValue(arrRow[0], "csr_no");
					var v_sub_sys_cd = sheetObject.CellValue(arrRow[0], "sub_sys_cd");
					//alert(v_sub_sys_cd);
	            	if(v_csr_no != "") {
	            		var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus=1|1|1&readOnly=Y&invSubSysCd="+v_sub_sys_cd;
	            		ComOpenPopup(url, 1020, 580, '', 'none', true); 
	            	}
    		    	break;
    		    	
                case "btng_editapprovalstep":  
            	    var selRow = sheetObject.SelectRow;
            	    
                    if (sheetObject.RowCount <= 0){
                		ComShowMessage(ComGetMsg("COM130401"));
            			return false;
            		}  
        	        
        	        if(selRow == 0) {
        	            ComShowCodeMessage("COM12176");   
        	            return;
        	        }
        	        
        	        var height = screen.height; 
                	var width = screen.width;
        	                          
      	            var w = 615;
                    var h = 280;
                    var leftpos = width/2 - w/2; 
                	var toppos = height/2 - h/2; 
                	if(leftpos<0) leftpos=0;
                	if(toppos<0) toppos=0;
                	
					if (   sheetObject.CellValue(selRow, 'csr_no') == undefined 
					    || sheetObject.CellValue(selRow, 'csr_no') == null ){
                        errMsg = ComGetMsg("TRS90199");
                        ComShowMessage(errMsg);
						return false;
					}                	
                	
                	var apro_rqst_no = sheetObject.CellValue(selRow, "apro_rqst_no");                	
					if (apro_rqst_no == undefined || apro_rqst_no == null || apro_rqst_no == ''){
						ComShowCodeMessage('TRS90394','Approval Request No');
						return false;
					}                	
                	
                    var v_if_sts = sheetObjects[0].CellValue(selRow, 'appyn');

                    if(v_if_sts == 'N') {
                        var v_csr_no = sheetObject.CellValue(selRow, 'csr_no');
                        var v_ofc_cd = sheetObject.CellValue(selRow, 'cost_ofc_cd');
                        var v_sub_sys_cd = sheetObject.CellValue(selRow, 'sub_sys_cd'); 
                        
                        var param = '?mode=save&ofc_cd='+v_ofc_cd+'&csr_no='+v_csr_no+'&sub_sys_cd='+v_sub_sys_cd+'&classId=COM_ENS_0T1&target_obj_nm=apro_step&apro_cfm_flg=Y"';
                        ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
                        
                    }else{
                        ComShowCodeMessage('COM12113','Approval Request Status');
                    }
        	      break;	
        	      
        	      
        	    case "btn_detail_auth":
        	    	if(sheetFlg == 0){
        	    		setAuthDetailBtn(sheetObject2);
        	    	}else if(sheetFlg == 1){
        	    		setAuthDetailBtn(sheetObject3);
        	    	}
        	    break;
        	    
        	    case "btn_approve_auth":
        	    	if(sheetFlg == 0){
        	    		doActionIBSheet2(sheetObject2,formObject,MULTI01);
        	    	}else if(sheetFlg == 1){
        	    		doActionIBSheet2(sheetObject3,formObject,MULTI01);
        	    	}
        	    break;
        	    
        	    case "btn_disapprove_auth":
        	    	if(sheetFlg == 0){
        	    		doActionIBSheet2(sheetObject2,formObject,MULTI02);
        	    	}else if(sheetFlg == 1){
        	    		doActionIBSheet2(sheetObject3,formObject,MULTI02);
        	    	}
        	    break;
        	    
        	    case "btn_confirm_auth":
        	    	if(sheetFlg == 0){
        	    		doActionIBSheet2(sheetObject2,formObject,MULTI01);
        	    	}else if(sheetFlg == 1){
        	    		doActionIBSheet2(sheetObject3,formObject,MULTI01);
        	    	}
        	    break;
        	    
        	    case "btn_save_auth":
        	    	if(sheetFlg == 0){
        	    		doActionIBSheet2(sheetObject2,formObject,MULTI03);
        	    	}else if(sheetFlg == 1){
        	    		doActionIBSheet2(sheetObject3,formObject,MULTI03);
        	    	}
        	    	break;
        	   

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg("COM12111"));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    /**
     * confirm 처리 function <br>
     * @param  
     * @return 없음
     * @author 
     * @version 2014.07.11
     */	
    function doActionApprove() {
    	 	
    	var sheetObject = sheetObjects[0];
        var formObject = document.form;

        doActionBtnEnable('C'); 
    	doActionIBSheet(sheetObject,formObject,SEARCH01);
    	doActionIBSheet(sheetObject,formObject,MULTI01);
    }
    
    /**
     * reject 처리 function <br>
     * Approval Step & Comments popup창에서 호출해서 사용
     * @param  
     * @return 없음
     * @author 
     * @version 2014.07.11
     */	
    function doActionDisapprove() {
    	
    	var sheetObject = sheetObjects[0];
        var formObject = document.form;

        doActionBtnEnable('C'); 
        doActionIBSheet(sheetObject,formObject,MULTI02);
    }
    
    
    /**
    * Action 버튼의 활성/비활성을 설정한다. <br>
    * @param  invStatus String
    * @param  statusCd String
    * @return 없음
    * @author 김창식
    * @version 2009.10.12
    */	
   function doActionBtnEnable (invStatus){
   	 
   	// Invoice Confirm 버튼 활성/비활성
   	if(invStatus == 'S'){
   		ComBtnEnable("btng_confirm");
   	} else {
   		ComBtnDisable("btng_confirm");
   	}
   }
   
   /**
    * Action 버튼의 활성/비활성을 설정한다. <br>
    * @param  invStatus String
    * @param  statusCd String
    * @return 없음
    * @author 심성윤
    * @version 2015.07.18
    */	
   function doActionBtnEnableAuth (authStatus){
   	if(authAproTpCd =="BF"){
   		if(authStatus == 'S'){
   			ComBtnEnable("btn_approve_auth");
   			ComBtnDisable("btn_confirm_auth");
   	   	} else {
   	   		ComBtnDisable("btn_approve_auth");
   		    ComBtnDisable("btn_confirm_auth");
   	   	}
   	}else if(authAproTpCd =="AF"){
   		if(authStatus == 'S'){
   	   		ComBtnDisable("btn_approve_auth");
   	   		ComBtnEnable("btn_confirm_auth");
   	   	} else {
   	   		ComBtnDisable("btn_approve_auth");
   		    ComBtnDisable("btn_confirm_auth");
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
        
        // IBTab 초기화
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		//IBMultiCombo 초기화
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		
        
        formObj = document.form;
        axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
        axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
        axon_event.addListenerForm  ('click'	   , 'obj_onclick'   , 	document.form); //라디오 버튼
        
        
        var formObj  = document.form;
		var sheetObj = sheetObjects[0];
        doActionIBSheet2(sheetObj, formObj , IBSEARCH_ASYNC01);		
		setPeriod();
        // Detail, Approval Step, Approval Step & Comments, Files, Disapprove 버튼 비활성화
        //Expense
        ComBtnDisable("btn_comments");
        ComBtnDisable("btn_files");
        ComBtnDisable("btn_Detail");
        ComBtnDisable("btng_viewapprovalstep");     
        ComBtnDisable("btng_reject");
        
        //Basic Data
        ComBtnDisable("btn_approve_auth");
        ComBtnDisable("btn_disapprove_auth");
        ComBtnDisable("btn_confirm_auth");
        ComBtnDisable("btn_detail_auth");     
        
        formObj.if_status.disabled = true;
        
    }

    /**
     * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
     * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init Expense
                with (sheetObj) {
            	    // 높이 설
                    style.height = 420;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone , msPㅅrevColumnMerge + msHeaderOnly]
    				MergeSheet =  msHeaderOnly;
    				
    				// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(28, 0, 0, true);

                    //Row Height Fix
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle = "||NO||ALPS Status|I/F Status|Module|Date|Cost Office|CSR No.|No. Of INV|Payment S/P|Payment S/P|Payment Due Date|Paid Date|Currency|Total Amount|ASA Amount|USD Amount|GW Contract|Contract|Files||Remark||||ASA No." ;
                    //var HeadTitle = "NO|STS||Date|Cost Office|CSR No.|No of INV.|Payment S/P|payment Due Date|Currency|Total Amount|Remark|" ;

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,      DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "checkbox",        false,          "",       dfNone,   	0,     true,       	true);                    
                    InitDataProperty(0, cnt++ , dtStatus,     0,    daCenter,  true,     "ibflag",          false,        	"",       dfNone,   	0,     false,      	false);  
                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,    "apro_rqst_no",    false,          "",       dfNone,	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "apro_rqst_seq",   false,          "",       dfNone,	    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "alps_status",     false,          "",       dfNone,   	0,     false,      	false);		
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "if_status",       false,          "",       dfNone,   	0,     false,      	false);		
					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,    "sub_sys_cd",      false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "rqst_st_dt",      false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "cost_ofc_cd",     false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  false,    "csr_no",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "inv_knt",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,    "vndr_seq",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     100,    daLeft,    false,    "vndr_nm",         false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     120,    daCenter,  false,    "pay_due_dt",      false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "pay_dt",        	false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "curr_cd",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      90,    daRight,   false,    "apro_ttl_amt",    false,          "",       dfFloat,   	2,     false,       false, 2);  
                    InitDataProperty(0, cnt++ , dtData,      90,    daRight,   false,    "asa_amt",    		false,          "",       dfFloat,   	2,     false,       false, 2); 
                    InitDataProperty(0, cnt++ , dtHidden,   110,    daRight,   false,    "csr_usd_amt",     false,          "",       dfFloat,   	2,     false,       false, 2); //추가    

                    InitDataProperty(0, cnt++ , dtPopup,	80, 	daCenter,  false,    "agmt_doc_cfm_cd",	false,			"",		  dfNone,		0,		true,		true);	//추가
					InitDataProperty(0, cnt++ , dtPopup,	70, 	daCenter,  false,    "agmt_file_cfm_cd",false,			"",		  dfNone,		0,		true,		true);	//추가
					InitDataProperty(0, cnt++ , dtPopup,	50, 	daCenter,  false,    "file_upld_flg",	false,			"",		  dfNone,		0,		true,		true);	//추가
					
					InitDataProperty(0, cnt++ , dtHidden,     10,    daCenter,  false,    "chk_curr_apro_usr_yn",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "apro_rmk",        false,          "",       dfNone,   	0,     false,       true);     
                    InitDataProperty(0, cnt++ , dtHidden,     90,    daCenter,  false,    "file_knt",        false,          "",       dfNone,   	0,     false,        false);	//추가
                    InitDataProperty(0, cnt++ , dtHidden,      60,    daCenter,  false,    "cmt_yn",        	false,          "",       dfNone,   	0,     false,       false);	//추가
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "appyn",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     	60,    daCenter,  false,    "asa_no",        	false,          "",       dfNone,   	0,     false,       false);
                    
                    ColHidden(1) = true;
                    PopupImage  =  "/hanjin/img/btns_search.gif";  
                    ShowButtonImage = 2; 
             }
             break;
             
    		
		   
    		case 2:      //Basic Data, DefaultAuth
                with (sheetObj) {
            	    // 높이 설정
                    style.height = 405;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
    				MergeSheet =  msHeaderOnly;
    				
    				// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);
                    //InitColumnInfo(11, 0, 0, true);

                    //Row Height Fix
                    InitHeadMode(true, true, true, true, false,false)

                   var HeadTitle = "|Seq|||Module|App Type||Menu||Excel|RQST Date|RQST ID|RQST Name|RQST\nOffice||RQST Remark|" ;

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,      DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true,     "ibflag",           false,        	"",       dfNone,   	0,     false,      	false);
                    InitDataProperty(0, cnt++ , dtSeq,      	30,    daCenter,  false,    "seq");
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "checkbox",        false,          "",       dfNone,   	0,     true,       	true); 
                    InitDataProperty(0, cnt++ , dtHidden,     	100,    daCenter,  false,    "auth_apro_rqst_no",    false,          "",       dfNone,	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "sub_sys_cd",       false,          "",       dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  false,    "auth_apro_tp_nm",     	false,          "",       dfNone,   	0,     false,      	false);
					InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,  false,    "auth_apro_tp_cd",       false,          "",       dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	120,    daLeft,  false,    "pgm_nm",      false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  false,    "pgm_no",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  false,    "xls_flg",      false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "rqst_st_dt",        	false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "rqst_usr_id",         false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "rqst_usr_nm",         false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "rqst_ofc_cd",       false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      	100,    daCenter,  false,    "rqst_rsn_rmk",       false,          "",       dfNone,   	0,     false,       false);//임시 savename
                    InitDataProperty(0, cnt++ , dtData,      	200,    daLeft,  false,    "auth_apro_rmk",       false,          "",       dfNone,   	0,     true,       true);//임시 savename
                    InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,   false,    "dtl_pgm_url_ctnt",     false,          "",       dfNone,   	0,     false,       false);
                    
                   //ColHidden(1) = true;
//                    PopupImage  =  "/hanjin/img/btns_search.gif";  
//                    ShowButtonImage = 2; 
             }
             break;
             
    		case 3:      //TRS W/O용
                with (sheetObj) {
            	    // 높이 설정
                    style.height = 405;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
    				MergeSheet =  msPrevColumnMerge + msHeaderOnly;
                    //MergeSheet = msAll;
    				// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(28, 0, 0, true);
                    //InitColumnInfo(11, 0, 0, true);

                    //Row Height Fix
                    InitHeadMode(true, true, true, true, false,false)

                   var HeadTitle = "|Seq|||Module|App\nType||Menu||||W/O No.|S/P\nCode|S/P\nName|From Node|Via Node|To Node|Door\nLocation|Request Type|Approval\nAMT||RQST Date|RQST ID|RQST Name|RQST Office||Approval Remark" ;
                    
                    //Request Type|S/O Type|Cost\nMode|W/O No.|S/P\nCode|S/P\nName|From Node|Via Node|To Node|Door\nLocation|Approval\nAMT|

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,      DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,     	100,    daCenter,  true,    "auth_apro_rqst_no",    false,          "",       dfNone,	    0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,    "seq",        false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  true,    "checkbox",        false,          "",       dfNone,   	0,     true,       	true, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  true,     "ibflag",           false,        	"",       dfNone,   	0,     false,      	false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "sub_sys_cd",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
					InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,  false,    "auth_apro_tp_nm",     	false,          "",       dfNone,   	0,     false,      	false, 		-1,		false,		false );
					InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,  false,    "auth_apro_tp_cd",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
					InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "pgm_nm",      false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  false,    "pgm_no",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    /* TRS START */
                    
                    InitDataProperty(0, cnt++ , dtHidden,      	100,    daCenter,  false,    "trsp_so_tp_nm",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtHidden,      	120,    daCenter,  false,    "trsp_cost_dtl_mod_nm",false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "trsp_wo_no",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	 50,    daCenter,  false,    "vndr_seq",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	140,    daLeft,    false,    "vndr_nm",        	    false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	 80,    daCenter,  false,    "fm_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "via_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "to_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	 70,    daCenter,  false,    "dor_nod_cd",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	110,    daLeft,    false,    "request_type",        false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	80,    daRight,   false,    "approval_amt",        false,          "",       dfFloat,   	2,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtHidden,     	  0,    daCenter,  false,    "auth_apro_rqst_no_seq",      		false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    /* TRS END */
                    InitDataProperty(0, cnt++ , dtData,      	120,    daCenter,  false,    "rqst_st_dt",        	false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  false,    "rqst_usr_id",         false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,    "rqst_usr_nm",         false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  false,    "rqst_ofc_cd",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );
                    InitDataProperty(0, cnt++ , dtHidden,      	200,    daLeft,  false,    "rqst_rsn_rmk",       false,          "",       dfNone,   	0,     false,       false, 		-1,		false,		false );//임시 savename
                    InitDataProperty(0, cnt++ , dtData,      	450,    daLeft,  true,    "auth_apro_rmk",       false,          "",       dfNone,   	0,     true,       true, 		1000,		false,		false );//임시 savename
                    InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,   false,    "dtl_pgm_url_ctnt",     false,          "",       dfNone,   	0,     false,       false);
                    
                    HeadRowHeight = 50;
//                    ColHidden(1) = true;
//                    PopupImage  =  "/hanjin/img/btns_search.gif";  
//                    ShowButtonImage = 2; 
             }
             break;
    		case 4: //
				with (sheetObj) {
    			style.height = 0; // 높이 설정
    			SheetWidth = 0; //전체 너비 설정
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
    			MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
    			Editable = false; //전체Edit 허용 여부 [선택, Default false]
    			InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitColumnInfo(1, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false,false)

    			var HeadTitle0 = "cnt";

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle0, true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "cnt", false, "", dfNone, 0, false, false);						
    		
		   }
		   break;
        }
    }
    
  	/** 
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      * @param  없음
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */ 
     function obj_keypress(){
    	 obj = event.srcElement;
    	 if(obj.dataformat == null) return;
    	 	
    	 window.defaultStatus = obj.dataformat;
    	 switch(obj.dataformat) {
    	 	case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	        break;
    	    case "eng":
    	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    case "engup":
    	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    
    	 }
     } 
     
     /** 
      * Object 의 deactivate 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */
     function obj_deactivate(){
    	 var formObj = document.form;
    	 obj = event.srcElement;
      
    	 if(obj.name=="sdate"  ){
        			
    		 with(formObj){
 	        			
    			 var creDtFr = ComReplaceStr(sdate.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
        }
      	if(obj.name=="edate"  ){
 			
   		 with(formObj){
 	        			
   			 var creDtFr = ComReplaceStr(edate.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
       }
      	
      	//Basic Data Tab
      	 if(obj.name=="sdate_auth"  ){
 			
    		 with(formObj){
 	        			
    			 var creDtFr = ComReplaceStr(sdate.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
        }
      	if(obj.name=="edate_auth"  ){
 			
   		 with(formObj){
 	        			
   			 var creDtFr = ComReplaceStr(edate.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
       }
        	
     }
      
      /**
       * AXON 이벤트 처리
       */
      function obj_activate(){
          ComClearSeparator(event.srcElement);
      }
     
    function sheet1_OnSearchEnd() {
    	var sheetObj = sheetObjects[0];
    	for(var i=0; i<sheetObj.RowCount; i++) {
            if(sheetObj.CellValue(i + 1, "appyn") == "Y" || sheetObj.CellValue(i + 1, "chk_curr_apro_usr_yn") != "Y") {
                sheetObj.CellEditable(i + 1, "checkbox") = false;
                sheetObj.CellEditable(i + 1, "apro_rmk") = false;
            }
        }
    	
    	ComBtnEnable("btng_confirm");
    	
    	ComBtnDisable("btn_comments");
        ComBtnDisable("btn_files");
        ComBtnDisable("btn_Detail"); 
        ComBtnDisable("btng_reject");
    }
    
    function sheet1_OnSaveEnd() {
    	var sheetObj = sheetObjects[0];
    	for(var i=0; i<sheetObj.RowCount; i++) {
            if(sheetObj.CellValue(i + 1, "appyn") == "Y" || sheetObj.CellValue(i + 1, "chk_curr_apro_usr_yn") != "Y") {
                sheetObj.CellEditable(i + 1, "checkbox") = false;
                sheetObj.CellEditable(i + 1, "apro_rmk") = false;
            }
        }
    	
    	ComBtnEnable("btng_confirm");
    	
    	ComBtnDisable("btn_comments");
        ComBtnDisable("btn_files");
        ComBtnDisable("btn_Detail"); 
        ComBtnDisable("btng_reject");
    }
    
    function sheet1_OnChange(sheetObj , row , col, value)
    {
    	var formObj = document.form;
		var sName = sheetObj.ColSaveName(col);
		var rows = sheetObj.Rows;
		var pi = 0;

		//기존 로직 
		if (sName == "checkbox") {
   			if(row > 0 && row < rows) {
   				if(sheetObj.cellvalue(row,"checkbox") == 1) {	 //Check
   					//버튼 활성  				
   					doActionBtnEnable('S');
   				}
   				
   				//한개 선택한 경우에만 Detail, Approval Step, Approval Step & Comments, Files, Disapprove 버튼 활성화
   				if(sheetObj.CheckedRows("checkbox") == 1) {		  					
   					ComBtnEnable("btn_comments");
   					ComBtnEnable("btn_files");
   					ComBtnEnable("btn_Detail");
   					ComBtnEnable("btng_viewapprovalstep");
   					if (sheetObj.CellValue(sheetObj.SelectRow,"chk_curr_apro_usr_yn") == "Y"){
   						ComBtnEnable("btng_reject");	
   					}
   				} else {
   					ComBtnDisable("btn_comments");
   					ComBtnDisable("btn_files");
   					ComBtnDisable("btn_Detail");
   					ComBtnDisable("btng_viewapprovalstep");    
   					ComBtnDisable("btng_reject");
   				}
   			}
		}
		
    }

 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

          case IBSEARCH:        //???
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                
                if(formObj.alps_status.value != "R") {
                   sheetObj.RowEditable(4) = false;
                }
               
                formObj.f_cmd.value = SEARCHLIST;                
                selectVal = FormQueryString(formObj)
                sheetObj.DoSearch4Post("COM_ENS_0U1ViewGS.do", selectVal);
           break;
           
           case IBSEARCHAPPEND:  // ????¡ ???
                formObj.f_cmd.value = SEARCHLIST;  
                sheetObj.DoSearch4Post("COM_ENS_0U1GS.do", selectVal, "iPage=" + PageNo, true);
           break;

           case IBINSERT:      // ???
                //sheetObj.DataInsert();
                //???ο? ROW??? ?? KEY ???? ???
                var Row = sheetObj.DataInsert(0); 
                sheetObj.CellValue(Row,"hol_knd_cd") = "C";
                
                break;

           case IBDOWNEXCEL:        //???? ???ε?
              sheetObj.Down2Excel(-1, false, false, true);
              break;
           
           case MULTI01:        // Confirm
                for(var i=0; i<sheetObj.RowCount; i++) {
                    if(sheetObj.CellValue(i + 1, "checkbox") == 1) {
                        sheetObj.CellValue2(i + 1, "ibflag") = "U";
                    }
                }
                
                formObj.f_cmd.value = MULTI01;
    			//파라미터 명시적인 생성
    			var formParams = "";
    			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
                var param = sheetObj.GetSaveString(false,true,1);
                //sheetObj.DoSave("COM_ENS_0U1ViewGS.do", FormQueryString(formObj), 1, false);
    			
                var sXml = sheetObj.GetSearchXml("COM_ENS_0U1ViewGS.do", param+'&'+formParams);
                // Error Msg Handling Start
	            if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
			     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
			     		ComShowMessage(rmsg[3]);
			     	} else {
			     		sheetObj.LoadSaveXml(sXml);
			     		return;
					}
	            }
	            // Error Msg Handling End
	            
    			var key = ComGetEtcData(sXml,"key");

    	        if (key.length > 0) {
    				gRefresh = true; // 결과 file에서 조회해야함
    	            formObj.key.value = key;
    	            sheetObj.WaitImageVisible = false;
    	            ComOpenWait(true);
    	            sheetObj.RequestTimeOut = 1000;
    	            timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
    	        }
           break;
           
           case SEARCH01:        // Invoice 존재여부 체크
               for(var i=0; i<sheetObj.RowCount; i++) {
                   if(sheetObj.CellValue(i + 1, "checkbox") == 1) {
                       sheetObj.CellValue2(i + 1, "ibflag") = "U";
                   }
               }
               
               formObj.f_cmd.value = SEARCH01;
   			//파라미터 명시적인 생성
   			var formParams = "";
   			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
            var param = sheetObj.GetSaveString(false,true,1);
            sheetObjects[1].DoSearch4Post("COM_ENS_0U1ViewGS.do", param+'&'+formParams);
            
           break;
                
           case IBSEARCH_ASYNC02: 
               formObj.f_cmd.value = SEARCHLIST02;
               selectVal = FormQueryString(formObj)
               //sheetObj.DoSearch4Post("COM_ENS_0U1ViewGS.do", selectVal);
     		    var sXml = sheetObj.GetSearchXml("COM_ENS_0U1ViewGS.do", selectVal);
     		    var jobState = ComGetEtcData(sXml, "jb_sts_flg")
     		    var jobError = ComGetEtcData(sXml, "jb_usr_err_msg")
     		    if (jobState == "3") {
     		        ComOpenWait(false);
     		        ComShowCodeMessage("CSR25021");
     		        if (gRefresh)
     		        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
     		        clearInterval(timer);
     		    } else if (jobState == "4") {
     		        ComOpenWait(false);
     		        clearInterval(timer);
     		        // BackEndJob을 실패 하였습니다.
     		        ComShowMessage(jobError);
     		    } else if (jobState == "5") {
     		        ComOpenWait(false);
     		        clearInterval(timer);
     		        // 이미 BackEndJob 결과 파일을 읽었습니다.
     		        ComShowCodeMessage('JOO00152');
     		    }
            break;
                
           case MULTI02:        // Reject
                for(var i=0; i<sheetObj.RowCount; i++) {
                    if(sheetObj.CellValue(i + 1, "checkbox") == 1) {
                        sheetObj.CellValue2(i + 1, "ibflag") = "U";
                    }
                }
                
                formObj.f_cmd.value = MULTI02;    
                sheetObj.DoSave("COM_ENS_0U1ViewGS.do", FormQueryString(formObj), 1, false);
                break;
                
                
        }
    }
    
    
 // Sheet관련 프로세스 처리
 // Authorization
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

          case IBSEARCH:    
        	  
        	  if(!validateForm_auth(sheetObj,formObj,sAction)) {
                  return false;
              }
                formObj.f_cmd.value = COMMAND01;                
                selectVal = FormQueryString(formObj);
//                else if(formObj.auth_apro_tp_cd.value == null){
//            		ComShowCodeMessage('COM12113',"App Type") ;
//            		formObj.auth_apro_tp_cd.focus() ;
//            		rtnVal = false;
//            	}
                sheetObj.DoSearch4Post("COM_ENS_0U1GS_AUTH.do", selectVal);
           break;
           
          case MULTI01:       
        	  
        	  for(var i=0; i<sheetObj.RowCount; i++) {
                  if(sheetObj.CellValue(i + 1, "checkbox") == 1) {
                      sheetObj.CellValue2(i + 1, "ibflag") = "U";
                  }
              }
	        	formObj.f_cmd.value = COMMAND02;                
	        	//sheetObj.DoSave("COM_ENS_0U1GS_AUTH.do", selectVal, -1, false);
	        	
	        	var param = sheetObj.GetSaveString(false,true,"checkbox");
	        	//alert(param+"&"+FormQueryString(formObj));
	        	var sXml = sheetObj.GetSearchXml("COM_ENS_0U1GS_AUTH.do", param+"&"+FormQueryString(formObj),"",true);
	        	sheetObj.LoadSaveXml(sXml, true);
          break;
       
          case MULTI02:        
	            formObj.f_cmd.value = COMMAND03;                
	            selectVal = FormQueryString(formObj);
	            sheetObj.DoSave("COM_ENS_0U1GS_AUTH.do", selectVal, -1, false);
         break;    
         
          case MULTI03:   
        	  if(sheetFlg == 1){
	        	  for(var i=0; i<sheetObj.RowCount; i++) {
	                  //if(sheetObj.CellValue(i + 1, "checkbox") == 1) {
	                	  if(sheetObj.CellValue(i + 1, "auth_apro_rqst_no_seq") != 1){
	                		  sheetObj.CellValue2(i + 1, "ibflag") = "R";
	                	  }
	                      
	                 // }
	              }
        	  }
        	  
	            formObj.f_cmd.value = COMMAND04;                
	            selectVal = FormQueryString(formObj);
	            //alert(selectVal);
	            sheetObj.DoSave("COM_ENS_0U1GS_AUTH.do", selectVal, -1, false);
       break; 
         
          case IBSEARCH_ASYNC01:	//권한 로케이션 날짜 조회
  			var sXml = getInputValue(sheetObj,formObj.ofc_cd.value);
  			//alert(sXml);
  			//if(ComGetEtcData(sXml, "ofc_cd") != 'null'){
  				ComSetObjValue(formObj.DB_DATE, ComGetEtcData(sXml, "curr_date"));
  			//}
  			break;
  			
          case IBSEARCH_ASYNC02:	//TRS용 Confirm 대상
        	  if(!validateForm_auth(sheetObj,formObj,sAction)) {
                  return false;
              }
        	  formObj.f_cmd.value = COMMAND50;                
	            selectVal = FormQueryString(formObj);
	            sheetObj.DoSearch4Post("COM_ENS_0U1GS_AUTH.do", selectVal);
    			break;
          
        }
    }
  
   /**
     * ??? ????°??? ???? ????????? ???μ??? o??
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }
    
    function releasePage() {
    	event.returnValue = "If you navigate away from this page now, the approval can't be completed successfully."
    }
    
	 function UF_getBackEndJobStatus() {
			//alert("UF_getBackEndJobStatus");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	}
	 
 /**
  * OnPopupClick 이벤트 발생시 호출되는 function <br>
  * Sheet1 Popup버튼 클릭시 팝업화면 호출. 팝업화면에서 수정된 결과는 해당 sheet의 내용을 조합하여 Sheet1에 다시 Update해준다.
  * 
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
  * @return 없음
  * @author 
  * @version 2014.08.25
  */
 function sheet1_OnPopupClick(sheetObj, Row, Col) {
 	var colName = sheetObj.ColSaveName(Col);

   	if (colName == "agmt_doc_cfm_cd" || colName == "agmt_file_cfm_cd" || colName == "file_upld_flg") {
   		if(sheetObj.RowCount > 0){
   			var v_csr_no = sheetObj.CellValue(Row, "csr_no");
 			
         	if(v_csr_no != "") {
             	var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus=1|1|1&readOnly=Y";
             	ComOpenPopup(url, 1020, 580, '', 'none', true); 
         	}
   		}
   	}	 	
 }
	 
 /**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}
		
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Expense", -1);
			InsertTab(cnt++, "Basic Data", -1);
		}
		break;
	}
}
		
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;
	if(beforetab == 1){
		document.form.auth_apro_tp_cd.value = "ALL";
	}
}
		
/**
 * Radio 클릭시 이벤트 관련
 * 
 */
function obj_onclick(){
	var formObj = document.form;
	var obj	 = event.srcElement;
	if ( obj.name == "auth_apro_tp_cd" ) {
		authAproTpCd = ComGetObjValue(obj);
		formObj.auth_apro_tp_cd.value = authAproTpCd;
		//comboObjects[2].RemoveAll();
		comboObjects[1].RemoveAll();
		setComboData(comboObjects[1]);
		document.form.pgm_no.value = "";//Menu 초기화
		setComboData(comboObjects[0], authAproTpCd); 
		//alert(comboObjects[0].id);
	}
}
		
/**  
 * IBCombo Object를 배열로 등록
 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj){     
	comboObjects[comboCnt++] = combo_obj;  
}	
		
/**
 * IBCombo 기본 설정
 * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
 */
function initCombo(comboObj) {
	var formObject = document.form;
	switch(comboObj.id) {  
	
		case "pgm_no": 	//Year
			with (comboObj) { 
			
				MultiSelect = false; 
				UseAutoComplete = false;
				UseCode = true;
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
//						ValidChar(2,0);	//영문대문자
//						MaxLength = 5;
				
				setComboData(comboObj);
			}
		break;
		
						
		case "sub_sys_cd_auth": 	
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = false;
				UseCode = true;
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
//						ValidChar(2,0);	//영문대문자
//						MaxLength = 5;
				
				setComboData(comboObj, "ALL");
			}
		break;
	
	}
}
		
function setComboData(comboObj, param){ 
	var comboID = comboObj.id;
	var formObj = document.form;
	var sheetObj = sheetObjects[1];
	switch(comboID){
		case "pgm_no":	
			if(param == "ALL"){
				comboObj.InsertItem(0, "--ALL--", "ALL");
				comboObj.Code2 = "ALL";
			}else{
				var sParam = "f_cmd=" + COMMAND02 + "&sub_sys_cd_auth="+param;
				var xml = sheetObj.GetSearchXml("COM_ENS_0U2GS_AUTH.do", sParam );
				ComXml2ComboItem(xml,formObj.pgm_no,"pgm_no","pgm_nm");	
				comboObj.InsertItem(0, "--ALL--", "ALL");
				comboObj.Code2 = "ALL";
			}		
			break;
			
		
		case "sub_sys_cd_auth":		
			var sParam = "f_cmd=" + COMMAND01+"&auth_apro_tp_cd="+param;
	
			var xml = sheetObj.GetSearchXml("COM_ENS_0U2GS_AUTH.do", sParam );
			ComXml2ComboItem(xml,formObj.sub_sys_cd_auth,"sub_sys_cd_auth","sub_sys_cd");
			comboObj.InsertItem(0, "--ALL--", "ALL");
			comboObj.Code2 = "ALL";
			document.form.sub_sys_cd_auth.value="ALL";
			break;
		
	}
	
	
}
		
		
/**
 * 모듈 변경시
 * @param comboObj
 * @param Index_Code
 * @param Text
 */
function sub_sys_cd_auth_OnChange(comboObj, Index_Code, Text){
	comboObjects[1].RemoveAll();
	setComboData(comboObjects[1], Index_Code);
	document.form.sub_sys_cd_auth.value = Index_Code;
	document.form.pgm_no.value = "";//Menu 초기화
}


/**
 * Menu 변경시
 * @param comboObj
 * @param Index_Code
 * @param Text
 */
function pgm_no_OnChange(comboObj, Index_Code, Text){
	document.form.pgm_no.value = Index_Code;
}




/**
 * Authorization OnSearchEnd
 */
function sheet2_OnSearchEnd() {
	//Basic Data Common
	setAuthButtonInit();
}

function sheet3_OnSearchEnd() {
	//TRS W/O 전용
	setAuthButtonInit();
	
	var sheetObj = sheetObjects[2];
	var rows = sheetObj.Rows;
	var ibflgSts = null;
	for(var i=1; i<rows; i++){
		if(sheetObj.cellValue(i, "auth_apro_rqst_no_seq")!=1){
			sheetObj.CellEditable(i,"auth_apro_rmk") = false;
			ibflgSts = sheetObj.CellValue(i,"ibflag");
			sheetObj.CellValue(i,"auth_apro_rmk") = "";
			sheetObj.CellValue2(i,"ibflag") = ibflgSts;
			//sheetObj.CellEditable(i,'checkbox') = false;
			
			//개발중
		}else if(sheetObj.cellValue(i, "auth_apro_rqst_no_seq")==1){
			sheetObj.CellEditable(i,"auth_apro_rmk") = true;
		}
//		sheetObj.CellEditable(i,"auth_apro_rmk") = true;
	}
//	for(var i=1; i<rows; i++){
//		var rqstNo = sheetObj.cellValue(i,"auth_apro_rqst_no");
//		var cnt = 0;
//		for(var j=1; j<rows; j++){
//			if(sheetObj.cellValue(j,"auth_apro_rqst_no")==rqstNo){
//				cnt = cnt+1;
//			}
//		}
//		if(cnt>1){
//			alert(rqstNo+"   "+cnt+"   "+i);
//			
//		}
//	}
}

/**
 * Authorization OnSaveEnd
 */
function sheet2_OnSaveEnd() {
	//Basic Data Common
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	doActionIBSheet2(sheetObj,formObj,IBSEARCH);
}

function sheet3_OnSaveEnd() {
	//TRS W/O 전용
	var sheetObj = sheetObjects[2];
	var formObj = document.form;
	doActionIBSheet2(sheetObj,formObj,IBSEARCH_ASYNC02);
}
		
/**
 * Authorization OnChange
 */
function sheet2_OnChange(sheetObj , row , col, value){
	//Basic Data Common
	setAuthButtonOnChange(sheetObj , row , col, value);
}

function sheet3_OnChange(sheetObj , row , col, value){
	//TRS W/O 전용
	
	
	var sName = sheetObj.ColSaveName(col);
	var rows = sheetObj.Rows;
	
	//체크 박스 Merge
	if (sName == "checkbox") {
		var rqstNo = sheetObj.cellValue(row,"auth_apro_rqst_no");
		//if(row > 0 && row < rows) {
			if(sheetObj.cellValue(row,"checkbox") == 1) {	 //Check
				setAuthButtonOnChange(sheetObj , row , col, value);
				//버튼 활성
//				alert(sheetObj.cellValue(row,"auth_apro_rqst_no"));
				for(var i=1; i<rows; i++){
					if(sheetObj.cellValue(i,"auth_apro_rqst_no")==rqstNo){
						sheetObj.cellValue2(i,"checkbox") = 1;
						
						if(sheetObj.CellValue(i, "auth_apro_rqst_no_seq") != 1)
							sheetObj.CellValue2(i, "ibflag") = "R";
					}
				}
			}else{
				for(var i=1; i<rows; i++){
					if(sheetObj.cellValue(i,"auth_apro_rqst_no")==rqstNo){
						sheetObj.cellValue2(i,"checkbox") = 0;
						if(sheetObj.CellValue(i, "auth_apro_rqst_no_seq") != 1)
							sheetObj.CellValue2(i, "ibflag") = "R";
					}
				}
				
				setAuthButtonOnChange(sheetObj , row , col, value);
			}	
			
			
		//}
	}

}

/**
 * Authorization OnClick (MEMO)
 */
function sheet2_OnClick(sheetObj, Row, Col, Value) {
	//Basic Data Common
	//setAuthOnClickEvt(sheetObj, Row, Col, Value);
}

function sheet3_OnClick(sheetObj, Row, Col, Value) {
	//TRS W/O 전용
	//setAuthOnClickEvt(sheetObj, Row, Col, Value);
}


/**
 * Search Validation_auth
 */
function validateForm_auth(sheetObj,formObj,sAction){
	var rtnVal = true;
	if(ComTrimAll(formObj.sdate_auth) == ""){
		ComShowCodeMessage('COM12132') ;
		formObj.sdate_auth.focus() ;
		rtnVal = false;
	}else if(ComTrimAll(formObj.edate_auth) == ""){
		ComShowCodeMessage('COM12132') ;
		formObj.edate_auth.focus() ;
		rtnVal = false;
	
	}
		
    return rtnVal;
}


function setPeriod(){
	var formObj = document.form;
	var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
	var fr_dt;
	if (to_dt!=undefined && to_dt!=null && to_dt.trim()!='' && to_dt.length==8 && !isNaN(to_dt)){
		//fr_dt = csr_getDiffDate(to_dt, -30, 'D');
		fr_dt = getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
		if (fr_dt!=undefined && fr_dt!=null && fr_dt.trim()!='' && fr_dt.length==8){
			if (fr_dt.substring(6,8) > getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6))){
				
				fr_dt = fr_dt.substring(0,6) + getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6));
			}
			
			formObj.sdate.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
			formObj.edate.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
			formObj.sdate_auth.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
			formObj.edate_auth.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
		}
	}	
}

function getDiffDate(sdate, sdiff, stype) {
	/***********************************************************
		sdate:  YYYYMMDD 형식의 문자열
		sdiff:  차이값
		stype:	'Y' - 년
				'M' - 월
				'D'/NULL/''/이외  - 일
	***********************************************************/
	
	var tyy = sdate.substring(0,4);
	var tmm = sdate.substring(4,6) - 1;
	var tdd = sdate.substring(6,8);

	if (stype == "M") tdd = "01";

	var currdate = new Date(tyy,tmm,tdd);

	switch (stype) {
		case "Y" :
			diffdate = new Date(currdate.getYear() + sdiff,currdate.getMonth(),currdate.getDate());
			break;
		case "M" :
			diffdate = new Date(currdate.getYear(),currdate.getMonth() + sdiff,currdate.getDate());
			break;
		default  :
			diffdate = new Date(currdate.getYear(),currdate.getMonth(),currdate.getDate() + sdiff);
			break;
	}

	var tmpyy = diffdate.getYear();
	var ls_yy = (tmpyy > 99) ? tmpyy : 1900 + tmpyy;

	var tmpmm = diffdate.getMonth();
	var ls_mm = (tmpmm < 9)  ? "0" + (tmpmm + 1) : tmpmm + 1;

	var tmpdd = diffdate.getDate();
	var ls_dd = (tmpdd < 10) ? "0" + tmpdd : tmpdd;
	
	switch (stype) {
		case "M" :
			return ls_yy.toString() + ls_mm.toString();
		default  :
			return ls_yy.toString() + ls_mm.toString() + ls_dd.toString() ;
	}
	
}

function getInputValue(sheetObj,ofc_cd){
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + COMMAND05 + '&';
	f_query += 'ofc_cd=' + ofc_cd + '&';
	var sXml = sheetObj.GetSearchXml("CSR_COM01.do","" ,f_query,true);
	return  sXml;
}

/**
 * 해당 년, 월의 마지막 일자를 가져온다
 * @param year   년
 * @param month  월
 * @return 마지막 일자
*/
function getEndDay(year,month) {
   //if (!isMonth(month)) return 0;
   if ((month==01)||(month==03)||(month==05)||(month==07)||(month==08)||(month==10)||(month==12)) {
       return 31;
   } else {
       if(month==02) {
           if ((year%4==0) && ((year/4)%200!=0))   return 29;
           else    return 28;
       } else {
           return 30;
       } // end if
   } // end if
}


/**
 * Auth 모듈별 Sheet 전환
*/
function setAuthSheets(){
	var formObj = document.form;
	 var sheetObject2 = sheetObjects[1]; //Basic Data default
     var sheetObject3 = sheetObjects[2]; //Basic Data TRS W/O
     
	if(formObj.pgm_no.value == 'ESD_TRS_0024'){
		sheetFlg = 1;
		document.all.defaultAuth.style.display = 'none';
		document.all.trsAfWo.style.display = 'inline';
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		doActionIBSheet2(sheetObject3,formObj,IBSEARCH_ASYNC02);
	}else{//default
		sheetFlg = 0;
		document.all.defaultAuth.style.display = 'inline';
		document.all.trsAfWo.style.display = 'none';
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		doActionIBSheet2(sheetObject2,formObj,IBSEARCH);
	}
	

}

/**
 * Authorization 버튼 초기화
 */
function setAuthButtonInit(){
	ComBtnDisable("btn_approve_auth");
    ComBtnDisable("btn_disapprove_auth");
    ComBtnDisable("btn_confirm_auth");
    ComBtnDisable("btn_detail_auth"); 
}


/**
 * Authorization 버튼 기능
 */
function setAuthButtonOnChange(sheetObj , row , col, value){
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(col);
	var rows = sheetObj.Rows;
	/*
	 * if(authAproTpCd =="BF"){
   		if(authStatus == 'S'){
   			ComBtnEnable("btn_approve_auth");
   			ComBtnDisable("btn_confirm_auth");
   	   	} else {
   	   		ComBtnDisable("btn_approve_auth");
   		    ComBtnDisable("btn_confirm_auth");
   	   	}
   	}else if(authAproTpCd =="AF"){
   		if(authStatus == 'S'){
   	   		ComBtnDisable("btn_approve_auth");
   	   		ComBtnEnable("btn_confirm_auth");
   	   	} else {
   	   		ComBtnDisable("btn_approve_auth");
   		    ComBtnDisable("btn_confirm_auth");
   	   	}
   	}
	 * 
	 * 
	 */
	
//	for(var i=1; i<rows; i++){
//		var cnt = 0;
//		if(sheetObj.cellValue(i,"auth_apro_rqst_no_seq") == 1){
//			if(sheetObj.cellValue(i,"checkbox") == 1) {	 //Check
//				cnt = cnt + 1;
//			}
//		}
//	}
//	
//	alert(cnt);

	//기존 로직 
	if (sName == "checkbox") {
		if(row > 0 && row < rows) {
				var param = sheetObj.CellValue(row, "dtl_pgm_url_ctnt");
				if(sheetObj.cellValue(row,"checkbox") == 1) {	 //Check
					//버튼 활성
		   				doActionBtnEnableAuth('S');
		   				
				}	
				
				//한개 선택한 경우에만 Detail, Approval Step, Approval Step & Comments, Files, Disapprove 버튼 활성화
				if(sheetObj.CheckedRows("checkbox") == 1) {	
						if(sheetObj.cellValue(row,"auth_apro_tp_cd")=="AF"){
							ComBtnDisable("btn_approve_auth");
							ComBtnDisable("btn_disapprove_auth");
		   					ComBtnEnable("btn_confirm_auth");
		   					
		   					if(param == null || param == "" ){
			   					ComBtnDisable("btn_detail_auth");	
			   				}else{
			   					ComBtnEnable("btn_detail_auth"); 
			   				}
						}else if(sheetObj.cellValue(row,"auth_apro_tp_cd")=="BF"){
							ComBtnEnable("btn_approve_auth");
		   					ComBtnEnable("btn_disapprove_auth");
		   					ComBtnDisable("btn_confirm_auth");
		   					
		   					if(param == null || param == "" ){
			   					ComBtnDisable("btn_detail_auth");	
			   				}else{
			   					ComBtnEnable("btn_detail_auth"); 
			   				}
						}
				}else if(sheetObj.CheckedRows("checkbox") > 1){
						var checkList = sheetObj.FindCheckedRow('checkbox');
						var checkArray = checkList.split('|');

						var btn_flag = false;
						var apro = sheetObj.CellValue(checkArray[0], 'auth_apro_rqst_no');
						var cntChk = 0;
						var cntAF = 0;
						var cntBF = 0;
						for(var i=0; i<checkArray.length-1; i++)	{
														
							if(apro != sheetObj.CellValue(checkArray[i], 'auth_apro_rqst_no')){
								btn_flag = true;
							}
						}
						if(btn_flag == false){
							if(sheetObj.cellValue(row,"auth_apro_tp_cd")=="AF"){
								ComBtnDisable("btn_approve_auth");
								ComBtnDisable("btn_disapprove_auth");
			   					ComBtnEnable("btn_confirm_auth");
			   					ComBtnEnable("btn_detail_auth"); 
							}else if(sheetObj.cellValue(row,"auth_apro_tp_cd")=="BF"){
								ComBtnEnable("btn_approve_auth");
			   					ComBtnEnable("btn_disapprove_auth");
			   					ComBtnDisable("btn_confirm_auth");
			   					ComBtnEnable("btn_detail_auth"); 
							}
						}else{
							for(var i=0; i<checkArray.length-1; i++){
								cntChk = cntChk + 1;
								if(sheetObj.cellValue(checkArray[i],"auth_apro_tp_cd")=="AF"){
									cntAF = cntAF +1;
								}else if(sheetObj.cellValue(checkArray[i],"auth_apro_tp_cd")=="BF"){
									cntBF = cntBF +1;
								}
							}
							//alert("전체 : "+cntChk+"/AF : "+cntAF+"/BF : "+cntBF);
							if(cntChk == cntAF){
								ComBtnEnable("btn_confirm_auth");
								ComBtnDisable("btn_approve_auth");
								ComBtnDisable("btn_disapprove_auth");
								ComBtnDisable("btn_detail_auth");
							}else if(cntChk == cntBF){
								ComBtnEnable("btn_approve_auth");
								ComBtnDisable("btn_confirm_auth");
								ComBtnDisable("btn_disapprove_auth");
								ComBtnDisable("btn_detail_auth");
								
							}else{
								ComBtnDisable("btn_confirm_auth");
								ComBtnDisable("btn_approve_auth");
								ComBtnDisable("btn_disapprove_auth");
								ComBtnDisable("btn_detail_auth");
							}
						}
				}else{
						ComBtnDisable("btn_approve_auth");
						ComBtnDisable("btn_disapprove_auth");
						ComBtnDisable("btn_confirm_auth");
						ComBtnDisable("btn_detail_auth"); 
				}
			}
	}else if(sName == "auth_apro_rmk"){
		var length = sheetObj.cellValue(row, "auth_apro_rmk").length;
		if(length > 0){
			
		}
		
	}
}

///**
// * Authorization sheet 클릭 기능
// */
//function setAuthOnClickEvt(sheetObj, Row, Col, Value){
//	
//	switch (sheetObj.ColSaveName(Col)) {
//    case "auth_apro_rmk":
//            sheetObj.CellEditable(Row, Col) = false;
//            ComShowMemoPad(sheetObj, Row, Col, false, 300, 200, 1000, true);
//            break;
//    }
//}

function setAuthDetailBtn(sheetObject){
	var formObj = document.form;
	var sRow = sheetObject.FindCheckedRow("checkbox");
    var arrRow = sRow.split("|");     
	var param = sheetObject.CellValue(arrRow[0], "dtl_pgm_url_ctnt");
	var authAproRqstNo = sheetObject.CellValue(arrRow[0], "auth_apro_rqst_no");
	
	if(authAproRqstNo != null && authAproRqstNo != "" && authAproRqstNo != "undefined"){
		var url = "/hanjin/"+param+authAproRqstNo+"&confirm=Y";
    	var rtn = ComOpenPopup(url, 1020, 380, '', 'none', true);
    	if(rtn == "retrieve"){
    		if(sheetFlg ==0){
        		doActionIBSheet2(sheetObject,formObj,IBSEARCH);
        	}else if(sheetFlg == 1){
        		doActionIBSheet2(sheetObject,formObj,IBSEARCH_ASYNC02);
        	}
    	} 
    	
	}
}



/**
     * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
     * @param {sheet}	t1sheet1	Coincidence sheet
     * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {long}	X			X 좌표
     * @param {long}	Y			Y 좌표
     * @return
     */	 

    function sheet3_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
    	var row = t1sheet1.MouseRow;
    	var col = t1sheet1.MouseCol;
    	if (t1sheet1.ColSaveName(col) == "vndr_nm" && row >= 1
    			&& t1sheet1.CellValue(row, "vndr_nm") != null
    			&& t1sheet1.CellValue(row, "vndr_nm") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "vndr_nm");
    	}else if (t1sheet1.ColSaveName(col) == "auth_apro_rmk" && row >= 1
    			&& t1sheet1.CellValue(row, "auth_apro_rmk") != null
    			&& t1sheet1.CellValue(row, "auth_apro_rmk") != ''){
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "auth_apro_rmk");
    	}
    		
    } 
    
    /**
     * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
     * @param {sheet}	t1sheet1	Coincidence sheet
     * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {long}	X			X 좌표
     * @param {long}	Y			Y 좌표
     * @return
     */	 

    function sheet2_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
    	var row = t1sheet1.MouseRow;
    	var col = t1sheet1.MouseCol;
    	if (t1sheet1.ColSaveName(col) == "auth_apro_rmk" && row >= 1
    			&& t1sheet1.CellValue(row, "auth_apro_rmk") != null
    			&& t1sheet1.CellValue(row, "auth_apro_rmk") != '') {
    		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "auth_apro_rmk");
    	}
    		
    } 
    
    function changeIfStatus(objVal){
    	var formObj = document.form;
    	if(objVal == 'P' || objVal == 'R'){	//Requested, Disapproved
    		formObj.if_status.value = '';
    		formObj.if_status.disabled = true;
    	} else {
    		formObj.if_status.disabled = false;
    	}
    }
