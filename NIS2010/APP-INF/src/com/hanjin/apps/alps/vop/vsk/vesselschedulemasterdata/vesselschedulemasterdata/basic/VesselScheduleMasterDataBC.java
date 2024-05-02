/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataBC.java
*@FileTitle : Port Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.05.20 서창열
* 1.0 Creation
*
* History
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Vesselschedulemasterdata Business Logic Command Interface<br>
 * - NIS2010-Vesselschedulemasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see Vop_vsk-0033EventResponse 참조
 * @since J2EE 1.4
 */

public interface VesselScheduleMasterDataBC {
	
	/**
	 * Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchPortList(LocationVO locationVO) throws EventException;
	/**
	 * Port 정보를 수정합니다.
	 * 
	 * @param LocationVO[] locationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortList(LocationVO[] locationVOs,SignOnUserAccount account) throws EventException;
	/**
	 * 운하대리점이 관리하고 있는 Lane Code 리스트 정보를 조회합니다.
	 * 
	 * @return CanelRegistGRPVO
	 * @exception EventException
	 */
	public CanelRegistGRPVO searchLaneListByCanalAgency() throws EventException;
	
	/**
	 * 운하대리점이 관리하고 있는 Lane Code 리스트 정보를 등록한다.
	 * 
	 * @param CanelRegistGRPVO canelRegistGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneListByCanalAgency(CanelRegistGRPVO canelRegistGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사용자별 Lane Group 정보를 조회합니다.
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception EventException
	 */
	public List<UserLaneGroupVO> searchUserLaneGroup(String usrId) throws EventException;
	
	/**
	 * 사용자별 Lane Group 정보를 저장합니다.
	 * 
	 * @param UserLaneGroupVO[] userLaneGroupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUserLaneGroup(UserLaneGroupVO[] userLaneGroupVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사용자별 Lane Group 정보를 조회합니다.
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception EventException
	 */
	public List<UserLaneGroupVO> searchLaneGrpByUsrId(String usrId) throws EventException;
	
	/**
	 * User별 Group을 조회합니다<br>
	 * 
	 * @param String usr_id
	 * @return List<UserDefinedLanePortGroupVO>
	 * @exception EventException
	 */
	public List<UserDefinedLanePortGroupVO> searchLanePortGroupByUserId(String usr_id) throws EventException;
	/**
	 * User별 Group을 조회합니다<br>
	 * 
	 * @param String usr_id
	 * @return List<UserDefinedLanePortGroupVO>
	 * @exception EventException
	 */
	public List<UserDefinedLanePortGroupVO> searchUserDefinedLanePortGroup(String usr_id) throws EventException;
	/**
	 * Save user별 Lane Group 정보를 저장합니다.
	 * 
	 * @param UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUserDefinedLanePortGroup(UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs, SignOnUserAccount account) throws EventException;
}