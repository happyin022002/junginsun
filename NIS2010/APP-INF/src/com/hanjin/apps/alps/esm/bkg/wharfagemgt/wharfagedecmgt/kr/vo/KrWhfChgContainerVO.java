/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfChgContainerVO.java
*@FileTitle : KrWhfChgContainerVO
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfChgContainerVO extends WhfChgVO {

	private static final long serialVersionUID = 1L;
	
	
	VvdPortEtdEtaVO vvdPortEtdEtaVO = null;
	List<KrWhfChgVO>       krWhfChgVOs       = null ;
	List<KrWhfChgGenVO>    krWhfChgGenVOs    = null ;
	List<KrWhfChgExpSumVO> krWhfChgExpSumVOs = null ;
	KrWhfCfmVO             krWhfCfmVO     = null ;

	public VvdPortEtdEtaVO getVvdPortEtdEtaVO() {
		return vvdPortEtdEtaVO;
	}
	public void setVvdPortEtdEtaVO(VvdPortEtdEtaVO vvdPortEtdEtaVO) {
		this.vvdPortEtdEtaVO = vvdPortEtdEtaVO;
	}
	public KrWhfCfmVO getKrWhfCfmVO() {
		return krWhfCfmVO;
	}
	public void setKrWhfCfmVO(KrWhfCfmVO krWhfCfmVO) {
		this.krWhfCfmVO = krWhfCfmVO;
	}
	public List<KrWhfChgVO> getKrWhfChgVOs() {
		return krWhfChgVOs;
	}
	public void setKrWhfChgVOs(List<KrWhfChgVO> krWhfChgVOs) {
		this.krWhfChgVOs = krWhfChgVOs;
	}
	public List<KrWhfChgGenVO> getKrWhfChgGenVOs() {
		return krWhfChgGenVOs;
	}
	public void setKrWhfChgGenVOs(List<KrWhfChgGenVO> krWhfChgGenVOs) {
		this.krWhfChgGenVOs = krWhfChgGenVOs;
	}
	public List<KrWhfChgExpSumVO> getKrWhfChgExpSumVOs() {
		return krWhfChgExpSumVOs;
	}
	public void setKrWhfChgExpSumVOs(List<KrWhfChgExpSumVO> krWhfChgExpSumVOs) {
		this.krWhfChgExpSumVOs = krWhfChgExpSumVOs;
	}
	
}
