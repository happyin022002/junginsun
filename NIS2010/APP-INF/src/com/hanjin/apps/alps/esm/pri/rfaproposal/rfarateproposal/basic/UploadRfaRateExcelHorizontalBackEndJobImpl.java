/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UploadRateExcelHorizontalBackEndJobImpl.java
*@FileTitle : UploadRateExcelHorizontalBackEndJobImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 박근환
*@LastVersion : 1.0
* 2016.04.14 박근환
* 1.0 Creation
=========================================================
* History
* [CHM-201640671] RFA 효율화를 위한 요청 (1차)
* [CHM-201641745] [RFA 효율화를 위한 요청 (1차)] APP 오류 발견(SHA16M0374 case) 및 Service Scope validation 미적용
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration.RFARateProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * RFA Rate Excel Upload 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sungsoo, Park
 * @see RFARateProposalDBDAO
 * @since J2EE 1.6
 */
public class UploadRfaRateExcelHorizontalBackEndJobImpl extends BackEndCommandSupport{

	private static final long serialVersionUID = 6097486557477880250L;

	private  RFARateProposalDBDAO dbDao = new RFARateProposalDBDAO();
	
	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO;
	private RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs;
	private SignOnUserAccount account;

	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	public RsltRtListHorizontalExcelVO[] getRsltRtListHorizontalExcelVOs() {
		RsltRtListHorizontalExcelVO[] rtnVOs = null;
		if (this.rsltRtListHorizontalExcelVOs != null) {
			rtnVOs = new RsltRtListHorizontalExcelVO[rsltRtListHorizontalExcelVOs.length];
			System.arraycopy(rsltRtListHorizontalExcelVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltRtListHorizontalExcelVOs(RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs){
		if(rsltRtListHorizontalExcelVOs != null){
			RsltRtListHorizontalExcelVO[] tmpVOs = new RsltRtListHorizontalExcelVO[rsltRtListHorizontalExcelVOs.length];
			System.arraycopy(rsltRtListHorizontalExcelVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListHorizontalExcelVOs = tmpVOs;
		}
	}

	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * RFA Rate Horizontal Excel Updoad Transaction을 처리한다.<br>
	 *  
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
	public List doStart() throws Exception {
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();
		List<PriRfaNoteConvVO> noteConvVoList = new ArrayList<PriRfaNoteConvVO>();
		List<PriRpScpRtCmdtRnoteVO> rNoteVoList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
		List<String> noteCtntList = new ArrayList<String>();
		List<RsltRoutHdrSmryListVO> routHdrSmryList = new ArrayList<RsltRoutHdrSmryListVO>();
		
		try {			
			int nextRoutSeq = 0;
			int insertNextRoutSeq = 0;
			int updateNextRoutSeq = 0;
			int nextCmdtHdrSeq = 1;
			int nextRoutPntSeq = 1;
			int nextRoutViaSeq = 1;
			int nextRtSeq = 0;
			int nextNoteConvSeq = 0;
			int nextRoutNoteSeq = 1;
			
			boolean routHdrSmryDiv = false;
			boolean routMaxSeqDiv = false;
			 
			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			String preNoteConvMapgId = "";
		    String strNoteCtnt = "";
		    String routMaxSeq = "";
		    
			String updateStrPropNo = "";
			String updateStrAmdtSeq = "";
			String updateStrSvcScpCd = "";
			String updateNextCmdtHdrSeq = "";
			String updateStrN1stCmncAmdtSeq = "";
		    
			// Route & Summary > Charge Term 입력값 생성
		    for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
		    	RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];
		    	
		    	String strNoteConvRuleCd = row.getNoteConvRuleCd();
		    	String strNoteConvChgCd = row.getNoteConvChgCd();
		    	
			    if (("APP".equals(strNoteConvRuleCd) && i > 0)) {
			    	noteCtntList.add(strNoteCtnt);
			    }		
			    
			    if ("APP".equals(strNoteConvRuleCd)) {			    	
			    	strNoteCtnt = "";
			    	strNoteCtnt = strNoteConvRuleCd;
			    }
			    
			    if (!"".equals(strNoteConvChgCd)) {			    	
			    	strNoteCtnt = strNoteCtnt + ", " + strNoteConvChgCd;
			    }
			    
			    if (i == rsltRtListHorizontalExcelVOs.length - 1) {
			    	noteCtntList.add(strNoteCtnt);
			    }
		    }
		    
			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];

				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				
				String strAppBkgDirCallFlg = row.getAppBkgDirCallFlg();
			    String strAppBkgTsPortDefCd = row.getAppBkgTsPortDefCd();
			    String strAppBkgSlanCd = row.getAppBkgSlanCd();
			    String strChgRuleDefCd = row.getChgRuleDefCd();
			    String strRtApplTpCd = row.getRtApplTpCd();
			    String strCurrCd = row.getCurrCd();
			    
				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				
			    String strBkgRatUtCdBl = row.getBkgRatUtCdBl();
			    String strBkgRatUtCdCm = row.getBkgRatUtCdCm();
			    String strBkgRatUtCdBx = row.getBkgRatUtCdBx();
			    
			    String strConvBkgDirCallFlg = row.getConvBkgDirCallFlg();
			    String strConvBkgTsPortDefCd = row.getConvBkgTsPortDefCd();
			    String strConvBkgSlanCd = row.getConvBkgSlanCd();
			    String strPayTermCd = row.getPayTermCd();
			    String strBkgYdCd = row.getBkgYdCd();
			    String strBkgMinCgoWgt = row.getBkgMinCgoWgt();
			    String strBkgMaxCgoWgt = row.getBkgMaxCgoWgt();
			    
			    String strNoteConvMapgId = row.getNoteConvMapgId();
			    String strNoteConvTpCd = "R";
			    String strEffDt = row.getEffDt();
			    String strExpDt = row.getExpDt();
			    String strN1stCmncAmdtSeq = row.getN1stCmncAmdtSeq();
			    String strChgRuleTpCd = row.getChgRuleTpCd();
			    String strNoteConvChgCd = row.getNoteConvChgCd();
			    String strNoteConvRuleCd = row.getNoteConvRuleCd();
			    String strAppBkgVslCd = row.getAppBkgVslCd();
			    String strAppBkgSkdVoyNo = row.getAppBkgSkdVoyNo();
			    String strAppBkgSkdDirCd = row.getAppBkgSkdDirCd();
			    String strAppBkgTsPortTpCd = row.getAppBkgTsPortTpCd();
			    String strConvBkgVslCd = row.getConvBkgVslCd();
			    String strConvBkgSkdVoyNo = row.getConvBkgSkdVoyNo();
			    String strConvBkgSkdDirCd = row.getConvBkgSkdDirCd();
			    String strConvBkgTsPortTpCd = row.getConvBkgTsPortTpCd();
			    String strSrcInfoCd = row.getSrcInfoCd();
			    String strAppBkgVvdCd = row.getAppBkgVvdCd();
			    
			    RsltRoutHdrSmryListVO routSmry = new RsltRoutHdrSmryListVO();
			    
			    routSmry.setPropNo(strPropNo);
			    routSmry.setAmdtSeq(strAmdtSeq);
			    routSmry.setSvcScpCd(strSvcScpCd);
			    routSmry.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
			    routSmry.setBkgDirCallFlg(strAppBkgDirCallFlg);
			    routSmry.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
			    routSmry.setBkgSlanCd(strAppBkgSlanCd);
			    routSmry.setBkgVvdCd(strAppBkgVvdCd);
			    routSmry.setOrgRoutPntLocDefCd(strOrgPntCd);
			    routSmry.setRcvDeTermCdOri(strOrgRcvDeTermCd);
			    routSmry.setOrgRoutViaPortDefCd(strOrgViaCd);
			    routSmry.setDestRoutViaPortDefCd(strDestViaCd);
			    routSmry.setDestRoutPntLocDefCd(strDestPntCd);
			    routSmry.setRcvDeTermCdDest(strDestRcvDeTermCd);

			    if (!"".equals(strOrgPntCd) && !"".equals(strOrgViaCd) 
			    	&& !"".equals(strDestViaCd) && !"".equals(strDestPntCd)) {
			    	// 해당 Route 가 이미 존재하는지 조회
			    	routHdrSmryList = dbDao.searchRoutHdrSmryList(routSmry);
			    	
			    	log.debug(">>>>>>>>>> routHdrSmryList size " + routHdrSmryList.size());
			    	
			    	nextRoutSeq++;
			    	
			    	if (routHdrSmryList.size() > 0) {		
				    	
				    	// Insert(false) or Update(true) 구분  
				    	routHdrSmryDiv = true;

				    	log.debug(">>>>>>>>>> Update Route " + " Origin : " + strOrgPntCd + " Ori.Term. : " + strOrgRcvDeTermCd + " O.Via. : " + strOrgViaCd + " Dest. Via. : " + strDestViaCd + " Dest. : " + strDestPntCd + " Dest. Term." + strDestRcvDeTermCd);
				    	
				    	for (int j = 0; routHdrSmryList != null && j < routHdrSmryList.size(); j++) {	
					    	updateStrPropNo = routHdrSmryList.get(j).getPropNo();
					    	updateStrAmdtSeq = routHdrSmryList.get(j).getAmdtSeq();
					    	updateStrSvcScpCd = routHdrSmryList.get(j).getSvcScpCd();
					    	updateNextCmdtHdrSeq = routHdrSmryList.get(j).getCmdtHdrSeq();
					    	updateNextRoutSeq = Integer.parseInt(routHdrSmryList.get(j).getRoutSeq());
					    	updateStrN1stCmncAmdtSeq = routHdrSmryList.get(j).getN1stCmncAmdtSeq();
						}
					} else {
						// Insert(false) or Update(true) 구분 
				    	routHdrSmryDiv = false;

				    	log.debug(">>>>>>>>>> insert Route " + " Origin : " + strOrgPntCd + " Ori.Term. : " + strOrgRcvDeTermCd + " O.Via. : " + strOrgViaCd + " Dest. Via. : " + strDestViaCd + " Dest. : " + strDestPntCd + " Dest. Term." + strDestRcvDeTermCd);
				    	
						PriRpScpRtCmdtRoutVO cmdtRout = new PriRpScpRtCmdtRoutVO();
				    	cmdtRout.setPropNo(strPropNo);
				    	cmdtRout.setAmdtSeq(strAmdtSeq);
				    	cmdtRout.setSvcScpCd(strSvcScpCd);
				    	
				    	// Route Sequence Max 값 조회 - 한번만 조회하면 된다.
				    	routMaxSeq = dbDao.searchCmdtRoutMaxSeq(cmdtRout);
				    	if ("" != routMaxSeq && !routMaxSeqDiv) {
				    		routMaxSeqDiv = true;
				    		insertNextRoutSeq = Integer.parseInt(routMaxSeq);
				    		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> insert Next Rout Seq Flag " +  routMaxSeqDiv + " seq : " + insertNextRoutSeq);
				    	}						
					}
			    }
			    		    
			    if (!routHdrSmryDiv) {	// Insert
					if (strOrgPntCd != null && !"".equals(strOrgPntCd)
						&& strDestPntCd != null && !"".equals(strDestPntCd)
						&& strChgRuleDefCd != null && !"".equals(strChgRuleDefCd)
						&& strRtApplTpCd != null && !"".equals(strRtApplTpCd)) {
					    
					    insertNextRoutSeq++;
					    
						nextRoutPntSeq = 1;
						nextRoutViaSeq = 1;
						nextRtSeq = 0;
						nextNoteConvSeq = 0;
						nextRoutNoteSeq = 1;
						
				    	log.debug(">>>>>>>>>> Route Insert " + " Origin : " + strOrgPntCd + " Dest. : " + strDestPntCd + " insertNextRoutSeq : " + insertNextRoutSeq);
				    	
						// Route Insert
						PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();					
						
						rout.setPropNo(strPropNo);
						rout.setAmdtSeq(strAmdtSeq);
						rout.setSvcScpCd(strSvcScpCd);
						rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rout.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rout.setN1stCmncAmdtSeq(strAmdtSeq);
						rout.setCreUsrId(strCreUsrId);
						rout.setUpdUsrId(strUpdUsrId);
	
						routVoList.add(rout);						
					}
					
					if (strOrgPntCd != null && !"".equals(strOrgPntCd)
						&& strDestPntCd != null && !"".equals(strDestPntCd)
						&& strChgRuleDefCd != null && !"".equals(strChgRuleDefCd)
						&& strRtApplTpCd != null && !"".equals(strRtApplTpCd)
						&& strNoteConvMapgId != null && !"".equals(strNoteConvMapgId)) {
						
						// Rnote Insert
						PriRpScpRtCmdtRnoteVO rNote = new PriRpScpRtCmdtRnoteVO();
						
				    	rNote.setPropNo(strPropNo);
				    	rNote.setAmdtSeq(strAmdtSeq);
				    	rNote.setSvcScpCd(strSvcScpCd);
				    	rNote.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
				    	rNote.setRoutSeq(String.valueOf(insertNextRoutSeq));
				    	rNote.setRoutNoteSeq(String.valueOf(nextRoutNoteSeq));
				    	rNote.setNoteCtnt(noteCtntList.get((nextRoutSeq-1)));
				    	rNote.setNoteConvMapgId(strNoteConvMapgId);
				    	rNote.setPrcProgStsCd("I");
				    	rNote.setSrcInfoCd("NW");
				    	rNote.setN1stCmncAmdtSeq(strAmdtSeq);
				    	rNote.setCreUsrId(strCreUsrId);
				    	rNote.setUpdUsrId(strUpdUsrId);
				    	
				    	rNoteVoList.add(rNote);
					}
	
					// Origin Route Point Insert
					if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
						
						String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
	
						PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
						pnt.setPropNo(strPropNo);
						pnt.setAmdtSeq(strAmdtSeq);
						pnt.setSvcScpCd(strSvcScpCd);
						pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						pnt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						pnt.setOrgDestTpCd("O");
						pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
						pnt.setRoutPntLocTpCd(locTpCd);
						pnt.setRoutPntLocDefCd(strOrgPntCd);
						pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
						pnt.setPrcProgStsCd("I");
						pnt.setSrcInfoCd("NW");
						pnt.setN1stCmncAmdtSeq(strAmdtSeq);
						pnt.setCreUsrId(strCreUsrId);
						pnt.setUpdUsrId(strUpdUsrId);
	
						log.debug(">>>>>>>>>> Origin Route Point Insert " + " Origin : " + strOrgPntCd + " Dest. : " + insertNextRoutSeq + " nextRoutPntSeq :  " + nextRoutPntSeq);
						
						pntVoList.add(pnt);
					}
					
					// Origin Route Via Insert
					if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
						
						String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";
	
						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(insertNextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);
	
						viaVoList.add(via);
					}
					
					// Destination Route Via Insert
					if (strDestViaCd != null && !"".equals(strDestViaCd)) {
						
						String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";
	
						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(insertNextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);
	
						viaVoList.add(via);
					}
					
					// Destination Route Point Insert
					if (strDestPntCd != null && !"".equals(strDestPntCd)) {
						
						String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";
						
						PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
						pnt.setPropNo(strPropNo);
						pnt.setAmdtSeq(strAmdtSeq);
						pnt.setSvcScpCd(strSvcScpCd);
						pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						pnt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						pnt.setOrgDestTpCd("D");
						pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
						pnt.setRoutPntLocTpCd(locTpCd);
						pnt.setRoutPntLocDefCd(strDestPntCd);
						pnt.setRcvDeTermCd(strDestRcvDeTermCd);
						pnt.setPrcProgStsCd("I");
						pnt.setSrcInfoCd("NW");
						pnt.setN1stCmncAmdtSeq(strAmdtSeq);
						pnt.setCreUsrId(strCreUsrId);
						pnt.setUpdUsrId(strUpdUsrId);
						
						log.debug(">>>>>>>>>> Destination Route Point Insert " + " Dest. : " + strDestPntCd + " insertNextRoutSeq : " + insertNextRoutSeq + " nextRoutPntSeq :  " + nextRoutPntSeq);
						
						pntVoList.add(pnt);
					}
	
					// Amount > Dry 20' Insert
					if (strRateDry20 != null && !"".equals(strRateDry20) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(strPropNo);
						rt.setAmdtSeq(strAmdtSeq);
						rt.setSvcScpCd(strSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D2");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry20);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						rt.setSrcInfoCd("NW");
						rt.setN1stCmncAmdtSeq(strAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
	
					// Amount > Dry 40' Insert
					if (strRateDry40 != null && !"".equals(strRateDry40) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(strPropNo);
						rt.setAmdtSeq(strAmdtSeq);
						rt.setSvcScpCd(strSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D4");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						rt.setSrcInfoCd("NW");
						rt.setN1stCmncAmdtSeq(strAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
	
					// Amount > Dry 40HC Insert
					if (strRateDry40hc != null && !"".equals(strRateDry40hc) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(strPropNo);
						rt.setAmdtSeq(strAmdtSeq);
						rt.setSvcScpCd(strSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D5");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40hc);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						rt.setSrcInfoCd("NW");
						rt.setN1stCmncAmdtSeq(strAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
		
					// APP Conversion
					if (strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) && "OFT".equals(strChgRuleDefCd)) {
						// 화면의 [APP] 항목 하위의 4개 중에 값이 하나도 없으면 APP Charge를 생성하지 않는다.
						if(!strAppBkgDirCallFlg.equals("") || !strAppBkgTsPortDefCd.equals("") || !strAppBkgSlanCd.equals("") || !strAppBkgVvdCd.equals("")) {
							nextNoteConvSeq++;
							
							PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
							
							noteConv.setNoteConvMapgId(strNoteConvMapgId);
							noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
							noteConv.setNoteConvTpCd(strNoteConvTpCd);
							noteConv.setPropNo(strPropNo);
							noteConv.setAmdtSeq(strAmdtSeq);
							noteConv.setSvcScpCd(strSvcScpCd);
							noteConv.setChgRuleTpCd(strChgRuleTpCd);
							noteConv.setNoteConvChgCd(strNoteConvChgCd);
							noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
							noteConv.setEffDt(strEffDt);
							noteConv.setExpDt(strExpDt);
							noteConv.setRtApplTpCd(strRtApplTpCd);
							noteConv.setCurrCd("");
							noteConv.setFrtRtAmt("");
							noteConv.setPayTermCd("");
							noteConv.setBkgRatUtCd("");
							noteConv.setBkgPrcCgoTpCd("");
							noteConv.setBkgSlanCd(strAppBkgSlanCd);
							noteConv.setBkgVslCd(strAppBkgVslCd);
							noteConv.setBkgSkdVoyNo(strAppBkgSkdVoyNo);
							noteConv.setBkgSkdDirCd(strAppBkgSkdDirCd);
							noteConv.setBkgMinCgoWgt("");
							noteConv.setBkgMaxCgoWgt("");
							noteConv.setBkgTsPortTpCd(strAppBkgTsPortTpCd);
							noteConv.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
							noteConv.setBkgDirCallFlg(strAppBkgDirCallFlg);
							noteConv.setBkgYdCd("");
							noteConv.setSrcInfoCd("NW");
							noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
							noteConv.setCreUsrId(strCreUsrId);
							noteConv.setUpdUsrId(strUpdUsrId);
							
							noteConvVoList.add(noteConv);
						}
				    }
					
					// D2 Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strRateDry20 != null && !"".equals(strRateDry20) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry20);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D2");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    // D4 Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strRateDry40 != null && !"".equals(strRateDry40) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D4");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // D5 Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strRateDry40hc != null && !"".equals(strRateDry40hc) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40hc);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D5");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // BL Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strBkgRatUtCdBl != null && !"".equals(strBkgRatUtCdBl) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBl);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BL");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // CM Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strBkgRatUtCdCm != null && !"".equals(strBkgRatUtCdCm) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdCm);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("CM");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // BX Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strBkgRatUtCdBx != null && !"".equals(strBkgRatUtCdBx) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBx);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BX");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    // Include or Subject Conversion
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& "".equals(strRateDry20) && "".equals(strRateDry40)
				    	&& "".equals(strRateDry40hc) && "".equals(strBkgRatUtCdBl)
						&& "".equals(strBkgRatUtCdCm) && "".equals(strBkgRatUtCdBx)
						&& !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd("");
				    	noteConv.setFrtRtAmt("");
				    	noteConv.setPayTermCd("");
				    	noteConv.setBkgRatUtCd("");
				    	noteConv.setBkgPrcCgoTpCd("");
				    	noteConv.setBkgSlanCd(strAppBkgSlanCd);
				    	noteConv.setBkgVslCd(strAppBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strAppBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strAppBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strAppBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strAppBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }				    
			    } else {	// Update			    	
			    	if (strOrgPntCd != null && !"".equals(strOrgPntCd)
						&& strDestPntCd != null && !"".equals(strDestPntCd)
						&& strChgRuleDefCd != null && !"".equals(strChgRuleDefCd)
						&& strRtApplTpCd != null && !"".equals(strRtApplTpCd)) {
					    
						nextRoutPntSeq = 1;
						nextRoutViaSeq = 1;
						nextRtSeq = 0;
						nextNoteConvSeq = 1;
						nextRoutNoteSeq = 1;
						
						PriRpScpRtCmdtRnoteVO rNote = new PriRpScpRtCmdtRnoteVO();
						rNote.setPropNo(updateStrPropNo);
						rNote.setAmdtSeq(updateStrAmdtSeq);
						rNote.setSvcScpCd(updateStrSvcScpCd);
						rNote.setRoutSeq(String.valueOf(updateNextRoutSeq));
						
						// 기존 Mapping ID
						preNoteConvMapgId = dbDao.searchMstRateCommodityRnoteMapgId(rNote);

						// APP를 제외한 나머지 Conversion 삭제 (Amend 처리가 힘드니 삭제하고 Insert 하기로 협의)
						if (preNoteConvMapgId != null && !"".equals(preNoteConvMapgId)) {
							PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
							
							noteConv.setNoteConvMapgId(preNoteConvMapgId);
							noteConv.setPropNo(strPropNo);
							noteConv.setAmdtSeq(strAmdtSeq);
							noteConv.setSvcScpCd(strSvcScpCd);
							
							// Note Conversion Delete
							dbDao.removeMstNoteConversion(noteConv);
						}		
					}
					
					// Rate Dry 20' Update
					if (strRateDry20 != null && !"".equals(strRateDry20) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(updateStrPropNo);
						rt.setAmdtSeq(updateStrAmdtSeq);
						rt.setSvcScpCd(updateStrSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(updateNextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(updateNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D2");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry20);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						if(updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq) && strSrcInfoCd.equals("AM")) {
							rt.setSrcInfoCd("AM");
						} else if( !updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq)) {
							rt.setSrcInfoCd("AM");
						} else {
							rt.setSrcInfoCd("NW");
						}
						rt.setN1stCmncAmdtSeq(updateStrAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
						rtVoList.add(rt);
					}
	
					// Rate Dry 40' Update
					if (strRateDry40 != null && !"".equals(strRateDry40) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(updateStrPropNo);
						rt.setAmdtSeq(updateStrAmdtSeq);
						rt.setSvcScpCd(updateStrSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(updateNextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(updateNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D4");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						if(updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq) && strSrcInfoCd.equals("AM")) {
							rt.setSrcInfoCd("AM");
						} else if( !updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq)) {
							rt.setSrcInfoCd("AM");
						} else {
							rt.setSrcInfoCd("NW");
						}
						rt.setN1stCmncAmdtSeq(updateStrAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
	
					// Rate Dry 40' Update
					if (strRateDry40hc != null && !"".equals(strRateDry40hc) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(updateStrPropNo);
						rt.setAmdtSeq(updateStrAmdtSeq);
						rt.setSvcScpCd(updateStrSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(updateNextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(updateNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D5");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40hc);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						if(updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq) && strSrcInfoCd.equals("AM")) {
							rt.setSrcInfoCd("AM");
						} else if( !updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq)) {
							rt.setSrcInfoCd("AM");
						} else {
							rt.setSrcInfoCd("NW");
						}
						rt.setN1stCmncAmdtSeq(updateStrAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
					
					// D2 Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strRateDry20 != null && !"".equals(strRateDry20) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry20);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D2");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    // D4 Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strRateDry40 != null && !"".equals(strRateDry40) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D4");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // D5 Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strRateDry40hc != null && !"".equals(strRateDry40hc) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40hc);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D5");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // BL Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strBkgRatUtCdBl != null && !"".equals(strBkgRatUtCdBl) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBl);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BL");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // CM Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strBkgRatUtCdCm != null && !"".equals(strBkgRatUtCdCm) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdCm);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("CM");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    // BX Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strBkgRatUtCdBx != null && !"".equals(strBkgRatUtCdBx) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBx);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BX");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    // Include & Subject
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& "".equals(strRateDry20) && "".equals(strRateDry40)
				    	&& "".equals(strRateDry40hc) && "".equals(strBkgRatUtCdBl)
						&& "".equals(strBkgRatUtCdCm) && "".equals(strBkgRatUtCdBx)
						&& !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd("");
				    	noteConv.setFrtRtAmt("");
				    	noteConv.setPayTermCd("");
				    	noteConv.setBkgRatUtCd("");
				    	noteConv.setBkgPrcCgoTpCd("");
				    	noteConv.setBkgSlanCd(strAppBkgSlanCd);
				    	noteConv.setBkgVslCd(strAppBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strAppBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strAppBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt("");
				    	noteConv.setBkgMaxCgoWgt("");
				    	noteConv.setBkgTsPortTpCd(strAppBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strAppBkgDirCallFlg);
				    	noteConv.setBkgYdCd("");
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }			    	
//				    routMaxSeqDiv = false;
			    }			    
			}			
			
			// Route
			if (routVoList.size() > 0) {
				dbDao.addMstRateCommodityRoute(routVoList);
			}
			
			// Route Point
			if (pntVoList.size() > 0) {
				dbDao.addMstRateRoutePoint(pntVoList);
			}
			
			// Route Via
			if (viaVoList.size() > 0) {
				dbDao.addMstRateRouteVia(viaVoList);
			}

			// Rate
			if (rtVoList.size() > 0) {
				dbDao.addMstRate(rtVoList);
			}
			
			// Surcharge
			if (scgVoList.size() > 0) {
				dbDao.addMstRateSurcharge(scgVoList);
			}
			
			// Conversion
			if (noteConvVoList.size() > 0) {
				dbDao.addMstNoteConversion(noteConvVoList);
			}

			// Rnote
			if (rNoteVoList.size() > 0) {
				dbDao.addMstRateCommodityRnote(rNoteVoList);
			}
			
			// 수정된 내용을 Summary 테이블에 반영한다.
			RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
			
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(strPropNo);
			smryVO.setAmdtSeq(strAmdtSeq);
			smryVO.setSvcScpCd(strSvcScpCd);
			smryVO.setPropScpTermTpCd("71");
			cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
