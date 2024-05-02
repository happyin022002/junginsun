/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcAmendScopeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcAmendScopeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Code의 General Information을 Amend하여 Scope을 Insert 한다..
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcAmendScopeCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcAmendScopeCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_BZC_ROUT_PNT" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    TRF_PFX_CD" ).append("\n"); 
		query.append("   ,TRF_NO" ).append("\n"); 
		query.append("   ,AMDT_SEQ" ).append("\n"); 
		query.append("   ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_ROUT_PNT_SEQ" ).append("\n"); 
		query.append("   ,TRF_BZC_ROUT_PNT_TP_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_ROUT_PNT_DEF_CD" ).append("\n"); 
		query.append("   ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("   ,SRC_INFO_CD" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("        TRF_PFX_CD" ).append("\n"); 
		query.append("       ,TRF_NO" ).append("\n"); 
		query.append("       ,AMDT_SEQ + 1" ).append("\n"); 
		query.append("       ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("       ,TRF_BZC_ROUT_PNT_SEQ" ).append("\n"); 
		query.append("       ,TRF_BZC_ROUT_PNT_TP_CD" ).append("\n"); 
		query.append("       ,TRF_BZC_ROUT_PNT_DEF_CD" ).append("\n"); 
		query.append("       ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("       ,SRC_INFO_CD" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("  FROM  PRI_TRF_BZC_ROUT_PNT" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  TRF_NO     = @[trf_no]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}