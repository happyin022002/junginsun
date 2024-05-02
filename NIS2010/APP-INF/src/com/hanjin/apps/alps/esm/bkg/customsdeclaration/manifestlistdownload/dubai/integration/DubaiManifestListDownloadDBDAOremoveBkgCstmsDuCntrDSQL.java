/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCntrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.06.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCntrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeBkgCstmsDuCntr
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCntrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCntrDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_DU_CNTR" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND BL_NO IN (" ).append("\n"); 
		query.append("                 SELECT BL_NO " ).append("\n"); 
		query.append("                   FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                       ,BKG_VVD V" ).append("\n"); 
		query.append("                  WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                #if (${bl_no} != '') " ).append("\n"); 
		query.append("                    AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${vvd} != '') " ).append("\n"); 
		query.append("                    AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                    AND V.POD_CD = @[pod_cd]                               " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${pol_cd} != '')      " ).append("\n"); 
		query.append("                    AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${cgo_type} == 'F') " ).append("\n"); 
		query.append("                    AND B.BKG_CGO_TP_CD IN ('F')" ).append("\n"); 
		query.append("                #elseif (${cgo_type} == 'M') " ).append("\n"); 
		query.append("                    AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("  AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}