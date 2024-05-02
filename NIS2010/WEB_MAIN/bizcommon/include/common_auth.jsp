
<%-------------------- 공통 Auth에 포함할 스크립트 START --------------------%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<SCRIPT LANGUAGE="javascript">
	msgs['AUTH00001'] = 'The approval for Excel Download is in progress\n[Rqst No.:{?msg1}]';
	msgs['AUTH00002'] = 'X';
	/**
     * Excel Download 승인을 확인하는 화면인지 확인
     * Before(사전) 일 때
     */
     var xlsDlRstrActFlg = "";
     var authAproRqstNo = "";
     //var pgmUseFlg = "";
     var authPgmBtnSeq = "";
     var authAproTpCd = "";
     var authPgmSeq = "";
     var authAproStsCd = "";
     
    function chkXlsBtnPrmtBF(subSysCd, pgmNo, sheet){
    	authAproTpCd = "BF";
    	var f_cmd = document.form.f_cmd.value;
    	f_cmd = COMMAND01;
    	var param = "f_cmd="+f_cmd+"&sub_sys_cd_auth="+subSysCd+"&pgm_no="+pgmNo;
		var sXml = sheet.GetSearchXml("COM_APR_0T1GS2.do", param,"",true);
		var check = ComGetEtcData(sXml , "XLS_PRMT_DATA");
		
		var temp = check.split("|");
		xlsDlRstrActFlg = temp[0];
		authAproStsCd	= temp[1];
		authAproRqstNo  = temp[2];
		authPgmSeq 		= temp[3];
		authPgmBtnSeq   = temp[4];
    }
    
	/**
	 * Excel Download 승인을 위한 팝업창
	 */
	function chkXlsDnPopup(param){
		var param1 = param+"&auth_apro_tp_cd="+authAproTpCd+"&auth_pgm_btn_seq="+authPgmBtnSeq+"&xls_prmt="+xlsDlRstrActFlg
		ComOpenPopup('/hanjin/COM_APR_0T1.do' + param1, 915, 522, '', 'none', true);
		var authAproRqstNo;
		if(document.form_auth_common.AUTH_APRO_RQST_NO.value == undefined || document.form_auth_common.AUTH_APRO_RQST_NO.value == null ||
				ComTrim(document.form_auth_common.AUTH_APRO_RQST_NO.value) == '' || ComTrim(document.form_auth_common.AUTH_APRO_RQST_NO.value).length != 30) return;
		
		authAproRqstNo = document.form_auth_common.AUTH_APRO_RQST_NO.value;
		return authAproRqstNo;
	}
	
	//Form 초기 검사용
	var comAuthForm = document.createElement("<form name='form_auth_common' method='post'></form>");
	var comAuthAproRqstNo = document.createElement("<input type='hidden' name='AUTH_APRO_RQST_NO' value=''>");
	comAuthForm.appendChild(comAuthAproRqstNo);
	document.body.appendChild(comAuthForm); 


</SCRIPT>
<%-------------------- 공통 Auth에 포함할 스크립트 END --------------------%>