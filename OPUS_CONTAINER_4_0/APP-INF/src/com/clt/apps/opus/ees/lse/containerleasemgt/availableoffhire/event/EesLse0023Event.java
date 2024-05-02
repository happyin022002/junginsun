/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0023Event.java
*@FileTitle : Target Off-Hire Location Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.08 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event;


import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EES_LSE_0023HTMLAction;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireRegisterVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji-yeon Jeon
 * @see EES_LSE_0023HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0023Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	private AvailableOffHireRegisterVO availableOffHireRegisterVO = null;

	/** Table Value Object Multi Data 처리 */
	private AvailableOffHireRegisterVO[] availableOffHireRegisterVOs = null;

	/**
	 * Default Constructor.
	 */
	public EesLse0023Event(){}

	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setAvailableOffHireRegisterVOs(AvailableOffHireRegisterVO[] availableOffHireRegisterVOs){
		if (availableOffHireRegisterVOs != null) {
			AvailableOffHireRegisterVO[] tmpVOs = new AvailableOffHireRegisterVO[availableOffHireRegisterVOs.length];
			System.arraycopy(availableOffHireRegisterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.availableOffHireRegisterVOs = tmpVOs;
		}
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public AvailableOffHireRegisterVO getAvailableOffHireRegisterVO() {
		return availableOffHireRegisterVO;
	}

	public void setAvailableOffHireRegisterVO(
			AvailableOffHireRegisterVO availableOffHireRegisterVO) {
		this.availableOffHireRegisterVO = availableOffHireRegisterVO;
	} 

	public AvailableOffHireRegisterVO[] getAvailableOffHireRegisterVOs(){
		AvailableOffHireRegisterVO[] tmpVOs = null;
		if (this.availableOffHireRegisterVOs != null) {
			tmpVOs = new AvailableOffHireRegisterVO[availableOffHireRegisterVOs.length];
			System.arraycopy(availableOffHireRegisterVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
