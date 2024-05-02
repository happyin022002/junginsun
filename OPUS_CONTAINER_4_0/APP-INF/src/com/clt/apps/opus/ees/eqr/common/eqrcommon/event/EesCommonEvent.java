/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : EES_COMMONEvent.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
*@Create         : 
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.event;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;



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
	private EesCommonConditionVO[] eesCommonConditionVOS = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesCommonVO eesCommonVO = null;
	/** Table Value Object Multi Data 처리 */
	private EesCommonVO[] eesCommonVOS = null;
	
	
	public EesCommonConditionVO getEesCommonConditionVO() {
		return eesCommonConditionVO;
	}
	public void setEesCommonConditionVO(EesCommonConditionVO eesCommonConditionVO) {
		this.eesCommonConditionVO = eesCommonConditionVO;
	}
	public EesCommonConditionVO[] getEesCommonConditionVOS() {
		EesCommonConditionVO[] tmpVOs = null;
		if (this.eesCommonConditionVOS != null) {
			tmpVOs = new EesCommonConditionVO[eesCommonConditionVOS.length];
			System.arraycopy(eesCommonConditionVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setEesCommonConditionVOS(
			EesCommonConditionVO[] eesCommonConditionVOS) {
		if (eesCommonConditionVOS != null) {
			EesCommonConditionVO[] tmpVOs = new EesCommonConditionVO[eesCommonConditionVOS.length];
			System.arraycopy(eesCommonConditionVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesCommonConditionVOS = tmpVOs;
		}
	}

	
	public EesCommonVO getEesCommonVO() {
		return eesCommonVO;
	}
	public void setEesCommonVO(EesCommonVO eesCommonVO) {
		this.eesCommonVO = eesCommonVO;
	}
	public EesCommonVO[] getEesCommonVOS() {
		EesCommonVO[] tmpVOs = null;
		if (this.eesCommonVOS != null) {
			tmpVOs = new EesCommonVO[eesCommonVOS.length];
			System.arraycopy(eesCommonVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setEesCommonVOS(EesCommonVO[] eesCommonVOS) {
		if (eesCommonVOS != null) {
			EesCommonVO[] tmpVOs = new EesCommonVO[eesCommonVOS.length];
			System.arraycopy(eesCommonVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesCommonVOS = tmpVOs;
		}
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
