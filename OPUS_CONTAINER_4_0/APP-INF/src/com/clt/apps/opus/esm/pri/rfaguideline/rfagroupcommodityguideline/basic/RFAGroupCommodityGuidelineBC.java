/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineBC.java
*@FileTitle : Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.basic;


import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriRgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.RsltPriRgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 *
 * @author
 * @see Ui_pri_2001_02EventResponse 
 * @since J2EE 1.4
 */

public interface RFAGroupCommodityGuidelineBC {
	/**
	 * Retrieving COMMODITY GROUP을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriRgGrpCmdtVO> searchGroupCommodityGuidelineList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;
	/**
	 * Retrieving COMMODITY GROUP DETAIL을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltPriRgGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;	
	/**
	 * Saving COMMODITY GROUP을 저장합니다.<br>
	 * 
	 * @param GrpCmdtGlineVO grpCmdtGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodityGuideline(GrpCmdtGlineVO grpCmdtGlineVO,SignOnUserAccount account) throws EventException;
	/**
	 * Deleting Guideline Group Commodity information<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException;	
		
	/**
	 *  Retrieving commodity in rate <br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;	
	
    /**
     * Copying RFA Guideline Group Commodity Information.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * Downloading RFA Guideline Group Commodity Information<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtExcelVO>
	 * @exception EventException
	 */
	public List<PriRgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException;
	
}