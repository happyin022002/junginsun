/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceManualContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.08
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2011.08.08 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceManualContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDIInvoiceManualContainerList
	  * 
	  * * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceManualContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_so_dtl_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceManualContainerListRSQL").append("\n"); 
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
		query.append("SELECT @[lgs_cost_cd] RVIS_LGS_COST_CD, M.CNTR_NO RVIS_CNTR_NO,D.CNTR_TPSZ_CD RVIS_CNTR_TPSZ_CD --, M.BKG_NO, M.BKG_NO_SPLIT" ).append("\n"); 
		query.append(", CASE WHEN D.CNTR_TPSZ_CD IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END EFF_CNTR_YN" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H, TES_EDI_SO_DTL C, TES_EDI_SO_MNL_CNTR_LIST M, MST_CONTAINER D" ).append("\n"); 
		query.append("WHERE NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = C.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = C.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND C.TML_EDI_SO_OFC_CTY_CD = M.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND C.TML_EDI_SO_SEQ = M.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND C.TML_EDI_SO_DTL_SEQ = M.TML_EDI_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND M.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND M.EDI_SO_DTL_ID = @[edi_so_dtl_id]" ).append("\n"); 
		query.append("AND C.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND C.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 

	}
}