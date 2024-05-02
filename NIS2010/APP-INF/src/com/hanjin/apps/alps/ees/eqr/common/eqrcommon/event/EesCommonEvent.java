/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : EES_COMMONEvent.java
*@FileTitle      : 시나리오 아이디 불러오기 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-09-20
*@LastModifier   : ChangHoChae
*@LastVersion    : 1.0
*@Create         : Ver 1.0    2006-09-20 ChangHoChae
*@Modify         : Ver 1.33   2009-02-10 HaengJi, Lee
*                             신규프로젝트 No  - [ S2Q-09P-004 ]
*                             Bay Plan I/F 화면추가(EES_EQR_140)에 따른 메소드 추가 - getVvd, setVvd
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.event;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EES_COMMON 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_COMMONHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChangHoChae
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCommonEvent extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesCommonConditionVO eesCommonConditionVO = null;
	/** Table Value Object Multi Data 처리 */
	public EesCommonConditionVO[] eesCommonConditionVOS = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesCommonVO eesCommonVO = null;
	/** Table Value Object Multi Data 처리 */
	public EesCommonVO[] eesCommonVOS = null;
	
	
	public EesCommonConditionVO getEesCommonConditionVO() {
		return eesCommonConditionVO;
	}
	public void setEesCommonConditionVO(EesCommonConditionVO eesCommonConditionVO) {
		this.eesCommonConditionVO = eesCommonConditionVO;
	}
	public EesCommonConditionVO[] getEesCommonConditionVOS() {
		return eesCommonConditionVOS;
	}
	public void setEesCommonConditionVOS(
			EesCommonConditionVO[] eesCommonConditionVOS) {
		this.eesCommonConditionVOS = eesCommonConditionVOS;
	}

	
	public EesCommonVO getEesCommonVO() {
		return eesCommonVO;
	}
	public void setEesCommonVO(EesCommonVO eesCommonVO) {
		this.eesCommonVO = eesCommonVO;
	}
	public EesCommonVO[] getEesCommonVOS() {
		return eesCommonVOS;
	}
	public void setEesCommonVOS(EesCommonVO[] eesCommonVOS) {
		this.eesCommonVOS = eesCommonVOS;
	}
	/**
	 * EES_COMMONEvent 객체를 생성
	 */	
	public EesCommonEvent(){
		eesCommonConditionVO = new EesCommonConditionVO();
	}
	
	/**
	 * @param yyyyww The yyyyww to set.
	 * @param seq The seq to set.
	 */			
	public EesCommonEvent(String yyyyww, String seq){
		eesCommonConditionVO = new EesCommonConditionVO();
		eesCommonConditionVO.setYyyyww(yyyyww);
		eesCommonConditionVO.setSeq(seq);
	}
	
	/**
	 * @param yyyyww The yyyyww to set.
	 * @param seq The seq to set.
	 * @param localDate The localDate to set.
	 * @param tmp The tmp to set.
	 */			
	public EesCommonEvent(String yyyyww, String seq, String localDate, int tmp){
		eesCommonConditionVO = new EesCommonConditionVO();
		eesCommonConditionVO.setYyyyww(yyyyww);
		eesCommonConditionVO.setSeq(seq);
		eesCommonConditionVO.setLocaldate(localDate);
		eesCommonConditionVO.setTmp(tmp+"");
	}
	
	/**
	 * @param locCd The locCd to set.
	 * @param type The type to set.
	 * @param temp The temp to set.
	 */		
	public EesCommonEvent(String locCd, String type, String temp){
		eesCommonConditionVO = new EesCommonConditionVO();
		eesCommonConditionVO.setLocCd(locCd);
		eesCommonConditionVO.setType(type);
		eesCommonConditionVO.setTemp(temp);
	}

	/**
	 * @param mlocCd The mlocCd to set.
	 * @param mtype The mtype to set.
	 * @param locCd The locCd to set.
	 * @param type The type to set.
	 * @param temp The temp to set.
	 */		
	public EesCommonEvent(String mlocCd, String mtype, String locCd, String type, String temp){
		eesCommonConditionVO = new EesCommonConditionVO();
		eesCommonConditionVO.setMlocCd(mlocCd);
		eesCommonConditionVO.setMtype(mtype);
		eesCommonConditionVO.setLocCd(locCd);
		eesCommonConditionVO.setType(type);
		eesCommonConditionVO.setTemp(temp);
	}
	
	/**
	 * @param eccCd The eccCd to set.
	 */		
	public EesCommonEvent(String eccCd){
		eesCommonConditionVO = new EesCommonConditionVO();
		eesCommonConditionVO.setEcccd(eccCd);
	}

}
