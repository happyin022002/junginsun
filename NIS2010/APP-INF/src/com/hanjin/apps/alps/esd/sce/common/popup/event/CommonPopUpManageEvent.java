/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageEvent.java
*@FileTitle : EsdSce0103
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.28 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.event;

import com.hanjin.apps.alps.esd.sce.common.popup.vo.COPSummaryVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComMailManagementConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SCNOManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiInfoVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiManageVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmDataVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmInfoVO;
import com.hanjin.apps.alps.esd.sce.common.util.vo.CodeUtilVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EsdSce0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsdSce0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Shin Han Sung
 * @see EsdSce0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSceClmInfoVO sceClmInfo = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSceClmDataVO sceClmeData = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComVvdManagementVO comVvdManagementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComVvdManagementVO[] comVvdManagementVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComVvdManagementConditionVO comVvdManagementConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComVvdManagementConditionVO[] comVvdManagementConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComOfficeManagementVO comOfficeManagementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComOfficeManagementVO[] comOfficeManagementVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CodeUtilVO codeUtilVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private COPSummaryVO copSummaryVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCNOManagementVO sCNOManagementVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComMailManagementConditionVO comMailManagementConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String bkgNo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchContiInfoVO contiInfo = null; 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchContiManageVO contiManage = null;
	
	public CommonPopUpManageEvent(){}
	
	public ComOfficeManagementVO getComOfficeManagementVO() {
		return comOfficeManagementVO;
	}
	
	public void setComOfficeManagementVO(ComOfficeManagementVO comOfficeManagementVO) {
		this.comOfficeManagementVO = comOfficeManagementVO;
	}

	public ComOfficeManagementVO[] getComOfficeManagementVOs() {
		return comOfficeManagementVOs;
	}

	public void setComOfficeManagementVOs(
			ComOfficeManagementVO[] comOfficeManagementVOs) {
		this.comOfficeManagementVOs = comOfficeManagementVOs;
	}

	public ComVvdManagementConditionVO getComVvdManagementConditionVO() {
		return comVvdManagementConditionVO;
	}

	public void setComVvdManagementConditionVO(
			ComVvdManagementConditionVO comVvdManagementConditionVO) {
		this.comVvdManagementConditionVO = comVvdManagementConditionVO;
	}

	public ComVvdManagementConditionVO[] getComVvdManagementConditionVOs() {
		return comVvdManagementConditionVOs;
	}

	public void setComVvdManagementConditionVOs(
			ComVvdManagementConditionVO[] comVvdManagementConditionVOs) {
		this.comVvdManagementConditionVOs = comVvdManagementConditionVOs;
	}

	public void setComVvdManagementVO(ComVvdManagementVO comVvdManagementVO){
		this. comVvdManagementVO = comVvdManagementVO;
	}

	public void setComVvdManagementVOS(ComVvdManagementVO[] comVvdManagementVOs){
		this. comVvdManagementVOs = comVvdManagementVOs;
	}

	public ComVvdManagementVO getComVvdManagementVO(){
		return comVvdManagementVO;
	}

	public ComVvdManagementVO[] getComVvdManagementVOS(){
		return comVvdManagementVOs;
	}

	public CodeUtilVO getCodeUtilVO() {
		return codeUtilVO;
	}

	public void setCodeUtilVO(CodeUtilVO codeUtilVO) {
		this.codeUtilVO = codeUtilVO;
	}
	
	public COPSummaryVO getCopSummaryVO() {
		return copSummaryVO;
	}

	public void setCopSummaryVO(COPSummaryVO copSummaryVO) {
		this.copSummaryVO = copSummaryVO;
	}

	public SCNOManagementVO getSCNOManagementVO() {
		return sCNOManagementVO;
	}

	public void setSCNOManagementVO(SCNOManagementVO managementVO) {
		sCNOManagementVO = managementVO;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public ComMailManagementConditionVO getComMailManagementConditionVO() {
		return comMailManagementConditionVO;
	}

	public void setComMailManagementConditionVO(
			ComMailManagementConditionVO comMailManagementConditionVO) {
		this.comMailManagementConditionVO = comMailManagementConditionVO;
	}

	public SearchSceClmInfoVO getSceClmInfo() {
		return sceClmInfo;
	}

	public void setSceClmInfo(SearchSceClmInfoVO sceClmInfo) {
		this.sceClmInfo = sceClmInfo;
	}

	public SearchSceClmDataVO getSceClmeData() {
		return sceClmeData;
	}

	public void setSceClmeData(SearchSceClmDataVO sceClmeData) {
		this.sceClmeData = sceClmeData;
	}

	public SearchContiInfoVO getContiInfo() {
		return contiInfo;
	}

	public void setContiInfo(SearchContiInfoVO contiInfo) {
		this.contiInfo = contiInfo;
	}

	public SearchContiManageVO getContiManage() {
		return contiManage;
	}

	public void setContiManage(SearchContiManageVO contiManage) {
		this.contiManage = contiManage;
	}

}