/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGTAuditDBDAOSearchAPActualInterfaceMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSearchAPActualInterfaceMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPActualInterfaceMaster
	  * </pre>
	  */
	public AGTAuditDBDAOSearchAPActualInterfaceMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchAPActualInterfaceMasterRSQL").append("\n"); 
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
		query.append("A.COMM_APRO_NO," ).append("\n"); 
		query.append("A.INV_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.VVD_CNT," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.NET_AMT," ).append("\n"); 
		query.append("A.VAT," ).append("\n"); 
		query.append("A.TOT_AMT," ).append("\n"); 
		query.append("C.CSR_NO," ).append("\n"); 
		query.append("A.AC_IF_DT," ).append("\n"); 
		query.append("(SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE C.INTG_CD_ID = 'CD02355'" ).append("\n"); 
		query.append("AND C.INTG_CD_VAL_CTNT = NVL(C.INV_STS_CD, '')" ).append("\n"); 
		query.append(")                     AS IF_FLG_MSG," ).append("\n"); 
		query.append("CASE B.RCV_ERR_FLG" ).append("\n"); 
		query.append("WHEN 'Y'" ).append("\n"); 
		query.append("THEN 'Success'" ).append("\n"); 
		query.append("ELSE B.RCV_ERR_RSN" ).append("\n"); 
		query.append("END                     AS RCV_ERR_FLG_MSG," ).append("\n"); 
		query.append("CASE substr(B.IF_ERR_RSN,0,20)" ).append("\n"); 
		query.append("WHEN 'Duplicate CSR Number'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE B.IF_FLG" ).append("\n"); 
		query.append("END                     AS IF_FLG," ).append("\n"); 
		query.append("B.RCV_ERR_FLG," ).append("\n"); 
		query.append("B.PAY_AMT," ).append("\n"); 
		query.append("B.PAY_DT," ).append("\n"); 
		query.append("B.FTU_USE_CTNT1," ).append("\n"); 
		query.append("B.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("C.INV_STS_CD STATUS_CD, --2012.03.05 권상준 추가" ).append("\n"); 
		query.append("C.INV_RGST_NO           --2012.03.05 권상준 추가" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("COMM_APRO_NO," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("COUNT(DISTINCT COMM_VSL_CD||COMM_SKD_VOY_NO||COMM_SKD_DIR_CD||COMM_REV_DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("ROUND(SUM(ACT_IF_LOCL_COMM_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("ROUND(SUM(ACT_IF_LOCL_COMM_AMT * NVL(INV_TAX_RT, 0) / 100), DECODE(CURR_CD, 'JPY', 0, 2)) AS VAT," ).append("\n"); 
		query.append("ROUND(SUM(ACT_IF_LOCL_COMM_AMT + (ACT_IF_LOCL_COMM_AMT * NVL(INV_TAX_RT, 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) AS TOT_AMT," ).append("\n"); 
		query.append("CSR_NO," ).append("\n"); 
		query.append("TO_CHAR(AC_IF_DT, 'YYYYMMDD') AS AC_IF_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE AR_OFC_CD           = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND AGN_CD              = @[agn_cd]" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD    = @[if_option]" ).append("\n"); 
		query.append("AND CRE_USR_ID         <> 'COST'  -- 2007.05.07 이전데이터는 검색대상에서 제외" ).append("\n"); 
		query.append("-- Exp.Type = 'G:General', 'E:General Exception'" ).append("\n"); 
		query.append("#if(${exp_type} == 'G')" ).append("\n"); 
		query.append("AND COMM_STND_COST_CD   IN ('512611','512621','512631','512641','512661','512691')  -- General" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND COMM_STND_COST_CD   IN ('512692','512693')  -- General Exception" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Status = 'AS:Audited OK', 'IF:Interface OK'" ).append("\n"); 
		query.append("#if(${if_option} == 'AS')" ).append("\n"); 
		query.append("AND AC_APRO_DT          >= TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND AC_APRO_DT          <  TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD') + 1  -- AS(Audit Success)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND AC_IF_DT            >= TO_DATE(REPLACE(@[search_dt_fr],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND AC_IF_DT            <  TO_DATE(REPLACE(@[search_dt_to],'-', ''),'YYYYMMDD') + 1  -- IF(Interface Success)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("COMM_APRO_NO," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CSR_NO," ).append("\n"); 
		query.append("TO_CHAR(AC_IF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("AP_INV_HDR B," ).append("\n"); 
		query.append("AP_PAY_INV C	--2012.03.05 권상준 추가" ).append("\n"); 
		query.append("WHERE A.CSR_NO = B.CSR_NO(+)" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO = C.INV_NO(+) --2012.03.05 권상준 추가" ).append("\n"); 
		query.append("AND C.DELT_FLG(+) = 'N' --2012.03.05 권상준 추가" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}