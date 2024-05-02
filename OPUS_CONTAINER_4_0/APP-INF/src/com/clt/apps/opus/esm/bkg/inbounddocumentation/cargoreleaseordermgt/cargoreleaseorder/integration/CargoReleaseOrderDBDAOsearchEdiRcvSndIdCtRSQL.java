/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
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

public class CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL").append("\n"); 
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
		query.append("SELECT 'CT' AS EDI_MSG_ID, C.RCVR_TRD_PRNR_ID AS EDI_RCV_ID, C.SNDR_TRD_PRNR_ID AS EDI_SND_ID" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("       BKG_BOOKING  B," ).append("\n"); 
		query.append("       BKG_EDI_TRD_PRNR_SUB_LNK C," ).append("\n"); 
		query.append("       BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append("--       BKG_EDI_YD   C" ).append("\n"); 
		query.append(" WHERE A.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("   AND B.POD_NOD_CD  = C.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("   AND C.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("   AND (D.MSG_TP_DESC = '1' OR D.MSG_TP_DESC = '2')" ).append("\n"); 
		query.append("   AND ROWNUM	= 1" ).append("\n"); 
		query.append("   AND 'CT1'    = @[edi_knd]" ).append("\n"); 
		query.append("   /* AND NVL(A.MRN_TML_EDI_SND_CD,' ') <> 'T' */" ).append("\n"); 

	}
}