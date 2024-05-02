/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0387Event.java
*@FileTitle : Next VVD Assign I (by VVD POD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0387 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0387HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0387HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0387Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private NextVvdAssignInputVO nextVvdAssignInputVO = null;
	private VvdAssignTargetListVO vvdAssignTargetListVO = null;
    private BkgBlNoVO bkgBlNoVO =null;
	private BkgBlNoVO[] bkgBlNoVOs =null;
	private String nextVvd = null;
	private String formerVvd = null;
	private String relay=null;
	private String etbFrom = null;
	private String etbTo = null;
	private String oopCd = null; 
	private String nextTmnl = null;
	private String nextSeq = null; 
	private String oldNextVvd = null;
	private String closedVvds = null;
	private String relayTmnl = null;
	private String relaySeq = null;
	
	public NextVvdAssignInputVO getNextVvdAssignInputVO() {
		return nextVvdAssignInputVO;
	}
	public void setNextVvdAssignInputVO(NextVvdAssignInputVO nextVvdAssignInputVO) {
		this.nextVvdAssignInputVO = nextVvdAssignInputVO;
	}
	public VvdAssignTargetListVO getVvdAssignTargetListVO() {
		return vvdAssignTargetListVO;
	}
	public void setVvdAssignTargetListVO(VvdAssignTargetListVO vvdAssignTargetListVO) {
		this.vvdAssignTargetListVO = vvdAssignTargetListVO;
	}
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}
	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}
	 
	public String getNextVvd() {
		return nextVvd;
	}
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	public String getFormerVvd() {
		return formerVvd;
	}
	public void setFormerVvd(String formerVvd) {
		this.formerVvd = formerVvd;
	}
	public String getRelay() {
		return relay;
	}
	public void setRelay(String relay) {
		this.relay = relay;
	}
	public String getEtbFrom() {
		return etbFrom;
	}
	public void setEtbFrom(String etbFrom) {
		this.etbFrom = etbFrom;
	}
	public String getEtbTo() {
		return etbTo;
	}
	public void setEtbTo(String etbTo) {
		this.etbTo = etbTo;
	}
	public String getOopCd() {
		return oopCd;
	}
	public void setOopCd(String oopCd) {
		this.oopCd = oopCd;
	}
	public String getNextTmnl() {
		return nextTmnl;
	}
	public void setNextTmnl(String nextTmnl) {
		this.nextTmnl = nextTmnl;
	} 
	public String getNextSeq() {
		return nextSeq;
	}
	public void setNextSeq(String nextSeq) {
		this.nextSeq = nextSeq;
	} 
	public String getOldNextVvd() {
		return oldNextVvd;
	}
	public void setOldNextVvd(String oldNextVvd) {
		this.oldNextVvd = oldNextVvd;
	}
	public String getClosedVvds() {
		return closedVvds;
	}
	public void setClosedVvds(String closedVvds) {
		this.closedVvds = closedVvds;
	}
	public String getRelayTmnl() {
		return relayTmnl;
	}
	public void setRelayTmnl(String relayTmnl) {
		this.relayTmnl = relayTmnl;
	}
	public String getRelaySeq() {
		return relaySeq;
	}
	public void setRelaySeq(String relaySeq) {
		this.relaySeq = relaySeq;
	}	
}