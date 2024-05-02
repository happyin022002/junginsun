/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgOfcListForBkgClzRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.19 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgOfcListForBkgClzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgOfcListForBkgClzRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 'All' val," ).append("\n");
		query.append("'All' name" ).append("\n");
		query.append("FROM DUAL" ).append("\n");
		query.append("UNION" ).append("\n");
		query.append("SELECT DISTINCT BK.BKG_OFC_CD val," ).append("\n");
		query.append("BK.BKG_OFC_CD name" ).append("\n");
		query.append("FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n");
		query.append("WHERE BK.BKG_NO        = VVD.BKG_NO" ).append("\n");
		query.append("AND BK.POL_CD        = VVD.POL_CD" ).append("\n");
		query.append("#if (${vsl_cd})" ).append("\n");
		query.append("AND VVD.VSL_CD       = SUBSTR(@[vsl_cd], 1, 4)" ).append("\n");
		query.append("AND VVD.SKD_VOY_NO   = SUBSTR(@[vsl_cd], 5, 4)" ).append("\n");
		query.append("AND VVD.SKD_DIR_CD   = SUBSTR(@[vsl_cd], 9, 1)" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${pol_cd} != '')" ).append("\n");
		query.append("AND VVD.POL_CD       = @[pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n");
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgOfcListForBkgClzRSQL").append("\n");
		query.append("*/").append("\n");
	}
}