/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FQAResultMgtDBDAOsearchFQAListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FQAResultMgtDBDAOsearchFQAListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FQAResultMgtDBDAOsearchFQAListDataRSQL
	  * </pre>
	  */
	public FQAResultMgtDBDAOsearchFQAListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.integration").append("\n"); 
		query.append("FileName : FQAResultMgtDBDAOsearchFQAListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("	MAX(A.OFC_CD) OFC_CD," ).append("\n"); 
		query.append("	TO_CHAR(A.FLD_AUD_DT,'YYYY-MM-DD') FLD_AUD_DT," ).append("\n"); 
		query.append("	TRIM(MAX(A.FLD_AUD_DTL_SEQ)) FLD_AUD_DTL_SEQ," ).append("\n"); 
		query.append("	A.YD_CD," ).append("\n"); 
		query.append("	TRIM(MAX(A.MAX_PNT_NO)) MAX_PNT_NO," ).append("\n"); 
		query.append("	TRIM(SUM(A.PNT_NO)) PNT_NO," ).append("\n"); 
		query.append("	DECODE(MAX(A.PNT_CALC_FLG),NULL,'N',MAX(A.PNT_CALC_FLG))  PNT_CALC_FLG," ).append("\n"); 
		query.append("	MAX(A.FLD_AUD_RMK) FLD_AUD_RMK," ).append("\n"); 
		query.append("	MAX(A.FILE_SEQ) FILE_SEQ," ).append("\n"); 
		query.append("	MAX(A.CRE_USR_ID) CRE_USR_ID," ).append("\n"); 
		query.append("	TRIM(MAX(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[ofc_cd]))) CRE_DT," ).append("\n"); 
		query.append("	MAX(A.UPD_USR_ID) UPD_USR_ID," ).append("\n"); 
		query.append("	TRIM(MAX(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.UPD_DT, @[ofc_cd]))) UPD_DT" ).append("\n"); 
		query.append("FROM MNR_FLD_QLTY_AUD_RSLT A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("	AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ar_hd_qtr_cd} != '')" ).append("\n"); 
		query.append("   AND @[ar_hd_qtr_cd] = (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                            FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                           WHERE OFC_CD = A.OFC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY VNDR_SEQ, YD_CD, FLD_AUD_DT" ).append("\n"); 

	}
}