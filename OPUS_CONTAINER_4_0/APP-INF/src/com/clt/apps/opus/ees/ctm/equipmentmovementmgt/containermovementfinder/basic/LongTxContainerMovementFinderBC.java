/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongTxContainerMovementFinderBC.java
*@FileTitle : LongTxContainerMovementFinderBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Equipmentmovementmgt Business Logic Command Interface<br>
 *
 * @author
 * @see Ees_ctm_0440EventResponse reference
 * @since J2EE 1.6
 */

public interface LongTxContainerMovementFinderBC {

	/**
	 * EES_CTM_0418
	 * retrieving RCC Combo List when loading screen
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @exception DAOException, Exception
	 */
	public String getRccList(String ofcCd) throws EventException;

	/**
	 * EES_CTM_0418
	 * retrieving LCC when changing RCC Combo List
	 *
	 * @param String rccCd
	 * @return String
	 * @throws EventException
	 * @exception DAOException, Exception
	 */
	public String getLccList(String rccCd) throws EventException;

	/**
	 * EES_CTM_0418 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param MovementEDIReportVO movementEDIReportVO
	 * @return String
	 */
	public String doBackEndJob(SignOnUserAccount account, MovementEDIReportVO movementEDIReportVO);

	/**
	 * retrieving details about EES_CTM_0418 Movement Update time gap
	 *
	 * @param UpdateRatioDetailVO updateRatioDetailVO
	 * @return List<UpdateRatioDetailVO>
	 * @exception EventException
	 */
	public List<UpdateRatioDetailVO> getUpdateRatioDetail(UpdateRatioDetailVO updateRatioDetailVO) throws EventException ;

	/**
	 * EES_CTM_0417 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobEDIErrList(SignOnUserAccount account, SearchEDIErrorVO searchEDIErrorVO);

	/**
	 * EES_CTM_0417 : BackEndJob result
	 * retrieving EDI Error List Long Tx result
	 *
	 * @param String key
	 * @return List<SearchEDIErrorVO>
	 * @exception EventException
	 */
	public List<SearchEDIErrorVO> searchEDIErrorList(String key) throws EventException;

	/**
	 * EES_CTM_0417 : retrieving EDI error details for excel down including EDI error, row data 
	 *
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return List<SearchEDIErrorVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<SearchEDIErrorVO> searchEDIErrorDetailExcel(SearchEDIErrorVO searchEDIErrorVO) throws EventException;

	/**
	 * EES_CTM_0420 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return String
	 */
	public String doBackEndJobEDIRst(SignOnUserAccount account, SearchEDIResultVO searchEDIResultVO);

	/**
	 * EES_CTM_0420 : BackEndJob result
	 * retrieving EDI Result List Long Tx result
	 *
	 * @param String key
	 * @return List<SearchEDIResultVO>
	 * @exception EventException
	 */
	public List<SearchEDIResultVO> searchEDIResultList(String key) throws EventException;

	/**
	 * EES_CTM_0420 : retrieving EDI result detail for excel down
	 *
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return List<SearchEDIResultVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<SearchEDIResultVO> searchEDIResultDetailExcel(SearchEDIResultVO searchEDIResultVO) throws EventException;

	/**
	 * EES_CTM_0460 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param VLVDUpdateStatusVO vlvdUpdateStatusVO
	 * @return String
	 */
	public String doBackEndJobVLVDStatus(SignOnUserAccount account, VLVDUpdateStatusVO vlvdUpdateStatusVO);

	/**
	 * BackEndJob - returning BackEndJob status
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException ;

	/**
	 * retrieving auto created Movement list
	 *
	 * @param AutoCreStsListVO	autoCreStsListVO
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	public List<AutoCreStsListVO> getAutoCreSts(AutoCreStsListVO autoCreStsListVO) throws EventException ;

	/**
	 * EES_CTM_0462 : starting BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param AutoCreStsListVO autoCreStsListVO
	 * @return String
	 */
	public String doBackEndJobAutoCreStatus(SignOnUserAccount account, AutoCreStsListVO autoCreStsListVO);

	/**
	 * EES_CTM_0418 : BackEndJob result
	 * retrieving MVMT Timely Update Ratio Long Tx result
	 *
	 * @param String key
	 * @return List<MovementEDIReportVO>
	 * @exception EventException
	 */
	public List<MovementEDIReportVO> searchEDIOnTimeDetailList(String key) throws EventException;

	/**
	 * EES_CTM_0462 : BackEndJob result
	 * retrieving Auto Creation Status List Long Tx result
	 *
	 * @param String key
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	public List<AutoCreStsListVO> searchAutoCreStatus(String key) throws EventException;

}