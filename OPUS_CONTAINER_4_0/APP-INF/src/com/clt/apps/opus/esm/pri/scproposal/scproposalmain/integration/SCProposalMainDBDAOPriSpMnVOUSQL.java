/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpMnVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpMnVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI SP MN 수정
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpMnVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prxy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gamt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("real_cust_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("real_cust_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_dur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("real_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("real_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("real_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blpl_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpMnVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("UPDATE PRI_SP_MN SET" ).append("\n"); 
		query.append("     EFF_DT               = NVL(TO_DATE(@[eff_dt],'YYYY-MM-DD'), EFF_DT)" ).append("\n"); 
		query.append("#if (${init_cancel} == 'Y')" ).append("\n"); 
		query.append("	,EXP_DT				  = ( SELECT CTRT_EXP_DT FROM PRI_SP_DUR WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,EXP_DT				  = NVL(TO_DATE(@[exp_dt],'YYYY-MM-DD'), EXP_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,PROP_SREP_CD         = NVL(@[prop_srep_cd],PROP_SREP_CD)                  " ).append("\n"); 
		query.append("    ,PROP_OFC_CD          = NVL(@[prop_ofc_cd],PROP_OFC_CD)                  " ).append("\n"); 
		query.append("    ,PROP_APRO_OFC_CD     = NVL(@[prop_apro_ofc_cd],PROP_APRO_OFC_CD)        " ).append("\n"); 
		query.append("    ,FILE_DT              = NVL(TO_DATE(@[file_dt],'YYYY-MM-DD'),FILE_DT)        " ).append("\n"); 
		query.append("    ,PROP_STS_CD          = NVL(@[prop_sts_cd],PROP_STS_CD)" ).append("\n"); 
		query.append("	,REAL_CUST_CNT_CD     = DECODE(@[real_cust_cnt_cd], 'XX','',NVL(@[real_cust_cnt_cd],REAL_CUST_CNT_CD))" ).append("\n"); 
		query.append("	,REAL_CUST_SEQ        = DECODE(@[real_cust_cnt_cd], 'XX','',NVL(@[real_cust_seq],REAL_CUST_SEQ) )" ).append("\n"); 
		query.append("    ,REAL_CUST_TP_CD      = DECODE(@[real_cust_cnt_cd], 'XX','',NVL(@[real_cust_tp_cd],REAL_CUST_TP_CD))           " ).append("\n"); 
		query.append("    ,REAL_CUST_SREP_CD    = DECODE(@[real_cust_cnt_cd], 'XX','',NVL(@[real_cust_srep_cd],REAL_CUST_SREP_CD))       " ).append("\n"); 
		query.append("    ,REAL_CUST_SLS_OFC_CD = DECODE(@[real_cust_cnt_cd], 'XX','',NVL(@[real_cust_sls_ofc_cd],REAL_CUST_SLS_OFC_CD)) " ).append("\n"); 
		query.append("    ,RF_FLG               = NVL(@[rf_flg],RF_FLG)                              " ).append("\n"); 
		query.append("    ,GAMT_FLG             = NVL(@[gamt_flg],GAMT_FLG)                          " ).append("\n"); 
		query.append("	,RESPB_SREP_CD     	  = NVL(@[respb_srep_cd], RESPB_SREP_CD)                 " ).append("\n"); 
		query.append("	,RESPB_SLS_OFC_CD	  = NVL(@[respb_sls_ofc_cd], RESPB_SLS_OFC_CD)               " ).append("\n"); 
		query.append("    ,UPD_USR_ID           = @[upd_usr_id]                                      " ).append("\n"); 
		query.append("    ,UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("	,BLPL_HDR_SEQ		  = DECODE(@[blpl_hdr_seq], 'XX','',NVL(@[blpl_hdr_seq],BLPL_HDR_SEQ)) " ).append("\n"); 
		query.append("    ,PRXY_FLG             = NVL(@[prxy_flg],PRXY_FLG)" ).append("\n"); 
		query.append("    ,CTRT_DUR_TP_CD       = NVL(@[ctrt_dur_tp_cd],CTRT_DUR_TP_CD)" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 

	}
}