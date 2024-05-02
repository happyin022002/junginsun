/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryBC.java
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-11
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeSubVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CollectionSummary Business Logic Command Interface<br>
 * - CollectionSummary에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Son, Jin-Hwan
 * @since J2EE 1.6 
 */
public interface CollectionSummaryBC {
	/**
	 * DOD Collection Summary by Customer list
	 * 
	 * @category EES_DOD_0016
	 * @param CollectionSummaryByCustomerVO collectionSummaryINVO
	 * @return List<CollectionSummaryByCustomerVO>
	 * @throws EventException
	 */
	public List<CollectionSummaryByCustomerVO> searchCollectionSummaryByCustomer(CollectionSummaryByCustomerVO collectionSummaryINVO) throws EventException;
	
	/**
	 * DOD Collection Summary by Customer Detail list
	 * 
	 * @category EES_DOD_0017
	 * @param CollectionSummaryByCustomerDetailVO collectionSummaryDetailINVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCollectionSummaryByCustomerDetailList(CollectionSummaryByCustomerDetailVO collectionSummaryDetailINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * DOD Collection Summary by Office
	 * 
	 * @category EES_DOD_0009
	 * @param sumbyOfcVO SumbyOfcVO
	 * @return List<SumbyOfcVO>
	 * @throws EventException
	 */	
	public List<SumbyOfcVO> searchSumbyOfc(SumbyOfcVO sumbyOfc) throws EventException;

	/**
	 * DOD Collection Summary by Office Detail
	 * 
	 * @category EES_DOD_0010
	 * @param sumbyOfcDetailVO SumbyOfcDetailVO
	 * @return List<SumbyOfcDetailVO>
	 * @throws EventException
	 */	
	public List<SumbyOfcDetailVO> searchSumbyOfcDetail(SumbyOfcDetailVO sumbyOfcDetailVO) throws EventException;


	/**
	 * DOD Collection Summary by Office - Combobox RHQ Office List
	 * 
	 * @category EES_DOD_0009
	 * @param 
	 * @return List<String>
	 * @throws EventException
	 */
	
	public List<String> searchRHQOfcList() throws EventException;


	/**
	 * DOD Collection Summary by Office - Combobox Office List
	 * 
	 * @category EES_DOD_0009
	 * @param 
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchOfcList() throws EventException;
	
	/**
	 * DOD Collection Summary by Office - Combobox Sub Office List
	 * 
	 * @category EES_DOD_0009
	 * @param 
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchSubOfcList(OfficeSubVO officeSubVO) throws EventException;

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
}
