/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0032Event.java
*@FileTitle :  Output Alive EQ Master Data for Owned Equipment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.31 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetAudVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @return the assetsAuditDetailVOs
	 */
	public AssetsAuditDetailVO[] getAssetsAuditDetailVOs() {
		return assetsAuditDetailVOs;
	}

	/**
	 * @param assetsAuditDetailVOs the assetsAuditDetailVOs to set
	 */
	public void setAssetsAuditDetailVOs(AssetsAuditDetailVO[] assetsAuditDetailVOs) {
		this.assetsAuditDetailVOs = assetsAuditDetailVOs;
	}

	/**
	 * @return the eqAsetAudVO
	 */
	public EqAsetAudVO getEqAsetAudVO() {
		return eqAsetAudVO;
	}

	/**
	 * @param eqAsetAudVO the eqAsetAudVO to set
	 */
	public void setEqAsetAudVO(EqAsetAudVO eqAsetAudVO) {
		this.eqAsetAudVO = eqAsetAudVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리 
	 *  2014-05-28 시큐어 코딩 작업 (private --> public) 변경
	 *  */
	public AssetsAuditDetailVO[] assetsAuditDetailVOs = null;
	
	/** 검색결과 **/
	private EqAsetAudVO eqAsetAudVO = null;	

}