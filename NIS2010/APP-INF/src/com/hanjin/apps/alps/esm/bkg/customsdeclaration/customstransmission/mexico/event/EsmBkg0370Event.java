/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0370Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.15
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.15 김도완
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.VslCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0370 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0370HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_0370HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0370Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private VslCondVO condVo = null;
	private MxManifestListByVvdDetailVO[] detailVOs = null;
	private String key = "";

	public EsmBkg0370Event() {}

	public void setCondVO(VslCondVO condVo) {
		this.condVo = condVo;
	}
	public VslCondVO getCondVO() {
		return condVo;
	}


	public void setDetailVOs(MxManifestListByVvdDetailVO[] detailVOs){
		if(detailVOs != null){
			MxManifestListByVvdDetailVO[] tmpVOs = Arrays.copyOf(detailVOs, detailVOs.length);
			this.detailVOs = tmpVOs;
		}
	}
	public MxManifestListByVvdDetailVO[] getDetailVOs() {
		MxManifestListByVvdDetailVO[] rtnVOs = null;
		if (this.detailVOs != null) {
			rtnVOs = Arrays.copyOf(detailVOs, detailVOs.length);
		}
		return rtnVOs;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
}