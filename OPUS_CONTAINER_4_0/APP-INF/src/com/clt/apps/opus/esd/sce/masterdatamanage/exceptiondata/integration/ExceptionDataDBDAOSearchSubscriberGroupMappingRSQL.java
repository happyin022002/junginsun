/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchSubscriberGroupMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.22 이중환
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

public class ExceptionDataDBDAOSearchSubscriberGroupMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select group map
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchSubscriberGroupMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("h_expt_tp_dtl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchSubscriberGroupMappingRSQL").append("\n"); 
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
		query.append("grp.COP_EXPT_SUBSC_CS_SEQ COP_EXPT_SUBSC_CS_SEQ," ).append("\n"); 
		query.append("tp1.expt_cd r_expt_tp," ).append("\n"); 
		query.append("tp1.expt_cd_nm cop_expt_tp_nm," ).append("\n"); 
		query.append("tp1.expt_cd_desc expt_tp_desc," ).append("\n"); 
		query.append("tp2.expt_cd r_expt_tp_dtl," ).append("\n"); 
		query.append("tp2.expt_cd_nm cop_expt_tp_dtl_nm," ).append("\n"); 
		query.append("tp2.expt_cd_desc cop_expt_tp_dtl_desc," ).append("\n"); 
		query.append("case when substr(tp3.expt_cd, 4, 1 ) = '1' then tp3.expt_cd else '' end r_fm_act," ).append("\n"); 
		query.append("case when substr(tp3.expt_cd, 4, 1 ) = '1' then tp3.expt_cd_nm else '' end fm_act_nm," ).append("\n"); 
		query.append("case when substr(tp3.expt_cd, 4, 1 ) = '1' then tp3.expt_cd_desc else '' end fm_act_desc," ).append("\n"); 
		query.append("case when substr(tp.expt_cd, 4, 1 ) = '2' then tp.expt_cd else '' end r_to_act," ).append("\n"); 
		query.append("case when substr(tp.expt_cd, 4, 1 ) = '2' then tp.expt_cd_nm else '' end to_act_nm," ).append("\n"); 
		query.append("case when substr(tp.expt_cd, 4, 1 ) = '2' then tp.expt_cd_desc else '' end to_act_desc," ).append("\n"); 
		query.append("grp.cop_expt_subsc_grp_cd r_subseq_grp," ).append("\n"); 
		query.append("case when grp.cop_expt_subsc_grp_cd = 'L' then 'Logistics Operation'" ).append("\n"); 
		query.append("else case when grp.cop_expt_subsc_grp_cd = 'C' then 'Customer Service'" ).append("\n"); 
		query.append("else case when grp.cop_expt_subsc_grp_cd = 'U' then 'US Rail Tracing'" ).append("\n"); 
		query.append("else '' end end" ).append("\n"); 
		query.append("end cop_expt_subsc_grp_nm, /*cop_expt_subsc_grp_nm*/" ).append("\n"); 
		query.append("grp.subsc_grp_ntfd_pty_cd r_noti_prty," ).append("\n"); 
		query.append("case when grp.subsc_grp_ntfd_pty_cd = '1' then 'BKG Create Office'" ).append("\n"); 
		query.append("else case when grp.subsc_grp_ntfd_pty_cd = '2' then 'BKG POR Office'" ).append("\n"); 
		query.append("else case when grp.subsc_grp_ntfd_pty_cd = '3' then 'BKG POL Office'" ).append("\n"); 
		query.append("else case when grp.subsc_grp_ntfd_pty_cd = '4' then 'BKG POD Office'" ).append("\n"); 
		query.append("else case when grp.subsc_grp_ntfd_pty_cd = '5' then 'BKG DEL Office'" ).append("\n"); 
		query.append("else case when grp.subsc_grp_ntfd_pty_cd = '6' then 'Exception Office'" ).append("\n"); 
		query.append("else case when grp.subsc_grp_ntfd_pty_cd = '7' then 'US Rail Office'" ).append("\n"); 
		query.append("end end end end end end end subsc_grp_ntfd_pty_nm, /*subsc_grp_ntfd_pty_nm*/" ).append("\n"); 
		query.append("grp.cre_usr_id," ).append("\n"); 
		query.append("grp.upd_usr_id r_usr_id," ).append("\n"); 
		query.append("TO_CHAR(grp.UPD_DT, 'YYYY/MM/DD HH24:MI') r_upd_dt," ).append("\n"); 
		query.append("grp.act_flg r_act" ).append("\n"); 
		query.append(",fa.act_nm fm_act_desc" ).append("\n"); 
		query.append(",ta.act_nm to_act_desc" ).append("\n"); 
		query.append("from sce_expt_subsc_mst_grp grp, sce_expt_cd tp, mdm_activity fa, mdm_activity ta," ).append("\n"); 
		query.append("( select * from sce_expt_cd where substr(expt_cd, 2, length(expt_cd) ) = '0000000' and act_flg = 'Y' ) tp1," ).append("\n"); 
		query.append("( select * from sce_expt_cd where substr(expt_cd, 4, length(expt_cd) ) = '00000' and act_flg = 'Y' ) tp2," ).append("\n"); 
		query.append("( select  expt_cd, substr(expt_cd, 1, 3 )||substr(expt_cd, 5, 2 ) expt_cd1, expt_cd_nm, expt_cd_desc" ).append("\n"); 
		query.append("from sce_expt_cd where substr(expt_cd, 4, 1 ) = '1' and act_flg = 'Y' ) tp3" ).append("\n"); 
		query.append("where grp.expt_cd = tp.expt_cd" ).append("\n"); 
		query.append("and substr(grp.expt_cd, 1, 1 ) = substr(tp1.expt_cd, 1, 1 )" ).append("\n"); 
		query.append("and substr(grp.expt_cd, 1, 3 ) = substr(tp2.expt_cd, 1, 3 )" ).append("\n"); 
		query.append("and substr(grp.expt_cd, 1, 3 )||substr(grp.expt_cd, 5, 2 ) = tp3.expt_cd1" ).append("\n"); 
		query.append("and tp.act_flg = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${h_expt_tp} != '')" ).append("\n"); 
		query.append("AND substr(tp.expt_cd, 1, 1 ) = @[h_expt_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${h_expt_tp_dtl} != '')" ).append("\n"); 
		query.append("AND substr(tp.expt_cd, 1, 3 ) = @[h_expt_tp_dtl]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and fa.act_cd(+) = DECODE(substr(tp3.expt_cd, 4, 1 ),'1',tp3.expt_cd_nm)" ).append("\n"); 
		query.append("and ta.act_cd(+) = DECODE(substr(tp.expt_cd, 4, 1 ),'2',tp.expt_cd_nm)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by  tp.expt_cd" ).append("\n"); 

	}
}