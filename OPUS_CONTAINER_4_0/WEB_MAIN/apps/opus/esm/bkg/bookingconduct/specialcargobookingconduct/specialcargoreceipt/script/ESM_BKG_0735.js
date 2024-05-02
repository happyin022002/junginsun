/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0735.js
*@FileTitle  : Dangerous cargo application Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================
*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // 공통전역변수
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var radioChk=0;
 var opener_copy=window.dialogArguments;
 if (!opener_copy) opener_copy=parent;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
				            case "btn_ok":
				            	copyCntrSeq();
							break; 
 							case "btn_close":
 								ComClosePopup(); 
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
         for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
 				ComConfigSheet (sheetObjects[i] );
 				initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
 				ComEndConfigSheet(sheetObjects[i]);
         }
 			initControl();
 			if(document.getElementById("copyFlg").value == "Y"){
 				document.getElementById("chk1text").disabled=false;
 				radioChk="1";
 			}else{
 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 				document.getElementsByName("radioChk2")[0].disabled=false;
	    		document.getElementsByName("radioChk2")[1].disabled=false;
	    		document.getElementById("chk2text").disabled=true; 
	  			sheetObjects[0].editable=false;
 			}
     }
   function initControl() {    	  
  	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
  	    axon_event.addListenerForm('click',    'obj_click',     form);
  	    axon_event.addListenerForm('keypress','obj_keypress', form);
  	}
    function obj_click(){
  		switch (ComGetEvent("name")) {  	 		
  			/*
  		    case "radioChk1":
  		    	var size=document.getElementsByName("radioChk1").length;
  		    	for(var i=0; i < size; i++) {
  		    	  if(document.getElementsByName("radioChk1")[i].checked) {
  		    		  if(document.getElementsByName("radioChk1")[i].value == "1"){
  		    			document.getElementsByName("radioChk2")[0].checked=false;
  		    			document.getElementsByName("radioChk2")[1].checked=false;
  		    			document.getElementsByName("radioChk2")[0].disabled=true;
  		    			document.getElementsByName("radioChk2")[1].disabled=true;
  		    			document.getElementById("chk1text").disabled=false;
  		    			document.getElementById("chk2text").disabled=true;
  		    			sheetObjects[0].editable=false;
  		    			radioChk="1";
  		    		  }else{  	
  		    			document.getElementsByName("radioChk2")[0].disabled=false;
  		    			document.getElementsByName("radioChk2")[1].disabled=false;
  		    			document.getElementById("chk2text").disabled=true; 
  		    			document.getElementById("chk1text").disabled=true;
  		    		  }
  		    	  } 
  		    	}
  		    break;
  		 */
  		    case "radioChk2":
				var size=document.getElementsByName("radioChk2").length;
  		    	for(var i=0; i < size; i++) {
  		    	  if(document.getElementsByName("radioChk2")[i].checked) {
  		    		  if(document.getElementsByName("radioChk2")[i].value == "1"){
  		    			sheetObjects[0].editable=false;  	
  		    			document.getElementById("chk2text").disabled=false;
  		    			radioChk="2";
  		    		  }else{
  		    			sheetObjects[0].editable=true;
  		    			document.getElementById("chk2text").disabled=true;
  		    			radioChk="3";
  		    		  }
  		    	 } 
  		    }
  		    break;
  		}	
  	}
    function obj_keypress(){
		switch (ComGetEvent("name")) {		
		    case "chk1text":		    	
		    	ComKeyOnlyNumber(ComGetEvent());   	
			break;
		    case "chk2text":		    	
		    	ComKeyOnlyNumber(ComGetEvent(), "-.");   	
			break;	    
		}	
	}
    function copyCntrSeq(){
    	opener_copy.document.getElementById("temp_cntr_no").value="";
    	if(radioChk == "1" && document.getElementById("chk1text").value != ""){ //Container copy 
    		var chk=document.getElementById("chk1text").value;
    		var sRow=opener_copy.sheetObjects[3].FindCheckedRow("CntrChk")+"|";
    		var arrRow=sRow.split("|");   		
    		var cntr_name="";
			var cntr_val="";
			for (var j=1; j <= opener_copy.sheetObjects[4].RowCount(); j++){
				if(opener_copy.sheetObjects[4].GetCellValue(j, "DelChk") == "0"){
						cntr_name += opener_copy.sheetObjects[4].GetCellValue(j, "name")+"|";
						cntr_val += opener_copy.sheetObjects[4].GetCellValue(j, "val")+"|";
					} 									
			}
			cntr_val=cntr_val.substr(0, cntr_val.length-1);	
			cntr_name=cntr_name.substr(0, cntr_name.length-1);   
    		for (var i=1; i <= chk; i++){
    			var row1=opener_copy.sheetObjects[1].DataInsert(-1);
    			opener_copy.sheetObjects[1].SetCellValue(row1, "cntr_no","",0);
    			opener_copy.sheetObjects[1].CellComboItem(row1,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
    			opener_copy.sheetObjects[1].SetCellValue(row1, "cntr_tpsz_cd",opener_copy.document.getElementById("cntr_tpsz_cd").value,0);
    			opener_copy.sheetObjects[1].SetCellValue(row1, "cntr_cgo_seq","1",0);
    			var findTpszRow=opener_copy.sheetObjects[0].FindText("cntr_tpsz_cd", opener_copy.document.getElementById("cntr_tpsz_cd").value, 1, 0, 2);
    			var cntr_vol_qty=opener_copy.sheetObjects[0].GetCellValue(findTpszRow, "dcgo_qty");
    			if(findTpszRow == undefined || findTpszRow < 0){
    				cntr_vol_qty = 0;
    			}
    			if(cntr_vol_qty >= 1){
    				cntr_vol_qty=1;
    			}
    			var dg_cntr_seq=Number(opener_copy.sheetObjects[1].GetCellValue(1, "dg_cntr_seq"));
				for(var j=1; j <= opener_copy.sheetObjects[1].RowCount(); j++){
					if(dg_cntr_seq < Number(opener_copy.sheetObjects[1].GetCellValue(j, "dg_cntr_seq"))){
						dg_cntr_seq=Number(opener_copy.sheetObjects[1].GetCellValue(j, "dg_cntr_seq"));
					}
				}
				opener_copy.sheetObjects[1].SetCellValue(row1, "cntr_vol_qty",cntr_vol_qty,0);
				opener_copy.sheetObjects[1].SetCellValue(row1, "dg_cntr_seq",Number(dg_cntr_seq) + 1,0);
    			for(var idx=0; idx < arrRow.length-1; idx++){
    				var row2=opener_copy.sheetObjects[3].DataInsert(-1);
    				var dcgo_seq=0;
    				if(opener_copy.sheetObjects[3].RowCount() > 0){		//return value 가 null일떄 -1 처리
    					dcgo_seq=Number(opener_copy.sheetObjects[3].GetCellValue(1, "dcgo_seq"));
    				}else{
    					dcgo_seq=0;
    				}
    				
    				for(var k=1; k <= opener_copy.sheetObjects[3].RowCount(); k++){
						if(dcgo_seq < Number(opener_copy.sheetObjects[3].GetCellValue(k, "dcgo_seq"))){
							dcgo_seq=Number(opener_copy.sheetObjects[3].GetCellValue(k, "dcgo_seq"));
    					}
    				}
    				opener_copy.sheetObjects[3].SetCellValue(row2, "dcgo_seq",Number(dcgo_seq)+1,0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "cntr_cgo_seq",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "cntr_cgo_seq"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "spcl_cgo_seq",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "cntr_cgo_seq"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_clss_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_clss_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "cfr_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "cfr_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_comp_grp_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_comp_grp_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_un_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_un_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "grs_wgt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "grs_wgt"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "wgt_ut_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "wgt_ut_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "net_wgt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "net_wgt"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "prp_shp_nm",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "prp_shp_nm"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hzd_desc",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hzd_desc"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "flsh_pnt_cdo_temp",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "flsh_pnt_cdo_temp"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_pck_grp_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_pck_grp_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "psa_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "psa_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_lmt_qty_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_lmt_qty_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_expt_qty_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_expt_qty_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hcdg_flag",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hcdg_flag"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_subs_rsk_lbl_cd1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_subs_rsk_lbl_cd2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_subs_rsk_lbl_cd3",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd3"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_subs_rsk_lbl_cd4",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_subs_rsk_lbl_cd4"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "dcgo_sts_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "dcgo_sts_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_segr_grp_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_segr_grp_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "rsd_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "rsd_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "mrn_polut_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "mrn_polut_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "emer_cntc_phn_no_ctnt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "emer_cntc_phn_no_ctnt"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "emer_cntc_pson_nm",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "emer_cntc_pson_nm"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "certi_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "certi_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "cnee_dtl_desc",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "cnee_dtl_desc"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "net_explo_wgt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "net_explo_wgt"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "rada_skd_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "rada_skd_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "rada_amt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "rada_amt"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "rada_ut_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "rada_ut_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "rada_trsp_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "rada_trsp_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "in_imdg_pck_cd1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "in_imdg_pck_cd1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "in_imdg_pck_cd2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "in_imdg_pck_cd2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "intmd_imdg_pck_cd1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "intmd_imdg_pck_cd1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "intmd_imdg_pck_cd2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "intmd_imdg_pck_cd2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "out_imdg_pck_cd1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "out_imdg_pck_cd1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "out_imdg_pck_cd2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "out_imdg_pck_cd2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "in_imdg_pck_desc1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "in_imdg_pck_desc1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "in_imdg_pck_desc2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "in_imdg_pck_desc2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "intmd_imdg_pck_desc1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "intmd_imdg_pck_desc1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "intmd_imdg_pck_desc2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "intmd_imdg_pck_desc2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "out_imdg_pck_desc1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "out_imdg_pck_desc1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "out_imdg_pck_desc2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "out_imdg_pck_desc2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "in_imdg_pck_qty1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "in_imdg_pck_qty1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "in_imdg_pck_qty2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "in_imdg_pck_qty2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "intmd_imdg_pck_qty1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "intmd_imdg_pck_qty1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "intmd_imdg_pck_qty2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "intmd_imdg_pck_qty2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "out_imdg_pck_qty1",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "out_imdg_pck_qty1"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "out_imdg_pck_qty2",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "out_imdg_pck_qty2"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "max_in_pck_qty",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "max_in_pck_qty"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "max_in_pck_tp_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "max_in_pck_tp_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hcdg_intmd_bc_rstr_desc",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hcdg_intmd_bc_rstr_desc"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hcdg_pck_rstr_desc",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hcdg_pck_rstr_desc"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hcdg_tnk_rstr_desc",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hcdg_tnk_rstr_desc"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "ltd_qty",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "ltd_qty"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "bkg_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "bkg_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_comp_grp_cd",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_comp_grp_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_un_no_seq",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_un_no_seq"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "clod_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "clod_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "cgo_lcl_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "cgo_lcl_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "ems_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "ems_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "emer_rspn_gid_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "emer_rspn_gid_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "emer_rspn_gid_chr_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "emer_rspn_gid_chr_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "ctrl_temp_ctnt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "ctrl_temp_ctnt"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "emer_temp_ctnt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "emer_temp_ctnt"),0);
    				opener_copy.sheetObjects[3].SetCellValue(row2, "dg_cntr_seq",Number(dg_cntr_seq) + 1,0);
    				opener_copy.sheetObjects[3].SetCellValue(row2, "spcl_cntr_seq",Number(dg_cntr_seq) + 1,0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "meas_qty",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "meas_qty"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "rc_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "rc_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "awk_cgo_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "awk_cgo_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "bb_cgo_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "bb_cgo_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hcdg_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hcdg_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "hcdg_dpnd_qty_flg",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "hcdg_dpnd_qty_flg"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "cntr_tpsz_cd",opener_copy.sheetObjects[1].GetCellValue(row1, "cntr_tpsz_cd"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "cntr_vol_qty",opener_copy.sheetObjects[1].GetCellValue(row1, "cntr_vol_qty"),0);
    				opener_copy.sheetObjects[3].SetCellValue(row2, "cntr_no","",0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "dg_cntr_seq",opener_copy.sheetObjects[1].GetCellValue(row1, "dg_cntr_seq"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "spcl_cntr_seq",opener_copy.sheetObjects[1].GetCellValue(row1, "dg_cntr_seq"),0);
    				opener_copy.sheetObjects[3].SetCellValue(row2, "spcl_rqst_flg","N",0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_amdt_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_amdt_no"),0);
					//2015.11.24.erap
					opener_copy.sheetObjects[3].SetCellValue(row2, "erap_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "erap_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "erap_cntc_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "erap_cntc_no"),0);
					opener_copy.sheetObjects[3].SetCellValue(row2, "erap_apro_ref_no",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "erap_apro_ref_no"),0);

					opener_copy.sheetObjects[3].SetCellValue(row2, "imdg_un_no_spcl_provi_ctnt",opener_copy.sheetObjects[3].GetCellValue(arrRow[idx], "imdg_un_no_spcl_provi_ctnt"),0);
    			}   			
    		} 
    		var cnt=0;  
	  	  	for (var i=1; i<=opener_copy.sheetObjects[3].RowCount(); i++){
	  	  		if(opener_copy.sheetObjects[3].GetCellValue(i, "CntrChk") == "1" ){
			      	cnt++;		
			      	opener_copy.sheetObjects[3].SetCellValue(i, "cntr_cgo_seq",cnt,0);
			      	opener_copy.sheetObjects[3].SetCellValue(i, "spcl_cgo_seq",cnt,0);
		      	}
	      	} 
    	}else if(radioChk == "2" && document.getElementById("chk2text").value != ""){ //Detail copy to new CNTR seq
    		var selRow=opener_copy.sheetObjects[3].FindText("CntrChk", 1, 0, 2)
    		var chk=document.getElementById("chk2text").value;
    		var cntr_name="";
			var cntr_val="";
			/*
    		for (var j=1; j<=opener_copy.sheetObjects[4].RowCount(); j++){
				if(opener_copy.sheetObjects[4].GetCellValue(j, "DelChk") == "0"){
					cntr_name += opener_copy.sheetObjects[4].GetCellValue(j, "name")+"|";
					cntr_val += opener_copy.sheetObjects[4].GetCellValue(j, "val")+"|";
				} 									
			}
			cntr_val=cntr_val.substr(0, cntr_val.length-1);	
			cntr_name=cntr_name.substr(0, cntr_name.length-1); 
    		*/
    		for (var i=1; i <= chk; i++){
    			var ins=opener_copy.sheetObjects[1].DataInsert(-1);
    			opener_copy.sheetObjects[1].SetCellValue(ins, "cntr_no","",0);
    			opener_copy.sheetObjects[1].CellComboItem(ins,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
    			opener_copy.sheetObjects[1].SetCellValue(ins, "cntr_tpsz_cd",opener_copy.document.getElementById("cntr_tpsz_cd").value,0);
    			opener_copy.sheetObjects[1].SetCellValue(ins, "cntr_cgo_seq","1",0);
    			var dg_cntr_seq=Number(opener_copy.sheetObjects[1].GetCellValue(1, "dg_cntr_seq"));
    			var cntr_vol_qty="";
    			for(var k=1; k <= opener_copy.sheetObjects[1].RowCount(); k++){
					if(dg_cntr_seq < Number(opener_copy.sheetObjects[1].GetCellValue(k, "dg_cntr_seq"))){
						dg_cntr_seq=Number(opener_copy.sheetObjects[1].GetCellValue(k, "dg_cntr_seq"));
						cntr_vol_qty=opener_copy.sheetObjects[1].GetCellValue(k, "cntr_vol_qty");
					}
				}
    			opener_copy.sheetObjects[1].SetCellValue(ins, "cntr_vol_qty",cntr_vol_qty,0);
				opener_copy.sheetObjects[1].SetCellValue(ins, "dg_cntr_seq",Number(dg_cntr_seq)+1,0);
    			var row=opener_copy.sheetObjects[3].DataInsert(-1);
    			var dcgo_seq=0;
    			
    			if(opener_copy.sheetObjects[3].RowCount() > 0){
    				dcgo_seq=Number(opener_copy.sheetObjects[3].GetCellValue(1, "dcgo_seq"));
    			}else{
    				dcgo_seq = 0;
    			}
    			
				for(var m=1; m <= opener_copy.sheetObjects[3].RowCount(); m++){
					if(dcgo_seq < Number(opener_copy.sheetObjects[3].GetCellValue(m, "dcgo_seq"))){
						dcgo_seq=Number(opener_copy.sheetObjects[3].GetCellValue(m, "dcgo_seq"));
					}
				}
				opener_copy.sheetObjects[3].SetCellValue(row, "dcgo_seq",Number(dcgo_seq) + 1,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "dg_cntr_seq",opener_copy.sheetObjects[1].GetCellValue(ins, "dg_cntr_seq"),0);
				opener_copy.sheetObjects[3].SetCellValue(row, "spcl_cntr_seq",opener_copy.sheetObjects[1].GetCellValue(ins, "dg_cntr_seq"),0);
    			opener_copy.sheetObjects[3].SetCellValue(row, "cntr_cgo_seq","1",0);
    			opener_copy.sheetObjects[3].SetCellValue(row, "spcl_cgo_seq","1",0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_clss_cd",opener_copy.document.getElementById("imdg_clss_cd").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "cfr_flg",opener_copy.document.getElementById("cfr_flg").checked?"Y":"N",0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_comp_grp_cd",opener_copy.document.getElementById("imdg_comp_grp_cd").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_un_no",opener_copy.document.getElementById("imdg_un_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "grs_wgt",opener_copy.document.getElementById("grs_wgt").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "wgt_ut_cd","KGS",0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "net_wgt",opener_copy.document.getElementById("net_wgt").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "prp_shp_nm",opener_copy.document.getElementById("prp_shp_nm").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "hzd_desc",opener_copy.document.getElementById("hzd_desc").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "flsh_pnt_cdo_temp",opener_copy.document.getElementById("flsh_pnt_cdo_temp").value,0);
   				var imdgPckGrpCd = opener_copy.document.getElementById("imdg_pck_grp_cd").value;
   				if(imdgPckGrpCd == "I"){
   					imdgPckGrpCd = "1";
   				}else if(imdgPckGrpCd == "II"){
   					imdgPckGrpCd = "2";
   				}else if(imdgPckGrpCd == "III"){
   					imdgPckGrpCd = "3";
   				}
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_pck_grp_cd",imdgPckGrpCd,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "psa_no",opener_copy.document.getElementById("psa_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_lmt_qty_flg",opener_copy.document.getElementById("imdg_lmt_qty_flg").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_expt_qty_flg",opener_copy.document.form.imdg_expt_qty_flg.value,0);
   				//opener_copy.sheetObjects[3].SetCellValue(row, "imdg_expt_qty_flg",opener_copy.document.getElementById("imdg_expt_qty_flg").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_flag",opener_copy.document.getElementById("hcdg_flag").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd1",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd1").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd2",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd2").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd3",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd3").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd4",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd4").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "dcgo_sts_cd",opener_copy.document.getElementById("dcgo_sts_cd").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_segr_grp_no",opener_copy.document.getElementById("imdg_segr_grp_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "rsd_flg",opener_copy.document.getElementById("rsd_flg").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "mrn_polut_flg",opener_copy.document.getElementById("mrn_polut_flg").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "emer_cntc_phn_no_ctnt",opener_copy.document.getElementById("emer_cntc_phn_no_ctnt").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "emer_cntc_pson_nm",opener_copy.document.getElementById("emer_cntc_pson_nm").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "certi_no",opener_copy.document.getElementById("certi_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "cnee_dtl_desc",opener_copy.document.getElementById("cnee_dtl_desc").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "net_explo_wgt",opener_copy.document.getElementById("net_explo_wgt").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_skd_no",opener_copy.document.getElementById("rada_skd_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_amt",opener_copy.document.getElementById("rada_amt").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_ut_cd",opener_copy.document.getElementById("rada_ut_cd").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_trsp_no",opener_copy.document.getElementById("rada_trsp_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "bkg_no",opener_copy.document.getElementById("bkg_no").value,0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd1",opener_copy.document.getElementById("in_imdg_pck_cd1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd2",opener_copy.document.getElementById("in_imdg_pck_cd2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd1",opener_copy.document.getElementById("intmd_imdg_pck_cd1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd2",opener_copy.document.getElementById("intmd_imdg_pck_cd2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd1",opener_copy.document.getElementById("out_imdg_pck_cd1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd2",opener_copy.document.getElementById("out_imdg_pck_cd2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc1",opener_copy.document.getElementById("in_imdg_pck_desc1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc2",opener_copy.document.getElementById("in_imdg_pck_desc2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc1",opener_copy.document.getElementById("intmd_imdg_pck_desc1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc2",opener_copy.document.getElementById("intmd_imdg_pck_desc2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc1",opener_copy.document.getElementById("out_imdg_pck_desc1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc2",opener_copy.document.getElementById("out_imdg_pck_desc2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty1",opener_copy.document.getElementById("in_imdg_pck_qty1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty2",opener_copy.document.getElementById("in_imdg_pck_qty2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty1",opener_copy.document.getElementById("intmd_imdg_pck_qty1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty2",opener_copy.document.getElementById("intmd_imdg_pck_qty2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty1",opener_copy.document.getElementById("out_imdg_pck_qty1").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty2",opener_copy.document.getElementById("out_imdg_pck_qty2").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "max_in_pck_qty",opener_copy.document.getElementById("max_in_pck_qty").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "max_in_pck_tp_cd",opener_copy.document.getElementById("max_in_pck_tp_cd").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_intmd_bc_rstr_desc",opener_copy.document.getElementById("hcdg_intmd_bc_rstr_desc").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_pck_rstr_desc",opener_copy.document.getElementById("hcdg_pck_rstr_desc").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_tnk_rstr_desc",opener_copy.document.getElementById("hcdg_tnk_rstr_desc").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "ltd_qty",opener_copy.document.getElementById("ltd_qty").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "cntr_vol_qty",opener_copy.sheetObjects[1].GetCellValue(ins, "cntr_vol_qty"),0);
   				opener_copy.sheetObjects[3].SetCellValue(row, "cntr_no","",0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "cntr_tpsz_cd",opener_copy.document.getElementById("cntr_tpsz_cd").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "CntrChk","1",0);
    	  		opener_copy.sheetObjects[1].SetCellValue(opener_copy.sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd","",0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "clod_flg",opener_copy.document.getElementById("clod_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "rc_flg",opener_copy.document.getElementById("rc_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "awk_cgo_flg",opener_copy.document.getElementById("awk_cgo_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "bb_cgo_flg",opener_copy.document.getElementById("bb_cgo_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_flg",opener_copy.document.getElementById("hcdg_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "meas_qty",opener_copy.document.getElementById("meas_qty").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_dpnd_qty_flg",opener_copy.document.getElementById("hcdg_dpnd_qty_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "imdg_comp_grp_cd",opener_copy.document.getElementById("imdg_comp_grp_cd").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "imdg_un_no_seq",opener_copy.document.getElementById("imdg_un_no_seq").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "ems_no",opener_copy.document.getElementById("ems_no").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "emer_rspn_gid_no",opener_copy.document.getElementById("emer_rspn_gid_no").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "emer_rspn_gid_chr_no",opener_copy.document.getElementById("emer_rspn_gid_chr_no").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "ctrl_temp_ctnt",opener_copy.document.getElementById("ctrl_temp_ctnt").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "emer_temp_ctnt",opener_copy.document.getElementById("emer_temp_ctnt").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "spcl_rqst_flg",opener_copy.document.getElementById("spcl_rqst_flg").value,0);
    	  		opener_copy.sheetObjects[3].SetCellValue(row, "imdg_amdt_no",opener_copy.document.getElementById("imdg_amdt_no").value,0);
				//2015.11.24.erap
				opener_copy.sheetObjects[3].SetCellValue(row, "erap_no",opener_copy.document.getElementById("erap_no").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "erap_cntc_no",opener_copy.document.getElementById("erap_cntc_no").value,0);
				opener_copy.sheetObjects[3].SetCellValue(row, "erap_apro_ref_no",opener_copy.document.getElementById("erap_apro_ref_no").value,0);
				
				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_un_no_spcl_provi_ctnt",opener_copy.document.getElementById("imdg_un_no_spcl_provi_ctnt").value,0);
    		}   		  		
    	}
    	else if(radioChk == "3"){ //detail copy to Existing CNTR seq
    		var rowCnt=sheetObjects[0].RowCount();
    		var copyCnt=0;
    		for (var i=1; i <= rowCnt; i++){
    			if(sheetObjects[0].GetCellValue(i, "copyChk")=="1" ){
    				if(sheetObjects[0].GetCellValue(i, "copyCnt") > 0){
	    				copyCnt++;
	    				var row2=0;
	    				for(var k=1; k<=opener_copy.sheetObjects[3].RowCount(); k++){
	    					if(sheetObjects[0].GetCellValue(i, "dg_cntr_seq") == opener_copy.sheetObjects[3].GetCellValue(k, "dg_cntr_seq") && sheetObjects[0].GetCellValue(i, "cntr_no") == opener_copy.sheetObjects[3].GetCellValue(k, "cntr_no") && opener_copy.sheetObjects[3].GetCellValue(k, "ibflag") != "D"){
	    						row2++;	    						
	    					}    	    	  			
    	    	  		}
	    				for (var j=1; j <= sheetObjects[0].GetCellValue(i, "copyCnt"); j++){
	    					var row=opener_copy.sheetObjects[3].DataInsert(-1);
	    					var dcgo_seq=Number(opener_copy.sheetObjects[3].GetCellValue(1, "dcgo_seq"));
	    					for(var m=1; m <= opener_copy.sheetObjects[3].RowCount(); m++){
								if(dcgo_seq < Number(opener_copy.sheetObjects[3].GetCellValue(m, "dcgo_seq"))){
								dcgo_seq=Number(opener_copy.sheetObjects[3].GetCellValue(m, "dcgo_seq"));
	    						}
	    					}
	    					opener_copy.sheetObjects[3].SetCellValue(row, "dcgo_seq",Number(dcgo_seq) + 1,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "imdg_clss_cd",opener_copy.document.getElementById("imdg_clss_cd").value,0);
//	    					opener_copy.sheetObjects[3].SetCellValue(row, "cfr_flg",opener_copy.document.getElementById("cfr_flg").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "cfr_flg",opener_copy.document.getElementById("cfr_flg").checked?"Y":"N",0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_comp_grp_cd",opener_copy.document.getElementById("imdg_comp_grp_cd").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_un_no",opener_copy.document.getElementById("imdg_un_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "grs_wgt",opener_copy.document.getElementById("grs_wgt").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "wgt_ut_cd","KGS",0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "net_wgt",opener_copy.document.getElementById("net_wgt").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "prp_shp_nm",opener_copy.document.getElementById("prp_shp_nm").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "hzd_desc",opener_copy.document.getElementById("hzd_desc").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "flsh_pnt_cdo_temp",opener_copy.document.getElementById("flsh_pnt_cdo_temp").value,0);
	    	   				var imdgPckGrpCd = opener_copy.document.getElementById("imdg_pck_grp_cd").value;
	    	   				if(imdgPckGrpCd == "I"){
	    	   					imdgPckGrpCd = "1";
	    	   				}else if(imdgPckGrpCd == "II"){
	    	   					imdgPckGrpCd = "2";
	    	   				}else if(imdgPckGrpCd == "III"){
	    	   					imdgPckGrpCd = "3";
	    	   				}
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_pck_grp_cd",imdgPckGrpCd,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "psa_no",opener_copy.document.getElementById("psa_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_lmt_qty_flg",opener_copy.document.getElementById("imdg_lmt_qty_flg").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_expt_qty_flg",opener_copy.document.form.imdg_expt_qty_flg.value,0);
	    	   				//opener_copy.sheetObjects[3].SetCellValue(row, "imdg_expt_qty_flg",opener_copy.document.getElementById("imdg_expt_qty_flg").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_flag",opener_copy.document.getElementById("hcdg_flag").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd1",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd1").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd2",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd2").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd3",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd3").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_subs_rsk_lbl_cd4",opener_copy.document.getElementById("imdg_subs_rsk_lbl_cd4").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "dcgo_sts_cd",opener_copy.document.getElementById("dcgo_sts_cd").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "imdg_segr_grp_no",opener_copy.document.getElementById("imdg_segr_grp_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "rsd_flg",opener_copy.document.getElementById("rsd_flg").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "mrn_polut_flg",opener_copy.document.getElementById("mrn_polut_flg").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "emer_cntc_phn_no_ctnt",opener_copy.document.getElementById("emer_cntc_phn_no_ctnt").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "emer_cntc_pson_nm",opener_copy.document.getElementById("emer_cntc_pson_nm").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "certi_no",opener_copy.document.getElementById("certi_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "cnee_dtl_desc",opener_copy.document.getElementById("cnee_dtl_desc").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "net_explo_wgt",opener_copy.document.getElementById("net_explo_wgt").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_skd_no",opener_copy.document.getElementById("rada_skd_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_amt",opener_copy.document.getElementById("rada_amt").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_ut_cd",opener_copy.document.getElementById("rada_ut_cd").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "rada_trsp_no",opener_copy.document.getElementById("rada_trsp_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "bkg_no",opener_copy.document.getElementById("bkg_no").value,0);
	    	   				opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd1",opener_copy.document.getElementById("in_imdg_pck_cd1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd2",opener_copy.document.getElementById("in_imdg_pck_cd2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd1",opener_copy.document.getElementById("intmd_imdg_pck_cd1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd2",opener_copy.document.getElementById("intmd_imdg_pck_cd2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd1",opener_copy.document.getElementById("out_imdg_pck_cd1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd2",opener_copy.document.getElementById("out_imdg_pck_cd2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc1",opener_copy.document.getElementById("in_imdg_pck_desc1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc2",opener_copy.document.getElementById("in_imdg_pck_desc2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc1",opener_copy.document.getElementById("intmd_imdg_pck_desc1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc2",opener_copy.document.getElementById("intmd_imdg_pck_desc2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc1",opener_copy.document.getElementById("out_imdg_pck_desc1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc2",opener_copy.document.getElementById("out_imdg_pck_desc2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty1",opener_copy.document.getElementById("in_imdg_pck_qty1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty2",opener_copy.document.getElementById("in_imdg_pck_qty2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty1",opener_copy.document.getElementById("intmd_imdg_pck_qty1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty2",opener_copy.document.getElementById("intmd_imdg_pck_qty2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty1",opener_copy.document.getElementById("out_imdg_pck_qty1").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty2",opener_copy.document.getElementById("out_imdg_pck_qty2").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "max_in_pck_qty",opener_copy.document.getElementById("max_in_pck_qty").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "max_in_pck_tp_cd",opener_copy.document.getElementById("max_in_pck_tp_cd").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_intmd_bc_rstr_desc",opener_copy.document.getElementById("hcdg_intmd_bc_rstr_desc").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_pck_rstr_desc",opener_copy.document.getElementById("hcdg_pck_rstr_desc").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_tnk_rstr_desc",opener_copy.document.getElementById("hcdg_tnk_rstr_desc").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "ltd_qty",opener_copy.document.getElementById("ltd_qty").value,0);
							opener_copy.sheetObjects[3].SetCellValue(row, "cntr_vol_qty",sheetObjects[0].GetCellValue(i, "cntr_vol_qty"),0);
							opener_copy.sheetObjects[3].SetCellValue(row, "cntr_no",sheetObjects[0].GetCellValue(i, "cntr_no"),0);
							opener_copy.sheetObjects[3].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"),0);
							opener_copy.sheetObjects[3].SetCellValue(row, "dg_cntr_seq",sheetObjects[0].GetCellValue(i, "dg_cntr_seq"),0);
							opener_copy.sheetObjects[3].SetCellValue(row, "spcl_cntr_seq",sheetObjects[0].GetCellValue(i, "dg_cntr_seq"),0);
	    	    	  		opener_copy.sheetObjects[1].SetCellValue(i, "spcl_cgo_apro_cd","",0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "clod_flg",opener_copy.document.getElementById("clod_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "rc_flg",opener_copy.document.getElementById("rc_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "awk_cgo_flg",opener_copy.document.getElementById("awk_cgo_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "bb_cgo_flg",opener_copy.document.getElementById("bb_cgo_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_flg",opener_copy.document.getElementById("hcdg_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "meas_qty",opener_copy.document.getElementById("meas_qty").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "hcdg_dpnd_qty_flg",opener_copy.document.getElementById("hcdg_dpnd_qty_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "imdg_comp_grp_cd",opener_copy.document.getElementById("imdg_comp_grp_cd").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "imdg_un_no_seq",opener_copy.document.getElementById("imdg_un_no_seq").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "ems_no",opener_copy.document.getElementById("ems_no").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "emer_rspn_gid_no",opener_copy.document.getElementById("emer_rspn_gid_no").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "emer_rspn_gid_chr_no",opener_copy.document.getElementById("emer_rspn_gid_chr_no").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "ctrl_temp_ctnt",opener_copy.document.getElementById("ctrl_temp_ctnt").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "emer_temp_ctnt",opener_copy.document.getElementById("emer_temp_ctnt").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "spcl_rqst_flg",opener_copy.document.getElementById("spcl_rqst_flg").value,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "imdg_amdt_no",opener_copy.document.getElementById("imdg_amdt_no").value,0);
	    					//2015.11.24.erap
	    					opener_copy.sheetObjects[3].SetCellValue(row, "erap_no",opener_copy.document.getElementById("erap_no").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "erap_cntc_no",opener_copy.document.getElementById("erap_cntc_no").value,0);
	    					opener_copy.sheetObjects[3].SetCellValue(row, "erap_apro_ref_no",opener_copy.document.getElementById("erap_apro_ref_no").value,0);

	    					opener_copy.sheetObjects[3].SetCellValue(row, "imdg_un_no_spcl_provi_ctnt",opener_copy.document.getElementById("imdg_un_no_spcl_provi_ctnt").value,0);

	    					row2++;	    	 
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "cntr_cgo_seq",row2,0);
	    	    	  		opener_copy.sheetObjects[3].SetCellValue(row, "spcl_cgo_seq",row2,0);
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
    	}else{
    		//ComShowMessage("Copy할 수량이 입력되지 않았소.") 
    		ComShowCodeMessage("BKG95008", "Copy Number");
    		return;
    	}
    	opener_copy.cntrChk();    	  
		opener_copy.htmlSheetSync(); 
		ComClosePopup(); 
    }
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with(sheetObj){
		              var HeadTitle1=" ||Seq|Container No.|No. of Copy";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"copyChk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"copyCnt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
			              InitColumns(cols);
			              SetEditable(1);
			              SetSheetHeight(240);
                       }
                 break;
         		}
     }
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
         var sheetCopy=opener_copy.sheetObjects[1];
     	 var rowVal=0;
         switch(sAction) {
			case IBSEARCH:      //조회					
			if(sheetCopy.RowCount()> 0){
				for(var i=1; i<=sheetCopy.RowCount(); i++){
					rowVal++;	 							
					sheetObjects[0].DataInsert(-1);
					sheetObjects[0].SetCellValue(rowVal, "ibflag",sheetCopy.GetCellValue(i, "ibflag"),0);
					sheetObjects[0].SetCellValue(rowVal, "seq",sheetCopy.GetCellValue(i, "seq"),0);
					sheetObjects[0].SetCellValue(rowVal, "cntr_no",sheetCopy.GetCellValue(i, "cntr_no"),0);
					sheetObjects[0].SetCellValue(rowVal, "cntr_tpsz_cd",sheetCopy.GetCellValue(i, "cntr_tpsz_cd"),0);
					sheetObjects[0].SetCellValue(rowVal, "dg_cntr_seq",sheetCopy.GetCellValue(i, "dg_cntr_seq"),0);
					sheetObjects[0].SetCellValue(rowVal, "cntr_vol_qty",sheetCopy.GetCellValue(i, "cntr_vol_qty"),0);
				} 						
			}	
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
