/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchUpprMstRfaVerThanBzcRfaVerYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.07 
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

public class RFAExceptionTariffMgtDBDAOSearchUpprMstRfaVerThanBzcRfaVerYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAExceptionTariffMgtDBDAOSearchUpprMstRfaVerThanBzcRfaVerYnRSQL
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchUpprMstRfaVerThanBzcRfaVerYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchUpprMstRfaVerThanBzcRfaVerYnRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN MST_RFA_EXPT_VER_SEQ > BZC_RFA_EXPT_VER_SEQ THEN 'Y' ELSE 'N' END AS UPPR_YN" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  (" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX_DESC( DMT_RFA_EXPT_TRF XPKDMT_RFA_EXPT_TRF ) */ MST_RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("						  FROM  DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("						 WHERE  PROP_NO = @[bzc_prop_no]" ).append("\n"); 
		query.append("						   AND  ROWNUM = 1" ).append("\n"); 
		query.append("					) AS BZC_RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX_DESC( DMT_RFA_EXPT_TRF XPKDMT_RFA_EXPT_TRF ) */ RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("						  FROM  DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("						 WHERE  PROP_NO = @[mst_prop_no]" ).append("\n"); 
		query.append("                           AND  DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("						   AND  ROWNUM = 1   " ).append("\n"); 
		query.append("					) AS MST_RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("			  FROM  DUAL" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}