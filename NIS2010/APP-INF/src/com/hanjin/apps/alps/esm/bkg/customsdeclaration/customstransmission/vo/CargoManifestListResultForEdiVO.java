/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CargoManifestListResultForEdiVO.java
 *@FileTitle : CargoManifestListResultForEdiVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.15
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.15 김도완
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxVslResultVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 김도완
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class CargoManifestListResultForEdiVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private MxVslResultVO mxVslResultVO;
	private List<MxManifestListByVvdDetailVO> mxManifestListByVvdDetailVOs;

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CargoManifestListResultForEdiVO() {}
	
	public MxVslResultVO getMxVslResultVO() {
		return mxVslResultVO;
	}
	
	public void setMxVslResultVO(MxVslResultVO mxVslResultVO) {
		this.mxVslResultVO = mxVslResultVO;
	}

	public List<MxManifestListByVvdDetailVO> getMxManifestListByVvdDetailVOs() {
		
		return mxManifestListByVvdDetailVOs;
	}
	
	public void setMxManifestListByVvdDetailVOs(List<MxManifestListByVvdDetailVO> mxManifestListByVvdDetailVOs) {
		this.mxManifestListByVvdDetailVOs = mxManifestListByVvdDetailVOs;
	}
	


}