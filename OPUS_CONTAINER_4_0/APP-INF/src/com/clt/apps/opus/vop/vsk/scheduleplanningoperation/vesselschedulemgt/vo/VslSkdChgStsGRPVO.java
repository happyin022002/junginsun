/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SwapCstGRPVO.java
*@FileTitle : SwapCstGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.06.22 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdChgStsGRPVO {

	private static final long serialVersionUID = 1L;
	
	private String vslCd = null;
	private String portCd = null;
	private String yardCd = null;
	private String portSkdStsCd = null;
	private VslSkdCngNoticeVO vslSkdCngNoticeVO = null;
	private VslSkdCngUpdateVO vslSkdCngUpdateVO = null;
	private SceActRcvIfVO sceActRcvIfVO = null;
	private CanonEmlVO canonEmlVO = null;
	private BkgVvdBdrLogVO bkgVvdBdrLogVO = null;
	private String okCnt = null;
	private String failCnt = null;
	private String failPortInfo = null;
	private String slanCd = null;

	private String[] vslCds = null;
	private String[] portCds = null;
	private String[] yardCds = null;
	private String[] portSkdStsCds = null;
	private List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = null;
	private List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs = null;
	private List<SceActRcvIfVO> sceActRcvIfVOs = null;
	private List<CanonEmlVO> canonEmlVOs = null;
	private List<VvdVO> erpVvdVOs = null;
	private List<VvdVO> ediVvdVOs = null;
	private List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = null;
	private List<String> failPortInfos = null;
	
	/****************************************************************
	 * 운항스케쥴 이력관리를 위한 VO,HashMap추가 ::2015-05-08::
	 */
	//private List<VskVslSkdVO>				vskVslSkdVOs			= null;
	//private List<VskVslSkdVO>				updateList				= null;
	
	private Map<String, List<VslSkdXtraHisVO>>	hmVslSkdXtraHisVOs		= null;
	private VslSkdXtraHisGroupVO				vslSkdXtraHisGroupVO	= null;
	
	private List<VslSkdXtraHisVO>				vslSkdXtraHisVOs		= null;
	/****************************************************************/
	
	public VslSkdChgStsGRPVO() {}

	/**
	 * @return the hmVskVslSkdVOs
	 */
	public Map<String, List<VslSkdXtraHisVO>> getHmVslSkdXtraHisVOs() {
		return this.hmVslSkdXtraHisVOs;
	}
	
	/**
	 * @return the hmVskVslSkdVOs
	 */
	public void setHmVslSkdXtraHisVOs(Map<String, List<VslSkdXtraHisVO>> hmVslSkdXtraHisVOs) {
		this.hmVslSkdXtraHisVOs	= hmVslSkdXtraHisVOs;
	}
	
	/**
	 * @return the vslSkdCngHisDtlVOs
	 */
	public VslSkdXtraHisGroupVO getVslSkdXtraHisGroupVO() {
		return vslSkdXtraHisGroupVO;
	}
	
	/**
	 * @param vslSkdCngHisDtlVOs the vslSkdCngHisDtlVOs to set
	 */
	public void setVslSkdXtraHisGroupVO(VslSkdXtraHisGroupVO vslSkdXtraHisGroupVO) {
		this.vslSkdXtraHisGroupVO = vslSkdXtraHisGroupVO;
	}
	
	/**
	 * @return the vslSkdCngHisDtlVOs
	 */
	public List<VslSkdXtraHisVO> getVslSkdXtraHisVOs() {
		return vslSkdXtraHisVOs;
	}
	
	/**
	 * @param vslSkdCngHisDtlVOs the vslSkdCngHisDtlVOs to set
	 */
	public void setVslSkdXtraHisVOs(List<VslSkdXtraHisVO> vslSkdXtraHisVOs) {
		this.vslSkdXtraHisVOs = vslSkdXtraHisVOs;
	}
	
	
	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @return the yardCd
	 */
	public String getYardCd() {
		return yardCd;
	}

	/**
	 * @param yardCd the yardCd to set
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}

	/**
	 * @return the portCds
	 */
	public String[] getPortCds() {
		return portCds;
	}

	/**
	 * @param portCds the portCds to set
	 */
	public void setPortCds(String[] portCds) {
		this.portCds = portCds;
	}

	/**
	 * @return the yardCds
	 */
	public String[] getYardCds() {
		return yardCds;
	}

	/**
	 * @param yardCds the yardCds to set
	 */
	public void setYardCds(String[] yardCds) {
		this.yardCds = yardCds;
	}

	/**
	 * @return the vslCd
	 */
	public String getVslCd() {
		return vslCd;
	}

	/**
	 * @param vslCd the vslCd to set
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * @return the vslCds
	 */
	public String[] getVslCds() {
		return vslCds;
	}

	/**
	 * @param vslCds the vslCds to set
	 */
	public void setVslCds(String[] vslCds) {
		this.vslCds = vslCds;
	}

	/**
	 * @return the vslSkdCngNoticeVO
	 */
	public VslSkdCngNoticeVO getVslSkdCngNoticeVO() {
		return vslSkdCngNoticeVO;
	}

	/**
	 * @param vslSkdCngNoticeVO the vslSkdCngNoticeVO to set
	 */
	public void setVslSkdCngNoticeVO(VslSkdCngNoticeVO vslSkdCngNoticeVO) {
		this.vslSkdCngNoticeVO = vslSkdCngNoticeVO;
	}

	/**
	 * @return the vslSkdCngUpdateVO
	 */
	public VslSkdCngUpdateVO getVslSkdCngUpdateVO() {
		return vslSkdCngUpdateVO;
	}

	/**
	 * @param vslSkdCngUpdateVO the vslSkdCngUpdateVO to set
	 */
	public void setVslSkdCngUpdateVO(VslSkdCngUpdateVO vslSkdCngUpdateVO) {
		this.vslSkdCngUpdateVO = vslSkdCngUpdateVO;
	}

	/**
	 * @return the vslSkdCngNoticeVOs
	 */
	public List<VslSkdCngNoticeVO> getVslSkdCngNoticeVOs() {
		return vslSkdCngNoticeVOs;
	}

	/**
	 * @param vslSkdCngNoticeVOs the vslSkdCngNoticeVOs to set
	 */
	public void setVslSkdCngNoticeVOs(List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs) {
		this.vslSkdCngNoticeVOs = vslSkdCngNoticeVOs;
	}

	/**
	 * @return the vslSkdCngUpdateVOs
	 */
	public List<VslSkdCngUpdateVO> getVslSkdCngUpdateVOs() {
		return vslSkdCngUpdateVOs;
	}

	/**
	 * @param vslSkdCngUpdateVOs the vslSkdCngUpdateVOs to set
	 */
	public void setVslSkdCngUpdateVOs(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs) {
		this.vslSkdCngUpdateVOs = vslSkdCngUpdateVOs;
	}

	/**
	 * @return the sceActRcvIfVO
	 */
	public SceActRcvIfVO getSceActRcvIfVO() {
		return sceActRcvIfVO;
	}

	/**
	 * @param sceActRcvIfVO the sceActRcvIfVO to set
	 */
	public void setSceActRcvIfVO(SceActRcvIfVO sceActRcvIfVO) {
		this.sceActRcvIfVO = sceActRcvIfVO;
	}

	/**
	 * @return the sceActRcvIfVOs
	 */
	public List<SceActRcvIfVO> getSceActRcvIfVOs() {
		return sceActRcvIfVOs;
	}

	/**
	 * @param sceActRcvIfVOs the sceActRcvIfVOs to set
	 */
	public void setSceActRcvIfVOs(List<SceActRcvIfVO> sceActRcvIfVOs) {
		this.sceActRcvIfVOs = sceActRcvIfVOs;
	}

	/**
	 * @return the canonEmlVO
	 */
	public CanonEmlVO getCanonEmlVO() {
		return canonEmlVO;
	}

	/**
	 * @param canonEmlVO the canonEmlVO to set
	 */
	public void setCanonEmlVO(CanonEmlVO canonEmlVO) {
		this.canonEmlVO = canonEmlVO;
	}

	/**
	 * @return the canonEmlVOs
	 */
	public List<CanonEmlVO> getCanonEmlVOs() {
		return canonEmlVOs;
	}

	/**
	 * @param canonEmlVOs the canonEmlVOs to set
	 */
	public void setCanonEmlVOs(List<CanonEmlVO> canonEmlVOs) {
		this.canonEmlVOs = canonEmlVOs;
	}

	/**
	 * @return the erpVvdVOs
	 */
	public List<VvdVO> getErpVvdVOs() {
		return erpVvdVOs;
	}

	/**
	 * @param erpVvdVOs the erpVvdVOs to set
	 */
	public void setErpVvdVOs(List<VvdVO> erpVvdVOs) {
		this.erpVvdVOs = erpVvdVOs;
	}

	/**
	 * @return the ediVvdVOs
	 */
	public List<VvdVO> getEdiVvdVOs() {
		return ediVvdVOs;
	}

	/**
	 * @param ediVvdVOs the ediVvdVOs to set
	 */
	public void setEdiVvdVOs(List<VvdVO> ediVvdVOs) {
		this.ediVvdVOs = ediVvdVOs;
	}

	/**
	 * @return the bkgVvdBdrLogVO
	 */
	public BkgVvdBdrLogVO getBkgVvdBdrLogVO() {
		return bkgVvdBdrLogVO;
	}

	/**
	 * @param bkgVvdBdrLogVO the bkgVvdBdrLogVO to set
	 */
	public void setBkgVvdBdrLogVO(BkgVvdBdrLogVO bkgVvdBdrLogVO) {
		this.bkgVvdBdrLogVO = bkgVvdBdrLogVO;
	}

	/**
	 * @return the bkgVvdBdrLogVOs
	 */
	public List<BkgVvdBdrLogVO> getBkgVvdBdrLogVOs() {
		return bkgVvdBdrLogVOs;
	}

	/**
	 * @param bkgVvdBdrLogVOs the bkgVvdBdrLogVOs to set
	 */
	public void setBkgVvdBdrLogVOs(List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs) {
		this.bkgVvdBdrLogVOs = bkgVvdBdrLogVOs;
	}

	/**
	 * @return the portSkdStsCd
	 */
	public String getPortSkdStsCd() {
		return portSkdStsCd;
	}

	/**
	 * @param portSkdStsCd the portSkdStsCd to set
	 */
	public void setPortSkdStsCd(String portSkdStsCd) {
		this.portSkdStsCd = portSkdStsCd;
	}

	/**
	 * @return the portSkdStsCds
	 */
	public String[] getPortSkdStsCds() {
		return portSkdStsCds;
	}

	/**
	 * @param portSkdStsCds the portSkdStsCds to set
	 */
	public void setPortSkdStsCds(String[] portSkdStsCds) {
		this.portSkdStsCds = portSkdStsCds;
	}

	/**
	 * @return the okCnt
	 */
	public String getOkCnt() {
		return okCnt;
	}

	/**
	 * @param okCnt the okCnt to set
	 */
	public void setOkCnt(String okCnt) {
		this.okCnt = okCnt;
	}

	/**
	 * @return the failCnt
	 */
	public String getFailCnt() {
		return failCnt;
	}

	/**
	 * @param failCnt the failCnt to set
	 */
	public void setFailCnt(String failCnt) {
		this.failCnt = failCnt;
	}

	/**
	 * @return the failPortInfo
	 */
	public String getFailPortInfo() {
		return failPortInfo;
	}

	/**
	 * @param failPortInfo the failPortInfo to set
	 */
	public void setFailPortInfo(String failPortInfo) {
		this.failPortInfo = failPortInfo;
	}

	/**
	 * @return the failPortInfos
	 */
	public List<String> getFailPortInfos() {
		return failPortInfos;
	}

	/**
	 * @param failPortInfos the failPortInfos to set
	 */
	public void setFailPortInfos(List<String> failPortInfos) {
		this.failPortInfos = failPortInfos;
	}

	/**
	 * @return String slanCd
	 */
	public String getSlanCd() {
		return slanCd;
	}

	/**
	 * @param String slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	
}
