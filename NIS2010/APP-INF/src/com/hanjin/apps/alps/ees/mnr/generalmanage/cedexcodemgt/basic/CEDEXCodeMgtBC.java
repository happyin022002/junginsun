/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin
 * @see Ees_mnr_0003EventResponse 참조
 * @since J2EE 1.4
 */

public interface CEDEXCodeMgtBC { 
	/**
	 * [EES_MNR_0225]Division Code Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDivisionCodeBasic(DivisionCodeGRPVO divisionCodeGRPVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0225]Division Code Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @param SignOnUserAccount account
	 * @return DivisionCodeGRPVO
	 * @exception EventException
	 */
	public DivisionCodeGRPVO searchDivisionCodeListBasic(DivisionCodeGRPVO divisionCodeGRPVO,SignOnUserAccount account)throws EventException;
	/**
	 * [EES_MNR_0193]Location Code Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param DamageLocationCodeListGRPVO damageLocationCodeListGRPVO
	 * @return DamageLocationCodeListGRPVO
	 * @exception EventException
	 */
	public DamageLocationCodeListGRPVO searchDamageLocationCodeListBasic(DamageLocationCodeListGRPVO damageLocationCodeListGRPVO) throws EventException;
	/**
	 * [EES_MNR_0003]Damage Location의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DamageLocationCodeListGRPVO damageLocationCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */     
	public void manageDamageLocationCodeBasic(DamageLocationCodeListGRPVO damageLocationCodeListGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0002]EQ Component의 정보를 조회 합니다. <br>
	 *
	 * @param ComponentCodeListGRPVO componentCodeListGRPVO
	 * @return ComponentCodeListGRPVO
	 * @exception EventException
	 */
	public ComponentCodeListGRPVO searchComponentCodeListBasic(ComponentCodeListGRPVO componentCodeListGRPVO) throws EventException;
	/**
	 * [EES_MNR_0002]EQ Component의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ComponentCodeListGRPVO componentCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageComponentCodeBasic(ComponentCodeListGRPVO componentCodeListGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0004]Damage Type의 정보를 조회 합니다. <br>
	 *
	 * @param CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO
	 * @return CedexOtherCodeListGRPVO
	 * @exception EventException
	 */
	public CedexOtherCodeListGRPVO searchCedexOtherCodeListBasic(CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO) throws EventException;
	/**
	 * [EES_MNR_0004]Damage Type의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCedexOtherCodeListBasic(CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 조회 합니다. <br>
	 *
	 * @param CodeRelationGRPVO codeRelationGRPVO
	 * @return CodeRelationGRPVO
	 * @exception EventException
	 */
	public CodeRelationGRPVO searchCodeRelationListBasic(CodeRelationGRPVO codeRelationGRPVO) throws EventException;
	/**
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param CodeRelationGRPVO codeRelationGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodeRelationBasic(CodeRelationGRPVO codeRelationGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0142]Pop Up_Tariff Code Finding의 정보를 조회 합니다. <br>
	 *
	 * @param RepairCodeFindListGRPVO repairCodeFindListGRPVO
	 * @return RepairCodeFindListGRPVO
	 * @exception EventException
	 */
	public RepairCodeFindListGRPVO searchRepairCodeFindListBasic(RepairCodeFindListGRPVO repairCodeFindListGRPVO) throws EventException;
} 