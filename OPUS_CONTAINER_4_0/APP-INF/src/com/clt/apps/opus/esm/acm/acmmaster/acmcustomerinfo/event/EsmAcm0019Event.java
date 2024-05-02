/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0019Event.java
*@FileTitle : FF-Vendor Match for FF Compensation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.vo.FFVendorMatchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 처리  */
	private FFVendorMatchVO ffVendorMatchVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFVendorMatchVO[] ffVendorMatchVOs = null;

	public EsmAcm0019Event() {}

	public FFVendorMatchVO getFFVendorMatchVO() {
		return ffVendorMatchVO;
	}

	public void setFFVendorMatchVO(FFVendorMatchVO ffVendorMatchVO) {
		this.ffVendorMatchVO = ffVendorMatchVO;
	}

	public FFVendorMatchVO[] getFFVendorMatchVOs() {
		FFVendorMatchVO[] rtnVOs = null;
		if (this.ffVendorMatchVOs != null) {
			rtnVOs = Arrays.copyOf(ffVendorMatchVOs, ffVendorMatchVOs.length);
		}
		return rtnVOs;
	}

	public void setFFVendorMatchVOs(FFVendorMatchVO[] ffVendorMatchVOs) {
		if(ffVendorMatchVOs != null){
			FFVendorMatchVO[] tmpVOs = Arrays.copyOf(ffVendorMatchVOs, ffVendorMatchVOs.length);
			this.ffVendorMatchVOs  = tmpVOs;
		}
	}
}