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
* -------------------------------------------------------
* History
* 2012.01.09 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	private String yardCd = null;
	private String bkgOfcCd = null;
	private String pol = null;
	private String pod = null;
	private String vslCngRsn = null;
	private BkgBlNoVO bkgBlNoVO =null;
	private BkgListForPortAssignInputVO bkgListForPortAssignInputVO = null;
    private VvdPortAssinVO[] vvdPortAssinVOs = null;
    private	String	portSkpFlg = null;
	private String closedVvds = null;
	private BkgBlNoVO[] bkgBlNoVOs= null;
	
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
	
	public String getYardCd() {
		return yardCd;
	}

	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
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
			rtnVOs = new VvdPortAssinVO[vvdPortAssinVOs.length];
			System.arraycopy(vvdPortAssinVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setVvdPortAssinVOs(VvdPortAssinVO[] vvdPortAssinVOs){
		if(vvdPortAssinVOs != null){
			VvdPortAssinVO[] tmpVOs = new VvdPortAssinVO[vvdPortAssinVOs.length];
			System.arraycopy(vvdPortAssinVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdPortAssinVOs = tmpVOs;
		}
	}

	public String getPortSkpFlg() {
		return portSkpFlg;
	}

	public void setPortSkpFlg(String portSkpFlg) {
		this.portSkpFlg = portSkpFlg;
	}

	public String getClosedVvds() {
		return closedVvds;
	}

	public void setClosedVvds(String closedVvds) {
		this.closedVvds = closedVvds;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs){
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public String getVslCngRsn() {
		return vslCngRsn;
	}

	public void setVslCngRsn(String vslCngRsn) {
		this.vslCngRsn = vslCngRsn;
	}

}