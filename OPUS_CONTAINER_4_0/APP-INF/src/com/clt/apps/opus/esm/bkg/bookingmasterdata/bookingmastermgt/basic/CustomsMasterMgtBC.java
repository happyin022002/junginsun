/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsMasterMgtBC.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.04 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 *BookingMasterDataSC Business Logic Basic Command Interface<br>
 * - BookingMasterDataSC 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Gyoung Sub
 * @see esm_bkg_0354EventResponse 참조
 * @since J2EE 1.6
 */

public interface CustomsMasterMgtBC {
	
	
	/**
	 *  0354: Canada ACI: Location of Goods 을 조회합니다.<br>
	 *  
	 * @param BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO
	 * @return List<BkgcustomscanadagrouplocationVO>
	 * @throws EventException
	 */
	public List<BkgcustomscanadagrouplocationVO> searchCanadaGroupLocationCD(BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO) throws EventException ;

	 /**
	  * 0354 Canada ACI: Location of Goods Setup - Loc Code 생성/수정을 위한 기존 데이타를 조회합니다.<br>
	  * @param BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO
	  * @return List<BkgcustomscanadagrouplocationVO>
	  * @throws EventException
	  */
	 public List<BkgcustomscanadagrouplocationVO> searchCanadaGroupLocationCD2(BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO) throws EventException ;
		
	 
	/**
     * 0354: Canada ACI: Location of Goods 을 트랜잭션 처리합니다.<br>	
     * 
	 * @param BkgcustomscanadagrouplocationVO[] bkgcustomscanadagrouplocationVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageCanadaGroupLocationCD(BkgcustomscanadagrouplocationVO[] bkgcustomscanadagrouplocationVO,SignOnUserAccount account) throws EventException;
    
    /**
     * @param inputVO
     * @return
     * @throws EventException
     */
    public String searchYardDesc(BkgcustomscanadagrouplocationVO inputVO) throws EventException;
    
    /**
     * @param inputVO
     * @return
     * @throws EventException
     */
    public String searchLocDesc(BkgcustomscanadagrouplocationVO inputVO) throws EventException;    
}