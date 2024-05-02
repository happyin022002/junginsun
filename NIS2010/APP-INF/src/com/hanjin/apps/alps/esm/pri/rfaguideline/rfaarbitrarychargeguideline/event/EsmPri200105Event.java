/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri000104Event.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRgArbVO;


/**
 * UI_PRI_0002_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PRI_0002_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_2001_05HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmPri200105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	   /** Table Value Object 조회 조건 및 단건 처리 */
    private FicRouteGLineVO ficRouteGLineVO = null;
    private GLineInfoByFICRouteVO gLineInfoByFICRouteVO = null;
 
    /** Table Value Object Multi Data 처리 */
    private FicRouteGLineVO[] ficRouteGLineVOs = null;
    private GLineInfoByFICRouteVO[] gLineInfoByFICRouteVOs = null;
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgArbVO priRgArbVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRgArbVO[] priRgArbVOs = null;

	public EsmPri200105Event(){}
	
	

    public GLineInfoByFICRouteVO getgLineInfoByFICRouteVO() {
        return gLineInfoByFICRouteVO;
    }

    public void setgLineInfoByFICRouteVO(GLineInfoByFICRouteVO gLineInfoByFICRouteVO) {
        this.gLineInfoByFICRouteVO = gLineInfoByFICRouteVO;
    }

 
    public GLineInfoByFICRouteVO[] getgLineInfoByFICRouteVOs() {
        GLineInfoByFICRouteVO[] rtnVOs = null;
        if (this.gLineInfoByFICRouteVOs != null) {
            rtnVOs = new GLineInfoByFICRouteVO[gLineInfoByFICRouteVOs.length];
            System.arraycopy(gLineInfoByFICRouteVOs, 0, rtnVOs, 0, rtnVOs.length);
        }
        return rtnVOs;
    }

    public void setgLineInfoByFICRouteVOs(GLineInfoByFICRouteVO[] gLineInfoByFICRouteVOs){
        if(gLineInfoByFICRouteVOs != null){
            GLineInfoByFICRouteVO[] tmpVOs = new GLineInfoByFICRouteVO[gLineInfoByFICRouteVOs.length];
            System.arraycopy(gLineInfoByFICRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
            this.gLineInfoByFICRouteVOs = tmpVOs;
        }
    }

    public FicRouteGLineVO getFicRouteGLineVO() {
        return ficRouteGLineVO;
    }

    public void setFicRouteGLineVO(FicRouteGLineVO ficRouteGLineVO) {
        this.ficRouteGLineVO = ficRouteGLineVO;
    }

    public FicRouteGLineVO[] getFicRouteGLineVOs() {
        FicRouteGLineVO[] rtnVOs = null;
        if (this.ficRouteGLineVOs != null) {
            rtnVOs = new FicRouteGLineVO[ficRouteGLineVOs.length];
            System.arraycopy(ficRouteGLineVOs, 0, rtnVOs, 0, rtnVOs.length);
        }
        return rtnVOs;
    }

    public void setFicRouteGLineVOs(FicRouteGLineVO[] ficRouteGLineVOs){
        if(ficRouteGLineVOs != null){
            FicRouteGLineVO[] tmpVOs = new FicRouteGLineVO[ficRouteGLineVOs.length];
            System.arraycopy(ficRouteGLineVOs, 0, tmpVOs, 0, tmpVOs.length);
            this.ficRouteGLineVOs = tmpVOs;
        }
    }

    public GLineInfoByFICRouteVO getGLineInfoByFICRouteVO() {
        return gLineInfoByFICRouteVO;
    }

    public void setGLineInfoByFICRouteVO(GLineInfoByFICRouteVO gLineInfoByFICRouteVO) {
        this.gLineInfoByFICRouteVO = gLineInfoByFICRouteVO;
    }

    public GLineInfoByFICRouteVO[] getGLineInfoByFICRouteVOs() {
        GLineInfoByFICRouteVO[] rtnVOs = null;
        if (this.gLineInfoByFICRouteVOs != null) {
            rtnVOs = new GLineInfoByFICRouteVO[gLineInfoByFICRouteVOs.length];
            System.arraycopy(gLineInfoByFICRouteVOs, 0, rtnVOs, 0, rtnVOs.length);
        }
        return rtnVOs;
    }

    public void setGLineInfoByFICRouteVOs(GLineInfoByFICRouteVO[] gLineInfoByFICRouteVOs){
        if(gLineInfoByFICRouteVOs != null){
            GLineInfoByFICRouteVO[] tmpVOs = new GLineInfoByFICRouteVO[gLineInfoByFICRouteVOs.length];
            System.arraycopy(gLineInfoByFICRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
            this.gLineInfoByFICRouteVOs = tmpVOs;
        }
    }
    
    
	public void setPriRgArbVO(PriRgArbVO priRgArbVO){
		this. priRgArbVO = priRgArbVO;
	}

	public void setPriRgArbVOS(PriRgArbVO[] priRgArbVOs){
		if(priRgArbVOs != null){
			PriRgArbVO[] tmpVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgArbVOs = tmpVOs;
		}
	}

	public PriRgArbVO getPriRgArbVO(){
		return priRgArbVO;
	}

	public PriRgArbVO[] getPriRgArbVOS(){
		PriRgArbVO[] rtnVOs = null;
		if (this.priRgArbVOs != null) {
			rtnVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}