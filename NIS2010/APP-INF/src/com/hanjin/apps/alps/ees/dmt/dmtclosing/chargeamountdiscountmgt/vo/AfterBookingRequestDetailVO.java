/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AfterBKGGRPVO.java
*@FileTitle : AfterBKGGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AfterBookingRequestDetailVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AfterBKGListInputVO inputVO = null;
	private AfterBookingReasonDescVO afterBookingReasonDescVO = null;
	
	private ActualCostListVO actualCostListVO = null;	
	private List<ActualCostListVO> actualCostListVOs = null;	

	private List<AfterBookingFullHistoryVO> afterBookingFullHistoryVOs = null;

	private AfterBookingReasonDetailVO afterBookingReasonDetailVO = null;
	private List<AfterBookingReasonDetailVO> afterBookingReasonDetailVOs = null;

	private List<AfterBookingFileListVO> afterBookingFileListVOs = null;
	
	private List<AfterBookingExptClrRqstVO> afterBookingExptClrRqstVOs = null;	

	private List<AfterBookingPfmcListVO> afterBookingPfmcListVOs = null;		

	private List<AfterBookingAproItmVO> afterBookingAproItmVOs = null;	
	
	private AfterProgressVO afterProgressVO = null;	

	private List<AfterBookingMasListVO> afterBookingMasListVOs = null;	
	
	
	public AfterBKGListInputVO getInputVO() {
		return inputVO;
	}
	public void setInputVO(AfterBKGListInputVO inputVO) {
		this.inputVO = inputVO;
	}	
	public AfterBookingReasonDescVO getAfterBookingReasonDescVO() {
		return afterBookingReasonDescVO;
	}
	public void setAfterBookingReasonDescVO(
			AfterBookingReasonDescVO afterBookingReasonDescVO) {
		this.afterBookingReasonDescVO = afterBookingReasonDescVO;
	}
	public ActualCostListVO getActualCostListVO() {
		return actualCostListVO;
	}
	public void setActualCostListVO(ActualCostListVO actualCostListVO) {
		this.actualCostListVO = actualCostListVO;
	}

	public void setActualCostListVOs(ActualCostListVO[] actualCostListVOs) {
		if (actualCostListVOs != null && actualCostListVOs.length > 0) {
			this.actualCostListVOs = new ArrayList<ActualCostListVO>();
			for (int i = 0 ; i < actualCostListVOs.length ; i++) {
				this.actualCostListVOs.add(actualCostListVOs[i]);
			}
		}
	}
	public List<ActualCostListVO> getActualCostListVOs() {
		return actualCostListVOs;
	}
	
	public List<AfterBookingFullHistoryVO> getAfterBookingFullHistoryVOs() {
		return afterBookingFullHistoryVOs;
	}
	public void setAfterBookingFullHistoryVOs(AfterBookingFullHistoryVO[] afterBookingFullHistoryVOs) {
		if (afterBookingFullHistoryVOs != null && afterBookingFullHistoryVOs.length > 0) {
			this.afterBookingFullHistoryVOs = new ArrayList<AfterBookingFullHistoryVO>();
			for (int i = 0 ; i < afterBookingFullHistoryVOs.length ; i++) {
				this.afterBookingFullHistoryVOs.add(afterBookingFullHistoryVOs[i]);
			}
		}
	}
	
	public AfterBookingReasonDetailVO getAfterBookingReasonDetailVO() {
		return afterBookingReasonDetailVO;
	}
	public void setAfterBookingReasonDetailVO(
			AfterBookingReasonDetailVO afterBookingReasonDetailVO) {
		this.afterBookingReasonDetailVO = afterBookingReasonDetailVO;
	}
	public List<AfterBookingReasonDetailVO> getAfterBookingReasonDetailVOs() {
		return afterBookingReasonDetailVOs;
	}
	public void setAfterBookingReasonDetailVOs(AfterBookingReasonDetailVO[] afterBookingReasonDetailVOs) {
		if (afterBookingReasonDetailVOs != null && afterBookingReasonDetailVOs.length > 0) {
			this.afterBookingReasonDetailVOs = new ArrayList<AfterBookingReasonDetailVO>();
			for (int i = 0 ; i < afterBookingReasonDetailVOs.length ; i++) {
				this.afterBookingReasonDetailVOs.add(afterBookingReasonDetailVOs[i]);
			}
		}
	}

	public List<AfterBookingFileListVO> getAfterBookingFileListVOs() {
		return afterBookingFileListVOs;
	}
	public void setAfterBookingFileListVOs(AfterBookingFileListVO[] afterBookingFileListVOs) {
		if (afterBookingFileListVOs != null && afterBookingFileListVOs.length > 0) {
			this.afterBookingFileListVOs = new ArrayList<AfterBookingFileListVO>();
			for (int i = 0 ; i < afterBookingFileListVOs.length ; i++) {
				this.afterBookingFileListVOs.add(afterBookingFileListVOs[i]);
			}
		}
	}
	
	public List<AfterBookingExptClrRqstVO> getAfterBookingExptClrRqstVOs() {
		return afterBookingExptClrRqstVOs;
	}
	public void setAfterBookingExptClrRqstVOs(AfterBookingExptClrRqstVO[] afterBookingExptClrRqstVOs) {
		if (afterBookingExptClrRqstVOs != null && afterBookingExptClrRqstVOs.length > 0) {
			this.afterBookingExptClrRqstVOs = new ArrayList<AfterBookingExptClrRqstVO>();
			for (int i = 0 ; i < afterBookingExptClrRqstVOs.length ; i++) {
				this.afterBookingExptClrRqstVOs.add(afterBookingExptClrRqstVOs[i]);
			}
		}
	}
	
	public List<AfterBookingPfmcListVO> getAfterBookingPfmcListVOs() {
		return afterBookingPfmcListVOs;
	}
	public void setAfterBookingPfmcListVOs(AfterBookingPfmcListVO[] afterBookingPfmcListVOs) {
		if (afterBookingPfmcListVOs != null && afterBookingPfmcListVOs.length > 0) {
			this.afterBookingPfmcListVOs = new ArrayList<AfterBookingPfmcListVO>();
			for (int i = 0 ; i < afterBookingPfmcListVOs.length ; i++) {
				this.afterBookingPfmcListVOs.add(afterBookingPfmcListVOs[i]);
			}
		}
	}
	public List<AfterBookingAproItmVO> getAfterBookingAproItmVOs() {
		return afterBookingAproItmVOs;
	}
	public void setAfterBookingAproItmVOs(AfterBookingAproItmVO[] afterBookingAproItmVOs) {
		if (afterBookingAproItmVOs != null && afterBookingAproItmVOs.length > 0) {
			this.afterBookingAproItmVOs = new ArrayList<AfterBookingAproItmVO>();
			for (int i = 0 ; i < afterBookingAproItmVOs.length ; i++) {
				this.afterBookingAproItmVOs.add(afterBookingAproItmVOs[i]);
			}
		}
	}
	public AfterProgressVO getAfterProgressVO() {
		return afterProgressVO;
	}
	public void setAfterProgressVO(AfterProgressVO afterProgressVO) {
		this.afterProgressVO = afterProgressVO;
	}
	
	public List<AfterBookingMasListVO> getAfterBookingMasListVOs() {
		return afterBookingMasListVOs;
	}
	public void setAfterBookingMasListVOs(AfterBookingMasListVO[] afterBookingMasListVOs) {
		if (afterBookingMasListVOs != null && afterBookingMasListVOs.length > 0) {
			this.afterBookingMasListVOs = new ArrayList<AfterBookingMasListVO>();
			for (int i = 0 ; i < afterBookingMasListVOs.length ; i++) {
				this.afterBookingMasListVOs.add(afterBookingMasListVOs[i]);
			}
		}
	}
	
	
}