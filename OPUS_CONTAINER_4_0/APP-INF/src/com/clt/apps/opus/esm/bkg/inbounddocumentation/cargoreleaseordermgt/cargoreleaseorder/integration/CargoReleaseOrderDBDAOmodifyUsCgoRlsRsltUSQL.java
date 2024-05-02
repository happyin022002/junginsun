/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyUsCgoRlsRsltUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmodifyUsCgoRlsRsltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyUsCgoRlsRsltUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snp_rtn_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyUsCgoRlsRsltUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CGO_RLSE RMST" ).append("\n"); 
		query.append("   SET RMST.MRN_TML_EDI_SND_FLG      = 'Y',       " ).append("\n"); 
		query.append("       RMST.MRN_TML_EDI_SND_CD       = CASE WHEN 'CR1' = @[edi_knd] THEN 'J'" ).append("\n"); 
		query.append("                                       WHEN 'CR2' = @[edi_knd] THEN 'R'" ).append("\n"); 
		query.append("                                       WHEN 'CR3' = @[edi_knd] THEN 'R'" ).append("\n"); 
		query.append("                                       WHEN 'CR4' = @[edi_knd] THEN 'R'" ).append("\n"); 
		query.append("                                       WHEN 'CA1' = @[edi_knd] THEN 'A'" ).append("\n"); 
		query.append("                                       WHEN 'CA2' = @[edi_knd] THEN 'A'" ).append("\n"); 
		query.append("                                       WHEN 'PA1' = @[edi_knd] THEN 'H'" ).append("\n"); 
		query.append("                                       WHEN 'PQ1' = @[edi_knd] THEN 'H'" ).append("\n"); 
		query.append("                                       WHEN 'CT1' = @[edi_knd] THEN 'T'" ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("       RMST.MRN_TML_EDI_LST_SND_DT   = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC')," ).append("\n"); 
		query.append("       RMST.MRN_TML_EDI_LST_SND_GDT  = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'GMT' ), " ).append("\n"); 
		query.append("       RMST.MRN_TML_EDI_RCV_ID       = @[edi_rcv_id]," ).append("\n"); 
		query.append("       RMST.MRN_TML_EDI_LST_MSG_ID   = @[edi_msg_id],      " ).append("\n"); 
		query.append("       RMST.MRN_TML_EDI_LST_SCS_FLG  = DECODE(@[edi_snp_rtn_val],'A','Y','N'),     " ).append("\n"); 
		query.append("       RMST.UPD_DT                   = SYSDATE" ).append("\n"); 
		query.append(" WHERE RMST.BL_NO                    = @[bl_no]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                 FROM BKG_CGO_RLSE_EDI_SND_LOG RLOG" ).append("\n"); 
		query.append("                WHERE RLOG.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("                  AND RLOG.HIS_SEQ     = @[his_seq]" ).append("\n"); 
		query.append("                  AND RLOG.BL_NO       = RMST.BL_NO" ).append("\n"); 
		query.append("                  AND RLOG.CGOR_EDI_RCVR_TP_CD = 'L')" ).append("\n"); 

	}
}