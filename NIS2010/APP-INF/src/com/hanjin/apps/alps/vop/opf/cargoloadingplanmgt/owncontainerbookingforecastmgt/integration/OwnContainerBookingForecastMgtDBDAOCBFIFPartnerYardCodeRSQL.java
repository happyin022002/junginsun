/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerYardCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerYardCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * yard code 가져오기
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerYardCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerYardCodeRSQL").append("\n"); 
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
		query.append("WITH V_YARD AS ( " ).append("\n"); 
		query.append("   SELECT * FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("    WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("      AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND VPS_PORT_CD = @[edi_pol_yd_cd] )" ).append("\n"); 
		query.append(" SELECT  MIN(CASE WHEN ( SELECT COUNT(1) FROM V_YARD ) = 1 THEN" ).append("\n"); 
		query.append("                        YD_CD||CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  WHEN ( SELECT COUNT(1) FROM V_YARD ) > 1 AND " ).append("\n"); 
		query.append("                       ( VPS_ETD_DT BETWEEN TO_DATE(SUBSTR(@[eta_dt],1,8),'YYYYMMDD') AND TO_DATE(SUBSTR(@[eta_dt],1,8),'YYYYMMDD')+ 0.9999) THEN " ).append("\n"); 
		query.append("                        YD_CD||CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  ELSE " ).append("\n"); 
		query.append("                     NULL" ).append("\n"); 
		query.append("                  END ) AS YD_CD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      FROM V_YARD" ).append("\n"); 

	}
}