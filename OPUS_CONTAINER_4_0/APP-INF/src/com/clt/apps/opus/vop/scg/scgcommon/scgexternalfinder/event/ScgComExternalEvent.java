/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgComEvent.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.event;

import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCntrTpVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.VskVslSkdVO;
 


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
	private MdmCntrTpVO mdmCntrTpVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCompGrpVO scgImdgCompGrpVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPortVO searchPortVO = null;
	
	private String polSlanCd = null;
	private String podSlanCd = null;
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
	
	public void setMdmCntrTpVO(MdmCntrTpVO mdmCntrTpVO){
		this. mdmCntrTpVO = mdmCntrTpVO;
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
	
	public MdmCntrTpVO getMdmCntrTpVO(){
		return mdmCntrTpVO;
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
	
	
}