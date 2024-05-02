/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonBC.java
*@FileTitle : GemCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : GEM
*@LastVersion : 1.0
* 2009.04.16 GEM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.basic;

import com.clt.apps.opus.cps.gem.gemcommon.gemcommon.vo.SlipPerfCondVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * NIS2010-Gemcommon Business Logic Command Interface<br>
 * - NIS2010-Gemcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GEM
 * @see GemcommonEventResponse 참조
 * @since J2EE 1.4
 */

public interface GEMCommonBC {	
	
	/**
	 * 전표 실적,예산 데이타 정규화
	 * slip 예산 , 전표 금액 수정
	 * @author 진윤오
	 * @category CPS_GEM_1001
	 * @category modifySlipPerf
	 * @param SlipPerfCondVO condVo
	 * @return int count
	 * @exception EventException
	 */
	public int modifySlipPerf(SlipPerfCondVO condVo) throws EventException;

	/**
	 * Silip 월별 합산금액 조정 
	 * GEM_RSLT_SMRY
	 * @author 진윤오
	 * @category CPS_GEM_1001
	 * @category modifyRsltSmryByYrmon
	 * @param SlipPerfCondVO condVo
	 * @return int count
	 * @exception EventException
	 */
	public int modifyRsltSmryByYrmon(SlipPerfCondVO condVo) throws EventException;
	
	/**
     * 일반관리비 BU 조직코드 조회
     * 
     * @author choijungmi
     * @category searchBUOffice
     * @return String[]
     * @exception EventException
     */
    public String[] searchBUOffice() throws EventException;
    
    /**
     * 일반관리비 Major 조직코드 조회
     * 
     * @author choijungmi
     * @category searchMajorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
    public String[] searchMajorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException;
    
    /**
     * 일반관리비 Minor 조직코드 조회
     * 
     * @author choijungmi
     * @category searchMinorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
    public String[] searchMinorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException;
    
    /**
     * [투자법인] BU조직에 속한 HO본사,HQ지역그룹,BU주관부서 코드 리스트 조회
     * 
     * @author Park Chang June
     * @category searchSubsMajorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
    public String[] searchSubsMajorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException;
    
    /**
     * [투자법인] HO본사,HQ지역그룹,BU주관부서의 속한 조직코드 리스트 조회
     * 
     * @author Park Chang June
     * @category searchSubsMinorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
    public String[] searchSubsMinorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException;
}