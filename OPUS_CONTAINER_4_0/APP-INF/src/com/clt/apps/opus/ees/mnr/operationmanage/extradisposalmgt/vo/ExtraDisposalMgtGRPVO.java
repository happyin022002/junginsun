/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtGRPVO
*@FileTitle : Scrapping/Donation Creation
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 09. 07
*@LastModifier : 
*@LastVersion : 1.0
*2009. 09. 07. 김완규 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo;

import java.util.List;
/**
 * ExtraDisposalMgtGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class ExtraDisposalMgtGRPVO {
	//조회 조건을 받기 위한
	private ExtraDisposalMgtINVO extraDisposalMgtINVO = null;
	//조회 결과를 받기 위한
    private  List <CustomMnrXtraDispVO> listCustomMnrXtraDispVO = null;
    //저장 처리를 위한
	private  CustomMnrXtraDispVO[] arrayCustomMnrXtraDispVOs = null;
	//중복체크를 위한
	private String cnt = null;
	
	public ExtraDisposalMgtINVO getExtraDisposalMgtINVO() {
		return extraDisposalMgtINVO;
	}
	public void setExtraDisposalMgtINVO(ExtraDisposalMgtINVO extraDisposalMgtINVO) {
		this.extraDisposalMgtINVO = extraDisposalMgtINVO;
	}
	public List<CustomMnrXtraDispVO> getListCustomMnrXtraDispVO() {
		return listCustomMnrXtraDispVO;
	}
	public void setListCustomMnrXtraDispVO(
			List<CustomMnrXtraDispVO> listCustomMnrXtraDispVO) {
		this.listCustomMnrXtraDispVO = listCustomMnrXtraDispVO;
	}
	public CustomMnrXtraDispVO[] getArrayCustomMnrXtraDispVOs() {
		return arrayCustomMnrXtraDispVOs;
	}
	public void setArrayCustomMnrXtraDispVOs(
			CustomMnrXtraDispVO[] arrayCustomMnrXtraDispVOs) {
		this.arrayCustomMnrXtraDispVOs = arrayCustomMnrXtraDispVOs;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
}
