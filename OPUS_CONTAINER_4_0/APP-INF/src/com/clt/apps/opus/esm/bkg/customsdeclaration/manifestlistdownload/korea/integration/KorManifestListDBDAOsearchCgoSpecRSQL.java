/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCgoSpecRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchCgoSpecRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Cargo Spec 자동 조회를 위해 POL, POD가 "KR"로 시작되는 값의 Sum을 구해서 1이상이면 Cargo Spec 자동 조회 조건 충족함.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCgoSpecRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchCgoSpecRSQL").append("\n");
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
		query.append("SELECT DECODE(SUM(DECODE(SUBSTR(T1.POL_CD,1,2),'KR',DECODE(SUBSTR(T1.POD_CD,1,2),'KR',1,0),0)), 0, ' '," ).append("\n");
		query.append("              SUM(DECODE(SUBSTR(T1.POL_CD,1,2),'KR',DECODE(SUBSTR(T1.POD_CD,1,2),'KR',1,0),0))) CGO_SPEC" ).append("\n");
		query.append("FROM BKG_VVD T1," ).append("\n");
		query.append("    (SELECT S2.VSL_CD, S2.SKD_VOY_NO, S2.SKD_DIR_CD, S2.VPS_PORT_CD, S2.SLAN_CD, MAX(S2.VPS_ETD_DT) VPS_ETD_DT" ).append("\n");
		query.append("    FROM BKG_VVD S1, VSK_VSL_PORT_SKD S2" ).append("\n");
		query.append("    WHERE S1.BKG_NO      = @[bkg_no]" ).append("\n");
		query.append("    AND S1.VSL_CD        = S2.VSL_CD(+)" ).append("\n");
		query.append("    AND S1.SKD_VOY_NO    = S2.SKD_VOY_NO(+)" ).append("\n");
		query.append("    AND S1.SKD_DIR_CD    = S2.SKD_DIR_CD(+)" ).append("\n");
		query.append("    AND S1.POL_CD       = S2.VPS_PORT_CD(+)" ).append("\n");
		query.append("    GROUP BY S2.VSL_CD, S2.SKD_VOY_NO, S2.SKD_DIR_CD, S2.VPS_PORT_CD, S2.SLAN_CD) T2," ).append("\n");
		query.append("    (SELECT S2.VSL_CD, S2.SKD_VOY_NO, S2.SKD_DIR_CD, S2.VPS_PORT_CD, MIN(S2.VPS_ETA_DT) VPS_ETA_DT" ).append("\n");
		query.append("    FROM BKG_VVD S1, VSK_VSL_PORT_SKD S2" ).append("\n");
		query.append("    WHERE S1.BKG_NO      = @[bkg_no]" ).append("\n");
		query.append("    AND S1.VSL_CD        = S2.VSL_CD(+)" ).append("\n");
		query.append("    AND S1.SKD_VOY_NO    = S2.SKD_VOY_NO(+)" ).append("\n");
		query.append("    AND S1.SKD_DIR_CD    = S2.SKD_DIR_CD(+)" ).append("\n");
		query.append("    AND S1.POD_CD        = S2.VPS_PORT_CD(+)" ).append("\n");
		query.append("    GROUP BY S2.VSL_CD, S2.SKD_VOY_NO, S2.SKD_DIR_CD, S2.VPS_PORT_CD) T3" ).append("\n");
		query.append("WHERE T1.BKG_NO      = @[bkg_no]" ).append("\n");
		query.append("AND T1.VSL_CD        = T2.VSL_CD(+)" ).append("\n");
		query.append("AND T1.SKD_VOY_NO    = T2.SKD_VOY_NO(+)" ).append("\n");
		query.append("AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD(+)" ).append("\n");
		query.append("AND T1.POL_CD        = T2.VPS_PORT_CD(+)" ).append("\n");
		query.append("AND T1.VSL_CD        = T3.VSL_CD(+)" ).append("\n");
		query.append("AND T1.SKD_VOY_NO    = T3.SKD_VOY_NO(+)" ).append("\n");
		query.append("AND T1.SKD_DIR_CD    = T3.SKD_DIR_CD(+)" ).append("\n");
		query.append("AND T1.POD_CD        = T3.VPS_PORT_CD(+)" ).append("\n");

	}
}