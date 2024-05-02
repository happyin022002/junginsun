/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateGuidelineBC.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.20 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.ScRtGlineCmdtVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.ScRtGlineRoutVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSgRtMqcRngVO;
import com.hanjin.syscommon.common.table.PriSgRtVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCRateGuidelineBC {
	/**
	 * Radio Button 표시를 위한 Customer Type을 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltRtCustTpVO> searchRateCustomerType(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Guideline Commdity 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Guideline Route 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtRoutVO priSgRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSgRtCmdtRoutVO priSgRtCmdtRoutVO) throws EventException;

	/**
	 * Rate Guideline Rate 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return RsltRtRoutListVO
	 * @exception EventException
	 */
	public RsltRtRoutListVO searchRateList(PriSgRtVO priSgRtVO) throws EventException;

	/**
	 * Rate Guideline Excel Download를 위해 Rate 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtListExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListExcelVO> searchRateListExcel(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Commodity Header 데이터의 CUD 트랜잭션 이벤트를 처리한다.<br>
	 * 
	 * @param ScRtGlineCmdtVO scRtGlineCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtGlineCmdtVO scRtGlineCmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate Commodity - Route 데이터의 CUD 트랜잭션 이벤트를 처리한다.<br>
	 * 
	 * @param ScRtGlineRoutVO scRtGlineRoutVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateRoute(ScRtGlineRoutVO scRtGlineRoutVO, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Rate Vertical Excel 의 정합성을 체크합니다.<br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @param RsltRtListExcelVO[] rsltRtListExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO, RsltRtListExcelVO[] rsltRtListExcelVOs) throws EventException;

    
    /**
     * Guideline Rate Vertical Excel 로 Guideline Rate 를 생성합니다.<br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @param RsltRtListExcelVO[] rsltRtListExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVertical(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO, RsltRtListExcelVO[] rsltRtListExcelVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Guideline MQC 리스트를 조회합니다.<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @return List<PriSgRtMqcRngVO>
	 * @exception EventException
	 */
	public List<PriSgRtMqcRngVO> searchRateMQCRangeList(PriSgRtMqcRngVO priSgRtMqcRngVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * Scrateguideline 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param PriSgRtMqcRngVO[] priSgRtMqcRngVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateMQCRange(PriSgRtMqcRngVO[] priSgRtMqcRngVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Rate Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
}