package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.BkgRevDrAmtVO;
import com.hanjin.syscommon.common.table.BkgRevDrNoteProgVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class RevDrNoteVO {
	//note :1, amt :2
	String searchGubun = "";
	//Regional rmk
	String regionalRmk = "";
	
	//Receipt rmk
	String receiptRmk = "";
	
	//blNo 여부 
	String cntBlno = "0";
	
	//caNo 여부 
	String cntCano = "0";
	
	//tpbNo 여부 
	String cntTpbno = "0";
	
	//umch rmk
	String umchRmk = "";
	
	List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList   	= new ArrayList<RsltBkgRevDrNoteVO>();
	List<BkgRevDrNoteProgVO> bkgRevDrNoteProgVOList   	= new ArrayList<BkgRevDrNoteProgVO>();
	List<RsltBkgRevDrAmtVO>  RsltBkgRevDrAmtVOList 		= new ArrayList<RsltBkgRevDrAmtVO>();
	
	
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRevDrNoteProgVO bkgRevDrNoteProgVO = new BkgRevDrNoteProgVO();
	
	
	/** Table Value Object Multi Data 처리 */
	private BkgRevDrAmtVO[] bkgRevDrAmtVOs = null;


	public String getSearchGubun() {
		return searchGubun;
	}


	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	






	public String getCntCano() {
		return cntCano;
	}


	public void setCntCano(String cntCano) {
		this.cntCano = cntCano;
	}
	
	public String getCntTpbno() {
		return cntTpbno;
	}


	public void setCntTpbno(String cntTpbno) {
		this.cntTpbno = cntTpbno;
	}


	public String getCntBlno() {
		return cntBlno;
	}


	public void setCntBlno(String cntBlno) {
		this.cntBlno = cntBlno;
	}


	public String getRegionalRmk() {
		return regionalRmk;
	}


	public void setRegionalRmk(String regionalRmk) {
		this.regionalRmk = regionalRmk;
	}


	public String getReceiptRmk() {
		return receiptRmk;
	}


	public void setReceiptRmk(String receiptRmk) {
		this.receiptRmk = receiptRmk;
	}
	
	public String getUmchRmk() {
		return umchRmk;
	}


	public void setUmchRmk(String umchRmk) {
		this.umchRmk = umchRmk;
	}

	public List<RsltBkgRevDrNoteVO> getRsltBkgRevDrNoteVOList() {
		return rsltBkgRevDrNoteVOList;
	}


	public void setRsltBkgRevDrNoteVOList(
			List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList) {
		this.rsltBkgRevDrNoteVOList = rsltBkgRevDrNoteVOList;
	}


	public List<BkgRevDrNoteProgVO> getBkgRevDrNoteProgVOList() {
		return bkgRevDrNoteProgVOList;
	}


	public void setBkgRevDrNoteProgVOList(
			List<BkgRevDrNoteProgVO> bkgRevDrNoteProgVOList) {
		this.bkgRevDrNoteProgVOList = bkgRevDrNoteProgVOList;
	}


	public List<RsltBkgRevDrAmtVO> getRsltBkgRevDrAmtVOList() {
		return RsltBkgRevDrAmtVOList;
	}


	public void setRsltBkgRevDrAmtVOList(
			List<RsltBkgRevDrAmtVO> rsltBkgRevDrAmtVOList) {
		RsltBkgRevDrAmtVOList = rsltBkgRevDrAmtVOList;
	}


	public CstmBkgRevDrNoteVO getBkgRevDrNoteVO() {
		return bkgRevDrNoteVO;
	}


	public void setBkgRevDrNoteVO(CstmBkgRevDrNoteVO bkgRevDrNoteVO) {
		this.bkgRevDrNoteVO = bkgRevDrNoteVO;
	}


	public BkgRevDrNoteProgVO getBkgRevDrNoteProgVO() {
		return bkgRevDrNoteProgVO;
	}


	public void setBkgRevDrNoteProgVO(BkgRevDrNoteProgVO bkgRevDrNoteProgVO) {
		this.bkgRevDrNoteProgVO = bkgRevDrNoteProgVO;
	}


	public BkgRevDrAmtVO[] getBkgRevDrAmtVOs() {
		return bkgRevDrAmtVOs;
	}


	public void setBkgRevDrAmtVOs(BkgRevDrAmtVO[] bkgRevDrAmtVOs) {
		this.bkgRevDrAmtVOs = bkgRevDrAmtVOs;
	}

	
}