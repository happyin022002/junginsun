/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchEDIStorageInvoiceContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.13 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchEDIStorageInvoiceContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDIStorageInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchEDIStorageInvoiceContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchEDIStorageInvoiceContainerListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("C.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_STY_CD," ).append("\n"); 
		query.append("CASE WHEN C.INV_GATE_IN_TM_MSG IS NOT NULL AND LENGTH(C.INV_GATE_IN_TM_MSG) = 8 THEN C.INV_GATE_IN_TM_MSG||'0000' END INV_GATE_IN_DT," ).append("\n"); 
		query.append("CASE WHEN C.INV_GATE_OUT_TM_MSG IS NOT NULL AND LENGTH(C.INV_GATE_OUT_TM_MSG) = 8 THEN C.INV_GATE_OUT_TM_MSG||'0000' END INV_GATE_OUT_DT," ).append("\n"); 
		query.append("TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,C.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H, TES_EDI_SO_CNTR_LIST C" ).append("\n"); 
		query.append("WHERE H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD IN ('SC','SE')" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = C.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = C.TML_EDI_SO_SEQ" ).append("\n"); 

	}
}