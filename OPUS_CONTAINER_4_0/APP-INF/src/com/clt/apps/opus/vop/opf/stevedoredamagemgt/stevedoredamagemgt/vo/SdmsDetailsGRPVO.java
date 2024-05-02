package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

import java.util.List;

import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;


public class SdmsDetailsGRPVO {
	
	public SdmsDetailsGRPVO(){
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgVO opfStvDmgVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgDtlVO opfStvDmgDtlVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgCmpnVO opfStvDmgCmpnVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgStlVO opfStvDmgStlVO = null;
	
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileDSDRVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileDPICVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileDDOCVO = null;

	private OpfStvDmgAtchFileVO opfStvDmgAtchFileRRESVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileRINVVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileRPICVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileRDOCVO = null;

	private OpfStvDmgAtchFileVO opfStvDmgAtchFileSINVVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileSDOCVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<OpfStvDmgVO> opfStvDmgVOs = null;
	/** Table Value Object Multi Data 처리 */
	private List<OpfStvDmgDtlVO> opfStvDmgDtlVOs = null;
	/** Table Value Object Multi Data 처리 */
	private List<OpfStvDmgRprVO> opfStvDmgRprVOs = null;
	/** Table Value Object Multi Data 처리 */
	private List<OpfStvDmgCmpnVO> opfStvDmgCmpnVOs = null;
	/** Table Value Object Multi Data 처리 */
	private List<OpfStvDmgStlVO> opfStvDmgStlVOs = null;
	
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileDSDRVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileDPICVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileDDOCVOs = null;
	
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRRESVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRINVVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRPICVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRDOCVOs = null;
	
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileSINVVOs = null;
	private List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileSDOCVOs = null;
	
	/** 화면 Data 받는 VO Array 처리 */
	private OpfStvDmgRprVO[] opfStvDmgRprVO = null;
	
	public void setOpfStvDmgVO(OpfStvDmgVO opfStvDmgVO){
		this. opfStvDmgVO = opfStvDmgVO;
	}
	public OpfStvDmgVO getOpfStvDmgVO(){
		return opfStvDmgVO;
	}
	
	public OpfStvDmgDtlVO getOpfStvDmgDtlVO() {
		return opfStvDmgDtlVO;
	}
	public void setOpfStvDmgDtlVO(OpfStvDmgDtlVO opfStvDmgDtlVO) {
		this.opfStvDmgDtlVO = opfStvDmgDtlVO;
	}
	
	public OpfStvDmgCmpnVO getOpfStvDmgCmpnVO() {
		return opfStvDmgCmpnVO;
	}
	public void setOpfStvDmgCmpnVO(OpfStvDmgCmpnVO opfStvDmgCmpnVO) {
		this.opfStvDmgCmpnVO = opfStvDmgCmpnVO;
	}
	
	public OpfStvDmgStlVO getOpfStvDmgStlVO() {
		return opfStvDmgStlVO;
	}
	public void setOpfStvDmgStlVO(OpfStvDmgStlVO opfStvDmgStlVO) {
		this.opfStvDmgStlVO = opfStvDmgStlVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileVO() {
		return opfStvDmgAtchFileVO;
	}
	public void setOpfStvDmgAtchFileVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO) {
		this.opfStvDmgAtchFileVO = opfStvDmgAtchFileVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileDSDRVO() {
		return opfStvDmgAtchFileDSDRVO;
	}
	public void setOpfStvDmgAtchFileDSDRVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileDSDRVO) {
		this.opfStvDmgAtchFileDSDRVO = opfStvDmgAtchFileDSDRVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileDPICVO() {
		return opfStvDmgAtchFileDPICVO;
	}
	public void setOpfStvDmgAtchFileDPICVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileDPICVO) {
		this.opfStvDmgAtchFileDPICVO = opfStvDmgAtchFileDPICVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileDDOCVO() {
		return opfStvDmgAtchFileDDOCVO;
	}
	public void setOpfStvDmgAtchFileDDOCVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileDDOCVO) {
		this.opfStvDmgAtchFileDDOCVO = opfStvDmgAtchFileDDOCVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileRRESVO() {
		return opfStvDmgAtchFileRRESVO;
	}
	public void setOpfStvDmgAtchFileRRESVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileRRESVO) {
		this.opfStvDmgAtchFileRRESVO = opfStvDmgAtchFileRRESVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileRINVVO() {
		return opfStvDmgAtchFileRINVVO;
	}
	public void setOpfStvDmgAtchFileRINVVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileRINVVO) {
		this.opfStvDmgAtchFileRINVVO = opfStvDmgAtchFileRINVVO;
	}

	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileRPICVO() {
		return opfStvDmgAtchFileRPICVO;
	}
	public void setOpfStvDmgAtchFileRPICVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileRPICVO) {
		this.opfStvDmgAtchFileRPICVO = opfStvDmgAtchFileRPICVO;
	}

	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileRDOCVO() {
		return opfStvDmgAtchFileRDOCVO;
	}
	public void setOpfStvDmgAtchFileRDOCVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileRDOCVO) {
		this.opfStvDmgAtchFileRDOCVO = opfStvDmgAtchFileRDOCVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileSINVVO() {
		return opfStvDmgAtchFileSINVVO;
	}
	public void setOpfStvDmgAtchFileSINVVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileSINVVO) {
		this.opfStvDmgAtchFileSINVVO = opfStvDmgAtchFileSINVVO;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileSDOCVO() {
		return opfStvDmgAtchFileSDOCVO;
	}
	public void setOpfStvDmgAtchFileSDOCVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileSDOCVO) {
		this.opfStvDmgAtchFileSDOCVO = opfStvDmgAtchFileSDOCVO;
	}
	
	public List<OpfStvDmgRprVO> getOpfStvDmgRprVOs() {
		return opfStvDmgRprVOs;
	}
	public void setOpfStvDmgRprVOs(List<OpfStvDmgRprVO> opfStvDmgRprVOs) {
		this.opfStvDmgRprVOs = opfStvDmgRprVOs;
	}
	
	public List<OpfStvDmgVO> getOpfStvDmgVOs() {
		return opfStvDmgVOs;
	}
	public void setOpfStvDmgVOs(List<OpfStvDmgVO> opfStvDmgVOs) {
		this.opfStvDmgVOs = opfStvDmgVOs;
	}
	
	public List<OpfStvDmgDtlVO> getOpfStvDmgDtlVOs() {
		return opfStvDmgDtlVOs;
	}
	public void setOpfStvDmgDtlVOs(List<OpfStvDmgDtlVO> opfStvDmgDtlVOs) {
		this.opfStvDmgDtlVOs = opfStvDmgDtlVOs;
	}
	
	public List<OpfStvDmgCmpnVO> getOpfStvDmgCmpnVOs() {
		return opfStvDmgCmpnVOs;
	}
	public void setOpfStvDmgCmpnVOs(List<OpfStvDmgCmpnVO> opfStvDmgCmpnVOs) {
		this.opfStvDmgCmpnVOs = opfStvDmgCmpnVOs;
	}
	
	public List<OpfStvDmgStlVO> getOpfStvDmgStlVOs() {
		return opfStvDmgStlVOs;
	}
	public void setOpfStvDmgStlVOs(List<OpfStvDmgStlVO> opfStvDmgStlVOs) {
		this.opfStvDmgStlVOs = opfStvDmgStlVOs;
	}
	
	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileVOs() {
		return opfStvDmgAtchFileVOs;
	}
	public void setOpfStvDmgAtchFileVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs) {
		this.opfStvDmgAtchFileVOs = opfStvDmgAtchFileVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileDSDRVOs() {
		return opfStvDmgAtchFileDSDRVOs;
	}
	public void setOpfStvDmgAtchFileDSDRVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileDSDRVOs) {
		this.opfStvDmgAtchFileDSDRVOs = opfStvDmgAtchFileDSDRVOs;
	}
	
	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileDPICVOs() {
		return opfStvDmgAtchFileDPICVOs;
	}
	public void setOpfStvDmgAtchFileDPICVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileDPICVOs) {
		this.opfStvDmgAtchFileDPICVOs = opfStvDmgAtchFileDPICVOs;
	}
	
	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileDDOCVOs() {
		return opfStvDmgAtchFileDDOCVOs;
	}
	public void setOpfStvDmgAtchFileDDOCVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileDDOCVOs) {
		this.opfStvDmgAtchFileDDOCVOs = opfStvDmgAtchFileDDOCVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileRRESVOs() {
		return opfStvDmgAtchFileRRESVOs;
	}
	public void setOpfStvDmgAtchFileRRESVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRRESVOs) {
		this.opfStvDmgAtchFileRRESVOs = opfStvDmgAtchFileRRESVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileRINVVOs() {
		return opfStvDmgAtchFileRINVVOs;
	}
	public void setOpfStvDmgAtchFileRINVVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRINVVOs) {
		this.opfStvDmgAtchFileRINVVOs = opfStvDmgAtchFileRINVVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileRPICVOs() {
		return opfStvDmgAtchFileRPICVOs;
	}
	public void setOpfStvDmgAtchFileRPICVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRPICVOs) {
		this.opfStvDmgAtchFileRPICVOs = opfStvDmgAtchFileRPICVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileRDOCVOs() {
		return opfStvDmgAtchFileRDOCVOs;
	}
	public void setOpfStvDmgAtchFileRDOCVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileRDOCVOs) {
		this.opfStvDmgAtchFileRDOCVOs = opfStvDmgAtchFileRDOCVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileSINVVOs() {
		return opfStvDmgAtchFileSINVVOs;
	}
	public void setOpfStvDmgAtchFileSINVVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileSINVVOs) {
		this.opfStvDmgAtchFileSINVVOs = opfStvDmgAtchFileSINVVOs;
	}

	public List<OpfStvDmgAtchFileVO> getOpfStvDmgAtchFileSDOCVOs() {
		return opfStvDmgAtchFileSDOCVOs;
	}
	public void setOpfStvDmgAtchFileSDOCVOs(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileSDOCVOs) {
		this.opfStvDmgAtchFileSDOCVOs = opfStvDmgAtchFileSDOCVOs;
	}
	
	public OpfStvDmgRprVO[] getOpfStvDmgRprVO() {
		return opfStvDmgRprVO;
	}
	public void setOpfStvDmgRprVO(OpfStvDmgRprVO[] opfStvDmgRprVO) {
		this.opfStvDmgRprVO = opfStvDmgRprVO;
	}	

}