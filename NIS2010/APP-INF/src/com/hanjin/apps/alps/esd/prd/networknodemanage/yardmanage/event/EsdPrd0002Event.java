/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_002Event.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
 * 2009-07-13 alps framework 구조 변경 noh seung bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0002Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd0002Event(){
	}
	private SearchLeaseListVO searchLeaseListVO;
	private SearchNodeListVO searchNodeListVO;
	private SearchYardDetailVO searchYardDetailVO;
	private SearchZoneDetailVO searchZoneDetailVO;
	private SearchZonePostCodeVO searchZonePostCodeVO;

	/**
	 * @return the searchLeaseListVO
	 */
	public SearchLeaseListVO getSearchLeaseListVO(){
		return searchLeaseListVO;
	}

	/**
	 * @param searchLeaseListVO the searchLeaseListVO to set
	 */
	public void setSearchLeaseListVO(SearchLeaseListVO searchLeaseListVO){
		this.searchLeaseListVO = searchLeaseListVO;
	}

	/**
	 * @return the searchNodeListVO
	 */
	public SearchNodeListVO getSearchNodeListVO(){
		return searchNodeListVO;
	}

	/**
	 * @param searchNodeListVO the searchNodeListVO to set
	 */
	public void setSearchNodeListVO(SearchNodeListVO searchNodeListVO){
		this.searchNodeListVO = searchNodeListVO;
	}

	/**
	 * @return the searchYardDetailVO
	 */
	public SearchYardDetailVO getSearchYardDetailVO(){
		return searchYardDetailVO;
	}

	/**
	 * @param searchYardDetailVO the searchYardDetailVO to set
	 */
	public void setSearchYardDetailVO(SearchYardDetailVO searchYardDetailVO){
		this.searchYardDetailVO = searchYardDetailVO;
	}

	/**
	 * @return the searchZoneDetailVO
	 */
	public SearchZoneDetailVO getSearchZoneDetailVO(){
		return searchZoneDetailVO;
	}

	/**
	 * @param searchZoneDetailVO the searchZoneDetailVO to set
	 */
	public void setSearchZoneDetailVO(SearchZoneDetailVO searchZoneDetailVO){
		this.searchZoneDetailVO = searchZoneDetailVO;
	}

	/**
	 * @return the searchZonePostCodeVO
	 */
	public SearchZonePostCodeVO getSearchZonePostCodeVO(){
		return searchZonePostCodeVO;
	}

	/**
	 * @param searchZonePostCodeVO the searchZonePostCodeVO to set
	 */
	public void setSearchZonePostCodeVO(SearchZonePostCodeVO searchZonePostCodeVO){
		this.searchZonePostCodeVO = searchZonePostCodeVO;
	}
}
