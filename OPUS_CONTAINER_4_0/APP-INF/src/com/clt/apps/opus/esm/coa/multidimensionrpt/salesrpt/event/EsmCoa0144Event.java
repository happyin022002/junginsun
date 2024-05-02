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
' 2009.09.15 송호진 OPUS F/W 적용   
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

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
	
	//SJH.20150507.소스품질
	public void setShipperVOS(ShipperVO[] shipperVOs){
		if(shipperVOs != null){
			ShipperVO[] tmpVOs = Arrays.copyOf(shipperVOs, shipperVOs.length);
			this.shipperVOs = tmpVOs;
		}
	}

	public ShipperVO getShipperVO(){
		return shipperVO;
	}
	
	//SJH.20150507.소스품질
	public ShipperVO[] getShipperVOS(){
		ShipperVO[] rtnVOs = null;
		if (this.shipperVOs != null) {
			rtnVOs = Arrays.copyOf(shipperVOs, shipperVOs.length);
		}
		return rtnVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
}