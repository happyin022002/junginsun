/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0273Event.java
*@FileTitle : Chassis Cost Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-23
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-04-23 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.ChassisCostReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0273 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0273HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0273HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0273Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private ChassisCostReportVO chassisCostReportVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private ChassisCostReportVO[] chassisCostReportVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0273Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0273Event";
	}

	public ChassisCostReportVO getChassisCostReportVO() {
		return chassisCostReportVO;
	}

	public void setChassisCostReportVO(ChassisCostReportVO chassisCostReportVO) {
		this.chassisCostReportVO = chassisCostReportVO;
	}

	
	public ChassisCostReportVO[] getChassisCostReportVOs() {
		return chassisCostReportVOs;
	}

	public void setChassisCostReportVOs(ChassisCostReportVO[] chassisCostReportVOs) {
		this.chassisCostReportVOs = chassisCostReportVOs;
	}
		
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}		
			
}
