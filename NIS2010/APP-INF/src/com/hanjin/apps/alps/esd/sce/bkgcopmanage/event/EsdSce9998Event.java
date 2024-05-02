/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce9998Event.java
*@FileTitle : Bkg Cop Manage Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.21 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.event;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SceCopHdrVO;


/**
 * ESD_SCE_9998 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_9998HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim In-soo
 * @see ESD_SCE_9998HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce9998Event extends EventSupport {

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

	public EsdSce9998Event(){}
	
	public void setSceCopHdrVO(SceCopHdrVO sceCopHdrVO){
		this. sceCopHdrVO = sceCopHdrVO;
	}

	public void setSceCopHdrVOS(SceCopHdrVO[] sceCopHdrVOs){
		this. sceCopHdrVOs = sceCopHdrVOs;
	}

	public SceCopHdrVO getSceCopHdrVO(){
		return sceCopHdrVO;
	}

	public SceCopHdrVO[] getSceCopHdrVOS(){
		return sceCopHdrVOs;
	}
	
	
	public void setBkgCopManageVO(BkgCopManageVO bkgCopManageVO){
		this. bkgCopManageVO = bkgCopManageVO;
	}

	public void setBkgCopManageVOS(BkgCopManageVO[] bkgCopManageVOs){
		this. bkgCopManageVOs = bkgCopManageVOs;
	}

	public BkgCopManageVO getBkgCopManageVO(){
		return bkgCopManageVO;
	}

	public BkgCopManageVO[] getBkgCopManageVOS(){
		return bkgCopManageVOs;
	}
	
    public String getEventName() {
        return "EsdSce9998Event";
    }


}