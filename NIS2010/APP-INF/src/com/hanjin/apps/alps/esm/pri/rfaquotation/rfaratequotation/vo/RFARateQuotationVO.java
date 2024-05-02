package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRqRtVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 * 
 * @author 이승준
 * @since J2EE 1.5
 */

public class RFARateQuotationVO {

	private String ficRtTpCd = null;

	private String inOrgDestTpCd = null;

	private String svcScpCd = null;

	/** Table Value Object 단건 Data 처리 */
	private PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = null;
	private PriRqRtCmdtVO priRqRtCmdtVO = null;
	private PriRqRtCmdtRoutVO PriRqRtCmdtRoutVO = null;
	private PriRqRtRoutPntVO priRqRtRoutPntOrgVO = null;
	private PriRqRtRoutPntVO priRqRtRoutPntDestVO = null;
	private PriRqRtRoutViaVO priRqRtRoutOrgViaVO = null;
	private PriRqRtRoutViaVO priRqRtRoutDestViaVO = null;

	private RsltPriRqRtRoutOrgPntVO priRqRtRoutOrgPntVO = null;
	private RsltPriRqRtRoutDestPntVO priRqRtRoutDestPntVO = null;
	private PriRqRtVO priRqRtVO = null;
	private RsltPriRqMnVO rsltPriRqMnVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRqRtCmdtHdrVO[] priRqRtCmdtHdrVOs = null;
	private PriRqRtCmdtVO[] priRqRtCmdtVOs = null;
	private PriRqRtCmdtRoutVO[] PriRqRtCmdtRoutVOs = null;
	private PriRqRtRoutPntVO[] priRqRtRoutOrgPntVOs = null;
	private PriRqRtRoutPntVO[] priRqRtRoutDestPntVOs = null;
	private PriRqRtRoutViaVO[] priRqRtRoutOrgViaVOs = null;
	private PriRqRtRoutViaVO[] priRqRtRoutDestViaVOs = null;
	private PriRqRtVO[] priRqRtVOs = null;
	private RsltRtListVerticalExcelForIHCVO[] rsltRtListVerticalExcelForIHCVOs = null;
	private RsltRtListHorizontalExcelForIHCVO[] rsltRtListHorizontalExcelForIHCVOs = null;
	private RsltRtListHorizontalLoadExcelForIHCVO[] rsltRtListHorizontalLoadExcelForIHCVOs = null;

	private RsltPriRqRtListVerticalExcelForAddOnTariffVO[] rsltPriRqRtListVerticalExcelForAddOnTariffVOs = null;
	private RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] rsltPriRqRtListHorizontalExcelForAddOnTariffVOs = null;

	private RsltPriRqRtCmdtVO[] rsltPriRqRtCmdtVOs = null;

	/** Table Value Object Multi Data 처리 */
	List<RsltPriRqRtCmdtVO> rsltPriRqRtCmdtVOList = new ArrayList<RsltPriRqRtCmdtVO>();
	List<RsltPriRqRtCmdtRoutVO> rsltPriRqRtCmdtRoutVOList = new ArrayList<RsltPriRqRtCmdtRoutVO>();
	List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutOrgViaVOList = new ArrayList<RsltPriRqRtRoutViaVO>();
	List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutDestViaVOList = new ArrayList<RsltPriRqRtRoutViaVO>();
	List<RsltPriRqRtVO> rsltPriRqRtVOList = new ArrayList<RsltPriRqRtVO>();

	List<RsltPriRqRtRoutOrgPntVO> rsltPriRqRtRoutOrgPntVOs = new ArrayList<RsltPriRqRtRoutOrgPntVO>();
	List<RsltPriRqRtRoutDestPntVO> rsltPriRqRtRoutDestPntVOs = new ArrayList<RsltPriRqRtRoutDestPntVO>();

	private PriRqRtLoadExcelGuidelineCheckVO priRqRtLoadExcelGuidelineCheckVO = null;
	private PriRqRtLoadExcelGuidelineCheckVO[] priRqRtLoadExcelGuidelineCheckVOs = null;

	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
	}

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	public PriRqRtCmdtHdrVO getPriRqRtCmdtHdrVO() {
		return priRqRtCmdtHdrVO;
	}

	public void setPriRqRtCmdtHdrVO(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) {
		this.priRqRtCmdtHdrVO = priRqRtCmdtHdrVO;
	}

	public PriRqRtCmdtVO getPriRqRtCmdtVO() {
		return priRqRtCmdtVO;
	}

	public void setPriRqRtCmdtVO(PriRqRtCmdtVO priRqRtCmdtVO) {
		this.priRqRtCmdtVO = priRqRtCmdtVO;
	}

	public PriRqRtCmdtRoutVO getPriRqRtCmdtRoutVO() {
		return PriRqRtCmdtRoutVO;
	}

	public void setPriRqRtCmdtRoutVO(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) {
		PriRqRtCmdtRoutVO = priRqRtCmdtRoutVO;
	}

	public PriRqRtRoutPntVO getPriRqRtRoutPntOrgVO() {
		return priRqRtRoutPntOrgVO;
	}

	public void setPriRqRtRoutPntOrgVO(PriRqRtRoutPntVO priRqRtRoutPntOrgVO) {
		this.priRqRtRoutPntOrgVO = priRqRtRoutPntOrgVO;
	}

	public PriRqRtRoutPntVO getPriRqRtRoutPntDestVO() {
		return priRqRtRoutPntDestVO;
	}

	public void setPriRqRtRoutPntDestVO(PriRqRtRoutPntVO priRqRtRoutPntDestVO) {
		this.priRqRtRoutPntDestVO = priRqRtRoutPntDestVO;
	}

	public PriRqRtRoutViaVO getPriRqRtRoutOrgViaVO() {
		return priRqRtRoutOrgViaVO;
	}

	public void setPriRqRtRoutOrgViaVO(PriRqRtRoutViaVO priRqRtRoutOrgViaVO) {
		this.priRqRtRoutOrgViaVO = priRqRtRoutOrgViaVO;
	}

	public PriRqRtRoutViaVO getPriRqRtRoutDestViaVO() {
		return priRqRtRoutDestViaVO;
	}

	public void setPriRqRtRoutDestViaVO(PriRqRtRoutViaVO priRqRtRoutDestViaVO) {
		this.priRqRtRoutDestViaVO = priRqRtRoutDestViaVO;
	}

	public RsltPriRqRtRoutOrgPntVO getPriRqRtRoutOrgPntVO() {
		return priRqRtRoutOrgPntVO;
	}

	public void setPriRqRtRoutOrgPntVO(RsltPriRqRtRoutOrgPntVO priRqRtRoutOrgPntVO) {
		this.priRqRtRoutOrgPntVO = priRqRtRoutOrgPntVO;
	}

	public RsltPriRqRtRoutDestPntVO getPriRqRtRoutDestPntVO() {
		return priRqRtRoutDestPntVO;
	}

	public void setPriRqRtRoutDestPntVO(RsltPriRqRtRoutDestPntVO priRqRtRoutDestPntVO) {
		this.priRqRtRoutDestPntVO = priRqRtRoutDestPntVO;
	}

	public PriRqRtVO getPriRqRtVO() {
		return priRqRtVO;
	}

	public void setPriRqRtVO(PriRqRtVO priRqRtVO) {
		this.priRqRtVO = priRqRtVO;
	}

	public RsltPriRqMnVO getRsltPriRqMnVO() {
		return rsltPriRqMnVO;
	}

	public void setRsltPriRqMnVO(RsltPriRqMnVO rsltPriRqMnVO) {
		this.rsltPriRqMnVO = rsltPriRqMnVO;
	}

	public PriRqRtCmdtHdrVO[] getPriRqRtCmdtHdrVOs() {
		return priRqRtCmdtHdrVOs;
	}

	public void setPriRqRtCmdtHdrVOs(PriRqRtCmdtHdrVO[] priRqRtCmdtHdrVOs) {
		this.priRqRtCmdtHdrVOs = priRqRtCmdtHdrVOs;
	}

	public PriRqRtCmdtVO[] getPriRqRtCmdtVOs() {
		return priRqRtCmdtVOs;
	}

	public void setPriRqRtCmdtVOs(PriRqRtCmdtVO[] priRqRtCmdtVOs) {
		this.priRqRtCmdtVOs = priRqRtCmdtVOs;
	}

	public PriRqRtCmdtRoutVO[] getPriRqRtCmdtRoutVOs() {
		return PriRqRtCmdtRoutVOs;
	}

	public void setPriRqRtCmdtRoutVOs(PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVOs) {
		PriRqRtCmdtRoutVOs = priRqRtCmdtRoutVOs;
	}

	public PriRqRtRoutPntVO[] getPriRqRtRoutOrgPntVOs() {
		return priRqRtRoutOrgPntVOs;
	}

	public void setPriRqRtRoutOrgPntVOs(PriRqRtRoutPntVO[] priRqRtRoutOrgPntVOs) {
		this.priRqRtRoutOrgPntVOs = priRqRtRoutOrgPntVOs;
	}

	public PriRqRtRoutPntVO[] getPriRqRtRoutDestPntVOs() {
		return priRqRtRoutDestPntVOs;
	}

	public void setPriRqRtRoutDestPntVOs(PriRqRtRoutPntVO[] priRqRtRoutDestPntVOs) {
		this.priRqRtRoutDestPntVOs = priRqRtRoutDestPntVOs;
	}

	public PriRqRtRoutViaVO[] getPriRqRtRoutOrgViaVOs() {
		return priRqRtRoutOrgViaVOs;
	}

	public void setPriRqRtRoutOrgViaVOs(PriRqRtRoutViaVO[] priRqRtRoutOrgViaVOs) {
		this.priRqRtRoutOrgViaVOs = priRqRtRoutOrgViaVOs;
	}

	public PriRqRtRoutViaVO[] getPriRqRtRoutDestViaVOs() {
		return priRqRtRoutDestViaVOs;
	}

	public void setPriRqRtRoutDestViaVOs(PriRqRtRoutViaVO[] priRqRtRoutDestViaVOs) {
		this.priRqRtRoutDestViaVOs = priRqRtRoutDestViaVOs;
	}

	public PriRqRtVO[] getPriRqRtVOs() {
		return priRqRtVOs;
	}

	public void setPriRqRtVOs(PriRqRtVO[] priRqRtVOs) {
		this.priRqRtVOs = priRqRtVOs;
	}

	public RsltRtListVerticalExcelForIHCVO[] getRsltRtListVerticalExcelForIHCVOs() {
		return rsltRtListVerticalExcelForIHCVOs;
	}

	public void setRsltRtListVerticalExcelForIHCVOs(RsltRtListVerticalExcelForIHCVO[] rsltRtListVerticalExcelForIHCVOs) {
		this.rsltRtListVerticalExcelForIHCVOs = rsltRtListVerticalExcelForIHCVOs;
	}

	public RsltRtListHorizontalExcelForIHCVO[] getRsltRtListHorizontalExcelForIHCVOs() {
		return rsltRtListHorizontalExcelForIHCVOs;
	}

	public void setRsltRtListHorizontalExcelForIHCVOs(RsltRtListHorizontalExcelForIHCVO[] rsltRtListHorizontalExcelForIHCVOs) {
		this.rsltRtListHorizontalExcelForIHCVOs = rsltRtListHorizontalExcelForIHCVOs;
	}

	public RsltRtListHorizontalLoadExcelForIHCVO[] getRsltRtListHorizontalLoadExcelForIHCVOs() {
		return rsltRtListHorizontalLoadExcelForIHCVOs;
	}

	public void setRsltRtListHorizontalLoadExcelForIHCVOs(RsltRtListHorizontalLoadExcelForIHCVO[] rsltRtListHorizontalLoadExcelForIHCVOs) {
		this.rsltRtListHorizontalLoadExcelForIHCVOs = rsltRtListHorizontalLoadExcelForIHCVOs;
	}

	public RsltPriRqRtCmdtVO[] getRsltPriRqRtCmdtVOs() {
		return rsltPriRqRtCmdtVOs;
	}

	public void setRsltPriRqRtCmdtVOs(RsltPriRqRtCmdtVO[] rsltPriRqRtCmdtVOs) {
		this.rsltPriRqRtCmdtVOs = rsltPriRqRtCmdtVOs;
	}

	public List<RsltPriRqRtCmdtVO> getRsltPriRqRtCmdtVOList() {
		return rsltPriRqRtCmdtVOList;
	}

	public void setRsltPriRqRtCmdtVOList(List<RsltPriRqRtCmdtVO> rsltPriRqRtCmdtVOList) {
		this.rsltPriRqRtCmdtVOList = rsltPriRqRtCmdtVOList;
	}

	public List<RsltPriRqRtCmdtRoutVO> getRsltPriRqRtCmdtRoutVOList() {
		return rsltPriRqRtCmdtRoutVOList;
	}

	public void setRsltPriRqRtCmdtRoutVOList(List<RsltPriRqRtCmdtRoutVO> rsltPriRqRtCmdtRoutVOList) {
		this.rsltPriRqRtCmdtRoutVOList = rsltPriRqRtCmdtRoutVOList;
	}

	public List<RsltPriRqRtRoutViaVO> getRsltPriRqRtRoutOrgViaVOList() {
		return rsltPriRqRtRoutOrgViaVOList;
	}

	public void setRsltPriRqRtRoutOrgViaVOList(List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutOrgViaVOList) {
		this.rsltPriRqRtRoutOrgViaVOList = rsltPriRqRtRoutOrgViaVOList;
	}

	public List<RsltPriRqRtRoutViaVO> getRsltPriRqRtRoutDestViaVOList() {
		return rsltPriRqRtRoutDestViaVOList;
	}

	public void setRsltPriRqRtRoutDestViaVOList(List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutDestViaVOList) {
		this.rsltPriRqRtRoutDestViaVOList = rsltPriRqRtRoutDestViaVOList;
	}

	public List<RsltPriRqRtVO> getRsltPriRqRtVOList() {
		return rsltPriRqRtVOList;
	}

	public void setRsltPriRqRtVOList(List<RsltPriRqRtVO> rsltPriRqRtVOList) {
		this.rsltPriRqRtVOList = rsltPriRqRtVOList;
	}

	public List<RsltPriRqRtRoutOrgPntVO> getRsltPriRqRtRoutOrgPntVOs() {
		return rsltPriRqRtRoutOrgPntVOs;
	}

	public void setRsltPriRqRtRoutOrgPntVOs(List<RsltPriRqRtRoutOrgPntVO> rsltPriRqRtRoutOrgPntVOs) {
		this.rsltPriRqRtRoutOrgPntVOs = rsltPriRqRtRoutOrgPntVOs;
	}

	public List<RsltPriRqRtRoutDestPntVO> getRsltPriRqRtRoutDestPntVOs() {
		return rsltPriRqRtRoutDestPntVOs;
	}

	public void setRsltPriRqRtRoutDestPntVOs(List<RsltPriRqRtRoutDestPntVO> rsltPriRqRtRoutDestPntVOs) {
		this.rsltPriRqRtRoutDestPntVOs = rsltPriRqRtRoutDestPntVOs;
	}

	public String getInOrgDestTpCd() {
		return inOrgDestTpCd;
	}

	public void setInOrgDestTpCd(String inOrgDestTpCd) {
		this.inOrgDestTpCd = inOrgDestTpCd;
	}

	public PriRqRtLoadExcelGuidelineCheckVO getPriRqRtLoadExcelGuidelineCheckVO() {
		return priRqRtLoadExcelGuidelineCheckVO;
	}

	public void setPriRqRtLoadExcelGuidelineCheckVO(PriRqRtLoadExcelGuidelineCheckVO priRqRtLoadExcelGuidelineCheckVO) {
		this.priRqRtLoadExcelGuidelineCheckVO = priRqRtLoadExcelGuidelineCheckVO;
	}

	public PriRqRtLoadExcelGuidelineCheckVO[] getPriRqRtLoadExcelGuidelineCheckVOs() {
		return priRqRtLoadExcelGuidelineCheckVOs;
	}

	public void setPriRqRtLoadExcelGuidelineCheckVOs(PriRqRtLoadExcelGuidelineCheckVO[] priRqRtLoadExcelGuidelineCheckVOs) {
		this.priRqRtLoadExcelGuidelineCheckVOs = priRqRtLoadExcelGuidelineCheckVOs;
	}

	public RsltPriRqRtListVerticalExcelForAddOnTariffVO[] getRsltPriRqRtListVerticalExcelForAddOnTariffVOs() {
		return rsltPriRqRtListVerticalExcelForAddOnTariffVOs;
	}

	public void setRsltPriRqRtListVerticalExcelForAddOnTariffVOs(RsltPriRqRtListVerticalExcelForAddOnTariffVO[] rsltPriRqRtListVerticalExcelForAddOnTariffVOs) {
		this.rsltPriRqRtListVerticalExcelForAddOnTariffVOs = rsltPriRqRtListVerticalExcelForAddOnTariffVOs;
	}

	public RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] getRsltPriRqRtListHorizontalExcelForAddOnTariffVOs() {
		return rsltPriRqRtListHorizontalExcelForAddOnTariffVOs;
	}

	public void setRsltPriRqRtListHorizontalExcelForAddOnTariffVOs(RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] rsltPriRqRtListHorizontalExcelForAddOnTariffVOs) {
		this.rsltPriRqRtListHorizontalExcelForAddOnTariffVOs = rsltPriRqRtListHorizontalExcelForAddOnTariffVOs;
	}

}