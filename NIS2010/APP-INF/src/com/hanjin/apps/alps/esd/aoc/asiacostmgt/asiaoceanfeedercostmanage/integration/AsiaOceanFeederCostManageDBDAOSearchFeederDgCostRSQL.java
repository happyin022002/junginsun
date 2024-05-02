/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AsiaOceanFeederCostManageDBDAOSearchFeederDgCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaOceanFeederCostManageDBDAOSearchFeederDgCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.04 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
	  * </pre>
	  */
	public AsiaOceanFeederCostManageDBDAOSearchFeederDgCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_from_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : AsiaOceanFeederCostManageDBDAOSearchFeederDgCostRSQL").append("\n"); 
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
		query.append("SELECT  DG.COST_TRF_NO" ).append("\n"); 
		query.append(", DG.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append(", DRY.FM_NOD_CD" ).append("\n"); 
		query.append(", DRY.TO_NOD_CD" ).append("\n"); 
		query.append(", DRY.PCTL_IO_BND_CD" ).append("\n"); 
		query.append(", DECODE(DRY.PCTL_IO_BND_CD, 'O', 'Pre', 'I', 'Post') PCTL_IO_BND_NM" ).append("\n"); 
		query.append(", DRY.DIR_CD" ).append("\n"); 
		query.append(", DRY.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(", DRY.WTR_DE_TERM_CD" ).append("\n"); 
		query.append(", DRY.CURR_CD" ).append("\n"); 
		query.append(", DRY.VNDR_SEQ" ).append("\n"); 
		query.append(", ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = DRY.VNDR_SEQ ) VNDR_NM" ).append("\n"); 
		query.append(", GREATEST( NVL(DRY.TRSP_20FT_AGMT_OLD_FLG,'N'), NVL(DRY.TRSP_40FT_AGMT_OLD_FLG,'N') ) AGMT_OLD_FLG" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N1ST_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N1ST_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N1ST_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N1ST_CLSS_20FT_SCG_AMT AS IMDG_N1ST_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N1ST_CLSS_40FT_SCG_AMT AS IMDG_N1ST_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N2ND_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N2ND_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N2ND_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N2ND_CLSS_20FT_SCG_AMT AS IMDG_N2ND_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N2ND_CLSS_40FT_SCG_AMT AS IMDG_N2ND_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N3RD_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N3RD_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N3RD_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N3RD_CLSS_20FT_SCG_AMT AS IMDG_N3RD_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N3RD_CLSS_40FT_SCG_AMT AS IMDG_N3RD_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N4TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N4TH_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N4TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N4TH_CLSS_20FT_SCG_AMT AS IMDG_N4TH_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N4TH_CLSS_40FT_SCG_AMT AS IMDG_N4TH_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N5TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N5TH_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N5TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N5TH_CLSS_20FT_SCG_AMT AS IMDG_N5TH_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N5TH_CLSS_40FT_SCG_AMT AS IMDG_N5TH_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N6TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N6TH_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N6TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N6TH_CLSS_20FT_SCG_AMT AS IMDG_N6TH_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N6TH_CLSS_40FT_SCG_AMT AS IMDG_N6TH_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N7TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N7TH_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N7TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N7TH_CLSS_20FT_SCG_AMT AS IMDG_N7TH_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N7TH_CLSS_40FT_SCG_AMT AS IMDG_N7TH_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N8TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N8TH_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N8TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N8TH_CLSS_20FT_SCG_AMT AS IMDG_N8TH_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N8TH_CLSS_40FT_SCG_AMT AS IMDG_N8TH_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N9TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append(", DG.IMDG_N9TH_CLSS_20FT_SCG_AMT" ).append("\n"); 
		query.append(", DG.IMDG_N9TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append(", DRY.FDR_20FT_TTL_AMT + DG.IMDG_N9TH_CLSS_20FT_SCG_AMT AS IMDG_N9TH_CLSS_20FT_TTL_AMT" ).append("\n"); 
		query.append(", DRY.FDR_40FT_TTL_AMT + DG.IMDG_N9TH_CLSS_40FT_SCG_AMT AS IMDG_N9TH_CLSS_40FT_TTL_AMT" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM    AOC_CHN_FDR_DG_TRF_DTL DG" ).append("\n"); 
		query.append(", AOC_CHN_FDR_TRF_DTL DRY" ).append("\n"); 
		query.append("WHERE   DG.COST_TRF_NO = DRY.COST_TRF_NO" ).append("\n"); 
		query.append("AND     DG.COST_TRF_ROUT_SEQ = DRY.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("AND     DG.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_from_nod_cd} != '')" ).append("\n"); 
		query.append("AND     DRY.FM_NOD_CD LIKE @[in_from_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_to_nod_cd} != '')" ).append("\n"); 
		query.append("AND     DRY.TO_NOD_CD LIKE @[in_to_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}