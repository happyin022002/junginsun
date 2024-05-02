/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsWhfPortRtVO.java
 *@FileTitle : UsWhfPortRtVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.26
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.08.26 김민정 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfSendVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlkCgoVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndQtyVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class UsWhfSendVO extends WhfSendVO {
	private static final long serialVersionUID = 1L;
	private BkgUsaWhfSndVO bkgUsaWhfSndVO = null;
	private List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs = null;
	private List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs = null;
	private List<BkgUsaWhfBlkCgoVO> bkgUsaWhfBlkCgoVOs = null;
	private List<UsWhfSendQtyVO> usWhfSendQtyVOs = null;
	private List<UsWhfSendCntrCntVO> usWhfSendCntrCntVOs = null;

	/**
	 * @param bkgUsaWhfSndVO
	 */
	public void setBkgUsaWhfSndVO(BkgUsaWhfSndVO bkgUsaWhfSndVO) {
		this.bkgUsaWhfSndVO = bkgUsaWhfSndVO;
	}

	/**
	 * @return
	 */
	public BkgUsaWhfSndVO getBkgUsaWhfSndVO() {
		return bkgUsaWhfSndVO;
	}

	/**
	 * @param bkgUsaWhfSndHisVOs
	 */
	public void setBkgUsaWhfSndHisVOs(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs) {
		this.bkgUsaWhfSndHisVOs = bkgUsaWhfSndHisVOs;
	}

	/**
	 * @return
	 */
	public List<BkgUsaWhfSndHisVO> getBkgUsaWhfSndHisVOs() {
		return bkgUsaWhfSndHisVOs;
	}

	/**
	 * @param bkgUsaWhfSndQtyVOs
	 */
	public void setBkgUsaWhfSndQtyVOs(List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs) {
		this.bkgUsaWhfSndQtyVOs = bkgUsaWhfSndQtyVOs;
	}

	/**
	 * @return
	 */
	public List<BkgUsaWhfSndQtyVO> getBkgUsaWhfSndQtyVOs() {
		return bkgUsaWhfSndQtyVOs;
	}

	/**
	 * @param bkgUsaWhfBlkCgoVOs
	 */
	public void setBkgUsaWhfBlkCgoVOs(List<BkgUsaWhfBlkCgoVO> bkgUsaWhfBlkCgoVOs) {
		this.bkgUsaWhfBlkCgoVOs = bkgUsaWhfBlkCgoVOs;
	}

	/**
	 * @return
	 */
	public List<BkgUsaWhfBlkCgoVO> getBkgUsaWhfBlkCgoVOs() {
		return bkgUsaWhfBlkCgoVOs;
	}

	/**
	 * @return
	 */
	public List<UsWhfSendQtyVO> getUsWhfSendQtyVOs() {
		return usWhfSendQtyVOs;
	}

	/**
	 * @param usWhfSendQtyVOs
	 */
	public void setUsWhfSendQtyVOs(List<UsWhfSendQtyVO> usWhfSendQtyVOs) {
		this.usWhfSendQtyVOs = usWhfSendQtyVOs;
	}

	/**
	 * @return
	 */
	public List<UsWhfSendCntrCntVO> getUsWhfSendCntrCntVOs() {
		return usWhfSendCntrCntVOs;
	}

	/**
	 * @param usWhfSendCntrCntVOs
	 */
	public void setUsWhfSendCntrCntVOs(List<UsWhfSendCntrCntVO> usWhfSendCntrCntVOs) {
		this.usWhfSendCntrCntVOs = usWhfSendCntrCntVOs;
	}
}
