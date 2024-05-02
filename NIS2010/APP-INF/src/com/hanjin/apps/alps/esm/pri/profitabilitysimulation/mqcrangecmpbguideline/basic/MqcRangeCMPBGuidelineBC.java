/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MqcRangeCMPBGuidelineBC.java
*@FileTitle : CMPB Guideline- MQC Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMqcRngVO;

/**
 * ALPS-Profitabilitysimulation Business Logic Command Interface<br>
 * - ALPS-Profitabilitysimulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6003EventResponse 참조
 * @since J2EE 1.6
 */

public interface MqcRangeCMPBGuidelineBC {

	/**
	 * MQC RNG를 조회한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO
	 * @return List<PriCmpbGlineMqcRngVO>
	 * @exception EventException
	 */
	public List<PriCmpbGlineMqcRngVO> searchCmpbGlineMqcRangeList(PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO) throws EventException;
	
	/**
	 * MQC RNG를 등록 수정 삭제 한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMqcRangeCmpbGuideline(PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 헤더 별 copy 등록한다<br>
	 * 
	 * @param rsltDurationCreationOfficeVO RsltDurationCreationOfficeVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyMqcRangeCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 헤더 별 전체 삭제<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeMqcRangeCmpbGuideline(PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account ) throws EventException;
	
}