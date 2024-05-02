/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcRoutPntInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.08 
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

public class TariffGeneralInformationDBDAOPriTrfBzcRoutPntInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff General Information Scope을 Select한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcRoutPntInquiryVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcRoutPntInquiryVORSQL").append("\n"); 
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
		query.append("SELECT  ROUT.TRF_BZC_ROUT_PNT_DEF_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  CNT_NM" ).append("\n"); 
		query.append("          FROM  MDM_COUNTRY" ).append("\n"); 
		query.append("         WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND  CNT_CD = ROUT.TRF_BZC_ROUT_PNT_DEF_CD" ).append("\n"); 
		query.append("        ) AS CNT_NM" ).append("\n"); 
		query.append("  FROM  PRI_TRF_BZC_ROUT_PNT ROUT" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  ROUT.TRF_PFX_CD     = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  ROUT.TRF_NO         = @[trf_no]" ).append("\n"); 
		query.append("   AND  ROUT.AMDT_SEQ       = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  ROUT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND  ROUT.SRC_INFO_CD    <> 'AD'" ).append("\n"); 

	}
}