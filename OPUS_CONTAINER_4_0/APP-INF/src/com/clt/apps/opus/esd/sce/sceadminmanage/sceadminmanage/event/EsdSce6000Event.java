/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdSce6000Event.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.02 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.ManRplnRsltVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SceActTmlIfVO;
import com.clt.syscommon.common.table.SceBkgOpHisVO;


/**
 * ESD_SCE_6000 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_6000HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim In-soo
 * @see ESD_SCE_6000HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce6000Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SceAdminObjVO sceAdminObjVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SceAdminObjVO[] sceAdminObjVOs = null;
	
	/**
	 * 
	 */
	private SceBkgOpHisVO[] sceBkgOpHisVOs = null;
	
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

	/**
	 * @return the sceAdminObjVOs
	 */
	public SceAdminObjVO[] getSceAdminObjVOs() {
		SceAdminObjVO[] rtnVOs = null;
		if (this.sceAdminObjVOs != null) {
			rtnVOs = Arrays.copyOf(sceAdminObjVOs, sceAdminObjVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param sceAdminObjVOs the sceAdminObjVOs to set
	 */
	public void setSceAdminObjVOs(SceAdminObjVO[] sceAdminObjVOs) {
		if(sceAdminObjVOs != null){
			SceAdminObjVO[] tmpVOs = Arrays.copyOf(sceAdminObjVOs, sceAdminObjVOs.length);
			this.sceAdminObjVOs = tmpVOs;
		}
	}

	/**
	 * @return the manRplnRslvVOs
	 */
	public ManRplnRsltVO[] getManRplnRsltVOs() {
		ManRplnRsltVO[] rtnVOs = null;
		if (this.manRplnRsltVOs != null) {
			rtnVOs = Arrays.copyOf(manRplnRsltVOs, manRplnRsltVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manRplnRslvVOs the manRplnRslvVOs to set
	 */
	public void setManRplnRsltVOs(ManRplnRsltVO[] manRplnRslvVOs) {
		if(manRplnRslvVOs != null){
			ManRplnRsltVO[] tmpVOs = Arrays.copyOf(manRplnRslvVOs, manRplnRslvVOs.length);
			this.manRplnRsltVOs = tmpVOs;
		}
	}

	private ManRplnRsltVO[] manRplnRsltVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SceActTmlIfVO sceActTmlIfVO = null;
	
	/**
	 * @return the sceActTmlIfVO
	 */
	public SceActTmlIfVO getSceActTmlIfVO() {
		return sceActTmlIfVO;
	}

	/**
	 * @param sceActTmlIfVO the sceActTmlIfVO to set
	 */
	public void setSceActTmlIfVO(SceActTmlIfVO sceActTmlIfVO) {
		this.sceActTmlIfVO = sceActTmlIfVO;
	}

	/**
	 * @return the sceActTmlIfVOs
	 */
	public SceActTmlIfVO[] getSceActTmlIfVOs() {
		SceActTmlIfVO[] rtnVOs = null;
		if (this.sceActTmlIfVOs != null) {
			rtnVOs = Arrays.copyOf(sceActTmlIfVOs, sceActTmlIfVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param sceActTmlIfVOs the sceActTmlIfVOs to set
	 */
	public void setSceActTmlIfVOs(SceActTmlIfVO[] sceActTmlIfVOs) {
		if(sceActTmlIfVOs != null){
			SceActTmlIfVO[] tmpVOs = Arrays.copyOf(sceActTmlIfVOs, sceActTmlIfVOs.length);
			this.sceActTmlIfVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private SceActTmlIfVO[] sceActTmlIfVOs = null;
	
	public EsdSce6000Event(){}
	
	public void setSceAdminObjVO(SceAdminObjVO SceAdminObjVO){
		this. sceAdminObjVO = SceAdminObjVO;
	}

	public void setSceAdminObjVOS(SceAdminObjVO[] SceAdminObjVOs){
		if(SceAdminObjVOs != null){
			SceAdminObjVO[] tmpVOs = Arrays.copyOf(SceAdminObjVOs, SceAdminObjVOs.length);
			this.sceAdminObjVOs = tmpVOs;
		}
	}

	public SceAdminObjVO getSceAdminObjVO(){
		return sceAdminObjVO;
	}

	public SceAdminObjVO[] getSceAdminObjVOS(){
		SceAdminObjVO[] rtnVOs = null;
		if (this.sceAdminObjVOs != null) {
			rtnVOs = Arrays.copyOf(sceAdminObjVOs, sceAdminObjVOs.length);
		}
		return rtnVOs;
	}
	
	

}