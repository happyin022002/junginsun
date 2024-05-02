/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfBlInfoContainerVO.java
*@FileTitle : KrWhfBlInfoContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.31 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlInfoVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfBlInfoContainerVO extends WhfBlInfoVO {

	private static final long serialVersionUID = 1L;
	
	private List<KrWhfBlInfoVO>     krWhfBlInfoVOs     = null;
	private List<KrWhfAplyPortRtVO> krWhfAplyPortRtVOs = null;
	private List<BkgHrdCdgCtntVO>   bkgHrdCdgCtntVOs   = null;
	
	public List<BkgHrdCdgCtntVO> getBkgHrdCdgCtntVOs() {
		return bkgHrdCdgCtntVOs;
	}
	public void setBkgHrdCdgCtntVOs(List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs) {
		this.bkgHrdCdgCtntVOs = bkgHrdCdgCtntVOs;
	}
	public List<KrWhfBlInfoVO> getKrWhfBlInfoVOs() {
		return krWhfBlInfoVOs;
	}
	public void setKrWhfBlInfoVOs(List<KrWhfBlInfoVO> krWhfBlInfoVOs) {
		this.krWhfBlInfoVOs = krWhfBlInfoVOs;
	}
	public List<KrWhfAplyPortRtVO> getKrWhfAplyPortRtVOs() {
		return krWhfAplyPortRtVOs;
	}
	public void setKrWhfAplyPortRtVOs(List<KrWhfAplyPortRtVO> krWhfAplyPortRtVOs) {
		this.krWhfAplyPortRtVOs = krWhfAplyPortRtVOs;
	}
}
