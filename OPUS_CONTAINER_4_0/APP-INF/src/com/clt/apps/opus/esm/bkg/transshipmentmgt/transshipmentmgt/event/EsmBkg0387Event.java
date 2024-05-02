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
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
		}
		return rtnVOs;
	}
	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
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
	
}