/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdoRqstVO.java
*@FileTitle : EdoRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgEdoCntrVO;
import com.clt.syscommon.common.table.BkgEdoDoVO;
import com.clt.syscommon.common.table.BkgEdoIbdTrspVO;
import com.clt.syscommon.common.table.BkgEdoMstVO;
import com.clt.syscommon.common.table.BkgEdoPtyTrspVO;
import com.clt.syscommon.common.table.BkgEdoSelfTrspVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdoRqstVO {

    private BkgEdoMstVO bkgEdoMstVO;
    private BkgEdoDoVO bkgEdoDoVO;
    private BkgEdoIbdTrspVO bkgEdoIbdTrspVO;
    private BkgEdoSelfTrspVO bkgEdoSelfTrspVO;
    private List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs;
    private List<BkgEdoCntrVO>bkgEdoCntrVOs;

    /** 
	 * 생성자
	 */
	public EdoRqstVO() {
	}
	/**
	 * @return the doRefVO
	 */
	public BkgEdoMstVO getBkgEdoMstVO() {
		return bkgEdoMstVO;
	}
	/**
	 * @param doRefVO the doRefVO to set
	 */
	public void setBkgEdoMstVO(BkgEdoMstVO bkgEdoMstVO) {
		this.bkgEdoMstVO = bkgEdoMstVO;
	}
	/**
	 * @return the bkgEdoPtyTrspVOs
	 */
	public List<BkgEdoPtyTrspVO> getBkgEdoPtyTrspVOs() {
		return bkgEdoPtyTrspVOs;
	}
	/**
	 * @param bkgEdoPtyTrspVOs the bkgEdoPtyTrspVOs to set
	 */
	public void setBkgEdoPtyTrspVOs(List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs) {
		this.bkgEdoPtyTrspVOs = bkgEdoPtyTrspVOs;
	}
	/**
	 * @return the bkgEdoDoVO
	 */
	public BkgEdoDoVO getBkgEdoDoVO() {
		return bkgEdoDoVO;
	}
	/**
	 * @param bkgEdoDoVO the bkgEdoDoVO to set
	 */
	public void setBkgEdoDoVO(BkgEdoDoVO bkgEdoDoVO) {
		this.bkgEdoDoVO = bkgEdoDoVO;
	}

	/**
	 * @return the bkgEdoIbdTrspVO
	 */
	public BkgEdoIbdTrspVO getBkgEdoIbdTrspVO() {
		return bkgEdoIbdTrspVO;
	}
	/**
	 * @param bkgEdoDoVO the bkgEdoDoVO to set
	 */
	public void setBkgEdoIbdTrspVO(BkgEdoIbdTrspVO bkgEdoIbdTrspVO) {
		this.bkgEdoIbdTrspVO = bkgEdoIbdTrspVO;
	}	
	
	/**
	 * @return the bkgEdoSelfTrspVO
	 */
	public BkgEdoSelfTrspVO getBkgEdoSelfTrspVO() {
		return bkgEdoSelfTrspVO;
	}
	/**
	 * @param bkgEdoSelfTrspVO the bkgEdoSelfTrspVO to set
	 */
	public void setBkgEdoSelfTrspVO(BkgEdoSelfTrspVO bkgEdoSelfTrspVO) {
		this.bkgEdoSelfTrspVO = bkgEdoSelfTrspVO;
	}
	/**
	 * @param bkgEdoCntrVOs the bkgEdoCntrVOs to set
	 */
	public void setBkgEdoCntrVOs(List<BkgEdoCntrVO> bkgEdoCntrVOs) {
		this.bkgEdoCntrVOs = bkgEdoCntrVOs;
	}
	/**
	 * @return the bkgEdoCntrVOs
	 */
	public List<BkgEdoCntrVO> getBkgEdoCntrVOs() {
		return bkgEdoCntrVOs;
	}		
}