/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostBC.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomMktRtVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomStndHirVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomTeuRngVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchTeuRangeListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutfleetmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Woo-Seok
 * @see Esm_fms_0062EventResponse 참조
 * @since J2EE 1.4
 */

public interface TCharterStandardPrimeCostBC {
	
	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 조회한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchTeuRangeListVO>
	 * @exception EventException
	 */
	public List<SearchTeuRangeListVO> searchTeuRangeList(String rngYr) throws EventException;

	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 조회한다<br>
	 * 
	 * @param customTeuRngVOs CustomTeuRngVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageTeuRange(CustomTeuRngVO[] customTeuRngVOs,String usrId) throws EventException;
	
	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 전체 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @exception EventException
	 */
	public void removeAllTeuRange(String rngYr) throws EventException;
	
	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 조회한다<br>
	 * 
	 * @param mktRtYrmon String
	 * @return List<SearchHireBaseListVO>
	 * @exception EventException
	 */
	public List<SearchHireBaseListVO> searchHireBaseList(String mktRtYrmon) throws EventException;
	
	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 변경한다<br>
	 * 
	 * @param customMktRtVOs CustomMktRtVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageHireBase(CustomMktRtVO[] customMktRtVOs, String usrId) throws EventException;
	
	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 변경한다<br>
	 * 
	 * @param mktRtYrmon String
	 * @exception EventException
	 */
	public void removeAllHireBase(String mktRtYrmon) throws EventException;
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 조회한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchStandardHireListVO>
	 * @exception EventException
	 */
	public List<SearchStandardHireListVO> searchStandardHireList(String rngYr) throws EventException;
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 등록 및 변경한다<br>
	 * 
	 * @param customStndHirVOs CustomStndHirVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageStandardHire(CustomStndHirVO[] customStndHirVOs, String usrId) throws EventException;
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @exception EventException
	 */
	public void removeAllStandardHire(String rngYr) throws EventException;

	/**
	 * 월간 Standard Hire (표준 용선료)를 산출한다<br>
	 * 
	 * @param rngYr String
	 * @param usrId String
	 * @return List<SearchStandardHireBaseListVO>
	 * @exception EventException
	 */
	public List<SearchStandardHireBaseListVO> searchStandardHireBaseList(String rngYr, String usrId) throws EventException;
}