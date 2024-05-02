/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ServiceProviderDAOSpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.serviceprovider.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderDAOSpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select service provider list
	  * </pre>
	  */
	public ServiceProviderDAOSpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pts_vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm_eng",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.serviceprovider.integration").append("\n"); 
		query.append("FileName : ServiceProviderDAOSpListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	IDA_GST_RGST_STS_CD," ).append("\n"); 
		query.append("	IDA_GST_RGST_NO," ).append("\n"); 
		query.append("	IDA_STE_CD," ).append("\n"); 
		query.append("	IDA_STE_NM," ).append("\n"); 
		query.append("	VNDR_SEQ," ).append("\n"); 
		query.append("	OFC_CD," ).append("\n"); 
		query.append("	VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("	VNDR_ABBR_NM," ).append("\n"); 
		query.append("	PRNT_VNDR_SEQ," ).append("\n"); 
		query.append("	VNDR_CNT_CD," ).append("\n"); 
		query.append("	ORG_VNDR_SEQ," ).append("\n"); 
		query.append("	ENG_ADDR," ).append("\n"); 
		query.append("	'' CNT_CD		," ).append("\n"); 
		query.append("	'' VNDR_NM_ENG	," ).append("\n"); 
		query.append("	'' OFC_CD     	," ).append("\n"); 
		query.append("	'' PTS_VNDR_CD	," ).append("\n"); 
		query.append("	'' VNDR_CD    	," ).append("\n"); 
		query.append("	'' P_SP_TYPE   	," ).append("\n"); 
		query.append("	'' LGS_FLG    	," ).append("\n"); 
		query.append("	'' I_PAGE" ).append("\n"); 
		query.append("FROM (SELECT ROW_NUMBER() OVER (ORDER BY VNDR_SEQ) NO," ).append("\n"); 
		query.append("		LPAD(MV.VNDR_SEQ, 6, '0') VNDR_SEQ," ).append("\n"); 
		query.append("		MV.OFC_CD," ).append("\n"); 
		query.append("		MV.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("		MV.VNDR_ABBR_NM," ).append("\n"); 
		query.append("		LPAD(MV.PRNT_VNDR_SEQ, 6, '0') PRNT_VNDR_SEQ," ).append("\n"); 
		query.append("		MV.VNDR_CNT_CD," ).append("\n"); 
		query.append("		MV.VNDR_CNT_CD||LPAD(MV.VNDR_SEQ, 6, '0') ORG_VNDR_SEQ," ).append("\n"); 
		query.append("		MV.ENG_ADDR," ).append("\n"); 
		query.append("		MV.IDA_GST_RGST_STS_CD," ).append("\n"); 
		query.append("		MV.IDA_GST_RGST_NO," ).append("\n"); 
		query.append("		(SELECT MS.IDA_STE_CD FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) AS IDA_STE_CD," ).append("\n"); 
		query.append("		(SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) AS IDA_STE_NM" ).append("\n"); 
		query.append("	FROM MDM_VENDOR MV, MDM_LOCATION ML" ).append("\n"); 
		query.append("	WHERE MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("     AND UPPER(MV.VNDR_CNT_CD) like UPPER(@[cnt_cd]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("     AND UPPER(MV.OFC_CD) like UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${vndr_nm_eng} != '')" ).append("\n"); 
		query.append("     AND UPPER(MV.VNDR_LGL_ENG_NM) like '%' || UPPER(@[vndr_nm_eng]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${pts_vndr_cd} != '')" ).append("\n"); 
		query.append("     AND LPAD(MV.PRNT_VNDR_SEQ, 6, '0') = LPAD(@[pts_vndr_cd], 6, '0')" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${vndr_cd} != '')" ).append("\n"); 
		query.append("     AND LPAD(MV.VNDR_SEQ, 6, '0') = LPAD(@[vndr_cd], 6, '0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lgs_flg} == 'Y')" ).append("\n"); 
		query.append("	AND MV.LGS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND NVL(MV.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("  ) a" ).append("\n"); 
		query.append("WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}