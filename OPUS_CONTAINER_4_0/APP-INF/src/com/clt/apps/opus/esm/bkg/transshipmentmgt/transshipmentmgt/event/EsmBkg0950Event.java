/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0950Event.java
*@FileTitle : Relay Vessel Group Assign by Relay Port
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
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0950 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0950HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0950HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0950Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO = null;
	private BkgBlNoVO bkgBlNoVO =null;
	private BkgBlNoVO[] bkgBlNoVOs =null;
	private String newVVD = null;
	private String orgVVD = null;
	private String assignFlag = null;
	private String relay = null;
	
	public EsmBkg0950Event(){}

	public RlyVslGrpAssignInputVO getRlyVslGrpAssignInputVO() {
		return rlyVslGrpAssignInputVO;
	}

	public void setRlyVslGrpAssignInputVO(RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO) {
		this.rlyVslGrpAssignInputVO = rlyVslGrpAssignInputVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public String getNewVVD() {
		return newVVD;
	}

	public void setNewVVD(String newVVD) {
		this.newVVD = newVVD;
	}

	public String getOrgVVD() {
		return orgVVD;
	}

	public void setOrgVVD(String orgVVD) {
		this.orgVVD = orgVVD;
	}

	public String getAssignFlag() {
		return assignFlag;
	}

	public void setAssignFlag(String assignFlag) {
		this.assignFlag = assignFlag;
	}

	public String getRelay() {
		return relay;
	}

	public void setRelay(String relay) {
		this.relay = relay;
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
	
	
	 
}