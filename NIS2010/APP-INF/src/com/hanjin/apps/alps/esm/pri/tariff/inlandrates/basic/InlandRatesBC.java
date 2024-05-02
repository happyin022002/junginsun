/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesBC.java
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndRtVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfInlndRtVO;
import com.hanjin.syscommon.common.table.PriTrfInlndVO;

/**
 * ALPS-Tariff Business Logic Command Interface<br>
 * - ALPS-Tariff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNGMIN
 * @since J2EE 1.6
 */

public interface InlandRatesBC {

	/**
	 * [Inland Rate 명]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO	priTrfInlndVO
	 * @return List<PriTrfInlndVO>
	 * @exception EventException
	 */
	public List<PriTrfInlndVO> searchInlandRatesName(PriTrfInlndVO priTrfInlndVO) throws EventException;
	

	/**
	 * [Inland Rate 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRates(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;
	

	/**
	 * [Inland Rate Detail 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesLocation(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;


	/**
	 * [Inland Rate Detail 정보]을 [다운로드] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesExcel(PriTrfInlndRtVO priTrfInlndRtVO) throws EventException;
	
	/**
	 * [Inland Rate 파일]을 [저장] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInlandRatesFile(PriTrfInlndVO priTrfInlndVO, List<String> keys, SignOnUserAccount account) throws EventException;

	/**
	 * [Inland Rate 정보]을 [저장] 합니다.<br>
	 * 
	 * @param PriTrfInlndListVO priTrfInlndListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInlandRates(PriTrfInlndListVO priTrfInlndListVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Inland Rate 정보]을 [삭제] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @exception EventException
	 */
	public void removeInlandRates(PriTrfInlndVO priTrfInlndVO) throws EventException;
	
	/**
	 * [Inland Rate 정보]을 [Request] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Inland Rate 정보]을 [취소] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Inland Rate 정보]을 [승인] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * [Inland Rate 정보]을 [Publish] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Inland Rate 정보]을 [Amend] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Inland Rate 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesInquiryList(PriTrfInlndVO priTrfInlndVO) throws EventException;
	
	/**
	 * [Inland Rate Detail 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesInquiry(PriTrfInlndRtVO priTrfInlndRtVO) throws EventException;
	
	/**
	 * [Inland Rates Name 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException;
	
	/**
	 * [Inland Rates Amend 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesAmendHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException;
	
	/**
	 * [Inland Rates Location 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesHistory(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException;
	
	/**
	 * [Tariff Code List 정보]을 [조회] 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws EventException;
	
	/**
	 * [Inland Rates Location 엑셀정보]을 [체크] 합니다.<br>
	 * 
	 * @param PriTrfInlndRtVO[] priTrfInlndRtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchInlandRatesCheck(PriTrfInlndRtVO[] priTrfInlndRtVO) throws EventException;
	
	/**
	 * [Inland Rate Max Seq]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesMaxSeq(PriTrfInlndVO priTrfInlndVO) throws EventException;

	/**
	 * [Inland Rate Location Max Seq]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesLocationMaxSeq(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;
	
	/**
	 * [Inland Rate Location 의 최근 업데이트 날짜] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesMaxUpdate(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException;
	
	/**
	 * [Inland Rate] 존재유무를 [조회] 합니다.<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesExistCheck(PriTrfInlndVO priTrfInlndVO) throws EventException;
}