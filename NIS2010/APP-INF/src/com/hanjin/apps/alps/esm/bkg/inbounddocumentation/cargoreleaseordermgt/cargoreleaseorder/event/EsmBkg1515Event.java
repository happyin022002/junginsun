/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1515Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.12 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdiYardInfoVO;

/**
 * esm_bkg_1515 EDI Setup 조회<br>
 * -  ESM_BKG_1515HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung 
 * @see ESM_BKG_1515HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1515Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

	/** PickUp Notice Setup Table Value Object 조회 조건 및 단건 처리  */
	private EdiYardInfoVO ediYardInfoVO = null;
    /** Table Value Object Multi Data 처리 */
    private EdiYardInfoVO[] ediYardInfoVOs = null;
	
    public EsmBkg1515Event(){}

    
	/**
	 * @param ediYardInfoVO the ediYardInfoVO to set
	 */
	public void setEdiYardInfoVO(EdiYardInfoVO ediYardInfoVO) {
		this.ediYardInfoVO = ediYardInfoVO;
	}

	/**
	 * @return the ediYardInfoVO
	 */
	public EdiYardInfoVO getEdiYardInfoVO() {
		return ediYardInfoVO;
	}
	
    /**
     * @return the doStsVOs
     */
    public EdiYardInfoVO[] getEdiYardInfoVOs() {
		EdiYardInfoVO[] rtnVOs = null;
		if (this.ediYardInfoVOs != null) {
			rtnVOs = new EdiYardInfoVO[ediYardInfoVOs.length];
			System.arraycopy(ediYardInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param ediYardInfoVOs the ediYardInfoVOs to set
     */
    public void setEdiYardInfoVOs(EdiYardInfoVO[] ediYardInfoVOs){
		if(ediYardInfoVOs != null){
			EdiYardInfoVO[] tmpVOs = new EdiYardInfoVO[ediYardInfoVOs.length];
			System.arraycopy(ediYardInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ediYardInfoVOs = tmpVOs;
		}
    }
    
}