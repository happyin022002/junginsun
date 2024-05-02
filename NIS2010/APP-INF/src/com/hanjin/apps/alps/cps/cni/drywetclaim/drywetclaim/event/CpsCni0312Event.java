/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0312Event.java
 *@FileTitle : Transfer
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event;


import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CniDwTrnsVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferCondVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0036] Transfer
 * @author 양정란 
 * @see CPS_CNI_0312HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0312Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    public TransferVO[] getTransferVOs() {
		return transferVOs;
	}
	public void setTransferVOs(TransferVO[] transferVOs) {
		this.transferVOs = transferVOs;
	}
	private String schOfcCd;
    private String schUsrId;
    private String schTrnsAuthCd;    
    private String schDate;
	private String pageNo;
	//row validation
	private String trnsToOfcCd;
	private String trnsToUsrId;
	
	/* VO */
    private TransferVO transferVO;
    private TransferCondVO transferCondVO;
    
    /** Table Value Object Multi Data 처리 */
	private CniDwTrnsVO[] cniDwTrnsVOs = null;	
	private TransferVO[] transferVOs = null;

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
	public CniDwTrnsVO[] getCniDwTrnsVOs() {
		return cniDwTrnsVOs;
	}
	public void setCniDwTrnsVOs(CniDwTrnsVO[] cniDwTrnsVOs) {
		this.cniDwTrnsVOs = cniDwTrnsVOs;
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
	public TransferVO getTransferVO() {
		return transferVO;
	}
	public void setTransferVO(TransferVO transferVO) {
		this.transferVO = transferVO;
	}
	public TransferCondVO getTransferCondVO() {
		return transferCondVO;
	}
	public void setTransferCondVO(TransferCondVO transferCondVO) {
		this.transferCondVO = transferCondVO;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    
    
    }