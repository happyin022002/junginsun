/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3013Event.java
*@FileTitle : TRI Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.12.04 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_3013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_3013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TriPropParamVO triPropParamVO = null;
	private RsltTriPropListVO rsltTriPropListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltTriPropListVO[] rsltTriPropListVOs = null;

	public EsmPri3013Event(){}
	
	/**
	 * @return the triPropParamVO
	 */
	public TriPropParamVO getTriPropParamVO() {
		return triPropParamVO;
	}

	/**
	 * @param triPropParamVO the triPropParamVO to set
	 */
	public void setTriPropParamVO(TriPropParamVO triPropParamVO) {
		this.triPropParamVO = triPropParamVO;
	}
	
	public void setRsltTriPropListVO(RsltTriPropListVO rsltTriPropListVO){
		this. rsltTriPropListVO = rsltTriPropListVO;
	}

	public void setRsltTriPropListVOS(RsltTriPropListVO[] rsltTriPropListVOs){
		if (rsltTriPropListVOs != null) {
			RsltTriPropListVO[] tmpVOs = new RsltTriPropListVO[rsltTriPropListVOs.length];
			System.arraycopy(rsltTriPropListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltTriPropListVOs = tmpVOs;
		}
	}

	public RsltTriPropListVO getRsltTriPropListVO(){
		return rsltTriPropListVO;
	}

	public RsltTriPropListVO[] getRsltTriPropListVOS(){
		RsltTriPropListVO[] tmpVOs = null;
		if (this.rsltTriPropListVOs != null) {
			tmpVOs = new RsltTriPropListVO[rsltTriPropListVOs.length];
			System.arraycopy(rsltTriPropListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}