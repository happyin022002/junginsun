/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchVesselListByCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.12 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchVesselListByCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel에 대한 정보를 조회합니다.
	  * 
	  * History
	  * 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
	  *  - INC_DEL_VSL 이 D인 경우는 DELETE만, 'Y'는 전부, ''이면 살아있는 VSL만.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchVesselListByCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchVesselListByCodeRSQL").append("\n"); 
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
		query.append("*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	VSL_CLSS_FLG," ).append("\n"); 
		query.append("	VSL_ENG_NM," ).append("\n"); 
		query.append("	VSL_KRN_NM," ).append("\n"); 
		query.append("	FOIL_CAPA," ).append("\n"); 
		query.append("	DOIL_CAPA," ).append("\n"); 
		query.append("	FRSH_WTR_CAPA," ).append("\n"); 
		query.append("	CALL_SGN_NO," ).append("\n"); 
		query.append("	RGST_NO," ).append("\n"); 
		query.append("	PHN_NO," ).append("\n"); 
		query.append("	FAX_NO," ).append("\n"); 
		query.append("	TLX_NO," ).append("\n"); 
		query.append("	VSL_EML," ).append("\n"); 
		query.append("	PICLB_DESC," ).append("\n"); 
		query.append("	RGST_PORT_CD," ).append("\n"); 
		query.append("	CLSS_NO_RGST_AREA_NM," ).append("\n"); 
		query.append("	VSL_CLSS_NO," ).append("\n"); 
		query.append("	VSL_BLDR_NM," ).append("\n"); 
		query.append("	LOA_LEN," ).append("\n"); 
		query.append("	LBP_LEN," ).append("\n"); 
		query.append("	VSL_WDT," ).append("\n"); 
		query.append("	VSL_DPTH," ).append("\n"); 
		query.append("	SMR_DRFT_HGT," ).append("\n"); 
		query.append("	DWT_WGT," ).append("\n"); 
		query.append("	LGT_SHP_TONG_WGT," ).append("\n"); 
		query.append("	GRS_RGST_TONG_WGT," ).append("\n"); 
		query.append("	NET_RGST_TONG_WGT," ).append("\n"); 
		query.append("	PNM_GT_WGT," ).append("\n"); 
		query.append("	PNM_NET_TONG_WGT," ).append("\n"); 
		query.append("	SUZ_GT_WGT," ).append("\n"); 
		query.append("	SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("	MN_ENG_MKR_NM," ).append("\n"); 
		query.append("	MN_ENG_TP_DESC," ).append("\n"); 
		query.append("	MN_ENG_BHP_PWR," ).append("\n"); 
		query.append("	VSL_OWN_IND_CD," ).append("\n"); 
		query.append("	VSL_RGST_CNT_CD," ).append("\n"); 
		query.append("	VSL_BLD_CD," ).append("\n"); 
		query.append("	CRR_CD," ).append("\n"); 
		query.append("	FDR_DIV_CD," ).append("\n"); 
		query.append("	VSL_SVC_SPD," ).append("\n"); 
		query.append("	MAX_SPD," ).append("\n"); 
		query.append("	ECN_SPD," ).append("\n"); 
		query.append("	CRW_KNT," ).append("\n"); 
		query.append("	CNTR_DZN_CAPA," ).append("\n"); 
		query.append("	CNTR_OP_CAPA," ).append("\n"); 
		query.append("	CNTR_PNM_CAPA," ).append("\n"); 
		query.append("	CNTR_VSL_CLSS_CAPA," ).append("\n"); 
		query.append("	RF_RCPT_KNT," ).append("\n"); 
		query.append("	RF_RCPT_MAX_KNT," ).append("\n"); 
		query.append("	FBD_CAPA," ).append("\n"); 
		query.append("	DPL_CAPA," ).append("\n"); 
		query.append("	BLST_TNK_CAPA," ).append("\n"); 
		query.append("	FOIL_CSM," ).append("\n"); 
		query.append("	DOIL_CSM," ).append("\n"); 
		query.append("	FRSH_WTR_CSM," ).append("\n"); 
		query.append("	MN_ENG_RPM_PWR," ).append("\n"); 
		query.append("	GNR_RPM_PWR," ).append("\n"); 
		query.append("	VSL_HGT," ).append("\n"); 
		query.append("	RGST_DT," ).append("\n"); 
		query.append("	VSL_EDI_NM," ).append("\n"); 
		query.append("	CO_CD," ).append("\n"); 
		query.append("	VSL_CLZ_DT," ).append("\n"); 
		query.append("	VSL_CRE_OFC_CD," ).append("\n"); 
		query.append("	VSL_DELT_OFC_CD," ).append("\n"); 
		query.append("	VSL_BLD_AREA_NM," ).append("\n"); 
		query.append("	GNR_MKR_NM," ).append("\n"); 
		query.append("	GNR_TP_DESC," ).append("\n"); 
		query.append("	GNR_BHP_PWR," ).append("\n"); 
		query.append("	BWTHST_MKR_NM," ).append("\n"); 
		query.append("	BWTHST_TP_DESC," ).append("\n"); 
		query.append("	BWTHST_BHP_PWR," ).append("\n"); 
		query.append("	BWTHST_RPM_PWR," ).append("\n"); 
		query.append("	LLOYD_NO," ).append("\n"); 
		query.append("	VSL_LNCH_DT," ).append("\n"); 
		query.append("	VSL_DE_DT," ).append("\n"); 
		query.append("	VSL_KEL_LY_DT," ).append("\n"); 
		query.append("	VSL_HL_NO," ).append("\n"); 
		query.append("	TTL_TEU_KNT," ).append("\n"); 
		query.append("	VSL_HTCH_KNT," ).append("\n"); 
		query.append("	VSL_HLD_KNT," ).append("\n"); 
		query.append("	VSL_RMK," ).append("\n"); 
		query.append("	INTL_TONG_CERTI_FLG," ).append("\n"); 
		query.append("	VSL_SFT_CSTRU_CERTI_EXP_DT," ).append("\n"); 
		query.append("	VSL_SFT_RDO_CERTI_EXP_DT," ).append("\n"); 
		query.append("	VSL_SFT_EQ_CERTI_EXP_DT," ).append("\n"); 
		query.append("	VSL_LOD_LINE_CERTI_EXP_DT," ).append("\n"); 
		query.append("	VSL_DERAT_CERTI_EXP_DT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	DELT_FLG," ).append("\n"); 
		query.append("	EAI_EVNT_DT," ).append("\n"); 
		query.append("    VSL_LOCL_NM," ).append("\n"); 
		query.append("    COUNT(*) OVER() TOTAL_CNT," ).append("\n"); 
		query.append("    ROW_NUMBER() OVER(ORDER BY VSL_CD) RNUM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND VSL_CD LIKE UPPER(@[vsl_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '')" ).append("\n"); 
		query.append("AND VSL_ENG_NM LIKE UPPER(@[vsl_eng_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND CRR_CD LIKE UPPER(@[crr_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fdr_div_cd} != '')" ).append("\n"); 
		query.append("AND FDR_DIV_CD = DECODE(@[fdr_div_cd], 'A', FDR_DIV_CD, @[fdr_div_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${call_sgn_no} != '')" ).append("\n"); 
		query.append("AND CALL_SGN_NO LIKE UPPER(@[call_sgn_no]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lloyd_no} != '')" ).append("\n"); 
		query.append("AND LLOYD_NO LIKE UPPER(@[lloyd_no]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inc_del_vsl} == 'D')" ).append("\n"); 
		query.append("AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${inc_del_vsl} != 'Y' || ${inc_del_vsl} == '') " ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_locl_nm} != '')" ).append("\n"); 
		query.append("AND VSL_LOCL_NM LIKE @[vsl_locl_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VSL_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}