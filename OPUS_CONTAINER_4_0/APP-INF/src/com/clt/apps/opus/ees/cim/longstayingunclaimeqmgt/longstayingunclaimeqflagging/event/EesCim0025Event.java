/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim0025Event.java
 *@FileTitle : CNTR Free day Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.10
 *@LastModifier : 신자영
 *@LastVersion : 1.0
 * 2010.07.27 신자영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author shin ja young
 * @see EES_CIM_0025HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvtCntrListVO invtCntrListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvtOptionVO invtOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvtCntrListVO[] invtCntrListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtOptionVO[] invtOptionVOs = null;

	public EesCim0025Event() {
	}

	public void setInvtCntrListVO(InvtCntrListVO invtCntrListVO) {
		this.invtCntrListVO = invtCntrListVO;
	}

	public void setInvtCntrListVOS(InvtCntrListVO[] invtCntrListVOs) {
		if (invtCntrListVOs != null) {
			InvtCntrListVO[] tmpVOs = new InvtCntrListVO[invtCntrListVOs.length];
			System.arraycopy(invtCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invtCntrListVOs = tmpVOs;
		}
	}

	public void setInvtOptionVOS(InvtOptionVO[] invtOptionVOs) {
		if (invtOptionVOs != null) {
			InvtOptionVO[] tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invtOptionVOs = tmpVOs;
		}
	}

	public InvtCntrListVO getInvtCntrListVO() {
		return invtCntrListVO;
	}

	public InvtCntrListVO[] getTInvtCntrListVOS() {
		InvtCntrListVO[] tmpVOs = null;
		if (this.invtCntrListVOs != null) {
			tmpVOs = new InvtCntrListVO[invtCntrListVOs.length];
			System.arraycopy(invtCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public InvtOptionVO[] getInvtOptionVOS() {
		InvtOptionVO[] tmpVOs = null;
		if (this.invtOptionVOs != null) {
			tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setInvtOptionVO(InvtOptionVO invtOptionVO) {
		this.invtOptionVO = invtOptionVO;
	}

	public InvtOptionVO getInvtOptionVO() {
		return invtOptionVO;
	}

}