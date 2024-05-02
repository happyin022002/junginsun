	/*=========================================================
	 *Copyright(c) 2015 CyberLogitec
	 *@FileName : EsmBkg200501Event.java
	 *@FileTitle : Hard Coding Contents
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2015.06.24
	 *@LastModifier : 문경일
	 *@LastVersion : 1.0
	 * 2015.06.24 문경일
	 * 1.0 Creation
	 =========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgCtnt2VO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * ESM_BKG_2005_SEQ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2005_SEQHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_2005_01HTMLAction reference
 * @since J2EE 1.6
 */
public class EsmBkg200501Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private HrdCdgCtnt2VO hrdCdgCtnt2VO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private HrdCdgCtnt2VO[] hrdCdgCtnt2VOs = null;
	
	public EsmBkg200501Event(){}

	public HrdCdgCtnt2VO getHrdCdgCtnt2VO() {
		return hrdCdgCtnt2VO;
	}

	public void setHrdCdgCtnt2VO(HrdCdgCtnt2VO hrdCdgCtnt2VO) {
		this.hrdCdgCtnt2VO = hrdCdgCtnt2VO;
	}

//	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
//		return bkgHrdCdgCtntVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public HrdCdgCtnt2VO[] getHrdCdgCtnt2VOs() {
		HrdCdgCtnt2VO[] tmpVOs = null;
		if (this.hrdCdgCtnt2VO != null) {
			tmpVOs = new HrdCdgCtnt2VO[hrdCdgCtnt2VOs.length];
			System.arraycopy(hrdCdgCtnt2VOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		

//	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
//		this.bkgHrdCdgCtntVOs = bkgHrdCdgCtntVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setHrdCdgCtnt2VOs(HrdCdgCtnt2VO[] hrdCdgCtnt2VOs) {
		if (hrdCdgCtnt2VOs != null) {
			HrdCdgCtnt2VO[] tmpVOs = new HrdCdgCtnt2VO[hrdCdgCtnt2VOs.length];
			System.arraycopy(hrdCdgCtnt2VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.hrdCdgCtnt2VOs = tmpVOs;
		}		
	}		
}
