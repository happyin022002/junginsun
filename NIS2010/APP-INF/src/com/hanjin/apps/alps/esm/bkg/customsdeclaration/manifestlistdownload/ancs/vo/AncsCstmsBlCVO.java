/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsBlCVO.java
*@FileTitle : AncsCstmsBlCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.02 정재엽 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AncsCstmsBlCVO extends BlDetailVO{

	private static final long serialVersionUID = 1L;
	
	private AncsCstmsBlVO ancsCstmsBlVO = null;
	private AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO = null;
	private AncsCstmsCntrVO ancsCstmsCntrVO = null;
	
	private List<AncsCstmsBlVO>  ancsCstmsBlVOs   = null;
	private List<AncsCstmsBlInfoVO>  AncsCstmsBlInfoVOs = null;
	private List<AncsCstmsCntrVO> ancsCstmsCntrVOs = null;
	private List<AncsCstmsCmdtVO> ancsCstmsCmdtVOs = null;
	
	
	public List<AncsCstmsBlInfoVO> getAncsCstmsBlInfoVOs() {
		return AncsCstmsBlInfoVOs;
	}
	public void setAncsCstmsBlInfoVOs(List<AncsCstmsBlInfoVO> ancsCstmsBlInfoVOs) {
		AncsCstmsBlInfoVOs = ancsCstmsBlInfoVOs;
	}
	public AncsCstmsBlVO getAncsCstmsBlVO() {
		return ancsCstmsBlVO;
	}
	public void setAncsCstmsBlVO(AncsCstmsBlVO ancsCstmsBlVO) {
		this.ancsCstmsBlVO = ancsCstmsBlVO;
	}
	public AncsCstmsBlNtfyVO getAncsCstmsBlNtfyVO() {
		return ancsCstmsBlNtfyVO;
	}
	public void setAncsCstmsBlNtfyVO(AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO) {
		this.ancsCstmsBlNtfyVO = ancsCstmsBlNtfyVO;
	}
	public AncsCstmsCntrVO getAncsCstmsCntrVO() {
		return ancsCstmsCntrVO;
	}
	public void setAncsCstmsCntrVO(AncsCstmsCntrVO ancsCstmsCntrVO) {
		this.ancsCstmsCntrVO = ancsCstmsCntrVO;
	}
	public List<AncsCstmsBlVO> getAncsCstmsBlVOs() {
		return ancsCstmsBlVOs;
	}
	public void setAncsCstmsBlVOs(List<AncsCstmsBlVO> ancsCstmsBlVOs) {
		this.ancsCstmsBlVOs = ancsCstmsBlVOs;
	}
	public List<AncsCstmsCntrVO> getAncsCstmsCntrVOs() {
		return ancsCstmsCntrVOs;
	}
	public void setAncsCstmsCntrVOs(List<AncsCstmsCntrVO> ancsCstmsCntrVOs) {
		this.ancsCstmsCntrVOs = ancsCstmsCntrVOs;
	}
	public List<AncsCstmsCmdtVO> getAncsCstmsCmdtVOs() {
		return ancsCstmsCmdtVOs;
	}
	public void setAncsCstmsCmdtVOs(List<AncsCstmsCmdtVO> ancsCstmsCmdtVOs) {
		this.ancsCstmsCmdtVOs = ancsCstmsCmdtVOs;
	}
	
}
