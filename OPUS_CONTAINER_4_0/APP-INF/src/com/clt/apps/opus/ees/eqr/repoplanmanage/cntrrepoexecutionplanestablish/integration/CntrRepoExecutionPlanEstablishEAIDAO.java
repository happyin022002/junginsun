/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishEAIDAO.java
*@FileTitle : Send Fax or e-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.21 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.clt.framework.component.exception.CheckUtilsException;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;


/**
 *  CntrRepoExecutionPlanEstablishEAIDAO <br>
 * - -RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ChungEunHo
 * @see CntrRepoExecutionPlanEstablishBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoExecutionPlanEstablishEAIDAO extends EAIDAOSupport {

	/**
	 * EES_EQR_0131 eMail  Send.<br>
	 * 
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void sendEmail(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws MailerAppException, DAOException, SQLException, CheckUtilsException, IOException
	{
		//	e-mail 보내기
		String  eml_content = conditionVO.getEmlContent();
		String	eml_subject = conditionVO.getEmlSubject();
 	
		String repo_pln_id = conditionVO.getRepoPlnId();
		String ref_id = conditionVO.getRefId();
		String tpsz = conditionVO.getTpsz();
		String email = conditionVO.getEmail();
		String pdfFileName = com.clt.apps.opus.ees.eqr.common.Utils.getDateTime("YMDhmi")+"EQR.pdf";
	
		//  Mail Architecture 변경에 따른 소스 수정 10.01.11 Modify By ChungEunHo 
		Mail mail = new Mail();
		mail.setRdSubSysCd("EQR");
		mail.setFrom(account.getUsr_eml());
		mail.setSubject(eml_subject); 
		mail.setRecipient(email);
		mail.setTextContent(eml_content);
		List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
		
		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
		comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
		comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
		comRptDsgnXptInfoVO.setRdTmpltNm("REP_EES_EQR_0131.mrd");
		comRptDsgnXptInfoVO.setRdParaCtnt("/rp [" + repo_pln_id + "]" + "[" + ref_id + "]" + "[" + tpsz + "]" +  "[" + account.getOfc_cd()  + " / " +  account.getUsr_nm() + "]");
		comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
		comRptDsgnXptInfoVO.setXptFileNm(pdfFileName);
		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
		
		mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
		mail.send();
		
		
//			RDMailMetaInfo mailInfo = new RDMailMetaInfo("EQR", "REP_EES_EQR_0131.mrd", "N", eml_subject , eml_content, 
//				"/rp [" + repo_pln_id + "]" + "[" + ref_id + "]" + "[" + tpsz + "]" +  "[" + account.getOfc_cd()  + " / " +  account.getUsr_nm() + "]", 
//				account.getUsr_nm(), account.getUsr_eml(), email, account.getUsr_id());
//		
//			RDMailUtility.registerDB(mailInfo);
//			RDMailUtility.send(mailInfo);
			
		
		
	}

	/**
	 * EES_EQR_0131 Fax  Send.<br>
	 * 
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void sendFax(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws FaxSendException
	{
		// Fax 보내기
		String repo_pln_id = conditionVO.getRepoPlnId();
		String ref_id = conditionVO.getRefId();
		String tpsz = conditionVO.getTpsz();
		String fax = conditionVO.getFax();
		String fax_subject = conditionVO.getFaxSubject();
		
		try {		
			// fax 실제로 보내는 format로 맞추기. 받는사람1;받는사람fax1, 받는사람2;받는사람fax2
			String[] arrFaxNo   = null;
                       
			arrFaxNo = fax.split(",");
        
			for(int i=0; i<arrFaxNo.length; i++) {
				if( arrFaxNo[i].indexOf(";") == -1){	        	           
					arrFaxNo[i] = ";" + arrFaxNo[i] ;
				}	
				FaxMetaInfo info = new FaxMetaInfo("EQR", "REP_EES_EQR_0131.mrd", "N", fax_subject, 
					"/rp [" + repo_pln_id + "]" + "[" + ref_id + "]" + "[" + tpsz + "]" + "[" + account.getOfc_cd()  + " / " +  account.getUsr_nm() + "]",  
					arrFaxNo[i], account.getOfc_cd(),  account.getUsr_id());  
				
				// 2. FaxUtility를 이용하여, Database에 Data를 입력한다.	    	
				FaxUtility.registerDB(info);
				// 3. Fax 발송
		    	FaxUtility.send(info);	
		    	
			}
				
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new FaxSendException(e.getMessage());
		}
		
	}
}