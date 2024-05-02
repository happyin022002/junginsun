/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMSNCreateContainerVO.java
*@FileTitle : KorMSNCreateContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * MSN Create 화면 전달용 컨테이너 VO
 *
 * @author 박상훈
 *
 */
public class KorMSNCreateContainerVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 7360083200461808323L;

	// MRN 정보 VO
	private KorMrnInfoVO korMrnInfoVO = null;
	// LOCAL LIST VOs
	private List<KorMsnInfoVO> localMsnInfoVOs = null;
	// TS LIST VOs
	private List<KorMsnInfoVO> tsMsnInfoVOs = null;
	// LOCAL BL TYPE COUNT
	private KorBlTypeCntVO localBlTpCnt = null;
	// TS BL TYPE COUNT
	private KorBlTypeCntVO TsBlTpCnt = null;

	public KorMSNCreateContainerVO() {}

	/**
	 * @return the localMsnInfoVOs
	 */
	public List<KorMsnInfoVO> getLocalMsnInfoVOs() {
		return localMsnInfoVOs;
	}

	/**
	 * @param localMsnInfoVOs the localMsnInfoVOs to set
	 */
	public void setLocalMsnInfoVOs(List<KorMsnInfoVO> localMsnInfoVOs) {
		this.localMsnInfoVOs = localMsnInfoVOs;
	}

	/**
	 * @return the tsMsnInfoVOs
	 */
	public List<KorMsnInfoVO> getTsMsnInfoVOs() {
		return tsMsnInfoVOs;
	}

	/**
	 * @param tsMsnInfoVOs the tsMsnInfoVOs to set
	 */
	public void setTsMsnInfoVOs(List<KorMsnInfoVO> tsMsnInfoVOs) {
		this.tsMsnInfoVOs = tsMsnInfoVOs;
	}

	/**
	 * @return the korMrnInfoVO
	 */
	public KorMrnInfoVO getKorMrnInfoVO() {
		return korMrnInfoVO;
	}

	/**
	 * @param korMrnInfoVO the korMrnInfoVO to set
	 */
	public void setKorMrnInfoVO(KorMrnInfoVO korMrnInfoVO) {
		this.korMrnInfoVO = korMrnInfoVO;
	}

	/**
	 * @return the localBlTpCnt
	 */
	public KorBlTypeCntVO getLocalBlTpCnt() {
		return localBlTpCnt;
	}

	/**
	 * @param localBlTpCnt the localBlTpCnt to set
	 */
	public void setLocalBlTpCnt(KorBlTypeCntVO localBlTpCnt) {
		this.localBlTpCnt = localBlTpCnt;
	}

	/**
	 * @return the tsBlTpCnt
	 */
	public KorBlTypeCntVO getTsBlTpCnt() {
		return TsBlTpCnt;
	}

	/**
	 * @param tsBlTpCnt the tsBlTpCnt to set
	 */
	public void setTsBlTpCnt(KorBlTypeCntVO tsBlTpCnt) {
		TsBlTpCnt = tsBlTpCnt;
	}

}
