/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedBC.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;

/**
 * NIS2010-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutaccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see Esm_fms_0046EventResponse 참조
 * @since J2EE 1.6
 */

public interface TCharterIOEstimatedBC {
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMmFrom String
	 * @param estRevMmTo String
	 * @param fletCtrtTpCd String
	 * @param seachTpCd String
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedRevenueList(String estRevMmFrom , String estRevMmTo , String fletCtrtTpCd, String seachTpCd) throws EventException;

	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param customEstmIfVOs CustomEstmIfVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedRevenue(CustomEstmIfVO[] customEstmIfVOs, String slpOfcCd, String usrId) throws EventException;
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMm String
	 * @return List<SearchEstimatedProRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueList(String estRevMm) throws EventException ;
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 결과를 등록한다<br>
	 * 
	 * @param customEstmIfVOs CustomEstmIfVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedProRevenue(CustomEstmIfVO[] customEstmIfVOs, String slpOfcCd, String usrId) throws EventException;
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMmFrom String
	 * @param estRevMmTo String
	 * @param fletCtrtTpCd String
	 * @return List<SearchEstimatedHireResultListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedHireResultListVO> searchEstimatedHireResultList(String estRevMmFrom , String estRevMmTo , String fletCtrtTpCd) throws EventException ;
}