/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmYardDBDAOAddPrdNodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmYardDBDAOAddPrdNodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddPrdNode
	  * </pre>
	  */
	public ReceiveQueueMdmYardDBDAOAddPrdNodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onf_hir_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmYardDBDAOAddPrdNodeCSQL").append("\n"); 
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
		query.append("INSERT INTO prd_node (" ).append("\n"); 
		query.append("nod_cd 	       ,nod_nm 	       ,nod_tp_cd      ,loc_cd 	       ," ).append("\n"); 
		query.append("onf_hir_yd_flg ,delt_flg       ,cre_usr_id     ,cre_dt 	       ," ).append("\n"); 
		query.append("upd_usr_id     ,upd_dt 	       ,eai_evnt_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES  (" ).append("\n"); 
		query.append("@[yd_cd] ,@[yd_nm] ," ).append("\n"); 
		query.append("#if(${yd_fcty_tp_psdo_yd_flg} =='Y')" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_mrn_tml_flg} =='Y')" ).append("\n"); 
		query.append("'M'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_brg_rmp_flg} =='Y')" ).append("\n"); 
		query.append("'B'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_rail_rmp_flg} =='Y')" ).append("\n"); 
		query.append("'R'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_cy_flg} =='Y')" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_cfs_flg} =='Y')" ).append("\n"); 
		query.append("'S'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_psdo_yd_flg} !='Y' &&" ).append("\n"); 
		query.append("${yd_fcty_tp_mrn_tml_flg} !='Y' &&" ).append("\n"); 
		query.append("${yd_fcty_tp_brg_rmp_flg} !='Y' &&" ).append("\n"); 
		query.append("${yd_fcty_tp_rail_rmp_flg} !='Y' &&" ).append("\n"); 
		query.append("${yd_fcty_tp_cy_flg} !='Y' &&" ).append("\n"); 
		query.append("${yd_fcty_tp_cfs_flg} !='Y' )" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[loc_cd] ," ).append("\n"); 
		query.append("@[onf_hir_yd_flg] ,@[delt_flg] ,@[cre_usr_id] ,to_date(@[cre_dt] ,'yyyymmddhh24miss')," ).append("\n"); 
		query.append("@[upd_usr_id] ,to_date(@[upd_dt] ,'yyyymmddhh24miss') ,to_date(@[eai_evnt_dt] ,'yyyymmddhh24miss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}