/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtBC.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.TCntrStsCodeGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MstIsoCntrTpSzVO;


/**
 * Equipmentmanagement Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mst_0005EventResponse
 * @since J2EE 1.4
 */

public interface ContainerSpecMgtBC {
	/**
	 *  retrieving for EqStatusCode<br>
	 * 
	 * @return TCntrStsCodeGRPVO
	 * @exception EventException
	 */
	public TCntrStsCodeGRPVO searchEqStatusCodeListBasic() throws EventException;
	/**
	 * saving EqStatusCode<br>
	 * 
	 * @param TCntrStsCodeGRPVO tCntrStsCodeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEqStatusCodeBasic(TCntrStsCodeGRPVO tCntrStsCodeGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * retrieving for Containerspecmgt<br>
	 * 
	 * @return List<MstIsoCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MstIsoCntrTpSzVO> searchISOCodeListBasic() throws EventException;
	/**
	 * saving ISO Code<br>
	 * 
	 * @param MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageISOCodeBasic(MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs,SignOnUserAccount account) throws EventException;
	/**
	 * retrieving for EqOrgSccList Equipment Organization Chart<br>
	 * 
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<EqOrgSccVO> searchEqOrgSccListBasic() throws EventException;
	/**
	 * retrieving for EqOrgYardList<br>
	 * 
	 * @param EqOrgYardVO eqOrgYardVO
	 * @return List<EqOrgYardVO>
	 * @exception EventException
	 */
	public List<EqOrgYardVO> searchEqOrgYardListBasic(EqOrgYardVO eqOrgYardVO) throws EventException;
	
	/**
	 * retrieving for Container Type/Size<br>
	 *  
	 * @return List<ContainerTypeSizeCodeVO>
	 * @throws EventException
	 */
	public List<ContainerTypeSizeCodeVO> searchCntrTypeSizeCodeListBasic() throws EventException;
	
	/**
	 * saving Container Type/Size<br>
	 *  
	 * @param ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCntrTypeSizeCodeBasic(ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs, SignOnUserAccount account) throws EventException;
	
	/** EES_MST_0004 : retrieve<br>
	 * retrieving for LeaseTermCode<br> 
	 * @category EES_MST_0004_2
	 * @category searchLeaseTermCodeListBasic    
	 * @return List<LeaseTermVO>
	 * @exception EventException
	 */	
	public List<LeaseTermVO> searchLeaseTermCodeListBasic() throws EventException;
	
	/** EES_MST_0004 : save<br>
	 * saving LeaseTermCode<br> 
	 * @category EES_MST_0004_1
	 * @category manageLeaseTermCodeBasic    
	 * @param LeaseTermVO[] leaseTermVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageLeaseTermCodeBasic(LeaseTermVO[] leaseTermVOs,SignOnUserAccount account) throws EventException;

	/**
	 * retrieving for CntrSpec<br>
	 * 
	 * @param CntrSpecListBrieflyVO cntrSpecListBrieflyVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 */
	public List<CntrSpecListBrieflyVO> searchCntrSpecListBrieflyBasic(CntrSpecListBrieflyVO cntrSpecListBrieflyVO) throws EventException;
	
	/**
	 * retrieving for CntrSpec<br>
	 * 
	 * @param CntrSpecListBrieflyVO cntrSpecListBrieflyVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 */
	public List<CntrSpecListBrieflyVO> searchCntrSpecNoInquiryBasic(CntrSpecListBrieflyVO cntrSpecListBrieflyVO) throws EventException;

	/**
	 * retrieving for CntrSpec<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return List<MstCntrSpecVO>
	 * @exception EventException
	 */
	public MstCntrSpecVO searchCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException;

	/**
	 * saving CntrSpec<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO,SignOnUserAccount account) throws EventException;
	/**
	 * removing CntrSpec<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @exception EventException
	 */
	public void removeCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException;
	/**
	 * creating CntrSpec<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @return String
	 */
	public String createCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO,SignOnUserAccount account) throws EventException;
}