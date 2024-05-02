/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiComFileuploadEvent.java
*@FileTitle : File Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.05.06 김정훈
* 1.0 Creation 
=========================================================*/
package com.hanjin.syscommon.management.alps.file.event;

import java.util.Arrays;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.table.ComUpldFileVO;


/**
 * UI_COM_fileupload 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_COM_fileuploadHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong-Hoon, Kim
 * @see UI_COM_fileuploadHTMLAction 참조
 * @since J2EE 1.4
 */

public class UiComFileuploadEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComUpldFileVO comUpldFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComUpldFileVO[] comUpldFileVOs = null;

	public UiComFileuploadEvent(){}
	
	public void setComUpldFileVO(ComUpldFileVO comUpldFileVO){
		this. comUpldFileVO = comUpldFileVO;
	}

	public void setComUpldFileVOS(ComUpldFileVO[] comUpldFileVOs){
		if(comUpldFileVOs != null){
			ComUpldFileVO[] tempVOs = Arrays.copyOf(comUpldFileVOs, comUpldFileVOs.length);
			this. comUpldFileVOs = tempVOs;
		}
	}

	public ComUpldFileVO getComUpldFileVO(){
		return comUpldFileVO;
	}

	public ComUpldFileVO[] getComUpldFileVOS(){
		ComUpldFileVO[] rtnVOs = null;
		if(this.comUpldFileVOs != null){
			rtnVOs = Arrays.copyOf(this.comUpldFileVOs, this.comUpldFileVOs.length);
		}
		return rtnVOs;
	}

}