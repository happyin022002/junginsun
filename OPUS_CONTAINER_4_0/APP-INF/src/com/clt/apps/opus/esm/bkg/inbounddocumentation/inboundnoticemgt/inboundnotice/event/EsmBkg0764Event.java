/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0764Event.java
*@FileTitle : Customer Data Management Update History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0764 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0764HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0764HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0764Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IbCustCntcHisVO ibCustCntcHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IbCustCntcHisVO[] ibCustCntcHisVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	public IbCustCntcHisVO getIbCustCntcHisVO() {
		return ibCustCntcHisVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	public void setIbCustCntcHisVO(IbCustCntcHisVO ibCustCntcHisVO) {
		this.ibCustCntcHisVO = ibCustCntcHisVO;
	}
	/** Table Value Object Multi Data 처리 */
//	public IbCustCntcHisVO[] getIbCustCntcHisVOs() {
//		return ibCustCntcHisVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public IbCustCntcHisVO[] getIbCustCntcHisVOs() {
		IbCustCntcHisVO[] tmpVOs = null;
		if (this.ibCustCntcHisVOs != null) {
			tmpVOs = new IbCustCntcHisVO[ibCustCntcHisVOs.length];
			System.arraycopy(ibCustCntcHisVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
	/** Table Value Object Multi Data 처리 */
//	public void setDoRcvrVOs(IbCustCntcHisVO[] ibCustCntcHisVOs) {
//		this.ibCustCntcHisVOs = ibCustCntcHisVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setDoRcvrVOs(IbCustCntcHisVO[] ibCustCntcHisVOs) {
		if (ibCustCntcHisVOs != null) {
			IbCustCntcHisVO[] tmpVOs = new IbCustCntcHisVO[ibCustCntcHisVOs.length];
			System.arraycopy(ibCustCntcHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ibCustCntcHisVOs = tmpVOs;
		}		
	} 
    
}