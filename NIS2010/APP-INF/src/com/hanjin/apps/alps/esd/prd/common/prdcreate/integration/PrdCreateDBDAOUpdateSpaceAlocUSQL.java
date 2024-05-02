/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateDBDAOUpdateSpaceAlocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.18 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateDBDAOUpdateSpaceAlocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateSpaceAloc
	  * </pre>
	  */
	public PrdCreateDBDAOUpdateSpaceAlocUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dst_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration ").append("\n"); 
		query.append("FileName : PrdCreateDBDAOUpdateSpaceAlocUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("SET (GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC)" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(CTRL_TS_FLG,'N',NULL,ALOC.ALOC_TTL_QTY - BKG.BKG_TTL_QTY) GENERAL," ).append("\n"); 
		query.append("DECODE(CTRL_TS_FLG,'N',NULL,DECODE((SELECT CTRL_45FT_HC_FLG FROM  SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd] )," ).append("\n"); 
		query.append("'N',NULL, ALOC.ALOC_45FT_HC_QTY-BKG.BKG_45FT_HC_QTY)) D7," ).append("\n"); 
		query.append("DECODE(CTRL_TS_FLG,'N',NULL,DECODE((SELECT CTRL_RF_FLG FROM  SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd] )," ).append("\n"); 
		query.append("'N',NULL, ALOC.ALOC_RF_QTY-BKG.BKG_RF_QTY)) RF" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(BKG_AVAL_TTL_QTY) ALOC_TTL_QTY," ).append("\n"); 
		query.append("SUM(BKG_AVAL_45FT_HC_QTY) ALOC_45FT_HC_QTY," ).append("\n"); 
		query.append("SUM(BKG_AVAL_RF_QTY) ALOC_RF_QTY," ).append("\n"); 
		query.append("MAX(DECODE(@[ts_flg],'N','Y',NVL((" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM SPC_TS_ALOC_LANE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BSE_YR||BSE_MON = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COST_YRMON" ).append("\n"); 
		query.append("FROM COA_MON_VVD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRD_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRD_CD" ).append("\n"); 
		query.append("FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_SLAN_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND IOC_CD = DECODE(@[org_conti_cd],@[dest_conti_cd],'I','O')" ).append("\n"); 
		query.append("AND FM_CONTI_CD = @[org_conti_cd]" ).append("\n"); 
		query.append("AND TO_CONTI_CD = @[dest_conti_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND IOC_CD = DECODE(@[org_conti_cd],@[dest_conti_cd],'I','O')" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("AND RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SLS_RHQ_CD = (SELECT N2ND_PRNT_OFC_CD FROM SPC_ORGANIZATION_V WHERE OFC_CD=@[sls_ofc])),'N'))) CTRL_TS_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1' TP," ).append("\n"); 
		query.append("SUM(ASGN_TTL_QTY) BKG_AVAL_TTL_QTY," ).append("\n"); 
		query.append("SUM(ASGN_45FT_HC_QTY) BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("SUM(ASGN_RF_QTY) BKG_AVAL_RF_QTY" ).append("\n"); 
		query.append("FROM SPC_ALOC_POL_POD A" ).append("\n"); 
		query.append("WHERE A.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND   A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   A.SLS_RGN_OFC_CD = (SELECT N4TH_PRNT_OFC_CD FROM SPC_ORGANIZATION_V WHERE OFC_CD = @[sls_ofc] )" ).append("\n"); 
		query.append("AND   A.TS_FLG = @[ts_flg]" ).append("\n"); 
		query.append("AND   A.POL_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[org_node],1,5),A.POL_CD)" ).append("\n"); 
		query.append("AND   A.POD_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[dst_node],1,5),A.POD_CD)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'2' TP," ).append("\n"); 
		query.append("NVL(SUM(BKG_AVAL_TTL_QTY),0) * -1 BKG_AVAL_TTL_QTY," ).append("\n"); 
		query.append("NVL(SUM(BKG_AVAL_45FT_HC_QTY),0)* -1 BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("NVL(SUM(BKG_AVAL_RF_QTY),0)* -1 BKG_AVAL_RF_QTY" ).append("\n"); 
		query.append("FROM SPC_ALOC_GNTE A" ).append("\n"); 
		query.append("WHERE A.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND   A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   A.SLS_OFC_CD = (SELECT N4TH_PRNT_OFC_CD FROM SPC_ORGANIZATION_V WHERE OFC_CD = @[sls_ofc] )" ).append("\n"); 
		query.append("AND   A.POL_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[org_node],1,5),A.POL_CD)" ).append("\n"); 
		query.append("AND   A.POD_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[dst_node],1,5),A.POD_CD)" ).append("\n"); 
		query.append("AND   DECODE(@[ts_flg],'Y','0','1') = DECODE(@[ts_flg],'Y','1','1')" ).append("\n"); 
		query.append("AND   NOT EXISTS(SELECT  'X'" ).append("\n"); 
		query.append("FROM  SAQ_MON_CUST_SPC_GNTE B" ).append("\n"); 
		query.append("WHERE (BSE_YR,BSE_WK) = (SELECT SUBSTR(COST_YRMON,1,4),COST_WK" ).append("\n"); 
		query.append("FROM COA_MON_VVD M" ).append("\n"); 
		query.append("WHERE M.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND   M.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND   M.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   M.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND   M.TRD_CD  = SAQ_GET_REP_TRD_FNC(@[r_lane_cd]))" ).append("\n"); 
		query.append("AND   CUST_CNT_CD = DECODE(@[cust_cnt_cd],'',@[shpr_cnt_cd],@[cust_cnt_cd])" ).append("\n"); 
		query.append("AND   CUST_SEQ = DECODE(@[cust_cnt_cd],'',@[shpr_seq],@[cust_seq])" ).append("\n"); 
		query.append("AND   RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("AND   DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("AND   SLS_OFC_CD = A.SLS_OFC_CD" ).append("\n"); 
		query.append("AND   DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir_cd] ),'Y',POL_CD,'1')" ).append("\n"); 
		query.append("= DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir_cd] ),'Y',SUBSTR(@[org_node],1,5),'1')" ).append("\n"); 
		query.append("AND   NVL(CRNT_TTL_CFM_QTY,0)+NVL(CRNT_40FT_HC_CFM_QTY,0)+NVL(CRNT_45FT_HC_CFM_QTY,0)+NVL(CRNT_RF_CFM_QTY,0) >0)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") ALOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(BKG_TTL_QTY) BKG_TTL_QTY," ).append("\n"); 
		query.append("SUM(BKG_45FT_HC_QTY) BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("SUM(BKG_RF_QTY) BKG_RF_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(S.BKG_TTL_QTY) BKG_TTL_QTY," ).append("\n"); 
		query.append("SUM(BKG_45FT_HC_QTY) BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("SUM(BKG_RF_QTY) BKG_RF_QTY" ).append("\n"); 
		query.append("FROM SPC_BKG_V S" ).append("\n"); 
		query.append("WHERE S.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND S.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("AND S.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND S.SLS_RGN_OFC_CD = (SELECT N4TH_PRNT_OFC_CD FROM SPC_ORGANIZATION_V WHERE OFC_CD = @[sls_ofc] )" ).append("\n"); 
		query.append("AND S.VSL_PRE_PST_CD IN ( DECODE(@[ts_flg],'N','T','S') ,DECODE(@[ts_flg],'N','T','U') )" ).append("\n"); 
		query.append("AND S.POL_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[org_node],1,5),S.POL_CD)" ).append("\n"); 
		query.append("AND S.POD_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[dst_node],1,5),S.POD_CD)" ).append("\n"); 
		query.append("AND S.TRD_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRD_CD" ).append("\n"); 
		query.append("FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_SLAN_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND IOC_CD = DECODE(@[org_conti_cd],@[dest_conti_cd],'I','O')" ).append("\n"); 
		query.append("AND FM_CONTI_CD = @[org_conti_cd]" ).append("\n"); 
		query.append("AND TO_CONTI_CD = @[dest_conti_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL(SUM(S.BKG_TTL_QTY),0) * -1 BKG_TTL_QTY," ).append("\n"); 
		query.append("NVL(SUM(BKG_45FT_HC_QTY),0) * -1 BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("NVL(SUM(BKG_RF_QTY),0) * -1 BKG_RF_QTY" ).append("\n"); 
		query.append("FROM SPC_BKG_V S ,  COA_BKG_INFO E" ).append("\n"); 
		query.append("WHERE S.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND S.SLAN_CD = @[lane]" ).append("\n"); 
		query.append("AND S.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND S.SLS_RGN_OFC_CD = (SELECT N4TH_PRNT_OFC_CD FROM SPC_ORGANIZATION_V WHERE OFC_CD = @[sls_ofc] )" ).append("\n"); 
		query.append("AND S.VSL_PRE_PST_CD IN ( DECODE(@[ts_flg],'N','T','S') ,DECODE(@[ts_flg],'N','T','U') )" ).append("\n"); 
		query.append("AND S.POL_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[org_node],1,5),S.POL_CD)" ).append("\n"); 
		query.append("AND S.POD_CD = DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO= @[voy_no]" ).append("\n"); 
		query.append("AND  SKD_DIR_CD =@[dir_cd]" ).append("\n"); 
		query.append("AND RLANE_CD =@[r_lane_cd]),'Y',SUBSTR(@[dst_node],1,5),S.POD_CD)" ).append("\n"); 
		query.append("AND S.TRD_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRD_CD" ).append("\n"); 
		query.append("FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_SLAN_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND IOC_CD = DECODE(@[org_conti_cd],@[dest_conti_cd],'I','O')" ).append("\n"); 
		query.append("AND FM_CONTI_CD = @[org_conti_cd]" ).append("\n"); 
		query.append("AND TO_CONTI_CD = @[dest_conti_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND S.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("AND S.BKG_NO_SPLIT = E.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("AND   EXISTS(SELECT  'X'" ).append("\n"); 
		query.append("FROM  SAQ_MON_CUST_SPC_GNTE G" ).append("\n"); 
		query.append("WHERE (BSE_YR,BSE_WK)= (SELECT SUBSTR(COST_YRMON,1,4), COST_WK" ).append("\n"); 
		query.append("FROM COA_MON_VVD M" ).append("\n"); 
		query.append("WHERE M.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND   M.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND   M.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   M.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND   M.TRD_CD  = SAQ_GET_REP_TRD_FNC(@[r_lane_cd]))" ).append("\n"); 
		query.append("AND   CUST_CNT_CD = E.AGMT_CNT_CD" ).append("\n"); 
		query.append("AND   CUST_SEQ = E.AGMT_CUST_SEQ" ).append("\n"); 
		query.append("AND   RLANE_CD = S.RLANE_CD" ).append("\n"); 
		query.append("AND   DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   SLS_OFC_CD = S.SLS_OFC_CD" ).append("\n"); 
		query.append("AND   DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir_cd] ),'Y',POL_CD,'1')" ).append("\n"); 
		query.append("= DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir_cd] ),'Y',SUBSTR(@[org_node],1,5),'1')" ).append("\n"); 
		query.append("AND   NVL(CRNT_TTL_CFM_QTY,0) +NVL(CRNT_40FT_HC_CFM_QTY,0) +NVL(CRNT_45FT_HC_CFM_QTY,0) +NVL(CRNT_RF_CFM_QTY,0) >0)" ).append("\n"); 
		query.append("AND   NOT EXISTS(SELECT  'X'" ).append("\n"); 
		query.append("FROM  SAQ_MON_CUST_SPC_GNTE G" ).append("\n"); 
		query.append("WHERE (BSE_YR,BSE_WK)= (SELECT SUBSTR(COST_YRMON,1,4), COST_WK" ).append("\n"); 
		query.append("FROM COA_MON_VVD M" ).append("\n"); 
		query.append("WHERE M.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND   M.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND   M.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   M.RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND   M.TRD_CD  = SAQ_GET_REP_TRD_FNC(@[r_lane_cd]))" ).append("\n"); 
		query.append("AND   CUST_CNT_CD = DECODE(@[cust_cnt_cd],'',@[shpr_cnt_cd],@[cust_cnt_cd])" ).append("\n"); 
		query.append("AND   CUST_SEQ = DECODE(@[cust_cnt_cd],'',@[shpr_seq],@[cust_seq])" ).append("\n"); 
		query.append("AND   RLANE_CD = S.RLANE_CD" ).append("\n"); 
		query.append("AND   DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   SLS_OFC_CD = S.SLS_OFC_CD" ).append("\n"); 
		query.append("AND   DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir_cd] ),'Y',POL_CD,'1')" ).append("\n"); 
		query.append("= DECODE((SELECT CTRL_PORT_FLG FROM SPC_ALOC_CTRL_OPT" ).append("\n"); 
		query.append("WHERE RLANE_CD = @[r_lane_cd]" ).append("\n"); 
		query.append("AND VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir_cd] ),'Y',SUBSTR(@[org_node],1,5),'1')" ).append("\n"); 
		query.append("AND   NVL(CRNT_TTL_CFM_QTY,0) +NVL(CRNT_40FT_HC_CFM_QTY,0) +NVL(CRNT_45FT_HC_CFM_QTY,0) +NVL(CRNT_RF_CFM_QTY,0) >0)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") BKG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PCTL_NO = @[pctl_no] AND PCTL_SEQ = @[pctl_seq]" ).append("\n"); 

	}
}