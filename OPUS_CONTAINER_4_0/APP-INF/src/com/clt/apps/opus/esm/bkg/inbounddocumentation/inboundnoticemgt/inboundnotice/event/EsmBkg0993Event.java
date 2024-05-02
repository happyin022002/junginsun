/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0993Event.java
*@FileTitle : Pick up No Notice Manual Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0993 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0993HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
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
//	public void setBlNo(String[] blNo) {
//		this.blNo = blNo;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBlNo(String[] blNo) {
		if (blNo != null) {
			String[] tmpVOs = new String[blNo.length];
			System.arraycopy(blNo, 0, tmpVOs, 0, tmpVOs.length);
			this.blNo = tmpVOs;
		}		
	} 

	/**
	 * @return the blNo
	 */
//	public String[] getBlNo() {
//		return blNo;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public String[] getBlNo() {
		String[] tmpVOs = null;
		if (this.blNo != null) {
			tmpVOs = new String[blNo.length];
			System.arraycopy(blNo, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 

	/**
	 * @param pkupNtcManualListVOs the pkupNtcManualListVOs to set
	 */
//	public void setPkupNtcManualListVOs(PkupNtcManualListVO[] pkupNtcManualListVOs) {
//		this.pkupNtcManualListVOs = pkupNtcManualListVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setPkupNtcManualListVOs(PkupNtcManualListVO[] pkupNtcManualListVOs) {
		if (pkupNtcManualListVOs != null) {
			PkupNtcManualListVO[] tmpVOs = new PkupNtcManualListVO[pkupNtcManualListVOs.length];
			System.arraycopy(pkupNtcManualListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pkupNtcManualListVOs = tmpVOs;
		}		
	} 
	
	/**
	 * @return the pkupNtcManualListVOs
	 */
//	public PkupNtcManualListVO[] getPkupNtcManualListVOs() {
//		return pkupNtcManualListVOs;
//	}	

	//2015.04.14 Secure Coding 적용[CWE-496]
	public PkupNtcManualListVO[] getPkupNtcManualListVOs() {
		PkupNtcManualListVO[] tmpVOs = null;
		if (this.pkupNtcManualListVOs != null) {
			tmpVOs = new PkupNtcManualListVO[pkupNtcManualListVOs.length];
			System.arraycopy(pkupNtcManualListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
}