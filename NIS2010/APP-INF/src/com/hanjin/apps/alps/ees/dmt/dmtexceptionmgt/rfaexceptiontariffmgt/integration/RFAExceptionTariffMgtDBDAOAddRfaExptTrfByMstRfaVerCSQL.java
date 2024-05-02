/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOAddRfaExptTrfByMstRfaVerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOAddRfaExptTrfByMstRfaVerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAExceptionTariffMgtDBDAOAddRfaExptTrfByMstRfaVerCSQL
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOAddRfaExptTrfByMstRfaVerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOAddRfaExptTrfByMstRfaVerCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	   ,RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	   ,RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	   ,PROP_NO" ).append("\n"); 
		query.append("	   ,DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("	   ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("	   ,CUST_CNT_CD" ).append("\n"); 
		query.append("	   ,CUST_SEQ" ).append("\n"); 
		query.append("	   ,RQST_USR_ID" ).append("\n"); 
		query.append("	   ,RQST_OFC_CD" ).append("\n"); 
		query.append("	   ,RQST_DT" ).append("\n"); 
		query.append("	   ,APRO_OFC_CD" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,CRE_OFC_CD" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,UPD_OFC_CD" ).append("\n"); 
		query.append("	   ,MST_RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC( DMT_RFA_EXPT_TRF XPKDMT_RFA_EXPT_TRF ) */" ).append("\n"); 
		query.append("        @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("	   ,RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  NVL(MAX(RFA_EXPT_VER_SEQ), 0) + 1" ).append("\n"); 
		query.append("			  FROM  DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("			 WHERE  PROP_NO = @[bzc_prop_no]" ).append("\n"); 
		query.append("	    ) " ).append("\n"); 
		query.append("	   ,@[bzc_prop_no]" ).append("\n"); 
		query.append("	   ,'T'" ).append("\n"); 
		query.append("	   ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("	   ,CUST_CNT_CD" ).append("\n"); 
		query.append("	   ,CUST_SEQ" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,APRO_OFC_CD" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	   ,RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("  FROM  DMT_RFA_EXPT_TRF T1" ).append("\n"); 
		query.append(" WHERE  T1.PROP_NO = @[mst_prop_no]" ).append("\n"); 
		query.append("   AND  T1.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("   AND  ROWNUM = 1" ).append("\n"); 

	}
}