/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchCustomsSetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchCustomsSetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchCustomsSetupListRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchCustomsSetupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchCustomsSetupListRSQL").append("\n"); 
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
		query.append("/* CustomsSetupVO */" ).append("\n"); 
		query.append("SELECT PORT_CD" ).append("\n"); 
		query.append("     , '' AS PORTS_CD" ).append("\n"); 
		query.append("     ,TML_CD" ).append("\n"); 
		query.append("     ,''  AS TMLS_CD" ).append("\n"); 
		query.append("     ,Y.CNT_CD" ).append("\n"); 
		query.append("     ,N1ST_EUR_PORT_FLG" ).append("\n"); 
		query.append("     ,EUR_CSTMS_OFC_ID AS CUSTOMS_CD" ).append("\n"); 
		query.append("     ,EUR_CSTMS_OFC_NM AS CUSTOMS_NM" ).append("\n"); 
		query.append("	 ,DECODE(EXS_EDI_SVC_FLG,'Y',1)       AS SVC_EXS_YN" ).append("\n"); 
		query.append("     ,DECODE(ENS_EDI_SVC_FLG,'Y',1)       AS SVC_ENS_YN" ).append("\n"); 
		query.append("     ,DECODE(AN_EDI_SVC_FLG,'Y',1)        AS SVC_AN_YN" ).append("\n"); 
		query.append("     ,DECODE(DVS_RQST_EDI_SVC_FLG,'Y',1)  AS SVC_DR_YN" ).append("\n"); 
		query.append("     ,CNTC_NM               AS CT_NAME" ).append("\n"); 
		query.append("     ,CNTC_PSN_NM           AS CT_POSITION" ).append("\n"); 
		query.append("     ,CNTC_EML              AS CT_EMAIL" ).append("\n"); 
		query.append("     ,CNTC_PHN_NO           AS CT_TEL " ).append("\n"); 
		query.append("     ,CNTC_FAX_NO           AS CT_FAX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_EUR_CD_STUP X" ).append("\n"); 
		query.append("     , MDM_LOCATION Y" ).append("\n"); 
		query.append("WHERE  X.PORT_CD = Y.LOC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${p_cnt_cd} != '') " ).append("\n"); 
		query.append("        AND Y.CNT_CD = @[p_cnt_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("/* GRID  조회시 All로 들어오고 저장시는 ALL로 들어온다. ALL은 저장되어야 하므로 중복을 허용해서 안된다. 주의해서 수정한다. */" ).append("\n"); 
		query.append("    #if (${p_port} != '' && ${p_port} != 'All') " ).append("\n"); 
		query.append("        AND X.PORT_CD = @[p_port]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${p_tml}!= ''  && ${p_tml} != 'All') " ).append("\n"); 
		query.append("        AND X.TML_CD = @[p_tml]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    #if (${p_cstms_cd} != '') " ).append("\n"); 
		query.append("        AND X.EUR_CSTMS_OFC_ID LIKE @[p_cstms_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}