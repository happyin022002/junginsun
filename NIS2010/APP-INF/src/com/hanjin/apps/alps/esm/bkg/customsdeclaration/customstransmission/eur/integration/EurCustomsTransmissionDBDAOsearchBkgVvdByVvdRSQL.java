/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.12.20 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd 기본 정보 조회
	  * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
	  * 2011.10.28 김보배 [CHM-201114181] [BKG] [EUR customs manifest] 쿼리속도 개선
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    DISTINCT NVL(A.VSL_CD, '')||NVL(A.SKD_VOY_NO, '')||NVL(A.SKD_DIR_CD, '') AS VVD" ).append("\n"); 
		query.append("    ,NVL(B.CALL_SGN_NO, '')     AS VSL_CALLSIGN" ).append("\n"); 
		query.append("    ,NVL(B.LLOYD_NO, '')        AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("    ,NVL(B.VSL_ENG_NM, '')      AS VSL_FULLNAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.VPS_ETA_DT,'RRMMDD'),' ') AS ETA" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.VPS_ETD_DT,'RRMMDD'),' ') AS ETD" ).append("\n"); 
		query.append("    ,VSL_RGST_CNT_CD AS VSL_FLAG " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    ,(SELECT BKG_GET_CSTMS_EUR_FOPE_CD_FNC(@[vvd_cd]) FROM DUAL) POFE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, MDM_VSL_CNTR B, BKG_VVD BV, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND   A.VSL_CD                   =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO               =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD               =  SUBSTR(@[vvd_cd], 9, 1) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   A.VSL_CD        =  BV.VSL_CD" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO    =  BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD    =  BV.SKD_DIR_CD " ).append("\n"); 
		query.append("AND   NVL(A.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BV.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mode_type} == 'I')" ).append("\n"); 
		query.append("	AND   A.VPS_PORT_CD   =  @[pod_cd]" ).append("\n"); 
		query.append("	AND   A.VPS_PORT_CD   =  BV.POD_CD" ).append("\n"); 
		query.append("	AND   BV.POD_YD_CD    =  @[pod_yd_cd]" ).append("\n"); 
		query.append("	AND   A.CLPT_IND_SEQ  =  BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND   A.VPS_PORT_CD   =  @[pol_cd]" ).append("\n"); 
		query.append("	AND   A.VPS_PORT_CD   =  BV.POL_CD" ).append("\n"); 
		query.append("	AND   BV.POL_YD_CD    =  @[pol_yd_cd]" ).append("\n"); 
		query.append("	AND   A.CLPT_IND_SEQ  =  BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY ETA DESC" ).append("\n"); 

	}
}