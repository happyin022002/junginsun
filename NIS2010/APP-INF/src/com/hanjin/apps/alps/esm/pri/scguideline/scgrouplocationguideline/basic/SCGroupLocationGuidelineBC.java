/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGroupLocationGuidelineBC.java
 *@FileTitle : Location Group Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.GrpLocGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSgGrpLocVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Park Sungsoo
 * @see Ui_pri_0001_02EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCGroupLocationGuidelineBC {
	/**
	 * Guideline - GroupLocation을 조회한다.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocVO> searchGroupLocationList(PriSgGrpLocVO priSgGrpLocVO) throws EventException;

	/**
	 * Guideline - GroupLocation Detail을 조회한다.<br>
	 * 
	 * @param PriSgGrpLocDtlVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocDtlVO> searchGroupLocationDetailList(PriSgGrpLocDtlVO priSgGrpLocVO)
			throws EventException;

	/**
	 * Group Location삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(PriSgGrpLocVO priSgGrpLocVO) throws EventException;

	/**
	 * Excel Download를 위해 Group Location을 조회한다.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocExcelVO> searchGroupLocationListExcel(PriSgGrpLocVO priSgGrpLocVO) throws EventException;

	/**
	 * Group Location 데이터에 대한 CUD 이벤트를 처리합니다.<br>
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
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;

	/**
	 * Group Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException;
}