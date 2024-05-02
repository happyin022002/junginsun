/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FaxSendEAIDAO.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Jun 1, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
/**
 * 
 */
package com.hanjin.sample.fax.faxsend.integration;

import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.table.ComFaxSndInfoVO;

/** It's FaxSendEAIDAO.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Jun 1, 2009
 */
public class FaxSendEAIDAO {

	/**This method 
	 * @author Jeong-Hoon, KIM
	 * @param comFaxSndInfoVO
	 * @return
	 * @throws FaxSendException 
	 */
	public String comFaxSndInfoVO(ComFaxSndInfoVO comFaxSndInfoVO) throws FaxSendException {
		FaxMetaInfo faxMetaInfo = new FaxMetaInfo(comFaxSndInfoVO.getRdApplCd(),comFaxSndInfoVO.getRptFileNm(),comFaxSndInfoVO.getBatFlg(),
				comFaxSndInfoVO.getFaxTitNm(),comFaxSndInfoVO.getParaInfoCtnt(),comFaxSndInfoVO.getRcvrInfoCtnt(),comFaxSndInfoVO.getOfcCd(),comFaxSndInfoVO.getCreUsrId());
		return FaxUtility.registerDBLive(faxMetaInfo);
	}
}
