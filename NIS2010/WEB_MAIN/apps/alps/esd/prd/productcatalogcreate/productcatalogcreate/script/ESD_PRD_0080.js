/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0080.js
*@FileTitle : Product Catalog
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정선용
*@LastVersion : 1.0 
* 2009.07.29 정선용
* 1.0 Creation
* http://localhost:7001/hanjin/ESD_PRD_0080.do?f_cmd=3&pc_mode=B&por=CNFOC&pol=CNFOC&pod=NOOSL&del=NOOSL&pol_n=&t_vvd=&rcv_t=D&del_t=D&shpr=KR001682&com=030015&rep_com=02&wgt=15000&wgt_un=KGS&rfa=PUS7A100587&rfa_ofc=PUSBS&rfa_srep=KR073&c_tpsz=D2&&c_qty=1.00&c_tpsz=D4&c_qty=2.00&ld_dt=20090728&m_pu=CNFOCY3
* * history
* 2010.12.22  채창호  [CHM-201007734] [PRD & SCEM] IRG상 BKG&Temp Flag 적용방법 변경 관련하여, Alert Message 처리 요청사항
* 2017.12.18  이선묵  [CSR#2816] BKG Creation시 호출된 PRD 화면의 Route중 Optimum이 아닌 Route 선택시 사유 입력  팝업 호출 안되도록 처리 요청사항 (추후 영업 확대될 경우 분석 기능 필요시 해당 Logic 복원 예정) 
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
     * @class ESD_PRD_0080 : ESD_PRD_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_PRD_0080() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
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
 var updChk = 1;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var shtCnt = 0;
          var sheetObject = sheetObjects[shtCnt++];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 				switch(srcName) {
		
		            case "btn_select":
		            	ComOpenWait(true);
		            	//replane 시 선택한 pc no로 map table 업데이트 &
		            	//부패턴 pc생성 및 map 업데이트
		            	if(formObject.pc_mode.value == 'R'){
		            		updatePrdMap();
		            	}
		            	ComOpenWait(false);
		            	
		            	if(updChk == 1){
		            		var callFunc = formObject.calllFunc.value;
		            		var pcNo = '';
		            		var copMapSeq ='';
		            		var selRownum = '';
		            		for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
		            			if(sheetObjects[0].CellValue(i, "chk") == true){
		            				selRownum = i;
		            			}
		            		}
		            		if(callFunc != ''){
//			           		formObject.valChk.value="N";
		            			// Route 선택 Validation 체크 (2010.01.18 csr)
		            			// [CSR#2816] 요청에 따른 Logic 비활성화에 따른 주석 처리 [기존 logic 복구시 해당 CSR의 주석만 복원] Start
//		            			if(!chkVal(selRownum)){
//		            				var url = "ESD_PRD_0083.do?f_cmd="+""+"&pctl_no="+sheetObjects[0].CellValue(selRownum,"pctl_no");
//		            				ComOpenPopup(url, 590, 495, "callBackEsdPrd0083",	"1,0,1,1,1", true);			       			
//		            			} else {
		            				formObject.valChk.value="Y";
//		            			}
			            		// [CSR#2816] 요청에 따른 Logic 비활성화에 따른 주석 처리 [기존 logic 복구시 해당 CSR의 주석만 복원] End		            				
		            			
		            			pcNo =  sheetObjects[0].CellValue(selRownum,"pctl_no");  
		            			
		            			// Validation Check 에 응해야 단계 진행이 된다
		            			if(formObject.valChk.value=="Y"){
		            				copMapSeq = formObject.map_seq.value;
		            				eval('window.dialogArguments.'+callFunc)(pcNo+'|'+copMapSeq);   
		            				
		            				window.close();
		            			}
		            		}
		            	} else {
		            		ComShowMessage(ComGetMsg('PRD90114'));
		            	}
		            break;
		         	case "btns_LddCalendar":
			            var cal = new ComCalendar();
			            cal.select(formObject.fm_ld_dt, 'yyyy-MM-dd');   
					break;   
		         	case "btns_EmptyCalendar":
			            var cal = new ComCalendar();
			            cal.select(formObject.fm_empty_dt, 'yyyy-MM-dd');   
					break; 					
		         	case "btng_fullroute":
		            	var selRownum = '';
		            	
			       		for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
		    				if(sheetObjects[0].CellValue(i, "chk") == true){
		    					selRownum = i;
		    				}
			    		}

			       		var url = "ESD_PRD_0081.do?pctl_no="+sheetObjects[0].CellValue(selRownum,"pctl_no");
		         		ComOpenPopup(url, 800, 460, "",	"1,0,1,1,1", true);
					break;
		         	case "btng_constraints":
		            	var selRownum = '';
		            	
			       		for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
		    				if(sheetObjects[0].CellValue(i, "chk") == true){
		    					selRownum = i;
		    				}
			    		}

//		         		var url = "ESD_PRD_0082.do?f_cmd="+SEARCHLIST+"&pctl_no="+sheetObjects[0].CellValue(selRownum,"pctl_no");
//		         		ComOpenPopup(url, 780, 440, "",	"1,0,1,1,1", true, true, 1,1,0, "Product Catalog - Constraint", "yes");

//                        var paramUrl = "pgmNo=ESD_PRD_0082&pctl_no="+sheetObjects[0].CellValue(selRownum,"pctl_no");
//				        var newWin = window.showModalDialog("ESD_PRD_0082.do?"+paramUrl, "bkg_info_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:605px");
						fnPopConstraintDetail(sheetObjects[0].CellValue(selRownum,"pctl_no"));
		         	break;					
	                case "btn_close":
						window.close();
	                break; 
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
     
     function updatePrdMap() {
    	 var formObj = document.form;
    	 formObj.f_cmd.value = MODIFY ;
		 formObj.sXml.value = '' ;
     	 var selRownum = '';
    	
		 for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
			 if(sheetObjects[0].CellValue(i, "chk") == true){
				 selRownum = i;
			 }
		 }
		 
		 var main_pattern_pctl_no = sheetObjects[0].CellValue(selRownum,"pctl_no"); 
		 var sXml = sheetObjects[2].GetSearchXml("ESD_PRD_0080GS.do?main_pattern_pctl_no="+main_pattern_pctl_no ,PrdFQString(formObj));
		 var arrXml = sXml.split("|$$|"); 
		 if(ComGetEtcData(arrXml[0],"MAP_UPDATE")=="FAIL"){
			 updChk = 0 ;
		 }	 
		 
     }
     
     /*
      * ldd 변경으로 pc새로 생성 
      */
     function newPcCreateByLdd() {
      	ComOpenWait(true);
 	 	var formObj = document.form;
 	 	formObj.ld_dt.value =  formObj.fm_ld_dt.value.replace(/\-/gi, '');
 	 	formObj.f_cmd.value = SEARCHLIST01 ;

 	 	formObj.sXml.value = '';
		var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));
		var arrXml = sXml.split("|$$|"); 

	    for(var i = 0; i < arrXml.length; i++){  
//	           sheetObjects[i].Redraw = false;       
//	           if(i > 0) {   
//	           sheetObjects[i].WaitImageVisible = false;     
//	           }     
	           sheetObjects[i].LoadSearchXml(arrXml[i]);   
//	           sheetObjects[i].Redraw = true;   
	    }  
	    
		var arr_dt = ComGetEtcData(arrXml[0],"arr_dt");
		var transit_dt = ComGetEtcData(arrXml[0],"transit_dt");
		var pc_ldd = ComGetEtcData(arrXml[0],"pc_ldd");// JSPUtil.getNull(eventResponse.getETCData("pc_ldd")); //pc dtl의 loadding due date
		var ldd = ComGetEtcData(arrXml[0],"ldd");// JSPUtil.getNull(eventResponse.getETCData("pc_ldd")); //pc dtl의 loadding due date
		var cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
		var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
		if(hamRtm != null && hamRtm.length > 0){
		     ComShowMessage(hamRtm);
		}
		
		var mt_pu_dt =  ComGetEtcData(arrXml[0],"mt_pu_dt");
		 if(arrXml.length ==1) { //생성 실패시.
			 sheetObjects[0].RemoveAll();
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
			 
			 if( arr_dt==undefined ) arr_dt='' ; 
			 if( transit_dt==undefined ) transit_dt='' ; 
			 if( pc_ldd==undefined ) pc_ldd='' ; 
			 if( ldd==undefined ) ldd='' ; 
			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
			 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 			 
			 
		 } else {
			 formObj.ttl_expn_amt.value = ComGetEtcData(arrXml[0],"ttl_expn_amt");
			 formObj.d_pod_cd.value     = ComGetEtcData(arrXml[0],"pod_cd");
			 formObj.map_seq.value     = ComGetEtcData(arrXml[0],"map_seq");
		 }

		formObj.fm_empty_dt.value   = mt_pu_dt; //ComGetEtcData(arrXml[0],"mt_pu_dt");
		ComAddSeparator(formObj.fm_empty_dt);
		
		formObj.arr_dt.value = arr_dt;
		formObj.transit_dt.value = transit_dt;
		formObj.cnst_flg.value = cnst_flg;
		
		ComAddSeparator(ldd);
		
		set_color_constraint_btn(cnst_flg);
		ComOpenWait(false);
		
     }
     
     function set_color_constraint_btn( cnst_flg ) {
		 if(cnst_flg != ''){
			 if(cnst_flg == 'X'){
				 document.getElementById('btng_constraints').style.color = 'red';
            	 ComBtnDisable("btn_select"); 
        		 ComBtnEnable("btng_constraints"); 
        		 ComBtnEnable("btng_fullroute");      
			 }else {
				 document.getElementById('btng_constraints').style.color = 'blue';
        		 ComBtnEnable("btn_select"); 
        		 ComBtnEnable("btng_constraints"); 
        		 ComBtnEnable("btng_fullroute");  				 
			 }
			 ComShowMessage(ComGetMsg('PRD90113'));	// Constraint 존재시 경고창 - 2010.04.12 추가
		 }else {
			 if(sheetObjects[0].RowCount>0){
	    		 ComBtnEnable("btn_select"); 
	    		 ComBtnEnable("btng_constraints"); 
	    		 ComBtnEnable("btng_fullroute"); 
				 document.getElementById('btng_constraints').style.color = "#737373";
			 } else {
            	 ComBtnDisable("btn_select"); 
            	 ComBtnDisable("btng_constraints"); 
            	 ComBtnDisable("btng_fullroute"); 
            	 document.getElementById('btng_constraints').style.color = "#737373";
			 }
//    		 ComBtnEnable("btn_select"); 
		 }   	 
     }
     function searchEqInv() {
  	 	var formObj = document.form;
    	var selRownum = '';
   		for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
			if(sheetObjects[0].CellValue(i, "chk") == true){
				selRownum = i;
			}
		}
  	 	formObj.m_pu_dt.value =  formObj.fm_empty_dt.value.replace(/\-/gi, '');
  	 	formObj.pctl_no.value = sheetObjects[0].CellValue(selRownum,"pctl_no"); 

  	 	ComOpenWait(true);
		formObj.f_cmd.value = SEARCH02 ;
		formObj.sXml.value = '';
		var sXml = sheetObjects[1].GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));
		sheetObjects[1].LoadSearchXml(sXml);
		ComOpenWait(false);
     }
     
     function chk_ob_trsp_mode(mode) {
    	 ComOpenWait(true);
    	 
    	 var formObj = document.form;
		 formObj.f_cmd.value = SEARCHLIST01 ;
		 formObj.sXml.value = '' ;
		 var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));
		 ComBtnEnable("btn_select");
		 
//    		 sheetObj.ShowDebugMsg = true;  
		 var arrXml = sXml.split("|$$|"); 
 
         for(var i = 0; i < arrXml.length; i++){  
//                 sheetObjects[i].Redraw = false;       
//                 if(i > 0) {   
//                 sheetObjects[i].WaitImageVisible = false;     
//                 }     
                 sheetObjects[i].LoadSearchXml(arrXml[i]);   
//                 sheetObjects[i].Redraw = true;   
         }  
	 
		 
		 if(arrXml.length ==1) { //생성 실패시.
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
			 
		 }else{
			ComAddSeparator(formObj.fm_empty_dt);

			//var mt_pu_dt     =  ComGetEtcData(arrXml[0],"mt_pu_dt");
			formObj.fm_empty_dt.value = ComGetEtcData(arrXml[0],"mt_pu_dt");
			formObj.arr_dt.value      = ComGetEtcData(arrXml[0],"arr_dt");
			formObj.transit_dt.value  = ComGetEtcData(arrXml[0],"transit_dt");
			formObj.return_str.value  = ComGetEtcData(arrXml[0],"returnStr");
			var cnst_flg              = ComGetEtcData(arrXml[0],"cnst_flg");
			formObj.map_seq.value     = ComGetEtcData(arrXml[0],"map_seq");
//			var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
//			if(hamRtm != null && hamRtm.length > 0){
//			     ComShowMessage(hamRtm);
//			}
			
			formObj.cnst_flg.value    = cnst_flg;

			 set_color_constraint_btn(cnst_flg);

		 }
		 ComOpenWait(false);
     }
     
     function chk_ib_trsp_mode(mode) {
    	 ComOpenWait(true);

    	 var formObj = document.form;
		 formObj.f_cmd.value = SEARCHLIST01 ;
		 formObj.sXml.value = '' ;
		 var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));
		 ComBtnEnable("btn_select");
		 
//    		 sheetObj.ShowDebugMsg = true;  
		 var arrXml = sXml.split("|$$|"); 

         for(var i = 0; i < arrXml.length; i++){  
//                 sheetObjects[i].Redraw = false;       
//                 if(i > 0) {   
//                 sheetObjects[i].WaitImageVisible = false;     
//                 }     
                 sheetObjects[i].LoadSearchXml(arrXml[i]);   
//                 sheetObjects[i].Redraw = true;   
         }  
	 
		 var arr_dt = ComGetEtcData(arrXml[0],"arr_dt");
		 var transit_dt = ComGetEtcData(arrXml[0],"transit_dt");
		 var return_str = ComGetEtcData(arrXml[0],"returnStr");
		 var cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
		 formObj.map_seq.value     = ComGetEtcData(arrXml[0],"map_seq");
//		 var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
//		 if(hamRtm != null && hamRtm.length > 0){
//		     ComShowMessage(hamRtm);
//		 }		 
		 
		 var mt_pu_dt =  ComGetEtcData(arrXml[0],"mt_pu_dt");
		 if(arrXml.length ==1) { //생성 실패시.
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
			 
			 if( arr_dt==undefined ) arr_dt='' ; 
			 if( transit_dt==undefined ) transit_dt='' ; 
//			 if( pc_ldd==undefined ) pc_ldd='' ; 
//			 if( ldd==undefined ) ldd='' ; 
			 if( return_str==undefined ) return_str='' ; 
			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
			 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 
		 } 		 
		 ComAddSeparator(formObj.fm_empty_dt);
			
		 formObj.arr_dt.value = arr_dt;
		 formObj.transit_dt.value = transit_dt;
		 formObj.return_str.value = return_str;
		 formObj.cnst_flg.value = cnst_flg;
		 set_color_constraint_btn(cnst_flg);	
		 ComOpenWait(false);
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
    	var f = document.form;
		f.f_cmd.value = SEARCHLIST01 ;

		ComOpenWait(true);
		
		// 화면을 그려줍니다.
        for(i=0;i<sheetObjects.length;i++){
			 ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
        }
        
		var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(f));
		this.createPcView(sXml);

        axon_event.addListenerForm('beforedeactivate', 'prd0080_deactivate',  f); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 'prd0080_activate',    f); //- 포커스 들어갈때
//        POD :  USLGB, USOAK, USPDX, USTIW, USSEA, CAVAN, CAPRR, USLAX 
//        위의 Port들을 POD로 잡는 모든 BKG은 PRD에서 제공하는 Inland Route(본부에서 정한 Standard IRG)에서
//               다른 IRG로 BKG User가 임의대로 변경하지 못하도록 조치
//        var pod_str ='USLGB, USOAK, USPDX, USTIW, USSEA, CAVAN, CAPRR, USLAX';
//        
//        if(pod_str.indexOf (f.pod.value) >= 0 ) {
//        	ComEnableObject(document.form.ib_trsp_mode[0], false);
//        	ComEnableObject(document.form.ib_trsp_mode[1], false);
//        	ComEnableObject(document.form.ib_trsp_mode[2], false);
//        	ComEnableObject(document.form.ib_trsp_mode[3], false);
//        	ComEnableObject(document.form.ib_trsp_mode[4], false);
//        	ComEnableObject(document.form.ib_trsp_mode[5], false);
//        	//ComShowMessage('In case POD is US west coast or canada port, the \"Trans Mode\" which is already being setted by NYCNOG won\'t be selected by booking staff');
//        }
        ComOpenWait(false);
	 }

     function createPcView(sXml) {

         // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
         var formObj = document.form;
         var arrXml = sXml.split("|$$|");   
         
         formObj.pre_n1st_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol1_dc_flg");
         formObj.post_n1st_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol1_dc_flg");
         formObj.pre_n1st_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod1_dc_flg");
         formObj.post_n1st_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod1_dc_flg");
         formObj.pre_n2nd_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol2_dc_flg");
         formObj.post_n2nd_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol2_dc_flg");
         formObj.pre_n2nd_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod2_dc_flg");
         formObj.post_n2nd_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod2_dc_flg");
         formObj.pre_n3rd_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol3_dc_flg");
         formObj.post_n3rd_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol3_dc_flg");
         formObj.pre_n3rd_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod3_dc_flg");
         formObj.post_n3rd_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod3_dc_flg");
         formObj.pre_n4th_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol4_dc_flg");
         formObj.post_n4th_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol4_dc_flg");
         formObj.pre_n4th_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod4_dc_flg");
         formObj.post_n4th_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod4_dc_flg");
         
//       formObj.pol1_dc_flg.value   = ComGetEtcData(arrXml[0],"pol1_dc_flg");
//		 formObj.pod1_dc_flg.value   = ComGetEtcData(arrXml[0],"pod1_dc_flg");
//		 formObj.pol2_dc_flg.value   = ComGetEtcData(arrXml[0],"pol2_dc_flg");
//		 formObj.pod2_dc_flg.value   = ComGetEtcData(arrXml[0],"pod2_dc_flg");
//		 formObj.pol3_dc_flg.value   = ComGetEtcData(arrXml[0],"pol3_dc_flg");
//		 formObj.pod3_dc_flg.value   = ComGetEtcData(arrXml[0],"pod3_dc_flg");
//		 formObj.pol4_dc_flg.value   = ComGetEtcData(arrXml[0],"pol4_dc_flg");
//		 formObj.pod4_dc_flg.value   = ComGetEtcData(arrXml[0],"pod4_dc_flg");
         
         for(var i = 0; i < arrXml.length; i++){  
//        	 sheetObjects[i].ShowDebugMsg = true;
             sheetObjects[i].LoadSearchXml(arrXml[i]);   
         }  

		var cnst_flg = "";
		 if(arrXml.length ==1) { //생성 실패시.
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
			 
		 } else{
			 var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
			 if(hamRtm != null && hamRtm.length > 0){
			     ComShowMessage(hamRtm);
			 }

			 formObj.return_str.value   = ComGetEtcData(arrXml[0],"returnStr");
			 formObj.arr_dt.value       = ComGetEtcData(arrXml[0],"arr_dt");
			 formObj.transit_dt.value   = ComGetEtcData(arrXml[0],"transit_dt");
			 cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
			 formObj.cnst_flg.value     = cnst_flg;

			 formObj.fm_ld_dt.value     = ComGetEtcData(arrXml[0],"ldd");
			 formObj.arr_dt.value       = ComGetEtcData(arrXml[0],"arr_dt");
			 formObj.d_pod_cd.value     = ComGetEtcData(arrXml[0],"pod_cd");
			 formObj.ttl_expn_amt.value = ComGetEtcData(arrXml[0],"ttl_expn_amt");

			 formObj.map_seq.value      = ComGetEtcData(arrXml[0],"map_seq");
			 formObj.sum_bkg_qty.value  = ComGetEtcData(arrXml[0],"sum_bkg_qty");
			 formObj.sum_ctp_sz.value   = ComGetEtcData(arrXml[0],"sum_ctp_sz");
			 formObj.fm_empty_dt.value   = ComGetEtcData(arrXml[0],"mt_pu_dt");
			 
			 ComAddSeparator(formObj.fm_empty_dt);

			 document.getElementById("sheet3Title").innerHTML = ComGetEtcData(arrXml[0],'port_cct_msg');
		 }

		 ComAddSeparator(formObj.fm_ld_dt);
		 
		 set_color_constraint_btn(cnst_flg);

     }

     function prd0080_deactivate() {
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     	var srcValue = window.event.srcElement.getAttribute("value");
     
     	if(srcName == "fm_ld_dt"){
    		ComAddSeparator(event.srcElement);
    		if (ComChkLen(srcValue, srcMaxLength) == "2") {
    			newPcCreateByLdd();
    		}
     	}
     	if(srcName == "fm_empty_dt"){
     		ComAddSeparator(event.srcElement);
     		if (ComChkLen(srcValue, srcMaxLength) == "2") {
     			searchEqInv();
     		}
     	}
     }

  	 /**
	 * 마우스 IN일때 
	 */
	function prd0080_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	

	    	case "fm_ld_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "fm_empty_dt":
	    		ComClearSeparator(event.srcElement);
	    		break;
			default:
				break;
		}
	}     
     	
     	
     
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 var formObj = document.form;
         var cnt = 0;
         var shtID = sheetObj.id;
         
         switch(shtID) {
             case "sheet1":      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 215;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge ;
//                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 10, 100);

//                     var HeadTitle1 = "no|CHK|Flag|Priority|Cost(USD)|Transit Time|1st Vessel|1st Vessel|"+pol1_tit1+"1st Vessel|"+pod1_tit1+"1st Vessel|1st Vessel|2nd Vessel|2nd Vessel|"+pol2_tit1+"2nd Vessel|"+pod2_tit1+"2nd Vessel|3rd Vessel|3rd Vessel|"+pol3_tit1+"3rd Vessel|"+pod3_tit1+"3rd Vessel|4th Vessel|4th Vessel|"+pol4_tit1+"4th Vessel|"+pod4_tit1+"4th Vessel|||||||||||||||";
//                     var HeadTitle2 = "no|CHK|Flag|Priority|Cost(USD)|Transit Time|Lane / VVD|POL / ETD|"+pol1_tit2+"POD / ETA|"+pod1_tit2+"Lane|SPACE|Lane / VVD|POL / ETD|"+pol2_tit2+"POD / ETA|"+pod2_tit2+"SPACE|Lane / VVD|POL / ETD|"+pol3_tit2+"POD / ETA|"+pod3_tit2+"SPACE|Lane / VVD|POL / ETD|"+pol4_tit2+"POD / ETA|"+pod4_tit2+"SPACE|||||||||||||||";
                     var HeadTitle1 = "no|CHK|Flag|Priority|Cost(USD)|Transit Time|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel||||||||||||||||||||||||||||||||||||";
                     var HeadTitle2 = "no|CHK|Flag|Priority|Cost(USD)|Transit Time|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|Lane|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|||||||||||||||||||||||||||||||||||||";
                     var headCount = ComCountHeadTitle(HeadTitle1);                    
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, false, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,	    30,   daCenter,	 true,	"pctl_no",				false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtRadioCheck,	30,   daCenter,	 true,	"chk");
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,	 true,	"upd_ind_cd",			false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		60,   daCenter,	 true,	"ocn_rout_prio_cd",		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  true,	"ttl_expn_amt",     	false,	"",	dfNone, 0,false);

                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  true,	"tztm_hrs",     		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n1st_vsl_slan_cd",     false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n1st_pol_dc_chk",     false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n1st_pol_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n1st_pol_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n1st_pol",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n1st_pol_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n1st_pol_dc",     	false,	"",	dfNone);
                	 
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n1st_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n1st_pod_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n1st_pod_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n1st_pod",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n1st_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n1st_pod_dc",     	false,	"",	dfNone);

                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,	 true,	"n1st_slan_cd",  		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,	 true,	"n1st_space",  			false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n2nd_vsl_slan_cd",     false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n2nd_pol_dc_chk",     false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n2nd_pol_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n2nd_pol_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n2nd_pol",     		false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n2nd_pol_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n2nd_pol_dc",     	false,	"",	dfNone);
                	 
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n2nd_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n2nd_pod_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n2nd_pod_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,	 false,	"n2nd_pod",  			false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n2nd_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n2nd_pod_dc",     	false,	"",	dfNone);
                	 
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,	 false,	"n2nd_space",	        false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n3rd_vsl_slan_cd",     false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n3rd_pol_dc_chk",     false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n3rd_pol_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n3rd_pol_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n3rd_pol",     		false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n3rd_pol_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n3rd_pol_dc",     	false,	"",	dfNone);
                	 
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n3rd_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n3rd_pod_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n3rd_pod_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,	 false,	"n3rd_pod",	        	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n3rd_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n3rd_pod_dc",     	false,	"",	dfNone);
                	 
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n3rd_space",     		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n4th_vsl_slan_cd",     false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n4th_pol_dc_chk",     false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n4th_pol_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n4th_pol_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,	 false,	"n4th_pol",	        	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n4th_pol_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n4th_pol_dc",     	false,	"",	dfNone);
                	 
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"pre_n4th_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"pre_n4th_pod_dc",     	false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"n4th_pod_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n4th_pod",     		false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtCheckBox,	20,   daCenter,  false,	"post_n4th_pod_dc_chk",     false,	"",	dfNone);
                	 InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"post_n4th_pod_dc",     	false,	"",	dfNone);
                	 
                     InitDataProperty(0, cnt++ , dtData,		80,   daCenter,  false,	"n4th_space",     		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"org_loc_cd",     		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"dest_loc_cd",     		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"rout_seq",     		false,	"",	dfNone);

                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"vvd_lnk_no",     		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"ord",     				false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"lnk_knt",     			false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_pol_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_pod_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_vvd",				false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_vvd",				false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_vvd",				false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_vvd",				false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_pol_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_pod_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_pol_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_pod_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_pol_dc_clpt_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_pod_dc_clpt_seq",	false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_pol_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_pod_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_pol_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_pod_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_pol_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_pod_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_pol_clpt_ind_seq",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_pod_clpt_ind_seq",	false,	"",	dfNone);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_pol_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n1st_pod_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_pol_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n2nd_pod_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_pol_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n3rd_pod_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_pol_n",	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"n4th_pod_n",	false,	"",	dfNone);			                      
                     
                     InitDataProperty(0, cnt++ , dtHidden,		80,   daCenter,  false,	"ocn_rout_usr_rmk",	false,	"",	dfNone);			                      
                     ColHidden(0) = true;
                     SelectionMode = smSelectionFree;
                     WaitImageVisible=false;

                }
                 break;


             case "sheet2":      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 125;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 10, 100);

 		             var HeadTitle1 = " CHK|Empty Pick Up Yard|Empty Pick Up Yard|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory";
                     var HeadTitle2 = " CHK|||D4|D2|D5|R2|R4|R5";
                     var headCount = ComCountHeadTitle(HeadTitle1);                    

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtRadioCheck,		30,	daCenter,	 true,	"mt_chk",			false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	 true,	"yd_cd",			false,	"",	dfNone);
 		             InitDataProperty(0, cnt++ , dtData,		140,	daLeft,  	 true,	"nod_nm",			false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		35,     daCenter,  	 true,	"d2",     	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		35,     daCenter, 	 true,	"d4",     	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		35,     daCenter, 	 true,	"d5",     	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		35,     daCenter, 	 true,	"r2",     	false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		35,     daCenter,	 true,	"r4",  		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		35,     daCenter, 	 true,	"r5",     	false,	"",	dfNone);
                     
                     WaitImageVisible=false;
                }
                 break;
             case "sheet3":      //sheet3 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 125;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet =  msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     //InitRowInfo(2, 2, 10, 100);
                     InitRowInfo(2, 1, 10, 100);

 		             var HeadTitle1 = " |CHK |Full Return Yard|Cargo Cut Off Time|Cargo Cut Off Time|Cargo Cut Off Time";
                     var HeadTitle2 = " |CHK |Full Return Yard|General|RF|DG";
                     var headCount = ComCountHeadTitle(HeadTitle1);                    

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                     InitHeadMode(true, true, false, true, false,false)
                     InitHeadMode(false, false, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"yd_cd1",		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	true,	"frt_chk");
                     InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"yd_cd",		false,	"",	dfNone);
                     //InitDataProperty(0, cnt++ , dtData,		50,     daCenter, 	 true,	"from_txt",     false,	"",	dfNone);
 		             InitDataProperty(0, cnt++ , dtData,		110,	daLeft,		true,	"gen",		false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		110,    daCenter,   true,	"rf",     false,	"",	dfNone);
                     InitDataProperty(0, cnt++ , dtData,		110,    daCenter, 	true,	"dg",     false,	"",	dfNone);
                     //cnt=0;
                     //InitDataProperty(1, cnt++ , dtData,		100,	daCenter,	true,	"yd_cd1",		false,	"",	dfNone);
                     //InitDataProperty(1, cnt++ , dtRadioCheck,	30,		daCenter,	true,	"frt_chk");
                     //InitDataProperty(1, cnt++ , dtData,		100,	daCenter,	true,	"yd_cd",		false,	"",	dfNone);
                     ////InitDataProperty(1, cnt++ , dtData,		50,     daCenter, 	 true,	"to_txt",     false,	"",	dfNone);
 		             //InitDataProperty(1, cnt++ , dtData,		110,	daLeft,		true,	"gen",		false,	"",	dfNone);
                     //InitDataProperty(1, cnt++ , dtData,		110,    daCenter,   true,	"rf",     false,	"",	dfNone);
                     //InitDataProperty(1, cnt++ , dtData,		110,    daCenter, 	true,	"dg",     false,	"",	dfNone);
                     ColHidden(0) = true;
					 WordWrap = true;
					 WaitImageVisible=false;
                }
                 break;

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
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
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
     
     function chkTempOcnRout(ocn_rout_usr_rmk) {
    	 var rmk ='Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error';
    	 if(ocn_rout_usr_rmk != '') {
    		 if(rmk.indexOf(ocn_rout_usr_rmk)>=0) {
    			 ComShowMessage("This temporary route should be used only for the case below.\n" +
    			 		"Type : "+ocn_rout_usr_rmk);
    		 } else {
    			 ComShowMessage("This temporary route should be used only for the case below.\n" +
     			 		"Type : The Others\n"+
     			 		"Note : "+ocn_rout_usr_rmk);
    		 }
    	 }
     }
     /*
      * ocn route 를 변경시 해당 ocn으로 만들어진 pc번호를 가지고  아래 irg등의 내용을 조회하여 가져옴. 
      */
     function sheet1_OnChange(sheetObj, row, col, value){
    	  
    	 var formObj = document.form;
    	 var colArr = "pre_n1st_pol_dc_chk post_n1st_pol_dc_chk pre_n1st_pod_dc_chk post_n1st_pod_dc_chk pre_n2nd_pol_dc_chk post_n2nd_pol_dc_chk pre_n2nd_pod_dc_chk post_n2nd_pod_dc_chk pre_n3rd_pol_dc_chk post_n3rd_pol_dc_chk pre_n3rd_pod_dc_chk post_n3rd_pod_dc_chk pre_n4th_pol_dc_chk post_n4th_pol_dc_chk pre_n4th_pod_dc_chk post_n4th_pod_dc_chk";
//    	 alert(sheetObj.ColSaveName(col));
//    	 alert(colArr.indexOf(sheetObj.ColSaveName(col)));
    	 if (sheetObj.ColSaveName(col) == "chk") {
    		 
    		 // temp 를 선택시 alert 
    		 chkTempOcnRout(sheetObj.CellValue(row,"ocn_rout_usr_rmk"));
    		 formObj.pctl_no.value = sheetObj.CellValue(row,"pctl_no");
    		 ComOpenWait(true);
    		 formObj.f_cmd.value = SEARCH01 ;
    		 formObj.sXml.value = '' ;
//    		 sheetObj.ShowDebugMsg = true;  
//    		 doActionIBSheet(sheetObj,formObj,SEARCH01);
//    		 sheetObj.WaitImageVisible = true;   
    		 var sXml = sheetObj.GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));

    		 var arrXml = sXml.split("|$$|"); 
    		 if(arrXml.length =2){
    			 sheetObjects[1].LoadSearchXml(arrXml[0]); 
    			 sheetObjects[2].LoadSearchXml(arrXml[1]); 
    		 }
    		 
    		 var arr_dt = ComGetEtcData(arrXml[0],"arr_dt");
    		 var transit_dt = ComGetEtcData(arrXml[0],"transit_dt");
    		 var return_str = ComGetEtcData(arrXml[0],"returnStr");
    		 var pod_cd = ComGetEtcData(arrXml[0],"pod_cd");
    		 
    		 var pc_ldd = ComGetEtcData(arrXml[0],"pc_ldd");
    		 var ldd = ComGetEtcData(arrXml[0],"ldd");
    		 var cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
 			 var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
			 if(hamRtm != null && hamRtm.length > 0){
			     ComShowMessage(hamRtm);
			 }
    		 var ttl_expn_amt = ComGetEtcData(arrXml[0],"ttl_expn_amt");
    		 var mt_pu_dt = ComGetEtcData(arrXml[0],"mt_pu_dt");
    		 formObj.fm_empty_dt.value = mt_pu_dt;
    		 formObj.return_str.value = return_str;
    		 formObj.arr_dt.value = arr_dt;
    		 formObj.transit_dt.value = transit_dt;
    		 formObj.d_pod_cd.value = pod_cd;
//    		 formObj.fm_ld_dt.value = pc_ldd;
    		 formObj.ttl_expn_amt.value = ttl_expn_amt;
    		 formObj.cnst_flg.value = cnst_flg;

			 document.getElementById("sheet3Title").innerHTML = ComGetEtcData(arrXml[0],'port_cct_msg');
			 
			 set_color_constraint_btn(cnst_flg);

			 ComOpenWait(false);
//	        POD :  USLGB, USOAK, USPDX, USTIW, USSEA, CAVAN, CAPRR, USLAX 
//	                    위의 Port들을 POD로 잡는 모든 BKG은 PRD에서 제공하는 Inland Route(본부에서 정한 Standard IRG)에서
//	                    다른 IRG로 BKG User가 임의대로 변경하지 못하도록 했으나
//          위의 POD에 해당되지 않는 PORT에 대해서 변경이 안되어서 check 박스를 통해서 PORT 외에선 변경이 가능도록 변경 		 
					 
		    var pod_str ='USLGB, USOAK, USPDX, USTIW, USSEA, CAVAN, CAPRR, USLAX';
 		      if (!sheetObj.CellValue(row, 'n4th_pod').substring(0,5) == ''){
 		    	 if(pod_str.indexOf (sheetObj.CellValue(row, 'n4th_pod').substring(0,5)) >= 0 ) {
 	 	        	ComEnableObject(document.form.ib_trsp_mode[0], false);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[1], false);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[2], false);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[3], false);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[4], false);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[5], false);
 	 	        	document.form.ib_trsp_mode[0].checked=true;

 		    	 }else {
 		    		ComEnableObject(document.form.ib_trsp_mode[0], true);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[1], true);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[2], true);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[3], true);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[4], true);
 	 	        	ComEnableObject(document.form.ib_trsp_mode[5], true); 
 		    	 }
  		    }else {
 		    	 	if (!sheetObj.CellValue(row, 'n3rd_pod').substring(0,5) == ''){
 		    	 		if(pod_str.indexOf (sheetObj.CellValue(row, 'n3rd_pod').substring(0,5)) >= 0 ) {
 		    	 			ComEnableObject(document.form.ib_trsp_mode[0], false);
 		    	 			ComEnableObject(document.form.ib_trsp_mode[1], false);
 		    	 			ComEnableObject(document.form.ib_trsp_mode[2], false);
 		    	 			ComEnableObject(document.form.ib_trsp_mode[3], false);
 		    	 			ComEnableObject(document.form.ib_trsp_mode[4], false);
 		    	 			ComEnableObject(document.form.ib_trsp_mode[5], false);
 		    	 		    //Standard Mode로 환원을 한다
 		    	 			document.form.ib_trsp_mode[0].checked=true; 
 		    	 		}else{
 		    	 			ComEnableObject(document.form.ib_trsp_mode[0], true);
 		 	 	        	ComEnableObject(document.form.ib_trsp_mode[1], true);
 		 	 	        	ComEnableObject(document.form.ib_trsp_mode[2], true);
 		 	 	        	ComEnableObject(document.form.ib_trsp_mode[3], true);
 		 	 	        	ComEnableObject(document.form.ib_trsp_mode[4], true);
 		 	 	        	ComEnableObject(document.form.ib_trsp_mode[5], true);
 		    	 		}
 		    	 	} else {
		        	  		if (!sheetObj.CellValue(row, 'n2nd_pod').substring(0,5) == ''){
		        	  			if(pod_str.indexOf (sheetObj.CellValue(row, 'n2nd_pod').substring(0,5)) >= 0 ) {
		        	  				ComEnableObject(document.form.ib_trsp_mode[0], false);
		        	  				ComEnableObject(document.form.ib_trsp_mode[1], false);
		        	  				ComEnableObject(document.form.ib_trsp_mode[2], false);
		        	  				ComEnableObject(document.form.ib_trsp_mode[3], false);
		        	  				ComEnableObject(document.form.ib_trsp_mode[4], false);
		        	  				ComEnableObject(document.form.ib_trsp_mode[5], false);
		        	  				 //Standard Mode로 환원을 한다
		        	  				document.form.ib_trsp_mode[0].checked=true;
		        	  			}else{
		        	  				ComEnableObject(document.form.ib_trsp_mode[0], true);
		         	 	        	ComEnableObject(document.form.ib_trsp_mode[1], true);
		         	 	        	ComEnableObject(document.form.ib_trsp_mode[2], true);
		         	 	        	ComEnableObject(document.form.ib_trsp_mode[3], true);
		         	 	        	ComEnableObject(document.form.ib_trsp_mode[4], true);
		         	 	        	ComEnableObject(document.form.ib_trsp_mode[5], true);
		        	  			}
		        	  		}else {
		        	  			if (!sheetObj.CellValue(row, 'n1st_pod').substring(0,5) == ''){
		        	  				if(pod_str.indexOf (sheetObj.CellValue(row, 'n1st_pod').substring(0,5)) >= 0 ) {
		        	  					ComEnableObject(document.form.ib_trsp_mode[0], false);
		        	  					ComEnableObject(document.form.ib_trsp_mode[1], false);
		        	  					ComEnableObject(document.form.ib_trsp_mode[2], false);
		        	  					ComEnableObject(document.form.ib_trsp_mode[3], false);
		        	  					ComEnableObject(document.form.ib_trsp_mode[4], false);
		        	  					ComEnableObject(document.form.ib_trsp_mode[5], false);
		        	  					 //Standard Mode로 환원을 한다
		        	  					document.form.ib_trsp_mode[0].checked=true;
		        	  				}else{
		        	  					ComEnableObject(document.form.ib_trsp_mode[0], true);
		        	 	 	        	ComEnableObject(document.form.ib_trsp_mode[1], true);
		        	 	 	        	ComEnableObject(document.form.ib_trsp_mode[2], true);
		        	 	 	        	ComEnableObject(document.form.ib_trsp_mode[3], true);
		        	 	 	        	ComEnableObject(document.form.ib_trsp_mode[4], true);
		        	 	 	        	ComEnableObject(document.form.ib_trsp_mode[5], true);
		        	  				}
		        	  			}else{
		   	    	  			} //n1st_pod check end
		        	  		}//n2nd_pod check end
 		    	 		}//n3rd_pod check end
  		    		}//n4th_pod check end
    	 } else if (colArr.indexOf(sheetObj.ColSaveName(col),0) >= 0 ){
//    		 formObj.dc_clpt.value = sheetObj.CellValue(row,col);
			 formObj.n1st_pol_dc_seq.value = "";
			 formObj.n1st_pod_dc_seq.value = "";
			 formObj.n2nd_pol_dc_seq.value = "";
			 formObj.n2nd_pod_dc_seq.value = "";
			 formObj.n3rd_pol_dc_seq.value = "";
			 formObj.n3rd_pod_dc_seq.value = "";
			 formObj.n4th_pol_dc_seq.value = "";
			 formObj.n4th_pod_dc_seq.value = "";
			 formObj.n1st_pol_clpt_ind_seq.value = "";
			 formObj.n1st_pod_clpt_ind_seq.value = "";
			 formObj.n2nd_pol_clpt_ind_seq.value = "";
			 formObj.n2nd_pod_clpt_ind_seq.value = "";
			 formObj.n3rd_pol_clpt_ind_seq.value = "";
			 formObj.n3rd_pod_clpt_ind_seq.value = "";
			 formObj.n4th_pol_clpt_ind_seq.value = "";
			 formObj.n4th_pod_clpt_ind_seq.value = "";	
			 
			 formObj.vvd1.value = "";
			 formObj.vvd2.value = "";
			 formObj.vvd3.value = "";
			 formObj.vvd4.value = "";
			 formObj.pol1.value = "";
			 formObj.pod1.value = "";
			 formObj.pol2.value = "";
			 formObj.pod2.value = "";
			 formObj.pol3.value = "";
			 formObj.pod3.value = "";
			 formObj.pol4.value = "";
			 formObj.pod4.value = "";			 
    		 formObj.n1st_pol_dc_seq.value = sheetObj.CellValue(row,"n1st_pol_dc_clpt_seq");
    		 formObj.n1st_pod_dc_seq.value = sheetObj.CellValue(row,"n1st_pod_dc_clpt_seq");
    		 formObj.n2nd_pol_dc_seq.value = sheetObj.CellValue(row,"n2nd_pol_dc_clpt_seq");
    		 formObj.n2nd_pod_dc_seq.value = sheetObj.CellValue(row,"n2nd_pod_dc_clpt_seq");
    		 formObj.n3rd_pol_dc_seq.value = sheetObj.CellValue(row,"n3rd_pol_dc_clpt_seq");
    		 formObj.n3rd_pod_dc_seq.value = sheetObj.CellValue(row,"n3rd_pod_dc_clpt_seq");
    		 formObj.n4th_pol_dc_seq.value = sheetObj.CellValue(row,"n4th_pol_dc_clpt_seq");
    		 formObj.n4th_pod_dc_seq.value = sheetObj.CellValue(row,"n4th_pod_dc_clpt_seq");
    		 
//    		 formObj.n1st_pol_clpt_ind_seq.value = sheetObj.CellValue(row,"n1st_pol_clpt_ind_seq");
//    		 formObj.n1st_pod_clpt_ind_seq.value = sheetObj.CellValue(row,"n1st_pod_clpt_ind_seq");
//    		 formObj.n2nd_pol_clpt_ind_seq.value = sheetObj.CellValue(row,"n2nd_pol_clpt_ind_seq");
//    		 formObj.n2nd_pod_clpt_ind_seq.value = sheetObj.CellValue(row,"n2nd_pod_clpt_ind_seq");
//    		 formObj.n3rd_pol_clpt_ind_seq.value = sheetObj.CellValue(row,"n3rd_pol_clpt_ind_seq");
//    		 formObj.n3rd_pod_clpt_ind_seq.value = sheetObj.CellValue(row,"n3rd_pod_clpt_ind_seq");
//    		 formObj.n4th_pol_clpt_ind_seq.value = sheetObj.CellValue(row,"n4th_pol_clpt_ind_seq");
//    		 formObj.n4th_pod_clpt_ind_seq.value = sheetObj.CellValue(row,"n4th_pod_clpt_ind_seq");
    		 
			 formObj.vvd1.value = sheetObj.CellValue(row,"n1st_vvd");
			 formObj.vvd2.value = sheetObj.CellValue(row,"n2nd_vvd");
			 formObj.vvd3.value = sheetObj.CellValue(row,"n3rd_vvd");
			 formObj.vvd4.value = sheetObj.CellValue(row,"n4th_vvd");
			 
			 if(sheetObj.ColSaveName(col) =="pre_n1st_pol_dc_chk"){
				 formObj.pol1.value = sheetObj.CellValue(row,"pre_n1st_pol_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n1st_pol_dc_chk"){
				 formObj.pol1.value = sheetObj.CellValue(row,"post_n1st_pol_dc").substring(0,5);
			 } else {
				 formObj.pol1.value = sheetObj.CellValue(row,"n1st_pol_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n1st_pod_dc_chk"){
				 formObj.pod1.value = sheetObj.CellValue(row,"pre_n1st_pod_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n1st_pod_dc_chk"){
				 formObj.pod1.value = sheetObj.CellValue(row,"post_n1st_pod_dc").substring(0,5);
			 } else {
				 formObj.pod1.value = sheetObj.CellValue(row,"n1st_pod_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n2nd_pol_dc_chk"){
				 formObj.pol2.value = sheetObj.CellValue(row,"pre_n2nd_pol_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n2nd_pol_dc_chk"){
				 formObj.pol2.value = sheetObj.CellValue(row,"post_n2nd_pol_dc").substring(0,5);
			 } else {
				 formObj.pol2.value = sheetObj.CellValue(row,"n2nd_pol_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n2nd_pod_dc_chk"){
				 formObj.pod2.value = sheetObj.CellValue(row,"pre_n2nd_pod_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n2nd_pod_dc_chk"){
				 formObj.pod2.value = sheetObj.CellValue(row,"post_n2nd_pod_dc").substring(0,5);
			 } else {
				 formObj.pod2.value = sheetObj.CellValue(row,"n2nd_pod_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n3rd_pol_dc_chk"){
				 formObj.pol3.value = sheetObj.CellValue(row,"pre_n3rd_pol_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n3rd_pol_dc_chk"){
				 formObj.pol3.value = sheetObj.CellValue(row,"post_n3rd_pol_dc").substring(0,5);
			 } else {
				 formObj.pol3.value = sheetObj.CellValue(row,"n3rd_pol_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n3rd_pod_dc_chk"){
				 formObj.pod3.value = sheetObj.CellValue(row,"pre_n3rd_pod_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n3rd_pod_dc_chk"){
				 formObj.pod3.value = sheetObj.CellValue(row,"post_n3rd_pod_dc").substring(0,5);
			 } else {
				 formObj.pod3.value = sheetObj.CellValue(row,"n3rd_pod_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n4th_pol_dc_chk"){
				 formObj.pol4.value = sheetObj.CellValue(row,"pre_n4th_pol_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n4th_pol_dc_chk"){
				 formObj.pol4.value = sheetObj.CellValue(row,"post_n4th_pol_dc").substring(0,5);
			 } else {
				 formObj.pol4.value = sheetObj.CellValue(row,"n4th_pol_n").substring(0,5);
			 }
			 if(sheetObj.ColSaveName(col) =="pre_n4th_pod_dc_chk"){
				 formObj.pod4.value = sheetObj.CellValue(row,"pre_n4th_pod_dc").substring(0,5);
			 } else if(sheetObj.ColSaveName(col) =="post_n4th_pod_dc_chk"){
				 formObj.pod4.value = sheetObj.CellValue(row,"post_n4th_pod_dc").substring(0,5);
			 } else {
				 formObj.pod4.value = sheetObj.CellValue(row,"n4th_pod_n").substring(0,5);
			 }

    		 dcSearch(sheetObj);
    	 } 
      
      }
     
     /*
      * pc를 새로 생성한다. 
      */
     function sheet2_OnChange(sheetObj, row, col, value){
    	 var formObj = document.form;
    	 if (sheetObj.ColSaveName(col) == "mt_chk" || sheetObj.ColSaveName(col) == "yd_cd" ) {
    		 if( sheetObj.CellValue(row,"yd_cd")=='' || sheetObj.CellValue(row,"yd_cd").length < 7 ){
    			 return;
    		 }
    		 ComOpenWait(true);
    		 formObj.f_cmd.value = SEARCHLIST01 ;
    		 formObj.m_pu.value = sheetObj.CellValue(row,"yd_cd") ;
    		 formObj.sXml.value = '' ;
//    		 sheetObj.WaitImageVisible = true;   

			 // ocean route 쉬트에서 채크된 row에 rout_seq 컬럼값 저장하기
			 var routeSeq;
			 for (i = 0; i < sheetObjects[0].Rows; i++) {
				 if(sheetObjects[0].CellValue(i, "chk") == 1){
					 routeSeq = sheetObjects[0].CellValue(i, "rout_seq");
					 break;
				 }
			 }

    		 var sXml = sheetObj.GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));
    		 
    		 
//    		 sheetObj.ShowDebugMsg = true;  
//    		 sheetObjects[0].WaitImageVisible = false;  
    		 var arrXml = sXml.split("|$$|"); 
             for(var i = 0; i < arrXml.length; i++){  
//                     sheetObjects[i].Redraw = false;       
                     if(i > 0) {   
//                    	 sheetObjects[i].WaitImageVisible = false;     
                     }     
                     sheetObjects[i].LoadSearchXml(arrXml[i]);  
                     if(i > 0) {   
//                         sheetObjects[i].WaitImageVisible = true;     
                     }                      
//                     sheetObjects[i].Redraw = true;   
             }  
   		 
			 // ocena route sheet 가 재 로딩되면 기존에 routeSeq 변수에 저장되어 있는 값으로 row 채크
			 var routeSeqFlag = true;
			 for (i = 0; i < sheetObjects[0].Rows; i++) {
				 if(sheetObjects[0].CellValue(i, "rout_seq") == routeSeq){
					 sheetObjects[0].CellValue2(i, "chk") = 1;
					 routeSeqFlag = false;
				 }
			 }
			 if(routeSeqFlag){
				 sheetObjects[0].CellValue2(parseInt(sheetObj.HeaderRows),"chk") = 1;
			 }

    		 var arr_dt = ComGetEtcData(arrXml[0],"arr_dt");
    		 var transit_dt = ComGetEtcData(arrXml[0],"transit_dt");
    		 var return_str = ComGetEtcData(arrXml[0],"returnStr");
    		 var cop_map_seq = ComGetEtcData(arrXml[0],"map_seq");
    		 var cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
// 			 var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
//			 if(hamRtm != null && hamRtm.length > 0){
//			     ComShowMessage(hamRtm);
//			 }
    		 var mt_pu_dt =  ComGetEtcData(arrXml[0],"mt_pu_dt");
    			
    		 if(arrXml.length ==1) { //생성 실패시.
    			 sheetObjects[1].RemoveAll();
    			 sheetObjects[2].RemoveAll();
    			 
    			 if( arr_dt==undefined ) arr_dt='' ; 
    			 if( transit_dt==undefined ) transit_dt='' ; 
    			 if( cop_map_seq==undefined ) cop_map_seq='' ; 
    			 if( return_str==undefined ) return_str='' ; 
    			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
    			 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 
    		 }     		 
    		 

   			 formObj.fm_empty_dt.value   = ComGetEtcData(arrXml[0],"mt_pu_dt");
    		 ComAddSeparator(formObj.fm_empty_dt);

    		 formObj.arr_dt.value = arr_dt;
    		 formObj.transit_dt.value = transit_dt;
    		 formObj.return_str.value = return_str;
    		 formObj.map_seq.value = cop_map_seq;
    		 formObj.cnst_flg.value = cnst_flg;

    		 set_color_constraint_btn(cnst_flg);
    		 ComOpenWait(false);
    	 }
    	 
     }

     /*
      * pc를 새로 생성한다.
      */
     function sheet3_OnChange(sheetObj, row, col, value){
//    	 alert(sheetObj.CellValue(row,"frt_chk")+':::'+row);
    	 var formObj = document.form;
    	 if (sheetObj.ColSaveName(col) == "frt_chk" || sheetObj.ColSaveName(col) == "yd_cd" ) {
    		 if( sheetObj.CellValue(row,"yd_cd")=='' || sheetObj.CellValue(row,"yd_cd").length < 7 
    				 || sheetObj.CellValue(row,"frt_chk") =='0' ){
    			 return ;
    		 }
    		 ComOpenWait(true);
    		 formObj.f_cmd.value = SEARCHLIST01 ;
			 formObj.f_rt.value = sheetObj.CellValue(row,"yd_cd") ;
			 formObj.sXml.value = '' ;

			 // ocean route 쉬트에서 채크된 row에 rout_seq 컬럼값 저장하기
			 var routeSeq;
			 for (i = 0; i < sheetObjects[0].Rows; i++) {
				 if(sheetObjects[0].CellValue(i, "chk") == 1){
					 routeSeq = sheetObjects[0].CellValue(i, "rout_seq");
					 break;
				 }
			 }

			 var sXml = sheetObj.GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));


//    		 sheetObj.ShowDebugMsg = true;  
			 var arrXml = sXml.split("|$$|");
			 for(var i = 0; i < arrXml.length; i++){
//	                     sheetObjects[i].Redraw = false;       
//	                     if(i > 0) {   
//	                     sheetObjects[i].WaitImageVisible = false;     
//	                     }     
					 sheetObjects[i].LoadSearchXml(arrXml[i]);
//	                     sheetObjects[i].Redraw = true;   
			 }

			 // ocena route sheet 가 재 로딩되면 기존에 routeSeq 변수에 저장되어 있는 값으로 row 채크
			 var routeSeqFlag = true;
			 for (i = 0; i < sheetObjects[0].Rows; i++) {
				 if(sheetObjects[0].CellValue(i, "rout_seq") == routeSeq){
					 sheetObjects[0].CellValue2(i, "chk") = 1;
					 routeSeqFlag = false;
				 }
			 }
			 if(routeSeqFlag){
				 sheetObjects[0].CellValue2(parseInt(sheetObj.HeaderRows),"chk") = 1;
			 }

			 var arr_dt = ComGetEtcData(arrXml[0],"arr_dt");
			 var transit_dt = ComGetEtcData(arrXml[0],"transit_dt");
			 var return_str = ComGetEtcData(arrXml[0],"returnStr");
			 var cop_map_seq = ComGetEtcData(arrXml[0],"map_seq");
			 var cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
//			 var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
//			 if(hamRtm != null && hamRtm.length > 0){
//			     ComShowMessage(hamRtm);
//			 }
			 var mt_pu_dt =  ComGetEtcData(arrXml[0],"mt_pu_dt");			 

    		 if(arrXml.length ==1) { //생성 실패시.
    			 sheetObjects[1].RemoveAll();
    			 sheetObjects[2].RemoveAll();
    			 
    			 if( arr_dt==undefined ) arr_dt='' ; 
    			 if( transit_dt==undefined ) transit_dt='' ; 
    			 if( cop_map_seq==undefined ) cop_map_seq='' ; 
    			 if( return_str==undefined ) return_str='' ; 
    			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
    			 if( mt_pu_dt==undefined ) mt_pu_dt='' ;     			 
    		 }     
    		 
    		 formObj.fm_empty_dt.value   = ComGetEtcData(arrXml[0],"mt_pu_dt");
    		 ComAddSeparator(formObj.fm_empty_dt);

			 formObj.arr_dt.value = arr_dt;
			 formObj.transit_dt.value = transit_dt;
			 formObj.return_str.value = return_str;
			 formObj.map_seq.value = cop_map_seq;
			 formObj.cnst_flg.value = cnst_flg;
			 set_color_constraint_btn(cnst_flg);   
			 ComOpenWait(false);
    	 }
			 

     }
 
     
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 var formObj = document.form;
    	 sheetObj.ColHidden("pre_n1st_pol_dc_chk") = false;
    	 sheetObj.ColHidden("pre_n1st_pol_dc") = false;
    	 sheetObj.ColHidden("post_n1st_pol_dc_chk") = false;
    	 sheetObj.ColHidden("post_n1st_pol_dc") = false;
    	 sheetObj.ColHidden("n1st_pol_chk") = false;
		 sheetObj.ColHidden("pre_n1st_pod_dc_chk") = false;
		 sheetObj.ColHidden("pre_n1st_pod_dc") = false;
    	 sheetObj.ColHidden("post_n1st_pod_dc_chk") = false;
    	 sheetObj.ColHidden("post_n1st_pod_dc") = false;
    	 sheetObj.ColHidden("n1st_pod_chk") = false;
    	 sheetObj.ColHidden("pre_n2nd_pol_dc_chk") = false;
    	 sheetObj.ColHidden("pre_n2nd_pol_dc") = false;
    	 sheetObj.ColHidden("post_n2nd_pol_dc_chk") = false;
    	 sheetObj.ColHidden("post_n2nd_pol_dc") = false;
    	 sheetObj.ColHidden("n2nd_pol_chk") = false;
    	 sheetObj.ColHidden("pre_n3rd_pol_dc_chk") = false;
    	 sheetObj.ColHidden("pre_n3rd_pol_dc") = false;
    	 sheetObj.ColHidden("post_n3rd_pol_dc_chk") = false;
    	 sheetObj.ColHidden("post_n3rd_pol_dc") = false;
    	 sheetObj.ColHidden("n3rd_pol_chk") = false;
    	 sheetObj.ColHidden("pre_n3rd_pod_dc_chk") = false;
    	 sheetObj.ColHidden("pre_n3rd_pod_dc") = false;
    	 sheetObj.ColHidden("post_n3rd_pod_dc_chk") = false;
    	 sheetObj.ColHidden("post_n3rd_pod_dc") = false;
    	 sheetObj.ColHidden("n3rd_pod_chk") = false;
    	 sheetObj.ColHidden("pre_n4th_pol_dc_chk") = false;
    	 sheetObj.ColHidden("pre_n4th_pol_dc") = false;
    	 sheetObj.ColHidden("post_n4th_pol_dc_chk") = false;
    	 sheetObj.ColHidden("post_n4th_pol_dc") = false;
    	 sheetObj.ColHidden("n4th_pol_chk") = false;
    	 sheetObj.ColHidden("pre_n4th_pod_dc_chk") = false;
    	 sheetObj.ColHidden("pre_n4th_pod_dc") = false;
    	 sheetObj.ColHidden("post_n4th_pod_dc_chk") = false;
    	 sheetObj.ColHidden("post_n4th_pod_dc") = false;
    	 sheetObj.ColHidden("n4th_pod_chk") = false;
    	 
    	 if(sheetObj.RowCount > 0){
    		 sheetObj.CellValue2(parseInt(sheetObj.HeaderRows),"chk")="1";
    		 chkTempOcnRout(sheetObj.CellValue(parseInt(sheetObj.HeaderRows),"ocn_rout_usr_rmk"));
    		//Double Calling Port 존재 유무에 따른 처리
    		 if(formObj.pre_n1st_pol_dc.value!="Y"){
    			 sheetObj.ColHidden("pre_n1st_pol_dc_chk") = true;
    			 sheetObj.ColHidden("pre_n1st_pol_dc") = true;
    		 }
    		 if(formObj.post_n1st_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n1st_pol_dc_chk") = true;
            	 sheetObj.ColHidden("post_n1st_pol_dc") = true;
             }
    		 if(formObj.pre_n1st_pol_dc.value!="Y" && formObj.post_n1st_pol_dc.value!="Y"){
    			 sheetObj.ColHidden("n1st_pol_chk") = true;
    		 }
    		 
    		 if(formObj.pre_n1st_pod_dc.value!="Y"){
    			 sheetObj.ColHidden("pre_n1st_pod_dc_chk") = true;
    			 sheetObj.ColHidden("pre_n1st_pod_dc") = true;
    		 }
             if(formObj.post_n1st_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n1st_pod_dc_chk") = true;
            	 sheetObj.ColHidden("post_n1st_pod_dc") = true;
             }
             if(formObj.pre_n1st_pod_dc.value!="Y" && formObj.post_n1st_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("n1st_pod_chk") = true;
             }
             
             if(formObj.pre_n2nd_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("pre_n2nd_pol_dc_chk") = true;
            	 sheetObj.ColHidden("pre_n2nd_pol_dc") = true;
             }
             if(formObj.post_n2nd_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n2nd_pol_dc_chk") = true;
            	 sheetObj.ColHidden("post_n2nd_pol_dc") = true;
             }
             if(formObj.pre_n2nd_pol_dc.value!="Y" && formObj.post_n2nd_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("n2nd_pol_chk") = true;
             }

             if(formObj.pre_n2nd_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("pre_n2nd_pod_dc_chk") = true;
            	 sheetObj.ColHidden("pre_n2nd_pod_dc") = true;
             }
             if(formObj.post_n2nd_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n2nd_pod_dc_chk") = true;
            	 sheetObj.ColHidden("post_n2nd_pod_dc") = true;
             }
             if(formObj.pre_n2nd_pod_dc.value!="Y" && formObj.post_n2nd_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("n2nd_pod_chk") = true;
             }
             
             if(formObj.pre_n3rd_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("pre_n3rd_pol_dc_chk") = true;
            	 sheetObj.ColHidden("pre_n3rd_pol_dc") = true;
             }
             if(formObj.post_n3rd_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n3rd_pol_dc_chk") = true;
            	 sheetObj.ColHidden("post_n3rd_pol_dc") = true;
             }
             if(formObj.pre_n3rd_pol_dc.value!="Y" && formObj.post_n3rd_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("n3rd_pol_chk") = true;
             }
             
             if(formObj.pre_n3rd_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("pre_n3rd_pod_dc_chk") = true;
            	 sheetObj.ColHidden("pre_n3rd_pod_dc") = true;
             }
             if(formObj.post_n3rd_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n3rd_pod_dc_chk") = true;
            	 sheetObj.ColHidden("post_n3rd_pod_dc") = true;
             }
             if(formObj.pre_n3rd_pod_dc.value!="Y" && formObj.post_n3rd_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("n3rd_pod_chk") = true;
             }
             
             if(formObj.pre_n4th_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("pre_n4th_pol_dc_chk") = true;
            	 sheetObj.ColHidden("pre_n4th_pol_dc") = true;
             }
             if(formObj.post_n4th_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n4th_pol_dc_chk") = true;
            	 sheetObj.ColHidden("post_n4th_pol_dc") = true;
             }
             if(formObj.pre_n4th_pol_dc.value!="Y" && formObj.post_n4th_pol_dc.value!="Y"){
            	 sheetObj.ColHidden("n4th_pol_chk") = true;
             }
             
             if(formObj.pre_n4th_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("pre_n4th_pod_dc_chk") = true;
            	 sheetObj.ColHidden("pre_n4th_pod_dc") = true;
             }
             if(formObj.post_n4th_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("post_n4th_pod_dc_chk") = true;
            	 sheetObj.ColHidden("post_n4th_pod_dc") = true;
             }
             if(formObj.pre_n4th_pod_dc.value!="Y" && formObj.post_n4th_pod_dc.value!="Y"){
            	 sheetObj.ColHidden("n4th_pod_chk") = true;
             }
    		 
             for(var row=2; row<=sheetObj.RowCount+1; row++){
            	 sheetObj.CellEditable(row,"pctl_no") = false;
            	 sheetObj.CellEditable(row,"upd_ind_cd") = false;
            	 sheetObj.CellEditable(row,"ocn_rout_prio_cd") = false;
            	 sheetObj.CellEditable(row,"ttl_expn_amt") = false;
            	 sheetObj.CellEditable(row,"tztm_hrs") = false;
            	 sheetObj.CellEditable(row,"n1st_vsl_slan_cd") = false;

            	 sheetObj.CellEditable(row,"n1st_pol") = false;
            	 sheetObj.CellEditable(row,"n1st_pod") = false;
            	 sheetObj.CellEditable(row,"n1st_slan_cd") = false;
            	 sheetObj.CellEditable(row,"n1st_space") = false;
            	 sheetObj.CellEditable(row,"n2nd_vsl_slan_cd") = false;

            	 sheetObj.CellEditable(row,"n2nd_pol") = false;
            	 sheetObj.CellEditable(row,"n2nd_pod") = false;
            	 sheetObj.CellEditable(row,"n2nd_space") = false;
            	 sheetObj.CellEditable(row,"n3rd_vsl_slan_cd") = false;
            	 sheetObj.CellEditable(row,"n3rd_pol") = false;

            	 sheetObj.CellEditable(row,"n3rd_pod") = false;
            	 sheetObj.CellEditable(row,"n3rd_space") = false;
            	 sheetObj.CellEditable(row,"n4th_vsl_slan_cd") = false;
            	 sheetObj.CellEditable(row,"n4th_pol") = false;
            	 sheetObj.CellEditable(row,"n4th_pod") = false;
            	 
            	 sheetObj.CellEditable(row,"n4th_space") = false;

            	 sheetObj.CellEditable(row,"post_n1st_pol_dc") = false;
            	 sheetObj.CellEditable(row,"post_n1st_pod_dc") = false;
            	 sheetObj.CellEditable(row,"post_n2nd_pol_dc") = false;
            	 sheetObj.CellEditable(row,"post_n2nd_pod_dc") = false;
            	 sheetObj.CellEditable(row,"post_n3rd_pol_dc") = false;
            	 sheetObj.CellEditable(row,"post_n3rd_pod_dc") = false;
            	 sheetObj.CellEditable(row,"post_n4th_pol_dc") = false;
            	 sheetObj.CellEditable(row,"post_n4th_pod_dc") = false;
            	 
            	 sheetObj.CellEditable(row,"pre_n1st_pol_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n1st_pod_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n2nd_pol_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n2nd_pod_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n3rd_pol_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n3rd_pod_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n4th_pol_dc") = false;
            	 sheetObj.CellEditable(row,"pre_n4th_pod_dc") = false;

            	 sheetObj.CellValue2(row,"n1st_pol_chk") = "Y";
            	 sheetObj.CellValue2(row,"n1st_pod_chk") = "Y";
            	 sheetObj.CellValue2(row,"n2nd_pol_chk") = "Y";
            	 sheetObj.CellValue2(row,"n2nd_pod_chk") = "Y";
            	 sheetObj.CellValue2(row,"n3rd_pol_chk") = "Y";
            	 sheetObj.CellValue2(row,"n3rd_pod_chk") = "Y";
            	 sheetObj.CellValue2(row,"n4th_pol_chk") = "Y";
            	 sheetObj.CellValue2(row,"n4th_pod_chk") = "Y";

            	 sheetObj.CellEditable(row,"n1st_pol_chk") = false;
            	 sheetObj.CellEditable(row,"n1st_pod_chk") = false;
            	 sheetObj.CellEditable(row,"n2nd_pol_chk") = false;
            	 sheetObj.CellEditable(row,"n2nd_pod_chk") = false;
            	 sheetObj.CellEditable(row,"n3rd_pol_chk") = false;
            	 sheetObj.CellEditable(row,"n3rd_pod_chk") = false;
            	 sheetObj.CellEditable(row,"n4th_pol_chk") = false;
            	 sheetObj.CellEditable(row,"n4th_pod_chk") = false;

            	 //Double Calling Port 존재 유무에 따른 처리
            	 if(sheetObj.CellValue(row,"n1st_pol_dc_clpt_seq")==""){
                	 sheetObj.CellEditable(row,"pre_n1st_pol_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n1st_pol_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n1st_pod_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n1st_pod_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n1st_pod_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n2nd_pol_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n2nd_pol_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n2nd_pol_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n2nd_pod_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n2nd_pod_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n2nd_pod_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n3rd_pol_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n3rd_pol_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n3rd_pol_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n3rd_pod_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n3rd_pod_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n3rd_pod_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n4th_pol_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n4th_pol_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n4th_pol_dc_chk") = false;
                 }
            	 if(sheetObj.CellValue(row,"n4th_pod_dc_clpt_seq")==""){
            		 sheetObj.CellEditable(row,"pre_n4th_pod_dc_chk") = false;
                	 sheetObj.CellEditable(row,"post_n4th_pod_dc_chk") = false;
                 }
             }
             
    		 ComBtnEnable("btn_select"); 
    		 ComBtnEnable("btng_constraints"); 
    		 ComBtnEnable("btng_fullroute"); 
    		 
	 		// 	        POD :  USLGB, USOAK, USPDX, USTIW, USSEA, CAVAN, CAPRR, USLAX 
	 		//             위의 Port들을 POD로 잡는 모든 BKG은 PRD에서 제공하는 Inland Route(본부에서 정한 Standard IRG)에서
	 		//             다른 IRG로 BKG User가 임의대로 변경하지 못하도록 했으나
	 		//위의 POD에 해당되지 않는 PORT에 대해서 변경이 안되어서 check 박스를 통해서 PORT 외에선 변경이 가능도록 변경 		 
    	 	if (sheetObj.CellValue(sheetObj.HeaderRows,"chk") == '1') {	 
		 		var pod_str ='USLGB, USOAK, USPDX, USTIW, USSEA, CAVAN, CAPRR, USLAX';
		 		if (!sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n4th_pod').substring(0,5) == ''){
		 			if(pod_str.indexOf (sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n4th_pod').substring(0,5)) >= 0 ) {
		 				ComEnableObject(document.form.ib_trsp_mode[0], false);
		 				ComEnableObject(document.form.ib_trsp_mode[1], false);
		 				ComEnableObject(document.form.ib_trsp_mode[2], false);
		 				ComEnableObject(document.form.ib_trsp_mode[3], false);
		 				ComEnableObject(document.form.ib_trsp_mode[4], false);
		 				ComEnableObject(document.form.ib_trsp_mode[5], false);
		 				document.form.ib_trsp_mode[0].checked=true;

		 			}else {
		 				ComEnableObject(document.form.ib_trsp_mode[0], true);
		 				ComEnableObject(document.form.ib_trsp_mode[1], true);
		 				ComEnableObject(document.form.ib_trsp_mode[2], true);
		 				ComEnableObject(document.form.ib_trsp_mode[3], true);
		 				ComEnableObject(document.form.ib_trsp_mode[4], true);
		 				ComEnableObject(document.form.ib_trsp_mode[5], true); 
		 			}
		 		}else {
		 			if (!sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n3rd_pod').substring(0,5) == ''){
		 				if(pod_str.indexOf (sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n3rd_pod').substring(0,5)) >= 0 ) {
		 					ComEnableObject(document.form.ib_trsp_mode[0], false);
		 					ComEnableObject(document.form.ib_trsp_mode[1], false);
		 					ComEnableObject(document.form.ib_trsp_mode[2], false);
		 					ComEnableObject(document.form.ib_trsp_mode[3], false);
		 					ComEnableObject(document.form.ib_trsp_mode[4], false);
		 					ComEnableObject(document.form.ib_trsp_mode[5], false);
		 					//Standard Mode로 환원을 한다
		 					document.form.ib_trsp_mode[0].checked=true; 
		 				}else{
		 					ComEnableObject(document.form.ib_trsp_mode[0], true);
		 					ComEnableObject(document.form.ib_trsp_mode[1], true);
		 					ComEnableObject(document.form.ib_trsp_mode[2], true);
		 					ComEnableObject(document.form.ib_trsp_mode[3], true);
		 					ComEnableObject(document.form.ib_trsp_mode[4], true);
		 					ComEnableObject(document.form.ib_trsp_mode[5], true);
		 				}
		 			} else {
		 				if (!sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n2nd_pod').substring(0,5) == ''){
		 					if(pod_str.indexOf (sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n2nd_pod').substring(0,5)) >= 0 ) {
		 						ComEnableObject(document.form.ib_trsp_mode[0], false);
		 						ComEnableObject(document.form.ib_trsp_mode[1], false);
		 						ComEnableObject(document.form.ib_trsp_mode[2], false);
		 						ComEnableObject(document.form.ib_trsp_mode[3], false);
		 						ComEnableObject(document.form.ib_trsp_mode[4], false);
		 						ComEnableObject(document.form.ib_trsp_mode[5], false);
		 						//Standard Mode로 환원을 한다
		 						document.form.ib_trsp_mode[0].checked=true;
		 					}else{
		 						ComEnableObject(document.form.ib_trsp_mode[0], true);
		 						ComEnableObject(document.form.ib_trsp_mode[1], true);
		 						ComEnableObject(document.form.ib_trsp_mode[2], true);
		 						ComEnableObject(document.form.ib_trsp_mode[3], true);
		 						ComEnableObject(document.form.ib_trsp_mode[4], true);
		 						ComEnableObject(document.form.ib_trsp_mode[5], true);
		 					}
		 				}else {
		 					if (!sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n1st_pod').substring(0,5) == ''){
		 						if(pod_str.indexOf (sheetObj.CellValue(parseInt(sheetObj.HeaderRows), 'n1st_pod').substring(0,5)) >= 0 ) {
		 							ComEnableObject(document.form.ib_trsp_mode[0], false);
		 							ComEnableObject(document.form.ib_trsp_mode[1], false);
		 							ComEnableObject(document.form.ib_trsp_mode[2], false);
		 							ComEnableObject(document.form.ib_trsp_mode[3], false);
		 							ComEnableObject(document.form.ib_trsp_mode[4], false);
		 							ComEnableObject(document.form.ib_trsp_mode[5], false);
		 							//Standard Mode로 환원을 한다
		 							document.form.ib_trsp_mode[0].checked=true;
		 						}else{
		 							ComEnableObject(document.form.ib_trsp_mode[0], true);
		 							ComEnableObject(document.form.ib_trsp_mode[1], true);
		 							ComEnableObject(document.form.ib_trsp_mode[2], true);
		 							ComEnableObject(document.form.ib_trsp_mode[3], true);
		 							ComEnableObject(document.form.ib_trsp_mode[4], true);
		 							ComEnableObject(document.form.ib_trsp_mode[5], true);
		 						}
		 					}else{
		 					} //n1st_pod check end
		 				}//n2nd_pod check end
		 			}//n3rd_pod check end
		 		}//n4th_pod check end
 		 	}// chk position check end
    	 } else {
    		 ComBtnDisable("btn_select"); 
    		 ComBtnDisable("btng_constraints"); 
    		 ComBtnDisable("btng_fullroute"); 
    		 document.getElementById('btng_constraints').style.color = "#737373";
    		 self.close(); // 닫히는 동작 제거는 우선 제외 (2011 12 23 진석호 대리와 협의)
    	 }

    	 for(i = parseInt(sheetObj.HeaderRows) ; i<= parseInt(sheetObj.HeaderRows)+sheetObj.RowCount ; i++){
    		 var fCol = 0;
    		 var tCol = 0;
    		 
			if(sheetObj.CellValue(i,'vvd_lnk_no')=='1'){
				fCol = sheetObj.SaveNameCol("n1st_vsl_slan_cd");
				tCol = sheetObj.SaveNameCol("n1st_space");
				sheetObj.RangeBackColor(i, fCol, i, tCol) =sheetObj.RgbColor(255,255,0);
				
			} else if(sheetObj.CellValue(i,'vvd_lnk_no')=='2'){
				fCol = sheetObj.SaveNameCol("n2nd_vsl_slan_cd");
				tCol = sheetObj.SaveNameCol("n2nd_space");
				sheetObj.RangeBackColor(i, fCol, i, tCol) =sheetObj.RgbColor(255,255,0);
				
			} else if(sheetObj.CellValue(i,'vvd_lnk_no')=='3'){
				fCol = sheetObj.SaveNameCol("n3rd_vsl_slan_cd");
				tCol = sheetObj.SaveNameCol("n3rd_space");
				sheetObj.RangeBackColor(i, fCol, i, tCol) =sheetObj.RgbColor(255,255,0); 	
				
			} else if(sheetObj.CellValue(i,'vvd_lnk_no')=='4'){
				fCol = sheetObj.SaveNameCol("n4th_vsl_slan_cd");
				tCol = sheetObj.SaveNameCol("n4th_space");
				sheetObj.RangeBackColor(i, fCol, i, tCol) =sheetObj.RgbColor(255,255,0); 	
				
			}
		}
//		sheetObj.RangeBackColor(0, 9, parseInt(sheetObj.RowCount)+1, 9) =sheetObj.RgbColor(0,234,0);
//		sheetObj.RangeBackColor(0, 10, parseInt(sheetObj.RowCount)+1, 10) =sheetObj.RgbColor(0,234,0);
    	 
    	 //    	 sheetObj.SetMergeCell(2, 9, 2, 1);
     }
     
     function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	 if(sheetObj.RowCount > 0){
    		 sheetObj.CellValue2(parseInt(sheetObj.HeaderRows),"mt_chk")="1";
    		 
             for(var row=2; row<=sheetObj.RowCount; row++){
            	 sheetObj.CellEditable(row,"yd_cd") = false;
            	 sheetObj.CellEditable(row,"nod_nm") = false;
            	 sheetObj.CellEditable(row,"d2") = false;
            	 sheetObj.CellEditable(row,"d4") = false;
            	 sheetObj.CellEditable(row,"d5") = false;

            	 sheetObj.CellEditable(row,"r2") = false;
            	 sheetObj.CellEditable(row,"r4") = false;
            	 sheetObj.CellEditable(row,"r5") = false;
             }
    	 }
     }
     
     function sheet3_OnSearchEnd(sheetObj, ErrMsg) {

    	 if(sheetObj.RowCount > 0){
    		 sheetObj.CellValue2(parseInt(sheetObj.HeaderRows),"frt_chk")="1";
    		 
             for(var row=2; row<=sheetObj.RowCount; row++){
            	 sheetObj.CellEditable(row,"yd_cd1") = false;
            	 sheetObj.CellEditable(row,"yd_cd") = false;
            	 sheetObj.CellEditable(row,"gen") = false;
            	 sheetObj.CellEditable(row,"rf") = false;
            	 sheetObj.CellEditable(row,"dg") = false;
             }
    	 }
     }

     /**
     * Double Calling Port 선택시 처리 로직
     */
    function dcSearch(sheetObj){
    	 var formObj = document.form;
    	 ComOpenWait(true);
		 formObj.f_cmd.value = SEARCHLIST01 ;
		 formObj.sXml.value = '' ;

		 // ocean route 쉬트에서 체크된 row에 rout_seq 컬럼값 저장하기
		 var routeSeq;
		 for (i = 0; i < sheetObjects[0].Rows; i++) {
			 if(sheetObjects[0].CellValue(i, "chk") == 1){
				 routeSeq = sheetObjects[0].CellValue(i, "rout_seq");
				 break;
			 }
		 }
//		 alert(PrdFQString(formObj));
		 var sXml = sheetObj.GetSearchXml("ESD_PRD_0080GS.do",PrdFQString(formObj));
		 
		 var arrXml = sXml.split("|$$|"); 

         formObj.pre_n1st_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol1_dc_flg");
         formObj.post_n1st_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol1_dc_flg");
         formObj.pre_n1st_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod1_dc_flg");
         formObj.post_n1st_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod1_dc_flg");
         formObj.pre_n2nd_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol2_dc_flg");
         formObj.post_n2nd_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol2_dc_flg");
         formObj.pre_n2nd_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod2_dc_flg");
         formObj.post_n2nd_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod2_dc_flg");
         formObj.pre_n3rd_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol3_dc_flg");
         formObj.post_n3rd_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol3_dc_flg");
         formObj.pre_n3rd_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod3_dc_flg");
         formObj.post_n3rd_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod3_dc_flg");
         formObj.pre_n4th_pol_dc.value   = ComGetEtcData(arrXml[0],"pre_pol4_dc_flg");
         formObj.post_n4th_pol_dc.value   = ComGetEtcData(arrXml[0],"post_pol4_dc_flg");
         formObj.pre_n4th_pod_dc.value   = ComGetEtcData(arrXml[0],"pre_pod4_dc_flg");
         formObj.post_n4th_pod_dc.value   = ComGetEtcData(arrXml[0],"post_pod4_dc_flg");		 
		 
		 for(var i = 0; i < arrXml.length; i++){  
                 sheetObjects[i].LoadSearchXml(arrXml[i]);  
         }  
		 
		 // ocena route sheet 가 재 로딩되면 기존에 routeSeq 변수에 저장되어 있는 값으로 row 체크
		 var routeSeqFlag = true;
		 for (i = 0; i < sheetObjects[0].Rows; i++) {
			 if(sheetObjects[0].CellValue(i, "rout_seq") == routeSeq){
				 sheetObjects[0].CellValue2(i, "chk") = 1;
				 routeSeqFlag = false;
			 }
		 }
		 if(routeSeqFlag){
			 sheetObjects[0].CellValue2(parseInt(sheetObj.HeaderRows),"chk") = 1;
		 }

		 var arr_dt = ComGetEtcData(arrXml[0],"arr_dt");
		 var transit_dt = ComGetEtcData(arrXml[0],"transit_dt");
		 var return_str = ComGetEtcData(arrXml[0],"returnStr");
		 var cop_map_seq = ComGetEtcData(arrXml[0],"map_seq");
		 var cnst_flg = ComGetEtcData(arrXml[0],"cnst_flg");
//		 var hamRtm = ComGetEtcData(arrXml[0],"ham_rtm");
//		 if(hamRtm != null && hamRtm.length > 0){
//		     ComShowMessage(hamRtm);
//		 }
		 var mt_pu_dt =  ComGetEtcData(arrXml[0],"mt_pu_dt");
			
		 if(arrXml.length ==1) { //생성 실패시.
			 sheetObjects[1].RemoveAll();
			 sheetObjects[2].RemoveAll();
			 
			 if( arr_dt==undefined ) arr_dt='' ; 
			 if( transit_dt==undefined ) transit_dt='' ; 
			 if( cop_map_seq==undefined ) cop_map_seq='' ; 
			 if( return_str==undefined ) return_str='' ; 
			 if( cnst_flg==undefined ) cnst_flg='' ; 			 
			 if( mt_pu_dt==undefined ) mt_pu_dt='' ; 
		 }     		 

		 formObj.fm_empty_dt.value   = ComGetEtcData(arrXml[0],"mt_pu_dt");
		 ComAddSeparator(formObj.fm_empty_dt);

		 formObj.arr_dt.value = arr_dt;
		 formObj.transit_dt.value = transit_dt;
		 formObj.return_str.value = return_str;
		 formObj.map_seq.value = cop_map_seq;
		 formObj.cnst_flg.value = cnst_flg;

		 set_color_constraint_btn(cnst_flg);
		 ComOpenWait(false);

    }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

	 // Validation 체크
     function chkVal(selRownum) {
    	 var ord = sheetObjects[0].CellValue(selRownum,"ord");
    	 var lnk_knt = sheetObjects[0].CellValue(selRownum,"lnk_knt");
    	 var ttl_expn_amt =  sheetObjects[0].CellValue(selRownum,"ttl_expn_amt");
    	 var ordType = 0;
    	 for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
			 if(parseFloat(sheetObjects[0].CellValue(i, "ord")) > parseFloat(ordType)){
				 ordType = sheetObjects[0].CellValue(i, "ord");
			 }
		 }
    	 
    	 for (var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].Rows; i++) {
    		 if(ordType > 1){
    			 if(i!=selRownum){
    				 // Guide 와 Standard Flag 가 존재할 경우
    				 if(parseFloat(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "ord"))==1){
    					 if(parseFloat(ord)>1){
	    					 return false;
    					 }
    				 // Guide 와 Standard Flag 가 존재하지 않을 경우(Cost 만 체크)
    				 } else if(parseFloat(sheetObjects[0].CellValue(i, "ttl_expn_amt")) < parseFloat(ttl_expn_amt)){
						 return false;
    				 }
    			 }
    		 // Guide 와 Stadard Flag 만 존재할 경우
    		 } else {
    			 if(i!=selRownum){
    				 // Direct Call 인 경우는 Validation Check 없이 Pass 
    				 if(parseFloat(lnk_knt) > 1){
    					 if(parseFloat(sheetObjects[0].CellValue(i, "ord")) < parseFloat(ord)){
    						 return false;
    					 } else {
    						 if(parseFloat(sheetObjects[0].CellValue(i, "lnk_knt")) < parseFloat(lnk_knt)){
    							 return false;
    						 } else {
    							 if(parseFloat(sheetObjects[0].CellValue(i, "ttl_expn_amt")) < parseFloat(ttl_expn_amt)){
    								 return false;
    							 }
    						 }
    					 }
    				 }
    			 }
    		 }
    	 }

    	 return true;
     }

	 
     function sheet1_OnClick (sheetObj, row,col) {
    	 var formObj = document.form;
         if(sheetObj.CellValue(row,"n1st_pol_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n1st_pol_chk") {
//        		 sheetObj.CellValue2(row,"post_n1st_pol_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"pre_n1st_pol_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n1st_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n1st_pol_dc_chk"){
        		 sheetObj.CellValue2(row,"n1st_pol_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 } 
         }
         if(sheetObj.CellValue(row,"n1st_pod_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n1st_pod_chk") {
//        		 sheetObj.CellValue2(row,"n1st_pod_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n1st_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n1st_pod_dc_chk"){
        		 sheetObj.CellValue2(row,"n1st_pod_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
         if(sheetObj.CellValue(row,"n2nd_pol_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n2nd_pol_chk") {
//        		 sheetObj.CellValue2(row,"n2nd_pol_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n2nd_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n2nd_pol_dc_chk"){
        		 sheetObj.CellValue2(row,"n2nd_pol_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
         if(sheetObj.CellValue(row,"n2nd_pod_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n2nd_pod_chk") {
//        		 sheetObj.CellValue2(row,"n2nd_pod_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n2nd_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n2nd_pod_dc_chk"){
        		 sheetObj.CellValue2(row,"n2nd_pod_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
         if(sheetObj.CellValue(row,"n3rd_pol_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n3rd_pol_chk") {
//        		 sheetObj.CellValue2(row,"n3rd_pol_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n3rd_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n3rd_pol_dc_chk"){
        		 sheetObj.CellValue2(row,"n3rd_pol_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
         if(sheetObj.CellValue(row,"n3rd_pod_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n3rd_pod_chk") {
//        		 sheetObj.CellValue2(row,"n3rd_pod_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n3rd_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n3rd_pod_dc_chk"){
        		 sheetObj.CellValue2(row,"n3rd_pod_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
         if(sheetObj.CellValue(row,"n4th_pol_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n4th_pol_chk") {
//        		 sheetObj.CellValue2(row,"n4th_pol_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n4th_pol_dc_chk" || sheetObj.ColSaveName(col) == "post_n4th_pol_dc_chk"){
        		 sheetObj.CellValue2(row,"n4th_pol_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
         if(sheetObj.CellValue(row,"n4th_pod_dc_clpt_seq")!=""){
//        	 if (sheetObj.ColSaveName(col) == "n4th_pod_chk") {
//        		 sheetObj.CellValue2(row,"n4th_pod_dc_chk") = "N";
//        		 sheetObj.CellValue2(row,"chk") = "Y";
//        	 } else 
        	 if (sheetObj.ColSaveName(col) == "pre_n4th_pod_dc_chk" || sheetObj.ColSaveName(col) == "post_n4th_pod_dc_chk"){
        		 sheetObj.CellValue2(row,"n4th_pod_chk") = "N";
        		 sheetObj.CellValue2(row,"chk") = "Y";
        	 }
         }
    	 
     }	 
	 
     function sheet2_OnDblClick (sheetObj, row,col,value ) {
//    	 alert(sheetObj.CellValue(row,col)+"::"+sheetObj.ColSaveName(col));
    	 if (sheetObj.ColSaveName(col) == "yd_cd") {
			var param="?node_cd="+sheetObj.CellValue(row,col);   
		    ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 780, 420, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);

    	 }

     }

  	// ESD_PRD_0083 호출후 Return 받는값.

    //[CSR#2816] 요청에 따른 Logic 비활성화에 따른 주석 처리 [기존 logic 복구시 해당 CSR의 주석만 복원] Start
//  	function callBackEsdPrd0083(valChk){
//  		var formObject = document.form;
//  		if(valChk){
//  			formObject.valChk.value="Y";
//  		}
//  	}
    //[CSR#2816] 요청에 따른 Logic 비활성화에 따른 주석 처리 [기존 logic 복구시 해당 CSR의 주석만 복원] End
  	
    /**
     * constraint 팝업 호출
     * @param formObj
     * @return
     */
    function fnPopConstraintDetail(pctlNo){
	   	var newForm  = "<form name='form_prd_pop' method='post'>" ;
	   	newForm += "  <input type='hidden' name='pctl_no'       value='" + pctlNo + "'>" ;	
	   	newForm += "  <input type='hidden' name='pgmNo' value='ESD_PRD_0082'>" ;	
	   	newForm += "</form>";
	   	document.all.prd_form.innerHTML = newForm ;
	   	var formObj = document.form_prd_pop ;
	   	var paramUrl = "pgmNo=ESD_PRD_0082&pctl_no="+pctlNo+'&bkg_no='+document.form.bkg_no.value;
        var newWin = window.showModalDialog("ESD_PRD_0082.do?"+paramUrl, "detail", "scroll:yes;status:no;resizable:auto;help:no;dialogWidth:800px;dialogHeight:450px");
    }
     
     /* 개발자 작업  끝 */