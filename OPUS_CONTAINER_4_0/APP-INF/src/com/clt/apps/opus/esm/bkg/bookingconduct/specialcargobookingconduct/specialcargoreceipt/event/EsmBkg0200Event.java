/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0200Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrInfoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0200 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0200HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu 
 * @see ESM_BKG_0200HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg0200Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DgAproInfoVO dgAproInfoVO = null;
	private CntrInfoListVO cntrInfoListVO = null;
	private DgCgoApplVO dgCgoApplVO = null;
	private BkgDgCgoInfoVO bkgDgCgoInfoVO = null;
	private CntrTypzQtyVO cntrTypzQtyVO = null;
	private DgBkgInfoVO dgBkgInfoVO = null;	
	private DgCgoListVO dgCgoListVO = null;	
	private BkgComboVO bkgcomboVO = null;
	private SpclReqInVO spclReqInVO =  null;
	private String bkgNo = null;
    private String blNo = null;
    private String dcgoSeq = null;
    private String evntUsrId = null;
    private String evntDt = null;
    private String dgCgoSeq = null;
    private String dgPkgTpCd = null;
    private String button = null;
    private String dgChkFlg = null;
    private String saveButton = null;

	/** Table Value Object Multi Data 처리 */
    private DgAproInfoVO[] dgAproInfoVOs = null;
	private CntrInfoListVO[] cntrInfoListVOs = null;
	private DgCgoApplVO[] dgCgoApplVOs = null;
	private BkgDgCgoInfoVO[] bkgDgCgoInfoVOs = null;
	private CntrTypzQtyVO[] cntrTypzQtyVOs = null;
	private DgBkgInfoVO[] dgBkgInfoVOs = null;	
	private DgCgoListVO[] dgCgoListVOs = null;	
	private BkgComboVO[] bkgcombovos = null;
	private SpclReqInVO[] spclReqInVOs =  null;
	
	public EsmBkg0200Event(){}

	/**
	 * @return the dgAproInfoVO
	 */
	public DgAproInfoVO getDgAproInfoVO() {
		return dgAproInfoVO;
	}

	/**
	 * @param dgAproInfoVO the dgAproInfoVO to set
	 */
	public void setDgAproInfoVO(DgAproInfoVO dgAproInfoVO) {
		this.dgAproInfoVO = dgAproInfoVO;
	}

	/**
	 * @return the cntrInfoListVO
	 */
	public CntrInfoListVO getCntrInfoListVO() {
		return cntrInfoListVO;
	}

	/**
	 * @param cntrInfoListVO the cntrInfoListVO to set
	 */
	public void setCntrInfoListVO(CntrInfoListVO cntrInfoListVO) {
		this.cntrInfoListVO = cntrInfoListVO;
	}

	/**
	 * @return the dgCgoApplVO
	 */
	public DgCgoApplVO getDgCgoApplVO() {
		return dgCgoApplVO;
	}

	/**
	 * @param dgCgoApplVO the dgCgoApplVO to set
	 */
	public void setDgCgoApplVO(DgCgoApplVO dgCgoApplVO) {
		this.dgCgoApplVO = dgCgoApplVO;
	}

	/**
	 * @return the bkgDgCgoInfoVO
	 */
	public BkgDgCgoInfoVO getBkgDgCgoInfoVO() {
		return bkgDgCgoInfoVO;
	}

	/**
	 * @param bkgDgCgoInfoVO the bkgDgCgoInfoVO to set
	 */
	public void setBkgDgCgoInfoVO(BkgDgCgoInfoVO bkgDgCgoInfoVO) {
		this.bkgDgCgoInfoVO = bkgDgCgoInfoVO;
	}

	/**
	 * @return the cntrTypzQtyVO
	 */
	public CntrTypzQtyVO getCntrTypzQtyVO() {
		return cntrTypzQtyVO;
	}

	/**
	 * @param cntrTypzQtyVO the cntrTypzQtyVO to set
	 */
	public void setCntrTypzQtyVO(CntrTypzQtyVO cntrTypzQtyVO) {
		this.cntrTypzQtyVO = cntrTypzQtyVO;
	}

	/**
	 * @return the dgBkgInfoVO
	 */
	public DgBkgInfoVO getDgBkgInfoVO() {
		return dgBkgInfoVO;
	}

	/**
	 * @param dgBkgInfoVO the dgBkgInfoVO to set
	 */
	public void setDgBkgInfoVO(DgBkgInfoVO dgBkgInfoVO) {
		this.dgBkgInfoVO = dgBkgInfoVO;
	}

	/**
	 * @return the bkgcomboVO
	 */
	public BkgComboVO getBkgcomboVO() {
		return bkgcomboVO;
	}

	/**
	 * @param bkgcomboVO the bkgcomboVO to set
	 */
	public void setBkgcomboVO(BkgComboVO bkgcomboVO) {
		this.bkgcomboVO = bkgcomboVO;
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the evntUsrId
	 */
	public String getEvntUsrId() {
		return evntUsrId;
	}

	/**
	 * @param evntUsrId the evntUsrId to set
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}

	/**
	 * @return the evntDt
	 */
	public String getEvntDt() {
		return evntDt;
	}
	/**
	 * @param evntDt the evntDt to set
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(String button) {
		this.button = button;
	}
	
	/**
	 * @return the button
	 */
	public String getButton() {
		return button;
	}


	/**
	 * @return the dgCgoSeq
	 */
	public String getDgCgoSeq() {
		return dgCgoSeq;
	}

	/**
	 * @param dgCgoSeq the dgCgoSeq to set
	 */
	public void setDgCgoSeq(String dgCgoSeq) {
		this.dgCgoSeq = dgCgoSeq;
	}

	/**
	 * @return the dgPkgTpCd
	 */
	public String getDgPkgTpCd() {
		return dgPkgTpCd;
	}

	/**
	 * @param dgPkgTpCd the dgPkgTpCd to set
	 */
	public void setDgPkgTpCd(String dgPkgTpCd) {
		this.dgPkgTpCd = dgPkgTpCd;
	}

	/**
	 * @return the dgAproInfoVOs
	 */
	public DgAproInfoVO[] getDgAproInfoVOs() {
		DgAproInfoVO[] rtnVOs = null;
		if (this.dgAproInfoVOs != null) {
			rtnVOs = Arrays.copyOf(dgAproInfoVOs, dgAproInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgAproInfoVOs the dgAproInfoVOs to set
	 */
	public void setDgAproInfoVOs(DgAproInfoVO[] dgAproInfoVOs) {
		if(dgAproInfoVOs != null){
			DgAproInfoVO[] tmpVOs = Arrays.copyOf(dgAproInfoVOs, dgAproInfoVOs.length);
			this.dgAproInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the cntrInfoListVOs
	 */
	public CntrInfoListVO[] getCntrInfoListVOs() {
		CntrInfoListVO[] rtnVOs = null;
		if (this.cntrInfoListVOs != null) {
			rtnVOs = Arrays.copyOf(cntrInfoListVOs, cntrInfoListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param cntrInfoListVOs the cntrInfoListVOs to set
	 */
	public void setCntrInfoListVOs(CntrInfoListVO[] cntrInfoListVOs) {
		if(cntrInfoListVOs != null){
			CntrInfoListVO[] tmpVOs = Arrays.copyOf(cntrInfoListVOs, cntrInfoListVOs.length);
			this.cntrInfoListVOs = tmpVOs;
		}
	}

	/**
	 * @return the dgCgoApplVOs
	 */
	public DgCgoApplVO[] getDgCgoApplVOs() {
		DgCgoApplVO[] rtnVOs = null;
		if (this.dgCgoApplVOs != null) {
			rtnVOs = Arrays.copyOf(dgCgoApplVOs, dgCgoApplVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgCgoApplVOs the dgCgoApplVOs to set
	 */
	public void setDgCgoApplVOs(DgCgoApplVO[] dgCgoApplVOs) {
		if(dgCgoApplVOs != null){
			DgCgoApplVO[] tmpVOs = Arrays.copyOf(dgCgoApplVOs, dgCgoApplVOs.length);
			this.dgCgoApplVOs = tmpVOs;
		}
	}

	/**
	 * @return the bkgDgCgoInfoVOs
	 */
	public BkgDgCgoInfoVO[] getBkgDgCgoInfoVOs() {
		BkgDgCgoInfoVO[] rtnVOs = null;
		if (this.bkgDgCgoInfoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgDgCgoInfoVOs, bkgDgCgoInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgDgCgoInfoVOs the bkgDgCgoInfoVOs to set
	 */
	public void setBkgDgCgoInfoVOs(BkgDgCgoInfoVO[] bkgDgCgoInfoVOs) {
		if(bkgDgCgoInfoVOs != null){
			BkgDgCgoInfoVO[] tmpVOs = Arrays.copyOf(bkgDgCgoInfoVOs, bkgDgCgoInfoVOs.length);
			this.bkgDgCgoInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the cntrTypzQtyVOs
	 */
	public CntrTypzQtyVO[] getCntrTypzQtyVOs() {
		CntrTypzQtyVO[] rtnVOs = null;
		if (this.cntrTypzQtyVOs != null) {
			rtnVOs = Arrays.copyOf(cntrTypzQtyVOs, cntrTypzQtyVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param cntrTypzQtyVOs the cntrTypzQtyVOs to set
	 */
	public void setCntrTypzQtyVOs(CntrTypzQtyVO[] cntrTypzQtyVOs) {
		if(cntrTypzQtyVOs != null){
			CntrTypzQtyVO[] tmpVOs = Arrays.copyOf(cntrTypzQtyVOs, cntrTypzQtyVOs.length);
			this.cntrTypzQtyVOs = tmpVOs;
		}
	}

	/**
	 * @return the dgBkgInfoVOs
	 */
	public DgBkgInfoVO[] getDgBkgInfoVOs() {
		DgBkgInfoVO[] rtnVOs = null;
		if (this.dgBkgInfoVOs != null) {
			rtnVOs = Arrays.copyOf(dgBkgInfoVOs, dgBkgInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgBkgInfoVOs the dgBkgInfoVOs to set
	 */
	public void setDgBkgInfoVOs(DgBkgInfoVO[] dgBkgInfoVOs) {
		if(dgBkgInfoVOs != null){
			DgBkgInfoVO[] tmpVOs = Arrays.copyOf(dgBkgInfoVOs, dgBkgInfoVOs.length);
			this.dgBkgInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the bkgcombovos
	 */
	public BkgComboVO[] getBkgcombovos() {
		BkgComboVO[] rtnVOs = null;
		if (this.bkgcombovos != null) {
			rtnVOs = Arrays.copyOf(bkgcombovos, bkgcombovos.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgcombovos the bkgcombovos to set
	 */
	public void setBkgcombovos(BkgComboVO[] bkgcombovos) {
		if(bkgcombovos != null){
			BkgComboVO[] tmpVOs = Arrays.copyOf(bkgcombovos, bkgcombovos.length);
			this.bkgcombovos = tmpVOs;
		}
	}

	/**
	 * @return the dgCgoListVO
	 */
	public DgCgoListVO getDgCgoListVO() {
		return dgCgoListVO;
	}

	/**
	 * @param dgCgoListVO the dgCgoListVO to set
	 */
	public void setDgCgoListVO(DgCgoListVO dgCgoListVO) {
		this.dgCgoListVO = dgCgoListVO;
	}

	/**
	 * @return the dgCgoListVOs
	 */
	public DgCgoListVO[] getDgCgoListVOs() {
		DgCgoListVO[] rtnVOs = null;
		if (this.dgCgoListVOs != null) {
			rtnVOs = Arrays.copyOf(dgCgoListVOs, dgCgoListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgCgoListVOs the dgCgoListVOs to set
	 */
	public void setDgCgoListVOs(DgCgoListVO[] dgCgoListVOs) {
		if(dgCgoListVOs != null){
			DgCgoListVO[] tmpVOs = Arrays.copyOf(dgCgoListVOs, dgCgoListVOs.length);
			this.dgCgoListVOs = tmpVOs;
		}
	}

	/**
	 * @return the dcgoSeq
	 */
	public String getDcgoSeq() {
		return dcgoSeq;
	}

	/**
	 * @param dcgoSeq the dcgoSeq to set
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}

	/**
	 * @return the spclReqInVO
	 */
	public SpclReqInVO getSpclReqInVO() {
		return spclReqInVO;
	}

	/**
	 * @param spclReqInVO the spclReqInVO to set
	 */
	public void setSpclReqInVO(SpclReqInVO spclReqInVO) {
		this.spclReqInVO = spclReqInVO;
	}

	/**
	 * @return the spclReqInVOs
	 */
	public SpclReqInVO[] getSpclReqInVOs() {
		SpclReqInVO[] rtnVOs = null;
		if (this.spclReqInVOs != null) {
			rtnVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param spclReqInVOs the spclReqInVOs to set
	 */
	public void setSpclReqInVOs(SpclReqInVO[] spclReqInVOs) {
		if(spclReqInVOs != null){
			SpclReqInVO[] tmpVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
			this.spclReqInVOs = tmpVOs;
		}
	}

	public String getDgChkFlg() {
		return dgChkFlg;
	}

	public void setDgChkFlg(String dgChkFlg) {
		this.dgChkFlg = dgChkFlg;
	}

	public String getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(String saveButton) {
		this.saveButton = saveButton;
	}
	

}