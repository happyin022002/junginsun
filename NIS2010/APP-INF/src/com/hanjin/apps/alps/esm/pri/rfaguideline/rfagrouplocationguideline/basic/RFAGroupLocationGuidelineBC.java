/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGroupLocationGuidelineBC.java
 *@FileTitle : Location Group Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.04.15 최성민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.GrpLocGlineVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRgGrpLocVO;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Park Sungsoo
 * @see Ui_pri_0001_02EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAGroupLocationGuidelineBC {
	/**
	 * LOCATION GROUP MASTER를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocVO> searchGroupLocationList(PriRgGrpLocVO priRgGrpLocVO) throws EventException;

	/**
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocDtlVO priRgGrpLocDtlVO
	 * @return List<RsltPriRgGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocDtlVO> searchGroupLocationDetailList(PriRgGrpLocDtlVO priRgGrpLocDtlVO)
			throws EventException;

	/**
	 * RATE에의 사용데이터를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(PriRgGrpLocVO priRgGrpLocVO) throws EventException;

	/**
	 * 엑셀다운로드 정보를 조회합니다.
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocExcelVO> searchGroupLocationListExcel(PriRgGrpLocVO priRgGrpLocVO) throws EventException;

	/**
	 * LOCATION GROUP을 저장합니다.
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException;
	
    /**
     * RFA Guideline Group Location 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ORI/DEST TYPE의 선택유무를 체크한다.<br>
	 * ARR[0]: LOCATION CODE LIST, ARR[1]: ORI/DST TYPE NAME 으로 세팅됨.<br>
	 * 
	 * @param RsltPriRgGrpLocDtlVO[]  rsltPriRgGrpLocDtlVOs
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkGroupLocationCode(RsltPriRgGrpLocDtlVO[] rsltPriRgGrpLocDtlVOs) throws EventException;
	
	/**
	 * 엑셀데이터를 생성합니다.
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * 엑셀파일을 체크합니다.<br>
	 * 
	 * @param RsltPriRgGrpVO[] rsltPriRgGrpVOs
	 * @return List<RsltPriRgGrpVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpVO> searchLocationGroupCodeCheckResult(RsltPriRgGrpVO[] rsltPriRgGrpVOs) throws EventException;
	
}