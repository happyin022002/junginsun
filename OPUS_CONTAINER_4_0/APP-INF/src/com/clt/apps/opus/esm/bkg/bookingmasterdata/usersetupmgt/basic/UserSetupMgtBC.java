/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UserSetupMgtBC.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlCluzStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlESignatureVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCorrectionVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.PlaceOfIssueAssociationVO;		//SJH.20141121.ADD


/**
 * BookingMaterData Business Logic Basic Command implementation<br>
 * - BookingMaterData  handling business transaction<br>
 * 
 * @author 
 * @see UI_BKG-0365EventResponse,UserSetupMgtBC
 * @since J2EE 1.4
 */

public interface UserSetupMgtBC {
    
	/**
     * User Template List retrieve method.<br>
     *
     * @author 
     * @param usrTmpltVo
     * @return List<BkgUsrTmpltVO>
     * @exception EventException
     */
	public List<BkgUsrTmpltVO> searchUserTmpltList(BkgUsrTmpltVO usrTmpltVo) throws EventException;
    
	/**
     * User Template List management method.<br>
     *
     * @author 
     * @param usrTmpltVo
     * @param account
     * @exception EventException
     */
    public void manageUserTmpltList(BkgUsrTmpltVO[] usrTmpltVo, SignOnUserAccount account) throws EventException;
    	
    /**
     * retrieve event process<br>
     * retrieve event for screen of UserSetupMgt.<br>
     * 
     * @author
     * @param BkgUsrTmpltVO usrTmpltVo
     * @return List<BkgUsrTmpltVO>
     * @exception EventException
     */
	public List<BkgUsrTmpltVO> searchRmkTemplate(BkgUsrTmpltVO usrTmpltVo) throws EventException;
	
	/**
     * retrieve event process.<br>
     * retrieve event for UserSetupMgt.<br>
     * 
     * @author
     * @param String userid
     * @return BkgUsrDfltSetVO
     * @exception EventException
     */
	public BkgUsrDfltSetVO searchUserDefaultSetting (String userid) throws EventException ;
	
	/**
     * multi event process.<br>
     * multi event process for screen of In.<br>
     * 
     * @author
     * @param BkgUsrDfltSetVO vo
     * @exception EventException
     */
    public void createUserDefaultSettingByBooking(BkgUsrDfltSetVO vo) throws EventException ;

    /**
     * retrieve event process.<br>
     * retrieving search condition for 0232 screen.
     * retrieve event for screen of UserSetupMgt<br>
     * 
     * @param String usrId
     * @return List<BkgXterSrchSetVO>
     * @exception EventException
     */
	public List<BkgXterSrchSetVO> searchUserXterSearchSet(String usrId) throws EventException;

	/**
     * multi event process.<br>
     * save search condition of 0232 by multi.<br> 
     * showing error msg in case of not existing Country Code.<br>
     * multi event process for screen of In.<br>
     *
     * @author
     * @param bkgXterSrchSetVO BkgXterSrchSetVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void manageUserXterSearchSet(BkgXterSrchSetVO[] bkgXterSrchSetVO,SignOnUserAccount account) throws EventException;

    
    /**
	 * retrieve 0743, 0064 B/L Print option.<br>
	 * 
	 * @author
	 * @param BkgUsrDfltSetVO bkgUsrDfltSetVO
	 * @param SignOnUserAccount account
	 * @return List<BkgUsrDfltSetVO>
	 */
	public List<BkgUsrDfltSetVO> searchUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO, SignOnUserAccount account) throws EventException;
	
	/**
	  * retrieve 0743 C/A No Option.<br>
	  * 
	  * @author
	  * @param String bkgNo 
 	  * @param SignOnUserAccount account	   
	  * @return List<BkgCorrectionVO>
	  * @throws EventException
	  */
	 public List<BkgCorrectionVO> searchUserPrintSetup2(String bkgNo, SignOnUserAccount account) throws EventException;
	 
	 /**
	  * retrieve init condition for 0743_01 group print.<br> 
	  *
	  * @author
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup3(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws EventException;
	 
	 /**
	  * retrieve 0743_01 print setting.<br>
	  * 
	  * @author
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup4(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws EventException;
	 
	 /**
		 *  save 0743,0064 B/L Print Option.<br>
		 *
		 * @author
		 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
		 * @param SignOnUserAccount account
	     * @exception EventException
		 */
	public void manageUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO, SignOnUserAccount account) throws EventException;
	
	/**
	  * retrieve 0922 Office Detail.<br>
	  * 
	  * @author
	  * @param String ofcCd 
	  * @param SignOnUserAccount account
	  * @return List<MdmOrganizationVO>
	  * @throws EventException
	  */
	 public List<MdmOrganizationVO> searchOfficeDetail(String ofcCd, SignOnUserAccount account) throws EventException;

	 /**
     * searchRptItmStup
     * 
     * @author 
     * @param ofcCd
     * @param custCd
     * @return List<RptItmStupVO>
     * @throws EventException
     */
    public List<RptItmStupVO> searchRptItmStup(String ofcCd, String custCd) throws EventException;

    /**
     * manageRptItmStup
     * 
     * @author 
     * @param RptItmStupVO[] rptItmStupVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageRptItmStup(RptItmStupVO[] rptItmStupVOs, SignOnUserAccount account) throws EventException;

    /**
     * searchOfcCd
     * 
     * @author 
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchOfcCd() throws EventException;
    
    /**
	 * @param BkgInternetAuthorityVO bkgInternetAuthorityVO
	 * @return  List<BkgInternetAuthorityVO>
	 * @exception EventException
	 */		
	public List<BkgInternetAuthorityVO> searchUserInternetAuth(BkgInternetAuthorityVO bkgInternetAuthorityVO) throws EventException;
	
    /**
     * @param BkgInternetAuthorityVO[] bkgInternetAuthorityVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUserInternetAuth(BkgInternetAuthorityVO[] bkgInternetAuthorityVO,SignOnUserAccount account) throws EventException;
    
    /**
     * @param String countryCode
     * @param String eSignatureLastNm
     * @return List<BlESignatureVO>
     * @exception EventException
     */
    public List<BlESignatureVO> searchBlESignatureList(String countryCode, String eSignatureLastNm) throws EventException;
    
    /**
     * @param String blEsigSeq
     * @return List<BlESignatureVO>
     * @exception EventException
     */
    public List<BlESignatureVO> searchBlESignature(String blEsigSeq) throws EventException;
    
    /**
     * @param BlESignatureVO blESignatureVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void addBlESignature(BlESignatureVO blESignatureVO, SignOnUserAccount account) throws EventException;
	
	/**
     * @param BlESignatureVO blESignatureVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyBlESignature(BlESignatureVO blESignatureVO, SignOnUserAccount account) throws EventException;
	
	/**
     * @param String blEsigSeq
     * @exception EventException
     */
	public void removeBlESignature(String blEsigSeq) throws EventException;
	
    /** 
     * searchPlaceOfIssueAssociationList
     * @param String countryCode
     * @param String blIssOfcNm
     * @return List<PlaceOfIssueAssociationVO>
     * @exception EventException
     */
	public List<PlaceOfIssueAssociationVO> searchPlaceOfIssueAssociationList(String countryCode, String blIssOfcNm) throws EventException;
	
    /** 
     * removePlaceOfIssueAssociation
     * @param String blEsigSeq
     * @exception EventException
     */
	public void removePlaceOfIssueAssociation(String blEsigSeq) throws EventException;
	
    /** 
     * searchPlaceOfIssueAssociation
     * @param String blEsigAsgnSeq
     * @return List<PlaceOfIssueAssociationVO>
     * @exception EventException
     */
	public List<PlaceOfIssueAssociationVO> searchPlaceOfIssueAssociation(String blEsigAsgnSeq) throws EventException;
	
    /** 
     * addPlaceOfIssueAssociation
     * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void addPlaceOfIssueAssociation(PlaceOfIssueAssociationVO placeOfIssueAssociationVO, SignOnUserAccount account) throws EventException;
	
    /** 
     * modifyPlaceOfIssueAssociation
     * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyPlaceOfIssueAssociation(PlaceOfIssueAssociationVO placeOfIssueAssociationVO, SignOnUserAccount account) throws EventException;
	
    /** 
     * searchEmployeeList
     * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
     * @return List<PlaceOfIssueAssociationVO>
     * @exception EventException
     */
	public List<PlaceOfIssueAssociationVO> searchEmployeeList(PlaceOfIssueAssociationVO placeOfIssueAssociationVO) throws EventException;	 
	
    /**
     * searchCntClause
     * 
     * @author 
     * @param String orgCntCd
     * @return List<BlCluzStupVO>
     * @throws EventException
     */
    public List<BlCluzStupVO> searchBlCluzStup(String orgCntCd) throws EventException;
 
    /**
     * manage country clause
     * 
     * @author 
     * @param BlCluzStupVO[] blCluzStupVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageBlCluzStup(BlCluzStupVO[] blCluzStupVOs, SignOnUserAccount account) throws EventException;

}