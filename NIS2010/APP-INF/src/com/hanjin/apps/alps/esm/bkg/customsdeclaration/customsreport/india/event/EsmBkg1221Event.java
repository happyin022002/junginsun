/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1032Event.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndDecCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsmBkg1032Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_1032HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1221Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private IndDecCondVO indDecCondVO = null;
	
	public EsmBkg1221Event() {}

	/**
	 * @return the indDecCondVO
	 */
	public IndDecCondVO getIndDecCondVO() {
		return indDecCondVO;
	}

	/**
	 * @param indDecCondVO the indDecCondVO to set
	 */
	public void setIndDecCondVO(IndDecCondVO indDecCondVO) {
		this.indDecCondVO = indDecCondVO;
	}


}

