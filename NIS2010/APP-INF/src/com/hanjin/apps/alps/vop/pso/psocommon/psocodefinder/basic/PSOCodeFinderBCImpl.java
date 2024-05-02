/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSOCodeFinderBCImpl.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
*  
* History
* 2012.03.05 진마리아 CHM-201216583-01 Port Charge Invoice Creation 로직 변경 - 스케줄 존재 여부 점검 로직 추가 / KRPUS 스케줄에 대해 'Actual SKD 존재 체크' 로직 제외
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration.PSOCodeFinderDBDAO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PSOCommon Business Logic Basic Command implementation<br>
 * - ALPS-PSOCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see PSO_COMEventResponse,PSOCodeFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PSOCodeFinderBCImpl extends BasicCommandSupport implements PSOCodeFinderBC {

	// Database Access Object
	private transient PSOCodeFinderDBDAO dbDao = null;

	/**
	 * PSOCodeFinderBCImpl 객체 생성<br>
	 * PSOCodeFinderDBDAO를 생성한다.<br>
	 */
	public PSOCodeFinderBCImpl() {
		dbDao = new PSOCodeFinderDBDAO();
	}
//	/**
//	 * 조회 이벤트 처리<br>
//	 *  PSOCodeFinder화면에 대한 조회 이벤트 처리<br>
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
//	 * 멀티 이벤트 처리<br>
//	 * In화면에 대한 멀티 이벤트 처리<br>
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
	 *  vessel class를 조회한다.<br>
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
	 *  Account를 조회한다.<br>
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
	 * vendor seq를 기준으로 Vendor의 Bank정보를 조회한다.
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
	 * Vendor List정보를 조회한다.
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
	 * VVD가 존재하는지 체크
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
	 * 해당 VVD 의 Turning Port 여부 확인
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
	 * 존재하는 Lane인지 체크
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
	 * VVD가 SKD(VSK_VSL_PORT_SKD) 에 존재하는지 체크
	 * @param String vslCd  
	 * @param String skdVoyNo 
	 * @param String skdDirCd 
	 * @param String ydCd
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkVslSkdVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		try {
			return dbDao.checkVslSkdVvd(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{""}).getMessage(), de);
		}
	}
}