/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1064Event.java
*@FileTitle : Pick up Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptEmlUpldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1064HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PkupNoRptEmlUpldVO pkupNoRptEmlUpldVO = null;
	
	private PkupNoRptEmlUpldVO[] pkupNoRptEmlUpldVOs = null;

	private PkupNoRptVO pkupNoRptVO = null;

	private PkupNoRptVO[] pkupNoRptVOs = null;
	
	public EsmBkg1064Event(){}
	



	/**
	 * @param pkupNoRptEmlUpldVO the pkupNoRptEmlUpldVO to set
	 */
	public void setPkupNoRptEmlUpldVO(PkupNoRptEmlUpldVO pkupNoRptEmlUpldVO) {
		this.pkupNoRptEmlUpldVO = pkupNoRptEmlUpldVO;
	}

	/**
	 * @return the pkupNoRptEmlUpldVO
	 */
	public PkupNoRptEmlUpldVO getPkupNoRptEmlUpldVO() {
		return pkupNoRptEmlUpldVO;
	}

	/**
	 * @param pkupNoRptEmlUpldVOs the pkupNoRptEmlUpldVOs to set
	 */
//	public void setPkupNoRptEmlUpldVOs(PkupNoRptEmlUpldVO[] pkupNoRptEmlUpldVOs) {
//		this.pkupNoRptEmlUpldVOs = pkupNoRptEmlUpldVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setPkupNoRptEmlUpldVOs(PkupNoRptEmlUpldVO[] pkupNoRptEmlUpldVOs) {
		if (pkupNoRptEmlUpldVOs != null) {
			PkupNoRptEmlUpldVO[] tmpVOs = new PkupNoRptEmlUpldVO[pkupNoRptEmlUpldVOs.length];
			System.arraycopy(pkupNoRptEmlUpldVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pkupNoRptEmlUpldVOs = tmpVOs;
		}		
	} 
	
	/**
	 * @return the pkupNoRptEmlUpldVOs
	 */
//	public PkupNoRptEmlUpldVO[] getPkupNoRptEmlUpldVOs() {
//		return pkupNoRptEmlUpldVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public PkupNoRptEmlUpldVO[] getPkupNoRptEmlUpldVOs() {
		PkupNoRptEmlUpldVO[] tmpVOs = null;
		if (this.pkupNoRptEmlUpldVOs != null) {
			tmpVOs = new PkupNoRptEmlUpldVO[pkupNoRptEmlUpldVOs.length];
			System.arraycopy(pkupNoRptEmlUpldVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	


	/**
	 * @param pkupNoRptVO the pkupNoRptVO to set
	 */
	public void setPkupNoRptVO(PkupNoRptVO pkupNoRptVO) {
		this.pkupNoRptVO = pkupNoRptVO;
	}




	/**
	 * @return the pkupNoRptVO
	 */
	public PkupNoRptVO getPkupNoRptVO() {
		return pkupNoRptVO;
	}




	/**
	 * @param pkupNoRptVOs the pkupNoRptVOs to set
	 */
//	public void setPkupNoRptVOs(PkupNoRptVO[] pkupNoRptVOs) {
//		this.pkupNoRptVOs = pkupNoRptVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setPkupNoRptVOs(PkupNoRptVO[] pkupNoRptVOs) {
		if (pkupNoRptVOs != null) {
			PkupNoRptVO[] tmpVOs = new PkupNoRptVO[pkupNoRptVOs.length];
			System.arraycopy(pkupNoRptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pkupNoRptVOs = tmpVOs;
		}		
	} 


	/**
	 * @return the pkupNoRptVOs
	 */
//	public PkupNoRptVO[] getPkupNoRptVOs() {
//		return pkupNoRptVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public PkupNoRptVO[] getPkupNoRptVOs() {
		PkupNoRptVO[] tmpVOs = null;
		if (this.pkupNoRptVOs != null) {
			tmpVOs = new PkupNoRptVO[pkupNoRptVOs.length];
			System.arraycopy(pkupNoRptVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
}