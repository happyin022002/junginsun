/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOaddZoneRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOaddZoneRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 Request Zone 정보를 저장합니다.
	  * </pre>
	  */
	public LocationDBDAOaddZoneRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_hndl_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dist_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOaddZoneRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_ZN_RQST (" ).append("\n"); 
		query.append("  RQST_NO, " ).append("\n"); 
		query.append("  ZN_CD," ).append("\n"); 
		query.append("  ZN_NM," ).append("\n"); 
		query.append("  CGO_HNDL_TM_HRS," ).append("\n"); 
		query.append("  TZTM_HRS," ).append("\n"); 
		query.append("  REP_YD_CD," ).append("\n"); 
		query.append("  LNK_DIST," ).append("\n"); 
		query.append("  DIST_UT_CD," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT," ).append("\n"); 
		query.append("  DELT_FLG," ).append("\n"); 
		query.append("  LOC_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("  @[rqst_no]," ).append("\n"); 
		query.append("  @[zn_cd]," ).append("\n"); 
		query.append("  @[zn_nm]," ).append("\n"); 
		query.append("  @[cgo_hndl_tm_hrs]," ).append("\n"); 
		query.append("  @[tztm_hrs]," ).append("\n"); 
		query.append("  @[rep_yd_cd]," ).append("\n"); 
		query.append("  @[lnk_dist]," ).append("\n"); 
		query.append("  @[dist_ut_cd]," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  sysdate," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  sysdate," ).append("\n"); 
		query.append("  @[delt_flg]," ).append("\n"); 
		query.append("  SUBSTR(@[zn_cd],1,5)" ).append("\n"); 
		query.append(") " ).append("\n"); 

	}
}