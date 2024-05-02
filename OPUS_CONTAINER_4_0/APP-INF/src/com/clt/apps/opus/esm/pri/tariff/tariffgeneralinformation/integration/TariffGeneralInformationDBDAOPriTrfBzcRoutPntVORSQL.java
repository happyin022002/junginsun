/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcRoutPntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcRoutPntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Scope 을 조회한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcRoutPntVORSQL(){
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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcRoutPntVORSQL").append("\n"); 
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
		query.append("SELECT  ROUT.TRF_PFX_CD" ).append("\n"); 
		query.append("       ,ROUT.TRF_NO" ).append("\n"); 
		query.append("       ,ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("       ,ROUT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("       ,ROUT.TRF_BZC_ROUT_PNT_SEQ" ).append("\n"); 
		query.append("       ,ROUT.TRF_BZC_ROUT_PNT_TP_CD" ).append("\n"); 
		query.append("       ,ROUT.TRF_BZC_ROUT_PNT_DEF_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  CNT_NM" ).append("\n"); 
		query.append("          FROM  MDM_COUNTRY" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  CNT_CD   = ROUT.TRF_BZC_ROUT_PNT_DEF_CD" ).append("\n"); 
		query.append("           AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("        ) CNT_NM" ).append("\n"); 
		query.append("       ,ROUT.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("       ,ROUT.SRC_INFO_CD" ).append("\n"); 
		query.append("       ,(SELECT  MAX(TO_CHAR(SUB.UPD_DT, 'YYYYMMDD-HH24MISS')) " ).append("\n"); 
		query.append("          FROM  PRI_TRF_BZC_ROUT_PNT SUB" ).append("\n"); 
		query.append("         WHERE  SUB.TRF_PFX_CD = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("           AND  SUB.TRF_NO     = AMEND.TRF_NO" ).append("\n"); 
		query.append("           AND  SUB.AMDT_SEQ   = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("         GROUP BY TRF_PFX_CD, TRF_NO, AMDT_SEQ" ).append("\n"); 
		query.append("        ) AS UPD_DT" ).append("\n"); 
		query.append("  FROM  PRI_TRF_BZC_ROUT_PNT    ROUT" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  TRF_PFX_CD, TRF_NO" ).append("\n"); 
		query.append("               ,MAX(AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("          FROM  PRI_TRF_BZC" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("           AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("        GROUP BY TRF_PFX_CD,TRF_NO" ).append("\n"); 
		query.append("        ) AMEND" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  ROUT.TRF_PFX_CD = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("   AND  ROUT.TRF_NO     = AMEND.TRF_NO" ).append("\n"); 
		query.append("   AND  ROUT.ORG_DEST_TP_CD          = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND  (   ROUT.AMDT_SEQ = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("        OR  (    ROUT.AMDT_SEQ = AMEND.AMDT_SEQ - 1" ).append("\n"); 
		query.append("            AND  ROUT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND  NOT EXISTS  (" ).append("\n"); 
		query.append("                             SELECT  1" ).append("\n"); 
		query.append("                               FROM  PRI_TRF_BZC_ROUT_PNT EXCEP" ).append("\n"); 
		query.append("                              WHERE  1 = 1" ).append("\n"); 
		query.append("                                AND  EXCEP.TRF_PFX_CD = AMEND.TRF_PFX_CD" ).append("\n"); 
		query.append("                                AND  EXCEP.TRF_NO     = AMEND.TRF_NO" ).append("\n"); 
		query.append("                                AND  EXCEP.AMDT_SEQ   = AMEND.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND  EXCEP.ORG_DEST_TP_CD       = ROUT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                AND  EXCEP.TRF_BZC_ROUT_PNT_SEQ = ROUT.TRF_BZC_ROUT_PNT_SEQ" ).append("\n"); 
		query.append("                                AND  EXCEP.N1ST_CMNC_AMDT_SEQ   = ROUT.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("            )                 " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY ROUT.ORG_DEST_TP_CD, ROUT.TRF_BZC_ROUT_PNT_SEQ, ROUT.TRF_BZC_ROUT_PNT_TP_CD, ROUT.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 

	}
}