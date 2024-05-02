/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetRfRdrRgnChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetRfRdrRgnChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer의 RGN 변경시 Used RF, POL, POD, RF Surcharge정보를 조회한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetRfRdrRgnChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetRfRdrRgnChangeRSQL").append("\n"); 
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
		query.append("WITH CRR AS (" ).append("\n"); 
		query.append("    SELECT B.JO_CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD" ).append("\n"); 
		query.append("    FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("    		   SELECT DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("    		   FROM   DUAL" ).append("\n"); 
		query.append("    		   UNION  ALL" ).append("\n"); 
		query.append("    		   SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("    		   FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("    		   WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("    		   AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("    		   AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd])" ).append("\n"); 
		query.append("    		   AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("    		   AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("           ) B" ).append("\n"); 
		query.append("    WHERE  A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("    AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("    AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("    AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("    AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("    AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("    AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("    AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("    AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("    AND    A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("    AND    A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND    A.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${ioc_cd} == 'O')" ).append("\n"); 
		query.append("SELECT 'O' OI, M.POL AS FM_PORT_CD, M.POD_ISO AS TO_PORT_CD," ).append("\n"); 
		query.append("       SUM(DECODE(M.CNTR_SIZE,'2',1,'3',1,0))       USD_SLT_BSA_QTY_20," ).append("\n"); 
		query.append("       SUM(DECODE(M.CNTR_SIZE,'4',1,'H',1,'L',1,0)) USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("  FROM RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("   AND H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("   AND H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("   AND H.REGION  = M.REGION" ).append("\n"); 
		query.append("   AND M.CARGO_TYPE <> 'IR'" ).append("\n"); 
		query.append("   AND M.TEMP IS NOT NULL     " ).append("\n"); 
		query.append("   AND (M.OPR_CD, M.VSL_CD, M.VOY_NO, M.DIR_CD) IN " ).append("\n"); 
		query.append("       (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM CRR)" ).append("\n"); 
		query.append("   AND H.REGION   = @[sconti_cd]" ).append("\n"); 
		query.append(" GROUP BY M.POL, M.POD_ISO" ).append("\n"); 
		query.append("UNION  ALL" ).append("\n"); 
		query.append("SELECT 'O' OI, S.POL AS FM_PORT_CD, S.POD_ISO AS TO_PORT_CD," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE,'2',QTY,0)) USD_SLT_BSA_QTY_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE,'4',QTY,0)) USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("  FROM RDR_HEADER H, RDR_SUMMARY S" ).append("\n"); 
		query.append(" WHERE H.VSL_CD     = S.VSL_CD" ).append("\n"); 
		query.append("   AND H.VOY_NO     = S.VOY_NO" ).append("\n"); 
		query.append("   AND H.DIR_CD     = S.DIR_CD" ).append("\n"); 
		query.append("   AND H.REGION     = S.REGION" ).append("\n"); 
		query.append("   AND (S.OPR_CD, S.VSL_CD, S.VOY_NO, S.DIR_CD) IN " ).append("\n"); 
		query.append("        (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM CRR)" ).append("\n"); 
		query.append("   AND H.REGION     = @[sconti_cd]" ).append("\n"); 
		query.append("   AND S.CNTR_TYPE  = 'T'" ).append("\n"); 
		query.append(" GROUP BY S.POL, S.POD_ISO" ).append("\n"); 
		query.append("#elseif (${ioc_cd} == 'I')" ).append("\n"); 
		query.append("SELECT 'I' OI, M.POL AS FM_PORT_CD, M.POD_ISO AS TO_PORT_CD," ).append("\n"); 
		query.append("       SUM(DECODE(M.CNTR_SIZE,'2',1,'3',1,0))       USD_SLT_BSA_QTY_20," ).append("\n"); 
		query.append("       SUM(DECODE(M.CNTR_SIZE,'4',1,'H',1,'L',1,0)) USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("  FROM RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND H.VSL_CD     = M.VSL_CD " ).append("\n"); 
		query.append("   AND H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("   AND H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("   AND H.REGION     = M.REGION" ).append("\n"); 
		query.append("   AND M.CARGO_TYPE = 'IR'                 " ).append("\n"); 
		query.append("   AND (M.OPR_CD, M.VSL_CD, M.VOY_NO, M.DIR_CD) IN " ).append("\n"); 
		query.append("       (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM CRR)" ).append("\n"); 
		query.append("-- TDR의 인 경우 Inter 밖에 없고 Region 구분없이 가져오며 Region은 A로 setting한다." ).append("\n"); 
		query.append("#if (${rf_scg_stl_tp_cd} != 'T')" ).append("\n"); 
		query.append("   AND H.REGION = @[sconti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY M.POL, M.POD_ISO" ).append("\n"); 
		query.append(" UNION ALL " ).append("\n"); 
		query.append("SELECT 'I' OI, S.POL AS FM_PORT_CD, S.POD_ISO AS TO_PORT_CD," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE,'2',QTY,0)) USD_SLT_BSA_QTY_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE,'4',QTY,0)) USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("  FROM RDR_HEADER H, RDR_SUMMARY S" ).append("\n"); 
		query.append(" WHERE H.VSL_CD    = S.VSL_CD" ).append("\n"); 
		query.append("   AND H.VOY_NO    = S.VOY_NO" ).append("\n"); 
		query.append("   AND H.DIR_CD    = S.DIR_CD" ).append("\n"); 
		query.append("   AND H.REGION    = S.REGION" ).append("\n"); 
		query.append("   AND (S.OPR_CD, S.VSL_CD, S.VOY_NO, S.DIR_CD) IN " ).append("\n"); 
		query.append("        (SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM CRR)" ).append("\n"); 
		query.append("#if (${rf_scg_stl_tp_cd} != 'T')" ).append("\n"); 
		query.append("   AND H.REGION    = @[sconti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND S.CNTR_TYPE = 'I'" ).append("\n"); 
		query.append(" GROUP BY S.POL, S.POD_ISO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}