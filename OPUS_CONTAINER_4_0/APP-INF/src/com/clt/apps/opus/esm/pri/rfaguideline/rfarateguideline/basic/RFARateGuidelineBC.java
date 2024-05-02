/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateGuidelineBC.java
 *@FileTitle : RFA Rate Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineRoutVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtListExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgMnVO;
import com.clt.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRgRtVO;

/**
 * RFAguideline Business Logic Command Interface<br>
 * - interface about RFAguideline biz logic<br>
 * 
 * @author 
 * @see Ui_pri_0030EventResponse
 * @since J2EE 1.4
 */

public interface RFARateGuidelineBC {

	/**
	 * Retrieving Rate Guideline Commodity<br>
	 * 
	 * @param PriRgRtCmdtHdrVO rgVo
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRgRtCmdtHdrVO rgVo) throws EventException;

	/**
	 * Retrieving Rate Guideline Route List<br>
	 * 
	 * @param PriRgRtCmdtRoutVO vo
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRgRtCmdtRoutVO vo) throws EventException;

	/**
	 * Retrieving Rate Guideline Rate List<br>
	 * 
	 * @param PriRgRtVO rtVo
	 * @return RsltRtRoutListVO
	 * @exception EventException
	 */
	public RsltRtRoutListVO searchRateList(PriRgRtVO rtVo) throws EventException;

	/**
	 * Retrieving Rate Guideline Excel Download List<br>
	 * 
	 * @param PriRgRtCmdtHdrVO vo
	 * @return List<RsltRtListExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListExcelVO> searchRateListExcel(PriRgRtCmdtHdrVO vo) throws EventException;

	/**
	 * handling Rate Commodity Header data's CUD transaction <br>
	 * 
	 * @param RfaRtGlineCmdtVO cmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtGlineCmdtVO cmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * handling Rate Commodity - Route data's CUD transaction <br>
	 * 
	 * @param RfaRtGlineRoutVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateRoute(RfaRtGlineRoutVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting Guideline in Guideline Main <br>
	 * 
	 * @param PriRgMnVO vo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO vo) throws EventException;

    /**
     * checking RFA Guideline Rate Vertical Excel's compatibility<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs) throws EventException;

    
    /**
     * creating RFA Guideline Rate by RFA Guideline Rate Vertical Excel<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVertical(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;

    /**
     * checking RFA Guideline Rate Horizontal Excel's compatibility<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelHorizontal(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs) throws EventException;

    /**
     * creating RFA Guideline Rate by RFA Guideline Rate Horizontal Excel<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelHorizontal(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException;

    /**
     * Retrieving Guideline Rate Vertical Excel Download List<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListVerticalExcelVO>
     * @exception EventException
     */
    public List<RsltRfaRtListVerticalExcelVO> searchRateListVerticalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws EventException;
    
    /**
     * Retrieving Guideline Rate Horizontal Excel Download List<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListHorizontalExcelVO>
     * @exception EventException
     */
    public List<RsltRfaRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws EventException;

    /**
     * copying RFA Guideline Rate<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;
}