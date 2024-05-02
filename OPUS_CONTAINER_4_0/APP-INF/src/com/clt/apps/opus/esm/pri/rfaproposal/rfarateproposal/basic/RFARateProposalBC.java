/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateProposalBC.java
 *@FileTitle : RFARateProposalBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvCommVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRoutListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpRtActCustVO;
import com.clt.syscommon.common.table.PriRpScpRtCgoSpecVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtVO;
import com.clt.syscommon.common.table.PriRpScpRtCnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.clt.syscommon.common.table.PriRpScpRtVO;



/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 * 
 * @author 
 * @see Ui_pri_0030EventResponse 
 * @since J2EE 1.4
 */

public interface RFARateProposalBC {

	
	/**
	 * Retrieving style information for diplay after handling CUD transaction<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return RsltRtCmdtRoutListVO
	 * @exception EventException
	 */
	public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate's Commodity Group.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving Rate Inquiry - Commodity Group<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving Rate History - Commodity Group<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityHistoryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving Rate's Route information<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate Inquiry - Route List<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate History - Route List<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Retrieving Rate information<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateList(PriRpScpRtVO priRpScpRtVO) throws EventException;

	/**
	 * Retrieving Rate Inquiry - Rate information<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateInquiryList(PriRpScpRtVO priRpScpRtVO) throws EventException;

	/**
	 * Retrieving for Excel Download(Vertical)<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving for Excel Download(Horizontal)<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving  duplicated rate list<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCheckDuplicateVO>
	 * @exception EventException
	 */
	public List<RsltRtCheckDuplicateVO> searchRateCheckDuplicate(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving Accept All's List<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Retrieving last Bullet No. of Rate's Commodity<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String getMaxOldBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Handling multi transaction of Commodity Group <br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi-transaction of Route and Rate data<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Actual Customer data<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Actual Customer data<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Rate data<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Rate data<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Commodity Note data<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Commodity Note data<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Commodity data<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Commodity data<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Route Note data<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Route Note data.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Route Point data.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Route Point data<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Route Via. data<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Route Point data<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting all item of rate<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRate(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling acceptance of Rate's all item<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRate(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * copying Guideline's data<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineRate(RfaGlineCopyVO rfaGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * Checking whether Group Location, Group Commodity exists or not before copying Guideline <br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkGlineCopyGroupCodeExist(RfaGlineCopyVO rfaGlineCopyVO) throws EventException;

	/**
	 * Applying GRI Calculation to rate<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling applied GRI Calculation<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting Amend SEQ No's all data when canceling Main's Init status<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void removeProposalMain(PriRpScpMnVO priRpScpMnVO) throws EventException;
 
	/**
	 * checking whether loaded excel data is correct or not<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException;

	/**
	 * Uploading loaded excel data to Sheet<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *Uploading loaded excel data to Sheet<<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;
	
//	/**
//	 * Uploading loaded excel data to Sheet<<br>
//	 * 
//	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
//	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @exception EventException
//	 */
//	public String uploadRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException;

//	/**
//	 * Uploading loaded excel data to Sheet<<br>
//	 * 
//	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
//	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void uploadRateExcelHorizontalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException;



	/**
	 * Handling retrieving event<br>
	 * 
	 * @param RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
//	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
//			RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO) throws EventException;

	/**
	 * Changing Main duration's accepted data to Init at once when canceling Request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Rate Cargo Specification<br>
	 *  
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @return List<RsltPriRpScpRtCgoSpecVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpRtCgoSpecVO> searchRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws EventException;
	
	/**
	 * Modifying Rate Cargo Specification<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Rate Note Conversion<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException;
	
	/**
	 * Retrieving copied Rate Note Conversion<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Copying Rate Note Conversion<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVOs,SignOnUserAccount account) throws EventException;

    /**
     * Copying RFA Proposal Rate information<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeRate(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying Guideline Rate to Proposal <br>
     * 
     * @param RpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineRate(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
	
	/**
	 * Retrieving when surcharge is created on RFA Proposal - Rate Tab's Surcharge View All Popup.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
//	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	
	/**
	 *  Deleting Surcharge information<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @exception EventException
	 */
//	public void manageProposalScopeSurchargeRemove(RfaPropMnVO rfaPropMnVO) throws EventException;	
	
	/**
	 * Retrieving expire data information of main about previous amdt_seq.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBeforeExpireDate(PriRpScpMnVO priRpScpMnVO) throws EventException ;	
	
	/****************************************************************************************/
	/* ESM_PRI_2060  BackEndJob Start       */
	/****************************************************************************************/
	
	/**
	 *  call backEndJob to Check RFA Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String checkRateExcelHorizontalBackEndJob(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;

	/**
	 * Check RFA Contract with Excel <br>
	 * Only using in SCRateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */	
	public List<RsltRtListHorizontalExcelVO> checkRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;
  	
	/**
	 *  call backEndJob to Save RFA Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String uploadRateExcelHorizontalBackEndJob(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;

	/**
	 * Save RFA Contract with Excel <br>
	 * Only using in RFARateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void uploadRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException;
  	
	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException;
	
	/****************************************************************************************/
	/* ESM_PRI_2060  BackEndJob End       */
	/****************************************************************************************/
	
	//########### ESM_PRI_2022 2015.05.19 ADD START ############
	/**
	 * Retrieving Rate History - Commodity Group<br>
	 * 2016.05.19 ADD(using ESM_PRI_2022)
	 * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityConversionHistoryList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws EventException;
	
	/**
	 * Retrieving Rate History - Commodity Cnote and Conversion<br>
	 * 2016.05.19 ADD(using ESM_PRI_2022)
	 * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityForCnoteConvList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws EventException;
	
	/**
	 * Retrieving Rate History - Commodity Conversion<br>
	 * 2016.05.19 ADD(using ESM_PRI_2022)
	 * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityForConvList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws EventException;
	
	/**
	 * Handling multi transaction of Commodity CNote <br>
	 * 2016.05.19 ADD
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCommodityCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS, SignOnUserAccount account) throws EventException;
	//########### ESM_PRI_2022 2015.05.19 ADD END ############
}
