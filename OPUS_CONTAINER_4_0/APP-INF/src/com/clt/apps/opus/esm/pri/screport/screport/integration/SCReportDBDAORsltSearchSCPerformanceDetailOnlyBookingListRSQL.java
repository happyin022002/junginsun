/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerformanceDetailOnlyBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.26 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCPerformanceDetailOnlyBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSCPerformanceDetailOnlyBookingList
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerformanceDetailOnlyBookingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerformanceDetailOnlyBookingListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("TR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/* PK : SLAN_CD, DIR_CD, FM_CONTI, TO_CONTI */" ).append("\n"); 
		query.append("SELECT  VSL_SLAN_CD, VSL_SLAN_DIR_CD, FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD, RLANE_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  RL.VSL_SLAN_CD, DL.VSL_SLAN_DIR_CD, DL.FM_CONTI_CD, DL.TO_CONTI_CD, DL.TRD_CD, DL.SUB_TRD_CD, DL.RLANE_CD" ).append("\n"); 
		query.append("/* DELETE 되지 않고, I/O 가 정상적인 것이 우선 적용됨 */" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER ( PARTITION BY RL.VSL_SLAN_CD, DL.VSL_SLAN_DIR_CD, DL.FM_CONTI_CD, DL.TO_CONTI_CD ORDER BY DL.DELT_FLG, DECODE(FM_CONTI_CD, TO_CONTI_CD, DECODE(IOC_CD, 'I', 1, 2), DECODE(IOC_CD, 'O', 1 ,2)) ) ROW_NUMBER" ).append("\n"); 
		query.append("FROM    MDM_REV_LANE      RL  ," ).append("\n"); 
		query.append("MDM_DTL_REV_LANE  DL" ).append("\n"); 
		query.append("WHERE   DL.RLANE_CD   = RL.RLANE_CD" ).append("\n"); 
		query.append("AND     RL.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("AND     TRD_CD     LIKE @[trd_cd] || '%' -- trade" ).append("\n"); 
		query.append("AND     SUB_TRD_CD LIKE @[sub_trd_cd] || '%' -- sub trade" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("BK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  TRD_CD ,SKD_DIR_CD ,SUB_TRD_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",SVC_SCP_CD ,CMDT_CD ,AGMT_ACT_CNT_CD ,AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  BK.SVC_SCP_CD ,BK.CMDT_CD ,BK.AGMT_ACT_CNT_CD ,DECODE(BK.AGMT_ACT_CNT_CD, NULL, 0, BK.AGMT_ACT_CUST_SEQ) AS AGMT_ACT_CUST_SEQ ,TR.TRD_CD" ).append("\n"); 
		query.append(",BK.SKD_DIR_CD ,TR.SUB_TRD_CD ,BK.SLAN_CD ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",CASE WHEN  L3.CNT_CD IN ( 'US', 'CA' ) AND BK.POD_CD = BK.DEL_CD AND BK.DE_TERM_CD NOT IN ( 'D', 'H' ) THEN 'PO'" ).append("\n"); 
		query.append("WHEN  L3.CNT_CD IN ( 'US', 'CA' ) THEN NVL(( SELECT SUBSTR(SVC_MOD_CD, 1, 2) FROM COA_USA_SVC_MOD A WHERE A.ORG_RGN_CD = L3.RGN_CD AND A.DEST_RGN_CD = L4.RGN_CD ), 'OT' )" ).append("\n"); 
		query.append("WHEN  L2.CNT_CD IN ( 'US', 'CA' ) AND BK.POL_CD = BK.POR_CD AND BK.RCV_TERM_CD NOT IN ( 'D', 'H' ) THEN 'PO'" ).append("\n"); 
		query.append("WHEN  L2.CNT_CD IN ( 'US', 'CA' ) THEN NVL(( SELECT SUBSTR(SVC_MOD_CD, 1, 2) FROM COA_USA_SVC_MOD A WHERE A.ORG_RGN_CD = L2.RGN_CD AND A.DEST_RGN_CD = L1.RGN_CD ), 'OT' )" ).append("\n"); 
		query.append("END  USA_SVC_MOD_CD" ).append("\n"); 
		query.append("/* PO, LO, IP, ML, OT */" ).append("\n"); 
		query.append(",BK.POR_CD ,BK.POL_CD ,BK.POD_CD ,BK.DEL_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  SUM( BQ.OP_CNTR_QTY * ( SELECT PRI_SC_FEU_CONV(BK.SVC_SCP_CD, BQ.CNTR_TPSZ_CD) FROM DUAL) )" ).append("\n"); 
		query.append("FROM    BKG_QUANTITY  BQ" ).append("\n"); 
		query.append("WHERE   BQ.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND     BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append(") AS OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BK    ," ).append("\n"); 
		query.append("BKG_BL_DOC  BB    ," ).append("\n"); 
		query.append("MDM_LOCATION  L1  ," ).append("\n"); 
		query.append("MDM_LOCATION  L2  ," ).append("\n"); 
		query.append("MDM_LOCATION  L3  ," ).append("\n"); 
		query.append("MDM_LOCATION  L4  ," ).append("\n"); 
		query.append("TR" ).append("\n"); 
		query.append("WHERE   BB.BKG_NO           = BK.BKG_NO" ).append("\n"); 
		query.append("AND     L1.LOC_CD           = BK.POR_CD" ).append("\n"); 
		query.append("AND     L2.LOC_CD           = BK.POL_CD" ).append("\n"); 
		query.append("AND     L3.LOC_CD           = BK.POD_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD           = BK.DEL_CD" ).append("\n"); 
		query.append("AND     TR.VSL_SLAN_CD      = BK.SLAN_CD" ).append("\n"); 
		query.append("AND     TR.VSL_SLAN_DIR_CD  = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     TR.FM_CONTI_CD      = L2.CONTI_CD" ).append("\n"); 
		query.append("AND     TR.TO_CONTI_CD      = L3.CONTI_CD" ).append("\n"); 
		query.append("AND     BK.BKG_STS_CD       = 'F'" ).append("\n"); 
		query.append("/* 조회 조건 */" ).append("\n"); 
		query.append("AND     BK.SC_NO        = @[sc_no]      -- sc_no" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND     BK.SKD_DIR_CD   = @[skd_dir_cd] -- direction" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND     BK.SLAN_CD      = @[slan_cd]    -- lane" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND     BK.VSL_CD       = @[vsl_cd]     -- vvd 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND     BK.SKD_VOY_NO   = @[skd_voy_no] -- vvd 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd_txt} != '')" ).append("\n"); 
		query.append("AND     BK.SKD_DIR_CD   = @[skd_dir_cd_txt] -- ?" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND     BK.POR_CD       = @[por_cd]     -- por" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND     BK.POL_CD       =  @[pol_cd]     -- pol" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND     BK.POD_CD       = @[pod_cd]     -- pod" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND     BK.DEL_CD       = @[del_cd]     -- del" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_obrd_dt_from} != '')" ).append("\n"); 
		query.append("AND     BB.BL_OBRD_DT >= TO_DATE(@[bl_obrd_dt_from], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_obrd_dt_to} != '')" ).append("\n"); 
		query.append("AND     BB.BL_OBRD_DT <= TO_DATE (@[bl_obrd_dt_to], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */  -- Period" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND     BK.SVC_SCP_CD   = @[svc_scp_cd]   -- SVC SCOPE CODE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE     USA_SVC_MOD_CD LIKE @[usa_svc_mod_cd] || '%' -- us mode" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRD_CD ,SKD_DIR_CD ,SUB_TRD_CD" ).append("\n"); 
		query.append("#if (${chk_slan_cd} != '')" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_vvd} != '')" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${chk_usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append(",USA_SVC_MOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_por_cd} != '')" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_pol_cd} != '')" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_pod_cd} != '')" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_del_cd} != '')" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SUM(OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  BK.TRD_CD ,BK.SKD_DIR_CD ,BK.SUB_TRD_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_slan_cd], NULL, NULL, BK.SLAN_CD)           		   AS SLAN_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_vvd], NULL, NULL, BK.VVD)                             AS VVD" ).append("\n"); 
		query.append("--,SC.SVC_SCP_CD" ).append("\n"); 
		query.append(",BK.SVC_SCP_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_usa_svc_mod_cd], NULL, NULL, BK.USA_SVC_MOD_CD)       AS USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_por_cd], NULL, NULL, BK.POR_CD)                       AS POR_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_pol_cd], NULL, NULL, BK.POL_CD)                       AS POL_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_pod_cd], NULL, NULL, BK.POD_CD)                       AS POD_CD" ).append("\n"); 
		query.append(",DECODE(@[chk_del_cd], NULL, NULL, BK.DEL_CD)                       AS DEL_CD" ).append("\n"); 
		query.append(",OP_CNTR_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    BK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("TRD_CD     ,SKD_DIR_CD        ,SUB_TRD_CD" ).append("\n"); 
		query.append("#if (${chk_slan_cd} != '')" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_vvd} != '')" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${chk_usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append(",USA_SVC_MOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_por_cd} != '')" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_pol_cd} != '')" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_pod_cd} != '')" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_del_cd} != '')" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}