/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtBC.java
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

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MstIsoCntrTpSzVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.TCntrStsCodeGRPVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;


/**
 * ALPS-Equipmentmanagement Business Logic Command Interface<br>
 * - ALPS-Equipmentmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Suk Jun Kim
 * @see Ees_mst_0005EventResponse 참조
 * @since J2EE 1.4
 */

public interface ContainerSpecMgtBC {
	/**
	 *  EqStatusCode를 조회합니다<br>
	 * 
	 * @return TCntrStsCodeGRPVO
	 * @exception EventException
	 */
	public TCntrStsCodeGRPVO searchEqStatusCodeListBasic() throws EventException;
	/**
	 * EqStatusCode를 저장합니다.<br>
	 * 
	 * @param TCntrStsCodeGRPVO tCntrStsCodeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEqStatusCodeBasic(TCntrStsCodeGRPVO tCntrStsCodeGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * Containerspecmgt를 조회합니다<br>
	 * 
	 * @return List<MstIsoCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MstIsoCntrTpSzVO> searchISOCodeListBasic() throws EventException;
	/**
	 * ISO Code를 저장합니다.<br>
	 * 
	 * @param MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageISOCodeBasic(MstIsoCntrTpSzVO[] mstIsoCntrTpSzVOs,SignOnUserAccount account) throws EventException;
	/**
	 * EqOrgSccList Equipment Organization Chart 를 조회합니다<br>
	 * 
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<EqOrgSccVO> searchEqOrgSccListBasic() throws EventException;
	/**
	 * EqOrgYardList 를 조회합니다<br>
	 * 
	 * @param EqOrgYardVO eqOrgYardVO
	 * @return List<EqOrgYardVO>
	 * @exception EventException
	 */
	public List<EqOrgYardVO> searchEqOrgYardListBasic(EqOrgYardVO eqOrgYardVO) throws EventException;
	
	/**
	 * Container Type/Size를 조회합니다<br>
	 *  
	 * @return List<ContainerTypeSizeCodeVO>
	 * @throws EventException
	 */
	public List<ContainerTypeSizeCodeVO> searchCntrTypeSizeCodeListBasic() throws EventException;
	
	/**
	 * Container Type/Size를 수정합니다.<br>
	 *  
	 * @param ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCntrTypeSizeCodeBasic(ContainerTypeSizeCodeVO[] containerTypeSizeCodeVOs, SignOnUserAccount account) throws EventException;
	
	/** EES_MST_0004 : retrieve<br>
	 * LeaseTermCode조회 처리합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_2
	 * @category searchLeaseTermCodeListBasic    
	 * @return List<LeaseTermVO>
	 * @exception EventException
	 */	
	public List<LeaseTermVO> searchLeaseTermCodeListBasic() throws EventException;
	
	/** EES_MST_0004 : save<br>
	 * LeaseTermCode 등록, 수정, 삭제 데이타 처리합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_1
	 * @category manageLeaseTermCodeBasic    
	 * @param LeaseTermVO[] leaseTermVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageLeaseTermCodeBasic(LeaseTermVO[] leaseTermVOs,SignOnUserAccount account) throws EventException;

	/**
	 * CntrSpec 를 조회합니다<br>
	 * 
	 * @param CntrSpecListBrieflyVO cntrSpecListBrieflyVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 */
	public List<CntrSpecListBrieflyVO> searchCntrSpecListBrieflyBasic(CntrSpecListBrieflyVO cntrSpecListBrieflyVO) throws EventException;

	/**
	 * CntrSpec 를 조회합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return List<MstCntrSpecVO>
	 * @exception EventException
	 */
	public MstCntrSpecVO searchCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException;

	/**
	 * CntrSpec 을 수정합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO,SignOnUserAccount account) throws EventException;
	/**
	 * CntrSpec 을 삭제합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @exception EventException
	 */
	public void removeCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO) throws EventException;
	/**
	 * CntrSpec 을 생성합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @return String
	 */
	public String createCntrSpecBasic(MstCntrSpecVO mstCntrSpecVO,SignOnUserAccount account) throws EventException;
}