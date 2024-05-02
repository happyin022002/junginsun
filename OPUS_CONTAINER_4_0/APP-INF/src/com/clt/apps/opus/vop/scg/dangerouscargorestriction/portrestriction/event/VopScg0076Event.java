/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0076Event.java
*@FileTitle : DG Prohibition Summary by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.30 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0076HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
    private PortRestrictonOptionVO portRestrictonOptionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortRestrictionVO portRestrictionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortRestrictionVO[] portRestrictionVOs = null;

	public VopScg0076Event(){}
	
	public void setPortRestrictionVO(PortRestrictionVO portRestrictionVO){
		this. portRestrictionVO = portRestrictionVO;
	}

	public void setPortRestrictionVOS(PortRestrictionVO[] portRestrictionVOs){
		if(portRestrictionVOs != null){
			PortRestrictionVO[] tmpVOs = Arrays.copyOf(portRestrictionVOs, portRestrictionVOs.length);
			this.portRestrictionVOs = tmpVOs;
		}
	}

	public PortRestrictionVO getPortRestrictionVO(){
		return portRestrictionVO;
	}

	public PortRestrictionVO[] getPortRestrictionVOS(){
		PortRestrictionVO[] rtnVOs = null;
		if (this.portRestrictionVOs != null) {
			rtnVOs = Arrays.copyOf(portRestrictionVOs, portRestrictionVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the portRestrictonOptionVO
     */
    public PortRestrictonOptionVO getPortRestrictonOptionVO() {
        return portRestrictonOptionVO;
    }

    /**
     * @param portRestrictonOptionVO the portRestrictonOptionVO to set
     */
    public void setPortRestrictonOptionVO(
            PortRestrictonOptionVO portRestrictonOptionVO) {
        this.portRestrictonOptionVO = portRestrictonOptionVO;
    }

}