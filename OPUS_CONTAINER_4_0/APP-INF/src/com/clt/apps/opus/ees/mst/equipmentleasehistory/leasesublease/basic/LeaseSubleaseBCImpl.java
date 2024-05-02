/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseSubleaseBCImpl.java
*@FileTitle : Manageing lease History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.basic;

import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.integration.LeaseSubleaseDBDAO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusGrpVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * EquipmentLeaseHistory Business Logic Basic Command implementation<br>
 * handling business logic about EquipmentLeaseHistory<br>
 *
 * @author 
 * @see EES_MST_0029EventResponse,LeaseSubleaseBC,LeaseSubleaseDBDAO
 * @since J2EE 1.6
 */
public class LeaseSubleaseBCImpl extends BasicCommandSupport implements LeaseSubleaseBC {

	// Database Access Object
	private transient LeaseSubleaseDBDAO dbDao = null;

	/**
	 * creating LeaseSubleaseBCImpl Object<br>
	 * creating LeaseSubleaseDBDAO Object<br>
	 */
	public LeaseSubleaseBCImpl() {
		dbDao = new LeaseSubleaseDBDAO();
	}
	/**
	 * EES_MST_0029 : retrieve<br>
	 *  retrieving for Container Status Inquiry<br>
	 * @category EES_MST_0029_1
	 * @category searchCntrStatusListByCntrNoBasic     
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return CntrStatusGrpVO
	 * @exception EventException
	 */
	public CntrStatusGrpVO searchCntrStatusListByCntrNoBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException {
		try {
			if (cntrStatusOptionVO.getCntrNo().length() == 10){
				cntrStatusOptionVO.setChklen("1");
			} else {
				cntrStatusOptionVO.setChklen("0");
			}
			CntrStatusGrpVO cntrStatusGrpVO = new CntrStatusGrpVO(); 
			List<CntrMstHeadVO> list = dbDao.searchCntrMasterInfoByCntrNoData(cntrStatusOptionVO);
			cntrStatusGrpVO.setCntrMstHeadVO(list);
			List<CntrStatusListVO> listPre = dbDao.searchCntrStatusListByCntrNoData(cntrStatusOptionVO);
			cntrStatusGrpVO.setCntrStatusListVO(listPre);
			return cntrStatusGrpVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Inquiry"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Inquiry"}).getMessage(),ex);
		}
	}

	/**
	 * EES_MST_0035 : retrieve<br>
	 *  retrieving for Container Check Digit and Container Checking Inquiry<br>
	 * @category EES_MST_0035_1
	 * @category searchCntrCheckDigitListBasic    
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusListVO>
	 * @exception EventException
	 */
	public List<CntrStatusListVO> searchCntrCheckDigitListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException {
		try {
			return dbDao.searchCntrCheckDigitListData(cntrStatusOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Check Digit and Container Checking Inquiry"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Check Digit and Container Checking Inquiry"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MST_0027 : retrieve<br>
	 * retrieving for Container Status List by Lost & Found<br>
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusReportListVO>	
	 * @exception EventException
	 */
	public List<CntrStatusReportListVO> searchCntrStatusReportListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException {
		try {
			return dbDao.searchCntrStatusReportListData(cntrStatusOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status List by Lost & Found"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status List by Lost & Found"}).getMessage(),ex);
		}
	}	
	
}