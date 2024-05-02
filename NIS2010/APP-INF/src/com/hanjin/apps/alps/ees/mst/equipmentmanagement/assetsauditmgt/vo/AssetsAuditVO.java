/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AssetsAuditVO.java
*@FileTitle : Output Alive EQ Master Data for Owned Equipment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.31 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

import java.util.List;

public class AssetsAuditVO
{
	// 조회 결과값을 받기위한 테이블 VO리스트
	private EqAsetAudVO eqAsetAudVO = null;
	
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<AssetsAuditDetailVO> assetsAuditDetailVOs = null;
	
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<EqAsetDpcAmtVO> eqAsetDpcAmtVOs = null;

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

	/**
	 * @return the assetsAuditDetailVOs
	 */
	public List<AssetsAuditDetailVO> getAssetsAuditDetailVOs() {
		return assetsAuditDetailVOs;
	}

	/**
	 * @param assetsAuditDetailVOs the assetsAuditDetailVOs to set
	 */
	public void setAssetsAuditDetailVOs(
			List<AssetsAuditDetailVO> assetsAuditDetailVOs) {
		this.assetsAuditDetailVOs = assetsAuditDetailVOs;
	}
	
	/**
	 * @return the assetsAuditDetailVOs
	 */
	public List<EqAsetDpcAmtVO> getEqAsetDpcAmtVOs() {
		return eqAsetDpcAmtVOs;
	}

	/**
	 * @param assetsAuditDetailVOs the assetsAuditDetailVOs to set
	 */
	public void setEqAsetDpcAmtVOs(
			List<EqAsetDpcAmtVO> eqAsetDpcAmtVOs) {
		this.eqAsetDpcAmtVOs = eqAsetDpcAmtVOs;
	}

	public AssetsAuditVO() 
	{
	}
}
