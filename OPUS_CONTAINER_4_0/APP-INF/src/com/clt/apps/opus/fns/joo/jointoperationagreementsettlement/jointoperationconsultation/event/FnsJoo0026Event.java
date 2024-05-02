/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0026Event.java
*@FileTitle : AR Data ERP Interface Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.19 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.JooArMnVO;


/**
 * FNS_JOO_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0026HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooArMnVO jooArMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooArMnVO[] jooArMnVOs = null;
	
	/** ERP I/F Flag **/
	private String erpIfFlg = null;

	/** date Flag **/
	private String dtFlg = null;

	/** From Date **/
	private String issDtFr = null;

	/** To date **/
	private String issDtTo = null;
	
	public FnsJoo0026Event(){}
	
	public void setJooArMnVO(JooArMnVO jooArMnVO){
		this. jooArMnVO = jooArMnVO;
	}

	public void setJooArMnVOS(JooArMnVO[] jooArMnVOs){
		if (jooArMnVOs != null) {
			JooArMnVO[] tmpVOs = new JooArMnVO[jooArMnVOs.length];
			System.arraycopy(jooArMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooArMnVOs = tmpVOs;
		}
	}

	public JooArMnVO getJooArMnVO(){
		return jooArMnVO;
	}

	public JooArMnVO[] getJooArMnVOS(){
		JooArMnVO[] tmpVOs = null;
		if (this.jooArMnVOs != null) {
			tmpVOs = new JooArMnVO[jooArMnVOs.length];
			System.arraycopy(jooArMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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