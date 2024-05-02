/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchMrnVslSysDtEtaEtdDtRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.01 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchMrnVslSysDtEtaEtdDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Download전의 MRN No와 ETA/ETD, Sysdate를 조회한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchMrnVslSysDtEtaEtdDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchMrnVslSysDtEtaEtdDtRSQL").append("\n");
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
		query.append("SELECT NVL(REF.MRN_NO,' ')         AS MRN_NO" ).append("\n");
		query.append(", NVL(REF.MRN_CHK_NO, ' ')    AS MRN_CHK_NO" ).append("\n");
		query.append(", TO_CHAR(SYSDATE,'YYYYMMDD HH24:MI:SS') ACTION_TIME" ).append("\n");
		query.append(", NVL(TO_CHAR(VPS.VPS_ETA_DT,'YYYYMMDD HH24:MI'), ' ') ETA_DT" ).append("\n");
		query.append(", NVL(TO_CHAR(VPS.VPS_ETD_DT,'YYYYMMDD HH24:MI'), ' ') ETD_DT" ).append("\n");
		query.append(", NVL(VSL.VSL_RGST_CNT_CD,' ') VSL_FLAG" ).append("\n");
		query.append(", NVL(VSL.VSL_ENG_NM,' ') VSL_ENG_NM" ).append("\n");
		query.append(", NVL(VSL.CALL_SGN_NO,' ') VSL_CALL_SIGN" ).append("\n");
		query.append(", TO_CHAR(SYSDATE,'YYYYMMDD HH24:MI:SS') CURDATE" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO REF, VSK_VSL_PORT_SKD VPS, MDM_VSL_CNTR VSL" ).append("\n");
		query.append("WHERE 1 = 1" ).append("\n");
		query.append("AND REF.VSL_CD     = VPS.VSL_CD" ).append("\n");
		query.append("AND REF.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND REF.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND REF.VSL_CD     = SUBSTR(@[in_vvd], 1, 4)" ).append("\n");
		query.append("AND REF.SKD_VOY_NO = SUBSTR(@[in_vvd], 5, 4)" ).append("\n");
		query.append("AND REF.SKD_DIR_CD = SUBSTR(@[in_vvd], 9, 1)" ).append("\n");
		query.append("AND VSL.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("AND REF.IO_BND_CD  = @[in_bound]" ).append("\n");
		query.append("AND REF.PORT_CD    = DECODE(@[in_bound], 'O', @[in_pol], @[in_pod])" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = DECODE(@[in_bound],'O', @[in_pol], @[in_pod])" ).append("\n");
		query.append("AND NVL(VPS.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ   = '1'" ).append("\n");

	}
}