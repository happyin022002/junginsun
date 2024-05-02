/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0062Event.java
*@FileTitle : TP/SZ Volume Calculation Terms
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvLaneListVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvLaneVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvListVO;


/**
 * ESM_SPC_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0062HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerSpaceGuaranteeConvLaneListVO[] searchCustomerSpaceGuaranteeConvLaneListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqCntrSzConvVO saqCntrSzConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqCntrSzConvVO[] saqCntrSzConvVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqCntrSzConvLaneVO saqCntrSzConvLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqCntrSzConvLaneVO[] saqCntrSzConvLaneVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerSpaceGuaranteeConvListVO[] searchCustomerSpaceGuaranteeConvListVOs = null;

	public EsmSpc0062Event(){}
	
	public void setSearchCustomerSpaceGuaranteeConvLaneListVO(SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO){
		this. searchCustomerSpaceGuaranteeConvLaneListVO = searchCustomerSpaceGuaranteeConvLaneListVO;
	}

	public void setSearchCustomerSpaceGuaranteeConvLaneListVOS(SearchCustomerSpaceGuaranteeConvLaneListVO[] searchCustomerSpaceGuaranteeConvLaneListVOs){
		this. searchCustomerSpaceGuaranteeConvLaneListVOs = searchCustomerSpaceGuaranteeConvLaneListVOs;
	}

	public void setSaqCntrSzConvVO(SaqCntrSzConvVO saqCntrSzConvVO){
		this. saqCntrSzConvVO = saqCntrSzConvVO;
	}

	public void setSaqCntrSzConvVOS(SaqCntrSzConvVO[] saqCntrSzConvVOs){
		this. saqCntrSzConvVOs = saqCntrSzConvVOs;
	}

	public void setSaqCntrSzConvLaneVO(SaqCntrSzConvLaneVO saqCntrSzConvLaneVO){
		this. saqCntrSzConvLaneVO = saqCntrSzConvLaneVO;
	}

	public void setSaqCntrSzConvLaneVOS(SaqCntrSzConvLaneVO[] saqCntrSzConvLaneVOs){
		this. saqCntrSzConvLaneVOs = saqCntrSzConvLaneVOs;
	}

	public void setSearchCustomerSpaceGuaranteeConvListVO(SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO){
		this. searchCustomerSpaceGuaranteeConvListVO = searchCustomerSpaceGuaranteeConvListVO;
	}

	public void setSearchCustomerSpaceGuaranteeConvListVOS(SearchCustomerSpaceGuaranteeConvListVO[] searchCustomerSpaceGuaranteeConvListVOs){
		this. searchCustomerSpaceGuaranteeConvListVOs = searchCustomerSpaceGuaranteeConvListVOs;
	}

	public SearchCustomerSpaceGuaranteeConvLaneListVO getSearchCustomerSpaceGuaranteeConvLaneListVO(){
		return searchCustomerSpaceGuaranteeConvLaneListVO;
	}

	public SearchCustomerSpaceGuaranteeConvLaneListVO[] getSearchCustomerSpaceGuaranteeConvLaneListVOS(){
		return searchCustomerSpaceGuaranteeConvLaneListVOs;
	}

	public SaqCntrSzConvVO getSaqCntrSzConvVO(){
		return saqCntrSzConvVO;
	}

	public SaqCntrSzConvVO[] getSaqCntrSzConvVOS(){
		return saqCntrSzConvVOs;
	}

	public SaqCntrSzConvLaneVO getSaqCntrSzConvLaneVO(){
		return saqCntrSzConvLaneVO;
	}

	public SaqCntrSzConvLaneVO[] getSaqCntrSzConvLaneVOS(){
		return saqCntrSzConvLaneVOs;
	}

	public SearchCustomerSpaceGuaranteeConvListVO getSearchCustomerSpaceGuaranteeConvListVO(){
		return searchCustomerSpaceGuaranteeConvListVO;
	}

	public SearchCustomerSpaceGuaranteeConvListVO[] getSearchCustomerSpaceGuaranteeConvListVOS(){
		return searchCustomerSpaceGuaranteeConvListVOs;
	}

}