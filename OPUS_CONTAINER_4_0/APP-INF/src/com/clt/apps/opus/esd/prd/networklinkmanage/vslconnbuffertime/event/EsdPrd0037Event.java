/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0037Event.java
 *@FileTitle : EsdPrd0037Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.08.03
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.vo.VslConnBufferTimeListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0037Event extends EventSupport {

	private static final long serialVersionUID = -3918536174849906625L;

	private VslConnBufferTimeListVO vslConnBufferTimeListVO;

	private VslConnBufferTimeListVO[] vslConnBufferTimeListVOs;

	public EsdPrd0037Event() {
	}

	/**
	 * 
	 * @return
	 */
	public VslConnBufferTimeListVO getVslConnBufferTimeListVO() {
		return vslConnBufferTimeListVO;
	}

	/**
	 * 
	 * @param vslConnBufferTimeListVO
	 */
	public void setVslConnBufferTimeListVO(VslConnBufferTimeListVO vslConnBufferTimeListVO) {
		this.vslConnBufferTimeListVO = vslConnBufferTimeListVO;
	}

	/**
	 * 
	 * @return
	 */
	public VslConnBufferTimeListVO[] getVslConnBufferTimeListVOs() {
		VslConnBufferTimeListVO[] tmpVOs = null;
		if (this.vslConnBufferTimeListVOs != null) {
			tmpVOs = new VslConnBufferTimeListVO[this.vslConnBufferTimeListVOs.length];
			System.arraycopy(this.vslConnBufferTimeListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param vslConnBufferTimeListVOs
	 */
	public void setVslConnBufferTimeListVOs(VslConnBufferTimeListVO[] vslConnBufferTimeListVOs) {
		if (vslConnBufferTimeListVOs != null) {
			VslConnBufferTimeListVO[] tmpVOs = new VslConnBufferTimeListVO[vslConnBufferTimeListVOs.length];
			System.arraycopy(vslConnBufferTimeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslConnBufferTimeListVOs = tmpVOs;
		}
	}

}
