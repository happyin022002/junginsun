/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineMainBC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.07.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010-RFAguideline Business Logic Command Interface<br>
 * - NIS2010-RFAguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Park Sungsoo
 * @see Ui_pri_0001EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAGuidelineMainBC {
	/**
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(
			PriRgMnVO vo) throws EventException;

	/**
	 * 하위 탭들에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineTermsCntVO>
	 * @exception EventException
	 */
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriRgMnVO vo)
			throws EventException;

	/**
	 * Guideline Main을 조회합니다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineMnVO>
	 * @exception EventException
	 */
	public List<RsltGlineMnVO> searchGuidelineMain(PriRgMnVO vo)
			throws EventException;

	/**
	 * Guideline Main 트랜잭션 데이터를 처리한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineMain(PriRgMnVO vo, SignOnUserAccount account)
			throws EventException;

	/**
	 * Guideline을 Confirm합니다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmGuidelineMain(PriRgMnVO vo, SignOnUserAccount account)
			throws EventException;

	/**
	 * Confirm된 Guideline을 Cancel합니다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGuidelineMain(PriRgMnVO vo, SignOnUserAccount account)
			throws EventException;

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO vo) throws EventException;

	/**
	 * RFA Guideline Main 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(RsltRfaGlineCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * RFA Guideline Effective Date 를 Check 합니다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineEffectiveDate(PriRgMnVO vo)
			throws EventException;

	/**
	 * 생성할 Guideline 의 새로운 gline_seq 를 조회합니다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return String
	 * @exception EventException
	 */
	public String getGuidelineSeq(PriRgMnVO vo) throws EventException;

    /**
     * RFA Guideline Copy 대상들의 기존 데이터 유무를 조회합니다.<br>
     * 
     * @param PriRgMnVO priRgMnVO
     * @return List<RsltRfaGlineCopyVO>
     * @exception EventException
     */
    public List<RsltRfaGlineCopyVO> searchGlineCopyCheckTermsExist(PriRgMnVO priRgMnVO) throws EventException;
}