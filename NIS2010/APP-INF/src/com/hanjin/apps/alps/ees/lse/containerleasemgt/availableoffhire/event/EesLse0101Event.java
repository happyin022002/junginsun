/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0101Event.java
*@FileTitle : Available Yard Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.13 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EES_LSE_0101HTMLAction;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0101HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0101Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;

	/** Table Value Object Multi Data 처리 */
	public AvailableOffHireYardCodeVO[] availableOffHireYardCodeVOs = null;

	/**
	 * Default Constructor.
	 */
	public EesLse0101Event(){}

	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setAvailableOffHireYardCodeVOs(AvailableOffHireYardCodeVO[] availableOffHireYardCodeVOs){
		this. availableOffHireYardCodeVOs = availableOffHireYardCodeVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public AvailableOffHireYardCodeVO[] getAvailableOffHireYardCodeVOs(){
		return availableOffHireYardCodeVOs;
	}
}
