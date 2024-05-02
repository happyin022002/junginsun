/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderBC.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderOutVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgImgStoVO;

/**
 * ALPS-Specialcargobookingconduct Business Logic Command Interface<br>
 * - ALPS-Specialcargobookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Jin Seo
 * @see Ui_bkg_0207EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpecialCargoRiderBC {
	/**
	 * ESM_BKG_0742 조회 이벤트 처리<br>
	 * BlRider :ESM_BKG_0742 화면에 대한 조회 이벤트 처리<br>
	 * B/L Rider & DG Rider 파일 업로드 현황 조회
	 * @author Lee Jin Seo
	 * @param AttachFileInVO attachFileInVO
	 * @return List<AttachFileOutVO>
	 * @exception EventException
	 */
	public List<AttachFileOutVO> searchAttachFileList(AttachFileInVO attachFileInVO) throws EventException;

	/**
	 * ESM_BKG_0369 조회 이벤트 처리<br>
	 * BlRider :ESM_BKG_0369 화면에 대한 조회 이벤트 처리<br>
	 * b/l의 rider image 정보 list를 조회함
	 * @author Lee Jin Seo
	 * @param BlRiderInVO blRiderIn
	 * @return List<BlRiderOutVO>
	 * @exception EventException
	 */
	public List<BlRiderOutVO> searchBlRiderList(BlRiderInVO blRiderIn) throws EventException;

	/**
	 * ESM_BKG_0369 멀티 이벤트 처리<br>
	 * BlRider : ESM_BKG_0369 화면에 대한 멀티 이벤트 처리<br>
	 * @author Lee Jin Seo
	 * @param BlRiderInVO blRiderIn
	 * @exception EventException
	 */
	public void manageBlRider(BlRiderInVO blRiderIn) throws EventException;

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
	 * 파일이 삭제 되었으면 Spcl Rider Data 삭제
	 * @param vO
	 * @throws EventException
	 */
	public void removeSpclRider(BkgImgStoVO vO) throws EventException;
		
}