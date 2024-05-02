/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PSOCodeFinderBCImpl.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration.PSOCodeFinderDBDAO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PSOCommon Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of PSO_COMEventResponse,PSOCodeFinderBC 
 * @since J2EE 1.6
 */
public class PSOCodeFinderBCImpl extends BasicCommandSupport implements PSOCodeFinderBC {

	// Database Access Object
	private transient PSOCodeFinderDBDAO dbDao = null;

	/**
	 * Creating object PSOCodeFinderBCImpl <br>
	 * Creating PSOCodeFinderDBDAO<br>
	 */
	public PSOCodeFinderBCImpl() {
		dbDao = new PSOCodeFinderDBDAO();
	}
//	/**
//	 * Retrieve event <br>
//	 *  handling Retrieve event about PSOCodeFinder page<br>
//	 * 
//	 * @param psoMsaVO   PsoMsaVO
//	 * @return List<PsoMsaVO>
//	 * @exception EventException
//	 */
//	public List<PsoMsaVO> PsoMsaVO(PsoMsaVO psoMsaVO) throws EventException {
//		try {
//			return dbDao.PsoMsaVO(psoMsaVO);
//		} catch (DAOException ex) {
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * handling multi event<br>
//	 * handling Multi event about In page<br>
//	 * 
//	 * @param psoMsaDtlVO PsoMsaDtlVO[]
//	 * @param account SignOnUserAccount
//	 * @exception EventException
//	 */
//	public void PsoMsaDtlVO(PsoMsaDtlVO[] psoMsaDtlVO, SignOnUserAccount account) throws EventException{
//		try {
//			List<PsoMsaDtlVO> insertVoList = new ArrayList<PsoMsaDtlVO>();
//			List<PsoMsaDtlVO> updateVoList = new ArrayList<PsoMsaDtlVO>();
//			List<PsoMsaDtlVO> deleteVoList = new ArrayList<PsoMsaDtlVO>();
//			for ( int i=0; i<psoMsaDtlVO .length; i++ ) {
//				if ( psoMsaDtlVO[i].getIbflag().equals("I")){
//					psoMsaDtlVO[i].setCreUsrId(account.getUsr_id());
//					insertVoList.add(psoMsaDtlVO[i]);
//				} else if ( psoMsaDtlVO[i].getIbflag().equals("U")){
//					psoMsaDtlVO[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(psoMsaDtlVO[i]);
//				} else if ( psoMsaDtlVO[i].getIbflag().equals("D")){
//					deleteVoList.add(psoMsaDtlVO[i]);
//				}
//			}
//			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addPsoMsaDtlVOS(insertVoList);
//			}
//			
//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifyPsoMsaDtlVOS(updateVoList);
//			}
//			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removePsoMsaDtlVOS(deleteVoList);
//			}
//		} catch (DAOException ex) {
//			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}

	/**
	 * Retrieve vessel class.<br>
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVesselClassList() throws EventException {
		try {
			return dbDao.searchVesselClassList();
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}	
	
	
	/**
	 * Retrieve Account<br>
	 * @return List<CostListVO>
	 * @exception EventException
	 */
	public List<CostListVO> searchAccountList() throws EventException {
		try {
			return dbDao.searchAccountList();
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}	
	
	
	/**
	 * Retrieve Account<br>
	 * @param String ofcCd
	 * @return List<CostListVO>
	 * @exception EventException
	 */
	public List<CostListVO> searchAccountList(String ofcCd) throws EventException {
		try {
			return dbDao.searchAccountList(ofcCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}	
	
	

	/**
	 * Retrieve Bank of vendor by vendor seq standard.
	 * @param String vndrSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchVendorName(String vndrSeq) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchVendorName(vndrSeq);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}

	/**
	 * Retrieve Vendor List
	 * @param VendorListVO vendorListVO
	 * @return  List<VendorListVO>
	 * @exception EventException
	 */
	public List<VendorListVO> searchVendorList(VendorListVO vendorListVO)
			throws EventException {
		try {
			return dbDao.searchVendorList(vendorListVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Retrieval of Vendors"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Retrieval of Vendors"}).getMessage(), de);
		}
	}

	/**
	 * check existence of VVD
	 * @param String vslCd  
	 * @param String skdVoyNo 
	 * @param String skdDirCd 
	 * @param String ydCd
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkVslPortSkdVvd(String vslCd, String skdVoyNo,
			String skdDirCd, String ydCd) throws EventException {
		try {
			return dbDao.checkVslPortSkdVvd(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}

	/**
	 * check whether Turning Port of VVD chosen
	 * @param vslCd String 
	 * @param skdVoyNo String 
	 * @param skdDirCd String 
	 * @param ydCd String
	 * @return String 
	 * @exception EventException
	 */
	public String getTurnPortIndCd(String vslCd, String skdVoyNo,
			String skdDirCd, String ydCd) throws EventException {
		try {
			return dbDao.getTurnPortIndCd(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
	
	/**
	 * check existence of Lane
	 * @param  String rlaneCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkRevLane(String rlaneCd) throws EventException{
		try {
			return dbDao.checkRevLane(rlaneCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}

	/**
	 * check whether Turning Port of VVD chosen
	 * @param vslCd String 
	 * @param skdVoyNo String 
	 * @param skdDirCd String 
	 * @param ydCd String
	 * @return String 
	 * @exception EventException
	 */
	public String getDefaultTurnPortIndIoData(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		try {
			return dbDao.getDefaultTurnPortIndIoData(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}

	/**
	 * AR_MST_REV_VVD Check 구분 구하기 
	 * @param vslCd String 
	 * @param skdVoyNo String 
	 * @param skdDirCd String 
	 * @return String 
	 * @exception EventException
	 */
	public String checkArMasterRevenueByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		try {
			return dbDao.checkArMasterRevenueByVvd(vslCd, skdVoyNo, skdDirCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
	
	

	/**
	 *  clpt_ind_seq를 조회한다.
	 * @param String vvd
	 * @param String ydCd
	 * @return String 
	 * @exception EventException
	 */
	public String searchClptIndSeq(String vvd, String ydCd) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchClptIndSeq(vvd, ydCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
}