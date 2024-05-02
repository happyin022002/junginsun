/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce9999Event.java
*@FileTitle : Bkg Cop Manage Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.21 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.ManRplnRsltVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.SceActTmlRtvVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SceBkgOpHisVO;
import com.clt.syscommon.common.table.SceCopHdrVO;


/**
 * ESD_SCE_9999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_9999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim In-soo
 * @see ESD_SCE_9999HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce9999Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String fmDt = "";
	/**
	 * @return the fm_dt
	 */
	public String getFmDt() {
		return fmDt;
	}

	/**
	 * @param fmDt the fm_dt to set
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}

//	private String to_dt = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SceCopHdrVO sceCopHdrVO = null;
	
	private BkgCopManageVO bkgCopManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SceCopHdrVO[] sceCopHdrVOs = null;
	
	private BkgCopManageVO[] bkgCopManageVOs = null;
	
	private SceActTmlRtvVO[] sceActTmlRtvVOs = null;
	
	private ManRplnRsltVO[] manRplnRsltVOs = null;
	
	/**
	 * @return the manRplnRsltVOs
	 */
	public ManRplnRsltVO[] getManRplnRsltVOs() {
		ManRplnRsltVO[] rtnVOs = null;
		if (this.manRplnRsltVOs != null) {
			rtnVOs = Arrays.copyOf(manRplnRsltVOs, manRplnRsltVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manRplnRsltVOs the manRplnRsltVOs to set
	 */
	public void setManRplnRsltVOs(ManRplnRsltVO[] ManRplnRsltVO) {
		if(ManRplnRsltVO != null){
			ManRplnRsltVO[] tmpVOs = Arrays.copyOf(ManRplnRsltVO, ManRplnRsltVO.length);
			this.manRplnRsltVOs = tmpVOs;
		}
	}

	/**
	 * @return the sceActTmlIfDtlVOs
	 */
	public SceActTmlRtvVO[] getSceActTmlIfDtlVOs() {
		SceActTmlRtvVO[] rtnVOs = null;
		if (this.sceActTmlRtvVOs != null) {
			rtnVOs = Arrays.copyOf(sceActTmlRtvVOs, sceActTmlRtvVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param sceActTmlIfDtlVOs the sceActTmlIfDtlVOs to set
	 */
	public void setSceActTmlIfDtlVOs(SceActTmlRtvVO[] sceActTmlIfDtlVOs) {
		if(sceActTmlIfDtlVOs != null){
			SceActTmlRtvVO[] tmpVOs = Arrays.copyOf(sceActTmlIfDtlVOs, sceActTmlIfDtlVOs.length);
			this.sceActTmlRtvVOs = tmpVOs;
		}
	}

	private SceBkgOpHisVO sceBkgOpHisVO = null;
	
	/**
	 * @return the sceBkgOpHisVO
	 */
	public SceBkgOpHisVO getSceBkgOpHisVO() {
		return sceBkgOpHisVO;
	}

	/**
	 * @param sceBkgOpHisVO the sceBkgOpHisVO to set
	 */
	public void setSceBkgOpHisVO(SceBkgOpHisVO sceBkgOpHisVO) {
		this.sceBkgOpHisVO = sceBkgOpHisVO;
	}

	/**
	 * @return the sceBkgOpHisVOs
	 */
	public SceBkgOpHisVO[] getSceBkgOpHisVOs() {
		SceBkgOpHisVO[] rtnVOs = null;
		if (this.sceBkgOpHisVOs != null) {
			rtnVOs = Arrays.copyOf(sceBkgOpHisVOs, sceBkgOpHisVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param sceBkgOpHisVOs the sceBkgOpHisVOs to set
	 */
	public void setSceBkgOpHisVOs(SceBkgOpHisVO[] sceBkgOpHisVOs) {
		if(sceBkgOpHisVOs != null){
			SceBkgOpHisVO[] tmpVOs = Arrays.copyOf(sceBkgOpHisVOs, sceBkgOpHisVOs.length);
			this.sceBkgOpHisVOs = tmpVOs;
		}
	}

	private SceBkgOpHisVO[] sceBkgOpHisVOs = null;
	

	public EsdSce9999Event(){}
	
	public void setSceCopHdrVO(SceCopHdrVO sceCopHdrVO){
		this. sceCopHdrVO = sceCopHdrVO;
	}

	public void setSceCopHdrVOS(SceCopHdrVO[] sceCopHdrVOs){
		if(sceCopHdrVOs != null){
			SceCopHdrVO[] tmpVOs = Arrays.copyOf(sceCopHdrVOs, sceCopHdrVOs.length);
			this.sceCopHdrVOs = tmpVOs;
		}
	}

	public SceCopHdrVO getSceCopHdrVO(){
		return sceCopHdrVO;
	}

	public SceCopHdrVO[] getSceCopHdrVOS(){
		SceCopHdrVO[] rtnVOs = null;
		if (this.sceCopHdrVOs != null) {
			rtnVOs = Arrays.copyOf(sceCopHdrVOs, sceCopHdrVOs.length);
		}
		return rtnVOs;
	}
	
	
	public void setBkgCopManageVO(BkgCopManageVO bkgCopManageVO){
		this. bkgCopManageVO = bkgCopManageVO;
	}

	public void setBkgCopManageVOS(BkgCopManageVO[] bkgCopManageVOs){
		if(bkgCopManageVOs != null){
			BkgCopManageVO[] tmpVOs = Arrays.copyOf(bkgCopManageVOs, bkgCopManageVOs.length);
			this.bkgCopManageVOs = tmpVOs;
		}
	}

	public BkgCopManageVO getBkgCopManageVO(){
		return bkgCopManageVO;
	}

	public BkgCopManageVO[] getBkgCopManageVOS(){
		BkgCopManageVO[] rtnVOs = null;
		if (this.bkgCopManageVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCopManageVOs, bkgCopManageVOs.length);
		}
		return rtnVOs;
	}
	
    public String getEventName() {
        return "EsdSce9999Event";
    }


}