/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 * 
 * @author 
 * @see Ui_pri_0001EventResponse 
 * @since J2EE 1.4
 */

public interface SCGuidelineMainBC {
	/**
	 * Retrieving registered guideline list in selected Service scope<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(PriSgMnVO priSgMnVO)
			throws EventException;

	/**
	 * Retrieving SC Guideline's Main screen<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineMnVO>
	 * @exception EventException
	 */
	public List<RsltGlineMnVO> searchGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Retrieving whether data exists on below tabs<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineTermsCntVO>
	 * @exception EventException
	 */
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Handing Guideline Main Transaction data<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Confirming Guideline<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 *  Cancelling confirmed guideline<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling guideline in Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Copying Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Checking whether duplicating Guideline Effective Date<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineEffectiveDate(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Numbering SEQ from Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return String
	 * @exception EventException
	 */
	public String getGuidelineSeq(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Copying Guideline Main<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMainAll(GlineMnCpVO glineMnCpVO) throws EventException;

}