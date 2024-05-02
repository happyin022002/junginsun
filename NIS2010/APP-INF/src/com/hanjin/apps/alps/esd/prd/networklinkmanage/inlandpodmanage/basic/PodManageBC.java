/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PodManageBC.java
*@FileTitle : PodManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-24
*@LastModifier : Noh Seung Bae
*@LastVersion : 1.0
* 2009-08-24 Noh Seung Bae
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.PrdImdgClssCdVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.SearchPodListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-PRD Business Logic Command Interface<br>
 * - eNIS-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_085EventResponse 참조
 * @since J2EE 1.4
 */
public interface PodManageBC  {
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ★2009-10-16 kimkwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchPodListVO> searchPodList(SearchPodListVO vo) throws EventException;

	/**
	 * searchLoactionState
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchPodListVO> searchLoactionState(SearchPodListVO vo) throws EventException;
	
	/**
	 * searchValidation
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public String searchValidation(SearchPodListVO vo) throws EventException;
	
	/**
	 * pod 저장처리
	 * ★2009-10-16 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiPod(SearchPodListVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * Class 를 조회 합니다. <br>
	 * 
	 * @return List<PrdImdgClssCdVO>
	 * @exception EventException
	 */
	public List<PrdImdgClssCdVO> searchUNClass() throws EventException;


}