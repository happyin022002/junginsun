/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MstComEvent.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.ComIntgCdListDataVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * PDTO(Data Transfer Object including Parameters) for CIM_COM
 * implementing in CIM_COMHTMLAction
 * using as PDTO for transmit to ServiceCommand Layer
 *
 * @author 
 * @see CIM_COMHTMLAction reference
 * @since J2EE 1.6
 */

public class CimComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object retrieving option , handling single data  */
	private ComIntgCdListDataVO comIntgCdListDataVO = null;
	
	/** handling Table Value Object Multi Data */
	private ComIntgCdListDataVO[] comIntgCdListDataVOs = null;
	
	/** INTG CD ID retrieving option **/
	private String intgCdId="";
	
	/** INTG CD VAL retrieving option **/
	private String intgCdVal="";
	
	/**
	 * @return the commonListVOs
	 */
	public ComIntgCdListDataVO[] getCommonListVOs() {
		ComIntgCdListDataVO[] tmpVOs = null;
		  if (this.comIntgCdListDataVOs != null) {
		   tmpVOs = new ComIntgCdListDataVO[comIntgCdListDataVOs.length];
		   System.arraycopy(comIntgCdListDataVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		return tmpVOs;
	}

	

	public ComIntgCdListDataVO getComIntgCdListDataVO() {
		return comIntgCdListDataVO;
	}



	public void setComIntgCdListDataVO(ComIntgCdListDataVO comIntgCdListDataVO) {
		this.comIntgCdListDataVO = comIntgCdListDataVO;
	}



	public ComIntgCdListDataVO[] getComIntgCdListDataVOs() {
		ComIntgCdListDataVO[] tmpVOs = null;
		  if (this.comIntgCdListDataVOs != null) {
		   tmpVOs = new ComIntgCdListDataVO[comIntgCdListDataVOs.length];
		   System.arraycopy(comIntgCdListDataVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;
	}



	public void setComIntgCdListDataVOs(ComIntgCdListDataVO[] comIntgCdListDataVOs) {
		  if (comIntgCdListDataVOs != null) {
			  ComIntgCdListDataVO[] tmpVOs = new ComIntgCdListDataVO[comIntgCdListDataVOs.length];
			   System.arraycopy(comIntgCdListDataVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.comIntgCdListDataVOs = tmpVOs;
			  }
	}



	public String getIntgCdId() {
		return intgCdId;
	}

	public void setIntgCdVal(String intgCdVal) {
		this.intgCdVal = intgCdVal;
	}
	
	public String getIntgCdVal() {
		return intgCdVal;
	}

	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}

}