/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0066Event.java
*@FileTitle : Slot Price 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.15 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PortExpenseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * VOP_VSK_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0066HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */  
	private PortExpenseVO portExpenseVO = null;
	private SlotPriceVO slotPriceVO = null;
	private SlotPriceGRPVO slotPriceGRPVO = null;
	private YardVO yardVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortExpenseVO[] portExpenseVOs = null;
	private SlotPriceVO[] slotPriceVOs = null;
	private YardVO[] yardVOs = null;

	public VopVsk0066Event(){}
	
	public void setPortExpenseVO(PortExpenseVO portExpenseVO){
		this. portExpenseVO = portExpenseVO;
	}
	
	public void setSlotPriceVO(SlotPriceVO slotPriceVO){
		this. slotPriceVO = slotPriceVO;
	}
	
	public void setSlotPriceGRPVO(SlotPriceGRPVO slotPriceGRPVO){
		this.slotPriceGRPVO = slotPriceGRPVO;
	}

	public void setSlotPriceVOS(SlotPriceVO[] slotPriceVOs){
		if(slotPriceVOs != null){
			SlotPriceVO[] tmpVOs = new SlotPriceVO[slotPriceVOs.length];
			System.arraycopy(slotPriceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.slotPriceVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. slotPriceVOs = slotPriceVOs;
	}
	
	public void setYardVO(YardVO yardVO){
		this.yardVO = yardVO;
	}
	
	public void setYardVOS(YardVO[] yardVOs){
		if(yardVOs != null){
			YardVO[] tmpVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.yardVOs = yardVOs;
	}
	
	public void setPortExpenseVOS(PortExpenseVO[] portExpenseVOs){
		if(portExpenseVOs != null){
			PortExpenseVO[] tmpVOs = new PortExpenseVO[portExpenseVOs.length];
			System.arraycopy(portExpenseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portExpenseVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. portExpenseVOs = portExpenseVOs;
	}

	public PortExpenseVO getPortExpenseVO(){
		return portExpenseVO;
	}
	
	public SlotPriceVO getSlotPriceVO(){
		return slotPriceVO;
	}
	
	public SlotPriceGRPVO getSlotPriceGRPVO(){
		return slotPriceGRPVO;
	}
	
	public YardVO getYardVO(){
		return yardVO;
	}

	public PortExpenseVO[] getPortExpenseVOS(){
		PortExpenseVO[] rtnVOs =  null;
		if(this.portExpenseVOs != null){
			rtnVOs = new PortExpenseVO[portExpenseVOs.length];
			System.arraycopy(portExpenseVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return portExpenseVOs;
	}
	
	public SlotPriceVO[] getSlotPriceVOS(){
		SlotPriceVO[] rtnVOs =  null;
		if(this.slotPriceVOs != null){
			rtnVOs = new SlotPriceVO[slotPriceVOs.length];
			System.arraycopy(slotPriceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return slotPriceVOs;
	}
	
	public YardVO[] getYardVOS(){
		YardVO[] rtnVOs =  null;
		if(this.yardVOs != null){
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return yardVOs;
	}

}