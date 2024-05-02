/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchWoSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.11.02 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchWoSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 SO의 Suchargy를 가지고 온다.
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchWoSurchargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchWoSurchargeRSQL").append("\n"); 
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
		query.append("SELECT	TRSP_SO_OFC_CTY_CD			,	" ).append("\n"); 
		query.append("		TRSP_SO_SEQ				,	" ).append("\n"); 
		query.append("		LGS_COST_CD				,	" ).append("\n"); 
		query.append("	 	SCG_AMT				,	" ).append("\n"); 
		query.append("	 	DRY_RUN_RLBL_PTY_TP_CD			,	" ).append("\n"); 
		query.append("	 	FNE_CUZ_DESC				,	" ).append("\n"); 
		query.append("	 	FUMG_COST_TP_CD			,	" ).append("\n"); 
		query.append("	 	MGST_TPSZ_CD				,	" ).append("\n"); 
		query.append("	 	INSP_RF_PTI_CSTMS_TP_CD		,	" ).append("\n"); 
		query.append("	 	LFTG_KNT				,	" ).append("\n"); 
		query.append("	 	LFTG_CUZ_DESC				,	" ).append("\n"); 
		query.append("	 	STOP_LOC_NOD_CD			,	" ).append("\n"); 
		query.append("	 	GRS_WGT				,	" ).append("\n"); 
		query.append("	 	TO_CHAR(INCRT_DT,'YYYYMMDD') INCRT_DT				,	" ).append("\n"); 
		query.append("	 	SCL_STOP_PLC_NOD_CD			,	" ).append("\n"); 
		query.append("	 	STO_DYS				,	" ).append("\n"); 
		query.append("	 	OB_BKG_NO				,	" ).append("\n"); 
		query.append("	 	WT_HRS					,	" ).append("\n"); 
		query.append("	 	OTR_RMK				,	" ).append("\n"); 
		query.append("	 	N3PTY_BIL_FLG				,	" ).append("\n"); 
		query.append("	 	CUST_CNT_CD				,	" ).append("\n"); 
		query.append("	 	CUST_SEQ				,	" ).append("\n"); 
		query.append("	 	N3PTY_VNDR_SEQ				,	" ).append("\n"); 
		query.append("	 	N3PTY_OFC_CD				,	" ).append("\n"); 
		query.append("	 	N3PTY_AMT				,	" ).append("\n"); 
		query.append("	 	N3PTY_DESC				,	" ).append("\n"); 
		query.append("	 	CRE_OFC_CD				,	" ).append("\n"); 
		query.append("	 	CRE_USR_ID				,	" ).append("\n"); 
		query.append("	 	TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS') CRE_DT," ).append("\n"); 
		query.append("	 	CHSS_NO				," ).append("\n"); 
		query.append("	 	TO_CHAR(INCUR_DT,'YYYYMMDD') INCUR_DT," ).append("\n"); 
		query.append("		TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("		TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("		TRSP_AGMT_RT_TP_SER_NO," ).append("\n"); 
		query.append("		TRSP_AGMT_SCG_NOD_SEQ," ).append("\n"); 
		query.append("		TRSP_AGMT_SCG_RT_SEQ," ).append("\n"); 
		query.append("		COM_SCG_KND_CD," ).append("\n"); 
		query.append("		COM_SCG_SEQ," ).append("\n"); 
		query.append("		SCG_DTL_SEQ," ).append("\n"); 
		query.append("     	CURR_CD," ).append("\n"); 
		query.append("     	ORG_SCG_AMT" ).append("\n"); 
		query.append("  FROM	TRS_TRSP_SCG_DTL			" ).append("\n"); 
		query.append(" WHERE 	TRSP_SO_OFC_CTY_CD		= @[trsp_so_ofc_cty_cd]	" ).append("\n"); 
		query.append("   AND	TRSP_SO_SEQ				= @[trsp_so_seq]		" ).append("\n"); 
		query.append("   AND	NVL(SCG_AMT, 0)			<> 0" ).append("\n"); 
		query.append("   AND	SUBSTR(LGS_COST_CD, 3, 2)<> 'FU'" ).append("\n"); 

	}
}