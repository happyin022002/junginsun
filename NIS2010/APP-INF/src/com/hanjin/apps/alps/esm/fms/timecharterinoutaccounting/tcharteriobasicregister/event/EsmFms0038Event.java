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
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;


/**
 * ESM_FMS_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRevenueVvdListVO searchRevenueVvdListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchRevenueVvdListVO[] searchRevenueVvdListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomVvdVO customVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomVvdVO[] customVvdVOs = null;
	
	/** revYrmon From Revenue Year/Month Code */
	private String revYrmonFrom = "";
	
	/** revYrmon To Revenue Year/Month Code */
	private String revYrmonTo = "";
	
	/** slanCd Service Lane Code */
	private String slanCd = "";
	
	/** rlaneCd Revenue Lane Code */
	private String rlaneCd = "";

	public EsmFms0038Event(){}
	
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

	public void setRevYrmonFrom(String revYrmonFrom) {
		this.revYrmonFrom = revYrmonFrom;
	}

	public void setRevYrmonTo(String revYrmonTo) {
		this.revYrmonTo = revYrmonTo;
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
		SearchRevenueVvdListVO[] rtnVOs = null;
		if (this.searchRevenueVvdListVOs != null) {
			rtnVOs = new SearchRevenueVvdListVO[searchRevenueVvdListVOs.length];
			System.arraycopy(searchRevenueVvdListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		
	}

	public CustomVvdVO getCustomVvdVO(){
		return customVvdVO;
	}

	public CustomVvdVO[] getCustomVvdVOS(){
		CustomVvdVO[] rtnVOs = null;
		if (this.customVvdVOs != null) {
			rtnVOs = new CustomVvdVO[customVvdVOs.length];
			System.arraycopy(customVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getRevYrmonFrom() {
		return revYrmonFrom;
	}
	
	public String getRevYrmonTo() {
		return revYrmonTo;
	}
	
	public String getSlanCd() {
		return slanCd;
	}
	
	public String getRlaneCd() {
		return rlaneCd;
	}

}