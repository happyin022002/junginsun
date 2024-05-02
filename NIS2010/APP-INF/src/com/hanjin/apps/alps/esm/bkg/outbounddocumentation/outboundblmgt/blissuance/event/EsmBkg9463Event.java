/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9463Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlAtchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9463 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9463HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>  
 *
 * @author jeongmin cho
 * @see ESM_BKG_9463HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9463Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg9463Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private BlAtchVO blAtchVO = null;

	/** Table Value Object Multi Data 처리 */
	private BlAtchVO[] blAtchVOs = null;

	/**
	 * @return the blAtchVO
	 */
	public BlAtchVO getBlAtchVO() {
		return blAtchVO;
	}
	/**
	 * @param blAtchVO the blAtchVO to set
	 */
	public void setBlAtchVO(BlAtchVO blAtchVO) {
		this.blAtchVO = blAtchVO;
	}

	/**
	 * @return the blAtchVOs
	 */
	public BlAtchVO[] getBlAtchVOs() {
		return blAtchVOs;
	}

	
	/**
	 * @param blAtchVOs the blAtchVOs to set
	 */
	public void setBlAtchVOs(BlAtchVO[] blAtchVOs) {
		this.blAtchVOs = blAtchVOs;
	}


}