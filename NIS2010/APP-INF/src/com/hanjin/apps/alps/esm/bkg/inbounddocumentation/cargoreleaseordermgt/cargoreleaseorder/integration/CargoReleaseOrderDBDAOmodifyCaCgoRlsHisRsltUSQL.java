/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyCaCgoRlsHisRsltUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.08.19 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmodifyCaCgoRlsHisRsltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOmodifyCaCgoRlsHisRsltUSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyCaCgoRlsHisRsltUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyCaCgoRlsHisRsltUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CGO_RLSE_HIS RHIS" ).append("\n"); 
		query.append("   SET RHIS.CUST_EDI_SND_CD     = NULL," ).append("\n"); 
		query.append("       RHIS.MRN_TML_EDI_SND_CD  = CASE WHEN 'CR' = @[edi_knd] THEN 'R'" ).append("\n"); 
		query.append("                                  WHEN 'CA' = @[edi_knd] THEN 'A'" ).append("\n"); 
		query.append("                             END," ).append("\n"); 
		query.append("       RHIS.INLND_YD_EDI_SND_CD = CASE WHEN 'CR' = @[edi_knd] THEN 'R'" ).append("\n"); 
		query.append("                                  WHEN 'CA' = @[edi_knd] THEN 'A'" ).append("\n"); 
		query.append("                             END," ).append("\n"); 
		query.append("       RHIS.UPD_DT              = SYSDATE," ).append("\n"); 
		query.append("	   RHIS.DO_HLD_FLG		    = (" ).append("\n"); 
		query.append("								  	SELECT NVL(A.DO_HLD_FLG,'N') DO_HLD_FLG" ).append("\n"); 
		query.append("									FROM BKG_DO_REF A," ).append("\n"); 
		query.append("						   			     BKG_BOOKING B" ).append("\n"); 
		query.append("									WHERE A.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("									  AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("						 		 )" ).append("\n"); 
		query.append(" WHERE RHIS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND RHIS.HIS_SEQ = @[his_seq]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                 FROM BKG_CGO_RLSE_EDI_SND_LOG RLOG" ).append("\n"); 
		query.append("                WHERE RLOG.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("                  AND RLOG.HIS_SEQ     = @[his_seq]" ).append("\n"); 
		query.append("                  AND RLOG.BL_NO       = RHIS.BL_NO" ).append("\n"); 
		query.append("                  AND RLOG.HIS_SEQ     = RHIS.HIS_SEQ" ).append("\n"); 
		query.append("                  AND RLOG.CGOR_EDI_RCVR_TP_CD = 'L')" ).append("\n"); 

	}
}