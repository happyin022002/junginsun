/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtBCImpl.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration.ContainerSpecMgtDBDAO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.TCntrStsCodeGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MstCntrPreStsVO;
import com.clt.syscommon.common.table.MstCntrStsVO;
import com.clt.syscommon.common.table.MstIsoCntrTpSzVO;

/**
 * EquipmentManagement Business Logic Basic Command implementation<br>
 * handling business logic about EquipmentManagement<br>
 *
 * @author 
 * @see EES_MST_0005EventResponse,ContainerSpecMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ContainerSpecMgtBCImpl extends BasicCommandSupport implements ContainerSpecMgtBC {

	// Database Access Object
	private transient ContainerSpecMgtDBDAO dbDao = null;

	/**
	 * creating ContainerSpecMgtBCImpl<br>
	 * creating ContainerSpecMgtDBDAObr>
	 */
	public ContainerSpecMgtBCImpl() {
		dbDao = new ContainerSpecMgtDBDAO();
	}
	
	/**
	 *  retrieving for EqStatusCode<br>
	 * 
	 * @return TCntrStsCodeGRPVO
	 * @exception EventException
	 */
	public TCntrStsCodeGRPVO searchEqStatusCodeListBasic() throws EventException 
	{

		TCntrStsCodeGRPVO tgrVo = new TCntrStsCodeGRPVO();

		try {
			//retrieving for Status Code List
			List<MstCntrStsVO> list = dbDao.searchEqStatusCodeListData();
			tgrVo.setMstCntrStsVO(list);
			
			//retrieving for Pre Status of Status Code
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
	 * saving EqStatusCode<br>
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
			
			//handling Status Code
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
						if (tCntrStsCodeGRPVO.getMstCntrPreStsVO() != null) {
							deleteSubVoList.add(tCntrStsCodeGRPVO.getMstCntrPreStsVOS()[i]);
						}
					}
				}
			}
			
			//handling Pre Status of Status Code
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
	 * retrieving for Containerspecmgt<br>
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
	 * saving ISO Code<br>
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
	 * retrieving for EqOrgSccList Equipment Organization Chart<br>
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
	 * retrieving for EqOrgYardList<br>
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
	 * retrieving for Container Type/Size<br>
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
	 * saving Container Type/Size<br>
	 *  
	 * @param ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs
	 * @param SignOnUserAccount account
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
			
			String ofc_cd = account.getOfc_cd();
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrTypeSizeCodeData(updateVoList);
				dbDao.removeCntrTypeSizeCodeDataForCim();
				dbDao.addCntrTypeSizeCodeDataForCim(ofc_cd); 
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Type/Size Modify"}).getMessage(),de);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Type/Size Modify"}).getMessage(),de);			
		}
	}
	

	/** EES_MST_0004 : save <br>
	 * saving lease term code<br> 
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
	 * retrieving for LeaseTermCode<br> 
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
	 * retrieving for Container Spec List<br>
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
	 * EES_MST_0022 : retrieve<br>
	 * retrieving for Container Spec List<br>
	 * @category EES_MST_0022_1 
	 * @category searchCntrSpecListBrieflyBasic   
	 * @param CntrSpecListBrieflyVO cntrSpecListBrieflyVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 */
	public List<CntrSpecListBrieflyVO> searchCntrSpecNoInquiryBasic(CntrSpecListBrieflyVO cntrSpecListBrieflyVO) throws EventException {
		try {
			return dbDao.searchCntrSpecNoInquiryData(cntrSpecListBrieflyVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpecList Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpecList Search"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0021 : retrieve<br>
	 * retrieving for Container Spec<br>
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
	 * saving CntrSpec<br>
	 * @category EES_MST_0021_2 
	 * @category modifyCntrSpecBasic   
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO, SignOnUserAccount account) throws EventException{
		try {
			mstCntrSpecVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyCntrSpecData(mstCntrSpecVO);
			dbDao.modifyCntrMstData(mstCntrSpecVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Modify"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"CntrSpec Modify"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0021 : save<br>  
	 * removing CntrSpec<br>
	 * @category EES_MST_0021_3 
	 * @category removeCntrSpecBasic   
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @exception EventException
	 */
	public void removeCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException{
		String strAgmt = "";
		try {
			// checking removable
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
	 * creating CntrSpec<br>
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
			mstCntrSpecVO.setCreUsrId(account.getUsr_id());
			mstCntrSpecVO.setUpdUsrId(account.getUsr_id());
			
			cntrSpecNo = dbDao.searchCntrSpecLastSeqData(mstCntrSpecVO);
			
			if("".equals(cntrSpecNo))		// in case of faliure creating cntr_spec_no
			{
				throw new EventException(new ErrorHandler("MST00004").getMessage());
			}

			mstCntrSpecVO.setCntrSpecNo(cntrSpecNo);

			dbDao.createCntrSpecData(mstCntrSpecVO);
			
			if("Y".equals(mstCntrSpecVO.getSpecYrMod())) {
				//Update ( LSE_AGMT_RT_HIS, LSE_AGMT_RT, MST_CNTR_LOT, MST_CONTAINER)				
				dbDao.modifyLseAgmtRtHisCntrSpecData(mstCntrSpecVO);
				dbDao.modifyLseAgmtRtCntrSpecData(mstCntrSpecVO);
				dbDao.modifyMstCntrLotCntrSpecData(mstCntrSpecVO);
				dbDao.modifyMstContainerCntrSpecData(mstCntrSpecVO);
				
				//Delete (MST_CNTR_SPEC)
				dbDao.removeCntrSpecNoData(mstCntrSpecVO);
			}
			
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