/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri200312Event.java
 *@FileTitle : RFA Proposal & Amendment Creation - Arbitrary Tab (Add-On Tariff Management)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.21
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * ESM_PRI_2003_12 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2005_12HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_2003_12HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200312Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private FicRouteGLineVO ficRouteGLineVO = null;
	private GLineInfoByFICRouteVO gLineInfoByFICRouteVO = null;
	private PriRpScpTrspAddChgVO priRpScpTrspAddChgVO = null;

	/** Table Value Object Multi Data 처리 */
	private FicRouteGLineVO[] ficRouteGLineVOs = null;
	private GLineInfoByFICRouteVO[] gLineInfoByFICRouteVOs = null;

	public EsmPri200312Event() {
	}

	public GLineInfoByFICRouteVO getgLineInfoByFICRouteVO() {
		return gLineInfoByFICRouteVO;
	}

	public void setgLineInfoByFICRouteVO(GLineInfoByFICRouteVO gLineInfoByFICRouteVO) {
		this.gLineInfoByFICRouteVO = gLineInfoByFICRouteVO;
	}

	public PriRpScpTrspAddChgVO getPriRpScpTrspAddChgVO() {
		return priRpScpTrspAddChgVO;
	}

	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) {
		this.priRpScpTrspAddChgVO = priRpScpTrspAddChgVO;
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
}