/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UbizhjsAlpsBkgCancusAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.23
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;

/**
 * 캐나다 EDI 수신용 이벤트
 * 
 * @author Kim Min Jeong
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.4
 */
public class UbizhjsAlpsBkgCancusCusresAckEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public String flatFile = null;
	public String rcvMsgTpId = null;
	public String ackRcvStsCd = null;
	public String cstmsRmk1 = null;
	/* Column Info */
	private List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs = null;
	/* Column Info */
	private List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = null;
	
	/**
	 * @return the flatFile
	 */
	public String getFlatFile() {
		return flatFile;
	}

	/**
	 * @return the rcvMsgTpId
	 */
	public String getRcvMsgTpId() {
		return rcvMsgTpId;
	}
	
	/**
	 * @return the ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return ackRcvStsCd;
	}

	/**
	 * @return the cstmsRmk1
	 */
	public String getCstmsRmk1() {
		return cstmsRmk1;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public List<BkgCstmsAdvSndLogVO> getBkgCstmsAdvSndLogVOs() {
		return bkgCstmsAdvSndLogVOs;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public List<BkgCstmsAdvRcvLogVO> getBkgCstmsAdvRcvLogVOs() {
		return bkgCstmsAdvRcvLogVOs;
	}
	
	/**
	 * @param flatFile the flatFile to set
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

	/**
	 * @param rcvMsgTpId the rcvMsgTpId to set
	 */
	public void setRcvMsgTpId(String rcvMsgTpId) {
		this.rcvMsgTpId = rcvMsgTpId;
	}
	
	/**
	 * @param ackRcvStsCd the ackRcvStsCd to set
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
	}

	/**
	 * @param cstmsRmk1 the cstmsRmk1 to set
	 */
	public void setCstmsRmk1(String cstmsRmk1) {
		this.cstmsRmk1 = cstmsRmk1;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setBkgCstmsAdvRcvLogVOs(List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs) {
		this.bkgCstmsAdvRcvLogVOs = bkgCstmsAdvRcvLogVOs;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setBkgCstmsAdvSndLogVOs(List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs) {
		this.bkgCstmsAdvSndLogVOs = bkgCstmsAdvSndLogVOs;
	}
}
