/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEmptyCntrByBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchEmptyCntrByBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Repo Bkg에 속해 있는 Container No List를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEmptyCntrByBKGRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEmptyCntrByBKGRSQL").append("\n"); 
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
		query.append("SELECT  CNTR.CNTR_NO," ).append("\n"); 
		query.append("        CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CNTR.MCNTR_BDL_NO," ).append("\n"); 
		query.append("        CNTR.BDL_BTM_FLG," ).append("\n"); 
		query.append("		(SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("			FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("			WHERE INTG_CD_ID = 'CD02012' " ).append("\n"); 
		query.append("			AND INTG_CD_VAL_CTNT = MST.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("		MST.MNR_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("		MST.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("FROM    BKG_CNTR_HIS CNTR, MST_CONTAINER MST" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM    BKG_CONTAINER CNTR, MST_CONTAINER MST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE   CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND     CNTR.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		CNTR.CNTR_NO = MST.CNTR_NO" ).append("\n"); 

	}
}