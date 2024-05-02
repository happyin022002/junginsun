/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfBlContainerVO.java
*@FileTitle : KrWhfBlContainerVO
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgKrWhfBlVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCntrVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCustVO;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfBlContainerVO extends WhfBlVO {

	private static final long serialVersionUID = 1L;
	
	private String svcGubunId = "";
	
	private KrWhfBkgInfoCondVO      krWhfBkgInfoCondVO = null ;
	
	private KrWhfBkgKrWhfBlVO       krWhfBkgKrWhfBlVO = null;
	private BkgKrWhfCustVO          bkgKrWhfCustVO    = null;
	private BkgKrWhfCntrVO          bkgKrWhfCntrVO    = null;
	private KrWhfCntrVO             krWhfCntrVO       = null;
	
	private KrWhfBkgKrWhfBlVO[]     krWhfBkgKrWhfBlVOs = null ;
	private List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs2 = null ;
	
	private BkgKrWhfCustVO[]        bkgKrWhfCustVOs    = null ; 
	private List<BkgKrWhfCustVO>    bkgKrWhfCustVOs2   = null ;
	
	private BkgKrWhfCntrVO[]        bkgKrWhfCntrVOs    = null ;  
	private List<BkgKrWhfCntrVO>    bkgKrWhfCntrVOs2   = null ;
	
	private KrWhfVslInfoCondVO krWhfVslInfoCondVO   = null;
	private BkgKrWhfBlVO bkgKrWhfBlVO = null;
	
	private List<BkgKrWhfVolVO> bkgKrWhfVols = null;
	private BkgKrWhfVolVO[]     bkgKrWhfVols2 = null;
	
	private BkgKrWhfVolVO bkgKrWhfVolVO = null;
	
	private KrWhfBlInfoVO[] krWhfBlInfoVOs = null; 
	
	private KrWhfCgoClassCondVO krWhfCgoClassCondVO = null;
	
	private KrWhfBkgChkListCondVO krWhfBkgChkListCondVO    = null;
	
	private KrWhfBkgChkListCondVO[]     krWhfBkgChkListCondVOs   = null;
	
	public KrWhfCgoClassCondVO getKrWhfCgoClassCondVO() {
		return krWhfCgoClassCondVO;
	}
	public void setKrWhfCgoClassCondVO(KrWhfCgoClassCondVO krWhfCgoClassCondVO) {
		this.krWhfCgoClassCondVO = krWhfCgoClassCondVO;
	}
	public KrWhfBlInfoVO[] getKrWhfBlInfoVOs() {
		return krWhfBlInfoVOs;
	}
	public void setKrWhfBlInfoVOs(KrWhfBlInfoVO[] krWhfBlInfoVOs) {
		this.krWhfBlInfoVOs = krWhfBlInfoVOs;
	}
	public BkgKrWhfVolVO getBkgKrWhfVolVO() {
		return bkgKrWhfVolVO;
	}
	public void setBkgKrWhfVolVO(BkgKrWhfVolVO bkgKrWhfVolVO) {
		this.bkgKrWhfVolVO = bkgKrWhfVolVO;
	}
	public BkgKrWhfVolVO[] getBkgKrWhfVols2() {
		return bkgKrWhfVols2;
	}
	public void setBkgKrWhfVols2(BkgKrWhfVolVO[] bkgKrWhfVols2) {
		this.bkgKrWhfVols2 = bkgKrWhfVols2;
	}
	public String getSvcGubunId() {
		return svcGubunId;
	}
	public void setSvcGubunId(String svcGubunId) {
		this.svcGubunId = svcGubunId;
	}
	public List<BkgKrWhfVolVO> getBkgKrWhfVols() {
		return bkgKrWhfVols;
	}
	public void setBkgKrWhfVols(List<BkgKrWhfVolVO> bkgKrWhfVols) {
		this.bkgKrWhfVols = bkgKrWhfVols;
	}
	public KrWhfVslInfoCondVO getKrWhfVslInfoCondVO() {
		return krWhfVslInfoCondVO;
	}
	public void setKrWhfVslInfoCondVO(KrWhfVslInfoCondVO krWhfVslInfoCondVO) {
		this.krWhfVslInfoCondVO = krWhfVslInfoCondVO;
	}
	public BkgKrWhfBlVO getBkgKrWhfBlVO() {
		return bkgKrWhfBlVO;
	}
	public void setBkgKrWhfBlVO(BkgKrWhfBlVO bkgKrWhfBlVO) {
		this.bkgKrWhfBlVO = bkgKrWhfBlVO;
	}
	public KrWhfCntrVO getKrWhfCntrVO() {
		return krWhfCntrVO;
	}
	public void setKrWhfCntrVO(KrWhfCntrVO krWhfCntrVO) {
		this.krWhfCntrVO = krWhfCntrVO;
	}
	public KrWhfBkgKrWhfBlVO getKrWhfBkgKrWhfBlVO() {
		return krWhfBkgKrWhfBlVO;
	}
	public void setKrWhfBkgKrWhfBlVO(KrWhfBkgKrWhfBlVO krWhfBkgKrWhfBlVO) {
		this.krWhfBkgKrWhfBlVO = krWhfBkgKrWhfBlVO;
	}
	public BkgKrWhfCustVO getBkgKrWhfCustVO() {
		return bkgKrWhfCustVO;
	}
	public void setBkgKrWhfCustVO(BkgKrWhfCustVO bkgKrWhfCustVO) {
		this.bkgKrWhfCustVO = bkgKrWhfCustVO;
	}
	public BkgKrWhfCntrVO getBkgKrWhfCntrVO() {
		return bkgKrWhfCntrVO;
	}
	public void setBkgKrWhfCntrVO(BkgKrWhfCntrVO bkgKrWhfCntrVO) {
		this.bkgKrWhfCntrVO = bkgKrWhfCntrVO;
	}
	public KrWhfBkgInfoCondVO getKrWhfBkgInfoCondVO() {
		return krWhfBkgInfoCondVO;
	}
	public void setKrWhfBkgInfoCondVO(KrWhfBkgInfoCondVO krWhfBkgInfoCondVO) {
		this.krWhfBkgInfoCondVO = krWhfBkgInfoCondVO;
	}
	public KrWhfBkgKrWhfBlVO[] getKrWhfBkgKrWhfBlVOs() {
		return krWhfBkgKrWhfBlVOs;
	}
	public void setKrWhfBkgKrWhfBlVOs(KrWhfBkgKrWhfBlVO[] krWhfBkgKrWhfBlVOs) {
		this.krWhfBkgKrWhfBlVOs = krWhfBkgKrWhfBlVOs;
	}
	public List<KrWhfBkgKrWhfBlVO> getKrWhfBkgKrWhfBlVOs2() {
		return krWhfBkgKrWhfBlVOs2;
	}
	public void setKrWhfBkgKrWhfBlVOs2(List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs2) {
		this.krWhfBkgKrWhfBlVOs2 = krWhfBkgKrWhfBlVOs2;
	}
	public BkgKrWhfCustVO[] getBkgKrWhfCustVOs() {
		return bkgKrWhfCustVOs;
	}
	public void setBkgKrWhfCustVOs(BkgKrWhfCustVO[] bkgKrWhfCustVOs) {
		this.bkgKrWhfCustVOs = bkgKrWhfCustVOs;
	}
	public List<BkgKrWhfCustVO> getBkgKrWhfCustVOs2() {
		return bkgKrWhfCustVOs2;
	}
	public void setBkgKrWhfCustVOs2(List<BkgKrWhfCustVO> bkgKrWhfCustVOs2) {
		this.bkgKrWhfCustVOs2 = bkgKrWhfCustVOs2;
	}
	public BkgKrWhfCntrVO[] getBkgKrWhfCntrVOs() {
		return bkgKrWhfCntrVOs;
	}
	public void setBkgKrWhfCntrVOs(BkgKrWhfCntrVO[] bkgKrWhfCntrVOs) {
		this.bkgKrWhfCntrVOs = bkgKrWhfCntrVOs;
	}
	public List<BkgKrWhfCntrVO> getBkgKrWhfCntrVOs2() {
		return bkgKrWhfCntrVOs2;
	}
	public void setBkgKrWhfCntrVOs2(List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs2) {
		this.bkgKrWhfCntrVOs2 = bkgKrWhfCntrVOs2;
	}
	public KrWhfBkgChkListCondVO getKrWhfBkgChkListCondVO() {
		return krWhfBkgChkListCondVO;
	}
	
	public KrWhfBkgChkListCondVO[] getKrWhfBkgChkListCondVOs() {
		return krWhfBkgChkListCondVOs;
	}

	public void setKrWhfBkgChkListCondVO(KrWhfBkgChkListCondVO krWhfBkgChkListCondVO) {
		this.krWhfBkgChkListCondVO = krWhfBkgChkListCondVO;
	}
	
	public void setKrWhfBkgChkListCondVOs(KrWhfBkgChkListCondVO[] krWhfBkgChkListCondVOs) {
		this.krWhfBkgChkListCondVOs = krWhfBkgChkListCondVOs;
	}
}
