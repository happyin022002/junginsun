/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0009Event.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.VopScg0009ConditionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private VopScg0009ConditionVO condition = null;
	private CarrierRestrictionOptionVO container   = null;
	private String exceptKey   = "";
	public VopScg0009Event(){}
	
	
	
	/**
	 * @return the container
	 */
	public CarrierRestrictionOptionVO getContainer() {
		return container;
	}
	/**
	 * @param container the container to set
	 */
	public void setContainer(CarrierRestrictionOptionVO container) {
		this.container = container;
	}

	/**
	 * @return the condition
	 */
	public VopScg0009ConditionVO getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(VopScg0009ConditionVO condition) {
		this.condition = condition;
	}



    /**
     * @return the exceptKey
     */
    public String getExceptKey() {
        return exceptKey;
    }



    /**
     * @param exceptKey the exceptKey to set
     */
    public void setExceptKey(String exceptKey) {
        this.exceptKey = exceptKey;
    }
 



	
 
}