/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOaddAutoAuditHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.04.05 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOaddAutoAuditHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit History 저장
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOaddAutoAuditHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOaddAutoAuditHisCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_MNR_CFM_INV_HIS " ).append("\n"); 
		query.append("( INV_NO" ).append("\n"); 
		query.append(" ,VNDR_SEQ" ).append("\n"); 
		query.append(" ,EQ_KND_CD" ).append("\n"); 
		query.append(" ,AUD_HIS_SEQ" ).append("\n"); 
		query.append(" ,EXPN_AUD_STS_CD" ).append("\n"); 
		query.append(" ,EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append(" ,EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append(" ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append(" ,EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append(" ,RHQ_CD" ).append("\n"); 
		query.append(" ,INV_OFC_CD" ).append("\n"); 
		query.append(" ,INV_CFM_DT" ).append("\n"); 
		query.append(" ,AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append(" ,CURR_CD" ).append("\n"); 
		query.append(" ,WO_AMT" ).append("\n"); 
		query.append(" ,INV_AMT" ).append("\n"); 
		query.append(" ,CURR_CNG_FLG" ).append("\n"); 
		query.append(" ,INV_DIFF_AMT" ).append("\n"); 
		query.append(" ,INV_DIFF_RTO" ).append("\n"); 
		query.append(" ,CRE_OFC_CD" ).append("\n"); 
		query.append(" ,LOCL_CRE_DT" ).append("\n"); 
		query.append(" ,INV_CHG_AMT" ).append("\n"); 
		query.append(" ,WO_VRFY_FLG" ).append("\n"); 
		query.append(" ,ESTM_VRFY_FLG" ).append("\n"); 
		query.append(" ,ESTM_VRFY_DESC" ).append("\n"); 
		query.append(" ,WO_VRFY_DESC" ).append("\n"); 
		query.append(" ,INV_RGST_NO" ).append("\n"); 
		query.append(" ,EAC_NO_CTNT" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append(" ,AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append(" ,INV_CURR_CD" ).append("\n"); 
		query.append(" ,EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append(" ,MLT_WO_CURR_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.INV_NO" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(AUD_HIS_SEQ),0) + 1 " ).append("\n"); 
		query.append("          FROM EAS_MNR_CFM_INV_HIS C" ).append("\n"); 
		query.append("         WHERE C.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("           AND C.EQ_KND_CD = A.EQ_KND_CD) AS AUD_HIS_SEQ" ).append("\n"); 
		query.append("      ,A.EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("      ,A.EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("      ,A.EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("      ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,A.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("      ,A.RHQ_CD" ).append("\n"); 
		query.append("      ,A.INV_OFC_CD" ).append("\n"); 
		query.append("      ,A.INV_CFM_DT" ).append("\n"); 
		query.append("      ,A.AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.WO_AMT" ).append("\n"); 
		query.append("      ,A.INV_AMT" ).append("\n"); 
		query.append("      ,A.CURR_CNG_FLG" ).append("\n"); 
		query.append("      ,A.INV_DIFF_AMT" ).append("\n"); 
		query.append("      ,A.INV_DIFF_RTO" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,A.LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,A.INV_CHG_AMT" ).append("\n"); 
		query.append("      ,A.WO_VRFY_FLG" ).append("\n"); 
		query.append("      ,A.ESTM_VRFY_FLG" ).append("\n"); 
		query.append("      ,A.ESTM_VRFY_DESC" ).append("\n"); 
		query.append("      ,A.WO_VRFY_DESC" ).append("\n"); 
		query.append("      ,A.INV_RGST_NO" ).append("\n"); 
		query.append("      ,(SELECT WM_CONCAT(EAC_NO) " ).append("\n"); 
		query.append("          FROM EAS_MNR_CFM_INV_DTL B" ).append("\n"); 
		query.append("         WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("           AND A.EQ_KND_CD = B.EQ_KND_CD) AS EAC_NO_CTNT" ).append("\n"); 
		query.append("      , A.CRE_USR_ID" ).append("\n"); 
		query.append("      , A.CRE_DT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("      , A.UPD_DT" ).append("\n"); 
		query.append("      , A.AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append("      , A.AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append("      , A.INV_CURR_CD" ).append("\n"); 
		query.append("      , A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("      , A.MLT_WO_CURR_FLG" ).append("\n"); 
		query.append(" FROM EAS_MNR_CFM_INV A" ).append("\n"); 
		query.append("WHERE A.INV_NO    = @[inv_no]" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ  = @[vndr_seq]" ).append("\n"); 
		query.append("  AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 

	}
}