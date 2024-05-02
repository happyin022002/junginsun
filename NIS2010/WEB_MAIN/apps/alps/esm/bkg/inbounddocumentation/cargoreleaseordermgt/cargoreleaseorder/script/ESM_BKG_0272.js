/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0272.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.14 손윤석
* 1.0 Creation
===============================================================================
 History
* 2012.11.13 조정민 [CHM-201221007] [EUR Cargo Release] P/up Date 시간변경 (0000->2400)
* 2012.11.22 조정민 [CHM-201221094] POD DE일 경우 EU Full CNTR Release 에서 Email 전송시 전송내역 추가 요청
* 2012.12.03 조정민 [CHM-201221517][EU Full CNTR RLS] DEL컬럼 추가- 검색조건/검색결과
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var chk_flag = "N";

document.onclick = processButtonClick;

/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */ 
function processButtonClick()
{
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];

    /*******************************************************/
    var formObj = document.form;

    try 
    {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) 
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObj,IBSEARCH);
                break;
            case "btn_DownExcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;
            case "btn_CNTRMvmt":
                funcCTMCall(sheetObject);
                break;
            case "btn_Remark":
                if(!funcCheckRowValid(sheetObject)) return;
                
                // 데이터를 2개 선택하지 못하도록 한다. Add by Park Mangeon At 20091103
                var sRowStr = sheetObject.GetSelectionRows("|");
            	var sRowArr = sRowStr.split("|");
            
                if (sRowStr == "0" ) {
                	return;
                } else if (sRowArr.length > 1) {
            		//Select Only one row.
            		ComShowCodeMessage("BKG40075");
            		return;
                }

                
                funcSelectRowData(formObj, sheetObject);
                funcRemarkPopup(sheetObject);
                break;
            case "btn_EMail_TMNL":
            	var emailParam = "TMNL";
            	
                if(!funcCheckRowValid(sheetObject)) return;
                formObj.in_checktype.value = "M";
              
                
                var chkMail = fnChkEMail(sheetObject, formObj, emailParam);
                
                
                if (chkMail == true) {
                	var sXml = IBS_GetDataSearchXml(sheetObjects[1]);
                    document.form.mailXml.value = sXml;
                	
                	funcSendMailPopup(formObj, emailParam);
                }
                break;
                
            case "btn_EMail_CUST":

            	var emailParam = "CUST";
            	
                if(!funcCheckRowValid(sheetObject)) return;
                formObj.in_checktype.value = "M";
              
                
                var chkMail = fnChkEMail(sheetObject, formObj, emailParam);

                
                if (chkMail == true) {
                	var sXml = IBS_GetDataSearchXml(sheetObjects[1]);
                	document.form.mailXml.value = sXml;
                	funcSendMailPopup(formObj, emailParam);
                }
                
                break;
                
            case "btn_EDI":
                for(i=1; i<sheetObject.Rows; i++) 
                {
//                  2010.04.09 수정 지침에 따라서 수정(안진응)
//                    sheetObject.CellValue(i, sheetObject.SaveNameCol("ibflag")) = 'R';
                    sheetObject.RowStatus(i) = "R";
                }
              
                var validOk = true;
                if(!funcCheckRowValid(sheetObject)) return;
                formObj.in_checktype.value = "E";                
                
                //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = sheetObject.GetSelectionRows("/");
                //자바 스크립트 배열로 만들기
                var arr = sRowStr.split("/");
             
                for(i=0; i<arr.length; i++) 
                {
                	var cntrNo   = sheetObject.CellValue(arr[i], "cntr_no");
                    var pkupDt   = sheetObject.CellValue(arr[i], "cgo_pkup_dt");
                    var ydCd     = sheetObject.CellValue(arr[i], "yd_cd");     
                    var doNoYn   = sheetObject.CellValue(arr[i], "do_no_yn");
                    var bkgCgoTpCd   = sheetObject.CellValue(arr[i], "bkg_cgo_tp_cd");         
                    var uqVslIdNo   = sheetObject.CellValue(arr[i], "uq_vsl_id_no");
                    var pinNo 	 = sheetObject.CellValue(arr[i], "pin_no");
                    var coBdgId  = sheetObject.CellValue(arr[i], "co_bdg_id");
                    var rlseExpDt   = sheetObject.CellValue(arr[i], "rlse_exp_dt");
                    var toDay       = ComGetNowInfo("ymd")+ComGetNowInfo("hm");
                    var cgoCrrId  = sheetObject.CellValue(arr[i], "cgo_crr_id");

                    
                    if(ydCd == null || ydCd == '')
                    {
                        ComShowCodeMessage("BKG40100", "pickup yard", cntrNo);
                        return false;
                    }
                    if(ydCd.length != 7)
                    {
                        ComShowCodeMessage("BKG40102","pickup yard" + "["+ ydCd + "]",cntrNo);
                        validOk = false;
                        break;
                    }
//                    if(pkupDt == null || pkupDt == ''  )
//                    {
//                        ComShowCodeMessage("BKG40100", "pickup date", cntrNo);
//                        return false;
//                    }
//                 
//                    if(pkupDt.length != 8)
//                    {
//                        ComShowCodeMessage("BKG40102","pickup date" + "["+ pkupDt + "]",cntrNo);
//                        validOk = false;
//                        break;
//                    }  
                    
                    if((uqVslIdNo != null && uqVslIdNo != '') && uqVslIdNo.length < 5)
                    {
                        ComShowCodeMessage("BKG95018", "UVI No.", "5digit");
                        validOk = false;
                        break;
                    }
                    
                    if((pinNo != null && pinNo != '') && pinNo.length < 4)
                    {
                        //ComShowCodeMessage("BKG95018", "PIN", "4digit");
                        ComShowCodeMessage("BKG95018", "PIN", "between 4 and 7 digit"); //2011.07.11 입력자리수 변경(4 -> 4~7)
                        validOk = false;
                        break;
                    }
                    
                    if((coBdgId != null && coBdgId != '') && coBdgId.length < 3)
                    {
                        ComShowCodeMessage("BKG95018", "Badge Code", "3");
                        validOk = false;
                        break;
                    }
                    
                    toDay = ComReplaceStr(toDay, "-", ""); 
                    toDay = ComReplaceStr(toDay, ":", ""); 
                    if(rlseExpDt != '' && rlseExpDt.substr(0,8) < toDay.substr(0,8)) 
                    {
                        ComShowCodeMessage("COM12131", "Release Expiry Date");
                        validOk = false;
                        break;
                    }
                    
                    if((cgoCrrId != null && cgoCrrId != '') && cgoCrrId.length < 3)
                    {
                        ComShowCodeMessage("BKG06065", "Trucker code/Name");
                        validOk = false;
                        break;
                    }
                    
//                  2010.04.09 수정 지침에 따라서 수정(안진응)
//                    sheetObject.CellValue(arr[i], sheetObject.SaveNameCol("ibflag")) = 'U';
					sheetObject.RowStatus(arr[i]) = "U";
                }
                
                if(!validOk) return;
                //EDI 전송
                
                doActionIBSheet(sheetObject,formObj,SEARCH01);
                if(chk_flag == "N"){
	                if(!ComShowCodeConfirm("BKG01070")) return;
	                doActionIBSheet(sheetObject,formObj,MULTI01);
                }
                
                break;
            case "btn_CargoRelease":
            	fnGoCargoRelease(sheetObjects[0]);
                break;
            case "btn_Print":
                if(!funcCheckRowValid(sheetObject)) return;
                sheetObject.Down2Print(true, poLandscape , "Full Container Release", 1.5, 1.5);
                break;
            case "rad_vvd":
                funcChangeRadio(formObj, 'VVD');
                break;
            case "rad_bl":
                funcChangeRadio(formObj, 'BL')
                break;
       } // end switch
    }
    catch(e) 
    {
        if( e == "[object Error]") 
        {
        	 ComShowCodeMessage("BKG40101");
        } 
        else 
        {
            ComShowMessage(e);
        }
    }
}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function loadPage() 
{
    
	 doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	 
	 for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    initControl();

    if(document.form.in_bl_no.value.length > 0)
    {
        funcChangeRadio(document.form, 'BL', document.form.in_bl_no);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    else
    {
        funcChangeRadio(document.form, 'VVD', document.form.in_vvd);
    }
    
    
    
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function initControl() 
{
    var formObject = document.form;
    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
    axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  formObject); //- 포커스 나갈때
    axon_event.addListenerFormat('beforeactivate'  ,'obj_activate',    formObject); //- 포커스 들어갈때
    axon_event.addListenerFormat('keypress'        ,'obj_keypress', document.form);
    axon_event.addListenerFormat('keyup'           ,'keyupcheck',      formObject);
    axon_event.addListener      ('keydown'         ,'ComKeyEnter',         'form');
}

/**
 * Focus를 가졌을때 발생하는 이벤트<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01 
 */
function obj_activate()
{
    var form = document.form;
    var srcName = event.srcElement.getAttribute("name");
    
    switch(srcName)
    {
    case 'in_vvd':
        funcChangeRadio(form, "VVD");
        break;
    case 'in_pod':
        funcChangeRadio(form, "VVD");
        break;
    case 'in_bl_no':
        funcChangeRadio(form, "BL");
        break;
    }
}

/**
 * Key Up Event받아서 자리수만큼 입력다됬을 경우 다음 객체로 포커스 이동
 * @param {void}
 * @return void
 */
function keyupcheck()
{
    var form = document.form;
    var key = event.keyCode;
    var srcValue = event.srcElement.getAttribute("value");
    var dtaLength = event.srcElement.getAttribute("maxlength");
    var srcLength = srcValue.length; 
    var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName = event.srcElement.getAttribute("name");
  
    if(srcLength < dtaLength) return;
  
    switch(srcName)
    {
    case 'in_vvd':
        form.in_pod.focus();
        break;
    case 'in_pod':
        form.in_cntr_no.focus();
        break;
    case 'in_bl_no':
        form.in_cntr_no.focus();
        break;
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @param {String} CondParam 필수, 서버전송 정보
 * @param {int} PageNo 선택, 페이지 번호
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction)
{
    switch(sAction)
    {
        case IBSEARCH:
            if(formObj.in_option.value == 'VVD')
            {
                if(!ComChkObjValid(formObj.in_vvd)) return false;
                if(!ComChkObjValid(formObj.in_pod)) return false;
                if(formObj.in_del.value != "")
                	if(!ComChkObjValid(formObj.in_del)) return false;
             }
            else
            {
                if(!ComChkObjValid(formObj.in_bl_no)) 
                {
                    funcChangeRadio(document.form, 'VVD', document.form.in_vvd);
                    formObj.in_vvd.focus();
                    return false;
                }
            }
            break;
//        case COMMAND03:
//        	var sRowStr = sheetObj.GetSelectionRows();
//
//        	var arr = sRowStr.split("|");
//        	
//        	var colIndex = "";
//        	var rowIndex = "";
//        	var now = "";
//        	var dateValue = "";
//        	var celValue = "";
//        	
//        	for (i=0; i<arr.length; i++) {
//        	    //선택한 Row마다 야드 코드와  
//
//            	colIndex = sheetObj.SaveNameCol("yd_cd");     
//                
//                rowIndex = arr[i];
//                if(isNaN(colIndex)) 
//                {
//                    ComShowCodeMessage("BKG00155");
//                    return false;
//                }
//
//               
////                funcSelectRowData(formObj, sheetObj);
//                now   = new Date();
//                
//                formObj.p_send_date.value = formatDate(now, "dd / MMM / yy - hh:mm a");
//                
//                dateValue = strToDate(formObj.p_cgo_pkup_dt.value);
//                
//                formObj.p_cgo_pkup_dt.value = formatDate(dateValue, "ddMMMyy");                 
//                
//                celValue = sheetObj.CellValue(rowIndex, colIndex);         
//              
//                
//                if(celValue == null || celValue == '')
//                {
//                    ComShowCodeMessage("BKG40100", "pickup yard", sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
//                    return false;
//                }
//                
//                if(celValue.length != 7)
//                {
//                    ComShowCodeMessage("COM132201","pickup yard" + "["+ celValue + "]");
//                    validOk = false;
//                    break;
//                }          
//       
//                colIndex = sheetObj.SaveNameCol("cgo_pkup_dt");
//                if(isNaN(colIndex))
//                {
//                    ComShowCodeMessage("BKG00155");
//                    return false;
//                }
//
//                celValue = sheetObj.CellValue(rowIndex, colIndex);
//                if(celValue==null || celValue == '')
//                {
//                	 ComShowCodeMessage("BKG40100", "pickup date", sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
//                     return false;
//                }
//                if(celValue.length != 8)
//                {
//                	 ComShowCodeMessage("COM132201","pickup date" + "["+ celValue + "]");
//                	 return false;
//                }        		
//        	}
//
//        	break;
    }

    return true;
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo Sheet Index 번호
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) 
{
    var cnt = 0;
    switch(sheetNo) 
    {
        case 1:      //sheet1 init
            with (sheetObj) 
            {
                // 높이 설정
                style.height = 440;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                //Ctrl키를 눌러 다중행을 선택함 2011.07.11 추가 
                SelectionMode = smSelectionList;
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(42, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
            
                var HeadTitle1 = "||Seq.|Err|B/L No.|BKG No.|Container|TP/SZ|Consignee|Yard|E-Mail|T/VVD|POL|POD|DEL|D/O|D/O No|PIN|Badge Code|Release Expiry Date|Trucker Code/Name|Vechicle Registration|R.H.I.D.S Code|UVI No.|Fax No.|ATB#|T-Mode|ATP No.|F/Forwarder|Party to invoice|MT return yard|P/Up DT|Release Notes|Del. Term|Sent|Yard Name|Email|Phone No|Vessel Name|Location||";
            
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
            
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,  30,     daCenter,    false,   "ibflag");
                InitDataProperty(0, cnt++ , dtHidden,        180,    daLeft,      true,    "diff_rmk",        false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtSeq,           30,     daCenter,    false,   "Seq");
                InitDataProperty(0, cnt++ , dtCheckBox,      30,     daCenter,    true,    "err",             false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "bl_no",           false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "bkg_no",          false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "cntr_no",         false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          80,     daCenter,    true,    "cntr_tpsz_cd",    false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          180,    daLeft,      true,    "cust_nm",         false,    "",      dfNone,            0,    true,     true);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "yd_cd",           false,    "",      dfEngUpKey,        0,    true,     true);
                InitDataProperty(0, cnt++ , dtData,          200,    daCenter,    true,    "cust_eml",        false,    "",      dfNone,    	    0,    true,     true);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "vvd",             false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "pol_cd",          false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "pod_cd",          false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "del_cd",          false,    "",      dfNone,            0,    false,    false);
                
                InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "do_no_yn",        false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "do_no",           false,    "",      dfNone,            0,    false,    false);

                //InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "pin_no",		  false,    "",      dfNone,         0,    true,    true, 4);
                InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "pin_no",		  false,    "",      dfNone,         0,    true,    true, 7); //2011.07.11 입력자리수 변경(4 -> 4~7)
                InitDataProperty(0, cnt++ , dtData,          80,     daCenter,    true,    "co_bdg_id",       false,    "",      dfEngUpKey,        0,    true,    true, 3);
                InitDataProperty(0, cnt++ , dtData,          130,    daCenter,    true,    "rlse_exp_dt",     false,    "",      dfDateYmd,         0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          130,    daCenter,    true,    "cgo_crr_id",      false,    "",      dfEngUpKey,        0,    true,    true, 14);
                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    "veh_rgst_id",     false,    "",      dfEngUpKey,        0,    true,    true, 8);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "road_hlg_id",     false,    "",      dfNone,         0,    true,    true, 7);
                InitDataProperty(0, cnt++ , dtData,          70,     daCenter,    true,    "uq_vsl_id_no",    false,    "",      dfNone,         0,    true,    true, 5);
                
                InitDataProperty(0, cnt++ , dtData,          120,    daCenter,    true,    "fax_no",          false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    "msg_acpt_ref_no",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtCombo,         100,    daCenter,    true,    "bkg_trsp_mod_cd", false,    "",      dfNone,    0,    true,    true);
//                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "cgo_pkup_dt",     false,    "",      dfUserFormat2,     0,    true,    true);
                
                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    "cstms_voy_no",     false,    "",      dfNone,     0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    "frt_fwrd_cd",     false,    "",      dfNone,     0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    "pty_to_inv_cd",     false,    "",      dfNone,     0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          150,    daCenter,    true,    "mt_ret_cy_cd",     false,    "",      dfNone,     0,    false,    false);
                
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "cgo_pkup_dt",     false,    "",      dfDateYmd,     0,    true,    true);
                InitDataProperty(0, cnt++ , dtCombo,         90,     daCenter,    true,    "cxl_flg",         false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          80,     daCenter,    true,    "de_term_cd",      false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          60,     daCenter,    true,    "sent_flg",        false,    "",      dfNone,            0,    false,    false);
                
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "yd_nm",           false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "yd_eml",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "phn_no",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "vsl_nm",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "loc_nm",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        80,     daLeft,      true,    "do_iss_dt",       false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "bkg_cgo_tp_cd",   false,    "",      dfNone,            0,    true,    true);

                InitDataCombo(0, "bkg_trsp_mod_cd", "Truck|Rail|Feeder|Barge", "T|R|F|B");
               if(document.form.upd_ofc_flg.value == "Y"){
            	   InitDataCombo(0, "cxl_flg", "Cancel|None|Update", "Y|N|U");
               }else{
            	   InitDataCombo(0, "cxl_flg", "Cancel|None", "Y|N");
               }
                             	
//                InitUserFormat2(0, "cgo_pkup_dt", "####-##-##", "-|" );  // 안진응 주석 처리(날자만 입력 받을 수 있도록 수정)
                InitDataValid(0, "co_bdg_id", vtEngUpOnly);
                InitDataValid(0, "pin_no", vtEngOther, "1234567890");
                InitDataValid(0, "road_hlg_id", vtNumericOnly);
                InitDataValid(0, "uq_vsl_id_no", vtNumericOnly);
            }
        break;
        case 2:
            with (sheetObj) 
            {
                // 높이 설정
                style.height = 0;
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
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(24, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                var HeadTitle1 = "|B/L No.|BKG No.|Container|POD|Yard|P/Up DT|Yard Name|Email|Phone No|Fax No.|||||||||||||";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,   30,    daCenter,    false,   "ibflag");
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "bl_no",           false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "bkg_no",          false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "cntr_no",         false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "pod_cd",          false,    "",      dfNone,            0,    false,    false);
                             
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "yd_cd",           false,    "",      dfEngUpKey,        0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "cgo_pkup_dt",     false,    "",      dfDateYmd,     0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "yd_nm",           false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "yd_eml",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "phn_no",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          120,    daCenter,    true,    "fax_no",          false,    "",      dfNone,            0,    false,    false);

                InitDataProperty(0, cnt++ , dtHidden,        180,    daLeft,      true,    "diff_rmk",        false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "vsl_nm",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "vvd",             false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtHidden,        10,     daLeft,      true,    "loc_nm",          false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          180,    daLeft,      true,    "cust_nm",         false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          180,    daLeft,      true,    "cust_eml",        false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtCombo,         100,    daCenter,    true,    "bkg_trsp_mod_cd", false,    "",      dfNone,    0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "send_date",       false,    "",      dfNone,    0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          100,    daCenter,    true,    "do_no",           false,    "",      dfNone,            0,    false,    false);
                InitDataProperty(0, cnt++ , dtHidden,        80,     daLeft,      true,    "do_iss_dt",       false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtHidden,        60,     daCenter,    true,    "pin_no",		  false,    "",      dfNone,         0,    true,    true, 7); //2011.07.11 입력자리수 변경(4 -> 4~7)
                InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,    true,    "msg_acpt_ref_no",           false,    "",      dfNone,            0,    true,    true);
                InitDataProperty(0, cnt++ , dtData,          130,    daCenter,    true,    "rlse_exp_dt",     false,    "",      dfDateYmd,         0,    true,    true);
                
                InitDataCombo(0, "bkg_trsp_mod_cd", "Truck|Rail|Feeder|Barge", "T|R|F|B");
                
            }
        break;
        
    }
}

/**
 * Sheet관련 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {String} sAction 필수, 작업코드
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj, formObj, sAction) 
{
   //sheetObj.ShowDebugMsg = false;
    var status = '';
    switch(sAction) 
    {
        case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
            if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.DoSearch("ESM_BKG_0272GS.do", FormQueryString(formObj));
            break;
        case IBDOWNEXCEL:  //엑셀 다운로드
            sheetObj.SpeedDown2Excel(1, false, false, "", "", false, false, "FullCargoRelease",false, "0|1" );
            break;
        case MULTI01:
            //EDI 전송
          
            formObj.f_cmd.value = MULTI01;           
            var saveStr = sheetObj.GetSaveString(); 
            
            var xml = sheetObj.GetSaveXml("ESM_BKG_0272GS.do", FormQueryString(formObj) + "&" + saveStr);
                         
	        var rMsg = ComResultMessage(xml);
         
            if(rMsg != ''){
            	var State = ComGetEtcData(xml, ComWebKey.Trans_Result_Key);
				if(State == "S"){
					 //sheetObj.LoadSaveXml(xml);					 
					 ComShowCodeMessage("BKG00101");					 
				} else {
					//sheetObj.LoadSaveXml(xml);
					ComShowMessage(rMsg);
					//ComDeleteMsg(xml); 
					// alert(rMsg.split('<||>').join('\n'));
				}
			 }           
            
             break;     
       
        case SEARCH01:
            //Pickup Date 및 Release Expire Date 항목 체크
          
            formObj.f_cmd.value = SEARCH01;           
            var saveStr = sheetObj.GetSaveString(); 

            var xml = sheetObj.GetSaveXml("ESM_BKG_0272GS.do", FormQueryString(formObj) + "&" + saveStr);      
			if(ComGetEtcData(xml,"TRANS_RESULT_KEY") == "F"){
				sheetObj.LoadSaveXml(xml);
				chk_flag = "Y";
			} else
				chk_flag = "N";
            
             break;    
             
             
        case SEARCH02:
            //Pickup Date 및 Release Expire Date 항목 체크
          
            formObj.f_cmd.value = SEARCH02;           
            
            var xml = sheetObj.GetSaveXml("ESM_BKG_0272GS.do", FormQueryString(formObj));  
          
			if(ComGetEtcData(xml,"upd_ofc_flg") == "Y"){
				document.form.upd_ofc_flg.value = "Y";
			} else
				document.form.upd_ofc_flg.value = "N";
            
             break; 
    }
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.<br>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function obj_keypress()
{
    var key = event.keyCode;
    
    switch(event.srcElement.dataformat)
    {
        case "float":
            //숫자+"."입력하기
            ComKeyOnlyNumber(event.srcElement, ".");
            break;
        case "eng":
            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
            //ComKeyOnlyAlphabet();
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
            ComKeyOnlyAlphabet('lower');
            break;
        case "engup":
            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        default:    
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
    
}

/**
 * HTML 검색옵션에 따른 활성화여부 결정<br>
 * @param {Object} formObj 선택, 페이지 번호
 * @param {String} isvvd  VVD인지 여부 VVD일경우 "VVD" input
 * @param {Object} obj Form의 Object
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcChangeRadio(formObj, isvvd, obj)
{
    if(isvvd == 'VVD')
    {
        formObj.rad_vvd.checked = true;
        formObj.rad_bl.checked = false;
        formObj.in_option.value = 'VVD';
        formObj.in_vvd.className = "input1";
        formObj.in_pod.className = "input1";
        formObj.in_bl_no.className = "input";
        if(obj == null)formObj.in_vvd.focus();
        else obj.focus();
    }
    else
    {
        formObj.rad_vvd.checked = false;
        formObj.rad_bl.checked = true;
        formObj.in_vvd.className = "input";
        formObj.in_pod.className = "input";
        formObj.in_bl_no.className = "input1";
        formObj.in_option.value = 'BL';
        if(obj == null)formObj.in_bl_no.focus();
        else obj.focus();
    }
}

/**
 * Sheet에 있는 Data를 Form으로 복사한다.<br>
 * @param {Object} formObj 선택, 페이지 번호
 * @param {Object} sheetObj 필수, Sheet객체
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcSelectRowData(formObj, sheetObj)
{
    var rowIndex = sheetObj.SelectRow;

    formObj.p_diff_rmk.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("diff_rmk"));
    formObj.p_err.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("err"));
    formObj.p_bl_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("bl_no"));
    formObj.p_bkg_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("bkg_no"));
    formObj.p_cntr_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cntr_no"));
    formObj.p_cntr_tpsz_cd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cntr_tpsz_cd"));
    formObj.p_yd_cd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("yd_cd"));
    formObj.p_cust_nm.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cust_nm"));
    formObj.p_cust_eml.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cust_eml"));
    formObj.p_vvd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("vvd"));
    formObj.p_pol_cd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("pol_cd"));
    formObj.p_pod_cd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("pod_cd"));
    formObj.p_do_no_yn.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("do_no_yn"));
    formObj.p_do_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("do_no"));
    formObj.p_do_iss_dt.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("do_iss_dt"));   
    formObj.p_fax_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("fax_no"));
    formObj.p_bkg_trsp_mod_cd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("bkg_trsp_mod_cd"));
    formObj.p_cgo_pkup_dt.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cgo_pkup_dt"));
    formObj.p_cxl_flg.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cxl_flg"));
    formObj.p_de_term_cd.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("de_term_cd"));
    formObj.p_sent_flg.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("sent_flg"));
    formObj.p_yd_nm.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("yd_nm"));
    formObj.p_yd_eml.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("yd_eml"));
    formObj.p_phn_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("phn_no"));
    formObj.p_vsl_nm.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("vsl_nm"));
    formObj.p_loc_nm.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("loc_nm"));
    formObj.p_pin_no.value = sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("pin_no"));
    
    
//  2010.04.09 수정 지침에 따라서 수정(안진응)
//    sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("ibflag")) = "U";
    sheetObj.RowStatus(rowIndex) = "U";
}

/**
 * BL Editing Poput을 호출한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcRemarkPopup(sheetObj)
{
    var rowIndex = sheetObj.SelectRow;
    var colIndex = sheetObj.SaveNameCol("diff_rmk");
    var celValue = sheetObj.CellValue(rowIndex, colIndex);
    document.form.p_row.value = rowIndex;
    document.form.p_diff_rmk.value = celValue;
    
    var condition = "?pgmNo=ESM_BKG_1052&";
    condition += FormQueryString(document.form);
    
    ComOpenPopup("/hanjin/ESM_BKG_1052.do" + condition, 500, 250, "0002", "1,0", false);
}

/**
 * BL Editing Poput을 호출한다.<br>
 * @param {int} rowIdx 필수, Sheet의 선택된 행
 * @param {String} remarkvalue 필수, 입력될 Remark값
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcSetRemark(rowIdx, remarkvalue)
{
    var sheetObj = sheetObjects[0];
    var i_row = parseInt(rowIdx);
    
    sheetObj.CellValue(i_row, sheetObj.SaveNameCol("diff_rmk")) = remarkvalue;
}

/**
 * 메일용 팝업을 호출한다.<br>
 * @param {Object} formObj 필수, Form 객체
 * @param emailParam 1.E-mail for TMNL : 터미널 Yard 에게 보내는 경우
 *                   2.E-mail for CUST : 화주에게 보내는 경우
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcSendMailPopup(formObj, emailParam)
{
    var condition = "?";
    formObj.f_cmd.value = REPLY;    //Mail Content 내용 자동 생성
    ComOpenPopup("/hanjin/ESM_BKG_0272_1.do?emailParam="+emailParam, 600, 650, "0002", "1,0", false);
}

/**
 * CTM팝업 화면을 호출한다.<br>
 * @param {Object} sheetObj 필수, Form 객체
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcCTMCall(sheetObj)
{
    if(!funcCheckRowValid(sheetObj)) return;
    var sRowStr = sheetObj.GetSelectionRows("|");
    var sRowArr = sRowStr.split("|");
    var cntrNo = "";
    var tpszCd = "";
    
    if (sRowStr != "0" ) {
    	if (sRowArr.length > 1) {
    		//Select Only one row.
    		ComShowCodeMessage("BKG08040");
    		return;
    	}
    	cntrNo = sheetObj.CellValue(sRowArr[0], "cntr_no");
    	tpszCd = sheetObj.CellValue(sRowArr[0], "cntr_tpsz_cd"); 
    }
        
    var condition = "?pgmNo=EES_CTM_0411"
    	           + "&cntrNo=" + cntrNo
                   + "&typeSize=" + tpszCd;
    
    ComOpenPopup("/hanjin/EES_CTM_0411.do" + condition, 1020, 660, "0002", "1,0", false);
}
 
/**
 * EU Cargo Release화면을 호출한다.<br>
 * @param {Object} sheetObj 필수, Form 객체
 * @return {void} 
 * @author Park Mangeon
 * @version 2009.11.03
 */
function fnGoCargoRelease(sheetObj) {
    if(!funcCheckRowValid(sheetObj)) return;
    var sRowStr = sheetObj.GetSelectionRows("|");
    var sRowArr = sRowStr.split("|");
    var bkgNo = "";
    
    if (sRowStr != "0" ) {
    	if (sRowArr.length > 1) {
    		//Select Only one row.
    		ComShowCodeMessage("BKG08040");
    		return;
    	}
    	bkgNo = sheetObj.CellValue(sRowArr[0], "bkg_no");
    }
	
    var condition = "?pgmNo=ESM_BKG_0938"
        + "&bkg_no=" + bkgNo;
	
	ComOpenPopup("/hanjin/ESM_BKG_0938.do" + condition, 1024, 700, "0002", "1,0", false, null, null, null, null, null, "yes");

}

/**
 * 메일 발송 기록을 조회한다.<br>
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
 /*
function funcSendMailHistory()
{
    return doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
}
*/

/**
 * String을 Data형 데이터로 변환한다.<br>
 * @param {String} sDate 필수, 날자
 * @return {Date} String에 해당하는 Date 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function strToDate(sDate) 
{
    try 
    {
        sDate = sDate.replace(/\/|\-|\.|\:|\ /g,"");  //날짜구분자,시간구분자,스페이스 없애기
        
        var arr = ComNumberArray(7);
        var iLen = sDate.length;
        
        if (iLen>=4) arr[0]  = sDate.substr(0,4);        //year
        if (iLen>=6) arr[1]  = sDate.substr(4,2)-1;        //month
        if (iLen>=8) arr[2]  = sDate.substr(6,2);        //day
        
        if (iLen>=10) arr[3] = sDate.substr(8,2);        //hours
        if (iLen>=12) arr[4] = sDate.substr(10,2);        //minutes
        if (iLen>=14) arr[5] = sDate.substr(12,2);        //seconds
        if (iLen<=17) arr[6] = sDate.substr(14);        //hour
        
        return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
        
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * Sheet에 있는 데이터를 검증한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return {boolean} valid여부 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcCheckRowValid(sheetObj)
{
    var rowIndex = sheetObj.SelectRow;
    if(rowIndex < 1 || isNaN(rowIndex))
    {
        ComShowCodeMessage("BKG95010");
        return false;
    }
    return true;
}

/**
 * Sheet를 Double Click했을 경우 데이터를 처리한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {int} row 필수, Sheet의 행
 * @param {int} col 필수, Sheet의 열
 * @return {void} 
 * @author Son Yunseok
 * @version 2009.10.01
 */
function sheet1_OnDblClick(sheetObj,row,col)
{
    formObj = document.form;
    with(sheetObj)
    {
        if(row >= 1)
        {
            var bl_no = sheetObj.CellValue(row, sheetObj.SaveNameCol("bl_no"));
            var cntr_no = sheetObj.CellValue(row, sheetObj.SaveNameCol("cntr_no"));
            var condition = "?pgmNo=ESM_BKG_0273&bl_no=" + bl_no + "&cntr_no=" + cntr_no;
            
            ComOpenPopup("/hanjin/ESM_BKG_0273.do" + condition, 1024, 660, "0002", "1,0", false);
        }
    }
}

 /**
  * sheet1을 저장,수정,삭제 Operation을 수행하고 화면 Reflesh
  */
function sheet1_OnSaveEnd(sheetObj, ErrMsg){	  
	  // edi 전송 후 재조회 하는 것을 막음
	  //doActionIBSheet(sheetObj, document.form,IBSEARCH);
}

/**
 * E-Mail을 전송하기전 체크할 사항들을 점검한다.
 * @param sheetObj
 * @param formObj
 * @param emailParam 1.E-mail for TMNL : 터미널 Yard 에게 보내는 경우
 *                   2.E-mail for CUST : 화주에게 보내는 경우
 * @returns {Boolean}
 */
function fnChkEMail(sheetObj, formObj, emailParam) {
	var sRowStr = sheetObj.GetSelectionRows();

	var arr = sRowStr.split("|");
	var colIndex = "";
	var rowIndex = "";
	var now = "";
	var dateValue = "";
	var celValue = "";
	
	var row7 = 0;
	
	sheetObjects[1].RemoveAll();

	var now   = new Date();
	var sendDate = formatDate(now, "dd / MMM / yy - hh:mm a");
	
	for (i=0; i<arr.length; i++) {
	    //선택한 Row마다 야드 코드와  

    	colIndex = sheetObj.SaveNameCol("yd_cd");     
        
        rowIndex = arr[i];
        if(isNaN(colIndex)) 
        {
            ComShowCodeMessage("BKG00155");
            return false;
        }

        celValue = sheetObj.CellValue(rowIndex, colIndex);         
        
        if(celValue == null || celValue == '')
        {
            ComShowCodeMessage("BKG40100", "pickup yard", sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
            return false;
        }
        
        if(celValue.length != 7)
        {
            ComShowCodeMessage("COM132201","pickup yard" + "["+ celValue + "]");
            validOk = false;
            return false;
//            break;
        }          

        colIndex = sheetObj.SaveNameCol("cgo_pkup_dt");
        if(isNaN(colIndex))
        {
            ComShowCodeMessage("BKG00155");
            return false;
        }

        celValue = sheetObj.CellValue(rowIndex, colIndex);
//        if(celValue==null || celValue == '')
//        {
//        	 ComShowCodeMessage("BKG40100", "pickup date", sheetObj.CellValue(rowIndex, sheetObj.SaveNameCol("cntr_no")));
//             return false;
//        }
//        if(celValue.length != 8)
//        {
//        	 ComShowCodeMessage("COM132201","pickup date" + "["+ celValue + "]");
//        	 return false;
//        }
        
        // E-mail for CUST인 경우, 화주Email이 입력되어 있지 않으면 에러 메세지를 표시한다.
        if(emailParam == "CUST") {
        	if(sheetObjects[0].CellValue(rowIndex, "cust_eml") == ""){
        		ComShowCodeMessage("BKG00857");
        		return false;
        	}
        }

        row7 = sheetObjects[1].DataInsert(-1);           //마지막 열에 Row를 추가한다.

        sheetObjects[1].CellValue2(row7, "bl_no")           = sheetObjects[0].CellValue(rowIndex, "bl_no"); 
        sheetObjects[1].CellValue2(row7, "bkg_no")          = sheetObjects[0].CellValue(rowIndex, "bkg_no"); 
        sheetObjects[1].CellValue2(row7, "cntr_no")         = sheetObjects[0].CellValue(rowIndex, "cntr_no"); 
        sheetObjects[1].CellValue2(row7, "pod_cd")          = sheetObjects[0].CellValue(rowIndex, "pod_cd"); 
        sheetObjects[1].CellValue2(row7, "yd_cd")           = sheetObjects[0].CellValue(rowIndex, "yd_cd"); 
        sheetObjects[1].CellValue2(row7, "cgo_pkup_dt")     = sheetObjects[0].CellValue(rowIndex, "cgo_pkup_dt"); 
        sheetObjects[1].CellValue2(row7, "yd_nm")           = sheetObjects[0].CellValue(rowIndex, "yd_nm"); 
        sheetObjects[1].CellValue2(row7, "yd_eml")          = sheetObjects[0].CellValue(rowIndex, "yd_eml"); 
        sheetObjects[1].CellValue2(row7, "phn_no")          = sheetObjects[0].CellValue(rowIndex, "phn_no"); 
        sheetObjects[1].CellValue2(row7, "fax_no")          = sheetObjects[0].CellValue(rowIndex, "fax_no"); 

        sheetObjects[1].CellValue2(row7, "diff_rmk")        = sheetObjects[0].CellValue(rowIndex, "diff_rmk"); 
        sheetObjects[1].CellValue2(row7, "vsl_nm")          = sheetObjects[0].CellValue(rowIndex, "vsl_nm"); 
        sheetObjects[1].CellValue2(row7, "vvd")             = sheetObjects[0].CellValue(rowIndex, "vvd"); 
        sheetObjects[1].CellValue2(row7, "loc_nm")          = sheetObjects[0].CellValue(rowIndex, "loc_nm"); 
        sheetObjects[1].CellValue2(row7, "cust_nm")         = sheetObjects[0].CellValue(rowIndex, "cust_nm");
        sheetObjects[1].CellValue2(row7, "cust_eml")        = sheetObjects[0].CellValue(rowIndex, "cust_eml");
        sheetObjects[1].CellValue2(row7, "bkg_trsp_mod_cd") = sheetObjects[0].CellValue(rowIndex, "bkg_trsp_mod_cd");
        sheetObjects[1].CellValue2(row7, "send_date")       = sendDate;  
        sheetObjects[1].CellValue2(row7, "do_no") = sheetObjects[0].CellValue(rowIndex, "do_no"); 
        sheetObjects[1].CellValue2(row7, "do_iss_dt") = sheetObjects[0].CellValue(rowIndex, "do_iss_dt"); 
        sheetObjects[1].CellValue2(row7, "pin_no")        = sheetObjects[0].CellValue(rowIndex, "pin_no");
        sheetObjects[1].CellValue2(row7, "msg_acpt_ref_no")        = sheetObjects[0].CellValue(rowIndex, "msg_acpt_ref_no");
        sheetObjects[1].CellValue2(row7, "rlse_exp_dt")        = sheetObjects[0].CellValue(rowIndex, "rlse_exp_dt");
        
	}
	
	return true;
}

