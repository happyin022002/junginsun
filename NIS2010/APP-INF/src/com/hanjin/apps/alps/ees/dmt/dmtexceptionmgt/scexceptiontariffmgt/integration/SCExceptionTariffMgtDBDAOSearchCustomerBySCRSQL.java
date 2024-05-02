/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchCustomerBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchCustomerBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Exception Terms Entry 의 Group 에 소속된 Actual Customer 정보를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchCustomerBySCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchCustomerBySCRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT " ).append("\n"); 
		query.append("        NEW.PROP_NO" ).append("\n"); 
		query.append("	   ,NEW.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	   ,NEW.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	   ,NEW.CUST_CD" ).append("\n"); 
		query.append("	   ,NEW.ACT_CUST_FLG" ).append("\n"); 
		query.append("	   ,( SELECT	/*+ INDEX_DESC(A XPKPRI_SP_CTRT_CUST_TP) */ " ).append("\n"); 
		query.append("        				CASE prc_ctrt_cust_tp_cd WHEN 'N' THEN 'Actual Customer'" ).append("\n"); 
		query.append("                                 				 WHEN 'I' THEN 'Affiliate'" ).append("\n"); 
		query.append("                                				 WHEN 'A' THEN 'Affiliate'" ).append("\n"); 
		query.append("                                				 WHEN 'B' THEN 'Affiliate'" ).append("\n"); 
		query.append("                                				 ELSE ' ' END prc_ctrt_cust_tp_cd" ).append("\n"); 
		query.append("			FROM	PRI_SP_CTRT_CUST_TP A" ).append("\n"); 
		query.append("			WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND     ROWNUM = 1 ) AS CUST_TP" ).append("\n"); 
		query.append("	   ,NEW.CUST_NM" ).append("\n"); 
		query.append("	   ,DECODE(OLD.SC_EXPT_GRP_SEQ, null, 'Y','N') AS NEW_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT SC_ACT_CUST.PROP_NO" ).append("\n"); 
		query.append("            ,SC_ACT_CUST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("            ,SC_ACT_CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("            ,SC_ACT_CUST.CUST_CNT_CD || LPAD(SC_ACT_CUST.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("            ,SC_ACT_CUST.ACT_CUST_FLG" ).append("\n"); 
		query.append("            ,DECODE(SC_ACT_CUST.ACT_CUST_FLG, 'Y', 'Actual Customer', 'N', 'Affiliate', '') AS CUST_TP" ).append("\n"); 
		query.append("            ,CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("      FROM	DMT_SC_EXPT_ACT_CUST SC_ACT_CUST, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("      WHERE	SC_ACT_CUST.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("      	AND	SC_ACT_CUST.SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("      	AND SC_ACT_CUST.SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("      	AND SC_ACT_CUST.CUST_CNT_CD 	= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("      	AND SC_ACT_CUST.CUST_SEQ 		= CUST.CUST_SEQ" ).append("\n"); 
		query.append("        --AND SC_ACT_CUST.ACT_CUST_FLG ='Y'" ).append("\n"); 
		query.append("       ) NEW," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT  SC_ACT_CUST.PROP_NO" ).append("\n"); 
		query.append("              ,SC_ACT_CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("              ,SC_ACT_CUST.CUST_CNT_CD || LPAD(SC_ACT_CUST.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("              ,SC_ACT_CUST.ACT_CUST_FLG" ).append("\n"); 
		query.append("        FROM	DMT_SC_EXPT_ACT_CUST SC_ACT_CUST" ).append("\n"); 
		query.append("        WHERE	SC_ACT_CUST.PROP_NO 	= @[prop_no]" ).append("\n"); 
		query.append("        AND	SC_ACT_CUST.SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("        AND SC_ACT_CUST.SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("        --AND SC_ACT_CUST.ACT_CUST_FLG ='Y'" ).append("\n"); 
		query.append("        INTERSECT       " ).append("\n"); 
		query.append("        SELECT SC_ACT_CUST.PROP_NO" ).append("\n"); 
		query.append("              ,SC_ACT_CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("              ,SC_ACT_CUST.CUST_CNT_CD || LPAD(SC_ACT_CUST.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("              ,SC_ACT_CUST.ACT_CUST_FLG" ).append("\n"); 
		query.append("        FROM   DMT_SC_EXPT_ACT_CUST SC_ACT_CUST" ).append("\n"); 
		query.append("        WHERE  SC_ACT_CUST.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("        AND	SC_ACT_CUST.SC_EXPT_VER_SEQ = @[sc_expt_ver_seq] - 1" ).append("\n"); 
		query.append("        AND SC_ACT_CUST.SC_EXPT_GRP_SEQ = @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("        --AND SC_ACT_CUST.ACT_CUST_FLG ='Y'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("       ) OLD" ).append("\n"); 
		query.append("WHERE  NEW.SC_EXPT_GRP_SEQ =  OLD.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 

	}
}