/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Park Sungsoo
 * @see Ui_pri_0001EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCGuidelineMainBC {
	/**
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(PriSgMnVO priSgMnVO)
			throws EventException;

	/**
	 * SC Guideline 메인화면을 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineMnVO>
	 * @exception EventException
	 */
	public List<RsltGlineMnVO> searchGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * 하위 탭들에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineTermsCntVO>
	 * @exception EventException
	 */
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Guideline Main 트랜잭션 데이터를 처리한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline을 Confirm합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Confirm된 Guideline을 Cancel합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Guideline Main을 Copy한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Effective Date가 중복인지 조회합니다. <br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineEffectiveDate(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Guideline Main 테이블에서 Seq를 채번합니다. <br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return String
	 * @exception EventException
	 */
	public String getGuidelineSeq(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Guideline Main을 Copy 합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMainAll(GlineMnCpVO glineMnCpVO) throws EventException;

}