/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGroupLocationGuidelineBC.java
 *@FileTitle : Location Group Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRgGrpLocVO;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about Scguideline biz logic<br>
 * 
 * @author 
 * @see Ui_pri_0001_02EventResponse 
 * @since J2EE 1.4
 */

public interface RFAGroupLocationGuidelineBC {
	/**
	 * Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocVO> searchGroupLocationList(PriRgGrpLocVO priRgGrpLocVO) throws EventException;

	/**
	 *  Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRgGrpLocDtlVO priRgGrpLocDtlVO
	 * @return List<RsltPriRgGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocDtlVO> searchGroupLocationDetailList(PriRgGrpLocDtlVO priRgGrpLocDtlVO)
			throws EventException;

	/**
	 * checking existence of data in RATE<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(PriRgGrpLocVO priRgGrpLocVO) throws EventException;

	/**
	 * Excel Downloading <br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocExcelVO> searchGroupLocationListExcel(PriRgGrpLocVO priRgGrpLocVO) throws EventException;

	/**
	 * Saving LOCATION GROUP<br>
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * Deleting Guideline in Guideline Main <br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException;
	
    /**
     * copying RFA Guideline Group Location <br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * checking ORI/DEST TYPE's selection <br>
	 * setting ARR[0]: LOCATION CODE LIST, ARR[1]: ORI/DST TYPE NAME <br>
	 * 
	 * @param RsltPriRgGrpLocDtlVO[]  rsltPriRgGrpLocDtlVOs
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkGroupLocationCode(RsltPriRgGrpLocDtlVO[] rsltPriRgGrpLocDtlVOs) throws EventException;
	
	/**
	 * uploading excel file<br>
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * checking excel file<br>
	 * 
	 * @param RsltPriRgGrpVO[] rsltPriRgGrpVOs
	 * @return List<RsltPriRgGrpVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpVO> searchLocationGroupCodeCheckResult(RsltPriRgGrpVO[] rsltPriRgGrpVOs) throws EventException;
	
}