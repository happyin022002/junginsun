/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0026Event.java
*@FileTitle : Revenue Structure Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.19 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.RevenueStrcSetVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0026HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RevenueStrcSetVO revenueStrcSetVO = null;

	/** Table Value Object Multi Data 처리 */
	private RevenueStrcSetVO[] revenueStrcSetVOs = null;

	public EsmAcm0026Event() {}

	public RevenueStrcSetVO getRevenueStrcSetVO() {
		return revenueStrcSetVO;
	}

	public void setRevenueStrcSetVO(RevenueStrcSetVO revenueStrcSetVO) {
		this.revenueStrcSetVO = revenueStrcSetVO;
	}

	public RevenueStrcSetVO[] getRevenueStrcSetVOs() {
		RevenueStrcSetVO[] rtnVOs = null;
		if (this.revenueStrcSetVOs != null) {
			rtnVOs = Arrays.copyOf(revenueStrcSetVOs, revenueStrcSetVOs.length);
		}
		return rtnVOs;
	}

	public void setRevenueStrcSetVOs(RevenueStrcSetVO[] revenueStrcSetVOs) {
		if(revenueStrcSetVOs != null){
			RevenueStrcSetVO[] tmpVOs = Arrays.copyOf(revenueStrcSetVOs, revenueStrcSetVOs.length);
			this.revenueStrcSetVOs  = tmpVOs;
		}
	}

}