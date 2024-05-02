	/*=========================================================
	 *Copyright(c) 2015 CyberLogitec
	 *@FileName : EsmBkg2004SEQEvent.java
	 *@FileTitle : Hard Coding Setup
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2015.06.24
	 *@LastModifier : 문경일
	 *@LastVersion : 1.0
	 * 2015.06.24 문경일
	 * 1.0 Creation
	 =========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgDesc2VO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_2004_SEQ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_2004HTMLAction reference
 * @since J2EE 1.6
 */
public class EsmBkg200401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private HrdCdgDesc2VO hrdCdgDesc2VO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private HrdCdgDesc2VO[] hrdCdgDesc2VOs = null;
	
	public EsmBkg200401Event(){}

	public HrdCdgDesc2VO getHrdCdgDesc2VO() {
		return hrdCdgDesc2VO;
	}

	public void setSearchHrdCdgDesc2VO(HrdCdgDesc2VO hrdCdgDesc2VO) {
		this.hrdCdgDesc2VO = hrdCdgDesc2VO;
	}

	public HrdCdgDesc2VO[] getHrdCdgDescVOs() {
		HrdCdgDesc2VO[] tmpVOs = null;
		if (this.hrdCdgDesc2VOs != null) {
			tmpVOs = new HrdCdgDesc2VO[hrdCdgDesc2VOs.length];
			System.arraycopy(hrdCdgDesc2VOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

	public void setHrdCdgDescVOs(HrdCdgDesc2VO[] hrdCdgDesc2VOs) {
		if (hrdCdgDesc2VOs != null) {
			HrdCdgDesc2VO[] tmpVOs = new HrdCdgDesc2VO[hrdCdgDesc2VOs.length];
			System.arraycopy(hrdCdgDesc2VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.hrdCdgDesc2VOs = tmpVOs;
		}		
	} 
}
