/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCheckBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCheckBookingRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       '' BKG_NO_SPLIT," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       '' BL_NO_TP," ).append("\n"); 
		query.append("       '' BL_NO_CHK," ).append("\n"); 
		query.append("       BL_TP_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM   BKG_BOOKING" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    BKG_NO = @[p_bkg_no]" ).append("\n"); 
		query.append("AND		NVL(BKG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND		NVL(BKG_STS_CD,' ') <> 'X'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       '' BKG_NO_SPLIT," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       '' BL_NO_TP," ).append("\n"); 
		query.append("       '' BL_NO_CHK," ).append("\n"); 
		query.append("       '' BL_TP_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM   CTM_BOOKING" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    BKG_NO = @[p_bkg_no]" ).append("\n"); 
		query.append("AND		NVL(BKG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND		NVL(BKG_STS_CD,' ') <> 'X'" ).append("\n"); 

	}
}