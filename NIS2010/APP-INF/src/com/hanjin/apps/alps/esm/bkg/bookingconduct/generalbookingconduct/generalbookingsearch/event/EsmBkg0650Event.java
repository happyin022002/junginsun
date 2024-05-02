/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0650Event.java
*@FileTitle : Transhipment Route and VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.04.30 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0650 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0650HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_0650HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0650Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String codRqstSeq = null;
	private String opCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSRouteVO tSRouteVO = null;
	private BkgBlNoVO bkgBlNoVO = null;

	/** Table Value Object Multi Data 처리 */
	private TSRouteVO[] tSRouteVOs = null;

	public EsmBkg0650Event(){}

	public void setTSRouteVO(TSRouteVO tSRouteVO){
		this. tSRouteVO = tSRouteVO;
	}

	public void setTSRouteVOS(TSRouteVO[] tSRouteVOs){
		this. tSRouteVOs = tSRouteVOs;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

	public TSRouteVO getTSRouteVO(){
		return tSRouteVO;
	}

	public TSRouteVO[] getTSRouteVOS(){
		return tSRouteVOs;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setCodRqstSeq(String codRqstSeq){
		this. codRqstSeq = codRqstSeq;
	}

	public String getCodRqstSeq(){
		return codRqstSeq;
	}	

	public void setOpCd(String opCd){
		this. opCd = opCd;
	}

	public String getOpCd(){
		return opCd;
	}		
}