/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVoyageNumberRSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVoyageNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner EDI 의 VOYAGE CODE와 DIRECTION CODE 를가져오기.
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVoyageNumberRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVoyageNumberRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN LENGTH(@[skd_voy_no]) = 5 THEN " ).append("\n"); 
		query.append("                 DECODE( (SELECT  COUNT(1) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                          WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                                            AND VPS_PORT_CD = @[edi_pol_yd_cd]" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO  = SUBSTR(@[skd_voy_no],1,4)" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD  = SUBSTR(@[skd_voy_no],5,1)), 0 , NULL, @[skd_voy_no])" ).append("\n"); 
		query.append("             WHEN LENGTH(@[skd_voy_no]) = 4 THEN " ).append("\n"); 
		query.append("                  DECODE( (SELECT  COUNT(1) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                           WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                                             AND VPS_PORT_CD = @[edi_pol_yd_cd]" ).append("\n"); 
		query.append("                                             AND SKD_VOY_NO  = '0'||SUBSTR(@[skd_voy_no],1,3)" ).append("\n"); 
		query.append("                                             AND SKD_DIR_CD  = SUBSTR(@[skd_voy_no],4,1)), 0 , NULL, '0'||@[skd_voy_no])" ).append("\n"); 
		query.append("             ELSE " ).append("\n"); 
		query.append("	              (SELECT MIN(SKD_VOY_NO||SKD_DIR_CD)  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                   WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                     AND VPS_PORT_CD = @[edi_pol_yd_cd]" ).append("\n"); 
		query.append("                     AND VPS_ETD_DT BETWEEN TO_DATE(SUBSTR(@[eta_dt],1,8),'YYYYMMDD') AND TO_DATE(SUBSTR(@[eta_dt],1,8),'YYYYMMDD')+ 0.9999)" ).append("\n"); 
		query.append("             END AS VOY_DIR" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}