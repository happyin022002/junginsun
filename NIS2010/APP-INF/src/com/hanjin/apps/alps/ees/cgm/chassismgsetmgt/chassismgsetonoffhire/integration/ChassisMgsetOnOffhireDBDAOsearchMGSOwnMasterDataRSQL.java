/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSOwnMasterDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.15 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSOwnMasterDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSOwnMasterDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_lot_no_tmp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSOwnMasterDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_PFX_CD||A.FM_SER_NO||'-'||A.EQ_PFX_CD||A.TO_SER_NO||' '||(A.TO_SER_NO - A.FM_SER_NO + 1) AS MGSET_RANGE," ).append("\n"); 
		query.append("A.EQ_PFX_CD," ).append("\n"); 
		query.append("A.FM_SER_NO," ).append("\n"); 
		query.append("A.TO_SER_NO," ).append("\n"); 
		query.append("(A.TO_SER_NO - FM_SER_NO + 1) AS UNITS," ).append("\n"); 
		query.append("A.EQ_LOT_NO," ).append("\n"); 
		query.append("A.DE_YRMON," ).append("\n"); 
		query.append("B.EQ_SPEC_NO," ).append("\n"); 
		query.append("B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ AS VNDR_SEQ_EQSPEC," ).append("\n"); 
		query.append("(SELECT D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE B.VNDR_SEQ = D.VNDR_SEQ) AS VNDR_LGL_ENG_NM_EQSPEC," ).append("\n"); 
		query.append("B.MGST_VLTG_CAPA," ).append("\n"); 
		query.append("B.MGST_FUEL_CAPA," ).append("\n"); 
		query.append("B.CHSS_TARE_WGT," ).append("\n"); 
		query.append("B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("C.AGMT_OFC_CTY_CD||C.AGMT_SEQ AS AGREEMENT_NO," ).append("\n"); 
		query.append("C.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("C.AGMT_SEQ," ).append("\n"); 
		query.append("C.AGMT_LSTM_CD," ).append("\n"); 
		query.append("C.AGMT_ISS_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(C.CRE_DT, 'yyyy-MM-dd') AS CRE_DT," ).append("\n"); 
		query.append("A.FINC_VNDR_SEQ AS VNDR_SEQ_AGREE," ).append("\n"); 
		query.append("(SELECT D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE A.FINC_VNDR_SEQ = D.VNDR_SEQ) AS VNDR_LGL_ENG_NM_AGREE" ).append("\n"); 
		query.append("FROM CGM_EQ_LOT A, CGM_EQ_SPEC B, CGM_AGREEMENT C" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.EQ_SPEC_NO = B.EQ_SPEC_NO(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("/* AND A.AGMT_VER_NO = C.AGMT_VER_NO */" ).append("\n"); 
		query.append("AND C.LST_VER_FLG(+) ='Y'" ).append("\n"); 
		query.append("AND A.EQ_LOT_NO = @[eq_lot_no_tmp]" ).append("\n"); 

	}
}