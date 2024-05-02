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
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event;

import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.ManRplnRsltVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SceActTmlIfVO;
import com.hanjin.syscommon.common.table.SceBkgOpHisVO;


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
	
	private SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO = null;
	
	public SearchLeaMonthlyWorkVO getSearchLeaMonthlyWorkVO() {
		return searchLeaMonthlyWorkVO;
	}

	public void setSearchLeaMonthlyWorkVO(
			SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO) {
		this.searchLeaMonthlyWorkVO = searchLeaMonthlyWorkVO;
	}

	public SearchLeaMonthlyWorkVO[] getSearchLeaMonthlyWorkVOs() {
		return searchLeaMonthlyWorkVOs;
	}

	public void setSearchLeaMonthlyWorkVOs(
			SearchLeaMonthlyWorkVO[] searchLeaMonthlyWorkVOs) {
		this.searchLeaMonthlyWorkVOs = searchLeaMonthlyWorkVOs;
	}

	private SearchLeaMonthlyWorkVO[] searchLeaMonthlyWorkVOs = null;
	
	private String leaAccMon = null;
	
	public String getLeaAccMon() {
		return leaAccMon;
	}

	public void setLeaAccMon(String leaAccMon) {
		this.leaAccMon = leaAccMon;
	}

	/**
	 * 
	 */
	private SceBkgOpHisVO[] sceBkgOpHisVOs = null;
	
	/**
	 * @return the sceBkgOpHisVOs
	 */
	public SceBkgOpHisVO[] getSceBkgOpHisVOs() {
		return sceBkgOpHisVOs;
	}

	/**
	 * @param sceBkgOpHisVOs the sceBkgOpHisVOs to set
	 */
	public void setSceBkgOpHisVOs(SceBkgOpHisVO[] sceBkgOpHisVOs) {
		this.sceBkgOpHisVOs = sceBkgOpHisVOs;
	}

	/**
	 * @return the sceAdminObjVOs
	 */
	public SceAdminObjVO[] getSceAdminObjVOs() {
		return sceAdminObjVOs;
	}

	/**
	 * @param sceAdminObjVOs the sceAdminObjVOs to set
	 */
	public void setSceAdminObjVOs(SceAdminObjVO[] sceAdminObjVOs) {
		this.sceAdminObjVOs = sceAdminObjVOs;
	}

	/**
	 * @return the manRplnRslvVOs
	 */
	public ManRplnRsltVO[] getManRplnRsltVOs() {
		return manRplnRsltVOs;
	}

	/**
	 * @param manRplnRslvVOs the manRplnRslvVOs to set
	 */
	public void setManRplnRsltVOs(ManRplnRsltVO[] manRplnRslvVOs) {
		this.manRplnRsltVOs = manRplnRslvVOs;
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
		return sceActTmlIfVOs;
	}

	/**
	 * @param sceActTmlIfVOs the sceActTmlIfVOs to set
	 */
	public void setSceActTmlIfVOs(SceActTmlIfVO[] sceActTmlIfVOs) {
		this.sceActTmlIfVOs = sceActTmlIfVOs;
	}

	/** Table Value Object Multi Data 처리 */
	private SceActTmlIfVO[] sceActTmlIfVOs = null;
	
	public EsdSce6000Event(){}
	
	public void setSceAdminObjVO(SceAdminObjVO SceAdminObjVO){
		this. sceAdminObjVO = SceAdminObjVO;
	}

	public void setSceAdminObjVOS(SceAdminObjVO[] SceAdminObjVOs){
		this. sceAdminObjVOs = SceAdminObjVOs;
	}

	public SceAdminObjVO getSceAdminObjVO(){
		return sceAdminObjVO;
	}

	public SceAdminObjVO[] getSceAdminObjVOS(){
		return sceAdminObjVOs;
	}
	
	

}