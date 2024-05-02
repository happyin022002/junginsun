package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSgStndNoteHdrVO;
import com.clt.syscommon.common.table.PriSgStndNoteVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class StndNoteGlineVO {
	
	//쉬트별 조회 구분 헤더 :1, 타이틀:2, 본문:3
	String searchGubun = "";

	
	List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();
	List<PriSgStndNoteVO> priSgStndNote 		= new ArrayList<PriSgStndNoteVO>();
	List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();
	
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgStndNoteHdrVO prisgstndnotehdrvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgStndNoteVO[] prisgstndnotevos = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgStndNoteCtntVO[] prisgstndnotectntvos = null;
	
	
	
	public PriSgStndNoteHdrVO getPrisgstndnotehdrvo() {
		return prisgstndnotehdrvo;
	}
	public void setPrisgstndnotehdrvo(PriSgStndNoteHdrVO prisgstndnotehdrvo) {
		this.prisgstndnotehdrvo = prisgstndnotehdrvo;
	}
	public PriSgStndNoteVO[] getPrisgstndnotevos() {
		return prisgstndnotevos;
	}
	public void setPrisgstndnotevos(PriSgStndNoteVO[] prisgstndnotevos) {
		this.prisgstndnotevos = prisgstndnotevos;
	}
	public PriSgStndNoteCtntVO[] getPrisgstndnotectntvos() {
		return prisgstndnotectntvos;
	}
	public void setPrisgstndnotectntvos(PriSgStndNoteCtntVO[] prisgstndnotectntvos) {
		this.prisgstndnotectntvos = prisgstndnotectntvos;
	}
	public String getSearchGubun() {
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	
	public List<PriSgStndNoteHdrVO> getPriSgStndNoteHdr() {
		return priSgStndNoteHdr;
	}
	public void setPriSgStndNoteHdr(List<PriSgStndNoteHdrVO> priSgStndNoteHdr) {
		this.priSgStndNoteHdr = priSgStndNoteHdr;
	}
	public List<PriSgStndNoteVO> getPriSgStndNote() {
		return priSgStndNote;
	}
	public void setPriSgStndNote(List<PriSgStndNoteVO> priSgStndNote) {
		this.priSgStndNote = priSgStndNote;
	}
	public List<PriSgStndNoteCtntVO> getPriSgStndNoteCtnt() {
		return priSgStndNoteCtnt;
	}
	public void setPriSgStndNoteCtnt(List<PriSgStndNoteCtntVO> priSgStndNoteCtnt) {
		this.priSgStndNoteCtnt = priSgStndNoteCtnt;
	}
	
	
}