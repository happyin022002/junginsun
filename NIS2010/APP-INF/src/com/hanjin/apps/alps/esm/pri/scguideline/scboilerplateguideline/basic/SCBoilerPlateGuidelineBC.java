/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineBC.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.27 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgBlplHdrVO;
import com.hanjin.syscommon.common.table.PriSgBlplVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_pri_0007EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCBoilerPlateGuidelineBC {
	
	/**
	 * Boiler Plate Guide Line Header 를 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	/**
	 * Boiler Plate 타이틀, 본문 항목을 조회한다<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException;
	
	/**
	 * Boiler Plate Guideline 을 저장합니다. <br>
	 * 
	 * @param ScBlplGlineVO scBlplGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlateGuideline(ScBlplGlineVO scBlplGlineVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사용자가 노트를 컨폼한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사용자가 노트를 컨폼 cancel한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 보일러 플레이트 전체를 삭제한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @exception EventException
	 */
	public void removeBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	/**
	 * 선택된 보일러 플레이트를 카피한다<br>
	 * 
	 * @param RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBoilerPlateGuideline(RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Boiler Plate Guideline Header를 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrInquiryList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	
	/**
	 *  Boiler Plate Guideline List를 조회합니다.<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineInquiryList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException;
	
	/**
     * Boiler Plate Header Year를 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return List<PriSgBlplHdrVO>
	 * @exception EventException
	 */
	public  List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryYear(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	/**
     * Boiler Plate Header Duration 을 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return List<PriSgBlplHdrVO>
	 * @exception EventException
	 */
	public  List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryDuration(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;		

    /**
     * Excel 로 저장할 Boiler Plate 정보를 조회합니다.<br>
     * 
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplExcelVO>
     * @exception EventException
     */
    public List<PriSgBlplExcelVO> searchBoilerPlateGuidelineListExcel(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
}