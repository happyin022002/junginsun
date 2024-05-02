/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOBkgAlocMgmtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOBkgAlocMgmtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgAlocMgmtVO
	  * </pre>
	  */
	public UserSetupMgtDBDAOBkgAlocMgmtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOBkgAlocMgmtVORSQL").append("\n"); 
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
		query.append("SELECT BKG_ALOC_SEQ" ).append("\n"); 
		query.append("     , BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("     , TRNK_SLAN_CD" ).append("\n"); 
		query.append("     , TRNK_DIR_CD" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , SLS_RHQ_CD" ).append("\n"); 
		query.append("     , OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , BKG_POR_CNT_CD" ).append("\n"); 
		query.append("     , POR_CD" ).append("\n"); 
		query.append("     , POR_NOD_CD" ).append("\n"); 
		query.append("     , BKG_POR_SCC_CD" ).append("\n"); 
		query.append("     , BKG_POL_CNT_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POL_NOD_CD" ).append("\n"); 
		query.append("     , N1ST_TS_SLAN_CD" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAM.BKG_ALOC_TP_CD = 'S' ) N1ST_TS_POL_CD" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAM.BKG_ALOC_TP_CD = 'S' ) N1ST_TS_POD_CD" ).append("\n"); 
		query.append("     , N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("     , N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append("     , N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("     , N2ND_TS_SLAN_CD" ).append("\n"); 
		query.append("     , N2ND_TS_POL_CD" ).append("\n"); 
		query.append("     , N2ND_TS_POD_CD" ).append("\n"); 
		query.append("     , BKG_POD_CNT_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , POD_NOD_CD" ).append("\n"); 
		query.append("     , BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , DEL_NOD_CD" ).append("\n"); 
		query.append("     , BKG_DEL_SCC_CD" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CTRT_CUST_CNT_CD||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_CNT_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , (SELECT CMDT_NM FROM MDM_COMMODITY MDM WHERE BAM.CMDT_CD = MDM.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("     , TO_CHAR(SCG_GRP_CMDT_SEQ,'00') SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT PSGC.SCG_GRP_CMDT_DESC FROM PRI_SCG_GRP_CMDT PSGC WHERE PSGC.SVC_SCP_CD = 'TPW' AND PSGC.CHG_CD = 'GRI' AND PSGC.SCG_GRP_CMDT_SEQ = BAM.SCG_GRP_CMDT_SEQ AND ROWNUM = 1) SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("     , ALOC_LOD_QTY" ).append("\n"); 
		query.append("     , ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("     , ALOC_SVC_CD" ).append("\n"); 
		query.append("     , BKG_ALOC_RMK" ).append("\n"); 
		query.append("     , ALOC_USE_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("	 , '' LANE_CNT" ).append("\n"); 
		query.append("	 , '' DIR_CNT" ).append("\n"); 
		query.append("	 , '' CMDT_CNT" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAM.BKG_ALOC_TP_CD = 'T') TRUNK_POL_CD" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAM.BKG_ALOC_TP_CD = 'T') TRUNK_POD_CD" ).append("\n"); 
		query.append("FROM BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${bkg_aloc_tp_cd} != 'A')" ).append("\n"); 
		query.append("   AND BKG_ALOC_TP_CD = @[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trnk_slan_cd} != '')" ).append("\n"); 
		query.append("   AND TRNK_SLAN_CD LIKE '%'||@[trnk_slan_cd]||'%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("   AND SC_NO LIKE '%'||@[sc_no]||'%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${rfa_no} != '')" ).append("\n"); 
		query.append("   AND RFA_NO LIKE '%'||@[rfa_no]||'%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${cmdt_nm} != '')" ).append("\n"); 
		query.append("   AND CMDT_CD IN(SELECT CMDT_CD " ).append("\n"); 
		query.append("				    FROM MDM_COMMODITY" ).append("\n"); 
		query.append("				   WHERE CMDT_NM LIKE '%'||@[cmdt_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY BKG_ALOC_SEQ" ).append("\n"); 

	}
}