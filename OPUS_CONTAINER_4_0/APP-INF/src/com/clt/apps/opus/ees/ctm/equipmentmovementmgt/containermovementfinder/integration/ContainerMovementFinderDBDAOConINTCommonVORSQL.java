/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOConINTCommonVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOConINTCommonVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOConINTCommonVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOConINTCommonVORSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO," ).append("\n"); 
		query.append("       CNMV_CYC_NO," ).append("\n"); 
		query.append("       VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       BKG.BKG_NO," ).append("\n"); 
		query.append("       BL_NO BL_NO," ).append("\n"); 
		query.append("       MDT.CMDT_NM AS REP_CMDT_NM" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG, BKG_CONTAINER CON, MDM_COMMODITY MDT" ).append("\n"); 
		query.append("WHERE  CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("AND    CON.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = CON.BKG_NO" ).append("\n"); 
		query.append("AND    BKG.CMDT_CD = MDT.CMDT_CD(+)" ).append("\n"); 

	}
}