/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EesDmt2021Event.java
*@FileTitle : AFT DAR Requst & Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : Kim Ki Tae
*@LastVersion : 1.0
* 2016.03.03 Kim Ki Tae
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_2021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_2021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private AfterBkgRqstAproStsVO afterBkgRqstAproStsVO = null;
	private AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO = null;
	private CommonCodeVO commonCodeVO = null;	
	

	public EesDmt2021Event(){}

	public AfterBkgRqstAproStsVO getAfterBkgRqstAproStsVO() {
		return afterBkgRqstAproStsVO;
	}

	public void setAfterBkgRqstAproStsVO(AfterBkgRqstAproStsVO afterBkgRqstAproStsVO) {
		this.afterBkgRqstAproStsVO = afterBkgRqstAproStsVO;
	}

	public AfterBkgRqstAproStsParamVO getAfterBkgRqstAproStsParamVO() {
		return afterBkgRqstAproStsParamVO;
	}

	public void setAfterBkgRqstAproStsParamVO(AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO) {
		this.afterBkgRqstAproStsParamVO = afterBkgRqstAproStsParamVO;
	}
	
	public CommonCodeVO getCommonCodeVO() {
		return commonCodeVO;
	}

	public void setCommonCodeVO(CommonCodeVO commonCodeVO) {
		this.commonCodeVO = commonCodeVO;
	}
	
}