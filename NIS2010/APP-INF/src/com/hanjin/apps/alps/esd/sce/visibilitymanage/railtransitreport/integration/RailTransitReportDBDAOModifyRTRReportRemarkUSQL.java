/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailTransitReportDBDAOModifyRTRReportRemarkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOModifyRTRReportRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel Upload 기능을 통한 Current Remark 항목 만을 업데이트 함 (Origin In-gate 항목 업데이트는 제외)
	  * </pre>
	  */
	public RailTransitReportDBDAOModifyRTRReportRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_dwll_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOModifyRTRReportRemarkUSQL").append("\n"); 
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
		query.append("UPDATE SCE_RAIL_TZ_RPT              " ).append("\n"); 
		query.append("SET    " ).append("\n"); 
		query.append("CRNT_DWLL_RMK = @[crnt_dwll_rmk]" ).append("\n"); 
		query.append(",CRNT_DWLL_RMK_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("AND ((TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("( SUBSTR(@[so_no],1,3),SUBSTR(@[so_no],4) )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}