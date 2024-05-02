/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmPri0151Event.java
*@FileTitle : MOF Filing (Formatted)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_PRI_0151 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0151HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE HYE MIN
 * @see ESM_PRI_0151HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0151Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	private RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO = null;

	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	private String backendjobKey = null;
	
	public EsmPri0151Event(){}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		if(comBakEndJbVOs != null){
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * @return the rsltSearchKoreaMOTListVO
	 */
	public RsltSearchKoreaMOTListVO getRsltSearchKoreaMOTListVO() {
		return rsltSearchKoreaMOTListVO;
	}

	/**
	 * @param rsltSearchKoreaMOTListVO the rsltSearchKoreaMOTListVO to set
	 */
	public void setRsltSearchKoreaMOTListVO(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) {
		this.rsltSearchKoreaMOTListVO = rsltSearchKoreaMOTListVO;
	}
	
	/**
	 * @return the backendjobKey
	 */
	public String getBackendjobKey() {
		return backendjobKey;
	}

	/**
	 * @param backendjobKey the backendjobKey to set
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
}
