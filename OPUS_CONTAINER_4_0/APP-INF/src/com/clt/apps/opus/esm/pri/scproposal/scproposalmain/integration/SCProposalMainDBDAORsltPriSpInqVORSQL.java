/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPriSpInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.05.07 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPriSpInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal & Amendment Inquiry search
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPriSpInqVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scre_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scre_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ssc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seff_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seff_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPriSpInqVORSQL").append("\n"); 
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
		query.append("SELECT HDR.SC_NO" ).append("\n"); 
		query.append("	  ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("	  ,MN.PROP_NO" ).append("\n"); 
		query.append("	  ,PTY.CTRT_PTY_NM" ).append("\n"); 
		query.append("	  ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("	  ,MN.PROP_SREP_CD SREP_NM" ).append("\n"); 
		query.append("      ,CASE MN.PROP_STS_CD " ).append("\n"); 
		query.append("       	   WHEN 'A' THEN MQC.FNL_MQC_QTY" ).append("\n"); 
		query.append("           WHEN 'F' THEN MQC.FNL_MQC_QTY" ).append("\n"); 
		query.append("       ELSE                        " ).append("\n"); 
		query.append("           MQC.PROP_MQC_QTY" ).append("\n"); 
		query.append("       END PROP_MQC_QTY " ).append("\n"); 
		query.append("	  ,MQC.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("	  ,UNIT.INTG_CD_VAL_DP_DESC UNIT_NM" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(DUR.CTRT_EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(DUR.CTRT_EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(MN.FILE_DT,'YYYY-MM-DD') FILE_DT" ).append("\n"); 
		query.append("	  ,MN.PROP_STS_CD" ).append("\n"); 
		query.append("	  ,STS.INTG_CD_VAL_DP_DESC PROP_STS_NM" ).append("\n"); 
		query.append("FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("	,PRI_SP_HDR HDR" ).append("\n"); 
		query.append("	,PRI_SP_DUR DUR" ).append("\n"); 
		query.append("	,PRI_SP_MQC MQC" ).append("\n"); 
		query.append("	,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("	,PRI_SP_CTRT_CUST_TP CUST_TP" ).append("\n"); 
		query.append("	,COM_INTG_CD_DTL STS" ).append("\n"); 
		query.append("	,COM_INTG_CD_DTL UNIT" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    MN.PROP_NO = HDR.PROP_NO " ).append("\n"); 
		query.append("AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("AND MN.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.PROP_NO = MQC.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = MQC.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("AND PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND MN.PROP_NO = CUST_TP.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = CUST_TP.AMDT_SEQ" ).append("\n"); 
		query.append("AND PTY.PRC_CTRT_PTY_TP_CD = CUST_TP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD = STS.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND STS.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("AND MQC.CNTR_LOD_UT_CD = UNIT.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND UNIT.INTG_CD_ID = 'CD00897'" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(B XPKPRI_SP_MN) */ AMDT_SEQ " ).append("\n"); 
		query.append("					FROM PRI_SP_MN B " ).append("\n"); 
		query.append("					WHERE MN.PROP_NO = PROP_NO " ).append("\n"); 
		query.append("					AND ROWNUM = 1)" ).append("\n"); 
		query.append("#if (${ssc_no} != '')" ).append("\n"); 
		query.append("AND HDR.SC_NO LIKE @[ssc_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_no} != '')" ).append("\n"); 
		query.append("AND HDR.PROP_NO = @[sprop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_ofc_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_OFC_CD = @[sprop_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_srep_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_SREP_CD = @[sprop_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_APRO_OFC_CD = @[sprop_apro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_sts_cd} != '')" ).append("\n"); 
		query.append("AND MN.PROP_STS_CD = @[sprop_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scust_cnt_cd} != '' && ${scust_seq} != '')" ).append("\n"); 
		query.append("AND PTY.CUST_CNT_CD = @[scust_cnt_cd]" ).append("\n"); 
		query.append("AND PTY.CUST_SEQ = @[scust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scre_dt1} != '' && ${scre_dt2} != '')" ).append("\n"); 
		query.append("AND MN.CRE_DT BETWEEN @[scre_dt1] AND @[scre_dt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${seff_dt1} != '' && ${seff_dt2} != '')" ).append("\n"); 
		query.append("AND TO_DATE(@[seff_dt1],'yyyy-MM-dd') <= DUR.CTRT_EXP_DT AND TO_DATE(@[seff_dt2], 'yyyy-MM-DD') >= DUR.CTRT_EFF_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprop_mqc_qty} != '' && ${smqc_sign_cd} !='')" ).append("\n"); 
		query.append("AND MQC.PROP_MQC_QTY ${smqc_sign_cd} TO_NUMBER(REPLACE(@[sprop_mqc_qty],','))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ssc_type_cd} == 'R')" ).append("\n"); 
		query.append("AND MN.RF_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${ssc_type_cd} == 'G')" ).append("\n"); 
		query.append("AND MN.GAMT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("AND CUST_TP.PRC_CTRT_CUST_TP_CD = @[sprc_ctrt_cust_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY HDR.SC_NO,MN.PROP_NO,MN.AMDT_SEQ" ).append("\n"); 

	}
}