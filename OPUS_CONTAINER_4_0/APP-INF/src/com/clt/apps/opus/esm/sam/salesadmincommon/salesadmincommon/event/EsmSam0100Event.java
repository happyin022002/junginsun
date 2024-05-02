/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0100Event.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SamActTpMstVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SamSlsActTpDtlVO;

/**
 * ESM_SAM_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActItemMstVO searchActItemMstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchActItemMstVO[] searchActItemMstVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamActTpMstVO samActTpMstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamActTpMstVO[] samActTpMstVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamSlsActTpDtlVO samSlsActTpDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamSlsActTpDtlVO[] samSlsActTpDtlVOs = null;

	public EsmSam0100Event(){}
	
	public void setSearchActItemMstVO(SearchActItemMstVO searchActItemMstVO){
		this. searchActItemMstVO = searchActItemMstVO;
	}

	public void setSearchActItemMstVOS(SearchActItemMstVO[] searchActItemMstVOs){
		if(searchActItemMstVOs != null){
			SearchActItemMstVO[] tmpVOs = Arrays.copyOf(searchActItemMstVOs, searchActItemMstVOs.length);
			this.searchActItemMstVOs = tmpVOs;
		}
	}
	
	public void setSamSlsActTpDtlVO (SamSlsActTpDtlVO samSlsActTpDtlVO ){
		this. samSlsActTpDtlVO  = samSlsActTpDtlVO ;
	}

	public void setSamSlsActTpDtlVOS(SamSlsActTpDtlVO[] samSlsActTpDtlVOs){
		if(samSlsActTpDtlVOs != null){
			SamSlsActTpDtlVO[] tmpVOs = Arrays.copyOf(samSlsActTpDtlVOs, samSlsActTpDtlVOs.length);
			this.samSlsActTpDtlVOs = tmpVOs;
		}
	}
	
	public void setSamActTpMstVO(SamActTpMstVO samActTpMstVO){
		this. samActTpMstVO = samActTpMstVO;
	}

	public void setSamActTpMstVOS(SamActTpMstVO[] samActTpMstVOs){
		if(samActTpMstVOs != null){
			SamActTpMstVO[] tmpVOs = Arrays.copyOf(samActTpMstVOs, samActTpMstVOs.length);
			this.samActTpMstVOs = tmpVOs;
		}
	}

	public SearchActItemMstVO getSearchActItemMstVO(){
		return searchActItemMstVO;
	}

	public SearchActItemMstVO[] getSearchActItemMstVOS(){
		SearchActItemMstVO[] rtnVOs = null;
		if (this.searchActItemMstVOs != null) {
			rtnVOs = Arrays.copyOf(searchActItemMstVOs, searchActItemMstVOs.length);
		}
		return rtnVOs;
	}

	public SamActTpMstVO getSamActTpMstVO(){
		return samActTpMstVO;
	}

	public SamActTpMstVO[] getSamActTpMstVOS(){
		SamActTpMstVO[] rtnVOs = null;
		if (this.samActTpMstVOs != null) {
			rtnVOs = Arrays.copyOf(samActTpMstVOs, samActTpMstVOs.length);
		}
		return rtnVOs;
	}
	
	public SamSlsActTpDtlVO getSamSlsActTpDtlVO(){
		return samSlsActTpDtlVO ;
	}

	public SamSlsActTpDtlVO[] getSamSlsActTpDtlVOS(){
		SamSlsActTpDtlVO[] rtnVOs = null;
		if (this.samSlsActTpDtlVOs != null) {
			rtnVOs = Arrays.copyOf(samSlsActTpDtlVOs, samSlsActTpDtlVOs.length);
		}
		return rtnVOs;
	}

}