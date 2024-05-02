/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1064Event.java
*@FileTitle : Pick up Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.04 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptEmlUpldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
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
	public void setPkupNoRptEmlUpldVOs(PkupNoRptEmlUpldVO[] pkupNoRptEmlUpldVOs) {
		this.pkupNoRptEmlUpldVOs = pkupNoRptEmlUpldVOs;
	}

	/**
	 * @return the pkupNoRptEmlUpldVOs
	 */
	public PkupNoRptEmlUpldVO[] getPkupNoRptEmlUpldVOs() {
		return pkupNoRptEmlUpldVOs;
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
	public void setPkupNoRptVOs(PkupNoRptVO[] pkupNoRptVOs) {
		this.pkupNoRptVOs = pkupNoRptVOs;
	}




	/**
	 * @return the pkupNoRptVOs
	 */
	public PkupNoRptVO[] getPkupNoRptVOs() {
		return pkupNoRptVOs;
	}

}