/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchFinDirRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.08.17 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchFinDirRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * financial direction을 찾는다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchFinDirRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchFinDirRSQL").append("\n"); 
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
		query.append("SELECT dir REV_DIR_CD" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT 1 rank, substr(fin.RLANE_DIR_CD, 1, 1) dir" ).append("\n"); 
		query.append("	FROM AR_FINC_DIR_CONV fin, mdm_LOCATION loc" ).append("\n"); 
		query.append("	WHERE fin.SCONTI_CD = loc.SCONTI_CD " ).append("\n"); 
		query.append("  	AND loc.LOC_CD        = @[pol_cd]" ).append("\n"); 
		query.append("   	AND fin.SLAN_CD       = @[trnk_lane_cd]" ).append("\n"); 
		query.append("    AND fin.SLAN_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT 2 rank, @[skd_dir_cd]" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE DIR IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1	" ).append("\n"); 

	}
}