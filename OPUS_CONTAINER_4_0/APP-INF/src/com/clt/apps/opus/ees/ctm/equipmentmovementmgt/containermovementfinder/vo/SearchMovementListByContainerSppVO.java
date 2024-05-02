/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMovementListByContainerVO.java
*@FileTitle : SearchMovementListByContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.24 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 */

public class SearchMovementListByContainerSppVO implements Serializable {

	private static final long serialVersionUID = 8775180034562351524L;
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String cntrXchCd = null;	
	/* Column Info */
	private String rstrUsgLblNm = null;

	public SearchMovementListByContainerSppVO() {}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return bkgKnt
	 */
	public String getBkgKnt() {
		return this.bkgKnt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrDispFlg
	 */
	public String getCntrDispFlg() {
		return this.cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}

	/**
	 * Column Info
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
	}	

	/**
	 * Column Info
	 * @return rstrUsgLblNm
	 */
	public String getRstrUsgLblNm() {
		return this.rstrUsgLblNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrDispFlg
	 */
	public void setCntrDispFlg(String cntrDispFlg) {
		this.cntrDispFlg = cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}	
	
	/**
	 * Column Info
	 * @param rstrUsgLblNm
	 */
	public void setRstrUsgLblNm(String rstrUsgLblNm) {
		this.rstrUsgLblNm = rstrUsgLblNm;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}
}
