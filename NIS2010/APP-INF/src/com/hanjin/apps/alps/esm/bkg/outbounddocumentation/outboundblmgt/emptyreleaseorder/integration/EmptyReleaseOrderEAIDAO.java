/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderEAIDAO.java
*@FileTitle : EmptyReleaseOrderEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.20 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * EAIDAO 연동 처리
 * @author Choi Do soon
 * @see com.hanjin.framework.support.layer.integration.EAIDAOSupport
 * @since J2EE 1.4
 */
public class EmptyReleaseOrderEAIDAO extends EAIDAOSupport {
	
	/**
	 * FAX : BKG001
	 * Rd Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param SendMtyRlseOrdVO[] faxInfos
	 * @author Choi Do Soon
	 * @return List<String>
	 * @throws Exception 
	 */
	private List<String> sendFax(SendMtyRlseOrdVO[] faxInfos) throws Exception {
		
		int arrLen = faxInfos.length;
		FaxMetaInfo[] infos = new FaxMetaInfo[arrLen];
		
		try {
			for (int i=0; i<arrLen; i++) {
				infos[i] = new FaxMetaInfo(faxInfos[i].getSysCd(),     // 모듈명(ex.BKG)
					 		               faxInfos[i].getTmplMrd(),   // MRD 파일 명 (ex.WO_NORMAL.mrd)
							               faxInfos[i].getBatchFlg(),  // 배치 유무(Y/N)
								           faxInfos[i].getTitle(),     // 제목
								           faxInfos[i].getTmplParam(), // RD Parameter (ex. [419][1][selho])
								           faxInfos[i].getRcvInfo(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           faxInfos[i].getOffice(),    // 지역 FAX office
								           faxInfos[i].getCrtUserId()  // 보내는 사람
								          ); 
			}
					
			return FaxUtility.registerDB(infos);

		} catch (Exception ex){
			throw new EAIException(ex.getMessage(), ex);
		}
	}

	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param SendMtyRlseOrdVO sendMtyRlseOrdVO
	 * @author Choi Do Soon
	 * @return String
	 * @throws Exception 
	 */
	public String sendMtyRlseOrdByFax(SendMtyRlseOrdVO sendMtyRlseOrdVO) throws Exception {
		
		SendMtyRlseOrdVO infos[] = new SendMtyRlseOrdVO[1];
		
		infos[0] = sendMtyRlseOrdVO;
		
		List<String> sendId = sendFax(infos);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	
	/**
	 * Mail : BKG001
	 * RDMail을 전송한다.
	 * 
	 * @param SendMtyRlseOrdVO[] emailInfos
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ccEmail
	 * @author Choi Do Soon
	 * @return List<String>
	 * @throws Exception
	 */
	private List<String> sendRDEmail(SendMtyRlseOrdVO[] emailInfos,BkgEmlEdtVO bkgEmlEdtVO,String ccEmail) throws Exception {
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ArrayList<SingleMailAttachedFile> fileList = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		String bkgNo = null;
		try {
			sndIds = new ArrayList<String>();
			for (int i=0; i<emailInfos.length; i++) {
				bkgNo = emailInfos[i].getContents().substring(emailInfos[i].getContents().lastIndexOf(":")+1,emailInfos[i].getContents().length()).trim();
				vo = new ComRptDsgnXptInfoVO();
				vo.setRdTmpltNm(emailInfos[i].getTmplMrd());
				vo.setRdParaCtnt(emailInfos[i].getTmplParam());
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm("SMLM"+bkgNo+".pdf");
				vo.setCreUsrId(emailInfos[i].getCrtUserId());
				vo.setUpdUsrId(emailInfos[i].getCrtUserId());
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				fileList = new ArrayList<SingleMailAttachedFile>();

				if(null!=bkgEmlEdtVO && bkgEmlEdtVO.getFileKey() != null ){
					String[] file = bkgEmlEdtVO.getFileKey().split(";");
					for( String fileKey:file ){
						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
						attachedFile.setFileKey(fileKey);
						fileList.add(attachedFile); 
					}
				}
				
				template = new TemplateMail();
				template.setAttachedFile(fileList);
				template.setBatFlg(emailInfos[i].getBatchFlg());
				template.setComRptDsgnXptInfoVOs(vos);
				template.setFrom(emailInfos[i].getSndEml(),emailInfos[i].getSndNm());
				if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
					template.setRecipient(bkgEmlEdtVO.getEdtToEml());
					template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
					template.setSubject(bkgEmlEdtVO.getEdtSubject()); 
					template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
				} else {
					template.setRecipient(emailInfos[i].getRcvEml());
					template.setCcRcvrEml(ccEmail);
					template.setSubject(emailInfos[i].getTitle()); 
					template.setHtmlTemplate("ESM_BKG_0252_01T.html");
					template.setArg("bkgNoTitle","BKG No : "+bkgNo);
					template.setArg("bkgNoBody",bkgNo);
				}
				sndIds.add(template.send());
			}
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new EAIException(ex.getMessage(), ex);
		}
		return sndIds;
	}	
	
	/**
	 * RD 메일을 전송한다.(파일 미첨부)
	 * 
	 * @param SendMtyRlseOrdVO sendMtyRlseOrdVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ccEmail
	 * @author Choi Do Soon
	 * @return String
	 * @throws Exception
	 */
	public String sendMtyRlseOrdByEmail(SendMtyRlseOrdVO sendMtyRlseOrdVO,BkgEmlEdtVO bkgEmlEdtVO,String ccEmail) throws Exception {
				
		SendMtyRlseOrdVO[] infos = new SendMtyRlseOrdVO[1];

		infos[0] = sendMtyRlseOrdVO;
		
		List<String> sendId = sendRDEmail(infos,bkgEmlEdtVO,ccEmail);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
}
