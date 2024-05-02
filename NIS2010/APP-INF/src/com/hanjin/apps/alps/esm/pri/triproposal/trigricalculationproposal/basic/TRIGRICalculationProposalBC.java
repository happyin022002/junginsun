/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIGRICalculationProposalBC.java
 *@FileTitle : TRI GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.TriGriCalcVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTriGriGrpVO;

/**
 * NIS2010-TRIGRICalculationProposal Business Logic Command Interface<br>
 * - NIS2010-TRIGRICalculationProposal에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Sungsoo, Park
 * @see Ui_pri_3010EventResponse 참조
 * @since J2EE 1.4
 */

public interface TRIGRICalculationProposalBC {
	/**
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriTriGriGrpVO vo) throws EventException;

	/**
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriTriGriGrpVO vo) throws EventException;

	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param TriGriCalcVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(TriGriCalcVO pVo, SignOnUserAccount account) throws EventException;

}