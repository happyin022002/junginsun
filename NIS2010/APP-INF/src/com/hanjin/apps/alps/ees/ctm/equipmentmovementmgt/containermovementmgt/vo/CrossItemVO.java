/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : AutoCreItemVO.java
*@FileTitle : AutoCreItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.29
* 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.09 김상수 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
 *                   BCImpl메서드간의 return값 전달시와 SC로의 return시 사용되는 컬럼추가
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

@SuppressWarnings("unused")
public class CrossItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CrossItemVO> models = new ArrayList<CrossItemVO>();

	/* 외부와 연결한 VO */
	private CusCtmMovementVO ctmVO = null;
	/* UPDATE MASTER CONTAINEDR */
	private boolean updateMaster = false;
	/* findBkgCntr */
	private boolean findBkgCntr = true;
	/* mstBkgCntrOpUpdate */
	private boolean mstBkgCntrOpUpdate = false;
	/* mstCtmMvmtIrrInsert */
	private boolean mstCtmMvmtIrrInsert = false;
	/* return String array */
	private String[] rtnStr = null;
	private List<CusCtmMovementVO> cgmVo = new ArrayList<CusCtmMovementVO>();
	private CusCtmMovementVO bkgVo = new CusCtmMovementVO();
	private List<SceActRcvIfVO> sceVOs = new ArrayList<SceActRcvIfVO>();
	/* Container Number */
	private String cntrNo = "";
	/* Booking Number */
	private String bkgNo = "";
	/* Prev Status */
	private String prevSts = "";
	/* Prev Status */
	private String cntrPrtFlg = "";
	/* FinalConfirm Status */
	private String finalCfm = "";
	/* FinalConfirm Status */
	private String caFlg = "";
	/* FinalConfirm Status */
	private String cycNo = "";
	/* FinalConfirm Status */
	private String attchCd = "";
	/* FinalConfirm Status */
	private String cnmvYr = "";
	/* for sendEDItoKor */
	private String ediSendStsCd = "";
	private String ediSendVslCd = "";
	private String ediSendSkdVoyNo = "";
	private String ediSendSkdDirCd = "";
	private String ediSendLstrmCd = "";
	// SC에서 사용되는 MNR을 호출Flag. */
	private String mnrCallYN = "";


	public CrossItemVO() {}

	/**
	 * CusCtmMovementVO
	 * @return CusCtmMovementVO
	 */
	public List<CusCtmMovementVO> getCusCtmMovementVOs() {
		return this.cgmVo;
	}
	
	/**
	 * SceActRcvIfVO
	 * @return SceActRcvIfVO
	 */
	public List<SceActRcvIfVO> getSceActRcvIfVOs() {
		return this.sceVOs;
	}

	/**
	 * CusCtmMovementVO
	 * @return CusCtmMovementVO
	 */
	public CusCtmMovementVO getCusCtmMovementVO() {
		return this.ctmVO;
	}

	/**
	 * CusCtmMovementVO
	 * @return bkgVo
	 */
	public CusCtmMovementVO getBkgVO() {
		return this.bkgVo;
	}

	/**
	 * cntrNo
	 * @return prevSts
	 */
	public String getPrevSts() {
		return this.prevSts;
	}

	/**
	 * cntrNo
	 * @return prevSts
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
 
	/**
	 * cntrNo
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * bkgNo
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * CusCtmMovementVO
	 * @return CusCtmMovementVO
	 */
	public boolean getUpdateMaster() {
		return this.updateMaster;
	}

	/**
	 * findBkgCntr
	 * @return findBkgCntr
	 */
	public boolean getFindBkgCntr() {
		return this.findBkgCntr;
	}

	/**
	 * findBkgCntr
	 * @return findBkgCntr
	 */
	public boolean getMstBkgCntrOpUpdate() {
		return this.mstBkgCntrOpUpdate;
	}

	/**
	 * findBkgCntr
	 * @return findBkgCntr
	 */
	public boolean getMstCtmMvmtIrrInsert() {
		return this.mstCtmMvmtIrrInsert;
	}

	/**
	 * Return String Array
	 * @return rtnStr
	 */
	public String[] getRtnStr() {
		return this.rtnStr;
	}

	/**
	 * Return String Array
	 * @return finalCfm
	 */
	public String getFinalCfm() {
		return this.finalCfm;
	}

	/**
	 * Return String Array
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}

	/**
	 * Return String Array
	 * @return caFlg
	 */
	public String getCycNo() {
		return this.cycNo;
	}

	/**
	 * Return String Array
	 * @return attchCd
	 */
	public String getAttchCd() {
		return this.attchCd;
	}

	/**
	 * Return String Array
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}

	/**
	 * ediSendStsCd
	 * @return ediSendStsCd
	 */
	public String getEdiSendStsCd() {
		return this.ediSendStsCd;
	}

	/**
	 * ediSendVslCd
	 * @return ediSendVslCd
	 */
	public String getEdiSendVslCd() {
		return this.ediSendVslCd;
	}

	/**
	 * ediSendSkdVoyNo
	 * @return ediSendSkdVoyNo
	 */
	public String getEdiSendSkdVoyNo() {
		return this.ediSendSkdVoyNo;
	}

	/**
	 * ediSendSkdDirCd
	 * @return ediSendSkdDirCd
	 */
	public String getEdiSendSkdDirCd() {
		return this.ediSendSkdDirCd;
	}

	/**
	 * ediSendLstrmCd
	 * @return ediSendSkdDirCd
	 */
	public String getEdiSendLstrmCd() {
		return this.ediSendLstrmCd;
	}

	/**
	 * mnrCallYN
	 * @return mnrCallYN
	 */
	public String getMnrCallYN() {
		return this.mnrCallYN;
	}

	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCusCtmMovementVO(CusCtmMovementVO ctmVO) {
		this.ctmVO = ctmVO;
	}
	/**
	 * Column Info
	 * @param cgmVO
	 */
	public void setCusCtmMovementVOs(List<CusCtmMovementVO> cgmVO) {
		this.cgmVo = cgmVO;
	}
	/**
	 * Column Info
	 * @param sceVOs
	 */
	public void setSceActRcvIfVOs(List<SceActRcvIfVO> sceVOs) {
		this.sceVOs = sceVOs;
	}
	/**
	 * Column Info
	 * @param bkgVO
	 */
	public void setBkgVO(CusCtmMovementVO bkgVO) {
		this.bkgVo = bkgVO;
	}
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param prevSts
	 */
	public void setPrevSts(String prevSts) {
		this.prevSts = prevSts;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setUpdateMaster(boolean updMst) {
		this.updateMaster = updMst;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setFindBkgCntr(boolean findBkgCntr) {
		this.findBkgCntr = findBkgCntr;
	}
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setMstBkgCntrOpUpdate(boolean mstBkgCntrOpUpdate) {
		this.mstBkgCntrOpUpdate = mstBkgCntrOpUpdate;
	}
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setMstCtmMvmtIrrInsert(boolean mstCtmMvmtIrrInsert) {
		this.mstCtmMvmtIrrInsert = mstCtmMvmtIrrInsert;
	}
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setRtnStr(String[] rtnStr) {
		this.rtnStr = rtnStr;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCycNo(String cycNo) {
		this.cycNo = cycNo;
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

	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}

	/**
	 * Column Info
	 * @param finalCfm
	 */
	public void setFinalCfm(String finalCfm) {
		this.finalCfm = finalCfm;
	}

	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}

	/**
	 * Column Info
	 * @param attchCd
	 */
	public void setAttchCd(String attchCd) {
		this.attchCd = attchCd;
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
	 * @param ediSendStsCd
	 */
	public void setEdiSendStsCd (String ediSendStsCd) {
		this.ediSendStsCd = ediSendStsCd;
	}

	/**
	 * Column Info
	 * @param ediSendVslCd
	 */
	public void setEdiSendVslCd (String ediSendVslCd) {
		this.ediSendVslCd = ediSendVslCd;
	}

	/**
	 * Column Info
	 * @param ediSendSkdVoyNo
	 */
	public void setEdiSendSkdVoyNo (String ediSendSkdVoyNo) {
		this.ediSendSkdVoyNo = ediSendSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param ediSendSkdDirCd
	 */
	public void setEdiSendSkdDirCd (String ediSendSkdDirCd) {
		this.ediSendSkdDirCd = ediSendSkdDirCd;
	}

	/**
	 * Column Info
	 * @param ediSendLstrmCd
	 */
	public void setEdiSendLstrmCd (String ediSendLstrmCd) {
		this.ediSendLstrmCd = ediSendLstrmCd;
	}

	/**
	 * Column Info
	 * @param mnrCallYN
	 */
	public void setMnrCallYN (String mnrCallYN) {
		this.mnrCallYN = mnrCallYN;
	}


	/**
	 * 미사용 함수.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	/**
	 * 미사용 함수.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	public HashMap<String, String> getFieldNames() {
		return null;
	}

}
