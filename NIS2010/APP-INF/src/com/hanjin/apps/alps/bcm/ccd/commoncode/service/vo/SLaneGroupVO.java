/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchScpLimitCodeVO.java
*@FileTitle : SearchScpLimitCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SLaneGroupVO {

	//private static final long serialVersionUID = 1L;
	
	//private Collection<SLaneGroupVO> models = new ArrayList<SLaneGroupVO>();
	
	/* Column Info */
	//private String rgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	//private String ibflag = null;
	/* Page Number */
	//private String pagerows = null;
	
	private SLaneVO sLaneVO = null;
	
	private SLaneVO[] sLaneVOs = null;
	
	private List<SLaneVO> sLaneVOS = null;
	
	private SLaneDirVO sLaneDirVO = null;
	
	private SLaneDirVO[] sLaneDirVOs = null;
	
	private List<SLaneDirVO> sLaneDirVOS = null;
	
	public void setSLaneVO(SLaneVO sLaneVO){
		this. sLaneVO = sLaneVO;
	}
	
	public SLaneVO getSLaneVO(){
		return sLaneVO;
	}
	
	public void setSLaneVOS(SLaneVO[] sLaneVOs){
		this. sLaneVOs = sLaneVOs;
	}
	
	public SLaneVO[] getRLaneVOS(){
		return sLaneVOs;
	}
	
	public void setSLaneVOS(List<SLaneVO> sLaneVOS){
		this. sLaneVOS = sLaneVOS;
	}
	
	public void setSLaneDirVO(SLaneDirVO sLaneDirVO){
		this. sLaneDirVO = sLaneDirVO;
	}
	
	public SLaneDirVO getSLaneDirVO(){
		return sLaneDirVO;
	}
	
	public void setSLaneDirVOS(SLaneDirVO[] sLaneDirVOs){
		this. sLaneDirVOs = sLaneDirVOs;
	}
	

	public void setSLaneDirVOS(List<SLaneDirVO> sLaneDirVOS){
		this. sLaneDirVOS = sLaneDirVOS;
	}
	
	public SLaneDirVO[] getSLaneDirVOs(){
		return sLaneDirVOs;
	}
	
	public List<SLaneDirVO> getSLaneDirVOS(){
		return sLaneDirVOS;
	}
}
