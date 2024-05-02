/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandLinkManageBCImpl.java
 *@FileTitle : Inland Link Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration.InlandLinkManageDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_009EventResponse,InlandLinkManageBC
 * @since J2EE 1.4
 */
public class InlandLinkManageBCImpl extends BasicCommandSupport implements InlandLinkManageBC {
	private transient InlandLinkManageDBDAO dbDao = null;

	/**
	 * creating InlandLinkManageBCImpl Object<br>
	 * creating InlandLinkManageDBDAO<br>
	 */
	public InlandLinkManageBCImpl() {
		dbDao = new InlandLinkManageDBDAO();
	}

	/**
	 * retrieving - InlandLinkManage<br>
	 * 
	 * @param vo
	 * @return response ESD_PRD_009EventResponse
	 * @exception EventException
	 */
	public List<PrdInlndEachLnkVO> searchInlandLinkManageList(PrdInlndEachLnkVO vo) throws EventException {
		try {
			return dbDao.searchInlandLinkManageList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving<br>
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandLinkManageListVO> searchInlandLinkManagePopup(SearchInlandLinkManageListVO vo) throws EventException {
		try {
			return dbDao.searchInlandLinkManageList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> multiInlandLinkManage(SearchInlandLinkManageListVO[] vo, SignOnUserAccount account) throws EventException {
		try {
			Map<String, String> retVal = new HashMap<String, String>();
			String pseudoChk = "";
			String pseudoCd = ""; // returning in case of pseudo node
			String blankCd = ""; // returning in case of not existing node
			String invalidVendor = "";

			boolean resultVendorCheck = false;
			boolean resultAgrementCheck = false;
			String ctyCd = "";
			String agmtSeq = "";
			int iAgmtSeq = 0;
			String agmt_no = "";
			String vndSeq = "";
			for (int i = 0; i < vo.length; i++) {
				vo[i].setCreUsrId(account.getUsr_id());
				vo[i].setUpdUsrId(account.getUsr_id());
				vo[i].setCreOfcCd(account.getOfc_cd());
				ctyCd = "";
				agmtSeq = "";
				iAgmtSeq = 0;
				agmt_no = vo[i].getAgmtNo();

				if (agmt_no != null && agmt_no.length() > 4) {
					ctyCd = agmt_no.substring(0, 3);
					agmtSeq = agmt_no.substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
				}

				vo[i].setCtyCd(ctyCd);
				vo[i].setAgmtSeq(agmtSeq);
				vo[i].setIAgmtSeq(iAgmtSeq + "");
				if (vo[i].getIbflag().equals("I")) {
					pseudoChk = dbDao.pseudoTypeFromToCheck(vo[i].getLnkOrgNodCd(), vo[i].getLnkDestNodCd());
					resultVendorCheck = dbDao.validationVendor(vo[i].getVndrSeq(), vo[i].getSkipFlagFunItemControl());
					if (!resultVendorCheck) {
						invalidVendor = invalidVendor + (invalidVendor.length() > 0 ? "," : "") + vo[i].getVndrSeq();
					}
					if (pseudoChk.equals("3")) { // capital - both
						pseudoCd = pseudoCd + (pseudoCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd() + "," + vo[i].getLnkDestNodCd();
						continue;
					} else if (pseudoChk.equals("2")) { // capital - from
						pseudoCd = pseudoCd + (pseudoCd.length() > 0 ? "," : "") + vo[i].getLnkDestNodCd();
						continue;
					} else if (pseudoChk.equals("1")) { // capital - to
						pseudoCd = pseudoCd + (pseudoCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd();
						continue;
					} else if (pseudoChk.equals("4")) { // not existing node of from,to
						blankCd = blankCd + (blankCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd() + "," + vo[i].getLnkDestNodCd();
					} else if (pseudoChk.equals("5")) { // not existing node of from
						blankCd = blankCd + (blankCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd();
						continue;
					} else if (pseudoChk.equals("6")) { // not existing node of from
						blankCd = blankCd + (blankCd.length() > 0 ? "," : "") + vo[i].getLnkDestNodCd();
						continue;
					}
					if (!resultVendorCheck) {
						continue;
					}
					if (iAgmtSeq > 0) {
						vndSeq = vo[i].getVndrSeq();
						if (dbDao.isAgmtNoRight(ctyCd, iAgmtSeq, vndSeq)) {
							resultAgrementCheck = true;
						} else {
							resultAgrementCheck = false;
						}
					} else {
						resultAgrementCheck = true;
					}
					if (!resultAgrementCheck) {
						continue;
					}
					dbDao.mergeInlandLink(vo[i]);
				} else if (vo[i].getIbflag().equals("U")) {
					if (iAgmtSeq > 0) {
						vndSeq = vo[i].getVndrSeq();
						if (dbDao.isAgmtNoRight(ctyCd, iAgmtSeq, vndSeq)) {
							dbDao.updateInlandLink(vo[i]);
							dbDao.updateInlandRoutByLink(vo[i]);
						}
					} else {
						dbDao.updateInlandLink(vo[i]);
						dbDao.updateInlandRoutByLink(vo[i]);
					}
				} else if (vo[i].getIbflag().equals("D")) {
					dbDao.deleteInlandLink(vo[i]);
					dbDao.deleteInlndRoutMst(vo[i].getLnkOrgNodCd(), vo[i].getLnkDestNodCd(), vo[i].getTrspModCd(), account.getUsr_id());
				}
			}
			retVal.put("pseudoCd", pseudoCd);
			retVal.put("blankCd", blankCd);
			retVal.put("invalidVendorCd", invalidVendor);
			return retVal;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<PrdInlndEachLnkVO> multiAgmtNo(PrdInlndEachLnkVO[] vo, SignOnUserAccount account) throws EventException {
		try {
			List<PrdInlndEachLnkVO> prdInlndEachLnkVO = new ArrayList<PrdInlndEachLnkVO>();
			String validAgmtNoRoute = "";
			String validUpdateRoute = "";

			for (int i = 0; i < vo.length; i++) {
				log.debug("★update");
				String ctyCd = "";
				String agmtSeq = "";
				int iAgmtSeq = 0;
				String vndSeq = vo[i].getVndrSeq();
				String agmt_no = vo[i].getAgmtNo();

				if (agmt_no != null && agmt_no.length() > 4) {
					ctyCd = agmt_no.substring(0, 3);
					agmtSeq = agmt_no.substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
				}

				vo[i].setCreUsrId(account.getUsr_id());
				vo[i].setCreOfcCd(account.getOfc_cd());
				vo[i].setUpdUsrId(account.getUsr_id());
				vo[i].setCtyCd(ctyCd);
				vo[i].setIAgmtNo(iAgmtSeq + "");

				if (dbDao.isAgmtNoRight(ctyCd, iAgmtSeq, vndSeq)) {
					int res = dbDao.multiAgmtNo(vo[i]);

					if (res == 0) {
						validUpdateRoute = validUpdateRoute + " ," + vo[i].getLnkOrgNodCd() + " to " + vo[i].getLnkDestNodCd();
						vo[i].setResult("NOT LINK");
					} else {
						vo[i].setResult("OK");
						dbDao.updateInlandRouteAgmtNo(vo[i].getLnkOrgNodCd(), vo[i].getLnkDestNodCd(), vo[i].getTrspModCd(), vo[i].getVndrSeq(), ctyCd, iAgmtSeq);
					}
				} else {
					validAgmtNoRoute = validAgmtNoRoute + " ," + vo[i].getLnkOrgNodCd() + " to " + vo[i].getLnkDestNodCd();
					vo[i].setResult("UNMATCH AGMT_NO");
				}

				if (i == (vo.length - 1)) {
					vo[i].setValidUpdateRoute(validUpdateRoute);
					vo[i].setValidAgmtNoRoute(validAgmtNoRoute);
				}

				prdInlndEachLnkVO.add(vo[i]);
			}
			return prdInlndEachLnkVO;

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
