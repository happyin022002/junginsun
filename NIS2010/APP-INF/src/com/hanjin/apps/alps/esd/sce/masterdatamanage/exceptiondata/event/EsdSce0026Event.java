/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0026Event.java
*@FileTitle : Exception Type Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-12
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListForMultiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListForMultiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EsdSce0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Se-Hoon PARK
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    /**
     * 생성자
     */
    public EsdSce0026Event(){}

    private SearchExpTypeListVO expType = null;
    private SearchExpTypeListForMultiVO[] expTypes = null;
    private SearchExpTypeDetailListVO expTypeDetail = null;
    private SearchExptDetailList3VO expDetail3 = null;
    private SearchExpInfoVO fExpTp = null;
    private SearchExpTypeDetailListForMultiVO expTypeDetailSep = null;
    private SearchExpTypeDetailListForMultiVO[] expTypeDetails = null;
    private SearchExptDetailQueryStrVO expDetailQuery = null;
    private SearchExptDetailQueryStr2VO expDetailQuery2 = null;
	
    public SearchExpTypeListVO getExpType() {
		return expType;
	}

	public void setExpType(SearchExpTypeListVO expType) {
		this.expType = expType;
	}

	public SearchExpTypeDetailListVO getExpTypeDetail() {
		return expTypeDetail;
	}

	public void setExpTypeDetail(SearchExpTypeDetailListVO expTypeDetail) {
		this.expTypeDetail = expTypeDetail;
	}

	public SearchExptDetailList3VO getExpDetail3() {
		return expDetail3;
	}

	public void setExpDetail3(SearchExptDetailList3VO expDetail3) {
		this.expDetail3 = expDetail3;
	}

	public SearchExpInfoVO getFExpTp() {
		return fExpTp;
	}

	public void setFExpTp(SearchExpInfoVO expTp) {
		fExpTp = expTp;
	}

	public SearchExpTypeListForMultiVO[] getExpTypes() {
		return expTypes;
	}

	public void setExpTypes(SearchExpTypeListForMultiVO[] expTypes) {
		this.expTypes = expTypes;
	}

	public SearchExpTypeDetailListForMultiVO[] getExpTypeDetails() {
		return expTypeDetails;
	}

	public void setExpTypeDetails(SearchExpTypeDetailListForMultiVO[] expTypeDetails) {
		this.expTypeDetails = expTypeDetails;
	}

	public SearchExpTypeDetailListForMultiVO getExpTypeDetailSep() {
		return expTypeDetailSep;
	}

	public void setExpTypeDetailSep(
			SearchExpTypeDetailListForMultiVO expTypeDetailSep) {
		this.expTypeDetailSep = expTypeDetailSep;
	}

	public SearchExptDetailQueryStrVO getExpDetailQuery() {
		return expDetailQuery;
	}

	public void setExpDetailQuery(SearchExptDetailQueryStrVO expDetailQuery) {
		this.expDetailQuery = expDetailQuery;
	}

	public SearchExptDetailQueryStr2VO getExpDetailQuery2() {
		return expDetailQuery2;
	}

	public void setExpDetailQuery2(SearchExptDetailQueryStr2VO expDetailQuery2) {
		this.expDetailQuery2 = expDetailQuery2;
	}

}
