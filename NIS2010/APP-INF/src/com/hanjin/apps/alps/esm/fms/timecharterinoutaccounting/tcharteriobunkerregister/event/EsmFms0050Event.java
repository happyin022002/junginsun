/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0050Event.java
*@FileTitle : BunkerDataManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.FmsBunkerVO;


/**
 * ESM_FMS_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS_0050HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** FletCtrlNo 계약번호 */
	private String fletCtrtNo = "";
	
	/** CurrVslCd 현재 Row의 vslCd */
	private String currVslCd = "";
	
	/** CurrPortCd 현재 Row의 portCd */
	private String currPortCd = "";

	/** BnkYrmon Target Month */
	private String bnkYrmon = "";
	
	/** BnkDt */
	private String bunkerDt = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FmsBunkerVO fmsbunkervo = null;
	
	/** Table Value Object Multi Data 처리 */
	private FmsBunkerVO[] fmsbunkervos = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBunkerVO searchbunkervo = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBunkerVO[] searchbunkervos = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomBunkerVO custombunkervo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomBunkerVO[] custombunkervos = null;

	public EsmFms0050Event(){}
	
	public void setFmsBunkerVO(FmsBunkerVO fmsbunkervo){
		this.fmsbunkervo = fmsbunkervo;
	}

	public void setFmsBunkerVOS(FmsBunkerVO[] fmsbunkervos){
		if (fmsbunkervos != null) {
			FmsBunkerVO[] tmpVOs = new FmsBunkerVO[fmsbunkervos.length];
			System.arraycopy(fmsbunkervos, 0, tmpVOs, 0, tmpVOs.length);
			this.fmsbunkervos = tmpVOs;
		}
	}

	public void setSearchBunkerVO(SearchBunkerVO searchbunkervo){
		this.searchbunkervo = searchbunkervo;
	}

	public void setSearchBunkerVOS(SearchBunkerVO[] searchbunkervos){
		if (searchbunkervos != null) {
			SearchBunkerVO[] tmpVOs = new SearchBunkerVO[searchbunkervos.length];
			System.arraycopy(searchbunkervos, 0, tmpVOs, 0, tmpVOs.length);
			this.searchbunkervos = tmpVOs;
		}
	}
	
	public void setCustomBunkerVO(CustomBunkerVO custombunkervo){
		this.custombunkervo = custombunkervo;
	}

	public void setCustomBunkerVOS(CustomBunkerVO[] custombunkervos){
		if (custombunkervos != null) {
			CustomBunkerVO[] tmpVOs = new CustomBunkerVO[custombunkervos.length];
			System.arraycopy(custombunkervos, 0, tmpVOs, 0, tmpVOs.length);
			this.custombunkervos = tmpVOs;
		}
	}

	public FmsBunkerVO getFmsBunkerVO(){
		return fmsbunkervo;
	}

	public FmsBunkerVO[] getFmsBunkerVOS(){
		FmsBunkerVO[] rtnVOs = null;
		if (this.fmsbunkervos != null) {
			rtnVOs = new FmsBunkerVO[fmsbunkervos.length];
			System.arraycopy(fmsbunkervos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchBunkerVO getSearchBunkerVO(){
		return searchbunkervo;
	}

	public SearchBunkerVO[] getSearchBunkerVOS(){
		SearchBunkerVO[] rtnVOs = null;
		if (this.searchbunkervos != null) {
			rtnVOs = new SearchBunkerVO[searchbunkervos.length];
			System.arraycopy(searchbunkervos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public CustomBunkerVO getCustomBunkerVO(){
		return custombunkervo;
	}

	public CustomBunkerVO[] getCustomBunkerVOS(){
		CustomBunkerVO[] rtnVOs = null;
		if (this.custombunkervos != null) {
			rtnVOs = new CustomBunkerVO[custombunkervos.length];
			System.arraycopy(custombunkervos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getCurrVslCd() {
		return currVslCd;
	}

	public void setCurrVslCd(String currVslCd) {
		this.currVslCd = currVslCd;
	}
	
	public String getBnkYrmon() {
		return bnkYrmon;
	}

	public void setBnkYrmon(String bnkYrmon) {
		this.bnkYrmon = bnkYrmon;
	}
	
	public String getCurrPortCd() {
		return currPortCd;
	}

	public void setCurrPortCd(String currPortCd) {
		this.currPortCd = currPortCd;
	}
	
	public String getBunkerDt() {
		return bunkerDt;
	}

	public void setBunkerDt(String bunkerDt) {
		this.bunkerDt = bunkerDt;
	}

}