/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecContainerVO.java
*@FileTitle : KrWhfDecContainerVO
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

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgKrWhfVolVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecContainerVO extends WhfDecVO {

	private static final long serialVersionUID = 1L;
	
	private List<KrWhfVvdDtlVO> krWhfVvdDtlVOs = null ;
	private BkgKrWhfVolVO bkgKrWhfVolVO = null;
	private KrWhfDecVO krWhfDecVO = null;
	private KrWhfDecVO whfDecVO = null;
	private List<KrWhfDecExptVolVO> krWhfDecExptVolVOs = null;
	private KrWhfPortRtVO krWhfPortRtVO = null;
	private KrWhfPortRtVO Cntr_KrWhfPortRtVO = null;
	private KrWhfPortRtVO Blk_KrWhfPortRtVO = null;
	private KrWhfDecCondVO krWhfDecCondVO = null;
	private KrWhfVvdDtlVO[] krWhfVvdDtlVOs2 = null;
	private KrWhfDecExptVolVO[] krWhfDecExptVolVOs2 = null;
	private String errMsg="";

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public KrWhfVvdDtlVO[] getKrWhfVvdDtlVOs2() {
		return krWhfVvdDtlVOs2;
	}

	public void setKrWhfVvdDtlVOs2(KrWhfVvdDtlVO[] krWhfVvdDtlVOs2) {
		this.krWhfVvdDtlVOs2 = krWhfVvdDtlVOs2;
	}

	public KrWhfDecExptVolVO[] getKrWhfDecExptVolVOs2() {
		return krWhfDecExptVolVOs2;
	}

	public void setKrWhfDecExptVolVOs2(KrWhfDecExptVolVO[] krWhfDecExptVolVOs2) {
		this.krWhfDecExptVolVOs2 = krWhfDecExptVolVOs2;
	}

	public KrWhfPortRtVO getKrWhfPortRtVO() {
		return krWhfPortRtVO;
	}

	public void setKrWhfPortRtVO(KrWhfPortRtVO krWhfPortRtVO) {
		this.krWhfPortRtVO = krWhfPortRtVO;
	}

	public KrWhfDecCondVO getKrWhfDecCondVO() {
		return krWhfDecCondVO;
	}

	public void setKrWhfDecCondVO(KrWhfDecCondVO krWhfDecCondVO) {
		this.krWhfDecCondVO = krWhfDecCondVO;
	}

	public List<KrWhfDecExptVolVO> getKrWhfDecExptVolVOs() {
		return krWhfDecExptVolVOs;
	}

	public void setKrWhfDecExptVolVOs(List<KrWhfDecExptVolVO> krWhfDecExptVolVOs) {
		this.krWhfDecExptVolVOs = krWhfDecExptVolVOs;
	}

	public KrWhfPortRtVO getCntr_KrWhfPortRtVO() {
		return Cntr_KrWhfPortRtVO;
	}

	public void setCntr_KrWhfPortRtVO(KrWhfPortRtVO cntr_KrWhfPortRtVO) {
		Cntr_KrWhfPortRtVO = cntr_KrWhfPortRtVO;
	}

	public KrWhfPortRtVO getBlk_KrWhfPortRtVO() {
		return Blk_KrWhfPortRtVO;
	}

	public void setBlk_KrWhfPortRtVO(KrWhfPortRtVO blk_KrWhfPortRtVO) {
		Blk_KrWhfPortRtVO = blk_KrWhfPortRtVO;
	}

	public KrWhfDecVO getKrWhfDecVO() {
		return krWhfDecVO;
	}

	public void setKrWhfDecVO(KrWhfDecVO krWhfDecVO) {
		this.krWhfDecVO = krWhfDecVO;
	}

	public KrWhfDecVO getWhfDecVO() {
		return whfDecVO;
	}

	public void setWhfDecVO(KrWhfDecVO whfDecVO) {
		this.whfDecVO = whfDecVO;
	}

	public BkgKrWhfVolVO getBkgKrWhfVolVO() {
		return bkgKrWhfVolVO;
	}

	public void setBkgKrWhfVolVO(BkgKrWhfVolVO bkgKrWhfVolVO) {
		this.bkgKrWhfVolVO = bkgKrWhfVolVO;
	}

	public List<KrWhfVvdDtlVO> getKrWhfVvdDtlVOs() {
		return krWhfVvdDtlVOs;
	}

	public void setKrWhfVvdDtlVOs(List<KrWhfVvdDtlVO> krWhfVvdDtlVOs) {
		this.krWhfVvdDtlVOs = krWhfVvdDtlVOs;
	}
	
}
