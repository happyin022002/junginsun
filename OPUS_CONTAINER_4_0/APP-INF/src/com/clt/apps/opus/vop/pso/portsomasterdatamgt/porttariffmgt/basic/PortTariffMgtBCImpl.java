/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PortTariffMgtBCImpl.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration.PortTariffMgtDBDAO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CondtionOpertionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CostCodeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.EffectiveDateListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PsoBasicFomlDtlVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PsoBasicFormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListWithYdNmVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.clt.apps.opus.vop.pso.psocommonutil.PsoConstants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.PsoChgXprDtlVO;
import com.clt.syscommon.common.table.PsoChgXprVO;
import com.clt.syscommon.common.table.PsoCondDtlVO;
import com.clt.syscommon.common.table.PsoConditionVO;
import com.clt.syscommon.common.table.PsoFormulaVO;
import com.clt.syscommon.common.table.PsoTariffVO;
import com.clt.syscommon.common.table.PsoTrfDtlVO;
import com.clt.syscommon.common.table.PsoYdChgObjListVO;
import com.clt.syscommon.common.table.PsoYdChgVO;
import com.clt.syscommon.common.table.PsoYdChgXprVO;

/**
 * NIS2010-portsomasterdatamgt Business Logic Basic Command implementation<br>
 * - Handling business logic of portsomasterdatamgt<br>
 *
 * @author
 * @see Reference each DAO class of UI_PSO-0205EventResponse,porttariffmgtBC
 * @since J2EE 1.4
 */

public class PortTariffMgtBCImpl extends BasicCommandSupport implements PortTariffMgtBC {

	// Database Access Object
	private transient PortTariffMgtDBDAO dbDao = null;

	/**
	 * Creating object porttariffmgtBCImpl <br>
	 * Creating porttariffmgtDBDAO<br>
	 */
	public PortTariffMgtBCImpl() {
		dbDao = new PortTariffMgtDBDAO();
	}

	/**
	 * Retrieve vendor Info by office CD of User Of SSO
	 * 
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchOfficeVendor(VendorVO vendorVO) throws EventException {
		
		try {
			return dbDao.searchOfficeVendor(vendorVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Vendors" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Vendors" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve and,or operator of condition
	 * 
	 * @return List<CondtionOpertionGRPVO>
	 * @throws DAOException
	 */
	public List<CondtionOpertionVO> searchConditonAndOrOperator() throws EventException {
		
		try {
			return dbDao.searchConditonAndOrOperator();
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Operators" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Operators" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve comparing operator of condition
	 * 
	 * @return List<CondtionOpertionGRPVO>
	 * @throws DAOException
	 */
	public List<CondtionOpertionVO> searchConditionCompairingOperator() throws EventException {
		
		try {
			return dbDao.searchConditionCompairingOperator();
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Operators" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Operators" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Cost Code set by office of login user
	 * 
	 * @param ofcCd
	 * @return List<CostCodeVO>
	 * @throws DAOException
	 */
	public List<CostCodeVO> searchCostCodeList(String ofcCd) throws EventException {
		
		try {
			return dbDao.searchCostCodeList(ofcCd);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Cost" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Cost" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve currency info set by office of login user
	 * 
	 * @param ofcCd
	 * @return List<CurrencyVO>
	 * @throws DAOException
	 */
	public List<CurrencyVO> searchCurrencyList(String ofcCd) throws EventException {
		
		try {
			return dbDao.searchCurrencyList(ofcCd);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Currency" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Currency" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object List
	 * 
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	public List<PsoObjListVO> searchObjectListA() throws EventException {
		try {
			return dbDao.searchObjectListA();
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object List
	 * 
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	public List<PsoObjListVO> searchObjectListAll() throws EventException {
		try {
			return dbDao.searchObjectListAll();
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object List set by office of login user
	 * 
	 * @param String psoOfcCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	public List<PsoObjListVO> searchOfficeObjectList1(String psoOfcCd, String types) throws EventException {
		
		try {
			return dbDao.searchOfficeObjectList1(psoOfcCd, types);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Second Row info of Object List set by office of login user
	 * 
	 * @param String psoOfcCd
	 * @param String psoObjCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchOfficeObjectList2(String psoOfcCd, String psoObjCd, String types) throws EventException {
		try {
			return dbDao.searchOfficeObjectList2(psoOfcCd, psoObjCd, types);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object List registered
	 * 
	 * @param PsoObjListVO psoObjListVO
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchObjectList(PsoObjListVO psoObjListVO) throws EventException {
		
		// List<PsoObjListVO> list = new ArrayList<PsoObjListVO>();
		// PsoObjListVO vo = new PsoObjListVO();
		try {
			// vo.setList1(dbDao.searchObjectList(psoObjListVO));
			// vo.setList2(dbDao.searchOfficeObject1stList(psoObjListVO));
			// vo.setList3(dbDao.searchOfficeObject2stList(psoObjListVO));
			// vo.setList4(dbDao.searchOfficeObject3stList(psoObjListVO));

			// list.add(vo);

			// return list;
			return dbDao.searchObjectList(psoObjListVO);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object List of office
	 * 
	 * @category VOP_PSO_0208_OfficeObjectList
	 * @param String ofcCd
	 * @return List<PsoObjListVO>
	 */
	@Override
	public List<PsoObjListVO> searchOfficeObjectList(String ofcCd) throws EventException {
		
		List<PsoObjListVO> list = new ArrayList<PsoObjListVO>();
		List<PsoObjListVO> list1 = new ArrayList<PsoObjListVO>();
		List<PsoObjListVO> list2 = new ArrayList<PsoObjListVO>();
		List<PsoObjListVO> list3 = new ArrayList<PsoObjListVO>();
		PsoObjListVO vo = new PsoObjListVO();
		PsoObjListVO rvo = null;
		try {
			List<PsoObjListVO> lst = dbDao.searchOfficeObjectList(ofcCd);

			for (int i = 0; i < lst.size(); i++) {
				rvo = lst.get(i);
				if (rvo.getRowNo().equals("1"))
					list1.add(rvo);
				else if (rvo.getRowNo().equals("2"))
					list2.add(rvo);
				else if (rvo.getRowNo().equals("3"))
					list3.add(rvo);
			}
			vo.setList1(list1);
			vo.setList2(list2);
			vo.setList3(list3);
			list.add(vo);
			return list;
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Object" }).getMessage(), ex);
		}
	}

	/**
	 * Get formula of base tariff
	 * 
	 * @category VOP_PSO_0002_Retrieve
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffBaseVO>
	 * @throws EventException
	 */
	public List<TariffBaseVO> searchBaseTariff(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {
		
		try {
			return dbDao.searchBaseTariff(portTariffCodeGRPVO);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Formula" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Formula" }).getMessage(), ex);
		}
	}

	/**
	 * Get condition of base tariff
	 * 
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<ConditionVO>
	 * @throws EventException
	 */
	public List<ConditionVO> searchBaseCondition(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {
		
		try {
			return dbDao.searchBaseCondition(portTariffCodeGRPVO);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Condition" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Condition" }).getMessage(), ex);
		}
	}

	/**
	 * Get condition of search formula & conditon
	 * 
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusConditon(UseStatusConForVO useStatusConForVO) throws EventException {
		
		try {
			return dbDao.searchUseStatusConditon(useStatusConForVO);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Condition" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Condition" }).getMessage(), ex);
		}
	}

	/**
	 * Get formula of search formula & conditon
	 * 
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusFormulaDetaill(UseStatusConForVO useStatusConForVO) throws EventException {
		
		try {
			return dbDao.searchUseStatusFormulaDetaill(useStatusConForVO);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Formula" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Formula" }).getMessage(), ex);
		}
	}

	/**
	 * Get formula of search formula & conditon
	 * 
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaVO> searchUseStatusFormula(UseStatusConForVO useStatusConForVO) throws EventException {
		
		try {
			return dbDao.searchUseStatusFormula(useStatusConForVO);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Formula" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Formula" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve version Info of TariffList
	 * 
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @param String uid
	 * @return List<TariffListGRPVO>
	 * @exception EventException
	 */
	public List<TariffListGRPVO> searchEffectiveDateList(PortTariffCodeGRPVO portTariffCodeGRPVO, String uid) throws EventException {
		
		try {
			return dbDao.searchEffectiveDateList(portTariffCodeGRPVO, uid);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Version" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Version" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve version Info of TariffList copy
	 * 
	 * @param String combo1
	 * @param String vndrSeq
	 * @param String acctCd
	 * @param String ofcCd
	 * @return List<TariffListGRPVO>
	 * @exception EventException
	 */
	public List<TariffListGRPVO> searchEffectiveDateList2(String combo1, String vndrSeq, String acctCd, String ofcCd) throws EventException {
		
		try {
			return dbDao.searchEffectiveDateList2(combo1, vndrSeq, acctCd, ofcCd);
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Version" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Retrieval of Version" }).getMessage(), ex);
		}
	}

	/**
	 * Handling CRUD of Favorite Object List by office
	 * 
	 * @param psoObjListVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageOfficeObjectList(PsoObjListVO[] psoObjListVOs, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeOfficeObjectList(account.getOfc_cd());// Delete object list already registered of logn office
			List<PsoObjListVO> insertVoList = new ArrayList<PsoObjListVO>();
			if (psoObjListVOs == null || psoObjListVOs.length == 0)
				return;
			for (int i = 0; i < psoObjListVOs.length; i++) {
				if (!psoObjListVOs[i].getPsoObjCd().equals("")) {
					psoObjListVOs[i].setCreUsrId(account.getUsr_id());
					psoObjListVOs[i].setPsoOfcCd(account.getOfc_cd());
					insertVoList.add(psoObjListVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addOfficeObjectList(insertVoList);// registered new ObjectList
			}
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Favorite Object List" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Favorite Object List" }).getMessage(), ex);
		}
	}

	/**
	 * Delete Tariff info
	 * 
	 * @category VOP_PSO_0002
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void deletePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {

		/***************************************************************************************************************************************
		 * <Delete Sequence>
		 ***************************************************************************************************************************************
		 * 0. PSO_YD_CHG Checking existence 1. PSO_YD_CHG_OBJ_LIST Delete data
		 * 2. PSO_TRF_DTL Delete data 3. PSO_TARIFF Delete data 4.
		 * PSO_CHG_XPR_DTL Delete data 5. PSO_CHG_XPR Delete data 6.
		 * PSO_YD_CHG_XPR Delete data 7. PSO_YD_CHG Delete data 8. PSO_YD_CHG
		 * Update LST_FLG
		 ***************************************************************************************************************************************/

		String vYdChgNo = portTariffCodeGRPVO.getYdChgNo();
		String vYdChgVerSeq = portTariffCodeGRPVO.getCombo4();

		try {

			// 0. PSO_YD_CHG Checking existence (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vYdChgVerSeq);
			if (resultPsoYdChg == null || resultPsoYdChg.size() == 0) {
				throw new EventException(new ErrorHandler("PSO90002", new String[] {}).getMessage());
			} else {
				String resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId();
				if (!"X".equalsIgnoreCase(resIssCtyCd)) {

					throw new EventException(new ErrorHandler("PSO91001", new String[] {}).getMessage());
				}
			}

			// 1. PSO_YD_CHG_OBJ_LIST Delete data
			PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
			deletePsoYdChgObjListVO.setYdChgNo(vYdChgNo);
			deletePsoYdChgObjListVO.setYdChgVerSeq(vYdChgVerSeq);
			deletePsoYdChgObjListVO.setObjListNo("");
			dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);

			// 2. PSO_TRF_DTL Delete data
			dbDao.removePsoTrfDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 3. PSO_TARIFF Delete data
			dbDao.removePsoTariffByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 4. PSO_CHG_XPR_DTL Delete data
			dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 5. PSO_CHG_XPR Delete data
			dbDao.removePsoChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 6. PSO_YD_CHG_XPR Delete data
			dbDao.removePsoYdChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 7. PSO_YD_CHG Delete data
			dbDao.removePsoYdChg(vYdChgNo, vYdChgVerSeq);

			// 8. PSO_YD_CHG Update LST_FLG
			dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, "");

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Tariff" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Tariff" }).getMessage(), ex);
		}
	}

	/**
	 * Delete Tariff Info
	 * 
	 * @category VOP_PSO_0004
	 * @param portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void deletePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {

		/***************************************************************************************************************************************
		 * <Delete Sequence>
		 ***************************************************************************************************************************************
		 * 0. PSO_YD_CHG Checking existence 1. PSO_YD_CHG_OBJ_LIST Delete data
		 * 2. PSO_TRF_DTL Delete data 3. PSO_TARIFF Delete data 4.
		 * PSO_CHG_XPR_DTL Delete data 5. PSO_CHG_XPR Delete data 6.
		 * PSO_YD_CHG_XPR Delete data 7. PSO_YD_CHG Delete data 8. PSO_YD_CHG
		 * Update LST_FLG
		 ***************************************************************************************************************************************/

		String vYdChgNo = portTariffCodeGRPVO.getYdChgNo();
		String vYdChgVerSeq = portTariffCodeGRPVO.getCombo4();

		try {

			// 0. PSO_YD_CHG Checking existence (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vYdChgVerSeq);
			if (resultPsoYdChg == null || resultPsoYdChg.size() == 0) {
				throw new EventException(new ErrorHandler("PSO90002", new String[] {}).getMessage());
			} else {
				String resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId(); // PSO_CHG_DTL존재여부 (없으면 'X')

				if (!"X".equalsIgnoreCase(resIssCtyCd)) {
					throw new EventException(new ErrorHandler("PSO91001", new String[] {}).getMessage());
				}
			}

			// 1. PSO_YD_CHG_OBJ_LIST Delete data
			PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
			deletePsoYdChgObjListVO.setYdChgNo(vYdChgNo);
			deletePsoYdChgObjListVO.setYdChgVerSeq(vYdChgVerSeq);
			deletePsoYdChgObjListVO.setObjListNo("");
			dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);

			// 2. PSO_TRF_DTL Delete data
			dbDao.removePsoTrfDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 3. PSO_TARIFF Delete data
			dbDao.removePsoTariffByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 4. PSO_CHG_XPR_DTL Delete data
			dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 5. PSO_CHG_XPR Delete data
			dbDao.removePsoChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 6. PSO_YD_CHG_XPR Delete data
			dbDao.removePsoYdChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");

			// 7. PSO_YD_CHG Delete data
			dbDao.removePsoYdChg(vYdChgNo, vYdChgVerSeq);

			// 8. PSO_YD_CHG Ipdate LST_FLG
			dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, "");

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Tariff" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Tariff" }).getMessage(), ex);
		}
	}

	/**
	 * Create Tariff (Tariff List)
	 * 
	 * @category VOP_PSO_0002_SaveClick
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void managePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {

		/***************************************************************************************************************************************
		 * <Save Sequence>
		 ***************************************************************************************************************************************
		 * 1. Create data on PSO_YD_CHG table 2. Create data on
		 * PSO_YD_CHG_OBJ_LIST table 3. Delete previous data on PSO_TRF_DTL,
		 * PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR tale (in
		 * case of "UPDATE") 4. Create data on PSO_CHG_XPR, (PSO_CHG_XPR_DTL,)
		 * PSO_YD_CHG_XPR table 5. Create data on (PSO_CHG_XPR_DTL,) PSO_TARIFF,
		 * PSO_TRF_DTL table 6. Update Description on PSO_CHG_XPR table
		 ***************************************************************************************************************************************/

		try {

			String vYdCd = portTariffCodeGRPVO.getPortCd() + portTariffCodeGRPVO.getCombo1();
			// String vAcctCd = portTariffCodeGRPVO.getCombo2();
			String vCostCd = portTariffCodeGRPVO.getCombo3();
			String vVndrSeq = portTariffCodeGRPVO.getVndrSeq();
			String vOrgVndrNm = portTariffCodeGRPVO.getOrgVndrNm();
			String vFromDate = portTariffCodeGRPVO.getFromDate().replace("-", ""); // YYYYMMDD
			String vToDate = portTariffCodeGRPVO.getToDate().replace("-", ""); // YYYYMMDD
			String vVersion = portTariffCodeGRPVO.getCombo4();
			String vCurrency = portTariffCodeGRPVO.getCombo5();
			String vYdChgNo = portTariffCodeGRPVO.getYdChgNo();
			String vCreUsrId = portTariffCodeGRPVO.getCreUsrId();
			// String vOfcCd = portTariffCodeGRPVO.getOfcCd();
			String vCplsFlg = portTariffCodeGRPVO.getCplsFlg();

			TariffBaseVO[] arrBase = portTariffCodeGRPVO.getTariffBaseVOs();
			TariffBaseVO[] arrSurcharge = portTariffCodeGRPVO.getTariffSurchargeVOs();
			TariffBaseVO[] arrDiscount = portTariffCodeGRPVO.getTariffDiscountVOs();

			// String sheet1_psoObjCd = ""; // Object
			// String sheet1_psoMeasUtCd = ""; // Unit of Measure
			String sheet1_objListNo = ""; // OBJ_LIST_NO
			String sheet1_psoTrfTpCd = ""; // Rate Type
			// String sheet1_dfltVal = ""; // Regular Value
			String sheet1_fomlNo = ""; // Formula
			String sheet1_condNo = ""; // Condition
			String sheet1_chgXprNo = ""; // CHG_XPR_NO
			String sheet1_chgXprSeq = ""; // CHG_XPR_SEQ
			String sheet1_psoChgXprTpCd = ""; // PSO_CHG_XPR_TP_CD
			String sheet1_psoCtrlStmtTpCd = ""; // PSO_CTRL_STMT_TP_CD
			if (arrBase != null && arrBase.length > 0) {
				// sheet1_psoObjCd = arrBase[0].getObject();
				// sheet1_psoMeasUtCd = arrBase[0].getObjectCode();
				sheet1_objListNo = arrBase[0].getObjListNo();
				sheet1_psoTrfTpCd = arrBase[0].getRateCode();
				// sheet1_dfltVal = arrBase[0].getRegularValue(); //

				// Get Formula No by using Object, UOM, Rate Type
				/*
				 * List<PsoFormulaVO> fomlNoList =
				 * dbDao.searchFomlNoByObjListNo(sheet1_psoObjCd,
				 * sheet1_psoMeasUtCd, sheet1_psoTrfTpCd); if(fomlNoList.size()
				 * > 0){ sheet1_fomlNo = fomlNoList.get(0).getFomlNo(); } else{
				 * throw new EventException(new ErrorHandler("PSO90002", new
				 * String[]{"[Formula No] "}).getMessage()); }
				 */

				// Get Formula No by using OBJ_LIST_NO, Rate Type
				List<PsoFormulaVO> fomlNoList = dbDao.searchFomlNoByObjAndType(sheet1_objListNo, sheet1_psoTrfTpCd);
				if (fomlNoList.size() > 0) {
					sheet1_fomlNo = fomlNoList.get(0).getFomlNo();
				} else {
					throw new EventException(new ErrorHandler("PSO90002", new String[] { "[Formula No] " }).getMessage());
				}

				sheet1_condNo = arrBase[0].getCondition();
				// /////////////////////////////////////////////////////////
				// Get CHG_XPR_NO by using Formula and Condition
				// List<PsoChgXprDtlVO> checkPsoChgXprDtlVO =
				// dbDao.searchChgXprNoByFomlCond(sheet1_fomlNo, sheet1_condNo);
				// if(checkPsoChgXprDtlVO.size() > 0){
				// sheet1_chgXprNo = checkPsoChgXprDtlVO.get(0).getChgXprNo();
				// sheet1_chgXprSeq = checkPsoChgXprDtlVO.get(0).getChgXprSeq();
				// }
				// /////////////////////////////////////////////////////////

				sheet1_psoChgXprTpCd = "".equals(sheet1_condNo) ? "1" : "2";
				sheet1_psoCtrlStmtTpCd = "".equals(sheet1_condNo) ? "4" : "1";
			}

			// condition From sheet2 (prefix = sheet2_)
			String sheet2_chgXprNo = ""; // CHG_XPR_NO
			// String sheet2_chgXprSeq = ""; // CHG_XPR_SEQ

			// condition From sheet3 (prefix = sheet3_)
			String sheet3_chgXprNo = ""; // CHG_XPR_NO
			// String sheet3_chgXprSeq = ""; // CHG_XPR_SEQ

			// Search PSO_YD_CHG By PK (prefix = res)
			String resIssCtyCd = "";
			String resFromDt = "";
			// String resToDt = "";
			String resLstFlg = "";

			// GLOBAL VARIABLES (prefix = g)
			String gYdChgNo = "";
			String gYdChgVerSeq = "";

			/***************************************************************************************************************************************
			 * 1. Create data on PSO_YD_CHG table
			 *************************************************************************************************************************************** 
			 * PSO_YD_CHG ( KEY : [LGS_COST_CD, YD_CD, VNDR_SEQ, EFF_DT,
			 * EXP_DT]=[YD_CHG_NO]) - Get EFF_DT~EXP_DT in case of same
			 * LGS_COST_CD, YD_CD, VNDR_SEQ - Date overlap is not available in
			 * case of same LGS_COST_CD, YD_CD, VNDR_SEQ - Have to get CURR_CD
			 * in case of same LGS_COST_CD, YD_CD
			 * 
			 * [CREATE] 1. In case of not existing YD_CHG_NO, YD_CHG_VER_SEQ
			 * data of condition from page 2.In case of not exist YD_CHG_NO,
			 * YD_CHG_VER_SEQ data of condition from page and changing From_Date
			 * ※ 동일 LGS_COST_CD/YD_CD/VNDR_SEQ의 MAX(EXP_DT)보다 From_Date가 커야 함.
			 * 
			 * [VERSION_UP] 1. In case of existing YD_CHG_NO, YD_CHG_VER_SEQ
			 * data of condition from page and existing data in PSO_CHG_DTL(
			 * LST_FLG='Y', update others 'NULL' on last version)
			 * 
			 * [UPDATE] 1. update condition (in case of changing To_Date, update
			 * To_Date of different Version which has same NO to same date
			 * 
			 * [DELETE] 1. Delete in case of LST_FLG='Y' and not existing on
			 * PSO_CHG_DTL table
			 ***************************************************************************************************************************************/

			// Checking existence of PSO_YD_CHG (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vVersion);

			String checkPsoYdChg = ""; // PSO_YD_CHG (CREATE/VERSIONUP/UPDATE)

			if (resultPsoYdChg.size() == 0) {
				checkPsoYdChg = "CREATE";
			} else {
				resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId(); // existence
																	// PSO_CHG_DTL
				resFromDt = resultPsoYdChg.get(0).getEffDt(); // YYYYMMDD
				// resToDt += resultPsoYdChg.get(0).getExpDt(); //YYYYMMDD
				resLstFlg = resultPsoYdChg.get(0).getLstFlg();

				if (!resFromDt.equals(vFromDate)) {
					checkPsoYdChg = "CREATE";
				} else {
					if ("X".equals(resIssCtyCd)) {
						checkPsoYdChg = "UPDATE";
					} else {
						checkPsoYdChg = "VERSION_UP";
					}
				}
			}

			if (checkPsoYdChg.equals("CREATE")) {

				// Get MAX(EXP_DT) by Cost,Yard,Vendor
				String maxExpDt = dbDao.searchPsoYdChgMaxExpDtByYdCostVndr(vCostCd, vYdCd, vVndrSeq);
				if (!"".equals(maxExpDt)) {
					if (Integer.parseInt(vFromDate) <= Integer.parseInt(maxExpDt)) {
						throw new EventException(new ErrorHandler("PSO99002", new String[] {}).getMessage());
					}
				}

				String newYdChgNo = dbDao.searchYardChgNumber().get(0).getYdChgNo(); // PSO_YD_CHG.YD_CHG_NO

				PsoYdChgVO createPsoYdChgVO = new PsoYdChgVO();
				createPsoYdChgVO.setYdChgNo(newYdChgNo);
				createPsoYdChgVO.setYdChgVerSeq("1"); // Version 1
				createPsoYdChgVO.setLgsCostCd(vCostCd);
				createPsoYdChgVO.setYdCd(vYdCd);
				createPsoYdChgVO.setVndrSeq(vVndrSeq);
				createPsoYdChgVO.setEffDt(vFromDate);
				createPsoYdChgVO.setExpDt(vToDate);
				createPsoYdChgVO.setCurrCd(vCurrency);
				createPsoYdChgVO.setCplsFlg(vCplsFlg);
				createPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				createPsoYdChgVO.setRltAgmtNo("");
				createPsoYdChgVO.setLstFlg("Y");
				createPsoYdChgVO.setCreUsrId(vCreUsrId);
				dbDao.addPsoYdChg(createPsoYdChgVO);

				gYdChgNo = newYdChgNo;
				gYdChgVerSeq = "1";

			} else if (checkPsoYdChg.equals("VERSION_UP")) {

				String newYdChgVerSeq = dbDao.searchPsoYdChgVersionByNo(vYdChgNo); // Version

				PsoYdChgVO versionUpPsoYdChgVO = new PsoYdChgVO();
				versionUpPsoYdChgVO.setYdChgNo(vYdChgNo);
				versionUpPsoYdChgVO.setYdChgVerSeq(newYdChgVerSeq);
				versionUpPsoYdChgVO.setLgsCostCd(vCostCd);
				versionUpPsoYdChgVO.setYdCd(vYdCd);
				versionUpPsoYdChgVO.setVndrSeq(vVndrSeq);
				versionUpPsoYdChgVO.setEffDt(vFromDate);
				versionUpPsoYdChgVO.setExpDt(vToDate);
				versionUpPsoYdChgVO.setCurrCd(vCurrency);
				versionUpPsoYdChgVO.setCplsFlg(vCplsFlg);
				versionUpPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				versionUpPsoYdChgVO.setRltAgmtNo("");
				versionUpPsoYdChgVO.setLstFlg("Y");
				versionUpPsoYdChgVO.setCreUsrId(vCreUsrId);
				dbDao.addPsoYdChg(versionUpPsoYdChgVO);

				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);

				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = newYdChgVerSeq;

			} else if (checkPsoYdChg.equals("UPDATE")) {

				PsoYdChgVO updatePsoYdChgVO = new PsoYdChgVO();
				updatePsoYdChgVO.setYdChgNo(vYdChgNo);
				updatePsoYdChgVO.setYdChgVerSeq(vVersion);
				updatePsoYdChgVO.setLgsCostCd(vCostCd);
				updatePsoYdChgVO.setYdCd(vYdCd);
				updatePsoYdChgVO.setVndrSeq(vVndrSeq);
				updatePsoYdChgVO.setEffDt(vFromDate);
				updatePsoYdChgVO.setExpDt(vToDate);
				updatePsoYdChgVO.setCurrCd(vCurrency);
				updatePsoYdChgVO.setCplsFlg(vCplsFlg);
				updatePsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				updatePsoYdChgVO.setRltAgmtNo("");
				updatePsoYdChgVO.setLstFlg(resLstFlg);
				updatePsoYdChgVO.setCreUsrId(vCreUsrId);
				dbDao.modifyPsoYdChg(updatePsoYdChgVO); // UPDATE

				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate); // changing EXP_DT,LST_FLG

				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = vVersion;
			}

			// String[] arrCurr = dbDao.searchCurrByYardAndCost(vYdCd, vCostCd);
			// if(!"".equals(arrCurr[0])){
			// if(!arrCurr[0].equals(arrCurr[1])){
			// throw new EventException(new ErrorHandler("PSO90011", new
			// String[]{"The currency is different from what is input as the same yard and cost before."}).getMessage());
			// //
			// }
			// }

			/***************************************************************************************************************************************
			 * 2. Create data on PSO_YD_CHG_OBJ_LIST table
			 *************************************************************************************************************************************** 
			 * - Delete by YardCharge on PSO_YD_CHG_OBJ_LIST table. - Get
			 * PSO_OBJ_CD and PSO_MEAS_UT_CD로 OBJ_LIST_NO - Insert into
			 * PSO_YD_CHG_OBJ_LIST table
			 ***************************************************************************************************************************************/
			/*
			 * 
			 * PsoYdChgObjListVO deletePsoYdChgObjListVO = new
			 * PsoYdChgObjListVO();
			 * deletePsoYdChgObjListVO.setYdChgNo(gYdChgNo);
			 * deletePsoYdChgObjListVO.setYdChgVerSeq(gYdChgVerSeq);
			 * deletePsoYdChgObjListVO.setObjListNo("");
			 * dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
			 * 
			 * if(arrBase != null && arrBase.length > 0){
			 * 
			 * //sheet1_objListNo =
			 * dbDao.searchObjListNoByObjUom(sheet1_psoObjCd,
			 * sheet1_psoMeasUtCd); //if("".equals(sheet1_objListNo)){ // throw
			 * new EventException(new ErrorHandler("PSO90002", new
			 * String[]{"[Object List No ] "}).getMessage()); //}
			 * 
			 * 
			 * PsoYdChgObjListVO insertPsoYdChgObjListVO = new
			 * PsoYdChgObjListVO();
			 * insertPsoYdChgObjListVO.setYdChgNo(gYdChgNo);
			 * insertPsoYdChgObjListVO.setYdChgVerSeq(gYdChgVerSeq);
			 * insertPsoYdChgObjListVO.setObjListNo(sheet1_objListNo);
			 * insertPsoYdChgObjListVO.setDfltCtnt("");
			 * insertPsoYdChgObjListVO.setDfltVal(sheet1_dfltVal);
			 * insertPsoYdChgObjListVO.setDfltFlg("");
			 * insertPsoYdChgObjListVO.setCreUsrId(vCreUsrId);
			 * dbDao.mergePsoYdChgObjList(insertPsoYdChgObjListVO); }
			 */

			/***************************************************************************************************************************************
			 * 3. Delete previous data on PSO_TRF_DTL, PSO_TARIFF,
			 * PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR table
			 *************************************************************************************************************************************** 
			 * - In case of "UPDATE", delete PSO_TRF_DTL, PSO_TARIFF,
			 * PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR
			 ***************************************************************************************************************************************/
			//
			if ("UPDATE".equals(checkPsoYdChg)) {
				// delete PSO_TRF_DTL
				dbDao.removePsoTrfDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// delete PSO_TARIFF
				dbDao.removePsoTariffByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// delete PSO_CHG_XPR_DTL
				dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// delete PSO_CHG_XPR
				dbDao.removePsoChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// delete PSO_YD_CHG_XPR
				dbDao.removePsoYdChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
			}

			/***************************************************************************************************************************************
			 * 4. Create data on PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR
			 * table
			 *************************************************************************************************************************************** 
			 * [Base] - PSO_CHG_XPR - PSO_CHG_XPR_DTL - PSO_YD_CHG_XPR
			 * [Surcharge] - PSO_CHG_XPR - PSO_YD_CHG_XPR [Discount] -
			 * PSO_CHG_XPR - PSO_YD_CHG_XPR
			 ***************************************************************************************************************************************/
			// [Base]
			if (arrBase != null && arrBase.length > 0) {
				if ("".equals(sheet1_chgXprNo)) {

					sheet1_chgXprNo = dbDao.searchPsoChgXprPK();
					sheet1_chgXprSeq = "1";
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet1_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd(sheet1_psoChgXprTpCd); // Condition 有 : 2, Condition 無 : 1

					insertPsoChgXprVO.setUpdMnuNo("1");
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					insertPsoChgXprVO.setUpdUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);

					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet1_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq("1");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(sheet1_psoCtrlStmtTpCd); // Condition 有 : 1, Condition 無 : 4
					insertPsoChgXprDtlVO.setCondNo(sheet1_condNo);
					insertPsoChgXprDtlVO.setFomlNo(sheet1_fomlNo);
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					insertPsoChgXprDtlVO.setUpdUsrId(vCreUsrId);
					
					insertPsoChgXprDtlVO.setCondAlsNm(arrBase[0].getCondAlsNm());//2015.09.21 Add
					
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);

				}

				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("B");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}

			// [Surcharge]
			if (arrSurcharge != null && arrSurcharge.length > 0) {
				if ("".equals(sheet2_chgXprNo)) {

					sheet2_chgXprNo = dbDao.searchPsoChgXprPK();
					// sheet2_chgXprSeq = "1";
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet2_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7");

					// insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("1");
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);
				}

				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("S");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet2_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}

			// [Discount]
			if (arrDiscount != null && arrDiscount.length > 0) {
				if ("".equals(sheet3_chgXprNo)) {
					// PSO_CHG_XPR Insert
					sheet3_chgXprNo = dbDao.searchPsoChgXprPK();
					// sheet3_chgXprSeq += "1";
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet3_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7");

					// insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("1");
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);
				}

				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("D");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet3_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}

			/***************************************************************************************************************************************
			 * 5. Create data on (PSO_CHG_XPR_DTL,) PSO_TARIFF, PSO_TRF_DTL
			 * table
			 *************************************************************************************************************************************** 
			 * [Base] - PSO_TARIFF - PSO_TRF_DTL [Surcharge] - PSO_CHG_XPR_DTL -
			 * PSO_TARIFF - PSO_TRF_DTL [Discount] - PSO_CHG_XPR_DTL -
			 * PSO_TARIFF - PSO_TRF_DTL
			 ***************************************************************************************************************************************/
			// [Base]
			if (arrBase != null && arrBase.length > 0) {

				String newPortTrfNo = dbDao.searchPsoTariffPK();

				List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
				PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
				insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
				insertPsoTariffVO.setPsoTrfTpCd(sheet1_psoTrfTpCd);
				insertPsoTariffVO.setFomlNo(sheet1_fomlNo);
				insertPsoTariffVO.setFomlSeq("1");
				insertPsoTariffVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoTariffVO.setChgXprSeq(sheet1_chgXprSeq);
				insertPsoTariffVO.setObjListNo(sheet1_objListNo);
				insertPsoTariffVO.setCurrCd(vCurrency);
				insertPsoTariffVO.setPsoRtTpCd(null);
				insertPsoTariffVO.setDpNo("10");
				insertPsoTariffVO.setCreUsrId(vCreUsrId);
				insertPsoTariffVOList.add(insertPsoTariffVO);
				dbDao.addTariff(insertPsoTariffVOList);

				for (int i = 0; i < arrBase.length; i++) {
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq(i + 1 + "");
					insertPsoTrfDtlVO.setFmVal(arrBase[i].getRangeFrom().replace(":", "").replace(",", "")); // From Value
					insertPsoTrfDtlVO.setToVal(arrBase[i].getRangeTo().replace(":", "").replace(",", "")); // To Value
					insertPsoTrfDtlVO.setTrfRtAmt(arrBase[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(sheet1_condNo);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}

			}

			// [Surcharge]
			if (arrSurcharge != null && arrSurcharge.length > 0) {

				for (int i = 0; i < arrSurcharge.length; i++) {
					// PSO_CHG_XPR_DTL Insert
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet2_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrSurcharge[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrSurcharge[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					
					insertPsoChgXprDtlVO.setCondAlsNm(arrSurcharge[i].getCondAlsNm());//2015.09.21 Add
					
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);

					String newPortTrfNo = dbDao.searchPsoTariffPK();

					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");
					insertPsoTariffVO.setChgXprNo(sheet2_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrSurcharge[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);

					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrSurcharge[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}

			}

			// [Discount]
			if (arrDiscount != null && arrDiscount.length > 0) {

				for (int i = 0; i < arrDiscount.length; i++) {
					// PSO_CHG_XPR_DTL Insert
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet3_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrDiscount[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrDiscount[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					
					insertPsoChgXprDtlVO.setCondAlsNm(arrDiscount[i].getCondAlsNm());//2015.09.21 Add
					
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);

					String newPortTrfNo = dbDao.searchPsoTariffPK();

					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");
					insertPsoTariffVO.setChgXprNo(sheet3_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrDiscount[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);

					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrDiscount[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
			}
			/***************************************************************************************************************************************
			 * 6. Update Description on PSO_CHG_XPR table
			 *************************************************************************************************************************************** 
			 * [Base] - PSO_CHG_XPR Description Update [Surcharge] - PSO_CHG_XPR
			 * Description Update [Discount] - PSO_CHG_XPR Description Update
			 ***************************************************************************************************************************************/
			// [Base]
			if (arrBase != null && arrBase.length > 0) {
				if (dbDao.modifyChgXprDescByChgXprNo(sheet1_chgXprNo) < 1) {
					throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expression Description, Base" }).getMessage()); // Unexpected Error Occurred.
				}
			}

			// [Surcharge]
			if (arrSurcharge != null && arrSurcharge.length > 0) {
				if (dbDao.modifyChgXprDescByChgXprNo(sheet2_chgXprNo) < 1) {
					throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expression Description, Surcharge" }).getMessage()); //  Unexpected Error Occurred.
				}
			}

			// [Discount]
			if (arrDiscount != null && arrDiscount.length > 0) {
				if (dbDao.modifyChgXprDescByChgXprNo(sheet3_chgXprNo) < 1) {
					throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expression Description, Discount" }).getMessage()); //  Unexpected Error Occurred.
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Tariff Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Tariff Creation" }).getMessage(), de);
		}
	}

	/**
	 * create Tariff (Formula Selection)
	 * 
	 * @category VOP_PSO_0004_SaveClick (jmh)
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void managePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {
		/***************************************************************************************************************************************
		 * <Save Sequence>
		 ***************************************************************************************************************************************
		 * 1. PSO_YD_CHG 테이블에 데이터 생성 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성
		 * *[2010.01.13] ReadOnly로 변경 3. PSO_TRF_DTL, PSO_TARIFF,
		 * PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 테이블의 이전 데이터 삭제
		 * ("UPDATE"일 경우) 4. PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR 테이블에
		 * 데이터 생성 - FOML_NO와 COND_NO를 가지고 PSO_CHG_XPR_DTL 테이블에서 CHG_XPR_NO를 찾는다.
		 * (개발시 Fetch ROWNUM=1) - CHG_XPR_NO를 찾지 못하면 PSO_CHG_XPR 테이블에 데이터 생성,
		 * PSO_CHG_XPR_DTL 테이블(Simple화면에서는 CHG_XPR_SEQ=1)에 데이터 생성 -
		 * PSO_YD_CHG_XPR 테이블에 의미상 Key의 중복여부를 체크하여 데이터를 생성 5. (PSO_CHG_XPR_DTL,)
		 * PSO_TARIFF, PSO_TRF_DTL 테이블에 데이터 생성 6. PSO_CHG_XPR 테이블에 Description
		 * Update
		 ***************************************************************************************************************************************/
		try {
			// 화면에서 넘어온 조건 (prefix = v)
			String vYdCd = portTariffCodeGRPVO.getPortCd() + portTariffCodeGRPVO.getCombo1();
			// String vAcctCd = portTariffCodeGRPVO.getCombo2();
			String vCostCd = portTariffCodeGRPVO.getCombo3();
			String vVndrSeq = portTariffCodeGRPVO.getVndrSeq();
			String vOrgVndrNm = portTariffCodeGRPVO.getOrgVndrNm();
			String vFromDate = portTariffCodeGRPVO.getFromDate().replace("-", ""); // YYYYMMDD
			String vToDate = portTariffCodeGRPVO.getToDate().replace("-", ""); // YYYYMMDD
			String vVersion = portTariffCodeGRPVO.getCombo4();
			String vCurrency = portTariffCodeGRPVO.getCombo5();
			String vYdChgNo = portTariffCodeGRPVO.getYdChgNo();
			String vCreUsrId = portTariffCodeGRPVO.getCreUsrId();
			// String vOfcCd = portTariffCodeGRPVO.getOfcCd();
			String vCplsFlg = portTariffCodeGRPVO.getCplsFlg();

			TariffBaseVO[] arrBaseFomlCond = portTariffCodeGRPVO.getTariffBaseFomlCondVOs();
			TariffBaseVO[] arrBaseRegVal = portTariffCodeGRPVO.getTariffBaseRegValVOs(); // [2010.01.13:ReadOnly로 변경]-> *[2011.11.10] Version up 시 insert 되도록 변경
			TariffBaseVO[] arrBase = portTariffCodeGRPVO.getTariffBaseVOs();
			TariffBaseVO[] arrSurcharge = portTariffCodeGRPVO.getTariffSurchargeVOs();
			TariffBaseVO[] arrDiscount = portTariffCodeGRPVO.getTariffDiscountVOs();

			// From sheet1 (prefix = sheet1_) 화면에서 넘어온 조건, From sheet1 (prefix = sheet1_)
			String sheet1_uk = ""; // ] UK
			String sheet1_fomlNo = ""; // Formula
			String sheet1_condNo = ""; // Condition
			String sheet1_chgXprNo = ""; // CHG_XPR_NO
			String sheet1_psoChgXprTpCd = ""; // PSO_CHG_XPR_TP_CD
			String sheet1_dfltFomlFlg = ""; // DFLT_FOML_FLG
			String sheet1_psoCtrlStmtTpCd = ""; // PSO_CTRL_STMT_TP_CD

			// 화면에서 넘어온 조건, From sheet3 (prefix = sheet3_)
			String sheet3_objListNo = ""; // [서버] [2010.01.13:ReadOnly로 변경] -> *[2011.11.10] Version up 시 insert 되도록 변경
			String sheet3_dfltVal = ""; // [화면] [2010.01.13:ReadOnly로 변경] -> *[2011.11.10] Version up 시 insert 되도록 변경

			// From sheet4 (prefix = sheet4_) 화면에서 넘어온 조건, From sheet4 (prefix =
			// sheet4_)
			String sheet4_chgXprNo = ""; // CHG_XPR_NO
			// String sheet4_chgXprSeq = ""; // CHG_XPR_SEQ

			// From sheet5 (prefix = sheet5_) 화면에서 넘어온 조건, From sheet5 (prefix =
			// sheet5_)
			String sheet5_chgXprNo = ""; // CHG_XPR_NO
			// String sheet5_chgXprSeq = ""; // CHG_XPR_SEQ

			// From sheet6 (prefix = sheet6_) 화면에서 넘어온 조건, From sheet6 (prefix =
			// sheet6_)
			String sheet6_uk = ""; // [화면] UK
			String sheet6_seq = ""; // [화면] Seq
			// String sheet6_psoObjCd = ""; //[화면] Object
			// String sheet6_psoMeasUtCd = ""; //[화면] Unit of Measure
			String sheet6_objListNo = ""; // [화면] OBJ_LIST_NO
			String sheet6_psoTrfTpCd = ""; // [화면] Rate Type
			String sheet6_fomlNo = ""; // [서버] Formula
			String sheet6_condNo = ""; // [화면] Condition
			String sheet6_fmVal = ""; // [화면] FM_VAL
			String sheet6_toVal = ""; // [화면] TO_VAL
			String sheet6_trfRtAmt = ""; // [화면] TRF_RT_AMT
			String sheet6_consAlsNm = ""; // [화면] CONS_ALS_NM

			// Sheet1의 UK와 PSO_CHG_XPR_DTL.CHG_XPR_SEQ 연결하는 Hash
			HashMap<String, String> hashUkChgXprSeq = new HashMap<String, String>(); // key:화면UK, value:PSO_CHG_XPR_DTL.CHG_XPR_SEQ (PSO_CHG_XPR_DTL.CHG_XPR_NO=sheet1_chgXprNo는 한개이므로)
			HashMap<String, HashMap<String, String>> hashUkSeqTrfSeq = new HashMap<String, HashMap<String, String>>(); // Hash의 Hash, key:화면UK, key:화면Seq, value:PSO_TARIFF.TRF_NO_SEQ PSO_TARIFF:Base 저장시, Formula에 속한 Object인지 체크하기 위해
			HashMap<String, String> hashUkObject = new HashMap<String, String>(); // key:화면UK, value:Formula에 속한 Object(,1,2,3,)/ Search PSO_YD_CHG By PK (prefix = res) [조회조건과 비교하여
			// CREATE/VERSIONUP/UPDATE 결정]
			String resIssCtyCd = "";
			String resFromDt = "";
			// String resToDt = "";
			String resLstFlg = "";

			// 사용자 정의 GLOBAL VARIABLES (prefix = g)
			String gYdChgNo = "";
			String gYdChgVerSeq = "";

			// Version Up시 생성될 yd_chg_ver_seq
			String newYdChgVerSeq = "";

			/***************************************************************************************************************************************
			 * 1. PSO_YD_CHG 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * PSO_YD_CHG (의미상 KEY : [LGS_COST_CD, YD_CD, VNDR_SEQ, EFF_DT,
			 * EXP_DT]=[YD_CHG_NO]) - 동일 LGS_COST_CD, YD_CD, VNDR_SEQ 끼리는 같은
			 * EFF_DT~EXP_DT를 갖는다. - 동일 LGS_COST_CD, YD_CD, VNDR_SEQ 끼리는 날짜가
			 * Overlap될 수 없다. - 동일 LGS_COST_CD, YD_CD 끼리는 같은 CURR_CD를 가져야 한다.
			 * [2010.03.19]
			 * 
			 * [CREATE] 1. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터가 없는 경우 2.
			 * 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터 존재시 From_Date가 변경되었을 때
			 * ※ 동일 LGS_COST_CD/YD_CD/VNDR_SEQ의 MAX(EXP_DT)보다 From_Date가 커야 함.
			 * 
			 * [VERSION_UP] 1. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터 존재하고
			 * PSO_CHG_DTL에도 있을 때 (최종 버전에 LST_FLG='Y', 나머지는 NULL로 업데이트)
			 * 
			 * [UPDATE] 1. 일반 업데이트 조건 (To_Date가 변경되면 동일 NO의 다른 VERSION의 To_Date도
			 * 같은 날짜로 업데이트)
			 * 
			 * [DELETE] 1. LST_FLG='Y' 이고 PSO_CHG_DTL 테이블에 없는 경우 삭제 가능
			 ***************************************************************************************************************************************/

			// PSO_YD_CHG 존재 확인 (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vVersion);

			String checkPsoYdChg = ""; // PSO_YD_CHG (CREATE/VERSIONUP/UPDATE)

			if (resultPsoYdChg.size() == 0) {
				checkPsoYdChg = "CREATE";
			} else {
				resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId(); // PSO_CHG_DTL 존재여부 (없으면 'X')
				resFromDt = resultPsoYdChg.get(0).getEffDt(); // YYYYMMDD
				// resToDt += resultPsoYdChg.get(0).getExpDt(); //YYYYMMDD
				resLstFlg = resultPsoYdChg.get(0).getLstFlg();

				if (!resFromDt.equals(vFromDate)) {
					checkPsoYdChg = "CREATE";
				} else {
					if ("X".equals(resIssCtyCd)) { // PSO_CHG_DTL 테이블에 없으면
						checkPsoYdChg = "UPDATE";
					} else { // PSO_CHG_DTL 테이블에 있으면
						checkPsoYdChg = "VERSION_UP";
					}
				}
			}

			// PSO_YD_CHG C/U/D 작업
			if (checkPsoYdChg.equals("CREATE")) {

				// Cost,Yard,Vendor 별 MAX(EXP_DT) 구하기
				String maxExpDt = dbDao.searchPsoYdChgMaxExpDtByYdCostVndr(vCostCd, vYdCd, vVndrSeq);
				if (!"".equals(maxExpDt)) {
					if (Integer.parseInt(vFromDate) <= Integer.parseInt(maxExpDt)) { // From_Date는 MAX(EXP_DT)보다 커야 한다.
						throw new EventException(new ErrorHandler("PSO99002", new String[] {}).getMessage());
					}
				}

				String newYdChgNo = dbDao.searchYardChgNumber().get(0).getYdChgNo(); // PSO_YD_CHG.YD_CHG_NO

				PsoYdChgVO createPsoYdChgVO = new PsoYdChgVO();
				createPsoYdChgVO.setYdChgNo(newYdChgNo);
				createPsoYdChgVO.setYdChgVerSeq("1"); // Version 1
				createPsoYdChgVO.setLgsCostCd(vCostCd);
				createPsoYdChgVO.setYdCd(vYdCd);
				createPsoYdChgVO.setVndrSeq(vVndrSeq);
				createPsoYdChgVO.setEffDt(vFromDate);
				createPsoYdChgVO.setExpDt(vToDate);
				createPsoYdChgVO.setCurrCd(vCurrency);
				createPsoYdChgVO.setCplsFlg(vCplsFlg);
				createPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				createPsoYdChgVO.setRltAgmtNo("");
				createPsoYdChgVO.setLstFlg("Y");
				createPsoYdChgVO.setCreUsrId(vCreUsrId);
				dbDao.addPsoYdChg(createPsoYdChgVO); // 새로운 No, 1 Version으로 Insert

				// PSO_YD_CHG 테이블의 PK
				gYdChgNo = newYdChgNo;
				gYdChgVerSeq = "1";

			} else if (checkPsoYdChg.equals("VERSION_UP")) {

				newYdChgVerSeq = dbDao.searchPsoYdChgVersionByNo(vYdChgNo); // Version 채번

				PsoYdChgVO versionUpPsoYdChgVO = new PsoYdChgVO();
				versionUpPsoYdChgVO.setYdChgNo(vYdChgNo);
				versionUpPsoYdChgVO.setYdChgVerSeq(newYdChgVerSeq);
				versionUpPsoYdChgVO.setLgsCostCd(vCostCd);
				versionUpPsoYdChgVO.setYdCd(vYdCd);
				versionUpPsoYdChgVO.setVndrSeq(vVndrSeq);
				versionUpPsoYdChgVO.setEffDt(vFromDate);
				versionUpPsoYdChgVO.setExpDt(vToDate);
				versionUpPsoYdChgVO.setCurrCd(vCurrency);
				versionUpPsoYdChgVO.setCplsFlg(vCplsFlg);
				versionUpPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				versionUpPsoYdChgVO.setRltAgmtNo("");
				versionUpPsoYdChgVO.setLstFlg("Y");
				versionUpPsoYdChgVO.setCreUsrId(vCreUsrId);
				dbDao.addPsoYdChg(versionUpPsoYdChgVO);

				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);

				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = newYdChgVerSeq;

			} else if (checkPsoYdChg.equals("UPDATE")) {

				PsoYdChgVO updatePsoYdChgVO = new PsoYdChgVO();
				updatePsoYdChgVO.setYdChgNo(vYdChgNo);
				updatePsoYdChgVO.setYdChgVerSeq(vVersion);
				updatePsoYdChgVO.setLgsCostCd(vCostCd);
				updatePsoYdChgVO.setYdCd(vYdCd);
				updatePsoYdChgVO.setVndrSeq(vVndrSeq);
				updatePsoYdChgVO.setEffDt(vFromDate);
				updatePsoYdChgVO.setExpDt(vToDate);
				updatePsoYdChgVO.setCurrCd(vCurrency);
				updatePsoYdChgVO.setCplsFlg(vCplsFlg);
				updatePsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				updatePsoYdChgVO.setRltAgmtNo("");
				updatePsoYdChgVO.setLstFlg(resLstFlg);
				updatePsoYdChgVO.setCreUsrId(vCreUsrId);
				dbDao.modifyPsoYdChg(updatePsoYdChgVO); // UPDATE

				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);

				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = vVersion;
			}

			// [2010.03.19] 제약사항 체크 : PSO_YD_CHG (동일 Yard/Cost인 경우, 같은 CURR_CD를
			// 가져야 한다. 값 입력후, 중복 Currency가 있는지 조사)
			/*
			 * String[] arrCurr = dbDao.searchCurrByYardAndCost(vYdCd, vCostCd);
			 * if(!"".equals(arrCurr[0])){ if(!arrCurr[0].equals(arrCurr[1])){
			 * throw new EventException(new ErrorHandler("PSO90011", new
			 * String[]{
			 * "The currency is different from what is input as the same yard and cost before."
			 * }).getMessage()); // } }
			 */

			/***************************************************************************************************************************************
			 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성 [2010.01.13:ReadOnly로 변경] ->
			 * *[2011.11.10] Version up 시 insert 되도록 변경
			 *************************************************************************************************************************************** 
			 * - PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. -
			 * PSO_YD_CHG_OBJ_LIST 테이블에 Insert
			 ***************************************************************************************************************************************/
			if (checkPsoYdChg.equals("VERSION_UP")) {
				/*
				 * PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. PsoYdChgObjListVO
				 * deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
				 * deletePsoYdChgObjListVO.setYdChgNo(gYdChgNo);
				 * deletePsoYdChgObjListVO.setYdChgVerSeq(gYdChgVerSeq);
				 * deletePsoYdChgObjListVO.setObjListNo(""); //YardCharge 모두를
				 * 삭제하기 위해 dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
				 */
				if (null != arrBaseRegVal && arrBaseRegVal.length > 0) {
					for (int i = 0; i < arrBaseRegVal.length; i++) {
						sheet3_dfltVal = arrBaseRegVal[i].getRegularValue();
						sheet3_objListNo = arrBaseRegVal[i].getObjListNo();

						// PSO_YD_CHG_OBJ_LIST 테이블에 Insert
						PsoYdChgObjListVO insertPsoYdChgObjListVO = new PsoYdChgObjListVO();
						insertPsoYdChgObjListVO.setYdChgNo(gYdChgNo);
						insertPsoYdChgObjListVO.setYdChgVerSeq(newYdChgVerSeq);
						insertPsoYdChgObjListVO.setObjListNo(sheet3_objListNo);
						insertPsoYdChgObjListVO.setDfltCtnt("");
						insertPsoYdChgObjListVO.setDfltVal(sheet3_dfltVal);
						insertPsoYdChgObjListVO.setDfltFlg("");
						insertPsoYdChgObjListVO.setCreUsrId(vCreUsrId);
						dbDao.mergePsoYdChgObjList(insertPsoYdChgObjListVO);
					}
				}
			}

			/***************************************************************************************************************************************
			 * 3. PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR,
			 * PSO_YD_CHG_XPR 테이블의 이전 데이터 삭제
			 *************************************************************************************************************************************** 
			 * - "UPDATE"일 경우, PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL,
			 * PSO_CHG_XPR, PSO_YD_CHG_XPR 삭제
			 ***************************************************************************************************************************************/
			if ("UPDATE".equals(checkPsoYdChg)) {
				// PSO_TRF_DTL 삭제
				dbDao.removePsoTrfDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// PSO_TARIFF 삭제
				dbDao.removePsoTariffByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// PSO_CHG_XPR_DTL 삭제
				dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// PSO_CHG_XPR 삭제
				dbDao.removePsoChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				// PSO_YD_CHG_XPR 삭제
				dbDao.removePsoYdChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
			}

			/***************************************************************************************************************************************
			 * 4. PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * [Base] - PSO_CHG_XPR 채번, 신규 - PSO_CHG_XPR_DTL 신규 - PSO_YD_CHG_XPR
			 * 업데이트 [Surcharge] - PSO_CHG_XPR 채번, 신규 - PSO_YD_CHG_XPR 업데이트
			 * [Discount] - PSO_CHG_XPR 채번, 신규 - PSO_YD_CHG_XPR 업데이트
			 ***************************************************************************************************************************************/
			// [Base]
			if (arrBaseFomlCond != null && arrBaseFomlCond.length > 0) {

				// PSO_CHG_XPR Insert 단건 (채번, 신규)
				sheet1_chgXprNo = dbDao.searchPsoChgXprPK(); // 채번
				if (arrBaseFomlCond.length == 1) {
					sheet1_condNo = arrBaseFomlCond[0].getCondition();
					sheet1_psoChgXprTpCd = "".equals(sheet1_condNo) ? "1" : "2"; // Condition이 없으면 1, 있으면 2
				} else {
					sheet1_psoChgXprTpCd = "4";
				}
				PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
				insertPsoChgXprVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoChgXprVO.setPsoChgXprTpCd(sheet1_psoChgXprTpCd);
				// XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력은
				// PSO_CHG_XPR_DTL 생성후 업데이트 처리함
				insertPsoChgXprVO.setUpdMnuNo("2"); // 0002:1, 0004:2
				insertPsoChgXprVO.setCreUsrId(vCreUsrId);
				insertPsoChgXprVO.setUpdUsrId(vCreUsrId);
				dbDao.mergePsoChgXpr(insertPsoChgXprVO); // 신규

				// PSO_CHG_XPR_DTL Insert 다건 (신규)
				for (int i = 0; i < arrBaseFomlCond.length; i++) {
					sheet1_uk = arrBaseFomlCond[i].getUk();
					sheet1_fomlNo = arrBaseFomlCond[i].getFormulaNo();
					sheet1_condNo = arrBaseFomlCond[i].getCondition();

					sheet1_dfltFomlFlg = "1".equals(arrBaseFomlCond[i].getDefault2()) ? "Y" : "N";

					sheet1_psoCtrlStmtTpCd = "".equals(sheet1_condNo) ? "4" : "1"; // Condition이 없으면 4, 있으면 1

					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet1_chgXprNo); // Key 1
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + ""); // Key 2
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(sheet1_psoCtrlStmtTpCd); // Condition  有 :1,Condition 無 :4
					insertPsoChgXprDtlVO.setDfltFomlFlg(sheet1_dfltFomlFlg);
					insertPsoChgXprDtlVO.setCondNo(sheet1_condNo);
					insertPsoChgXprDtlVO.setFomlNo(sheet1_fomlNo);
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					insertPsoChgXprDtlVO.setUpdUsrId(vCreUsrId);
					
					insertPsoChgXprDtlVO.setCondAlsNm(arrBaseFomlCond[i].getCondAlsNm()); //2015.09.21 Add
					
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);

					hashUkChgXprSeq.put(sheet1_uk, i + 1 + "");
					hashUkSeqTrfSeq.put(sheet1_uk, new HashMap<String, String>());

					// Formula에 속한 Object 구해놓기 (PSO_TARIFF:Base 저장시, Formula에 속한
					// Object인지 체크하기 위해)
					List<PsoObjListVO> psoObjListVO = dbDao.searchObjectsByFormula(sheet1_fomlNo);
					StringBuffer objectsByFormula = new StringBuffer(",");
					for (int j = 0; j < psoObjListVO.size(); j++) {
						objectsByFormula.append(psoObjListVO.get(j).getObjListNo() + ",");
					}
					hashUkObject.put(sheet1_uk, objectsByFormula.toString());
				}

				// PSO_YD_CHG_XPR 단건 (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("B");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);

			}

			// [Surcharge]
			if (arrSurcharge != null && arrSurcharge.length > 0) {
				if ("".equals(sheet4_chgXprNo)) {
					// PSO_CHG_XPR Insert (채번, 신규)
					sheet4_chgXprNo = dbDao.searchPsoChgXprPK(); // 채번
					// sheet4_chgXprSeq += "1";
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet4_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7"); // Surcharge, Discount는 7
					// XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC
					// 입력要
					// insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("2"); // 0002:1, 0004:2
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					
					dbDao.mergePsoChgXpr(insertPsoChgXprVO); // 신규
				}

				// PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("S");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet4_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}

			// [Discount]
			if (arrDiscount != null && arrDiscount.length > 0) {
				if ("".equals(sheet5_chgXprNo)) {
					// PSO_CHG_XPR Insert (채번, 신규)
					sheet5_chgXprNo = dbDao.searchPsoChgXprPK(); // 채번
					// sheet5_chgXprSeq += "1";
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet5_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7"); // Surcharge, Discount는 7

					// insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("2"); // 0002:1, 0004:2
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO); // 신규
				}

				// PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("D");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet5_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}

			/***************************************************************************************************************************************
			 * 5. (PSO_CHG_XPR_DTL,) PSO_TARIFF, PSO_TRF_DTL 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * [Base] - FOML_NO Map Creation (OBJ_LIST_NO, RATE_TYPE) -
			 * PSO_TARIFF 채번, 신규 - PSO_TRF_DTL 신규 [Surcharge] - PSO_CHG_XPR_DTL
			 * 신규 - PSO_TARIFF 채번, 신규 - PSO_TRF_DTL 신규 [Discount] -
			 * PSO_CHG_XPR_DTL 신규 - PSO_TARIFF 채번, 신규 - PSO_TRF_DTL 신규
			 ***************************************************************************************************************************************/
			// [Base]
			if (arrBase != null && arrBase.length > 0) {
				String newPortTrfNo = "";
				int trfSeq = 1;
				List<PsoTrfDtlVO> insert4BasePsoTrfDtlVOs = new ArrayList<PsoTrfDtlVO>();

				// FOML_NO Map Creation (OBJ_LIST_NO, RATE_TYPE)
				List<PsoFormulaVO> fomlNoList = dbDao.searchFomlNoByObjAndType("", "");
				Map<String, String> mapFomlNo = new HashMap<String, String>();
				for (int i = 0; i < fomlNoList.size(); i++) {
					// Key -> RT_OBJ_LIST_NO + ":" + FOML_SEQ
					// Value -> FOML_NO
					mapFomlNo.put(fomlNoList.get(i).getCreUsrId(), fomlNoList.get(i).getFomlNo());
				}

				for (int i = 0; i < arrBase.length; i++) {
					sheet6_uk = arrBase[i].getUk();
					sheet6_seq = arrBase[i].getSeq();
					// sheet6_psoObjCd = arrBase[i].getObject();
					// sheet6_psoMeasUtCd = arrBase[i].getObjectCode();
					sheet6_psoTrfTpCd = arrBase[i].getRateCode();
					sheet6_objListNo = arrBase[i].getObjListNo();
					if ("".equals(sheet6_objListNo)) {
						throw new EventException(new ErrorHandler("PSO90002", new String[] { "Object List No " }).getMessage());
					}

					// 선택한 Object가 Formula에 없을때
					if (hashUkObject.get(sheet6_uk).indexOf("," + sheet6_objListNo + ",") < 0) {
						throw new EventException(new ErrorHandler("PSO90002", new String[] { "Please input 'Object Code' that belongs to 'Formula Code'" }).getMessage());
					}

					// /List<PsoFormulaVO> fomlNoList =
					// dbDao.searchFomlNoByObjAndType(sheet6_objListNo,
					// sheet6_psoTrfTpCd);
					/*
					 * if(fomlNoList.size() > 0){ sheet6_fomlNo =
					 * fomlNoList.get(0).getFomlNo(); } else{ throw new
					 * EventException(new ErrorHandler("PSO90002", new
					 * String[]{"[Formula No] "}).getMessage()); }
					 */

					// Fomular No를 Map에서 꺼낸다.
					String psoTrfTpCd = sheet6_psoTrfTpCd.equals("R") ? "3" : (sheet6_psoTrfTpCd.equals("S") ? "1" : "3"); // DECODE(@[pso_trf_tp_cd], 'R',3,'S', 1,'F',3)
					if (mapFomlNo.containsKey(sheet6_objListNo + ":" + psoTrfTpCd)) {
						sheet6_fomlNo = mapFomlNo.get(sheet6_objListNo + ":" + psoTrfTpCd);
					} else {
						throw new EventException(new ErrorHandler("PSO90002", new String[] { "[Formula No] " + "OBJ_LIST_NO=" + sheet6_objListNo + ", TYPE=" + sheet6_psoTrfTpCd }).getMessage());
					}

					sheet6_condNo = arrBase[i].getCondition();
					sheet6_fmVal = arrBase[i].getRangeFrom().replace(":", "").replace(",", "");
					sheet6_toVal = arrBase[i].getRangeTo().replace(":", "").replace(",", "");
					sheet6_trfRtAmt = arrBase[i].getRateValue();
					sheet6_consAlsNm = arrBase[i].getConsAlsNm();

					if (hashUkSeqTrfSeq.get(sheet6_uk).get(sheet6_seq) == null) {

						// PSO_TARIFF 채번
						newPortTrfNo = dbDao.searchPsoTariffPK();
						// PSO_TARIFF 입력
						List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
						PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
						insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
						insertPsoTariffVO.setPsoTrfTpCd(sheet6_psoTrfTpCd);
						insertPsoTariffVO.setFomlNo(sheet6_fomlNo);
						insertPsoTariffVO.setFomlSeq("2"); // 단순은 1
						insertPsoTariffVO.setChgXprNo(sheet1_chgXprNo); // PSO_CHG_XPR.CHG_XPR_NO는 하나뿐임
						insertPsoTariffVO.setChgXprSeq(hashUkChgXprSeq.get(sheet6_uk));
						insertPsoTariffVO.setObjListNo(sheet6_objListNo);
						insertPsoTariffVO.setCurrCd(vCurrency);
						insertPsoTariffVO.setPsoRtTpCd(null);
						insertPsoTariffVO.setDpNo(sheet6_seq);
						insertPsoTariffVO.setConsAlsNm(sheet6_consAlsNm);
						insertPsoTariffVO.setCreUsrId(vCreUsrId);
						insertPsoTariffVOList.add(insertPsoTariffVO);
						dbDao.addTariff(insertPsoTariffVOList);

						hashUkSeqTrfSeq.get(sheet6_uk).put(sheet6_seq, newPortTrfNo);

						trfSeq = 1;

					} else {
						trfSeq++;
					}

					/*
					 * PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					 * insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					 * insertPsoTrfDtlVO.setTrfSeq(trfSeq + "");
					 * insertPsoTrfDtlVO.setFmVal(sheet6_fmVal);
					 * insertPsoTrfDtlVO.setToVal(sheet6_toVal);
					 * insertPsoTrfDtlVO.setTrfRtAmt(sheet6_trfRtAmt);
					 * insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					 * insertPsoTrfDtlVO.setCondNo(sheet6_condNo);
					 * dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
					 */

					// PSO_TRF_DTL 입력 (executeBatch)
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq(trfSeq + "");
					insertPsoTrfDtlVO.setFmVal(sheet6_fmVal);
					insertPsoTrfDtlVO.setToVal(sheet6_toVal);
					insertPsoTrfDtlVO.setTrfRtAmt(sheet6_trfRtAmt);
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(sheet6_condNo);
					insert4BasePsoTrfDtlVOs.add(insertPsoTrfDtlVO);
				}

				// dbDao.addPsoTrfDtl(insert4BasePsoTrfDtlVOs.get(insert4BasePsoTrfDtlVOs.size()-1));
				dbDao.addPsoTrfDtl(insert4BasePsoTrfDtlVOs);
			}

			// [Surcharge]
			if (arrSurcharge != null && arrSurcharge.length > 0) {

				for (int i = 0; i < arrSurcharge.length; i++) {
					// PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet4_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrSurcharge[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrSurcharge[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					
					insertPsoChgXprDtlVO.setCondAlsNm(arrSurcharge[i].getCondAlsNm());//2015.09.21 Add

					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);

					// PSO_TARIFF 채번
					String newPortTrfNo = dbDao.searchPsoTariffPK();
					// PSO_TARIFF 입력
					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");
					insertPsoTariffVO.setChgXprNo(sheet4_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrSurcharge[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);

					// PSO_TRF_DTL 입력
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrSurcharge[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}

			}

			// [Discount]
			if (arrDiscount != null && arrDiscount.length > 0) {

				for (int i = 0; i < arrDiscount.length; i++) {
					// PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet5_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrDiscount[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrDiscount[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					
					insertPsoChgXprDtlVO.setCondAlsNm(arrDiscount[i].getCondAlsNm());//2015.09.21 Add
					
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);

					// PSO_TARIFF 채번
					String newPortTrfNo = dbDao.searchPsoTariffPK();
					// PSO_TARIFF 입력
					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");
					insertPsoTariffVO.setChgXprNo(sheet5_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrDiscount[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);

					// PSO_TRF_DTL 입력
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrDiscount[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
			}

			/***************************************************************************************************************************************
			 * 6. PSO_CHG_XPR 테이블에 Description Update
			 *************************************************************************************************************************************** 
			 * [Base] - PSO_CHG_XPR Description Update [Surcharge] - PSO_CHG_XPR
			 * Description Update [Discount] - PSO_CHG_XPR Description Update
			 ***************************************************************************************************************************************/
			// [Base]
			if (arrBase != null && arrBase.length > 0) {
				if (dbDao.modifyChgXprDescByChgXprNo(sheet1_chgXprNo) < 1) {
					throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expression Description, Base" }).getMessage()); // Unexpected Error Occurred.
				}
			}

			// [Surcharge]
			if (arrSurcharge != null && arrSurcharge.length > 0) {
				if (dbDao.modifyChgXprDescByChgXprNo(sheet4_chgXprNo) < 1) {
					throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expression Description, Surcharge" }).getMessage()); // Unexpected Error Occurred.
				}
			}

			// [Discount]
			if (arrDiscount != null && arrDiscount.length > 0) {
				if (dbDao.modifyChgXprDescByChgXprNo(sheet5_chgXprNo) < 1) {
					throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expression Description, Discount" }).getMessage()); // Unexpected Error Occurred.
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Tariff Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Tariff Creation" }).getMessage(), de);
		}
	}

	/**
	 * Retrieve by Condition/Formula chosen
	 * 
	 * @param UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO
	 * @return List<UseStatusConditonFormulaDtlVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaDtlVO> searchUseIdConditonFormulaDetail(UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO) throws EventException {
		List<UseStatusConditonFormulaDtlVO> list = null;
		try {
			if ("C".equalsIgnoreCase(useStatusConditonFormulaDtlVO.getIdTp())) {
				list = dbDao.searchUseIdConditonDetail(useStatusConditonFormulaDtlVO); // Condition
			} else if ("F".equalsIgnoreCase(useStatusConditonFormulaDtlVO.getIdTp())) {
				list = dbDao.searchUseIdFormulaDetail(useStatusConditonFormulaDtlVO); // Formula
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Condition/Formula" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Condition/Formula" }).getMessage(), de);
		}

		return list;
	}

	/**
	 * Retrieve Tariff List(Account/Vendor/Update ID/Update Date) by Terminal
	 * 
	 * @category VOP_PSO_0036_RetrieveBtnClick
	 * @param String ydCd
	 * @param String year
	 * @return List<PortTariffListVO>
	 * @throws EventException
	 */
	public List<PortTariffListVO> searchPortTariffList(String ydCd, String year) throws EventException {
		try {

			return dbDao.searchPortChargeList(ydCd, year);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff List" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff List" }).getMessage(), de);
		}
	}

	/**
	 * Retrieve Effective Date necessary in case of Charge Creation(Invoice creation)
	 * 
	 * @category VOP_PSO_0036_VerClick
	 * @param PortTariffListVO portTariffListVO
	 * @return List<EffectiveDateListVO>
	 * @throws EventException
	 */
	public List<EffectiveDateListVO> searchDistinctEffectiveDateList(PortTariffListVO portTariffListVO) throws EventException {
		try {

			return dbDao.searchDistinctEffectiveDateList(portTariffListVO);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Charge Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Charge Creation" }).getMessage(), de);
		}
	}

	/**
	 * Retrieve version of Effective Date necessary in case of Charge
	 * Creation(Invoice creation)
	 * 
	 * @category VOP_PSO_0036_EffDateClick
	 * @param PortTariffListVO portTariffListVO
	 * @return List<YardChargeVersionVO>
	 * @throws EventException
	 */
	public List<YardChargeVersionVO> searchYardChargeVersion(PortTariffListVO portTariffListVO) throws EventException {
		try {

			return dbDao.searchYardChargeVersion(portTariffListVO);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Charge Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Charge Creation" }).getMessage(), de);
		}
	}

	/**
	 * PSO yard Charge 정보와 비교하여 조건에 따흔 Account Code를 조회한다.
	 * 
	 * @category VOP_PSO_0036_Account Code
	 * @param String ydCd
	 * @param String year
	 * @param String updMnuNo
	 * @return List<AccountAndCostVO>
	 * @throws EventException
	 */
	public List<AccountAndCostVO> searchAccountAndCostByCondition(String ydCd, String year, String updMnuNo) throws EventException {
		try {

			return dbDao.searchAccountAndCostByCondition(ydCd, year, updMnuNo);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12244").getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12244").getMessage(), de);
		}
	}

	/**
	 * Retrieve Formula info in case of Clicking Retreive button on Formula N'
	 * Condition Creation page
	 * 
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormula(String formulaNo) throws EventException {
		try {

			return dbDao.searchPsoFormula(formulaNo);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), de);
		}
	}

	/**
	 * Retrieve Formula Info in case of Clicking Retrieve Button of Formula N'
	 * Condition Creation page (for Hidden Grid )
	 * 
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormulaSys(String formulaNo) throws EventException {
		try {

			return dbDao.searchPsoFormulaSys(formulaNo);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), de);
		}
	}

	/**
	 * Retrieve Condition Info in case of Clicking Retrieve Button of Formula N'
	 * Condition Creation page
	 * 
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchCondition(String conditionNo) throws EventException {
		try {

			return dbDao.searchPsoCondition(conditionNo);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), de);
		}
	}

	/**
	 * Retrieve Condition Info in case of Clicking Retrieve Button of Formula N'
	 * Condition Creation page (for Hidden Grid)
	 * 
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchConditionSys(String conditionNo) throws EventException {
		try {

			return dbDao.searchPsoConditionSys(conditionNo);

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula N' Condition Creation" }).getMessage(), de);
		}
	}

	/**
	 * Handling in case of clicking Delete Button of Formula N' Condition
	 * Creation page
	 * 
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param String formulaNo
	 * @throws EventException
	 */
	public void removeFormula(String formulaNo) throws EventException {
		try {

			String[] arrCheckFoml = dbDao.checkFormulaUsing(formulaNo);
			String bUsed = arrCheckFoml[0];
			String updMnuNo = arrCheckFoml[1];

			if (!bUsed.equals("0") && !updMnuNo.equals("2")) {
				// NYK Modify 2014.11.07
				throw new EventException(new ErrorHandler("PSO00027").getMessage()); // Can't update data due to internal system formula
				//throw new EventException(new ErrorHandler("PSO90001", new String[] { "The formula that you want to delete isn't created by this program." }).getMessage());
			}

			if (bUsed.equals("0")) {
				return;
			} else if (bUsed.equals("1")) {//
				dbDao.removeFormulaDetail(formulaNo);
				dbDao.removeFormula(formulaNo);
				log.debug("bUsed:>>>" + bUsed);
			} else {// ServerMessage Throw?
				throw new EventException(new ErrorHandler("PSO97001").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Formula N' Condition Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Formula N' Condition Creation" }).getMessage(), de);
		}
	}

	/**
	 * Handling in case of clicking Delete Button of Formula N' Condition
	 * Creation page
	 * 
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param String conditionNo
	 * @throws EventException
	 */
	public void removeCondition(String conditionNo) throws EventException {
		try {

			String[] arrCheckFoml = dbDao.checkConditionUsing(conditionNo);
			String bUsed = arrCheckFoml[0];
			// String updMnuNo = arrCheckFoml[1];

			// if(!bUsed.equals("0") && !updMnuNo.equals("2")){

			// throw new EventException(new ErrorHandler("PSO90001", new
			// String[]{"The condition that you want to delete isn't created by this program."}).getMessage());
			// }

			if (bUsed.equals("0")) {
				return;
			} else if (bUsed.equals("1")) {//
				dbDao.removeConditionDetail(conditionNo);
				dbDao.removeCondtion(conditionNo);
				log.debug("bUsed:>>>" + bUsed);
			} else {// ServerMessage Throw?
				throw new EventException(new ErrorHandler("PSO97002").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Formula N' Condition Creation" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90012", new String[] { "Formula N' Condition Creation" }).getMessage(), de);
		}
	}

	/**
	 * Save Condition Info
	 * 
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param FormulaGRPVO formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageCondition(FormulaGRPVO formulaGRPVO) throws EventException {
		String newId = "";
		String id = formulaGRPVO.getId().trim() + "";

		try {

			String bVal = dbDao.validateFormulaCondition(formulaGRPVO, "2");

			if (!bVal.equals("Y")) {
				throw new EventException(new ErrorHandler("PSO90001", new String[] { "validation pass failed" }).getMessage());
			}

			String[] arrCheckFoml = dbDao.checkConditionUsing(id);
			String bUsed = arrCheckFoml[0];
			// String updMnuNo = arrCheckFoml[1];

			// if(!bUsed.equals("0") && !updMnuNo.equals("2")){
			// throw new EventException(new ErrorHandler("PSO90001", new
			// String[]{"The condition that you want to update isn't created by this program."}).getMessage());
			// }

			if (bUsed.equals("0")/* && "".equals(id) */) {
				// newId = dbDao.searchPsoConditionPK();
				// formulaGRPVO.setId(newId);
				dbDao.addPsoCondition(formulaGRPVO);
				dbDao.addPsoConditionDetail(formulaGRPVO);
				log.debug("bUsed:>>>" + bUsed);
				// } else if(bUsed.equals("0") && !"".equals(id)){

			} else if (bUsed.equals("1")) {
				dbDao.modifyPsoCondition(formulaGRPVO);
				dbDao.removeConditionDetail(id);
				dbDao.addPsoConditionDetail(formulaGRPVO);
			} else if (bUsed.equals("2")) {
				throw new EventException(new ErrorHandler("PSO97002").getMessage());
			}

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Condition" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Condition" }).getMessage(), de);
		}

		return newId;
	}

	/**
	 * Save Formula Info
	 * 
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param FormulaGRPVO formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageFormula(FormulaGRPVO formulaGRPVO) throws EventException {
		String newId = "";
		String id = formulaGRPVO.getId().trim() + "";

		try {
			// 입력한 Formula가 Valid한지 체크
			String bVal = dbDao.validateFormulaCondition(formulaGRPVO, "1");

			if (!bVal.equals("Y")) {
				throw new EventException(new ErrorHandler("PSO90001", new String[] { "validation pass failed" }).getMessage());
			}

			// 해당 Formula가 Charge Expression Detail 에서 사용되고 있는지 확인한다.
			String[] arrCheckFoml = dbDao.checkFormulaUsing(id);
			String bUsed = arrCheckFoml[0];
			String updMnuNo = arrCheckFoml[1];

			if (!bUsed.equals("0") && !updMnuNo.equals("2")) {
				// NYK Modify 2014.11.07
				throw new EventException(new ErrorHandler("PSO00027").getMessage()); // Can't update data due to internal system formula
				
				// throw new EventException(new ErrorHandler("PSO90001", new
				// String[]{"The formula that you want to update isn't created by this program."}).getMessage());
			}

			if (bUsed.equals("0")/* && "".equals(id) */) { // 신규 처리
				// if(formulaGRPVO.getFormulaVOs()==null) return;
				// newId = dbDao.searchPsoFormulaPK();
				// formulaGRPVO.setId(newId);
				dbDao.addPsoFormula(formulaGRPVO);
				dbDao.addPsoFormulaDetail(formulaGRPVO);
				log.debug("bUsed:>>>" + bUsed);
				// } else if(bUsed.equals("0") && !"".equals(id)){

			} else if (bUsed.equals("1")) {// FORMULA 존재 하나 사용되지 않을 경우
				// if(formulaGRPVO.getFormulaVOs()==null) return;
				dbDao.modifyPsoFormula(formulaGRPVO);
				dbDao.removeFormulaDetail(id);
				dbDao.addPsoFormulaDetail(formulaGRPVO);
			} else if (bUsed.equals("2")) {// FORMULA 존재 하고 사용 중인 경우
				throw new EventException(new ErrorHandler("PSO97001").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Formula" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Formula" }).getMessage(), de);
		}

		return newId;
	}

	/**
	 * Retrieve Formula No Info in case of loading page
	 * 
	 * @category VOP_PSO_0002_Loading
	 * @return List<PsoFormulaVO>
	 * @throws EventException
	 */
	public List<PsoFormulaVO> searchFormulaNoForLoading() throws EventException {
		try {
			return dbDao.searchFormulaNoForLoading();
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Formula" }).getMessage(), de);
		}
	}

	/**
	 * Save Condition
	 * 
	 * @category VOP_PSO_0206_OKBtnClick
	 * @param ConditionVO[] conditionVOs
	 * @return String
	 * @throws EventException
	 */
	public String manageConditionByPopup(ConditionVO[] conditionVOs) throws EventException {

		try {

			String condition = ""; // AND or OR
			String objListNo = ""; // OBJ_LIST_NO
			String operator = ""; // Comparison Operator
			String value = ""; // Value

			String condDesc = ""; // Condition Description
			String condSysDesc = ""; // Condition System Description

			// String newCondNo = dbDao.searchPsoConditionPK();
			String newCondNo = dbDao.searchPsoConditionContinuousPK();

			PsoConditionVO psoConditionVO = new PsoConditionVO();
			psoConditionVO.setCondNo(newCondNo);
			psoConditionVO.setUpdMnuNo("1");
			psoConditionVO.setCreUsrId(conditionVOs[0].getCreUsrId());
			psoConditionVO.setUpdUsrId(conditionVOs[0].getCreUsrId());

			dbDao.addPsoConditionByRow(psoConditionVO);

			int sizePsoCondDtlVOList = 0;
			List<PsoCondDtlVO> psoCondDtlVOList = new ArrayList<PsoCondDtlVO>();

			if (conditionVOs != null && conditionVOs.length > 0) {
				for (int i = 0; i < conditionVOs.length; i++) {

					condition = conditionVOs[i].getCondition(); // AND or OR
					objListNo = conditionVOs[i].getObjListNo(); // OBJ_LIST_NO
					operator = conditionVOs[i].getOperator(); // Comparison
																// Operator
					value = conditionVOs[i].getObjValue(); // Value

					int rows = 0;

					rows = (i == 0) ? 3 : 4;

					for (int j = 0; j < rows; j++) {
						++sizePsoCondDtlVOList;
						PsoCondDtlVO psoCondDtlVO = new PsoCondDtlVO();
						if (sizePsoCondDtlVOList % 4 == 1) {
							psoCondDtlVO.setPsoCondDtlTpCd("O");
							psoCondDtlVO.setPsoCondOprCd(null);
							psoCondDtlVO.setObjListNo(objListNo);
							psoCondDtlVO.setCondOprValCtnt(null);
						} else if (sizePsoCondDtlVOList % 4 == 2) {
							psoCondDtlVO.setPsoCondDtlTpCd("P");
							psoCondDtlVO.setPsoCondOprCd(operator);
							psoCondDtlVO.setObjListNo("-1");
							psoCondDtlVO.setCondOprValCtnt(null);
						} else if (sizePsoCondDtlVOList % 4 == 3) {
							psoCondDtlVO.setPsoCondDtlTpCd("C");
							psoCondDtlVO.setPsoCondOprCd(null);
							psoCondDtlVO.setObjListNo("-1");

							value = "Y".equalsIgnoreCase(value) || "N".equalsIgnoreCase(value) ? "'" + value + "'" : value;
							psoCondDtlVO.setCondOprValCtnt(value);
						} else if (sizePsoCondDtlVOList % 4 == 0) {
							psoCondDtlVO.setPsoCondDtlTpCd("P");
							psoCondDtlVO.setPsoCondOprCd(condition);
							psoCondDtlVO.setObjListNo("-1");
							psoCondDtlVO.setCondOprValCtnt(null);
						}
						psoCondDtlVO.setCondNo(newCondNo);
						psoCondDtlVO.setCondSeq(sizePsoCondDtlVOList + "");
						psoCondDtlVO.setRowNo((i + 1) * 10 + "");
						psoCondDtlVO.setCreUsrId(conditionVOs[0].getCreUsrId());
						psoCondDtlVO.setUpdUsrId(conditionVOs[0].getCreUsrId());

						psoCondDtlVOList.add(psoCondDtlVO);
					}
				}
			}

			// PSO_CONDITION
			for (int i = 0; i < psoCondDtlVOList.size(); i++) {
				dbDao.addPsoCondDtlByRow(psoCondDtlVOList.get(i));
			}

			// COND_DESC, COND_SYS_DESC
			// condDesc = ""; //Unique
			List<PsoConditionVO> descPsoConditionVOList = dbDao.searchTariffConditionDesc(newCondNo);
			condDesc = descPsoConditionVOList.get(0).getCondDesc();
			condSysDesc = descPsoConditionVOList.get(0).getCondSysDesc();

			List<PsoConditionVO> psoConditionVOList = new ArrayList<PsoConditionVO>();
			PsoConditionVO updatePsoConditionVO = new PsoConditionVO();
			updatePsoConditionVO.setCondNo(newCondNo);
			updatePsoConditionVO.setCondNm("");
			updatePsoConditionVO.setCondDesc(condDesc);
			updatePsoConditionVO.setCondSysDesc(condSysDesc);
			updatePsoConditionVO.setUpdMnuNo("1");
			updatePsoConditionVO.setCreUsrId(conditionVOs[0].getCreUsrId());
			updatePsoConditionVO.setUpdUsrId(conditionVOs[0].getCreUsrId());
			psoConditionVOList.add(updatePsoConditionVO);
			dbDao.modifyPsoCondition(psoConditionVOList);

			return newCondNo + "||" + condDesc;

		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Condition Creation" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Condition Creation" }).getMessage(), ex);
		}

	}

	/**
	 * Retrieve in case of loading page
	 * 
	 * @category VOP_PSO_0206_Open
	 * @param String condNo
	 * @return List<SearchTariffConditionVO>
	 * @throws EventException
	 */
	public List<SearchTariffConditionVO> searchTariffCondition(String condNo) throws EventException {
		try {
			return dbDao.searchTariffCondition(condNo);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Condition" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Condition" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve LOCAL CURRENCY by PORT_CD
	 * 
	 * @param String portCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLocalCurrencyByPortCd(String portCd) throws EventException {
		try {
			return dbDao.searchLocalCurrencyByPortCd(portCd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Local Currency" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Local Currency" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve OBJECT
	 * 
	 * @category VOP_PSO_0004_
	 * @param String psoObjListTpCd
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchPsoObjListByPsoObjListTpCd(String psoObjListTpCd) throws EventException {
		try {
			return dbDao.searchPsoObjListByPsoObjListTpCd(psoObjListTpCd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Object" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Object" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve DFLT_VAL info by YD_CHG_NO, YD_CHG_VER_SEQ, OBJ_LIST_NO
	 * 
	 * @category VOP_PSO_0004_
	 * @param PsoYdChgObjListVO psoYdChgObjListVO
	 * @return List<YdChgObjVO>
	 * @throws EventException
	 */
	public List<YdChgObjVO> searchPsoYdChgObjListByPK(PsoYdChgObjListVO psoYdChgObjListVO) throws EventException {
		try {
			return dbDao.searchPsoYdChgObjListByPK(psoYdChgObjListVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Default Value" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Default Value" }).getMessage(), ex);
		}
	}

	/**
	 * [PSO_YD_CHD] Vendor 정보를 조회한다.
	 * 
	 * @category VOP_PSO_0211,2
	 * @param String ydCd
	 * @param String costCd
	 * @param String year
	 * @param String uid
	 * @param String acctcd
	 * @return List<MdmVendorVO>
	 * @throws EventException
	 */
	public List<MdmVendorVO> searchVendorByYardAndCost(String ydCd, String costCd, String year, String uid, String acctcd) throws EventException {
		try {
			return dbDao.searchVendorByYardAndCost(ydCd, costCd, year, uid, acctcd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Vendor" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Vendor" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve all Account & Cost
	 * 
	 * @category VOP_PSO_0037
	 * @param String ofcCd
	 * @return List<CostCodeVO>
	 * @throws EventException
	 */
	public List<CostCodeVO> searchAccountAndCost(String ofcCd) throws EventException {
		try {
			return dbDao.searchAccountAndCost(ofcCd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Account & Cost" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Account & Cost" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Tariff Value Management
	 * 
	 * @category VOP_PSO_0037
	 * @param YardChargeVO yardChargeVO
	 * @return List<YardChargeVO>
	 * @throws EventException
	 */
	public List<YardChargeVO> searchYardChargeList(YardChargeVO yardChargeVO) throws EventException {
		try {
			return dbDao.searchYardChargeList(yardChargeVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Value Management" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff Value Management" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object by YD_CHG_NO, YD_CHG_VER_SEQ
	 * 
	 * @category VOP_PSO_0037
	 * @param YdChgObjVO ydChgObjVO
	 * @return List<YdChgObjVO>
	 * @throws EventException
	 */
	public List<YdChgObjVO> searchObjByYdChg(YdChgObjVO ydChgObjVO) throws EventException {
		try {
			return dbDao.searchObjByYdChg(ydChgObjVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Regular Value Management" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Regular Value Management" }).getMessage(), ex);
		}
	}

	/**
	 * Save Tariff Value List
	 * 
	 * @category VOP_PSO_0037
	 * @param TariffValueMgtGRPVO tariffValueMgtGRPVO
	 * @throws EventException
	 */
	public void manageTariffValue(TariffValueMgtGRPVO tariffValueMgtGRPVO) throws EventException {

		HashMap<String, String> retHash = new HashMap<String, String>();
		try {
			YardChargeVO[] yardChargeVOs = tariffValueMgtGRPVO.getYardChargeVOs(); // Master
			YdChgObjVO[] ydChgObjVOs = tariffValueMgtGRPVO.getYdChgObjVOs(); // Detail

			if (yardChargeVOs != null) {
				String ydChgNo = "";
				String ydChgVerSeq = "";
				String expDt = "";
				String cplsFlg = "";
				for (int i = 0; i < yardChargeVOs.length; i++) {
					ydChgNo = yardChargeVOs[i].getYdChgNo();
					ydChgVerSeq = yardChargeVOs[i].getYdChgVerSeq();
					expDt = (yardChargeVOs[i].getExpDt() + "").replace("-", "");
					cplsFlg = yardChargeVOs[i].getCplsFlg();

					// if("O".equals(checkExpDateForTariffMgt(yardChargeVOs[i]))){
					if ("O".equals(dbDao.checkExpDateForTariffMgt(yardChargeVOs[i]))) {
						dbDao.modifyPsoYdChgExpDtCplsFlgByNo(ydChgNo, ydChgVerSeq, expDt, cplsFlg);
					} else {
						// throw new EventException(new ErrorHandler("PSO90001",
						// new
						// String[]{"validation pass failed"}).getMessage());
						retHash.put(yardChargeVOs[i].getYdChgNo() + ":" + yardChargeVOs[i].getYdChgVerSeq(), "X");
					}
				}
			}

			if (ydChgObjVOs != null) {

				if (ydChgObjVOs.length > 0) {
					PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
					deletePsoYdChgObjListVO.setYdChgNo(ydChgObjVOs[0].getYdChgNo());
					deletePsoYdChgObjListVO.setYdChgVerSeq(ydChgObjVOs[0].getYdChgVerSeq());
					deletePsoYdChgObjListVO.setObjListNo("");
					dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
				}

				for (int i = 0; i < ydChgObjVOs.length; i++) {
					if (!StringUtils.isEmpty(ydChgObjVOs[i].getRegularValue())) {
						PsoYdChgObjListVO insertPsoYdChgObjListVO = new PsoYdChgObjListVO();
						
						String tmpReqularValue 	= ydChgObjVOs[i].getRegularValue();
						String tmpObjListNo 	= ydChgObjVOs[i].getObjListNo();
						String tmpPsoMeasUtCd 	= ydChgObjVOs[i].getPsoMeasUtCd();
						String tmpDfltVal		= "";
						String tmpDfltFlg		= "";
						
						if(!StringUtils.isEmpty(tmpPsoMeasUtCd) && "12".equals(tmpPsoMeasUtCd) && !"77".equals(tmpObjListNo) && !"89".equals(tmpObjListNo)){
							tmpDfltFlg	= tmpReqularValue;
						}else{
							tmpDfltVal	= tmpReqularValue;
						}
						
						insertPsoYdChgObjListVO.setYdChgNo(ydChgObjVOs[i].getYdChgNo());
						insertPsoYdChgObjListVO.setYdChgVerSeq(ydChgObjVOs[i].getYdChgVerSeq());
						insertPsoYdChgObjListVO.setObjListNo(ydChgObjVOs[i].getObjListNo());
						insertPsoYdChgObjListVO.setDfltCtnt("");
						insertPsoYdChgObjListVO.setDfltVal(tmpDfltVal);
						insertPsoYdChgObjListVO.setDfltFlg(tmpDfltFlg);
						insertPsoYdChgObjListVO.setCreUsrId(tariffValueMgtGRPVO.getAccount().getUsr_id());
						dbDao.mergePsoYdChgObjList(insertPsoYdChgObjListVO);
					}
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Tariff Value Management" }).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Tariff Value Management" }).getMessage(), de);
		}
	}

	/**
	 * check validation of Expired Date : VOP_PSO_0037
	 * 
	 * @param YardChargeVO yardChargeVO
	 * @return String
	 * @exception EventException
	 */
	public String checkExpDateForTariffMgt(YardChargeVO yardChargeVO) throws EventException {
		try {
			return dbDao.checkExpDateForTariffMgt(yardChargeVO);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expired Date" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Invalid Expired Date" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Tariff List which contains PortCd and CostCd
	 * 
	 * @param String portCd
	 * @param String costCd
	 * @return List<TariffListWithYdNmVO>
	 * @exception EventException
	 */
	public List<TariffListWithYdNmVO> searchTariffWithCostCd(String portCd, String costCd) throws EventException {
		try {
			return dbDao.searchTariffWithCostCd(portCd, costCd);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff List" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[] { "Tariff List" }).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Object List
	 * 
	 * @param String objNm
	 * @return List<PsoObjListVO>
	 * @exception EventException
	 */
	public List<PsoObjListVO> searchObjBasicAll(String objNm) throws EventException {
		try {
			return dbDao.searchObjBasicAll(objNm);
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Object List" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[] { "Object List" }).getMessage(), ex);
		}

	}
	
	/**
	 * Save Object List
	 * 
	 * @param PsoObjListVO[] psoObjListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageObjectList(PsoObjListVO[] psoObjListVOS, SignOnUserAccount account) throws EventException {
		try {
			String newObjNo = "";
			for (PsoObjListVO psoObjectListVO : psoObjListVOS) {
				log.debug("manageObjectList IbFlag ======== [" + psoObjectListVO.getIbflag() + "]");
				if ("I".equals(psoObjectListVO.getIbflag())) { // Insert
					newObjNo = dbDao.searchMaxObjNo();
					psoObjectListVO.setObjListNo(newObjNo);
					psoObjectListVO.setCreUsrId(account.getUsr_id());
					dbDao.addNewobject(psoObjectListVO); // Insert PSO_OBJ_LIST
					String psoMeasUtCd = psoObjectListVO.getPsoMeasUtCd();
					// 2015.02.13 ADD FLAG 일때는 수식을 만들 필요가 없다.
					// 2016.03.07 FLAG(12), CODE(14), DATE(16), DAY(17) 디폴트 Formula 생성하지 않는다.
					boolean isNotFormula = true;
					if(PsoConstants.MEAS_UNIT_CD_CODE.equals(psoMeasUtCd) || PsoConstants.MEAS_UNIT_CD_DATE.equals(psoMeasUtCd) || 
					   PsoConstants.MEAS_UNIT_CD_DAY.equals(psoMeasUtCd)  || PsoConstants.MEAS_UNIT_CD_FLAG.equals(psoMeasUtCd) ||
					   PsoConstants.MEAS_UNIT_CD_TIME.equals(psoMeasUtCd)){
						isNotFormula = false;
					}
					
					if (isNotFormula) {
						// PSO_FORMULA 1개의 레코드 Insert
						// ObjNm + " RATE" 1개 Row만 Insert 한다.
						String newFomlNo = addBasicFormula(psoObjectListVO, account);

						// PSO_FOML_DTL 1개의 레코드만 Insert
						addBasicFomlDtl(psoObjectListVO, newFomlNo, account);
					}
				} else if ("U".equals(psoObjectListVO.getIbflag())) { // Update
					psoObjectListVO.setCreUsrId(account.getUsr_id());
					dbDao.addNewobject(psoObjectListVO); // Update PSO_OBJ_LIST
				}else if ("D".equals(psoObjectListVO.getIbflag())) { // Delete
					// TODO Delete PSO_OBJ_LIST , PSO_FOML_DTL, PSO_FORMULA
					// Object 신규 생성시 PSO_FORMULA : 2개 Row, PSO_FOML_DTL : 4개 Row 생성됨.
					// 1. PSO_FOML_DTL Delete
					dbDao.removeFormulaDetilByObject(psoObjectListVO);
					// 2. PSO_FORMULA Delete
					dbDao.removeFormulaByObject(psoObjectListVO);
					// 3. PSO_INV_OFC_OBJ_LIST Delete
					dbDao.removePsoInvoiceOfficeByObject(psoObjectListVO);
					// 4. PSO_OBJ_LIST Delete
					dbDao.removeObject(psoObjectListVO);
				}
			}
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Object List" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Object List" }).getMessage(), ex);
		}
	}

	/**
	 * Register Object Basic Formula
	 * 
	 * @param PsoObjListVO
	 *            psoObjectListVO
	 * @param SignOnUserAccount
	 *            account
	 * @return String
	 * @exception EventException
	 */
	private String addBasicFormula(PsoObjListVO psoObjListVO, SignOnUserAccount account) throws EventException, DAOException {
		String objNm = psoObjListVO.getObjListNm();
		String objListNo = psoObjListVO.getObjListNo();
		String fomlDesc = null;
		String fomlSysDesc = null;
		String newFomlNo = dbDao.searchMaxFomlNo();
		String fomlNo = null;
		PsoBasicFormulaVO psoBasicFormulaVO = new PsoBasicFormulaVO();

		try {
			// NYK Modify 2014.11.18
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					fomlDesc = objNm + " RATE";
					fomlSysDesc = "[45]<" + objListNo + ">";
					fomlNo = newFomlNo;
				} else {
					fomlDesc = objNm + " * " + objNm + " RATE";
					fomlSysDesc = "[" + objListNo + "] * [45]<" + objListNo + ">";
					fomlNo = "" + (Integer.parseInt(newFomlNo) + 1);
				}
				psoBasicFormulaVO.setFomlDesc(fomlDesc);
				psoBasicFormulaVO.setFomlSysDesc(fomlSysDesc);
				psoBasicFormulaVO.setFomlNo(fomlNo);
				psoBasicFormulaVO.setCreUsrId(account.getUsr_id());
				dbDao.addBasicFormula(psoBasicFormulaVO);	
			}
			
			return newFomlNo;
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Basic Formula" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Basic Formula" }).getMessage(), ex);
		}
	}

	/**
	 * Register Object Basic Formula detail
	 * 
	 * @param PsoObjListVO
	 *            psoObjectListVO
	 * @param String
	 *            newFomlNo
	 * @param SignOnUserAccount
	 *            account
	 * @exception EventException
	 */
	private void addBasicFomlDtl(PsoObjListVO psoObjectListVO, String newFomlNo, SignOnUserAccount account) throws EventException, DAOException {
		try {

			String fomlNo = null;
			/*
			 * 45<ObjectNo>, ObjectNo * 45<ObjectNo>
			 * 4개의 Row 가 Insert 된다.
			 * 0 : 45<ObjectNo>
			 * 1 : ObjectNo
			 * 2 : *
			 * 3 : 45<ObjectNo>
			 */ 
			for (int i = 0; i < 4; i++) {
				int fomlSeq = 0;
				String psoFomlDtlTpCd = null;
				String psoFomlOprCd = null;
				String objListNo = null;
				String rtObjListNo = null;
				PsoBasicFomlDtlVO psoBasicFomlDtlVO = new PsoBasicFomlDtlVO();
				// fomlNo = newFomlNo;
				if (i == 0) {
					fomlNo = newFomlNo;
					fomlSeq = 1;
					psoFomlDtlTpCd = "O";
					objListNo = "45";
					rtObjListNo = psoObjectListVO.getObjListNo();
					psoFomlOprCd = "";
				} else {

					fomlSeq = i;
					if (i == 1) {
						fomlNo = "" + (Integer.parseInt(newFomlNo) + 1);

						psoFomlDtlTpCd = "O";
						objListNo = psoObjectListVO.getObjListNo();

					} else if (i == 2) {
						psoFomlOprCd = "*";
						psoFomlDtlTpCd = "P";
					} else {
						psoFomlDtlTpCd = "O";
						objListNo = "45";
						rtObjListNo = psoObjectListVO.getObjListNo();
					}
				}
				psoBasicFomlDtlVO.setPsoFomlDtlTpCd(psoFomlDtlTpCd);
				psoBasicFomlDtlVO.setFomlSeq(Integer.toString(fomlSeq));
				psoBasicFomlDtlVO.setPsoFomlOprCd(psoFomlOprCd);
				psoBasicFomlDtlVO.setObjListNo(objListNo);
				psoBasicFomlDtlVO.setRtObjListNo(rtObjListNo);
				psoBasicFomlDtlVO.setFomlNo(fomlNo);
				psoBasicFomlDtlVO.setCreUsrId(account.getUsr_id());
				dbDao.addBasicFomlDtl(psoBasicFomlDtlVO);
			}
		} catch (DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Basic Formula detail" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Basic Formula detail" }).getMessage(), ex);
		}
	}
}