/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchToleranceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.16 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchToleranceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select to list
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchToleranceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("h_expt_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_expt_tp_dtl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchToleranceListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("tp1.expt_cd expt_tp," ).append("\n"); 
		query.append("tp1.expt_cd_nm expt_tp_nm," ).append("\n"); 
		query.append("tp1.expt_cd_desc expt_tp_desc," ).append("\n"); 
		query.append("tp2.expt_cd expt_tp_dtl," ).append("\n"); 
		query.append("tp2.expt_cd_nm expt_dtl_tp_nm," ).append("\n"); 
		query.append("tp2.expt_cd_desc expt_dtl_tp_desc," ).append("\n"); 
		query.append("case when substr(tp3.expt_cd, 4, 1 ) = '1' then tp3.expt_cd else '' end fm_act," ).append("\n"); 
		query.append("case when substr(tp3.expt_cd, 4, 1 ) = '1' then tp3.expt_cd_nm else '' end fm_act_nm," ).append("\n"); 
		query.append("case when substr(tp3.expt_cd, 4, 1 ) = '1' then tp3.expt_cd_desc else '' end fm_act_desc," ).append("\n"); 
		query.append("case when substr(tp.expt_cd, 4, 1 ) = '2' then tp.expt_cd else '' end to_act," ).append("\n"); 
		query.append("case when substr(tp.expt_cd, 4, 1 ) = '2' then tp.expt_cd_nm else '' end to_act_nm," ).append("\n"); 
		query.append("case when substr(tp.expt_cd, 4, 1 ) = '2' then tp.expt_cd_desc else '' end to_act_desc," ).append("\n"); 
		query.append("case when length(tol.YD_CD) = 5 or length(tol.YD_CD) = 3 then tol.YD_CD else '' end loc_cd," ).append("\n"); 
		query.append("case when length(tol.YD_CD) = 7 then tol.YD_CD else '' end nod_cd," ).append("\n"); 
		query.append("tol.FOML_PCT_NO," ).append("\n"); 
		query.append("tol.FOML_TM_DY FOML_TM_DYS," ).append("\n"); 
		query.append("tol.FOML_TM_HR FOML_TM_HRS," ).append("\n"); 
		query.append("tol.FOML_TM_MNT FOML_TM_MIN," ).append("\n"); 
		query.append("tol.EXPT_LOC_CD," ).append("\n"); 
		query.append("tol.cre_usr_id USR_ID," ).append("\n"); 
		query.append("tol.upd_usr_id," ).append("\n"); 
		query.append("TO_CHAR(tol.UPD_DT, 'YYYY/MM/DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("tol.act_flg ACT_FLG," ).append("\n"); 
		query.append("fa.act_nm fa_act_nm," ).append("\n"); 
		query.append("ta.act_nm ta_act_nm" ).append("\n"); 
		query.append("from SCE_EXPT_TOL tol, sce_expt_cd tp, mdm_activity fa, mdm_activity ta," ).append("\n"); 
		query.append("( select * from sce_expt_cd where substr(expt_cd, 2, length(expt_cd) ) = '0000000' and act_flg = 'Y' ) tp1," ).append("\n"); 
		query.append("( select * from sce_expt_cd where substr(expt_cd, 4, length(expt_cd) ) = '00000' and act_flg = 'Y' ) tp2," ).append("\n"); 
		query.append("( select  expt_cd, substr(expt_cd, 1, 3 )||substr(expt_cd, 5, 2 ) expt_cd1, expt_cd_nm, expt_cd_desc" ).append("\n"); 
		query.append("from sce_expt_cd where substr(expt_cd, 4, 1 ) = '1' and act_flg = 'Y' ) tp3" ).append("\n"); 
		query.append("where tol.expt_cd = tp.expt_cd" ).append("\n"); 
		query.append("and substr(tol.expt_cd, 1, 1 ) = substr(tp1.expt_cd, 1, 1 )" ).append("\n"); 
		query.append("and substr(tol.expt_cd, 1, 3 ) = substr(tp2.expt_cd, 1, 3 )" ).append("\n"); 
		query.append("and substr(tol.expt_cd, 1, 3 )||substr(tol.expt_cd, 5, 2 ) = tp3.expt_cd1" ).append("\n"); 
		query.append("and tp.act_flg = 'Y'" ).append("\n"); 
		query.append("and fa.act_cd(+) = DECODE(substr(tp3.expt_cd, 4, 1 ),'1',tp3.expt_cd_nm)" ).append("\n"); 
		query.append("and ta.act_cd(+) = DECODE(substr(tp.expt_cd, 4, 1 ),'2',tp.expt_cd_nm)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Country Code */" ).append("\n"); 
		query.append("#if (${cnt_cd} != \"\")" ).append("\n"); 
		query.append("AND  tol.YD_CD LIKE  @[cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Location Code */" ).append("\n"); 
		query.append("#if (${loc_cd} != \"\")" ).append("\n"); 
		query.append("AND   tol.YD_CD LIKE  @[loc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${h_expt_tp} != \"\")" ).append("\n"); 
		query.append("AND substr(tp.expt_cd, 1, 1 ) = @[h_expt_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${h_expt_tp_dtl} != \"\")" ).append("\n"); 
		query.append("AND substr(tp.expt_cd, 1, 3 ) = @[h_expt_tp_dtl]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by  tp.expt_cd" ).append("\n"); 

	}
}