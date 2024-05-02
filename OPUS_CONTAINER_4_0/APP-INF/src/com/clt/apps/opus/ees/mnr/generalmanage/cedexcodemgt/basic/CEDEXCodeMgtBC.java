/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
  
/**
 * COM-General manage Business Logic Command Interface<br>
 * - COM-General manage - interface of business logic<br>
 *
 * @author
 * @see Ees_mnr_0003EventResponse
 * @since J2EE 1.4
 */

public interface CEDEXCodeMgtBC {
	
	/**
	 * [EES_MNR_0225]Adding, modifying, deleting "Division Code Creation" data<br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDivisionCodeBasic(DivisionCodeGRPVO divisionCodeGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0225]Retrieving "Division Code Creation" data<br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @param SignOnUserAccount account
	 * @return DivisionCodeGRPVO
	 * @exception EventException
	 */
	public DivisionCodeGRPVO searchDivisionCodeListBasic(DivisionCodeGRPVO divisionCodeGRPVO,SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0193]Retrieving "Location Code Inquiry_Pop Up" data<br>
	 *
	 * @param DamageLocationCodeListGRPVO damageLocationCodeListGRPVO
	 * @return DamageLocationCodeListGRPVO
	 * @exception EventException
	 */
	public DamageLocationCodeListGRPVO searchDamageLocationCodeListBasic(DamageLocationCodeListGRPVO damageLocationCodeListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0003]Adding, modifying, deleting "Damage Location" data<br>
	 *
	 * @param DamageLocationCodeListGRPVO damageLocationCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageLocationCodeBasic(DamageLocationCodeListGRPVO damageLocationCodeListGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0002]Retrieving "EQ Component" data<br>
	 *
	 * @param ComponentCodeListGRPVO componentCodeListGRPVO
	 * @return ComponentCodeListGRPVO
	 * @exception EventException
	 */
	public ComponentCodeListGRPVO searchComponentCodeListBasic(ComponentCodeListGRPVO componentCodeListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0002]Adding, modifying, deleting "EQ Component" data<br>
	 *
	 * @param ComponentCodeListGRPVO componentCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageComponentCodeBasic(ComponentCodeListGRPVO componentCodeListGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0004]Retrieving "Damage Type" data<br>
	 *
	 * @param CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO
	 * @return CedexOtherCodeListGRPVO
	 * @exception EventException
	 */
	public CedexOtherCodeListGRPVO searchCedexOtherCodeListBasic(CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0004]Adding, modifying, deleting "Damage Type" data<br>
	 *
	 * @param CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCedexOtherCodeListBasic(CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0145]Retrieving "EQ Component Grouping by Location & Damage Type" data<br>
	 *
	 * @param CodeRelationGRPVO codeRelationGRPVO
	 * @return CodeRelationGRPVO
	 * @exception EventException
	 */
	public CodeRelationGRPVO searchCodeRelationListBasic(CodeRelationGRPVO codeRelationGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0145]Adding, modifying, deleting "EQ Component Grouping by Location & Damage Type" data<br>
	 *
	 * @param CodeRelationGRPVO codeRelationGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodeRelationBasic(CodeRelationGRPVO codeRelationGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0142]Retrieving "Pop Up_Tariff Code Finding" data<br>
	 *
	 * @param RepairCodeFindListGRPVO repairCodeFindListGRPVO
	 * @return RepairCodeFindListGRPVO
	 * @exception EventException
	 */
	public RepairCodeFindListGRPVO searchRepairCodeFindListBasic(RepairCodeFindListGRPVO repairCodeFindListGRPVO) throws EventException;
} 