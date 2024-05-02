/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0993Event.java
*@FileTitle : Pick up No Notice Manual Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.24 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0993 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0993HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_0993HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0993Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PkupNtcManualListVO[] pkupNtcManualListVOs = null;
	
	private String[] blNo = null;
	
	public EsmBkg0993Event(){}
	

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String[] blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the blNo
	 */
	public String[] getBlNo() {
		return blNo;
	}

	/**
	 * @param pkupNtcManualListVOs the pkupNtcManualListVOs to set
	 */
	public void setPkupNtcManualListVOs(PkupNtcManualListVO[] pkupNtcManualListVOs) {
		this.pkupNtcManualListVOs = pkupNtcManualListVOs;
	}

	/**
	 * @return the pkupNtcManualListVOs
	 */
	public PkupNtcManualListVO[] getPkupNtcManualListVOs() {
		return pkupNtcManualListVOs;
	}	

}