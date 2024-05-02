/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCntrByYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.18 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCntrByYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard코드로 Container 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCntrByYardRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCntrByYardRSQL").append("\n"); 
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
		query.append("select 	substr(cntr_no,1,10) cntr_no," ).append("\n"); 
		query.append("substr(cntr_no,11,1) cntr_no_PST," ).append("\n"); 
		query.append("cntr_no full_cntr_no," ).append("\n"); 
		query.append("cntr_tpsz_cd TPSZ_CD," ).append("\n"); 
		query.append("cnmv_sts_Cd  STS_CD" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CRNT_YD_CD 	= @[yd_cd]" ).append("\n"); 
		query.append("and IMDT_EXT_FLG = 'N'" ).append("\n"); 
		query.append("and DISP_FLG 	= 'N'" ).append("\n"); 
		query.append("--   and RFUB_FLG 	= 'N' --20091118 이동석 차장님 요청으로 제회함" ).append("\n"); 
		query.append("and CNMV_STS_CD	= 'MT'" ).append("\n"); 
		query.append("and ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("and lstm_cd <> 'SH'" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd}!= '')" ).append("\n"); 
		query.append("and cntr_tpsz_cd = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}