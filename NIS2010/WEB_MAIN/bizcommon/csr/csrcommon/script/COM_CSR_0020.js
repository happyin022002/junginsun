/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : COM_CSR_0020.js
 *@FileTitle : Approval Step & Comments
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.21
 *@LastModifier : 9014787
 *@LastVersion : 1.0
 * 2014.07.21 9014787
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

var sheetObjects = new Array();
var sheetCnt = 0;
var gvMyRow = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /** **************************************************** */
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject, formObject, IBSEARCH);
        	        break;
				case "btn_close":
					  window.close();
					  break;
					  
				case "btn_apro":
				case "btn_dapro":
				case "btn_save":

					// dapro comment Required
					if(srcName == "btn_dapro"){
						for( var idx = 0 + parseInt(sheetObject.HeaderRows); idx <= sheetObject.LastRow; idx++ ){

							if( sheetObject.CellValue(idx,"editable_yn") == "Y" && ComIsEmpty(sheetObject.CellValue(idx,"apro_rmk"))){
								ComShowMessage("Please input disapproval reasons.");	// 코멘트가 없습니다.
								return;
							}
						}
					}

					/*if (!ComShowConfirm(ComGetMsg("COM14002"))){
						return;
					}*/
					
					doActionIBSheet(sheetObject, formObject, srcName);//MODIFY04
        	        break;
        	        
				case "btn_EditMode":
					chkEditMode(sheetObject);
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
     * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
     * 추가한다
     */
    function loadPage() {
		ComBtnDisable("btn_apro");
		ComBtnDisable("btn_dapro");
       	if (document.form.apro_rqst_no.value == '') {
    		//ComShowCodeMessage("COM14001", "No.");// 조회를 위한 CSR no가 없습니다.
    		self.close();
    	} else {
    		try {
    			for(i=0;i<sheetObjects.length;i++){

			        //khlee-?? ?? ?? ?? ?? ??
    				ComConfigSheet(sheetObjects[i]);

    				initSheet(sheetObjects[i],i+1);
			        //khlee-??? ?? ?? ?? ??
    				ComEndConfigSheet(sheetObjects[i]);
    			}

    			// VVD? ??? ??, ?? ??               
    			var sheetObject = sheetObjects[0];
    			var formObject = document.form;
    			doActionIBSheet(sheetObject,formObject,IBSEARCH);

    		} catch (e) {
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e);
    			}
    		}
    	}
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
                    // ?? ??
                    style.height = GetSheetHeight(6) ;
                    //?? ?? ??
                    SheetWidth = mainTable.clientWidth;

                    //Host?? ??[??][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //??Merge ?? [??, Default msNone]
                    MergeSheet = msNone;

                    //??Edit ?? ?? [??, Default false]
                    Editable = true;

                    //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // ???? ??? ? ?? ?? ??? ????
                    InitHeadMode(false, true, true, true, false,false)

                    var HeadTitle = "No|Name|Office|Title|APP STS|App Date|Comment|editable_yn|apro_rqst_no|chk_curr_apro_usr_yn" ;

                    //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //?????         [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,   "apro_rqst_seq",        false,          "",       dfNone,	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "apro_usr_nm",        false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "apro_ofc_cd",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,  false,   "title",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  false,    "apro_cd",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,   "apro_dt",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      125,    daCenter,  false,   "apro_rmk",        false,          "",       dfNone,   	0,     false,       false, 400);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,   "editable_yn",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,   "apro_rqst_no",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      10,    daCenter,  false,   "chk_curr_apro_usr_yn",        false,          "",       dfNone,   	0,     false,       false);
                    
                    FocusEditMode = -1;
             }
                break;

        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	formObj   
     * @param {String} 	sAction   
     * @return {없음}
     **/
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //??
               
                formObj.f_cmd.value = SEARCH;                
                selectVal = FormQueryString(formObj)
                sheetObj.DoSearch4Post("COM_CSR_0020GS.do", selectVal);
                break;
           
           case "btn_apro": // SAVE//MODIFY04
           case "btn_dapro":
           case "btn_save":
				//if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					formObj.f_cmd.value = MODIFY04;
					var sParam =  ComGetSaveString(sheetObj, true, false);
					if( sParam == ""){ return;}
					
					
					
					/*if (!validateForm(sheetObj, formObj, sAction)) {
						return false;
					}*/
					//var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
					//var chkRow = chkRowArr.split("|");
					//select doc type 체크 추가
					//chkDocType(sheetObj, chkRow[0]); 

					var sheetParam = "";
					sheetParam = "&apro_rqst_seq="+sheetObj.CellValue(gvMyRow, "apro_rqst_seq")
						+ "&apro_rmk="+sheetObj.CellValue(gvMyRow, "apro_rmk")
						+ "&apro_rqst_no="+sheetObj.CellValue(gvMyRow, "apro_rqst_no")
						
						var sXml = sheetObj.GetSaveXml('COM_CSR_0020GS.do', "f_cmd= "+MODIFY04 + sheetParam); 
					 	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", "");
					
					//alert(sParam);
					//var sXml = sheetObj.GetSaveXml("COM_CSR_0020GS.do", FormQueryString(formObj) + "&" + sParam, true);
					//alert(sXml);
	    			//console.log(sXml);
					
					if (sheetObj.CellValue(sheetObj.SelectRow,"chk_curr_apro_usr_yn") == "Y"){
						if(sAction == "btn_apro"){
							if (window.dialogArguments && typeof (window.dialogArguments.doActionApprove) == "function"){
								window.dialogArguments.doActionApprove();
							}
						}else if(sAction == "btn_dapro"){
							if (window.dialogArguments && typeof (window.dialogArguments.doActionDisapprove) == "function"){
								window.dialogArguments.doActionDisapprove();
							}
						}
					}
					
					window.close();

	    			/*return;
					var vDodInvNo = ComGetEtcData(sXml, "dodInvNo");
					ComSetObjValue(formObj.in_dod_inv_no, vDodInvNo);
					ComSetObjValue(formObj.dod_inv_no, vDodInvNo);
					setGridInvNo(sheetObj, vDodInvNo);
					
					ComBtnDisable("btn_retrieve");
					ComBtnDisable("btn_issue");
					ComBtnDisable("btn_payer_info");

					ComBtnEnable("btn_fax");
					ComBtnEnable("btn_email");
					ComBtnEnable("btn_preview");

					object_disable();*/
				//}	
				break;
				
			case IBINSERT:        //저장
				//RD 호출
				/*var rdParm = "/rv dod_inv_no[" + ComGetObjValue(formObj.dod_inv_no) +"]";
				ComSetObjValue(formObj.rd_parm, rdParm);

				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("ESD_EAS_0101GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						ComShowCodeMessage("EAS90041");
					}
					else {
						ComShowCodeMessage("EAS90042");
					}
				}*/
			break;
        }
    }
    
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if( sheetObj.RowCount > 0 ){
			//object_enable();
			setCellEditable(sheetObj);
	    	if (sheetObj.CellValue(1,"chk_curr_apro_usr_yn") == "Y"){
	    		ComBtnEnable("btn_apro");
	    		ComBtnEnable("btn_dapro");
	    	} else {
	    		ComBtnDisable("btn_apro");
	    		ComBtnDisable("btn_dapro");
	    	}

			/*ComSetObjValue(formObj.bkg_no, sheetObj.CellValue(1, "bkg_no"));
			ComSetObjValue(formObj.bl_no, sheetObj.CellValue(1, "bl_no"));
			
			ComSetObjValue(formObj.pod_cd, sheetObj.CellValue(1, "pod_cd"));
			ComSetObjValue(formObj.del_cd, sheetObj.CellValue(1, "del_cd"));
			ComSetObjValue(formObj.bkg_de_term_cd, sheetObj.CellValue(1, "de_term_cd"));
			ComSetObjValue(formObj.cnee, sheetObj.CellValue(1, "cnee"));
			ComSetObjValue(formObj.nfty, sheetObj.CellValue(1, "nfty"));
			ComSetObjValue(formObj.shpr, sheetObj.CellValue(1, "shpr"));*/
			
			
			/*if(sheetObj.CellValue(1, "de_term_cd") == "D"){
				formObj.bkg_de_term_cd.style.color = "#ff0000";
				formObj.bkg_de_term_cd.style.fontWeight = "bold";
				ComShowCodeMessage("EAS80009");
				ComBtnDisable("btn_issue");
			}else{
				formObj.bkg_de_term_cd.style.color = "#606060";
				formObj.bkg_de_term_cd.style.fontWeight = "normal";
				ComBtnEnable("btn_issue");
			}*/

			//ComBtnDisable("btn_retrieve");
			//ComBtnEnable("btn_issue");
		}else{
			/*object_disable();

			ComSetObjValue(formObj.bkg_no, "");
			ComSetObjValue(formObj.bl_no, "");
			
			ComSetObjValue(formObj.pod_cd, "");
			ComSetObjValue(formObj.del_cd, "");
			ComSetObjValue(formObj.bkg_de_term_cd, "");
			ComSetObjValue(formObj.cnee, "");
			ComSetObjValue(formObj.nfty, "");
			ComSetObjValue(formObj.shpr, "");
			
			//Payer 초기화
			setPayerInfoClear();*/
			//alert(1);
		}
		
		
		//sheetObj.SelectCell(gvMyRow, "apro_rmk");
	}
    
    
    
    function setCellEditable(sheetObj) {
    	
    	// btn_flag Y 일 경우 comment 를 수정 할수 있게 editable 를 true 로 변경한다.
    	var target_btn_flag = document.getElementById('btn_flag');
		if(target_btn_flag.value == "Y"){
			for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
				
				//alert(sheetObj.CellValue(idx,"editable_yn"));
				if( sheetObj.CellValue(idx,"editable_yn") == "Y"){
					/*sheetObj.CellEditable(idx, "sel_chk") = false;
					sheetObj.CellEditable(idx, "dod_loc_cd") = false;
					sheetObj.CellEditable(idx, "bil_amt") = false;
					sheetObj.CellEditable(idx, "tax_amt") = false;*/
					
					
					sheetObj.CellEditable(idx, "apro_rmk") = true;
					
					gvMyRow = idx;
					
				}
			}
    	}
	}
    
    
    function chkEditMode(sheetObj){
    	sheetObj.SelectCell(gvMyRow, "apro_rmk");
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
    
    /**
     * Sheet 저장완료 후 이벤트 발생
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {

    	//alert(1);
    	//doActionIBSheet(sheetObj, document.form, IBSEARCH); // 파일링크를 위해 재조회
    }
