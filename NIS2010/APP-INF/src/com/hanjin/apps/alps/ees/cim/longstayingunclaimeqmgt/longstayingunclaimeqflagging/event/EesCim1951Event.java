/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1951Event.java
*@FileTitle : OP Inventory for Pseudo Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.01
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2009.07.09 이영두
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO ;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;


/**
 * EES_CIM_1951 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1951HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Young Du
 * @see EES_CIM_1951HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1951Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO  = null;
	
	/** Table Value Object Multi Data 처리 */
	private OPInventoryForPseudoBookingOptionVO [] oPInventoryForPseudoBookingOptionVOs = null;

	public EesCim1951Event(){}
	
	public void setOPInventoryForPseudoBookingOptionVO (OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ){
		this. oPInventoryForPseudoBookingOptionVO  = oPInventoryForPseudoBookingOptionVO ;
	}

	public void setOPInventoryForPseudoBookingOptionVOS(OPInventoryForPseudoBookingOptionVO [] oPInventoryForPseudoBookingOptionVOs){
		if (oPInventoryForPseudoBookingOptionVOs != null) {
			OPInventoryForPseudoBookingOptionVO[] tmpVOs = Arrays.copyOf(oPInventoryForPseudoBookingOptionVOs, oPInventoryForPseudoBookingOptionVOs.length);
			this.oPInventoryForPseudoBookingOptionVOs = tmpVOs;
		}
	}

	public OPInventoryForPseudoBookingOptionVO  getOPInventoryForPseudoBookingOptionVO (){
		return oPInventoryForPseudoBookingOptionVO ;
	}

	public OPInventoryForPseudoBookingOptionVO [] getOPInventoryForPseudoBookingOptionVOS(){
		OPInventoryForPseudoBookingOptionVO[] rtnVOs = null;
		if (this.oPInventoryForPseudoBookingOptionVOs != null) {
			rtnVOs = Arrays.copyOf(oPInventoryForPseudoBookingOptionVOs, oPInventoryForPseudoBookingOptionVOs.length);
		}
		return rtnVOs;
	}

}