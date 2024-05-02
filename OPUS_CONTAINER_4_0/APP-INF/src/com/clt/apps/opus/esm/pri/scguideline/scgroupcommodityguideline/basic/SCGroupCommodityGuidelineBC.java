/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineBC.java
*@FileTitle : Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.basic;


import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.PriSgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtCustTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about Scguideline biz logic<br>
 *
 * @author 
 * @see Ui_pri_0001_03EventResponse 
 * @since J2EE 1.4
 */

public interface SCGroupCommodityGuidelineBC {
	/**
	 *  Retrieving GroupCommodity data count by Cust Type<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtCustTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpCmdtCustTypeVO> searchGroupCommodityGuideCustTypeCount(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;	
	/**
	 * Retrieving Group Commodity main<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtVO> searchGroupCommodityGuidelineList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;
	/**
	 * Retrieving Group Commodity detail<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;	
	/**
	 * Saving Group Commodity <br>
	 * 
	 * @param GrpCmdtGlineVO grpCmdtGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodityGuideline(GrpCmdtGlineVO grpCmdtGlineVO,SignOnUserAccount account) throws EventException;
	/**
	 * Deleting Group Commodity<br>
	 * 
	 * @param PriSgMnVO prisgmnvo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;	
	
	/**
	 * Retrieving data for Excel Download<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtExcelVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;
	
	/**
	 * Retrieving Surcharge Group Commodity<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriScgGrpCmdtVO> searchGRIGroupCommodityGuidelineList(PriScgGrpCmdtVO priComGrpCmdtVO) throws EventException;

	/**
	 * Adding Guideline TPW Group Commodity<br>
	 * 
	 * @param PriGriGrpCmdtVO[] priGriGrpCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createGRIGroupCommodityGuideline(PriGriGrpCmdtVO[] priGriGrpCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Copying Commodity Guideline <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
	
	/**
	 * Retrieving commodity code using on the Rate
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;	
	

}