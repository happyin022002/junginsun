/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettledOrderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.11 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettledOrderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettledOrderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("territory",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettledOrderListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(STK.STK_GATE_IO_CD, 'O', 'Release', 'I', 'Redelivery', STK.STK_GATE_IO_CD) AS I_TYPE," ).append("\n"); 
		query.append("STK.STK_GATE_IO_CD AS BD," ).append("\n"); 
		query.append("STK.STK_OFC_CD AS I_OFFICE," ).append("\n"); 
		query.append("STK.TRSP_CRR_MOD_CD AS MODE_CD," ).append("\n"); 
		query.append("STK.TRSP_SO_TP_CD AS TYPE_CD," ).append("\n"); 
		query.append("DECODE (STK.TRSP_SO_TP_CD, 'C', 'C/H', 'M', 'M/H', 'R', 'MT REPO', 'S', 'S/T', STK.TRSP_SO_TP_CD) AS TYPE_DISP," ).append("\n"); 
		query.append("STK.STK_YD_CD AS EMPTY_CY," ).append("\n"); 
		query.append("TO_CHAR (STK.STK_JB_DT, 'YYYY-MM-DD') AS PD_DATE," ).append("\n"); 
		query.append("STK.CNTR_TPSZ_CD AS TP," ).append("\n"); 
		query.append("STK.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("DECODE (STK.TRSP_SO_TP_CD, 'C', ORD.TRO_SEQ, 'M', TRO.TRO_SEQ, '') AS TRO_SEQ," ).append("\n"); 
		query.append("STK.BL_NO AS BL_NO," ).append("\n"); 
		query.append("STK.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("STK.MVMT_CNTR_NO AS MVMT_CNTR_NO," ).append("\n"); 
		query.append("NVL (STK.VSL_CD||STK.SKD_VOY_NO||STK.SKD_DIR_CD, '') AS VVD," ).append("\n"); 
		query.append("NVL (STK.POL_CD, '') AS POL," ).append("\n"); 
		query.append("NVL (STK.POD_CD, '') AS POD," ).append("\n"); 
		query.append("DECODE (STK.MVMT_CNTR_NO, NULL, 'Manual', 'Auto') AS DELETED," ).append("\n"); 
		query.append("DECODE (STK.MVMT_CNTR_NO, NULL, TO_CHAR (STK.UPD_DT, 'YYYY-MM-DD HH24:MI'), '') AS DELETED_DT," ).append("\n"); 
		query.append("NVL (ORD.TRSP_WO_OFC_CTY_CD||ORD.TRSP_WO_SEQ, '') WO_NO," ).append("\n"); 
		query.append("TO_CHAR (STK.STK_JB_DT, 'YYYY-MM-DD') AS STK_JB_DT," ).append("\n"); 
		query.append("DECODE (STK.MVMT_CNTR_NO, NULL, STK.UPD_USR_ID, STK.CRE_USR_ID) AS USER_ID," ).append("\n"); 
		query.append("REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (S.CUST_NM, 1, 50), CHR(92)||'R'||CHR(92)||'N', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS SHPR," ).append("\n"); 
		query.append("REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (C.CUST_NM, 1, 50), CHR(92)||'R'||CHR(92)||'N', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS CNEE," ).append("\n"); 
		query.append("REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (SUBSTR (N.CUST_NM, 1, 50), CHR(92)||'R'||CHR(92)||'N', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' ') AS NTFY," ).append("\n"); 
		query.append("BB.CTRT_OFC_CD AS OFFICE," ).append("\n"); 
		query.append("BB.SC_NO AS SC_NO," ).append("\n"); 
		query.append("BB.RFA_NO AS RFA_NO," ).append("\n"); 
		query.append("STK.SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("STK.SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("ORD.INV_NO AS INV_NO" ).append("\n"); 
		query.append("FROM CIM_CNTR_STK STK," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD ORD," ).append("\n"); 
		query.append("BKG_EUR_TRO TRO," ).append("\n"); 
		query.append("CIM_TERRITORY CT," ).append("\n"); 
		query.append("BKG_BOOKING BB," ).append("\n"); 
		query.append("#if (${p_yard2} == '' && ${p_yard1} == '' && ${lcc_cd} != '')" ).append("\n"); 
		query.append("MDM_LOCATION ML," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT MC," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("BKG_CUSTOMER S," ).append("\n"); 
		query.append("BKG_CUSTOMER C," ).append("\n"); 
		query.append("BKG_CUSTOMER N" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND STL_FLG = 'Y'" ).append("\n"); 
		query.append("AND STK.SO_OFC_CTY_CD = ORD.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND STK.SO_SEQ = ORD.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("AND STK.SO_OFC_CTY_CD = TRO.SO_CTY_CD(+)" ).append("\n"); 
		query.append("AND STK.SO_SEQ = TRO.SO_SEQ_NO(+)" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '' && ${wo_no} == '')" ).append("\n"); 
		query.append("#if (${p_date1} != '' && ${p_date2} != '')" ).append("\n"); 
		query.append("AND STK.STK_JB_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CT.CNTR_STK_TERR_CD = @[territory]" ).append("\n"); 
		query.append("AND CT.OFC_CD = @[office]" ).append("\n"); 
		query.append("AND CT.CNT_CD = SUBSTR (STK.STK_YD_CD, 1, 2)" ).append("\n"); 
		query.append("AND STK.STK_GATE_IO_CD = @[type]" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND STK.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND STK.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("#if (${type} == 'I')" ).append("\n"); 
		query.append("AND STK.CNTR_NO LIKE @[cntr_no]||'%'" ).append("\n"); 
		query.append("#elseif (${type} == 'O')" ).append("\n"); 
		query.append("AND STK.MVMT_CNTR_NO LIKE @[cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND STK.STK_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("AND STK.STK_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#elseif (${lcc_cd} != '')" ).append("\n"); 
		query.append("AND MC.LCC_CD LIKE @[lcc_cd]||'%'" ).append("\n"); 
		query.append("AND MC.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("AND ML.LOC_CD = STK.STK_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wo_no} != '')" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no], 1, 3)" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_SEQ = SUBSTR(@[wo_no], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND STK.BKG_NO = BB.BKG_NO(+)" ).append("\n"); 
		query.append("AND STK.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("AND STK.TRSP_SO_TP_CD = TRO.HLG_TP_CD(+)" ).append("\n"); 
		query.append("AND STK.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND STK.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND STK.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 

	}
}