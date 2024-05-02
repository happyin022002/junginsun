/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetRfTdrRgnChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetRfTdrRgnChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * R/F TDR의 RGN변경시 단가를 조회한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetRfTdrRgnChangeRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetRfTdrRgnChangeRSQL").append("\n"); 
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
		query.append("SELECT H.PORT_CD AS FM_PORT_CD, D.POD AS TO_PORT_CD," ).append("\n"); 
		query.append("       SUM(DECODE(D.CNTR_SIZE,'2',1,'3',1,0)) USD_SLT_BSA_QTY_20," ).append("\n"); 
		query.append("       SUM(DECODE(D.CNTR_SIZE,'4',1,'H',1,'L',1,0)) USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("FROM   TDR_HEADER H, TDR_CNTR_DETAIL D" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    H.VSL_CD   = D.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO   = D.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD   = D.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD  = D.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND = D.CALL_IND" ).append("\n"); 
		query.append("AND    D.STATUS   = 'LS'" ).append("\n"); 
		query.append("AND    H.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    D.OPR_CD IN " ).append("\n"); 
		query.append("           (SELECT B.JO_CRR_CD" ).append("\n"); 
		query.append("            FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("            		SELECT DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("            		FROM   DUAL" ).append("\n"); 
		query.append("            		UNION  ALL" ).append("\n"); 
		query.append("            		SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("            		FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("            		WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("            		AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("            		AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd])" ).append("\n"); 
		query.append("            		AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("            		AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("                   ) B" ).append("\n"); 
		query.append("            WHERE  A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("            AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("            AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("            AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("            AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("            AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("            AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("            AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("            AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("            AND    A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("            AND    A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND    A.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("AND    D.TEMP IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY H.PORT_CD, D.POD" ).append("\n"); 

	}
}