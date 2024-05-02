/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsdEas0501Event.java
*@FileTitle :  
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.BnfStatusMlgVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrIssVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrUsdVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TesStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TrsStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.VslStatusIncntVO;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0501 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see ESD_EAS_0501HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0501Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	public EsdEas0501Event(){}
	
	private String strRhqCd = "";
	private String strInvOfcCd = "";
	private String strBseYr = "";
	private String strIncntNo = "";
	private String strInvVndrSeq = "";
	private String strFmDt = "";
	private String strToDt = "";
	private String strMkrCd = "";
	private String strCrUsdOfcCd = "";
	private String strPrdFmDt = "";
	private String strPrdToDt = "";
	private String strCrIssNo = "";
	private String strCrUsdSeq = "";
	private String strAtchFileLnkId = "";
	private String rhqOfcCd = "";
	private String ofcCd = "";
	private String portCd = "";
	private String ydCd = "";
	private String lgsCostCd = "";
	
	private BnfStatusMlgVO   bnfStatusMlgVO = null;
	private MnrStatusCrIssVO mnrStatusCrIssVO = null;
	private MnrStatusCrUsdVO mnrStatusCrUsdVO = null;
	private TesStatusIncntVO tesStatusIncntVO = null;
	private TrsStatusIncntVO trsStatusIncntVO = null;
	private VslStatusIncntVO vslStatusIncntVO = null;

	private BnfStatusMlgVO[] bnfStatusMlgVOs = null;
	private MnrStatusCrIssVO[] mnrStatusCrIssVOs = null;
	private MnrStatusCrUsdVO[] mnrStatusCrUsdVOs = null;
	private TesStatusIncntVO[] tesStatusIncntVOs = null;
	private TrsStatusIncntVO[] trsStatusIncntVOs = null;
	private VslStatusIncntVO[] vslStatusIncntVOs = null;
	
	public String getStrRhqCd() {
		return strRhqCd;
	}
	public void setStrRhqCd(String strRhqCd) {
		this.strRhqCd = strRhqCd;
	}
	public String getStrInvOfcCd() {
		return strInvOfcCd;
	}
	public void setStrInvOfcCd(String strInvOfcCd) {
		this.strInvOfcCd = strInvOfcCd;
	}
	public String getStrBseYr() {
		return strBseYr;
	}
	public void setStrBseYr(String strBseYr) {
		this.strBseYr = strBseYr;
	}
	public String getStrInvVndrSeq() {
		return strInvVndrSeq;
	}
	public void setStrInvVndrSeq(String strInvVndrSeq) {
		this.strInvVndrSeq = strInvVndrSeq;
	}
	public String getStrFmDt() {
		return strFmDt;
	}
	public void setStrFmDt(String strFmDt) {
		this.strFmDt = strFmDt;
	}
	public String getStrToDt() {
		return strToDt;
	}
	public void setStrToDt(String strToDt) {
		this.strToDt = strToDt;
	}
	public String getStrMkrCd() {
		return strMkrCd;
	}
	public void setStrMkrCd(String strMkrCd) {
		this.strMkrCd = strMkrCd;
	}
	public String getStrCrUsdOfcCd() {
		return strCrUsdOfcCd;
	}
	public void setStrCrUsdOfcCd(String strCrUsdOfcCd) {
		this.strCrUsdOfcCd = strCrUsdOfcCd;
	}
	
	public String getStrCrUsdSeq() {
		return strCrUsdSeq;
	}
	public void setStrCrUsdSeq(String strCrUsdSeq) {
		this.strCrUsdSeq = strCrUsdSeq;
	}
	public String getStrPrdFmDt() {
		return strPrdFmDt;
	}
	public void setStrPrdFmDt(String strPrdFmDt) {
		this.strPrdFmDt = strPrdFmDt;
	}
	public String getStrPrdToDt() {
		return strPrdToDt;
	}
	public void setStrPrdToDt(String strPrdToDt) {
		this.strPrdToDt = strPrdToDt;
	}
	
	public String getStrCrIssNo() {
		return strCrIssNo;
	}
	public void setStrCrIssNo(String strCrIssNo) {
		this.strCrIssNo = strCrIssNo;
	}
	
	public String getStrIncntNo() {
		return strIncntNo;
	}
	public void setStrIncntNo(String strIncntNo) {
		this.strIncntNo = strIncntNo;
	}
	public String getStrAtchFileLnkId() {
		return strAtchFileLnkId;
	}
	public void setStrAtchFileLnkId(String strAtchFileLnkId) {
		this.strAtchFileLnkId = strAtchFileLnkId;
	}
	public String getRhqOfcCd() {
		return rhqOfcCd;
	}
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getPortCd() {
		return portCd;
	}
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	public String getYdCd() {
		return ydCd;
	}
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	public String getLgsCostCd() {
		return lgsCostCd;
	}
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	public BnfStatusMlgVO getBnfStatusMlgVO() {
		return bnfStatusMlgVO;
	}
	public void setBnfStatusMlgVO(BnfStatusMlgVO bnfStatusMlgVO) {
		this.bnfStatusMlgVO = bnfStatusMlgVO;
	}
	public MnrStatusCrIssVO getMnrStatusCrIssVO() {
		return mnrStatusCrIssVO;
	}
	public void setMnrStatusCrIssVO(MnrStatusCrIssVO mnrStatusCrIssVO) {
		this.mnrStatusCrIssVO = mnrStatusCrIssVO;
	}
	public MnrStatusCrUsdVO getMnrStatusCrUsdVO() {
		return mnrStatusCrUsdVO;
	}
	public void setMnrStatusCrUsdVO(MnrStatusCrUsdVO mnrStatusCrUsdVO) {
		this.mnrStatusCrUsdVO = mnrStatusCrUsdVO;
	}
	public TesStatusIncntVO getTesStatusIncntVO() {
		return tesStatusIncntVO;
	}
	public void setTesStatusIncntVO(TesStatusIncntVO tesStatusIncntVO) {
		this.tesStatusIncntVO = tesStatusIncntVO;
	}
	public TrsStatusIncntVO getTrsStatusIncntVO() {
		return trsStatusIncntVO;
	}
	public void setTrsStatusIncntVO(TrsStatusIncntVO trsStatusIncntVO) {
		this.trsStatusIncntVO = trsStatusIncntVO;
	}
	public VslStatusIncntVO getVslStatusIncntVO() {
		return vslStatusIncntVO;
	}
	public void setVslStatusIncntVO(VslStatusIncntVO vslStatusIncntVO) {
		this.vslStatusIncntVO = vslStatusIncntVO;
	}
	
	public BnfStatusMlgVO[] getBnfStatusMlgVOs() {
		BnfStatusMlgVO[] rtnVOs = null;
		if(this.bnfStatusMlgVOs != null){
			rtnVOs = new BnfStatusMlgVO[bnfStatusMlgVOs.length];
			System.arraycopy(bnfStatusMlgVOs,0,rtnVOs,0,rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setBnfStatusMlgVOs(BnfStatusMlgVO[] bnfStatusMlgVOs) {
		if(bnfStatusMlgVOs!=null){
			BnfStatusMlgVO[] tmpVOs = Arrays.copyOf(bnfStatusMlgVOs,bnfStatusMlgVOs.length);
			this.bnfStatusMlgVOs = tmpVOs;
		}
	}
	
	public MnrStatusCrIssVO[] getMnrStatusCrIssVOs() {
		MnrStatusCrIssVO[] rtnVOs = null;
		if(this.mnrStatusCrIssVOs != null){
			rtnVOs = new MnrStatusCrIssVO[mnrStatusCrIssVOs.length];
			System.arraycopy(mnrStatusCrIssVOs,0,rtnVOs,0,rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setMnrStatusCrIssVOs(MnrStatusCrIssVO[] mnrStatusCrIssVOs) {
		if(mnrStatusCrIssVOs!=null){
			MnrStatusCrIssVO[] tmpVOs = Arrays.copyOf(mnrStatusCrIssVOs,mnrStatusCrIssVOs.length);
			this.mnrStatusCrIssVOs = tmpVOs;			
		}
	}
	
	public MnrStatusCrUsdVO[] getMnrStatusCrUsdVOs() {
		MnrStatusCrUsdVO[] rtnVOs = null;
		if(this.mnrStatusCrUsdVOs != null){
			rtnVOs = new MnrStatusCrUsdVO[mnrStatusCrUsdVOs.length];
			System.arraycopy(mnrStatusCrUsdVOs,0,rtnVOs,0,rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setMnrStatusCrUsdVOs(MnrStatusCrUsdVO[] mnrStatusCrUsdVOs) {
		if(mnrStatusCrUsdVOs != null){
			MnrStatusCrUsdVO[] tmpVOs = Arrays.copyOf(mnrStatusCrUsdVOs,mnrStatusCrUsdVOs.length);
			this.mnrStatusCrUsdVOs = tmpVOs;
		}
	}
	
	public TesStatusIncntVO[] getTesStatusIncntVOs() {
		TesStatusIncntVO[] rtnVOs = null;
		if(this.tesStatusIncntVOs != null){
			rtnVOs = new TesStatusIncntVO[tesStatusIncntVOs.length];
			System.arraycopy(tesStatusIncntVOs,0,rtnVOs,0,rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTesStatusIncntVOs(TesStatusIncntVO[] tesStatusIncntVOs) {
		if(tesStatusIncntVOs != null){
			TesStatusIncntVO[] tmpVOs = Arrays.copyOf(tesStatusIncntVOs,tesStatusIncntVOs.length);
			this.tesStatusIncntVOs = tmpVOs;
		}
	}
	
	public TrsStatusIncntVO[] getTrsStatusIncntVOs() {
		TrsStatusIncntVO[] rtnVOs = null;
		if(this.trsStatusIncntVOs != null){
			rtnVOs = new TrsStatusIncntVO[trsStatusIncntVOs.length];
			System.arraycopy(trsStatusIncntVOs,0,rtnVOs,0,rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTrsStatusIncntVOs(TrsStatusIncntVO[] trsStatusIncntVOs) {
		if(trsStatusIncntVOs != null){
			TrsStatusIncntVO[] tmpVOs = Arrays.copyOf(trsStatusIncntVOs,trsStatusIncntVOs.length);
			this.trsStatusIncntVOs = tmpVOs;
		}
	}
	
	public VslStatusIncntVO[] getVslStatusIncntVOs() {
		VslStatusIncntVO[] rtnVOs = null;
		if(this.vslStatusIncntVOs != null){
			rtnVOs = new VslStatusIncntVO[vslStatusIncntVOs.length];
			System.arraycopy(vslStatusIncntVOs,0,rtnVOs,0,rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVslStatusIncntVOs(VslStatusIncntVO[] vslStatusIncntVOs) {
		if(vslStatusIncntVOs != null){
			VslStatusIncntVO[] tmpVOs = Arrays.copyOf(vslStatusIncntVOs,vslStatusIncntVOs.length);
			this.vslStatusIncntVOs = tmpVOs;
		}
	}
}	
	