/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DistanceCreationDBDAOmultiDistanceDeleteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.08.07 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DistanceCreationDBDAOmultiDistanceDeleteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiDistanceDelete
	  * </pre>
	  */
	public DistanceCreationDBDAOmultiDistanceDeleteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dist_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_zip_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_zip_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration").append("\n"); 
		query.append("FileName : DistanceCreationDBDAOmultiDistanceDeleteUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_DIST  SET" ).append("\n"); 
		query.append("dist_meas_ut_cd     =@[dist_meas_ut_cd]," ).append("\n"); 
		query.append("bzc_dist            =@[bzc_dist]," ).append("\n"); 
		query.append("conv_meas_ut_cd     =@[conv_meas_ut_cd]," ).append("\n"); 
		query.append("conv_dist           =@[conv_dist]," ).append("\n"); 
		query.append("fm_nod_zip_cd_ctnt  =@[fm_nod_zip_cd_ctnt]," ).append("\n"); 
		query.append("to_nod_zip_cd_ctnt  =@[to_nod_zip_cd_ctnt]," ).append("\n"); 
		query.append("delt_flg  = decode(@[del_gubun],'D','Y','N') ," ).append("\n"); 
		query.append("upd_usr_id          =@[cre_usr_id]," ).append("\n"); 
		query.append("upd_dt              = sysdate" ).append("\n"); 
		query.append("WHERE fm_nod_cd = @[fm_nod_cd]" ).append("\n"); 
		query.append("AND   to_nod_cd = @[to_nod_cd]" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 

	}
}