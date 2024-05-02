/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SoldEQFileListGRPVO
*@FileTitle : Sold Creation File Import_Pop Up
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 10.06
*@LastModifier : 
*@LastVersion : 1.0
*2009. 10.06. 김완규 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;

/**
 * SoldEQFileListGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class SoldEQFileListGRPVO {
	//조회조건을 받기 위한
	private SoldEQFileListINVO soldEQFileListINVO = null;
	//조회결과을 받기 위한
	private  List <CustomMnrDatVrfyVO> listCustomMnrDatVrfyVO = null;
	//CUD처리를 위한 
	private CustomMnrDatVrfyVO[] arrayCustomMnrDatVrfyVO = null;
	
	public SoldEQFileListINVO getSoldEQFileListINVO() {
		return soldEQFileListINVO;
	}
	public void setSoldEQFileListINVO(SoldEQFileListINVO soldEQFileListINVO) {
		this.soldEQFileListINVO = soldEQFileListINVO;
	}
	public List<CustomMnrDatVrfyVO> getListCustomMnrDatVrfyVO() {
		return listCustomMnrDatVrfyVO;
	}
	public void setListCustomMnrDatVrfyVO(
			List<CustomMnrDatVrfyVO> listCustomMnrDatVrfyVO) {
		this.listCustomMnrDatVrfyVO = listCustomMnrDatVrfyVO;
	}
	public CustomMnrDatVrfyVO[] getArrayCustomMnrDatVrfyVO() {
		return arrayCustomMnrDatVrfyVO;
	}
	public void setArrayCustomMnrDatVrfyVO(
			CustomMnrDatVrfyVO[] arrayCustomMnrDatVrfyVO) {
		this.arrayCustomMnrDatVrfyVO = arrayCustomMnrDatVrfyVO;
	}
}
