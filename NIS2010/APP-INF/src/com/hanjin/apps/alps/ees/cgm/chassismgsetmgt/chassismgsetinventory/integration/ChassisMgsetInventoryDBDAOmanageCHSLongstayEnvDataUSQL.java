/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOmanageCHSLongstayEnvDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.23 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOmanageCHSLongstayEnvDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090722 1094 update query
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOmanageCHSLongstayEnvDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stay_dys_inp_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOmanageCHSLongstayEnvDataUSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("MERGE INTO CGM_LONG_STAY_DYS_ENV t1" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (t1.STAY_DYS_INP_USR_ID = @[stay_dys_inp_usr_id] )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("N1ST_INQ_FM_DYS=@[n1st_inq_fm_dys]" ).append("\n"); 
		query.append(",N1ST_INQ_TO_DYS=@[n1st_inq_to_dys]" ).append("\n"); 
		query.append(", N2ND_INQ_FM_DYS=@[n2nd_inq_fm_dys]" ).append("\n"); 
		query.append(", N2ND_INQ_TO_DYS=@[n2nd_inq_to_dys]" ).append("\n"); 
		query.append(", N3RD_INQ_FM_DYS=@[n3rd_inq_fm_dys]" ).append("\n"); 
		query.append(", N3RD_INQ_TO_DYS=@[n3rd_inq_to_dys]" ).append("\n"); 
		query.append(", N4TH_INQ_FM_DYS=@[n4th_inq_fm_dys]" ).append("\n"); 
		query.append(", N4TH_INQ_TO_DYS=@[n4th_inq_to_dys]" ).append("\n"); 
		query.append(", N5TH_INQ_FM_DYS=@[n5th_inq_fm_dys]" ).append("\n"); 
		query.append(", N5TH_INQ_TO_DYS=@[n5th_inq_to_dys]" ).append("\n"); 
		query.append(", UPD_USR_ID=@[stay_dys_inp_usr_id]" ).append("\n"); 
		query.append(", UPD_DT=sysdate" ).append("\n"); 
		query.append("WHERE STAY_DYS_INP_USR_ID = @[stay_dys_inp_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("STAY_DYS_INP_USR_ID" ).append("\n"); 
		query.append(", N1ST_INQ_FM_DYS" ).append("\n"); 
		query.append(", N1ST_INQ_TO_DYS" ).append("\n"); 
		query.append(", N2ND_INQ_FM_DYS" ).append("\n"); 
		query.append(", N2ND_INQ_TO_DYS" ).append("\n"); 
		query.append(", N3RD_INQ_FM_DYS" ).append("\n"); 
		query.append(", N3RD_INQ_TO_DYS" ).append("\n"); 
		query.append(", N4TH_INQ_FM_DYS" ).append("\n"); 
		query.append(", N4TH_INQ_TO_DYS" ).append("\n"); 
		query.append(", N5TH_INQ_FM_DYS" ).append("\n"); 
		query.append(", N5TH_INQ_TO_DYS" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[stay_dys_inp_usr_id]" ).append("\n"); 
		query.append(",@[n1st_inq_fm_dys]" ).append("\n"); 
		query.append(",@[n1st_inq_to_dys]" ).append("\n"); 
		query.append(",@[n2nd_inq_fm_dys]" ).append("\n"); 
		query.append(",@[n2nd_inq_to_dys]" ).append("\n"); 
		query.append(",@[n3rd_inq_fm_dys]" ).append("\n"); 
		query.append(",@[n3rd_inq_to_dys]" ).append("\n"); 
		query.append(",@[n4th_inq_fm_dys]" ).append("\n"); 
		query.append(",@[n4th_inq_to_dys]" ).append("\n"); 
		query.append(",@[n5th_inq_fm_dys]" ).append("\n"); 
		query.append(",@[n5th_inq_to_dys]" ).append("\n"); 
		query.append(",@[stay_dys_inp_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[stay_dys_inp_usr_id]" ).append("\n"); 
		query.append(",sysdate)" ).append("\n"); 

	}
}