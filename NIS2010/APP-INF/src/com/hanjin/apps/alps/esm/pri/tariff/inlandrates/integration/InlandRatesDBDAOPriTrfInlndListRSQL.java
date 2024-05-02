/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2010.12.20 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inland 리스트 조회
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndListRSQL").append("\n"); 
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
		query.append("WITH MAX_AMEND_INLND AS (" ).append("\n"); 
		query.append("	SELECT TRF_INLND_SEQ, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	  FROM PRI_TRF_INLND" ).append("\n"); 
		query.append("	 WHERE TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("	 GROUP BY TRF_INLND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.TRF_INLND_NM" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.EXP_DT" ).append("\n"); 
		query.append("     , A.RQST_OFC_CD" ).append("\n"); 
		query.append("     , A.APRO_OFC_CD" ).append("\n"); 
		query.append("     , A.TRF_INLND_STS_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("     , A.PUB_DT" ).append("\n"); 
		query.append("     , A.ATCH_FILE_ID" ).append("\n"); 
		query.append("  FROM PRI_TRF_INLND A, MAX_AMEND_INLND B" ).append("\n"); 
		query.append(" WHERE A.TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND A.TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ 		= A.AMDT_SEQ" ).append("\n"); 
		query.append("   AND B.TRF_INLND_SEQ 	= A.TRF_INLND_SEQ" ).append("\n"); 
		query.append(" ORDER BY A.TRF_INLND_NM" ).append("\n"); 

	}
}