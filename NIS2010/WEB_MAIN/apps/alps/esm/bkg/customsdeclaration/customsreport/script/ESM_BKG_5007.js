/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5007.js
*@FileTitle : ESM_BKG_5007.js
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.07 김도완
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
     * @class esm_bkg_0881 : esm_bkg_0881 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_5007() {
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
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
	         var rdObject = rdObjects[0];
	         
	         
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
                                          
    		switch(srcName) {

				case "btn_print":
					
					rdPrint(rdObject);
					
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage(vvd, pol, etd, to, fm, rmk, by, by2, by3) {
        
    	 rdOpen();
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        return true;
    }

	/*
	*Rd 설정
	*/
	function initRdConfig(rdObject){
		
		
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		//Rdviewer.style.height = 0;
		
		
	}
    
    
	/*
	* RD 오픈  및 미리보기
	*/
	function rdOpen(){
		if (document.form.typecode.value != "ALL"){
			var sXml = "";		
			var opener_obj = opener;
			var form1 = opener_obj.document.form;
			//alert();	
			var opener_sheet_obj1 =  opener_obj.document.sheet1;
			var opener_sheet_obj2 =  opener_obj.document.sheet2;
			var opener_sheet_obj3 =  opener_obj.document.sheet3;
			var opener_sheet_obj4 =  opener_obj.document.sheet4;
			var opener_sheet_obj5 =  opener_obj.document.sheet5;
	
			sXml = "<?xml version='1.0' ?><SHEET>"; 
			sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj2, 2);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj3, 3);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj4, 4);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj5, 5);
			sXml +="\n<ETC>" ;
			sXml +="<VVD>"+form1.vvd_cd_nm.value+"</VVD>";
			sXml +="<POL>"+form1.pol_cd_print.value+"</POL>";
			sXml +="<ETD>"+form1.vps_etd.value+"</ETD>";
			sXml +="<TO>"+form1.setText1.value+"</TO>";
			sXml +="<FM>"+form1.setText2.value+"</FM>";
			sXml +="<RMK>"+replaceAll(form1.remark.value)+"</RMK>";
			sXml +="<BY>"+form1.in_by_type.value+"</BY>";
			sXml +="<BY2>"+form1.in_by_type.value+"</BY2>";
			sXml +="<BY3>"+form1.in_by_type.value+"</BY3>";
			sXml +="</ETC>";
			sXml +="</SHEET>";
			
			//alert(sXml);
			
			
	
			//rdObjects[0].AutoAdjust = true;
			//rdObjects[0].HideToolbar();
			//rdObjects[0].HideStatusbar();
			//rdObjects[0].ViewShowMode(0); 
	
			//rdObjects[0].setbackgroundcolor(128,128,128);
			//rdObjects[0].SetPageLineColor(128,128,128);
			
			rdObjects[0].SetRData(sXml);
			var urlPath = RD_path+'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5007.mrd';
			
			//urlPath = "http://localhost:7001/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5007.mrd";
			
			rdObjects[0].FileOpen(urlPath ,RDServer);
		} else {
			ComOpenWait(true);
			rdObjects[0].SetAppendReport(1);
			
			var sXml = "";		
			var opener_obj = opener;
			var form1 = opener_obj.document.form;
			//alert();	
			var opener_sheet_obj1 =  opener_obj.document.sheet1;
			var opener_sheet_obj2 =  opener_obj.document.sheet2;
			var opener_sheet_obj3 =  opener_obj.document.sheet3;
			var opener_sheet_obj4 =  opener_obj.document.sheet4;
			var opener_sheet_obj5 =  opener_obj.document.sheet5;

			sXml = "<?xml version='1.0' ?><SHEET>"; 
			sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj2, 2);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj3, 3);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj4, 4);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj5, 5);
			sXml +="\n<ETC>" ;
			sXml +="<VVD>"+form1.vvd_cd_nm.value+"</VVD>";
			sXml +="<POL>"+form1.pol_cd_print.value+"</POL>";
			sXml +="<ETD>"+form1.vps_etd.value+"</ETD>";
			sXml +="<TO>"+form1.setText1.value+"</TO>";
			sXml +="<FM>"+form1.setText2.value+"</FM>";
			sXml +="<RMK>"+replaceAll(form1.remark.value)+"</RMK>";
			sXml +="<BY>"+form1.in_by_type.value+"</BY>";
			sXml +="<BY2>"+form1.in_by_type.value+"</BY2>";
			sXml +="<BY3>"+form1.in_by_type.value+"</BY3>";
			sXml +="</ETC>";
			sXml +="</SHEET>";
			rdObjects[0].SetRData(sXml);
			var urlPath = RD_path+'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5007.mrd';
			
			//urlPath = "http://localhost:7001/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5007.mrd";
			
			rdObjects[0].FileOpen(urlPath ,RDServer	+ " /rwait");
			
			opener_sheet_obj1 =  opener_obj.document.sheet9;
			opener_sheet_obj2 =  opener_obj.document.sheet7;
			opener_sheet_obj3 =  opener_obj.document.sheet8;
			sXml = "<?xml version='1.0' ?><SHEET>";
			var temp_sheet1 = RD_GetDataSearchXml(opener_sheet_obj1, 1);
			if( temp_sheet1.indexOf("<TR>") < 0){
				temp_sheet1 = "<SHEET1>  <DATA TOTAL='0'><TR></TR> </DATA></SHEET1>";
			}
			sXml +=temp_sheet1;
			sXml +=RD_GetDataSearchXml(opener_sheet_obj2, 2);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj3, 3);
			sXml +="\n<ETC>" ;
			sXml +="<VVD>"+form1.vvd_cd.value+"</VVD>";
			sXml +="<POL>"+form1.un_loc_cd.value+"</POL>";
			sXml +="<ETD>"+form1.vps_etd_dt.value+"</ETD>";
			sXml +="<GUBUN>"+"LOCAL"+"</GUBUN>";
			sXml +="<D2>"+form1.local_d2.value+"</D2>"; 
			sXml +="<D4>"+form1.local_d4.value+"</D4>"; 
			sXml +="<D5>"+form1.local_d5.value+"</D5>"; 
			sXml +="<D7>"+form1.local_d7.value+"</D7>"; 
			sXml +="<D8>"+form1.local_d8.value+"</D8>"; 
			sXml +="<D9>"+form1.local_d9.value+"</D9>"; 
			sXml +="<DW>"+form1.local_dw.value+"</DW>"; 
			sXml +="<DX>"+form1.local_dx.value+"</DX>"; 
			sXml +="<R2>"+form1.local_r2.value+"</R2>"; 
			sXml +="<R4>"+form1.local_r4.value+"</R4>"; 
			sXml +="<R5>"+form1.local_r5.value+"</R5>"; 
			sXml +="<F2>"+form1.local_f2.value+"</F2>"; 
			sXml +="<F4>"+form1.local_f4.value+"</F4>"; 
			sXml +="<F5>"+form1.local_f5.value+"</F5>"; 
			sXml +="<O2>"+form1.local_o2.value+"</O2>"; 
			sXml +="<O4>"+form1.local_o4.value+"</O4>"; 
			sXml +="<O5>"+form1.local_o5.value+"</O5>"; 
			sXml +="<S2>"+form1.local_s2.value+"</S2>"; 
			sXml +="<S4>"+form1.local_s4.value+"</S4>"; 
			sXml +="<T2>"+form1.local_t2.value+"</T2>"; 
			sXml +="<T4>"+form1.local_t4.value+"</T4>"; 
			sXml +="<A2>"+form1.local_a2.value+"</A2>"; 
			sXml +="<A4>"+form1.local_a4.value+"</A4>";
			sXml +="<A5>"+form1.local_a5.value+"</A5>";
			sXml +="<P2>"+form1.local_p2.value+"</P2>";
			sXml +="<P4>"+form1.local_p4.value+"</P4>";
			sXml +="<Z2>"+form1.local_z2.value+"</Z2>";
			sXml +="<Z4>"+form1.local_z4.value+"</Z4>";
			sXml +="<D3>"+form1.local_d3.value+"</D3>";
			sXml +="<R9>"+form1.local_r9.value+"</R9>";
			sXml +="<ETC1>"+form1.local_etc.value+"</ETC1>";
			sXml +="<TOTAL>"+form1.local_totalTpSize.value+"</TOTAL>";
			sXml +="<LOCAL>"+form1.local_local.value+"</LOCAL>";
			sXml +="<LOCALF>"+form1.local_localFull.value+"</LOCALF>";
			sXml +="<LOCALE>"+form1.local_localEmpty.value+"</LOCALE>";
			sXml +="<TS2>"+form1.local_ts.value+"</TS2>";
			sXml +="<TSF>"+form1.local_tsFull.value+"</TSF>";
			sXml +="<TSE>"+form1.local_tsEmpty.value+"</TSE>";
			sXml +="<WGT2>"+form1.local_wgt.value+"</WGT2>";
			
			sXml +="</ETC>";
			sXml +="</SHEET>";
			rdObjects[0].SetRData(sXml);
			var urlPath = RD_path+'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5008.mrd';
			
			//urlPath = "http://localhost:7001/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5008.mrd";
			
			rdObjects[0].FileOpen(urlPath ,RDServer + " /rwait");
			
			opener_sheet_obj1 =  opener_obj.document.sheet13;
			opener_sheet_obj2 =  opener_obj.document.sheet11;
			opener_sheet_obj3 =  opener_obj.document.sheet12;
			sXml = "<?xml version='1.0' ?><SHEET>";
			var temp_sheet1 = RD_GetDataSearchXml(opener_sheet_obj1, 1);
			if( temp_sheet1.indexOf("<TR>") < 0){
				temp_sheet1 = "<SHEET1>  <DATA TOTAL='0'><TR></TR> </DATA></SHEET1>";
			}
			sXml +=temp_sheet1;
			sXml +=RD_GetDataSearchXml(opener_sheet_obj2, 2);
			sXml +=RD_GetDataSearchXml(opener_sheet_obj3, 3);
			sXml +="\n<ETC>" ;
			sXml +="<VVD>"+form1.vvd_cd.value+"</VVD>";
			sXml +="<POL>"+form1.un_loc_cd.value+"</POL>";
			sXml +="<ETD>"+form1.vps_etd_dt.value+"</ETD>";
			sXml +="<GUBUN>"+"TS"+"</GUBUN>"; 
			sXml +="<D2>"+form1.ts_d2.value+"</D2>"; 
			sXml +="<D4>"+form1.ts_d4.value+"</D4>"; 
			sXml +="<D5>"+form1.ts_d5.value+"</D5>"; 
			sXml +="<D7>"+form1.ts_d7.value+"</D7>"; 
			sXml +="<D8>"+form1.ts_d8.value+"</D8>"; 
			sXml +="<D9>"+form1.ts_d9.value+"</D9>"; 
			sXml +="<DW>"+form1.ts_dw.value+"</DW>"; 
			sXml +="<DX>"+form1.ts_dx.value+"</DX>"; 
			sXml +="<R2>"+form1.ts_r2.value+"</R2>"; 
			sXml +="<R4>"+form1.ts_r4.value+"</R4>"; 
			sXml +="<R5>"+form1.ts_r5.value+"</R5>"; 
			sXml +="<F2>"+form1.ts_f2.value+"</F2>"; 
			sXml +="<F4>"+form1.ts_f4.value+"</F4>"; 
			sXml +="<F5>"+form1.ts_f5.value+"</F5>"; 
			sXml +="<O2>"+form1.ts_o2.value+"</O2>"; 
			sXml +="<O4>"+form1.ts_o4.value+"</O4>"; 
			sXml +="<O5>"+form1.ts_o5.value+"</O5>"; 
			sXml +="<S2>"+form1.ts_s2.value+"</S2>"; 
			sXml +="<S4>"+form1.ts_s4.value+"</S4>"; 
			sXml +="<T2>"+form1.ts_t2.value+"</T2>"; 
			sXml +="<T4>"+form1.ts_t4.value+"</T4>"; 
			sXml +="<A2>"+form1.ts_a2.value+"</A2>"; 
			sXml +="<A4>"+form1.ts_a4.value+"</A4>";
			sXml +="<A5>"+form1.ts_a5.value+"</A5>";
			sXml +="<P2>"+form1.ts_p2.value+"</P2>";
			sXml +="<P4>"+form1.ts_p4.value+"</P4>";
			sXml +="<Z2>"+form1.ts_z2.value+"</Z2>";
			sXml +="<Z4>"+form1.ts_z4.value+"</Z4>";
			sXml +="<D3>"+form1.ts_d3.value+"</D3>";
			sXml +="<R9>"+form1.ts_r9.value+"</R9>";
			sXml +="<ETC1>"+form1.ts_etc.value+"</ETC1>";
			sXml +="<TOTAL>"+form1.ts_totalTpSize.value+"</TOTAL>";
			sXml +="<LOCAL>"+form1.ts_local.value+"</LOCAL>";
			sXml +="<LOCALF>"+form1.ts_localFull.value+"</LOCALF>";
			sXml +="<LOCALE>"+form1.ts_localEmpty.value+"</LOCALE>";
			sXml +="<TS2>"+form1.ts_ts.value+"</TS2>";
			sXml +="<TSF>"+form1.ts_tsFull.value+"</TSF>";
			sXml +="<TSE>"+form1.ts_tsEmpty.value+"</TSE>";
			sXml +="<WGT2>"+form1.ts_wgt.value+"</WGT2>";
			
			sXml +="</ETC>";
			sXml +="</SHEET>";
			rdObjects[0].SetRData(sXml);
			var urlPath = RD_path+'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5008.mrd';
			
			//urlPath = "http://localhost:7001/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5008.mrd";
			
			rdObjects[0].FileOpen(urlPath ,RDServer + " /rwait");
			
			opener_sheet_obj1 =  opener_obj.document.sheet14;
			sXml = "<?xml version='1.0' ?><SHEET>";
			sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
			sXml +="\n<ETC>" ;
			sXml +="<VVD>"+form1.preview_vvd_cd.value+"</VVD>";
			sXml +="<POL>"+form1.preview_pol_cd.value+"</POL>";
			sXml +="<ETD>"+form1.preview_vps_etd.value+"</ETD>";
			sXml +="</ETC>";
			sXml +="</SHEET>";
			
			rdObjects[0].SetRData(sXml);
			var urlPath = RD_path+'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5006.mrd';
			
			//urlPath = "http://localhost:7001/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5006.mrd";
			
			rdObjects[0].FileOpen(urlPath ,RDServer + " /rwait");
			ComOpenWait(false);
		}
		
	}
	
	/**
	 * RD 출력
	 * @param rdObject
	 * @return
	 */
	function rdPrint(rdObject) {
		var Rdviewer = rdObject;
		
		Rdviewer.PrintDialog();
		//Rdviewer.CMPrint();
	}
	 
	 

	 function replaceAll(str){
		 var result = str;
		 result = result.split("&").join("&amp;"); 
		 result = result.split("<").join("&lt;"); 
		 result = result.split(">").join("&gt;"); 

	   return result; 
	 }
