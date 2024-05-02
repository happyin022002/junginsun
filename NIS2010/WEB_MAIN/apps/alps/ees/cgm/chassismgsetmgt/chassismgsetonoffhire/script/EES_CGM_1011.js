/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1011.js
*@FileTitle : On &amp; Off-Hire Status Summary Inquiry(Print)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.18 조재성
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
		
		var sXmlEtc="";
		sXmlEtc +="<ETC>" ;
		sXmlEtc +="	<S_USR_ID>"+opener_obj.document.form.s_usr_id.value+"</S_USR_ID>";		
		sXmlEtc +="	<S_OFC_ID>"+opener_obj.document.form.s_ofc_id.value+"</S_OFC_ID>";
		sXmlEtc +="	<EVNT_DT_STR>"+opener_obj.document.form.evnt_dt_str.value+"</EVNT_DT_STR>";
		sXmlEtc +="	<EVNT_DT_END>"+opener_obj.document.form.evnt_dt_end.value+"</EVNT_DT_END>";
		sXmlEtc +="	<EQ_ASET_STS_CD>"+opener_obj.document.form.eq_aset_sts_cd.options[opener_obj.document.form.eq_aset_sts_cd.selectedIndex].text+"</EQ_ASET_STS_CD>";
		sXmlEtc +="	<LOCATION>"+opener_obj.document.form.location.value+"</LOCATION>";
		sXmlEtc +="	<SCC_CD>"+opener_obj.document.form.scc_cd.value+"</SCC_CD>";
		sXmlEtc +="	<STS_EVNT_YD_CD>"+opener_obj.document.form.sts_evnt_yd_cd.value+"</STS_EVNT_YD_CD>";
		sXmlEtc +="	<HEAD_AGMT_LSTM_CD>"+opener_obj.document.form.agmt_lstm_cd.Text+"</HEAD_AGMT_LSTM_CD>";
		sXmlEtc +="	<KIND>"+opener_obj.document.form.kind.options[opener_obj.document.form.kind.selectedIndex].text+"</KIND>";
		sXmlEtc +="	<HEAD_VNDR_SEQ>"+opener_obj.document.form.vndr_seq.value+"</HEAD_VNDR_SEQ>";
		sXmlEtc +="	<TOT_TOTAL>"+rdObj[0].SumText(0,"total")+"</TOT_TOTAL>";
		sXmlEtc +="	<TOT_SF2>"+rdObj[0].SumText(0,"sf2")+"</TOT_SF2>";
		sXmlEtc +="	<TOT_SL2>"+rdObj[0].SumText(0,"sl2")+"</TOT_SL2>";
		sXmlEtc +="	<TOT_TA2>"+rdObj[0].SumText(0,"ta2")+"</TOT_TA2>";
		sXmlEtc +="	<TOT_SF4>"+rdObj[0].SumText(0,"sf4")+"</TOT_SF4>";
		sXmlEtc +="	<TOT_GN4>"+rdObj[0].SumText(0,"gn4")+"</TOT_GN4>";
		sXmlEtc +="	<TOT_GN5>"+rdObj[0].SumText(0,"gn5")+"</TOT_GN5>";				
		sXmlEtc +="	<TOT_CB4>"+rdObj[0].SumText(0,"cb4")+"</TOT_CB4>";
		sXmlEtc +="	<TOT_EG5>"+rdObj[0].SumText(0,"eg5")+"</TOT_EG5>";
		sXmlEtc +="	<TOT_EG8>"+rdObj[0].SumText(0,"eg8")+"</TOT_EG8>";
		sXmlEtc +="	<TOT_ZT4>"+rdObj[0].SumText(0,"zt4")+"</TOT_ZT4>";
		sXmlEtc +="</ETC>"
		sXml +=sXmlEtc;
		sXml +="</SHEET>";
		
		if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
		{
		    errMsg = 'No data found.';
		    showErrMessage(errMsg);
		    return;
		}
		rdObjects[0].AutoAdjust = true;
		//rdObjects[0].HideToolbar();
		//rdObjects[0].HideStatusbar();
		rdObjects[0].ViewShowMode(0);
				
		rdObjects[0].setbackgroundcolor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);			

		rdObjects[0].SetRData(sXml);
		rdObjects[0].FileOpen(RD_path+'apps/alps/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1011.mrd',RDServer);
		//rdObjects[0].FileOpen('http://localhost:7001/hanjin/apps/alps/ees/cgm/chassismgsetmgt/chassismgsetonoffhire/report/EES_CGM_1011.mrd',RDServer);
		
	}