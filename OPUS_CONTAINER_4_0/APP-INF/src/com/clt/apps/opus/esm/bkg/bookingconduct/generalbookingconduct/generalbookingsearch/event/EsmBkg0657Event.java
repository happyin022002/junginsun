/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0657Event.java
*@FileTitle : SC Commodity PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.23 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0657 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0657HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0657HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0657Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScListInputVO scListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScListInputVO[] scListInputVOs = null;

	private String cmdtCd = null;
	private String cmdtNm = null;	
	private String svcScpCd = null;
	private String uiId = null;
	
	public EsmBkg0657Event(){}
	
	public void setScListInputVO(ScListInputVO scListInputVO){
		this. scListInputVO = scListInputVO;
	}

	public void setScListInputVOs(ScListInputVO[] scListInputVOs){
		if (scListInputVOs != null) {
			ScListInputVO[] tmpVOs = Arrays.copyOf(scListInputVOs, scListInputVOs .length);
			this. scListInputVOs = tmpVOs;
		}
	}

	public ScListInputVO getScListInputVO(){
		return scListInputVO;
	}

	public ScListInputVO[] getScListInputVOs(){
		ScListInputVO[] tmpVOs = null;
		if (this. scListInputVOs != null) {
			tmpVOs = Arrays.copyOf(scListInputVOs, scListInputVOs .length);
		}
		return tmpVOs;
	}

	public void setCmdtCd(String cmdtCd){
		this.cmdtCd = cmdtCd;
	}
	
	public String getCmdtCd(){
		return cmdtCd;
	}
	
	public void setCmdtNm(String cmdtNm){
		this.cmdtNm = cmdtNm;
	}
	
	public String getCmdtNm(){
		return cmdtNm;
	}	
	
	public void setSvcScpCd(String svcScpCd){
		this.svcScpCd = svcScpCd;
	}
	
	public String getSvcScpCd(){
		return svcScpCd;
	}	
	
	public String getUiId() {
		return uiId;
	}

	public void setUiId(String uiId) {
		this.uiId = uiId;
	}	
}