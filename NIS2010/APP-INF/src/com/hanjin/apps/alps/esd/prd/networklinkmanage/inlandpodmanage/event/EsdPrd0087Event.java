/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_085Event.java
 *@FileTitle : ESD_PRD_085Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-24
 *@LastModifier : Noh Seung Bae
 *@LastVersion : 1.0
 * 2009-08-24 Noh Seung Bae
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.PrdImdgClssCdVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author noh seung bae
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0087Event extends EventSupport{

	private String pctlImdgClssCtnt = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrdImdgClssCdVO prdImdgClssCdVO = null;
	
	/**
	 *  
	 */
	public EsdPrd0087Event(){
	}
	
	public String getPctlImdgClssCtnt() {
		return pctlImdgClssCtnt;
	}

	public void setPctlImdgClssCtnt(String pctlImdgClssCtnt) {
		this.pctlImdgClssCtnt = pctlImdgClssCtnt;
	}

	public PrdImdgClssCdVO getPrdImdgClssCdVO() {
		return prdImdgClssCdVO;
	}

	public void setPrdImdgClssCdVO(PrdImdgClssCdVO prdImdgClssCdVO) {
		this.prdImdgClssCdVO = prdImdgClssCdVO;
	}

	public String getEventName() {
		return "EsdPrd0087Event";
	}
	
	public String toString() {
		return "EsdPrd0087Event";
	}
	
 
}
