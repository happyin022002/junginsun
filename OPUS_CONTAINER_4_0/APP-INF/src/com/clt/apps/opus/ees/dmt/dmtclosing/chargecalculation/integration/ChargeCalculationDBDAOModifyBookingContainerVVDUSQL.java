/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOModifyBookingContainerVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOModifyBookingContainerVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Data가 존재하지 않으면 UPDATE한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOModifyBookingContainerVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOModifyBookingContainerVVDUSQL").append("\n"); 
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
		query.append("UPDATE DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("SET VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append(",SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append(",SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("WHERE (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("      SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO  FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("      WHERE (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("          SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      AND SUBSTR(DMDT_TRF_CD, 3, 1) = @[io_bnd])" ).append("\n"); 

	}
}