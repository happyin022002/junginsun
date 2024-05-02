/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportEAIDAO.java
*@FileTitle : 고객에게 Container Loading Confirmation을 발송하는 기능
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.26 김기종
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.List;

import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * It's RDMailSampleEAIDAO.java
 * @authorKim Ki Jong
 * @see 
 * @since J2EE 1.6
 * Apr 27, 2009
 */
public class CarrierSettlementProcessEAIDAO extends EAIDAOSupport{
	
	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param FaxMetaInfo[] faxInfos
	 * @return List<String>
	 * @throws Exception 
	 */
	public List<String> sendFax(FaxMetaInfo[] faxInfos) throws Exception {
		
		int arrLen = faxInfos.length;
		FaxMetaInfo[] infos = new FaxMetaInfo[arrLen];
		
		try {
			for (int i=0; i<arrLen; i++) {
				infos[i] = new FaxMetaInfo(faxInfos[i].getRdSubSysCd(),     // 모듈명(ex.BKG)
					 		               faxInfos[i].getTmplMrd(),   // MRD 파일 명 (ex.WO_NORMAL.mrd)
							               faxInfos[i].getBatFlg(),  // 배치 유무(Y/N)
								           faxInfos[i].getEmlTitNm(),     // 제목
								           faxInfos[i].getParaInfoCtnt(), // RD Parameter (ex. [419][1][selho])
								           //"KIM;5336",
								           faxInfos[i].getRcvrInfoCtnt(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           faxInfos[i].getOffice(),    // 지역 FAX office
								           faxInfos[i].getCreUsrId()  // 보내는 사람
								          ); 
			}
					
			return FaxUtility.registerDB(infos);

		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}

	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param FaxMetaInfo faxInfo
	 * @return String
	 * @throws Exception 
	 */
	public String sendFax(FaxMetaInfo faxInfo) throws Exception {
		
		FaxMetaInfo infos[] = new FaxMetaInfo[1];
		
		infos[0] = faxInfo;
		
		List<String> sendId = sendFax(infos);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	
	/**
	 * RD 메일을 전송한다.(파일 미첨부)
	 * 
	 * @param Mail mail
	 * @return String
	 */
	public String sendRDEmail(Mail mail) throws Exception {
		return mail.send();
	}

	/**
	 * FNS_JOO_0084 Container List/ Standard format 엑셀 다운로드
	 * 
	 * @param String key
	 * @return Object
	 * @throws Exception
	 * @throws DAOException
	 */
	public Object searchCntrReportBackEndJobDataFile(String key) throws Exception, DAOException {
		try {
			return (Object) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}
