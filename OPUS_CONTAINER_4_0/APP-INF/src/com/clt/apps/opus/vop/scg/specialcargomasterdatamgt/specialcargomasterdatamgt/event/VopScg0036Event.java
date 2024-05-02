/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0036Event.java
*@FileTitle : SPCL CGO Irregular Type (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.06 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VMS_SCG-0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0036HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchIrregularTypeCodeListVO[] searchIrregularTypeCodeListVOs = null;

	public VopScg0036Event(){}
	
	public void setSearchIrregularTypeCodeListVO(SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO){
		this. searchIrregularTypeCodeListVO = searchIrregularTypeCodeListVO;
	}

	public void setSearchIrregularTypeCodeListVOS(SearchIrregularTypeCodeListVO[] searchIrregularTypeCodeListVOs){
		if(searchIrregularTypeCodeListVOs != null){
			SearchIrregularTypeCodeListVO[] tmpVOs = Arrays.copyOf(searchIrregularTypeCodeListVOs, searchIrregularTypeCodeListVOs.length);
			this.searchIrregularTypeCodeListVOs = tmpVOs;
		}
	}

	public SearchIrregularTypeCodeListVO getSearchIrregularTypeCodeListVO(){
		return searchIrregularTypeCodeListVO;
	}

	public SearchIrregularTypeCodeListVO[] getSearchIrregularTypeCodeListVOS(){
		SearchIrregularTypeCodeListVO[] rtnVOs = null;
		if (this.searchIrregularTypeCodeListVOs != null) {
			rtnVOs = Arrays.copyOf(searchIrregularTypeCodeListVOs, searchIrregularTypeCodeListVOs.length);
		}
		return rtnVOs;
	}

}