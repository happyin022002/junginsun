/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : HolidayMgtDBDAOSb45RulingExceptionsDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.19
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.19 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HolidayMgtDBDAOSb45RulingExceptionsDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 Country, Location, Yard, Bound 별로 등록된 SB45 Ruling Exception 정보 삭제용 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOSb45RulingExceptionsDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exclu_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_det_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOSb45RulingExceptionsDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM DMT_OVR_DY_EXCLU" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CNT_CD        = @[cnt_cd]" ).append("\n"); 
		query.append("   AND LOC_CD        = NVL(@[loc_cd],' ')" ).append("\n"); 
		query.append("   AND YD_CD         = NVL(@[yd_cd],' ')" ).append("\n"); 
		query.append("   AND IO_BND_CD     = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND DEM_DET_TP_CD = @[dem_det_tp_cd]" ).append("\n"); 
		query.append("   AND EXCLU_SEQ     = @[exclu_seq]" ).append("\n"); 

	}
}