package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;

/**
 * Container Value Ojbect<br>
 * Indonesia flat file을 생성하기 위한 여러 단위 VO들을 가지고 있음
 *
 * @author 민동진
 * @since J2EE 1.6
 * @see ManifestListVO
 */
public class IndonesiaManifestListVO extends ManifestListVO {
	private static final long serialVersionUID = 1L;
	
	IndonesiaManifestHeaderVO indonesiaManifestHeaderVO;
	IndonesiaManifestDetail1VO indonesiaManifestDetail1VO;
	IndonesiaManifestDetail2VO indonesiaManifestDetail2VO;
	List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOList;
	List<IndonesiaManifestDokVO> indonesiaManifestDokVOList;
	List<IndonesiaManifestCmdtHsCdVO> indonesiaManifestCmdtHsCdVOList;

	public IndonesiaManifestHeaderVO getIndonesiaManifestHeaderVO() {
		return indonesiaManifestHeaderVO;
	}
	public void setIndonesiaManifestHeaderVO(IndonesiaManifestHeaderVO indonesiaManifestHeaderVO) {
		this.indonesiaManifestHeaderVO = indonesiaManifestHeaderVO;
	}
	public IndonesiaManifestDetail1VO getIndonesiaManifestDetail1VO() {
		return indonesiaManifestDetail1VO;
	}
	public void setIndonesiaManifestDetail1VO(IndonesiaManifestDetail1VO indonesiaManifestDetail1VO) {
		this.indonesiaManifestDetail1VO = indonesiaManifestDetail1VO;
	}
	public IndonesiaManifestDetail2VO getIndonesiaManifestDetail2VO() {
		return indonesiaManifestDetail2VO;
	}
	public void setIndonesiaManifestDetail2VO(IndonesiaManifestDetail2VO indonesiaManifestDetail2VO) {
		this.indonesiaManifestDetail2VO = indonesiaManifestDetail2VO;
	}
	public List<IndonesiaManifestContainerVO> getIndonesiaManifestContainerVOList() {
		return indonesiaManifestContainerVOList;
	}
	public void setIndonesiaManifestContainerVOList(List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOList) {
		this.indonesiaManifestContainerVOList = indonesiaManifestContainerVOList;
	}
	public List<IndonesiaManifestDokVO> getIndonesiaManifestDokVOList() {
		return indonesiaManifestDokVOList;
	}
	public void setIndonesiaManifestDokVOList(List<IndonesiaManifestDokVO> indonesiaManifestDokVOList) {
		this.indonesiaManifestDokVOList = indonesiaManifestDokVOList;
	}
	public List<IndonesiaManifestCmdtHsCdVO> getIndonesiaManifestCmdtHsCdVOList() {
		return indonesiaManifestCmdtHsCdVOList;
	}
	public void setIndonesiaManifestCmdtHsCdVOList(List<IndonesiaManifestCmdtHsCdVO> indonesiaManifestCmdtHsCdVOList) {
		this.indonesiaManifestCmdtHsCdVOList = indonesiaManifestCmdtHsCdVOList;
	}

}
