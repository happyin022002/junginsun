/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CstPriSpMnFileDtVO.java
*@FileTitle : CstPriSpMnFileDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.14
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.07.14 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstPriSpMnFileDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstPriSpMnFileDtVO> models = new ArrayList<CstPriSpMnFileDtVO>();
	
	/* Column Info */
	private String fnlCtDt = null;
	/* Column Info */
	private String mnlFileFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String errCodeConNum = null;
	/* Column Info */
	private String fmcFileSessId = null;
	/* Column Info */
	private String errCodeAmdNum = null;
	/* Column Info */
	private String errCodeFile = null;
	/* Column Info */
	private String errMsgUserName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmcAmdtNo = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String fnlCtStff = null;
	/* Column Info */
	private String fmcFileMdtFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fmcFileTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String errCodeEffDate = null;
	/* Column Info */
	private String fmcFileSndDt = null;
	/* Column Info */
	private String orzNo = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String fileProgSeq = null;
	/* Column Info */
	private String fmcFileUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String fmcFileCfmDt = null;
	/* Column Info */
	private String fileSzCapa = null;
	/* Column Info */
	private String errMsgOrgNum = null;
	/* Column Info */
	private String fileProgDt = null;
	/* Column Info */
	private String usEstSysDt = null;
	/* Column Info */
	private String preEffDt = null;
	/* Column Info */
	private String fmcCtrtNo = null;
	/* Column Info */
	private String errMsgFile = null;
	/* Column Info */
	private String fnlCtCfmNo = null;
	/* Column Info */
	private String fmcFileErrMsg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmcNo = null;
	/* Column Info */
	private String errMsgEffDate = null;
	/* Column Info */
	private String fileStff = null;
	/* Column Info */
	private String fmcFileNm = null;
	/* Column Info */
	private String errMsgConNum = null;
	/* Column Info */
	private String cfmNo = null;
	/* Column Info */
	private String fileProgUsrId = null;
	/* Column Info */
	private String fileCorrCmtCtnt = null;
	/* Column Info */
	private String fmcEffDt = null;
	/* Column Info */
	private String errMsgAmdNum = null;
	/* Column Info */
	private String errCodeUserName = null;
	/* Column Info */
	private String ctCnt = null;
	/* Column Info */
	private String effDtChg = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String fileEffDt = null;
	/* Column Info */
	private String lastFileDt = null;
	/* Column Info */
	private String errCodeOrgNum = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstPriSpMnFileDtVO() {}

	public CstPriSpMnFileDtVO(String ibflag, String pagerows, String propNo, String amdtSeq, String lastFileDt, String effDt, String usEstSysDt, String preEffDt, String fmcFileCfmDt, String cfmNo, String fileStff, String fnlCtDt, String fnlCtCfmNo, String fnlCtStff, String ctCnt, String fileCorrCmtCtnt, String fmcFileErrMsg, String fileDt, String fmcFileMdtFlg, String fileProgSeq, String fmcFileTpCd, String fileEffDt, String fmcFileSndDt, String fileProgDt, String fileProgUsrId, String fmcFileNm, String orzNo, String fmcCtrtNo, String fmcAmdtNo, String fmcFileUsrId, String fmcFileSessId, String fmcNo, String fmcEffDt, String fileSzCapa, String mnlFileFlg, String creUsrId, String updUsrId, String errCodeUserName, String errCodeOrgNum, String errCodeConNum, String errCodeAmdNum, String errCodeEffDate, String errCodeFile, String errMsgUserName, String errMsgOrgNum, String errMsgConNum, String errMsgAmdNum, String errMsgEffDate, String errMsgFile, String scNo, String propOfcCd, String effDtChg) {
		this.fnlCtDt = fnlCtDt;
		this.mnlFileFlg = mnlFileFlg;
		this.amdtSeq = amdtSeq;
		this.errCodeConNum = errCodeConNum;
		this.fmcFileSessId = fmcFileSessId;
		this.errCodeAmdNum = errCodeAmdNum;
		this.errCodeFile = errCodeFile;
		this.errMsgUserName = errMsgUserName;
		this.pagerows = pagerows;
		this.fmcAmdtNo = fmcAmdtNo;
		this.effDt = effDt;
		this.fnlCtStff = fnlCtStff;
		this.fmcFileMdtFlg = fmcFileMdtFlg;
		this.scNo = scNo;
		this.fmcFileTpCd = fmcFileTpCd;
		this.updUsrId = updUsrId;
		this.errCodeEffDate = errCodeEffDate;
		this.fmcFileSndDt = fmcFileSndDt;
		this.orzNo = orzNo;
		this.fileDt = fileDt;
		this.fileProgSeq = fileProgSeq;
		this.fmcFileUsrId = fmcFileUsrId;
		this.creUsrId = creUsrId;
		this.propOfcCd = propOfcCd;
		this.fmcFileCfmDt = fmcFileCfmDt;
		this.fileSzCapa = fileSzCapa;
		this.errMsgOrgNum = errMsgOrgNum;
		this.fileProgDt = fileProgDt;
		this.usEstSysDt = usEstSysDt;
		this.preEffDt = preEffDt;
		this.fmcCtrtNo = fmcCtrtNo;
		this.errMsgFile = errMsgFile;
		this.fnlCtCfmNo = fnlCtCfmNo;
		this.fmcFileErrMsg = fmcFileErrMsg;
		this.ibflag = ibflag;
		this.fmcNo = fmcNo;
		this.errMsgEffDate = errMsgEffDate;
		this.fileStff = fileStff;
		this.fmcFileNm = fmcFileNm;
		this.errMsgConNum = errMsgConNum;
		this.cfmNo = cfmNo;
		this.fileProgUsrId = fileProgUsrId;
		this.fileCorrCmtCtnt = fileCorrCmtCtnt;
		this.fmcEffDt = fmcEffDt;
		this.errMsgAmdNum = errMsgAmdNum;
		this.errCodeUserName = errCodeUserName;
		this.ctCnt = ctCnt;
		this.effDtChg = effDtChg;
		this.propNo = propNo;
		this.fileEffDt = fileEffDt;
		this.lastFileDt = lastFileDt;
		this.errCodeOrgNum = errCodeOrgNum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fnl_ct_dt", getFnlCtDt());
		this.hashColumns.put("mnl_file_flg", getMnlFileFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("err_code_con_num", getErrCodeConNum());
		this.hashColumns.put("fmc_file_sess_id", getFmcFileSessId());
		this.hashColumns.put("err_code_amd_num", getErrCodeAmdNum());
		this.hashColumns.put("err_code_file", getErrCodeFile());
		this.hashColumns.put("err_msg_user_name", getErrMsgUserName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fmc_amdt_no", getFmcAmdtNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("fnl_ct_stff", getFnlCtStff());
		this.hashColumns.put("fmc_file_mdt_flg", getFmcFileMdtFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fmc_file_tp_cd", getFmcFileTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("err_code_eff_date", getErrCodeEffDate());
		this.hashColumns.put("fmc_file_snd_dt", getFmcFileSndDt());
		this.hashColumns.put("orz_no", getOrzNo());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("file_prog_seq", getFileProgSeq());
		this.hashColumns.put("fmc_file_usr_id", getFmcFileUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("fmc_file_cfm_dt", getFmcFileCfmDt());
		this.hashColumns.put("file_sz_capa", getFileSzCapa());
		this.hashColumns.put("err_msg_org_num", getErrMsgOrgNum());
		this.hashColumns.put("file_prog_dt", getFileProgDt());
		this.hashColumns.put("us_est_sys_dt", getUsEstSysDt());
		this.hashColumns.put("pre_eff_dt", getPreEffDt());
		this.hashColumns.put("fmc_ctrt_no", getFmcCtrtNo());
		this.hashColumns.put("err_msg_file", getErrMsgFile());
		this.hashColumns.put("fnl_ct_cfm_no", getFnlCtCfmNo());
		this.hashColumns.put("fmc_file_err_msg", getFmcFileErrMsg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("err_msg_eff_date", getErrMsgEffDate());
		this.hashColumns.put("file_stff", getFileStff());
		this.hashColumns.put("fmc_file_nm", getFmcFileNm());
		this.hashColumns.put("err_msg_con_num", getErrMsgConNum());
		this.hashColumns.put("cfm_no", getCfmNo());
		this.hashColumns.put("file_prog_usr_id", getFileProgUsrId());
		this.hashColumns.put("file_corr_cmt_ctnt", getFileCorrCmtCtnt());
		this.hashColumns.put("fmc_eff_dt", getFmcEffDt());
		this.hashColumns.put("err_msg_amd_num", getErrMsgAmdNum());
		this.hashColumns.put("err_code_user_name", getErrCodeUserName());
		this.hashColumns.put("ct_cnt", getCtCnt());
		this.hashColumns.put("eff_dt_chg", getEffDtChg());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("file_eff_dt", getFileEffDt());
		this.hashColumns.put("last_file_dt", getLastFileDt());
		this.hashColumns.put("err_code_org_num", getErrCodeOrgNum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fnl_ct_dt", "fnlCtDt");
		this.hashFields.put("mnl_file_flg", "mnlFileFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("err_code_con_num", "errCodeConNum");
		this.hashFields.put("fmc_file_sess_id", "fmcFileSessId");
		this.hashFields.put("err_code_amd_num", "errCodeAmdNum");
		this.hashFields.put("err_code_file", "errCodeFile");
		this.hashFields.put("err_msg_user_name", "errMsgUserName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fmc_amdt_no", "fmcAmdtNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("fnl_ct_stff", "fnlCtStff");
		this.hashFields.put("fmc_file_mdt_flg", "fmcFileMdtFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fmc_file_tp_cd", "fmcFileTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("err_code_eff_date", "errCodeEffDate");
		this.hashFields.put("fmc_file_snd_dt", "fmcFileSndDt");
		this.hashFields.put("orz_no", "orzNo");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("file_prog_seq", "fileProgSeq");
		this.hashFields.put("fmc_file_usr_id", "fmcFileUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("fmc_file_cfm_dt", "fmcFileCfmDt");
		this.hashFields.put("file_sz_capa", "fileSzCapa");
		this.hashFields.put("err_msg_org_num", "errMsgOrgNum");
		this.hashFields.put("file_prog_dt", "fileProgDt");
		this.hashFields.put("us_est_sys_dt", "usEstSysDt");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("fmc_ctrt_no", "fmcCtrtNo");
		this.hashFields.put("err_msg_file", "errMsgFile");
		this.hashFields.put("fnl_ct_cfm_no", "fnlCtCfmNo");
		this.hashFields.put("fmc_file_err_msg", "fmcFileErrMsg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("err_msg_eff_date", "errMsgEffDate");
		this.hashFields.put("file_stff", "fileStff");
		this.hashFields.put("fmc_file_nm", "fmcFileNm");
		this.hashFields.put("err_msg_con_num", "errMsgConNum");
		this.hashFields.put("cfm_no", "cfmNo");
		this.hashFields.put("file_prog_usr_id", "fileProgUsrId");
		this.hashFields.put("file_corr_cmt_ctnt", "fileCorrCmtCtnt");
		this.hashFields.put("fmc_eff_dt", "fmcEffDt");
		this.hashFields.put("err_msg_amd_num", "errMsgAmdNum");
		this.hashFields.put("err_code_user_name", "errCodeUserName");
		this.hashFields.put("ct_cnt", "ctCnt");
		this.hashFields.put("eff_dt_chg", "effDtChg");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("file_eff_dt", "fileEffDt");
		this.hashFields.put("last_file_dt", "lastFileDt");
		this.hashFields.put("err_code_org_num", "errCodeOrgNum");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fnlCtDt
	 */
	public String getFnlCtDt() {
		return this.fnlCtDt;
	}
	
	/**
	 * Column Info
	 * @return mnlFileFlg
	 */
	public String getMnlFileFlg() {
		return this.mnlFileFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return errCodeConNum
	 */
	public String getErrCodeConNum() {
		return this.errCodeConNum;
	}
	
	/**
	 * Column Info
	 * @return fmcFileSessId
	 */
	public String getFmcFileSessId() {
		return this.fmcFileSessId;
	}
	
	/**
	 * Column Info
	 * @return errCodeAmdNum
	 */
	public String getErrCodeAmdNum() {
		return this.errCodeAmdNum;
	}
	
	/**
	 * Column Info
	 * @return errCodeFile
	 */
	public String getErrCodeFile() {
		return this.errCodeFile;
	}
	
	/**
	 * Column Info
	 * @return errMsgUserName
	 */
	public String getErrMsgUserName() {
		return this.errMsgUserName;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return fmcAmdtNo
	 */
	public String getFmcAmdtNo() {
		return this.fmcAmdtNo;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return fnlCtStff
	 */
	public String getFnlCtStff() {
		return this.fnlCtStff;
	}
	
	/**
	 * Column Info
	 * @return fmcFileMdtFlg
	 */
	public String getFmcFileMdtFlg() {
		return this.fmcFileMdtFlg;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return fmcFileTpCd
	 */
	public String getFmcFileTpCd() {
		return this.fmcFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return errCodeEffDate
	 */
	public String getErrCodeEffDate() {
		return this.errCodeEffDate;
	}
	
	/**
	 * Column Info
	 * @return fmcFileSndDt
	 */
	public String getFmcFileSndDt() {
		return this.fmcFileSndDt;
	}
	
	/**
	 * Column Info
	 * @return orzNo
	 */
	public String getOrzNo() {
		return this.orzNo;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return fileProgSeq
	 */
	public String getFileProgSeq() {
		return this.fileProgSeq;
	}
	
	/**
	 * Column Info
	 * @return fmcFileUsrId
	 */
	public String getFmcFileUsrId() {
		return this.fmcFileUsrId;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmcFileCfmDt
	 */
	public String getFmcFileCfmDt() {
		return this.fmcFileCfmDt;
	}
	
	/**
	 * Column Info
	 * @return fileSzCapa
	 */
	public String getFileSzCapa() {
		return this.fileSzCapa;
	}
	
	/**
	 * Column Info
	 * @return errMsgOrgNum
	 */
	public String getErrMsgOrgNum() {
		return this.errMsgOrgNum;
	}
	
	/**
	 * Column Info
	 * @return fileProgDt
	 */
	public String getFileProgDt() {
		return this.fileProgDt;
	}
	
	/**
	 * Column Info
	 * @return usEstSysDt
	 */
	public String getUsEstSysDt() {
		return this.usEstSysDt;
	}
	
	/**
	 * Column Info
	 * @return preEffDt
	 */
	public String getPreEffDt() {
		return this.preEffDt;
	}
	
	/**
	 * Column Info
	 * @return fmcCtrtNo
	 */
	public String getFmcCtrtNo() {
		return this.fmcCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return errMsgFile
	 */
	public String getErrMsgFile() {
		return this.errMsgFile;
	}
	
	/**
	 * Column Info
	 * @return fnlCtCfmNo
	 */
	public String getFnlCtCfmNo() {
		return this.fnlCtCfmNo;
	}
	
	/**
	 * Column Info
	 * @return fmcFileErrMsg
	 */
	public String getFmcFileErrMsg() {
		return this.fmcFileErrMsg;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
	}
	
	/**
	 * Column Info
	 * @return errMsgEffDate
	 */
	public String getErrMsgEffDate() {
		return this.errMsgEffDate;
	}
	
	/**
	 * Column Info
	 * @return fileStff
	 */
	public String getFileStff() {
		return this.fileStff;
	}
	
	/**
	 * Column Info
	 * @return fmcFileNm
	 */
	public String getFmcFileNm() {
		return this.fmcFileNm;
	}
	
	/**
	 * Column Info
	 * @return errMsgConNum
	 */
	public String getErrMsgConNum() {
		return this.errMsgConNum;
	}
	
	/**
	 * Column Info
	 * @return cfmNo
	 */
	public String getCfmNo() {
		return this.cfmNo;
	}
	
	/**
	 * Column Info
	 * @return fileProgUsrId
	 */
	public String getFileProgUsrId() {
		return this.fileProgUsrId;
	}
	
	/**
	 * Column Info
	 * @return fileCorrCmtCtnt
	 */
	public String getFileCorrCmtCtnt() {
		return this.fileCorrCmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return fmcEffDt
	 */
	public String getFmcEffDt() {
		return this.fmcEffDt;
	}
	
	/**
	 * Column Info
	 * @return errMsgAmdNum
	 */
	public String getErrMsgAmdNum() {
		return this.errMsgAmdNum;
	}
	
	/**
	 * Column Info
	 * @return errCodeUserName
	 */
	public String getErrCodeUserName() {
		return this.errCodeUserName;
	}
	
	/**
	 * Column Info
	 * @return ctCnt
	 */
	public String getCtCnt() {
		return this.ctCnt;
	}
	
	/**
	 * Column Info
	 * @return effDtChg
	 */
	public String getEffDtChg() {
		return this.effDtChg;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return fileEffDt
	 */
	public String getFileEffDt() {
		return this.fileEffDt;
	}
	
	/**
	 * Column Info
	 * @return lastFileDt
	 */
	public String getLastFileDt() {
		return this.lastFileDt;
	}
	
	/**
	 * Column Info
	 * @return errCodeOrgNum
	 */
	public String getErrCodeOrgNum() {
		return this.errCodeOrgNum;
	}
	

	/**
	 * Column Info
	 * @param fnlCtDt
	 */
	public void setFnlCtDt(String fnlCtDt) {
		this.fnlCtDt = fnlCtDt;
	}
	
	/**
	 * Column Info
	 * @param mnlFileFlg
	 */
	public void setMnlFileFlg(String mnlFileFlg) {
		this.mnlFileFlg = mnlFileFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param errCodeConNum
	 */
	public void setErrCodeConNum(String errCodeConNum) {
		this.errCodeConNum = errCodeConNum;
	}
	
	/**
	 * Column Info
	 * @param fmcFileSessId
	 */
	public void setFmcFileSessId(String fmcFileSessId) {
		this.fmcFileSessId = fmcFileSessId;
	}
	
	/**
	 * Column Info
	 * @param errCodeAmdNum
	 */
	public void setErrCodeAmdNum(String errCodeAmdNum) {
		this.errCodeAmdNum = errCodeAmdNum;
	}
	
	/**
	 * Column Info
	 * @param errCodeFile
	 */
	public void setErrCodeFile(String errCodeFile) {
		this.errCodeFile = errCodeFile;
	}
	
	/**
	 * Column Info
	 * @param errMsgUserName
	 */
	public void setErrMsgUserName(String errMsgUserName) {
		this.errMsgUserName = errMsgUserName;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param fmcAmdtNo
	 */
	public void setFmcAmdtNo(String fmcAmdtNo) {
		this.fmcAmdtNo = fmcAmdtNo;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param fnlCtStff
	 */
	public void setFnlCtStff(String fnlCtStff) {
		this.fnlCtStff = fnlCtStff;
	}
	
	/**
	 * Column Info
	 * @param fmcFileMdtFlg
	 */
	public void setFmcFileMdtFlg(String fmcFileMdtFlg) {
		this.fmcFileMdtFlg = fmcFileMdtFlg;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param fmcFileTpCd
	 */
	public void setFmcFileTpCd(String fmcFileTpCd) {
		this.fmcFileTpCd = fmcFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param errCodeEffDate
	 */
	public void setErrCodeEffDate(String errCodeEffDate) {
		this.errCodeEffDate = errCodeEffDate;
	}
	
	/**
	 * Column Info
	 * @param fmcFileSndDt
	 */
	public void setFmcFileSndDt(String fmcFileSndDt) {
		this.fmcFileSndDt = fmcFileSndDt;
	}
	
	/**
	 * Column Info
	 * @param orzNo
	 */
	public void setOrzNo(String orzNo) {
		this.orzNo = orzNo;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param fileProgSeq
	 */
	public void setFileProgSeq(String fileProgSeq) {
		this.fileProgSeq = fileProgSeq;
	}
	
	/**
	 * Column Info
	 * @param fmcFileUsrId
	 */
	public void setFmcFileUsrId(String fmcFileUsrId) {
		this.fmcFileUsrId = fmcFileUsrId;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmcFileCfmDt
	 */
	public void setFmcFileCfmDt(String fmcFileCfmDt) {
		this.fmcFileCfmDt = fmcFileCfmDt;
	}
	
	/**
	 * Column Info
	 * @param fileSzCapa
	 */
	public void setFileSzCapa(String fileSzCapa) {
		this.fileSzCapa = fileSzCapa;
	}
	
	/**
	 * Column Info
	 * @param errMsgOrgNum
	 */
	public void setErrMsgOrgNum(String errMsgOrgNum) {
		this.errMsgOrgNum = errMsgOrgNum;
	}
	
	/**
	 * Column Info
	 * @param fileProgDt
	 */
	public void setFileProgDt(String fileProgDt) {
		this.fileProgDt = fileProgDt;
	}
	
	/**
	 * Column Info
	 * @param usEstSysDt
	 */
	public void setUsEstSysDt(String usEstSysDt) {
		this.usEstSysDt = usEstSysDt;
	}
	
	/**
	 * Column Info
	 * @param preEffDt
	 */
	public void setPreEffDt(String preEffDt) {
		this.preEffDt = preEffDt;
	}
	
	/**
	 * Column Info
	 * @param fmcCtrtNo
	 */
	public void setFmcCtrtNo(String fmcCtrtNo) {
		this.fmcCtrtNo = fmcCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param errMsgFile
	 */
	public void setErrMsgFile(String errMsgFile) {
		this.errMsgFile = errMsgFile;
	}
	
	/**
	 * Column Info
	 * @param fnlCtCfmNo
	 */
	public void setFnlCtCfmNo(String fnlCtCfmNo) {
		this.fnlCtCfmNo = fnlCtCfmNo;
	}
	
	/**
	 * Column Info
	 * @param fmcFileErrMsg
	 */
	public void setFmcFileErrMsg(String fmcFileErrMsg) {
		this.fmcFileErrMsg = fmcFileErrMsg;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
	}
	
	/**
	 * Column Info
	 * @param errMsgEffDate
	 */
	public void setErrMsgEffDate(String errMsgEffDate) {
		this.errMsgEffDate = errMsgEffDate;
	}
	
	/**
	 * Column Info
	 * @param fileStff
	 */
	public void setFileStff(String fileStff) {
		this.fileStff = fileStff;
	}
	
	/**
	 * Column Info
	 * @param fmcFileNm
	 */
	public void setFmcFileNm(String fmcFileNm) {
		this.fmcFileNm = fmcFileNm;
	}
	
	/**
	 * Column Info
	 * @param errMsgConNum
	 */
	public void setErrMsgConNum(String errMsgConNum) {
		this.errMsgConNum = errMsgConNum;
	}
	
	/**
	 * Column Info
	 * @param cfmNo
	 */
	public void setCfmNo(String cfmNo) {
		this.cfmNo = cfmNo;
	}
	
	/**
	 * Column Info
	 * @param fileProgUsrId
	 */
	public void setFileProgUsrId(String fileProgUsrId) {
		this.fileProgUsrId = fileProgUsrId;
	}
	
	/**
	 * Column Info
	 * @param fileCorrCmtCtnt
	 */
	public void setFileCorrCmtCtnt(String fileCorrCmtCtnt) {
		this.fileCorrCmtCtnt = fileCorrCmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param fmcEffDt
	 */
	public void setFmcEffDt(String fmcEffDt) {
		this.fmcEffDt = fmcEffDt;
	}
	
	/**
	 * Column Info
	 * @param errMsgAmdNum
	 */
	public void setErrMsgAmdNum(String errMsgAmdNum) {
		this.errMsgAmdNum = errMsgAmdNum;
	}
	
	/**
	 * Column Info
	 * @param errCodeUserName
	 */
	public void setErrCodeUserName(String errCodeUserName) {
		this.errCodeUserName = errCodeUserName;
	}
	
	/**
	 * Column Info
	 * @param ctCnt
	 */
	public void setCtCnt(String ctCnt) {
		this.ctCnt = ctCnt;
	}
	
	/**
	 * Column Info
	 * @param effDtChg
	 */
	public void setEffDtChg(String effDtChg) {
		this.effDtChg = effDtChg;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param fileEffDt
	 */
	public void setFileEffDt(String fileEffDt) {
		this.fileEffDt = fileEffDt;
	}
	
	/**
	 * Column Info
	 * @param lastFileDt
	 */
	public void setLastFileDt(String lastFileDt) {
		this.lastFileDt = lastFileDt;
	}
	
	/**
	 * Column Info
	 * @param errCodeOrgNum
	 */
	public void setErrCodeOrgNum(String errCodeOrgNum) {
		this.errCodeOrgNum = errCodeOrgNum;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setFnlCtDt(JSPUtil.getParameter(request, prefix + "fnl_ct_dt", ""));
		setMnlFileFlg(JSPUtil.getParameter(request, prefix + "mnl_file_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setErrCodeConNum(JSPUtil.getParameter(request, prefix + "err_code_con_num", ""));
		setFmcFileSessId(JSPUtil.getParameter(request, prefix + "fmc_file_sess_id", ""));
		setErrCodeAmdNum(JSPUtil.getParameter(request, prefix + "err_code_amd_num", ""));
		setErrCodeFile(JSPUtil.getParameter(request, prefix + "err_code_file", ""));
		setErrMsgUserName(JSPUtil.getParameter(request, prefix + "err_msg_user_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmcAmdtNo(JSPUtil.getParameter(request, prefix + "fmc_amdt_no", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setFnlCtStff(JSPUtil.getParameter(request, prefix + "fnl_ct_stff", ""));
		setFmcFileMdtFlg(JSPUtil.getParameter(request, prefix + "fmc_file_mdt_flg", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setFmcFileTpCd(JSPUtil.getParameter(request, prefix + "fmc_file_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setErrCodeEffDate(JSPUtil.getParameter(request, prefix + "err_code_eff_date", ""));
		setFmcFileSndDt(JSPUtil.getParameter(request, prefix + "fmc_file_snd_dt", ""));
		setOrzNo(JSPUtil.getParameter(request, prefix + "orz_no", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setFileProgSeq(JSPUtil.getParameter(request, prefix + "file_prog_seq", ""));
		setFmcFileUsrId(JSPUtil.getParameter(request, prefix + "fmc_file_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setFmcFileCfmDt(JSPUtil.getParameter(request, prefix + "fmc_file_cfm_dt", ""));
		setFileSzCapa(JSPUtil.getParameter(request, prefix + "file_sz_capa", ""));
		setErrMsgOrgNum(JSPUtil.getParameter(request, prefix + "err_msg_org_num", ""));
		setFileProgDt(JSPUtil.getParameter(request, prefix + "file_prog_dt", ""));
		setUsEstSysDt(JSPUtil.getParameter(request, prefix + "us_est_sys_dt", ""));
		setPreEffDt(JSPUtil.getParameter(request, prefix + "pre_eff_dt", ""));
		setFmcCtrtNo(JSPUtil.getParameter(request, prefix + "fmc_ctrt_no", ""));
		setErrMsgFile(JSPUtil.getParameter(request, prefix + "err_msg_file", ""));
		setFnlCtCfmNo(JSPUtil.getParameter(request, prefix + "fnl_ct_cfm_no", ""));
		setFmcFileErrMsg(JSPUtil.getParameter(request, prefix + "fmc_file_err_msg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setErrMsgEffDate(JSPUtil.getParameter(request, prefix + "err_msg_eff_date", ""));
		setFileStff(JSPUtil.getParameter(request, prefix + "file_stff", ""));
		setFmcFileNm(JSPUtil.getParameter(request, prefix + "fmc_file_nm", ""));
		setErrMsgConNum(JSPUtil.getParameter(request, prefix + "err_msg_con_num", ""));
		setCfmNo(JSPUtil.getParameter(request, prefix + "cfm_no", ""));
		setFileProgUsrId(JSPUtil.getParameter(request, prefix + "file_prog_usr_id", ""));
		setFileCorrCmtCtnt(JSPUtil.getParameter(request, prefix + "file_corr_cmt_ctnt", ""));
		setFmcEffDt(JSPUtil.getParameter(request, prefix + "fmc_eff_dt", ""));
		setErrMsgAmdNum(JSPUtil.getParameter(request, prefix + "err_msg_amd_num", ""));
		setErrCodeUserName(JSPUtil.getParameter(request, prefix + "err_code_user_name", ""));
		setCtCnt(JSPUtil.getParameter(request, prefix + "ct_cnt", ""));
		setEffDtChg(JSPUtil.getParameter(request, prefix + "eff_dt_chg", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setFileEffDt(JSPUtil.getParameter(request, prefix + "file_eff_dt", ""));
		setLastFileDt(JSPUtil.getParameter(request, prefix + "last_file_dt", ""));
		setErrCodeOrgNum(JSPUtil.getParameter(request, prefix + "err_code_org_num", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriSpMnFileDtVO[]
	 */
	public CstPriSpMnFileDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstPriSpMnFileDtVO[]
	 */
	public CstPriSpMnFileDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstPriSpMnFileDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fnlCtDt = (JSPUtil.getParameter(request, prefix	+ "fnl_ct_dt", length));
			String[] mnlFileFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_file_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] errCodeConNum = (JSPUtil.getParameter(request, prefix	+ "err_code_con_num", length));
			String[] fmcFileSessId = (JSPUtil.getParameter(request, prefix	+ "fmc_file_sess_id", length));
			String[] errCodeAmdNum = (JSPUtil.getParameter(request, prefix	+ "err_code_amd_num", length));
			String[] errCodeFile = (JSPUtil.getParameter(request, prefix	+ "err_code_file", length));
			String[] errMsgUserName = (JSPUtil.getParameter(request, prefix	+ "err_msg_user_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmcAmdtNo = (JSPUtil.getParameter(request, prefix	+ "fmc_amdt_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] fnlCtStff = (JSPUtil.getParameter(request, prefix	+ "fnl_ct_stff", length));
			String[] fmcFileMdtFlg = (JSPUtil.getParameter(request, prefix	+ "fmc_file_mdt_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] fmcFileTpCd = (JSPUtil.getParameter(request, prefix	+ "fmc_file_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] errCodeEffDate = (JSPUtil.getParameter(request, prefix	+ "err_code_eff_date", length));
			String[] fmcFileSndDt = (JSPUtil.getParameter(request, prefix	+ "fmc_file_snd_dt", length));
			String[] orzNo = (JSPUtil.getParameter(request, prefix	+ "orz_no", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] fileProgSeq = (JSPUtil.getParameter(request, prefix	+ "file_prog_seq", length));
			String[] fmcFileUsrId = (JSPUtil.getParameter(request, prefix	+ "fmc_file_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] fmcFileCfmDt = (JSPUtil.getParameter(request, prefix	+ "fmc_file_cfm_dt", length));
			String[] fileSzCapa = (JSPUtil.getParameter(request, prefix	+ "file_sz_capa", length));
			String[] errMsgOrgNum = (JSPUtil.getParameter(request, prefix	+ "err_msg_org_num", length));
			String[] fileProgDt = (JSPUtil.getParameter(request, prefix	+ "file_prog_dt", length));
			String[] usEstSysDt = (JSPUtil.getParameter(request, prefix	+ "us_est_sys_dt", length));
			String[] preEffDt = (JSPUtil.getParameter(request, prefix	+ "pre_eff_dt", length));
			String[] fmcCtrtNo = (JSPUtil.getParameter(request, prefix	+ "fmc_ctrt_no", length));
			String[] errMsgFile = (JSPUtil.getParameter(request, prefix	+ "err_msg_file", length));
			String[] fnlCtCfmNo = (JSPUtil.getParameter(request, prefix	+ "fnl_ct_cfm_no", length));
			String[] fmcFileErrMsg = (JSPUtil.getParameter(request, prefix	+ "fmc_file_err_msg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] errMsgEffDate = (JSPUtil.getParameter(request, prefix	+ "err_msg_eff_date", length));
			String[] fileStff = (JSPUtil.getParameter(request, prefix	+ "file_stff", length));
			String[] fmcFileNm = (JSPUtil.getParameter(request, prefix	+ "fmc_file_nm", length));
			String[] errMsgConNum = (JSPUtil.getParameter(request, prefix	+ "err_msg_con_num", length));
			String[] cfmNo = (JSPUtil.getParameter(request, prefix	+ "cfm_no", length));
			String[] fileProgUsrId = (JSPUtil.getParameter(request, prefix	+ "file_prog_usr_id", length));
			String[] fileCorrCmtCtnt = (JSPUtil.getParameter(request, prefix	+ "file_corr_cmt_ctnt", length));
			String[] fmcEffDt = (JSPUtil.getParameter(request, prefix	+ "fmc_eff_dt", length));
			String[] errMsgAmdNum = (JSPUtil.getParameter(request, prefix	+ "err_msg_amd_num", length));
			String[] errCodeUserName = (JSPUtil.getParameter(request, prefix	+ "err_code_user_name", length));
			String[] ctCnt = (JSPUtil.getParameter(request, prefix	+ "ct_cnt", length));
			String[] effDtChg = (JSPUtil.getParameter(request, prefix	+ "eff_dt_chg", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] fileEffDt = (JSPUtil.getParameter(request, prefix	+ "file_eff_dt", length));
			String[] lastFileDt = (JSPUtil.getParameter(request, prefix	+ "last_file_dt", length));
			String[] errCodeOrgNum = (JSPUtil.getParameter(request, prefix	+ "err_code_org_num", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstPriSpMnFileDtVO();
				if (fnlCtDt[i] != null)
					model.setFnlCtDt(fnlCtDt[i]);
				if (mnlFileFlg[i] != null)
					model.setMnlFileFlg(mnlFileFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (errCodeConNum[i] != null)
					model.setErrCodeConNum(errCodeConNum[i]);
				if (fmcFileSessId[i] != null)
					model.setFmcFileSessId(fmcFileSessId[i]);
				if (errCodeAmdNum[i] != null)
					model.setErrCodeAmdNum(errCodeAmdNum[i]);
				if (errCodeFile[i] != null)
					model.setErrCodeFile(errCodeFile[i]);
				if (errMsgUserName[i] != null)
					model.setErrMsgUserName(errMsgUserName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmcAmdtNo[i] != null)
					model.setFmcAmdtNo(fmcAmdtNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (fnlCtStff[i] != null)
					model.setFnlCtStff(fnlCtStff[i]);
				if (fmcFileMdtFlg[i] != null)
					model.setFmcFileMdtFlg(fmcFileMdtFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fmcFileTpCd[i] != null)
					model.setFmcFileTpCd(fmcFileTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (errCodeEffDate[i] != null)
					model.setErrCodeEffDate(errCodeEffDate[i]);
				if (fmcFileSndDt[i] != null)
					model.setFmcFileSndDt(fmcFileSndDt[i]);
				if (orzNo[i] != null)
					model.setOrzNo(orzNo[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (fileProgSeq[i] != null)
					model.setFileProgSeq(fileProgSeq[i]);
				if (fmcFileUsrId[i] != null)
					model.setFmcFileUsrId(fmcFileUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (fmcFileCfmDt[i] != null)
					model.setFmcFileCfmDt(fmcFileCfmDt[i]);
				if (fileSzCapa[i] != null)
					model.setFileSzCapa(fileSzCapa[i]);
				if (errMsgOrgNum[i] != null)
					model.setErrMsgOrgNum(errMsgOrgNum[i]);
				if (fileProgDt[i] != null)
					model.setFileProgDt(fileProgDt[i]);
				if (usEstSysDt[i] != null)
					model.setUsEstSysDt(usEstSysDt[i]);
				if (preEffDt[i] != null)
					model.setPreEffDt(preEffDt[i]);
				if (fmcCtrtNo[i] != null)
					model.setFmcCtrtNo(fmcCtrtNo[i]);
				if (errMsgFile[i] != null)
					model.setErrMsgFile(errMsgFile[i]);
				if (fnlCtCfmNo[i] != null)
					model.setFnlCtCfmNo(fnlCtCfmNo[i]);
				if (fmcFileErrMsg[i] != null)
					model.setFmcFileErrMsg(fmcFileErrMsg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (errMsgEffDate[i] != null)
					model.setErrMsgEffDate(errMsgEffDate[i]);
				if (fileStff[i] != null)
					model.setFileStff(fileStff[i]);
				if (fmcFileNm[i] != null)
					model.setFmcFileNm(fmcFileNm[i]);
				if (errMsgConNum[i] != null)
					model.setErrMsgConNum(errMsgConNum[i]);
				if (cfmNo[i] != null)
					model.setCfmNo(cfmNo[i]);
				if (fileProgUsrId[i] != null)
					model.setFileProgUsrId(fileProgUsrId[i]);
				if (fileCorrCmtCtnt[i] != null)
					model.setFileCorrCmtCtnt(fileCorrCmtCtnt[i]);
				if (fmcEffDt[i] != null)
					model.setFmcEffDt(fmcEffDt[i]);
				if (errMsgAmdNum[i] != null)
					model.setErrMsgAmdNum(errMsgAmdNum[i]);
				if (errCodeUserName[i] != null)
					model.setErrCodeUserName(errCodeUserName[i]);
				if (ctCnt[i] != null)
					model.setCtCnt(ctCnt[i]);
				if (effDtChg[i] != null)
					model.setEffDtChg(effDtChg[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (fileEffDt[i] != null)
					model.setFileEffDt(fileEffDt[i]);
				if (lastFileDt[i] != null)
					model.setLastFileDt(lastFileDt[i]);
				if (errCodeOrgNum[i] != null)
					model.setErrCodeOrgNum(errCodeOrgNum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstPriSpMnFileDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstPriSpMnFileDtVO[]
	 */
	public CstPriSpMnFileDtVO[] getCstPriSpMnFileDtVOs(){
		CstPriSpMnFileDtVO[] vos = (CstPriSpMnFileDtVO[])models.toArray(new CstPriSpMnFileDtVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.fnlCtDt = this.fnlCtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFileFlg = this.mnlFileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCodeConNum = this.errCodeConNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileSessId = this.fmcFileSessId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCodeAmdNum = this.errCodeAmdNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCodeFile = this.errCodeFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsgUserName = this.errMsgUserName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcAmdtNo = this.fmcAmdtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlCtStff = this.fnlCtStff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileMdtFlg = this.fmcFileMdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileTpCd = this.fmcFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCodeEffDate = this.errCodeEffDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileSndDt = this.fmcFileSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orzNo = this.orzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileProgSeq = this.fileProgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileUsrId = this.fmcFileUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileCfmDt = this.fmcFileCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSzCapa = this.fileSzCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsgOrgNum = this.errMsgOrgNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileProgDt = this.fileProgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usEstSysDt = this.usEstSysDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt = this.preEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcCtrtNo = this.fmcCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsgFile = this.errMsgFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlCtCfmNo = this.fnlCtCfmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileErrMsg = this.fmcFileErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsgEffDate = this.errMsgEffDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileStff = this.fileStff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileNm = this.fmcFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsgConNum = this.errMsgConNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmNo = this.cfmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileProgUsrId = this.fileProgUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileCorrCmtCtnt = this.fileCorrCmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcEffDt = this.fmcEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsgAmdNum = this.errMsgAmdNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCodeUserName = this.errCodeUserName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctCnt = this.ctCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtChg = this.effDtChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileEffDt = this.fileEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastFileDt = this.lastFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCodeOrgNum = this.errCodeOrgNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
