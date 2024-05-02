/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtDBDAOHolidayMgtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.19 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class HolidayMgtDBDAOHolidayMgtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 Country, Region, State, Location 별로 등록된 Holiday 정보 입력용 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOHolidayMgtCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hol_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hol_dt_in",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hol_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO DMT_HOLIDAY (" ).append("\n"); 
		query.append("HOL_YR," ).append("\n"); 
		query.append("CNT_CD," ).append("\n"); 
		query.append("RGN_CD," ).append("\n"); 
		query.append("STE_CD," ).append("\n"); 
		query.append("LOC_CD," ).append("\n"); 
		query.append("HOL_DT," ).append("\n"); 
		query.append("HOL_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("UPD_OFC_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[hol_yr]," ).append("\n"); 
		query.append("@[cnt_cd]," ).append("\n"); 
		query.append("NVL(@[rgn_cd], ' ')," ).append("\n"); 
		query.append("NVL(@[ste_cd], ' ')," ).append("\n"); 
		query.append("NVL(@[loc_cd], ' ')," ).append("\n"); 
		query.append("TO_DATE(@[hol_dt_in],'yyyy-MM-dd')," ).append("\n"); 
		query.append("@[hol_desc]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[cre_ofc_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[cre_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOHolidayMgtCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}