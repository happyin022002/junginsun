/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 5. 20.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 20. 성덕경 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo;

import java.util.List;

/**
 * FQAResultMgt GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 성덕경
 * @since J2EE 1.5
 * @see
 */
public class FQAResultMgtGRPVO  {
	//조회조건을 받기위한
	private FQAResultMgtINVO fQAResultMgtINVO= null;
	//CUD처리를 위한 
	private MnrFieldQualityAuditResultVO[] arrayMnrFieldQualityAuditResultVOs = null;
	//조회 결과를 받기 위한 
	private List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOS = null;
	
	public FQAResultMgtINVO getFQAResultMgtINVO() {
		return fQAResultMgtINVO;
	}
	public void setFQAResultMgtINVO(FQAResultMgtINVO fQAResultMgtINVO) {
		this.fQAResultMgtINVO = fQAResultMgtINVO;
	}
	
	public MnrFieldQualityAuditResultVO[] getArrayMnrFieldQualityAuditResultVOs() {
		return arrayMnrFieldQualityAuditResultVOs;
	}
	public void setMnrFieldQualityAuditResultVOs(MnrFieldQualityAuditResultVO[] arrayMnrFieldQualityAuditResultVOs) {
		this.arrayMnrFieldQualityAuditResultVOs = arrayMnrFieldQualityAuditResultVOs;
	}	
	public List<MnrFieldQualityAuditResultVO> getMnrFieldQualityAuditResultVOS() {
		return mnrFieldQualityAuditResultVOS;
	}
	public void setMnrFieldQualityAuditResultVOS(
			List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOS) {
		this.mnrFieldQualityAuditResultVOS = mnrFieldQualityAuditResultVOS;
	} 
}
