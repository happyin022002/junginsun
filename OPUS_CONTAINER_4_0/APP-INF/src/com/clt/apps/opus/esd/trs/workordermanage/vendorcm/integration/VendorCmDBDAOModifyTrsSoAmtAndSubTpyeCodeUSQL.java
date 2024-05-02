/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VendorCmDBDAOModifyTrsSoAmtAndSubTpyeCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VendorCmDBDAOModifyTrsSoAmtAndSubTpyeCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VendorCmDBDAOModifyTrsSoAmtAndSubTpyeCodeUSQL
	  * </pre>
	  */
	public VendorCmDBDAOModifyTrsSoAmtAndSubTpyeCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration").append("\n"); 
		query.append("FileName : VendorCmDBDAOModifyTrsSoAmtAndSubTpyeCodeUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   SET SO.BZC_AMT        = NVL((SELECT M.RCV_AMT" ).append("\n"); 
		query.append("                                 FROM TRS_EDI_USA_RCV_MSG M" ).append("\n"); 
		query.append("                                WHERE M.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                  AND M.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                  AND M.RCV_MSG_SEQ = @[rcv_msg_seq]" ).append("\n"); 
		query.append("                                  AND M.LGS_COST_CD = 'TRCOST'" ).append("\n"); 
		query.append("                                  AND M.RCV_MSG = 'Charges')," ).append("\n"); 
		query.append("                               SO.BZC_AMT)" ).append("\n"); 
		query.append("      ,SO.NEGO_AMT       = NVL((SELECT 0" ).append("\n"); 
		query.append("                                 FROM TRS_EDI_USA_RCV_MSG M" ).append("\n"); 
		query.append("                                WHERE M.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                  AND M.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                  AND M.RCV_MSG_SEQ = @[rcv_msg_seq]" ).append("\n"); 
		query.append("                                  AND M.LGS_COST_CD = 'TRCOST'" ).append("\n"); 
		query.append("                                  AND M.RCV_MSG = 'Charges')," ).append("\n"); 
		query.append("                               SO.NEGO_AMT)" ).append("\n"); 
		query.append("      ,SO.FUEL_SCG_AMT   = NVL((SELECT SUM(M.SCG_AMT)" ).append("\n"); 
		query.append("                                 FROM TRS_TRSP_SCG_DTL M" ).append("\n"); 
		query.append("                                WHERE M.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                  AND M.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                  AND SUBSTR(M.LGS_COST_CD, 3, 2) = ('FU'))," ).append("\n"); 
		query.append("                               0)" ).append("\n"); 
		query.append("      ,SO.ETC_ADD_AMT    = NVL((SELECT SUM(M.SCG_AMT)" ).append("\n"); 
		query.append("                                 FROM TRS_TRSP_SCG_DTL M" ).append("\n"); 
		query.append("                                WHERE M.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                  AND M.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                  AND SUBSTR(M.LGS_COST_CD, 3, 2) <> ('FU'))," ).append("\n"); 
		query.append("                               0)" ).append("\n"); 
		query.append("      ,SO.EQ_NO          = NVL((SELECT M.RCV_MSG_DESC" ).append("\n"); 
		query.append("                                 FROM TRS_EDI_USA_RCV_MSG M" ).append("\n"); 
		query.append("                                WHERE M.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                  AND M.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                  AND SO.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                                  AND SO.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("                                  AND M.RCV_MSG_SEQ = @[rcv_msg_seq]" ).append("\n"); 
		query.append("                                  AND M.LGS_COST_CD = 'EQ'" ).append("\n"); 
		query.append("                                  AND M.RCV_MSG = 'Equipment')," ).append("\n"); 
		query.append("                               SO.EQ_NO)" ).append("\n"); 
		query.append("      ,SO.LOCL_UPD_DT    = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SO.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,SO.UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("      ,SO.UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}