/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.12 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG VVD 정보를 조회한다.
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL").append("\n"); 
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
		query.append("SELECT '' BRAC" ).append("\n"); 
		query.append(",NVL(A.VSL_CD, '')||NVL(A.SKD_VOY_NO, '')||NVL(A.SKD_DIR_CD, '') VVD" ).append("\n"); 
		query.append(",NVL(D.CALL_SGN_NO, '') VSL_CALLSIGN" ).append("\n"); 
		query.append(",NVL(D.LLOYD_NO, '') VSL_LLOYDCODE" ).append("\n"); 
		query.append(",NVL(D.VSL_ENG_NM, '') VSL_FULLNAME" ).append("\n"); 
		query.append(",NVL(A.SLAN_CD, '') LANE_CD" ).append("\n"); 
		query.append(",NVL(A.SHP_CALL_NO, '') VVD_REF_NO" ).append("\n"); 
		query.append(",NVL(DECODE(@[pol_cd], NULL, @[pod_cd], @[pol_cd]),'') PORT" ).append("\n"); 
		query.append(",NVL((SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = NVL(@[pol_cd],@[pod_cd])" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("), '') PORTNAME" ).append("\n"); 
		query.append(",NVL(TO_CHAR(DECODE(SUBSTR(@[pol_cd], 1, 2), 'BR', MAX(A.VPS_ETA_DT), MIN(A.VPS_ETA_DT)),'YYYYMMDDHH24MI'), '') ETA" ).append("\n"); 
		query.append(",NVL(TO_CHAR(DECODE(SUBSTR(@[pol_cd], 1, 2), 'BR', MAX(A.VPS_ETD_DT), MIN(A.VPS_ETD_DT)),'YYYYMMDDHH24MI'), '') ETD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', MIN(C.VPS_PORT_CD) ) NEXTPORT" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', MIN(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI')) ) NEXTPORT_ETA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, MIN(B.VPS_PORT_CD), '' ) PREVPORT" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, MIN(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI')), '' ) PREVPORT_ETD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', 'BRZ' ) IO_IND" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', @[comp_id] ) COMP_ID" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', NVL(D.CRR_CD,' ')) MRN" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B, VSK_VSL_PORT_SKD C, MDM_VSL_CNTR D" ).append("\n"); 
		query.append("WHERE A.VSL_CD                   =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO                 =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD                 =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND NVL(A.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD                =  NVL(@[pol_cd], @[pod_cd])" ).append("\n"); 
		query.append("AND B.CLPT_SEQ(+)                <  A.CLPT_SEQ" ).append("\n"); 
		query.append("AND B.VSL_CD(+)                  =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO(+)              =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD(+)              =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD(+), ' ') <> 'S'" ).append("\n"); 
		query.append("AND C.CLPT_SEQ(+)                >  A.CLPT_SEQ" ).append("\n"); 
		query.append("AND C.VSL_CD(+)                  =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO(+)              =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD(+)              =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(C.SKD_CNG_STS_CD(+), ' ') <> 'S'" ).append("\n"); 
		query.append("AND A.VSL_CD                     =  D.VSL_CD" ).append("\n"); 
		query.append("GROUP BY NVL(A.VSL_CD, '')" ).append("\n"); 
		query.append(",NVL(A.SKD_VOY_NO, '')" ).append("\n"); 
		query.append(",NVL(A.SKD_DIR_CD, '')" ).append("\n"); 
		query.append(",NVL(D.CALL_SGN_NO, '')" ).append("\n"); 
		query.append(",NVL(D.LLOYD_NO, '')" ).append("\n"); 
		query.append(",NVL(D.VSL_ENG_NM, '')" ).append("\n"); 
		query.append(",NVL(A.SLAN_CD, '')" ).append("\n"); 
		query.append(",NVL(A.SHP_CALL_NO, '')" ).append("\n"); 
		query.append(",NVL(D.CRR_CD,' ')" ).append("\n"); 

	}
}