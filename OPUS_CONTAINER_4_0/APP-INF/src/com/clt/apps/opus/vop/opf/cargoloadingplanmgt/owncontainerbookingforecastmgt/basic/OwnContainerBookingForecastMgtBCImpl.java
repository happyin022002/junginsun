/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OwnContainerBookingForecastMgtBCImpl.java
 *@FileTitle : Weight Group (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration.OwnContainerBookingForecastMgtDBDAO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.OpfCgoBkgFcastWgtGrpVO;
import com.clt.syscommon.common.table.VskCarrierVO;



/**
 * OPUS-CargoLoadingPlanMgt Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see Reference each DAO class of  VOP_OPF-3019EventResponse,OwnContainerBookingForecastMgtBC 
 * @since J2EE 1.4
 */

public class OwnContainerBookingForecastMgtBCImpl extends BasicCommandSupport implements OwnContainerBookingForecastMgtBC {

	// Database Access Object
	private transient OwnContainerBookingForecastMgtDBDAO dbDao = null;

	/**
	 * Creating object OwnContainerBookingForecastMgtBCImpl <br>
	 * Creating OwnContainerBookingForecastMgtDBDAO<br>
	 */
	public OwnContainerBookingForecastMgtBCImpl() {
		dbDao = new OwnContainerBookingForecastMgtDBDAO();
	}

	/**
	 * Retrieve POL Info<br>
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
	 * Retrieve OPR <br>
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
	 * Retrieve PodbyVvd <br>
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
	 * Retrieve MLB <br>
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
	 * Retrieve LOC <br>
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
	 * Retrieve CBF Booking Status<br>
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
	 * Check CBF save Info<br>
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
	 * Retrieve WeightGRPList <br>
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
	 * Retrieve CBFVolumeList .<br>
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
	 * Retrieve CBFSpecialList .<br>
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
	 * Retrieve CBFBKGVolumeList .<br>
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
	 * Retrieve CBFSpecialList .<br>
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
	 * Check BKGVVD Info.<br>
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
	 * Check TurningPortSkipCall Info.
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
	 * Save Weight Group Info <br>
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

						updateForDeleteVoList.add(tableDeleteVo); // VO List which will be deleted in Update Column.
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

						updateForDeleteVoList.add(tableDeleteVo); //  VO List which will be deleted in Update Column.
					}
				}
				dbDao.modifyWeightGRPList(tableUpdateVoList);
			}
			// Delete VO List Data which will be added in Update column..
			if (updateForDeleteVoList.size() > 0) {
				dbDao.removeWeightGRPList(updateForDeleteVoList);
			}
			// Insert VO List Data which will be added in Update column.
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
	 * Delete CBFList Info<br>
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
	 * Save OwnCBF Info.<br>
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
					cbfListVolumnVOs[i].setUpdUsrId(account.getUsr_id());
					cbfListVolumnVOs[i].setCreUsrId(account.getUsr_id());
					cbfListVolumnVOs[i].setCreDt(cBFListOptionVO.getCreDt());
					
					cbfListVolumnVOs[i].setCbfSmrySeq(Integer.toString(cbfSmrySeq));
					cbfListVolumnVOs[i].setCbfIndFlg(cBFListOptionVO.getCbfIndFlg());
					cbfListVolumnVOs[i].setCbfBkgStsCd(cBFListOptionVO.getCbfBkgStsCd());
					
					if(cbfListVolumnVOs[i].getVslCd() != null && !"".equals(cbfListVolumnVOs[i].getVslCd())) {					
						//Creating Volumn CBF VO
						insertCntrVoList.add(cbfListVolumnVOs[i]);
						
						cbfSmrySeq++;
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
							//Creating Special CBF VO
							insertCntrVoList.add(cbfListSpecialVOs[i]);
							
							//Creating Subs Risk VO
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
				
			} else {
				//1. Special
				if (cbfListSpecialVOs != null) {
					for (int i = 0; i < cbfListSpecialVOs.length; i++) {
						cBFListOptionVO.setUpdUsrId(account.getUsr_id());
						cbfListSpecialVOs[i].setUpdUsrId(account.getUsr_id());

						//Creating Special CBF VO which will be modified
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
	 * Retrieve CBF Summary .<br>
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
	 * Retrieve CBF SpecialList .<br>
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
	 * Retrieve CBF Special Stwg .<br>
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
	 * Retrieve CBF Summary .<br>
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
	 * Retrieve CBF Special Stwg .<br>
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
	 * Retrieve CBF SpecialList .<br>
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
	 * Retrieve OprPodMlbComboList <br>
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
	 * Retrieve CBFSummaryPreviewHeader .<br>
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
	 * Retrieve CBFSummaryPreviewStwgCd .<br>
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
	 *  Retrieve PartnerCBFList .<br>
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
	 *  Retrieve PartnerCBFSpecialList .<br>
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
	 * Save PartnerCBF Info.<br>
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
	 *  Retrieve TP .<br>
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
	 *  Retrieve Weight Group .<br>
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
	 *  Retrieve Full Empty .<br>
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
	 *  Retrieve CGO .<br>
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
	 *  Retrieve IMO .<br>
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
	 *  Retrieve PostExtd .<br>
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
	 *  Retrieve STWG .<br>
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
	 *  Check Partner Line CBF save Info<br>
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
	 *  Check Partner Line CBF save Info<br>
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
}