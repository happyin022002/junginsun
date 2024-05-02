/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0142Event.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0142HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0142Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO = null;
	private CstmsTrsmRsltVO cstmsTrsmRsltVO = null;
	private CstmsTrsmRsltVO[] cstmsTrsmRsltVOs = null;

	public EsmBkg0142Event() {}

	public void setCstmsTrsmRsltListCondVO(CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO) {
		this.cstmsTrsmRsltListCondVO = cstmsTrsmRsltListCondVO;
	}

	public void setCstmsTrsmRsltVO(CstmsTrsmRsltVO cstmsTrsmRsltVO) {
		this.cstmsTrsmRsltVO = cstmsTrsmRsltVO;
	}

	public void setCstmsTrsmRsltVOs(CstmsTrsmRsltVO[] cstmsTrsmRsltVOs){
		if(cstmsTrsmRsltVOs != null){
			CstmsTrsmRsltVO[] tmpVOs = Arrays.copyOf(cstmsTrsmRsltVOs, cstmsTrsmRsltVOs.length);
			this.cstmsTrsmRsltVOs = tmpVOs;
		}
	}

	public CstmsTrsmRsltListCondVO getCstmsTrsmRsltListCondVO() {
		return cstmsTrsmRsltListCondVO;
	}

	public CstmsTrsmRsltVO getCstmsTrsmRsltVO() {
		return cstmsTrsmRsltVO;
	}

	public CstmsTrsmRsltVO[] getCstmsTrsmRsltVOs() {
		CstmsTrsmRsltVO[] rtnVOs = null;
		if (this.cstmsTrsmRsltVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsTrsmRsltVOs, cstmsTrsmRsltVOs.length);
		}
		return rtnVOs;
	}
}