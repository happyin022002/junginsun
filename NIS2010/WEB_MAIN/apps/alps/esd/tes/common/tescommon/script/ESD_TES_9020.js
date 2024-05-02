
	String.prototype.trim = function()
	{
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/** 
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 **/
    function processButtonClick() {

         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
         	    case "btn_save":
//					ComShowMessage(rjct_sts_inp_nm + ' / ' + rjct_fn_nm);
//					if (confirm('reject를 진행합니까?')) {
					if (confirm(ComGetMsg("TES31001"))) {

						/***************************************************************************
							Reject 상태 (tml_inv_rjct_sts_cd)
							  'NL' : 정상
							  'RJ' : Reject
							  'RL' : Reject후 수정후 다시 Comfirm or Approval Request
						***************************************************************************/
						var opr_rjct_sts_inp_obj = eval('window.dialogArguments.document.form.'+rjct_sts_inp_nm);
						opr_rjct_sts_inp_obj.value = formObj.inv_rjct_rmk.value;
						//opener.document.form.tml_inv_rjct_sts_cd.value = 'RJ'; //밑에서..
						//opener.rjctInv(); //rejet function 호출
						eval("window.dialogArguments."+rjct_fn_nm+"()");
						window.close();
					}  
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

