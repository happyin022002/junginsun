/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchYardCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.29 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchYardCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchYardCode
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchYardCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchYardCodeRSQL").append("\n"); 
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
		query.append("SELECT  YD.LOC_CD" ).append("\n"); 
		query.append(",LC.LOC_NM" ).append("\n"); 
		query.append(",YD.YD_CD" ).append("\n"); 
		query.append(",YD.YD_NM" ).append("\n"); 
		query.append(",LC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",DECODE(YD.YD_FCTY_TP_CY_FLG,      'Y','O','') YD_FCTY_TP_CY_FLG" ).append("\n"); 
		query.append(",DECODE(YD.YD_FCTY_TP_CFS_FLG,     'Y','O','') YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append(",DECODE(YD.YD_FCTY_TP_RAIL_RMP_FLG,'Y','O','') YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n"); 
		query.append(",DECODE(YD.YD_FCTY_TP_PSDO_YD_FLG, 'Y','O','') YD_FCTY_TP_PSDO_YD_FLG" ).append("\n"); 
		query.append(",DECODE(YD.YD_FCTY_TP_MRN_TML_FLG, 'Y','O','') YD_FCTY_TP_MRN_TML_FLG" ).append("\n"); 
		query.append(",'' YD_ADDR" ).append("\n"); 
		query.append(",'' ZN_CD" ).append("\n"); 
		query.append(",'' ZN_NM" ).append("\n"); 
		query.append(",'' PST_CD" ).append("\n"); 
		query.append(",'' DSTR_NM" ).append("\n"); 
		query.append("FROM    MDM_YARD YD" ).append("\n"); 
		query.append(",MDM_LOCATION LC" ).append("\n"); 
		query.append("WHERE   YD.LOC_CD = LC.LOC_CD" ).append("\n"); 
		query.append("#if (${country_cd} != '')" ).append("\n"); 
		query.append("AND     LC.CNT_CD = @[country_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("#if (${loc_cd2}!= '')" ).append("\n"); 
		query.append("AND     YD.YD_CD LIKE @[loc_cd]||'%'||@[loc_cd2]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     YD.LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${loc_cd2}!= '')" ).append("\n"); 
		query.append("AND     YD.YD_CD LIKE '%'||@[loc_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_ctrl_ofc_cd}!= '')" ).append("\n"); 
		query.append("AND     LC.EQ_CTRL_OFC_CD = @[eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${marine_terminal}== 'Y')" ).append("\n"); 
		query.append("AND     YD.YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     YD.DELT_FLG = 'N'" ).append("\n"); 

	}
}