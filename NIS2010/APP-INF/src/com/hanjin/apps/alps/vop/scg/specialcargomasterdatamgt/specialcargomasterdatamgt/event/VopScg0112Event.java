/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0112Event.java
*@FileTitle : FILE ATTACH
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
* -------------------------------------------------------- 
* 처리내역 :첨부파일 팝업화면과 팝업화면에서 파일등록,삭제 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemHistoryFileVO;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see VOP_SCG_2013_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgChemHistoryFileVO scgChemHistoryFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgChemHistoryFileVO[] scgChemHistoryFileVOs = null;
	
	private List<String> keys = null;
	
	private String chemSeq;
	private String atchFileDivCd;



	public VopScg0112Event(){}
	
	public ScgChemHistoryFileVO getScgChemHistoryFileVO() {
		return scgChemHistoryFileVO;
	}

	public void setScgChemHistoryFileVO(ScgChemHistoryFileVO scgChemHistoryFileVO) {
		this.scgChemHistoryFileVO = scgChemHistoryFileVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgChemHistoryFileVO[] getScgChemHistoryFileVOs() {
		ScgChemHistoryFileVO[] rtnVOs = null;
		if (this.scgChemHistoryFileVOs != null) {
			rtnVOs = new ScgChemHistoryFileVO[scgChemHistoryFileVOs.length];
			System.arraycopy(scgChemHistoryFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgChemHistoryFileVOs(ScgChemHistoryFileVO[] scgChemHistoryFileVOs) {
		if (scgChemHistoryFileVOs != null) {
			ScgChemHistoryFileVO[] tmpVOs = new ScgChemHistoryFileVO[scgChemHistoryFileVOs.length];
			System.arraycopy(scgChemHistoryFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgChemHistoryFileVOs = tmpVOs;
		}
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public void setChemSeq(String chemSeq) {
		this.chemSeq = chemSeq;
	}
	
	public String getChemSeq() {
		// TODO Auto-generated method stub
		return this.chemSeq;
	}
	
	public void setAtchFileDivCd(String atchFileDivCd) {
		this.atchFileDivCd = atchFileDivCd;
	}
	
	public String getAtchFileDivCd() {
		// TODO Auto-generated method stub
		return this.atchFileDivCd;
	}
	

}