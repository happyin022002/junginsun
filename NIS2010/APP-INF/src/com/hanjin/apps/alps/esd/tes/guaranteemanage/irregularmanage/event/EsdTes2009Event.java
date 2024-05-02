/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdTes2009Event.java
*@FileTitle : Irregular Report Designer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : Kim Yong Jin
*@LastVersion : 1.0
* 2011.03.31 Kim Yong Jin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularHdrVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularCntrListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TES_2009에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_2009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김용진
 * @see ESD_TES_2009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchIrregularCntrListVO searchIrregularCntrListVO = null; 
	private SearchIrregularHdrVO searchIrregularHdrVO = null; 
	
	public EsdTes2009Event(){}

	/**
	 * @return the searchIrregularHdrVO
	 */
	public SearchIrregularHdrVO getSearchIrregularHdrVO() {
		return searchIrregularHdrVO;
	}
	
	/**
	 * @return the searchIrregularCntrListVO
	 */
	public SearchIrregularCntrListVO getSearchIrregularCntrListVO() {
		return searchIrregularCntrListVO;
	}

	/**
	 * @param searchIrregularHdrVO the searchIrregularHdrVO to set
	 */
	public void setSearchIrregularHdrVO(SearchIrregularHdrVO searchIrregularHdrVO) {
		this.searchIrregularHdrVO = searchIrregularHdrVO;
	}
	
	/**
	 * @param searchIrregularCntrListVO the searchIrregularCntrListVO to set
	 */
	public void setSearchIrregularCntrListVO(SearchIrregularCntrListVO guaranteeCommonVO) {
		this.searchIrregularCntrListVO = guaranteeCommonVO;
	}


}