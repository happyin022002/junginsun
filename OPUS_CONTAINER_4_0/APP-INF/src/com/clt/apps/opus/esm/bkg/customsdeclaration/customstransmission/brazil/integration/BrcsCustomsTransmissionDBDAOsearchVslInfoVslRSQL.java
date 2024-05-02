/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchVslInfoVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.19 경종윤
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

public class BrcsCustomsTransmissionDBDAOsearchVslInfoVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel 정보, Vessel ETA 정보를 조회한다.
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchVslInfoVslRSQL(){
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
		query.append("SELECT NVL(A.VSL_CD, '')||NVL(A.SKD_VOY_NO, '')||NVL(A.SKD_DIR_CD, '') BVVD1" ).append("\n"); 
		query.append(",NVL(A.SLAN_CD, '') BVVD_LANE" ).append("\n"); 
		query.append(",NVL(D.CALL_SGN_NO, '') VSL_CALLSIGN1" ).append("\n"); 
		query.append(",NVL(D.LLOYD_NO, '') VSL_LLOYDCODE1" ).append("\n"); 
		query.append(",NVL(D.VSL_ENG_NM, '') VSL_FULLNAME1" ).append("\n"); 
		query.append(",NVL(B.SHP_CALL_NO, '') VVD_REF_NO1" ).append("\n"); 
		query.append(",NVL(E.UN_LOC_CD, A.POL_CD) BLPOL1" ).append("\n"); 
		query.append(",E.LOC_NM POL_FULLNAME1" ).append("\n"); 
		query.append(",NVL(F.UN_LOC_CD, A.POD_CD) BLPOD1" ).append("\n"); 
		query.append(",F.LOC_NM POD_FULLNAME1" ).append("\n"); 
		query.append(",NVL(TO_CHAR(B.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') POLETA1" ).append("\n"); 
		query.append(",NVL(TO_CHAR(B.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') POLETD1" ).append("\n"); 
		query.append(",NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') PODETA1" ).append("\n"); 
		query.append(",NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') PODETD1" ).append("\n"); 
		query.append(",'' OP_CODE" ).append("\n"); 
		query.append("FROM BKG_VVD A" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append(", MDM_VSL_CNTR D" ).append("\n"); 
		query.append(", MDM_LOCATION E" ).append("\n"); 
		query.append(", MDM_LOCATION F" ).append("\n"); 
		query.append("WHERE A.BKG_NO                     =  @[bkg_no]" ).append("\n"); 
		query.append("AND A.VSL_CD                     =  B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO                 =  B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD                 =  B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.POL_CD                    =  B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND B.CLPT_IND_SEQ(+)            =  '1'" ).append("\n"); 
		query.append("AND A.VSL_CD                     =  C.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO                 =  C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD                 =  C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.POD_CD                    =  C.VPS_PORT_CD" ).append("\n"); 
		query.append("AND C.CLPT_IND_SEQ(+)            =  '1'" ).append("\n"); 
		query.append("AND A.VSL_CD                     =  D.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.POL_CD                    =  E.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.POD_CD                    =  F.LOC_CD(+)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchVslInfoVslRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}