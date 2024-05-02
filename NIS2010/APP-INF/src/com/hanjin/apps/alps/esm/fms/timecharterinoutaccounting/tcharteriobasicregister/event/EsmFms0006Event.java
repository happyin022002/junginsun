/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0006Event.java
*@FileTitle : Owner list
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.14
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.14 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;


/**
 * ESM_FMS_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0006HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Com Code Id */
	private String comCdId = "";
	
	/** Com Code */
	private String comCode = "";
	
	/** Com Text */
	private String comText = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomOwnerVO customownervo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOwnerVO[] customownervos = null;

	public EsmFms0006Event(){}
	
	public void setCustomOwnerVO(CustomOwnerVO customownervo){
		this. customownervo = customownervo;
	}

	public void setCustomOwnerVOS(CustomOwnerVO[] customownervos){
		if (customownervos != null) {
			CustomOwnerVO[] tmpVOs = new CustomOwnerVO[customownervos.length];
			System.arraycopy(customownervos, 0, tmpVOs, 0, tmpVOs.length);
			this.customownervos = tmpVOs;
		}
	}

	public void setComCdId(String comCdId) {
		this.comCdId = comCdId;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public void setComText(String comText) {
		this.comText = comText;
	}

	public CustomOwnerVO getCustomOwnerVO(){
		return customownervo;
	}

	public CustomOwnerVO[] getCustomOwnerVOS(){
		CustomOwnerVO[] rtnVOs = null;
		if (this.customownervos != null) {
			rtnVOs = new CustomOwnerVO[customownervos.length];
			System.arraycopy(customownervos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getComCdId() {
		return comCdId;
	}
	
	public String getComCode() {
		return comCode;
	}
	
	public String getComText() {
		return comText;
	}

}