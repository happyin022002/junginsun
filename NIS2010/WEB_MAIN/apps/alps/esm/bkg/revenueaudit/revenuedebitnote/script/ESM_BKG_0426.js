/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0426.js
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
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
     * @class esm_bkg_0426 : esm_bkg_0426 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0426() {
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
    var sheet1;
    var sheet2; // 메일용
    
    //
    var gIsMailSend = false;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    //search xml
    var searchXml;
    
    //event status
    var eventStatus = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject1 = sheetObjects[0];
             var sheetObject2 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    					case "btn_RowAdd":
    						doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
    						break;
    						
    					case "btn_Delete":
    						doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
    						break;

    					case "btn_Retrieve":
    						//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    						if(formObject.rdn_no_cd.GetCount () == 0 || getRdnNoTxt() != formObject.rdn_no) {
    							setRdnCd();
    						} else {
    							//removeSearch(formObject);
    							doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    						}
    				 		break;
    						
    					case "btn_New":
    						removeAll(document.form);
    						break;
    						
    					case "btn_Save":
    						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
    						break;
    						
    					case "btn_Issue":
       						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
    						break;
    					
    					case "btn_ReIssue":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
    						break;
    						
    					case "btn_Revise":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
    						break;
    					
    					case "btn_Cancel":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
    						break;
    					
    					case "btn_Vcancel":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC08);
    						break;
    						
    					case "btn_Settle":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC05);
    						break;
    						
    					case "btn_Copy":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC06);
    						break;	
    						
    					case "btn_Print":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC07);
    						break;
    						
    					case "btn_Attachment":
    						var rdn_no = formObject.rdn_no.value;
    						var rvis_seq = formObject.rvis_seq.value;
    						var edit_flg = "Y";
//    						if(){
//    							edit_flg = "N";
//    						}
    						
    						var url = "ESM_BKG_1408.do?rdn_no="+rdn_no+"&rvis_seq="+rvis_seq+"&edit_flg="+edit_flg;
    						ComOpenWindowCenter(url, "ESM_BKG_1408", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    						break;
    					
    					case "btn_Close":
    						window.close();
    						break;
    						
    						
    					case "btn_mail":
    					    openGroupWareMailPopup(sheetObjects[0], formObject);

    						var bkg_no = formObject.bkg_no.value;
    						var url = "ESM_BKG_0369.do?bkg_no="+bkg_no;
    						ComOpenWindowCenter(url, "ESM_BKG_0369", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
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
         * IBSheet Object를 배열로 등록 <br>
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setSheetObject(sheetObj);
         * </pre>
         * @param {ibsheet} sheet_obj 필수 IBSheet Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */ 
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;
    			
        }

        /**
         * IBMulti Combo Object를 배열로 등록 <br>
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setComboObject(combo_obj);
         * </pre>
         * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++] = combo_obj;
     	}
        
        /**
         * Sheet 기본 설정 및 초기화 <br>
         * body 태그의 onLoad 이벤트핸들러 구현 <br>
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     loadPage();
         * </pre>
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function loadPage() {
        	var form = document.form;
       	    sheet1 = sheetObjects[1]; //usd amount
       	    sheet2 = sheetObjects[2]; //메일용

    		//IBMultiCombo초기화
     	    for(var k = 0; k < comboObjects.length; k++){
     	        initCombo(comboObjects[k], k + 1);
     	    }
       	    
    		for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
     		}
    		
     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
     	    //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);     		
     	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	         	    
     	    
     	    setSumTxt(sheetObjects[1]);
     	    
     	    toggleButtons("");
     	    
     	    initIBComboItem();
     	    
     	    form.rdn_no_cd.focus();
     	    
     	    //pop으로 호출시 rdn_no로 로딩시 조회
 	    	if(form.rdn_no_pop.value != ""){
 	    		
    			var rdn_no = form.rdn_no_pop.value.toUpperCase();
    			var code = form.rdn_no_cd.FindIndex(rdn_no, 0);
    			if(code == "-1") {	
    				eventStatus = "INIT";
    				form.rdn_no_cd.InsertItem(0,rdn_no);
    				form.rdn_no_cd.Text = rdn_no;
    				eventStatus = "";
    			}
 	    	
    			setRdnCd();    			

     	    }
     	    
     	    var rctRhqCdPopValue = form.rct_rhq_cd_pop.value;
     	    var rctOfcCdPopValue = form.rct_ofc_cd_pop.value;
     	    
 	    	form.rct_rhq_cd.Code = rctRhqCdPopValue;
 	    	form.rct_ofc_cd.Code = rctOfcCdPopValue;
// 	    	form.respb_rhq_cd.Code = rctRhqCdPopValue;
 	    	form.respb_ofc_cd.Code = rctOfcCdPopValue;
     	    
     	    //김대호 - rd 테스트
     	    //form.bl_no.value = "AARE01025401";
     	    //setRdnCd();
 	    	
			ComOpenWait(false);
    	    
    	}
        
        
        /**
         * bl_no로 콤보를 조회 후 첫번째 값으로 세팅한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     setRdnCd();
         * </pre>
         * @param 없음
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function setRdnCd() {
        	
        	var formObject = document.form;
        	
        	if (validateForm(sheetObjects[0],formObject,IBSEARCH)) {
				//rdn combo의 값을 hidden에 세팅
				//formObject.rdn_no.value = comboObjects[0].Code;
				
	        	formObject.f_cmd.value = SEARCH01;
		 		searchXml = sheetObjects[0].GetSearchXml("ESM_BKG_0426GS.do", FormQueryString(formObject));
		 		
		 		//화면 리셋
				removeSearch(formObject);
		 		
		 		ComXml2ComboItem(searchXml, formObject.rdn_no_cd, "rdn_no", "rdn_no");

		 		if(form.rdn_no_cd.GetCount () > 0) {
		 			form.rdn_no_cd.Index = "-1";
		 			form.rdn_no_cd.Index = "0";

					if(gIsMailSend) {
						gIsMailSend = false;

						openGroupWareMailPopup(sheetObjects[0], formObject);
						
						//메일발송위해 리스트 가져옴.
						// 현업 요청으로 임시 메일 보내는 것을 막아 놓았음.
//						doActionIBSheet2(sheet2, document.form, IBSEARCH);
					}
		 			
		 		} else {
		 			ComShowCodeMessage("BKG95010");
		 		}
        	}
        }	
        
        /**
         * RDN No로 조회한 후 리턴된 xml을 화면에 세팅한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     setSearchData(searchXml, formObj)
         * </pre>
         * @param {String} searchXml
         * @param {form} formObj
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function setSearchData(searchXml, formObj) {
        	
        	var arrData = ComBkgXml2Array(searchXml,  "rdn_no|rvis_seq|iss_ofc_cd|rdn_sts_cd|rdn_iss_dt|sts_upd_dt" +   //5
							"|rct_rhq_cd|rct_ofc_cd|respb_ofc_cd|umch_tp_cd|umch_sub_tp_cd" +                           //10
							"|rdn_iss_rsn_cd|sc_rfa_no|umch_rmk|rdn_rmk|rdn_sts_nm" +                                   //15
							"|bkg_no|bkg_no_split|bkg_corr_no|prog_seq|bl_no" +                                         //20
							"|respb_rhq_cd|rev_aud_tool_cd|ctrt_tp_cd|rdn_iss_dt_wk|rdn_knd_cd"+                        //25
							"|inv_no|vvd_cd|n3pty_no|atch_file_lnk_id|file_cnt");
        	
        	if (arrData != null && arrData.length > 0) {
        	
	        	formObj.rdn_no.value		= arrData[0][0];
	        	formObj.rvis_seq.value		= arrData[0][1];
	        	formObj.rdn_knd_cd.Code     = arrData[0][25];
	        	
	        	if(arrData[0][2] != "")	formObj.iss_ofc_cd.value = arrData[0][2];
				formObj.rdn_sts_cd.value  	= arrData[0][3];
				formObj.rdn_iss_dt.value 	= arrData[0][4];
				formObj.rdn_iss_dt_wk.value = arrData[0][24];				
				formObj.sts_upd_dt.value 	= arrData[0][5];

				//조직도 콤보1		
				formObj.rct_rhq_cd.Code 		    = arrData[0][6];
				formObj.rct_ofc_cd_hidden.value 	= arrData[0][7];
				formObj.respb_ofc_cd_hidden.value 	= arrData[0][8];
				
				formObj.respb_rhq_cd.Code 	= arrData[0][21];
				formObj.rev_aud_tool_cd.Code 	= arrData[0][22];
				formObj.ctrt_tp_cd.value = arrData[0][23];
				
				formObj.umch_tp_cd.Code					= arrData[0][9];
				formObj.umch_sub_tp_cd_hidden.value 	= arrData[0][10];
				formObj.rdn_iss_rsn_cd.Code				= arrData[0][11];
				
				formObj.sc_rfa_no.value 	= arrData[0][12];
				formObj.umch_rmk.value 		= arrData[0][13];
				formObj.rdn_rmk.value 		= arrData[0][14];
				formObj.rdn_sts_nm.value 	= arrData[0][15];
				
				//BOOKING
				formObj.bkg_no.value 		= arrData[0][16];
				formObj.bkg_no_split.value 	= arrData[0][17];
				formObj.bkg_corr_no.value 	= arrData[0][18];
				formObj.inv_no.value        = arrData[0][26];
				formObj.vvd_cd.value        = arrData[0][27];
				formObj.n3pty_no.value  = arrData[0][28];
				formObj.atch_file_lnk_id.value = arrData[0][29];
				formObj.file_cnt.value = arrData[0][30];
				
				//prog_seq
				formObj.prog_seq.value 		= arrData[0][19];
				
				//bl_no
				formObj.bl_no.value 		= arrData[0][20];
				
				//하위 콤보 조회 위해 콤보 코드 세팅 
				formObj.etc1.value		= arrData[0][9];
				formObj.etc2.value		= arrData[0][6];
        	}	
			
			return arrData;
        }
        
        /**
         * IBSHEET COMBO를 LOAD하는 함수<br>
         * <br><b>Example :</b>
         * <pre>
         * 		initCombo(comboObj, comboNo)
         * </pre>
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */ 
        function initCombo(comboObj, comboNo) {
            switch(comboObj.id) {
            
            case "rdn_no_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 1);    // 영문대문자만 입력 + 숫자만 입력
                    MaxLength = 10;      // 10자리만 입력
                }
                break;
                
            case "rct_rhq_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;    
            
            case "rct_ofc_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;
                
            case "respb_rhq_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;      
                
            case "respb_ofc_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;  
                
            case "umch_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 0);    // 영문만 입력
                }
                break;    
            
            case "umch_sub_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 0);    // 영문만 입력
                }
                break;       
                
            case "rdn_iss_rsn_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 0);    // 영문만 입력
                }
                break;     
                
            case "rev_aud_tool_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);    // 영문만 입력 + 특수문자
                }
                break;   
                
            case "rdn_knd_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 0);    // 영문만 입력 + 특수문자
                }
                break;
            }
      	}
        
        /**
         * comboObjects[0]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRdnNoCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRdnNoCd() {
      		return comboObjects[0].Code;
      	}
        
        /**
         * comboObjects[0]의 Text값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var Text = getRdnNoTxt();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRdnNoTxt() {
      		return comboObjects[0].Text;
      	}
        
        
        /**
         * comboObjects[2]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRctRhqCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRctRhqCd() {
      		return comboObjects[2].Code;
      	}
        
        /**
         * comboObjects[3]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRctOfcCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRctOfcCd() {
      		return comboObjects[3].Code;
      	}
        
        /**
         * comboObjects[4]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRespbRhqCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRespbRhqCd() {
        	 
      		return comboObjects[4].Code;
      	}
        
        /**
         * comboObjects[5]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRespbOfcCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRespbOfcCd() {
      		return comboObjects[5].Code;
      	}
        
        /**
         * comboObjects[6]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getUmchTpCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getUmchTpCd() {
      		return comboObjects[6].Code;
      	}
        
        /**
         * comboObjects[7]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getUmchSubTpCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getUmchSubTpCd() {
      		return comboObjects[7].Code;
      	}
        
        /**
         * comboObjects[8]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRdnIssRsnCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRdnIssRsnCd() {
      		return comboObjects[8].Code;
      	}
        
        /**
         * 이벤트가 발생시 rct_ofc_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		setOfcCd();
         * </pre>
         * @param 없음
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */ 
        function setOfcCd() {
        	var formObj = document.form;
        	// 조직도 combo2
        	formObj.f_cmd.value = COMMAND02;
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.rct_ofc_cd, "cd", "cd");
			//조회한 히든 값으로 세팅
			formObj.rct_ofc_cd.Code  		= formObj.rct_ofc_cd_hidden.value;
        }
        
        
        /**
         * 이벤트가 발생시 rct_ofc_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		setOfcCd2();
         * </pre>
         * @param 없음
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */ 
        function setOfcCd2() {
        	var formObj = document.form;
        	
			// 조직도 combo4
			formObj.f_cmd.value = COMMAND02;
			formObj.etc2.value = getRespbRhqCd();
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.respb_ofc_cd, "cd", "cd");
			//조회한 히든 값으로 세팅
			formObj.respb_ofc_cd.Code  		= formObj.respb_ofc_cd_hidden.value;
	
        }
        
        /**
         * 이벤트가 발생시 umch_sub_tp_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		setUmchSubCd();
         * </pre>
         * @param 없음
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
        function setUmchSubCd() {
        	var formObj = document.form;
        	var errorKind2 = formObj.umch_sub_tp_cd; 
 			formObj.f_cmd.value = COMMAND05;
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			errorKind2.RemoveAll();
			ComXml2ComboItem(sXml, errorKind2, "cd", "nm");
			
			if(formObj.umch_tp_cd.Code == 'D'){
				errorKind2.InsertItem(0, "", "");
			}
			
			//조회한 히든 값으로 세팅
			errorKind2.Code = formObj.umch_sub_tp_cd_hidden.value;
			if(errorKind2.Index == "-1" && errorKind2.GetCount() > 0) {
				errorKind2.Index = "0";
			}
        }
        
        
        /**
         * rdn_no combo 변경시 활성화됨<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function rdn_no_cd_OnChange(comboObj, code, text) {
        	
        	if(eventStatus == "INIT") return;
        	
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
     				var formObj = document.form;
     				
     				formObj.rdn_no.value = code;
     				
       		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		 				
     				
     			} 
     		 
     		} 
     		
       }
        
        /**
         * rdn_no_combo text를 대문자로 변환한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param 없음
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function setUpperCaseRdnNo() {
        	
        	if(ComIsEmpty(getRdnNoTxt())) return;
        	
			var rdn_no = getRdnNoTxt().toUpperCase();
			
			comboObjects[0].Text2 = rdn_no;
		
       }
        
        /**
         * rdn_no combo 포커스 아웃시 동작함<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
        function rdn_no_cd_OnBlur(comboObj) {
        	
        	if(ComIsEmpty(getRdnNoTxt())) return;
        	
			var rdn_no = getRdnNoTxt().toUpperCase();
			
			var code = comboObj.FindIndex(rdn_no, 0);
			
			if(code == "-1") {	
				//combo item insert
				eventStatus = "INIT";
				comboObj.InsertItem(0,rdn_no);
				comboObj.Text = rdn_no;
				//document.form.bl_no.focus();
				eventStatus = "";
			}	
			
       }
        
 /** 
 * Object 의 Keypress 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음  
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2010.01.04
 */ 
 function obj_keypress(){
 	var obj = event.srcElement;
 	var objName = obj.getAttribute("name");

  	if(obj.dataformat == null) return;
  	window.defaultStatus = obj.dataformat;
 	switch(obj.dataformat){
  	case "ymd": //날짜 입력하기
 		ComKeyOnlyNumber(obj,"-"); 
 		break;
  	case "int": //숫자만 입력
  	case "number": //숫자만 입력 	
  		ComKeyOnlyNumber(obj);
  		break;
  	case "engup":
  		ComKeyOnlyAlphabet('upper');
  		break;
  	case "uppernum":
  		ComKeyOnlyAlphabet('uppernum');
  		break;
  	default:
  		//ComKeyOnlyNumber(obj);
  		break;
 	}

  	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	switch(objName){
  	case "bl_no":
	 	if(ComIsEmpty(obj.value)) { return; }
	  	if(keyValue == 13 && obj.value.length == 12){
	 		var btnObj = document.getElementById("btn_retrieve");
	 		if (btnObj) { btnObj.fireEvent("onclick"); }
	  	}
 		break;
 	}
 }         
        
 /** 
 * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음  
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2010.01.04
 */ 
 function obj_deactivate() {
 	var form = document.form;
 	var formObj = event.srcElement;
     var srcName = formObj.getAttribute("name");
     switch(srcName) {
 		case "bl_no":
         	if(ComIsEmpty(formObj.value)) return;
         	var msg = formObj.caption;
 			if(formObj.value.length != formObj.maxLength) {
 				ComShowCodeMessage("BKG95018", msg, formObj.maxLength);
 				ComSetFocus(formObj);
 				return false;
 			} 
 			break;
 		case "inv_no":
 		case "vvd_cd":
 			break;
 		default :
 			ComChkObjValid(formObj);
 	}
 }
        
         /**
         * rct_rhq_cd combo 변경시 활성화됨<br>
         * qttn_ver_no로 조회한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function rct_rhq_cd_OnChange(comboObj, code, text) {
        		
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			
 				var formObj = document.form;
 				formObj.etc2.value 	= code;
 				
 				//조회 상태가 아니면
 				if(eventStatus != "IBSEARCH") {
 					
 	     			//하위 오피스 콤보 세팅
	 				setOfcCd();
	 				
 				}	
     			
     		} 
     		
       	}
        

        
        /**
         * rdn_knd_cd combo 포커스 아웃시 동작함<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
      	function rdn_knd_cd_OnChange(comboObj) {
      		
    		var formObj = document.form;   		

			if(eventStatus != "IBSEARCH") {// Unmatch Type Code
	        	formObj.f_cmd.value = COMMAND04;
				var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
	 			ComXml2ComboItem(sXml, formObj.umch_tp_cd, "cd", "nm");	
	 			formObj.umch_sub_tp_cd.removeAll();
			}
    	}
        
        /**
         * rct_rhq_cd combo 포커스 아웃시 동작함<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
      	function rct_rhq_cd_OnBlur(comboObj) {
      		
    		var formObj = document.form;
    		
    		var code = comboObj.FindIndex(comboObj.Code, 0);
    		//alert(code)
    		if (code != null && code != "") {
    			//조회된 값이 없으면
				if(formObj.respb_rhq_cd.GetCount () > 0 && formObj.respb_rhq_cd.Index == "-1") {
					formObj.respb_rhq_cd.Text = comboObj.Text
     			}
    		}
    	}
        
      	
      	/**
         * rct_ofc_cd combo 포커스 아웃시 동작함<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
      	function rct_ofc_cd_OnBlur(comboObj) {
      		
    		var formObj = document.form;
    		
    		var code = comboObj.FindIndex(comboObj.Code, 0);
    		//alert(code)
    		if (code != null && code != "") {
    			//조회된 값이 없으면
				if(formObj.respb_ofc_cd.GetCount () > 0 && formObj.respb_ofc_cd.Index == "-1") {
					formObj.respb_ofc_cd.Text = comboObj.Text
     			}
    		}
    	}
        
        
        /**
         * respb_rhq_cd combo 변경시 활성화됨<br>
         * qttn_ver_no로 조회한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function respb_rhq_cd_OnChange(comboObj, code, text) {
        		
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			
 				var formObj = document.form;
 				
 				formObj.etc2.value 	= code;
 				
 				//조회 상태가 아니면
				if(eventStatus != "IBSEARCH") {
 					// 조직도 combo2
 		        	formObj.f_cmd.value = COMMAND02;
 					var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
 					// 조직도 combo3
 		 			ComXml2ComboItem(sXml, formObj.respb_ofc_cd, "cd", "cd");
 		 			formObj.respb_ofc_cd.Code  		= formObj.respb_ofc_cd_hidden.value;
 				}	
     			
     		} 
     		
       	}
        
        
        /**
         * umch_tp_cd combo 변경시 활성화됨<br>
         * qttn_ver_no로 조회한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function umch_tp_cd_OnChange(comboObj, code, text) {
        		
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			
 				var formObj = document.form;
 				formObj.etc1.value 	= code;
 				
 				//조회 상태가 아니면
 				if(eventStatus != "IBSEARCH") {
 					//하위 콤보 세팅
 	 				setUmchSubCd();
 				}	
 				
			} 
     		
       	}
        
        
        
        /**
         * 저장시  bkg 관련 데이터 조회 해서 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		searchBlno(formObj)
         * </pre>
         * @param {form} formObj  
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function searchBlno(formObj) {
        
        	if(ComIsEmpty(formObj.bkg_no)) {
        	
	        	formObj.f_cmd.value = SEARCH05;
				var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0426GS.do", FormQueryString(formObj));
				
				
				var arrData = ComBkgXml2Array(sXml,  "bkg_no|bkg_no_split");
		
    			if (arrData != null && arrData.length > 0) {
				
					//BOOKING
					formObj.bkg_no.value 		= arrData[0][0];
					formObj.bkg_no_split.value 	= arrData[0][1];
    			}
    			
        	}	
        }
        
    	/**
    	 * Invoice Number Validation  
    	 */
    	function validateInvoiceNumber(formObj) {
        	if(ComIsEmpty(formObj.inv_no)) {
        		return true;        		
        	} else {
        		formObj.f_cmd.value = COMMAND10;
        		formObj.input_text.value = formObj.inv_no.value;
    			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
    			
    			if(ComGetEtcData(sXml, "output_text") == "Y"){
    				return true;
    			} else {
    				ComShowCodeMessage("BKG00651", "Invoice Number"); // "Invoice Number is Invlaid."
    				return false;
    			}    			
        	}
        	
    	}
    	
    	/**
    	 * VVD Validation  
    	 */
    	function validateVVD(formObj) {
        	if(ComIsEmpty(formObj.vvd_cd)) {
        		return true;        		
        	} else {
        		formObj.f_cmd.value = COMMAND11;
        		formObj.input_text.value = formObj.vvd_cd.value;
    			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
    			
    			if(ComGetEtcData(sXml, "output_text") == "Y"){
    				return true;
    			} else {
    				ComShowCodeMessage("BKG00651", "VVD"); // "VVD is Invlaid."
    				return false;
    			}
        	}
    	}
        
/**
 * IBMultiCombo 에 Item을 setting한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     initIBComboItem();
 * </pre>
 * @return 없음
 * @author 김대호
 * @version 2009.12.15
 */
function initIBComboItem() {
    ComBkgTextCode2ComboItem(rhqComboValue,             rhqComboValue,        	  getComboObject(comboObjects, 'rct_rhq_cd'),      "|", "\t" );
    ComBkgTextCode2ComboItem(respComboValue,            respComboValue,       	  getComboObject(comboObjects, 'respb_rhq_cd'),    "|", "\t" );
    ComBkgTextCode2ComboItem(discrepancyKindComboValue, discrepancyKindComboText, getComboObject(comboObjects, 'umch_tp_cd'),      "|", "\t" );
    ComBkgTextCode2ComboItem(rdnIssRsnCdComboValue, 	rdnIssRsnCdComboText,     getComboObject(comboObjects, 'rdn_iss_rsn_cd'),  "|", "\t" );
    ComBkgTextCode2ComboItem(auditToolComboValue, 	    auditToolComboText, 	  getComboObject(comboObjects, 'rev_aud_tool_cd'), "|", "\t" );
    ComBkgTextCode2ComboItem(rdnKindComboValue, 	    rdnKindComboText,		  getComboObject(comboObjects, 'rdn_knd_cd'), "|", "\t" );
}

        /**
         * 시트 초기설정값, 헤더 정의 <br>
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
         * <br><b>Example :</b>
         * <pre>
         *     initSheet(sheetObj,1);
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */  
    	function initSheet(sheetObj,sheetNo) {

    		 var cnt = 0;
             var sheetID = sheetObj.id;
             switch(sheetID) {
             
             		case "sheet0":      //hidden 
	    	             with (sheetObj) {
	    	            	 // Host정보 설정[필수][HostIp, Port, PagePath]
	    	 				 if (location.hostname != "")
	    	 					InitHostInfo(location.hostname, location.port, page_path);
	    											
	    	             }
	    	             break; 
             
             		case "sheet1":      //sheet1 init
    					with (sheetObj) {

    						// 높이 설정
    						style.height = 82;
    						//전체 너비 설정
    						SheetWidth = mainTable.clientWidth;
    						
    						//Host정보 설정[필수][HostIp, Port, PagePath]
    						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    						
    						//전체Merge 종류 [선택, Default msNone]
    						MergeSheet = msNone;
    						
    						//전체Edit 허용 여부 [선택, Default false]
    						Editable = true;
    						
    						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    						InitRowInfo(1, 1, 2, 100);
    						
    						var HeadTitle = "|Sel.|Del Check|Currency|Amount|USD Amount|rdn_no|rvis_seq";
    						
    						var headCount = ComCountHeadTitle(HeadTitle);
    						
    						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    						InitColumnInfo(headCount, 0, 0, true);
    						
    						// 해더에서 처리할 수 있는 각종 기능을 설정한다
    						InitHeadMode(true, true, false, true, false,false);
    						
    						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    						InitHeadRow(0, HeadTitle, true);
    						
    						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    						InitDataProperty(0, cnt++ ,  dtHiddenStatus, 30,    daCenter,   false,  "ibflag");
    	 	                InitDataProperty(0, cnt++,   dtDummyCheck, 	 40, 	daCenter,   false, 	"chk");
    	                    InitDataProperty(0, cnt++,   dtDelCheck, 	 40, 	daCenter,   false, 	"del_chk");
    	                    InitDataProperty(0, cnt++ ,  dtPopupEdit,	 100,	daCenter,	false,	"curr_cd",		true,	"",	 dfNone,   0,	true,	true);
    						InitDataProperty(0, cnt++ ,  dtData,	 	 140,	daRight,	false,	"dr_amt",		false,	"",	 dfFloat,  2,	true,	true);
    						InitDataProperty(0, cnt++ ,  dtAutoSum,	 	 140,	daRight,	false,	"usd_amount",	false,	"",	 dfFloat,  2,	true,	true);
    						InitDataProperty(0, cnt++,   dtHidden, 		 90, 	daLeft,     false, 	"rdn_no",       false,  "",  dfNone,   0, 	false, false);
    	 					InitDataProperty(0, cnt++,   dtHidden, 		 90, 	daLeft,     false, 	"rvis_seq",  	false,  "",  dfNone,   0, 	false, false);
    	 					
    	 					InitDataValid(0,  "curr_cd",	vtEngUpOnly);		// 영문대문자만 입력
    	 					ColHidden("del_chk") = true;
    						CountPosition = 0;
    						
    						ShowButtonImage = 2;
    						
    	    				var idx = sheetObj.DataInsert();
    						
    					}
    					break;
    					
            		case "sheet2": // 메일발송용
	              		with (sheet2) {
	        		
	        	            //높이 설정
	        	            style.height = 100;
	        	            //전체 너비 설정
    						SheetWidth = mainTable.clientWidth;
	        	            //Host정보 설정[필수][HostIp, Port, PagePath]
	        	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	        	            //전체Merge 종류 [선택, Default msNone]
	        				MergeSheet = msNone;
	        	            //전체Edit 허용 여부 [선택, Default false]
	        	            Editable = true;
	        	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        	            InitRowInfo(1, 1, 2, 100);
	                        var HeadTitle1 = "ibflag|user_gb|group_gb|usr_id|usr_eml|pre_str|suf_str"
	        	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	        	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	        	            InitHeadMode(true, true, false, true, false, false);
	        	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        	            InitHeadRow(0, HeadTitle1, true);
	    		            DataAutoTrim = true;       
	    		            
							//데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME  ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
							InitDataProperty(0, cnt++ ,dtStatus ,30  ,daCenter ,false   ,"ibflag"                                     );
							InitDataProperty(0 ,cnt++ ,dtData   ,50  ,daLeft   ,false   ,"user_gb"  ,false   ,""        ,dfNone    ,0 );
							InitDataProperty(0 ,cnt++ ,dtData   ,50  ,daLeft   ,false   ,"group_gb" ,false   ,""        ,dfNone    ,0 );
							InitDataProperty(0 ,cnt++ ,dtData   ,50  ,daLeft   ,false   ,"usr_id"   ,false   ,""        ,dfNone    ,0 );
							InitDataProperty(0 ,cnt++ ,dtData   ,200 ,daLeft   ,false   ,"usr_eml"  ,false   ,""        ,dfNone    ,0 );
							InitDataProperty(0 ,cnt++ ,dtData   ,80  ,daLeft   ,false   ,"pre_str"  ,false   ,""        ,dfNone    ,0 );
							InitDataProperty(0 ,cnt++ ,dtData   ,80  ,daLeft   ,false   ,"suf_str"  ,false   ,""        ,dfNone    ,0 );
	        	            
	        				//Visible = false;
	        			}
	          			break;    					

    		}
    	}

    	/**
         * Sheet관련 프로세스 처리 <br>
         * <br><b>Example :</b>
         * <pre>
         *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {form} formObj 필수 html form object
         * @param {int} sAction 필수 프로세스 플래그 상수
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
              
            	case IBSEARCH:      //조회
            		//현재 이벤트를 전역변수로 세팅
            		eventStatus = "IBSEARCH";
            		
            		if (validateForm(sheetObj,formObj,sAction)) {
            		   if ( sheetObj.id == "sheet0") {
            			     
            			   //콤보의 첫번째 값으로  조회
						   formObj.f_cmd.value = SEARCH01;
						   var sXml = sheetObj.GetSearchXml("ESM_BKG_0426GS.do", FormQueryString(formObj));
						   
						   //화면 리셋
						   //removeSearch(formObj);
		       			   
						   var arrData = setSearchData(sXml, formObj);
		       			   
		       			   if (arrData != null && arrData.length > 0) {
		       				 	
		       					//키값이 있으면
		       					if (formObj.rdn_no.value != "" && formObj.rvis_seq.value != "") {
		       						
	       				    		ComOpenWait(true);
	       				    		
			       					sheetObjects[1].WaitImageVisible = false;
			       					
		       						formObj.f_cmd.value = SEARCH03;
			       					sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0426GS.do", FormQueryString(formObj));
			       					
			       					if(typeof ComGetEtcData(sXml, "regional_rmk") != "undefined" && ComGetEtcData(sXml, "regional_rmk") != "") {
			       						formObj.rdn_rmk.value = ComGetEtcData(sXml, "regional_rmk"); 
			       		 			}
			       					if(typeof ComGetEtcData(sXml, "receipt_rmk") != "undefined" && ComGetEtcData(sXml, "receipt_rmk") != "") {
			       						formObj.receiver_rmk.value = ComGetEtcData(sXml, "receipt_rmk");
			       					}
			       					 
			       					//하위 오피스 콤보 세팅
			       					setOfcCd();
			       					
			       					setOfcCd2();
			       					
			       					//하위 언매치 콤보 세팅
			       	 				setUmchSubCd();
			       	 				
				       		 	 	formObj.f_cmd.value = SEARCH02;
			       					sheetObjects[1].DoSearch("ESM_BKG_0426GS.do", FormQueryString(formObj));
								    
			       	 				ComOpenWait(false);			       	 				
		       				 			
		       					}	
		       					
		       			   } else {
		       				   ComShowCodeMessage("BKG95010");
		       			   }
		       			
		       			   ComBtnEnable("btn_Print");
		       			   ComBtnEnable("btn_Attachment");
		       			   
		       			   //Attachment 있는 경우 파란색
		       			   if ("0" == ComGetObjValue(formObj.file_cnt)) {
		       				   document.getElementById('btn_Attachment').style.color = '';
		       			   } else {
		       				   document.getElementById('btn_Attachment').style.color = 'blue';
		       			   }
            		   } 
    	        	}    
            		eventStatus = "";
            		
                    break;

    			case IBSAVE:        //저장
    				
    				//bkg search
    				searchBlno(formObj);
    				
	 				if (!validateForm(sheetObj,document.form,sAction)) {
	 					return false;
	 				}
	 				
	 				if (!ComBkgProcessYn("save")) return;
    				
	 				formObj.f_cmd.value = MULTI02;
	 	   			
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheetObjects[1].GetSaveString();	
					
					if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
						return;
					}
					
					sParam += "&" + sParamSheet1;
					
		    		ComOpenWait(true);		

					var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
					sheetObjects[1].LoadSaveXml(sXml);
			 			
					ComOpenWait(false);
					
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95033"); // "Saved."
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					
	        		break;
	        		
	        	
    			case IBSEARCH_ASYNC01:        //issue

    				//bkg search
    				formObj.bkg_no.value = "";
    				searchBlno(formObj);
   	    				
	 				if (!validateForm(sheetObj,document.form,sAction)) {
	 					return false;
	 				}
	 				
	 				if (!ComShowCodeConfirm("BKG95003", "issue the RDN")) { return; }
    				
    				//키값이 없으면 insert
    				formObj.f_cmd.value = MULTI01;
	 	   			
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheetObjects[1].GetSaveString();	
					
					if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
						return;
					}
					
					sParam += "&" + sParamSheet1;

		    		ComOpenWait(true);		
						
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
					sheetObjects[1].LoadSaveXml(sXml);
					
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95035"); // "Issued."
						
//						if(bkg_no, inv_no, vvd null){
//							formObj.rdn_no.value = ComGetEtcData(sXml,"rdn_no");
							var rdn_no = ComGetEtcData(sXml,"rdn_no");

							formObj.rdn_no_cd.InsertItem(0,rdn_no);
							formObj.rdn_no_cd.Text = rdn_no;
//						}
						
						// 메일발송 Flg
						gIsMailSend = true;
						setRdnCd();	
					}
					
					ComOpenWait(false);
					
	   				break;		
	   				 
    			case IBSEARCH_ASYNC02:        //ReIssue
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "ReIssue the RDN")) {
	   						
	   						formObj.f_cmd.value = MULTI04;
	   							
	   						var sParam = FormQueryString(formObj);	   						
	   						var sParamSheet1 = sheetObjects[1].GetSaveString(true);

	   						if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
	   							return;
	   						}
	   						sParam += "&" + sParamSheet1;
	   						
	   						ComOpenWait(true);		
   							
	   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
	   						sheetObjects[1].LoadSaveXml(sXml);
	   				 			
	   						ComOpenWait(false);
	   						
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95035"); // "Issue."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}
	   						
	   					}	
	   				 }	
	   					
	   				 break;		
	   				 
    			case IBSEARCH_ASYNC03:        //revise
	  				 if (validateForm(sheetObj,document.form,sAction)) {
	  					if (ComShowCodeConfirm("BKG95003", "revise the RDN")) {
	  						
	  						formObj.f_cmd.value = MULTI05;
	  							
	  						var sParam = FormQueryString(formObj);	   						
	  						var sParamSheet1 = sheetObjects[1].GetSaveString(true);
	
	  						if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
	  							return;
	  						}
	  						sParam += "&" + sParamSheet1;
	  						
	  						ComOpenWait(true);		
								
	  						var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
	  						sheetObjects[1].LoadSaveXml(sXml);
	  				 			
	  						ComOpenWait(false);
	  						
	  						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	  							ComShowCodeMessage("BKG95036"); // "Revised."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  						}
	  						
	  					}	
	  				 }	
  					
    				break;			 
    			case IBSEARCH_ASYNC04:        //cancel
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "cancel the RDN")) {
	   						
	   						formObj.f_cmd.value = MULTI06;
	   						
   				    		ComOpenWait(true);		
	   							
	   						var sParam = FormQueryString(formObj);
	   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
	   				 			
	   						ComOpenWait(false);
	   						
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95039"); // "Canceled."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}

	   					}	
	   				 }	
	   					
	   				 break;	
	   				 
	   				 
    			case IBSEARCH_ASYNC05:        //settle
    			
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "settle the RDN")) {
	   						
	   						formObj.f_cmd.value = MULTI07;
	   							
   				    		ComOpenWait(true);		

   							var sParam = FormQueryString(formObj);
   							
   							

   							var sParam = FormQueryString(formObj);
   							var sParamSheet1 = sheetObjects[1].GetSaveString();	
   							
   							//Other(CTY)는 RDN Settle시 금액 확정
   							if(formObj.umch_tp_cd.Code == "T"){
	   							if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
	   								return;
	   							}
	   							
	   							sParam += "&" + sParamSheet1;
   							}  				
   							
	   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
	   				 			
	   						ComOpenWait(false);
	   						
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95037"); // "Settled."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}
	   						
	   					}	
	   				 }	
	   					
	   				 break;
	   				 
    			case IBSEARCH_ASYNC06:        //copy
    				
    				if (!validateForm(sheetObj,document.form,sAction)) return;
    			
    				if (!ComShowCodeConfirm("BKG95003", "copy the RDN")) { return; }
					
    				//rdn no, bl no clear
    				clearKey(formObj);
    				toggleButtons("COPY");
					
    				setRowStatus(sheetObjects[1]);
    				
					ComShowCodeMessage("BKG95038"); // "Copied."	
    				
	   				break;	

    			case IBINSERT:      // 입력

    				var idx = sheetObj.DataInsert();
    				sheetObj.SelectCell(idx,"curr_cd");
    				
                    break;
                    
    			case IBDELETE: 		// Delete
    				//if (validateForm(sheetObj,document.form,sAction)) {
    				
    				if (sheetObj.CheckedRows("chk") <= 0) {
    	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
    	        	}

    	        	deleteRowCheck(sheetObj, "chk");
    				//}	
    	       		
    	       		break;	 
    	 
    			case IBSEARCH_ASYNC07:
    				var popParams = "progId=ESM_BKG_0426";
    				comRASCallPop("ESM_BKG_5001", "ESM_BKG_0426", popParams, "");
	    			break;		 
	    			
    			case IBSEARCH_ASYNC08:        //cancel(Valid)
	   				 if (validateForm(sheetObj,document.form,sAction)) {
	   					if (ComShowCodeConfirm("BKG95003", "cancel(Valid) the RDN")) {
	   						
	   						formObj.f_cmd.value = MULTI08;
	   						
 				    		ComOpenWait(true);		
	   							
	   						var sParam = FormQueryString(formObj);
	   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0426GS.do", sParam);
	   				 			
	   						ComOpenWait(false);
	   						
	   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	   							ComShowCodeMessage("BKG95039"); // "Canceled."
		   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   						}

	   					}	
	   				 }	
	   					
	   				 break;	

            }
            
        }

/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet2 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.16
*/ 
function doActionIBSheet2(sheetObj, formObj, sAction) {
	var form = document.form;
	sheet2.ShowDebugMsg = false;
    sheet2.WaitImageVisible = false;
    
	switch(sAction) {

        case IBSEARCH: // 메일 대상자 가져오기.

        	ComOpenWait(true);

        	try {
	        	sheet2.RemoveAll();
	        	var params = "f_cmd=" + SEARCH06 + "&bl_no=" + formObj.bl_no.value;
			    var sXml = sheet2.GetSearchXml("ESM_BKG_0426GS.do?", params);
	        	sheet2.LoadSearchXml(sXml);
	        					
	    	}catch(e){
	    		ComShowMessage(e);
	    	}
	    	
        	ComOpenWait(false);
        
        	break;
        	
        case IBSAVE: // 메일발송

        	ComOpenWait(true);

	    	try {

	        	form.f_cmd.value = COMMAND01;
	            var params = FormQueryString(form);
	            params += "&mail_title=[RDN Notice] " + form.rct_ofc_cd.Code + " / " + form.rdn_iss_dt.value.replace(/-/g, "") + " / WK";
	            params += "&cont_fm=PKGSAR_Rev Audit";
	            params += "&rdn_amount=USD " + sheet1.SumText(0, "usd_amount");
	            params += "&error_kind=" + form.umch_tp_cd.Text + " / " + form.umch_sub_tp_cd.Text + " / " + form.rdn_iss_rsn_cd.Text;
	            params += "&" + sheet2.GetSaveString();

	            var sXml = sheet2.GetSaveXml("ESM_BKG_0426GS.do", params);
	    		
	    	}catch(e){
	    		ComShowMessage(e);
	    	}

        	ComOpenWait(false);

			break;

	}
}
      
/** 
* 화면 폼입력값 Error Kind 에 대한 유효성검증 프로세스 처리하는 chkErrorKind <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음.
* @return {boolean}
* @see #
* @author 김대호
* @version 2010.02.16
*/ 
function chkErrorKind() {
	var form = document.form;
	var errorKind  = form.umch_tp_cd;
	var errorKind2 = form.umch_sub_tp_cd;
	var errorKind3 = form.rdn_iss_rsn_cd;
 	if (errorKind.Code == "" || ( errorKind2.Code == "" && errorKind2.GetCount() > 0 ) || errorKind3.Code == "") {
 	    ComShowCodeMessage("BKG95031", "Error Kind");
 	    if(errorKind.Code == ""){
 	    	errorKind.focus();
 	    }else if(errorKind2.Code == "" && errorKind2.GetCount() > 0){
 	    	errorKind2.focus();
 	    }else{
 	    	errorKind3.focus();
 	    }
		return false;
	}
 	return true;
}

		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
		 *         로직처리;
		 *     }
		 * </pre>
		 * @param {ibsheet} sheetObj 필수 IBSheet Object
		 * @param {form} formObj 필수 html form object
		 * @param {int} sAction 필수 프로세스 플래그 상수
		 * @return bool <br>
		 *          true  : 폼입력값이 유효할 경우<br>
		 *          false : 폼입력값이 유효하지 않을 경우
		 * @author 이승준
		 * @version 2009.04.17
		 */
        function validateForm(sheetObj,formObj,sAction){
			 
			 var form = document.form;
			 
			 switch (sAction) {
       	  
   	 		case IBSEARCH: // 조회
   	 			
   	 			setUpperCaseRdnNo();
   	 					
   	 			if (ComIsEmpty(getRdnNoTxt()) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.inv_no) && ComIsEmpty(formObj.vvd_cd)) {
					ComBkgInputValueFailed("input","RDN No, BL No, INV No or VVD Code",formObj.rdn_no_cd);
					return false;
	 			} 
   	 			
	   	 		if (!ComIsEmpty(getRdnNoTxt()) && (getRdnNoTxt().length != 9 && getRdnNoTxt().length != 10)) {
	   	 		    ComShowCodeMessage("BKG95018","RDN No\'s","10");
	   	 		    formObj.rdn_no_cd.focus();
					return false;
	 			} 
	 			
	   	 		if (!ComIsEmpty(formObj.bl_no) && formObj.bl_no.value.length != 12) {
	   	 			ComShowCodeMessage("BKG95018","BL No\'s","12");
	   	 			formObj.bl_no.focus();
					return false;
	 			}
	   	 		
		   	 	if (!ComIsEmpty(getRdnNoTxt()) && !ComIsEmpty(formObj.bl_no)) {
		   	 		formObj.bl_no.value = "";
			 	}

 				//rdn 콤보의 값을 세팅
 				formObj.rdn_no.value = getRdnNoTxt();

   				return true;
   	 			break;
   	 	
   	 		case IBSAVE: // 저장
   	 		
   	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
   	 			//저장가능 상태
   	 			if(rdn_sts_cd == "IS" || rdn_sts_cd == "RV" || rdn_sts_cd == "ST" || rdn_sts_cd == "CL" || rdn_sts_cd == "CV") {
   	 				
	 				if (formObj.rdn_knd_cd.Code == "") {
	 					ComShowCodeMessage("BKG95031", "RDN Kind");
	 					formObj.rdn_knd_cd.focus();
	 					return false;
	 				}
	 				
	 				//RDN Kind가 B/L, B/L PCB인 경우만 BKG No가 필수 입력값
	 				if(formObj.rdn_knd_cd.Code == 'C' || formObj.rdn_knd_cd.Code == 'B'){
   	 			
		   	 			if (ComIsEmpty(formObj.bl_no)) {
							ComBkgInputValueFailed("input","BL No",formObj.bl_no);
							return false;
		   	 			}
		   	 			
			   	 		if (ComIsEmpty(formObj.bkg_no)) {
			   	 			ComShowCodeMessage("BKG95009","BL No");
			   	 			formObj.bl_no.focus();
							return false;
		   	 			}
			   	 		
				   	 	if (formObj.bl_no.value.length != 12) {
				   	 		ComShowCodeMessage("BKG95018","BL No\'s","12");
			   	 			formObj.bl_no.focus();
							return false;
		   	 			}
	 				}
	    			

	 				if(!validateInvoiceNumber(formObj)){
	   	 				return false;
	   	 			}
	 				
	   	 			if(!validateVVD(formObj)){
	   	 				return false;
	   	 			}
	   	 			
	   	 			if (formObj.rct_rhq_cd.Code == "") {
	   	 				ComBkgInputValueFailed("select","RHQ",formObj.rct_rhq_cd);
	   	 				return false;
	   	 			}
	   	 			
		   	 		if (formObj.rct_ofc_cd.Code == "") {
		   	 			ComBkgInputValueFailed("select","Receipt Office",formObj.rct_ofc_cd);
		 				return false;
		 			}
		   	 		
			   	 	if (formObj.respb_rhq_cd.Code == "") {
			   	 		ComBkgInputValueFailed("select","Responsible RHQ",formObj.respb_rhq_cd);
		 				return false;
		 			}
		   	 		
			   	 	if (formObj.respb_ofc_cd.Code == "") {
			   	 		ComBkgInputValueFailed("select","Responsible Office",formObj.respb_ofc_cd);
		 				return false;
		 			}
			   	 	
			   	 	if(!chkErrorKind()) { return false; }
			   	 	
			   	 	if (formObj.rev_aud_tool_cd.Code == "") {
			   	 		ComBkgInputValueFailed("select","Audit Tool",formObj.rev_aud_tool_cd);
		 				return false;
		 			}
	   	 			
	           		if (sheetObjects[1].IsDataModified ) {
	   					 var rowM = sheetObjects[1].ColValueDup("curr_cd",false);
	   					 if (rowM >= 0) {
	   						 ComShowCodeMessage("BKG95007");
	   					     return false;
	   				    }	    		
	   				}
	           		//신규인데 데이터가 없으면
	           		if (getValidRowCount(sheetObjects[1]) <= 0) {
   						 ComShowCodeMessage("BKG95034", "RDN Amount");
   					     return false;
	   				 	    		
	   				}
	           	
       	  		} else {
       	  			return false;
       	  		}	
   				return true;
   	 			break;
   	 			
        	case IBSEARCH_ASYNC01: // ISSUE
	 			
        		var rdn_sts_cd = form.rdn_sts_cd.value;
        		var recRHQ     = form.rct_rhq_cd;
        		var rspRHQ     = form.respb_rhq_cd;
        		var recOffice   = form.rct_ofc_cd;
        		var resOffice   = form.respb_ofc_cd;
        		var auditTool   = form.rev_aud_tool_cd;
        		var rdnKind     = form.rdn_knd_cd;
	 			var umchTpCd = formObj.umch_tp_cd.Code;
        		
        		
	 			//ISSUE 가능 상태
	 			if(ComIsEmpty(rdn_sts_cd)){
	 				
	 				if (rdnKind.Code == "") {
	 					ComShowCodeMessage("BKG95031", "RDN Kind");
	 					rdnKind.focus();
	 					return false;
	 				}
	 				
	 				//RDN Kind가 B/L, B/L PCB인 경우만 BKG No가 필수 입력값
	 				if(rdnKind.Code == 'C' || rdnKind.Code == 'B'){
		 				if (ComIsEmpty(formObj.bl_no)) {
							ComBkgInputValueFailed("input","BL No",formObj.bl_no);
							return false;
		   	 			}
	 				}
	 				

	   	 			if(formObj.bl_no.value.length > 0){
			   	 		if (ComIsEmpty(formObj.bkg_no)) {
			   	 		    ComShowCodeMessage("BKG95009","BL No");
			   	 			formObj.bl_no.focus();
							return false;
		   	 			}
			   	 		
				   	 	if (formObj.bl_no.value.length != 12) {
				   	 	    ComShowCodeMessage("BKG95018","BL No\'s","12");
			   	 			formObj.bl_no.focus();
							return false;
		   	 			}
	   	 			}
	   	 			
	   	 			if(!validateInvoiceNumber(formObj)){
	   	 				return false;
	   	 			}
	   	 			if(!validateVVD(formObj)){
	   	 				return false;
	   	 			}
	    			
	   	 			if(formObj.vvd_cd.value.length > 0){
	   	 				
	   	 			}
			   	 	if (recRHQ.Code == "" || rspRHQ.Code == "") {
			   	 	    ComShowCodeMessage("BKG95031", "Receipt and Responsible RHQ");
			   	 	    if(recRHQ.Code == ""){
			   	 	    	recRHQ.focus();
			   	 	    }else{
			   	 	    	rspRHQ.focus();
			   	 	    }
	   	 				return false;
	   	 			}
			   	 
			   	 	if (recOffice.Code == "" || resOffice.Code == "") {
			   	 	    ComShowCodeMessage("BKG95031", "Receipt and Responsible Office");
			   	 	    if(recOffice.Code == ""){
			   	 	    	recOffice.focus();
			   	 	    }else{
			   	 	    	resOffice.focus();
			   	 	    }
	   	 				return false;
	   	 			}
			   	 	
			   	 	if(!chkErrorKind()) { return false; }
			   	 	
			   	 	if (auditTool.Code == "") {
			   	 	    ComShowCodeMessage("BKG95031", "Audit Tool");
			   	 	    auditTool.focus();
		 				return false;
		 			}

	           		if (sheetObjects[1].IsDataModified ) {
	   					 var rowM = sheetObjects[1].ColValueDup("curr_cd",false);
	   					 if (rowM >= 0) {
	   						 ComShowCodeMessage("BKG95007");
	   					     return false;
	   				    }	    		
	   				}
	           		
	           		//신규인데 데이터가 없으면 
	           		//Other(CTY)는 금액 없이 Issue 가능
	           		if (getValidRowCount(sheetObjects[1]) <= 0 && umchTpCd != "T") {
   						 ComShowCodeMessage("BKG95034", "RDN Amount");
   					     return false;
	   				}
	 				
   	  			} else {
   	  				return false;
   	  			}	
	 			
				return true;
	 			break;	
	 			
        	case IBSEARCH_ASYNC03: // REVISE
        		var tf = true;
	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
	 			//REVISE 가능 상태
	 			if(rdn_sts_cd == "RR" || rdn_sts_cd == "CR" || rdn_sts_cd == "AC" ){
	 				tf = chkErrorKind();
   	  			} else {
   	  				tf = false;
   	  			}

	 			return tf;

	 			break;	
	 			
        	case IBSEARCH_ASYNC04: // CANCEL
	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
	 			var rdn_knd_cd = formObj.rdn_knd_cd.Code;
	 			//CANCEL 가능 상태
	 			if(rdn_sts_cd == "CR" || rdn_sts_cd == "RR" || rdn_sts_cd == "AC" || rdn_knd_cd == "M" || rdn_knd_cd == "B" ){
	 				return true;
   	  			} else {
   	  				return false;
   	  			}
				return true;
	 			break;
	 			
	 			
        	case IBSEARCH_ASYNC05: // SETTLE
	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
	 			var rdn_knd_cd = formObj.rdn_knd_cd.Code;
	 			var umch_tp_cd = formObj.umch_tp_cd.Code;
	 			var umch_sub_tp_cd = formObj.umch_sub_tp_cd.Code;
	 			//SATTLE 가능 상태
	 			
	 			// RDN Kind가 B/L 인 경우 Accept 이후 Settle, PCB & Manual Invoice는 Accept 과정 없이 Settle
	 			if(rdn_knd_cd == "C"){
		 			if(rdn_sts_cd == "AC"){
		 				return true;
	   	  			} else {
	   	  				return false;
	   	  			}
	 			} else {
	 				
	 				
	 				// Other(CTY) : RDN Settle시 AR INV No입력
	 				if(umch_tp_cd == "T"){
	 					if (ComIsEmpty(formObj.inv_no)) {
			   	 		    ComShowCodeMessage("BKG95025","Invoice No");
			   	 			formObj.inv_no.focus();
							return false;
		   	 			}

		   	 			//Other(CTY)는 RDN 발행시 금액 없음. 추후 확정됨
		           		if (getValidRowCount(sheetObjects[1]) <= 0) {
	   						 ComShowCodeMessage("BKG95034", "RDN Amount");
	   					     return false;
		   				}
		           		
	 				// Other(H/O)
	 				}else if(umch_tp_cd == "O"){
	 					// SOC from Shipping Lines:RDN발행시 BKG없음,    금액 존재, RDN Settle시 BKG No 입력
	 					// Manual Invoice        : RDN발행시 BKG있음,    금액 존재, RDN Settle시 INV No 입력
	 					// Other                 : RDN발행시 BKG없음,    금액 존재, RDN Settle시 INV No 입력	 					
	 					if(umch_sub_tp_cd == "10"){
	 						searchBlno(formObj);
		 					if (ComIsEmpty(formObj.bl_no)) {
				   	 		    ComShowCodeMessage("BKG95025","B/L No");
				   	 			formObj.bl_no.focus();
								return false;
			   	 			}
		 					if (ComIsEmpty(formObj.bkg_no)) {
				   	 			ComShowCodeMessage("BKG95009","BL No");
				   	 			formObj.bl_no.focus();
								return false;
			   	 			}
	 					} else {
		 					if (ComIsEmpty(formObj.inv_no)) {
				   	 		    ComShowCodeMessage("BKG95025","Invoice No");
				   	 			formObj.inv_no.focus();
								return false;
			   	 			}
	 					}	   	 			
		   	 			
	 				}
	 				
	 				if(!validateInvoiceNumber(formObj)){
	   	 				return false;
	   	 			}
	   	 			if(!validateVVD(formObj)){
	   	 				return false;
	   	 			}
	 				
	 			}
	 			
				return true;
	 			break;	
	 			
	 		
        	case IBSEARCH_ASYNC06: // copy
	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
	 			//copy 가능 상태
	 			if(!ComIsEmpty(rdn_sts_cd)){
	 				return true;
   	  			} else {
   	  				return false;
   	  			}
				return true;
	 			break;		
   	 		
   	 			
   	 		case IBINSERT: // Row Add
   	 			return true;
   	 			break;
   	 			
   	 		
   	 		case IBDELETE: // Delete
   	 			return true;
   	 			break;
   	 		}

            return true;
        }

        
        function sheet1_OnClick(sheetObj, Row, Col, Value)  {
     		var colName = sheetObj.ColSaveName(Col);
     		if (colName == "chk") {
     			if (Value == "0") {
     				sheetObj.CellValue(Row, "del_chk") = "0";
     			}
     		}	
     	}
        

        /**
         * sheet1에 조회이벤트가 끝난 후 호출된다.<br>
         * 서브 sum을 구하고 버튼을 리셋한다.
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {sheetObj} sheetObj  
         * @param {String} ErrMsg  
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        	var formObj = document.form;
    		
        	setSumTxt(sheetObj);
       		if((formObj.rdn_sts_cd.value =='ST' || formObj.rdn_sts_cd.value =='CL' || formObj.rdn_sts_cd.value =='CV') && formObj.riss_flg.value == 'Y'){
    			toggleButtons("RS")
    		}else
    			resetButton();
       		
    	}
    	
    	
    	/**
         * sheet1에 조회이벤트가 끝난 후 호출된다.<br>
         * 마지막 row에 total sum 및 표시문자를 설정한다.
         * <br><b>Example :</b>
         * <pre>
         *     setSumTxt(sheetObj)
         * </pre>
         * @param {sheetObj} sheetObj  
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
    	function setSumTxt(sheetObj) {
    		with(sheetObj)
    		{
    			SumText(0, "chk") = "";
    			SumText(0, "curr_cd") = "USD Total";
    			//alert(SumText(0, "curr_cd"));
    			//CellAlign(LastRow, "dr_amt") = daRight;
    			CellAlign(LastRow, "usd_amount") = daRight;
    		
	    		//조회된 curr_cd를 readonly로 setting
	    		for (var i=1; i<=SearchRows; i++) {
	    			CellEditable(i, "curr_cd") = false;
    		    }
    		}		
    	}
    	
    	
    	/** 
    	* sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
    	* <br><b>Example :</b>
    	* <pre>
    	* </pre>
    	* @param  {IBSheet} sheetObj : 시트오브젝트  
    	* @param  {string} errMsg : 에러메세지  
    	* @return 없음
    	* @see #
    	* @author 김대호
    	* @version 2009.10.16
    	*/ 
    	function sheet2_OnSearchEnd(sheetObj, errMsg) {
    		
        	try {
            	
        		var form = document.form;
        		
        		if (errMsg == "" && sheet2.RowCount > 0) {
        			
        		    var startRow2 = sheet2.HeaderRows;
        			var endRow2 = sheet2.HeaderRows + sheet2.RowCount;
        			var userGb, groupGb;
        			for(var i = startRow2; i < endRow2; i++) {
        				userGb = sheet2.CellValue(i, "user_gb");
        				groupGb = sheet2.CellValue(i, "group_gb");
        				if(userGb == "TEST_USER") {	/* TEST 용도 */
//       					if(userGb == "REAL_USER") {
        					sheet2.RowStatus(i) = "I";
        				}
        			}
        				
        			doActionIBSheet2(sheetObjects[2], form, IBSAVE);
        			
        	    }
        	}catch(e){
        		ComShowMessage(e);
        	}
    		
    	}       	
    	
/** 
* sheet2 데이터가 변경되면 usd의 환산환율로 변경하여 세팅한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {int} Row 
* @param  {int} Col 
* @param  {string} Value 
* @return 없음
* @see #
* @author 김대호
* @version 2010.02.19
*/ 
function sheet1_OnChange(sheetObj, Row, Col, Value)  {
	var colNm = sheetObj.ColSaveName(Col);  
  	var formObj = document.form
	switch (colNm) {
	  
	 	case "curr_cd":
	 	case "dr_amt":
	    	var etc1 = sheetObj.Cellvalue(Row,"curr_cd"); 
			var etc2 = sheetObj.Cellvalue(Row,"dr_amt"); 
			var etc3 = formObj.rdn_iss_dt.value.replace(/-/g, "");
			var params = "f_cmd=" + COMMAND03;
			params += "&etc1=" + etc1;
			params += "&etc2=" + etc2;
			params += "&etc3=" + etc3;
			sheetObj.WaitImageVisible = false; //	처리 중 대기 이미지를 표시하지 않도록 설정한다. 
			var sXml2 = sheetObjects[0].GetSearchXml("RASCommonGS.do", params);
			if(null == sXml2 || "" == sXml2){
				return;
			}
			var usdAmount = ComGetEtcData(sXml2, "usdAmount");
			sheetObj.Cellvalue2(Row, "usd_amount") = usdAmount;
	 		
	 		break;
	 	
	 }
}
    	
/** 
* sheet1 팝업연결 선택시 발생하는 sheet1_OnPopupClick 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {Long} Row : 해당 셀의 Row Index
* @param  {Long} Col : 해당 셀의 Column Index
* @return  
* @see #
* @author 김대호
* @version 2009.10.16
*/
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var colNm = sheetObj.ColSaveName(Col);
	switch (colNm) {
		case "curr_cd" : // ESM_BKG_0079_08 씀
		    ComOpenPopup('/hanjin/COM_ENS_N13.do?pgmNo=COM_ENS_N13', 500, 450, 'getCOM_ENC_N13', '1,0,1,1,1', true, true, Row, Col, 1);
			break;
	}
}

/** 
* sheet1 팝업연결 선택시 발생하는 sheet1_OnPopupClick 의 callback 함수. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} rowArray : 시트오브젝트  
* @param  {Long} Row : 해당 셀의 Row Index
* @param  {Long} Col : 해당 셀의 Column Index
* @return  
* @see #
* @author 김대호
* @version 2009.10.16
*/
function getCOM_ENC_N13(rowArray, Row, Col, sheetIdx) {
	sheetObjects[sheetIdx].CellValue(Row, Col) = rowArray[0][3];
}


		/**
		 * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     toggleButtons(mode)
		 * </pre>
		 * @param {String} mode    
		 * @return 없음
		 * @author 이승준
		 * @version 2009.06.10
		 */
    	function toggleButtons(mode) {
    		var form = document.form;
    		
    		switch (mode) {
    		case "":		//신규
    			ComBtnEnable("btn_Retrieve");
    			ComBtnEnable("btn_New");
    			ComBtnDisable("btn_Save");
    			ComBtnEnable("btn_Issue");
    			ComBtnDisable("btn_Revise");
    			ComBtnDisable("btn_ReIssue");
    			ComBtnDisable("btn_Vcancel");
    			ComBtnDisable("btn_Cancel");
    			ComBtnDisable("btn_Settle");
    			ComBtnDisable("btn_Copy");
    			ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
    			break;
    			
    		case "RS":		//ReIssue
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Vcancel");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
    			ComBtnEnable("btn_ReIssue");
				break;
			
    		case "IS":		//ISSUE
    			ComBtnEnable("btn_Retrieve");
    			ComBtnEnable("btn_New");
    			ComBtnEnable("btn_Save");
    			ComBtnDisable("btn_Issue");
    			ComBtnDisable("btn_ReIssue");
    			ComBtnEnable("btn_Copy");
    			ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
    			ComBtnDisable("btn_Revise");
    			
    			if(form.rdn_knd_cd.Code == 'C'){
        			ComBtnDisable("btn_Cancel");
        			ComBtnDisable("btn_Settle");
        			ComBtnDisable("btn_Vcancel");
    			} else {
    				ComBtnEnable("btn_Cancel");
    				ComBtnEnable("btn_Settle");
    				ComBtnEnable("btn_Vcancel");
    			}
    			    			
    			break;
    		case "RV":		//REVISE
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Vcancel");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");				
				break;
			case "CV":		//CANCEL
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Vcancel");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;
			case "CL":		//CANCEL
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Vcancel");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;
			case "ST":		//SETTLE
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnEnable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Vcancel");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;
			case "AC":		//Accepted
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnEnable("btn_Revise");
				ComBtnEnable("btn_Vcancel");
				ComBtnEnable("btn_Cancel");
				ComBtnEnable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;
			case "CR":		//Cancel Requested
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnEnable("btn_Revise");
				ComBtnEnable("btn_Vcancel");
				ComBtnEnable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;
			case "RR":		//REVISE Requested
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Issue");
				ComBtnEnable("btn_Revise");
				ComBtnEnable("btn_Vcancel");
				ComBtnEnable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnEnable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;
				
			case "COPY":		//copy
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_New");
				ComBtnDisable("btn_Save");
				ComBtnEnable("btn_Issue");
				ComBtnDisable("btn_Revise");
				ComBtnDisable("btn_Vcancel");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Settle");
				ComBtnDisable("btn_Copy");
				ComBtnDisable("btn_Print");
    			ComBtnDisable("btn_Attachment");
				break;	
    		}	
		}
    	
    	/**
         * 조회 후 상태 코드에 따라 버튼 활성화/비활성화함.<br>
         * <br><b>Example :</b>
         * <pre>
         *     resetButton()
         * </pre>
         * @param 없음  
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
    	function resetButton() {
    		
    		var formObj = document.form;
    		var rdn_sts_cd = formObj.rdn_sts_cd.value;
    		toggleButtons(rdn_sts_cd);
    	}
    	
    	
    	/**
         * 화면을 전체 리셋한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     removeAll(formObj)
         * </pre>
         * @param {formObj} formObj    
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
 	 	function removeAll(formObj) {
 	 		
 	 		formObj.reset();
 	 		formObj.rdn_no_cd.removeAll();
 	 		formObj.rdn_knd_cd.Index = "-1";
 	 		formObj.rct_rhq_cd.Index = "-1";
 	 		formObj.rct_ofc_cd.removeAll();
 	 		formObj.respb_rhq_cd.Index = "-1";
 	 		formObj.respb_ofc_cd.removeAll();
 	 		formObj.umch_tp_cd.Index = "-1";
 	 		formObj.umch_sub_tp_cd.removeAll();
 	 		formObj.rdn_iss_rsn_cd.Index = "-1";
 	 		formObj.rev_aud_tool_cd.Index = "-1";
 	 		
 	 		sheetObjects[1].RemoveAll();
 	 		
 	 		doActionIBSheet(sheetObjects[1], formObj, IBINSERT);
 	 		
 	 		setSumTxt(sheetObjects[1]);
 	 		
 	 		resetButton();
 	 		formObj.rdn_no_cd.focus();
 	 		
 		}
    	
 	 	/**
         * BLNO, RDN NO 외 리셋한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     removeSearch(formObj)
         * </pre>
         * @param {formObj} formObj    
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
 	 	function removeSearch(formObj) {
 	 		
 	 		
 	 		var rdnNo = formObj.rdn_no.value;
 	 		var blNo = formObj.bl_no.value;
 	 		
 	 		formObj.reset();
 	 		formObj.rdn_no_cd.RemoveAll();
 	 		formObj.rdn_knd_cd.Index = "-1";
 	 		formObj.rct_rhq_cd.Index = "-1";
 	 		formObj.rct_ofc_cd.removeAll();
 	 		formObj.respb_rhq_cd.Index = "-1";
 	 		formObj.respb_ofc_cd.removeAll();
 	 		formObj.umch_tp_cd.Index = "-1";
 	 		formObj.umch_sub_tp_cd.removeAll();
 	 		formObj.rdn_iss_rsn_cd.Index = "-1";
 	 		formObj.rev_aud_tool_cd.Index = "-1";
 	 		
 	 		sheetObjects[1].RemoveAll();
 	 		
 	 		setSumTxt(sheetObjects[1]);
 	 		
 	 		formObj.bl_no.value = blNo;
 	 		formObj.rdn_no.value = rdnNo;
 	 		
 		}
 	 	
 	 	/**
 	     * RVISE 시 AMT FLAG를  I로 세팅한다.<br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     *     setRowStatus(sheetObj)
 	     * </pre>
 	     * @param {sheetObj} sheetObj    
 	     * @return 없음
 	     * @author 이승준
 	     * @version 2009.06.10
 	     */
 	 	function setRowStatus(sheetObj)  {
 	 			
 	 		for(var i=1; i<=sheetObj.RowCount; i++) {
 	 			sheetObj.RowStatus(i) = "I";
 	 			
 	 		}

 	 	}
 	 	
 	 	
 	 	/**
 	     * copy 시 키 클리어한다.<br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     *     clearKey(formObj)
 	     * </pre>
 	     * @param {sheetObj} sheetObj    
 	     * @return 없음
 	     * @author 이승준
 	     * @version 2009.06.10
 	     */
 	 	function clearKey(formObj)  {
 	 		
 	 		formObj.rdn_no_cd.removeAll();
 	 		formObj.bl_no.value = "";
 	 		formObj.inv_no.value = "";
 	 		formObj.vvd_cd.value = "";
 	 		
 	 		formObj.rdn_sts_cd.value = "";
 	 		
 	 		formObj.rdn_no.value = "";
 	 		formObj.rvis_seq.value = "";
 	 		formObj.prog_seq.value = "";
 	 		formObj.rdn_sts_cd.value = "";
 	 		formObj.rct_ofc_cd_hidden.value = "";
 	 		formObj.respb_ofc_cd_hidden.value = "";
 	 		formObj.umch_sub_tp_cd_hidden.value = "";
 	 		formObj.bkg_no.value = "";
 	 		formObj.bkg_no_split.value = "";
 	 		formObj.cntBlno.value = "";
 	 		formObj.rdn_no_pop.value = "";
 	 		formObj.atch_file_lnk_id.value = "";
 	 		
 	 		formObj.iss_ofc_cd.value = gStrUsr_office_cd;
 	 		formObj.rdn_sts_nm.value = "";
 	 		formObj.rdn_iss_dt.value = "";
 	 		formObj.sts_upd_dt.value = "";
 	 		formObj.sc_rfa_no.value = "";
 	 		formObj.bkg_corr_no.value = "";
 	 		formObj.n3pty_no.value = "";
 	 		
 	 	}
    
 	/**
     * GroupWare Mail Popup을 호출한다.<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     *     openGroupWareMailPopup(sheetObjects[0], document.form);
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 Form Object
     * @return 없음
     * @author 문동규
     * @version 2010.04.27
     */
 	function openGroupWareMailPopup(sheetObj, formObj) {
    	var rmk = formObj.rdn_rmk.value;

    	var subject = "[RDN Notice] " + formObj.rct_ofc_cd.Code + " / " + formObj.rdn_iss_dt.value.replace(/-/g, "") + " / WK" + " " + formObj.rdn_iss_dt_wk.value;
        var contents = "reqcontents;";

     	// mail contents
     	contents += "TO: " + formObj.rct_ofc_cd.Code + "<br>";
     	contents += "FM: " + formObj.iss_ofc_cd.value + "<br>";
     	contents += "<br><br>";
     	contents += "Revenue Debit Note" + "<br>";
     	contents += "<br>";
     	contents += "RDN No : " + formObj.rdn_no.value + "<br>";
     	contents += "RDN Amount : " + "USD " + sheet1.SumText(0, "usd_amount") + "<br>";
     	
     	if(formObj.rdn_knd_cd.Code =="C"){
	     	contents += "Issue Date : " + formObj.rdn_iss_dt.value + "<br>";
	     	contents += "B/L No : " + formObj.bl_no.value + "<br>";
	     	contents += "Contract No : " + formObj.sc_rfa_no.value + "<br>";
     	}
     	
     	contents += "<br>";
     	contents += "Error Kind : " + formObj.umch_tp_cd.Text + " / " + formObj.umch_sub_tp_cd.Text + " / " + formObj.rdn_iss_rsn_cd.Text + "<br>";
     	contents += "Remarks(Auditor) :" + "<br>";
     	contents += rmk.split("\r\n").join("<br>") + "<br>";     	

     	if(formObj.rdn_knd_cd.Code =="C"){
	     	contents += "<br>";
	     	contents += "1. If you agree to this debit note, please issue C/A within 5 working days after receipt and the" + "<br>";
	     	contents += "collection office should collect the above debited amount from party concerned. And please " + "<br>";
	     	contents += "report us the occurrence reason of this error case in details and countermeasures taken/to be" + "<br>";
	     	contents += "taken." + "<br>";
	     	contents += "<br>";
	     	contents += "2. If you disagree to this debit note, please give us your cancel request or revise request" + "<br>";
	     	contents += "through \"RDN Receipt by Office\" within 5 working days after receipt." + "<br>";
     	}
     	contents += "<br><br>";
     	contents += "Best Regards" + "<br>";
     	
     	formObj.gw_subject.value = subject;
     	formObj.gw_contents.value = "";
        formObj.gw_template.value = "ESM_BKG_COMM_01T.html";
        formObj.gw_args.value = contents;

        ComOpenGroupwareMail(sheetObj,formObj);
 	}
	/* 개발자 작업 끝 */