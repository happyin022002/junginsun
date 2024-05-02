/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfVslInfoContainerVO.java
*@FileTitle : KrWhfVslInfoContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.31 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfVslInfoContainerVO extends WhfVslInfoVO {

	private static final long serialVersionUID = 1L;
	
	KrWhfVslInfoVO           krWhfVslInfoVO      = null;
	
	List<KrWhfVslInfoVO>     KrWhfVslInfoVOs     = null;
	List<KrWhfVslInfoTempVO> KrWhfVslInfoTempVOs = null;

	public List<KrWhfVslInfoTempVO> getKrWhfVslInfoTempVOs() {
		return KrWhfVslInfoTempVOs;
	}

	public void setKrWhfVslInfoTempVOs(List<KrWhfVslInfoTempVO> krWhfVslInfoTempVOs) {
		KrWhfVslInfoTempVOs = krWhfVslInfoTempVOs;
	}

	public KrWhfVslInfoVO getKrWhfVslInfoVO() {
		return krWhfVslInfoVO;
	}

	public void setKrWhfVslInfoVO(KrWhfVslInfoVO krWhfVslInfoVO) {
		this.krWhfVslInfoVO = krWhfVslInfoVO;
	}

	public List<KrWhfVslInfoVO> getKrWhfVslInfoVOs() {
		return KrWhfVslInfoVOs;
	}

	public void setKrWhfVslInfoVOs(List<KrWhfVslInfoVO> krWhfVslInfoVOs) {
		KrWhfVslInfoVOs = krWhfVslInfoVOs;
	}
}
