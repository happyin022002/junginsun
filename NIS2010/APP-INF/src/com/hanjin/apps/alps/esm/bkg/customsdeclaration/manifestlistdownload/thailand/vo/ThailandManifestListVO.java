/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ThailandManifestListBlInfoVO.java
*@FileTitle : ThailandManifestListBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo;

import java.util.List;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ThailandManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<ThailandManifestListBlInfoVO> thailandManifestListBlInfoVOs;
	private List<ThailandManifestListCntrInfoVO> thailandManifestListCntrInfoVOs;
	private ThailandManifestListCondVO thailandManifestListCondVO = null;

	public ThailandManifestListVO() {}

	public List<ThailandManifestListBlInfoVO> getThailandManifestListBlInfoVOs() {
		return thailandManifestListBlInfoVOs;
	}

	public void setThailandManifestListBlInfoVOs(
			List<ThailandManifestListBlInfoVO> thailandManifestListBlInfoVOs) {
		this.thailandManifestListBlInfoVOs = thailandManifestListBlInfoVOs;
	}

	public List<ThailandManifestListCntrInfoVO> getThailandManifestListCntrInfoVOs() {
		return thailandManifestListCntrInfoVOs;
	}

	public void setThailandManifestListCntrInfoVOs(
			List<ThailandManifestListCntrInfoVO> thailandManifestListCntrInfoVOs) {
		this.thailandManifestListCntrInfoVOs = thailandManifestListCntrInfoVOs;
	}

	public ThailandManifestListCondVO getThailandManifestListCondVO() {
		return thailandManifestListCondVO;
	}

	public void setThailandManifestListCondVO(
			ThailandManifestListCondVO thailandManifestListCondVO) {
		this.thailandManifestListCondVO = thailandManifestListCondVO;
	}

}
