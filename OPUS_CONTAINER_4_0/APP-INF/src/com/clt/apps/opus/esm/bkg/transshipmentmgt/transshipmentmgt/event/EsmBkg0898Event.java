/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0898Event.java
*@FileTitle : Vessel/Port Group Assign by VVD, Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.22 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SearchCondForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0898 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0898HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0898HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0898Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String vvd = null;
	private String portCd = null;
	private String bkgOfcCd = null;
	private String pol = null;
	private String pod = null;
	private String mtPkupDt = null;
	private String mPu = null;
	private String fRt = null;
	private String por = null;
	private String del = null;
	private String porNodCd = null;
	private String delNodCd = null;
	private String polNodCd = null;
	private String podNodCd = null;
	private String orgTrnsModCd = null;
	private String destTrnsModCd = null;
	private String prevTvvd = null;
	private BkgBlNoVO bkgBlNoVO =null;
	private BkgListForPortAssignInputVO bkgListForPortAssignInputVO = null;
    private VvdPortAssinVO[] vvdPortAssinVOs = null;
    private SearchCondForPortAssignVO searchCondForPortAssignVO = null;
	
	public EsmBkg0898Event(){}


	public String getVvd() {
		return vvd;
	}


	public void setVvd(String vvd) {
		this.vvd = vvd;
	}


	public String getPortCd() {
		return portCd;
	}


	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}


	public String getBkgOfcCd() {
		return bkgOfcCd;
	}
	

	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	public String getPod() {
		return pod;
	}
	
	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getMtPkupDt() {
		return mtPkupDt;
	}


	public void setMtPkupDt(String mtPkupDt) {
		this.mtPkupDt = mtPkupDt;
	}


	public String getMPu() {
		return mPu;
	}

	public void setMPu(String mPu) {
		this.mPu = mPu;
	}

	public String getFRt() {
		return fRt;
	}

	public void setFRt(String fRt) {
		this.fRt = fRt;
	}

	public String getPorNodCd() {
		return porNodCd;
	}

	public void setPor(String por) {
		this.por = por;
	}
	
	public String getPor() {
		return por;
	}
	
	public void setDel(String del) {
		this.del = del;
	}
	
	public String getDel() {
		return del;
	}
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	public String getDelNodCd() {
		return delNodCd;
	}

	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	public String getPolNodCd() {
		return polNodCd;
	}


	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}


	public String getPodNodCd() {
		return podNodCd;
	}


	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}


	public String getOrgTrnsModCd() {
		return orgTrnsModCd;
	}


	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}


	public String getDestTrnsModCd() {
		return destTrnsModCd;
	}


	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}


	public String getPrevTvvd() {
		return prevTvvd;
	}


	public void setPrevTvvd(String prevTvvd) {
		this.prevTvvd = prevTvvd;
	}


	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}


	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}


	public BkgListForPortAssignInputVO getBkgListForPortAssignInputVO() {
		return bkgListForPortAssignInputVO;
	}


	public void setBkgListForPortAssignInputVO(
			BkgListForPortAssignInputVO bkgListForPortAssignInputVO) {
		this.bkgListForPortAssignInputVO = bkgListForPortAssignInputVO;
	}


	public VvdPortAssinVO[] getVvdPortAssinVOs() {
		VvdPortAssinVO[] rtnVOs = null;
		if (this.vvdPortAssinVOs != null) {
			rtnVOs = Arrays.copyOf(vvdPortAssinVOs, vvdPortAssinVOs.length);
		}
		return rtnVOs;
	}


	public void setVvdPortAssinVOs(VvdPortAssinVO[] vvdPortAssinVOs) {
		if (vvdPortAssinVOs != null) {
			VvdPortAssinVO[] tmpVOs = Arrays.copyOf(vvdPortAssinVOs, vvdPortAssinVOs.length);
			this.vvdPortAssinVOs = tmpVOs;
		}
	}


	public SearchCondForPortAssignVO getSearchCondForPortAssignVO() {
		return searchCondForPortAssignVO;
	}


	public void setSearchCondForPortAssignVO(
			SearchCondForPortAssignVO searchCondForPortAssignVO) {
		this.searchCondForPortAssignVO = searchCondForPortAssignVO;
	}







	 
	 

}