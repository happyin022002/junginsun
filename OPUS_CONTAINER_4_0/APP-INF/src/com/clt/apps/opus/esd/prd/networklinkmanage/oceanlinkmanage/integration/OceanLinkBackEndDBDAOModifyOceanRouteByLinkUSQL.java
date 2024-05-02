/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOModifyOceanRouteByLinkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOModifyOceanRouteByLinkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Link에 대한 Ocean Route Update
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOModifyOceanRouteByLinkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmt_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("polprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOModifyOceanRouteByLinkUSQL").append("\n"); 
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
		query.append("UPDATE PRD_OCN_ROUT " ).append("\n"); 
		query.append("SET   UPD_OFC_CD=@[cre_ofc_cd] , " ).append("\n"); 
		query.append("      UPD_USR_ID= @[upd_usr_id] , " ).append("\n"); 
		query.append("      OCN_ROUT_RMK= @[remark] , " ).append("\n"); 
		query.append("      OCN_ROUT_UPD_DT= sysdate," ).append("\n"); 
		query.append("#if (${lnk_seq} == '1')      " ).append("\n"); 
		query.append("      N1ST_TZTM_HRS = TO_NUMBER(@[fmt_tztm_hrs]) , " ).append("\n"); 
		query.append("      TZTM_HRS = (TO_NUMBER(@[fmt_tztm_hrs]) +nvl(N2ND_TZTM_HRS,0)+nvl(N3RD_TZTM_HRS,0)+nvl(N4TH_TZTM_HRS,0) )" ).append("\n"); 
		query.append("WHERE N1ST_POL_CD = @[polprot]  " ).append("\n"); 
		query.append("AND   N1ST_POD_CD = @[podprot]  " ).append("\n"); 
		query.append("AND   N1ST_LANE_CD = @[lanecd]  " ).append("\n"); 
		query.append("AND   N1ST_SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("AND   N1ST_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lnk_seq} == '2')" ).append("\n"); 
		query.append("      N2ND_TZTM_HRS = TO_NUMBER(@[fmt_tztm_hrs]) , " ).append("\n"); 
		query.append("      TZTM_HRS = (nvl(N1ST_TZTM_HRS,0)+TO_NUMBER(@[fmt_tztm_hrs]) +nvl(N3RD_TZTM_HRS,0)+nvl(N4TH_TZTM_HRS,0) )" ).append("\n"); 
		query.append("WHERE N2ND_POL_CD = @[polprot]  " ).append("\n"); 
		query.append("AND   N2ND_POD_CD = @[podprot]  " ).append("\n"); 
		query.append("AND   N2ND_LANE_CD = @[lanecd]  " ).append("\n"); 
		query.append("AND   N2ND_SKD_DIR_CD = @[dircd] " ).append("\n"); 
		query.append("AND   N2ND_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lnk_seq} == '3')" ).append("\n"); 
		query.append("      N3RD_TZTM_HRS = TO_NUMBER(@[fmt_tztm_hrs]) , " ).append("\n"); 
		query.append("      TZTM_HRS = (nvl(N1ST_TZTM_HRS,0)+nvl(N2ND_TZTM_HRS,0)+TO_NUMBER(@[fmt_tztm_hrs]) +nvl(N4TH_TZTM_HRS,0) )" ).append("\n"); 
		query.append("WHERE N3RD_POL_CD = @[polprot]  " ).append("\n"); 
		query.append("AND   N3RD_POD_CD = @[podprot]  " ).append("\n"); 
		query.append("AND   N3RD_LANE_CD = @[lanecd]" ).append("\n"); 
		query.append("AND   N3RD_SKD_DIR_CD = @[dircd]   " ).append("\n"); 
		query.append("AND   N3RD_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lnk_seq} == '4')" ).append("\n"); 
		query.append("      N4TH_TZTM_HRS = TO_NUMBER(@[fmt_tztm_hrs]) , " ).append("\n"); 
		query.append("      TZTM_HRS = (nvl(N1ST_TZTM_HRS,0)+nvl(N2ND_TZTM_HRS,0)+nvl(N3RD_TZTM_HRS,0)+TO_NUMBER(@[fmt_tztm_hrs])  )" ).append("\n"); 
		query.append("WHERE N4TH_POL_CD = @[polprot]  " ).append("\n"); 
		query.append("AND   N4TH_POD_CD = @[podprot]  " ).append("\n"); 
		query.append("AND   N4TH_LANE_CD = @[lanecd] " ).append("\n"); 
		query.append("AND   N4TH_SKD_DIR_CD = @[dircd]    " ).append("\n"); 
		query.append("AND   N4TH_LANE_FDR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}