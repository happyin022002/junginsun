/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9020.jsp
*@FileTitle  : Terminal Invoice Reject Reason
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/	
	String.prototype.trim = function()
	{
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	/** 
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick=processButtonClick;
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 **/
    function processButtonClick() {
         var formObj=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
         	    case "btn_save":
					if (confirm(ComGetMsg("TES31001"))) {
						/***************************************************************************
							Reject 상태 (tml_inv_rjct_sts_cd)
							  'NL' : 정상
							  'RJ' : Reject
							  'RL' : Reject후 수정후 다시 Comfirm or Approval Request
						***************************************************************************/
						var opener_obj;
						opener_obj=window.dialogArguments;
						if (!opener_obj)  opener_obj=window.opener;  //이 코드 추가할것
						if (!opener_obj) opener_obj=parent; //이 코드 추가할것
						var opr_rjct_sts_inp_obj=eval('opener_obj.document.form.'+rjct_sts_inp_nm);
						opr_rjct_sts_inp_obj.value=formObj.inv_rjct_rmk.value;
						eval("opener_obj."+rjct_fn_nm+"()");
						ComClosePopup(); 
					}  
        	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }