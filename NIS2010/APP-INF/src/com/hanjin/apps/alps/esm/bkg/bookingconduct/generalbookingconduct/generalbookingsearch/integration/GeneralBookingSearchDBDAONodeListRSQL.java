/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAONodeListRSQL.java
*@FileTitle : Node Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.20 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GeneralBookingSearchDBDAONodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * NodeListVO
	  * </pre>
	  */
	public GeneralBookingSearchDBDAONodeListRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
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
		query.append("SELECT 	'' LOC_CD" ).append("\n");
		query.append(",'' LOC_NM" ).append("\n");
		query.append(",'' YD_CD" ).append("\n");
		query.append(",'' YD_NM" ).append("\n");
		query.append(",'' EQ_CTRL_OFC_CD" ).append("\n");
		query.append(",'' YD_FCTY_TP_CY_FLG" ).append("\n");
		query.append(",'' YD_FCTY_TYP_CFS_FLG" ).append("\n");
		query.append(",'' YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n");
		query.append(",'' REP_YD_TP_CD" ).append("\n");
		query.append(",'' YD_FCTY_TP_MRN_TML_FLG" ).append("\n");
		query.append(",'' YD_ADDR" ).append("\n");
		query.append(",'' ZN_CD" ).append("\n");
		query.append(",'' ZN_NM" ).append("\n");
		query.append(",'' PSTL_CD" ).append("\n");
		query.append(",'' DSTR_NM" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ").append("\n");
		query.append("FileName : GeneralBookingSearchDBDAONodeListRSQL").append("\n");
		query.append("*/").append("\n");
	}
}