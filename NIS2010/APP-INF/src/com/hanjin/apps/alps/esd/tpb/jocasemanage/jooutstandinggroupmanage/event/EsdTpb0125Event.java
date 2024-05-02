/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0125Event.java
*@FileTitle : JOOutstandinggroupManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchJOOutstandinggroupManageListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0125 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0125HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0125HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0125Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOOutstandinggroupManageListVO searchJOOutstandinggroupManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchJOOutstandinggroupManageListVO[] searchJOOutstandinggroupManageListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBGroupModifyListVO searchTPBGroupModifyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVOs = null;

	public EsdTpb0125Event(){}
	
	public void setSearchJOOutstandinggroupManageListVO(SearchJOOutstandinggroupManageListVO searchJOOutstandinggroupManageListVO){
		this. searchJOOutstandinggroupManageListVO = searchJOOutstandinggroupManageListVO;
	}

	public void setSearchJOOutstandinggroupManageListVOS(SearchJOOutstandinggroupManageListVO[] searchJOOutstandinggroupManageListVOs){
		this. searchJOOutstandinggroupManageListVOs = searchJOOutstandinggroupManageListVOs;
	}

	public SearchJOOutstandinggroupManageListVO getSearchJOOutstandinggroupManageListVO(){
		return searchJOOutstandinggroupManageListVO;
	}

	public SearchJOOutstandinggroupManageListVO[] getSearchJOOutstandinggroupManageListVOS(){
		return searchJOOutstandinggroupManageListVOs;
	}

	public SearchTPBGroupModifyListVO getSearchTPBGroupModifyListVO() {
		return searchTPBGroupModifyListVO;
	}

	public void setSearchTPBGroupModifyListVO(
			SearchTPBGroupModifyListVO searchTPBGroupModifyListVO) {
		this.searchTPBGroupModifyListVO = searchTPBGroupModifyListVO;
	}

	public SearchTPBGroupModifyListVO[] getSearchTPBGroupModifyListVOs() {
		return searchTPBGroupModifyListVOs;
	}

	public void setSearchTPBGroupModifyListVOs(
			SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVOs) {
		this.searchTPBGroupModifyListVOs = searchTPBGroupModifyListVOs;
	}

}