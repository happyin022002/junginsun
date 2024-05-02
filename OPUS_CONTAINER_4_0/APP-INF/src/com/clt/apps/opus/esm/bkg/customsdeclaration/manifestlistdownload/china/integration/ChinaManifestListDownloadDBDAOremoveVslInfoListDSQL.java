/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOremoveVslInfoListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOremoveVslInfoListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeVslInfoList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOremoveVslInfoListDSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOremoveVslInfoListDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_CSTMS_CHN_VVD" ).append("\n"); 
		query.append("WHERE  VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND	   CHN_MF_SND_IND_CD IN (@[trans_mode], 'R')" ).append("\n"); 
		query.append("AND    PORT_CD IN ( SELECT  DISTINCT BV.POL_CD" ).append("\n"); 
		query.append("                    FROM    BKG_VVD BV, BKG_BOOKING BB" ).append("\n"); 
		query.append("                    WHERE   BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                    AND (#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("                           	#if($velocityCount > 1)" ).append("\n"); 
		query.append("                            OR #end      BV.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("                    AND     BB.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("                    AND     BV.VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND     BV.SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND     BV.SKD_DIR_CD    = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                    AND     BV.POD_CD        = @[loc_cd]" ).append("\n"); 
		query.append("                    AND     BB.BKG_STS_CD    NOT IN ('X','S')" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("                    SELECT  @[loc_cd] FROM DUAL )" ).append("\n"); 

	}
}