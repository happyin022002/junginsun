/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineBC.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgBlplHdrVO;
import com.clt.syscommon.common.table.PriSgBlplVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about Scguideline biz logic<br>
 *
 * @author
 * @see Esm_pri_0007EventResponse 
 * @since J2EE 1.4
 */

public interface SCBoilerPlateGuidelineBC {
	
	/**
	 * Boiler Plate Guide Line Header  retrieving<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	/**
	 * retrieving Boiler Plate title, body item<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException;
	
	/**
	 * Boiler Plate Guideline saving <br>
	 * 
	 * @param ScBlplGlineVO scBlplGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlateGuideline(ScBlplGlineVO scBlplGlineVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Note confirming <br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Note confirming cancel <br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * deleting all Boiler Plate<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @exception EventException
	 */
	public void removeBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	/**
	 * copying selected Boiler Plate<br>
	 * 
	 * @param RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBoilerPlateGuideline(RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Boiler Plate Guideline Header retrieving<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrInquiryList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	
	/**
	 *  Boiler Plate Guideline List retrieving<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineInquiryList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException;
	
	/**
     * Boiler Plate Header Year retrieving<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return List<PriSgBlplHdrVO>
	 * @exception EventException
	 */
	public  List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryYear(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
	
	/**
     * Boiler Plate Header Duration  retrieving<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return List<PriSgBlplHdrVO>
	 * @exception EventException
	 */
	public  List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryDuration(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;		

    /**
     * retrieving Boiler Plate to save excel file<br>
     * 
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplExcelVO>
     * @exception EventException
     */
    public List<PriSgBlplExcelVO> searchBoilerPlateGuidelineListExcel(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
    
    /**
     * check to S/C(PRI_SP_MN Table) in use <br><br>
     * 
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception EventException
     * @LastModifyDate : 2014.10.07
     */
    public int checkBoilerPlateGuidelineUse(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException;
}