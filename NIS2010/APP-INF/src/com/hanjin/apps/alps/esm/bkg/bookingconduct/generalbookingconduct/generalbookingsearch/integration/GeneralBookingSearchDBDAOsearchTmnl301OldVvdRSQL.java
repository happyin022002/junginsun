/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301OldVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("	||	'VVDOLDLOYD:'		|| NVL(VSL.LLOYD_NO, '')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSLNAME:'	|| NVL(VSL.VSL_ENG_NM, '')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSL_CALL_SIGN:'	|| NVL(VSL.CALL_SGN_NO, '')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVOY:'		|| NVL(@[skd_voy_no], '')	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDDIR:'		|| NVL(@[skd_dir_cd], '')	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLUNLC:'        || NVL(@[pol_cd], '')   || CHR(10)      " ).append("\n"); 
		query.append("	||	'VVDOLDPOLYDCD:'        || NVL(@[pol_yd_cd], '')|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLNAME:'        || POL.LOC_NM || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLQUAL:'        || DECODE(LENGTH(POL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLAMS:'         || POL.LOC_AMS_PORT_CD	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODUNLC:'        || NVL(@[pod_cd], '')   || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODYDCD:'        || NVL(@[pod_yd_cd], '')|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODNAME:'        || POD.LOC_NM || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODQUAL:'        || DECODE(LENGTH(POD.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODAMS:'         || POD.LOC_AMS_PORT_CD  || CHR(10)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	||	'}BL_VVD'							|| CHR(10) OLD_VVD" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("      , MDM_LOCATION POL" ).append("\n"); 
		query.append("      , MDM_LOCATION POD" ).append("\n"); 
		query.append("WHERE	VSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND     POL.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND     POD.LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'VVDOLDVSL:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDLOYD:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSLNAME:'		|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVSL_CALL_SIGN:'	|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDVOY:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDDIR:'			|| CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLUNLC:'        || CHR(10)      " ).append("\n"); 
		query.append("	||	'VVDOLDPOLYDCD:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLNAME:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLQUAL:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPOLAMS:'         || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODUNLC:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODYDCD:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODNAME:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODQUAL:'        || CHR(10)" ).append("\n"); 
		query.append("	||	'VVDOLDPODAMS:'         || CHR(10)	" ).append("\n"); 
		query.append("	||	'}BL_VVD'				|| CHR(10) OLD_VVD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}