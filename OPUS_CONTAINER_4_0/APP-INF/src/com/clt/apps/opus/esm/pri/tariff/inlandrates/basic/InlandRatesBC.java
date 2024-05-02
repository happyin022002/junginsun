/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesBC.java
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndRtVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTrfInlndRtVO;
import com.clt.syscommon.common.table.PriTrfInlndVO;

/**
 * Tariff Business Logic Command Interface<br>
 * - interface about Tariff biz logic<br>
 *
 * @author SHKIM
 * @see EsmPri3514EventResponse
 * @since J2EE 1.6
 */
public interface InlandRatesBC {

	/**
	 * retrieving Inland Rate name<br>
	 * 
	 * @param PriTrfInlndVO	priTrfInlndVO
	 * @return List<PriTrfInlndVO>
	 * @exception EventException
	 */
	public List<PriTrfInlndVO> searchInlandRatesName(PriTrfInlndVO priTrfInlndVO) throws EventException;
	

	/**
	 * retrieving Inland Rate <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRates(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;	

	/**
	 * retrieving Inland Rate Detail <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesLocation(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;


	/**
	 * downloading Inland Rate Detail <br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesExcel(PriTrfInlndRtVO priTrfInlndRtVO) throws EventException;
	
	/**
	 * saving Inland Rate file<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInlandRatesFile(PriTrfInlndVO priTrfInlndVO, List<String> keys, SignOnUserAccount account) throws EventException;

	/**
	 * saving Inland Rate information <br>
	 * 
	 * @param PriTrfInlndListVO priTrfInlndListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInlandRates(PriTrfInlndListVO priTrfInlndListVO, SignOnUserAccount account) throws EventException;

	/**
	 * deleting Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @exception EventException
	 */
	public void removeInlandRates(PriTrfInlndVO priTrfInlndVO) throws EventException;
	
	/**
	 * Request : Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * canceling Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * approving Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * Publishing Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;

	/**
	 * Amending Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving Inland Rate <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesInquiryList(PriTrfInlndVO priTrfInlndVO) throws EventException;
	
	/**
	 * retrieving Inland Rate Detail<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesInquiry(PriTrfInlndRtVO priTrfInlndRtVO) throws EventException;
	
	/**
	 * retrieving Inland Rates Name <br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException;
	
	/**
	 * retrieving Inland Rates Amend  <br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesAmendHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException;
	
	/**
	 * retrieving Inland Rates Location <br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesHistory(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException;
	
	/**
	 * retrieving Tariff Code List <br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws EventException;
	
	/**
	 * checking Inland Rates Location excel information <br>
	 * 
	 * @param PriTrfInlndRtVO[] priTrfInlndRtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchInlandRatesCheck(PriTrfInlndRtVO[] priTrfInlndRtVO) throws EventException;
	
	/**
	 * retrieving Inland Rate Max Seq<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesMaxSeq(PriTrfInlndVO priTrfInlndVO) throws EventException;

	/**
	 * retrieving Inland Rate Location Max Seq<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesLocationMaxSeq(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;
	
	/**
	 * retrieving Inland Rate Location's last update date <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesMaxUpdate(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;
	
	/**
	 * retrieving existence of Inland Rate<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesExistCheck(PriTrfInlndVO priTrfInlndVO) throws EventException;
}