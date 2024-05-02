/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo003401Event.java
*@FileTitle : Estimate Code Check - Carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.03 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0034_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0034_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0034_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo003401Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리  */
    private EstmActRsltVO estmActRsltVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private EstmActRsltVO[] estmActRsltVOs = null;

    /**
     * @return the yearMm
     */
    public String getYearMm() {
        return yearMm;
    }

    /**
     * @param yearMm the yearMm to set
     */
    public void setYearMm(String yearMm) {
        this.yearMm = yearMm;
    }

    public FnsJoo003401Event(){}
    public String yearMm = null;

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
    	EstmActRsltVO[] tmpVOs = null;
		if (this.estmActRsltVOs != null) {
			tmpVOs = new EstmActRsltVO[estmActRsltVOs.length];
			System.arraycopy(estmActRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
     * @param estmActRsltVO the estmActRsltVO to set
     */
    public void setEstmActRsltVO(EstmActRsltVO estmActRsltVO) {
        this.estmActRsltVO = estmActRsltVO;
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
 
	
 

}