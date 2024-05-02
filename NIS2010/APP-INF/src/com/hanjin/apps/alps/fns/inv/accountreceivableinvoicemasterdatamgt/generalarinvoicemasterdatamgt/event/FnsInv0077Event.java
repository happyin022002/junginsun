/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0077Event.java
*@FileTitle : Revenue Lane Inquiry by Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderInPutVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmRevLaneVO;


/**
 * FNS_INV_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0077HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LaneOrderInPutVO laneOrderInPutVO = null;
	private MdmRevLaneVO mdmRevLaneVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private LaneOrderInPutVO[] laneOrderInPutVOs = null;
	private MdmRevLaneVO[] mdmRevLaneVOs = null;

	public FnsInv0077Event(){}
	
	public void setLaneOrderInPutVO(LaneOrderInPutVO laneOrderInPutVO){
		this. laneOrderInPutVO = laneOrderInPutVO;
	}

	public void setLaneOrderInPutVOS(LaneOrderInPutVO[] laneOrderInPutVOs){
		this. laneOrderInPutVOs = laneOrderInPutVOs;
	}

	public LaneOrderInPutVO getLaneOrderInPutVO(){
		return laneOrderInPutVO;
	}

	public LaneOrderInPutVO[] getLaneOrderInPutVOS(){
		return laneOrderInPutVOs;
	}

	/**
	 * @return the mdmRevLaneVO
	 */
	public MdmRevLaneVO getMdmRevLaneVO() {
		return mdmRevLaneVO;
	}

	/**
	 * @param mdmRevLaneVO the mdmRevLaneVO to set
	 */
	public void setMdmRevLaneVO(MdmRevLaneVO mdmRevLaneVO) {
		this.mdmRevLaneVO = mdmRevLaneVO;
	}

	/**
	 * @return the mdmRevLaneVOs
	 */
	public MdmRevLaneVO[] getMdmRevLaneVOs() {
		return mdmRevLaneVOs;
	}

	/**
	 * @param mdmRevLaneVOs the mdmRevLaneVOs to set
	 */
	public void setMdmRevLaneVOs(MdmRevLaneVO[] mdmRevLaneVOs) {
		this.mdmRevLaneVOs = mdmRevLaneVOs;
	}

	
	
	
}