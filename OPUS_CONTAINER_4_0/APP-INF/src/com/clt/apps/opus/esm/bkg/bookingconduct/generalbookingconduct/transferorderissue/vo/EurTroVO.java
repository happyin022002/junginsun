package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0079_02A 화면에서, 조회용 Container VO
 * @author 이남경
 * @since J2EE 1.5
 */
public class EurTroVO {
	
	/* param */
	String eBkgFlg = null;  //eBooking 여부 	
	String bkgNo   = null;
	String ioBndCd = null;
	String delFlg  = null;  //화면 save 이벤트구분 flg 
	
	/** 조회용 */
	//1) General 용 
	BkgBlNoVO                bkgBlNoVO         = null;
	
	BkgInfoForTroVO          bkgInfoForTroVO   = null; 
	List<DgSeqVO>            dgSeqVOs          = new ArrayList<DgSeqVO>(); 
	List<RfSeqVO>            rfSeqVOs          = new ArrayList<RfSeqVO>(); 
	List<AwkSeqVO>           awkSeqVOs         = new ArrayList<AwkSeqVO>();
	
	List<EurTroMstVO>        eurTroMstVOs      = new ArrayList<EurTroMstVO>();
	List<EurTroDtlVO>        eurTroDtlVOs      = new ArrayList<EurTroDtlVO>();
    List<BkgEurTroDgSeqVO>   bkgEurTroDgSeqVOs = new ArrayList<BkgEurTroDgSeqVO>();
    List<QtyInfoForTroVO>    qtyInfoForTroVOs  = new ArrayList<QtyInfoForTroVO>(); 
	
    /** 저장용 */ 
	/** Table Value Object Multi Data 처리 */
	private EurTroMstVO[]           arrEurTroMstVO      = null; 
	/** Table Value Object Multi Data 처리 */
	private EurTroDtlVO[]           arrEurTroDtlVO      = null; 
	/** Table Value Object Multi Data 처리 */
	private BkgEurTroDgSeqVO[]      arrBkgEurTroDgSeqVO = null;
	
	
	
	/**
	 * @return the bkgInfoForTroVO
	 */
	public BkgInfoForTroVO getBkgInfoForTroVO() {
		return bkgInfoForTroVO;
	}
	/**
	 * @param bkgInfoForTroVO the bkgInfoForTroVO to set
	 */
	public void setBkgInfoForTroVO(BkgInfoForTroVO bkgInfoForTroVO) {
		this.bkgInfoForTroVO = bkgInfoForTroVO;
	}
	/**
	 * @return the dgSeqVOs
	 */
	public List<DgSeqVO> getDgSeqVOs() {
		return dgSeqVOs;
	}
	/**
	 * @param dgSeqVOs the dgSeqVOs to set
	 */
	public void setDgSeqVOs(List<DgSeqVO> dgSeqVOs) {
		this.dgSeqVOs = dgSeqVOs;
	}
	/**
	 * @return the rfSeqVOs
	 */
	public List<RfSeqVO> getRfSeqVOs() {
		return rfSeqVOs;
	}
	/**
	 * @param rfSeqVOs the rfSeqVOs to set
	 */
	public void setRfSeqVOs(List<RfSeqVO> rfSeqVOs) {
		this.rfSeqVOs = rfSeqVOs;
	}
	/**
	 * @return the awkSeqVOs
	 */
	public List<AwkSeqVO> getAwkSeqVOs() {
		return awkSeqVOs;
	}
	/**
	 * @param awkSeqVOs the awkSeqVOs to set
	 */
	public void setAwkSeqVOs(List<AwkSeqVO> awkSeqVOs) {
		this.awkSeqVOs = awkSeqVOs;
	}
	/**
	 * @return the eurTroMstVOs
	 */
	public List<EurTroMstVO> getEurTroMstVOs() {
		return eurTroMstVOs;
	}
	/**
	 * @param eurTroMstVOs the eurTroMstVOs to set
	 */
	public void setEurTroMstVOs(List<EurTroMstVO> eurTroMstVOs) {
		this.eurTroMstVOs = eurTroMstVOs;
	}
	/**
	 * @return the eurTroDtlVOs
	 */
	public List<EurTroDtlVO> getEurTroDtlVOs() {
		return eurTroDtlVOs;
	}
	/**
	 * @param eurTroDtlVOs the eurTroDtlVOs to set
	 */
	public void setEurTroDtlVOs(List<EurTroDtlVO> eurTroDtlVOs) {
		this.eurTroDtlVOs = eurTroDtlVOs;
	}
	/**
	 * @return the bkgEurTroDgSeqVOs
	 */
	public List<BkgEurTroDgSeqVO> getBkgEurTroDgSeqVOs() {
		return bkgEurTroDgSeqVOs;
	}
	/**
	 * @param bkgEurTroDgSeqVOs the bkgEurTroDgSeqVOs to set
	 */
	public void setBkgEurTroDgSeqVOs(List<BkgEurTroDgSeqVO> bkgEurTroDgSeqVOs) {
		this.bkgEurTroDgSeqVOs = bkgEurTroDgSeqVOs;
	}
	/**
	 * @return the qtyInfoForTroVOs
	 */
	public List<QtyInfoForTroVO> getQtyInfoForTroVOs() {
		return qtyInfoForTroVOs;
	}
	/**
	 * @param qtyInfoForTroVOs the qtyInfoForTroVOs to set
	 */
	public void setQtyInfoForTroVOs(List<QtyInfoForTroVO> qtyInfoForTroVOs) {
		this.qtyInfoForTroVOs = qtyInfoForTroVOs;
	}
	/**
	 * @return the arrEurTroMstVO
	 */
	public EurTroMstVO[] getArrEurTroMstVO() {
		return arrEurTroMstVO;
	}
	/**
	 * @param arrEurTroMstVO the arrEurTroMstVO to set
	 */
	public void setArrEurTroMstVO(EurTroMstVO[] arrEurTroMstVO) {
		this.arrEurTroMstVO = arrEurTroMstVO;
	}
	/**
	 * @return the arrEurTroDtlVO
	 */
	public EurTroDtlVO[] getArrEurTroDtlVO() {
		return arrEurTroDtlVO;
	}
	/**
	 * @param arrEurTroDtlVO the arrEurTroDtlVO to set
	 */
	public void setArrEurTroDtlVO(EurTroDtlVO[] arrEurTroDtlVO) {
		this.arrEurTroDtlVO = arrEurTroDtlVO;
	}
	/**
	 * @return the arrBkgEurTroDgSeqVO
	 */
	public BkgEurTroDgSeqVO[] getArrBkgEurTroDgSeqVO() {
		return arrBkgEurTroDgSeqVO;
	}
	/**
	 * @param arrBkgEurTroDgSeqVO the arrBkgEurTroDgSeqVO to set
	 */
	public void setArrBkgEurTroDgSeqVO(BkgEurTroDgSeqVO[] arrBkgEurTroDgSeqVO) {
		this.arrBkgEurTroDgSeqVO = arrBkgEurTroDgSeqVO;
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
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}
	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	/**
	 * @return the eBkgFlg
	 */
	public String getEBkgFlg() {
		return eBkgFlg;
	}
	/**
	 * @param bkgFlg the eBkgFlg to set
	 */
	public void setEBkgFlg(String bkgFlg) {
		eBkgFlg = bkgFlg;
	}
	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	/**
	 * @return the delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}
	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}	
}