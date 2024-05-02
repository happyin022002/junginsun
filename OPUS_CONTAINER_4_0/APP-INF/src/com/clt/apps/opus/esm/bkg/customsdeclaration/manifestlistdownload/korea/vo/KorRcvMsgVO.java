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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvMsgVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박상훈
 * @since J2EE 1.5
 * @see AbstractValueObject
 */
public class KorRcvMsgVO extends RcvMsgVO {

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
