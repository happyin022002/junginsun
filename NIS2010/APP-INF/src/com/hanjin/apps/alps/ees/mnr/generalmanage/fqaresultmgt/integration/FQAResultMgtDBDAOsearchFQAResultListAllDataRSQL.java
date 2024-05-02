/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FQAResultMgtDBDAOsearchFQAResultListAllDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.11 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FQAResultMgtDBDAOsearchFQAResultListAllDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search all
	  * </pre>
	  */
	public FQAResultMgtDBDAOsearchFQAResultListAllDataRSQL(){
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
		params.put("fld_aud_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.integration").append("\n"); 
		query.append("FileName : FQAResultMgtDBDAOsearchFQAResultListAllDataRSQL").append("\n"); 
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
		query.append("@[vndr_seq] AS VNDR_SEQ," ).append("\n"); 
		query.append("@[yd_cd] AS YD_CD," ).append("\n"); 
		query.append("@[ofc_cd] AS OFC_CD," ).append("\n"); 
		query.append("C.FLD_AUD_DT," ).append("\n"); 
		query.append("C.FLD_AUD_DTL_SEQ," ).append("\n"); 
		query.append("B.MNR_CD_DESC EV_DESC," ).append("\n"); 
		query.append("B.MNR_CD_DFLT_PNT_NO MAX_PNT_NO," ).append("\n"); 
		query.append("C.PNT_NO," ).append("\n"); 
		query.append("C.PNT_CALC_FLG," ).append("\n"); 
		query.append("C.FLD_AUD_RMK," ).append("\n"); 
		query.append("NVL(C.FILE_SEQ,'0') FILE_SEQ," ).append("\n"); 
		query.append("C.CRE_USR_ID," ).append("\n"); 
		query.append("C.CRE_DT," ).append("\n"); 
		query.append("C.UPD_USR_ID," ).append("\n"); 
		query.append("C.UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRIM(A.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("@[yd_cd] AS YD_CD," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.FLD_AUD_DT,'YYYY-MM-DD') FLD_AUD_DT," ).append("\n"); 
		query.append("TRIM(A.FLD_AUD_DTL_SEQ) FLD_AUD_DTL_SEQ," ).append("\n"); 
		query.append("A.EV_DESC," ).append("\n"); 
		query.append("TRIM(A.MAX_PNT_NO) MAX_PNT_NO," ).append("\n"); 
		query.append("TRIM(A.PNT_NO) PNT_NO," ).append("\n"); 
		query.append("DECODE(A.PNT_CALC_FLG,NULL,'N',A.PNT_CALC_FLG)  PNT_CALC_FLG," ).append("\n"); 
		query.append("A.FLD_AUD_RMK," ).append("\n"); 
		query.append("A.FILE_SEQ," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[ofc_cd]), 'yyyy-mm-dd') CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.UPD_DT, @[ofc_cd]), 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_FLD_QLTY_AUD_RSLT A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(A.FLD_AUD_DT,'YYYY-MM-DD') = @[fld_aud_dt]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#if (${gubn} == '2')" ).append("\n"); 
		query.append("AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")C, MNR_GEN_CD B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("C.EV_DESC(+) = B.MNR_CD_DESC" ).append("\n"); 
		query.append("AND B.PRNT_CD_ID = 'CD00003'" ).append("\n"); 
		query.append("ORDER BY B.MNR_CD_DP_SEQ" ).append("\n"); 

	}
}