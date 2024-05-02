/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeDBDAOSearchTariffCodeALLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.11.08 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffCodeDBDAOSearchTariffCodeALLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Code Inquiry
	  * </pre>
	  */
	public TariffCodeDBDAOSearchTariffCodeALLRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffcode.integration").append("\n"); 
		query.append("FileName : TariffCodeDBDAOSearchTariffCodeALLRSQL").append("\n"); 
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
		query.append("SELECT B.TRF_PFX_CD||'-'||B.TRF_NO Tariff_Code" ).append("\n"); 
		query.append("      ,B.TRF_BZC_TP_CD" ).append("\n"); 
		query.append("      ,B.AMDT_SEQ" ).append("\n"); 
		query.append("      ,T.TRF_NM" ).append("\n"); 
		query.append("  FROM PRI_TRF_BZC B," ).append("\n"); 
		query.append("       PRI_TARIFF T" ).append("\n"); 
		query.append(" WHERE B.TRF_NO = T.TRF_NO" ).append("\n"); 
		query.append("   AND B.TRF_PFX_CD = T.TRF_PFX_CD" ).append("\n"); 
		query.append("   AND T.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (B.TRF_PFX_CD, B.TRF_NO,  B.AMDT_SEQ) " ).append("\n"); 
		query.append("       IN (SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("                 ,A.TRF_NO" ).append("\n"); 
		query.append("                 ,MAX(A.AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("           FROM PRI_TRF_BZC A" ).append("\n"); 
		query.append("           WHERE 1 = 1" ).append("\n"); 
		query.append("           AND AMDT_SEQ > '0'" ).append("\n"); 
		query.append("           OR (AMDT_SEQ = '0' AND TRF_BZC_STS_CD = 'F') " ).append("\n"); 
		query.append("           GROUP BY A.TRF_PFX_CD, A.TRF_NO )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${trf_no}!= '')" ).append("\n"); 
		query.append("   AND B.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${trf_pfx_cd}!= '')" ).append("\n"); 
		query.append("   AND B.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   #end       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY Tariff_Code" ).append("\n"); 

	}
}