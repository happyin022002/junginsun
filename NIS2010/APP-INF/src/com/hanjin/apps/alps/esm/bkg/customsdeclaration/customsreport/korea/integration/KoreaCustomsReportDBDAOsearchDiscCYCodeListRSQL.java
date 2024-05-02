/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchDiscCYCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchDiscCYCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국/인도 세관에 적하 목록 전송시 Discharging CY Code 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchDiscCYCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_dchg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchDiscCYCodeListRSQL").append("\n"); 
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
		query.append("SELECT NVL(OTR_DCHG_CD, ' ') OTR_DCHG_CD" ).append("\n"); 
		query.append("	 , NVL(YD_CD, ' ') YD_CD" ).append("\n"); 
		query.append("	 , NVL(LOC_CD, ' ') LOC_CD" ).append("\n"); 
		query.append("	 , NVL(LOC_NM, ' ') LOC_NM" ).append("\n"); 
		query.append("	 , NVL(PORT_CD, ' ') PORT_CD" ).append("\n"); 
		query.append("	 , NVL(SLAN_CD, ' ') SLAN_CD" ).append("\n"); 
		query.append("	 , NVL(SKD_DIR_CD, ' ') SKD_DIR_CD" ).append("\n"); 
		query.append("	 , NVL(EDO_TRSM_FLG, ' ') EDO_TRSM_FLG" ).append("\n"); 
		query.append("  FROM BKG_DCHG_LOC" ).append("\n"); 
		query.append(" WHERE NVL(OTR_DCHG_CD , ' ') LIKE @[otr_dchg_cd] || '%'" ).append("\n"); 
		query.append("   AND NVL(PORT_CD , ' ') LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("   AND NVL(LOC_CD , ' ') LIKE @[loc_cd] || '%'" ).append("\n"); 
		query.append("   AND NVL(LOC_NM, ' ') LIKE @[loc_nm] || '%'" ).append("\n"); 
		query.append("   AND NVL(YD_CD, ' ') LIKE @[yd_cd] || '%'   " ).append("\n"); 
		query.append("   AND NVL(SLAN_CD, ' ') LIKE @[slan_cd] || '%'" ).append("\n"); 
		query.append("   AND NVL(SKD_DIR_CD, ' ') LIKE @[skd_dir_cd] || '%'" ).append("\n"); 

	}
}