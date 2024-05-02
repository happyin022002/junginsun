/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmBkg1144Event.java
 *@FileTitle : SNP/Broker Nomination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.26
 *@LastModifier : KIM HYUN HWA
 *@LastVersion : 1.0
 * 2012.03.26 KIM HYUN HWA
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * 
 * @author
 * @see ESM_BKG_1144HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1144Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String strCustCntCd = null;
	private String strCustSeq = null;
	private String strLocCd = null;

	/** OrgParty정보 단건 */
	private OrgPartyVO orgPartyVO = null;
	/** OrgParty정보 복수 */
	private OrgPartyVO[] orgPartyVOs = null;

	// private List<OrgPartyVO> orgPartyVOs = null;

	public EsmBkg1144Event() {
	}

	/** Set Method **/

	public void setOrgPartyVO(OrgPartyVO orgPartyVO) {
		this.orgPartyVO = orgPartyVO;
	}

	public void setStrCustCntCd(String strCustCntCd) {
		this.strCustCntCd = strCustCntCd;
	}

	public void setStrCustSeq(String strCustSeq) {
		this.strCustSeq = strCustSeq;
	}

	public void setStrLocCd(String strLocCd) {
		this.strLocCd = strLocCd;
	}

	public void setOrgPartyVOs(OrgPartyVO[] orgPartyVOs) {
		if (orgPartyVOs != null)
			this.orgPartyVOs = Arrays.copyOf(orgPartyVOs, orgPartyVOs.length);
	}

	/** Get Method **/

	public OrgPartyVO getOrgPartyVO() {
		return orgPartyVO;
	}

	public OrgPartyVO[] getOrgPartyVOs() {
		OrgPartyVO[] rtnVOs = null;
		if (orgPartyVOs != null)
			rtnVOs = Arrays.copyOf(orgPartyVOs, orgPartyVOs.length);
		return rtnVOs;
	}

	public String getStrCustCntCd() {
		return strCustCntCd;
	}

	public String getStrCustSeq() {
		return strCustSeq;
	}

	public String getStrLocCd() {
		return strLocCd;
	}

}