/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1053Event.java
*@FileTitle : CIM Batch Job Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.29 문중철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CIM_1053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see UI_CIM_1053HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim1053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String froms = "";
	private String tos   = "";
	private String fromz = "";
	private String toz   = "";
	private String wk    = "";
	private String dt    = "";
	private String tp    = "";
	private String tl    = "";
	private String ts    = "";
	private String tm    = "";
	private String mp    = "";
	private String ml    = "";
	private String mb    = "";
	private String md    = "";
	private String rp    = "";
	private String rl    = "";
	private String rd    = "";
	private String wf    = "";
	private String wt    = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBatchJobStatusVO searchBatchJobStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBatchJobStatusVO[] searchBatchJobStatusVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOptionByFromToVO searchOptionByFromToVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOptionByFromToVO[] searchOptionByFromToVOs = null;
	
	public EesCim1053Event(){}

	/**
	 * @return the froms
	 */
	public String getFroms() {
		return froms;
	}

	/**
	 * @param froms the froms to set
	 */
	public void setFroms(String froms) {
		this.froms = froms;
	}

	/**
	 * @return the tos
	 */
	public String getTos() {
		return tos;
	}

	/**
	 * @param tos the tos to set
	 */
	public void setTos(String tos) {
		this.tos = tos;
	}

	/**
	 * @return the fromz
	 */
	public String getFromz() {
		return fromz;
	}

	/**
	 * @param fromz the fromz to set
	 */
	public void setFromz(String fromz) {
		this.fromz = fromz;
	}

	/**
	 * @return the toz
	 */
	public String getToz() {
		return toz;
	}

	/**
	 * @param toz the toz to set
	 */
	public void setToz(String toz) {
		this.toz = toz;
	}

	/**
	 * @return the wk
	 */
	public String getWk() {
		return wk;
	}

	/**
	 * @param wk the wk to set
	 */
	public void setWk(String wk) {
		this.wk = wk;
	}

	/**
	 * @return the dt
	 */
	public String getDt() {
		return dt;
	}

	/**
	 * @param dt the dt to set
	 */
	public void setDt(String dt) {
		this.dt = dt;
	}

	/**
	 * @return the tp
	 */
	public String getTp() {
		return tp;
	}

	/**
	 * @param tp the tp to set
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}

	/**
	 * @return the tl
	 */
	public String getTl() {
		return tl;
	}

	/**
	 * @param tl the tl to set
	 */
	public void setTl(String tl) {
		this.tl = tl;
	}

	/**
	 * @return the ts
	 */
	public String getTs() {
		return ts;
	}

	/**
	 * @param ts the ts to set
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}

	/**
	 * @return the tm
	 */
	public String getTm() {
		return tm;
	}

	/**
	 * @param tm the tm to set
	 */
	public void setTm(String tm) {
		this.tm = tm;
	}

	/**
	 * @return the mp
	 */
	public String getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(String mp) {
		this.mp = mp;
	}

	/**
	 * @return the ml
	 */
	public String getMl() {
		return ml;
	}

	/**
	 * @param ml the ml to set
	 */
	public void setMl(String ml) {
		this.ml = ml;
	}

	/**
	 * @return the mb
	 */
	public String getMb() {
		return mb;
	}

	/**
	 * @param mb the mb to set
	 */
	public void setMb(String mb) {
		this.mb = mb;
	}

	/**
	 * @return the md
	 */
	public String getMd() {
		return md;
	}

	/**
	 * @param md the md to set
	 */
	public void setMd(String md) {
		this.md = md;
	}

	/**
	 * @return the rp
	 */
	public String getRp() {
		return rp;
	}

	/**
	 * @param rp the rp to set
	 */
	public void setRp(String rp) {
		this.rp = rp;
	}

	/**
	 * @return the rl
	 */
	public String getRl() {
		return rl;
	}

	/**
	 * @param rl the rl to set
	 */
	public void setRl(String rl) {
		this.rl = rl;
	}

	/**
	 * @return the rd
	 */
	public String getRd() {
		return rd;
	}

	/**
	 * @param rd the rd to set
	 */
	public void setRd(String rd) {
		this.rd = rd;
	}

	/**
	 * @return the wf
	 */
	public String getWf() {
		return wf;
	}

	/**
	 * @param wf the wf to set
	 */
	public void setWf(String wf) {
		this.wf = wf;
	}

	/**
	 * @return the wt
	 */
	public String getWt() {
		return wt;
	}

	/**
	 * @param wt the wt to set
	 */
	public void setWt(String wt) {
		this.wt = wt;
	}

	/**
	 * @return the searchBatchJobStatusVO
	 */
	public SearchBatchJobStatusVO getSearchBatchJobStatusVO() {
		return searchBatchJobStatusVO;
	}

	/**
	 * @param searchBatchJobStatusVO the searchBatchJobStatusVO to set
	 */
	public void setSearchBatchJobStatusVO(
			SearchBatchJobStatusVO searchBatchJobStatusVO) {
		this.searchBatchJobStatusVO = searchBatchJobStatusVO;
	}

	/**
	 * @return the searchBatchJobStatusVOs
	 */
	public SearchBatchJobStatusVO[] getSearchBatchJobStatusVOs() {
		SearchBatchJobStatusVO[] rtnVOs = null;
		if (this.searchBatchJobStatusVOs != null) {
			rtnVOs = Arrays.copyOf(searchBatchJobStatusVOs, searchBatchJobStatusVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param searchBatchJobStatusVOs the searchBatchJobStatusVOs to set
	 */
	public void setSearchBatchJobStatusVOs(
			SearchBatchJobStatusVO[] searchBatchJobStatusVOs) {
		if (searchBatchJobStatusVOs != null) {
			SearchBatchJobStatusVO[] tmpVOs = Arrays.copyOf(searchBatchJobStatusVOs, searchBatchJobStatusVOs.length);
			this.searchBatchJobStatusVOs = tmpVOs;
		}
	}

	/**
	 * @return the searchOptionByFromToVO
	 */
	public SearchOptionByFromToVO getSearchOptionByFromToVO() {
		return searchOptionByFromToVO;
	}

	/**
	 * @param searchOptionByFromToVO the searchOptionByFromToVO to set
	 */
	public void setSearchOptionByFromToVO(
			SearchOptionByFromToVO searchOptionByFromToVO) {
		this.searchOptionByFromToVO = searchOptionByFromToVO;
	}

	/**
	 * @return the searchOptionByFromToVOs
	 */
	public SearchOptionByFromToVO[] getSearchOptionByFromToVOs() {
		SearchOptionByFromToVO[] rtnVOs = null;
		if (this.searchOptionByFromToVOs != null) {
			rtnVOs = Arrays.copyOf(searchOptionByFromToVOs, searchOptionByFromToVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param searchOptionByFromToVOs the searchOptionByFromToVOs to set
	 */
	public void setSearchOptionByFromToVOs(
			SearchOptionByFromToVO[] searchOptionByFromToVOs) {
		if (searchOptionByFromToVOs != null) {
			SearchOptionByFromToVO[] tmpVOs = Arrays.copyOf(searchOptionByFromToVOs, searchOptionByFromToVOs.length);
			this.searchOptionByFromToVOs = tmpVOs;
		}
	}
	
}
