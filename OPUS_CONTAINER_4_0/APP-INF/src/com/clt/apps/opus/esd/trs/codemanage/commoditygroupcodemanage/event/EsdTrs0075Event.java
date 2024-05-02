/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_075Event.java
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.event;

import java.util.Arrays;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmCommodityVO;
import com.clt.syscommon.common.table.TrsCmdtGrpCzVO;
import com.clt.syscommon.common.table.TrsTrspCmdtGrpVO;

/**
 * ESD_TRS_075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0075Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** trs_trsp_cmdt_grp Table  Value Object */
	private TrsTrspCmdtGrpVO trsTrspCmdtGrpVO = null;

	/** trs_trsp_cmdt_grps Multi Action을 위한 Collection */
	private TrsTrspCmdtGrpVO[] trsTrspCmdtGrpVOs = null;

	/** trs_trsp_cmdt_grp Table  Value Object */
	private TrsCmdtGrpCzVO trsCmdtGrpCzVO = null;

	/** trs_trsp_cmdt_grps Multi Action을 위한 Collection */
	private TrsCmdtGrpCzVO[] trsCmdtGrpCzVOs = null;	

	/** trs_trsp_cmdt_grps Multi Action을 위한 Collection */
	private MdmCommodityVO[] mdmCommodityVOs = null;

	/** trs_trsp_cmdt_grps Multi Action을 위한 Collection */
	private MdmCommodityVO mdmCommodityVO = null;

	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String vndrCd = "";
	private String vndrCommoodityCd = "";
	private String vndrCommoodityNm = "";
	private String vndrNm = "";
	private String vndrSeq = "";
	private String repCmdtCd = "";
	private String cmdtCd = "";
	private String trspGrpCmdtCd = "";
	private String creUsrId = "";
	private String creDt = "";
	private String updUsrId = "";
	private String updDt = "";
	private String deltFlag = "";
	
	public void setVndrCd(String vndrCd){
		this.vndrCd = vndrCd;
	}		
	
	public String getVndrCd() {
		return vndrCd;
	}

	public void setVndrCommoodityCd(String vndrCommoodityCd){
		this.vndrCommoodityCd = vndrCommoodityCd;
	}		
	
	public String getVndrCommoodityCd() {
		return vndrCommoodityCd;
	}

	public void setVndrCommoodityNm(String vndrCommoodityNm){
		this.vndrCommoodityNm = vndrCommoodityNm;
	}		
	
	public String getVndrCommoodityNm() {
		return vndrCommoodityNm;
	}

	public void setVndrNm(String vndrNm){
		this.vndrNm = vndrNm;
	}		
	
	public String getVndrNm() {
		return vndrNm;
	}

	public void setVndrSeq(String vndrSeq){
		this.vndrSeq = vndrSeq;
	}		
	
	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setRepCmdtCd(String repCmdtCd){
		this.repCmdtCd = repCmdtCd;
	}		
	
	public String getRepCmdtCd() {
		return repCmdtCd;
	}

	public void setCmdtCd(String cmdtCd){
		this.cmdtCd = cmdtCd;
	}		
	
	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setTrspGrpCmdtCd(String trspGrpCmdtCd){
		this.trspGrpCmdtCd = trspGrpCmdtCd;
	}		
	
	public String getTrspGrpCmdtCd() {
		return trspGrpCmdtCd;
	}

	public void setCreUsrId(String creUsrId){
		this.creUsrId = creUsrId;
	}		
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreDt(String creDt){
		this.creDt = creDt;
	}		
	
	public String getCreDt() {
		return creDt;
	}
	 
	public void setUpdUsrId(String updUsrId){
		this.updUsrId = updUsrId;
	}		
	
	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdDt(String updDt){
		this.updDt = updDt;
	}		
	
	public String getUpdDt() {
		return updDt;
	}

	public void setDeltFlag(String deltFlag){
		this.deltFlag = deltFlag;
	}		
	
	public String getDeltFlag() {
		return deltFlag;
	}

	/** HASHPARAM을 대치할 파라미터 set/get END*/

	/** ESD_TRS_0075Event */
	public EsdTrs0075Event(){}

	/**
	 * @param trsTrspCmdtGrpVO
	 * @param trsCmdtGrpCzVOs
	 */
	public EsdTrs0075Event(TrsTrspCmdtGrpVO trsTrspCmdtGrpVO, TrsCmdtGrpCzVO[] trsCmdtGrpCzVOs) {
		this.trsTrspCmdtGrpVO = trsTrspCmdtGrpVO;
		this.trsCmdtGrpCzVOs = trsCmdtGrpCzVOs;
    }

	/**
	 * @param trsTrspCmdtGrpVO
	 * @param trsCmdtGrpCzVO
	 */
	public EsdTrs0075Event(TrsTrspCmdtGrpVO trsTrspCmdtGrpVO, TrsCmdtGrpCzVO trsCmdtGrpCzVO) {
		this.trsTrspCmdtGrpVO = trsTrspCmdtGrpVO;
		this.trsCmdtGrpCzVO = trsCmdtGrpCzVO;
    }
	
	/** getTrsTrspCmdtGrpVO*/
	public TrsTrspCmdtGrpVO getTrsTrspCmdtGrpVO(){
		return trsTrspCmdtGrpVO;
	}

	/** getTrsTrspCmdtGrpVOS */
	public TrsTrspCmdtGrpVO[] getTrsTrspCmdtGrpVOS(){
		TrsTrspCmdtGrpVO[] rtnVOs = null;
		if (this.trsTrspCmdtGrpVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspCmdtGrpVOs, trsTrspCmdtGrpVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspCmdtGrpVOS(TrsTrspCmdtGrpVO[] trsTrspCmdtGrpVOs){
		if (trsTrspCmdtGrpVOs != null) {
			TrsTrspCmdtGrpVO[] tmpVOs = Arrays.copyOf(trsTrspCmdtGrpVOs, trsTrspCmdtGrpVOs.length);
			this.trsTrspCmdtGrpVOs = tmpVOs;
		} // end if
	}
	
	/** getTrsTrspCmdtGrpVO*/
	public TrsCmdtGrpCzVO getTrsCmdtGrpCzVO(){
		return trsCmdtGrpCzVO;
	}

	/** getTrsTrspCmdtGrpVOS */
	public TrsCmdtGrpCzVO[] getTrsCmdtGrpCzVOS(){
		TrsCmdtGrpCzVO[] rtnVOs = null;
		if (this.trsCmdtGrpCzVOs != null) {
			rtnVOs = Arrays.copyOf(trsCmdtGrpCzVOs, trsCmdtGrpCzVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsCmdtGrpCzVOS(TrsCmdtGrpCzVO[] trsCmdtGrpCzVOs){
		if (trsCmdtGrpCzVOs != null) {
			TrsCmdtGrpCzVO[] tmpVOs = Arrays.copyOf(trsCmdtGrpCzVOs, trsCmdtGrpCzVOs.length);
			this.trsCmdtGrpCzVOs = tmpVOs;
		} // end if
	}
	
	/** getTrsTrspCmdtGrpVO*/
	public MdmCommodityVO getMdmCommodityVO(){
		return mdmCommodityVO;
	}

	/** getTrsTrspCmdtGrpVOS */
	public MdmCommodityVO[] getMdmCommodityVOS(){
		MdmCommodityVO[] rtnVOs = null;
		if (this.mdmCommodityVOs != null) {
			rtnVOs = Arrays.copyOf(mdmCommodityVOs, mdmCommodityVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setMdmCommodityVOS(MdmCommodityVO[] mdmCommodityVOs){
		if (mdmCommodityVOs != null) {
			MdmCommodityVO[] tmpVOs = Arrays.copyOf(mdmCommodityVOs, mdmCommodityVOs.length);
			this.mdmCommodityVOs = tmpVOs;
		} // end if
	}
	
	/** getEventName */
	public String getEventName() {
		return "EsdTrs0075Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0075Event";
	}
}