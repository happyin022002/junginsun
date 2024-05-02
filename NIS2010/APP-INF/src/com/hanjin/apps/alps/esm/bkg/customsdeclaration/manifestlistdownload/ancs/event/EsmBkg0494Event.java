/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0551Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsVesselArrivalVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * ESM_BKG_0551 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0551HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0551HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0494Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsVesselArrivalCondVO ancsCstmsVesselArrivalCondVO  = null;
	/** 조회결과 단건 */
	private AncsCstmsVesselArrivalVO ancsCstmsVesselArrivalVO = null;
	/** 조회결과 복수 */
	private AncsCstmsVesselArrivalVO[] ancsCstmsVesselArrivalVOs = null;

	/** 조회조건 */
	private BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO   = null;
	/** 조회결과 단건 */
	private BkgHrdCdgCtntVO bkgHrdCdgCtntVO = null; 
	/** 조회결과 복수 */
	private BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = null;
	
	/** 조회결과 단건 */
	private AncsVesselArrivalVO ancsVesselArrivalVO = null;
	
	private AncsVesselArrivalTransmitVO ancsVesselArrivalTransmitVO = null; 
	
	public AncsVesselArrivalTransmitVO getAncsVesselArrivalTransmitVO() {
		return ancsVesselArrivalTransmitVO;
	}
	public void setAncsVesselArrivalTransmitVO(AncsVesselArrivalTransmitVO ancsVesselArrivalTransmitVO) {
		this.ancsVesselArrivalTransmitVO = ancsVesselArrivalTransmitVO;
	}
	public AncsVesselArrivalVO getAncsVesselArrivalVO() {
		return ancsVesselArrivalVO;
	}
	public void setAncsVesselArrivalVO(AncsVesselArrivalVO ancsVesselArrivalVO) {
		this.ancsVesselArrivalVO = ancsVesselArrivalVO;
	}
	public AncsVesselArrivalVO[] getAncsVesselArrivalVOs() {
		return ancsVesselArrivalVOs;
	}
	public void setAncsVesselArrivalVOs(AncsVesselArrivalVO[] ancsVesselArrivalVOs) {
		this.ancsVesselArrivalVOs = ancsVesselArrivalVOs;
	}
	/** 조회결과 복수 */
	private AncsVesselArrivalVO[] ancsVesselArrivalVOs = null;
	
	
	public BkgHrdCdgCtntListCondVO getBkgHrdCdgCtntListCondVO() {
		return bkgHrdCdgCtntListCondVO;
	}
	public void setBkgHrdCdgCtntListCondVO(BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) {
		this.bkgHrdCdgCtntListCondVO = bkgHrdCdgCtntListCondVO;
	}
	public BkgHrdCdgCtntVO getBkgHrdCdgCtntVO() {
		return bkgHrdCdgCtntVO;
	}
	public void setBkgHrdCdgCtntVO(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) {
		this.bkgHrdCdgCtntVO = bkgHrdCdgCtntVO;
	}
	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
		return bkgHrdCdgCtntVOs;
	}
	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
		this.bkgHrdCdgCtntVOs = bkgHrdCdgCtntVOs;
	}
	public AncsCstmsVesselArrivalCondVO getAncsCstmsVesselArrivalCondVO() {
		return ancsCstmsVesselArrivalCondVO;
	}
	public void setAncsCstmsVesselArrivalCondVO(AncsCstmsVesselArrivalCondVO ancsCstmsVesselArrivalCondVO) {
		this.ancsCstmsVesselArrivalCondVO = ancsCstmsVesselArrivalCondVO;
	}
	public AncsCstmsVesselArrivalVO getAncsCstmsVesselArrivalVO() {
		return ancsCstmsVesselArrivalVO;
	}
	public void setAncsCstmsVesselArrivalVO(AncsCstmsVesselArrivalVO ancsCstmsVesselArrivalVO) {
		this.ancsCstmsVesselArrivalVO = ancsCstmsVesselArrivalVO;
	}
	public AncsCstmsVesselArrivalVO[] getAncsCstmsVesselArrivalVOs() {
		return ancsCstmsVesselArrivalVOs;
	}
	public void setAncsCstmsVesselArrivalVOs(AncsCstmsVesselArrivalVO[] ancsCstmsVesselArrivalVOs) {
		this.ancsCstmsVesselArrivalVOs = ancsCstmsVesselArrivalVOs;
	}
}