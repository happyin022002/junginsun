/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmSqm0222Event.java
*@FileTitle      : QTA Edit_Office Add for IAS Sector
*@Open Issues    :
*@Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSctrLodRevVO;

/**
 * ESM_SQM_0222 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0222HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0222HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0222Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmSqm0222Event(){}

	private ConditionVO conditionVO = null;

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	/** Table Value Object Multi Data 처리 */
	private ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOs = null;


	/** Table Value Object Multi Data 처리 */
	private SqmSctrLodRevVO[] sqmSctrLodRevVOs = null;
	

	public void setManageQtaEditIasSectorVOS(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOs){
		if(manageQtaEditIasSectorVOs != null){
			this.manageQtaEditIasSectorVOs = new ManageQtaEditIasSectorVO[manageQtaEditIasSectorVOs.length];
			for(int i=0; i<manageQtaEditIasSectorVOs.length; ++i){
				this.manageQtaEditIasSectorVOs[i] = manageQtaEditIasSectorVOs[i];
			}
		}
	}

	public ManageQtaEditIasSectorVO[] getManageQtaEditIasSectorVOS(){
		ManageQtaEditIasSectorVO[] ret = null;
		if(this.manageQtaEditIasSectorVOs != null){
			ret = new ManageQtaEditIasSectorVO[manageQtaEditIasSectorVOs.length];
			for(int i=0; i<manageQtaEditIasSectorVOs.length; i++){
				ret[i] = this.manageQtaEditIasSectorVOs[i];
			}
		}
		return ret;
	}

	/**
	 * @return the sqmSctrLodRevVOs
	 */
	public SqmSctrLodRevVO[] getSqmSctrLodRevVOs() {
		SqmSctrLodRevVO[] ret = null;
		if(this.sqmSctrLodRevVOs != null){
			ret = new SqmSctrLodRevVO[sqmSctrLodRevVOs.length];
			for(int i=0; i<sqmSctrLodRevVOs.length; i++){
				ret[i] = this.sqmSctrLodRevVOs[i];
			}
		}
		return ret;
	}

	/**
	 * @param sqmSctrLodRevVOs the sqmSctrLodRevVOs to set
	 */
	public void setSqmSctrLodRevVOs(SqmSctrLodRevVO[] sqmSctrLodRevVOs) {
		if(sqmSctrLodRevVOs != null){
			this.sqmSctrLodRevVOs = new SqmSctrLodRevVO[sqmSctrLodRevVOs.length];
			for(int i=0; i<sqmSctrLodRevVOs.length; ++i){
				this.sqmSctrLodRevVOs[i] = sqmSctrLodRevVOs[i];
			}
		}
	}

	

}