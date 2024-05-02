/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsBlContainerVO.java
*@FileTitle : AncsCstmsBlContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.14 정재엽 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.syscommon.common.table.BkgCstmsAnrBlLogVO;
import com.clt.syscommon.common.table.BkgCstmsAnrCmdtVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AncsCstmsBlContainerVO extends CstmsBlVO{

	private static final long serialVersionUID = 1L;
	
	private String rcv;
	private String sndSts;
	
	private AncsCstmsBlVO     ancsCstmsBlVO     = null ;
	private AncsCstmsAnrBlVO  ancsCstmsAnrBlVO  = null ;
	private BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = null ;
	private AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO = null;
	private AncsCstmsCntrVO   ancsCstmsCntrVO   = null;
	
	private AncsBkgCstmsAnrCntrVO ancsBkgCstmsAnrCntrVO = null;
	private AncsCstmsCntrVO[] ancsCstmsCntrVOArrys = null;
	private AncsCstmsCmdtVO[] ancsCstmsCmdtVOArrys = null;
	
	private BkgCstmsAnrCmdtVO bkgCstmsAnrCmdtVO    = null;
	private BkgCstmsAnrCmdtVO[] bkgCstmsAnrCmdtVOs = null;
		
	private List<AncsCstmsBlVO>   ancsCstmsBlVOs   = null ;
	private List<AncsCstmsCntrVO> ancsCstmsCntrVOs = null ;
	private List<AncsCstmsCmdtVO> ancsCstmsCmdtVOs = null ;
	
	
	
	public String getSndSts() {
		return sndSts;
	}
	public void setSndSts(String sndSts) {
		this.sndSts = sndSts;
	}
	public AncsBkgCstmsAnrCntrVO getAncsBkgCstmsAnrCntrVO() {
		return ancsBkgCstmsAnrCntrVO;
	}
	public void setAncsBkgCstmsAnrCntrVO(AncsBkgCstmsAnrCntrVO ancsBkgCstmsAnrCntrVO) {
		this.ancsBkgCstmsAnrCntrVO = ancsBkgCstmsAnrCntrVO;
	}
	public AncsCstmsAnrBlVO getAncsCstmsAnrBlVO() {
		return ancsCstmsAnrBlVO;
	}
	public void setAncsCstmsAnrBlVO(AncsCstmsAnrBlVO ancsCstmsAnrBlVO) {
		this.ancsCstmsAnrBlVO = ancsCstmsAnrBlVO;
	}
	public BkgCstmsAnrBlLogVO getBkgCstmsAnrBlLogVO() {
		return bkgCstmsAnrBlLogVO;
	}
	public void setBkgCstmsAnrBlLogVO(BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO) {
		this.bkgCstmsAnrBlLogVO = bkgCstmsAnrBlLogVO;
	}
	public String getRcv() {
		return rcv;
	}
	public void setRcv(String rcv) {
		this.rcv = rcv;
	}
	public BkgCstmsAnrCmdtVO getBkgCstmsAnrCmdtVO() {
		return bkgCstmsAnrCmdtVO;
	}
	public void setBkgCstmsAnrCmdtVO(BkgCstmsAnrCmdtVO bkgCstmsAnrCmdtVO) {
		this.bkgCstmsAnrCmdtVO = bkgCstmsAnrCmdtVO;
	}
	public BkgCstmsAnrCmdtVO[] getBkgCstmsAnrCmdtVOs() {
		return bkgCstmsAnrCmdtVOs;
	}
	public void setBkgCstmsAnrCmdtVOs(BkgCstmsAnrCmdtVO[] bkgCstmsAnrCmdtVOs) {
		this.bkgCstmsAnrCmdtVOs = bkgCstmsAnrCmdtVOs;
	}
	
	public AncsCstmsCmdtVO[] getAncsCstmsCmdtVOArrys() {
		return ancsCstmsCmdtVOArrys;
	}
	public void setAncsCstmsCmdtVOArrys(AncsCstmsCmdtVO[] ancsCstmsCmdtVOArrys) {
		this.ancsCstmsCmdtVOArrys = ancsCstmsCmdtVOArrys;
	}
	public AncsCstmsCntrVO[] getAncsCstmsCntrVOArrys() {
		return ancsCstmsCntrVOArrys;
	}
	public void setAncsCstmsCntrVOArrys(AncsCstmsCntrVO[] ancsCstmsCntrVOArrys) {
		this.ancsCstmsCntrVOArrys = ancsCstmsCntrVOArrys;
	}
	public AncsCstmsBlVO getAncsCstmsBlVO() {
		return ancsCstmsBlVO;
	}
	public void setAncsCstmsBlVO(AncsCstmsBlVO ancsCstmsBlVO) {
		this.ancsCstmsBlVO = ancsCstmsBlVO;
	}
	public AncsCstmsBlNtfyVO getAncsCstmsBlNtfyVO() {
		return ancsCstmsBlNtfyVO;
	}
	public void setAncsCstmsBlNtfyVO(AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO) {
		this.ancsCstmsBlNtfyVO = ancsCstmsBlNtfyVO;
	}
	public AncsCstmsCntrVO getAncsCstmsCntrVO() {
		return ancsCstmsCntrVO;
	}
	public void setAncsCstmsCntrVO(AncsCstmsCntrVO ancsCstmsCntrVO) {
		this.ancsCstmsCntrVO = ancsCstmsCntrVO;
	}
	public List<AncsCstmsBlVO> getAncsCstmsBlVOs() {
		return ancsCstmsBlVOs;
	}
	public void setAncsCstmsBlVOs(List<AncsCstmsBlVO> ancsCstmsBlVOs) {
		this.ancsCstmsBlVOs = ancsCstmsBlVOs;
	}
	public List<AncsCstmsCntrVO> getAncsCstmsCntrVOs() {
		return ancsCstmsCntrVOs;
	}
	public void setAncsCstmsCntrVOs(List<AncsCstmsCntrVO> ancsCstmsCntrVOs) {
		this.ancsCstmsCntrVOs = ancsCstmsCntrVOs;
	}
	public List<AncsCstmsCmdtVO> getAncsCstmsCmdtVOs() {
		return ancsCstmsCmdtVOs;
	}
	public void setAncsCstmsCmdtVOs(List<AncsCstmsCmdtVO> ancsCstmsCmdtVOs) {
		this.ancsCstmsCmdtVOs = ancsCstmsCmdtVOs;
	}
	
}
