/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_SCG_0080HTMLAction.java
*@FileTitle : Special Cargo Guidance
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.07 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceFileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Young Oh
 * @see VOP_SCG_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0080Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgGuidanceVO scgGuidanceVO = null;
	private ScgGuidanceFileVO scgGuidanceFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgGuidanceVO[] scgGuidanceVOs = null;
	private ScgGuidanceFileVO[] scgGuidanceFileVOs = null;
		
	private List<String> keys = null;

	private String[] 		strKeys	= null;

	public VopScg0080Event(){}
	
	
	public ScgGuidanceVO getScgGuidanceVO() {
		return scgGuidanceVO;
	}

	public void setScgGuidanceVO(ScgGuidanceVO scgGuidanceVO) {
		this.scgGuidanceVO = scgGuidanceVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgGuidanceVO[] getScgGuidanceVOs() {
		ScgGuidanceVO[] rtnVOs = null;
		if (this.scgGuidanceVOs != null) {
			rtnVOs = new ScgGuidanceVO[scgGuidanceVOs.length];
			System.arraycopy(scgGuidanceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public String[] getStrKeys() {
		String[] rtnVOs = null;
		if (this.strKeys != null) {
			rtnVOs = new String[strKeys.length];
			System.arraycopy(strKeys, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setStrKeys(String[] strKeys) {
		if (strKeys != null) {
			String[] tmpVOs = new String[strKeys.length];
			System.arraycopy(strKeys, 0, tmpVOs, 0, tmpVOs.length);
			this.strKeys = tmpVOs;
		}
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgGuidanceVOs(ScgGuidanceVO[] scgGuidanceVOs) {
		if (scgGuidanceVOs != null) {
			ScgGuidanceVO[] tmpVOs = new ScgGuidanceVO[scgGuidanceVOs.length];
			System.arraycopy(scgGuidanceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgGuidanceVOs = tmpVOs;
		}
	}

	public ScgGuidanceFileVO getScgGuidanceFileVO() {
		return scgGuidanceFileVO;
	}


	public void setScgGuidanceFileVO(ScgGuidanceFileVO scgGuidanceFileVO) {
		this.scgGuidanceFileVO = scgGuidanceFileVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgGuidanceFileVO[] getScgGuidanceFileVOs() {
		ScgGuidanceFileVO[] rtnVOs = null;
		if (this.scgGuidanceFileVOs != null) {
			rtnVOs = new ScgGuidanceFileVO[scgGuidanceFileVOs.length];
			System.arraycopy(scgGuidanceFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgGuidanceFileVOs(ScgGuidanceFileVO[] scgGuidanceFileVOs) {
		if (scgGuidanceFileVOs != null) {
			ScgGuidanceFileVO[] tmpVOs = new ScgGuidanceFileVO[scgGuidanceFileVOs.length];
			System.arraycopy(scgGuidanceFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgGuidanceFileVOs = tmpVOs;
		}
	}

	public List<String> getKeys() {
		return keys;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

}