/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PrdCommonManageDBDAOIsFullCargoCuttOffInThePastRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOIsFullCargoCuttOffInThePastRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG 생성시 Full Cargo Cut-Off Time 과거데이터여부 확인
	  * </pre>
	  */
	public PrdCommonManageDBDAOIsFullCargoCuttOffInThePastRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_cgo_cut_off_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_cgo_cut_off_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOIsFullCargoCuttOffInThePastRSQL").append("\n"); 
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
		query.append("SELECT   CASE WHEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(NVL(@[full_cgo_cut_off_yd_cd],'SGSIN'),1,5),SYSDATE,'SGSIN')" ).append("\n"); 
		query.append("				   >=" ).append("\n"); 
		query.append("				   GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(NVL(@[full_cgo_cut_off_yd_cd],'SGSIN'),1,5),TO_DATE(REPLACE(REPLACE(REPLACE(NVL(@[full_cgo_cut_off_tm],TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')),CHR(32),''),'-',''),':',''),'YYYYMMDDHH24MI'),'SGSIN') THEN 'Y'" ).append("\n"); 
		query.append("              ELSE 'N'" ).append("\n"); 
		query.append("         END  AS IS_IN_THE_PAST" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 

	}
}