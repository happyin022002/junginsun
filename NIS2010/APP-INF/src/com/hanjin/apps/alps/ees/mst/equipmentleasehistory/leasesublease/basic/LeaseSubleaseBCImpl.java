/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseSubleaseBCImpl.java
*@FileTitle : 임차 및 반납 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.basic;

import java.util.List;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration.LeaseSubleaseDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusGrpVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-EquipmentLeaseHistory Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentLeaseHistory에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0029EventResponse,LeaseSubleaseBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LeaseSubleaseBCImpl extends BasicCommandSupport implements LeaseSubleaseBC {

	// Database Access Object
	private transient LeaseSubleaseDBDAO dbDao = null;

	/**
	 * LeaseSubleaseBCImpl 객체 생성<br>
	 * LeaseSubleaseDBDAO를 생성한다.<br>
	 */
	public LeaseSubleaseBCImpl() {
		dbDao = new LeaseSubleaseDBDAO();
	}
	/**
	 * EES_MST_0029 : retrieve<br>
	 *  Container Status Inquiry 화면에 대한 조회를 합니다.<br>
	 * @author LEE HO SUN
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
	 *  Container Check Digit and Container Checking Inquiry 화면에 대한 조회를 합니다.<br>
	 * @author LEE HO SUN
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
	 * Container Status List by Lost & Found 화면에 대한 조회를 합니다.<br>
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