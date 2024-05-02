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
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	public PortRestrictionOptionVO[] getRslist() {
		PortRestrictionOptionVO[] rtnVOs = null;
		if (this.rslist != null) {
			rtnVOs = Arrays.copyOf(rslist, rslist.length);
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
	public void setRslist(PortRestrictionOptionVO[] rslist) {
		if(rslist != null){
			PortRestrictionOptionVO[] tmpVOs = Arrays.copyOf(rslist, rslist.length);
			this.rslist = tmpVOs;
		}
	}

	 

 

}