/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RuLabelListVO.java
 *@FileTitle : RuLabelListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.02.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class RuLabelListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RuLabelListVO>  models =	new	ArrayList<RuLabelListVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgCdSeq   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpCd   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNm   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblDesc   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgDpSeq   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgHisSeq   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgUpdTpCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvYr   =  null;
	/*	Column Info	*/
	private  String	 cnmvIdNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvSeq   =  null;
	/*	Column Info	*/
	private  String	 cnmvSplitNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 lessor   =  null;
	/*	Column Info	*/
	private  String	 lessorNm   =  null;
	/*	Column Info	*/
	private  String	 cntrAuthNo   =  null;
	/*	Column Info	*/
	private  String	 ruLabelType   =  null;
	/*	Column Info	*/
	private  String	 ruLabelValue   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm1   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm2   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm3   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm4   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm5   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm6   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm7   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm8   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm9   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm10   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm11   =  null;
	/*	Column Info	*/
	private  String	 sCntrNo   =  null;
	/*	Column Info	*/
	private  String	 sRuLableType   =  null;
	/*	Column Info	*/
	private  String	 sRuLabelType   =  null;
	/*	Column Info	*/
	private  String	 sRuLabelValue   =  null;
	/*	Column Info	*/
	private  String	 sTpCd   =  null;
	/*	Column Info	*/
	private  String	 sAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 sAgmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 sAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 sContractNo   =  null;
	/*	Column Info	*/
	private  String	 sAuthNo   =  null;
	/*	Column Info	*/
	private  String	 hisRuLabelValue   =  null;
	/*	Column Info	*/
	private  String	 remark   =  null;
	/*	Column Info	*/
	private  String	 allRuLabelType   =  null;
	/*	Column Info	*/
	private  String	 allRuLabelValue   =  null;
	/*	Column Info	*/
	private  String	 allIbFlag   =  null;
	/*	Column Info	*/
	private  String	 ruLabelTypeDesc   =  null;
	/*	Column Info	*/
	private  String	 lotPlnYr   =  null;
	/*	Column Info	*/
	private  String	 lotLocCd   =  null;
	/*	Column Info	*/
	private  String	 lotSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrSpecNo   =  null;
	/*	Column Info	*/
	private  String	 lotNo   =  null;
	/*	Column Info	*/
	private  String	 cntrLotTpszCd   =  null;
	/*	Column Info	*/
	private  String	 level   =  null;
	/*	Column Info	*/
	private  String	 id   =  null;
	/*	Column Info	*/
	private  String	 name   =  null;
	/*	Column Info	*/
	private  String	 usrDefRmk   =  null;
	/*	Column Info	*/
	private  String	 iPage   =  null;
	/*	Column Info	*/
	private  String	 hCntrNo   =  null;
	/*	Column Info	*/
	private  String	 tmpSeq   =  null;
	/*	Column Info	*/
	private  String	 tmpDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 lseCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 mftrVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 mftrVndrNm   =  null;
	/*	Column Info	*/
	private  String	 mftDt   =  null;
	/*	Column Info	*/
	private  String	 rfMkrSeq   =  null;
	/*	Column Info	*/
	private  String	 rfMkrNm   =  null;
	/*	Column Info	*/
	private  String	 rfMdlNm   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 sCntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 sMultiAgmtSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public RuLabelListVO(){}

	public RuLabelListVO(String ibflag,String pagerows,String rstrUsgCdSeq,String rstrUsgTpCd,String rstrUsgLblNm,String rstrUsgLblDesc,String rstrUsgDpSeq,String deltFlg,String creUsrId,String creDt,String updUsrId,String updDt,String cntrNo,String rstrUsgHisSeq,String rstrUsgUpdTpCd,String cnmvYr,String cnmvIdNo,String cnmvSeq,String cnmvSplitNo,String cntrTpszCd,String agmtNo,String lessor,String lessorNm,String cntrAuthNo,String ruLabelType,String ruLabelValue,String rstrUsgTpLblNm1,String rstrUsgTpLblNm2,String rstrUsgTpLblNm3,String rstrUsgTpLblNm4,String rstrUsgTpLblNm5,String rstrUsgTpLblNm6,String rstrUsgTpLblNm7,String rstrUsgTpLblNm8,String rstrUsgTpLblNm9,String rstrUsgTpLblNm10,String rstrUsgTpLblNm11,String sCntrNo,String sRuLableType,String sRuLabelType,String sRuLabelValue,String sTpCd,String sAgmtNo,String sAgmtCtyCd,String sAgmtSeq,String sContractNo,String sAuthNo,String hisRuLabelValue,String remark,String allRuLabelType,String allRuLabelValue,String allIbFlag,String ruLabelTypeDesc,String lotPlnYr,String lotLocCd,String lotSeq,String cntrSpecNo,String lotNo,String cntrLotTpszCd,String level,String id,String name,String usrDefRmk,String iPage,String hCntrNo,String tmpSeq,String tmpDtlSeq,String cntrStsCd,String lseCtrtNo,String crntYdCd,String cnmvDt,String fullFlg,String mftrVndrSeq,String mftrVndrNm,String mftDt,String rfMkrSeq,String rfMkrNm,String rfMdlNm,String cnmvStsCd,String sCntrStsCd,String lstmCd,String sMultiAgmtSeq)	{
		this.ibflag  = ibflag ;
		this.pagerows  = pagerows ;
		this.rstrUsgCdSeq  = rstrUsgCdSeq ;
		this.rstrUsgTpCd  = rstrUsgTpCd ;
		this.rstrUsgLblNm  = rstrUsgLblNm ;
		this.rstrUsgLblDesc  = rstrUsgLblDesc ;
		this.rstrUsgDpSeq  = rstrUsgDpSeq ;
		this.deltFlg  = deltFlg ;
		this.creUsrId  = creUsrId ;
		this.creDt  = creDt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.cntrNo  = cntrNo ;
		this.rstrUsgHisSeq  = rstrUsgHisSeq ;
		this.rstrUsgUpdTpCd  = rstrUsgUpdTpCd ;
		this.cnmvYr  = cnmvYr ;
		this.cnmvIdNo  = cnmvIdNo ;
		this.cnmvSeq  = cnmvSeq ;
		this.cnmvSplitNo  = cnmvSplitNo ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.agmtNo  = agmtNo ;
		this.lessor  = lessor ;
		this.lessorNm  = lessorNm ;
		this.cntrAuthNo  = cntrAuthNo ;
		this.ruLabelType  = ruLabelType ;
		this.ruLabelValue  = ruLabelValue ;
		this.rstrUsgTpLblNm1  = rstrUsgTpLblNm1 ;
		this.rstrUsgTpLblNm2  = rstrUsgTpLblNm2 ;
		this.rstrUsgTpLblNm3  = rstrUsgTpLblNm3 ;
		this.rstrUsgTpLblNm4  = rstrUsgTpLblNm4 ;
		this.rstrUsgTpLblNm5  = rstrUsgTpLblNm5 ;
		this.rstrUsgTpLblNm6  = rstrUsgTpLblNm6 ;
		this.rstrUsgTpLblNm7  = rstrUsgTpLblNm7 ;
		this.rstrUsgTpLblNm8  = rstrUsgTpLblNm8 ;
		this.rstrUsgTpLblNm9  = rstrUsgTpLblNm9 ;
		this.rstrUsgTpLblNm10  = rstrUsgTpLblNm10 ;
		this.rstrUsgTpLblNm11  = rstrUsgTpLblNm11 ;
		this.sCntrNo  = sCntrNo ;
		this.sRuLableType  = sRuLableType ;
		this.sRuLabelType  = sRuLabelType ;
		this.sRuLabelValue  = sRuLabelValue ;
		this.sTpCd  = sTpCd ;
		this.sAgmtNo  = sAgmtNo ;
		this.sAgmtCtyCd  = sAgmtCtyCd ;
		this.sAgmtSeq  = sAgmtSeq ;
		this.sContractNo  = sContractNo ;
		this.sAuthNo  = sAuthNo ;
		this.hisRuLabelValue  = hisRuLabelValue ;
		this.remark  = remark ;
		this.allRuLabelType  = allRuLabelType ;
		this.allRuLabelValue  = allRuLabelValue ;
		this.allIbFlag  = allIbFlag ;
		this.ruLabelTypeDesc  = ruLabelTypeDesc ;
		this.lotPlnYr  = lotPlnYr ;
		this.lotLocCd  = lotLocCd ;
		this.lotSeq  = lotSeq ;
		this.cntrSpecNo  = cntrSpecNo ;
		this.lotNo  = lotNo ;
		this.cntrLotTpszCd  = cntrLotTpszCd ;
		this.level  = level ;
		this.id  = id ;
		this.name  = name ;
		this.usrDefRmk  = usrDefRmk ;
		this.iPage  = iPage ;
		this.hCntrNo  = hCntrNo ;
		this.tmpSeq  = tmpSeq ;
		this.tmpDtlSeq  = tmpDtlSeq ;
		this.cntrStsCd  = cntrStsCd ;
		this.lseCtrtNo  = lseCtrtNo ;
		this.crntYdCd  = crntYdCd ;
		this.cnmvDt  = cnmvDt ;
		this.fullFlg  = fullFlg ;
		this.mftrVndrSeq  = mftrVndrSeq ;
		this.mftrVndrNm  = mftrVndrNm ;
		this.mftDt  = mftDt ;
		this.rfMkrSeq  = rfMkrSeq ;
		this.rfMkrNm  = rfMkrNm ;
		this.rfMdlNm  = rfMdlNm ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.sCntrStsCd  = sCntrStsCd ;
		this.lstmCd  = lstmCd ;
		this.sMultiAgmtSeq  = sMultiAgmtSeq ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rstr_usg_cd_seq", getRstrUsgCdSeq());		
		this.hashColumns.put("rstr_usg_tp_cd", getRstrUsgTpCd());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());		
		this.hashColumns.put("rstr_usg_lbl_desc", getRstrUsgLblDesc());		
		this.hashColumns.put("rstr_usg_dp_seq", getRstrUsgDpSeq());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("rstr_usg_his_seq", getRstrUsgHisSeq());		
		this.hashColumns.put("rstr_usg_upd_tp_cd", getRstrUsgUpdTpCd());		
		this.hashColumns.put("cnmv_yr", getCnmvYr());		
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());		
		this.hashColumns.put("cnmv_seq", getCnmvSeq());		
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("lessor", getLessor());		
		this.hashColumns.put("lessor_nm", getLessorNm());		
		this.hashColumns.put("cntr_auth_no", getCntrAuthNo());		
		this.hashColumns.put("ru_label_type", getRuLabelType());		
		this.hashColumns.put("ru_label_value", getRuLabelValue());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm1", getRstrUsgTpLblNm1());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm2", getRstrUsgTpLblNm2());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm3", getRstrUsgTpLblNm3());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm4", getRstrUsgTpLblNm4());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm5", getRstrUsgTpLblNm5());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm6", getRstrUsgTpLblNm6());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm7", getRstrUsgTpLblNm7());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm8", getRstrUsgTpLblNm8());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm9", getRstrUsgTpLblNm9());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm10", getRstrUsgTpLblNm10());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm11", getRstrUsgTpLblNm11());		
		this.hashColumns.put("s_cntr_no", getSCntrNo());		
		this.hashColumns.put("s_ru_lable_type", getSRuLableType());		
		this.hashColumns.put("s_ru_label_type", getSRuLabelType());		
		this.hashColumns.put("s_ru_label_value", getSRuLabelValue());		
		this.hashColumns.put("s_tp_cd", getSTpCd());		
		this.hashColumns.put("s_agmt_no", getSAgmtNo());		
		this.hashColumns.put("s_agmt_cty_cd", getSAgmtCtyCd());		
		this.hashColumns.put("s_agmt_seq", getSAgmtSeq());		
		this.hashColumns.put("s_contract_no", getSContractNo());		
		this.hashColumns.put("s_auth_no", getSAuthNo());		
		this.hashColumns.put("his_ru_label_value", getHisRuLabelValue());		
		this.hashColumns.put("remark", getRemark());		
		this.hashColumns.put("all_ru_label_type", getAllRuLabelType());		
		this.hashColumns.put("all_ru_label_value", getAllRuLabelValue());		
		this.hashColumns.put("all_ibflag", getAllIbFlag());		
		this.hashColumns.put("ru_label_type_desc", getRuLabelTypeDesc());		
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());		
		this.hashColumns.put("lot_loc_cd", getLotLocCd());		
		this.hashColumns.put("lot_seq", getLotSeq());		
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());		
		this.hashColumns.put("lot_no", getLotNo());		
		this.hashColumns.put("cntr_lot_tpsz_cd", getCntrLotTpszCd());		
		this.hashColumns.put("level", getLevel());		
		this.hashColumns.put("id", getId());		
		this.hashColumns.put("name", getName());		
		this.hashColumns.put("usr_def_rmk", getUsrDefRmk());		
		this.hashColumns.put("i_page", getIPage());		
		this.hashColumns.put("h_cntr_no", getHCntrNo());		
		this.hashColumns.put("tmp_seq", getTmpSeq());		
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("mftr_vndr_seq", getMftrVndrSeq());		
		this.hashColumns.put("mftr_vndr_nm", getMftrVndrNm());		
		this.hashColumns.put("mft_dt", getMftDt());		
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());		
		this.hashColumns.put("rf_mkr_nm", getRfMkrNm());		
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("s_cntr_sts_cd", getSCntrStsCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("s_multi_agmt_seq", getSMultiAgmtSeq());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rstr_usg_cd_seq", "rstrUsgCdSeq");
		this.hashFields.put("rstr_usg_tp_cd", "rstrUsgTpCd");
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("rstr_usg_lbl_desc", "rstrUsgLblDesc");
		this.hashFields.put("rstr_usg_dp_seq", "rstrUsgDpSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rstr_usg_his_seq", "rstrUsgHisSeq");
		this.hashFields.put("rstr_usg_upd_tp_cd", "rstrUsgUpdTpCd");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("cntr_auth_no", "cntrAuthNo");
		this.hashFields.put("ru_label_type", "ruLabelType");
		this.hashFields.put("ru_label_value", "ruLabelValue");
		this.hashFields.put("rstr_usg_tp_lbl_nm1", "rstrUsgTpLblNm1");
		this.hashFields.put("rstr_usg_tp_lbl_nm2", "rstrUsgTpLblNm2");
		this.hashFields.put("rstr_usg_tp_lbl_nm3", "rstrUsgTpLblNm3");
		this.hashFields.put("rstr_usg_tp_lbl_nm4", "rstrUsgTpLblNm4");
		this.hashFields.put("rstr_usg_tp_lbl_nm5", "rstrUsgTpLblNm5");
		this.hashFields.put("rstr_usg_tp_lbl_nm6", "rstrUsgTpLblNm6");
		this.hashFields.put("rstr_usg_tp_lbl_nm7", "rstrUsgTpLblNm7");
		this.hashFields.put("rstr_usg_tp_lbl_nm8", "rstrUsgTpLblNm8");
		this.hashFields.put("rstr_usg_tp_lbl_nm9", "rstrUsgTpLblNm9");
		this.hashFields.put("rstr_usg_tp_lbl_nm10", "rstrUsgTpLblNm10");
		this.hashFields.put("rstr_usg_tp_lbl_nm11", "rstrUsgTpLblNm11");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_ru_lable_type", "sRuLableType");
		this.hashFields.put("s_ru_label_type", "sRuLabelType");
		this.hashFields.put("s_ru_label_value", "sRuLabelValue");
		this.hashFields.put("s_tp_cd", "sTpCd");
		this.hashFields.put("s_agmt_no", "sAgmtNo");
		this.hashFields.put("s_agmt_cty_cd", "sAgmtCtyCd");
		this.hashFields.put("s_agmt_seq", "sAgmtSeq");
		this.hashFields.put("s_contract_no", "sContractNo");
		this.hashFields.put("s_auth_no", "sAuthNo");
		this.hashFields.put("his_ru_label_value", "hisRuLabelValue");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("all_ru_label_type", "allRuLabelType");
		this.hashFields.put("all_ru_label_value", "allRuLabelValue");
		this.hashFields.put("all_ibflag", "allIbFlag");
		this.hashFields.put("ru_label_type_desc", "ruLabelTypeDesc");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("cntr_lot_tpsz_cd", "cntrLotTpszCd");
		this.hashFields.put("level", "level");
		this.hashFields.put("id", "id");
		this.hashFields.put("name", "name");
		this.hashFields.put("usr_def_rmk", "usrDefRmk");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("h_cntr_no", "hCntrNo");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("mftr_vndr_seq", "mftrVndrSeq");
		this.hashFields.put("mftr_vndr_nm", "mftrVndrNm");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("rf_mkr_nm", "rfMkrNm");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("s_cntr_sts_cd", "sCntrStsCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("s_multi_agmt_seq", "sMultiAgmtSeq");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgCdSeq
	*/
	public void	setRstrUsgCdSeq( String	rstrUsgCdSeq ) {
		this.rstrUsgCdSeq =	rstrUsgCdSeq;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgCdSeq
	 */
	 public	 String	getRstrUsgCdSeq() {
		 return	this.rstrUsgCdSeq;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpCd
	*/
	public void	setRstrUsgTpCd( String	rstrUsgTpCd ) {
		this.rstrUsgTpCd =	rstrUsgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpCd
	 */
	 public	 String	getRstrUsgTpCd() {
		 return	this.rstrUsgTpCd;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblNm
	*/
	public void	setRstrUsgLblNm( String	rstrUsgLblNm ) {
		this.rstrUsgLblNm =	rstrUsgLblNm;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblNm
	 */
	 public	 String	getRstrUsgLblNm() {
		 return	this.rstrUsgLblNm;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblDesc
	*/
	public void	setRstrUsgLblDesc( String	rstrUsgLblDesc ) {
		this.rstrUsgLblDesc =	rstrUsgLblDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblDesc
	 */
	 public	 String	getRstrUsgLblDesc() {
		 return	this.rstrUsgLblDesc;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgDpSeq
	*/
	public void	setRstrUsgDpSeq( String	rstrUsgDpSeq ) {
		this.rstrUsgDpSeq =	rstrUsgDpSeq;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgDpSeq
	 */
	 public	 String	getRstrUsgDpSeq() {
		 return	this.rstrUsgDpSeq;
	 } 
 	/**
	* Column Info
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	 String	getDeltFlg() {
		 return	this.deltFlg;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	 String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgHisSeq
	*/
	public void	setRstrUsgHisSeq( String	rstrUsgHisSeq ) {
		this.rstrUsgHisSeq =	rstrUsgHisSeq;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgHisSeq
	 */
	 public	 String	getRstrUsgHisSeq() {
		 return	this.rstrUsgHisSeq;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgUpdTpCd
	*/
	public void	setRstrUsgUpdTpCd( String	rstrUsgUpdTpCd ) {
		this.rstrUsgUpdTpCd =	rstrUsgUpdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgUpdTpCd
	 */
	 public	 String	getRstrUsgUpdTpCd() {
		 return	this.rstrUsgUpdTpCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvYr
	*/
	public void	setCnmvYr( String	cnmvYr ) {
		this.cnmvYr =	cnmvYr;
	}
 
	/**
	 * Column Info
	 * @return	cnmvYr
	 */
	 public	 String	getCnmvYr() {
		 return	this.cnmvYr;
	 } 
 	/**
	* Column Info
	* @param  cnmvIdNo
	*/
	public void	setCnmvIdNo( String	cnmvIdNo ) {
		this.cnmvIdNo =	cnmvIdNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvIdNo
	 */
	 public	 String	getCnmvIdNo() {
		 return	this.cnmvIdNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvSeq
	*/
	public void	setCnmvSeq( String	cnmvSeq ) {
		this.cnmvSeq =	cnmvSeq;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSeq
	 */
	 public	 String	getCnmvSeq() {
		 return	this.cnmvSeq;
	 } 
 	/**
	* Column Info
	* @param  cnmvSplitNo
	*/
	public void	setCnmvSplitNo( String	cnmvSplitNo ) {
		this.cnmvSplitNo =	cnmvSplitNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSplitNo
	 */
	 public	 String	getCnmvSplitNo() {
		 return	this.cnmvSplitNo;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
	 } 
 	/**
	* Column Info
	* @param  lessor
	*/
	public void	setLessor( String	lessor ) {
		this.lessor =	lessor;
	}
 
	/**
	 * Column Info
	 * @return	lessor
	 */
	 public	 String	getLessor() {
		 return	this.lessor;
	 } 
 	/**
	* Column Info
	* @param  lessorNm
	*/
	public void	setLessorNm( String	lessorNm ) {
		this.lessorNm =	lessorNm;
	}
 
	/**
	 * Column Info
	 * @return	lessorNm
	 */
	 public	 String	getLessorNm() {
		 return	this.lessorNm;
	 } 
 	/**
	* Column Info
	* @param  cntrAuthNo
	*/
	public void	setCntrAuthNo( String	cntrAuthNo ) {
		this.cntrAuthNo =	cntrAuthNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrAuthNo
	 */
	 public	 String	getCntrAuthNo() {
		 return	this.cntrAuthNo;
	 } 
 	/**
	* Column Info
	* @param  ruLabelType
	*/
	public void	setRuLabelType( String	ruLabelType ) {
		this.ruLabelType =	ruLabelType;
	}
 
	/**
	 * Column Info
	 * @return	ruLabelType
	 */
	 public	 String	getRuLabelType() {
		 return	this.ruLabelType;
	 } 
 	/**
	* Column Info
	* @param  ruLabelValue
	*/
	public void	setRuLabelValue( String	ruLabelValue ) {
		this.ruLabelValue =	ruLabelValue;
	}
 
	/**
	 * Column Info
	 * @return	ruLabelValue
	 */
	 public	 String	getRuLabelValue() {
		 return	this.ruLabelValue;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm1
	*/
	public void	setRstrUsgTpLblNm1( String	rstrUsgTpLblNm1 ) {
		this.rstrUsgTpLblNm1 =	rstrUsgTpLblNm1;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm1
	 */
	 public	 String	getRstrUsgTpLblNm1() {
		 return	this.rstrUsgTpLblNm1;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm2
	*/
	public void	setRstrUsgTpLblNm2( String	rstrUsgTpLblNm2 ) {
		this.rstrUsgTpLblNm2 =	rstrUsgTpLblNm2;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm2
	 */
	 public	 String	getRstrUsgTpLblNm2() {
		 return	this.rstrUsgTpLblNm2;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm3
	*/
	public void	setRstrUsgTpLblNm3( String	rstrUsgTpLblNm3 ) {
		this.rstrUsgTpLblNm3 =	rstrUsgTpLblNm3;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm3
	 */
	 public	 String	getRstrUsgTpLblNm3() {
		 return	this.rstrUsgTpLblNm3;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm4
	*/
	public void	setRstrUsgTpLblNm4( String	rstrUsgTpLblNm4 ) {
		this.rstrUsgTpLblNm4 =	rstrUsgTpLblNm4;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm4
	 */
	 public	 String	getRstrUsgTpLblNm4() {
		 return	this.rstrUsgTpLblNm4;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm5
	*/
	public void	setRstrUsgTpLblNm5( String	rstrUsgTpLblNm5 ) {
		this.rstrUsgTpLblNm5 =	rstrUsgTpLblNm5;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm5
	 */
	 public	 String	getRstrUsgTpLblNm5() {
		 return	this.rstrUsgTpLblNm5;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm6
	*/
	public void	setRstrUsgTpLblNm6( String	rstrUsgTpLblNm6 ) {
		this.rstrUsgTpLblNm6 =	rstrUsgTpLblNm6;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm6
	 */
	 public	 String	getRstrUsgTpLblNm6() {
		 return	this.rstrUsgTpLblNm6;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm7
	*/
	public void	setRstrUsgTpLblNm7( String	rstrUsgTpLblNm7 ) {
		this.rstrUsgTpLblNm7 =	rstrUsgTpLblNm7;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm7
	 */
	 public	 String	getRstrUsgTpLblNm7() {
		 return	this.rstrUsgTpLblNm7;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm8
	*/
	public void	setRstrUsgTpLblNm8( String	rstrUsgTpLblNm8 ) {
		this.rstrUsgTpLblNm8 =	rstrUsgTpLblNm8;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm8
	 */
	 public	 String	getRstrUsgTpLblNm8() {
		 return	this.rstrUsgTpLblNm8;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm9
	*/
	public void	setRstrUsgTpLblNm9( String	rstrUsgTpLblNm9 ) {
		this.rstrUsgTpLblNm9 =	rstrUsgTpLblNm9;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm9
	 */
	 public	 String	getRstrUsgTpLblNm9() {
		 return	this.rstrUsgTpLblNm9;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm10
	*/
	public void	setRstrUsgTpLblNm10( String	rstrUsgTpLblNm10 ) {
		this.rstrUsgTpLblNm10 =	rstrUsgTpLblNm10;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm10
	 */
	 public	 String	getRstrUsgTpLblNm10() {
		 return	this.rstrUsgTpLblNm10;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm11
	*/
	public void	setRstrUsgTpLblNm11( String	rstrUsgTpLblNm11 ) {
		this.rstrUsgTpLblNm11 =	rstrUsgTpLblNm11;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm11
	 */
	 public	 String	getRstrUsgTpLblNm11() {
		 return	this.rstrUsgTpLblNm11;
	 } 
 	/**
	* Column Info
	* @param  sCntrNo
	*/
	public void	setSCntrNo( String	sCntrNo ) {
		this.sCntrNo =	sCntrNo;
	}
 
	/**
	 * Column Info
	 * @return	sCntrNo
	 */
	 public	 String	getSCntrNo() {
		 return	this.sCntrNo;
	 } 
 	/**
	* Column Info
	* @param  sRuLableType
	*/
	public void	setSRuLableType( String	sRuLableType ) {
		this.sRuLableType =	sRuLableType;
	}
 
	/**
	 * Column Info
	 * @return	sRuLableType
	 */
	 public	 String	getSRuLableType() {
		 return	this.sRuLableType;
	 } 
 	/**
	* Column Info
	* @param  sRuLabelType
	*/
	public void	setSRuLabelType( String	sRuLabelType ) {
		this.sRuLabelType =	sRuLabelType;
	}
 
	/**
	 * Column Info
	 * @return	sRuLabelType
	 */
	 public	 String	getSRuLabelType() {
		 return	this.sRuLabelType;
	 } 
 	/**
	* Column Info
	* @param  sRuLabelValue
	*/
	public void	setSRuLabelValue( String	sRuLabelValue ) {
		this.sRuLabelValue =	sRuLabelValue;
	}
 
	/**
	 * Column Info
	 * @return	sRuLabelValue
	 */
	 public	 String	getSRuLabelValue() {
		 return	this.sRuLabelValue;
	 } 
 	/**
	* Column Info
	* @param  sTpCd
	*/
	public void	setSTpCd( String	sTpCd ) {
		this.sTpCd =	sTpCd;
	}
 
	/**
	 * Column Info
	 * @return	sTpCd
	 */
	 public	 String	getSTpCd() {
		 return	this.sTpCd;
	 } 
 	/**
	* Column Info
	* @param  sAgmtNo
	*/
	public void	setSAgmtNo( String	sAgmtNo ) {
		this.sAgmtNo =	sAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	sAgmtNo
	 */
	 public	 String	getSAgmtNo() {
		 return	this.sAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  sAgmtCtyCd
	*/
	public void	setSAgmtCtyCd( String	sAgmtCtyCd ) {
		this.sAgmtCtyCd =	sAgmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	sAgmtCtyCd
	 */
	 public	 String	getSAgmtCtyCd() {
		 return	this.sAgmtCtyCd;
	 } 
 	/**
	* Column Info
	* @param  sAgmtSeq
	*/
	public void	setSAgmtSeq( String	sAgmtSeq ) {
		this.sAgmtSeq =	sAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	sAgmtSeq
	 */
	 public	 String	getSAgmtSeq() {
		 return	this.sAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  sContractNo
	*/
	public void	setSContractNo( String	sContractNo ) {
		this.sContractNo =	sContractNo;
	}
 
	/**
	 * Column Info
	 * @return	sContractNo
	 */
	 public	 String	getSContractNo() {
		 return	this.sContractNo;
	 } 
 	/**
	* Column Info
	* @param  sAuthNo
	*/
	public void	setSAuthNo( String	sAuthNo ) {
		this.sAuthNo =	sAuthNo;
	}
 
	/**
	 * Column Info
	 * @return	sAuthNo
	 */
	 public	 String	getSAuthNo() {
		 return	this.sAuthNo;
	 } 
 	/**
	* Column Info
	* @param  hisRuLabelValue
	*/
	public void	setHisRuLabelValue( String	hisRuLabelValue ) {
		this.hisRuLabelValue =	hisRuLabelValue;
	}
 
	/**
	 * Column Info
	 * @return	hisRuLabelValue
	 */
	 public	 String	getHisRuLabelValue() {
		 return	this.hisRuLabelValue;
	 } 
 	/**
	* Column Info
	* @param  remark
	*/
	public void	setRemark( String	remark ) {
		this.remark =	remark;
	}
 
	/**
	 * Column Info
	 * @return	remark
	 */
	 public	 String	getRemark() {
		 return	this.remark;
	 } 
 	/**
	* Column Info
	* @param  allRuLabelType
	*/
	public void	setAllRuLabelType( String	allRuLabelType ) {
		this.allRuLabelType =	allRuLabelType;
	}
 
	/**
	 * Column Info
	 * @return	allRuLabelType
	 */
	 public	 String	getAllRuLabelType() {
		 return	this.allRuLabelType;
	 } 
 	/**
	* Column Info
	* @param  allRuLabelValue
	*/
	public void	setAllRuLabelValue( String	allRuLabelValue ) {
		this.allRuLabelValue =	allRuLabelValue;
	}
 
	/**
	 * Column Info
	 * @return	allRuLabelValue
	 */
	 public	 String	getAllRuLabelValue() {
		 return	this.allRuLabelValue;
	 } 
 	/**
	* Column Info
	* @param  allIbFlag
	*/
	public void	setAllIbFlag( String	allIbFlag ) {
		this.allIbFlag =	allIbFlag;
	}
 
	/**
	 * Column Info
	 * @return	allIbFlag
	 */
	 public	 String	getAllIbFlag() {
		 return	this.allIbFlag;
	 } 
 	/**
	* Column Info
	* @param  ruLabelTypeDesc
	*/
	public void	setRuLabelTypeDesc( String	ruLabelTypeDesc ) {
		this.ruLabelTypeDesc =	ruLabelTypeDesc;
	}
 
	/**
	 * Column Info
	 * @return	ruLabelTypeDesc
	 */
	 public	 String	getRuLabelTypeDesc() {
		 return	this.ruLabelTypeDesc;
	 } 
 	/**
	* Column Info
	* @param  lotPlnYr
	*/
	public void	setLotPlnYr( String	lotPlnYr ) {
		this.lotPlnYr =	lotPlnYr;
	}
 
	/**
	 * Column Info
	 * @return	lotPlnYr
	 */
	 public	 String	getLotPlnYr() {
		 return	this.lotPlnYr;
	 } 
 	/**
	* Column Info
	* @param  lotLocCd
	*/
	public void	setLotLocCd( String	lotLocCd ) {
		this.lotLocCd =	lotLocCd;
	}
 
	/**
	 * Column Info
	 * @return	lotLocCd
	 */
	 public	 String	getLotLocCd() {
		 return	this.lotLocCd;
	 } 
 	/**
	* Column Info
	* @param  lotSeq
	*/
	public void	setLotSeq( String	lotSeq ) {
		this.lotSeq =	lotSeq;
	}
 
	/**
	 * Column Info
	 * @return	lotSeq
	 */
	 public	 String	getLotSeq() {
		 return	this.lotSeq;
	 } 
 	/**
	* Column Info
	* @param  cntrSpecNo
	*/
	public void	setCntrSpecNo( String	cntrSpecNo ) {
		this.cntrSpecNo =	cntrSpecNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSpecNo
	 */
	 public	 String	getCntrSpecNo() {
		 return	this.cntrSpecNo;
	 } 
 	/**
	* Column Info
	* @param  lotNo
	*/
	public void	setLotNo( String	lotNo ) {
		this.lotNo =	lotNo;
	}
 
	/**
	 * Column Info
	 * @return	lotNo
	 */
	 public	 String	getLotNo() {
		 return	this.lotNo;
	 } 
 	/**
	* Column Info
	* @param  cntrLotTpszCd
	*/
	public void	setCntrLotTpszCd( String	cntrLotTpszCd ) {
		this.cntrLotTpszCd =	cntrLotTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrLotTpszCd
	 */
	 public	 String	getCntrLotTpszCd() {
		 return	this.cntrLotTpszCd;
	 } 
 	/**
	* Column Info
	* @param  level
	*/
	public void	setLevel( String	level ) {
		this.level =	level;
	}
 
	/**
	 * Column Info
	 * @return	level
	 */
	 public	 String	getLevel() {
		 return	this.level;
	 } 
 	/**
	* Column Info
	* @param  id
	*/
	public void	setId( String	id ) {
		this.id =	id;
	}
 
	/**
	 * Column Info
	 * @return	id
	 */
	 public	 String	getId() {
		 return	this.id;
	 } 
 	/**
	* Column Info
	* @param  name
	*/
	public void	setName( String	name ) {
		this.name =	name;
	}
 
	/**
	 * Column Info
	 * @return	name
	 */
	 public	 String	getName() {
		 return	this.name;
	 } 
 	/**
	* Column Info
	* @param  usrDefRmk
	*/
	public void	setUsrDefRmk( String	usrDefRmk ) {
		this.usrDefRmk =	usrDefRmk;
	}
 
	/**
	 * Column Info
	 * @return	usrDefRmk
	 */
	 public	 String	getUsrDefRmk() {
		 return	this.usrDefRmk;
	 } 
 	/**
	* Column Info
	* @param  iPage
	*/
	public void	setIPage( String	iPage ) {
		this.iPage =	iPage;
	}
 
	/**
	 * Column Info
	 * @return	iPage
	 */
	 public	 String	getIPage() {
		 return	this.iPage;
	 } 
 	/**
	* Column Info
	* @param  hCntrNo
	*/
	public void	setHCntrNo( String	hCntrNo ) {
		this.hCntrNo =	hCntrNo;
	}
 
	/**
	 * Column Info
	 * @return	hCntrNo
	 */
	 public	 String	getHCntrNo() {
		 return	this.hCntrNo;
	 } 
 	/**
	* Column Info
	* @param  tmpSeq
	*/
	public void	setTmpSeq( String	tmpSeq ) {
		this.tmpSeq =	tmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmpSeq
	 */
	 public	 String	getTmpSeq() {
		 return	this.tmpSeq;
	 } 
 	/**
	* Column Info
	* @param  tmpDtlSeq
	*/
	public void	setTmpDtlSeq( String	tmpDtlSeq ) {
		this.tmpDtlSeq =	tmpDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmpDtlSeq
	 */
	 public	 String	getTmpDtlSeq() {
		 return	this.tmpDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  cntrStsCd
	*/
	public void	setCntrStsCd( String	cntrStsCd ) {
		this.cntrStsCd =	cntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsCd
	 */
	 public	 String	getCntrStsCd() {
		 return	this.cntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  lseCtrtNo
	*/
	public void	setLseCtrtNo( String	lseCtrtNo ) {
		this.lseCtrtNo =	lseCtrtNo;
	}
 
	/**
	 * Column Info
	 * @return	lseCtrtNo
	 */
	 public	 String	getLseCtrtNo() {
		 return	this.lseCtrtNo;
	 } 
 	/**
	* Column Info
	* @param  crntYdCd
	*/
	public void	setCrntYdCd( String	crntYdCd ) {
		this.crntYdCd =	crntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	crntYdCd
	 */
	 public	 String	getCrntYdCd() {
		 return	this.crntYdCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvDt
	*/
	public void	setCnmvDt( String	cnmvDt ) {
		this.cnmvDt =	cnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvDt
	 */
	 public	 String	getCnmvDt() {
		 return	this.cnmvDt;
	 } 
 	/**
	* Column Info
	* @param  fullFlg
	*/
	public void	setFullFlg( String	fullFlg ) {
		this.fullFlg =	fullFlg;
	}
 
	/**
	 * Column Info
	 * @return	fullFlg
	 */
	 public	 String	getFullFlg() {
		 return	this.fullFlg;
	 } 
 	/**
	* Column Info
	* @param  mftrVndrSeq
	*/
	public void	setMftrVndrSeq( String	mftrVndrSeq ) {
		this.mftrVndrSeq =	mftrVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	mftrVndrSeq
	 */
	 public	 String	getMftrVndrSeq() {
		 return	this.mftrVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  mftrVndrNm
	*/
	public void	setMftrVndrNm( String	mftrVndrNm ) {
		this.mftrVndrNm =	mftrVndrNm;
	}
 
	/**
	 * Column Info
	 * @return	mftrVndrNm
	 */
	 public	 String	getMftrVndrNm() {
		 return	this.mftrVndrNm;
	 } 
 	/**
	* Column Info
	* @param  mftDt
	*/
	public void	setMftDt( String	mftDt ) {
		this.mftDt =	mftDt;
	}
 
	/**
	 * Column Info
	 * @return	mftDt
	 */
	 public	 String	getMftDt() {
		 return	this.mftDt;
	 } 
 	/**
	* Column Info
	* @param  rfMkrSeq
	*/
	public void	setRfMkrSeq( String	rfMkrSeq ) {
		this.rfMkrSeq =	rfMkrSeq;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrSeq
	 */
	 public	 String	getRfMkrSeq() {
		 return	this.rfMkrSeq;
	 } 
 	/**
	* Column Info
	* @param  rfMkrNm
	*/
	public void	setRfMkrNm( String	rfMkrNm ) {
		this.rfMkrNm =	rfMkrNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrNm
	 */
	 public	 String	getRfMkrNm() {
		 return	this.rfMkrNm;
	 } 
 	/**
	* Column Info
	* @param  rfMdlNm
	*/
	public void	setRfMdlNm( String	rfMdlNm ) {
		this.rfMdlNm =	rfMdlNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMdlNm
	 */
	 public	 String	getRfMdlNm() {
		 return	this.rfMdlNm;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd
	*/
	public void	setCnmvStsCd( String	cnmvStsCd ) {
		this.cnmvStsCd =	cnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd
	 */
	 public	 String	getCnmvStsCd() {
		 return	this.cnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  sCntrStsCd
	*/
	public void	setSCntrStsCd( String	sCntrStsCd ) {
		this.sCntrStsCd =	sCntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	sCntrStsCd
	 */
	 public	 String	getSCntrStsCd() {
		 return	this.sCntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
	 } 
	 /**
	* Column Info
	* @param  lstmCd
	*/
	public void	setSMultiAgmtSeq( String	sMultiAgmtSeq ) {
		this.sMultiAgmtSeq =	sMultiAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getSMultiAgmtSeq() {
		 return	this.sMultiAgmtSeq;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRstrUsgCdSeq(JSPUtil.getParameter(request,	prefix + "rstr_usg_cd_seq", ""));
		setRstrUsgTpCd(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_cd", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setRstrUsgLblDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_desc", ""));
		setRstrUsgDpSeq(JSPUtil.getParameter(request,	prefix + "rstr_usg_dp_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setRstrUsgHisSeq(JSPUtil.getParameter(request,	prefix + "rstr_usg_his_seq", ""));
		setRstrUsgUpdTpCd(JSPUtil.getParameter(request,	prefix + "rstr_usg_upd_tp_cd", ""));
		setCnmvYr(JSPUtil.getParameter(request,	prefix + "cnmv_yr", ""));
		setCnmvIdNo(JSPUtil.getParameter(request,	prefix + "cnmv_id_no", ""));
		setCnmvSeq(JSPUtil.getParameter(request,	prefix + "cnmv_seq", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request,	prefix + "cnmv_split_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setLessor(JSPUtil.getParameter(request,	prefix + "lessor", ""));
		setLessorNm(JSPUtil.getParameter(request,	prefix + "lessor_nm", ""));
		setCntrAuthNo(JSPUtil.getParameter(request,	prefix + "cntr_auth_no", ""));
		setRuLabelType(JSPUtil.getParameter(request,	prefix + "ru_label_type", ""));
		setRuLabelValue(JSPUtil.getParameter(request,	prefix + "ru_label_value", ""));
		setRstrUsgTpLblNm1(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm1", ""));
		setRstrUsgTpLblNm2(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm2", ""));
		setRstrUsgTpLblNm3(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm3", ""));
		setRstrUsgTpLblNm4(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm4", ""));
		setRstrUsgTpLblNm5(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm5", ""));
		setRstrUsgTpLblNm6(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm6", ""));
		setRstrUsgTpLblNm7(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm7", ""));
		setRstrUsgTpLblNm8(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm8", ""));
		setRstrUsgTpLblNm9(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm9", ""));
		setRstrUsgTpLblNm10(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm10", ""));
		setRstrUsgTpLblNm11(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm11", ""));
		setSCntrNo(JSPUtil.getParameter(request,	prefix + "s_cntr_no", ""));
		setSRuLableType(JSPUtil.getParameter(request,	prefix + "s_ru_lable_type", ""));
		setSRuLabelType(JSPUtil.getParameter(request,	prefix + "s_ru_label_type", ""));
		setSRuLabelValue(JSPUtil.getParameter(request,	prefix + "s_ru_label_value", ""));
		setSTpCd(JSPUtil.getParameter(request,	prefix + "s_tp_cd", ""));
		setSAgmtNo(JSPUtil.getParameter(request,	prefix + "s_agmt_no", ""));
		setSAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "s_agmt_cty_cd", ""));
		setSAgmtSeq(JSPUtil.getParameter(request,	prefix + "s_agmt_seq", ""));
		setSContractNo(JSPUtil.getParameter(request,	prefix + "s_contract_no", ""));
		setSAuthNo(JSPUtil.getParameter(request,	prefix + "s_auth_no", ""));
		setHisRuLabelValue(JSPUtil.getParameter(request,	prefix + "his_ru_label_value", ""));
		setRemark(JSPUtil.getParameter(request,	prefix + "remark", ""));
		setAllRuLabelType(JSPUtil.getParameter(request,	prefix + "all_ru_label_type", ""));
		setAllRuLabelValue(JSPUtil.getParameter(request,	prefix + "all_ru_label_value", ""));
		setAllIbFlag(JSPUtil.getParameter(request,	prefix + "all_ibflag", ""));
		setRuLabelTypeDesc(JSPUtil.getParameter(request,	prefix + "ru_label_type_desc", ""));
		setLotPlnYr(JSPUtil.getParameter(request,	prefix + "lot_pln_yr", ""));
		setLotLocCd(JSPUtil.getParameter(request,	prefix + "lot_loc_cd", ""));
		setLotSeq(JSPUtil.getParameter(request,	prefix + "lot_seq", ""));
		setCntrSpecNo(JSPUtil.getParameter(request,	prefix + "cntr_spec_no", ""));
		setLotNo(JSPUtil.getParameter(request,	prefix + "lot_no", ""));
		setCntrLotTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_lot_tpsz_cd", ""));
		setLevel(JSPUtil.getParameter(request,	prefix + "level", ""));
		setId(JSPUtil.getParameter(request,	prefix + "id", ""));
		setName(JSPUtil.getParameter(request,	prefix + "name", ""));
		setUsrDefRmk(JSPUtil.getParameter(request,	prefix + "usr_def_rmk", ""));
		setIPage(JSPUtil.getParameter(request,	prefix + "i_page", ""));
		setHCntrNo(JSPUtil.getParameter(request,	prefix + "h_cntr_no", ""));
		setTmpSeq(JSPUtil.getParameter(request,	prefix + "tmp_seq", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request,	prefix + "tmp_dtl_seq", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setLseCtrtNo(JSPUtil.getParameter(request,	prefix + "lse_ctrt_no", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setMftrVndrSeq(JSPUtil.getParameter(request,	prefix + "mftr_vndr_seq", ""));
		setMftrVndrNm(JSPUtil.getParameter(request,	prefix + "mftr_vndr_nm", ""));
		setMftDt(JSPUtil.getParameter(request,	prefix + "mft_dt", ""));
		setRfMkrSeq(JSPUtil.getParameter(request,	prefix + "rf_mkr_seq", ""));
		setRfMkrNm(JSPUtil.getParameter(request,	prefix + "rf_mkr_nm", ""));
		setRfMdlNm(JSPUtil.getParameter(request,	prefix + "rf_mdl_nm", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setSCntrStsCd(JSPUtil.getParameter(request,	prefix + "s_cntr_sts_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setSMultiAgmtSeq(JSPUtil.getParameter(request,	prefix + "s_multi_agmt_seq", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RuLabelListVO[]
	 */
	public RuLabelListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RuLabelListVO[]
	 */
	public RuLabelListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RuLabelListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rstrUsgCdSeq =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_cd_seq".trim(),	length));
				String[] rstrUsgTpCd =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_cd".trim(),	length));
				String[] rstrUsgLblNm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] rstrUsgLblDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));
				String[] rstrUsgDpSeq =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_dp_seq".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] rstrUsgHisSeq =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_his_seq".trim(),	length));
				String[] rstrUsgUpdTpCd =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_upd_tp_cd".trim(),	length));
				String[] cnmvYr =	(JSPUtil.getParameter(request, prefix +	"cnmv_yr".trim(),	length));
				String[] cnmvIdNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_id_no".trim(),	length));
				String[] cnmvSeq =	(JSPUtil.getParameter(request, prefix +	"cnmv_seq".trim(),	length));
				String[] cnmvSplitNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_split_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] lessor =	(JSPUtil.getParameter(request, prefix +	"lessor".trim(),	length));
				String[] lessorNm =	(JSPUtil.getParameter(request, prefix +	"lessor_nm".trim(),	length));
				String[] cntrAuthNo =	(JSPUtil.getParameter(request, prefix +	"cntr_auth_no".trim(),	length));
				String[] ruLabelType =	(JSPUtil.getParameter(request, prefix +	"ru_label_type".trim(),	length));
				String[] ruLabelValue =	(JSPUtil.getParameter(request, prefix +	"ru_label_value".trim(),	length));
				String[] rstrUsgTpLblNm1 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm1".trim(),	length));
				String[] rstrUsgTpLblNm2 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm2".trim(),	length));
				String[] rstrUsgTpLblNm3 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm3".trim(),	length));
				String[] rstrUsgTpLblNm4 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm4".trim(),	length));
				String[] rstrUsgTpLblNm5 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm5".trim(),	length));
				String[] rstrUsgTpLblNm6 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm6".trim(),	length));
				String[] rstrUsgTpLblNm7 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm7".trim(),	length));
				String[] rstrUsgTpLblNm8 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm8".trim(),	length));
				String[] rstrUsgTpLblNm9 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm9".trim(),	length));
				String[] rstrUsgTpLblNm10 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm10".trim(),	length));
				String[] rstrUsgTpLblNm11 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm11".trim(),	length));
				String[] sCntrNo =	(JSPUtil.getParameter(request, prefix +	"s_cntr_no".trim(),	length));
				String[] sRuLableType =	(JSPUtil.getParameter(request, prefix +	"s_ru_lable_type".trim(),	length));
				String[] sRuLabelType =	(JSPUtil.getParameter(request, prefix +	"s_ru_label_type".trim(),	length));
				String[] sRuLabelValue =	(JSPUtil.getParameter(request, prefix +	"s_ru_label_value".trim(),	length));
				String[] sTpCd =	(JSPUtil.getParameter(request, prefix +	"s_tp_cd".trim(),	length));
				String[] sAgmtNo =	(JSPUtil.getParameter(request, prefix +	"s_agmt_no".trim(),	length));
				String[] sAgmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"s_agmt_cty_cd".trim(),	length));
				String[] sAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"s_agmt_seq".trim(),	length));
				String[] sContractNo =	(JSPUtil.getParameter(request, prefix +	"s_contract_no".trim(),	length));
				String[] sAuthNo =	(JSPUtil.getParameter(request, prefix +	"s_auth_no".trim(),	length));
				String[] hisRuLabelValue =	(JSPUtil.getParameter(request, prefix +	"his_ru_label_value".trim(),	length));
				String[] remark =	(JSPUtil.getParameter(request, prefix +	"remark".trim(),	length));
				String[] allRuLabelType =	(JSPUtil.getParameter(request, prefix +	"all_ru_label_type".trim(),	length));
				String[] allRuLabelValue =	(JSPUtil.getParameter(request, prefix +	"all_ru_label_value".trim(),	length));
				String[] allIbFlag =	(JSPUtil.getParameter(request, prefix +	"all_ibflag".trim(),	length));
				String[] ruLabelTypeDesc =	(JSPUtil.getParameter(request, prefix +	"ru_label_type_desc".trim(),	length));
				String[] lotPlnYr =	(JSPUtil.getParameter(request, prefix +	"lot_pln_yr".trim(),	length));
				String[] lotLocCd =	(JSPUtil.getParameter(request, prefix +	"lot_loc_cd".trim(),	length));
				String[] lotSeq =	(JSPUtil.getParameter(request, prefix +	"lot_seq".trim(),	length));
				String[] cntrSpecNo =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_no".trim(),	length));
				String[] lotNo =	(JSPUtil.getParameter(request, prefix +	"lot_no".trim(),	length));
				String[] cntrLotTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_lot_tpsz_cd".trim(),	length));
				String[] level =	(JSPUtil.getParameter(request, prefix +	"level".trim(),	length));
				String[] id =	(JSPUtil.getParameter(request, prefix +	"id".trim(),	length));
				String[] name =	(JSPUtil.getParameter(request, prefix +	"name".trim(),	length));
				String[] usrDefRmk =	(JSPUtil.getParameter(request, prefix +	"usr_def_rmk".trim(),	length));
				String[] iPage =	(JSPUtil.getParameter(request, prefix +	"i_page".trim(),	length));
				String[] hCntrNo =	(JSPUtil.getParameter(request, prefix +	"h_cntr_no".trim(),	length));
				String[] tmpSeq =	(JSPUtil.getParameter(request, prefix +	"tmp_seq".trim(),	length));
				String[] tmpDtlSeq =	(JSPUtil.getParameter(request, prefix +	"tmp_dtl_seq".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] lseCtrtNo =	(JSPUtil.getParameter(request, prefix +	"lse_ctrt_no".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] mftrVndrSeq =	(JSPUtil.getParameter(request, prefix +	"mftr_vndr_seq".trim(),	length));
				String[] mftrVndrNm =	(JSPUtil.getParameter(request, prefix +	"mftr_vndr_nm".trim(),	length));
				String[] mftDt =	(JSPUtil.getParameter(request, prefix +	"mft_dt".trim(),	length));
				String[] rfMkrSeq =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_seq".trim(),	length));
				String[] rfMkrNm =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_nm".trim(),	length));
				String[] rfMdlNm =	(JSPUtil.getParameter(request, prefix +	"rf_mdl_nm".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] sCntrStsCd =	(JSPUtil.getParameter(request, prefix +	"s_cntr_sts_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] sMultiAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"s_multi_agmt_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	RuLabelListVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rstrUsgCdSeq[i] !=	null)
						model.setRstrUsgCdSeq( rstrUsgCdSeq[i]);
						if ( rstrUsgTpCd[i] !=	null)
						model.setRstrUsgTpCd( rstrUsgTpCd[i]);
						if ( rstrUsgLblNm[i] !=	null)
						model.setRstrUsgLblNm( rstrUsgLblNm[i]);
						if ( rstrUsgLblDesc[i] !=	null)
						model.setRstrUsgLblDesc( rstrUsgLblDesc[i]);
						if ( rstrUsgDpSeq[i] !=	null)
						model.setRstrUsgDpSeq( rstrUsgDpSeq[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( rstrUsgHisSeq[i] !=	null)
						model.setRstrUsgHisSeq( rstrUsgHisSeq[i]);
						if ( rstrUsgUpdTpCd[i] !=	null)
						model.setRstrUsgUpdTpCd( rstrUsgUpdTpCd[i]);
						if ( cnmvYr[i] !=	null)
						model.setCnmvYr( cnmvYr[i]);
						if ( cnmvIdNo[i] !=	null)
						model.setCnmvIdNo( cnmvIdNo[i]);
						if ( cnmvSeq[i] !=	null)
						model.setCnmvSeq( cnmvSeq[i]);
						if ( cnmvSplitNo[i] !=	null)
						model.setCnmvSplitNo( cnmvSplitNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( lessor[i] !=	null)
						model.setLessor( lessor[i]);
						if ( lessorNm[i] !=	null)
						model.setLessorNm( lessorNm[i]);
						if ( cntrAuthNo[i] !=	null)
						model.setCntrAuthNo( cntrAuthNo[i]);
						if ( ruLabelType[i] !=	null)
						model.setRuLabelType( ruLabelType[i]);
						if ( ruLabelValue[i] !=	null)
						model.setRuLabelValue( ruLabelValue[i]);
						if ( rstrUsgTpLblNm1[i] !=	null)
						model.setRstrUsgTpLblNm1( rstrUsgTpLblNm1[i]);
						if ( rstrUsgTpLblNm2[i] !=	null)
						model.setRstrUsgTpLblNm2( rstrUsgTpLblNm2[i]);
						if ( rstrUsgTpLblNm3[i] !=	null)
						model.setRstrUsgTpLblNm3( rstrUsgTpLblNm3[i]);
						if ( rstrUsgTpLblNm4[i] !=	null)
						model.setRstrUsgTpLblNm4( rstrUsgTpLblNm4[i]);
						if ( rstrUsgTpLblNm5[i] !=	null)
						model.setRstrUsgTpLblNm5( rstrUsgTpLblNm5[i]);
						if ( rstrUsgTpLblNm6[i] !=	null)
						model.setRstrUsgTpLblNm6( rstrUsgTpLblNm6[i]);
						if ( rstrUsgTpLblNm7[i] !=	null)
						model.setRstrUsgTpLblNm7( rstrUsgTpLblNm7[i]);
						if ( rstrUsgTpLblNm8[i] !=	null)
						model.setRstrUsgTpLblNm8( rstrUsgTpLblNm8[i]);
						if ( rstrUsgTpLblNm9[i] !=	null)
						model.setRstrUsgTpLblNm9( rstrUsgTpLblNm9[i]);
						if ( rstrUsgTpLblNm10[i] !=	null)
						model.setRstrUsgTpLblNm10( rstrUsgTpLblNm10[i]);
						if ( rstrUsgTpLblNm11[i] !=	null)
						model.setRstrUsgTpLblNm11( rstrUsgTpLblNm11[i]);
						if ( sCntrNo[i] !=	null)
						model.setSCntrNo( sCntrNo[i]);
						if ( sRuLableType[i] !=	null)
						model.setSRuLableType( sRuLableType[i]);
						if ( sRuLabelType[i] !=	null)
						model.setSRuLabelType( sRuLabelType[i]);
						if ( sRuLabelValue[i] !=	null)
						model.setSRuLabelValue( sRuLabelValue[i]);
						if ( sTpCd[i] !=	null)
						model.setSTpCd( sTpCd[i]);
						if ( sAgmtNo[i] !=	null)
						model.setSAgmtNo( sAgmtNo[i]);
						if ( sAgmtCtyCd[i] !=	null)
						model.setSAgmtCtyCd( sAgmtCtyCd[i]);
						if ( sAgmtSeq[i] !=	null)
						model.setSAgmtSeq( sAgmtSeq[i]);
						if ( sContractNo[i] !=	null)
						model.setSContractNo( sContractNo[i]);
						if ( sAuthNo[i] !=	null)
						model.setSAuthNo( sAuthNo[i]);
						if ( hisRuLabelValue[i] !=	null)
						model.setHisRuLabelValue( hisRuLabelValue[i]);
						if ( remark[i] !=	null)
						model.setRemark( remark[i]);
						if ( allRuLabelType[i] !=	null)
						model.setAllRuLabelType( allRuLabelType[i]);
						if ( allRuLabelValue[i] !=	null)
						model.setAllRuLabelValue( allRuLabelValue[i]);
						if ( allIbFlag[i] !=	null)
						model.setAllIbFlag( allIbFlag[i]);
						if ( ruLabelTypeDesc[i] !=	null)
						model.setRuLabelTypeDesc( ruLabelTypeDesc[i]);
						if ( lotPlnYr[i] !=	null)
						model.setLotPlnYr( lotPlnYr[i]);
						if ( lotLocCd[i] !=	null)
						model.setLotLocCd( lotLocCd[i]);
						if ( lotSeq[i] !=	null)
						model.setLotSeq( lotSeq[i]);
						if ( cntrSpecNo[i] !=	null)
						model.setCntrSpecNo( cntrSpecNo[i]);
						if ( lotNo[i] !=	null)
						model.setLotNo( lotNo[i]);
						if ( cntrLotTpszCd[i] !=	null)
						model.setCntrLotTpszCd( cntrLotTpszCd[i]);
						if ( level[i] !=	null)
						model.setLevel( level[i]);
						if ( id[i] !=	null)
						model.setId( id[i]);
						if ( name[i] !=	null)
						model.setName( name[i]);
						if ( usrDefRmk[i] !=	null)
						model.setUsrDefRmk( usrDefRmk[i]);
						if ( iPage[i] !=	null)
						model.setIPage( iPage[i]);
						if ( hCntrNo[i] !=	null)
						model.setHCntrNo( hCntrNo[i]);
						if ( tmpSeq[i] !=	null)
						model.setTmpSeq( tmpSeq[i]);
						if ( tmpDtlSeq[i] !=	null)
						model.setTmpDtlSeq( tmpDtlSeq[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( lseCtrtNo[i] !=	null)
						model.setLseCtrtNo( lseCtrtNo[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( mftrVndrSeq[i] !=	null)
						model.setMftrVndrSeq( mftrVndrSeq[i]);
						if ( mftrVndrNm[i] !=	null)
						model.setMftrVndrNm( mftrVndrNm[i]);
						if ( mftDt[i] !=	null)
						model.setMftDt( mftDt[i]);
						if ( rfMkrSeq[i] !=	null)
						model.setRfMkrSeq( rfMkrSeq[i]);
						if ( rfMkrNm[i] !=	null)
						model.setRfMkrNm( rfMkrNm[i]);
						if ( rfMdlNm[i] !=	null)
						model.setRfMdlNm( rfMdlNm[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( sCntrStsCd[i] !=	null)
						model.setSCntrStsCd( sCntrStsCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( sMultiAgmtSeq[i] !=	null)
						model.setSMultiAgmtSeq( sMultiAgmtSeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getRuLabelListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RuLabelListVO[]
	 */
	public RuLabelListVO[]	 getRuLabelListVOs(){
		RuLabelListVO[] vos = (RuLabelListVO[])models.toArray(new	RuLabelListVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgCdSeq =	this.rstrUsgCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpCd =	this.rstrUsgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm =	this.rstrUsgLblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblDesc =	this.rstrUsgLblDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgDpSeq =	this.rstrUsgDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgHisSeq =	this.rstrUsgHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgUpdTpCd =	this.rstrUsgUpdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr =	this.cnmvYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo =	this.cnmvIdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq =	this.cnmvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo =	this.cnmvSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor =	this.lessor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm =	this.lessorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAuthNo =	this.cntrAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruLabelType =	this.ruLabelType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruLabelValue =	this.ruLabelValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm1 =	this.rstrUsgTpLblNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm2 =	this.rstrUsgTpLblNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm3 =	this.rstrUsgTpLblNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm4 =	this.rstrUsgTpLblNm4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm5 =	this.rstrUsgTpLblNm5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm6 =	this.rstrUsgTpLblNm6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm7 =	this.rstrUsgTpLblNm7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm8 =	this.rstrUsgTpLblNm8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm9 =	this.rstrUsgTpLblNm9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm10 =	this.rstrUsgTpLblNm10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm11 =	this.rstrUsgTpLblNm11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo =	this.sCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRuLableType =	this.sRuLableType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRuLabelType =	this.sRuLabelType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRuLabelValue =	this.sRuLabelValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTpCd =	this.sTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAgmtNo =	this.sAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAgmtCtyCd =	this.sAgmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAgmtSeq =	this.sAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sContractNo =	this.sContractNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAuthNo =	this.sAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisRuLabelValue =	this.hisRuLabelValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark =	this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allRuLabelType =	this.allRuLabelType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allRuLabelValue =	this.allRuLabelValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allIbFlag =	this.allIbFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruLabelTypeDesc =	this.ruLabelTypeDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr =	this.lotPlnYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd =	this.lotLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq =	this.lotSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo =	this.cntrSpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo =	this.lotNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLotTpszCd =	this.cntrLotTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level =	this.level.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.id =	this.id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name =	this.name.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrDefRmk =	this.usrDefRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage =	this.iPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCntrNo =	this.hCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq =	this.tmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq =	this.tmpDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo =	this.lseCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrSeq =	this.mftrVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrNm =	this.mftrVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt =	this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq =	this.rfMkrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrNm =	this.rfMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm =	this.rfMdlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrStsCd =	this.sCntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMultiAgmtSeq =	this.sMultiAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}