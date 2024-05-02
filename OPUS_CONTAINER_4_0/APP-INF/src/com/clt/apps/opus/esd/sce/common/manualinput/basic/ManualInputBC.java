/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtBC.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3306Event;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActualActivityMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCntrStsMsgMvmtMapgVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCopCntrRepoRuleVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceRailSplcVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmRegionVO;
import com.clt.syscommon.common.table.MdmYardVO;
/**
 * OPUS-CustomsDeclaration Business Logic Command Interface<br>
 * - OPUS-CustomsDeclaration Business Logic Interface<br>
 *
 * @author YoungHeon Lee
 * @see ManualInputBCImpl
 * @since J2EE 1.6
 */
public interface ManualInputBC {
	
	/**
	 * searchActualActivityMappingList.<br>
	 * @param ActualActivityMappingVO actualActivityMappingVO
	 * @return List<ActualActivityMappingVO>
	 * @throws EventException
	 */
	public List<ActualActivityMappingVO> searchActualActivityMappingList(ActualActivityMappingVO actualActivityMappingVO) throws EventException;

	/**
	 * manageActualActivityMapping.<br>
	 * @param actualActivityMappingVOs ActualActivityMappingVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageActualActivityMapping(ActualActivityMappingVO[] actualActivityMappingVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * checkActualCode.<br>
	 * @param String actCd
	 * @return String
	 * @throws EventException
	 */
	public String checkActualCode(String actCd) throws EventException;
	
	/**
	 * checkActualActivityMappingCode.<br>
	 * @param actCd String
	 * @param actStsMapgCd String
	 * @param actRcvTpCd String
	 * @return String
	 * @throws EventException
	 */
	public String checkActualActivityMappingCode(String actCd, String actStsMapgCd, String actRcvTpCd) throws EventException;
	
	/**
	 * searchActivityGroupList.<br>
	 * @param ActivityGroupVO activityGroupVO
	 * @return List<ActivityGroupVO>
	 * @throws EventException
	 */
	public List<ActivityGroupVO> searchActivityGroupList(ActivityGroupVO activityGroupVO) throws EventException;
	
	/**
	 * checkActivityGroupCode.<br>
	 * @param ActivityGroupVO activityGroupVO
	 * @return String
	 * @throws EventException
	 */
	public String checkActivityGroupCode(ActivityGroupVO activityGroupVO) throws EventException;
	
	/**
	 * manageActivityGroup.<br>
	 * @param activityGroupVOs ActivityGroupVO[] 
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageActivityGroup(ActivityGroupVO[] activityGroupVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchActivityGroupMappingList.<br>
	 * @param ActivityGroupMappingVO activityGroupMappingVO
	 * @return List<ActivityGroupMappingVO>
	 * @throws EventException
	 */
	public List<ActivityGroupMappingVO> searchActivityGroupMappingList(ActivityGroupMappingVO activityGroupMappingVO) throws EventException;
	
	/**
	 * checkCOPDetailGroupCode.<br>
	 * @param String copDtlGrpCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCOPDetailGroupCode(String copDtlGrpCd) throws EventException;
	
	/**
	 * checkActivityGroupMappingCode.<br>
	 * @param actCd String
	 * @param copDtlGrpCd String
	 * @return String
	 * @throws EventException
	 */
	public String checkActivityGroupMappingCode(String actCd, String copDtlGrpCd) throws EventException;

	/**
	 * manageActivityGroupMapping.<br>
	 * @param activityGroupMappingVOs ActivityGroupMappingVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageActivityGroupMapping(ActivityGroupMappingVO[] activityGroupMappingVOs, SignOnUserAccount account) throws EventException;
	
		/**
	 * searchSceCntrStsMsgMvmtMappingList.<br>
	 * @param SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO
	 * @return List<SceCntrStsMsgMvmtMapgVO>
	 * @throws EventException
	 */
	public List<SceCntrStsMsgMvmtMapgVO> searchSceCntrStsMsgMvmtMappingList(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) throws EventException;

	/**
	 * manageSceCntrStsMsgMvmt.<br>
	 * @param sceCntrStsMsgMvmtMapgVO SceCntrStsMsgMvmtMapgVO[] 
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageSceCntrStsMsgMvmt(SceCntrStsMsgMvmtMapgVO[] sceCntrStsMsgMvmtMapgVO, SignOnUserAccount account) throws EventException;  

	/**
	 * searchSceCopCntrRepoRuleList
	 * @param sceCopCntrRepoRuleVO
	 * @return
	 * @throws EventException
	 */
	public List<SceCopCntrRepoRuleVO> searchSceCopCntrRepoRuleList(SceCopCntrRepoRuleVO sceCopCntrRepoRuleVO) throws EventException;
	
	/**
	 * manageSceCopCntrRepoRule
	 * @param sceCopCntrRepoRuleVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageSceCopCntrRepoRule(SceCopCntrRepoRuleVO[] sceCopCntrRepoRuleVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchSceRailSplcList
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<SceRailSplcVO> searchSceRailSplcList(EsdSce3306Event event) throws EventException;
	
	/**
	 * manageSceRailSplc
	 * @param sceRailSplcVOs
	 * @param account
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void manageSceRailSplc(SceRailSplcVO[] sceRailSplcVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchMdmCntrTpszCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpszCd(HashMap<String, String> map) throws EventException;
	
	/**
	 * searchMdmCountryCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	public List<MdmCountryVO> searchMdmCountryCd(HashMap<String, String> map) throws EventException;
	
	/**
	 * searchMdmLocationCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	public List<MdmLocationVO> searchMdmLocationCd(HashMap<String, String> map) throws EventException;
	
	/**
	 * searchMdmRegionCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	public List<MdmRegionVO> searchMdmRegionCd(HashMap<String, String> map) throws EventException;
	
	/**
	 * searchMdmYard
	 * @param map
	 * @return
	 * @throws EventException
	 */
	public List<MdmYardVO> searchMdmYard(HashMap<String, String> map) throws EventException;
	
}