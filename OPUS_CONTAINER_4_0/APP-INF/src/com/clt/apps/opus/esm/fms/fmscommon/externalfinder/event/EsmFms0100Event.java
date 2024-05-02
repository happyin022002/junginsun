/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0100Event.java
*@FileTitle : Other Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event;


import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.OtherCodeListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_FMS_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0100에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_FMS_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OtherCodeListVO otherCodeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OtherCodeListVO[] otherCodeListVOs = null;
	
	private String codeTp = "";
	
	public EsmFms0100Event(){}
	
	
	public OtherCodeListVO getOtherCodeListVO(){
		return otherCodeListVO;
	}
	
	public void setOtherCodeListVO(OtherCodeListVO otherCodeListVO){
		this. otherCodeListVO = otherCodeListVO;
	}

	public OtherCodeListVO[] getOtherCodeListVOS(){
		OtherCodeListVO[] tmpVOs = null;
		if (this.otherCodeListVOs != null) {
			tmpVOs = new OtherCodeListVO[otherCodeListVOs.length];
			System.arraycopy(otherCodeListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setOtherCodeListVOS(OtherCodeListVO[] otherCodeListVOs){
		if (otherCodeListVOs != null) {
			OtherCodeListVO[] tmpVOs = new OtherCodeListVO[otherCodeListVOs.length];
			System.arraycopy(otherCodeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.otherCodeListVOs = tmpVOs;
		}
	}

	public void setCodeTp(String codeTp) {
		this.codeTp = codeTp;
	}

	public String getCodeTp() {
		return codeTp;
	}

	
}