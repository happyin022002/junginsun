/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateGuidelineBC.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCustTpVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.ScRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.ScRtGlineRoutVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgMnVO;
import com.clt.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSgRtMqcRngVO;
import com.clt.syscommon.common.table.PriSgRtVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about  Scguideline biz logic<br>
 * 
 * @author 
 * @see Ui_pri_0030EventResponse 
 * @since J2EE 1.4
 */

public interface SCRateGuidelineBC {
	/**
	 * retrieving Customer Type for Radio Button setting<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltRtCustTpVO> searchRateCustomerType(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException;

	/**
	 * retrieving Rate Guideline Commodity list<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Guideline Route list retrieving<br>
	 * 
	 * @param PriSgRtCmdtRoutVO priSgRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSgRtCmdtRoutVO priSgRtCmdtRoutVO) throws EventException;

	/**
	 * Rate Guideline Rate list retrieving<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return RsltRtRoutListVO
	 * @exception EventException
	 */
	public RsltRtRoutListVO searchRateList(PriSgRtVO priSgRtVO) throws EventException;

	/**
	 * Rate list retrieving for Rate Guideline Excel Download <br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtListExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListExcelVO> searchRateListExcel(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Commodity Header data CUD transaction event handling<br>
	 * 
	 * @param ScRtGlineCmdtVO scRtGlineCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtGlineCmdtVO scRtGlineCmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate Commodity - Route data CUD transaction event handling<br>
	 * 
	 * @param ScRtGlineRoutVO scRtGlineRoutVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateRoute(ScRtGlineRoutVO scRtGlineRoutVO, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Rate Vertical Excel validation check<br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @param RsltRtListExcelVO[] rsltRtListExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO, RsltRtListExcelVO[] rsltRtListExcelVOs) throws EventException;

    
    /**
     * creating Guideline Rate by Guideline Rate Vertical Excel <br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @param RsltRtListExcelVO[] rsltRtListExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVertical(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO, RsltRtListExcelVO[] rsltRtListExcelVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Guideline MQC list retrieving<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @return List<PriSgRtMqcRngVO>
	 * @exception EventException
	 */
	public List<PriSgRtMqcRngVO> searchRateMQCRangeList(PriSgRtMqcRngVO priSgRtMqcRngVO) throws EventException;

	/**
	 * multiple event handling<br>
	 * multiple event handling about SC rate guideline screen<br>
	 * 
	 * @param PriSgRtMqcRngVO[] priSgRtMqcRngVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateMQCRange(PriSgRtMqcRngVO[] priSgRtMqcRngVOs, SignOnUserAccount account) throws EventException;

	/**
	 * deleting Guideline at Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Rate Guideline Copying <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
}