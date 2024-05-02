/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRBookingInterfaceImpl.java
*@FileTitle : BDRBookingInterfaceImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.30 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration.BDRSettingDBDAO;
import com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.vo.BdrBkgNoVO;
import com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.vo.BdrVvdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * BDRBookingInterface Business Logic Basic Command implementation<br>
 * BDRBookingInterface에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ilmin Lee
 * @see BDRBookingInterfaceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BDRBookingInterfaceBCImpl extends BasicCommandSupport implements BDRBookingInterfaceBC {

	private transient BDRSettingDBDAO dbDao = null;
	private transient CargoReleaseOrderBC inboundBc = null;

	/**
	 * BDRBookingInterfaceImpl 객체 생성<br>
	 * BDRSettingDBDAO를 생성한다.<br>
	 */
	public BDRBookingInterfaceBCImpl() {
		dbDao = new BDRSettingDBDAO();
		inboundBc = new CargoReleaseOrderBCImpl();
	}

	/**
	 * manageBdrBookingList
	 * 
	 * @return List<BdrBkgNoVO>
	 * @exception EventException
	 */
	public List<BdrBkgNoVO> manageBdrBookingList() throws EventException {
		List<BdrVvdVO> bdrVvdList = null;
		List<BdrBkgNoVO> bdrBkgNoList = null;
		List<BdrBkgNoVO> bdrBkgNoAllList = null;
		try {
			//vvd 목록을 조회한다.
			bdrVvdList = dbDao.searchBdrVvdList();
			if (null!=bdrVvdList && 0<bdrVvdList.size()) {
				bdrBkgNoAllList = new ArrayList<BdrBkgNoVO>();
				for (BdrVvdVO bdrVvd : bdrVvdList) {
					//booking 목록을 조회한다.
					bdrBkgNoList = dbDao.searchBdrBkgNoList(bdrVvd);
					bdrBkgNoAllList.addAll(bdrBkgNoList);
					dbDao.updateBdrFlg(bdrVvd);
					if (null!=bdrBkgNoList && 0<bdrBkgNoList.size()) {
						for (BdrBkgNoVO bdrBkgNo : bdrBkgNoList) {
							dbDao.updateBlDoc(bdrBkgNo);
						}
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return bdrBkgNoAllList;
	}

	/**
	 * manageBdrBookingListTest
	 * 
	 * @return List<BdrBkgNoVO>
	 * @exception EventException
	 */
	public List<BdrBkgNoVO> manageBdrBookingListTest() throws EventException {
		List<BdrVvdVO> bdrVvdList = null;
		List<BdrBkgNoVO> bdrBkgNoList = null;
		List<BdrBkgNoVO> bdrBkgNoAllList = null;
		try {
			//vvd 목록을 조회한다.
			bdrVvdList = dbDao.searchBdrVvdListTest();
			if (null!=bdrVvdList && 0<bdrVvdList.size()) {
				bdrBkgNoAllList = new ArrayList<BdrBkgNoVO>();
				for (BdrVvdVO bdrVvd : bdrVvdList) {
					//booking 목록을 조회한다.
					bdrBkgNoList = dbDao.searchBdrBkgNoList(bdrVvd);
					bdrBkgNoAllList.addAll(bdrBkgNoList);
//					dbDao.updateBdrFlg(bdrVvd);
//					if (null!=bdrBkgNoList && 0<bdrBkgNoList.size()) {
//						for (BdrBkgNoVO bdrBkgNo : bdrBkgNoList) {
//							dbDao.updateBlDoc(bdrBkgNo);
//						}
//					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return bdrBkgNoAllList;
	}

	/**
	 * setupFocByObl
	 * 
	 * @param List<BdrBkgNoVO>
	 * @exception EventException
	 */
	public void setupFocByOblAutoBdr(List<BdrBkgNoVO> bdrBkgNoList) throws EventException {
		List<OblRdemVO> oblRdemVOs = null;
		try {
			if (null!=bdrBkgNoList && 0<bdrBkgNoList.size()) {
				oblRdemVOs = new ArrayList<OblRdemVO>();
				for (BdrBkgNoVO bdrBkgNo : bdrBkgNoList) {
					oblRdemVOs.add(this.convertOblRdemVO(bdrBkgNo));
				}
				inboundBc.setupFocByOblAutoBdr(oblRdemVOs.toArray(new OblRdemVO[oblRdemVOs.size()]));
			}
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	private OblRdemVO convertOblRdemVO(BdrBkgNoVO bdrBkgNoVO) throws Exception {
		OblRdemVO oblRdem = null;
		BkgBlNoVO bkgBlNoVO = null;
		try {
			bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bdrBkgNoVO.getBkgNo());
			oblRdem = new OblRdemVO();
			oblRdem.setBlNo(bdrBkgNoVO.getBlNo());
			oblRdem.setCgorTeamCd("B");
			oblRdem.setCgoEvntNm("B/L BDR");
			oblRdem.setEvntDt(bdrBkgNoVO.getEvntDt());
			oblRdem.setEvntOfcCd("SYS");
			oblRdem.setEvntUsrId("BDRBookingSetting");
			oblRdem.setOblChk("N");
			oblRdem.setOblRdemFlg(bdrBkgNoVO.getOblRlseFlg());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return oblRdem;
	}

}
