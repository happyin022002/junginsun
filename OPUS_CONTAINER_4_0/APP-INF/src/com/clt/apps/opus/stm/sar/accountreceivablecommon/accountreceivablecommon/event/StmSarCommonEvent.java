/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSarCommonEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.MiscLimitCondVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSarCommonEvent 참조
 * @since J2EE 1.4
 */

public class StmSarCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private String effDt = null;
	
	private String ofcCd = null;
	
	private String sysDivCd = null;
	
	private String acctCtnt = null;
	
	private String custCntCd = null;
	
	private String custSeq = null;
	
	private String currCd = null;
	
	private String rhqCd = null;
	
	private String acctCd = null;
	
	private String arRhqCd = null;
	
	private String acctCtnt2 = null;
	private String acctCtnt3 = null;
	private String acctCtnt4 = null;
	private String acctCtnt5 = null;
	
	private String custUseFlg = null;
	
	
	//2014.08.25 add
	private MiscLimitCondVO miscLimitCondVO = null;
	
	/**
	 * Office level type 
	 * 'QUERY'=> Inquery authorize  or EMPTY ==> entry authorize   
	 */
	private String ofcLvlTp = "";
	
	
	/**
	 * Office Agent/Branch
	 */
	private String ofcBrncAgnTpCd = "";
	
	
	
	public String getOfcBrncAgnTpCd() {
		return ofcBrncAgnTpCd;
	}


	public void setOfcBrncAgnTpCd(String ofcBrncAgnTpCd) {
		this.ofcBrncAgnTpCd = ofcBrncAgnTpCd;
	}


	private ARExrateVO arExrateVO = null;
	
	private AROfficeListVO arOfficeListVO = null;
	
	
	public String getOfcLvlTp() {
		return ofcLvlTp;
	}


	public void setOfcLvlTp(String ofcLvlTp) {
		this.ofcLvlTp = ofcLvlTp;
	}


	public StmSarCommonEvent() {}

	
	public String getEffDt() {
		return effDt;
	}
	
	public void setEffDt(String effDt) {
		this.effDt = effDt;	
	}
	
	public String getOfcCd() {
		return ofcCd;
	}
	
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;	
	}
	
	public String getSysDivCd() {
		return sysDivCd;
	}
	
	public void setSysDivCd(String sysDivCd) {
		this.sysDivCd = sysDivCd;	
	}
	
	public String getAcctCtnt() {
		return acctCtnt;
	}

	public void setAcctCtnt(String acctCtnt) {
		this.acctCtnt = acctCtnt;
	}
	
	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	public String getCustUseFlg() {
		return custUseFlg;
	}

	public void setCustUseFlg(String custUseFlg) {
		this.custUseFlg = custUseFlg;
	}
	
	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getArRhqCd() {
		return arRhqCd;
	}

	public void setArRhqCd(String arRhqCd) {
		this.arRhqCd = arRhqCd;
	}
	
	public String getRhqCd() {
		return rhqCd;
	}

	public String getAcctCtnt3() {
		return acctCtnt3;
	}


	public void setAcctCtnt3(String acctCtnt3) {
		this.acctCtnt3 = acctCtnt3;
	}


	public String getAcctCtnt4() {
		return acctCtnt4;
	}


	public void setAcctCtnt4(String acctCtnt4) {
		this.acctCtnt4 = acctCtnt4;
	}


	public String getAcctCtnt5() {
		return acctCtnt5;
	}


	public void setAcctCtnt5(String acctCtnt5) {
		this.acctCtnt5 = acctCtnt5;
	}


	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	public String getAcctCd() {
		return acctCd;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}

	
	public ARExrateVO getARExrateVO() {
		return arExrateVO;
	}

	public void setARExrateVO(ARExrateVO arExrateVO) {
		this.arExrateVO = arExrateVO;
	}
	
	public AROfficeListVO getAROfficeListVO() {
		return arOfficeListVO;
	}

	public void setAROfficeListVO(AROfficeListVO arOfficeListVO) {
		this.arOfficeListVO = arOfficeListVO;
	}

	public String getAcctCtnt2() {
		return acctCtnt2;
	}


	public void setAcctCtnt2(String acctCtnt2) {
		this.acctCtnt2 = acctCtnt2;
	}	
	
	//2014.08.25 add
	public MiscLimitCondVO getMiscLimitCondVO() {
		return miscLimitCondVO;
	}

	//2014.08.25 add
	public void setMiscLimitCondVO(MiscLimitCondVO miscLimitCondVO) {
		this.miscLimitCondVO = miscLimitCondVO;
	}	
}