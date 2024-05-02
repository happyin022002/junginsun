/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrPartnerGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 12.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 12. 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.vo;

import java.util.List;

import com.clt.syscommon.common.table.MnrPartnerVO;
import com.clt.syscommon.common.table.MnrPrnrCntcPntVO;

/**
 * MnrPartner GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 안준상 
 * @since J2EE 1.5 
 * @see	  ..   
 */
 
public class MnrPartnerGRPVO {
	
	private MnrPartnerVO mnrPartnerVO = null;
	
	private MnrPrnrCntcPntVO[] mnrPrnrCntcPntVOS = null;
	
	public MnrPartnerVO getMnrPartnerVO() {
		return mnrPartnerVO;
	}
	public void setMnrPartnerVO(MnrPartnerVO mnrPartnerVO) {
		this.mnrPartnerVO = mnrPartnerVO;
	}
	public MnrPrnrCntcPntVO[] getMnrPrnrCntcPntVOS() {
		return mnrPrnrCntcPntVOS;
	}
	public void setMnrPrnrCntcPntVOS(MnrPrnrCntcPntVO[] mnrPrnrCntcPntVOS) {
		this.mnrPrnrCntcPntVOS = mnrPrnrCntcPntVOS;
	}
}
