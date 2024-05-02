/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0068Event.java
*@FileTitle : Revenue Port Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.15 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomBsePortVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  Choi Woo-Seok
 * @see ESM_FMS_0068HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String slanCd = "";
	
	private String rLaneCd = "";
	
	private String searchType = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomBsePortVO customBsePortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomBsePortVO[] customBsePortVOs = null;

	public EsmFms0068Event(){}
	
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	public String getSlanCd() {
		return slanCd;
	}
	
	public void setRLaneCd(String rLaneCd) {
		this.rLaneCd = rLaneCd;
	}
	
	public String getRLaneCd() {
		return rLaneCd;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getSearchType() {
		return searchType;
	}

	public void setCustomBsePortVO(CustomBsePortVO customBsePortVO){
		this. customBsePortVO = customBsePortVO;
	}
	
	public CustomBsePortVO getCustomBsePortVO(){
		return customBsePortVO;
	}
	
	public void setCustomBsePortVOS(CustomBsePortVO[] customBsePortVOs){
		if (customBsePortVOs != null) {
			CustomBsePortVO[] tmpVOs = new CustomBsePortVO[customBsePortVOs.length];
			System.arraycopy(customBsePortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customBsePortVOs = tmpVOs;
		}
	}

	public CustomBsePortVO[] getCustomBsePortVOS(){
		CustomBsePortVO[] tmpVOs = null;
		if (this.customBsePortVOs != null) {
			tmpVOs = new CustomBsePortVO[customBsePortVOs.length];
			System.arraycopy(customBsePortVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}