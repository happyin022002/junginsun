/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchKoreaMOTFilingEmailBackEndJob.java
*@FileTitle : Korea MOF Filing (by Upload) - Multi-Download
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History
* 2016.06.30 [CHM-201642423] [해수부 운임 신고 시스템 (임시방식)] 다운로드시 파일 형식 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
/* RD Report Generate Module Import */
import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo; 

/**
 * Korea MOF Filing (by Upload) - Multi-Download 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeeye Jeon
 * @see RFAReportDBDAO
 * @since J2EE 1.6
 */
public class SearchKoreaMOTFilingEmailBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 1638677229317513382L;

	private SignOnUserAccount account;
	private RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO;
	private RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs;
	
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * @return the rsltSearchKoreaMOTListVO
	 */
	public RsltSearchKoreaMOTListVO getRsltSearchKoreaMOTListVO() {
		return rsltSearchKoreaMOTListVO;
	}

	/**
	 * @param rsltSearchKoreaMOTListVO the rsltSearchKoreaMOTListVO to set
	 */
	public void setRsltSearchKoreaMOTListVO(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) {
		this.rsltSearchKoreaMOTListVO = rsltSearchKoreaMOTListVO;
	}

	/**
	 * @return the rsltSearchKoreaMOTListVOs
	 */
	public RsltSearchKoreaMOTListVO[] getRsltSearchKoreaMOTListVOs() {
		RsltSearchKoreaMOTListVO[] rtnVOs = null;
		if (this.rsltSearchKoreaMOTListVOs != null) {
			rtnVOs = new RsltSearchKoreaMOTListVO[rsltSearchKoreaMOTListVOs.length];
			System.arraycopy(rsltSearchKoreaMOTListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param rsltSearchKoreaMOTListVOs the rsltSearchKoreaMOTListVOs to set
	 */
	public void setRsltSearchKoreaMOTListVOs(RsltSearchKoreaMOTListVO[] rsltSearchKoreaMOTListVOs) {
		if(rsltSearchKoreaMOTListVOs != null){
			RsltSearchKoreaMOTListVO[] tmpVOs = new RsltSearchKoreaMOTListVO[rsltSearchKoreaMOTListVOs.length];
			System.arraycopy(rsltSearchKoreaMOTListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchKoreaMOTListVOs = tmpVOs;
		}
	}

	/**
	 * RFA Rate Horizontal Excel Updoad Transaction을 처리한다.<br>
	 *  
	 * @return List
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		
		this.sendSISFile();
		
		return null;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	* 해수부 FILING 을 위해 다수개의 RD 계약 정보를 Email Send 합니다<br>
	*  
	* @param List vo, MainVO mainVO
	* @return String
	* @exception Exception 
	*/
	private String sendSISFile() throws Exception {
		
		//메일 응답 번호
		String sendMailNo = "";
		
		//메일 발신자
		String sndrEml = account.getUsr_eml();
		
		//메일 제목
		String emlTitNm = account.getUsr_nm(); // Requester 의 Full Name + 메일 발송 시점 (변경)
		
		//메일 수신자
		String rcvrEml = "Korea.Filing@smlines.com";
//		String rcvrEml = "smtp_test@smlines.com";	// DEV
		
		//메일 CC수신자
		String ccRcvrEml = "";
		
		//메일 내용
		String html = "ESM_PRI_0150.html";
		
		/********************************************************
		* 이메일 공통 테이블 참조
		select * from COM_EML_ATCH_FILE;
		select * from COM_EML_ATCH_FILE_RSLT;
		select * from COM_EML_SND_CTNT;
		select * from COM_EML_SND_INFO WHERE RD_SUB_SYS_CD = 'PRI';
		select * from COM_EML_SND_RSLT_INFO;
		2) 파일 전송은 zip 파일이 아닌 개별 PDF 파일로 전송하며, 파일명은 ‘계약_#Amd_EFF”.pdf 로 설정.
		(예) AEF160974_#004_20160517.pdf
		3) 메일 제목 : Requester 의 Full Name + 메일 발송 시점
		(예) Hye-In Ahn (2016-05-17 18:10 (KST))
		4) 메일 본문 내용 : Multi-Download 클릭 시점 및 조회 조건 : (기존 0번, 5번 삭제)
		(예) 1. Date By : Filed (SC) / Approved (RFA)
		2. Date From_To : 2016-05-17 ~ 2016-05-17
		3. Contract Type : S/C, RFA (B/A/C)
		4. APVL OFC : None
		********************************************************/
		try {
			
			TemplateMail tempMail = new TemplateMail(); 
			
			// 화면에서 선택한 파일 List 내용을 comRptDsgnXptInfoVOs 에 전달함.
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = null;
			
			// 첨부 파일 생성
			for(int i=0; i<rsltSearchKoreaMOTListVOs.length; i++) {
				comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
				
				// 사용자 명
				comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
				
				// 파일 타입
				comRptDsgnXptInfoVO.setXptFileTpCd( ExportInfo.FTYPE_PDF);
				
				// 결과 파일명
				//계약#_Amd#_EFF”.pdf   (예) AEF160974_#004_20160517.pdf
				StringBuffer fileNm = new StringBuffer();
				fileNm.append(rsltSearchKoreaMOTListVOs[i].getCtrtNo() + "_#" + leftPad(rsltSearchKoreaMOTListVOs[i].getAmdtSeq(), 3) + "_");
				fileNm.append( rsltSearchKoreaMOTListVOs[i].getAmdtEffDt().replaceAll("-", "") + ".pdf");
				
				comRptDsgnXptInfoVO.setXptFileNm(fileNm.toString());
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Name : " + fileNm.toString() );
				
				/**
				 * [CHM-201642423] [해수부 운임 신고 시스템 (임시방식)] 다운로드시 파일 형식 변경 요청
				 * Date by 선택사항에서 Effective 나 Filed (SC) / Approved (RFA)  선택시 모두 S/C 및 RFA Full draft 보이도록 파일 형식 변경 요청 
				 */
//				// Date By : Filed (SC) / Approved (RFA)
//				if("1".equals(this.rsltSearchKoreaMOTListVO.getDateBy())) {
//					// SC
//					if("SC".equals(rsltSearchKoreaMOTListVOs[i].getCtrtType())){
//						// MRD 파일 명 및 rd 파라미터
//						if ( Integer.parseInt(rsltSearchKoreaMOTListVOs[i].getAmdtSeq()) == 0 ) {
//							comRptDsgnXptInfoVO.setRdTmpltNm("ESM_PRI_0061.mrd");
//							comRptDsgnXptInfoVO.setRdParaCtnt ("/rsumunknownvar /rp [" + rsltSearchKoreaMOTListVOs[i].getPropNo() +"] ["+rsltSearchKoreaMOTListVOs[i].getAmdtSeq()+"] [Y] [Y] [A]");
//							log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Case  : ESM_PRI_0061 all  ");
//						} else  if ( Integer.parseInt(rsltSearchKoreaMOTListVOs[i].getAmdtSeq()) > 0 ) {
//							comRptDsgnXptInfoVO.setRdTmpltNm("ESM_PRI_0079.mrd");
//							comRptDsgnXptInfoVO.setRdParaCtnt ("/rsumunknownvar /rp [" + rsltSearchKoreaMOTListVOs[i].getPropNo() +"] ["+rsltSearchKoreaMOTListVOs[i].getAmdtSeq()+"] [Y] [Y]");
//							log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Case  : ESM_PRI_0079 amend ");
//						}
//						
//					//RFA
//					} else {
//						// MRD 파일 명 및 rd 파라미터
//						if ( Integer.parseInt(rsltSearchKoreaMOTListVOs[i].getAmdtSeq()) == 0 ) {
//							comRptDsgnXptInfoVO.setRdTmpltNm("ESM_PRI_2039.mrd");
//							comRptDsgnXptInfoVO.setRdParaCtnt ("/rp [" + rsltSearchKoreaMOTListVOs[i].getPropNo() +"] ["+rsltSearchKoreaMOTListVOs[i].getAmdtSeq()+"]");
//							log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Case  : ESM_PRI_2039 all ");
//						}  else  if ( Integer.parseInt(rsltSearchKoreaMOTListVOs[i].getAmdtSeq()) > 0 ) {
//							comRptDsgnXptInfoVO.setRdTmpltNm("ESM_PRI_2062.mrd");
//							comRptDsgnXptInfoVO.setRdParaCtnt ("/rp [" + rsltSearchKoreaMOTListVOs[i].getPropNo() +"] ["+rsltSearchKoreaMOTListVOs[i].getAmdtSeq()+"]");
//							log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Case  : ESM_PRI_2062 amend ");
//						}
//						
//					}
//					
//				// Date By : Effective - 최초 신고의 목적이므로 모두 모든 내용이 보이도록 요청. by Hye-In Ahn (XWPA)
//				} else {
					// SC
					if("SC".equals(rsltSearchKoreaMOTListVOs[i].getCtrtType())){
						// MRD 파일 명 및 rd 파라미터
						comRptDsgnXptInfoVO.setRdTmpltNm("ESM_PRI_0061.mrd");
						comRptDsgnXptInfoVO.setRdParaCtnt ("/rsumunknownvar /rp [" + rsltSearchKoreaMOTListVOs[i].getPropNo() +"] ["+rsltSearchKoreaMOTListVOs[i].getAmdtSeq()+"] [Y] [Y] [A]");
						log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Case  : ESM_PRI_0061 all ");
					//RFA
					} else {
						// MRD 파일 명 및 rd 파라미터
						comRptDsgnXptInfoVO.setRdTmpltNm("ESM_PRI_2039.mrd");
						comRptDsgnXptInfoVO.setRdParaCtnt ("/rp [" + rsltSearchKoreaMOTListVOs[i].getPropNo() +"] ["+rsltSearchKoreaMOTListVOs[i].getAmdtSeq()+"]");
						log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>> file Case  : ESM_PRI_2039 all ");
					}
//				}
				
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			}
			
//			log.debug(">>>>>>  setComRptDsgnXptInfoVOs . size : " + comRptDsgnXptInfoVOs.size() );
			// 첨부파일 List RD 정보를 mail 에 전송함(요청순서:RD생성 -> Mail)
			tempMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			
			/** 메일 기본정보 셋팅 **/
			// FROM
			if(sndrEml == null || "".equals(sndrEml)){
				// 메일 주소가 없는 경우
				tempMail.setFrom("Korea.Filing@smlines.com");
			} else {
				tempMail.setFrom(sndrEml);
			}
			tempMail.setRecipient(rcvrEml);					// TO
			tempMail.setCcRcvrEml(ccRcvrEml);				// CC
			//메일 제목
			tempMail.setSubject(emlTitNm + " (" + (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date()) + " (KST))");
			tempMail.setHtmlTemplate(html);					// html 파일로 내용 전송시 사용함.
			tempMail.setRdSubSysCd("PRI");					// 모듈명(COM_EML_SND_INFO 조회시)
			tempMail.setBatFlg("N");								// OLTP인 경우는 N을 설정, Batch 인 경우는 Y를 설정
			
			// html 파람1 - 1. Date By : Filed (SC) / Approved (RFA)
			if("1".equals(this.rsltSearchKoreaMOTListVO.getDateBy())) {
				tempMail.setArg("param1", "Filed (SC) / Approved (RFA)");                   
			} else {
				tempMail.setArg("param1", "Effective");
			}
			
			// html 파람2 - 2. Date From_To : 2016-05-17 ~ 2016-05-17
			tempMail.setArg("param2", this.rsltSearchKoreaMOTListVO.getFEffDt() + " ~ " + this.rsltSearchKoreaMOTListVO.getFExpDt());
			
			// html 파람3 - 3. Contract Type : S/C, RFA (B/A/C)
			StringBuffer ctrtTpNm = new StringBuffer();
			
			// SC
			if(this.rsltSearchKoreaMOTListVO.getFCtrtTp().indexOf("S")!=-1) {
				ctrtTpNm.append("S/C");
			}
			if(this.rsltSearchKoreaMOTListVO.getFCtrtTp().indexOf("R")!=-1) {
				if(ctrtTpNm.length() != 0) {
					ctrtTpNm.append(", ");
				}
				ctrtTpNm.append("RFA (B/A/C)");
			}
			tempMail.setArg("param3", ctrtTpNm.toString());
			
			// html 파람4 - 4. APVL OFC : None
			if(this.rsltSearchKoreaMOTListVO.getApvlOfc() == null || "".equals(this.rsltSearchKoreaMOTListVO.getApvlOfc())) {
				tempMail.setArg("param4", "None");
			} else {
				tempMail.setArg("param4", this.rsltSearchKoreaMOTListVO.getApvlOfc());
			}
			
			//메일 발송 및 응답번호
			sendMailNo = tempMail.send();
//			log.debug("[REQUEST :: sendMailNo :"+sendMailNo +"]" );
			
		} catch(Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		
		return sendMailNo;
	}
	
	/**
	* 넘어온 text를 size 길이만큼 0을 lpad해서 리턴한다.
	* ex) 0 -> 000, 22 -> 022
	*    
	* @param String text
	* @param int size
	* @return String
	* @exception Exception 
	*/
    public static String leftPad(String text, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("0");
        }
        sb.append(text);
        return sb.substring(sb.length() - size, sb.length());
    }
}
