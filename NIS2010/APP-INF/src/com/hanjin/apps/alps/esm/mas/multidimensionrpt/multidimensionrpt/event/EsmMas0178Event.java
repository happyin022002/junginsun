/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmMas0178Event.java
*@FileTitle : IAS 협의체별 Scop 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.08.20 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchIasSubCdListVO;


/**
 * ESM_MAS_0178 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0178HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_MAS_0178HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0178Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchIasSubCdListVO searchIasSubCdListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchIasSubCdListVO[] searchIasSubCdListVOs = null;

	public EsmMas0178Event(){}
	
	public void setSearchIasSubCdListVO(SearchIasSubCdListVO searchIasSubCdListVO){
		this. searchIasSubCdListVO = searchIasSubCdListVO;
	}

	public void setSearchIasSubCdListVOS(SearchIasSubCdListVO[] searchIasSubCdListVOs){
		this. searchIasSubCdListVOs = searchIasSubCdListVOs;
	}

	public SearchIasSubCdListVO getSearchIasSubCdListVO(){
		return searchIasSubCdListVO;
	}

	public SearchIasSubCdListVO[] getSearchIasSubCdListVOS(){
		return searchIasSubCdListVOs;
	}

}