/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineBC.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.basic;


import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriRgGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.RsltPriRgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRgMnVO;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Ui_pri_2001_02EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAGroupCommodityGuidelineBC {
	/**
	 * COMMODITY GROUP을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriRgGrpCmdtVO> searchGroupCommodityGuidelineList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;
	/**
	 * COMMODITY GROUP DETAIL을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltPriRgGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;	
	/**
	 * COMMODITY GROUP을 저장합니다.<br>
	 * 
	 * @param GrpCmdtGlineVO grpCmdtGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodityGuideline(GrpCmdtGlineVO grpCmdtGlineVO,SignOnUserAccount account) throws EventException;
	/**
	 * RFAGroupCommodityGuideline화면에 화면에 대한 전체데이터삭제<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException;	
	
	/**
	 * TPW Group Commodity 조회 이벤트 처리<br>
	 *  RFAGroupCommodityGuideline화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return List<PriScgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriScgGrpCmdtVO> searchGRIGroupCommodityGuidelineList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException;
	
	/**
	 * 선택한 TPW Group Commodity 로 Group Commodity 를 생성합니다.<br>
	 * 
	 * @param PriGriGrpCmdtVO[] priGriGrpCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createGRIGroupCommodityGuideline(PriGriGrpCmdtVO[] priGriGrpCmdtVOs, SignOnUserAccount account) throws EventException;
		
	/**
	 * RATE에서 사용하는 commodity 코드가 있는지 조회한다.
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;	
	
    /**
     * RFA Guideline Group Commodity 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 *  RFA Guideline Group Commodity 정보를 다운로드 합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtExcelVO>
	 * @exception EventException
	 */
	public List<PriRgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;
	
}