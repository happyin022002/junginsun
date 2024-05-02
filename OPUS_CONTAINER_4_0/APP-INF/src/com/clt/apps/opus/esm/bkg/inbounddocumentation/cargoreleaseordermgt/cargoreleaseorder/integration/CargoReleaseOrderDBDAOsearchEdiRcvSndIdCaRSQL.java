/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.23 
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

public class CargoReleaseOrderDBDAOsearchEdiRcvSndIdCaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiRcvSndIdCaRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCaRSQL").append("\n"); 
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
		query.append("--BKG_EDI_YD 테이블을 BKG_EDI_TRD_PRNR_SUB_LNK, BKG_EDI_SUB_LNK_MSG로 수정" ).append("\n"); 
		query.append("SELECT 'CA' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND B.POD_NOD_CD  = C.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   AND (D.MSG_TP_DESC = '1' OR D.MSG_TP_DESC = '2')" ).append("\n"); 
		query.append("   AND ROWNUM	      = 1" ).append("\n"); 
		query.append("   AND 'CA1'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'CA' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND B.POD_NOD_CD  = C.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   AND D.MSG_TP_DESC = '2'" ).append("\n"); 
		query.append("   AND ROWNUM	= 1" ).append("\n"); 
		query.append("   AND 'CA2'    = @[edi_knd]" ).append("\n"); 

	}
}