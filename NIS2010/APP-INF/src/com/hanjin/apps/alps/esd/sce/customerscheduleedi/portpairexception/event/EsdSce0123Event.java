/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdSce0123Event.java
*@FileTitle : 화주전송 Schedule 관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 함대성 
*@LastVersion : 1.0
* 2010.01.08 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.PartnerVO;
/**
 * ESD_SCE_123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see ESD_SCE_123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdjustmentVO adjustmentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AdjustmentVO[] adjustmentVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RouteForBLVO routeForBLVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RouteForBLVO[] routeForBLVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String          partnerName;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String          custTrdPrnrId;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PartnerVO comboVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PartnerVO[] comboVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private Edi323AdjustmentVO edi323AdjustmentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private Edi323AdjustmentVO[] edi323AdjustmentVOs = null;

	

	public EsdSce0123Event(){}
	
	/**
	 * @param String key
	 * @param Object value
	 */
	public void putValue(String key, Object value){
		if(key==null) return;
		this.setAttribute(key, value);
	}
	
	/**
	 * @param String key
	 * @return String
	 */
	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp==null) ? "" : (String)tmp;
	}

	/**
	 * @param String key
	 * @return Object
	 */
	public Object getObject(String key){
		return (key==null) ? null : this.getAttribute(key);
	}

	/**
	 * @return the adjustmentVO
	 */
	public AdjustmentVO getAdjustmentVO() {
		return adjustmentVO;
	}

	/**
	 * @param adjustmentVO the adjustmentVO to set
	 */
	public void setAdjustmentVO(AdjustmentVO adjustmentVO) {
		this.adjustmentVO = adjustmentVO;
	}

	/**
	 * @return the adjustmentVOs
	 */
	public AdjustmentVO[] getAdjustmentVOs() {
		return adjustmentVOs;
	}

	/**
	 * @param adjustmentVOs the adjustmentVOs to set
	 */
	public void setAdjustmentVOs(AdjustmentVO[] adjustmentVOs) {
		this.adjustmentVOs = adjustmentVOs;
	}

	/**
	 * @return the routeForBLVO
	 */
	public RouteForBLVO getRouteForBLVO() {
		return routeForBLVO;
	}

	/**
	 * @param routeForBLVO the routeForBLVO to set
	 */
	public void setRouteForBLVO(RouteForBLVO routeForBLVO) {
		this.routeForBLVO = routeForBLVO;
	}

	/**
	 * @return the routeForBLVOs
	 */
	public RouteForBLVO[] getRouteForBLVOs() {
		return routeForBLVOs;
	}

	/**
	 * @param routeForBLVOs the routeForBLVOs to set
	 */
	public void setRouteForBLVOs(RouteForBLVO[] routeForBLVOs) {
		this.routeForBLVOs = routeForBLVOs;
	}

	/**
	 * @return the partnerName
	 */
	public String getPartnerName() {
		return partnerName;
	}

	/**
	 * @param partnerName the partnerName to set
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	/**
	 * @return the custTrdPrnrId
	 */
	public String getcustTrdPrnrId() {
		return custTrdPrnrId;
	}

	/**
	 * @param custTrdPrnrId the custTrdPrnrId to set
	 */
	public void setcustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}

	/**
	 * @return the PartnerVO
	 */
	public PartnerVO getComboVO() {
		return comboVO;
	}

	/**
	 * @param PartnerVO the PartnerVO to set
	 */
	public void setComboVO(PartnerVO comboVO) {
		this.comboVO = comboVO;
	}

	/**
	 * @return the PartnerVO[]
	 */
	public PartnerVO[] getComboVOs() {
		return comboVOs;
	}

	/**
	 * @param PartnerVO[] the PartnerVO[] to set
	 */
	public void setComboVOs(PartnerVO[] comboVOs) {
		this.comboVOs = comboVOs;
	}

	/**
	 * @return the Edi323AdjustmentVO
	 */
	public Edi323AdjustmentVO getEdi323AdjustmentVO() {
		return edi323AdjustmentVO;
	}

	/**
	 * @param edi323AdjustmentVO the edi323AdjustmentVO to set
	 */
	public void setEdi323AdjustmentVO(Edi323AdjustmentVO edi323AdjustmentVO) {
		this.edi323AdjustmentVO = edi323AdjustmentVO;
	}

	/**
	 * @return the edi323AdjustmentVOs
	 */
	public Edi323AdjustmentVO[] getEdi323AdjustmentVOs() {
		return edi323AdjustmentVOs;
	}

	/**
	 * @param edi323AdjustmentVOs the edi323AdjustmentVOs to set
	 */
	public void setEdi323AdjustmentVOs(Edi323AdjustmentVO[] edi323AdjustmentVOs) {
		this.edi323AdjustmentVOs = edi323AdjustmentVOs;
	}

	
	
	
}