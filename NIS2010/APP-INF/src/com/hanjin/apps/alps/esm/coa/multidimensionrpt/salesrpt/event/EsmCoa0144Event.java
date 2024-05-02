/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0144Event.java
*@FileTitle : Shipper Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.08 송호진
* 1.0 Creation
===========================================================
' History :
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경 
' 2009.09.15 송호진 ALPS F/W 적용   
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;


/**
 * ESM_COA_0144 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0144HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0144HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0144Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ShipperVO shipperVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ShipperVO[] shipperVOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmCoa0144Event(){}
	
	public void setShipperVO(ShipperVO shipperVO){
		this. shipperVO = shipperVO;
	}

	public void setShipperVOS(ShipperVO[] shipperVOs){
		this. shipperVOs = shipperVOs;
	}

	public ShipperVO getShipperVO(){
		return shipperVO;
	}

	public ShipperVO[] getShipperVOS(){
		return shipperVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
}