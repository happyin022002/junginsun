/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1093.js
*@FileTitle : Inbound C/S USA_Instruction Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2010.05.07 안진응
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.05 이지영 [CHM-201006263-01] INBOUND C/S USA_INSTRUCTION MAX 변경 요청
* 2012.05.16 김보배 [CHM-201217815] [BKG] Inbound CS_USA 화면 및 기능 변경사항 요청
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
     * @class esm_bkg_1093 : esm_bkg_1093 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1093() {
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
    var iNodeCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     * @author 안진응
     * @version 2009.07.09
     */
    function processButtonClick() {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_close":
					window.close();
                    break;
                case "btn_save":
                	doActionIBSheet(sheetObjects[0], document.form,IBSAVE);
                	break;
            }
//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
    }

    /**
    * IBSheet Object를 배열로 등록<br>
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
    * 배열은 소스 상단에 정의 <br>
    * 
    * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
    * @return 없슴
    * @author 안진응
    * @version 2009.07.09
    */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    function setComboObject(combo_obj){          
        comboObjects[comboCnt++] = combo_obj;
     }



    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
    * 
    * @return 없슴
    * @author 안진응
    * @version 2009.07.09
    */
    function loadPage() {

        for (var i=0; i<sheetObjects.length; i++) {

            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i], i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }
        axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
        

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        
        
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);           
        }
        
    }
     

    /**
    * 시트 초기설정값, 헤더 정의<br>
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
    * 
    * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
    * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
    * @return 없슴
    * @author 안진응
    * @version 2009.07.09
    */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
       

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadMode(false, true, false, true, false, false)

                    var HeadTitle1 = "ibflag|instr_rmk_seq|cre_usr_id|usr_nm|bkg_no|upd_locl_dt|upd_locl_gdt|instr_rmk|instr_rmk_tp_cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  80, daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "instr_rmk_seq",  false, "", dfNone,      0,     false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "cre_usr_id",     false, "", dfNone,      0,     false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "usr_nm",         false, "", dfNone,      0,     false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "bkg_no",         false, "", dfNone,      0,     false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "upd_locl_dt",    false, "", dfNone,      0,     false);                                                                                                                     
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "upd_locl_gdt",   false, "", dfNone,      0,     false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "instr_rmk",      false, "", dfNone,      0,     false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter,  false,  "instr_rmk_tp_cd",false, "", dfNone,      0,     false);
               }
                break;


        }
    }

    /**
    * Sheet관련 프로세스 처리 <br>
    * 
    * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
    * @param {object}  formObj  필수,HTML Form 오브젝트
    * @param {string}  sAction  필수,Action 명 
    * @return 없슴
    * @author 안진응
    * @version 2009.07.09
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        
    	//sheetObj.ShowDebugMsg = false;
    	sheetObj.WaitImageVisible = false;
        
        switch(sAction) {

            case IBSEARCH:      //조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            	
                ComOpenWait(true);
            
            	formObj.f_cmd.value = SEARCH;
                // (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])                	
            	sheetObj.DoSearch("ESM_BKG_1093GS.do", FormQueryString(formObj));
            	
            	ComOpenWait(false);
            	
                break;
                
            case IBSAVE:   //저장

            	if(validateForm(sheetObj, formObj, sAction)){
	            	
	                formObj.f_cmd.value = MODIFY;
	
	                if( !ComShowCodeConfirm('COM12147') ){
	                    return false;
	                }

	                var param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&instr_rmk=" + formObj.instr_rmk.value
	                			+ "&instr_rmk_tp_cd=" + formObj.rmk_tp.value;
	                
	                var sXml = sheetObj.GetSaveXml("ESM_BKG_1093GS.do", param);
	                
	                sheetObj.LoadSaveXml(sXml);
	                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
	                //sheetObjects["blIss"].LoadSaveXml(sXml);
	            }
	        	
            	break;                
            case IBDELETE:   //삭제
            	
                formObj.f_cmd.value = REMOVE;

                if( !ComShowCodeConfirm('BKG00535') ){
                    return false;
                }

                var param = "f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&instr_rmk_seq=" + formObj.instr_rmk_seq.value;	                
                
                var sXml = sheetObj.GetSaveXml("ESM_BKG_1093GS.do", param);

                sheetObj.LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
                //sheetObjects["blIss"].LoadSaveXml(sXml);
        	
                break;
                
            
            case SEARCH01 : //  TYPE 조회
				
				formObj.f_cmd.value = INIT;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1093GS.do", FormQueryString(formObj));
				
				ComXml2ComboItem(sXml, formObj.rmk_tp, "val", "name");
				ComOpenWait(false);
				
				break;	
        }
    }



    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
    * 
    * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
    * @param {object}  formObj  필수,HTML Form 오브젝트
    * @param {string}  sAction  필수,Action 명 
    * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
    * @author 안진응
    * @version 2009.07.09
    */
    function validateForm(sheetObj,formObj,sAction) {
    	if(sAction ==IBSEARCH){
            if (!ComChkValid(formObj)) return false;
        		with(formObj) {
            }
    	}else if(sAction ==IBSAVE){
        	// remark 값이 존재하는지 체크한다.
        	if(ComIsNull(document.form.instr_rmk)){
                ComShowCodeMessage('BKG00877'); //필수 조회 조건이 누락되었습니다. B/L No or Container No or BKG No가 필수 조회 조건입니다.
                ComSetFocus(document.form.instr_rmk);
                return false;
            }
        	// remark type 을 선택하였는지 확인한다
        	if(document.form.rmk_tp.value == '0'){
        		ComShowCodeMessage('BKG06141'); //Selection for Dwell Reason SVC Type is mandatory
                ComSetFocus(document.form.rmk_tp);
                return false;
        	}
    	}        
        return true;
    }

    /**
     * sheet1의 조회가 완료된 시점에 값을 설정한다.
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg   에러메시지
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
   function sheet1_OnSearchEnd(sheetObj, ErrMsg){
       var blNo = null;

       if (ErrMsg == "") {
           if(sheetObj.RowCount > 0){
        	   fnDispRemark(sheetObj);
           }
       }
   }    

     /**
      * sheet1를 저장하고 나서 처리할 사항
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg){
         if (iNodeCnt > 0) {
        	 fnRemoveNode(iNodeCnt);
         }
    	 
         document.form.instr_rmk.value = "";
         
         // 저장 후 콤보 초기화
         for(k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k],k+1);           
         }
         
    	 doActionIBSheet(sheetObj, document.form,IBSEARCH);         
     }     
   
    function fnRemoveRemark(){
    	var basicDiv = document.getElementById("div1");
    	
    	div.innerHTML = "";
		basicDiv.appendChild(div);		
    }
    
    function fnDispRemark(sheetObj){
    	var basicDiv = document.getElementById("div1");
    	
    	var strHead = "<tr class='h23'> <td style='padding-left:3;' width='745'> ";
    	var strBody = "<input type='text' style='width:670 ; ' class='noinput3' "; //body 너비 수정
    	var strButton = "<td style='padding-left:1;' width='' class='stm' ";
    	var strDate = "<td width='120'><input type='text'";
    	var strName = "<input type='hidden' style='width:135 ; ' class='noinput3' ";
    	var strUsrId = "<input type='text' style='width:80 ; ' class='noinput3' cursor: hand; onMouseOver='fngBkgToolTipView();' onMouseMove='fngBkgToolTipMove();' onMouseOut='fngBkgToolTipHide();' ";
    	var strType = "<input type='text' style='width:105 ; ' class='noinput3' ";
    	var strSeq = "<td width=''><input type='text'";
    	
    	var strHtml = "";
    	
    	var nCount = sheetObj.RowCount;
    	
    	var strRemark = "";
    	var strInstrRmk = "";
    	var strUpdLoclDt = "";
    	var strInstrRmkSeq = "";
    	var strUsrNm = "";
    	var strCreUsrId = "";
    	var strRmkTpCd = "";
    	var strRmkTp = "";
    	iNodeCnt = 0;
    	
    	for (var i=1; i <= nCount; i++) {
    		strUsrNm = sheetObj.CellValue(i,"usr_nm");
    		strInstrRmk = sheetObj.CellValue(i,"instr_rmk");
    		strUpdLoclDt = sheetObj.CellValue(i,"upd_locl_dt");
    		strInstrRmkSeq = sheetObj.CellValue(i,"instr_rmk_seq");
    		strCreUsrId = sheetObj.CellValue(i,"cre_usr_id");
    		strRmkTp = sheetObj.CellValue(i,"instr_rmk_tp_cd");
    		
//    		strRemark = strInstrRmk;
    		strRemark = replaceAll(strInstrRmk,"'","&#39;");
    		strRmkTpCd = strRmkTp;
    		
    		
    		var div = document.createElement("div");
    		
    		if (strCreUsrId == strUsr_id) {
    			strHtml = strHead + 
        		          strBody + " name='txt_rmk"+i+"' id='txt_rmk"+i+"' value='" + strRemark + "' readonly='true'></td>" + 
        		          strDate + " name='txt_upd_locl_dt"+i+"' id='txt_upd_locl_dt"+i+"' align='top' style='width:110;' class='noinput3' value='" + strUpdLoclDt + "' readonly='true'></td>" + 
        		          strName + " name='txt_usr_nm"+i+"' id='txt_usr_nm"+i+"' align='top' style='width:50;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strUsrNm + "' readonly='true'></td>" + 
        		          strUsrId + " name='txt_usr_id"+i+"' id='txt_usr_id"+i+"' align='top' style='width:50;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strCreUsrId + "' readonly='true'></td>" +
        		          strType + " name='txt_rmk_tp_cd"+i+"' id='txt_rmk_tp_cd"+i+"' align='top' style='width:50;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strRmkTpCd + "' readonly='true'></td>" +
        		          strSeq + " name='instr_rmk_seq"+i+"' id='instr_rmk_seq"+i+"' style='width:0;' class='input2' value='" + strInstrRmkSeq + "' readonly='true'></td>" +
                          
                          "<td width='' class=''><img class='cursor' name='btn_delete"+i+"' OnClick='fnDeleteNode("+strInstrRmkSeq+")' src='img/btns_del_1.gif' width='19' height='20' border='0' align='absmiddle' ></td> </tr>";
    		} else {
    			strHtml = strHead + 
        		          strBody + " name='txt_rmk"+i+"' id='txt_rmk"+i+"' value='" + strRemark + "' readonly='true'></td>" + 
		                  strDate + " name='txt_upd_locl_dt"+i+"' id='txt_upd_locl_dt"+i+"' align='top' style='width:110;' class='noinput3' value='" + strUpdLoclDt + "' readonly='true'></td>" + 
        		          strName + " name='txt_usr_nm"+i+"' id='txt_usr_nm"+i+"' align='top' style='width:120;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strUsrNm + "' readonly='true'></td>" + 
		                  strUsrId + " name='txt_usr_id"+i+"' id='txt_usr_id"+i+"' align='top' style='width:50;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strCreUsrId + "' readonly='true'></td>" +
		                  strType + " name='txt_rmk_tp_cd"+i+"' id='txt_rmk_tp_cd"+i+"' align='top' style='width:50;overflow:hidden;text-overflow:ellipsis;font-weight:normal;' value='" + strRmkTpCd + "' readonly='true'></td>" +
        		          strSeq + " name='instr_rmk_seq"+i+"' id='instr_rmk_seq"+i+"' style='width:0;' class='input2' value='" + strInstrRmkSeq + "' readonly='true'></td> </tr>";
    		}
    		
    		div.innerHTML = strHtml;
    		basicDiv.appendChild(div);  
    		
    		iNodeCnt = iNodeCnt + 1;
//    		div.innerHTML = "내용"; 
    	}
    }    
    
    
    function fnRemoveNode(iCnt) {

    	var div = document.getElementById("div1");
        var reset_div = div.cloneNode(false);

        div.parentNode.replaceChild(reset_div, div);

    }
    
    
    function fnDeleteNode(iSeq) {
    	document.form.instr_rmk_seq.value = iSeq;
    	
    	doActionIBSheet(sheetObjects[0], document.form, IBDELETE); 
    }
    
    
    /**
     * 콤보 초기설정값
     * 
     * @param comboObj
     * @param comNo
     * @return
     */
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
        	case "rmk_tp":
        		
        		var i = 0;
        		
        		doActionIBSheet(sheetObjects[0],document.form, SEARCH01);
        		// 초기값으로 Dwell Reason SVC Type 을 보여주기 위해 추가
        		comboObj.InsertItem( i++, "Dwell Reason SVC Type" , "0");
        		
        		comboObj.Code = "0";
        		comboObj.SetColWidth("50|550|0");
        		comboObj.DropHeight= 350;
        		break;
               
     	    default:
     	    	comboObj.MultiSelect = false;
     			comboObj.UseCode = true;
     			comboObj.LineColor = "#ffffff";
     			comboObj.SetColAlign("left|left");
     			comboObj.MultiSeparator = "|";
     	    	break;
         }
    }
    
    
    
    // 선택된 remark type 값을 폼에 value 로 할당
    function rmk_tp_OnChange(comboObj, value, text)
    {
    	document.form.rmk_tp.value = value;
    }
    
    
    
    /**
     * 값을 치환
     * 
     * @param strTemp 
     * @param strValue1 
     * @param strValue2 치환 변수
     */
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
    
    
    /**
     * 툴팁 이동하기
     * @param :evt
     */
    function fngBkgToolTipMove(evt) {
    	if (navigator.appName == "Netscape") {
    		helpbox.style.left = evt.pageX + 10;
    		helpbox.style.top = evt.pageY + 20;
    	} else {
    		helpbox.style.posLeft = event.x + 10 + document.body.scrollLeft;
    		helpbox.style.posTop = event.y + 20 + document.body.scrollTop;
    	}
    }
    
    /**
     * 툴팁 보이기 
     * @param :str
     */
    function fngBkgToolTipView() {

    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");

    	var row = srcName.substr("txt_usr_id".length, srcName.length + 1);
    	
//    	alert(document.getElementById("txt_usr_nm" + row).value);
    	var showMsg = document.getElementById("txt_usr_nm" + row).value; 
    	
    	var str = showMsg;
    	if(str == null || str == 'undefined') return;
    	var text;
    	text = '<table align="center" border="0" cellpadding="10" cellspacing="0" style="border-width:3; border-color:#3a679e; background-color:#eaf3ff ;border-style:solid;font-size:9pt;">';
    	text += '<tr><td align=center>' + str + '</td></tr></table>';
    	helpbox.innerHTML = text;
    }
    
    /**
     * 툴팁 숨기기  
     */
    function fngBkgToolTipHide() {
    	helpbox.innerHTML = '';
    }

    
	/* 개발자 작업  끝 */