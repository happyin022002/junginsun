/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossInfoGRPVO
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 09. 15
*@LastModifier :
*@LastVersion : 1.0
*2009. 09. 15. 김완규
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

import java.util.List;

/**
 * TotalLossInfoGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see ..
 */
public class TotalLossInfoGRPVO {
	//조회조건을 받기 위한
	private TotalLossInfoINVO totalLossInfoINVO = null;
	//조회 결과를 받기 위한
    private  List <CustomMnrTtlLssRqstHdrVO> listCustomMnrTtlLssRqstHdrVOs = null;

    public TotalLossInfoINVO getTotalLossInfoINVO() {
		return totalLossInfoINVO;
	}
	public void setTotalLossInfoINVO(TotalLossInfoINVO totalLossInfoINVO) {
		this.totalLossInfoINVO = totalLossInfoINVO;
	}
	public List<CustomMnrTtlLssRqstHdrVO> getListCustomMnrTtlLssRqstHdrVOs() {
		return listCustomMnrTtlLssRqstHdrVOs;
	}
	public void setListCustomMnrTtlLssRqstHdrVOs(
			List<CustomMnrTtlLssRqstHdrVO> listCustomMnrTtlLssRqstHdrVOs) {
		this.listCustomMnrTtlLssRqstHdrVOs = listCustomMnrTtlLssRqstHdrVOs;
	}
}
