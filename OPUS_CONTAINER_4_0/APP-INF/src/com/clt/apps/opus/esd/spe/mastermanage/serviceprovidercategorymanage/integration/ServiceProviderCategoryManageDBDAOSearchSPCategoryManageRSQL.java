/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderCategoryManageDBDAOSearchSPCategoryManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.30 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderCategoryManageDBDAOSearchSPCategoryManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSPCategoryManage
	  * </pre>
	  */
	public ServiceProviderCategoryManageDBDAOSearchSPCategoryManageRSQL(){
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
		params.put("eg_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderCategoryManageDBDAOSearchSPCategoryManageRSQL").append("\n"); 
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
		query.append("#if (${vndr_seq} == '')" ).append("\n"); 
		query.append("#if (${mapped} == 'Y')" ).append("\n"); 
		query.append("SELECT S.VNDR_SEQ," ).append("\n"); 
		query.append("A.VNDR_LGL_ENG_NM AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.REG_GROUP," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TRSP_FLG, 'Y', '1', '0') AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_RAIL_FLG, 'Y', '1', '0') AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_CY_FLG, 'Y', '1', '0') AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TML_FLG, 'Y', '1', '0') AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_WTR_FLG, 'Y', '1', '0') AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_EQ_FLG, 'Y', '1', '0') AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', @[eg_rhq_cd], 'A', DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD, 1, 3), 'SIN', 'SIN', 'SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND V.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND M.OFC_CD LIKE @[eg_cty_cd]||'%' ) A" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${mapped} == 'N')" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', @[eg_rhq_cd], 'A', DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD, 1, 3), 'SIN', 'SIN', 'SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND V.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND V.OFC_CD LIKE @[eg_cty_cd]||'%'" ).append("\n"); 
		query.append("AND V.VNDR_SEQ NOT IN (" ).append("\n"); 
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', @[eg_rhq_cd], 'A', 'SHA') REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND M.OFC_CD LIKE @[eg_cty_cd]||'%' ) A" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ = A.VNDR_SEQ)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT S.VNDR_SEQ," ).append("\n"); 
		query.append("A.VNDR_LGL_ENG_NM AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.REG_GROUP," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TRSP_FLG, 'Y', '1', '0') AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_RAIL_FLG, 'Y', '1', '0') AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_CY_FLG, 'Y', '1', '0') AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TML_FLG, 'Y', '1', '0') AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_WTR_FLG, 'Y', '1', '0') AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_EQ_FLG, 'Y', '1', '0') AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', @[eg_rhq_cd], 'A', DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD, 1, 3), 'SIN', 'SIN', 'SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND V.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND M.OFC_CD LIKE @[eg_cty_cd]||'%' ) A" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', @[eg_rhq_cd], 'A', DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD, 1, 3), 'SIN', 'SIN', 'SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND V.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND V.OFC_CD LIKE @[eg_cty_cd]||'%'" ).append("\n"); 
		query.append("AND V.VNDR_SEQ NOT IN (" ).append("\n"); 
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', @[eg_rhq_cd], 'A', 'SHA') REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND M.OFC_CD LIKE @[eg_cty_cd]||'%' ) A" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ = A.VNDR_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${vndr_seq} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mapped} == 'Y')" ).append("\n"); 
		query.append("SELECT S.VNDR_SEQ," ).append("\n"); 
		query.append("M.VNDR_LGL_ENG_NM AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TRSP_FLG, 'Y', '1', '0') AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_RAIL_FLG, 'Y', '1', '0') AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_CY_FLG, 'Y', '1', '0') AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TML_FLG, 'Y', '1', '0') AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_WTR_FLG, 'Y', '1', '0') AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_EQ_FLG, 'Y', '1', '0') AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT C.VNDR_SEQ, C.VNDR_LGL_ENG_NM, A.OFC_CD, DECODE(B.CONTI_CD, 'F', 'HAM','E','HAM','M','NYC','A',DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD,1,3),'SIN','SIN','SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION A, MDM_LOCATION B, MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND     A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append(")M" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	S.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND M.OFC_CD LIKE @[eg_cty_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${mapped} == 'A')" ).append("\n"); 
		query.append("#if (${chk_unique} =='Y')" ).append("\n"); 
		query.append("SELECT S.VNDR_SEQ," ).append("\n"); 
		query.append("M.VNDR_LGL_ENG_NM AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TRSP_FLG, 'Y', '1', '0') AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_RAIL_FLG, 'Y', '1', '0') AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_CY_FLG, 'Y', '1', '0') AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TML_FLG, 'Y', '1', '0') AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_WTR_FLG, 'Y', '1', '0') AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_EQ_FLG, 'Y', '1', '0') AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT C.VNDR_SEQ, C.VNDR_LGL_ENG_NM, A.OFC_CD, DECODE(B.CONTI_CD, 'F', 'HAM','E','HAM','M','NYC','A',DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD,1,3),'SIN','SIN','SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION A, MDM_LOCATION B, MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND     A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append(")M" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	S.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND M.OFC_CD LIKE @[eg_cty_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM  AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', 'NYC', 'A', DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD, 1, 3), 'SIN', 'SIN', 'SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND V.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND V.VNDR_SEQ =@[vndr_seq]" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND V.OFC_CD LIKE @[eg_cty_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${chk_unique} =='Y')" ).append("\n"); 
		query.append("SELECT S.VNDR_SEQ," ).append("\n"); 
		query.append("''AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("''REG_GROUP," ).append("\n"); 
		query.append("''OFC_CD," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TRSP_FLG, 'Y', '1', '0') AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_RAIL_FLG, 'Y', '1', '0') AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_CY_FLG, 'Y', '1', '0') AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_TML_FLG, 'Y', '1', '0') AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_WTR_FLG, 'Y', '1', '0') AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("DECODE(S.SVC_CATE_EQ_FLG, 'Y', '1', '0') AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S" ).append("\n"); 
		query.append("WHERE 	S.VNDR_SEQ IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("M.REG_GROUP," ).append("\n"); 
		query.append("M.OFC_CD," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("'0' AS SVC_CATE_EQ_FLG" ).append("\n"); 
		query.append("FROM MDM_VENDOR V," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', 'NYC', 'A', DECODE(SUBSTR(A.AR_HD_QTR_OFC_CD, 1, 3), 'SIN', 'SIN', 'SHA')) REG_GROUP" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y' ) M" ).append("\n"); 
		query.append("WHERE V.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("AND V.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND V.VNDR_SEQ =@[vndr_seq]" ).append("\n"); 
		query.append("#if (${eg_rhq_cd} !='')" ).append("\n"); 
		query.append("AND M.REG_GROUP LIKE @[eg_rhq_cd]||'%'" ).append("\n"); 
		query.append("AND V.OFC_CD LIKE @[eg_cty_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}