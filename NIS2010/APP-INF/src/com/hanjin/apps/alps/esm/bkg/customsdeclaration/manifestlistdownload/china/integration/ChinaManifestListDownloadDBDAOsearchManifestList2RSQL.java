/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchManifestList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.16
*@LastModifier : Hannah Lee
*@LastVersion : 1.0
* 2014.07.16 Hannah Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hannah Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchManifestList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestList2
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchManifestList2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchManifestList2RSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) AS TOTAL        " ).append("\n"); 
		query.append("FROM    BKG_VVD VVD," ).append("\n"); 
		query.append("        BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE  VVD.BKG_NO           =    BKG.BKG_NO" ).append("\n"); 
		query.append("AND    VVD.VSL_CD           =    SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    VVD.SKD_VOY_NO       =    SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    VVD.SKD_DIR_CD       =    SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    BKG.BKG_STS_CD       NOT IN ('X','S')" ).append("\n"); 
		query.append("AND    DECODE(BKG.BKG_CGO_TP_CD,'P','P','F') LIKE @[bkg_cgo_tp_cd]||'%'" ).append("\n"); 
		query.append("AND    DECODE(@[trans_mode],'D',VVD.POD_CD,'O',VVD.POL_CD,VVD.POL_CD) = @[loc_cd]" ).append("\n"); 
		query.append("AND    VVD.POD_CD           LIKE    DECODE(@[trans_mode],'D','%','O','CN%','%')" ).append("\n"); 
		query.append("AND    NVL(BKG.CRR_SOC_FLG, 'N' )='N'" ).append("\n"); 

	}
}