/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1078Event.java
*@FileTitle : TAA Commodity Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2010.01.25 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_1078HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1078Event  extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TaaListInputVO taaListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TaaListInputVO[] taaListInputVOs = null;

	private String cmdtCd = null;
	private String cmdtNm = null;
	
	public EsmBkg1078Event(){}
	
	public void setTaaListInputVO(TaaListInputVO taaListInputVO){
		this. taaListInputVO = taaListInputVO;
	}

	public void setTaaListInputVOs(TaaListInputVO[] taaListInputVOs){
		this. taaListInputVOs = taaListInputVOs;
	}

	public TaaListInputVO getTaaListInputVO(){
		return taaListInputVO;
	}

	public TaaListInputVO[] getTaaListInputVOS(){
		return taaListInputVOs;
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
}
