/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RDMailSendEAIDAO.java
*@FileTitle : RDMailSendEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.vo.SearchPreDispatchSentHistoryVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see EAIDAOSupport
 * @since J2EE 1.4
 */
public class RDMailSendEAIDAO extends EAIDAOSupport{

	private ArrayList emlresponseArray = null;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * PreDisPatchHistory의 event에 대한 멀티 이벤트 처리<br>
	 * PreDisPatchHistory MESSAGE Send E-mail
	 * 
	 * @param paramList
	 * @return
	 * @throws MailerAppException
	 */
	public ArrayList emailEdiSend(List<SearchPreDispatchSentHistoryVO> paramList) throws MailerAppException {
		String sys_cd = "TRS";
		String app_cd = "ESD_TRS_0027B.mrd";
		String batch_ind = "N";
		String title = "SM LINE";
		String param = "";
		String email_contents = "SM LINE";
		String sctrl_user_id = "";
		String rcv_email = "railbilling@us.smlines.com";		
		
		Mail mail = null;		
		SearchPreDispatchSentHistoryVO preVO = null;
		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = null;
		//ArrayList arr_email = new ArrayList();
		ArrayList arr_emlresponse = new ArrayList();

		String vndr_seq = "";
		String pvndr_seq = "";
		String seml_snd1_no = "";
		String seml_snd2_no = "";
		String seml_snd3_no = "";
		try {			
			
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			
			for( int p = 0; p < paramList.size(); p++ ) {
				
				preVO = (SearchPreDispatchSentHistoryVO)paramList.get(p);
				vndr_seq = preVO.getVndrSeq();
				sctrl_user_id = preVO.getUpdUsrId();
				
				
				if( !vndr_seq.equals(pvndr_seq) ) {
					// Vendor Seq, date조회 조건, printed의 일자, title의 일자    //preVO.getLoc_curr_date()
					param = "["+vndr_seq+"]["+preVO.getTrspDisRefNo()+"]";
					if( preVO.getDisN1stEml() != null && !"".equals(preVO.getDisN1stEml()) ) {
						param = param + "["+preVO.getDisN1stFaxNo()+"]["+preVO.getDisN1stEml()+"]";
						// new RDMailMetaInfo(sys_cd, app_cd, batch_ind, title, email_contents, param, preVO.getVndrLglEngNm(), 
						//rcv_email, preVO.getDisN1stEml(), sctrl_user_id);
						mail = new Mail();
						mail.setFrom(rcv_email, preVO.getVndrLglEngNm());
						mail.setSubject(title); 
						mail.setRecipient(preVO.getDisN1stEml());   //
						mail.setTextContent(email_contents);
						mail.setRdSubSysCd(sys_cd);
						mail.setBatFlg(batch_ind);
						
						comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
						comRptDsgnXptInfoVO.setCreUsrId(sctrl_user_id);
						comRptDsgnXptInfoVO.setUpdUsrId(sctrl_user_id);
						comRptDsgnXptInfoVO.setRdTmpltNm(app_cd);    //mrd 파일  Set
						comRptDsgnXptInfoVO.setXptFileNm("CNTR Available Notice.pdf");
						comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						comRptDsgnXptInfoVO.setRdParaCtnt(param);						
						comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
						mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
						seml_snd1_no = mail.send();

					}
					if( preVO.getDisN2ndEml() != null && !preVO.getDisN2ndEml().equals("") ) {
						param = param + "["+preVO.getDisN2ndFaxNo()+"]["+preVO.getDisN2ndEml()+"]";
						mail = new Mail();
						mail.setFrom(rcv_email, preVO.getVndrLglEngNm());
						mail.setSubject(title); 
						mail.setRecipient(preVO.getDisN2ndEml());   
						mail.setTextContent(email_contents);
						mail.setRdSubSysCd(sys_cd);
						mail.setBatFlg(batch_ind);
						
						comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
						comRptDsgnXptInfoVO.setCreUsrId(sctrl_user_id);
						comRptDsgnXptInfoVO.setUpdUsrId(sctrl_user_id);
						comRptDsgnXptInfoVO.setRdTmpltNm(app_cd);    //mrd 파일  Set
						comRptDsgnXptInfoVO.setXptFileNm("CNTR Available Notice.pdf");
						comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						comRptDsgnXptInfoVO.setRdParaCtnt(param);						
						comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
						mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
						seml_snd2_no = mail.send();
						
	
					}
					if( preVO.getDisN3rdEml() != null && !preVO.getDisN3rdEml().equals("") ) {
						param = param + "["+preVO.getDisN3rdFaxNo()+"]["+preVO.getDisN3rdEml()+"]";
						mail = new Mail();
						mail.setFrom(rcv_email, preVO.getVndrLglEngNm());
						mail.setSubject(title); 
						mail.setRecipient(preVO.getDisN3rdEml());   						
						mail.setTextContent(email_contents);
						mail.setRdSubSysCd(sys_cd);
						mail.setBatFlg(batch_ind);
						
						comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
						comRptDsgnXptInfoVO.setCreUsrId(sctrl_user_id);
						comRptDsgnXptInfoVO.setUpdUsrId(sctrl_user_id);
						comRptDsgnXptInfoVO.setRdTmpltNm(app_cd);    //mrd 파일  Set
						comRptDsgnXptInfoVO.setXptFileNm("CNTR Available Notice.pdf");
						comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						comRptDsgnXptInfoVO.setRdParaCtnt(param);						
						comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
						mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
						seml_snd3_no = mail.send();
						

					}
				}
				
				
				if( preVO.getDisN1stEml() != null && !preVO.getDisN1stEml().equals("") ) {
					preVO.setEmlSnd1No(seml_snd1_no);
				}
				if( preVO.getDisN2ndEml() != null && !preVO.getDisN2ndEml().equals("") ) {
					preVO.setEmlSnd2No(seml_snd2_no);
				}
				if( preVO.getDisN3rdEml() != null && !preVO.getDisN3rdEml().equals("") ) {
					preVO.setEmlSnd3No(seml_snd3_no);
				}
				arr_emlresponse.add(preVO);
				this.setEmlresponse_array(arr_emlresponse);
				pvndr_seq = vndr_seq;
			}
			
		} catch (Exception e){
			log.error(e.getMessage());
			throw new MailerAppException(e.getMessage());

		}

		return this.getEmlresponse_array();
    }
	
	/**
	 * @param arraylist
	 */
	private void setEmlresponse_array(ArrayList emlresponse_array) {
		this.emlresponseArray = emlresponse_array;
	}
	
	/**
	 * @return response ArrayList
	 */
	public ArrayList getEmlresponse_array() {
		return emlresponseArray;
	}
    
}
