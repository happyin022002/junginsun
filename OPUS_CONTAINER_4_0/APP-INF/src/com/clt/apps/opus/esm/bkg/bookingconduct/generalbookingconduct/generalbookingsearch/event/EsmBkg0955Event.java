/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0955HTMLAction.java
*@FileTitle : Booking History (B/L Data)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0955 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0955HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0955HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0955Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private String	  sheetRow	= null;
	private String	  sheetIdx  = null;
	
	
	public EsmBkg0955Event(){}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	/**
	 * @return the sheetRow
	 */
	public String getSheetRow() {
		return sheetRow;
	}

	/**
	 * @param sheetRow the sheetRow to set
	 */
	public void setSheetRow(String sheetRow) {
		this.sheetRow = sheetRow;
	}

	/**
	 * @return the sheetIdx
	 */
	public String getSheetIdx() {
		return sheetIdx;
	}

	/**
	 * @param sheetIdx the sheetIdx to set
	 */
	public void setSheetIdx(String sheetIdx) {
		this.sheetIdx = sheetIdx;
	}


}