/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Vender301ParamVO.java
*@FileTitle : Vender301ParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.12 최영희
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgVvdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Vender301ParamVO{

	BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
	BkgVvdVO oldVvdVO = new BkgVvdVO();
	List<BkgVvdVO> oldVvdVOs = new ArrayList<BkgVvdVO>();
	List<BkgQuantityVO> oldQtyVOs = new ArrayList<BkgQuantityVO>();
	BkgBlNoVO[] bkgBlNoVOs = null;
	CustTpIdVO[] custTpIdVOs = null;
	
	private String oldMtyPkupYdCd  = null; 
	private String bracCd = null;
	private String nsBracCd = null;
	private String bracCdNew = null;
	private String ediKind = null;
	private String autoManualFlg = null;
	private String rcvId = null;
	private String cct = null;
	private String nsBatchFlag = null;
	private String eventPage = null;
	private String refCode = null;
	private String polNodCd = null;
	
	
	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}
	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}
	public CustTpIdVO[] getCustTpIdVOs() {
		return custTpIdVOs;
	}
	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs) {
		this.custTpIdVOs = custTpIdVOs;
	}
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
	public String getEventPage() {
		return eventPage;
	}
	public void setEventPage(String eventPage) {
		this.eventPage = eventPage;
	}
	public String getRefCode() {
		return refCode;
	}
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	public String getPolNodCd() {
		return polNodCd;
	}
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	
	
}