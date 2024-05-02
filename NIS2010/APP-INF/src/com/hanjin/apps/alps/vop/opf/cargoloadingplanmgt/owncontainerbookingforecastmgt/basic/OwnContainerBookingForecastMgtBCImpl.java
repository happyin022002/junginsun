/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OwnContainerBookingForecastMgtBCImpl.java
 *@FileTitle : Weight Group (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.11 우지석
 * 1.0 Creation
 * 2016.05.20 CBF PARTNER EDI 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration.OwnContainerBookingForecastMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFAllSummaryPreviewVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryDiffListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerEDIVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.SearchYardCodeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFWgtGroupSummaryVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiCgoBkgFcastVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.syscommon.common.table.OpfCgoBkgFcastWgtGrpVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiLogVO;
import com.hanjin.syscommon.common.table.VskCarrierVO;

/**
 * NIS2010-CargoLoadingPlanMgt Business Logic Basic Command implementation<br>
 * - NIS2010-CargoLoadingPlanMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Ji Seok Woo
 * @see VOP_OPF-3019EventResponse,OwnContainerBookingForecastMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class OwnContainerBookingForecastMgtBCImpl extends BasicCommandSupport implements OwnContainerBookingForecastMgtBC {

	// Database Access Object
	private transient OwnContainerBookingForecastMgtDBDAO dbDao = null;

	/**
	 * OwnContainerBookingForecastMgtBCImpl 객체 생성<br>
	 * OwnContainerBookingForecastMgtDBDAO를 생성한다.<br>
	 */
	public OwnContainerBookingForecastMgtBCImpl() {
		dbDao = new OwnContainerBookingForecastMgtDBDAO();
	}

	/**
	 * POL 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String[] arrPol
	 * @exception EventException
	 */
	public String[] searchPol(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		String[] arrPol = null;
		
		try {
			arrPol = dbDao.searchPol(vslCd, skdVoyNo, skdDirCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"POL"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"POL"}).getMessage(), ex);
		}
		return arrPol;
	}

	/**
	 * OPR 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[] arrOpr
	 * @exception EventException
	 */
	public String[] searchOpr(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		String[] arrOpr = null;
		try {
			arrOpr = dbDao.searchOpr(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"OPR"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"OPR"}).getMessage(), ex);
		}
		return arrOpr;
	}

	/**
	 * PodbyVvd 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPodbyVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		String[] arrPod = null;
		try {
			arrPod = dbDao.searchPodbyVvd(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PodbyVvd"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PodbyVvd"}).getMessage(), ex);
		}
		return arrPod;
	}

	/**
	 * MLB 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[] arrMlb
	 * @exception EventException
	 */
	public String[] searchMlb(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		String[] arrMlb = null;
		try {
			arrMlb = dbDao.searchMlb(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"MLB"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"MLB"}).getMessage(), ex);
		}
		return arrMlb;
	}

	/**
	 * LOC 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[] arrLoc
	 * @exception EventException
	 */
	public String[] searchLocInfo(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		String[] arrLoc = null;
		try {
			arrLoc = dbDao.searchLocInfo(vslCd, skdVoyNo, skdDirCd, ydCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"LOC"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"LOC"}).getMessage(), ex);
		}
		return arrLoc;
	}

	/**
	 * CBF Booking Status 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[] arrCbfBs
	 * @exception EventException
	 */
	public String[] searchCBFBS(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		String[] arrCbfBs = null;
		try {
			arrCbfBs = dbDao.searchCBFBS(vslCd, skdVoyNo, skdDirCd, ydCd);

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Booking Status"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Booking Status"}).getMessage(), ex);
		}
		return arrCbfBs;
	}
	
	/**
	 * CBF Booking Status 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[] arrCbfBs
	 * @exception EventException
	 */
	public String[] searchCBFHeaderInfo(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException {
		String[] arrCbfBs = null;
		try {
			arrCbfBs = dbDao.searchCBFHeaderInfo(vslCd, skdVoyNo, skdDirCd, ydCd);
        
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Booking Status"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Booking Status"}).getMessage(), ex);
		}
		return arrCbfBs;
	}
	

	/**
	 * CBF 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkCBFSave(CBFListOptionVO cBFListOptionVO) throws EventException {
		try {
			return dbDao.checkCBFSave(cBFListOptionVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Save Info"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Save Info"}).getMessage(), ex);
		}
	}

	/**
	 * CBF Header 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkCBFHeaderSave(CBFListOptionVO cBFListOptionVO) throws EventException {
		try {
			return dbDao.checkCBFHeaderSave(cBFListOptionVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Header Save Info"}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Header Save Info"}).getMessage(), ex);
		}
	}
	
	/**
	 * WeightGRPList 정보를 조회합니다.<br>
	 * 
	 * @param CargoBookingForecastVO cargoBookingForecastVO
	 * @return List<CargoBookingForecastVO>
	 * @exception EventException
	 */
	public List<CargoBookingForecastVO> searchWeightGRPList(CargoBookingForecastVO cargoBookingForecastVO) throws EventException {
		try {
			return dbDao.searchWeightGRPList(cargoBookingForecastVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00023", new String[]{"Weight Group Creation"}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00023", new String[]{"Weight Group Creation"}).getMessage());
		}
	}

	/**
	 * CBFVolumeList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<List<CBFListOptionVO>>
	 * @exception EventException
	 */
	public List<List<CBFListOptionVO>> searchCBFVolumeList(CBFListOptionVO cBFListOptionVO) throws EventException {		
		List<List<CBFListOptionVO>> rsltList = new ArrayList<List<CBFListOptionVO>>();
		
		try {
			
			List<CBFListOptionVO> list1 = dbDao.searchCBFVolumeList(cBFListOptionVO);
			List<CBFListOptionVO> list2 = dbDao.searchCBFVolumeSpecialList(cBFListOptionVO);
			
			rsltList.add(list1);
			rsltList.add(list2);			
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
		return rsltList;
	}

	/**
	 * CBFSpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return CBFListOptionVO
	 * @exception EventException
	 */
	public CBFListOptionVO searchCBFOwnSpecialList(CBFListOptionVO cBFListOptionVO) throws EventException {
		CBFListOptionVO rsltList = new CBFListOptionVO();
		try {
			List<CBFListOptionVO> list = dbDao.searchCBFOwnSpecialList(cBFListOptionVO);
			
			rsltList.setCBFListOptionVOS(list);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), ex);
		}
		return rsltList;
	}

	/**
	 * CBFBKGVolumeList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return List<List<CBFListOptionVO>>
	 * @exception EventException
	 */
	public List<List<CBFListOptionVO>> searchCBFBKGVolumeList(CBFListOptionVO cBFListOptionVO) throws EventException {
		List<List<CBFListOptionVO>> rsltList = new ArrayList<List<CBFListOptionVO>>();
		
		try {
			List<CBFListOptionVO> list1 = dbDao.searchCBFBKGVolumeList(cBFListOptionVO);
			List<CBFListOptionVO> list2 = dbDao.searchCBFBKGSpecialList(cBFListOptionVO);
			
			rsltList.add(list1);
			rsltList.add(list2);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF BKG Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF BKG Volume List"}).getMessage(), ex);
		}
		return rsltList;
	}

	/**
	 * CBFSpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchCBFVolumeSpecialList(
			CBFListOptionVO cbfListOptionVO) throws EventException {
		try {
			return dbDao.searchCBFVolumeSpecialList(cbfListOptionVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), ex);
		}
	}

	/**
	 * BKGVVD 정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int checkBKGVVD(CBFListOptionVO cbfListOptionVO)	throws EventException {
		try {
			return dbDao.checkBKGVVD(cbfListOptionVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"BKG VVD"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"BKG VVD"}).getMessage(), ex);
		}
	}

	/**
	 * TurningPortSkipCall 정보를 확인합니다.
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return VskVslPortSkdCustVO
	 * @throws EventException
	 */
	public VskVslPortSkdCustVO checkTurningPortSkipCall(CBFListOptionVO cbfListOptionVO) throws EventException {
		try {
			return dbDao.checkTurningPortSkipCall(cbfListOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Turning Port Skip Call"}).getMessage(), ex);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Turning Port Skip Call"}).getMessage(), e);
		}
	}

	/**
	 * Weight Group 정보를 저장합니다. <br>
	 * 
	 * @param CargoBookingForecastVO[] cargoBookingForecastVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWeightGRP(CargoBookingForecastVO[] cargoBookingForecastVO, SignOnUserAccount account) throws EventException {
		try {
			List<CargoBookingForecastVO> insertVoList = new ArrayList<CargoBookingForecastVO>();
			List<CargoBookingForecastVO> updateVoList = new ArrayList<CargoBookingForecastVO>();
			List<CargoBookingForecastVO> deleteVoList = new ArrayList<CargoBookingForecastVO>();
			for (int i = 0; i < cargoBookingForecastVO.length; i++) {
				if (cargoBookingForecastVO[i].getIbflag().equals("I")) {
					cargoBookingForecastVO[i].setCreUsrId(account.getUsr_id());
					cargoBookingForecastVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cargoBookingForecastVO[i]);
				} else if (cargoBookingForecastVO[i].getIbflag().equals("U")) {
					cargoBookingForecastVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cargoBookingForecastVO[i]);
				} else if (cargoBookingForecastVO[i].getIbflag().equals("D")) {
					deleteVoList.add(cargoBookingForecastVO[i]);
				}
			}

			if (deleteVoList.size() > 0) {

				List<OpfCgoBkgFcastWgtGrpVO> tableDeleteVoList = new ArrayList<OpfCgoBkgFcastWgtGrpVO>();
				for (int i = 0; i < deleteVoList.size(); i++) {
					CargoBookingForecastVO mgtVoList = deleteVoList.get(i);

					if ( (mgtVoList.getCntrLmtWgt1() != null && !mgtVoList.getCntrLmtWgt1().equals("")) || (mgtVoList.getCntrLmtWgt2() != null	&& !mgtVoList.getCntrLmtWgt2().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableDeleteVo = new OpfCgoBkgFcastWgtGrpVO();
						tableDeleteVo.setSlanCd(mgtVoList.getSlanCd());
						tableDeleteVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableDeleteVo.setPolCd(mgtVoList.getPolCd());
						tableDeleteVo.setCntrSzCd("2");
						tableDeleteVo.setFullMtyCd("F");
						tableDeleteVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());

						tableDeleteVoList.add(tableDeleteVo);
					}
					if ( (mgtVoList.getCntrLmtWgt3() != null && !mgtVoList.getCntrLmtWgt3().equals("")) || (mgtVoList.getCntrLmtWgt4() != null	&& !mgtVoList.getCntrLmtWgt4().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableDeleteVo = new OpfCgoBkgFcastWgtGrpVO();
						tableDeleteVo.setSlanCd(mgtVoList.getSlanCd());
						tableDeleteVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableDeleteVo.setPolCd(mgtVoList.getPolCd());
						tableDeleteVo.setCntrSzCd("4");
						tableDeleteVo.setFullMtyCd("F");
						tableDeleteVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());

						tableDeleteVoList.add(tableDeleteVo);
					}
				}
				dbDao.removeWeightGRPList(tableDeleteVoList);
			}
			
			
			if (insertVoList.size() > 0) {

				List<OpfCgoBkgFcastWgtGrpVO> tableInsertVoList = new ArrayList<OpfCgoBkgFcastWgtGrpVO>();
				for (int i = 0; i < insertVoList.size(); i++) {
					CargoBookingForecastVO mgtVoList = insertVoList.get(i);

					if ( (mgtVoList.getCntrLmtWgt1() != null && !mgtVoList.getCntrLmtWgt1().equals("")) || (mgtVoList.getCntrLmtWgt2() != null	&& !mgtVoList.getCntrLmtWgt2().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableInsertVo = new OpfCgoBkgFcastWgtGrpVO();
						tableInsertVo.setSlanCd(mgtVoList.getSlanCd());
						tableInsertVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableInsertVo.setPolCd(mgtVoList.getPolCd());
						tableInsertVo.setCntrSzCd("2");
						tableInsertVo.setFullMtyCd("F");
						tableInsertVo.setFmLmtWgt(mgtVoList.getCntrLmtWgt1());
						tableInsertVo.setToLmtWgt(mgtVoList.getCntrLmtWgt2());
						tableInsertVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
						tableInsertVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
						tableInsertVo.setCreUsrId(account.getUsr_id());
						tableInsertVo.setCreUsrId(account.getUsr_id());
						tableInsertVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());
						
						tableInsertVoList.add(tableInsertVo);
					}

					if ( (mgtVoList.getCntrLmtWgt3() != null && !mgtVoList.getCntrLmtWgt3().equals("")) || (mgtVoList.getCntrLmtWgt4() != null	&& !mgtVoList.getCntrLmtWgt4().equals(""))) {
						
						OpfCgoBkgFcastWgtGrpVO tableInsertVo = new OpfCgoBkgFcastWgtGrpVO();
						tableInsertVo.setSlanCd(mgtVoList.getSlanCd());
						tableInsertVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableInsertVo.setPolCd(mgtVoList.getPolCd());
						tableInsertVo.setCntrSzCd("4");
						tableInsertVo.setFullMtyCd("F");
						tableInsertVo.setFmLmtWgt(mgtVoList.getCntrLmtWgt3());
						tableInsertVo.setToLmtWgt(mgtVoList.getCntrLmtWgt4());
						tableInsertVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
						tableInsertVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
						tableInsertVo.setCreUsrId(account.getUsr_id());
						tableInsertVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());

						tableInsertVoList.add(tableInsertVo);
					}
					
					if ( mgtVoList.getCntrLmtWgt1().equals("") && mgtVoList.getCntrLmtWgt2().equals("") && mgtVoList.getCntrLmtWgt3().equals("") && mgtVoList.getCntrLmtWgt4().equals("")) {
						OpfCgoBkgFcastWgtGrpVO tableInsertVo = new OpfCgoBkgFcastWgtGrpVO();
						tableInsertVo.setSlanCd(mgtVoList.getSlanCd());
						tableInsertVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableInsertVo.setPolCd(mgtVoList.getPolCd());
						tableInsertVo.setCntrSzCd("2");
						tableInsertVo.setFullMtyCd("F");
						tableInsertVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
						tableInsertVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
						tableInsertVo.setCreUsrId(account.getUsr_id());
						tableInsertVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());

						tableInsertVoList.add(tableInsertVo);
					}					
				}
				dbDao.addWeightGRPList(tableInsertVoList);
			}

			List<OpfCgoBkgFcastWgtGrpVO> updateForDeleteVoList = new ArrayList<OpfCgoBkgFcastWgtGrpVO>();
			List<OpfCgoBkgFcastWgtGrpVO> updateForInsertVoList = new ArrayList<OpfCgoBkgFcastWgtGrpVO>();
			if (updateVoList.size() > 0) {

				List<OpfCgoBkgFcastWgtGrpVO> tableUpdateVoList = new ArrayList<OpfCgoBkgFcastWgtGrpVO>();
				for (int i = 0; i < updateVoList.size(); i++) {
					CargoBookingForecastVO mgtVoList = updateVoList.get(i);

					if ( (mgtVoList.getCntrLmtWgt1() != null && !mgtVoList.getCntrLmtWgt1().equals("")) || (mgtVoList.getCntrLmtWgt2() != null && !mgtVoList.getCntrLmtWgt2().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableUpdateVo = new OpfCgoBkgFcastWgtGrpVO();
						tableUpdateVo.setSlanCd(mgtVoList.getSlanCd());
						tableUpdateVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableUpdateVo.setPolCd(mgtVoList.getPolCd());
						tableUpdateVo.setCntrSzCd("2");
						tableUpdateVo.setFullMtyCd("F");
						tableUpdateVo.setFmLmtWgt(mgtVoList.getCntrLmtWgt1());
						tableUpdateVo.setToLmtWgt(mgtVoList.getCntrLmtWgt2());
						tableUpdateVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
						tableUpdateVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
						tableUpdateVo.setUpdUsrId(account.getUsr_id());
						tableUpdateVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());
						
						if (dbDao.searchWeightGRP(tableUpdateVo) > 0) {
							tableUpdateVoList.add(tableUpdateVo);
						} else {
							OpfCgoBkgFcastWgtGrpVO tableInsertVo = new OpfCgoBkgFcastWgtGrpVO();
							tableInsertVo.setSlanCd(mgtVoList.getSlanCd());
							tableInsertVo.setSkdDirCd(mgtVoList.getSkdDirCd());
							tableInsertVo.setPolCd(mgtVoList.getPolCd());
							tableInsertVo.setCntrSzCd("2");
							tableInsertVo.setFullMtyCd("F");
							tableInsertVo.setFmLmtWgt(mgtVoList.getCntrLmtWgt1());
							tableInsertVo.setToLmtWgt(mgtVoList.getCntrLmtWgt2());
							tableInsertVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
							tableInsertVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
							tableInsertVo.setCreUsrId(account.getUsr_id());
							tableInsertVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());
							
							updateForInsertVoList.add(tableInsertVo);
						}

					} else {
						OpfCgoBkgFcastWgtGrpVO tableDeleteVo = new OpfCgoBkgFcastWgtGrpVO();
						tableDeleteVo.setSlanCd(mgtVoList.getSlanCd());
						tableDeleteVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableDeleteVo.setPolCd(mgtVoList.getPolCd());
						tableDeleteVo.setCntrSzCd("2");
						tableDeleteVo.setFullMtyCd("F");
						tableDeleteVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());

						updateForDeleteVoList.add(tableDeleteVo); // Update 컬럼의 삭제될 VO List.
					}

					if ( (mgtVoList.getCntrLmtWgt3() != null && !mgtVoList.getCntrLmtWgt3().equals("")) || (mgtVoList.getCntrLmtWgt4() != null	&& !mgtVoList.getCntrLmtWgt4().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableUpdateVo = new OpfCgoBkgFcastWgtGrpVO();
						tableUpdateVo.setSlanCd(mgtVoList.getSlanCd());
						tableUpdateVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableUpdateVo.setPolCd(mgtVoList.getPolCd());
						tableUpdateVo.setCntrSzCd("4");
						tableUpdateVo.setFullMtyCd("F");
						tableUpdateVo.setFmLmtWgt(mgtVoList.getCntrLmtWgt3());
						tableUpdateVo.setToLmtWgt(mgtVoList.getCntrLmtWgt4());						
						tableUpdateVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
						tableUpdateVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
						tableUpdateVo.setUpdUsrId(account.getUsr_id());
						tableUpdateVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());
						
						if (dbDao.searchWeightGRP(tableUpdateVo) > 0) {
							tableUpdateVoList.add(tableUpdateVo);
						} else {
							OpfCgoBkgFcastWgtGrpVO tableInsertVo = new OpfCgoBkgFcastWgtGrpVO();
							tableInsertVo.setSlanCd(mgtVoList.getSlanCd());
							tableInsertVo.setSkdDirCd(mgtVoList.getSkdDirCd());
							tableInsertVo.setPolCd(mgtVoList.getPolCd());
							tableInsertVo.setCntrSzCd("4");
							tableInsertVo.setFullMtyCd("F");
							tableInsertVo.setFmLmtWgt(mgtVoList.getCntrLmtWgt3());
							tableInsertVo.setToLmtWgt(mgtVoList.getCntrLmtWgt4());
							tableInsertVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());
							tableInsertVo.setWgtGrpCdDesc(mgtVoList.getWgtGrpCdDesc());
							tableInsertVo.setCreUsrId(account.getUsr_id());
							tableInsertVo.setCntrWgtGrpSeq(mgtVoList.getCntrWgtGrpSeq());
							
							updateForInsertVoList.add(tableInsertVo);
						}

					} else {
						OpfCgoBkgFcastWgtGrpVO tableDeleteVo = new OpfCgoBkgFcastWgtGrpVO();
						tableDeleteVo.setSlanCd(mgtVoList.getSlanCd());
						tableDeleteVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableDeleteVo.setPolCd(mgtVoList.getPolCd());
						tableDeleteVo.setCntrSzCd("4");
						tableDeleteVo.setFullMtyCd("F");
						tableDeleteVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());

						updateForDeleteVoList.add(tableDeleteVo); // Update 컬럼의 삭제될 VO List.
					}
				}
				dbDao.modifyWeightGRPList(tableUpdateVoList);
			}
			// Update 컬럼의 삭제될 VO List Data Delete.
			if (updateForDeleteVoList.size() > 0) {
				dbDao.removeWeightGRPList(updateForDeleteVoList);
			}
			// Update 컬럼의 추가될 VO List Data Insert.
			if (updateForInsertVoList.size() > 0) {
				dbDao.addWeightGRPList(updateForInsertVoList);
			}

/*			if (deleteVoList.size() > 0) {

				List<OpfCgoBkgFcastWgtGrpVO> tableDeleteVoList = new ArrayList<OpfCgoBkgFcastWgtGrpVO>();
				for (int i = 0; i < deleteVoList.size(); i++) {
					CargoBookingForecastVO mgtVoList = deleteVoList.get(i);

					if ( (mgtVoList.getCntrLmtWgt1() != null && !mgtVoList.getCntrLmtWgt1().equals("")) || (mgtVoList.getCntrLmtWgt2() != null	&& !mgtVoList.getCntrLmtWgt2().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableDeleteVo = new OpfCgoBkgFcastWgtGrpVO();
						tableDeleteVo.setSlanCd(mgtVoList.getSlanCd());
						tableDeleteVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableDeleteVo.setPolCd(mgtVoList.getPolCd());
						tableDeleteVo.setCntrSzCd("2");
						tableDeleteVo.setFullMtyCd("F");
						tableDeleteVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());

						tableDeleteVoList.add(tableDeleteVo);
					}
					if ( (mgtVoList.getCntrLmtWgt3() != null && !mgtVoList.getCntrLmtWgt3().equals("")) || (mgtVoList.getCntrLmtWgt4() != null	&& !mgtVoList.getCntrLmtWgt4().equals(""))) {
						OpfCgoBkgFcastWgtGrpVO tableDeleteVo = new OpfCgoBkgFcastWgtGrpVO();
						tableDeleteVo.setSlanCd(mgtVoList.getSlanCd());
						tableDeleteVo.setSkdDirCd(mgtVoList.getSkdDirCd());
						tableDeleteVo.setPolCd(mgtVoList.getPolCd());
						tableDeleteVo.setCntrSzCd("4");
						tableDeleteVo.setFullMtyCd("F");
						tableDeleteVo.setCntrWgtGrpCd(mgtVoList.getCntrWgtGrpCd());

						tableDeleteVoList.add(tableDeleteVo);
					}
				}
				dbDao.removeWeightGRPList(tableDeleteVoList);
			}*/
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"WeightGRP"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"WeightGRP"}).getMessage(), de);
		}
	}
	
	/**
	 * CBFList 정보를 삭제합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @exception EventException
	 */
	public void removeCBFList(CBFListOptionVO cBFListOptionVO) throws EventException {
		try {
			dbDao.removeCBFList(cBFListOptionVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12197", new String[]{"CBF List"}).getMessage(), de);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("COM12197", new String[]{"CBF List"}).getMessage(), de);
		}
	}

	/**
	 * OwnCBF 정보를 저장합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @param CBFListOptionVO[] cbfListVolumnVOs
	 * @param CBFListOptionVO[] cbfListSpecialVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOwnCBF(CBFListOptionVO cBFListOptionVO, CBFListOptionVO[] cbfListVolumnVOs, CBFListOptionVO[] cbfListSpecialVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CBFListOptionVO> insertCntrVoList = new ArrayList<CBFListOptionVO>();
			List<CBFListOptionVO> insertSubRVoList = new ArrayList<CBFListOptionVO>();
			
			if (cbfListVolumnVOs != null && cbfListVolumnVOs.length > 0) {
				int cbfSmrySeq = 1;
				//1. Volumn
				for (int i = 0; i < cbfListVolumnVOs.length; i++) {
					if(!"D".equals(cbfListVolumnVOs[i].getIbflag())) {
						cbfListVolumnVOs[i].setUpdUsrId(account.getUsr_id());
						cbfListVolumnVOs[i].setCreUsrId(account.getUsr_id());
						cbfListVolumnVOs[i].setCreDt(cBFListOptionVO.getCreDt());
						
						cbfListVolumnVOs[i].setCbfSmrySeq(Integer.toString(cbfSmrySeq));
						cbfListVolumnVOs[i].setCbfIndFlg(cBFListOptionVO.getCbfIndFlg());
						cbfListVolumnVOs[i].setCbfBkgStsCd(cBFListOptionVO.getCbfBkgStsCd());
						
						if(cbfListVolumnVOs[i].getVslCd() != null && !"".equals(cbfListVolumnVOs[i].getVslCd())) {					
							//Volumn CBF VO 생성
							insertCntrVoList.add(cbfListVolumnVOs[i]);
							
							cbfSmrySeq++;
						}
					}
				}
				//2. Special
				if (cbfListSpecialVOs != null) {
					for (int i = 0; i < cbfListSpecialVOs.length; i++) {
						cbfListSpecialVOs[i].setUpdUsrId(account.getUsr_id());
						cbfListSpecialVOs[i].setCreUsrId(account.getUsr_id());
						cbfListSpecialVOs[i].setCreDt(cBFListOptionVO.getCreDt());
						
						cbfListSpecialVOs[i].setCbfSmrySeq(Integer.toString(cbfSmrySeq));
						cbfListSpecialVOs[i].setCbfIndFlg(cBFListOptionVO.getCbfIndFlg());
						cbfListSpecialVOs[i].setCbfBkgStsCd(cBFListOptionVO.getCbfBkgStsCd());
						
						if(cbfListSpecialVOs[i].getVslCd() != null && !"".equals(cbfListSpecialVOs[i].getVslCd())) {
							//Special CBF VO 생성
							insertCntrVoList.add(cbfListSpecialVOs[i]);
							
							//Subs Risk VO 생성
							if(!"".equals(cbfListSpecialVOs[i].getImdgSubsRskLblCd())) {
								insertSubRVoList.add(cbfListSpecialVOs[i]);
							}
							
							cbfSmrySeq++;
						}
					}
				}
				
				cBFListOptionVO.setUpdUsrId(account.getUsr_id());
				cBFListOptionVO.setCreUsrId(account.getUsr_id());
				cBFListOptionVO.setCBFListOptionVOS(insertSubRVoList);
				
				if (insertCntrVoList.size() > 0) {
					dbDao.addOpfCgoBkgFcast(cBFListOptionVO);
					dbDao.addOwnCBFList(cBFListOptionVO, insertCntrVoList);
				}

			} else if(cbfListVolumnVOs == null && cbfListSpecialVOs == null ) {
				// Retrieve 데이타도 없고 import BKG 해도 데이타가 없는 경우에 Save 버튼 Click 시 -> 기존 Header 정보 삭제 후 신규 Header 정보 생성				
				
				dbDao.removeCBFListHeader(cBFListOptionVO);
				
				cBFListOptionVO.setUpdUsrId(account.getUsr_id());
				cBFListOptionVO.setCreUsrId(account.getUsr_id());
				dbDao.addOpfCgoBkgFcast(cBFListOptionVO);				
			} else {
				//1. Special
				if (cbfListSpecialVOs != null) {
					for (int i = 0; i < cbfListSpecialVOs.length; i++) {
						cBFListOptionVO.setUpdUsrId(account.getUsr_id());
						cbfListSpecialVOs[i].setUpdUsrId(account.getUsr_id());

						//수정할 Special CBF VO 생성
						insertCntrVoList.add(cbfListSpecialVOs[i]);
					}					
				}
				
				dbDao.modifyOpfCgoBkgFcast(cBFListOptionVO);
				
				if (insertCntrVoList.size() > 0) {					
					dbDao.modifyOwnCBFList(insertCntrVoList);
				}
			}
			
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Own CBF"}).getMessage(), de);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Own CBF"}).getMessage(), de);
		}
	}

	/**
	 * CBF Summary 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> calCBFSummary(CBFSummaryVO cbfSummaryVO) throws EventException {
		try {
			return dbDao.calCBFSummary(cbfSummaryVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), e);
		}
	}
	
	/**
	 * CBF SpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFSpecialList(CBFSummaryVO cbfSummaryVO) throws EventException {
		try {
			return dbDao.searchCBFSpecialList(cbfSummaryVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), e);
		}
	}
	
	/**
	 * CBF Special Stwg 정보를 조회합니다.<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @exception EventException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwg(CBFSpecialStwgVO cbfSpecialStwgVO) throws EventException {
		try {
			return dbDao.searchCBFSpecialStwg(cbfSpecialStwgVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), e);
		}
	}

	/**
	 * CBF Summary 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> calCBFInquirySummary(CBFSummaryVO cbfSummaryVO) throws EventException {
		try {
			return dbDao.calCBFInquirySummary(cbfSummaryVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), e);
		}
	}

	/**
	 * CBF Special Stwg 정보를 조회합니다.<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @exception EventException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwgPreview(CBFSpecialStwgVO cbfSpecialStwgVO)	throws EventException {
		try {
			return dbDao.searchCBFSpecialStwgPreview(cbfSpecialStwgVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), e);
		}
	}

	/**
	 * CBF SpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFInquirySpecialList(CBFSummaryVO cbfSummaryVO)	throws EventException {
		try {
			return dbDao.searchCBFInquirySpecialList(cbfSummaryVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Special List"}).getMessage(), e);
		}
	}

	/**
	 * OprPodMlbComboList 정보를 조회합니다.<br>
	 * 
	 * @return List<VskCarrierVO>
	 * @exception EventException
	 */
	public List<VskCarrierVO> searchOprPodMlbComboList() throws EventException {
		try {
			return dbDao.searchOprPodMlbComboList();
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Opr Pod Mlb Combo List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Opr Pod Mlb Combo List"}).getMessage(), ex);
		}
	}

	/**
	 * CBFSummaryPreviewHeader 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFSummaryPreviewHeaderList(CBFSummaryVO cbfSummaryVO) throws EventException {
		try {
			return dbDao.searchCBFSummaryPreviewHeaderList(cbfSummaryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary Preview Header"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary Preview Header"}).getMessage(), ex);
		}
	}

	/**
	 * CBFSummaryPreviewStwgCd 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @exception EventException
	 */
	public List<CBFSummaryVO> searchCBFSummaryPreviewStwgCdList(CBFSummaryVO cbfSummaryVO) throws EventException {
		try {
			return dbDao.searchCBFSummaryPreviewStwgCdList(cbfSummaryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary Preview StwgCd"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary Preview StwgCd"}).getMessage(), ex);
		}
	}
	
	/**
	 *  PartnerCBFList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchPartnerCBFList(CBFListOptionVO cbfListOptionVO) throws EventException {
		try {
			return dbDao.searchPartnerCBFList(cbfListOptionVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PartnerCBFList"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PartnerCBFList"}).getMessage(), ex);
		}
	}
	
	/**
	 *  PartnerCBFSpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public List<CBFListOptionVO> searchPartnerCBFSpecialList(CBFListOptionVO cbfListOptionVO) throws EventException {
		try {
			return dbDao.searchPartnerCBFSpecialList(cbfListOptionVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PartnerCBFSpecialList"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PartnerCBFSpecialList"}).getMessage(), ex);
		}
	}

	/**
	 * PartnerCBF 정보를 저장합니다.<br>
	 * 
	 * @param CBFListOptionVO[] cbfListOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void managePartnerCBF(CBFListOptionVO[] cbfListOptionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CBFListOptionVO> insertVoList = new ArrayList<CBFListOptionVO>();
			List<CBFListOptionVO> updateVoList = new ArrayList<CBFListOptionVO>();
			List<CBFListOptionVO> deleteVoList = new ArrayList<CBFListOptionVO>();

			if(cbfListOptionVOs != null) {
				for ( int i=0; i<cbfListOptionVOs.length; i++ ) {
					if ( cbfListOptionVOs[i].getIbflag().equals("I")){
						cbfListOptionVOs[i].setCreUsrId(account.getUsr_id());
						cbfListOptionVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(cbfListOptionVOs[i]);
					} else if ( cbfListOptionVOs[i].getIbflag().equals("U")){
						cbfListOptionVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(cbfListOptionVOs[i]);
					} else if ( cbfListOptionVOs[i].getIbflag().equals("D")){
						deleteVoList.add(cbfListOptionVOs[i]);
					}
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePartnerCBFList(deleteVoList);
				dbDao.removeOpfCgoBkgFcast(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOpfCgoBkgFcast(insertVoList);
				dbDao.addPartnerCBFList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPartnerOpfCgoBkgFcast(updateVoList);
				dbDao.modifyPartnerCBFList(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"PartnerCBF"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"PartnerCBF"}).getMessage(), ex);
		}
	}
	
	/**
	 *  TP 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchTp(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchTp(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"TP"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"TP"}).getMessage(), ex);
		}
	}

	/**
	 *  Weight Group 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSingleWgp(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchSingleWgp(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Weight Group"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Weight Group"}).getMessage(), ex);
		}
	}	

	/**
	 *  Full Empty 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchFm(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchFm(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Full Empty"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Full Empty"}).getMessage(), ex);
		}
	}	
	
	/**
	 *  CGO 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchCgo(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchCgo(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CGO"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CGO"}).getMessage(), ex);
		}
	}	

	/**
	 *  IMO 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchImo(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchImo(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMO"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMO"}).getMessage(), ex);
		}
	}	

	/**
	 *  PostExtd 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchPostExtd(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchPostExtd(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PostExtd"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"PostExtd"}).getMessage(), ex);
		}
	}	

	/**
	 *  STWG 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @exception EventException
	 */
	public List<PodComboVO> searchStwg(PodComboVO podComboVO) throws EventException {
		try {
			return dbDao.searchStwg(podComboVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"STWG"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"STWG"}).getMessage(), ex);
		}
	}	

	/**
	 *  Partner CBF 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public int checkPCBFSave(CBFListOptionVO cbfListOptionVO) throws EventException {
		try {
			return dbDao.checkPCBFSave(cbfListOptionVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner CBF Save Info"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner CBF Save Info"}).getMessage(), ex);
		}
	}
	
	/**
	 *  Partner CBF 저장정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @exception EventException
	 */
	public int checkPCBFSpecialSave(CBFListOptionVO cbfListOptionVO) throws EventException {
		try {
			return dbDao.checkPCBFSpecialSave(cbfListOptionVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner CBF Save Info"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner CBF Save Info"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회조건 Carrier Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFCarrierList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
	//	List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			return dbDao.searchCBFIFCarrierList(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}

	/**
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTypeSize(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		try {
			return dbDao.checkTypeSize(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}

	/**
	 * Pod Code 정보를 체크합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTypePodCd(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		try {
			return dbDao.checkTypePodCd(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"POD CODE"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"POD CODE"}).getMessage(), ex);
		}
	}
	
	/**
	 *  KOREA 세관신고CLL과 BOOKING 데이터 비교 정보 가져온다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkCllDiff(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		try {
			return dbDao.checkCllDiff(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CLL&BOOKING DIFF"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CLL&BOOKING DIFFt"}).getMessage(), ex);
		}
	}
	
	
	/**
	 *   PARTNER EDI 수신 전 MANUAL 입력 데이터 존재 여부<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPartnerEdiExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		try {
			return dbDao.checkPartnerEdiExist(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CLL&BOOKING DIFF"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CLL&BOOKING DIFFt"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회조건 POD Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFPodList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
	//	List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			return dbDao.searchCBFIFPodList(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn POD Combo 정보를 조회합니다.<br>  
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFOprPodList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
	//	List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			return dbDao.searchCBFIFOprPodList(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Dg - UN NO. Combo 정보를 조회합니다.<br>  
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFDgUnNoList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
	//	List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			return dbDao.searchCBFIFDgUnNoList(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}

	/**
	 * Special STWG Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSTWGList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
	//	List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			return dbDao.searchCBFIFSTWGList(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}

	/**
	 *  Weight 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCgoGrsWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {
		try {
			return dbDao.searchCgoGrsWgt(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Weight Group"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Weight Group"}).getMessage(), ex);
		}
	}	

	/**
	 *  OPR HJS의 등록여부 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchOprHJSExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {
		try {
			return dbDao.searchOprHJSExist(cBFIFSummaryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Weight Group"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Weight Group"}).getMessage(), ex);
		}
	}	

	/**
	 * CBF - Creation 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<List<CBFIFSummaryListVO>> searchCBFIFSummaryList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			// Carrier 정보를 조회합니다.
			List<CBFIFSummaryListVO> list1 = dbDao.searchCBFIFSummaryList(cBFIFSummaryListVO);
			// Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보를 조회합니다.
			List<CBFIFSummaryListVO> list2 = dbDao.searchCBFIFSummarySpecialList(cBFIFSummaryListVO);
			
			rsltList.add(list1);
			rsltList.add(list2);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
		return rsltList;
	}
	
	/**
	 * CBF - POD 삭제시 해당 POD의 SPECIAL 데이터가 있는지 확인하기 위함 <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCBFIFSpecialExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		try {
			String  delFlg = dbDao.searchCBFIFSpecialExist(cBFIFSummaryListVO);
			return delFlg;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF EXISTS"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF EXISTS"}).getMessage(), ex);
		}
	}

	/**
	 * CBF - Creation 정보를 삭제합니다.<br>
	 * 	 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @exception EventException
	 */
	public void manageCBFDelete(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {
		try {
		
			dbDao.delCBFAll(cBFIFSummaryListVO);

		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}	
		
	/**
	 * CBF - Creation 정보를 저장합니다.<br>
	 * 	 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @param CBFIFSummaryListVO[] cBFIFSummaryListVOs
	 * @param CBFIFSummaryListVO[] cbfIFSummarySpecialListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCBFIFSummary(CBFIFSummaryListVO cBFIFSummaryListVO, CBFIFSummaryListVO[] cBFIFSummaryListVOs, CBFIFSummaryListVO[] cbfIFSummarySpecialListVOs, SignOnUserAccount account) throws EventException {
		try {
			log.debug("cBFIFSummaryListVO.getConditionGb()"+cBFIFSummaryListVO.getConditionGb());
			
			if("addCrrCd".equals(cBFIFSummaryListVO.getConditionGb())){
				dbDao.addCBFIFSummaryCarrier(cBFIFSummaryListVO);
			}else if("delCrrCd".equals(cBFIFSummaryListVO.getConditionGb())){
				dbDao.removeCBFIFSummaryCarrier(cBFIFSummaryListVO);
				
				dbDao.removeCBFIFSummaryIfBkgDtCgoGrsWgt(cBFIFSummaryListVO);
				dbDao.removeCBFIFSummaryIfBkgDtDtl(cBFIFSummaryListVO);
				dbDao.removeCBFIFSummaryIfBkgDt(cBFIFSummaryListVO);
			}else if("manageIfEDI".equals(cBFIFSummaryListVO.getConditionGb())){
				cBFIFSummaryListVO.setUpdUsrId(account.getUsr_id());
				cBFIFSummaryListVO.setCreUsrId(account.getUsr_id());
				
				log.debug("manageIfEDI++++");
			
				dbDao.removeCBFIFPartnerDelCgoSummary(cBFIFSummaryListVO);
				dbDao.removeCBFIFPartnerDelCgoSpeicalSummary(cBFIFSummaryListVO);
				dbDao.removeCBFIFPartnerDelCgoDgDtl(cBFIFSummaryListVO);
				dbDao.removeCBFIFPartnerDelWgt(cBFIFSummaryListVO);
				dbDao.removeCBFIFPartnerDelWgtGrp(cBFIFSummaryListVO);
				
				dbDao.addCBFIFPartnerIfBkgDtCarrier(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgDtCgoGrsWgt(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgDtDg(cBFIFSummaryListVO);
		    	dbDao.addCBFIFPartnerIfBkgDtDgDtl(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgDtAwk(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgDtRf(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgDtBb(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgDtMty(cBFIFSummaryListVO);
				dbDao.addCBFIFPartnerIfBkgWgtGrpSummary(cBFIFSummaryListVO);
				dbDao.modifyCBFIFPartnerIfUpload(cBFIFSummaryListVO);
				
				
			}else if("manageIfBkgDt".equals(cBFIFSummaryListVO.getConditionGb())){
				cBFIFSummaryListVO.setUpdUsrId(account.getUsr_id());
				cBFIFSummaryListVO.setCreUsrId(account.getUsr_id());
				cBFIFSummaryListVO.setCrrCd("SML");

				dbDao.removeCBFIFSummaryIfBkgDtCarrier(cBFIFSummaryListVO);
				dbDao.removeCBFIFSummaryIfBkgDtCgoGrsWgt(cBFIFSummaryListVO);
				dbDao.removeCBFIFSummaryIfBkgDtDtl(cBFIFSummaryListVO);
				dbDao.removeCBFIFSummaryIfBkgDt(cBFIFSummaryListVO);
				dbDao.removeCBFIFSummaryWgtGroup(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtCarrier(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtCgoGrsWgt(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtDg(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtDgDtl(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtAwk(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtRf(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtStwg(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtBb(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtBn(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryIfBkgDtMty(cBFIFSummaryListVO);
				dbDao.addCBFIFSummaryWgtGroup(cBFIFSummaryListVO);
				
			}else if("manageSOverDms".equals(cBFIFSummaryListVO.getConditionGb())){
				
				List<CBFIFSummaryListVO> insertVoList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> updateVoList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> deleteVoList = new ArrayList<CBFIFSummaryListVO>();
				
				String cbfSmryDcgoSeq = "";
				
				if (cBFIFSummaryListVOs != null && cBFIFSummaryListVOs.length > 0) {
	
					for (int i = 0; i < cBFIFSummaryListVOs.length; i++) {
	
						cBFIFSummaryListVOs[i].setUpdUsrId(account.getUsr_id());
						cBFIFSummaryListVOs[i].setCreUsrId(account.getUsr_id());
						if("I".equals(cBFIFSummaryListVOs[i].getIbflag())) {
							
							if(i==0){
								cBFIFSummaryListVO.setCbfSmrySeq(cBFIFSummaryListVO.getCbfSpclSmrySeq());
								cbfSmryDcgoSeq = dbDao.searchCBFIFSummaryCbfSmryDcgoSeq(cBFIFSummaryListVO);
							}
							
							cBFIFSummaryListVOs[i].setVslCd(cBFIFSummaryListVO.getVslCd());					//VSL_CD
							cBFIFSummaryListVOs[i].setSkdDirCd(cBFIFSummaryListVO.getSkdDirCd());			//SKD_VOY_NO 
							cBFIFSummaryListVOs[i].setSkdVoyNo(cBFIFSummaryListVO.getSkdVoyNo());			//SKD_DIR_CD
							cBFIFSummaryListVOs[i].setYdCd(cBFIFSummaryListVO.getYdCd());					//YD_CD
							cBFIFSummaryListVOs[i].setPolClptIndSeq(cBFIFSummaryListVO.getPolClptIndSeq());	//POL_CLPT_IND_SEQ
							cBFIFSummaryListVOs[i].setCrrCd(cBFIFSummaryListVO.getCrrCd());					//CRR_CD
							cBFIFSummaryListVOs[i].setPodCd(cBFIFSummaryListVO.getPodCd());					//POD_CD
							cBFIFSummaryListVOs[i].setBlckStwgCd(cBFIFSummaryListVO.getBlckStwgCd());		//BLCK_STWG_CD
							cBFIFSummaryListVOs[i].setCbfSmrySeq(cBFIFSummaryListVO.getCbfSpclSmrySeq());	//CBF_SMRY_SEQ
							cBFIFSummaryListVOs[i].setCbfSmryDcgoSeq(Integer.toString(Integer.parseInt(cbfSmryDcgoSeq)+i));
							
							insertVoList.add(cBFIFSummaryListVOs[i]);
						}else if("U".equals(cBFIFSummaryListVOs[i].getIbflag())) {
							updateVoList.add(cBFIFSummaryListVOs[i]);
						}else if("D".equals(cBFIFSummaryListVOs[i].getIbflag())) {
							deleteVoList.add(cBFIFSummaryListVOs[i]);
						}
					}
				}
				
				if (insertVoList.size() > 0) {
					dbDao.addCBFIFSummaryOverDms(insertVoList);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyCBFIFSummaryOverDms(updateVoList);
				}
				if (deleteVoList.size() > 0) {
					dbDao.removeCBFIFSummaryOverDms(deleteVoList);
				}
				
			}else{
				String cbfSpclSmrySeq = dbDao.searchCBFIFSummaryCbfSpclSmrySeq(cBFIFSummaryListVO);
				
				List<CBFIFSummaryListVO> insertVoPodList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> updateVoPodList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> deleteVoPodList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> insertVoSpecialList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> updateVoSpecialList = new ArrayList<CBFIFSummaryListVO>();
				List<CBFIFSummaryListVO> deleteVoSpecialList = new ArrayList<CBFIFSummaryListVO>();
				
				// Carrier POD 정보 셋팅.
				if (cBFIFSummaryListVOs != null && cBFIFSummaryListVOs.length > 0) {
	
					for (int i = 0; i < cBFIFSummaryListVOs.length; i++) {
	
						cBFIFSummaryListVOs[i].setUpdUsrId(account.getUsr_id());
						cBFIFSummaryListVOs[i].setCreUsrId(account.getUsr_id());
						if("I".equals(cBFIFSummaryListVOs[i].getIbflag())) {
							
							cBFIFSummaryListVOs[i].setVslCd(cBFIFSummaryListVO.getVslCd());					//VSL_CD
							cBFIFSummaryListVOs[i].setSkdDirCd(cBFIFSummaryListVO.getSkdDirCd());			//SKD_VOY_NO 
							cBFIFSummaryListVOs[i].setSkdVoyNo(cBFIFSummaryListVO.getSkdVoyNo());			//SKD_DIR_CD
							cBFIFSummaryListVOs[i].setYdCd(cBFIFSummaryListVO.getPolCd());					//YD_CD
							cBFIFSummaryListVOs[i].setPolClptIndSeq(cBFIFSummaryListVO.getPolClptIndSeq());	//POL_CLPT_IND_SEQ
							cBFIFSummaryListVOs[i].setCrrCd(cBFIFSummaryListVO.getCrrCd());					//CRR_CD
							cBFIFSummaryListVOs[i].setCbfIndFlg((cBFIFSummaryListVO.getCbfIndFlg()));					//CRR_CD
							cBFIFSummaryListVOs[i].setPodCd(cBFIFSummaryListVOs[i].getPodStwgCd());			//POD_CD
							cBFIFSummaryListVOs[i].setBlckStwgCd((cBFIFSummaryListVOs[i].getPodStwgCd()).substring(2, 5));	//BLCK_STWG_CD
							
							insertVoPodList.add(cBFIFSummaryListVOs[i]);
						}else if("U".equals(cBFIFSummaryListVOs[i].getIbflag())) {
							updateVoPodList.add(cBFIFSummaryListVOs[i]);
						}else if("D".equals(cBFIFSummaryListVOs[i].getIbflag())) {
							deleteVoPodList.add(cBFIFSummaryListVOs[i]);
						}
					}
					
				}
				
				// Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보 셋팅.
				if (cbfIFSummarySpecialListVOs != null && cbfIFSummarySpecialListVOs.length > 0) {
	
					for (int i = 0; i < cbfIFSummarySpecialListVOs.length; i++) {
	
						cbfIFSummarySpecialListVOs[i].setUpdUsrId(account.getUsr_id());
						cbfIFSummarySpecialListVOs[i].setCreUsrId(account.getUsr_id());
						if("I".equals(cbfIFSummarySpecialListVOs[i].getIbflag())) {
							
							cbfIFSummarySpecialListVOs[i].setVslCd(cBFIFSummaryListVO.getVslCd());					//VSL_CD
							cbfIFSummarySpecialListVOs[i].setSkdDirCd(cBFIFSummaryListVO.getSkdDirCd());			//SKD_VOY_NO 
							cbfIFSummarySpecialListVOs[i].setSkdVoyNo(cBFIFSummaryListVO.getSkdVoyNo());			//SKD_DIR_CD
							cbfIFSummarySpecialListVOs[i].setYdCd(cBFIFSummaryListVO.getPolCd());					//YD_CD
							cbfIFSummarySpecialListVOs[i].setPolClptIndSeq(cBFIFSummaryListVO.getPolClptIndSeq());	//POL_CLPT_IND_SEQ
							cbfIFSummarySpecialListVOs[i].setCrrCd(cBFIFSummaryListVO.getCrrCd());					//CRR_CD
							cbfIFSummarySpecialListVOs[i].setPodCd(cbfIFSummarySpecialListVOs[i].getPodNm());				//POD_CD
							cbfIFSummarySpecialListVOs[i].setBlckStwgCd((cbfIFSummarySpecialListVOs[i].getPodNm()).substring(2, 5));	//BLCK_STWG_CD
							cbfIFSummarySpecialListVOs[i].setCbfSpclSmrySeq(Integer.toString(Integer.parseInt(cbfSpclSmrySeq)+i));
							
							if(!"".equals(cBFIFSummaryListVO.getDcgoFlg()) && cBFIFSummaryListVO.getDcgoFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setDcgoFlg(cBFIFSummaryListVO.getDcgoFlg());
							}else if(!"".equals(cBFIFSummaryListVO.getRcFlg()) && cBFIFSummaryListVO.getRcFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setRcFlg(cBFIFSummaryListVO.getRcFlg());
							}else if(!"".equals(cBFIFSummaryListVO.getAwkCgoFlg()) && cBFIFSummaryListVO.getAwkCgoFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setAwkCgoFlg(cBFIFSummaryListVO.getAwkCgoFlg());
							}else if(!"".equals(cBFIFSummaryListVO.getBbCgoFlg()) && cBFIFSummaryListVO.getBbCgoFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setBbCgoFlg(cBFIFSummaryListVO.getBbCgoFlg());
							}else if(!"".equals(cBFIFSummaryListVO.getBdlCgoFlg()) && cBFIFSummaryListVO.getBdlCgoFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setBdlCgoFlg(cBFIFSummaryListVO.getBdlCgoFlg());
							}else if(!"".equals(cBFIFSummaryListVO.getStwgCgoFlg()) && cBFIFSummaryListVO.getStwgCgoFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setStwgCgoFlg(cBFIFSummaryListVO.getStwgCgoFlg());
							}else if(!"".equals(cBFIFSummaryListVO.getMtyBkgFlg()) && cBFIFSummaryListVO.getMtyBkgFlg() != null) {
								cbfIFSummarySpecialListVOs[i].setMtyBkgFlg(cBFIFSummaryListVO.getMtyBkgFlg());
							}
							
							insertVoSpecialList.add(cbfIFSummarySpecialListVOs[i]);
						}else if("U".equals(cbfIFSummarySpecialListVOs[i].getIbflag())) {
							updateVoSpecialList.add(cbfIFSummarySpecialListVOs[i]);
						}else if("D".equals(cbfIFSummarySpecialListVOs[i].getIbflag())) {
							cbfIFSummarySpecialListVOs[i].setCbfSmrySeq(cbfIFSummarySpecialListVOs[i].getCbfSpclSmrySeq());	//CBF_SMRY_SEQ
							deleteVoSpecialList.add(cbfIFSummarySpecialListVOs[i]);
						}
					}
				}
				
				// Weight 정보 수정.
				cBFIFSummaryListVO.setUpdUsrId(account.getUsr_id());
				cBFIFSummaryListVO.setCreUsrId(account.getUsr_id());
				dbDao.modifyCBFIFSummaryCgoGrsWgt(cBFIFSummaryListVO);
				
				// Carrier POD 정보 저장/수정/삭제.
				if (insertVoPodList.size() > 0) {
					dbDao.addCBFIFSummaryPod(insertVoPodList);
				}
				if (updateVoPodList.size() > 0) {
					dbDao.modifyCBFIFSummaryPod(updateVoPodList);
				}
				if (deleteVoPodList.size() > 0) {
					dbDao.removeCBFIFSummaryPod(deleteVoPodList);
				}

				// Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보 저장/수정/삭제.
				if (insertVoSpecialList.size() > 0) {
					dbDao.addCBFIFSummarySpecial(insertVoSpecialList);
				}
				if (updateVoSpecialList.size() > 0) {
					dbDao.modifyCBFIFSummarySpecial(updateVoSpecialList);
				}
				if (deleteVoSpecialList.size() > 0) {
					dbDao.removeCBFIFSummarySpecialOverDms(deleteVoSpecialList);
					dbDao.removeCBFIFSummarySpecial(deleteVoSpecialList);
				}
				
			}			
			
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Own CBF"}).getMessage(), de);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Own CBF"}).getMessage(), de);
		}
	}

	/**
	 * CBF - Creation : Over Dimension 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<List<CBFIFSummaryListVO>> searchCBFIFSummaryOverDmsList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			List<CBFIFSummaryListVO> list = dbDao.searchCBFIFSummaryOverDmsList(cBFIFSummaryListVO);
			
			rsltList.add(list);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
		return rsltList;
	}

	/**
	 * CBF - Creation : Carrier 정보를 조회합니다. <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @return List<List<CBFIFSummaryListVO>>
	 * @exception EventException
	 */
	public List<List<CBFIFSummaryListVO>> searchCBFIFSummaryCarrierAllList(CBFIFSummaryListVO cBFIFSummaryListVO) throws EventException {		
		List<List<CBFIFSummaryListVO>> rsltList = new ArrayList<List<CBFIFSummaryListVO>>();
		try {
			List<CBFIFSummaryListVO> list = dbDao.searchCBFIFSummaryCarrierAllList(cBFIFSummaryListVO);
			
			rsltList.add(list);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
		return rsltList;
	}
	
	/**
	 * CBF Summary 정보를 조회합니다.<br>
	 * 
	 * @param  String vvd  
	 * @param  String ydCd
	 * @param  String polclptindseq
	 * @return List<CBFAllSummaryPreviewVO>
	 * @exception EventException
	 */
	public List<CBFAllSummaryPreviewVO> searchCBFAllSummary(String vvd,  String ydCd, String polclptindseq) throws EventException {
		try {
			return dbDao.searchCBFAllSummary(vvd,ydCd,polclptindseq);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), e);
		}
	}
	
	/**
	 * CBF: CLL과 BOOKING DATA 비교 LIST<br>
	 * 
	 * @param  String vvd  
	 * @param  String ydCd
	 * @param  String polclptindseq
	 * @return List<CBFIFSummaryDiffListVO>
	 * @exception EventException
	 */
	public List<CBFIFSummaryDiffListVO> searchCBFIFSummaryDiffCntrList(String vvd,  String ydCd, String polclptindseq) throws EventException {
		try {
			return dbDao.searchCBFIFSummaryDiffCntrList(vvd,ydCd,polclptindseq);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), e);
		}
	}
	
	/**
	 * VVD 정보를 체크합니다.<br>
	 * 
	 * @param  CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdExist(CBFPartnerEDIVO cBFPartnerEDIVO) throws EventException {		
		try {
			return dbDao.checkVvdExist(cBFPartnerEDIVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VVD"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VVD"}).getMessage(), ex);
		}
	}
	
	/**
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param  CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTypeSizeCd(CBFPartnerEDIVO cBFPartnerEDIVO) throws EventException {		
		try {
			return dbDao.checkTypeSizeCd(cBFPartnerEDIVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"type size"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"type size"}).getMessage(), ex);
		}
	}
	
	/**
	 * yard 정보를 가져온다.<br>
	 * 
	 * @param  CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return List<SearchYardCodeVO>
	 * @exception EventException
	 */
	public List<SearchYardCodeVO> checkYardCd(CBFPartnerEDIVO cBFPartnerEDIVO) throws EventException {		
		try {
			return dbDao.checkYardCd(cBFPartnerEDIVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"yard code"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"yard code"}).getMessage(), ex);
		}
	}

	
	/**
	 * CBF: Partner CLL EDI LIST<br>
	 * 
	 * @param  CBFPartnerConditionVO cBFPartnerConditionVO
	 * @return List<CBFPartnerEDIVO>
	 * @exception EventException
	 */
	public List<CBFPartnerEDIVO> searchCBFPartnerEDIList(CBFPartnerConditionVO cBFPartnerConditionVO) throws EventException {
		try {
			return dbDao.searchCBFPartnerEDIList(cBFPartnerConditionVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Summary"}).getMessage(), e);
		}
	}
	
	/**
	 * OPF EDIT 전문 List 정렬 후 저장
	 * @param ediFlatFile
	 * @param opfPrnrEdiLogVO
	 * @throws EventException
	 */
	public void addOpfPartnerEdiCgoBkgFcast(String ediFlatFile, OpfPrnrEdiLogVO opfPrnrEdiLogVO) throws EventException{
		
		List<OpfPrnrEdiCgoBkgFcastVO> opfPrnrEdiCgoBkgFcastVOs 	= new ArrayList<OpfPrnrEdiCgoBkgFcastVO>();
		OpfPrnrEdiCgoBkgFcastVO opfPrnrEdiCgoBkgFcastVO 		= new OpfPrnrEdiCgoBkgFcastVO();

		try{
//			/* DB 연결 테스트 완려 후 하기로직 삭제 DAO도 함꼐 -------------------*/
//			log.debug("addOpfPartnerEdiCgoBkgFcast start ");
//			String dbinfo = "";
//			dbinfo = dbDao.searchTestOpfPrnrEdi();
//			log.debug("==dbinfo : " + dbinfo);
//			/*---------------------------------------------------*/
			
//			opfPrnrEdiLogVO.setCreUsrId("SYSTEM");
//			opfPrnrEdiLogVO.setUpdUsrId("SYSTEM");
//			opfPrnrEdiLogVO.setScsFlg("N");
//			int nextLogSeq	= 1;
//			nextLogSeq		= dbDao.searchEdiLogNextSeq();
//			opfPrnrEdiLogVO.setRcvSeq(Integer.toString(nextLogSeq));
//			
//			// 최초 생성 - 필수 값만 저장
//			dbDao.addOpfPrnrEdiLog(opfPrnrEdiLogVO);
			
			String flatFile = "";
			
			if (ediFlatFile != null) {
				
				flatFile = ediFlatFile;
				
				int blInfoCnt					= 0;
				String flatFileTmp				= "";
				String[] blInfoInfoSize 		= flatFile.split("\\{BL_INFO");
				String[] blInfoInfo 			= new String[blInfoInfoSize.length - 1] ;// 헤더 부분까지 포함되므로 -1 해줌
				String[] headerArr				= null;
				String headerKey				= null;
				String headerTmp				= null;
				String headerLogTmp				= null;
				StringBuffer headerData 		= new StringBuffer();
				ArrayList<String> headerList	= null;
				
				String vslCd					= ""; //DB 조회값
				String crrCd					= ""; //DB 조회값
				String crrNm					= "";
				String vvd						= "";
				String port						= "";
				String eta						= "";
				String voyDir					= "";
				String ydCodeClptSeq			= "";
				String vslCallsign				= "";
				String vslFullname				= "";
				
				flatFileTmp = flatFile;
				
				//HEADER START
				if(blInfoInfoSize.length > 1){
					headerTmp	= flatFileTmp.substring(flatFileTmp.indexOf("MSGSTART"),flatFileTmp.indexOf("{BL_INFO"));
					headerList	= flatFileConvertList(headerTmp);
				
					headerData	= new StringBuffer();

					for(int i=0; i < headerList.size(); i++){
						headerArr = headerList.get(i).toString().trim().split(":",2);
						headerKey = headerArr[0];

						if("MSGSTART".equals(headerKey)){
							crrNm = headerArr[1].toString().substring(0,headerArr[1].indexOf(" "));
							headerData.append("^^" + headerKey + ":" + crrNm);
							
							// crrCd 조회
							if(crrNm != null && !"".equals(crrNm)){
								crrCd = dbDao.searchCBFIFPartnerCarrier(crrNm);
								if(crrCd != null){
									headerData.append("^^CRR_CD:" + crrCd);
								}
							}
							
							// Log data 추출 START
							headerLogTmp	= headerArr[1].toString();
							opfPrnrEdiLogVO.setCrrNm(headerLogTmp.substring(0, headerLogTmp.indexOf(" ")).trim());
							
							headerLogTmp	= headerLogTmp.substring(headerLogTmp.indexOf(" ")).trim();
							opfPrnrEdiLogVO.setEdiSkdDirNm(headerLogTmp.substring(0, headerLogTmp.indexOf(" ")).trim());
							
							headerLogTmp	= headerLogTmp.substring(headerLogTmp.indexOf(" ")).trim();
							opfPrnrEdiLogVO.setEdiMsgTpId(headerLogTmp.substring(0, headerLogTmp.indexOf(" ")).trim());
							
							headerLogTmp	= headerLogTmp.substring(headerLogTmp.indexOf(" ")).trim();
							
							headerArr = headerLogTmp.trim().split(":",2);
							headerKey = headerArr[0];
							
							if("UDEV".equals(headerKey)){
								headerData.append("^^" + headerKey + ":" + headerArr[1].toString().trim());
								opfPrnrEdiLogVO.setEdiSndId(headerArr[1].toString().trim());
							}
							
							else if("UBIZ1".equals(headerKey)){
								headerData.append("^^" + headerKey + ":" + headerArr[1].toString().trim());
								opfPrnrEdiLogVO.setEdiSndId(headerArr[1].toString().trim());
							}
							// Log data 추출 END
							
						}else if("VVD".equals(headerKey) 
								|| "VSL_CALLSIGN".equals(headerKey) 
								|| "VSL_FULLNAME".equals(headerKey) 
								|| "PORT".equals(headerKey) 
								|| "PORTNAME".equals(headerKey) 
								|| "POL_YDCD".equals(headerKey)
								|| "POL_YDNM".equals(headerKey)
								|| "ETA".equals(headerKey)
								|| "ETD".equals(headerKey)){
							
							headerData.append("^^" + headerKey + ":" + headerArr[1].toString());
							
							if("PORT".equals(headerKey)){
								port = headerArr[1].toString();
							}
							
							if("ETA".equals(headerKey)){
								eta = headerArr[1].toString();
							}
							
							if("VSL_CALLSIGN".equals(headerKey)){
								vslCallsign = headerArr[1].toString();
							}
							
							if("VSL_FULLNAME".equals(headerKey)){
								vslFullname = headerArr[1].toString();
							}
							
							if("VVD".equals(headerKey)){
								vvd = headerArr[1].toString();
								// Log data 추출 START
								opfPrnrEdiLogVO.setEdiVslNm(headerArr[1].toString());
							}
							// Log data 추출 END
						}
					}
					
					// EDI Log 기본 데이터 저장 
					dbDao.modifyOpfPrnrEdiLog(opfPrnrEdiLogVO);
					
					//VSL_CD 조회
					vslCd = dbDao.searchCBFIFPartnerVesselName(vslCallsign, vslFullname);
					if(vslCd != null){
						headerData.append("^^VSL_CD:" + vslCd);
					}
					
					// SKD_VOY_NO, SKD_DIR_CD 조회
					voyDir = dbDao.searchCBFIFPartnerVoyageDirection(vvd, vslCd, port, eta);
					
					if(voyDir != null && !"".equals(voyDir) && voyDir.length() >= 5){
						headerData.append("^^SKD_VOY_NO:" + voyDir.substring(0, 4));
						headerData.append("^^SKD_DIR_CD:" + voyDir.substring(4, 5));
						
						// YD_CD, POL_CLPT_IND_SEQ 조회
						ydCodeClptSeq = dbDao.searchCBFIFPartnerYardCodeCallingPortIndicatorSequence(voyDir.substring(0, 4), voyDir.substring(4, 5), vslCd, port, eta);
						if(ydCodeClptSeq != null && !"".equals(ydCodeClptSeq) && ydCodeClptSeq.length() >= 8){
							headerData.append("^^YD_CD:" + ydCodeClptSeq.substring(0, 7));
							headerData.append("^^POL_CLPT_IND_SEQ:" + ydCodeClptSeq.substring(7, 8));
						}
					}
				}else{
					headerData = new StringBuffer();
				}
				//HEADER END
				
				//BL_INFO START
				for(int i=0; i < blInfoInfoSize.length; i++){
					if (flatFileTmp.indexOf("{BL_INFO") > -1 && flatFileTmp.indexOf("}BL_INFO") > -1) {
						
						// 1차 분할 BL_INFO
						blInfoInfo[blInfoCnt] = flatFileTmp.substring(flatFileTmp.indexOf("{BL_INFO"), flatFileTmp.indexOf("}BL_INFO"));
						
						blInfoCnt++;
						// 다음처리할 BL_INFO 담기
						flatFileTmp = flatFileTmp.substring(flatFileTmp.indexOf("}BL_INFO"));
						
						if(flatFileTmp.length() > "}BL_INFO".length()+3){
							flatFileTmp = flatFileTmp.substring(flatFileTmp.indexOf("{BL_INFO"));
						}
					}

					if(flatFileTmp.indexOf("{BL_INFO") == -1){
						i = blInfoInfoSize.length;
					}
				}
				// BL_INFO END
				
				String   cntrInfoTmp 				= null;
				String[] cntrInfoSize				= null;
				String[] cntrInfo					= null; 
				String[] cntrInfoArr				= null;
				String 	 cntrInfoKey 				= null;
				ArrayList<String> cntrInfoList		= null;
				
				String   cntrDangerTmp				= null;
				String[] cntrDangerSize				= null;
				String[] cntrDanger					= null;
				String[] cntrDangerArr  			= null;
				String 	 cntrDangerKey 				= null;
				ArrayList<String> cntrDangerList	= null;
				
				String   bkgVvdTmp					= null;
				String[] bkgVvdSize					= null;
				String[] bkgVvd						= null;
				String[] bkgVvdArr					= null;
				String   bkgVvdChk					= null;
				String 	 bkgVvdKey					= null;
				StringBuffer bkgVvdDataTmp			= new StringBuffer();
				ArrayList<String> bkgVvdList 		= null;
				
				String   blInfoTmp					= null;
				String[] blInfodArr					= null;
				String 	 blInfoKey					= null;
				ArrayList<String> blInfoList 		= null;
				
				String[] ediDataToList				= null;
				String[] ediDataToListRow			= null;
				String[] listDataArr  				= null;
				String 	 listDataKey 				= null;
				
				String bkgVvdData					= "";
				
				StringBuffer cntrInfoData			= new StringBuffer();
				StringBuffer cntrDangerData			= new StringBuffer();
				StringBuffer blInfoData				= new StringBuffer();
				StringBuffer finalData				= new StringBuffer();
				
				String blpod1						= null;
				String podCd						= null;
				
				//------- BL_INFO & CNTR_INFO & BKGVVD START
				for(int i=0; i < blInfoInfo.length; i++){
					
					//BL_INFO START 단건 데이터 처리 
					blInfoData = new StringBuffer();
					if(blInfoInfo[i].indexOf("{BL_INFO") > -1){

						blInfoTmp	= blInfoInfo[i].substring(blInfoInfo[i].indexOf("{BL_INFO"), blInfoInfo[i].indexOf("{CNTR_INFO"));// BL_INFO 단건 데이터
						blInfoList	= flatFileConvertList(blInfoTmp);
						
						for(int m=0; m < blInfoList.size(); m++){
							blInfodArr	= blInfoList.get(m).toString().trim().split(":",2);
							blInfoKey	= blInfodArr[0];
							if("BLNBR".equals(blInfoKey) || "CARGOTYPE".equals(blInfoKey)){
								blInfoData.append("^^" + blInfoKey + ":" + blInfodArr[1].toString());
							}
						}
					}
					//BL_INFO END 단건 데이터 처리 
					
					//BKGVVD START
					if(blInfoInfo[i].indexOf("{BKGVVD") > -1){
						
						bkgVvdSize	= blInfoInfo[i].split("\\{BKGVVD"); //BKGVVD count
						bkgVvdTmp	= blInfoInfo[i];
						bkgVvd		= new String[bkgVvdSize.length-1];
						bkgVvdData	= "";
						
						for(int ii=0; ii < bkgVvd.length; ii++){
							if (bkgVvdTmp.indexOf("{BKGVVD") > -1 && bkgVvdTmp.indexOf("}BKGVVD") > -1) {
								
								bkgVvd[ii]	= bkgVvdTmp.substring(bkgVvdTmp.indexOf("{BKGVVD"), bkgVvdTmp.indexOf("}BKGVVD"));// BKGVVD DATA 담기
								bkgVvdTmp	= bkgVvdTmp.substring(bkgVvdTmp.indexOf("}BKGVVD"));
								
								bkgVvdList = flatFileConvertList(bkgVvd[ii]);
								
								bkgVvdChk		= "N";
								blpod1			= null;
								bkgVvdDataTmp	= new StringBuffer();
								
								for(int l=0; l < bkgVvdList.size(); l++){
									
									bkgVvdArr = bkgVvdList.get(l).toString().trim().split(":",2);
									bkgVvdKey = bkgVvdArr[0];
									
									if("BVVD1".equals(bkgVvdKey)){
//										if(bkgVvdArr[1].toString().trim().length() > 8 &&  headerData.indexOf(bkgVvdArr[1].toString()) > -1){ // BVVD1 와 VVD 같은지 확인
										if(headerData.indexOf(bkgVvdArr[1].toString()) > -1){ // BVVD1 와 VVD 같은지 확인 - 길이체크 안함
											bkgVvdChk = "Y";
										}
										bkgVvdDataTmp.append("^^" + bkgVvdKey + ":" + bkgVvdArr[1].toString());
									}else if("VSL_CALLSIGN1".equals(bkgVvdKey)
											|| "VSL_FULLNAME1".equals(bkgVvdKey)
											|| "BLPOD1".equals(bkgVvdKey)
											|| "BLPOD_YDCD1".equals(bkgVvdKey)
											|| "BLPOD_YDNM1".equals(bkgVvdKey)
											|| "POD_FULLNAME1".equals(bkgVvdKey)
											|| "PODETA1".equals(bkgVvdKey)){
										
										// 최소한의 roop 내에서 POD_CD 를 조회하기 위해 변수에 담음
										if("Y".equals(bkgVvdChk) && "BLPOD1".equals(bkgVvdKey)){
											blpod1 = bkgVvdArr[1].toString();
										}
										
										bkgVvdDataTmp.append("^^" + bkgVvdKey + ":" + bkgVvdArr[1].toString());
									}
								}
								
								if("Y".equals(bkgVvdChk)){
									// podCd 조회
									podCd = dbDao.searchCBFIFPartnerPortCode(blpod1);
									if(podCd != null){
										bkgVvdDataTmp.append("^^POD_CD:" + podCd);
									}
									
									bkgVvdData = bkgVvdDataTmp.toString();
								}
								
								if(bkgVvdTmp.indexOf("{BKGVVD") > -1){
									bkgVvdTmp = bkgVvdTmp.substring(bkgVvdTmp.indexOf("{BKGVVD"));
								}
							}
						}
					}
					//BKGVVD END

					// {CNTR_INFO / CNTR_INFO}
					if(blInfoInfo[i].indexOf("{CNTR_INFO") > -1){

						cntrInfoSize 	= blInfoInfo[i].split("\\{CNTR_INFO"); //CNTR_INFO count
						cntrInfoTmp 	= blInfoInfo[i];
						
						// CNTR_INFO ROOP START
//						if(cntr_info_size.length > 1){ //CNTR_INFO 가 있으면
						cntrInfo = new String[cntrInfoSize.length-1];
							
							for(int j=0; j < cntrInfo.length; j++){ //CNTR_INFO 배열 생성
								
								if (cntrInfoTmp.indexOf("{CNTR_INFO") > -1 && cntrInfoTmp.indexOf("}CNTR_INFO") > -1) {
									
									cntrInfo[j]		= cntrInfoTmp.substring(cntrInfoTmp.indexOf("{CNTR_INFO"), cntrInfoTmp.indexOf("}CNTR_INFO"));// CNTR_INFO DATA 담기
									cntrInfoList	= flatFileConvertList(cntrInfo[j]);
										
									for(int jj=0; jj < cntrInfoList.size(); jj++){
										cntrInfoArr = cntrInfoList.get(jj).toString().trim().split(":",2);
										cntrInfoKey = cntrInfoArr[0];
										
										if("CNTRNBR".equals(cntrInfoKey)
												|| "CNTRWGT".equals(cntrInfoKey) || "CNTR_WGT_UNIT".equals(cntrInfoKey) || "CNTR_TOTAL_WGT".equals(cntrInfoKey)
												|| "CNTR_TOTAL_WGT_UNIT".equals(cntrInfoKey) || "CNTRTYPE".equals(cntrInfoKey) || "VGM_WGTQTY".equals(cntrInfoKey)
												|| "VGM_WGTCD".equals(cntrInfoKey) || "FM_IND".equals(cntrInfoKey)
												|| "RF_IND".equals(cntrInfoKey) || "DG_IND".equals(cntrInfoKey) || "AK_IND".equals(cntrInfoKey)
												|| "BK_IND".equals(cntrInfoKey) || "TEMP".equals(cntrInfoKey) || "OVF".equals(cntrInfoKey)
												|| "OVR".equals(cntrInfoKey) || "OVH".equals(cntrInfoKey) || "OVLW".equals(cntrInfoKey)
												|| "OVRW".equals(cntrInfoKey) || "STWG_REQ".equals(cntrInfoKey)){
											
											cntrInfoData.append("^^" + cntrInfoKey + ":" + cntrInfoArr[1].toString());
										}
									}

									// CNTR_DANGER START
									if(cntrInfo[j].indexOf("{CNTR_DANGER") > -1){
										cntrDangerSize	= cntrInfo[j].split("\\{CNTR_DANGER"); //CNTR_DANGER count
										cntrDangerTmp 	= cntrInfo[j];
										cntrDanger 		= new String[cntrDangerSize.length-1];
										
										// CNTR_DANGER ROOP START
										for(int k=0; k < cntrDanger.length; k++){
											if (cntrDangerTmp.indexOf("{CNTR_DANGER") > -1 && cntrDangerTmp.indexOf("}CNTR_DANGER") > -1) {

												cntrDanger[k] = cntrDangerTmp.substring(cntrDangerTmp.indexOf("{CNTR_DANGER"), cntrDangerTmp.indexOf("}CNTR_DANGER"));// CNTR_DANGER DATA 담기
												cntrDangerTmp = cntrDangerTmp.substring(cntrDangerTmp.indexOf("}CNTR_DANGER"));
												
												//전문을 \n으로 나누어 new line으로 떨어 뜨린다.
												cntrDangerList = flatFileConvertList(cntrDanger[k]);
												
												for(int l=0; l < cntrDangerList.size(); l++){
													
													cntrDangerArr = cntrDangerList.get(l).toString().trim().split(":",2);
													cntrDangerKey = cntrDangerArr[0];
													
													if("UNNBR".equals(cntrDangerKey) || "CLASS".equals(cntrDangerKey) || "PKGGRP".equals(cntrDangerKey)
															|| "MAR_POLL".equals(cntrDangerKey) || "STWG".equals(cntrDangerKey)){

														cntrDangerData.append("^^" + cntrDangerKey + ":" + cntrDangerArr[1].toString());
													}
												}

												finalData.append("@@" + headerData + blInfoData + cntrInfoData + cntrDangerData + bkgVvdData);

												cntrDangerData = new StringBuffer();
												
												if(cntrDangerTmp.indexOf("{CNTR_DANGER") > -1){
													cntrDangerTmp = cntrDangerTmp.substring(cntrDangerTmp.indexOf("{CNTR_DANGER"));
												}
											}
										}// CNTR_DANGER ROOP END
									}else{
										finalData.append("@@" + headerData + blInfoData + cntrInfoData + bkgVvdData);
									}// CNTR_DANGER END

									cntrInfoTmp = cntrInfoTmp.substring(cntrInfoTmp.indexOf("}CNTR_INFO"));
									
									if(cntrInfoTmp.indexOf("{CNTR_INFO") > -1){
										cntrInfoTmp = cntrInfoTmp.substring(cntrInfoTmp.indexOf("{CNTR_INFO"));
									}
								}
								cntrInfoData = new StringBuffer();
							}// CNTR_INFO ROOP END
//						}
					}
				}
				//-------CNTR_INFO END
				
				log.debug("finalData : " + finalData);
				
				ediDataToList = finalData.toString().split("@@");
				
				for(int p=1; p < ediDataToList.length; p++){
//					log.debug("ediDataToList["+ p +"] : " + ediDataToList[p]);

					opfPrnrEdiCgoBkgFcastVO = new OpfPrnrEdiCgoBkgFcastVO();
					ediDataToListRow = ediDataToList[p].split("\\^\\^");
					
					for(int pp=1; pp < ediDataToListRow.length; pp++){
						listDataArr = ediDataToListRow[pp].toString().trim().split(":",2);
						listDataKey = listDataArr[0];
						
						// 하기 두 항목 추후 변경 가능
						opfPrnrEdiCgoBkgFcastVO.setCreUsrId("SYSTEM");
						opfPrnrEdiCgoBkgFcastVO.setUpdUsrId("SYSTEM");
						
						if("MSGSTART".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setCrrNm(listDataArr[1].toString());		// CRR_NM
						}else if("UDEV".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEdiSndId(listDataArr[1].toString());		// EDI_SND_ID
						}else if("UBIZ1".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEdiSndId(listDataArr[1].toString());		// EDI_SND_ID
						}else if("VVD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setCbfRmk(listDataArr[1].toString());		// CBF_RMK
						}else if("VSL_CALLSIGN".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("VSL_FULLNAME".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEdiVslNm(listDataArr[1].toString());		// EDI_VSL_NM
						}else if("PORT".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEdiPolYdCd(listDataArr[1].toString());	// EDI_POL_YD_CD
						}else if("PORTNAME".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("POL_YDCD".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
//							opfPrnrEdiCgoBkgFcastVO.setEdiPolYdCd(listDataArr[1].toString());		// EDI_POL_YD_CD
						}else if("POL_YDNM".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("ETA".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEtaDt(listDataArr[1].toString());		// ETA DT
						}else if("ETD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEtdDt(listDataArr[1].toString());		// ETD DT
						}else if("VSL_CD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setVslCd(listDataArr[1].toString());		// VSL_CD
						}else if("SKD_VOY_NO".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setSkdVoyNo(listDataArr[1].toString());		// SKD_VOY_NO
						}else if("SKD_DIR_CD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setSkdDirCd(listDataArr[1].toString());		// SKD_DIR_CD
						}else if("YD_CD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setYdCd(listDataArr[1].toString());		// YD_CD
						}else if("POL_CLPT_IND_SEQ".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setPolClptIndSeq(listDataArr[1].toString());	// POL_CLPT_IND_SEQ
						}else if("CRR_CD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setCrrCd(listDataArr[1].toString());		// CRR_CD
						}else if("POD_CD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setPodCd(listDataArr[1].toString());		// POD_CD
						}else if("BLNBR".equals(listDataKey)){
							if(listDataArr[1] != null && listDataArr[1].length() > 12){			// EDI_BL_NO
								opfPrnrEdiCgoBkgFcastVO.setEdiBlNo(listDataArr[1].toString().substring(0, 12));
							}else{
								opfPrnrEdiCgoBkgFcastVO.setEdiBlNo(listDataArr[1].toString());		
							}
						}else if("CARGOTYPE".equals(listDataKey)){
							if(listDataArr[1] != null && "E".equals(listDataArr[1].toString())){	// MTY_BKG_FLG
								opfPrnrEdiCgoBkgFcastVO.setMtyBkgFlg("Y");
							}else{
								opfPrnrEdiCgoBkgFcastVO.setMtyBkgFlg("");		
							}
						}else if("CNTRNBR".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setCntrNo(listDataArr[1].toString());	// CNTR_NO
						}else if("CNTRWGT".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setTtlWgt(listDataArr[1].toString());	// TTL_WGT
						}else if("CNTR_WGT_UNIT".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setCntrWgtUtCd(listDataArr[1].toString());	// CNTR_WGT_UT_CD
						}else if("CNTR_TOTAL_WGT".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("CNTR_TOTAL_WGT_UNIT".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("CNTRTYPE".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setCntrTpszCd(listDataArr[1].toString());	// CNTR_TPSZ_CD
							opfPrnrEdiCgoBkgFcastVO.setIsoCntrTpszCd(listDataArr[1].toString());	// ISO_CNTR_TPSZ_CD
						}else if("VGM_WGTQTY".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setVgmWgt(listDataArr[1].toString());	// VGM_WGTQTY
						}else if("VGM_WGTCD".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setVgmWgtUtCd(listDataArr[1].toString());	// VGM_WGTCD
						}else if("FM_IND".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("RF_IND".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setRcFlg(listDataArr[1].toString());	// RC_FLG
						}else if("DG_IND".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setDcgoFlg(listDataArr[1].toString());	// DCGO_FLG
						}else if("AK_IND".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setAwkCgoFlg(listDataArr[1].toString());	// AWK_CGO_FLG
						}else if("BK_IND".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setBbCgoFlg(listDataArr[1].toString());	// BB_CGO_FLG
						}else if("TEMP".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("OVF".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setFwrdOvrDimLen(listDataArr[1].toString());	// FWRD_OVR_DIM_LEN
						}else if("OVR".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setBkwdOvrDimLen(listDataArr[1].toString());	// BKWD_OVR_DIM_LEN
						}else if("OVH".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setHgtOvrDimLen(listDataArr[1].toString());		// HGT_OVR_DIM_LEN
						}else if("OVLW".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setLfSdOvrDimLen(listDataArr[1].toString());	// LF_SD_OVR_DIM_LEN
						}else if("OVRW".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setRtSdOvrDimLen(listDataArr[1].toString());	// RT_SD_OVR_DIM_LEN
						}else if("STWG_REQ".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
//							opfPrnrEdiCgoBkgFcastVO.setCbfRmk(listDataArr[1].toString());	// CBF_RMK
						}else if("UNNBR".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setImdgUnNo(listDataArr[1].toString());	// IMDG_UN_NO
						}else if("CLASS".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setImdgClssCd(listDataArr[1].toString());	// IMDG_CLSS_CD
						}else if("PKGGRP".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("MAR_POLL".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setMrnPolutFlg(listDataArr[1].toString());	// MRN_POLUT_FLG							
						}else if("STWG".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("BVVD1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("VSL_CALLSIGN1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("VSL_FULLNAME1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("BLPOD1".equals(listDataKey)){
							opfPrnrEdiCgoBkgFcastVO.setEdiPodCd(listDataArr[1].toString());	// EDI_POD_CD
						}else if("BLPOD_YDCD1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("BLPOD_YDNM1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("POD_FULLNAME1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}else if("PODETA1".equals(listDataKey)){
							listDataKey.trim(); // 소스품질용 - 로직과 무관
						}
					}
					
					opfPrnrEdiCgoBkgFcastVOs.add(opfPrnrEdiCgoBkgFcastVO);
				}
				
				for(int r=0; r <opfPrnrEdiCgoBkgFcastVOs.size(); r++){
					dbDao.addOpfPrnrEdiCgoBkgFcast(opfPrnrEdiCgoBkgFcastVOs.get(r));
				}
				
				opfPrnrEdiLogVO.setScsFlg("Y");
				dbDao.modifyOpfPrnrEdiLog(opfPrnrEdiLogVO);
			}else{
				// EDI 실패 Log 저장
				opfPrnrEdiLogVO.setRsltMsg("ediFlatFile data is null");
				dbDao.modifyOpfPrnrEdiLog(opfPrnrEdiLogVO);
			}
			
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12192", new String[]{"OPF"}).getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12157", new String[]{"OPF"}).getMessage(), ex);
		}
	}
	
	/**
	 * 전문을 \n으로 나누어 new line으로 떨어 뜨린다.
	 * 
	 * @param String sFlatFile
	 * @return ArrayList<String>
	 * @throws EventException
	 */
	private ArrayList<String> flatFileConvertList(String sFlatFile) throws EventException {
		ArrayList<String> rtnArr = new ArrayList<String>();
		try{
			StringTokenizer token = new StringTokenizer(sFlatFile, "\n");
			while (token.hasMoreTokens()) {
				rtnArr.add(token.nextToken());
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("COM12157", new String[]{"OPF"}).getMessage(), ex);
		}
		return rtnArr;
	}
	
	/**
	 * OPF EDI 전문 최초 진입 로그 저장
	 * @return OpfPrnrEdiLogVO
	 * @throws EventException
	 */
	public OpfPrnrEdiLogVO addOpfPartnerEdiCBFLog() throws EventException{
		OpfPrnrEdiLogVO opfPrnrEdiLogVO = new OpfPrnrEdiLogVO();
		
		opfPrnrEdiLogVO.setCreUsrId("SYSTEM");
		opfPrnrEdiLogVO.setUpdUsrId("SYSTEM");
		opfPrnrEdiLogVO.setScsFlg("N");
		
		int nextLogSeq	= 1;

		try{
			nextLogSeq = dbDao.searchEdiLogNextSeq();
			opfPrnrEdiLogVO.setRcvSeq(Integer.toString(nextLogSeq));
			
			// 최초 생성 - 필수 값만 저장
			dbDao.addOpfPrnrEdiLog(opfPrnrEdiLogVO);
		} catch (DAOException ex) {
			/* MSG - 입력중 오류가 발생하였습니다. */
			throw new EventException(new ErrorHandler("COM12192", new String[]{"OPF"}).getMessage(), ex);
		} catch (Exception ex) {
			/* MSG - 서비스 실행중 오류가 발생하였습니다. */
			throw new EventException(new ErrorHandler("COM12157", new String[]{"OPF"}).getMessage(), ex);
		}
		
		return opfPrnrEdiLogVO;
	}
	
	
	/**
	 * CBF: WGT GROUP SUMMARY 조회 <br>
	 * 
	 * @param  CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO
	 * @return List<CBFWgtGroupSummaryVO>
	 * @exception EventException
	 */
	public List<CBFWgtGroupSummaryVO> searchCBFWgtGroupSummary(CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO) throws EventException {
		try {
			return dbDao.searchCBFWgtGroupSummary(cBFWgtGroupSummaryVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF WGT GROUP Summary"}).getMessage(), de);
		} catch (Exception e) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF WGT GROUP Summary"}).getMessage(), e);
		}
	}
	
	/**
	 * OPF EDI 데이터 수정
	 * @param CBFWgtGroupSummaryVO[] cBFWgtGroupSummaryVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCBFWgtGroupSummary(CBFWgtGroupSummaryVO[] cBFWgtGroupSummaryVOS, SignOnUserAccount account) throws EventException {

		try {
			List<CBFWgtGroupSummaryVO> updateVoList = new ArrayList<CBFWgtGroupSummaryVO>();
		
			
			for ( int i=0; i<cBFWgtGroupSummaryVOS.length; i++ ) {
				if ( cBFWgtGroupSummaryVOS[i].getIbflag().equals("U")){
					cBFWgtGroupSummaryVOS[i].setCreUsrId(account.getUsr_id());
					updateVoList.add(cBFWgtGroupSummaryVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.manageCBFWgtGroupSummary(updateVoList);
			}	
		  
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
	
  }
	
	/**
	 * OPF EDI 데이터 수정
	 * @param CBFPartnerEDIVO[] cBFPartnerEDIVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCBFPartnerEDI(CBFPartnerEDIVO[] cBFPartnerEDIVOS, SignOnUserAccount account) throws EventException {

		try {
			List<CBFPartnerEDIVO> updateVoList = new ArrayList<CBFPartnerEDIVO>();
		
			
			for ( int i=0; i<cBFPartnerEDIVOS.length; i++ ) {
				if ( cBFPartnerEDIVOS[i].getIbflag().equals("U")){
					cBFPartnerEDIVOS[i].setCreUsrId(account.getUsr_id());
					updateVoList.add(cBFPartnerEDIVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.manageCBFPartnerEDI(updateVoList);
			}
			else {
				log.debug("no data found ******");
			}
			
		  
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
	
  }
	
}