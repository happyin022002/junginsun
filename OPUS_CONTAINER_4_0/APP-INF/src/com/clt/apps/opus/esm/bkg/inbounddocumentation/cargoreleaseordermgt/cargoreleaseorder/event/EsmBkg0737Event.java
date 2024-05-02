/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg0737Event.java
*@FileTitle      : Attorney Search Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-07-17
*@LastModifier   : 
*@LastVersion    : 1.0
* 2009-07-17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0737 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0737HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0737HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0737Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 2954119069493312059L;

    /** Table Value Object 조회 조건 및 단건 처리  */
    private EdoTransVO edoTransVO = null;

    /** Table Value Object Multi Data 처리 */
    private EdoTransVO[] edoTransVOs = null;

    /** Table Value Object Multi Data 처리 */
    private  EdoEdiTransVO[] edoEdiTrans = null;

    /**
     * @param edoTrans the edoTrans to set
     */
    public void setEdoTransVO(EdoTransVO edoTransVO) {
        this.edoTransVO = edoTransVO;
    }

    /**
     * @return the edoTrans
     */
    public EdoTransVO getEdoTransVO() {
        return edoTransVO;
    }

    /**
     * @param edoTransVOs the edoTransVOs to set
     */
//    public void setEdoTransVOs(EdoTransVO[] edoTransVOs) {
//        this.edoTransVOs = edoTransVOs;
//    }

	//2015.04.14 Secure Coding 적용[CWE-496]
    public void setEdoTransVOs(EdoTransVO[] edoTransVOs) {
		if (edoTransVOs != null) {
			EdoTransVO[] tmpVOs = new EdoTransVO[edoTransVOs.length];
			System.arraycopy(edoTransVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.edoTransVOs = tmpVOs;
		}		
	} 	
    
    /**
     * @return the edoTransVOs
     */
//    public EdoTransVO[] getEdoTransVOs() {
//        return edoTransVOs;
//    }

	//2015.04.14 Secure Coding 적용[CWE-496]
    public EdoTransVO[] getEdoTransVOs() {
    	EdoTransVO[] tmpVOs = null;
		if (this.edoTransVOs != null) {
			tmpVOs = new EdoTransVO[edoTransVOs.length];
			System.arraycopy(edoTransVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
    
	/**
	 * @return the edoEdiTrans
	 */
//	public EdoEdiTransVO[] getEdoEdiTrans() {
//		return edoEdiTrans;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public EdoEdiTransVO[] getEdoEdiTrans() {
		EdoEdiTransVO[] tmpVOs = null;
		if (this.edoEdiTrans != null) {
			tmpVOs = new EdoEdiTransVO[edoEdiTrans.length];
			System.arraycopy(edoEdiTrans, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	

	/**
	 * @param edoEdiTrans the edoEdiTrans to set
	 */
//	public void setEdoEdiTrans(EdoEdiTransVO[] edoEdiTrans) {
//		this.edoEdiTrans = edoEdiTrans;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setEdoEdiTrans(EdoEdiTransVO[] edoEdiTrans) {
		if (edoEdiTrans != null) {
			EdoEdiTransVO[] tmpVOs = new EdoEdiTransVO[edoEdiTrans.length];
			System.arraycopy(edoEdiTrans, 0, tmpVOs, 0, tmpVOs.length);
			this.edoEdiTrans = tmpVOs;
		}		
	} 	
}