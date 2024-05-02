/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineBC.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.basic;


import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.PriSgGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtCustTypeVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Ui_pri_0001_03EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCGroupCommodityGuidelineBC {
	/**
	 * GroupCommodity Cust Type을 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtCustTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpCmdtCustTypeVO> searchGroupCommodityGuideCustTypeCount(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;	
	/**
	 * Group Commodity 메인을 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtVO> searchGroupCommodityGuidelineList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;
	/**
	 * Group Commodity 상세를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;	
	/**
	 * Group Commodity 를 저장합니다.<br>
	 * 
	 * @param GrpCmdtGlineVO grpCmdtGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodityGuideline(GrpCmdtGlineVO grpCmdtGlineVO,SignOnUserAccount account) throws EventException;
	/**
	 * Group Commodity를 삭제합니다.<br>
	 * 
	 * @param PriSgMnVO prisgmnvo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;	
	
	/**
	 * Excel로 Download하기위한 데이터를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtExcelVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;
	
	/**
	 * Surcharge Group Commodity 정보를 조회합니다.<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriScgGrpCmdtVO> searchGRIGroupCommodityGuidelineList(PriScgGrpCmdtVO priComGrpCmdtVO) throws EventException;

	/**
	 * Guideline TPW Group Commodity 정보를 생성합니다.<br>
	 * 
	 * @param PriGriGrpCmdtVO[] priGriGrpCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createGRIGroupCommodityGuideline(PriGriGrpCmdtVO[] priGriGrpCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
	
	/**
	 * Rate에서 사용하는 commodity 코드가 있는지 조회한다.
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException;	
	

}