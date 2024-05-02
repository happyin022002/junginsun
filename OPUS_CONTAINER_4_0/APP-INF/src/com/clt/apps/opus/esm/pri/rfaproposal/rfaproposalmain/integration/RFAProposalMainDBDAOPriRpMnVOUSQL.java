/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpMnVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.05.02 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpMnVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI RP MN 수정
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpMnVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_dur_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_lod_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_ctrt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_mvc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpMnVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_MN SET " ).append("\n"); 
		query.append("     EFF_DT               = NVL(TO_DATE(@[eff_dt],'YYYY-MM-DD'), EFF_DT)" ).append("\n"); 
		query.append("#if (${init_cancel} == 'Y')" ).append("\n"); 
		query.append("	,EXP_DT				  = ( SELECT CTRT_EXP_DT FROM PRI_RP_DUR WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,EXP_DT				  = NVL(TO_DATE(@[exp_dt],'YYYY-MM-DD'), EXP_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,PROP_SREP_CD         = NVL(@[prop_srep_cd],PROP_SREP_CD)" ).append("\n"); 
		query.append("	,CTRT_CUST_CNT_CD     = NVL(@[ctrt_cust_cnt_cd],CTRT_CUST_CNT_CD)" ).append("\n"); 
		query.append("	,CTRT_CUST_SEQ 		  = NVL(@[ctrt_cust_seq],CTRT_CUST_SEQ )" ).append("\n"); 
		query.append("	,PRC_CTRT_CUST_TP_CD  = NVL(@[prc_ctrt_cust_tp_cd],PRC_CTRT_CUST_TP_CD)" ).append("\n"); 
		query.append("    ,PROP_OFC_CD          = NVL(@[prop_ofc_cd],PROP_OFC_CD)                  " ).append("\n"); 
		query.append("    ,PROP_APRO_OFC_CD     = DECODE(@[prop_apro_ofc_cd],'',PROP_APRO_OFC_CD,'A','',@[prop_apro_ofc_cd])" ).append("\n"); 
		query.append("    ,PROP_STS_CD          = NVL(@[prop_sts_cd],PROP_STS_CD) " ).append("\n"); 
		query.append("	,RESPB_SREP_CD     	  = NVL(@[respb_srep_cd], RESPB_SREP_CD)   " ).append("\n"); 
		query.append("	,RESPB_SLS_OFC_CD	  = NVL(@[respb_sls_ofc_cd], RESPB_SLS_OFC_CD)  " ).append("\n"); 
		query.append("    ,UPD_USR_ID           = @[upd_usr_id] " ).append("\n"); 
		query.append("    ,UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("	,TGT_MVC_QTY     	  = NVL(@[tgt_mvc_qty], TGT_MVC_QTY) " ).append("\n"); 
		query.append("	,CNTR_LOD_UT_CD       = NVL(@[cntr_lod_ut_cd], CNTR_LOD_UT_CD) " ).append("\n"); 
		query.append("    ,TRF_CTRT_FLG         = DECODE(@[trf_ctrt_flg], null, TRF_CTRT_FLG, @[trf_ctrt_flg])" ).append("\n"); 
		query.append("    ,CTRT_DUR_TP_CD       = NVL(@[ctrt_dur_tp_cd], CTRT_DUR_TP_CD) " ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}