/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg07110001Event.java
*@FileTitle : Cargo Release Order History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.19 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OutstandingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG-0711 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0711HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
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
	public void setOtsDtlVOs(OtsDtlVO[] otsDtlVOs) {
		this.otsDtlVOs = otsDtlVOs;
	}

	/**
	 * @return the otsDtlVOs
	 */
	public OtsDtlVO[] getOtsDtlVOs() {
		return otsDtlVOs;
	}

	/**
	 * @param outVOs the outVOs to set
	 */
	public void setOutVOs(OutstandingVO[] outVOs) {
		this.outVOs = outVOs;
	}

	/**
	 * @return the outVOs
	 */
	public OutstandingVO[] getOutVOs() {
		return outVOs;
	}
}