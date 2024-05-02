/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0011Event.java
*@FileTitle : VSL OPR's Restriction on DG (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.14
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.14 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;


/**
 * VOP_SCG_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0011Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortRestrictionOptionVO contition = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortRestrictionOptionVO[] rslist = null;

	public VopScg0011Event(){}	
	private static final long serialVersionUID = 1L;
	/**
	 * @return the contition
	 */
	public PortRestrictionOptionVO getContition() {
		return contition;
	}

	/**
	 * @return the rslist
	 */
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public PortRestrictionOptionVO[] getRslist() {
		PortRestrictionOptionVO[] rtnVOs = null;
		if (this.rslist != null) {
			rtnVOs = new PortRestrictionOptionVO[rslist.length];
			System.arraycopy(rslist, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param contition the contition to set
	 */
	public void setContition(PortRestrictionOptionVO contition) {
		this.contition = contition;
	}

	/**
	 * @param rslist the rslist to set
	 */
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setRslist(PortRestrictionOptionVO[] rslist) {
		if (rslist != null) {
			PortRestrictionOptionVO[] tmpVOs = new PortRestrictionOptionVO[rslist.length];
			System.arraycopy(rslist, 0, tmpVOs, 0, tmpVOs.length);
			this.rslist = tmpVOs;
		}
	}

	 

 

}