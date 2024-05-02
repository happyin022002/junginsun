/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderDetailDBDAOmodifyWorkOrderDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderDetailDBDAOmodifyWorkOrderDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modify Work Order Detail
	  * </pre>
	  */
	public WorkOrderDetailDBDAOmodifyWorkOrderDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOmodifyWorkOrderDetailUSQL").append("\n"); 
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
		query.append("UPDATE  trs_trsp_svc_ord so" ).append("\n"); 
		query.append("SET	apnt_dt	 = TO_DATE( @[apnt_dt] , 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("de_dt	 = TO_DATE( @[de_dt] , 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("eq_no = @[eq_no]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("eq_tpsz_cd = (case when @[eq_tpsz_cd] = 'D4' OR @[eq_tpsz_cd] = 'D5' then @[eq_tpsz_cd]" ).append("\n"); 
		query.append("else so.eq_tpsz_cd" ).append("\n"); 
		query.append("end)" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND  so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND  so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 

	}
}