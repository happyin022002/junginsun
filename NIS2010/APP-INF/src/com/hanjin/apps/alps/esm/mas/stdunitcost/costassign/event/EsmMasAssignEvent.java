/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas9999Event.java
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영
* 1.0 Creation
* 
* 2010.09.29 박은주 비용생성 단계추가(디버깅을 위해서 소스 변경) Ticket ID : ITM-201003077 
*                  level 인자추가
* 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasBkgCostCalcVO;


/**
 * ESM_MAS_9999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_9999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author OKYOUNG IM
 * @see ESM_MAS_9999HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMasAssignEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasBkgCostCalcVO masBkgCostCalcVO = null;
	/* MnlAsgn.do 파일 하단 시트 조회조건  배치상태 코드*/
	private String fMasBatCd = null;
	/* MnlAsgn.do 파일 상단 PRD (createCostAssignPrd)  실행시 Start Product Catalogue Code*/
	private String fStartPctlNo = null;
	/* MnlAsgn.do 파일 상단 PRD (createCostAssignPrd)  실행시 End Product Catalogue Code*/
	private String fEndPctlNo = null;
	/* MnlAsgn.do 파일 상단 COP (createCostAssignCop)  실행시 Booking NO*/
	private String fBkgNo = null;
	/* MnlAsgn.do 파일 상단 COP (createCostAssignCop)  실행시 PARA 삭제 여부, default='Y'*/
	private String fDelPara = "Y";
	/** Table Value Object Multi Data 처리 */
	private MasBkgCostCalcVO[] masBkgCostCalcVOs = null;
	private String fLevel = null;
	
	/**
	 * 
	 * @return fLevel
	 */
	public String getFLevel() {
		return fLevel;
	}
	/**
	 * 
	 * @param level
	 */
	public void setFLevel(String level) {
		fLevel = level;
	}

	/*
	 * 생성자
	 */
	public EsmMasAssignEvent(){}

	/**
	 * @return the masBkgCostCalcVO
	 */
	public MasBkgCostCalcVO getMasBkgCostCalcVO() {
		return masBkgCostCalcVO;
	}

	/**
	 * @param masBkgCostCalcVO the masBkgCostCalcVO to set
	 */
	public void setMasBkgCostCalcVO(MasBkgCostCalcVO masBkgCostCalcVO) {
		this.masBkgCostCalcVO = masBkgCostCalcVO;
	}

	/**
	 * @return the fMasBatCd
	 */
	public String getFMasBatCd() {
		return fMasBatCd;
	}

	/**
	 * @param masBatCd the fMasBatCd to set
	 */
	public void setFMasBatCd(String masBatCd) {
		fMasBatCd = masBatCd;
	}

	/**
	 * @return the fStartPctlNo
	 */
	public String getFStartPctlNo() {
		return fStartPctlNo;
	}

	/**
	 * @param startPctlNo the fStartPctlNo to set
	 */
	public void setFStartPctlNo(String startPctlNo) {
		fStartPctlNo = startPctlNo;
	}

	/**
	 * @return the fEndPctlNo
	 */
	public String getFEndPctlNo() {
		return fEndPctlNo;
	}

	/**
	 * @param endPctlNo the fEndPctlNo to set
	 */
	public void setFEndPctlNo(String endPctlNo) {
		fEndPctlNo = endPctlNo;
	}

	/**
	 * @return the fBkgNo
	 */
	public String getFBkgNo() {
		return fBkgNo;
	}

	/**
	 * @param bkgNo the fBkgNo to set
	 */
	public void setFBkgNo(String bkgNo) {
		fBkgNo = bkgNo;
	}

	/**
	 * @return the masBkgCostCalcVOs
	 */
	public MasBkgCostCalcVO[] getMasBkgCostCalcVOs() {
		return masBkgCostCalcVOs;
	}

	/**
	 * @param masBkgCostCalcVOs the masBkgCostCalcVOs to set
	 */
	public void setMasBkgCostCalcVOs(MasBkgCostCalcVO[] masBkgCostCalcVOs) {
		this.masBkgCostCalcVOs = masBkgCostCalcVOs;
	}

	/**
	 * @return the fDelPara
	 */
	public String getFDelPara() {
		return fDelPara;
	}

	/**
	 * @param delPara the fDelPara to set
	 */
	public void setFDelPara(String delPara) {
		fDelPara = delPara;
	}
	
	
	
}