/*=========================================================
 *Copyright(c) SMLines
 *@FileName : EsmBkgN010Event.java
 *@FileTitle : EsmBkgN010Event
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Min Jeong
 * @see ESM_BKG_N007HTMLAction 참조
 * @since J2EE 1.4
 */ 

public class EsmBkgN010Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CstmsVvdInfoVO cstmsVvdInfoVO = null;
	private CstmsVvdInfoVO[] cstmsVvdInfoVOs = null;
	private CstmsVvdInfoCondVO cstmsVvdInfoCondVO = null;
	private CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO = null;
	private String ieTypeCd = null;

	public String getIeTypeCd() {
		return ieTypeCd;
	}

	public void setIeTypeCd(String ieTypeCd) {
		this.ieTypeCd = ieTypeCd;
	}

	public EsmBkgN010Event() {
	}

	public void setCstmsVvdInfoVO(CstmsVvdInfoVO cstmsVvdInfoVO) {
		this.cstmsVvdInfoVO = cstmsVvdInfoVO;
	}

	public void setCstmsVvdInfoVOS(CstmsVvdInfoVO[] cstmsVvdInfoVOs) {
		if (cstmsVvdInfoVOs != null)
			this.cstmsVvdInfoVOs = Arrays.copyOf(cstmsVvdInfoVOs, cstmsVvdInfoVOs.length);
	}

	public void setCstmsVvdInfoCondVO(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) {
		this.cstmsVvdInfoCondVO = cstmsVvdInfoCondVO;
	}

	public void setCstmsVvdRefNoCondVO(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) {
		this.cstmsVvdRefNoCondVO = cstmsVvdRefNoCondVO;
	}

	public CstmsVvdInfoVO getCstmsVvdInfoVO() {
		return cstmsVvdInfoVO;
	}

	public CstmsVvdRefNoCondVO getCstmsVvdRefNoCondVO() {
		return cstmsVvdRefNoCondVO;
	}

	public CstmsVvdInfoVO[] getCstmsVvdInfoVOS() {
		CstmsVvdInfoVO[] rtnVOs = null;
		if (cstmsVvdInfoVOs != null)
			rtnVOs = Arrays.copyOf(cstmsVvdInfoVOs, cstmsVvdInfoVOs.length);
		return rtnVOs;
	}

	public CstmsVvdInfoCondVO getCstmsVvdInfoCondVO() {
		return cstmsVvdInfoCondVO;
	}
}