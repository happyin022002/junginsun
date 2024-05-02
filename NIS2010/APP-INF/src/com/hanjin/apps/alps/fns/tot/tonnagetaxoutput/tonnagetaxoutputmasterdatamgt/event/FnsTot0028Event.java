/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0028Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.01.27 이준범 [CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리

=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.NrtBsaChgVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TotVesselVO;
/**
 * FNS_TOT_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private NrtBsaChgVO nrtBsaChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private NrtBsaChgVO[] nrtBsaChgVOs = null;

	/** Input parameter 처리 */

	private String stlYrmon = null;
	
	public FnsTot0028Event(){}

	public String getStlYrmon() {
		return stlYrmon;
	}	

	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	
	public NrtBsaChgVO getNrtBsaChgVO() {
		return nrtBsaChgVO;
	}

	public void setNrtBsaChgVO(NrtBsaChgVO nrtBsaChgVO) {
		this.nrtBsaChgVO = nrtBsaChgVO;
	}

	public NrtBsaChgVO[] getNrtBsaChgVOs() {
		NrtBsaChgVO[] rtnVOs = null;
		if (this.nrtBsaChgVOs != null) {
			rtnVOs = new NrtBsaChgVO[nrtBsaChgVOs.length];
			System.arraycopy(nrtBsaChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setNrtBsaChgVOs(NrtBsaChgVO[] nrtBsaChgVOs) {
		if (nrtBsaChgVOs != null) {
			NrtBsaChgVO[] tmpVOs = new NrtBsaChgVO[nrtBsaChgVOs.length];
			System.arraycopy(nrtBsaChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.nrtBsaChgVOs = tmpVOs;
		}
	}
}