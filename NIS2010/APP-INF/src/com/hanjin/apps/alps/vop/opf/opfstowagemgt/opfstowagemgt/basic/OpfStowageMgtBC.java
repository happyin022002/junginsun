/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfStowageMgtBC.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.03 김도현
* 1.0 Creation
*=========================================================
* History
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.basic;

import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.OpfStowageBayPlanListVO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.BayPlanCntrDtlVO;
import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Changeofdestinationmgt Business Logic Command Interface<br>
 * - ALPS-Changeofdestinationmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see Vop_opf_0033EventResponse 참조
 * @since J2EE 1.6
 */

public interface OpfStowageMgtBC {

	/**
	 * Bay Plan 정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan의 Contailner 정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<BayPlanCntrDtlVO>
	 * @exception EventException
	 */
	public List<BayPlanCntrDtlVO> searchBayPlanCntrDtl(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan Hach Cover정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanHtchCvrList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan에서 조회조건 Container의 Bay 위치정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrPositionList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan에서 해당Container의 Bay Index정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrBayIdx(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan의 Container에 해당되는 Bay List를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrBayList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan의 Container에 해당되는 VVD 및 Port를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrVvdPortList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;

	/**
	 * Bay Plan Port별 Color정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchPortColorList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException;
	
	/**
	 * 타선사 Container 조회시 VESSEL정보가 없는경우 관련테이블에 데이터를 생성하기 위해 STO_TPL_CRE_PRC 호출<br>
	 * 
	 * @param String vslCd
	 * @exception EventException
	 */
	public void addBBayPlanVslCd(String vslCd) throws EventException;
}
