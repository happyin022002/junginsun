/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchZoneCodeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.17 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchZoneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchZoneCode
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchZoneCodeRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("SELECT  LC.LOC_CD" ).append("\n");
		query.append(",LC.LOC_NM" ).append("\n");
		query.append(",ZN.ZN_CD" ).append("\n");
		query.append(",ZN.ZN_NM" ).append("\n");
		query.append(",PT.PST_CD" ).append("\n");
		query.append(",ZD.DSTR_NM" ).append("\n");
		query.append(",LC.EQ_CTRL_OFC_CD" ).append("\n");
		query.append("FROM    MDM_ZONE ZN" ).append("\n");
		query.append(",MDM_LOCATION LC" ).append("\n");
		query.append(",BKG_POSTAL PT" ).append("\n");
		query.append(",MDM_ZN_DTL ZD" ).append("\n");
		query.append("WHERE   ZN.LOC_CD = LC.LOC_CD" ).append("\n");
		query.append("#if (${postal_cd} == 'P')" ).append("\n");
		query.append("AND     ZN.LOC_CD = PT.LOC_CD(+)" ).append("\n");
		query.append("AND     ZN.ZN_CD = ZD.ZN_CD(+)" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND     ZN.LOC_CD = PT.LOC_CD(+)" ).append("\n");
		query.append("AND     ZN.ZN_CD = ZD.ZN_CD" ).append("\n");
		query.append("AND     ZD.DSTR_NM IS NOT NULL" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${country_cd} != '')" ).append("\n");
		query.append("AND     LC.CNT_CD = @[country_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${loc_cd} != '')" ).append("\n");
		query.append("#if (${loc_cd2}!= '')" ).append("\n");
		query.append("AND     ZN.ZN_CD LIKE @[loc_cd]||'%'||@[loc_cd2]" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND     ZN.LOC_CD LIKE @[loc_cd]||'%'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("#if (${loc_cd2}!= '')" ).append("\n");
		query.append("AND     ZN.ZN_CD LIKE '%'||@[loc_cd2]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${eq_ctrl_ofc_cd}!= '')" ).append("\n");
		query.append("AND     LC.EQ_CTRL_OFC_CD = @[eq_ctrl_ofc_cd]" ).append("\n");
		query.append("#end" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n");
		query.append("FileName : GeneralBookingSearchDBDAOSearchZoneCodeRSQL").append("\n");
		query.append("*/").append("\n");
	}
}