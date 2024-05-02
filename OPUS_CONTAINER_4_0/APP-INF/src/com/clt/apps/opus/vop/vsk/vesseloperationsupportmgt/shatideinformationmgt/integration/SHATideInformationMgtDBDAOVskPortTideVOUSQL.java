/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtDBDAOVskPortTideVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SHATideInformationMgtDBDAOVskPortTideVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SHATideInformationMgtDBDAOVskPortTideVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_fm_tide_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_low_tide_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_high_tide_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_to_tide_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tide_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_low_tide_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tide_dy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_tide_to_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tide_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_high_tide_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_tide_fm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration").append("\n"); 
		query.append("FileName : SHATideInformationMgtDBDAOVskPortTideVOUSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_PORT_TIDE" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON( LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND TIDE_YR = @[tide_yr]" ).append("\n"); 
		query.append("AND TIDE_MON = @[tide_mon]" ).append("\n"); 
		query.append("AND TIDE_DY = @[tide_dy]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET N1ST_TIDE_FM_HRMNT = @[n1st_tide_fm_hrmnt]" ).append("\n"); 
		query.append(", N1ST_TIDE_TO_HRMNT = @[n1st_tide_to_hrmnt]" ).append("\n"); 
		query.append(", N1ST_HIGH_TIDE_HGT = NVL(@[n1st_high_tide_hgt], 0)" ).append("\n"); 
		query.append(", N1ST_LOW_TIDE_HGT = NVL(@[n1st_low_tide_hgt], 0)" ).append("\n"); 
		query.append(", N2ND_FM_TIDE_HRMNT = @[n2nd_fm_tide_hrmnt]" ).append("\n"); 
		query.append(", N2ND_TO_TIDE_HRMNT = @[n2nd_to_tide_hrmnt]" ).append("\n"); 
		query.append(", N2ND_HIGH_TIDE_HGT = NVL(@[n2nd_high_tide_hgt], 0)" ).append("\n"); 
		query.append(", N2ND_LOW_TIDE_HGT = NVL(@[n2nd_low_tide_hgt], 0)" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (  LOC_CD" ).append("\n"); 
		query.append(", TIDE_YR" ).append("\n"); 
		query.append(", TIDE_MON" ).append("\n"); 
		query.append(", TIDE_DY" ).append("\n"); 
		query.append(", N1ST_TIDE_FM_HRMNT" ).append("\n"); 
		query.append(", N1ST_TIDE_TO_HRMNT" ).append("\n"); 
		query.append(", N1ST_HIGH_TIDE_HGT" ).append("\n"); 
		query.append(", N1ST_LOW_TIDE_HGT" ).append("\n"); 
		query.append(", N2ND_FM_TIDE_HRMNT" ).append("\n"); 
		query.append(", N2ND_TO_TIDE_HRMNT" ).append("\n"); 
		query.append(", N2ND_HIGH_TIDE_HGT" ).append("\n"); 
		query.append(", N2ND_LOW_TIDE_HGT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(  @[loc_cd]" ).append("\n"); 
		query.append(", @[tide_yr]" ).append("\n"); 
		query.append(", @[tide_mon]" ).append("\n"); 
		query.append(", @[tide_dy]" ).append("\n"); 
		query.append(", @[n1st_tide_fm_hrmnt]" ).append("\n"); 
		query.append(", @[n1st_tide_to_hrmnt]" ).append("\n"); 
		query.append(", NVL(@[n1st_high_tide_hgt], 0)" ).append("\n"); 
		query.append(", NVL(@[n1st_low_tide_hgt], 0)" ).append("\n"); 
		query.append(", @[n2nd_fm_tide_hrmnt]" ).append("\n"); 
		query.append(", @[n2nd_to_tide_hrmnt]" ).append("\n"); 
		query.append(", NVL(@[n2nd_high_tide_hgt], 0)" ).append("\n"); 
		query.append(", NVL(@[n2nd_low_tide_hgt], 0)" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}