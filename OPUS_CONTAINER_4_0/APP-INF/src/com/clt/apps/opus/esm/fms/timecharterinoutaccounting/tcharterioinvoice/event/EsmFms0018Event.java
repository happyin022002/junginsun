/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0018Event.java
*@FileTitle : Owner’s Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.28 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0018HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchOwnerInvoiceVO[] condSearchOwnerInvoiceVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomOwnrAcctSlpVO customOwnrAcctSlpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchOwnerInvoiceAutoMatchVO[] condSearchOwnerInvoiceAutoMatchVOs = null;
	
	/** 검색구분 **/
	private String searchType = null;
	
	public EsmFms0018Event(){}
	
	public void setCondSearchOwnerInvoiceVO(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO){
		this. condSearchOwnerInvoiceVO = condSearchOwnerInvoiceVO;
	}

	public void setCondSearchOwnerInvoiceVOS(CondSearchOwnerInvoiceVO[] condSearchOwnerInvoiceVOs){
		if (condSearchOwnerInvoiceVOs != null) {
			CondSearchOwnerInvoiceVO[] tmpVOs = new CondSearchOwnerInvoiceVO[condSearchOwnerInvoiceVOs.length];
			System.arraycopy(condSearchOwnerInvoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condSearchOwnerInvoiceVOs = tmpVOs;
		}
	}

	public CondSearchOwnerInvoiceVO getCondSearchOwnerInvoiceVO(){
		return condSearchOwnerInvoiceVO;
	}

	public CondSearchOwnerInvoiceVO[] getCondSearchOwnerInvoiceVOS(){
		CondSearchOwnerInvoiceVO[] tmpVOs = null;
		if (this.condSearchOwnerInvoiceVOs != null) {
			tmpVOs = new CondSearchOwnerInvoiceVO[condSearchOwnerInvoiceVOs.length];
			System.arraycopy(condSearchOwnerInvoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCustomOwnrAcctSlpVO(CustomOwnrAcctSlpVO customOwnrAcctSlpVO){
		this. customOwnrAcctSlpVO = customOwnrAcctSlpVO;
	}

	public void setCustomOwnrAcctSlpVOS(CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs){
		if (customOwnrAcctSlpVOs != null) {
			CustomOwnrAcctSlpVO[] tmpVOs = new CustomOwnrAcctSlpVO[customOwnrAcctSlpVOs.length];
			System.arraycopy(customOwnrAcctSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customOwnrAcctSlpVOs = tmpVOs;
		}
	}

	public CustomOwnrAcctSlpVO getCustomOwnrAcctSlpVO(){
		return customOwnrAcctSlpVO;
	}

	public CustomOwnrAcctSlpVO[] getCustomOwnrAcctSlpVOS(){
		CustomOwnrAcctSlpVO[] tmpVOs = null;
		if (this.customOwnrAcctSlpVOs != null) {
			tmpVOs = new CustomOwnrAcctSlpVO[customOwnrAcctSlpVOs.length];
			System.arraycopy(customOwnrAcctSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCondSearchOwnerInvoiceAutoMatchVO(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO){
		this. condSearchOwnerInvoiceAutoMatchVO = condSearchOwnerInvoiceAutoMatchVO;
	}

	public void setCondSearchOwnerInvoiceAutoMatchVOS(CondSearchOwnerInvoiceAutoMatchVO[] condSearchOwnerInvoiceAutoMatchVOs){
		if (condSearchOwnerInvoiceAutoMatchVOs != null) {
			CondSearchOwnerInvoiceAutoMatchVO[] tmpVOs = new CondSearchOwnerInvoiceAutoMatchVO[condSearchOwnerInvoiceAutoMatchVOs.length];
			System.arraycopy(condSearchOwnerInvoiceAutoMatchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condSearchOwnerInvoiceAutoMatchVOs = tmpVOs;
		}
	}

	public CondSearchOwnerInvoiceAutoMatchVO getCondSearchOwnerInvoiceAutoMatchVO(){
		return condSearchOwnerInvoiceAutoMatchVO;
	}

	public CondSearchOwnerInvoiceAutoMatchVO[] getCondSearchOwnerInvoiceAutoMatchVOS(){
		CondSearchOwnerInvoiceAutoMatchVO[] tmpVOs = null;
		if (this.condSearchOwnerInvoiceAutoMatchVOs != null) {
			tmpVOs = new CondSearchOwnerInvoiceAutoMatchVO[condSearchOwnerInvoiceAutoMatchVOs.length];
			System.arraycopy(condSearchOwnerInvoiceAutoMatchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getSearchType(){
		return searchType;
	}
	
	public void setSearchType(String searchType){
		this. searchType = searchType;
	}
}