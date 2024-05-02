/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchNoneBLVVDCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchNoneBLVVDCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L 이 없는 공동 VVD 를 체크.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchNoneBLVVDCheckRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n"); 
		query.append("FileName : Kor24ManifestListDBDAOSearchNoneBLVVDCheckRSQL").append("\n"); 
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
		query.append("SELECT C.CRR_CD, V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD, COUNT(V.BKG_NO) CNTBKG" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD S, MDM_VSL_CNTR C, MDM_VSL_SVC_LANE L, BKG_VVD V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND S.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND S.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND S.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND S.VPS_PORT_CD = @[port_cd]         --POD OR POL" ).append("\n"); 
		query.append("   AND S.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("   AND L.VSL_SLAN_CD=S.SLAN_CD" ).append("\n"); 
		query.append("   AND L.VSL_SVC_TP_CD='J'" ).append("\n"); 
		query.append("   AND L.DELT_FLG='N'" ).append("\n"); 
		query.append("   AND C.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("   AND C.CRR_CD = 'SML'" ).append("\n"); 
		query.append("   AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND V.VSL_CD(+)=S.VSL_CD" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO(+)=S.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD(+)=S.SKD_DIR_CD" ).append("\n"); 
		query.append("   #if (${pol_cd} != '' )" ).append("\n"); 
		query.append("   AND V.POL_CD(+)=S.VPS_PORT_CD" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND V.POD_CD(+)=S.VPS_PORT_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("  GROUP BY C.CRR_CD, V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 

	}
}