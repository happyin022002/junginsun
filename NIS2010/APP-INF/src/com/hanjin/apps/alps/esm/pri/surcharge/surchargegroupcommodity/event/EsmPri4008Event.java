/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4008Event.java
*@FileTitle : GRI COMM Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.08 이승준
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.event;

import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;


/**
 * ESM_PRI_4008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4008HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	CommonGroupCommodityVO commonGroupCommodityVO  = new CommonGroupCommodityVO();

    /** Table Value Object 조회 조건 및 단건 처리  */
    private PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private PriScgGrpCmdtDtlVO[] priScgGrpCmdtDtlVOs = null;

    /** Table Value Object 조회 조건 및 단건 처리  */
    private PriScgGrpCmdtVO priScgGrpCmdtVO = null;
    
    /** Table Value Object Multi Data 처리 */
    private PriScgGrpCmdtVO[] priScgGrpCmdtVOs = null;

    public EsmPri4008Event(){}
    
    public void setPriScgGrpCmdtDtlVO(PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO){
        this. priScgGrpCmdtDtlVO = priScgGrpCmdtDtlVO;
    }

    public void setPriScgGrpCmdtDtlVOS(PriScgGrpCmdtDtlVO[] priScgGrpCmdtDtlVOs){
		if(priScgGrpCmdtDtlVOs != null){
			PriScgGrpCmdtDtlVO[] tmpVOs = new PriScgGrpCmdtDtlVO[priScgGrpCmdtDtlVOs.length];
			System.arraycopy(priScgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgGrpCmdtDtlVOs = tmpVOs;
		}
    }

    public void setPriScgGrpCmdtVO(PriScgGrpCmdtVO priScgGrpCmdtVO){
        this. priScgGrpCmdtVO = priScgGrpCmdtVO;
    }

    public void setPriScgGrpCmdtVOS(PriScgGrpCmdtVO[] priScgGrpCmdtVOs){
		if(priScgGrpCmdtVOs != null){
			PriScgGrpCmdtVO[] tmpVOs = new PriScgGrpCmdtVO[priScgGrpCmdtVOs.length];
			System.arraycopy(priScgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgGrpCmdtVOs = tmpVOs;
		}
    }
    
    public void setCommonGroupCommodityVO(CommonGroupCommodityVO commonGroupCommodityVO) {
        this.commonGroupCommodityVO = commonGroupCommodityVO;
    }

    public PriScgGrpCmdtDtlVO getPriScgGrpCmdtDtlVO(){
        return priScgGrpCmdtDtlVO;
    }

    public PriScgGrpCmdtDtlVO[] getPriScgGrpCmdtDtlVOS(){
		PriScgGrpCmdtDtlVO[] rtnVOs = null;
		if (this.priScgGrpCmdtDtlVOs != null) {
			rtnVOs = new PriScgGrpCmdtDtlVO[priScgGrpCmdtDtlVOs.length];
			System.arraycopy(priScgGrpCmdtDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    public PriScgGrpCmdtVO getPriScgGrpCmdtVO(){
        return priScgGrpCmdtVO;
    }

    public PriScgGrpCmdtVO[] getPriScgGrpCmdtVOS(){
		PriScgGrpCmdtVO[] rtnVOs = null;
		if (this.priScgGrpCmdtVOs != null) {
			rtnVOs = new PriScgGrpCmdtVO[priScgGrpCmdtVOs.length];
			System.arraycopy(priScgGrpCmdtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    public CommonGroupCommodityVO getCommonGroupCommodityVO() {
        return commonGroupCommodityVO;
    }
}