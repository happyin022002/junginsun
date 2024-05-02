/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBackEndBC.java
*@FileTitle : Customer Code Validation Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.ArrivalNoticeDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgArrNtcDtlVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 *   InboundNotice Back End Job Business Logic Basic Command implementation<br>
 * - Inbound BackEnd작업을 처리하는 Business Class
 * @author
 * @see UI-BKG_1054
 * @date 2009.06.05
 * @since J2EE 1.6
 */
public class ArrivalNoticeSendEmailBackEndJob extends BackEndCommandSupport {

	// Database Access Object
	private transient ArrivalNoticeDBDAO dbDao = new ArrivalNoticeDBDAO();
	private transient InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -1L;
	
	/**
	 * Customer Code Validation을 위한 Value
	 */
	private SignOnUserAccount signOnUserAccount;
	private ArrNtcSendListVO[] listVOs;
	

	/**
	 * Customer Code Validation을 위한 Value를 Setup 한다.
	 * @param ArrNtcSendListVO[] listVOS
	 */
	public void setListVOS(ArrNtcSendListVO[] listVOs) {
		if (listVOs != null) {
			ArrNtcSendListVO[] tmpVOs = new ArrNtcSendListVO[listVOs.length];
			System.arraycopy(listVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.listVOs = tmpVOs;
		}
	} 

	/**
	 * 다운로드 할 데이터 세팅 0613화면.
	 *
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.signOnUserAccount = account;
	}

	/**
	 * Customer code Validation을 실행한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		SignOnUserAccount account = this.signOnUserAccount;
		//1.modifyArrNtcBySend
		//2.modifyArrDtlByMail
		//3.sendEmail
		//4.modifyArrNtcSendId
		//5.searchBkgHistMstSeq	
		//6.setting max seq value		
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };		
		
		try {
			BookingUtil util = new BookingUtil();
			String copyEml = util.searchCcEmailAddrRSQL("AN", account.getUsr_id());	
			String bccRcvrEml = util.searchBccEmailAddrRSQL("AN");						//20160324.ADD
			log.debug("-------------------- bccRcvrEml : "+bccRcvrEml);					//20160324.ADD			
			
			List<RDMailSendVO> mailInfos = new ArrayList<RDMailSendVO>();
			
			for (ArrNtcSendListVO arrNtcSendListVO : this.listVOs) {
				
				if(arrNtcSendListVO.getChkEmail().equals("1")){
					dbDao.modifyArrNtcBySend(arrNtcSendListVO, account);
					
	
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					Vector<String> rcvMailInfo = new Vector<String>();
					
					Vector<String> vCustCntcTpCd = new Vector<String>();
					Vector<String> vNtcEml = new Vector<String>();
					vNtcEml.add(arrNtcSendListVO.getNtcEml1());
					vNtcEml.add(arrNtcSendListVO.getNtcEml2());
					vNtcEml.add(arrNtcSendListVO.getNtcEml3());
					vNtcEml.add(arrNtcSendListVO.getNtcEml4());
					vNtcEml.add(arrNtcSendListVO.getNtcEml5());
					Vector<String> vEmlEvntFlg = new Vector<String>();
					vEmlEvntFlg.add(arrNtcSendListVO.getEmlEvntFlg1());
					vEmlEvntFlg.add(arrNtcSendListVO.getEmlEvntFlg2());
					vEmlEvntFlg.add(arrNtcSendListVO.getEmlEvntFlg3());
					vEmlEvntFlg.add(arrNtcSendListVO.getEmlEvntFlg4());
					vEmlEvntFlg.add(arrNtcSendListVO.getEmlEvntFlg5());
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						dtlVO.setBkgNo(arrNtcSendListVO.getBkgNo());
						dtlVO.setBkgCustTpCd(arrNtcSendListVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setNtcEml(""+vNtcEml.get(x));
						dtlVO.setEmlEvntFlg(""+vEmlEvntFlg.get(x));
						dtlVO.setEmlTpCd("M");
                        dtlVO.setEmlSndUsrId(account.getUsr_id());
                        
						
						
						log.debug("-------------------- vEmlEvntFlg.get(x) " + x + "   :   "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
							log.debug("----------------- detail 수정실행");
							rcvMailInfo.add(vNtcEml.get(x));
							vCustCntcTpCd.add(arrCustCntcTpCd[x]);
	                        if(vNtcEml.get(x) == null || vNtcEml.get(x).equals("")){
	                        	continue;
	                        }
							int modResult = dbDao.modifyArrNtcDtlByMail(dtlVO, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByMail(dtlVO, account);
							}
							
						}
						
					}				
					
					log.debug("-------------- mailInfos length"+ mailInfos.size());					
					
					if( !StringUtils.isBlank(copyEml) ){	
						rcvMailInfo.add(copyEml);
					}					
	
					for(int v=0;v<rcvMailInfo.size();v++){
						RDMailSendVO mailInfo = new RDMailSendVO();
						List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
						
						String bkgNo = "";
						
						log.debug("------------------ 해당 MRD 정보구해오기");
						
						log.debug("rcvMailInfo.get(v) : " + rcvMailInfo.get(v));
						
						ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
						arrNtcMrdSearch.setBkgNo(arrNtcSendListVO.getBkgNo());
						arrNtcMrdSearch.setUsrId(account.getUsr_id());
						arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
						
						String mrdId = arrNtcSendListVO.getMrdId();
						String loclLangFlg = arrNtcSendListVO.getLoclLangFlg();
						
						String eclzBlCpyFlg = arrNtcSendListVO.getEclzBlCpyFlg();
						String comParam = arrNtcSendListVO.getComParam();
						
						
						bkgNo = arrNtcSendListVO.getBkgNo();
						
						ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();		
						
						rdVO.setCreUsrId(account.getUsr_id());
						rdVO.setUpdUsrId(account.getUsr_id());						
						
						rdVO.setXptFileNm("AN_"+arrNtcSendListVO.getBlNo() + ".pdf");
						rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						rdVO.setRdTmpltNm(mrdId + ".mrd");
						
						StringBuffer strArg = new StringBuffer("/rv ");
						strArg.append(" form_bkgNo['")  .append(bkgNo                     ).append("']");
						strArg.append(" form_usrId['")  .append(account.getUsr_id()       ).append("']");
						strArg.append(" form_loclFlg['")  .append(loclLangFlg             ).append("']");
						strArg.append(" form_tsFlg['")  .append(arrNtcSendListVO.getTsFlg()         ).append("']");
						strArg.append(" form_showPuFlg['")  .append(arrNtcSendListVO.getShowPuFlg() ).append("']");
						strArg.append(" form_chgDpFlg['")  .append(arrNtcSendListVO.getChgDpFlg()   ).append("']");
						strArg.append(" form_remarkCtnt['']");
						strArg.append(" form_ofcCd['")  .append(account.getOfc_cd()       ).append("']");
						strArg.append(" ").append(comParam);
						strArg.append(" /riprnmargin /rprncenteropt [3] /roldarithop");
												
						
						log.debug("--------------------------- 파라미터 : "+ strArg);
						
						
						rdVO.setRdParaCtnt(strArg.toString());
						rdVOs.add(rdVO);	
						
						mailInfo.setSndrNm("shipment.info@notifications.nykline.com");
						mailInfo.setSndrEml("shipment.info@notifications.nykline.com");	
						mailInfo.setRcvrEml(rcvMailInfo.get(v));
						mailInfo.setRcvrNm(arrNtcSendListVO.getCustNm());
//						mailInfo.setEmlTitNm("[" + ConstantMgr.getCompanyName().toUpperCase() +"] Container(s) will arrive at POD Soon"); //20151006 안진응 메일 타이틀 변경
						mailInfo.setEmlTitNm("Arrival Notice - " + arrNtcSendListVO.getVvd()); //Redmine #40604 - 2015-12-28 AN 제목안에 BL을 넣을 수없음 (모든 RD를 모아 한 email form 안에 넣기때문에 제일 마지막 BL만 가져옴) 대체로 VVD를 넣음
						mailInfo.setTemplate("ESM_BKG_0381_01T.html");

						HashMap<String, String> arguments = new HashMap<String, String>();
						arguments.put("rcvrNm", arrNtcSendListVO.getCustNm());
						mailInfo.setArguments(arguments);
					
						
						if (!arrNtcSendListVO.getFileKey().equals("")) {
							log.debug("-------------------- listVO.file_key Before: " + arrNtcSendListVO.getFileKey());
							
							if (isNumeric(arrNtcSendListVO.getFileKey())){
								String strFileKey = dbDao.searchAttachFileKey(arrNtcSendListVO);
								
								if (!strFileKey.equals("")) {
									arrNtcSendListVO.setFileKey(strFileKey);

									log.debug("-------------------- listVO.file_key After: " + arrNtcSendListVO.getFileKey());
								}
							}
						}
						
						mailInfo.setFileKey(arrNtcSendListVO.getFileKey());						
					
						log.debug("--------------------------- eclzBlCpyFlg    "+eclzBlCpyFlg);
						if(eclzBlCpyFlg.equals("Y")){
							rdVO = new ComRptDsgnXptInfoVO();
							
							rdVO.setCreUsrId(this.signOnUserAccount.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							
							strArg = new StringBuffer("/rv ");
							strArg.append(" form_bkgNo[( '").append(arrNtcSendListVO.getBkgNo()).append("' )] ");
						    strArg.append(" form_type[2]");// ---> Default
						    strArg.append(" form_dataOnly[N]");// ---> Default
						    strArg.append(" form_manifest[N]");// ---> Default
						    strArg.append(" form_usrId[").append(account.getUsr_id()).append("]");
						    strArg.append(" form_hiddeData[N]");// ---> Default
						    strArg.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
						    strArg.append(" form_remark[]");// ---> Default
						    strArg.append(" form_Cntr[1]");// ---> Default
						    strArg.append(" form_mainOnly[N]");// ---> Default
						    strArg.append(" form_CorrNo[]");// ---> Default
						    strArg.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
						    strArg.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
						    strArg.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
						    strArg.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
						    strArg.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
						    
						    strArg.append(" form_rqst_via_cd[]");// ---> Default
						    strArg.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
						    strArg.append(" form_path[]");// ---> Default
						    strArg.append(" isEncode[Y]");// ---> Default
						    strArg.append(" form_end_no[]");// ---> Default
						    strArg.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default
						    
						    
						    strArg.append(" /rp []");// ---> Default
						    strArg.append(" /riprnmargin");
							
//							strArg = "/rv ";
//							
//							strArg = strArg + " form_bkgNo[( '" + listVO.getBkgNo() + "' )] ";
//						    strArg = strArg + " form_type[2]";// ---> Default
//						    strArg = strArg + " form_dataOnly[N]";// ---> Default
//						    strArg = strArg + " form_manifest[N]";// ---> Default
//						    strArg = strArg + " form_usrId[" + account.getUsr_id() + "]";
//						    strArg = strArg + " form_hiddeData[N]";// ---> Default
//						    strArg = strArg + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
//						    strArg = strArg + " form_remark[]";// ---> Default
//						    strArg = strArg + " form_Cntr[1]";// ---> Default
//						    strArg = strArg + " form_mainOnly[N]";// ---> Default
//						    strArg = strArg + " form_CorrNo[]";// ---> Default
//						    strArg = strArg + " form_his_cntr[BKG_CONTAINER]";// ---> Default
//						    strArg = strArg + " form_his_bkg[BKG_BOOKING]";// ---> Default
//						    strArg = strArg + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
//						    strArg = strArg + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
//						    strArg = strArg + " form_his_bl[BKG_BL_DOC]";// ---> Default
//						    
//						    // 2015.01.14 안진응 추가
//						    strArg = strArg + " form_rqst_via_cd[]";
//						    strArg = strArg + " form_his_bl_mkd[BKG_BL_ISS]";
//						    strArg = strArg + " form_path[]";
//						    strArg = strArg + " isEncode[Y]";
//						    strArg = strArg + " form_end_no[]";				
//						    strArg = strArg + " form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]";				
//						    
//						    strArg = strArg + " /rp []";// ---> Default
//						    strArg = strArg + " /riprnmargin";
							
							
//							log.debug("---------- strArg "+ strArg.toString());
//							log.debug("------- O/B BL을 첨부하여 메일을 발송합니다.");
							rdVO.setXptFileNm("OBL_" +arrNtcSendListVO.getBlNo() +".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF); 
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArg.toString());
							
							rdVOs.add(rdVO);
						}
						
						log.debug("------------------ 실제 메일 발송 ");
						mailInfo.setComRptDsgnXptInfoVOs(rdVOs);
						
						mailInfos.add(mailInfo);
					}
					
				}
			}

			List<String> retEmlSndId = new ArrayList<String>();
			//20160324.ADD				
			if( !StringUtils.isBlank(bccRcvrEml) ){	
				mailInfos.get(0).setBccRcvrEml(bccRcvrEml);
				log.debug("-------------------- bccRcvrEml : "+mailInfos.get(0).getBccRcvrEml());
			}
			retEmlSndId = eaiDao.sendEmailGroupRDWithFiles(mailInfos);
			
			int y =0;
			for (int i = 0; i < listVOs.length; i++) {
				ArrNtcSendListVO listVO = listVOs[i];
				if(listVO.getChkEmail().equals("1")){	
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					Vector<String> rcvMailInfo = new Vector<String>();
					
					Vector<String> vCustCntcTpCd = new Vector<String>();
					Vector<String> vNtcEml = new Vector<String>();
					vNtcEml.add(listVO.getNtcEml1());
					vNtcEml.add(listVO.getNtcEml2());
					vNtcEml.add(listVO.getNtcEml3());
					vNtcEml.add(listVO.getNtcEml4());
					vNtcEml.add(listVO.getNtcEml5());
					Vector<String> vEmlEvntFlg = new Vector<String>();
					vEmlEvntFlg.add(listVO.getEmlEvntFlg1());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg2());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg3());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg4());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg5());
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setNtcEml(""+vNtcEml.get(x));
						dtlVO.setEmlEvntFlg(""+vEmlEvntFlg.get(x));
						dtlVO.setEmlTpCd("M");
                        dtlVO.setEmlSndUsrId(account.getUsr_id());
                        
                        
						
						log.debug("-------------------- vEmlEvntFlg.get(x) " + x + "   :   "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
						
							rcvMailInfo.add(vNtcEml.get(x));
							vCustCntcTpCd.add(arrCustCntcTpCd[x]);
						}
						
					}		
					
					
					log.debug("------------ retEmlSndId.size() "+retEmlSndId.size());
					
					for(int xx=0;xx<retEmlSndId.size();xx++){
						log.debug("-------------- retEmlSndId "+ xx + "    "+retEmlSndId.get(xx));
						if(retEmlSndId.get(xx) == null){
							retEmlSndId.set(xx,"NO SND NO");
						}
					}
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {				
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);		
						if(vEmlEvntFlg.get(x).equals("1")){
							log.debug("---------------Mail 전송후 Send Id 를 업데이트");
							log.debug("-------- bkg_no  "+dtlVO.getBkgNo());
							log.debug("-------- bkg_cust_tp_cd  "+dtlVO.getBkgCustTpCd());
							log.debug("-------- cust_cnt_tp_cd  "+dtlVO.getCustCntcTpCd());
							log.debug("-------- retEmlSndId.get(y)  "+retEmlSndId.get(y));
							dtlVO.setEmlNtcSndId(retEmlSndId.get(y));
							dbDao.modifyArrNtcSendIdByMail(dtlVO, account);
							y = y + 1;
						}
						
					}
					
					
					for(int q=0;q<rcvMailInfo.size();q++){				
						BkgNtcHisVO hisVO = new BkgNtcHisVO();
						hisVO.setNtcViaCd("M");
						hisVO.setSndId(retEmlSndId.get(q));
						hisVO.setSndOfcCd(account.getOfc_cd());
						hisVO.setSndUsrId(account.getUsr_id());
						hisVO.setCreUsrId(account.getUsr_id());
						hisVO.setUpdUsrId(account.getUsr_id());
						hisVO.setBkgNo(listVO.getBkgNo());
						hisVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						hisVO.setCustCntcTpCd(vCustCntcTpCd.get(q));
						
						log.debug("--------------listVO.getBkgNo()  "+ listVO.getBkgNo());
						
						log.debug("--------------listVO.getBkgCustTpCd()  "+ listVO.getBkgCustTpCd());
						
						hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
					}
					
				}
			}

		}catch (EventException de) {
//			de.printStackTrace();
			log.error("err " + de.toString(), de);
            throw de;
        }catch (DAOException de) {
//			de.printStackTrace();
        	log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return hisVOS;
		
	}

	/** isNumeric<br>
	 * @param String s
	 * @return static boolean
	 */
	private static boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    } 
}
