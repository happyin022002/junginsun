/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0037Event.java
*@FileTitle : Revenue VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.01 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRevenueVvdListVO searchRevenueVvdListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchRevenueVvdListVO[] searchRevenueVvdListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomVvdVO customVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomVvdVO[] customVvdVOs = null;
	
	/** revYrmon Revenue Year/Month Code */
	private String revYrmon = "";
	
	/** slanCd Service Lane Code */
	private String slanCd = "";
	
	/** rlaneCd Revenue Lane Code */
	private String rlaneCd = "";

	public EsmFms0037Event(){}
	
	public void setSearchRevenueVvdListVO(SearchRevenueVvdListVO searchRevenueVvdListVO){
		this. searchRevenueVvdListVO = searchRevenueVvdListVO;
	}

	public void setSearchRevenueVvdListVOS(SearchRevenueVvdListVO[] searchRevenueVvdListVOs){
		if (searchRevenueVvdListVOs != null) {
			SearchRevenueVvdListVO[] tmpVOs = new SearchRevenueVvdListVO[searchRevenueVvdListVOs.length];
			System.arraycopy(searchRevenueVvdListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchRevenueVvdListVOs = tmpVOs;
		}
	}

	public void setCustomVvdVO(CustomVvdVO customVvdVO){
		this. customVvdVO = customVvdVO;
	}

	public void setCustomVvdVOS(CustomVvdVO[] customVvdVOs){
		if (customVvdVOs != null) {
			CustomVvdVO[] tmpVOs = new CustomVvdVO[customVvdVOs.length];
			System.arraycopy(customVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customVvdVOs = tmpVOs;
		}
	}

	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}

	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}

	public SearchRevenueVvdListVO getSearchRevenueVvdListVO(){
		return searchRevenueVvdListVO;
	}

	public SearchRevenueVvdListVO[] getSearchRevenueVvdListVOS(){
		SearchRevenueVvdListVO[] tmpVOs = null;
		if (this.searchRevenueVvdListVOs != null) {
			tmpVOs = new SearchRevenueVvdListVO[searchRevenueVvdListVOs.length];
			System.arraycopy(searchRevenueVvdListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CustomVvdVO getCustomVvdVO(){
		return customVvdVO;
	}

	public CustomVvdVO[] getCustomVvdVOS(){
		CustomVvdVO[] tmpVOs = null;
		if (this.customVvdVOs != null) {
			tmpVOs = new CustomVvdVO[customVvdVOs.length];
			System.arraycopy(customVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getRevYrmon() {
		return revYrmon;
	}
	
	public String getSlanCd() {
		return slanCd;
	}
	
	public String getRlaneCd() {
		return rlaneCd;
	}

}