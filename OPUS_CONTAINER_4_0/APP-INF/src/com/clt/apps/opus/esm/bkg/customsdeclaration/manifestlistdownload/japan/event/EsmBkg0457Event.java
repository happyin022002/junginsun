/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0457Event.java
*@FileTitle : ESM_BKG-0457
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanCmfModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCmfDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0457 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0457HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0457HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0457Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListCondVO japanManifestListCondVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListCmfDetailVO japanManifestListCmfDetail = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanCmfModificationVO japanCmfModificationVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanBlKeyVO japanBlKeyVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String form1CustCntCd = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String form1CustSeq = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String custType = null;

	public EsmBkg0457Event(){}

	public void setJapanManifestListCondVO(JapanManifestListCondVO japanManifestListCondVO){
		this. japanManifestListCondVO = japanManifestListCondVO;
	}

	public JapanManifestListCondVO getJapanManifestListCondVO(){
		return japanManifestListCondVO;
	}

	public void setJapanManifestListCmfDetailVO(JapanManifestListCmfDetailVO japanManifestListCmfDetail){
		this. japanManifestListCmfDetail = japanManifestListCmfDetail;
	}

	public JapanManifestListCmfDetailVO getJapanManifestListCmfDetailVO(){
		return japanManifestListCmfDetail;
	}

	public void setJapanCmfModificationVO(JapanCmfModificationVO japanCmfModificationVO){
		this. japanCmfModificationVO = japanCmfModificationVO;
	}

	public JapanCmfModificationVO getJapanCmfModificationVO(){
		return japanCmfModificationVO;
	}

	public void setJapanBlKeyVO(JapanBlKeyVO japanBlKeyVO){
		this. japanBlKeyVO = japanBlKeyVO;
	}

	public JapanBlKeyVO getJapanBlKeyVO(){
		return japanBlKeyVO;
	}

	public void setForm1CustCntCd(String form1CustCntCd){
		this. form1CustCntCd = form1CustCntCd;
	}

	public String getForm1CustCntCd(){
		return form1CustCntCd;
	}

	public void setForm1CustSeq(String form1CustSeq){
		this. form1CustSeq = form1CustSeq;
	}

	public String getForm1CustSeq(){
		return form1CustSeq;
	}

	public void setCustType(String custType){
		this. custType = custType;
	}

	public String getCustType(){
		return custType;
	}
}
