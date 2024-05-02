/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgComEvent.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
*  
* History
* 2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.event;

import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;
 


/**
 * SCG_COM_ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SCG_COM_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see SCG_COM_EXTERNALHTMLAction 참조
 * @since J2EE 1.4
 */

public class ScgComExternalEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCarrierVO mdmCarrierVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBookingVO bkgBookingVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslSkdVO vskVslSkdVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCntrTpSzVO mdmCntrTpSzVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCompGrpVO scgImdgCompGrpVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPortVO searchPortVO = null;
	
	private String polSlanCd = null;
	private String podSlanCd = null;
	private String pgmNo	 = null;
	private String bkgNo	 = null;

	/**
	 * @return the codeInfo
	 */
	public CodeInfo getCodeInfo() {
		return codeInfo;
	}

	/**
	 * @param codeInfo the codeInfo to set
	 */
	public void setCodeInfo(CodeInfo codeInfo) {
		this.codeInfo = codeInfo;
	}

	private CodeInfo codeInfo = null;
	
	
	public ScgComExternalEvent(){}
	
	public void setMdmCarrierVO(MdmCarrierVO mdmCarrierVO){
		this. mdmCarrierVO = mdmCarrierVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO){
		this. mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}
	
	public void setBkgBookingVO(BkgBookingVO bkgBookingVO){
		this. bkgBookingVO = bkgBookingVO;
	}
	
	public void setVskVslSkdVO(VskVslSkdVO vskVslSkdVO){
		this. vskVslSkdVO = vskVslSkdVO;
	}
	
	public void setMdmCntrTpSzVO(MdmCntrTpSzVO mdmCntrTpSzVO){
		this. mdmCntrTpSzVO = mdmCntrTpSzVO;
	}
	
	public void setScgImdgCompGrpVO(ScgImdgCompGrpVO scgImdgCompGrpVO){
		this. scgImdgCompGrpVO = scgImdgCompGrpVO;
	}
	
	public void setSearchPortVO(SearchPortVO searchPortVO){
		this. searchPortVO = searchPortVO;
	}

	

	public MdmCarrierVO getMdmCarrierVO(){
		return mdmCarrierVO;
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO(){
		return mdmVslSvcLaneVO;
	}

	public BkgBookingVO getBkgBookingVO(){
		return bkgBookingVO;
	}
	
	public VskVslSkdVO getVskVslSkdVO(){
		return vskVslSkdVO;
	}
	
	public MdmCntrTpSzVO getMdmCntrTpSzVO(){
		return mdmCntrTpSzVO;
	}
	
	public ScgImdgCompGrpVO getScgImdgCompGrpVO(){
		return scgImdgCompGrpVO;
	}
	
	public SearchPortVO getSearchPortVO(){
		return searchPortVO;
	}

    /**
     * @return the polSlanCd
     */
    public String getPolSlanCd() {
        return polSlanCd;
    }

    /**
     * @return the podSlanCd
     */
    public String getPodSlanCd() {
        return podSlanCd;
    }

    /**
     * @param polSlanCd the polSlanCd to set
     */
    public void setPolSlanCd(String polSlanCd) {
        this.polSlanCd = polSlanCd;
    }

    /**
     * @param podSlanCd the podSlanCd to set
     */
    public void setPodSlanCd(String podSlanCd) {
        this.podSlanCd = podSlanCd;
    }

	public String getPgmNo() {
		return pgmNo;
	}

	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}	
	
}