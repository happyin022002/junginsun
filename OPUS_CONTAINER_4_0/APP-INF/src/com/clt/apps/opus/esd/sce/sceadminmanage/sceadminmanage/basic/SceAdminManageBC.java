/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageBC.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic;

import java.util.List;
import java.util.Set;

import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.SceAdminManageSC;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.SceActTmlIfVO;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * Sceadminmanage Business Logic Command Interface<br>
 * <br>
 *
 * @author Kim In-soo
 * @see SceAdminManageSC
 * @since J2EE 1.6
 */

public interface SceAdminManageBC {

	/**
	 * retrieving terminal change 
	 * @param SceAdminObjVO	sceAdminObjVO
	 * @return List<SceActTmlIfVO>
	 * @exception EventException
	 */
	public List<SceActTmlIfVO> searchTmlChgRslt(SceAdminObjVO sceAdminObjVO) throws EventException;
	
	/**
	 * update terminal change
	 * @param SceActTmlIfVO sceActTmlIfVO
	 * @return int
	 * @throws EventException
	 */
	public int modifyActTmlIfSts (SceActTmlIfVO sceActTmlIfVO) throws EventException;
	
	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceCopHdrVO> 
	 * @throws EventException
	 */
	public List<SceCopHdrVO> searchRplnCops(SceAdminObjVO sceAdminObjVO) throws EventException;
	
	/**
	 * interfaced to COA by daily batch
	 * @param Set<String> bkgNoSet
	 * @throws EventException
	 */
	public void interfaceCoaDailyBtch (Set<String> bkgNoSet) throws EventException ;
	
	/**
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<SceCopHdrVO>
	 * @throws EventException
	 */
	public List<SceCopHdrVO> searchMstCopNoDiff (String fm_dt, String to_dt) throws EventException;
	
	
	/**
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<CntrDiffVO>
	 * @throws EventException
	 */
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws EventException;
	
	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceActRcvIfVO>
	 * @throws EventException
	 */
	public List<SceActRcvIfVO> searchActDatRcvIf(SceAdminObjVO sceAdminObjVO) throws EventException;
}