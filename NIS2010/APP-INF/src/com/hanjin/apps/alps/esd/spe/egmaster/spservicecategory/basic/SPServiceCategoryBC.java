/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryBC.java
*@FileTitle : S/P Service Category Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.basic;

import java.util.List;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo.SpeSvcCateVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Egmaster Business Logic Command Interface<br>
 * - ALPS-Egmaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface SPServiceCategoryBC {

	/**
	 * S/P Service Category Confirm 을 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeSvcCateVO[] speSvcCateVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpSvcCateCfm(SpeSvcCateVO[] speSvcCateVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 업체의 서비스 카테고리 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpSvcCateCfm(Event e) throws EventException;	
	
	/**
	 * 저장전 저장할수 있는 데이터 인지 확인한다.<br>
	 * 
	 * @param SpeSvcCateVO speSvcCateVO
	 * @return List<SpeSvcCateVO>
	 * @exception EventException
	 */
	public List<SpeSvcCateVO> searchSpSvcCateCfmChk(SpeSvcCateVO speSvcCateVO) throws EventException;	
}