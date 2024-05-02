/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBatchEdiVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.04.05 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBatchEdiVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchBatchEdiVvdListRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBatchEdiVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBatchEdiVvdListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	DISTINCT SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE SKD.VPS_ETD_DT BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 20" ).append("\n"); 
		query.append("AND SKD.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("			SELECT 'X' " ).append("\n"); 
		query.append("            	FROM BKG_VVD VVD " ).append("\n"); 
		query.append("               	WHERE  VVD.VSL_CD        = SKD.VSL_CD" ).append("\n"); 
		query.append("               	AND VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("               	AND VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("               	AND VVD.POL_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("               	AND VVD.POL_YD_CD        = SKD.YD_CD" ).append("\n"); 
		query.append("               	AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}