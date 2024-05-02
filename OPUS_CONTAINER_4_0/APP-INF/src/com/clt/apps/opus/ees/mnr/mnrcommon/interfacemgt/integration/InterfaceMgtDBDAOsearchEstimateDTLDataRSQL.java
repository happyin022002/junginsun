/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEstimateDTLDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.03.24 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEstimateDTLDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchEstimateDTLDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEstimateDTLDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEstimateDTLDataRSQL").append("\n"); 
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
		query.append("SELECT B.RPR_RQST_DTL_SEQ LINE_NO," ).append("\n"); 
		query.append("B.EQ_LOC_CD DAM_LOC_CD," ).append("\n"); 
		query.append("B.EQ_CMPO_CD COMPNT_CD," ).append("\n"); 
		query.append("B.EQ_DMG_CD DAM_TP_CD," ).append("\n"); 
		query.append("'' COMPNT_MAT_CD," ).append("\n"); 
		query.append("B.EQ_RPR_CD REPR_METH_CD," ).append("\n"); 
		query.append("B.RPR_QTY QUANTITY," ).append("\n"); 
		query.append("'' MEA_UNIT_SPEC," ).append("\n"); 
		query.append("NVL(B.RPR_SZ_NO, 0) DIM_LEN," ).append("\n"); 
		query.append("0 DIM_WID," ).append("\n"); 
		query.append("B.RPR_LBR_HRS MAN_HOUR," ).append("\n"); 
		query.append("B.RPR_LBR_RT LAB_RATE," ).append("\n"); 
		query.append("B.MTRL_COST_AMT MATRL_COST," ).append("\n"); 
		query.append("'D' RESPON" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR A, MNR_RPR_RQST_DTL B" ).append("\n"); 
		query.append("WHERE A.RQST_EQ_NO = B.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   A.RPR_RQST_SEQ = B.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   A.RPR_RQST_VER_NO = B.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   A.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   A.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 

	}
}