/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0733Event.java
 *@FileTitle : EsmBkg0733Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgCstmsLocVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfLocCdListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCstmsLocVO;

/**
 * ESM_BKG_0733 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0733HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0733HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0733Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfLocCdListCondVO krWhfLocCdListCondVO   = null;
	/** 조회결과 단건 */
	private BkgCstmsLocVO bkgCstmsLocVO = null;
	/** 조회결과 복수 */
	private List<BkgCstmsLocVO> bkgCstmsLocVOs  = null;
	private BkgCstmsLocVO[]     bkgCstmsLocVOs2 = null;
	
	private List<KrBkgCstmsLocVO> krBkgCstmsLocVOs  = null;
	private KrBkgCstmsLocVO[]     krBkgCstmsLocVOs2 = null;
		
	
	
	public KrBkgCstmsLocVO[] getKrBkgCstmsLocVOs2() {
		return krBkgCstmsLocVOs2;
	}
	public void setKrBkgCstmsLocVOs2(KrBkgCstmsLocVO[] krBkgCstmsLocVOs2) {
		this.krBkgCstmsLocVOs2 = krBkgCstmsLocVOs2;
	}
	public List<KrBkgCstmsLocVO> getKrBkgCstmsLocVOs() {
		return krBkgCstmsLocVOs;
	}
	public void setKrBkgCstmsLocVOs(List<KrBkgCstmsLocVO> krBkgCstmsLocVOs) {
		this.krBkgCstmsLocVOs = krBkgCstmsLocVOs;
	}
	public KrWhfLocCdListCondVO getKrWhfLocCdListCondVO() {
		return krWhfLocCdListCondVO;
	}
	public void setKrWhfLocCdListCondVO(KrWhfLocCdListCondVO krWhfLocCdListCondVO) {
		this.krWhfLocCdListCondVO = krWhfLocCdListCondVO;
	}
	public BkgCstmsLocVO getBkgCstmsLocVO() {
		return bkgCstmsLocVO;
	}
	public void setBkgCstmsLocVO(BkgCstmsLocVO bkgCstmsLocVO) {
		this.bkgCstmsLocVO = bkgCstmsLocVO;
	}
	public List<BkgCstmsLocVO> getBkgCstmsLocVOs() {
		return bkgCstmsLocVOs;
	}
	public void setBkgCstmsLocVOs(List<BkgCstmsLocVO> bkgCstmsLocVOs) {
		this.bkgCstmsLocVOs = bkgCstmsLocVOs;
	}
	public BkgCstmsLocVO[] getBkgCstmsLocVOs2() {
		return bkgCstmsLocVOs2;
	}
	public void setBkgCstmsLocVOs2(BkgCstmsLocVO[] bkgCstmsLocVOs2) {
		this.bkgCstmsLocVOs2 = bkgCstmsLocVOs2;
	}
	
}