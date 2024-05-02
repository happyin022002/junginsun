/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0076Event.java
*@FileTitle : SearchAccountItemList
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.25 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;


/**
 * ESM_FMS_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS_0076HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** fletAcctCateCd */
	private String fletAcctCateCd = "";
	
	/** currCd */
	private String currCd = "";
	
	/** vslCd */
	private String vslCd = "";

	/** direction */
	private String direction = "";
	
	/** revYrmon */
	private String revYrmon = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccountItemListVO searchaccountitemlistvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccountItemListVO[] searchaccountitemlistvos = null;

	public EsmFms0076Event(){}
	
	public void setSearchAccountItemListVO(SearchAccountItemListVO searchaccountitemlistvo){
		this.searchaccountitemlistvo = searchaccountitemlistvo;
	}

	public void setSearchAccountItemListVOS(SearchAccountItemListVO[] searchaccountitemlistvos){
		if (searchaccountitemlistvos != null) {
			SearchAccountItemListVO[] tmpVOs = new SearchAccountItemListVO[searchaccountitemlistvos.length];
			System.arraycopy(searchaccountitemlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.searchaccountitemlistvos = tmpVOs;
		}
	}
		   
	public SearchAccountItemListVO getSearchAccountItemListVO(){
		return searchaccountitemlistvo;
	}

	public SearchAccountItemListVO[] getSearchAccountItemListVOS(){
		SearchAccountItemListVO[] rtnVOs = null;
		if (this.searchaccountitemlistvos != null) {
			rtnVOs = new SearchAccountItemListVO[searchaccountitemlistvos.length];
			System.arraycopy(searchaccountitemlistvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getFletAcctCateCd() {
		return fletAcctCateCd;
	}

	public void setFletAcctCateCd(String fletAcctCateCd) {
		this.fletAcctCateCd = fletAcctCateCd;
	}
	
	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getRevYrmon() {
		return revYrmon;
	}

	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}

}