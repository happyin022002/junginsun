/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeBC.java
*@FileTitle : Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.clt.apps.opus.esm.pri.surcharge.surcharge.vo.PriScgRtValidVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Surcharge Business Logic Command Interface<br>
 * -interface about Surcharge biz logic<br>
 *
 * @author SHKIM
 * @see Esm_pri_4003EventResponse 
 * @since J2EE 1.6
 */

public interface SurchargeBC {
	/**
	 * Retrieving Percentage Base Code<br>
	 * 
	 * @param PriScgPrfVO priScgPrfVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComboPctBseCdList(PriScgPrfVO priScgPrfVO) throws EventException;
	
	/**
	 * Retrieving Surcharge Preferences list<br>
	 * 
	 * @param PriScgPrfVO priScgPrfVO
	 * @return List<PriScgPrfVO>
	 * @exception EventException
	 */
	public List<PriScgPrfVO> searchSurchargePreferences(PriScgPrfVO priScgPrfVO) throws EventException;
	
	/**
	 * Modifying Surcharge Preferences <br>
	 * 
	 * @param PriScgPrfVO[] priScgPrfVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargePreferences(PriScgPrfVO[] priScgPrfVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Surcharge<br>
	 * 
	 * @param PriScgRtVO priScgRtVO
	 * @return List<PriScgRtVO>
	 * @exception EventException
	 */
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO) throws EventException;
	
	/**
	 * Retrieving Surcharge (for paging)<br>
	 * 
	 * @param PriScgRtVO priScgRtVO
	 * @param int nPage
	 * @return List<PriScgRtVO>
	 * @exception EventException
	 */
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO, int nPage) throws EventException;
	
	/**
	 * Modifying Surcharge<br>
	 * 
	 * @param PriScgRtVO[] priScgRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeRate(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * checking duplicate Surcharge  <br>
	 * 
	 * @param PriScgRtVO[] priScgRtVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkSurchargeDuplicate(PriScgRtVO[] priScgRtVOs) throws EventException;
	
	/**
	 * checking duplicate Surcharge <br>
	 * 
	 * @param PriScgRtVO[] priScgRtVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkSurchargeDuplicateExcel(PriScgRtVO[] priScgRtVOs) throws EventException;	
	
	/**
	 * Retrieving Surcharge total List (for paging)<br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @param int nPage
	 * @return List<PriScgRtVO>
	 * @exception EventException
	 */
	public List<PriScgRtVO> searchAllSurchargeList(CstPriScgRtVO cstPriScgRtVO, int nPage) throws EventException;
	
	/**
	 * Retrieving Surcharge total List (for EXCEL)<br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> searchSurchargeListForExcel(CstPriScgRtVO cstPriScgRtVO) throws EventException;
	
	/**
	 * deleting Sucharge Preferences  <br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @exception EventException
	 */
	public void removeSurchargePreferences(CstPriScgRtVO cstPriScgRtVO) throws EventException;
	
	/**
	 * deleting Sucharge Rate <br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @exception EventException
	 */
	public void removeSurchargeRate(CstPriScgRtVO cstPriScgRtVO) throws EventException;
	
	/**
	 * check surcharge data <br>
	 * 2015.03.27 CREATE
	 * @param PriScgRtVO[] priScgRtVOS
	 * @return List<PriScgRtValidVO>
	 * @exception EventException
	 */
	public List<PriScgRtValidVO> checkSurchargeExcelData(PriScgRtVO[] priScgRtVOS) throws EventException;
}