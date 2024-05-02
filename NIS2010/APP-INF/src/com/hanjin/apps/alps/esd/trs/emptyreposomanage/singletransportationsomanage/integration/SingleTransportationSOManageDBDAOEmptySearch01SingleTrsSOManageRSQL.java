/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOEmptySearch01SingleTrsSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2012.06.13 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOEmptySearch01SingleTrsSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Repo S/O 조회 대상을 조회한다.
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOEmptySearch01SingleTrsSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOEmptySearch01SingleTrsSOManageRSQL").append("\n"); 
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
		query.append("SELECT X.*" ).append("\n"); 
		query.append(",SUBSTR (X.PRD_DIST, 1, INSTR (X.PRD_DIST, '/') - 1) LNK_DIST_DIV_CD" ).append("\n"); 
		query.append(",SUBSTR (X.PRD_DIST, INSTR (X.PRD_DIST, '/') + 1) TTL_DIST" ).append("\n"); 
		query.append("FROM ( SELECT A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.REF_ID," ).append("\n"); 
		query.append("A.REF_SEQ," ).append("\n"); 
		query.append("A.REPO_PURP_RMK," ).append("\n"); 
		query.append("DECODE(A.SO_IF_DIV_CD, 'O', 'CN', 'F', 'CF', 'ER')  TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("A.VSL_LANE_CD SLAN_CD," ).append("\n"); 
		query.append("DECODE(A.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME," ).append("\n"); 
		query.append("A.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("A.CNTR_NO ORG_EQ_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.FM_YD_CD FM_NOD_CD," ).append("\n"); 
		query.append("DECODE(A.SO_IF_DIV_CD, 'F', DECODE(OFF.OFFH_YD_CD, NULL, A.TO_YD_CD, OFF.OFFH_YD_CD), A.TO_YD_CD)  TO_NOD_CD," ).append("\n"); 
		query.append("DECODE(A.TRSP_MOD_CD, 'W', 'WD', 'T', 'TD', 'R', 'RD', '') TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("(B.AGMT_CTY_CD||B.AGMT_SEQ) LESSOR," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("B.IMDT_EXT_FLG," ).append("\n"); 
		query.append("B.OWNR_CO_CD OWNR_CO_CD," ).append("\n"); 
		query.append("B.CNTR_USE_CO_CD EQ_USED," ).append("\n"); 
		query.append("B.CNMV_STS_CD MOVEMENT_STS," ).append("\n"); 
		query.append("B.CRNT_YD_CD CREATION_YARD," ).append("\n"); 
		query.append("TO_CHAR(B.CNMV_DT,   'YYYYMMDD') EVENT_DATE," ).append("\n"); 
		query.append("LOC.CONTI_CD ," ).append("\n"); 
		query.append("A.SO_RQST_DT TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("'' INTER_RMK," ).append("\n"); 
		query.append("@[ofc_cty_cd] TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[ctrl_user_id] CRE_USR_ID," ).append("\n"); 
		query.append("@[ctrl_user_id] UPD_USR_ID," ).append("\n"); 
		query.append("TRNS_RQST_OFC_CD ," ).append("\n"); 
		query.append("TRNS_RQST_USR_ID ," ).append("\n"); 
		query.append("TRNS_RQST_RSN ," ).append("\n"); 
		query.append("DECODE( OFF.CNTR_NO, NULL, 'N', 'Y') LSE_CNTR_FLG ," ).append("\n"); 
		query.append("A.TO_YD_CD ORG_TO_YD_CD," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_PRD_DISTANCE_FNC( A.FM_YD_CD" ).append("\n"); 
		query.append(",DECODE(A.SO_IF_DIV_CD, 'F', DECODE(OFF.OFFH_YD_CD, NULL, A.TO_YD_CD, OFF.OFFH_YD_CD), A.TO_YD_CD)" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",DECODE(A.SO_IF_DIV_CD, 'O', 'CN', 'F', 'CF', 'ER')" ).append("\n"); 
		query.append(",DECODE(A.TRSP_MOD_CD, 'W', 'WD', 'T', 'TD', 'R', 'RD', '')" ).append("\n"); 
		query.append(") PRD_DIST" ).append("\n"); 
		query.append("FROM EQR_REPO_EXE_SO_IF A," ).append("\n"); 
		query.append("MST_CONTAINER B ," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("MDM_LOCATION LOC," ).append("\n"); 
		query.append("(SELECT CNTR_NO, OFFH_YD_CD" ).append("\n"); 
		query.append("FROM LSE_AVAL_OFFH" ).append("\n"); 
		query.append("WHERE OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND OFFH_STS_CD IN ('R','C') ) OFF" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = OFF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = SO.REPO_PLN_ID(+)" ).append("\n"); 
		query.append("AND A.PLN_YRWK = SO.PLN_YRWK(+)" ).append("\n"); 
		query.append("AND A.REF_ID = SO.REF_ID(+)" ).append("\n"); 
		query.append("AND A.REF_SEQ = SO.REF_SEQ(+)" ).append("\n"); 
		query.append("AND LOC.LOC_CD = SUBSTR(A.FM_YD_CD, 1, 5)" ).append("\n"); 
		query.append("AND NVL(SO.DELT_FLG(+),'N')  <>'Y'" ).append("\n"); 
		query.append("AND SO.TRSP_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND A.TRSP_MOD_CD IN ('T', 'R', 'W')" ).append("\n"); 
		query.append("AND A.WO_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.WO_EXE_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CO_CD = 'H'" ).append("\n"); 
		query.append("AND SO.HJL_NO IS NULL" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 1 FROM MDM_COUNTRY CNTY WHERE CNTY.CNT_CD != 'MX' AND A.TRSP_MOD_CD = 'R' AND LOC.CONTI_CD = 'M' AND LOC.CNT_CD = CNTY.CNT_CD)" ).append("\n"); 
		query.append("#if($arr_refid.size() > 0)" ).append("\n"); 
		query.append("AND A.REF_ID IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_refid})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_fmnode.size() > 0)" ).append("\n"); 
		query.append("AND A.FM_YD_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_fmnode})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_tonode.size() > 0)" ).append("\n"); 
		query.append("AND A.TO_YD_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_tonode})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_eq_tpsz.size() > 0)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_eq_tpsz})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_office.size() > 0)" ).append("\n"); 
		query.append("AND A.EQ_CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_office})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("UPPER('${key}')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", UPPER('${key}')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}