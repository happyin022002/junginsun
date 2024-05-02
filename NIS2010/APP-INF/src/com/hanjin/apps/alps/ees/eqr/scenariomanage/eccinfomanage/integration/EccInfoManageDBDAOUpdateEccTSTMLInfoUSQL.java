/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccInfoManageDBDAOUpdateEccTSTMLInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EccInfoManageDBDAOUpdateEccTSTMLInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_TS_TML 테이블 데이터 수정
	  * </pre>
	  */
	public EccInfoManageDBDAOUpdateEccTSTMLInfoUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_20ft_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_40ft_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_45ft_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE EQR_SCNR_TS_TML SET" ).append("\n"); 
		query.append("TS_20FT_UC_AMT   = @[ts_20ft_uc_amt]," ).append("\n"); 
		query.append("TS_40FT_UC_AMT   = @[ts_40ft_uc_amt]," ).append("\n"); 
		query.append("TS_45FT_UC_AMT   = @[ts_45ft_uc_amt]," ).append("\n"); 
		query.append("UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT    		 = SYSDATE" ).append("\n"); 
		query.append("WHERE SCNR_ID	 	 = @[scnr_id]" ).append("\n"); 
		query.append("AND   ECC_CD	 	 = @[ecc_cd]" ).append("\n"); 
		query.append("AND   FM_SLAN_CD 	 = @[fm_slan_cd]" ).append("\n"); 
		query.append("AND   TO_SLAN_CD 	 = @[to_slan_cd]" ).append("\n"); 
		query.append("AND   LANE_DIR_CD	 = @[lane_dir_cd]" ).append("\n"); 
		query.append("AND   FM_YD_CD   	 = @[fm_yd_cd]" ).append("\n"); 
		query.append("AND   TO_YD_CD   	 = @[to_yd_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.scenariomanage.eccinfomanage.integration").append("\n"); 
		query.append("FileName : EccInfoManageDBDAOUpdateEccTSTMLInfoUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}