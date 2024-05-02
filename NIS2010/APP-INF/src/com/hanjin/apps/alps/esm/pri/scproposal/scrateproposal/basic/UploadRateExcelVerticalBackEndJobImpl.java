/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UploadRateExcelVerticalBackEndJobImpl.java
*@FileTitle : UploadRateExcelVerticalBackEndJobImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.29 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration.SCRateProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;

/**
 * S/C Rate Excel Upload 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sungsoo, Park
 * @see SCRateProposalDBDAO
 * @since J2EE 1.6
 */
public class UploadRateExcelVerticalBackEndJobImpl extends BackEndCommandSupport{

	private static final long serialVersionUID = 6097486557477880250L;

	private SCProposalMainBC cmdMain = new SCProposalMainBCImpl();
	private SCRateProposalDBDAO dbDao = new SCRateProposalDBDAO();
	
	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO;
	private RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs;
	private SignOnUserAccount account;

	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO() {
		return priSpScpRtCmdtHdrVO;
	}

	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

	public RsltRtListVerticalExcelVO[] getRsltRtListVerticalExcelVOs() {
		return rsltRtListVerticalExcelVOs;
	}

	public void setRsltRtListVerticalExcelVOs(RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) {
		this.rsltRtListVerticalExcelVOs = rsltRtListVerticalExcelVOs;
	}

	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * S/C Rate Vertical Excel Updoad Transaction을 처리한다.<br>
	 *  
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")	
	public List doStart() throws Exception {
		List<PriSpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
		List<PriSpScpRtCmdtVO> cmdtVoList = new ArrayList<PriSpScpRtCmdtVO>();
		List<PriSpScpRtActCustVO> custVoList = new ArrayList<PriSpScpRtActCustVO>();
		List<PriSpScpRtCmdtRoutVO> routVoList = new ArrayList<PriSpScpRtCmdtRoutVO>();
		List<PriSpScpRtRoutPntVO> pntVoList = new ArrayList<PriSpScpRtRoutPntVO>();
		List<PriSpScpRtRoutViaVO> viaVoList = new ArrayList<PriSpScpRtRoutViaVO>();
		List<PriSpScpRtRoutDirVO> dcallVoList = new ArrayList<PriSpScpRtRoutDirVO>();
		List<PriSpScpRtVO> rtVoList = new ArrayList<PriSpScpRtVO>();
		List<PriSpScpRtScgVO> scgVoList = new ArrayList<PriSpScpRtScgVO>();
		
		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priSpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priSpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;
			
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;
			
			String strPropNo = priSpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priSpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priSpScpRtCmdtHdrVO.getSvcScpCd();
			String strGenSpclRtTpCd = priSpScpRtCmdtHdrVO.getGenSpclRtTpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];
				
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
				String strDirCall = (row.getDirCallFlg() == null || "".equals(row.getDirCallFlg())) ? "N" : row.getDirCallFlg();
				
				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strRateAmt = row.getPropFrtRtAmt();
				
				String strBucAmt = row.getBucUsdAmt();
				String strIfcAmt = row.getIfcUsdAmt();
				String strPscAmt = row.getPscUsdAmt();
				
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;
					
					PriSpScpRtCmdtHdrVO cmdtHdr = new PriSpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setGenSpclRtTpCd(strGenSpclRtTpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					
					cmdtHdrVoList.add(cmdtHdr);
				}
				
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					
					String cmdtTpCd = strCmdtCd.length() == 5 ? "G" : "C";
					
					PriSpScpRtCmdtVO cmdt = new PriSpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
					
					PriSpScpRtActCustVO cust = new PriSpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
					
					PriSpScpRtCmdtRoutVO rout = new PriSpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setGenSpclRtTpCd(strGenSpclRtTpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					
					routVoList.add(rout);
					
					PriSpScpRtRoutDirVO dir = new PriSpScpRtRoutDirVO();
					dir.setPropNo(strPropNo);
					dir.setAmdtSeq(strAmdtSeq);
					dir.setSvcScpCd(strSvcScpCd);
					dir.setGenSpclRtTpCd(strGenSpclRtTpCd);
					dir.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					dir.setRoutSeq(String.valueOf(nextRoutSeq));
					dir.setDirCallFlg(strDirCall);
					dir.setPrcProgStsCd("I");
					dir.setSrcInfoCd("NW");
					dir.setN1stCmncAmdtSeq(strAmdtSeq);
					dir.setCreUsrId(strCreUsrId);
					dir.setUpdUsrId(strUpdUsrId);
					
					dcallVoList.add(dir);
				}
				
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
					
					PriSpScpRtRoutPntVO pnt = new PriSpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
					
					PriSpScpRtRoutViaVO via = new PriSpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
					
					PriSpScpRtRoutViaVO via = new PriSpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
					
					PriSpScpRtRoutPntVO pnt = new PriSpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;
					
					PriSpScpRtVO rt = new PriSpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateAmt);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					
					rtVoList.add(rt);
					
					if (strBucAmt != null && !"".equals(strBucAmt)) {
						PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
						PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
						PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
			if (dcallVoList.size() > 0) {
				dbDao.addRateRouteDirectCall(dcallVoList);
			}
			
			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}
			
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (cmdtHdrVoList.get(0).getGenSpclRtTpCd().equals("G")) {
            	sTermTpCd = "71";
            } else if (cmdtHdrVoList.get(0).getGenSpclRtTpCd().equals("S")) {
            	sTermTpCd = "72";
            }
            smryVO.setPropNo(cmdtHdrVoList.get(0).getPropNo());
            smryVO.setAmdtSeq(cmdtHdrVoList.get(0).getAmdtSeq());
            smryVO.setSvcScpCd(cmdtHdrVoList.get(0).getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
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
