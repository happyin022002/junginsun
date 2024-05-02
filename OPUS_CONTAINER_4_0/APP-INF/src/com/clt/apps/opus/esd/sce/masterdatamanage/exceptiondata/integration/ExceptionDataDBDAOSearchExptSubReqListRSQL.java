/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExptSubReqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.28 이중환
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

public class ExceptionDataDBDAOSearchExptSubReqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select exptsubreqlist
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExptSubReqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_expt_subsc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExptSubReqListRSQL").append("\n"); 
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
		query.append("COP_EXPT_SUBSC_CS_SEQ," ).append("\n"); 
		query.append("NTFD_OFC_CD r_ntfd_ofc_cd," ).append("\n"); 
		query.append("NTFD_SUBSC_ID r_global_id," ).append("\n"); 
		query.append("NTFD_SUBSC_NM r_name," ).append("\n"); 
		query.append("NTFD_SUBSC_USR_EML r_email," ).append("\n"); 
		query.append("ACT_FLG r_act," ).append("\n"); 
		query.append("UPD_USR_ID r_usr_id," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYY/MM/DD HH24:MI') r_upd_dt," ).append("\n"); 
		query.append("COP_EXPT_SUBSC_GRP_CD r_subsc_grp_cd," ).append("\n"); 
		query.append("SUBSC_GRP_NTFD_PTY_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD r_cnt_ofc" ).append("\n"); 
		query.append("from sce_expt_subsc_mst" ).append("\n"); 
		query.append("WHERE COP_EXPT_SUBSC_GRP_CD = NVL( @[cop_expt_subsc_grp_cd], COP_EXPT_SUBSC_GRP_CD)" ).append("\n"); 
		query.append("AND NTFD_OFC_CD = NVL ( @[ntfd_ofc_cd], NTFD_OFC_CD)" ).append("\n"); 

	}
}