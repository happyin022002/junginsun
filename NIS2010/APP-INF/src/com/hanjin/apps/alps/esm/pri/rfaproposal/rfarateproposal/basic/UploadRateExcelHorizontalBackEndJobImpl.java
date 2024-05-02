/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UploadRateExcelHorizontalBackEndJobImpl.java
*@FileTitle : UploadRateExcelHorizontalBackEndJobImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.29 박성수
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration.RFARateProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;

/**
 * RFA Rate Excel Upload 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sungsoo, Park
 * @see RFARateProposalDBDAO
 * @since J2EE 1.6
 */
public class UploadRateExcelHorizontalBackEndJobImpl extends BackEndCommandSupport{

	private static final long serialVersionUID = 6097486557477880250L;

	private RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
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
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();
		
		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;
			
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;
			
			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			
			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];
				
				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();
				
				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();
				
				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();
				
				String strBucDry20 = row.getBucDry20();
				String strBucDry40 = row.getBucDry40();
				String strBucDry40hc = row.getBucDry40hc();
				String strBucDry45 = row.getBucDry45();
				String strBucRf40hc = row.getBucRf40hc();
				String strBucRd40hc = row.getBucRd40hc();
				
				String strIfcDry20 = row.getIfcDry20();
				String strIfcDry40 = row.getIfcDry40();
				String strIfcDry40hc = row.getIfcDry40hc();
				String strIfcDry45 = row.getIfcDry45();
				String strIfcRf40hc = row.getIfcRf40hc();
				String strIfcRd40hc = row.getIfcRd40hc();

				String strPscDry20 = row.getPscDry20();
				String strPscDry40 = row.getPscDry40();
				String strPscDry40hc = row.getPscDry40hc();
				String strPscDry45 = row.getPscDry45();
				String strPscRf40hc = row.getPscRf40hc();
				String strPscRd40hc = row.getPscRd40hc();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;
					
					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					
					cmdtHdrVoList.add(cmdtHdr);
				}
				
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					
					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}
					
					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);
					
					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;
					
					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);
					
					custVoList.add(cust);
				}
				
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;
					
					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					
					routVoList.add(rout);
				}
				
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					
					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
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
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
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
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					
					pntVoList.add(pnt);
				}
				
				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
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
					
					if (strBucDry20 != null && !"".equals(strBucDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry20);
						scg.setAdjScgUsdAmt(strBucDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcDry20 != null && !"".equals(strIfcDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry20);
						scg.setAdjScgUsdAmt(strIfcDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscDry20 != null && !"".equals(strPscDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry20);
						scg.setAdjScgUsdAmt(strPscDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}
				
				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
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
					
					if (strBucDry40 != null && !"".equals(strBucDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40);
						scg.setAdjScgUsdAmt(strBucDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcDry40 != null && !"".equals(strIfcDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40);
						scg.setAdjScgUsdAmt(strIfcDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscDry40 != null && !"".equals(strPscDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40);
						scg.setAdjScgUsdAmt(strPscDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}

				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
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
					
					if (strBucDry40hc != null && !"".equals(strBucDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40hc);
						scg.setAdjScgUsdAmt(strBucDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcDry40hc != null && !"".equals(strIfcDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40hc);
						scg.setAdjScgUsdAmt(strIfcDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscDry40hc != null && !"".equals(strPscDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40hc);
						scg.setAdjScgUsdAmt(strPscDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}

				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry45);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					
					rtVoList.add(rt);
					
					if (strBucDry45 != null && !"".equals(strBucDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry45);
						scg.setAdjScgUsdAmt(strBucDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcDry45 != null && !"".equals(strIfcDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry45);
						scg.setAdjScgUsdAmt(strIfcDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscDry45 != null && !"".equals(strPscDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry45);
						scg.setAdjScgUsdAmt(strPscDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}

				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRf40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					
					rtVoList.add(rt);
					
					if (strBucRf40hc != null && !"".equals(strBucRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRf40hc);
						scg.setAdjScgUsdAmt(strBucRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcRf40hc != null && !"".equals(strIfcRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRf40hc);
						scg.setAdjScgUsdAmt(strIfcRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscRf40hc != null && !"".equals(strPscRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRf40hc);
						scg.setAdjScgUsdAmt(strPscRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}

				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRd40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					
					rtVoList.add(rt);
					
					if (strBucRd40hc != null && !"".equals(strBucRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRd40hc);
						scg.setAdjScgUsdAmt(strBucRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcRd40hc != null && !"".equals(strIfcRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRd40hc);
						scg.setAdjScgUsdAmt(strIfcRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscRd40hc != null && !"".equals(strPscRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRd40hc);
						scg.setAdjScgUsdAmt(strPscRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}
			}
			
			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}
			
			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}
			
			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(cmdtHdrVoList.get(0).getPropNo());
            smryVO.setAmdtSeq(cmdtHdrVoList.get(0).getAmdtSeq());
            smryVO.setSvcScpCd(cmdtHdrVoList.get(0).getSvcScpCd());
            smryVO.setPropScpTermTpCd("71");
            // BackEndJob에서 타 BC 호출. 송팀장님 승인 득. 2010-02-08
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
	
}
