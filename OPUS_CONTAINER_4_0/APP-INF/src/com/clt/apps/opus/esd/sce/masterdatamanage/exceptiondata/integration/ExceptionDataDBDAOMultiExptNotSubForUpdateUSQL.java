/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOMultiExptNotSubForUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.29 이중환
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

public class ExceptionDataDBDAOMultiExptNotSubForUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update exptnotsub
	  * </pre>
	  */
	public ExceptionDataDBDAOMultiExptNotSubForUpdateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_act",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_global_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_subsc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_ntfd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_email",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cnt_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_expt_subsc_cs_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_name",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOMultiExptNotSubForUpdateUSQL").append("\n"); 
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
		query.append("update sce_expt_subsc_mst" ).append("\n"); 
		query.append("set NTFD_OFC_CD = @[r_ntfd_ofc_cd]" ).append("\n"); 
		query.append(",NTFD_SUBSC_ID = @[r_global_id]" ).append("\n"); 
		query.append(",NTFD_SUBSC_NM = @[r_name]" ).append("\n"); 
		query.append(",NTFD_SUBSC_USR_EML = @[r_email]" ).append("\n"); 
		query.append(",ACT_FLG = @[r_act]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[r_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",COP_EXPT_SUBSC_GRP_CD = @[r_subsc_grp_cd]" ).append("\n"); 
		query.append(",CTRL_OFC_CD = @[r_cnt_ofc]" ).append("\n"); 
		query.append("where COP_EXPT_SUBSC_CS_SEQ = @[cop_expt_subsc_cs_seq]" ).append("\n"); 

	}
}