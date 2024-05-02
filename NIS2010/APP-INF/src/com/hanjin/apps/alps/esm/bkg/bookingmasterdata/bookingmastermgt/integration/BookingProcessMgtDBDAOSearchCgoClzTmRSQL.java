/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingProcessMgtDBDAOSearchCgoClzTmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOSearchCgoClzTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cargo closing time setup SELECT
	  * </pre>
	  */
	public BookingProcessMgtDBDAOSearchCgoClzTmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOSearchCgoClzTmRSQL").append("\n"); 
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
		query.append("SELECT 	 POL_CD" ).append("\n"); 
		query.append(",LANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CCT_HRS" ).append("\n"); 
		query.append(",EML_SND_FLG" ).append("\n"); 
		query.append(",MBL_SND_FLG" ).append("\n"); 
		query.append(",SHPR_NTC_FLG" ).append("\n"); 
		query.append(",BKG_PIC_NTC_FLG" ).append("\n"); 
		query.append(",SREP_NTC_FLG" ).append("\n"); 
		query.append(",OB_PIC_NTC_FLG" ).append("\n"); 
		query.append(",CNTC_EML" ).append("\n"); 
		query.append(",CNTC_MPHN_NO" ).append("\n"); 
		query.append(",CTRT_OFC_PHN_NO" ).append("\n"); 
		query.append(",AUTO_NTC_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM 	BKG_CGO_CLZ_TM_STUP" ).append("\n"); 
		query.append("WHERE	POL_CD	LIKE '%'||@[pol_cd]||'%'" ).append("\n"); 
		query.append("AND		LANE_CD	LIKE '%'||@[lane_cd]||'%'" ).append("\n"); 

	}
}