/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : UploadRateExcelVerticalForAeeAewBackEndJobImpl.java
 *@FileTitle : UploadRateExcelVerticalForAeeAewBackEndJobImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.27
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration.RFARateProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAeeAewVO;
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
 * @author Eunsup, Lee
 * @see RFARateProposalDBDAO
 * @since J2EE 1.6
 */
public class UploadRateExcelVerticalForAeeAewBackEndJobImpl extends BackEndCommandSupport {

	private static final long serialVersionUID = 6097486557477880250L;

	private RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
	private RFARateProposalDBDAO dbDao = new RFARateProposalDBDAO();

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO;
	private RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs;
	private SignOnUserAccount account;

	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	public RsltRtListVerticalExcelForAeeAewVO[] getRsltRtListVerticalExcelForAeeAewVOs() {
		RsltRtListVerticalExcelForAeeAewVO[] rtnVOs = null;
		if (this.rsltRtListVerticalExcelForAeeAewVOs != null) {
			rtnVOs = new RsltRtListVerticalExcelForAeeAewVO[rsltRtListVerticalExcelForAeeAewVOs.length];
			System.arraycopy(rsltRtListVerticalExcelForAeeAewVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltRtListVerticalExcelForAeeAewVOs(RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs){
		if(rsltRtListVerticalExcelForAeeAewVOs != null){
			RsltRtListVerticalExcelForAeeAewVO[] tmpVOs = new RsltRtListVerticalExcelForAeeAewVO[rsltRtListVerticalExcelForAeeAewVOs.length];
			System.arraycopy(rsltRtListVerticalExcelForAeeAewVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListVerticalExcelForAeeAewVOs = tmpVOs;
		}
	}

	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * RFA Rate Vertical Excel Updoad Transaction을 처리한다.<br>
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

			for (int i = 0; i < rsltRtListVerticalExcelForAeeAewVOs.length; i++) {
				RsltRtListVerticalExcelForAeeAewVO row = rsltRtListVerticalExcelForAeeAewVOs[i];

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

				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strCurrCd = row.getCurrCd();
				String strRateAmt = row.getPropFrtRtAmt();

				String strBucAmt = row.getBucUsdAmt();
				String strIfcAmt = row.getIfcUsdAmt();
				String strPscAmt = row.getPscUsdAmt();

				// IHC Amount
				String strFicPropRtAmt = row.getFicPropRtAmt();
				// FIC_GLINE_RT_AMT
				String strFicGlineRtAmt = row.getFicGlineRtAmt();

				String strOptmTrspModFlg = row.getOptmTrspModFlg();
				String strFicRtUseStsCd = row.getFicRtUseStsCd();
				String strBasePortLocCd = row.getBsePortLocCd();
				String strFicRoutCmbTpCd = row.getFicRoutCmbTpCd();

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

					/**
					 * TODO 9011648 <BR>
					 * 2012.06.15일 추가
					 */
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());

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

					if ("AEE".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					}
					if (!dupChk) {
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
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					if ("AEW".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					}

					if (!dupChk) {
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
					// 추가
					if ("AEW".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}
					pntVoList.add(pnt);
				}

				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
					rt.setCurrCd(strCurrCd);
					rt.setPropFrtRtAmt(strRateAmt);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strFicPropRtAmt);
					rt.setFicGlineRtAmt(strFicGlineRtAmt);
					rt.setOptmTrspModFlg(strOptmTrspModFlg);
					rt.setFicRtUseStsCd(strFicRtUseStsCd);

					rtVoList.add(rt);

					if (strBucAmt != null && !"".equals(strBucAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucAmt);
						scg.setAdjScgUsdAmt(strBucAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcAmt != null && !"".equals(strIfcAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcAmt);
						scg.setAdjScgUsdAmt(strIfcAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscAmt != null && !"".equals(strPscAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscAmt);
						scg.setAdjScgUsdAmt(strPscAmt);
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
			if ("A".equals(priRpScpRtCmdtHdrVO.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			// BackEndJob에서 타 BC 호출. 송팀장님 승인 득. 2010-02-08
			cmdMain.manageScopeAmendmentSummary(smryVO, account);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * Route Via 중복 체크
	 * 
	 * @param vias
	 * @param strPropNo
	 * @param strAmdtSeq
	 * @param strSvcScpCd
	 * @param nextCmdtHdrSeq
	 * @param nextRoutSeq
	 * @param strViaCd
	 * @return
	 */
	private boolean duplicateRouteVia(List<PriRpScpRtRoutViaVO> vias, String strPropNo, String strAmdtSeq, String strSvcScpCd, int nextCmdtHdrSeq, int nextRoutSeq,
			String strViaCd) {
		for (int i = 0; i < vias.size(); i++) {
			CompareToBuilder builder = new CompareToBuilder();
			builder.append(vias.get(i).getPropNo(), strPropNo);
			builder.append(vias.get(i).getAmdtSeq(), strAmdtSeq);
			builder.append(vias.get(i).getSvcScpCd(), strSvcScpCd);
			builder.append(vias.get(i).getCmdtHdrSeq(), String.valueOf(nextCmdtHdrSeq));
			builder.append(vias.get(i).getRoutSeq(), String.valueOf(nextRoutSeq));
			builder.append(vias.get(i).getRoutViaPortDefCd(), strViaCd);
			if (builder.toComparison() == 0) {
				return true;
			}
		}
		return false;
	}
}
