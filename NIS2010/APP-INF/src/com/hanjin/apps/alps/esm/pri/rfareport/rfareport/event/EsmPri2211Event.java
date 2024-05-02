/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsmPri2211Event.java
*@FileTitle : Master RFA Inquiry (& Copied RFA List) - B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRFABlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsmPri2211Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsmPri2211Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasterRFAConditionVO masterRFAConditionVO = null;
	private RsltPriRFABlVO rsltPriRFABlVO = null;
	/** Table Value Object Multi Data 처리 */		
	private RsltPriRFABlVO[] RsltPriRFABlVOs = null;

	public MasterRFAConditionVO getMasterRFAConditionVO() {
		return masterRFAConditionVO;
	}

	public void setMasterRFAConditionVO(MasterRFAConditionVO masterRFAConditionVO) {
		this.masterRFAConditionVO = masterRFAConditionVO;
	}
	
	public RsltPriRFABlVO getRsltPriRFABlVO() {
		return rsltPriRFABlVO;
	}

	public void setRsltPriRFABlVO(RsltPriRFABlVO rsltPriRFABlVO) {
		this.rsltPriRFABlVO = rsltPriRFABlVO;
	}
	
	public RsltPriRFABlVO[] getRsltPriRFABlVOs() {
		RsltPriRFABlVO[] rtnVOs = null;
		if (this.RsltPriRFABlVOs != null) {
			rtnVOs = new RsltPriRFABlVO[RsltPriRFABlVOs.length];
			System.arraycopy(RsltPriRFABlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRsltPriRFABlVOs(RsltPriRFABlVO[] RsltPriRFABlVOs) {
		if(RsltPriRFABlVOs != null){
			RsltPriRFABlVO[] tmpVOs = Arrays.copyOf(RsltPriRFABlVOs, RsltPriRFABlVOs.length);
			this.RsltPriRFABlVOs = tmpVOs;
		}
	}	
}
