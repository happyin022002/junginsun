/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateGuidelineBC.java
 *@FileTitle : RFA Rate Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.06 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineRoutVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtListExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgMnVO;
import com.hanjin.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRgRtVO;

/**
 * NIS2010-RFAguideline Business Logic Command Interface<br>
 * - NIS2010-RFAguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFARateGuidelineBC {

	/**
	 * Rate Guideline Commdity 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtHdrVO rgVo
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRgRtCmdtHdrVO rgVo) throws EventException;

	/**
	 * Rate Guideline Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtRoutVO vo
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRgRtCmdtRoutVO vo) throws EventException;

	/**
	 * Rate Guideline Rate 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtVO rtVo
	 * @return RsltRtRoutListVO
	 * @exception EventException
	 */
	public RsltRtRoutListVO searchRateList(PriRgRtVO rtVo) throws EventException;

	/**
	 * Rate Guideline Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriRgRtCmdtHdrVO vo
	 * @return List<RsltRtListExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListExcelVO> searchRateListExcel(PriRgRtCmdtHdrVO vo) throws EventException;

	/**
	 * Rate Commodity Header 데이터의 CUD 트랜잭션 이벤트를 처리한다.<br>
	 * 
	 * @param RfaRtGlineCmdtVO cmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtGlineCmdtVO cmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate Commodity - Route 데이터의 CUD 트랜잭션 이벤트를 처리한다.<br>
	 * 
	 * @param RfaRtGlineRoutVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateRoute(RfaRtGlineRoutVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO vo) throws EventException;

    /**
     * RFA Guideline Rate Vertical Excel 의 정합성을 체크합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs) throws EventException;

    
    /**
     * RFA Guideline Rate Vertical Excel 로 Guideline Rate 를 생성합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVertical(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;

    /**
     * RFA Guideline Rate Horizontal Excel 의 정합성을 체크합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelHorizontal(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs) throws EventException;

    /**
     * RFA Guideline Rate Horizontal Excel 로 Guideline Rate 를 생성합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelHorizontal(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Rate Vertical Excel Download 리스트를 조회합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListVerticalExcelVO>
     * @exception EventException
     */
    public List<RsltRfaRtListVerticalExcelVO> searchRateListVerticalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws EventException;
    
    /**
     * Guideline Rate Horizontal Excel Download 리스트를 조회합니다.<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListHorizontalExcelVO>
     * @exception EventException
     */
    public List<RsltRfaRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws EventException;

    /**
     * RFA Guideline Rate 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;
}