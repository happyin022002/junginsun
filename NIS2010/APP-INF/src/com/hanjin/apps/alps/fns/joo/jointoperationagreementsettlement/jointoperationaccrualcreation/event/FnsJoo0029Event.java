/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0029Event.java
*@FileTitle : Estimate Performance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * FNS_JOO_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    /**
     *  조회옵션처리 VO
	 */
	private SettlementConditionVO settlementConditionVO = null;
	
	private EstmConditionVO estmConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
    private  EstmActRsltVO estmActRsltVo = null;
    
    /** Table Value Object Multi Data 처리 */
    private EstmActRsltVO[] estmActRsltVOs = null;
 
	public FnsJoo0029Event(){}

	/**
     * @return the settlementConditionVO
     */
    public SettlementConditionVO getSettlementConditionVO() {
        return settlementConditionVO;
    }


    /**
     * @return the estmActRsltVo
     */
    public EstmActRsltVO getEstmActRsltVo() {
        return estmActRsltVo;
    }


    /**
     * @return the estmActRsltVOs
     */
    public EstmActRsltVO[] getEstmActRsltVOs() {
        EstmActRsltVO[] rtnVOs = null;
		if (this.estmActRsltVOs != null) {
			rtnVOs = new EstmActRsltVO[estmActRsltVOs.length];
			System.arraycopy(estmActRsltVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }


    /**
     * @param settlementConditionVO the settlementConditionVO to set
     */
    public void setSettlementConditionVO(SettlementConditionVO settlementConditionVO) {
        this.settlementConditionVO = settlementConditionVO;
    }


    /**
     * @param estmActRsltVo the estmActRsltVo to set
     */
    public void setEstmActRsltVo(EstmActRsltVO estmActRsltVo) {
        this.estmActRsltVo = estmActRsltVo;
    }


    /**
     * @param estmActRsltVOs the estmActRsltVOs to set
     */
    public void setEstmActRsltVOs(EstmActRsltVO[] estmActRsltVOs) {
		if (estmActRsltVOs != null) {
			EstmActRsltVO[] tmpVOs = new EstmActRsltVO[estmActRsltVOs.length];
			System.arraycopy(estmActRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.estmActRsltVOs = tmpVOs;
		}                
    }

    public EstmConditionVO getEstmConditionVO() {
		return estmConditionVO;
	}

	public void setEstmConditionVO(EstmConditionVO estmConditionVO) {
		this.estmConditionVO = estmConditionVO;
	}

}