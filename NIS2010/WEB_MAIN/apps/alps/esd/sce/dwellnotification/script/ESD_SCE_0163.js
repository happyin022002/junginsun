/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0154.js
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0163 : ESD_SCE_0163 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SCE_0163() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;
        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

        			case "btn_new":
        				sheetObject.RemoveAll();
        				formObject.reset();
        		
        				break;

                    case "btn_retrieve":
                    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;

    				case "btn_save":
//    					if(!formObject.i_del_flg.checked){
    					    doActionIBSheet(sheetObject,formObject,IBSAVE);
//    					}else {
//    						doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);	
//    					}
    				break ;
    				case "btn_close":
    					var chkRows = sheetObject.FindCheckedRow("chk");
    					if (chkRows =="") {
    						closeWindow();
    					}else{
    						if(ComShowCodeConfirm("SCE90053")) {
    							closeWindow();
    						}
    					}
    					
    				break ;

    				case "btng_rowadd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break ;
    				
    				case "btng_rowdelete":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
    				
    	            break ;
                 } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
    				ComShowMessage(ComGetMsg('COM12111')) ;
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
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
             var cnt = 0; 
           	 switch(sheetNo) {
             case 1:      //IBSheet1 init
                	 with (sheetObj) {
     	                // 높이 설정
     	                style.height = 250;
     	                //전체 너비 설정
     	                SheetWidth = mainTable.clientWidth;
     	
     	                //Host정보 설정[필수][HostIp, Port, PagePath]
     	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     	
     	                //전체Merge 종류 [선택, Default msNone]
     	                MergeSheet = msHeaderOnly;
     	
     	               //전체Edit 허용 여부 [선택, Default false]
     	                Editable = true;
     	
     	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     	                InitRowInfo( 2, 1, 10, 50);
     	
     	                var HeadTitle  = "|CHK|Office|E - mail Address|CRM|Origin|Destination|Other Parties|Remark|One Time \n send history|Send Option|Send Option|C.Date|C.User|C.Name|D.Date|D.User|D.Name|sc_no|ntfc_seq|i_del_flg|";
     	                var HeadTitle1 = "|CHK|Office|E - mail Address|CRM|Origin|Destination|Other Parties|Remark|One Time \n send history|One Time Only|S/C List Base|C.Date|C.User|C.Name|D.Date|D.User|D.Name|sc_no|ntfc_seq|i_del_flg|";
     	                var headCount = ComCountHeadTitle(HeadTitle);
     	                
     	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     	                InitColumnInfo(headCount, 0, 0, true);
     	
     	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
     	                InitHeadMode(true, true, false, true, false,false);
     	
     	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     					InitHeadRow(0, HeadTitle, true);
     					InitHeadRow(1, HeadTitle1, true);
     	
     	                //데이터속성    [   ROW, COL,   DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter, true, "ibflag");
     	              // InitDataProperty(0, cnt++ , dtStatus,	30,   daCenter, false, "ibflag");
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    60,   daCenter, true, "chk"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtData,     	60,  daCenter, true, "cre_ofc_cd",   false , "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtData,     	170,  daLeft, true, "subsc_eml",   true , "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    60,   daCenter, true, "eml_fm_crm_flg"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    60,   daCenter, true, "eml_bkg_org_flg"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    100,   daCenter, true, "eml_bkg_dest_flg"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    100,   daCenter, true, "eml_bkg_otr_flg"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtData,     	250,  daLeft  , true, "subsc_rmk",   false, "", dfNone, 	  0, true, true);
     	                InitDataProperty(0, cnt++ , dtData,     	80,  daCenter  , true, "ot_snd_hist",   false, "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    100,   daCenter, true, "snd_opt_cd_ot"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtCheckBox,	    100,   daCenter, true, "snd_opt_cd_aw"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     					InitDataProperty(0, cnt++ , dtData,      	80,   daCenter, true, "cre_dt",      false, "", dfDateYmd,   0, false, false);										
     				    InitDataProperty(0, cnt++ , dtData, 		80,   daCenter, true, "cre_usr_id",  false, "", dfNone,       0, false, false);
     					InitDataProperty(0, cnt++ , dtData,      	100,  daCenter, true, "cre_usr_nm",  false, "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,     	72,   daCenter, true, "delt_dt",     false, "", dfDateYmd,    0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	72,   daCenter, true, "delt_usr_id", false, "", dfNone,       0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	100,  daCenter, true, "delt_usr_nm", false, "", dfNone,       0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	100,  daCenter, true, "sc_no",       false, "", dfNone,       0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	100,  daCenter, true, "ntfc_seq",    false, "", dfNone,       0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	100,  daCenter, true, "i_del_flg",       false, "", dfNone,       0, false, false);
     	                InitDataProperty(0, cnt++ , dtHidden,      	100,  daCenter, true, "cust_cd",       false, "", dfNone,       0, false, false);
     	               
     	                DataLinkMouse('ot_snd_hist') = true;
      	                ActionMenu ="Check|Uncheck";   // Action Menu - OnSelectMenu Event 발생.
      	             
                        MultiSelection = true;         // Multi-Selection
                        SelectionMode = smSelectionFree;   // Cel 단위 선택
     	            }
     	            break;  
                
            }
        }

        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetObject = sheetObjects[0];               
            var formObject = document.form;
            doActionIBSheet(sheetObject,formObject,COMMAND01);
            doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
         }

    	// Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
            	case IBSEARCH_ASYNC01:      //조회
            		//if(validateForm(sheetObj,formObj,sAction)){
            			formObj.f_cmd.value = SEARCH;
            	      	sheetObj.DoSearch4Post("ESD_SCE_0163GS.do", SceFrmQryString(formObj));
            		// }
            	break;
                
            	case IBSEARCH:      //조회
        			formObj.f_cmd.value = SEARCH;
        	      	sheetObj.DoSearch4Post("ESD_SCE_0163GS.do", SceFrmQryString(formObj));
        	
        	    break;
            	case IBINSERT:
            		var Row = sheetObj.DataInsert();
            	    sheetObj.CellEditable(Row ,'subsc_eml') = true;
            	    sheetObj.CellEditable(Row ,'subsc_rmk') = true;
            	    sheetObj.CellValue2(Row ,'sc_no') = formObj.sc_no.value;
            	    sheetObj.CellValue2(Row ,'cust_cd') = formObj.cust_cd.value;
            	    sheetObj.CellValue2(Row ,'snd_opt_cd_aw')="1";
            	
            	break;
            	case IBSAVE:
            		if(validateForm(sheetObj,formObj,sAction)){
            			formObj.f_cmd.value = MULTI;
            			sheetObj.DoSave("ESD_SCE_0163GS.do", SceFrmQryString(formObj));
            		}
        	  	break;
            	case IBSEARCH_ASYNC02:
            		if(validateForm(sheetObj,formObj,sAction)){
//            		 formObj.f_cmd.value = MULTI01;
//            		 sheetObj.DoSave("ESD_SCE_0163GS.do", SceFrmQryString(formObj));
            		}
        	  	break;
        	  	
                case COMMAND01:     
                    formObj.f_cmd.value = SEARCH04;
                    var sXml = sheetObj.GetSaveXml("ESD_SCE_0145GS.do", FormQueryString(formObj));
                    document.form.frm_rvis_cntr_cust_tp_cd.value = ComGetEtcData(sXml, "rvis_cntr_cust_tp_cd");
                break;
         
            }
        }
    	/**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		 
  		  switch(sAction) {
		  	case IBSAVE:
		  		var rowcount          = sheetObj.RowCount +1;
				var email_str         = "";
				var email_chk         = "";
				var save_count        = 0;
				
              for(m=0 ; m<= rowcount ; m++){
              	if(sheetObj.RowStatus(m) == 'I'){
               		email_str = sheetObj.CellValue(m,'subsc_eml');
               		if (email_str == "") {
               			continue;
               		}
                 		email_chk = isEmail(email_str);
              	    if(!email_chk){
                      	 ComShowCodeMessage("SCE90052", "'" + email_str + "'");
                       	return false;
                       }
              	}
                  if(sheetObj.RowStatus(m) == 'U'){
                  	if(sheetObj.CellValue(m ,'chk') == '1'){
                  		save_count++;
                  	}
                  }
                  if(((sheetObj.CellValue(m,"eml_fm_crm_flg") + sheetObj.CellValue(m,"eml_bkg_org_flg")+ sheetObj.CellValue(m,"eml_bkg_dest_flg") + sheetObj.CellValue(m,"eml_bkg_otr_flg"))<"1") && m>0 && (sheetObj.RowStatus(m) == 'U' || sheetObj.RowStatus(m) == 'I')){
                  	ComShowMessage(ComGetMsg("COM12176")+" (E-mail Source)");
                  	return false;
                  }
                  if(sheetObj.CellValue(m,"snd_opt_cd_ot")+sheetObj.CellValue(m,"snd_opt_cd_aw")<1){
                	  ComShowCodeMessage("COM12113","Send Option");
                	  return false;
                  }
              }
              return true;
                    
                break;
    		  	case IBSEARCH_ASYNC02:
                    var chkRows = sheetObj.FindCheckedRow("chk");
                    var aChk = chkRows.split("|");
                    for (var idx = aChk.length -1 ; idx > -1 ; idx --) {
                    	if (aChk[idx] == "") {
                    		continue;
                    	}
                    	if (sheetObj.RowStatus(aChk[idx]) == "I") {
                    		sheetObj.RowDelete(aChk[idx],false);
                    	} else {
                    		sheetObj.RowStatus(aChk[idx]) = "D";
                    		sheetObj.RowHidden(aChk[idx]) = true;
                    	}
                    }
                    return true;
    		  break
               
    		  }   
                   
    	}

    	 	/**
     	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     	 */
     	function validateFormRowDelete(sheetObj,formObj,sAction){
     			
                    
     	}
//
          
          /**
           * 하나의 컬럼만 체크.
           * 
           */  
       	function sheet1_OnChange(sheetObj,Row, Col, Value) {
       	    var formObject = document.form;
      		 if(sheetObj.ColSaveName(Col) == "snd_opt_cd_aw"){
      			 if(sheetObj.CellValue(Row,"snd_opt_cd_aw") == "1"){
      				sheetObj.CellValue(Row,"snd_opt_cd_ot") ="0";
      			 }
      		 }else if(sheetObj.ColSaveName(Col) == "snd_opt_cd_ot"){
      			if(sheetObj.CellValue(Row,"snd_opt_cd_ot") == "1"){
      				sheetObj.CellValue(Row,"snd_opt_cd_aw") ="0";
      			 }
      		 }else if(sheetObj.ColSaveName(Col) == "eml_bkg_org_flg"){
      			 if(sheetObj.CellValue(Row,"eml_bkg_org_flg")=="1"){
      				sheetObj.CellValue(Row,"eml_bkg_dest_flg")="0";
      				sheetObj.CellValue(Row,"eml_bkg_otr_flg")="0";
      			 }
       		 }else if(sheetObj.ColSaveName(Col) == "eml_bkg_dest_flg"){
      			 if(sheetObj.CellValue(Row,"eml_bkg_dest_flg")=="1"){
       				sheetObj.CellValue(Row,"eml_bkg_org_flg")="0";
       				sheetObj.CellValue(Row,"eml_bkg_otr_flg")="0";
       			 }
       		 }else if(sheetObj.ColSaveName(Col) == "eml_bkg_otr_flg"){
      			 if(sheetObj.CellValue(Row,"eml_bkg_otr_flg")=="1"){
        				sheetObj.CellValue(Row,"eml_bkg_org_flg")="0";
        				sheetObj.CellValue(Row,"eml_bkg_dest_flg")="0";
        		 }
       		 }
      	 }
 
       	//Delt Flg 변경 이벤트 처리
        function changeDeltFlg() {
         
         var sheetObject = sheetObjects[0];               
         var formObject = document.form;
         var chkRows = sheetObject.FindCheckedRow("chk");
		if (chkRows !="") {
			if(!ComShowCodeConfirm("SCE90054")) {
				return;
			}
		}
         	 sheetObject.RemoveAll();
         	 sheetObject.Redraw = false;
            if(formObject.i_del_flg.checked ){
            	sheetObject.ColHidden("delt_dt")=false;
            	sheetObject.ColHidden("delt_usr_id")=false;
            	sheetObject.ColHidden("delt_usr_nm")=false;
            	ComBtnDisable("btng_rowadd");
            	ComBtnDisable("btng_rowdelete");
            
               doActionIBSheet(sheetObject,formObject,IBSEARCH);
                      
             } else {
             	sheetObject.ColHidden("delt_dt")=true;
             	sheetObject.ColHidden("delt_usr_id")=true;
             	sheetObject.ColHidden("delt_usr_nm")=true;
             	ComBtnEnable("btng_rowadd");
             	ComBtnEnable("btng_rowdelete");
           
               doActionIBSheet(sheetObject,formObject,IBSEARCH);
             }
            sheetObjects[0].Redraw = true;
        }
        
  // 이메일 주소 검증 
        function isEmail(str) {
        	  // regular expression 지원 여부 점검
        	  var supported = 0;
        	  if (window.RegExp) {
        		  var tempStr = "a" ;
        		  var tempReg = new RegExp(tempStr);
        		  if (tempReg.test(tempStr))
        			  supported = 1; 
        		 }
        	  if (!supported) 
        	    return (str.indexOf(".") > 2) && (str.indexOf("@") > 0);
        	  var r1 = new RegExp("(@.*@)|(\\.\\.)|(@\\.)|(^\\.)");
        	  var r2 = new RegExp("^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,3}|[0-9]{1,3})(\\]?)$");
        	  return (!r1.test(str) && r2.test(str));
        	}  

        /**
         * 컬럼 입력된값을 확인하여 조회를 해온다.
         * 
         */  
         function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	 var formObject = document.form;
        	  if(!formObject.i_del_flg.checked ){
        		  var rowcount = sheetObj.RowCount;
        		  formObject.totalCount.value = rowcount;
        		 }
        	  var idx = coSceSaveNameCol(sheetObj, 'ot_snd_hist');
        	  var rowcount = sheetObj.LastRow;
              sheetObj.ColFontUnderline('ot_snd_hist') = true;
              sheetObj.ColFontColor('ot_snd_hist')= sheetObj.RgbColor(0, 0, 255);
              sheetObj.RangeFontBold(2,idx,rowcount,idx)=true;
         }
         
         /**
          * 컬럼 입력된값을 확인하여 조회를 해온다.
          * 
          */  
          function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        	 var formObj = document.form;
         	 var rowcount = sheetObj.RowCount;
         	 var flg = 0;
         	 for(k=0 ; k<= rowcount ; k++){
         		 if(sheetObj.RowStatus(k)== 'I'){
         			 flg++;
         		 }
         	 }
         	if(flg == 0) {
         	 doActionIBSheet(sheetObj,formObj,IBSEARCH);
         	}
          }
          
          // 시트 컬럼 더블클릭 이벤트 처리
          function sheet1_OnDblClick(sheetObj ,Row, Col){
         	    var formObject = document.form;
         	    var colName = sheetObj.ColSaveName(Col);
         	    var dtValue = sheetObj.CellValue(Row,Col);
         	    switch(colName) {
         	    case "ot_snd_hist":
         	    	if (sheetObj.CellValue(Row, Col) == "Y") {
      	   	    	var paramUrl = "cust_cd="+formObject.cust_cd.value+"&row=" + Row+"&subsc_eml="+sheetObj.CellValue(Row,'subsc_eml');
      	            window.showModalDialog("ESD_SCE_0165.do?"+paramUrl, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:900px;dialogHeight:400px");  
         	    	}
                  break;
              }
          }
          
          // Window Close 이벤트 처리
         function  closeWindow(){
        	 var opener = window.dialogArguments;
        	 var opnSheetObj = opener.sheetObjects[0];
           	 var formObject = document.form;
           	 if (formObject.emailcnt_gubun.value == 'cnee_eml_cnt'){
           		 opnSheetObj.CellValue2(opnSheetObj.SelectRow, "cnee_eml_cnt") = "Edit (Registered : "+ formObject.totalCount.value +" )";
           	 }else if (formObject.emailcnt_gubun.value == 'ntfy_eml_cnt'){
           		 opnSheetObj.CellValue2(opnSheetObj.SelectRow, "ntfy_eml_cnt") = "Edit (Registered : "+ formObject.totalCount.value +" )";
             }else if (formObject.emailcnt_gubun.value == 'eml_cnt'){
           		 opnSheetObj.CellValue2(opnSheetObj.SelectRow, "eml_cnt") = "Edit (Registered : "+ formObject.totalCount.value +" )";
             }
        	 self.close();
         }
	/* 개발자 작업  끝 */