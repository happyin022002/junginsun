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
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsAgmtAplyVndrVO;

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
		return searchAgmtHdrVOs;
	}

	public void setSearchAgmtHdrVOs(SearchAgmtHdrVO[] searchAgmtHdrVOs) {
		this.searchAgmtHdrVOs = searchAgmtHdrVOs;
	}

	public TrsAgmtAplyVndrVO getTrsAgmtAplyVndrVO() {
		return trsAgmtAplyVndrVO;
	}

	public void setTrsAgmtAplyVndrVO(TrsAgmtAplyVndrVO trsAgmtAplyVndrVO) {
		this.trsAgmtAplyVndrVO = trsAgmtAplyVndrVO;
	}

	public TrsAgmtAplyVndrVO[] getTrsAgmtAplyVndrVOs() {
		return trsAgmtAplyVndrVOs;
	}

	public void setTrsAgmtAplyVndrVOs(TrsAgmtAplyVndrVO[] trsAgmtAplyVndrVOs) {
		this.trsAgmtAplyVndrVOs = trsAgmtAplyVndrVOs;
	}

	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}


}
