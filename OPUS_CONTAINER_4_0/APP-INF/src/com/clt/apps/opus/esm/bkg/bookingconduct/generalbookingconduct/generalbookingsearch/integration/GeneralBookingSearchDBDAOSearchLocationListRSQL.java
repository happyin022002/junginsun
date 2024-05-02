/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchLocationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchLocationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LocationList를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchLocationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_eq_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("state",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_loc_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchLocationListRSQL").append("\n"); 
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
		query.append("A.LOC_CD," ).append("\n"); 
		query.append("A.LOC_NM," ).append("\n"); 
		query.append("A.RGN_CD," ).append("\n"); 
		query.append("A.STE_CD LOC_STATE," ).append("\n"); 
		query.append("A.HUB_LOC_CD," ).append("\n"); 
		query.append("A.UN_LOC_IND_CD," ).append("\n"); 
		query.append("A.UN_LOC_CD," ).append("\n"); 
		query.append("A.LOC_CHR_CD," ).append("\n"); 
		query.append("A.SCC_CD," ).append("\n"); 
		query.append("C.LCC_CD," ).append("\n"); 
		query.append("C.ECC_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.CNT_CD," ).append("\n"); 
		query.append("A.SLS_OFC_CD," ).append("\n"); 
		query.append("A.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_COUNTRY B, MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("#if(${location_cd} != '')" ).append("\n"); 
		query.append("	AND A.LOC_CD like @[location_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${un_loc_ind_cd} != '')" ).append("\n"); 
		query.append("	AND A.UN_LOC_IND_CD = @[un_loc_ind_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${loc_nm} != '')" ).append("\n"); 
		query.append("	AND UPPER(A.LOC_NM) like '%' || UPPER(@[loc_nm])  || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("	AND A.CNT_CD like @[cnt_cd]  || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rcc_cd} != '' && ${rcc_cd} != 'All')	" ).append("\n"); 
		query.append("	AND C.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lcc_cd} != '')" ).append("\n"); 
		query.append("	AND C.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${state} != '')" ).append("\n"); 
		query.append("	AND A.STE_CD = @[state]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${select} == 'S')" ).append("\n"); 
		query.append("	AND A.sls_ofc_cd like @[loc_eq_ofc]  || '%'" ).append("\n"); 
		query.append("#elseif(${select} == 'F')" ).append("\n"); 
		query.append("	AND A.finc_ctrl_ofc_cd like @[loc_eq_ofc]  || '%'" ).append("\n"); 
		query.append("#elseif(${select} == 'E')" ).append("\n"); 
		query.append("	AND A.eq_ctrl_ofc_cd like @[loc_eq_ofc]  || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("	AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}