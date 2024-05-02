/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgChgOfcVO.java
*@FileTitle : BkgChgOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25  
* 1.0 Creation
* 2012.02.13 정선용 [CHM-201215887-01]	NS RELORD 신규개발 건(30 day expiration)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * Terminal에 보낼 EDI정보를 Parameter로 하며 VO로 설정. 
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Vender301ParamVO{

	List<BkgVvdVO> oldVvdVOs = new ArrayList<BkgVvdVO>();
	List<BkgQuantityVO> oldQtyVOs = new ArrayList<BkgQuantityVO>();
	BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
	BkgVvdVO oldVvdVO = new BkgVvdVO();
	
	private String oldMtyPkupYdCd  = null; 
	private String bracCd = null;
	private String nsBracCd = null;
	private String bracCdNew = null;
	private String ediKind = null;
	private String autoManualFlg = null;
	private String rcvId = null;
	private String cct = null;
	private String nsBatchFlag = null;
	
	
	public String getNsBatchFlag() {
		return nsBatchFlag;
	}
	public void setNsBatchFlag(String nsBatchFlag) {
		this.nsBatchFlag = nsBatchFlag;
	}
	public List<BkgVvdVO> getOldVvdVOs() {
		return oldVvdVOs;
	}
	public void setOldVvdVOs(List<BkgVvdVO> oldVvdVOs) {
		this.oldVvdVOs = oldVvdVOs;
	}
	public List<BkgQuantityVO> getOldQtyVOs() {
		return oldQtyVOs;
	}
	public void setOldQtyVOs(List<BkgQuantityVO> oldQtyVOs) {
		this.oldQtyVOs = oldQtyVOs;
	}
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	public String getOldMtyPkupYdCd() {
		return oldMtyPkupYdCd;
	}
	public void setOldMtyPkupYdCd(String oldMtyPkupYdCd) {
		this.oldMtyPkupYdCd = oldMtyPkupYdCd;
	}
	public String getBracCd() {
		return bracCd;
	}
	public void setBracCd(String bracCd) {
		this.bracCd = bracCd;
	}
	public String getEdiKind() {
		return ediKind;
	}
	public void setEdiKind(String ediKind) {
		this.ediKind = ediKind;
	}
	public String getAutoManualFlg() {
		return autoManualFlg;
	}
	public void setAutoManualFlg(String autoManualFlg) {
		this.autoManualFlg = autoManualFlg;
	}
	public String getRcvId() {
		return rcvId;
	}
	public void setRcvId(String rcvId) {
		this.rcvId = rcvId;
	}
	public String getNsBracCd() {
		return nsBracCd;
	}
	public void setNsBracCd(String nsBracCd) {
		this.nsBracCd = nsBracCd;
	}
	public String getBracCdNew() {
		return bracCdNew;
	}
	public void setBracCdNew(String bracCdNew) {
		this.bracCdNew = bracCdNew;
	}
	public String getCct() {
		return cct;
	}
	public void setCct(String cct) {
		this.cct = cct;
	}
	public BkgVvdVO getOldVvdVO() {
		return oldVvdVO;
	}
	public void setOldVvdVO(BkgVvdVO oldVvdVO) {
		this.oldVvdVO = oldVvdVO;
	}
}
