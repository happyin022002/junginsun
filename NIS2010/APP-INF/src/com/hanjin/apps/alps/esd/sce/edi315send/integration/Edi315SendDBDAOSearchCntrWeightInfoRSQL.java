/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCntrWeightInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCntrWeightInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrWeightInfo
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCntrWeightInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCntrWeightInfoRSQL").append("\n"); 
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
		query.append("                WGT_UT_CD," ).append("\n"); 
		query.append("                CNTR_WGT," ).append("\n"); 
		query.append("                MEAS_UT_CD," ).append("\n"); 
		query.append("                MEAS_QTY," ).append("\n"); 
		query.append("                PCK_TP_CD," ).append("\n"); 
		query.append("                PCK_QTY," ).append("\n"); 
		query.append("				RD_CGO_FLG	-- 2012.05.22 By SBKIM" ).append("\n"); 
		query.append("          FROM  bkg_container" ).append("\n"); 
		query.append("         WHERE  BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND  CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}