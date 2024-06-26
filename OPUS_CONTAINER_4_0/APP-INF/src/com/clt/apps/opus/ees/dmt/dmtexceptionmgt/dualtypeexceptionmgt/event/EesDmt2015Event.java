/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2014Event.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.07 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_dmt_2014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_2014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2014HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DualTypeCustomerVO dualTypeCustomerVO = null;

	private SCOrDARListInputVO sCOrDARListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DualTypeCustomerVO[] dualTypeCustomerVOS = null;

	public EesDmt2015Event(){}
	
	public void setDualTypeCustomerVO(DualTypeCustomerVO dualTypeCustomerVO) {
		this.dualTypeCustomerVO = dualTypeCustomerVO;
	}

	public void setDualTypeCustomerVOS(DualTypeCustomerVO[] dualTypeCustomerVOS){
		if (dualTypeCustomerVOS != null) {
			DualTypeCustomerVO[] tmpVOs = new DualTypeCustomerVO[dualTypeCustomerVOS.length];
			System.arraycopy(dualTypeCustomerVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.dualTypeCustomerVOS = tmpVOs;
		}
	}

	public void setSCOrDARListInputVO(SCOrDARListInputVO sCOrDARListInputVO) {
		this.sCOrDARListInputVO = sCOrDARListInputVO;
	}
	
	public DualTypeCustomerVO getDualTypeCustomerVO(){
		return dualTypeCustomerVO;
	}

	public DualTypeCustomerVO[] getDualTypeCustomerVOS(){
		DualTypeCustomerVO[] tmpVOs = null;
		if (this.dualTypeCustomerVOS != null) {
			tmpVOs = new DualTypeCustomerVO[dualTypeCustomerVOS.length];
			System.arraycopy(dualTypeCustomerVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public SCOrDARListInputVO getSCOrDARListInputVO(){
		return sCOrDARListInputVO;
	}	

}