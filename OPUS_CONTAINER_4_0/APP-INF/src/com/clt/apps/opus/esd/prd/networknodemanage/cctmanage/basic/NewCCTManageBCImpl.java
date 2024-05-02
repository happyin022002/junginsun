/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NewCCTManageBCImpl.java
 *@FileTitle : New CCT Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.basic;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event.EsdPrd0039Event;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration.NewCCTManageDBDAO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration.NewCctVgmHisManageDBDAO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.PrdCstSkdByPortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.PrdTmlVgmCctHisVO;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author Jeongseon An
 * @see ESD_PRD_0036EventResponse,CCTmanageBC
 * @since J2EE 1.4
 */
public class NewCCTManageBCImpl extends BasicCommandSupport implements NewCCTManageBC {
	private transient NewCCTManageDBDAO dbDao = null;
	private transient NewCctVgmHisManageDBDAO vgmDbDao = null;

	/**
	 * creating CCTmanageBCImpl<br>
	 * creating CCTmanageDBDAO<br>
	 */
	public NewCCTManageBCImpl() {
		dbDao = new NewCCTManageDBDAO();
		vgmDbDao = new NewCctVgmHisManageDBDAO();
	}

	/**
	 * retrieving - CCTmanage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchCCTManage(NewCCTManageVO vo) throws EventException {
		try {
			return dbDao.searchCCTManage(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * multi event - ESD_PRD_036
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiCCTManage(NewCCTManageVO[] vos, SignOnUserAccount account) throws EventException {
		DBRowSet dbR = null;
		try {
			boolean bInsertFlg = false;
			for (int i = 0; i < vos.length; i++) {
				vos[i].setUserId(account.getUsr_id());
				bInsertFlg = vos[i].getIbflag().equals("I");

				if (bInsertFlg) {
					dbR = dbDao.checkCct(vos[i]);
					if (dbR.getRowCount() > 0) {
						throw new EventException(new ErrorHandler(vos[i].getYardCode() + ", " + vos[i].getLaneCode() + ", Cargo:" + (vos[i].getCargoType().equals("AL") ? "All" : vos[i].getCargoType()) + " is already registerd. Please check again.").getMessage());
					}
				}
				addPrdTmlVgmCctHisByPrd(vos[i], true, bInsertFlg);
				addPrdTmlVgmCctHisByPrd(vos[i], false, bInsertFlg);
				dbDao.updateMultiCCTManage(vos[i]);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param prdCstSkdByPortVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchCstSkdByPort(PrdCstSkdByPortVO prdCstSkdByPortVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPort(prdCstSkdByPortVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage());
		}
	}

	/**
	 * multi event - ESD_PRD_0036
	 * 
	 * @param prdCstSkdByPortVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiVslCgoClzDate(PrdCstSkdByPortVO[] prdCstSkdByPortVOs, SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < prdCstSkdByPortVOs.length; i++) {
				if (CheckUtilities.isInBlank(prdCstSkdByPortVOs[i].getCgoClzDt())) {
					prdCstSkdByPortVOs[i].setCgoClzDtHhmi("");
				} else {
					prdCstSkdByPortVOs[i].setCgoClzDt(prdCstSkdByPortVOs[i].getCgoClzDt().replaceAll("-", "") + prdCstSkdByPortVOs[i].getCgoClzDtHhmi().replaceAll(":", ""));
				}

				if (CheckUtilities.isInBlank(prdCstSkdByPortVOs[i].getDcgoClzDt())) {
					prdCstSkdByPortVOs[i].setDcgoClzDtHhmi("");
				} else {
					prdCstSkdByPortVOs[i].setDcgoClzDt(prdCstSkdByPortVOs[i].getDcgoClzDt().replaceAll("-", "") + prdCstSkdByPortVOs[i].getDcgoClzDtHhmi().replaceAll(":", ""));
				}

				if (CheckUtilities.isInBlank(prdCstSkdByPortVOs[i].getRcClzDt())) {
					prdCstSkdByPortVOs[i].setRcClzDtHhmi("");
				} else {
					prdCstSkdByPortVOs[i].setRcClzDt(prdCstSkdByPortVOs[i].getRcClzDt().replaceAll("-", "") + prdCstSkdByPortVOs[i].getRcClzDtHhmi().replaceAll(":", ""));
				}

				if (CheckUtilities.isInBlank(prdCstSkdByPortVOs[i].getAwkCgoClzDt())) {
					prdCstSkdByPortVOs[i].setAwkCgoClzDtHhmi("");
				} else {
					prdCstSkdByPortVOs[i].setAwkCgoClzDt(prdCstSkdByPortVOs[i].getAwkCgoClzDt().replaceAll("-", "") + prdCstSkdByPortVOs[i].getAwkCgoClzDtHhmi().replaceAll(":", ""));
				}
				if (CheckUtilities.isInBlank(prdCstSkdByPortVOs[i].getBbCgoClzDt())) {
					prdCstSkdByPortVOs[i].setBbCgoClzDtHhmi("");
				} else {
					prdCstSkdByPortVOs[i].setBbCgoClzDt(prdCstSkdByPortVOs[i].getBbCgoClzDt().replaceAll("-", "") + prdCstSkdByPortVOs[i].getBbCgoClzDtHhmi().replaceAll(":", ""));
				}

				if (CheckUtilities.isInBlank(prdCstSkdByPortVOs[i].getVgmClzDt())) {
					prdCstSkdByPortVOs[i].setVgmClzDtHhmi("");
				} else {
					prdCstSkdByPortVOs[i].setVgmClzDt(prdCstSkdByPortVOs[i].getVgmClzDt().replaceAll("-", "") + prdCstSkdByPortVOs[i].getVgmClzDtHhmi().replaceAll(":", ""));
				}

				addPrdTmlVgmCctHisByVsl(prdCstSkdByPortVOs[i], true, account);
				addPrdTmlVgmCctHisByVsl(prdCstSkdByPortVOs[i], false, account);
				dbDao.multiVslCgoClzDate(prdCstSkdByPortVOs[i]);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param vo
	 * @param VgmFlg
	 * @throws EventException
	 */
	private void addPrdTmlVgmCctHisByPrd(NewCCTManageVO vo, boolean VgmFlg, boolean bInsertFlg) throws EventException {
		PrdTmlVgmCctHisVO prdTmlVgmCctHisVO = new PrdTmlVgmCctHisVO();
		prdTmlVgmCctHisVO.setPctlUseFlg("Y");
		prdTmlVgmCctHisVO.setYdCd(vo.getYardCode());
		prdTmlVgmCctHisVO.setVslSlanCd(vo.getLaneCode());
		prdTmlVgmCctHisVO.setVslSlanDirCd(vo.getLaneDirCode());
		prdTmlVgmCctHisVO.setCgoTpCd(vo.getCargoType());
		prdTmlVgmCctHisVO.setCreUsrId(vo.getUserId());
		prdTmlVgmCctHisVO.setUpdUsrId(vo.getUserId());
		if (vo.getIbflag().equals("D")) {
			prdTmlVgmCctHisVO.setDeltFlg("Y");
		} else {
			prdTmlVgmCctHisVO.setDeltFlg("N");
		}
		if (VgmFlg) {
			prdTmlVgmCctHisVO.setVgmFlg("Y");
			prdTmlVgmCctHisVO.setCctTpCd(vo.getVgmClzTpCd());
			prdTmlVgmCctHisVO.setCctHr(StringUtils.leftPad(vo.getVgmClzHr(), 2, '0'));
			prdTmlVgmCctHisVO.setCctDyCd(vo.getVgmClzDyCd());
			prdTmlVgmCctHisVO.setCctHrmnt(vo.getVgmClzHrmnt());
			prdTmlVgmCctHisVO.setCctFileFlg(vo.getVgmClzFileFlg());
			prdTmlVgmCctHisVO.setYdBseCalcFlg(vo.getVgmYdBseCalcFlg());
			prdTmlVgmCctHisVO.setXcldHolFriFlg(vo.getVgmXcldHolFriFlg());
			prdTmlVgmCctHisVO.setXcldHolSatFlg(vo.getVgmXcldHolSatFlg());
			prdTmlVgmCctHisVO.setXcldHolSunFlg(vo.getVgmXcldHolSunFlg());
			prdTmlVgmCctHisVO.setXcldHolHolFlg(vo.getVgmXcldHolHolFlg());
		} else {
			prdTmlVgmCctHisVO.setVgmFlg("N");
			prdTmlVgmCctHisVO.setCctTpCd(vo.getCctType());
			prdTmlVgmCctHisVO.setCctHr(StringUtils.leftPad(vo.getCctHour(), 2, '0'));
			prdTmlVgmCctHisVO.setCctDyCd(vo.getCctDay());
			prdTmlVgmCctHisVO.setCctHrmnt(vo.getCctTime());

			prdTmlVgmCctHisVO.setCctFileFlg(vo.getCctFileFlg());
			prdTmlVgmCctHisVO.setYdBseCalcFlg(vo.getYdBseCalcFlg());
			prdTmlVgmCctHisVO.setXcldHolFriFlg(vo.getFriFlag());
			prdTmlVgmCctHisVO.setXcldHolSatFlg(vo.getSatFlag());
			prdTmlVgmCctHisVO.setXcldHolSunFlg(vo.getSunFlag());
			prdTmlVgmCctHisVO.setXcldHolHolFlg(vo.getHoliFlag());
		}
		try {
			if (bInsertFlg) {
				vgmDbDao.addPrdTmlVgmCctHisByPrdNewData(prdTmlVgmCctHisVO);
			} else {
				vgmDbDao.addPrdTmlVgmCctHis(prdTmlVgmCctHisVO);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param vo
	 * @param VgmFlg
	 * @param account
	 * @throws EventException
	 */
	private void addPrdTmlVgmCctHisByVsl(PrdCstSkdByPortVO vo, boolean VgmFlg, SignOnUserAccount account) throws EventException {
		PrdTmlVgmCctHisVO prdTmlVgmCctHisVO = new PrdTmlVgmCctHisVO();
		prdTmlVgmCctHisVO.setPctlUseFlg("N");
		prdTmlVgmCctHisVO.setVvdCd(vo.getVvd());
		prdTmlVgmCctHisVO.setYdCd(vo.getVpsPortCd());
		prdTmlVgmCctHisVO.setVpsPortCd(vo.getVpsPortCd());
		prdTmlVgmCctHisVO.setClptIndSeq(vo.getClptIndSeq());
		prdTmlVgmCctHisVO.setVslSlanCd(vo.getVslSlanCd());
		prdTmlVgmCctHisVO.setCreUsrId(account.getUsr_id());
		prdTmlVgmCctHisVO.setUpdUsrId(account.getUsr_id());

		prdTmlVgmCctHisVO.setDeltFlg("N");
		if (VgmFlg) {
			prdTmlVgmCctHisVO.setVgmFlg("Y");
			prdTmlVgmCctHisVO.setVgmClzDt(vo.getVgmClzDt());
		} else {
			prdTmlVgmCctHisVO.setVgmFlg("N");
			prdTmlVgmCctHisVO.setCgoClzDt(vo.getCgoClzDt());
			prdTmlVgmCctHisVO.setDcgoClzDt(vo.getDcgoClzDt());
			prdTmlVgmCctHisVO.setRcClzDt(vo.getRcClzDt());
			prdTmlVgmCctHisVO.setAwkCgoClzDt(vo.getAwkCgoClzDt());
			prdTmlVgmCctHisVO.setBbCgoClzDt(vo.getBbCgoClzDt());
		}
		try {
			vgmDbDao.addPrdTmlVgmCctHis(prdTmlVgmCctHisVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<PrdTmlVgmCctHisVO> searchPrdTmlVgmCctHis(EsdPrd0039Event event) throws EventException {
		try {
			return vgmDbDao.searchPrdTmlVgmCctHis(event.getPrdTmlVgmCctHisVO());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage());
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
