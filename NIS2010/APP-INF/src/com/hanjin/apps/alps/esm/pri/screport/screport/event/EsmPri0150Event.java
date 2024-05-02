/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmPri0150Event.java
*@FileTitle : Korea MOF Filing (by Upload)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2016.05.25 전지예
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_0150 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0150HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JeeyeJeon
 * @see ESM_PRI_0150HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri0150Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs = null;
	
	public EsmPri0150Event(){}

	/**
	 * @return the rsltSearchKoreaMOTListVO
	 */
	public RsltSearchKoreaMOTListVO getRsltSearchKoreaMOTListVO() {
		return rsltSearchKoreaMOTListVO;
	}

	/**
	 * @return the rsltSearchKoreaMOTListVOs
	 */
	public RsltSearchKoreaMOTListVO[] getRsltSearchKoreaMOTListVOS() {
		RsltSearchKoreaMOTListVO[] rtnVOs = null;
		if (this.rsltSearchKoreaMOTListVOs != null) {
			rtnVOs = new RsltSearchKoreaMOTListVO[rsltSearchKoreaMOTListVOs.length];
			System.arraycopy(rsltSearchKoreaMOTListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param rsltSearchKoreaMOTListVO the rsltSearchKoreaMOTListVO to set
	 */
	public void setRsltSearchKoreaMOTListVO(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) {
		this.rsltSearchKoreaMOTListVO = rsltSearchKoreaMOTListVO;
	}

	/**
	 * @param rsltSearchKoreaMOTListVOs the rsltSearchKoreaMOTListVOs to set
	 */
	public void setRsltSearchKoreaMOTListVOS(RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs) {
		if(rsltSearchKoreaMOTListVOs != null) {
			RsltSearchKoreaMOTListVO[] tmpVOs = new RsltSearchKoreaMOTListVO[rsltSearchKoreaMOTListVOs.length];
			System.arraycopy(rsltSearchKoreaMOTListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchKoreaMOTListVOs = tmpVOs;
		}
	}
	
}
