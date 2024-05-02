/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg07110001Event.java
*@FileTitle : Cargo Release Order History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsDtlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OutstandingVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_BKG-0711 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0711HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see UI_BKG-0711HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0710Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6766125147959177357L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OtsDtlVO otsDtlVO = null;
	private OutstandingVO outVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OtsDtlVO[] otsDtlVOs = null;
	private OutstandingVO[] outVOs = null;

	public EsmBkg0710Event(){}

	/**
	 * 
	 * @return
	 */
	public OtsDtlVO getOtsDtlVO() {
		return otsDtlVO;
	}
	/**
	 * 
	 * @param otsDtlVO
	 */
	public void setOtsDtlVO(OtsDtlVO otsDtlVO) {
		this.otsDtlVO = otsDtlVO;
	}
	/**
	 * 
	 * @return
	 */
	public OutstandingVO getOutVO() {
		return outVO;
	}
	/**
	 * 
	 * @param outVO
	 */
	public void setOutVO(OutstandingVO outVO) {
		this.outVO = outVO;
	}

	/**
	 * @param otsDtlVOs the otsDtlVOs to set
	 */
//	public void setOtsDtlVOs(OtsDtlVO[] otsDtlVOs) {
//		this.otsDtlVOs = otsDtlVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setOtsDtlVOs(OtsDtlVO[] otsDtlVOs) {
		if (otsDtlVOs != null) {
			OtsDtlVO[] tmpVOs = new OtsDtlVO[otsDtlVOs.length];
			System.arraycopy(otsDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.otsDtlVOs = tmpVOs;
		}		
	} 

	/**
	 * @return the otsDtlVOs
	 */
//	public OtsDtlVO[] getOtsDtlVOs() {
//		return otsDtlVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public OtsDtlVO[] getOtsDtlVOs() {
		OtsDtlVO[] tmpVOs = null;
		if (this.otsDtlVOs != null) {
			tmpVOs = new OtsDtlVO[otsDtlVOs.length];
			System.arraycopy(otsDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 

	/**
	 * @param outVOs the outVOs to set
	 */
//	public void setOutVOs(OutstandingVO[] outVOs) {
//		this.outVOs = outVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setOutVOs(OutstandingVO[] outVOs) {
		if (outVOs != null) {
			OutstandingVO[] tmpVOs = new OutstandingVO[outVOs.length];
			System.arraycopy(outVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.outVOs = tmpVOs;
		}		
	} 
	
	/**
	 * @return the outVOs
	 */
//	public OutstandingVO[] getOutVOs() {
//		return outVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public OutstandingVO[] getOutVOs() {
		OutstandingVO[] tmpVOs = null;
		if (this.outVOs != null) {
			tmpVOs = new OutstandingVO[outVOs.length];
			System.arraycopy(outVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
}