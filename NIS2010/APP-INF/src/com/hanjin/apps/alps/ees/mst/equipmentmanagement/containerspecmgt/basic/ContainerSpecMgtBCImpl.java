/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtBCImpl.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.30 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration.ContainerSpecMgtDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MstIsoCntrTpSzVO;
import com.hanjin.syscommon.common.table.MstCntrStsVO;
import com.hanjin.syscommon.common.table.MstCntrPreStsVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.TCntrStsCodeGRPVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;

/**
 * ALPS-EquipmentManagement Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Suk Jun Kim
 * @see EES_MST_0005EventResponse,ContainerSpecMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ContainerSpecMgtBCImpl extends BasicCommandSupport implements ContainerSpecMgtBC {

	// Database Access Object
	private transient ContainerSpecMgtDBDAO dbDao = null;

	/**
	 * ContainerSpecMgtBCImpl 객체 생성<br>
	 * ContainerSpecMgtDBDAO를 생성한다.<br>
	 */
	public ContainerSpecMgtBCImpl() {
		dbDao = new ContainerSpecMgtDBDAO();
	}
	
	/**
	 *  EqStatusCode를 조회합니다<br>
	 * 
	 * @return TCntrStsCodeGRPVO
	 * @exception EventException
	 */
	public TCntrStsCodeGRPVO searchEqStatusCodeListBasic() throws EventException 
	{

		// GROUPVO 생성
		TCntrStsCodeGRPVO tgrVo = new TCntrStsCodeGRPVO();

		try {
			//Status Code List를 조회한다.
			List<MstCntrStsVO> list = dbDao.searchEqStatusCodeListData();
			tgrVo.setMstCntrStsVO(list);
			
			//Status Code의 Pre Status를 조회한다.
			List<MstCntrPreStsVO> listPre = dbDao.searchEqPreStatusCodeListData();
			tgrVo.setMstCntrPreStsVO(listPre);
			return tgrVo;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqStatusCode Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqStatusCode Search"}).getMessage(),de);
		}
	}
	
	/**
	 * EqStatusCode를 생성,삭제,저장합니다.<br>
	 * 
	 * @param TCntrStsCodeGRPVO tCntrStsCodeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEqStatusCodeBasic(TCntrStsCodeGRPVO tCntrStsCodeGRPVO, SignOnUserAccount account) throws EventException
	{
		try {
			List<MstCntrStsVO> insertVoList = new ArrayList<MstCntrStsVO>();
			List<MstCntrStsVO> updateVoList = new ArrayList<MstCntrStsVO>();
			List<MstCntrStsVO> deleteVoList = new ArrayList<MstCntrStsVO>();

			List<MstCntrPreStsVO> insertSubVoList = new ArrayList<MstCntrPreStsVO>();
			List<MstCntrPreStsVO> deleteSubVoList = new ArrayList<MstCntrPreStsVO>();
			
			//Status Code의 C, U, D 처리
			if(tCntrStsCodeGRPVO.getMstCntrStsVOS() != null)
			{
				for ( int i=0; i<tCntrStsCodeGRPVO.getMstCntrStsVOS().length; i++ ) 
				{
					if ( tCntrStsCodeGRPVO.getMstCntrStsVOS()[i].getIbflag().equals("I")){
						tCntrStsCodeGRPVO.getMstCntrStsVOS()[i].setCreUsrId(account.getUsr_id());
						tCntrStsCodeGRPVO.getMstCntrStsVOS()[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(tCntrStsCodeGRPVO.getMstCntrStsVOS()[i]);
					} else if ( tCntrStsCodeGRPVO.getMstCntrStsVOS()[i].getIbflag().equals("U")){
						tCntrStsCodeGRPVO.getMstCntrStsVOS()[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(tCntrStsCodeGRPVO.getMstCntrStsVOS()[i]);
					} else if ( tCntrStsCodeGRPVO.getMstCntrStsVOS()[i].getIbflag().equals("D")){
						deleteVoList.add(tCntrStsCodeGRPVO.getMstCntrStsVOS()[i]);
						deleteSubVoList.add(tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i]);
					}
				}
			}
			
			//Status Code의 Pre Status의 C, D 처리			
			if(tCntrStsCodeGRPVO.getMstCntrPreStsVOS() != null) 
			{
				for ( int i=0; i<tCntrStsCodeGRPVO.getMstCntrPreStsVOS().length; i++ ) 
				{
					if ( tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i].getIbflag().equals("I")){
						tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i].setCreUsrId(account.getUsr_id());
						tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i].setUpdUsrId(account.getUsr_id());
						insertSubVoList.add(tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i]);
					} else if ( tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i].getIbflag().equals("D")){
						deleteSubVoList.add(tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addEqStatusCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEqStatusCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEqPreStatusCodeAllData(deleteVoList);
				dbDao.removeEqStatusCodeData(deleteVoList);				
			}
			
			if ( insertSubVoList.size() > 0 ) {
				dbDao.addEqPreStatusCodeData(insertSubVoList);
			}
			
			if ( deleteSubVoList.size() > 0 ) {
				dbDao.removeEqPreStatusCodeData(deleteSubVoList);
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqStatusCode Manage"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqStatusCode Manage"}).getMessage(),de);
		}
	}

	/**
	 * Containerspecmgt를 조회합니다<br>
	 * 
	 * @return List<MstIsoCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MstIsoCntrTpSzVO> searchISOCodeListBasic() throws EventException {
		try {
			return dbDao.searchISOCodeListData();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"ISO Code List Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"ISO Code List Search"}).getMessage(),de);
		}
	}
	
	/**
	 * ISO Code를 저장합니다.<br>
	 * 
	 * @param MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageISOCodeBasic(MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MstIsoCntrTpSzVO> insertVoList = new ArrayList<MstIsoCntrTpSzVO>();
			List<MstIsoCntrTpSzVO> updateVoList = new ArrayList<MstIsoCntrTpSzVO>();
			List<MstIsoCntrTpSzVO> deleteVoList = new ArrayList<MstIsoCntrTpSzVO>();
			for ( int i=0; i<mstIsoCntrTpSzVOs .length; i++ ) {
				if ( mstIsoCntrTpSzVOs[i].getIbflag().equals("I")){
					mstIsoCntrTpSzVOs[i].setCreUsrId(account.getUsr_id());
					mstIsoCntrTpSzVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(mstIsoCntrTpSzVOs[i]);
				} else if ( mstIsoCntrTpSzVOs[i].getIbflag().equals("U")){
					mstIsoCntrTpSzVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mstIsoCntrTpSzVOs[i]);
				} else if ( mstIsoCntrTpSzVOs[i].getIbflag().equals("D")){
					deleteVoList.add(mstIsoCntrTpSzVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addISOCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyISOCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeISOCodeData(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"ISO Code Manage"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"ISO Code Manage"}).getMessage(),de);
		}
	}
	
	/**
	 * EqOrgSccList Equipment Organization Chart 를 조회합니다<br>
	 * 
	 * @return List<EqOrgSccVO>
	 * @exception EventException
	 */
	public List<EqOrgSccVO> searchEqOrgSccListBasic() throws EventException {
		try {
			return dbDao.searchEqOrgSccListData();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqOrgSccList Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqOrgSccList Search"}).getMessage(),de);
		}
	}

	/**
	 * EqOrgYardList 를 조회합니다<br>
	 * 
	 * @param EqOrgYardVO eqOrgYardVO
	 * @return List<EqOrgYardVO>
	 * @exception EventException
	 */
	public List<EqOrgYardVO> searchEqOrgYardListBasic(EqOrgYardVO eqOrgYardVO) throws EventException {
		try {
			return dbDao.searchEqOrgYardListData(eqOrgYardVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqOrgYardList Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"EqOrgYardList Search"}).getMessage(),de);
		}
	}

	
	/**
	 * Container Type/Size를 조회합니다.<br>
	 * 
	 * @return List<ContainerTypeSizeCodeVO>
	 * @throws DAOException
	 */
	public List<ContainerTypeSizeCodeVO> searchCntrTypeSizeCodeListBasic() throws EventException {
		try {
			return dbDao.searchCntrTypeSizeCodeListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Type/Size Search"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Type/Size Search"}).getMessage(),de);			
		}
	}	
	
	/**
	 * Container Type/Size를 수정합니다<br>
	 *  
	 * @param containerTypeSizeCodeVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyCntrTypeSizeCodeBasic(ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs, SignOnUserAccount account) throws EventException{
		
		try {
			List<ContainerTypeSizeCodeVO> updateVoList = new ArrayList<ContainerTypeSizeCodeVO>();

			for ( int i=0; i<containerTypeSizeCodeVOs.length; i++ ) {
				if ( containerTypeSizeCodeVOs[i].getIbflag().equals("U")){
					containerTypeSizeCodeVOs[i].setUpdUsrId(account.getUsr_id());	
					updateVoList.add(containerTypeSizeCodeVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrTypeSizeCodeData(updateVoList);
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Type/Size Modify"}).getMessage(),de);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Type/Size Modify"}).getMessage(),de);			
		}
	}
	

	/** EES_MST_0004 : save <br>
	 * 등록, 수정, 삭제 데이타 처리<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_1
	 * @category manageLeaseTermCodeBasic    
	 * @param LeaseTermVO[] leaseTermVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void manageLeaseTermCodeBasic(LeaseTermVO[] leaseTermVOs,
			SignOnUserAccount account) throws EventException {
		try {
			List<LeaseTermVO> insertVoList = new ArrayList<LeaseTermVO>();
			List<LeaseTermVO> updateVoList = new ArrayList<LeaseTermVO>();
			List<LeaseTermVO> deleteVoList = new ArrayList<LeaseTermVO>();
			for ( int i=0; i<leaseTermVOs .length; i++ ) {
				if ( leaseTermVOs[i].getIbflag().equals("I")){
					leaseTermVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(leaseTermVOs[i]);
				} else if ( leaseTermVOs[i].getIbflag().equals("U")){
					leaseTermVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(leaseTermVOs[i]);
				} else if ( leaseTermVOs[i].getIbflag().equals("D")){
					deleteVoList.add(leaseTermVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLeaseTermCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLeaseTermCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLeaseTermCodeData(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lease Term Code Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lease Term Code Creation"}).getMessage(),ex);
		}
	}


	/** EES_MST_0004 : retrieve <br>
	 * LeaseTermCode를 조회합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_2
	 * @category searchLeaseTermCodeListBasic    
	 * @return List<LeaseTermVO>
	 * @exception EventException
	 */		
	public List<LeaseTermVO> searchLeaseTermCodeListBasic() throws EventException {
		try {
			return dbDao.searchLeaseTermCodeListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lease Term Code Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lease Term Code Creation"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MST_0022 : retrieve<br>
	 * Container Spec List를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0022_1 
	 * @category searchCntrSpecListBrieflyBasic   
	 * @param CntrSpecListBrieflyVO cntrSpecListBrieflyVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 */
	public List<CntrSpecListBrieflyVO> searchCntrSpecListBrieflyBasic(CntrSpecListBrieflyVO cntrSpecListBrieflyVO) throws EventException {
		try {
			return dbDao.searchCntrSpecListBrieflyData(cntrSpecListBrieflyVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpecList Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpecList Search"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0021 : retrieve<br>
	 * Container Spec을 조회합니다<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0021_1 
	 * @category searchCntrSpecBasic   
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return MstCntrSpecVO
	 * @exception EventException
	 */
	public MstCntrSpecVO searchCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException {
		try {
			return dbDao.searchCntrSpecData(mstCntrSpecVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Search"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0021 : save<br> 
	 * CntrSpec 을 수정합니다<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0021_2 
	 * @category modifyCntrSpecBasic   
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO, SignOnUserAccount account) throws EventException{
		try {
			// Update User ID 지정.
			mstCntrSpecVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyCntrSpecData(mstCntrSpecVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Modify"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Modify"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0021 : save<br>  
	 * CntrSpec 을 삭제합니다<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0021_3 
	 * @category removeCntrSpecBasic   
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @exception EventException
	 */
	public void removeCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException{
		String strAgmt = "";
		try {
			// 삭제가능한지 검사.
			strAgmt = dbDao.searchCntrSpecUsingCheckData(mstCntrSpecVO);
			if("".equals(strAgmt)==false)
			{  
				if (mstCntrSpecVO.getOwnCntrFlg().equals("Y")){
				   throw new EventException(new ErrorHandler("MST01028", new String[]{strAgmt}).getMessage());
				} else {
				   throw new EventException(new ErrorHandler("MST01001", new String[]{strAgmt}).getMessage());
				}
			}

			dbDao.removeCntrSpecData(mstCntrSpecVO);
			
	    } catch (EventException de) {   
	        throw de;   
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Remove"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Remove"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0021 : save<br>   
	 * CntrSpec 을 생성합니다<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0021_4 
	 * @category createCntrSpecBasic   
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO, SignOnUserAccount account) throws EventException{
		String cntrSpecNo = "";
		try {
			// Create User ID 지정.
			mstCntrSpecVO.setCreUsrId(account.getUsr_id());
			// Update User ID 지정.
			mstCntrSpecVO.setUpdUsrId(account.getUsr_id());
			
			cntrSpecNo = dbDao.searchCntrSpecLastSeqData(mstCntrSpecVO);
			
			if("".equals(cntrSpecNo))		// cntr_spec_no 코드생성이 실패하였습니다.
			{
				throw new EventException(new ErrorHandler("MST00004").getMessage());
			}
			// 생성된 cntr_spec_no 코드를 지정한다.
			mstCntrSpecVO.setCntrSpecNo(cntrSpecNo);

			dbDao.createCntrSpecData(mstCntrSpecVO);
			
	    } catch (EventException de) {   
	        throw de;   
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Create"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Create"}).getMessage(),de);
		}
		return cntrSpecNo;
	}
}