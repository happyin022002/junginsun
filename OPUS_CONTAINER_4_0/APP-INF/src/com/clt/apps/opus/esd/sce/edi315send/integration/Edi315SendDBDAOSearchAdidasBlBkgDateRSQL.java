/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchAdidasBlBkgDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.10.14 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchAdidasBlBkgDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchAdidasBlBkgDateRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchAdidasBlBkgDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchAdidasBlBkgDateRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("( SELECT TO_CHAR(OBL_ISS_DT,'YYYYMMDDHH24MISS') FROM BKG_BL_ISS" ).append("\n"); 
		query.append("WHERE BKG_NO=A.BKG_NO AND NVL(OBL_ISS_FLG,'N')='Y' AND ROWNUM=1) AS BL_CRT_DT," ).append("\n"); 
		query.append("( SELECT TO_CHAR(MIN(SND_DT),'YYYYMMDDHH24MISS') FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO=A.BKG_NO AND NTC_KND_CD='BK' ) AS BKG_CFM_DT," ).append("\n"); 
		query.append("( SELECT TO_CHAR(BKG_CRE_DT,'YYYYMMDDHH24MISS') FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO=A.BKG_NO AND ROWNUM=1 ) AS BKG_CRT_DT" ).append("\n"); 
		query.append("FROM (SELECT @[bkg_no] AS BKG_NO FROM DUAL) A" ).append("\n"); 

	}
}