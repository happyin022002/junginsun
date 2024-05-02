/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0393Event.java
*@FileTitle : House B/L Data Input Checklist
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.30 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0393 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0393HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0393HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0393Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 처리  */
	private String customs = null;
	private HouseBlCondVO houseBlCondVO = null;
	private HouseBlDetailVO[] houseBlDetailVOs = null;
	
	/**
	 * @return the customs
	 */
	public String getCustoms() {
		return customs;
	}
	/**
	 * @param customs the customs to set
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	/**
	 * @return the houseBlCondVO
	 */
	public HouseBlCondVO getHouseBlCondVO() {
		return houseBlCondVO;
	}
	/**
	 * @param houseBlCondVO the houseBlCondVO to set
	 */
	public void setHouseBlCondVO(HouseBlCondVO houseBlCondVO) {
		this.houseBlCondVO = houseBlCondVO;
	}
	/**
	 * @return the houseBlDetailVOs
	 */
	public HouseBlDetailVO[] getHouseBlDetailVOs() {
		HouseBlDetailVO[] rtnVOs = null;
		if (this.houseBlDetailVOs != null) {
			rtnVOs = Arrays.copyOf(houseBlDetailVOs, houseBlDetailVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param houseBlDetailVOs the houseBlDetailVOs to set
	 */
	public void setHouseBlDetailVOs(HouseBlDetailVO[] houseBlDetailVOs){
		if(houseBlDetailVOs != null){
			HouseBlDetailVO[] tmpVOs = Arrays.copyOf(houseBlDetailVOs, houseBlDetailVOs.length);
			this.houseBlDetailVOs = tmpVOs;
		}
	}
	
}