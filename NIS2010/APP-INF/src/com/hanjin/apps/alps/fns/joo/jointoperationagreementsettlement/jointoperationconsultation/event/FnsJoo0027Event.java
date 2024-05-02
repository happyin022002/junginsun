/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0027Event.java
*@FileTitle : AP Data ERP Interface Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.19 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ErpIfVO;


/**
 * FNS_JOO_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0027HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ErpIfVO erpIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ErpIfVO[] erpIfVOs = null;

	/** ERP I/F Flag **/
	private String erpIfFlg = null;

	/** date Flag **/
	private String dtFlg = null;

	/** From Date **/
	private String issDtFr = null;

	/** To date **/
	private String issDtTo = null;
	
	public FnsJoo0027Event(){}
	
	public void setErpIfVO(ErpIfVO erpIfVO){
		this. erpIfVO = erpIfVO;
	}

	public void setErpIfVOS(ErpIfVO[] erpIfVOs){
		if (erpIfVOs != null) {
			ErpIfVO[] tmpVOs = new ErpIfVO[erpIfVOs.length];
			System.arraycopy(erpIfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.erpIfVOs = tmpVOs;
		}		
	}

	public ErpIfVO getErpIfVO(){
		return erpIfVO;
	}

	public ErpIfVO[] getErpIfVOS(){
		ErpIfVO[] rtnVOs = null;
		if (this.erpIfVOs != null) {
			rtnVOs = new ErpIfVO[erpIfVOs.length];
			System.arraycopy(erpIfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}


	public String getErpIfFlg() {
		return erpIfFlg;
	}

	public void setErpIfFlg(String erpIfFlg) {
		this.erpIfFlg = erpIfFlg;
	}

	public String getDtFlg() {
		return dtFlg;
	}

	public void setDtFlg(String dtFlg) {
		this.dtFlg = dtFlg;
	}

	public String getIssDtFr() {
		return issDtFr;
	}

	public void setIssDtFr(String issDtFr) {
		this.issDtFr = issDtFr;
	}

	public String getIssDtTo() {
		return issDtTo;
	}

	public void setIssDtTo(String issDtTo) {
		this.issDtTo = issDtTo;
	}
}