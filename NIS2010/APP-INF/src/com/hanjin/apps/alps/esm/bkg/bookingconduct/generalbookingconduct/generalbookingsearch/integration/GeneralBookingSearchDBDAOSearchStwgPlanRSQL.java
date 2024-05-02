/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchStwgPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.11.17 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchStwgPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStwgPlan
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchStwgPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchStwgPlanRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("substr(stwg.CNTR_REF_NO,1,10) CNTR_NO" ).append("\n"); 
		query.append(", substr(stwg.CNTR_REF_NO,11,1) CNTR_NO_PST" ).append("\n"); 
		query.append(", stwg.CNTR_REF_NO     FULL_CNTR_NO" ).append("\n"); 
		query.append(", stwg.CNTR_TPSZ_CD    TPSZ_CD" ).append("\n"); 
		query.append(", cntr.cnmv_STS_CD" ).append("\n"); 
		query.append(", stwg.POD_CD      POD_CD" ).append("\n"); 
		query.append(", cntr.pre_sts_flg" ).append("\n"); 
		query.append("FROM OPF_BAY_PLN_LDIS stwg, mst_container cntr" ).append("\n"); 
		query.append("WHERE stwg.VSL_CD     = SUBSTR(@[vvd], 0,4)" ).append("\n"); 
		query.append("AND stwg.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND stwg.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("AND stwg.POL_CD     = SUBSTR(@[yd_cd], 0, 5)" ).append("\n"); 
		query.append("AND stwg.CRR_CD     = 'HJS'" ).append("\n"); 
		query.append("AND stwg.LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("and stwg.cntr_ref_no = cntr.cntr_no(+)" ).append("\n"); 
		query.append("AND DECODE(stwg.FULL_MTY_CD, 'E', 'P', 'M','P','F') = 'P'" ).append("\n"); 
		query.append("ORDER BY cntr.pre_sts_flg" ).append("\n"); 

	}
}