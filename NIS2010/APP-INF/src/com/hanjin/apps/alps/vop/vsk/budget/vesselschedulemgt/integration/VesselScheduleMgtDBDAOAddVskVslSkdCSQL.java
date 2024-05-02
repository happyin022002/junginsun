/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskVslSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskVslSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_SKD의 VVD 정보를 생성합니다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskVslSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psdo_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_port_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_usd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskVslSkdCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_BUD_VSL_SKD (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	VSL_SLAN_CD" ).append("\n"); 
		query.append(",	SKD_STS_CD" ).append("\n"); 
		query.append(",	SKD_VOY_TP_CD" ).append("\n"); 
		query.append(",	SKD_USD_IND_CD" ).append("\n"); 
		query.append(",	PF_SKD_TP_CD" ).append("\n"); 
		query.append(",	ST_PORT_CD" ).append("\n"); 
		query.append(",	N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append(",	PSDO_VVD_CD" ).append("\n"); 
		query.append(",	CO_CD" ).append("\n"); 
		query.append(",	SKD_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT @[vsl_cd]" ).append("\n"); 
		query.append("	   , @[skd_voy_no]" ).append("\n"); 
		query.append("	   , @[skd_dir_cd]" ).append("\n"); 
		query.append("	   , @[vsl_slan_cd]" ).append("\n"); 
		query.append("	   , @[skd_sts_cd]" ).append("\n"); 
		query.append("	   , DECODE(T1.VSL_SVC_TP_CD || DECODE(T2.VSL_OWN_IND_CD, 'O', 'O', 'C') || DECODE(T2.CRR_CD, 'SML', 'H', 'X')," ).append("\n"); 
		query.append("                'SOH', 'CJ', 'SCH', 'CV'," ).append("\n"); 
		query.append("                'SOX', 'CB', 'SCX', 'CB'," ).append("\n"); 
		query.append("                'JOH', 'CJ', 'JCH', 'CV'," ).append("\n"); 
		query.append("                'JOX', 'CA', 'JCX', 'CA'," ).append("\n"); 
		query.append("                'IOH', 'CI', 'ICH', 'CC'," ).append("\n"); 
		query.append("                'IOX', 'CA', 'ICX', 'CA'," ).append("\n"); 
		query.append("                'OOH', 'CJ', 'OCH', 'CV'," ).append("\n"); 
		query.append("                'OOX', 'CB', 'OCX', 'CB'" ).append("\n"); 
		query.append("         ) AS SKD_VOY_TP_CD" ).append("\n"); 
		query.append("	   , @[skd_usd_ind_cd]" ).append("\n"); 
		query.append("	   , @[pf_skd_tp_cd]" ).append("\n"); 
		query.append("	   , @[st_port_cd]" ).append("\n"); 
		query.append("	   , TO_DATE(@[n1st_port_brth_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	   , @[psdo_vvd_cd]" ).append("\n"); 
		query.append("	   , @[co_cd]" ).append("\n"); 
		query.append("	   , @[skd_rmk]" ).append("\n"); 
		query.append("	   , @[cre_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("       , @[upd_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("FROM   MDM_VSL_SVC_LANE T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    T1.VSL_SLAN_CD   = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND    T2.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    T1.VSL_TP_CD     = 'C' /*컨테이너선*/" ).append("\n"); 

	}
}