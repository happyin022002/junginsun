/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0090Event.java
*@FileTitle : Special Stowage Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgCgoApplVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgStwgCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;

/**
 * ESM_BKG_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu 
 * @see ESM_BKG_0090HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0090Event extends EventSupport {
 
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgComboVO bkgComboVO = null;
	private StwgCgoApplVO stwgCgoApplVO = null;
	private BkgStwgCgoVO bkgStwgCgoVO = null;
	private SpclReqInVO spclReqInVO =  null;

	/** Table Value Object Multi Data 처리 */
	private BkgComboVO[] bkgComboVOs = null;
	private StwgCgoApplVO[] stwgCgoApplVOs = null;
	private BkgStwgCgoVO[] bkgStwgCgoVOs = null;
	private SpclReqInVO[] spclReqInVOs =  null;
	
//	private SearchCntrInfoVO searchCntrInfoVO = null;
//	private SearchCntrInfoVO[] searchCntrInfoVOs = null;
//	private SearchStwgInfoVO searchStwgInfoVO = null;
//	private SearchStwgInfoVO[] searchStwgInfoVOs = null;
	
	private String bkgNo = null;
	private String stwgCd = null;
	private String stwgRmk = null;
    private String button = null;

	public EsmBkg0090Event(){}

	public void setBkgComboVO(BkgComboVO bkgComboVO){
		this. bkgComboVO = bkgComboVO;
	}

	public void setBkgComboVOS(BkgComboVO[] bkgComboVOs){
		if(bkgComboVOs != null){
			BkgComboVO[] tmpVOs = Arrays.copyOf(bkgComboVOs, bkgComboVOs.length);
			this.bkgComboVOs = tmpVOs;
		}
	}

	public BkgComboVO getBkgComboVO(){
		return bkgComboVO;
	}

	public BkgComboVO[] getBkgComboVOS(){
		BkgComboVO[] rtnVOs = null;
		if (this.bkgComboVOs != null) {
			rtnVOs = Arrays.copyOf(bkgComboVOs, bkgComboVOs.length);
		}
		return rtnVOs;
	}

//	public void setSearchCntrInfoVO(SearchCntrInfoVO searchCntrInfoVO){
//		this. searchCntrInfoVO = searchCntrInfoVO;
//	}
//
//	public void setSearchCntrInfoVOS(SearchCntrInfoVO[] searchCntrInfoVOs){
//		this. searchCntrInfoVOs = searchCntrInfoVOs;
//	}
//
//	public SearchCntrInfoVO getSearchCntrInfoVO(){
//		return searchCntrInfoVO;
//	}
//
//	public SearchCntrInfoVO[] getSearchCntrInfoVOS(){
//		return searchCntrInfoVOs;
//	}	
//
//	public void setSearchStwgInfoVO(SearchStwgInfoVO searchStwgInfoVO){
//		this. searchStwgInfoVO = searchStwgInfoVO;
//	}
//
//	public void setSearchStwgInfoVOS(SearchStwgInfoVO[] searchStwgInfoVOs){
//		this. searchStwgInfoVOs = searchStwgInfoVOs;
//	}
//
//	public SearchStwgInfoVO getSearchStwgInfoVO(){
//		return searchStwgInfoVO;
//	}
//
//	public SearchStwgInfoVO[] getSearchStwgInfoVOS(){
//		return searchStwgInfoVOs;
//	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getStwgCd() {
		return stwgCd;
	}

	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}

	public String getStwgRmk() {
		return stwgRmk;
	}

	public void setStwgRmk(String stwgRmk) {
		this.stwgRmk = stwgRmk;
	}

	public StwgCgoApplVO getStwgCgoApplVO() {
		return stwgCgoApplVO;
	}

	public void setStwgCgoApplVO(StwgCgoApplVO stwgCgoApplVO) {
		this.stwgCgoApplVO = stwgCgoApplVO;
	}

	public BkgStwgCgoVO getBkgStwgCgoVO() {
		return bkgStwgCgoVO;
	}

	public void setBkgStwgCgoVO(BkgStwgCgoVO bkgStwgCgoVO) {
		this.bkgStwgCgoVO = bkgStwgCgoVO;
	}

	public StwgCgoApplVO[] getStwgCgoApplVOs() {
		StwgCgoApplVO[] rtnVOs = null;
		if (this.stwgCgoApplVOs != null) {
			rtnVOs = Arrays.copyOf(stwgCgoApplVOs, stwgCgoApplVOs.length);
		}
		return rtnVOs;
	}

	public void setStwgCgoApplVOs(StwgCgoApplVO[] stwgCgoApplVOs) {
		if(spclReqInVOs != null){
			StwgCgoApplVO[] tmpVOs = Arrays.copyOf(stwgCgoApplVOs, stwgCgoApplVOs.length);
			this.stwgCgoApplVOs = tmpVOs;
		}
	}

	public BkgStwgCgoVO[] getBkgStwgCgoVOs() {
		BkgStwgCgoVO[] rtnVOs = null;
		if (this.bkgStwgCgoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgStwgCgoVOs, bkgStwgCgoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgStwgCgoVOs(BkgStwgCgoVO[] bkgStwgCgoVOs) {
		if(bkgStwgCgoVOs != null){
			BkgStwgCgoVO[] tmpVOs = Arrays.copyOf(bkgStwgCgoVOs, bkgStwgCgoVOs.length);
			this.bkgStwgCgoVOs = tmpVOs;
		}
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public SpclReqInVO getSpclReqInVO() {
		return spclReqInVO;
	}

	public void setSpclReqInVO(SpclReqInVO spclReqInVO) {
		this.spclReqInVO = spclReqInVO;
	}

	public SpclReqInVO[] getSpclReqInVOs() {
		SpclReqInVO[] rtnVOs = null;
		if (this.spclReqInVOs != null) {
			rtnVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
		}
		return rtnVOs;
	}

	public void setSpclReqInVOs(SpclReqInVO[] spclReqInVOs) {
		if(spclReqInVOs != null){
			SpclReqInVO[] tmpVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
			this.spclReqInVOs = tmpVOs;
		}
	}

}