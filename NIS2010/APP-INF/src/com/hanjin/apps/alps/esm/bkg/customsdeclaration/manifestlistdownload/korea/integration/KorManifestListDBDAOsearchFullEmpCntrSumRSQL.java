/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOsearchFullEmpCntrSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchFullEmpCntrSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Full/Empty Container Summary 정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchFullEmpCntrSumRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchFullEmpCntrSumRSQL").append("\n"); 
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
		query.append("SELECT SUM(DECODE(KR_CSTMS_BL_TP_CD, 'E', 0, 1)) CNT_FULL" ).append("\n"); 
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD, 'E', 1, 0)) CNT_EMPTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(T2.KR_CSTMS_BL_TP_CD, 'E', 'E', 'X') KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append(", C.CNTR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("CSTMS_BL_NO," ).append("\n"); 
		query.append("CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("DMST_PORT_CD," ).append("\n"); 
		query.append("MAX(TRNS_SEQ) SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${in_type} == 'D')" ).append("\n"); 
		query.append("AND KR_CSTMS_BND_CD IN ('A','B','C','M')" ).append("\n"); 
		query.append("#elseif(${in_type} == 'N')" ).append("\n"); 
		query.append("AND KR_CSTMS_BND_CD IN ('A','N','M','T','R')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND KR_CSTMS_BND_CD = @[in_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd], 'I', CSTMS_DECL_TP_CD, 'I') IN ('I','T')" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd], 'O', CSTMS_DECL_TP_CD, 'E') IN ('E','R')" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd], 'I', TS_POD_CD, TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("AND DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' ')" ).append("\n"); 
		query.append("GROUP BY BKG_NO, CSTMS_BL_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n"); 
		query.append("HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y') T, BKG_CSTMS_KR_BL T2, BKG_CSTMS_KR_CNTR C" ).append("\n"); 
		query.append("WHERE T.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND T.CSTMS_DECL_TP_CD = C.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("AND T.DMST_PORT_CD = C.DMST_PORT_CD" ).append("\n"); 
		query.append("AND T.SEQ = C.TRNS_SEQ" ).append("\n"); 
		query.append("AND T.BKG_NO = T2.BKG_NO" ).append("\n"); 
		query.append("AND T.CSTMS_DECL_TP_CD = T2.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("AND T.DMST_PORT_CD = T2.DMST_PORT_CD" ).append("\n"); 
		query.append("AND T.SEQ = T2.TRNS_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T.CSTMS_BL_NO = T2.CSTMS_BL_NO" ).append("\n"); 
		query.append("AND T2.CSTMS_BL_NO = C.CSTMS_BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY DECODE(T2.KR_CSTMS_BL_TP_CD, 'E', 'E', 'X'), C.CNTR_NO)" ).append("\n"); 

	}
}