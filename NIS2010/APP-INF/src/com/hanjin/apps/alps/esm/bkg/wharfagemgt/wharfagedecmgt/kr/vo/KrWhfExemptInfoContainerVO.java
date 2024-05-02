/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfExemptInfoContainerVO.java
*@FileTitle : KrWhfExemptInfoContainerVO
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfExemptInfoContainerVO extends WhfExemptInfoVO {

	private static final long serialVersionUID = 1L;
	
	private KrWhfBlExpInfoVO            krWhfBlExpInfoVO  = null ;
	private List<KrWhfBlExptInfoVO>     krWhfBlExptInfoVOs = null ;
	
	private List<KrWhfCntrExpInfoVO> krWhfCntrExpInfoVOs = null ;

	public KrWhfBlExpInfoVO getKrWhfBlExpInfoVO() {
		return krWhfBlExpInfoVO;
	}

	public void setKrWhfBlExpInfoVO(KrWhfBlExpInfoVO krWhfBlExpInfoVO) {
		this.krWhfBlExpInfoVO = krWhfBlExpInfoVO;
	}

	public List<KrWhfCntrExpInfoVO> getKrWhfCntrExpInfoVOs() {
		return krWhfCntrExpInfoVOs;
	}

	public void setKrWhfCntrExpInfoVOs(List<KrWhfCntrExpInfoVO> krWhfCntrExpInfoVOs) {
		this.krWhfCntrExpInfoVOs = krWhfCntrExpInfoVOs;
	}

	public List<KrWhfBlExptInfoVO> getKrWhfBlExptInfoVOs() {
		return krWhfBlExptInfoVOs;
	}

	public void setKrWhfBlExptInfoVOs(List<KrWhfBlExptInfoVO> krWhfBlExptInfoVOs) {
		this.krWhfBlExptInfoVOs = krWhfBlExptInfoVOs;
	}
}
