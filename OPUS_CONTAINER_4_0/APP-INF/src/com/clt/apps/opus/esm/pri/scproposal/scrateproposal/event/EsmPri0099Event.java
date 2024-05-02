/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0099Event.java
 *@FileTitle : EsmPri0099Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.07.30 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;

/**
 * UI_PRI_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0029HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	private RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	private String key = null;

	public EsmPri0099Event() {
	}

	/**
	 * @return the priSpScpRtCmdtHdrVO
	 */
	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO() {
		return priSpScpRtCmdtHdrVO;
	}

	/**
	 * @param priSpScpRtCmdtHdrVO the priSpScpRtCmdtHdrVO to set
	 */
	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

	/**
	 * @return the rsltRtListHorizontalExcelVOS
	 */
	public RsltRtListHorizontalExcelVO[] getRsltRtListHorizontalExcelVOS() {
		RsltRtListHorizontalExcelVO[] tmpVOs = null;
		if (this.rsltRtListHorizontalExcelVOS != null) {
			tmpVOs = new RsltRtListHorizontalExcelVO[rsltRtListHorizontalExcelVOS.length];
			System.arraycopy(rsltRtListHorizontalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRtListHorizontalExcelVOS the rsltRtListHorizontalExcelVOS to set
	 */
	public void setRsltRtListHorizontalExcelVOS(RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS) {
		if (rsltRtListHorizontalExcelVOS != null) {
			RsltRtListHorizontalExcelVO[] tmpVOs = new RsltRtListHorizontalExcelVO[rsltRtListHorizontalExcelVOS.length];
			System.arraycopy(rsltRtListHorizontalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListHorizontalExcelVOS = tmpVOs;
		}
	}
	
	
	
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		ComBakEndJbVO[] tmpVOs = null;
		if (this.comBakEndJbVOs != null) {
			tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}