/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : EsmSpc0090Event.java
*@FileTitle : SPACE MANAGEMENT PLAN (NEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.03.19 송민석
* 1.0 Creation
* 
* History
* 2018.03.19 송민석 [CSR #3462] 기존 H/O, RHQ, L/OFC 3단계로 진행 되던 업무를 H/O에서 통합 관리하도록 수정함 이에 ESM_SPC_0090을 copy해서 새로운 화면으로 만듬
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcMdlExptWkVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;


/**
 * ESM_SPC_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0090HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0090Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchModelManageListVO searchModelManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchModelManageListVO[] searchModelManageListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustCtrlGrpVO custCtrlGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustCtrlGrpVO[] custCtrlGrpVOs = null;

	SpcMdlExptWkVO[] spcMdlExptWkVOs  = null;
	List<SpcMdlExptWkVO> spcMdlExptWkVOList = null;
	
	public EsmSpc0090Event(){}
	
	
	public SearchModelManageListVO getSearchModelManageListVO() {
		return searchModelManageListVO;
	}

	public void setSearchModelManageListVO(
			SearchModelManageListVO searchModelManageListVO) {
		this.searchModelManageListVO = searchModelManageListVO;
	}

	public SearchModelManageListVO[] getSearchModelManageListVOs() {
		return searchModelManageListVOs;
	}

	public void setSearchModelManageListVOs(
			SearchModelManageListVO[] searchModelManageListVOs) {
		this.searchModelManageListVOs = searchModelManageListVOs;
	}


	private ConditionVO conditionVO = null;
	private ConditionVO[] conditionVOs = null;
	private SpcMdlVerMstVO spcMdlVerMstVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public ConditionVO[] getConditionVOs() {
		return conditionVOs;
	}


	public void setConditionVOs(ConditionVO[] conditionVOs) {
		this.conditionVOs = conditionVOs;
	}

	public SpcMdlVerMstVO getSpcMdlVerMstVO() {
		return spcMdlVerMstVO;
	}


	public void setSpcMdlVerMstVO(SpcMdlVerMstVO spcMdlVerMstVO) {
		this.spcMdlVerMstVO = spcMdlVerMstVO;
	}

	private String slsRhqCd = null;
	private String slsRgnOfcCd = null;
	private String trdCd = null;
	private String subTrdCd = null;
	private String rlaneCd = null;

	public String getSlsRhqCd() {
		return slsRhqCd;
	}

	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}

	public String getSlsRgnOfcCd() {
		return slsRgnOfcCd;
	}

	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}

	public String getTrdCd() {
		return trdCd;
	}

	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}

	public String getSubTrdCd() {
		return subTrdCd;
	}

	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}

	public String getRlaneCd() {
		return rlaneCd;
	}

	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}


	public CustCtrlGrpVO getCustCtrlGrpVO() {
		return custCtrlGrpVO;
	}


	public void setCustCtrlGrpVO(CustCtrlGrpVO custCtrlGrpVO) {
		this.custCtrlGrpVO = custCtrlGrpVO;
	}


	public CustCtrlGrpVO[] getCustCtrlGrpVOs() {
		return custCtrlGrpVOs;
	}


	public void setCustCtrlGrpVOs(CustCtrlGrpVO[] custCtrlGrpVOs) {
		this.custCtrlGrpVOs = custCtrlGrpVOs;
	}
	

   public SpcMdlExptWkVO[] getSpcMdlExptWkVOs() {
        return spcMdlExptWkVOs;
    }


    public void setSpcMdlExptWkVOs(SpcMdlExptWkVO[] spcMdlExptWkVOs) {
        this.spcMdlExptWkVOs = spcMdlExptWkVOs;
    }

    public List<SpcMdlExptWkVO> getSpcMdlExptWkVOList() {
        return spcMdlExptWkVOList;
    }


    public void setSpcMdlExptWkVOList(List<SpcMdlExptWkVO> spcMdlExptWkVOList) {
        this.spcMdlExptWkVOList = spcMdlExptWkVOList;
    }
    
}