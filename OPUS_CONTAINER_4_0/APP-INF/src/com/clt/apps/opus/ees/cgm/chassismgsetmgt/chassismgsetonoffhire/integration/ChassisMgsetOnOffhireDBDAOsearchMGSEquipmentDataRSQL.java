/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentDataRSQL(){
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO," ).append("\n"); 
		query.append("       DECODE(A.ACIAC_DIV_CD, 'A', 'Active', 'In-active') AS ACIAC_DIV_CD," ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("A.CRNT_YD_CD CRNT_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.MFT_DT, 'yyyy-mm-dd') AS MFT_DT," ).append("\n"); 
		query.append("       A.EQ_SPEC_NO," ).append("\n"); 
		query.append("       A.MGST_MCHN_SER_NO," ).append("\n"); 
		query.append("       A.MGST_VLTG_CAPA," ).append("\n"); 
		query.append("       A.MGST_FUEL_CAPA," ).append("\n"); 
		query.append("       A.MGST_RUN_HRS," ).append("\n"); 
		query.append("       TO_CHAR(A.MGST_RUN_HRS_UPD_DT, 'yyyy-mm-dd hh24:mi') AS MGST_RUN_HRS_UPD_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.MGST_WARR_END_DT, 'yyyy-mm-dd') AS MGST_WARR_END_DT," ).append("\n"); 
		query.append("       A.ONH_OFC_CD," ).append("\n"); 
		query.append("       --TO_CHAR(A.ONH_DT, 'yyyy-mm-dd') AS ONH_DT," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT /*+ index(t2 XPKCGM_EQ_STS_HIS )  */" ).append("\n"); 
		query.append("            TO_CHAR(t2.STS_EVNT_DT, 'yyyy-mm-dd') AS ONH_DT" ).append("\n"); 
		query.append("            FROM CGM_EQUIPMENT  t1" ).append("\n"); 
		query.append("            ,  CGM_EQ_STS_HIS t2" ).append("\n"); 
		query.append("        WHERE t1.EQ_KND_CD='G'" ).append("\n"); 
		query.append("            AND t1.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("            AND t1.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS ONH_DT ," ).append("\n"); 
		query.append("       B.AGMT_OFC_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS AGREEMENT_NO," ).append("\n"); 
		query.append("       B.AGMT_REF_NO," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') AS CRE_DT," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') AS UPD_Dt," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.EQ_KND_CD," ).append("\n"); 
		query.append("       B.VNDR_SEQ," ).append("\n"); 
		query.append("       C.CNTR_CHK AS CNTR_CHK," ).append("\n"); 
		query.append("       C.CHS_CHK AS CHS_CHK," ).append("\n"); 
		query.append("	   C.ATCH_CNTR AS ATCH_CNTR," ).append("\n"); 
		query.append("	   C.ATCH_CHS AS ATCH_CHS," ).append("\n"); 
		query.append("       NVL(C.BARE_CHK,'Y') AS BARE_CHK," ).append("\n"); 
		query.append("       A.DMG_FLG AS DAMAGE_CHK" ).append("\n"); 
		query.append("  FROM CGM_EQUIPMENT A, CGM_AGREEMENT B," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC( D XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("            A.EQ_NO" ).append("\n"); 
		query.append(",DECODE(D.DTCH_YD_CD , NULL,   DECODE(D.CNTR_NO,'','N','Y') ,'N') CNTR_CHK" ).append("\n"); 
		query.append(",DECODE(D.DTCH_YD_CD , NULL,   DECODE(D.CHSS_NO,'','N','Y') ,'N') CHS_CHK" ).append("\n"); 
		query.append(",DECODE(D.DTCH_YD_CD , NULL,   D.CNTR_NO ,'') ATCH_CNTR" ).append("\n"); 
		query.append(",DECODE(D.DTCH_YD_CD , NULL,   D.CHSS_NO ,'') ATCH_CHS" ).append("\n"); 
		query.append(",DECODE(D.DTCH_YD_CD , NULL,  'N'  ,'Y') BARE_CHK" ).append("\n"); 
		query.append(",NVL( D.DTCH_YD_CD, D.ATCH_YD_CD) CURR_YD_CD" ).append("\n"); 
		query.append("            FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("            CGM_EQ_ATCH_DTCH_HIS D" ).append("\n"); 
		query.append("            WHERE D.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("            AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("            --AND D.DTCH_DT = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("            AND ROWNUM=1" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append(" WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.EQ_NO = C.EQ_NO(+)" ).append("\n"); 
		query.append("   AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("   /* AND A.AGMT_VER_NO = B.AGMT_VER_NO */" ).append("\n"); 
		query.append("   AND B.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("   AND SUBSTR(A.EQ_NO,1,10) = SUBSTR(@[eq_no],1,10)" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 

	}
}