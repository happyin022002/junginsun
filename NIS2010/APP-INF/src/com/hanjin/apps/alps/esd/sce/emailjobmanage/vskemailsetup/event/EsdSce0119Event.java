/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdSce0119Event.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.vo.VslSkdEmlSetUpVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SCE_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Jun Yong
 * @see ESD_SCE_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String laneCdVerify = null; 
	private String portCdVerify = null; 
	
	private VslSkdEmlSetUpVO   vslSkdEmlSetUpVo;
	
	private VslSkdEmlSetUpVO[] vslSkdEmlSetUpVos;

	public VslSkdEmlSetUpVO getVslSkdEmlSetUpVo() {
		return vslSkdEmlSetUpVo;
	}

	public void setVslSkdEmlSetUpVo(VslSkdEmlSetUpVO vslSkdEmlSetUpVo) {
		this.vslSkdEmlSetUpVo = vslSkdEmlSetUpVo;
	}

	public VslSkdEmlSetUpVO[] getVslSkdEmlSetUpVos() {
		return vslSkdEmlSetUpVos; 
	}

	public void setVslSkdEmlSetUpVos(VslSkdEmlSetUpVO[] vslSkdEmlSetUpVos) {
		this.vslSkdEmlSetUpVos = vslSkdEmlSetUpVos;
	}
	
	public String getLaneCdVerify() {
		return laneCdVerify;
	}
	
	public String getPortCdVerify() {
		return portCdVerify;
	}

	public void setLaneCdVerify(String laneCdVerify) {
		this.laneCdVerify = laneCdVerify;
	}
	
	public void setPortCdVerify(String portCdVerify) {
		this.portCdVerify = portCdVerify;
	}

	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("laneCdVerify", this.getLaneCdVerify());
		this.hashColumns.put("portCdVerify", this.getPortCdVerify());
		return this.hashColumns;
	}
}