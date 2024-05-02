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
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestriction2VO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	
	private PortRestriction2VO portRestriction2VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortRestrictionVO[] portRestrictionVOs = null;

	private PortRestriction2VO[] portRestriction2VOs = null;

	public VopScg0076Event(){}
	
	public void setPortRestrictionVO(PortRestrictionVO portRestrictionVO){
		this. portRestrictionVO = portRestrictionVO;
	}

	public void setPortRestriction2VO(PortRestriction2VO portRestriction2VO){
		this. portRestriction2VO = portRestriction2VO;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setPortRestrictionVOS(PortRestrictionVO[] portRestrictionVOs){
		if (portRestrictionVOs != null) {
			PortRestrictionVO[] tmpVOs = new PortRestrictionVO[portRestrictionVOs.length];
			System.arraycopy(portRestrictionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portRestrictionVOs = tmpVOs;
		}
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setPortRestriction2VOS(PortRestriction2VO[] portRestriction2VOs){
		if (portRestriction2VOs != null) {
			PortRestriction2VO[] tmpVOs = new PortRestriction2VO[portRestriction2VOs.length];
			System.arraycopy(portRestriction2VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portRestriction2VOs = tmpVOs;
		}
	}
	
	public PortRestrictionVO getPortRestrictionVO(){
		return portRestrictionVO;
	}

	public PortRestriction2VO getPortRestriction2VO(){
		return portRestriction2VO;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public PortRestrictionVO[] getPortRestrictionVOS(){
		PortRestrictionVO[] rtnVOs = null;
		if (this.portRestrictionVOs != null) {
			rtnVOs = new PortRestrictionVO[portRestrictionVOs.length];
			System.arraycopy(portRestrictionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public PortRestriction2VO[] getPortRestriction2VOS(){
		PortRestriction2VO[] rtnVOs = null;
		if (this.portRestriction2VOs != null) {
			rtnVOs = new PortRestriction2VO[portRestriction2VOs.length];
			System.arraycopy(portRestriction2VOs, 0, rtnVOs, 0, rtnVOs.length);
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