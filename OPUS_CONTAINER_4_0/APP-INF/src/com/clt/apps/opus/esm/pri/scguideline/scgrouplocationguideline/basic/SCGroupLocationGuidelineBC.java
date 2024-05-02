/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGroupLocationGuidelineBC.java
 *@FileTitle : Location Group Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSgGrpLocVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Scguideline<br>
 * 
 * @author 
 * @see Ui_pri_0001_02EventResponse 
 * @since J2EE 1.4
 */

public interface SCGroupLocationGuidelineBC {
	/**
	 * Retrieving Guideline - GroupLocation.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocVO> searchGroupLocationList(PriSgGrpLocVO priSgGrpLocVO) throws EventException;

	/**
	 * Retrieving Guideline - GroupLocation Detail<br>
	 * 
	 * @param PriSgGrpLocDtlVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocDtlVO> searchGroupLocationDetailList(PriSgGrpLocDtlVO priSgGrpLocVO)
			throws EventException;

	/**
	 * checking whether code is in use at rate when deleting Group Location<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(PriSgGrpLocVO priSgGrpLocVO) throws EventException;

	/**
	 * Retrieving group location to download excel<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocExcelVO> searchGroupLocationListExcel(PriSgGrpLocVO priSgGrpLocVO) throws EventException;

	/**
	 * Handling CUD event for Group Location data.<br>
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * Deleting guideline from Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Copying Group Guideline<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
}