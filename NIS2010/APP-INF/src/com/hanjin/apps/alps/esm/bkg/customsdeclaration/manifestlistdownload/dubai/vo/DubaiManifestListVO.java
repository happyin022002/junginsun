/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListVO.java
*@FileTitle : DubaiManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.18 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DubaiManifestListVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private List<DubaiBlManifestListVO> dubaiBlManifestListVOs = null;
	private List<DubaiCntrManifestListVO> dubaiCntrManifestListVOs = null;
	private List<DubaiVesselManifestListVO> dubaiVesselManifestListVOs = null;
	private DubaiManifestListCondVO dubaiManifestListCondVO = null;
	
	public void setDubaiBlManifestListVOs(List<DubaiBlManifestListVO> dubaiBlManifestListVOs) {
		this.dubaiBlManifestListVOs = dubaiBlManifestListVOs;
	}
	public List<DubaiBlManifestListVO> getDubaiBlManifestListVOs() {
		return dubaiBlManifestListVOs;
	}
	
	public void setDubaiCntrManifestListVOs(List<DubaiCntrManifestListVO> dubaiCntrManifestListVOs) {
		this.dubaiCntrManifestListVOs = dubaiCntrManifestListVOs;
	}
	public List<DubaiCntrManifestListVO> getDubaiCntrManifestListVOs() {
		return dubaiCntrManifestListVOs;
	}
	
	public void setDubaiVesselManifestListVOs(List<DubaiVesselManifestListVO> dubaiVesselManifestListVOs) {
		this.dubaiVesselManifestListVOs = dubaiVesselManifestListVOs;
	}
	public List<DubaiVesselManifestListVO> getDubaiVesselManifestListVOs() {
		return dubaiVesselManifestListVOs;
	}
	
	public void setDubaiManifestListCondVO(DubaiManifestListCondVO dubaiManifestListCondVO) {
		this.dubaiManifestListCondVO = dubaiManifestListCondVO;
	}
	public DubaiManifestListCondVO getDubaiManifestListCondVO() {
		return dubaiManifestListCondVO;
	}
}
