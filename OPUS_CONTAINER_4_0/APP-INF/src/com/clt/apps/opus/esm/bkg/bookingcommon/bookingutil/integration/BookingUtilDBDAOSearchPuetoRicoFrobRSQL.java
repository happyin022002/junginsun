/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOSearchPuetoRicoFrobRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchPuetoRicoFrobRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOSearchPuetoRicoFrobRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOSearchPuetoRicoFrobRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trunk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchPuetoRicoFrobRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (SELECT 'Y' FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) = 'Y' THEN" ).append("\n"); 
		query.append("------------------------------기 생성된 BKG일 경우 " ).append("\n"); 
		query.append("(SELECT	count(1) CNT" ).append("\n"); 
		query.append("   FROM	BKG_VVD VVD" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND	POD_CD IN " ).append("\n"); 
		query.append("   (SELECT	vps_port_cd --POD에 들리기 이전이라면" ).append("\n"); 
		query.append(" 	  FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("	 WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("	   AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	   AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("	   AND	clpt_ind_seq= '1'" ).append("\n"); 
		query.append("	   AND	clpt_seq	>=" ).append("\n"); 
		query.append("		(SELECT	MIN(clpt_seq) --처음 CANADA를 들리는 port가" ).append("\n"); 
		query.append("	       FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("		  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("		    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		    AND	vps_port_cd	LIKE 'PR%'" ).append("\n"); 
		query.append("		    AND	nvl(skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("		    AND	clpt_seq	>= " ).append("\n"); 
		query.append("			(SELECT	MAX(clpt_seq) --출항 port 이후에" ).append("\n"); 
		query.append("			   FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("			  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("			    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("			    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("			    AND	vps_port_cd	LIKE VVD.POL_CD " ).append("\n"); 
		query.append("		        AND	nvl(skd_cng_sts_cd, ' ') <> 'S') ) )" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POL_CD, 1, 2) <> 'CA'--POL이 미국일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POL_CD, 1, 2) <> 'PR'--POL이 CANADA일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(VVD.POD_CD, 1, 2) <> 'PR'--POD가 CANADA일 때는 제외" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("-------------------------------BKG 생성 전일 경우" ).append("\n"); 
		query.append("(SELECT	count(1) CNT" ).append("\n"); 
		query.append("   FROM	dual" ).append("\n"); 
		query.append("  WHERE	@[pod_cd] IN " ).append("\n"); 
		query.append("   (SELECT vps_port_cd --POD에 들리기 이전이라면" ).append("\n"); 
		query.append(" 	  FROM vsk_vsl_port_skd" ).append("\n"); 
		query.append("	 WHERE vsl_cd		= substr(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append("	   AND skd_voy_no	= substr(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append("	   AND skd_dir_cd	= substr(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append("	   AND clpt_ind_seq= '1'" ).append("\n"); 
		query.append("	   AND clpt_seq	>=" ).append("\n"); 
		query.append("		(SELECT	MIN(clpt_seq) --처음 CANADA를 들리는 port가" ).append("\n"); 
		query.append("	       FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("		  WHERE	vsl_cd		= substr(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append("		    AND	skd_voy_no	= substr(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append("		    AND	skd_dir_cd	= substr(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append("		    AND	vps_port_cd	LIKE 'PR%'" ).append("\n"); 
		query.append("		    AND	nvl(skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("		    AND	clpt_seq	>= " ).append("\n"); 
		query.append("			(SELECT	MAX(clpt_seq) --출항 port 이후에" ).append("\n"); 
		query.append("			   FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("			  WHERE	vsl_cd		= substr(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append("			    AND	skd_voy_no	= substr(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append("			    AND	skd_dir_cd	= substr(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append("			    AND	vps_port_cd	= @[pol_cd] " ).append("\n"); 
		query.append("		        AND	nvl(skd_cng_sts_cd, ' ') <> 'S') ) )" ).append("\n"); 
		query.append("   AND SUBSTR(@[pol_cd], 1, 2) <> 'CA'--POL이 미국일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(@[pol_cd], 1, 2) <> 'PR'--POL이 CANADA일 때는 제외" ).append("\n"); 
		query.append("   AND SUBSTR(@[pod_cd], 1, 2) <> 'PR'--POD가 CANADA일 때는 제외" ).append("\n"); 
		query.append(") END CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}