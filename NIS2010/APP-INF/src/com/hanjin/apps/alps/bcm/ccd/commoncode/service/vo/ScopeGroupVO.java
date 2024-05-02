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

public class ScopeGroupVO{

	//private static final long serialVersionUID = 1L;
	
	//private Collection<ScopeGroupVO> models = new ArrayList<ScopeGroupVO>();
	
	/* Column Info */
	//private String rgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	//private String ibflag = null;
	/* Page Number */
	//private String pagerows = null;
	
	private ScopeVO scopeVO = null;
	
	private ScopeVO[] scopeVOs = null;
	
	private List<ScopeVO> scopeVOS = null;
	
	private ScopeLaneVO scopeLaneVO = null;
	
	private ScopeLaneVO[] scopeLaneVOs = null;
	
	private List<ScopeLaneVO> scopeLaneVOS = null;
	
	private ScopeLimitVO scopeLimitVO = null;
	
	private ScopeLimitVO[] scopeLimitVOs = null;
	
	private List<ScopeLimitVO> scopeLimitVOS = null;
	
	public void setScopeVO(ScopeVO scopeVO){
		this. scopeVO = scopeVO;
	}
	
	public ScopeVO getScopeVO(){
		return scopeVO;
	}
	
	public void setScopeVOS(ScopeVO[] scopeVOs){
		this. scopeVOs = scopeVOs;
	}
	
	public ScopeVO[] getScopeVOS(){
		return scopeVOs;
	}
	
	public void setScopeVOS(List<ScopeVO> scopeVOS){
		this. scopeVOS = scopeVOS;
	}
	
	public void setScopeLaneVO(ScopeLaneVO scopeLaneVO){
		this. scopeLaneVO = scopeLaneVO;
	}
	
	public ScopeLaneVO getScopeLaneVO(){
		return scopeLaneVO;
	}
	
	public void setScopeLaneVOS(ScopeLaneVO[] scopeLaneVOs){
		this. scopeLaneVOs = scopeLaneVOs;
	}
	

	public void setScopeLaneVOS(List<ScopeLaneVO> scopeLaneVOS){
		this. scopeLaneVOS = scopeLaneVOS;
	}
	
	public ScopeLaneVO[] getScopeLaneVOs(){
		return scopeLaneVOs;
	}
	
	public List<ScopeLaneVO> getScopeLaneVOS(){
		return scopeLaneVOS;
	}
	
	public void setScopeLimitVO(ScopeLimitVO scopeLimitVO){
		this. scopeLimitVO = scopeLimitVO;
	}
	
	public ScopeLimitVO getScopeLimitVO(){
		return scopeLimitVO;
	}
	
	public void setScopeLimitVOS(ScopeLimitVO[] scopeLimitVOs){
		this. scopeLimitVOs = scopeLimitVOs;
	}
	
	public void setScopeLimitVOS(List<ScopeLimitVO> scopeLimitVOS){
		this. scopeLimitVOS = scopeLimitVOS;
	}
	
	public ScopeLimitVO[] getScopeLimitVOs(){
		return scopeLimitVOs;
	}
	
	public List<ScopeLimitVO> getScopeLimitVOS(){
		return scopeLimitVOS;
	}
}
