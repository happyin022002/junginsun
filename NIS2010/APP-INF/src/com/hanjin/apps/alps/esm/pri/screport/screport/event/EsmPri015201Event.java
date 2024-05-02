/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmPri015201Event.java
*@FileTitle : Korea MOF Filing (Base Table) - Scope & Location
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.23
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFLaneListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_0152_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0152_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE HYE MIN
 * @see ESM_PRI_0152_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri015201Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	RsltSearchMOFLaneListVO[] rsltSearchMOFLaneListVOs = null;
	
	public EsmPri015201Event(){}

	/**
	 * @return the rsltSearchMOFLaneListVO
	 */
	public RsltSearchMOFLaneListVO getRsltSearchMOFLaneListVO() {
		return rsltSearchMOFLaneListVO;
	}

	/**
	 * @return the rsltSearchMOFLaneListVOs
	 */
	public RsltSearchMOFLaneListVO[] getRsltSearchKoreaMOFListVOS() {
		RsltSearchMOFLaneListVO[] rtnVOs = null;
		if (this.rsltSearchMOFLaneListVOs != null) {
			rtnVOs = new RsltSearchMOFLaneListVO[rsltSearchMOFLaneListVOs.length];
			System.arraycopy(rsltSearchMOFLaneListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param rsltSearchMOFLaneListVO the rsltSearchMOFLaneListVO to set
	 */
	public void setRsltSearchMOFLaneListVO(RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO) {
		this.rsltSearchMOFLaneListVO = rsltSearchMOFLaneListVO;
	}

	/**
	 * @param rsltSearchMOFLaneListVOs the rsltSearchMOFLaneListVOs to set
	 */
	public void setRsltSearchMOFLaneListVOS(RsltSearchMOFLaneListVO[] rsltSearchMOFLaneListVOs) {
		if(rsltSearchMOFLaneListVOs != null) {
			RsltSearchMOFLaneListVO[] tmpVOs = new RsltSearchMOFLaneListVO[rsltSearchMOFLaneListVOs.length];
			System.arraycopy(rsltSearchMOFLaneListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchMOFLaneListVOs = tmpVOs;
		}
	}
	
}
