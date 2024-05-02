/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgDoRefVOVO.java
*@FileTitle : BkgDoRefVOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.25 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgDoCntrVO;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EuDoRcvrVO {

    private BkgDoVO bkgDoVO;
    private BkgDoCntrVO bkgDoCntrVO;
    private List<BkgDoCntrVO> bkgDoCntrVOs;
    private List<DoCntrVO> doCntrVos;
    

    public BkgDoVO getBkgDoVO() {
		return bkgDoVO;
	}
	public void setBkgDoVO(BkgDoVO bkgDoVO) {
		this.bkgDoVO = bkgDoVO;
	}
	public BkgDoCntrVO getBkgDoCntrVO() {
		return bkgDoCntrVO;
	}
	public void setBkgDoCntrVO(BkgDoCntrVO bkgDoCntrVO) {
		this.bkgDoCntrVO = bkgDoCntrVO;
	}
	public List<DoCntrVO> getDoCntrVos() {
		return doCntrVos;
	}
	public void setDoCntrVos(List<DoCntrVO> doCntrVos) {
		this.doCntrVos = doCntrVos;
	}
	public List<BkgDoCntrVO> getBkgDoCntrVOs() {
		return bkgDoCntrVOs;
	}
	public void setBkgDoCntrVOs(List<BkgDoCntrVO> bkgDoCntrVOs) {
		this.bkgDoCntrVOs = bkgDoCntrVOs;
	}
	

}