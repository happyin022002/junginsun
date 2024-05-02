/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0902.js
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.28 김종준
* 1.0 Creation
=========================================================*/
	
	// 공통전역변수
	var docObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= docObjects[0];
         var sheetObject1 = docObjects[1];
         var sheetObject2 = docObjects[2];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {
				
				case "btn_close":
					window.close();
	        break;

				case "btng_print":					
					rdObject.PrintDialog();
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
                errMsg = getMsg("TES22506" );
                showErrMessage(errMsg);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
       	rdOpen();	
		//rdObjects[0].PrintDialog();
    }

    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
	function rdOpen(){		
		
		var sXml = "";		
		var i=0;
		var j=0; 
		var opener_obj = window.dialogArguments;	
		var opener_sheet_obj1 =  opener_obj.document.sheet1;
		
		var fromObj = new Array();
		var rdObj = new Array();
					
        fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
        rdObj[0] = opener_sheet_obj1;     
         
        sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		
		sheetCnt = 1;
		//i = 시트 카운트,
		for(i=0;i<1;i++){
			sheetCnt = i+1;
			if(rdObj[i].RowCount ==0){
				sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 				for(j=0;j<=rdObj[i].LastCol;j++){
					sXml +="<TD></TD>";
 				}
				sXml +="</TR></DATA></SHEET"+sheetCnt+">";
			}else{
				sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt); 					
			}			
		}
		var prt_cntr_tpsz_cd = opener_obj.document.form.prt_chk_cntr_tpsz_cd.value;
		if ( prt_cntr_tpsz_cd == 'true' ) {
			prt_cntr_tpsz_cd ="";
		} else {
			prt_cntr_tpsz_cd = opener_obj.document.form.prt_cntr_tpsz_cd.value
		}
		sXml +="<ETC>" ;  
		sXml +="	<CHK_CNTR_TPSZ_CD>"+prt_cntr_tpsz_cd+"</CHK_CNTR_TPSZ_CD>"
		sXml +="	<CNMV_STS_CD>"+opener_obj.document.form.prt_cnmv_sts_cd.value+"</CNMV_STS_CD>"
		sXml +="	<LSTM_CD>"+opener_obj.document.form.prt_lstm_cd.value+"</LSTM_CD>"
		var full_flg = "";
		if ( opener_obj.document.form.prt_full_flg.value == 'Y' ) {
			full_flg = "Full";
		} else if  ( opener_obj.document.form.prt_full_flg.value == 'N' ) {
			full_flg = "MTY";
		}
		sXml +="	<FULL_FLG>"+full_flg+"</FULL_FLG>"
		var dmg_flg = "Include";
		if ( opener_obj.document.form.prt_dmg_flg.value == 'Y' ) {
			dmg_flg = "Only";
		} else if  ( opener_obj.document.form.prt_dmg_flg.value == 'N' ) {
			dmg_flg = "Exclude";
		} 
		sXml +="	<DMG_FLG>"+dmg_flg+"</DMG_FLG>"
		var soc_cd = "";
		if ( opener_obj.document.form.prt_soc_cd.value == '1' ) {
			soc_cd = "Exclude";
		} else if  ( opener_obj.document.form.prt_soc_cd.value == '2' ) {
			soc_cd = "Only";
		} else {
			soc_cd = "Include";
		}
		sXml +="	<SOC_CD>"+soc_cd+"</SOC_CD>"
		if ( opener_obj.document.form.prt_cntr_hngr_rck_cd.value == 'Y' ) {
			sXml +="	<CNTR_HNGR_RCK_CD>Hanger Rack/Bar : √</CNTR_HNGR_RCK_CD>"
		} else {
			sXml +="	<CNTR_HNGR_RCK_CD>Hanger Rack/Bar :</CNTR_HNGR_RCK_CD>"
		}
		if ( opener_obj.document.form.prt_disp_flg.value == 'Y' ) {
			sXml +="	<DISP_FLG>DPSL :√</DISP_FLG>"
		} else {
			sXml +="	<DISP_FLG>DPSL :</DISP_FLG>"
		}
		if ( opener_obj.document.form.prt_d2_payld_flg.value == 'Y' ) {
			sXml +="	<D2_PAYLD_FLG>D2-HP :√</D2_PAYLD_FLG>" 
		} else {
			sXml +="	<D2_PAYLD_FLG>D2-HP :	</D2_PAYLD_FLG>"
		}

		sXml +="	<CNTR_NO>"+opener_obj.document.form.prt_cntr_no.value+"</CNTR_NO>"
		sXml +="	<CNTR_USE_CO_CD>"+opener_obj.document.form.prt_cntr_use_co_cd.value+"</CNTR_USE_CO_CD>"
		var real_cntr_tpsz_cd = opener_obj.head_cntr_tpsz_cd.split("|")
		var ii = 0;
		for ( var i=0; i<real_cntr_tpsz_cd.length; i++ ) {
			ii++;
			sXml +="	<HEAD_CNTR_TPSZ_CD"+ii+">"+real_cntr_tpsz_cd[i]+"</HEAD_CNTR_TPSZ_CD"+ii+">"
		}
		
		sXml +="</ETC>"
		sXml +="</SHEET>";

		if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
		{
		    errMsg = 'No data found.';
		    showErrMessage(errMsg);
		    return;
		}
		rdObjects[0].AutoAdjust = true;
		rdObjects[0].HideToolbar();
		rdObjects[0].HideStatusbar();
		rdObjects[0].ViewShowMode(2);
				
		rdObjects[0].setbackgroundcolor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);			

		rdObjects[0].SetRData(sXml);
		// 접속 지역이 미국이면 용지설정을 LETTER 로 한다.
		if(opener_obj.document.form.prt_cnt_cd.value == "US"){ 
			RDServer += "/rpaper [LETTER]";
		}		
		rdObjects[0].FileOpen(RD_path+'apps/alps/ees/cim/containersupplydemandforecast/cntrinventoryreport/report/EES_CIM_0902.mrd',RDServer);
	}