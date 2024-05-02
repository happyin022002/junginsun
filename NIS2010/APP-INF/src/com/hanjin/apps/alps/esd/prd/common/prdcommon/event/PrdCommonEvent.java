/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : Event.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.event;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class PrdCommonEvent extends EventSupport{

	private static final long serialVersionUID = 1L;
	private String chkData;
	private ContinentVO continentVO;
	private ValidationVO validationVO;
	
    /**
     * @return the validationVO
     */
    public ValidationVO getValidationVO() {
        return validationVO;
    }

    /**
     * @param validationVO the validationVO to set
     */
    public void setValidationVO(ValidationVO validationVO) {
        this.validationVO = validationVO;
    }

	/**
	 *
	 */
	public PrdCommonEvent(){
	}

	/**
	 *
	 * @param chkData
	 */
	public void setChkData(String chkData){
		this.chkData = chkData;
	}

	/**
	 *
	 * @return
	 */
	public String getChkData(){
		return chkData;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String getEventName(){
		return "PrdCommonEvent";
	}

	@Override
	public String toString(){
		return "PrdCommonEvent";
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public Object getObject(String key){
		return (key == null) ? null : this.getAttribute(key);
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp == null) ? "" : (String) tmp;
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public int getInt(String key){
		String tmp = this.getString(key);
		return ("".equals(tmp)) ? 0 : Integer.parseInt(tmp);
	}

	/**
	 *
	 * @param key
	 * @param value
	 */
	public void putValue(String key, Object value){
		if(key == null){
			return;
		}
		this.setAttribute(key, value);
	}

	/**
	 * @return the continentVO
	 */
	public ContinentVO getContinentVO(){
		return continentVO;
	}

	/**
	 * @param continentVO the continentVO to set
	 */
	public void setContinentVO(ContinentVO continentVO){
		this.continentVO = continentVO;
	}


}
