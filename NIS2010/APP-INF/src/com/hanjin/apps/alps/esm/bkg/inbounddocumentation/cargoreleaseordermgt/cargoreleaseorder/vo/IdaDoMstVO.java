/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BkgDoRefVOVO.java
*@FileTitle      : BkgDoRefVOVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.25
*@LastModifier   : 박만건
*@LastVersion    : 1.0
* 2009.05.25 박만건
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgDoRefVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IdaDoMstVO {

    private DoBlInfoVO doBlInfoVO;
    private BkgDoRefVO bkgDoRefVO;
    private EdoRqstStsVO edoRqstStsVO;
    private BlIssVO blIssVO;
    private OtsRcvInfoVO otsRcvInfoVO; //운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 수신 받는 Value Object
    private String[] cntrNoList;
    private String mrdId;
    private IdaCstmsVO idaCstmsVO;             // India Customs
    private int remainCnt;                     // DO가 발급되지 않은 Remain Container의 개수
    
    // for India Cargo Release
    private List<IdaDoCntrRlseStsVO> idaDoCntrRlseStsVOList;
    private List<IdaDoRlseStsVO> idaDoRlseStsVOList ;
    
    /**
     * 생성자
     */
    public IdaDoMstVO() {
    }


    public DoBlInfoVO getDoBlInfoVO() {
		return doBlInfoVO;
	}


	public void setDoBlInfoVO(DoBlInfoVO doBlInfoVO) {
		this.doBlInfoVO = doBlInfoVO;
	}



	public BkgDoRefVO getBkgDoRefVO() {
		return bkgDoRefVO;
	}


	public void setBkgDoRefVO(BkgDoRefVO bkgDoRefVO) {
		this.bkgDoRefVO = bkgDoRefVO;
	}


	public EdoRqstStsVO getEdoRqstStsVO() {
		return edoRqstStsVO;
	}

	public void setEdoRqstStsVO(EdoRqstStsVO edoRqstStsVO) {
		this.edoRqstStsVO = edoRqstStsVO;
	}

	public BlIssVO getBlIssVO() {
		return blIssVO;
	}

	public void setBkgBlIssVO(BlIssVO blIssVO) {
		this.blIssVO = blIssVO;
	}

	public OtsRcvInfoVO getOtsRcvInfoVO() {
		return otsRcvInfoVO;
	}

	public void setOtsRcvInfoVO(OtsRcvInfoVO otsRcvInfoVO) {
		this.otsRcvInfoVO = otsRcvInfoVO;
	}

	public String[] getCntrNoList() {
		return cntrNoList;
	}

	public void setCntrNoList(String[] cntrNoList) {
		this.cntrNoList = cntrNoList;
	}

	public String getMrdId() {
		return mrdId;
	}

	public void setMrdId(String mrdId) {
		this.mrdId = mrdId;
	}

	public IdaCstmsVO getIdaCstmsVO() {
		return idaCstmsVO;
	}

	public void setIdaCstmsVO(IdaCstmsVO idaCstmsVO) {
		this.idaCstmsVO = idaCstmsVO;
	}

	public int getRemainCnt() {
		return remainCnt;
	}

	public void setRemainCnt(int remainCnt) {
		this.remainCnt = remainCnt;
	}

	public List<IdaDoCntrRlseStsVO> getIdaDoCntrRlseStsVOList() {
		return idaDoCntrRlseStsVOList;
	}

	public void setIdaDoCntrRlseStsVOList(
			List<IdaDoCntrRlseStsVO> idaDoCntrRlseStsVOList) {
		this.idaDoCntrRlseStsVOList = idaDoCntrRlseStsVOList;
	}

	public List<IdaDoRlseStsVO> getIdaDoRlseStsVOList() {
		return idaDoRlseStsVOList;
	}

	public void setIdaDoRlseStsVOList(List<IdaDoRlseStsVO> idaDoRlseStsVOList) {
		this.idaDoRlseStsVOList = idaDoRlseStsVOList;
	}


	
}