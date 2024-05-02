/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LeaseReportDBDAOTotalContainerInventoryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOTotalContainerInventoryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HJS의 관리하는 자가 및 임차장비의 상세내역을 조회합니다.
	  * </pre>
	  */
	public LeaseReportDBDAOTotalContainerInventoryDetailRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOTotalContainerInventoryDetailRSQL").append("\n"); 
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
		query.append("SELECT  /*+ INDEX(A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("        ROWNUM AS ROW_SEQ, C.LSTM_CD, A.AGMT_CTY_CD ||LTRIM(TO_CHAR(A.AGMT_SEQ, '000000')) AS AGMT_NO," ).append("\n"); 
		query.append("        C.REF_NO, A.CNTR_TPSZ_CD, A.CNTR_NO, " ).append("\n"); 
		query.append("        TO_CHAR(A.ONH_DT,'YYYYMMDD') AS ONH_DT," ).append("\n"); 
		query.append("        A.ONH_YD_CD, A.ONH_FREE_DYS, A.MIN_ONH_DYS," ).append("\n"); 
		query.append("        CASE WHEN C.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("             THEN ROUND(SYSDATE - A.MFT_DT)" ).append("\n"); 
		query.append("             ELSE ROUND(SYSDATE - A.ONH_DT) END USED_DYS," ).append("\n"); 
		query.append("        TO_CHAR(A.CNMV_DT,'YYYYMMDD') AS CNMV_DT, " ).append("\n"); 
		query.append("        A.CNTR_STS_CD, A.CNMV_STS_CD, A.CRNT_YD_CD" ).append("\n"); 
		query.append("        , T3.VNDR_ABBR_NM" ).append("\n"); 
		query.append("        , T2.BKG_NO" ).append("\n"); 
		query.append("        , T2.VSL_CD || T2.SKD_VOY_NO || T2.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , T2.POR_CD" ).append("\n"); 
		query.append("        , T2.POL_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T5.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS POL_ETD" ).append("\n"); 
		query.append("        , T2.POD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T6.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS POD_ETA" ).append("\n"); 
		query.append("        , T2.DEL_CD" ).append("\n"); 
		query.append("FROM    MST_CONTAINER       A" ).append("\n"); 
		query.append("        , LSE_AGREEMENT     C" ).append("\n"); 
		query.append("        , CTM_MOVEMENT      T1" ).append("\n"); 
		query.append("        , BKG_BOOKING       T2" ).append("\n"); 
		query.append("        , MDM_VENDOR        T3" ).append("\n"); 
		query.append("        , BKG_VVD           T4" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD  T5" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD  T6            " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.CNTR_NO           = T1.CNTR_NO        (+)" ).append("\n"); 
		query.append("AND     A.CNMV_YR           = T1.CNMV_YR        (+)" ).append("\n"); 
		query.append("AND     A.CNMV_ID_NO        = T1.CNMV_ID_NO     (+)" ).append("\n"); 
		query.append("AND     C.VNDR_SEQ          = T3.VNDR_SEQ       (+)" ).append("\n"); 
		query.append("AND     T1.BKG_NO           = T2.BKG_NO         (+)" ).append("\n"); 
		query.append("AND     T2.BKG_NO           = T4.BKG_NO         (+)" ).append("\n"); 
		query.append("AND     'T'                 = T4.VSL_PRE_PST_CD (+)" ).append("\n"); 
		query.append("AND     T4.VSL_CD           = T5.VSL_CD         (+)" ).append("\n"); 
		query.append("AND     T4.SKD_VOY_NO       = T5.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("AND     T4.SKD_DIR_CD       = T5.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("AND     T4.POL_CD           = T5.VPS_PORT_CD    (+)" ).append("\n"); 
		query.append("AND     T4.POL_CLPT_IND_SEQ = T5.CLPT_IND_SEQ   (+)" ).append("\n"); 
		query.append("AND     T4.VSL_CD           = T6.VSL_CD         (+)" ).append("\n"); 
		query.append("AND     T4.SKD_VOY_NO       = T6.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("AND     T4.SKD_DIR_CD       = T6.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("AND     T4.POD_CD           = T6.VPS_PORT_CD    (+)" ).append("\n"); 
		query.append("AND     T4.POD_CLPT_IND_SEQ = T6.CLPT_IND_SEQ   (+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD NOT IN ('LSO','DIO','DON','SCR','TLL','SLD','SRO')" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD       = C.AGMT_CTY_CD        " ).append("\n"); 
		query.append("AND     A.AGMT_SEQ          = C.AGMT_SEQ        " ).append("\n"); 
		query.append("AND     A.AGMT_SEQ         <> 999990" ).append("\n"); 
		query.append("AND     A.HJS_CRE_FLG      = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM            <= 1000" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND     A.CNTR_NO         > @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND     C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end						" ).append("\n"); 
		query.append("#if (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("AND     A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("AND     A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("AND     A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end						  " ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("    #if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("AND     A.LSTM_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("    #if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("    #if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}