/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyMIBAdvListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.11.29 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyMIBAdvListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, ADV_BL.USA_LST_LOC_CD 갱신. 0408
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyMIBAdvListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_lst_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyMIBAdvListUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	CNT_CD = CNT_CD" ).append("\n"); 
		query.append("#if (${origin_bl_flag} == 'origin_bl') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${locl_clr_ipi_mvmt_flg} == 'Y' ) " ).append("\n"); 
		query.append("		#if (${cstms_clr_tp_cd} == 'L') " ).append("\n"); 
		query.append("    		,USA_LST_LOC_CD = ''" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,USA_LST_LOC_CD = TRIM(@[usa_lst_loc_cd])" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		,USA_LST_LOC_CD = TRIM(@[usa_lst_loc_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${cstms_clr_tp_cd} == 'L')" ).append("\n"); 
		query.append("    ,CSTMS_LOC_CD = (SELECT POD_CD FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("    #elseif(${cstms_clr_tp_cd} == 'I')" ).append("\n"); 
		query.append("    ,CSTMS_LOC_CD = @[cstms_loc_cd]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    ,HUB_LOC_CD = TRIM(@[hub_loc_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${cstms_clr_tp_cd_chg} == 'Y')" ).append("\n"); 
		query.append("    	#if (${cstms_clr_tp_cd} == 'L')" ).append("\n"); 
		query.append("    		,CSTMS_LOC_CD = (SELECT POD_CD FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("			#if (${locl_clr_ipi_mvmt_flg} == 'Y')" ).append("\n"); 
		query.append("				,USA_LST_LOC_CD = ''" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    	#elseif (${cstms_clr_tp_cd} == 'I')" ).append("\n"); 
		query.append("    	,CSTMS_LOC_CD = @[cstms_loc_cd]" ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 

	}
}