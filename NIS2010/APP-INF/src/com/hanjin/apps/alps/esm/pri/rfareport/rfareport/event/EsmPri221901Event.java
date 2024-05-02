/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri221901Event.java
*@FileTitle : Master RFA Inquiry (& Copied RFA List)
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriMasterRFAOnlyVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_2219_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2219_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_2219_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri221901Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasterRFAConditionVO masterRFAConditionVO = null;
	private RsltPriMasterRFAOnlyVO rsltPriMasterRFAOnlyVO = null;
	/** Table Value Object Multi Data 처리 */		
	private RsltPriMasterRFAOnlyVO[] RsltPriMasterRFAOnlyVOs = null;

	public MasterRFAConditionVO getMasterRFAConditionVO() {
		return masterRFAConditionVO;
	}

	public void setMasterRFAConditionVO(MasterRFAConditionVO masterRFAConditionVO) {
		this.masterRFAConditionVO = masterRFAConditionVO;
	}
	
	public RsltPriMasterRFAOnlyVO getRsltPriMasterRFAOnlyVO() {
		return rsltPriMasterRFAOnlyVO;
	}

	public void setRsltPriMasterRFAOnlyVO(RsltPriMasterRFAOnlyVO rsltPriMasterRFAOnlyVO) {
		this.rsltPriMasterRFAOnlyVO = rsltPriMasterRFAOnlyVO;
	}
	
	public RsltPriMasterRFAOnlyVO[] getRsltPriMasterRFAOnlyVOs() {
		RsltPriMasterRFAOnlyVO[] rtnVOs = null;
		if (this.RsltPriMasterRFAOnlyVOs != null) {
			rtnVOs = new RsltPriMasterRFAOnlyVO[RsltPriMasterRFAOnlyVOs.length];
			System.arraycopy(RsltPriMasterRFAOnlyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRsltPriMasterRFAOnlyVOs(RsltPriMasterRFAOnlyVO[] RsltPriMasterRFAOnlyVOs) {
		if(RsltPriMasterRFAOnlyVOs != null){
			RsltPriMasterRFAOnlyVO[] tmpVOs = Arrays.copyOf(RsltPriMasterRFAOnlyVOs, RsltPriMasterRFAOnlyVOs.length);
			this.RsltPriMasterRFAOnlyVOs = tmpVOs;
		}
	}
}