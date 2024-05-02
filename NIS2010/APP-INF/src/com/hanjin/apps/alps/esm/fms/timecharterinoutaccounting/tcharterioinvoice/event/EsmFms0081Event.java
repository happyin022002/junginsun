/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0081Event.java
*@FileTitle : Manhour Item Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.08 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemListVO;


/**
 * ESM_FMS_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0081HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchManhourItemListVO searchManhourItemListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchManhourItemListVO[] searchManhourItemListVOs = null;

	public EsmFms0081Event(){}
	
	public void setSearchManhourItemListVO(SearchManhourItemListVO searchManhourItemListVO){
		this. searchManhourItemListVO = searchManhourItemListVO;
	}

	public void setSearchManhourItemListVOS(SearchManhourItemListVO[] searchManhourItemListVOs){
		if (searchManhourItemListVOs != null) {
			SearchManhourItemListVO[] tmpVOs = Arrays.copyOf(searchManhourItemListVOs, searchManhourItemListVOs.length);
			this.searchManhourItemListVOs = tmpVOs;
		}
	}

	public SearchManhourItemListVO getSearchManhourItemListVO(){
		return searchManhourItemListVO;
	}

	public SearchManhourItemListVO[] getSearchManhourItemListVOS(){
		SearchManhourItemListVO[] rtnVOs = null;
		if (this.searchManhourItemListVOs != null) {
			rtnVOs = Arrays.copyOf(searchManhourItemListVOs, searchManhourItemListVOs.length);
		}
		return rtnVOs;
	}

}