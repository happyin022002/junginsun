/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LocationDBDAOaddZoneDtlCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOaddZoneDtlCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 Zone Detail 정보를 저장합니다.
	  * </pre>
	  */
	public LocationDBDAOaddZoneDtlCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dstr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOaddZoneDtlCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_ZN_DTL (" ).append("\n"); 
		query.append("  ZN_CD," ).append("\n"); 
		query.append("  ZN_SEQ," ).append("\n"); 
		query.append("  ZIP_CD," ).append("\n"); 
		query.append("  DSTR_NM," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT," ).append("\n"); 
		query.append("  DELT_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("  @[zn_cd]," ).append("\n"); 
		query.append("  (SELECT DECODE (MAX(ZN_SEQ), NULL, 1, MAX(ZN_SEQ)+1) FROM MDM_ZN_DTL WHERE ZN_CD = @[zn_cd])," ).append("\n"); 
		query.append("  @[zip_cd]," ).append("\n"); 
		query.append("  @[dstr_nm]," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  sysdate," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  sysdate," ).append("\n"); 
		query.append("  @[delt_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}