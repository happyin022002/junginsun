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

package com.clt.apps.opus.bcm.ccd.commoncode.service.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RLaneGroupVO {

	//private static final long serialVersionUID = 1L;
	
	//private Collection<RLaneGroupVO> models = new ArrayList<RLaneGroupVO>();
	
	/* Column Info */
	//private String rgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	//private String ibflag = null;
	/* Page Number */
	//private String pagerows = null;
	
	private RLaneVO rLaneVO = null;
	
	private RLaneVO[] rLaneVOs = null;
	
	private List<RLaneVO> rLaneVOS = null;
	
	private RLaneDtlVO rLaneDtlVO = null;
	
	private RLaneDtlVO[] rLaneDtlVOs = null;
	
	private List<RLaneDtlVO> rLaneDtlVOS = null;
	
	public void setRLaneVO(RLaneVO rLaneVO){
		this. rLaneVO = rLaneVO;
	}
	
	public RLaneVO getRLaneVO(){
		return rLaneVO;
	}
	
	public void setRLaneVOS(RLaneVO[] rLaneVOs){
		this. rLaneVOs = rLaneVOs;
	}
	
	public RLaneVO[] getRLaneVOS(){
		return rLaneVOs;
	}
	
	public void setRLaneVOS(List<RLaneVO> rLaneVOS){
		this. rLaneVOS = rLaneVOS;
	}
	
	public void setRLaneDtlVO(RLaneDtlVO rLaneDtlVO){
		this. rLaneDtlVO = rLaneDtlVO;
	}
	
	public RLaneDtlVO getRLaneDtlVO(){
		return rLaneDtlVO;
	}
	
	public void setRLaneDtlVOS(RLaneDtlVO[] rLaneDtlVOs){
		this. rLaneDtlVOs = rLaneDtlVOs;
	}
	

	public void setRLaneDtlVOS(List<RLaneDtlVO> rLaneDtlVOS){
		this. rLaneDtlVOS = rLaneDtlVOS;
	}
	
	public RLaneDtlVO[] getRLaneDtlVOs(){
		return rLaneDtlVOs;
	}
	
	public List<RLaneDtlVO> getRLaneDtlVOS(){
		return rLaneDtlVOS;
	}
}
