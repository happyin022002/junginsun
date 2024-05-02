/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineMainBC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineTermsCntVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * RFAguideline Business Logic Command Interface<br>
 * - Handling a biz logic about RFAguideline<br>
 * 
 * @author 
 * @see Ui_pri_0001EventResponse
 * @since J2EE 1.4
 */

public interface RFAGuidelineMainBC {
	/**
	 * Retrieving Guideline list registered in selected Service scope<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(
			PriRgMnVO vo) throws EventException;

	/**
	 * Retrieving whether data in sub-tab exists or not<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineTermsCntVO>
	 * @exception EventException
	 */
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriRgMnVO vo)
			throws EventException;

	/**
	 * Retrieving Guideline Main<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineMnVO>
	 * @exception EventException
	 */
	public List<RsltGlineMnVO> searchGuidelineMain(PriRgMnVO vo)
			throws EventException;

	/**
	 * handling Guideline Main transaction data<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineMain(PriRgMnVO vo, SignOnUserAccount account)
			throws EventException;

	/**
	 * Confirming Guideline<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmGuidelineMain(PriRgMnVO vo, SignOnUserAccount account)
			throws EventException;

	/**
	 * Cancelling Confirmed Guideline.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGuidelineMain(PriRgMnVO vo, SignOnUserAccount account)
			throws EventException;

	/**
	 * Deleting guideline from Guideline Main<br>
	 * 
	 * @param PriRgMnVO vo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO vo) throws EventException;

	/**
	 * Copying RFA Guideline Main information<br>
	 * 
	 * @param RsltRfaGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(RsltRfaGlineCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Checking RFA Guideline Effective Date<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineEffectiveDate(PriRgMnVO vo)
			throws EventException;

	/**
	 * Retrieving new guide_SEQ of guideline to be created<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return String
	 * @exception EventException
	 */
	public String getGuidelineSeq(PriRgMnVO vo) throws EventException;

    /**
     * Retrieving wheter existing data of RFA Guideline for copying exists or not<br>
     * 
     * @param PriRgMnVO priRgMnVO
     * @return List<RsltRfaGlineCopyVO>
     * @exception EventException
     */
    public List<RsltRfaGlineCopyVO> searchGlineCopyCheckTermsExist(PriRgMnVO priRgMnVO) throws EventException;
}