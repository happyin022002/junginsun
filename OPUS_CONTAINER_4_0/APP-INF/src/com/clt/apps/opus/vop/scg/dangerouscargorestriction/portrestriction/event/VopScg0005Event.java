/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0005Event.java
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.VopScg004ContainVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgPortRstrVO;


/**
 * VOP_SCG_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public VopScg0005Event(){}
	/**  조회 조건 및 단건 처리  */
	private PortRestrictonOptionVO condition = null;
 
 
	private ScgImdgPortRstrVO scgImdgPortRstrVO = null;
	private ScgImdgPortRstrVO[] scgImdgPortRstrVOs = null;
	
	private VopScg004ContainVO vopScg004ContainVO = null;	
	
	
	
	/**
	 * 화면 전체 Sheet set Vo
	 */
	public VopScg004ContainVO getVopScg004ContainVO() {
		return vopScg004ContainVO;
	}
	/**
	 * 화면 전체 Sheet get Vo
	 */
	public void setVopScg004ContainVO(VopScg004ContainVO vopScg004ContainVO) {
		this.vopScg004ContainVO = vopScg004ContainVO;
	}
	public ScgImdgPortRstrVO getScgImdgPortRstrVO() {
		return scgImdgPortRstrVO;
	}
	public void setScgImdgPortRstrVO(ScgImdgPortRstrVO scgImdgPortRstrVO) {
		this.scgImdgPortRstrVO = scgImdgPortRstrVO;
	}
	public ScgImdgPortRstrVO[] getScgImdgPortRstrVOs() {
		ScgImdgPortRstrVO[] rtnVOs = null;
		if (this.scgImdgPortRstrVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgPortRstrVOs, scgImdgPortRstrVOs.length);
		}
		return rtnVOs;
	}
	public void setScgImdgPortRstrVOs(ScgImdgPortRstrVO[] scgImdgPortRstrVOs) {
		if(scgImdgPortRstrVOs != null){
			ScgImdgPortRstrVO[] tmpVOs = Arrays.copyOf(scgImdgPortRstrVOs, scgImdgPortRstrVOs.length);
			this.scgImdgPortRstrVOs = tmpVOs;
		}
	}
    /**
     * @return the condition
     */
    public PortRestrictonOptionVO getCondition() {
        return condition;
    }
    /**
     * @param condition the condition to set
     */
    public void setCondition(PortRestrictonOptionVO condition) {
        this.condition = condition;
    }

 
}