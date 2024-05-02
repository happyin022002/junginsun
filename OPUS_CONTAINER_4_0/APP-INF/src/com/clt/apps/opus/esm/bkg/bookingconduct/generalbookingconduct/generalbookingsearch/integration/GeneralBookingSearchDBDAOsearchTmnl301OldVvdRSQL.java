/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301OldVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.19 정인선
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

public class GeneralBookingSearchDBDAOsearchTmnl301OldVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301OldVvd
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301OldVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301OldVvdRSQL").append("\n"); 
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
		query.append("SELECT OLD_VVD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	'VVDOLDVSL:'			|| NVL(@[vsl_cd], '')	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDLOYD:'		|| NVL(LLOYD_NO, '')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSLNAME:'	|| NVL(VSL_ENG_NM, '')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSL_CALL_SIGN:'	|| NVL(CALL_SGN_NO, '')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVOY:'		|| NVL(@[skd_voy_no], '')	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDDIR:'		|| NVL(@[skd_dir_cd], '')	|| CHR(10)" ).append("\n"); 
		query.append("    ||	'VVDOLDCONSORT_VOY:'|| VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(@[vsl_cd],@[skd_voy_no],@[skd_dir_cd],@[pol_cd],'O')	|| CHR(10) " ).append("\n"); 
		query.append("	||	'}BL_VVD'							|| CHR(10) OLD_VVD" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'VVDOLDVSL:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDLOYD:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSLNAME:'		|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSL_CALL_SIGN:'	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVOY:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDDIR:'			|| CHR(10)" ).append("\n"); 
		query.append("    ||	'VVDOLDCONSORT_VOY:'	|| CHR(10)" ).append("\n"); 
		query.append("	||	'}BL_VVD'				|| CHR(10) OLD_VVD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}