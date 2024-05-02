/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderBC.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022908Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderOutVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Specialcargobookingconduct Business Logic Command Interface<br>
 * - ALPS-Specialcargobookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ui_bkg_0207EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpecialCargoRiderBC {
	/**
	 * ESM_BKG_0207 조회 이벤트 처리<br>
	 * SpclRider : ESM_BKG_0207 화면에 대한 조회 이벤트 처리<br>
	 * b/l의 SpclRider image 정보 list를 조회함
	 * @author Lee Jin Seo
	 * @param SpclRiderInVO spclRiderIn
	 * @return SpclRiderOutVO
	 * @exception EventException
	 */
	public SpclRiderOutVO searchSpclRiderList(SpclRiderInVO spclRiderIn) throws EventException;

	/**
	 * ESM_BKG_0207 멀티 이벤트 처리<br>
	 * SpclRider : ESM_BKG_0207  화면에 대한 멀티 이벤트 처리<br>
	 * @author Lee Jin Seo
	 * @param SpclRiderInVO spclRiderIn
	 * @exception EventException
	 */
	public void manageSpclRider(SpclRiderInVO spclRiderIn) throws EventException;

	/**
	 * DG rider를 Master booking으로 이동.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copySpclRiderAfterCombine(BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException;

	/**
	 * DG rider를 Master booking에서 삭제<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @exception EventException
	 */
	public void removeSpclRiderAfterCombine(BkgBlNoVO[] bkgBlNoVO) throws EventException;

	/**
	 * 
	 * @param event
	 * @param account
	 * @throws EventException
	 */
	public void manageSpclRider(EsmBkg022908Event event, SignOnUserAccount account) throws EventException;

}