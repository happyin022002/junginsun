/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorRcvMsgVO.java
*@FileTitle : KorRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 15.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 15. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박상훈
 * @since J2EE 1.5
 * @see AbstractValueObject
 */
public class KorRcvAckMsgVO extends RcvMsgVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String flatFile = null;
	private String userId = null;
	

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the flatFile
	 */
	public String getFlatFile() {
		return flatFile;
	}

	/**
	 * @param flatFile the flatFile to set
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	

}
