/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg1005Event.java
*@FileTitle : SAVE DG Restriction by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.03 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_1005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_1005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_1005HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg1005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PortRestrictionVO condition = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortRestrictionVO portRestrictionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortRestrictionVO[] portRestrictionVOs = null;	
 
	public VopScg1005Event(){}
	
	/**
	 * @return the condition
	 */
	public PortRestrictionVO getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(PortRestrictionVO condition) {
		this.condition = condition;
	}

	/**
	 * @return the searchScgImdgPortRstrVO
	 */
	public PortRestrictionVO getSearchScgImdgPortRstrVO() {
		return portRestrictionVO;
	}

	/**
	 * @param portRestrictionVO the searchScgImdgPortRstrVO to set
	 */
	public void setSearchScgImdgPortRstrVO(
			PortRestrictionVO portRestrictionVO) {
		this.portRestrictionVO = portRestrictionVO;
	}

	/**
	 * @return the searchScgImdgPortRstrVOs
	 */
	public PortRestrictionVO[] getSearchScgImdgPortRstrVOs() {
		PortRestrictionVO[] rtnVOs = null;
		if (this.portRestrictionVOs != null) {
			rtnVOs = Arrays.copyOf(portRestrictionVOs, portRestrictionVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param searchScgImdgPortRstrVOs the searchScgImdgPortRstrVOs to set
	 */
	public void setSearchScgImdgPortRstrVOs(
			PortRestrictionVO[] portRestrictionVOs) {
		if(portRestrictionVOs != null){
			PortRestrictionVO[] tmpVOs = Arrays.copyOf(portRestrictionVOs, portRestrictionVOs.length);
			this.portRestrictionVOs = tmpVOs;
		}
	}



 
}