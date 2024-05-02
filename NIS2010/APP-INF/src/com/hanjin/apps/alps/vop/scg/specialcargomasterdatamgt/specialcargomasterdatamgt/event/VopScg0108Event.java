/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VopScg0108Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.02.27 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.List;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguImgVO;


/**
 * VOP_AOM_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JA YOUNG SHIN
 * @see VOP_SCG_0108HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0108Event extends EventSupport {

	// File attach start ** 2013.02.28
	private List<String> keys = null;
	
	private String[] 		strKeys	= null;	//::2011.11.22 append::jsk

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckReguImgVO ScgPckReguImgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckReguImgVO[] ScgPckReguImgVOs = null;

	public VopScg0108Event(){}
	
	public void setScgPckReguImgVO(ScgPckReguImgVO ScgPckReguImgVO){
		this. ScgPckReguImgVO = ScgPckReguImgVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckReguImgVOs(ScgPckReguImgVO[] ScgPckReguImgVOs){
		if (ScgPckReguImgVOs != null) {
			ScgPckReguImgVO[] tmpVOs = new ScgPckReguImgVO[ScgPckReguImgVOs.length];
			System.arraycopy(ScgPckReguImgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ScgPckReguImgVOs = tmpVOs;
		}
	}

	public ScgPckReguImgVO getScgPckReguImgVO(){
		return ScgPckReguImgVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckReguImgVO[] getScgPckReguImgVOs(){
		ScgPckReguImgVO[] rtnVOs = null;
		if (this.ScgPckReguImgVOs != null) {
			rtnVOs = new ScgPckReguImgVO[ScgPckReguImgVOs.length];
			System.arraycopy(ScgPckReguImgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	
	public List<String> getKeys() {
		return keys;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public String[] getStrKeys(){
		String[] rtnVOs = null;
		if (this.strKeys != null) {
			rtnVOs = new String[strKeys.length];
			System.arraycopy(strKeys, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setStrKeys(String[] strKeys){
		if (strKeys != null) {
			String[] tmpVOs = new String[strKeys.length];
			System.arraycopy(strKeys, 0, tmpVOs, 0, tmpVOs.length);
			this.strKeys = tmpVOs;
		}
	}
}