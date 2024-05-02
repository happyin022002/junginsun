/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Expire Date 의 유효성을 체크하기 위한 조회용 쿼리.
	  * Before Booking 데이터의 Expire Date 보다 크거나 같다면 유효, 작다면 에러
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateByRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateByRFARSQL").append("\n"); 
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
		query.append("SELECT  RFA_TRF.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_RP_MN RP_MN" ).append("\n"); 
		query.append(",	PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_TRF RFA_TRF" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_TRF_DTL RFA_TRF_DTL" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_CVRG_CMB RFA_CVRG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   RP_MN.CTRT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND RP_MN.CTRT_CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("AND RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+	INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN)*/ AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_RP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND RP_MN.PROP_NO = RP_HDR.PROP_NO" ).append("\n"); 
		query.append("AND RP_HDR.PROP_NO = RFA_TRF.PROP_NO" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD IN ('A', 'O', 'R')" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_DAR_NO = RFA_TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_MAPG_SEQ = RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_VER_SEQ = RFA_TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.DMDT_TRF_CD IN ('CTIC', 'CTOC')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(RFA_TRF_DTL.EFF_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND RFA_TRF_DTL.EFF_DT <= TO_DATE(NVL(@[dul_expt_exp_dt], '99991231'), 'YYYYMMDD'))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(RFA_TRF_DTL.EFF_DT <= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND RFA_TRF_DTL.EXP_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_DAR_NO = RFA_CVRG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ = RFA_CVRG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_VER_SEQ = RFA_CVRG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_RQST_DTL_SEQ = RFA_CVRG.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("#if(${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("AND (	RFA_CVRG.CVRG_CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("#if(${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_RGN_CD = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_STE_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cvrg_ste_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_RGN_CD = ' '" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_STE_CD = @[cvrg_ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_LOC_CD = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RFA_TRF.PROP_NO = @[prop_no]" ).append("\n"); 

	}
}