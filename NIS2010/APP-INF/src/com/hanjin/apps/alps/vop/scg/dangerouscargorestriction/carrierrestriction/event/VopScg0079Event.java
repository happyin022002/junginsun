/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg201301Event.java
*@FileTitle : Supporting Documents or Pictures
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.08 김현욱
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 처리내역 :첨부파일 팝업화면과 팝업화면에서 파일등록,삭제 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_2013_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FileVO fileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FileVO[] fileVOs = null;
	
	private List<String> keys = null;


	public VopScg0079Event(){}
	
	public FileVO getFileVO() {
		return fileVO;
	}

	public void setFileVO(FileVO fileVO) {
		this.fileVO = fileVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public FileVO[] getFileVOs() {
		FileVO[] rtnVOs = null;
		if (this.fileVOs != null) {
			rtnVOs = new FileVO[fileVOs.length];
			System.arraycopy(fileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setFileVOs(FileVO[] fileVOs) {
		if (fileVOs != null) {
			FileVO[] tmpVOs = new FileVO[fileVOs.length];
			System.arraycopy(fileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fileVOs = tmpVOs;
		}
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	

}