/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAOSearchFeederCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurOceanFeederCostManageDBDAOSearchFeederCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFeederCost
	  * 
	  * * History
	  * 2015.02.03 전지예 CHM-201533794 [AOC] 45' Cost 추가
	  * </pre>
	  */
	public EurOceanFeederCostManageDBDAOSearchFeederCostRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : EurOceanFeederCostManageDBDAOSearchFeederCostRSQL").append("\n"); 
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
		query.append("SELECT  D.FM_NOD_CD" ).append("\n"); 
		query.append("      , D.TO_NOD_CD" ).append("\n"); 
		query.append("      , DECODE(D.PCTL_IO_BND_CD, 'O', 'Pre', 'I', 'Post') PCTL_IO_BND_NM" ).append("\n"); 
		query.append("      , D.DIR_CD" ).append("\n"); 
		query.append("      , D.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("      , D.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("	  , D.CURR_CD" ).append("\n"); 
		query.append("      , D.FDR_20FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.FDR_40FT_TTL_AMT" ).append("\n"); 
		query.append("      , D.FDR_45FT_TTL_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("      , D.SCC_CD" ).append("\n"); 
		query.append("      , D.MB_20FT_RTO" ).append("\n"); 
		query.append("      , D.MB_40FT_RTO" ).append("\n"); 
		query.append("      , D.MB_45FT_RTO -- 45' Cost 추가" ).append("\n"); 
		query.append("      , D.TRSP_20FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TRSP_20FT_COST_SYS_SRC_CD) TRSP_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(TRSP_20FT_AGMT_WGT,999999.99,'MAX',TO_CHAR(TRSP_20FT_AGMT_WGT))  AGMT_WGT_20FT" ).append("\n"); 
		query.append("      , D.TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TRSP_40FT_COST_SYS_SRC_CD) TRSP_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(TRSP_40FT_AGMT_WGT,999999.99,'MAX',TO_CHAR(TRSP_40FT_AGMT_WGT))  AGMT_WGT_40FT" ).append("\n"); 
		query.append("      , D.TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      -- 45' Cost 추가 start" ).append("\n"); 
		query.append("      , D.TRSP_45FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TRSP_45FT_COST_SYS_SRC_CD) TRSP_45FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TRSP_45FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TRSP_45FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(TRSP_45FT_AGMT_WGT,999999.99,'MAX',TO_CHAR(TRSP_45FT_AGMT_WGT))  AGMT_WGT_45FT" ).append("\n"); 
		query.append("      , D.TRSP_45FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      -- 45' Cost 추가 end" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.MTY_TRSP_20FT_COST_SYS_SRC_CD) MTY_TRSP_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.MTY_TRSP_40FT_COST_SYS_SRC_CD) MTY_TRSP_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      -- 45' Cost 추가 start" ).append("\n"); 
		query.append("      , D.MTY_TRSP_45FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.MTY_TRSP_45FT_COST_SYS_SRC_CD) MTY_TRSP_45FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.MTY_TRSP_45FT_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_45FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.MTY_TRSP_45FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      -- 45' Cost 추가 end" ).append("\n"); 
		query.append("      , D.TML_20FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TML_20FT_COST_SYS_SRC_CD) TML_20FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TML_20FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_20FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TML_40FT_COST_SYS_SRC_CD) TML_40FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TML_40FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_40FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      -- 45' Cost 추가 start" ).append("\n"); 
		query.append("      , D.TML_45FT_COST_SYS_SRC_CD" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', D.TML_45FT_COST_SYS_SRC_CD) TML_45FT_COST_SYS_SRC_NM" ).append("\n"); 
		query.append("      , D.TML_45FT_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_45FT_ADJ_COST_AMT" ).append("\n"); 
		query.append("      , D.TML_45FT_TTL_COST_AMT" ).append("\n"); 
		query.append("      -- 45' Cost 추가 end" ).append("\n"); 
		query.append("      , D.VNDR_SEQ" ).append("\n"); 
		query.append("      , ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = D.VNDR_SEQ ) VNDR_NM" ).append("\n"); 
		query.append("      , GREATEST( NVL(D.TRSP_20FT_AGMT_OLD_FLG,'N'), NVL(D.TRSP_40FT_AGMT_OLD_FLG,'N'), NVL(D.TRSP_45FT_AGMT_OLD_FLG,'N') ) AGMT_OLD_FLG" ).append("\n"); 
		query.append("      , D.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("      , D.COST_TRF_NO" ).append("\n"); 
		query.append("      , '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM    AOC_EUR_FDR_TRF_HDR M" ).append("\n"); 
		query.append("      , AOC_EUR_FDR_TRF_DTL D" ).append("\n"); 
		query.append("WHERE   M.COST_TRF_NO = D.COST_TRF_NO" ).append("\n"); 
		query.append("AND     M.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("AND     D.COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_from_nod_cd} != '') " ).append("\n"); 
		query.append("AND     D.FM_NOD_CD LIKE @[in_from_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_to_nod_cd} != '') " ).append("\n"); 
		query.append("AND     D.TO_NOD_CD LIKE @[in_to_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}