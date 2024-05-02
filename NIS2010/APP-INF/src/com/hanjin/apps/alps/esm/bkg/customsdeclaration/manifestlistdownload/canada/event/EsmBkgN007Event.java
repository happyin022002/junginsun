/*=========================================================
 *Copyright(c) SMLines
 *@FileName : EsmBkgN007Event.java
 *@FileTitle : B/L Inquiry: Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_N007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkgN007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String blNo = null;
	private String cntCd = null;
	
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}
	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}



	/** Table Value Object 조회 조건 처리  */
	private ContainerListCondVO containerListCondVO = null;
	private ContainerListRsltVO[] containerListRsltVOs = null;

	public ContainerListCondVO getContainerListCondVO() {
		return containerListCondVO;
	}
	public void setContainerListCondVO(ContainerListCondVO containerListCondVO) {
		this.containerListCondVO = containerListCondVO;
	}
	public ContainerListRsltVO[] getContainerListRsltVOs() {
		ContainerListRsltVO[] rtnVOs = null;
		if (this.containerListRsltVOs != null) {
			rtnVOs = Arrays.copyOf(containerListRsltVOs, containerListRsltVOs.length);
		}
		return rtnVOs;
	}
	public void setContainerListRsltVOs(ContainerListRsltVO[] containerListRsltVOs){
		if(containerListRsltVOs != null){
			ContainerListRsltVO[] tmpVOs = Arrays.copyOf(containerListRsltVOs, containerListRsltVOs.length);
			this.containerListRsltVOs = tmpVOs;
		}
	}	
	
}
