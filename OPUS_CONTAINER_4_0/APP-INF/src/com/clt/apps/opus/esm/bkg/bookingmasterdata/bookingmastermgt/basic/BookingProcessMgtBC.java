/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtBC.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate :  
*@LastModifier :  
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHamoTrfVO;

/**
 *BookingMasterDataSC Business Logic Basic Command Interface<br>
 * - BookingMasterDataSC Business Logic Basic Command implementation<br>
 *
 * @author  
 * @see esm_bkg_0374EventResponse 참조
 * @since J2EE 1.6
 */

public interface BookingProcessMgtBC {
	
	/**
	 * event processing<br>
	 * @author 
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @exception EventException
	 */
	public List<CodeDescVO> searchChargeCode(CodeDescVO codeDescVO) throws EventException ;

	/**
	 *  00374  Arrival Notice of the Office Default,  US Destination Office Setup search
	 *  
	 * @param String officeCD
	 * @param String  handlingOfficeCD
	 * @return List<BkganDestOfcStupVO>
	 * @throws EventException
	 */
	public List<BkganDestOfcStupVO> searchANDestOfcList(String officeCD,String  handlingOfficeCD) throws EventException ;

	/**
	 0374  Search for storing. EQ OFC already exists in the HQ OFC does not save.<br>
	 * exception: EQ OFC = HQ OFC<br>
	 *  
	 * @param String officeCD
	 * @param String  handlingOfficeCD
	 * @return List<BkganDestOfcStupVO>
	 * @throws EventException
	 */
	public List<BkganDestOfcStupVO> searchANDestOfcList2(String officeCD,String  handlingOfficeCD) throws EventException;
	 
	/**
     * 0374  Transaction processing.<br>
     * 
	 * @param BkganDestOfcStupVO[] bkganDestOfcStupVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageANDestOfcList(BkganDestOfcStupVO[] bkganDestOfcStupVO,SignOnUserAccount account) throws EventException;
    
    /**
	 *  Search Office Setup(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDpcsUsrGrp2VO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> searchOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	
	/**
	 * Office Setup save / modify / delete it. (ESM_BKG_0741)<br>
	 * 
	 * @param BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficePfmc(BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  Office code checking for the presence.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> checkOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	
	/**
	 *  Office code to check for duplicates.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> checkCtrlOffice(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code search) (ESM_BKG_0040)<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @return List<BkgCstmsAdvScacVO>
	 * @exception EventException
	 */	
	public List<BkgCstmsAdvScacVO>  searchScacNumber (BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws EventException ;
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) Information input(ESM_BKG_0040)<br>
	 * @param BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs
	 * @exception EventException
	 */	
	public void manageScacNumber(BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs) throws EventException;
	
	/**
	 * SKD  Update-> VBL_ESTBDR_DT, VBL_FESTBDR_DT modify<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return BkgVvdBdrLogVO
	 * @exception EventException
	 */	
	public BkgVvdBdrLogVO manageBKGBDRLOG(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * SKD  Update-> VBL_ESTBDR_DT, VBL_FESTBDR_DT modify<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	
	public String manageBKGBDRLOGBackEndJob(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException ;


	 
}