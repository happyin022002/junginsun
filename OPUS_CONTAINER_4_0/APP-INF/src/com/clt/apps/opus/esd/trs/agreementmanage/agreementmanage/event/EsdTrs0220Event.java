/*=========================================================
 *@FileName : ESD_TRS_0220Event.java
 *@FileTitle : Agreement Header
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0 
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;
import java.util.Arrays;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsAgmtAplyVndrVO;

/**
 * ESD_TRS_0220 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0220HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0220Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	String fmAgmtno          = null;
	String fmAccountOfcCd          = null;
	String fmAccountUsrId          = null;
	String fmVndrPrmrySeq  = null;
	String fmCtrtOfcCd  = null;
	private SearchAgmtHdrVO searchAgmtHdrVO = null;
	private SearchAgmtHdrVO[] searchAgmtHdrVOs = null;
	private TrsAgmtAplyVndrVO trsAgmtAplyVndrVO = null;
	private TrsAgmtAplyVndrVO[] trsAgmtAplyVndrVOs = null;

	public String getFm_agmtno() {
		return fmAgmtno;
	}

	public void setFm_agmtno(String fmAgmtno) {
		this.fmAgmtno = fmAgmtno;
	}

	public String getFm_account_ofc_cd() {
		return fmAccountOfcCd;
	}

	public void setFm_account_ofc_cd(String fmAccountOfcCd) {
		this.fmAccountOfcCd = fmAccountOfcCd;
	}

	public String getFm_account_usr_id() {
		return fmAccountUsrId;
	}

	public void setFm_account_usr_id(String fmAccountUsrId) {
		this.fmAccountUsrId = fmAccountUsrId;
	}

	public String getFm_vndr_prmry_seq() {
		return fmVndrPrmrySeq;
	}

	public void setFm_vndr_prmry_seq(String fmVndrPrmrySeq) {
		this.fmVndrPrmrySeq = fmVndrPrmrySeq;
	}
	
	public String getFmCtrtOfcCd() {
		return fmCtrtOfcCd;
	}
	
	public void setFmCtrtOfcCd(String fmCtrtOfcCd) {
		this.fmCtrtOfcCd = fmCtrtOfcCd;
	}

	public SearchAgmtHdrVO getSearchAgmtHdrVO() {
		return searchAgmtHdrVO;
	}

	public void setSearchAgmtHdrVO(SearchAgmtHdrVO searchAgmtHdrVO) {
		this.searchAgmtHdrVO = searchAgmtHdrVO;
	}

	public SearchAgmtHdrVO[] getSearchAgmtHdrVOs() {
		SearchAgmtHdrVO[] rtnVOs = null;
		if (this.searchAgmtHdrVOs != null) {
			rtnVOs = Arrays.copyOf(searchAgmtHdrVOs, searchAgmtHdrVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setSearchAgmtHdrVOs(SearchAgmtHdrVO[] searchAgmtHdrVOs) {
		if (searchAgmtHdrVOs != null) {
			SearchAgmtHdrVO[] tmpVOs = Arrays.copyOf(searchAgmtHdrVOs, searchAgmtHdrVOs.length);
			this.searchAgmtHdrVOs = tmpVOs;
		} // end if
	}

	public TrsAgmtAplyVndrVO getTrsAgmtAplyVndrVO() {
		return trsAgmtAplyVndrVO;
	}

	public void setTrsAgmtAplyVndrVO(TrsAgmtAplyVndrVO trsAgmtAplyVndrVO) {
		this.trsAgmtAplyVndrVO = trsAgmtAplyVndrVO;
	}

	public TrsAgmtAplyVndrVO[] getTrsAgmtAplyVndrVOs() {
		TrsAgmtAplyVndrVO[] rtnVOs = null;
		if (this.trsAgmtAplyVndrVOs != null) {
			rtnVOs = Arrays.copyOf(trsAgmtAplyVndrVOs, trsAgmtAplyVndrVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsAgmtAplyVndrVOs(TrsAgmtAplyVndrVO[] trsAgmtAplyVndrVOs) {
		if (trsAgmtAplyVndrVOs != null) {
			TrsAgmtAplyVndrVO[] tmpVOs = Arrays.copyOf(trsAgmtAplyVndrVOs, trsAgmtAplyVndrVOs.length);
			this.trsAgmtAplyVndrVOs = tmpVOs;
		} // end if
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}


}
