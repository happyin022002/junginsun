/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0013.js
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.19 한동훈
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.03.12 권   민 [CHM-201216480] SAOSC의 인보이스 이슈 기능 개발 요청
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
     * @class fns_inv_0503 : fns_inv_0503 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0503() {
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
    
    var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject1 = sheetObjects[0];
    		         var sheetObject2 = sheetObjects[1];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
	                case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;								
					
				case "btn_new":
					ComResetAll();
					document.getElementById('del_flg').style.display='none';
					ComSetFocus(form.frm_cust_cnt_cd);	
					break;
				
				case "btn_Pop":
					var param = '?cust_cnt_cd='+formObject.frm_cust_cnt_cd.value+'&cust_seq='+formObject.frm_cust_seq.value+'&pop_yn=Y';
					var Row = 1;
					var Col = 1;
					//ComOpenPopupWithTarget('/hanjin/FNS_INV_0013.do'+param, 920, 660, 'getPopData', '0,1', false, false, Row, Col, 0);
					ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 660, 'getPopData', '0,0', false, false, "", "", 0);
					break;
					
				case "btn_close":
					window.close();
					break;
					
				case "btn_Print":
					rdOpen(rdObjects[0], formObject, "print");
					break;
					
				case "btn_Print_b":
					rdOpen2(rdObjects[0], formObject, "print");
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
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			//document.form.frm_cust_cnt_cd.focus();
//			if(document.form.pop_yn.value == "Y"){
//				doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
//			}
			initControl();
			
			//RD
			initRdConfig(rdObjects[0]);
		}


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
    				var sheetID = sheetObj.id;

            switch(sheetID) {

                case "sheet1":
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
                        InitRowInfo(1, 1, 2, 100);

                        var HeadTitle1 = "|sel|inv_no|cust_seq|cust_lgl_eng_nm|cust_lgl_eng_nm2";                        
    										var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        		var prefix="sheet1_";
                        		
                        		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
            					InitDataProperty(0, cnt++, dtDummyCheck, 	40,		daCenter, 	false,	"DelChk");
                        		InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"inv_no"			 ,	false,	"",	dfNone,	0,	true,	true);
								InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	false,	"cust_seq"               ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"cust_lgl_eng_nm"        ,	false,	"",	dfNone,	0,	false,	false);
								InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"cust_lgl_eng_nm2"       ,	false,	"",	dfNone,	0,	false,	false);
								
								//sheetObj.CellVale(-1,"inv_no") = "AAA";
								
								for(var i=1; i<=1; i++){
									var sheetIdx = sheetObj.DataInsert(-1);
									if(i==1){
										sheetObj.CellText(sheetIdx,"DelChk") = "1";
										sheetObj.CellText(sheetIdx,"inv_no") = "F80502014";
									}else{
										sheetObj.CellText(sheetIdx,"inv_no") = "HM1099613";
									}
								}
								
    				}
                    break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            	case IBSEARCH:      //조회				            		
            		if(validateForm(sheetObj,formObj,sAction) == false) return false;  
					if (sheetObj.id == "sheet1") {						
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch("FNS_INV_0013GS.do", FormQueryString(formObj));
					}
					
					if(sheetObj.RowCount > 0){
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
						
						formObj.frm_cr_amt.value = ComAddComma2(formObj.frm_cr_amt, "#,###.00");
						formObj.frm_cust_scr_locl_amt.value = ComAddComma2(formObj.frm_cust_scr_locl_amt, "#,###");
						
						if(formObj.frm_cust_cr_due_dt_div_cd.value == "S"){
							formObj.frm_cust_cr_due_dt_div_cd1.checked = true;
						}else if(formObj.frm_cust_cr_due_dt_div_cd.value == "I"){
							formObj.frm_cust_cr_due_dt_div_cd2.checked = true;
						}	
						if(formObj.frm_delt_flg.value == "Y"){
							//formObj.del_flg.style.display="";
							document.getElementById('del_flg').style.display='';
						}
						
						//frmRESULT.GAME_RESULT[i].checked=true;

						/*
						formObj.frm_grs_rgst_tong_wgt.value = ComAddComma2(formObj.frm_grs_rgst_tong_wgt, "#,###.00");
						formObj.frm_net_rgst_tong_wgt.value = ComAddComma2(formObj.frm_net_rgst_tong_wgt, "#,###.00");
						formObj.frm_dwt_wgt.value = ComAddComma2(formObj.frm_dwt_wgt, "#,###.00");
						formObj.frm_crw_knt.value = ComAddComma2(formObj.frm_crw_knt, "#,###");
						formObj.frm_loa_len.value = ComAddComma2(formObj.frm_loa_len, "#,###.00");
						*/
					} else {
						ComShowCodeMessage('BKG00221');
						/*
						for(var i=0; i<formObj.getElementsByTagName("input").length; i++) {
							if (formObj.getElementsByTagName("input")[i].name != "frm_vsl_cd") {
								formObj.getElementsByTagName("input")[i].value="";
							}
						}*/
					}
                break;
			}
        }        

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	if (ComIsNull(formObj.frm_cust_seq) && ComIsNull(formObj.frm_cust_rgst_no)) {
    				//ComShowCodeMessage('INV00041');
    				//ComSetFocus(form.frm_cust_cnt_cd);
    				//ComAlertFocus(formObj.frm_cust_seq, "Cust Code or BIZ RGST No. 중 하나를 입력하십시오.");
    				ComShowCodeMessage('INV00041');
    				ComSetFocus(form.frm_cust_seq);
    				return false;
    			}
    			if(!ComIsNull(formObj.frm_cust_seq) && ComIsNull(formObj.frm_cust_cnt_cd)){
    				ComShowCodeMessage('INV00041');
    				ComSetFocus(form.frm_cust_cnt_cd);
    				return false;
    			}
								
            }
            return true;
        }
		
		function validateForm2(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    			//기본포멧체크
    			/*
    			if(formObj.frm_cust_cnt_cd.value.length != 2) {
					ComShowCodeMessage('INV00041');
					ComSetFocus(form.frm_cust_cnt_cd);					
					return false;
				}
				*/				

            	if (ComIsNull(formObj.frm_cust_seq) && ComIsNull(formObj.frm_cust_rgst_no)) {
    				//ComShowCodeMessage('INV00041');
    				//ComSetFocus(form.frm_cust_cnt_cd);
    				//ComAlertFocus(formObj.frm_cust_seq, "Cust Code or BIZ RGST No. 중 하나를 입력하십시오.");
    				return false;
    			}
    			break;
    		case MULTI:

    			break;
    		}
        	return true;
    	}
        
        // 숫자만 입력가능
		function onOnlyNumber(obj)
		{
			/*
			 for (var i = 0; i < obj.value.length ; i++){
			  chr = obj.value.substr(i,1);  
			  chr = escape(chr);
			  key_eg = chr.charAt(1);
			  if (key_eg == ’u’){
			   key_num = chr.substr(i,(chr.length-1));   
			   if((key_num < "AC00") || (key_num > "D7A3")) { 
			    event.returnValue = false;
			   }    
			  }
			 }
			 */
			 if (event.keyCode >= 48 && event.keyCode <= 57) {
			  
			 } else {
			  event.returnValue = false;
			 }
		}	
			
		function isUpperCase(obj)
		{
			 if (event.keyCode < 48 || event.keyCode > 57) {
			  
			 } else {
			  event.returnValue = false;
			 }
		}		


		function getPopData(rowArray){
			var colArray = rowArray[0];	
			document.form.frm_cust_cnt_cd.value = colArray[1];
			document.form.frm_cust_seq.value = colArray[2];
		}
		
		//포커스이동
		function moveNext(id_from,id_to,maxSize) {			
			var cur = document.getElementById(id_from).value;
			curSize = cur.length;
			if (curSize == maxSize) {
				document.getElementById(id_to).focus();
			}
		}
		
		//Print start------------------------------------------------
		
		/*
		function initRdConfig1(rdObject){
			var Rdviewer = rdObject;
			Rdviewer.AutoAdjust = true;
			Rdviewer.ViewShowMode(0); 
			Rdviewer.setbackgroundcolor(128,128,128);
			Rdviewer.SetPageLineColor(128,128,128);
		}
		*/
		function initRdConfig(rdObject){
		    var Rdviewer = rdObject ;
		    
			//Rdviewer.AutoAdjust = true;
			//Rdviewer.ViewShowMode(0);
			Rdviewer.style.height = 600;
		
			Rdviewer.setbackgroundcolor(128,128,128);
			Rdviewer.SetPageLineColor(128,128,128);
		}
		

		
		function rdOpen(rdObject, formObject, viewType){
			
			var Rdviewer = rdObject ;	
			//var queryStr = RD_FormQueryString(formObject,1);
			//var inv_no = document.form.inv_no.value;
			var inv_no = "";
			var print_num = Number(document.form.print_num.value);	//프린트갯수
			var print_o = document.form.print_o.value;	//Y이면 paper만(origin&copy), N이면 copy
			var logo = "";	//ORIGINAL/COPY 문구
			var num2 = 0;
			if(print_o == "Y"){
				num2 = 1;
			}else{
				num2 = 0;
			}
			var user_nm = document.form.user_nm.value;
			var ofc_cd = document.form.ofc_cd.value;
			
			var rdFile = "";
			if (ofc_cd == "HAMSC") {
    			rdFile = "FNS_INV_0503.mrd";
    		} else if (ofc_cd == "GOASC") {
    			rdFile = "FNS_INV_0504.mrd";
    		} else if (ofc_cd == "ANRSO") {
    			rdFile = "FNS_INV_0505.mrd";
    		} else if (ofc_cd == "BUDSC") {
    			rdFile = "FNS_INV_0506.mrd";
    		} else if (ofc_cd == "RTMSC") {
    			rdFile = "FNS_INV_0507.mrd";
    		} else if (ofc_cd == "GDYSC") {
    			rdFile = "FNS_INV_0508.mrd";
    		} else if (ofc_cd == "PRGSC") {
    			rdFile = "FNS_INV_0509.mrd";
    		} else if (ofc_cd == "VLCSC") {
    			rdFile = "FNS_INV_0510.mrd";
    		} else if (ofc_cd == "SINSC") {
    			rdFile = "FNS_INV_0511.mrd";
    		} else if (ofc_cd == "PKGSC") {
    			rdFile = "FNS_INV_0512.mrd";
    		} else if (ofc_cd == "CMBSC") {
    			rdFile = "FNS_INV_0513.mrd";
    		} else if (ofc_cd == "BOMSC") {
    			rdFile = "FNS_INV_0514.mrd";
    		} else if (ofc_cd == "SYDSC") {
    			rdFile = "FNS_INV_0515.mrd";
    		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
    			rdFile = "FNS_INV_0516.mrd";
    		} else if (ofc_cd == "HKGSC") {
    			rdFile = "FNS_INV_0518.mrd";
    		} else if (ofc_cd == "LONBB") {
    			rdFile = "FNS_INV_0521.mrd";
    		} else if (ofc_cd == "LEHSC") {
    			rdFile = "FNS_INV_0522.mrd";
    		} else if (ofc_cd == "BOMSC") {
    			rdFile = "FNS_INV_0525.mrd";
    		} else if (ofc_cd == "SGNSC") {
    			rdFile = "FNS_INV_0520.mrd";
    		} else if (ofc_cd == "JKTSC") {
    			rdFile = "FNS_INV_0527.mrd";
    		} else if (ofc_cd == "SAOSC") {
    			rdFile = "FNS_INV_0542.mrd";
    		}
			
			rdFile = "FNS_INV_0503.mrd";
			//alert("ofc_cd : "+ofc_cd+" - rdFile : "+rdFile);
			
			Rdviewer.SetAppendReport(1);
			//Rdviewer.SetReportDialogInfo (1,"서버에 접속중입니다", "서버접속중", 1, "보고서를 작성중입니다", "보고서작성중");
			//sheetObjects[0].WaitImageVisible = false; 
			ComOpenWait(true);
			for (var i=1; i<=sheetObjects[0].RowCount; i++) {
				inv_no = sheetObjects[0].CellValue(i,"inv_no");
				var chk = sheetObjects[0].CellValue(i,"DelChk");
				if(chk == "1"){
					for(var k=0; k<print_num+num2; k++){
						if(k==0 && num2==1){
							logo = "ORIGINAL";
						}else{
							logo = "COPY";
						}						
						//var rdParam = "/rv " + "frm1_inv_no["+inv_no+"] frm1_print_num["+print_num+"] frm1_print_o["+print_o+"] frm1_cnt["+i+"]";
						var rdParam = "/rv " + "frm1_inv_no["+inv_no+"] frm1_print_num["+print_num+"] frm1_print_o["+print_o+"] frm1_logo["+logo+"] frm1_login_nm["+user_nm+"] frm1_ofc_cd["+ofc_cd+"] frm1_vsl_cd[HNOT] frm1_skd_voy_no[0064] frm1_skd_dir_cd[W] frm1_port_cd [DEHAM] frm1_att_gb [Y]";
						//rdParam = "/rv frm1_inv_no[HM1281365] frm1_logo["+logo+"] frm1_login_nm [TES_HAMSC] frm1_ofc_cd [HAMSC] frm1_line_num [15] frm1_vsl_cd[HNOT] frm1_skd_voy_no[0064] frm1_skd_dir_cd[W] frm1_port_cd [DEHAM] frm1_att_gb [Y]";
						var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";																	

						//alert(RDServer + rdParam + " /rop /rprintnexit ");
						 
						//Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam +  + " /rop /rprintnexit ");
						//Rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam + " /rop /rprintnexit ");
						Rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");	// /rop
						//Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ " /riprnmargin /rwait");
					}
				}
			}
			ComOpenWait(false);
			//sheetObjects[0].WaitImageVisible = true;
			//Rdviewer.SetAppendReport(0);
			//Rdviewer.SaveAsPdfFile("C:\\a.pdf"); //PDF 파일로 저장
			//Rdviewer.SaveAsWordFile ("C:\\a.doc");	//MS Word 파일로 저장
			//Rdviewer.SaveAsPptFile ("C:\\a.ppt"); //PowerPoint 파일로 저장
			//Rdviewer.SaveAsHwpFile ("C:\\a.hwp"); //HWP 파일로 저장
			//Rdviewer.SaveAsDialog();
			//Rdviewer.PrintDialog(); // 버튼 클릭시 print box - 프린트 선택가능
			//Rdviewer.SetPrintInfo ("HP LaserJet 8150 PCL 6", 2, 1, 4); // 출력할 프린터를 강제로 지정하여 출력
			//Rdviewer.CMPrint(); // 기본 프린터로 출력
			//Rdviewer.ViewPdf();
			//Rdviewer.SaveAsMrrFile("C:\\a.mrr"); //PDF 파일로 저장
			
			
		}
		
		function rdOpen2(rdObject, formObject, viewType){
			var Rdviewer = rdObject ;
			var inv_no = sheetObjects[0].CellValue(1,"inv_no");
			var ofc_cd = document.form.ofc_cd.value;
			var frm1_inv_gb = document.form.frm1_inv_gb.value;
			var tot_amount = "5270288.94";
			//tot_amount = "520.00";
			//tot_amount = "453308.00";
			tot_amount = "1829000.00";

			var amount = sgnAmount(frm1_inv_gb,tot_amount);		
			//alert(tot_amount+"::"+amount);
			//return false;

			var rdParam = "/rv " + "frm1_inv_no["+inv_no+"] frm1_ofc_cd ["+ofc_cd+"] frm1_inv_gb["+frm1_inv_gb+"] frm1_amount["+amount+"]";
			var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
			var rdFile = "FNS_INV_0520_SINGLE.mrd";
			//alert(rdParam);

			Rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");

			//Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");								
			//Rdviewer.CMPrint();	
		}
		
		function sgnAmount(inv_gb, amount){		 
	    	 var amount = replaceAll(amount+"",',','');
	    	 var chn_amount = "";
	    	 var r_unit = "";
	    	 var array_data = amount.split(".");  
	    	 var a_pnt = array_data[0];	//.앞에 정수
	    	 var b_pnt = array_data[1];	//.뒤에 소수
	    	 var tmp_iDiv1 = "0";
	    	 var tmp_iDiv2 = "0";

	    	//정수 변환
	    	 var a_length = a_pnt.length;
	    	 var a_unit = "";
	    	 var ak_length = "";
	    	 var a1 = 0;
	    	 var a2 = 0;
	    	 for(i=0; i<a_length; i++){
	    		 a1 = Number(a_pnt)%10;
	    		 a2 = Number(a_pnt)/10;
	    		 
	    		 a_unit = a_pnt.substr(i, 1);
	    		 if(a_unit == "1"){
	    			 r_unit = r_unit + " MỘT";
	    		 }else if(a_unit == "2"){
	    			 r_unit = r_unit + " HAI";
	    		 }else if(a_unit == "3"){
	    			 r_unit = r_unit + " BA";
	    		 }else if(a_unit == "4"){
	    			 r_unit = r_unit + " BỐN";
	    		 }else if(a_unit == "5"){
	    			 r_unit = r_unit + " NĂM";
	    		 }else if(a_unit == "6"){
	    			 r_unit = r_unit + " SÁU";
	    		 }else if(a_unit == "7"){
	    			 r_unit = r_unit + " BẢY";
	    		 }else if(a_unit == "8"){
	    			 r_unit = r_unit + " TÁM";
	    		 }else if(a_unit == "9"){
	    			 r_unit = r_unit + " CHÍN";
	    		 }	    		 	    		 
	    		 
	    		//금액단위
	    		 //if(a_unit != "0"){
	    		 if((i == 1 || i == 4 || i == 7)){
	    		 //alert(a_unit+"="+tmp_iDiv1+"::"+tmp_iDiv2+"::"+a1+"::"+i);
	    		 }
	    		 if(tmp_iDiv1 == "0" && tmp_iDiv2 != "0" && (i == 1 || i == 4 || i == 7)){
	    			 r_unit = r_unit + " LẺ";
	    		 }else{
	    			 ak_length = a_length - i;
	    			 if(ak_length == "2"){
	    				 if(a1 == "1"){
	    					 r_unit = r_unit + " MƯỜI";
	    				 }else{
	    					 r_unit = r_unit + " MƯƠI";
	    				 }
	    			 }else if(ak_length == "3"){
	    				 r_unit = r_unit + " TRĂM";
	    			 }else if(ak_length == "4"){	    				 
	    				 r_unit = r_unit + " NGÀN";
	    			 }else if(ak_length == "5"){
	    				 if(a1 == "1"){
	    					 r_unit = r_unit + " MƯỜI";
	    				 }else{
	    					 r_unit = r_unit + " MƯƠI";
	    				 }
	    			 }else if(ak_length == "6"){
	    				 r_unit = r_unit + " TRĂM";
	    			 }else if(ak_length == "7"){
	    				 r_unit = r_unit + " TRIỆU";
	    			 }else if(ak_length == "8"){
	    				 if(a1 == "1"){
	    					 r_unit = r_unit + " MƯỜI";
	    				 }else{
	    					 r_unit = r_unit + " MƯƠI";
	    				 }
	    			 }else if(ak_length == "9"){
	    				 r_unit = r_unit + " TRĂM";
	    			 }else if(ak_length == "10"){
	    				 r_unit = r_unit + " NGÀN";
	    			 }    			 
	    			 
	    			 /*else if(ak_length == "4"){
	    				 r_unit = r_unit + " MỘT NGÀN";
	    			 }else if(ak_length == "5"){
	    				 r_unit = r_unit + " MƯỜI NGÀN";
	    			 }else if(ak_length == "6"){
	        			 r_unit = r_unit + " MỘT TRĂM NGÀN";
	    			 }else if(ak_length == "7"){
	        			 r_unit = r_unit + " MỘT TRIỆU";
	    			 }	*/ 
	    		 }
	    		 tmp_iDiv2 = tmp_iDiv1;							
					
                 tmp_iDiv1 = a1;	
	    	 }	  
	    	 
	    	//소수 변환
	    	 var b_length = b_pnt.length;    	 
        	 var b_unit = "";
        	 var bk_length = "";
        	 if(replaceAll(b_pnt,0,"").length == 0){
        		 if(inv_gb == "FRT"){
	    			 r_unit = r_unit + " ĐÔ MỸ";
	    		 }else{
	    			 r_unit = r_unit + " ĐỒNG";
	    		 }
        	 }else{	 
        		 var tmp1 = "";
        		 var tmp2 = "";
	    		 for(i=0; i<b_length; i++){
	    			 tmp1 = b_pnt.substr(0, 1);
	    			 tmp2 = b_pnt.substr(1, 1);	    			 
	    			 b_unit = b_pnt.substr(i, 1);
		    		 if(b_unit == "1"){
		    			 r_unit = r_unit + " MỘT";
		    		 }else if(b_unit == "2"){
		    			 r_unit = r_unit + " HAI";
		    		 }else if(b_unit == "3"){
		    			 r_unit = r_unit + " BA";
		    		 }else if(b_unit == "4"){
		    			 r_unit = r_unit + " BỐN";
		    		 }else if(b_unit == "5"){
		    			 if(i==0 && tmp2 != "0"){
		    				 r_unit = r_unit + " LĂM";
		    			 }else{
		    				 r_unit = r_unit + " NĂM";
		    			 }	 
		    		 }else if(b_unit == "6"){
		    			 r_unit = r_unit + " SÁU";
		    		 }else if(b_unit == "7"){
		    			 r_unit = r_unit + " BẢY";
		    		 }else if(b_unit == "8"){
		    			 r_unit = r_unit + " TÁM";
		    		 }else if(b_unit == "9"){
		    			 r_unit = r_unit + " CHÍN";
		    		 }
	    		 }
        	 }
	    	 
	    	 chn_amount = chn_amount + r_unit;
	    	 return chn_amount;
	     }
		
		function replaceAll(strTemp, strValue1, strValue2){
			while(1){
			    if( strTemp.indexOf(strValue1) != -1 ){
			       strTemp = strTemp.replace(strValue1, strValue2);
			    }else{
			       break;
			    }   
			}
		   	return strTemp;   	 
		}
		//Print end------------------------------------------------
			
	/* 개발자 작업  끝 */