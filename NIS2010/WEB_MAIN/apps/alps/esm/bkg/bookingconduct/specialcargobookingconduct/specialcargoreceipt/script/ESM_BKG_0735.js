/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0735.js
*@FileTitle : Criteria for out guage calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.08 이병규
* 1.0 Creation
* 2011.11.15 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
* 2011.12.20 변종건 [CHM-201114816-01] 위험물  입력 관련 로직 변경 추가 요청 검토(추가 요청 사항)
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
     * @class esm_bkg_0735 : esm_bkg_0735 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0735() {
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
 
 var radioChk = 0;
 var opener = window.dialogArguments;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             				
				            case "btn_ok":
				            	copyCntrSeq();
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

         //khlee-시작 환경 설정 함수 이름 변경
 				ComConfigSheet (sheetObjects[i] );

 				initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
 				ComEndConfigSheet(sheetObjects[i]);
         }
 			
 			
 			initControl();
 			var formObj = document.form;
 			
 			if(document.getElementById("copyFlg").value == "Y"){
 				
 				document.getElementById("chk1text").disabled = false;
 				radioChk = "1";
 			}else{
 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 				document.getElementsByName("radioChk2")[0].disabled = false;
	    		document.getElementsByName("radioChk2")[1].disabled = false;
	    		if(ComGetObjValue(formObj.usr_ofc_cd) == "SELSC"){
	    			//document.getElementsByName("radioChk2")[2].disabled = false;
	    			document.all.oldBkgDiv.style.visibility = 'visible';
	    		}else{
	    			//document.getElementsByName("radioChk2")[2].disabled = true;
	    			document.all.oldBkgDiv.style.visibility = 'hidden';
	    		}
	    		document.getElementById("chk2text").disabled = true; 
	    		document.getElementById("chk2text3").disabled = true; 
	    			
	  			sheetObjects[0].editable = false;
 			}
  			

     }
      
   function initControl() {    	  
  	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
  	    axon_event.addListenerForm('click',    'obj_click',     form);
  	    axon_event.addListenerForm('keypress','obj_keypress', form);
  	    
  	}
    
    function obj_click(){
  		switch (event.srcElement.name) {  	 		
  			/*
  		    case "radioChk1":
  		    	
  		    	var size = document.getElementsByName("radioChk1").length;
  		    	
  		    	for(var i = 0; i < size; i++) {
  		    	  if(document.getElementsByName("radioChk1")[i].checked) {
  		    		  
  		    		  if(document.getElementsByName("radioChk1")[i].value == "1"){
  		    			document.getElementsByName("radioChk2")[0].checked = false;
  		    			document.getElementsByName("radioChk2")[1].checked = false;
  		    			document.getElementsByName("radioChk2")[0].disabled = true;
  		    			document.getElementsByName("radioChk2")[1].disabled = true;
  		    			document.getElementById("chk1text").disabled = false;
  		    			document.getElementById("chk2text").disabled = true;
  		    			sheetObjects[0].editable = false;
  		    			
  		    			radioChk = "1";
  		    			
  		    		  }else{  	
  		    			  
  		    			document.getElementsByName("radioChk2")[0].disabled = false;
  		    			document.getElementsByName("radioChk2")[1].disabled = false;
  		    			document.getElementById("chk2text").disabled = true; 
  		    			document.getElementById("chk1text").disabled = true;
  		    			
  		    		  }
  		    	  } 
  		    	}
  		    			    	
  		    break;
  		 */
  		    case "radioChk2":
				var size = document.getElementsByName("radioChk2").length;
				  		    	
  		    	for(var i = 0; i < size; i++) {
  		    	  if(document.getElementsByName("radioChk2")[i].checked) {
  		    		  if(document.getElementsByName("radioChk2")[i].value == "1"){
  		    			
  		    			sheetObjects[0].editable = false;  	
  		    			document.getElementById("chk2text").disabled = false;
  		    			document.getElementById("chk2text3").disabled = true;
  		    			radioChk = "2";
  		    			
  		    		  }else if(document.getElementsByName("radioChk2")[i].value == "3"){
		    			sheetObjects[0].editable = false;  	
		    			document.getElementById("chk2text").disabled = true;
		    			document.getElementById("chk2text3").disabled = false;
		    			radioChk = "4"; 
  		    		  }else{
  		    			sheetObjects[0].editable = true;
  		    			document.getElementById("chk2text").disabled = true;
  		    			document.getElementById("chk2text3").disabled = true;
  		    			radioChk = "3";
  		    			
  		    		  }
  		    	 } 
  		    }
  		    break;
  		 
  		}	
  	}
    
    
    function obj_keypress(){
    	
		switch (event.srcElement.name) {		
				
		    case "chk1text":		    	
		    	ComKeyOnlyNumber(event.srcElement);   	
			break;
			
		    case "chk2text":		    	
		    	ComKeyOnlyNumber(event.srcElement, "-.");   	
			break;	    
		}	
	}

    
    function copyCntrSeq(){
    	
    	opener.document.getElementById("temp_cntr_no").value = "";
    	if(radioChk == "1" && document.getElementById("chk1text").value != ""){
    		var chk = document.getElementById("chk1text").value;
    		var sRow = opener.sheetObjects[3].FindCheckedRow("CntrChk");
    		var arrRow = sRow.split("|");   		
    		
    		var cntr_name = "";
			var cntr_val = "";
			
			for (var j=1; j <= opener.sheetObjects[4].RowCount; j++){	 									
					
					if(opener.sheetObjects[4].CellValue(j, "DelChk") == "0"){
						
						cntr_name += opener.sheetObjects[4].CellValue(j, "name")+"|";
						cntr_val += opener.sheetObjects[4].CellValue(j, "val")+"|";	 										
					} 									
			}
			cntr_val = cntr_val.substr(0, cntr_val.length-1);	
			cntr_name = cntr_name.substr(0, cntr_name.length-1);   
			    		
    		
    		for (var i=1; i <= chk; i++){
    			
    			var row1 = opener.sheetObjects[1].DataInsert(-1);  
    			
    			opener.sheetObjects[1].CellValue2(row1, "cntr_no") = "";    			
    			
    			opener.sheetObjects[1].CellComboItem(row1, "cntr_no", " |"+cntr_name, " |"+cntr_val);
    			
    			opener.sheetObjects[1].CellValue2(row1, "cntr_tpsz_cd") = opener.document.getElementById("cntr_tpsz_cd").value;    	
    			opener.sheetObjects[1].CellValue2(row1, "cntr_cgo_seq") = "1"; 
    			
    			var findTpszRow = opener.sheetObjects[0].FindText("cntr_tpsz_cd", opener.document.getElementById("cntr_tpsz_cd").value, 1, 0, 2)    			
    			var cntr_vol_qty = opener.sheetObjects[0].CellValue(findTpszRow, "dcgo_qty");
    			
    			if(cntr_vol_qty >= 1){
    				
    				cntr_vol_qty = "1";
    			}
    			
    			var dg_cntr_seq = Number(opener.sheetObjects[1].CellValue(1, "dg_cntr_seq"));
    			
    			
				for(var j=1; j <= opener.sheetObjects[1].RowCount; j++){
					
					if(dg_cntr_seq < Number(opener.sheetObjects[1].CellValue(j, "dg_cntr_seq"))){
						
						dg_cntr_seq = Number(opener.sheetObjects[1].CellValue(j, "dg_cntr_seq"));
						
					}
				}
				opener.sheetObjects[1].CellValue2(row1, "cntr_vol_qty") = cntr_vol_qty;
				opener.sheetObjects[1].CellValue2(row1, "dg_cntr_seq") = Number(dg_cntr_seq) + 1;				
    			
    			
    			for(idx=0; idx < arrRow.length-1; idx++){
    				
    				var row2 = opener.sheetObjects[3].DataInsert(-1); 
    				
    				var dcgo_seq = Number(opener.sheetObjects[3].CellValue(1, "dcgo_seq"));
    				
    				for(var k=1; k <= opener.sheetObjects[3].RowCount; k++){
    					
    					if(dcgo_seq < Number(opener.sheetObjects[3].CellValue(k, "dcgo_seq"))){
    						
    						dcgo_seq = Number(opener.sheetObjects[3].CellValue(k, "dcgo_seq"));
    					}
    				}
    				
    				opener.sheetObjects[3].CellValue2(row2, "dcgo_seq") = Number(dcgo_seq)+1;
    				opener.sheetObjects[3].CellValue2(row2, "cntr_cgo_seq") = opener.sheetObjects[3].CellValue(arrRow[idx], "cntr_cgo_seq");
    				opener.sheetObjects[3].CellValue2(row2, "spcl_cgo_seq") = opener.sheetObjects[3].CellValue(arrRow[idx], "cntr_cgo_seq");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_clss_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_clss_cd");	  
    				opener.sheetObjects[3].CellValue2(row2, "imdg_comp_grp_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_comp_grp_cd");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_un_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_un_no");
    				opener.sheetObjects[3].CellValue2(row2, "grs_wgt") = opener.sheetObjects[3].CellValue(arrRow[idx], "grs_wgt");
    				opener.sheetObjects[3].CellValue2(row2, "wgt_ut_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "wgt_ut_cd");    				
    				opener.sheetObjects[3].CellValue2(row2, "net_wgt") = opener.sheetObjects[3].CellValue(arrRow[idx], "net_wgt");
    				opener.sheetObjects[3].CellValue2(row2, "prp_shp_nm") = opener.sheetObjects[3].CellValue(arrRow[idx], "prp_shp_nm");
    				opener.sheetObjects[3].CellValue2(row2, "hzd_desc") = opener.sheetObjects[3].CellValue(arrRow[idx], "hzd_desc");	  
    				opener.sheetObjects[3].CellValue2(row2, "flsh_pnt_cdo_temp") = opener.sheetObjects[3].CellValue(arrRow[idx], "flsh_pnt_cdo_temp");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_pck_grp_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_pck_grp_cd");
    				opener.sheetObjects[3].CellValue2(row2, "psa_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "psa_no");	  
    				opener.sheetObjects[3].CellValue2(row2, "imdg_lmt_qty_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_lmt_qty_flg");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_expt_qty_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_expt_qty_flg");
    				opener.sheetObjects[3].CellValue2(row2, "hcdg_flag") = opener.sheetObjects[3].CellValue(arrRow[idx], "hcdg_flag");	   
    				opener.sheetObjects[3].CellValue2(row2, "imdg_subs_rsk_lbl_cd1") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd1");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_subs_rsk_lbl_cd2") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd2");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_subs_rsk_lbl_cd3") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd3");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_subs_rsk_lbl_cd4") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd4");	   
    				opener.sheetObjects[3].CellValue2(row2, "dcgo_sts_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "dcgo_sts_cd");
    				opener.sheetObjects[3].CellValue2(row2, "mrn_polut_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "mrn_polut_flg");
    				opener.sheetObjects[3].CellValue2(row2, "emer_cntc_phn_no_ctnt") = opener.sheetObjects[3].CellValue(arrRow[idx], "emer_cntc_phn_no_ctnt");
    				opener.sheetObjects[3].CellValue2(row2, "emer_cntc_pson_nm") = opener.sheetObjects[3].CellValue(arrRow[idx], "emer_cntc_pson_nm");
    				opener.sheetObjects[3].CellValue2(row2, "certi_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "certi_no");
    				opener.sheetObjects[3].CellValue2(row2, "cnee_dtl_desc") = opener.sheetObjects[3].CellValue(arrRow[idx], "cnee_dtl_desc");
    				opener.sheetObjects[3].CellValue2(row2, "net_explo_wgt") = opener.sheetObjects[3].CellValue(arrRow[idx], "net_explo_wgt");
    				opener.sheetObjects[3].CellValue2(row2, "rada_skd_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "rada_skd_no");	   
    				opener.sheetObjects[3].CellValue2(row2, "rada_amt") = opener.sheetObjects[3].CellValue(arrRow[idx], "rada_amt");
    				opener.sheetObjects[3].CellValue2(row2, "rada_ut_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "rada_ut_cd");
    				opener.sheetObjects[3].CellValue2(row2, "rada_trsp_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "rada_trsp_no");    				
    				opener.sheetObjects[3].CellValue2(row2, "in_imdg_pck_cd1") = opener.sheetObjects[3].CellValue(arrRow[idx], "in_imdg_pck_cd1"); 
    				opener.sheetObjects[3].CellValue2(row2, "in_imdg_pck_cd2") = opener.sheetObjects[3].CellValue(arrRow[idx], "in_imdg_pck_cd2"); 
    				opener.sheetObjects[3].CellValue2(row2, "out_imdg_pck_cd1") = opener.sheetObjects[3].CellValue(arrRow[idx], "out_imdg_pck_cd1"); 
    				opener.sheetObjects[3].CellValue2(row2, "out_imdg_pck_cd2") = opener.sheetObjects[3].CellValue(arrRow[idx], "out_imdg_pck_cd2"); 
    				opener.sheetObjects[3].CellValue2(row2, "in_imdg_pck_desc1") = opener.sheetObjects[3].CellValue(arrRow[idx], "in_imdg_pck_desc1"); 
    				opener.sheetObjects[3].CellValue2(row2, "in_imdg_pck_desc2") = opener.sheetObjects[3].CellValue(arrRow[idx], "in_imdg_pck_desc2"); 
    				opener.sheetObjects[3].CellValue2(row2, "out_imdg_pck_desc1") = opener.sheetObjects[3].CellValue(arrRow[idx], "out_imdg_pck_desc1"); 
    				opener.sheetObjects[3].CellValue2(row2, "out_imdg_pck_desc2") = opener.sheetObjects[3].CellValue(arrRow[idx], "out_imdg_pck_desc2"); 
    				opener.sheetObjects[3].CellValue2(row2, "in_imdg_pck_qty1") = opener.sheetObjects[3].CellValue(arrRow[idx], "in_imdg_pck_qty1"); 
    				opener.sheetObjects[3].CellValue2(row2, "in_imdg_pck_qty2") = opener.sheetObjects[3].CellValue(arrRow[idx], "in_imdg_pck_qty2");     				
    				opener.sheetObjects[3].CellValue2(row2, "out_imdg_pck_qty1") = opener.sheetObjects[3].CellValue(arrRow[idx], "out_imdg_pck_qty1"); 
    				opener.sheetObjects[3].CellValue2(row2, "out_imdg_pck_qty2") = opener.sheetObjects[3].CellValue(arrRow[idx], "out_imdg_pck_qty2"); 
    				opener.sheetObjects[3].CellValue2(row2, "max_in_pck_qty") = opener.sheetObjects[3].CellValue(arrRow[idx], "max_in_pck_qty"); 
    				opener.sheetObjects[3].CellValue2(row2, "max_in_pck_tp_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "max_in_pck_tp_cd"); 
    				opener.sheetObjects[3].CellValue2(row2, "hcdg_intmd_bc_rstr_desc") = opener.sheetObjects[3].CellValue(arrRow[idx], "hcdg_intmd_bc_rstr_desc"); 
    				opener.sheetObjects[3].CellValue2(row2, "hcdg_pck_rstr_desc") = opener.sheetObjects[3].CellValue(arrRow[idx], "hcdg_pck_rstr_desc"); 
    				opener.sheetObjects[3].CellValue2(row2, "hcdg_tnk_rstr_desc") = opener.sheetObjects[3].CellValue(arrRow[idx], "hcdg_tnk_rstr_desc"); 
    				opener.sheetObjects[3].CellValue2(row2, "ltd_qty") = opener.sheetObjects[3].CellValue(arrRow[idx], "ltd_qty");
    				opener.sheetObjects[3].CellValue2(row2, "stwg_temp_ctnt") = opener.sheetObjects[3].CellValue(arrRow[idx], "stwg_temp_ctnt");
    				opener.sheetObjects[3].CellValue2(row2, "hzd_ctnt") = opener.sheetObjects[3].CellValue(arrRow[idx], "hzd_ctnt");
    				
    				opener.sheetObjects[3].CellValue2(row2, "bkg_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "bkg_no");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_comp_grp_cd") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_comp_grp_cd");
    				opener.sheetObjects[3].CellValue2(row2, "imdg_un_no_seq") = opener.sheetObjects[3].CellValue(arrRow[idx], "imdg_un_no_seq");
    				opener.sheetObjects[3].CellValue2(row2, "clod_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "clod_flg");
    				opener.sheetObjects[3].CellValue2(row2, "cgo_lcl_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "cgo_lcl_flg");
    				opener.sheetObjects[3].CellValue2(row2, "ems_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "ems_no");
    				opener.sheetObjects[3].CellValue2(row2, "emer_rspn_gid_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "emer_rspn_gid_no");
    				opener.sheetObjects[3].CellValue2(row2, "emer_rspn_gid_chr_no") = opener.sheetObjects[3].CellValue(arrRow[idx], "emer_rspn_gid_chr_no");
    				opener.sheetObjects[3].CellValue2(row2, "ctrl_temp_ctnt") = opener.sheetObjects[3].CellValue(arrRow[idx], "ctrl_temp_ctnt");
    				opener.sheetObjects[3].CellValue2(row2, "emer_temp_ctnt") = opener.sheetObjects[3].CellValue(arrRow[idx], "emer_temp_ctnt");
    				opener.sheetObjects[3].CellValue2(row2, "dg_cntr_seq") = Number(dg_cntr_seq) + 1;
    				opener.sheetObjects[3].CellValue2(row2, "spcl_cntr_seq") = Number(dg_cntr_seq) + 1;
    				opener.sheetObjects[3].CellValue2(row2, "meas_qty") = opener.sheetObjects[3].CellValue(arrRow[idx], "meas_qty");
    				opener.sheetObjects[3].CellValue2(row2, "rc_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "rc_flg");
    				opener.sheetObjects[3].CellValue2(row2, "awk_cgo_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "awk_cgo_flg");
    				opener.sheetObjects[3].CellValue2(row2, "bb_cgo_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "bb_cgo_flg");
    				opener.sheetObjects[3].CellValue2(row2, "hcdg_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "hcdg_flg");
    				opener.sheetObjects[3].CellValue2(row2, "hcdg_dpnd_qty_flg") = opener.sheetObjects[3].CellValue(arrRow[idx], "hcdg_dpnd_qty_flg");    				
    				opener.sheetObjects[3].CellValue2(row2, "cntr_tpsz_cd") = opener.sheetObjects[1].CellValue(row1, "cntr_tpsz_cd");
    				opener.sheetObjects[3].CellValue2(row2, "cntr_vol_qty") = opener.sheetObjects[1].CellValue(row1, "cntr_vol_qty");
    				opener.sheetObjects[3].CellValue2(row2, "cntr_no") = "";  				
    				opener.sheetObjects[3].CellValue2(row2, "dg_cntr_seq") = opener.sheetObjects[1].CellValue(row1, "dg_cntr_seq");
    				opener.sheetObjects[3].CellValue2(row2, "spcl_cntr_seq") = opener.sheetObjects[1].CellValue(row1, "dg_cntr_seq");
    				opener.sheetObjects[3].CellValue2(row2, "spcl_rqst_flg") = "N"; 
    			}   			
    		} 
    		var cnt=0;  
	  	  	for (var i=1; i<=opener.sheetObjects[3].RowCount; i++){
	  	  	
		      	if(opener.sheetObjects[3].CellValue(i, "CntrChk") == "1" ){   			  
		      		 
			      	cnt++;		
			      	opener.sheetObjects[3].CellValue2(i, "cntr_cgo_seq") = cnt;	
			      	opener.sheetObjects[3].CellValue2(i, "spcl_cgo_seq") = cnt;	
		      	}
	      	} 
    		
    	}else if(radioChk == "2" && document.getElementById("chk2text").value != ""){
    		
    		var selRow = opener.sheetObjects[3].FindText("CntrChk", 1, 0, 2)
    		var chk = document.getElementById("chk2text").value;
    		
    		var cntr_name = "";
			var cntr_val = "";
			
			/*
    		for (var j=1; j<=opener.sheetObjects[4].RowCount; j++){	 									
				
				if(opener.sheetObjects[4].CellValue(j, "DelChk") == "0"){
					
					cntr_name += opener.sheetObjects[4].CellValue(j, "name")+"|";
					cntr_val += opener.sheetObjects[4].CellValue(j, "val")+"|";	 										
				} 									
			}
    		
			cntr_val = cntr_val.substr(0, cntr_val.length-1);	
			cntr_name = cntr_name.substr(0, cntr_name.length-1); 
    		*/
    		for (var i=1; i <= chk; i++){
    			
    			var ins = opener.sheetObjects[1].DataInsert(-1); 
    			
    			opener.sheetObjects[1].CellValue2(ins, "cntr_no") = ""; 
    			opener.sheetObjects[1].CellComboItem(ins, "cntr_no", " |"+cntr_name, " |"+cntr_val);
    			
    			opener.sheetObjects[1].CellValue2(ins, "cntr_tpsz_cd") = opener.document.getElementById("cntr_tpsz_cd").value; 
    			opener.sheetObjects[1].CellValue2(ins, "cntr_cgo_seq") = "1"; 
    			 
    			
    			var dg_cntr_seq = Number(opener.sheetObjects[1].CellValue(1, "dg_cntr_seq"));
    			var cntr_vol_qty = "";
				
    			for(var k=1; k <= opener.sheetObjects[1].RowCount; k++){
					
					if(dg_cntr_seq < Number(opener.sheetObjects[1].CellValue(k, "dg_cntr_seq"))){
						
						dg_cntr_seq = Number(opener.sheetObjects[1].CellValue(k, "dg_cntr_seq"));
						cntr_vol_qty = opener.sheetObjects[1].CellValue(k, "cntr_vol_qty");
					}
				}
    			
    			opener.sheetObjects[1].CellValue2(ins, "cntr_vol_qty") = cntr_vol_qty;
    			
				opener.sheetObjects[1].CellValue2(ins, "dg_cntr_seq") = Number(dg_cntr_seq)+1;
    			
    			var row = opener.sheetObjects[3].DataInsert(-1);
    			
    			var dcgo_seq = Number(opener.sheetObjects[3].CellValue(1, "dcgo_seq"));
				
				for(var m=1; m <= opener.sheetObjects[3].RowCount; m++){
					
					if(dcgo_seq < Number(opener.sheetObjects[3].CellValue(m, "dcgo_seq"))){
						
						dcgo_seq = Number(opener.sheetObjects[3].CellValue(m, "dcgo_seq"));
					}
				}
    			
				opener.sheetObjects[3].CellValue2(row, "dcgo_seq") = Number(dcgo_seq) + 1;
    			opener.sheetObjects[3].CellValue2(row, "dg_cntr_seq") = opener.sheetObjects[1].CellValue(ins, "dg_cntr_seq");
    			opener.sheetObjects[3].CellValue2(row, "spcl_cntr_seq") = opener.sheetObjects[1].CellValue(ins, "dg_cntr_seq");
    			opener.sheetObjects[3].CellValue2(row, "cntr_cgo_seq") = "1"; 
    			opener.sheetObjects[3].CellValue2(row, "spcl_cgo_seq") = "1"; 
   				opener.sheetObjects[3].CellValue2(row, "imdg_clss_cd") = opener.document.getElementById("imdg_clss_cd").value;    			
   				opener.sheetObjects[3].CellValue2(row, "imdg_comp_grp_cd") = opener.document.getElementById("imdg_comp_grp_cd").value;	
   				opener.sheetObjects[3].CellValue2(row, "imdg_un_no") = opener.document.getElementById("imdg_un_no").value;	
   				opener.sheetObjects[3].CellValue2(row, "grs_wgt") = opener.document.getElementById("grs_wgt").value;   				
   				opener.sheetObjects[3].CellValue2(row, "wgt_ut_cd") = "KGS";		
   				opener.sheetObjects[3].CellValue2(row, "net_wgt") = opener.document.getElementById("net_wgt").value;   				
   				opener.sheetObjects[3].CellValue2(row, "prp_shp_nm") = opener.document.getElementById("prp_shp_nm").value;	
   				opener.sheetObjects[3].CellValue2(row, "hzd_desc") = opener.document.getElementById("hzd_desc").value;		  
   				opener.sheetObjects[3].CellValue2(row, "flsh_pnt_cdo_temp") = opener.document.getElementById("flsh_pnt_cdo_temp").value;   				
   				opener.sheetObjects[3].CellValue2(row, "imdg_pck_grp_cd") = opener.document.getElementById("imdg_pck_grp_cd").value;	
   				opener.sheetObjects[3].CellValue2(row, "psa_no") = opener.document.getElementById("psa_no").value;		  
   				opener.sheetObjects[3].CellValue2(row, "imdg_lmt_qty_flg") = opener.document.getElementById("imdg_lmt_qty_flg").value;	
   				opener.sheetObjects[3].CellValue2(row, "imdg_expt_qty_flg") = opener.document.getElementById("imdg_expt_qty_flg").value;	
   				opener.sheetObjects[3].CellValue2(row, "hcdg_flag") = opener.document.getElementById("hcdg_flag").value;  
   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd1") = opener.document.getElementById("imdg_subs_rsk_lbl_cd1").value;	
   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd2") = opener.document.getElementById("imdg_subs_rsk_lbl_cd2").value;	
   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd3") = opener.document.getElementById("imdg_subs_rsk_lbl_cd3").value;	
   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd4") = opener.document.getElementById("imdg_subs_rsk_lbl_cd4").value;	
   				opener.sheetObjects[3].CellValue2(row, "dcgo_sts_cd") = opener.document.getElementById("dcgo_sts_cd").value;	
   				opener.sheetObjects[3].CellValue2(row, "mrn_polut_flg") = opener.document.getElementById("mrn_polut_flg").value;	
   				opener.sheetObjects[3].CellValue2(row, "emer_cntc_phn_no_ctnt") = opener.document.getElementById("emer_cntc_phn_no_ctnt").value;	
   				opener.sheetObjects[3].CellValue2(row, "emer_cntc_pson_nm") = opener.document.getElementById("emer_cntc_pson_nm").value;	
   				opener.sheetObjects[3].CellValue2(row, "certi_no") = opener.document.getElementById("certi_no").value;	
   				opener.sheetObjects[3].CellValue2(row, "cnee_dtl_desc") = opener.document.getElementById("cnee_dtl_desc").value;	
   				opener.sheetObjects[3].CellValue2(row, "net_explo_wgt") = opener.document.getElementById("net_explo_wgt").value;	
   				opener.sheetObjects[3].CellValue2(row, "rada_skd_no") = opener.document.getElementById("rada_skd_no").value;		   
   				opener.sheetObjects[3].CellValue2(row, "rada_amt") = opener.document.getElementById("rada_amt").value;	
   				opener.sheetObjects[3].CellValue2(row, "rada_ut_cd") = opener.document.getElementById("rada_ut_cd").value;	
   				opener.sheetObjects[3].CellValue2(row, "rada_trsp_no") = opener.document.getElementById("rada_trsp_no").value;	 
   				opener.sheetObjects[3].CellValue2(row, "bkg_no") = opener.document.getElementById("bkg_no").value; 
   				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_cd1") = opener.document.getElementById("in_imdg_pck_cd1").value; 
				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_cd2") = opener.document.getElementById("in_imdg_pck_cd2").value; 
				opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_cd1") = opener.document.getElementById("out_imdg_pck_cd1").value; 
				opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_cd2") = opener.document.getElementById("out_imdg_pck_cd2").value; 
				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_desc1") = opener.document.getElementById("in_imdg_pck_desc1").value; 
				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_desc2") = opener.document.getElementById("in_imdg_pck_desc2").value; 
				opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_desc1") = opener.document.getElementById("out_imdg_pck_desc1").value; 
				opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_desc2") = opener.document.getElementById("out_imdg_pck_desc2").value; 
				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_qty1") = opener.document.getElementById("in_imdg_pck_qty1").value; 
				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_qty2") = opener.document.getElementById("in_imdg_pck_qty2").value;				
				opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_qty1") = opener.document.getElementById("out_imdg_pck_qty1").value; 
				opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_qty2") = opener.document.getElementById("out_imdg_pck_qty2").value;  
				opener.sheetObjects[3].CellValue2(row, "max_in_pck_qty") = opener.document.getElementById("max_in_pck_qty").value;  
				opener.sheetObjects[3].CellValue2(row, "max_in_pck_tp_cd") = opener.document.getElementById("max_in_pck_tp_cd").value;  
				opener.sheetObjects[3].CellValue2(row, "hcdg_intmd_bc_rstr_desc") = opener.document.getElementById("hcdg_intmd_bc_rstr_desc").value;  
				opener.sheetObjects[3].CellValue2(row, "hcdg_pck_rstr_desc") = opener.document.getElementById("hcdg_pck_rstr_desc").value;  
				opener.sheetObjects[3].CellValue2(row, "hcdg_tnk_rstr_desc") = opener.document.getElementById("hcdg_tnk_rstr_desc").value;  
				opener.sheetObjects[3].CellValue2(row, "ltd_qty") = opener.document.getElementById("ltd_qty").value;
				opener.sheetObjects[3].CellValue2(row, "stwg_temp_ctnt") = opener.document.getElementById("stwg_temp_ctnt").value;
				opener.sheetObjects[3].CellValue2(row, "hzd_ctnt") = opener.document.getElementById("hzd_ctnt").text;
				
				opener.sheetObjects[3].CellValue2(row, "cntr_vol_qty") = opener.sheetObjects[1].CellValue(ins, "cntr_vol_qty"); 					
   				opener.sheetObjects[3].CellValue2(row, "cntr_no") = "";      				
				  				
    	  		opener.sheetObjects[3].CellValue2(row, "cntr_tpsz_cd") = opener.document.getElementById("cntr_tpsz_cd").value;     	  		
    	  		opener.sheetObjects[3].CellValue2(row, "CntrChk") = "1";
    	  		opener.sheetObjects[1].CellValue2(opener.sheetObjects[1].SelectRow, "spcl_cgo_apro_cd") = "";
    	  		
    	  		opener.sheetObjects[3].CellValue2(row, "clod_flg") = opener.document.getElementById("clod_flg").value; 
    	  		opener.sheetObjects[3].CellValue2(row, "rc_flg") = opener.document.getElementById("rc_flg").value; 
    	  		opener.sheetObjects[3].CellValue2(row, "awk_cgo_flg") = opener.document.getElementById("awk_cgo_flg").value; 
    	  		opener.sheetObjects[3].CellValue2(row, "bb_cgo_flg") = opener.document.getElementById("bb_cgo_flg").value; 
    	  		opener.sheetObjects[3].CellValue2(row, "hcdg_flg") = opener.document.getElementById("hcdg_flg").value; 
    	  		opener.sheetObjects[3].CellValue2(row, "meas_qty") = opener.document.getElementById("meas_qty").value; 
    	  		opener.sheetObjects[3].CellValue2(row, "hcdg_dpnd_qty_flg") = opener.document.getElementById("hcdg_dpnd_qty_flg").value;     	  		   	  		
    	  		opener.sheetObjects[3].CellValue2(row, "imdg_comp_grp_cd") = opener.document.getElementById("imdg_comp_grp_cd").value;
    	  		opener.sheetObjects[3].CellValue2(row, "imdg_un_no_seq") = opener.document.getElementById("imdg_un_no_seq").value;
    	  		opener.sheetObjects[3].CellValue2(row, "ems_no") = opener.document.getElementById("ems_no").value;
    	  		opener.sheetObjects[3].CellValue2(row, "emer_rspn_gid_no") = opener.document.getElementById("emer_rspn_gid_no").value;
    	  		opener.sheetObjects[3].CellValue2(row, "emer_rspn_gid_chr_no") = opener.document.getElementById("emer_rspn_gid_chr_no").value;
    	  		opener.sheetObjects[3].CellValue2(row, "ctrl_temp_ctnt") = opener.document.getElementById("ctrl_temp_ctnt").value;
    	  		opener.sheetObjects[3].CellValue2(row, "emer_temp_ctnt") = opener.document.getElementById("emer_temp_ctnt").value;   
    	  		opener.sheetObjects[3].CellValue2(row, "spcl_rqst_flg") = opener.document.getElementById("spcl_rqst_flg").value;
    	  		
    		}   		  		
    		
    	}
    	
    	else if(radioChk == "3"){
    		
    		var rowCnt = sheetObjects[0].RowCount;  
    		
    		var copyCnt = 0;
    		
    		for (var i=1; i <= rowCnt; i++){
    			
    			if(sheetObjects[0].CellValue(i, "copyChk")=="1" ){
	    			if(sheetObjects[0].CellValue(i, "copyCnt") > 0){
	    				copyCnt++;
	    				
	    				
	    				var row2 = 0;
	    				for(var k=1; k<=opener.sheetObjects[3].RowCount; k++){
	    					
	    					if(sheetObjects[0].CellValue(i, "dg_cntr_seq") == opener.sheetObjects[3].CellValue(k, "dg_cntr_seq") && sheetObjects[0].CellValue(i, "cntr_no") == opener.sheetObjects[3].CellValue(k, "cntr_no") && opener.sheetObjects[3].CellValue(k, "ibflag") != "D"){
	    						
	    						row2++;	    						
	    						
	    					}    	    	  			
    	    	  		}
	    				
	    				for (var j=1; j <= sheetObjects[0].CellValue(i, "copyCnt"); j++){
	    					
	    					var row = opener.sheetObjects[3].DataInsert(-1);
	    					
	    					var dcgo_seq = Number(opener.sheetObjects[3].CellValue(1, "dcgo_seq"));
	    					
	    					for(var m=1; m <= opener.sheetObjects[3].RowCount; m++){
	    						
	    						if(dcgo_seq < Number(opener.sheetObjects[3].CellValue(m, "dcgo_seq"))){
	    							
	    							dcgo_seq = Number(opener.sheetObjects[3].CellValue(m, "dcgo_seq"));
	    						}
	    					}
	    	    			
	    					opener.sheetObjects[3].CellValue2(row, "dcgo_seq") = Number(dcgo_seq) + 1;
	    					
	    					opener.sheetObjects[3].CellValue2(row, "imdg_clss_cd") = opener.document.getElementById("imdg_clss_cd").value;    			
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_comp_grp_cd") = opener.document.getElementById("imdg_comp_grp_cd").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_un_no") = opener.document.getElementById("imdg_un_no").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "grs_wgt") = opener.document.getElementById("grs_wgt").value;   				
	    	   				opener.sheetObjects[3].CellValue2(row, "wgt_ut_cd") = "KGS";   				
	    	   				opener.sheetObjects[3].CellValue2(row, "net_wgt") = opener.document.getElementById("net_wgt").value;   				
	    	   				opener.sheetObjects[3].CellValue2(row, "prp_shp_nm") = opener.document.getElementById("prp_shp_nm").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "hzd_desc") = opener.document.getElementById("hzd_desc").value;		  
	    	   				opener.sheetObjects[3].CellValue2(row, "flsh_pnt_cdo_temp") = opener.document.getElementById("flsh_pnt_cdo_temp").value;   				
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_pck_grp_cd") = opener.document.getElementById("imdg_pck_grp_cd").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "psa_no") = opener.document.getElementById("psa_no").value;		  
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_lmt_qty_flg") = opener.document.getElementById("imdg_lmt_qty_flg").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_expt_qty_flg") = opener.document.getElementById("imdg_expt_qty_flg").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "hcdg_flag") = opener.document.getElementById("hcdg_flag").value;   
	    	   				
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd1") = opener.document.getElementById("imdg_subs_rsk_lbl_cd1").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd2") = opener.document.getElementById("imdg_subs_rsk_lbl_cd2").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd3") = opener.document.getElementById("imdg_subs_rsk_lbl_cd3").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd4") = opener.document.getElementById("imdg_subs_rsk_lbl_cd4").value;	
	    	   				
	    	   				opener.sheetObjects[3].CellValue2(row, "dcgo_sts_cd") = opener.document.getElementById("dcgo_sts_cd").value;
	    	   				
	    	   				opener.sheetObjects[3].CellValue2(row, "mrn_polut_flg") = opener.document.getElementById("mrn_polut_flg").value;	
	    	   				
	    	   				opener.sheetObjects[3].CellValue2(row, "emer_cntc_phn_no_ctnt") = opener.document.getElementById("emer_cntc_phn_no_ctnt").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "emer_cntc_pson_nm") = opener.document.getElementById("emer_cntc_pson_nm").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "certi_no") = opener.document.getElementById("certi_no").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "cnee_dtl_desc") = opener.document.getElementById("cnee_dtl_desc").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "net_explo_wgt") = opener.document.getElementById("net_explo_wgt").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "rada_skd_no") = opener.document.getElementById("rada_skd_no").value;		   
	    	   				opener.sheetObjects[3].CellValue2(row, "rada_amt") = opener.document.getElementById("rada_amt").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "rada_ut_cd") = opener.document.getElementById("rada_ut_cd").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "rada_trsp_no") = opener.document.getElementById("rada_trsp_no").value;	 
	    	   				opener.sheetObjects[3].CellValue2(row, "bkg_no") = opener.document.getElementById("bkg_no").value;	
	    	   				opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_cd1") = opener.document.getElementById("in_imdg_pck_cd1").value; 
	    					opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_cd2") = opener.document.getElementById("in_imdg_pck_cd2").value; 
	    					opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_cd1") = opener.document.getElementById("out_imdg_pck_cd1").value; 
	    					opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_cd2") = opener.document.getElementById("out_imdg_pck_cd2").value; 
	    					opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_desc1") = opener.document.getElementById("in_imdg_pck_desc1").value; 
	    					opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_desc2") = opener.document.getElementById("in_imdg_pck_desc2").value; 
	    					opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_desc1") = opener.document.getElementById("out_imdg_pck_desc1").value; 
	    					opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_desc2") = opener.document.getElementById("out_imdg_pck_desc2").value; 
	    					opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_qty1") = opener.document.getElementById("in_imdg_pck_qty1").value; 
	    					opener.sheetObjects[3].CellValue2(row, "in_imdg_pck_qty2") = opener.document.getElementById("in_imdg_pck_qty2").value;     					
	    					opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_qty1") = opener.document.getElementById("out_imdg_pck_qty1").value; 
	    					opener.sheetObjects[3].CellValue2(row, "out_imdg_pck_qty2") = opener.document.getElementById("out_imdg_pck_qty2").value;  
	    					opener.sheetObjects[3].CellValue2(row, "max_in_pck_qty") = opener.document.getElementById("max_in_pck_qty").value;  
	    					opener.sheetObjects[3].CellValue2(row, "max_in_pck_tp_cd") = opener.document.getElementById("max_in_pck_tp_cd").value;  
	    					opener.sheetObjects[3].CellValue2(row, "hcdg_intmd_bc_rstr_desc") = opener.document.getElementById("hcdg_intmd_bc_rstr_desc").value;  
	    					opener.sheetObjects[3].CellValue2(row, "hcdg_pck_rstr_desc") = opener.document.getElementById("hcdg_pck_rstr_desc").value;  
	    					opener.sheetObjects[3].CellValue2(row, "hcdg_tnk_rstr_desc") = opener.document.getElementById("hcdg_tnk_rstr_desc").value;  
	    					opener.sheetObjects[3].CellValue2(row, "ltd_qty") = opener.document.getElementById("ltd_qty").value;
	    					opener.sheetObjects[3].CellValue2(row, "stwg_temp_ctnt") = opener.document.getElementById("stwg_temp_ctnt").value;
	    					opener.sheetObjects[3].CellValue2(row, "hzd_ctnt") = opener.document.getElementById("hzd_ctnt").text;
	    					opener.sheetObjects[3].CellValue2(row, "cntr_vol_qty") = sheetObjects[0].CellValue(i, "cntr_vol_qty"); 	    					
	    	   				opener.sheetObjects[3].CellValue2(row, "cntr_no") = sheetObjects[0].CellValue(i, "cntr_no"); 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd"); 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "dg_cntr_seq") = sheetObjects[0].CellValue(i, "dg_cntr_seq"); 	
	    	    	  		opener.sheetObjects[3].CellValue2(row, "spcl_cntr_seq") = sheetObjects[0].CellValue(i, "dg_cntr_seq"); 	
	    	    	  		opener.sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "";  
	    	    	  		opener.sheetObjects[3].CellValue2(row, "clod_flg") = opener.document.getElementById("clod_flg").value; 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "rc_flg") = opener.document.getElementById("rc_flg").value; 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "awk_cgo_flg") = opener.document.getElementById("awk_cgo_flg").value; 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "bb_cgo_flg") = opener.document.getElementById("bb_cgo_flg").value; 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "hcdg_flg") = opener.document.getElementById("hcdg_flg").value; 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "meas_qty") = opener.document.getElementById("meas_qty").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "hcdg_dpnd_qty_flg") = opener.document.getElementById("hcdg_dpnd_qty_flg").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "imdg_comp_grp_cd") = opener.document.getElementById("imdg_comp_grp_cd").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "imdg_un_no_seq") = opener.document.getElementById("imdg_un_no_seq").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "ems_no") = opener.document.getElementById("ems_no").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "emer_rspn_gid_no") = opener.document.getElementById("emer_rspn_gid_no").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "emer_rspn_gid_chr_no") = opener.document.getElementById("emer_rspn_gid_chr_no").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "ctrl_temp_ctnt") = opener.document.getElementById("ctrl_temp_ctnt").value;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "emer_temp_ctnt") = opener.document.getElementById("emer_temp_ctnt").value; 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "spcl_rqst_flg") = opener.document.getElementById("spcl_rqst_flg").value;    	    	  		
	    	    	  		  			
	    	    	  		row2++;	    	 
	    	    	  		opener.sheetObjects[3].CellValue2(row, "cntr_cgo_seq") = row2;
	    	    	  		opener.sheetObjects[3].CellValue2(row, "spcl_cgo_seq") = row2;    	    	  		
	    				} 
	    				
	    				
	    				
	    			}else{
	    				//ComShowMessage("Copy할 수량이 입력되지 않았소.")
	    				ComShowCodeMessage("BKG95008", "Copy Number");
	    				return;
	    			}
    			}
    		}
    		
    		if(copyCnt < 1){    			
    			ComShowMessage(ComGetMsg("BKG00567"));	
    			return;
    		}  
    		
    	}else if(radioChk == "4" && document.getElementById("chk2text3").value != ""){
    		var fromBkgNo = document.getElementById("chk2text3").value;
    		ComSetObjValue(document.form.from_bkg_no, fromBkgNo);
    		doActionIBSheet(sheetObjects[1], document.form, SEARCH03);	  		
    		
    		if( sheetObjects[1].SearchRows > 0){
	    		var row = sheetObjects[1].HeaderRows ;
	    		var prow = opener.sheetObjects[3].SelectRow; 
	    		
	    		//opener.sheetObjects[3].CellValue2(row, "dcgo_seq") = Number(dcgo_seq) + 1;
				//opener.sheetObjects[3].CellValue2(row, "dg_cntr_seq") = opener.sheetObjects[1].CellValue(ins, "dg_cntr_seq");
				//opener.sheetObjects[3].CellValue2(row, "spcl_cntr_seq") = opener.sheetObjects[1].CellValue(ins, "dg_cntr_seq");
				//opener.sheetObjects[3].CellValue2(row, "cntr_cgo_seq") = "1"; 
				//opener.sheetObjects[3].CellValue2(row, "spcl_cgo_seq") = "1"; 
	    		
	    		opener.sheetObjects[3].CellValue(prow, "imdg_clss_cd") 	 = sheetObjects[1].CellValue(row, "imdg_clss_cd");     			
	    		opener.sheetObjects[3].CellValue(prow, "imdg_comp_grp_cd") =	sheetObjects[1].CellValue(row, "imdg_comp_grp_cd");	
	    		opener.sheetObjects[3].CellValue(prow, "imdg_un_no")		 = sheetObjects[1].CellValue(row, "imdg_un_no");
	    		opener.sheetObjects[3].CellValue(prow, "grs_wgt")		 =	sheetObjects[1].CellValue(row, "grs_wgt"); 				
				//	opener.sheetObjects[3].CellValue2(row, "wgt_ut_cd") = "KGS";		
	    		opener.sheetObjects[3].CellValue(prow, "net_wgt")	= sheetObjects[1].CellValue(row, "net_wgt");   				
	    		opener.sheetObjects[3].CellValue(prow, "prp_shp_nm")	= 	sheetObjects[1].CellValue(row, "prp_shp_nm");	
	    		opener.sheetObjects[3].CellValue(prow, "hzd_desc")	= 	sheetObjects[1].CellValue(row, "hzd_desc");		  
	    		
	    		opener.sheetObjects[3].CellValue(prow, "flsh_pnt_cdo_temp")	= 	sheetObjects[1].CellValue(row, "flsh_pnt_cdo_temp");  
	    		
	    		opener.sheetObjects[3].CellValue(prow, "imdg_pck_grp_cd") =	sheetObjects[1].CellValue(row, "imdg_pck_grp_cd");
	    		opener.sheetObjects[3].CellValue(prow, "psa_no") = 	sheetObjects[1].CellValue(row, "psa_no");	  
	    		opener.sheetObjects[3].CellValue(prow, "imdg_lmt_qty_flg")	= 	sheetObjects[1].CellValue(row, "imdg_lmt_qty_flg");
	    		opener.sheetObjects[3].CellValue(prow, "imdg_expt_qty_flg")	= 	sheetObjects[1].CellValue(row, "imdg_expt_qty_flg");
	    		//opener.document.getElementById("hcdg_flag").value	= 	sheetObjects[1].CellValue(row, "hcdg_flag");
	    		opener.sheetObjects[3].CellValue(prow, "imdg_subs_rsk_lbl_cd1")	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd1");	
	    		opener.sheetObjects[3].CellValue(prow, "imdg_subs_rsk_lbl_cd2")	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd2");	
	    		opener.sheetObjects[3].CellValue(prow, "imdg_subs_rsk_lbl_cd3")	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd3");	
	    		opener.sheetObjects[3].CellValue(prow, "imdg_subs_rsk_lbl_cd4")	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd4");
	    		opener.sheetObjects[3].CellValue(prow, "dcgo_sts_cd") =	sheetObjects[1].CellValue(row, "dcgo_sts_cd");	
	    		opener.sheetObjects[3].CellValue(prow, "mrn_polut_flg")	= 	sheetObjects[1].CellValue(row, "mrn_polut_flg");	
	    		opener.sheetObjects[3].CellValue(prow, "emer_cntc_phn_no_ctnt")	= 	sheetObjects[1].CellValue(row, "emer_cntc_phn_no_ctnt");	
	    		opener.sheetObjects[3].CellValue(prow, "emer_cntc_pson_nm")	= 	sheetObjects[1].CellValue(row, "emer_cntc_pson_nm");	
	    		opener.sheetObjects[3].CellValue(prow, "certi_no")		= sheetObjects[1].CellValue(row, "certi_no");	
	    		opener.sheetObjects[3].CellValue(prow, "cnee_dtl_desc")	= 	sheetObjects[1].CellValue(row, "cnee_dtl_desc");	
	    		opener.sheetObjects[3].CellValue(prow, "net_explo_wgt")	= 	sheetObjects[1].CellValue(row, "net_explo_wgt");	
	    		opener.sheetObjects[3].CellValue(prow, "rada_skd_no")	= sheetObjects[1].CellValue(row, "rada_skd_no");		   
	    		opener.sheetObjects[3].CellValue(prow, "rada_amt")	= 	sheetObjects[1].CellValue(row, "rada_amt");
	    		opener.sheetObjects[3].CellValue(prow, "rada_ut_cd")	= 	sheetObjects[1].CellValue(row, "rada_ut_cd");
	    		opener.sheetObjects[3].CellValue(prow, "rada_trsp_no")		= sheetObjects[1].CellValue(row, "rada_trsp_no");
	    		//opener.document.getElementById("bkg_no").value		= sheetObjects[1].CellValue(row, "bkg_no"); 
	    		opener.sheetObjects[3].CellValue(prow, "in_imdg_pck_cd1")		= sheetObjects[1].CellValue(row, "in_imdg_pck_cd1"); 
	    		
	    		opener.sheetObjects[3].CellValue(prow, "in_imdg_pck_cd2")   = sheetObjects[1].CellValue(row, "in_imdg_pck_cd2");
	    		opener.sheetObjects[3].CellValue(prow, "out_imdg_pck_cd1")  = sheetObjects[1].CellValue(row, "out_imdg_pck_cd1");
	    		opener.sheetObjects[3].CellValue(prow, "out_imdg_pck_cd2")  = sheetObjects[1].CellValue(row, "out_imdg_pck_cd2");
	    		opener.sheetObjects[3].CellValue(prow, "in_imdg_pck_desc1") = sheetObjects[1].CellValue(row, "in_imdg_pck_desc1");
	    		opener.sheetObjects[3].CellValue(prow, "in_imdg_pck_desc2") = sheetObjects[1].CellValue(row, "in_imdg_pck_desc2");
	    		
	    		opener.sheetObjects[3].CellValue(prow, "out_imdg_pck_desc1") = sheetObjects[1].CellValue(row, "out_imdg_pck_desc1");
	    		opener.sheetObjects[3].CellValue(prow, "out_imdg_pck_desc2") = sheetObjects[1].CellValue(row, "out_imdg_pck_desc2"); 
	    		opener.sheetObjects[3].CellValue(prow, "in_imdg_pck_qty1") = sheetObjects[1].CellValue(row, "in_imdg_pck_qty1"); 
	    		opener.sheetObjects[3].CellValue(prow, "in_imdg_pck_qty2")= sheetObjects[1].CellValue(row, "in_imdg_pck_qty2");			
	    		opener.sheetObjects[3].CellValue(prow, "out_imdg_pck_qty1") = sheetObjects[1].CellValue(row, "out_imdg_pck_qty1");
	    		opener.sheetObjects[3].CellValue(prow, "out_imdg_pck_qty2") = sheetObjects[1].CellValue(row, "out_imdg_pck_qty2"); 
	    		opener.sheetObjects[3].CellValue(prow, "max_in_pck_qty") = sheetObjects[1].CellValue(row, "max_in_pck_qty");  
	    		opener.sheetObjects[3].CellValue(prow, "max_in_pck_tp_cd") = sheetObjects[1].CellValue(row, "max_in_pck_tp_cd"); 
	    		opener.sheetObjects[3].CellValue(prow, "hcdg_intmd_bc_rstr_desc") = sheetObjects[1].CellValue(row, "hcdg_intmd_bc_rstr_desc");
	    		opener.sheetObjects[3].CellValue(prow, "hcdg_pck_rstr_desc") = sheetObjects[1].CellValue(row, "hcdg_pck_rstr_desc");
	    		opener.sheetObjects[3].CellValue(prow, "hcdg_tnk_rstr_desc") = sheetObjects[1].CellValue(row, "hcdg_tnk_rstr_desc");  
	    		opener.sheetObjects[3].CellValue(prow, "ltd_qty") = sheetObjects[1].CellValue(row, "ltd_qty");
	    		opener.sheetObjects[3].CellValue(prow, "stwg_temp_ctnt") = sheetObjects[1].CellValue(row, "stwg_temp_ctnt");
	    		opener.sheetObjects[3].CellValue(prow, "hzd_ctnt") = sheetObjects[1].CellValue(row, "hzd_ctnt");
				
	    		//opener.sheetObjects[1].CellValue(ins, "cntr_vol_qty") = sheetObjects[1].CellValue(row, "cntr_vol_qty"); 					
				//	sheetObjects[1].CellValue(row, "cntr_no") = "";      				
				  				
	    		opener.sheetObjects[3].CellValue(prow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");     	  		
		  		//sheetObjects[1].CellValue(row, "CntrChk") = "1";
		  		//opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "spcl_cgo_apro_cd") = "";
		  		// 히든 값
	    		opener.sheetObjects[3].CellValue(prow, "clod_flg") = sheetObjects[1].CellValue(row, "clod_flg"); 
	    		opener.sheetObjects[3].CellValue(prow, "rc_flg") = sheetObjects[1].CellValue(row, "rc_flg"); 
	    		opener.sheetObjects[3].CellValue(prow, "awk_cgo_flg") = sheetObjects[1].CellValue(row, "awk_cgo_flg"); 
	    		opener.sheetObjects[3].CellValue(prow, "bb_cgo_flg") = sheetObjects[1].CellValue(row, "bb_cgo_flg"); 
	    		opener.sheetObjects[3].CellValue(prow, "hcdg_flg") = sheetObjects[1].CellValue(row, "hcdg_flg"); 
	    		opener.sheetObjects[3].CellValue(prow, "meas_qty") = sheetObjects[1].CellValue(row, "meas_qty"); 
	    		opener.sheetObjects[3].CellValue(prow, "hcdg_dpnd_qty_flg") = sheetObjects[1].CellValue(row, "hcdg_dpnd_qty_flg");     	  		   	  		
	    		opener.sheetObjects[3].CellValue(prow, "imdg_comp_grp_cd") = sheetObjects[1].CellValue(row, "imdg_comp_grp_cd");
	    		opener.sheetObjects[3].CellValue(prow, "imdg_un_no_seq") = sheetObjects[1].CellValue(row, "imdg_un_no_seq");
	    		opener.sheetObjects[3].CellValue(prow, "ems_no") = sheetObjects[1].CellValue(row, "ems_no");
	    		opener.sheetObjects[3].CellValue(prow, "emer_rspn_gid_no") = sheetObjects[1].CellValue(row, "emer_rspn_gid_no");
	    		opener.sheetObjects[3].CellValue(prow, "emer_rspn_gid_chr_no") = sheetObjects[1].CellValue(row, "emer_rspn_gid_chr_no");
	    		opener.sheetObjects[3].CellValue(prow, "ctrl_temp_ctnt") = sheetObjects[1].CellValue(row, "ctrl_temp_ctnt");
	    		opener.sheetObjects[3].CellValue(prow, "emer_temp_ctnt") = sheetObjects[1].CellValue(row, "emer_temp_ctnt");   
	    		opener.sheetObjects[3].CellValue(prow, "spcl_rqst_flg") = sheetObjects[1].CellValue(row, "spcl_rqst_flg");
	    		
	    		opener.sheetObjects[3].CellValue(prow, "dcgo_rqst_grp_eml1") = sheetObjects[1].CellValue(row, "dcgo_rqst_grp_eml1");
	    		opener.sheetObjects[3].CellValue(prow, "dcgo_rqst_grp_eml2") = sheetObjects[1].CellValue(row, "dcgo_rqst_grp_eml2");
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    		opener.document.getElementById("imdg_clss_cd").value 	 = sheetObjects[1].CellValue(row, "imdg_clss_cd");     			
	    		opener.document.getElementById("imdg_comp_grp_cd").value =	sheetObjects[1].CellValue(row, "imdg_comp_grp_cd");	
	    		opener.document.getElementById("imdg_un_no").value		 = sheetObjects[1].CellValue(row, "imdg_un_no");
	    		opener.document.getElementById("grs_wgt").value			 =	sheetObjects[1].CellValue(row, "grs_wgt"); 				
				//	opener.sheetObjects[3].CellValue2(row, "wgt_ut_cd") = "KGS";		
	    		opener.document.getElementById("net_wgt").value	= sheetObjects[1].CellValue(row, "net_wgt");   				
	    		opener.document.getElementById("prp_shp_nm").value	= 	sheetObjects[1].CellValue(row, "prp_shp_nm");	
	    		opener.document.getElementById("hzd_desc").value	= 	sheetObjects[1].CellValue(row, "hzd_desc");		  
	    		
	    		opener.document.getElementById("flsh_pnt_cdo_temp").value	= 	sheetObjects[1].CellValue(row, "flsh_pnt_cdo_temp");  
	    		
	    		opener.document.getElementById("imdg_pck_grp_cd").value =	sheetObjects[1].CellValue(row, "imdg_pck_grp_cd");
	    		opener.document.getElementById("psa_no").value = 	sheetObjects[1].CellValue(row, "psa_no");	  
	    		opener.document.getElementById("imdg_lmt_qty_flg").value	= 	sheetObjects[1].CellValue(row, "imdg_lmt_qty_flg");
	    		opener.document.getElementById("imdg_expt_qty_flg").value	= 	sheetObjects[1].CellValue(row, "imdg_expt_qty_flg");
	    		//opener.document.getElementById("hcdg_flag").value	= 	sheetObjects[1].CellValue(row, "hcdg_flag");
	    		opener.document.getElementById("imdg_subs_rsk_lbl_cd1").value	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd1");	
	    		opener.document.getElementById("imdg_subs_rsk_lbl_cd2").value	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd2");	
	    		opener.document.getElementById("imdg_subs_rsk_lbl_cd3").value	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd3");	
	    		opener.document.getElementById("imdg_subs_rsk_lbl_cd4").value	= 	sheetObjects[1].CellValue(row, "imdg_subs_rsk_lbl_cd4");
	    		opener.document.getElementById("dcgo_sts_cd").value =	sheetObjects[1].CellValue(row, "dcgo_sts_cd");	
	    		opener.document.getElementById("mrn_polut_flg").value	= 	sheetObjects[1].CellValue(row, "mrn_polut_flg");	
	    		opener.document.getElementById("emer_cntc_phn_no_ctnt").value	= 	sheetObjects[1].CellValue(row, "emer_cntc_phn_no_ctnt");	
	    		opener.document.getElementById("emer_cntc_pson_nm").value	= 	sheetObjects[1].CellValue(row, "emer_cntc_pson_nm");	
	    		opener.document.getElementById("certi_no").value		= sheetObjects[1].CellValue(row, "certi_no");	
	    		opener.document.getElementById("cnee_dtl_desc").value	= 	sheetObjects[1].CellValue(row, "cnee_dtl_desc");	
	    		opener.document.getElementById("net_explo_wgt").value	= 	sheetObjects[1].CellValue(row, "net_explo_wgt");	
	    		opener.document.getElementById("rada_skd_no").value		= sheetObjects[1].CellValue(row, "rada_skd_no");		   
	    		opener.document.getElementById("rada_amt").value	= 	sheetObjects[1].CellValue(row, "rada_amt");
	    		opener.document.getElementById("rada_ut_cd").value	= 	sheetObjects[1].CellValue(row, "rada_ut_cd");
	    		opener.document.getElementById("rada_trsp_no").value		= sheetObjects[1].CellValue(row, "rada_trsp_no");
	    		//opener.document.getElementById("bkg_no").value		= sheetObjects[1].CellValue(row, "bkg_no"); 
	    		opener.document.getElementById("in_imdg_pck_cd1").value		= sheetObjects[1].CellValue(row, "in_imdg_pck_cd1"); 
	    		
	    		opener.document.getElementById("in_imdg_pck_cd2").value   = sheetObjects[1].CellValue(row, "in_imdg_pck_cd2");
	    		opener.document.getElementById("out_imdg_pck_cd1").value  = sheetObjects[1].CellValue(row, "out_imdg_pck_cd1");
	    		opener.document.getElementById("out_imdg_pck_cd2").value  = sheetObjects[1].CellValue(row, "out_imdg_pck_cd2");
	    		opener.document.getElementById("in_imdg_pck_desc1").value = sheetObjects[1].CellValue(row, "in_imdg_pck_desc1");
	    		opener.document.getElementById("in_imdg_pck_desc2").value = sheetObjects[1].CellValue(row, "in_imdg_pck_desc2");
	    		
	    		opener.document.getElementById("out_imdg_pck_desc1").value = sheetObjects[1].CellValue(row, "out_imdg_pck_desc1");
	    		opener.document.getElementById("out_imdg_pck_desc2").value = sheetObjects[1].CellValue(row, "out_imdg_pck_desc2"); 
	    		opener.document.getElementById("in_imdg_pck_qty1").value = sheetObjects[1].CellValue(row, "in_imdg_pck_qty1"); 
	    		opener.document.getElementById("in_imdg_pck_qty2").value = sheetObjects[1].CellValue(row, "in_imdg_pck_qty2");			
	    		opener.document.getElementById("out_imdg_pck_qty1").value = sheetObjects[1].CellValue(row, "out_imdg_pck_qty1");
	    		opener.document.getElementById("out_imdg_pck_qty2").value = sheetObjects[1].CellValue(row, "out_imdg_pck_qty2"); 
	    		opener.document.getElementById("max_in_pck_qty").value = sheetObjects[1].CellValue(row, "max_in_pck_qty");  
	    		opener.document.getElementById("max_in_pck_tp_cd").value = sheetObjects[1].CellValue(row, "max_in_pck_tp_cd"); 
	    		opener.document.getElementById("hcdg_intmd_bc_rstr_desc").value = sheetObjects[1].CellValue(row, "hcdg_intmd_bc_rstr_desc");
	    		opener.document.getElementById("hcdg_pck_rstr_desc").value = sheetObjects[1].CellValue(row, "hcdg_pck_rstr_desc");
	    		opener.document.getElementById("hcdg_tnk_rstr_desc").value = sheetObjects[1].CellValue(row, "hcdg_tnk_rstr_desc");  
	    		opener.document.getElementById("ltd_qty").value = sheetObjects[1].CellValue(row, "ltd_qty");
	    		opener.document.getElementById("stwg_temp_ctnt").value = sheetObjects[1].CellValue(row, "stwg_temp_ctnt");
	    		opener.document.getElementById("hzd_ctnt").text = sheetObjects[1].CellValue(row, "hzd_ctnt");
					
	    		opener.document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");     	  		
		  	
	    		opener.document.getElementById("clod_flg").value = sheetObjects[1].CellValue(row, "clod_flg"); 
	    		opener.document.getElementById("rc_flg").value = sheetObjects[1].CellValue(row, "rc_flg"); 
	    		opener.document.getElementById("awk_cgo_flg").value = sheetObjects[1].CellValue(row, "awk_cgo_flg"); 
	    		opener.document.getElementById("bb_cgo_flg").value = sheetObjects[1].CellValue(row, "bb_cgo_flg"); 
	    		opener.document.getElementById("hcdg_flg").value = sheetObjects[1].CellValue(row, "hcdg_flg"); 
	    		opener.document.getElementById("meas_qty").value = sheetObjects[1].CellValue(row, "meas_qty"); 
	    		opener.document.getElementById("hcdg_dpnd_qty_flg").value = sheetObjects[1].CellValue(row, "hcdg_dpnd_qty_flg");     	  		   	  		
	    		opener.document.getElementById("imdg_comp_grp_cd").value = sheetObjects[1].CellValue(row, "imdg_comp_grp_cd");
	    		opener.document.getElementById("imdg_un_no_seq").value = sheetObjects[1].CellValue(row, "imdg_un_no_seq");
	    		opener.document.getElementById("ems_no").value = sheetObjects[1].CellValue(row, "ems_no");
	    		opener.document.getElementById("emer_rspn_gid_no").value = sheetObjects[1].CellValue(row, "emer_rspn_gid_no");
	    		opener.document.getElementById("emer_rspn_gid_chr_no").value = sheetObjects[1].CellValue(row, "emer_rspn_gid_chr_no");
	    		opener.document.getElementById("ctrl_temp_ctnt").value = sheetObjects[1].CellValue(row, "ctrl_temp_ctnt");
	    		opener.document.getElementById("emer_temp_ctnt").value = sheetObjects[1].CellValue(row, "emer_temp_ctnt");   
	    		opener.document.getElementById("spcl_rqst_flg").value = sheetObjects[1].CellValue(row, "spcl_rqst_flg");
	    		
	    		opener.document.getElementById("dcgo_rqst_grp_eml1").value = sheetObjects[1].CellValue(row, "dcgo_rqst_grp_eml1");
	    		opener.document.getElementById("dcgo_rqst_grp_eml2").value = sheetObjects[1].CellValue(row, "dcgo_rqst_grp_eml2");
	    		
	    		window.close();
    		}else{
    			//No data found.
    			ComShowMessage(ComGetMsg("BKG00889"));	
    		}
    		
    	}else{
    		//ComShowMessage("Copy할 수량이 입력되지 않았소.") 
    		ComShowCodeMessage("BKG95008", "Copy Number");
    		return;
    	}
   
    	    	
    	window.close();
    	
    	opener.cntrChk();    	  
		opener.htmlSheetSync(); 
    	
    	
    }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 200;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = " ||Seq|Container No.|No. of Copy";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     					InitDataProperty(0, cnt++ , dtDummyCheck,	0,		daCenter,		true,		"copyChk",		false,			"",      dfNone,			0,		true,		true);
 										InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag",		false,			"",      dfNone,			0,		true,		true);
 										InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"seq",		false,			"",      dfNone,			0,		true,		true);
 										InitDataProperty(0, cnt++ , dtData,					170,	daCenter,		true,		"cntr_no",		false,			"",      dfNone,			0,		true,		true);
 										InitDataProperty(0, cnt++ , dtData,					100,		daCenter,		true,		"copyCnt",		false,			"",      dfNullInteger,			0,		true,		true);
 										
 										InitDataProperty(0, cnt++ , dtHidden,					50,		daCenter,		true,		"cntr_tpsz_cd",		false,			"",      dfNone,			0,		true,		true);
 										InitDataProperty(0, cnt++ , dtHidden,					170,	daCenter,		true,		"dg_cntr_seq",		false,			"",      dfNone,			0,		true,		true);
 										InitDataProperty(0, cnt++ , dtHidden,					170,	daCenter,		true,		"cntr_vol_qty",		false,			"",      dfNone,			0,		true,		true);
 										 																				
                }
                 break;
             case 2: //sheet2 init
     			with (sheetObj) {
     				// 높이 설정
     				style.height = 0;
     				//전체 너비 설정
     				SheetWidth = mainTable.clientWidth;
     				//Host정보 설정[필수][HostIp, Port, PagePath]
     				if (location.hostname != "")
     					InitHostInfo(location.hostname, location.port, page_path);
     				//전체Merge 종류 [선택, Default msNone]
     				MergeSheet = msHeaderOnly;
     				//전체Edit 허용 여부 [선택, Default false]
     				Editable = true;
     				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     				InitRowInfo(1, 1, 4, 100);
     				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     				InitColumnInfo(108, 0, 0, true);
     				// 해더에서 처리할 수 있는 각종 기능을 설정한다
     				InitHeadMode(false, true, false, true, false, false)
     				var HeadTitle1 = "|||Seq|Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no" + "|dg_cgo_seq|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|spcl_provi_no|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm"
     						+ "|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3" + "|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_mrn_polut_cd|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|dcgo_rqst_grp_eml1|dcgo_rqst_grp_eml2|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt"
     						+ "|rada_ut_cd|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk|bkg_cntr_seq|in_imdg_pck_cd1|in_imdg_pck_cd2|out_imdg_pck_cd1" + "|out_imdg_pck_cd2|||in_imdg_pck_desc1|in_imdg_pck_desc2|||out_imdg_pck_desc1|out_imdg_pck_desc2|in_imdg_pck_qty1|in_imdg_pck_qty2|||out_imdg_pck_qty1|out_imdg_pck_qty2|max_in_pck_qty"
     						+ "|max_in_pck_tp_cd|hcdg_intmd_bc_rstr_desc|hcdg_pck_rstr_desc|hcdg_tnk_rstr_desc|ltd_qty|ems_no|emer_rspn_gid_no|emer_rspn_gid_chr_no|ctrl_temp_ctnt|emer_temp_ctnt"
     						+ "|dcgo_seq|modifyaproflg|dg_cntr_seq|meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_flg|hcdg_qty|hcdg_dpnd_qty_flg|imdg_spcl_provi_no|imdg_crr_rstr_expt_cd|spcl_rqst_flg|spcl_rqst_desc|imdg_expt_qty_cd|crr_cd|por_cd|del_cd|rcv_term_cd|de_term_cd|spcl_cgo_seq|spcl_cntr_seq|apro_cd|||hzd_ctnt|stwg_temp_ctnt|dflt_segr_grp_nm|grs_capa_qty";
     				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     				InitHeadRow(0, HeadTitle1, true);
     				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "CntrChk");
     				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "DelChk");
     				InitDataProperty(0, cnt++, dtStatus, 20, daCenter, false, "ibflag");
     				InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
     				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no", false, "", dfNone, 0, true, true);
     				InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
     				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_vol_qty", false, "", dfFloat, 2, true, true);
     				InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "spcl_cgo_apro_cd", false, "", dfNone, 0, false, false);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "", false, "", dfNone, 0, false, false);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "", false, "", dfNone, 0, false, false);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dg_cgo_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cntr_cgo_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_clss_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_comp_grp_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_un_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_un_no_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "spcl_provi_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "grs_wgt", false, "", dfFloat, 3, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "wgt_ut_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "net_wgt", false, "", dfFloat, 3, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "prp_shp_nm", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hzd_desc", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "flsh_pnt_cdo_temp", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_pck_grp_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "psa_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_lmt_qty_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_expt_qty_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd3", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd4", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_sts_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "mrn_polut_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_mrn_polut_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_cntc_phn_no_ctnt", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_cntc_pson_nm", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dcgo_rqst_grp_eml1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dcgo_rqst_grp_eml2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "certi_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cnee_dtl_desc", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "net_explo_wgt", false, "", dfFloat, 1, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_skd_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_amt", false, "", dfFloat, 2, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_ut_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_trsp_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "clod_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgo_lcl_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "diff_rmk", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_cntr_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_cd1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_cd2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_cd1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_cd2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_cd1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_cd2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_desc1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_desc2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_desc1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_desc2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_desc1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_desc2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_qty1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_qty2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_qty1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_qty2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_qty1", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_qty2", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "max_in_pck_qty", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "max_in_pck_tp_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_intmd_bc_rstr_desc", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_pck_rstr_desc", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_tnk_rstr_desc", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ltd_qty", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ems_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_rspn_gid_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_rspn_gid_chr_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ctrl_temp_ctnt", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_temp_ctnt", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "modifyaproflg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dg_cntr_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "meas_qty", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rc_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bb_cgo_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_qty", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_dpnd_qty_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_spcl_provi_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_crr_rstr_expt_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_rqst_flg", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_rqst_desc", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_expt_qty_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "crr_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "por_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "del_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rcv_term_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "de_term_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_cgo_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_cntr_seq", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "apro_cd", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "eq_tpsz", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "aply_no", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "hzd_ctnt", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "stwg_temp_ctnt", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dflt_segr_grp_nm", false, "", dfNone, 0, false, true);
     				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "grs_capa_qty", false, "", dfNone, 0, false, true);
     				CountPosition = 0;
     			}
     			break;   

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
	   
    	 sheetObj.ShowDebugMsg = false;
         var sheetCopy = opener.sheetObjects[1];
     	 var rowVal=0;
     	 
         switch(sAction) {

 					case IBSEARCH:      //조회					
 					
 					if(sheetCopy.RowCount > 0){
 						
 						for(var i=1; i<=sheetCopy.RowCount; i++){ 							
 								
	 						rowVal++;	 							
	 							
	 						sheetObjects[0].DataInsert(-1);
	 							
	 						sheetObjects[0].CellValue2(rowVal, "ibflag") = sheetCopy.CellValue(i, "ibflag");	 							
	 						sheetObjects[0].CellValue2(rowVal, "seq") = sheetCopy.CellValue(i, "seq");	 							
	 						sheetObjects[0].CellValue2(rowVal, "cntr_no") = sheetCopy.CellValue(i, "cntr_no");
	 						sheetObjects[0].CellValue2(rowVal, "cntr_tpsz_cd") = sheetCopy.CellValue(i, "cntr_tpsz_cd");	 							
	 						sheetObjects[0].CellValue2(rowVal, "dg_cntr_seq") = sheetCopy.CellValue(i, "dg_cntr_seq");
	 						sheetObjects[0].CellValue2(rowVal, "cntr_vol_qty") = sheetCopy.CellValue(i, "cntr_vol_qty");
	 							 												
 						} 						
 					}	
 					
 					
 					break;
 					
 					case SEARCH03:
 						if (validateForm(sheetObj, formObj, sAction))
 							formObj.f_cmd.value = SEARCH03;			
 						var resultXml = sheetObj.GetSearchXml("ESM_BKG_0735GS.do", "f_cmd="+formObj.f_cmd.value+"&bkg_no="+ComGetObjValue(formObj.from_bkg_no)); 
 						var arrXml = resultXml.split("|$$|");
 						sheetObjects[1].LoadSearchXml(arrXml[0], false);
 						break;    
 						
 					
         }
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

	/* 개발자 작업  끝 */