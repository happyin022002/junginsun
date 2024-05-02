/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtUsdRoutCsTransitTimeCalculateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtUsdRoutCsTransitTimeCalculateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtUsdRoutCsTransitTimeCalculateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_src_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtUsdRoutCsTransitTimeCalculateUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRI_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT  TRI_PROP_NO, AMDT_SEQ, ROUT_CS_SRC_DT, ROUT_CS_NO" ).append("\n"); 
		query.append("          FROM (        " ).append("\n"); 
		query.append("		        SELECT  A.TRI_PROP_NO, A.AMDT_SEQ, A.ROUT_CS_SRC_DT, D.ROUT_CS_NO" ).append("\n"); 
		query.append("		        	   ,ROW_NUMBER() OVER(PARTITION BY A.TRI_PROP_NO, A.AMDT_SEQ, A.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("		        	   				ORDER BY D.TTL_TZTM_HRS, D.ROUT_CS_NO ) NUM" ).append("\n"); 
		query.append("		          FROM  PRI_TRI_RT C" ).append("\n"); 
		query.append("		               ,PRI_TRI_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("		               ,PRI_PRS_USD_ROUT_CS_INFO D" ).append("\n"); 
		query.append("		         WHERE  C.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("		           AND  C.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		           AND  C.PROP_STS_CD IN ( 'I', 'R')" ).append("\n"); 
		query.append("		           AND  C.PRS_UPD_DT IS NULL " ).append("\n"); 
		query.append("		           AND  C.TRI_PROP_NO = A.TRI_PROP_NO" ).append("\n"); 
		query.append("		           AND  C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("		           AND  A.ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("		           AND  A.ROUT_CS_NO = D.ROUT_CS_NO" ).append("\n"); 
		query.append("		           AND  A.ROUT_CS_SRC_DT = D.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("        		)" ).append("\n"); 
		query.append("		 WHERE  NUM = 1        		          " ).append("\n"); 
		query.append("    	) B" ).append("\n"); 
		query.append("ON (   A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.ROUT_CS_NO = B.ROUT_CS_NO" ).append("\n"); 
		query.append("   AND A.ROUT_CS_SRC_DT = B.ROUT_CS_SRC_DT)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 

	}
}