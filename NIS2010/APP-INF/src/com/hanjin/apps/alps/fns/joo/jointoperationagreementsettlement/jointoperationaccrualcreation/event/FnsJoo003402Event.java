/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo003402Event.java
*@FileTitle : Estimate Code Check - VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.06 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooEstmActRsltVO;


/**
 * FNS_JOO_0034_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0034_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0034_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo003402Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	private EstdVvdVO  estdVvdVO = null;
    /** Table Value Object 조회 조건 및 단건 처리  */
    private EstmActRsltVO estmActRsltVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private EstmActRsltVO[] estmActRsltVOs = null;
    /**
     * @return the estmActRsltVO
     */
    public EstmActRsltVO getEstmActRsltVO() {
        return estmActRsltVO;
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
    
	public FnsJoo003402Event(){}

    /**
     * @return the estdVvdVO
     */
    public EstdVvdVO getEstdVvdVO() {
        return estdVvdVO;
    }

    /**
     * @param estdVvdVO the estdVvdVO to set
     */
    public void setEstdVvdVO(EstdVvdVO estdVvdVO) {
        this.estdVvdVO = estdVvdVO;
    }
 
}