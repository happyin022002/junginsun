/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrBlContainerVO.java
*@FileTitle : KrBlContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.31 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrBlContainerVO extends BlVO {

	private static final long serialVersionUID = 1L;
	
	private KrBlVO krBlVO            = null;
	private List<KrCntrVO> krCntrVOs = null;
	private List<KrCustVO> krCustVOs = null;
	
	public KrBlVO getKrBlVO() {
		return krBlVO;
	}
	public void setKrBlVO(KrBlVO krBlVO) {
		this.krBlVO = krBlVO;
	}
	public List<KrCntrVO> getKrCntrVOs() {
		return krCntrVOs;
	}
	public void setKrCntrVOs(List<KrCntrVO> krCntrVOs) {
		this.krCntrVOs = krCntrVOs;
	}
	public List<KrCustVO> getKrCustVOs() {
		return krCustVOs;
	}
	public void setKrCustVOs(List<KrCustVO> krCustVOs) {
		this.krCustVOs = krCustVOs;
	}
	
}
