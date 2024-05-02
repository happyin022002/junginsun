/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistranManifestListVO.java
*@FileTitle : PakistranManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.24
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.07.24 김보배
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo;

import java.util.List;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PakistanManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private PakistanVesselVO pakistanVesselVO;
	private List<PakistanVesselVO> pakistanVesselVOs;

	private PakistanBlInfoVO pakistanBlInfoVO;
	private List<PakistanBlInfoVO> pakistanBlInfoVOs;

	private PakistanCNTRInfoVO pakistanCNTRInfoVO;
	private List<PakistanCNTRInfoVO> pakistanCNTRInfoVOs;
	
	private PakistanBlInfoVO pakistanChargeInfoVO;
	private List<PakistanBlInfoVO> pakistanChargeInfoVOs;
	
	public PakistanManifestListVO() {}

	
	
	public PakistanVesselVO getPakistanVesselVO() {
		return pakistanVesselVO;
	}
	public void setPakistanVesselVO(PakistanVesselVO pakistanVesselVO) {
		this.pakistanVesselVO = pakistanVesselVO;
	}

	
	public List<PakistanVesselVO> getPakistanVesselVOs() {
		return pakistanVesselVOs;
	}
	public void setPakistanVesselVOs(List<PakistanVesselVO> pakistanVesselVOs) {
		this.pakistanVesselVOs = pakistanVesselVOs;
	}



	public PakistanBlInfoVO getPakistanBlInfoVO() {
		return pakistanBlInfoVO;
	}
	public void setPakistanBlInfoVO(PakistanBlInfoVO pakistanBlInfoVO) {
		this.pakistanBlInfoVO = pakistanBlInfoVO;
	}

	
	public List<PakistanBlInfoVO> getPakistanBlInfoVOs() {
		return pakistanBlInfoVOs;
	}
	public void setPakistanBlInfoVOs(List<PakistanBlInfoVO> pakistanBlInfoVOs) {
		this.pakistanBlInfoVOs = pakistanBlInfoVOs;
	}
	
	
	public PakistanCNTRInfoVO getPakistanCNTRInfoVO() {
		return pakistanCNTRInfoVO;
	}
	public void setPakistanCNTRInfoVO(PakistanCNTRInfoVO pakistanCNTRInfoVO) {
		this.pakistanCNTRInfoVO = pakistanCNTRInfoVO;
	}

	
	public List<PakistanCNTRInfoVO> getPakistanCNTRInfoVOs() {
		return pakistanCNTRInfoVOs;
	}
	public void setPakistanCNTRInfoVOs(List<PakistanCNTRInfoVO> pakistanCNTRInfoVOs) {
		this.pakistanCNTRInfoVOs = pakistanCNTRInfoVOs;
	}



	public PakistanBlInfoVO getPakistanChargeInfoVO() {
		return pakistanChargeInfoVO;
	}
	public void setPakistanChargeInfoVO(PakistanBlInfoVO pakistanChargeInfoVO) {
		this.pakistanChargeInfoVO = pakistanChargeInfoVO;
	}

	public List<PakistanBlInfoVO> getPakistanChargeInfoVOs() {
		return pakistanChargeInfoVOs;
	}
	public void setPakistanChargeInfoVOs(
			List<PakistanBlInfoVO> pakistanChargeInfoVOs) {
		this.pakistanChargeInfoVOs = pakistanChargeInfoVOs;
	}
}
