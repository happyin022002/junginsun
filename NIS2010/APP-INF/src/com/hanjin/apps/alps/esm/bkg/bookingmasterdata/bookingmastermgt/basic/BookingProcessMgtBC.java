/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtBC.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.04 김경섭
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CgoClzTmStupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 *ALPS-BookingMasterDataSC Business Logic Basic Command Interface<br>
 * - ALPS-BookingMasterDataSC 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Gyoung Sub
 * @see esm_bkg_0374EventResponse 참조
 * @since J2EE 1.6
 */

public interface BookingProcessMgtBC {
	
	/**
	 * 975 조회  처리<br>
	 * Bookingprocessmgt화면에 대한 조회 이벤트 처리<br>
	 * @author Lee Jin Seo
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @exception EventException
	 */
	public List<CodeDescVO> searchChargeCode(CodeDescVO codeDescVO) throws EventException ;

	/**
	 *  0374  Arrival Notice의 Office Default  US Destination Office Setup 을 조회합니다.<br>
	 *  
	  * @param String officeCD
	  * @param String  handlingOfficeCD
	 * @return List<BkganDestOfcStupVO>
	 * @throws EventException
	 */
	public List<BkganDestOfcStupVO> searchANDestOfcList(String officeCD,String  handlingOfficeCD) throws EventException ;

	/**
	 * 0374  저장을 위한 조회. EQ OFC가 HQ OFC에 이미 등록되어 있으면 저장을 하지 못한다.<br>
	 * 단. EQ OFC와 HQ OFC가 같은 경우는 예외이다<br>
	 *  
	 * @param String officeCD
	 * @param String  handlingOfficeCD
	 * @return List<BkganDestOfcStupVO>
	 * @throws EventException
	 */
	public List<BkganDestOfcStupVO> searchANDestOfcList2(String officeCD,String  handlingOfficeCD) throws EventException;
	 
	/**
     * 0374  Arrival Notice의 Office Default  US Destination Office Setup 을 트랜잭션 처리합니다.<br>	
     * 
	 * @param BkganDestOfcStupVO[] bkganDestOfcStupVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageANDestOfcList(BkganDestOfcStupVO[] bkganDestOfcStupVO,SignOnUserAccount account) throws EventException;
    
    /**
	 *  Office Setup 에 정보를 조회합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDpcsUsrGrp2VO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> searchOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	
	/**
	 * Office Setup 에 Office 를 저장/수정/삭제 합니다. (ESM_BKG_0741)<br>
	 * 
	 * @param BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficePfmc(BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  Office Setup 에 등록된 Office code 인지 여부를 체크합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> checkOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	
	/**
	 *  Office Setup 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> checkCtrlOffice(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code 정보를 조회한다.(ESM_BKG_0040)<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @return List<BkgCstmsAdvScacVO>
	 * @exception EventException
	 */	
	public List<BkgCstmsAdvScacVO>  searchScacNumber (BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws EventException ;
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 입력 한다.(ESM_BKG_0040)<br>
	 * @param BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs
	 * @exception EventException
	 */	
	public void manageScacNumber(BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs) throws EventException;
	
	/**
	 * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을<br>
	 * 관리할 목적. SKD를 Update될 때마다 항상 조건을 확인한 후 VBL_ESTBDR_DT, VBL_FESTBDR_DT를<br>
	 * 수정하도록 한다.<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return BkgVvdBdrLogVO
	 * @exception EventException
	 */	
	public BkgVvdBdrLogVO manageBKGBDRLOG(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을<br>
	 * 관리할 목적. SKD를 Update될 때마다 항상 조건을 확인한 후 VBL_ESTBDR_DT, VBL_FESTBDR_DT를<br>
	 * 수정하도록 한다.<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	
	public String manageBKGBDRLOGBackEndJob(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException ;

	/**
	 * @param BkgUserSmsInputVO bkgUserSmsInputVO
	 * @return List<BkgUserSmsListVO>
	 * @throws EventException
	 */
	public List<BkgUserSmsListVO> searchSmsRcvList(BkgUserSmsInputVO bkgUserSmsInputVO)throws EventException ;
	
	/**
	 * @param CgoClzTmStupVO CgoClzTmStupVO
	 * @return List<CgoClzTmStupVO>
	 * @throws EventException
	 */
	public List<CgoClzTmStupVO> searchCgoClzTmStupList(CgoClzTmStupVO cgoClzTmStupVO)throws EventException ;

	/**
	 * @param BkgUserSmsListVO[] bkgUserSmsListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSmsRcvList(BkgUserSmsListVO[] bkgUserSmsListVOs, SignOnUserAccount account) throws EventException ;

	/**
	 * @param SignOnUserAccount account
	 * @param String slanCd 
	 * @param String dirCd 
	 * @return String
	 * @throws EventException
	 */
	public String chkOfcCnt(SignOnUserAccount account, String slanCd, String dirCd)throws EventException ;

	/**
	 * @param CgoClzTmStupVO[] cgoClzTmStupVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCgoClzTmList(CgoClzTmStupVO[] cgoClzTmStupVOs, SignOnUserAccount account) throws EventException ;
	
	/**
	 * @param SignOnUserAccount account
	 * @param String polCd 
	 * @param String laneCd 
	 * @param String dirCd
	 * @return List<CgoClzTmStupVO>
	 * @throws EventException
	 */
	public List<CgoClzTmStupVO> chkSetUpCnt(SignOnUserAccount account, String polCd, String laneCd, String dirCd)throws EventException ;
	
	/**
	 *  이미 등록된 Por 인지 여부를 체크합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> checkBkgOfcPorPfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException;
	

	 
}