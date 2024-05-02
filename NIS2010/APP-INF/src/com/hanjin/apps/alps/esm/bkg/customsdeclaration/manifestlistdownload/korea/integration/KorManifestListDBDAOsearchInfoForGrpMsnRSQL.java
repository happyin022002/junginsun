/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOsearchInfoForGrpMsnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 장인호
*@LastVersion : 1.0
* 2013.06.04 장인호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author janginho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchInfoForGrpMsnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group MSN정보조회를 위한 정보 search
	  * </pre>
	  */
	public KorManifestListDBDAOsearchInfoForGrpMsnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchInfoForGrpMsnRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SEQ.MF_REF_NO GRP_MRN" ).append("\n"); 
		query.append(", SEQ.MRN_CHK_NO GRP_MRN_CHK" ).append("\n"); 
		query.append(", SEQ.VSL_CD||SEQ.SKD_VOY_NO||SEQ.SKD_DIR_CD GRP_VVD" ).append("\n"); 
		query.append(", VVD.POL_CD GRP_POL" ).append("\n"); 
		query.append(", VVD.POD_CD GRP_POD" ).append("\n"); 
		query.append(", NVL(TO_CHAR(VSL1.VPS_ETD_DT,'YYYYMMDD'),' ') GRP_ETD" ).append("\n"); 
		query.append(", NVL(TO_CHAR(VSL2.VPS_ETA_DT,'YYYYMMDD'),' ') GRP_ETA" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT NVL(TO_CHAR(VSL3.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI'), ' ')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VSL3" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = VSL3.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = VSL3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = VSL3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD = VSL3.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VSL3.CLPT_IND_SEQ  =  '1'" ).append("\n"); 
		query.append("AND ROWNUM = 1) GRP_ETA_DTL" ).append("\n"); 
		query.append(", SEQ.UPD_USR_ID" ).append("\n"); 
		query.append(", SEQ.UPD_DT" ).append("\n"); 
		query.append(", SEQ.VIA_WEB_FLG" ).append("\n"); 
		query.append(", SEQ.VIA_WEB_DT" ).append("\n"); 
		query.append("FROM BKG_VVD VVD,  VSK_VSL_PORT_SKD  VSL1,  VSK_VSL_PORT_SKD  VSL2" ).append("\n"); 
		query.append(",(SELECT BKG_NO, MF_REF_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, UPD_USR_ID, NVL(TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI'),' ') UPD_DT" ).append("\n"); 
		query.append(", VIA_WEB_FLG, NVL(TO_CHAR(WEB_IF_DT,'YYYY-MM-DD HH24:MI'),' ') VIA_WEB_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]) SEQ" ).append("\n"); 
		query.append("WHERE SEQ.VSL_CD   = VVD.VSL_CD" ).append("\n"); 
		query.append("AND SEQ.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SEQ.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SEQ.BKG_NO     = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_CD         =  VSL1.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO     =  VSL1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD     =  VSL1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD         =  VSL1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VSL1.CLPT_IND_SEQ  =  '1'" ).append("\n"); 
		query.append("AND VVD.VSL_CD         =  VSL2.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO     =  VSL2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD     =  VSL2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD         =  VSL2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VSL2.VPS_ETA_DT    >  VSL1.VPS_ETD_DT" ).append("\n"); 

	}
}