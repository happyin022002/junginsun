/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri013001Event.java
*@FileTitle : Charge Summary Report - Summary View
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportSummaryViewVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;


/**
 * ESM_PRI_013001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_013001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE HYE MIN
 * @see ESM_PRI_0130_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri013001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	private MdmChargeVO mdmChargeVO = null;
	private SearchConditionVO searchConditionVO = null;
	private RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	private MdmChargeVO[] mdmChargeVOs = null;
	private SearchConditionVO[] searchConditionVOs = null;
	private RptSearchChargeSummaryReportSummaryViewVO[] rptSearchChargeSummaryReportSummaryViewVOs = null;
	
	private String ofcCd = null;
	private String backendjobKey = null;
	
	public EsmPri013001Event(){}
	
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		if(comBakEndJbVOs != null){
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setMdmChargeVO(MdmChargeVO mdmChargeVO){
		this. mdmChargeVO = mdmChargeVO;
	}

	public void setMdmChargeVOS(MdmChargeVO[] mdmChargeVOs){
		if(mdmChargeVOs != null){
			MdmChargeVO[] tmpVOs = new MdmChargeVO[mdmChargeVOs.length];
			System.arraycopy(mdmChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmChargeVOs = tmpVOs;
		}
	}

	public MdmChargeVO getMdmChargeVO(){
		return mdmChargeVO;
	}

	public MdmChargeVO[] getMdmChargeVOS(){
		MdmChargeVO[] rtnVOs = null;
		if (this.mdmChargeVOs != null) {
			rtnVOs = new MdmChargeVO[mdmChargeVOs.length];
			System.arraycopy(mdmChargeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public void setSearchConditionVOS(SearchConditionVO[] searchConditionVOs){
		if(searchConditionVOs != null){
			SearchConditionVO[] tmpVOs = new SearchConditionVO[searchConditionVOs.length];
			System.arraycopy(searchConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchConditionVOs = tmpVOs;
		}
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public SearchConditionVO[] getSearchConditionVOS(){
		SearchConditionVO[] rtnVOs = null;
		if (this.searchConditionVOs != null) {
			rtnVOs = new SearchConditionVO[searchConditionVOs.length];
			System.arraycopy(searchConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRptSearchChargeSummaryReportSummaryViewVO(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO){
		this. rptSearchChargeSummaryReportSummaryViewVO = rptSearchChargeSummaryReportSummaryViewVO;
	}

	public void setRptSearchChargeSummaryReportSummaryViewVOS(RptSearchChargeSummaryReportSummaryViewVO[] rptSearchChargeSummaryReportSummaryViewVOs){
		if(rptSearchChargeSummaryReportSummaryViewVOs != null){
			RptSearchChargeSummaryReportSummaryViewVO[] tmpVOs = new RptSearchChargeSummaryReportSummaryViewVO[rptSearchChargeSummaryReportSummaryViewVOs.length];
			System.arraycopy(rptSearchChargeSummaryReportSummaryViewVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rptSearchChargeSummaryReportSummaryViewVOs = tmpVOs;
		}
	}

	public RptSearchChargeSummaryReportSummaryViewVO getRptSearchChargeSummaryReportSummaryViewVO(){
		return rptSearchChargeSummaryReportSummaryViewVO;
	}

	public RptSearchChargeSummaryReportSummaryViewVO[] getRptSearchChargeSummaryReportSummaryViewVOS(){
		RptSearchChargeSummaryReportSummaryViewVO[] rtnVOs = null;
		if (this.rptSearchChargeSummaryReportSummaryViewVOs != null) {
			rtnVOs = new RptSearchChargeSummaryReportSummaryViewVO[rptSearchChargeSummaryReportSummaryViewVOs.length];
			System.arraycopy(rptSearchChargeSummaryReportSummaryViewVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * @return the backendjobKey
	 */
	public String getBackendjobKey() {
		return backendjobKey;
	}

	/**
	 * @param backendjobKey the backendjobKey to set
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
}