/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0022Event.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.24 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;


/**
 * ESM_FMS-0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS-0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS-0022HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Account Code  */
	private String acctCd ="";

	/** VVD Code  */
	private String vvdCd ="";
	
	/** Vessel Code  */
	private String vslCd ="";
	
	/** Location Code  */
	private String locCd ="";
	
	/** Lane Code  */
	private String laneCd ="";
	
	/** 국가코드 */
	private String cntCd ="";
	
	/** Carrier 코드 */
	private String crrCd = "";
	
	/** Effective Date */
	private String effDt = "";
	
	/** Office Code */
	private String slpOfcCd = "";
	
	/** 사업자 등록 번호 */
	private String slpRgstNo = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslCntrVO mdmvslcntrvo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVesselVO searchvesselvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslCntrVO[] mdmvslcntrvos = null;

	public EsmFms0022Event(){}
	
	public void setMdmVslCntrVO(MdmVslCntrVO mdmvslcntrvo){
		this. mdmvslcntrvo = mdmvslcntrvo;
	}
	
	public void setSearchVesselVO(SearchVesselVO searchvesselvo){
		this. searchvesselvo = searchvesselvo;
	}

	public void setMdmVslCntrVOS(MdmVslCntrVO[] mdmvslcntrvos){
		if (mdmvslcntrvos != null) {
			MdmVslCntrVO[] tmpVOs = new MdmVslCntrVO[mdmvslcntrvos.length];
			System.arraycopy(mdmvslcntrvos, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmvslcntrvos = tmpVOs;
		}
	}

	public SearchVesselVO getSearchVesselVO(){
		return searchvesselvo;
	}
	
	public MdmVslCntrVO getMdmVslCntrVO(){
		return mdmvslcntrvo;
	}

	public MdmVslCntrVO[] getMdmVslCntrVOS(){
		MdmVslCntrVO[] rtnVOs = null;
		if (this.mdmvslcntrvos != null) {
			rtnVOs = new MdmVslCntrVO[mdmvslcntrvos.length];
			System.arraycopy(mdmvslcntrvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getAcctCd() {
		return acctCd;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	public String getVvdCd() {
		return vvdCd;
	}

	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	public String getLaneCd() {
		return laneCd;
	}

	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	public String getCrrCd() {
		return crrCd;
	}

	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	public String getSlpOfcCd() {
		return slpOfcCd;
	}

	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	public String getSlpRgstNo() {
		return slpRgstNo;
	}

	public void setSlpRgstNo(String slpRgstNo) {
		this.slpRgstNo = slpRgstNo;
	}

}