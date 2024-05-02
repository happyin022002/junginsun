/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchVslEtcInfoVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchVslEtcInfoVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel 정보, Vessel ETA 정보를 조회한다.
	  * 1. 2011.01.10 이수진 1.[CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : VVD TYPE, VSL SEQ 항목 추가
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchVslEtcInfoVslRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchVslEtcInfoVslRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.VSL_PRE_PST_CD, 'S', 'PRE', 'T', 'TRUNK', 'U', DECODE(A.VSL_SEQ, '0', 'POST', '1', 'FOURTH', '2', 'FIFTH', '3', 'SIXTH', '4', 'SEVENTH', '5', 'EIGHTH')) VVDTYPE" ).append("\n"); 
		query.append("       ,A.SLAN_CD LANE_CD" ).append("\n"); 
		query.append("       ,NVL(A.VSL_CD, '')||NVL(A.SKD_VOY_NO, '')||NVL(A.SKD_DIR_CD, '') BVVD1" ).append("\n"); 
		query.append("	   ,NVL(D.CALL_SGN_NO, '') VSL_CALLSIGN1" ).append("\n"); 
		query.append("	   ,NVL(D.LLOYD_NO, '') VSL_LLOYDCODE1 " ).append("\n"); 
		query.append("	   ,NVL(D.VSL_ENG_NM, '') VSL_FULLNAME1" ).append("\n"); 
		query.append("	   ,NVL(D.VSL_RGST_CNT_CD, '') VSL_RGST_CNT_CD1" ).append("\n"); 
		query.append("	   ,NVL(E.UN_LOC_CD, A.POL_CD) BLPOL1" ).append("\n"); 
		query.append("	   ,E.LOC_NM POL_FULLNAME1" ).append("\n"); 
		query.append("	   ,NVL(F.UN_LOC_CD, A.POD_CD) BLPOD1" ).append("\n"); 
		query.append("	   ,F.LOC_NM POD_FULLNAME1" ).append("\n"); 
		query.append("	   ,NVL(TO_CHAR(B.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') POLETA1" ).append("\n"); 
		query.append("	   ,NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ') POLETD1 " ).append("\n"); 
		query.append("	   ,NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') PODETA1" ).append("\n"); 
		query.append("	   ,NVL(TO_CHAR(C.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ') PODETD1" ).append("\n"); 
		query.append("	   ,'' OP_CODE" ).append("\n"); 
		query.append("  FROM BKG_VVD A" ).append("\n"); 
		query.append("      , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("      , VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("      , MDM_VSL_CNTR D" ).append("\n"); 
		query.append("      , MDM_LOCATION E" ).append("\n"); 
		query.append("      , MDM_LOCATION F" ).append("\n"); 
		query.append(" WHERE A.BKG_NO                     =  @[bkg_no]" ).append("\n"); 
		query.append("   AND A.VSL_CD                     =  B.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO                 =  B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD                 =  B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.POL_CD                     =  B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND B.CLPT_IND_SEQ(+)            =  '1'" ).append("\n"); 
		query.append("   AND A.VSL_CD                     =  C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO                 =  C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD                 =  C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD                     =  C.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND C.CLPT_IND_SEQ(+)            =  '1'" ).append("\n"); 
		query.append("   AND A.VSL_CD                     =  D.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.POL_CD                     =  E.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD                     =  F.LOC_CD(+)" ).append("\n"); 

	}
}