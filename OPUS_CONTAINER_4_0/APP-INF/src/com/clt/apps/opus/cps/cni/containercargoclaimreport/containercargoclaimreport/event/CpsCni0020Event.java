/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0020Event.java
 *@FileTitle : Report-Settlement Analysis
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0020] Report-Settlement Analysis
 * @author 양정란 
 * @see CPS_CNI_0020HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private String schOfcCd;
    private String schUsrId;
    private String schTrnsAuthCd;    
    private String schDate;
	private String pageNo;
	//row validation
	private String trnsToOfcCd;
	private String trnsToUsrId;
	
	/* VO */
    private SettlementAnalysisVO settlementAnalysisVO;
    private SettlementAnalysisCondVO settlementAnalysisCondVO;
    
    /** Table Value Object Multi Data 처리 */
	private CniCgoClmTrnsVO[] cniCgoClmTrnsVOs = null;	

    public String getTrnsToUsrId() {
		return trnsToUsrId;
	}
	public void setTrnsToUsrId(String trnsToUsrId) {
		this.trnsToUsrId = trnsToUsrId;
	}
	public String getTrnsToOfcCd() {
		return trnsToOfcCd;
	}
	public void setTrnsToOfcCd(String trnsToOfcCd) {
		this.trnsToOfcCd = trnsToOfcCd;
	}
	public CniCgoClmTrnsVO[] getCniCgoClmTrnsVOs() {
		CniCgoClmTrnsVO[] rtnVOs = null;
		if (this.cniCgoClmTrnsVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cniCgoClmTrnsVOs, cniCgoClmTrnsVOs.length);
		}
		return rtnVOs;
	}
	public void setCniCgoClmTrnsVOs(CniCgoClmTrnsVO[] cniCgoClmTrnsVOs){
		if(cniCgoClmTrnsVOs != null){
			CniCgoClmTrnsVO[] tmpVOs = java.util.Arrays.copyOf(cniCgoClmTrnsVOs, cniCgoClmTrnsVOs.length);
			this.cniCgoClmTrnsVOs = tmpVOs;
		}
	}
	public String getSchOfcCd() {
		return schOfcCd;
	}
	public void setSchOfcCd(String schOfcCd) {
		this.schOfcCd = schOfcCd;
	}
	public String getSchUsrId() {
		return schUsrId;
	}
	public void setSchUsrId(String schUsrId) {
		this.schUsrId = schUsrId;
	}
	public String getSchTrnsAuthCd() {
		return schTrnsAuthCd;
	}
	public void setSchTrnsAuthCd(String schTrnsAuthCd) {
		this.schTrnsAuthCd = schTrnsAuthCd;
	}
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public SettlementAnalysisVO getSettlementAnalysisVO() {
		return settlementAnalysisVO;
	}
	public void setSettlementAnalysisVO(SettlementAnalysisVO settlementAnalysisVO) {
		this.settlementAnalysisVO = settlementAnalysisVO;
	}
	public SettlementAnalysisCondVO getSettlementAnalysisCondVO() {
		return settlementAnalysisCondVO;
	}
	public void setSettlementAnalysisCondVO(
			SettlementAnalysisCondVO settlementAnalysisCondVO) {
		this.settlementAnalysisCondVO = settlementAnalysisCondVO;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    
    
    }