/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecEdiFfContainerVO.java
*@FileTitle : KrWhfDecEdiFfContainerVO
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

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecEdiFfContainerVO extends KrWhfDecEdiFfVO {

	private static final long serialVersionUID = 1L;
	
	private KrWhfDecEdiVvdVO krWhfDecEdiVvdVO  = null;
	private List<KrWhfDecEdiRtVO>  krWhfDecEdiRtVOs = null;
	
	public KrWhfDecEdiVvdVO getKrWhfDecEdiVvdVO() {
		return krWhfDecEdiVvdVO;
	}
	public void setKrWhfDecEdiVvdVO(KrWhfDecEdiVvdVO krWhfDecEdiVvdVO) {
		this.krWhfDecEdiVvdVO = krWhfDecEdiVvdVO;
	}
	public List<KrWhfDecEdiRtVO> getKrWhfDecEdiRtVOs() {
		return krWhfDecEdiRtVOs;
	}
	public void setKrWhfDecEdiRtVOs(List<KrWhfDecEdiRtVO> krWhfDecEdiRtVOs) {
		this.krWhfDecEdiRtVOs = krWhfDecEdiRtVOs;
	}
	
}
